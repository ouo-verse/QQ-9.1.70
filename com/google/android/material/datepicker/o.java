package com.google.android.material.datepicker;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.icu.text.DateFormat;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.mobileqq.R;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: P */
/* loaded from: classes2.dex */
class o {

    /* renamed from: a, reason: collision with root package name */
    static AtomicReference<k> f33612a = new AtomicReference<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long a(long j3) {
        Calendar q16 = q();
        q16.setTimeInMillis(j3);
        return f(q16).getTimeInMillis();
    }

    private static int b(@NonNull String str, @NonNull String str2, int i3, int i16) {
        while (i16 >= 0 && i16 < str.length() && str2.indexOf(str.charAt(i16)) == -1) {
            if (str.charAt(i16) != '\'') {
                i16 += i3;
            }
            do {
                i16 += i3;
                if (i16 >= 0 && i16 < str.length()) {
                }
                i16 += i3;
            } while (str.charAt(i16) != '\'');
            i16 += i3;
        }
        return i16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(24)
    public static DateFormat c(Locale locale) {
        return e("MMMd", locale);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(24)
    public static DateFormat d(Locale locale) {
        return e("MMMEd", locale);
    }

    @TargetApi(24)
    private static DateFormat e(String str, Locale locale) {
        DateFormat instanceForSkeleton;
        instanceForSkeleton = DateFormat.getInstanceForSkeleton(str, locale);
        instanceForSkeleton.setTimeZone(p());
        return instanceForSkeleton;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Calendar f(Calendar calendar) {
        Calendar r16 = r(calendar);
        Calendar q16 = q();
        q16.set(r16.get(1), r16.get(2), r16.get(5));
        return q16;
    }

    private static java.text.DateFormat g(int i3, Locale locale) {
        java.text.DateFormat dateInstance = java.text.DateFormat.getDateInstance(i3, locale);
        dateInstance.setTimeZone(n());
        return dateInstance;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static java.text.DateFormat h(Locale locale) {
        return g(0, locale);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static java.text.DateFormat i(Locale locale) {
        return g(2, locale);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static java.text.DateFormat j(Locale locale) {
        SimpleDateFormat simpleDateFormat = (SimpleDateFormat) i(locale);
        simpleDateFormat.applyPattern(u(simpleDateFormat.toPattern()));
        return simpleDateFormat;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SimpleDateFormat k() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(((SimpleDateFormat) java.text.DateFormat.getDateInstance(3, Locale.getDefault())).toPattern().replaceAll("\\s+", ""), Locale.getDefault());
        simpleDateFormat.setTimeZone(n());
        simpleDateFormat.setLenient(false);
        return simpleDateFormat;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String l(Resources resources, SimpleDateFormat simpleDateFormat) {
        String pattern = simpleDateFormat.toPattern();
        String string = resources.getString(R.string.f168762gi);
        String string2 = resources.getString(R.string.f168752gh);
        String string3 = resources.getString(R.string.f168742gg);
        if (pattern.replaceAll("[^y]", "").length() == 1) {
            pattern = pattern.replace("y", DateUtil.DATE_FORMAT_YEAR);
        }
        return pattern.replace("d", string3).replace("M", string2).replace("y", string);
    }

    static k m() {
        k kVar = f33612a.get();
        if (kVar == null) {
            return k.c();
        }
        return kVar;
    }

    private static TimeZone n() {
        return TimeZone.getTimeZone("UTC");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Calendar o() {
        Calendar a16 = m().a();
        a16.set(11, 0);
        a16.set(12, 0);
        a16.set(13, 0);
        a16.set(14, 0);
        a16.setTimeZone(n());
        return a16;
    }

    @TargetApi(24)
    private static android.icu.util.TimeZone p() {
        android.icu.util.TimeZone timeZone;
        timeZone = android.icu.util.TimeZone.getTimeZone("UTC");
        return timeZone;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Calendar q() {
        return r(null);
    }

    static Calendar r(@Nullable Calendar calendar) {
        Calendar calendar2 = Calendar.getInstance(n());
        if (calendar == null) {
            calendar2.clear();
        } else {
            calendar2.setTimeInMillis(calendar.getTimeInMillis());
        }
        return calendar2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(24)
    public static DateFormat s(Locale locale) {
        return e("yMMMd", locale);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(24)
    public static DateFormat t(Locale locale) {
        return e("yMMMEd", locale);
    }

    @NonNull
    private static String u(@NonNull String str) {
        int b16 = b(str, "yY", 1, 0);
        if (b16 >= str.length()) {
            return str;
        }
        String str2 = "EMd";
        int b17 = b(str, "EMd", 1, b16);
        if (b17 < str.length()) {
            str2 = "EMd,";
        }
        return str.replace(str.substring(b(str, str2, -1, b16) + 1, b17), " ").trim();
    }
}
