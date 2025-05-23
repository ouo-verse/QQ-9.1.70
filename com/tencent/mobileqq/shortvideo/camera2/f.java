package com.tencent.mobileqq.shortvideo.camera2;

import android.annotation.TargetApi;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.support.annotation.NonNull;

/* compiled from: P */
@TargetApi(21)
/* loaded from: classes18.dex */
public class f extends CameraCaptureSession.CaptureCallback {

    /* renamed from: a, reason: collision with root package name */
    private Camera2Control f287844a;

    /* renamed from: b, reason: collision with root package name */
    private int f287845b = 0;

    public f(Camera2Control camera2Control) {
        this.f287844a = camera2Control;
    }

    private void a(CaptureResult captureResult) {
        if (this.f287845b == 1) {
            Integer num = (Integer) captureResult.get(CaptureResult.CONTROL_AF_STATE);
            d.a(1, "[Camera2]process afState:" + num);
            if (num == null) {
                Camera2Control camera2Control = this.f287844a;
                if (camera2Control != null) {
                    camera2Control.B();
                    return;
                }
                return;
            }
            if (4 == num.intValue() || 5 == num.intValue() || num.intValue() == 0 || 1 == num.intValue() || 2 == num.intValue()) {
                Integer num2 = (Integer) captureResult.get(CaptureResult.CONTROL_AE_STATE);
                if (num2 != null && num2.intValue() != 2) {
                    d.a(1, "[Camera2]process preCapture aeState:" + num2);
                    Camera2Control camera2Control2 = this.f287844a;
                    if (camera2Control2 != null) {
                        camera2Control2.B();
                        return;
                    }
                    return;
                }
                this.f287845b = 4;
                d.a(1, "[Camera2]process aeState:" + num2);
                Camera2Control camera2Control3 = this.f287844a;
                if (camera2Control3 != null) {
                    camera2Control3.B();
                }
            }
        }
    }

    public void b(int i3) {
        this.f287845b = i3;
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public void onCaptureCompleted(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
        a(totalCaptureResult);
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public void onCaptureProgressed(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull CaptureResult captureResult) {
        a(captureResult);
    }
}
