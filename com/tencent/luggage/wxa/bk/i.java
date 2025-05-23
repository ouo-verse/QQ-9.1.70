package com.tencent.luggage.wxa.bk;

import com.tencent.luggage.wxa.tn.w;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class i extends com.tencent.luggage.wxa.wn.b {
    @Override // com.tencent.luggage.wxa.wn.b
    public void a() {
        super.a();
        w.d("MicroMsg.LoggerState", getName() + " [ENTERING]");
    }

    @Override // com.tencent.luggage.wxa.wn.b
    public void b() {
        super.b();
        w.d("MicroMsg.LoggerState", getName() + " [EXITING]");
    }
}
