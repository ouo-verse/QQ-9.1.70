package c.t.m.g;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes.dex */
public class p extends h0 {

    /* renamed from: g, reason: collision with root package name */
    public static volatile p f29913g;

    /* renamed from: h, reason: collision with root package name */
    public static Context f29914h;

    /* renamed from: c, reason: collision with root package name */
    public volatile boolean f29915c = true;

    /* renamed from: d, reason: collision with root package name */
    public volatile y f29916d = y.f30109a;

    /* renamed from: e, reason: collision with root package name */
    public Handler f29917e;

    /* renamed from: f, reason: collision with root package name */
    public volatile String f29918f;

    /* compiled from: P */
    /* loaded from: classes.dex */
    public class a extends BaseThread {
        public a(String str) {
            super(str);
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                p.f();
                r.a();
                q.b();
                k1.b(r.a().b(), "last_pull_time", (Object) String.valueOf(0));
            } catch (Throwable unused) {
            }
        }
    }

    public p() {
        Context context = f29914h;
        if (context != null && context.getApplicationContext() != null) {
        } else {
            throw new IllegalStateException("Please invoke initial(context,...) first when app started!");
        }
    }

    public static synchronized p f() {
        p pVar;
        synchronized (p.class) {
            if (f29913g == null) {
                synchronized (p.class) {
                    if (f29913g == null) {
                        f29913g = new p();
                    }
                }
            }
            pVar = f29913g;
        }
        return pVar;
    }

    @Override // c.t.m.g.h0
    public String a() {
        return "TxCC";
    }

    public final void g() {
        long e16;
        try {
            int c16 = q.b().c("cc_version");
            if (c16 == -1) {
                e16 = 10800000;
            } else {
                e16 = e();
            }
            c1.a("TxCC", "schedule : locVer[" + c16 + "],delayTime[" + e16 + "]");
            a(e16);
        } catch (Throwable th5) {
            c1.a("TxCC", "startSchedule error.", th5);
        }
    }

    @Override // c.t.m.g.h0
    public void d() {
        try {
            q.b().f();
            c1.a("TxCC", "shutdown:pull immediately");
            y0.b(this.f29917e);
            a(0L);
            w0.a("th_loc_task_t_consume", 100L);
            this.f29917e = null;
        } catch (Throwable th5) {
            c1.a("TxCC", "shutdown error.", th5);
        }
    }

    public final long e() {
        long d16 = q.b().d("cc_req_interval");
        if (d16 > 86400000) {
            d16 = 86400000;
        }
        if (d16 < 1800000) {
            return 1800000L;
        }
        return d16;
    }

    public static void a(HashMap<String, String> hashMap) {
        q.a(hashMap);
    }

    public static void a(Context context, String str, String str2) {
        if (context != null && context.getApplicationContext() != null) {
            Context applicationContext = context.getApplicationContext();
            f29914h = applicationContext;
            o0.a(applicationContext);
            r.a(str);
            q.a(str, str2);
            new a("th_loc_tmp").start();
            return;
        }
        throw new NullPointerException("context cannot be null!");
    }

    public static void a(String str) {
        q.f(str);
    }

    public final void a(long j3) {
        Handler handler = this.f29917e;
        b bVar = new b();
        if (j3 < 0) {
            j3 = 0;
        }
        y0.a(handler, bVar, j3);
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public class b extends TimerTask {

        /* renamed from: a, reason: collision with root package name */
        public final JSONObject f29919a = new JSONObject();

        /* renamed from: b, reason: collision with root package name */
        public q f29920b;

        /* renamed from: c, reason: collision with root package name */
        public r f29921c;

        public b() {
            this.f29920b = null;
            this.f29921c = null;
            this.f29920b = q.b();
            this.f29921c = r.a();
        }

        public final void a() {
            boolean b16 = p.this.b();
            if (b16) {
                try {
                    this.f29921c.c();
                } catch (Throwable th5) {
                    try {
                        c1.a("CC_Task", "pullSettings error.", th5);
                        if (!b16) {
                            return;
                        }
                    } finally {
                        this.f29920b.e();
                        if (b16) {
                            this.f29921c.d();
                        }
                    }
                }
            }
            JSONObject b17 = b();
            if (b17 != this.f29919a) {
                int parseInt = Integer.parseInt(b17.optString("status", "-5"));
                c1.a("CC_Task", "status:" + parseInt);
                if (parseInt == 0 && b17.has("version")) {
                    a(b17);
                }
                k1.b(this.f29921c.b(), "last_pull_time", (Object) String.valueOf(System.currentTimeMillis()));
                LockMethodProxy.sleep(1000L);
                c1.a("CC_Task", "---> finish update xml");
            }
            this.f29920b.e();
            if (!b16) {
            }
        }

        public final JSONObject b() {
            if (p.this.f29916d == null) {
                return this.f29919a;
            }
            String str = "https://cc.map.qq.com/?get_c3";
            if (!p.this.f29915c) {
                str = "https://cc.map.qq.com/?get_c3".replace("https:", "http:");
            }
            c1.a("CC_Task", "cc_url:" + str);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("cc_version", this.f29920b.e("cc_version"));
                jSONObject.put("m_module", q.f29941g);
                jSONObject.put("m_channel", q.f29942h);
                jSONObject.put("m_version", q.f29943i);
                String str2 = p.this.f29918f;
                if (h1.a(str2) || "0123456789ABCDEF".equals(str2)) {
                    str2 = l1.a();
                }
                if (h1.a(str2) || "0123456789ABCDEF".equals(str2)) {
                    str2 = l1.i();
                }
                jSONObject.put("imei", str2);
                String jSONObject2 = jSONObject.toString();
                c1.c("TAG", "cc request: " + jSONObject2);
                String a16 = s0.a("cc");
                String b16 = s0.b(jSONObject2, a16);
                c1.a("CC_Task", "req string: " + jSONObject2);
                c1.a("CC_Task", "req string enc:" + b16);
                Bundle a17 = p.this.f29916d.a(str, b16.getBytes(), null);
                String string = a17.getString("msg_suc", "");
                if (TextUtils.isEmpty(string)) {
                    c1.a("CC_Task", "net work error! res = [" + a17.getString("msg_fail", "") + "]");
                    return this.f29919a;
                }
                c1.a("CC_Task", "res:" + string);
                String jSONObject3 = this.f29919a.toString();
                if (jSONObject3.equals(string)) {
                    c1.a("CC_Task", "network or server error,response empty json");
                } else {
                    c1.a("CC_Task", "start dec");
                    jSONObject3 = s0.a(string, a16);
                    c1.a("CC_Task", "end dec, " + jSONObject3);
                }
                if (TextUtils.isEmpty(jSONObject3)) {
                    return this.f29919a;
                }
                return new JSONObject(jSONObject3);
            } catch (Throwable th5) {
                c1.a("CC_Task", "req cc error.", th5);
                return this.f29919a;
            }
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                if (Math.abs(System.currentTimeMillis() - this.f29920b.d("last_pull_time")) >= p.this.e()) {
                    a();
                } else {
                    c1.a("CC_Task", "skip pull");
                }
                if (p.this.b()) {
                    p.this.g();
                }
            } catch (Throwable th5) {
                c1.a("CC_Task", "timer task error.", th5);
            }
        }

        public final void a(JSONObject jSONObject) throws JSONException {
            int i3;
            long parseLong;
            long j3;
            SharedPreferences b16 = this.f29921c.b();
            if (b16 == null) {
                return;
            }
            int c16 = this.f29920b.c("cc_version");
            try {
                i3 = Integer.parseInt(jSONObject.optString("version", this.f29920b.e("cc_version")));
            } catch (Throwable unused) {
                i3 = c16;
            }
            c1.a("CC_Task", "locVer:" + c16 + ",serVer:" + i3);
            if (i3 == c16) {
                return;
            }
            c1.a("CC_Task", "locVer != serVer, clear sp.");
            b16.edit().clear().apply();
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                optJSONObject = this.f29919a;
            }
            SharedPreferences.Editor edit = b16.edit();
            Iterator keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                a(edit, str, str, optJSONObject);
            }
            edit.putString("cc_version", String.valueOf(i3));
            edit.putString("app_version", q.f29943i);
            try {
                parseLong = Long.parseLong(optJSONObject.optString("cc_req_interval", this.f29920b.e("cc_req_interval")));
                j3 = 1800000;
            } catch (Throwable unused2) {
            }
            if (parseLong >= 1800000) {
                j3 = 86400000;
                if (parseLong > 86400000) {
                }
                edit.putString("cc_req_interval", String.valueOf(parseLong));
                edit.apply();
            }
            parseLong = j3;
            edit.putString("cc_req_interval", String.valueOf(parseLong));
            edit.apply();
        }

        public final void a(SharedPreferences.Editor editor, String str, String str2, JSONObject jSONObject) {
            try {
                String e16 = this.f29920b.e(str);
                if (e16 == null) {
                    return;
                }
                editor.putString(str, jSONObject.optString(str2, e16));
            } catch (Exception e17) {
                c1.a("CC_Task", "update sp error.", e17);
            }
        }
    }
}
