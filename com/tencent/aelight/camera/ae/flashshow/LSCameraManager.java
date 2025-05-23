package com.tencent.aelight.camera.ae.flashshow;

import android.app.Activity;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.camera2.CameraCharacteristics;
import android.media.Image;
import android.os.Handler;
import android.provider.Settings;
import android.util.SizeF;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.aelight.camera.ae.camera.testpkg.VideoCameraProxy;
import com.tencent.aelight.camera.ae.flashshow.util.h;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.videocodec.audio.AudioCapture;
import com.tencent.qqcamerakit.capture.c;
import com.tencent.qqcamerakit.capture.cameraextend.a;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes32.dex */
public class LSCameraManager extends com.tencent.qqcamerakit.capture.b implements com.tencent.qqcamerakit.common.d {
    private int C;
    private String D;
    private boolean E;
    private xp.a F;
    private com.tencent.qqcamerakit.capture.cameraextend.a G;
    private boolean H;
    private boolean I;
    private View J;
    private int K;
    private int L;
    private boolean M;
    private h.a N;
    private boolean P;
    private com.tencent.aelight.camera.ae.flashshow.util.h Q;
    private int R;
    private int S;
    private AudioCapture T;
    private int U;
    private boolean V;
    private final AtomicInteger W;
    private volatile boolean X;
    private boolean Y;
    private int Z;

    /* renamed from: a0, reason: collision with root package name */
    private Object f63866a0;

    /* renamed from: d, reason: collision with root package name */
    private final Handler f63867d;

    /* renamed from: e, reason: collision with root package name */
    private a f63868e;

    /* renamed from: f, reason: collision with root package name */
    private final com.tencent.aelight.camera.ae.camera.testpkg.b f63869f;

    /* renamed from: h, reason: collision with root package name */
    private int f63870h;

    /* renamed from: i, reason: collision with root package name */
    private int f63871i;

    /* renamed from: m, reason: collision with root package name */
    private Matrix f63872m;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface a {
        void a();

        void onCameraPreviewSizeChanged(int i3, int i16);

        void onCameraPreviewStarted();

        void onCameraReadyToPreview();

        void onCameraStarted(boolean z16, String str);

        void onRetryOpenCamera();
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface b {
        void onOpenResult(int i3, boolean z16);
    }

    public LSCameraManager() {
        com.tencent.aelight.camera.ae.camera.testpkg.b aVar;
        if (com.tencent.aelight.camera.ae.flashshow.autotest.b.j()) {
            aVar = new VideoCameraProxy();
        } else {
            aVar = new com.tencent.aelight.camera.ae.camera.testpkg.a();
        }
        this.f63869f = aVar;
        this.f63872m = new Matrix();
        this.C = 0;
        this.D = "Xiaomi;Redmi Note 8 Pro";
        this.E = false;
        this.H = false;
        this.I = false;
        this.M = false;
        this.U = 1;
        this.V = false;
        this.W = new AtomicInteger(0);
        this.X = false;
        this.Y = false;
        this.Z = 0;
        this.f63866a0 = null;
        if (!com.tencent.aelight.camera.ae.flashshow.util.f.a()) {
            this.U = 2;
        }
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("AECameraManagerHandlerThread");
        baseHandlerThread.start();
        this.f63867d = new Handler(baseHandlerThread.getLooper());
        this.G = new com.tencent.qqcamerakit.capture.cameraextend.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isCameraCreated() {
        return this.W.get() >= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isCameraPreviewing() {
        return this.W.get() >= 3;
    }

    private void onCameraSizeSelected(com.tencent.qqcamerakit.capture.d dVar) {
        int i3 = dVar.f344912b;
        this.f63870h = i3;
        int i16 = dVar.f344911a;
        this.f63871i = i16;
        a aVar = this.f63868e;
        if (aVar != null) {
            aVar.onCameraPreviewSizeChanged(i3, i16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void realStartPreview(SurfaceTexture surfaceTexture, com.tencent.mobileqq.activity.richmedia.i iVar) {
        ms.a.f("LSCameraManager", "realStartPreview---ENTER, previewTexture=" + surfaceTexture + ", previewSize=" + iVar);
        this.W.set(3);
        this.F.n(iVar.f185860a);
        this.F.m(iVar.f185861b);
        this.f63869f.l(new com.tencent.qqcamerakit.capture.d(iVar.f185860a, iVar.f185861b), new com.tencent.qqcamerakit.capture.d(iVar.f185860a, iVar.f185861b), new com.tencent.qqcamerakit.capture.d(iVar.f185860a, iVar.f185861b), 30, "continuous-video", 3, 0);
        this.f63869f.r(surfaceTexture, this);
        this.W.set(4);
        a aVar = this.f63868e;
        if (aVar != null) {
            aVar.onCameraPreviewStarted();
        }
        ms.a.f("LSCameraManager", "realStartPreview---EXIT");
        tq.b.h().o("startCameraPreview-end");
    }

    private void setAeCaptureParam(xp.a aVar) {
        this.F = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopCameraInternal(boolean z16) {
        ms.a.f("LSCameraManager", "stopCameraInternal---ENTER, cameraCreated=" + isCameraCreated() + ", forceStop=" + z16);
        this.X = false;
        if (!z16 && !isCameraCreated()) {
            ms.a.c("LSCameraManager", "stopCameraInternal---EXIT, not created, do nothing");
            return;
        }
        this.f63869f.j(false);
        this.f63869f.a(false);
        this.W.set(0);
        AudioCapture audioCapture = this.T;
        if (audioCapture != null) {
            audioCapture.y();
        }
        this.f63869f.d(this);
        x(null);
        ms.a.f("LSCameraManager", "stopCameraInternal---EXIT, normally");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(b bVar) {
        ms.a.f("LSCameraManager", "openCameraInternal---cameraCreated=" + isCameraCreated());
        try {
            if (isCameraCreated()) {
                ms.a.c("LSCameraManager", "openCameraInternal---camera already created, recreate camera without close camera first");
                if (bVar != null) {
                    return;
                } else {
                    return;
                }
            }
            ms.a.f("LSCameraManager", "openCameraInternal---create camera: " + this.U + ", useWideAngleLens: " + this.V);
            this.f63869f.o(this);
            this.f63869f.h(this.U, this.V);
            this.W.set(2);
            ms.a.f("LSCameraManager", "openCameraInternal---cameraCreated normally");
            AECameraConstants.sCurrentCamera = this.U;
            tq.b.h().o("openCamera-end");
            if (bVar != null) {
                bVar.onOpenResult(this.U, isCameraCreated());
            }
        } finally {
            if (bVar != null) {
                bVar.onOpenResult(this.U, isCameraCreated());
            }
        }
    }

    public void cameraStopPreview() {
        this.f63867d.post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.LSCameraManager.7
            @Override // java.lang.Runnable
            public void run() {
                ms.a.f("LSCameraManager", "cameraStopPreview---ENTER");
                if (!LSCameraManager.this.isCameraPreviewing()) {
                    ms.a.c("LSCameraManager", "cameraStopPreview---EXIT, is not previewing");
                } else {
                    LSCameraManager.this.f63869f.j(false);
                    LSCameraManager.this.W.set(2);
                }
            }
        });
    }

    public void capturePhoto(final File file, int i3, final c.b bVar, final com.tencent.mobileqq.activity.richmedia.i iVar) {
        this.f63867d.post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.LSCameraManager.8
            @Override // java.lang.Runnable
            public void run() {
                LSCameraManager.this.f63869f.p(new com.tencent.qqcamerakit.capture.d(iVar.b(), iVar.a()), LSCameraManager.this.H, file.getPath(), LSCameraManager.this.C, bVar);
            }
        });
    }

    public int getActivityOrientation() {
        return this.C;
    }

    public float getHorizontalViewAngle() {
        if (this.f63866a0 == null) {
            this.f63866a0 = this.f63869f.g();
        }
        Object obj = this.f63866a0;
        if (obj instanceof CameraCharacteristics) {
            ms.a.f("LSCameraManager", "[CAMERA TYPE]:camera2");
            CameraCharacteristics cameraCharacteristics = (CameraCharacteristics) this.f63866a0;
            SizeF sizeF = (SizeF) cameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_PHYSICAL_SIZE);
            float[] fArr = (float[]) cameraCharacteristics.get(CameraCharacteristics.LENS_INFO_AVAILABLE_FOCAL_LENGTHS);
            if (fArr == null || fArr.length <= 0) {
                return -1.0f;
            }
            return (float) (((Math.atan(sizeF.getWidth() / (fArr[0] * 2.0f)) * 2.0d) * 180.0d) / 3.141592653589793d);
        }
        if (!(obj instanceof Camera.Parameters)) {
            return -1.0f;
        }
        ms.a.f("LSCameraManager", "[CAMERA TYPE]:camera1");
        return ((Camera.Parameters) this.f63866a0).getHorizontalViewAngle();
    }

    public int getSelectedCamera() {
        return this.U;
    }

    public void init(xp.a aVar) {
        this.Q = new com.tencent.aelight.camera.ae.flashshow.util.h();
        setAeCaptureParam(aVar);
        int e16 = aVar.e();
        this.U = e16;
        if (e16 != 1 || com.tencent.aelight.camera.ae.flashshow.util.f.a()) {
            return;
        }
        this.U = 2;
    }

    public boolean isFlashEnabled() {
        return this.I;
    }

    public boolean isFrontCamera() {
        return this.U == 1;
    }

    public boolean isSupportCamera2() {
        return com.tencent.qqcamerakit.capture.camerastrategy.a.f344888b;
    }

    @Override // com.tencent.qqcamerakit.common.d
    public void notify(int i3, int i16, String str, Object... objArr) {
        int i17;
        a aVar;
        a aVar2;
        tq.b.h().n("LSCameraManager", "\u3010CameraProxy notify\u3011eventId=" + i3 + ", args=" + Arrays.toString(objArr));
        if (i3 == 1) {
            if (i16 == 0) {
                this.X = true;
                a aVar3 = this.f63868e;
                if (aVar3 != null) {
                    aVar3.onCameraReadyToPreview();
                    ms.a.c("LSCameraManager", "\u3010Camera Open Success\u3011EVENT_CREATE_CAMERA:");
                    return;
                }
                return;
            }
            this.X = false;
            if (objArr != null && objArr.length != 0) {
                Object obj = objArr[0];
                if (!(obj instanceof String) || (aVar = this.f63868e) == null) {
                    return;
                }
                aVar.onCameraStarted(false, (String) obj);
                ms.a.c("LSCameraManager", "\u3010Camera Open Error\u3011EVENT_CREATE_CAMERA:" + objArr[0]);
                return;
            }
            ms.a.c("LSCameraManager", "[Performance2]\u3010Camera Open Error\u3011EVENT_CREATE_CAMERA:" + i16);
            a aVar4 = this.f63868e;
            if (aVar4 == null || (i17 = this.Z) >= 3) {
                return;
            }
            this.Z = i17 + 1;
            aVar4.onRetryOpenCamera();
            return;
        }
        if (i3 != 2) {
            if (i3 != 11) {
                return;
            }
            if (objArr != null && objArr.length <= 0) {
                ms.a.c("LSCameraManager", "onDispatchThreadException---" + i3 + "errorMsg" + str);
                return;
            }
            Exception exc = (Exception) objArr[0];
            if (exc != null) {
                ms.a.d("LSCameraManager", "onDispatchThreadException---" + exc.getMessage(), exc);
                return;
            }
            ms.a.c("LSCameraManager", "onDispatchThreadException---" + i3);
            return;
        }
        if (objArr != null && objArr.length != 0) {
            Object obj2 = objArr[0];
            if (obj2 instanceof com.tencent.qqcamerakit.capture.d) {
                onCameraSizeSelected((com.tencent.qqcamerakit.capture.d) obj2);
                a aVar5 = this.f63868e;
                if (aVar5 != null) {
                    aVar5.onCameraStarted(true, "");
                    ms.a.f("LSCameraManager", "\u3010Camera Open Success\u3011EVENT_SET_CAMERA_PARAM");
                }
                if (objArr.length >= 2) {
                    Object obj3 = objArr[1];
                    if (obj3 instanceof com.tencent.qqcamerakit.capture.d) {
                        com.tencent.qqcamerakit.capture.d dVar = (com.tencent.qqcamerakit.capture.d) obj3;
                        this.R = dVar.f344911a;
                        this.S = dVar.f344912b;
                        return;
                    }
                    return;
                }
                return;
            }
            if (!(obj2 instanceof String) || (aVar2 = this.f63868e) == null) {
                return;
            }
            aVar2.onCameraStarted(false, (String) obj2);
            ms.a.c("LSCameraManager", "\u3010Camera Open Error\u3011EVENT_SET_CAMERA_PARAM:" + objArr[0]);
            return;
        }
        ms.a.f("LSCameraManager", "\u3010Camera Open Success\u3011EVENT_SET_CAMERA_PARAM");
    }

    @Override // com.tencent.qqcamerakit.capture.b
    public void onPreviewFrame(byte[] bArr, Camera camera2) {
        int i3;
        if (!this.Y) {
            this.Y = true;
            a aVar = this.f63868e;
            if (aVar != null) {
                aVar.a();
            }
            tq.b.h().o("onCameraPreviewFrameData");
        }
        if (this.P) {
            int i16 = this.f63870h;
            int i17 = this.f63871i;
            int i18 = this.R;
            if (i18 > 0 && (i3 = this.S) > 0) {
                i17 = i18;
                i16 = i3;
            }
            this.Q.a(bArr, i16, i17, this.N);
        }
    }

    public void r(final int i3, final b bVar) {
        this.f63867d.post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.LSCameraManager.4
            @Override // java.lang.Runnable
            public void run() {
                ms.a.f("LSCameraManager", "[cameraManagerHandler] changeCamera " + i3);
                int i16 = i3;
                if (i16 != 2 && i16 != 1) {
                    ms.a.c("LSCameraManager", "[cameraManagerHandler] changeCamera invalid camera: " + i3);
                    bVar.onOpenResult(LSCameraManager.this.U, LSCameraManager.this.isCameraCreated());
                    return;
                }
                if (LSCameraManager.this.U != i3 && LSCameraManager.this.isCameraCreated()) {
                    ms.a.f("LSCameraManager", "[cameraManagerHandler] changeCamera, firstly close last camera: " + LSCameraManager.this.U);
                    LSCameraManager.this.stopCameraInternal(false);
                }
                LSCameraManager.this.U = i3;
                LSCameraManager.this.w(bVar);
            }
        });
    }

    public void refreshDarkModeTimer() {
        com.tencent.aelight.camera.ae.flashshow.util.h hVar = this.Q;
        if (hVar != null) {
            hVar.b();
        }
    }

    public void requestCameraFocus(final float f16, final float f17, final int i3, final int i16) {
        this.f63867d.post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.LSCameraManager.9

            /* compiled from: P */
            /* renamed from: com.tencent.aelight.camera.ae.flashshow.LSCameraManager$9$a */
            /* loaded from: classes32.dex */
            class a implements c.a {
                a() {
                }

                @Override // com.tencent.qqcamerakit.capture.c.a
                public void onAutoFocusCallback(boolean z16) {
                    if (ms.a.g()) {
                        ms.a.a("LSCameraManager", "onAutoFocusCallback single tap focus " + z16);
                    }
                    if (z16) {
                        LSCameraManager.this.H = true;
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                if (LSCameraManager.this.G == null) {
                    return;
                }
                a.C9360a c9360a = new a.C9360a();
                c9360a.f344870a = f16;
                c9360a.f344871b = f17;
                c9360a.f344872c = i3;
                c9360a.f344873d = i16;
                c9360a.f344874e = com.tencent.aelight.camera.ae.flashshow.util.g.e(LSCameraManager.this.C);
                LSCameraManager.this.f63869f.q(LSCameraManager.this.f63872m, new a(), c9360a.f344874e, c9360a.f344872c, c9360a.f344873d, c9360a.f344870a, c9360a.f344871b);
            }
        });
    }

    public void s(final int i3, final boolean z16, final b bVar) {
        this.f63867d.post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.LSCameraManager.5
            @Override // java.lang.Runnable
            public void run() {
                ms.a.f("LSCameraManager", "[cameraManagerHandler] changeCamera to " + i3 + ", useWideAngleLens: " + z16);
                int i16 = i3;
                if (i16 != 2 && i16 != 1) {
                    ms.a.c("LSCameraManager", "[cameraManagerHandler] changeCamera invalid camera: " + i3);
                    bVar.onOpenResult(LSCameraManager.this.U, LSCameraManager.this.isCameraCreated());
                    return;
                }
                if (LSCameraManager.this.U != i3 && LSCameraManager.this.isCameraCreated()) {
                    ms.a.f("LSCameraManager", "[cameraManagerHandler] changeCamera, firstly close last camera: " + LSCameraManager.this.U);
                    LSCameraManager.this.stopCameraInternal(false);
                }
                if (LSCameraManager.this.V != z16 && LSCameraManager.this.f63869f.n(i3) && LSCameraManager.this.isCameraCreated()) {
                    ms.a.f("LSCameraManager", "[cameraManagerHandler] changeCamera, firstly close last camera: " + LSCameraManager.this.U);
                    LSCameraManager.this.stopCameraInternal(false);
                }
                LSCameraManager.this.U = i3;
                LSCameraManager.this.V = z16;
                LSCameraManager.this.w(bVar);
            }
        });
    }

    public void setActivityOrientation(int i3) {
        this.C = i3;
    }

    public void setAudioCapture(AudioCapture audioCapture) {
        this.T = audioCapture;
    }

    public void setDarkModeChecker(com.tencent.aelight.camera.ae.flashshow.util.h hVar) {
        this.Q = hVar;
    }

    public void setDarkModeEnable(boolean z16) {
        this.P = z16;
    }

    public void setDarkModeListener(h.a aVar) {
        this.N = aVar;
    }

    public void setDynamicResolutionMode(boolean z16) {
        this.E = z16;
    }

    public void setFocusModeRecording() {
        this.f63867d.post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.LSCameraManager.13
            @Override // java.lang.Runnable
            public void run() {
                LSCameraManager.this.f63869f.b();
            }
        });
    }

    public void setFocusOperatorMatrix(int i3, int i16, int i17, int i18) {
        com.tencent.qqcamerakit.capture.cameraextend.a aVar = this.G;
        if (aVar != null) {
            this.f63872m = aVar.d(i16, i3, i17, i18, this.U);
        }
    }

    public void setZoom(final float f16) {
        this.f63867d.post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.LSCameraManager.11
            @Override // java.lang.Runnable
            public void run() {
                LSCameraManager.this.f63869f.setZoom(f16);
            }
        });
    }

    public void startCameraPreview(final SurfaceTexture surfaceTexture, final com.tencent.mobileqq.activity.richmedia.i iVar) {
        ms.a.f("LSCameraManager", "startCameraPreview ENTER---previewTexture=" + surfaceTexture + ", previewSize=" + iVar);
        if (surfaceTexture == null || iVar == null || Math.min(iVar.f185860a, iVar.f185861b) <= 0) {
            return;
        }
        tq.b.h().o("startCameraPreview-begin");
        this.f63867d.post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.LSCameraManager.6
            @Override // java.lang.Runnable
            public void run() {
                if (LSCameraManager.this.isCameraCreated()) {
                    if (!LSCameraManager.this.isCameraPreviewing()) {
                        if (LSCameraManager.this.X) {
                            LSCameraManager.this.realStartPreview(surfaceTexture, iVar);
                            return;
                        } else {
                            ms.a.c("LSCameraManager", "startCameraPreview EXIT: camera isCameraRealOpened false");
                            return;
                        }
                    }
                    ms.a.c("LSCameraManager", "startCameraPreview EXIT: camera is already previewing");
                    return;
                }
                ms.a.c("LSCameraManager", "startCameraPreview EXIT: camera NOT created");
            }
        });
    }

    public void stopCamera(final boolean z16) {
        this.f63867d.post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.LSCameraManager.2
            @Override // java.lang.Runnable
            public void run() {
                LSCameraManager.this.stopCameraInternal(z16);
            }
        });
    }

    public void stopRecordVideo() {
        this.f63867d.post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.LSCameraManager.10
            @Override // java.lang.Runnable
            public void run() {
                LSCameraManager.this.f63869f.e();
            }
        });
    }

    public void switchFlash(boolean z16) {
        this.I = z16;
        com.tencent.aelight.camera.ae.flashshow.util.a.d(z16);
    }

    public long t() {
        return this.f63869f.k();
    }

    public void turnFlash(Activity activity, boolean z16) {
        ms.a.a("LSCameraManager", "turnFlash" + z16 + " selectedCamera " + this.U);
        if (this.U == 1) {
            turnFrontFlash(activity, z16);
        } else {
            this.f63869f.f(z16);
        }
    }

    public int u() {
        return this.f63869f.c();
    }

    public void v(final b bVar) {
        tq.b.h().o("openCamera-begin");
        this.f63867d.post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.LSCameraManager.1
            @Override // java.lang.Runnable
            public void run() {
                LSCameraManager.this.w(bVar);
            }
        });
    }

    public void x(a aVar) {
        ms.a.f("LSCameraManager", "### setCameraManagerListener--- listener=" + aVar);
        this.f63868e = aVar;
    }

    public void y(final int i3, final long j3) {
        this.f63867d.post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.LSCameraManager.12
            @Override // java.lang.Runnable
            public void run() {
                LSCameraManager.this.f63869f.i(i3, j3);
            }
        });
    }

    public void z(final b bVar) {
        if (!com.tencent.aelight.camera.ae.flashshow.util.f.a()) {
            ms.a.c("LSCameraManager", "toggleCamera---front camera not exists, not support toggle");
            bVar.onOpenResult(this.U, false);
        } else {
            ms.a.f("LSCameraManager", "toggleCamera");
            this.f63867d.post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.LSCameraManager.3
                @Override // java.lang.Runnable
                public void run() {
                    LSCameraManager.this.stopCameraInternal(false);
                    if (LSCameraManager.this.U == 1) {
                        LSCameraManager.this.U = 2;
                    } else {
                        LSCameraManager.this.U = 1;
                    }
                    AECameraConstants.sCurrentCamera = LSCameraManager.this.U;
                    LSCameraManager.this.H = false;
                    QmcfManager.getInstance().setCameraMode(LSCameraManager.this.U);
                    LSCameraManager.this.w(bVar);
                }
            });
        }
    }

    private void turnFrontFlash(Activity activity, boolean z16) {
        boolean z17;
        if (activity == null) {
            View view = this.J;
            if (view == null || view.getParent() == null || z16) {
                return;
            }
            ((ViewGroup) this.J.getParent()).removeView(this.J);
            return;
        }
        if (Settings.System.canWrite(activity)) {
            z17 = true;
        } else {
            if (activity.checkSelfPermission("android.permission.SYSTEM_ALERT_WINDOW") == 0) {
                DialogUtil.showWriteSetting(activity, null, null);
            }
            z17 = false;
        }
        if (!z17) {
            ms.a.c("LSCameraManager", "can not grant permission");
            return;
        }
        if (z16) {
            if (this.J == null) {
                this.J = new View(activity);
            }
            this.J.setBackgroundColor(-1);
            this.J.setAlpha(0.7f);
            if (this.J.getParent() != null) {
                ((ViewGroup) this.J.getParent()).removeView(this.J);
            }
            activity.addContentView(this.J, new ViewGroup.LayoutParams(-1, -1));
            try {
                this.K = Settings.System.getInt(activity.getContentResolver(), "screen_brightness_mode");
                Settings.System.putInt(activity.getContentResolver(), "screen_brightness_mode", 0);
                this.L = Settings.System.getInt(activity.getContentResolver(), "screen_brightness");
                Settings.System.putInt(activity.getContentResolver(), "screen_brightness", 255);
                this.M = true;
                return;
            } catch (Exception e16) {
                this.K = 1;
                this.L = 100;
                if (ms.a.g()) {
                    ms.a.d("LSCameraManager", "turn FrontFlash Error ", e16);
                    e16.printStackTrace();
                    return;
                }
                return;
            }
        }
        if (this.M) {
            Settings.System.putInt(activity.getContentResolver(), "screen_brightness", this.L);
            Settings.System.putInt(activity.getContentResolver(), "screen_brightness_mode", this.K);
            this.M = false;
        }
        View view2 = this.J;
        if (view2 == null || view2.getParent() == null) {
            return;
        }
        ((ViewGroup) this.J.getParent()).removeView(this.J);
    }

    public void setSelectedCamera(final int i3) {
        if (i3 == 2 || i3 == 1) {
            if (i3 != 1 || com.tencent.aelight.camera.ae.flashshow.util.f.a()) {
                this.f63867d.post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.LSCameraManager.14
                    @Override // java.lang.Runnable
                    public void run() {
                        LSCameraManager.this.U = i3;
                    }
                });
            }
        }
    }

    @Override // com.tencent.qqcamerakit.capture.b
    public void onPreviewFrame(Image image) {
        int i3;
        super.onPreviewFrame(image);
        if (!this.Y) {
            this.Y = true;
            a aVar = this.f63868e;
            if (aVar != null) {
                aVar.a();
            }
            tq.b.h().o("onCameraPreviewFrameData");
        }
        ByteBuffer buffer = image.getPlanes()[0].getBuffer();
        byte[] bArr = new byte[buffer.remaining()];
        buffer.get(bArr);
        if (this.P) {
            int i16 = this.f63870h;
            int i17 = this.f63871i;
            int i18 = this.R;
            if (i18 > 0 && (i3 = this.S) > 0) {
                i17 = i18;
                i16 = i3;
            }
            this.Q.a(bArr, i16, i17, this.N);
        }
    }
}
