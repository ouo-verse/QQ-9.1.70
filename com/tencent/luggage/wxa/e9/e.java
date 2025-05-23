package com.tencent.luggage.wxa.e9;

import com.tencent.luggage.wxa.g9.k;
import com.tencent.luggage.wxa.g9.l;

/* compiled from: P */
/* loaded from: classes8.dex */
public class e extends l {

    /* renamed from: e, reason: collision with root package name */
    public f f124595e;

    public e(f fVar, String str, int i3) {
        super(str, i3);
        this.f124595e = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        f fVar = this.f124595e;
        if (fVar != null) {
            fVar.a();
            this.f124595e.b();
        }
        this.f124595e = null;
        k.d(this);
    }
}
