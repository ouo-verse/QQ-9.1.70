package com.google.android.material.datepicker;

import android.os.Build;
import android.text.format.DateUtils;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public class d {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static Pair<String, String> a(@Nullable Long l3, @Nullable Long l16) {
        return b(l3, l16, null);
    }

    static Pair<String, String> b(@Nullable Long l3, @Nullable Long l16, @Nullable SimpleDateFormat simpleDateFormat) {
        if (l3 == null && l16 == null) {
            return Pair.create(null, null);
        }
        if (l3 == null) {
            return Pair.create(null, d(l16.longValue(), simpleDateFormat));
        }
        if (l16 == null) {
            return Pair.create(d(l3.longValue(), simpleDateFormat), null);
        }
        Calendar o16 = o.o();
        Calendar q16 = o.q();
        q16.setTimeInMillis(l3.longValue());
        Calendar q17 = o.q();
        q17.setTimeInMillis(l16.longValue());
        if (simpleDateFormat != null) {
            return Pair.create(simpleDateFormat.format(new Date(l3.longValue())), simpleDateFormat.format(new Date(l16.longValue())));
        }
        if (q16.get(1) == q17.get(1)) {
            if (q16.get(1) == o16.get(1)) {
                return Pair.create(f(l3.longValue(), Locale.getDefault()), f(l16.longValue(), Locale.getDefault()));
            }
            return Pair.create(f(l3.longValue(), Locale.getDefault()), k(l16.longValue(), Locale.getDefault()));
        }
        return Pair.create(k(l3.longValue(), Locale.getDefault()), k(l16.longValue(), Locale.getDefault()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String c(long j3) {
        return d(j3, null);
    }

    static String d(long j3, @Nullable SimpleDateFormat simpleDateFormat) {
        Calendar o16 = o.o();
        Calendar q16 = o.q();
        q16.setTimeInMillis(j3);
        if (simpleDateFormat != null) {
            return simpleDateFormat.format(new Date(j3));
        }
        if (o16.get(1) == q16.get(1)) {
            return e(j3);
        }
        return j(j3);
    }

    static String e(long j3) {
        return f(j3, Locale.getDefault());
    }

    static String f(long j3, Locale locale) {
        String format;
        if (Build.VERSION.SDK_INT >= 24) {
            format = o.c(locale).format(new Date(j3));
            return format;
        }
        return o.j(locale).format(new Date(j3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String g(long j3) {
        return h(j3, Locale.getDefault());
    }

    static String h(long j3, Locale locale) {
        String format;
        if (Build.VERSION.SDK_INT >= 24) {
            format = o.d(locale).format(new Date(j3));
            return format;
        }
        return o.h(locale).format(new Date(j3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String i(long j3) {
        return DateUtils.formatDateTime(null, j3, 8228);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String j(long j3) {
        return k(j3, Locale.getDefault());
    }

    static String k(long j3, Locale locale) {
        String format;
        if (Build.VERSION.SDK_INT >= 24) {
            format = o.s(locale).format(new Date(j3));
            return format;
        }
        return o.i(locale).format(new Date(j3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String l(long j3) {
        return m(j3, Locale.getDefault());
    }

    static String m(long j3, Locale locale) {
        String format;
        if (Build.VERSION.SDK_INT >= 24) {
            format = o.t(locale).format(new Date(j3));
            return format;
        }
        return o.h(locale).format(new Date(j3));
    }
}
