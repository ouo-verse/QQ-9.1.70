package com.tencent.luggage.wxa.k;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.CamcorderProfile;
import android.media.Image;
import android.media.ImageReader;
import android.media.MediaRecorder;
import android.os.Handler;
import android.os.Looper;
import android.util.Size;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.view.Surface;
import com.tencent.luggage.wxa.k.i;
import com.tencent.luggage.wxa.k.o;
import com.tencent.luggage.wxa.l.a;
import com.tencent.qmethod.pandoraex.monitor.AudioMonitor;
import com.tencent.qmethod.pandoraex.monitor.CameraMonitor;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c extends com.tencent.luggage.wxa.k.i implements MediaRecorder.OnInfoListener, MediaRecorder.OnErrorListener {

    /* renamed from: m0, reason: collision with root package name */
    public static final SparseIntArray f131262m0;
    public float C;
    public boolean D;
    public Rect E;
    public float[] F;
    public boolean G;
    public boolean H;
    public final CameraDevice.StateCallback I;
    public final CameraCaptureSession.StateCallback J;
    public i K;
    public final ImageReader.OnImageAvailableListener L;
    public String M;
    public CameraCharacteristics N;
    public CameraDevice O;
    public CameraCaptureSession P;
    public CaptureRequest.Builder Q;
    public Set R;
    public ImageReader S;
    public ImageReader T;
    public int U;
    public MediaRecorder V;
    public String W;
    public boolean X;
    public final r Y;
    public final r Z;

    /* renamed from: a0, reason: collision with root package name */
    public q f131263a0;

    /* renamed from: b0, reason: collision with root package name */
    public int f131264b0;

    /* renamed from: c0, reason: collision with root package name */
    public com.tencent.luggage.wxa.k.a f131265c0;

    /* renamed from: d, reason: collision with root package name */
    public final CameraManager f131266d;

    /* renamed from: d0, reason: collision with root package name */
    public com.tencent.luggage.wxa.k.a f131267d0;

    /* renamed from: e, reason: collision with root package name */
    public Context f131268e;

    /* renamed from: e0, reason: collision with root package name */
    public int f131269e0;

    /* renamed from: f, reason: collision with root package name */
    public q f131270f;

    /* renamed from: f0, reason: collision with root package name */
    public int f131271f0;

    /* renamed from: g, reason: collision with root package name */
    public CameraManager.AvailabilityCallback f131272g;

    /* renamed from: g0, reason: collision with root package name */
    public float f131273g0;

    /* renamed from: h, reason: collision with root package name */
    public List f131274h;

    /* renamed from: h0, reason: collision with root package name */
    public float f131275h0;

    /* renamed from: i, reason: collision with root package name */
    public SparseBooleanArray f131276i;

    /* renamed from: i0, reason: collision with root package name */
    public int f131277i0;

    /* renamed from: j, reason: collision with root package name */
    public int f131278j;

    /* renamed from: j0, reason: collision with root package name */
    public boolean f131279j0;

    /* renamed from: k, reason: collision with root package name */
    public boolean f131280k;

    /* renamed from: k0, reason: collision with root package name */
    public Surface f131281k0;

    /* renamed from: l, reason: collision with root package name */
    public CamcorderProfile f131282l;

    /* renamed from: l0, reason: collision with root package name */
    public Rect f131283l0;

    /* renamed from: m, reason: collision with root package name */
    public int f131284m;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a extends CameraDevice.StateCallback {
        public a() {
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onClosed(CameraDevice cameraDevice) {
            c.this.f131280k = false;
            c.this.f131333a.a();
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onDisconnected(CameraDevice cameraDevice) {
            c.this.f131280k = false;
            c.this.O = null;
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onError(CameraDevice cameraDevice, int i3) {
            com.tencent.luggage.wxa.k.f.b("Camera2", "onError: " + cameraDevice.getId() + " (" + i3 + ")");
            c.this.f131280k = false;
            c.this.O = null;
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onOpened(CameraDevice cameraDevice) {
            c cVar = c.this;
            cVar.O = cameraDevice;
            cVar.f131333a.b();
            c.this.f131280k = true;
            c.this.S();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b extends CameraCaptureSession.StateCallback {
        public b() {
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onClosed(CameraCaptureSession cameraCaptureSession) {
            CameraCaptureSession cameraCaptureSession2 = c.this.P;
            if (cameraCaptureSession2 != null && cameraCaptureSession2.equals(cameraCaptureSession)) {
                c.this.P = null;
            }
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
            com.tencent.luggage.wxa.k.f.b("Camera2", "Failed to configure capture session.");
            if (!c.this.H) {
                c.this.O();
            } else {
                com.tencent.luggage.wxa.k.f.d("Camera2", "in safe open mode already, exit");
            }
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigured(CameraCaptureSession cameraCaptureSession) {
            c cVar = c.this;
            if (cVar.O == null) {
                return;
            }
            cVar.P = cameraCaptureSession;
            cVar.f131283l0 = (Rect) cVar.Q.get(CaptureRequest.SCALER_CROP_REGION);
            c.this.W();
            c.this.X();
            c.this.Y();
            c.this.Z();
            c.this.a0();
            try {
                c cVar2 = c.this;
                CameraMonitor.setRepeatingRequest(cVar2.P, cVar2.Q.build(), c.this.K, null);
            } catch (CameraAccessException e16) {
                com.tencent.luggage.wxa.k.f.a("Camera2", "Failed to start camera preview because it couldn't access camera", (Throwable) e16);
            } catch (IllegalStateException e17) {
                com.tencent.luggage.wxa.k.f.a("Camera2", "Failed to start camera preview.", (Throwable) e17);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.k.c$c, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6350c extends i {
        public C6350c() {
        }

        @Override // com.tencent.luggage.wxa.k.c.i
        public void a() {
            c.this.Q.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, 1);
            a(3);
            try {
                c cVar = c.this;
                CameraCaptureSession cameraCaptureSession = cVar.P;
                if (cameraCaptureSession != null) {
                    cameraCaptureSession.capture(cVar.Q.build(), this, null);
                }
                c.this.Q.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, 0);
            } catch (CameraAccessException | IllegalArgumentException | IllegalStateException e16) {
                com.tencent.luggage.wxa.k.f.a("Camera2", "Failed to run precapture sequence.", e16);
            }
        }

        @Override // com.tencent.luggage.wxa.k.c.i
        public void b() {
            c.this.G();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d implements ImageReader.OnImageAvailableListener {
        public d() {
        }

        @Override // android.media.ImageReader.OnImageAvailableListener
        public void onImageAvailable(ImageReader imageReader) {
            Image acquireNextImage = imageReader.acquireNextImage();
            if (acquireNextImage == null) {
                if (acquireNextImage != null) {
                    acquireNextImage.close();
                    return;
                }
                return;
            }
            try {
                if (acquireNextImage.getFormat() != 256) {
                    byte[] a16 = c.a(acquireNextImage);
                    if (a16 == null) {
                        acquireNextImage.close();
                        return;
                    }
                    int width = acquireNextImage.getWidth();
                    int height = acquireNextImage.getHeight();
                    Image.Plane plane = acquireNextImage.getPlanes()[0];
                    int pixelStride = plane.getPixelStride();
                    int rowStride = (plane.getRowStride() - (pixelStride * width)) / pixelStride;
                    if (c.this.D) {
                        o oVar = c.this.f131334b;
                        if ((oVar instanceof l) && ((l) oVar).k() != null) {
                            ((l) c.this.f131334b).k().onFrameData(a16);
                        }
                    }
                    c cVar = c.this;
                    cVar.f131333a.a(a16, width + rowStride, height, cVar.f131271f0);
                } else {
                    ByteBuffer buffer = acquireNextImage.getPlanes()[0].getBuffer();
                    byte[] bArr = new byte[buffer.remaining()];
                    buffer.get(bArr);
                    c.this.f131333a.a(bArr);
                }
                acquireNextImage.close();
            } catch (Throwable th5) {
                try {
                    acquireNextImage.close();
                } catch (Throwable th6) {
                    th5.addSuppressed(th6);
                }
                throw th5;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class e extends CameraManager.AvailabilityCallback {
        public e() {
        }

        @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
        public void onCameraAvailable(String str) {
            super.onCameraAvailable(str);
            c.this.R.add(str);
        }

        @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
        public void onCameraUnavailable(String str) {
            super.onCameraUnavailable(str);
            c.this.R.remove(str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class f implements o.a {
        public f() {
        }

        @Override // com.tencent.luggage.wxa.k.o.a
        public void a() {
            c.this.S();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CameraCaptureSession cameraCaptureSession = c.this.P;
            if (cameraCaptureSession != null) {
                cameraCaptureSession.close();
                c.this.P = null;
            }
            c.this.S();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class h extends CameraCaptureSession.CaptureCallback {
        public h() {
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
            c.this.V();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static abstract class i extends CameraCaptureSession.CaptureCallback {

        /* renamed from: a, reason: collision with root package name */
        public int f131293a;

        public abstract void a();

        public void a(int i3) {
            this.f131293a = i3;
        }

        public abstract void b();

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
            a(totalCaptureResult);
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureProgressed(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureResult captureResult) {
            a(captureResult);
        }

        public final void a(CaptureResult captureResult) {
            int i3 = this.f131293a;
            if (i3 == 1) {
                Integer num = (Integer) captureResult.get(CaptureResult.CONTROL_AF_STATE);
                if (num == null) {
                    return;
                }
                if (num.intValue() == 4 || num.intValue() == 5) {
                    Integer num2 = (Integer) captureResult.get(CaptureResult.CONTROL_AE_STATE);
                    if (num2 != null && num2.intValue() != 2) {
                        a(2);
                        a();
                        return;
                    } else {
                        a(5);
                        b();
                        return;
                    }
                }
                return;
            }
            if (i3 == 3) {
                Integer num3 = (Integer) captureResult.get(CaptureResult.CONTROL_AE_STATE);
                if (num3 == null || num3.intValue() == 5 || num3.intValue() == 4 || num3.intValue() == 2) {
                    a(4);
                    return;
                }
                return;
            }
            if (i3 != 4) {
                return;
            }
            Integer num4 = (Integer) captureResult.get(CaptureResult.CONTROL_AE_STATE);
            if (num4 == null || num4.intValue() != 5) {
                a(5);
                b();
            }
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f131262m0 = sparseIntArray;
        sparseIntArray.put(0, 1);
        sparseIntArray.put(1, 0);
    }

    public c(i.a aVar, o oVar, Context context) {
        super(aVar, oVar);
        int i3;
        this.f131270f = new q(0, 0);
        this.f131274h = new ArrayList();
        this.f131276i = new SparseBooleanArray();
        this.f131280k = false;
        this.I = new a();
        this.J = new b();
        this.K = new C6350c();
        this.L = new d();
        this.R = new HashSet();
        this.Y = new r();
        this.Z = new r();
        this.f131265c0 = j.f131336a;
        this.f131268e = context;
        this.D = com.tencent.luggage.wxa.pq.a.a(context);
        CameraManager cameraManager = (CameraManager) context.getSystemService("camera");
        this.f131266d = cameraManager;
        e eVar = new e();
        this.f131272g = eVar;
        cameraManager.registerAvailabilityCallback(eVar, (Handler) null);
        if (this.f131279j0) {
            i3 = 35;
        } else {
            i3 = 256;
        }
        this.U = i3;
        this.f131334b.a(new f());
    }

    @Override // com.tencent.luggage.wxa.k.i
    public boolean A() {
        if (((Float) this.N.get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM)).floatValue() > 0.0f) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.k.i
    public boolean C() {
        if (!H()) {
            this.f131265c0 = this.f131267d0;
            return false;
        }
        J();
        a(this.f131267d0);
        this.f131267d0 = null;
        Q();
        P();
        T();
        return true;
    }

    @Override // com.tencent.luggage.wxa.k.i
    public void D() {
        CameraManager.AvailabilityCallback availabilityCallback;
        CameraCaptureSession cameraCaptureSession = this.P;
        if (cameraCaptureSession != null) {
            cameraCaptureSession.close();
            this.P = null;
        }
        CameraDevice cameraDevice = this.O;
        if (cameraDevice != null) {
            cameraDevice.close();
            this.O = null;
        }
        ImageReader imageReader = this.S;
        if (imageReader != null) {
            imageReader.close();
            this.S = null;
        }
        ImageReader imageReader2 = this.T;
        if (imageReader2 != null) {
            imageReader2.close();
            this.T = null;
        }
        MediaRecorder mediaRecorder = this.V;
        if (mediaRecorder != null && this.X) {
            try {
                mediaRecorder.stop();
            } catch (IllegalStateException e16) {
                com.tencent.luggage.wxa.k.f.a("Camera2", "stop media record error", (Throwable) e16);
                e16.printStackTrace();
            }
            this.V.reset();
            this.V.release();
            this.V = null;
            if (this.X) {
                this.f131333a.a(this.W);
                this.X = false;
            }
        }
        CameraManager cameraManager = this.f131266d;
        if (cameraManager != null && (availabilityCallback = this.f131272g) != null) {
            cameraManager.unregisterAvailabilityCallback(availabilityCallback);
        }
    }

    @Override // com.tencent.luggage.wxa.k.i
    public void E() {
        if (this.X) {
            U();
            CameraCaptureSession cameraCaptureSession = this.P;
            if (cameraCaptureSession != null) {
                cameraCaptureSession.close();
                this.P = null;
            }
            S();
        }
    }

    @Override // com.tencent.luggage.wxa.k.i
    public void F() {
        if (this.f131276i.get(this.f131264b0)) {
            N();
        } else {
            G();
        }
    }

    public void G() {
        try {
            CaptureRequest.Builder createCaptureRequest = CameraMonitor.createCaptureRequest(this.O, 2);
            if (this.f131279j0) {
                this.U = 256;
                createCaptureRequest.removeTarget(this.T.getSurface());
            }
            createCaptureRequest.addTarget(this.S.getSurface());
            CaptureRequest.Key key = CaptureRequest.CONTROL_AF_MODE;
            createCaptureRequest.set(key, (Integer) this.Q.get(key));
            int i3 = this.f131269e0;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            if (i3 == 4) {
                                createCaptureRequest.set(CaptureRequest.CONTROL_AE_MODE, 2);
                            }
                        } else {
                            createCaptureRequest.set(CaptureRequest.CONTROL_AE_MODE, 2);
                        }
                    } else {
                        createCaptureRequest.set(CaptureRequest.CONTROL_AE_MODE, 1);
                        createCaptureRequest.set(CaptureRequest.FLASH_MODE, 2);
                    }
                } else {
                    createCaptureRequest.set(CaptureRequest.CONTROL_AE_MODE, 3);
                }
            } else {
                createCaptureRequest.set(CaptureRequest.CONTROL_AE_MODE, 1);
                createCaptureRequest.set(CaptureRequest.FLASH_MODE, 0);
            }
            createCaptureRequest.set(CaptureRequest.JPEG_ORIENTATION, Integer.valueOf(K()));
            CaptureRequest.Key key2 = CaptureRequest.SCALER_CROP_REGION;
            createCaptureRequest.set(key2, (Rect) this.Q.get(key2));
            CameraCaptureSession cameraCaptureSession = this.P;
            if (cameraCaptureSession == null) {
                com.tencent.luggage.wxa.k.f.d("Camera2", "mCaptureSession is null.");
            } else {
                cameraCaptureSession.stopRepeating();
                this.P.capture(createCaptureRequest.build(), new h(), null);
            }
        } catch (CameraAccessException | IllegalArgumentException | IllegalStateException e16) {
            com.tencent.luggage.wxa.k.f.a("Camera2", "Cannot capture a still picture.", e16);
        }
    }

    public final boolean H() {
        try {
            int i3 = f131262m0.get(this.f131264b0);
            String[] cameraIdList = this.f131266d.getCameraIdList();
            if (cameraIdList.length != 0) {
                for (String str : cameraIdList) {
                    CameraCharacteristics cameraCharacteristics = this.f131266d.getCameraCharacteristics(str);
                    Integer num = (Integer) cameraCharacteristics.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
                    if (num != null && num.intValue() != 2) {
                        Integer num2 = (Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_FACING);
                        if (num2 != null) {
                            if (num2.intValue() == i3) {
                                this.M = str;
                                this.N = cameraCharacteristics;
                                return true;
                            }
                        } else {
                            throw new NullPointerException("Unexpected state: LENS_FACING null");
                        }
                    }
                }
                String str2 = cameraIdList[0];
                this.M = str2;
                CameraCharacteristics cameraCharacteristics2 = this.f131266d.getCameraCharacteristics(str2);
                this.N = cameraCharacteristics2;
                Integer num3 = (Integer) cameraCharacteristics2.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
                if (num3 != null && num3.intValue() != 2) {
                    Integer num4 = (Integer) this.N.get(CameraCharacteristics.LENS_FACING);
                    if (num4 != null) {
                        int size = f131262m0.size();
                        for (int i16 = 0; i16 < size; i16++) {
                            SparseIntArray sparseIntArray = f131262m0;
                            if (sparseIntArray.valueAt(i16) == num4.intValue()) {
                                this.f131264b0 = sparseIntArray.keyAt(i16);
                                return true;
                            }
                        }
                        this.f131264b0 = 0;
                        return true;
                    }
                    throw new NullPointerException("Unexpected state: LENS_FACING null");
                }
                return false;
            }
            throw new RuntimeException("No camera available.");
        } catch (CameraAccessException e16) {
            throw new RuntimeException("Failed to get a list of camera devices", e16);
        }
    }

    public final q I() {
        int h16 = this.f131334b.h();
        int b16 = this.f131334b.b();
        if (h16 < b16) {
            b16 = h16;
            h16 = b16;
        }
        SortedSet<q> b17 = this.Y.b(this.f131265c0);
        for (q qVar : b17) {
            if (qVar.b() >= h16 && qVar.a() >= b16) {
                return qVar;
            }
        }
        return (q) b17.last();
    }

    public final void J() {
        StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) this.N.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        if (streamConfigurationMap != null) {
            f(this.f131271f0);
            this.f131274h.clear();
            this.Y.a();
            for (Size size : streamConfigurationMap.getOutputSizes(this.f131334b.c())) {
                int width = size.getWidth();
                int height = size.getHeight();
                this.f131274h.add(new q(width, height));
                if (width <= 1920 && height <= 1080) {
                    this.Y.a(new q(width, height));
                }
            }
            this.Z.a();
            a(this.Z, streamConfigurationMap);
            if (this.f131263a0 == null) {
                this.f131265c0 = a();
                a.c a16 = a(this.f131268e, new ArrayList(this.Z.b(this.f131265c0)));
                if (a16 != null) {
                    Point point = a16.f132753a;
                    this.f131263a0 = new q(point.x, point.y);
                } else {
                    this.f131263a0 = (q) this.Z.b(this.f131265c0).last();
                }
            }
            for (com.tencent.luggage.wxa.k.a aVar : this.Y.c()) {
                if (!this.Z.c().contains(aVar)) {
                    this.Y.a(aVar);
                }
            }
            if (!this.Y.c().contains(this.f131265c0)) {
                this.f131265c0 = (com.tencent.luggage.wxa.k.a) this.Y.c().iterator().next();
                return;
            }
            return;
        }
        throw new IllegalStateException("Failed to get configuration map: " + this.M);
    }

    public final int K() {
        int intValue = ((Integer) this.N.get(CameraCharacteristics.SENSOR_ORIENTATION)).intValue();
        int i3 = this.f131271f0;
        int i16 = 1;
        if (this.f131264b0 != 1) {
            i16 = -1;
        }
        return ((intValue + (i3 * i16)) + 360) % 360;
    }

    public Surface L() {
        Surface surface = this.f131281k0;
        if (surface != null) {
            return surface;
        }
        return this.f131334b.d();
    }

    public final void M() {
        float floatValue;
        CameraCharacteristics cameraCharacteristics = this.N;
        if (cameraCharacteristics == null) {
            return;
        }
        Float f16 = (Float) cameraCharacteristics.get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM);
        if (f16 == null) {
            floatValue = 0.0f;
        } else {
            floatValue = f16.floatValue();
        }
        float round = ((Math.round(Float.valueOf(floatValue).floatValue() * 10.0f) * 1.0f) / 10.0f) * 10.0f;
        this.F = new float[Math.round(round)];
        for (int i3 = 0; i3 < Math.round(round); i3++) {
            this.F[i3] = ((i3 * 1.0f) / 10.0f) + 1.0f;
        }
    }

    public final void N() {
        this.Q.set(CaptureRequest.CONTROL_AF_TRIGGER, 1);
        try {
            this.K.a(1);
            CameraCaptureSession cameraCaptureSession = this.P;
            if (cameraCaptureSession == null) {
                com.tencent.luggage.wxa.k.f.d("Camera2", "mCaptureSession is null.");
            } else {
                cameraCaptureSession.capture(this.Q.build(), this.K, null);
            }
        } catch (CameraAccessException | IllegalArgumentException | IllegalStateException e16) {
            com.tencent.luggage.wxa.k.f.a("Camera2", "Failed to lock focus.", e16);
        }
    }

    public final void O() {
        com.tencent.luggage.wxa.k.f.c("Camera2", "open camera in safe mode");
        this.H = true;
        this.f131263a0 = (q) this.Z.b(this.f131265c0).last();
        this.f131270f = (q) this.Y.b(this.f131265c0).last();
        Q();
        P();
        T();
        this.H = false;
    }

    public final void P() {
        ImageReader imageReader = this.T;
        if (imageReader != null) {
            imageReader.close();
        }
        R();
    }

    public final void Q() {
        ImageReader imageReader = this.S;
        if (imageReader != null) {
            imageReader.close();
        }
        ImageReader newInstance = ImageReader.newInstance(this.f131263a0.b(), this.f131263a0.a(), 256, 1);
        this.S = newInstance;
        newInstance.setOnImageAvailableListener(this.L, null);
    }

    public final void R() {
        int i3;
        int i16;
        if (this.H) {
            com.tencent.luggage.wxa.k.f.c("Camera2", "safeSetPreviewSize, in safe mode");
            q qVar = (q) this.Y.b(this.f131265c0).last();
            i3 = qVar.b();
            i16 = qVar.a();
        } else {
            a.c a16 = a(this.f131268e, new ArrayList(this.Y.b(this.f131265c0)));
            if (a16 == null) {
                com.tencent.luggage.wxa.k.f.c("Camera2", "can't find a suitable preview size!");
                q qVar2 = (q) this.Y.b(this.f131265c0).last();
                i3 = qVar2.b();
                i16 = qVar2.a();
            } else {
                Point point = a16.f132753a;
                i3 = point.x;
                i16 = point.y;
            }
        }
        this.f131270f = new q(i3, i16);
        ImageReader newInstance = ImageReader.newInstance(i3, i16, 35, 1);
        this.T = newInstance;
        newInstance.setOnImageAvailableListener(this.L, null);
        o oVar = this.f131334b;
        if (oVar != null && oVar.b() == 0 && this.f131334b.h() == 0) {
            int i17 = this.f131278j;
            if (i17 != 90 && i17 != 270) {
                this.f131334b.b(i3, i16);
            } else {
                this.f131334b.b(i16, i3);
            }
        }
    }

    public void S() {
        if (y() && this.f131334b.i() && this.S != null && this.T != null) {
            q I = I();
            this.f131334b.a(I.b(), I.a());
            Surface L = L();
            try {
                CaptureRequest.Builder createCaptureRequest = CameraMonitor.createCaptureRequest(this.O, 1);
                this.Q = createCaptureRequest;
                createCaptureRequest.addTarget(L);
                if (this.f131279j0) {
                    this.Q.addTarget(this.T.getSurface());
                }
                this.O.createCaptureSession(Arrays.asList(L, this.S.getSurface(), this.T.getSurface()), this.J, null);
            } catch (CameraAccessException | IllegalArgumentException | IllegalStateException e16) {
                com.tencent.luggage.wxa.k.f.a("Camera2", "startCaptureSession error", e16);
                this.f131333a.c();
            }
        }
    }

    public final void T() {
        a.c a16;
        try {
            CameraMonitor.openCamera(this.f131266d, this.M, this.I, (Handler) null);
            if ((this.f131334b instanceof l) && (a16 = a(this.f131268e, b(b()))) != null) {
                com.tencent.luggage.wxa.kb.a aVar = com.tencent.luggage.wxa.kb.a.f131893a;
                aVar.b(a16.f132753a.x);
                aVar.a(a16.f132753a.y);
                boolean z16 = true;
                if (g() != 1) {
                    z16 = false;
                }
                aVar.a(z16);
                aVar.c(e());
                ((l) this.f131334b).a(aVar);
            }
        } catch (CameraAccessException e16) {
            throw new RuntimeException("Failed to open camera: " + this.M, e16);
        }
    }

    public final void U() {
        this.X = false;
        try {
            CameraCaptureSession cameraCaptureSession = this.P;
            if (cameraCaptureSession != null) {
                cameraCaptureSession.stopRepeating();
                this.P.abortCaptures();
            }
            this.V.stop();
        } catch (Exception e16) {
            com.tencent.luggage.wxa.k.f.a("Camera2", "stop media recorder fail", (Throwable) e16);
        }
        this.V.reset();
        this.V.release();
        this.V = null;
        if (this.W != null && new File(this.W).exists()) {
            this.f131333a.a(this.W);
            this.W = null;
        } else {
            this.f131333a.a((String) null);
        }
    }

    public void V() {
        this.Q.set(CaptureRequest.CONTROL_AF_TRIGGER, 2);
        try {
            CameraCaptureSession cameraCaptureSession = this.P;
            if (cameraCaptureSession != null) {
                cameraCaptureSession.capture(this.Q.build(), this.K, null);
            }
            W();
            X();
            if (this.f131279j0) {
                this.U = 35;
                S();
                return;
            }
            this.Q.set(CaptureRequest.CONTROL_AF_TRIGGER, 0);
            CameraCaptureSession cameraCaptureSession2 = this.P;
            if (cameraCaptureSession2 != null) {
                CameraMonitor.setRepeatingRequest(cameraCaptureSession2, this.Q.build(), this.K, null);
            }
            this.K.a(0);
        } catch (CameraAccessException | IllegalArgumentException | IllegalStateException e16) {
            com.tencent.luggage.wxa.k.f.a("Camera2", "Failed to restart camera preview.", e16);
        }
    }

    public void W() {
        if (this.f131276i.get(this.f131264b0)) {
            int[] iArr = (int[]) this.N.get(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES);
            if (iArr != null && iArr.length != 0 && (iArr.length != 1 || iArr[0] != 0)) {
                this.Q.set(CaptureRequest.CONTROL_AF_MODE, 4);
                return;
            } else {
                this.f131276i.put(this.f131264b0, false);
                this.Q.set(CaptureRequest.CONTROL_AF_MODE, 0);
                return;
            }
        }
        this.Q.set(CaptureRequest.CONTROL_AF_MODE, 0);
    }

    public void X() {
        int i3 = this.f131269e0;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 == 4) {
                            this.Q.set(CaptureRequest.CONTROL_AE_MODE, 4);
                            this.Q.set(CaptureRequest.FLASH_MODE, 0);
                            return;
                        }
                        return;
                    }
                    this.Q.set(CaptureRequest.CONTROL_AE_MODE, 2);
                    this.Q.set(CaptureRequest.FLASH_MODE, 0);
                    return;
                }
                this.Q.set(CaptureRequest.CONTROL_AE_MODE, 1);
                this.Q.set(CaptureRequest.FLASH_MODE, 2);
                return;
            }
            this.Q.set(CaptureRequest.CONTROL_AE_MODE, 3);
            this.Q.set(CaptureRequest.FLASH_MODE, 0);
            return;
        }
        this.Q.set(CaptureRequest.CONTROL_AE_MODE, 1);
        this.Q.set(CaptureRequest.FLASH_MODE, 0);
    }

    public void Y() {
        if (this.f131276i.get(this.f131264b0)) {
            return;
        }
        Float f16 = (Float) this.N.get(CameraCharacteristics.LENS_INFO_MINIMUM_FOCUS_DISTANCE);
        if (f16 == null) {
            f16 = Float.valueOf(0.0f);
        }
        this.Q.set(CaptureRequest.LENS_FOCUS_DISTANCE, Float.valueOf(this.f131273g0 * f16.floatValue()));
    }

    public void Z() {
        int i3 = this.f131277i0;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 == 5) {
                                this.Q.set(CaptureRequest.CONTROL_AWB_MODE, 2);
                                return;
                            }
                            return;
                        }
                        this.Q.set(CaptureRequest.CONTROL_AWB_MODE, 3);
                        return;
                    }
                    this.Q.set(CaptureRequest.CONTROL_AWB_MODE, 8);
                    return;
                }
                this.Q.set(CaptureRequest.CONTROL_AWB_MODE, 5);
                return;
            }
            this.Q.set(CaptureRequest.CONTROL_AWB_MODE, 6);
            return;
        }
        this.Q.set(CaptureRequest.CONTROL_AWB_MODE, 1);
    }

    @Override // com.tencent.luggage.wxa.k.i
    public void a(float f16, float f17) {
    }

    public void a0() {
        float floatValue = (this.f131275h0 * (((Float) this.N.get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM)).floatValue() - 1.0f)) + 1.0f;
        Rect rect = (Rect) this.N.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
        if (rect != null) {
            int width = rect.width();
            int height = rect.height();
            int i3 = (width - ((int) (width / floatValue))) / 2;
            int i16 = (height - ((int) (height / floatValue))) / 2;
            Rect rect2 = new Rect(rect.left + i3, rect.top + i16, rect.right - i3, rect.bottom - i16);
            if (floatValue != 1.0f) {
                this.Q.set(CaptureRequest.SCALER_CROP_REGION, rect2);
            } else {
                this.Q.set(CaptureRequest.SCALER_CROP_REGION, this.f131283l0);
            }
        }
    }

    @Override // com.tencent.luggage.wxa.k.i
    public void b(boolean z16) {
    }

    @Override // com.tencent.luggage.wxa.k.i
    public void e(int i3) {
        int i16 = this.f131277i0;
        if (i16 == i3) {
            return;
        }
        this.f131277i0 = i3;
        if (this.P != null) {
            Z();
            try {
                CameraMonitor.setRepeatingRequest(this.P, this.Q.build(), this.K, null);
            } catch (CameraAccessException | IllegalArgumentException | IllegalStateException e16) {
                this.f131277i0 = i16;
                com.tencent.luggage.wxa.k.f.a("Camera2", "set white balance fail", e16);
            }
        }
    }

    @Override // com.tencent.luggage.wxa.k.i
    public float f() {
        return this.C;
    }

    public final boolean g(int i3) {
        return i3 == 90 || i3 == 270;
    }

    @Override // com.tencent.luggage.wxa.k.i
    public int h() {
        return this.f131269e0;
    }

    @Override // com.tencent.luggage.wxa.k.i
    public float j() {
        return this.f131273g0;
    }

    @Override // com.tencent.luggage.wxa.k.i
    public float l() {
        return ((Float) this.N.get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM)).floatValue();
    }

    @Override // com.tencent.luggage.wxa.k.i
    public q m() {
        return this.f131263a0;
    }

    @Override // com.tencent.luggage.wxa.k.i
    public r n() {
        return this.Z;
    }

    @Override // com.tencent.luggage.wxa.k.i
    public q o() {
        return this.f131270f;
    }

    @Override // android.media.MediaRecorder.OnErrorListener
    public void onError(MediaRecorder mediaRecorder, int i3, int i16) {
        E();
    }

    @Override // android.media.MediaRecorder.OnInfoListener
    public void onInfo(MediaRecorder mediaRecorder, int i3, int i16) {
        if (i3 == 800 || i3 == 801) {
            E();
        }
    }

    @Override // com.tencent.luggage.wxa.k.i
    public int p() {
        return this.f131284m;
    }

    @Override // com.tencent.luggage.wxa.k.i
    public r q() {
        return this.Y;
    }

    @Override // com.tencent.luggage.wxa.k.i
    public boolean r() {
        return this.f131279j0;
    }

    @Override // com.tencent.luggage.wxa.k.i
    public float[] s() {
        if (this.F == null) {
            M();
        }
        return this.F;
    }

    @Override // com.tencent.luggage.wxa.k.i
    public Set t() {
        return this.Y.c();
    }

    @Override // com.tencent.luggage.wxa.k.i
    public Point u() {
        CamcorderProfile camcorderProfile = this.f131282l;
        if (camcorderProfile == null) {
            return null;
        }
        return new Point(com.tencent.luggage.wxa.l.a.a(camcorderProfile.videoFrameWidth), com.tencent.luggage.wxa.l.a.a(camcorderProfile.videoFrameHeight));
    }

    @Override // com.tencent.luggage.wxa.k.i
    public int w() {
        return this.f131277i0;
    }

    @Override // com.tencent.luggage.wxa.k.i
    public float x() {
        return this.f131275h0;
    }

    @Override // com.tencent.luggage.wxa.k.i
    public boolean y() {
        if (this.O != null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.k.i
    public boolean z() {
        return this.f131280k;
    }

    @Override // com.tencent.luggage.wxa.k.i
    public boolean c() {
        return this.f131276i.get(this.f131264b0);
    }

    @Override // com.tencent.luggage.wxa.k.i
    public int d() {
        return Integer.parseInt(this.M);
    }

    public final int f(int i3) {
        CameraCharacteristics cameraCharacteristics = this.N;
        if (cameraCharacteristics == null) {
            return 0;
        }
        int intValue = ((Integer) cameraCharacteristics.get(CameraCharacteristics.SENSOR_ORIENTATION)).intValue();
        if (this.f131264b0 == 1) {
            this.f131278j = (intValue + i3) % 360;
        } else {
            this.f131278j = ((intValue + i3) + (g(i3) ? 180 : 0)) % 360;
        }
        return this.f131278j;
    }

    @Override // com.tencent.luggage.wxa.k.i
    public int g() {
        return this.f131264b0;
    }

    @Override // com.tencent.luggage.wxa.k.i
    public void c(int i3) {
        int i16 = this.f131269e0;
        if (i16 == i3) {
            return;
        }
        this.f131269e0 = i3;
        if (this.Q != null) {
            X();
            CameraCaptureSession cameraCaptureSession = this.P;
            if (cameraCaptureSession != null) {
                try {
                    CameraMonitor.setRepeatingRequest(cameraCaptureSession, this.Q.build(), this.K, null);
                } catch (CameraAccessException | IllegalArgumentException | IllegalStateException e16) {
                    this.f131269e0 = i16;
                    com.tencent.luggage.wxa.k.f.a("Camera2", "set flash fail", e16);
                }
            }
        }
    }

    @Override // com.tencent.luggage.wxa.k.i
    public void d(int i3) {
        this.f131284m = i3;
    }

    @Override // com.tencent.luggage.wxa.k.i
    public void b(int i3) {
        if (this.f131264b0 == i3) {
            return;
        }
        this.f131264b0 = i3;
        if (y()) {
            D();
            C();
        }
    }

    public static byte[] a(Image image) {
        byte[] bArr;
        ByteBuffer buffer = image.getPlanes()[0].getBuffer();
        ByteBuffer buffer2 = image.getPlanes()[1].getBuffer();
        ByteBuffer buffer3 = image.getPlanes()[2].getBuffer();
        int remaining = buffer.remaining();
        int remaining2 = buffer2.remaining();
        int remaining3 = buffer3.remaining();
        try {
            bArr = new byte[remaining + remaining2 + remaining3];
            try {
                buffer.get(bArr, 0, remaining);
                buffer3.get(bArr, remaining, remaining3);
                buffer2.get(bArr, remaining + remaining3, remaining2);
            } catch (OutOfMemoryError unused) {
                com.tencent.luggage.wxa.k.f.d("Camera2", "YUV_420_888toNV21 oom");
                return bArr;
            }
        } catch (OutOfMemoryError unused2) {
            bArr = null;
        }
        return bArr;
    }

    @Override // com.tencent.luggage.wxa.k.i
    public int e() {
        CameraCharacteristics cameraCharacteristics = this.N;
        if (cameraCharacteristics == null) {
            return 0;
        }
        return ((Integer) cameraCharacteristics.get(CameraCharacteristics.SENSOR_ORIENTATION)).intValue();
    }

    @Override // com.tencent.luggage.wxa.k.i
    public com.tencent.luggage.wxa.k.a b() {
        return this.f131265c0;
    }

    @Override // com.tencent.luggage.wxa.k.i
    public void b(float f16) {
        float f17 = this.f131273g0;
        if (f17 == f16) {
            return;
        }
        this.f131273g0 = f16;
        if (this.P != null) {
            Y();
            try {
                CameraMonitor.setRepeatingRequest(this.P, this.Q.build(), this.K, null);
            } catch (CameraAccessException | IllegalArgumentException | IllegalStateException e16) {
                this.f131273g0 = f17;
                com.tencent.luggage.wxa.k.f.a("Camera2", "set focus depth fail", e16);
            }
        }
    }

    @Override // com.tencent.luggage.wxa.k.i
    public void c(float f16) {
        float f17 = this.f131275h0;
        if (f17 == f16) {
            return;
        }
        this.f131275h0 = f16;
        if (this.P != null) {
            a0();
            try {
                CameraMonitor.setRepeatingRequest(this.P, this.Q.build(), this.K, null);
            } catch (CameraAccessException | IllegalArgumentException | IllegalStateException e16) {
                this.f131275h0 = f17;
                com.tencent.luggage.wxa.k.f.a("Camera2", "set zoom fail", e16);
            }
        }
    }

    @Override // com.tencent.luggage.wxa.k.i
    public void a(q qVar) {
        if (qVar == null) {
            return;
        }
        CameraCaptureSession cameraCaptureSession = this.P;
        if (cameraCaptureSession != null) {
            try {
                cameraCaptureSession.stopRepeating();
            } catch (CameraAccessException | IllegalArgumentException | IllegalStateException e16) {
                com.tencent.luggage.wxa.k.f.a("Camera2", "set picture size fail", e16);
            }
            this.P.close();
            this.P = null;
        }
        ImageReader imageReader = this.S;
        if (imageReader != null) {
            imageReader.close();
        }
        this.f131263a0 = qVar;
        Q();
        S();
    }

    public List b(com.tencent.luggage.wxa.k.a aVar) {
        return new ArrayList(this.Y.b(this.f131265c0));
    }

    public final void b(String str, int i3, int i16, boolean z16, CamcorderProfile camcorderProfile, boolean z17) {
        MediaRecorder mediaRecorder = new MediaRecorder();
        this.V = mediaRecorder;
        CameraMonitor.setVideoSource(mediaRecorder, 2);
        if (z16) {
            AudioMonitor.setAudioSource(this.V, 1);
        }
        this.V.setOutputFile(str);
        this.W = str;
        this.f131282l = camcorderProfile;
        if (z17) {
            a(camcorderProfile, z16);
        } else if (CamcorderProfile.hasProfile(d(), camcorderProfile.quality)) {
            a(camcorderProfile, z16);
        } else {
            a(CamcorderProfile.get(d(), 1), z16);
        }
        this.V.setOrientationHint(K());
        if (i3 != -1) {
            this.V.setMaxDuration(i3);
        }
        if (i16 != -1) {
            this.V.setMaxFileSize(i16);
        }
        this.V.setOnInfoListener(this);
        this.V.setOnErrorListener(this);
    }

    @Override // com.tencent.luggage.wxa.k.i
    public void c(boolean z16) {
        if (this.f131279j0 == z16) {
            return;
        }
        this.f131279j0 = z16;
        if (!z16) {
            this.U = 256;
        } else {
            this.U = 35;
        }
        CameraCaptureSession cameraCaptureSession = this.P;
        if (cameraCaptureSession != null) {
            cameraCaptureSession.close();
            this.P = null;
        }
        S();
    }

    @Override // com.tencent.luggage.wxa.k.i
    public void B() {
    }

    @Override // com.tencent.luggage.wxa.k.i
    public boolean a(com.tencent.luggage.wxa.k.a aVar) {
        if (aVar != null && this.Y.b()) {
            this.f131267d0 = aVar;
            return false;
        }
        if (aVar == null || aVar.equals(this.f131265c0) || !this.Y.c().contains(aVar)) {
            return false;
        }
        this.f131265c0 = aVar;
        a.c a16 = a(this.f131268e, new ArrayList(this.Z.b(this.f131265c0)));
        if (a16 != null) {
            Point point = a16.f132753a;
            this.f131263a0 = new q(point.x, point.y);
        } else {
            this.f131263a0 = (q) this.Z.b(this.f131265c0).last();
        }
        Q();
        P();
        CameraCaptureSession cameraCaptureSession = this.P;
        if (cameraCaptureSession == null) {
            return true;
        }
        cameraCaptureSession.close();
        this.P = null;
        S();
        return true;
    }

    @Override // com.tencent.luggage.wxa.k.i
    public void a(boolean z16) {
        if (this.f131276i.get(this.f131264b0) == z16) {
            return;
        }
        this.f131276i.put(this.f131264b0, z16);
        if (this.Q != null) {
            W();
            CameraCaptureSession cameraCaptureSession = this.P;
            if (cameraCaptureSession != null) {
                try {
                    CameraMonitor.setRepeatingRequest(cameraCaptureSession, this.Q.build(), this.K, null);
                } catch (CameraAccessException | IllegalArgumentException | IllegalStateException e16) {
                    this.f131276i.put(this.f131264b0, !r0.get(r1));
                    com.tencent.luggage.wxa.k.f.a("Camera2", "set auto focus fail", e16);
                }
            }
        }
    }

    @Override // com.tencent.luggage.wxa.k.i
    public boolean a(String str, int i3, int i16, boolean z16, CamcorderProfile camcorderProfile, boolean z17) {
        if (!this.X) {
            b(str, i3, i16, z16, camcorderProfile, z17);
            try {
                this.V.prepare();
                CameraCaptureSession cameraCaptureSession = this.P;
                if (cameraCaptureSession != null) {
                    cameraCaptureSession.close();
                    this.P = null;
                }
                q I = I();
                this.f131334b.a(I.b(), I.a());
                Surface L = L();
                Surface surface = this.V.getSurface();
                CaptureRequest.Builder createCaptureRequest = CameraMonitor.createCaptureRequest(this.O, 3);
                this.Q = createCaptureRequest;
                createCaptureRequest.addTarget(L);
                this.Q.addTarget(surface);
                this.O.createCaptureSession(Arrays.asList(L, surface), this.J, null);
                AudioMonitor.start(this.V);
                this.X = true;
                return true;
            } catch (CameraAccessException | IOException | IllegalArgumentException | IllegalStateException e16) {
                com.tencent.luggage.wxa.k.f.a("Camera2", "record fail", e16);
            }
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.k.i
    public void a(int i3) {
        f(i3);
        this.f131271f0 = i3;
        this.f131334b.a(i3);
    }

    @Override // com.tencent.luggage.wxa.k.i
    public void a(float f16) {
        this.C = f16;
    }

    public void a(r rVar, StreamConfigurationMap streamConfigurationMap) {
        for (Size size : streamConfigurationMap.getOutputSizes(this.U)) {
            this.Z.a(new q(size.getWidth(), size.getHeight()));
        }
    }

    @Override // com.tencent.luggage.wxa.k.i
    public void a(SurfaceTexture surfaceTexture) {
        Point point;
        if (surfaceTexture != null) {
            a.c a16 = a(this.f131268e, b(this.f131265c0));
            if (a16 != null && (point = a16.f132753a) != null) {
                surfaceTexture.setDefaultBufferSize(point.x, point.y);
            }
            this.f131281k0 = new Surface(surfaceTexture);
        } else {
            this.f131281k0 = null;
        }
        new Handler(Looper.getMainLooper()).post(new g());
    }

    @Override // com.tencent.luggage.wxa.k.i
    public void a(Float f16) {
        if (this.G) {
            com.tencent.luggage.wxa.k.f.a("Camera2", "setForceZoomTargetRatio, zooming, ignore");
            return;
        }
        if (!A()) {
            com.tencent.luggage.wxa.k.f.a("Camera2", "setForceZoomTargetRatio, zoom not supported");
            return;
        }
        CameraCharacteristics cameraCharacteristics = this.N;
        if (cameraCharacteristics == null || this.Q == null) {
            return;
        }
        try {
            Rect rect = (Rect) cameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
            int width = rect.width() - Math.round((rect.width() * 1.0f) / f16.floatValue());
            int height = rect.height() - Math.round((rect.height() * 1.0f) / f16.floatValue());
            Rect rect2 = new Rect(width / 2, height / 2, rect.width() - (width / 2), rect.height() - (height / 2));
            this.E = rect2;
            this.Q.set(CaptureRequest.SCALER_CROP_REGION, rect2);
            CameraCaptureSession cameraCaptureSession = this.P;
            if (cameraCaptureSession != null) {
                try {
                    CameraMonitor.setRepeatingRequest(cameraCaptureSession, this.Q.build(), this.K, null);
                } catch (CameraAccessException | IllegalArgumentException | IllegalStateException e16) {
                    com.tencent.luggage.wxa.k.f.a("Camera2", "set repeating fail", e16);
                }
            }
        } catch (Exception e17) {
            com.tencent.luggage.wxa.k.f.a("Camera2", "setForceZoomTargetRatio error: %s", e17.getMessage());
        } finally {
            this.G = false;
        }
    }

    public final void a(CamcorderProfile camcorderProfile, boolean z16) {
        this.V.setOutputFormat(camcorderProfile.fileFormat);
        this.V.setVideoFrameRate(camcorderProfile.videoFrameRate);
        this.V.setVideoSize(camcorderProfile.videoFrameWidth, camcorderProfile.videoFrameHeight);
        this.V.setVideoEncodingBitRate(camcorderProfile.videoBitRate);
        this.V.setVideoEncoder(camcorderProfile.videoCodec);
        if (z16) {
            this.V.setAudioEncodingBitRate(camcorderProfile.audioBitRate);
            this.V.setAudioChannels(camcorderProfile.audioChannels);
            this.V.setAudioSamplingRate(camcorderProfile.audioSampleRate);
            this.V.setAudioEncoder(camcorderProfile.audioCodec);
        }
    }
}
