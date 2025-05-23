package com.tencent.mapsdk.internal;

import android.support.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class od extends nh<oe> {
    public od(tk tkVar) {
        super(tkVar);
    }

    @Override // com.tencent.mapsdk.internal.nh
    public final void c(ng<oe> ngVar) {
        ngVar.a(this.f149455a.a(ngVar.f149454d));
    }

    @Override // com.tencent.mapsdk.internal.nh
    public final void d(ng<oe> ngVar) {
        this.f149455a.a(ngVar.e_(), ngVar.f149454d);
    }

    @Override // com.tencent.mapsdk.internal.nh
    public final void e(ng<oe> ngVar) {
        this.f149455a.b(ngVar.e_());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.tencent.mapsdk.internal.nh
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public synchronized oc a(int i3) {
        return (oc) super.a(i3);
    }

    @Override // com.tencent.mapsdk.internal.nh
    public final /* synthetic */ ng<oe> a(oe oeVar) {
        return new oc(this, oeVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.tencent.mapsdk.internal.nh
    public synchronized oc b(@NonNull oe oeVar) {
        return (oc) super.b((od) oeVar);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private oc a2(oe oeVar) {
        return new oc(this, oeVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int a(long j3) {
        tk tkVar = this.f149455a;
        if (tkVar == null || j3 == 0) {
            return 0;
        }
        return tkVar.a(j3);
    }

    @Override // com.tencent.mapsdk.internal.nh
    public final void f(ng<oe> ngVar) {
    }
}
