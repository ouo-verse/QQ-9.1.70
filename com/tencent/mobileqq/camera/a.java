package com.tencent.mobileqq.camera;

import android.annotation.TargetApi;
import android.hardware.Camera;
import com.tencent.mobileqq.camera.adapter.CameraWrapper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
@TargetApi(9)
/* loaded from: classes11.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name */
    private static Camera.CameraInfo[] f200984g;

    /* renamed from: h, reason: collision with root package name */
    private static a f200985h;

    /* renamed from: a, reason: collision with root package name */
    private final int f200986a;

    /* renamed from: b, reason: collision with root package name */
    private int f200987b;

    /* renamed from: c, reason: collision with root package name */
    private int f200988c;

    /* renamed from: d, reason: collision with root package name */
    private int f200989d;

    /* renamed from: e, reason: collision with root package name */
    private final Camera.CameraInfo[] f200990e;

    /* renamed from: f, reason: collision with root package name */
    private CameraWrapper f200991f;

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f200987b = -1;
        this.f200988c = -1;
        this.f200989d = -1;
        this.f200991f = CameraWrapper.h();
        Camera.CameraInfo[] cameraInfoArr = f200984g;
        if (cameraInfoArr != null) {
            this.f200986a = cameraInfoArr.length;
            this.f200990e = cameraInfoArr;
        } else {
            int c16 = c();
            this.f200986a = c16;
            if (QLog.isColorLevel()) {
                QLog.d("Q.camera.CameraHolder", 1, "[CameraHolder] mNumberOfCameras = " + c16);
            }
            this.f200990e = new Camera.CameraInfo[c16];
            for (int i3 = 0; i3 < this.f200986a; i3++) {
                this.f200990e[i3] = new Camera.CameraInfo();
                try {
                    Camera.getCameraInfo(i3, this.f200990e[i3]);
                } catch (Exception e16) {
                    QLog.e("Q.camera.CameraHolder", 2, e16, new Object[0]);
                }
            }
        }
        for (int i16 = 0; i16 < this.f200986a; i16++) {
            if (this.f200988c == -1 && this.f200990e[i16].facing == 0) {
                this.f200988c = i16;
            } else if (this.f200989d == -1 && this.f200990e[i16].facing == 1) {
                this.f200989d = i16;
            }
        }
    }

    public static synchronized a d() {
        a aVar;
        synchronized (a.class) {
            if (f200985h == null) {
                synchronized (a.class) {
                    if (f200985h == null) {
                        f200985h = new a();
                    }
                }
            }
            aVar = f200985h;
        }
        return aVar;
    }

    public Camera.CameraInfo[] a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Camera.CameraInfo[]) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f200990e;
    }

    public CameraWrapper b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (CameraWrapper) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return CameraWrapper.h();
    }

    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return CameraWrapper.h().j();
    }
}
