package com.tencent.biz.qqcircle.immersive.views.mixfeed;

import android.content.Context;
import android.util.Size;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QFSCommentInfo;
import com.tencent.biz.qqcircle.immersive.utils.n;
import com.tencent.biz.qqcircle.utils.QFSCommentHelper;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StComment;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSMixFeedRecommendCommentItemView extends QFSMixFeedBaseWidgetView<FeedCloudMeta$StComment> implements View.OnClickListener {
    private QCircleAsyncTextView C;
    private Size D;

    /* renamed from: e, reason: collision with root package name */
    private FeedCloudMeta$StFeed f90870e;

    /* renamed from: f, reason: collision with root package name */
    private FeedCloudMeta$StComment f90871f;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f90872h;

    /* renamed from: i, reason: collision with root package name */
    private QCircleAvatarView f90873i;

    /* renamed from: m, reason: collision with root package name */
    private TextView f90874m;

    public QFSMixFeedRecommendCommentItemView(@NonNull Context context) {
        super(context);
        initView();
    }

    private void initView() {
        this.f90872h = (ImageView) findViewById(R.id.f3589133);
        this.f90873i = (QCircleAvatarView) findViewById(R.id.f352911g);
        this.f90874m = (TextView) findViewById(R.id.f3591135);
        this.C = (QCircleAsyncTextView) findViewById(R.id.f3626143);
        this.D = n.a(getContext(), R.dimen.d0k);
        o0();
    }

    private QFSCommentInfo l0(FeedCloudMeta$StComment feedCloudMeta$StComment) {
        if (getReportBean() != null) {
            getReportBean().setFromElement(QCircleDaTongConstant.ElementId.EM_XSJ_INFO_CARD);
        }
        QFSCommentInfo qFSCommentInfo = new QFSCommentInfo();
        qFSCommentInfo.mFeedBlockData = n0(this.f90870e);
        qFSCommentInfo.mFeed = this.f90870e;
        qFSCommentInfo.mReportBean = getReportBean();
        qFSCommentInfo.mRelocationScrollType = 100;
        QCircleExtraTypeInfo qCircleExtraTypeInfo = getQCircleExtraTypeInfo();
        qFSCommentInfo.mExtraTypeInfo = qCircleExtraTypeInfo;
        qCircleExtraTypeInfo.mDataPosition = getQCircleExtraTypeInfo().mDataPosition;
        qFSCommentInfo.mTargetComment = feedCloudMeta$StComment;
        qFSCommentInfo.mNeedLocateComment = true;
        qFSCommentInfo.mCommentId = feedCloudMeta$StComment.f398447id.get();
        qFSCommentInfo.mCmtPanelSource = 3;
        qFSCommentInfo.mIsShowMask = true;
        return qFSCommentInfo;
    }

    private void m0() {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_COMMENT_ID, this.f90871f.f398447id.get());
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_LAYER_PAGE_REF_EID, QCircleDaTongConstant.ElementId.EM_XSJ_INFO_CARD);
        VideoReport.setElementId(this.C, QCircleDaTongConstant.ElementId.EM_XSJ_HOTCOMMENT_BAR);
        VideoReport.setElementParams(this.C, buildElementParams);
        VideoReport.setElementExposePolicy(this.C, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(this.C, ClickPolicy.REPORT_ALL);
    }

    private e30.b n0(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        return new e30.b(feedCloudMeta$StFeed);
    }

    private void o0() {
        this.f90872h.setOnClickListener(this);
        this.f90873i.setOnClickListener(this);
        this.f90874m.setOnClickListener(this);
        this.C.setOnClickListener(this);
    }

    private void p0(FeedCloudMeta$StComment feedCloudMeta$StComment) {
        if (getInteractor() == null) {
            return;
        }
        ((j20.a) getInteractor()).c("event_open_comment", l0(feedCloudMeta$StComment));
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gbm;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void bindData(FeedCloudMeta$StComment feedCloudMeta$StComment, int i3) {
        int i16;
        int i17;
        if (feedCloudMeta$StComment == null) {
            return;
        }
        this.f90871f = feedCloudMeta$StComment;
        boolean V = QFSCommentHelper.V(feedCloudMeta$StComment.typeFlag2.get(), 4);
        ImageView imageView = this.f90872h;
        int i18 = 0;
        if (V) {
            i16 = 0;
        } else {
            i16 = 8;
        }
        imageView.setVisibility(i16);
        QCircleAvatarView qCircleAvatarView = this.f90873i;
        if (V) {
            i17 = 8;
        } else {
            i17 = 0;
        }
        qCircleAvatarView.setVisibility(i17);
        TextView textView = this.f90874m;
        if (V) {
            i18 = 8;
        }
        textView.setVisibility(i18);
        this.C.setText(feedCloudMeta$StComment.content.get());
        if (!V) {
            this.f90874m.setText(feedCloudMeta$StComment.postUser.nick.get());
            this.f90873i.setAvatar(feedCloudMeta$StComment.postUser, this.D);
        }
        m0();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view != null) {
            p0(this.f90871f);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void setStFeed(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        this.f90870e = feedCloudMeta$StFeed;
    }
}
