package com.tencent.qqmini.sdk.server;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.mini.app.AppBrandContant;
import com.tencent.qqmini.sdk.MiniSDK;
import com.tencent.qqmini.sdk.core.MiniAppConst;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.MiniProcessorConfig;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.CmdProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppCacheProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.QQCustomizedProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.WnsConfigProxy;
import com.tencent.qqmini.sdk.launcher.ipc.ILaunchManager;
import com.tencent.qqmini.sdk.launcher.ipc.IPCConst;
import com.tencent.qqmini.sdk.launcher.ipc.MiniCmdCallback;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.LoginInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniAppBaseInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.ProcessType;
import com.tencent.qqmini.sdk.launcher.utils.StartupReportUtil;
import com.tencent.qqmini.sdk.manager.BaseLibManager;
import com.tencent.qqmini.sdk.manager.EngineManager;
import com.tencent.qqmini.sdk.manager.a;
import com.tencent.qqmini.sdk.report.MiniAppReportManager2;
import com.tencent.qqmini.sdk.server.launch.AppLaunchStrategy;
import com.tencent.qqmini.sdk.server.launch.GameLaunchConfig;
import com.tencent.qqmini.sdk.server.launch.GameLaunchStrategy;
import com.tencent.qqmini.sdk.server.launch.LaunchStrategy;
import com.tencent.qqmini.sdk.server.launch.ProcessPreloader;
import com.tencent.qqmini.sdk.server.launch.ProcessState;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import cooperation.qzone.util.WiFiDash;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class LaunchManagerService {
    private static final String KEY_MINI_APP_CONFIG = "key_mini_app_config";
    private static final String KEY_RUN_IN_MAINPROCSS = "key_run_in_mainprocess";
    private static final String TAG = "minisdk-start_LaunchManagerService";
    private static boolean audioMute = false;
    private AppLaunchStrategy mAppLaunchStrategy;
    private Context mContext;
    private GameLaunchStrategy mGameLaunchStrategy;
    private final LinkedList<MiniProcessorConfig> mAppProcessConfig = new LinkedList<>();
    private final LinkedList<MiniProcessorConfig> mInternalProcessConfig = new LinkedList<>();
    private final LinkedList<MiniProcessorConfig> mGameProcessConfig = new LinkedList<>();
    protected Handler mHandler = new Handler(Looper.getMainLooper());
    private final IBinder mServiceBinder = new ServiceBinder();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class GameProcessPreloader implements ProcessPreloader {
        GameProcessPreloader() {
        }

        @Override // com.tencent.qqmini.sdk.server.launch.ProcessPreloader
        public void performPreloadProcess(@NotNull MiniProcessorConfig miniProcessorConfig) {
            Intent intent = new Intent(LaunchManagerService.this.mContext, miniProcessorConfig.appPreLoadClass);
            intent.setAction(MiniSDKConst.ACTION_PRELOAD_GAME);
            intent.putExtra(AppBrandContant.LAUNCH_SDK_MODE, true);
            MiniAppProxy miniAppProxy = (MiniAppProxy) ProxyManager.get(MiniAppProxy.class);
            intent.putExtra(IPCConst.KEY_LOGININFO, new LoginInfo(miniAppProxy.getLoginType(), miniAppProxy.getAccount(), miniAppProxy.getNickName(), miniAppProxy.getPayOpenId(), miniAppProxy.getPayOpenKey(), miniAppProxy.getPayAccessToken(), miniAppProxy.getLoginSig(), miniAppProxy.getPlatformId(), miniAppProxy.getAppId()));
            intent.putExtra(IPCConst.KEY_MINI_SERVICE_MANAGER, MiniServer.g().getMiniServiceFetcher());
            intent.putExtra("time_start_broadcast", System.currentTimeMillis());
            LaunchManagerService.this.mContext.sendBroadcast(intent);
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class ServiceBinder extends ILaunchManager.Stub {
        public ServiceBinder() {
        }

        @Override // com.tencent.qqmini.sdk.launcher.ipc.ILaunchManager
        public void onAppLifecycle(int i3, String str, MiniAppInfo miniAppInfo, Bundle bundle) throws RemoteException {
            if (miniAppInfo == null && i3 != 1) {
                QMLog.w(LaunchManagerService.TAG, "handleAppLifecycle lifecycle:" + i3 + " process:" + str + " miniAppInfo is null");
                return;
            }
            QMLog.i(LaunchManagerService.TAG, "handleAppLifecycle lifecycle:" + i3 + " process:" + str + " miniAppInfo:" + miniAppInfo);
            try {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            if (i3 == 4) {
                                LaunchManagerService.this.onAppStop(str, miniAppInfo, bundle);
                            }
                        } else {
                            LaunchManagerService.this.onAppBackground(str, miniAppInfo, bundle);
                        }
                    } else {
                        LaunchManagerService.this.onAppForeground(str, miniAppInfo, bundle);
                    }
                } else {
                    LaunchManagerService.this.onAppStart(str, miniAppInfo, bundle);
                }
            } catch (Throwable th5) {
                QMLog.e(LaunchManagerService.TAG, "onAppLifecycle() called with: lifecycle = [" + i3 + "], processName = [" + str + "], miniAppInfo = [" + miniAppInfo + "], bundle = [" + bundle + "]");
                if (((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).isDebugVersion()) {
                    ThreadManager.executeOnComputationThreadPool(new Runnable() { // from class: com.tencent.qqmini.sdk.server.LaunchManagerService.ServiceBinder.1
                        @Override // java.lang.Runnable
                        public void run() {
                            throw new RuntimeException(th5);
                        }
                    });
                }
                throw new RuntimeException(th5);
            }
        }

        @Override // com.tencent.qqmini.sdk.launcher.ipc.ILaunchManager
        public void preloadDownloadPackage(MiniAppInfo miniAppInfo, ResultReceiver resultReceiver) throws RemoteException {
            LaunchManagerService.this.preDownloadPkg(miniAppInfo, resultReceiver);
        }

        @Override // com.tencent.qqmini.sdk.launcher.ipc.ILaunchManager
        public Bundle requestAync(String str, String str2, Bundle bundle) throws RemoteException {
            QMLog.i(LaunchManagerService.TAG, "requestAync cmd:" + str + " process:" + str2);
            try {
                if (IPCConst.CMD_QUERY_IS_MINI_PROCESS.equals(str)) {
                    boolean isMiniProcess = LaunchManagerService.this.isMiniProcess(str2);
                    Bundle bundle2 = new Bundle();
                    bundle2.putBoolean("key_result", isMiniProcess);
                    return bundle2;
                }
                if (IPCConst.KEY_GET_CONFIG_FROM_VNS.equals(str)) {
                    String string = bundle.getString(IPCConst.KEY_VNS_FIRST);
                    String string2 = bundle.getString(IPCConst.KEY_VNS_SECOND);
                    Bundle bundle3 = new Bundle();
                    bundle3.putString("key_result", WnsConfig.getConfig(string, string2, ""));
                    return bundle3;
                }
                return null;
            } catch (Throwable th5) {
                QMLog.i(LaunchManagerService.TAG, "requestAync exception!", th5);
                return null;
            }
        }

        @Override // com.tencent.qqmini.sdk.launcher.ipc.ILaunchManager
        public void sendCmd(String str, String str2, Bundle bundle, MiniCmdCallback miniCmdCallback) throws RemoteException {
            try {
                if (IPCConst.CMD_NOTIFY_RUNTIME_INFO.equals(str)) {
                    LaunchManagerService.this.onRecvCommand(str, str2, bundle);
                    if (miniCmdCallback != null) {
                        miniCmdCallback.onCmdResult(true, new Bundle());
                        return;
                    }
                    return;
                }
                if (IPCConst.CMD_NOTIFY_RUNTIME_LIFECYCLE.equals(str)) {
                    LaunchManagerService.this.onRecvCommand(str, str2, bundle);
                    if (miniCmdCallback != null) {
                        miniCmdCallback.onCmdResult(true, new Bundle());
                        return;
                    }
                    return;
                }
                if (IPCConst.CMD_GAME_ENGINE_INFO.equals(str)) {
                    LaunchManagerService.this.onGetGameEngineInfo(str2, bundle);
                } else {
                    MiniAppCmdServlet.g().onMiniAppCmd(str, bundle, miniCmdCallback);
                }
            } catch (Throwable th5) {
                QMLog.e(LaunchManagerService.TAG, "sendCmd exception!", th5);
            }
        }

        @Override // com.tencent.qqmini.sdk.launcher.ipc.ILaunchManager
        public void startMiniApp(MiniAppInfo miniAppInfo, Bundle bundle, ResultReceiver resultReceiver) throws RemoteException {
            LaunchManagerService.this.startMiniApp(null, miniAppInfo, bundle, resultReceiver);
        }

        @Override // com.tencent.qqmini.sdk.launcher.ipc.ILaunchManager
        public void stopAllMiniApp() throws RemoteException {
            LaunchManagerService.this.stopAllMiniApp();
        }

        @Override // com.tencent.qqmini.sdk.launcher.ipc.ILaunchManager
        public void stopMiniApp(MiniAppInfo miniAppInfo) throws RemoteException {
            LaunchManagerService.this.stopMiniApp(miniAppInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class a implements BaseLibManager.UpdateListener {
        a() {
        }

        @Override // com.tencent.qqmini.sdk.manager.BaseLibManager.UpdateListener
        public void onUpdateResult(int i3) {
            String str;
            QMLog.w(LaunchManagerService.TAG, "updateBaseLib ret=" + i3);
            if (i3 != 0) {
                if (i3 == 1) {
                    QMLog.w(LaunchManagerService.TAG, "\u57fa\u7840\u5e93\u65e0\u66f4\u65b0.");
                    return;
                }
                if (i3 == 1100) {
                    str = "\u7840\u5e93\u66f4\u65b0\u8bf7\u6c42\u5931\u8d25.";
                } else if (i3 == 1101) {
                    str = "\u57fa\u7840\u5e93\u4e0b\u8f7d\u5931\u8d25.";
                } else {
                    str = "\u57fa\u7840\u5e93\u66f4\u65b0\u5931\u8d25.";
                }
                QMLog.w(LaunchManagerService.TAG, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f348344a;

        static {
            int[] iArr = new int[ProcessType.values().length];
            f348344a = iArr;
            try {
                iArr[ProcessType.MINI_APP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f348344a[ProcessType.MINI_GAME.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f348344a[ProcessType.MINI_INTERNAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private void addProcessorInfo(MiniProcessorConfig miniProcessorConfig) {
        QMLog.i(TAG, "registerProcessInfo " + miniProcessorConfig);
        int i3 = b.f348344a[miniProcessorConfig.processType.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    this.mInternalProcessConfig.add(miniProcessorConfig);
                    return;
                }
                return;
            }
            this.mGameProcessConfig.add(miniProcessorConfig);
            return;
        }
        this.mAppProcessConfig.add(miniProcessorConfig);
    }

    private void checkMiniAppInfoCache() {
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.qqmini.sdk.server.LaunchManagerService.8
            @Override // java.lang.Runnable
            public void run() {
                MiniAppCacheProxy miniAppCacheProxy = (MiniAppCacheProxy) ProxyManager.get(MiniAppCacheProxy.class);
                if (miniAppCacheProxy != null && miniAppCacheProxy.enableMiniAppCache() && miniAppCacheProxy.deleteCacheByTimeStamp(System.currentTimeMillis() - miniAppCacheProxy.getDeleteIntervalTime())) {
                    QMLog.d(LaunchManagerService.TAG, "deleteCacheByTimeStamp success.");
                }
            }
        });
    }

    @SuppressLint({"WrongConstant"})
    private void doStartMiniApp(final Activity activity, MiniAppInfo miniAppInfo, Bundle bundle, ResultReceiver resultReceiver) {
        try {
            LaunchStrategy.LaunchData startMiniApp = getLaunchStrategy(miniAppInfo).startMiniApp(miniAppInfo);
            StartupReportUtil.reportStartUI(miniAppInfo);
            MiniAppReportManager2.reportPageView("2click", null, miniAppInfo.launchParam.entryPath, miniAppInfo);
            final Intent intent = startMiniApp.getIntent();
            int i3 = 2;
            if (startMiniApp.getProcessState() == ProcessState.EMPTY) {
                intent.putExtra("start_mode", 3);
            } else if (startMiniApp.getProcessState() == ProcessState.PRELOADED) {
                intent.putExtra("start_mode", 1);
            } else {
                intent.putExtra("start_mode", 2);
            }
            MiniAppProxy miniAppProxy = (MiniAppProxy) ProxyManager.get(MiniAppProxy.class);
            intent.putExtra(IPCConst.KEY_LOGININFO, new LoginInfo(miniAppProxy.getLoginType(), miniAppProxy.getAccount(), miniAppProxy.getNickName(), miniAppProxy.getPayOpenId(), miniAppProxy.getPayOpenKey(), miniAppProxy.getPayAccessToken(), miniAppProxy.getLoginSig(), miniAppProxy.getPlatformId(), miniAppProxy.getAppId()));
            intent.putExtra(IPCConst.KEY_APPINFO, miniAppInfo);
            intent.putExtra(IPCConst.KEY_MINI_SERVICE_MANAGER, MiniServer.g().getMiniServiceFetcher());
            intent.putExtra(AppBrandContant.LAUNCH_SDK_MODE, true);
            intent.putExtra("receiver", resultReceiver);
            intent.putExtra("startDuration", System.currentTimeMillis());
            EngineManager g16 = EngineManager.g();
            if (miniAppInfo.engineType != 1) {
                i3 = 3;
            }
            intent.putExtra("engineChannel", g16.getChannelForType(i3));
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            intent.putExtra("isMute", audioMute);
            if (activity != null) {
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqmini.sdk.server.LaunchManagerService.1
                    @Override // java.lang.Runnable
                    public void run() {
                        activity.startActivity(intent);
                    }
                });
            } else if (resultReceiver != null) {
                Bundle bundle2 = new Bundle();
                bundle2.putParcelable(IPCConst.KEY_LAUNCH_ACTIVITY_INTENT, intent);
                resultReceiver.send(1, bundle2);
            } else {
                this.mContext.startActivity(intent);
            }
            QMLog.i(TAG, "---startApp----  appid:" + miniAppInfo.appId + " appName:" + miniAppInfo.name + " intent:" + intent);
        } catch (IllegalStateException e16) {
            QMLog.e(TAG, "---startApp---- failed appid:" + miniAppInfo.appId + " appName:" + miniAppInfo.name, e16);
        }
    }

    @NonNull
    private LaunchStrategy getLaunchStrategy(MiniAppBaseInfo miniAppBaseInfo) {
        if (!miniAppBaseInfo.isEngineTypeMiniGame() && !miniAppBaseInfo.isEngineTypeHippy()) {
            return this.mAppLaunchStrategy;
        }
        return this.mGameLaunchStrategy;
    }

    private void initWnsConfig() {
        if (QUAUtil.isQQApp()) {
            return;
        }
        ThreadManager.executeOnNetworkIOThreadPool(new Runnable() { // from class: com.tencent.qqmini.sdk.server.LaunchManagerService.6
            @Override // java.lang.Runnable
            public void run() {
                QMLog.i(LaunchManagerService.TAG, "zzconfig start to loadServer");
                WnsConfigProxy wnsConfigProxy = (WnsConfigProxy) ProxyManager.get(WnsConfigProxy.class);
                if (wnsConfigProxy != null) {
                    wnsConfigProxy.loadConfigFromServer();
                }
            }
        });
    }

    private boolean isMiniAppProcess(String str) {
        Iterator<MiniProcessorConfig> it = this.mAppProcessConfig.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(str, it.next().processName)) {
                return true;
            }
        }
        Iterator<MiniProcessorConfig> it5 = this.mInternalProcessConfig.iterator();
        while (it5.hasNext()) {
            if (TextUtils.equals(str, it5.next().processName)) {
                return true;
            }
        }
        return false;
    }

    private boolean isMiniGameProcess(String str) {
        Iterator<MiniProcessorConfig> it = this.mGameProcessConfig.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(str, it.next().processName)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isMiniProcess(String str) {
        if (!isMiniAppProcess(str) && !isMiniGameProcess(str)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onGetGameEngineInfo(String str, Bundle bundle) {
        GameLaunchStrategy gameLaunchStrategy = this.mGameLaunchStrategy;
        if (gameLaunchStrategy != null) {
            gameLaunchStrategy.onGetEngineInfo(str, bundle);
        }
    }

    private void setAinm4MiniApp(Activity activity, MiniAppInfo miniAppInfo) {
        if (activity != null && miniAppInfo != null) {
            boolean isEngineTypeMiniApp = miniAppInfo.isEngineTypeMiniApp();
            QMLog.e(TAG, "setAinm4MiniApp: " + activity + " ,appConfig: " + miniAppInfo + "--" + miniAppInfo.launchParam.scene);
            if (isEngineTypeMiniApp && miniAppInfo.launchParam.scene == 5002) {
                activity.overridePendingTransition(R.anim.mini_sdk_slide_in_right, R.anim.mini_sdk_activity_stay);
                return;
            }
            if (isEngineTypeMiniApp && miniAppInfo.launchParam.scene != 2004) {
                activity.overridePendingTransition(R.anim.mini_sdk_slide_in_down, R.anim.mini_sdk_activity_stay);
                return;
            }
            QQCustomizedProxy qQCustomizedProxy = (QQCustomizedProxy) ProxyManager.get(QQCustomizedProxy.class);
            if (qQCustomizedProxy != null && qQCustomizedProxy.needCustomActivityAnim(miniAppInfo)) {
                qQCustomizedProxy.setActivityAnim(miniAppInfo, activity);
                return;
            }
            return;
        }
        QMLog.e(TAG, "activity: " + activity + " ,appConfig: " + miniAppInfo);
    }

    private synchronized void updateBaseLib() {
        if (QUAUtil.isQQMainApp()) {
            return;
        }
        try {
            BaseLibManager.g().updateBaseLib(new a());
        } catch (Throwable th5) {
            QMLog.e(TAG, "updateBaseLib failed ", th5);
        }
    }

    public IBinder getBinder() {
        return this.mServiceBinder;
    }

    public Handler getHandler() {
        return this.mHandler;
    }

    public void init(Context context) {
        if (this.mContext == null) {
            this.mContext = context;
            this.mAppLaunchStrategy = new AppLaunchStrategy(this.mContext, this.mAppProcessConfig, this.mInternalProcessConfig);
            this.mGameLaunchStrategy = new GameLaunchStrategy(this.mContext, this.mGameProcessConfig, GameLaunchConfig.fromWnsConfig(), new GameProcessPreloader(), ((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).isDebugVersion());
            checkMiniAppInfoCache();
            return;
        }
        throw new IllegalArgumentException();
    }

    public void onAppBackground(String str, MiniAppBaseInfo miniAppBaseInfo, Bundle bundle) {
        getLaunchStrategy(miniAppBaseInfo).onAppBackground(str, miniAppBaseInfo, bundle);
    }

    public void onAppForeground(String str, MiniAppBaseInfo miniAppBaseInfo, Bundle bundle) {
        getLaunchStrategy(miniAppBaseInfo).onAppForeground(str, miniAppBaseInfo, bundle);
    }

    public void onAppStart(String str, @Nullable MiniAppBaseInfo miniAppBaseInfo, Bundle bundle) {
        if (miniAppBaseInfo != null) {
            getLaunchStrategy(miniAppBaseInfo).onAppStart(str, miniAppBaseInfo, bundle);
        } else {
            getLaunchStrategy(str).onPreloaded(str, bundle);
        }
        updateBaseLib();
        initWnsConfig();
    }

    public void onAppStop(String str, MiniAppBaseInfo miniAppBaseInfo, Bundle bundle) {
        getLaunchStrategy(miniAppBaseInfo).onAppStop(str, miniAppBaseInfo, bundle);
    }

    public void onHostAppBackground() {
        MiniAppReportManager2.onEnterBackground();
    }

    public void onRecvCommand(String str, String str2, Bundle bundle) {
        boolean z16;
        this.mAppLaunchStrategy.onRecvCommand(str, str2, bundle);
        bundle.setClassLoader(MiniAppInfo.class.getClassLoader());
        if (IPCConst.CMD_NOTIFY_RUNTIME_LIFECYCLE.equals(str) && "first_frame".equals(bundle.getString(IPCConst.KEY_BUNDLE_RUNTIME_LIFECYCLE, WiFiDash.NOT_AVALIBLE))) {
            MiniAppInfo miniAppInfo = (MiniAppInfo) bundle.getParcelable(IPCConst.KEY_BUNDLE_APPINFO);
            if (miniAppInfo != null && miniAppInfo.isEngineTypeMiniGame()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (QMLog.isColorLevel()) {
                QMLog.i(TAG, "onRecvCommand: first frame, isPreload=" + z16);
            }
            if (z16) {
                this.mGameLaunchStrategy.preloadProcess(null);
                return;
            }
            return;
        }
        if (IPCConst.CMD_NOTIFY_RUNTIME_INFO.equals(str)) {
            bundle.setClassLoader(MiniAppInfo.class.getClassLoader());
            ArrayList parcelableArrayList = bundle.getParcelableArrayList(IPCConst.KEY_BUNDLE_RUNTIME_LIST);
            if (parcelableArrayList != null) {
                getLaunchStrategy(str2).onReceiveProcessRunningAppInfos(str2, parcelableArrayList);
            }
        }
    }

    public void preDownloadPkg(MiniAppInfo miniAppInfo, final ResultReceiver resultReceiver) {
        if (((CmdProxy) ProxyManager.get(CmdProxy.class)) != null && miniAppInfo != null) {
            if (miniAppInfo.isEngineTypeMiniGame()) {
                com.tencent.qqmini.sdk.manager.a.a(miniAppInfo, false, new a.b() { // from class: com.tencent.qqmini.sdk.server.LaunchManagerService.4
                    @Override // com.tencent.qqmini.sdk.manager.a.b
                    public void onFail(@NonNull String str) {
                        if (resultReceiver != null) {
                            Bundle bundle = new Bundle();
                            bundle.putInt("retCode", 2);
                            bundle.putString("errMsg", str);
                            resultReceiver.send(2, bundle);
                        }
                    }

                    @Override // com.tencent.qqmini.sdk.manager.a.b
                    public void onSuccess() {
                        if (resultReceiver != null) {
                            Bundle bundle = new Bundle();
                            bundle.putInt("retCode", 0);
                            resultReceiver.send(0, bundle);
                        }
                    }

                    @Override // com.tencent.qqmini.sdk.manager.a.b
                    public void onProgress(float f16, long j3) {
                    }
                });
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putParcelable("key_mini_app_config", miniAppInfo);
            bundle.putBoolean(KEY_RUN_IN_MAINPROCSS, true);
            ((CmdProxy) ProxyManager.get(CmdProxy.class)).handleMiniAppCmd(IPCConst.CMD_MAIN_PROCESS_LOAD_PKG, bundle, new MiniCmdCallback.Stub() { // from class: com.tencent.qqmini.sdk.server.LaunchManagerService.5
                @Override // com.tencent.qqmini.sdk.launcher.ipc.MiniCmdCallback
                public void onCmdResult(boolean z16, @NonNull Bundle bundle2) throws RemoteException {
                    if (z16) {
                        int i3 = bundle2.getInt("retCode");
                        ResultReceiver resultReceiver2 = resultReceiver;
                        if (resultReceiver2 != null) {
                            resultReceiver2.send(i3, bundle2);
                        }
                        QMLog.i(LaunchManagerService.TAG, "[preDownloadPkg] retCode=" + i3);
                    }
                }
            });
            return;
        }
        QMLog.e(TAG, "preDownloadPkg: failed, params invalid.");
        resultReceiver.send(-1, null);
    }

    public synchronized void preloadMiniApp(Bundle bundle) {
        updateBaseLib();
        if (bundle == null) {
            return;
        }
        if (TextUtils.equals(bundle.getString(MiniAppConst.MINI_KEY_PRELOAD_TYPE), MiniAppConst.PRELOAD_TYPE_GAME)) {
            this.mGameLaunchStrategy.preloadProcess(bundle);
        } else {
            this.mAppLaunchStrategy.preloadProcess(bundle);
        }
    }

    public void registerClientMessenger(String str, Messenger messenger) {
        if (!TextUtils.isEmpty(str) && messenger != null) {
            QMLog.w(TAG, "registerClientMessenger pName=" + str + " messenger:" + messenger);
            try {
                getLaunchStrategy(str).registerProcessMessenger(str, messenger);
            } catch (Exception e16) {
                QMLog.e(TAG, "registerClientMessenger error=" + e16.getMessage());
            }
        }
    }

    public void registerProcessInfo(List<MiniProcessorConfig> list) {
        if (list != null && list.size() > 0) {
            for (MiniProcessorConfig miniProcessorConfig : list) {
                if (miniProcessorConfig != null && !TextUtils.isEmpty(miniProcessorConfig.processName)) {
                    addProcessorInfo(miniProcessorConfig);
                }
            }
        }
    }

    public boolean sendCmdToMiniProcess(int i3, Bundle bundle, MiniAppInfo miniAppInfo, ResultReceiver resultReceiver) {
        if (miniAppInfo == null) {
            QMLog.e(TAG, "sendCmdToMiniProcess failed! miniAppInfo is null.");
            return false;
        }
        Message obtain = Message.obtain();
        obtain.what = i3;
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putParcelable(IPCConst.KEY_APPINFO, miniAppInfo);
        if (resultReceiver != null) {
            bundle.putParcelable("receiver", resultReceiver);
        }
        obtain.setData(bundle);
        try {
            QMLog.i(TAG, "Messenger sendCmdToMiniProcess cmd=" + i3);
            getLaunchStrategy(miniAppInfo).sendMessageToMiniProcess(miniAppInfo, obtain);
            return true;
        } catch (Throwable th5) {
            QMLog.e(TAG, "Messenger sendCmdToMiniProcess exception!", th5);
            if (resultReceiver != null) {
                resultReceiver.send(-1, new Bundle());
            }
            return false;
        }
    }

    public void setMute(boolean z16) {
        audioMute = z16;
        QMLog.i(TAG, "setMute: " + z16);
    }

    public void startMiniApp(Activity activity, final MiniAppInfo miniAppInfo, Bundle bundle, ResultReceiver resultReceiver) {
        String str;
        String str2;
        if (miniAppInfo == null) {
            QMLog.e(TAG, "startMiniApp params is empty! ,appConfig=" + miniAppInfo + " Activity=" + activity);
            return;
        }
        QMLog.i(TAG, "startMiniApp: appId:" + miniAppInfo.appId + " appName:" + miniAppInfo.name);
        doStartMiniApp(activity, miniAppInfo, bundle, resultReceiver);
        com.tencent.qqmini.sdk.report.a.h(miniAppInfo);
        if (!miniAppInfo.isFakeAppInfo() && !miniAppInfo.isShortcutFakeApp()) {
            if (miniAppInfo.isEngineTypeMiniGame()) {
                ThreadManager.runIOTask(new Runnable() { // from class: com.tencent.qqmini.sdk.server.LaunchManagerService.2
                    @Override // java.lang.Runnable
                    public void run() {
                        MiniSDK.preDownloadPkg(LaunchManagerService.this.mContext, miniAppInfo, null);
                    }
                });
            }
            ChannelProxy channelProxy = (ChannelProxy) ProxyManager.get(ChannelProxy.class);
            LaunchParam launchParam = miniAppInfo.launchParam;
            if (launchParam == null) {
                str = "";
            } else {
                str = String.valueOf(launchParam.scene);
            }
            String str3 = miniAppInfo.via;
            if (str3 == null) {
                str2 = "";
            } else {
                str2 = str3;
            }
            channelProxy.useUserApp(miniAppInfo.appId, miniAppInfo.verType, 0, str, str2, null, new AsyncResult() { // from class: com.tencent.qqmini.sdk.server.LaunchManagerService.3
                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
                public void onReceiveResult(boolean z16, JSONObject jSONObject) {
                    QMLog.i(LaunchManagerService.TAG, "---startApp---- useUserApp isSuccess = " + z16);
                }
            });
        }
    }

    public void stopAllMiniApp() {
        this.mAppLaunchStrategy.killAllProcess();
        this.mGameLaunchStrategy.killAllProcess();
    }

    public void stopMiniApp(MiniAppInfo miniAppInfo) {
        getLaunchStrategy(miniAppInfo).killMiniAppProcess(miniAppInfo);
    }

    @NonNull
    private LaunchStrategy getLaunchStrategy(String str) {
        if (isMiniGameProcess(str)) {
            return this.mGameLaunchStrategy;
        }
        return this.mAppLaunchStrategy;
    }
}
