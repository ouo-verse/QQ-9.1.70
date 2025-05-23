package com.tencent.luggage.scanner.scanner.ui;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.luggage.scanner.qbar.LuggageScanDecodeQueue;
import com.tencent.luggage.scanner.scanner.ui.widget.ScannerFlashSwitcher;
import com.tencent.luggage.scanner.scanner.util.ScanCameraLightDetector;
import com.tencent.luggage.wxa.tn.c0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.z3.c;
import com.tencent.luggage.wxa.z3.d;
import com.tencent.luggage.wxa.z3.e;
import com.tencent.luggage.wxa.z3.o;
import com.tencent.luggage.wxa.z3.p;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mobileqq.R;
import com.tencent.qbar.QBar;
import com.tencent.qbar.QbarNative;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ScanUIRectView extends com.tencent.luggage.wxa.d4.a {
    public ScannerFlashSwitcher C;
    public int D;
    public boolean E;
    public long F;
    public l G;
    public int H;
    public Point I;
    public boolean J;
    public boolean K;
    public boolean L;
    public boolean M;
    public com.tencent.luggage.wxa.f4.b N;
    public int O;
    public long P;
    public long Q;
    public boolean R;
    public boolean S;
    public boolean T;
    public boolean U;
    public Runnable V;
    public int W;

    /* renamed from: a0, reason: collision with root package name */
    public int f120124a0;

    /* renamed from: b0, reason: collision with root package name */
    public LuggageScanDecodeQueue.ScanDecodeCallBack f120125b0;

    /* renamed from: c0, reason: collision with root package name */
    public final IListener f120126c0;

    /* renamed from: d0, reason: collision with root package name */
    public long f120127d0;

    /* renamed from: e0, reason: collision with root package name */
    public m f120128e0;

    /* renamed from: k, reason: collision with root package name */
    public com.tencent.luggage.wxa.g4.d f120129k;

    /* renamed from: l, reason: collision with root package name */
    public com.tencent.luggage.wxa.e4.b f120130l;

    /* renamed from: m, reason: collision with root package name */
    public com.tencent.luggage.wxa.g4.a f120131m;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class a implements LuggageScanDecodeQueue.ScanDecodeCallBack {

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.scanner.scanner.ui.ScanUIRectView$a$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC5965a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ long f120134a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ long f120135b;

            public RunnableC5965a(long j3, long j16) {
                this.f120134a = j3;
                this.f120135b = j16;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f120134a == ScanUIRectView.this.F && this.f120134a != 0) {
                    ScanUIRectView.this.b(this.f120135b);
                }
            }
        }

        /* compiled from: P */
        /* loaded from: classes2.dex */
        public class b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ long f120137a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ List f120138b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ List f120139c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ List f120140d;

            /* renamed from: e, reason: collision with root package name */
            public final /* synthetic */ Bundle f120141e;

            public b(long j3, List list, List list2, List list3, Bundle bundle) {
                this.f120137a = j3;
                this.f120138b = list;
                this.f120139c = list2;
                this.f120140d = list3;
                this.f120141e = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                QbarNative.QBarPoint qBarPoint;
                QbarNative.QBarReportMsg qBarReportMsg;
                long j3 = ScanUIRectView.this.F;
                long j16 = this.f120137a;
                if (j3 == j16 && j16 != 0) {
                    ScanUIRectView.this.B();
                    ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
                    List list = this.f120138b;
                    if (list != null && !list.isEmpty()) {
                        w.d("Luggage.ScanUIRectView", "alvinluo onDecodeSuccess result size: %d", Integer.valueOf(this.f120138b.size()));
                        int i3 = 0;
                        for (int i16 = 0; i16 < this.f120138b.size(); i16++) {
                            QBar.QBarResult qBarResult = (QBar.QBarResult) this.f120138b.get(i16);
                            com.tencent.luggage.wxa.b4.d dVar = new com.tencent.luggage.wxa.b4.d(qBarResult.typeID, qBarResult.typeName, qBarResult.data, qBarResult.rawData, qBarResult.charset, qBarResult.priorityLevel);
                            w.d("Luggage.ScanUIRectView", "alvinluo onDecodeSuccess result index: %d, format: %d, content:%s", Integer.valueOf(i16), Integer.valueOf(dVar.typeID), dVar.data);
                            List list2 = this.f120139c;
                            if (list2 != null && list2.size() >= i16 + 1 && (qBarReportMsg = (QbarNative.QBarReportMsg) this.f120139c.get(i16)) != null) {
                                dVar.f121842a = qBarReportMsg.qrcodeVersion;
                            }
                            List list3 = this.f120140d;
                            if (list3 != null && list3.size() >= i16 + 1 && (qBarPoint = (QbarNative.QBarPoint) this.f120140d.get(i16)) != null) {
                                dVar.f121843b = new com.tencent.luggage.wxa.b4.c(qBarPoint);
                                i3++;
                            }
                            arrayList.add(dVar);
                        }
                        Bundle bundle = new Bundle();
                        bundle.putParcelableArrayList("result_qbar_result_list", arrayList);
                        bundle.putInt("result_code_point_count", i3);
                        Bundle bundle2 = this.f120141e;
                        if (bundle2 != null) {
                            bundle.putAll(bundle2);
                        }
                        ScanUIRectView.this.C();
                        if (ScanUIRectView.this.G != null) {
                            ScanUIRectView.this.G.a(ScanUIRectView.this.F, bundle);
                        }
                    }
                }
            }
        }

        /* compiled from: P */
        /* loaded from: classes2.dex */
        public class c implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ long f120143a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Bundle f120144b;

            public c(long j3, Bundle bundle) {
                this.f120143a = j3;
                this.f120144b = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f120143a == ScanUIRectView.this.F && this.f120143a != 0 && this.f120144b.containsKey("param_zoom_ratio")) {
                    float f16 = this.f120144b.getFloat("param_zoom_ratio", 0.0f);
                    w.d("Luggage.ScanUIRectView", "zoom to scale %f", Float.valueOf(f16));
                    if (f16 > 0.0f && ScanUIRectView.this.J && ScanUIRectView.this.f124065b.e()) {
                        ((com.tencent.luggage.wxa.z3.a) ScanUIRectView.this.f124065b).c((int) (((com.tencent.luggage.wxa.z3.a) ScanUIRectView.this.f124065b).g() * f16));
                    }
                }
            }
        }

        public a() {
        }

        @Override // com.tencent.luggage.scanner.qbar.LuggageScanDecodeQueue.ScanDecodeCallBack
        public void notifyEvent(long j3, Bundle bundle) {
            ScanUIRectView.this.post(new c(j3, bundle));
        }

        @Override // com.tencent.luggage.scanner.qbar.LuggageScanDecodeQueue.ScanDecodeCallBack
        public void onDecodeSuccess(long j3, List list, List list2, List list3, Bundle bundle) {
            w.a("Luggage.ScanUIRectView", String.format("scan code after decode %d", Long.valueOf(j3)));
            if (list != null && !list.isEmpty()) {
                ScanUIRectView.this.post(new b(j3, list, list3, list2, bundle));
            }
        }

        @Override // com.tencent.luggage.scanner.qbar.LuggageScanDecodeQueue.ScanDecodeCallBack
        public void postTakeShot(long j3, long j16) {
            ScanUIRectView.this.post(new RunnableC5965a(j3, j16));
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class b implements View.OnTouchListener {

        /* renamed from: a, reason: collision with root package name */
        public float f120146a;

        /* renamed from: b, reason: collision with root package name */
        public float f120147b = 400.0f;

        /* renamed from: c, reason: collision with root package name */
        public boolean f120148c = false;

        public b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int actionMasked = motionEvent.getActionMasked();
            int actionIndex = motionEvent.getActionIndex();
            w.a("Luggage.ScanUIRectView", "pointIndex:%d, action: %d", Integer.valueOf(actionIndex), Integer.valueOf(actionMasked));
            if (actionMasked != 0) {
                if (actionMasked != 1) {
                    if (actionMasked != 2) {
                        if (actionMasked != 5) {
                            if (actionMasked == 6) {
                                w.a("Luggage.ScanUIRectView", "up,pointer:%d,x:%f,y:%f", Integer.valueOf(actionIndex), Float.valueOf(motionEvent.getX(actionIndex)), Float.valueOf(motionEvent.getY(actionIndex)));
                                if (motionEvent.getPointerCount() == 2) {
                                    this.f120146a = (float) (Math.pow(motionEvent.getX(0) - motionEvent.getX(1), 2.0d) + Math.pow(motionEvent.getY(0) - motionEvent.getY(1), 2.0d));
                                    if (this.f120148c) {
                                        this.f120148c = false;
                                    }
                                }
                            }
                        } else {
                            w.a("Luggage.ScanUIRectView", "down,pointer:%d,x:%f,y:%f", Integer.valueOf(actionIndex), Float.valueOf(motionEvent.getX(actionIndex)), Float.valueOf(motionEvent.getY(actionIndex)));
                            if (motionEvent.getPointerCount() == 2) {
                                this.f120146a = (float) (Math.pow(motionEvent.getX(0) - motionEvent.getX(1), 2.0d) + Math.pow(motionEvent.getY(0) - motionEvent.getY(1), 2.0d));
                            }
                            this.f120148c = false;
                        }
                    } else if (motionEvent.getPointerCount() == 2) {
                        w.a("Luggage.ScanUIRectView", "move,pointer:0,x:%f,y:%f", Float.valueOf(motionEvent.getX(0)), Float.valueOf(motionEvent.getY(0)));
                        w.a("Luggage.ScanUIRectView", "move,pointer:1,x:%f,y:%f", Float.valueOf(motionEvent.getX(1)), Float.valueOf(motionEvent.getY(1)));
                        float pow = (float) (Math.pow(motionEvent.getX(0) - motionEvent.getX(1), 2.0d) + Math.pow(motionEvent.getY(0) - motionEvent.getY(1), 2.0d));
                        w.a("Luggage.ScanUIRectView", "distance:%f,lastDistance:%f,min move:%f", Float.valueOf(pow), Float.valueOf(this.f120146a), Float.valueOf(this.f120147b));
                        if (Math.abs(pow - this.f120146a) > this.f120147b) {
                            if (ScanUIRectView.this.J) {
                                ScanUIRectView.this.J = false;
                            }
                            if (pow - this.f120146a > 0.0f) {
                                ((com.tencent.luggage.wxa.z3.a) ScanUIRectView.this.f124065b).b(2);
                                this.f120148c = true;
                            } else {
                                ((com.tencent.luggage.wxa.z3.a) ScanUIRectView.this.f124065b).b(3);
                                this.f120148c = true;
                            }
                            this.f120146a = pow;
                        }
                    }
                } else {
                    w.a("Luggage.ScanUIRectView", "last up,pointer:%d,x:%f,y:%f", Integer.valueOf(actionIndex), Float.valueOf(motionEvent.getX()), Float.valueOf(motionEvent.getY()));
                    if (motionEvent.getPointerCount() == 2) {
                        this.f120146a = (float) (Math.pow(motionEvent.getX(0) - motionEvent.getX(1), 2.0d) + Math.pow(motionEvent.getY(0) - motionEvent.getY(1), 2.0d));
                    }
                }
            } else {
                w.a("Luggage.ScanUIRectView", "first down,pointer:%d,x:%f,y:%f", Integer.valueOf(actionIndex), Float.valueOf(motionEvent.getX()), Float.valueOf(motionEvent.getY()));
                this.f120148c = false;
            }
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ScanUIRectView.this.r() && !ScanUIRectView.this.R) {
                ScanUIRectView.this.S = false;
                ScanUIRectView.this.R = true;
                ScanUIRectView.this.k();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class d implements e.a {
        public d() {
        }

        @Override // com.tencent.luggage.wxa.z3.e.a
        public void a() {
            ScanUIRectView.this.b(0L);
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ScanCameraLightDetector.f120177h.a(((o) ScanUIRectView.this.f124065b).c());
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class f implements e.a {
        public f() {
        }

        @Override // com.tencent.luggage.wxa.z3.e.a
        public void a() {
            ScanUIRectView.this.b(0L);
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class g implements c.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c.a f120154a;

        public g(c.a aVar) {
            this.f120154a = aVar;
        }

        @Override // com.tencent.luggage.wxa.z3.c.a
        public void a() {
            ScanUIRectView.this.t();
            c.a aVar = this.f120154a;
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class h implements d.a {
        public h() {
        }

        @Override // com.tencent.luggage.wxa.z3.d.a
        public void a() {
            ScanUIRectView.this.O = 1;
            ScanUIRectView.this.U = true;
            ScanUIRectView.this.t();
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class i implements Runnable {

        /* compiled from: P */
        /* loaded from: classes2.dex */
        public class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ byte[] f120158a;

            public a(byte[] bArr) {
                this.f120158a = bArr;
            }

            @Override // java.lang.Runnable
            public void run() {
                ScanUIRectView.this.b(this.f120158a);
            }
        }

        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c0.a(new a(ScanUIRectView.this.o()));
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class k implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f120162a;

        public k(boolean z16) {
            this.f120162a = z16;
        }

        @Override // java.lang.Runnable
        public void run() {
            ScanUIRectView.this.a(this.f120162a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface l {
        void a(long j3, Bundle bundle);
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class m extends Handler {
        public m(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            ScanUIRectView.this.f120127d0 = System.currentTimeMillis();
            ScanUIRectView.this.n();
        }
    }

    public ScanUIRectView(Context context) {
        super(context);
        this.D = 1;
        this.E = true;
        this.H = 0;
        this.I = null;
        this.J = true;
        this.K = false;
        this.L = false;
        this.M = true;
        com.tencent.luggage.wxa.f4.b bVar = new com.tencent.luggage.wxa.f4.b();
        this.N = bVar;
        this.O = 0;
        this.P = 0L;
        this.Q = bVar.h();
        this.R = false;
        this.S = true;
        this.T = false;
        this.U = false;
        this.V = new c();
        this.W = 0;
        this.f120124a0 = 0;
        this.f120125b0 = new a();
        this.f120126c0 = new IListener<com.tencent.luggage.wxa.c4.b>(com.tencent.luggage.wxa.z8.b.f146383a) { // from class: com.tencent.luggage.scanner.scanner.ui.ScanUIRectView.11
            @Override // com.tencent.mm.sdk.event.IListener
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public boolean callback(com.tencent.luggage.wxa.c4.b bVar2) {
                if (bVar2.f123289d.f123290a == 1) {
                    if (!((o) ScanUIRectView.this.f124065b).m()) {
                        ((o) ScanUIRectView.this.f124065b).p();
                    }
                } else if (((o) ScanUIRectView.this.f124065b).m()) {
                    ((o) ScanUIRectView.this.f124065b).k();
                }
                return true;
            }
        };
        this.f120128e0 = new m(Looper.getMainLooper());
    }

    private Rect getScanCodeRect() {
        return getDecorRect();
    }

    private String getScanTips() {
        if (!this.E) {
            return "";
        }
        int i3 = this.D;
        if (i3 != 1) {
            if (i3 != 4) {
                if (i3 != 8) {
                    return "";
                }
                return getResources().getString(R.string.f181283dc);
            }
            return getResources().getString(R.string.f181293dd);
        }
        return getResources().getString(R.string.f224026ht);
    }

    public final void A() {
        Runnable runnable = this.V;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    public void B() {
        w.d("Luggage.ScanUIRectView", "alvinluo stopCurrentSession %d", Long.valueOf(this.F));
        LuggageScanDecodeQueue.getInstance().stopSession(this.F);
        this.F = 0L;
    }

    public void C() {
        com.tencent.luggage.wxa.g4.a aVar = this.f120131m;
        if (aVar != null && (aVar instanceof com.tencent.luggage.wxa.e4.a)) {
            ((com.tencent.luggage.wxa.e4.a) aVar).q();
        }
    }

    public final void D() {
        w.d("Luggage.ScanUIRectView", "alvinluo updateScanCodeRect visibleResolution: %s", this.I);
        Point point = this.I;
        if (point != null && point.x > 0 && point.y > 0) {
            com.tencent.luggage.wxa.g4.d dVar = this.f120129k;
            Point point2 = this.I;
            float f16 = point2.y;
            dVar.setDecorRect(new Rect(0, (int) ((1.0f * f16) / 19.0f), point2.x, (int) ((f16 * 17.0f) / 19.0f)));
        }
    }

    public Rect getDecorRect() {
        return this.f120129k.getDecorRect();
    }

    public p getScanCamera() {
        return this.f124065b;
    }

    public com.tencent.luggage.wxa.e4.b getSharedMaskView() {
        return this.f120130l;
    }

    public final void j() {
        try {
            w.d("Luggage.ScanUIRectView", "alvinluo checkAndReopenCamera");
            a(new h());
        } catch (Exception e16) {
            w.a("Luggage.ScanUIRectView", e16, "alvinluo checkAnReopenCamera exception", new Object[0]);
        }
    }

    public final void k() {
        com.tencent.luggage.wxa.f4.b bVar = this.N;
        if (bVar != null) {
            int e16 = bVar.e();
            w.d("Luggage.ScanUIRectView", "alvinluo checkAndRetry retryType: %d, canRetry: %b", Integer.valueOf(e16), Boolean.valueOf(this.N.a(e16)));
            if (this.N.a(e16)) {
                if (e16 == 1) {
                    this.N.a(true);
                    j();
                } else if (e16 == 2) {
                    this.N.a(true);
                    this.U = true;
                    this.O = e16;
                    c(0L);
                }
            }
        }
    }

    public final void l() {
        w.a("Luggage.ScanUIRectView", "alvinluo createScanMaskView mode: %d, bottomHeight: %d", Integer.valueOf(this.D), Integer.valueOf(this.H));
        int i3 = this.D;
        if (i3 != 1 && i3 != 4 && i3 != 8) {
            w.d("Luggage.ScanUIRectView", "unknown scan mode %d", Integer.valueOf(i3));
        } else {
            D();
            com.tencent.luggage.wxa.e4.a aVar = new com.tencent.luggage.wxa.e4.a(getContext());
            this.f120131m = aVar;
            addView(aVar);
        }
        com.tencent.luggage.wxa.g4.a aVar2 = this.f120131m;
        if (aVar2 != null && this.f120130l != null) {
            aVar2.setBottomExtraHeight(this.H);
            this.f120131m.b(this.C);
            p pVar = this.f124065b;
            if (pVar instanceof o) {
                this.f120131m.a((o) pVar);
            }
            this.f120131m.a(this.f120130l.getScanTipsView());
            this.f120131m.c(this.f120130l.getGalleryButton());
            ScannerFlashSwitcher scannerFlashSwitcher = this.C;
            if (scannerFlashSwitcher != null) {
                setFlashStatus(scannerFlashSwitcher.e());
            }
            if (this.M) {
                this.f120130l.setShowTitle(false);
                this.M = false;
            } else {
                this.f120130l.setShowTitle(true);
            }
            this.f120131m.f();
            this.f120130l.e();
        }
    }

    public final void m() {
        com.tencent.luggage.wxa.g4.a aVar = this.f120131m;
        if (aVar != null) {
            aVar.a(new j(aVar));
        }
    }

    public final void n() {
        com.tencent.luggage.wxa.zp.h.f146825d.b(new i(), "takeOneShotByTextureLoopTag");
    }

    public final byte[] o() {
        int i3;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            int width = this.f124064a.getWidth();
            int height = this.f124064a.getHeight();
            com.tencent.luggage.wxa.f4.b bVar = this.N;
            if (bVar != null && bVar.g() != 0.0f) {
                width = (int) (this.f124064a.getWidth() * this.N.g());
                height = (int) (this.f124064a.getHeight() * this.N.g());
            }
            if (width % 2 != 0) {
                width--;
            }
            if (height % 2 != 0) {
                height--;
            }
            Bitmap bitmap = this.f124064a.getBitmap(width, height);
            w.a("Luggage.ScanUIRectView", "alvinluo generateFrameByTextureView getBitmap cost: %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            if (bitmap != null && !bitmap.isRecycled()) {
                this.W = bitmap.getWidth();
                this.f120124a0 = bitmap.getHeight();
                w.a("Luggage.ScanUIRectView", "alvinluo generateFrameByTextureView bitmap width: %d, height: %d", Integer.valueOf(this.W), Integer.valueOf(this.f120124a0));
                long currentTimeMillis2 = System.currentTimeMillis();
                byte[] a16 = com.tencent.luggage.wxa.f4.c.a(this.W, this.f120124a0, bitmap);
                long currentTimeMillis3 = System.currentTimeMillis();
                Object[] objArr = new Object[2];
                if (a16 != null) {
                    i3 = a16.length;
                } else {
                    i3 = -1;
                }
                objArr[0] = Integer.valueOf(i3);
                objArr[1] = Long.valueOf(currentTimeMillis3 - currentTimeMillis2);
                w.a("Luggage.ScanUIRectView", "alvinluo generateFrameByTextureView yuvData: %d, getNV21 cost: %d", objArr);
                return a16;
            }
            return null;
        } catch (Exception e16) {
            w.a("Luggage.ScanUIRectView", e16, "alvinluo generateFrameByTextureView exception", new Object[0]);
            return null;
        }
    }

    @Override // android.hardware.Camera.AutoFocusCallback
    public void onAutoFocus(boolean z16, Camera camera2) {
        w.d("Luggage.ScanUIRectView", "onAutoFocus %s", Boolean.valueOf(z16));
        if (z16) {
            this.S = false;
            b(0L);
        }
        a(com.tencent.luggage.wxa.d4.a.f124063j);
    }

    @Override // com.tencent.luggage.wxa.d4.a, android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera2) {
        boolean z16;
        super.onPreviewFrame(bArr, camera2);
        this.T = true;
        Object[] objArr = new Object[3];
        if (bArr == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        objArr[0] = Boolean.valueOf(z16);
        objArr[1] = Boolean.valueOf(this.K);
        objArr[2] = Boolean.valueOf(this.L);
        w.a("Luggage.ScanUIRectView", "onPreviewFrame null data: %b, isPreviewPaused: %b, canResumePreview: %b", objArr);
        int i3 = this.O;
        if (i3 == 2) {
            com.tencent.luggage.wxa.f4.b bVar = this.N;
            if (bVar != null) {
                bVar.b(i3);
            }
            this.U = false;
        }
        removeCallbacks(this.V);
        com.tencent.luggage.wxa.f4.b bVar2 = this.N;
        if (bVar2 != null) {
            bVar2.b(System.currentTimeMillis() - this.P);
            this.N.k();
        }
        if (this.K && this.L) {
            this.K = false;
            this.L = false;
            c(false);
            b(100L);
            return;
        }
        if (bArr == null) {
            w.f("Luggage.ScanUIRectView", "alvinluo onPreviewFrame data is null");
            b(0L);
        } else {
            b(bArr);
        }
    }

    @Override // com.tencent.luggage.wxa.d4.a, android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i3, int i16) {
        super.onSurfaceTextureAvailable(surfaceTexture, i3, i16);
        Point point = this.I;
        if (point == null || i3 != point.x || i16 != point.y) {
            if (point == null) {
                this.I = new Point(i3, i16);
            }
            if (r()) {
                D();
            }
        }
    }

    public final void p() {
        com.tencent.luggage.wxa.e4.b bVar = new com.tencent.luggage.wxa.e4.b(getContext());
        this.f120130l = bVar;
        this.C = bVar.getFlashSwitcherView();
        addView(this.f120130l, new FrameLayout.LayoutParams(-1, -1));
    }

    public final void q() {
        setOnTouchListener(new b());
    }

    public final boolean r() {
        return com.tencent.luggage.wxa.f4.d.a(this.D);
    }

    public boolean s() {
        com.tencent.luggage.wxa.g4.a aVar;
        if (r() && (aVar = this.f120131m) != null && (aVar instanceof com.tencent.luggage.wxa.e4.a)) {
            return aVar.c();
        }
        return false;
    }

    public void setBottomExtraHeight(int i3) {
        this.H = i3;
    }

    public void setDecodeSuccessFrameData(com.tencent.luggage.wxa.b4.e eVar) {
        com.tencent.luggage.wxa.g4.a aVar = this.f120131m;
        if (aVar != null) {
            aVar.setDecodeSuccessFrameData(eVar);
        }
    }

    public void setDecorRect(Rect rect) {
        this.f120129k.setDecorRect(rect);
    }

    public void setFlashStatus(boolean z16) {
        com.tencent.luggage.wxa.e4.b bVar = this.f120130l;
        if (bVar != null) {
            bVar.setFlashStatus(z16);
        }
    }

    public void setScanCallback(l lVar) {
        this.G = lVar;
    }

    public void setScanCodeReaders(int[] iArr) {
        LuggageScanDecodeQueue.getInstance().setReaders(iArr);
    }

    public void setScanMode(int i3) {
        this.D = i3;
    }

    public void setShowScanTips(boolean z16) {
        this.E = z16;
    }

    public void setSuccessMarkClickListener(com.tencent.luggage.wxa.e4.c cVar) {
        com.tencent.luggage.wxa.g4.a aVar = this.f120131m;
        if (aVar instanceof com.tencent.luggage.wxa.e4.a) {
            ((com.tencent.luggage.wxa.e4.a) aVar).setSuccessMarkClickListener(cVar);
        }
    }

    public final void t() {
        w.d("Luggage.ScanUIRectView", "alvinluo onCameraOpened");
        ((o) this.f124065b).b(false);
        a(new f());
    }

    public void u() {
        if (this.f120130l != null && this.C.e()) {
            this.f120130l.c(false);
        }
    }

    public void v() {
        if (this.f120130l != null && !this.C.e()) {
            this.f120130l.c(true);
        }
    }

    public void w() {
        this.K = true;
        this.L = false;
    }

    public final void x() {
        this.f120130l.setScanTips(getScanTips());
        int i3 = this.D;
        if (i3 != 1 && i3 != 4 && i3 != 8) {
            w.b("Luggage.ScanUIRectView", "alvinluo refreshSharedMaskView unknown scan mode %d", Integer.valueOf(i3));
        } else {
            this.f120130l.setScanTitle(getResources().getString(R.string.f223966hn));
        }
    }

    public void y() {
        this.f120129k.setVisibility(8);
        x();
        m();
        l();
    }

    public final void z() {
        w.a("Luggage.ScanUIRectView", "alvinluo releaseView");
        com.tencent.luggage.wxa.g4.a aVar = this.f120131m;
        if (aVar != null) {
            aVar.release();
        }
        com.tencent.luggage.wxa.e4.b bVar = this.f120130l;
        if (bVar != null) {
            bVar.f();
        }
    }

    @Override // com.tencent.luggage.wxa.d4.a
    public void f() {
        super.f();
        this.f124065b.a(true);
        w.d("Luggage.ScanUIRectView", "alvinluo onPuase");
        A();
        com.tencent.luggage.wxa.g4.a aVar = this.f120131m;
        if (aVar != null) {
            aVar.d();
        }
        B();
    }

    @Override // com.tencent.luggage.wxa.d4.a
    public void g() {
        super.g();
        this.f124065b.a(false);
        if (!this.f124065b.isOpen()) {
            w.d("Luggage.ScanUIRectView", "alvinluo onResume openCamera");
            a((c.a) null);
        } else if (!this.f124065b.e()) {
            w.d("Luggage.ScanUIRectView", "alvinluo onResume startPreview");
            ((o) this.f124065b).b(false);
            a(new d());
            w.d("Luggage.ScanUIRectView", "focus mode %s", this.f124065b.c());
        } else {
            w.d("Luggage.ScanUIRectView", "alvinluo onResume camera is previewing");
            w.d("Luggage.ScanUIRectView", "focus mode %s", this.f124065b.c());
            b(0L);
        }
        w.d("Luggage.ScanUIRectView", "onResume %s", w0.b());
        this.F = System.currentTimeMillis();
        if (r()) {
            LuggageScanDecodeQueue.getInstance().startSession(this.F, this.f120125b0);
        }
        com.tencent.luggage.wxa.g4.a aVar = this.f120131m;
        if (aVar != null) {
            aVar.e();
        }
        c0.a(new e(), 300L);
        this.L = true;
    }

    @Override // com.tencent.luggage.wxa.d4.a
    public void h() {
        super.h();
        a();
        ScanCameraLightDetector.f120177h.b();
    }

    @Override // com.tencent.luggage.wxa.d4.a
    public void i() {
        super.i();
        w();
    }

    @Override // com.tencent.luggage.wxa.d4.a
    public void b() {
        this.f124065b = new o();
    }

    @Override // com.tencent.luggage.wxa.d4.a
    public void c() {
        super.c();
        com.tencent.luggage.wxa.g4.d dVar = new com.tencent.luggage.wxa.g4.d(getContext());
        this.f120129k = dVar;
        addView(dVar, new FrameLayout.LayoutParams(-1, -1));
        p();
        x();
    }

    @Override // com.tencent.luggage.wxa.d4.a
    public void d() {
        super.d();
        if (r()) {
            LuggageScanDecodeQueue.getInstance().init(getContext());
        }
        q();
        this.f120126c0.alive();
        com.tencent.luggage.wxa.f4.b bVar = this.N;
        if (bVar != null) {
            bVar.b();
        }
    }

    @Override // com.tencent.luggage.wxa.d4.a
    public void e() {
        super.e();
        z();
        LuggageScanDecodeQueue.getInstance().release();
        this.f120126c0.dead();
        removeCallbacks(this.V);
        this.V = null;
        com.tencent.luggage.wxa.f4.b bVar = this.N;
        if (bVar != null) {
            bVar.c();
        }
    }

    @Override // com.tencent.luggage.wxa.d4.a
    public void b(long j3) {
        w.a("Luggage.ScanUIRectView", "alvinluo takeOneShot timeout: %d, isRetry: %b, onPreviewFrameCalled: %b, canReportOnPreviewFrame: %b, hasReport: %b", Long.valueOf(this.Q), Boolean.valueOf(this.U), Boolean.valueOf(this.T), Boolean.valueOf(this.S), Boolean.valueOf(this.R));
        if (!this.U) {
            super.b(j3);
            this.P = System.currentTimeMillis();
            if (!this.T && this.S && r()) {
                removeCallbacks(this.V);
                postDelayed(this.V, this.Q);
                return;
            }
            return;
        }
        com.tencent.luggage.wxa.f4.b bVar = this.N;
        if (bVar == null || !bVar.a(this.O)) {
            return;
        }
        int i3 = this.O;
        if (i3 == 1) {
            super.b(j3);
            this.P = System.currentTimeMillis();
        } else if (i3 == 2) {
            c(j3);
        }
    }

    @Override // com.tencent.luggage.wxa.d4.a
    public void a(c.a aVar) {
        super.a(new g(aVar));
    }

    public void a(Object obj, com.tencent.luggage.wxa.g4.e eVar) {
        com.tencent.luggage.wxa.f4.b bVar;
        w.d("Luggage.ScanUIRectView", "alvinluo onScanSuccess");
        A();
        f();
        i();
        com.tencent.luggage.wxa.g4.a aVar = this.f120131m;
        if (aVar != null) {
            aVar.a(obj, eVar);
            this.f120131m.a(this.f124064a);
        }
        com.tencent.luggage.wxa.e4.b bVar2 = this.f120130l;
        if (bVar2 != null) {
            bVar2.d();
        }
        if (!r() || (bVar = this.N) == null) {
            return;
        }
        bVar.l();
    }

    public void c(boolean z16) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            a(z16);
        } else {
            c0.a(new k(z16));
        }
    }

    public final void c(long j3) {
        long currentTimeMillis = System.currentTimeMillis() - this.f120127d0;
        long j16 = com.tencent.luggage.wxa.d4.a.f124062i;
        if (currentTimeMillis > j16) {
            this.f120128e0.removeMessages(0);
            this.f120128e0.sendEmptyMessageDelayed(0, j3);
        } else {
            this.f120128e0.removeMessages(0);
            this.f120128e0.sendEmptyMessageDelayed(0, j3 + (j16 - currentTimeMillis));
        }
    }

    public void b(boolean z16) {
        w.g("Luggage.ScanUIRectView", "alvinluo onShowNoDataView show: %b", Boolean.valueOf(z16));
        com.tencent.luggage.wxa.e4.b bVar = this.f120130l;
        if (bVar != null) {
            bVar.a(!z16);
        }
        com.tencent.luggage.wxa.g4.a aVar = this.f120131m;
        if (aVar != null) {
            aVar.a(!z16);
        }
    }

    public final void a(boolean z16) {
        com.tencent.luggage.wxa.g4.a aVar = this.f120131m;
        if (aVar != null) {
            aVar.b(z16);
        }
        com.tencent.luggage.wxa.e4.b bVar = this.f120130l;
        if (bVar != null) {
            bVar.d(z16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class j implements Animator.AnimatorListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.g4.b f120160a;

        public j(com.tencent.luggage.wxa.g4.b bVar) {
            this.f120160a = bVar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            ScanUIRectView.this.removeView((View) this.f120160a);
            this.f120160a.release();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ScanUIRectView.this.removeView((View) this.f120160a);
            this.f120160a.release();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public final void a(byte[] bArr) {
        int i3;
        if (this.F == 0 || !this.f124065b.e()) {
            return;
        }
        Point d16 = this.f124065b.d();
        if (d16 != null) {
            Rect scanCodeRect = getScanCodeRect();
            boolean z16 = this.U;
            if (!z16 || (i3 = this.O) == 1) {
                Rect a16 = ((o) this.f124065b).a(scanCodeRect);
                com.tencent.luggage.wxa.g4.a aVar = this.f120131m;
                if (aVar != null) {
                    aVar.setPreviewRect(a16);
                    this.f120131m.setScanRect(scanCodeRect);
                    com.tencent.luggage.wxa.g4.a aVar2 = this.f120131m;
                    if (aVar2 instanceof com.tencent.luggage.wxa.e4.a) {
                        ((com.tencent.luggage.wxa.e4.a) aVar2).setNeedRotate(true);
                    }
                }
                LuggageScanDecodeQueue.getInstance().addDecodeTask(bArr, d16, this.f124065b.a(), a16);
            } else if (z16 && i3 == 2) {
                Rect rect = new Rect(0, 0, this.W, this.f120124a0);
                com.tencent.luggage.wxa.g4.a aVar3 = this.f120131m;
                if (aVar3 != null) {
                    aVar3.setPreviewRect(rect);
                    this.f120131m.setScanRect(scanCodeRect);
                    com.tencent.luggage.wxa.g4.a aVar4 = this.f120131m;
                    if (aVar4 instanceof com.tencent.luggage.wxa.e4.a) {
                        ((com.tencent.luggage.wxa.e4.a) aVar4).setNeedRotate(false);
                    }
                }
                LuggageScanDecodeQueue.getInstance().addDecodeTask(bArr, new Point(this.W, this.f120124a0), 0, rect);
            }
        }
        if (((com.tencent.luggage.wxa.z3.a) this.f124065b).h() || LuggageScanDecodeQueue.getInstance().getScanFrameCount() <= 50) {
            return;
        }
        w.d("Luggage.ScanUIRectView", "change to FOCUS_MODE_AUTO");
        this.f124065b.a("auto");
        a(100L);
    }

    public final void b(byte[] bArr) {
        if (this.f124065b.e() && ((o) this.f124065b).n()) {
            ScanCameraLightDetector.f120177h.a(bArr, ((o) this.f124065b).d().x, ((o) this.f124065b).d().y);
        }
        int i3 = this.D;
        if (i3 == 1 || i3 == 4 || i3 == 8) {
            a(bArr);
        } else {
            w.d("Luggage.ScanUIRectView", "unknown scan mode %d", Integer.valueOf(i3));
        }
    }
}
