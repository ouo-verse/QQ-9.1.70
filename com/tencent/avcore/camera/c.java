package com.tencent.avcore.camera;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.Camera;
import com.tencent.avcore.config.CameraConfigHelper;
import com.tencent.avcore.jni.render.FocusDetectCallback;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class c extends b implements FocusDetectCallback {
    static IPatchRedirector $redirector_;
    private final Camera.AutoFocusCallback C;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a implements Camera.AutoFocusCallback {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
            }
        }

        @Override // android.hardware.Camera.AutoFocusCallback
        public void onAutoFocus(boolean z16, Camera camera2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), camera2);
                return;
            }
            if (AVCoreLog.isColorLevel()) {
                AVCoreLog.d("AndroidCamera", "camera focus success ? " + z16);
            }
            c.this.f77401r.n(false);
        }
    }

    public c(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.C = new a();
        }
    }

    @TargetApi(9)
    private void a0(Camera.Parameters parameters, boolean z16) {
        if (parameters == null) {
            AVCoreLog.printColorLog("AndroidCamera", "parameters null, do nothing about focus config");
            return;
        }
        List<String> supportedFocusModes = parameters.getSupportedFocusModes();
        if (supportedFocusModes == null) {
            AVCoreLog.printColorLog("AndroidCamera", "getSupportedFocusModes empty");
            return;
        }
        boolean h16 = this.f77401r.h();
        AVCoreLog.printColorLog("AndroidCamera", String.format("enableAutoFocus, isUserSelfFocusDev[%s], enable[%s]", Boolean.valueOf(h16), Boolean.valueOf(z16)));
        if (h16) {
            c0(z16, supportedFocusModes);
        } else {
            d0(z16, supportedFocusModes, parameters);
        }
    }

    private void c0(boolean z16, List<String> list) {
        this.f77401r.i(z16, list, this);
    }

    private void d0(boolean z16, List<String> list, Camera.Parameters parameters) {
        if (z16 && this.f77388e >= 9 && list.contains("continuous-video")) {
            parameters.setFocusMode("continuous-video");
            try {
                this.f77385b.setParameters(parameters);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.avcore.camera.b
    public void P(long j3, int i3, int i16) {
        Camera.Parameters parameters;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        super.P(j3, i3, i16);
        Camera camera2 = this.f77385b;
        if (camera2 != null) {
            try {
                parameters = camera2.getParameters();
            } catch (Exception e16) {
                AVCoreLog.e("AndroidCamera", "setCameraPara exception", e16);
                parameters = null;
            }
            if (parameters != null) {
                CameraConfigHelper.getInstance(this.f77384a.getApplicationContext()).setCameraParameters(parameters.flatten());
                a0(parameters, true);
                return;
            } else {
                if (AVCoreLog.isDevelopLevel()) {
                    AVCoreLog.d("AndroidCamera", "setCameraPara, parameters[null]");
                    return;
                }
                return;
            }
        }
        if (AVCoreLog.isDevelopLevel()) {
            AVCoreLog.printAllUserLog("AndroidCamera", "setCameraPara, camera[false]");
        }
    }

    @Override // com.tencent.avcore.camera.b
    public synchronized boolean a(long j3) {
        Camera.Parameters parameters;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, j3)).booleanValue();
        }
        if (b.f77381x) {
            try {
                parameters = this.f77385b.getParameters();
            } catch (Exception e16) {
                if (AVCoreLog.isColorLevel()) {
                    AVCoreLog.e("AndroidCamera", "closeCamera", e16);
                }
                parameters = null;
            }
            a0(parameters, false);
        }
        return super.a(j3);
    }

    public int b0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return f(this.f77392i, this.f77385b).f77462c;
    }

    @Override // com.tencent.avcore.jni.render.FocusDetectCallback
    public void onFocusDetectResult(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
            return;
        }
        if (z16) {
            if (this.f77385b == null) {
                AVCoreLog.printColorLog("AndroidCamera", "camera null, return");
            } else {
                this.f77401r.n(true);
                this.f77385b.autoFocus(this.C);
            }
        }
    }
}
