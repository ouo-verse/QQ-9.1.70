package com.qzone.util;

import android.text.TextUtils;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.util.URLUtil;

/* compiled from: P */
/* loaded from: classes37.dex */
public class an {
    public static String a(String str) {
        return (TextUtils.isEmpty(str) || !QQTheme.isNowThemeIsNightForQzone()) ? str : str.replace("/day/", "/night/");
    }

    public static String b(String str) {
        return (TextUtils.isEmpty(str) || !QQTheme.isNowThemeIsNightForQzone()) ? str : URLUtil.addParameter(str, "darkMode", "1");
    }
}
