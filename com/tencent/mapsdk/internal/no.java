package com.tencent.mapsdk.internal;

import android.support.annotation.NonNull;
import com.tencent.map.tools.CallbackRunnable;
import com.tencent.mapsdk.internal.tk;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class no extends nh<np> {
    public no(tk tkVar) {
        super(tkVar);
    }

    @Override // com.tencent.mapsdk.internal.nh
    public final /* synthetic */ ng<np> a(np npVar) {
        return new nn(this, npVar);
    }

    @Override // com.tencent.mapsdk.internal.nh
    public final void c(ng<np> ngVar) {
        tk tkVar = this.f149455a;
        ngVar.a(((Long) tkVar.a((CallbackRunnable<tk.AnonymousClass69>) new tk.AnonymousClass69(ngVar.f149454d), (tk.AnonymousClass69) 0L)).longValue());
    }

    @Override // com.tencent.mapsdk.internal.nh
    public final void d(ng<np> ngVar) {
        tk tkVar = this.f149455a;
        tkVar.a(new tk.AnonymousClass70(ngVar.e_(), ngVar.f149454d));
    }

    @Override // com.tencent.mapsdk.internal.nh
    public final void e(ng<np> ngVar) {
        this.f149455a.c(ngVar.e_());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.tencent.mapsdk.internal.nh
    public synchronized nn b(@NonNull np npVar) {
        return (nn) super.b((no) npVar);
    }

    @Override // com.tencent.mapsdk.internal.nh
    public final void e() {
        if (this.f149455a.y()) {
            this.f149455a.f150520j.f149412y = true;
        }
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private ng<np> a2(np npVar) {
        return new nn(this, npVar);
    }

    @Override // com.tencent.mapsdk.internal.nh
    public final void c() {
        boolean n3 = this.f149455a.n();
        Iterator it = this.f149456b.entrySet().iterator();
        while (it.hasNext()) {
            n3 |= ((np) ((nn) ((Map.Entry) it.next()).getValue()).f149454d).getIsAnimate();
        }
        if (n3) {
            this.f149455a.f150520j.f149412y = true;
        }
    }

    @Override // com.tencent.mapsdk.internal.nh
    public final void f(ng<np> ngVar) {
    }
}
