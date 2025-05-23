package com.tencent.hippy.qq.preload;

import android.content.ComponentCallbacks2;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.hippy.qq.api.HippyInterpolator;
import com.tencent.hippy.qq.api.IBaseHttpAdapter;
import com.tencent.hippy.qq.api.IHippyIPC;
import com.tencent.hippy.qq.api.IHippySSR;
import com.tencent.hippy.qq.api.IHippySetting;
import com.tencent.hippy.qq.api.IHippyThread;
import com.tencent.hippy.qq.api.IHippyUpdate;
import com.tencent.hippy.qq.api.ISSRBundleRequester;
import com.tencent.hippy.qq.api.KuiklyTabPreloadItem;
import com.tencent.hippy.qq.api.MMKVCommonFileKeys;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.hippy.qq.app.HippyQQPreloadEngine;
import com.tencent.hippy.qq.interpolators.HippyInterpolatorConfig;
import com.tencent.hippy.qq.preload.TabPreloadManager;
import com.tencent.hippy.qq.preload.ThemeChangedReceiver;
import com.tencent.hippy.qq.ssr.SSRManager;
import com.tencent.hippy.qq.update.HippyPredownloadManager;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.hippy.qq.update.HippyQQFileUtil;
import com.tencent.hippy.qq.update.HippyQQLibraryManager;
import com.tencent.hippy.qq.update.HippyUpdateManager;
import com.tencent.hippy.qq.update.config.TabPreloadConfigManager;
import com.tencent.hippy.qq.utils.HippyAccessHelper;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.hippy.qq.utils.HippyUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.bc;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qqecommerce.biz.hr.api.IBaseHttpAdapterFactory;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyDexResApi;
import com.tencent.mobileqq.qqgamepub.api.IQQGameAdService;
import com.tencent.mobileqq.qqgamepub.api.IQQGameConfigUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.statemachine.api.IStateManager;
import com.tencent.statemachine.api.MainState;
import com.tencent.statemachine.api.StateObserver;
import eipc.EIPCResult;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class TabPreloadManager implements ThemeChangedReceiver.Listener {
    private static final int DEFAULT_TAB_PRELOAD_WAIT_TIME = 1000;
    private static final String DESTROY_ENGINE_FROM_MANUAL = "tab_newPreload";
    private static final int MESSAGE_TAB_FIRST_PRELOAD_WAIT_TIME = 5000;
    private static final int MSG_PRELOAD_HIPPY = 2;
    private static final int MSG_TAB_CHANGED = 1;
    private static final String TAG = "TabPreloadManager.PID:" + MobileQQ.sProcessId;
    private static volatile TabPreloadManager sTabPreloadManager;
    private volatile String mCurTabName;
    private boolean mHasPreloadInToolProcess;
    private IBaseHttpAdapter mHttpAdapter;
    private HippyQQPreloadEngine mPreloadingEngine;
    private long mSwitchToolProcessTimeCost;
    private ThemeChangedReceiver mThemeChangedReceiver;
    private final Object mPreloadDataLock = new Object();
    private boolean mIsPreloading = false;
    private ArrayList<TabPreloadInfo> mPreloadWaitList = new ArrayList<>();
    private ArrayList<TabPreloadInfo> mPreloadedList = new ArrayList<>();
    private long mDynamicTabShowTime = 0;
    private ComponentCallbacks2 mComponentCallbacks = new ComponentCallbacks2() { // from class: com.tencent.hippy.qq.preload.TabPreloadManager.3
        @Override // android.content.ComponentCallbacks2
        public void onTrimMemory(int i3) {
            if (i3 == 10 || i3 == 15) {
                TabPreloadManager.this.clearAllPreloads(HippyReporter.RemoveEngineReason.LOW_MEMORY);
                HippyAccessHelper.clearAllPreloads(HippyReporter.RemoveEngineReason.LOW_MEMORY);
            }
        }

        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
        }

        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration configuration) {
        }
    };
    private StateObserver mMainTabStateObserver = new StateObserver() { // from class: com.tencent.hippy.qq.preload.TabPreloadManager.4
        @Override // com.tencent.statemachine.api.StateObserver
        public void onStateChanged(String str, String str2) {
            int preloadDelay;
            if (str != null && TabPreloadManager.this.mPreloadHandler != null) {
                if (str.equals(MainState.MAIN_STATE_DYNAMIC_TAB_SHOW)) {
                    TabPreloadManager.this.mDynamicTabShowTime = System.currentTimeMillis();
                }
                String convertStateToTabName = TabPreloadManager.this.convertStateToTabName(str);
                if (TextUtils.isEmpty(convertStateToTabName)) {
                    return;
                }
                if (str2 == null && str.equals(MainState.MAIN_STATE_MESSAGE_TAB_SHOW)) {
                    preloadDelay = 5000;
                } else {
                    preloadDelay = HippyPredownloadManager.getInstance().getTabPreloadConfigManager().getPreloadDelay();
                }
                TabPreloadManager.this.mPreloadHandler.removeMessages(1);
                TabPreloadManager.this.mPreloadHandler.g(1, convertStateToTabName, preloadDelay);
            }
        }
    };
    private bc mPreloadHandler = ((IHippyThread) QRoute.api(IHippyThread.class)).createQQHandler(new MyHandlerCallback());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.hippy.qq.preload.TabPreloadManager$5, reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] $SwitchMap$com$tencent$hippy$qq$api$TabPreloadItem$PreloadType;

        static {
            int[] iArr = new int[TabPreloadItem.PreloadType.values().length];
            $SwitchMap$com$tencent$hippy$qq$api$TabPreloadItem$PreloadType = iArr;
            try {
                iArr[TabPreloadItem.PreloadType.PRE_DRAW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$tencent$hippy$qq$api$TabPreloadItem$PreloadType[TabPreloadItem.PreloadType.PRE_LOAD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$tencent$hippy$qq$api$TabPreloadItem$PreloadType[TabPreloadItem.PreloadType.PRE_BASE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes7.dex */
    protected class MyHandlerCallback implements Handler.Callback {
        private volatile boolean isTabChanged = false;
        private volatile String lastTabName;

        public MyHandlerCallback() {
        }

        private boolean isTabChanged(String str) {
            if (this.isTabChanged) {
                return true;
            }
            if (str != null && this.lastTabName != null && !str.equals(this.lastTabName)) {
                this.isTabChanged = true;
                return true;
            }
            this.lastTabName = str;
            return false;
        }

        private void onMsgTabChanged(Message message) {
            String str = (String) message.obj;
            if (!isTabChanged(str)) {
                if (QLog.isDebugVersion()) {
                    QLog.d(TabPreloadManager.TAG, 4, "onMsgTabChanged tab has not changed");
                    return;
                }
                return;
            }
            if (MobileQQ.sProcessId == 1 && !TabPreloadItem.TAB_NAME_MESSAGE.equals(str)) {
                SSRManager.getInstance().updateSSRCommonJs();
                HippyQQLibraryManager.getInstance().downloadSo();
            }
            TabPreloadManager.this.onTabShow(str);
            if (MobileQQ.sProcessId == 1) {
                TabPreloadManager.this.checkForToolProcess(str);
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i3 = message.what;
            if (i3 != 1) {
                if (i3 != 2) {
                    return false;
                }
                TabPreloadManager.this.onPreload();
                return true;
            }
            onMsgTabChanged(message);
            return true;
        }
    }

    /* loaded from: classes7.dex */
    public static class MySSRBundleListener implements ISSRBundleRequester.OnGetSSRBundleListener {
        private String bundleName;
        private String url;

        public MySSRBundleListener(String str, String str2) {
            this.bundleName = str;
            this.url = str2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onGetSSRBundle$0(String str) {
            try {
                writeData(str);
            } catch (Throwable th5) {
                QLog.e(TabPreloadManager.TAG, 1, "onGetSSRBundle e:", th5);
            }
        }

        private void writeData(String str) {
            String str2 = HippyAccessHelper.getCurrentUin() + "_" + MD5Utils.toMD5(this.url);
            File businessDataDir = HippyQQFileUtil.getBusinessDataDir(this.bundleName);
            File file = new File(businessDataDir, str2);
            if (file.exists()) {
                file.delete();
            }
            File file2 = new File(businessDataDir, str2 + System.currentTimeMillis());
            FileUtils.writeFile(file2.getAbsolutePath(), str, false);
            if (!file2.exists()) {
                QLog.e(TabPreloadManager.TAG, 1, "MySSRBundleListener write file error:" + file);
                return;
            }
            if (!file2.renameTo(file)) {
                QLog.e(TabPreloadManager.TAG, 1, "MySSRBundleListener rename file error:" + file);
            }
        }

        @Override // com.tencent.hippy.qq.api.ISSRBundleRequester.OnGetSSRBundleListener
        public void onGetSSRBundle(int i3, String str, final String str2) {
            if (QLog.isColorLevel()) {
                QLog.d(TabPreloadManager.TAG, 2, "getSSRBundle code:", Integer.valueOf(i3), " msg:", str, " isJsEmpty:", Boolean.valueOf(TextUtils.isEmpty(str2)));
            }
            if (!TextUtils.isEmpty(str2)) {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.hippy.qq.preload.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        TabPreloadManager.MySSRBundleListener.this.lambda$onGetSSRBundle$0(str2);
                    }
                }, 64, null, false);
            }
        }
    }

    TabPreloadManager() {
        BaseApplication.getContext().getApplicationContext().registerComponentCallbacks(this.mComponentCallbacks);
        ThemeChangedReceiver themeChangedReceiver = new ThemeChangedReceiver();
        this.mThemeChangedReceiver = themeChangedReceiver;
        themeChangedReceiver.setListener(this);
    }

    public static boolean canUsePreloadedEngine(HippyQQPreloadEngine hippyQQPreloadEngine, String str, int i3) {
        DisplayMetrics displayMetrics;
        int i16;
        if (hippyQQPreloadEngine.getPreloadModuleVersion() != ((IHippySetting) QRoute.api(IHippySetting.class)).getModuleVersion(str) || hippyQQPreloadEngine.getPreloadModuleVersion() < i3) {
            return false;
        }
        if (hippyQQPreloadEngine.isPredraw() && hippyQQPreloadEngine.getPredrawHippyWidth() > 0 && (displayMetrics = HippyUtils.getDisplayMetrics()) != null && (i16 = displayMetrics.widthPixels) > 0 && i16 != hippyQQPreloadEngine.getPredrawHippyWidth()) {
            return false;
        }
        return true;
    }

    public static boolean checkHippyEngine(HippyQQPreloadEngine hippyQQPreloadEngine, String str, String str2) {
        if (isAccountChanged(str)) {
            QLog.e(TAG, 1, "doPreload onSuccess uin changed.");
            hippyQQPreloadEngine.destroyEngineImmediately(HippyReporter.RemoveEngineReason.ACCOUNT_CHANGED);
            return false;
        }
        if (!isThemeChanged(str2)) {
            return true;
        }
        QLog.e(TAG, 1, "doPreload onSuccess theme changed.");
        hippyQQPreloadEngine.destroyEngineImmediately(HippyReporter.RemoveEngineReason.THEME_CHANGED);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String convertStateToTabName(String str) {
        if (str == null) {
            return null;
        }
        if (str.equals(MainState.MAIN_STATE_MESSAGE_TAB_SHOW)) {
            return TabPreloadItem.TAB_NAME_MESSAGE;
        }
        if (str.equals(MainState.MAIN_STATE_CONTACTS_TAB_SHOW)) {
            return "contacts";
        }
        if (str.equals(MainState.MAIN_STATE_KANDIAN_TAB_SHOW)) {
            return TabPreloadItem.TAB_NAME_KANDIAN;
        }
        if (!str.equals(MainState.MAIN_STATE_DYNAMIC_TAB_SHOW) && !str.equals(MainState.MAIN_STATE_QZONE_TAB_SHOW)) {
            if (!str.equals(MainState.MAIN_STATE_DRAWER_TAB_SHOW)) {
                return null;
            }
            return "drawer";
        }
        return TabPreloadItem.TAB_NAME_DYNAMIC;
    }

    private TabPreloadItem createTabPreloadItem(OpenHippyInfo openHippyInfo) {
        String str;
        TabPreloadItem tabPreloadItem = new TabPreloadItem();
        tabPreloadItem.bundleName = openHippyInfo.bundleName;
        tabPreloadItem.domain = openHippyInfo.domain;
        tabPreloadItem.preloadProcess = "local";
        tabPreloadItem.preloadType = openHippyInfo.preloadType;
        if (TextUtils.isEmpty(openHippyInfo.framework)) {
            str = HippyQQConstants.HIPPY_VUE;
        } else {
            str = openHippyInfo.framework;
        }
        tabPreloadItem.preloadFramework = str;
        if (openHippyInfo.preloadType == TabPreloadItem.PreloadType.PRE_BASE) {
            tabPreloadItem.bundleName = "";
            tabPreloadItem.domain = "";
        }
        return tabPreloadItem;
    }

    private void doPreLoad(String str) {
        synchronized (this.mPreloadDataLock) {
            ArrayList arrayList = new ArrayList();
            Iterator<TabPreloadInfo> it = this.mPreloadWaitList.iterator();
            while (it.hasNext()) {
                TabPreloadInfo next = it.next();
                if (next.mPreloadItem.isAdPreload()) {
                    arrayList.add(next);
                }
            }
            this.mPreloadWaitList.clear();
            this.mPreloadWaitList.addAll(arrayList);
            logPreloadInfoList("preloaded list", this.mPreloadedList);
            clearOtherTabPreloads(str);
            List<TabPreloadItem> needPreloads = getNeedPreloads(str, getCurrentProcessName());
            if (needPreloads.size() > 0) {
                for (int i3 = 0; i3 < needPreloads.size(); i3++) {
                    if (!isPreloaded(needPreloads.get(i3))) {
                        TabPreloadInfo tabPreloadInfo = new TabPreloadInfo(str, needPreloads.get(i3));
                        this.mPreloadWaitList.add(tabPreloadInfo);
                        if (QLog.isDebugVersion()) {
                            QLog.i(TAG, 4, "add wait list, preloadInfo:" + tabPreloadInfo);
                        }
                    }
                }
                if (!this.mIsPreloading) {
                    this.mIsPreloading = true;
                    this.mPreloadHandler.removeMessages(2);
                    this.mPreloadHandler.sendEmptyMessage(2);
                }
            }
        }
    }

    private void doPreRequest(String str) {
        List<TabPreloadItem> itemsOfTab = HippyPredownloadManager.getInstance().getTabPreloadConfigManager().getItemsOfTab(str, (String) null, TabPreloadItem.PreloadType.PRE_REQUEST);
        for (int i3 = 0; i3 < itemsOfTab.size(); i3++) {
            TabPreloadItem tabPreloadItem = itemsOfTab.get(i3);
            if (tabPreloadItem.preRequestList != null) {
                long preRequestTime = getPreRequestTime(tabPreloadItem.bundleName);
                long serverTime = NetConnInfoCenter.getServerTime();
                if (serverTime <= preRequestTime || serverTime - preRequestTime >= tabPreloadItem.preUpdateInterval) {
                    setPreRequestTime(tabPreloadItem.bundleName, serverTime);
                    for (int i16 = 0; i16 < tabPreloadItem.preRequestList.size(); i16++) {
                        ISSRBundleRequester createSSRBundleRequester = ((IHippySSR) QRoute.api(IHippySSR.class)).createSSRBundleRequester();
                        OpenHippyInfo openHippyInfo = new OpenHippyInfo();
                        String str2 = tabPreloadItem.preRequestList.get(i16).url;
                        openHippyInfo.ssrBundleUrl = str2;
                        openHippyInfo.domain = tabPreloadItem.domain;
                        String str3 = tabPreloadItem.bundleName;
                        openHippyInfo.bundleName = str3;
                        createSSRBundleRequester.setSSRBundleListener(new MySSRBundleListener(str3, str2)).setRequestFrom(ISSRBundleRequester.FROM_PREREQUEST).requestSSRBundle(getBaseHttpAdapter(), openHippyInfo);
                    }
                }
            }
        }
    }

    private void doPreUpdate(String str) {
        List<TabPreloadItem> itemsOfTab = HippyPredownloadManager.getInstance().getTabPreloadConfigManager().getItemsOfTab(str, (String) null, TabPreloadItem.PreloadType.PRE_UPDATE);
        for (int i3 = 0; i3 < itemsOfTab.size(); i3++) {
            TabPreloadItem tabPreloadItem = itemsOfTab.get(i3);
            if (!HippyUpdateManager.getInstance().checkUpdateJsBundleInterval(tabPreloadItem.bundleName, tabPreloadItem.preUpdateInterval)) {
                if (QLog.isDebugVersion()) {
                    QLog.i(TAG, 4, "pre-download bundleName:" + tabPreloadItem.bundleName + " too soon!");
                }
            } else {
                Bundle bundle = new Bundle();
                bundle.putBoolean(IHippyUpdate.EXTRA_KEY_IS_SKIP_INTERVAL, true);
                HippyUpdateManager.getInstance().updateJsBundle(tabPreloadItem.bundleName, ((IQQGameConfigUtil) QRoute.api(IQQGameConfigUtil.class)).isUpdateHippyJsBundleByHttp(), 4, bundle, null);
                if (QLog.isDebugVersion()) {
                    QLog.i(TAG, 4, "pre-download bundleName:" + tabPreloadItem.bundleName);
                }
            }
        }
    }

    private void doReportPskey() {
        ((IQQGameAdService) QRoute.api(IQQGameAdService.class)).pullAd(1);
    }

    private Pair<String, TabPreloadItem> findTabPreloadItem(OpenHippyInfo openHippyInfo, String str) {
        TabPreloadItem tabPreloadItem;
        String str2;
        HashMap hashMap = new HashMap();
        Map<String, ArrayList<TabPreloadItem>> tabPreloadConfig = HippyPredownloadManager.getInstance().getTabPreloadConfigManager().getTabPreloadConfig();
        if (tabPreloadConfig == null) {
            return null;
        }
        for (String str3 : tabPreloadConfig.keySet()) {
            ArrayList<TabPreloadItem> arrayList = tabPreloadConfig.get(str3);
            if (arrayList != null) {
                int i3 = 0;
                while (true) {
                    if (i3 >= arrayList.size()) {
                        break;
                    }
                    TabPreloadItem tabPreloadItem2 = arrayList.get(i3);
                    if (tabPreloadItem2 != null) {
                        if (openHippyInfo.preloadType == TabPreloadItem.PreloadType.PRE_BASE) {
                            if (tabPreloadItem2.isPreloadBase() && tabPreloadItem2.getProcessId() == MobileQQ.sProcessId && (str2 = tabPreloadItem2.preloadFramework) != null && str2.equals(openHippyInfo.framework)) {
                                hashMap.put(str3, tabPreloadItem2);
                                break;
                            }
                        } else if (openHippyInfo.bundleName.equals(tabPreloadItem2.bundleName)) {
                            hashMap.put(str3, tabPreloadItem2);
                            break;
                        }
                    }
                    i3++;
                }
            }
        }
        if (TextUtils.isEmpty(str)) {
            tabPreloadItem = null;
            str = null;
        } else {
            tabPreloadItem = (TabPreloadItem) hashMap.get(str);
        }
        if (tabPreloadItem == null) {
            Iterator it = hashMap.keySet().iterator();
            if (it.hasNext()) {
                str = (String) it.next();
                tabPreloadItem = (TabPreloadItem) hashMap.get(str);
            }
        }
        if (tabPreloadItem != null) {
            return new Pair<>(str, tabPreloadItem);
        }
        return null;
    }

    private String generatePreloadFrom(TabPreloadInfo tabPreloadInfo) {
        if (tabPreloadInfo.mPreloadItem.hasRedDotCondition()) {
            return "tab_reddot";
        }
        if (tabPreloadInfo.mPreloadItem.isAdPreload()) {
            return "tab_ad";
        }
        return "tab_" + tabPreloadInfo.mPreloadTab;
    }

    private IBaseHttpAdapter getBaseHttpAdapter() {
        if (this.mHttpAdapter == null) {
            this.mHttpAdapter = ((IBaseHttpAdapterFactory) QRoute.api(IBaseHttpAdapterFactory.class)).create(HippyUtils.enableHttp2());
        }
        return this.mHttpAdapter;
    }

    public static TabPreloadManager getInstance() {
        if (sTabPreloadManager == null) {
            synchronized (TabPreloadManager.class) {
                if (sTabPreloadManager == null) {
                    sTabPreloadManager = new TabPreloadManager();
                    ((IStateManager) QRoute.api(IStateManager.class)).addMainStateObserver(sTabPreloadManager.mMainTabStateObserver);
                }
            }
        }
        return sTabPreloadManager;
    }

    private static long getKuiklyPreUpdateTime(String str) {
        return QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeLong(MMKVCommonFileKeys.TAB_KUIKLY_PREUPDATE_TIME_PREFIX + str + HippyAccessHelper.getCurrentUin(), 0L);
    }

    private static long getOfflineResPreUpdateTime(String str) {
        return QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeLong(MMKVCommonFileKeys.TAB_OFFLINE_RES_UPDATETIME_PREFIX + str + HippyAccessHelper.getCurrentUin(), 0L);
    }

    private static long getPreRequestTime(String str) {
        return QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeLong(MMKVCommonFileKeys.TAB_PREREQUEST_TIME_PREFIX + str + HippyAccessHelper.getCurrentUin(), 0L);
    }

    protected static boolean isAccountChanged(String str) {
        String account;
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (waitAppRuntime == null) {
            account = "";
        } else {
            account = waitAppRuntime.getAccount();
        }
        if (str != null && !str.equals(account)) {
            return true;
        }
        return false;
    }

    protected static boolean isThemeChanged(String str) {
        if (str != null && !str.equals(QQTheme.getCurrentThemeId())) {
            return true;
        }
        return false;
    }

    private void logPreloadInfoList(String str, List<TabPreloadInfo> list) {
        if (!QLog.isDebugVersion()) {
            return;
        }
        synchronized (this.mPreloadedList) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str);
            sb5.append(":[");
            Iterator<TabPreloadInfo> it = list.iterator();
            while (it.hasNext()) {
                sb5.append(it.next().toString());
                sb5.append(',');
            }
            sb5.append("]");
            QLog.i(TAG, 4, sb5.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPreloadFinish() {
        logPreloadInfoList("wait list", this.mPreloadWaitList);
        this.mPreloadHandler.removeMessages(2);
        this.mPreloadHandler.sendEmptyMessage(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onTabShow(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (QLog.isDebugVersion()) {
            QLog.i(TAG, 4, "onTabShow tabName:" + str);
        }
        this.mCurTabName = str;
        doPreLoad(str);
        doReportPskey();
        if (MobileQQ.sProcessId == 1) {
            doPreUpdate(str);
            doPreKuiklyUpdate(str);
            doPreOfflineResUpdate(str);
        }
        if (MobileQQ.sProcessId == 1) {
            doPreRequest(str);
        }
    }

    private boolean preloadOneItem(final TabPreloadInfo tabPreloadInfo) {
        TabPreloadItem tabPreloadItem;
        String account;
        if (tabPreloadInfo != null && (tabPreloadItem = tabPreloadInfo.mPreloadItem) != null && tabPreloadItem.checkData()) {
            if (((IHippySetting) QRoute.api(IHippySetting.class)).isClearingCache()) {
                QLog.d(TAG, 1, "doPreload skip because of QQ-Clearer is clearing hippy cache");
                onPreloadFinish();
                return false;
            }
            TabPreloadItem tabPreloadItem2 = tabPreloadInfo.mPreloadItem;
            String str = tabPreloadItem2.bundleName;
            QLog.d(TAG, 1, "preloadOneItem preloadInfo:" + tabPreloadInfo);
            if (tabPreloadItem2.preloadType == TabPreloadItem.PreloadType.PRE_DRAW && HippyUtils.isPadOrFoldDevice()) {
                tabPreloadItem2.preloadType = TabPreloadItem.PreloadType.PRE_LOAD;
            }
            AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
            JSONObject jSInitData = HippyAccessHelper.getJSInitData(waitAppRuntime, str, null, tabPreloadItem2.domain, null);
            if (jSInitData == null) {
                jSInitData = new JSONObject();
            }
            OpenHippyInfo openHippyInfo = new OpenHippyInfo();
            tabPreloadItem2.fillParameters(openHippyInfo);
            HippyAccessHelper.addPreloadParameters(jSInitData, openHippyInfo);
            final String currentThemeId = QQTheme.getCurrentThemeId();
            if (waitAppRuntime == null) {
                account = "";
            } else {
                account = waitAppRuntime.getAccount();
            }
            final String str2 = account;
            final HippyQQPreloadEngine hippyQQPreloadEngine = new HippyQQPreloadEngine(null, str, null);
            hippyQQPreloadEngine.setSwitchProcessTimeCost(this.mSwitchToolProcessTimeCost);
            hippyQQPreloadEngine.setOpenHippyInfo(openHippyInfo);
            hippyQQPreloadEngine.setInitData(jSInitData, jSInitData);
            hippyQQPreloadEngine.checkLoginState(jSInitData, !TextUtils.isEmpty(tabPreloadItem2.domain));
            hippyQQPreloadEngine.setJsBundleType(tabPreloadItem2.preloadFramework);
            hippyQQPreloadEngine.setPreloadFrom(generatePreloadFrom(tabPreloadInfo));
            synchronized (this.mPreloadDataLock) {
                this.mPreloadingEngine = hippyQQPreloadEngine;
            }
            HippyQQEngine.HippyQQEngineListener hippyQQEngineListener = new HippyQQEngine.HippyQQEngineListener() { // from class: com.tencent.hippy.qq.preload.TabPreloadManager.2
                @Override // com.tencent.hippy.qq.app.HippyQQEngine.HippyQQEngineListener
                public void onError(int i3, String str3) {
                    QLog.e(TabPreloadManager.TAG, 1, "preloadOneItem onError statusCode:" + i3 + " msg:" + str3 + " preloadInfo:" + tabPreloadInfo);
                    synchronized (TabPreloadManager.this.mPreloadDataLock) {
                        TabPreloadManager.this.mPreloadingEngine = null;
                    }
                    hippyQQPreloadEngine.destroyEngineImmediately(HippyReporter.RemoveEngineReason.PRELOAD_ERROR);
                    TabPreloadManager.this.onPreloadFinish();
                }

                @Override // com.tencent.hippy.qq.app.HippyQQEngine.HippyQQEngineListener
                public void onSuccess() {
                    QLog.i(TabPreloadManager.TAG, 1, "preloadOneItem onSuccess, preloadInfo:" + tabPreloadInfo);
                    synchronized (TabPreloadManager.this.mPreloadDataLock) {
                        TabPreloadManager.this.mPreloadingEngine = null;
                    }
                    if (TabPreloadManager.checkHippyEngine(hippyQQPreloadEngine, str2, currentThemeId)) {
                        synchronized (TabPreloadManager.this.mPreloadDataLock) {
                            TabPreloadInfo tabPreloadInfo2 = tabPreloadInfo;
                            tabPreloadInfo2.mHippyEngine = hippyQQPreloadEngine;
                            tabPreloadInfo2.mPreloadTime = System.currentTimeMillis() / 1000;
                            TabPreloadManager.this.mPreloadedList.add(tabPreloadInfo);
                        }
                        TabPreloadManager.this.onPreloadFinish();
                    }
                }
            };
            int i3 = AnonymousClass5.$SwitchMap$com$tencent$hippy$qq$api$TabPreloadItem$PreloadType[tabPreloadItem2.preloadType.ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        hippyQQPreloadEngine.preloadBaseHippy(hippyQQEngineListener, tabPreloadItem2.preloadFramework, tabPreloadInfo.mPreloadScene);
                    }
                } else {
                    hippyQQPreloadEngine.preloadHippy(hippyQQEngineListener, tabPreloadItem2.needCheckPreload, tabPreloadInfo.mPreloadScene);
                }
            } else {
                hippyQQPreloadEngine.predrawHippy(hippyQQEngineListener, tabPreloadItem2.needCheckPreload, tabPreloadInfo.mPreloadScene);
            }
            return true;
        }
        QLog.d(TAG, 1, "doPreload parameters error");
        onPreloadFinish();
        return false;
    }

    private TabPreloadInfo removePreloadBaseEngine(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.mPreloadDataLock) {
            for (int i3 = 0; i3 < this.mPreloadedList.size(); i3++) {
                TabPreloadInfo tabPreloadInfo = this.mPreloadedList.get(i3);
                HippyQQPreloadEngine hippyQQPreloadEngine = tabPreloadInfo.mHippyEngine;
                if (hippyQQPreloadEngine != null && hippyQQPreloadEngine.isPreloadBase() && str.equals(tabPreloadInfo.mHippyEngine.getJsBundleType())) {
                    this.mPreloadedList.remove(i3);
                    return tabPreloadInfo;
                }
            }
            return null;
        }
    }

    private TabPreloadInfo removePreloadEngine(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.mPreloadDataLock) {
            for (int i3 = 0; i3 < this.mPreloadedList.size(); i3++) {
                TabPreloadInfo tabPreloadInfo = this.mPreloadedList.get(i3);
                HippyQQPreloadEngine hippyQQPreloadEngine = tabPreloadInfo.mHippyEngine;
                if (hippyQQPreloadEngine != null && str.equals(hippyQQPreloadEngine.getModuleName())) {
                    this.mPreloadedList.remove(i3);
                    return tabPreloadInfo;
                }
            }
            return null;
        }
    }

    private static void setKuiklyPreUpdateTime(String str, long j3) {
        QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").encodeLong(MMKVCommonFileKeys.TAB_KUIKLY_PREUPDATE_TIME_PREFIX + str + HippyAccessHelper.getCurrentUin(), j3);
    }

    private static void setOfflineResPreUpdateTime(String str, long j3) {
        QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").encodeLong(MMKVCommonFileKeys.TAB_OFFLINE_RES_UPDATETIME_PREFIX + str + HippyAccessHelper.getCurrentUin(), j3);
    }

    private static void setPreRequestTime(String str, long j3) {
        QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").encodeLong(MMKVCommonFileKeys.TAB_PREREQUEST_TIME_PREFIX + str + HippyAccessHelper.getCurrentUin(), j3);
    }

    protected void checkForToolProcess(String str) {
        boolean z16;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        List<TabPreloadItem> needPreloads = getNeedPreloads(str, "tool");
        if (needPreloads.size() <= 0 && !this.mHasPreloadInToolProcess) {
            return;
        }
        if (needPreloads.size() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.mHasPreloadInToolProcess = z16;
        Intent intent = new Intent();
        intent.putExtra(IHippyIPC.KEY_IS_PRELOAD_HIPPY, true);
        intent.putExtra(IHippyIPC.KEY_SHOW_TAB_NAME, str);
        intent.putExtra(OpenHippyInfo.EXTRA_KEY_CALL_API_TIME, System.currentTimeMillis());
        HippyUtils.startToolProcess(intent);
    }

    protected void clearAllPreloads(String str) {
        String str2 = TAG;
        QLog.e(str2, 1, "clearAllPreloads from:", str);
        this.mIsPreloading = false;
        this.mPreloadHandler.removeAll();
        ArrayList arrayList = new ArrayList();
        synchronized (this.mPreloadDataLock) {
            HippyQQPreloadEngine hippyQQPreloadEngine = this.mPreloadingEngine;
            if (hippyQQPreloadEngine != null) {
                hippyQQPreloadEngine.cancelPreload();
                QLog.d(str2, 1, "clearAllPreloads cancel preload from:", str, " bundle:", this.mPreloadingEngine.getModuleName());
            }
            this.mPreloadWaitList.clear();
            arrayList.addAll(this.mPreloadedList);
            this.mPreloadedList.clear();
        }
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            ((TabPreloadInfo) arrayList.get(i3)).destroyHippyEngine(str);
            QLog.d(TAG, 1, "clearAllPreloads remove preload from:", str, " item:", ((TabPreloadInfo) arrayList.get(i3)).mPreloadItem);
        }
    }

    protected void clearOtherTabPreloads(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        List<TabPreloadItem> needPreloads = getNeedPreloads(str, getCurrentProcessName());
        for (int size = this.mPreloadedList.size() - 1; size >= 0; size--) {
            int i3 = 0;
            while (true) {
                if (i3 < needPreloads.size()) {
                    TabPreloadItem tabPreloadItem = this.mPreloadedList.get(size).mPreloadItem;
                    TabPreloadItem tabPreloadItem2 = needPreloads.get(i3);
                    if (tabPreloadItem.isPreloadBase()) {
                        if (isBasePreloadItemEquals(tabPreloadItem, tabPreloadItem2)) {
                            break;
                        } else {
                            i3++;
                        }
                    } else if (tabPreloadItem.bundleName.equals(tabPreloadItem2.bundleName)) {
                        break;
                    } else {
                        i3++;
                    }
                } else if (!str.equals(this.mPreloadedList.get(size).mPreloadTab) && this.mPreloadedList.get(size).isLifeEnd()) {
                    TabPreloadInfo remove = this.mPreloadedList.remove(size);
                    remove.destroyHippyEngine("tab_" + str);
                    if (QLog.isDebugVersion()) {
                        QLog.i(TAG, 4, "clear other tab, preloadInfo:" + remove);
                    }
                }
            }
        }
    }

    public void destroyPreloadBaseEngine(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.mPreloadDataLock) {
            HippyQQPreloadEngine hippyQQPreloadEngine = this.mPreloadingEngine;
            if (hippyQQPreloadEngine != null && hippyQQPreloadEngine.isPreloadBase() && str.equals(this.mPreloadingEngine.getJsBundleType())) {
                this.mPreloadingEngine.cancelPreload();
            }
        }
        TabPreloadInfo removePreloadBaseEngine = removePreloadBaseEngine(str);
        if (removePreloadBaseEngine != null) {
            removePreloadBaseEngine.mHippyEngine.destroyEngineImmediately(str2);
        }
    }

    public void destroyPreloadEngine(String str, String str2) {
        synchronized (this.mPreloadDataLock) {
            HippyQQPreloadEngine hippyQQPreloadEngine = this.mPreloadingEngine;
            if (hippyQQPreloadEngine != null && str.equals(hippyQQPreloadEngine.getModuleName())) {
                this.mPreloadingEngine.cancelPreload();
            }
        }
        TabPreloadInfo removePreloadEngine = removePreloadEngine(str);
        if (removePreloadEngine != null) {
            removePreloadEngine.mHippyEngine.destroyEngineImmediately(str2);
        }
    }

    public void doPreKuiklyUpdate(String str) {
        List<KuiklyTabPreloadItem> kuiklyItemsOfTab = HippyPredownloadManager.getInstance().getTabPreloadConfigManager().getKuiklyItemsOfTab(str, KuiklyTabPreloadItem.PreloadType.PRE_DOWNLOAD);
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < kuiklyItemsOfTab.size(); i3++) {
            KuiklyTabPreloadItem kuiklyTabPreloadItem = kuiklyItemsOfTab.get(i3);
            long kuiklyPreUpdateTime = getKuiklyPreUpdateTime(kuiklyTabPreloadItem.getResId());
            long serverTime = NetConnInfoCenter.getServerTime();
            if (serverTime > kuiklyPreUpdateTime && serverTime - kuiklyPreUpdateTime < kuiklyTabPreloadItem.getDownloadTimeGapMin() * 60) {
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 1, "QQKuiklyResUpdate doPreKuiklyUpdate curTabName:" + str + ", bundleName:" + kuiklyTabPreloadItem.getResId() + ", too soon! it's on time gap minutes:" + kuiklyTabPreloadItem.getDownloadTimeGapMin() + ",lastTime:" + kuiklyPreUpdateTime);
                }
            } else {
                setKuiklyPreUpdateTime(kuiklyTabPreloadItem.getResId(), serverTime);
                arrayList.add(kuiklyTabPreloadItem.getResId());
                QLog.i(TAG, 1, "QQKuiklyResUpdate doPreKuiklyUpdate start update curTabName:" + str + ", bundleName:" + kuiklyTabPreloadItem);
            }
        }
        if (arrayList.size() > 0) {
            ((IQQKuiklyDexResApi) QRoute.api(IQQKuiklyDexResApi.class)).updateMultiDexRes(arrayList, null);
        }
    }

    public void doPreOfflineResUpdate(String str) {
        List<String> offlineResOfTab = HippyPredownloadManager.getInstance().getTabPreloadConfigManager().getOfflineResOfTab(str);
        int updateOfflineResGap = HippyPredownloadManager.getInstance().getTabPreloadConfigManager().getUpdateOfflineResGap();
        final ArrayList arrayList = new ArrayList();
        QLog.i(TAG, 1, "doPreOfflineResUpdate curTabName=" + str + ",gapMin:" + updateOfflineResGap + ", needPreUpdates len:" + offlineResOfTab.size());
        for (String str2 : offlineResOfTab) {
            long offlineResPreUpdateTime = getOfflineResPreUpdateTime(str2);
            long serverTime = NetConnInfoCenter.getServerTime();
            if (serverTime > offlineResPreUpdateTime && serverTime - offlineResPreUpdateTime < updateOfflineResGap * 60) {
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 1, "doPreOfflineResUpdate curTabName:" + str + ", resId:" + str2 + ", too soon! it's on time gap minutes:" + updateOfflineResGap + ",lastTime:" + offlineResPreUpdateTime);
                }
            } else {
                setOfflineResPreUpdateTime(str2, serverTime);
                arrayList.add(str2);
                QLog.i(TAG, 1, "doPreOfflineResUpdate start update curTabName:" + str + ", resId:" + str2);
            }
        }
        if (arrayList.size() > 0) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.hippy.qq.preload.TabPreloadManager.1
                @Override // java.lang.Runnable
                public void run() {
                    for (final String str3 : arrayList) {
                        HtmlOffline.j(str3, MobileQQ.sMobileQQ.peekAppRuntime(), true, new com.tencent.biz.common.offline.a() { // from class: com.tencent.hippy.qq.preload.TabPreloadManager.1.1
                            @Override // com.tencent.biz.common.offline.a
                            public void loaded(String str4, int i3) {
                                if (QLog.isColorLevel()) {
                                    QLog.d(TabPreloadManager.TAG, 2, "doPreOfflineResUpdate loaded resId=" + str3 + ",code:" + i3);
                                }
                            }

                            @Override // com.tencent.biz.common.offline.a
                            public void progress(int i3) {
                            }
                        });
                    }
                }
            }, 128, null, true);
        }
    }

    protected String getCurrentProcessName() {
        int i3 = MobileQQ.sProcessId;
        if (i3 != 1) {
            if (i3 != 7) {
                return "unknown";
            }
            return "tool";
        }
        return "main";
    }

    public long getDynamicTabShowTime() {
        return this.mDynamicTabShowTime;
    }

    protected List<TabPreloadItem> getNeedPreloads(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(TabPreloadItem.PreloadType.PRE_DRAW);
        arrayList.add(TabPreloadItem.PreloadType.PRE_LOAD);
        arrayList.add(TabPreloadItem.PreloadType.PRE_BASE);
        return HippyPredownloadManager.getInstance().getTabPreloadConfigManager().getItemsOfTab(str, str2, arrayList);
    }

    public HippyQQPreloadEngine getPreloadBaseEngine(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.mPreloadDataLock) {
            for (int i3 = 0; i3 < this.mPreloadedList.size(); i3++) {
                TabPreloadInfo tabPreloadInfo = this.mPreloadedList.get(i3);
                HippyQQPreloadEngine hippyQQPreloadEngine = tabPreloadInfo.mHippyEngine;
                if (hippyQQPreloadEngine != null && hippyQQPreloadEngine.isPreloadBase() && str.equals(tabPreloadInfo.mHippyEngine.getJsBundleType())) {
                    this.mPreloadedList.remove(i3);
                    if (QLog.isDebugVersion()) {
                        QLog.i(TAG, 4, "Use an engine preloaded base, preloadInfo:" + tabPreloadInfo);
                    }
                    return tabPreloadInfo.mHippyEngine;
                }
            }
            return null;
        }
    }

    public HippyQQPreloadEngine getPreloadEngine(String str, int i3) {
        TabPreloadInfo removePreloadEngine = removePreloadEngine(str);
        if (removePreloadEngine == null) {
            return null;
        }
        if (QLog.isDebugVersion()) {
            QLog.i(TAG, 4, "Use an engine, preloadInfo:" + removePreloadEngine);
        }
        if (canUsePreloadedEngine(removePreloadEngine.mHippyEngine, str, i3)) {
            return removePreloadEngine.mHippyEngine;
        }
        removePreloadEngine.mHippyEngine.destroyEngineImmediately(HippyReporter.RemoveEngineReason.INVALID);
        return null;
    }

    public String getPreloadingStep(String str) {
        HippyQQPreloadEngine hippyQQPreloadEngine = this.mPreloadingEngine;
        if (hippyQQPreloadEngine != null && str.equals(hippyQQPreloadEngine.getModuleName())) {
            return this.mPreloadingEngine.getPreloadStep();
        }
        return null;
    }

    public StateObserver getStateObserver() {
        return this.mMainTabStateObserver;
    }

    public boolean hasNewMessage(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            HippyInterpolator interpolator = HippyInterpolatorConfig.getInterpolator(str);
            if (interpolator == null) {
                return false;
            }
            if (!interpolator.hasNewMessage()) {
                return false;
            }
            return true;
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "hasNewMessage error:" + th5);
            return false;
        }
    }

    protected boolean isBasePreloadItemEquals(TabPreloadItem tabPreloadItem, TabPreloadItem tabPreloadItem2) {
        String str;
        if (tabPreloadItem.isPreloadBase() && tabPreloadItem2.isPreloadBase() && (str = tabPreloadItem.preloadFramework) != null && str.equals(tabPreloadItem2.preloadFramework)) {
            return true;
        }
        return false;
    }

    public boolean isCanPreload(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            HippyInterpolator interpolator = HippyInterpolatorConfig.getInterpolator(str);
            if (interpolator != null) {
                if (!interpolator.isCanPreload()) {
                    return false;
                }
            }
            return true;
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "isCanPreload error:" + th5);
            return false;
        }
    }

    public boolean isInTabPreload(String str) {
        Map<String, ArrayList<TabPreloadItem>> tabPreloadConfig;
        if (TextUtils.isEmpty(str) || !isCanPreload(str) || (tabPreloadConfig = HippyPredownloadManager.getInstance().getTabPreloadConfigManager().getTabPreloadConfig()) == null) {
            return false;
        }
        for (ArrayList<TabPreloadItem> arrayList : tabPreloadConfig.values()) {
            if (arrayList != null) {
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    if (arrayList.get(i3) != null && str.equals(arrayList.get(i3).bundleName)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    protected boolean isPreloaded(TabPreloadItem tabPreloadItem) {
        if (tabPreloadItem == null) {
            return false;
        }
        for (int i3 = 0; i3 < this.mPreloadedList.size(); i3++) {
            TabPreloadItem tabPreloadItem2 = this.mPreloadedList.get(i3).mPreloadItem;
            if (tabPreloadItem.isPreloadBase()) {
                if (isBasePreloadItemEquals(tabPreloadItem, tabPreloadItem2)) {
                    return true;
                }
            } else if (tabPreloadItem.bundleName.equals(tabPreloadItem2.bundleName)) {
                return true;
            }
        }
        return false;
    }

    protected boolean isWaitingPreload(TabPreloadItem tabPreloadItem) {
        if (tabPreloadItem == null) {
            return false;
        }
        for (int i3 = 0; i3 < this.mPreloadWaitList.size(); i3++) {
            TabPreloadItem tabPreloadItem2 = this.mPreloadWaitList.get(i3).mPreloadItem;
            if (tabPreloadItem.isPreloadBase()) {
                if (isBasePreloadItemEquals(tabPreloadItem, tabPreloadItem2)) {
                    return true;
                }
            } else if (tabPreloadItem.bundleName.equals(tabPreloadItem2.bundleName)) {
                return true;
            }
        }
        return false;
    }

    public boolean manuallyPreload(String str, TabPreloadItem tabPreloadItem, int i3) {
        if (tabPreloadItem == null) {
            QLog.d(TAG, 1, "manuallyPreload item is null");
            return false;
        }
        synchronized (this.mPreloadDataLock) {
            if (!isWaitingPreload(tabPreloadItem) && !isPreloaded(tabPreloadItem)) {
                TabPreloadInfo tabPreloadInfo = new TabPreloadInfo(str, tabPreloadItem);
                tabPreloadInfo.mPreloadScene = i3;
                if (tabPreloadItem.isAdPreload()) {
                    this.mPreloadWaitList.add(0, tabPreloadInfo);
                } else {
                    this.mPreloadWaitList.add(tabPreloadInfo);
                }
                if (!this.mIsPreloading) {
                    this.mIsPreloading = true;
                    this.mPreloadHandler.removeMessages(2);
                    this.mPreloadHandler.sendEmptyMessage(2);
                }
                return true;
            }
            return true;
        }
    }

    public void onAppDestroy() {
        clearAllPreloads("logout");
    }

    public void onClearHippyCache() {
        clearAllPreloads(HippyReporter.RemoveEngineReason.CLEAR_CACHE);
    }

    protected void onPreload() {
        TabPreloadInfo tabPreloadInfo;
        synchronized (this.mPreloadDataLock) {
            TabPreloadConfigManager tabPreloadConfigManager = HippyPredownloadManager.getInstance().getTabPreloadConfigManager();
            while (true) {
                if (this.mPreloadWaitList.size() > 0) {
                    tabPreloadInfo = this.mPreloadWaitList.remove(0);
                    if (isPreloaded(tabPreloadInfo.mPreloadItem)) {
                        if (QLog.isDebugVersion()) {
                            QLog.i(TAG, 4, "has been preloaded, preloadInfo:" + tabPreloadInfo);
                        }
                    } else {
                        if (this.mPreloadedList.size() < tabPreloadConfigManager.getPreloadMaxCount()) {
                            break;
                        }
                        if (tabPreloadInfo.mPreloadScene == 1) {
                            QLog.i(TAG, 1, "count limit:" + tabPreloadConfigManager.getPreloadMaxCount());
                        } else {
                            TabPreloadInfo remove = this.mPreloadedList.remove(0);
                            remove.destroyHippyEngine(DESTROY_ENGINE_FROM_MANUAL);
                            if (QLog.isDebugVersion()) {
                                QLog.i(TAG, 4, "destroy when manually preload, preloadInfo:" + remove);
                            }
                        }
                    }
                } else {
                    tabPreloadInfo = null;
                    break;
                }
            }
            if (tabPreloadInfo == null) {
                this.mIsPreloading = false;
            } else {
                this.mIsPreloading = true;
                preloadOneItem(tabPreloadInfo);
            }
        }
    }

    public void onTabChangeForTool(String str) {
        Bundle bundle;
        bc bcVar;
        EIPCResult callServer = QIPCClientHelper.getInstance().callServer(IHippyIPC.NAME, IHippyIPC.ACTION_GET_MAIN_STATE, null);
        if (callServer != null && (bundle = callServer.data) != null) {
            String convertStateToTabName = convertStateToTabName(bundle.getString(IHippyIPC.KEY_CURRENT_MAIN_STATE));
            if (!TextUtils.isEmpty(convertStateToTabName) && convertStateToTabName.equals(str) && (bcVar = this.mPreloadHandler) != null) {
                bcVar.removeMessages(1);
                this.mPreloadHandler.a(1, convertStateToTabName);
            }
        }
    }

    @Override // com.tencent.hippy.qq.preload.ThemeChangedReceiver.Listener
    public void onThemeChanged() {
        clearAllPreloads(HippyReporter.RemoveEngineReason.THEME_CHANGED);
        HippyAccessHelper.clearAllPreloads(HippyReporter.RemoveEngineReason.THEME_CHANGED);
    }

    public void setSwitchToolProcessTimeCost(long j3) {
        this.mSwitchToolProcessTimeCost = j3;
    }

    public boolean manuallyPreload(OpenHippyInfo openHippyInfo) {
        if (openHippyInfo != null && openHippyInfo.checkData()) {
            Pair<String, TabPreloadItem> findTabPreloadItem = findTabPreloadItem(openHippyInfo);
            return manuallyPreload((String) findTabPreloadItem.first, (TabPreloadItem) findTabPreloadItem.second, openHippyInfo.isPreloadFromExitPage ? 2 : 0);
        }
        QLog.d(TAG, 1, "manuallyPreload parameters error");
        return false;
    }

    private Pair<String, TabPreloadItem> findTabPreloadItem(OpenHippyInfo openHippyInfo) {
        TabPreloadItem tabPreloadItem;
        String str;
        Pair<String, TabPreloadItem> findTabPreloadItem = findTabPreloadItem(openHippyInfo, this.mCurTabName);
        if (findTabPreloadItem == null) {
            str = openHippyInfo.preloadTabName;
            if (str == null) {
                str = "";
            }
            tabPreloadItem = createTabPreloadItem(openHippyInfo);
        } else {
            String str2 = TextUtils.isEmpty(openHippyInfo.preloadTabName) ? (String) findTabPreloadItem.first : openHippyInfo.preloadTabName;
            TabPreloadItem tabPreloadItem2 = (TabPreloadItem) findTabPreloadItem.second;
            tabPreloadItem2.preloadType = openHippyInfo.preloadType;
            tabPreloadItem = tabPreloadItem2;
            str = str2;
        }
        return new Pair<>(str, tabPreloadItem);
    }
}
