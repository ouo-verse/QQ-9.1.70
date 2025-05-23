package com.qq.e.comm.plugin.base.ad.model;

import com.qq.e.comm.constants.LoginType;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b {
    private JSONObject A;
    private int B;
    private int C;
    private int E;
    private JSONObject F;
    private int G;
    private int H;
    private boolean I;
    private int J;
    private String K;
    private JSONArray L;
    private String[] M;
    private int N;
    private int O;
    private JSONObject P;
    private String R;
    private String S;
    private JSONObject T;

    /* renamed from: a, reason: collision with root package name */
    private String f38908a;

    /* renamed from: b, reason: collision with root package name */
    private int f38909b;

    /* renamed from: c, reason: collision with root package name */
    private int f38910c;

    /* renamed from: d, reason: collision with root package name */
    private int f38911d;

    /* renamed from: e, reason: collision with root package name */
    private int f38912e;

    /* renamed from: f, reason: collision with root package name */
    private int f38913f;

    /* renamed from: g, reason: collision with root package name */
    private int f38914g;

    /* renamed from: h, reason: collision with root package name */
    private int f38915h;

    /* renamed from: i, reason: collision with root package name */
    private int f38916i;

    /* renamed from: j, reason: collision with root package name */
    private int f38917j;

    /* renamed from: k, reason: collision with root package name */
    private List<String> f38918k;

    /* renamed from: l, reason: collision with root package name */
    private String f38919l;

    /* renamed from: m, reason: collision with root package name */
    private String f38920m;

    /* renamed from: n, reason: collision with root package name */
    private int f38921n;

    /* renamed from: o, reason: collision with root package name */
    private LoginType f38922o;

    /* renamed from: p, reason: collision with root package name */
    private String f38923p;

    /* renamed from: q, reason: collision with root package name */
    private String f38924q;

    /* renamed from: r, reason: collision with root package name */
    private String f38925r;

    /* renamed from: s, reason: collision with root package name */
    private int f38926s;

    /* renamed from: t, reason: collision with root package name */
    private int f38927t;

    /* renamed from: w, reason: collision with root package name */
    private Map f38930w;

    /* renamed from: x, reason: collision with root package name */
    private String[] f38931x;

    /* renamed from: y, reason: collision with root package name */
    private int f38932y;

    /* renamed from: z, reason: collision with root package name */
    private int f38933z;

    /* renamed from: u, reason: collision with root package name */
    private int f38928u = 0;

    /* renamed from: v, reason: collision with root package name */
    private int f38929v = 0;
    private int D = Integer.MIN_VALUE;
    private int Q = -1;

    public int A() {
        return this.D;
    }

    public int B() {
        return this.C;
    }

    public JSONObject C() {
        return this.F;
    }

    public int D() {
        return this.G;
    }

    public int E() {
        return this.H;
    }

    public int F() {
        return this.f38928u;
    }

    public int G() {
        return this.f38929v;
    }

    public int H() {
        return this.J;
    }

    public Map I() {
        return this.f38930w;
    }

    public String J() {
        try {
            Map map = this.f38930w;
            if (map == null || map.size() <= 0) {
                return null;
            }
            return new JSONObject(this.f38930w).toString();
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public boolean K() {
        return this.I;
    }

    public String L() {
        return this.K;
    }

    public String[] M() {
        return this.f38931x;
    }

    public int N() {
        return this.f38932y;
    }

    public int O() {
        return this.f38933z;
    }

    public String[] P() {
        return this.M;
    }

    public JSONObject Q() {
        return this.P;
    }

    public int R() {
        return this.Q;
    }

    public String S() {
        return this.R;
    }

    public JSONObject T() {
        return this.A;
    }

    public String U() {
        return this.S;
    }

    public int a() {
        return this.N;
    }

    public int b() {
        return this.O;
    }

    public int c() {
        return this.E;
    }

    public JSONArray d() {
        return this.L;
    }

    public int e() {
        return this.f38916i;
    }

    public int f() {
        return this.f38917j;
    }

    public String g() {
        return this.f38908a;
    }

    public int h() {
        return this.f38909b;
    }

    public int i() {
        return this.f38910c;
    }

    public int j() {
        return this.f38911d;
    }

    public int k() {
        return this.f38912e;
    }

    public int l() {
        return this.f38913f;
    }

    public int m() {
        return this.f38914g;
    }

    public int n() {
        return this.f38915h;
    }

    public JSONObject o() {
        return this.T;
    }

    public List<String> p() {
        return this.f38918k;
    }

    public String q() {
        return this.f38919l;
    }

    public String r() {
        return this.f38920m;
    }

    public int s() {
        return this.f38921n;
    }

    public String t() {
        return this.f38924q;
    }

    public String u() {
        return this.f38925r;
    }

    public LoginType v() {
        return this.f38922o;
    }

    public String w() {
        return this.f38923p;
    }

    public int x() {
        return this.f38927t;
    }

    public int y() {
        return this.f38926s;
    }

    public int z() {
        return this.B;
    }

    public void a(String str) {
        this.f38908a = str;
    }

    public void b(int i3) {
        this.f38910c = i3;
    }

    public void c(int i3) {
        this.f38911d = i3;
    }

    public void d(int i3) {
        this.f38912e = i3;
    }

    public void e(int i3) {
        this.f38913f = i3;
    }

    public void f(int i3) {
        this.f38914g = i3;
    }

    public void g(int i3) {
        this.f38921n = i3;
    }

    public void h(int i3) {
        this.D = i3;
    }

    public void i(int i3) {
        this.G = i3;
    }

    public void j(int i3) {
        this.H = i3;
    }

    public void k(int i3) {
        this.f38929v = i3;
    }

    public void l(int i3) {
        this.J = i3;
    }

    public void m(int i3) {
        this.f38932y = i3;
    }

    public void a(int i3) {
        this.f38909b = i3;
    }

    public void b(String str) {
        this.f38924q = str;
    }

    public void c(String str) {
        this.f38925r = str;
    }

    public void d(String str) {
        this.f38923p = str;
    }

    public void e(String str) {
        this.K = str;
    }

    public void f(String str) {
        this.S = str;
    }

    public void a(LoginType loginType) {
        this.f38922o = loginType;
    }

    public void b(boolean z16) {
        if (z16) {
            this.C = 1;
        } else {
            this.C = 0;
        }
    }

    public void c(boolean z16) {
        this.I = z16;
    }

    public void a(boolean z16) {
        if (z16) {
            this.B = 1;
        } else {
            this.B = 0;
        }
    }

    public void c(JSONObject jSONObject) {
        this.A = jSONObject;
    }

    public void b(JSONObject jSONObject) {
        this.P = jSONObject;
    }

    public void a(JSONObject jSONObject) {
        this.F = jSONObject;
    }

    public void a(Map map) {
        this.f38930w = map;
    }

    public void a(String[] strArr) {
        this.f38931x = strArr;
    }
}
