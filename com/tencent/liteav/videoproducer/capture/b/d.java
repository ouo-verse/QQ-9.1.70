package com.tencent.liteav.videoproducer.capture.b;

import android.hardware.camera2.CaptureRequest;
import com.tencent.liteav.videoproducer.capture.b.a;

/* compiled from: P */
/* loaded from: classes7.dex */
final /* synthetic */ class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final a.AnonymousClass4 f119640a;

    /* renamed from: b, reason: collision with root package name */
    private final CaptureRequest f119641b;

    d(a.AnonymousClass4 anonymousClass4, CaptureRequest captureRequest) {
        this.f119640a = anonymousClass4;
        this.f119641b = captureRequest;
    }

    public static Runnable a(a.AnonymousClass4 anonymousClass4, CaptureRequest captureRequest) {
        return new d(anonymousClass4, captureRequest);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a.AnonymousClass4.a(this.f119640a, this.f119641b);
    }
}
