package com.tencent.biz.qqcircle.immersive.feed;

import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.event.QCircleSeekAreaEvent;
import com.tencent.mobileqq.qcircle.api.helper.QCircleSeekAreaFrameLayout;
import com.tencent.widget.media.QUICombinationSeekBar;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes4.dex */
public class cr extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> {
    private static final int L = ImmersiveUtils.dpToPx(50.0f);
    private static final int M = ImmersiveUtils.dpToPx(81.0f);
    private QUICombinationSeekBar I;
    private QCircleSeekAreaFrameLayout J;
    private FeedCloudMeta$StFeed K;

    private void g1(boolean z16) {
        QCircleSeekAreaFrameLayout qCircleSeekAreaFrameLayout = this.J;
        if (qCircleSeekAreaFrameLayout == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) qCircleSeekAreaFrameLayout.getLayoutParams();
        if (z16) {
            layoutParams.setMargins(0, 0, 0, 0);
        } else {
            layoutParams.setMargins(0, M, 0, L);
        }
    }

    private boolean h1(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (com.tencent.biz.qqcircle.immersive.adapter.n.e(feedCloudMeta$StFeed) == 4003) {
            return true;
        }
        return false;
    }

    private void j1(MotionEvent motionEvent) {
        if (this.I == null || h1(this.K)) {
            return;
        }
        this.I.e().onTouchEvent(motionEvent);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(View view) {
        QUICombinationSeekBar qUICombinationSeekBar = (QUICombinationSeekBar) view.findViewById(R.id.f42691kg);
        this.I = qUICombinationSeekBar;
        qUICombinationSeekBar.setEventHelper(new com.tencent.biz.qqcircle.helpers.x());
        this.J = (QCircleSeekAreaFrameLayout) view.findViewById(R.id.f42711ki);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<? extends SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<? extends SimpleBaseEvent>> eventClass = super.getEventClass();
        eventClass.add(QCircleSeekAreaEvent.class);
        return eventClass;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: i1, reason: merged with bridge method [inline-methods] */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        super.L0(feedCloudMeta$StFeed, i3);
        g1(false);
        this.K = feedCloudMeta$StFeed;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QCircleSeekAreaEvent) {
            j1(((QCircleSeekAreaEvent) simpleBaseEvent).getEvent());
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onResumed(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onResumed(rFWFeedSelectInfo);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSFullScreenSeekAreaPresenter";
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onPaused(RFWFeedSelectInfo rFWFeedSelectInfo) {
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onStop(RFWFeedSelectInfo rFWFeedSelectInfo) {
    }
}
