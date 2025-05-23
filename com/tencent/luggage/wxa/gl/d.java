package com.tencent.luggage.wxa.gl;

import com.tencent.luggage.wxa.tn.w;

/* compiled from: P */
/* loaded from: classes8.dex */
public class d extends g implements b {

    /* renamed from: c, reason: collision with root package name */
    public String f126792c = "*";

    @Override // com.tencent.luggage.wxa.gl.b
    public void b(String str) {
        if (str == null) {
            w.d("MicroMsg.AppBrandNetWork.HandshakeImpl1Client", "http resource descriptor must not be null");
        } else {
            this.f126792c = str;
        }
    }

    @Override // com.tencent.luggage.wxa.gl.a
    public String c() {
        return this.f126792c;
    }
}
