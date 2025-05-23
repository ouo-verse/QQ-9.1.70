package com.tencent.liteav.videoproducer.capture.b;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import com.tencent.liteav.videoproducer.capture.b.a;

/* compiled from: P */
/* loaded from: classes7.dex */
final /* synthetic */ class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final a.AnonymousClass4 f119637a;

    /* renamed from: b, reason: collision with root package name */
    private final TotalCaptureResult f119638b;

    /* renamed from: c, reason: collision with root package name */
    private final CaptureRequest f119639c;

    c(a.AnonymousClass4 anonymousClass4, TotalCaptureResult totalCaptureResult, CaptureRequest captureRequest) {
        this.f119637a = anonymousClass4;
        this.f119638b = totalCaptureResult;
        this.f119639c = captureRequest;
    }

    public static Runnable a(a.AnonymousClass4 anonymousClass4, TotalCaptureResult totalCaptureResult, CaptureRequest captureRequest) {
        return new c(anonymousClass4, totalCaptureResult, captureRequest);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a.AnonymousClass4.a(this.f119637a, this.f119638b, this.f119639c);
    }
}
