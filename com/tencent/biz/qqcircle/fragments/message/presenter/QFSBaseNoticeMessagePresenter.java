package com.tencent.biz.qqcircle.fragments.message.presenter;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ReplacementSpan;
import android.view.View;
import android.view.ViewStub;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.beans.QCircleLikeBean;
import com.tencent.biz.qqcircle.beans.QFSMessageItemInfo;
import com.tencent.biz.qqcircle.helpers.q;
import com.tencent.biz.qqcircle.immersive.events.QFSLaunchToSelectedEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSShowPersonalPanelEvent;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.requests.QFSThankPSVRequest;
import com.tencent.biz.qqcircle.utils.QFSMessageAvatarWrapper;
import com.tencent.biz.qqcircle.utils.QFSQUIUtilsKt;
import com.tencent.biz.qqcircle.utils.ac;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarListView;
import com.tencent.biz.qqcircle.widgets.QFSFollowView;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.richframework.text.rich.RFWAsyncRichTextView;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudCommon$BytesEntry;
import feedcloud.FeedCloudMeta$StComment;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StNotice;
import feedcloud.FeedCloudMeta$StOperation;
import feedcloud.FeedCloudMeta$StReply;
import feedcloud.FeedCloudMeta$StUser;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import qqcircle.QQCircleBase$StUserBusiData;
import qqcircle.QQCircleFeedBase$StNoticeBusiData;
import qqcircle.QQCircleThank$ThankPSVRsp;

/* loaded from: classes4.dex */
public abstract class QFSBaseNoticeMessagePresenter extends com.tencent.biz.qqcircle.fragments.message.presenter.a implements SimpleEventReceiver {
    private static final int COMMENT_REPLY_UNLIKE_STATUS = 0;
    protected static final int MESSAGE_VIEW_MIN_WIDTH = cx.a(360.0f);
    private static final String UNDERSCORE = "_";
    protected QCircleAvatarListView mAvatarListView;
    protected QFSMessageAvatarWrapper mAvatarWrap;
    private n30.c mCommentCoverWrap;
    protected View mContentContainer;
    protected ImageView mIvRightArrowLine1;
    private QFSFollowView mIvUserFollow;
    protected View mLLNickIcon;
    protected ConstraintLayout mMessageContainer;
    private View mMiniPersonaPanelView;
    protected ImageView mRightArrow;
    protected QCircleAsyncTextView mSubMessage;
    protected LinearLayout mSubMessageContainer;
    protected QCircleAsyncTextView mSummery;
    protected View mSummeryContainer;
    private AnimatorSet mThankAnimatorSet;
    private ImageView mThankedIv;
    private View mThanksBgView;
    private View mThanksView;
    protected QCircleAsyncTextView mTvMessage;
    protected TextView mTvNick;
    private TextView mTvSplitDot;
    private TextView mTvThanks;
    protected TextView mTvTime;
    private TextView mTvUserTypeLabel;
    private ImageView mUnThankIv;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements RFWAsyncRichTextView.OnClickAtTextListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QCircleAsyncTextView f84457a;

        a(QCircleAsyncTextView qCircleAsyncTextView) {
            this.f84457a = qCircleAsyncTextView;
        }

        @Override // com.tencent.richframework.text.rich.RFWAsyncRichTextView.OnClickAtTextListener
        public void onClick(String str) {
            View view = QFSBaseNoticeMessagePresenter.this.mContainer;
            if (view == null) {
                return;
            }
            view.callOnClick();
            QFSBaseNoticeMessagePresenter.this.reportClickEvent(this.f84457a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QFSBaseNoticeMessagePresenter.this.consumeItemNewFlag();
            QCircleLayerBean defaultContentDetailAttrs = QFSBaseNoticeMessagePresenter.this.getDefaultContentDetailAttrs(view);
            if (defaultContentDetailAttrs != null) {
                defaultContentDetailAttrs.setFromReportBean(QFSBaseNoticeMessagePresenter.this.getReportBean().m466clone());
                defaultContentDetailAttrs.setSingleFeed(true);
                defaultContentDetailAttrs.setPreRenderType(10012);
                defaultContentDetailAttrs.setEnableUpDragExit(true);
                com.tencent.biz.qqcircle.launcher.c.u(view.getContext(), defaultContentDetailAttrs);
                QFSBaseNoticeMessagePresenter.this.dtReportJumpContentLayerPage();
            }
            QFSBaseNoticeMessagePresenter.this.reportClickEvent(view);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes4.dex */
    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            String str2;
            String str3;
            String str4;
            EventCollector.getInstance().onViewClickedBefore(view);
            QFSBaseNoticeMessagePresenter.this.consumeItemNewFlag();
            QFSBaseNoticeMessagePresenter qFSBaseNoticeMessagePresenter = QFSBaseNoticeMessagePresenter.this;
            int i3 = qFSBaseNoticeMessagePresenter.mViewType;
            String str5 = "";
            int i16 = 6;
            if (i3 == 6) {
                FeedCloudMeta$StComment feedCloudMeta$StComment = qFSBaseNoticeMessagePresenter.mItemInfo.getStNotice().operation.comment.get();
                if (feedCloudMeta$StComment == null || feedCloudMeta$StComment.likeInfo.get() == null) {
                    str2 = "";
                    str4 = str2;
                } else {
                    str4 = feedCloudMeta$StComment.likeInfo.get().f398454id.get();
                    str2 = feedCloudMeta$StComment.f398447id.get();
                }
                str5 = str4;
                str = "";
            } else {
                i16 = 7;
                if (i3 == 7) {
                    FeedCloudMeta$StComment feedCloudMeta$StComment2 = qFSBaseNoticeMessagePresenter.mItemInfo.getStNotice().operation.comment.get();
                    String replyLikeId = QFSBaseNoticeMessagePresenter.this.getReplyLikeId(feedCloudMeta$StComment2);
                    FeedCloudMeta$StReply reply = QFSBaseNoticeMessagePresenter.this.getReply(feedCloudMeta$StComment2);
                    if (reply == null) {
                        str3 = "";
                    } else {
                        str3 = reply.f398460id.get();
                    }
                    str = str3;
                    str2 = "";
                    str5 = replyLikeId;
                } else {
                    i16 = 19;
                    if (i3 != 19) {
                        i16 = 20;
                        if (i3 != 20) {
                            i16 = 17;
                            if (i3 != 17) {
                                i16 = 22;
                                if (i3 != 22) {
                                    i16 = 31;
                                    if (i3 != 31) {
                                        i16 = 2;
                                        str = "";
                                        str5 = qFSBaseNoticeMessagePresenter.mItemInfo.getStNotice().feed.likeInfo.f398454id.get();
                                        str2 = str;
                                    }
                                }
                            }
                        }
                    }
                    str2 = "";
                    str = str2;
                }
            }
            int i17 = 0;
            long j3 = 0;
            if (QFSBaseNoticeMessagePresenter.this.mItemInfo.getNoticeBusiData() != null && QFSBaseNoticeMessagePresenter.this.mItemInfo.getNoticeBusiData().busiInfo.get() != null) {
                try {
                    i17 = Integer.parseInt(QCirclePluginUtil.getValueFromListEntry(QFSBaseNoticeMessagePresenter.this.mItemInfo.getNoticeBusiData().busiInfo.get(), "unread_like_count", "0"));
                    j3 = Long.parseLong(QCirclePluginUtil.getValueFromListEntry(QFSBaseNoticeMessagePresenter.this.mItemInfo.getNoticeBusiData().busiInfo.get(), "last_like_time", "0"));
                } catch (Exception e16) {
                    QLog.e(QFSBaseNoticeMessagePresenter.this.getLogTag(), 1, e16.toString());
                }
            }
            QCircleLikeBean qCircleLikeBean = new QCircleLikeBean();
            qCircleLikeBean.setFeed(QFSBaseNoticeMessagePresenter.this.mItemInfo.getStNotice().feed);
            qCircleLikeBean.setRequestType(i16);
            qCircleLikeBean.setLikeId(str5);
            qCircleLikeBean.setCount(i17);
            qCircleLikeBean.setTime(j3);
            qCircleLikeBean.setNoticeType(QFSBaseNoticeMessagePresenter.this.mViewType);
            qCircleLikeBean.setCommentId(str2);
            qCircleLikeBean.setReplyId(str);
            qCircleLikeBean.setFromReportBean(QFSBaseNoticeMessagePresenter.this.getReportBean().m466clone());
            if (QFSBaseNoticeMessagePresenter.this.mItemInfo.getStNotice() != null && QFSBaseNoticeMessagePresenter.this.mItemInfo.getStNotice().operation != null) {
                ArrayList arrayList = new ArrayList();
                Iterator<FeedCloudCommon$BytesEntry> it = QFSBaseNoticeMessagePresenter.this.mItemInfo.getStNotice().operation.busiTranparent.get().iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().toByteArray());
                }
                qCircleLikeBean.setBusiTranparentList(arrayList);
            }
            com.tencent.biz.qqcircle.launcher.c.R(view.getContext(), qCircleLikeBean);
            QFSBaseNoticeMessagePresenter.this.reportClickEvent(view);
            QFSBaseNoticeMessagePresenter.this.dtReportGatherEntrance();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QFSBaseNoticeMessagePresenter.this.consumeItemNewFlag();
            FeedCloudMeta$StNotice stNotice = QFSBaseNoticeMessagePresenter.this.mItemInfo.getStNotice();
            if (stNotice != null && !TextUtils.isEmpty(stNotice.operation.opUser.f398463id.get())) {
                if (view.getId() == R.id.f165909du3) {
                    QFSMessageAvatarWrapper qFSMessageAvatarWrapper = QFSBaseNoticeMessagePresenter.this.mAvatarWrap;
                    if (qFSMessageAvatarWrapper != null) {
                        qFSMessageAvatarWrapper.e();
                    }
                    QQCircleBase$StUserBusiData userBusiData = QFSBaseNoticeMessagePresenter.this.mItemInfo.getUserBusiData();
                    if (userBusiData != null) {
                        userBusiData.has_unread_feed.set(false);
                    }
                }
                QFSBaseNoticeMessagePresenter.this.gotoProfilerPage(view.getContext(), stNotice);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QQCircleFeedBase$StNoticeBusiData f84462d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ FeedCloudMeta$StNotice f84463e;

        /* loaded from: classes4.dex */
        class a implements VSDispatchObserver.OnVSRspCallBack<QQCircleThank$ThankPSVRsp> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ boolean f84465a;

            a(boolean z16) {
                this.f84465a = z16;
            }

            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, QQCircleThank$ThankPSVRsp qQCircleThank$ThankPSVRsp) {
                String traceId;
                String logTag = QFSBaseNoticeMessagePresenter.this.getLogTag();
                StringBuilder sb5 = new StringBuilder();
                sb5.append("NFT-[thanksClick] traceId: ");
                if (baseRequest == null) {
                    traceId = null;
                } else {
                    traceId = baseRequest.getTraceId();
                }
                sb5.append(traceId);
                sb5.append(" | isSuccess: ");
                sb5.append(z16);
                sb5.append(" | retCode: ");
                sb5.append(j3);
                sb5.append(" | errMsg: ");
                sb5.append(str);
                QLog.d(logTag, 1, sb5.toString());
                if (z16 && j3 == 0) {
                    QFSBaseNoticeMessagePresenter.this.consumeItemNewFlag();
                    return;
                }
                e.this.f84462d.thanked.set(this.f84465a);
                e eVar = e.this;
                QFSBaseNoticeMessagePresenter.this.updateThanksStatus(false, eVar.f84463e, eVar.f84462d);
                QCircleToast.h(R.string.f19228473, 0);
            }
        }

        e(QQCircleFeedBase$StNoticeBusiData qQCircleFeedBase$StNoticeBusiData, FeedCloudMeta$StNotice feedCloudMeta$StNotice) {
            this.f84462d = qQCircleFeedBase$StNoticeBusiData;
            this.f84463e = feedCloudMeta$StNotice;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            boolean z16 = this.f84462d.thanked.get();
            if (z16 && QFSBaseNoticeMessagePresenter.this.hasMultiPerson(this.f84463e, this.f84462d)) {
                QCircleToast.h(R.string.f188543wz, 0);
            } else {
                boolean z17 = !z16;
                this.f84462d.thanked.set(z17);
                QFSBaseNoticeMessagePresenter.this.updateThanksStatus(true, this.f84463e, this.f84462d);
                VSNetworkHelper.getInstance().sendRequest(new QFSThankPSVRequest(z17, this.f84463e.feedId.get()), new a(z16));
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class g implements IDynamicParams {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<QFSBaseNoticeMessagePresenter> f84470a;

        /* renamed from: b, reason: collision with root package name */
        private String f84471b;

        public g(QFSBaseNoticeMessagePresenter qFSBaseNoticeMessagePresenter, String str) {
            this.f84470a = new WeakReference<>(qFSBaseNoticeMessagePresenter);
            this.f84471b = str;
        }

        @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
        public Map<String, Object> getDynamicParams(String str) {
            String str2;
            String str3;
            QFSBaseNoticeMessagePresenter qFSBaseNoticeMessagePresenter = this.f84470a.get();
            if (qFSBaseNoticeMessagePresenter != null && qFSBaseNoticeMessagePresenter.mItemInfo != null) {
                Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
                if (qFSBaseNoticeMessagePresenter.hasMultiPerson(qFSBaseNoticeMessagePresenter.mItemInfo.getStNotice(), qFSBaseNoticeMessagePresenter.mItemInfo.getNoticeBusiData())) {
                    str2 = "2";
                } else {
                    str2 = "1";
                }
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_THANK_BUTTON_TYPE, str2);
                if (qFSBaseNoticeMessagePresenter.mItemInfo.getNoticeBusiData().thanked.get()) {
                    str3 = "thank";
                } else {
                    str3 = "thank_cancel";
                }
                buildElementParams.put("xsj_action_type", str3);
                if (!TextUtils.isEmpty(this.f84471b)) {
                    buildElementParams.put("xsj_target_qq", this.f84471b);
                }
                return buildElementParams;
            }
            return null;
        }
    }

    public QFSBaseNoticeMessagePresenter(int i3) {
        super(i3);
        this.mAvatarWrap = new QFSMessageAvatarWrapper(this.mViewType);
    }

    private void adjustAvatarSize() {
        if (this.mAvatarWrap == null) {
            QLog.e(getLogTag(), 1, "adjustAvatarSize mAvatarWrap is null");
        } else if (isUseDiffAvatarSizeAndTxtColor()) {
            this.mAvatarWrap.y(com.tencent.biz.qqcircle.immersive.utils.n.a(this.mContext, R.dimen.d3c));
            this.mAvatarWrap.c();
        }
    }

    private void adjustMiniPersonPanelPadding(Context context) {
        if (this.mMiniPersonaPanelView == null && (context instanceof Activity)) {
            View findViewById = ((Activity) context).findViewById(R.id.f485820d);
            this.mMiniPersonaPanelView = findViewById;
            m30.a.a(findViewById);
        }
    }

    private void adjustNickSize() {
        int i3;
        TextView textView = this.mTvNick;
        if (textView == null) {
            return;
        }
        Resources resources = textView.getResources();
        if (isUseDiffAvatarSizeAndTxtColor()) {
            i3 = R.dimen.c6v;
        } else {
            i3 = R.dimen.c6u;
        }
        textView.setTextSize(0, resources.getDimension(i3));
    }

    private void adjustTxtColor() {
        int i3;
        int i16;
        boolean isUseDiffAvatarSizeAndTxtColor = isUseDiffAvatarSizeAndTxtColor();
        TextView textView = this.mTvTime;
        if (textView != null) {
            Resources resources = RFWApplication.getApplication().getResources();
            if (isUseDiffAvatarSizeAndTxtColor) {
                i16 = R.color.qui_common_text_tertiary;
            } else {
                i16 = R.color.qui_common_text_secondary_light;
            }
            textView.setTextColor(resources.getColorStateList(i16));
        }
        QCircleAsyncTextView qCircleAsyncTextView = this.mTvMessage;
        int i17 = R.color.qui_common_text_secondary;
        if (qCircleAsyncTextView != null) {
            Resources resources2 = RFWApplication.getApplication().getResources();
            if (isUseDiffAvatarSizeAndTxtColor) {
                i3 = R.color.qui_common_text_secondary;
            } else {
                i3 = R.color.qui_common_text_primary;
            }
            qCircleAsyncTextView.setTextColor(resources2.getColorStateList(i3));
        }
        QCircleAsyncTextView qCircleAsyncTextView2 = this.mSubMessage;
        if (qCircleAsyncTextView2 != null) {
            Resources resources3 = RFWApplication.getApplication().getResources();
            if (this.mViewType != 31) {
                i17 = R.color.qui_common_text_primary;
            }
            qCircleAsyncTextView2.setTextColor(resources3.getColorStateList(i17));
        }
    }

    private void bindNormalData(FeedCloudMeta$StNotice feedCloudMeta$StNotice, QQCircleFeedBase$StNoticeBusiData qQCircleFeedBase$StNoticeBusiData, int i3) {
        this.mTvNick.setText(feedCloudMeta$StNotice.operation.opUser.nick.get());
        FeedCloudMeta$StUser feedCloudMeta$StUser = feedCloudMeta$StNotice.operation.opUser.get();
        setContent(feedCloudMeta$StNotice);
        setSubContent(feedCloudMeta$StNotice.subMessage.get());
        setSummery(feedCloudMeta$StNotice.summary.get());
        setUserTypeLabel(qQCircleFeedBase$StNoticeBusiData);
        setIvUserFollow(feedCloudMeta$StUser, feedCloudMeta$StNotice);
        setTime(feedCloudMeta$StNotice);
        handleRightArrowShow();
        setThanks(feedCloudMeta$StNotice, qQCircleFeedBase$StNoticeBusiData);
        n30.c cVar = this.mCommentCoverWrap;
        if (cVar != null) {
            cVar.b(feedCloudMeta$StNotice, i3);
        }
    }

    private void dismissThanksView() {
        View view = this.mThanksView;
        if (view != null) {
            view.setVisibility(8);
            View view2 = (View) this.mContentContainer.getParent();
            view2.setPadding(view2.getPaddingLeft(), view2.getPaddingTop(), view2.getPaddingRight(), view2.getResources().getDimensionPixelSize(R.dimen.c6j));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dtReportGatherEntrance() {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.fragments.message.presenter.QFSBaseNoticeMessagePresenter.9
            @Override // java.lang.Runnable
            public void run() {
                Map<String, Object> dtReportSubViewParams = QFSBaseNoticeMessagePresenter.this.getDtReportSubViewParams();
                dtReportSubViewParams.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_MSG_GATHER_ENTRANCE);
                VideoReport.reportEvent("ev_xsj_abnormal_clck", QFSBaseNoticeMessagePresenter.this.mContainer, dtReportSubViewParams);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dtReportJumpContentLayerPage() {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.fragments.message.presenter.QFSBaseNoticeMessagePresenter.8
            @Override // java.lang.Runnable
            public void run() {
                Map<String, Object> dtReportSubViewParams = QFSBaseNoticeMessagePresenter.this.getDtReportSubViewParams();
                dtReportSubViewParams.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_MSG_SKIP_FEED_AREA);
                VideoReport.reportEvent("ev_xsj_abnormal_clck", QFSBaseNoticeMessagePresenter.this.mContainer, dtReportSubViewParams);
            }
        });
    }

    private void dtReportThanks(FeedCloudMeta$StNotice feedCloudMeta$StNotice, QQCircleFeedBase$StNoticeBusiData qQCircleFeedBase$StNoticeBusiData) {
        FeedCloudMeta$StOperation feedCloudMeta$StOperation;
        if (feedCloudMeta$StNotice != null && (feedCloudMeta$StOperation = feedCloudMeta$StNotice.operation) != null && feedCloudMeta$StOperation.opUser != null) {
            View view = this.mThanksView;
            VideoReport.setElementId(view, QCircleDaTongConstant.ElementId.EM_XSJ_THANK_BUTTON);
            VideoReport.setElementReuseIdentifier(view, feedCloudMeta$StNotice.operation.opUser.f398463id.get() + "_" + feedCloudMeta$StNotice.createTime.get());
            VideoReport.setEventDynamicParams(view, new g(this, feedCloudMeta$StNotice.operation.opUser.f398463id.get()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getReplyLikeId(FeedCloudMeta$StComment feedCloudMeta$StComment) {
        if (feedCloudMeta$StComment == null) {
            return "";
        }
        for (FeedCloudMeta$StReply feedCloudMeta$StReply : feedCloudMeta$StComment.vecReply.get()) {
            if (feedCloudMeta$StReply.modifyflag.get() != 0) {
                return feedCloudMeta$StReply.likeInfo.get().f398454id.get();
            }
        }
        return "";
    }

    private void handleShowThankTips() {
        if (this.mTvThanks != null && !uq3.k.a().c("qfs_has_show_thank_tips", false)) {
            this.mTvThanks.postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.fragments.message.presenter.d
                @Override // java.lang.Runnable
                public final void run() {
                    QFSBaseNoticeMessagePresenter.this.lambda$handleShowThankTips$2();
                }
            }, 2000L);
        }
    }

    private void initThanksView() {
        if (this.mThanksView == null) {
            ViewStub viewStub = (ViewStub) this.mContainer.findViewById(R.id.f1204579l);
            if (viewStub == null) {
                QLog.d(getLogTag(), 1, "[showThanksView] viewStub = null");
                return;
            }
            View inflate = viewStub.inflate();
            this.mThanksView = inflate;
            this.mThankedIv = (ImageView) inflate.findViewById(R.id.f44601pm);
            this.mUnThankIv = (ImageView) this.mThanksView.findViewById(R.id.f44651pr);
            this.mTvThanks = (TextView) this.mThanksView.findViewById(R.id.f111866md);
            View findViewById = this.mThanksView.findViewById(R.id.f40561ep);
            this.mThanksBgView = findViewById;
            if (findViewById != null) {
                m30.a.d(findViewById);
            }
        }
        View view = this.mThanksView;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    private boolean isUseDiffAvatarSizeAndTxtColor() {
        int i3 = this.mViewType;
        if (i3 != 21 && i3 != 31) {
            return false;
        }
        return true;
    }

    private void jumpPersonPage(Context context) {
        FeedCloudMeta$StNotice feedCloudMeta$StNotice;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        if (context == null) {
            return;
        }
        consumeItemNewFlag();
        QFSMessageItemInfo qFSMessageItemInfo = this.mItemInfo;
        if (qFSMessageItemInfo != null) {
            feedCloudMeta$StNotice = qFSMessageItemInfo.getStNotice();
        } else {
            feedCloudMeta$StNotice = null;
        }
        if (feedCloudMeta$StNotice == null) {
            return;
        }
        if (this.mItemInfo.getApertureExposeFeed() != null) {
            feedCloudMeta$StFeed = this.mItemInfo.getApertureExposeFeed();
            this.mItemInfo.setApertureExposeFeed(null);
        } else {
            feedCloudMeta$StFeed = new FeedCloudMeta$StFeed();
        }
        feedCloudMeta$StFeed.poster.set(feedCloudMeta$StNotice.operation.opUser.get());
        QFSShowPersonalPanelEvent qFSShowPersonalPanelEvent = new QFSShowPersonalPanelEvent(feedCloudMeta$StFeed, true, context.hashCode());
        qFSShowPersonalPanelEvent.setNeedMaskView(true);
        SimpleEventBus.getInstance().dispatchEvent(qFSShowPersonalPanelEvent);
        adjustMiniPersonPanelPadding(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleShowThankTips$2() {
        if (!isNeedShowTips()) {
            return;
        }
        mc0.a.d(this.mTvThanks.getContext(), com.tencent.biz.qqcircle.utils.h.a(R.string.f19047427)).setAnchor(this.mTvThanks).setAlignment(0).setPosition(3).setOffsetDp(6.0f, 0.0f);
        uq3.k.a().j("qfs_has_show_thank_tips", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initClickListener$0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        jumpPersonPage(view.getContext());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$reBindReportInfo$1() {
        if (this.mItemInfo == null) {
            return;
        }
        RFWLog.d(getLogTag(), RFWLog.USR, "[reBindReportInfo]");
        initDtReport(this.mItemInfo, this.mItemInfo.getStNotice(), this.mItemInfo.getNoticeBusiData());
    }

    private void setIvUserFollow(FeedCloudMeta$StUser feedCloudMeta$StUser, FeedCloudMeta$StNotice feedCloudMeta$StNotice) {
        if (this.mIvUserFollow != null && this.mTvSplitDot != null) {
            if (feedCloudMeta$StNotice != null && feedCloudMeta$StNotice.opMask.get().contains(3) && feedCloudMeta$StUser != null) {
                this.mIvUserFollow.setNeedHandleFollowUpdateEvent(true);
                this.mIvUserFollow.setVisibility(0);
                this.mTvSplitDot.setVisibility(0);
                this.mIvUserFollow.setUserData(feedCloudMeta$StUser);
                return;
            }
            this.mIvUserFollow.setNeedHandleFollowUpdateEvent(false);
            this.mIvUserFollow.setUserData(feedCloudMeta$StUser);
            this.mIvUserFollow.setVisibility(8);
            this.mTvSplitDot.setVisibility(8);
        }
    }

    private void setThanks(FeedCloudMeta$StNotice feedCloudMeta$StNotice, QQCircleFeedBase$StNoticeBusiData qQCircleFeedBase$StNoticeBusiData) {
        if (feedCloudMeta$StNotice.opMask.get().contains(7)) {
            initThanksView();
            updateThanks(feedCloudMeta$StNotice, qQCircleFeedBase$StNoticeBusiData);
            handleShowThankTips();
            return;
        }
        dismissThanksView();
    }

    private void setUserTypeLabel(QQCircleFeedBase$StNoticeBusiData qQCircleFeedBase$StNoticeBusiData) {
        if (qQCircleFeedBase$StNoticeBusiData != null && qQCircleFeedBase$StNoticeBusiData.userTypeLabel.get() != null) {
            super.setUserTypeLabel(this.mTvUserTypeLabel, qQCircleFeedBase$StNoticeBusiData.userTypeLabel.text.get());
        }
    }

    private void updateThanks(FeedCloudMeta$StNotice feedCloudMeta$StNotice, QQCircleFeedBase$StNoticeBusiData qQCircleFeedBase$StNoticeBusiData) {
        if (this.mThanksView == null) {
            QLog.d(getLogTag(), 1, "[updateThanks] mThanksView = null");
            return;
        }
        updateThanksStatus(false, feedCloudMeta$StNotice, qQCircleFeedBase$StNoticeBusiData);
        this.mThanksView.setOnClickListener(new e(qQCircleFeedBase$StNoticeBusiData, feedCloudMeta$StNotice));
        dtReportThanks(feedCloudMeta$StNotice, qQCircleFeedBase$StNoticeBusiData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateThanksStatus(boolean z16, FeedCloudMeta$StNotice feedCloudMeta$StNotice, QQCircleFeedBase$StNoticeBusiData qQCircleFeedBase$StNoticeBusiData) {
        String g06;
        ImageView imageView;
        ImageView imageView2;
        String g07;
        boolean hasMultiPerson = hasMultiPerson(feedCloudMeta$StNotice, qQCircleFeedBase$StNoticeBusiData);
        boolean z17 = qQCircleFeedBase$StNoticeBusiData.thanked.get();
        AnimatorSet animatorSet = this.mThankAnimatorSet;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        if (z17) {
            TextView textView = this.mTvThanks;
            if (hasMultiPerson) {
                g07 = uq3.o.g0("msgAllThanksConfirmTxt");
            } else {
                g07 = uq3.o.g0("msgThankConfirmTxt");
            }
            textView.setText(g07);
        } else {
            TextView textView2 = this.mTvThanks;
            if (hasMultiPerson) {
                g06 = uq3.o.g0("msgAllThanksNoneTxt");
            } else {
                g06 = uq3.o.g0("msgThankNoneTxt");
            }
            textView2.setText(g06);
        }
        if (z17) {
            imageView = this.mThankedIv;
        } else {
            imageView = this.mUnThankIv;
        }
        if (z17) {
            imageView2 = this.mUnThankIv;
        } else {
            imageView2 = this.mThankedIv;
        }
        if (!z16) {
            imageView.setVisibility(0);
            imageView.setAlpha(1.0f);
            imageView2.setVisibility(8);
            imageView2.setAlpha(0.0f);
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView2, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f);
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.mThankAnimatorSet = animatorSet2;
        animatorSet2.setDuration(200L);
        this.mThankAnimatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        this.mThankAnimatorSet.playTogether(ofFloat, ofFloat2);
        this.mThankAnimatorSet.addListener(new f(imageView, imageView2));
        this.mThankAnimatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void appendMessageTimeText(SpannableStringBuilder spannableStringBuilder, FeedCloudMeta$StNotice feedCloudMeta$StNotice) {
        spannableStringBuilder.setSpan(new h(), 0, spannableStringBuilder.length(), 33);
        spannableStringBuilder.append("  ");
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
        spannableStringBuilder2.append((CharSequence) com.tencent.biz.qqcircle.widgets.comment.b.f(feedCloudMeta$StNotice.createTime.get() * 1000));
        spannableStringBuilder2.setSpan(new h(12, QFSQUIUtilsKt.d(RFWApplication.getApplication(), R.color.qui_common_text_secondary_light)), 0, spannableStringBuilder2.length(), 33);
        spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.a
    @CallSuper
    public void bindCustomData(@NonNull QFSMessageItemInfo qFSMessageItemInfo, int i3) {
        FeedCloudMeta$StNotice stNotice = qFSMessageItemInfo.getStNotice();
        if (stNotice != null && stNotice.operation.get() != null) {
            QFSMessageAvatarWrapper qFSMessageAvatarWrapper = this.mAvatarWrap;
            if (qFSMessageAvatarWrapper != null) {
                qFSMessageAvatarWrapper.d(qFSMessageItemInfo, i3);
                this.mAvatarWrap.q(getAvatarClickListener());
                this.mAvatarWrap.u(this.mOnItemLongClickListener);
                this.mAvatarWrap.k(stNotice, getDtReportSubViewParams());
            } else {
                QLog.e(getLogTag(), 1, "bindCustomData mAvatarWrap is null");
            }
            QQCircleFeedBase$StNoticeBusiData noticeBusiData = qFSMessageItemInfo.getNoticeBusiData();
            bindNormalData(stNotice, noticeBusiData, i3);
            initDtReport(qFSMessageItemInfo, stNotice, noticeBusiData);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void consumeItemNewFlag() {
        QFSMessageItemInfo qFSMessageItemInfo = this.mItemInfo;
        if (qFSMessageItemInfo == null) {
            return;
        }
        qFSMessageItemInfo.setConsumed();
        updateBackground(this.mItemInfo);
        QFSMessageAvatarWrapper qFSMessageAvatarWrapper = this.mAvatarWrap;
        if (qFSMessageAvatarWrapper != null) {
            qFSMessageAvatarWrapper.s(this.mItemInfo);
        }
        reBindReportInfo();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View.OnClickListener getAvatarClickListener() {
        if (this.mAvatarClickListener == null) {
            this.mAvatarClickListener = new d();
        }
        return this.mAvatarClickListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View.OnClickListener getContainerClickListener() {
        if (this.mContainerClickListener == null) {
            this.mContainerClickListener = new b();
        }
        return this.mContainerClickListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public QCircleLayerBean getDefaultContentDetailAttrs(View view) {
        try {
            if (this.mItemInfo.getStNotice().feed.get() != null) {
                QCircleLayerBean qCircleLayerBean = new QCircleLayerBean();
                ac.a(this.mItemInfo.getStNotice().feed, 3);
                qCircleLayerBean.setFeed(this.mItemInfo.getStNotice().feed);
                if (QCirclePluginUtil.isOwner(this.mItemInfo.getStNotice().feed.poster)) {
                    qCircleLayerBean.setFromPage(2);
                }
                QCircleExtraTypeInfo qCircleExtraTypeInfo = new QCircleExtraTypeInfo();
                qCircleExtraTypeInfo.sourceType = 1002;
                qCircleLayerBean.setExtraTypeInfo(qCircleExtraTypeInfo);
                qCircleLayerBean.setSingleFeed(true);
                return qCircleLayerBean;
            }
            return null;
        } catch (Exception e16) {
            QLog.e(getLogTag(), 1, "jumpDetailPageError:" + e16.getMessage());
            e16.printStackTrace();
            return null;
        }
    }

    @NonNull
    public Map<String, Object> getDtReportSubViewParams() {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PARENT_EMID, QCircleDaTongConstant.ElementId.EM_XSJ_MSG);
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_MSG_ID, this.mItemInfo.getStNotice().feedId.get());
        return buildElementParams;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QFSLaunchToSelectedEvent.class);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View.OnClickListener getLikeViewClickListener() {
        if (this.mLikeViewClickListener == null) {
            this.mLikeViewClickListener = new c();
        }
        return this.mLikeViewClickListener;
    }

    protected View.OnClickListener getMessageClickListener() {
        return getContainerClickListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public FeedCloudMeta$StReply getReply(FeedCloudMeta$StComment feedCloudMeta$StComment) {
        List<FeedCloudMeta$StReply> list = feedCloudMeta$StComment.vecReply.get();
        if (!RFSafeListUtils.isEmpty(list)) {
            return list.get(list.size() - 1);
        }
        return null;
    }

    protected SpannableStringBuilder getTimeText(FeedCloudMeta$StNotice feedCloudMeta$StNotice) {
        if (feedCloudMeta$StNotice == null) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (!TextUtils.isEmpty(feedCloudMeta$StNotice.typeName.get())) {
            spannableStringBuilder.append((CharSequence) feedCloudMeta$StNotice.typeName.get());
            spannableStringBuilder.append((CharSequence) " ");
            spannableStringBuilder.append((CharSequence) "\u00b7");
            spannableStringBuilder.append((CharSequence) " ");
        }
        spannableStringBuilder.append((CharSequence) com.tencent.biz.qqcircle.widgets.comment.b.f(feedCloudMeta$StNotice.createTime.get() * 1000));
        return spannableStringBuilder;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void gotoProfilerPage(Context context, FeedCloudMeta$StNotice feedCloudMeta$StNotice) {
        if (context != null && feedCloudMeta$StNotice != null) {
            consumeItemNewFlag();
            String str = feedCloudMeta$StNotice.operation.opUser.jumpUrl.get();
            QLog.i(getLogTag(), 1, "avatar click jumpUrl = " + str);
            if (!TextUtils.isEmpty(str)) {
                QFSMessageAvatarWrapper qFSMessageAvatarWrapper = this.mAvatarWrap;
                if (qFSMessageAvatarWrapper != null) {
                    qFSMessageAvatarWrapper.f();
                }
                com.tencent.biz.qqcircle.launcher.c.j(context, feedCloudMeta$StNotice.operation.opUser.jumpUrl.get(), true);
                return;
            }
            jumpPersonPage(context);
            return;
        }
        QLog.e(getLogTag(), 1, "[gotoProfilerPage] context == null || stNotice == null.");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void handleQFSLaunchToSelectedEvent(@NonNull QFSLaunchToSelectedEvent qFSLaunchToSelectedEvent) {
        if (qFSLaunchToSelectedEvent.mLaunchTo == this.mLaunchTo) {
            handleShowThankTips();
        }
        this.mCurrentSelectedType = qFSLaunchToSelectedEvent.mLaunchTo;
    }

    protected void handleRightArrowShow() {
        this.mIvRightArrowLine1.setVisibility(8);
        this.mRightArrow.setVisibility(0);
    }

    protected boolean hasMultiPerson(FeedCloudMeta$StNotice feedCloudMeta$StNotice, QQCircleFeedBase$StNoticeBusiData qQCircleFeedBase$StNoticeBusiData) {
        if (feedCloudMeta$StNotice.vecUser.get().size() > 1) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.a
    protected void initClickListener() {
        View view = this.mContainer;
        if (view != null) {
            view.setOnClickListener(getContainerClickListener());
            this.mContainer.setOnLongClickListener(this.mOnItemLongClickListener);
        }
        TextView textView = this.mTvNick;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.fragments.message.presenter.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    QFSBaseNoticeMessagePresenter.this.lambda$initClickListener$0(view2);
                }
            });
            this.mTvNick.setOnLongClickListener(this.mOnItemLongClickListener);
        }
        QCircleAsyncTextView qCircleAsyncTextView = this.mTvMessage;
        if (qCircleAsyncTextView != null) {
            qCircleAsyncTextView.setOnClickListener(getMessageClickListener());
            this.mTvMessage.setOnLongClickListener(this.mOnItemLongClickListener);
        }
        QCircleAsyncTextView qCircleAsyncTextView2 = this.mSubMessage;
        if (qCircleAsyncTextView2 != null) {
            qCircleAsyncTextView2.setOnClickListener(getContainerClickListener());
            this.mSubMessage.setOnLongClickListener(this.mOnItemLongClickListener);
        }
        ImageView imageView = this.mRightArrow;
        if (imageView != null) {
            imageView.setOnClickListener(getContainerClickListener());
            this.mRightArrow.setOnLongClickListener(this.mOnItemLongClickListener);
        }
        QCircleAsyncTextView qCircleAsyncTextView3 = this.mSummery;
        if (qCircleAsyncTextView3 != null) {
            qCircleAsyncTextView3.setOnClickListener(getContainerClickListener());
            this.mSummery.setOnLongClickListener(this.mOnItemLongClickListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.a
    @CallSuper
    public void initCustomView(Context context, @NonNull View view) {
        this.mLLNickIcon = view.findViewById(R.id.ypk);
        this.mTvNick = (TextView) view.findViewById(R.id.mdg);
        this.mMessageContainer = (ConstraintLayout) view.findViewById(R.id.z5c);
        this.mAvatarListView = (QCircleAvatarListView) view.findViewById(R.id.f46811vl);
        this.mTvMessage = (QCircleAsyncTextView) view.findViewById(R.id.f109306fg);
        this.mIvRightArrowLine1 = (ImageView) view.findViewById(R.id.f165906y05);
        this.mTvTime = (TextView) view.findViewById(R.id.f109336fj);
        this.mContentContainer = view.findViewById(R.id.yp7);
        this.mSubMessageContainer = (LinearLayout) view.findViewById(R.id.f902151v);
        this.mSubMessage = (QCircleAsyncTextView) view.findViewById(R.id.f111576ll);
        this.mRightArrow = (ImageView) view.findViewById(R.id.dtx);
        this.mSummery = (QCircleAsyncTextView) view.findViewById(R.id.f109326fi);
        this.mSummeryContainer = view.findViewById(R.id.z5l);
        this.mIvUserFollow = (QFSFollowView) view.findViewById(R.id.f112286ni);
        this.mTvUserTypeLabel = (TextView) view.findViewById(R.id.f112326nm);
        this.mTvSplitDot = (TextView) view.findViewById(R.id.f111446l9);
        QFSMessageAvatarWrapper qFSMessageAvatarWrapper = this.mAvatarWrap;
        if (qFSMessageAvatarWrapper != null) {
            qFSMessageAvatarWrapper.j(context, view);
        } else {
            QLog.e(getLogTag(), 1, "initCustomView mAvatarWrap is null");
        }
        if (this.mCommentCoverWrap == null) {
            this.mCommentCoverWrap = new n30.c(this.mViewType, view);
        }
        setAtStyle(this.mSummery, QFSQUIUtilsKt.d(RFWApplication.getApplication(), R.color.qui_common_text_secondary), false);
        setAtStyle(this.mSubMessage, QFSQUIUtilsKt.d(RFWApplication.getApplication(), R.color.qui_common_text_primary), true);
        setLabelBackground(this.mTvUserTypeLabel, 4.0f);
        adjustAvatarSize();
        adjustTxtColor();
        adjustNickSize();
        setTouchLister(this.mTvMessage);
        setTouchLister(this.mSubMessage);
        setTouchLister(this.mSummery);
        setTouchLister(this.mRightArrow);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initDtReport(QFSMessageItemInfo qFSMessageItemInfo, FeedCloudMeta$StNotice feedCloudMeta$StNotice, QQCircleFeedBase$StNoticeBusiData qQCircleFeedBase$StNoticeBusiData) {
        String str;
        Object obj;
        if (feedCloudMeta$StNotice != null && qQCircleFeedBase$StNoticeBusiData != null) {
            QCircleReportBean reportBean = getReportBean();
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_MSG_ID, feedCloudMeta$StNotice.feedId.get());
            int i3 = 0;
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_IF_PRIVATE_LETTER, 0);
            buildElementParams.put("xsj_target_qq", feedCloudMeta$StNotice.operation.opUser.f398463id.get());
            q.r().l(feedCloudMeta$StNotice, buildElementParams);
            if (qFSMessageItemInfo != null) {
                String str2 = "1";
                if (qFSMessageItemInfo.canShowNoAnimHighLight()) {
                    obj = "1";
                } else {
                    obj = "0";
                }
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_IS_HIGH_LIGHT, obj);
                if (!qFSMessageItemInfo.hasShowApertureAnim() || qFSMessageItemInfo.hasConsumeAperture()) {
                    str2 = "0";
                }
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_IS_APERTURE, str2);
            }
            if (reportBean != null && QCircleDaTongConstant.PageId.PG_XSJ_NEW_MESSAGE_PAGE.equals(reportBean.getDtPageId())) {
                if (qQCircleFeedBase$StNoticeBusiData.messageBoxRedPointInfo.needShow.get()) {
                    i3 = 2;
                }
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_REDDOT_TYPE, Integer.valueOf(i3));
                buildElementParams.put("xsj_reddot_number", Integer.valueOf(qQCircleFeedBase$StNoticeBusiData.messageBoxRedPointInfo.needShow.get() ? 1 : 0));
                str = QCircleDaTongConstant.ElementId.EM_XSJ_OTHER_MSG_ENTRANCE;
            } else {
                str = QCircleDaTongConstant.ElementId.EM_XSJ_MSG;
            }
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_MSG_TYPE, Integer.valueOf(feedCloudMeta$StNotice.noticeType.get()));
            VideoReport.setElementId(this.mContainer, str);
            VideoReport.setElementParams(this.mContainer, buildElementParams);
            VideoReport.setElementReuseIdentifier(this.mContainer, feedCloudMeta$StNotice.operation.opUser.f398463id.get() + "_" + feedCloudMeta$StNotice.createTime.get());
            VideoReport.setElementId(this.mMessageContainer, QCircleDaTongConstant.ElementId.EM_XSJ_CONTENT_SKIP);
            Map<String, Object> buildElementParams2 = new QCircleDTParamBuilder().buildElementParams();
            int i16 = feedCloudMeta$StNotice.noticeType.get();
            if (i16 != 0) {
                if (i16 != 23) {
                    if (i16 != 6 && i16 != 7) {
                        switch (i16) {
                            case 19:
                                buildElementParams2.put(QCircleDaTongConstant.ElementParamKey.XSJ_SKIP_PG_TYPE, 3);
                                break;
                            case 20:
                                buildElementParams2.put(QCircleDaTongConstant.ElementParamKey.XSJ_SKIP_PG_TYPE, 4);
                                break;
                            case 21:
                                buildElementParams2.put(QCircleDaTongConstant.ElementParamKey.XSJ_SKIP_PG_TYPE, 5);
                                break;
                        }
                    } else {
                        buildElementParams2.put(QCircleDaTongConstant.ElementParamKey.XSJ_SKIP_PG_TYPE, 2);
                    }
                } else {
                    buildElementParams2.put(QCircleDaTongConstant.ElementParamKey.XSJ_SKIP_PG_TYPE, 6);
                }
            } else {
                buildElementParams2.put(QCircleDaTongConstant.ElementParamKey.XSJ_SKIP_PG_TYPE, 1);
            }
            VideoReport.setElementParams(this.mMessageContainer, buildElementParams2);
            VideoReport.setElementId(this.mTvNick, QCircleDaTongConstant.ElementId.EM_XSJ_HANDLE_NAME);
            VideoReport.setElementReuseIdentifier(this.mTvNick, feedCloudMeta$StNotice.operation.opUser.nick.get());
            return;
        }
        QLog.e(getLogTag(), 1, "initDtReport stNotice == null || stNoticeBusiData == null");
    }

    protected boolean isNeedShowTips() {
        int i3 = this.mCurrentSelectedType;
        if ((i3 == -1 || i3 == this.mLaunchTo) && this.mLastPos == 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isResumePage() {
        if (this.mCurrentSelectedType == this.mLaunchTo) {
            return true;
        }
        return false;
    }

    protected boolean isShowBottomOperationArea(FeedCloudMeta$StNotice feedCloudMeta$StNotice) {
        return false;
    }

    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.a
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        n30.c cVar = this.mCommentCoverWrap;
        if (cVar != null) {
            cVar.f();
        }
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.a
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSLaunchToSelectedEvent) {
            handleQFSLaunchToSelectedEvent((QFSLaunchToSelectedEvent) simpleBaseEvent);
        }
    }

    protected void reBindReportInfo() {
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.fragments.message.presenter.c
            @Override // java.lang.Runnable
            public final void run() {
                QFSBaseNoticeMessagePresenter.this.lambda$reBindReportInfo$1();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void reportClickEvent(final View view) {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.fragments.message.presenter.QFSBaseNoticeMessagePresenter.7
            @Override // java.lang.Runnable
            public void run() {
                View view2 = view;
                if (view2 == null) {
                    return;
                }
                if (view2.getId() == R.id.f109326fi) {
                    VideoReport.setElementId(QFSBaseNoticeMessagePresenter.this.mSummery, QCircleDaTongConstant.ElementId.EM_XSJ_MSG_QUOTE_CONTEXT);
                    VideoReport.reportEvent("ev_xsj_abnormal_clck", QFSBaseNoticeMessagePresenter.this.mSummery, new QCircleDTParamBuilder().buildElementParams());
                    return;
                }
                if (view.getId() == R.id.f109306fg || view.getId() == R.id.f111576ll) {
                    VideoReport.setElementId(QFSBaseNoticeMessagePresenter.this.mTvMessage, QCircleDaTongConstant.ElementId.EM_XSJ_MSG_CONTEXT);
                    Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
                    QCircleAsyncTextView qCircleAsyncTextView = QFSBaseNoticeMessagePresenter.this.mSummery;
                    if (qCircleAsyncTextView != null && qCircleAsyncTextView.getVisibility() == 0) {
                        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_MSG_IF_QUOTE_CONTEXT, 1);
                    } else {
                        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_MSG_IF_QUOTE_CONTEXT, 0);
                    }
                    VideoReport.reportEvent("ev_xsj_abnormal_clck", QFSBaseNoticeMessagePresenter.this.mTvMessage, buildElementParams);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void reportImpEvent(final View view) {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.fragments.message.presenter.QFSBaseNoticeMessagePresenter.10
            @Override // java.lang.Runnable
            public void run() {
                View view2 = view;
                if (view2 == null) {
                    return;
                }
                VideoReport.setElementId(view2, QCircleDaTongConstant.ElementId.EM_XSJ_MSG_CONTEXT);
                Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
                QCircleAsyncTextView qCircleAsyncTextView = QFSBaseNoticeMessagePresenter.this.mSummery;
                if (qCircleAsyncTextView != null && qCircleAsyncTextView.getVisibility() == 0) {
                    buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_MSG_IF_QUOTE_CONTEXT, 1);
                } else {
                    buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_MSG_IF_QUOTE_CONTEXT, 0);
                }
                VideoReport.setElementParams(view, buildElementParams);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setAtStyle(QCircleAsyncTextView qCircleAsyncTextView, int i3, boolean z16) {
        if (qCircleAsyncTextView == null) {
            return;
        }
        qCircleAsyncTextView.setSpecialClickAreaColor(i3, true);
        qCircleAsyncTextView.setNeedSpecialAreaBold(z16);
        qCircleAsyncTextView.setOnClickAtTextListener(new a(qCircleAsyncTextView));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setContent(FeedCloudMeta$StNotice feedCloudMeta$StNotice) {
        String str = feedCloudMeta$StNotice.message.get();
        if (TextUtils.isEmpty(str)) {
            this.mMessageContainer.setVisibility(8);
            return;
        }
        this.mMessageContainer.setVisibility(0);
        this.mTvMessage.setText(str);
        reportImpEvent(this.mTvMessage);
    }

    protected void setSubContent(String str) {
        if (TextUtils.isEmpty(str)) {
            this.mSubMessageContainer.setVisibility(8);
            return;
        }
        this.mSubMessageContainer.setVisibility(0);
        this.mSubMessage.setText(str.trim());
        reportImpEvent(this.mSubMessage);
    }

    protected void setSummery(String str) {
        if (TextUtils.isEmpty(str)) {
            this.mSummeryContainer.setVisibility(8);
            return;
        }
        this.mSummeryContainer.setVisibility(0);
        this.mSummery.setText(str);
        reportImpEvent(this.mSummery);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setTime(FeedCloudMeta$StNotice feedCloudMeta$StNotice) {
        TextView textView = this.mTvTime;
        if (textView == null) {
            QLog.e(getLogTag(), 1, "[setTime] mTvTime == null");
        } else {
            textView.setVisibility(0);
            this.mTvTime.setText(getTimeText(feedCloudMeta$StNotice));
        }
    }

    /* loaded from: classes4.dex */
    public static class h extends ReplacementSpan {

        /* renamed from: d, reason: collision with root package name */
        private int f84472d;

        /* renamed from: e, reason: collision with root package name */
        private int f84473e;

        public h() {
            this.f84472d = -1;
            this.f84473e = -1;
        }

        private TextPaint a(Paint paint) {
            TextPaint textPaint = new TextPaint(paint);
            if (this.f84472d != -1) {
                textPaint.setTextSize(cx.a(r3));
            }
            int i3 = this.f84473e;
            if (i3 != -1) {
                textPaint.setColor(i3);
            }
            return textPaint;
        }

        @Override // android.text.style.ReplacementSpan
        public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i3, int i16, float f16, int i17, int i18, int i19, @NonNull Paint paint) {
            TextPaint a16 = a(paint);
            Paint.FontMetricsInt fontMetricsInt = a16.getFontMetricsInt();
            canvas.drawText(charSequence, i3, i16, f16, i18 - (((((fontMetricsInt.ascent + i18) + i18) + fontMetricsInt.descent) / 2) - ((i17 + i19) / 2)), a16);
        }

        @Override // android.text.style.ReplacementSpan
        public int getSize(@NonNull Paint paint, CharSequence charSequence, int i3, int i16, @Nullable Paint.FontMetricsInt fontMetricsInt) {
            return (int) a(paint).measureText(charSequence, i3, i16);
        }

        public h(int i3, int i16) {
            this.f84472d = i3;
            this.f84473e = i16;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class f implements Animator.AnimatorListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f84467d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f84468e;

        f(View view, View view2) {
            this.f84467d = view;
            this.f84468e = view2;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            View view = this.f84468e;
            if (view != null) {
                view.setVisibility(8);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            View view = this.f84468e;
            if (view != null) {
                view.setVisibility(8);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            View view = this.f84467d;
            if (view != null) {
                view.setVisibility(0);
            }
            View view2 = this.f84468e;
            if (view2 != null) {
                view2.setVisibility(0);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }
}
