package com.tencent.luggage.scanner.qbar;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import com.tencent.luggage.scanner.camera.ScanUtil;
import com.tencent.luggage.wxa.a4.a;
import com.tencent.luggage.wxa.b4.e;
import com.tencent.luggage.wxa.tn.c0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.qbar.QBar;
import com.tencent.qbar.QbarNative;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/* compiled from: P */
/* loaded from: classes2.dex */
public class LuggageScanDecodeQueue {

    /* renamed from: u, reason: collision with root package name */
    public static LuggageScanDecodeQueue f120045u = new LuggageScanDecodeQueue();

    /* renamed from: a, reason: collision with root package name */
    public int[] f120046a;

    /* renamed from: b, reason: collision with root package name */
    public int[] f120047b;

    /* renamed from: e, reason: collision with root package name */
    public ExecutorService f120050e;

    /* renamed from: f, reason: collision with root package name */
    public ExecutorService f120051f;

    /* renamed from: g, reason: collision with root package name */
    public long f120052g;

    /* renamed from: h, reason: collision with root package name */
    public ScanDecodeCallBack f120053h;

    /* renamed from: i, reason: collision with root package name */
    public volatile boolean f120054i;

    /* renamed from: j, reason: collision with root package name */
    public volatile boolean f120055j;

    /* renamed from: k, reason: collision with root package name */
    public int f120056k;

    /* renamed from: c, reason: collision with root package name */
    public Map f120048c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public Object f120049d = new Object();

    /* renamed from: l, reason: collision with root package name */
    public long f120057l = 0;

    /* renamed from: m, reason: collision with root package name */
    public com.tencent.luggage.wxa.b4.a f120058m = new com.tencent.luggage.wxa.b4.a("Luggage.WxScanDecodeQueue");

    /* renamed from: n, reason: collision with root package name */
    public boolean f120059n = false;

    /* renamed from: o, reason: collision with root package name */
    public long f120060o = 1000;

    /* renamed from: p, reason: collision with root package name */
    public Runnable f120061p = null;

    /* renamed from: q, reason: collision with root package name */
    public e f120062q = null;

    /* renamed from: r, reason: collision with root package name */
    public boolean f120063r = false;

    /* renamed from: s, reason: collision with root package name */
    public int f120064s = 2;

    /* renamed from: t, reason: collision with root package name */
    public int f120065t = 0;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface ScanDecodeCallBack {
        public static final String DECODE_DEBUG_STRING = "decode_debug_string";
        public static final String DECODE_SUCCESS_COST_TIME = "decode_success_cost_time";
        public static final String DECODE_SUCCESS_FRAME_DATA = "decode_success_frame_data";

        void notifyEvent(long j3, Bundle bundle);

        void onDecodeSuccess(long j3, List<QBar.QBarResult> list, List<QbarNative.QBarPoint> list2, List<QbarNative.QBarReportMsg> list3, Bundle bundle);

        void postTakeShot(long j3, long j16);
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LuggageScanDecodeQueue.this.b();
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public long f120067a;

        /* renamed from: b, reason: collision with root package name */
        public byte[] f120068b;

        /* renamed from: c, reason: collision with root package name */
        public Point f120069c;

        /* renamed from: d, reason: collision with root package name */
        public Rect f120070d;

        /* renamed from: e, reason: collision with root package name */
        public int f120071e;

        public b(long j3, byte[] bArr, Point point, int i3, Rect rect) {
            this.f120067a = j3;
            this.f120068b = bArr;
            this.f120069c = point;
            this.f120071e = i3;
            this.f120070d = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            byte[] a16;
            int[] iArr = new int[2];
            synchronized (LuggageScanDecodeQueue.this.f120058m) {
                LuggageScanDecodeQueue.this.f120054i = true;
                a16 = LuggageScanDecodeQueue.this.f120058m.a(this.f120068b, this.f120069c, this.f120071e, this.f120070d, iArr);
                LuggageScanDecodeQueue.this.f120054i = false;
                this.f120068b = null;
                this.f120069c = null;
                this.f120070d = null;
            }
            synchronized (LuggageScanDecodeQueue.this.f120049d) {
                if (a16 != null) {
                    if (this.f120067a == LuggageScanDecodeQueue.this.f120052g) {
                        LuggageScanDecodeQueue.this.f120048c.put("param_gray_data", a16);
                        LuggageScanDecodeQueue.this.f120048c.put("param_out_size", new Point(iArr[0], iArr[1]));
                        if (!LuggageScanDecodeQueue.this.f120055j) {
                            w.d("Luggage.WxScanDecodeQueue", "%d submit decode gray", Long.valueOf(LuggageScanDecodeQueue.this.f120052g));
                            if (LuggageScanDecodeQueue.this.f120051f != null) {
                                LuggageScanDecodeQueue.this.f120051f.execute(new c(this.f120067a));
                            } else {
                                w.b("Luggage.WxScanDecodeQueue", "do crop gray task, but decode thread not init yet");
                            }
                        }
                        if (LuggageScanDecodeQueue.this.f120053h != null) {
                            LuggageScanDecodeQueue.this.f120053h.postTakeShot(LuggageScanDecodeQueue.this.f120052g, 10L);
                        }
                    }
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public long f120073a;

        /* renamed from: b, reason: collision with root package name */
        public byte[] f120074b;

        /* renamed from: c, reason: collision with root package name */
        public Point f120075c;

        public c(long j3) {
            this.f120073a = j3;
        }

        /* JADX WARN: Removed duplicated region for block: B:50:0x01a1  */
        /* JADX WARN: Removed duplicated region for block: B:53:0x01b8 A[Catch: all -> 0x026c, TryCatch #1 {, blocks: (B:27:0x00e1, B:29:0x00ed, B:32:0x0104, B:34:0x010f, B:35:0x0113, B:37:0x0119, B:39:0x0145, B:41:0x014c, B:43:0x0169, B:45:0x016f, B:47:0x0173, B:48:0x017e, B:51:0x01a7, B:53:0x01b8, B:55:0x01c5, B:58:0x01cd, B:60:0x0201, B:62:0x0209, B:63:0x0215, B:64:0x0258, B:65:0x026a, B:70:0x0241, B:72:0x0249, B:73:0x0253, B:74:0x01a3, B:76:0x0100, B:77:0x025f), top: B:26:0x00e1 }] */
        /* JADX WARN: Removed duplicated region for block: B:74:0x01a3 A[Catch: all -> 0x026c, TryCatch #1 {, blocks: (B:27:0x00e1, B:29:0x00ed, B:32:0x0104, B:34:0x010f, B:35:0x0113, B:37:0x0119, B:39:0x0145, B:41:0x014c, B:43:0x0169, B:45:0x016f, B:47:0x0173, B:48:0x017e, B:51:0x01a7, B:53:0x01b8, B:55:0x01c5, B:58:0x01cd, B:60:0x0201, B:62:0x0209, B:63:0x0215, B:64:0x0258, B:65:0x026a, B:70:0x0241, B:72:0x0249, B:73:0x0253, B:74:0x01a3, B:76:0x0100, B:77:0x025f), top: B:26:0x00e1 }] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            int size;
            boolean z16;
            int size2;
            synchronized (LuggageScanDecodeQueue.this.f120049d) {
                if (this.f120073a == LuggageScanDecodeQueue.this.f120052g) {
                    LuggageScanDecodeQueue.this.f120055j = true;
                    if (!LuggageScanDecodeQueue.this.f120048c.isEmpty()) {
                        this.f120074b = (byte[]) LuggageScanDecodeQueue.this.f120048c.get("param_gray_data");
                        this.f120075c = new Point((Point) LuggageScanDecodeQueue.this.f120048c.get("param_out_size"));
                        LuggageScanDecodeQueue.this.f120048c.clear();
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    if (this.f120074b != null && this.f120075c != null) {
                        synchronized (LuggageScanDecodeQueue.this.f120058m) {
                            if (LuggageScanDecodeQueue.this.f120058m.b()) {
                                LuggageScanDecodeQueue.r(LuggageScanDecodeQueue.this);
                                if (LuggageScanDecodeQueue.this.f120059n) {
                                    LuggageScanDecodeQueue.d(LuggageScanDecodeQueue.this);
                                    w.d("Luggage.WxScanDecodeQueue", "alvinluo decodeGrayData isZooming and reset, currentFrameNumWhenZooming: %d", Integer.valueOf(LuggageScanDecodeQueue.this.f120065t));
                                }
                                com.tencent.luggage.wxa.b4.a aVar = LuggageScanDecodeQueue.this.f120058m;
                                byte[] bArr = this.f120074b;
                                Point point = this.f120075c;
                                List<QBar.QBarResult> a16 = aVar.a(bArr, point.x, point.y, arrayList2, arrayList);
                                QbarNative.QBarZoomInfo a17 = LuggageScanDecodeQueue.this.f120058m.a();
                                this.f120074b = null;
                                this.f120075c = null;
                                int currentTimeMillis2 = (int) (System.currentTimeMillis() - currentTimeMillis);
                                synchronized (LuggageScanDecodeQueue.this.f120049d) {
                                    if (this.f120073a != LuggageScanDecodeQueue.this.f120052g) {
                                        LuggageScanDecodeQueue.this.f120055j = false;
                                        LuggageScanDecodeQueue.this.a();
                                    } else {
                                        Object[] objArr = new Object[2];
                                        objArr[0] = QBar.getVersion();
                                        if (a16 == null) {
                                            size = 0;
                                        } else {
                                            size = a16.size();
                                        }
                                        objArr[1] = Integer.valueOf(size);
                                        w.d("Luggage.WxScanDecodeQueue", "qbar version %s, get %d decode results", objArr);
                                        if (a16 != null) {
                                            for (QBar.QBarResult qBarResult : a16) {
                                                w.d("Luggage.WxScanDecodeQueue", "result " + qBarResult.typeName + "," + qBarResult.data);
                                            }
                                        }
                                        Bundle bundle = new Bundle();
                                        if (a17 != null) {
                                            w.d("Luggage.WxScanDecodeQueue", "isZoom %b, zoomFactor %f", Boolean.valueOf(a17.isZoom), Float.valueOf(a17.zoomFactor));
                                            if (a16 == null || (a16.isEmpty() && a17.isZoom)) {
                                                bundle.putFloat("param_zoom_ratio", a17.zoomFactor);
                                                z16 = true;
                                                boolean a18 = LuggageScanDecodeQueue.this.a(a16);
                                                Object[] objArr2 = new Object[3];
                                                objArr2[0] = Boolean.valueOf(a18);
                                                objArr2[1] = Boolean.valueOf(LuggageScanDecodeQueue.this.f120059n);
                                                if (a16 != null) {
                                                    size2 = 0;
                                                } else {
                                                    size2 = a16.size();
                                                }
                                                objArr2[2] = Integer.valueOf(size2);
                                                w.d("Luggage.WxScanDecodeQueue", "alvinluo decodeGrayData ignoreResult: %b, isZooming: %b, result size: %d", objArr2);
                                                if (!bundle.isEmpty()) {
                                                    LuggageScanDecodeQueue.this.f120053h.notifyEvent(this.f120073a, bundle);
                                                }
                                                if (a16 == null && !a16.isEmpty() && !a18) {
                                                    Bundle bundle2 = new Bundle();
                                                    w.g("Luggage.WxScanDecodeQueue", "alvinluo decodeSuccess result size: %d, isZooming: %b, timeCost", Integer.valueOf(a16.size()), Boolean.valueOf(LuggageScanDecodeQueue.this.f120059n), Integer.valueOf(currentTimeMillis2));
                                                    if (a16.size() > 1 && LuggageScanDecodeQueue.this.f120059n) {
                                                        bundle2.putParcelable(ScanDecodeCallBack.DECODE_SUCCESS_FRAME_DATA, LuggageScanDecodeQueue.this.f120062q);
                                                    }
                                                    bundle2.putString(ScanDecodeCallBack.DECODE_DEBUG_STRING, "");
                                                    bundle2.putLong(ScanDecodeCallBack.DECODE_SUCCESS_COST_TIME, System.currentTimeMillis() - LuggageScanDecodeQueue.this.f120057l);
                                                    LuggageScanDecodeQueue.this.f120053h.onDecodeSuccess(LuggageScanDecodeQueue.this.f120052g, a16, arrayList2, arrayList, bundle2);
                                                } else {
                                                    if (z16 && LuggageScanDecodeQueue.this.f120063r) {
                                                        LuggageScanDecodeQueue.this.c();
                                                        LuggageScanDecodeQueue.this.e();
                                                    }
                                                    LuggageScanDecodeQueue.this.a();
                                                }
                                                LuggageScanDecodeQueue.this.f120055j = false;
                                            }
                                        }
                                        z16 = false;
                                        boolean a182 = LuggageScanDecodeQueue.this.a(a16);
                                        Object[] objArr22 = new Object[3];
                                        objArr22[0] = Boolean.valueOf(a182);
                                        objArr22[1] = Boolean.valueOf(LuggageScanDecodeQueue.this.f120059n);
                                        if (a16 != null) {
                                        }
                                        objArr22[2] = Integer.valueOf(size2);
                                        w.d("Luggage.WxScanDecodeQueue", "alvinluo decodeGrayData ignoreResult: %b, isZooming: %b, result size: %d", objArr22);
                                        if (!bundle.isEmpty()) {
                                        }
                                        if (a16 == null) {
                                        }
                                        if (z16) {
                                            LuggageScanDecodeQueue.this.c();
                                            LuggageScanDecodeQueue.this.e();
                                        }
                                        LuggageScanDecodeQueue.this.a();
                                        LuggageScanDecodeQueue.this.f120055j = false;
                                    }
                                }
                                return;
                            }
                            this.f120074b = null;
                            this.f120075c = null;
                            LuggageScanDecodeQueue.this.f120055j = false;
                            LuggageScanDecodeQueue.this.a();
                            return;
                        }
                    }
                    LuggageScanDecodeQueue.this.f120055j = false;
                    LuggageScanDecodeQueue.this.a();
                    return;
                }
                LuggageScanDecodeQueue.this.f120055j = false;
                LuggageScanDecodeQueue.this.a();
            }
        }
    }

    public LuggageScanDecodeQueue() {
        int[] iArr = {1, 2, 4, 5};
        this.f120046a = iArr;
        this.f120047b = iArr;
    }

    public static /* synthetic */ int d(LuggageScanDecodeQueue luggageScanDecodeQueue) {
        int i3 = luggageScanDecodeQueue.f120065t;
        luggageScanDecodeQueue.f120065t = i3 + 1;
        return i3;
    }

    public static LuggageScanDecodeQueue getInstance() {
        return f120045u;
    }

    public static /* synthetic */ int r(LuggageScanDecodeQueue luggageScanDecodeQueue) {
        int i3 = luggageScanDecodeQueue.f120056k;
        luggageScanDecodeQueue.f120056k = i3 + 1;
        return i3;
    }

    public void addDecodeTask(byte[] bArr, Point point, int i3, Rect rect) {
        synchronized (this.f120049d) {
            w.a("Luggage.WxScanDecodeQueue", "%d submit crop gray", Long.valueOf(this.f120052g));
            if (this.f120052g != 0) {
                if (this.f120050e != null) {
                    if (!this.f120054i) {
                        this.f120050e.execute(new b(this.f120052g, bArr, point, i3, rect));
                    }
                } else {
                    w.b("Luggage.WxScanDecodeQueue", "add decode task, but gray thread not init yet");
                }
            }
            if (this.f120059n && this.f120063r) {
                this.f120062q = new e(bArr, point.x, point.y, i3);
            }
        }
    }

    public int getScanFrameCount() {
        return this.f120056k;
    }

    public void init(Context context) {
        boolean z16;
        synchronized (this.f120058m) {
            if (!this.f120058m.b()) {
                this.f120058m.a(0, ScanUtil.getAiModeParam(context));
                if (this.f120058m.b()) {
                    this.f120058m.a(this.f120047b);
                }
            }
        }
        if (!com.tencent.luggage.wxa.tn.e.f141565g && !com.tencent.luggage.wxa.tn.e.f141559a) {
            z16 = false;
        } else {
            z16 = true;
        }
        this.f120063r = z16;
        this.f120060o = 1000L;
        this.f120064s = 2;
        a.C5984a c5984a = com.tencent.luggage.wxa.a4.a.f120840a;
        this.f120050e = c5984a.a(1);
        this.f120051f = c5984a.a(1);
        w.d("Luggage.WxScanDecodeQueue", "alvinluo initScanDecodeQueue configValue: %d, needShowSuccessFrameWhenZoom: %b, zoomDuration: %d, ignoreFrameNum: %d", 0, Boolean.valueOf(this.f120063r), Long.valueOf(this.f120060o), Integer.valueOf(this.f120064s));
    }

    public void release() {
        w.d("Luggage.WxScanDecodeQueue", "release QBar");
        this.f120047b = this.f120046a;
        stopSession(this.f120052g);
        synchronized (this.f120058m) {
            this.f120058m.c();
        }
        synchronized (this.f120049d) {
            ExecutorService executorService = this.f120050e;
            if (executorService != null && !executorService.isShutdown()) {
                this.f120050e.shutdownNow();
                this.f120050e = null;
            }
            ExecutorService executorService2 = this.f120051f;
            if (executorService2 != null && !executorService2.isShutdown()) {
                this.f120051f.shutdownNow();
                this.f120051f = null;
            }
        }
        d();
    }

    public void setReaders(int[] iArr) {
        if (iArr != null && iArr.length > 0) {
            synchronized (this.f120058m) {
                this.f120047b = iArr;
                if (this.f120058m.b()) {
                    this.f120058m.a(this.f120047b);
                }
            }
        }
    }

    public void startSession(long j3, ScanDecodeCallBack scanDecodeCallBack) {
        synchronized (this.f120049d) {
            this.f120052g = j3;
            this.f120053h = scanDecodeCallBack;
            this.f120056k = 0;
            this.f120057l = System.currentTimeMillis();
        }
    }

    public void stopSession(long j3) {
        synchronized (this.f120049d) {
            if (this.f120052g == j3) {
                this.f120052g = 0L;
                this.f120056k = 0;
                this.f120053h = null;
                this.f120048c.clear();
                this.f120059n = false;
                this.f120057l = 0L;
            }
        }
        d();
    }

    public final void c() {
        w.d("Luggage.WxScanDecodeQueue", "alvinluo onZoomStart");
        this.f120059n = true;
        this.f120065t = 0;
    }

    public final void d() {
        Runnable runnable = this.f120061p;
        if (runnable != null) {
            c0.b(runnable);
        }
    }

    public final void e() {
        w.d("Luggage.WxScanDecodeQueue", "alvinluo triggerZoomFinishTimer zoomDuration: %d", Long.valueOf(this.f120060o));
        d();
        if (this.f120061p == null) {
            this.f120061p = new a();
        }
        c0.a(this.f120061p, this.f120060o);
    }

    public final void b() {
        synchronized (this.f120049d) {
            w.d("Luggage.WxScanDecodeQueue", "alvinluo onZoomEnd");
            this.f120059n = false;
        }
    }

    public final void a() {
        if (!this.f120048c.isEmpty()) {
            long j3 = this.f120052g;
            if (j3 != 0) {
                w.d("Luggage.WxScanDecodeQueue", "%d decode hit cache", Long.valueOf(j3));
                ExecutorService executorService = this.f120051f;
                if (executorService != null) {
                    executorService.execute(new c(this.f120052g));
                    return;
                } else {
                    w.b("Luggage.WxScanDecodeQueue", "decode next task, but decode thread not init yet");
                    return;
                }
            }
        }
        ScanDecodeCallBack scanDecodeCallBack = this.f120053h;
        if (scanDecodeCallBack != null) {
            scanDecodeCallBack.postTakeShot(this.f120052g, 0L);
        }
    }

    public final boolean a(List list) {
        return this.f120059n && list != null && !list.isEmpty() && list.size() > 1 && this.f120065t <= this.f120064s;
    }
}
