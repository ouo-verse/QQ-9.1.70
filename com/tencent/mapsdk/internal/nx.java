package com.tencent.mapsdk.internal;

import android.support.annotation.NonNull;
import com.tencent.map.tools.CallbackRunnable;
import com.tencent.mapsdk.internal.tk;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class nx extends nh<ny> {
    public nx(tk tkVar) {
        super(tkVar);
    }

    @Override // com.tencent.mapsdk.internal.nh
    public final /* synthetic */ ng<ny> a(ny nyVar) {
        return new nw(this, nyVar);
    }

    @Override // com.tencent.mapsdk.internal.nh
    public final void c(ng<ny> ngVar) {
        tk tkVar = this.f149455a;
        ngVar.a(((Long) tkVar.a((CallbackRunnable<tk.AnonymousClass64>) new tk.AnonymousClass64(ngVar.f149454d), (tk.AnonymousClass64) 0L)).longValue());
    }

    @Override // com.tencent.mapsdk.internal.nh
    public final void d(ng<ny> ngVar) {
        tk tkVar = this.f149455a;
        tkVar.a(new tk.AnonymousClass65(ngVar.e_(), ngVar.f149454d));
    }

    @Override // com.tencent.mapsdk.internal.nh
    public final void e(ng<ny> ngVar) {
        this.f149455a.c(ngVar.e_());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.tencent.mapsdk.internal.nh
    public synchronized nw b(@NonNull ny nyVar) {
        return (nw) super.b((nx) nyVar);
    }

    @Override // com.tencent.mapsdk.internal.nh
    public final void e() {
        if (this.f149455a.y()) {
            this.f149455a.f150520j.f149412y = true;
        }
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private ng<ny> a2(ny nyVar) {
        return new nw(this, nyVar);
    }

    @Override // com.tencent.mapsdk.internal.nh
    public final void c() {
        boolean n3 = this.f149455a.n();
        Iterator it = this.f149456b.entrySet().iterator();
        while (it.hasNext()) {
            n3 |= ((ny) ((nw) ((Map.Entry) it.next()).getValue()).f149454d).isAnimate();
        }
        if (n3) {
            this.f149455a.f150520j.f149412y = true;
        }
    }

    @Override // com.tencent.mapsdk.internal.nh
    public final void f(ng<ny> ngVar) {
    }
}
