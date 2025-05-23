package com.tencent.gamecenter.wadl.util;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.api.IQQGameCheckService;
import com.tencent.gamecenter.wadl.api.IQQGameDownloadService;
import com.tencent.gamecenter.wadl.api.IQQGameNoticeService;
import com.tencent.gamecenter.wadl.api.IQQResDownloadService;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.gamecenter.wadl.biz.listener.WadlProxyServiceCallBackInterface;
import com.tencent.gamecenter.wadl.biz.receiver.GameCenterBroadcastReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.ProcessConstant;

/* loaded from: classes6.dex */
public class WadlProxyServiceWrap {
    public static final String TAG = "Wadl_WadlProxyServiceWrap";

    /* JADX INFO: Access modifiers changed from: protected */
    public WadlProxyServiceWrap() {
        QLog.i(TAG, 1, "WadlProxyServiceWrap new instance");
    }

    private IQQResDownloadService getResDownloadService() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            return (IQQResDownloadService) peekAppRuntime.getRuntimeService(IQQResDownloadService.class, ProcessConstant.MULTI);
        }
        return null;
    }

    private void reportToDC87(String str, String str2, int i3, String str3, String str4) {
        new WadlReportBuilder().setDcId(WadlProxyConsts.TAG_DC_00087).setPageId(WadlProxyConsts.PAGE_ID_DOWNLOAD).setOperModule(WadlProxyConsts.OPER_MODULE_DOWNLOAD).setModuleType(WadlProxyConsts.BUSINESS_ID_DOWNLOAD).setBussinessId("1").setOperId(str).setOperType("20").setGameAppId(str2).setExt(3, str3).setExt(10, str4).setRetId(i3).report();
    }

    public void deleteDownload(int i3, String str) {
        QLog.d(TAG, 1, "deleteDownload from=" + i3 + ",appId=" + str);
        IQQGameDownloadService downloadService = getDownloadService();
        if (downloadService != null) {
            downloadService.deleteApkDownload(i3, str);
        }
    }

    public void deleteResDownload(String str) {
        QLog.d(TAG, 1, "deleteResDownload resId=" + str);
        IQQResDownloadService resDownloadService = getResDownloadService();
        if (resDownloadService != null) {
            resDownloadService.deleteResDownload("", "", str);
        }
    }

    public void destroy() {
        QLog.d(TAG, 1, "destroy");
    }

    public void dispatchAction(WadlParams wadlParams) {
        QLog.i(TAG, 1, "dispatchAction wadlParams=" + wadlParams);
        int i3 = wadlParams.actionCode;
        if (i3 != 2) {
            if (i3 != 3) {
                if (i3 != 4) {
                    if (i3 != 5) {
                        if (i3 != 10) {
                            if (i3 != 12 && i3 != 13) {
                                return;
                            }
                        }
                    } else {
                        doInstallAction(wadlParams);
                        return;
                    }
                }
            }
            doPauseAction(wadlParams.from, wadlParams.appId);
            return;
        }
        if (wadlParams.delayDownload) {
            if (!TextUtils.isEmpty(wadlParams.jsonParams)) {
                GameCenterUtil.addAppidToList(wadlParams.appId, "DELAY_LIST");
                GameCenterUtil.saveAppDetail(wadlParams.appId, wadlParams.jsonParams, "DELAY_APPID_DETAIL_");
                GameCenterBroadcastReceiver.c();
                return;
            }
            return;
        }
        doDownloadAction(wadlParams);
    }

    public void dispatchResAction(WadlParams wadlParams) {
        QLog.i(TAG, 1, "dispatchResAction wadlParams=" + wadlParams);
        int i3 = wadlParams.actionCode;
        if (i3 != 2) {
            if (i3 != 3) {
                if (i3 != 4) {
                    if (i3 == 10) {
                        deleteResDownload(wadlParams.getResId());
                        return;
                    }
                    return;
                }
                doResumeResAction(wadlParams.getResId());
                return;
            }
            doPauseResAction(wadlParams.getResId());
            return;
        }
        doDownloadResAction(wadlParams);
    }

    public void doDownloadAction(WadlParams wadlParams) {
        QLog.d(TAG, 1, "doDownloadAction wadlParams=" + wadlParams);
        if (wadlParams == null) {
            return;
        }
        if (TextUtils.isEmpty(wadlParams.apkChannel)) {
            wadlParams.apkChannel = WadlProxyConsts.APP_CHANNEL_GAMECENTER;
        }
        if (TextUtils.isEmpty(wadlParams.sourceId)) {
            wadlParams.sourceId = "biz_src_zf_games";
        }
        if (TextUtils.isEmpty(wadlParams.appName)) {
            wadlParams.appName = wadlParams.packageName;
        }
        wadlParams.setFlags(16384);
        int i3 = wadlParams.from;
        if (i3 == 1 || i3 == 2) {
            wadlParams.setFlags(8);
        }
        if (wadlParams.from == 1) {
            wadlParams.setFlags(4);
        }
        if (wadlParams.actionCode != 4 && TextUtils.isEmpty(wadlParams.apkUrl)) {
            WadlReportBuilder wadlReportBuilder = new WadlReportBuilder();
            wadlReportBuilder.setDcId(WadlProxyConsts.TAG_DC_00087).setOperId(WadlProxyConsts.OPER_ID_URL_EMPTY).setGameAppId(wadlParams.appId);
            wadlReportBuilder.report();
            QLog.i(TAG, 1, "invalid url:" + wadlParams);
            return;
        }
        IQQGameDownloadService downloadService = getDownloadService();
        if (downloadService != null) {
            downloadService.downloadApk(wadlParams);
        }
    }

    public void doDownloadResAction(WadlParams wadlParams) {
        QLog.d(TAG, 1, "doDownloadResAction wadlParams=" + wadlParams);
        if (wadlParams == null) {
            return;
        }
        wadlParams.setFlagDisable(1);
        wadlParams.setFlagDisable(16384);
        IQQResDownloadService resDownloadService = getResDownloadService();
        if (resDownloadService != null) {
            resDownloadService.downloadRes(wadlParams);
        }
    }

    public void doInstallAction(WadlParams wadlParams) {
        QLog.d(TAG, 1, "doInstallAction wadlParams=" + wadlParams);
        if (wadlParams == null) {
            return;
        }
        if (TextUtils.isEmpty(wadlParams.sourceId)) {
            wadlParams.sourceId = "biz_src_zf_games";
        }
        IQQGameDownloadService downloadService = getDownloadService();
        if (downloadService != null) {
            downloadService.installApkAction(wadlParams);
        }
    }

    public void doPauseAction(int i3, String str) {
        doPauseAction(i3, "3", str);
    }

    public void doPauseResAction(String str) {
        QLog.d(TAG, 1, "doPauseResAction resId=" + str);
        IQQResDownloadService resDownloadService = getResDownloadService();
        if (resDownloadService != null) {
            resDownloadService.pauseResDownload(str);
        }
    }

    public void doQueryAction(ArrayList<String> arrayList) {
        QLog.d(TAG, 1, "doQueryAction apps=" + arrayList);
        IQQGameDownloadService downloadService = getDownloadService();
        if (downloadService != null) {
            downloadService.queryApkTaskByApps(arrayList);
        }
    }

    public void doQueryActionByVia(String str) {
        QLog.d(TAG, 1, "doQueryActionByVia via=" + str);
        IQQGameDownloadService downloadService = getDownloadService();
        if (downloadService != null) {
            downloadService.queryApkTaskByVia(str);
        }
    }

    public void doQueryAllRes() {
        QLog.d(TAG, 1, "doQueryAllRes");
        IQQResDownloadService resDownloadService = getResDownloadService();
        if (resDownloadService != null) {
            resDownloadService.queryAllResTask();
        }
    }

    public void doQueryAllTask() {
        IQQGameDownloadService downloadService = getDownloadService();
        if (downloadService != null) {
            downloadService.queryAllApkTask(false);
        }
    }

    public void doQueryAllTaskByPreload() {
        QLog.d(TAG, 1, "doQueryAllTaskByPreload");
        IQQGameDownloadService downloadService = getDownloadService();
        if (downloadService != null) {
            downloadService.queryAllApkTask(true);
        }
    }

    public void doResumeAction(int i3, String str) {
        doResumeAction(i3, 0, str);
    }

    public void doResumeResAction(String str) {
        QLog.d(TAG, 1, "doResumeResAction resId=" + str);
        IQQResDownloadService resDownloadService = getResDownloadService();
        if (resDownloadService != null) {
            resDownloadService.resumeResDownload(str);
        }
    }

    public IQQGameDownloadService getDownloadService() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            return (IQQGameDownloadService) peekAppRuntime.getRuntimeService(IQQGameDownloadService.class, ProcessConstant.MULTI);
        }
        return null;
    }

    public IQQGameCheckService getQQGameCheckService() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            return (IQQGameCheckService) peekAppRuntime.getRuntimeService(IQQGameCheckService.class, "");
        }
        return null;
    }

    public IQQGameNoticeService getQQGameNoticeService() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            return (IQQGameNoticeService) peekAppRuntime.getRuntimeService(IQQGameNoticeService.class, "");
        }
        return null;
    }

    public void preLaunchWadlService() {
        IQQGameDownloadService downloadService = getDownloadService();
        if (downloadService != null) {
            downloadService.preLaunchWadlService();
        }
    }

    public void receiveGameCenterAction(Intent intent) {
        IQQGameNoticeService iQQGameNoticeService;
        if (intent == null) {
            return;
        }
        int intExtra = intent.getIntExtra("key_event_id", -1);
        QLog.d(TAG, 1, "receiveGameCenterAction eventId=" + intExtra);
        if (intExtra != 1) {
            if (intExtra != 2) {
                if (intExtra != 3) {
                    if (intExtra != 4) {
                        if (intExtra != 5) {
                            if (intExtra == 7) {
                                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                                if (peekAppRuntime != null) {
                                    iQQGameNoticeService = (IQQGameNoticeService) peekAppRuntime.getRuntimeService(IQQGameNoticeService.class, "all");
                                } else {
                                    iQQGameNoticeService = null;
                                }
                                if (iQQGameNoticeService != null) {
                                    iQQGameNoticeService.onUserCleanNotification();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        String stringExtra = intent.getStringExtra("appid");
                        int intExtra2 = intent.getIntExtra("actionFrom", 4);
                        long longExtra = intent.getLongExtra("progress", 0L);
                        doPauseAction(intExtra2, "1", stringExtra);
                        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.gamecenter.wadl.util.WadlProxyServiceWrap.1
                            @Override // java.lang.Runnable
                            public void run() {
                                QQToast.makeText(MobileQQ.sMobileQQ, 0, R.string.f171222n6, 1).show();
                            }
                        });
                        reportToDC87(WadlProxyConsts.OPER_ID_NOTIFICATION_CLICK, stringExtra, 2, String.valueOf(longExtra), "");
                        return;
                    }
                    String stringExtra2 = intent.getStringExtra(WadlProxyConsts.KEY_JUMP_URL);
                    String stringExtra3 = intent.getStringExtra("appid");
                    String stringExtra4 = intent.getStringExtra(WadlProxyConsts.KEY_MATERIAL);
                    GameCenterUtil.jumpUrlOrSchema(MobileQQ.sMobileQQ, stringExtra2);
                    new WadlReportBuilder().setDcId(WadlProxyConsts.TAG_DC_00087).setOperId("914120").setOperModule("9385").setExt(11, "1").setExt(12, WadlProxyConsts.PAGE_ID_DOWNLOAD).setExt(1, "938503").setExt(4, "20").setExt(2, stringExtra4).setGameAppId(stringExtra3).report();
                    return;
                }
                int intExtra3 = intent.getIntExtra("actionFrom", 0);
                int intExtra4 = intent.getIntExtra("downloadType", 0);
                String stringExtra5 = intent.getStringExtra("appid");
                String stringExtra6 = intent.getStringExtra("packageName");
                int intExtra5 = intent.getIntExtra("actionType", 0);
                String stringExtra7 = intent.getStringExtra(WadlProxyConsts.KEY_JUMP_URL);
                if (intExtra3 == 4) {
                    new WadlReportBuilder().setDcId(WadlProxyConsts.TAG_DC_00087).setOperId(WadlProxyConsts.OPER_ID_CLICK_NOTICE).setOperType("20").setGameAppId(stringExtra5).setRetId(intExtra4).setExt(36, String.valueOf(intExtra5)).report();
                }
                reportToDC87(WadlProxyConsts.OPER_ID_NOTIFICATION_CLICK, stringExtra5, 6, String.valueOf(100), String.valueOf(intExtra5));
                if (intExtra5 == 1 && !TextUtils.isEmpty(stringExtra7)) {
                    GameCenterUtil.jumpUrlOrSchema(MobileQQ.sMobileQQ, stringExtra7);
                    return;
                } else {
                    GameCenterUtil.goToInstall(stringExtra5, stringExtra6, intent.getStringExtra(WadlProxyConsts.KEY_LOCAL_APK_PATH), null, "notification");
                    return;
                }
            }
            doResumeResAction(intent.getStringExtra("resId"));
            return;
        }
        String stringExtra8 = intent.getStringExtra("appid");
        int intExtra6 = intent.getIntExtra("actionFrom", 4);
        int intExtra7 = intent.getIntExtra("actionType", 0);
        long longExtra2 = intent.getLongExtra("progress", 0L);
        doResumeAction(intExtra6, intExtra7, stringExtra8);
        reportToDC87(WadlProxyConsts.OPER_ID_NOTIFICATION_CLICK, stringExtra8, 5, String.valueOf(longExtra2), String.valueOf(intExtra7));
    }

    public void registerResCallBack(nl0.g gVar) {
        QLog.d(TAG, 1, "registerResCallBack callback=" + gVar);
        IQQResDownloadService resDownloadService = getResDownloadService();
        if (resDownloadService != null) {
            resDownloadService.registerResCallBack(gVar);
        }
    }

    public void registerWadlServiceCallBack(WadlProxyServiceCallBackInterface wadlProxyServiceCallBackInterface) {
        if (wadlProxyServiceCallBackInterface == null) {
            QLog.w(TAG, 1, "registerWadlServiceCallBack callback is null");
            return;
        }
        IQQGameDownloadService downloadService = getDownloadService();
        if (downloadService != null) {
            downloadService.registerWadlServiceCallBack(wadlProxyServiceCallBackInterface);
        }
    }

    public void setSpeedBuffer(int i3) {
        QLog.d(TAG, 1, "setSpeedBuffer speedBuffer=" + i3);
        IQQGameDownloadService downloadService = getDownloadService();
        if (downloadService != null) {
            downloadService.setSpeedBuffer(i3);
        }
    }

    public void syncTaskData(ArrayList<WadlResult> arrayList) {
        if (arrayList != null && arrayList.size() >= 1) {
            QLog.d(TAG, 1, "syncTaskData wadlResults size=" + arrayList.size());
            IQQGameDownloadService downloadService = getDownloadService();
            if (downloadService != null) {
                downloadService.syncTaskData(arrayList);
            }
        }
    }

    public void unRegisterResCallBack(nl0.g gVar) {
        QLog.d(TAG, 1, "registerResCallBack callback=" + gVar);
        IQQResDownloadService resDownloadService = getResDownloadService();
        if (resDownloadService != null) {
            resDownloadService.unRegisterResCallBack(gVar);
        }
    }

    public void unRegisterWadlServiceCallBack(WadlProxyServiceCallBackInterface wadlProxyServiceCallBackInterface) {
        if (wadlProxyServiceCallBackInterface == null) {
            QLog.w(TAG, 1, "unRegisterWadlServiceCallBack callback is null");
            return;
        }
        IQQGameDownloadService downloadService = getDownloadService();
        if (downloadService != null) {
            downloadService.unRegisterWadlServiceCallBack(wadlProxyServiceCallBackInterface);
        }
    }

    public void doPauseAction(int i3, String str, String str2) {
        QLog.d(TAG, 1, "doPauseAction from=" + i3 + ",sceneId=" + str + ",appId=" + str2);
        IQQGameDownloadService downloadService = getDownloadService();
        if (downloadService != null) {
            downloadService.pauseApkDownload(i3, str, str2);
        }
    }

    public void doResumeAction(int i3, int i16, String str) {
        QLog.d(TAG, 1, "doResumeAction from=" + i3 + ",actionType=" + i16 + ",appId=" + str);
        IQQGameDownloadService downloadService = getDownloadService();
        if (downloadService != null) {
            downloadService.resumeApkDownload(i3, i16, str);
        }
    }
}
