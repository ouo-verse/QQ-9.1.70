package com.tencent.gamecenter.wadl.biz.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.ecommerce.base.runtime.api.IECScreenReceiver;
import com.tencent.gamecenter.wadl.api.IQQGameCheckService;
import com.tencent.gamecenter.wadl.api.IQQGameCommApi;
import com.tencent.gamecenter.wadl.api.IQQGameConfigService;
import com.tencent.gamecenter.wadl.api.IQQGameDLService;
import com.tencent.gamecenter.wadl.api.IQQGameDownloadService;
import com.tencent.gamecenter.wadl.api.IQQGameNoticeService;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.gamecenter.wadl.biz.entity.f;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.gamecenter.wadl.util.WadlProxyServiceUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;
import mqq.app.api.ProcessConstant;

/* compiled from: P */
/* loaded from: classes6.dex */
public class GameCenterReceiver extends BroadcastReceiver {
    public static final int EVENT_ID_CONFIG_UPDATE = 1;
    public static final int EVENT_ID_DO_DOWNLOAD = 10;
    public static final int EVENT_ID_DO_INTERRUPT_DOWNLOAD_DEF = 9;
    public static final int EVENT_ID_ON_BIND_SERVICE = 11;
    public static final int EVENT_ID_TASK_DEL = 2;
    public static final int EVENT_ID_TASK_DOWNLOAD_COMPLETE = 7;
    public static final int EVENT_ID_TASK_INSTALL_COMPLETE = 8;
    public static final String KEY_APK_INFO = "key_apk_info";
    public static final String KEY_APP_ID = "key_appid";
    public static final String KEY_BUSINESS_ID = "key_businessId";
    public static final String KEY_EVENT_ID = "key_event_id";
    public static final String KEY_PKG_NAME = "key_pkg_name";
    public static final String KEY_WADL_PARAMS = "key_wadl_params";
    public static final String KEY_WADL_RESULT = "key_wadl_result";
    private static final String PKG_PREFIX = "package:";
    private static final String SPECIAL_ZONE_HIPPY_PAGE = "mqqapi://hippy/open?src_type%3Dweb%26version%3D1%26bundleName%3DQQGameCenterV2%26url%3Dhttps%253A%252F%252Fplay.qq.com%252Fhippy-ssr%252Fv1%252Fapp%252Fgame-detail%253Fp_collections%253D%252526adtag%25253Dhulian_login%252526appid%25253Dxxxx%252526autodownload%25253D1%252526autolaunch%25253D1%26isAnimated%3Dtrue%26isStatusBarDarkFont%3Dtrue";
    public static final String TAG = "Wadl_GameCenterReceiver";
    private static final long VALID_TS = 300;
    private static GameCenterReceiver instance;
    static byte[] lock = new byte[0];
    private static volatile AtomicBoolean mIsRegistered = new AtomicBoolean(false);
    List<nl0.a> listeners = new ArrayList();

    GameCenterReceiver() {
    }

    public static void addListener(nl0.a aVar) {
        GameCenterReceiver gameCenterReceiver;
        List<nl0.a> list;
        QLog.d(TAG, 1, "addListener listener=" + aVar);
        if (aVar != null && (gameCenterReceiver = getInstance()) != null && (list = gameCenterReceiver.listeners) != null) {
            synchronized (list) {
                if (!gameCenterReceiver.listeners.contains(aVar)) {
                    gameCenterReceiver.listeners.add(aVar);
                }
            }
        }
    }

    public static GameCenterReceiver getInstance() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new GameCenterReceiver();
                }
            }
        }
        return instance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleGamePkgRmvAction(final Context context, String str, String str2) {
        if ("android.intent.action.PACKAGE_REMOVED".equals(str2) && !TextUtils.isEmpty(str)) {
            String uninstallPkgName = getUninstallPkgName();
            if (TextUtils.isEmpty(uninstallPkgName)) {
                return;
            }
            final String decodeString = QMMKV.from(MobileQQ.sMobileQQ, "vas_mmkv_configurations").decodeString("qq_login_game_app_id", "");
            QLog.i(TAG, 1, "[handleGamePkgRmvAction], pkg name:" + uninstallPkgName + ",appId:" + decodeString + ",intent.pkgname:" + str);
            if (str.equals(PKG_PREFIX + uninstallPkgName) && !TextUtils.isEmpty(decodeString)) {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.gamecenter.wadl.biz.receiver.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        GameCenterReceiver.this.lambda$handleGamePkgRmvAction$0(decodeString, context);
                    }
                }, 32, null, true);
            }
        }
    }

    private void jumpHippyAndReport(Context context, String str) {
        jumpMqqHippyScheme(context, SPECIAL_ZONE_HIPPY_PAGE.replace("xxxx", str));
        reportInstallOrJumpHippy(str, "1");
    }

    private void jumpInstallAndReport(String str, String str2) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.gamecenter.wadl.biz.receiver.GameCenterReceiver.3
            @Override // java.lang.Runnable
            public void run() {
                QQToast.makeText(MobileQQ.sMobileQQ, R.string.f160871w7, 0).show();
            }
        });
        try {
            QLog.i(TAG, 1, "[handleGamePkgRmvAction] task AlReady completed,just install");
            RouteUtils.startActivity(MobileQQ.sMobileQQ, GameCenterUtil.createInstallScheme(str2, "biz_src_zf_games", "custom"), RouterConstants.UI_ROUTER_JUMP);
            reportInstallOrJumpHippy(str, "2");
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
        }
    }

    private void jumpMqqHippyScheme(Context context, String str) {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 1, "[jumpMqqHippyScheme], schema:" + str);
        }
        if (context != null && !TextUtils.isEmpty(str)) {
            Intent intent = new Intent();
            intent.setData(Uri.parse(str));
            intent.setPackage(context.getPackageName());
            context.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleGamePkgRmvAction$0(String str, Context context) {
        f taskByAppId = ((IQQGameCommApi) QRoute.api(IQQGameCommApi.class)).getTaskByAppId(str);
        if (taskByAppId != null && taskByAppId.taskStatus == 6 && !TextUtils.isEmpty(taskByAppId.downloadFilePath)) {
            jumpInstallAndReport(str, taskByAppId.downloadFilePath);
        } else {
            jumpHippyAndReport(context, str);
            if (taskByAppId == null) {
                QLog.e(TAG, 1, "[handleGamePkgRmvAction] task is null");
            } else {
                QLog.i(TAG, 1, "[handleGamePkgRmvAction] taskStatus:" + taskByAppId.taskStatus + ",downloadFilePath:" + taskByAppId.downloadFilePath);
            }
        }
        resetPkgAndAppIdCacheDelay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void receiveGameCenterAction(Intent intent) {
        if (intent == null) {
            return;
        }
        int intExtra = intent.getIntExtra("key_event_id", -1);
        QLog.d(TAG, 1, "receiveGameCenterAction eventId=" + intExtra);
        if (intExtra != 1) {
            if (intExtra != 2) {
                switch (intExtra) {
                    case 7:
                        if (instance.listeners != null) {
                            synchronized (this.listeners) {
                                WadlResult wadlResult = (WadlResult) intent.getParcelableExtra(KEY_WADL_RESULT);
                                int intExtra2 = intent.getIntExtra(KEY_BUSINESS_ID, 0);
                                if (wadlResult != null) {
                                    Iterator<nl0.a> it = this.listeners.iterator();
                                    while (it.hasNext()) {
                                        it.next().onTaskComplete(wadlResult, intExtra2);
                                    }
                                }
                            }
                            return;
                        }
                        return;
                    case 8:
                        if (instance.listeners != null) {
                            synchronized (this.listeners) {
                                WadlResult wadlResult2 = (WadlResult) intent.getParcelableExtra(KEY_WADL_RESULT);
                                int intExtra3 = intent.getIntExtra(KEY_BUSINESS_ID, 0);
                                if (wadlResult2 != null) {
                                    Iterator<nl0.a> it5 = this.listeners.iterator();
                                    while (it5.hasNext()) {
                                        it5.next().onTaskInstall(wadlResult2, intExtra3);
                                    }
                                }
                            }
                            return;
                        }
                        return;
                    case 9:
                        WadlParams wadlParams = (WadlParams) intent.getParcelableExtra(KEY_WADL_PARAMS);
                        if (QLog.isColorLevel()) {
                            QLog.d(TAG, 1, "receiveGameCenterAction wadlParams=" + wadlParams);
                        }
                        WadlProxyServiceUtil.getProxyService().doDownloadAction(wadlParams);
                        return;
                    case 10:
                        WadlParams wadlParams2 = (WadlParams) intent.getParcelableExtra(KEY_WADL_PARAMS);
                        if (QLog.isColorLevel()) {
                            QLog.d(TAG, 1, "receiveGameCenterAction EVENT_ID_DO_DOWNLOAD params=" + wadlParams2);
                        }
                        IQQGameCheckService qQGameCheckService = WadlProxyServiceUtil.getProxyService().getQQGameCheckService();
                        if (qQGameCheckService != null) {
                            qQGameCheckService.onSendDownloadRequest(wadlParams2);
                            return;
                        }
                        return;
                    case 11:
                        IQQGameNoticeService qQGameNoticeService = WadlProxyServiceUtil.getProxyService().getQQGameNoticeService();
                        if (qQGameNoticeService != null) {
                            qQGameNoticeService.onBindService();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
            if (instance.listeners != null) {
                synchronized (this.listeners) {
                    String stringExtra = intent.getStringExtra("key_appid");
                    String stringExtra2 = intent.getStringExtra(KEY_PKG_NAME);
                    int intExtra4 = intent.getIntExtra(KEY_BUSINESS_ID, 0);
                    if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                        Iterator<nl0.a> it6 = this.listeners.iterator();
                        while (it6.hasNext()) {
                            it6.next().onTaskDeleted(stringExtra, stringExtra2, intExtra4);
                        }
                    }
                }
                return;
            }
            return;
        }
        ((IQQGameConfigService) QRoute.api(IQQGameConfigService.class)).loadConfig("update");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void receiveSystemInstallAction(String str, Intent intent) {
        String dataString = intent.getDataString();
        QLog.d(TAG, 1, "receiveSystemInstallAction intentPkgNameString=" + dataString);
        if (!TextUtils.isEmpty(dataString) && dataString.contains(":")) {
            String[] split = dataString.split(":");
            if (split.length < 2) {
                return;
            }
            String str2 = split[1];
            try {
                if (TextUtils.equals(str, "android.intent.action.PACKAGE_REMOVED")) {
                    IQQGameDownloadService iQQGameDownloadService = (IQQGameDownloadService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IQQGameDownloadService.class, ProcessConstant.MULTI);
                    if (iQQGameDownloadService != null) {
                        iQQGameDownloadService.doAppSystemReceiver(WadlProxyConsts.REMOTE_CMD_APP_UNINSTALLED, str2, null);
                        return;
                    }
                    return;
                }
                if (TextUtils.equals(str, "android.intent.action.PACKAGE_ADDED")) {
                    IQQGameDownloadService iQQGameDownloadService2 = (IQQGameDownloadService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IQQGameDownloadService.class, ProcessConstant.MULTI);
                    if (iQQGameDownloadService2 != null) {
                        iQQGameDownloadService2.onInstalledEvent(str2);
                    }
                    IQQGameDLService iQQGameDLService = (IQQGameDLService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IQQGameDLService.class, ProcessConstant.MULTI);
                    if (iQQGameDLService != null) {
                        iQQGameDLService.doAppSystemReceiver(WadlProxyConsts.REMOTE_CMD_APP_INSTALLED, str2);
                    }
                }
            } catch (Exception e16) {
                QLog.e(TAG, 1, "receiveSystemInstallAction exception:" + e16.getMessage());
            }
        }
    }

    public static synchronized void registerReceiver() {
        synchronized (GameCenterReceiver.class) {
            if (!mIsRegistered.getAndSet(true)) {
                QLog.d(TAG, 1, "registerReceiver processName=" + MobileQQ.processName);
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.gamecenter.wadl.biz.receiver.GameCenterReceiver.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            GameCenterReceiver gameCenterReceiver = GameCenterReceiver.getInstance();
                            if (gameCenterReceiver == null) {
                                return;
                            }
                            IntentFilter intentFilter = new IntentFilter();
                            if (MobileQQ.sProcessId == 1) {
                                intentFilter.addAction(IECScreenReceiver.ACTION_SCREEN_OFF);
                                intentFilter.addAction(IECScreenReceiver.ACTION_SCREEN_ON);
                                intentFilter.addAction(WadlProxyConsts.ACTION_GAME_CENTER_MAIN_PROCESS_ACTION);
                                IntentFilter intentFilter2 = new IntentFilter();
                                intentFilter2.addDataScheme("package");
                                intentFilter2.addAction("android.intent.action.PACKAGE_ADDED");
                                intentFilter2.addAction("android.intent.action.PACKAGE_REMOVED");
                                MobileQQ.sMobileQQ.registerReceiver(gameCenterReceiver, intentFilter2);
                            }
                            intentFilter.addAction(WadlProxyConsts.ACTION_GAME_CENTER_DYNAMIC_ACTION);
                            intentFilter.addAction(WadlProxyConsts.ACTION_GAME_CENTER_SERVICE_EXIT_ACTION);
                            MobileQQ.sMobileQQ.registerReceiver(gameCenterReceiver, intentFilter);
                        } catch (Throwable th5) {
                            GameCenterReceiver.unRegisterReceiver();
                            QLog.e(GameCenterReceiver.TAG, 1, "registerReceiver exception", th5);
                        }
                    }
                }, 16, null, false);
            }
        }
    }

    public static void removeListener(nl0.a aVar) {
        GameCenterReceiver gameCenterReceiver;
        List<nl0.a> list;
        QLog.d(TAG, 1, "removeListener listener=" + aVar);
        if (aVar != null && (gameCenterReceiver = getInstance()) != null && (list = gameCenterReceiver.listeners) != null) {
            synchronized (list) {
                if (gameCenterReceiver.listeners.contains(aVar)) {
                    gameCenterReceiver.listeners.remove(aVar);
                }
            }
        }
    }

    private void reportInstallOrJumpHippy(String str, String str2) {
        new WadlReportBuilder().setDcId(WadlProxyConsts.TAG_DC_00087).setOperModule("9388").setOperId("914157").setGameAppId(str).setAdTag("hulian_login").setModuleType("938801").setBusiness("4").setPageId(WadlProxyConsts.PAGE_ID_DOWNLOAD).setExt(4, "20").setExt(2, str2).report();
    }

    private void resetPkgAndAppIdCacheDelay() {
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.gamecenter.wadl.biz.receiver.b
            @Override // java.lang.Runnable
            public final void run() {
                GameCenterReceiver.this.lambda$resetPkgAndAppIdCacheDelay$1();
            }
        }, 3000L);
    }

    public static synchronized void unRegisterReceiver() {
        synchronized (GameCenterReceiver.class) {
            if (!mIsRegistered.get()) {
                return;
            }
            QLog.d(TAG, 1, "unRegisterReceiver process=" + MobileQQ.processName);
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.gamecenter.wadl.biz.receiver.GameCenterReceiver.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        GameCenterReceiver gameCenterReceiver = GameCenterReceiver.getInstance();
                        if (gameCenterReceiver != null) {
                            MobileQQ.sMobileQQ.unregisterReceiver(gameCenterReceiver);
                        }
                    } catch (Throwable th5) {
                        QLog.e(GameCenterReceiver.TAG, 1, "unRegisterReceiver exception", th5);
                    }
                    GameCenterReceiver.mIsRegistered.set(false);
                }
            }, 16, null, false);
        }
    }

    public String getUninstallPkgName() {
        int indexOf;
        try {
            String decodeString = QMMKV.from(MobileQQ.sMobileQQ, "vas_mmkv_configurations").decodeString("qq_login_game_pkg_name", "");
            if (TextUtils.isEmpty(decodeString) || (indexOf = decodeString.indexOf("@")) < 0) {
                return "";
            }
            long currentTimeMillis = System.currentTimeMillis() - Long.valueOf(decodeString.substring(indexOf + 1)).longValue();
            long decodeLong = QMMKV.from(MobileQQ.sMobileQQ, "vas_mmkv_configurations").decodeLong("qq_login_valid_time_in_sec", -1L);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "validTs:" + decodeLong);
            }
            if (decodeLong < 0) {
                decodeLong = 300;
            }
            if (currentTimeMillis >= decodeLong * 1000) {
                QLog.i(TAG, 1, "[getUninstallPkgName], action is invalid. delta:" + currentTimeMillis);
                return "";
            }
            String substring = decodeString.substring(0, indexOf);
            QLog.i(TAG, 1, "[getUninstallPkgName], pkgName:" + substring);
            return substring;
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "[getUninstallPkgName], error:" + th5);
            return "";
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context context, final Intent intent) {
        final String action = intent.getAction();
        if (action == null) {
            return;
        }
        QLog.d(TAG, 1, "onReceive action=" + action);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.gamecenter.wadl.biz.receiver.GameCenterReceiver.4
            @Override // java.lang.Runnable
            public void run() {
                if (IECScreenReceiver.ACTION_SCREEN_OFF.equals(action)) {
                    ((IQQGameConfigService) QRoute.api(IQQGameConfigService.class)).checkConfigUpdate(false, -1L);
                    return;
                }
                if (IECScreenReceiver.ACTION_SCREEN_ON.equals(action)) {
                    IQQGameNoticeService iQQGameNoticeService = (IQQGameNoticeService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IQQGameNoticeService.class, "");
                    if (iQQGameNoticeService != null) {
                        iQQGameNoticeService.onEvent(1);
                        return;
                    }
                    return;
                }
                if ("android.intent.action.PACKAGE_ADDED".equals(action) || "android.intent.action.PACKAGE_REMOVED".equals(action)) {
                    GameCenterReceiver.this.receiveSystemInstallAction(action, intent);
                    GameCenterReceiver.this.handleGamePkgRmvAction(context, intent.getDataString(), action);
                } else if (WadlProxyConsts.ACTION_GAME_CENTER_DYNAMIC_ACTION.equals(action) || WadlProxyConsts.ACTION_GAME_CENTER_MAIN_PROCESS_ACTION.equals(action)) {
                    GameCenterReceiver.this.receiveGameCenterAction(intent);
                } else if (WadlProxyConsts.ACTION_GAME_CENTER_SERVICE_EXIT_ACTION.equals(action)) {
                    ((IQQGameCommApi) QRoute.api(IQQGameCommApi.class)).onGameServiceExit();
                }
            }
        }, 16, null, false);
    }

    /* renamed from: resetPkgAndAppIdCache, reason: merged with bridge method [inline-methods] */
    public void lambda$resetPkgAndAppIdCacheDelay$1() {
        QMMKV.from(MobileQQ.sMobileQQ, "vas_mmkv_configurations").encodeString("qq_login_game_pkg_name", "pkg_name_null");
        QMMKV.from(MobileQQ.sMobileQQ, "vas_mmkv_configurations").encodeString("qq_login_game_app_id", "app_Id_null");
    }
}
