package com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.immersiveAd;

import android.content.Context;
import android.view.View;
import androidx.annotation.CallSuper;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadexposure.QAdExposure;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.adclick.QAdStandardClickReportInfo;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.adclick.b;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedui.qqlive.qaduikit.feed.model.QAdFeedBaseUI;
import com.tencent.tvideo.protocol.pb.AdActionField;
import com.tencent.tvideo.protocol.pb.AdFeedInfo;
import com.tencent.tvideo.protocol.pb.AdImmersivePoster;
import com.tencent.tvideo.protocol.pb.AdOrderItem;
import java.util.HashMap;
import java.util.Map;
import pw2.n;
import pw2.p;
import pw2.t;
import pw2.w;

/* compiled from: P */
/* loaded from: classes19.dex */
public abstract class c<V extends QAdFeedBaseUI> implements com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.event.a, gw2.a {
    protected sv2.a F;
    protected int H;
    protected QAdVrReportParams I;
    private long J;

    /* renamed from: d, reason: collision with root package name */
    protected V f304129d;

    /* renamed from: e, reason: collision with root package name */
    protected Context f304130e;

    /* renamed from: f, reason: collision with root package name */
    protected AdFeedInfo f304131f;

    /* renamed from: h, reason: collision with root package name */
    protected AdImmersivePoster f304132h;

    /* renamed from: i, reason: collision with root package name */
    protected com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.immersiveAd.a f304133i;
    protected Map<AdActionField, mv2.a> C = new HashMap();
    protected QAdStandardClickReportInfo.ClickExtraInfo D = new QAdStandardClickReportInfo.ClickExtraInfo();
    private QAdExposure.b K = new a();
    protected zw2.a L = new b();
    protected cx2.a M = new C8856c();

    /* renamed from: m, reason: collision with root package name */
    protected e f304134m = new e(this);
    protected com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.event.c G = new com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.event.c();
    protected String E = pw2.b.a();

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a implements QAdExposure.b {
        a() {
        }

        @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadexposure.QAdExposure.b
        public void a(Object obj) {
            c.this.c(obj);
        }

        @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadexposure.QAdExposure.b
        public void b(Object obj) {
            c.this.h(obj);
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class b implements zw2.a {
        b() {
        }

        @Override // zw2.a
        public void a(com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedui.qqlive.qaduikit.feed.model.b bVar) {
            if (bVar != null) {
                c cVar = c.this;
                QAdStandardClickReportInfo.ClickExtraInfo clickExtraInfo = cVar.D;
                clickExtraInfo.downX = bVar.f304161a;
                clickExtraInfo.downY = bVar.f304162b;
                clickExtraInfo.upX = bVar.f304163c;
                clickExtraInfo.upY = bVar.f304164d;
                clickExtraInfo.playTime = cVar.J;
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.immersiveAd.c$c, reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    class C8856c implements cx2.a {
        C8856c() {
        }

        @Override // cx2.a
        public void a(View view) {
            w.n(view, 0);
        }

        @Override // cx2.a
        public void onClick(View view) {
            c.this.onClick(view);
        }
    }

    public c(V v3, Context context) {
        this.f304129d = v3;
        this.f304130e = context;
    }

    private void b(int i3, AdActionField adActionField, int i16, int i17) {
        mv2.a aVar;
        V v3;
        QAdStandardClickReportInfo.ClickExtraInfo clickExtraInfo = this.D;
        if (clickExtraInfo != null && (v3 = this.f304129d) != null) {
            clickExtraInfo.width = v3.getMeasuredWidth();
            this.D.height = this.f304129d.getMeasuredHeight();
        }
        n.e("QAdImmersiveViewBaseController", "doClick,reportActionType:" + i3 + ",clickField:" + i16);
        Map<AdActionField, mv2.a> map = this.C;
        if (map != null) {
            aVar = map.get(adActionField);
        } else {
            aVar = null;
        }
        if (aVar == null) {
            return;
        }
        l();
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.adclick.a.a(new b.C8854b().b(aVar.f417667b).c(f()).d(104).g(this.H).h(this.D).k(this.f304134m.o(i16)).l(i3).m(true).n(this.E).q(this.f304134m.j(i17)).j(k(i3)).e(false).p(false).f(com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.immersiveAd.b.b(i3)).a(this.f304130e));
    }

    private boolean k(int i3) {
        if (i3 != 1021 && i3 != 1023) {
            return false;
        }
        return true;
    }

    private void l() {
        v(13, null);
    }

    public void c(Object obj) {
        this.f304134m.c();
    }

    @Override // gw2.a
    public View e() {
        return this.f304129d;
    }

    @Override // gw2.a
    public AdOrderItem f() {
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.immersiveAd.a aVar = this.f304133i;
        if (aVar != null) {
            return aVar.d();
        }
        return null;
    }

    public void h(Object obj) {
        this.f304134m.d();
    }

    protected abstract View i();

    protected abstract void j();

    public void n(AdFeedInfo adFeedInfo, com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.immersiveAd.a aVar) {
        this.f304131f = adFeedInfo;
        this.f304133i = aVar;
        this.C = t.a(adFeedInfo);
        if (adFeedInfo != null) {
            this.f304132h = (AdImmersivePoster) p.c(AdImmersivePoster.class, this.f304131f.data);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onClick(View view) {
        int a16 = yw2.a.a(view.getId());
        if (a16 == 0) {
            return;
        }
        ew2.a e16 = this.f304134m.e(a16);
        b(e16.f397277b, e16.f397276a, a16, view.getId());
        this.f304134m.m(view);
    }

    public void s() {
        View i3 = i();
        if (i3 != null) {
            QAdExposure.g(i3, this.f304131f.order_item, null, true, 5, this.K);
        }
    }

    public void t(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.event.a aVar) {
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.event.c cVar = this.G;
        if (cVar != null) {
            cVar.a(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void u(int i3) {
        v(i3, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void v(int i3, com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.event.b bVar) {
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.event.c cVar = this.G;
        if (cVar != null) {
            cVar.b(i3, bVar);
        }
    }

    public void x(sv2.a aVar) {
        if (aVar == null) {
            this.J = 0L;
        }
        this.J = aVar.f434846o;
    }

    public void y(QAdVrReportParams qAdVrReportParams) {
        this.I = qAdVrReportParams;
        j();
        this.f304134m.l(qAdVrReportParams);
        this.f304129d.e(this.M);
    }

    public void o() {
    }

    public void p() {
    }

    public void q() {
    }

    public void r() {
    }

    @CallSuper
    public void m(View view) {
    }

    public void w(boolean z16) {
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.event.a
    public void d(int i3, com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.event.b bVar) {
    }
}
