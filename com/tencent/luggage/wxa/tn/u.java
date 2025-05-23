package com.tencent.luggage.wxa.tn;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qcircle.weseevideo.model.utils.LocaleUtils;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class u {

    /* renamed from: a, reason: collision with root package name */
    public static Locale f141717a = Locale.getDefault();

    public static String a(String str) {
        String trim = Locale.getDefault().getLanguage().trim();
        String str2 = trim + "_" + Locale.getDefault().getCountry().trim();
        return trim.equals("en") ? trim : str2.equals("zh_TW") ? "zh_TW" : str2.equals("zh_HK") ? "zh_HK" : str2.equals("zh_CN") ? "zh_CN" : trim.equals("th") ? "th" : (trim.equals("id") || str2.equals("in_ID")) ? "id" : trim.equals("vi") ? "vi" : trim.equals("pt") ? "pt" : trim.equals("es") ? "es" : trim.equals("ru") ? "ru" : trim.equals("ar") ? "ar" : trim.equals(LocaleUtils.L_JAPANESE) ? LocaleUtils.L_JAPANESE : trim.equals("it") ? "it" : trim.equals(LocaleUtils.L_KOREAN) ? LocaleUtils.L_KOREAN : trim.equals("ms") ? "ms" : trim.equals(ReportConstant.COSTREPORT_TRANS) ? ReportConstant.COSTREPORT_TRANS : trim.equals("de") ? "de" : trim.equals("fr") ? "fr" : trim.equals("my") ? "my" : trim.equals("lo") ? "lo" : str;
    }

    public static String b(Context context) {
        return "language_default";
    }

    public static boolean b() {
        return a().equals("zh_CN");
    }

    public static String a() {
        String d16 = w0.d(t0.a(LocaleUtils.LANGUAGE_KEY));
        return (d16.length() <= 0 || d16.equals("language_default")) ? a("en") : d16;
    }

    public static String a(SharedPreferences sharedPreferences, Context context) {
        String d16 = w0.d(sharedPreferences.getString(LocaleUtils.LANGUAGE_KEY, null));
        return !w0.c(d16) ? d16 : "language_default";
    }

    public static String a(Context context) {
        String a16 = a(context.getSharedPreferences(z.f(), 0), context);
        return a16.equalsIgnoreCase("language_default") ? a() : a16;
    }
}
