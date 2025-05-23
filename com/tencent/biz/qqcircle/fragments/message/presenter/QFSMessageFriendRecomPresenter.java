package com.tencent.biz.qqcircle.fragments.message.presenter;

import android.animation.Animator;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Size;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.beans.QFSFollowRecommendParseInfo;
import com.tencent.biz.qqcircle.beans.QFSMessageItemInfo;
import com.tencent.biz.qqcircle.events.QFSLocateHighlightEvent;
import com.tencent.biz.qqcircle.events.QFSMessageFriendRecomItemRemoveEvent;
import com.tencent.biz.qqcircle.helpers.q;
import com.tencent.biz.qqcircle.immersive.events.QFSShowPersonalPanelEvent;
import com.tencent.biz.qqcircle.immersive.utils.r;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarListView;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.qqcircle.widgets.QFSFollowView;
import com.tencent.biz.qqcircle.widgets.aa;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.utils.QCircleHostUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StNotice;
import feedcloud.FeedCloudMeta$StUser;
import java.util.ArrayList;
import java.util.Map;
import qqcircle.QQCircleBase$StUserBusiData;

/* loaded from: classes4.dex */
public class QFSMessageFriendRecomPresenter extends com.tencent.biz.qqcircle.fragments.message.presenter.a implements View.OnClickListener, SimpleEventReceiver {
    private static final String TAG = "QFSMessageFriendRecomPresenter";
    private static final String UNDERSCORE = "_";
    private QCircleAvatarListView mAvatarListView;
    private QCircleAvatarView mAvatarView;
    private View mBgView;
    private Size mDefAvatarSize;
    private QFSFollowView mFollow;
    private boolean mIsPlayingHighLightAnim;
    private QFSMessageItemInfo mItemInfo;
    private View mMiniPersonaPanelView;
    private String mShowRecomReason;
    private TextView mTvDesc;
    private TextView mTvNick;
    private View mTvShield;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FeedCloudMeta$StUser feedCloudMeta$StUser;
            int i3;
            EventCollector.getInstance().onViewClickedBefore(view);
            if (view != null) {
                if (QFSMessageFriendRecomPresenter.this.mItemInfo != null && QFSMessageFriendRecomPresenter.this.mItemInfo.getStNotice() != null) {
                    feedCloudMeta$StUser = QFSMessageFriendRecomPresenter.this.mItemInfo.getStNotice().operation.opUser.get();
                } else {
                    feedCloudMeta$StUser = null;
                }
                if (feedCloudMeta$StUser != null) {
                    String str = feedCloudMeta$StUser.jumpUrl.get();
                    QLog.i(QFSMessageFriendRecomPresenter.this.getLogTag(), 1, "containerClick jumpUrl = " + str);
                    if (TextUtils.isEmpty(str)) {
                        QFSMessageFriendRecomPresenter.this.jumpPersonPage(view.getContext(), feedCloudMeta$StUser);
                    } else {
                        com.tencent.biz.qqcircle.launcher.c.j(view.getContext(), str, true);
                    }
                    if (view.getId() == R.id.f165909du3) {
                        i3 = 10;
                    } else if (view.getId() == R.id.mdg) {
                        i3 = 11;
                    } else {
                        i3 = 0;
                    }
                    if (i3 != 0) {
                        QFSMessageFriendRecomPresenter.this.reportDc05507(608, i3);
                    }
                    QFSMessageFriendRecomPresenter qFSMessageFriendRecomPresenter = QFSMessageFriendRecomPresenter.this;
                    View view2 = qFSMessageFriendRecomPresenter.mContainer;
                    if (view != view2) {
                        VideoReport.reportEvent("dt_clck", view2, qFSMessageFriendRecomPresenter.getDtReportParams(qFSMessageFriendRecomPresenter.mItemInfo.getStNotice()));
                    }
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public QFSMessageFriendRecomPresenter(int i3) {
        super(i3);
    }

    private void adjustMiniPersonPanelPadding(Context context) {
        if (this.mMiniPersonaPanelView == null && (context instanceof Activity)) {
            View findViewById = ((Activity) context).findViewById(R.id.f485820d);
            this.mMiniPersonaPanelView = findViewById;
            m30.a.a(findViewById);
        }
    }

    private View.OnClickListener getContainerClickListener() {
        if (this.mContainerClickListener == null) {
            this.mContainerClickListener = new b();
        }
        return this.mContainerClickListener;
    }

    private String getContainerElementId() {
        int type;
        QFSMessageItemInfo qFSMessageItemInfo = this.mItemInfo;
        if (qFSMessageItemInfo == null) {
            type = -104;
        } else {
            type = qFSMessageItemInfo.getType();
        }
        if (type == -104) {
            return QCircleDaTongConstant.ElementId.EM_XSJ_FRIEND_RECOMMEND_ITEM;
        }
        return QCircleDaTongConstant.ElementId.EM_XSJ_FOLLOW_MODULE_USER_INFO;
    }

    private String getFollowButtonElementId() {
        int type;
        QFSMessageItemInfo qFSMessageItemInfo = this.mItemInfo;
        if (qFSMessageItemInfo == null) {
            type = -104;
        } else {
            type = qFSMessageItemInfo.getType();
        }
        if (type == -104) {
            return QCircleDaTongConstant.ElementId.EM_XSJ_FOLLOW_BUTTON;
        }
        return QCircleDaTongConstant.ElementId.EM_XSJ_PYMK_ITEM;
    }

    private void handleClickShield() {
        SimpleEventBus.getInstance().dispatchEvent(new QFSMessageFriendRecomItemRemoveEvent(this.mLastPos));
        reportDc05507(609, 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jumpPersonPage(Context context, FeedCloudMeta$StUser feedCloudMeta$StUser) {
        FeedCloudMeta$StNotice feedCloudMeta$StNotice;
        if (context != null && feedCloudMeta$StUser != null) {
            QFSMessageItemInfo qFSMessageItemInfo = this.mItemInfo;
            if (qFSMessageItemInfo != null) {
                feedCloudMeta$StNotice = qFSMessageItemInfo.getStNotice();
            } else {
                feedCloudMeta$StNotice = null;
            }
            if (feedCloudMeta$StNotice == null) {
                return;
            }
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = new FeedCloudMeta$StFeed();
            feedCloudMeta$StFeed.poster.set(feedCloudMeta$StUser);
            QFSShowPersonalPanelEvent qFSShowPersonalPanelEvent = new QFSShowPersonalPanelEvent(feedCloudMeta$StFeed, true, context.hashCode());
            qFSShowPersonalPanelEvent.setNeedMaskView(true);
            SimpleEventBus.getInstance().dispatchEvent(qFSShowPersonalPanelEvent);
            adjustMiniPersonPanelPadding(context);
        }
    }

    private void reportDt(@NonNull FeedCloudMeta$StNotice feedCloudMeta$StNotice) {
        View view = this.mContainer;
        if (view != null && this.mTvShield != null) {
            VideoReport.setElementId(view, getContainerElementId());
            VideoReport.setElementParams(this.mContainer, getDtReportParams(feedCloudMeta$StNotice));
            VideoReport.setElementReuseIdentifier(this.mContainer, feedCloudMeta$StNotice.noticeType.get() + "_" + feedCloudMeta$StNotice.operation.opUser.f398463id.get());
            VideoReport.setElementId(this.mTvShield, QCircleDaTongConstant.ElementId.EM_XSJ_BLOCK_BUTTON);
            VideoReport.setElementParams(this.mTvShield, getDtReportParams(feedCloudMeta$StNotice));
            VideoReport.setElementReuseIdentifier(this.mTvShield, feedCloudMeta$StNotice.noticeType.get() + "_" + feedCloudMeta$StNotice.operation.opUser.f398463id.get());
            VideoReport.setElementId(this.mFollow, getFollowButtonElementId());
        }
    }

    private void setBgView() {
        View view = this.mBgView;
        if (view == null) {
            return;
        }
        view.setVisibility(8);
    }

    private void setDesc(@NonNull FeedCloudMeta$StNotice feedCloudMeta$StNotice) {
        QCircleAvatarListView qCircleAvatarListView = this.mAvatarListView;
        if (qCircleAvatarListView != null && this.mTvDesc != null) {
            qCircleAvatarListView.setVisibility(8);
            this.mTvDesc.setVisibility(8);
            this.mShowRecomReason = "";
            if (!feedCloudMeta$StNotice.followRecom.has()) {
                QLog.d(getLogTag(), 1, "[setDesc] followRecom not has");
                if (!TextUtils.isEmpty(feedCloudMeta$StNotice.message.get())) {
                    this.mShowRecomReason = feedCloudMeta$StNotice.message.get();
                    this.mTvDesc.setVisibility(0);
                    this.mTvDesc.setText(this.mShowRecomReason);
                    this.mTvDesc.setTextColor(RFWApplication.getApplication().getResources().getColorStateList(R.color.qui_common_text_primary));
                    return;
                }
                return;
            }
            QFSFollowRecommendParseInfo c16 = m30.a.c(feedCloudMeta$StNotice.followRecom.get());
            if (c16.getAvatarUrls() != null && c16.getAvatarUrls().size() > 0) {
                this.mAvatarListView.setVisibility(0);
                this.mAvatarListView.setData(c16.getAvatarUrls());
            }
            String recommendStr = c16.getRecommendStr();
            this.mShowRecomReason = recommendStr;
            if (!TextUtils.isEmpty(recommendStr)) {
                this.mTvDesc.setVisibility(0);
                this.mTvDesc.setText(this.mShowRecomReason);
                this.mTvDesc.setTextColor(RFWApplication.getApplication().getResources().getColorStateList(R.color.qui_common_text_primary));
            }
        }
    }

    private void setOpUserInfo(@NonNull FeedCloudMeta$StNotice feedCloudMeta$StNotice) {
        FeedCloudMeta$StUser feedCloudMeta$StUser = feedCloudMeta$StNotice.operation.opUser.get();
        QCircleAvatarView qCircleAvatarView = this.mAvatarView;
        if (qCircleAvatarView != null) {
            qCircleAvatarView.setUser(feedCloudMeta$StUser, this.mDefAvatarSize);
        }
        TextView textView = this.mTvNick;
        if (textView != null) {
            textView.setText(feedCloudMeta$StUser.nick.get());
        }
        QFSFollowView qFSFollowView = this.mFollow;
        if (qFSFollowView != null) {
            qFSFollowView.setUserData(feedCloudMeta$StUser, this.mShowRecomReason);
        }
    }

    private void startHighLightAnim() {
        View view = this.mBgView;
        if (view == null) {
            return;
        }
        if (this.mIsPlayingHighLightAnim) {
            QLog.d(getLogTag(), 1, "startHighLightAnim is playing");
            return;
        }
        this.mIsPlayingHighLightAnim = true;
        view.setVisibility(0);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.mBgView);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(this.mBgView.getBackground());
        com.tencent.biz.qqcircle.utils.d.h(this.mBgView, 0, arrayList, arrayList2, new c());
    }

    private void updateHighlightAnim() {
        QFSMessageItemInfo qFSMessageItemInfo = this.mItemInfo;
        if (qFSMessageItemInfo != null && qFSMessageItemInfo.getStNotice() != null) {
            boolean contains = this.mItemInfo.getStNotice().opMask.get().contains(6);
            QLog.d(getLogTag(), 1, "updateHighlightAnim highlight: " + contains);
            if (contains) {
                this.mItemInfo.getStNotice().opMask.get().remove((Object) 6);
                startHighLightAnim();
            }
        }
    }

    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.a
    protected void bindCustomData(@NonNull QFSMessageItemInfo qFSMessageItemInfo, int i3) {
        this.mItemInfo = qFSMessageItemInfo;
        FeedCloudMeta$StNotice stNotice = qFSMessageItemInfo.getStNotice();
        if (stNotice == null) {
            QLog.e(getLogTag(), 1, "[bindCustomData] stNotice == null");
            return;
        }
        setDesc(stNotice);
        setOpUserInfo(stNotice);
        setBgView();
        reportDt(stNotice);
    }

    public Map<String, Object> getDtReportParams(@NonNull FeedCloudMeta$StNotice feedCloudMeta$StNotice) {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        QQCircleBase$StUserBusiData userExtraData = QCircleHostUtil.getUserExtraData(feedCloudMeta$StNotice.operation.opUser.get());
        if (userExtraData == null) {
            userExtraData = new QQCircleBase$StUserBusiData();
        }
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_WORKS_NUM, Integer.valueOf(userExtraData.feedNum.get()));
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_FANS_NUM, userExtraData.fansNum.get() + "");
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, userExtraData.f429290id.get());
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_FOLLOW_STATUS, r.F(feedCloudMeta$StNotice.operation.opUser.followState.get()));
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_MSG_ID, feedCloudMeta$StNotice.feedId.get());
        buildElementParams.put("xsj_target_qq", feedCloudMeta$StNotice.operation.opUser.f398463id.get());
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_RECOM_REASON, this.mShowRecomReason);
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_IF_PYMK, "1");
        q.r().l(feedCloudMeta$StNotice, buildElementParams);
        return buildElementParams;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QFSLocateHighlightEvent.class);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.a
    public String getLogTag() {
        return TAG;
    }

    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.a
    protected void initClickListener() {
        View view = this.mContainer;
        if (view != null) {
            view.setOnClickListener(getContainerClickListener());
        }
        QCircleAvatarView qCircleAvatarView = this.mAvatarView;
        if (qCircleAvatarView != null) {
            qCircleAvatarView.setOnClickListener(getContainerClickListener());
        }
        TextView textView = this.mTvNick;
        if (textView != null) {
            textView.setOnClickListener(getContainerClickListener());
        }
        TextView textView2 = this.mTvDesc;
        if (textView2 != null) {
            textView2.setOnClickListener(getContainerClickListener());
        }
    }

    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.a
    protected void initCustomView(Context context, @NonNull View view) {
        this.mBgView = view.findViewById(R.id.f1185674h);
        this.mAvatarView = (QCircleAvatarView) view.findViewById(R.id.f165909du3);
        this.mDefAvatarSize = com.tencent.biz.qqcircle.immersive.utils.n.a(context, R.dimen.f159391d02);
        this.mTvNick = (TextView) view.findViewById(R.id.mdg);
        this.mAvatarListView = (QCircleAvatarListView) view.findViewById(R.id.f46811vl);
        this.mTvDesc = (TextView) view.findViewById(R.id.f109306fg);
        View findViewById = view.findViewById(R.id.f111276ks);
        this.mTvShield = findViewById;
        findViewById.setOnClickListener(this);
        QFSFollowView qFSFollowView = (QFSFollowView) view.findViewById(R.id.f31030py);
        this.mFollow = qFSFollowView;
        qFSFollowView.setDtParentEmId(QCircleDaTongConstant.ElementId.EM_XSJ_FRIEND_RECOMMEND_ITEM);
        this.mFollow.setItemReportListener(new a());
    }

    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.a
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        reportDc05507(608, 1);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view != null && view.getId() == R.id.f111276ks) {
            handleClickShield();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.a
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        View view = this.mBgView;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSLocateHighlightEvent) {
            updateHighlightAnim();
        }
    }

    public void reportDc05507(int i3, int i16) {
        FeedCloudMeta$StNotice stNotice;
        QFSMessageItemInfo qFSMessageItemInfo = this.mItemInfo;
        if (qFSMessageItemInfo == null) {
            stNotice = null;
        } else {
            stNotice = qFSMessageItemInfo.getStNotice();
        }
        if (stNotice == null) {
            return;
        }
        QCircleLpReportDc05507.DataBuilder dataBuilder = new QCircleLpReportDc05507.DataBuilder();
        QQCircleBase$StUserBusiData userExtraData = QCircleHostUtil.getUserExtraData(stNotice.operation.opUser.get());
        if (userExtraData == null) {
            userExtraData = new QQCircleBase$StUserBusiData();
        }
        dataBuilder.setActionType(i3).setExt1("" + userExtraData.feedNum.get()).setExt2("" + userExtraData.fansNum.get()).setSubActionType(i16).setToUin(stNotice.operation.opUser.f398463id.get()).setPosition(this.mLastPos).setPageId(getReportBean().getPageId()).setActTime(System.currentTimeMillis()).setExt10(this.mItemInfo.getTraceId());
        if (stNotice.busiReport.has()) {
            dataBuilder.setReportInfo(stNotice.get().toByteArray());
        }
        QCircleLpReportDc05507.report(dataBuilder);
    }

    /* loaded from: classes4.dex */
    class a implements QFSFollowView.d {
        a() {
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSFollowView.d
        public void a() {
            QFSMessageFriendRecomPresenter.this.reportDc05507(608, 3);
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSFollowView.d
        public /* synthetic */ void b() {
            aa.a(this);
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSFollowView.d
        public void onClick(int i3) {
            if (i3 == 0 || i3 == 2) {
                QFSMessageFriendRecomPresenter.this.reportDc05507(608, 2);
            }
            QFSMessageFriendRecomPresenter.this.mItemInfo.getStNotice().operation.opUser.followState.set(i3);
            QFSFollowView qFSFollowView = QFSMessageFriendRecomPresenter.this.mFollow;
            QFSMessageFriendRecomPresenter qFSMessageFriendRecomPresenter = QFSMessageFriendRecomPresenter.this;
            VideoReport.reportEvent(QCircleDaTongConstant.EventId.EV_XSJ_FOLLOW, qFSFollowView, qFSMessageFriendRecomPresenter.getDtReportParams(qFSMessageFriendRecomPresenter.mItemInfo.getStNotice()));
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSFollowView.d
        public void c(int i3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class c implements Animator.AnimatorListener {
        c() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (QFSMessageFriendRecomPresenter.this.mBgView == null) {
                return;
            }
            QFSMessageFriendRecomPresenter.this.mBgView.setVisibility(8);
            QFSMessageFriendRecomPresenter.this.mIsPlayingHighLightAnim = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }
}
