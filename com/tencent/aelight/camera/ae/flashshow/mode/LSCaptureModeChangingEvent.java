package com.tencent.aelight.camera.ae.flashshow.mode;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class LSCaptureModeChangingEvent {

    /* renamed from: a, reason: collision with root package name */
    public final LSCaptureMode f64349a;

    /* renamed from: b, reason: collision with root package name */
    public final LSCaptureMode f64350b;

    /* renamed from: c, reason: collision with root package name */
    public final int f64351c;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes32.dex */
    @interface ReasonMode {
    }

    public LSCaptureModeChangingEvent(LSCaptureMode lSCaptureMode, LSCaptureMode lSCaptureMode2, int i3) {
        this.f64349a = lSCaptureMode;
        this.f64350b = lSCaptureMode2;
        this.f64351c = i3;
    }
}
