package com.tencent.qcircle.weseevideo.model.utils;

import android.text.TextUtils;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes22.dex */
public class LocaleUtils {
    private static final String CHINA = "zh_CN";
    private static final String HONGKONG = "zh_HK";
    public static final String LANGUAGE_DEFAULT = "en";
    public static final String LANGUAGE_KEY = "language_key";
    public static final String L_ENGLISH = "en";
    public static final String L_JAPANESE = "ja";
    public static final String L_JAPANESE_2 = "ja_JP";
    public static final String L_KOREAN = "ko";
    public static final String L_KOREAN_2 = "ko_KR";
    public static final String L_SIMPLE_CHINESE = "zh-Hans";
    public static final String L_SIMPLE_CHINESE_2 = "zh_Hans";
    public static final String L_TRADITIONAL_CHINESE = "zh-Hant";
    private static final String TAIWAN = "zh_TW";
    public static String mCurrentAppLanguage;

    private static String filterLanguage(String str) {
        String trim = Locale.getDefault().getLanguage().trim();
        if (trim.equals("en")) {
            return "en";
        }
        String languageCountryLocale = getLanguageCountryLocale();
        if (!languageCountryLocale.equals(TAIWAN) && !languageCountryLocale.equals(HONGKONG)) {
            if (languageCountryLocale.equals(CHINA)) {
                return L_SIMPLE_CHINESE;
            }
            if (trim.equals(L_JAPANESE)) {
                return L_JAPANESE;
            }
            if (trim.equals(L_KOREAN)) {
                return L_KOREAN;
            }
            return str;
        }
        return L_TRADITIONAL_CHINESE;
    }

    public static String getApplicationLanguage() {
        if (!TextUtils.isEmpty(mCurrentAppLanguage)) {
            return mCurrentAppLanguage;
        }
        return filterLanguage("en");
    }

    private static String getLanguageCountryLocale() {
        return Locale.getDefault().getLanguage().trim() + "_" + Locale.getDefault().getCountry().trim();
    }

    public static Locale getLocale(String str) {
        if (!CHINA.equals(str) && !L_SIMPLE_CHINESE_2.equals(str)) {
            if (HONGKONG.equals(str)) {
                return Locale.TRADITIONAL_CHINESE;
            }
            if (L_JAPANESE_2.equals(str)) {
                return Locale.JAPAN;
            }
            if (L_KOREAN_2.equals(str)) {
                return Locale.KOREA;
            }
            return Locale.US;
        }
        return Locale.SIMPLIFIED_CHINESE;
    }
}
