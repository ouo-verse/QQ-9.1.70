package com.tencent.richframework.common;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.biz.richframework.config.RFWCommonConfig;
import com.tencent.mobileqq.qcircle.api.global.QCircleHostGlobalInfo;

/* compiled from: P */
/* loaded from: classes25.dex */
public class RFWCommonGlobalInfo {
    private static String sCurMsfServerId = "";

    public static String getCurMsfServerId() {
        SharedPreferences shareSp;
        if (TextUtils.isEmpty(sCurMsfServerId) && (shareSp = RFWCommonConfig.getShareSp()) != null) {
            sCurMsfServerId = shareSp.getString("rfw_common_msf_server_id", "production");
        }
        return sCurMsfServerId;
    }

    public static String getMsfServerConfData() {
        SharedPreferences shareSp = RFWCommonConfig.getShareSp();
        if (shareSp == null) {
            return "";
        }
        return shareSp.getString("rfw_common_msf_server_conf_data", "");
    }

    public static void saveMsfServerConfData(String str) {
        SharedPreferences shareSp = RFWCommonConfig.getShareSp();
        if (shareSp != null) {
            shareSp.edit().putString("rfw_common_msf_server_conf_data", str).apply();
        }
    }

    public static void setCurMsfServerId(String str) {
        sCurMsfServerId = str;
        QCircleHostGlobalInfo.setCurMsfServerId(str);
    }
}
