package com.tencent.mapsdk.internal;

import android.support.annotation.NonNull;
import com.tencent.map.tools.CallbackRunnable;
import com.tencent.mapsdk.internal.tk;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.VectorHeatAggregationUnit;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class nm extends nh<nl> {
    public nm(tk tkVar) {
        super(tkVar);
    }

    @Override // com.tencent.mapsdk.internal.nh
    public final /* synthetic */ ng<nl> a(nl nlVar) {
        return new nk(this, nlVar);
    }

    @Override // com.tencent.mapsdk.internal.nh
    public final void c(ng<nl> ngVar) {
        tk tkVar = this.f149455a;
        ngVar.a(((Long) tkVar.a((CallbackRunnable<tk.AnonymousClass62>) new tk.AnonymousClass62(ngVar.f149454d), (tk.AnonymousClass62) 0L)).longValue());
    }

    @Override // com.tencent.mapsdk.internal.nh
    public final void d(ng<nl> ngVar) {
        tk tkVar = this.f149455a;
        tkVar.a(new tk.AnonymousClass63(ngVar.e_(), ngVar.f149454d));
    }

    @Override // com.tencent.mapsdk.internal.nh
    public final void e(ng<nl> ngVar) {
        this.f149455a.c(ngVar.e_());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.tencent.mapsdk.internal.nh
    public synchronized nk b(@NonNull nl nlVar) {
        return (nk) super.b((nm) nlVar);
    }

    @Override // com.tencent.mapsdk.internal.nh
    public final void e() {
        if (this.f149455a.y()) {
            this.f149455a.f150520j.f149412y = true;
        }
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private ng<nl> a2(nl nlVar) {
        return new nk(this, nlVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final VectorHeatAggregationUnit a(long j3, LatLng latLng) {
        tk tkVar = this.f149455a;
        if (tkVar == null) {
            return null;
        }
        return (VectorHeatAggregationUnit) tkVar.a(new tk.AnonymousClass67(j3, latLng), (tk.AnonymousClass67) null);
    }

    @Override // com.tencent.mapsdk.internal.nh
    public final void c() {
        boolean n3 = this.f149455a.n();
        Iterator it = this.f149456b.entrySet().iterator();
        while (it.hasNext()) {
            n3 |= ((nl) ((nk) ((Map.Entry) it.next()).getValue()).f149454d).isAnimate();
        }
        if (n3) {
            this.f149455a.f150520j.f149412y = true;
        }
    }

    @Override // com.tencent.mapsdk.internal.nh
    public final void f(ng<nl> ngVar) {
    }
}
