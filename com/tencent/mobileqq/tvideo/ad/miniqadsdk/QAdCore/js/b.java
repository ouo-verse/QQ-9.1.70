package com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.js;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.js.a f303840a;

    /* renamed from: b, reason: collision with root package name */
    private a f303841b;

    /* renamed from: c, reason: collision with root package name */
    private c f303842c;

    /* renamed from: d, reason: collision with root package name */
    private QAdJavaScriptInterface f303843d;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface a {
        void a(String str);
    }

    public b(a aVar) {
        this.f303841b = aVar;
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.js.a aVar2 = new com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.js.a(this);
        this.f303840a = aVar2;
        c cVar = new c(this, aVar2);
        this.f303842c = cVar;
        this.f303843d = new QAdJavaScriptInterface(cVar);
    }

    public void a(String str) {
        a aVar = this.f303841b;
        if (aVar == null) {
            return;
        }
        aVar.a(str);
    }

    public QAdJavaScriptInterface b() {
        return this.f303843d;
    }

    public String c() {
        return this.f303840a.f();
    }

    public void d(jv2.a aVar) {
        this.f303840a.j(aVar);
    }
}
