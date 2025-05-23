package com.tencent.luggage.wxa.iq;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.luggage.wxa.iq.a;
import com.tencent.luggage.wxa.jq.h;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes8.dex */
public class f extends com.tencent.luggage.wxa.iq.a {

    /* renamed from: b, reason: collision with root package name */
    public b f130755b = new b();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class b implements a.InterfaceC6319a {

        /* renamed from: a, reason: collision with root package name */
        public Handler f130756a;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class a extends Handler {
            public a(Looper looper) {
                super(looper);
            }

            @Override // android.os.Handler
            public void dispatchMessage(Message message) {
                if (message.getCallback() != null && (message.getCallback() instanceof h) && ((h) message.getCallback()).isCancelled()) {
                    return;
                }
                super.dispatchMessage(message);
            }
        }

        public b() {
            this.f130756a = new a(Looper.getMainLooper());
        }

        @Override // com.tencent.luggage.wxa.iq.a.InterfaceC6319a
        public void a(h hVar) {
            this.f130756a.postDelayed(hVar, hVar.getDelay(TimeUnit.MILLISECONDS));
        }

        public void b(h hVar) {
            this.f130756a.postAtFrontOfQueue(hVar);
        }

        public void a(Runnable runnable) {
            this.f130756a.removeCallbacks(runnable);
        }
    }

    @Override // com.tencent.luggage.wxa.iq.a
    public a.InterfaceC6319a a() {
        return this.f130755b;
    }

    @Override // com.tencent.luggage.wxa.iq.d
    public void b(h hVar) {
        this.f130755b.a((Runnable) hVar);
    }

    public void d(h hVar) {
        this.f130755b.b(hVar);
    }

    @Override // com.tencent.luggage.wxa.iq.d
    public String getName() {
        return "UIPool";
    }
}
