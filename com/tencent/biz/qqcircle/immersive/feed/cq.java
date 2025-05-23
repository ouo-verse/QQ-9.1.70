package com.tencent.biz.qqcircle.immersive.feed;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.aspectj.QCircleForbidInteractProcessor;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QFSCommentInfo;
import com.tencent.biz.qqcircle.comment.QFSBaseCommentPresenter;
import com.tencent.biz.qqcircle.comment.QFSCommentReportHelper;
import com.tencent.biz.qqcircle.events.QCircleCommentCountUpdateEvent;
import com.tencent.biz.qqcircle.events.QCircleResetCommentBlockEvent;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes4.dex */
public class cq extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> implements View.OnClickListener {
    private View I;
    private TextView J;
    private ImageView K;
    private FeedCloudMeta$StFeed L;
    private View M;

    /* JADX WARN: Multi-variable type inference failed */
    private QFSCommentInfo g1() {
        QFSCommentInfo qFSCommentInfo = new QFSCommentInfo();
        qFSCommentInfo.mFeedBlockData = this.E;
        qFSCommentInfo.mFeed = (FeedCloudMeta$StFeed) this.f85017h;
        qFSCommentInfo.mReportBean = getReportBean();
        qFSCommentInfo.mRelocationScrollType = 100;
        QCircleExtraTypeInfo r16 = r();
        if (r16 == null) {
            r16 = new QCircleExtraTypeInfo();
        }
        qFSCommentInfo.mExtraTypeInfo = r16;
        r16.mDataPosition = this.f85018i;
        qFSCommentInfo.mCmtPanelSource = 2;
        qFSCommentInfo.mHadAdBanner = com.tencent.biz.qqcircle.immersive.utils.ad.a.h((ViewGroup) this.M.findViewById(R.id.f40181do));
        return qFSCommentInfo;
    }

    private void h1(View view) {
        if (QCircleForbidInteractProcessor.forbidInteractIfGuildFeed(this.L, 1)) {
            QLog.d(getTAG(), 1, "commentBtnClick: guild feed forbid interact");
        } else if (view.getId() == R.id.f40161dm) {
            l1();
            T0(new com.tencent.biz.qqcircle.immersive.feed.event.j(true, true));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void i1(QCircleCommentCountUpdateEvent qCircleCommentCountUpdateEvent) {
        T t16 = this.f85017h;
        if (t16 == 0 || !TextUtils.equals(((FeedCloudMeta$StFeed) t16).f398449id.get(), qCircleCommentCountUpdateEvent.getFeedId())) {
            return;
        }
        ((FeedCloudMeta$StFeed) this.f85017h).commentCount.set(qCircleCommentCountUpdateEvent.getCount());
        p1((FeedCloudMeta$StFeed) this.f85017h);
    }

    private boolean j1() {
        return TextUtils.equals(com.tencent.biz.qqcircle.utils.h.a(R.string.f183253io), this.J.getText());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void l1() {
        String str;
        if (s0() == null) {
            QLog.d(getTAG(), 1, "[openCommentPanel] feed ioc should not be null.");
            return;
        }
        if (this.f85017h == 0) {
            QLog.e(getTAG(), 1, "[openCommentPanel] mData == null");
            return;
        }
        QFSCommentInfo g16 = g1();
        t40.a s06 = s0();
        if (n1()) {
            str = "event_open_comment_input";
        } else {
            str = "event_open_comment";
        }
        s06.onHandlerMessage(str, g16);
        R0(6, 2, r(), QFSCommentReportHelper.n((FeedCloudMeta$StFeed) this.f85017h));
        w20.a.j().m();
    }

    private void m1(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (!uq3.c.H6()) {
            return;
        }
        if (QFSBaseCommentPresenter.l(feedCloudMeta$StFeed)) {
            QLog.d(getTAG(), 1, "showFirstCommentGuildText isNotAllowCommentFeed return");
        } else {
            this.J.setText(R.string.f183253io);
        }
    }

    private boolean n1() {
        if (this.J != null && j1()) {
            return true;
        }
        return false;
    }

    private void o1(String str) {
        ImageView imageView = this.K;
        if (imageView == null) {
            return;
        }
        imageView.setContentDescription(str);
    }

    private void p1(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (this.J == null) {
            QLog.d(getTAG(), 1, "[updateFeedCommentText] video comment text should not be null.");
            return;
        }
        if (feedCloudMeta$StFeed.commentCount.get() <= 0) {
            this.J.setText(R.string.f181813es);
            m1(feedCloudMeta$StFeed);
            o1(com.tencent.biz.qqcircle.utils.h.a(R.string.f181813es));
        } else {
            this.J.setText(com.tencent.biz.qqcircle.immersive.utils.r.d(feedCloudMeta$StFeed.commentCount.get(), 11));
            o1(com.tencent.biz.qqcircle.utils.h.a(R.string.f187793uy) + ((Object) this.J.getText()));
        }
        g0(this.I, QCircleDaTongConstant.ElementId.EM_XSJ_COMMENT_BUTTON, new HashMap());
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public boolean H0() {
        return com.tencent.biz.qqcircle.manager.i.a("qfs_feed_comment_show");
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull View view) {
        super.N0(view);
        this.M = view;
        View inflate = ((ViewStub) view.findViewById(R.id.f40161dm)).inflate();
        this.I = inflate;
        inflate.setOnClickListener(this);
        this.J = (TextView) this.I.findViewById(R.id.v_n);
        ImageView imageView = (ImageView) this.I.findViewById(R.id.v_l);
        this.K = imageView;
        imageView.setImageResource(com.tencent.biz.qqcircle.k.c());
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<? extends SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<? extends SimpleBaseEvent>> eventClass = super.getEventClass();
        eventClass.add(QCircleCommentCountUpdateEvent.class);
        return eventClass;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: k1, reason: merged with bridge method [inline-methods] */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        super.L0(feedCloudMeta$StFeed, i3);
        if (feedCloudMeta$StFeed == null) {
            QLog.d(getTAG(), 1, "[onBindData] data should not be null.");
        } else {
            this.L = feedCloudMeta$StFeed;
            p1(feedCloudMeta$StFeed);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view != null) {
            h1(view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedUnSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        String str;
        super.onFeedUnSelected(rFWFeedSelectInfo);
        SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.L;
        if (feedCloudMeta$StFeed != null) {
            str = feedCloudMeta$StFeed.f398449id.get();
        } else {
            str = "";
        }
        simpleEventBus.dispatchEvent(new QCircleResetCommentBlockEvent(str));
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        super.onReceiveEvent(simpleBaseEvent);
        if (simpleBaseEvent instanceof QCircleCommentCountUpdateEvent) {
            i1((QCircleCommentCountUpdateEvent) simpleBaseEvent);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSFullScreenCommentPresenter";
    }
}
