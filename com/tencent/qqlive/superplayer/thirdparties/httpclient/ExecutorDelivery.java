package com.tencent.qqlive.superplayer.thirdparties.httpclient;

import android.os.Handler;
import java.io.IOException;
import java.util.concurrent.Executor;

/* compiled from: P */
/* loaded from: classes22.dex */
public class ExecutorDelivery implements l {

    /* renamed from: a, reason: collision with root package name */
    private final Executor f345412a;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    private static class ResponseDeliveryRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private final Request f345413d;

        /* renamed from: e, reason: collision with root package name */
        private final k f345414e;

        public ResponseDeliveryRunnable(Request request, k kVar) {
            this.f345413d = request;
            this.f345414e = kVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f345413d.o()) {
                this.f345413d.h();
                return;
            }
            if (this.f345414e.b()) {
                this.f345413d.e(this.f345414e);
            } else {
                this.f345413d.d(this.f345414e.f345468c);
            }
            this.f345413d.h();
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class a implements Executor {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Handler f345415d;

        a(Handler handler) {
            this.f345415d = handler;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.f345415d.post(runnable);
        }
    }

    public ExecutorDelivery(Handler handler) {
        this.f345412a = new a(handler);
    }

    @Override // com.tencent.qqlive.superplayer.thirdparties.httpclient.l
    public void a(Request request, k kVar) {
        this.f345412a.execute(new ResponseDeliveryRunnable(request, kVar));
    }

    @Override // com.tencent.qqlive.superplayer.thirdparties.httpclient.l
    public void b(Request request, IOException iOException) {
        this.f345412a.execute(new ResponseDeliveryRunnable(request, k.a(iOException)));
    }
}
