package com.tencent.mobileqq.ar.model;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.ar.arengine.ARCamera;
import com.tencent.mobileqq.ar.arengine.aj;
import com.tencent.mobileqq.ar.arengine.ak;
import com.tencent.mobileqq.ar.codeEngine.MiniRecog;
import com.tencent.mobileqq.ar.y;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.ScannerResult;
import com.tencent.mobileqq.qrscan.api.IImgProcessApi;
import com.tencent.mobileqq.qrscan.api.IQRScanReportApi;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes11.dex */
public class b extends com.tencent.mobileqq.ar.model.a implements ARCamera.b, aj {
    private HandlerThread C;
    private Handler D;
    private ak E;
    private aj F;
    private boolean G;
    private boolean H;
    private int J;
    private byte[] K;
    private int L;
    private int M;
    private long N;
    private Rect P;
    private Rect Q;
    private Rect R;
    private Rect S;
    private byte[] T;
    private boolean U;
    private long V;
    private com.tencent.mobileqq.ar.codeEngine.a W;
    private MiniRecog X;

    /* renamed from: a0, reason: collision with root package name */
    private long f198527a0;

    /* renamed from: b0, reason: collision with root package name */
    private int f198528b0;

    /* renamed from: c0, reason: collision with root package name */
    private long f198529c0;

    /* renamed from: d0, reason: collision with root package name */
    private long f198530d0;
    private long I = 500;
    private boolean Y = false;
    private int Z = 0;

    /* renamed from: e0, reason: collision with root package name */
    private boolean f198531e0 = true;

    /* renamed from: f0, reason: collision with root package name */
    private boolean f198532f0 = false;

    /* renamed from: g0, reason: collision with root package name */
    private boolean f198533g0 = false;

    /* renamed from: h0, reason: collision with root package name */
    private boolean f198534h0 = false;

    /* renamed from: i0, reason: collision with root package name */
    private long f198535i0 = 0;

    /* renamed from: j0, reason: collision with root package name */
    AtomicInteger f198536j0 = new AtomicInteger(0);

    /* compiled from: P */
    /* loaded from: classes11.dex */
    private class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i3 = message.what;
            if (i3 == 100) {
                b.this.c0();
                return;
            }
            if (i3 == 101) {
                if (b.this.f198531e0) {
                    b.this.f198531e0 = false;
                    ((IQRScanReportApi) QRoute.api(IQRScanReportApi.class)).markScanStart();
                }
                try {
                    b.this.T();
                } catch (Throwable th5) {
                    if (QLog.isColorLevel()) {
                        QLog.i("QRSession", 2, th5.getMessage(), th5);
                    }
                }
            }
        }
    }

    public b() {
        this.f198522e = 0;
        CameraProxy.v().N(this);
        CameraProxy.v().K(this);
    }

    private static float P(Rect rect, Rect rect2, Point point) {
        int i3;
        int i16;
        float f16;
        float f17;
        int i17;
        int i18;
        float f18;
        int i19 = point.x;
        int i26 = i19 - rect2.left;
        int i27 = rect2.right - i19;
        int i28 = point.y;
        int i29 = i28 - rect2.top;
        int i36 = rect2.bottom - i28;
        int i37 = rect.left;
        if (i37 < i19) {
            i3 = i19 - i37;
        } else {
            i3 = 0;
        }
        int i38 = rect.right;
        if (i38 > i19) {
            i16 = i38 - i19;
        } else {
            i16 = 0;
        }
        float f19 = 2.14748365E9f;
        if (i3 > 0) {
            f16 = i26 / i3;
        } else {
            f16 = 2.14748365E9f;
        }
        if (i16 > 0) {
            f17 = i27 / i16;
        } else {
            f17 = 2.14748365E9f;
        }
        float min = Math.min(f16, f17);
        int i39 = rect.top;
        int i46 = point.y;
        if (i39 < i46) {
            i17 = i46 - i39;
        } else {
            i17 = 0;
        }
        int i47 = rect.bottom;
        if (i47 > i46) {
            i18 = i47 - i46;
        } else {
            i18 = 0;
        }
        if (i17 > 0) {
            f18 = i29 / i17;
        } else {
            f18 = 2.14748365E9f;
        }
        if (i18 > 0) {
            f19 = i36 / i18;
        }
        float min2 = Math.min(min, Math.min(f18, f19));
        float width = rect2.width() / rect.width();
        float height = rect2.height() / rect.height();
        float min3 = Math.min(width, height);
        if (QLog.isColorLevel()) {
            QLog.i("QRSession", 2, String.format("calcZoomFactor_ori [codeRect,scanRect,prevCenter]=[%s|%s|%s]", rect.toShortString(), rect2.toShortString(), point.toString()));
        }
        if (QLog.isColorLevel()) {
            QLog.i("QRSession", 2, String.format("calcZoomFactor_calc [ratioLeft,ratioRight]=[%.2f,%.2f], [ratioTop,ratioBot]=[%.2f,%.2f] [wFactor,hFactor]=[%.2f,%.2f]", Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19), Float.valueOf(width), Float.valueOf(height)));
        }
        if (min2 < 0.0f || min3 <= min2) {
            return min3;
        }
        return min2;
    }

    private boolean Q(int i3, int i16) {
        int i17;
        boolean z16;
        long currentTimeMillis = System.currentTimeMillis();
        boolean z17 = false;
        if (this.U && currentTimeMillis - this.V > 1000) {
            long currentTimeMillis2 = System.currentTimeMillis();
            i17 = U(this.T, i3, i16);
            if (i17 < this.J) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (QLog.isColorLevel()) {
                QLog.d("QRSession", 2, String.format("checkAvgLuminance avgLuminance=%s get avg luminance time cost:%sms", Integer.valueOf(i17), Long.valueOf(System.currentTimeMillis() - currentTimeMillis2)));
            }
            this.V = currentTimeMillis;
            z17 = z16;
        } else {
            i17 = -1;
        }
        ak akVar = this.E;
        if (akVar != null && this.f198521d == 2 && i17 >= 0) {
            akVar.f(i17);
        }
        return z17;
    }

    private boolean R(byte[] bArr, int i3, int i16) {
        if (bArr != null && bArr.length > 0 && bArr.length == ((i3 * i16) * 3) / 2) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [boolean] */
    public void T() {
        StringBuilder sb5;
        ?? r46;
        ScannerResult scannerResult;
        boolean z16;
        int i3;
        long currentTimeMillis = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
            sb5 = new StringBuilder("doRecognizeInternal ");
        } else {
            sb5 = null;
        }
        if (R(this.K, this.L, this.M)) {
            if (this.Q == null || this.S == null) {
                d0();
            }
            if (this.Q != null && this.S != null) {
                this.f198534h0 = true;
                int i16 = this.L;
                int i17 = this.M;
                byte[] bArr = this.T;
                if (bArr == null || bArr.length != ((i16 * i17) * 3) / 2) {
                    this.T = new byte[((i16 * i17) * 3) / 2];
                }
                int[] iArr = new int[2];
                if (((IImgProcessApi) QRoute.api(IImgProcessApi.class)).gray_rotate_crop_sub(this.T, iArr, this.K, this.L, this.M, 0, 0, i16, i17, 90, 0) == 0) {
                    int i18 = iArr[0];
                    int i19 = iArr[1];
                    ScannerResult scannerResult2 = new ScannerResult();
                    ArrayList<com.tencent.mobileqq.qrscan.a> arrayList = new ArrayList<>();
                    long currentTimeMillis2 = System.currentTimeMillis();
                    boolean b16 = this.W.b(this.T, i18, i19, scannerResult2);
                    long currentTimeMillis3 = System.currentTimeMillis();
                    boolean i26 = this.X.i(this.K, this.L, this.M, this.S, this.T, i18, i19, scannerResult2, arrayList, this.f198536j0);
                    long currentTimeMillis4 = System.currentTimeMillis();
                    if (arrayList.size() > 1 && scannerResult2.m() && !scannerResult2.k()) {
                        scannerResult = scannerResult2;
                        scannerResult.f276523h = true;
                    } else {
                        scannerResult = scannerResult2;
                    }
                    this.f198528b0++;
                    long j3 = currentTimeMillis3 - currentTimeMillis2;
                    this.f198529c0 += j3;
                    long j16 = currentTimeMillis4 - currentTimeMillis3;
                    this.f198530d0 += j16;
                    if (!b16 && !i26 && Q(i18, i19)) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (!z16 && !b16 && !i26) {
                        this.Z++;
                    }
                    e0(arrayList);
                    if (scannerResult.m()) {
                        h0(scannerResult, this.K, this.L, this.M);
                        i3 = 0;
                        this.Z = 0;
                    } else {
                        i3 = 0;
                        g0(false, 0.0f);
                        if (!arrayList.isEmpty()) {
                            f0(arrayList);
                        }
                    }
                    ((IQRScanReportApi) QRoute.api(IQRScanReportApi.class)).markScanConsume((int) j3, i3);
                    ((IQRScanReportApi) QRoute.api(IQRScanReportApi.class)).markScanConsume((int) j16, 1);
                    if (sb5 != null) {
                        Object[] objArr = new Object[5];
                        objArr[i3] = Boolean.valueOf(b16);
                        objArr[1] = Boolean.valueOf(i26);
                        objArr[2] = Boolean.valueOf(z16);
                        objArr[3] = Integer.valueOf(this.Z);
                        objArr[4] = scannerResult;
                        sb5.append(String.format("...1 decode qrSuc=%b miniSuc=%b isDark=%b failCnt=%d \nscannerResult=%s", objArr));
                        r46 = 0;
                    } else {
                        r46 = i3;
                    }
                    this.f198534h0 = r46;
                    if (!QLog.isColorLevel() && sb5 != null) {
                        QLog.i("QRSession", 2, sb5.toString());
                        Object[] objArr2 = new Object[1];
                        objArr2[r46] = Long.valueOf(System.currentTimeMillis() - currentTimeMillis);
                        QLog.d("QRSession", 2, String.format("doRecognizeInternal ...end  minicode_timecost=%d", objArr2));
                        return;
                    }
                }
            } else {
                return;
            }
        }
        r46 = 0;
        this.f198534h0 = r46;
        if (!QLog.isColorLevel()) {
        }
    }

    private int U(byte[] bArr, int i3, int i16) {
        if (bArr.length > i3 * i16) {
            int i17 = 0;
            int i18 = 0;
            for (int i19 = 0; i19 < i16; i19 += 3) {
                for (int i26 = 0; i26 < i3; i26 += 3) {
                    i18 += bArr[(i19 * i3) + i26] & 255;
                    i17++;
                }
            }
            if (i17 > 0) {
                return i18 / i17;
            }
        }
        return -1;
    }

    private void b0(Rect rect, Rect rect2, boolean z16) {
        Rect rect3 = new Rect();
        if (rect != null && rect.width() > 0 && rect.height() > 0) {
            rect3.set(0, 0, rect.height(), rect.width());
            rect3.offset((this.M - rect.top) - rect.height(), rect.left);
        }
        if (rect3.width() > 0 && rect3.height() > 0) {
            rect2.set(rect3);
            float f16 = z81.c.f452158a / this.M;
            float f17 = z81.c.f452159b / this.L;
            if (QLog.isColorLevel()) {
                QLog.i("QRSession", 2, String.format("getScreenRect [%.2f,%.2f, %d,%d,%d,%d]", Float.valueOf(f16), Float.valueOf(f17), Integer.valueOf(z81.c.f452158a), Integer.valueOf(z81.c.f452159b), Integer.valueOf(this.M), Integer.valueOf(this.L)));
            }
            rect2.left = (int) (rect2.left * f16);
            rect2.top = (int) (rect2.top * f17);
            rect2.right = (int) (rect2.right * f16);
            rect2.bottom = (int) (rect2.bottom * f17);
        }
        if (QLog.isColorLevel()) {
            QLog.i("QRSession", 2, String.format("[------ detect_point 2 rect=%s previewRect=%s screenRect=%s isQr=%b ------]", rect, rect3, rect2, Boolean.valueOf(z16)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c0() {
        this.W.a();
        this.G = true;
        this.X.g();
        this.H = true;
    }

    private void d0() {
        int i3;
        int i16 = this.L;
        if (i16 > 0 && (i3 = this.M) > 0) {
            float f16 = i3 / z81.c.f452158a;
            float f17 = i16 / z81.c.f452159b;
            Rect rect = this.P;
            Rect rect2 = new Rect((int) (rect.left * f16), (int) (rect.top * f17), (int) (rect.right * f16), (int) (rect.bottom * f17));
            Rect rect3 = new Rect(0, 0, (int) (rect2.width() * 1.5f), (int) (rect2.height() * 1.5f));
            rect3.offset(rect2.centerX() - rect3.centerX(), rect2.centerY() - rect3.centerY());
            rect3.intersect(0, 0, this.M, this.L);
            Rect rect4 = new Rect(0, 0, rect2.height(), rect2.width());
            rect4.offset(rect2.top, rect2.left);
            Rect rect5 = new Rect(0, 0, (int) (rect4.width() * 1.3f), (int) (rect4.height() * 1.2f));
            rect5.offset(rect4.centerX() - rect5.centerX(), rect4.centerY() - rect5.centerY());
            rect5.intersect(0, 0, this.L, this.M);
            rect2.set(0, 0, z81.c.f452158a, z81.c.f452159b);
            int i17 = this.M;
            int i18 = (this.L - i17) / 2;
            rect3.set(0, 0, i17, i17);
            rect3.offset(i18, 0);
            rect5.set(0, 0, i17, i17);
            rect5.offset(0, i18);
            if (QLog.isColorLevel()) {
                QLog.d("QRSession", 2, String.format("initScanRect [mScanRect,qRRecogRect,qRRecogRectExt,rotateQRRecogRectExt]=[%s, %s, %s, %s] [w,h]=[%d,%d]", this.P.toShortString(), rect2.toShortString(), rect3.toShortString(), rect5.toShortString(), Integer.valueOf(z81.c.f452158a), Integer.valueOf(z81.c.f452159b)));
            }
            this.Q = rect2;
            this.S = rect3;
            this.R = rect5;
        }
    }

    private void e0(List<com.tencent.mobileqq.qrscan.a> list) {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < list.size(); i3++) {
            com.tencent.mobileqq.qrscan.a aVar = new com.tencent.mobileqq.qrscan.a();
            aVar.f276531a = list.get(i3).f276531a;
            aVar.f276533c = list.get(i3).f276533c;
            Rect rect = list.get(i3).f276532b;
            if (rect.width() > 0 && rect.height() > 0) {
                b0(rect, aVar.f276532b, true);
            }
            arrayList.add(aVar);
        }
        ak akVar = this.E;
        if (akVar != null) {
            akVar.t(arrayList);
        }
    }

    private void f0(List<com.tencent.mobileqq.qrscan.a> list) {
        float f16;
        boolean z16;
        float f17;
        boolean z17;
        if (list.size() <= 0) {
            return;
        }
        try {
            if (!list.get(0).f276532b.isEmpty() && (this.f198535i0 == 0 || SystemClock.uptimeMillis() - this.f198535i0 > 500)) {
                f16 = list.get(0).f276532b.width() / this.S.width();
                f17 = list.get(0).f276532b.height() / this.S.height();
                if (f16 < 0.7f && f17 < 0.7f) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (QLog.isColorLevel()) {
                    QLog.i("QRSession", 2, String.format("[wRatio,hRatio,need]=[%.2f %.2f %b]", Float.valueOf(f16), Float.valueOf(f17), Boolean.valueOf(z17)));
                }
                if (z17) {
                    float P = P(new Rect(list.get(0).f276532b), this.S, new Point(this.L / 2, this.M / 2));
                    if (P >= 1.2f) {
                        if (P > 15.0f) {
                            P = 15.0f;
                        }
                        boolean s16 = CameraProxy.v().s(P, false);
                        this.f198533g0 |= s16;
                        if (s16) {
                            this.f198535i0 = SystemClock.uptimeMillis();
                            CameraProxy.v().u();
                        }
                        z16 = true;
                    }
                }
                z16 = false;
            } else {
                f16 = 0.0f;
                z16 = false;
                f17 = 0.0f;
            }
            if (QLog.isColorLevel()) {
                QLog.i("QRSession", 2, String.format("onGetDetectRect zoom=%b [%.2f,%.2f]", Boolean.valueOf(z16), Float.valueOf(f16), Float.valueOf(f17)));
            }
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.i("QRSession", 2, th5.getMessage(), th5);
            }
        }
    }

    private void g0(boolean z16, float f16) {
        int i3;
        MiniRecog miniRecog = this.X;
        if (miniRecog != null && miniRecog.h()) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QRSession", 2, String.format("onQRRecognizeFail hasQR=%s qrAreaRatio=%s isMiniRecgReady =%d", Boolean.valueOf(z16), Float.valueOf(f16), Integer.valueOf(i3)));
        }
        if (this.E != null && this.f198521d == 2) {
            if (z16 && f16 > 0.003f && i3 == 0) {
                float sqrt = ((float) (Math.sqrt(f16) * 100.0d)) * 0.75f;
                if (sqrt >= 1.2f) {
                    if (sqrt > 15.0f) {
                        sqrt = 15.0f;
                    }
                    CameraProxy.v().s(sqrt, false);
                }
                if (QLog.isColorLevel()) {
                    QLog.i("QRSession", 2, String.format("onRecognizeFail onGetDetectRect ratio=%.2f", Float.valueOf(sqrt)));
                }
            }
            this.E.s(z16, f16);
        }
    }

    private void h0(ScannerResult scannerResult, byte[] bArr, int i3, int i16) {
        int i17;
        int i18;
        if (this.E != null && this.f198521d == 2 && !this.f198532f0 && R(bArr, i3, i16)) {
            byte[] bArr2 = new byte[bArr.length];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            this.E.o(scannerResult, bArr2, i3, i16);
        }
        if (scannerResult.l()) {
            if (this.f198533g0) {
                i18 = 6;
            } else {
                i18 = 1;
            }
            ((IQRScanReportApi) QRoute.api(IQRScanReportApi.class)).markScanEnd(i18);
        }
        if (scannerResult.j()) {
            if (this.f198533g0) {
                i17 = 5;
            } else {
                i17 = 3;
            }
            ((IQRScanReportApi) QRoute.api(IQRScanReportApi.class)).markScanEnd(i17);
        }
    }

    private void p0() {
        try {
            if (this.G) {
                this.W.c();
                this.G = false;
            }
            if (this.H) {
                this.X.l();
                this.H = false;
            }
            Handler handler = this.D;
            if (handler != null) {
                handler.removeMessages(100);
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("QRSession", 2, "unInitQbar fail!", e16);
            }
        }
    }

    @Override // com.tencent.mobileqq.ar.model.a
    public void H(Context context, AppInterface appInterface) {
        super.H(context, appInterface);
        HandlerThread newFreeHandlerThread = ThreadManagerV2.newFreeHandlerThread("QRRecognizerController", 0);
        this.C = newFreeHandlerThread;
        newFreeHandlerThread.start();
        a aVar = new a(this.C.getLooper());
        this.D = aVar;
        this.W = new com.tencent.mobileqq.ar.codeEngine.a(aVar);
        MiniRecog miniRecog = new MiniRecog(this.D, context);
        this.X = miniRecog;
        miniRecog.k(this);
        this.I = 250L;
        if (y.a().f198841a) {
            this.I = 120L;
        }
        this.J = y.a().f198848h;
        j0();
        k0();
        i0();
        this.D.sendEmptyMessage(100);
        QLog.i("QRSession", 1, String.format("init mQRRecognizeInterval=%s", Long.valueOf(this.I)));
    }

    @Override // com.tencent.mobileqq.ar.model.a
    public void I() {
        super.I();
        if (this.f198533g0) {
            CameraProxy.v().J();
        }
        if (((IQRScanReportApi) QRoute.api(IQRScanReportApi.class)).isBaseTestSwitchOn()) {
            ((IQRScanReportApi) QRoute.api(IQRScanReportApi.class)).stopFrame();
        }
    }

    @Override // com.tencent.mobileqq.ar.model.a
    public void J() {
        super.J();
        j0();
        k0();
        i0();
        if (this.f198533g0) {
            this.f198533g0 = false;
        }
    }

    @Override // com.tencent.mobileqq.ar.model.a
    public void K() {
        super.K();
        p0();
        this.C.quit();
        this.C = null;
        this.D.removeCallbacksAndMessages(null);
        this.D = null;
        CameraProxy.v().I(this);
        CameraProxy.v().G(this);
        ((IQRScanReportApi) QRoute.api(IQRScanReportApi.class)).markScanEnd(0);
    }

    public void S(byte[] bArr, int i3, int i16, boolean z16) {
        Handler handler;
        if ((this.G || this.H) && (handler = this.D) != null && !this.f198532f0) {
            if ((z16 || !handler.hasMessages(101)) && !this.f198534h0) {
                long currentTimeMillis = System.currentTimeMillis();
                if (!z16 && currentTimeMillis - this.N < this.I) {
                    return;
                }
                if (this.f198527a0 == 0) {
                    this.f198527a0 = System.currentTimeMillis();
                }
                if (R(bArr, i3, i16)) {
                    byte[] bArr2 = this.K;
                    if (bArr2 == null || bArr2.length != bArr.length) {
                        this.K = new byte[bArr.length];
                    }
                    System.arraycopy(bArr, 0, this.K, 0, bArr.length);
                    this.L = i3;
                    this.M = i16;
                    this.N = currentTimeMillis;
                } else {
                    this.L = 0;
                    this.M = 0;
                    this.N = 0L;
                }
                this.D.removeMessages(101);
                this.D.sendEmptyMessage(101);
            }
        }
    }

    public boolean V() {
        return this.f198532f0;
    }

    public int W() {
        return this.f198528b0;
    }

    public boolean X() {
        return this.f198533g0;
    }

    public long Y() {
        return this.f198530d0;
    }

    @Override // com.tencent.mobileqq.ar.model.CameraProxy.c
    public boolean Yd(byte[] bArr) {
        if (this.f198521d == 2) {
            S(bArr, CameraProxy.v().z(), CameraProxy.v().y(), this.Y);
            if (((IQRScanReportApi) QRoute.api(IQRScanReportApi.class)).isBaseTestSwitchOn()) {
                ((IQRScanReportApi) QRoute.api(IQRScanReportApi.class)).doFrame();
            }
        }
        this.Y = false;
        return this.f198532f0;
    }

    public long Z() {
        return this.f198529c0;
    }

    @Override // com.tencent.mobileqq.ar.arengine.aj
    public void a(long j3) {
        aj ajVar = this.F;
        if (ajVar != null) {
            ajVar.a(j3);
        }
    }

    public long a0() {
        return this.f198527a0;
    }

    public void i0() {
        this.f198529c0 = 0L;
        this.f198530d0 = 0L;
    }

    public void j0() {
        this.f198528b0 = 0;
    }

    public void k0() {
        this.f198527a0 = 0L;
    }

    public void l0(boolean z16) {
        if (z16 != this.f198532f0) {
            this.f198532f0 = z16;
            if (z16) {
                this.D.removeMessages(101);
            }
        }
    }

    public void m0(ak akVar, aj ajVar) {
        this.E = akVar;
        this.F = ajVar;
    }

    public void n0(Rect rect) {
        if (rect != null && !rect.equals(this.P)) {
            this.P = rect;
            d0();
        }
    }

    public void o0(boolean z16, long j3) {
        this.U = z16;
        if (z16) {
            this.V = System.currentTimeMillis() + j3;
        }
    }

    @Override // com.tencent.mobileqq.ar.arengine.ARCamera.b
    public void r(boolean z16) {
        if (this.f198521d == 2) {
            this.Y = true;
        }
    }
}
