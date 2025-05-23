package com.tencent.aelight.camera.ae.mode;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class AECaptureModeChangingEvent {

    /* renamed from: a, reason: collision with root package name */
    public final AECaptureMode f65598a;

    /* renamed from: b, reason: collision with root package name */
    public final AECaptureMode f65599b;

    /* renamed from: c, reason: collision with root package name */
    public final int f65600c;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes32.dex */
    @interface ReasonMode {
    }

    public AECaptureModeChangingEvent(AECaptureMode aECaptureMode, AECaptureMode aECaptureMode2, int i3) {
        this.f65598a = aECaptureMode;
        this.f65599b = aECaptureMode2;
        this.f65600c = i3;
    }
}
