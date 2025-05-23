package k80;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.beans.QFSSearchBean;
import com.tencent.biz.qqcircle.events.QCircleConfigChangeEvent;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.qqcircle.immersive.search.viewmodel.QFSSearchViewModel;
import com.tencent.biz.qqcircle.immersive.views.search.util.QFSSearchVideoPlayHelper;
import com.tencent.biz.qqcircle.immersive.views.search.util.f;
import com.tencent.biz.qqcircle.immersive.views.search.util.k;
import com.tencent.biz.qqcircle.immersive.views.search.util.p;
import com.tencent.biz.qqcircle.immersive.views.search.widget.QFSSearchBaseWidgetView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.HashMap;
import p70.i;
import qqcircle.QQCircleFeedBase$StFeedListBusiReqData;

/* compiled from: P */
/* loaded from: classes4.dex */
public abstract class d extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> implements View.OnClickListener, e80.g, e80.c, f.b {
    protected FrameLayout I;
    protected ImageView J;
    protected Option K;
    protected com.tencent.biz.qqcircle.immersive.views.search.util.g L;
    protected com.tencent.biz.qqcircle.immersive.views.search.util.f M;
    protected final k N = new k();
    protected i P;
    protected boolean Q;

    private void m1() {
        if (this.P == null) {
            View view = this.C;
            if (view instanceof QFSSearchBaseWidgetView) {
                QCircleBaseFragment qCircleBaseFragment = ((QFSSearchBaseWidgetView) view).getQCircleBaseFragment();
                if (!qCircleBaseFragment.isDetached()) {
                    this.P = (i) qCircleBaseFragment.getViewModel(i.class);
                } else {
                    QLog.w("QFSSearchBaseCardMediaPresenter", 1, "get QFSSearchResultViewModel. fragment is deteched " + qCircleBaseFragment.hashCode());
                }
            }
        }
        if (this.P != null && this.M != null) {
            View view2 = this.C;
            if (view2 instanceof QFSSearchBaseWidgetView) {
                QCircleBaseFragment qCircleBaseFragment2 = ((QFSSearchBaseWidgetView) view2).getQCircleBaseFragment();
                if (!qCircleBaseFragment2.isDetached()) {
                    this.M.j((QFSSearchViewModel) qCircleBaseFragment2.getViewModel(QFSSearchViewModel.class));
                    return;
                }
                QLog.w("QFSSearchBaseCardMediaPresenter", 1, "get QFSSearchViewModel. fragment is deteched " + qCircleBaseFragment2.hashCode());
            }
        }
    }

    private void u1() {
        this.I.setOnClickListener(this);
        this.L.e();
    }

    private void w1() {
        HashMap hashMap = new HashMap();
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_IS_MUTE, Integer.valueOf(!n1() ? 1 : 0));
        VideoReport.setElementParams(this.C, hashMap);
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.search.util.f.b
    public void B(boolean z16) {
        w1();
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.search.util.f.b
    public void G() {
        p1();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void K0() {
        super.K0();
        this.Q = true;
        g1();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void M0() {
        super.M0();
        this.Q = false;
        if (this.L != null) {
            stop();
        }
        this.M.g();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull View view) {
        super.N0(view);
        this.I = (FrameLayout) view.findViewById(R.id.f5182295);
        this.J = (ImageView) view.findViewById(R.id.f516928s);
        this.L = new com.tencent.biz.qqcircle.immersive.views.search.util.g((ImageView) view.findViewById(R.id.lzl), this);
        this.M = new com.tencent.biz.qqcircle.immersive.views.search.util.f(view, this);
        m1();
    }

    @CallSuper
    public void a() {
        this.L.h();
        r1(false);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<? extends SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<? extends SimpleBaseEvent>> eventClass = super.getEventClass();
        eventClass.add(QCircleConfigChangeEvent.class);
        return eventClass;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public QCircleLayerBean h1() {
        if (r() != null && this.f85017h != 0) {
            QCircleLayerBean qCircleLayerBean = new QCircleLayerBean();
            qCircleLayerBean.setFeed((FeedCloudMeta$StFeed) this.f85017h);
            qCircleLayerBean.setDataPosInList(this.f85018i);
            qCircleLayerBean.setUseLoadingPic(true);
            qCircleLayerBean.setSourceType(r().pageType);
            qCircleLayerBean.setLayerBizAssemblerType("biz_search_result_page");
            qCircleLayerBean.setFeedListBusiReqData(new QQCircleFeedBase$StFeedListBusiReqData());
            qCircleLayerBean.setFromReportBean(getReportBean().setFromElement(QCircleDaTongConstant.ElementId.EM_XSJ_INFO_CARD));
            QFSSearchBean qFSSearchBean = new QFSSearchBean();
            qFSSearchBean.setExtraTypeInfo(r());
            qFSSearchBean.setUserSource(p.s(this.J.getContext()));
            qCircleLayerBean.setTransInitBean(qFSSearchBean);
            QLog.i("QFSSearchBaseCardMediaPresenter", 1, "#getDetailInitBean: position=" + this.f85018i + ", id=" + ((FeedCloudMeta$StFeed) this.f85017h).f398449id.get() + ", content=" + ((FeedCloudMeta$StFeed) this.f85017h).content.get() + ", playUrl=" + p.m((FeedCloudMeta$StFeed) this.f85017h));
            return qCircleLayerBean;
        }
        return new QCircleLayerBean();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract String i1();

    @Override // e80.g
    public boolean isPlaying() {
        return this.L.c();
    }

    public i j1() {
        return this.P;
    }

    public abstract void k1();

    @Override // e80.c
    public boolean l() {
        com.tencent.biz.qqcircle.immersive.views.search.util.g gVar = this.L;
        if (gVar != null && gVar.l()) {
            return true;
        }
        return false;
    }

    public void l1() {
        com.tencent.biz.qqcircle.immersive.views.search.util.f fVar = this.M;
        if (fVar != null) {
            fVar.e();
        }
    }

    public boolean n1() {
        com.tencent.biz.qqcircle.immersive.views.search.util.f fVar = this.M;
        if (fVar != null && fVar.H()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void o1() {
        x1();
        com.tencent.biz.qqcircle.launcher.c.u(this.J.getContext(), h1());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view == this.I) {
            o1();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        super.onReceiveEvent(simpleBaseEvent);
        if (simpleBaseEvent instanceof QCircleConfigChangeEvent) {
            g1();
        }
    }

    protected void p1() {
        HashMap hashMap = new HashMap();
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_CLCK_POSITION, 3);
        VideoReport.setElementParams(this.C, hashMap);
        EventCollector.getInstance().onViewClicked(this.C);
    }

    public void pause() {
        this.L.h();
        r1(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @CallSuper
    public void play() {
        this.L.setStatusPlay();
        QFSSearchVideoPlayHelper.N(((FeedCloudMeta$StFeed) this.f85017h).f398449id.get(), this.C.hashCode());
        t1(false);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    @CallSuper
    /* renamed from: q1 */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        super.L0(feedCloudMeta$StFeed, i3);
        if (feedCloudMeta$StFeed == null) {
            return;
        }
        u1();
        this.M.e();
        this.L.i();
        this.L.h();
    }

    protected abstract void r1(boolean z16);

    public void s1(int i3) {
        HashMap hashMap = new HashMap();
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_CLCK_POSITION, 2);
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_IS_PLAY, Integer.valueOf(i3));
        VideoReport.setElementParams(this.C, hashMap);
        EventCollector.getInstance().onViewClicked(this.C);
    }

    @CallSuper
    public void stop() {
        this.L.h();
        r1(false);
    }

    protected abstract void t1(boolean z16);

    public void v1(boolean z16) {
        com.tencent.biz.qqcircle.immersive.views.search.util.g gVar = this.L;
        if (gVar != null) {
            gVar.f(z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void x1() {
        HashMap hashMap = new HashMap();
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_CLCK_POSITION, 1);
        VideoReport.setElementParams(this.C, hashMap);
        EventCollector.getInstance().onViewClicked(this.C);
    }

    protected void g1() {
    }
}
