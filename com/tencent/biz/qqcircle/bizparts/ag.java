package com.tencent.biz.qqcircle.bizparts;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.adapter.QFSCommentBlock;
import com.tencent.biz.qqcircle.adapter.QFSCommentReplyAdapter;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.qqcircle.beans.QFSCommentInfo;
import com.tencent.biz.qqcircle.beans.QFSCommentInputWindowConfig;
import com.tencent.biz.qqcircle.beans.QFSCommentItemInfo;
import com.tencent.biz.qqcircle.beans.QFSCommentPublishFeedAttrBean;
import com.tencent.biz.qqcircle.beans.QFSCommentPublishFeedDraftBean;
import com.tencent.biz.qqcircle.beans.QFSFeedCommentInfo;
import com.tencent.biz.qqcircle.comment.QFSBaseCommentPresenter;
import com.tencent.biz.qqcircle.comment.QFSCommentReportHelper;
import com.tencent.biz.qqcircle.comment.emoji.QFSCommentEmojiOperationManager;
import com.tencent.biz.qqcircle.events.QCircleAtUpdateEvent;
import com.tencent.biz.qqcircle.events.QCircleCommentCountUpdateEvent;
import com.tencent.biz.qqcircle.events.QCircleCommentUpdateEvent;
import com.tencent.biz.qqcircle.events.QFSAddFakeCommentOrReplyEvent;
import com.tencent.biz.qqcircle.events.QFSCommentEmotionRedPointEvent;
import com.tencent.biz.qqcircle.events.QFSCommentHintTextEvent;
import com.tencent.biz.qqcircle.events.QFSCommentOrReplySharePanelClickEvent;
import com.tencent.biz.qqcircle.events.QFSCommentSendEvent;
import com.tencent.biz.qqcircle.events.QFSECommerceEvent;
import com.tencent.biz.qqcircle.events.QFSFakeCommentSendEvent;
import com.tencent.biz.qqcircle.events.QFSFavEmojiTabSelectEvent;
import com.tencent.biz.qqcircle.events.QFSRebuildInSplitViewModeEvent;
import com.tencent.biz.qqcircle.fragments.QCircleBlockContainer;
import com.tencent.biz.qqcircle.immersive.events.QFSShowPersonalPanelEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSFullScreenCloseEvent;
import com.tencent.biz.qqcircle.immersive.views.mixfeed.piclayerpage.QFSNewContentDetailBodyCommentPart;
import com.tencent.biz.qqcircle.j;
import com.tencent.biz.qqcircle.manager.QCircleAvatarDecorateManager;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.richframework.widget.menu.BubblePopupWindow;
import com.tencent.biz.qqcircle.utils.QCircleBindPhoneNumberHelper;
import com.tencent.biz.qqcircle.utils.QFSCommentHelper;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.biz.qqcircle.widgets.QCircleCustomDialog;
import com.tencent.biz.qqcircle.widgets.comment.f;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.ioc.callback.OnPromiseResolved;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.richframework.part.block.BlockMerger;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.engineering.preload.PreLoader;
import com.tencent.mobileqq.engineering.preload.inter.OnTaskListener;
import com.tencent.mobileqq.qcircle.api.global.QCircleHostGlobalInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.api.WinkVideoCommentCompleteEvent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.text.rich.RFWAsyncRichTextView;
import com.tencent.richframework.text.rich.parser.RichTextClickableImageSpanParser;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qzone.widget.QzoneEmotionUtils;
import feedcloud.FeedCloudMeta$StComment;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StFeedAbstract;
import feedcloud.FeedCloudMeta$StImage;
import feedcloud.FeedCloudMeta$StReply;
import feedcloud.FeedCloudMeta$StShare;
import feedcloud.FeedCloudMeta$StUser;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;
import qqcircle.QQCircleFeedBase$StBusiInfoCommentListData;

/* compiled from: P */
/* loaded from: classes4.dex */
public abstract class ag extends com.tencent.biz.qqcircle.bizparts.b implements com.tencent.biz.qqcircle.widgets.comment.c, SimpleEventReceiver, View.OnClickListener, com.tencent.biz.qqcircle.immersive.views.mixfeed.piclayerpage.a {
    public static final String TAG = "QFSBaseCommentPart";

    @NonNull
    protected final QFSCommentBlock mBlock;
    private BlockContainer mBlockContainer;
    private QQCircleFeedBase$StBusiInfoCommentListData mBusiInfoCommentListDataFromInitBean;
    protected com.tencent.biz.qqcircle.viewmodels.n mCommentBlockViewModel;

    @NonNull
    protected final QFSBaseCommentPresenter mCommentPresenter;
    protected int mCurCommentCount;
    protected int mCurrentShowCommentAndReplyCount;
    private String mFastCommentText;
    protected QFSCommentInfo mInfo;
    private QCircleInitBean mInitBean;
    protected boolean mIsNeedShowPublishIcon;
    private com.tencent.biz.qqcircle.widgets.comment.f mKeyBoardHelper;
    protected boolean mNeedShowBubbleGuide;
    protected com.tencent.biz.qqcircle.comment.v mPublishFeedManager;
    protected com.tencent.biz.qqcircle.richframework.part.a<QCircleReportBean> mReportBeanAgent;
    protected int mSendPreActionType;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ FeedCloudMeta$StComment f82837d;

        a(FeedCloudMeta$StComment feedCloudMeta$StComment) {
            this.f82837d = feedCloudMeta$StComment;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            ag.this.getCommentBusiness().q(ag.this.getActivity().hashCode(), ag.this.getFeedData(), this.f82837d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class c implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ FeedCloudMeta$StComment f82840d;

        c(FeedCloudMeta$StComment feedCloudMeta$StComment) {
            this.f82840d = feedCloudMeta$StComment;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            ag.this.getCommentBusiness().f0(ag.this.getActivity().hashCode(), ag.this.getFeedData(), this.f82840d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class e implements OnPromiseResolved<com.tencent.biz.qqcircle.comment.animation.a> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f82843a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Integer f82844b;

        e(int i3, Integer num) {
            this.f82843a = i3;
            this.f82844b = num;
        }

        @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onDone(com.tencent.biz.qqcircle.comment.animation.a aVar) {
            QFSCommentReplyAdapter qFSCommentReplyAdapter = (QFSCommentReplyAdapter) aVar.i().getAdapter();
            int size = qFSCommentReplyAdapter.l0().size();
            ag.this.mBlock.m1(this.f82843a, this.f82844b.intValue());
            int i3 = size - 1;
            qFSCommentReplyAdapter.n0(i3);
            qFSCommentReplyAdapter.p0(0, i3);
            if (ag.this.getCommentBlockContainer() != null) {
                ag.this.getCommentBlockContainer().getRecyclerView().scrollToPosition(this.f82843a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class g implements RFWAsyncRichTextView.OnClickAtTextListener {
        g() {
        }

        @Override // com.tencent.richframework.text.rich.RFWAsyncRichTextView.OnClickAtTextListener
        public void onClick(String str) {
            ag.this.handleInputTextClick();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class h implements MultiViewBlock.OnLoadDataDelegate {
        h() {
        }

        @Override // com.tencent.biz.richframework.part.block.MultiViewBlock.OnLoadDataDelegate
        public void onLoadData(LoadInfo loadInfo, Object obj) {
            if (loadInfo.isLoadMoreState()) {
                ag.this.requestCommentList(true);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class j implements BubblePopupWindow.c {
        j() {
        }

        @Override // com.tencent.biz.qqcircle.richframework.widget.menu.BubblePopupWindow.c
        public void onDismiss() {
            ag.this.enableSlide(true);
            ag.this.reportCommentAction(63);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class k implements j.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FeedCloudMeta$StReply f82854a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ FeedCloudMeta$StComment f82855b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f82856c;

        k(FeedCloudMeta$StReply feedCloudMeta$StReply, FeedCloudMeta$StComment feedCloudMeta$StComment, View view) {
            this.f82854a = feedCloudMeta$StReply;
            this.f82855b = feedCloudMeta$StComment;
            this.f82856c = view;
        }

        @Override // com.tencent.biz.qqcircle.j.f
        public void onClick(int i3) {
            if (i3 == j.g.f91370c) {
                com.tencent.biz.qqcircle.utils.s.a(ag.this.getContext(), ag.this.getReplyCopyText(this.f82854a));
            } else if (i3 == j.g.f91372e) {
                ag.this.handleReplyDelete(this.f82854a, this.f82855b);
            } else if (i3 == j.g.f91371d) {
                com.tencent.biz.qqcircle.utils.cg.i(this.f82856c.getContext().hashCode(), ag.this.getFeedData(), this.f82855b, this.f82854a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class l implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ FeedCloudMeta$StComment f82858d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ FeedCloudMeta$StReply f82859e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f82860f;

        l(FeedCloudMeta$StComment feedCloudMeta$StComment, FeedCloudMeta$StReply feedCloudMeta$StReply, int i3) {
            this.f82858d = feedCloudMeta$StComment;
            this.f82859e = feedCloudMeta$StReply;
            this.f82860f = i3;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            ag.this.getCommentBusiness().u(ag.this.getActivity().hashCode(), ag.this.getFeedData(), this.f82858d, this.f82859e, this.f82860f, true);
            BlockContainer blockContainer = ag.this.mBlockContainer;
            ag agVar = ag.this;
            QFSCommentReportHelper.l(blockContainer, agVar.mInfo, this.f82858d, this.f82859e, agVar.getPageId());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class n implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ FeedCloudMeta$StComment f82863d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f82864e;

        n(FeedCloudMeta$StComment feedCloudMeta$StComment, int i3) {
            this.f82863d = feedCloudMeta$StComment;
            this.f82864e = i3;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            ag.this.getCommentBusiness().v(ag.this.getActivity().hashCode(), ag.this.getFeedData(), this.f82863d, this.f82864e, true);
            BlockContainer blockContainer = ag.this.mBlockContainer;
            ag agVar = ag.this;
            QFSCommentReportHelper.e(blockContainer, agVar.mInfo, this.f82863d, agVar.getPageId());
        }
    }

    public ag(@NonNull QFSCommentBlock qFSCommentBlock) {
        this(qFSCommentBlock, new QFSBaseCommentPresenter());
    }

    private void assembleQQVideoParams(@NonNull QFSCommentInputWindowConfig qFSCommentInputWindowConfig) {
        boolean z16;
        QCircleInitBean initBean = getInitBean();
        if (initBean == null) {
            return;
        }
        Serializable businessData = initBean.getBusinessData("enableQQVideoCommentPublicTips");
        if (businessData instanceof Boolean) {
            z16 = ((Boolean) businessData).booleanValue();
        } else {
            z16 = false;
        }
        if (z16) {
            com.tencent.biz.qqcircle.utils.cq cqVar = com.tencent.biz.qqcircle.utils.cq.f92752a;
            if (!cqVar.s(getFeedData())) {
                QLog.e(getTAG(), 1, "[assembleQQVideoParams] enable, but not qzone feed");
                return;
            }
            String n3 = cqVar.n(getFeedData());
            String qQVideoBusinessFeedID = initBean.getQQVideoBusinessFeedID();
            qFSCommentInputWindowConfig.enableShowQQVideoCommentPublicTips = TextUtils.equals(n3, qQVideoBusinessFeedID);
            Serializable businessData2 = initBean.getBusinessData("enableQQVideoCommentPublicTipsContent");
            if (businessData2 instanceof String) {
                qFSCommentInputWindowConfig.qqVideoCommentPublicTipsContent = (String) businessData2;
            }
            QLog.d(getTAG(), 1, "[assembleQQVideoParams] qzoneFeedIdFromInitBean=" + qQVideoBusinessFeedID + ", qzoneFeedIdFromStFeed=" + n3);
        }
    }

    private void clearKeyBoardListener() {
        com.tencent.biz.qqcircle.widgets.comment.f fVar = this.mKeyBoardHelper;
        if (fVar != null) {
            fVar.r();
            this.mKeyBoardHelper = null;
        }
    }

    private void closeFullScreenActivityIfNeed() {
        if (!isFullScreenComment()) {
            return;
        }
        SimpleEventBus.getInstance().dispatchEvent(new QFSFullScreenCloseEvent(com.tencent.biz.qqcircle.utils.bj.g(getFeedData()), true));
    }

    private void doOnAddCommentOrReplyFail(QCircleCommentUpdateEvent qCircleCommentUpdateEvent) {
        if (this.mBlock.getDataList() != null && qCircleCommentUpdateEvent.comment != null) {
            Iterator<QFSCommentItemInfo> it = this.mBlock.getDataList().iterator();
            while (it.hasNext()) {
                FeedCloudMeta$StComment feedCloudMeta$StComment = it.next().comment;
                if (feedCloudMeta$StComment != null && feedCloudMeta$StComment.f398447id.get().equals(qCircleCommentUpdateEvent.comment.f398447id.get())) {
                    this.mCurrentShowCommentAndReplyCount--;
                    return;
                }
            }
        }
    }

    private void doOnLoadMoreCommentList(QCircleCommentUpdateEvent qCircleCommentUpdateEvent) {
        List<FeedCloudMeta$StComment> list = qCircleCommentUpdateEvent.commentList;
        if (list != null) {
            Iterator<FeedCloudMeta$StComment> it = list.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                i3 += it.next().replyCount.get() + 1;
            }
            this.mCurrentShowCommentAndReplyCount += i3;
        }
    }

    private void emojiPanelDTReport(boolean z16) {
        VideoReport.setElementId(getContainer(), QCircleDaTongConstant.ElementId.EM_XSJ_EMOTICON_TAB);
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        if (z16) {
            VideoReport.reportEvent("ev_xsj_abnormal_imp", getContainer(), buildElementParams);
        } else {
            VideoReport.reportEvent("ev_xsj_abnormal_clck", getContainer(), buildElementParams);
        }
    }

    private boolean enableShare() {
        FeedCloudMeta$StFeed feedData = getFeedData();
        if (!isFullScreenComment() && feedData.opMask2.get() != null && !feedData.opMask2.get().contains(26) && com.tencent.biz.qqcircle.comment.h.G().R()) {
            return true;
        }
        return false;
    }

    private QQCircleFeedBase$StBusiInfoCommentListData getBusiInfoFromCommentInfo() {
        QFSCommentInfo.ActionBean actionBean;
        QCircleInitBean.QCircleActionBean qCircleActionBean;
        QQCircleFeedBase$StBusiInfoCommentListData qQCircleFeedBase$StBusiInfoCommentListData;
        QFSCommentInfo qFSCommentInfo = this.mInfo;
        if (qFSCommentInfo != null && (actionBean = qFSCommentInfo.mActionBean) != null && (qCircleActionBean = actionBean.mCommentInitBeanActionBean) != null && (qQCircleFeedBase$StBusiInfoCommentListData = qCircleActionBean.mBusiInfoCommentListDataFromCommentInfo) != null) {
            return qQCircleFeedBase$StBusiInfoCommentListData;
        }
        return null;
    }

    private String getCommentCopyContent(FeedCloudMeta$StComment feedCloudMeta$StComment) {
        if (feedCloudMeta$StComment == null) {
            return "";
        }
        String str = feedCloudMeta$StComment.content.get();
        if (!TextUtils.isEmpty(feedCloudMeta$StComment.expressionInfo.expressionURL.get())) {
            str = str + getContext().getString(R.string.f182983hy);
        } else if (!TextUtils.isEmpty(feedCloudMeta$StComment.commentFeed.pic.picUrl.get())) {
            str = str + getContext().getString(R.string.f185473oo);
        } else if (!TextUtils.isEmpty(feedCloudMeta$StComment.commentPic.picUrl.get())) {
            str = str + getContext().getString(R.string.f184253ld);
        }
        return RichTextClickableImageSpanParser.change2TipsText(QzoneEmotionUtils.emCodesToQQcodes(str), 0, " [\u5546\u54c1\u94fe\u63a5]");
    }

    private String getCommentPicPreloadId() {
        if (getFeedData() == null) {
            return "";
        }
        return getFeedData().f398449id.get();
    }

    private static String getItemTopAnimationCommentId(QFSCommentInfo qFSCommentInfo, QCircleInitBean qCircleInitBean) {
        QFSCommentInfo.ActionBean actionBean;
        QCircleInitBean.QCircleActionBean qCircleActionBean;
        if (qFSCommentInfo != null && (actionBean = qFSCommentInfo.mActionBean) != null && (qCircleActionBean = actionBean.mCommentInitBeanActionBean) != null && !TextUtils.isEmpty(qCircleActionBean.mItemTopAnimationCommentId)) {
            return qFSCommentInfo.mActionBean.mCommentInitBeanActionBean.mItemTopAnimationCommentId;
        }
        if (qCircleInitBean != null && qCircleInitBean.getActionBean() != null && !TextUtils.isEmpty(qCircleInitBean.getActionBean().mItemTopAnimationCommentId)) {
            return qCircleInitBean.getActionBean().mItemTopAnimationCommentId;
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getReplyCopyText(FeedCloudMeta$StReply feedCloudMeta$StReply) {
        if (feedCloudMeta$StReply == null) {
            return "";
        }
        String str = feedCloudMeta$StReply.content.get();
        if (!TextUtils.isEmpty(feedCloudMeta$StReply.expressionInfo.expressionURL.get())) {
            str = str + getContext().getString(R.string.f182983hy);
        } else if (!TextUtils.isEmpty(feedCloudMeta$StReply.replyFeed.pic.picUrl.get())) {
            str = str + getContext().getString(R.string.f185473oo);
        } else if (!TextUtils.isEmpty(feedCloudMeta$StReply.replyPic.picUrl.get())) {
            str = str + getContext().getString(R.string.f184253ld);
        }
        return QzoneEmotionUtils.emCodesToQQcodes(str);
    }

    private void handleAddComment(QCircleCommentUpdateEvent qCircleCommentUpdateEvent) {
        QCircleAvatarDecorateManager.INSTANCE.reset();
        if (!qCircleCommentUpdateEvent.feedId.equals(getFeedData().f398449id.get())) {
            return;
        }
        if (qCircleCommentUpdateEvent.comment != null) {
            if (useNewCommentItemView()) {
                this.mCommentBlockViewModel.t2(qCircleCommentUpdateEvent.fakeCommentId, qCircleCommentUpdateEvent.comment);
            } else {
                this.mBlock.r1(qCircleCommentUpdateEvent.fakeCommentId, qCircleCommentUpdateEvent.comment);
            }
        }
        showAddCommentToast(qCircleCommentUpdateEvent.isFeedOwner);
        updateCommentNum(qCircleCommentUpdateEvent.commentTotalNum);
    }

    private void handleAddCommentFail(QCircleCommentUpdateEvent qCircleCommentUpdateEvent) {
        if (!qCircleCommentUpdateEvent.feedId.equals(getFeedData().f398449id.get())) {
            return;
        }
        if (useNewCommentItemView()) {
            this.mCommentBlockViewModel.U1(qCircleCommentUpdateEvent.comment.f398447id.get());
        } else {
            this.mBlock.b1(qCircleCommentUpdateEvent.comment.f398447id.get());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleAddFakeComment(FeedCloudMeta$StComment feedCloudMeta$StComment, int i3, o20.d dVar) {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        if (dVar != null) {
            dVar.f421802j = !TextUtils.equals(feedCloudMeta$StComment.content.get(), dVar.f421800h) ? 1 : 0;
        }
        if (dVar != null) {
            feedCloudMeta$StFeed = dVar.f421797e;
        } else {
            feedCloudMeta$StFeed = new FeedCloudMeta$StFeed();
        }
        com.tencent.biz.qqcircle.comment.effect.d handleCommentOrReplyAdded = handleCommentOrReplyAdded(feedCloudMeta$StComment, null, feedCloudMeta$StFeed);
        if (useNewCommentItemView()) {
            this.mCommentBlockViewModel.N1(feedCloudMeta$StComment, handleCommentOrReplyAdded);
        } else {
            this.mBlock.t0(feedCloudMeta$StComment, handleCommentOrReplyAdded);
        }
        updateListEmptyTextView();
        QFSCommentReportHelper.w(getContainer(), feedCloudMeta$StComment, this.mInfo, i3, this.mSendPreActionType, getPageId(), getParentPageId(), dVar);
    }

    private void handleAddFakeCommentOrReplyEvent(QFSAddFakeCommentOrReplyEvent qFSAddFakeCommentOrReplyEvent) {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        QFSCommentInfo qFSCommentInfo = this.mInfo;
        if (qFSCommentInfo != null && (feedCloudMeta$StFeed = qFSCommentInfo.mFeed) != null && TextUtils.equals(feedCloudMeta$StFeed.f398449id.get(), qFSAddFakeCommentOrReplyEvent.getFeedId())) {
            if (qFSAddFakeCommentOrReplyEvent.getType() == 1) {
                handleAddFakeComment(qFSAddFakeCommentOrReplyEvent.getComment(), 100, null);
            } else if (qFSAddFakeCommentOrReplyEvent.getType() == 2) {
                handleAddFakeReply(qFSAddFakeCommentOrReplyEvent.getReply(), qFSAddFakeCommentOrReplyEvent.getComment(), qFSAddFakeCommentOrReplyEvent.targetReply, 100, null, qFSAddFakeCommentOrReplyEvent.getFrom(), qFSAddFakeCommentOrReplyEvent.getDtPageId());
            }
        }
    }

    private void handleAddFakeReply(FeedCloudMeta$StReply feedCloudMeta$StReply, FeedCloudMeta$StComment feedCloudMeta$StComment, FeedCloudMeta$StReply feedCloudMeta$StReply2, int i3, o20.d dVar, int i16, String str) {
        if (feedCloudMeta$StComment == null) {
            return;
        }
        handleFastReplyPanel(feedCloudMeta$StComment, i16);
        String str2 = feedCloudMeta$StComment.f398447id.get();
        String str3 = feedCloudMeta$StReply2 != null ? feedCloudMeta$StReply2.f398460id.get() : "";
        int f16 = this.mCommentPresenter.f(this.mBlockContainer, str2, str3);
        com.tencent.biz.qqcircle.comment.effect.d handleCommentOrReplyAdded = handleCommentOrReplyAdded(null, feedCloudMeta$StReply, dVar != null ? dVar.f421797e : new FeedCloudMeta$StFeed());
        if (useNewCommentItemView()) {
            this.mCommentBlockViewModel.O1(str2, str3, feedCloudMeta$StReply, handleCommentOrReplyAdded);
        } else {
            this.mBlock.u0(str2, str3, feedCloudMeta$StReply, handleCommentOrReplyAdded);
        }
        if (f16 != -1 && getCommentBlockContainer() != null) {
            getCommentBlockContainer().getRecyclerView().scrollBy(0, f16);
        }
        if (dVar != null) {
            dVar.f421802j = !TextUtils.equals(feedCloudMeta$StReply.content.get(), dVar.f421800h) ? 1 : 0;
        }
        QFSCommentReportHelper.x(getContainer(), feedCloudMeta$StReply, this.mInfo, feedCloudMeta$StComment, feedCloudMeta$StReply2, i3, this.mSendPreActionType, getPageId(), getParentPageId(), dVar, str);
    }

    private void handleAddReply(QCircleCommentUpdateEvent qCircleCommentUpdateEvent) {
        if (!qCircleCommentUpdateEvent.feedId.equals(getFeedData().f398449id.get())) {
            return;
        }
        FeedCloudMeta$StComment feedCloudMeta$StComment = qCircleCommentUpdateEvent.comment;
        if (feedCloudMeta$StComment != null && qCircleCommentUpdateEvent.reply != null) {
            this.mBlock.s1(feedCloudMeta$StComment.f398447id.get(), qCircleCommentUpdateEvent.fakeReplyId, qCircleCommentUpdateEvent.reply);
        }
        updateCommentNum(qCircleCommentUpdateEvent.commentTotalNum);
    }

    private void handleAddReplyFail(QCircleCommentUpdateEvent qCircleCommentUpdateEvent) {
        if (!qCircleCommentUpdateEvent.feedId.equals(getFeedData().f398449id.get())) {
            return;
        }
        if (useNewCommentItemView()) {
            this.mCommentBlockViewModel.W1(qCircleCommentUpdateEvent.comment.f398447id.get(), qCircleCommentUpdateEvent.reply.f398460id.get());
        } else {
            this.mBlock.c1(qCircleCommentUpdateEvent.comment.f398447id.get(), qCircleCommentUpdateEvent.reply.f398460id.get());
        }
    }

    private void handleCancelStickyComment(QCircleCommentUpdateEvent qCircleCommentUpdateEvent) {
        if (qCircleCommentUpdateEvent.feedId.equals(getFeedData().f398449id.get()) && qCircleCommentUpdateEvent.comment != null) {
            if (useNewCommentItemView()) {
                this.mCommentBlockViewModel.Q1(qCircleCommentUpdateEvent.comment.f398447id.get());
            } else {
                this.mBlock.v0(qCircleCommentUpdateEvent.comment.f398447id.get());
            }
        }
    }

    private void handleCommentCancelSticky(FeedCloudMeta$StComment feedCloudMeta$StComment) {
        if (feedCloudMeta$StComment == null) {
            QLog.e(getTAG(), 1, "[handleCommentCancelSticky] comment == null");
            return;
        }
        reportCommentAction(49);
        QCircleCustomDialog.P(getContext(), getContext().getResources().getString(R.string.f181753em), null, R.string.cancel, R.string.f170648xe, new a(feedCloudMeta$StComment), new b()).show();
    }

    private void handleCommentDelete(FeedCloudMeta$StComment feedCloudMeta$StComment) {
        int i3;
        if (feedCloudMeta$StComment == null) {
            QLog.e(getTAG(), 1, "[handleCommentDelete] commentData == null");
            return;
        }
        reportCommentAction(47);
        if (QCirclePluginUtil.isOwner(feedCloudMeta$StComment.postUser.get())) {
            i3 = 0;
        } else {
            i3 = 2;
        }
        QCircleCustomDialog.P(getContext(), getContext().getResources().getString(R.string.f181823et), null, R.string.cancel, R.string.f170648xe, new n(feedCloudMeta$StComment, i3), new o()).show();
    }

    private void handleCommentHintTextEvent(QFSCommentHintTextEvent qFSCommentHintTextEvent) {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        QFSCommentInfo qFSCommentInfo = this.mInfo;
        if (qFSCommentInfo != null && (feedCloudMeta$StFeed = qFSCommentInfo.mFeed) != null && TextUtils.equals(feedCloudMeta$StFeed.f398449id.get(), qFSCommentHintTextEvent.getFeedId())) {
            initTextInputView();
        }
    }

    private void handleCommentPicEvent(WinkVideoCommentCompleteEvent winkVideoCommentCompleteEvent, QFSCommentPublishFeedDraftBean qFSCommentPublishFeedDraftBean, FeedCloudMeta$StComment feedCloudMeta$StComment, FeedCloudMeta$StReply feedCloudMeta$StReply) {
        if (winkVideoCommentCompleteEvent != null && winkVideoCommentCompleteEvent.params != null && qFSCommentPublishFeedDraftBean != null && getActivity() != null && qFSCommentPublishFeedDraftBean.getHostPartHashcode() == getActivity().hashCode()) {
            String str = winkVideoCommentCompleteEvent.params.get(QQWinkConstants.WINK_PUBLISH_PARAM_COVER_PATH);
            String str2 = winkVideoCommentCompleteEvent.params.get(QQWinkConstants.WINK_PUBLISH_PARAM_WIDTH);
            String str3 = winkVideoCommentCompleteEvent.params.get(QQWinkConstants.WINK_PUBLISH_PARAM_HEIGHT);
            QFSCommentInputWindowConfig qFSCommentInputWindowConfig = new QFSCommentInputWindowConfig();
            qFSCommentInputWindowConfig.commentPicPath = str;
            if (str3 != null && str2 != null) {
                qFSCommentInputWindowConfig.commentPicWidth = Integer.parseInt(str2);
                qFSCommentInputWindowConfig.commentPicHeight = Integer.parseInt(str3);
            }
            qFSCommentInputWindowConfig.isShowPostBtn = !TextUtils.isEmpty(str);
            QLog.d(TAG, 1, "[handlePicCommentEvent] imagePath: " + str + ", isShow: " + showInputWindowWithPic(feedCloudMeta$StComment, feedCloudMeta$StReply, qFSCommentInputWindowConfig) + ", width: " + str2 + ", height: " + str3);
        }
    }

    private void handleCommentSticky(FeedCloudMeta$StComment feedCloudMeta$StComment) {
        if (feedCloudMeta$StComment == null) {
            QLog.e(getTAG(), 1, "[handleCommentSticky] commentData == null");
            return;
        }
        reportCommentAction(48);
        if (getCommentBusiness().U(getFeedData(), feedCloudMeta$StComment)) {
            QCircleCustomDialog.P(getContext(), getContext().getResources().getString(R.string.f184713mm), null, R.string.cancel, R.string.f170648xe, new c(feedCloudMeta$StComment), new d()).show();
        } else {
            getCommentBusiness().f0(getActivity().hashCode(), getFeedData(), feedCloudMeta$StComment);
        }
    }

    private void handleDeleteComment(QCircleCommentUpdateEvent qCircleCommentUpdateEvent) {
        if (!qCircleCommentUpdateEvent.feedId.equals(getFeedData().f398449id.get())) {
            return;
        }
        if (qCircleCommentUpdateEvent.comment != null) {
            if (useNewCommentItemView()) {
                this.mCommentBlockViewModel.U1(qCircleCommentUpdateEvent.comment.f398447id.get());
            }
            this.mBlock.b1(qCircleCommentUpdateEvent.comment.f398447id.get());
        }
        updateCommentNum(qCircleCommentUpdateEvent.commentTotalNum);
        updateListEmptyTextView();
    }

    private void handleDeleteReply(QCircleCommentUpdateEvent qCircleCommentUpdateEvent) {
        if (!qCircleCommentUpdateEvent.feedId.equals(getFeedData().f398449id.get())) {
            return;
        }
        if (qCircleCommentUpdateEvent.comment != null && qCircleCommentUpdateEvent.reply != null) {
            if (useNewCommentItemView()) {
                this.mCommentBlockViewModel.W1(qCircleCommentUpdateEvent.comment.f398447id.get(), qCircleCommentUpdateEvent.reply.f398460id.get());
            }
            this.mBlock.c1(qCircleCommentUpdateEvent.comment.f398447id.get(), qCircleCommentUpdateEvent.reply.f398460id.get());
        }
        updateCommentNum(qCircleCommentUpdateEvent.commentTotalNum);
    }

    private void handleEventByStatus(QCircleCommentUpdateEvent qCircleCommentUpdateEvent) {
        switch (qCircleCommentUpdateEvent.eventStatus) {
            case 1:
                handleGetCommentList(qCircleCommentUpdateEvent);
                return;
            case 2:
                handleLoadMoreCommentList(qCircleCommentUpdateEvent);
                return;
            case 3:
                handleAddComment(qCircleCommentUpdateEvent);
                return;
            case 4:
                handleDeleteComment(qCircleCommentUpdateEvent);
                return;
            case 5:
                handleAddReply(qCircleCommentUpdateEvent);
                return;
            case 6:
                handleDeleteReply(qCircleCommentUpdateEvent);
                return;
            case 7:
                handleStickyComment(qCircleCommentUpdateEvent);
                return;
            case 8:
                handleCancelStickyComment(qCircleCommentUpdateEvent);
                return;
            case 9:
                handleAddCommentFail(qCircleCommentUpdateEvent);
                return;
            case 10:
                handleAddReplyFail(qCircleCommentUpdateEvent);
                return;
            case 11:
                handleGetCommentListFail(qCircleCommentUpdateEvent);
                return;
            default:
                return;
        }
    }

    private void handleFastReplyPanel(FeedCloudMeta$StComment feedCloudMeta$StComment, int i3) {
        if (feedCloudMeta$StComment == null) {
            return;
        }
        if (i3 != 19) {
            if (i3 == 20) {
                this.mInfo.mCmtPanelSource = 13;
            }
        } else {
            com.tencent.biz.qqcircle.comment.af.O();
            this.mInfo.mCmtPanelSource = 13;
        }
        if (com.tencent.biz.qqcircle.comment.af.y(feedCloudMeta$StComment)) {
            com.tencent.biz.qqcircle.comment.af.I(true);
        }
    }

    private void handleGetCommentListFail(QCircleCommentUpdateEvent qCircleCommentUpdateEvent) {
        if (!qCircleCommentUpdateEvent.feedId.equals(getRealCellId())) {
            return;
        }
        setLoadingStatus(false);
        this.mBlock.notifyLoadingComplete(false);
        updateListEmptyTextView(com.tencent.biz.qqcircle.f.H());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleInputTextClick() {
        showCommentInputWindow();
        reportCommentAction(60);
        this.mSendPreActionType = 60;
    }

    private void handleLoadMoreCommentList(QCircleCommentUpdateEvent qCircleCommentUpdateEvent) {
        boolean z16;
        if (qCircleCommentUpdateEvent.feedId.equals(getRealCellId()) && qCircleCommentUpdateEvent.commentList != null) {
            if (useNewCommentItemView()) {
                int commentSize = getCommentSize();
                this.mCommentBlockViewModel.g2().setValue(Boolean.valueOf(getCommentBusiness().S(getRealCellId())));
                this.mCommentBlockViewModel.M1(true, commentSize, qCircleCommentUpdateEvent.commentList);
            } else {
                this.mBlock.addData(qCircleCommentUpdateEvent.commentList);
                LoadInfo loadInfo = this.mBlock.getLoadInfo();
                if (getCommentBusiness().A(getFeedData().f398449id.get()) == null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                loadInfo.setFinish(z16);
                this.mBlock.notifyLoadingComplete(true);
            }
            onReceiveEventUpdateHintText(qCircleCommentUpdateEvent.tailText);
            insertFakePublishFeedDraft(qCircleCommentUpdateEvent.commentList, false);
            updateCommentNum(getCommentBusiness().I(getFeedData()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleReplyDelete(FeedCloudMeta$StReply feedCloudMeta$StReply, FeedCloudMeta$StComment feedCloudMeta$StComment) {
        int i3;
        if (feedCloudMeta$StReply == null) {
            QLog.e(getTAG(), 1, "[handleReplyDelete] replyData == null");
            return;
        }
        if (feedCloudMeta$StComment == null) {
            QLog.e(getTAG(), 1, "[handleReplyDelete] commentData == null");
            return;
        }
        if (QCirclePluginUtil.isOwner(feedCloudMeta$StReply.postUser.get())) {
            i3 = 0;
        } else {
            i3 = 2;
        }
        QCircleCustomDialog.P(getContext(), getContext().getResources().getString(R.string.f184723mn), null, R.string.cancel, R.string.f170648xe, new l(feedCloudMeta$StComment, feedCloudMeta$StReply, i3), new m()).show();
    }

    private void handleSharePanelClickEvent(QFSCommentOrReplySharePanelClickEvent qFSCommentOrReplySharePanelClickEvent) {
        if (!qFSCommentOrReplySharePanelClickEvent.feedId.equals(getRealCellId())) {
            return;
        }
        if (qFSCommentOrReplySharePanelClickEvent.contextHashCode != getContextHashCode()) {
            QLog.e(getTAG(), 1, "[handleSharePanelClickEvent] contextHashCode not equal");
            return;
        }
        int i3 = qFSCommentOrReplySharePanelClickEvent.clickType;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 4) {
                        handleReplyDelete(qFSCommentOrReplySharePanelClickEvent.reply, qFSCommentOrReplySharePanelClickEvent.comment);
                        return;
                    }
                    return;
                }
                handleCommentDelete(qFSCommentOrReplySharePanelClickEvent.comment);
                return;
            }
            handleCommentCancelSticky(qFSCommentOrReplySharePanelClickEvent.comment);
            return;
        }
        handleCommentSticky(qFSCommentOrReplySharePanelClickEvent.comment);
    }

    private void handleStickyComment(QCircleCommentUpdateEvent qCircleCommentUpdateEvent) {
        if (qCircleCommentUpdateEvent.feedId.equals(getFeedData().f398449id.get()) && qCircleCommentUpdateEvent.comment != null) {
            if (useNewCommentItemView()) {
                this.mCommentBlockViewModel.r2(qCircleCommentUpdateEvent.comment.f398447id.get());
            } else {
                this.mBlock.p1(qCircleCommentUpdateEvent.comment.f398447id.get());
            }
        }
    }

    private void handleWinkVideoCommentComplete(WinkVideoCommentCompleteEvent winkVideoCommentCompleteEvent) {
        String str;
        HashMap<String, String> hashMap = winkVideoCommentCompleteEvent.params;
        if (hashMap != null && !hashMap.isEmpty()) {
            if (QFSCommentHelper.L().K() != null) {
                QLog.d(getTAG(), 1, "[handleWinkEvent] has already show input window. ");
                return;
            }
            QFSCommentPublishFeedAttrBean attrBean = QFSCommentPublishFeedAttrBean.getAttrBean(hashMap);
            QLog.d(getTAG(), 1, "[handleWinkEvent] " + attrBean.toString());
            if (getFeedData() == null) {
                str = "";
            } else {
                str = getFeedData().f398449id.get();
            }
            if (!TextUtils.isEmpty(attrBean.feedId) && TextUtils.equals(attrBean.feedId, str)) {
                QFSCommentPublishFeedDraftBean N = QFSCommentHelper.L().N(attrBean.draftId);
                if (N == null) {
                    QLog.e(getTAG(), 1, "[handleWinkEvent] draftBean == null");
                    return;
                }
                QFSFeedCommentInfo feedCommentInfo = N.getFeedCommentInfo();
                if (feedCommentInfo == null) {
                    QLog.e(getTAG(), 1, "[handleWinkEvent] feedCommentInfo == null");
                    return;
                }
                FeedCloudMeta$StFeed feedCloudMeta$StFeed = feedCommentInfo.mFeed;
                if (feedCloudMeta$StFeed == null) {
                    QLog.e(getTAG(), 1, "[handleWinkEvent] targetFeed == null");
                    return;
                }
                FeedCloudMeta$StReply feedCloudMeta$StReply = feedCommentInfo.mReply;
                FeedCloudMeta$StComment feedCloudMeta$StComment = feedCommentInfo.mComment;
                int postType = N.getPostType();
                String str2 = hashMap.get("taskid");
                if (!TextUtils.equals(str2, "comment") && !TextUtils.equals(str2, "comment_reply")) {
                    FeedCloudMeta$StUser m3 = QCirclePluginGlobalInfo.m();
                    FeedCloudMeta$StFeedAbstract feedCloudMeta$StFeedAbstract = new FeedCloudMeta$StFeedAbstract();
                    if (!TextUtils.isEmpty(attrBean.coverPath)) {
                        FeedCloudMeta$StImage feedCloudMeta$StImage = new FeedCloudMeta$StImage();
                        feedCloudMeta$StImage.picUrl.set(attrBean.coverPath);
                        feedCloudMeta$StFeedAbstract.pic.set(feedCloudMeta$StImage);
                        feedCloudMeta$StFeedAbstract.type.set(attrBean.publishType);
                        feedCloudMeta$StFeedAbstract.poster.set(m3);
                    }
                    if (postType == 1) {
                        FeedCloudMeta$StComment feedCloudMeta$StComment2 = new FeedCloudMeta$StComment();
                        feedCloudMeta$StComment2.f398447id.set(QFSCommentHelper.H());
                        feedCloudMeta$StComment2.content.set(attrBean.publishContent);
                        feedCloudMeta$StComment2.createTime.set((int) (System.currentTimeMillis() / 1000));
                        if (QCircleHostGlobalInfo.getStUserInfo() != null) {
                            m3.iconDecorate.set(QCircleHostGlobalInfo.getStUserInfo().iconDecorate.get());
                        }
                        feedCloudMeta$StComment2.postUser.set(m3);
                        feedCloudMeta$StComment2.commentFeed.set(feedCloudMeta$StFeedAbstract);
                        N.setFakeComment(feedCloudMeta$StComment2);
                        QFSCommentHelper.L().m(feedCloudMeta$StComment2.f398447id.get(), attrBean.taskId);
                        handleAddFakeComment(feedCloudMeta$StComment2, 100, null);
                        SimpleEventBus.getInstance().dispatchEvent(new QFSFakeCommentSendEvent(feedCloudMeta$StFeed, feedCloudMeta$StComment2));
                    } else if (postType == 2 || postType == 3) {
                        FeedCloudMeta$StReply feedCloudMeta$StReply2 = new FeedCloudMeta$StReply();
                        feedCloudMeta$StReply2.f398460id.set(QFSCommentHelper.H());
                        feedCloudMeta$StReply2.content.set(attrBean.publishContent);
                        feedCloudMeta$StReply2.createTime.set((int) (System.currentTimeMillis() / 1000));
                        feedCloudMeta$StReply2.postUser.set(QCirclePluginGlobalInfo.m());
                        feedCloudMeta$StReply2.replyFeed.set(feedCloudMeta$StFeedAbstract);
                        if (feedCloudMeta$StReply != null && !TextUtils.isEmpty(feedCloudMeta$StReply.postUser.f398463id.get())) {
                            feedCloudMeta$StReply2.targetUser.set(feedCloudMeta$StReply.postUser.get());
                            feedCloudMeta$StReply2.targetReplyID.set(feedCloudMeta$StReply.f398460id.get());
                        }
                        N.setFakeReply(feedCloudMeta$StReply2);
                        QFSCommentHelper.L().m(feedCloudMeta$StReply2.f398460id.get(), attrBean.taskId);
                        handleAddFakeReply(feedCloudMeta$StReply2, feedCloudMeta$StComment, feedCloudMeta$StReply, 100, null, 0);
                    }
                    SimpleEventBus.getInstance().dispatchEvent(new QFSCommentSendEvent(feedCloudMeta$StFeed));
                    return;
                }
                QLog.d(getTAG(), 1, "[handleWinkEvent] isFrom commentPic");
                handleCommentPicEvent(winkVideoCommentCompleteEvent, N, feedCloudMeta$StComment, feedCloudMeta$StReply);
                return;
            }
            QLog.e(getTAG(), 1, "[handleWinkEvent] curFeedId = " + str);
            return;
        }
        QLog.e(getTAG(), 1, "[handleWinkEvent] params == null or empty");
    }

    private void initConfigReportBean(QFSCommentInputWindowConfig qFSCommentInputWindowConfig) {
        String str;
        QCircleReportBean qCircleReportBean = this.mInfo.mReportBean;
        if (qCircleReportBean == null) {
            qCircleReportBean = getReportBean();
        }
        if (qCircleReportBean == null) {
            qCircleReportBean = new QCircleReportBean();
        }
        FeedCloudMeta$StFeed feedData = getFeedData();
        if (feedData != null) {
            str = feedData.f398449id.get();
        } else {
            str = "";
        }
        qCircleReportBean.setFeedId(str);
        qFSCommentInputWindowConfig.reportBean = qCircleReportBean;
    }

    private void insertFakePublishFeedDraft(List<FeedCloudMeta$StComment> list, boolean z16) {
        if (uq3.c.n()) {
            Iterator<QFSCommentPublishFeedDraftBean> O = QFSCommentHelper.L().O();
            if (O == null) {
                QLog.e(getTAG(), 1, "[insertFakePublishFeedDraft] draftBeanIterator == null");
            } else {
                while (O.hasNext()) {
                    insertFakePublishFeedDraft(list, O.next(), z16);
                }
            }
        }
    }

    private void insertFakePublishFeedDraftWhenRefresh(List<FeedCloudMeta$StComment> list) {
        FeedCloudMeta$StComment feedCloudMeta$StComment;
        if (!uq3.c.n()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                if (list.get(i3) == null) {
                    feedCloudMeta$StComment = null;
                } else {
                    feedCloudMeta$StComment = list.get(i3);
                }
                if (feedCloudMeta$StComment != null) {
                    arrayList.add(feedCloudMeta$StComment);
                }
            }
        }
        insertFakePublishFeedDraft(arrayList, true);
    }

    private boolean isFromPersonalDetailPage() {
        QCircleInitBean qCircleInitBean = QCirclePluginUtil.getQCircleInitBean(getContext());
        if (qCircleInitBean != null && "qfs_personal_tab_all".equals(qCircleInitBean.getLaunchFrom())) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onPartResume$0(WinkVideoCommentCompleteEvent[] winkVideoCommentCompleteEventArr) {
        handleWinkVideoCommentComplete(winkVideoCommentCompleteEventArr[0]);
        PreLoader.remove(getCommentPicPreloadId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showEmojiPopupMenu$1(String str, String str2, int i3, int i16) {
        if (i16 == j.g.f91373f) {
            new QFSCommentEmojiOperationManager(str, getContext()).e();
        } else if (i16 == j.g.f91374g) {
            new QFSCommentEmojiOperationManager(str2, getContext()).f(getActivity());
        }
        QFSCommentReportHelper.h(i3, i16, getDtPageId());
    }

    private void onAtNicknameClick(Object obj) {
        int i3;
        if (obj instanceof QCircleInitBean) {
            QCircleInitBean qCircleInitBean = (QCircleInitBean) obj;
            if (!isFullScreenComment() && com.tencent.biz.qqcircle.comment.af.o()) {
                FeedCloudMeta$StFeed feedCloudMeta$StFeed = new FeedCloudMeta$StFeed();
                FeedCloudMeta$StUser feedCloudMeta$StUser = new FeedCloudMeta$StUser();
                feedCloudMeta$StUser.f398463id.set(qCircleInitBean.getUin());
                feedCloudMeta$StFeed.poster.set(feedCloudMeta$StUser);
                Context context = getContext();
                if (context != null) {
                    i3 = context.hashCode();
                } else {
                    i3 = 0;
                }
                QFSShowPersonalPanelEvent qFSShowPersonalPanelEvent = new QFSShowPersonalPanelEvent(feedCloudMeta$StFeed, true, i3);
                qFSShowPersonalPanelEvent.setPanelModel(2);
                qFSShowPersonalPanelEvent.setNeedMaskView(true);
                SimpleEventBus.getInstance().dispatchEvent(qFSShowPersonalPanelEvent);
                return;
            }
            qCircleInitBean.setStartNewIntent(startNewPersonPage());
            com.tencent.biz.qqcircle.launcher.c.d0(getContext(), qCircleInitBean);
        }
    }

    private void onAvatarClick(View view, Object obj) {
        FeedCloudMeta$StUser feedCloudMeta$StUser;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        if (obj instanceof FeedCloudMeta$StUser) {
            feedCloudMeta$StUser = (FeedCloudMeta$StUser) obj;
        } else {
            feedCloudMeta$StUser = null;
        }
        if (feedCloudMeta$StUser != null && view != null) {
            if ((view.getTag(-3) instanceof Boolean) && ((Boolean) view.getTag(-3)).booleanValue()) {
                com.tencent.biz.qqcircle.helpers.e.f84616a.e(view, feedCloudMeta$StUser, String.valueOf(13));
            } else {
                if (view.getTag(-4) instanceof FeedCloudMeta$StFeed) {
                    feedCloudMeta$StFeed = (FeedCloudMeta$StFeed) view.getTag(-4);
                } else {
                    feedCloudMeta$StFeed = null;
                }
                view.setTag(-4, null);
                this.mCommentPresenter.q(getContext(), (FeedCloudMeta$StUser) obj, getReportBean(), !(this instanceof QFSNewContentDetailBodyCommentPart), startNewPersonPage(), feedCloudMeta$StFeed);
            }
            reportCommentAction(14);
        }
    }

    private void onCommentCancelPraiseClick(Object obj) {
        reportCommentAction(51);
        QFSCommentReportHelper.f(getContainer(), this.mInfo, obj, true, getPageId());
    }

    private void onCommentFeedFeedback(int i3, Object obj) {
        if (!(obj instanceof FeedCloudMeta$StComment)) {
            return;
        }
        FeedCloudMeta$StComment feedCloudMeta$StComment = (FeedCloudMeta$StComment) obj;
        this.mBlock.b1(feedCloudMeta$StComment.f398447id.get());
        getCommentBusiness().t(getFeedData().f398449id.get(), feedCloudMeta$StComment.f398447id.get());
        QFSCommentReportHelper.z(getFeedData(), feedCloudMeta$StComment, i3, getPageId());
    }

    private void onCommentItemClick(View view, Object obj) {
        if ((obj instanceof FeedCloudMeta$StComment) && showInputWindowFromReply((FeedCloudMeta$StComment) obj, null)) {
            scrollItemToVisibleAboveInputLayout(view);
        }
        reportCommentAction(11);
        this.mSendPreActionType = 11;
    }

    private void onCommentLongClick(View view, Object obj, BubblePopupWindow.c cVar) {
        if (obj instanceof FeedCloudMeta$StComment) {
            reportCommentAction(45);
            FeedCloudMeta$StComment feedCloudMeta$StComment = (FeedCloudMeta$StComment) obj;
            QFSCommentHelper.c0(feedCloudMeta$StComment.f398447id.get());
            openCommentSharePanel(feedCloudMeta$StComment, 0);
        }
    }

    private void onCommentPraiseClick(Object obj) {
        reportCommentAction(50);
        QFSCommentReportHelper.f(getContainer(), this.mInfo, obj, false, getPageId());
    }

    private void onEmojiCommentLongClick(View view, Object obj, BubblePopupWindow.c cVar) {
        if (obj instanceof FeedCloudMeta$StComment) {
            FeedCloudMeta$StComment feedCloudMeta$StComment = (FeedCloudMeta$StComment) obj;
            showEmojiPopupMenu(feedCloudMeta$StComment.expressionInfo.expressionURL.get(), "", view, cVar, feedCloudMeta$StComment.expressionInfo.expression_src.get());
        }
    }

    private void onEmojiReplyLongClick(View view, Object obj, BubblePopupWindow.c cVar) {
        Object obj2;
        Object obj3;
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length > 1 && (obj2 = objArr[0]) != null && (obj3 = objArr[1]) != null && (obj2 instanceof FeedCloudMeta$StComment) && (obj3 instanceof FeedCloudMeta$StReply)) {
                FeedCloudMeta$StReply feedCloudMeta$StReply = (FeedCloudMeta$StReply) obj3;
                showEmojiPopupMenu(feedCloudMeta$StReply.expressionInfo.expressionURL.get(), "", view, cVar, feedCloudMeta$StReply.expressionInfo.expression_src.get());
            }
        }
    }

    private void onFastReplyPanelClick(View view, Object obj) {
        if ((obj instanceof FeedCloudMeta$StComment) && showInputWindowFromFastReply((FeedCloudMeta$StComment) obj)) {
            scrollItemToVisibleAboveInputLayout(view);
        }
    }

    private void onLessReplyClick(View view, int i3, Object obj) {
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length > 1 && (objArr[0] instanceof FeedCloudMeta$StComment)) {
                Object obj2 = objArr[1];
                if (obj2 instanceof Integer) {
                    com.tencent.biz.qqcircle.comment.af.u(view, new e(i3, (Integer) obj2));
                }
            }
        }
    }

    private void onMoreReplyClick(View view, int i3, Object obj) {
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length > 1 && (objArr[0] instanceof FeedCloudMeta$StComment)) {
                Object obj2 = objArr[1];
                if (obj2 instanceof Integer) {
                    this.mBlock.n1(view, i3, ((Integer) obj2).intValue());
                }
            }
        }
        reportCommentAction(52);
    }

    private void onNickNameClick(Object obj) {
        if (obj instanceof FeedCloudMeta$StUser) {
            this.mCommentPresenter.q(getContext(), (FeedCloudMeta$StUser) obj, getReportBean(), !(this instanceof QFSNewContentDetailBodyCommentPart), startNewPersonPage(), null);
        }
        reportCommentAction(15);
    }

    private void onPicCommentLongClick(View view, Object obj, BubblePopupWindow.c cVar) {
        if (obj instanceof FeedCloudMeta$StComment) {
            FeedCloudMeta$StComment feedCloudMeta$StComment = (FeedCloudMeta$StComment) obj;
            showEmojiPopupMenu(com.tencent.biz.qqcircle.utils.ct.c(feedCloudMeta$StComment.commentPic), com.tencent.biz.qqcircle.utils.ct.b(feedCloudMeta$StComment.commentPic), view, cVar, 0);
        }
    }

    private void onPicReplyLongClick(View view, Object obj, BubblePopupWindow.c cVar) {
        Object obj2;
        Object obj3;
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length > 1 && (obj2 = objArr[0]) != null && (obj3 = objArr[1]) != null && (obj2 instanceof FeedCloudMeta$StComment) && (obj3 instanceof FeedCloudMeta$StReply)) {
                FeedCloudMeta$StReply feedCloudMeta$StReply = (FeedCloudMeta$StReply) obj3;
                showEmojiPopupMenu(com.tencent.biz.qqcircle.utils.ct.c(feedCloudMeta$StReply.replyPic), com.tencent.biz.qqcircle.utils.ct.b(feedCloudMeta$StReply.replyPic), view, cVar, 0);
            }
        }
    }

    private void onReplyBtnClick(View view, Object obj) {
        if ((obj instanceof FeedCloudMeta$StComment) && showInputWindowFromReply((FeedCloudMeta$StComment) obj, null)) {
            scrollItemToVisibleAboveInputLayout(view);
        }
        reportCommentAction(13);
        this.mSendPreActionType = 13;
    }

    private void onReplyItemClick(View view, Object obj) {
        Object obj2;
        Object obj3;
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length > 1 && (obj2 = objArr[0]) != null && (obj3 = objArr[1]) != null && (obj2 instanceof FeedCloudMeta$StComment) && (obj3 instanceof FeedCloudMeta$StReply) && showInputWindowFromReply((FeedCloudMeta$StComment) obj2, (FeedCloudMeta$StReply) obj3)) {
                scrollItemToVisibleAboveInputLayout(view);
            }
        }
        reportCommentAction(12);
        this.mSendPreActionType = 12;
    }

    private void onReplyLongClick(View view, Object obj, BubblePopupWindow.c cVar) {
        Object obj2;
        Object obj3;
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length > 1 && (obj2 = objArr[0]) != null && (obj3 = objArr[1]) != null && (obj2 instanceof FeedCloudMeta$StComment) && (obj3 instanceof FeedCloudMeta$StReply)) {
                FeedCloudMeta$StComment feedCloudMeta$StComment = (FeedCloudMeta$StComment) obj2;
                FeedCloudMeta$StReply feedCloudMeta$StReply = (FeedCloudMeta$StReply) obj3;
                boolean c06 = QFSCommentHelper.c0(feedCloudMeta$StReply.f398460id.get());
                if (enableShare() && !c06) {
                    openReplySharePanel(new Object[]{feedCloudMeta$StComment, feedCloudMeta$StReply}, 0);
                } else {
                    com.tencent.biz.qqcircle.j.f().k(view, getFeedData(), feedCloudMeta$StReply, new k(feedCloudMeta$StReply, feedCloudMeta$StComment, view), cVar, this.mReportBean);
                    enableSlide(false);
                }
            }
        }
    }

    private void openCommentSharePanel(Object obj, int i3) {
        if (!(obj instanceof FeedCloudMeta$StComment)) {
            return;
        }
        FeedCloudMeta$StComment feedCloudMeta$StComment = (FeedCloudMeta$StComment) obj;
        FeedCloudMeta$StFeed feedData = getFeedData();
        QCircleShareInfo qCircleShareInfo = new QCircleShareInfo();
        qCircleShareInfo.type = 12;
        qCircleShareInfo.feed = feedData;
        feedData.share = new FeedCloudMeta$StShare();
        qCircleShareInfo.mShareTitle = "\u7ba1\u7406\u8bc4\u8bba";
        qCircleShareInfo.source = 8;
        qCircleShareInfo.comment = feedCloudMeta$StComment;
        qCircleShareInfo.copyContent = getCommentCopyContent(feedCloudMeta$StComment);
        HashMap hashMap = new HashMap();
        qCircleShareInfo.mDTReportExtMapOnSendSuccess = hashMap;
        hashMap.put(QCircleDaTongConstant.ElementParamKey.IS_FORM_CMT, Integer.valueOf(i3));
        qCircleShareInfo.shareStyleType = 11;
        qCircleShareInfo.feedBlockData = new e30.b(feedData);
        qCircleShareInfo.contextHashCode = getContextHashCode();
        qCircleShareInfo.isShowCopyContent = true;
        qCircleShareInfo.isShowCopySchemaLink = false;
        if (com.tencent.biz.qqcircle.comment.af.E(feedData, feedCloudMeta$StComment)) {
            qCircleShareInfo.isShowDelete = true;
        }
        if (com.tencent.biz.qqcircle.comment.af.G(feedCloudMeta$StComment)) {
            qCircleShareInfo.isShowReport = true;
        }
        if (com.tencent.biz.qqcircle.comment.af.r(feedCloudMeta$StComment)) {
            qCircleShareInfo.isShowPushRanComment = true;
        }
        getPartManager().broadcastMessage("share_action_show_share_sheet", qCircleShareInfo);
    }

    private void openReplySharePanel(Object obj, int i3) {
        Object obj2;
        Object obj3;
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length > 1 && (obj2 = objArr[0]) != null && (obj3 = objArr[1]) != null && (obj2 instanceof FeedCloudMeta$StComment) && (obj3 instanceof FeedCloudMeta$StReply)) {
                FeedCloudMeta$StReply feedCloudMeta$StReply = (FeedCloudMeta$StReply) obj3;
                FeedCloudMeta$StFeed feedData = getFeedData();
                QCircleShareInfo qCircleShareInfo = new QCircleShareInfo();
                qCircleShareInfo.type = 13;
                qCircleShareInfo.feed = feedData;
                feedData.share = new FeedCloudMeta$StShare();
                qCircleShareInfo.mShareTitle = "\u7ba1\u7406\u8bc4\u8bba";
                qCircleShareInfo.comment = (FeedCloudMeta$StComment) obj2;
                qCircleShareInfo.reply = feedCloudMeta$StReply;
                qCircleShareInfo.copyContent = getReplyCopyText(feedCloudMeta$StReply);
                qCircleShareInfo.source = 8;
                HashMap hashMap = new HashMap();
                qCircleShareInfo.mDTReportExtMapOnSendSuccess = hashMap;
                hashMap.put(QCircleDaTongConstant.ElementParamKey.IS_FORM_CMT, Integer.valueOf(i3));
                qCircleShareInfo.feedBlockData = new e30.b(feedData);
                qCircleShareInfo.shareStyleType = 12;
                qCircleShareInfo.contextHashCode = getContextHashCode();
                qCircleShareInfo.isShowCopyContent = true;
                qCircleShareInfo.isShowCopySchemaLink = false;
                if (com.tencent.biz.qqcircle.comment.af.F(feedData, feedCloudMeta$StReply)) {
                    qCircleShareInfo.isShowDelete = true;
                }
                if (com.tencent.biz.qqcircle.comment.af.H(feedCloudMeta$StReply)) {
                    qCircleShareInfo.isShowReport = true;
                }
                getPartManager().broadcastMessage("share_action_show_share_sheet", qCircleShareInfo);
            }
        }
    }

    private void registerPublishCallback() {
        if (this.mPublishFeedManager == null) {
            this.mPublishFeedManager = new com.tencent.biz.qqcircle.comment.v(getContext(), getInitBean());
        }
        this.mPublishFeedManager.d();
    }

    private void setFeedData(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed == null) {
            return;
        }
        getCommentBusiness().k0(feedCloudMeta$StFeed.f398449id.get(), feedCloudMeta$StFeed.commentCount.get());
    }

    private void showAddCommentToast(boolean z16) {
        boolean z17;
        if (getContainer() != null && getContainer().getVisibility() == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (!z17) {
            if (this.mCurCommentCount == 0 && !z16) {
                com.tencent.biz.qqcircle.immersive.feed.cf.b().d();
                return;
            } else {
                QCircleToast.l(QCircleToast.f91646f, com.tencent.biz.qqcircle.utils.h.a(R.string.f187953vd), 0, true, true);
                return;
            }
        }
        if (this.mCurCommentCount == 0 && !z16) {
            com.tencent.biz.qqcircle.immersive.feed.cf.b().e();
        }
    }

    private void showEmojiPopupMenu(final String str, final String str2, View view, BubblePopupWindow.c cVar, final int i3) {
        boolean z16;
        boolean z17;
        QLog.d(TAG, 1, "[showEmojiPopupMenu] emojiUrl=" + str + ", downloadUrl=" + str2);
        if (MobileQQ.sProcessId != 1) {
            QLog.d(TAG, 1, "[showEmojiPopupMenu] not main process");
            if (cVar != null) {
                cVar.onDismiss();
                return;
            }
            return;
        }
        if (!TextUtils.isEmpty(str2) && HttpUtil.isValidUrl(str2)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!TextUtils.isEmpty(str) && HttpUtil.isValidUrl(str)) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (!z16 && !z17) {
            QLog.d(TAG, 1, "[showEmojiPopupMenu] no need to show");
        } else {
            com.tencent.biz.qqcircle.j.f().i(view, new j.f() { // from class: com.tencent.biz.qqcircle.bizparts.ae
                @Override // com.tencent.biz.qqcircle.j.f
                public final void onClick(int i16) {
                    ag.this.lambda$showEmojiPopupMenu$1(str, str2, i3, i16);
                }
            }, cVar, z16);
            enableSlide(false);
        }
    }

    private boolean startNewPersonPage() {
        if (!isFullScreenComment() && !isFromPersonalDetailPage()) {
            return false;
        }
        return true;
    }

    private void unRegisterPublishCallBack() {
        com.tencent.biz.qqcircle.comment.v vVar = this.mPublishFeedManager;
        if (vVar != null) {
            vVar.e();
        }
    }

    private void updateCurrentShowCommentAndReplyCount(QCircleCommentUpdateEvent qCircleCommentUpdateEvent) {
        if (qCircleCommentUpdateEvent != null) {
            switch (qCircleCommentUpdateEvent.eventStatus) {
                case 1:
                    this.mCurrentShowCommentAndReplyCount = 0;
                    break;
                case 2:
                    break;
                case 3:
                case 5:
                    this.mCurrentShowCommentAndReplyCount++;
                    return;
                case 4:
                case 6:
                    this.mCurrentShowCommentAndReplyCount--;
                    return;
                case 7:
                case 8:
                default:
                    return;
                case 9:
                case 10:
                    doOnAddCommentOrReplyFail(qCircleCommentUpdateEvent);
                    return;
            }
            doOnLoadMoreCommentList(qCircleCommentUpdateEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void adjustKeyboardStateToView(View view) {
        registerKeyboardEvent();
        this.mCommentPresenter.s(getCommentBlockContainer(), view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean checkNotAllowComment() {
        if (!QFSBaseCommentPresenter.o(getContext(), getFeedData()) && !QFSBaseCommentPresenter.m(getFeedData())) {
            return false;
        }
        return true;
    }

    protected boolean enableLoadMore() {
        return true;
    }

    protected QCircleBlockContainer getBlockContainer() {
        return null;
    }

    public QQCircleFeedBase$StBusiInfoCommentListData getBusiInfo() {
        if (this.mBusiInfoCommentListDataFromInitBean == null) {
            QQCircleFeedBase$StBusiInfoCommentListData busiInfoFromCommentInfo = getBusiInfoFromCommentInfo();
            if (busiInfoFromCommentInfo != null) {
                this.mBusiInfoCommentListDataFromInitBean = busiInfoFromCommentInfo;
            } else if (this.mCommentPresenter.c(getInitBean()) != null) {
                this.mBusiInfoCommentListDataFromInitBean = this.mCommentPresenter.c(getInitBean());
            }
        }
        return this.mBusiInfoCommentListDataFromInitBean;
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.mixfeed.piclayerpage.a
    public QFSCommentBlock getCommentBlock() {
        return this.mBlock;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BlockContainer getCommentBlockContainer() {
        return this.mBlock.getBlockContainer();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BlockMerger getCommentBlockMerger() {
        QFSCommentBlock qFSCommentBlock = this.mBlock;
        if (qFSCommentBlock == null) {
            QLog.e(getTAG(), 1, "[getCommentBlockMerger] mBlock == null");
            return null;
        }
        return qFSCommentBlock.getBlockMerger();
    }

    protected abstract View getCommentBottomBar();

    protected com.tencent.biz.qqcircle.comment.h getCommentBusiness() {
        return com.tencent.biz.qqcircle.comment.h.G();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getCommentSize() {
        UIStateData<List<QFSCommentItemInfo>> value;
        com.tencent.biz.qqcircle.viewmodels.n nVar = this.mCommentBlockViewModel;
        if (nVar == null || (value = nVar.c2().getValue()) == null || value.getData() == null) {
            return 0;
        }
        return value.getData().size();
    }

    protected abstract View getContainer();

    /* JADX INFO: Access modifiers changed from: protected */
    public int getContextHashCode() {
        Context context = getContext();
        if (context == null) {
            return 0;
        }
        return context.hashCode();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getDtPageId() {
        return this.mCommentPresenter.e(this.mReportBean, this.mReportBeanAgent);
    }

    @CallSuper
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QCircleCommentUpdateEvent.class);
        arrayList.add(QFSCommentHintTextEvent.class);
        arrayList.add(QFSFavEmojiTabSelectEvent.class);
        arrayList.add(WinkVideoCommentCompleteEvent.class);
        arrayList.add(QFSAddFakeCommentOrReplyEvent.class);
        arrayList.add(QFSECommerceEvent.class);
        arrayList.add(QFSCommentOrReplySharePanelClickEvent.class);
        arrayList.add(QFSCommentEmotionRedPointEvent.class);
        arrayList.add(QFSRebuildInSplitViewModeEvent.class);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public FeedCloudMeta$StFeed getFeedData() {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        QFSCommentInfo qFSCommentInfo = this.mInfo;
        if (qFSCommentInfo != null && (feedCloudMeta$StFeed = qFSCommentInfo.mFeed) != null) {
            this.mInfo.mFeed.f398449id.set(com.tencent.biz.qqcircle.utils.af.a(feedCloudMeta$StFeed.f398449id.get()));
            return this.mInfo.mFeed;
        }
        return new FeedCloudMeta$StFeed();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public QCircleInitBean getInitBean() {
        if (this.mInitBean == null) {
            this.mInitBean = (QCircleInitBean) ((Activity) getContext()).getIntent().getSerializableExtra("key_bundle_common_init_bean");
        }
        return this.mInitBean;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.bizparts.b
    public int getPageId() {
        return this.mCommentPresenter.i(getTAG(), this.mReportBean, this.mReportBeanAgent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.bizparts.b
    public int getParentPageId() {
        return this.mCommentPresenter.j(getTAG(), this.mReportBean, this.mReportBeanAgent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getRealCellId() {
        if (getFeedData() == null) {
            return "";
        }
        return com.tencent.biz.qqcircle.utils.af.a(getFeedData().f398449id.get());
    }

    protected abstract QCircleAsyncTextView getTextInputView();

    /* JADX INFO: Access modifiers changed from: protected */
    public com.tencent.biz.qqcircle.comment.effect.d handleCommentOrReplyAdded(FeedCloudMeta$StComment feedCloudMeta$StComment, FeedCloudMeta$StReply feedCloudMeta$StReply, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void handleGetCommentList(QCircleCommentUpdateEvent qCircleCommentUpdateEvent) {
        if (!qCircleCommentUpdateEvent.feedId.equals(getRealCellId())) {
            return;
        }
        this.mFastCommentText = qCircleCommentUpdateEvent.getFastCommentText();
        boolean z16 = false;
        setLoadingStatus(false);
        refreshView(qCircleCommentUpdateEvent.tailText, qCircleCommentUpdateEvent.contextHashCode);
        onReceiveEventUpdateHintText(qCircleCommentUpdateEvent.tailText);
        if (!useNewCommentItemView()) {
            LoadInfo loadInfo = this.mBlock.getLoadInfo();
            if (getCommentBusiness().A(getFeedData().f398449id.get()) == null) {
                z16 = true;
            }
            loadInfo.setFinish(z16);
            this.mBlock.notifyLoadingComplete(true);
        }
        com.tencent.biz.qqcircle.immersive.report.a.a("comment", String.valueOf(getPageId()), getTAG());
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.mixfeed.piclayerpage.a
    public void init() {
        initView();
        refreshView();
    }

    public void initBlockContainer() {
        BlockContainer blockContainer = this.mBlock.getBlockContainer();
        this.mBlockContainer = blockContainer;
        if (blockContainer == null) {
            QLog.d(TAG, 1, "[initBlockContainer] mBlockContainer is null. ");
            QCircleBlockContainer blockContainer2 = getBlockContainer();
            this.mBlockContainer = blockContainer2;
            if (blockContainer2 == null) {
                QLog.w(getTAG(), 1, "initBlockContainer blockContainer == null");
                return;
            }
            blockContainer2.setLayoutManagerType(1, 1);
            if (getCommentBlockMerger() != null) {
                getCommentBlockMerger().setTryToLoadMoreWhenNotFullScreen(1);
            }
            this.mBlockContainer.setEnableLoadMore(enableLoadMore());
            this.mBlockContainer.setEnableRefresh(false);
            this.mBlockContainer.setParentFragment(getHostFragment());
            this.mBlockContainer.getRecyclerView().setNestedScrollingEnabled(true);
            this.mBlockContainer.registerBlock(prepareAdapters());
            this.mBlockContainer.start();
        }
        QCircleReportBean qCircleReportBean = this.mReportBean;
        if (qCircleReportBean != null) {
            this.mBlock.setReportBean(qCircleReportBean);
        }
        com.tencent.biz.qqcircle.richframework.part.a<QCircleReportBean> aVar = this.mReportBeanAgent;
        if (aVar != null) {
            this.mBlock.j1(aVar);
        }
        this.mBlock.setOnLoadDataDelegate(new h());
        this.mBlock.i1(this);
    }

    public void initCommentInfo(@NonNull QFSCommentInfo qFSCommentInfo) {
        this.mInfo = qFSCommentInfo;
        setFeedData(qFSCommentInfo.mFeed);
        com.tencent.biz.qqcircle.viewmodels.n nVar = this.mCommentBlockViewModel;
        if (nVar != null) {
            nVar.b2().setValue(qFSCommentInfo.mFeed);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @CallSuper
    public void initListener() {
        QLog.d(getTAG(), 1, "[initListener]");
        QCircleAsyncTextView textInputView = getTextInputView();
        if (textInputView != null) {
            textInputView.setOnClickListener(this);
            textInputView.setOnClickAtTextListener(new g());
        }
        SimpleEventBus.getInstance().registerReceiver(this);
        this.mCommentPresenter.r(getBlockContainer());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initTextInputView() {
        String g16;
        String d16 = this.mCommentPresenter.d(this.mInfo);
        boolean z16 = !TextUtils.isEmpty(d16);
        QCircleAsyncTextView textInputView = getTextInputView();
        if (z16) {
            g16 = "";
        } else {
            g16 = this.mCommentPresenter.g(this.mInfo);
        }
        textInputView.setHint(g16);
        QCircleAsyncTextView textInputView2 = getTextInputView();
        if (!z16) {
            d16 = "";
        }
        textInputView2.setText(d16);
    }

    public void initView() {
        initBlockContainer();
        initListener();
        initViewModel();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initViewModel() {
        this.mCommentBlockViewModel = (com.tencent.biz.qqcircle.viewmodels.n) getViewModel(com.tencent.biz.qqcircle.viewmodels.n.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isAllowAiComment() {
        boolean z16;
        boolean d16 = uq3.c.d();
        boolean H0 = uq3.c.H0();
        if (getFeedData() != null && getFeedData().opMask2.get().contains(51)) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.d(TAG, 1, "isAllowAiComment isExperiment = " + d16 + ", isSwitchOpen = " + H0 + ", isAllowInOpMask = " + z16);
        if (!d16 || !H0 || !z16) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isAllowCommentVideo() {
        if (this.mIsNeedShowPublishIcon && com.tencent.biz.qqcircle.comment.af.p(getFeedData())) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.mixfeed.piclayerpage.a
    public boolean isFullScreenComment() {
        return false;
    }

    protected boolean needCloseContainerWhenSoftKeyboardClosed() {
        return false;
    }

    public boolean needShowTopFeedDesc(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        QFSCommentInfo qFSCommentInfo = this.mInfo;
        if (qFSCommentInfo == null) {
            return false;
        }
        QFSCommentInfo.ActionBean actionBean = qFSCommentInfo.mActionBean;
        if ((actionBean != null && !actionBean.mNeedShowTopFeedDesc) || TextUtils.isEmpty(feedCloudMeta$StFeed.content.get()) || this.mInfo.mFrom != 1) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int i3, int i16, Intent intent) {
        if (257 == i3) {
            SimpleEventBus.getInstance().dispatchEvent(new QCircleAtUpdateEvent(getContext(), intent));
        }
    }

    @Override // com.tencent.biz.qqcircle.widgets.comment.c
    public void onClick(View view, int i3, int i16, Object obj) {
        if (i3 == 10) {
            onMoreReplyClick(view, i16, obj);
        } else {
            if (i3 != 11) {
                return;
            }
            onLessReplyClick(view, i16, obj);
        }
    }

    public void onLongClick(View view, int i3, int i16, Object obj) {
        j jVar = new j();
        if (i3 != 5) {
            if (i3 == 8) {
                onReplyLongClick(view, obj, jVar);
                return;
            }
            return;
        }
        onCommentLongClick(view, obj, jVar);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        registerPublishCallback();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    @CallSuper
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        if (!TextUtils.isEmpty(getRealCellId())) {
            getCommentBusiness().s(getRealCellId());
        }
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        unRegisterPublishCallBack();
        clearKeyBoardListener();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        if (PreLoader.exists(getCommentPicPreloadId())) {
            PreLoader.addListener(getCommentPicPreloadId(), new OnTaskListener() { // from class: com.tencent.biz.qqcircle.bizparts.af
                @Override // com.tencent.mobileqq.engineering.preload.inter.OnTaskListener
                public final void onComplete(Object[] objArr) {
                    ag.this.lambda$onPartResume$0((WinkVideoCommentCompleteEvent[]) objArr);
                }
            });
        }
    }

    @CallSuper
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QCircleCommentUpdateEvent) {
            QCircleCommentUpdateEvent qCircleCommentUpdateEvent = (QCircleCommentUpdateEvent) simpleBaseEvent;
            updateCurrentShowCommentAndReplyCount(qCircleCommentUpdateEvent);
            handleEventByStatus(qCircleCommentUpdateEvent);
            return;
        }
        if (simpleBaseEvent instanceof QFSCommentHintTextEvent) {
            handleCommentHintTextEvent((QFSCommentHintTextEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof QFSFavEmojiTabSelectEvent) {
            emojiPanelDTReport(((QFSFavEmojiTabSelectEvent) simpleBaseEvent).isTabExpose);
            return;
        }
        if (simpleBaseEvent instanceof WinkVideoCommentCompleteEvent) {
            PreLoader.preLoad(getCommentPicPreloadId(), new com.tencent.biz.qqcircle.preload.task.b((WinkVideoCommentCompleteEvent) simpleBaseEvent));
            return;
        }
        if (simpleBaseEvent instanceof QFSAddFakeCommentOrReplyEvent) {
            handleAddFakeCommentOrReplyEvent((QFSAddFakeCommentOrReplyEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof QFSECommerceEvent) {
            showInputWindowFromGoods((QFSECommerceEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof QFSCommentOrReplySharePanelClickEvent) {
            handleSharePanelClickEvent((QFSCommentOrReplySharePanelClickEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof QFSCommentEmotionRedPointEvent) {
            com.tencent.biz.qqcircle.viewmodels.n nVar = this.mCommentBlockViewModel;
            if (nVar != null) {
                nVar.R1();
                return;
            }
            return;
        }
        if ((simpleBaseEvent instanceof QFSRebuildInSplitViewModeEvent) && QCircleCustomDialog.Y()) {
            QLog.d(TAG, 1, "dismiss custom dialog success. ");
        }
    }

    protected void onReceiveEventUpdateHintText(String str) {
        if (useNewCommentItemView()) {
            com.tencent.biz.qqcircle.viewmodels.n nVar = this.mCommentBlockViewModel;
            if (TextUtils.isEmpty(str)) {
                str = getContext().getString(R.string.f184043kt);
            }
            nVar.q2(str);
            return;
        }
        BlockMerger commentBlockMerger = getCommentBlockMerger();
        if (commentBlockMerger == null) {
            return;
        }
        if (this.mBlock.I0() != null) {
            commentBlockMerger.setNoMoreHint("");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = getContext().getString(R.string.f184043kt);
        }
        commentBlockMerger.setNoMoreHint(str);
    }

    protected ArrayList<MultiViewBlock> prepareAdapters() {
        ArrayList<MultiViewBlock> arrayList = new ArrayList<>();
        arrayList.add(this.mBlock);
        return arrayList;
    }

    public void refreshView() {
        refreshView("", getContextHashCode());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void registerKeyboardEvent() {
        clearKeyBoardListener();
        com.tencent.biz.qqcircle.widgets.comment.f fVar = new com.tencent.biz.qqcircle.widgets.comment.f(getContainer());
        this.mKeyBoardHelper = fVar;
        fVar.a(new f());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void removeTopFeedDesc() {
        this.mCommentBlockViewModel.k2().setValue(Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void reportCommentAction(int i3) {
        QFSCommentReportHelper.y(getContext(), this.mInfo.mExtraTypeInfo, i3, getPageId(), getParentPageId());
    }

    public void requestCommentList(boolean z16) {
        if (!z16) {
            com.tencent.biz.qqcircle.immersive.report.a.c("comment");
        }
        String itemTopAnimationCommentId = getItemTopAnimationCommentId(this.mInfo, getInitBean());
        if (z16) {
            getCommentBusiness().C(getActivity().hashCode(), 0, getFeedData(), true, this.mCurrentShowCommentAndReplyCount, 0, "");
            return;
        }
        if (!TextUtils.isEmpty(itemTopAnimationCommentId) && getBusiInfo() != null) {
            getCommentBusiness().D(getActivity().hashCode(), getFeedData(), getBusiInfo());
            return;
        }
        boolean z17 = this instanceof QFSNewContentDetailBodyCommentPart;
        if (!z17) {
            com.tencent.biz.qqcircle.immersive.utils.j.f90213a.O(getInitBean(), getReportBean());
        }
        getCommentBusiness().C(getActivity().hashCode(), 0, getFeedData(), false, 0, z17 ? 1 : 0, this.mInfo.mHotCommentId);
    }

    protected void scrollItemToVisibleAboveInputLayout(View view) {
        adjustKeyboardStateToView(view);
    }

    protected void setData(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed, List<FeedCloudMeta$StComment> list) {
        if (useNewCommentItemView()) {
            this.mCommentBlockViewModel.g2().setValue(Boolean.valueOf(getCommentBusiness().S(getRealCellId())));
            this.mCommentBlockViewModel.M1(false, 0, list);
        } else {
            this.mBlock.h1(feedCloudMeta$StFeed, list);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setOrUpdateBlockData(@NonNull List<FeedCloudMeta$StComment> list, int i3) {
        int M0;
        if (useNewCommentItemView()) {
            M0 = getCommentSize();
        } else {
            M0 = this.mBlock.M0();
        }
        if (M0 <= 0 || list.size() > M0) {
            com.tencent.biz.qqcircle.viewmodels.n nVar = this.mCommentBlockViewModel;
            if (nVar != null) {
                nVar.p2();
            }
            setData(getFeedData(), list);
        }
    }

    public void setReportBeanAgent(com.tencent.biz.qqcircle.richframework.part.a<QCircleReportBean> aVar) {
        this.mReportBeanAgent = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setSendPreActionType(int i3) {
        if (i3 == -1) {
            return;
        }
        this.mSendPreActionType = i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean showCommentInputWindow() {
        return showCommentInputWindow(null, null, new QFSCommentInputWindowConfig());
    }

    protected boolean showInputWindowFromFastReply(FeedCloudMeta$StComment feedCloudMeta$StComment) {
        QFSCommentInputWindowConfig qFSCommentInputWindowConfig = new QFSCommentInputWindowConfig();
        qFSCommentInputWindowConfig.from = 19;
        return showCommentInputWindow(feedCloudMeta$StComment, null, qFSCommentInputWindowConfig);
    }

    protected void showInputWindowFromGoods(QFSECommerceEvent qFSECommerceEvent) {
        String str;
        if (!TextUtils.isEmpty(qFSECommerceEvent.getFeedId())) {
            String feedId = qFSECommerceEvent.getFeedId();
            if (getFeedData() != null) {
                str = getFeedData().f398449id.get();
            } else {
                str = "";
            }
            if (TextUtils.equals(feedId, str) && qFSECommerceEvent.getType() == QFSECommerceEvent.TYPE_ADD_ECOMMERCE_GOODS) {
                QFSCommentInputWindowConfig qFSCommentInputWindowConfig = new QFSCommentInputWindowConfig();
                com.tencent.biz.qqcircle.utils.be ecommerceBean = qFSECommerceEvent.getEcommerceBean();
                qFSCommentInputWindowConfig.ecommerceBean = ecommerceBean;
                qFSCommentInputWindowConfig.goodsContent = com.tencent.biz.qqcircle.helpers.l.e().f(ecommerceBean.c());
                qFSCommentInputWindowConfig.isShowPostBtn = !TextUtils.isEmpty(r3);
                showCommentInputWindow(null, null, qFSCommentInputWindowConfig);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean showInputWindowFromReply(FeedCloudMeta$StComment feedCloudMeta$StComment, FeedCloudMeta$StReply feedCloudMeta$StReply) {
        return showCommentInputWindow(feedCloudMeta$StComment, feedCloudMeta$StReply, new QFSCommentInputWindowConfig());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void showInputWindowWithAiComment() {
        QFSCommentInputWindowConfig qFSCommentInputWindowConfig = new QFSCommentInputWindowConfig();
        qFSCommentInputWindowConfig.isShowAiComment = true;
        showCommentInputWindow(null, null, qFSCommentInputWindowConfig);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void showInputWindowWithAt() {
        QFSCommentInputWindowConfig qFSCommentInputWindowConfig = new QFSCommentInputWindowConfig();
        qFSCommentInputWindowConfig.needShowAt = true;
        showCommentInputWindow(null, null, qFSCommentInputWindowConfig);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void showInputWindowWithEmoji() {
        QFSCommentInputWindowConfig qFSCommentInputWindowConfig = new QFSCommentInputWindowConfig();
        qFSCommentInputWindowConfig.isShowEmoji = true;
        showCommentInputWindow(null, null, qFSCommentInputWindowConfig);
    }

    protected boolean showInputWindowWithPic(FeedCloudMeta$StComment feedCloudMeta$StComment, FeedCloudMeta$StReply feedCloudMeta$StReply, QFSCommentInputWindowConfig qFSCommentInputWindowConfig) {
        return showCommentInputWindow(feedCloudMeta$StComment, feedCloudMeta$StReply, qFSCommentInputWindowConfig);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void showInputWindowWithPicPanel() {
        QFSCommentInputWindowConfig qFSCommentInputWindowConfig = new QFSCommentInputWindowConfig();
        qFSCommentInputWindowConfig.isShowHalfScreenPicPanel = true;
        showCommentInputWindow(null, null, qFSCommentInputWindowConfig);
    }

    protected boolean showPicEntranceRedPoint() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void showTopFeedDesc() {
        this.mCommentBlockViewModel.k2().setValue(Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @CallSuper
    public void updateCommentNum(int i3) {
        this.mCurCommentCount = i3;
        SimpleEventBus.getInstance().dispatchEvent(new QCircleCommentCountUpdateEvent(getFeedData().f398449id.get(), i3));
    }

    protected void updateListEmptyTextView() {
        updateListEmptyTextView(uq3.c.x3());
    }

    protected abstract void updateListEmptyTextView(String str);

    protected boolean useNewCommentItemView() {
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("101664", true) && (((this instanceof QFSCommentPanelPart) || (this instanceof com.tencent.biz.qqcircle.immersive.layer.biz.inside.fullscreen.b)) && this.mCommentBlockViewModel != null)) {
            return true;
        }
        return false;
    }

    public ag(@NonNull QFSCommentBlock qFSCommentBlock, @NonNull QFSBaseCommentPresenter qFSBaseCommentPresenter) {
        this.mCurrentShowCommentAndReplyCount = 0;
        this.mCurCommentCount = -1;
        this.mIsNeedShowPublishIcon = true;
        this.mBlock = qFSCommentBlock;
        this.mCommentPresenter = qFSBaseCommentPresenter;
        qFSBaseCommentPresenter.t(this);
    }

    private void refreshView(String str, int i3) {
        ArrayList<FeedCloudMeta$StComment> H = getCommentBusiness().H(getRealCellId());
        if (H == null) {
            H = new ArrayList<>();
            this.mCommentPresenter.a(getFeedData().vecComment.get(), H);
            setData(getFeedData(), H);
        } else {
            setOrUpdateBlockData(H, i3);
        }
        updateCommentNum(getCommentBusiness().I(getFeedData()));
        if (str == null) {
            updateListEmptyTextView();
        } else {
            updateListEmptyTextView(str);
        }
        insertFakePublishFeedDraftWhenRefresh(H);
    }

    @Override // com.tencent.biz.qqcircle.bizparts.b, com.tencent.biz.qqcircle.richframework.part.a
    public QCircleReportBean getReportBean() {
        return this.mCommentPresenter.k(getTAG(), this.mReportBean, this.mReportBeanAgent);
    }

    @CallSuper
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view == getTextInputView()) {
            handleInputTextClick();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean showCommentInputWindow(@Nullable FeedCloudMeta$StComment feedCloudMeta$StComment, @Nullable FeedCloudMeta$StReply feedCloudMeta$StReply, @NonNull QFSCommentInputWindowConfig qFSCommentInputWindowConfig) {
        boolean z16 = false;
        if (!QCircleBindPhoneNumberHelper.a()) {
            QCircleBindPhoneNumberHelper.b(getActivity(), 2);
            return false;
        }
        qFSCommentInputWindowConfig.activity = getActivity();
        if (qFSCommentInputWindowConfig.commentInfo == null) {
            qFSCommentInputWindowConfig.commentInfo = new QFSFeedCommentInfo(getFeedData(), feedCloudMeta$StComment, feedCloudMeta$StReply, this.mInfo.mHintText);
        }
        qFSCommentInputWindowConfig.isFullScreen = isFullScreenComment();
        qFSCommentInputWindowConfig.needShowPublishIcon = isAllowCommentVideo();
        qFSCommentInputWindowConfig.showPicEntranceRedPoint = showPicEntranceRedPoint() && TextUtils.isEmpty(qFSCommentInputWindowConfig.commentPicPath);
        if (qFSCommentInputWindowConfig.isAllowAiComment && isAllowAiComment()) {
            z16 = true;
        }
        qFSCommentInputWindowConfig.isAllowAiComment = z16;
        initConfigReportBean(qFSCommentInputWindowConfig);
        qFSCommentInputWindowConfig.isFromContentPage = true;
        assembleQQVideoParams(qFSCommentInputWindowConfig);
        qFSCommentInputWindowConfig.inputListener = new i(feedCloudMeta$StComment, feedCloudMeta$StReply, qFSCommentInputWindowConfig);
        boolean w06 = QFSCommentHelper.L().w0(qFSCommentInputWindowConfig);
        reportCommentAction(7);
        return w06;
    }

    private void insertFakePublishFeedDraft(List<FeedCloudMeta$StComment> list, QFSCommentPublishFeedDraftBean qFSCommentPublishFeedDraftBean, boolean z16) {
        List<FeedCloudMeta$StReply> list2;
        if (list != null && qFSCommentPublishFeedDraftBean != null) {
            FeedCloudMeta$StFeed feedData = getFeedData();
            if (feedData != null && !TextUtils.isEmpty(feedData.f398449id.get())) {
                QFSFeedCommentInfo feedCommentInfo = qFSCommentPublishFeedDraftBean.getFeedCommentInfo();
                if (feedCommentInfo == null) {
                    QLog.e(getTAG(), 1, "[insertFakePublishFeedDraft] commentInfo == null");
                    return;
                }
                FeedCloudMeta$StFeed feedCloudMeta$StFeed = feedCommentInfo.mFeed;
                if (feedCloudMeta$StFeed == null) {
                    QLog.e(getTAG(), 1, "[insertFakePublishFeedDraft] targetFeed == null");
                    return;
                }
                if (!TextUtils.equals(feedData.f398449id.get(), feedCloudMeta$StFeed.f398449id.get())) {
                    QLog.e(getTAG(), 1, "[insertFakePublishFeedDraft] feedId not empty, curFeedId = " + feedData.f398449id.get() + ", targetFeedId = " + feedCloudMeta$StFeed.f398449id.get());
                    return;
                }
                int postType = qFSCommentPublishFeedDraftBean.getPostType();
                FeedCloudMeta$StComment feedCloudMeta$StComment = feedCommentInfo.mComment;
                FeedCloudMeta$StComment fakeComment = qFSCommentPublishFeedDraftBean.getFakeComment();
                FeedCloudMeta$StReply fakeReply = qFSCommentPublishFeedDraftBean.getFakeReply();
                String tag = getTAG();
                StringBuilder sb5 = new StringBuilder();
                sb5.append("[insertFakePublishFeedDraft] feedId:");
                sb5.append(feedCloudMeta$StFeed.f398449id.get());
                sb5.append(" | draftId:");
                sb5.append(qFSCommentPublishFeedDraftBean.getDraftId());
                sb5.append(" | isRefresh:");
                sb5.append(z16);
                sb5.append(" | postType:");
                sb5.append(postType);
                sb5.append(" | targetComment:");
                sb5.append(feedCloudMeta$StComment == null ? "" : feedCloudMeta$StComment.f398447id.get());
                sb5.append(" | fakeComment:");
                sb5.append(fakeComment == null ? "" : fakeComment.f398447id.get());
                sb5.append(" | fakeReply:");
                sb5.append(fakeReply != null ? fakeReply.f398460id.get() : "");
                QLog.d(tag, 1, sb5.toString());
                int i3 = 0;
                if (z16 && postType == 1 && fakeComment != null) {
                    if (QFSCommentHelper.c0(fakeComment.f398447id.get())) {
                        while (i3 < list.size()) {
                            FeedCloudMeta$StComment feedCloudMeta$StComment2 = list.get(i3);
                            if (feedCloudMeta$StComment2 != null && TextUtils.equals(feedCloudMeta$StComment2.f398447id.get(), fakeComment.f398447id.get())) {
                                QLog.d(getTAG(), 1, "comment has insert");
                                return;
                            }
                            i3++;
                        }
                        QLog.d(getTAG(), 1, "comment insert");
                        handleAddFakeComment(fakeComment, 100, null);
                        return;
                    }
                    return;
                }
                if ((postType == 2 || postType == 3) && feedCloudMeta$StComment != null && fakeReply != null && QFSCommentHelper.c0(fakeReply.f398460id.get())) {
                    for (int i16 = 0; i16 < list.size(); i16++) {
                        FeedCloudMeta$StComment feedCloudMeta$StComment3 = list.get(i16);
                        if (feedCloudMeta$StComment3 != null && TextUtils.equals(feedCloudMeta$StComment3.f398447id.get(), feedCloudMeta$StComment.f398447id.get()) && (list2 = feedCloudMeta$StComment3.vecReply.get()) != null) {
                            while (i3 < list2.size()) {
                                FeedCloudMeta$StReply feedCloudMeta$StReply = list2.get(i3);
                                if (feedCloudMeta$StReply != null && TextUtils.equals(feedCloudMeta$StReply.f398460id.get(), fakeReply.f398460id.get())) {
                                    QLog.d(getTAG(), 1, "reply has insert");
                                    return;
                                }
                                i3++;
                            }
                            QLog.d(getTAG(), 1, "reply insert");
                            handleAddFakeReply(fakeReply, feedCloudMeta$StComment, feedCommentInfo.mReply, 100, null, 0);
                            return;
                        }
                    }
                    return;
                }
                return;
            }
            QLog.e(getTAG(), 1, "[insertFakePublishFeedDraft] curFeedId is empty");
            return;
        }
        QLog.e(getTAG(), 1, "[insertFakePublishFeedDraft] comments or draftBean == null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleAddFakeReply(FeedCloudMeta$StReply feedCloudMeta$StReply, FeedCloudMeta$StComment feedCloudMeta$StComment, FeedCloudMeta$StReply feedCloudMeta$StReply2, int i3, o20.d dVar, int i16) {
        handleAddFakeReply(feedCloudMeta$StReply, feedCloudMeta$StComment, feedCloudMeta$StReply2, i3, dVar, i16, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class f implements f.b {
        f() {
        }

        @Override // com.tencent.biz.qqcircle.widgets.comment.f.b
        public void onSoftKeyboardClosed() {
            ag agVar = ag.this;
            agVar.mCommentPresenter.b(agVar.getCommentBlockContainer(), 0);
            if (ag.this.getContainer() != null && ag.this.needCloseContainerWhenSoftKeyboardClosed()) {
                ag.this.getContainer().setVisibility(8);
            }
        }

        @Override // com.tencent.biz.qqcircle.widgets.comment.f.b
        public void onSoftKeyboardOpened(int i3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class i implements QFSCommentHelper.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FeedCloudMeta$StComment f82849a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ FeedCloudMeta$StReply f82850b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ QFSCommentInputWindowConfig f82851c;

        i(FeedCloudMeta$StComment feedCloudMeta$StComment, FeedCloudMeta$StReply feedCloudMeta$StReply, QFSCommentInputWindowConfig qFSCommentInputWindowConfig) {
            this.f82849a = feedCloudMeta$StComment;
            this.f82850b = feedCloudMeta$StReply;
            this.f82851c = qFSCommentInputWindowConfig;
        }

        @Override // com.tencent.biz.qqcircle.utils.QFSCommentHelper.b
        public void b(FeedCloudMeta$StReply feedCloudMeta$StReply, o20.d dVar) {
            ag agVar = ag.this;
            FeedCloudMeta$StComment feedCloudMeta$StComment = this.f82849a;
            FeedCloudMeta$StReply feedCloudMeta$StReply2 = this.f82850b;
            QFSCommentInputWindowConfig qFSCommentInputWindowConfig = this.f82851c;
            agVar.handleAddFakeReply(feedCloudMeta$StReply, feedCloudMeta$StComment, feedCloudMeta$StReply2, qFSCommentInputWindowConfig.relocationType, dVar, qFSCommentInputWindowConfig.from);
        }

        @Override // com.tencent.biz.qqcircle.utils.QFSCommentHelper.b
        public void c(FeedCloudMeta$StComment feedCloudMeta$StComment, o20.d dVar) {
            ag.this.handleAddFakeComment(feedCloudMeta$StComment, this.f82851c.relocationType, dVar);
        }

        @Override // com.tencent.biz.qqcircle.utils.QFSCommentHelper.b
        public void a(int i3) {
        }
    }

    protected void enableSlide(boolean z16) {
    }

    protected void setLoadingStatus(boolean z16) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class d implements DialogInterface.OnClickListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class m implements DialogInterface.OnClickListener {
        m() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class o implements DialogInterface.OnClickListener {
        o() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
        }
    }
}
