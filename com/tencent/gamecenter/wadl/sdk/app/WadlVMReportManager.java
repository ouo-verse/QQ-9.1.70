package com.tencent.gamecenter.wadl.sdk.app;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.api.IQQGameReportService;
import com.tencent.gamecenter.wadl.api.WadlRequest;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.h;
import com.tencent.gamecenter.wadl.sdk.dlcom.WadlUtils;
import com.tencent.gamecenter.wadl.sdk.dlmgr.WadlTask;
import com.tencent.gamecenter.wadl.sdk.dlmgr.WadlVMTaskManager;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes6.dex */
public class WadlVMReportManager {
    public static final String OPER_ID_VM_DOWNLOAD_DELETE = "209787";
    public static final String OPER_ID_VM_DOWNLOAD_FAIL = "209784";
    public static final String OPER_ID_VM_DOWNLOAD_PAUSE = "209788";
    public static final String OPER_ID_VM_DOWNLOAD_RESUME = "209789";
    public static final String OPER_ID_VM_DOWNLOAD_START = "209786";
    public static final String OPER_ID_VM_DOWNLOAD_SUCC = "209783";
    public static final String OPER_TYPE_APK_INSTALL = "26";
    public static final String OPER_TYPE_APK_REPLACED = "25";
    public static final String OPER_TYPE_APK_UNINSTALL = "24";
    public static final String OPER_TYPE_CLICK = "20";
    public static final String OPER_TYPE_DOWNLOAD_BREAK = "29";
    public static final String OPER_TYPE_DOWNLOAD_DELETE = "31";
    public static final String OPER_TYPE_DOWNLOAD_FAIL = "28";
    public static final String OPER_TYPE_DOWNLOAD_INSTALL = "22";
    public static final String OPER_TYPE_DOWNLOAD_PAUSE = "30";
    public static final String OPER_TYPE_DOWNLOAD_RESUME = "23";
    public static final String OPER_TYPE_DOWNLOAD_START = "21";
    public static final String OPER_TYPE_DOWNLOAD_SUCCESS = "27";
    public static final String TAG = "Wadl_WadlVMReportManager";

    private static WadlTask findTaskByRequest(WadlRequest wadlRequest) {
        String str;
        Bundle bundle = wadlRequest.f106596h;
        if (bundle != null) {
            str = bundle.getString("packageName");
        } else {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            return WadlVMTaskManager.getInstance().findTaskByPkgName(str);
        }
        return null;
    }

    private static void handleDeleteReport(WadlTask wadlTask, h hVar) {
        if (wadlTask != null) {
            hVar.f106816c = wadlTask.taskStatus;
        }
        wadlReportDC(OPER_ID_VM_DOWNLOAD_DELETE, "31", hVar);
    }

    private static void handlePauseReport(h hVar) {
        wadlReportDC(OPER_ID_VM_DOWNLOAD_PAUSE, "30", hVar);
    }

    public static void handleReportDownload(WadlParams wadlParams) {
        if (wadlParams != null) {
            h b16 = h.b();
            b16.f106814a = wadlParams;
            wadlReportDC(OPER_ID_VM_DOWNLOAD_START, "21", b16);
            wadlReportDC04239(wadlParams, "virtual_download");
        }
    }

    private static void handleResumeReport(h hVar) {
        wadlReportDC(OPER_ID_VM_DOWNLOAD_RESUME, "23", hVar);
    }

    public static void reportDC(int i3, WadlTask wadlTask) {
        String str;
        if (i3 == 1008) {
            h b16 = h.b();
            b16.f106815b = String.valueOf(wadlTask.getAverageSpeed());
            b16.f106817d = wadlTask.f107253msg;
            String str2 = "1";
            if (WadlUtils.isPhoneRooted(MobileQQ.sMobileQQ)) {
                str = "1";
            } else {
                str = "0";
            }
            b16.f106819f = str;
            b16.f106814a = wadlTask.mWadlParams;
            b16.f106824k = wadlTask.downloadFileSize;
            if (!WadlUtils.isScreenOn()) {
                str2 = "0";
            }
            b16.f106823j = str2;
            b16.f106820g = String.valueOf(wadlTask.mWadlParams.speedBuffer);
            if (!wadlTask.mWadlParams.getFlagEnable(524288)) {
                b16.f106821h = GameCenterUtil.getFileChannel(wadlTask.downloadFilePath);
            }
            b16.f106831r = String.valueOf(wadlTask.costTime);
            wadlReportDC(OPER_ID_VM_DOWNLOAD_SUCC, "27", b16);
            wadlReportDC04239(wadlTask.mWadlParams, "virtual_download_success");
            return;
        }
        if (i3 == 1005) {
            h b17 = h.b();
            b17.f106816c = wadlTask.errCode;
            b17.f106817d = wadlTask.f107253msg;
            b17.f106814a = wadlTask.mWadlParams;
            b17.f106824k = wadlTask.downloadFileSize;
            wadlReportDC(OPER_ID_VM_DOWNLOAD_FAIL, "28", b17);
            wadlReportDC04239(wadlTask.mWadlParams, "virtual_download_fail");
        }
    }

    public static void reportEvent(WadlRequest wadlRequest) {
        WadlTask findTaskByRequest = findTaskByRequest(wadlRequest);
        h b16 = h.b();
        if (findTaskByRequest != null) {
            b16.f106814a = findTaskByRequest.mWadlParams;
        }
        QLog.d(TAG, 1, "reportEvent cmd=" + wadlRequest.f106594e + ",wadlTask=" + findTaskByRequest);
        if (WadlProxyConsts.REMOTE_CMD_APP_PAUSE_ACTION.equals(wadlRequest.f106594e)) {
            handlePauseReport(b16);
        } else if (WadlProxyConsts.REMOTE_CMD_APP_RESUME_ACTION.equals(wadlRequest.f106594e)) {
            handleResumeReport(b16);
        } else if (WadlProxyConsts.REMOTE_CMD_APP_DELETE_ACTION.equals(wadlRequest.f106594e)) {
            handleDeleteReport(findTaskByRequest, b16);
        }
    }

    public static void wadlReportDC(String str, String str2, h hVar) {
        ((IQQGameReportService) QRoute.api(IQQGameReportService.class)).reportDC(str, str2, hVar, WadlProxyConsts.TAG_DC_00087);
    }

    public static void wadlReportDC04239(WadlParams wadlParams, String str) {
        ((IMiniAppService) QRoute.api(IMiniAppService.class)).reportMiniGameVirtual(wadlParams.appId, "page_view", str, "", null, null, String.valueOf(wadlParams.scene), wadlParams.launchVia, wadlParams.reportData);
    }
}
