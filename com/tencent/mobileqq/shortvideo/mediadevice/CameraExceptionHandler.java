package com.tencent.mobileqq.shortvideo.mediadevice;

import android.os.Handler;

/* compiled from: P */
/* loaded from: classes18.dex */
public class CameraExceptionHandler {

    /* renamed from: a, reason: collision with root package name */
    public Handler f288127a;

    /* renamed from: b, reason: collision with root package name */
    public a f288128b;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.shortvideo.mediadevice.CameraExceptionHandler$2, reason: invalid class name */
    /* loaded from: classes18.dex */
    class AnonymousClass2 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Exception f288130d;
        final /* synthetic */ CameraExceptionHandler this$0;

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.f288128b.b(this.f288130d);
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface a {
        void b(Exception exc);

        void c(RuntimeException runtimeException);
    }

    public CameraExceptionHandler(Handler handler, a aVar) {
        this.f288127a = handler;
        this.f288128b = aVar;
    }

    public void a(final RuntimeException runtimeException) {
        this.f288127a.post(new Runnable() { // from class: com.tencent.mobileqq.shortvideo.mediadevice.CameraExceptionHandler.1
            @Override // java.lang.Runnable
            public void run() {
                CameraExceptionHandler.this.f288128b.c(runtimeException);
            }
        });
    }
}
