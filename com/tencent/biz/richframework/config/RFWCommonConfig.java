package com.tencent.biz.richframework.config;

import android.content.SharedPreferences;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RFWCommonConfig {
    public static String getCurrentMsfServerName() {
        return getShareSp().getString("rfw_common_msf_server_name", "\u6b63\u5f0f\u73af\u5883");
    }

    public static SharedPreferences getShareSp() {
        return RFWApplication.getApplication().getSharedPreferences("RFW_COMMON_SHARE", 0);
    }

    public static void setCurrentAdInfo(String str) {
        getShareSp().edit().putString("rfw_common_ad_attach_info", str).apply();
    }
}
