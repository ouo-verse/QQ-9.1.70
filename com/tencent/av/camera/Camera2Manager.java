package com.tencent.av.camera;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Surface;
import android.view.TextureView;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.qmethod.pandoraex.monitor.CameraMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.util.Collections;

/* compiled from: P */
/* loaded from: classes3.dex */
public class Camera2Manager implements com.tencent.av.camera.c {
    private CameraCaptureSession C;
    private CameraManager E;
    private AutoFitTextureView H;
    private Activity I;

    /* renamed from: f, reason: collision with root package name */
    private HandlerThread f73484f;

    /* renamed from: h, reason: collision with root package name */
    private Handler f73485h;

    /* renamed from: i, reason: collision with root package name */
    private Handler f73486i;

    /* renamed from: m, reason: collision with root package name */
    private CameraDevice f73487m;

    /* renamed from: d, reason: collision with root package name */
    private boolean f73482d = false;

    /* renamed from: e, reason: collision with root package name */
    private boolean f73483e = false;
    private String D = "";
    private String F = "1";
    private String G = "0";
    private boolean J = false;
    private final TextureView.SurfaceTextureListener K = new a();
    private final CameraDevice.StateCallback L = new b();
    private CameraCaptureSession.CaptureCallback M = new c();

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class b extends CameraDevice.StateCallback {
        b() {
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onDisconnected(CameraDevice cameraDevice) {
            cameraDevice.close();
            Camera2Manager.this.f73487m = null;
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onError(CameraDevice cameraDevice, int i3) {
            cameraDevice.close();
            Camera2Manager.this.f73487m = null;
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onOpened(CameraDevice cameraDevice) {
            Camera2Manager.this.f73487m = cameraDevice;
            Camera2Manager.this.z();
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class c extends CameraCaptureSession.CaptureCallback {
        c() {
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
            super.onCaptureCompleted(cameraCaptureSession, captureRequest, totalCaptureResult);
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureFailed(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureFailure captureFailure) {
            super.onCaptureFailed(cameraCaptureSession, captureRequest, captureFailure);
            QLog.e("camera2Manager", 1, "mPreviewCallback-->onCaptureFailed");
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureProgressed(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureResult captureResult) {
            super.onCaptureProgressed(cameraCaptureSession, captureRequest, captureResult);
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureSequenceAborted(CameraCaptureSession cameraCaptureSession, int i3) {
            super.onCaptureSequenceAborted(cameraCaptureSession, i3);
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureSequenceCompleted(CameraCaptureSession cameraCaptureSession, int i3, long j3) {
            super.onCaptureSequenceCompleted(cameraCaptureSession, i3, j3);
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureStarted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, long j3, long j16) {
            super.onCaptureStarted(cameraCaptureSession, captureRequest, j3, j16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class d extends CameraCaptureSession.StateCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CaptureRequest.Builder f73491a;

        d(CaptureRequest.Builder builder) {
            this.f73491a = builder;
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
            QLog.e("camera2Manager", 1, "onConfigureFailed failed");
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigured(CameraCaptureSession cameraCaptureSession) {
            if (Camera2Manager.this.f73487m == null) {
                return;
            }
            if (Camera2Manager.this.C != null) {
                Camera2Manager.this.C.close();
            }
            Camera2Manager.this.C = cameraCaptureSession;
            try {
                if (Camera2Manager.this.f73483e) {
                    this.f73491a.set(CaptureRequest.CONTROL_AF_MODE, 1);
                    this.f73491a.set(CaptureRequest.CONTROL_AF_TRIGGER, 1);
                    this.f73491a.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, 1);
                }
                if (Camera2Manager.this.f73482d) {
                    this.f73491a.set(CaptureRequest.CONTROL_AE_MODE, 2);
                }
                CaptureRequest build = this.f73491a.build();
                if (Camera2Manager.this.C != null) {
                    CameraMonitor.setRepeatingRequest(Camera2Manager.this.C, build, Camera2Manager.this.M, Camera2Manager.this.f73485h);
                }
            } catch (Exception e16) {
                QLog.e("camera2Manager", 1, "setRepeatingRequest failed" + e16.toString());
            }
        }
    }

    private void A() {
        new BaseThread(new Runnable() { // from class: com.tencent.av.camera.Camera2Manager.5
            @Override // java.lang.Runnable
            public void run() {
                boolean z16;
                try {
                    for (String str : Camera2Manager.this.E.getCameraIdList()) {
                        CameraCharacteristics cameraCharacteristics = Camera2Manager.this.E.getCameraCharacteristics(str);
                        if (((StreamConfigurationMap) cameraCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP)) != null) {
                            Camera2Manager.this.f73482d = ((Boolean) cameraCharacteristics.get(CameraCharacteristics.FLASH_INFO_AVAILABLE)).booleanValue();
                            QLog.d("camera2Manager", 1, str + "---\u95ea\u5149\u706f\u652f\u6301-->" + Camera2Manager.this.f73482d);
                            int[] iArr = (int[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES);
                            for (int i3 = 0; i3 < iArr.length; i3++) {
                                QLog.d("camera2Manager", 1, str + "---afModes-->" + iArr[i3]);
                                if (iArr[i3] == 4) {
                                    Camera2Manager.this.f73483e = true;
                                }
                            }
                            int[] iArr2 = (int[]) cameraCharacteristics.get(CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES);
                            int i16 = 0;
                            while (true) {
                                if (i16 < iArr2.length) {
                                    if (iArr2[i16] == 0) {
                                        z16 = true;
                                        break;
                                    }
                                    i16++;
                                } else {
                                    z16 = false;
                                    break;
                                }
                            }
                            if (z16) {
                                Integer num = (Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_FACING);
                                if (num != null && num.intValue() == 0) {
                                    Camera2Manager.this.F = str;
                                }
                                if (num != null && num.intValue() == 1) {
                                    Camera2Manager.this.G = str;
                                }
                            }
                            QLog.d("camera2Manager", 1, "check cameraId=" + str + " isColorAvailable=" + z16);
                        }
                    }
                    Camera2Manager camera2Manager = Camera2Manager.this;
                    camera2Manager.D = camera2Manager.F;
                    QLog.d("camera2Manager", 1, "---facing-->" + Camera2Manager.this.F + " " + Camera2Manager.this.G + " needOpenCamera:" + Camera2Manager.this.J);
                    if (Camera2Manager.this.J && !TextUtils.isEmpty(Camera2Manager.this.D)) {
                        Camera2Manager.this.C();
                        Camera2Manager.this.J = false;
                    }
                } catch (CameraAccessException e16) {
                    e16.printStackTrace();
                }
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(int i3, int i16) {
        if (x()) {
            this.E = (CameraManager) this.I.getSystemService("camera");
            A();
            try {
                C();
            } catch (CameraAccessException e16) {
                e16.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"MissingPermission"})
    public void C() throws CameraAccessException {
        if (!TextUtils.isEmpty(this.D)) {
            this.J = false;
            Handler handler = this.f73486i;
            if (handler != null) {
                try {
                    CameraMonitor.openCamera(this.E, this.D, this.L, handler);
                    QLog.d("camera2Manager", 1, "openCamera2 mCameraId: " + this.D);
                    return;
                } catch (Exception e16) {
                    QLog.d("camera2Manager", 1, "openCamera2 error: " + e16);
                    return;
                }
            }
            return;
        }
        this.J = true;
        QLog.d("camera2Manager", 1, "openCamera2 error: invalid camera id.");
    }

    private void D() {
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("CameraBackground");
        this.f73484f = baseHandlerThread;
        baseHandlerThread.start();
        this.f73485h = new Handler(this.f73484f.getLooper());
        this.f73486i = new Handler(Looper.getMainLooper());
    }

    private void F() {
        HandlerThread handlerThread = this.f73484f;
        if (handlerThread != null) {
            handlerThread.quitSafely();
        }
        try {
            Handler handler = this.f73485h;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            Handler handler2 = this.f73486i;
            if (handler2 != null) {
                handler2.removeCallbacksAndMessages(null);
            }
            HandlerThread handlerThread2 = this.f73484f;
            if (handlerThread2 != null) {
                handlerThread2.join();
                this.f73484f = null;
            }
            this.f73485h = null;
            this.f73486i = null;
        } catch (InterruptedException e16) {
            e16.printStackTrace();
        }
    }

    private boolean x() {
        if (this.I.checkSelfPermission(QQPermissionConstants.Permission.CAMERA) == 0) {
            return true;
        }
        return false;
    }

    private void y() {
        CameraCaptureSession cameraCaptureSession = this.C;
        if (cameraCaptureSession != null) {
            cameraCaptureSession.close();
            this.C = null;
        }
        CameraDevice cameraDevice = this.f73487m;
        if (cameraDevice != null) {
            cameraDevice.close();
            this.f73487m = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        SurfaceTexture surfaceTexture = this.H.getSurfaceTexture();
        if (surfaceTexture == null) {
            return;
        }
        try {
            surfaceTexture.setDefaultBufferSize(1280, 720);
            Surface surface = new Surface(surfaceTexture);
            CaptureRequest.Builder createCaptureRequest = CameraMonitor.createCaptureRequest(this.f73487m, 1);
            createCaptureRequest.addTarget(surface);
            this.f73487m.createCaptureSession(Collections.singletonList(surface), new d(createCaptureRequest), this.f73485h);
        } catch (Exception e16) {
            QLog.e("camera2Manager", 1, "createCameraPreviewSession failed: " + e16.toString());
        }
    }

    public void E() {
        D();
        if (this.H.isAvailable()) {
            B(this.H.getWidth(), this.H.getHeight());
        } else {
            this.H.setSurfaceTextureListener(this.K);
        }
    }

    @Override // com.tencent.av.camera.c
    public void a(AutoFitTextureView autoFitTextureView, Activity activity) {
        this.H = autoFitTextureView;
        this.I = activity;
        autoFitTextureView.setAspectRatio(720, 1280);
    }

    @Override // com.tencent.av.camera.c
    public void release() {
        y();
        F();
    }

    @Override // com.tencent.av.camera.c
    public void resume() {
        E();
    }

    @Override // com.tencent.av.camera.c
    public boolean switchCamera() {
        y();
        if (this.D.equals(this.F)) {
            this.D = this.G;
        } else if (this.D.equals(this.G)) {
            this.D = this.F;
        }
        try {
            C();
        } catch (CameraAccessException e16) {
            e16.printStackTrace();
        }
        return this.F.equals(this.D);
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a implements TextureView.SurfaceTextureListener {
        a() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i3, int i16) {
            Camera2Manager.this.B(i3, i16);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i3, int i16) {
        }
    }
}
