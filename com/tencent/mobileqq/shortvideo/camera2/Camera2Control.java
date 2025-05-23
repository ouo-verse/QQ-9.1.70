package com.tencent.mobileqq.shortvideo.camera2;

import android.annotation.TargetApi;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
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
import android.hardware.camera2.params.OutputConfiguration;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.Image;
import android.media.ImageReader;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Range;
import android.util.Size;
import android.view.Surface;
import com.samsung.android.sdk.camera.SCamera;
import com.samsung.android.sdk.camera.SCameraCaptureProcessor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.richmedia.view.CameraCover;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraControl;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.ah;
import com.tencent.qmethod.pandoraex.monitor.CameraMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.util.VersionUtils;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
@TargetApi(23)
/* loaded from: classes18.dex */
public class Camera2Control {
    private static boolean L = false;
    private static boolean M = false;
    private static int N = -1;
    private static boolean O = false;
    private static boolean P = false;
    private static int Q = 0;
    private static String R = "";
    private static String S = "";
    public static String T;
    private static Camera2Control U;
    private static HashMap<String, h> V = new HashMap<>();
    CameraCaptureSession.CaptureCallback E;
    private SCameraCaptureProcessor F;
    private CaptureRequest H;

    /* renamed from: a, reason: collision with root package name */
    private CaptureRequest.Builder f287790a;

    /* renamed from: b, reason: collision with root package name */
    private CaptureRequest f287791b;

    /* renamed from: c, reason: collision with root package name */
    private CameraCaptureSession f287792c;

    /* renamed from: d, reason: collision with root package name */
    private CameraDevice f287793d;

    /* renamed from: e, reason: collision with root package name */
    private ImageReader f287794e;

    /* renamed from: f, reason: collision with root package name */
    private ImageReader f287795f;

    /* renamed from: g, reason: collision with root package name */
    private h f287796g;

    /* renamed from: h, reason: collision with root package name */
    private CameraControl.b f287797h;

    /* renamed from: i, reason: collision with root package name */
    private CameraControl.b f287798i;

    /* renamed from: j, reason: collision with root package name */
    private CameraControl.b f287799j;

    /* renamed from: k, reason: collision with root package name */
    private Range<Integer> f287800k;

    /* renamed from: q, reason: collision with root package name */
    public i f287806q;

    /* renamed from: r, reason: collision with root package name */
    private SurfaceTexture f287807r;

    /* renamed from: s, reason: collision with root package name */
    private HandlerThread f287808s;

    /* renamed from: t, reason: collision with root package name */
    private Handler f287809t;

    /* renamed from: u, reason: collision with root package name */
    private Camera.PreviewCallback f287810u;

    /* renamed from: v, reason: collision with root package name */
    private j f287811v;

    /* renamed from: l, reason: collision with root package name */
    private boolean f287801l = false;

    /* renamed from: m, reason: collision with root package name */
    private boolean f287802m = false;

    /* renamed from: n, reason: collision with root package name */
    private boolean f287803n = false;

    /* renamed from: o, reason: collision with root package name */
    private boolean f287804o = false;

    /* renamed from: p, reason: collision with root package name */
    private int f287805p = -1;

    /* renamed from: w, reason: collision with root package name */
    private boolean f287812w = false;

    /* renamed from: y, reason: collision with root package name */
    private long f287814y = 0;

    /* renamed from: z, reason: collision with root package name */
    private Rect f287815z = new Rect(0, 0, 1, 1);
    private int A = -1;
    private Rect B = null;
    private int C = -1;
    private Semaphore D = new Semaphore(1);
    public boolean G = false;
    private long I = 0;
    private int J = 0;
    private CameraCaptureSession.CaptureCallback K = new e();

    /* renamed from: x, reason: collision with root package name */
    private com.tencent.mobileqq.shortvideo.camera2.f f287813x = new com.tencent.mobileqq.shortvideo.camera2.f(this);

    /* compiled from: P */
    /* loaded from: classes18.dex */
    private static class ImageSaveServer implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private final byte[] f287816d;

        /* renamed from: e, reason: collision with root package name */
        private final j f287817e;

        ImageSaveServer(byte[] bArr, j jVar) {
            this.f287816d = bArr;
            this.f287817e = jVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x006c  */
        /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            boolean z16;
            CameraCover.a aVar;
            String str = null;
            if (this.f287816d == null) {
                com.tencent.mobileqq.shortvideo.camera2.d.a(2, "[Camera2]ImageSaveServer params error!");
                CameraCover.a aVar2 = this.f287817e.f287831c;
                if (aVar2 != null) {
                    aVar2.a(null);
                    return;
                }
                return;
            }
            j jVar = this.f287817e;
            int b16 = com.tencent.mobileqq.shortvideo.camera2.d.b(jVar.f287834f, jVar.f287832d);
            j jVar2 = this.f287817e;
            try {
                BaseImageUtil.saveBitmapFileAsJPEG(com.tencent.mobileqq.camera.utils.a.a(this.f287816d, jVar2.f287830b, jVar2.f287833e, b16), this.f287817e.f287829a);
                z16 = true;
            } catch (Exception e16) {
                e16.printStackTrace();
                com.tencent.mobileqq.shortvideo.camera2.d.a(2, "[Camera2]ImageSaveServer Exception:" + e16);
                z16 = false;
                j jVar3 = this.f287817e;
                aVar = jVar3.f287831c;
                if (aVar != null) {
                }
            } catch (OutOfMemoryError e17) {
                com.tencent.mobileqq.shortvideo.camera2.d.a(2, "[Camera2]ImageSaveServer OutOfMemoryError:" + e17);
                z16 = false;
                j jVar32 = this.f287817e;
                aVar = jVar32.f287831c;
                if (aVar != null) {
                }
            }
            j jVar322 = this.f287817e;
            aVar = jVar322.f287831c;
            if (aVar != null) {
                if (z16) {
                    str = jVar322.f287829a.getAbsolutePath();
                }
                aVar.a(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a extends CameraDevice.StateCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f287818a;

        a(long j3) {
            this.f287818a = j3;
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onDisconnected(@NonNull CameraDevice cameraDevice) {
            com.tencent.mobileqq.shortvideo.camera2.d.a(2, "[Camera2]openCamera2 onDisconnected!");
            Camera2Control.this.f287801l = false;
            Camera2Control.this.f287802m = false;
            cameraDevice.close();
            Camera2Control.this.f287793d = null;
            Camera2Control.this.D.release();
            i iVar = Camera2Control.this.f287806q;
            if (iVar != null) {
                iVar.a(-105);
            }
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onError(@NonNull CameraDevice cameraDevice, int i3) {
            com.tencent.mobileqq.shortvideo.camera2.d.a(2, "[Camera2]openCamera2 onError, error:" + i3);
            Camera2Control.this.f287801l = false;
            Camera2Control.this.f287802m = false;
            cameraDevice.close();
            Camera2Control.this.f287793d = null;
            Camera2Control.this.D.release();
            i iVar = Camera2Control.this.f287806q;
            if (iVar != null) {
                iVar.a(-102);
            }
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onOpened(@NonNull CameraDevice cameraDevice) {
            com.tencent.mobileqq.shortvideo.camera2.d.a(1, "[Camera2]openCamera2 onOpen, cost:" + (System.currentTimeMillis() - this.f287818a));
            Camera2Control.this.f287793d = cameraDevice;
            Camera2Control.this.f287801l = true;
            Camera2Control.this.f287802m = false;
            Camera2Control.this.D.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class b extends CameraCaptureSession.StateCallback {
        b() {
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigureFailed(@NonNull CameraCaptureSession cameraCaptureSession) {
            com.tencent.mobileqq.shortvideo.camera2.d.a(2, "[Camera2]startPreview onConfigureFailed!");
            Camera2Control.this.f287803n = false;
            Camera2Control.this.D.release();
            i iVar = Camera2Control.this.f287806q;
            if (iVar != null) {
                iVar.a(-202);
            }
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigured(@NonNull CameraCaptureSession cameraCaptureSession) {
            com.tencent.mobileqq.shortvideo.camera2.d.a(1, "[Camera2]startPreview onConfigured!");
            Camera2Control.this.f287803n = true;
            Camera2Control.this.f287792c = cameraCaptureSession;
            Camera2Control.this.f287790a.set(CaptureRequest.CONTROL_AF_MODE, 4);
            Camera2Control.this.f287790a.set(CaptureRequest.CONTROL_AE_MODE, 1);
            Camera2Control.this.f287790a.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, Camera2Control.this.f287800k);
            Camera2Control camera2Control = Camera2Control.this;
            if (camera2Control.G) {
                camera2Control.H = camera2Control.F.buildCaptureRequest(Camera2Control.this.f287790a);
                Camera2Control camera2Control2 = Camera2Control.this;
                camera2Control2.E = camera2Control2.F.createCaptureCallback(Camera2Control.this.f287813x, Camera2Control.this.f287809t);
            } else {
                camera2Control.f287791b = camera2Control.f287790a.build();
            }
            Camera2Control.this.t0();
            Camera2Control.this.D.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class c implements ImageReader.OnImageAvailableListener {
        c() {
        }

        @Override // android.media.ImageReader.OnImageAvailableListener
        public void onImageAvailable(ImageReader imageReader) {
            try {
                com.tencent.mobileqq.shortvideo.camera2.d.a(1, "[Camera2]Image Capture cost:" + (((float) (System.currentTimeMillis() - Camera2Control.this.I)) / 1000.0f));
                com.tencent.mobileqq.shortvideo.camera2.c.b(2, Camera2Control.this.f287798i.f288111a * Camera2Control.this.f287798i.f288112b, System.currentTimeMillis() - Camera2Control.this.I);
                Image acquireNextImage = imageReader.acquireNextImage();
                if (acquireNextImage != null) {
                    ByteBuffer buffer = acquireNextImage.getPlanes()[0].getBuffer();
                    byte[] bArr = new byte[buffer.remaining()];
                    buffer.get(bArr);
                    if (Camera2Control.this.f287809t != null && Camera2Control.this.f287811v != null) {
                        Camera2Control.this.f287811v.f287834f = Camera2Control.this.f287796g.f287828b;
                        Camera2Control.this.f287809t.post(new ImageSaveServer(bArr, Camera2Control.this.f287811v));
                    }
                    acquireNextImage.close();
                }
            } catch (Exception e16) {
                com.tencent.mobileqq.shortvideo.camera2.d.a(1, "[Camera2] onImageAvailable mImageReader exception:" + e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class d implements ImageReader.OnImageAvailableListener {
        d() {
        }

        @Override // android.media.ImageReader.OnImageAvailableListener
        public void onImageAvailable(ImageReader imageReader) {
            try {
                Image acquireNextImage = imageReader.acquireNextImage();
                if (acquireNextImage != null) {
                    Camera.PreviewCallback previewCallback = Camera2Control.this.f287810u;
                    if (previewCallback != null) {
                        ByteBuffer buffer = acquireNextImage.getPlanes()[0].getBuffer();
                        byte[] bArr = new byte[buffer.remaining()];
                        buffer.get(bArr);
                        previewCallback.onPreviewFrame(bArr, null);
                    }
                    acquireNextImage.close();
                }
            } catch (Exception e16) {
                com.tencent.mobileqq.shortvideo.camera2.d.a(1, "[Camera2] onImageAvailable mPreviewReader exception:" + e16);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class e extends CameraCaptureSession.CaptureCallback {
        e() {
        }

        private void a(CaptureResult captureResult, CaptureRequest captureRequest) {
            Object tag = captureRequest.getTag();
            if (tag instanceof CameraProxy.f) {
                CameraProxy.f fVar = (CameraProxy.f) tag;
                if (!fVar.f288159f) {
                    Integer num = (Integer) captureResult.get(CaptureResult.CONTROL_AF_STATE);
                    com.tencent.mobileqq.shortvideo.camera2.d.a(1, "[Camera2] mAfCaptureCallback:" + num);
                    if (num == null) {
                        return;
                    }
                    if (4 == num.intValue() || 5 == num.intValue()) {
                        b(true, fVar);
                        return;
                    }
                    return;
                }
            }
            com.tencent.mobileqq.shortvideo.camera2.d.a(1, "[Camera2] mAfCaptureCallback handled!");
            Camera2Control.this.f287804o = false;
        }

        private void b(boolean z16, CameraProxy.f fVar) {
            CaptureRequest build;
            Camera2Control.this.f287804o = false;
            Camera2Control.this.f287790a.set(CaptureRequest.CONTROL_AF_TRIGGER, 2);
            try {
                com.tencent.mobileqq.shortvideo.camera2.d.a(1, "[Camera2] mAfCaptureCallback run, success:" + z16);
                Camera2Control.this.f287790a.set(CaptureRequest.CONTROL_AF_MODE, 4);
                CameraCaptureSession cameraCaptureSession = Camera2Control.this.f287792c;
                Camera2Control camera2Control = Camera2Control.this;
                if (camera2Control.G) {
                    build = camera2Control.F.buildCaptureRequest(Camera2Control.this.f287790a);
                } else {
                    build = camera2Control.f287790a.build();
                }
                CameraMonitor.setRepeatingRequest(cameraCaptureSession, build, null, null);
                i iVar = fVar.f288158e.f287836b;
                if (iVar != null && !fVar.f288159f) {
                    fVar.f288159f = true;
                    iVar.b(1, z16);
                }
            } catch (Exception e16) {
                com.tencent.mobileqq.shortvideo.camera2.d.a(2, "[Camera2] mAfCaptureCallback e:" + e16);
            }
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureCompleted(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
            a(totalCaptureResult, captureRequest);
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureFailed(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull CaptureFailure captureFailure) {
            com.tencent.mobileqq.shortvideo.camera2.d.a(2, "[Camera2] mAfCaptureCallback failure reason:" + captureFailure.getReason());
            Object tag = captureRequest.getTag();
            if (tag instanceof CameraProxy.f) {
                CameraProxy.f fVar = (CameraProxy.f) tag;
                if (!fVar.f288159f) {
                    b(false, fVar);
                    return;
                }
            }
            com.tencent.mobileqq.shortvideo.camera2.d.a(1, "[Camera2] mAfCaptureCallback handled!");
            Camera2Control.this.f287804o = false;
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureProgressed(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull CaptureResult captureResult) {
            a(captureResult, captureRequest);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class f extends CameraCaptureSession.CaptureCallback {
        f() {
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureCompleted(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
            com.tencent.mobileqq.shortvideo.camera2.d.a(1, "[Camera2]captureStillPicture completed!");
            Camera2Control.this.f287814y = 0L;
            Camera2Control.this.f287812w = false;
            Camera2Control.this.f287813x.b(0);
            Camera2Control.this.s0();
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureFailed(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull CaptureFailure captureFailure) {
            com.tencent.mobileqq.shortvideo.camera2.d.a(1, "[Camera2]captureStillPicture failed!");
            Camera2Control.this.f287814y = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class g extends SCameraCaptureProcessor.CaptureCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f287825a;

        g(long j3) {
            this.f287825a = j3;
        }

        @Override // com.samsung.android.sdk.camera.SCameraCaptureProcessor.CaptureCallback
        public void onError(int i3) {
            com.tencent.mobileqq.shortvideo.camera2.d.a(1, "[Camera2]Samsung Capture onError:" + i3);
            Camera2Control.this.f287814y = 0L;
        }

        @Override // com.samsung.android.sdk.camera.SCameraCaptureProcessor.CaptureCallback
        public void onPictureAvailable(ByteBuffer byteBuffer) {
            com.tencent.mobileqq.shortvideo.camera2.d.a(1, "[Camera2]Samsung Capture cost:" + (((float) (System.currentTimeMillis() - this.f287825a)) / 1000.0f));
            com.tencent.mobileqq.shortvideo.camera2.c.b(2, Camera2Control.this.J, System.currentTimeMillis() - this.f287825a);
            if (Camera2Control.this.f287809t != null && Camera2Control.this.f287811v != null && byteBuffer != null) {
                byte[] bArr = new byte[byteBuffer.remaining()];
                byteBuffer.get(bArr);
                Camera2Control.this.f287811v.f287834f = Camera2Control.this.f287796g.f287828b;
                Camera2Control.this.f287809t.post(new ImageSaveServer(bArr, Camera2Control.this.f287811v));
            }
            Camera2Control.this.f287814y = 0L;
            Camera2Control.this.f287812w = false;
            Camera2Control.this.f287813x.b(0);
            Camera2Control.this.s0();
        }

        @Override // com.samsung.android.sdk.camera.SCameraCaptureProcessor.CaptureCallback
        public void onShutter() {
            com.tencent.mobileqq.shortvideo.camera2.d.a(1, "[Camera2]samsungCapture onShutter!");
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class h {

        /* renamed from: a, reason: collision with root package name */
        public String f287827a;

        /* renamed from: b, reason: collision with root package name */
        public CameraCharacteristics f287828b;

        public h(String str, CameraCharacteristics cameraCharacteristics) {
            this.f287827a = str;
            this.f287828b = cameraCharacteristics;
        }

        public boolean a() {
            if (!TextUtils.isEmpty(this.f287827a) && this.f287828b != null) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface i {
        void a(int i3);

        void b(int i3, boolean z16);
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class j {

        /* renamed from: a, reason: collision with root package name */
        public File f287829a;

        /* renamed from: b, reason: collision with root package name */
        public Rect f287830b;

        /* renamed from: c, reason: collision with root package name */
        public CameraCover.a f287831c;

        /* renamed from: d, reason: collision with root package name */
        public int f287832d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f287833e;

        /* renamed from: f, reason: collision with root package name */
        public CameraCharacteristics f287834f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class k implements Comparator<Size> {
        k() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Size size, Size size2) {
            return Long.signum((size.getWidth() * size.getHeight()) - (size2.getWidth() * size2.getHeight()));
        }
    }

    private void A(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f287796g = V.get(str);
        }
    }

    private int C(int i3, int i16, int i17) {
        if (i3 > i17) {
            return i17;
        }
        if (i3 < i16) {
            return i16;
        }
        return i3;
    }

    private void E() {
        CameraCaptureSession cameraCaptureSession = this.f287792c;
        if (cameraCaptureSession != null) {
            cameraCaptureSession.close();
            this.f287792c = null;
        }
    }

    public static String F(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                return R;
            }
            if (O()) {
                return R;
            }
        } else if (P()) {
            return S;
        }
        return "1";
    }

    private static int[] I(List<int[]> list, int i3) {
        ArrayList<int[]> arrayList = new ArrayList();
        for (int[] iArr : list) {
            if (iArr[1] >= i3) {
                arrayList.add(iArr);
            }
        }
        int[] iArr2 = null;
        int i16 = 0;
        for (int[] iArr3 : arrayList) {
            int i17 = iArr3[1] - iArr3[0];
            if (i17 > i16) {
                iArr2 = iArr3;
                i16 = i17;
            }
        }
        if (iArr2 != null) {
            return iArr2;
        }
        return N(list);
    }

    public static Camera2Control J() {
        if (U == null) {
            synchronized (Camera2Control.class) {
                if (U == null) {
                    U = new Camera2Control();
                }
            }
        }
        return U;
    }

    private static int[] N(List<int[]> list) {
        int i3;
        int[] iArr = null;
        for (int[] iArr2 : list) {
            if (iArr == null || ((i3 = iArr2[0]) <= 15 && iArr2[1] - i3 > iArr[1] - iArr[0])) {
                iArr = iArr2;
            }
        }
        return iArr;
    }

    public static boolean O() {
        if (Q > 0 && !TextUtils.isEmpty(R)) {
            return true;
        }
        return false;
    }

    public static boolean P() {
        if (Q > 0 && !TextUtils.isEmpty(S)) {
            return true;
        }
        return false;
    }

    private static void Q() {
        if (P) {
            return;
        }
        try {
            if (VersionUtils.isM() && T()) {
                CameraManager cameraManager = (CameraManager) BaseApplicationImpl.getApplication().getSystemService("camera");
                for (String str : cameraManager.getCameraIdList()) {
                    CameraCharacteristics cameraCharacteristics = cameraManager.getCameraCharacteristics(str);
                    Integer num = (Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_FACING);
                    if (num != null && num.intValue() == 0 && "1".equals(str)) {
                        V.put(str, new h(str, cameraCharacteristics));
                        S = str;
                        Q++;
                    } else if (num != null && num.intValue() == 1 && "0".equals(str)) {
                        V.put(str, new h(str, cameraCharacteristics));
                        R = str;
                        Q++;
                    }
                }
                com.tencent.mobileqq.shortvideo.camera2.d.a(1, "[Camera2]initCamera2Ability front:" + S + ", back:" + R);
            }
        } catch (Exception unused) {
            Q = 1;
            R = "1";
            com.tencent.mobileqq.shortvideo.camera2.d.a(2, "[Camera2]initCamera2Ability exception!");
        }
        P = true;
    }

    public static int R() {
        if (O) {
            return N;
        }
        CameraManager cameraManager = (CameraManager) BaseApplicationImpl.getApplication().getSystemService("camera");
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
                    CameraCharacteristics cameraCharacteristics = cameraManager.getCameraCharacteristics(cameraIdList[i16]);
                    Integer num = (Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_FACING);
                    if (num == null || num.intValue() != 2) {
                        Integer num2 = (Integer) cameraCharacteristics.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
                        com.tencent.mobileqq.shortvideo.camera2.d.a(1, "[Camera2]initCamera2SupportLevel supportLevel:" + num2);
                        if (num2 == null) {
                            i3 = -1;
                            break;
                        }
                        i3 = num2.intValue();
                        if (num2.intValue() == 1 || num2.intValue() == 3) {
                            break;
                        }
                    }
                    i16++;
                }
            }
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.e("Camera2Control", 2, "[Camera2]initCamera2SupportLevel exception:", th5);
            }
        }
        N = i3;
        O = true;
        return i3;
    }

    private int S(int i3) {
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
        return ((((Integer) this.f287796g.f287828b.get(CameraCharacteristics.SENSOR_ORIENTATION)).intValue() - i16) + 360) % 360;
    }

    public static boolean T() {
        if (M) {
            return L;
        }
        int R2 = R();
        boolean z16 = true;
        if (R2 != 1 && R2 != 3) {
            z16 = false;
        }
        L = z16;
        return z16;
    }

    private void V() {
        CaptureRequest build;
        try {
            this.f287790a.set(CaptureRequest.CONTROL_AF_TRIGGER, 1);
            this.f287813x.b(1);
            CameraCaptureSession cameraCaptureSession = this.f287792c;
            if (this.G) {
                build = this.F.buildCaptureRequest(this.f287790a);
            } else {
                build = this.f287790a.build();
            }
            cameraCaptureSession.capture(build, this.f287813x, this.f287809t);
        } catch (CameraAccessException e16) {
            e16.printStackTrace();
        }
    }

    private void j0() {
        CameraControl.b bVar = this.f287798i;
        ImageReader newInstance = ImageReader.newInstance(bVar.f288111a, bVar.f288112b, 256, 2);
        this.f287794e = newInstance;
        newInstance.setOnImageAvailableListener(new c(), this.f287809t);
        CameraControl.b bVar2 = this.f287799j;
        ImageReader newInstance2 = ImageReader.newInstance(bVar2.f288111a, bVar2.f288112b, 35, 2);
        this.f287795f = newInstance2;
        newInstance2.setOnImageAvailableListener(new d(), null);
    }

    private void m0() {
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("Camera2_Background_Thread");
        this.f287808s = baseHandlerThread;
        baseHandlerThread.start();
        this.f287809t = new Handler(this.f287808s.getLooper());
    }

    private void o0() {
        this.f287808s.quitSafely();
        try {
            this.f287808s.join();
            this.f287808s = null;
            this.f287809t = null;
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private void q0() {
        boolean z16;
        if (ah.p0() && Build.VERSION.SDK_INT >= 28) {
            try {
                if (!TextUtils.isEmpty(S) && !TextUtils.isEmpty(R)) {
                    boolean isFeatureEnabled = SCamera.getInstance().isFeatureEnabled(BaseApplicationImpl.getApplication(), S, 1);
                    boolean isFeatureEnabled2 = SCamera.getInstance().isFeatureEnabled(BaseApplicationImpl.getApplication(), R, 1);
                    if (isFeatureEnabled && isFeatureEnabled2) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    this.G = z16;
                    Size size = (Size) Collections.max(Arrays.asList(((StreamConfigurationMap) this.f287796g.f287828b.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP)).getOutputSizes(256)), new k());
                    if (this.G) {
                        this.J = size.getHeight() * size.getWidth();
                        SCameraCaptureProcessor sCameraCaptureProcessor = SCameraCaptureProcessor.getInstance();
                        this.F = sCameraCaptureProcessor;
                        sCameraCaptureProcessor.initialize(BaseApplicationImpl.getApplication(), T, size);
                    }
                    com.tencent.mobileqq.shortvideo.camera2.d.a(1, "[Camera2]openCamera2 Samsung Sfront:" + isFeatureEnabled + ", Sback:" + isFeatureEnabled2 + ", picSize:" + size.toString());
                }
            } catch (Throwable th5) {
                com.tencent.mobileqq.shortvideo.camera2.d.a(2, "[Camera2]openCamera2 Samsung Phone e:" + th5.getCause());
                this.G = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0() {
        CaptureRequest build;
        CaptureRequest captureRequest;
        try {
            this.f287790a.set(CaptureRequest.CONTROL_AF_TRIGGER, 2);
            this.f287790a.set(CaptureRequest.FLASH_MODE, 0);
            CameraCaptureSession cameraCaptureSession = this.f287792c;
            if (this.G) {
                build = this.F.buildCaptureRequest(this.f287790a);
            } else {
                build = this.f287790a.build();
            }
            cameraCaptureSession.capture(build, null, null);
            CameraCaptureSession cameraCaptureSession2 = this.f287792c;
            if (this.G) {
                captureRequest = this.H;
            } else {
                captureRequest = this.f287791b;
            }
            CameraMonitor.setRepeatingRequest(cameraCaptureSession2, captureRequest, null, null);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t0() {
        CaptureRequest build;
        if (this.f287793d == null) {
            return;
        }
        try {
            CameraCaptureSession cameraCaptureSession = this.f287792c;
            if (this.G) {
                build = this.F.buildCaptureRequest(this.f287790a);
            } else {
                build = this.f287790a.build();
            }
            CameraMonitor.setRepeatingRequest(cameraCaptureSession, build, null, null);
        } catch (Exception e16) {
            e16.printStackTrace();
            com.tencent.mobileqq.shortvideo.camera2.d.a(2, "[Camera2]updatePreview exp:" + e16);
        }
    }

    public void B() {
        try {
            com.tencent.mobileqq.shortvideo.camera2.d.a(1, "[Camera2]captureStillPicture request!");
            if (this.f287814y > 0) {
                com.tencent.mobileqq.shortvideo.camera2.d.a(1, "[Camera2]captureStillPicture on id:" + this.f287814y);
                return;
            }
            this.f287814y = System.currentTimeMillis();
            if (!this.G) {
                CaptureRequest.Builder createCaptureRequest = CameraMonitor.createCaptureRequest(this.f287793d, 2);
                createCaptureRequest.addTarget(this.f287794e.getSurface());
                createCaptureRequest.set(CaptureRequest.CONTROL_AF_MODE, 4);
                int i3 = this.C;
                if (i3 > -1) {
                    createCaptureRequest.set(CaptureRequest.FLASH_MODE, Integer.valueOf(i3));
                }
                Rect rect = this.B;
                if (rect != null) {
                    createCaptureRequest.set(CaptureRequest.SCALER_CROP_REGION, rect);
                }
                this.I = System.currentTimeMillis();
                this.f287792c.capture(createCaptureRequest.build(), new f(), null);
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(new SCameraCaptureProcessor.CaptureParameter(CaptureRequest.CONTROL_AF_MODE, 4));
            int i16 = this.C;
            if (i16 > -1) {
                arrayList.add(new SCameraCaptureProcessor.CaptureParameter(CaptureRequest.FLASH_MODE, Integer.valueOf(i16)));
            }
            Rect rect2 = this.B;
            if (rect2 != null) {
                arrayList.add(new SCameraCaptureProcessor.CaptureParameter(CaptureRequest.SCALER_CROP_REGION, rect2));
            }
            this.F.capture(this.f287792c, new g(System.currentTimeMillis()), null, arrayList);
        } catch (Exception unused) {
        }
    }

    public void D() {
        try {
            try {
                SCameraCaptureProcessor sCameraCaptureProcessor = this.F;
                if (sCameraCaptureProcessor != null) {
                    sCameraCaptureProcessor.deinitialize();
                    this.F = null;
                }
                this.D.acquire();
                E();
                CameraDevice cameraDevice = this.f287793d;
                if (cameraDevice != null) {
                    cameraDevice.close();
                    this.f287793d = null;
                }
                if (this.f287806q != null) {
                    this.f287806q = null;
                }
                ImageReader imageReader = this.f287794e;
                if (imageReader != null) {
                    imageReader.close();
                    this.f287794e = null;
                }
                ImageReader imageReader2 = this.f287795f;
                if (imageReader2 != null) {
                    imageReader2.close();
                    this.f287795f = null;
                }
                if (this.f287807r != null) {
                    this.f287807r = null;
                }
                if (this.f287796g != null) {
                    this.f287796g = null;
                }
                if (this.f287810u != null) {
                    this.f287810u = null;
                }
                if (this.B != null) {
                    this.B = null;
                }
                if (this.f287791b != null) {
                    this.f287791b = null;
                }
                if (this.H != null) {
                    this.H = null;
                }
                if (this.E != null) {
                    this.E = null;
                }
                o0();
                this.A = -1;
                this.C = -1;
                this.f287801l = false;
                this.f287803n = false;
                this.f287812w = false;
                this.f287804o = false;
                this.f287814y = 0L;
                com.tencent.mobileqq.shortvideo.camera2.d.a(1, "[Camera2]closeCamera2!");
            } catch (Exception e16) {
                this.f287801l = false;
                this.f287803n = false;
                this.f287812w = false;
                this.f287804o = false;
                com.tencent.mobileqq.shortvideo.camera2.d.a(1, "[Camera2]closeCamera2 exception:" + e16);
            }
        } finally {
            this.D.release();
        }
    }

    public h G() {
        return this.f287796g;
    }

    public CameraControl.b H() {
        return this.f287799j;
    }

    public Rect K(CameraProxy.f fVar) {
        com.tencent.mobileqq.shortvideo.camera2.e eVar;
        int i3;
        int i16;
        double d16;
        double d17;
        double d18;
        CaptureRequest captureRequest;
        double d19;
        double d26;
        if (fVar != null && (eVar = fVar.f288156c) != null) {
            double d27 = eVar.f287837a;
            double d28 = eVar.f287838b;
            eVar.f287841e = S(eVar.f287841e);
            CameraControl.b bVar = this.f287797h;
            int i17 = bVar.f288111a;
            int i18 = bVar.f288112b;
            com.tencent.mobileqq.shortvideo.camera2.e eVar2 = fVar.f288156c;
            int i19 = eVar2.f287841e;
            if (90 != i19 && 270 != i19) {
                i16 = i18;
                i3 = i17;
            } else {
                i3 = i18;
                i16 = i17;
            }
            int i26 = eVar2.f287839c;
            int i27 = i16 * i26;
            int i28 = eVar2.f287840d;
            double d29 = 0.0d;
            if (i27 > i3 * i28) {
                d17 = (i26 * 1.0d) / i3;
                d18 = (i16 - (i28 / d17)) / 2.0d;
                d16 = 0.0d;
            } else {
                double d36 = (i28 * 1.0d) / i16;
                d16 = (i3 - (i26 / d36)) / 2.0d;
                d17 = d36;
                d18 = 0.0d;
            }
            double d37 = (d27 / d17) + d16;
            double d38 = (d28 / d17) + d18;
            if (90 == i19) {
                double d39 = i18 - d37;
                d37 = d38;
                d38 = d39;
            } else if (270 == i19) {
                double d46 = i17 - d38;
                d38 = d37;
                d37 = d46;
            }
            if (this.G) {
                captureRequest = this.H;
            } else {
                captureRequest = this.f287791b;
            }
            Rect rect = (Rect) captureRequest.get(CaptureRequest.SCALER_CROP_REGION);
            if (rect == null) {
                com.tencent.mobileqq.shortvideo.camera2.d.a(2, "[Camera2]getMeteringRect can't get crop region");
                rect = this.f287815z;
            }
            int width = rect.width();
            int height = rect.height();
            CameraControl.b bVar2 = this.f287797h;
            int i29 = bVar2.f288112b;
            int i36 = i29 * width;
            int i37 = bVar2.f288111a;
            if (i36 > i37 * height) {
                d19 = (height * 1.0d) / i29;
                d26 = 0.0d;
                d29 = (width - (i37 * d19)) / 2.0d;
            } else {
                d19 = (width * 1.0d) / i37;
                d26 = (height - (i29 * d19)) / 2.0d;
            }
            double d47 = (d37 * d19) + d29 + rect.left;
            double d48 = (d38 * d19) + d26 + rect.top;
            Rect rect2 = new Rect();
            rect2.left = C((int) (d47 - (rect.width() * 0.05d)), 0, rect.width());
            rect2.right = C((int) (d47 + (rect.width() * 0.05d)), 0, rect.width());
            rect2.top = C((int) (d48 - (rect.height() * 0.05d)), 0, rect.height());
            rect2.bottom = C((int) (d48 + (0.05d * rect.height())), 0, rect.height());
            return rect2;
        }
        return null;
    }

    public List<int[]> L() {
        h hVar = this.f287796g;
        if (hVar != null && hVar.a()) {
            Range[] rangeArr = (Range[]) this.f287796g.f287828b.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES);
            ArrayList arrayList = new ArrayList();
            if (rangeArr != null) {
                for (Range range : rangeArr) {
                    arrayList.add(new int[]{((Integer) range.getLower()).intValue(), ((Integer) range.getUpper()).intValue()});
                }
            }
            return arrayList;
        }
        QLog.e("Camera2Control", 1, "[Camera2]getPreviewFps error, camera2Info: ", this.f287796g);
        return null;
    }

    public CameraControl.b M() {
        return this.f287797h;
    }

    public boolean U() {
        return this.f287802m;
    }

    public int W(int i3, i iVar) {
        if (com.tencent.mobileqq.activity.richmedia.d.a()) {
            com.tencent.mobileqq.shortvideo.camera2.d.a(2, "[Camera2]openCamera2 AVcamera2Used!");
            return -101;
        }
        if (!this.f287801l && !this.f287802m) {
            this.f287802m = true;
            long currentTimeMillis = System.currentTimeMillis();
            if (iVar == null) {
                com.tencent.mobileqq.shortvideo.camera2.d.a(2, "[Camera2]openCamera2 params Error!");
                return -103;
            }
            Q();
            Y(iVar);
            m0();
            CameraManager cameraManager = (CameraManager) BaseApplicationImpl.getApplication().getSystemService("camera");
            try {
            } catch (Exception e16) {
                com.tencent.mobileqq.shortvideo.camera2.d.a(2, "[Camera2]openCamera2 exception:" + e16);
                ms.a.f("Camera2Control", "\u3010Camera2 Open\u3011openCamera2 exception:" + e16);
                this.f287801l = false;
                this.f287802m = false;
                this.f287793d = null;
                this.D.release();
                i iVar2 = this.f287806q;
                if (iVar2 != null) {
                    iVar2.a(-102);
                }
            }
            if (this.D.tryAcquire(2500L, TimeUnit.MILLISECONDS)) {
                String F = F(i3);
                T = F;
                A(F);
                q0();
                CameraDevice.StateCallback aVar = new a(currentTimeMillis);
                ms.a.f("Camera2Control", "\u3010Camera2 Open\u3011");
                if (this.G) {
                    aVar = this.F.createStateCallback(aVar, this.f287809t);
                }
                CameraMonitor.openCamera(cameraManager, F, aVar, this.f287809t);
                return 0;
            }
            throw new Exception("[Camera2]openCamera2 time out waiting to lock camera opening.");
        }
        com.tencent.mobileqq.shortvideo.camera2.d.a(2, "[Camera2]openCamera2 hasOpened!");
        return -104;
    }

    public void X(CameraControl.b bVar) {
        Size[] outputSizes;
        try {
            StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) this.f287796g.f287828b.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
            if (streamConfigurationMap != null && (outputSizes = streamConfigurationMap.getOutputSizes(35)) != null) {
                Size size = outputSizes[0];
                for (Size size2 : outputSizes) {
                    if (size2.getHeight() >= bVar.f288112b / 3 && size2.getHeight() * size2.getWidth() < size.getWidth() * size.getHeight()) {
                        size = size2;
                    }
                }
                a0(new CameraControl.b(size.getWidth(), size.getHeight()));
            }
            if (this.f287799j == null) {
                a0(this.f287797h);
            }
        } catch (Exception unused) {
        }
    }

    public void Y(i iVar) {
        this.f287806q = iVar;
    }

    public boolean Z(CameraProxy.h hVar) {
        if (!this.f287801l) {
            com.tencent.mobileqq.shortvideo.camera2.d.a(2, "[Camera2] setCamera2ParamOnce mIsOpened:" + this.f287801l);
            return false;
        }
        if (hVar != null && hVar.f288169b != null && hVar.f288170c != null && hVar.f288171d != null) {
            com.tencent.mobileqq.shortvideo.camera2.d.a(1, "[Camera2] setCamera2ParamOnce!");
            g0(hVar.f288169b);
            i0(hVar.f288170c);
            a0(hVar.f288171d);
            return true;
        }
        com.tencent.mobileqq.shortvideo.camera2.d.a(2, "[Camera2] setCamera2ParamOnce error!");
        return false;
    }

    public void a0(CameraControl.b bVar) {
        String str;
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[Camera2]setDarkModeSize:");
            if (bVar != null) {
                str = bVar.toString();
            } else {
                str = "";
            }
            sb5.append(str);
            QLog.i("Camera2Control", 2, sb5.toString());
        }
        this.f287799j = bVar;
    }

    public void b0(boolean z16) {
        boolean z17;
        CaptureRequest.Builder builder;
        if (this.f287803n && this.f287790a != null) {
            if (z16 && this.C != 2) {
                this.C = 2;
            } else {
                z17 = false;
                if (!z16) {
                    this.C = 0;
                }
                com.tencent.mobileqq.shortvideo.camera2.d.a(1, "[Camera2]setFlashOn: " + z16 + ", mode:" + this.C + ", needUpdateView:" + z17);
                if (!z17 && (builder = this.f287790a) != null) {
                    builder.set(CaptureRequest.FLASH_MODE, Integer.valueOf(this.C));
                    t0();
                    return;
                }
                return;
            }
            z17 = true;
            com.tencent.mobileqq.shortvideo.camera2.d.a(1, "[Camera2]setFlashOn: " + z16 + ", mode:" + this.C + ", needUpdateView:" + z17);
            if (!z17) {
                return;
            } else {
                return;
            }
        }
        com.tencent.mobileqq.shortvideo.camera2.d.a(1, "[Camera2]setFlashOn error status!");
    }

    public void c0() {
        try {
            CaptureRequest.Builder builder = this.f287790a;
            if (builder != null) {
                builder.set(CaptureRequest.CONTROL_AF_MODE, 4);
                t0();
                com.tencent.mobileqq.shortvideo.camera2.d.a(1, "[Camera2] setFocusDefaultMode!");
            }
        } catch (Exception e16) {
            com.tencent.mobileqq.shortvideo.camera2.d.a(2, "[Camera2] setFocusDefaultMode exp:" + e16);
        }
    }

    public void d0() {
        try {
            CaptureRequest.Builder builder = this.f287790a;
            if (builder != null) {
                builder.set(CaptureRequest.CONTROL_AF_MODE, 3);
                t0();
                com.tencent.mobileqq.shortvideo.camera2.d.a(1, "[Camera2] setFocusRecordMode!");
            }
        } catch (Exception e16) {
            com.tencent.mobileqq.shortvideo.camera2.d.a(2, "[Camera2] setFocusRecordMode exp:" + e16);
        }
    }

    public void e0(Camera.PreviewCallback previewCallback) {
        this.f287810u = previewCallback;
    }

    public boolean f0(int i3) {
        List<int[]> L2 = J().L();
        if (L2 == null) {
            QLog.e("Camera2Control", 1, "[Camera2]getPreviewFps error, listPreviewFpsRange null");
            return false;
        }
        int[] I = I(L2, i3);
        if (QLog.isColorLevel()) {
            QLog.i("Camera2Control", 2, "setParamsPreviewFps[fps_wanted=" + i3 + " force=false]");
        }
        if (I != null && I.length >= 2) {
            this.f287800k = new Range<>(Integer.valueOf(I[0]), Integer.valueOf(I[1]));
            if (QLog.isColorLevel()) {
                QLog.i("Camera2Control", 2, "[Camera2]setPreviewFps:[" + I[0] + " " + I[1] + "]");
            }
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.i("Camera2Control", 2, "setParamsPreviewFps[getFpsRange=null]");
        }
        return false;
    }

    public boolean g0(CameraControl.b bVar) {
        if (bVar != null && bVar.f288111a > 0 && bVar.f288112b > 0) {
            this.f287797h = bVar;
            if (QLog.isColorLevel()) {
                QLog.i("Camera2Control", 2, "[Camera2]setPreviewSize:" + bVar.toString());
                return true;
            }
            return true;
        }
        com.tencent.mobileqq.shortvideo.camera2.d.a(2, "[Camera2] setPreviewSize params error!");
        return false;
    }

    public void h0(SurfaceTexture surfaceTexture) {
        this.f287807r = surfaceTexture;
    }

    public boolean i0(CameraControl.b bVar) {
        if (bVar != null && bVar.f288111a > 0 && bVar.f288112b > 0) {
            this.f287798i = bVar;
            if (QLog.isColorLevel()) {
                QLog.i("Camera2Control", 2, "[Camera2]setRawPictureSize:" + bVar.toString());
                return true;
            }
            return true;
        }
        com.tencent.mobileqq.shortvideo.camera2.d.a(2, "[Camera2] setRawPictureSize params error!");
        return false;
    }

    public CameraControl.b k0(CameraControl.b bVar) {
        if (bVar != null && bVar.f288111a > 0 && bVar.f288112b > 0) {
            X(bVar);
            if (QLog.isColorLevel()) {
                QLog.i("Camera2Control", 2, "[Camera2]setViewSize:" + bVar.toString());
            }
            return this.f287799j;
        }
        com.tencent.mobileqq.shortvideo.camera2.d.a(2, "[Camera2] setViewSize params error!");
        return null;
    }

    public void l0(int i3) {
        Rect rect = (Rect) this.f287796g.f287828b.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
        int intValue = ((Float) this.f287796g.f287828b.get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM)).intValue();
        int i16 = this.A + i3;
        this.A = i16;
        if (i16 <= 0) {
            this.A = 0;
        } else if (i16 >= 100) {
            this.A = 100;
        }
        float f16 = this.A / 100.0f;
        int centerX = rect.centerX();
        int centerY = rect.centerY();
        int i17 = rect.right;
        float f17 = (centerX * f16) / 0.4f;
        int i18 = (int) (((i17 - f17) - 1.0f) - (f17 + 16.0f));
        int i19 = rect.bottom;
        float f18 = (f16 * centerY) / 0.4f;
        int i26 = (int) (((i19 - f18) - 1.0f) - (16.0f + f18));
        if (i18 >= i17 / intValue && i26 >= i19 / intValue) {
            Rect rect2 = new Rect((int) (f17 + 40.0f), (int) (40.0f + f18), (rect.right - ((int) f17)) - 1, (rect.bottom - ((int) f18)) - 1);
            com.tencent.mobileqq.shortvideo.camera2.d.a(1, "[Camera2] setZoom mZoomValue:" + this.A + ", realRadio:" + intValue + ", minWidth:" + i18 + ", minHeight:" + i26 + ", rect:" + rect.toString() + ", destRect:" + rect2.toString());
            this.B = rect2;
            this.f287790a.set(CaptureRequest.SCALER_CROP_REGION, rect2);
            t0();
            return;
        }
        com.tencent.mobileqq.shortvideo.camera2.d.a(1, "[Camera2] setZoom out of region!");
    }

    public void n0(SurfaceTexture surfaceTexture) {
        try {
            this.D.acquire();
            if (this.f287793d != null && this.f287801l) {
                if (surfaceTexture == null) {
                    com.tencent.mobileqq.shortvideo.camera2.d.a(2, "[Camera2] startPreview params exception!");
                    i iVar = this.f287806q;
                    if (iVar != null) {
                        iVar.a(-203);
                    }
                    this.D.release();
                    return;
                }
                h0(surfaceTexture);
                j0();
                E();
                SurfaceTexture surfaceTexture2 = this.f287807r;
                CameraControl.b bVar = this.f287797h;
                surfaceTexture2.setDefaultBufferSize(bVar.f288111a, bVar.f288112b);
                Surface surface = new Surface(this.f287807r);
                CaptureRequest.Builder createCaptureRequest = CameraMonitor.createCaptureRequest(this.f287793d, 3);
                this.f287790a = createCaptureRequest;
                createCaptureRequest.addTarget(surface);
                this.f287790a.addTarget(this.f287795f.getSurface());
                b bVar2 = new b();
                if (this.G) {
                    this.f287793d.createCaptureSession(this.F.createSessionConfiguration(Arrays.asList(new OutputConfiguration(surface), new OutputConfiguration(this.f287795f.getSurface())), bVar2, this.f287809t));
                    return;
                } else {
                    this.f287793d.createCaptureSession(Arrays.asList(surface, this.f287795f.getSurface(), this.f287794e.getSurface()), bVar2, this.f287809t);
                    return;
                }
            }
            com.tencent.mobileqq.shortvideo.camera2.d.a(2, "[Camera2] startPreview mCameraDevice null!");
            i iVar2 = this.f287806q;
            if (iVar2 != null) {
                iVar2.a(-203);
            }
            this.D.release();
        } catch (Exception e16) {
            com.tencent.mobileqq.shortvideo.camera2.d.a(2, "[Camera2]startPreview exception:" + e16);
            this.f287803n = false;
            this.D.release();
            i iVar3 = this.f287806q;
            if (iVar3 != null) {
                iVar3.a(-202);
            }
        }
    }

    public void p0() {
        if (this.f287793d == null) {
            com.tencent.mobileqq.shortvideo.camera2.d.a(2, "[Camera2] stopRecordVideo device null!");
        } else {
            this.f287790a.set(CaptureRequest.FLASH_MODE, 0);
            t0();
        }
    }

    public void r0(j jVar) {
        if (!this.f287801l) {
            com.tencent.mobileqq.shortvideo.camera2.d.a(2, "[Camera2] camera not open");
            return;
        }
        if (this.f287812w) {
            com.tencent.mobileqq.shortvideo.camera2.d.a(2, "[Camera2] taking status!");
            return;
        }
        com.tencent.mobileqq.shortvideo.camera2.d.a(1, "[Camera2] takePicture request!");
        if (jVar == null) {
            com.tencent.mobileqq.shortvideo.camera2.d.a(2, "[Camera2] takePicture request exception!");
            return;
        }
        this.f287812w = true;
        this.f287811v = jVar;
        if (this.f287804o) {
            com.tencent.mobileqq.shortvideo.camera2.d.a(1, "[Camera2] takePicture AutoFocusing!");
            B();
        } else {
            V();
        }
    }

    public void z(CameraProxy.f fVar) {
        CaptureRequest build;
        if (this.f287793d == null) {
            return;
        }
        if (this.f287803n && !this.f287804o) {
            this.f287804o = true;
            this.f287815z = (Rect) this.f287796g.f287828b.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
            Rect K = K(fVar);
            if (K != null) {
                try {
                    this.f287790a.set(CaptureRequest.CONTROL_AF_REGIONS, new MeteringRectangle[]{new MeteringRectangle(K, 1000)});
                    this.f287790a.set(CaptureRequest.CONTROL_AE_REGIONS, new MeteringRectangle[]{new MeteringRectangle(K, 1000)});
                } catch (Exception e16) {
                    com.tencent.mobileqq.shortvideo.camera2.d.a(2, "[Camera2] autoFocus e:" + e16);
                    e16.printStackTrace();
                    return;
                }
            }
            this.f287790a.set(CaptureRequest.CONTROL_AF_MODE, 1);
            this.f287790a.set(CaptureRequest.CONTROL_AF_TRIGGER, 1);
            this.f287790a.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, 1);
            this.f287790a.setTag(fVar);
            CameraCaptureSession cameraCaptureSession = this.f287792c;
            if (this.G) {
                build = this.F.buildCaptureRequest(this.f287790a);
            } else {
                build = this.f287790a.build();
            }
            CameraMonitor.setRepeatingRequest(cameraCaptureSession, build, this.K, this.f287809t);
            return;
        }
        com.tencent.mobileqq.shortvideo.camera2.d.a(2, "[Camera2] autoFocus not preview, mPreview:" + this.f287803n + ", mIsAutoFocusing:" + this.f287804o);
    }
}
