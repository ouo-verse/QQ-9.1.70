package com.qzone.reborn.feedx.widget.header;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.reborn.feedx.viewmodel.q;
import com.tencent.mobileqq.R;
import n6.e;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneFriendFeedxHeaderContainerView extends QZoneBaseFeedxHeaderContainerView implements q.b, gf.s {
    private e C;
    private QZoneFeedxHeaderVipElement D;
    private t E;
    private com.qzone.reborn.feedx.viewmodel.q F;
    private QZoneFeedxHeaderNaviBarElement G;
    private j H;
    private bc I;
    private e.c J;

    /* renamed from: m, reason: collision with root package name */
    private bf f56141m;

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class a extends com.qzone.reborn.feedx.viewmodel.g {
        a() {
        }

        @Override // com.qzone.reborn.feedx.viewmodel.g, com.qzone.reborn.feedx.viewmodel.b
        public void i6() {
            QZoneFriendFeedxHeaderContainerView.this.delayShow();
        }

        @Override // com.qzone.reborn.feedx.viewmodel.g, com.qzone.reborn.feedx.viewmodel.b
        public void onHandleMessage(Message message) {
            QZoneFriendFeedxHeaderContainerView.this.onHandleMessage(message);
        }

        @Override // com.qzone.reborn.feedx.viewmodel.g, com.qzone.reborn.feedx.viewmodel.b
        public void v0(QZoneResult qZoneResult) {
            QZoneFriendFeedxHeaderContainerView.this.a0(qZoneResult);
        }
    }

    public QZoneFriendFeedxHeaderContainerView(Context context, LifecycleOwner lifecycleOwner, com.qzone.reborn.feedx.viewmodel.c cVar) {
        super(context, lifecycleOwner, cVar);
        if (lifecycleOwner instanceof Fragment) {
            this.J = (e.c) lifecycleOwner;
        }
    }

    @Override // gf.s
    public View R() {
        e.c cVar = this.J;
        if (cVar == null || cVar.getBannerManager() == null) {
            return null;
        }
        return this.J.getBannerManager().R();
    }

    @Override // com.qzone.reborn.feedx.viewmodel.q.b
    public int S() {
        return this.f56141m.u();
    }

    @Override // com.qzone.reborn.feedx.viewmodel.q.b
    public boolean T() {
        QZoneFeedxHeaderNaviBarElement qZoneFeedxHeaderNaviBarElement = this.G;
        return qZoneFeedxHeaderNaviBarElement != null && qZoneFeedxHeaderNaviBarElement.x();
    }

    @Override // com.qzone.reborn.feedx.widget.header.a
    public Handler Z() {
        return this.F.getMHandler();
    }

    @Override // com.qzone.reborn.feedx.widget.header.QZoneBaseFeedxHeaderContainerView, com.qzone.reborn.feedx.widget.header.a
    public int e() {
        ViewGroup viewGroup;
        QZoneFeedxHeaderNaviBarElement qZoneFeedxHeaderNaviBarElement;
        bf bfVar = this.f56141m;
        if (bfVar == null || (viewGroup = bfVar.f56217f) == null || (qZoneFeedxHeaderNaviBarElement = this.G) == null || qZoneFeedxHeaderNaviBarElement.f56127f == null) {
            return 0;
        }
        return viewGroup.getMeasuredHeight() - this.G.f56127f.getMeasuredHeight();
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.cip;
    }

    @Override // com.qzone.reborn.feedx.widget.header.QZoneBaseFeedxHeaderContainerView
    public void n0() {
        bf bfVar = new bf(this);
        this.f56141m = bfVar;
        r0(bfVar);
        bc bcVar = new bc(this);
        this.I = bcVar;
        r0(bcVar);
        e eVar = new e(this);
        this.C = eVar;
        r0(eVar);
        QZoneFeedxHeaderVipElement qZoneFeedxHeaderVipElement = new QZoneFeedxHeaderVipElement(this);
        this.D = qZoneFeedxHeaderVipElement;
        r0(qZoneFeedxHeaderVipElement);
        t tVar = new t(this);
        this.E = tVar;
        r0(tVar);
        QZoneFeedxHeaderNaviBarElement qZoneFeedxHeaderNaviBarElement = new QZoneFeedxHeaderNaviBarElement(this);
        this.G = qZoneFeedxHeaderNaviBarElement;
        r0(qZoneFeedxHeaderNaviBarElement);
        j jVar = new j(this);
        this.H = jVar;
        r0(jVar);
        r0(new f(this));
        if (com.tencent.mobileqq.service.qzone.e.f286406a.b()) {
            r0(new com.qzone.reborn.feedx.widget.header.dragon.c(this));
        }
    }

    @Override // com.qzone.reborn.feedx.widget.header.QZoneBaseFeedxHeaderContainerView
    public void o0() {
        com.qzone.reborn.feedx.viewmodel.q qVar = (com.qzone.reborn.feedx.viewmodel.q) this.f56121f.W(com.qzone.reborn.feedx.viewmodel.q.class);
        this.F = qVar;
        qVar.Q2(this);
        this.F.k2(new a());
    }

    @Override // com.qzone.reborn.feedx.widget.header.QZoneBaseFeedxHeaderContainerView
    public void p0() {
        e eVar = this.C;
        if (eVar != null) {
            eVar.p();
            this.D.u();
        }
    }
}
