package com.tencent.biz.qqcircle.fragments.message.presenter;

import android.content.Context;
import android.text.TextUtils;
import android.util.Size;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qcircleshadow.lib.variation.HostChatUtils;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.beans.QFSMessageItemInfo;
import com.tencent.biz.qqcircle.helpers.q;
import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.biz.qqcircle.requests.QCircleUnReadPointRequest;
import com.tencent.biz.qqcircle.richframework.widget.drag.DragTextView;
import com.tencent.biz.qqcircle.utils.QFSMessageAvatarWrapper;
import com.tencent.biz.qqcircle.utils.ac;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StNotice;
import feedcloud.FeedCloudRead$StClearRedPointRsp;
import java.util.Map;
import qqcircle.QQCircleBase$StUserBusiData;
import qqcircle.QQCircleCounterMsg$MergePsvRedPoint;
import qqcircle.QQCircleFeedBase$StNoticeBusiData;

/* loaded from: classes4.dex */
public class QFSBaseNormalMessagePresenter extends com.tencent.biz.qqcircle.fragments.message.presenter.a {
    private static final int DELAY_DISMISS_RED_POINT = 200;
    private static final String TAG = "QFSBaseNormalMessagePresenter";
    private static final String UNDERSCORE = "_";
    protected View.OnClickListener mAvatarClickListener;
    protected QFSMessageAvatarWrapper mAvatarWrap;
    protected Size mDefAvatarSize;
    protected ImageView mIvIcon;
    private boolean mLastDataFromCache;
    protected View mLlRightNext;
    protected View mLlRightRedDot;
    protected View mLlRightRedPoint;
    protected LinearLayout mMessageContainer;
    protected LinearLayout mRightContainer;
    protected QCircleAsyncTextView mTvMessage;
    protected TextView mTvMessageCount;
    protected TextView mTvNick;
    protected DragTextView mTvRedPointNum;
    protected TextView mTvTime;
    protected TextView mTvUserTypeLabel;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QFSBaseNormalMessagePresenter.this.handleContainerClick(view);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public QFSBaseNormalMessagePresenter(int i3) {
        super(i3);
        this.mLastDataFromCache = false;
        this.mAvatarWrap = new QFSMessageAvatarWrapper(i3);
    }

    private Map<String, Object> getItemReportParams(@NonNull FeedCloudMeta$StNotice feedCloudMeta$StNotice) {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_MSG_ID, feedCloudMeta$StNotice.feedId.get());
        buildElementParams.put("xsj_target_qq", feedCloudMeta$StNotice.operation.opUser.f398463id.get());
        q.r().l(feedCloudMeta$StNotice, buildElementParams);
        QQCircleCounterMsg$MergePsvRedPoint z16 = q.r().z(feedCloudMeta$StNotice.feedId.get());
        if (z16 == null) {
            z16 = new QQCircleCounterMsg$MergePsvRedPoint();
        }
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_REDDOT_TYPE, Integer.valueOf(z16.type.get()));
        buildElementParams.put("xsj_reddot_number", Integer.valueOf(z16.num.get()));
        return buildElementParams;
    }

    private void resetRightView() {
        View view = this.mLlRightNext;
        if (view != null && this.mLlRightRedDot != null && this.mLlRightRedPoint != null) {
            view.setVisibility(8);
            this.mLlRightRedDot.setVisibility(8);
            this.mLlRightRedPoint.setVisibility(8);
            return;
        }
        QLog.e(getLogTag(), 1, "resetRightView view is null");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.a
    public void bindCustomData(@NonNull QFSMessageItemInfo qFSMessageItemInfo, int i3) {
        FeedCloudMeta$StNotice stNotice = qFSMessageItemInfo.getStNotice();
        if (stNotice == null) {
            QLog.e(getLogTag(), 1, "bindCustomData stNotice is null");
            return;
        }
        setAvatarView(qFSMessageItemInfo, i3);
        setNickView(stNotice);
        setMessageView(stNotice);
        setTimeView(stNotice);
        setRightView(stNotice);
        QQCircleFeedBase$StNoticeBusiData noticeBusiData = qFSMessageItemInfo.getNoticeBusiData();
        if (noticeBusiData != null && noticeBusiData.userTypeLabel.get() != null) {
            setUserTypeLabel(this.mTvUserTypeLabel, noticeBusiData.userTypeLabel.text.get());
        }
        reportDT(stNotice);
    }

    protected View.OnClickListener getAvatarClickListener() {
        return getContainerClickListener();
    }

    protected View.OnClickListener getContainerClickListener() {
        if (this.mContainerClickListener == null) {
            this.mContainerClickListener = new a();
        }
        return this.mContainerClickListener;
    }

    protected QCircleLayerBean getDefaultLaunchLayerBean(View view) {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        QFSMessageItemInfo qFSMessageItemInfo = this.mItemInfo;
        if (qFSMessageItemInfo == null) {
            return null;
        }
        try {
            if (qFSMessageItemInfo.getStNotice() == null) {
                feedCloudMeta$StFeed = null;
            } else {
                feedCloudMeta$StFeed = this.mItemInfo.getStNotice().feed.get();
            }
            if (feedCloudMeta$StFeed != null) {
                QCircleLayerBean qCircleLayerBean = new QCircleLayerBean();
                ac.a(feedCloudMeta$StFeed, 3);
                qCircleLayerBean.setFeed(feedCloudMeta$StFeed);
                if (QCirclePluginUtil.isOwner(feedCloudMeta$StFeed.poster)) {
                    qCircleLayerBean.setFromPage(2);
                }
                QCircleExtraTypeInfo qCircleExtraTypeInfo = new QCircleExtraTypeInfo();
                qCircleExtraTypeInfo.sourceType = 1002;
                qCircleLayerBean.setExtraTypeInfo(qCircleExtraTypeInfo);
                qCircleLayerBean.setSingleFeed(true);
                qCircleLayerBean.setFromReportBean(getReportBean().m466clone());
                return qCircleLayerBean;
            }
        } catch (Exception e16) {
            QLog.e(getLogTag(), 1, "jumpDetailPageError:" + e16.getMessage());
            e16.printStackTrace();
        }
        return null;
    }

    protected String getElementId() {
        return QCircleDaTongConstant.ElementId.EM_XSJ_OTHER_MSG_ENTRANCE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.a
    public String getLogTag() {
        return TAG;
    }

    protected View.OnClickListener getMessageClickListener() {
        return getContainerClickListener();
    }

    protected int getRemoveRedPointPageType() {
        return 22;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void handleAvatarClick(View view) {
        FeedCloudMeta$StNotice stNotice = this.mItemInfo.getStNotice();
        if (stNotice != null && !TextUtils.isEmpty(stNotice.operation.opUser.f398463id.get())) {
            if (view.getId() == R.id.f165909du3) {
                QFSMessageAvatarWrapper qFSMessageAvatarWrapper = this.mAvatarWrap;
                if (qFSMessageAvatarWrapper != null) {
                    qFSMessageAvatarWrapper.e();
                }
                QQCircleBase$StUserBusiData userBusiData = this.mItemInfo.getUserBusiData();
                if (userBusiData != null) {
                    userBusiData.has_unread_feed.set(false);
                }
            }
            QCircleInitBean qCircleInitBean = new QCircleInitBean();
            qCircleInitBean.setUin(stNotice.operation.opUser.f398463id.get());
            qCircleInitBean.setFromReportBean(getReportBean().m466clone());
            if (this.mItemInfo.getApertureExposeFeed() != null) {
                qCircleInitBean.setFeed(this.mItemInfo.getApertureExposeFeed());
                this.mItemInfo.setApertureExposeFeed(null);
            }
            String str = stNotice.operation.opUser.jumpUrl.get();
            QLog.i(getLogTag(), 1, "[handleAvatarClick] avatar click jumpUrl = " + str);
            if (!TextUtils.isEmpty(str)) {
                QFSMessageAvatarWrapper qFSMessageAvatarWrapper2 = this.mAvatarWrap;
                if (qFSMessageAvatarWrapper2 != null) {
                    qFSMessageAvatarWrapper2.f();
                }
                com.tencent.biz.qqcircle.launcher.c.j(view.getContext(), str, true);
                return;
            }
            com.tencent.biz.qqcircle.launcher.c.d0(view.getContext(), qCircleInitBean);
            return;
        }
        QLog.e(getLogTag(), 1, "[handleAvatarClick] notice or opUser.id is null");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void handleContainerClick(View view) {
        QCircleLayerBean defaultLaunchLayerBean = getDefaultLaunchLayerBean(view);
        if (defaultLaunchLayerBean != null) {
            com.tencent.biz.qqcircle.launcher.c.u(view.getContext(), defaultLaunchLayerBean);
            removeRedPoint();
        }
    }

    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.a
    protected void initClickListener() {
        View view = this.mContainer;
        if (view != null) {
            view.setOnClickListener(getContainerClickListener());
            this.mContainer.setOnLongClickListener(this.mOnItemLongClickListener);
        }
        QCircleAsyncTextView qCircleAsyncTextView = this.mTvMessage;
        if (qCircleAsyncTextView != null) {
            qCircleAsyncTextView.setOnClickListener(getMessageClickListener());
            this.mTvMessage.setOnLongClickListener(this.mOnItemLongClickListener);
        }
        QFSMessageAvatarWrapper qFSMessageAvatarWrapper = this.mAvatarWrap;
        if (qFSMessageAvatarWrapper != null) {
            qFSMessageAvatarWrapper.q(getAvatarClickListener());
            this.mAvatarWrap.u(this.mOnItemLongClickListener);
        }
    }

    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.a
    protected void initCustomView(Context context, @NonNull View view) {
        this.mIvIcon = (ImageView) view.findViewById(R.id.dvu);
        this.mTvNick = (TextView) view.findViewById(R.id.mdg);
        this.mTvUserTypeLabel = (TextView) view.findViewById(R.id.f112326nm);
        this.mTvTime = (TextView) view.findViewById(R.id.f109336fj);
        this.mMessageContainer = (LinearLayout) view.findViewById(R.id.z5c);
        this.mTvMessage = (QCircleAsyncTextView) view.findViewById(R.id.f109306fg);
        this.mTvMessageCount = (TextView) view.findViewById(R.id.f109296ff);
        this.mRightContainer = (LinearLayout) view.findViewById(R.id.i_z);
        this.mLlRightNext = view.findViewById(R.id.yqe);
        this.mLlRightRedDot = view.findViewById(R.id.yqf);
        this.mLlRightRedPoint = view.findViewById(R.id.yqg);
        this.mTvRedPointNum = (DragTextView) view.findViewById(R.id.f110576iw);
        this.mDefAvatarSize = com.tencent.biz.qqcircle.immersive.utils.n.a(context, R.dimen.d3c);
        QFSMessageAvatarWrapper qFSMessageAvatarWrapper = this.mAvatarWrap;
        if (qFSMessageAvatarWrapper != null) {
            qFSMessageAvatarWrapper.j(context, view);
            this.mAvatarWrap.y(com.tencent.biz.qqcircle.immersive.utils.n.a(context, R.dimen.d3c));
        } else {
            QLog.e(getLogTag(), 1, "initCustomView mAvatarWrap is null");
        }
        setTouchLister(this.mTvMessage);
        setLabelBackground(this.mTvUserTypeLabel, 2.0f);
    }

    protected boolean isNeedShowAvatarLivingStatus(@NonNull QFSMessageItemInfo qFSMessageItemInfo) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void removeRedPoint() {
        RFWThreadManager.getInstance().postMainDelay(new Runnable() { // from class: com.tencent.biz.qqcircle.fragments.message.presenter.QFSBaseNormalMessagePresenter.3

            /* renamed from: com.tencent.biz.qqcircle.fragments.message.presenter.QFSBaseNormalMessagePresenter$3$a */
            /* loaded from: classes4.dex */
            class a implements VSDispatchObserver.OnVSRspCallBack<FeedCloudRead$StClearRedPointRsp> {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ QCircleBaseRequest f84452a;

                a(QCircleBaseRequest qCircleBaseRequest) {
                    this.f84452a = qCircleBaseRequest;
                }

                @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudRead$StClearRedPointRsp feedCloudRead$StClearRedPointRsp) {
                    QLog.i(QFSBaseNormalMessagePresenter.this.getLogTag(), 1, "traceId:" + this.f84452a.getTraceId() + " isSuccess:" + z16 + " errorCode" + j3 + " err:" + str);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                FeedCloudMeta$StNotice stNotice;
                QFSMessageItemInfo qFSMessageItemInfo = QFSBaseNormalMessagePresenter.this.mItemInfo;
                if (qFSMessageItemInfo == null) {
                    stNotice = null;
                } else {
                    stNotice = qFSMessageItemInfo.getStNotice();
                }
                if (stNotice == null) {
                    return;
                }
                q.r().P(stNotice.feedId.get());
                QFSBaseNormalMessagePresenter.this.setRightView(stNotice);
                if (QFSBaseNormalMessagePresenter.this.getRemoveRedPointPageType() == 0) {
                    return;
                }
                QCircleUnReadPointRequest qCircleUnReadPointRequest = new QCircleUnReadPointRequest(stNotice.feedId.get(), QFSBaseNormalMessagePresenter.this.getRemoveRedPointPageType(), q.r().B());
                VSNetworkHelper.getInstance().sendRequest(qCircleUnReadPointRequest, new a(qCircleUnReadPointRequest));
            }
        }, 200L);
    }

    protected void reportDT(FeedCloudMeta$StNotice feedCloudMeta$StNotice) {
        if (this.mContainer != null && feedCloudMeta$StNotice != null) {
            if (q.r().E()) {
                this.mLastDataFromCache = true;
                return;
            }
            VideoReport.setElementId(this.mContainer, getElementId());
            VideoReport.setElementParams(this.mContainer, getItemReportParams(feedCloudMeta$StNotice));
            VideoReport.setElementReuseIdentifier(this.mContainer, feedCloudMeta$StNotice.noticeType.get() + "_" + feedCloudMeta$StNotice.operation.opUser.f398463id.get());
            VideoReport.setElementId(this.mTvMessage, getElementId());
            VideoReport.setElementParams(this.mTvMessage, getItemReportParams(feedCloudMeta$StNotice));
            VideoReport.setElementReuseIdentifier(this.mTvMessage, feedCloudMeta$StNotice.noticeType.get() + "_" + feedCloudMeta$StNotice.operation.opUser.f398463id.get());
            VideoReport.setElementExposePolicy(this.mTvMessage, ExposurePolicy.REPORT_NONE);
            if (this.mLastDataFromCache) {
                RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.biz.qqcircle.fragments.message.presenter.QFSBaseNormalMessagePresenter.1
                    @Override // java.lang.Runnable
                    public void run() {
                        VideoReport.traversePage(QFSBaseNormalMessagePresenter.this.mContainer);
                    }
                });
            }
            this.mLastDataFromCache = false;
        }
    }

    protected void setAvatarView(@NonNull QFSMessageItemInfo qFSMessageItemInfo, int i3) {
        QFSMessageAvatarWrapper qFSMessageAvatarWrapper = this.mAvatarWrap;
        if (qFSMessageAvatarWrapper == null) {
            QLog.e(getLogTag(), 1, "[setAvatarView] mAvatarWrap == null");
        } else {
            qFSMessageAvatarWrapper.z(isNeedShowAvatarLivingStatus(qFSMessageItemInfo));
            this.mAvatarWrap.d(qFSMessageItemInfo, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setMessageView(@NonNull FeedCloudMeta$StNotice feedCloudMeta$StNotice) {
        QCircleAsyncTextView qCircleAsyncTextView = this.mTvMessage;
        if (qCircleAsyncTextView != null) {
            qCircleAsyncTextView.setText(feedCloudMeta$StNotice.message.get());
            this.mTvMessage.setTextColor(RFWApplication.getApplication().getResources().getColorStateList(R.color.qui_common_text_secondary));
        }
    }

    protected void setNickView(@NonNull FeedCloudMeta$StNotice feedCloudMeta$StNotice) {
        TextView textView = this.mTvNick;
        if (textView != null) {
            textView.setText(feedCloudMeta$StNotice.operation.opUser.nick.get());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean setRightView(@NonNull FeedCloudMeta$StNotice feedCloudMeta$StNotice) {
        resetRightView();
        QQCircleCounterMsg$MergePsvRedPoint z16 = q.r().z(feedCloudMeta$StNotice.feedId.get());
        if (z16 == null) {
            return false;
        }
        int i3 = z16.num.get();
        QLog.d(getLogTag(), 1, "[setRightView] num:" + i3 + " | type:" + z16.type.get());
        int i16 = z16.type.get();
        if (i16 != 1) {
            if (i16 == 2 && i3 > 0) {
                this.mLlRightRedDot.setVisibility(0);
                return true;
            }
        } else if (i3 > 0) {
            this.mLlRightRedPoint.setVisibility(0);
            this.mTvRedPointNum.setText(HostChatUtils.getMaxUnReadCountText(i3));
            return true;
        }
        return false;
    }

    protected void setTimeView(@NonNull FeedCloudMeta$StNotice feedCloudMeta$StNotice) {
        if (this.mTvTime == null) {
            return;
        }
        if (!feedCloudMeta$StNotice.createTime.has()) {
            QLog.e(getLogTag(), 1, "[setTimeView] createTime is empty");
            this.mTvTime.setVisibility(8);
        }
        this.mTvTime.setVisibility(0);
        this.mTvTime.setText(com.tencent.biz.qqcircle.widgets.comment.b.f(feedCloudMeta$StNotice.createTime.get() * 1000));
    }
}
