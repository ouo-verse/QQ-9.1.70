package com.tencent.could.aicamare;

import android.content.Context;
import android.graphics.ImageFormat;
import android.hardware.Camera;
import com.tencent.could.aicamare.callback.CameraEventListener;
import com.tencent.could.aicamare.callback.CameraLoggerCallBack;
import com.tencent.could.aicamare.entity.CameraConfig;
import com.tencent.could.aicamare.util.CameraLogger;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes5.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public com.tencent.could.aicamare.entity.a f99919a;

    /* renamed from: b, reason: collision with root package name */
    public CameraEventListener f99920b;

    /* renamed from: c, reason: collision with root package name */
    public CameraLoggerCallBack f99921c;

    /* renamed from: d, reason: collision with root package name */
    public CameraConfig f99922d;

    /* renamed from: e, reason: collision with root package name */
    public volatile boolean f99923e;

    /* renamed from: f, reason: collision with root package name */
    public WeakReference<Context> f99924f;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f99919a = new com.tencent.could.aicamare.entity.a();
        }
    }

    public void b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else {
            CameraLogger.a("CameraHolderImp", str, this.f99921c);
        }
    }

    public boolean a(Camera camera2) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) camera2)).booleanValue();
        }
        if (!this.f99922d.isByteDataBuffer()) {
            camera2.setPreviewCallback(new b(this, camera2));
        } else {
            camera2.setPreviewCallbackWithBuffer(new c(this, camera2));
            Camera.Size size = this.f99919a.f99928d;
            if (size != null) {
                camera2.addCallbackBuffer(new byte[((size.width * size.height) * ImageFormat.getBitsPerPixel(17)) / 8]);
                z16 = true;
            } else {
                a(3, "current size is null");
                z16 = false;
            }
            if (!z16) {
                CameraLogger.a("CameraHolderImp", "start Preview buffer happen error!", this.f99921c);
                return false;
            }
        }
        return true;
    }

    public void a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            return;
        }
        CameraLoggerCallBack cameraLoggerCallBack = this.f99921c;
        CameraLogger.LOG_LEVEL log_level = CameraLogger.f99931a;
        if (CameraLogger.LOG_LEVEL.LEVEL_DEBUG.compareTo(CameraLogger.f99931a) >= 0) {
            CameraLogger.a(true, "CameraHolderImp", str, cameraLoggerCallBack);
        }
    }

    public void a(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            return;
        }
        if (context == null) {
            CameraLogger.a("CameraHolderImp", "set context input a null", this.f99921c);
            return;
        }
        WeakReference<Context> weakReference = this.f99924f;
        if ((weakReference == null ? null : weakReference.get()) == null) {
            this.f99924f = new WeakReference<>(context);
        }
    }

    public final void a(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3, (Object) str);
            return;
        }
        CameraEventListener cameraEventListener = this.f99920b;
        if (cameraEventListener != null) {
            cameraEventListener.onEventError(i3, str);
            return;
        }
        b("sendEventError, code: " + i3 + " msg: " + str);
    }
}
