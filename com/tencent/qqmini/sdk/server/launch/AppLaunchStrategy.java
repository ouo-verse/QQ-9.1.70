package com.tencent.qqmini.sdk.server.launch;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.LruCache;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.mini.app.AppBrandContant;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqmini.sdk.core.MiniAppConst;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.MiniProcessorConfig;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.ipc.IPCConst;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.LoginInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniAppBaseInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.RenderInfo;
import com.tencent.qqmini.sdk.launcher.shell.ProcessType;
import com.tencent.qqmini.sdk.server.LaunchManagerService;
import com.tencent.qqmini.sdk.server.MiniServer;
import com.tencent.qqmini.sdk.server.launch.LaunchStrategy;
import com.tencent.qqmini.sdk.utils.DeviceInfoUtil;
import com.tencent.qqmini.sdk.utils.ProcessUtil;
import cooperation.qzone.util.WiFiDash;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes23.dex */
public class AppLaunchStrategy implements LaunchStrategy {
    public static final String KEY_APP_INTENT_APP_ID = "APP_INTENT_APP_ID";
    private static final int KILL_MODE_PID = 0;
    private static final int KILL__MODE_BROADCAST = 1;
    public static final int MINI_APP_CRASH_PROTECT_TIME_DEFAULT = 3600000;
    private static final int MINI_APP_PROCESS_DETECT_TIME_DEFAULT = 600000;
    private static final int MINI_GAME_PROCESS_REUSE_DEFAULT = 1;
    private static final int PROCESS_APP_RECYCLE_TIME = 1800000;
    private static final int PROCESS_GAME_RECYCLE_TIME = 900000;
    private static final int PROCESS_MAX_COUNT_DEFAULT = 6;
    private static final int PROCESS_PRELOAD_COUNT_DEFAULT = 2;
    private static final String TAG = "minisdk-start_LaunchManagerService";
    private static MiniAppSubProcessorInfo sInternalProcessInfo;
    public long appProcessRecycleTime;
    public long gameProcessRecycleTime;
    private MiniAppSubProcessorInfo lastKillingProcessor;
    private final Context mContext;
    private long mLastPreloadDetectTime;
    private int mProcessMaxCount;
    private int mProcessPreloadCount;
    private LruCache<String, MiniAppSubProcessorInfo> mProcessStack;
    private int mStartTimeInterval;
    private long mStartTimestamp;
    private MiniAppBaseInfo mStartingMiniAppConfig;
    public static LinkedHashMap<String, MiniAppSubProcessorInfo> subProcessorInfoMap = new LinkedHashMap<>();
    public static LinkedHashMap<String, MiniAppSubProcessorInfo> subAppProcessorInfoMap = new LinkedHashMap<>();
    private final Map<String, Messenger> mClientMessengerMap = new HashMap();
    protected Handler mHandler = new Handler(Looper.getMainLooper());
    private HashMap<String, Long> startAppIdMap = new HashMap<>();
    private ConcurrentHashMap<String, String> mPreloadingTask = new ConcurrentHashMap<>();
    private int mKillProcessMode = 0;
    private boolean mMiniAppUsed = false;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class MiniAppSubProcessorInfo {
        public final List<MiniAppBaseInfo> allMiniAppInfo;
        public Class<?> appPreLoadClass;
        public MiniAppBaseInfo currentAppInfo;
        private long enterBackgroundTimestamp;
        public Class<?> internalUIClass;
        public boolean isForeground;
        private final Handler mainHandler;
        public int pid;
        public String preloadGameBaseLibVersion;
        public String preloadType;
        public final String processName;
        public Runnable processRecycleRunnable;
        public int supportRuntimeType;
        public Class<?> uiClass;

        public MiniAppSubProcessorInfo(AppLaunchStrategy appLaunchStrategy, String str, ProcessType processType, Class cls, Class cls2, Class cls3, int i3) {
            this(str, cls, cls2, cls3, i3);
        }

        public void clean() {
            this.mainHandler.removeCallbacks(this.processRecycleRunnable);
        }

        public boolean containsAppConfig(MiniAppBaseInfo miniAppBaseInfo) {
            Iterator<MiniAppBaseInfo> it = this.allMiniAppInfo.iterator();
            while (it.hasNext()) {
                if (AppLaunchStrategy.equalAppInfo(it.next(), miniAppBaseInfo)) {
                    return true;
                }
            }
            return false;
        }

        public boolean isIdleProcess() {
            return this.allMiniAppInfo.isEmpty();
        }

        public boolean isInternalAppProcess() {
            if (AppLaunchStrategy.sInternalProcessInfo != null && AppLaunchStrategy.sInternalProcessInfo.processName.equals(this.processName)) {
                return true;
            }
            return false;
        }

        public void onEnterBackground() {
            long j3;
            boolean z16 = false;
            this.isForeground = false;
            if (this.allMiniAppInfo.isEmpty()) {
                return;
            }
            if (WnsConfig.getConfig("qqminiapp", WnsConfig.MINI_APP_SCREEN_DETECT, 1) > 0) {
                z16 = true;
            }
            if (z16 && !DeviceInfoUtil.isScreenOn(AppLaunchStrategy.this.mContext)) {
                QMLog.i(AppLaunchStrategy.TAG, "onAppBackground isScreenOn=false");
                return;
            }
            this.enterBackgroundTimestamp = System.currentTimeMillis();
            this.mainHandler.removeCallbacks(this.processRecycleRunnable);
            Handler handler = this.mainHandler;
            Runnable runnable = this.processRecycleRunnable;
            if (MiniAppConst.PRELOAD_TYPE_GAME.equals(this.preloadType)) {
                j3 = AppLaunchStrategy.this.gameProcessRecycleTime;
            } else {
                j3 = AppLaunchStrategy.this.appProcessRecycleTime;
            }
            handler.postDelayed(runnable, j3);
        }

        public void onEnterForeground() {
            this.isForeground = true;
            this.enterBackgroundTimestamp = 0L;
            this.mainHandler.removeCallbacks(this.processRecycleRunnable);
        }

        public void setAllMiniAppInfo(MiniAppBaseInfo miniAppBaseInfo, List<MiniAppInfo> list) {
            boolean z16;
            if (list == null) {
                return;
            }
            this.allMiniAppInfo.clear();
            if (miniAppBaseInfo != null) {
                Iterator<MiniAppInfo> it = list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (AppLaunchStrategy.equalAppInfo(miniAppBaseInfo, it.next())) {
                            z16 = true;
                            break;
                        }
                    } else {
                        z16 = false;
                        break;
                    }
                }
                if (!z16) {
                    this.allMiniAppInfo.add(miniAppBaseInfo);
                }
            }
            this.allMiniAppInfo.addAll(list);
        }

        public boolean support(boolean z16, int i3) {
            if ((z16 && this.internalUIClass == null) || (this.supportRuntimeType & i3) == 0) {
                return false;
            }
            return true;
        }

        @NonNull
        public String toString() {
            String str = this.processName;
            if (str.contains(":")) {
                str = str.substring(str.indexOf(":"));
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("pName:");
            sb5.append(str);
            sb5.append(" pid:");
            sb5.append(this.pid);
            sb5.append(" reportType=");
            sb5.append(-1);
            sb5.append(" preloadType=");
            sb5.append(this.preloadType);
            sb5.append(" supportRuntimeType=");
            sb5.append(this.supportRuntimeType);
            sb5.append(" currentApp=");
            sb5.append(this.currentAppInfo);
            sb5.append(" allApp=[");
            for (MiniAppBaseInfo miniAppBaseInfo : this.allMiniAppInfo) {
                sb5.append("(appid:");
                sb5.append(miniAppBaseInfo.appId);
                sb5.append(" name:");
                sb5.append(miniAppBaseInfo.name);
                sb5.append("), ");
            }
            sb5.setLength(sb5.length() - 2);
            sb5.append("]");
            return sb5.toString();
        }

        public MiniAppSubProcessorInfo(String str, Class cls, Class cls2, Class cls3, int i3) {
            this.allMiniAppInfo = new CopyOnWriteArrayList();
            this.isForeground = false;
            this.mainHandler = new Handler(Looper.getMainLooper());
            this.processRecycleRunnable = new Runnable() { // from class: com.tencent.qqmini.sdk.server.launch.AppLaunchStrategy.MiniAppSubProcessorInfo.1
                @Override // java.lang.Runnable
                public void run() {
                    if (MiniAppSubProcessorInfo.this.isForeground) {
                        return;
                    }
                    QMLog.i(AppLaunchStrategy.TAG, "recycle process=" + MiniAppSubProcessorInfo.this.processName + " " + MiniAppSubProcessorInfo.this.allMiniAppInfo);
                    MiniAppSubProcessorInfo miniAppSubProcessorInfo = MiniAppSubProcessorInfo.this;
                    AppLaunchStrategy.this.forceKillProcess(miniAppSubProcessorInfo);
                }
            };
            this.enterBackgroundTimestamp = 0L;
            this.processName = str;
            this.uiClass = cls;
            this.internalUIClass = cls2;
            this.appPreLoadClass = cls3;
            this.supportRuntimeType = i3;
        }
    }

    public AppLaunchStrategy(@NotNull Context context, @NotNull List<MiniProcessorConfig> list, @NotNull List<MiniProcessorConfig> list2) {
        this.gameProcessRecycleTime = 900000L;
        this.appProcessRecycleTime = 1800000L;
        this.mProcessPreloadCount = 0;
        this.mProcessMaxCount = 0;
        this.mStartTimeInterval = 1500;
        this.mContext = context;
        Iterator<MiniProcessorConfig> it = list.iterator();
        while (it.hasNext()) {
            initProcessInfo(it.next());
        }
        Iterator<MiniProcessorConfig> it5 = list2.iterator();
        while (it5.hasNext()) {
            initProcessInfo(it5.next());
        }
        this.mProcessPreloadCount = 2;
        this.appProcessRecycleTime = 1800000L;
        this.gameProcessRecycleTime = 900000L;
        this.mStartTimeInterval = 1500;
        this.mProcessMaxCount = list.size() + list2.size();
        this.mProcessStack = new LruCache<>(this.mProcessMaxCount);
    }

    private boolean canPreloadApp(MiniAppSubProcessorInfo miniAppSubProcessorInfo) {
        return true;
    }

    private boolean canPreloadProcess(String str) {
        MiniAppSubProcessorInfo value;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Map<String, MiniAppSubProcessorInfo> snapshot = this.mProcessStack.snapshot();
        MiniAppSubProcessorInfo miniAppSubProcessorInfo = sInternalProcessInfo;
        if (miniAppSubProcessorInfo != null) {
            snapshot.remove(miniAppSubProcessorInfo.processName);
        }
        int i3 = this.mProcessMaxCount;
        int i16 = 0;
        for (Map.Entry<String, MiniAppSubProcessorInfo> entry : snapshot.entrySet()) {
            if (entry != null && (value = entry.getValue()) != null && str.equals(value.preloadType)) {
                i16++;
            }
        }
        if (i16 >= i3) {
            return false;
        }
        return true;
    }

    private void checkAndCleanAllMiniProcess() {
        List<ActivityManager.RunningAppProcessInfo> list;
        boolean z16;
        try {
            ActivityManager activityManager = (ActivityManager) this.mContext.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
            if (activityManager != null) {
                list = SystemMethodProxy.getRunningAppProcesses(activityManager);
            } else {
                list = null;
            }
            if (list != null && list.size() > 0) {
                Iterator<Map.Entry<String, MiniAppSubProcessorInfo>> it = this.mProcessStack.snapshot().entrySet().iterator();
                while (true) {
                    boolean z17 = true;
                    if (!it.hasNext()) {
                        break;
                    }
                    Map.Entry<String, MiniAppSubProcessorInfo> next = it.next();
                    if (next != null) {
                        String key = next.getKey();
                        MiniAppSubProcessorInfo value = next.getValue();
                        if (value != null) {
                            Iterator<ActivityManager.RunningAppProcessInfo> it5 = list.iterator();
                            while (true) {
                                if (it5.hasNext()) {
                                    if (it5.next().pid == value.pid) {
                                        break;
                                    }
                                } else {
                                    z17 = false;
                                    break;
                                }
                            }
                            if (!z17) {
                                QMLog.i(TAG, "Process has been died, clean the record! processName=" + key + " pid=" + value.pid);
                                MiniAppSubProcessorInfo remove = this.mProcessStack.remove(key);
                                if (remove != null) {
                                    remove.clean();
                                }
                            }
                        }
                    }
                }
                Iterator<Map.Entry<String, String>> it6 = this.mPreloadingTask.entrySet().iterator();
                while (it6.hasNext()) {
                    Map.Entry<String, String> next2 = it6.next();
                    if (next2 != null) {
                        String key2 = next2.getKey();
                        Iterator<ActivityManager.RunningAppProcessInfo> it7 = list.iterator();
                        while (true) {
                            if (it7.hasNext()) {
                                if (TextUtils.equals(it7.next().processName, key2)) {
                                    z16 = true;
                                    break;
                                }
                            } else {
                                z16 = false;
                                break;
                            }
                        }
                        if (!z16) {
                            QMLog.i(TAG, "Process has been died, clean the preloading record! processName=" + key2);
                            it6.remove();
                        }
                    }
                }
            }
        } catch (Throwable th5) {
            QMLog.e(TAG, "", th5);
        }
    }

    private void checkPreload() {
        QMLog.i(TAG, "checkPreload MiniAppUsed:" + this.mMiniAppUsed);
        try {
            if (this.mMiniAppUsed) {
                this.mLastPreloadDetectTime = System.currentTimeMillis();
                checkAndCleanAllMiniProcess();
                preloadExtraMiniApp(true);
                preloadExtraMiniApp(false);
            }
        } catch (Throwable th5) {
            QMLog.e(TAG, "", th5);
        }
    }

    @Nullable
    private MiniAppSubProcessorInfo checkProcessForLoadedApp(MiniAppBaseInfo miniAppBaseInfo, Map<String, MiniAppSubProcessorInfo> map) {
        if (miniAppBaseInfo != null) {
            for (Map.Entry<String, MiniAppSubProcessorInfo> entry : map.entrySet()) {
                if (entry != null) {
                    String key = entry.getKey();
                    MiniAppSubProcessorInfo value = entry.getValue();
                    if (value == null) {
                        continue;
                    } else {
                        if (value.containsAppConfig(miniAppBaseInfo)) {
                            QMLog.i(TAG, "obtain loaded processor from stack:" + key);
                            return value;
                        }
                        Iterator<MiniAppBaseInfo> it = value.allMiniAppInfo.iterator();
                        while (it.hasNext()) {
                            if (equalAppInfo(miniAppBaseInfo, it.next())) {
                                QMLog.i(TAG, "obtain loaded processor from stack for cache runtime:" + key);
                                return value;
                            }
                        }
                    }
                }
            }
            return null;
        }
        return null;
    }

    private void cleanProcess(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        MiniAppSubProcessorInfo remove = this.mProcessStack.remove(str);
        if (remove != null) {
            remove.clean();
        }
        MiniAppSubProcessorInfo miniAppSubProcessorInfo = this.lastKillingProcessor;
        if (miniAppSubProcessorInfo != null && str.equals(miniAppSubProcessorInfo.processName)) {
            final MiniAppSubProcessorInfo miniAppSubProcessorInfo2 = this.lastKillingProcessor;
            getHandler().postDelayed(new Runnable() { // from class: com.tencent.qqmini.sdk.server.launch.AppLaunchStrategy.1
                @Override // java.lang.Runnable
                public void run() {
                    MiniAppSubProcessorInfo miniAppSubProcessorInfo3 = miniAppSubProcessorInfo2;
                    if (miniAppSubProcessorInfo3 != null && !miniAppSubProcessorInfo3.allMiniAppInfo.isEmpty()) {
                        AppLaunchStrategy.this.preloadExtraMiniApp(!TextUtils.equals(miniAppSubProcessorInfo2.preloadType, MiniAppConst.PRELOAD_TYPE_GAME));
                    }
                }
            }, 2000L);
            this.lastKillingProcessor = null;
        }
    }

    private MiniAppSubProcessorInfo createProcessorInfo(@NotNull String str, @NotNull MiniAppBaseInfo miniAppBaseInfo, MiniAppSubProcessorInfo miniAppSubProcessorInfo) {
        Class<?> cls;
        Class<?> cls2;
        int i3;
        String str2;
        Class<?> cls3 = null;
        if (miniAppSubProcessorInfo != null) {
            cls = miniAppSubProcessorInfo.uiClass;
        } else {
            cls = null;
        }
        if (miniAppSubProcessorInfo != null) {
            cls2 = miniAppSubProcessorInfo.internalUIClass;
        } else {
            cls2 = null;
        }
        if (miniAppSubProcessorInfo != null) {
            cls3 = miniAppSubProcessorInfo.appPreLoadClass;
        }
        Class<?> cls4 = cls3;
        if (miniAppSubProcessorInfo != null) {
            i3 = miniAppSubProcessorInfo.supportRuntimeType;
        } else {
            i3 = 0;
        }
        MiniAppSubProcessorInfo miniAppSubProcessorInfo2 = new MiniAppSubProcessorInfo(str, cls, cls2, cls4, i3);
        if (miniAppSubProcessorInfo2.preloadType == null && miniAppBaseInfo != null) {
            if (miniAppBaseInfo.isEngineTypeMiniApp()) {
                str2 = MiniAppConst.PRELOAD_TYPE_APP;
            } else {
                str2 = MiniAppConst.PRELOAD_TYPE_GAME;
            }
            miniAppSubProcessorInfo2.preloadType = str2;
        }
        return miniAppSubProcessorInfo2;
    }

    private void doPreLaunchMiniApp(MiniAppInfo miniAppInfo, Bundle bundle) {
        if (miniAppInfo != null && miniAppInfo.isEngineTypeMiniApp()) {
            try {
                QMLog.i(TAG, "PreLaunch mini app. appId:" + miniAppInfo.appId + " appName:" + miniAppInfo.name);
                MiniAppSubProcessorInfo obtainPreLaunchProcessor = obtainPreLaunchProcessor(miniAppInfo);
                if (obtainPreLaunchProcessor == null) {
                    QMLog.e(TAG, "obtain processor config failed!");
                    return;
                }
                QMLog.i(TAG, "PreLaunch mini app in process:" + obtainPreLaunchProcessor.processName + " appId:" + miniAppInfo.appId + " appName:" + miniAppInfo.name);
                Intent intent = new Intent();
                intent.setClass(this.mContext, obtainPreLaunchProcessor.appPreLoadClass);
                intent.setAction(MiniSDKConst.ACTION_PRELAUNCH_APP);
                intent.putExtra(AppBrandContant.LAUNCH_SDK_MODE, true);
                if (bundle != null) {
                    intent.putExtras(bundle);
                }
                MiniAppProxy miniAppProxy = (MiniAppProxy) ProxyManager.get(MiniAppProxy.class);
                intent.putExtra(IPCConst.KEY_LOGININFO, new LoginInfo(miniAppProxy.getLoginType(), miniAppProxy.getAccount(), miniAppProxy.getNickName(), miniAppProxy.getPayOpenId(), miniAppProxy.getPayOpenKey(), miniAppProxy.getPayAccessToken(), miniAppProxy.getLoginSig(), miniAppProxy.getPlatformId(), miniAppProxy.getAppId()));
                intent.putExtra(IPCConst.KEY_MINI_SERVICE_MANAGER, MiniServer.g().getMiniServiceFetcher());
                this.mContext.sendBroadcast(intent);
            } catch (Throwable th5) {
                QMLog.e(TAG, "send preload Broadcast exception!", th5);
            }
        }
    }

    private void doPreloadApp(MiniAppSubProcessorInfo miniAppSubProcessorInfo, boolean z16, boolean z17, boolean z18, Bundle bundle) {
        String str;
        Intent intent;
        int loginType;
        String account;
        String nickName;
        String payOpenId;
        String payOpenKey;
        String payAccessToken;
        byte[] loginSig;
        String platformId;
        String appId;
        if (miniAppSubProcessorInfo != null) {
            if (z17 || canPreloadApp(miniAppSubProcessorInfo)) {
                try {
                    QMLog.i(TAG, "do preload mini process name=" + miniAppSubProcessorInfo.processName + " Preload=" + miniAppSubProcessorInfo.appPreLoadClass.getSimpleName() + " isMiniApp:" + z16);
                    intent = new Intent();
                    intent.setClass(this.mContext, miniAppSubProcessorInfo.appPreLoadClass);
                    intent.setAction(z16 ? MiniSDKConst.ACTION_PRELOAD_APP : MiniSDKConst.ACTION_PRELOAD_GAME);
                    intent.putExtra(AppBrandContant.LAUNCH_SDK_MODE, true);
                    if (bundle != null) {
                        intent.putExtras(bundle);
                    }
                    MiniAppProxy miniAppProxy = (MiniAppProxy) ProxyManager.get(MiniAppProxy.class);
                    loginType = miniAppProxy.getLoginType();
                    account = miniAppProxy.getAccount();
                    nickName = miniAppProxy.getNickName();
                    payOpenId = miniAppProxy.getPayOpenId();
                    payOpenKey = miniAppProxy.getPayOpenKey();
                    payAccessToken = miniAppProxy.getPayAccessToken();
                    loginSig = miniAppProxy.getLoginSig();
                    platformId = miniAppProxy.getPlatformId();
                    appId = miniAppProxy.getAppId();
                    str = TAG;
                } catch (Throwable th5) {
                    th = th5;
                    str = TAG;
                }
                try {
                    intent.putExtra(IPCConst.KEY_LOGININFO, new LoginInfo(loginType, account, nickName, payOpenId, payOpenKey, payAccessToken, loginSig, platformId, appId));
                    intent.putExtra(IPCConst.KEY_MINI_SERVICE_MANAGER, MiniServer.g().getMiniServiceFetcher());
                    this.mPreloadingTask.put(miniAppSubProcessorInfo.processName, z16 ? MiniAppConst.PRELOAD_TYPE_APP : MiniAppConst.PRELOAD_TYPE_GAME);
                    this.mContext.sendBroadcast(intent);
                } catch (Throwable th6) {
                    th = th6;
                    QMLog.e(str, "send preload Broadcast exception!", th);
                }
            }
        }
    }

    private void doPreloadExtraMiniApp(final MiniAppBaseInfo miniAppBaseInfo) {
        if (miniAppBaseInfo != null && !miniAppBaseInfo.isEngineTypeMiniGame()) {
            getHandler().postDelayed(new Runnable() { // from class: com.tencent.qqmini.sdk.server.launch.AppLaunchStrategy.2
                @Override // java.lang.Runnable
                public void run() {
                    AppLaunchStrategy.this.preloadExtraMiniApp(!miniAppBaseInfo.isEngineTypeMiniGame());
                }
            }, 1000L);
        }
    }

    public static boolean equalAppInfo(MiniAppBaseInfo miniAppBaseInfo, MiniAppBaseInfo miniAppBaseInfo2) {
        if (miniAppBaseInfo == null || miniAppBaseInfo2 == null || miniAppBaseInfo.getEngineType() != miniAppBaseInfo2.getEngineType()) {
            return false;
        }
        if (!TextUtils.isEmpty(miniAppBaseInfo.appId) && TextUtils.equals(miniAppBaseInfo.appId, miniAppBaseInfo2.appId)) {
            return true;
        }
        if (TextUtils.isEmpty(miniAppBaseInfo.link) || !TextUtils.equals(miniAppBaseInfo.link, miniAppBaseInfo2.link)) {
            return false;
        }
        return true;
    }

    private MiniAppSubProcessorInfo findCacheMiniProcessInfo(MiniAppBaseInfo miniAppBaseInfo) {
        if (miniAppBaseInfo == null) {
            return null;
        }
        for (Map.Entry<String, MiniAppSubProcessorInfo> entry : this.mProcessStack.snapshot().entrySet()) {
            if (entry != null) {
                entry.getKey();
                MiniAppSubProcessorInfo value = entry.getValue();
                if (value == null) {
                    continue;
                } else {
                    if (value.containsAppConfig(miniAppBaseInfo)) {
                        return value;
                    }
                    Iterator<MiniAppBaseInfo> it = value.allMiniAppInfo.iterator();
                    while (it.hasNext()) {
                        if (equalAppInfo(miniAppBaseInfo, it.next())) {
                            return value;
                        }
                    }
                }
            }
        }
        return null;
    }

    @Nullable
    private MiniAppSubProcessorInfo findExitingIdelProcess(Map<String, MiniAppSubProcessorInfo> map, boolean z16, boolean z17) {
        for (Map.Entry<String, MiniAppSubProcessorInfo> entry : map.entrySet()) {
            if (entry != null) {
                String key = entry.getKey();
                MiniAppSubProcessorInfo value = entry.getValue();
                if (value != null && value.currentAppInfo == null && MiniAppConst.PRELOAD_TYPE_APP.equals(value.preloadType) && (!z16 || value.internalUIClass != null)) {
                    if (!z17 || (value.supportRuntimeType & 2) > 0) {
                        QMLog.i(TAG, "obtain idle processor from stack:" + key);
                        return value;
                    }
                }
            }
        }
        return null;
    }

    private boolean findExitingProcessForPreLaunch(MiniAppBaseInfo miniAppBaseInfo) {
        if (findCacheMiniProcessInfo(miniAppBaseInfo) != null) {
            QMLog.i(TAG, "The app has loaded, no need to PreLaunch again.");
            return true;
        }
        return false;
    }

    @Nullable
    private MiniAppSubProcessorInfo findFirstSupportedProcessForPreLaunch(boolean z16, int i3) {
        Iterator<Map.Entry<String, MiniAppSubProcessorInfo>> it = subAppProcessorInfoMap.entrySet().iterator();
        while (it.hasNext()) {
            MiniAppSubProcessorInfo value = it.next().getValue();
            if (value != null && value.support(z16, i3)) {
                QMLog.i(TAG, "obtain PreLaunch processor from config list: " + value.processName);
                return value;
            }
        }
        return null;
    }

    @Nullable
    private MiniAppSubProcessorInfo findIdelProcessForPreLaunch(Map<String, MiniAppSubProcessorInfo> map, boolean z16, int i3) {
        for (Map.Entry<String, MiniAppSubProcessorInfo> entry : map.entrySet()) {
            if (entry != null) {
                String key = entry.getKey();
                MiniAppSubProcessorInfo value = entry.getValue();
                if (value != null && value.currentAppInfo == null && MiniAppConst.PRELOAD_TYPE_APP.equals(value.preloadType) && value.support(z16, i3)) {
                    QMLog.i(TAG, "obtain PreLaunch processor from stack:" + key);
                    return value;
                }
            }
        }
        return null;
    }

    @Nullable
    private MiniAppSubProcessorInfo findInternalAppProcessForPrelaunch(boolean z16, int i3) {
        for (Map.Entry<String, MiniAppSubProcessorInfo> entry : subAppProcessorInfoMap.entrySet()) {
            entry.getKey();
            MiniAppSubProcessorInfo value = entry.getValue();
            if (value != null && value.support(z16, i3)) {
                QMLog.i(TAG, "obtain PreLaunch processor support internal mode " + value.processName);
                return value;
            }
        }
        return null;
    }

    private MiniAppSubProcessorInfo findMiniAppProcessInfo(MiniAppInfo miniAppInfo) {
        if (miniAppInfo == null) {
            return null;
        }
        for (Map.Entry<String, MiniAppSubProcessorInfo> entry : this.mProcessStack.snapshot().entrySet()) {
            if (entry != null) {
                entry.getKey();
                MiniAppSubProcessorInfo value = entry.getValue();
                if (value != null && value.containsAppConfig(miniAppInfo)) {
                    return value;
                }
            }
        }
        return null;
    }

    @Nullable
    private MiniAppSubProcessorInfo findProcessForInternalApp() {
        for (Map.Entry<String, MiniAppSubProcessorInfo> entry : subAppProcessorInfoMap.entrySet()) {
            entry.getKey();
            MiniAppSubProcessorInfo value = entry.getValue();
            if (value != null && value.internalUIClass != null) {
                QMLog.i(TAG, "obtain processor support internal mode " + value.processName);
                return value;
            }
        }
        return null;
    }

    private boolean finishAndRemoveTask(MiniAppSubProcessorInfo miniAppSubProcessorInfo, boolean z16) {
        List<ActivityManager.AppTask> appTasks;
        MiniAppBaseInfo miniAppBaseInfo;
        Intent intent;
        Intent intent2;
        Intent intent3;
        Class<?> cls;
        Intent intent4;
        try {
            ActivityManager activityManager = (ActivityManager) this.mContext.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
            if (activityManager == null || (appTasks = activityManager.getAppTasks()) == null) {
                return false;
            }
            if (miniAppSubProcessorInfo == null) {
                QMLog.e("miniapp", "\u5f53\u524d\u8fdb\u7a0b\u4fe1\u606f\u4e3a\u7a7a");
                return false;
            }
            if (!z16 && !miniAppSubProcessorInfo.allMiniAppInfo.isEmpty()) {
                List<MiniAppBaseInfo> list = miniAppSubProcessorInfo.allMiniAppInfo;
                miniAppBaseInfo = list.get(list.size() - 1);
            } else {
                miniAppBaseInfo = null;
            }
            Iterator<ActivityManager.AppTask> it = appTasks.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ActivityManager.AppTask next = it.next();
                if (next != null && next.getTaskInfo() != null) {
                    intent = next.getTaskInfo().baseIntent;
                    if (intent != null) {
                        intent2 = next.getTaskInfo().baseIntent;
                        if (intent2.getComponent() == null) {
                            continue;
                        } else if (z16) {
                            intent3 = next.getTaskInfo().baseIntent;
                            String className = intent3.getComponent().getClassName();
                            if (!TextUtils.isEmpty(className) && (cls = miniAppSubProcessorInfo.uiClass) != null && className.equals(cls.getName())) {
                                QMLog.i(TAG, "finishAndRemoveTask finish and remove task: id=" + next.getTaskInfo().id + " ui:" + miniAppSubProcessorInfo.uiClass);
                            }
                        } else {
                            intent4 = next.getTaskInfo().baseIntent;
                            String stringExtra = intent4.getStringExtra(KEY_APP_INTENT_APP_ID);
                            if (miniAppBaseInfo != null && TextUtils.equals(stringExtra, miniAppBaseInfo.appId)) {
                                QMLog.i(TAG, "finishAndRemoveTask finish and remove task: id=" + next.getTaskInfo().id + " app:" + miniAppBaseInfo.name);
                                next.finishAndRemoveTask();
                                break;
                            }
                        }
                    } else {
                        continue;
                    }
                }
            }
            return true;
        } catch (Throwable unused) {
            QMLog.e("miniapp", "finishAndRemoveAllTasks exception.");
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void forceKillProcess(MiniAppSubProcessorInfo miniAppSubProcessorInfo) {
        if (miniAppSubProcessorInfo == null) {
            return;
        }
        this.lastKillingProcessor = miniAppSubProcessorInfo;
        QMLog.i(TAG, "kill mini process: " + this.lastKillingProcessor);
        int i3 = miniAppSubProcessorInfo.pid;
        if (i3 > 0) {
            try {
                if (this.mKillProcessMode == 0) {
                    QMLog.w(TAG, "kill process by pid:" + i3);
                    finishAndRemoveTask(miniAppSubProcessorInfo, true);
                    SystemMethodProxy.killProcess(i3);
                    cleanProcess(miniAppSubProcessorInfo.processName);
                    printProcessStack();
                }
            } catch (Throwable th5) {
                QMLog.e(TAG, "kill process exception!", th5);
                return;
            }
        }
        QMLog.w(TAG, "kill process by broadcast" + miniAppSubProcessorInfo.processName);
        Intent intent = new Intent();
        intent.setClass(this.mContext, miniAppSubProcessorInfo.appPreLoadClass);
        this.mContext.sendBroadcast(intent);
    }

    private String getAppName(@NotNull MiniAppBaseInfo miniAppBaseInfo) {
        if (miniAppBaseInfo != null) {
            return miniAppBaseInfo.name;
        }
        return null;
    }

    private String getAppid(@NotNull MiniAppBaseInfo miniAppBaseInfo) {
        if (miniAppBaseInfo != null) {
            return miniAppBaseInfo.appId;
        }
        return null;
    }

    private int getEngineType(@NotNull MiniAppBaseInfo miniAppBaseInfo) {
        if (miniAppBaseInfo != null) {
            return miniAppBaseInfo.getEngineType();
        }
        return -1;
    }

    @Nullable
    private MiniAppSubProcessorInfo getLowestPriorityProcess() {
        MiniAppSubProcessorInfo value;
        Map<String, MiniAppSubProcessorInfo> snapshot = this.mProcessStack.snapshot();
        MiniAppSubProcessorInfo miniAppSubProcessorInfo = sInternalProcessInfo;
        if (miniAppSubProcessorInfo != null) {
            snapshot.remove(miniAppSubProcessorInfo.processName);
        }
        Iterator<Map.Entry<String, MiniAppSubProcessorInfo>> it = snapshot.entrySet().iterator();
        Map.Entry<String, MiniAppSubProcessorInfo> entry = null;
        while (it.hasNext() && ((entry = it.next()) == null || (value = entry.getValue()) == null || value.currentAppInfo == null || (value.supportRuntimeType & 3) == 0)) {
        }
        if (entry != null) {
            String key = entry.getKey();
            MiniAppSubProcessorInfo value2 = entry.getValue();
            if (value2 != null) {
                QMLog.i(TAG, "obtain idle processor from stack bottom:" + key);
                return value2;
            }
        }
        return null;
    }

    @Nullable
    private MiniAppSubProcessorInfo getLowestProcessForPreLaunch() {
        MiniAppSubProcessorInfo value;
        Iterator<Map.Entry<String, MiniAppSubProcessorInfo>> it = this.mProcessStack.snapshot().entrySet().iterator();
        Map.Entry<String, MiniAppSubProcessorInfo> entry = null;
        while (it.hasNext() && ((entry = it.next()) == null || (value = entry.getValue()) == null || value.currentAppInfo == null || !TextUtils.equals(value.preloadType, MiniAppConst.PRELOAD_TYPE_APP))) {
        }
        if (entry != null) {
            String key = entry.getKey();
            MiniAppSubProcessorInfo value2 = entry.getValue();
            if (value2 != null) {
                QMLog.i(TAG, "obtain PreLaunch idle processor from stack bottom:" + key);
                return value2;
            }
        }
        return null;
    }

    private MiniAppSubProcessorInfo getMiniAppSubProcessorInfo(@NotNull String str, @NotNull MiniAppBaseInfo miniAppBaseInfo, @NotNull Bundle bundle) {
        Class<?> cls;
        Class<?> cls2;
        Class<?> cls3;
        int i3;
        String str2;
        MiniAppSubProcessorInfo miniAppSubProcessorInfo = this.mProcessStack.get(str);
        if (miniAppSubProcessorInfo == null) {
            MiniAppSubProcessorInfo miniAppSubProcessorInfo2 = subProcessorInfoMap.get(str);
            String str3 = null;
            if (miniAppSubProcessorInfo2 != null) {
                cls = miniAppSubProcessorInfo2.uiClass;
            } else {
                cls = null;
            }
            if (miniAppSubProcessorInfo2 != null) {
                cls2 = miniAppSubProcessorInfo2.internalUIClass;
            } else {
                cls2 = null;
            }
            if (miniAppSubProcessorInfo2 != null) {
                cls3 = miniAppSubProcessorInfo2.appPreLoadClass;
            } else {
                cls3 = null;
            }
            if (miniAppSubProcessorInfo2 != null) {
                i3 = miniAppSubProcessorInfo2.supportRuntimeType;
            } else {
                i3 = 0;
            }
            MiniAppSubProcessorInfo miniAppSubProcessorInfo3 = new MiniAppSubProcessorInfo(str, cls, cls2, cls3, i3);
            if (bundle != null) {
                str3 = bundle.getString(MiniAppConst.MINI_KEY_PRELOAD_TYPE, null);
            }
            miniAppSubProcessorInfo3.preloadType = str3;
            if (str3 == null && miniAppBaseInfo != null) {
                if (miniAppBaseInfo.isEngineTypeMiniApp()) {
                    str2 = MiniAppConst.PRELOAD_TYPE_APP;
                } else {
                    str2 = MiniAppConst.PRELOAD_TYPE_GAME;
                }
                miniAppSubProcessorInfo3.preloadType = str2;
            }
            this.mProcessStack.put(str, miniAppSubProcessorInfo3);
            return miniAppSubProcessorInfo3;
        }
        return miniAppSubProcessorInfo;
    }

    private int getPid(@NotNull Bundle bundle) {
        if (bundle != null) {
            return bundle.getInt("PID");
        }
        return 0;
    }

    private ProcessState getProcessState(MiniAppSubProcessorInfo miniAppSubProcessorInfo) {
        ProcessState processState = ProcessState.EMPTY;
        if (miniAppSubProcessorInfo.pid > 0 && miniAppSubProcessorInfo.allMiniAppInfo.isEmpty()) {
            return ProcessState.PRELOADED;
        }
        if (miniAppSubProcessorInfo.pid > 0) {
            return ProcessState.REUSE;
        }
        return processState;
    }

    private boolean hasPreloadProcess(String str) {
        MiniAppSubProcessorInfo value;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Map<String, MiniAppSubProcessorInfo> snapshot = this.mProcessStack.snapshot();
        MiniAppSubProcessorInfo miniAppSubProcessorInfo = sInternalProcessInfo;
        if (miniAppSubProcessorInfo != null) {
            snapshot.remove(miniAppSubProcessorInfo.processName);
        }
        for (Map.Entry<String, MiniAppSubProcessorInfo> entry : snapshot.entrySet()) {
            if (entry != null && (value = entry.getValue()) != null && value.allMiniAppInfo.isEmpty() && str.equals(value.preloadType)) {
                return true;
            }
        }
        for (Map.Entry<String, String> entry2 : this.mPreloadingTask.entrySet()) {
            if (entry2 != null && str.equals(entry2.getValue())) {
                return true;
            }
        }
        return false;
    }

    private boolean hasPreloadingTask(String str) {
        if (str == null) {
            if (this.mPreloadingTask.size() > 0) {
                return true;
            }
            return false;
        }
        return this.mPreloadingTask.containsValue(str);
    }

    private void initProcessInfo(MiniProcessorConfig miniProcessorConfig) {
        MiniAppSubProcessorInfo miniAppSubProcessorInfo = new MiniAppSubProcessorInfo(this, miniProcessorConfig.processName, miniProcessorConfig.processType, miniProcessorConfig.appUIClass, miniProcessorConfig.internalUIClass, miniProcessorConfig.appPreLoadClass, miniProcessorConfig.supportRuntimeType);
        subProcessorInfoMap.put(miniAppSubProcessorInfo.processName, miniAppSubProcessorInfo);
        ProcessType processType = miniProcessorConfig.processType;
        if (processType == ProcessType.MINI_APP) {
            subAppProcessorInfoMap.put(miniAppSubProcessorInfo.processName, miniAppSubProcessorInfo);
        } else {
            if (processType == ProcessType.MINI_INTERNAL) {
                subAppProcessorInfoMap.put(miniAppSubProcessorInfo.processName, miniAppSubProcessorInfo);
                sInternalProcessInfo = miniAppSubProcessorInfo;
                return;
            }
            throw new IllegalArgumentException();
        }
    }

    private boolean isProcessAlive(String str) {
        try {
            for (Map.Entry<String, MiniAppSubProcessorInfo> entry : this.mProcessStack.snapshot().entrySet()) {
                if (entry != null) {
                    String key = entry.getKey();
                    MiniAppSubProcessorInfo value = entry.getValue();
                    if (str.equals(key) && value != null) {
                        return isProcessAlive(value.pid);
                    }
                }
            }
            return false;
        } catch (Throwable th5) {
            QMLog.e(TAG, "", th5);
            return false;
        }
    }

    private boolean needPreloadMiniApp(String str) {
        MiniAppSubProcessorInfo value;
        checkAndCleanAllMiniProcess();
        for (Map.Entry<String, MiniAppSubProcessorInfo> entry : this.mProcessStack.snapshot().entrySet()) {
            if (entry != null && (value = entry.getValue()) != null && value.isIdleProcess() && str != null && str.equals(value.preloadType)) {
                QMLog.d(TAG, "No need to preload mini process. " + str + ". Already has idle process " + value);
                return false;
            }
        }
        if (hasPreloadingTask(str)) {
            QMLog.d(TAG, "No need to preload mini process " + str + ". Already has preloading task " + this.mPreloadingTask);
            return false;
        }
        return true;
    }

    private MiniAppSubProcessorInfo obtainAppProcessorForPreLaunch(MiniAppBaseInfo miniAppBaseInfo) {
        boolean z16;
        Map<String, MiniAppSubProcessorInfo> snapshot = this.mProcessStack.snapshot();
        boolean isInternalApp = miniAppBaseInfo.isInternalApp();
        RenderInfo renderInfo = miniAppBaseInfo.renderInfo;
        int i3 = 1;
        if (renderInfo != null && renderInfo.renderMode == 1 && renderInfo.renderMaterialMap.get(1) != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            i3 = 2;
        }
        if (findExitingProcessForPreLaunch(miniAppBaseInfo)) {
            return null;
        }
        MiniAppSubProcessorInfo findIdelProcessForPreLaunch = findIdelProcessForPreLaunch(snapshot, isInternalApp, i3);
        if (findIdelProcessForPreLaunch != null) {
            return findIdelProcessForPreLaunch;
        }
        if (isInternalApp) {
            return findInternalAppProcessForPrelaunch(isInternalApp, i3);
        }
        MiniAppSubProcessorInfo startNewProcessForPreLaunch = startNewProcessForPreLaunch(snapshot, isInternalApp, i3);
        if (startNewProcessForPreLaunch != null) {
            return startNewProcessForPreLaunch;
        }
        MiniAppSubProcessorInfo findFirstSupportedProcessForPreLaunch = findFirstSupportedProcessForPreLaunch(isInternalApp, i3);
        if (findFirstSupportedProcessForPreLaunch != null) {
            return findFirstSupportedProcessForPreLaunch;
        }
        return getLowestProcessForPreLaunch();
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x001d, code lost:
    
        if (r2.renderMaterialMap.get(1) != null) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private MiniAppSubProcessorInfo obtainIdleMiniAppProcessor(MiniAppBaseInfo miniAppBaseInfo) {
        boolean z16;
        Map<String, MiniAppSubProcessorInfo> snapshot = this.mProcessStack.snapshot();
        boolean isInternalApp = miniAppBaseInfo.isInternalApp();
        RenderInfo renderInfo = miniAppBaseInfo.renderInfo;
        if (renderInfo != null) {
            z16 = true;
            if (renderInfo.renderMode == 1) {
            }
        }
        z16 = false;
        MiniAppSubProcessorInfo miniAppSubProcessorInfo = sInternalProcessInfo;
        if (miniAppSubProcessorInfo != null) {
            snapshot.remove(miniAppSubProcessorInfo.processName);
        }
        MiniAppSubProcessorInfo checkProcessForLoadedApp = checkProcessForLoadedApp(miniAppBaseInfo, snapshot);
        if (checkProcessForLoadedApp != null) {
            return checkProcessForLoadedApp;
        }
        MiniAppSubProcessorInfo findExitingIdelProcess = findExitingIdelProcess(snapshot, isInternalApp, z16);
        if (findExitingIdelProcess != null) {
            return findExitingIdelProcess;
        }
        if (isInternalApp) {
            return findProcessForInternalApp();
        }
        MiniAppSubProcessorInfo tryStartNewProcess = tryStartNewProcess(snapshot);
        if (tryStartNewProcess != null) {
            return tryStartNewProcess;
        }
        return getLowestPriorityProcess();
    }

    private MiniAppSubProcessorInfo obtainIdleProcessor(MiniAppBaseInfo miniAppBaseInfo) {
        MiniAppSubProcessorInfo miniAppSubProcessorInfo;
        if (miniAppBaseInfo == null) {
            return null;
        }
        if (miniAppBaseInfo.isInternalApp() && (miniAppSubProcessorInfo = sInternalProcessInfo) != null) {
            return miniAppSubProcessorInfo;
        }
        return obtainIdleMiniAppProcessor(miniAppBaseInfo);
    }

    private MiniAppSubProcessorInfo obtainPreLaunchProcessor(MiniAppBaseInfo miniAppBaseInfo) {
        if (miniAppBaseInfo == null || miniAppBaseInfo.isEngineTypeMiniGame()) {
            return null;
        }
        return obtainAppProcessorForPreLaunch(miniAppBaseInfo);
    }

    private void printProcessStack() {
        StringBuilder sb5 = new StringBuilder(500);
        Map<String, MiniAppSubProcessorInfo> snapshot = this.mProcessStack.snapshot();
        int size = this.mProcessStack.size();
        for (Map.Entry<String, MiniAppSubProcessorInfo> entry : snapshot.entrySet()) {
            sb5.append("{");
            sb5.append(entry.getKey());
            sb5.append(" ");
            sb5.append(entry.getValue());
            sb5.append("}\n");
        }
        QMLog.w(TAG, "current process count=" + size + " " + sb5.toString());
    }

    private void setIntentFlags(Intent intent, MiniAppInfo miniAppInfo) {
        intent.addFlags(805306368);
    }

    @Nullable
    private MiniAppSubProcessorInfo startNewProcessForPreLaunch(Map<String, MiniAppSubProcessorInfo> map, boolean z16, int i3) {
        if (this.mProcessStack.size() < this.mProcessMaxCount) {
            for (Map.Entry<String, MiniAppSubProcessorInfo> entry : subAppProcessorInfoMap.entrySet()) {
                String key = entry.getKey();
                MiniAppSubProcessorInfo value = entry.getValue();
                if (!map.containsKey(key) && value != null && value.support(z16, i3)) {
                    QMLog.i(TAG, "obtain idle processor from create:" + key);
                    return value;
                }
            }
            return null;
        }
        return null;
    }

    @Nullable
    private MiniAppSubProcessorInfo tryStartNewProcess(Map<String, MiniAppSubProcessorInfo> map) {
        if (this.mProcessStack.size() < this.mProcessMaxCount) {
            for (Map.Entry<String, MiniAppSubProcessorInfo> entry : subAppProcessorInfoMap.entrySet()) {
                String key = entry.getKey();
                MiniAppSubProcessorInfo value = entry.getValue();
                if (!map.containsKey(key) && value != null) {
                    QMLog.i(TAG, "obtain idle processor from create:" + key);
                    return value;
                }
            }
            return null;
        }
        return null;
    }

    private void updateAllMiniAppInfoForProcess(@Nullable MiniAppBaseInfo miniAppBaseInfo, @NonNull Bundle bundle, @NonNull MiniAppSubProcessorInfo miniAppSubProcessorInfo) {
        bundle.setClassLoader(MiniAppInfo.class.getClassLoader());
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(IPCConst.KEY_BUNDLE_RUNTIME_LIST);
        if (miniAppBaseInfo != null) {
            miniAppSubProcessorInfo.currentAppInfo = miniAppBaseInfo;
        }
        miniAppSubProcessorInfo.setAllMiniAppInfo(miniAppBaseInfo, parcelableArrayList);
    }

    public void doPreloadByRuntimeType(int i3) {
        QMLog.e(TAG, "preload by runtime type:" + i3);
        checkAndCleanAllMiniProcess();
        for (Map.Entry<String, MiniAppSubProcessorInfo> entry : subAppProcessorInfoMap.entrySet()) {
            String key = entry.getKey();
            MiniAppSubProcessorInfo value = entry.getValue();
            if (value != null && (value.supportRuntimeType & i3) != 0) {
                QMLog.i(TAG, "obtain targe processor:" + key);
                if (!isProcessAlive(value.processName)) {
                    QMLog.i(TAG, "preload targe processor:" + key);
                    doPreloadApp(value, true, true, true, null);
                    return;
                }
            }
        }
    }

    public MiniAppSubProcessorInfo getCacheApp(MiniAppBaseInfo miniAppBaseInfo) {
        if (miniAppBaseInfo != null) {
            return getCacheApp(miniAppBaseInfo.appId);
        }
        return null;
    }

    public Handler getHandler() {
        return this.mHandler;
    }

    @Override // com.tencent.qqmini.sdk.server.launch.LaunchStrategy
    public void killAllProcess() {
        for (Map.Entry<String, MiniAppSubProcessorInfo> entry : this.mProcessStack.snapshot().entrySet()) {
            if (entry != null) {
                String key = entry.getKey();
                forceKillProcess(entry.getValue());
                cleanProcess(key);
            }
        }
    }

    @Override // com.tencent.qqmini.sdk.server.launch.LaunchStrategy
    public boolean killMiniAppProcess(@NotNull MiniAppInfo miniAppInfo) {
        MiniAppSubProcessorInfo cacheApp = getCacheApp(miniAppInfo);
        if (cacheApp != null) {
            forceKillProcess(cacheApp);
            return false;
        }
        return false;
    }

    @Override // com.tencent.qqmini.sdk.server.launch.LaunchStrategy
    public void onAppBackground(@NotNull String str, @NotNull MiniAppBaseInfo miniAppBaseInfo, @org.jetbrains.annotations.Nullable Bundle bundle) {
        Class<?> cls;
        Class<?> cls2;
        int i3;
        if (bundle != null) {
            bundle.setClassLoader(LaunchManagerService.ServiceBinder.class.getClassLoader());
        }
        QMLog.i(TAG, "onAppBackground process=" + str + " appId=" + getAppid(miniAppBaseInfo) + " appName=" + getAppName(miniAppBaseInfo) + " engineType=" + getEngineType(miniAppBaseInfo) + " reportType=-1");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        MiniAppSubProcessorInfo miniAppSubProcessorInfo = this.mProcessStack.snapshot().get(str);
        if (miniAppSubProcessorInfo == null) {
            MiniAppSubProcessorInfo miniAppSubProcessorInfo2 = subProcessorInfoMap.get(str);
            Class<?> cls3 = null;
            if (miniAppSubProcessorInfo2 != null) {
                cls = miniAppSubProcessorInfo2.uiClass;
            } else {
                cls = null;
            }
            if (miniAppSubProcessorInfo2 != null) {
                cls2 = miniAppSubProcessorInfo2.internalUIClass;
            } else {
                cls2 = null;
            }
            if (miniAppSubProcessorInfo2 != null) {
                cls3 = miniAppSubProcessorInfo2.appPreLoadClass;
            }
            Class<?> cls4 = cls3;
            if (miniAppSubProcessorInfo2 != null) {
                i3 = miniAppSubProcessorInfo2.supportRuntimeType;
            } else {
                i3 = 0;
            }
            MiniAppSubProcessorInfo miniAppSubProcessorInfo3 = new MiniAppSubProcessorInfo(str, cls, cls2, cls4, i3);
            this.mProcessStack.put(str, miniAppSubProcessorInfo3);
            miniAppSubProcessorInfo = miniAppSubProcessorInfo3;
        }
        updateAllMiniAppInfoForProcess(miniAppBaseInfo, bundle, miniAppSubProcessorInfo);
        miniAppSubProcessorInfo.onEnterBackground();
        printProcessStack();
    }

    @Override // com.tencent.qqmini.sdk.server.launch.LaunchStrategy
    public void onAppForeground(@NotNull String str, @NotNull MiniAppBaseInfo miniAppBaseInfo, @org.jetbrains.annotations.Nullable Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(MiniAppInfo.class.getClassLoader());
        }
        String appid = getAppid(miniAppBaseInfo);
        String appName = getAppName(miniAppBaseInfo);
        int engineType = getEngineType(miniAppBaseInfo);
        int pid = getPid(bundle);
        QMLog.i(TAG, "onAppForeground process=" + str + " appId=" + appid + " appName=" + appName + " engineType=" + engineType + " reportType=-1");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        MiniAppSubProcessorInfo miniAppSubProcessorInfo = this.mProcessStack.get(str);
        if (miniAppSubProcessorInfo == null) {
            miniAppSubProcessorInfo = createProcessorInfo(str, miniAppBaseInfo, subProcessorInfoMap.get(str));
            this.mProcessStack.put(str, miniAppSubProcessorInfo);
        }
        updateAllMiniAppInfoForProcess(miniAppBaseInfo, bundle, miniAppSubProcessorInfo);
        MiniAppBaseInfo miniAppBaseInfo2 = this.mStartingMiniAppConfig;
        if (miniAppBaseInfo2 != null && miniAppBaseInfo2.equals(miniAppBaseInfo)) {
            this.mStartingMiniAppConfig = null;
        }
        if (pid > 0) {
            miniAppSubProcessorInfo.pid = pid;
        }
        miniAppSubProcessorInfo.onEnterForeground();
        printProcessStack();
    }

    @Override // com.tencent.qqmini.sdk.server.launch.LaunchStrategy
    public void onAppStart(@NotNull String str, @NotNull MiniAppBaseInfo miniAppBaseInfo, @NotNull Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(MiniAppInfo.class.getClassLoader());
        }
        String appid = getAppid(miniAppBaseInfo);
        String appName = getAppName(miniAppBaseInfo);
        int engineType = getEngineType(miniAppBaseInfo);
        int pid = getPid(bundle);
        QMLog.i(TAG, "onAppStart process=" + str + " appId=" + appid + " appName=" + appName + " engineType=" + engineType + " reportType=-1");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        MiniAppSubProcessorInfo miniAppSubProcessorInfo = getMiniAppSubProcessorInfo(str, miniAppBaseInfo, bundle);
        updateAllMiniAppInfoForProcess(miniAppBaseInfo, bundle, miniAppSubProcessorInfo);
        miniAppSubProcessorInfo.pid = pid;
        this.mPreloadingTask.remove(str);
        printProcessStack();
        QMLog.i(TAG, "updateBaseLib onAppStart " + ProcessUtil.getCurrentProcessName(this.mContext));
    }

    @Override // com.tencent.qqmini.sdk.server.launch.LaunchStrategy
    public void onAppStop(@NotNull String str, @NotNull MiniAppBaseInfo miniAppBaseInfo, @org.jetbrains.annotations.Nullable Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(LaunchManagerService.ServiceBinder.class.getClassLoader());
        }
        String appid = getAppid(miniAppBaseInfo);
        String appName = getAppName(miniAppBaseInfo);
        int engineType = getEngineType(miniAppBaseInfo);
        getPid(bundle);
        QMLog.i(TAG, "onAppStop process=" + str + " appId=" + appid + " appName=" + appName + " engineType=" + engineType + " reportType=-1");
        MiniAppSubProcessorInfo miniAppSubProcessorInfo = this.mProcessStack.get(str);
        if (miniAppSubProcessorInfo != null) {
            Iterator<MiniAppBaseInfo> it = miniAppSubProcessorInfo.allMiniAppInfo.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                MiniAppBaseInfo next = it.next();
                if (TextUtils.equals(next.appId, appid)) {
                    miniAppSubProcessorInfo.allMiniAppInfo.remove(next);
                    break;
                }
            }
            if (miniAppSubProcessorInfo.isIdleProcess()) {
                cleanProcess(str);
            }
        }
        printProcessStack();
    }

    public void onRecvCommand(String str, String str2, Bundle bundle) {
        QMLog.i(TAG, "onRecvCommand cmd=" + str + " processName=" + str2);
        if (IPCConst.CMD_NOTIFY_RUNTIME_INFO.equals(str)) {
            MiniAppSubProcessorInfo miniAppSubProcessorInfo = this.mProcessStack.snapshot().get(str2);
            if (miniAppSubProcessorInfo != null) {
                updateAllMiniAppInfoForProcess(null, bundle, miniAppSubProcessorInfo);
            }
            bundle.setClassLoader(MiniAppInfo.class.getClassLoader());
            ArrayList parcelableArrayList = bundle.getParcelableArrayList(IPCConst.KEY_BUNDLE_RUNTIME_LIST);
            String str3 = "";
            if (parcelableArrayList != null) {
                Iterator it = parcelableArrayList.iterator();
                while (it.hasNext()) {
                    str3 = str3 + ((MiniAppInfo) it.next()).name + ";";
                }
            }
            QMLog.i(TAG, "notify runtime info from process:" + str2 + " appsDecc:" + str3);
        } else if (IPCConst.CMD_NOTIFY_RUNTIME_LIFECYCLE.equals(str)) {
            bundle.setClassLoader(MiniAppInfo.class.getClassLoader());
            String string = bundle.getString(IPCConst.KEY_BUNDLE_RUNTIME_LIFECYCLE, WiFiDash.NOT_AVALIBLE);
            MiniAppInfo miniAppInfo = (MiniAppInfo) bundle.getParcelable(IPCConst.KEY_BUNDLE_APPINFO);
            QMLog.i(TAG, "notify runtime lifecycle from process:" + str2 + " lifecycle:" + string);
            if (miniAppInfo != null && "first_frame".equals(string)) {
                doPreloadExtraMiniApp(miniAppInfo);
            }
        }
        printProcessStack();
    }

    public synchronized void preloadExtraMiniApp(boolean z16) {
        String str;
        if (this.mProcessStack.size() >= this.mProcessMaxCount) {
            return;
        }
        if (z16) {
            str = MiniAppConst.PRELOAD_TYPE_APP;
        } else {
            str = MiniAppConst.PRELOAD_TYPE_GAME;
        }
        if (!hasPreloadProcess(str) && canPreloadProcess(str)) {
            Map<String, MiniAppSubProcessorInfo> snapshot = this.mProcessStack.snapshot();
            for (Map.Entry<String, MiniAppSubProcessorInfo> entry : subAppProcessorInfoMap.entrySet()) {
                if (!snapshot.containsKey(entry.getKey())) {
                    doPreloadApp(entry.getValue(), z16, false, false, null);
                    return;
                }
            }
        }
    }

    @Override // com.tencent.qqmini.sdk.server.launch.LaunchStrategy
    public boolean preloadProcess(@org.jetbrains.annotations.Nullable Bundle bundle) {
        int size;
        boolean z16;
        MiniAppInfo miniAppInfo;
        if (bundle == null) {
            return false;
        }
        try {
            bundle.setClassLoader(MiniAppInfo.class.getClassLoader());
            miniAppInfo = (MiniAppInfo) bundle.getParcelable(MiniAppConst.MINI_KEY_APPINFO);
        } catch (Throwable th5) {
            QMLog.e(TAG, "", th5);
        }
        if (miniAppInfo != null) {
            doPreLaunchMiniApp(miniAppInfo, bundle);
            return true;
        }
        int i3 = bundle.getInt(MiniAppConst.MINI_KEY_PRELOAD_RUNTIME_TYPE, 0);
        if (i3 > 0) {
            doPreloadByRuntimeType(i3);
            return true;
        }
        String string = bundle.getString(MiniAppConst.MINI_KEY_PRELOAD_TYPE);
        if (!needPreloadMiniApp(string) || (size = this.mProcessPreloadCount - this.mProcessStack.size()) <= 0) {
            return false;
        }
        QMLog.i(TAG, "updateBaseLib preloadMiniApp " + ProcessUtil.getCurrentProcessName(this.mContext) + ", process count=" + size);
        printProcessStack();
        Map<String, MiniAppSubProcessorInfo> snapshot = this.mProcessStack.snapshot();
        boolean equals = MiniAppConst.PRELOAD_TYPE_APP.equals(string);
        int i16 = 0;
        while (equals && size > 0) {
            if (i16 % 2 == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            i16++;
            if (z16 && equals) {
                doPreloadApp(snapshot, z16, bundle);
                size--;
            }
        }
        return true;
    }

    @Override // com.tencent.qqmini.sdk.server.launch.LaunchStrategy
    public void registerProcessMessenger(@NotNull String str, @NotNull Messenger messenger) {
        QMLog.w(TAG, "registerClientMessenger pName=" + str + " messenger:" + messenger);
        this.mClientMessengerMap.put(str, messenger);
    }

    @Override // com.tencent.qqmini.sdk.server.launch.LaunchStrategy
    public void sendMessageToMiniProcess(@NotNull MiniAppInfo miniAppInfo, @NotNull Message message) throws RemoteException {
        MiniAppSubProcessorInfo findMiniAppProcessInfo = findMiniAppProcessInfo(miniAppInfo);
        if (findMiniAppProcessInfo != null && !TextUtils.isEmpty(findMiniAppProcessInfo.processName)) {
            Messenger messenger = this.mClientMessengerMap.get(findMiniAppProcessInfo.processName);
            if (messenger != null) {
                messenger.send(message);
                return;
            }
            throw new RemoteException("sendCmdToMiniProcess failed! Messenger is null.");
        }
        throw new RemoteException("sendCmdToMiniProcess failed! Has no processor info.");
    }

    @Override // com.tencent.qqmini.sdk.server.launch.LaunchStrategy
    @NotNull
    public LaunchStrategy.LaunchData startMiniApp(@NotNull MiniAppInfo miniAppInfo) {
        Class<?> cls;
        checkAndCleanAllMiniProcess();
        MiniAppSubProcessorInfo obtainIdleProcessor = obtainIdleProcessor(miniAppInfo);
        if (obtainIdleProcessor != null && miniAppInfo != null) {
            MiniAppBaseInfo miniAppBaseInfo = this.mStartingMiniAppConfig;
            if (miniAppBaseInfo != null && miniAppBaseInfo.equals((MiniAppBaseInfo) miniAppInfo) && System.currentTimeMillis() - this.mStartTimestamp <= this.mStartTimeInterval) {
                QMLog.i(TAG, "startMiniApp duplicate. The miniapp is starting! interval=" + this.mStartTimeInterval + " appId=" + miniAppInfo.appId);
            }
            this.startAppIdMap.put(miniAppInfo.appId, Long.valueOf(System.currentTimeMillis()));
            this.mStartingMiniAppConfig = miniAppInfo;
            this.mStartTimestamp = System.currentTimeMillis();
            boolean containsAppConfig = obtainIdleProcessor.containsAppConfig(miniAppInfo);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("doStartMiniApp appId=");
            sb5.append(miniAppInfo.appId);
            sb5.append(" appName=");
            sb5.append(miniAppInfo.name);
            sb5.append(" isInternal:");
            sb5.append(miniAppInfo.isInternalApp());
            sb5.append(" engineType=");
            sb5.append(miniAppInfo.getEngineType());
            sb5.append(" reportType=");
            sb5.append(-1);
            sb5.append(" targetProcess=");
            sb5.append(obtainIdleProcessor.processName);
            sb5.append(" alreadyStarted=");
            sb5.append(containsAppConfig);
            sb5.append(" processorInfo = ");
            Class<?> cls2 = obtainIdleProcessor.internalUIClass;
            if (cls2 == null) {
                cls2 = obtainIdleProcessor.uiClass;
            }
            sb5.append(cls2);
            QMLog.i(TAG, sb5.toString());
            Context context = this.mContext;
            if (!miniAppInfo.isInternalApp() || (cls = obtainIdleProcessor.internalUIClass) == null) {
                cls = obtainIdleProcessor.uiClass;
            }
            Intent intent = new Intent(context, cls);
            setIntentFlags(intent, miniAppInfo);
            return new LaunchStrategy.LaunchData(intent, getProcessState(obtainIdleProcessor));
        }
        throw new IllegalStateException("obtain idle processor config failed!");
    }

    public MiniAppSubProcessorInfo getCacheApp(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (Map.Entry<String, MiniAppSubProcessorInfo> entry : this.mProcessStack.snapshot().entrySet()) {
            if (entry != null) {
                String key = entry.getKey();
                MiniAppSubProcessorInfo value = entry.getValue();
                if (value != null && !value.allMiniAppInfo.isEmpty()) {
                    Iterator<MiniAppBaseInfo> it = value.allMiniAppInfo.iterator();
                    while (it.hasNext()) {
                        if (TextUtils.equals(it.next().appId, str)) {
                            QMLog.i(TAG, "obtain loaded processor from stack:" + key);
                            return value;
                        }
                    }
                }
            }
        }
        return null;
    }

    private boolean isProcessAlive(int i3) {
        try {
            ActivityManager activityManager = (ActivityManager) this.mContext.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager != null ? SystemMethodProxy.getRunningAppProcesses(activityManager) : null;
            if (runningAppProcesses != null && runningAppProcesses.size() > 0) {
                Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                while (it.hasNext()) {
                    if (it.next().pid == i3) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        } catch (Throwable th5) {
            QMLog.e(TAG, "", th5);
            return false;
        }
    }

    private void doPreloadApp(Map<String, MiniAppSubProcessorInfo> map, boolean z16, Bundle bundle) {
        for (Map.Entry<String, MiniAppSubProcessorInfo> entry : subAppProcessorInfoMap.entrySet()) {
            if (!map.containsKey(entry.getKey())) {
                doPreloadApp(entry.getValue(), z16, true, true, bundle);
                return;
            }
        }
    }

    @Override // com.tencent.qqmini.sdk.server.launch.LaunchStrategy
    public void onPreloaded(@NotNull String str, @NotNull Bundle bundle) {
    }

    @Override // com.tencent.qqmini.sdk.server.launch.LaunchStrategy
    public void onReceiveProcessRunningAppInfos(@NonNull String str, @NotNull List<? extends MiniAppInfo> list) {
    }
}
