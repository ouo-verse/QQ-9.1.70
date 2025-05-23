package com.tencent.biz.qqcircle.immersive.feed.ad;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes4.dex */
public class cv extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> implements View.OnClickListener {
    private ImageView I;
    private TextView J;

    /* JADX WARN: Multi-variable type inference failed */
    private void h1() {
        if (s0() == null) {
            QLog.d("QFSFeedChildAdSharePresenter", 1, "[openSharePanel] feed ioc should not be null.");
            return;
        }
        if (((FeedCloudMeta$StFeed) this.f85017h).opMask2.get().contains(26)) {
            return;
        }
        QCircleShareInfo c16 = com.tencent.biz.qqcircle.immersive.utils.au.c((FeedCloudMeta$StFeed) this.f85017h);
        c16.feedBlockData = this.E;
        c16.extraTypeInfo.mDataPosition = this.f85018i;
        c16.feed = (FeedCloudMeta$StFeed) this.f85017h;
        c16.mReportBean = getReportBean();
        c16.isShowReport = false;
        c16.isShowDisLike = false;
        c16.isShowDeletePushDisable = false;
        c16.isShowDeletePush = false;
        c16.isShowSetToPublicPermission = false;
        c16.isEnableShareToMutual = com.tencent.biz.qqcircle.immersive.utils.a.c();
        c16.mDTReportExtMapOnSendSuccess = new HashMap();
        c16.mDTReportExtMapOnSendSuccess.put("1", ua0.c.f(m0()));
        s0().onHandlerMessage("event_open_share", c16);
    }

    private void i1(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (this.J == null) {
            QLog.d("QFSFeedChildAdSharePresenter", 1, "[updateFeedShareText] share text should not be null.");
            return;
        }
        if (this.I == null) {
            QLog.d("QFSFeedChildAdSharePresenter", 1, "[updateFeedShareText] mShareImg should not be null.");
            return;
        }
        if (feedCloudMeta$StFeed.share.sharedCount.get() == 0) {
            this.J.setText(R.string.f184893n4);
            this.J.setTextSize(1, 11.0f);
        } else {
            this.J.setText(com.tencent.biz.qqcircle.immersive.utils.r.d(feedCloudMeta$StFeed.share.sharedCount.get(), 11));
            this.J.setTextSize(1, 12.0f);
        }
        f0(this.I, "em_xsj_share_button");
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull View view) {
        super.N0(view);
        View findViewById = view.findViewById(R.id.f41401gz);
        this.J = (TextView) findViewById.findViewById(R.id.f165235va2);
        ImageView imageView = (ImageView) findViewById.findViewById(R.id.f165971dy1);
        this.I = imageView;
        imageView.setOnClickListener(this);
        this.I.setOnClickListener(this);
        this.I.setContentDescription("\u5206\u4eab");
        this.I.setImageResource(com.tencent.biz.qqcircle.k.p());
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: g1, reason: merged with bridge method [inline-methods] */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        super.L0(feedCloudMeta$StFeed, i3);
        if (feedCloudMeta$StFeed == null) {
            QLog.d("QFSFeedChildAdSharePresenter", 1, "[onBindData] data should not be null.");
        } else {
            i1(feedCloudMeta$StFeed);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view == this.I) {
            h1();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return null;
    }
}
