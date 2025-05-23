package com.tencent.mobileqq.tvideo.parts;

import android.app.Activity;
import android.util.SparseArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.immersive.layer.base.QFSLayerBaseMiddleListPart;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.tvideo.channel.event.QFSTVideoChannelClickEvent;
import com.tencent.mobileqq.tvideo.channel.event.QFSTVideoLandScapeChannelClickEvent;
import com.tencent.mobileqq.tvideo.event.QFSTVideoAuthPayReloadEvent;
import com.tencent.mobileqq.tvideo.event.QFSTVideoEpisodeClickEvent;
import com.tencent.mobileqq.tvideo.event.QFSTVideoFeedsItemSelectedEvent;
import com.tencent.mobileqq.tvideo.event.QFSTVideoScreenChangeReloadEvent;
import com.tencent.mobileqq.tvideo.event.QFSTVideoScrollToNextEvent;
import com.tencent.mobileqq.tvideo.like.QFSTVideoEnterReloadEvent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.data.idata.IDataDisplaySurface;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import tvideo.FeedData;
import tvideo.Video;

/* compiled from: P */
/* loaded from: classes19.dex */
public class q extends QFSLayerBaseMiddleListPart {

    /* renamed from: d, reason: collision with root package name */
    private QCircleLayerBean f304577d;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.mobileqq.tvideo.viewmodel.g f304578e;

    /* renamed from: f, reason: collision with root package name */
    private int f304579f;

    /* renamed from: h, reason: collision with root package name */
    private int f304580h;

    /* renamed from: i, reason: collision with root package name */
    private final AtomicBoolean f304581i;

    /* renamed from: m, reason: collision with root package name */
    private static final SparseArray f304576m = new SparseArray();
    private static final SparseArray C = new SparseArray();

    public q(QCircleLayerBean qCircleLayerBean) {
        this(qCircleLayerBean, ox2.b.e().d());
    }

    private void L9() {
        if (this.f304578e == null) {
            O9();
        }
        com.tencent.mobileqq.tvideo.viewmodel.g gVar = this.f304578e;
        if (gVar == null) {
            QLog.e("QFSLayerTVideoListPart", 1, "mSubscribeViewModel is null");
        } else {
            gVar.j().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.tvideo.parts.p
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    q.this.Q9((UIStateData) obj);
                }
            });
        }
    }

    @NonNull
    private e30.b M9() {
        SparseArray sparseArray = C;
        if (sparseArray.size() == 0) {
            return new e30.b(this.f304577d.getFeed());
        }
        int nextInt = new Random().nextInt(sparseArray.size());
        QLog.d("QFSLayerTVideoListPart", 4, "refreshBehindList randomIndex = " + nextInt);
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = (FeedCloudMeta$StFeed) sparseArray.valueAt(nextInt);
        if (feedCloudMeta$StFeed == null) {
            feedCloudMeta$StFeed = this.f304577d.getFeed();
        }
        return new e30.b(feedCloudMeta$StFeed);
    }

    private void N9(QFSTVideoEpisodeClickEvent qFSTVideoEpisodeClickEvent) {
        if (qFSTVideoEpisodeClickEvent != null && qFSTVideoEpisodeClickEvent.getVideoPlot() != null && qFSTVideoEpisodeClickEvent.getVideoFeed() != null) {
            FeedData build = new FeedData.a().d(new Video.a().c(qFSTVideoEpisodeClickEvent.getVideoPlot().video_base_info).b(qFSTVideoEpisodeClickEvent.getVideoFeed().cover_base_info).build()).build();
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = new FeedCloudMeta$StFeed();
            feedCloudMeta$StFeed.f398449id.set("tvideo_feed_id_replace_" + feedCloudMeta$StFeed.f398449id.get());
            feedCloudMeta$StFeed.busiData.set(ByteStringMicro.copyFrom(build.encode()));
            e30.b bVar = new e30.b(feedCloudMeta$StFeed);
            bVar.o("tvideo_episode_blockdara_transform", qFSTVideoEpisodeClickEvent.getVideoPlotDetails());
            this.f304578e.O1().set(qFSTVideoEpisodeClickEvent.getPos(), bVar);
            this.mLayerPageAdapter.submitList(this.f304578e.O1());
        }
    }

    private IDataDisplaySurface<e30.b> O9() {
        com.tencent.mobileqq.tvideo.viewmodel.g gVar = this.f304578e;
        if (gVar != null) {
            return gVar;
        }
        com.tencent.mobileqq.tvideo.viewmodel.g gVar2 = (com.tencent.mobileqq.tvideo.viewmodel.g) getViewModel(com.tencent.mobileqq.tvideo.viewmodel.g.class);
        this.f304578e = gVar2;
        if (gVar2 == null) {
            return null;
        }
        if (R9()) {
            I9();
        }
        return this.f304578e;
    }

    private boolean P9() {
        com.tencent.mobileqq.tvideo.viewmodel.g gVar = this.f304578e;
        if (gVar != null && gVar.O1() != null && !this.f304578e.O1().isEmpty()) {
            return jy2.g.F(this.f304578e.O1().get(this.f304580h).g());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q9(UIStateData uIStateData) {
        Z9(uIStateData);
        Z9(uIStateData);
    }

    private void S9() {
        List<e30.b> O1;
        if (P9()) {
            QLog.d("QFSLayerTVideoListPart", 4, "refreshBehindList replace video");
            return;
        }
        com.tencent.mobileqq.tvideo.viewmodel.g gVar = this.f304578e;
        if (gVar != null && (O1 = gVar.O1()) != null && !O1.isEmpty()) {
            QLog.d("QFSLayerTVideoListPart", 4, "refreshBehindList position = " + this.f304580h);
            QLog.d("QFSLayerTVideoListPart", 4, "refreshBehindList before size = " + O1.size());
            int size = O1.size();
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < size; i3++) {
                int i16 = this.f304580h;
                if (i3 > i16) {
                    QLog.d("QFSLayerTVideoListPart", 4, "refreshBehindList remove");
                    arrayList.add(O1.get(i3));
                } else if (i3 < i16) {
                    SparseArray sparseArray = f304576m;
                    if (sparseArray.get(i3) != null) {
                        QLog.d("QFSLayerTVideoListPart", 4, "refreshBehindList fullScreenVideo remove pos = " + i3);
                        e30.b M9 = M9();
                        if (jy2.g.S(M9.g())) {
                            sparseArray.remove(i3);
                            O1.remove(i3);
                            O1.add(i3, M9);
                        }
                    }
                }
            }
            O1.removeAll(arrayList);
            QLog.d("QFSLayerTVideoListPart", 4, "refreshBehindList after size = " + O1.size());
            this.mLayerPageAdapter.submitList(O1);
        }
    }

    private void T9(int i3) {
        if (i3 == 0) {
            try {
                S9();
            } catch (Exception e16) {
                QLog.d("QFSLayerTVideoListPart", 4, "refreshBehindList Exception = " + e16);
                return;
            }
        }
        V9(true, false);
    }

    private void U9(boolean z16) {
        V9(z16, true);
    }

    private void V9(boolean z16, boolean z17) {
        com.tencent.mobileqq.tvideo.viewmodel.g gVar = this.f304578e;
        if (gVar != null) {
            if (z17) {
                gVar.D2(0);
            }
            this.f304578e.v2(this.f304577d, z16, this.f304579f);
        }
    }

    private void W9(QFSTVideoAuthPayReloadEvent qFSTVideoAuthPayReloadEvent) {
        int pos = qFSTVideoAuthPayReloadEvent.getPos();
        QLog.d("QFSLayerTVideoListPart", 4, "QFSTVideoAuthPayReloadEvent  Auth pos = " + pos + " currentpos = " + this.f304580h);
        if (this.f304580h == pos || qFSTVideoAuthPayReloadEvent.isIgnorePos()) {
            this.mLayerPageAdapter.notifyItemRangeChanged(this.f304580h, 2);
        }
    }

    private void X9(QFSTVideoFeedsItemSelectedEvent qFSTVideoFeedsItemSelectedEvent) {
        int position = qFSTVideoFeedsItemSelectedEvent.getPosition();
        Video tVideoFeed = qFSTVideoFeedsItemSelectedEvent.getTVideoFeed();
        FeedCloudMeta$StFeed stFeed = qFSTVideoFeedsItemSelectedEvent.getStFeed();
        if (jy2.g.A(tVideoFeed)) {
            f304576m.put(position, tVideoFeed);
        } else {
            C.put(position, stFeed);
        }
    }

    private void Y9(QFSTVideoScrollToNextEvent qFSTVideoScrollToNextEvent) {
        com.tencent.mobileqq.tvideo.viewmodel.g gVar;
        com.tencent.biz.qqcircle.immersive.adapter.m mVar = this.mLayerPageAdapter;
        if (mVar != null && mVar.getRecyclerView() != null && (gVar = this.f304578e) != null && gVar.O1().size() - 1 >= qFSTVideoScrollToNextEvent.getNextPos()) {
            this.mLayerPageAdapter.getRecyclerView().smoothScrollToPosition(qFSTVideoScrollToNextEvent.getNextPos());
        }
    }

    private void Z9(UIStateData uIStateData) {
        if (getLayerPageContainer() != null && getLayerPageContainer().u() != null) {
            if (uIStateData != null && !uIStateData.getIsFinish()) {
                getLayerPageContainer().u().setLoadText("\u52aa\u529b\u5237\u65b0\u4e2d");
            } else {
                getLayerPageContainer().u().setLoadText(com.tencent.biz.qqcircle.utils.h.a(R.string.f184043kt));
            }
            getLayerPageContainer().u().setHideSloganImage(true);
        }
    }

    private void aa() {
        if (getLayerPageContainer() != null && getLayerPageContainer().x() != null) {
            getLayerPageContainer().x().setCustomPullFreshText("\u6b63\u5728\u75af\u72c2\u5237\u65b0\u4e2d~");
            getLayerPageContainer().x().setCustomRefreshSuccessText("\u5237\u65b0\u6210\u529f");
            getLayerPageContainer().x().setCustomLoadingText("\u52aa\u529b\u5237\u65b0\u4e2d~");
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.base.QFSLayerBaseMiddleListPart
    protected com.tencent.biz.qqcircle.immersive.layer.base.e H9() {
        return this.f304578e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.layer.base.QFSLayerBaseMiddleListPart
    public void I9() {
        com.tencent.biz.qqcircle.immersive.layer.base.e H9 = H9();
        QCircleLayerBean qCircleLayerBean = this.f304577d;
        if (qCircleLayerBean == null) {
            return;
        }
        FeedCloudMeta$StFeed feed = qCircleLayerBean.getFeed();
        if (H9 != null && jy2.g.S(feed)) {
            ArrayList arrayList = new ArrayList();
            feed.f398449id.set("share_fake_" + feed.f398449id.get());
            arrayList.add(feed);
            H9.i2(arrayList);
        }
    }

    protected boolean R9() {
        if (this.f304579f == ox2.b.e().g()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> eventClass = super.getEventClass();
        eventClass.add(QFSTVideoEpisodeClickEvent.class);
        eventClass.add(QFSTVideoChannelClickEvent.class);
        eventClass.add(QFSTVideoLandScapeChannelClickEvent.class);
        eventClass.add(QFSTVideoAuthPayReloadEvent.class);
        eventClass.add(QFSTVideoScrollToNextEvent.class);
        eventClass.add(QFSTVideoEnterReloadEvent.class);
        eventClass.add(QFSTVideoFeedsItemSelectedEvent.class);
        eventClass.add(QFSTVideoScreenChangeReloadEvent.class);
        return eventClass;
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart, t40.a
    public int getFeedPosition() {
        return this.f304580h;
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart, t40.a
    public QCircleInitBean getInitBean() {
        return this.f304577d;
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart, com.tencent.biz.richframework.part.Part
    public String getLogTag() {
        return "QFSLayerTVideoListPart";
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart
    protected com.tencent.biz.qqcircle.immersive.adapter.m getPageAdapter() {
        return new com.tencent.mobileqq.tvideo.base.c(getHostFragment());
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart
    protected IDataDisplaySurface<e30.b> getViewModelSurface() {
        return O9();
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart, t40.a
    public boolean isContainerOnScreen() {
        return true;
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.base.QFSLayerBaseMiddleListPart, com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart, com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        E9();
        this.mLayerPageContainer.setRefreshEnable(true);
        this.mLayerPageContainer.setLoadMoreEnable(true);
        com.tencent.mobileqq.tvideo.viewmodel.g gVar = this.f304578e;
        if (gVar != null) {
            gVar.E2(VideoReport.pageInfoForView(view));
            this.f304578e.v2(this.f304577d, R9(), this.f304579f);
        }
        aa();
        Z9(null);
        VideoReport.setElementParams(this.mLayerPageContainer, gy2.c.g());
        VideoReport.setElementExposePolicy(this.mLayerPageContainer, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(this.mLayerPageContainer, ClickPolicy.REPORT_NONE);
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart, com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        if (this.f304581i.compareAndSet(false, true)) {
            L9();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        super.onReceiveEvent(simpleBaseEvent);
        if (jy2.g.u(this)) {
            return;
        }
        if (simpleBaseEvent instanceof QFSTVideoEpisodeClickEvent) {
            N9((QFSTVideoEpisodeClickEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof QFSTVideoChannelClickEvent) {
            this.f304579f = ((QFSTVideoChannelClickEvent) simpleBaseEvent).getChannelId();
            U9(false);
            return;
        }
        if (simpleBaseEvent instanceof QFSTVideoAuthPayReloadEvent) {
            W9((QFSTVideoAuthPayReloadEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof QFSTVideoScrollToNextEvent) {
            Y9((QFSTVideoScrollToNextEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof QFSTVideoEnterReloadEvent) {
            this.f304577d = ((QFSTVideoEnterReloadEvent) simpleBaseEvent).getLayerBean();
            I9();
            U9(true);
        } else if (simpleBaseEvent instanceof QFSTVideoScreenChangeReloadEvent) {
            T9(((QFSTVideoScreenChangeReloadEvent) simpleBaseEvent).getOrientation());
        } else if (simpleBaseEvent instanceof QFSTVideoFeedsItemSelectedEvent) {
            X9((QFSTVideoFeedsItemSelectedEvent) simpleBaseEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.layer.base.QFSLayerBaseMiddleListPart, com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart
    public void pageContainerOnPageSelected(int i3) {
        super.pageContainerOnPageSelected(i3);
        QLog.d("QFSLayerTVideoListPart", 4, "pageContainerOnPageSelected pos = " + i3);
        this.f304580h = i3;
        if (i3 > 0) {
            VideoReport.setElementId(this.mLayerPageContainer, "up_sld");
            VideoReport.reportEvent("clck", this.mLayerPageContainer, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart
    public void requestData(boolean z16, boolean z17) {
        com.tencent.mobileqq.tvideo.viewmodel.g gVar = this.f304578e;
        if (gVar == null) {
            return;
        }
        gVar.v2(this.f304577d, z16, this.f304579f);
        if (!z16) {
            VideoReport.setElementId(this.mLayerPageContainer, "dw_sld");
            VideoReport.reportEvent("clck", this.mLayerPageContainer, null);
        }
    }

    public q(QCircleLayerBean qCircleLayerBean, int i3) {
        this.f304581i = new AtomicBoolean(false);
        this.f304577d = qCircleLayerBean;
        this.f304579f = i3;
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.base.QFSLayerBaseMiddleListPart, com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart
    protected void fakeDateNotifyDataSetChanged(List<e30.b> list) {
    }
}
