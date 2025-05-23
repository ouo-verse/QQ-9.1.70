package com.tencent.halley.common.d.b.b;

import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.halley.common.a.k;
import com.tencent.halley.common.b.a.f;
import com.tencent.halley.common.d.d;
import com.tencent.halley.common.d.h;
import com.tencent.halley.common.d.i;
import com.tencent.halley.common.utils.j;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes6.dex */
public class c implements d, Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    private static volatile c f113492b;

    /* renamed from: c, reason: collision with root package name */
    private static int f113493c;

    /* renamed from: a, reason: collision with root package name */
    public com.tencent.halley.common.d.c f113494a;

    /* renamed from: d, reason: collision with root package name */
    private Map<String, a> f113495d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f113496e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f113497f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f113498g;

    /* renamed from: h, reason: collision with root package name */
    private Handler f113499h;

    /* renamed from: i, reason: collision with root package name */
    private Map<String, b> f113500i;

    /* renamed from: j, reason: collision with root package name */
    private Runnable f113501j;

    /* renamed from: k, reason: collision with root package name */
    private Runnable f113502k;

    /* renamed from: l, reason: collision with root package name */
    private Runnable f113503l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public long f113508a;

        /* renamed from: b, reason: collision with root package name */
        public int f113509b;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
        }

        /* synthetic */ a(c cVar, byte b16) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, cVar, Byte.valueOf(b16));
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11813);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            f113492b = null;
            f113493c = -1;
        }
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f113495d = new HashMap();
        this.f113496e = false;
        this.f113497f = false;
        this.f113498g = false;
        this.f113500i = new ConcurrentHashMap();
        this.f113501j = new Runnable() { // from class: com.tencent.halley.common.d.b.b.c.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) c.this);
                }
            }

            @Override // java.lang.Runnable
            public final void run() {
                int i3;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                if (!c.this.f113497f) {
                    c.this.f113497f = true;
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    try {
                        com.tencent.halley.common.utils.d.a("halley-cloud-HttpPlatformConnection", "requestTask start");
                        com.tencent.halley.common.d.b.b.a aVar = new com.tencent.halley.common.d.b.b.a();
                        Iterator it = c.this.f113500i.values().iterator();
                        while (it.hasNext()) {
                            ((b) it.next()).a(aVar);
                        }
                        byte[] a16 = aVar.a();
                        if (j.a(a16)) {
                            a a17 = c.this.a(com.tencent.halley.common.a.c.b());
                            a17.f113508a = SystemClock.elapsedRealtime();
                            a17.f113509b = 0;
                            c.c(c.this);
                            c.this.f113497f = false;
                            return;
                        }
                        com.tencent.halley.common.utils.d.a("halley-cloud-HttpPlatformConnection", "HttpPlatform request:" + new String(a16));
                        com.tencent.halley.common.b.a.c a18 = com.tencent.halley.common.b.a.c.a("https://yun-hl.3g.qq.com/halleycloud", null, a16, 15000, j.h(), h.d().f());
                        a18.f113308p = c.f113493c;
                        a18.f113309q = "platform";
                        f b16 = a18.b();
                        i3 = b16.f113322a;
                        try {
                            com.tencent.halley.common.utils.d.a("halley-cloud-HttpPlatformConnection", "HttpPlatform rspCode:" + i3 + ",httpStatus:" + b16.f113324c);
                            if (b16.f113322a == 0 && b16.f113324c == 200) {
                                i3 = c.this.a(b16);
                            }
                            a18.f113296l = SystemClock.elapsedRealtime() - elapsedRealtime;
                            a18.a(false);
                        } catch (Throwable th5) {
                            th = th5;
                            try {
                                th.printStackTrace();
                            } finally {
                                a a19 = c.this.a(com.tencent.halley.common.a.c.b());
                                a19.f113508a = SystemClock.elapsedRealtime();
                                a19.f113509b = i3;
                                c.c(c.this);
                                c.this.f113497f = false;
                            }
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        i3 = 0;
                    }
                } else {
                    com.tencent.halley.common.utils.d.b("halley-cloud-HttpPlatformConnection", "isRequesting, just ignore..");
                }
            }
        };
        this.f113502k = new Runnable() { // from class: com.tencent.halley.common.d.b.b.c.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) c.this);
                }
            }

            @Override // java.lang.Runnable
            public final void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                try {
                    com.tencent.halley.common.utils.d.a("halley-cloud-HttpPlatformConnection", "checkTask start");
                    com.tencent.halley.common.a.c.e();
                    a a16 = c.this.a(com.tencent.halley.common.a.c.b());
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    int b16 = c.b(a16.f113509b);
                    long j3 = a16.f113508a;
                    if (elapsedRealtime - j3 > b16 || elapsedRealtime < j3) {
                        c.f();
                        if (!c.this.f113497f) {
                            com.tencent.halley.common.utils.d.a("halley-cloud-HttpPlatformConnection", "post requestTask");
                            com.tencent.halley.common.a.d.a().f113264a.execute(c.this.f113501j);
                        }
                    }
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
            }
        };
        this.f113503l = new Runnable() { // from class: com.tencent.halley.common.d.b.b.c.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) c.this);
                }
            }

            @Override // java.lang.Runnable
            public final void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                com.tencent.halley.common.utils.d.a("halley-cloud-HttpPlatformConnection", "delayCheckTask start");
                c.this.g();
                c.f(c.this);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(f fVar) {
        String str;
        Throwable th5;
        if (j.a(fVar.f113325d)) {
            return -320;
        }
        try {
            str = new String(fVar.f113325d);
        } catch (Throwable th6) {
            str = "";
            th5 = th6;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            com.tencent.halley.common.utils.d.a("halley-cloud-HttpPlatformConnection", "HttpPlatform rspData:".concat(str));
            com.tencent.halley.common.a.c.e();
            Iterator<b> it = this.f113500i.values().iterator();
            while (it.hasNext()) {
                it.next().a(jSONObject);
            }
            return 0;
        } catch (Throwable th7) {
            th5 = th7;
            th5.printStackTrace();
            fVar.f113323b = j.c("yun-hl.3g.qq.com") + "/" + str.substring(0, Math.min(str.length(), 20));
            return -321;
        }
    }

    static /* synthetic */ int b(int i3) {
        String str;
        int i16;
        if (i3 == 0) {
            str = "http_platform_update_interval_succ";
        } else {
            str = (i3 == -4 || i3 == -3) ? "http_platform_update_interval_nonet" : "http_platform_update_interval_fail";
        }
        if (i3 == 0) {
            i16 = 1800000;
        } else {
            i16 = (i3 == -4 || i3 == -3) ? 60000 : 300000;
        }
        return com.tencent.halley.common.a.h.a(str, 60000, 43200000, i16);
    }

    public static c c() {
        if (f113492b == null) {
            synchronized (c.class) {
                if (f113492b == null) {
                    f113492b = new c();
                }
            }
        }
        return f113492b;
    }

    static /* synthetic */ int f() {
        f113493c = 2;
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        this.f113499h.removeCallbacks(this.f113502k);
        this.f113499h.post(this.f113502k);
    }

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            if (com.tencent.halley.common.a.h.a("http_platform_start_update_on", 0, 1, 1) == 1) {
                com.tencent.halley.common.utils.d.c("halley-cloud-HttpPlatformConnection", "update on start");
                f113493c = 1;
                g();
                return;
            }
            com.tencent.halley.common.utils.d.c("halley-cloud-HttpPlatformConnection", "not update on start");
        }
    }

    static /* synthetic */ void c(c cVar) {
        if (cVar.f113495d.isEmpty()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, a> entry : cVar.f113495d.entrySet()) {
            a value = entry.getValue();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("lastCode", value.f113509b);
                jSONObject2.put("lastReqTime", value.f113508a);
                jSONObject.put(entry.getKey(), jSONObject2);
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
        i.a("apnrecords", jSONObject.toString(), true);
    }

    static /* synthetic */ boolean f(c cVar) {
        cVar.f113498g = false;
        return false;
    }

    @Override // com.tencent.halley.common.d.d
    public final void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (this.f113496e) {
            com.tencent.halley.common.utils.d.c("halley-cloud-HttpPlatformConnection", "already started");
        } else {
            com.tencent.halley.common.utils.d.c("halley-cloud-HttpPlatformConnection", "startPlatform");
            Handler h16 = com.tencent.halley.common.a.h();
            this.f113499h = h16;
            h16.post(this);
            this.f113499h.postDelayed(new Runnable() { // from class: com.tencent.halley.common.d.b.b.c.4
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) c.this);
                    }
                }

                @Override // java.lang.Runnable
                public final void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    int a16 = com.tencent.halley.common.a.h.a("detect_obtain_ip_type_interval", 0, 1000, 24);
                    com.tencent.halley.common.utils.d.b("halley-cloud-HttpPlatformConnection", "ready to obtain ip type report interval:".concat(String.valueOf(a16)));
                    if (a16 > 0) {
                        long b16 = i.b("next_detect_report_time");
                        long j3 = a16 * 60 * 60 * 1000;
                        if (b16 != 0 && System.currentTimeMillis() > b16) {
                            i.a("next_detect_report_time", System.currentTimeMillis() + j3);
                            com.tencent.halley.common.utils.d.b("halley-cloud-HttpPlatformConnection", "Report Not real detect..");
                            HashMap hashMap = new HashMap();
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append((int) com.tencent.halley.common.a.c.i());
                            hashMap.put("D9", sb5.toString());
                            hashMap.put("D40", com.tencent.halley.common.a.e());
                            String c16 = com.tencent.halley.common.a.c.c();
                            if (!TextUtils.isEmpty(c16)) {
                                hashMap.put("D39", c16);
                            }
                            k.a("HLNotRealDetectEvent", true, hashMap, false);
                            return;
                        }
                        if (b16 == 0) {
                            i.a("next_detect_report_time", System.currentTimeMillis() + j3);
                        }
                    }
                }
            }, 10000L);
        }
        this.f113494a.c();
    }

    @Override // com.tencent.halley.common.d.a
    public final void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            this.f113500i.get(QCircleDaTongConstant.ElementParamValue.SETTINGS).b();
        } else {
            iPatchRedirector.redirect((short) 5, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a a(String str) {
        JSONObject optJSONObject;
        byte b16 = 0;
        if (this.f113495d.isEmpty()) {
            try {
                String b17 = i.b("apnrecords", "", true);
                if (!b17.isEmpty()) {
                    JSONObject jSONObject = new JSONObject(b17);
                    Iterator keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String str2 = (String) keys.next();
                        if (!TextUtils.isEmpty(str2) && (optJSONObject = jSONObject.optJSONObject(str2)) != null) {
                            a aVar = new a(this, b16);
                            aVar.f113509b = optJSONObject.optInt("lastCode");
                            aVar.f113508a = optJSONObject.optLong("lastReqTime");
                            this.f113495d.put(str2, aVar);
                        }
                    }
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        a aVar2 = this.f113495d.get(str);
        if (aVar2 != null) {
            return aVar2;
        }
        a aVar3 = new a(this, b16);
        this.f113495d.put(str, aVar3);
        return aVar3;
    }

    @Override // com.tencent.halley.common.d.a
    public final void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            this.f113500i.get("accessscheduler").a();
        } else {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }

    @Override // com.tencent.halley.common.d.a
    public final void a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
            return;
        }
        com.tencent.halley.common.utils.d.a("halley-cloud-HttpPlatformConnection", "onHttpUsed:".concat(String.valueOf(i3)));
        if (i3 == 1) {
            g();
            return;
        }
        if (i3 == 2) {
            if (this.f113498g) {
                com.tencent.halley.common.utils.d.b("halley-cloud-HttpPlatformConnection", "timer is on , not do delay check..");
                return;
            }
            this.f113498g = true;
            int nextInt = (new Random().nextInt(com.tencent.halley.common.a.h.a("detect_platform_update_random_interval", 0, 1440, 10)) * 60 * 1000) + 1000;
            com.tencent.halley.common.utils.d.b("halley-cloud-HttpPlatformConnection", "check with delay PlatformInterval:".concat(String.valueOf(nextInt)));
            com.tencent.halley.common.a.j.a().a(this.f113503l, nextInt);
        }
    }

    private void a(b bVar) {
        this.f113500i.put(bVar.c(), bVar);
    }

    @Override // com.tencent.halley.common.d.d
    public final void a(com.tencent.halley.common.d.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) cVar);
            return;
        }
        this.f113494a = cVar;
        a(new com.tencent.halley.common.d.b.b.e.a());
        a(new com.tencent.halley.common.d.b.b.c.b());
        a(new com.tencent.halley.common.d.b.b.d.a());
        a(new com.tencent.halley.common.d.b.b.a.a());
    }
}
