package com.tencent.gamecenter.wadl.sdk.app;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.gamecenter.wadl.api.IQQGameReportService;
import com.tencent.gamecenter.wadl.api.WadlRequest;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.gamecenter.wadl.biz.entity.h;
import com.tencent.gamecenter.wadl.sdk.dlcom.WadlUtils;
import com.tencent.gamecenter.wadl.sdk.dlmgr.WadlGameCenterTaskMgr;
import com.tencent.gamecenter.wadl.sdk.dlmgr.WadlTask;
import com.tencent.gamecenter.wadl.sdk.dlmgr.WadlTgpaTaskMgr;
import com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTaskAttr;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingPermission;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes6.dex */
public class WadlReportManager {
    public static final String TAG = "Wadl_WadlReportManager";

    private static WadlTask findTaskByRequest(WadlRequest wadlRequest) {
        String str;
        String str2;
        String str3;
        Bundle bundle = wadlRequest.f106596h;
        if (bundle != null) {
            str = bundle.getString("appId");
            str2 = wadlRequest.f106596h.getString("resId");
            str3 = wadlRequest.f106596h.getString("packageName");
        } else {
            str = "";
            str2 = "";
            str3 = str2;
        }
        int i3 = wadlRequest.f106593d;
        WadlTask wadlTask = null;
        if (i3 == 1) {
            if (!TextUtils.isEmpty(str)) {
                wadlTask = WadlGameCenterTaskMgr.getInstance().findWadlTask(str);
            }
            if (wadlTask == null && !TextUtils.isEmpty(str3)) {
                return WadlGameCenterTaskMgr.getInstance().getWadlTaskByPackageName(str3);
            }
            return wadlTask;
        }
        if (i3 != 2) {
            return null;
        }
        return WadlTgpaTaskMgr.getInstance().getWadlTask(str2);
    }

    private static void handleDeleteReport(WadlTask wadlTask, h hVar) {
        if (wadlTask != null) {
            hVar.f106816c = wadlTask.taskStatus;
        }
        wadlReportDC(WadlProxyConsts.OPER_ID_DEL_DOWNLOAD, "31", hVar);
    }

    private static void handleInstallReport(Bundle bundle, WadlTask wadlTask, h hVar) {
        if (wadlTask != null && wadlTask.mWadlParams != null && bundle != null) {
            WadlParams wadlParams = (WadlParams) bundle.getParcelable(WadlProxyConsts.PARAM_DOWNLOAD_INFO);
            if (wadlParams != null && wadlParams.isExtFlagEnable(1)) {
                wadlTask.mWadlParams.setExtFlags(1);
            } else {
                wadlTask.mWadlParams.removeExtFlags(1);
            }
            wadlReportDC(WadlProxyConsts.OPER_ID_FROM_OTHER_INSTALL, "22", hVar);
        }
    }

    private static void handleInstalledReport(WadlTask wadlTask, h hVar, String str) {
        String str2;
        int i3;
        if (wadlTask != null) {
            boolean checkPermission = ((IQQFloatingPermission) QRoute.api(IQQFloatingPermission.class)).checkPermission(BaseApplication.getContext());
            if (Build.VERSION.SDK_INT > 28) {
                if (!checkPermission) {
                    i3 = 1;
                } else {
                    i3 = 2;
                }
                hVar.f106816c = i3;
            } else {
                hVar.f106816c = 0;
            }
            WadlParams wadlParams = wadlTask.mWadlParams;
            if (wadlParams != null) {
                str2 = GameCenterUtil.getFileChannel(GameCenterUtil.getApkSourceDir(wadlParams.packageName));
            } else {
                str2 = "";
            }
            hVar.f106815b = String.valueOf(wadlTask.taskStatus);
            hVar.f106819f = str;
            hVar.f106817d = str2;
            if (wadlTask.taskStatus == 6 && wadlTask.isDownloadApkFileVersionCodeEqual()) {
                hVar.f106822i = "1";
                hVar.f106821h = GameCenterUtil.getFileChannel(wadlTask.downloadFilePath);
            } else {
                hVar.f106822i = "0";
                hVar.f106821h = "0";
            }
            wadlReportDC(WadlProxyConsts.OPER_ID_INSTALL_APP, "26", hVar);
        }
    }

    private static void handlePauseReport(h hVar) {
        wadlReportDC(WadlProxyConsts.OPER_ID_PAUSE_DOWNLOAD, "30", hVar);
    }

    public static void handleReportDownload(WadlParams wadlParams) {
        String str;
        if (wadlParams != null) {
            h b16 = h.b();
            b16.f106814a = wadlParams;
            int i3 = wadlParams.actionCode;
            String str2 = "21";
            if (i3 != 2 && i3 != 13) {
                if (i3 == 12) {
                    b16.f106818e = String.valueOf(wadlParams.versionCode);
                    str = WadlProxyConsts.OPER_ID_UPDATE_DOWNLOAD;
                } else {
                    str2 = "";
                    str = "";
                }
            } else {
                int i16 = wadlParams.from;
                if (i16 == 2) {
                    str = WadlProxyConsts.OPER_ID_DELAY_DOWNLOAD;
                } else if (i16 == 1) {
                    str = WadlProxyConsts.OPER_ID_PRE_DOWNLOAD;
                } else {
                    str = WadlProxyConsts.OPER_ID_DEFAULT_DOWNLOAD;
                }
            }
            wadlReportDC(str, str2, b16);
        }
    }

    private static void handleResumeReport(int i3, h hVar) {
        String str;
        if (i3 == 4) {
            str = WadlProxyConsts.OPER_ID_FROM_NOTICE_RESUME;
        } else {
            str = WadlProxyConsts.OPER_ID_FROM_OTHER_RESUME;
        }
        wadlReportDC(str, "23", hVar);
    }

    private static void handleUninstallReport(WadlTask wadlTask, h hVar) {
        if (wadlTask != null) {
            wadlReportDC(WadlProxyConsts.OPER_ID_UNINSTALL_APP, "24", hVar);
        }
    }

    private static void reportChannelIdBeforeInstall(WadlTask wadlTask) {
        WadlParams wadlParams;
        if (wadlTask == null || (wadlParams = wadlTask.mWadlParams) == null || GameCenterUtil.getAppVersionCode(wadlParams.packageName) == -1) {
            return;
        }
        try {
            String fileChannel = GameCenterUtil.getFileChannel(GameCenterUtil.getApkSourceDir(wadlTask.mWadlParams.packageName));
            QLog.i(TAG, 1, "[reportChannelIdBeforeInstall], channel:" + fileChannel);
            new WadlReportBuilder().setDcId(WadlProxyConsts.TAG_DC_00087).setOperModule(WadlProxyConsts.OPER_MODULE_GAMECENTER).setOperId("928881").setGameAppId(wadlTask.mWadlParams.appId).setExt(1, WadlProxyConsts.MOUDLE_TYPE_GAMECENTER).setExt(3, fileChannel).setExt(4, "26").setExt(11, "4").setExt(22, String.valueOf(wadlTask.mWadlParams.versionCode)).setExt(12, WadlProxyConsts.PAGE_ID_GAMECENTER).report();
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "[getChannelId], error:" + th5);
        }
    }

    public static void reportDC(int i3, WadlTask wadlTask) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7 = "1";
        if (i3 == 1008) {
            DownloaderTaskAttr downloadAttr = wadlTask.getDownloadAttr();
            h b16 = h.b();
            b16.f106814a = wadlTask.mWadlParams;
            b16.f106824k = wadlTask.downloadFileSize;
            if (QQNotificationManager.getInstance().areNotificationsEnabled(MobileQQ.sMobileQQ)) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            b16.f106828o = str2;
            if (((IQQFloatingPermission) QRoute.api(IQQFloatingPermission.class)).checkPermission(BaseApplication.getContext())) {
                str3 = "1";
            } else {
                str3 = "0";
            }
            b16.f106829p = str3;
            if (GameCenterUtil.checkInstallPermission()) {
                str4 = "1";
            } else {
                str4 = "0";
            }
            b16.f106830q = str4;
            b16.f106815b = String.valueOf(wadlTask.getAverageSpeed());
            if (GameCenterUtil.isForeground()) {
                str5 = "1";
            } else {
                str5 = "0";
            }
            b16.f106820g = str5;
            String str8 = "";
            if (wadlTask.mWadlParams.getFlagEnable(65536)) {
                if (downloadAttr == null) {
                    str6 = "";
                } else {
                    str6 = String.valueOf((int) downloadAttr.sectionMobilePercent);
                }
                b16.f106822i = str6;
            } else {
                b16.f106822i = "";
            }
            if (downloadAttr != null) {
                str8 = String.valueOf((int) downloadAttr.sectionP2PPercent);
            }
            b16.f106827n = str8;
            if (!WadlUtils.isScreenOn()) {
                str7 = "0";
            }
            b16.f106823j = str7;
            b16.f106821h = GameCenterUtil.getFileChannel(wadlTask.downloadFilePath);
            b16.f106818e = String.valueOf(GameCenterUtil.getFileLastModifyTime(wadlTask.downloadFilePath));
            b16.f106817d = wadlTask.f107253msg;
            b16.f106831r = String.valueOf(wadlTask.costTime);
            wadlReportDC(WadlProxyConsts.OPER_ID_DOWNLOAD_SUCC, "27", b16);
            reportChannelIdBeforeInstall(wadlTask);
            return;
        }
        if (i3 == 1005) {
            h b17 = h.b();
            b17.f106816c = wadlTask.errCode;
            b17.f106817d = wadlTask.f107253msg;
            b17.f106814a = wadlTask.mWadlParams;
            b17.f106824k = wadlTask.downloadFileSize;
            wadlReportDC(WadlProxyConsts.OPER_ID_DOWNLOAD_FAIL, "28", b17);
            return;
        }
        if (i3 == 5008) {
            h b18 = h.b();
            b18.f106814a = wadlTask.mWadlParams;
            b18.f106824k = wadlTask.downloadFileSize;
            b18.f106815b = String.valueOf(wadlTask.getAverageSpeed());
            if (WadlUtils.isPhoneRooted(MobileQQ.sMobileQQ)) {
                str = "1";
            } else {
                str = "0";
            }
            b18.f106819f = str;
            if (!WadlUtils.isScreenOn()) {
                str7 = "0";
            }
            b18.f106823j = str7;
            b18.f106817d = wadlTask.f107253msg;
            wadlReportDC(WadlProxyConsts.OPER_ID_DOWNLOAD_SUCC, "27", b18);
            return;
        }
        if (i3 == 5005) {
            h b19 = h.b();
            b19.f106814a = wadlTask.mWadlParams;
            b19.f106824k = wadlTask.downloadFileSize;
            b19.f106816c = wadlTask.errCode;
            b19.f106817d = wadlTask.f107253msg;
            wadlReportDC(WadlProxyConsts.OPER_ID_DOWNLOAD_FAIL, "28", b19);
        }
    }

    public static void reportEvent(WadlRequest wadlRequest) {
        int i3;
        WadlTask findTaskByRequest = findTaskByRequest(wadlRequest);
        h b16 = h.b();
        if (findTaskByRequest != null) {
            b16.f106814a = findTaskByRequest.mWadlParams;
        }
        if (WadlProxyConsts.REMOTE_CMD_APP_PAUSE_ACTION.equals(wadlRequest.f106594e)) {
            handlePauseReport(b16);
            return;
        }
        if (WadlProxyConsts.REMOTE_CMD_APP_RESUME_ACTION.equals(wadlRequest.f106594e)) {
            Bundle bundle = wadlRequest.f106596h;
            int i16 = 0;
            if (bundle != null) {
                i3 = bundle.getInt("actionFrom", 0);
                i16 = wadlRequest.f106596h.getInt("actionType", 0);
            } else {
                i3 = 0;
            }
            b16.f106819f = String.valueOf(i16);
            handleResumeReport(i3, b16);
            return;
        }
        if (WadlProxyConsts.REMOTE_CMD_APP_DELETE_ACTION.equals(wadlRequest.f106594e)) {
            handleDeleteReport(findTaskByRequest, b16);
            return;
        }
        if (WadlProxyConsts.REMOTE_CMD_APP_INSTALL_ACTION.equals(wadlRequest.f106594e)) {
            handleInstallReport(wadlRequest.f106596h, findTaskByRequest, b16);
            return;
        }
        if (WadlProxyConsts.REMOTE_CMD_APP_UNINSTALLED.equals(wadlRequest.f106594e)) {
            handleUninstallReport(findTaskByRequest, b16);
            return;
        }
        if (WadlProxyConsts.REMOTE_CMD_APP_INSTALLED.equals(wadlRequest.f106594e)) {
            Bundle bundle2 = wadlRequest.f106596h;
            String str = "";
            if (bundle2 != null) {
                str = bundle2.getString("actionFrom", "");
            }
            handleInstalledReport(findTaskByRequest, b16, str);
        }
    }

    public static void wadlReportDC(String str, String str2, h hVar) {
        ((IQQGameReportService) QRoute.api(IQQGameReportService.class)).reportDC(str, str2, hVar, WadlProxyConsts.TAG_DC_00087);
        ((IQQGameReportService) QRoute.api(IQQGameReportService.class)).reportDC(str, str2, hVar, WadlProxyConsts.TAG_ATTA_05076);
    }

    public static void wadlReportDC04239(WadlParams wadlParams, String str) {
        ((IMiniAppService) QRoute.api(IMiniAppService.class)).reportMiniGameVirtual(wadlParams.appId, "page_view", str, "", null, String.valueOf(wadlParams.from), String.valueOf(wadlParams.scene), wadlParams.launchVia, wadlParams.reportData);
    }
}
