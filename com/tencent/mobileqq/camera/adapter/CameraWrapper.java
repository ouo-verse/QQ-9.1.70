package com.tencent.mobileqq.camera.adapter;

import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.hardware.Camera;
import android.os.Build;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
@TargetApi(9)
/* loaded from: classes11.dex */
public class CameraWrapper {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static CameraWrapper f200992d;

    /* renamed from: e, reason: collision with root package name */
    private static int f200993e;

    /* renamed from: a, reason: collision with root package name */
    private volatile boolean f200994a;

    /* renamed from: b, reason: collision with root package name */
    private volatile boolean f200995b;

    /* renamed from: c, reason: collision with root package name */
    private volatile boolean f200996c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(71189);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            f200992d = null;
            f200993e = -1;
        }
    }

    CameraWrapper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f200995b = true;
            n(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean f() {
        boolean z16;
        boolean z17;
        try {
            int j3 = j();
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            int i3 = 0;
            while (true) {
                if (i3 < j3) {
                    Camera.getCameraInfo(i3, cameraInfo);
                    if (cameraInfo.facing == 0) {
                        z17 = true;
                        break;
                    }
                    i3++;
                } else {
                    z17 = false;
                    break;
                }
            }
            try {
                com.tencent.mobileqq.camera.utils.a.g(BaseApplication.getContext()).edit().putBoolean("local_sp_camera_back_exist", this.f200995b).commit();
            } catch (Exception e16) {
                z16 = z17;
                e = e16;
                QLog.i("Q.camera.CameraWrapper", 1, "getBlackCameraExistBySysCall fail", e);
                z17 = z16;
                if (QLog.isColorLevel()) {
                }
                return z17;
            }
        } catch (Exception e17) {
            e = e17;
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.camera.CameraWrapper", 2, "getBlackCameraExistBySysCall, return ", Boolean.valueOf(z17));
        }
        return z17;
    }

    public static CameraWrapper h() {
        if (f200992d == null) {
            synchronized (CameraWrapper.class) {
                if (f200992d == null) {
                    f200992d = new CameraWrapper();
                }
            }
        }
        return f200992d;
    }

    public boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        if (this.f200996c) {
            return this.f200995b;
        }
        SharedPreferences g16 = com.tencent.mobileqq.camera.utils.a.g(BaseApplication.getContext());
        if (g16.contains("local_sp_camera_back_exist")) {
            this.f200995b = g16.getBoolean("local_sp_camera_back_exist", false);
        } else {
            this.f200996c = true;
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.camera.adapter.CameraWrapper.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) CameraWrapper.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        CameraWrapper cameraWrapper = CameraWrapper.this;
                        cameraWrapper.f200995b = cameraWrapper.f();
                    }
                }
            }, 64, null, false);
        }
        if (!this.f200995b && QLog.isColorLevel()) {
            QLog.i("Q.camera.CameraWrapper", 1, "check back camera exist, return false");
        }
        return this.f200995b;
    }

    public int g(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
        }
        QLog.d("Q.camera.CameraWrapper", 2, "[getCameraOrientation] cameraId = " + i3 + ", cameraOrientation = " + i16);
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(i3, cameraInfo);
        int i17 = cameraInfo.orientation;
        a.a().b();
        if (cameraInfo.facing == 1) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.camera.CameraWrapper", 2, "is FRONT camera, orientation = " + i17);
            }
            if (i16 != -1 && i16 != 0) {
                if (i16 != 90) {
                    if (i16 != 180) {
                        if (i16 == 270 && a.a().f201011m != -1) {
                            i17 = a.a().f201011m;
                            QLog.d("Q.camera.CameraWrapper", 2, "reset FRONT Cam frontCamRotate270 = " + i17);
                        }
                    } else if (a.a().f201010l != -1) {
                        i17 = a.a().f201010l;
                        QLog.d("Q.camera.CameraWrapper", 2, "reset FRONT Cam frontCamRotate180 = " + i17);
                    }
                } else if (a.a().f201009k != -1) {
                    i17 = a.a().f201009k;
                    QLog.d("Q.camera.CameraWrapper", 2, "reset FRONT Cam frontCamRotate90 = " + i17);
                }
            } else if (a.a().f201008j != -1) {
                i17 = a.a().f201008j;
                QLog.d("Q.camera.CameraWrapper", 2, "reset FRONT Cam frontCamRotate0 = " + i17);
            }
        } else {
            if (QLog.isColorLevel()) {
                QLog.d("Q.camera.CameraWrapper", 2, "is BACK camera, orientation = " + i17);
            }
            if (i16 != -1 && i16 != 0) {
                if (i16 != 90) {
                    if (i16 != 180) {
                        if (i16 == 270 && a.a().f201015q != -1) {
                            i17 = a.a().f201015q;
                            QLog.d("Q.camera.CameraWrapper", 2, "reset BACK Cam backCamRotate270 = " + i17);
                        }
                    } else if (a.a().f201014p != -1) {
                        i17 = a.a().f201014p;
                        QLog.d("Q.camera.CameraWrapper", 2, "reset BACK Cam backCamRotate180 = " + i17);
                    }
                } else if (a.a().f201013o != -1) {
                    i17 = a.a().f201013o;
                    QLog.d("Q.camera.CameraWrapper", 2, "reset BACK Cam backCamRotate90 = " + i17);
                }
            } else if (a.a().f201012n != -1) {
                i17 = a.a().f201012n;
                QLog.d("Q.camera.CameraWrapper", 2, "reset BACK Cam backCamRotate0 = " + i17);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.camera.CameraWrapper", 2, "return orientation = " + i17);
        }
        return i17;
    }

    public int i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return 23;
    }

    public int j() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        if (f200993e != -1) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.camera.CameraWrapper", 2, "[getNumberOfCameras] sNumberOfCameras = " + f200993e);
            }
            return f200993e;
        }
        SharedPreferences g16 = com.tencent.mobileqq.camera.utils.a.g(BaseApplication.getContext());
        if (g16.contains("local_sp_camera_num")) {
            i3 = g16.getInt("local_sp_camera_num", 0);
            if (i3 < 1) {
                i3 = Camera.getNumberOfCameras();
                StatisticCollector.report(StatisticCollector.EVENT_CAMERA_NUM_LESS_TWO);
            }
        } else {
            if (!this.f200994a) {
                this.f200994a = true;
                ThreadManagerV2.excute(new Runnable(g16) { // from class: com.tencent.mobileqq.camera.adapter.CameraWrapper.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ SharedPreferences f200997d;

                    {
                        this.f200997d = g16;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) CameraWrapper.this, (Object) g16);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        int numberOfCameras = Camera.getNumberOfCameras();
                        a.a().e();
                        if (a.a().f201005g || a.a().f201006h) {
                            QLog.d("Q.camera.CameraWrapper", 1, "getNumberOfCameras, readCamNumException:", Boolean.valueOf(a.a().f201005g));
                            numberOfCameras = 1;
                        }
                        CameraWrapper.f200993e = numberOfCameras;
                        this.f200997d.edit().putInt("local_sp_camera_num", numberOfCameras).commit();
                        QLog.d("Q.camera.CameraWrapper", 1, "getNumberOfCameras init, return ", Integer.valueOf(CameraWrapper.f200993e));
                    }
                }, 64, null, false);
            }
            i3 = 2;
        }
        f200993e = i3;
        if (QLog.isColorLevel()) {
            QLog.d("Q.camera.CameraWrapper", 2, "getNumberOfCameras, return ", Integer.valueOf(f200993e));
        }
        return i3;
    }

    public boolean k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        a.a().c();
        return a.a().f201004f;
    }

    public boolean l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        a.a().d();
        return a.a().f201016r;
    }

    public boolean m() {
        String[] strArr;
        int i3;
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        if (QLog.isColorLevel()) {
            QLog.i("Q.camera.CameraWrapper", 2, "[isSysVersionValid] ENTER sysCamerOn=" + a.a().f201001c + " sysMinVersion=" + a.a().f201002d + " sysMaxVersion=" + a.a().f201003e + " currVersion=" + Build.VERSION.RELEASE);
        }
        a.a().f();
        if (a.a().f201001c) {
            try {
                String[] split = a.a().f201002d.split("\\.");
                String[] split2 = a.a().f201003e.split("\\.");
                String str = Build.VERSION.RELEASE;
                if (str != null) {
                    strArr = str.split("\\.");
                } else {
                    strArr = null;
                }
                if (strArr != null && split.length == 3 && split2.length == 3) {
                    int parseInt = Integer.parseInt(split[0]);
                    int parseInt2 = Integer.parseInt(split[1]);
                    int parseInt3 = Integer.parseInt(split[2]);
                    int parseInt4 = Integer.parseInt(strArr[0]);
                    int parseInt5 = Integer.parseInt(strArr[1]);
                    if (strArr.length == 3) {
                        i3 = Integer.parseInt(strArr[2]);
                    } else {
                        i3 = 0;
                    }
                    int parseInt6 = Integer.parseInt(split2[0]);
                    int parseInt7 = Integer.parseInt(split2[1]);
                    int parseInt8 = Integer.parseInt(split2[2]);
                    if (parseInt4 <= parseInt && ((parseInt4 != parseInt || parseInt5 <= parseInt2) && (parseInt != parseInt4 || parseInt2 != parseInt5 || i3 < parseInt3))) {
                        z16 = false;
                    } else {
                        z16 = true;
                    }
                    if (parseInt4 >= parseInt6 && ((parseInt4 != parseInt6 || parseInt5 >= parseInt7) && (parseInt6 != parseInt4 || parseInt7 != parseInt5 || i3 > parseInt8))) {
                        z17 = false;
                    } else {
                        z17 = true;
                    }
                    if (!z16 || !z17) {
                        return false;
                    }
                    return true;
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        return false;
    }

    public void n(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, z16);
        } else {
            a.a().g(com.tencent.mobileqq.camera.utils.a.h(BaseApplication.getContext()), z16);
        }
    }
}
