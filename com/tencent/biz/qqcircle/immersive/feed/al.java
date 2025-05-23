package com.tencent.biz.qqcircle.immersive.feed;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QFSCommentInfo;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSDoublePraiseEvent;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.widgets.QFSLikeImageView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StLike;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes4.dex */
public class al extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> implements Observer<e30.b> {
    private FeedCloudMeta$StFeed I;
    protected QFSLikeImageView J;
    private TextView K;
    private boolean L = false;
    private boolean M = false;
    private boolean N;
    private int P;
    private e30.b Q;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a implements View.OnClickListener {
        a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            T t16 = al.this.f85017h;
            if (t16 != 0 && ((FeedCloudMeta$StFeed) t16).poster != null && QCirclePluginUtil.isOwner(((FeedCloudMeta$StFeed) t16).poster.f398463id.get())) {
                al.this.k1();
            } else {
                QCircleToast.u(com.tencent.biz.qqcircle.immersive.personal.utils.k.d(), 0, true);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    private boolean h1(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        FeedCloudMeta$StLike feedCloudMeta$StLike;
        boolean z16;
        if (feedCloudMeta$StFeed != null) {
            feedCloudMeta$StLike = feedCloudMeta$StFeed.likeInfo;
        } else {
            feedCloudMeta$StLike = null;
        }
        if (feedCloudMeta$StLike == null) {
            return false;
        }
        if (!h20.c.h()) {
            return true;
        }
        if (feedCloudMeta$StLike.status.get() == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        int i3 = feedCloudMeta$StLike.count.get();
        if (z16 == this.N && i3 == this.P) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void k1() {
        t40.a s06 = s0();
        if (s06 == null) {
            QLog.d("PL-QFSFeedChildLikePresenter", 1, "[openPushPanel] feed ioc should not be null.");
            return;
        }
        QFSCommentInfo qFSCommentInfo = new QFSCommentInfo();
        qFSCommentInfo.mFeedBlockData = this.E;
        qFSCommentInfo.mFeed = (FeedCloudMeta$StFeed) this.f85017h;
        qFSCommentInfo.mReportBean = getReportBean();
        QFSCommentInfo.ActionBean actionBean = new QFSCommentInfo.ActionBean();
        actionBean.mShowCommentPanelTabIndex = 1;
        qFSCommentInfo.mActionBean = actionBean;
        s06.onHandlerMessage("event_open_comment", qFSCommentInfo);
    }

    private void l1(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        QFSLikeImageView qFSLikeImageView = this.J;
        if (qFSLikeImageView != null) {
            qFSLikeImageView.setFeed(feedCloudMeta$StFeed);
        }
    }

    private void m1(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed, String str) {
        int i3;
        int i16;
        if (this.K == null) {
            QLog.d("PL-QFSFeedChildLikePresenter", 1, "[updateFeedLike] video like text should not be null.");
            return;
        }
        if (this.J == null) {
            QLog.d("PL-QFSFeedChildLikePresenter", 1, "[updateFeedLike] mLikeImg should not be null.");
            return;
        }
        boolean z16 = false;
        if (feedCloudMeta$StFeed.likeInfo.count.get() == 0) {
            this.K.setText(R.string.f193704_x);
            this.K.setTextSize(1, 11.0f);
            this.J.setContentDescription(com.tencent.biz.qqcircle.utils.h.a(R.string.f1909843k));
            i3 = 0;
        } else {
            i3 = feedCloudMeta$StFeed.likeInfo.count.get();
            TextView textView = this.K;
            long j3 = i3;
            if (this.M) {
                i16 = 12;
            } else {
                i16 = 11;
            }
            textView.setText(com.tencent.biz.qqcircle.immersive.utils.r.d(j3, i16));
            this.K.setTextSize(1, 12.0f);
            this.J.setContentDescription(com.tencent.biz.qqcircle.utils.h.a(R.string.f187813v0) + ((Object) this.K.getText()));
        }
        this.J.setData(feedCloudMeta$StFeed);
        if (feedCloudMeta$StFeed.likeInfo.status.get() == 1) {
            z16 = true;
        }
        this.L = z16;
        if (this.N != z16 || this.P != i3) {
            QLog.d("PL-QFSFeedChildLikePresenter", 1, "[updateFeedLike] feed id: " + com.tencent.biz.qqcircle.utils.bj.h(feedCloudMeta$StFeed) + " isLiked: " + this.L + " likeNum: " + i3 + " source: " + str);
            this.N = this.L;
            this.P = i3;
        }
        this.J.n(this.L);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull View view) {
        super.N0(view);
        View findViewById = view.findViewById(R.id.f40611eu);
        this.J = (QFSLikeImageView) findViewById.findViewById(R.id.f40581er);
        this.K = (TextView) findViewById.findViewById(R.id.f40601et);
        this.J.setOnClickListener(new a());
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<? extends SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<? extends SimpleBaseEvent>> eventClass = super.getEventClass();
        eventClass.add(QFSDoublePraiseEvent.class);
        return eventClass;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: i1, reason: merged with bridge method [inline-methods] */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        super.L0(feedCloudMeta$StFeed, i3);
        if (feedCloudMeta$StFeed == null) {
            QLog.d("PL-QFSFeedChildLikePresenter", 1, "[onBindData] data should not be null.");
            return;
        }
        m1(feedCloudMeta$StFeed, "on bind");
        this.I = feedCloudMeta$StFeed;
        l1(feedCloudMeta$StFeed);
        this.Q = new e30.b(feedCloudMeta$StFeed);
        w20.a.j().observerGlobalState(this.Q, this);
    }

    @Override // androidx.lifecycle.Observer
    /* renamed from: j1, reason: merged with bridge method [inline-methods] */
    public void onChanged(e30.b bVar) {
        if (bVar != null && h1(bVar.g())) {
            m1(bVar.g(), "on change");
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        boolean z16;
        super.onFeedSelected(rFWFeedSelectInfo);
        if (rFWFeedSelectInfo != null && rFWFeedSelectInfo.isFullVideo()) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.M = z16;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedUnSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        boolean z16;
        super.onFeedUnSelected(rFWFeedSelectInfo);
        if (rFWFeedSelectInfo != null && rFWFeedSelectInfo.isFullVideo()) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.M = z16;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        super.onReceiveEvent(simpleBaseEvent);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "PL-QFSFeedChildLikePresenter";
    }
}
