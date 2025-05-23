package d;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.c0.g;
import com.tencent.mobileqq.msf.core.o;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.open.business.base.MobileInfoUtil;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static String f392549a = "";

    /* renamed from: b, reason: collision with root package name */
    private static int f392550b = 0;

    /* renamed from: c, reason: collision with root package name */
    private static int f392551c = 0;

    /* renamed from: d, reason: collision with root package name */
    private static long f392552d = 0;

    /* renamed from: e, reason: collision with root package name */
    private static long f392553e = 0;

    /* renamed from: f, reason: collision with root package name */
    private static long f392554f = 0;

    /* renamed from: g, reason: collision with root package name */
    private static boolean f392555g = false;

    /* renamed from: h, reason: collision with root package name */
    private static ConcurrentHashMap<String, Integer> f392556h = new ConcurrentHashMap<>(16);

    /* renamed from: i, reason: collision with root package name */
    private static double f392557i = 0.0d;

    /* renamed from: j, reason: collision with root package name */
    private static long f392558j = 0;

    /* renamed from: k, reason: collision with root package name */
    private static long f392559k = 0;

    /* renamed from: l, reason: collision with root package name */
    private static long f392560l = 0;

    /* renamed from: m, reason: collision with root package name */
    private static long f392561m = 0;

    /* renamed from: n, reason: collision with root package name */
    private static long f392562n = 0;

    /* renamed from: o, reason: collision with root package name */
    private static double f392563o = 0.0d;

    /* renamed from: p, reason: collision with root package name */
    private static String f392564p = "";

    /* renamed from: q, reason: collision with root package name */
    private static long f392565q = 0;

    /* renamed from: r, reason: collision with root package name */
    private static int f392566r = 0;

    /* renamed from: s, reason: collision with root package name */
    private static String f392567s = "";

    /* renamed from: t, reason: collision with root package name */
    private static long f392568t = 0;

    /* renamed from: u, reason: collision with root package name */
    private static int f392569u = 0;

    /* renamed from: v, reason: collision with root package name */
    private static boolean f392570v = false;

    /* renamed from: w, reason: collision with root package name */
    private static double f392571w = 0.0d;

    /* renamed from: x, reason: collision with root package name */
    private static ConcurrentHashMap<Integer, Integer> f392572x = new ConcurrentHashMap<>(16);

    public static void a() {
        try {
            e();
            f();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public static void b(String str, int i3, int i16) {
        f();
        f392549a = str;
        f392550b = i3;
        f392551c = i16;
        f392552d = SystemClock.elapsedRealtime();
        f392570v = a.f392523f;
    }

    public static void c(String str, int i3, long j3, int i16, int i17) {
        try {
            double d16 = f392557i;
            long j16 = f392558j;
            long j17 = j16 + 1;
            f392557i = ((d16 / j17) * j16) + (j3 / j17);
            f392558j = j17;
            if (!BaseConstants.CMD_SSO_LOGIN_MERGE.equals(str)) {
                f392559k++;
            } else if (i16 > 0) {
                f392559k += i16;
            }
            if (i17 > 0) {
                f392560l += i17;
            }
            if (TextUtils.isEmpty(f392564p) || f392565q < j3) {
                f392564p = str;
                f392565q = j3;
                f392566r = i3;
            }
            long j18 = f392552d;
            if (j18 > 0 && f392554f - j18 > 180000) {
                if (!f392555g) {
                    f392555g = true;
                    ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(32);
                    for (Map.Entry<String, Integer> entry : f392556h.entrySet()) {
                        if (entry.getValue().intValue() > 20) {
                            concurrentHashMap.put(entry.getKey(), "" + entry.getValue());
                        }
                    }
                    if (concurrentHashMap.size() > 0) {
                        concurrentHashMap.put("account", MsfService.getCore().getAccountCenter().e());
                        concurrentHashMap.put("ip", f392549a);
                        concurrentHashMap.put("port", "" + f392550b);
                        concurrentHashMap.put(TPReportKeys.LiveExKeys.LIVE_EX_NET_TYPE, "" + f392551c);
                        if (MsfService.getCore().getStatReporter() != null) {
                            MsfService.getCore().getStatReporter().a(g.C0, true, 0L, 0L, (Map<String, String>) concurrentHashMap, false, false);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            f392554f = SystemClock.elapsedRealtime();
            if (f392556h.containsKey(str)) {
                ConcurrentHashMap<String, Integer> concurrentHashMap2 = f392556h;
                concurrentHashMap2.put(str, Integer.valueOf(concurrentHashMap2.get(str).intValue() + 1));
            } else {
                f392556h.put(str, 1);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public static void d(String str, int i3, long j3, long j16, boolean z16) {
        try {
            f392553e = SystemClock.elapsedRealtime();
            double d16 = f392563o;
            long j17 = f392562n;
            long j18 = j17 + 1;
            f392563o = ((d16 / j18) * j17) + (j3 / j18);
            f392562n = j18;
            if (TextUtils.isEmpty(f392567s) || f392568t < j3) {
                f392567s = str;
                f392568t = j3;
                f392569u = i3;
            }
            if (!z16) {
                double d17 = f392571w;
                long j19 = f392561m;
                long j26 = 1 + j19;
                f392571w = ((d17 / j26) * j19) + (j16 / j26);
                f392561m = j26;
                if (!TextUtils.isEmpty(f392567s) && f392568t < j3) {
                    f392567s = str;
                    f392568t = j3;
                    f392569u = i3;
                }
                if (j16 <= 30000) {
                    int i16 = (int) (j16 / 1000);
                    if (f392572x.containsKey(Integer.valueOf(i16))) {
                        f392572x.put(Integer.valueOf(i16), Integer.valueOf(f392572x.get(Integer.valueOf(i16)).intValue() + 1));
                    } else {
                        f392572x.put(Integer.valueOf(i16), 1);
                    }
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private static void e() {
        Object obj;
        if (TextUtils.isEmpty(f392549a) || f392558j == 0) {
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(32);
        concurrentHashMap.put("account", MsfService.getCore().getAccountCenter().e());
        concurrentHashMap.put("ip", f392549a);
        concurrentHashMap.put("port", "" + f392550b);
        concurrentHashMap.put(TPReportKeys.LiveExKeys.LIVE_EX_NET_TYPE, "" + f392551c);
        concurrentHashMap.put(MobileInfoUtil.IMSI, o.f());
        concurrentHashMap.put("reqtotalcount", "" + f392559k);
        concurrentHashMap.put("reqnoresp", "" + f392560l);
        concurrentHashMap.put("reqcount", "" + f392558j);
        concurrentHashMap.put("avareqsize", "" + f392557i);
        concurrentHashMap.put("respcount", "" + f392561m);
        concurrentHashMap.put("resptotalcount", "" + f392562n);
        concurrentHashMap.put("avarespsize", "" + f392563o);
        concurrentHashMap.put("maxreqcmd", f392564p);
        concurrentHashMap.put("maxreqsize", "" + f392565q);
        concurrentHashMap.put("maxreqseq", "" + f392566r);
        concurrentHashMap.put("maxrespcmd", f392567s);
        concurrentHashMap.put("maxrespsize", "" + f392568t);
        concurrentHashMap.put("maxrespseq", "" + f392569u);
        concurrentHashMap.put("avacost", "" + f392571w);
        concurrentHashMap.put("conntime", "" + f392552d);
        concurrentHashMap.put("disconntime", "" + elapsedRealtime);
        concurrentHashMap.put("lastresptime", "" + f392553e);
        concurrentHashMap.put("lastreqtime", "" + f392554f);
        String str = "1";
        if (f392570v) {
            obj = "1";
        } else {
            obj = "0";
        }
        concurrentHashMap.put("crossOper", obj);
        concurrentHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
        if (!f392570v) {
            str = "0";
        }
        concurrentHashMap.put("param_FailCode", str);
        if (f392572x.size() > 0) {
            StringBuilder sb5 = new StringBuilder();
            for (Map.Entry<Integer, Integer> entry : f392572x.entrySet()) {
                sb5.append(entry.getKey());
                sb5.append(":");
                sb5.append(entry.getValue());
                sb5.append("|");
            }
            concurrentHashMap.put("costmap", sb5.toString());
        }
        if (MsfService.getCore().getStatReporter() != null) {
            MsfService.getCore().getStatReporter().a(g.B0, true, (long) f392571w, (int) f392557i, (Map<String, String>) concurrentHashMap, false, false);
        }
    }

    private static void f() {
        f392549a = "";
        f392550b = 0;
        f392551c = 0;
        f392552d = 0L;
        f392554f = 0L;
        f392555g = false;
        f392553e = 0L;
        f392557i = 0.0d;
        f392563o = 0.0d;
        f392559k = 0L;
        f392560l = 0L;
        f392558j = 0L;
        f392561m = 0L;
        f392562n = 0L;
        f392564p = "";
        f392565q = 0L;
        f392566r = 0;
        f392567s = "";
        f392568t = 0L;
        f392569u = 0;
        f392556h.clear();
        f392570v = false;
        f392571w = 0.0d;
        f392572x.clear();
    }
}
