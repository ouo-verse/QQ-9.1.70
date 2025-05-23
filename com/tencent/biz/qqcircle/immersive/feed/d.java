package com.tencent.biz.qqcircle.immersive.feed;

import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.events.QCirclePanelStateEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSFullScreenCloseEvent;
import com.tencent.biz.qqcircle.immersive.utils.bi;
import com.tencent.biz.qqcircle.immersive.views.QFSVideoView;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.video.rfw.RFWPlayer;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.auto.engine.event.ASEngineTabStatusEvent;
import com.tencent.mobileqq.qcircle.api.utils.QCircleVideoDeviceInfoUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes4.dex */
public abstract class d<T extends FeedCloudMeta$StFeed> extends QFSBaseFeedChildPresenter<T> {
    protected QFSVideoView I;
    protected ImageView J;
    protected Option K;
    private t40.f L;
    private final AtomicBoolean M = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o1(Pair pair) {
        if (this.M.get()) {
            QLog.d("QFSBaseFeedChildVideoPresenter", 1, "[handlerEngineTabStatusEvent] current tab selected, not release player.");
        } else if (com.tencent.biz.qqcircle.immersive.utils.be.c().d()) {
            a();
            q1();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void p1() {
        if (!com.tencent.biz.qqcircle.immersive.utils.bi.l(this.J, this.K, (FeedCloudMeta$StFeed) this.f85017h) && this.K != null) {
            QLog.d("QFSBaseFeedChildVideoPresenter", 1, "[loadBitmapCover] load current frame fail, load origin cover.");
            QCircleFeedPicLoader.g().loadImage(this.K);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull View view) {
        super.N0(view);
        ViewStub viewStub = (ViewStub) view.findViewById(R.id.f41561he);
        if (viewStub != null) {
            this.f85016f = viewStub.inflate();
        }
        View view2 = this.f85016f;
        if (view2 != null) {
            view = view2;
        }
        this.I = (QFSVideoView) view.findViewById(R.id.f74163vi);
        this.J = (ImageView) view.findViewById(R.id.v_z);
    }

    protected abstract void a();

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<? extends SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<? extends SimpleBaseEvent>> eventClass = super.getEventClass();
        eventClass.add(ASEngineTabStatusEvent.class);
        eventClass.add(QFSFullScreenCloseEvent.class);
        eventClass.add(QCirclePanelStateEvent.class);
        return eventClass;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean h1() {
        return com.tencent.biz.qqcircle.immersive.utils.bi.l(this.J, this.K, (FeedCloudMeta$StFeed) this.f85017h);
    }

    protected abstract void i1(RFWFeedSelectInfo rFWFeedSelectInfo);

    public t40.f j1() {
        if (!h20.c.h()) {
            return (t40.f) u0(t40.f.class);
        }
        if (this.L == null) {
            this.L = (t40.f) u0(t40.f.class);
        }
        return this.L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void k1(@NonNull ASEngineTabStatusEvent aSEngineTabStatusEvent) {
        this.M.set(aSEngineTabStatusEvent.isSelected());
        QLog.d("QFSBaseFeedChildVideoPresenter", 1, "[handlerEngineTabStatusEvent] event selected: " + this.M);
        if (this.M.get()) {
            if (com.tencent.biz.qqcircle.immersive.utils.be.c().d()) {
                com.tencent.biz.qqcircle.immersive.utils.be.c().b();
                i1(null);
                return;
            }
            return;
        }
        r1(new bi.a() { // from class: com.tencent.biz.qqcircle.immersive.feed.c
            @Override // com.tencent.biz.qqcircle.immersive.utils.bi.a
            public final void a(Pair pair) {
                d.this.o1(pair);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l1(RFWPlayer rFWPlayer) {
        q50.b.e().c(this.K);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void m1(QFSFullScreenCloseEvent qFSFullScreenCloseEvent) {
        if (TextUtils.equals(com.tencent.biz.qqcircle.utils.bj.g((FeedCloudMeta$StFeed) this.f85017h), qFSFullScreenCloseEvent.getFeedId()) && com.tencent.biz.qqcircle.immersive.utils.bi.h()) {
            p1();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void n1() {
        if (this.K != null && !com.tencent.biz.qqcircle.immersive.utils.bi.g((FeedCloudMeta$StFeed) this.f85017h)) {
            q50.b.e().o(this.K);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        e30.b bVar;
        super.onFeedSelected(rFWFeedSelectInfo);
        QFSVideoView qFSVideoView = this.I;
        if (qFSVideoView != null && (bVar = this.E) != null) {
            qFSVideoView.Q0(bVar.g());
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        super.onReceiveEvent(simpleBaseEvent);
        if (simpleBaseEvent instanceof ASEngineTabStatusEvent) {
            k1((ASEngineTabStatusEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QFSFullScreenCloseEvent) {
            m1((QFSFullScreenCloseEvent) simpleBaseEvent);
        }
    }

    protected void q1() {
        p1();
        ImageView imageView = this.J;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void r1(bi.a aVar) {
        if (uq3.o.u() && QCircleVideoDeviceInfoUtils.isLowDevice()) {
            QLog.d("QFSBaseFeedChildVideoPresenter", 1, "[handlerEngineTabStatusEvent] keep Player.");
        } else {
            com.tencent.biz.qqcircle.immersive.utils.be.c().h(this.I, (FeedCloudMeta$StFeed) this.f85017h, aVar);
        }
    }

    /* renamed from: s1 */
    public void L0(T t16, int i3) {
        super.L0(t16, i3);
        QFSVideoView qFSVideoView = this.I;
        if (qFSVideoView != null) {
            qFSVideoView.setData(t16, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void t1() {
        l40.a aVar;
        if (!l40.i.I() || (aVar = (l40.a) RFWIocAbilityProvider.g().getIocInterface(l40.a.class, this.C, null)) == null) {
            return;
        }
        RFWLog.d("QFSBaseFeedChildVideoPresenter", RFWLog.USR, "[tryFastPlayViewReuse]");
        aVar.T4();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void u1() {
        if (!l40.i.I()) {
            return;
        }
        View view = this.C;
        if (view == null) {
            RFWLog.d("QFSBaseFeedChildVideoPresenter", RFWLog.USR, "[tryHideFastPlayVideo] rootView is null");
            return;
        }
        l40.a aVar = (l40.a) RFWIocAbilityProvider.g().getIocInterface(l40.a.class, view, null);
        if (aVar == null) {
            return;
        }
        aVar.Q6();
    }
}
