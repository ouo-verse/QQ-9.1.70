package com.tencent.luggage.wxa.hg;

import java.nio.ByteBuffer;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class d extends com.tencent.luggage.wxa.xd.a {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.r4.d f127102b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ JSONObject f127103c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f127104d;

        public a(com.tencent.luggage.wxa.r4.d dVar, JSONObject jSONObject, int i3) {
            this.f127102b = dVar;
            this.f127103c = jSONObject;
            this.f127104d = i3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            m a16 = j.f127133a.a(d.this.e(), this.f127102b, this.f127103c);
            this.f127102b.a(this.f127104d, d.this.makeReturnJson(a16.a(), a16.b()));
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void invoke(com.tencent.luggage.wxa.r4.d dVar, JSONObject jSONObject, int i3) {
        if (dVar == null) {
            return;
        }
        if (jSONObject == null) {
            dVar.a(i3, makeReturnJson(com.tencent.luggage.wxa.af.e.f121315k));
        } else {
            com.tencent.luggage.wxa.zp.h.f146825d.b(new a(dVar, jSONObject, i3), "SmCryptoInvoker");
        }
    }

    public abstract o e();

    @Override // com.tencent.luggage.wxa.xd.o
    public ByteBuffer processNativeBuffer(String str, com.tencent.luggage.wxa.ei.l lVar, int i3) {
        ByteBuffer processNativeBuffer = super.processNativeBuffer(str, lVar, i3);
        if (processNativeBuffer == null) {
            return ByteBuffer.allocate(0);
        }
        return processNativeBuffer;
    }
}
