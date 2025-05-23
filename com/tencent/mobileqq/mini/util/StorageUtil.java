package com.tencent.mobileqq.mini.util;

import android.content.SharedPreferences;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes33.dex */
public class StorageUtil {
    public static final String PRE_MINI_APP = "pre_miniapp";
    public static final String PRE_MINI_APP_AD = "pre_miniapp_ad";
    private static SharedPreferences sPreMiniAppAdSp;
    private static SharedPreferences sPreMiniAppSp;

    public static SharedPreferences getAdPreference() {
        if (sPreMiniAppAdSp == null) {
            sPreMiniAppAdSp = BaseApplication.getContext().getSharedPreferences(PRE_MINI_APP_AD, 4);
        }
        return sPreMiniAppAdSp;
    }

    public static SharedPreferences getPreference() {
        if (sPreMiniAppSp == null) {
            sPreMiniAppSp = BaseApplication.getContext().getSharedPreferences("pre_miniapp", 4);
        }
        return sPreMiniAppSp;
    }
}
