package com.tencent.mapsdk.internal;

import android.support.annotation.NonNull;
import com.tencent.map.tools.CallbackRunnable;
import com.tencent.mapsdk.internal.tk;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class nu extends nh<nv> {
    public nu(tk tkVar) {
        super(tkVar);
    }

    @Override // com.tencent.mapsdk.internal.nh
    public final /* synthetic */ ng<nv> a(nv nvVar) {
        return new nt(this, nvVar);
    }

    @Override // com.tencent.mapsdk.internal.nh
    public final void c(ng<nv> ngVar) {
        tk tkVar = this.f149455a;
        ngVar.a(((Long) tkVar.a((CallbackRunnable<tk.AnonymousClass76>) new tk.AnonymousClass76(ngVar.f149454d), (tk.AnonymousClass76) 0L)).longValue());
        ngVar.f149454d.setBitmap(null);
        ngVar.f149454d.setLatLngBounds(null);
    }

    @Override // com.tencent.mapsdk.internal.nh
    public final void d(ng<nv> ngVar) {
        tk tkVar = this.f149455a;
        tkVar.a(new tk.AnonymousClass77(ngVar.e_(), ngVar.f149454d));
        ngVar.f149454d.setBitmap(null);
        ngVar.f149454d.setLatLngBounds(null);
    }

    @Override // com.tencent.mapsdk.internal.nh
    public final void e(ng<nv> ngVar) {
        this.f149455a.c(ngVar.e_());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.tencent.mapsdk.internal.nh
    public synchronized nt b(@NonNull nv nvVar) {
        return (nt) super.b((nu) nvVar);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private ng<nv> a2(nv nvVar) {
        return new nt(this, nvVar);
    }

    @Override // com.tencent.mapsdk.internal.nh
    public final void f(ng<nv> ngVar) {
    }
}
