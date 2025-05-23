package com.tencent.mobileqq.zplan.cc.camera;

import android.app.Activity;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import com.tencent.qmethod.pandoraex.monitor.CameraMonitor;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

/* compiled from: P */
/* loaded from: classes35.dex */
public class a {

    /* renamed from: i, reason: collision with root package name */
    private static float f332489i = -1.0f;

    /* renamed from: j, reason: collision with root package name */
    private static int f332490j = 1280;

    /* renamed from: k, reason: collision with root package name */
    private static int f332491k = 720;

    /* renamed from: l, reason: collision with root package name */
    private static byte[] f332492l;

    /* renamed from: a, reason: collision with root package name */
    private Activity f332493a;

    /* renamed from: b, reason: collision with root package name */
    private Camera f332494b;

    /* renamed from: c, reason: collision with root package name */
    private Camera.Parameters f332495c;

    /* renamed from: e, reason: collision with root package name */
    private c f332497e;

    /* renamed from: f, reason: collision with root package name */
    private SurfaceTexture f332498f;

    /* renamed from: g, reason: collision with root package name */
    private int f332499g;

    /* renamed from: d, reason: collision with root package name */
    private CameraIndex f332496d = CameraIndex.FRONT_CAMERA;

    /* renamed from: h, reason: collision with root package name */
    private int f332500h = 90;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.zplan.cc.camera.a$a, reason: collision with other inner class name */
    /* loaded from: classes35.dex */
    class C9159a implements SurfaceTexture.OnFrameAvailableListener {
        C9159a() {
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
            if (a.this.f332497e != null) {
                a.this.f332497e.onFrameAvailable(surfaceTexture);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class b implements SurfaceTexture.OnFrameAvailableListener {
        b() {
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
            if (a.this.f332497e != null) {
                a.this.f332497e.onFrameAvailable(surfaceTexture);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    public interface c {
        void a(float f16);

        void b(CameraIndex cameraIndex);

        void onFrameAvailable(SurfaceTexture surfaceTexture);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void f(Point point) {
        int i3;
        int i16;
        Camera.Parameters parameters;
        Ratio parseFrom;
        int[] f16;
        c cVar;
        QLog.i("ZPlanCamera", 1, "initCameraParams begin");
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(b(), cameraInfo);
        int i17 = this.f332500h;
        if (i17 != 0) {
            if (i17 == 1) {
                i3 = 90;
            } else if (i17 == 2) {
                i3 = 180;
            } else if (i17 == 3) {
                i3 = 270;
            }
            if (cameraInfo.facing != 1) {
                i16 = (360 - ((cameraInfo.orientation + i3) % 360)) % 360;
            } else {
                i16 = ((cameraInfo.orientation - i3) + 360) % 360;
            }
            this.f332494b.setDisplayOrientation(i16);
            parameters = this.f332494b.getParameters();
            parseFrom = Ratio.parseFrom(this.f332499g);
            float f17 = 0.5625f;
            if (parseFrom != Ratio.RATIO_Full) {
                Activity activity = this.f332493a;
                if (activity != null) {
                    f17 = com.tencent.mobileqq.zplan.cc.camera.b.d(activity);
                }
            } else if (parseFrom != Ratio.RATIO_9_16) {
                f17 = parseFrom == Ratio.RATIO_4_3 ? 0.75f : 1.0f;
            }
            QLog.i("ZPlanCamera", 1, "camera ratio: " + parseFrom + " cameraRatio " + f17);
            Camera.Size e16 = com.tencent.mobileqq.zplan.cc.camera.b.e(point, parameters.getSupportedPreviewSizes(), f17);
            parameters.setPreviewSize(e16.width, e16.height);
            QLog.i("ZPlanCamera", 1, "setPreviewSize: width " + e16.width + " height " + e16.height);
            f16 = com.tencent.mobileqq.zplan.cc.camera.b.f(parameters);
            if (f16 != null && f16.length > 0) {
                parameters.setPreviewFpsRange(f16[0], f16[1]);
            }
            if (parameters.getSupportedFocusModes().contains("continuous-video")) {
                parameters.setFocusMode("continuous-video");
            }
            f332489i = parameters.getHorizontalViewAngle();
            Point c16 = c(false, parameters.getSupportedPreviewSizes(), f332490j, f332491k);
            int i18 = c16.x;
            f332490j = i18;
            int i19 = c16.y;
            f332491k = i19;
            int i26 = ((i18 * i19) * 3) / 2;
            QLog.i("ZPlanCamera", 1, "mFrameBuffer size: width " + f332490j + " height " + f332491k);
            f332492l = new byte[i26];
            this.f332494b.addCallbackBuffer(new byte[i26]);
            this.f332495c = parameters;
            this.f332494b.setParameters(parameters);
            com.tencent.mobileqq.zplan.cc.camera.b.f332504b = parameters;
            cVar = this.f332497e;
            if (cVar != null) {
                cVar.a(f17);
            }
            QLog.i("ZPlanCamera", 1, "initCameraParams end");
        }
        i3 = 0;
        if (cameraInfo.facing != 1) {
        }
        this.f332494b.setDisplayOrientation(i16);
        parameters = this.f332494b.getParameters();
        parseFrom = Ratio.parseFrom(this.f332499g);
        float f172 = 0.5625f;
        if (parseFrom != Ratio.RATIO_Full) {
        }
        QLog.i("ZPlanCamera", 1, "camera ratio: " + parseFrom + " cameraRatio " + f172);
        Camera.Size e162 = com.tencent.mobileqq.zplan.cc.camera.b.e(point, parameters.getSupportedPreviewSizes(), f172);
        parameters.setPreviewSize(e162.width, e162.height);
        QLog.i("ZPlanCamera", 1, "setPreviewSize: width " + e162.width + " height " + e162.height);
        f16 = com.tencent.mobileqq.zplan.cc.camera.b.f(parameters);
        if (f16 != null) {
            parameters.setPreviewFpsRange(f16[0], f16[1]);
        }
        if (parameters.getSupportedFocusModes().contains("continuous-video")) {
        }
        f332489i = parameters.getHorizontalViewAngle();
        Point c162 = c(false, parameters.getSupportedPreviewSizes(), f332490j, f332491k);
        int i182 = c162.x;
        f332490j = i182;
        int i192 = c162.y;
        f332491k = i192;
        int i262 = ((i182 * i192) * 3) / 2;
        QLog.i("ZPlanCamera", 1, "mFrameBuffer size: width " + f332490j + " height " + f332491k);
        f332492l = new byte[i262];
        this.f332494b.addCallbackBuffer(new byte[i262]);
        this.f332495c = parameters;
        this.f332494b.setParameters(parameters);
        com.tencent.mobileqq.zplan.cc.camera.b.f332504b = parameters;
        cVar = this.f332497e;
        if (cVar != null) {
        }
        QLog.i("ZPlanCamera", 1, "initCameraParams end");
    }

    public int b() {
        if (this.f332496d == CameraIndex.FRONT_CAMERA) {
            return com.tencent.mobileqq.zplan.cc.camera.b.b();
        }
        return com.tencent.mobileqq.zplan.cc.camera.b.a();
    }

    public void d(Activity activity) {
        this.f332500h = activity.getWindowManager().getDefaultDisplay().getRotation();
        e(com.tencent.mobileqq.zplan.cc.camera.b.c(activity, new Point()));
    }

    public void e(Point point) {
        if (g()) {
            return;
        }
        try {
            this.f332494b = CameraMonitor.open(b());
            f(point);
        } catch (Exception e16) {
            c cVar = this.f332497e;
            if (cVar != null) {
                cVar.b(this.f332496d);
            }
            this.f332494b = null;
            QLog.e("ZPlanCamera", 1, e16, "camera open error");
        }
    }

    public boolean g() {
        return this.f332494b != null;
    }

    public void h() {
        SurfaceTexture surfaceTexture = this.f332498f;
        if (surfaceTexture != null) {
            surfaceTexture.setOnFrameAvailableListener(null);
            this.f332498f = null;
        }
    }

    public void i(c cVar) {
        this.f332497e = cVar;
    }

    public void j(Activity activity) {
        this.f332493a = activity;
    }

    public void l(int i3) {
        this.f332499g = i3;
    }

    public void m() {
        if (this.f332498f == null) {
            QLog.e("ZPlanCamera", 1, "start preview but surfaceTexture is null");
            return;
        }
        try {
            QLog.i("ZPlanCamera", 1, "start preview");
            this.f332494b.setPreviewTexture(this.f332498f);
            this.f332494b.startPreview();
        } catch (Exception e16) {
            QLog.e("ZPlanCamera", 1, e16, "startPreview error");
        }
    }

    public void n(SurfaceTexture surfaceTexture) {
        if (surfaceTexture == null) {
            QLog.e("ZPlanCamera", 1, "surfaceTexture is null");
            return;
        }
        if (this.f332494b == null) {
            QLog.e("ZPlanCamera", 1, "start previewOnSurface but camera is null");
            return;
        }
        System.currentTimeMillis();
        this.f332498f = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(new b());
        try {
            QLog.i("ZPlanCamera", 1, "start preview on surface");
            this.f332494b.setPreviewTexture(surfaceTexture);
            this.f332494b.startPreview();
        } catch (Exception e16) {
            QLog.e("ZPlanCamera", 1, e16, "setPrviewTexture error");
        }
    }

    public void o() {
        if (this.f332494b != null) {
            QLog.i("ZPlanCamera", 1, "stop preview on surface");
            this.f332494b.setPreviewCallbackWithBuffer(null);
            this.f332494b.setPreviewCallback(null);
            try {
                this.f332494b.stopPreview();
                this.f332494b.release();
                this.f332494b = null;
            } catch (Exception e16) {
                QLog.e("ZPlanCamera", 1, e16, "release error");
            }
        }
    }

    public void k(SurfaceTexture surfaceTexture) {
        if (surfaceTexture == null) {
            return;
        }
        this.f332498f = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(new C9159a());
    }

    public static Point c(boolean z16, List<Camera.Size> list, int i3, int i16) {
        if (z16) {
            i16 = i3;
            i3 = i16;
        }
        for (Camera.Size size : list) {
            if (size.width == i3 && size.height == i16) {
                return new Point(size.width, size.height);
            }
        }
        float f16 = i3 / i16;
        float f17 = Float.MAX_VALUE;
        Camera.Size size2 = null;
        for (Camera.Size size3 : list) {
            float abs = Math.abs(f16 - (size3.width / size3.height));
            if (abs < f17) {
                size2 = size3;
                f17 = abs;
            }
        }
        if (size2 != null) {
            return new Point(size2.width, size2.height);
        }
        return new Point(i3, i16);
    }
}
