package com.tencent.luggage.wxa.z1;

import android.content.res.Configuration;
import com.tencent.luggage.wxa.kj.v;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.wj.e;

/* compiled from: P */
/* loaded from: classes9.dex */
public class h implements com.tencent.luggage.wxa.mj.e, e.a, com.tencent.luggage.wxa.mj.c {

    /* renamed from: a, reason: collision with root package name */
    public final v f146189a;

    /* renamed from: b, reason: collision with root package name */
    public String f146190b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f146191c = false;

    /* renamed from: d, reason: collision with root package name */
    public boolean f146192d = false;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements e.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e.a f146193a;

        public a(e.a aVar) {
            this.f146193a = aVar;
        }

        @Override // com.tencent.luggage.wxa.wj.e.a
        public void a(e.b bVar, boolean z16) {
            h.this.a(bVar, z16);
            e.a aVar = this.f146193a;
            if (aVar != null) {
                aVar.a(bVar, z16);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b extends com.tencent.luggage.wxa.wj.b {
        public b() {
        }

        @Override // com.tencent.luggage.wxa.wj.b
        public void j() {
            h.this.f146189a.h0().b(this);
            if (!h.this.f146192d && h.this.f146191c) {
                h.this.a((e.a) null);
            }
        }
    }

    public h(v vVar, String str) {
        this.f146189a = vVar;
        this.f146190b = str;
    }

    @Override // com.tencent.luggage.wxa.mj.e
    public boolean a() {
        return false;
    }

    @Override // com.tencent.luggage.wxa.mj.e
    public String getRequestedOrientation() {
        return this.f146190b;
    }

    @Override // com.tencent.luggage.wxa.mj.c
    public void onBackground() {
        this.f146191c = false;
    }

    @Override // com.tencent.luggage.wxa.mj.c
    public void onDestroy() {
        this.f146191c = false;
        this.f146192d = true;
    }

    @Override // com.tencent.luggage.wxa.mj.c
    public void onForeground() {
        this.f146191c = true;
        if (this.f146189a.h0() != null && this.f146189a.h0().b()) {
            this.f146189a.h0().a(new b());
        } else {
            a((e.a) null);
        }
        a((e.a) null);
    }

    @Override // com.tencent.luggage.wxa.mj.e
    public void a(String str) {
        w.d("Luggage.WAGamePageViewOrientationExtensionImpl[AppBrandSplashAd]", "setRequestedOrientation[%s] appId[%s]", str, this.f146189a.getAppId());
        if (str == null || str.isEmpty()) {
            return;
        }
        this.f146190b = str;
    }

    public void a(e.a aVar) {
        if (this.f146192d) {
            w.h("Luggage.WAGamePageViewOrientationExtensionImpl[AppBrandSplashAd]", "resetPageOrientation but destroyed, appId:%s", this.f146189a.getAppId());
            return;
        }
        if (this.f146189a.D() == null || this.f146189a.D().getOrientationHandler() == null) {
            if (aVar != null) {
                aVar.a(null, false);
            }
        } else {
            if (this.f146189a.getRuntime().C0()) {
                w.f("Luggage.WAGamePageViewOrientationExtensionImpl[AppBrandSplashAd]", "resetPageOrientation, game is showing launch ad, ignore changing orientation", new Object[0]);
                if (aVar != null) {
                    aVar.a(null, false);
                    return;
                }
                return;
            }
            e.b a16 = e.b.a(this.f146190b);
            w.f("Luggage.WAGamePageViewOrientationExtensionImpl[AppBrandSplashAd]", "resetPageOrientation, appId[%s], orientation[%s]", this.f146189a.getAppId(), a16);
            if (a16 != null) {
                this.f146189a.D().getOrientationHandler().a(a16, new a(aVar));
            }
        }
    }

    @Override // com.tencent.luggage.wxa.wj.e.a
    public void a(e.b bVar, boolean z16) {
        Object[] objArr = new Object[2];
        objArr[0] = bVar == null ? "null" : bVar.name();
        objArr[1] = Boolean.valueOf(z16);
        w.d("Luggage.WAGamePageViewOrientationExtensionImpl[AppBrandSplashAd]", "onOrientationChanged requested[%s], success[%b]", objArr);
    }

    @Override // com.tencent.luggage.wxa.mj.c
    public void onConfigurationChanged(Configuration configuration) {
    }
}
