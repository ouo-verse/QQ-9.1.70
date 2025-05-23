package com.tencent.mobileqq.search.business.qcircle.video.user;

import android.content.Context;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.search.business.qcircle.video.base.QCircleSearchDoubleVideoItemView;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;

/* compiled from: P */
/* loaded from: classes18.dex */
public class QCircleSearchUserItemView extends QCircleSearchDoubleVideoItemView {
    private QCircleAvatarView S;
    private TextView T;
    private TextView U;

    public QCircleSearchUserItemView(@NonNull Context context) {
        super(context);
    }

    @Override // com.tencent.mobileqq.search.business.qcircle.video.base.QCircleSearchDoubleVideoItemView
    protected String E0() {
        return QCircleDaTongConstant.ElementParamValue.AUTHOR_FEEDS;
    }

    @Override // com.tencent.mobileqq.search.business.qcircle.video.base.QCircleSearchDoubleVideoItemView
    protected String F0() {
        return "em_xsj_big_search_author_feed_card";
    }

    @Override // com.tencent.mobileqq.search.business.qcircle.video.base.QCircleSearchDoubleVideoItemView
    protected String G0() {
        return "qArt";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.search.business.qcircle.video.base.QCircleSearchDoubleVideoItemView
    public void initView() {
        super.initView();
        this.S = (QCircleAvatarView) findViewById(R.id.a2o);
        this.T = (TextView) findViewById(R.id.f5e);
        this.U = (TextView) findViewById(R.id.bob);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.search.business.qcircle.video.base.QCircleSearchDoubleVideoItemView, com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: u0 */
    public void bindData(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        super.bindData(feedCloudMeta$StFeed, i3);
        this.S.setVisibility(8);
        this.T.setVisibility(8);
        this.U.setVisibility(8);
    }
}
