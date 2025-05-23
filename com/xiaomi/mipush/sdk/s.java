package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusMiniService;
import com.xiaomi.push.ge;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes28.dex */
public class s {

    /* renamed from: e, reason: collision with root package name */
    private static volatile s f388089e;

    /* renamed from: a, reason: collision with root package name */
    private Context f388090a;

    /* renamed from: b, reason: collision with root package name */
    private a f388091b;

    /* renamed from: c, reason: collision with root package name */
    private Map<String, a> f388092c;

    /* renamed from: d, reason: collision with root package name */
    String f388093d;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f388094a;

        /* renamed from: b, reason: collision with root package name */
        public String f388095b;

        /* renamed from: c, reason: collision with root package name */
        public String f388096c;

        /* renamed from: d, reason: collision with root package name */
        public String f388097d;

        /* renamed from: e, reason: collision with root package name */
        public String f388098e;

        /* renamed from: f, reason: collision with root package name */
        public String f388099f;

        /* renamed from: g, reason: collision with root package name */
        public String f388100g;

        /* renamed from: h, reason: collision with root package name */
        public String f388101h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f388102i = true;

        /* renamed from: j, reason: collision with root package name */
        public boolean f388103j = false;

        /* renamed from: k, reason: collision with root package name */
        public int f388104k = 1;

        /* renamed from: l, reason: collision with root package name */
        private Context f388105l;

        public a(Context context) {
            this.f388105l = context;
        }

        private String a() {
            Context context = this.f388105l;
            return com.xiaomi.push.g.h(context, context.getPackageName());
        }

        public static String b(a aVar) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("appId", aVar.f388094a);
                jSONObject.put("appToken", aVar.f388095b);
                jSONObject.put("regId", aVar.f388096c);
                jSONObject.put("regSec", aVar.f388097d);
                jSONObject.put("devId", aVar.f388099f);
                jSONObject.put(IOnlineStatusMiniService.VIDEO_NAME, aVar.f388098e);
                jSONObject.put("valid", aVar.f388102i);
                jSONObject.put("paused", aVar.f388103j);
                jSONObject.put("envType", aVar.f388104k);
                jSONObject.put("regResource", aVar.f388100g);
                return jSONObject.toString();
            } catch (Throwable th5) {
                jz4.c.q(th5);
                return null;
            }
        }

        public void c() {
            s.b(this.f388105l).edit().clear().commit();
            this.f388094a = null;
            this.f388095b = null;
            this.f388096c = null;
            this.f388097d = null;
            this.f388099f = null;
            this.f388098e = null;
            this.f388102i = false;
            this.f388103j = false;
            this.f388101h = null;
            this.f388104k = 1;
        }

        public void d(int i3) {
            this.f388104k = i3;
        }

        public void e(String str, String str2) {
            this.f388096c = str;
            this.f388097d = str2;
            this.f388099f = ge.A(this.f388105l);
            this.f388098e = a();
            this.f388102i = true;
        }

        public void f(String str, String str2, String str3) {
            this.f388094a = str;
            this.f388095b = str2;
            this.f388100g = str3;
            SharedPreferences.Editor edit = s.b(this.f388105l).edit();
            edit.putString("appId", this.f388094a);
            edit.putString("appToken", str2);
            edit.putString("regResource", str3);
            edit.commit();
        }

        public void g(boolean z16) {
            this.f388103j = z16;
        }

        public boolean h() {
            return i(this.f388094a, this.f388095b);
        }

        public boolean i(String str, String str2) {
            boolean z16;
            boolean z17;
            boolean equals = TextUtils.equals(this.f388094a, str);
            boolean equals2 = TextUtils.equals(this.f388095b, str2);
            boolean z18 = !TextUtils.isEmpty(this.f388096c);
            boolean z19 = !TextUtils.isEmpty(this.f388097d);
            if (TextUtils.isEmpty(ge.p(this.f388105l)) || TextUtils.equals(this.f388099f, ge.A(this.f388105l)) || TextUtils.equals(this.f388099f, ge.z(this.f388105l))) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (equals && equals2 && z18 && z19 && z16) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17) {
                jz4.c.D(String.format("register invalid, aid=%s;atn=%s;rid=%s;rse=%s;did=%s", Boolean.valueOf(equals), Boolean.valueOf(equals2), Boolean.valueOf(z18), Boolean.valueOf(z19), Boolean.valueOf(z16)));
            }
            return z17;
        }

        public void j() {
            this.f388102i = false;
            s.b(this.f388105l).edit().putBoolean("valid", this.f388102i).commit();
        }

        public void k(String str, String str2, String str3) {
            this.f388096c = str;
            this.f388097d = str2;
            this.f388099f = ge.A(this.f388105l);
            this.f388098e = a();
            this.f388102i = true;
            this.f388101h = str3;
            SharedPreferences.Editor edit = s.b(this.f388105l).edit();
            edit.putString("regId", str);
            edit.putString("regSec", str2);
            edit.putString("devId", this.f388099f);
            edit.putString(IOnlineStatusMiniService.VIDEO_NAME, a());
            edit.putBoolean("valid", true);
            edit.putString("appRegion", str3);
            edit.commit();
        }
    }

    s(Context context) {
        this.f388090a = context;
        r();
    }

    public static SharedPreferences b(Context context) {
        return context.getSharedPreferences("mipush", 0);
    }

    public static s c(Context context) {
        if (f388089e == null) {
            synchronized (s.class) {
                if (f388089e == null) {
                    f388089e = new s(context);
                }
            }
        }
        return f388089e;
    }

    private void r() {
        this.f388091b = new a(this.f388090a);
        this.f388092c = new HashMap();
        SharedPreferences b16 = b(this.f388090a);
        this.f388091b.f388094a = b16.getString("appId", null);
        this.f388091b.f388095b = b16.getString("appToken", null);
        this.f388091b.f388096c = b16.getString("regId", null);
        this.f388091b.f388097d = b16.getString("regSec", null);
        this.f388091b.f388099f = b16.getString("devId", null);
        if (!TextUtils.isEmpty(this.f388091b.f388099f) && ge.m(this.f388091b.f388099f)) {
            this.f388091b.f388099f = ge.A(this.f388090a);
            b16.edit().putString("devId", this.f388091b.f388099f).commit();
        }
        this.f388091b.f388098e = b16.getString(IOnlineStatusMiniService.VIDEO_NAME, null);
        this.f388091b.f388102i = b16.getBoolean("valid", true);
        this.f388091b.f388103j = b16.getBoolean("paused", false);
        this.f388091b.f388104k = b16.getInt("envType", 1);
        this.f388091b.f388100g = b16.getString("regResource", null);
        this.f388091b.f388101h = b16.getString("appRegion", null);
    }

    public int a() {
        return this.f388091b.f388104k;
    }

    public String d() {
        return this.f388091b.f388094a;
    }

    public void e() {
        this.f388091b.c();
    }

    public void f(int i3) {
        this.f388091b.d(i3);
        b(this.f388090a).edit().putInt("envType", i3).commit();
    }

    public void g(String str) {
        SharedPreferences.Editor edit = b(this.f388090a).edit();
        edit.putString(IOnlineStatusMiniService.VIDEO_NAME, str);
        edit.commit();
        this.f388091b.f388098e = str;
    }

    public void h(String str, a aVar) {
        this.f388092c.put(str, aVar);
        b(this.f388090a).edit().putString("hybrid_app_info_" + str, a.b(aVar)).commit();
    }

    public void i(String str, String str2, String str3) {
        this.f388091b.f(str, str2, str3);
    }

    public void j(boolean z16) {
        this.f388091b.g(z16);
        b(this.f388090a).edit().putBoolean("paused", z16).commit();
    }

    public boolean k() {
        Context context = this.f388090a;
        return !TextUtils.equals(com.xiaomi.push.g.h(context, context.getPackageName()), this.f388091b.f388098e);
    }

    public boolean l(String str, String str2) {
        return this.f388091b.i(str, str2);
    }

    public String m() {
        return this.f388091b.f388095b;
    }

    public void n() {
        this.f388091b.j();
    }

    public void o(String str, String str2, String str3) {
        this.f388091b.k(str, str2, str3);
    }

    public boolean p() {
        if (!this.f388091b.h()) {
            jz4.c.m("Don't send message before initialization succeeded!");
            return false;
        }
        return true;
    }

    public String q() {
        return this.f388091b.f388096c;
    }

    public boolean s() {
        return this.f388091b.h();
    }

    public String t() {
        return this.f388091b.f388097d;
    }

    public boolean u() {
        if (!TextUtils.isEmpty(this.f388091b.f388094a) && !TextUtils.isEmpty(this.f388091b.f388095b) && !TextUtils.isEmpty(this.f388091b.f388096c) && !TextUtils.isEmpty(this.f388091b.f388097d)) {
            return true;
        }
        return false;
    }

    public String v() {
        return this.f388091b.f388100g;
    }

    public boolean w() {
        return this.f388091b.f388103j;
    }

    public boolean x() {
        return !this.f388091b.f388102i;
    }
}
