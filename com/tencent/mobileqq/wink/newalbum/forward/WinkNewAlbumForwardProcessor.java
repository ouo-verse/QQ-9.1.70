package com.tencent.mobileqq.wink.newalbum.forward;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.utils.QCircleDeviceUsageUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.wink.newalbum.collector.WinkNewAlbumCollectorDebugInstance;
import com.tencent.mobileqq.wink.newalbum.database.WinkNewAlbumDatabaseImp;
import com.tencent.mobileqq.wink.newalbum.processor.WinkNewAlbumContext;
import com.tencent.mobileqq.wink.newalbum.resmanager.WinkNewAlbumResFetchResult;
import com.tencent.mobileqq.wink.newalbum.resmanager.WinkNewAlbumResManager;
import com.tencent.mobileqq.winkpublish.report.WinkPublishQualityReportData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes21.dex */
public class WinkNewAlbumForwardProcessor extends com.tencent.mobileqq.wink.newalbum.processor.b {
    private final AtomicBoolean C;
    private final AtomicInteger D;
    private final LinkedBlockingQueue<WinkNewAlbumContext> E;
    private com.tencent.mobileqq.wink.newalbum.resmanager.a F;
    private long G;
    private String H;
    private com.tencent.mobileqq.wink.newalbum.forward.b I;
    private com.tencent.mobileqq.wink.newalbum.scale.b J;
    private boolean K;

    /* renamed from: m, reason: collision with root package name */
    private final int f324221m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes21.dex */
    public class a implements com.tencent.mobileqq.wink.newalbum.resmanager.a {
        a() {
        }

        @Override // com.tencent.mobileqq.wink.newalbum.resmanager.a
        public void a(@NonNull WinkNewAlbumResFetchResult winkNewAlbumResFetchResult) {
            WinkNewAlbumForwardProcessor.this.L(winkNewAlbumResFetchResult);
        }
    }

    /* loaded from: classes21.dex */
    class b implements com.tencent.mobileqq.wink.newalbum.forward.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WinkNewAlbumForwardResult f324225a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ WinkNewAlbumContext f324226b;

        b(WinkNewAlbumForwardResult winkNewAlbumForwardResult, WinkNewAlbumContext winkNewAlbumContext) {
            this.f324225a = winkNewAlbumForwardResult;
            this.f324226b = winkNewAlbumContext;
        }

        @Override // com.tencent.mobileqq.wink.newalbum.forward.a
        public void a(float[] fArr, boolean z16) {
            if (WinkNewAlbumForwardProcessor.this.I(fArr)) {
                this.f324225a.f(fArr);
            }
            boolean N = WinkNewAlbumForwardProcessor.this.N(fArr, z16);
            if (N) {
                this.f324226b.t(WinkNewAlbumForwardProcessor.this.G);
            }
            this.f324226b.r(N);
            this.f324226b.z(null);
            WinkNewAlbumForwardProcessor.this.i(this.f324226b);
        }
    }

    public WinkNewAlbumForwardProcessor(com.tencent.mobileqq.wink.newalbum.processor.a aVar, String str) {
        super(aVar, str);
        w83.b bVar = w83.b.f445025a;
        this.f324221m = bVar.u();
        this.G = 0L;
        this.H = "";
        this.K = bVar.G();
        this.E = new LinkedBlockingQueue<>();
        this.C = new AtomicBoolean(false);
        this.D = new AtomicInteger(0);
        com.tencent.mobileqq.wink.newalbum.scale.b bVar2 = new com.tencent.mobileqq.wink.newalbum.scale.b();
        this.J = bVar2;
        if (this.K) {
            bVar2.g();
        }
        O();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        QLog.d(b(), 1, "clear clip model");
        this.C.set(true);
        H().a();
        if (this.K) {
            this.J.c();
        } else {
            this.E.clear();
        }
        WinkNewAlbumResManager.f324315d.f();
    }

    private WinkPublishQualityReportData E(long j3, String str) {
        String str2;
        if (str == null) {
            str = "";
        }
        WinkPublishQualityReportData.Builder traceId = new WinkPublishQualityReportData.Builder().eventId("WE_E_CLIP_MODEL_DECRYPT_RESULT").traceId(getTraceId());
        if (str.isEmpty()) {
            str2 = "0";
        } else {
            str2 = "1";
        }
        return traceId.retCode(str2).ext1(j3 + "").attachInfo("Peak").desc(str).getReportData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WinkPublishQualityReportData F(String str) {
        String str2;
        if (str == null) {
            str = "";
        }
        WinkPublishQualityReportData.Builder traceId = new WinkPublishQualityReportData.Builder().eventId("WE_E_CLIP_FORWARD_RESULT").traceId(getTraceId());
        if (!str.isEmpty()) {
            str2 = "1";
        } else {
            str2 = "0";
        }
        return traceId.retCode(str2).ext1(this.G + "").ext2("1").ext3("1").attachInfo("Peak").desc(str).getReportData();
    }

    private WinkPublishQualityReportData G(long j3, String str) {
        String str2;
        if (str == null) {
            str = "";
        }
        WinkPublishQualityReportData.Builder desc = new WinkPublishQualityReportData.Builder().eventId("WE_E_CLIP_MODEL_LOAD_RESULT").traceId(getTraceId()).ext1(j3 + "").desc(str);
        if (str.isEmpty()) {
            str2 = "0";
        } else {
            str2 = "1";
        }
        return desc.retCode(str2).attachInfo("Peak").getReportData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.tencent.mobileqq.wink.newalbum.forward.b H() {
        if (this.I == null) {
            this.I = new com.tencent.mobileqq.wink.newalbum.forward.b();
        }
        return this.I;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean I(float[] fArr) {
        if (fArr != null && fArr.length == 1024) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        long c16 = H().c();
        long j3 = H().j();
        String d16 = H().d();
        String h16 = H().h();
        h(E(c16, d16));
        h(G(j3 - c16, h16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        h(new WinkPublishQualityReportData.Builder().eventId("WE_E_CLIP_MODEL_LOAD_START").traceId(getTraceId()).attachInfo("Peak").getReportData());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(final WinkNewAlbumResFetchResult winkNewAlbumResFetchResult) {
        try {
            RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: com.tencent.mobileqq.wink.newalbum.forward.WinkNewAlbumForwardProcessor.2
                @Override // java.lang.Runnable
                public void run() {
                    boolean c16 = f.b().c(winkNewAlbumResFetchResult);
                    QLog.i(WinkNewAlbumForwardProcessor.this.b(), 1, "onResReady, download complete!");
                    if (!c16) {
                        QLog.e(WinkNewAlbumForwardProcessor.this.b(), 1, "onResReady, load so fail!");
                    } else {
                        WinkNewAlbumForwardProcessor.this.M(winkNewAlbumResFetchResult);
                    }
                }
            });
        } catch (Exception e16) {
            QLog.e(b(), 1, e16, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean N(float[] fArr, boolean z16) {
        if (I(fArr) && StringUtil.isEmpty(this.H) && !z16) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O() {
        this.F = new a();
        QLog.i(b(), 1, "prepareClipModel, downloadCallback: " + this.F);
        WinkNewAlbumResManager winkNewAlbumResManager = WinkNewAlbumResManager.f324315d;
        winkNewAlbumResManager.g();
        winkNewAlbumResManager.c(this.F);
    }

    public void C() {
        this.C.set(true);
    }

    public void M(final WinkNewAlbumResFetchResult winkNewAlbumResFetchResult) {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.wink.newalbum.forward.WinkNewAlbumForwardProcessor.3
            @Override // java.lang.Runnable
            public void run() {
                WinkNewAlbumContext winkNewAlbumContext;
                try {
                    WinkNewAlbumForwardProcessor.this.K();
                    boolean g16 = WinkNewAlbumForwardProcessor.this.H().g(winkNewAlbumResFetchResult);
                    WinkNewAlbumForwardProcessor.this.J();
                    if (!g16) {
                        QLog.d(WinkNewAlbumForwardProcessor.this.b(), 1, "load result fail! need to reload");
                        if (WinkNewAlbumForwardProcessor.this.D.get() < WinkNewAlbumForwardProcessor.this.f324221m) {
                            WinkNewAlbumForwardProcessor.this.O();
                            WinkNewAlbumForwardProcessor.this.D.set(WinkNewAlbumForwardProcessor.this.D.get() + 1);
                            return;
                        } else {
                            QLog.d(WinkNewAlbumForwardProcessor.this.b(), 1, "reload model fail too much times!");
                            return;
                        }
                    }
                    QLog.d(WinkNewAlbumForwardProcessor.this.b(), 1, "load model success! prepare to forward!");
                    while (true) {
                        if (WinkNewAlbumForwardProcessor.this.C.get()) {
                            break;
                        }
                        if (WinkNewAlbumForwardProcessor.this.K) {
                            winkNewAlbumContext = WinkNewAlbumForwardProcessor.this.J.d();
                        } else {
                            winkNewAlbumContext = (WinkNewAlbumContext) WinkNewAlbumForwardProcessor.this.E.poll();
                        }
                        if (winkNewAlbumContext != null) {
                            float[] fArr = new float[1024];
                            if (winkNewAlbumContext.getIsLast()) {
                                winkNewAlbumContext.getForwardResult().getForwardCallback().a(fArr, false);
                                QLog.d(WinkNewAlbumForwardProcessor.this.b(), 1, "current context is last!");
                                break;
                            }
                            String id5 = winkNewAlbumContext.getMetaData().getId();
                            if (StringUtil.isEmpty(id5)) {
                                QLog.d(WinkNewAlbumForwardProcessor.this.b(), 1, "photoID is empty!");
                            } else if (!WinkNewAlbumDatabaseImp.u(id5)) {
                                WinkNewAlbumForwardProcessor.this.H = "";
                                WinkNewAlbumForwardProcessor.this.G = 0L;
                                Bitmap thumb = winkNewAlbumContext.getThumb();
                                try {
                                    try {
                                        long currentTimeMillis = System.currentTimeMillis();
                                        if (!WinkNewAlbumForwardProcessor.this.K || thumb == null || thumb.isRecycled()) {
                                            String l3 = winkNewAlbumContext.l();
                                            if (!com.tencent.biz.qqstory.utils.d.j(l3)) {
                                                QLog.d(WinkNewAlbumForwardProcessor.this.b(), 1, "bitmap doesn't exist! path: " + l3);
                                            } else {
                                                thumb = com.tencent.mobileqq.wink.utils.f.c(l3);
                                                if (QLog.isColorLevel()) {
                                                    QLog.i(WinkNewAlbumForwardProcessor.this.b(), 2, "getScaledPhotoCost:" + (System.currentTimeMillis() - currentTimeMillis));
                                                }
                                                if (thumb == null) {
                                                    QLog.d(WinkNewAlbumForwardProcessor.this.b(), 1, "bitmap is empty!");
                                                }
                                            }
                                        }
                                        long currentTimeMillis2 = System.currentTimeMillis();
                                        fArr = WinkNewAlbumForwardProcessor.this.H().i(thumb);
                                        WinkNewAlbumForwardProcessor.this.G = System.currentTimeMillis() - currentTimeMillis2;
                                        if (QLog.isColorLevel()) {
                                            QLog.d(WinkNewAlbumForwardProcessor.this.b(), 1, "model forward cost: " + WinkNewAlbumForwardProcessor.this.G);
                                        }
                                        if (WinkNewAlbumForwardProcessor.this.I(fArr)) {
                                            WinkNewAlbumDatabaseImp.m(fArr, winkNewAlbumContext.getMetaData().getId());
                                        } else {
                                            StringBuilder sb5 = new StringBuilder();
                                            WinkNewAlbumForwardProcessor winkNewAlbumForwardProcessor = WinkNewAlbumForwardProcessor.this;
                                            sb5.append(winkNewAlbumForwardProcessor.H);
                                            sb5.append(WinkNewAlbumForwardProcessor.this.H().e());
                                            winkNewAlbumForwardProcessor.H = sb5.toString();
                                            QLog.d(WinkNewAlbumForwardProcessor.this.b(), 1, "imageFeature is invalid! cannot save cache! forward error: " + WinkNewAlbumForwardProcessor.this.H);
                                        }
                                    } catch (Exception e16) {
                                        StringBuilder sb6 = new StringBuilder();
                                        WinkNewAlbumForwardProcessor winkNewAlbumForwardProcessor2 = WinkNewAlbumForwardProcessor.this;
                                        sb6.append(winkNewAlbumForwardProcessor2.H);
                                        sb6.append("|clip forward fail!");
                                        sb6.append(e16);
                                        winkNewAlbumForwardProcessor2.H = sb6.toString();
                                        QLog.d(WinkNewAlbumForwardProcessor.this.b(), 1, WinkNewAlbumForwardProcessor.this.H);
                                    }
                                    if (!WinkNewAlbumForwardProcessor.this.N(fArr, false)) {
                                        WinkNewAlbumForwardProcessor winkNewAlbumForwardProcessor3 = WinkNewAlbumForwardProcessor.this;
                                        WinkNewAlbumForwardProcessor.this.h(winkNewAlbumForwardProcessor3.F(winkNewAlbumForwardProcessor3.H));
                                    }
                                    winkNewAlbumContext.getForwardResult().getForwardCallback().a(fArr, false);
                                } finally {
                                    com.tencent.mobileqq.wink.utils.f.n(thumb);
                                }
                            } else {
                                winkNewAlbumContext.getForwardResult().getForwardCallback().a(WinkNewAlbumDatabaseImp.M(id5), true);
                            }
                        }
                    }
                    QLog.i(WinkNewAlbumForwardProcessor.this.b(), 1, "timeCost:" + (System.currentTimeMillis() - WinkNewAlbumForwardProcessor.this.getStartTime()));
                    WinkNewAlbumCollectorDebugInstance.f324014a.A(System.currentTimeMillis() - WinkNewAlbumForwardProcessor.this.getStartTime());
                    WinkNewAlbumForwardProcessor.this.D();
                } catch (Exception e17) {
                    QLog.d(WinkNewAlbumForwardProcessor.this.b(), 1, e17, new Object[0]);
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.wink.newalbum.processor.b, com.tencent.mobileqq.wink.newalbum.processor.a
    public void a(@NonNull WinkNewAlbumContext winkNewAlbumContext) {
        if (winkNewAlbumContext == null) {
            QLog.d(b(), 1, "context is null");
            return;
        }
        WinkNewAlbumForwardResult winkNewAlbumForwardResult = new WinkNewAlbumForwardResult();
        winkNewAlbumForwardResult.e(new b(winkNewAlbumForwardResult, winkNewAlbumContext));
        winkNewAlbumContext.q(winkNewAlbumForwardResult);
        if (this.K) {
            this.J.b(winkNewAlbumContext);
        } else {
            this.E.offer(winkNewAlbumContext);
        }
    }

    @Override // com.tencent.mobileqq.wink.newalbum.processor.b
    @NonNull
    public String b() {
        return super.b() + "WinkNewAlbumForwardProcessor";
    }

    @Override // com.tencent.mobileqq.wink.newalbum.processor.b
    public void g() {
        QCircleDeviceUsageUtils.e().i();
    }

    @Override // com.tencent.mobileqq.wink.newalbum.processor.b
    public void i(@NonNull WinkNewAlbumContext winkNewAlbumContext) {
        super.i(winkNewAlbumContext);
    }

    @Override // com.tencent.mobileqq.wink.newalbum.processor.b
    public void onStop() {
        C();
        QCircleDeviceUsageUtils.e().g();
        WinkNewAlbumResManager.f324315d.f();
    }
}
