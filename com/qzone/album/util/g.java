package com.qzone.album.util;

import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.mobileqq.R;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes39.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public static final String f44368a = com.qzone.util.l.a(R.string.l_3);

    /* renamed from: b, reason: collision with root package name */
    public static final String f44369b = com.qzone.util.l.a(R.string.l_s);

    /* renamed from: c, reason: collision with root package name */
    public static final String f44370c = com.qzone.util.l.a(R.string.l_i);

    /* renamed from: d, reason: collision with root package name */
    public static final String f44371d = com.qzone.util.l.a(R.string.la_);

    /* renamed from: e, reason: collision with root package name */
    public static final String f44372e = com.qzone.util.l.a(R.string.l_z);

    /* renamed from: f, reason: collision with root package name */
    public static final String f44373f = com.qzone.util.l.a(R.string.la7);

    /* renamed from: g, reason: collision with root package name */
    public static final String f44374g = com.qzone.util.l.a(R.string.l_6);

    /* renamed from: h, reason: collision with root package name */
    public static final String f44375h = com.qzone.util.l.a(R.string.f171832la1);

    /* renamed from: i, reason: collision with root package name */
    public static final String f44376i = com.qzone.util.l.a(R.string.l9v);

    /* renamed from: j, reason: collision with root package name */
    public static final String f44377j = com.qzone.util.l.a(R.string.l_v);

    /* renamed from: k, reason: collision with root package name */
    public static final String f44378k = com.qzone.util.l.a(R.string.l_c);

    /* renamed from: l, reason: collision with root package name */
    public static final String f44379l = com.qzone.util.l.a(R.string.l_r);

    /* renamed from: m, reason: collision with root package name */
    public static final String f44380m = com.qzone.util.l.a(R.string.l_5);

    /* renamed from: n, reason: collision with root package name */
    public static final String f44381n = com.qzone.util.l.a(R.string.l_d);

    /* renamed from: o, reason: collision with root package name */
    public static final String f44382o = com.qzone.util.l.a(R.string.l_h);

    /* renamed from: p, reason: collision with root package name */
    public static final String f44383p = com.qzone.util.l.a(R.string.l9w);

    /* renamed from: q, reason: collision with root package name */
    public static final String f44384q = com.qzone.util.l.a(R.string.l_a);

    /* renamed from: r, reason: collision with root package name */
    public static final String f44385r = com.qzone.util.l.a(R.string.l_w);

    /* renamed from: s, reason: collision with root package name */
    public static final String f44386s = com.qzone.util.l.a(R.string.l_e);

    /* renamed from: t, reason: collision with root package name */
    public static final String f44387t = com.qzone.util.l.a(R.string.l_u);

    /* renamed from: u, reason: collision with root package name */
    public static final String f44388u = com.qzone.util.l.a(R.string.f171833la2);

    /* renamed from: v, reason: collision with root package name */
    public static final SimpleDateFormat f44389v = new SimpleDateFormat(DateUtil.DATE_FORMAT_HOUR, Locale.CHINA);

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a extends ThreadLocal<Calendar> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Calendar initialValue() {
            return Calendar.getInstance();
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class b extends ThreadLocal<Calendar> {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Calendar initialValue() {
            return Calendar.getInstance();
        }
    }

    public static String b(long j3) {
        Calendar calendar = new a().get();
        long currentTimeMillis = System.currentTimeMillis();
        calendar.setTimeInMillis(currentTimeMillis);
        int i3 = calendar.get(1);
        calendar.setTimeInMillis(j3);
        int i16 = calendar.get(1);
        int i17 = (calendar.get(2) + 1) - 0;
        int i18 = calendar.get(5);
        int i19 = calendar.get(11);
        int i26 = calendar.get(12);
        int i27 = (int) ((currentTimeMillis - j3) / 86400000);
        if (i27 == 0) {
            return String.format("%d:%02d", Integer.valueOf(i19), Integer.valueOf(i26));
        }
        if (i27 == 1) {
            return String.format("%s %d:%02d", f44388u, Integer.valueOf(i19), Integer.valueOf(i26));
        }
        if (i3 == i16) {
            return String.format("%d-%d %d:%02d", Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26));
        }
        return String.format("%d-%d-%d %d:%02d", Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26));
    }

    public static final String[] c(long j3) {
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(j3);
        calendar.getTimeInMillis();
        int i3 = calendar2.get(1);
        int i16 = calendar2.get(2) + 1;
        calendar2.get(5);
        return new String[]{String.valueOf(i3), String.valueOf(i16)};
    }

    public static final String d(long j3) {
        return e(j3, Calendar.getInstance());
    }

    public static final String e(long j3, Calendar calendar) {
        long i3 = i(calendar);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(j3);
        long timeInMillis = calendar.getTimeInMillis() - j3;
        long j16 = i3 - j3;
        int i16 = calendar2.get(11);
        int i17 = calendar2.get(12);
        if (timeInMillis >= 0) {
            if (j16 <= 0) {
                return f44371d + a(i16) + ":" + a(i17);
            }
            if (j16 > 0 && j16 < 86400000) {
                return f44372e + a(i16) + ":" + a(i17);
            }
            if (j16 >= 86400000 && j16 <= 172800500) {
                return f44373f + a(i16) + ":" + a(i17);
            }
        } else if (j16 <= 0 && l(calendar.getTimeInMillis(), j3)) {
            return f44371d + a(i16) + ":" + a(i17);
        }
        int i18 = calendar2.get(1);
        int i19 = calendar2.get(2) + 1;
        int i26 = calendar2.get(5);
        if (calendar.get(1) != i18) {
            return i18 + f44378k + a(i19) + f44379l + a(i26) + f44380m + " " + a(i16) + ":" + a(i17);
        }
        return a(i19) + f44379l + a(i26) + f44380m + a(i16) + ":" + a(i17);
    }

    public static final String f(long j3) {
        return f44389v.format(new Date(j3));
    }

    public static String g(long j3) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j3);
        return calendar.get(1) + "/" + (calendar.get(2) + 1) + "/" + calendar.get(5);
    }

    public static String h(long j3) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j3);
        StringBuilder sb5 = new StringBuilder();
        sb5.append(calendar.get(1));
        if (calendar.get(2) + 1 < 10) {
            sb5.append("0" + (calendar.get(2) + 1));
        } else {
            sb5.append(calendar.get(2) + 1);
        }
        if (calendar.get(5) < 10) {
            sb5.append("0" + calendar.get(5));
        } else {
            sb5.append(calendar.get(5));
        }
        return sb5.toString();
    }

    public static final long i(Calendar calendar) {
        return (((calendar.getTimeInMillis() - (((calendar.get(11) * 60) * 60) * 1000)) - ((calendar.get(12) * 60) * 1000)) - (calendar.get(13) * 1000)) - calendar.get(14);
    }

    public static boolean k(int i3, int i16) {
        Calendar calendar = new b().get();
        long currentTimeMillis = System.currentTimeMillis();
        calendar.setTimeInMillis(currentTimeMillis);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        long timeInMillis = currentTimeMillis - calendar.getTimeInMillis();
        return ((long) i3) <= timeInMillis && timeInMillis <= ((long) i16);
    }

    public static boolean l(long j3, long j16) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j3);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(j16);
        return calendar.get(1) == calendar2.get(1) && calendar.get(6) == calendar2.get(6);
    }

    static String a(int i3) {
        if (i3 < 10) {
            return '0' + String.valueOf(i3);
        }
        return String.valueOf(i3);
    }

    public static String j(long j3) {
        StringBuilder sb5;
        String str;
        int i3;
        Object obj;
        Object obj2;
        if (j3 >= 60000) {
            int round = (int) Math.round(((j3 % 60000) * 1.0d) / 1000.0d);
            if (round >= 60) {
                i3 = round / 60;
                round %= 60;
            } else {
                i3 = 0;
            }
            int i16 = (int) ((j3 / 60000) + i3);
            StringBuilder sb6 = new StringBuilder();
            if (i16 > 9) {
                obj = Integer.valueOf(i16);
            } else {
                obj = "0" + i16;
            }
            sb6.append(obj);
            sb6.append(":");
            if (round > 9) {
                obj2 = Integer.valueOf(round);
            } else {
                obj2 = "0" + round;
            }
            sb6.append(obj2);
            return sb6.toString();
        }
        int round2 = (int) Math.round((j3 * 1.0d) / 1000.0d);
        if (round2 > 9) {
            sb5 = new StringBuilder();
            str = "00:";
        } else {
            sb5 = new StringBuilder();
            str = "00:0";
        }
        sb5.append(str);
        sb5.append(round2);
        return sb5.toString();
    }
}
