package com.tencent.mobileqq.ocr;

import android.content.Context;
import android.graphics.PixelFormat;
import android.graphics.Point;
import android.graphics.RectF;
import android.hardware.Camera;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.view.OrientationEventListener;
import android.view.SurfaceHolder;
import com.tencent.aelight.camera.api.ICameraCompatible;
import com.tencent.av.camera.QavCameraUsage;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.ocr.api.IOCR;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qmethod.pandoraex.monitor.CameraMonitor;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.CameraUtil;
import com.tencent.util.WeakReferenceHandler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes16.dex */
public class OcrCamera implements Handler.Callback {
    static IPatchRedirector $redirector_;
    private int C;
    private int D;
    private boolean E;
    private boolean F;
    private volatile boolean G;
    private boolean H;
    SurfaceHolder I;
    WeakReferenceHandler J;
    e K;
    com.tencent.mobileqq.camera.a L;
    int M;
    int N;
    com.tencent.mobileqq.ar.arengine.a P;
    volatile boolean Q;
    volatile boolean R;
    OrientationEventListener S;
    byte[] T;
    int U;
    int V;
    private long W;
    public int X;
    int Y;
    Camera.PreviewCallback Z;

    /* renamed from: a0, reason: collision with root package name */
    public RectF f254556a0;

    /* renamed from: b0, reason: collision with root package name */
    byte[] f254557b0;

    /* renamed from: d, reason: collision with root package name */
    private long f254558d;

    /* renamed from: e, reason: collision with root package name */
    private Camera f254559e;

    /* renamed from: f, reason: collision with root package name */
    private int f254560f;

    /* renamed from: h, reason: collision with root package name */
    private int f254561h;

    /* renamed from: i, reason: collision with root package name */
    private int f254562i;

    /* renamed from: m, reason: collision with root package name */
    private int f254563m;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class a extends OrientationEventListener {
        static IPatchRedirector $redirector_;

        a(Context context) {
            super(context);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) OcrCamera.this, (Object) context);
            }
        }

        @Override // android.view.OrientationEventListener
        public void onOrientationChanged(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
                return;
            }
            if (i3 == -1) {
                OcrCamera.this.N = 0;
                return;
            }
            OcrCamera ocrCamera = OcrCamera.this;
            int i16 = ((i3 + 45) / 90) * 90;
            ocrCamera.N = i16;
            if (i16 < 0) {
                ocrCamera.N = 0;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class b implements Comparator<Camera.Size> {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) OcrCamera.this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Camera.Size size, Camera.Size size2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) size, (Object) size2)).intValue();
            }
            int i3 = size.height * size.width;
            int i16 = size2.height * size2.width;
            if (i16 < i3) {
                return 1;
            }
            if (i16 > i3) {
                return -1;
            }
            return 0;
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class c implements Camera.PreviewCallback {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) OcrCamera.this);
            }
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) bArr, (Object) camera2);
                return;
            }
            if (bArr == null) {
                return;
            }
            if ((OcrCamera.this.Q || OcrCamera.this.X == 1) && !OcrCamera.this.G) {
                OcrCamera ocrCamera = OcrCamera.this;
                ocrCamera.T = bArr;
                if (ocrCamera.X != 1) {
                    long currentTimeMillis = System.currentTimeMillis() - OcrCamera.this.f254558d;
                    OcrCamera ocrCamera2 = OcrCamera.this;
                    if (currentTimeMillis > ocrCamera2.U) {
                        ocrCamera2.f254558d = System.currentTimeMillis();
                        OcrCamera.this.t(bArr);
                    }
                }
            }
            OcrCamera.this.f254559e.addCallbackBuffer(bArr);
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class d implements Camera.PictureCallback {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) OcrCamera.this);
            }
        }

        @Override // android.hardware.Camera.PictureCallback
        public void onPictureTaken(byte[] bArr, Camera camera2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) bArr, (Object) camera2);
            } else {
                OcrCamera.this.p(bArr, true);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface e {
        void a(int i3, int i16, int i17, int i18);

        void b();

        void c(String str);

        void d(boolean z16);

        void e(boolean z16);

        void onStop(boolean z16);
    }

    public OcrCamera(Context context, e eVar, SurfaceHolder surfaceHolder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, eVar, surfaceHolder);
            return;
        }
        this.H = true;
        this.Q = true;
        this.R = true;
        this.X = 0;
        this.Y = 0;
        this.Z = new c();
        this.K = eVar;
        this.I = surfaceHolder;
        this.J = new WeakReferenceHandler(ThreadManagerV2.getSubThreadLooper(), this);
        this.L = com.tencent.mobileqq.camera.a.d();
        this.S = new a(context);
        com.tencent.mobileqq.ocr.data.b a16 = com.tencent.mobileqq.ocr.data.b.a();
        if (a16 != null) {
            this.U = a16.f254754j;
            int i3 = a16.f254749e * a16.f254750f;
            this.V = i3;
            if (i3 < 76800) {
                this.V = 921600;
            }
        } else {
            this.U = 100;
            this.V = 921600;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.ocr.camera", 2, "OcrCamera mFrameGap:" + this.U + ",mMaxPreviewPixels:" + this.V);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003c A[Catch: all -> 0x005f, TryCatch #2 {, blocks: (B:3:0x0001, B:8:0x0008, B:11:0x0010, B:16:0x001e, B:19:0x003c, B:20:0x003e, B:22:0x0044), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0044 A[Catch: all -> 0x005f, TRY_LEAVE, TryCatch #2 {, blocks: (B:3:0x0001, B:8:0x0008, B:11:0x0010, B:16:0x001e, B:19:0x003c, B:20:0x003e, B:22:0x0044), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized boolean A() {
        boolean z16;
        Camera camera2 = this.f254559e;
        z16 = false;
        if (camera2 != null) {
            try {
                camera2.setPreviewCallbackWithBuffer(null);
                this.f254559e.stopPreview();
                try {
                    this.S.disable();
                    B();
                    z16 = true;
                } catch (Exception e16) {
                    e = e16;
                    z16 = true;
                    QLog.d("Q.ocr.camera", 1, "stopPreview failed. error msg: " + e.getMessage());
                    if (z16) {
                    }
                    if (QLog.isColorLevel()) {
                    }
                    return z16;
                }
            } catch (Exception e17) {
                e = e17;
            }
        }
        if (z16) {
            this.F = true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.ocr.camera", 2, "stopPreviewInternal isSuc:" + z16);
        }
        return z16;
    }

    private boolean l(Camera camera2, int i3) {
        if (camera2 != null && i3 > 0) {
            int i16 = 0;
            for (int i17 = 0; i17 < 5; i17++) {
                try {
                    camera2.addCallbackBuffer(new byte[i3]);
                    i16++;
                } catch (Exception e16) {
                    e16.printStackTrace();
                    QLog.d("Q.ocr.camera", 1, "addCallbackBuffer failed. exp msg:" + e16.getMessage());
                } catch (OutOfMemoryError unused) {
                    if (i16 > 1) {
                        break;
                    }
                    URLDrawable.clearMemoryCache();
                    QLog.d("Q.ocr.camera", 1, "addCallbackBuffer failed. oom i:" + i17);
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("Q.ocr.camera", 2, "addCallbackBuffer count:" + i16 + ",bufSize:" + i3);
            }
            if (i16 <= 1) {
                return false;
            }
            return true;
        }
        QLog.d("Q.ocr.camera", 1, "addCallbackBuffer camera == null || bufSize <= 0");
        return false;
    }

    private synchronized boolean n() {
        boolean z16;
        Camera camera2 = this.f254559e;
        if (camera2 != null) {
            z16 = true;
            try {
                camera2.release();
            } catch (Exception e16) {
                this.f254559e = null;
                this.I = null;
                QLog.d("Q.ocr.camera", 1, "closeCamera failed. error msg: " + e16.getMessage());
            }
            this.f254557b0 = null;
        }
        z16 = false;
        this.f254557b0 = null;
        return z16;
    }

    private Point o(Camera camera2, int i3, int i16, boolean z16) {
        boolean z17;
        int i17;
        int i18;
        Camera.Parameters parameters = camera2.getParameters();
        Camera.Size previewSize = parameters.getPreviewSize();
        if (CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_SANXING.equalsIgnoreCase(Build.MANUFACTURER) && "GT-I9008L".equalsIgnoreCase(DeviceInfoMonitor.getModel())) {
            return new Point(previewSize.width, previewSize.height);
        }
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        if (z16) {
            supportedPreviewSizes = parameters.getSupportedPictureSizes();
        }
        if (supportedPreviewSizes == null) {
            return new Point(previewSize.width, previewSize.height);
        }
        ArrayList<Camera.Size> arrayList = new ArrayList(supportedPreviewSizes);
        Collections.sort(arrayList, new b());
        float f16 = i3 / i16;
        int i19 = this.V;
        if (z16) {
            i19 = 3686400;
        }
        Point point = null;
        float f17 = Float.POSITIVE_INFINITY;
        for (Camera.Size size : arrayList) {
            int i26 = size.width;
            int i27 = size.height;
            int i28 = i26 * i27;
            if (i28 >= 76800 && i28 <= i19 && (i26 != 980 || i27 != 800 || !CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_SANXING.equalsIgnoreCase(Build.MANUFACTURER) || (!"GT-I9220".equalsIgnoreCase(DeviceInfoMonitor.getModel()) && !"GT-N7000".equalsIgnoreCase(DeviceInfoMonitor.getModel())))) {
                if (((i26 != 1184 || i27 != 666) && (i26 != 704 || i27 != 576)) || !CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_SANXING.equalsIgnoreCase(Build.MANUFACTURER) || !"GT-I9300".equalsIgnoreCase(DeviceInfoMonitor.getModel())) {
                    boolean z18 = false;
                    if (i3 > i16) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (i26 < i27) {
                        z18 = true;
                    }
                    if (z17 == z18) {
                        i18 = i27;
                        i17 = i26;
                    } else {
                        i17 = i27;
                        i18 = i26;
                    }
                    if (i18 == i3 && i17 == i16) {
                        return new Point(i26, i27);
                    }
                    if (i18 >= (i3 >> 1) && (i18 >> 1) <= i3 && i17 >= (i16 >> 1) && (i17 >> 1) <= i16) {
                        float abs = Math.abs((i18 / i17) - f16);
                        if (abs <= f17) {
                            point = new Point(i26, i27);
                            f17 = abs;
                        }
                    }
                }
            }
        }
        if (point != null) {
            return point;
        }
        return new Point(previewSize.width, previewSize.height);
    }

    private synchronized int r() {
        int i3;
        int i16;
        if (QavCameraUsage.a(BaseApplication.getContext())) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.ocr.camera", 2, "openCamera take up!");
            }
            return -1001;
        }
        try {
            this.f254559e = CameraUtil.openCameraWithRetry();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (this.f254559e == null) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.ocr.camera", 2, "openCamera failed!");
            }
            return -1002;
        }
        this.M = com.tencent.mobileqq.shortvideo.mediadevice.a.b();
        x1.a.d(this.f254559e, 0, 0);
        if (((ICameraCompatible) QRoute.api(ICameraCompatible.class)).isFoundProduct(com.tencent.aelight.camera.constants.a.f68993g)) {
            i3 = 270;
        } else {
            i3 = 90;
        }
        this.f254559e.setDisplayOrientation(i3);
        Camera.Parameters parameters = this.f254559e.getParameters();
        PixelFormat pixelFormat = new PixelFormat();
        int previewFormat = parameters.getPreviewFormat();
        PixelFormat.getPixelFormatInfo(previewFormat, pixelFormat);
        Point o16 = o(this.f254559e, ScreenUtil.SCREEN_WIDTH, ScreenUtil.SCREEN_HIGHT, false);
        if (QLog.isColorLevel()) {
            QLog.d("Q.ocr.camera", 2, "openCamera bestPreviewSize:" + o16.x + "," + o16.y);
        }
        try {
            parameters.setPreviewSize(o16.x, o16.y);
            this.f254559e.setParameters(parameters);
        } catch (Exception e17) {
            e17.printStackTrace();
            QLog.d("Q.ocr.camera", 1, "openInternal setCamera Params1 exp " + e17.getMessage());
        }
        if (this.X == 1) {
            try {
                Camera.Parameters parameters2 = this.f254559e.getParameters();
                parameters2.setPictureFormat(256);
                parameters2.setJpegQuality(100);
                Point o17 = o(this.f254559e, ScreenUtil.SCREEN_WIDTH, ScreenUtil.SCREEN_HIGHT, true);
                int i17 = o17.x;
                if (i17 >= o16.x && (i16 = o17.y) >= o16.y) {
                    parameters2.setPictureSize(i17, i16);
                    this.f254559e.setParameters(parameters2);
                    Camera.Size pictureSize = parameters2.getPictureSize();
                    this.f254562i = pictureSize.width;
                    this.f254563m = pictureSize.height;
                    this.H = true;
                }
            } catch (Exception e18) {
                e18.printStackTrace();
                QLog.d("Q.ocr.camera", 1, "openInternal setCamera Params2 exp " + e18.getMessage());
                this.H = false;
            }
        }
        Camera.Size previewSize = parameters.getPreviewSize();
        this.f254560f = previewSize.width;
        this.f254561h = previewSize.height;
        this.C = previewFormat;
        this.D = pixelFormat.bitsPerPixel;
        if (QLog.isColorLevel()) {
            QLog.d("Q.ocr.camera", 2, "openCamera picWidth:" + this.f254560f + ",picHeight:" + this.f254561h + ",picFormat:" + this.C + "  mTakePicWidth:" + this.f254562i + "   mTakePicHeight:" + this.f254563m);
        }
        if (!x()) {
            return -1003;
        }
        this.S.enable();
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:22:0x007d A[Catch: all -> 0x0158, TryCatch #2 {, blocks: (B:4:0x0003, B:6:0x0008, B:7:0x0031, B:9:0x0035, B:10:0x003e, B:22:0x007d, B:24:0x00ff, B:27:0x0118, B:29:0x0124, B:32:0x0131, B:34:0x0135, B:35:0x0138, B:37:0x0153, B:42:0x005a), top: B:3:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void t(byte[] bArr) {
        boolean z16;
        if (this.R) {
            this.R = false;
            ReportController.o(null, "dc00898", "", "", "0X80082C1", "0X80082C1", 0, 0, "", "", "", "");
            this.W = System.currentTimeMillis();
        }
        if (this.P == null) {
            this.P = new com.tencent.mobileqq.ar.arengine.a(com.tencent.mobileqq.ar.arengine.a.f197965t);
        }
        if (this.Y >= 5) {
            return;
        }
        try {
            z16 = this.P.d(bArr, this.f254560f, this.f254561h);
        } catch (Throwable th5) {
            th = th5;
            z16 = false;
        }
        try {
            this.Y = 0;
        } catch (Throwable th6) {
            th = th6;
            this.Y++;
            QLog.d("Q.ocr.camera", 4, "selectImage error " + th.getMessage());
            if (z16) {
            }
        }
        if (z16) {
            long currentTimeMillis = System.currentTimeMillis() - this.W;
            QLog.d("Q.ocr.camera", 4, "select image isBest:" + z16 + ",costTime:" + currentTimeMillis);
            ReportController.o(null, "dc00898", "", "", "0X80082C3", "0X80082C3", 0, 0, "", "", "", "");
            ReportController.o(null, "dc00898", "", "", "0X80082C5", "0X80082C5", 0, 0, String.valueOf(currentTimeMillis), "", "", "");
            ThreadManagerV2.post(new Runnable(currentTimeMillis) { // from class: com.tencent.mobileqq.ocr.OcrCamera.4
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ long f254564d;

                {
                    this.f254564d = currentTimeMillis;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, OcrCamera.this, Long.valueOf(currentTimeMillis));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("costTime", String.valueOf(this.f254564d));
                    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "ocr_select_pic", true, 0L, 0L, hashMap, "", false);
                }
            }, 5, null, false);
            if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
                QLog.d("Q.ocr.camera", 1, "selectImage best but error!");
                QQToast.makeText(BaseApplication.getContext(), 1, R.string.fod, 0).show();
                return;
            }
            this.Q = false;
            this.R = true;
            byte[] a16 = this.P.a();
            if (a16 == null) {
                this.Q = true;
                QLog.d("Q.ocr.camera", 1, "postUploadTask imageData == null");
                return;
            }
            e eVar = this.K;
            if (eVar != null) {
                eVar.b();
            }
            String savePreviewImage = ((IOCR) QRoute.api(IOCR.class)).savePreviewImage(a16, this.f254560f, this.f254561h, this.C, this.M, this.N);
            e eVar2 = this.K;
            if (eVar2 != null) {
                eVar2.c(savePreviewImage);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x006a A[Catch: all -> 0x008d, TryCatch #2 {, blocks: (B:3:0x0001, B:5:0x0007, B:8:0x000b, B:10:0x000f, B:15:0x0021, B:16:0x0028, B:19:0x0034, B:21:0x006a, B:22:0x006c, B:24:0x0072, B:31:0x003d, B:34:0x005e), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0072 A[Catch: all -> 0x008d, TRY_LEAVE, TryCatch #2 {, blocks: (B:3:0x0001, B:5:0x0007, B:8:0x000b, B:10:0x000f, B:15:0x0021, B:16:0x0028, B:19:0x0034, B:21:0x006a, B:22:0x006c, B:24:0x0072, B:31:0x003d, B:34:0x005e), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized boolean x() {
        boolean z16;
        Camera camera2 = this.f254559e;
        boolean z17 = true;
        if (camera2 != null && this.I != null) {
            try {
                if (this.Z != null) {
                    if (!l(camera2, ((this.f254560f * this.f254561h) * this.D) / 8)) {
                        return false;
                    }
                    this.f254559e.setPreviewCallbackWithBuffer(this.Z);
                }
                this.f254559e.setPreviewDisplay(this.I);
                this.f254559e.startPreview();
                try {
                    y();
                } catch (Exception e16) {
                    e = e16;
                    z16 = true;
                    e.printStackTrace();
                    QLog.d("Q.ocr.camera", 1, "startPreview failed. error msg:" + e.getMessage());
                    z17 = z16;
                    if (z17) {
                    }
                    if (QLog.isColorLevel()) {
                    }
                    return z17;
                }
            } catch (Exception e17) {
                e = e17;
                z16 = false;
            }
        } else {
            QLog.d("Q.ocr.camera", 1, "startPreview camera is null or holder is null");
            z17 = false;
        }
        if (z17) {
            this.F = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.ocr.camera", 2, "startPreviewInternal isSuc:" + z17);
        }
        return z17;
    }

    public synchronized void B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            this.Q = false;
        }
    }

    public boolean C() {
        byte[] bArr;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("takePicture, isOpen:");
            sb5.append(this.E);
            sb5.append(",mNeedSelectImage:");
            sb5.append(this.Q);
            sb5.append(",isStop:");
            sb5.append(this.F);
            sb5.append(",picData:");
            if (this.T == null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            QLog.d("Q.ocr.camera", 2, sb5.toString());
        }
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            QLog.d("Q.ocr.camera", 1, "takePicture but net error!");
            QQToast.makeText(BaseApplication.getContext(), 1, R.string.fod, 0).show();
            return false;
        }
        if (!this.E || this.F || ((!this.Q && this.X != 1) || this.T == null || this.G || this.f254559e == null)) {
            return false;
        }
        this.G = true;
        if (this.X == 1 && this.H && this.f254562i * this.f254563m >= this.f254560f * this.f254561h) {
            CameraMonitor.takePicture(this.f254559e, null, null, null, new d());
        } else {
            byte[] bArr2 = this.f254557b0;
            if (bArr2 == null || bArr2.length != this.T.length) {
                try {
                    this.f254557b0 = new byte[this.T.length];
                } catch (Throwable th5) {
                    QLog.e("Q.ocr.camera", 1, "takePicture error: ", th5.getMessage());
                    this.f254557b0 = null;
                }
            }
            byte[] bArr3 = this.f254557b0;
            if (bArr3 != null) {
                byte[] bArr4 = this.T;
                System.arraycopy(bArr4, 0, bArr3, 0, bArr4.length);
                bArr = this.f254557b0;
            } else {
                bArr = this.T;
            }
            p(bArr, false);
        }
        return true;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) message)).booleanValue();
        }
        int i16 = message.what;
        if (i16 != 0) {
            if (i16 != 1) {
                if (i16 != 2) {
                    if (i16 == 3 && this.E) {
                        boolean n3 = n();
                        if (n3) {
                            this.E = false;
                        }
                        e eVar = this.K;
                        if (eVar != null) {
                            eVar.d(n3);
                        }
                    }
                } else {
                    boolean A = A();
                    e eVar2 = this.K;
                    if (eVar2 != null) {
                        eVar2.onStop(A);
                    }
                }
            } else {
                boolean x16 = x();
                e eVar3 = this.K;
                if (eVar3 != null) {
                    eVar3.e(x16);
                }
            }
        } else if (!this.E) {
            try {
                i3 = r();
            } catch (Exception e16) {
                e16.printStackTrace();
                i3 = -1004;
            }
            if (i3 == 0) {
                this.E = true;
            }
            e eVar4 = this.K;
            if (eVar4 != null) {
                eVar4.a(i3, this.f254560f, this.f254561h, this.C);
            }
        }
        return false;
    }

    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        this.J.removeCallbacksAndMessages(null);
        this.J.sendMessage(this.J.obtainMessage(3));
        if (QLog.isColorLevel()) {
            QLog.d("Q.ocr.camera", 2, "close");
        }
    }

    public boolean p(byte[] bArr, boolean z16) {
        WeakReferenceHandler weakReferenceHandler;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, this, bArr, Boolean.valueOf(z16))).booleanValue();
        }
        if (bArr == null || (weakReferenceHandler = this.J) == null || this.f254559e == null) {
            return false;
        }
        weakReferenceHandler.post(new Runnable(z16, bArr) { // from class: com.tencent.mobileqq.ocr.OcrCamera.7
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ boolean f254565d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ byte[] f254566e;

            {
                this.f254565d = z16;
                this.f254566e = bArr;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, OcrCamera.this, Boolean.valueOf(z16), bArr);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                String savePreviewImage;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                OcrCamera.this.Q = false;
                OcrCamera.this.R = true;
                e eVar = OcrCamera.this.K;
                if (eVar != null) {
                    eVar.b();
                }
                if (this.f254565d) {
                    IOCR iocr = (IOCR) QRoute.api(IOCR.class);
                    byte[] bArr2 = this.f254566e;
                    int i3 = OcrCamera.this.f254562i;
                    int i16 = OcrCamera.this.f254563m;
                    int i17 = OcrCamera.this.C;
                    OcrCamera ocrCamera = OcrCamera.this;
                    savePreviewImage = iocr.savePreviewImage(bArr2, i3, i16, i17, ocrCamera.M, ocrCamera.N, ocrCamera.f254556a0, true);
                } else {
                    IOCR iocr2 = (IOCR) QRoute.api(IOCR.class);
                    byte[] bArr3 = this.f254566e;
                    int i18 = OcrCamera.this.f254560f;
                    int i19 = OcrCamera.this.f254561h;
                    int i26 = OcrCamera.this.C;
                    OcrCamera ocrCamera2 = OcrCamera.this;
                    savePreviewImage = iocr2.savePreviewImage(bArr3, i18, i19, i26, ocrCamera2.M, ocrCamera2.N);
                }
                e eVar2 = OcrCamera.this.K;
                if (eVar2 != null) {
                    eVar2.c(savePreviewImage);
                }
                OcrCamera.this.G = false;
            }
        });
        return true;
    }

    public void q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (this.E) {
            if (this.F) {
                s();
                w();
                return;
            }
            return;
        }
        this.J.removeMessages(0);
        this.J.sendMessage(this.J.obtainMessage(0));
        if (QLog.isColorLevel()) {
            QLog.d("Q.ocr.camera", 2, "open isStop:" + this.F + ",isOpen:" + this.E);
        }
    }

    public synchronized void s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            this.Q = true;
            this.R = true;
        }
    }

    public void u(RectF rectF) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) rectF);
        } else {
            this.f254556a0 = rectF;
        }
    }

    public void v(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
            return;
        }
        this.X = i3;
        if (i3 == 1) {
            this.V = 2073600;
            if (QLog.isColorLevel()) {
                QLog.i("Q.ocr.camera", 1, "setOcrMode device model: " + ah.F());
            }
        }
    }

    public void w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        this.J.removeMessages(1);
        this.J.sendMessage(this.J.obtainMessage(1));
        if (QLog.isColorLevel()) {
            QLog.d("Q.ocr.camera", 2, "startPreview");
        }
    }

    public synchronized void y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            this.Q = true;
        }
    }

    public void z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        this.J.removeMessages(2);
        this.J.sendMessage(this.J.obtainMessage(2));
        if (QLog.isColorLevel()) {
            QLog.d("Q.ocr.camera", 2, "stopPreview");
        }
    }
}
