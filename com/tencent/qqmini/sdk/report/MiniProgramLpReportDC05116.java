package com.tencent.qqmini.sdk.report;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.ipc.AppBrandCmdProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import com.tenpay.proxy.dlg.location.QbAddrData;
import java.net.MalformedURLException;
import java.net.URL;

/* loaded from: classes23.dex */
public class MiniProgramLpReportDC05116 {
    private static final String TAG = "MiniProgramLpReportDC05";

    public static void reportOneHttpOrDownloadRequest(MiniAppInfo miniAppInfo, String str, long j3, long j16, int i3) {
        String str2;
        String str3;
        String str4;
        String str5;
        if (miniAppInfo != null && miniAppInfo.appId != null && !TextUtils.isEmpty(str)) {
            if (j3 != 0) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            String str6 = str2;
            String valueOf = String.valueOf(i3);
            String qua = QUAUtil.getQUA();
            String platformId = ((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).getPlatformId();
            String appVersion = ((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).getAppVersion();
            String loginType = QUAUtil.getLoginType();
            try {
                str3 = new URL(str).getHost();
            } catch (MalformedURLException e16) {
                QMLog.e(TAG, "reportOneHttpOrDownloadRequest", e16);
                str3 = str;
            }
            if (str.indexOf(63) != -1) {
                str4 = str.substring(0, str.indexOf(63));
            } else {
                str4 = str;
            }
            String str7 = miniAppInfo.appId + QbAddrData.DATA_SPLITER + str + QbAddrData.DATA_SPLITER + str6 + QbAddrData.DATA_SPLITER + valueOf + QbAddrData.DATA_SPLITER + j16 + QbAddrData.DATA_SPLITER + j3 + QbAddrData.DATA_SPLITER + str3 + QbAddrData.DATA_SPLITER + str4 + QbAddrData.DATA_SPLITER + MiniProgramReportHelper.getNetworkType() + QbAddrData.DATA_SPLITER + miniAppInfo.getReportType() + QbAddrData.DATA_SPLITER + "android" + QbAddrData.DATA_SPLITER + System.currentTimeMillis();
            if (!QUAUtil.isQQApp()) {
                str7 = str7 + QbAddrData.DATA_SPLITER + qua + QbAddrData.DATA_SPLITER + platformId + QbAddrData.DATA_SPLITER + appVersion + QbAddrData.DATA_SPLITER + loginType;
            }
            Bundle bundle = new Bundle();
            if (QUAUtil.isQQApp()) {
                str5 = "dc05116";
            } else {
                str5 = "dc05388";
            }
            bundle.putString("log_key", str5);
            bundle.putStringArray("data", new String[]{str7});
            AppBrandCmdProxy.g().sendCmd("cmd_dc_report_log_key_data", bundle, null);
        }
    }
}
