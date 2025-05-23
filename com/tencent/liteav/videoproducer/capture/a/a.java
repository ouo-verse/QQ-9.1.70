package com.tencent.liteav.videoproducer.capture.a;

import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Size;
import com.tencent.liteav.base.util.g;
import com.tencent.liteav.base.util.k;
import com.tencent.liteav.videoproducer.capture.CameraCaptureParams;
import com.tencent.liteav.videoproducer.capture.CameraControllerInterface;
import com.tencent.liteav.videoproducer.capture.CameraEventCallback;
import com.tencent.qmethod.pandoraex.monitor.CameraMonitor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlinx.coroutines.DebugKt;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class a extends CameraControllerInterface implements Camera.ErrorCallback {

    /* renamed from: b, reason: collision with root package name */
    private Camera f119585b;

    /* renamed from: f, reason: collision with root package name */
    private SurfaceTexture f119589f;

    /* renamed from: g, reason: collision with root package name */
    private Size f119590g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f119591h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f119592i;

    /* renamed from: l, reason: collision with root package name */
    private CameraEventCallback f119595l;

    /* renamed from: n, reason: collision with root package name */
    private float f119597n;

    /* renamed from: a, reason: collision with root package name */
    private boolean f119584a = true;

    /* renamed from: c, reason: collision with root package name */
    private k f119586c = k.NORMAL;

    /* renamed from: d, reason: collision with root package name */
    private k f119587d = null;

    /* renamed from: e, reason: collision with root package name */
    private boolean f119588e = true;

    /* renamed from: j, reason: collision with root package name */
    private boolean f119593j = true;

    /* renamed from: k, reason: collision with root package name */
    private int f119594k = 0;

    /* renamed from: m, reason: collision with root package name */
    private boolean f119596m = false;

    /* renamed from: o, reason: collision with root package name */
    private boolean f119598o = false;

    /* renamed from: p, reason: collision with root package name */
    private float f119599p = 0.0f;

    /* renamed from: q, reason: collision with root package name */
    private final Camera.AutoFocusCallback f119600q = b.a();

    @Override // com.tencent.liteav.videoproducer.capture.CameraControllerInterface
    public final void enableCameraFpsCorrectionLogic(boolean z16) {
        this.f119588e = z16;
        LiteavLog.i("CameraController", "set enable camera fps correction logic value is:".concat(String.valueOf(z16)));
    }

    @Override // com.tencent.liteav.videoproducer.capture.CameraControllerInterface
    public final void enableTapToFocus(boolean z16) {
        Camera.Parameters a16;
        this.f119593j = z16;
        if (this.f119585b == null || (a16 = a()) == null) {
            return;
        }
        try {
            a(a16, z16);
            this.f119585b.setParameters(a16);
        } catch (Throwable th5) {
            LiteavLog.e("CameraController", "enableTapToFocus failed.", th5);
        }
    }

    @Override // com.tencent.liteav.videoproducer.capture.CameraControllerInterface
    public final k getCameraSystemRotation() {
        return this.f119586c;
    }

    @Override // com.tencent.liteav.videoproducer.capture.CameraControllerInterface
    public final int getCameraSystemRotationValue() {
        return this.f119586c.mValue;
    }

    @Override // com.tencent.liteav.videoproducer.capture.CameraControllerInterface
    public final int getMaxZoom() {
        int i3 = this.f119594k;
        if (i3 != 0) {
            return i3;
        }
        if (this.f119585b != null) {
            Camera.Parameters a16 = a();
            if (a16 == null) {
                return this.f119594k;
            }
            if (a16.getMaxZoom() > 0 && a16.isZoomSupported()) {
                this.f119594k = a16.getMaxZoom();
            }
        }
        return this.f119594k;
    }

    @Override // com.tencent.liteav.videoproducer.capture.CameraControllerInterface
    public final Size getPreviewSize() {
        return this.f119590g;
    }

    @Override // com.tencent.liteav.videoproducer.capture.CameraControllerInterface
    public final boolean isCameraAutoFocusFaceModeSupported() {
        Camera.Parameters a16;
        if (this.f119585b == null || (a16 = a()) == null || a16.getMaxNumDetectedFaces() <= 0) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.liteav.videoproducer.capture.CameraControllerInterface
    public final boolean isCameraFocusPositionInPreviewSupported() {
        return this.f119591h;
    }

    @Override // com.tencent.liteav.videoproducer.capture.CameraControllerInterface
    public final boolean isCurrentPreviewSizeAspectRatioMatch(int i3, int i16, boolean z16) {
        boolean z17 = true;
        if (this.f119585b != null) {
            Camera.Parameters a16 = a();
            if (a16 == null) {
                return true;
            }
            k kVar = this.f119587d;
            if (kVar == null) {
                kVar = this.f119586c;
            }
            Size a17 = a(a16, kVar, i3, i16);
            if (a17 != null) {
                int i17 = a17.width * a17.height;
                Size size = this.f119590g;
                if (i17 > size.height * size.width) {
                    z17 = false;
                }
                if (z16 && Math.abs(a17.aspectRatio() - this.f119590g.aspectRatio()) > 0.001d) {
                    z17 = false;
                }
            }
        }
        LiteavLog.i("CameraController", "isCurrentPreviewSizeAspectRatioMatch : ".concat(String.valueOf(z17)));
        return z17;
    }

    @Override // com.tencent.liteav.videoproducer.capture.CameraControllerInterface
    public final boolean isTorchSupported() {
        Camera.Parameters a16;
        List<String> supportedFlashModes;
        if (this.f119585b == null || (a16 = a()) == null || (supportedFlashModes = a16.getSupportedFlashModes()) == null || !supportedFlashModes.contains("torch")) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.liteav.videoproducer.capture.CameraControllerInterface
    public final boolean isZoomSupported() {
        Camera.Parameters a16;
        if (this.f119585b == null || (a16 = a()) == null || a16.getMaxZoom() <= 0 || !a16.isZoomSupported()) {
            return false;
        }
        return true;
    }

    @Override // android.hardware.Camera.ErrorCallback
    public final void onError(int i3, Camera camera2) {
        LiteavLog.e("CameraController", "onError, error:".concat(String.valueOf(i3)));
        int i16 = 1;
        if (i3 == 1 || i3 == 2 || i3 == 100) {
            if (i3 != 2) {
                if (i3 == 100) {
                    i16 = 3;
                } else {
                    i16 = 0;
                }
            }
            CameraEventCallback cameraEventCallback = this.f119595l;
            if (cameraEventCallback != null) {
                cameraEventCallback.onCameraError(this, i16);
            }
        }
    }

    @Override // com.tencent.liteav.videoproducer.capture.CameraControllerInterface
    public final void setCameraRotationCorrectionValue(int i3) {
        k kVar;
        if (k.b(i3)) {
            kVar = k.a(i3);
        } else {
            kVar = null;
        }
        this.f119587d = kVar;
        LiteavLog.i("CameraController", "camera rotation correction is " + this.f119587d);
    }

    @Override // com.tencent.liteav.videoproducer.capture.CameraControllerInterface
    public final void setExposureCompensation(float f16) {
        this.f119597n = f16;
        this.f119596m = true;
        if (this.f119585b == null) {
            return;
        }
        this.f119596m = false;
        Camera.Parameters a16 = a();
        if (a16 == null) {
            return;
        }
        a16.setExposureCompensation(a(a16, f16));
        try {
            this.f119585b.setParameters(a16);
        } catch (Throwable th5) {
            LiteavLog.e("CameraController", "set exposure compensation failed.", th5);
        }
    }

    @Override // com.tencent.liteav.videoproducer.capture.CameraControllerInterface
    public final void setZoom(float f16) {
        this.f119599p = f16;
        this.f119598o = true;
        if (this.f119585b == null) {
            return;
        }
        this.f119598o = false;
        Camera.Parameters a16 = a();
        if (a16 == null) {
            return;
        }
        if (a16.getMaxZoom() > 0 && a16.isZoomSupported()) {
            int maxZoom = a16.getMaxZoom();
            try {
                a16.setZoom(g.a(Math.round(f16 * maxZoom), 0, maxZoom));
                this.f119585b.setParameters(a16);
                return;
            } catch (Throwable th5) {
                LiteavLog.e("CameraController", "set zoom failed.", th5);
                return;
            }
        }
        LiteavLog.i("CameraController", "camera doesn't support zoom!");
    }

    @Override // com.tencent.liteav.videoproducer.capture.CameraControllerInterface
    public final void startAutoFocusAtPosition(int i3, int i16) {
        if (this.f119593j && this.f119585b != null) {
            if (i3 >= 0) {
                Size size = this.f119590g;
                if (i3 < size.width && i16 >= 0 && i16 < size.height) {
                    LiteavLog.i("CameraController", "Start auto focus at (%d, %d)", Integer.valueOf(i3), Integer.valueOf(i16));
                    try {
                        this.f119585b.cancelAutoFocus();
                        Camera.Parameters a16 = a();
                        if (a16 == null) {
                            return;
                        }
                        if (this.f119591h) {
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(new Camera.Area(a(i3, i16, 2.0f), 1000));
                            a16.setFocusAreas(arrayList);
                        }
                        if (this.f119592i) {
                            ArrayList arrayList2 = new ArrayList();
                            arrayList2.add(new Camera.Area(a(i3, i16, 3.0f), 1000));
                            a16.setMeteringAreas(arrayList2);
                        }
                        try {
                            this.f119585b.setParameters(a16);
                            this.f119585b.autoFocus(this.f119600q);
                            return;
                        } catch (Throwable th5) {
                            LiteavLog.e("CameraController", "auto focus failed.", th5);
                            return;
                        }
                    } catch (Throwable th6) {
                        LiteavLog.e("CameraController", "cancel auto focus failed.", th6);
                        return;
                    }
                }
            }
            LiteavLog.w("CameraController", "Start auto focus at (%d, %d) invalid ", Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0138 A[Catch: all -> 0x0170, TryCatch #0 {all -> 0x0170, blocks: (B:5:0x000d, B:7:0x0011, B:10:0x0019, B:13:0x0045, B:16:0x0074, B:19:0x007f, B:21:0x008a, B:23:0x0094, B:25:0x009a, B:26:0x00ad, B:28:0x00b1, B:29:0x00bc, B:31:0x00da, B:32:0x0125, B:33:0x012e, B:35:0x0138, B:36:0x014f, B:38:0x0146, B:39:0x00eb, B:41:0x010d, B:43:0x011d, B:46:0x0167, B:47:0x016f), top: B:2:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0146 A[Catch: all -> 0x0170, TryCatch #0 {all -> 0x0170, blocks: (B:5:0x000d, B:7:0x0011, B:10:0x0019, B:13:0x0045, B:16:0x0074, B:19:0x007f, B:21:0x008a, B:23:0x0094, B:25:0x009a, B:26:0x00ad, B:28:0x00b1, B:29:0x00bc, B:31:0x00da, B:32:0x0125, B:33:0x012e, B:35:0x0138, B:36:0x014f, B:38:0x0146, B:39:0x00eb, B:41:0x010d, B:43:0x011d, B:46:0x0167, B:47:0x016f), top: B:2:0x0009 }] */
    @Override // com.tencent.liteav.videoproducer.capture.CameraControllerInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean startCapture(CameraCaptureParams cameraCaptureParams, SurfaceTexture surfaceTexture, CameraEventCallback cameraEventCallback) {
        boolean z16;
        boolean z17;
        this.f119595l = cameraEventCallback;
        try {
            if (cameraCaptureParams != null && surfaceTexture != null) {
                if (this.f119585b != null) {
                    LiteavLog.e("CameraController", "it's capturing, you should Stop first.");
                    return false;
                }
                this.f119589f = surfaceTexture;
                Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                int a16 = a(cameraCaptureParams.f119574a.booleanValue(), cameraInfo);
                this.f119584a = cameraCaptureParams.f119574a.booleanValue();
                this.f119585b = CameraMonitor.open(a16);
                k a17 = k.a(cameraInfo.orientation);
                this.f119586c = a17;
                k kVar = this.f119587d;
                if (kVar != null) {
                    a17 = kVar;
                }
                LiteavLog.i("CameraController", "open camera id: %d, isFrontCamera: %b, camera rotation: %s, camera info orientation: %d", Integer.valueOf(a16), cameraCaptureParams.f119574a, a17, Integer.valueOf(cameraInfo.orientation));
                Camera.Parameters parameters = this.f119585b.getParameters();
                if (parameters.getMaxNumFocusAreas() > 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                this.f119591h = z16;
                if (parameters.getMaxNumMeteringAreas() > 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                this.f119592i = z17;
                a(parameters, this.f119593j);
                if (this.f119598o) {
                    this.f119598o = false;
                    int maxZoom = parameters.getMaxZoom();
                    this.f119594k = maxZoom;
                    if (maxZoom > 0 && parameters.isZoomSupported()) {
                        parameters.setZoom(g.a(Math.round(this.f119599p * this.f119594k), 0, this.f119594k));
                    }
                }
                if (this.f119596m) {
                    this.f119596m = false;
                    parameters.setExposureCompensation(a(parameters, this.f119597n));
                }
                Size a18 = a(parameters, a17, cameraCaptureParams.f119581c, cameraCaptureParams.f119582d);
                this.f119590g = a18;
                parameters.setPreviewSize(a18.width, a18.height);
                if (LiteavSystemInfo.getModel().equalsIgnoreCase("aiv8167sm3_bsp")) {
                    LiteavLog.i("CameraController", "Model equals dingdang, setPreviewFrameRate: %d", Integer.valueOf(cameraCaptureParams.f119580b));
                } else {
                    int i3 = cameraCaptureParams.f119580b * 1000;
                    LiteavLog.i("CameraController", "preferred fps: ".concat(String.valueOf(i3)));
                    com.tencent.liteav.videoproducer.a.a a19 = com.tencent.liteav.videoproducer.capture.b.a(a(parameters.getSupportedPreviewFpsRange()), i3, this.f119588e);
                    if (a19 != null) {
                        LiteavLog.i("CameraController", "choosed fps range: ".concat(String.valueOf(a19)));
                    }
                    if (a19 != null) {
                        parameters.setPreviewFpsRange(a19.f119572a, a19.f119573b);
                        parameters.setWhiteBalance("auto");
                        parameters.setSceneMode("auto");
                        if (cameraInfo.facing != 1) {
                            this.f119585b.setDisplayOrientation((360 - this.f119586c.mValue) % 360);
                        } else {
                            this.f119585b.setDisplayOrientation(this.f119586c.mValue);
                        }
                        this.f119585b.setParameters(parameters);
                        this.f119585b.setErrorCallback(this);
                        this.f119585b.setPreviewTexture(this.f119589f);
                        this.f119585b.startPreview();
                        return true;
                    }
                }
                parameters.setPreviewFrameRate(a(cameraCaptureParams.f119580b));
                parameters.setWhiteBalance("auto");
                parameters.setSceneMode("auto");
                if (cameraInfo.facing != 1) {
                }
                this.f119585b.setParameters(parameters);
                this.f119585b.setErrorCallback(this);
                this.f119585b.setPreviewTexture(this.f119589f);
                this.f119585b.startPreview();
                return true;
            }
            throw new IOException("captureParams or surfaceTexture is null");
        } catch (Throwable th5) {
            LiteavLog.e("CameraController", "open camera1 fail, Exception:".concat(String.valueOf(th5)));
            return false;
        }
    }

    @Override // com.tencent.liteav.videoproducer.capture.CameraControllerInterface
    public final void stopCapture() {
        LiteavLog.i("CameraController", "stopCapture");
        try {
            Camera camera2 = this.f119585b;
            if (camera2 != null) {
                camera2.setErrorCallback(null);
                this.f119585b.stopPreview();
                this.f119585b.release();
                this.f119585b = null;
            }
        } catch (Throwable th5) {
            LiteavLog.e("CameraController", "closeCamera fail, Exception:".concat(String.valueOf(th5)));
        }
        this.f119589f = null;
    }

    @Override // com.tencent.liteav.videoproducer.capture.CameraControllerInterface
    public final void turnOnTorch(boolean z16) {
        String str;
        List<String> supportedFlashModes;
        if (this.f119585b == null) {
            return;
        }
        if (z16) {
            str = "torch";
        } else {
            str = DebugKt.DEBUG_PROPERTY_VALUE_OFF;
        }
        Camera.Parameters a16 = a();
        if (a16 != null && (supportedFlashModes = a16.getSupportedFlashModes()) != null && supportedFlashModes.contains(str)) {
            try {
                a16.setFlashMode(str);
                this.f119585b.setParameters(a16);
            } catch (Throwable th5) {
                LiteavLog.e("CameraController", "enable torch failed.", th5);
            }
        }
    }

    private Rect a(float f16, float f17, float f18) {
        int i3 = (int) (f18 * 200.0f);
        Size size = this.f119590g;
        int i16 = (int) (((f16 / size.width) * 2000.0f) - 1000.0f);
        int i17 = (int) (((f17 / size.height) * 2000.0f) - 1000.0f);
        int i18 = i3 / 2;
        int a16 = g.a(i16 - i18, -1000, 1000);
        int a17 = g.a(a16 + i3, -1000, 1000);
        int a18 = g.a(i17 - i18, -1000, 1000);
        return new Rect(a16, a18, a17, g.a(i3 + a18, -1000, 1000));
    }

    private static int a(Camera.Parameters parameters, float f16) {
        int minExposureCompensation = parameters.getMinExposureCompensation();
        int maxExposureCompensation = parameters.getMaxExposureCompensation();
        if (minExposureCompensation == 0 && maxExposureCompensation == 0) {
            LiteavLog.i("CameraController", "camera doesn't support exposure compensation");
            return minExposureCompensation;
        }
        com.tencent.liteav.base.a.a.a();
        return g.a((int) (g.a(f16, -1.0f) * maxExposureCompensation), minExposureCompensation, maxExposureCompensation);
    }

    private static int a(boolean z16, Camera.CameraInfo cameraInfo) {
        int i3 = -1;
        int i16 = -1;
        for (int i17 = 0; i17 < Camera.getNumberOfCameras(); i17++) {
            Camera.getCameraInfo(i17, cameraInfo);
            LiteavLog.i("CameraController", "get camera info, index: " + i17 + ", facing: " + cameraInfo.facing);
            if (i3 == -1 && cameraInfo.facing == 1) {
                i3 = i17;
            } else if (i16 == -1 && cameraInfo.facing == 0) {
                i16 = i17;
            }
        }
        if (!z16 ? i16 != -1 : i3 == -1) {
            i3 = i16;
        }
        Camera.getCameraInfo(i3, cameraInfo);
        return i3;
    }

    private static Size a(Camera.Parameters parameters, k kVar, int i3, int i16) {
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        ArrayList arrayList = new ArrayList();
        if (supportedPreviewSizes != null) {
            for (Camera.Size size : supportedPreviewSizes) {
                arrayList.add(new Size(size.width, size.height));
            }
        }
        return com.tencent.liteav.videoproducer.capture.b.a(arrayList, kVar, i3, i16);
    }

    private static void a(Camera.Parameters parameters, boolean z16) {
        List<String> supportedFocusModes = parameters.getSupportedFocusModes();
        if (supportedFocusModes == null) {
            return;
        }
        if (z16 && supportedFocusModes.contains("auto")) {
            parameters.setFocusMode("auto");
            LiteavLog.i("CameraController", "set focus mode to auto");
        } else if (supportedFocusModes.contains("continuous-video")) {
            parameters.setFocusMode("continuous-video");
            LiteavLog.i("CameraController", "set focus mode to continuous-video");
        }
    }

    private int a(int i3) {
        Camera.Parameters a16 = a();
        if (a16 == null) {
            return 1;
        }
        List<Integer> supportedPreviewFrameRates = a16.getSupportedPreviewFrameRates();
        if (supportedPreviewFrameRates != null && !supportedPreviewFrameRates.isEmpty()) {
            int intValue = supportedPreviewFrameRates.get(0).intValue();
            Iterator<Integer> it = supportedPreviewFrameRates.iterator();
            while (it.hasNext()) {
                int intValue2 = it.next().intValue();
                if (Math.abs(i3 - intValue2) < Math.abs(i3 - intValue)) {
                    intValue = intValue2;
                }
            }
            LiteavLog.i("CameraController", "best matched frame rate: %d", Integer.valueOf(intValue));
            return intValue;
        }
        LiteavLog.e("CameraController", "supported preview frame rates is empty");
        return 1;
    }

    private Camera.Parameters a() {
        try {
            Camera camera2 = this.f119585b;
            if (camera2 != null) {
                return camera2.getParameters();
            }
            return null;
        } catch (Throwable th5) {
            LiteavLog.e("CameraController", "getCameraParameters failed.", th5);
            return null;
        }
    }

    private static com.tencent.liteav.videoproducer.a.a[] a(List<int[]> list) {
        if (list == null || list.size() <= 0) {
            return new com.tencent.liteav.videoproducer.a.a[0];
        }
        com.tencent.liteav.videoproducer.a.a[] aVarArr = new com.tencent.liteav.videoproducer.a.a[list.size()];
        for (int i3 = 0; i3 < list.size(); i3++) {
            int[] iArr = list.get(i3);
            if (iArr != null && iArr.length >= 2) {
                aVarArr[i3] = new com.tencent.liteav.videoproducer.a.a(iArr[0], iArr[1]);
            }
        }
        return aVarArr;
    }
}
