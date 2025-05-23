package com.tencent.qqcamerakit.capture.camera;

import android.content.Context;
import android.content.SharedPreferences;
import android.hardware.Camera;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqcamerakit.capture.c;
import com.tencent.qqcamerakit.capture.d;
import com.tencent.qqcamerakit.common.e;
import com.tencent.qqnt.kernel.nativeinterface.DigestErrCode;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    private static int f344821b;

    /* renamed from: c, reason: collision with root package name */
    private static int f344822c;

    /* renamed from: d, reason: collision with root package name */
    private static int f344823d;

    /* renamed from: e, reason: collision with root package name */
    private static a f344824e;

    /* renamed from: f, reason: collision with root package name */
    static final /* synthetic */ boolean f344825f;

    /* renamed from: a, reason: collision with root package name */
    private Camera.Parameters f344826a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(DigestErrCode.MSG_EXPIRED);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
            return;
        }
        f344825f = true;
        f344821b = 0;
        f344822c = -1;
        f344823d = -1;
        try {
            Context d16 = c.d();
            if (d16 != null) {
                SharedPreferences sharedPreferences = d16.getSharedPreferences("qcamera_local", 0);
                if (sharedPreferences.contains("localsp_camera_num")) {
                    f344821b = sharedPreferences.getInt("localsp_camera_num", 0);
                }
            }
            if (f344821b == 0) {
                f344821b = Camera.getNumberOfCameras();
                if (d16 != null) {
                    d16.getSharedPreferences("qcamera_local", 0).edit().putInt("localsp_camera_num", f344821b).commit();
                }
            }
            for (int i3 = 0; i3 < f344821b; i3++) {
                Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                Camera.getCameraInfo(i3, cameraInfo);
                int i16 = cameraInfo.facing;
                if (i16 == 0 && f344822c == -1) {
                    f344822c = i3;
                } else if (1 == i16) {
                    f344823d = i3;
                }
            }
        } catch (RuntimeException e16) {
            if (e.f()) {
                e.b("CameraAbility", 2, "", e16);
            }
            f344821b = 1;
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static int b() {
        return f344822c;
    }

    public static int c() {
        return f344823d;
    }

    public static a d() {
        if (f344824e == null) {
            synchronized (a.class) {
                if (f344824e == null) {
                    f344824e = new a();
                }
            }
        }
        return f344824e;
    }

    public static boolean g() {
        if (h() && f344822c != -1) {
            return true;
        }
        return false;
    }

    public static boolean h() {
        if (f344821b > 0) {
            return true;
        }
        return false;
    }

    public static boolean j() {
        if (h() && f344823d != -1) {
            return true;
        }
        return false;
    }

    public boolean a(Camera camera2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) camera2)).booleanValue();
        }
        n();
        if (camera2 == null) {
            return false;
        }
        try {
            this.f344826a = camera2.getParameters();
        } catch (Exception e16) {
            e16.printStackTrace();
            this.f344826a = null;
        }
        if (this.f344826a == null) {
            return false;
        }
        return true;
    }

    public List<int[]> e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (List) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        if (!f344825f && this.f344826a == null) {
            throw new AssertionError();
        }
        try {
            return this.f344826a.getSupportedPreviewFpsRange();
        } catch (Exception unused) {
            return null;
        }
    }

    public List<d> f(boolean z16) {
        List<Camera.Size> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (List) iPatchRedirector.redirect((short) 7, (Object) this, z16);
        }
        if (!f344825f && this.f344826a == null) {
            throw new AssertionError();
        }
        try {
            if (z16) {
                list = this.f344826a.getSupportedPictureSizes();
            } else {
                list = this.f344826a.getSupportedPreviewSizes();
            }
        } catch (Exception e16) {
            e.c("CameraAbility", 1, e16, "getPreviewSizes, isPicture: ", Boolean.valueOf(z16));
            list = null;
        }
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (Camera.Size size : list) {
                d dVar = new d(size.width, size.height);
                arrayList.add(dVar);
                if (e.f()) {
                    e.a("CameraAbility", 2, "getPreviewSizes, isPicture: ", Boolean.valueOf(z16), " ", dVar);
                }
            }
        }
        return arrayList;
    }

    public boolean i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        if (!f344825f && this.f344826a == null) {
            throw new AssertionError();
        }
        try {
            List<String> supportedFlashModes = this.f344826a.getSupportedFlashModes();
            if (supportedFlashModes == null) {
                return false;
            }
            if (!supportedFlashModes.contains("torch")) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean k(String str) {
        List<String> supportedFocusModes;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str)).booleanValue();
        }
        if (!f344825f && this.f344826a == null) {
            throw new AssertionError();
        }
        try {
            supportedFocusModes = this.f344826a.getSupportedFocusModes();
        } catch (Exception unused) {
        }
        if (supportedFocusModes == null) {
            return false;
        }
        if (!supportedFocusModes.contains(str)) {
            return false;
        }
        return true;
    }

    public boolean l(int i3) {
        List<Integer> supportedPreviewFormats;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, i3)).booleanValue();
        }
        if (!f344825f && this.f344826a == null) {
            throw new AssertionError();
        }
        try {
            supportedPreviewFormats = this.f344826a.getSupportedPreviewFormats();
        } catch (Exception unused) {
        }
        if (supportedPreviewFormats == null) {
            return false;
        }
        if (!supportedPreviewFormats.contains(Integer.valueOf(i3))) {
            return false;
        }
        return true;
    }

    public boolean m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        if (!f344825f && this.f344826a == null) {
            throw new AssertionError();
        }
        try {
            return this.f344826a.isZoomSupported();
        } catch (Exception unused) {
            return false;
        }
    }

    public void n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            this.f344826a = null;
        }
    }
}
