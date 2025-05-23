package com.tencent.qqcamerakit.capture.camera2;

import android.annotation.TargetApi;
import android.app.admin.DevicePolicyManager;
import android.graphics.Rect;
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
import android.hardware.camera2.params.MeteringRectangle;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.Image;
import android.media.ImageReader;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.Range;
import android.util.Size;
import android.util.SizeF;
import android.view.Surface;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qmethod.pandoraex.monitor.CameraMonitor;
import com.tencent.qqcamerakit.capture.CameraHandler;
import com.tencent.qqcamerakit.capture.c;
import com.tencent.qqcamerakit.capture.cameraextend.a;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
@TargetApi(21)
/* loaded from: classes22.dex */
public class b {
    static IPatchRedirector $redirector_;
    private static int M;
    private static boolean N;
    private static boolean O;
    private static int P;
    private static String Q;
    private static String R;
    private static String S;
    private static String T;
    public static String U;
    public static int V;
    private static b W;
    private static HashMap<String, i> X;
    private float A;
    private float B;
    private Rect C;
    private int D;
    private Semaphore E;
    private float F;
    public int G;
    private int H;
    private long I;
    private CameraCaptureSession.CaptureCallback J;
    private final CameraCaptureSession.CaptureCallback K;
    private final CameraCaptureSession.CaptureCallback L;

    /* renamed from: a, reason: collision with root package name */
    private CaptureRequest.Builder f344827a;

    /* renamed from: b, reason: collision with root package name */
    private CaptureRequest f344828b;

    /* renamed from: c, reason: collision with root package name */
    private CameraCaptureSession f344829c;

    /* renamed from: d, reason: collision with root package name */
    private CameraDevice f344830d;

    /* renamed from: e, reason: collision with root package name */
    private ImageReader f344831e;

    /* renamed from: f, reason: collision with root package name */
    private ImageReader f344832f;

    /* renamed from: g, reason: collision with root package name */
    private i f344833g;

    /* renamed from: h, reason: collision with root package name */
    private Surface f344834h;

    /* renamed from: i, reason: collision with root package name */
    private com.tencent.qqcamerakit.capture.d f344835i;

    /* renamed from: j, reason: collision with root package name */
    private com.tencent.qqcamerakit.capture.d f344836j;

    /* renamed from: k, reason: collision with root package name */
    private com.tencent.qqcamerakit.capture.d f344837k;

    /* renamed from: l, reason: collision with root package name */
    private Range<Integer> f344838l;

    /* renamed from: m, reason: collision with root package name */
    private volatile boolean f344839m;

    /* renamed from: n, reason: collision with root package name */
    private volatile boolean f344840n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f344841o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f344842p;

    /* renamed from: q, reason: collision with root package name */
    private int f344843q;

    /* renamed from: r, reason: collision with root package name */
    public j f344844r;

    /* renamed from: s, reason: collision with root package name */
    private SurfaceTexture f344845s;

    /* renamed from: t, reason: collision with root package name */
    private HandlerThread f344846t;

    /* renamed from: u, reason: collision with root package name */
    private Handler f344847u;

    /* renamed from: v, reason: collision with root package name */
    private com.tencent.qqcamerakit.capture.b f344848v;

    /* renamed from: w, reason: collision with root package name */
    private CameraHandler.c f344849w;

    /* renamed from: x, reason: collision with root package name */
    private boolean f344850x;

    /* renamed from: y, reason: collision with root package name */
    private com.tencent.qqcamerakit.capture.camera2.c f344851y;

    /* renamed from: z, reason: collision with root package name */
    private long f344852z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class a extends CameraDevice.StateCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f344853a;

        a(long j3) {
            this.f344853a = j3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, b.this, Long.valueOf(j3));
            }
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onDisconnected(@NonNull CameraDevice cameraDevice) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) cameraDevice);
                return;
            }
            com.tencent.qqcamerakit.common.e.d("Camera2Control", 1, "[Camera2]openCamera2 onDisconnected!");
            b.this.f344839m = false;
            b.this.f344840n = false;
            cameraDevice.close();
            b.this.f344830d = null;
            b.this.E.release();
            j jVar = b.this.f344844r;
            if (jVar != null) {
                jVar.a(1, 3, "onDisconnected", new Object[0]);
            }
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onError(@NonNull CameraDevice cameraDevice, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) cameraDevice, i3);
                return;
            }
            com.tencent.qqcamerakit.common.e.d("Camera2Control", 1, "[Camera2]openCamera2 onError, error:" + i3);
            b.this.f344839m = false;
            b.this.f344840n = false;
            cameraDevice.close();
            b.this.f344830d = null;
            b.this.E.release();
            j jVar = b.this.f344844r;
            if (jVar != null) {
                jVar.a(1, 3, "onError " + i3, new Object[0]);
            }
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onOpened(@NonNull CameraDevice cameraDevice) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) cameraDevice);
                return;
            }
            com.tencent.qqcamerakit.common.e.a("Camera2Control", 1, "[Camera2]openCamera2 onOpen, cost:" + (System.currentTimeMillis() - this.f344853a));
            b.this.f344830d = cameraDevice;
            b.this.f344839m = true;
            b.this.f344840n = false;
            b.this.E.release();
            j jVar = b.this.f344844r;
            if (jVar != null) {
                jVar.a(1, 0, "", new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.qqcamerakit.capture.camera2.b$b, reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public class C9359b extends CameraCaptureSession.StateCallback {
        static IPatchRedirector $redirector_;

        C9359b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigureFailed(@NonNull CameraCaptureSession cameraCaptureSession) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) cameraCaptureSession);
                return;
            }
            com.tencent.qqcamerakit.common.e.d("Camera2Control", 1, "[Camera2]startPreview onConfigureFailed!");
            b.this.f344841o = false;
            b.this.E.release();
            j jVar = b.this.f344844r;
            if (jVar != null) {
                jVar.a(3, 42, "[Camera2]onConfigureFailed", new Object[0]);
            }
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigured(@NonNull CameraCaptureSession cameraCaptureSession) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) cameraCaptureSession);
                return;
            }
            com.tencent.qqcamerakit.common.e.a("Camera2Control", 1, "[Camera2]startPreview onConfigured!");
            b.this.f344841o = true;
            b.this.f344829c = cameraCaptureSession;
            b.this.f344827a.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(b.this.f344843q));
            b.this.f344827a.set(CaptureRequest.CONTROL_AE_MODE, 1);
            b.this.f344827a.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, b.this.f344838l);
            b bVar = b.this;
            bVar.f344828b = bVar.f344827a.build();
            b bVar2 = b.this;
            bVar2.H0(bVar2.K);
            b.this.E.release();
            j jVar = b.this.f344844r;
            if (jVar != null) {
                jVar.a(3, 0, "", new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class c implements ImageReader.OnImageAvailableListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // android.media.ImageReader.OnImageAvailableListener
        public void onImageAvailable(ImageReader imageReader) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) imageReader);
                return;
            }
            try {
                Image acquireNextImage = imageReader.acquireNextImage();
                if (acquireNextImage != null) {
                    ByteBuffer buffer = acquireNextImage.getPlanes()[0].getBuffer();
                    byte[] bArr = new byte[buffer.remaining()];
                    buffer.get(bArr);
                    if (b.this.f344849w != null) {
                        b.this.f344849w.f344787f = bArr;
                        b.this.f344849w.f344788g = 100;
                        new com.tencent.qqcamerakit.capture.cameraextend.c(b.this.f344849w).execute(new Void[0]);
                    }
                    acquireNextImage.close();
                }
            } catch (Exception e16) {
                com.tencent.qqcamerakit.common.e.a("Camera2Control", 1, "[Camera2] onImageAvailable mImageReader exception:" + e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class d implements ImageReader.OnImageAvailableListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // android.media.ImageReader.OnImageAvailableListener
        public void onImageAvailable(ImageReader imageReader) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) imageReader);
                return;
            }
            try {
                Image acquireNextImage = imageReader.acquireNextImage();
                if (acquireNextImage != null) {
                    if (b.this.f344848v != null) {
                        b.this.f344848v.onPreviewFrame(acquireNextImage);
                    }
                    acquireNextImage.close();
                }
            } catch (Exception e16) {
                com.tencent.qqcamerakit.common.e.a("Camera2Control", 1, "[Camera2] onImageAvailable mPreviewReader exception:" + e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class e extends CameraCaptureSession.CaptureCallback {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureCompleted(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, cameraCaptureSession, captureRequest, totalCaptureResult);
                return;
            }
            com.tencent.qqcamerakit.common.e.e("Camera2Control", 1, "[Camera2]captureStillPicture!");
            b.this.f344852z = 0L;
            b.this.f344850x = false;
            b.this.f344851y.b(0);
            b.this.F0();
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureFailed(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull CaptureFailure captureFailure) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, cameraCaptureSession, captureRequest, captureFailure);
            } else {
                com.tencent.qqcamerakit.common.e.e("Camera2Control", 1, "[Camera2]captureStillPicture failed!");
                b.this.f344852z = 0L;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class f extends CameraCaptureSession.CaptureCallback {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        private void a(CaptureResult captureResult, CaptureRequest captureRequest) {
            Object tag = captureRequest.getTag();
            if (tag instanceof a.C9360a) {
                a.C9360a c9360a = (a.C9360a) tag;
                if (!c9360a.f344879j) {
                    Integer num = (Integer) captureResult.get(CaptureResult.CONTROL_AF_STATE);
                    com.tencent.qqcamerakit.common.e.d("Camera2Control", 1, "[Camera2] mAfCaptureCallback:" + num);
                    if (num == null) {
                        return;
                    }
                    if (4 == num.intValue() || 5 == num.intValue()) {
                        b(true, c9360a);
                        return;
                    }
                    return;
                }
            }
            com.tencent.qqcamerakit.common.e.d("Camera2Control", 1, "[Camera2] mAfCaptureCallback handled!");
            b.this.f344842p = false;
        }

        private void b(boolean z16, a.C9360a c9360a) {
            b.this.f344842p = false;
            b.this.f344827a.set(CaptureRequest.CONTROL_AF_TRIGGER, 2);
            try {
                if (com.tencent.qqcamerakit.common.e.f()) {
                    com.tencent.qqcamerakit.common.e.a("Camera2Control", 2, "[Camera2] mAfCaptureCallback run, success:" + z16);
                }
                b.this.f344827a.set(CaptureRequest.CONTROL_AF_MODE, 4);
                CameraMonitor.setRepeatingRequest(b.this.f344829c, b.this.f344827a.build(), null, null);
                c.a aVar = c9360a.f344876g;
                if (aVar != null && !c9360a.f344879j) {
                    c9360a.f344879j = true;
                    aVar.onAutoFocusCallback(z16);
                }
            } catch (Exception e16) {
                com.tencent.qqcamerakit.common.e.d("Camera2Control", 1, "[Camera2] mAfCaptureCallback e:" + e16);
            }
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureCompleted(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, cameraCaptureSession, captureRequest, totalCaptureResult);
            } else {
                a(totalCaptureResult, captureRequest);
            }
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureFailed(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull CaptureFailure captureFailure) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, cameraCaptureSession, captureRequest, captureFailure);
                return;
            }
            com.tencent.qqcamerakit.common.e.d("Camera2Control", 1, "[Camera2] mAfCaptureCallback failure reason:" + captureFailure.getReason());
            Object tag = captureRequest.getTag();
            if (tag instanceof a.C9360a) {
                a.C9360a c9360a = (a.C9360a) tag;
                if (!c9360a.f344879j) {
                    b(false, c9360a);
                    return;
                }
            }
            com.tencent.qqcamerakit.common.e.d("Camera2Control", 1, "[Camera2] mAfCaptureCallback handled!");
            b.this.f344842p = false;
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureProgressed(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull CaptureResult captureResult) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, cameraCaptureSession, captureRequest, captureResult);
            } else {
                a(captureResult, captureRequest);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class g extends CameraCaptureSession.CaptureCallback {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureCompleted(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, cameraCaptureSession, captureRequest, totalCaptureResult);
                return;
            }
            Long l3 = (Long) totalCaptureResult.get(CaptureResult.SENSOR_EXPOSURE_TIME);
            Integer num = (Integer) totalCaptureResult.get(CaptureResult.SENSOR_SENSITIVITY);
            if (l3 != null && num != null) {
                b.this.I = l3.longValue();
                b.this.H = num.intValue();
                b.this.G0();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class h extends CameraCaptureSession.CaptureCallback {
        static IPatchRedirector $redirector_;

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureCompleted(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, cameraCaptureSession, captureRequest, totalCaptureResult);
                return;
            }
            Long l3 = (Long) totalCaptureResult.get(CaptureResult.SENSOR_EXPOSURE_TIME);
            Integer num = (Integer) totalCaptureResult.get(CaptureResult.SENSOR_SENSITIVITY);
            if (l3 != null && num != null) {
                b.this.I = l3.longValue();
                b.this.H = num.intValue();
                com.tencent.qqcamerakit.common.e.e("Camera2Control", 1, "[Camera2] mAeCaptureCallback currentExposureTime: " + b.this.I + " currentISO: " + b.this.H);
                if (captureRequest.getTag() instanceof Long) {
                    long longValue = ((Long) captureRequest.getTag()).longValue();
                    int i3 = (int) ((b.this.I * b.this.H) / longValue);
                    b.this.l0(i3, longValue);
                    com.tencent.qqcamerakit.common.e.h("Camera2Control", 1, "[Camera2] mAeCaptureCallback set exposureTime: " + longValue + " ISO: " + i3);
                    return;
                }
                if (captureRequest.getTag() instanceof Integer) {
                    int intValue = ((Integer) captureRequest.getTag()).intValue();
                    long j3 = (b.this.I * b.this.H) / intValue;
                    b.this.l0(intValue, j3);
                    com.tencent.qqcamerakit.common.e.h("Camera2Control", 1, "[Camera2] mAeCaptureCallback set exposureTime: " + j3 + " ISO: " + intValue);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class i {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f344862a;

        /* renamed from: b, reason: collision with root package name */
        public CameraCharacteristics f344863b;

        public i(String str, CameraCharacteristics cameraCharacteristics) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) cameraCharacteristics);
            } else {
                this.f344862a = str;
                this.f344863b = cameraCharacteristics;
            }
        }

        public boolean a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            if (!TextUtils.isEmpty(this.f344862a) && this.f344863b != null) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface j {
        void a(int i3, int i16, String str, Object... objArr);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11380);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 39)) {
            redirector.redirect((short) 39);
            return;
        }
        M = -1;
        N = false;
        O = false;
        P = 0;
        Q = "";
        R = "";
        S = "";
        T = "";
        X = new HashMap<>();
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f344839m = false;
        this.f344840n = false;
        this.f344841o = false;
        this.f344842p = false;
        this.f344843q = 4;
        this.f344850x = false;
        this.f344852z = 0L;
        this.A = -1.0f;
        this.B = 0.0f;
        this.C = null;
        this.D = -1;
        this.E = new Semaphore(1);
        this.F = 0.4f;
        this.G = 100;
        this.H = 0;
        this.I = 0L;
        this.J = new f();
        this.K = new g();
        this.L = new h();
        this.f344851y = new com.tencent.qqcamerakit.capture.camera2.c(this);
    }

    private void A(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f344833g = X.get(str);
        }
    }

    private void A0() {
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("Camera2_Background_Thread");
        this.f344846t = baseHandlerThread;
        baseHandlerThread.start();
        this.f344847u = new Handler(this.f344846t.getLooper());
    }

    private boolean C() {
        try {
            return ((DevicePolicyManager) com.tencent.qqcamerakit.capture.c.d().getSystemService("device_policy")).getCameraDisabled(null);
        } catch (Exception e16) {
            if (com.tencent.qqcamerakit.common.e.f()) {
                com.tencent.qqcamerakit.common.e.b("Camera2Control", 2, "checkCameraDisabled, ", e16);
                return true;
            }
            return true;
        } catch (NoClassDefFoundError e17) {
            if (com.tencent.qqcamerakit.common.e.f()) {
                com.tencent.qqcamerakit.common.e.b("Camera2Control", 2, "checkCameraDisabled, ", e17);
                return true;
            }
            return true;
        }
    }

    private void C0() {
        this.f344846t.quitSafely();
        try {
            this.f344846t.join();
            this.f344846t = null;
            this.f344847u = null;
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private int D(int i3, int i16, int i17) {
        if (i3 > i17) {
            return i17;
        }
        if (i3 < i16) {
            return i16;
        }
        return i3;
    }

    private void F() {
        CameraCaptureSession cameraCaptureSession = this.f344829c;
        if (cameraCaptureSession != null) {
            cameraCaptureSession.close();
            this.f344829c = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F0() {
        try {
            this.f344827a.set(CaptureRequest.CONTROL_AF_TRIGGER, 2);
            this.f344827a.set(CaptureRequest.FLASH_MODE, 0);
            this.f344829c.capture(this.f344827a.build(), null, null);
            CameraMonitor.setRepeatingRequest(this.f344829c, this.f344828b, null, null);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private Rect G(float f16) {
        float floatValue = ((Float) this.f344833g.f344863b.get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM)).floatValue();
        float f17 = ((floatValue - 1.0f) * f16) + 1.0f;
        Rect rect = (Rect) this.f344833g.f344863b.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
        int width = rect.width() / 2;
        int height = rect.height() / 2;
        int width2 = (int) ((rect.width() * 0.5f) / f17);
        int height2 = (int) ((rect.height() * 0.5f) / f17);
        com.tencent.qqcamerakit.common.e.e("Camera2Control", 1, "sensorRect: " + rect);
        com.tencent.qqcamerakit.common.e.e("Camera2Control", 1, "maxZoom: " + floatValue);
        com.tencent.qqcamerakit.common.e.e("Camera2Control", 1, "zoomRatio: " + f17);
        Rect rect2 = new Rect(width - width2, height - height2, width + width2, height + height2);
        com.tencent.qqcamerakit.common.e.e("Camera2Control", 1, "zoomRect: " + rect2);
        return rect2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G0() {
        H0(null);
    }

    private Rect H(float f16) {
        Rect rect = (Rect) this.f344833g.f344863b.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
        float floatValue = ((Float) this.f344833g.f344863b.get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM)).floatValue();
        float f17 = floatValue - 1.0f;
        int width = (int) (rect.width() / floatValue);
        int width2 = rect.width() - width;
        int height = rect.height() - ((int) (rect.height() / floatValue));
        float f18 = ((f16 * f17) + 1.0f) - 1.0f;
        int i3 = (int) (((width2 * f18) / f17) / 2.0f);
        int i16 = (int) (((height * f18) / f17) / 2.0f);
        return new Rect(i3, i16, rect.width() - i3, rect.height() - i16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H0(CameraCaptureSession.CaptureCallback captureCallback) {
        Handler handler;
        if (this.f344830d == null) {
            return;
        }
        try {
            CameraCaptureSession cameraCaptureSession = this.f344829c;
            CaptureRequest build = this.f344827a.build();
            if (captureCallback != null) {
                handler = this.f344847u;
            } else {
                handler = null;
            }
            CameraMonitor.setRepeatingRequest(cameraCaptureSession, build, captureCallback, handler);
        } catch (Exception e16) {
            e16.printStackTrace();
            com.tencent.qqcamerakit.common.e.d("Camera2Control", 1, "[Camera2]updatePreview exp:" + e16);
        }
    }

    private static String I(CameraManager cameraManager, String str, CameraCharacteristics cameraCharacteristics) {
        Set<String> set;
        try {
            String str2 = null;
            if (Build.VERSION.SDK_INT >= 28) {
                set = cameraCharacteristics.getPhysicalCameraIds();
            } else {
                set = null;
            }
            if (set != null && !set.isEmpty()) {
                com.tencent.qqcamerakit.common.e.d("Camera2Control", 1, "[Camera2] found " + set.size() + " physical cameras in camera " + str);
                float f16 = 0.0f;
                for (String str3 : set) {
                    float P2 = P(cameraManager.getCameraCharacteristics(str3));
                    com.tencent.qqcamerakit.common.e.d("Camera2Control", 1, "[Camera2] fov of camera " + str + " is " + P2);
                    if (P2 > f16) {
                        str2 = str3;
                        f16 = P2;
                    }
                }
                try {
                    X.put(str2, new i(str2, cameraManager.getCameraCharacteristics(str2)));
                    return str2;
                } catch (Exception e16) {
                    e = e16;
                    str = str2;
                    com.tencent.qqcamerakit.common.e.d("Camera2Control", 1, "[Camera2]getCameraByMaxFov exception:" + e.getMessage());
                    return str;
                }
            }
            return str;
        } catch (Exception e17) {
            e = e17;
        }
    }

    public static String J(int i3, boolean z16) {
        if (i3 != 1) {
            if (i3 != 2) {
                return Q;
            }
            if (X()) {
                if (z16) {
                    return S;
                }
                return Q;
            }
        } else if (Y()) {
            if (z16) {
                return T;
            }
            return R;
        }
        return "1";
    }

    private static float P(CameraCharacteristics cameraCharacteristics) {
        SizeF sizeF = (SizeF) cameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_PHYSICAL_SIZE);
        float[] fArr = (float[]) cameraCharacteristics.get(CameraCharacteristics.LENS_INFO_AVAILABLE_FOCAL_LENGTHS);
        if (fArr != null && fArr.length > 0) {
            return (float) Math.toDegrees(Math.atan(sizeF.getWidth() / (fArr[0] * 2.0f)) * 2.0d);
        }
        return -1.0f;
    }

    public static b Q() {
        if (W == null) {
            synchronized (b.class) {
                if (W == null) {
                    W = new b();
                }
            }
        }
        return W;
    }

    private long V(long j3) {
        Range range = (Range) this.f344833g.f344863b.get(CameraCharacteristics.SENSOR_INFO_EXPOSURE_TIME_RANGE);
        if (range == null) {
            return j3;
        }
        if (((Long) range.getLower()).longValue() > j3) {
            return ((Long) range.getLower()).longValue();
        }
        if (((Long) range.getUpper()).longValue() < j3) {
            return ((Long) range.getUpper()).longValue();
        }
        return j3;
    }

    private int W(int i3) {
        Comparable upper;
        Range range = (Range) this.f344833g.f344863b.get(CameraCharacteristics.SENSOR_INFO_SENSITIVITY_RANGE);
        if (range == null) {
            return i3;
        }
        if (((Integer) range.getLower()).intValue() > i3) {
            upper = range.getLower();
        } else if (((Integer) range.getUpper()).intValue() < i3) {
            upper = range.getUpper();
        } else {
            return i3;
        }
        return ((Integer) upper).intValue();
    }

    public static boolean X() {
        a0();
        if (P > 0 && !TextUtils.isEmpty(Q)) {
            return true;
        }
        return false;
    }

    public static boolean Y() {
        a0();
        if (P > 0 && !TextUtils.isEmpty(R)) {
            return true;
        }
        return false;
    }

    public static boolean Z(int i3) {
        a0();
        if (i3 != 1) {
            if (i3 == 2 && X()) {
                return !Q.equals(S);
            }
            return false;
        }
        if (Y()) {
            return !R.equals(T);
        }
        return false;
    }

    private static void a0() {
        if (O) {
            return;
        }
        try {
            if (d0()) {
                CameraManager cameraManager = (CameraManager) com.tencent.qqcamerakit.capture.c.d().getSystemService("camera");
                for (String str : cameraManager.getCameraIdList()) {
                    CameraCharacteristics cameraCharacteristics = cameraManager.getCameraCharacteristics(str);
                    Integer num = (Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_FACING);
                    if (num != null && num.intValue() == 0 && "1".equals(str)) {
                        X.put(str, new i(str, cameraCharacteristics));
                        R = str;
                        P++;
                        T = I(cameraManager, str, cameraCharacteristics);
                    } else if (num != null && num.intValue() == 1 && "0".equals(str)) {
                        X.put(str, new i(str, cameraCharacteristics));
                        Q = str;
                        P++;
                        S = I(cameraManager, str, cameraCharacteristics);
                    }
                }
                com.tencent.qqcamerakit.common.e.d("Camera2Control", 1, "[Camera2]initCamera2Ability front:" + R + ", back:" + Q + ", front with max fov: " + T + ", back with max fov: " + S);
            }
        } catch (Exception unused) {
            P = 1;
            Q = "1";
            com.tencent.qqcamerakit.common.e.d("Camera2Control", 1, "[Camera2]initCamera2Ability exception!");
        }
        O = true;
    }

    public static int b0() {
        if (N) {
            return M;
        }
        CameraManager cameraManager = (CameraManager) com.tencent.qqcamerakit.capture.c.d().getSystemService("camera");
        int i3 = -2;
        try {
            String[] cameraIdList = cameraManager.getCameraIdList();
            if (cameraIdList.length > 0) {
                int length = cameraIdList.length;
                int i16 = 0;
                while (true) {
                    if (i16 >= length) {
                        break;
                    }
                    String str = cameraIdList[i16];
                    com.tencent.qqcamerakit.common.e.e("Camera2Control", 2, "[Camera2]initCamera2SupportLevel for logicCameraId = " + str);
                    CameraCharacteristics cameraCharacteristics = cameraManager.getCameraCharacteristics(str);
                    Integer num = (Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_FACING);
                    com.tencent.qqcamerakit.common.e.e("Camera2Control", 2, "[Camera2]initCameraSupportLevel camera facing = " + num);
                    if (num != null && num.intValue() != 2 && ((num.intValue() != 0 || "1".equals(str)) && (num.intValue() != 1 || "0".equals(str)))) {
                        Integer num2 = (Integer) cameraCharacteristics.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
                        if (com.tencent.qqcamerakit.common.e.f()) {
                            com.tencent.qqcamerakit.common.e.e("Camera2Control", 2, "[Camera2]initCamera2SupportLevel supportLevel:" + num2);
                        }
                        if (num2 == null) {
                            i3 = -1;
                            break;
                        }
                        i3 = num2.intValue();
                        if (num2.intValue() != 1 && num2.intValue() != 0 && num2.intValue() != 3) {
                            break;
                        }
                    }
                    i16++;
                }
            }
        } catch (Throwable th5) {
            if (com.tencent.qqcamerakit.common.e.f()) {
                com.tencent.qqcamerakit.common.e.b("Camera2Control", 2, "[Camera2]initCamera2SupportLevel exception:", th5);
            }
        }
        M = i3;
        N = true;
        return i3;
    }

    private int c0(int i3) {
        int i16 = 0;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        i16 = 270;
                    }
                } else {
                    i16 = 180;
                }
            } else {
                i16 = 90;
            }
        }
        return ((((Integer) this.f344833g.f344863b.get(CameraCharacteristics.SENSOR_ORIENTATION)).intValue() - i16) + 360) % 360;
    }

    public static boolean d0() {
        return true;
    }

    private void e0() {
        try {
            this.f344827a.set(CaptureRequest.CONTROL_AF_TRIGGER, 1);
            this.f344851y.b(1);
            this.f344829c.capture(this.f344827a.build(), this.f344851y, this.f344847u);
        } catch (CameraAccessException e16) {
            e16.printStackTrace();
        }
    }

    private void w0() {
        com.tencent.qqcamerakit.capture.d dVar = this.f344836j;
        ImageReader newInstance = ImageReader.newInstance(dVar.f344911a, dVar.f344912b, 256, 2);
        this.f344831e = newInstance;
        newInstance.setOnImageAvailableListener(new c(), this.f344847u);
        com.tencent.qqcamerakit.capture.d dVar2 = this.f344835i;
        ImageReader newInstance2 = ImageReader.newInstance(dVar2.f344911a, dVar2.f344912b, 35, 2);
        this.f344832f = newInstance2;
        newInstance2.setOnImageAvailableListener(new d(), null);
    }

    public void B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
            return;
        }
        try {
            if (com.tencent.qqcamerakit.common.e.f()) {
                com.tencent.qqcamerakit.common.e.e("Camera2Control", 2, "[Camera2]captureStillPicture request!");
            }
            if (this.f344852z > 0) {
                com.tencent.qqcamerakit.common.e.e("Camera2Control", 1, "[Camera2]captureStillPicture on id:" + this.f344852z);
                return;
            }
            this.f344852z = System.currentTimeMillis();
            CaptureRequest.Builder createCaptureRequest = CameraMonitor.createCaptureRequest(this.f344830d, 2);
            createCaptureRequest.addTarget(this.f344831e.getSurface());
            createCaptureRequest.set(CaptureRequest.CONTROL_AF_MODE, 4);
            int i3 = this.D;
            if (i3 > -1) {
                createCaptureRequest.set(CaptureRequest.FLASH_MODE, Integer.valueOf(i3));
            }
            Rect rect = this.C;
            if (rect != null) {
                createCaptureRequest.set(CaptureRequest.SCALER_CROP_REGION, rect);
            }
            this.f344829c.capture(createCaptureRequest.build(), new e(), null);
        } catch (Exception unused) {
        }
    }

    public void B0(SurfaceTexture surfaceTexture, com.tencent.qqcamerakit.capture.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) surfaceTexture, (Object) bVar);
            return;
        }
        try {
            this.E.acquire();
            if (this.f344830d != null && this.f344839m) {
                if (surfaceTexture == null) {
                    com.tencent.qqcamerakit.common.e.d("Camera2Control", 1, "[Camera2] startPreview params exception!");
                    j jVar = this.f344844r;
                    if (jVar != null) {
                        jVar.a(3, 40, "[Camera2]no surface", new Object[0]);
                    }
                    this.E.release();
                    return;
                }
                u0(surfaceTexture);
                w0();
                this.f344848v = bVar;
                F();
                SurfaceTexture surfaceTexture2 = this.f344845s;
                com.tencent.qqcamerakit.capture.d dVar = this.f344835i;
                surfaceTexture2.setDefaultBufferSize(dVar.f344911a, dVar.f344912b);
                Surface surface = this.f344834h;
                if (surface != null) {
                    surface.release();
                }
                this.f344834h = new Surface(this.f344845s);
                CaptureRequest.Builder createCaptureRequest = CameraMonitor.createCaptureRequest(this.f344830d, 1);
                this.f344827a = createCaptureRequest;
                createCaptureRequest.addTarget(this.f344834h);
                this.f344827a.addTarget(this.f344832f.getSurface());
                this.f344827a.set(CaptureRequest.STATISTICS_FACE_DETECT_MODE, Integer.valueOf(com.tencent.qqcamerakit.capture.a.E));
                com.tencent.qqcamerakit.common.e.d("Camera2Control", 2, "[Camera2] face detect mode : " + this.f344827a.get(CaptureRequest.STATISTICS_FACE_DETECT_MODE));
                this.f344827a.set(CaptureRequest.LENS_OPTICAL_STABILIZATION_MODE, 0);
                this.f344827a.set(CaptureRequest.CONTROL_VIDEO_STABILIZATION_MODE, 0);
                com.tencent.qqcamerakit.common.e.e("Camera2Control", 2, "[Camera2] set optical stabilization and video stabilization off");
                this.f344830d.createCaptureSession(Arrays.asList(this.f344834h, this.f344832f.getSurface(), this.f344831e.getSurface()), new C9359b(), this.f344847u);
                return;
            }
            com.tencent.qqcamerakit.common.e.d("Camera2Control", 1, "[Camera2] startPreview mCameraDevice null!");
            j jVar2 = this.f344844r;
            if (jVar2 != null) {
                jVar2.a(3, 41, "[Camera2]error camera, isopend:" + this.f344839m, new Object[0]);
            }
            this.E.release();
        } catch (Exception e16) {
            com.tencent.qqcamerakit.common.e.d("Camera2Control", 1, "[Camera2]startPreview exception:" + e16);
            this.f344841o = false;
            this.E.release();
            j jVar3 = this.f344844r;
            if (jVar3 != null) {
                jVar3.a(3, 42, "[Camera2]" + e16.getMessage(), new Object[0]);
            }
        }
    }

    public void D0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this);
        } else if (this.f344830d == null) {
            com.tencent.qqcamerakit.common.e.e("Camera2Control", 1, "[Camera2] stopRecordVideo device null!");
        } else {
            this.f344827a.set(CaptureRequest.FLASH_MODE, 0);
            G0();
        }
    }

    public void E() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        try {
            try {
                this.E.acquire();
                F();
                CameraDevice cameraDevice = this.f344830d;
                if (cameraDevice != null) {
                    cameraDevice.close();
                    this.f344830d = null;
                }
                if (this.f344844r != null) {
                    this.f344844r = null;
                }
                ImageReader imageReader = this.f344831e;
                if (imageReader != null) {
                    imageReader.close();
                    this.f344831e = null;
                }
                ImageReader imageReader2 = this.f344832f;
                if (imageReader2 != null) {
                    imageReader2.close();
                    this.f344832f = null;
                }
                if (this.f344845s != null) {
                    this.f344845s = null;
                }
                if (this.f344833g != null) {
                    this.f344833g = null;
                }
                if (this.f344848v != null) {
                    this.f344848v = null;
                }
                if (this.C != null) {
                    this.C = null;
                }
                if (this.f344828b != null) {
                    this.f344828b = null;
                }
                C0();
                CaptureRequest.Builder builder = this.f344827a;
                if (builder != null) {
                    builder.removeTarget(this.f344834h);
                }
                Surface surface = this.f344834h;
                if (surface != null) {
                    surface.release();
                }
                this.A = -1.0f;
                this.D = -1;
                this.f344839m = false;
                this.f344840n = false;
                this.f344841o = false;
                this.f344850x = false;
                this.f344842p = false;
                this.f344852z = 0L;
                com.tencent.qqcamerakit.common.e.a("Camera2Control", 1, "[Camera2]closeCamera2!");
            } catch (Exception e16) {
                this.f344839m = false;
                this.f344841o = false;
                this.f344850x = false;
                this.f344842p = false;
                com.tencent.qqcamerakit.common.e.d("Camera2Control", 1, "[Camera2]closeCamera2 exception:" + e16);
            }
        } finally {
            this.E.release();
        }
    }

    public void E0(CameraHandler.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) cVar);
            return;
        }
        if (!this.f344839m) {
            com.tencent.qqcamerakit.common.e.d("Camera2Control", 1, "[Camera2] takePicture fail, camera not open");
            return;
        }
        if (this.f344850x) {
            com.tencent.qqcamerakit.common.e.d("Camera2Control", 1, "[Camera2] takePicture fail, taking status");
            return;
        }
        if (com.tencent.qqcamerakit.common.e.f()) {
            com.tencent.qqcamerakit.common.e.a("Camera2Control", 2, "[Camera2] takePicture request");
        }
        if (cVar == null) {
            com.tencent.qqcamerakit.common.e.d("Camera2Control", 1, "[Camera2] takePicture request exception");
            return;
        }
        this.f344850x = true;
        this.f344849w = cVar;
        if (this.f344842p) {
            com.tencent.qqcamerakit.common.e.e("Camera2Control", 1, "[Camera2] takePicture AutoFocusing");
            B();
        } else {
            e0();
        }
    }

    public int K() {
        CameraCharacteristics cameraCharacteristics;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Integer) iPatchRedirector.redirect((short) 22, (Object) this)).intValue();
        }
        i iVar = this.f344833g;
        if (iVar != null && (cameraCharacteristics = iVar.f344863b) != null) {
            return ((Integer) cameraCharacteristics.get(CameraCharacteristics.SENSOR_ORIENTATION)).intValue();
        }
        com.tencent.qqcamerakit.common.e.d("Camera2Control", 1, "getCameraOrientation fail, return 0");
        return 0;
    }

    public CameraCharacteristics L() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return (CameraCharacteristics) iPatchRedirector.redirect((short) 38, (Object) this);
        }
        i iVar = this.f344833g;
        if (iVar != null) {
            return iVar.f344863b;
        }
        return null;
    }

    public long M() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Long) iPatchRedirector.redirect((short) 33, (Object) this)).longValue();
        }
        return this.I;
    }

    public int N() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return ((Integer) iPatchRedirector.redirect((short) 32, (Object) this)).intValue();
        }
        return this.H;
    }

    public com.tencent.qqcamerakit.capture.d O() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (com.tencent.qqcamerakit.capture.d) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.f344837k;
    }

    public Rect R(a.C9360a c9360a) {
        int i3;
        int i16;
        double d16;
        double d17;
        double d18;
        double d19;
        double d26;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (Rect) iPatchRedirector.redirect((short) 26, (Object) this, (Object) c9360a);
        }
        if (c9360a == null) {
            return null;
        }
        double d27 = c9360a.f344870a;
        double d28 = c9360a.f344871b;
        int c06 = c0(c9360a.f344874e);
        c9360a.f344874e = c06;
        com.tencent.qqcamerakit.capture.d dVar = this.f344835i;
        int i17 = dVar.f344911a;
        int i18 = dVar.f344912b;
        if (90 != c06 && 270 != c06) {
            i16 = i18;
            i3 = i17;
        } else {
            i3 = i18;
            i16 = i17;
        }
        int i19 = c9360a.f344872c;
        int i26 = i16 * i19;
        int i27 = c9360a.f344873d;
        double d29 = 0.0d;
        if (i26 > i3 * i27) {
            d17 = (i19 * 1.0d) / i3;
            d18 = (i16 - (i27 / d17)) / 2.0d;
            d16 = 0.0d;
        } else {
            double d36 = (i27 * 1.0d) / i16;
            d16 = (i3 - (i19 / d36)) / 2.0d;
            d17 = d36;
            d18 = 0.0d;
        }
        double d37 = (d27 / d17) + d16;
        double d38 = (d28 / d17) + d18;
        if (90 == c06) {
            double d39 = i18 - d37;
            d37 = d38;
            d38 = d39;
        } else if (270 == c06) {
            double d46 = i17 - d38;
            d38 = d37;
            d37 = d46;
        }
        Rect rect = (Rect) this.f344828b.get(CaptureRequest.SCALER_CROP_REGION);
        if (rect == null) {
            com.tencent.qqcamerakit.common.e.d("Camera2Control", 1, "[Camera2]getMeteringRect can't get crop region");
            rect = (Rect) this.f344833g.f344863b.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
        }
        int width = rect.width();
        int height = rect.height();
        com.tencent.qqcamerakit.capture.d dVar2 = this.f344835i;
        int i28 = dVar2.f344912b;
        int i29 = i28 * width;
        int i36 = dVar2.f344911a;
        if (i29 > i36 * height) {
            d19 = (height * 1.0d) / i28;
            double d47 = (width - (i36 * d19)) / 2.0d;
            d26 = 0.0d;
            d29 = d47;
        } else {
            d19 = (width * 1.0d) / i36;
            d26 = (height - (i28 * d19)) / 2.0d;
        }
        double d48 = (d37 * d19) + d29 + rect.left;
        double d49 = (d38 * d19) + d26 + rect.top;
        Rect rect2 = new Rect();
        rect2.left = D((int) (d48 - (rect.width() * 0.05d)), 0, rect.width());
        rect2.right = D((int) (d48 + (rect.width() * 0.05d)), 0, rect.width());
        rect2.top = D((int) (d49 - (rect.height() * 0.05d)), 0, rect.height());
        rect2.bottom = D((int) (d49 + (0.05d * rect.height())), 0, rect.height());
        return rect2;
    }

    public List<int[]> S() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        i iVar = this.f344833g;
        if (iVar != null && iVar.a()) {
            Range[] rangeArr = (Range[]) this.f344833g.f344863b.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES);
            ArrayList arrayList = new ArrayList();
            if (rangeArr != null) {
                for (Range range : rangeArr) {
                    arrayList.add(new int[]{((Integer) range.getLower()).intValue(), ((Integer) range.getUpper()).intValue()});
                }
            }
            return arrayList;
        }
        com.tencent.qqcamerakit.common.e.d("Camera2Control", 1, "[Camera2]getPreviewFps error, camera2Info: ", this.f344833g);
        return null;
    }

    public com.tencent.qqcamerakit.capture.d T() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (com.tencent.qqcamerakit.capture.d) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.f344835i;
    }

    public List<com.tencent.qqcamerakit.capture.d> U(boolean z16) {
        Size[] outputSizes;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (List) iPatchRedirector.redirect((short) 6, (Object) this, z16);
        }
        i iVar = this.f344833g;
        if (iVar != null && iVar.a()) {
            StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) this.f344833g.f344863b.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
            if (streamConfigurationMap == null) {
                com.tencent.qqcamerakit.common.e.d("Camera2Control", 1, "[Camera2]getPreviewSizes map null, isJPEG: ", Boolean.valueOf(z16));
                return null;
            }
            if (z16) {
                outputSizes = streamConfigurationMap.getOutputSizes(256);
            } else {
                outputSizes = streamConfigurationMap.getOutputSizes(SurfaceTexture.class);
            }
            if (outputSizes == null) {
                com.tencent.qqcamerakit.common.e.d("Camera2Control", 1, "[Camera2]getPreviewSizes choices is null, isJPEG: ", Boolean.valueOf(z16));
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Size size : outputSizes) {
                com.tencent.qqcamerakit.capture.d dVar = new com.tencent.qqcamerakit.capture.d(size.getWidth(), size.getHeight());
                arrayList.add(dVar);
                if (com.tencent.qqcamerakit.common.e.f()) {
                    com.tencent.qqcamerakit.common.e.a("Camera2Control", 2, "getPreviewSizes, isJPEG: ", Boolean.valueOf(z16), " ", dVar);
                }
            }
            return arrayList;
        }
        com.tencent.qqcamerakit.common.e.d("Camera2Control", 1, "[Camera2]getPreviewSizes error, camera2Info: ", this.f344833g, " isJPEG: ", Boolean.valueOf(z16));
        return null;
    }

    public int f0(int i3, boolean z16, j jVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 3;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Boolean.valueOf(z16), jVar)).intValue();
        }
        if (!this.f344839m && !this.f344840n) {
            if (C()) {
                if (com.tencent.qqcamerakit.common.e.f()) {
                    com.tencent.qqcamerakit.common.e.e("Camera2Control", 2, "openCamera failed, camera disable");
                }
                return 5;
            }
            this.f344840n = true;
            long currentTimeMillis = System.currentTimeMillis();
            a0();
            h0(jVar);
            A0();
            com.tencent.qqcamerakit.common.e.d("Camera2Control", 1, "[Camera2]openCamera2");
            try {
            } catch (Exception e16) {
                this.f344839m = false;
                this.f344840n = false;
                this.f344830d = null;
                this.E.release();
                com.tencent.qqcamerakit.common.e.d("Camera2Control", 1, "[Camera2]openCamera2 exception:" + e16);
                if (e16 instanceof CameraAccessException) {
                    i16 = 5;
                } else if (e16 instanceof IllegalArgumentException) {
                    i16 = 9;
                } else if (e16 instanceof SecurityException) {
                    i16 = 8;
                }
                j jVar2 = this.f344844r;
                if (jVar2 != null) {
                    jVar2.a(1, i16, e16.getMessage(), new Object[0]);
                }
            }
            if (this.E.tryAcquire(2500L, TimeUnit.MILLISECONDS)) {
                V = i3;
                String J = J(i3, z16);
                U = J;
                A(J);
                CameraMonitor.openCamera((CameraManager) com.tencent.qqcamerakit.capture.c.d().getSystemService("camera"), J, new a(currentTimeMillis), this.f344847u);
                return 0;
            }
            throw new Exception("[Camera2]openCamera2 time out waiting to lock camera opening.");
        }
        com.tencent.qqcamerakit.common.e.d("Camera2Control", 1, "[Camera2]openCamera2 hasOpened!");
        return 6;
    }

    public void g0(com.tencent.qqcamerakit.capture.d dVar) {
        Size[] outputSizes;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) dVar);
            return;
        }
        try {
            StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) this.f344833g.f344863b.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
            if (streamConfigurationMap != null && (outputSizes = streamConfigurationMap.getOutputSizes(35)) != null) {
                Size size = outputSizes[0];
                for (Size size2 : outputSizes) {
                    if (size2.getHeight() >= dVar.f344912b / 3 && size2.getHeight() * size2.getWidth() < size.getWidth() * size.getHeight()) {
                        size = size2;
                    }
                }
                j0(new com.tencent.qqcamerakit.capture.d(size.getWidth(), size.getHeight()));
            }
            if (this.f344837k == null) {
                j0(this.f344835i);
            }
        } catch (Exception unused) {
        }
    }

    public void h0(j jVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) jVar);
        } else {
            this.f344844r = jVar;
        }
    }

    public boolean i0(CameraHandler.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this, (Object) bVar)).booleanValue();
        }
        try {
            try {
                this.E.acquire();
            } catch (Exception e16) {
                com.tencent.qqcamerakit.common.e.a("Camera2Control", 1, "[Camera2] setCamera2ParamOnce, e:", e16);
            }
            if (!this.f344839m) {
                com.tencent.qqcamerakit.common.e.d("Camera2Control", 1, "[Camera2] setCamera2ParamOnce mIsOpened:" + this.f344839m);
            } else {
                if (bVar != null && bVar.f344779b != null && bVar.f344780c != null && bVar.f344781d != null) {
                    com.tencent.qqcamerakit.common.e.a("Camera2Control", 1, "[Camera2] setCamera2ParamOnce!");
                    t0(bVar.f344779b);
                    v0(bVar.f344780c);
                    j0(bVar.f344781d);
                    return true;
                }
                com.tencent.qqcamerakit.common.e.d("Camera2Control", 1, "[Camera2] setCamera2ParamOnce error!");
            }
            return false;
        } finally {
            this.E.release();
        }
    }

    public void j0(com.tencent.qqcamerakit.capture.d dVar) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) dVar);
            return;
        }
        if (com.tencent.qqcamerakit.common.e.f()) {
            Object[] objArr = new Object[1];
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[Camera2]setDarkModeSize:");
            if (dVar != null) {
                str = dVar.toString();
            } else {
                str = "";
            }
            sb5.append(str);
            objArr[0] = sb5.toString();
            com.tencent.qqcamerakit.common.e.e("Camera2Control", 2, objArr);
        }
        this.f344837k = dVar;
    }

    public com.tencent.qqcamerakit.capture.d k0(com.tencent.qqcamerakit.capture.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (com.tencent.qqcamerakit.capture.d) iPatchRedirector.redirect((short) 9, (Object) this, (Object) dVar);
        }
        if (dVar != null && dVar.f344911a > 0 && dVar.f344912b > 0) {
            g0(dVar);
            if (com.tencent.qqcamerakit.common.e.f()) {
                com.tencent.qqcamerakit.common.e.e("Camera2Control", 2, "[Camera2]setViewSize:" + dVar.toString());
            }
            return this.f344837k;
        }
        com.tencent.qqcamerakit.common.e.d("Camera2Control", 1, "[Camera2] setViewSize params error!");
        return null;
    }

    public void l0(int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, this, Integer.valueOf(i3), Long.valueOf(j3));
            return;
        }
        if (i3 == 0 && j3 == 0) {
            m0();
            return;
        }
        if (i3 == 0) {
            i3 = (int) ((this.H * this.I) / j3);
        }
        if (j3 == 0) {
            j3 = (this.H * this.I) / i3;
        }
        if (i3 == 0) {
            this.f344827a.set(CaptureRequest.CONTROL_AE_MODE, 1);
            this.f344827a.setTag(Long.valueOf(j3));
            H0(this.L);
        } else if (j3 == 0) {
            this.f344827a.set(CaptureRequest.CONTROL_AE_MODE, 1);
            this.f344827a.setTag(Integer.valueOf(i3));
            H0(this.L);
        } else {
            this.f344827a.set(CaptureRequest.CONTROL_AE_MODE, 0);
            this.f344827a.set(CaptureRequest.SENSOR_SENSITIVITY, Integer.valueOf(W(i3)));
            this.f344827a.set(CaptureRequest.SENSOR_EXPOSURE_TIME, Long.valueOf(V(j3)));
            this.f344827a.setTag(null);
            H0(this.L);
        }
    }

    public void m0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this);
        } else {
            this.f344827a.set(CaptureRequest.CONTROL_AE_MODE, 1);
            H0(this.K);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void n0(boolean z16) {
        boolean z17;
        CaptureRequest.Builder builder;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, z16);
            return;
        }
        if (this.f344841o && this.f344827a != null) {
            if (z16 && this.D != 2) {
                this.D = 2;
            } else if (!z16) {
                this.D = 0;
            } else {
                z17 = false;
                if (com.tencent.qqcamerakit.common.e.f()) {
                    com.tencent.qqcamerakit.common.e.d("Camera2Control", 2, "[Camera2]setFlashOn: ", z16 + ", mode:", Integer.valueOf(this.D), ", needUpdateView:", Boolean.valueOf(z17));
                }
                if (!z17 && (builder = this.f344827a) != null) {
                    builder.set(CaptureRequest.FLASH_MODE, Integer.valueOf(this.D));
                    G0();
                    return;
                }
                return;
            }
            z17 = true;
            if (com.tencent.qqcamerakit.common.e.f()) {
            }
            if (!z17) {
                return;
            } else {
                return;
            }
        }
        com.tencent.qqcamerakit.common.e.d("Camera2Control", 1, "[Camera2]setFlashOn error status!");
    }

    public void o0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this);
            return;
        }
        try {
            CaptureRequest.Builder builder = this.f344827a;
            if (builder != null) {
                builder.set(CaptureRequest.CONTROL_AF_MODE, 4);
                G0();
                com.tencent.qqcamerakit.common.e.e("Camera2Control", 1, "[Camera2] setFocusDefaultMode!");
            }
        } catch (Exception e16) {
            com.tencent.qqcamerakit.common.e.b("Camera2Control", 1, "[Camera2] setFocusDefaultMode exp:", e16);
        }
    }

    public void p0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, i3);
            return;
        }
        if (com.tencent.qqcamerakit.common.e.f()) {
            com.tencent.qqcamerakit.common.e.e("Camera2Control", 2, "[Camera2]setFocusMode:" + i3);
        }
        this.f344843q = i3;
    }

    public void q0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this);
            return;
        }
        try {
            CaptureRequest.Builder builder = this.f344827a;
            if (builder != null) {
                builder.set(CaptureRequest.CONTROL_AF_MODE, 3);
                G0();
                com.tencent.qqcamerakit.common.e.e("Camera2Control", 1, "[Camera2] setFocusRecordMode!");
            }
        } catch (Exception e16) {
            com.tencent.qqcamerakit.common.e.b("Camera2Control", 1, "[Camera2] setFocusRecordMode exp:", e16);
        }
    }

    public void r0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, i3);
            return;
        }
        float f16 = i3;
        float f17 = this.A + (f16 / 100.0f);
        if (Build.MANUFACTURER.equalsIgnoreCase("OPPO") && com.tencent.qqcamerakit.capture.camerastrategy.b.f344889a.toUpperCase().contains("PEGM00")) {
            y0(f17);
            return;
        }
        if (com.tencent.qqcamerakit.capture.camerastrategy.b.f344889a.toUpperCase().contains("GFY-AL00")) {
            com.tencent.qqcamerakit.common.e.e("Camera2Control", 1, "set zoom with new method");
            if (i3 < 0) {
                this.B = 0.0f;
            }
            if (i3 >= 0 && this.B > f16) {
                com.tencent.qqcamerakit.common.e.e("Camera2Control", 1, "mCurrentValue do not update");
                return;
            } else {
                this.B = Math.max(this.B, f16);
                z0(f17);
                return;
            }
        }
        x0(f17);
    }

    public boolean s0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, i3)).booleanValue();
        }
        int[] a16 = com.tencent.qqcamerakit.capture.camerastrategy.d.a(i3);
        if (com.tencent.qqcamerakit.common.e.f()) {
            com.tencent.qqcamerakit.common.e.e("Camera2Control", 2, "setParamsPreviewFps[fps_wanted=" + i3 + " force=false]");
        }
        if (a16 != null && a16.length >= 2) {
            this.f344838l = new Range<>(Integer.valueOf(a16[0]), Integer.valueOf(a16[1]));
            if (com.tencent.qqcamerakit.common.e.f()) {
                com.tencent.qqcamerakit.common.e.e("Camera2Control", 2, "[Camera2]setPreviewFps:[" + a16[0] + " " + a16[1] + "]");
            }
            return true;
        }
        if (com.tencent.qqcamerakit.common.e.f()) {
            com.tencent.qqcamerakit.common.e.e("Camera2Control", 2, "setParamsPreviewFps[getFpsRange=null]");
        }
        return false;
    }

    public boolean t0(com.tencent.qqcamerakit.capture.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, (Object) dVar)).booleanValue();
        }
        if (dVar != null && dVar.f344911a > 0 && dVar.f344912b > 0) {
            this.f344835i = dVar;
            if (com.tencent.qqcamerakit.common.e.f()) {
                com.tencent.qqcamerakit.common.e.e("Camera2Control", 2, "[Camera2]setPreviewSize:" + dVar.toString());
            }
            return true;
        }
        com.tencent.qqcamerakit.common.e.d("Camera2Control", 1, "[Camera2] setPreviewSize params error!");
        return false;
    }

    public void u0(SurfaceTexture surfaceTexture) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) surfaceTexture);
        } else {
            this.f344845s = surfaceTexture;
        }
    }

    public boolean v0(com.tencent.qqcamerakit.capture.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, (Object) dVar)).booleanValue();
        }
        if (dVar != null && dVar.f344911a > 0 && dVar.f344912b > 0) {
            this.f344836j = dVar;
            if (com.tencent.qqcamerakit.common.e.f()) {
                com.tencent.qqcamerakit.common.e.e("Camera2Control", 2, "[Camera2]setRawPictureSize:" + dVar.toString());
            }
            return true;
        }
        com.tencent.qqcamerakit.common.e.d("Camera2Control", 1, "[Camera2] setRawPictureSize params error!");
        return false;
    }

    public void x0(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, this, Float.valueOf(f16));
            return;
        }
        com.tencent.qqcamerakit.common.e.e("Camera2Control", 1, "set zoom with old method");
        Rect rect = (Rect) this.f344833g.f344863b.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
        int intValue = ((Float) this.f344833g.f344863b.get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM)).intValue();
        this.A = f16;
        if (f16 <= 0.0f) {
            this.A = 0.0f;
        } else {
            int i3 = this.G;
            if (f16 >= i3) {
                this.A = i3;
            }
        }
        float f17 = (this.A / this.G) / this.F;
        int centerX = rect.centerX();
        int centerY = rect.centerY();
        int i16 = rect.right;
        float f18 = centerX * f17;
        int i17 = (int) (((i16 - f18) - 1.0f) - (f18 + 16.0f));
        int i18 = rect.bottom;
        float f19 = f17 * centerY;
        int i19 = (int) (((i18 - f19) - 1.0f) - (16.0f + f19));
        if (i17 >= i16 / intValue && i19 >= i18 / intValue) {
            Rect rect2 = new Rect((int) (f18 + 40.0f), (int) (40.0f + f19), (rect.right - ((int) f18)) - 1, (rect.bottom - ((int) f19)) - 1);
            if (com.tencent.qqcamerakit.common.e.f()) {
                com.tencent.qqcamerakit.common.e.e("Camera2Control", 2, "[Camera2] setZoom mZoomValue:" + this.A + ", realRadio:" + intValue + ", minWidth:" + i17 + ", minHeight:" + i19 + ", rect:" + rect + ", destRect:" + rect2);
            }
            this.C = rect2;
            this.f344827a.set(CaptureRequest.SCALER_CROP_REGION, rect2);
            G0();
            return;
        }
        com.tencent.qqcamerakit.common.e.d("Camera2Control", 1, "[Camera2] setZoom out of region!");
    }

    public void y0(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, this, Float.valueOf(f16));
            return;
        }
        com.tencent.qqcamerakit.common.e.e("Camera2Control", 1, "set zoom with new method");
        float min = Math.min(100.0f, Math.max(0.0f, f16)) / 100.0f;
        com.tencent.qqcamerakit.common.e.e("Camera2Control", 1, "target zoom ratio is: ", Float.valueOf(min));
        Rect H = H(min);
        this.C = H;
        if (!H.isEmpty()) {
            this.f344827a.set(CaptureRequest.SCALER_CROP_REGION, this.C);
            G0();
        }
    }

    public void z(a.C9360a c9360a) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) c9360a);
            return;
        }
        if (this.f344830d == null) {
            return;
        }
        if (this.f344841o && !this.f344842p) {
            this.f344842p = true;
            Rect R2 = R(c9360a);
            if (R2 != null) {
                try {
                    this.f344827a.set(CaptureRequest.CONTROL_AF_REGIONS, new MeteringRectangle[]{new MeteringRectangle(R2, 1000)});
                    this.f344827a.set(CaptureRequest.CONTROL_AE_REGIONS, new MeteringRectangle[]{new MeteringRectangle(R2, 1000)});
                } catch (Exception e16) {
                    com.tencent.qqcamerakit.common.e.d("Camera2Control", 1, "[Camera2] autoFocus e:" + e16);
                    e16.printStackTrace();
                    return;
                }
            }
            this.f344827a.set(CaptureRequest.CONTROL_AF_MODE, 1);
            this.f344827a.set(CaptureRequest.CONTROL_AF_TRIGGER, 1);
            this.f344827a.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, 1);
            this.f344827a.setTag(c9360a);
            CameraMonitor.setRepeatingRequest(this.f344829c, this.f344827a.build(), this.J, this.f344847u);
            return;
        }
        com.tencent.qqcamerakit.common.e.d("Camera2Control", 1, "[Camera2] autoFocus not preview, mPreview:" + this.f344841o + ", mIsAutoFocusing:" + this.f344842p);
    }

    public void z0(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, this, Float.valueOf(f16));
            return;
        }
        float min = Math.min(100.0f, Math.max(0.0f, f16)) / 100.0f;
        com.tencent.qqcamerakit.common.e.e("Camera2Control", 1, "target zoom ratio is: ", Float.valueOf(min));
        Rect G = G(min);
        this.C = G;
        if (G != null && !G.isEmpty()) {
            this.f344827a.set(CaptureRequest.SCALER_CROP_REGION, this.C);
            G0();
        }
    }
}
