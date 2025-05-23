package com.tencent.biz.qqcircle.fragments.message.presenter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QFSMessageItemInfo;
import com.tencent.biz.qqcircle.fragments.message.widget.QFSMessageBottomJumpBtnView;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StNotice;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qqcircle.QQCircleFeedBase$StNoticeBusiData;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0014J\u001a\u0010\n\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0014J\u001a\u0010\u000f\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0014J&\u0010\u0016\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0014R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006 "}, d2 = {"Lcom/tencent/biz/qqcircle/fragments/message/presenter/QFSFriendPushNoticeMessagePresenter;", "Lcom/tencent/biz/qqcircle/fragments/message/presenter/QFSDefaultNoticeMessagePresenter;", "", "initJumpBtn", "", "getLogTag", "Landroid/content/Context;", "context", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "initCustomView", "Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;", "initBean", "", "isCover", "initOtherQCircleBean", "Lcom/tencent/biz/qqcircle/beans/QFSMessageItemInfo;", "itemInfo", "Lfeedcloud/FeedCloudMeta$StNotice;", "stNotice", "Lqqcircle/QQCircleFeedBase$StNoticeBusiData;", "stNoticeBusiData", "initDtReport", "Lcom/tencent/biz/qqcircle/fragments/message/widget/QFSMessageBottomJumpBtnView;", "jumpBtnView", "Lcom/tencent/biz/qqcircle/fragments/message/widget/QFSMessageBottomJumpBtnView;", "", "viewType", "<init>", "(I)V", "Companion", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSFriendPushNoticeMessagePresenter extends QFSDefaultNoticeMessagePresenter {

    @NotNull
    private static final String OPEN_FOLDER_SCHEME = "mqqapi://qcircle/openfolder?tabtype=6&is_force_jump_tab_page=1";

    @NotNull
    private static final String TAG = "QFSPushNoticeMessagePresenter";

    @Nullable
    private QFSMessageBottomJumpBtnView jumpBtnView;

    public QFSFriendPushNoticeMessagePresenter(int i3) {
        super(i3);
    }

    private final void initJumpBtn() {
        ViewGroup viewGroup;
        Context mContext = this.mContext;
        Intrinsics.checkNotNullExpressionValue(mContext, "mContext");
        QFSMessageBottomJumpBtnView qFSMessageBottomJumpBtnView = new QFSMessageBottomJumpBtnView(mContext);
        qFSMessageBottomJumpBtnView.setIconDrawable(R.drawable.qvideo_skin_icon_general_rocket_primary);
        String a16 = com.tencent.biz.qqcircle.utils.h.a(R.string.f1917845q);
        Intrinsics.checkNotNullExpressionValue(a16, "qqStr(R.string.qfs_messa\u2026iend_push_recommend_more)");
        qFSMessageBottomJumpBtnView.setDesc(a16);
        View view = this.mContentContainer;
        if (view instanceof ViewGroup) {
            viewGroup = (ViewGroup) view;
        } else {
            viewGroup = null;
        }
        if (viewGroup != null) {
            viewGroup.addView(qFSMessageBottomJumpBtnView);
        }
        qFSMessageBottomJumpBtnView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.fragments.message.presenter.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                QFSFriendPushNoticeMessagePresenter.initJumpBtn$lambda$0(QFSFriendPushNoticeMessagePresenter.this, view2);
            }
        });
        this.jumpBtnView = qFSMessageBottomJumpBtnView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initJumpBtn$lambda$0(QFSFriendPushNoticeMessagePresenter this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.biz.qqcircle.launcher.c.g(this$0.mContext, OPEN_FOLDER_SCHEME);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.QFSDefaultNoticeMessagePresenter, com.tencent.biz.qqcircle.fragments.message.presenter.a
    @NotNull
    public String getLogTag() {
        return TAG;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.QFSDefaultNoticeMessagePresenter, com.tencent.biz.qqcircle.fragments.message.presenter.QFSBaseNoticeMessagePresenter, com.tencent.biz.qqcircle.fragments.message.presenter.a
    public void initCustomView(@Nullable Context context, @NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.initCustomView(context, rootView);
        initJumpBtn();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.QFSBaseNoticeMessagePresenter
    public void initDtReport(@Nullable QFSMessageItemInfo itemInfo, @Nullable FeedCloudMeta$StNotice stNotice, @Nullable QQCircleFeedBase$StNoticeBusiData stNoticeBusiData) {
        super.initDtReport(itemInfo, stNotice, stNoticeBusiData);
        QFSMessageBottomJumpBtnView qFSMessageBottomJumpBtnView = this.jumpBtnView;
        if (qFSMessageBottomJumpBtnView == null || stNotice == null) {
            return;
        }
        VideoReport.setElementId(qFSMessageBottomJumpBtnView, QCircleDaTongConstant.ElementId.EM_XSJ_REC_MOREWORK);
        Map<String, Object> params = new QCircleDTParamBuilder().buildElementParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put(QCircleDaTongConstant.ElementParamKey.XSJ_MSG_ID, stNotice.feedId.get());
        VideoReport.setElementParams(this.jumpBtnView, params);
        VideoReport.setElementExposePolicy(this.jumpBtnView, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(this.jumpBtnView, ClickPolicy.REPORT_ALL);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.QFSDefaultNoticeMessagePresenter
    public void initOtherQCircleBean(@Nullable QCircleInitBean initBean, boolean isCover) {
        super.initOtherQCircleBean(initBean, isCover);
        QCircleInitBean.QCircleActionBean qCircleActionBean = new QCircleInitBean.QCircleActionBean();
        qCircleActionBean.mShowLightInteractListPanel = true;
        qCircleActionBean.mLightInteractListRequestType = 1;
        if (initBean != null) {
            initBean.setActionBean(qCircleActionBean);
        }
    }
}
