package com.tencent.mapsdk.internal;

import android.support.annotation.NonNull;
import com.tencent.map.tools.CallbackRunnable;
import com.tencent.mapsdk.internal.tk;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class og extends nh<oh> {
    public og(tk tkVar) {
        super(tkVar);
    }

    @Override // com.tencent.mapsdk.internal.nh
    public final /* synthetic */ ng<oh> a(oh ohVar) {
        return new of(this, ohVar);
    }

    @Override // com.tencent.mapsdk.internal.nh
    public final void c(ng<oh> ngVar) {
        tk tkVar = this.f149455a;
        ngVar.a(((Long) tkVar.a((CallbackRunnable<tk.AnonymousClass71>) new tk.AnonymousClass71(ngVar.f149454d), (tk.AnonymousClass71) 0L)).longValue());
    }

    @Override // com.tencent.mapsdk.internal.nh
    public final void d(ng<oh> ngVar) {
        tk tkVar = this.f149455a;
        tkVar.a(new tk.AnonymousClass72(ngVar.e_(), ngVar.f149454d));
    }

    @Override // com.tencent.mapsdk.internal.nh
    public final void e(ng<oh> ngVar) {
        this.f149455a.c(ngVar.e_());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.tencent.mapsdk.internal.nh
    public synchronized of b(@NonNull oh ohVar) {
        return (of) super.b((og) ohVar);
    }

    @Override // com.tencent.mapsdk.internal.nh
    public final void e() {
        if (this.f149455a.y()) {
            this.f149455a.f150520j.f149412y = true;
        }
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private ng<oh> a2(oh ohVar) {
        return new of(this, ohVar);
    }

    @Override // com.tencent.mapsdk.internal.nh
    public final void c() {
        boolean n3 = this.f149455a.n();
        Iterator it = this.f149456b.entrySet().iterator();
        while (it.hasNext()) {
            n3 |= ((oh) ((of) ((Map.Entry) it.next()).getValue()).f149454d).isAnimate();
        }
        if (n3) {
            this.f149455a.f150520j.f149412y = true;
        }
    }

    @Override // com.tencent.mapsdk.internal.nh
    public final void f(ng<oh> ngVar) {
    }
}
