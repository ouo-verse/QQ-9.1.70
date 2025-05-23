package com.tencent.biz.qqcircle.fragments.message.presenter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.biz.qqcircle.beans.QFSMessageItemInfo;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StNotice;
import feedcloud.FeedCloudMeta$StOperation;
import feedcloud.FeedCloudMeta$StUser;
import java.util.Map;

/* loaded from: classes4.dex */
public class QFSNewFriendThankMessagePresenter extends QFSBaseNoticeMessagePresenter {
    private static final String TAG = "QFSNewFriendThankMessagePresenter";
    private View mProfilerCallView;
    private TextView mProfilerTextView;

    public QFSNewFriendThankMessagePresenter(int i3) {
        super(i3);
    }

    private void dtReportCallProfiler(FeedCloudMeta$StNotice feedCloudMeta$StNotice) {
        FeedCloudMeta$StOperation feedCloudMeta$StOperation;
        FeedCloudMeta$StUser feedCloudMeta$StUser;
        if (this.mProfilerCallView != null && feedCloudMeta$StNotice != null && (feedCloudMeta$StOperation = feedCloudMeta$StNotice.operation) != null && (feedCloudMeta$StUser = feedCloudMeta$StOperation.opUser) != null && feedCloudMeta$StUser.f398463id != null) {
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            String str = feedCloudMeta$StNotice.operation.opUser.f398463id.get();
            if (!TextUtils.isEmpty(str)) {
                buildElementParams.put("xsj_target_qq", str);
            }
            VideoReport.setElementId(this.mProfilerCallView, QCircleDaTongConstant.ElementId.EM_XSJ_VIEW_CP_WORK_BUTTON);
            VideoReport.setElementParams(this.mProfilerCallView, buildElementParams);
        }
    }

    private void dtReportCallProfilerClick(View view, FeedCloudMeta$StNotice feedCloudMeta$StNotice) {
        FeedCloudMeta$StOperation feedCloudMeta$StOperation;
        FeedCloudMeta$StUser feedCloudMeta$StUser;
        if (view != null && feedCloudMeta$StNotice != null && (feedCloudMeta$StOperation = feedCloudMeta$StNotice.operation) != null && (feedCloudMeta$StUser = feedCloudMeta$StOperation.opUser) != null && feedCloudMeta$StUser.f398463id != null) {
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            String str = feedCloudMeta$StNotice.operation.opUser.f398463id.get();
            if (!TextUtils.isEmpty(str)) {
                buildElementParams.put("xsj_target_qq", str);
            }
            VideoReport.setElementId(this.mProfilerCallView, QCircleDaTongConstant.ElementId.EM_XSJ_VIEW_CP_WORK_BUTTON);
            VideoReport.setElementParams(this.mProfilerCallView, buildElementParams);
            VideoReport.reportEvent("dt_clck", view, buildElementParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setProfilerCall$0(FeedCloudMeta$StNotice feedCloudMeta$StNotice, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        gotoProfilerPage(view.getContext(), feedCloudMeta$StNotice);
        dtReportCallProfilerClick(view, feedCloudMeta$StNotice);
        EventCollector.getInstance().onViewClicked(view);
    }

    private void setProfilerCall(final FeedCloudMeta$StNotice feedCloudMeta$StNotice) {
        if (this.mProfilerCallView == null) {
            ViewStub viewStub = (ViewStub) this.mContainer.findViewById(R.id.f33030vc);
            if (viewStub == null) {
                QLog.d(getLogTag(), 1, "[initProfilerBtnView] vsCallProfiler = null");
                return;
            }
            View inflate = viewStub.inflate();
            this.mProfilerCallView = inflate;
            TextView textView = (TextView) inflate.findViewById(R.id.f109316fh);
            this.mProfilerTextView = textView;
            textView.setText(com.tencent.biz.qqcircle.utils.h.a(R.string.f188523wx));
            this.mProfilerCallView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.fragments.message.presenter.l
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QFSNewFriendThankMessagePresenter.this.lambda$setProfilerCall$0(feedCloudMeta$StNotice, view);
                }
            });
        }
        this.mProfilerCallView.setVisibility(0);
        View view = (View) this.mContentContainer.getParent();
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), 0);
        dtReportCallProfiler(feedCloudMeta$StNotice);
    }

    private boolean updateNewFriendThankContent(FeedCloudMeta$StNotice feedCloudMeta$StNotice, String str) {
        ConstraintLayout constraintLayout;
        if (TextUtils.isEmpty(str) || this.mTvMessage == null || (constraintLayout = this.mMessageContainer) == null) {
            return false;
        }
        constraintLayout.setVisibility(0);
        this.mTvMessage.setSingleLine(true);
        this.mTvMessage.setEllipsize(TextUtils.TruncateAt.END);
        this.mTvMessage.setMinimumWidth(QFSBaseNoticeMessagePresenter.MESSAGE_VIEW_MIN_WIDTH);
        this.mTvMessage.setText(str.trim());
        reportImpEvent(this.mTvMessage);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.QFSBaseNoticeMessagePresenter, com.tencent.biz.qqcircle.fragments.message.presenter.a
    public void bindCustomData(@NonNull QFSMessageItemInfo qFSMessageItemInfo, int i3) {
        super.bindCustomData(qFSMessageItemInfo, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.QFSBaseNoticeMessagePresenter
    public View.OnClickListener getContainerClickListener() {
        return super.getAvatarClickListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.a
    public String getLogTag() {
        return TAG;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.QFSBaseNoticeMessagePresenter, com.tencent.biz.qqcircle.fragments.message.presenter.a
    public void initCustomView(Context context, @NonNull View view) {
        super.initCustomView(context, view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.QFSBaseNoticeMessagePresenter
    public void setContent(FeedCloudMeta$StNotice feedCloudMeta$StNotice) {
        if (feedCloudMeta$StNotice != null && this.mAvatarListView != null && this.mMessageContainer != null && this.mTvMessage != null) {
            setProfilerCall(feedCloudMeta$StNotice);
            this.mTvMessage.setEllipsize(TextUtils.TruncateAt.END);
            this.mTvMessage.setMaxLines(3);
            this.mTvMessage.setSingleLine(false);
            this.mAvatarListView.setVisibility(8);
            this.mMessageContainer.setVisibility(8);
            String str = feedCloudMeta$StNotice.message.get();
            if (TextUtils.isEmpty(str)) {
                this.mMessageContainer.setVisibility(8);
            } else {
                this.mMessageContainer.setVisibility(0);
                this.mTvMessage.setText(str);
            }
            updateNewFriendThankContent(feedCloudMeta$StNotice, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.QFSBaseNoticeMessagePresenter
    public void setTime(FeedCloudMeta$StNotice feedCloudMeta$StNotice) {
        TextView textView = this.mTvTime;
        if (textView != null && feedCloudMeta$StNotice != null) {
            textView.setText(com.tencent.biz.qqcircle.widgets.comment.b.f(feedCloudMeta$StNotice.createTime.get() * 1000));
            this.mTvTime.setVisibility(0);
        }
    }
}
