package com.tencent.mtt.hippy.utils;

import android.os.Build;
import android.os.LocaleList;
import android.text.TextUtils;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes20.dex */
public class I18nUtil {
    public static String getCountry() {
        return getLocale().getCountry();
    }

    public static String getLanguage() {
        return getLocale().getLanguage();
    }

    public static int getLayoutDirection() {
        return TextUtils.getLayoutDirectionFromLocale(getLocale());
    }

    private static Locale getLocale() {
        LocaleList localeList;
        Locale locale;
        if (Build.VERSION.SDK_INT >= 24) {
            localeList = LocaleList.getDefault();
            locale = localeList.get(0);
            return locale;
        }
        return Locale.getDefault();
    }

    public static boolean isRTL() {
        if (getLayoutDirection() == 1) {
            return true;
        }
        return false;
    }
}
