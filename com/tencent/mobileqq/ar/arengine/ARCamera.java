package com.tencent.mobileqq.ar.arengine;

import android.graphics.Matrix;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.aelight.camera.api.ICameraCompatible;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.ar.ScanEntranceReport;
import com.tencent.mobileqq.ar.model.CameraProxy;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.SensorMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.CameraUtil;
import java.util.ArrayList;
import java.util.List;
import kotlinx.coroutines.DebugKt;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ARCamera implements Camera.AutoFocusCallback {
    private static final int S;
    private static final int T;
    private static final Object U;
    private static int V;
    private static long W;
    private int C;
    private int F;
    private int G;
    private boolean H;
    private boolean I;
    private int J;
    private int K;
    private b P;

    /* renamed from: d, reason: collision with root package name */
    private Camera f197732d;

    /* renamed from: e, reason: collision with root package name */
    private Handler f197733e;

    /* renamed from: f, reason: collision with root package name */
    private int f197734f;

    /* renamed from: h, reason: collision with root package name */
    private int f197735h;

    /* renamed from: i, reason: collision with root package name */
    private int f197736i;

    /* renamed from: m, reason: collision with root package name */
    private int f197737m;
    private boolean D = false;
    private Matrix E = new Matrix();
    private int L = 0;
    private int M = 0;
    private boolean Q = false;
    SensorEventListener R = new a();
    private SensorManager N = (SensorManager) BaseApplication.getContext().getSystemService(WebRTCSDK.PRIVILEGE_SENSOR);

    /* compiled from: P */
    /* loaded from: classes11.dex */
    private class ARCameraHandler extends Handler {
        public ARCameraHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 100:
                    CameraProxy.v().F(new Runnable() { // from class: com.tencent.mobileqq.ar.arengine.ARCamera.ARCameraHandler.1
                        @Override // java.lang.Runnable
                        public void run() {
                            int i3;
                            ARCamera aRCamera = ARCamera.this;
                            int i16 = aRCamera.f197737m / 2;
                            int i17 = ARCamera.this.C / 2;
                            int i18 = ARCamera.this.f197737m;
                            int i19 = ARCamera.this.C;
                            if (!ARCamera.this.Q) {
                                i3 = ARCamera.T;
                            } else {
                                i3 = (ARCamera.this.f197737m * 3) / 4;
                            }
                            aRCamera.s(i16, i17, i18, i19, i3);
                        }
                    });
                    removeMessages(100);
                    sendEmptyMessageDelayed(100, 3000L);
                    return;
                case 101:
                    CameraProxy.v().F(new Runnable() { // from class: com.tencent.mobileqq.ar.arengine.ARCamera.ARCameraHandler.2
                        @Override // java.lang.Runnable
                        public void run() {
                            ARCamera.this.D();
                        }
                    });
                    return;
                case 102:
                    CameraProxy.v().F(new Runnable() { // from class: com.tencent.mobileqq.ar.arengine.ARCamera.ARCameraHandler.3
                        @Override // java.lang.Runnable
                        public void run() {
                            ARCamera.this.H();
                        }
                    });
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface b {
        void r(boolean z16);
    }

    static {
        int i3 = ScreenUtil.SCREEN_WIDTH;
        S = (i3 * 3) / 4;
        T = (i3 * 3) / 4;
        U = new Object();
        V = -3;
        W = -1L;
    }

    public ARCamera() {
        this.f197733e = null;
        this.f197733e = new ARCameraHandler(Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        int zoom;
        int i3;
        if (QLog.isColorLevel()) {
            QLog.d("AREngine_ARCamera", 2, String.format("revertZoom mZooming=%s", Boolean.valueOf(this.H)));
        }
        try {
            if (this.f197732d != null) {
                this.H = false;
                Handler handler = this.f197733e;
                if (handler != null) {
                    handler.removeMessages(102);
                    this.f197733e.removeMessages(101);
                }
                Camera.Parameters parameters = this.f197732d.getParameters();
                if (parameters.isZoomSupported() && (zoom = parameters.getZoom()) != (i3 = this.F)) {
                    I(zoom, i3);
                    ReportController.o(null, "dc00898", "", "", "0X80085B0", "0X80085B0", 0, 0, "", "", "", "");
                }
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H() {
        try {
            if (this.f197732d != null) {
                int i3 = this.J;
                int i16 = this.K;
                if (i3 != i16) {
                    try {
                        if (this.I) {
                            int i17 = i3 + 5;
                            this.J = i17;
                            this.J = Math.min(i17, i16);
                        } else {
                            int i18 = i3 - 5;
                            this.J = i18;
                            this.J = Math.max(i18, i16);
                        }
                        int min = Math.min(this.J, this.G);
                        this.J = min;
                        this.J = Math.max(min, this.F);
                        Camera.Parameters parameters = this.f197732d.getParameters();
                        parameters.setZoom(this.J);
                        this.f197732d.setParameters(parameters);
                        Handler handler = this.f197733e;
                        if (handler != null) {
                            handler.removeMessages(102);
                            this.f197733e.sendEmptyMessageDelayed(102, 20L);
                            return;
                        }
                        return;
                    } catch (Exception e16) {
                        if (QLog.isColorLevel()) {
                            QLog.d("AREngine_ARCamera", 2, "updateZoom fail!", e16);
                            return;
                        }
                        return;
                    }
                }
                this.H = false;
            }
        } catch (Exception unused) {
        }
    }

    private void I(int i3, int i16) {
        try {
            if (this.f197732d != null) {
                boolean z16 = true;
                this.H = true;
                if (i16 <= i3) {
                    z16 = false;
                }
                this.I = z16;
                this.J = i3;
                this.K = i16;
                H();
            }
        } catch (Exception unused) {
        }
    }

    private Rect l(int i3, int i16, int i17, int i18, int i19, float f16) {
        int i26 = (int) (i19 * f16);
        int i27 = i26 / 2;
        RectF rectF = new RectF(p(i3 - i27, 0, i17 - i26), p(i16 - i27, 0, i18 - i26), r2 + i26, r3 + i26);
        this.E.mapRect(rectF);
        return new Rect(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
    }

    private boolean m() {
        return !((ICameraCompatible) QRoute.api(ICameraCompatible.class)).isFoundProduct(com.tencent.aelight.camera.constants.a.f68987a);
    }

    public static int o(int i3) {
        int numberOfCameras = Camera.getNumberOfCameras();
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        for (int i16 = 0; i16 < numberOfCameras; i16++) {
            try {
                Camera.getCameraInfo(i16, cameraInfo);
                if (i3 == cameraInfo.facing) {
                    return i16;
                }
            } catch (Throwable th5) {
                QLog.i("AREngine_ARCamera", 1, "checkCameraFacing error:" + th5.getMessage());
            }
        }
        return 0;
    }

    private int p(int i3, int i16, int i17) {
        if (i3 > i17) {
            return i17;
        }
        if (i3 < i16) {
            return i16;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(int i3, int i16, int i17, int i18, int i19) {
        if (this.f197732d != null && m() && !this.D) {
            try {
                Camera.Parameters parameters = this.f197732d.getParameters();
                if (!parameters.getSupportedFocusModes().contains("auto")) {
                    return;
                }
                Rect l3 = l(i3, i16, i17, i18, i19, 1.0f);
                Rect l16 = l(i3, i16, i17, i18, i19, 1.0f);
                QLog.d("AREngine_ARCamera", 1, String.format("focusOnArea focusRect=%s meteringRect=%s", l3, l16));
                parameters.setFocusMode("auto");
                if (parameters.getMaxNumFocusAreas() > 0) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new Camera.Area(l3, 1000));
                    parameters.setFocusAreas(arrayList);
                }
                if (parameters.getMaxNumMeteringAreas() > 0) {
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(new Camera.Area(l16, 1000));
                    parameters.setMeteringAreas(arrayList2);
                }
                this.f197732d.cancelAutoFocus();
                this.f197732d.setParameters(parameters);
                this.f197732d.autoFocus(this);
                this.D = true;
            } catch (Exception e16) {
                QLog.i("AREngine_ARCamera", 1, "focusOnArea fail.", e16);
                try {
                    this.f197732d.cancelAutoFocus();
                    Camera.Parameters parameters2 = this.f197732d.getParameters();
                    x1.a.f(parameters2);
                    this.f197732d.setParameters(parameters2);
                } catch (Exception e17) {
                    QLog.i("AREngine_ARCamera", 1, "focusOnArea fail.", e17);
                }
            }
        }
    }

    public int A(int i3, long j3) {
        int i16;
        QLog.i("AREngine_ARCamera", 1, "openCamera mCamera=" + this.f197732d);
        if (this.f197732d != null) {
            synchronized (U) {
                V = 0;
                W = Thread.currentThread().getId();
            }
            return 0;
        }
        try {
            if (DeviceInfoMonitor.getModel().equalsIgnoreCase("MI 5s Plus") || DeviceInfoMonitor.getModel().equalsIgnoreCase("vivo X7") || j3 != 0) {
                if (j3 != 0) {
                    Thread.currentThread();
                    LockMethodProxy.sleep(j3);
                } else {
                    Thread.currentThread();
                    LockMethodProxy.sleep(800L);
                }
            }
            if (Camera.getNumberOfCameras() > 0) {
                int o16 = o(i3);
                try {
                    this.f197732d = CameraUtil.openCameraWithRetry(o16, 1);
                } catch (Exception e16) {
                    QLog.i("AREngine_ARCamera", 1, "openCamera index:" + o16 + " fail.", e16);
                }
                if (this.f197732d == null && o16 != 1) {
                    this.f197732d = CameraUtil.openCameraWithRetry(1, 1);
                    o16 = 1;
                }
                if (this.f197732d != null) {
                    Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                    Camera.getCameraInfo(o16, cameraInfo);
                    this.L = cameraInfo.orientation;
                }
            }
            Camera camera2 = this.f197732d;
            if (camera2 == null) {
                QLog.i("AREngine_ARCamera", 1, "openCamera fail. mCamera is null.");
                synchronized (U) {
                    V = -3;
                    W = Thread.currentThread().getId();
                }
                return -3;
            }
            x1.a.e(camera2, 1280, 720, com.tencent.mobileqq.ar.y.a().f198842b);
            int i17 = 270;
            if (((ICameraCompatible) QRoute.api(ICameraCompatible.class)).isFoundProduct(com.tencent.aelight.camera.constants.a.f68993g) && i3 == 0) {
                i16 = 270;
            } else {
                i16 = 90;
            }
            if (i3 != 1 || (!((ICameraCompatible) QRoute.api(ICameraCompatible.class)).isFoundProduct(com.tencent.aelight.camera.constants.a.f68991e) && !((ICameraCompatible) QRoute.api(ICameraCompatible.class)).isFoundProductFeatureRom(com.tencent.aelight.camera.constants.a.f68992f))) {
                i17 = i16;
            }
            this.f197732d.setDisplayOrientation(i17);
            Camera.Parameters parameters = this.f197732d.getParameters();
            this.f197736i = parameters.getPreviewFormat();
            PixelFormat pixelFormat = new PixelFormat();
            PixelFormat.getPixelFormatInfo(this.f197736i, pixelFormat);
            Camera.Size previewSize = parameters.getPreviewSize();
            this.f197734f = previewSize.width;
            this.f197735h = previewSize.height;
            this.D = false;
            this.F = parameters.getZoom();
            this.G = (parameters.getMaxZoom() / 3) * 2;
            QLog.d("AREngine_ARCamera", 1, String.format("openCamera mInitZoom=%s mMaxZoom=%s supportMaxZoom=%s", Integer.valueOf(this.F), Integer.valueOf(this.G), Integer.valueOf(parameters.getMaxZoom())));
            int i18 = ((this.f197734f * this.f197735h) * pixelFormat.bitsPerPixel) / 8;
            for (int i19 = 0; i19 < 3; i19++) {
                this.f197732d.addCallbackBuffer(new byte[i18]);
            }
            synchronized (U) {
                V = 0;
                W = Thread.currentThread().getId();
            }
            return 0;
        } catch (Exception e17) {
            QLog.i("AREngine_ARCamera", 1, "openCamera fail.", e17);
            synchronized (U) {
                V = -3;
                W = Thread.currentThread().getId();
                return -3;
            }
        }
    }

    public int B(int i3) {
        boolean z16;
        synchronized (U) {
            z16 = false;
            if (W != -1 && Thread.currentThread().getId() != W && V == 0) {
                z16 = true;
            }
        }
        if (z16) {
            return A(i3, 150L);
        }
        return A(i3, 0L);
    }

    public void C() {
        Handler handler = this.f197733e;
        if (handler != null) {
            handler.removeMessages(101);
            this.f197733e.sendEmptyMessageDelayed(101, 20L);
        }
    }

    public boolean E(Camera.PreviewCallback previewCallback, SurfaceTexture surfaceTexture, b bVar) {
        boolean z16 = false;
        QLog.i("AREngine_ARCamera", 1, String.format("startPreview callback=%s surfaceTexture=%s mCamera=%s", previewCallback, surfaceTexture, this.f197732d));
        Camera camera2 = this.f197732d;
        if (camera2 == null) {
            return false;
        }
        try {
            camera2.setPreviewCallbackWithBuffer(previewCallback);
            this.f197732d.setPreviewTexture(surfaceTexture);
            this.f197732d.startPreview();
            this.P = bVar;
            try {
                if (this.N != null && com.tencent.mobileqq.qmethodmonitor.a.a(MobileQQ.sMobileQQ)) {
                    SensorManager sensorManager = this.N;
                    SensorMonitor.registerListener(sensorManager, this.R, SensorMonitor.getDefaultSensor(sensorManager, 1), 3);
                }
                return true;
            } catch (Exception e16) {
                e = e16;
                z16 = true;
                QLog.i("AREngine_ARCamera", 1, "startPreview fail.", e);
                return z16;
            }
        } catch (Exception e17) {
            e = e17;
        }
    }

    public void F() {
        QLog.i("AREngine_ARCamera", 1, String.format("stopPreview mCamera=%s", this.f197732d));
        n();
        Handler handler = this.f197733e;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        Camera camera2 = this.f197732d;
        if (camera2 != null) {
            try {
                camera2.setPreviewCallbackWithBuffer(null);
                this.f197732d.stopPreview();
                this.P = null;
                SensorManager sensorManager = this.N;
                if (sensorManager != null) {
                    sensorManager.unregisterListener(this.R);
                }
            } catch (Exception e16) {
                QLog.i("AREngine_ARCamera", 1, "stopCamera fail.", e16);
            }
        }
    }

    public boolean G(boolean z16) {
        Camera camera2 = this.f197732d;
        if (camera2 == null) {
            return false;
        }
        try {
            Camera.Parameters parameters = camera2.getParameters();
            if (QLog.isColorLevel()) {
                QLog.d("AREngine_ARCamera", 2, String.format("switchFlashLight on=%s current=%s", Boolean.valueOf(z16), parameters.getFlashMode()));
            }
            if (z16) {
                parameters.setFlashMode("torch");
            } else {
                parameters.setFlashMode(DebugKt.DEBUG_PROPERTY_VALUE_OFF);
            }
            this.f197732d.setParameters(parameters);
            return true;
        } catch (Exception e16) {
            QLog.e("AREngine_ARCamera", 1, "switchFlashLight fail.", e16);
            return false;
        }
    }

    public void j(int i3, int i16) {
        QLog.i("AREngine_ARCamera", 1, String.format("autoFocus surfaceWidth=%s surfaceHeight=%s", Integer.valueOf(i3), Integer.valueOf(i16)));
        if (this.f197732d != null) {
            if (this.f197737m != i3 || this.C != i16) {
                Matrix matrix = new Matrix();
                matrix.setScale(1.0f, 1.0f);
                matrix.postRotate(90.0f);
                float f16 = i3;
                float f17 = i16;
                matrix.postScale(f16 / 2000.0f, f17 / 2000.0f);
                matrix.postTranslate(f16 / 2.0f, f17 / 2.0f);
                matrix.invert(this.E);
                this.f197737m = i3;
                this.C = i16;
            }
            Handler handler = this.f197733e;
            if (handler != null) {
                handler.removeMessages(100);
                this.f197733e.sendEmptyMessageDelayed(100, 500L);
            }
        }
    }

    public void k() {
        if (QLog.isColorLevel()) {
            QLog.d("AREngine_ARCamera", 2, String.format("autoZoom mZooming=%s", Boolean.valueOf(this.H)));
        }
        if (this.f197732d != null) {
            try {
                this.H = false;
                Handler handler = this.f197733e;
                if (handler != null) {
                    handler.removeMessages(102);
                    this.f197733e.removeMessages(101);
                }
                Camera.Parameters parameters = this.f197732d.getParameters();
                if (parameters.isZoomSupported()) {
                    int zoom = parameters.getZoom();
                    int i3 = this.F;
                    if (zoom == i3) {
                        I(zoom, this.G);
                    } else {
                        I(zoom, i3);
                    }
                    ScanEntranceReport.c().i();
                }
            } catch (Exception e16) {
                QLog.e("AREngine_ARCamera", 1, "autoZoom fail!", e16);
            }
        }
    }

    public void n() {
        Handler handler = this.f197733e;
        if (handler != null) {
            handler.removeMessages(100);
        }
    }

    @Override // android.hardware.Camera.AutoFocusCallback
    public void onAutoFocus(boolean z16, Camera camera2) {
        QLog.d("AREngine_ARCamera", 1, String.format("onAutoFocus success=%s", Boolean.valueOf(z16)));
        if (this.D) {
            try {
                this.f197732d.cancelAutoFocus();
                Camera.Parameters parameters = this.f197732d.getParameters();
                x1.a.f(parameters);
                this.f197732d.setParameters(parameters);
            } catch (Exception e16) {
                QLog.i("AREngine_ARCamera", 1, "focusOnArea fail.", e16);
            }
            b bVar = this.P;
            if (bVar != null) {
                bVar.r(z16);
            }
        }
        this.D = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean q() {
        Thread currentThread;
        long id5;
        QLog.i("AREngine_ARCamera", 1, String.format("closeCamera mCamera=%s", this.f197732d));
        Camera camera2 = this.f197732d;
        if (camera2 != null) {
            int i3 = -3;
            i3 = -3;
            Camera camera3 = null;
            camera3 = null;
            try {
                try {
                    camera2.release();
                    this.f197732d = null;
                    synchronized (U) {
                        V = -3;
                        currentThread = Thread.currentThread();
                        id5 = currentThread.getId();
                        W = id5;
                    }
                    i3 = currentThread;
                    camera3 = id5;
                } catch (Exception e16) {
                    QLog.i("AREngine_ARCamera", 1, "closeCamera fail.", e16);
                    this.f197732d = null;
                    synchronized (U) {
                        V = -3;
                        Thread currentThread2 = Thread.currentThread();
                        long id6 = currentThread2.getId();
                        W = id6;
                        i3 = currentThread2;
                        camera3 = id6;
                    }
                }
            } catch (Throwable th5) {
                this.f197732d = camera3;
                synchronized (U) {
                    V = i3;
                    W = Thread.currentThread().getId();
                    throw th5;
                }
            }
        }
        return true;
    }

    public boolean r(float f16, boolean z16) {
        int zoom;
        int i3;
        if (QLog.isColorLevel()) {
            QLog.d("AREngine_ARCamera", 2, String.format("directZoom scale=%.2f autoRevert=%s mZooming=%s", Float.valueOf(f16), Boolean.valueOf(z16), Boolean.valueOf(this.H)));
        }
        if (this.H) {
            this.H = false;
            Handler handler = this.f197733e;
            if (handler != null) {
                handler.removeMessages(102);
                this.f197733e.removeMessages(101);
            }
        }
        Camera camera2 = this.f197732d;
        if (camera2 != null && !this.H) {
            try {
                Camera.Parameters parameters = camera2.getParameters();
                List<Integer> zoomRatios = parameters.getZoomRatios();
                if (zoomRatios == null || zoomRatios.size() == 0 || (zoom = parameters.getZoom()) < 0) {
                    return false;
                }
                int i16 = -1;
                if (zoomRatios.size() > zoom) {
                    i3 = zoomRatios.get(zoom).intValue();
                } else {
                    i3 = -1;
                }
                int i17 = (int) (i3 * f16);
                if (i17 <= i3) {
                    return false;
                }
                int i18 = 0;
                int i19 = Integer.MAX_VALUE;
                int i26 = -1;
                for (int i27 = zoom; i27 < zoomRatios.size(); i27++) {
                    if (Math.abs(zoomRatios.get(i27).intValue() - i17) < i19 && zoomRatios.get(i27).intValue() < i17) {
                        int abs = Math.abs(zoomRatios.get(i27).intValue() - i17);
                        int intValue = zoomRatios.get(i27).intValue();
                        int i28 = i27 + 1;
                        if (i28 < zoomRatios.size()) {
                            i18 = zoomRatios.get(i28).intValue();
                        }
                        i19 = abs;
                        i26 = intValue;
                        i16 = i27;
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.i("AREngine_ARCamera", 2, String.format("directZoom [curZoomRatio,dstZoomRatio,index,cur,finalRatio,nextRatio]=[%d,%d,%d,%d,%d,%d]", Integer.valueOf(i3), Integer.valueOf(i17), Integer.valueOf(i16), Integer.valueOf(zoom), Integer.valueOf(i26), Integer.valueOf(i18)));
                }
                if (parameters.isZoomSupported() && i16 >= 0 && i16 != zoom) {
                    int max = Math.max(Math.min(i16, this.G), this.F);
                    if (max != zoom) {
                        parameters.setZoom(max);
                        this.f197732d.setParameters(parameters);
                        return true;
                    }
                    Handler handler2 = this.f197733e;
                    if (handler2 != null) {
                        handler2.removeMessages(101);
                        if (z16) {
                            this.f197733e.sendEmptyMessageDelayed(101, 5000L);
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public void t() {
        Handler handler = this.f197733e;
        if (handler != null) {
            handler.removeMessages(100);
            this.f197733e.sendEmptyMessageDelayed(100, 100L);
        }
    }

    public int u() {
        return this.f197736i;
    }

    public int v() {
        return this.f197735h;
    }

    public int w() {
        return this.f197734f;
    }

    public int x() {
        return ((this.L - this.M) + 360) % 360;
    }

    public void y(final int i3, final int i16, final int i17, final int i18) {
        QLog.i("AREngine_ARCamera", 1, String.format("manualFocus touchX=%s touchY=%s surfaceWidth=%s surfaceHeight=%s", Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18)));
        if (this.f197732d != null) {
            CameraProxy.v().F(new Runnable() { // from class: com.tencent.mobileqq.ar.arengine.ARCamera.1
                @Override // java.lang.Runnable
                public void run() {
                    ARCamera.this.s(i3, i16, i17, i18, ARCamera.S);
                }
            });
        }
    }

    public int z() {
        return A(0, 0L);
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a implements SensorEventListener {
        a() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0029, code lost:
        
            if (r3 < (-1.0d)) goto L7;
         */
        @Override // android.hardware.SensorEventListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onSensorChanged(SensorEvent sensorEvent) {
            if (1 != sensorEvent.sensor.getType()) {
                return;
            }
            float[] fArr = sensorEvent.values;
            float f16 = fArr[0];
            double sqrt = fArr[1] / Math.sqrt((f16 * f16) + (r6 * r6));
            double d16 = 1.0d;
            if (sqrt <= 1.0d) {
                d16 = -1.0d;
            }
            sqrt = d16;
            double acos = Math.acos(sqrt);
            if (f16 < 0.0f) {
                acos = 6.283185307179586d - acos;
            }
            ARCamera.this.M = ((((int) (acos * 57.29577951308232d)) + 45) / 90) * 90;
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i3) {
        }
    }
}
