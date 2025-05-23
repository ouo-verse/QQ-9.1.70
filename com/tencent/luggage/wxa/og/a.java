package com.tencent.luggage.wxa.og;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.luggage.wxa.cp.v;
import com.tencent.luggage.wxa.pg.e;
import com.tencent.luggage.wxa.rg.d;
import com.tencent.luggage.wxa.rg.i;
import com.tencent.luggage.wxa.tg.c;
import com.tencent.luggage.wxa.tg.h;
import com.tencent.luggage.wxa.tg.j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a {

    /* renamed from: r, reason: collision with root package name */
    public static volatile a f136459r;

    /* renamed from: a, reason: collision with root package name */
    public Context f136460a;

    /* renamed from: h, reason: collision with root package name */
    public String f136467h;

    /* renamed from: i, reason: collision with root package name */
    public String f136468i;

    /* renamed from: j, reason: collision with root package name */
    public List f136469j;

    /* renamed from: n, reason: collision with root package name */
    public j f136473n;

    /* renamed from: o, reason: collision with root package name */
    public com.tencent.luggage.wxa.sg.a f136474o;

    /* renamed from: p, reason: collision with root package name */
    public i f136475p;

    /* renamed from: q, reason: collision with root package name */
    public e f136476q;

    /* renamed from: b, reason: collision with root package name */
    public boolean f136461b = false;

    /* renamed from: c, reason: collision with root package name */
    public boolean f136462c = true;

    /* renamed from: d, reason: collision with root package name */
    public boolean f136463d = true;

    /* renamed from: e, reason: collision with root package name */
    public boolean f136464e = true;

    /* renamed from: f, reason: collision with root package name */
    public boolean f136465f = true;

    /* renamed from: g, reason: collision with root package name */
    public boolean f136466g = false;

    /* renamed from: k, reason: collision with root package name */
    public long f136470k = 536870912;

    /* renamed from: l, reason: collision with root package name */
    public long f136471l = 1048576;

    /* renamed from: m, reason: collision with root package name */
    public int f136472m = 5;

    public a(Context context) {
        this.f136460a = context;
    }

    public void a(d dVar) {
    }

    public Context b() {
        return this.f136460a;
    }

    public String c() {
        v vVar;
        if (TextUtils.isEmpty(this.f136468i)) {
            try {
                vVar = v.a(this.f136460a.getExternalCacheDir());
            } catch (Exception e16) {
                h.a(5, "PlayerConfig", "getCacheDir fail", e16);
                vVar = null;
            }
            if (vVar == null) {
                h.a(5, "PlayerConfig", "getCacheDir fail, extCacheDir not exist");
                return null;
            }
            return a(vVar + "/wxvideocache");
        }
        return this.f136468i;
    }

    public e d() {
        return this.f136476q;
    }

    public long e() {
        return this.f136470k;
    }

    public void f(boolean z16) {
        this.f136461b = z16;
    }

    public List g() {
        List list = this.f136469j;
        if (list != null) {
            return list;
        }
        return new ArrayList(Arrays.asList(c.f141289a, c.f141290b, c.f141291c, c.f141293e, c.f141294f, c.f141292d, c.f141295g, c.f141296h, c.f141297i, c.f141298j));
    }

    public int h() {
        return this.f136472m;
    }

    public j i() {
        return this.f136473n;
    }

    public d j() {
        return null;
    }

    public i k() {
        return this.f136475p;
    }

    public String l() {
        v vVar;
        if (TextUtils.isEmpty(this.f136467h)) {
            try {
                vVar = v.a(this.f136460a.getFilesDir());
            } catch (Exception e16) {
                h.a(5, "PlayerConfig", "getTempDir fail", e16);
                vVar = null;
            }
            if (vVar == null) {
                return null;
            }
            return a(vVar + "/wxvideotmp");
        }
        return this.f136467h;
    }

    public com.tencent.luggage.wxa.sg.a m() {
        return this.f136474o;
    }

    public boolean n() {
        return this.f136461b;
    }

    public boolean o() {
        return this.f136463d;
    }

    public boolean p() {
        return this.f136464e;
    }

    public boolean q() {
        return this.f136465f;
    }

    public boolean r() {
        return this.f136462c;
    }

    public boolean s() {
        return this.f136466g;
    }

    public static a a() {
        if (f136459r != null) {
            return f136459r;
        }
        throw new RuntimeException("PlayerConfig not initialized!");
    }

    public void b(String str) {
        this.f136468i = str;
    }

    public void d(boolean z16) {
        this.f136462c = z16;
    }

    public void e(boolean z16) {
        this.f136466g = z16;
    }

    public long f() {
        return this.f136471l;
    }

    public void b(long j3) {
        this.f136471l = j3;
    }

    public void b(boolean z16) {
        this.f136464e = z16;
    }

    public static void a(Context context) {
        if (f136459r == null) {
            synchronized (a.class) {
                if (f136459r == null) {
                    f136459r = new a(context);
                }
            }
        }
    }

    public void c(String str) {
        this.f136467h = str;
    }

    public void c(boolean z16) {
        this.f136465f = z16;
    }

    public final String a(String str) {
        if (!TextUtils.isEmpty(str)) {
            v vVar = new v(str);
            if (vVar.q()) {
                h.a(4, "PlayerConfig", "fileDir:" + str + " is file, delete result:" + vVar.d());
            }
            if (!vVar.e()) {
                h.a(4, "PlayerConfig", "fileDir:" + str + " not exist, make dir result:" + vVar.w());
            }
        }
        return str;
    }

    public void a(j jVar) {
        this.f136473n = jVar;
    }

    public void a(long j3) {
        this.f136470k = j3;
    }

    public void a(e eVar) {
        this.f136476q = eVar;
    }

    public void a(boolean z16) {
        this.f136463d = z16;
    }

    public void a(com.tencent.luggage.wxa.sg.a aVar) {
        this.f136474o = aVar;
    }

    public void a(int i3) {
        this.f136472m = i3;
    }

    public void a(i iVar) {
        this.f136475p = iVar;
    }
}
