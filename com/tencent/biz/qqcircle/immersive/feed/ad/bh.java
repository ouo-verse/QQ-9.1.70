package com.tencent.biz.qqcircle.immersive.feed.ad;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QFSCommentInfo;
import com.tencent.biz.qqcircle.events.QCircleCommentCountUpdateEvent;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes4.dex */
public class bh extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> implements View.OnClickListener {
    private View I;
    private ImageView J;
    private TextView K;

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
        return qFSCommentInfo;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void h1(QCircleCommentCountUpdateEvent qCircleCommentCountUpdateEvent) {
        T t16 = this.f85017h;
        if (t16 != 0 && TextUtils.equals(((FeedCloudMeta$StFeed) t16).f398449id.get(), qCircleCommentCountUpdateEvent.getFeedId())) {
            ((FeedCloudMeta$StFeed) this.f85017h).commentCount.set(qCircleCommentCountUpdateEvent.getCount());
            k1((FeedCloudMeta$StFeed) this.f85017h);
        }
    }

    private void j1() {
        if (s0() == null) {
            QLog.d("QFSFeedChildAdCommentPresenter", 1, "[openCommentPanel] feed ioc should not be null.");
        } else if (this.f85017h == 0) {
            QLog.e(getTAG(), 1, "[openCommentPanel] mData == null");
        } else {
            s0().onHandlerMessage("event_open_comment", g1());
        }
    }

    private void k1(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (this.K == null) {
            QLog.d("QFSFeedChildAdCommentPresenter", 1, "[updateFeedCommentText] video comment text should not be null.");
            return;
        }
        int i3 = feedCloudMeta$StFeed.commentCount.get();
        if (i3 <= 0) {
            i3 = 1;
        }
        this.K.setText(com.tencent.biz.qqcircle.immersive.utils.r.d(i3, 11));
        this.K.setTextSize(1, 12.0f);
    }

    private void l1(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        int i3;
        boolean f16 = u.f(feedCloudMeta$StFeed);
        View view = this.I;
        if (f16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        view.setVisibility(i3);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull View view) {
        super.N0(view);
        View findViewById = view.findViewById(R.id.f40161dm);
        this.I = findViewById;
        findViewById.setVisibility(0);
        this.K = (TextView) this.I.findViewById(R.id.v_n);
        ImageView imageView = (ImageView) this.I.findViewById(R.id.v_l);
        this.J = imageView;
        imageView.setOnClickListener(this);
        this.J.setImageResource(com.tencent.biz.qqcircle.k.c());
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<? extends SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<? extends SimpleBaseEvent>> eventClass = super.getEventClass();
        eventClass.add(QCircleCommentCountUpdateEvent.class);
        return eventClass;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: i1, reason: merged with bridge method [inline-methods] */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        super.L0(feedCloudMeta$StFeed, i3);
        if (feedCloudMeta$StFeed == null) {
            QLog.d("QFSFeedChildAdCommentPresenter", 1, "[onBindData] data should not be null.");
        } else {
            l1(feedCloudMeta$StFeed);
            k1(feedCloudMeta$StFeed);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        j1();
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        super.onReceiveEvent(simpleBaseEvent);
        if (simpleBaseEvent instanceof QCircleCommentCountUpdateEvent) {
            h1((QCircleCommentCountUpdateEvent) simpleBaseEvent);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return null;
    }
}
