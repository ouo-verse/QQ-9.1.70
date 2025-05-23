package com.tencent.luggage.wxa.l4;

import android.os.Build;
import com.tencent.luggage.wxa.oe.i;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class g implements i {

    /* renamed from: b, reason: collision with root package name */
    public static final g f133035b = new g();

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f133036a;

    public g() {
        i iVar;
        if (Build.VERSION.SDK_INT >= 24) {
            iVar = a.f133011a;
        } else {
            iVar = com.tencent.luggage.wxa.oe.f.f136402a;
        }
        this.f133036a = iVar;
    }

    @Override // com.tencent.luggage.wxa.oe.i
    public int U() {
        return this.f133036a.U();
    }

    @Override // com.tencent.luggage.wxa.oe.i
    public boolean X() {
        return this.f133036a.X();
    }

    @Override // com.tencent.luggage.wxa.oe.i
    public void c(int i3) {
        this.f133036a.c(i3);
    }
}
