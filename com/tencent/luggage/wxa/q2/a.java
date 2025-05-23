package com.tencent.luggage.wxa.q2;

import com.tencent.bugly.common.constants.Constants;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.q2.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6615a {

        /* renamed from: a, reason: collision with root package name */
        public String f137787a;

        /* renamed from: b, reason: collision with root package name */
        public String f137788b;

        /* renamed from: c, reason: collision with root package name */
        public String f137789c;

        /* renamed from: d, reason: collision with root package name */
        public String f137790d;

        /* renamed from: e, reason: collision with root package name */
        public String f137791e;

        /* renamed from: f, reason: collision with root package name */
        public String f137792f;

        /* renamed from: g, reason: collision with root package name */
        public String f137793g;

        /* renamed from: h, reason: collision with root package name */
        public String f137794h;

        /* renamed from: i, reason: collision with root package name */
        public String f137795i;

        /* renamed from: j, reason: collision with root package name */
        public String f137796j;

        /* renamed from: k, reason: collision with root package name */
        public String f137797k;

        /* renamed from: l, reason: collision with root package name */
        public String f137798l;

        /* renamed from: m, reason: collision with root package name */
        public String f137799m;

        /* renamed from: n, reason: collision with root package name */
        public String f137800n;

        public C6615a c() {
            this.f137800n = c.a();
            return this;
        }

        public C6615a d() {
            this.f137789c = c.b();
            return this;
        }

        public C6615a e() {
            this.f137790d = c.a(0);
            return this;
        }

        public C6615a f() {
            this.f137791e = c.a(1);
            return this;
        }

        public C6615a g() {
            this.f137792f = c.c();
            return this;
        }

        public C6615a h() {
            this.f137793g = c.b(0);
            return this;
        }

        public C6615a i() {
            this.f137794h = c.b(1);
            return this;
        }

        public C6615a j() {
            this.f137788b = c.d();
            return this;
        }

        public C6615a k() {
            this.f137795i = c.e();
            return this;
        }

        public C6615a l() {
            this.f137796j = c.c(0);
            return this;
        }

        public C6615a m() {
            this.f137797k = c.c(1);
            return this;
        }

        public C6615a n() {
            this.f137787a = c.f();
            return this;
        }

        public C6615a o() {
            this.f137799m = c.g();
            return this;
        }

        public final String a() {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                if (!w0.c(this.f137787a)) {
                    jSONObject.put("oaid", this.f137787a);
                }
                if (!w0.c(this.f137788b)) {
                    jSONObject.put("imeiWx", this.f137788b);
                }
                if (!w0.c(this.f137789c)) {
                    jSONObject.put(Constants.SP_DEVICE_ID, this.f137789c);
                }
                if (!w0.c(this.f137790d)) {
                    jSONObject.put("deviceId0", this.f137790d);
                }
                if (!w0.c(this.f137791e)) {
                    jSONObject.put("deviceId1", this.f137791e);
                }
                if (!w0.c(this.f137792f)) {
                    jSONObject.put("imei", this.f137792f);
                }
                if (!w0.c(this.f137793g)) {
                    jSONObject.put("imei0", this.f137793g);
                }
                if (!w0.c(this.f137794h)) {
                    jSONObject.put("imei1", this.f137794h);
                }
                if (!w0.c(this.f137795i)) {
                    jSONObject.put("meid", this.f137795i);
                }
                if (!w0.c(this.f137796j)) {
                    jSONObject.put("meid0", this.f137796j);
                }
                if (!w0.c(this.f137797k)) {
                    jSONObject.put("meid1", this.f137797k);
                }
                if (!w0.c(this.f137798l)) {
                    jSONObject.put("subscriberId", this.f137798l);
                }
                if (!w0.c(this.f137799m)) {
                    jSONObject.put("uuid", this.f137799m);
                }
                if (!w0.c(this.f137800n)) {
                    jSONObject.put("androidId", this.f137800n);
                }
                String jSONObject2 = jSONObject.toString();
                w.a("AdDeviceInfo", "buildPartDeviceInfo, timeCost = " + (System.currentTimeMillis() - currentTimeMillis) + ", ret = " + jSONObject2);
                return jSONObject2;
            } catch (Throwable th5) {
                w.b("AdDeviceInfo", th5.toString());
                return "";
            }
        }

        public final C6615a b() {
            long currentTimeMillis = System.currentTimeMillis();
            n();
            j();
            d();
            e();
            f();
            g();
            h();
            i();
            k();
            l();
            m();
            o();
            c();
            w.a("AdDeviceInfo", "genAllDeviceInfo, timeCost = " + (System.currentTimeMillis() - currentTimeMillis));
            return this;
        }
    }

    public static synchronized String a() {
        String d16;
        int length;
        synchronized (a.class) {
            d16 = w0.d(new C6615a().b().a());
            StringBuilder sb5 = new StringBuilder();
            sb5.append("getAllDeviceInfo, len = ");
            if (d16 == null) {
                length = 0;
            } else {
                length = d16.length();
            }
            sb5.append(length);
            w.d("AdDeviceInfo", sb5.toString());
        }
        return d16;
    }
}
