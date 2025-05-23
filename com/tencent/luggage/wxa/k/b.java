package com.tencent.luggage.wxa.k;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseIntArray;
import android.view.SurfaceHolder;
import androidx.collection.SparseArrayCompat;
import com.tencent.luggage.wxa.k.i;
import com.tencent.luggage.wxa.k.o;
import com.tencent.luggage.wxa.l.a;
import com.tencent.qmethod.pandoraex.monitor.AudioMonitor;
import com.tencent.qmethod.pandoraex.monitor.CameraMonitor;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlinx.coroutines.DebugKt;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b extends i implements MediaRecorder.OnInfoListener, MediaRecorder.OnErrorListener, Camera.PreviewCallback {

    /* renamed from: a0, reason: collision with root package name */
    public static final SparseArrayCompat f131240a0;

    /* renamed from: b0, reason: collision with root package name */
    public static final SparseArrayCompat f131241b0;
    public final r C;
    public q D;
    public com.tencent.luggage.wxa.k.a E;
    public boolean F;
    public boolean G;
    public int H;
    public int I;
    public int J;
    public float K;
    public int L;
    public boolean M;
    public Context N;
    public int O;
    public float P;
    public int Q;
    public float R;
    public CamcorderProfile S;
    public final AtomicBoolean T;
    public Handler U;
    public Camera.AutoFocusCallback V;
    public boolean W;
    public SparseIntArray X;
    public boolean Y;
    public SurfaceTexture Z;

    /* renamed from: d, reason: collision with root package name */
    public int f131242d;

    /* renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f131243e;

    /* renamed from: f, reason: collision with root package name */
    public Camera f131244f;

    /* renamed from: g, reason: collision with root package name */
    public Camera.Parameters f131245g;

    /* renamed from: h, reason: collision with root package name */
    public final Camera.CameraInfo f131246h;

    /* renamed from: i, reason: collision with root package name */
    public MediaRecorder f131247i;

    /* renamed from: j, reason: collision with root package name */
    public String f131248j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f131249k;

    /* renamed from: l, reason: collision with root package name */
    public final r f131250l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f131251m;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements o.a {
        public a() {
        }

        @Override // com.tencent.luggage.wxa.k.o.a
        public void a() {
            b bVar = b.this;
            if (bVar.f131244f != null) {
                bVar.N();
                b.this.G();
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.k.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6349b implements Camera.AutoFocusCallback {
        public C6349b() {
        }

        @Override // android.hardware.Camera.AutoFocusCallback
        public void onAutoFocus(boolean z16, Camera camera2) {
            if (b.this.T.get()) {
                com.tencent.luggage.wxa.k.f.c("MicroMsg.Camera1", "takePicture, auto focus => takePictureInternal");
                b.this.T.set(false);
                b.this.Q();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.T.get()) {
                com.tencent.luggage.wxa.k.f.c("MicroMsg.Camera1", "takePicture, cancel focus => takePictureInternal");
                b.this.T.set(false);
                b.this.Q();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d implements Camera.PictureCallback {
        public d() {
        }

        @Override // android.hardware.Camera.PictureCallback
        public void onPictureTaken(byte[] bArr, Camera camera2) {
            com.tencent.luggage.wxa.k.f.c("MicroMsg.Camera1", "takePictureInternal, onPictureTaken");
            b.this.f131243e.set(false);
            camera2.cancelAutoFocus();
            camera2.startPreview();
            b.this.f131251m = true;
            if (b.this.M) {
                camera2.setPreviewCallback(b.this);
            }
            b.this.f131333a.a(bArr);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class e implements Camera.AutoFocusCallback {
        public e() {
        }

        @Override // android.hardware.Camera.AutoFocusCallback
        public void onAutoFocus(boolean z16, Camera camera2) {
            b.this.a(z16, camera2);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class f implements Camera.AutoFocusCallback {
        public f() {
        }

        @Override // android.hardware.Camera.AutoFocusCallback
        public void onAutoFocus(boolean z16, Camera camera2) {
            b.this.a(z16, camera2);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class g implements Camera.AutoFocusCallback {
        public g() {
        }

        @Override // android.hardware.Camera.AutoFocusCallback
        public void onAutoFocus(boolean z16, Camera camera2) {
            if (b.this.V != null) {
                b.this.V.onAutoFocus(z16, camera2);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class h implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Camera f131259a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f131260b;

        public h(Camera camera2, boolean z16) {
            this.f131259a = camera2;
            this.f131260b = z16;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f131259a != null && b.this.f131251m) {
                this.f131259a.cancelAutoFocus();
                try {
                    Camera.Parameters parameters = this.f131259a.getParameters();
                    if (parameters != null && !parameters.getFocusMode().equalsIgnoreCase("continuous-picture") && parameters.getSupportedFocusModes().contains("continuous-picture")) {
                        parameters.setFocusMode("continuous-picture");
                        parameters.setFocusAreas(null);
                        parameters.setMeteringAreas(null);
                        this.f131259a.setParameters(parameters);
                    }
                } catch (Exception e16) {
                    com.tencent.luggage.wxa.k.f.a("MicroMsg.Camera1", "resetFocus, camera getParameters or setParameters fail", (Throwable) e16);
                }
                if (b.this.V != null) {
                    b.this.V.onAutoFocus(this.f131260b, this.f131259a);
                }
            }
        }
    }

    static {
        SparseArrayCompat sparseArrayCompat = new SparseArrayCompat();
        f131240a0 = sparseArrayCompat;
        sparseArrayCompat.put(0, DebugKt.DEBUG_PROPERTY_VALUE_OFF);
        sparseArrayCompat.put(1, "on");
        sparseArrayCompat.put(2, "torch");
        sparseArrayCompat.put(3, "auto");
        sparseArrayCompat.put(4, "red-eye");
        SparseArrayCompat sparseArrayCompat2 = new SparseArrayCompat();
        f131241b0 = sparseArrayCompat2;
        sparseArrayCompat2.put(0, "auto");
        sparseArrayCompat2.put(1, "cloudy-daylight");
        sparseArrayCompat2.put(2, "daylight");
        sparseArrayCompat2.put(3, "shade");
        sparseArrayCompat2.put(4, "fluorescent");
        sparseArrayCompat2.put(5, "incandescent");
    }

    public b(i.a aVar, o oVar, Context context) {
        super(aVar, oVar);
        this.f131243e = new AtomicBoolean(false);
        this.f131246h = new Camera.CameraInfo();
        this.f131250l = new r();
        this.f131251m = false;
        this.C = new r();
        this.R = 1.0f;
        this.T = new AtomicBoolean(false);
        this.U = new Handler();
        this.N = context;
        this.W = com.tencent.luggage.wxa.pq.a.a(context);
        oVar.a(new a());
    }

    @Override // com.tencent.luggage.wxa.k.i
    public boolean A() {
        return this.f131245g.isZoomSupported();
    }

    @Override // com.tencent.luggage.wxa.k.i
    public void B() {
        this.R = 0.75f;
    }

    @Override // com.tencent.luggage.wxa.k.i
    public boolean C() {
        I();
        if (!K()) {
            this.f131333a.c();
            return true;
        }
        if (this.f131334b.i()) {
            N();
        }
        this.F = true;
        O();
        return true;
    }

    @Override // com.tencent.luggage.wxa.k.i
    public void D() {
        Camera camera2 = this.f131244f;
        if (camera2 != null) {
            camera2.stopPreview();
            this.f131251m = false;
            this.f131244f.setPreviewCallback(null);
        }
        this.F = false;
        MediaRecorder mediaRecorder = this.f131247i;
        if (mediaRecorder != null) {
            if (this.f131249k) {
                try {
                    mediaRecorder.stop();
                } catch (IllegalStateException e16) {
                    com.tencent.luggage.wxa.k.f.a("MicroMsg.Camera1", "stop media record error", (Throwable) e16);
                    e16.printStackTrace();
                }
            }
            this.f131247i.release();
            this.f131247i = null;
            if (this.f131249k) {
                this.f131333a.a(this.f131248j);
                this.f131249k = false;
            }
        }
        L();
    }

    @Override // com.tencent.luggage.wxa.k.i
    public void E() {
        if (this.f131249k) {
            P();
            Camera camera2 = this.f131244f;
            if (camera2 != null) {
                camera2.lock();
            }
        }
    }

    @Override // com.tencent.luggage.wxa.k.i
    public void F() {
        if (!y()) {
            com.tencent.luggage.wxa.k.f.c("MicroMsg.Camera1", "Camera is not ready, call start() before takePicture()");
            return;
        }
        if (this.f131251m) {
            if (c()) {
                com.tencent.luggage.wxa.k.f.c("MicroMsg.Camera1", "takePicture => autofocus");
                this.f131244f.cancelAutoFocus();
                this.T.getAndSet(true);
                try {
                    this.f131244f.autoFocus(new C6349b());
                } catch (Exception e16) {
                    if (this.T.get()) {
                        com.tencent.luggage.wxa.k.f.b("MicroMsg.Camera1", "takePicture, autofocus exception => takePictureInternal", (Throwable) e16);
                        this.T.set(false);
                        Q();
                    }
                }
                new Handler(Looper.getMainLooper()).postDelayed(new c(), 2000L);
                return;
            }
            com.tencent.luggage.wxa.k.f.c("MicroMsg.Camera1", "takePicture => takePictureInternal");
            Q();
            return;
        }
        throw new IllegalStateException("Preview is paused - resume it before taking a picture.");
    }

    public void G() {
        this.f131245g.setRotation(f(this.J));
        SortedSet b16 = this.f131250l.b(this.E);
        if (b16 == null) {
            com.tencent.luggage.wxa.k.f.b("MicroMsg.Camera1", "adjustCameraParameters, ratio[%s] is not supported", this.E);
            com.tencent.luggage.wxa.k.a a16 = a();
            this.E = a16;
            b16 = this.f131250l.b(a16);
            com.tencent.luggage.wxa.k.f.b("MicroMsg.Camera1", "adjustCameraParameters, change to ratio to %s", this.E);
        }
        a(b16);
        if (this.D == null) {
            ArrayList arrayList = new ArrayList();
            for (Camera.Size size : this.f131245g.getSupportedPreviewSizes()) {
                arrayList.add(new q(size.width, size.height));
            }
            q a17 = a(arrayList);
            this.D = a17;
            if (a17 == null) {
                this.D = (q) this.C.b(this.E).last();
            }
        }
        if (this.F) {
            this.f131244f.stopPreview();
            this.f131251m = false;
        }
        this.f131245g.setPictureSize(this.D.b(), this.D.a());
        M();
        d(this.G);
        i(this.I);
        a(this.E);
        d(this.K);
        j(this.L);
        e(this.M);
        try {
            this.f131244f.setParameters(this.f131245g);
        } catch (Exception e16) {
            com.tencent.luggage.wxa.k.f.a("MicroMsg.Camera1", "adjustCameraParameters setParameters fail", (Throwable) e16);
        }
        if (this.F) {
            O();
        }
    }

    public final void H() {
        ArrayList arrayList = new ArrayList();
        for (com.tencent.luggage.wxa.k.a aVar : this.f131250l.c()) {
            if (!this.C.c().contains(aVar)) {
                arrayList.add(aVar);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.f131250l.a((com.tencent.luggage.wxa.k.a) it.next());
        }
    }

    public final boolean I() {
        int numberOfCameras = Camera.getNumberOfCameras();
        for (int i3 = 0; i3 < numberOfCameras; i3++) {
            Camera.getCameraInfo(i3, this.f131246h);
            if (this.f131246h.facing == this.H) {
                this.f131242d = i3;
                com.tencent.luggage.wxa.k.f.b("MicroMsg.Camera1", "chooseCamera, CameraId = %d", Integer.valueOf(i3));
                return true;
            }
        }
        this.f131242d = -1;
        com.tencent.luggage.wxa.k.f.b("MicroMsg.Camera1", "chooseCamera, no camera available");
        return false;
    }

    public final void J() {
        List<Integer> list;
        int i3;
        if (this.f131245g == null || !y() || !A()) {
            return;
        }
        try {
            list = this.f131245g.getZoomRatios();
        } catch (Exception e16) {
            com.tencent.luggage.wxa.k.f.a("MicroMsg.Camera1", "getZoom error: %s", e16.getMessage());
            list = null;
        }
        if (list != null && !list.isEmpty()) {
            int intValue = list.get(list.size() - 1).intValue();
            int i16 = 1;
            int i17 = intValue;
            while (true) {
                i17 /= 10;
                if (i17 < 10) {
                    break;
                } else {
                    i16 *= 10;
                }
            }
            int i18 = intValue / i16;
            if ((intValue + 4) / i16 > i18) {
                i18++;
            }
            this.X = new SparseIntArray(i18);
            for (i3 = 10; i3 <= i18; i3++) {
                int i19 = i3 * i16;
                if (list.indexOf(Integer.valueOf(i19)) < 0) {
                    int i26 = 1;
                    while (true) {
                        if (i26 <= 4) {
                            int i27 = i19 - i26;
                            if (list.indexOf(Integer.valueOf(i27)) > 0) {
                                this.X.append(i3, i27);
                                break;
                            }
                            int i28 = i19 + i26;
                            if (list.indexOf(Integer.valueOf(i28)) > 0) {
                                this.X.append(i3, i28);
                                break;
                            }
                            i26++;
                        }
                    }
                } else {
                    this.X.append(i3, i19);
                }
            }
        }
    }

    public final boolean K() {
        if (this.f131244f != null) {
            L();
        }
        try {
            Camera open = CameraMonitor.open(this.f131242d);
            this.f131244f = open;
            this.f131245g = open.getParameters();
            this.f131250l.a();
            for (Camera.Size size : this.f131245g.getSupportedPreviewSizes()) {
                this.f131250l.a(new q(size.width, size.height));
            }
            com.tencent.luggage.wxa.k.f.c("MicroMsg.Camera1", "openCamera, supportedPreviewSizes: " + this.f131250l);
            this.C.a();
            for (Camera.Size size2 : this.f131245g.getSupportedPictureSizes()) {
                this.C.a(new q(size2.width, size2.height));
            }
            com.tencent.luggage.wxa.k.f.c("MicroMsg.Camera1", "openCamera, supportedPictureSizes: " + this.C);
            H();
            com.tencent.luggage.wxa.k.f.b("MicroMsg.Camera1", "openCamera, adjustPreviewSizes: %s", this.f131250l);
            if (this.E == null) {
                this.E = j.f131336a;
            }
            G();
            this.f131244f.setDisplayOrientation(g(this.J));
            this.f131333a.b();
            return true;
        } catch (RuntimeException e16) {
            com.tencent.luggage.wxa.k.f.a("MicroMsg.Camera1", "open camera1 error", (Throwable) e16);
            return false;
        }
    }

    public final void L() {
        Camera camera2 = this.f131244f;
        if (camera2 != null) {
            camera2.release();
            this.f131244f = null;
            this.D = null;
            this.f131333a.a();
        }
    }

    public final void M() {
        int i3;
        int i16;
        a.c a16 = a(this.N, b(this.E));
        if (a16 == null) {
            com.tencent.luggage.wxa.k.f.c("MicroMsg.Camera1", "can't find a suitable preview size!");
            q a17 = a(this.f131250l.b(this.E));
            i3 = a17.b();
            i16 = a17.a();
        } else {
            Point point = a16.f132753a;
            i3 = point.x;
            i16 = point.y;
        }
        this.f131245g.setPreviewSize(i3, i16);
        this.f131244f.setParameters(this.f131245g);
    }

    public void N() {
        try {
            SurfaceTexture surfaceTexture = this.Z;
            if (surfaceTexture != null) {
                this.f131244f.setPreviewTexture(surfaceTexture);
            } else if (this.f131334b.c() == SurfaceHolder.class) {
                boolean z16 = this.F;
                com.tencent.luggage.wxa.k.f.b("MicroMsg.Camera1", "setUpPreview, outputClass is SurfaceHolder, needsToStopPreview = %s", (Object) false);
                this.f131244f.setPreviewDisplay(this.f131334b.e());
            } else {
                com.tencent.luggage.wxa.k.f.c("MicroMsg.Camera1", "setUpPreview, outputClass is SurfaceTexture");
                this.f131244f.setPreviewTexture((SurfaceTexture) this.f131334b.f());
            }
        } catch (IOException e16) {
            com.tencent.luggage.wxa.k.f.b("MicroMsg.Camera1", "setUpPreview, fail IOException message: ", e16.getMessage());
        }
    }

    public final void O() {
        a.c a16;
        this.f131244f.startPreview();
        boolean z16 = true;
        this.f131251m = true;
        if (this.M) {
            this.f131244f.setPreviewCallback(this);
        }
        if ((this.f131334b instanceof l) && (a16 = a(this.N, b(b()))) != null) {
            com.tencent.luggage.wxa.kb.a aVar = com.tencent.luggage.wxa.kb.a.f131893a;
            aVar.b(a16.f132753a.x);
            aVar.a(a16.f132753a.y);
            if (g() != 1) {
                z16 = false;
            }
            aVar.a(z16);
            aVar.c(e());
            ((l) this.f131334b).a(aVar);
        }
    }

    public final void P() {
        this.f131249k = false;
        MediaRecorder mediaRecorder = this.f131247i;
        if (mediaRecorder != null) {
            try {
                mediaRecorder.stop();
            } catch (RuntimeException e16) {
                com.tencent.luggage.wxa.k.f.a("MicroMsg.Camera1", "stopMediaRecorder", (Throwable) e16);
            }
            this.f131247i.reset();
            this.f131247i.release();
            this.f131247i = null;
        }
        if (this.f131248j != null && new File(this.f131248j).exists()) {
            this.f131333a.a(this.f131248j);
            this.f131248j = null;
        } else {
            this.f131333a.a((String) null);
        }
    }

    public void Q() {
        if (y() && !this.f131243e.getAndSet(true)) {
            CameraMonitor.takePicture(this.f131244f, null, null, null, new d());
        }
    }

    @Override // com.tencent.luggage.wxa.k.i
    public void b(float f16) {
    }

    @Override // com.tencent.luggage.wxa.k.i
    public float f() {
        return this.P;
    }

    @Override // com.tencent.luggage.wxa.k.i
    public int g() {
        return this.H;
    }

    public final boolean h(int i3) {
        return i3 == 90 || i3 == 270;
    }

    public final boolean i(int i3) {
        if (y()) {
            List<String> supportedFlashModes = this.f131245g.getSupportedFlashModes();
            SparseArrayCompat sparseArrayCompat = f131240a0;
            String str = (String) sparseArrayCompat.get(i3);
            if (supportedFlashModes != null && supportedFlashModes.contains(str)) {
                this.f131245g.setFlashMode(str);
                this.I = i3;
                com.tencent.luggage.wxa.k.f.b("MicroMsg.Camera1", "setFlashInternal, flash = %d", Integer.valueOf(i3));
                return true;
            }
            String str2 = (String) sparseArrayCompat.get(this.I);
            if (supportedFlashModes != null && supportedFlashModes.contains(str2)) {
                return false;
            }
            this.f131245g.setFlashMode(DebugKt.DEBUG_PROPERTY_VALUE_OFF);
            return true;
        }
        this.I = i3;
        return false;
    }

    @Override // com.tencent.luggage.wxa.k.i
    public float j() {
        return 0.0f;
    }

    @Override // com.tencent.luggage.wxa.k.i
    public float l() {
        return this.f131245g.getMaxZoom();
    }

    @Override // com.tencent.luggage.wxa.k.i
    public q m() {
        return this.D;
    }

    @Override // com.tencent.luggage.wxa.k.i
    public r n() {
        return this.C;
    }

    @Override // com.tencent.luggage.wxa.k.i
    public q o() {
        Camera.Size previewSize = this.f131245g.getPreviewSize();
        return new q(previewSize.width, previewSize.height);
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

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera2) {
        Camera.Size previewSize = this.f131245g.getPreviewSize();
        if (this.W) {
            o oVar = this.f131334b;
            if ((oVar instanceof l) && ((l) oVar).k() != null) {
                ((l) this.f131334b).k().onFrameData(bArr);
            }
        }
        this.f131333a.a(bArr, previewSize.width, previewSize.height, this.J);
    }

    @Override // com.tencent.luggage.wxa.k.i
    public int p() {
        return this.O;
    }

    @Override // com.tencent.luggage.wxa.k.i
    public r q() {
        return this.f131250l;
    }

    @Override // com.tencent.luggage.wxa.k.i
    public boolean r() {
        return this.M;
    }

    @Override // com.tencent.luggage.wxa.k.i
    public float[] s() {
        if (this.X == null) {
            J();
        }
        float[] fArr = new float[this.X.size()];
        for (int i3 = 0; i3 < this.X.size(); i3++) {
            fArr[i3] = (this.X.keyAt(i3) * 1.0f) / 10.0f;
        }
        return fArr;
    }

    @Override // com.tencent.luggage.wxa.k.i
    public Set t() {
        r rVar = this.f131250l;
        ArrayList arrayList = new ArrayList();
        for (com.tencent.luggage.wxa.k.a aVar : rVar.c()) {
            if (this.C.b(aVar) == null) {
                arrayList.add(aVar);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            rVar.a((com.tencent.luggage.wxa.k.a) it.next());
        }
        return rVar.c();
    }

    @Override // com.tencent.luggage.wxa.k.i
    public Point u() {
        CamcorderProfile camcorderProfile = this.S;
        if (camcorderProfile == null) {
            return null;
        }
        int i3 = camcorderProfile.videoFrameWidth;
        int i16 = camcorderProfile.videoFrameHeight;
        float f16 = this.R;
        return new Point(com.tencent.luggage.wxa.l.a.a((int) (i3 * f16)), com.tencent.luggage.wxa.l.a.a((int) (i16 * f16)));
    }

    @Override // com.tencent.luggage.wxa.k.i
    public int w() {
        return this.L;
    }

    @Override // com.tencent.luggage.wxa.k.i
    public float x() {
        return this.K;
    }

    @Override // com.tencent.luggage.wxa.k.i
    public boolean y() {
        if (this.f131244f != null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.k.i
    public boolean z() {
        return this.f131251m;
    }

    @Override // com.tencent.luggage.wxa.k.i
    public void b(boolean z16) {
    }

    @Override // com.tencent.luggage.wxa.k.i
    public boolean c() {
        if (!y()) {
            return this.G;
        }
        String focusMode = this.f131245g.getFocusMode();
        return focusMode != null && focusMode.contains("continuous");
    }

    @Override // com.tencent.luggage.wxa.k.i
    public int d() {
        return this.f131242d;
    }

    @Override // com.tencent.luggage.wxa.k.i
    public void e(int i3) {
        if (i3 != this.L && j(i3)) {
            this.f131244f.setParameters(this.f131245g);
        }
    }

    public final int f(int i3) {
        Camera.CameraInfo cameraInfo = this.f131246h;
        if (cameraInfo.facing == 1) {
            this.Q = (cameraInfo.orientation + i3) % 360;
        } else {
            this.Q = ((this.f131246h.orientation + i3) + (h(i3) ? 180 : 0)) % 360;
        }
        return this.Q;
    }

    public final int g(int i3) {
        Camera.CameraInfo cameraInfo = this.f131246h;
        if (cameraInfo.facing == 1) {
            return (360 - ((cameraInfo.orientation + i3) % 360)) % 360;
        }
        return ((cameraInfo.orientation - i3) + 360) % 360;
    }

    @Override // com.tencent.luggage.wxa.k.i
    public int h() {
        return this.I;
    }

    public final boolean j(int i3) {
        this.L = i3;
        if (!y()) {
            return false;
        }
        List<String> supportedWhiteBalance = this.f131245g.getSupportedWhiteBalance();
        SparseArrayCompat sparseArrayCompat = f131241b0;
        String str = (String) sparseArrayCompat.get(i3);
        if (supportedWhiteBalance != null && supportedWhiteBalance.contains(str)) {
            this.f131245g.setWhiteBalance(str);
            return true;
        }
        String str2 = (String) sparseArrayCompat.get(this.L);
        if (supportedWhiteBalance != null && supportedWhiteBalance.contains(str2)) {
            return false;
        }
        this.f131245g.setWhiteBalance("auto");
        return true;
    }

    @Override // com.tencent.luggage.wxa.k.i
    public void d(int i3) {
        this.O = i3;
    }

    @Override // com.tencent.luggage.wxa.k.i
    public void a(q qVar) {
        if (qVar == null) {
            return;
        }
        this.D = qVar;
        Camera.Parameters parameters = this.f131245g;
        if (parameters == null || this.f131244f == null) {
            return;
        }
        parameters.setPictureSize(qVar.b(), qVar.a());
        this.f131244f.setParameters(this.f131245g);
    }

    @Override // com.tencent.luggage.wxa.k.i
    public void b(int i3) {
        SurfaceTexture surfaceTexture;
        if (this.H == i3) {
            return;
        }
        this.H = i3;
        if (y()) {
            D();
            C();
            Camera camera2 = this.f131244f;
            if (camera2 == null || (surfaceTexture = this.Z) == null) {
                return;
            }
            try {
                camera2.setPreviewTexture(surfaceTexture);
            } catch (IOException e16) {
                com.tencent.luggage.wxa.k.f.c("MicroMsg.Camera1", "change facing error", e16);
            }
        }
    }

    public final boolean d(boolean z16) {
        this.G = z16;
        if (y()) {
            List<String> supportedFocusModes = this.f131245g.getSupportedFocusModes();
            if (z16 && supportedFocusModes.contains("continuous-picture")) {
                this.f131245g.setFocusMode("continuous-picture");
                com.tencent.luggage.wxa.k.f.c("MicroMsg.Camera1", "setAutoFocusInternal, FOCUS_MODE_CONTINUOUS_PICTURE, autoFocus = true");
                return true;
            }
            if (supportedFocusModes.contains(QCircleDaTongConstant.ElementParamValue.FIXED)) {
                this.f131245g.setFocusMode(QCircleDaTongConstant.ElementParamValue.FIXED);
                com.tencent.luggage.wxa.k.f.b("MicroMsg.Camera1", "setAutoFocusInternal, FOCUS_MODE_FIXED, autoFocus = %s", Boolean.valueOf(z16));
                return true;
            }
            if (supportedFocusModes.contains("infinity")) {
                this.f131245g.setFocusMode("infinity");
                com.tencent.luggage.wxa.k.f.b("MicroMsg.Camera1", "setAutoFocusInternal, FOCUS_MODE_INFINITY, autoFocus = %s", Boolean.valueOf(z16));
                return true;
            }
            this.f131245g.setFocusMode(supportedFocusModes.get(0));
            com.tencent.luggage.wxa.k.f.a("MicroMsg.Camera1", "setAutoFocusInternal, mode = %s, autoFocus = %s", supportedFocusModes.get(0), Boolean.valueOf(z16));
            return true;
        }
        com.tencent.luggage.wxa.k.f.b("MicroMsg.Camera1", "setAutoFocusInternal, camera not open, autoFocus = %s", Boolean.valueOf(z16));
        return false;
    }

    @Override // com.tencent.luggage.wxa.k.i
    public int e() {
        return this.f131246h.orientation;
    }

    @Override // com.tencent.luggage.wxa.k.i
    public void c(int i3) {
        if (i3 != this.I && i(i3)) {
            try {
                this.f131244f.setParameters(this.f131245g);
            } catch (Exception e16) {
                com.tencent.luggage.wxa.k.f.a("MicroMsg.Camera1", "setFlash setParameters fail", (Throwable) e16);
            }
        }
    }

    public final void e(boolean z16) {
        this.M = z16;
        if (y()) {
            if (this.M) {
                this.f131244f.setPreviewCallback(this);
            } else {
                this.f131244f.setPreviewCallback(null);
            }
        }
    }

    @Override // com.tencent.luggage.wxa.k.i
    public boolean a(com.tencent.luggage.wxa.k.a aVar) {
        if (this.E != null && y()) {
            if (this.E.equals(aVar)) {
                return false;
            }
            if (this.f131250l.b(aVar) == null) {
                com.tencent.luggage.wxa.k.f.b("MicroMsg.Camera1", "setAspectRatio, ratio [%s] is not supported", aVar.toString());
                return false;
            }
            this.E = aVar;
            this.D = (q) this.C.b(aVar).last();
            G();
            return true;
        }
        com.tencent.luggage.wxa.k.f.a("MicroMsg.Camera1", "setAspectRatio, mAspectRatio is null? %s, camera open? %s", Boolean.valueOf(this.E == null), Boolean.valueOf(y()));
        this.E = aVar;
        return true;
    }

    @Override // com.tencent.luggage.wxa.k.i
    public void c(float f16) {
        if (f16 != this.K && d(f16)) {
            this.f131244f.setParameters(this.f131245g);
        }
    }

    @Override // com.tencent.luggage.wxa.k.i
    public com.tencent.luggage.wxa.k.a b() {
        return this.E;
    }

    public List b(com.tencent.luggage.wxa.k.a aVar) {
        return new ArrayList(this.f131250l.b(this.E));
    }

    @Override // com.tencent.luggage.wxa.k.i
    public void c(boolean z16) {
        if (z16 == this.M) {
            return;
        }
        e(z16);
    }

    public final Rect b(float f16, float f17) {
        int i3 = i() / 2;
        int a16 = a(f16, this.f131334b.h(), i3);
        int a17 = a(f17, this.f131334b.b(), i3);
        return new Rect(a16 - i3, a17 - i3, a16 + i3, a17 + i3);
    }

    @Override // com.tencent.luggage.wxa.k.i
    public void a(boolean z16) {
        if (this.G != z16 && d(z16)) {
            this.f131244f.setParameters(this.f131245g);
        }
    }

    public final void b(String str, int i3, int i16, boolean z16, CamcorderProfile camcorderProfile, boolean z17) {
        this.f131247i = new MediaRecorder();
        this.f131244f.unlock();
        this.f131247i.setCamera(this.f131244f);
        CameraMonitor.setVideoSource(this.f131247i, 1);
        if (z16) {
            AudioMonitor.setAudioSource(this.f131247i, 5);
        }
        this.f131247i.setOutputFile(str);
        this.f131248j = str;
        if (z17) {
            a(camcorderProfile, z16);
        } else if (CamcorderProfile.hasProfile(this.f131242d, camcorderProfile.quality)) {
            a(CamcorderProfile.get(this.f131242d, camcorderProfile.quality), z16);
        } else {
            a(CamcorderProfile.get(this.f131242d, 1), z16);
        }
        this.f131247i.setOrientationHint(f(this.J));
        if (i3 != -1) {
            this.f131247i.setMaxDuration(i3);
        }
        if (i16 != -1) {
            this.f131247i.setMaxFileSize(i16);
        }
        this.f131247i.setOnInfoListener(this);
        this.f131247i.setOnErrorListener(this);
    }

    public final boolean d(float f16) {
        if (y() && this.f131245g.isZoomSupported()) {
            this.f131245g.setZoom((int) (this.f131245g.getMaxZoom() * f16));
            this.K = f16;
            return true;
        }
        this.K = f16;
        return false;
    }

    @Override // com.tencent.luggage.wxa.k.i
    public boolean a(String str, int i3, int i16, boolean z16, CamcorderProfile camcorderProfile, boolean z17) {
        if (!this.f131249k) {
            b(str, i3, i16, z16, camcorderProfile, z17);
            try {
                this.f131247i.prepare();
                AudioMonitor.start(this.f131247i);
                this.f131249k = true;
                return true;
            } catch (IOException e16) {
                e16.printStackTrace();
                com.tencent.luggage.wxa.k.f.a("MicroMsg.Camera1", "record error", (Throwable) e16);
            }
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.k.i
    public void a(int i3) {
        if (this.J == i3) {
            com.tencent.luggage.wxa.k.f.b("MicroMsg.Camera1", "Camera1 setDisplayOrientation, displayOrientation = %d, not changed", Integer.valueOf(i3));
            return;
        }
        this.J = i3;
        if (y()) {
            int f16 = f(i3);
            this.f131245g.setRotation(f(i3));
            this.f131244f.setParameters(this.f131245g);
            boolean z16 = this.F;
            int g16 = g(i3);
            this.f131244f.setDisplayOrientation(g(i3));
            com.tencent.luggage.wxa.k.f.a("MicroMsg.Camera1", "Camera1 setDisplayOrientation, new orientation = %d, camera rotation = %d, camera orientation = %d", Integer.valueOf(i3), Integer.valueOf(f16), Integer.valueOf(g16));
        }
    }

    @Override // com.tencent.luggage.wxa.k.i
    public void a(float f16) {
        this.P = f16;
    }

    @Override // com.tencent.luggage.wxa.k.i
    public void a(SurfaceTexture surfaceTexture) {
        try {
            Camera camera2 = this.f131244f;
            if (camera2 == null) {
                this.Z = surfaceTexture;
                return;
            }
            camera2.stopPreview();
            this.f131251m = false;
            if (surfaceTexture == null) {
                this.f131244f.setPreviewTexture((SurfaceTexture) this.f131334b.f());
            } else {
                this.f131244f.setPreviewTexture(surfaceTexture);
            }
            this.Z = surfaceTexture;
            O();
        } catch (IOException e16) {
            throw new RuntimeException(e16);
        }
    }

    @Override // com.tencent.luggage.wxa.k.i
    public void a(Float f16) {
        if (this.Y) {
            com.tencent.luggage.wxa.k.f.a("MicroMsg.Camera1", "setForceZoomTargetRatio, zooming, ignore");
            return;
        }
        if (this.f131245g == null || !y()) {
            return;
        }
        try {
            try {
            } catch (Exception e16) {
                com.tencent.luggage.wxa.k.f.a("MicroMsg.Camera1", "setForceZoomTargetRatio error: %s", e16.getMessage());
            }
            if (A()) {
                return;
            }
            if (this.X == null) {
                com.tencent.luggage.wxa.k.f.a("MicroMsg.Camera1", "setForceZoomTargetRatio before init zoom info, ignore");
                return;
            }
            int indexOf = this.f131245g.getZoomRatios().indexOf(Integer.valueOf(this.X.get(Math.round(f16.floatValue() * 10.0f))));
            if (indexOf >= 0 && indexOf <= this.f131245g.getMaxZoom()) {
                this.Y = true;
                this.f131245g.setZoom(indexOf);
                this.f131244f.setParameters(this.f131245g);
            }
        } finally {
            this.Y = false;
        }
    }

    public final q a(SortedSet sortedSet) {
        if (!this.f131334b.i()) {
            return (q) sortedSet.first();
        }
        int h16 = this.f131334b.h();
        int b16 = this.f131334b.b();
        if (h(this.J)) {
            b16 = h16;
            h16 = b16;
        }
        Iterator it = sortedSet.iterator();
        q qVar = null;
        while (it.hasNext()) {
            qVar = (q) it.next();
            if (h16 <= qVar.b() && b16 <= qVar.a()) {
                break;
            }
        }
        return qVar;
    }

    public final q a(List list) {
        a.c a16 = a(this.N, list);
        if (a16 == null) {
            com.tencent.luggage.wxa.k.f.d("MicroMsg.Camera1", "supportSizes is empty, skip getReasonableSize");
            return null;
        }
        Point point = a16.f132753a;
        return new q(point.x, point.y);
    }

    @Override // com.tencent.luggage.wxa.k.i
    public void a(float f16, float f17) {
        Camera camera2 = this.f131244f;
        if (camera2 != null && this.f131251m) {
            Camera.Parameters parameters = camera2.getParameters();
            String focusMode = parameters.getFocusMode();
            Rect b16 = b(f16, f17);
            ArrayList arrayList = new ArrayList();
            arrayList.add(new Camera.Area(b16, k()));
            if (parameters.getMaxNumFocusAreas() != 0 && focusMode != null && (focusMode.equals("auto") || focusMode.equals("macro") || focusMode.equals("continuous-picture") || focusMode.equals("continuous-video"))) {
                if (parameters.getSupportedFocusModes().contains("auto")) {
                    parameters.setFocusMode("auto");
                    parameters.setFocusAreas(arrayList);
                    if (parameters.getMaxNumMeteringAreas() > 0) {
                        parameters.setMeteringAreas(arrayList);
                    }
                    this.f131244f.setParameters(parameters);
                    try {
                        this.f131244f.autoFocus(new e());
                        return;
                    } catch (Exception e16) {
                        com.tencent.luggage.wxa.k.f.a("MicroMsg.Camera1", "attachFocusTapListener, autofocus fail case 1", (Throwable) e16);
                        return;
                    }
                }
                return;
            }
            if (parameters.getMaxNumMeteringAreas() > 0) {
                if (parameters.getSupportedFocusModes().contains("auto")) {
                    parameters.setFocusMode("auto");
                    parameters.setFocusAreas(arrayList);
                    parameters.setMeteringAreas(arrayList);
                    this.f131244f.setParameters(parameters);
                    try {
                        this.f131244f.autoFocus(new f());
                        return;
                    } catch (Exception e17) {
                        com.tencent.luggage.wxa.k.f.a("MicroMsg.Camera1", "attachFocusTapListener, autofocus fail case 2", (Throwable) e17);
                        return;
                    }
                }
                return;
            }
            try {
                this.f131244f.autoFocus(new g());
                return;
            } catch (Exception e18) {
                com.tencent.luggage.wxa.k.f.a("MicroMsg.Camera1", "attachFocusTapListener, autofocus fail case 3", (Throwable) e18);
                return;
            }
        }
        com.tencent.luggage.wxa.k.f.c("MicroMsg.Camera1", "execute simpleRequestFocus after camera.release");
    }

    public final void a(boolean z16, Camera camera2) {
        if (this.f131244f != null && this.f131251m) {
            this.U.removeCallbacksAndMessages(null);
            this.U.postDelayed(new h(camera2, z16), 3000L);
        } else {
            com.tencent.luggage.wxa.k.f.c("MicroMsg.Camera1", "execute simpleRequestFocus after camera.release");
        }
    }

    public static int a(float f16, int i3, int i16) {
        int i17 = (int) (((f16 / i3) * 2000.0f) - 1000.0f);
        return Math.abs(i17) + i16 > 1000 ? i17 > 0 ? 1000 - i16 : i16 - 1000 : i17;
    }

    public final void a(CamcorderProfile camcorderProfile, boolean z16) {
        this.S = camcorderProfile;
        this.f131247i.setOutputFormat(camcorderProfile.fileFormat);
        this.f131247i.setVideoFrameRate(camcorderProfile.videoFrameRate);
        this.f131247i.setVideoSize(camcorderProfile.videoFrameWidth, camcorderProfile.videoFrameHeight);
        this.f131247i.setVideoEncodingBitRate(camcorderProfile.videoBitRate);
        this.f131247i.setVideoEncoder(camcorderProfile.videoCodec);
        if (z16) {
            this.f131247i.setAudioEncodingBitRate(camcorderProfile.audioBitRate);
            this.f131247i.setAudioChannels(camcorderProfile.audioChannels);
            this.f131247i.setAudioSamplingRate(camcorderProfile.audioSampleRate);
            this.f131247i.setAudioEncoder(camcorderProfile.audioCodec);
        }
    }
}
