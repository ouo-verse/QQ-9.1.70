package com.android.volley;

import android.os.Handler;
import java.util.concurrent.Executor;

/* compiled from: P */
/* loaded from: classes.dex */
public class ExecutorDelivery implements i {

    /* renamed from: a, reason: collision with root package name */
    private final Executor f31295a;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class ResponseDeliveryRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private final Request f31296d;

        /* renamed from: e, reason: collision with root package name */
        private final h f31297e;

        /* renamed from: f, reason: collision with root package name */
        private final Runnable f31298f;

        public ResponseDeliveryRunnable(Request request, h hVar, Runnable runnable) {
            this.f31296d = request;
            this.f31297e = hVar;
            this.f31298f = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f31296d.isCanceled()) {
                this.f31296d.finish("canceled-at-delivery");
                return;
            }
            if (this.f31297e.b()) {
                this.f31296d.deliverResponse(this.f31297e.f31337a);
            } else {
                this.f31296d.deliverError(this.f31297e.f31339c);
            }
            if (this.f31297e.f31340d) {
                this.f31296d.addMarker("intermediate-response");
            } else {
                this.f31296d.finish("done");
            }
            Runnable runnable = this.f31298f;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    class a implements Executor {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Handler f31299d;

        a(Handler handler) {
            this.f31299d = handler;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.f31299d.post(runnable);
        }
    }

    public ExecutorDelivery(Handler handler) {
        this.f31295a = new a(handler);
    }

    @Override // com.android.volley.i
    public void a(Request<?> request, h<?> hVar, Runnable runnable) {
        request.markDelivered();
        request.addMarker("post-response");
        this.f31295a.execute(new ResponseDeliveryRunnable(request, hVar, runnable));
    }

    @Override // com.android.volley.i
    public void b(Request<?> request, h<?> hVar) {
        a(request, hVar, null);
    }

    @Override // com.android.volley.i
    public void c(Request<?> request, VolleyError volleyError) {
        request.addMarker("post-error");
        this.f31295a.execute(new ResponseDeliveryRunnable(request, h.a(volleyError), null));
    }
}
