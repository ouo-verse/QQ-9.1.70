package com.tencent.biz.qqcircle.fragments.message.presenter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QFSMessageItemInfo;
import com.tencent.biz.qqcircle.events.QCircleCommentPraiseUpdateEvent;
import com.tencent.biz.qqcircle.utils.QFSQUIUtilsKt;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta$StComment;
import feedcloud.FeedCloudMeta$StNotice;
import feedcloud.FeedCloudMeta$StOperation;
import feedcloud.FeedCloudMeta$StReply;
import java.util.ArrayList;
import qqcircle.QQCircleFeedBase$StBusiInfoCommentListData;

/* loaded from: classes4.dex */
public class QFSTopReplayMessagePresenter extends QFSDefaultNoticeMessagePresenter {
    private static final String TAG = "QFSTopReplayMessagePresenter";
    private n30.a mBottomOperationWrap;

    public QFSTopReplayMessagePresenter(int i3) {
        super(i3);
    }

    private FeedCloudMeta$StReply getTopAnimationReplyId(FeedCloudMeta$StComment feedCloudMeta$StComment) {
        if (feedCloudMeta$StComment == null) {
            return null;
        }
        int i3 = this.mViewType;
        if (i3 != 2 && i3 != 36 && i3 != 11) {
            return null;
        }
        return getReply(feedCloudMeta$StComment);
    }

    private void handlePraiseUpdateEvent(QCircleCommentPraiseUpdateEvent qCircleCommentPraiseUpdateEvent) {
        if (this.mBottomOperationWrap == null) {
            QLog.e(getLogTag(), 1, "handlePraiseUpdateEvent opWrap is null");
            return;
        }
        QFSMessageItemInfo qFSMessageItemInfo = this.mItemInfo;
        if (qFSMessageItemInfo == null) {
            QLog.e(getLogTag(), 1, "mItemInfo opWrap is null");
        } else if (isShowBottomOperationArea(qFSMessageItemInfo.getStNotice())) {
            this.mBottomOperationWrap.E(qCircleCommentPraiseUpdateEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initCustomView$0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        consumeItemNewFlag();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.QFSDefaultNoticeMessagePresenter, com.tencent.biz.qqcircle.fragments.message.presenter.QFSBaseNoticeMessagePresenter, com.tencent.biz.qqcircle.fragments.message.presenter.a
    public void bindCustomData(@NonNull QFSMessageItemInfo qFSMessageItemInfo, int i3) {
        setAtStyle(this.mTvMessage, QFSQUIUtilsKt.d(RFWApplication.getApplication(), R.color.qui_common_text_primary), false);
        super.bindCustomData(qFSMessageItemInfo, i3);
        n30.a aVar = this.mBottomOperationWrap;
        if (aVar != null) {
            aVar.f(qFSMessageItemInfo.getStNotice(), isShowBottomOperationArea(qFSMessageItemInfo.getStNotice()), getReportBean());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.QFSBaseNoticeMessagePresenter
    public View.OnClickListener getContainerClickListener() {
        if (this.mItemInfo.getStNotice() != null && this.mItemInfo.getStNotice().opMask.get().contains(2)) {
            QLog.w(TAG, 1, "\u4e0d\u5141\u8bb8\u8df3\u8f6c\uff1aopMask contains DISABLE_GOTO_DETAIL, getContainerClickListener return null");
            return null;
        }
        return super.getContainerClickListener();
    }

    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.QFSBaseNoticeMessagePresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> eventClass = super.getEventClass();
        eventClass.add(QCircleCommentPraiseUpdateEvent.class);
        return eventClass;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.QFSDefaultNoticeMessagePresenter, com.tencent.biz.qqcircle.fragments.message.presenter.a
    public String getLogTag() {
        return TAG;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.QFSDefaultNoticeMessagePresenter, com.tencent.biz.qqcircle.fragments.message.presenter.QFSBaseNoticeMessagePresenter, com.tencent.biz.qqcircle.fragments.message.presenter.a
    public void initCustomView(Context context, @NonNull View view) {
        super.initCustomView(context, view);
        this.mTvMessage.setMaxLines(Integer.MAX_VALUE);
        n30.a aVar = new n30.a(view, this.mViewType);
        this.mBottomOperationWrap = aVar;
        aVar.z(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.fragments.message.presenter.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                QFSTopReplayMessagePresenter.this.lambda$initCustomView$0(view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.QFSDefaultNoticeMessagePresenter
    public void initOtherQCircleBean(QCircleInitBean qCircleInitBean, boolean z16) {
        QFSMessageItemInfo qFSMessageItemInfo = this.mItemInfo;
        if (qFSMessageItemInfo != null && qFSMessageItemInfo.getStNotice() != null && this.mItemInfo.getStNotice().operation != null) {
            FeedCloudMeta$StOperation feedCloudMeta$StOperation = this.mItemInfo.getStNotice().operation;
            if (this.mViewType == 5 && uq3.c.m()) {
                QCircleInitBean.QCircleActionBean qCircleActionBean = new QCircleInitBean.QCircleActionBean();
                qCircleActionBean.mShowCommentPanelTabIndex = 2;
                ArrayList arrayList = new ArrayList();
                arrayList.add(feedCloudMeta$StOperation.opUser.f398463id.get());
                qCircleActionBean.mCommentPanelPushTabAnchorUinList = arrayList;
                qCircleActionBean.mShowCommentPanel = true;
                qCircleInitBean.setActionBean(qCircleActionBean);
                return;
            }
            FeedCloudMeta$StComment feedCloudMeta$StComment = feedCloudMeta$StOperation.comment.get();
            if (feedCloudMeta$StComment != null && !TextUtils.isEmpty(feedCloudMeta$StComment.f398447id.get())) {
                QQCircleFeedBase$StBusiInfoCommentListData qQCircleFeedBase$StBusiInfoCommentListData = new QQCircleFeedBase$StBusiInfoCommentListData();
                qQCircleFeedBase$StBusiInfoCommentListData.comment.set(feedCloudMeta$StComment);
                QCircleInitBean.QCircleActionBean qCircleActionBean2 = new QCircleInitBean.QCircleActionBean();
                qCircleActionBean2.mShowCommentPanel = true;
                qCircleActionBean2.mItemTopAnimationCommentId = feedCloudMeta$StComment.f398447id.get();
                FeedCloudMeta$StReply topAnimationReplyId = getTopAnimationReplyId(feedCloudMeta$StComment);
                if (topAnimationReplyId != null) {
                    qQCircleFeedBase$StBusiInfoCommentListData.reply.set(topAnimationReplyId);
                    qCircleActionBean2.mItemTopAnimationReplyId = topAnimationReplyId.f398460id.get();
                }
                qCircleInitBean.setBusiInfoData(qQCircleFeedBase$StBusiInfoCommentListData.toByteArray());
                qCircleInitBean.setActionBean(qCircleActionBean2);
                return;
            }
            return;
        }
        QLog.e(getLogTag(), 1, "[initOtherQCircleBean] operation is null ");
    }

    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.QFSBaseNoticeMessagePresenter
    protected boolean isShowBottomOperationArea(FeedCloudMeta$StNotice feedCloudMeta$StNotice) {
        if (feedCloudMeta$StNotice == null) {
            return false;
        }
        return feedCloudMeta$StNotice.opMask.get().contains(5);
    }

    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.QFSBaseNoticeMessagePresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QCircleCommentPraiseUpdateEvent) {
            handlePraiseUpdateEvent((QCircleCommentPraiseUpdateEvent) simpleBaseEvent);
        }
    }
}
