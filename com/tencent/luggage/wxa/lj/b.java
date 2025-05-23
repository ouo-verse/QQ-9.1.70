package com.tencent.luggage.wxa.lj;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.tencent.luggage.wxa.lj.a;
import com.tencent.luggage.wxa.lj.j;
import com.tencent.luggage.wxa.tn.w;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b extends s implements a {

    /* renamed from: b, reason: collision with root package name */
    public final com.tencent.luggage.wxa.ic.g f133438b;

    /* renamed from: c, reason: collision with root package name */
    public final j.b f133439c;

    /* renamed from: d, reason: collision with root package name */
    public Drawable f133440d;

    /* renamed from: e, reason: collision with root package name */
    public CharSequence f133441e;

    /* renamed from: f, reason: collision with root package name */
    public int f133442f;

    /* renamed from: g, reason: collision with root package name */
    public int f133443g;

    public b(com.tencent.luggage.wxa.ic.g gVar, j.b bVar) {
        this.f133438b = gVar;
        this.f133439c = bVar;
    }

    @Override // com.tencent.luggage.wxa.lj.f
    public void a(Runnable runnable) {
        this.f133438b.e(runnable);
    }

    @Override // com.tencent.luggage.wxa.lj.f
    public final void b(CharSequence charSequence) {
        this.f133441e = charSequence;
        if (e()) {
            return;
        }
        this.f133439c.a(charSequence);
    }

    @Override // com.tencent.luggage.wxa.lj.f
    public Context c() {
        try {
            return this.f133438b.Y().getCurrentPage().getCurrentPageView().W().getContext();
        } catch (NullPointerException unused) {
            return this.f133438b.L();
        }
    }

    public final boolean e() {
        com.tencent.luggage.wxa.ic.g gVar = this.f133438b;
        if (gVar != null && !gVar.t0() && !this.f133438b.w0() && this.f133438b.I() != null) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.luggage.wxa.lj.f
    public void a(boolean z16) {
        if (e()) {
            return;
        }
        this.f133439c.a(z16);
    }

    @Override // com.tencent.luggage.wxa.lj.f
    public final void a(Drawable drawable) {
        this.f133440d = drawable;
        if (e()) {
            return;
        }
        this.f133439c.setLogo(drawable);
    }

    @Override // com.tencent.luggage.wxa.lj.f
    public final void b(int i3, boolean z16) {
        this.f133442f = i3;
        if (e()) {
            return;
        }
        this.f133439c.a(i3, z16);
    }

    @Override // com.tencent.luggage.wxa.lj.a
    public j.b a(a.c cVar) {
        return a(cVar, a.d.LOW, "");
    }

    @Override // com.tencent.luggage.wxa.lj.f
    public void b(Map map) {
        this.f133443g = ((a.EnumC6443a) map.get("key_type")).ordinal();
        if (e()) {
            return;
        }
        this.f133439c.a(map);
    }

    public j.b a(a.c cVar, a.d dVar, String str) {
        int i3 = cVar.f133432a;
        int i16 = cVar.f133433b;
        j.b a16 = super.a(dVar);
        a16.a(str);
        a16.a(cVar.ordinal(), false);
        a16.setLogo(i16);
        a16.a(i3);
        w.d("Luggage.AppBrandCapsuleBarBlinkHelper", "new blinkCapsuleBar");
        return a16;
    }

    @Override // com.tencent.luggage.wxa.lj.a
    public int b() {
        return this.f133442f;
    }

    @Override // com.tencent.luggage.wxa.lj.a
    public int a() {
        return this.f133443g;
    }
}
