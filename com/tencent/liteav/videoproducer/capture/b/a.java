package com.tencent.liteav.videoproducer.capture.b;

import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.MeteringRectangle;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Range;
import android.view.Surface;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Size;
import com.tencent.liteav.base.util.g;
import com.tencent.liteav.base.util.k;
import com.tencent.liteav.base.util.q;
import com.tencent.liteav.videoproducer.capture.CameraCaptureParams;
import com.tencent.liteav.videoproducer.capture.CameraControllerInterface;
import com.tencent.liteav.videoproducer.capture.CameraEventCallback;
import com.tencent.qmethod.pandoraex.monitor.CameraMonitor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class a extends CameraControllerInterface {

    /* renamed from: c, reason: collision with root package name */
    private static boolean f119603c;
    private CameraEventCallback A;

    /* renamed from: g, reason: collision with root package name */
    private final q f119608g;

    /* renamed from: l, reason: collision with root package name */
    private CaptureRequest f119613l;

    /* renamed from: m, reason: collision with root package name */
    private CaptureRequest.Builder f119614m;

    /* renamed from: n, reason: collision with root package name */
    private Size f119615n;

    /* renamed from: r, reason: collision with root package name */
    private SurfaceTexture f119619r;

    /* renamed from: y, reason: collision with root package name */
    private CountDownLatch f119626y;

    /* renamed from: z, reason: collision with root package name */
    private CountDownLatch f119627z;

    /* renamed from: b, reason: collision with root package name */
    private static final HashMap<String, CameraCharacteristics> f119602b = new HashMap<>();

    /* renamed from: d, reason: collision with root package name */
    private static String f119604d = "";

    /* renamed from: e, reason: collision with root package name */
    private static String f119605e = "";

    /* renamed from: f, reason: collision with root package name */
    private final Handler f119607f = new Handler(Looper.getMainLooper());

    /* renamed from: h, reason: collision with root package name */
    private final AtomicBoolean f119609h = new AtomicBoolean(false);

    /* renamed from: i, reason: collision with root package name */
    private final AtomicReference<CameraDevice> f119610i = new AtomicReference<>();

    /* renamed from: j, reason: collision with root package name */
    private final AtomicBoolean f119611j = new AtomicBoolean(false);

    /* renamed from: k, reason: collision with root package name */
    private final AtomicReference<CameraCaptureSession> f119612k = new AtomicReference<>();

    /* renamed from: o, reason: collision with root package name */
    private k f119616o = k.NORMAL;

    /* renamed from: p, reason: collision with root package name */
    private k f119617p = null;

    /* renamed from: q, reason: collision with root package name */
    private boolean f119618q = true;

    /* renamed from: s, reason: collision with root package name */
    private boolean f119620s = true;

    /* renamed from: t, reason: collision with root package name */
    private boolean f119621t = true;

    /* renamed from: u, reason: collision with root package name */
    private boolean f119622u = true;

    /* renamed from: v, reason: collision with root package name */
    private int f119623v = -1;

    /* renamed from: w, reason: collision with root package name */
    private EnumC5953a f119624w = EnumC5953a.IDLE;

    /* renamed from: x, reason: collision with root package name */
    private boolean f119625x = false;

    /* renamed from: a, reason: collision with root package name */
    public boolean f119606a = false;
    private float B = 0.0f;
    private float C = 0.0f;
    private final CameraDevice.StateCallback D = new CameraDevice.StateCallback() { // from class: com.tencent.liteav.videoproducer.capture.b.a.1
        private void a(CameraDevice cameraDevice, int i3) {
            if (a.this.f119609h.get()) {
                a.b(a.this, i3);
            } else {
                a.this.a(false, cameraDevice);
            }
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public final void onClosed(CameraDevice cameraDevice) {
            LiteavLog.i("Camera2Controller", "CameraDevice onClosed!" + a(cameraDevice));
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public final void onDisconnected(CameraDevice cameraDevice) {
            LiteavLog.e("Camera2Controller", "CameraDevice onDisconnected!" + a(cameraDevice));
            a(cameraDevice, 1);
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public final void onError(CameraDevice cameraDevice, int i3) {
            LiteavLog.e("Camera2Controller", "CameraDevice onError!" + a(cameraDevice) + ", error:" + i3);
            int i16 = 3;
            if (i3 == 3) {
                i16 = 2;
            } else if (i3 == 1) {
                i16 = 1;
            } else if (i3 != 5) {
                i16 = 4;
                if (i3 != 4) {
                    i16 = 0;
                }
            }
            a(cameraDevice, i16);
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public final void onOpened(CameraDevice cameraDevice) {
            LiteavLog.i("Camera2Controller", "CameraDevice onOpen!" + a(cameraDevice));
            a.this.a(true, cameraDevice);
        }

        private static String a(CameraDevice cameraDevice) {
            if (cameraDevice == null) {
                return "null";
            }
            return "CameraDevice[id:" + cameraDevice.getId() + "]";
        }
    };
    private final CameraCaptureSession.StateCallback E = new CameraCaptureSession.StateCallback() { // from class: com.tencent.liteav.videoproducer.capture.b.a.2
        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public final void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
            LiteavLog.e("Camera2Controller", "CameraCaptureSession onConfigureFailed!");
            a.this.a(false, cameraCaptureSession);
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public final void onConfigured(CameraCaptureSession cameraCaptureSession) {
            LiteavLog.i("Camera2Controller", "CameraCaptureSession onConfigured!");
            a.this.a(true, cameraCaptureSession);
        }
    };
    private final CameraManager.AvailabilityCallback F = new CameraManager.AvailabilityCallback() { // from class: com.tencent.liteav.videoproducer.capture.b.a.3
        @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
        public final void onCameraAccessPrioritiesChanged() {
            super.onCameraAccessPrioritiesChanged();
        }

        @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
        public final void onCameraAvailable(String str) {
            super.onCameraAvailable(str);
            LiteavLog.i("Camera2Controller", "onCameraAvailable: ".concat(String.valueOf(str)));
            if (!a.this.f() && a.b(a.this.f119620s).equals(str) && a.this.f119609h.get()) {
                LiteavLog.w("Camera2Controller", "Current camera is available, it could be interrupted by system app.");
                a aVar = a.this;
                aVar.a(false, (CameraDevice) aVar.f119610i.get());
                a.b(a.this, 1);
            }
        }

        @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
        public final void onCameraUnavailable(String str) {
            super.onCameraUnavailable(str);
            LiteavLog.i("Camera2Controller", "onCameraUnavailable: ".concat(String.valueOf(str)));
        }
    };
    private final CameraCaptureSession.CaptureCallback G = new AnonymousClass4();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.liteav.videoproducer.capture.b.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public enum EnumC5953a {
        IDLE,
        PREVIEWING
    }

    public a(q qVar) {
        this.f119608g = qVar;
    }

    static /* synthetic */ boolean e(a aVar) {
        aVar.f119625x = false;
        return false;
    }

    @Override // com.tencent.liteav.videoproducer.capture.CameraControllerInterface
    public final void enableCameraFpsCorrectionLogic(boolean z16) {
        this.f119618q = z16;
        LiteavLog.i("Camera2Controller", "set enable camera fps correction logic value is: ".concat(String.valueOf(z16)));
    }

    @Override // com.tencent.liteav.videoproducer.capture.CameraControllerInterface
    public final void enableTapToFocus(boolean z16) {
        this.f119621t = z16;
        if (!this.f119625x) {
            c(z16);
            d();
        }
    }

    @Override // com.tencent.liteav.videoproducer.capture.CameraControllerInterface
    public final k getCameraSystemRotation() {
        return this.f119616o;
    }

    @Override // com.tencent.liteav.videoproducer.capture.CameraControllerInterface
    public final int getCameraSystemRotationValue() {
        return this.f119616o.mValue;
    }

    @Override // com.tencent.liteav.videoproducer.capture.CameraControllerInterface
    public final int getMaxZoom() {
        return 100;
    }

    @Override // com.tencent.liteav.videoproducer.capture.CameraControllerInterface
    public final Size getPreviewSize() {
        return this.f119615n;
    }

    @Override // com.tencent.liteav.videoproducer.capture.CameraControllerInterface
    public final boolean isCameraAutoFocusFaceModeSupported() {
        if (a() != null && ((Integer) a().get(CameraCharacteristics.STATISTICS_INFO_MAX_FACE_COUNT)).intValue() > 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.liteav.videoproducer.capture.CameraControllerInterface
    public final boolean isCameraFocusPositionInPreviewSupported() {
        if (a() != null && ((Integer) a().get(CameraCharacteristics.CONTROL_MAX_REGIONS_AF)).intValue() > 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.liteav.videoproducer.capture.CameraControllerInterface
    public final boolean isCurrentPreviewSizeAspectRatioMatch(int i3, int i16, boolean z16) {
        boolean z17;
        k kVar = this.f119617p;
        if (kVar == null) {
            kVar = this.f119616o;
        }
        Size a16 = com.tencent.liteav.videoproducer.capture.b.a(e(), kVar, i3, i16);
        boolean z18 = false;
        if (a16.getArea() > this.f119615n.getArea()) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (!z16 || Math.abs(a16.aspectRatio() - this.f119615n.aspectRatio()) <= 0.001d) {
            z18 = z17;
        }
        LiteavLog.i("Camera2Controller", "isCurrentPreviewSizeAspectRatioMatch:".concat(String.valueOf(z18)));
        return z18;
    }

    @Override // com.tencent.liteav.videoproducer.capture.CameraControllerInterface
    public final boolean isTorchSupported() {
        if (a() != null && ((Boolean) a().get(CameraCharacteristics.FLASH_INFO_AVAILABLE)).booleanValue()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.liteav.videoproducer.capture.CameraControllerInterface
    public final boolean isZoomSupported() {
        if (a() != null && ((Float) a().get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM)).floatValue() > 0.0f) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.liteav.videoproducer.capture.CameraControllerInterface
    public final void setCameraRotationCorrectionValue(int i3) {
        k kVar;
        if (k.b(i3)) {
            kVar = k.a(i3);
        } else {
            kVar = null;
        }
        this.f119617p = kVar;
        LiteavLog.i("Camera2Controller", "camera rotation correction is " + this.f119617p);
    }

    @Override // com.tencent.liteav.videoproducer.capture.CameraControllerInterface
    public final void setExposureCompensation(float f16) {
        this.B = f16;
        b(f16);
        d();
    }

    @Override // com.tencent.liteav.videoproducer.capture.CameraControllerInterface
    public final void setZoom(float f16) {
        this.C = f16;
        a(f16);
        d();
    }

    @Override // com.tencent.liteav.videoproducer.capture.CameraControllerInterface
    public final void startAutoFocusAtPosition(int i3, int i16) {
        double d16;
        double d17;
        if (this.f119621t && this.f119622u) {
            if (!f() && !this.f119625x) {
                CameraCaptureSession cameraCaptureSession = this.f119612k.get();
                if (cameraCaptureSession == null) {
                    LiteavLog.e("Camera2Controller", "CameraCaptureSession get fail");
                    return;
                }
                if (i3 >= 0) {
                    Size size = this.f119615n;
                    if (i3 < size.width && i16 >= 0 && i16 < size.height) {
                        LiteavLog.i("Camera2Controller", "Start auto focus at (%d, %d)", Integer.valueOf(i3), Integer.valueOf(i16));
                        double d18 = i3;
                        double d19 = i16;
                        Rect rect = (Rect) this.f119613l.get(CaptureRequest.SCALER_CROP_REGION);
                        if (rect == null) {
                            LiteavLog.e("Camera2Controller", "getMeteringRect can't get crop region");
                            rect = (Rect) a().get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
                        }
                        int width = rect.width();
                        int height = rect.height();
                        Size size2 = this.f119615n;
                        int i17 = size2.height;
                        int i18 = i17 * width;
                        int i19 = size2.width;
                        double d26 = 0.0d;
                        if (i18 > i19 * height) {
                            d16 = (height * 1.0d) / i17;
                            d17 = 0.0d;
                            d26 = (width - (i19 * d16)) / 2.0d;
                        } else {
                            d16 = (width * 1.0d) / i19;
                            d17 = (height - (i17 * d16)) / 2.0d;
                        }
                        double d27 = (d18 * d16) + d26 + rect.left;
                        double d28 = (d19 * d16) + d17 + rect.top;
                        Rect rect2 = new Rect();
                        rect2.left = g.a((int) (d27 - (rect.width() * 0.05d)), 0, rect.width());
                        rect2.right = g.a((int) (d27 + (rect.width() * 0.05d)), 0, rect.width());
                        rect2.top = g.a((int) (d28 - (rect.height() * 0.05d)), 0, rect.height());
                        rect2.bottom = g.a((int) (d28 + (rect.height() * 0.05d)), 0, rect.height());
                        try {
                            this.f119614m.set(CaptureRequest.CONTROL_AF_REGIONS, new MeteringRectangle[]{new MeteringRectangle(rect2, 1000)});
                            this.f119614m.set(CaptureRequest.CONTROL_AE_REGIONS, new MeteringRectangle[]{new MeteringRectangle(rect2, 1000)});
                            this.f119614m.set(CaptureRequest.CONTROL_AF_MODE, 1);
                            this.f119614m.set(CaptureRequest.CONTROL_AF_TRIGGER, 1);
                            this.f119614m.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, 1);
                            this.f119625x = true;
                            this.f119606a = false;
                            this.f119614m.setTag(this);
                            CameraMonitor.setRepeatingRequest(cameraCaptureSession, this.f119614m.build(), this.G, this.f119607f);
                            return;
                        } catch (Throwable th5) {
                            LiteavLog.e("Camera2Controller", "startAutoFocusAtPosition exception:".concat(String.valueOf(th5)));
                            return;
                        }
                    }
                }
                LiteavLog.w("Camera2Controller", "Start auto focus at (%d, %d) invalid ", Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            LiteavLog.e("Camera2Controller", "autoFocus not preview, mCameraStatus:" + this.f119624w + " mIsAutoFocusing:" + this.f119625x);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0120  */
    @Override // com.tencent.liteav.videoproducer.capture.CameraControllerInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean startCapture(CameraCaptureParams cameraCaptureParams, SurfaceTexture surfaceTexture, CameraEventCallback cameraEventCallback) {
        String str;
        boolean z16;
        this.A = cameraEventCallback;
        if (!f119603c) {
            try {
                CameraManager cameraManager = (CameraManager) ContextUtils.getApplicationContext().getSystemService("camera");
                for (String str2 : cameraManager.getCameraIdList()) {
                    CameraCharacteristics cameraCharacteristics = cameraManager.getCameraCharacteristics(str2);
                    Integer num = (Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_FACING);
                    if (num != null && num.intValue() == 0 && "1".equals(str2)) {
                        f119602b.put(str2, cameraCharacteristics);
                        f119605e = str2;
                    } else if (num != null && num.intValue() == 1 && "0".equals(str2)) {
                        f119602b.put(str2, cameraCharacteristics);
                        f119604d = str2;
                    }
                }
                LiteavLog.i("Camera2Controller", "initCamera2Ability front:" + f119605e + ", back:" + f119604d);
            } catch (Throwable th5) {
                f119605e = "1";
                LiteavLog.e("Camera2Controller", "initCamera2Ability exception!".concat(String.valueOf(th5)));
            }
            f119603c = true;
        }
        if (cameraCaptureParams != null && surfaceTexture != null) {
            EnumC5953a enumC5953a = this.f119624w;
            EnumC5953a enumC5953a2 = EnumC5953a.IDLE;
            if (enumC5953a != enumC5953a2) {
                LiteavLog.e("Camera2Controller", "it's capturing, you should Stop first.");
                return false;
            }
            this.f119619r = surfaceTexture;
            this.f119620s = cameraCaptureParams.f119574a.booleanValue();
            if (a() != null) {
                int[] iArr = (int[]) a().get(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES);
                if (iArr.length != 0 && (iArr.length != 1 || iArr[0] != 0)) {
                    z16 = true;
                    this.f119622u = z16;
                    ((CameraManager) ContextUtils.getApplicationContext().getSystemService("camera")).registerAvailabilityCallback(this.F, this.f119607f);
                    if (a(cameraCaptureParams.f119581c, cameraCaptureParams.f119582d)) {
                        LiteavLog.e("Camera2Controller", "openCamera failed.");
                        c();
                        this.f119624w = enumC5953a2;
                        return false;
                    }
                    if (!a(surfaceTexture)) {
                        LiteavLog.e("Camera2Controller", "startPreview failed.");
                        b();
                        this.f119624w = enumC5953a2;
                        return false;
                    }
                    this.f119614m.set(CaptureRequest.CONTROL_AE_MODE, 1);
                    int i3 = cameraCaptureParams.f119580b;
                    LiteavLog.i("Camera2Controller", "preferred fps: ".concat(String.valueOf(i3)));
                    Range range = new Range(Integer.valueOf(i3), Integer.valueOf(i3));
                    CameraCharacteristics a16 = a();
                    if (a16 == null) {
                        LiteavLog.e("Camera2Controller", "camera characteristics is null");
                    } else {
                        com.tencent.liteav.videoproducer.a.a a17 = com.tencent.liteav.videoproducer.capture.b.a(a((Range<Integer>[]) a16.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES)), i3, this.f119618q);
                        if (a17 != null) {
                            range = new Range(Integer.valueOf(a17.f119572a), Integer.valueOf(a17.f119573b));
                        }
                    }
                    LiteavLog.i("Camera2Controller", "get best matched fps range result is ".concat(String.valueOf(range)));
                    this.f119614m.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, range);
                    c(this.f119621t);
                    a(this.C);
                    b(this.B);
                    this.f119613l = this.f119614m.build();
                    d();
                    this.f119624w = EnumC5953a.PREVIEWING;
                    LiteavLog.i("Camera2Controller", "startCaptureInternal ok.");
                    return true;
                }
                StringBuilder sb5 = new StringBuilder("Current ");
                if (this.f119620s) {
                    str = "front camera ";
                } else {
                    str = "back camera ";
                }
                sb5.append(str);
                sb5.append(" is not support auto focus.");
                LiteavLog.w("Camera2Controller", sb5.toString());
            }
            z16 = false;
            this.f119622u = z16;
            ((CameraManager) ContextUtils.getApplicationContext().getSystemService("camera")).registerAvailabilityCallback(this.F, this.f119607f);
            if (a(cameraCaptureParams.f119581c, cameraCaptureParams.f119582d)) {
            }
        } else {
            LiteavLog.e("Camera2Controller", "captureParams or surfaceTexture is null");
            return false;
        }
    }

    @Override // com.tencent.liteav.videoproducer.capture.CameraControllerInterface
    public final void stopCapture() {
        CountDownLatch countDownLatch = this.f119626y;
        if (countDownLatch != null) {
            countDownLatch.countDown();
        }
        this.f119626y = null;
        CountDownLatch countDownLatch2 = this.f119627z;
        if (countDownLatch2 != null) {
            countDownLatch2.countDown();
        }
        this.f119627z = null;
        b();
        c();
        this.f119613l = null;
        this.f119606a = false;
        this.f119609h.set(false);
        this.f119619r = null;
        this.f119623v = -1;
        this.f119624w = EnumC5953a.IDLE;
        LiteavLog.i("Camera2Controller", "stopCapture success");
    }

    @Override // com.tencent.liteav.videoproducer.capture.CameraControllerInterface
    public final void turnOnTorch(boolean z16) {
        if (f()) {
            LiteavLog.e("Camera2Controller", "turnOnTorch error mCameraStatus:" + this.f119624w);
            return;
        }
        boolean z17 = true;
        if (z16 && this.f119623v != 2) {
            this.f119623v = 2;
        } else if (!z16) {
            this.f119623v = 0;
        } else {
            z17 = false;
        }
        LiteavLog.i("Camera2Controller", "turnOnTorch:" + z16 + ", mode:" + this.f119623v + ", updateView:" + z17);
        if (z17) {
            this.f119614m.set(CaptureRequest.FLASH_MODE, Integer.valueOf(this.f119623v));
            d();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.liteav.videoproducer.capture.b.a$4, reason: invalid class name */
    /* loaded from: classes7.dex */
    public final class AnonymousClass4 extends CameraCaptureSession.CaptureCallback {
        AnonymousClass4() {
        }

        private static boolean a(CaptureRequest captureRequest) {
            return (captureRequest.getTag() instanceof a) && !((a) captureRequest.getTag()).f119606a;
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public final void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
            a.this.f119608g.a(c.a(this, totalCaptureResult, captureRequest));
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public final void onCaptureFailed(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureFailure captureFailure) {
            LiteavLog.e("Camera2Controller", "onCaptureFailed failure reason:" + captureFailure.getReason());
            a.this.f119608g.a(d.a(this, captureRequest));
        }

        private void a(CaptureRequest captureRequest, boolean z16) {
            if (a.this.f()) {
                return;
            }
            a.e(a.this);
            try {
                a.this.f119614m.set(CaptureRequest.CONTROL_AF_TRIGGER, 2);
                a.this.f119614m.set(CaptureRequest.CONTROL_AE_MODE, 1);
                a.this.f119614m.set(CaptureRequest.CONTROL_AF_MODE, 3);
                a.this.d();
                if (captureRequest.getTag() instanceof a) {
                    a.a((a) captureRequest.getTag(), z16);
                }
            } catch (Throwable th5) {
                LiteavLog.e("Camera2Controller", "mAfCaptureCallback exception:".concat(String.valueOf(th5)));
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ void a(AnonymousClass4 anonymousClass4, CaptureRequest captureRequest) {
            if (!a(captureRequest)) {
                a.e(a.this);
            } else {
                anonymousClass4.a(captureRequest, false);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ void a(AnonymousClass4 anonymousClass4, TotalCaptureResult totalCaptureResult, CaptureRequest captureRequest) {
            if (!a(captureRequest)) {
                a.e(a.this);
                return;
            }
            Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_STATE);
            if (num == null) {
                LiteavLog.e("Camera2Controller", "handleCaptureCompleted get afState fail");
                anonymousClass4.a(captureRequest, false);
            } else if (4 == num.intValue() || 5 == num.intValue()) {
                anonymousClass4.a(captureRequest, true);
            }
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public final void onCaptureProgressed(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureResult captureResult) {
        }
    }

    private void b(float f16) {
        float f17;
        int i3;
        if (this.f119614m != null && a() != null) {
            Range range = (Range) a().get(CameraCharacteristics.CONTROL_AE_COMPENSATION_RANGE);
            int intValue = ((Integer) range.getLower()).intValue();
            int intValue2 = ((Integer) range.getUpper()).intValue();
            if (intValue == 0 && intValue2 == 0) {
                LiteavLog.i("Camera2Controller", "camera doesn't support exposure compensation");
                return;
            }
            float a16 = g.a(f16, -1.0f);
            if (a16 == 0.0f) {
                i3 = 0;
            } else {
                if (a16 > 0.0f) {
                    f17 = intValue2;
                } else {
                    a16 = Math.abs(a16);
                    f17 = intValue;
                }
                i3 = (int) (a16 * f17);
            }
            this.f119614m.set(CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, Integer.valueOf(g.a(i3, intValue, intValue2)));
            return;
        }
        LiteavLog.e("Camera2Controller", "setExposureCompensation fail, value:" + f16 + " mCameraStatus:" + this.f119624w);
    }

    private void c() {
        CameraDevice andSet = this.f119610i.getAndSet(null);
        if (andSet != null) {
            try {
                andSet.close();
            } catch (Throwable th5) {
                LiteavLog.e("Camera2Controller", "closeCamera fail, Exception:".concat(String.valueOf(th5)));
            }
        }
        ((CameraManager) ContextUtils.getApplicationContext().getSystemService("camera")).unregisterAvailabilityCallback(this.F);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        CaptureRequest.Builder builder;
        CameraCaptureSession cameraCaptureSession = this.f119612k.get();
        if (cameraCaptureSession == null || (builder = this.f119614m) == null) {
            return;
        }
        try {
            CameraMonitor.setRepeatingRequest(cameraCaptureSession, builder.build(), null, null);
        } catch (Throwable th5) {
            LiteavLog.e("Camera2Controller", "updatePreview exception:".concat(String.valueOf(th5)));
        }
    }

    private List<Size> e() {
        if (a() == null) {
            LiteavLog.e("Camera2Controller", "getPreviewSizes error, Characteristics is null");
            return null;
        }
        StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) a().get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        if (streamConfigurationMap == null) {
            LiteavLog.e("Camera2Controller", "getPreviewSizes map null");
            return null;
        }
        android.util.Size[] outputSizes = streamConfigurationMap.getOutputSizes(SurfaceTexture.class);
        if (outputSizes == null) {
            LiteavLog.e("Camera2Controller", "getPreviewSizes choices is null");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (android.util.Size size : outputSizes) {
            arrayList.add(new Size(size.getWidth(), size.getHeight()));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f() {
        return a() == null || this.f119614m == null || this.f119624w != EnumC5953a.PREVIEWING;
    }

    private void a(float f16) {
        if (this.f119614m != null && a() != null) {
            this.f119614m.set(CaptureRequest.SCALER_CROP_REGION, c(f16));
            return;
        }
        LiteavLog.e("Camera2Controller", "setZoom fail, scale:" + f16 + " mPreviewBuilder is null.");
    }

    private void c(boolean z16) {
        CaptureRequest.Builder builder = this.f119614m;
        if (builder == null) {
            return;
        }
        int i3 = z16 ? 1 : 3;
        builder.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(i3));
        LiteavLog.i("Camera2Controller", "setFocusModeWithoutUpdatePreview to ".concat(String.valueOf(i3)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(a aVar, int i3) {
        if (aVar.f()) {
            LiteavLog.e("Camera2Controller", "onCameraError, but camera is invalid, do not send camera error.");
            return;
        }
        CameraEventCallback cameraEventCallback = aVar.A;
        if (cameraEventCallback != null) {
            cameraEventCallback.onCameraError(aVar, i3);
        }
    }

    private Rect c(float f16) {
        Rect rect = (Rect) a().get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
        float floatValue = ((Float) a().get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM)).floatValue();
        float f17 = floatValue - 1.0f;
        float a16 = (g.a(f16, 0.0f) * f17) + 1.0f;
        int width = (int) (rect.width() / floatValue);
        int width2 = rect.width() - width;
        int height = rect.height() - ((int) (rect.height() / floatValue));
        float f18 = a16 - 1.0f;
        int i3 = (int) (((width2 * f18) / f17) / 2.0f);
        int i16 = (int) (((height * f18) / f17) / 2.0f);
        Rect rect2 = new Rect(i3, i16, rect.width() - i3, rect.height() - i16);
        LiteavLog.i("Camera2Controller", "calculateZoomRect calculatedZoomLevel:" + a16 + " rect:" + rect + " newRect2:" + rect2);
        return rect2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z16, CameraDevice cameraDevice) {
        CountDownLatch countDownLatch = this.f119626y;
        this.f119609h.set(z16);
        this.f119610i.set(cameraDevice);
        if (countDownLatch != null) {
            countDownLatch.countDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(boolean z16) {
        return z16 ? !TextUtils.isEmpty(f119605e) ? f119605e : f119604d : !TextUtils.isEmpty(f119604d) ? f119604d : f119605e;
    }

    private void b() {
        CameraCaptureSession andSet = this.f119612k.getAndSet(null);
        if (andSet != null) {
            try {
                andSet.close();
            } catch (Throwable th5) {
                LiteavLog.e("Camera2Controller", "closePreviewSession fail, Exception:".concat(String.valueOf(th5)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z16, CameraCaptureSession cameraCaptureSession) {
        CountDownLatch countDownLatch = this.f119627z;
        this.f119611j.set(z16);
        this.f119612k.set(cameraCaptureSession);
        if (countDownLatch != null) {
            countDownLatch.countDown();
        }
    }

    static /* synthetic */ void b(a aVar, int i3) {
        aVar.f119608g.a(b.a(aVar, i3));
    }

    private CameraCharacteristics a() {
        String b16 = b(this.f119620s);
        if (TextUtils.isEmpty(b16)) {
            return null;
        }
        return f119602b.get(b16);
    }

    private boolean a(int i3, int i16) {
        String b16 = b(this.f119620s);
        if (a() == null) {
            LiteavLog.e("Camera2Controller", "openCamera fail getCameraCharacteristics null");
            return false;
        }
        k a16 = k.a(((Integer) a().get(CameraCharacteristics.SENSOR_ORIENTATION)).intValue());
        this.f119616o = a16;
        k kVar = this.f119617p;
        if (kVar != null) {
            a16 = kVar;
        }
        this.f119615n = com.tencent.liteav.videoproducer.capture.b.a(e(), a16, i3, i16);
        StringBuilder sb5 = new StringBuilder("openCamera ,id:");
        sb5.append(b16);
        sb5.append(",");
        sb5.append(this.f119620s ? "front camera" : "back camera");
        sb5.append(" mPreviewSize ");
        sb5.append(this.f119615n);
        sb5.append(" cameraRotation ");
        sb5.append(a16);
        sb5.append(" mIsCameraSupportAutoFocus ");
        sb5.append(this.f119622u);
        LiteavLog.i("Camera2Controller", sb5.toString());
        try {
            this.f119626y = new CountDownLatch(1);
            CameraMonitor.openCamera((CameraManager) ContextUtils.getApplicationContext().getSystemService("camera"), b16, this.D, this.f119607f);
            this.f119626y.await();
        } catch (Throwable th5) {
            LiteavLog.e("Camera2Controller", "openCamera exception:".concat(String.valueOf(th5)));
            a(false, (CameraDevice) null);
        }
        return this.f119609h.get();
    }

    private boolean a(SurfaceTexture surfaceTexture) {
        CameraDevice cameraDevice;
        try {
            cameraDevice = this.f119610i.get();
        } catch (Throwable th5) {
            LiteavLog.e("Camera2Controller", "startPreview exception", th5);
            a(false, (CameraCaptureSession) null);
        }
        if (cameraDevice != null && surfaceTexture != null) {
            b();
            SurfaceTexture surfaceTexture2 = this.f119619r;
            Size size = this.f119615n;
            surfaceTexture2.setDefaultBufferSize(size.width, size.height);
            Surface surface = new Surface(this.f119619r);
            CaptureRequest.Builder createCaptureRequest = CameraMonitor.createCaptureRequest(cameraDevice, 3);
            this.f119614m = createCaptureRequest;
            createCaptureRequest.addTarget(surface);
            List<Surface> singletonList = Collections.singletonList(surface);
            this.f119627z = new CountDownLatch(1);
            cameraDevice.createCaptureSession(singletonList, this.E, this.f119607f);
            this.f119627z.await();
            return this.f119611j.get();
        }
        throw new IOException("startPreview cameraDevice null!");
    }

    private static com.tencent.liteav.videoproducer.a.a[] a(Range<Integer>[] rangeArr) {
        if (rangeArr == null || rangeArr.length <= 0) {
            return new com.tencent.liteav.videoproducer.a.a[0];
        }
        com.tencent.liteav.videoproducer.a.a[] aVarArr = new com.tencent.liteav.videoproducer.a.a[rangeArr.length];
        for (int i3 = 0; i3 < rangeArr.length; i3++) {
            aVarArr[i3] = new com.tencent.liteav.videoproducer.a.a(rangeArr[i3].getLower().intValue(), rangeArr[i3].getUpper().intValue());
        }
        return aVarArr;
    }

    static /* synthetic */ void a(a aVar, boolean z16) {
        LiteavLog.i("Camera2Controller", "onFocusCallback success:".concat(String.valueOf(z16)));
        aVar.f119606a = true;
        boolean z17 = aVar.f119621t;
        if (z17) {
            return;
        }
        aVar.c(z17);
        aVar.d();
    }
}
