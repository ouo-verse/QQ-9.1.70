package com.tencent.luggage.wxa.t9;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class x {

    /* renamed from: a, reason: collision with root package name */
    public static j f141175a = new j();

    /* renamed from: b, reason: collision with root package name */
    public static d f141176b = new d();

    /* renamed from: c, reason: collision with root package name */
    public static c f141177c = new c();

    /* renamed from: d, reason: collision with root package name */
    public static t f141178d = new t();

    /* renamed from: e, reason: collision with root package name */
    public static z f141179e = new z();

    /* renamed from: f, reason: collision with root package name */
    public static n f141180f = new n();

    /* renamed from: g, reason: collision with root package name */
    public static q f141181g = new q();

    /* renamed from: h, reason: collision with root package name */
    public static w f141182h = new w();

    /* renamed from: i, reason: collision with root package name */
    public static p f141183i = new p();

    /* renamed from: j, reason: collision with root package name */
    public static p f141184j = new p();

    /* renamed from: k, reason: collision with root package name */
    public static b f141185k = new b();

    /* renamed from: l, reason: collision with root package name */
    public static int f141186l = -1;

    /* renamed from: m, reason: collision with root package name */
    public static e f141187m = new e();

    /* renamed from: n, reason: collision with root package name */
    public static k f141188n = new k();

    public static void a(String str) {
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.SrvDeviceInfo", "update deviceInfo %s", str);
        if (str == null || str.length() <= 0 || str.hashCode() == f141186l) {
            return;
        }
        f141186l = str.hashCode();
        f141175a.a();
        f141176b.a();
        f141177c.a();
        f141187m.b();
        f141178d.a();
        f141179e.a();
        f141180f.a();
        f141181g.a();
        f141182h.a();
        f141183i.a();
        f141184j.a();
        f141185k.a();
        if (!new m().a(str, f141175a, f141176b, f141177c, f141187m, f141178d, f141179e, f141180f, f141181g, f141182h, f141183i, f141185k, f141184j)) {
            return;
        }
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.SrvDeviceInfo", "steve: mCameraInfo.mSupportVoipBeauty = " + f141176b.M + ", mVoipBeautyWhiteCfg=" + f141176b.N);
        new com.tencent.luggage.wxa.p9.e().c();
    }
}
