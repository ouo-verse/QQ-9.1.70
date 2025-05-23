package com.tencent.mobileqq.ar.codeEngine;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.ar.arengine.aj;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.ScannerResult;
import com.tencent.mobileqq.qrscan.api.IMiniCodeApi;
import com.tencent.mobileqq.qrscan.api.IQRScanReportApi;
import com.tencent.mobileqq.qrscan.api.IScanUtilApi;
import com.tencent.mobileqq.qrscan.c;
import com.tencent.mobileqq.qrscan.i;
import com.tencent.mobileqq.qrscan.j;
import com.tencent.mobileqq.qrscan.s;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import z81.b;

/* compiled from: P */
/* loaded from: classes11.dex */
public class MiniRecog implements i, j {

    /* renamed from: b, reason: collision with root package name */
    aj f198334b;

    /* renamed from: c, reason: collision with root package name */
    Handler f198335c;

    /* renamed from: d, reason: collision with root package name */
    Context f198336d;

    /* renamed from: e, reason: collision with root package name */
    int f198337e;

    /* renamed from: f, reason: collision with root package name */
    int f198338f;

    /* renamed from: g, reason: collision with root package name */
    Rect f198339g;

    /* renamed from: j, reason: collision with root package name */
    long f198342j;

    /* renamed from: k, reason: collision with root package name */
    b.a f198343k;

    /* renamed from: a, reason: collision with root package name */
    volatile boolean f198333a = false;

    /* renamed from: h, reason: collision with root package name */
    boolean f198340h = false;

    /* renamed from: i, reason: collision with root package name */
    int f198341i = Integer.MIN_VALUE;

    public MiniRecog(Handler handler, Context context) {
        this.f198335c = handler;
        this.f198336d = context;
    }

    private Bitmap e(byte[] bArr, int i3, int i16, Rect rect) {
        Bitmap bitmap;
        if (i3 != this.f198337e || i16 != this.f198338f || this.f198339g == null) {
            this.f198337e = i3;
            this.f198338f = i16;
            this.f198339g = new Rect(rect.left, rect.top, rect.right, rect.bottom);
            if (QLog.isColorLevel()) {
                QLog.i("QRSession.MiniRecog", 2, String.format("-----> recognizeDetect Mini [preW,preH]=[%d,%d] scanRect=%s rotateScanRect=%s", Integer.valueOf(i3), Integer.valueOf(i16), rect, this.f198339g));
            }
        }
        System.currentTimeMillis();
        try {
            bitmap = f(bArr, this.f198337e, this.f198338f);
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.i("QRSession.MiniRecog", 2, th5.getMessage(), th5);
            }
            bitmap = null;
        }
        if (bitmap == null) {
            return null;
        }
        try {
            Rect rect2 = this.f198339g;
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, rect2.left, rect2.top, rect2.width(), this.f198339g.height());
            if (createBitmap != bitmap) {
                bitmap.recycle();
            }
            return createBitmap;
        } catch (Throwable th6) {
            if (QLog.isColorLevel()) {
                QLog.i("QRSession.MiniRecog", 2, "recognizeDetect exception", th6);
            }
            return null;
        }
    }

    private String j(byte[] bArr, int i3, int i16, int i17, int i18, int i19, int i26, int i27) {
        if (!((IMiniCodeApi) QRoute.api(IMiniCodeApi.class)).isDecodeInited()) {
            return null;
        }
        String decode = ((IMiniCodeApi) QRoute.api(IMiniCodeApi.class)).decode(bArr, i3, i16, i17, i18, i19, i26, i27, 0);
        if (QLog.isColorLevel()) {
            QLog.i("QRSession.MiniRecog", 2, "recognizeNoAI resultStr:" + decode);
        }
        if (!((IMiniCodeApi) QRoute.api(IMiniCodeApi.class)).bValidDecodeResult(decode)) {
            return null;
        }
        return decode;
    }

    @Override // com.tencent.mobileqq.qrscan.i
    public void a(final long j3) {
        this.f198335c.post(new Runnable() { // from class: com.tencent.mobileqq.ar.codeEngine.MiniRecog.1
            @Override // java.lang.Runnable
            public void run() {
                aj ajVar = MiniRecog.this.f198334b;
                if (ajVar != null) {
                    ajVar.a(j3);
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.qrscan.i
    public void b(int i3) {
        long uptimeMillis = SystemClock.uptimeMillis() - this.f198342j;
        if (QLog.isColorLevel() || ((IQRScanReportApi) QRoute.api(IQRScanReportApi.class)).isBaseTestSwitchOn()) {
            QLog.i("QRSession.MiniRecog", 1, String.format("base_test_scan mini_detect_init consume=%d", Long.valueOf(uptimeMillis)));
        }
        this.f198335c.post(new Runnable() { // from class: com.tencent.mobileqq.ar.codeEngine.MiniRecog.2
            @Override // java.lang.Runnable
            public void run() {
                if (QLog.isColorLevel()) {
                    QLog.i("QRSession.MiniRecog", 2, "[------ onDetectReady------]");
                }
                MiniRecog.this.f198333a = true;
            }
        });
        ((IQRScanReportApi) QRoute.api(IQRScanReportApi.class)).onDetectInitCost(this.f198341i, (int) uptimeMillis);
    }

    public Bitmap f(byte[] bArr, int i3, int i16) {
        try {
            if (this.f198343k == null) {
                this.f198343k = new b.a(BaseApplication.getContext());
            }
            return this.f198343k.a(bArr, this.f198337e, this.f198338f);
        } catch (Throwable th5) {
            th5.printStackTrace();
            QLog.i("QRSession.MiniRecog", 2, "getBitmapFromYuv error ", th5);
            return null;
        }
    }

    public int g() {
        boolean z16;
        this.f198342j = SystemClock.uptimeMillis();
        ((IMiniCodeApi) QRoute.api(IMiniCodeApi.class)).addInitCallback(this);
        ((IMiniCodeApi) QRoute.api(IMiniCodeApi.class)).addDetectCallback(this);
        ((IMiniCodeApi) QRoute.api(IMiniCodeApi.class)).init(this.f198336d, hashCode(), "MiniRecog");
        int supportDetectType = ((IMiniCodeApi) QRoute.api(IMiniCodeApi.class)).getSupportDetectType();
        this.f198341i = supportDetectType;
        if (supportDetectType > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.f198340h = z16;
        return 0;
    }

    public boolean h() {
        return this.f198333a;
    }

    public boolean i(byte[] bArr, int i3, int i16, Rect rect, byte[] bArr2, int i17, int i18, ScannerResult scannerResult, ArrayList<com.tencent.mobileqq.qrscan.a> arrayList, AtomicInteger atomicInteger) {
        boolean z16;
        int i19;
        String str;
        int i26;
        char c16;
        int i27;
        int i28 = 0;
        if (!((IMiniCodeApi) QRoute.api(IMiniCodeApi.class)).isDecodeInited()) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (((IMiniCodeApi) QRoute.api(IMiniCodeApi.class)).isDetectInited() && ((IMiniCodeApi) QRoute.api(IMiniCodeApi.class)).isDetectReady()) {
            z16 = true;
        } else {
            z16 = false;
        }
        int i29 = atomicInteger.get();
        String str2 = "QRSession.MiniRecog";
        int i36 = 3;
        int i37 = 2;
        if (this.f198340h && z16 && i29 < 3) {
            scannerResult.f276522f = true;
            Bitmap e16 = e(bArr, i3, i16, rect);
            if (e16 == null) {
                return false;
            }
            ArrayList<com.tencent.mobileqq.qrscan.a> arrayList2 = new ArrayList<>();
            boolean detectSync = ((IMiniCodeApi) QRoute.api(IMiniCodeApi.class)).detectSync(e16, arrayList2);
            if (QLog.isColorLevel()) {
                QLog.i("QRSession.MiniRecog", 2, String.format("recognize exec=%b, detectRects=%s", Boolean.valueOf(detectSync), arrayList2));
            }
            e16.recycle();
            if (detectSync && !arrayList2.isEmpty()) {
                Iterator<com.tencent.mobileqq.qrscan.a> it = arrayList2.iterator();
                while (it.hasNext()) {
                    com.tencent.mobileqq.qrscan.a next = it.next();
                    if (!next.f276532b.isEmpty()) {
                        Rect rect2 = new Rect(next.f276532b);
                        Rect rect3 = this.f198339g;
                        rect2.offset(rect3.left, rect3.top);
                        com.tencent.mobileqq.qrscan.a aVar = new com.tencent.mobileqq.qrscan.a();
                        aVar.f276532b.set(rect2);
                        aVar.f276531a = next.f276531a;
                        aVar.f276533c = next.f276533c;
                        arrayList.add(aVar);
                        int i38 = next.f276531a;
                        if (i38 == i37 || i38 == i36) {
                            Rect rect4 = new Rect();
                            Rect rect5 = new Rect();
                            rect5.set(i28, i28, rect2.height(), rect2.width());
                            rect5.offset((i17 - rect2.top) - rect2.height(), rect2.left);
                            s.a(rect5, rect4, i17, i18, 1.2f);
                            int i39 = i36;
                            String str3 = str2;
                            int i46 = i29;
                            String j3 = j(bArr2, i17, i18, rect4.left, rect4.top, rect4.width(), rect4.height(), next.f276531a);
                            if (!TextUtils.isEmpty(j3)) {
                                scannerResult.b(j3, rect5, next.f276533c, i16, i3, next.f276531a);
                            } else {
                                atomicInteger.getAndIncrement();
                            }
                            i36 = i39;
                            i29 = i46;
                            str2 = str3;
                            i37 = 2;
                            i28 = 0;
                        }
                    }
                }
            }
            i19 = i36;
            str = str2;
            i26 = i29;
            c16 = 1;
        } else {
            i19 = 3;
            str = "QRSession.MiniRecog";
            i26 = i29;
            c16 = 1;
            atomicInteger.set(0);
            scannerResult.f276522f = false;
            if (((IScanUtilApi) QRoute.api(IScanUtilApi.class)).recognizeQQCodeWithoutAI()) {
                String j16 = j(bArr2, i17, i18, 0, 0, 0, 0, 0);
                if (!TextUtils.isEmpty(j16)) {
                    int i47 = c.f276614a;
                    String substring = j16.substring(0, i47);
                    if ("WITHOUTAIQQ&".equals(substring)) {
                        i27 = 2;
                    } else if ("WITHOUTAIWX&".equals(substring)) {
                        i27 = 3;
                    } else {
                        i27 = 0;
                    }
                    scannerResult.a(j16.substring(i47), i27);
                }
            }
        }
        if (QLog.isColorLevel()) {
            Object[] objArr = new Object[5];
            objArr[0] = Boolean.valueOf(scannerResult.j());
            objArr[c16] = Long.valueOf(System.currentTimeMillis() - currentTimeMillis);
            objArr[2] = Integer.valueOf(i26);
            objArr[i19] = scannerResult;
            objArr[4] = arrayList;
            QLog.i(str, 2, String.format("------>recognize Mini suc=%b minicode_timecost=%d lastHitAiButMissDecodeCnt=%d result=%s \nrects=%s", objArr));
        }
        return scannerResult.j();
    }

    public void k(aj ajVar) {
        this.f198334b = ajVar;
    }

    public void l() {
        ((IMiniCodeApi) QRoute.api(IMiniCodeApi.class)).removeInitCallback(this);
        ((IMiniCodeApi) QRoute.api(IMiniCodeApi.class)).removeDetectCallback(this);
        ((IMiniCodeApi) QRoute.api(IMiniCodeApi.class)).unInit(hashCode(), "MiniRecog");
    }

    @Override // com.tencent.mobileqq.qrscan.j
    public void d() {
    }

    @Override // com.tencent.mobileqq.qrscan.i
    public void c(List<com.tencent.mobileqq.qrscan.a> list, long j3) {
    }
}
