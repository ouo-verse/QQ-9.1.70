package com.tencent.biz.qqcircle.fragments.message.presenter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.utils.QFSMessageAvatarWrapper;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.qqlive.module.videoreport.VideoReport;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StNotice;

/* loaded from: classes4.dex */
public class QFSVisitorMessagePresenter extends QFSBaseMultiPersonActionMessagePresenter {
    private static final String TAG = "QFSVisitorMessagePresenter";

    public QFSVisitorMessagePresenter(int i3) {
        super(i3);
    }

    private void dtReportConfig() {
        VideoReport.setElementId(this.mTvNick, QCircleDaTongConstant.ElementId.EM_XSJ_HANDLE_NAME);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.QFSDefaultNoticeMessagePresenter, com.tencent.biz.qqcircle.fragments.message.presenter.a
    public String getLogTag() {
        return TAG;
    }

    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.QFSBaseNoticeMessagePresenter
    protected void handleRightArrowShow() {
        this.mIvRightArrowLine1.setVisibility(0);
        this.mRightArrow.setVisibility(8);
    }

    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.QFSBaseNoticeMessagePresenter, com.tencent.biz.qqcircle.fragments.message.presenter.a
    protected void initClickListener() {
        View view = this.mContainer;
        if (view != null) {
            view.setOnClickListener(null);
        }
        QFSMessageAvatarWrapper qFSMessageAvatarWrapper = this.mAvatarWrap;
        if (qFSMessageAvatarWrapper != null) {
            qFSMessageAvatarWrapper.q(getLikeViewClickListener());
        }
        TextView textView = this.mTvNick;
        if (textView != null) {
            textView.setOnClickListener(getLikeViewClickListener());
        }
        QCircleAsyncTextView qCircleAsyncTextView = this.mTvMessage;
        if (qCircleAsyncTextView != null) {
            qCircleAsyncTextView.setOnClickListener(getLikeViewClickListener());
        }
        ConstraintLayout constraintLayout = this.mMessageContainer;
        if (constraintLayout != null) {
            constraintLayout.setOnClickListener(getLikeViewClickListener());
        }
        QCircleAsyncTextView qCircleAsyncTextView2 = this.mSubMessage;
        if (qCircleAsyncTextView2 != null) {
            qCircleAsyncTextView2.setOnClickListener(getLikeViewClickListener());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.QFSBaseMultiPersonActionMessagePresenter, com.tencent.biz.qqcircle.fragments.message.presenter.QFSDefaultNoticeMessagePresenter, com.tencent.biz.qqcircle.fragments.message.presenter.QFSBaseNoticeMessagePresenter, com.tencent.biz.qqcircle.fragments.message.presenter.a
    public void initCustomView(Context context, @NonNull View view) {
        super.initCustomView(context, view);
        dtReportConfig();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.QFSBaseNoticeMessagePresenter
    public void setContent(FeedCloudMeta$StNotice feedCloudMeta$StNotice) {
        String str = feedCloudMeta$StNotice.message.get();
        if (TextUtils.isEmpty(str)) {
            this.mMessageContainer.setVisibility(8);
            return;
        }
        this.mMessageContainer.setVisibility(0);
        this.mTvMessage.setVisibility(0);
        this.mTvMessage.setText(str);
        this.mTvMessageCount.setText(QCirclePluginUtil.getValueFromListEntry(this.mItemInfo.getNoticeBusiData().busiInfo.get(), "noticeVisitorCountMessage", ""));
        reportImpEvent(this.mTvMessage);
    }
}
