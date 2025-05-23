package com.tencent.mapsdk.internal;

import android.support.annotation.NonNull;
import com.tencent.map.tools.CallbackRunnable;
import com.tencent.mapsdk.internal.tk;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class nz extends nh<ob> {
    public nz(tk tkVar) {
        super(tkVar);
    }

    @Override // com.tencent.mapsdk.internal.nh
    public final /* synthetic */ ng<ob> a(ob obVar) {
        return new oa(this, obVar);
    }

    @Override // com.tencent.mapsdk.internal.nh
    public final void c(ng<ob> ngVar) {
        tk tkVar = this.f149455a;
        ngVar.a(((Long) tkVar.a((CallbackRunnable<tk.AnonymousClass78>) new tk.AnonymousClass78(ngVar.f149454d), (tk.AnonymousClass78) 0L)).longValue());
    }

    @Override // com.tencent.mapsdk.internal.nh
    public final void d(ng<ob> ngVar) {
        tk tkVar = this.f149455a;
        tkVar.a(new tk.AnonymousClass80(ngVar.e_(), ngVar.f149454d));
    }

    @Override // com.tencent.mapsdk.internal.nh
    public final void e(ng<ob> ngVar) {
        this.f149455a.b(ngVar.e_());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.tencent.mapsdk.internal.nh
    public synchronized oa b(@NonNull ob obVar) {
        return (oa) super.b((nz) obVar);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private oa a2(ob obVar) {
        return new oa(this, obVar);
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
    public final void f(ng<ob> ngVar) {
    }
}
