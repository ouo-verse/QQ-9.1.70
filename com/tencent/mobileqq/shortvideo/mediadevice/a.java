package com.tencent.mobileqq.shortvideo.mediadevice;

import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.hardware.Camera;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    private static int f288180b = 0;

    /* renamed from: c, reason: collision with root package name */
    private static int f288181c = -1;

    /* renamed from: d, reason: collision with root package name */
    private static int f288182d = -1;

    /* renamed from: e, reason: collision with root package name */
    private static a f288183e;

    /* renamed from: a, reason: collision with root package name */
    private Camera.Parameters f288184a;

    static {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            SharedPreferences g16 = com.tencent.mobileqq.camera.utils.a.g(BaseApplication.getContext());
            if (g16.contains("local_sp_camera_num")) {
                f288180b = g16.getInt("local_sp_camera_num", 0);
            } else {
                f288180b = Camera.getNumberOfCameras();
            }
            if (QLog.isColorLevel()) {
                QLog.i("CameraAbility", 2, "getNumberOfCameras cost: " + (System.currentTimeMillis() - currentTimeMillis));
            }
            for (int i3 = 0; i3 < f288180b; i3++) {
                Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                Camera.getCameraInfo(i3, cameraInfo);
                int i16 = cameraInfo.facing;
                if (i16 == 0 && f288181c == -1) {
                    f288181c = i3;
                } else if (1 == i16) {
                    f288182d = i3;
                }
            }
        } catch (RuntimeException e16) {
            if (QLog.isColorLevel()) {
                QLog.i("CameraAbility", 2, "", e16);
            }
            f288180b = 1;
        }
    }

    public static int b() {
        return f288181c;
    }

    public static int c() {
        return f288182d;
    }

    public static a d() {
        if (f288183e == null) {
            synchronized (a.class) {
                if (f288183e == null) {
                    f288183e = new a();
                }
            }
        }
        return f288183e;
    }

    public static boolean h() {
        if (i() && f288181c != -1) {
            return true;
        }
        return false;
    }

    public static boolean i() {
        if (f288180b > 0) {
            return true;
        }
        return false;
    }

    public static boolean k() {
        if (i() && f288182d != -1) {
            return true;
        }
        return false;
    }

    public boolean a(Camera camera2) {
        p();
        if (camera2 == null) {
            return false;
        }
        try {
            this.f288184a = camera2.getParameters();
        } catch (Exception e16) {
            e16.printStackTrace();
            this.f288184a = null;
        }
        if (this.f288184a == null) {
            return false;
        }
        return true;
    }

    public List<Camera.Size> e() {
        List<Camera.Size> list;
        try {
            list = this.f288184a.getSupportedPictureSizes();
        } catch (Exception e16) {
            e16.printStackTrace();
            list = null;
        }
        if (list != null && QLog.isColorLevel()) {
            for (Camera.Size size : list) {
                if (size != null) {
                    QLog.d("CameraAbility", 2, "[@] getPictureSizes:w=" + size.width + ",h=" + size.height + " w/h=" + (size.width / size.height));
                }
            }
        }
        return list;
    }

    @TargetApi(9)
    public List<int[]> f() {
        try {
            return this.f288184a.getSupportedPreviewFpsRange();
        } catch (Exception unused) {
            return null;
        }
    }

    public List<Camera.Size> g() {
        List<Camera.Size> list;
        try {
            list = this.f288184a.getSupportedPreviewSizes();
        } catch (Exception e16) {
            e16.printStackTrace();
            list = null;
        }
        if (list != null && QLog.isColorLevel()) {
            for (Camera.Size size : list) {
                if (size != null) {
                    QLog.d("CameraAbility", 2, "[@] getPreviewSizes:w=" + size.width + ",h=" + size.height + " w/h=" + (size.width / size.height));
                }
            }
        }
        return list;
    }

    public boolean j() {
        try {
            List<String> supportedFlashModes = this.f288184a.getSupportedFlashModes();
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

    public boolean l(String str) {
        try {
            List<String> supportedSceneModes = this.f288184a.getSupportedSceneModes();
            if (supportedSceneModes != null && !supportedSceneModes.isEmpty()) {
                return supportedSceneModes.contains(str);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean m(String str) {
        List<String> supportedFocusModes;
        try {
            supportedFocusModes = this.f288184a.getSupportedFocusModes();
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

    public boolean n(int i3) {
        List<Integer> supportedPreviewFormats;
        try {
            supportedPreviewFormats = this.f288184a.getSupportedPreviewFormats();
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

    public boolean o() {
        try {
            return this.f288184a.isZoomSupported();
        } catch (Exception unused) {
            return false;
        }
    }

    public void p() {
        this.f288184a = null;
    }
}
