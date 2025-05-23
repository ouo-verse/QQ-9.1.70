package com.tencent.biz.qqcircle.fragments.message.presenter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QFSMessageItemInfo;
import com.tencent.biz.qqcircle.helpers.q;
import com.tencent.biz.qqcircle.immersive.request.QFSBatchDoUrgeRequest;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.utils.QFSMessageAvatarWrapper;
import com.tencent.biz.qqcircle.utils.QFSQUIUtilsKt;
import com.tencent.biz.qqcircle.utils.cy;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import cooperation.qqcircle.report.QCirclePublishQualityReporter;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StNotice;
import feedcloud.FeedCloudMeta$StUser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import qqcircle.QQCircleFeedBase$StNoticeBusiData;
import qqcircle.QQCircleLightinteract$StBatchDoUrgeRsp;

/* loaded from: classes4.dex */
public class QFSPushMoreMessagePresenter extends QFSBaseMultiPersonActionMessagePresenter {
    private static final String TAG = "QFSPushMoreMessagePresenter";
    private View mFlButtonContainer;
    private ViewStub mMessageBtnViewStub;
    private TextView mTvRightBtn;

    public QFSPushMoreMessagePresenter(int i3) {
        super(i3);
    }

    private void dtReportConfigUrgeUpdateBtn() {
        TextView textView = this.mTvRightBtn;
        if (textView != null) {
            VideoReport.setElementId(textView, QCircleDaTongConstant.ElementId.EM_XSJ_MSG_FEATURE_BUTTON);
            VideoReport.setElementParams(this.mTvRightBtn, new QCircleDTParamBuilder().buildElementParams());
            VideoReport.setElementExposePolicy(this.mTvRightBtn, ExposurePolicy.REPORT_ALL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateUrgeUpdateReminder$0(BaseRequest baseRequest, boolean z16, long j3, String str, QQCircleLightinteract$StBatchDoUrgeRsp qQCircleLightinteract$StBatchDoUrgeRsp) {
        QLog.d(TAG, 1, "QFSBatchDoUrgeRequest  | isSuccess:" + z16 + " | retCode:" + j3 + " | errorMsg:" + str);
        if (z16 && j3 == 0) {
            str = com.tencent.biz.qqcircle.utils.h.a(R.string.f196334h1);
        } else {
            Iterator<Integer> it = this.mItemInfo.getStNotice().opMask.get().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next().intValue() == 4) {
                    it.remove();
                    break;
                }
            }
            noUrgeSettings();
        }
        QCircleToast.o(str, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateUrgeUpdateReminder$1(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (this.mItemInfo.getStNotice().opMask.get().contains(4)) {
            QCircleToast.o(com.tencent.biz.qqcircle.utils.h.a(R.string.f196324h0), 0);
        } else {
            this.mItemInfo.getStNotice().opMask.get().add(4);
            urgedSettings();
            ArrayList arrayList = new ArrayList();
            Iterator<FeedCloudMeta$StUser> it = this.mItemInfo.getStNotice().vecUser.get().iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().f398463id.get());
            }
            VSNetworkHelper.getInstance().sendRequest(new QFSBatchDoUrgeRequest(arrayList), new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.biz.qqcircle.fragments.message.presenter.m
                @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
                public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                    QFSPushMoreMessagePresenter.this.lambda$updateUrgeUpdateReminder$0(baseRequest, z16, j3, str, (QQCircleLightinteract$StBatchDoUrgeRsp) obj);
                }
            });
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateUrgeUpdateView$2(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        com.tencent.biz.qqcircle.launcher.c.g(this.mContext, cy.c(cy.a(this.mItemInfo.getStNotice().operation.jumpUrl.get(), QCirclePublishQualityReporter.getTraceId()), 3));
        EventCollector.getInstance().onViewClicked(view);
    }

    private void noUrgeSettings() {
        this.mTvRightBtn.setSelected(false);
        if (this.mItemInfo.getStNotice().vecUser.get().size() == 1) {
            this.mTvRightBtn.setText(com.tencent.biz.qqcircle.utils.h.a(R.string.f194314bk));
        } else {
            this.mTvRightBtn.setText(com.tencent.biz.qqcircle.utils.h.a(R.string.f194324bl));
        }
    }

    private void updateAvatarView() {
        if (this.mAvatarWrap == null) {
            QLog.e(getLogTag(), 1, "updateAvatarView mAvatarWrap is null");
        } else {
            if (this.mItemInfo.getStNotice().vecUser.get().size() == 1) {
                this.mAvatarWrap.w(0);
                this.mAvatarWrap.q(getLikeViewClickListener());
                this.mAvatarWrap.t(8);
                return;
            }
            this.mAvatarWrap.B(getContainerClickListener());
        }
    }

    private void updateRightButtonView() {
        if (this.mFlButtonContainer == null) {
            this.mFlButtonContainer = this.mMessageBtnViewStub.inflate();
        }
        View view = this.mFlButtonContainer;
        if (view != null) {
            view.setVisibility(0);
            TextView textView = (TextView) this.mFlButtonContainer.findViewById(R.id.f109316fh);
            this.mTvRightBtn = textView;
            textView.setEnabled(true);
            if (this.mItemInfo.getStNotice().noticeType.get() == 31) {
                updateUrgeUpdateReminder();
            } else if (this.mItemInfo.getStNotice().noticeType.get() == 17) {
                updateUrgeUpdateView();
            }
        }
    }

    private void updateUrgeUpdateReminder() {
        if (!this.mItemInfo.getStNotice().opMask.get().contains(4)) {
            noUrgeSettings();
        } else {
            urgedSettings();
        }
        this.mTvRightBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.fragments.message.presenter.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QFSPushMoreMessagePresenter.this.lambda$updateUrgeUpdateReminder$1(view);
            }
        });
        VideoReport.setElementId(this.mTvRightBtn, QCircleDaTongConstant.ElementId.EM_XSJ_MSG_FEATURE_BUTTON);
        VideoReport.setElementParams(this.mTvRightBtn, new QCircleDTParamBuilder().buildElementParams());
        VideoReport.setElementExposePolicy(this.mTvRightBtn, ExposurePolicy.REPORT_ALL);
    }

    private void updateUrgeUpdateView() {
        this.mTvRightBtn.setText(com.tencent.biz.qqcircle.utils.h.a(R.string.f193844aa));
        this.mTvRightBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.fragments.message.presenter.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QFSPushMoreMessagePresenter.this.lambda$updateUrgeUpdateView$2(view);
            }
        });
        dtReportConfigUrgeUpdateBtn();
    }

    private void urgedSettings() {
        this.mTvRightBtn.setSelected(true);
        this.mTvRightBtn.setText(com.tencent.biz.qqcircle.utils.h.a(R.string.f1908843a));
    }

    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.QFSDefaultNoticeMessagePresenter, com.tencent.biz.qqcircle.fragments.message.presenter.QFSBaseNoticeMessagePresenter, com.tencent.biz.qqcircle.fragments.message.presenter.a
    public void bindCustomData(@NonNull QFSMessageItemInfo qFSMessageItemInfo, int i3) {
        super.bindCustomData(qFSMessageItemInfo, i3);
        updateRightButtonView();
        updateAvatarView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.QFSBaseNoticeMessagePresenter
    public View.OnClickListener getContainerClickListener() {
        return getLikeViewClickListener();
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

    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.QFSBaseMultiPersonActionMessagePresenter, com.tencent.biz.qqcircle.fragments.message.presenter.QFSDefaultNoticeMessagePresenter, com.tencent.biz.qqcircle.fragments.message.presenter.QFSBaseNoticeMessagePresenter, com.tencent.biz.qqcircle.fragments.message.presenter.a
    public void initCustomView(Context context, @NonNull View view) {
        super.initCustomView(context, view);
        this.mMessageBtnViewStub = (ViewStub) view.findViewById(R.id.f33060vf);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.QFSBaseNoticeMessagePresenter
    public void initDtReport(QFSMessageItemInfo qFSMessageItemInfo, FeedCloudMeta$StNotice feedCloudMeta$StNotice, QQCircleFeedBase$StNoticeBusiData qQCircleFeedBase$StNoticeBusiData) {
        if (feedCloudMeta$StNotice == null) {
            return;
        }
        VideoReport.setElementId(this.mContainer, QCircleDaTongConstant.ElementId.EM_XSJ_IMPULSE_PUBLISH_MSG_ENTRANCE);
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_target_qq", feedCloudMeta$StNotice.operation.opUser.f398463id.get());
        int i3 = 0;
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_IF_PRIVATE_LETTER, 0);
        q.r().l(feedCloudMeta$StNotice, buildElementParams);
        if (qQCircleFeedBase$StNoticeBusiData.messageBoxRedPointInfo.needShow.get()) {
            i3 = 2;
        }
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_REDDOT_TYPE, Integer.valueOf(i3));
        buildElementParams.put("xsj_reddot_number", Integer.valueOf(qQCircleFeedBase$StNoticeBusiData.messageBoxRedPointInfo.needShow.get() ? 1 : 0));
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_MSG_ID, feedCloudMeta$StNotice.feedId.get());
        VideoReport.setElementParams(this.mContainer, buildElementParams);
        VideoReport.setElementId(this.mTvNick, QCircleDaTongConstant.ElementId.EM_XSJ_HANDLE_NAME);
        VideoReport.setElementId(this.mTvMessage, QCircleDaTongConstant.ElementId.EM_XSJ_HANDLE_NAME);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.QFSBaseNoticeMessagePresenter
    public void setContent(FeedCloudMeta$StNotice feedCloudMeta$StNotice) {
        String str = feedCloudMeta$StNotice.message.get();
        if (this.mItemInfo.getStNotice().vecUser.get().size() == 1) {
            this.mLLNickIcon.setVisibility(0);
            this.mTvNick.setText(str);
            QFSMessageAvatarWrapper qFSMessageAvatarWrapper = this.mAvatarWrap;
            if (qFSMessageAvatarWrapper != null) {
                qFSMessageAvatarWrapper.v(this.mItemInfo.getStNotice().vecUser.get(0).get());
            }
            this.mMessageContainer.setVisibility(8);
            return;
        }
        this.mLLNickIcon.setVisibility(8);
        this.mMessageContainer.setVisibility(0);
        this.mTvMessage.setTextColor(QFSQUIUtilsKt.d(RFWApplication.getApplication(), R.color.qui_common_text_primary));
        this.mTvMessageCount.setTextColor(QFSQUIUtilsKt.d(RFWApplication.getApplication(), R.color.qui_common_text_primary));
        this.mTvMessage.setTextSize(0, this.mContext.getResources().getDimension(R.dimen.c6v));
        this.mTvMessage.setTypeface(Typeface.defaultFromStyle(1));
        this.mTvMessageCount.setTextSize(0, this.mContext.getResources().getDimension(R.dimen.c6v));
        this.mTvMessageCount.setTypeface(Typeface.defaultFromStyle(1));
        this.mTvMessage.setText(str);
        reportImpEvent(this.mTvMessage);
        String replace = QCirclePluginUtil.getValueFromListEntry(this.mItemInfo.getNoticeBusiData().busiInfo.get(), "noticeVisitorCountMessage", "").replace("*", QCirclePluginUtil.getValueFromListEntry(this.mItemInfo.getNoticeBusiData().busiInfo.get(), "urgeCount", ""));
        if (replace != null) {
            this.mTvMessageCount.setText(replace);
        }
    }
}
