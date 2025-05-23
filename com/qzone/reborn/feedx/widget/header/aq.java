package com.qzone.reborn.feedx.widget.header;

import android.view.View;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.event.Event;
import com.qzone.common.event.EventCenter;
import com.qzone.common.event.IObserver;
import com.qzone.cover.ui.QzoneVipAnimateDecorator;
import com.qzone.cover.ui.QzoneVipDecorator;
import com.tencent.mobileqq.R;
import cooperation.vip.vipcomponent.util.a;

/* compiled from: P */
/* loaded from: classes37.dex */
public class aq extends d implements IObserver.main {

    /* renamed from: f, reason: collision with root package name */
    private boolean f56203f;

    /* renamed from: h, reason: collision with root package name */
    private QzoneVipDecorator f56204h;

    /* renamed from: i, reason: collision with root package name */
    private QzoneVipAnimateDecorator f56205i;

    /* renamed from: m, reason: collision with root package name */
    private com.qzone.reborn.feedx.viewmodel.w f56206m;

    public aq(View view, boolean z16) {
        super(view);
        this.f56203f = z16;
        this.f56204h = (QzoneVipDecorator) view.findViewById(R.id.mzo);
        this.f56205i = (QzoneVipAnimateDecorator) view.findViewById(R.id.mzp);
    }

    private void n() {
        this.f56205i.e(h());
    }

    private void o() {
        this.f56204h.r(h());
        this.f56204h.w(g(), this.f56206m.F2(), false);
        this.f56204h.setVisibility(0);
        this.f56204h.d();
        f6.a.c(this.f56204h);
    }

    private void q() {
        QzoneVipDecorator qzoneVipDecorator = this.f56204h;
        if (qzoneVipDecorator != null) {
            qzoneVipDecorator.d();
            s();
        }
    }

    private void s() {
        if (this.f56204h == null || this.f56205i == null) {
            return;
        }
        String F2 = this.f56206m.F2();
        if (this.f56203f) {
            boolean n3 = this.f56205i.n(2, F2, this.f56204h.u());
            QzoneVipAnimateDecorator qzoneVipAnimateDecorator = this.f56205i;
            if (qzoneVipAnimateDecorator != null && n3) {
                this.f56204h.setVisibility(8);
            } else {
                if (qzoneVipAnimateDecorator != null) {
                    qzoneVipAnimateDecorator.j();
                    this.f56205i.setVisibility(8);
                }
                QzoneVipDecorator qzoneVipDecorator = this.f56204h;
                if (qzoneVipDecorator != null) {
                    qzoneVipDecorator.setVisibility(0);
                }
            }
        }
        this.f56204h.w(g(), F2, true);
        this.f56204h.d();
        f6.a.c(this.f56204h);
    }

    @Override // com.qzone.reborn.feedx.widget.header.d, com.qzone.reborn.feedx.widget.header.b
    public void a0(QZoneResult qZoneResult) {
        q();
    }

    @Override // com.qzone.reborn.feedx.widget.header.d, com.qzone.reborn.feedx.widget.header.b
    public void delayShow() {
        q();
    }

    @Override // com.qzone.reborn.feedx.widget.header.d
    protected String j() {
        return "QZoneUserHomeHeaderVipElement";
    }

    @Override // com.qzone.reborn.feedx.widget.header.d
    public void l() {
        this.f56206m = (com.qzone.reborn.feedx.viewmodel.w) k(com.qzone.reborn.feedx.viewmodel.w.class);
        o();
        n();
        EventCenter.getInstance().addUIObserver(this, a.C10129a.f391398a, 11);
        s();
    }

    @Override // com.qzone.reborn.feedx.widget.header.d, com.qzone.reborn.feedx.widget.header.b
    public void onDestroy() {
        EventCenter.getInstance().removeObserver(this);
        QzoneVipAnimateDecorator qzoneVipAnimateDecorator = this.f56205i;
        if (qzoneVipAnimateDecorator != null) {
            qzoneVipAnimateDecorator.j();
        }
    }

    @Override // com.qzone.reborn.feedx.widget.header.d, com.qzone.reborn.feedx.widget.header.b
    public void onPause() {
        QzoneVipDecorator qzoneVipDecorator = this.f56204h;
        if (qzoneVipDecorator != null) {
            qzoneVipDecorator.B();
        }
        QzoneVipAnimateDecorator qzoneVipAnimateDecorator = this.f56205i;
        if (qzoneVipAnimateDecorator != null) {
            qzoneVipAnimateDecorator.i();
        }
    }

    @Override // com.qzone.reborn.feedx.widget.header.d, com.qzone.reborn.feedx.widget.header.b
    public void onResume() {
        QzoneVipDecorator qzoneVipDecorator = this.f56204h;
        if (qzoneVipDecorator != null) {
            qzoneVipDecorator.C();
        }
        QzoneVipAnimateDecorator qzoneVipAnimateDecorator = this.f56205i;
        if (qzoneVipAnimateDecorator != null) {
            qzoneVipAnimateDecorator.k();
        }
    }

    public void p() {
        q();
    }

    @Override // com.qzone.common.event.IObserver.main
    public void onEventUIThread(Event event) {
    }
}
