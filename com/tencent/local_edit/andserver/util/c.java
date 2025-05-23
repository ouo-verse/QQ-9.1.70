package com.tencent.local_edit.andserver.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private static final SimpleDateFormat[] f119876a;

    /* renamed from: b, reason: collision with root package name */
    private static final TimeZone f119877b;

    /* renamed from: c, reason: collision with root package name */
    private static final SimpleDateFormat f119878c;

    static {
        Locale locale = Locale.US;
        f119876a = new SimpleDateFormat[]{new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", locale), new SimpleDateFormat("EEEEEE, dd-MMM-yy HH:mm:ss zzz", locale), new SimpleDateFormat("EEE MMMM d HH:mm:ss yyyy", locale)};
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        f119877b = timeZone;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", locale);
        f119878c = simpleDateFormat;
        simpleDateFormat.setTimeZone(timeZone);
    }

    public static String a(long j3) {
        String format;
        synchronized (c.class) {
            format = f119878c.format(new Date(j3));
        }
        return format;
    }

    public static long b(String str) {
        Date date = null;
        for (SimpleDateFormat simpleDateFormat : f119876a) {
            try {
                date = simpleDateFormat.parse(str);
            } catch (ParseException unused) {
            }
        }
        if (date == null) {
            return -1L;
        }
        return date.getTime();
    }
}
