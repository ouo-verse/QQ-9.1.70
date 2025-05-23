package com.qzone.reborn.feedx.widget.header;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.event.Event;
import com.qzone.common.event.EventCenter;
import com.qzone.common.event.IObserver;
import com.qzone.cover.ui.QzoneVipAnimateDecorator;
import com.qzone.cover.ui.QzoneVipDecorator;
import com.qzone.proxy.vipcomponent.VipComponentProxy;
import com.qzone.proxy.vipcomponent.model.QzoneVipInfo;
import com.tencent.mobileqq.R;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import cooperation.vip.vipcomponent.util.a;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneFeedxHeaderVipElement extends d implements IObserver.main {

    /* renamed from: f, reason: collision with root package name */
    private com.qzone.reborn.feedx.viewmodel.q f56129f;

    /* renamed from: h, reason: collision with root package name */
    private QzoneVipDecorator f56130h;

    /* renamed from: i, reason: collision with root package name */
    private QzoneVipAnimateDecorator f56131i;

    public QZoneFeedxHeaderVipElement(View view) {
        super(view);
        this.f56130h = (QzoneVipDecorator) view.findViewById(R.id.mzo);
        this.f56131i = (QzoneVipAnimateDecorator) view.findViewById(R.id.mzp);
    }

    private void q() {
        this.f56131i.e(h());
    }

    private void s() {
        this.f56130h.r(h());
        this.f56130h.w(g(), LoginData.getInstance().getUinString(), false);
        this.f56130h.setVisibility(0);
        this.f56130h.d();
        f6.a.c(this.f56130h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        QzoneVipDecorator qzoneVipDecorator = this.f56130h;
        if (qzoneVipDecorator != null) {
            qzoneVipDecorator.setVisibility(0);
        }
        QzoneVipAnimateDecorator qzoneVipAnimateDecorator = this.f56131i;
        if (qzoneVipAnimateDecorator != null) {
            qzoneVipAnimateDecorator.j();
            this.f56131i.setVisibility(8);
            Drawable drawable = this.f56131i.getDrawable();
            if (drawable instanceof AnimationDrawable) {
                ((AnimationDrawable) drawable).stop();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        QzoneVipAnimateDecorator qzoneVipAnimateDecorator;
        if (this.f56130h == null || (qzoneVipAnimateDecorator = this.f56131i) == null) {
            return;
        }
        if (qzoneVipAnimateDecorator.n(1, LoginData.getInstance().getUinString(), this.f56130h.u())) {
            this.f56130h.setVisibility(8);
            return;
        }
        this.f56131i.j();
        this.f56131i.setVisibility(8);
        this.f56130h.setVisibility(0);
    }

    @Override // com.qzone.reborn.feedx.widget.header.d, com.qzone.reborn.feedx.widget.header.b
    public void a0(QZoneResult qZoneResult) {
        this.f56130h.d();
        y();
    }

    @Override // com.qzone.reborn.feedx.widget.header.d, com.qzone.reborn.feedx.widget.header.b
    public void delayShow() {
        QzoneVipDecorator qzoneVipDecorator = this.f56130h;
        if (qzoneVipDecorator != null) {
            qzoneVipDecorator.d();
            y();
        }
    }

    @Override // com.qzone.reborn.feedx.widget.header.d
    protected String j() {
        return "QZoneFeedxHeaderVipElement";
    }

    @Override // com.qzone.reborn.feedx.widget.header.d
    public void l() {
        this.f56129f = (com.qzone.reborn.feedx.viewmodel.q) k(com.qzone.reborn.feedx.viewmodel.q.class);
        s();
        q();
        EventCenter.getInstance().addUIObserver(this, a.C10129a.f391398a, 11);
    }

    @Override // com.qzone.reborn.feedx.widget.header.d, com.qzone.reborn.feedx.widget.header.b
    public void onDestroy() {
        EventCenter.getInstance().removeObserver(this);
        QzoneVipAnimateDecorator qzoneVipAnimateDecorator = this.f56131i;
        if (qzoneVipAnimateDecorator != null) {
            qzoneVipAnimateDecorator.j();
        }
    }

    @Override // com.qzone.common.event.IObserver.main
    public void onEventUIThread(Event event) {
        if (a.C10129a.f391398a.equals(event.source.getName())) {
            if (event.what == 11) {
                QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.reborn.feedx.widget.header.k
                    @Override // java.lang.Runnable
                    public final void run() {
                        QZoneFeedxHeaderVipElement.this.t();
                    }
                });
            }
        } else if ("Personalize".equals(event.source.getName()) && event.what == 17) {
            try {
                v(((Integer) ((Object[]) event.params)[0]).intValue(), (String) ((Object[]) event.params)[1]);
                this.f56129f.P1();
            } catch (Exception e16) {
                QZLog.e("personalizedvip", e16.toString());
            }
        }
    }

    @Override // com.qzone.reborn.feedx.widget.header.d, com.qzone.reborn.feedx.widget.header.b
    public void onPause() {
        QzoneVipDecorator qzoneVipDecorator = this.f56130h;
        if (qzoneVipDecorator != null) {
            qzoneVipDecorator.B();
        }
        QzoneVipAnimateDecorator qzoneVipAnimateDecorator = this.f56131i;
        if (qzoneVipAnimateDecorator != null) {
            qzoneVipAnimateDecorator.i();
        }
    }

    @Override // com.qzone.reborn.feedx.widget.header.d, com.qzone.reborn.feedx.widget.header.b
    public void onResume() {
        QzoneVipDecorator qzoneVipDecorator = this.f56130h;
        if (qzoneVipDecorator != null) {
            qzoneVipDecorator.C();
        }
        QzoneVipAnimateDecorator qzoneVipAnimateDecorator = this.f56131i;
        if (qzoneVipAnimateDecorator != null) {
            qzoneVipAnimateDecorator.k();
        }
    }

    public void u() {
        QzoneVipDecorator qzoneVipDecorator = this.f56130h;
        if (qzoneVipDecorator != null) {
            qzoneVipDecorator.d();
        }
        y();
    }

    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public void t() {
        if (VipComponentProxy.f50997g.getServiceInterface().getVipInfo(LoginData.getInstance().getUinString()).getVipType() != 0) {
            f().post(new Runnable() { // from class: com.qzone.reborn.feedx.widget.header.l
                @Override // java.lang.Runnable
                public final void run() {
                    QZoneFeedxHeaderVipElement.this.x();
                }
            });
        } else {
            f().post(new Runnable() { // from class: com.qzone.reborn.feedx.widget.header.m
                @Override // java.lang.Runnable
                public final void run() {
                    QZoneFeedxHeaderVipElement.this.y();
                }
            });
        }
        QzoneVipDecorator qzoneVipDecorator = this.f56130h;
        if (qzoneVipDecorator != null) {
            qzoneVipDecorator.d();
        }
    }

    void v(int i3, final String str) {
        QZLog.i("onPersonalizeVipSucce", 1, " personli", Integer.valueOf(i3), " url ", str);
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.reborn.feedx.widget.header.QZoneFeedxHeaderVipElement.1
            @Override // java.lang.Runnable
            public void run() {
                VipComponentProxy vipComponentProxy = VipComponentProxy.f50997g;
                vipComponentProxy.getServiceInterface().updateVipInfo(LoginData.getInstance().getUinString(), new QzoneVipInfo(vipComponentProxy.getServiceInterface().getVipInfo(LoginData.getInstance().getUinString()).getBitMap(), str));
                QZoneFeedxHeaderVipElement.this.t();
            }
        });
    }
}
