package com.tencent.qqcamerakit.capture.camera2;

import android.annotation.TargetApi;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqcamerakit.common.e;

/* compiled from: P */
@TargetApi(21)
/* loaded from: classes22.dex */
public class c extends CameraCaptureSession.CaptureCallback {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private b f344864a;

    /* renamed from: b, reason: collision with root package name */
    private int f344865b;

    public c(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) bVar);
        } else {
            this.f344865b = 0;
            this.f344864a = bVar;
        }
    }

    private void a(CaptureResult captureResult) {
        if (this.f344865b == 1) {
            Integer num = (Integer) captureResult.get(CaptureResult.CONTROL_AF_STATE);
            if (e.f()) {
                e.a("Camera2Control", 2, "[Camera2]process afState:" + num);
            }
            if (num == null) {
                b bVar = this.f344864a;
                if (bVar != null) {
                    bVar.B();
                    return;
                }
                return;
            }
            if (4 == num.intValue() || 2 == num.intValue() || 5 == num.intValue() || num.intValue() == 0 || 1 == num.intValue() || 3 == num.intValue()) {
                Integer num2 = (Integer) captureResult.get(CaptureResult.CONTROL_AE_STATE);
                if (num2 != null && num2.intValue() != 2) {
                    if (e.f()) {
                        e.a("Camera2Control", 2, "[Camera2]process preCapture aeState:" + num2);
                    }
                    b bVar2 = this.f344864a;
                    if (bVar2 != null) {
                        bVar2.B();
                        return;
                    }
                    return;
                }
                this.f344865b = 4;
                if (e.f()) {
                    e.a("Camera2Control", 2, "[Camera2]process aeState:" + num2);
                }
                b bVar3 = this.f344864a;
                if (bVar3 != null) {
                    bVar3.B();
                }
            }
        }
    }

    public void b(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else {
            this.f344865b = i3;
        }
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public void onCaptureCompleted(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, cameraCaptureSession, captureRequest, totalCaptureResult);
        } else {
            a(totalCaptureResult);
        }
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public void onCaptureProgressed(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull CaptureResult captureResult) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, cameraCaptureSession, captureRequest, captureResult);
        } else {
            a(captureResult);
        }
    }
}
