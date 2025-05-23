package com.tencent.luggage.wxa.ph;

import com.tencent.luggage.wxa.p004if.b0;
import com.tencent.luggage.wxa.p004if.p;
import com.tencent.luggage.wxa.ph.c;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.xd.d;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final com.tencent.luggage.wxa.ph.a f137601a;

    /* renamed from: b, reason: collision with root package name */
    public final b0 f137602b = b0.f130171e.a(new Function0() { // from class: v31.a
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            d b16;
            b16 = c.this.b();
            return b16;
        }
    }, new a());

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements p.a {
        public a() {
        }

        @Override // com.tencent.luggage.wxa.if.p.a
        public void onPause() {
            w.d("MicroMsg.AppBrand.BackgroundPlayAudioFocusHelper", "audio focus lossTransient");
            c.this.f137601a.p();
        }

        @Override // com.tencent.luggage.wxa.if.p.a
        public void onResume() {
            w.d("MicroMsg.AppBrand.BackgroundPlayAudioFocusHelper", "audio focus gain");
            c.this.f137601a.q();
        }

        @Override // com.tencent.luggage.wxa.if.p.a
        public void onStop() {
            w.d("MicroMsg.AppBrand.BackgroundPlayAudioFocusHelper", "audio focus loss, passive pause");
            c.this.f137601a.r();
            c.this.a();
        }
    }

    public c(com.tencent.luggage.wxa.ph.a aVar) {
        this.f137601a = aVar;
    }

    public boolean c() {
        return this.f137602b.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ com.tencent.luggage.wxa.xd.d b() {
        return this.f137601a.h().h0();
    }

    public void a() {
        this.f137602b.a();
    }
}
