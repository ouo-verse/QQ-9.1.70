package com.tencent.mobileqq.qcircle.api.utils;

import android.text.TextUtils;
import android.util.Pair;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tencent.mobileqq.qcircle.api.data.QFSFlowPeakRuleBean;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import uq3.o;

/* compiled from: P */
/* loaded from: classes16.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static int f261729a = -1;

    /* renamed from: b, reason: collision with root package name */
    private static int f261730b = -1;

    /* renamed from: h, reason: collision with root package name */
    private static boolean f261736h;

    /* renamed from: i, reason: collision with root package name */
    private static boolean f261737i;

    /* renamed from: j, reason: collision with root package name */
    private static int f261738j;

    /* renamed from: k, reason: collision with root package name */
    private static int f261739k;

    /* renamed from: c, reason: collision with root package name */
    private static final Gson f261731c = new Gson();

    /* renamed from: d, reason: collision with root package name */
    private static final Type f261732d = new a().getType();

    /* renamed from: e, reason: collision with root package name */
    private static int f261733e = -1;

    /* renamed from: f, reason: collision with root package name */
    private static QFSFlowPeakRuleBean f261734f = null;

    /* renamed from: g, reason: collision with root package name */
    private static final SimpleDateFormat f261735g = new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT);

    /* renamed from: l, reason: collision with root package name */
    private static boolean f261740l = false;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class a extends TypeToken<QFSFlowPeakRuleBean> {
        a() {
        }
    }

    private static Calendar a() {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            return calendar;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean b(int i3) {
        try {
            Calendar a16 = a();
            if (a16 == null) {
                return false;
            }
            if (a16.get(1) != i3) {
                return false;
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static boolean c(String str) {
        try {
            Calendar a16 = a();
            if (a16 == null) {
                return false;
            }
            return Arrays.asList(str.split("\\|")).contains(String.valueOf(a16.get(11)));
        } catch (Throwable unused) {
            return false;
        }
    }

    private static boolean d(int i3, String str) {
        try {
            String[] split = str.split("-");
            int parseInt = Integer.parseInt(split[0]);
            int parseInt2 = Integer.parseInt(split[1]);
            Calendar a16 = a();
            if (a16 == null) {
                return false;
            }
            int i16 = a16.get(1);
            int i17 = a16.get(2) + 1;
            int i18 = a16.get(5);
            if (i16 != i3 || parseInt != i17 || parseInt2 != i18) {
                return false;
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static boolean e(int i3, List<QFSFlowPeakRuleBean.Holiday> list) {
        boolean d16;
        if (a() != null && list != null && !list.isEmpty()) {
            Iterator<QFSFlowPeakRuleBean.Holiday> it = list.iterator();
            while (it.hasNext()) {
                String dates = it.next().getDates();
                if (!TextUtils.isEmpty(dates)) {
                    String[] split = dates.split("_");
                    if (split.length == 0) {
                        continue;
                    } else {
                        String str = split[0];
                        if (split.length >= 2) {
                            d16 = f(i3, str, split[1]);
                        } else {
                            d16 = d(i3, str);
                        }
                        if (d16) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private static boolean f(int i3, String str, String str2) {
        return j(i3 + "-" + str, i3 + "-" + str2);
    }

    public static boolean g() {
        s();
        if (f261729a == 2) {
            return true;
        }
        return false;
    }

    public static boolean h() {
        s();
        if (f261730b == 1) {
            return true;
        }
        return false;
    }

    public static boolean i() {
        s();
        if (f261730b == 2) {
            return true;
        }
        return false;
    }

    private static boolean j(String str, String str2) {
        try {
            Calendar a16 = a();
            if (a16 == null) {
                return false;
            }
            Date time = a16.getTime();
            SimpleDateFormat simpleDateFormat = f261735g;
            Date parse = simpleDateFormat.parse(str);
            Date parse2 = simpleDateFormat.parse(str2);
            if (!time.after(parse)) {
                return false;
            }
            if (!time.before(parse2)) {
                return false;
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static boolean k() {
        Calendar a16 = a();
        if (a16 == null) {
            return false;
        }
        int i3 = a16.get(7);
        if (i3 != 7 && i3 != 1) {
            return false;
        }
        return true;
    }

    private static Pair<Integer, Integer> l(QFSFlowPeakRuleBean qFSFlowPeakRuleBean) {
        int m3;
        int n3;
        try {
            boolean z16 = false;
            if (e(qFSFlowPeakRuleBean.getEffectiveYear(), qFSFlowPeakRuleBean.getWorkDayWhiteList())) {
                int o16 = o(qFSFlowPeakRuleBean.getNormal());
                int p16 = p(qFSFlowPeakRuleBean.getNormalStrict());
                r("workDayWhiteList", false, false, o16, p16);
                return new Pair<>(Integer.valueOf(o16), Integer.valueOf(p16));
            }
            if (qFSFlowPeakRuleBean.isJudgeWeek() && k()) {
                z16 = true;
            }
            boolean e16 = e(qFSFlowPeakRuleBean.getEffectiveYear(), qFSFlowPeakRuleBean.getHolidays());
            if (!e16 && !z16) {
                m3 = o(qFSFlowPeakRuleBean.getNormal());
                if (!e16 && !z16) {
                    n3 = p(qFSFlowPeakRuleBean.getNormalStrict());
                    r("normalLink", z16, e16, m3, n3);
                    return new Pair<>(Integer.valueOf(m3), Integer.valueOf(n3));
                }
                n3 = n(qFSFlowPeakRuleBean.getFestivalStrict());
                r("normalLink", z16, e16, m3, n3);
                return new Pair<>(Integer.valueOf(m3), Integer.valueOf(n3));
            }
            m3 = m(qFSFlowPeakRuleBean.getFestival());
            if (!e16) {
                n3 = p(qFSFlowPeakRuleBean.getNormalStrict());
                r("normalLink", z16, e16, m3, n3);
                return new Pair<>(Integer.valueOf(m3), Integer.valueOf(n3));
            }
            n3 = n(qFSFlowPeakRuleBean.getFestivalStrict());
            r("normalLink", z16, e16, m3, n3);
            return new Pair<>(Integer.valueOf(m3), Integer.valueOf(n3));
        } catch (Throwable unused) {
            return new Pair<>(-1, -1);
        }
    }

    private static int m(QFSFlowPeakRuleBean.Festival festival) {
        if (festival == null) {
            return -1;
        }
        if (c(festival.getHighRangTime())) {
            return 1;
        }
        return 2;
    }

    private static int n(QFSFlowPeakRuleBean.FestivalStrict festivalStrict) {
        if (festivalStrict == null) {
            return -1;
        }
        if (c(festivalStrict.getHighRangTime())) {
            return 1;
        }
        return 2;
    }

    private static int o(QFSFlowPeakRuleBean.Normal normal) {
        if (normal == null) {
            return -1;
        }
        if (c(normal.getHighRangTime())) {
            return 1;
        }
        return 2;
    }

    private static int p(QFSFlowPeakRuleBean.NormalStrict normalStrict) {
        if (normalStrict == null) {
            return -1;
        }
        if (c(normalStrict.getHighRangTime())) {
            return 1;
        }
        return 2;
    }

    private static QFSFlowPeakRuleBean q() {
        int size;
        try {
            if (!o.h1()) {
                return null;
            }
            String U = o.U("{\"holidays\":[{\"name\":\"\u5143\u65e6\",\"dates\":\"1-1\"},{\"name\":\"\u5bd2\u5047\",\"dates\":\"1-20_2-20\"},{\"name\":\"\u6625\u8282\",\"dates\":\"2-10_2-17\"},{\"name\":\"\u6e05\u660e\u8282\",\"dates\":\"4-4_4-6\"},{\"name\":\"\u52b3\u52a8\u8282\",\"dates\":\"5-1_5-5\"},{\"name\":\"\u7aef\u5348\u8282\",\"dates\":\"6-10\"},{\"name\":\"\u6691\u5047\",\"dates\":\"7-1_8-31\"},{\"name\":\"\u4e2d\u79cb\u8282\",\"dates\":\"9-15_9-17\"},{\"name\":\"\u56fd\u5e86\u8282\",\"dates\":\"10-1_10-7\"}],\"workDayWhiteList\":[{\"name\":\"\u4e2d\u79cb\u524d\u8c03\u73ed\",\"dates\":\"9-14\"},{\"name\":\"\u56fd\u5e86\u524d\u8c03\u73ed\",\"dates\":\"9-29\"},{\"name\":\"\u56fd\u5e86\u540e\u8c03\u73ed\",\"dates\":\"10-12\"}],\"normal\":{\"highRangTime\":\"8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|0\"},\"normalStrict\":{\"highRangTime\":\"11|12|13|14|17|18|19|20|21|22|23\"},\"festival\":{\"highRangTime\":\"8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|0\"},\"festivalStrict\":{\"highRangTime\":\"10|11|12|13|14|15|16|17|18|19|20|21|22|23\"},\"effectiveYear\":2024,\"isJudgeWeek\":true}");
            int hashCode = U.hashCode();
            if (hashCode == f261733e) {
                return f261734f;
            }
            QFSFlowPeakRuleBean qFSFlowPeakRuleBean = (QFSFlowPeakRuleBean) f261731c.fromJson(U, f261732d);
            f261734f = qFSFlowPeakRuleBean;
            List<QFSFlowPeakRuleBean.Holiday> holidays = qFSFlowPeakRuleBean.getHolidays();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[initFlowPeakConfig] flow peak rule holiday count:");
            if (holidays == null) {
                size = 0;
            } else {
                size = holidays.size();
            }
            sb5.append(size);
            sb5.append(" json: ");
            sb5.append(U);
            QLog.d("QFSFlowPeakRuleUtils", 1, sb5.toString());
            f261733e = hashCode;
            return f261734f;
        } catch (Throwable th5) {
            QLog.d("QFSFlowPeakRuleUtils", 1, "[parseFlowPeakConfig]: ex: ", th5);
            return null;
        }
    }

    private static void r(String str, boolean z16, boolean z17, int i3, int i16) {
        if (f261736h != z16 || z17 != f261737i || i3 != f261738j || i16 != f261739k) {
            QLog.d("QFSFlowPeakRuleUtils", 1, "[obtainDeviceTimeFlowPeakState] tag: " + str + " | isWeekHoliday: " + z16 + " | isHoliday: " + z17 + " | timeFlowPeakState: " + i3 + " | timeFlowPeakStrictState\uff1a" + i16);
            f261736h = z16;
            f261737i = z17;
            f261738j = i3;
            f261739k = i16;
        }
    }

    private static void s() {
        QFSFlowPeakRuleBean q16 = q();
        if (q16 == null) {
            f261729a = -1;
            f261730b = -1;
        } else {
            if (!b(q16.getEffectiveYear())) {
                if (!f261740l) {
                    QLog.d("QFSFlowPeakRuleUtils", 1, "[updateCurrentFlowPeakState] current not effective year, config load fail.");
                    f261740l = true;
                }
                f261729a = -1;
                f261730b = -1;
                return;
            }
            Pair<Integer, Integer> l3 = l(q16);
            f261729a = ((Integer) l3.first).intValue();
            f261730b = ((Integer) l3.second).intValue();
        }
    }
}
