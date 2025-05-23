package com.tencent.biz.widgets;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.api.IImgProcessApi;
import com.tencent.mobileqq.qrscan.api.IQRCodeApi;
import com.tencent.mobileqq.qrscan.api.IScanUtilApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.SensorMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.util.CameraUtil;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import kotlinx.coroutines.DebugKt;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ScannerView extends ViewGroup implements SurfaceHolder.Callback, Camera.PreviewCallback, Comparator<Camera.Size> {
    int C;
    int D;
    int E;
    int F;
    int G;
    int H;
    int I;
    String J;
    Camera K;
    int L;
    private SurfaceView M;
    private ViewFinderView N;
    private int P;
    private int Q;
    private int R;
    private int S;
    private int T;
    private int U;
    private int V;
    private boolean W;

    /* renamed from: a0, reason: collision with root package name */
    private boolean f97703a0;

    /* renamed from: b0, reason: collision with root package name */
    private boolean f97704b0;

    /* renamed from: c0, reason: collision with root package name */
    private boolean f97705c0;

    /* renamed from: d, reason: collision with root package name */
    ReentrantLock f97706d;

    /* renamed from: d0, reason: collision with root package name */
    private e f97707d0;

    /* renamed from: e, reason: collision with root package name */
    DecodeThread f97708e;

    /* renamed from: e0, reason: collision with root package name */
    private c f97709e0;

    /* renamed from: f, reason: collision with root package name */
    Handler f97710f;

    /* renamed from: f0, reason: collision with root package name */
    private AutoFocusThread f97711f0;

    /* renamed from: g0, reason: collision with root package name */
    private SensorManager f97712g0;

    /* renamed from: h, reason: collision with root package name */
    Rect f97713h;

    /* renamed from: h0, reason: collision with root package name */
    private float f97714h0;

    /* renamed from: i, reason: collision with root package name */
    Rect f97715i;

    /* renamed from: i0, reason: collision with root package name */
    private float f97716i0;

    /* renamed from: j0, reason: collision with root package name */
    private float f97717j0;

    /* renamed from: k0, reason: collision with root package name */
    private boolean f97718k0;

    /* renamed from: l0, reason: collision with root package name */
    private boolean f97719l0;

    /* renamed from: m, reason: collision with root package name */
    Rect f97720m;

    /* renamed from: m0, reason: collision with root package name */
    private boolean f97721m0;

    /* renamed from: n0, reason: collision with root package name */
    private f f97722n0;

    /* renamed from: o0, reason: collision with root package name */
    protected long f97723o0;

    /* renamed from: p0, reason: collision with root package name */
    protected long f97724p0;

    /* renamed from: q0, reason: collision with root package name */
    public StringBuilder f97725q0;

    /* renamed from: r0, reason: collision with root package name */
    public boolean f97726r0;

    /* renamed from: s0, reason: collision with root package name */
    Handler f97727s0;

    /* renamed from: t0, reason: collision with root package name */
    private boolean f97728t0;

    /* compiled from: P */
    /* renamed from: com.tencent.biz.widgets.ScannerView$8, reason: invalid class name */
    /* loaded from: classes5.dex */
    class AnonymousClass8 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f97730d;
        final /* synthetic */ ScannerView this$0;

        @Override // java.lang.Runnable
        public void run() {
            try {
                LockMethodProxy.sleep(1000L);
            } catch (InterruptedException unused) {
            }
            ScannerView scannerView = this.this$0;
            Camera camera2 = scannerView.K;
            if (camera2 != null) {
                scannerView.v(camera2, this.f97730d);
            } else {
                scannerView.f97727s0.obtainMessage(10, Boolean.FALSE).sendToTarget();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class AutoFocusThread extends BaseThread implements Camera.AutoFocusCallback {
        Camera C;
        protected Runnable E = new Runnable() { // from class: com.tencent.biz.widgets.ScannerView.AutoFocusThread.1
            @Override // java.lang.Runnable
            public void run() {
                Camera camera2 = AutoFocusThread.this.C;
                if (camera2 == null) {
                    return;
                }
                try {
                    camera2.cancelAutoFocus();
                } catch (Exception unused) {
                }
                ScannerView.this.f97721m0 = true;
            }
        };
        Handler D = new Handler(Looper.getMainLooper());

        public AutoFocusThread(Camera camera2) {
            this.C = camera2;
        }

        public void o() {
            synchronized (this) {
                if (ScannerView.this.f97721m0 && this.C != null && ScannerView.this.f97703a0) {
                    this.D.postDelayed(this.E, 2500L);
                    this.C.autoFocus(this);
                    ScannerView.this.f97721m0 = false;
                }
            }
        }

        @Override // android.hardware.Camera.AutoFocusCallback
        public void onAutoFocus(boolean z16, Camera camera2) {
            if (QLog.isDevelopLevel()) {
                QLog.d("ScannerView", 4, "onAutoFocus");
            }
            ScannerView.this.f97721m0 = true;
            this.D.removeCallbacks(this.E);
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            while (true) {
                try {
                    if (ScannerView.this.f97718k0) {
                        ScannerView.this.f97718k0 = false;
                    } else {
                        LockMethodProxy.sleep(3000L);
                    }
                    try {
                        o();
                    } catch (RuntimeException unused) {
                    }
                } catch (InterruptedException unused2) {
                    if (!ScannerView.this.f97721m0) {
                        try {
                            this.C.cancelAutoFocus();
                            ScannerView.this.f97721m0 = true;
                            this.D.removeCallbacks(this.E);
                        } catch (RuntimeException unused3) {
                        }
                        this.C = null;
                        return;
                    }
                    return;
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class DecodeThread extends BaseHandlerThread {

        /* renamed from: m, reason: collision with root package name */
        public boolean f97732m;

        public DecodeThread(String str) {
            super(str);
            this.f97732m = false;
        }

        @Override // android.os.HandlerThread
        public boolean quit() {
            this.f97732m = true;
            if (QLog.isColorLevel()) {
                QLog.d("ScannerView", 2, "decode thread quit");
            }
            try {
                ((IQRCodeApi) QRoute.api(IQRCodeApi.class)).releaseForCamera();
            } catch (UnsatisfiedLinkError e16) {
                if (QLog.isColorLevel()) {
                    QLog.w("ScannerView", 2, e16.toString());
                }
            }
            return super.quit();
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread, android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            Process.setThreadPriority(-20);
            try {
                int initForCamera = ((IQRCodeApi) QRoute.api(IQRCodeApi.class)).initForCamera(0, "ANY", "UTF-8");
                int readersForCamera = ((IQRCodeApi) QRoute.api(IQRCodeApi.class)).setReadersForCamera(((IQRCodeApi) QRoute.api(IQRCodeApi.class)).getSupportReader());
                String version = ((IQRCodeApi) QRoute.api(IQRCodeApi.class)).getVersion();
                if (QLog.isDevelopLevel()) {
                    QLog.d("ScannerView", 4, "init for camera initResult:" + initForCamera + ",setReadersResult:" + readersForCamera);
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("version:");
                    sb5.append(version);
                    QLog.d("ScannerView", 4, sb5.toString());
                }
            } catch (UnsatisfiedLinkError e16) {
                if (QLog.isColorLevel()) {
                    QLog.w("ScannerView", 2, e16.toString());
                }
            }
            super.run();
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 9) {
                e eVar = ScannerView.this.f97707d0;
                if (eVar != null) {
                    int i3 = message.what;
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 != 7) {
                                if (i3 == 8) {
                                    eVar.o();
                                    return;
                                }
                            } else {
                                eVar.a0();
                                return;
                            }
                        } else {
                            eVar.z();
                            return;
                        }
                    } else {
                        eVar.k(String.valueOf(message.obj));
                        return;
                    }
                }
                c cVar = ScannerView.this.f97709e0;
                if (cVar != null) {
                    int i16 = message.what;
                    if (i16 != 3) {
                        if (i16 == 4) {
                            cVar.c(1);
                            return;
                        }
                    } else {
                        cVar.x(String.valueOf(message.obj), 1, 1);
                        return;
                    }
                }
                ScannerView.c(ScannerView.this);
                return;
            }
            QQToast.makeText(ScannerView.this.getContext(), ScannerView.this.getContext().getString(R.string.f170665xu), 1).show();
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class b extends Handler {
        b(Looper looper) {
            super(looper);
        }

        /* JADX WARN: Can't wrap try/catch for region: R(11:20|(3:22|(1:(2:24|(2:27|28)(1:26))(2:34|35))|(1:30)(2:31|(1:33)))|36|(5:(1:39)|40|(1:42)(2:45|(1:47)(2:48|(1:50)(1:51)))|43|44)|(4:52|53|54|55)|(2:57|(2:69|(2:71|(2:75|(9:77|78|79|80|81|82|83|(1:85)|(2:88|89)(2:90|91))))))|100|82|83|(0)|(0)(0)) */
        /* JADX WARN: Code restructure failed: missing block: B:92:0x023b, code lost:
        
            r0 = e;
         */
        /* JADX WARN: Removed duplicated region for block: B:85:0x0224 A[Catch: UnsatisfiedLinkError -> 0x023b, TRY_LEAVE, TryCatch #3 {UnsatisfiedLinkError -> 0x023b, blocks: (B:83:0x0218, B:85:0x0224), top: B:82:0x0218 }] */
        /* JADX WARN: Removed duplicated region for block: B:88:0x024f  */
        /* JADX WARN: Removed duplicated region for block: B:90:0x02bb  */
        /* JADX WARN: Removed duplicated region for block: B:95:0x0246  */
        @Override // android.os.Handler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void handleMessage(Message message) {
            int i3;
            int i16;
            long currentTimeMillis;
            int[] iArr;
            byte[] bArr;
            Rect rect;
            boolean z16;
            Pair<StringBuilder, StringBuilder> pair;
            int i17 = message.what;
            if (i17 != 5) {
                if (i17 == 6) {
                    if (message.obj instanceof Uri) {
                        pair = ((IScanUtilApi) QRoute.api(IScanUtilApi.class)).decodeQRCodeFromFile((Uri) message.obj, ScannerView.this.getContext());
                    } else {
                        pair = null;
                    }
                    if (pair != null) {
                        ScannerView.this.f97727s0.obtainMessage(3, pair.first).sendToTarget();
                        return;
                    } else {
                        ScannerView.this.f97727s0.sendEmptyMessage(4);
                        return;
                    }
                }
                return;
            }
            ScannerView scannerView = ScannerView.this;
            scannerView.f97724p0++;
            Object obj = message.obj;
            if (obj != null && (obj instanceof byte[])) {
                byte[] bArr2 = (byte[]) obj;
                if (scannerView.L < 3) {
                    int length = bArr2.length;
                    int i18 = 0;
                    while (true) {
                        if (i18 < length) {
                            if (bArr2[i18] != 0) {
                                z16 = true;
                                break;
                            }
                            i18++;
                        } else {
                            z16 = false;
                            break;
                        }
                    }
                    if (z16) {
                        ScannerView.this.L = 3;
                    } else {
                        ScannerView scannerView2 = ScannerView.this;
                        int i19 = scannerView2.L + 1;
                        scannerView2.L = i19;
                        if (i19 == 3) {
                            scannerView2.f97727s0.sendEmptyMessage(9);
                        }
                    }
                }
                ScannerView scannerView3 = ScannerView.this;
                Rect rect2 = scannerView3.f97715i;
                Rect rect3 = scannerView3.f97713h;
                if (rect2 == null) {
                    if (rect3 == null) {
                        ScannerView scannerView4 = ScannerView.this;
                        rect3 = new Rect(0, 0, scannerView4.G, scannerView4.H);
                        scannerView3.f97713h = rect3;
                    }
                    int i26 = ScannerView.this.I;
                    if (i26 == 90) {
                        float f16 = r0.C / r0.H;
                        float f17 = r0.D / r0.G;
                        int i27 = ScannerView.this.G;
                        rect = new Rect((int) (rect3.top * f16), (int) ((i27 - rect3.right) * f17), (int) (rect3.bottom * f16), (int) ((i27 - rect3.left) * f17));
                    } else if (i26 == 180) {
                        float f18 = r0.C / r0.G;
                        float f19 = r0.D / r0.H;
                        ScannerView scannerView5 = ScannerView.this;
                        int i28 = scannerView5.G;
                        int i29 = scannerView5.H;
                        rect = new Rect((int) ((i28 - rect3.right) * f18), (int) ((i29 - rect3.bottom) * f19), (int) ((i28 - rect3.left) * f18), (int) ((i29 - rect3.top) * f19));
                    } else if (i26 == 270) {
                        float f26 = r0.C / r0.H;
                        float f27 = r0.D / r0.G;
                        int i36 = ScannerView.this.H;
                        rect = new Rect((int) ((i36 - rect3.bottom) * f26), (int) (rect3.left * f27), (int) ((i36 - rect3.top) * f26), (int) (rect3.right * f27));
                    } else {
                        float f28 = r0.C / r0.G;
                        float f29 = r0.D / r0.H;
                        rect = new Rect((int) (rect3.left * f28), (int) (rect3.top * f29), (int) (rect3.right * f28), (int) (rect3.bottom * f29));
                    }
                    rect2 = rect;
                    ScannerView.this.f97715i = rect2;
                }
                try {
                    currentTimeMillis = System.currentTimeMillis();
                    iArr = new int[2];
                    try {
                        try {
                            bArr = new byte[((rect2.width() * rect2.height()) * 3) >> 1];
                        } catch (UnsatisfiedLinkError e16) {
                            e = e16;
                            i16 = 0;
                            if (QLog.isColorLevel()) {
                            }
                            if (i16 != 1) {
                            }
                        }
                    } catch (OutOfMemoryError e17) {
                        if (QLog.isColorLevel()) {
                            QLog.w("ScannerView", 2, e17.toString());
                        }
                        bArr = null;
                    }
                } catch (UnsatisfiedLinkError e18) {
                    e = e18;
                    i3 = 0;
                    i16 = i3;
                    if (QLog.isColorLevel()) {
                    }
                    if (i16 != 1) {
                    }
                }
                if (bArr != null) {
                    ScannerView scannerView6 = ScannerView.this;
                    if (scannerView6.C > 0 && scannerView6.D > 0 && rect2.left >= 0 && rect2.top >= 0 && rect2.width() > 0 && rect2.height() > 0) {
                        int i37 = rect2.right;
                        ScannerView scannerView7 = ScannerView.this;
                        int i38 = scannerView7.C;
                        if (i37 <= i38) {
                            int i39 = rect2.bottom;
                            int i46 = scannerView7.D;
                            if (i39 <= i46 && bArr2.length == (((i38 * i46) * 3) >> 1)) {
                                IImgProcessApi iImgProcessApi = (IImgProcessApi) QRoute.api(IImgProcessApi.class);
                                ScannerView scannerView8 = ScannerView.this;
                                if (iImgProcessApi.gray_rotate_crop_sub(bArr, iArr, bArr2, scannerView8.C, scannerView8.D, rect2.left, rect2.top, rect2.width(), rect2.height(), ScannerView.this.I, 0) == 0) {
                                    i3 = 0;
                                    try {
                                        i16 = ((IQRCodeApi) QRoute.api(IQRCodeApi.class)).scanImageForCamera(bArr, iArr[0], iArr[1]);
                                        double currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                                        if (QLog.isDevelopLevel()) {
                                            QLog.d("ScannerView", 4, "detect time:" + currentTimeMillis2);
                                        }
                                    } catch (UnsatisfiedLinkError e19) {
                                        e = e19;
                                        i16 = i3;
                                        if (QLog.isColorLevel()) {
                                            QLog.w("ScannerView", 2, e.toString());
                                        }
                                        if (i16 != 1) {
                                        }
                                    }
                                    if (i16 != 1) {
                                        StringBuilder sb5 = new StringBuilder();
                                        StringBuilder sb6 = new StringBuilder();
                                        ((IQRCodeApi) QRoute.api(IQRCodeApi.class)).getOneResultForCamera(sb5, sb6);
                                        ReportController.o(null, "P_CliOper", "BizTechReport", "", "qrdecode", "decodeSuccess", 0, 0, "" + (System.currentTimeMillis() - ScannerView.this.f97723o0), "" + ScannerView.this.f97724p0, "", "");
                                        ScannerView scannerView9 = ScannerView.this;
                                        scannerView9.f97725q0 = sb5;
                                        scannerView9.f97727s0.obtainMessage(1, sb6).sendToTarget();
                                        return;
                                    }
                                    ScannerView.this.f97727s0.sendEmptyMessage(2);
                                    return;
                                }
                            }
                        }
                    }
                }
                i16 = 0;
                double currentTimeMillis22 = System.currentTimeMillis() - currentTimeMillis;
                if (QLog.isDevelopLevel()) {
                }
                if (i16 != 1) {
                }
            } else {
                scannerView.f97727s0.sendEmptyMessage(2);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface c {
        void c(int i3);

        void x(String str, int i3, int i16);
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface d {
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface e {
        void a0();

        void k(String str);

        void o();

        void z();
    }

    public ScannerView(Context context) {
        super(context);
        this.f97706d = new ReentrantLock();
        this.f97713h = null;
        this.f97715i = null;
        this.f97720m = new Rect();
        this.L = 0;
        this.P = 0;
        this.Q = 0;
        this.R = 0;
        this.S = 0;
        this.T = -1;
        this.U = -1;
        this.V = 17;
        this.W = false;
        this.f97703a0 = false;
        this.f97704b0 = false;
        this.f97705c0 = false;
        this.f97714h0 = 0.0f;
        this.f97716i0 = 0.0f;
        this.f97717j0 = 0.0f;
        this.f97718k0 = true;
        this.f97719l0 = false;
        this.f97721m0 = true;
        this.f97726r0 = false;
        this.f97727s0 = new a();
        this.f97728t0 = false;
        y(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(9)
    public boolean B() {
        int i3;
        int i16;
        boolean z16;
        this.f97706d.lock();
        boolean z17 = false;
        try {
            try {
            } catch (RuntimeException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("ScannerView", 2, "camera open failed:" + e16.getMessage());
                }
            }
            if (this.K != null) {
                if (QLog.isColorLevel()) {
                    QLog.d("ScannerView", 2, "camera already opened");
                }
                return true;
            }
            int numberOfCameras = Camera.getNumberOfCameras();
            if (numberOfCameras > 0) {
                Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                int i17 = 0;
                while (i17 < numberOfCameras) {
                    Camera.getCameraInfo(i17, cameraInfo);
                    if (cameraInfo.facing == 0) {
                        break;
                    }
                    i17++;
                }
                if (i17 >= numberOfCameras) {
                    Camera.getCameraInfo(0, cameraInfo);
                    i17 = 0;
                    i16 = 1;
                } else {
                    i16 = 0;
                }
                this.K = CameraUtil.openCameraWithRetry(i17);
                i3 = cameraInfo.orientation;
            } else {
                i3 = 90;
                i16 = 0;
            }
            int i18 = wy2.d.f446764n;
            if (i18 <= 0) {
                i18 = i3;
            }
            this.E = i18;
            this.F = i16;
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("camera open:");
                if (this.K != null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                sb5.append(z16);
                sb5.append(" orientation:");
                sb5.append(i3);
                sb5.append(" facing:");
                sb5.append(i16);
                QLog.d("ScannerView", 2, sb5.toString());
            }
            if (this.K != null) {
                z17 = true;
            }
            return z17;
        } finally {
            this.f97706d.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x011a, code lost:
    
        if (r8.contains("edof") != false) goto L85;
     */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0120 A[Catch: RuntimeException -> 0x012f, all -> 0x0185, IOException -> 0x0191, TRY_ENTER, TryCatch #4 {IOException -> 0x0191, blocks: (B:4:0x0010, B:9:0x001a, B:11:0x001e, B:13:0x0022, B:15:0x0028, B:16:0x002d, B:17:0x0032, B:19:0x004d, B:20:0x005a, B:22:0x0062, B:23:0x0080, B:25:0x0091, B:27:0x009c, B:28:0x00a1, B:30:0x00b9, B:32:0x00db, B:66:0x00ee, B:68:0x00f4, B:33:0x00fa, B:36:0x0101, B:50:0x010e, B:41:0x0120, B:44:0x0128, B:53:0x0116, B:46:0x0130, B:48:0x0136, B:57:0x0151, B:59:0x016a, B:63:0x0173, B:71:0x0055), top: B:3:0x0010, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0128 A[Catch: RuntimeException -> 0x012f, all -> 0x0185, IOException -> 0x0191, TRY_LEAVE, TryCatch #4 {IOException -> 0x0191, blocks: (B:4:0x0010, B:9:0x001a, B:11:0x001e, B:13:0x0022, B:15:0x0028, B:16:0x002d, B:17:0x0032, B:19:0x004d, B:20:0x005a, B:22:0x0062, B:23:0x0080, B:25:0x0091, B:27:0x009c, B:28:0x00a1, B:30:0x00b9, B:32:0x00db, B:66:0x00ee, B:68:0x00f4, B:33:0x00fa, B:36:0x0101, B:50:0x010e, B:41:0x0120, B:44:0x0128, B:53:0x0116, B:46:0x0130, B:48:0x0136, B:57:0x0151, B:59:0x016a, B:63:0x0173, B:71:0x0055), top: B:3:0x0010, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0136 A[Catch: all -> 0x0185, RuntimeException -> 0x0187, IOException -> 0x0191, TryCatch #0 {RuntimeException -> 0x0187, blocks: (B:4:0x0010, B:9:0x001a, B:11:0x001e, B:13:0x0022, B:15:0x0028, B:16:0x002d, B:17:0x0032, B:19:0x004d, B:20:0x005a, B:22:0x0062, B:23:0x0080, B:25:0x0091, B:28:0x00a1, B:30:0x00b9, B:66:0x00ee, B:68:0x00f4, B:33:0x00fa, B:36:0x0101, B:46:0x0130, B:48:0x0136, B:57:0x0151, B:59:0x016a, B:63:0x0173, B:71:0x0055), top: B:3:0x0010, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x016a A[Catch: all -> 0x0185, RuntimeException -> 0x0187, IOException -> 0x0191, TryCatch #0 {RuntimeException -> 0x0187, blocks: (B:4:0x0010, B:9:0x001a, B:11:0x001e, B:13:0x0022, B:15:0x0028, B:16:0x002d, B:17:0x0032, B:19:0x004d, B:20:0x005a, B:22:0x0062, B:23:0x0080, B:25:0x0091, B:28:0x00a1, B:30:0x00b9, B:66:0x00ee, B:68:0x00f4, B:33:0x00fa, B:36:0x0101, B:46:0x0130, B:48:0x0136, B:57:0x0151, B:59:0x016a, B:63:0x0173, B:71:0x0055), top: B:3:0x0010, outer: #2 }] */
    @TargetApi(8)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean E() {
        int i3;
        String str = "edof";
        this.f97706d.lock();
        try {
            try {
                try {
                    if (this.K == null) {
                        return false;
                    }
                    if (this.f97704b0) {
                        AutoFocusThread autoFocusThread = this.f97711f0;
                        if (autoFocusThread != null && autoFocusThread.isAlive()) {
                            this.f97711f0.interrupt();
                        }
                        this.K.stopPreview();
                    }
                    int orientation = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getOrientation() * 90;
                    if (this.F == 0) {
                        i3 = ((this.E - orientation) + 360) % 360;
                    } else {
                        i3 = (this.E + orientation) % 360;
                    }
                    this.I = i3;
                    if (QLog.isColorLevel()) {
                        QLog.d("ScannerView", 2, "screenRotation:" + orientation + " previewRotation:" + i3);
                    }
                    Camera.Parameters parameters = this.K.getParameters();
                    this.K.setDisplayOrientation(i3);
                    if (parameters.isZoomSupported()) {
                        parameters.setZoom(Math.min(2, parameters.getMaxZoom()));
                    }
                    try {
                        this.K.setParameters(parameters);
                    } catch (RuntimeException unused) {
                    }
                    Point x16 = x(this.K, this.G, this.H);
                    this.C = x16.x;
                    this.D = x16.y;
                    if (QLog.isColorLevel()) {
                        QLog.d("ScannerView", 2, "best preview size:" + x16.x + " x " + x16.y);
                    }
                    try {
                        Camera.Parameters parameters2 = this.K.getParameters();
                        parameters2.setPreviewSize(x16.x, x16.y);
                        this.K.setParameters(parameters2);
                    } catch (RuntimeException unused2) {
                        if (QLog.isColorLevel()) {
                            QLog.d("ScannerView", 2, "set preview size failed, using default");
                        }
                    }
                    String str2 = this.J;
                    if (str2 == null) {
                        Camera.Parameters parameters3 = this.K.getParameters();
                        List<String> supportedFocusModes = parameters3.getSupportedFocusModes();
                        try {
                            if (supportedFocusModes != null) {
                                try {
                                    if (supportedFocusModes.contains("auto")) {
                                        str = "auto";
                                    }
                                    if (str == null) {
                                        this.K.setParameters(parameters3);
                                        this.J = str;
                                    } else {
                                        this.J = "unsupported";
                                    }
                                    str2 = str;
                                } catch (RuntimeException unused3) {
                                    if (QLog.isColorLevel()) {
                                        QLog.d("ScannerView", 2, "set focus mode:" + str2 + ", failed");
                                    }
                                    this.K.setPreviewDisplay(this.M.getHolder());
                                    this.K.startPreview();
                                    this.f97704b0 = true;
                                    if (!"auto".equals(str2)) {
                                    }
                                    AutoFocusThread autoFocusThread2 = new AutoFocusThread(this.K);
                                    this.f97711f0 = autoFocusThread2;
                                    autoFocusThread2.start();
                                    return true;
                                }
                            }
                            if (str == null) {
                            }
                            str2 = str;
                        } catch (RuntimeException unused4) {
                            str2 = str;
                            if (QLog.isColorLevel()) {
                            }
                            this.K.setPreviewDisplay(this.M.getHolder());
                            this.K.startPreview();
                            this.f97704b0 = true;
                            if (!"auto".equals(str2)) {
                            }
                            AutoFocusThread autoFocusThread22 = new AutoFocusThread(this.K);
                            this.f97711f0 = autoFocusThread22;
                            autoFocusThread22.start();
                            return true;
                        }
                        str = str2;
                    }
                    this.K.setPreviewDisplay(this.M.getHolder());
                    this.K.startPreview();
                    this.f97704b0 = true;
                    if (!"auto".equals(str2) || "macro".equals(str2)) {
                        AutoFocusThread autoFocusThread222 = new AutoFocusThread(this.K);
                        this.f97711f0 = autoFocusThread222;
                        autoFocusThread222.start();
                    }
                    return true;
                } catch (IOException unused5) {
                    if (QLog.isColorLevel()) {
                        QLog.d("ScannerView", 2, "start preview failed");
                    }
                    return false;
                }
            } catch (RuntimeException unused6) {
                if (QLog.isColorLevel()) {
                    QLog.d("ScannerView", 2, "start preview failed");
                }
                return false;
            }
        } finally {
            this.f97706d.unlock();
        }
    }

    static /* bridge */ /* synthetic */ d c(ScannerView scannerView) {
        scannerView.getClass();
        return null;
    }

    private void r() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
        } else {
            throw new RuntimeException("This method must be called on UI thread");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        this.f97706d.lock();
        try {
            if (this.K == null) {
                return;
            }
            AutoFocusThread autoFocusThread = this.f97711f0;
            if (autoFocusThread != null && autoFocusThread.isAlive()) {
                this.f97711f0.interrupt();
                this.f97711f0 = null;
            }
            try {
                Camera.Parameters parameters = this.K.getParameters();
                parameters.setFlashMode(DebugKt.DEBUG_PROPERTY_VALUE_OFF);
                this.K.setParameters(parameters);
                this.f97705c0 = false;
            } catch (RuntimeException unused) {
            }
            if (this.f97704b0) {
                this.f97704b0 = false;
                this.K.stopPreview();
            }
            this.K.release();
            this.K = null;
        } finally {
            this.f97706d.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(Camera camera2, boolean z16) {
        Boolean bool;
        try {
            Camera.Parameters parameters = camera2.getParameters();
            String str = "torch";
            if (!wy2.d.f446760j) {
                str = wy2.c.d().i(parameters);
            }
            if (!z16) {
                str = DebugKt.DEBUG_PROPERTY_VALUE_OFF;
            }
            parameters.setFlashMode(str);
            camera2.setParameters(parameters);
        } catch (RuntimeException unused) {
            z16 = false;
        }
        if (this.f97704b0 && ("auto".equals(this.J) || "macro".equals(this.J))) {
            AutoFocusThread autoFocusThread = new AutoFocusThread(this.K);
            this.f97711f0 = autoFocusThread;
            autoFocusThread.start();
        }
        this.f97705c0 = z16;
        Handler handler = this.f97727s0;
        if (z16) {
            bool = Boolean.TRUE;
        } else {
            bool = Boolean.FALSE;
        }
        handler.obtainMessage(10, bool).sendToTarget();
    }

    private Point x(Camera camera2, int i3, int i16) {
        boolean z16;
        int i17;
        int i18;
        Camera.Parameters parameters = camera2.getParameters();
        Camera.Size previewSize = parameters.getPreviewSize();
        String str = Build.MANUFACTURER;
        if (CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_SANXING.equalsIgnoreCase(str) && "GT-I9008L".equalsIgnoreCase(DeviceInfoMonitor.getModel())) {
            return new Point(previewSize.width, previewSize.height);
        }
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        if (supportedPreviewSizes == null) {
            return new Point(previewSize.width, previewSize.height);
        }
        ArrayList<Camera.Size> arrayList = new ArrayList(supportedPreviewSizes);
        Collections.sort(arrayList, this);
        if (QLog.isDevelopLevel()) {
            StringBuilder sb5 = new StringBuilder("manufacturer:");
            sb5.append(str);
            sb5.append(" model:");
            sb5.append(DeviceInfoMonitor.getModel());
            sb5.append("\ndefault size:");
            sb5.append(previewSize.width);
            sb5.append(" x ");
            sb5.append(previewSize.height);
            sb5.append("\nsizes:");
            for (Camera.Size size : arrayList) {
                sb5.append(size.width);
                sb5.append(" x ");
                sb5.append(size.height);
                sb5.append(APLogFileUtil.SEPARATOR_LOG);
            }
            QLog.d("ScannerView", 4, sb5.toString());
        }
        float f16 = i3 / i16;
        Point point = null;
        float f17 = Float.POSITIVE_INFINITY;
        for (Camera.Size size2 : arrayList) {
            int i19 = size2.width;
            int i26 = size2.height;
            int i27 = i19 * i26;
            if (i27 >= 76800 && i27 <= 921600 && (i19 != 980 || i26 != 800 || !CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_SANXING.equalsIgnoreCase(Build.MANUFACTURER) || (!"GT-I9220".equalsIgnoreCase(DeviceInfoMonitor.getModel()) && !"GT-N7000".equalsIgnoreCase(DeviceInfoMonitor.getModel())))) {
                if (((i19 != 1184 || i26 != 666) && (i19 != 704 || i26 != 576)) || !CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_SANXING.equalsIgnoreCase(Build.MANUFACTURER) || !"GT-I9300".equalsIgnoreCase(DeviceInfoMonitor.getModel())) {
                    boolean z17 = false;
                    if (i3 > i16) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (i19 < i26) {
                        z17 = true;
                    }
                    if (z16 == z17) {
                        i18 = i26;
                        i17 = i19;
                    } else {
                        i17 = i26;
                        i18 = i19;
                    }
                    if (i18 == i3 && i17 == i16) {
                        return new Point(i19, i26);
                    }
                    if (i18 >= (i3 >> 1) && (i18 >> 1) <= i3 && i17 >= (i16 >> 1) && (i17 >> 1) <= i16) {
                        float abs = Math.abs((i18 / i17) - f16);
                        if (abs < f17) {
                            point = new Point(i19, i26);
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

    private void y(Context context, AttributeSet attributeSet) {
        setKeepScreenOn(true);
        w(context);
        SurfaceView surfaceView = new SurfaceView(context, attributeSet);
        this.M = surfaceView;
        addView(surfaceView);
        this.M.getHolder().addCallback(this);
        if (attributeSet != null && attributeSet.getAttributeBooleanValue(R.styleable.ScannerView_viewFinder, true)) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ScannerView);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = obtainStyledAttributes.getIndex(i3);
                if (index == R.styleable.ScannerView_viewFinder_bottom) {
                    this.S = obtainStyledAttributes.getDimensionPixelOffset(index, this.S);
                } else if (index == R.styleable.ScannerView_viewFinder_left) {
                    this.Q = obtainStyledAttributes.getDimensionPixelOffset(index, this.Q);
                } else if (index == R.styleable.ScannerView_viewFinder_right) {
                    this.R = obtainStyledAttributes.getDimensionPixelOffset(index, this.R);
                } else if (index == R.styleable.ScannerView_viewFinder_top) {
                    this.P = obtainStyledAttributes.getDimensionPixelOffset(index, this.P);
                } else if (index == R.styleable.ScannerView_viewFinder_width) {
                    this.T = obtainStyledAttributes.getLayoutDimension(index, this.T);
                } else if (index == R.styleable.ScannerView_viewFinder_height) {
                    this.U = obtainStyledAttributes.getLayoutDimension(index, this.U);
                } else if (index == R.styleable.ScannerView_viewFinder_gravity) {
                    this.V = obtainStyledAttributes.getInt(index, this.V);
                }
            }
            obtainStyledAttributes.recycle();
            ViewFinderView viewFinderView = new ViewFinderView(context);
            this.N = viewFinderView;
            addView(viewFinderView);
        }
        if (attributeSet != null) {
            this.W = attributeSet.getAttributeBooleanValue(R.styleable.ScannerView_autoStart, true);
        }
    }

    private static boolean z() {
        if ("Lenovo K50-t5".equalsIgnoreCase(DeviceInfoMonitor.getModel()) && "LENOVO".equalsIgnoreCase(Build.MANUFACTURER)) {
            return true;
        }
        if ("Redmi Note 3".equalsIgnoreCase(DeviceInfoMonitor.getModel()) && CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_XIAOMI.equalsIgnoreCase(Build.MANUFACTURER)) {
            return true;
        }
        return false;
    }

    public void A(SensorEvent sensorEvent) {
        if (this.K != null && this.f97703a0 && this.f97711f0 != null && !this.f97718k0) {
            float[] fArr = sensorEvent.values;
            float f16 = fArr[0];
            float f17 = fArr[1];
            float f18 = fArr[2];
            if (!this.f97719l0) {
                this.f97714h0 = f16;
                this.f97716i0 = f17;
                this.f97717j0 = f18;
                this.f97719l0 = true;
            }
            float abs = Math.abs(this.f97714h0 - f16);
            float abs2 = Math.abs(this.f97716i0 - f17);
            float abs3 = Math.abs(this.f97717j0 - f18);
            if ((abs > 0.5d || abs2 > 0.5d || abs3 > 0.5d) && this.f97721m0) {
                try {
                    this.f97711f0.o();
                } catch (RuntimeException unused) {
                }
            }
            this.f97714h0 = f16;
            this.f97716i0 = f17;
            this.f97717j0 = f18;
        }
    }

    public void C(boolean z16) {
        if (this.f97728t0 && E()) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.widgets.ScannerView.6
                @Override // java.lang.Runnable
                public void run() {
                    if (ScannerView.this.N != null) {
                        ScannerView.this.N.b();
                    }
                }
            });
            this.f97723o0 = System.currentTimeMillis();
            this.f97724p0 = 0L;
            this.f97727s0.sendEmptyMessage(7);
            return;
        }
        this.f97727s0.sendEmptyMessage(8);
    }

    public void D() {
        if (this.f97708e == null) {
            synchronized (this) {
                if (this.f97708e == null) {
                    DecodeThread decodeThread = new DecodeThread("ScannerDecodeThread");
                    this.f97708e = decodeThread;
                    decodeThread.start();
                    this.f97710f = new b(this.f97708e.getLooper());
                }
            }
        }
        if (!this.f97708e.f97732m && this.f97706d.tryLock()) {
            try {
                Camera camera2 = this.K;
                if (camera2 == null) {
                    return;
                }
                camera2.setOneShotPreviewCallback(this);
            } finally {
                this.f97706d.unlock();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        u();
        synchronized (this) {
            DecodeThread decodeThread = this.f97708e;
            if (decodeThread != null && !decodeThread.f97732m) {
                decodeThread.quit();
                this.f97710f.removeCallbacksAndMessages(null);
                this.f97710f = null;
            }
            this.f97727s0.removeCallbacksAndMessages(null);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        int i19;
        int i26;
        int i27;
        int i28;
        int i29;
        int i36 = i17 - i3;
        int i37 = i18 - i16;
        this.M.layout(0, 0, i36, i37);
        ViewFinderView viewFinderView = this.N;
        if (viewFinderView != null) {
            viewFinderView.layout(0, 0, i36, i37);
            int i38 = this.T;
            if (i38 == -1) {
                i27 = this.Q;
                i26 = i36 - this.R;
            } else {
                int i39 = this.V;
                if ((i39 & 3) == 3) {
                    i19 = this.Q;
                } else if ((i39 & 5) == 5) {
                    i26 = i36 - this.R;
                    i27 = i26 - i38;
                } else {
                    i19 = (i36 - i38) >> 1;
                }
                i26 = i19 + i38;
                i27 = i19;
            }
            int i46 = this.U;
            if (i46 == -1) {
                i28 = this.P;
                i29 = i37 - this.S;
            } else {
                int i47 = this.V;
                if ((i47 & 48) == 48) {
                    i28 = this.P;
                } else if ((i47 & 80) == 80) {
                    i29 = i37 - this.S;
                    i28 = i29 - i46;
                } else {
                    i28 = (i37 - i46) >> 1;
                }
                i29 = i28 + i46;
            }
            Rect rect = this.f97713h;
            if (this.f97720m == null) {
                this.f97720m = new Rect();
            }
            this.f97720m.set(i27, i28, i26, i29);
            this.f97713h = this.f97720m;
            this.f97720m = rect;
            this.f97715i = null;
            this.N.a(i27, i28, i26, i29);
        }
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera2) {
        Handler handler = this.f97710f;
        if (handler != null) {
            handler.obtainMessage(5, this.C, this.D, bArr).sendToTarget();
        }
    }

    public void p() {
        this.W = false;
        ViewFinderView viewFinderView = this.N;
        if (viewFinderView != null) {
            viewFinderView.c();
        }
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.biz.widgets.ScannerView.7
            @Override // java.lang.Runnable
            public void run() {
                ScannerView.this.s();
            }
        }, 8, null, false);
    }

    public void q() {
        this.W = true;
        if (this.f97703a0) {
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.biz.widgets.ScannerView.5
                @Override // java.lang.Runnable
                public void run() {
                    ScannerView.this.f97728t0 = false;
                    ScannerView scannerView = ScannerView.this;
                    scannerView.f97728t0 = scannerView.B();
                    ScannerView scannerView2 = ScannerView.this;
                    scannerView2.C(scannerView2.f97728t0);
                }
            }, 8, null, true);
        }
    }

    public void setFileDecodeListener(c cVar) {
        r();
        this.f97709e0 = cVar;
    }

    public void setFlashLightListener(d dVar) {
        r();
    }

    public void setScanListener(e eVar) {
        r();
        this.f97707d0 = eVar;
    }

    public void setViewFinder(int i3, int i16, int i17, int i18) {
        r();
        this.V = 51;
        this.Q = i3;
        this.P = i16;
        this.T = i17 - i3;
        this.U = i18 - i16;
        this.R = 0;
        this.S = 0;
        if (this.N == null) {
            ViewFinderView viewFinderView = new ViewFinderView(getContext());
            this.N = viewFinderView;
            addView(viewFinderView);
        } else {
            this.f97713h = new Rect(i3, i16, i17, i18);
            this.f97715i = null;
            this.N.a(i3, i16, i17, i18);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i3, int i16, int i17) {
        this.G = i16;
        this.H = i17;
        if (this.W) {
            if (!this.f97704b0) {
                ThreadManagerV2.post(new Runnable() { // from class: com.tencent.biz.widgets.ScannerView.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ScannerView.this.B() && ScannerView.this.E()) {
                            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.widgets.ScannerView.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (ScannerView.this.N != null) {
                                        ScannerView.this.N.b();
                                    }
                                }
                            });
                            ScannerView.this.f97727s0.sendEmptyMessage(7);
                        } else {
                            ScannerView.this.f97727s0.sendEmptyMessage(8);
                        }
                    }
                }, 8, null, true);
            } else {
                ThreadManagerV2.post(new Runnable() { // from class: com.tencent.biz.widgets.ScannerView.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!ScannerView.this.E()) {
                            ScannerView.this.f97727s0.sendEmptyMessage(8);
                        }
                    }
                }, 8, null, true);
            }
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.f97703a0 = true;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.f97703a0 = false;
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.biz.widgets.ScannerView.4
            @Override // java.lang.Runnable
            public void run() {
                ScannerView.this.s();
            }
        }, 8, null, false);
    }

    @Override // java.util.Comparator
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public int compare(Camera.Size size, Camera.Size size2) {
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

    public void u() {
        SensorManager sensorManager = this.f97712g0;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this.f97722n0);
            this.f97712g0 = null;
            this.f97722n0 = null;
        }
    }

    public void w(Context context) {
        if (z()) {
            return;
        }
        SensorManager sensorManager = (SensorManager) context.getApplicationContext().getSystemService(WebRTCSDK.PRIVILEGE_SENSOR);
        this.f97712g0 = sensorManager;
        if (sensorManager != null) {
            if (this.f97722n0 == null) {
                this.f97722n0 = new f(this);
            }
            SensorMonitor.registerListener(this.f97712g0, this.f97722n0, SensorMonitor.getDefaultSensor(this.f97712g0, 1), 2);
        }
    }

    public ScannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f97706d = new ReentrantLock();
        this.f97713h = null;
        this.f97715i = null;
        this.f97720m = new Rect();
        this.L = 0;
        this.P = 0;
        this.Q = 0;
        this.R = 0;
        this.S = 0;
        this.T = -1;
        this.U = -1;
        this.V = 17;
        this.W = false;
        this.f97703a0 = false;
        this.f97704b0 = false;
        this.f97705c0 = false;
        this.f97714h0 = 0.0f;
        this.f97716i0 = 0.0f;
        this.f97717j0 = 0.0f;
        this.f97718k0 = true;
        this.f97719l0 = false;
        this.f97721m0 = true;
        this.f97726r0 = false;
        this.f97727s0 = new a();
        this.f97728t0 = false;
        y(context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class f implements SensorEventListener {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<ScannerView> f97735d;

        public f(ScannerView scannerView) {
            this.f97735d = new WeakReference<>(scannerView);
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            ScannerView scannerView = this.f97735d.get();
            if (scannerView != null) {
                scannerView.A(sensorEvent);
            } else if (QLog.isColorLevel()) {
                QLog.d("ScannerView", 2, "onSensorChanged but mRef got null");
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i3) {
        }
    }
}
