package com.tencent.luggage.wxa.ar;

import android.text.TextUtils;
import java.util.Calendar;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a0 {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public boolean f121611a = false;

        /* renamed from: b, reason: collision with root package name */
        public Object f121612b;

        public double a() {
            Object obj = this.f121612b;
            if (obj == null) {
                return 0.0d;
            }
            return ((Double) obj).doubleValue();
        }

        public int b() {
            Object obj = this.f121612b;
            if (obj == null) {
                return 0;
            }
            return ((Integer) obj).intValue();
        }
    }

    public static double a(long j3) {
        Calendar.getInstance().setTimeInMillis(j3);
        return r0.get(11) + (r0.get(12) / 60.0d);
    }

    public static a b(String str) {
        a aVar = new a();
        try {
            aVar.f121612b = Double.valueOf(Double.parseDouble(str));
            aVar.f121611a = true;
        } catch (Throwable th5) {
            x0.a("NumberUtil", "safeParseDouble error", th5);
        }
        return aVar;
    }

    public static a c(String str) {
        a aVar = new a();
        if (str == null) {
            return aVar;
        }
        try {
            String trim = str.trim();
            while (trim.startsWith("0") && trim.length() > 1) {
                trim = trim.substring(1);
            }
            aVar.f121612b = Integer.valueOf(Integer.parseInt(trim));
            aVar.f121611a = true;
        } catch (Throwable th5) {
            x0.a("NumberUtil", "safeParseInt error", th5);
        }
        return aVar;
    }

    public static double a() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(11) + (calendar.get(12) / 60.0d);
    }

    public static long b() {
        Calendar calendar = Calendar.getInstance();
        return ((24 - calendar.get(11)) * 3600000) - (calendar.get(12) * 60000);
    }

    public static double a(String str) {
        String[] split;
        if (!TextUtils.isEmpty(str) && (split = str.split(":")) != null && split.length != 0) {
            a b16 = b(split[0]);
            if (!b16.f121611a) {
                return -1.0d;
            }
            double a16 = b16.a();
            if (split.length == 2) {
                int b17 = c(split[1]).b();
                if (b17 < 0 || b17 >= 60) {
                    return -1.0d;
                }
                a16 += (b17 * 1.0d) / 60.0d;
            }
            if (a16 >= 0.0d && a16 <= 24.0d) {
                return a16;
            }
        }
        return -1.0d;
    }
}
