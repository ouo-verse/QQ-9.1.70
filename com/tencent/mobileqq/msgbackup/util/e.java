package com.tencent.mobileqq.msgbackup.util;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.msgbackup.transport.MsgBackupTransportProcessor;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes15.dex */
public class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static boolean f251403a;

    /* renamed from: b, reason: collision with root package name */
    public static String f251404b;

    /* renamed from: c, reason: collision with root package name */
    private static ConcurrentHashMap<String, Long> f251405c;

    /* renamed from: d, reason: collision with root package name */
    private static ConcurrentHashMap<String, Long> f251406d;

    /* renamed from: e, reason: collision with root package name */
    public static long f251407e;

    /* renamed from: f, reason: collision with root package name */
    public static long f251408f;

    /* renamed from: g, reason: collision with root package name */
    public static long f251409g;

    /* renamed from: h, reason: collision with root package name */
    public static long f251410h;

    /* renamed from: i, reason: collision with root package name */
    public static boolean f251411i;

    /* renamed from: j, reason: collision with root package name */
    public static long f251412j;

    /* renamed from: k, reason: collision with root package name */
    public static long f251413k;

    /* renamed from: l, reason: collision with root package name */
    public static long f251414l;

    /* renamed from: m, reason: collision with root package name */
    public static long f251415m;

    /* renamed from: n, reason: collision with root package name */
    public static long f251416n;

    /* renamed from: o, reason: collision with root package name */
    public static long f251417o;

    /* renamed from: p, reason: collision with root package name */
    public static long f251418p;

    /* renamed from: q, reason: collision with root package name */
    public static long f251419q;

    /* renamed from: r, reason: collision with root package name */
    private static ConcurrentHashMap<Long, Long> f251420r;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24153);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f251403a = true;
        f251404b = "MsgBackup_timeStats";
        f251405c = new ConcurrentHashMap<>(new HashMap(8));
        f251406d = new ConcurrentHashMap<>(new HashMap(10));
        f251407e = 0L;
        f251408f = 0L;
        f251409g = 0L;
        f251410h = 0L;
        f251411i = false;
        f251412j = 0L;
        f251413k = 0L;
        f251414l = 0L;
        f251415m = 0L;
        f251416n = 0L;
        f251417o = 0L;
        f251418p = 0L;
        f251419q = 0L;
        f251420r = new ConcurrentHashMap<>();
    }

    public static void a(long j3) {
        if (f251420r.containsKey(Long.valueOf(j3))) {
            Long l3 = f251420r.get(Long.valueOf(j3));
            if (l3 != null) {
                f.B(f251404b, "transport complete complete = %d", l3);
                f251409g += l3.longValue();
            }
            f251420r.remove(Long.valueOf(j3));
        }
    }

    public static void b() {
        if (f251406d.containsKey("statis_qianchums_start") && f251406d.containsKey("statis_qianchums_end")) {
            f251417o = f251406d.get("statis_qianchums_end").longValue() - f251406d.get("statis_qianchums_start").longValue();
            f.B(f251404b, "pure qianru time cost = %d ", Long.valueOf(f251419q));
            f.B(f251404b, "pure daoru time cost = %d,pb_unpack cost time = %d ", Long.valueOf(f251417o), Long.valueOf(f251418p));
        }
    }

    public static void c() {
        if (f251406d.containsKey("statis_qianchums_start") && f251406d.containsKey("statis_qianchums_end")) {
            long longValue = f251406d.get("statis_qianchums_end").longValue() - f251406d.get("statis_qianchums_start").longValue();
            f251415m = longValue;
            f.B(f251404b, "pure qianchu time cost = %d,pb_pack cost time = %d ", Long.valueOf(longValue), Long.valueOf(f251416n));
        }
    }

    public static void d() {
        if (f251406d.containsKey("statis_qianchums_start") && f251406d.containsKey("statis_qianchums_end")) {
            f251419q += f251406d.get("statis_qianchums_end").longValue() - f251406d.get("statis_qianchums_start").longValue();
        }
    }

    public static void e() {
        f251415m = 0L;
        f251416n = 0L;
        f251417o = 0L;
        f251418p = 0L;
        f251419q = 0L;
        f251406d.clear();
    }

    public static void f() {
        f.B(f251404b, "transport reset", new Object[0]);
        f251411i = false;
        f251409g = 0L;
        f251407e = 0L;
        f251408f = 0L;
        f251420r.clear();
    }

    public static void g(String str) {
        f251406d.put(str, Long.valueOf(System.currentTimeMillis()));
    }

    public static void h(long j3, long j16) {
        f251420r.put(Long.valueOf(j3), Long.valueOf(j16));
    }

    public static void i(long j3, long j16) {
        if (!f251411i) {
            f251407e = j16;
            f251411i = true;
        }
        f.B(f251404b, "transport increment = %d sMaxSpeed = %d, sMinSpeed = %d", Long.valueOf(j16), Long.valueOf(f251408f), Long.valueOf(f251407e));
        f.B(f251404b, "transport storeSpeed increment = %s", f.p(j16));
        if (j16 >= f251408f) {
            f251408f = j16;
        }
        if (j16 <= f251407e) {
            f251407e = j16;
        }
    }

    public static void j(String str, String str2) {
        Long remove;
        if (f251403a) {
            long uptimeMillis = SystemClock.uptimeMillis();
            if (str != null && (remove = f251405c.remove(str)) != null) {
                if (TextUtils.equals("total_transport_cost", str)) {
                    f251410h = uptimeMillis - remove.longValue();
                }
                if (TextUtils.equals("single_uin_cost", str)) {
                    f251412j += uptimeMillis - remove.longValue();
                }
                if (TextUtils.equals("total_daoru_cost", str)) {
                    f251413k += uptimeMillis - remove.longValue();
                }
                if (TextUtils.equals("cost_connect_total", str)) {
                    f251414l += uptimeMillis - remove.longValue();
                }
                if (QLog.isColorLevel()) {
                    QLog.i(f251404b, 2, str + ", cost=" + (uptimeMillis - remove.longValue()));
                } else {
                    Log.i(f251404b, str + ", cost=" + (uptimeMillis - remove.longValue()));
                }
            }
            if (str2 != null) {
                f251405c.put(str2, Long.valueOf(uptimeMillis));
            }
        }
    }

    public static void k() {
        d.b();
        c cVar = d.f251402a;
        cVar.f251375e = f251410h;
        cVar.f251393w = f251414l;
        if (MsgBackupTransportProcessor.u().x() == 2) {
            d.f251402a.f251394x = f251412j;
        } else {
            d.f251402a.f251394x = f251413k;
        }
        long j3 = f251410h;
        if (j3 > 0) {
            d.f251402a.f251376f = (f251409g * 1000.0d) / j3;
        }
        if (f251403a) {
            String p16 = f.p(f251408f);
            String p17 = f.p(f251407e);
            if (f251410h == 0) {
                f.B(f251404b, "transport speed error", new Object[0]);
                return;
            }
            f.B(f251404b, "transport speed sSizeCache.size = %d, sLogs.size = %d", Integer.valueOf(f251420r.size()), Integer.valueOf(f251405c.size()));
            long j16 = f251409g;
            long j17 = (1000 * j16) / f251410h;
            f.B(f251404b, "transport speed totalLength = %d B, totalElipse = %d ms", Long.valueOf(j16), Long.valueOf(f251410h));
            f.B(f251404b, "transport speed max = %s, min = %s, average = %s", p16, p17, f.p(j17));
            if (MsgBackupTransportProcessor.u().x() == 2) {
                f.B(f251404b, HardCodeUtil.qqStr(R.string.o_e), Long.valueOf(f251412j));
            }
        }
    }
}
