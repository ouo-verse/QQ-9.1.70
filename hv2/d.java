package hv2;

import android.content.Context;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.download.QADApkDownloadCallback;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.download.QADApkDownloadReportManager;

/* compiled from: P */
/* loaded from: classes19.dex */
public abstract class d extends j {

    /* renamed from: b, reason: collision with root package name */
    private com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.download.e f406401b;

    /* renamed from: a, reason: collision with root package name */
    private QADApkDownloadCallback f406400a = new QADApkDownloadCallback();

    /* renamed from: c, reason: collision with root package name */
    private QADApkDownloadReportManager f406402c = new QADApkDownloadReportManager(c(), d());

    public d(Context context) {
        this.f406401b = new com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.download.e(context);
        k();
    }

    private void k() {
        j(this.f406401b);
        j(this.f406402c);
    }

    protected abstract boolean a(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info.c cVar);

    public final boolean b(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info.f fVar) {
        return a(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.download.a.a(fVar));
    }

    protected boolean c() {
        return true;
    }

    protected boolean d() {
        return false;
    }

    public final com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info.f e(String str) {
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.download.b f16 = this.f406402c.f(str);
        if (f16 != null) {
            return f16.f303770a;
        }
        return null;
    }

    public final gv2.b f() {
        return this.f406400a;
    }

    protected abstract void g(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info.c cVar);

    public final void h(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info.f fVar) {
        g(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.download.a.a(fVar));
    }

    public abstract void i(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info.b bVar, gv2.a aVar);

    public final void j(gv2.b bVar) {
        this.f406400a.g(bVar);
    }

    protected abstract void l(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info.c cVar);

    public final void m(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info.f fVar) {
        this.f406402c.p(fVar);
        l(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.download.a.a(fVar));
    }
}
