package com.tencent.biz.qqcircle.fragments.message.presenter;

import android.graphics.Typeface;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QFSMessageItemInfo;
import com.tencent.mobileqq.R;
import feedcloud.FeedCloudMeta$StComment;
import feedcloud.FeedCloudMeta$StNotice;
import feedcloud.FeedCloudMeta$StReply;
import feedcloud.FeedCloudMeta$StUser;
import java.util.ArrayList;
import java.util.List;
import qqcircle.QQCircleFeedBase$StBusiInfoCommentListData;

/* loaded from: classes4.dex */
public class QFSLikeMessagePresenter extends QFSBaseMultiPersonActionMessagePresenter {
    private static final String KEY_NOTICE_LIKE_COUNT_MESSAGE = "noticeLikeCountMessage";
    private static final String KEY_TOTAL_LIKE_COUNT = "totalLikeCount";
    private static final String TAG = "QFSLikeMessagePresenter";

    public QFSLikeMessagePresenter(int i3) {
        super(i3);
    }

    private List<String> getLikeTypeAnchorUinList() {
        FeedCloudMeta$StNotice stNotice;
        QFSMessageItemInfo qFSMessageItemInfo = this.mItemInfo;
        ArrayList arrayList = null;
        if (qFSMessageItemInfo == null) {
            stNotice = null;
        } else {
            stNotice = qFSMessageItemInfo.getStNotice();
        }
        if (stNotice == null) {
            return null;
        }
        List<FeedCloudMeta$StUser> list = stNotice.vecUser.get();
        if (list != null && list.size() > 0) {
            arrayList = new ArrayList();
            for (FeedCloudMeta$StUser feedCloudMeta$StUser : list) {
                if (feedCloudMeta$StUser != null) {
                    arrayList.add(feedCloudMeta$StUser.f398463id.get());
                }
            }
        }
        return arrayList;
    }

    private boolean needShowCommentPanel() {
        int i3 = this.mViewType;
        if (i3 == 6 || i3 == 7) {
            return true;
        }
        if (i3 == 0 && uq3.c.m()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.QFSDefaultNoticeMessagePresenter, com.tencent.biz.qqcircle.fragments.message.presenter.a
    public String getLogTag() {
        return TAG;
    }

    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.QFSBaseNoticeMessagePresenter
    protected View.OnClickListener getMessageClickListener() {
        return getLikeViewClickListener();
    }

    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.QFSBaseNoticeMessagePresenter
    protected void handleRightArrowShow() {
        this.mIvRightArrowLine1.setVisibility(0);
        this.mRightArrow.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.QFSDefaultNoticeMessagePresenter
    public void initOtherQCircleBean(QCircleInitBean qCircleInitBean, boolean z16) {
        FeedCloudMeta$StComment feedCloudMeta$StComment = this.mItemInfo.getStNotice().operation.comment.get();
        if (feedCloudMeta$StComment == null) {
            return;
        }
        QQCircleFeedBase$StBusiInfoCommentListData qQCircleFeedBase$StBusiInfoCommentListData = new QQCircleFeedBase$StBusiInfoCommentListData();
        qQCircleFeedBase$StBusiInfoCommentListData.comment.set(feedCloudMeta$StComment);
        QCircleInitBean.QCircleActionBean qCircleActionBean = new QCircleInitBean.QCircleActionBean();
        if (this.mViewType == 0) {
            qCircleActionBean.mShowCommentPanelTabIndex = 1;
            List<String> likeTypeAnchorUinList = getLikeTypeAnchorUinList();
            if (likeTypeAnchorUinList != null) {
                qCircleActionBean.mCommentPanelLikeTabAnchorUinList = likeTypeAnchorUinList;
            }
        }
        if (needShowCommentPanel()) {
            qCircleActionBean.mShowCommentPanel = true;
        }
        qCircleActionBean.mShowInputKeyboard = false;
        qCircleActionBean.mItemTopAnimationCommentId = feedCloudMeta$StComment.f398447id.get();
        FeedCloudMeta$StReply reply = getReply(feedCloudMeta$StComment);
        if (reply != null) {
            qQCircleFeedBase$StBusiInfoCommentListData.reply.set(reply);
            qCircleActionBean.mItemTopAnimationReplyId = reply.f398460id.get();
        }
        qCircleActionBean.mNeedCancelLikeToast = true;
        qCircleInitBean.setBusiInfoData(qQCircleFeedBase$StBusiInfoCommentListData.toByteArray());
        qCircleInitBean.setActionBean(qCircleActionBean);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.QFSBaseNoticeMessagePresenter
    public void setContent(FeedCloudMeta$StNotice feedCloudMeta$StNotice) {
        if (this.mItemInfo.getStNotice().vecUser.get() != null && this.mItemInfo.getStNotice().vecUser.get().size() > 1) {
            this.mLLNickIcon.setVisibility(8);
            this.mMessageContainer.setVisibility(0);
            this.mMessageContainer.setOnClickListener(getLikeViewClickListener());
            this.mIvRightArrowLine1.setOnClickListener(getMessageClickListener());
            this.mTvMessage.setTextSize(0, this.mContext.getResources().getDimension(R.dimen.c6v));
            this.mTvMessage.setTypeface(Typeface.defaultFromStyle(1));
            this.mTvMessageCount.setTextSize(0, this.mContext.getResources().getDimension(R.dimen.c6v));
            this.mTvMessageCount.setTypeface(Typeface.defaultFromStyle(1));
            this.mTvMessage.setText(feedCloudMeta$StNotice.message.get());
            this.mTvMessageCount.setText(QCirclePluginUtil.getValueFromListEntry(this.mItemInfo.getNoticeBusiData().busiInfo.get(), KEY_NOTICE_LIKE_COUNT_MESSAGE, "").replace("*", QCirclePluginUtil.getValueFromListEntry(this.mItemInfo.getNoticeBusiData().busiInfo.get(), KEY_TOTAL_LIKE_COUNT, "")));
            this.mTvMessageCount.setOnClickListener(getLikeViewClickListener());
            reportImpEvent(this.mTvMessage);
            return;
        }
        this.mLLNickIcon.setVisibility(0);
        this.mMessageContainer.setVisibility(8);
    }

    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.QFSBaseNoticeMessagePresenter
    protected void setSubContent(String str) {
        if (TextUtils.isEmpty(str)) {
            this.mSubMessageContainer.setVisibility(8);
            return;
        }
        this.mSubMessageContainer.setVisibility(0);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str.trim());
        appendMessageTimeText(spannableStringBuilder, this.mItemInfo.getStNotice());
        this.mSubMessage.setMinimumWidth(QFSBaseNoticeMessagePresenter.MESSAGE_VIEW_MIN_WIDTH);
        this.mSubMessage.setText(spannableStringBuilder);
        reportImpEvent(this.mSubMessage);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.QFSBaseNoticeMessagePresenter
    public void setTime(FeedCloudMeta$StNotice feedCloudMeta$StNotice) {
        this.mTvTime.setVisibility(8);
    }
}
