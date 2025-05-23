package com.tencent.mobileqq.msf.core.i0.d;

import android.annotation.SuppressLint;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.e0.d;
import com.tencent.mobileqq.msf.core.m;
import com.tencent.mobileqq.msf.core.net.k;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.CodecWarpper;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a implements d {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: h, reason: collision with root package name */
    public static final String f248534h = "SocketRttMonitorReport";

    /* renamed from: i, reason: collision with root package name */
    public static final String f248535i = "key_socket_rtt_monitor_report";

    /* renamed from: j, reason: collision with root package name */
    public static final String f248536j = "key_interval_index";

    /* renamed from: k, reason: collision with root package name */
    public static final String f248537k = "key_statistic_rtt_count";

    /* renamed from: l, reason: collision with root package name */
    public static final String f248538l = "key_statistic_weak_net_count";

    /* renamed from: m, reason: collision with root package name */
    public static final String f248539m = "key_timeout_count";

    /* renamed from: n, reason: collision with root package name */
    public static final String f248540n = "key_network_type";

    /* renamed from: o, reason: collision with root package name */
    public static final String f248541o = "key_ip_family";

    /* renamed from: p, reason: collision with root package name */
    public static final String f248542p = "key_conn_cost_time";

    /* renamed from: q, reason: collision with root package name */
    public static final String f248543q = "key_conn_address";

    /* renamed from: r, reason: collision with root package name */
    public static final String f248544r = "key_socket_time";

    /* renamed from: s, reason: collision with root package name */
    public static final String f248545s = "key_conn_close_reason";

    /* renamed from: t, reason: collision with root package name */
    public static final String f248546t = "key_socket_all_retrans";

    /* renamed from: u, reason: collision with root package name */
    public static final String f248547u = "key_weak_net_strategy";

    /* renamed from: v, reason: collision with root package name */
    public static final int f248548v = -1;

    /* renamed from: w, reason: collision with root package name */
    public static final int f248549w = 50;

    /* renamed from: x, reason: collision with root package name */
    public static final int f248550x = 500;

    /* renamed from: y, reason: collision with root package name */
    public static final int f248551y = 11;

    /* renamed from: a, reason: collision with root package name */
    int[] f248552a;

    /* renamed from: b, reason: collision with root package name */
    int[] f248553b;

    /* renamed from: c, reason: collision with root package name */
    int f248554c;

    /* renamed from: d, reason: collision with root package name */
    long f248555d;

    /* renamed from: e, reason: collision with root package name */
    private final b f248556e;

    /* renamed from: f, reason: collision with root package name */
    private final AtomicBoolean f248557f;

    /* renamed from: g, reason: collision with root package name */
    private int f248558g;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f248559a;

        /* renamed from: b, reason: collision with root package name */
        public int f248560b;

        /* renamed from: c, reason: collision with root package name */
        public int f248561c;

        /* renamed from: d, reason: collision with root package name */
        public long f248562d;

        /* renamed from: e, reason: collision with root package name */
        public long f248563e;

        /* renamed from: f, reason: collision with root package name */
        public long f248564f;

        /* renamed from: g, reason: collision with root package name */
        public com.tencent.qphone.base.a f248565g;

        public b(String str, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, a.this, str, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            this.f248559a = str;
            this.f248560b = i3;
            this.f248561c = i16;
        }

        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            this.f248559a = "";
            this.f248560b = 0;
            this.f248561c = 0;
            this.f248562d = 0L;
            this.f248563e = 0L;
            this.f248564f = 0L;
            this.f248565g = com.tencent.qphone.base.a.netChange;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private static final a f248567a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26399);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f248567a = new a(null);
            }
        }

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* synthetic */ a(C8085a c8085a) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) c8085a);
    }

    public static a b() {
        return c.f248567a;
    }

    private void d() {
        this.f248557f.set(false);
        this.f248556e.a();
        Arrays.fill(this.f248552a, 0);
        Arrays.fill(this.f248553b, 0);
        this.f248558g = -1;
        this.f248554c = 0;
    }

    @Override // com.tencent.mobileqq.msf.core.e0.d
    public void a(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) toServiceMsg, (Object) fromServiceMsg);
            return;
        }
        if (!this.f248557f.get() || toServiceMsg == null || fromServiceMsg == null) {
            return;
        }
        if (fromServiceMsg.isSuccess()) {
            try {
                if (fromServiceMsg.getAttributes().containsKey(BaseConstants.TIMESTAMP_MSF2NET) && fromServiceMsg.getAttributes().containsKey(BaseConstants.TIMESTAMP_NET2MSF)) {
                    long longValue = ((Long) fromServiceMsg.getAttribute(BaseConstants.TIMESTAMP_NET2MSF)).longValue() - ((Long) fromServiceMsg.getAttribute(BaseConstants.TIMESTAMP_MSF2NET)).longValue();
                    r5 = fromServiceMsg.getAttributes().containsKey(BaseConstants.DELTA_TIME_SERVER) ? ((Integer) fromServiceMsg.getAttribute(BaseConstants.DELTA_TIME_SERVER)).longValue() : -1L;
                    j3 = longValue;
                } else {
                    j3 = 0;
                }
                a(fromServiceMsg, j3, r5);
                return;
            } catch (Exception e16) {
                QLog.e(f248534h, 1, "[onMessageReceive] calculate rtt error: ", e16);
                return;
            }
        }
        if (fromServiceMsg.getBusinessFailCode() == 1002) {
            this.f248554c++;
        }
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        int i3 = this.f248558g;
        if (i3 != -1) {
            try {
                this.f248555d = CodecWarpper.getSocketTotalRetrans(i3);
            } catch (Throwable th5) {
                QLog.d(f248534h, 1, "getSocketTotalRetrans fail", th5);
            }
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f248552a = new int[11];
        this.f248553b = new int[11];
        this.f248554c = 0;
        this.f248555d = 0L;
        this.f248557f = new AtomicBoolean(false);
        this.f248558g = -1;
        this.f248556e = new b("", 0, 0);
    }

    public void a(String str, int i3, int i16, int i17, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, str, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Long.valueOf(j3));
            return;
        }
        if (!m.i().g()) {
            QLog.d(f248534h, 1, "close socketStatisticReport by toggle");
            return;
        }
        b bVar = this.f248556e;
        bVar.f248559a = str;
        bVar.f248560b = i16;
        bVar.f248561c = i17;
        bVar.f248562d = j3;
        bVar.f248563e = System.currentTimeMillis();
        this.f248558g = i3;
        this.f248557f.set(true);
    }

    public void a(com.tencent.qphone.base.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) aVar);
            return;
        }
        if (m.i().g()) {
            b bVar = this.f248556e;
            bVar.f248565g = aVar;
            bVar.f248564f = System.currentTimeMillis();
            a();
            d();
        }
    }

    private void a(FromServiceMsg fromServiceMsg, long j3, long j16) {
        if (j16 <= 0 || j16 > j3) {
            return;
        }
        long j17 = j3 - j16;
        int i3 = j17 > 500 ? 10 : (int) (j17 / 50);
        int[] iArr = this.f248552a;
        iArr[i3] = iArr[i3] + 1;
        if (MsfService.getCore().isWeakNet()) {
            int[] iArr2 = this.f248553b;
            iArr2[i3] = iArr2[i3] + 1;
        }
    }

    @SuppressLint({"DefaultLocale"})
    private void a() {
        if (this.f248557f.get()) {
            for (int i3 = 0; i3 < 11; i3++) {
                int i16 = this.f248552a[i3];
                int i17 = this.f248553b[i3];
                if (i16 != 0) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(f248536j, String.valueOf(i3));
                    hashMap.put(f248537k, String.valueOf(i16));
                    a(hashMap);
                    MsfCore.sCore.statReporter.a(f248535i, true, 0L, 0L, (Map<String, String>) hashMap, true, false);
                }
                if (i17 != 0) {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put(f248536j, String.valueOf(i3));
                    hashMap2.put(f248538l, String.valueOf(i17));
                    a(hashMap2);
                    MsfCore.sCore.statReporter.a(f248535i, true, 0L, 0L, (Map<String, String>) hashMap2, true, false);
                }
            }
            if (this.f248554c != 0) {
                HashMap hashMap3 = new HashMap();
                hashMap3.put(f248536j, String.valueOf(-1));
                hashMap3.put(f248539m, String.valueOf(this.f248554c));
                a(hashMap3);
                MsfCore.sCore.statReporter.a(f248535i, true, 0L, 0L, (Map<String, String>) hashMap3, true, false);
            }
        }
    }

    private void a(Map<String, String> map) {
        map.put(f248540n, String.valueOf(this.f248556e.f248560b));
        map.put("key_ip_family", k.a(this.f248556e.f248561c));
        map.put(f248543q, this.f248556e.f248559a);
        map.put(f248542p, String.valueOf(this.f248556e.f248562d));
        b bVar = this.f248556e;
        map.put(f248544r, String.valueOf(bVar.f248564f - bVar.f248563e));
        map.put(f248545s, this.f248556e.f248565g.toString());
        map.put(f248546t, String.valueOf(this.f248555d));
        map.put(f248547u, String.valueOf(com.tencent.mobileqq.msf.core.i0.a.v().t()));
    }
}
