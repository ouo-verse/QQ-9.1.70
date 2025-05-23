package com.tencent.biz.qqcircle.fragments.message.presenter;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.biz.qqcircle.activity.QCircleFragmentActivity;
import com.tencent.biz.qqcircle.beans.QFSFollowRecommendParseInfo;
import com.tencent.biz.qqcircle.beans.QFSMessageItemInfo;
import com.tencent.biz.qqcircle.immersive.events.QFSLaunchToSelectedEvent;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.biz.qqcircle.widgets.QFSFollowView;
import com.tencent.biz.qqcircle.widgets.QFSPagAnimView;
import com.tencent.biz.qqcircle.widgets.aa;
import com.tencent.biz.qqcircle.widgets.bc;
import com.tencent.biz.richframework.compat.CompatPublicFragment;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.biz.richframework.part.PartManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.utils.QCircleDeviceInfoUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudCommon$BytesEntry;
import feedcloud.FeedCloudMeta$StNotice;
import feedcloud.FeedCloudMeta$StUser;
import java.util.ArrayList;
import java.util.Iterator;
import qqcircle.QQCircleFeedBase$StTabInfo;

/* loaded from: classes4.dex */
public class QFSFollowMessagePresenter extends QFSBaseNoticeMessagePresenter {
    private static final int ANIM_DURATION_200 = 200;
    private static final int ANIM_DURATION_3000 = 3000;
    private static final int ANIM_DURATION_3560 = 3560;
    private static final int CALL_FOLLOW_ANIM_DELAY = 1000;
    private static final String CALL_FOLLOW_KEY_IN_BUSITRANPARENT = "call_follow";
    private static final String CALL_FOLLOW_MESSAGE_ANIM_HAS_PLAY = "call_follow_message_anim_has_play";
    private static final String LAST_GET_CALL_FOLLOW_MESSAGE_TRACE_ID = "last_get_call_follow_message_trace_id";
    private static final String TAG = "QFSFollowMessagePresenter";
    private QFSPagAnimView mAvatarCallFollowAnim;
    private ViewStub mAvatarCallFollowAnimStub;
    private View mBgView;
    private QFSPagAnimView mCallFollowAnim;
    private Runnable mCallFollowAnimRunnable;
    private Context mContext;
    private QFSFollowView mFollow;
    private ViewStub mFollowAnimStub;
    private QFSPagAnimView mFollowedAnim;
    private boolean mIsCallFollowBackType;
    private boolean mIsPlayingHighLightAnim;
    private QFSMessageItemInfo mItemInfo;
    private static final int AVATAR_MASK_ANIM_SIZE = cx.a(66.0f);
    private static final int AVATAR_MASK_ANIM_MARGIN = cx.a(-10.0f);

    /* loaded from: classes4.dex */
    class a implements QFSFollowView.e {
        a() {
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSFollowView.e
        public void beforeClick() {
            QFSFollowMessagePresenter.this.consumeItemNewFlag();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class d implements QFSPagAnimView.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AnimatorSet f84482a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AnimatorSet f84483b;

        d(AnimatorSet animatorSet, AnimatorSet animatorSet2) {
            this.f84482a = animatorSet;
            this.f84483b = animatorSet2;
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSPagAnimView.c
        public /* synthetic */ void onAnimationCancel(QFSPagAnimView qFSPagAnimView) {
            bc.a(this, qFSPagAnimView);
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSPagAnimView.c
        public void onAnimationEnd(QFSPagAnimView qFSPagAnimView) {
            if (qFSPagAnimView != null) {
                qFSPagAnimView.setVisibility(8);
            }
            AnimatorSet animatorSet = this.f84483b;
            if (animatorSet != null) {
                animatorSet.start();
            }
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSPagAnimView.c
        public /* synthetic */ void onAnimationRepeat(QFSPagAnimView qFSPagAnimView) {
            bc.c(this, qFSPagAnimView);
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSPagAnimView.c
        public void onAnimationStart(QFSPagAnimView qFSPagAnimView) {
            AnimatorSet animatorSet = this.f84482a;
            if (animatorSet != null) {
                animatorSet.start();
            }
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSPagAnimView.c
        public /* synthetic */ void onAnimationUpdate(QFSPagAnimView qFSPagAnimView) {
            bc.e(this, qFSPagAnimView);
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSPagAnimView.c
        public /* synthetic */ void onPagPlayError(QFSPagAnimView qFSPagAnimView, String str) {
            bc.f(this, qFSPagAnimView, str);
        }
    }

    public QFSFollowMessagePresenter(int i3) {
        super(i3);
        this.mIsCallFollowBackType = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getCallFollowAnimHasPlayMMKVKey(String str) {
        return CALL_FOLLOW_MESSAGE_ANIM_HAS_PLAY + str;
    }

    private QQCircleFeedBase$StTabInfo getCurTabInfo() {
        PartManager partManager;
        Context context = this.mContext;
        if (!(context instanceof QCircleFragmentActivity)) {
            return null;
        }
        CompatPublicFragment fragment = ((QCircleFragmentActivity) context).getFragment();
        if (!(fragment instanceof BasePartFragment) || (partManager = ((BasePartFragment) fragment).getPartManager()) == null) {
            return null;
        }
        Object messageFromPart = partManager.getMessageFromPart("public_list_tab_info", null);
        if (!(messageFromPart instanceof QQCircleFeedBase$StTabInfo)) {
            return null;
        }
        return (QQCircleFeedBase$StTabInfo) messageFromPart;
    }

    private int getCurTabLaunch() {
        QQCircleFeedBase$StTabInfo curTabInfo = getCurTabInfo();
        if (curTabInfo == null) {
            return -1;
        }
        return curTabInfo.tabType.get();
    }

    private void handleCallFollowBackType(@NonNull QFSMessageItemInfo qFSMessageItemInfo) {
        if (qFSMessageItemInfo.getStNotice() == null) {
            return;
        }
        this.mIsCallFollowBackType = false;
        Iterator<FeedCloudCommon$BytesEntry> it = qFSMessageItemInfo.getStNotice().operation.busiTranparent.get().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (TextUtils.equals(it.next().key.get(), CALL_FOLLOW_KEY_IN_BUSITRANPARENT)) {
                this.mIsCallFollowBackType = true;
                break;
            }
        }
        if (this.mIsCallFollowBackType) {
            inflateAvatarCallFollowedView();
            inflateFollowAnimView();
            playCallFollowAnim(qFSMessageItemInfo.getStNotice().feedId.get(), qFSMessageItemInfo.getTraceId());
            QLog.d(TAG, 1, "Call Follow Back Type");
        } else {
            stopAndHideAnimView();
        }
        QFSFollowView qFSFollowView = this.mFollow;
        if (qFSFollowView != null) {
            qFSFollowView.setIsCallFollowBackType(this.mIsCallFollowBackType);
        }
    }

    private void inflateAvatarCallFollowedView() {
        ViewStub viewStub = this.mAvatarCallFollowAnimStub;
        if (viewStub != null && this.mAvatarCallFollowAnim == null) {
            QFSPagAnimView qFSPagAnimView = (QFSPagAnimView) viewStub.inflate().findViewById(R.id.f34040y3);
            this.mAvatarCallFollowAnim = qFSPagAnimView;
            qFSPagAnimView.setVisibility(0);
            int i3 = AVATAR_MASK_ANIM_SIZE;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i3, i3);
            int i16 = AVATAR_MASK_ANIM_MARGIN;
            layoutParams.topMargin = i16;
            layoutParams.leftMargin = i16;
            this.mAvatarCallFollowAnim.setLayoutParams(layoutParams);
            this.mAvatarCallFollowAnim.setClipChildren(false);
        }
    }

    private void inflateFollowAnimView() {
        ViewStub viewStub = this.mFollowAnimStub;
        if (viewStub != null && this.mFollow != null && this.mCallFollowAnim == null) {
            View inflate = viewStub.inflate();
            this.mCallFollowAnim = (QFSPagAnimView) inflate.findViewById(R.id.f47001w4);
            this.mFollowedAnim = (QFSPagAnimView) inflate.findViewById(R.id.f46861vq);
            this.mCallFollowAnim.setVisibility(0);
            this.mFollowedAnim.setVisibility(0);
            this.mFollow.setItemReportListener(new b());
        }
    }

    private boolean isShowThank(FeedCloudMeta$StNotice feedCloudMeta$StNotice) {
        PBRepeatField<Integer> pBRepeatField;
        if (feedCloudMeta$StNotice != null && (pBRepeatField = feedCloudMeta$StNotice.opMask) != null && pBRepeatField.get() != null && feedCloudMeta$StNotice.opMask.get().contains(7)) {
            return true;
        }
        return false;
    }

    private void playCallFollowAnim(final String str, final String str2) {
        if (this.mFollow == null) {
            return;
        }
        if (this.mCallFollowAnimRunnable == null) {
            this.mCallFollowAnimRunnable = new Runnable() { // from class: com.tencent.biz.qqcircle.fragments.message.presenter.QFSFollowMessagePresenter.2
                @Override // java.lang.Runnable
                public void run() {
                    if (!QFSFollowMessagePresenter.this.mIsCallFollowBackType) {
                        QFSFollowMessagePresenter.this.stopAndHideAnimView();
                        return;
                    }
                    if (uq3.k.a().c(QFSFollowMessagePresenter.this.getCallFollowAnimHasPlayMMKVKey(str), false)) {
                        return;
                    }
                    if (str2.equals(uq3.k.a().h(QFSFollowMessagePresenter.LAST_GET_CALL_FOLLOW_MESSAGE_TRACE_ID, ""))) {
                        uq3.k.a().j(QFSFollowMessagePresenter.this.getCallFollowAnimHasPlayMMKVKey(str), true);
                        return;
                    }
                    QFSFollowMessagePresenter qFSFollowMessagePresenter = QFSFollowMessagePresenter.this;
                    qFSFollowMessagePresenter.playCommonPagAnim(qFSFollowMessagePresenter.mCallFollowAnim, "https://qq-video.cdn-go.cn/android/latest/defaultmode/8938/friend_invitation/qvideo_newfriends_invitation_touchbtn.pag", 1, 3000L, null, null);
                    QFSFollowMessagePresenter qFSFollowMessagePresenter2 = QFSFollowMessagePresenter.this;
                    qFSFollowMessagePresenter2.playCommonPagAnim(qFSFollowMessagePresenter2.mAvatarCallFollowAnim, "https://qq-video.cdn-go.cn/android/latest/defaultmode/8938/friend_invitation/qvideo_newfriends_headbuble.pag", 1, 3560L, null, null);
                    uq3.k.a().j(QFSFollowMessagePresenter.this.getCallFollowAnimHasPlayMMKVKey(str), true);
                    uq3.k.a().p(QFSFollowMessagePresenter.LAST_GET_CALL_FOLLOW_MESSAGE_TRACE_ID, str2);
                }
            };
        }
        this.mFollow.postDelayed(this.mCallFollowAnimRunnable, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playCommonPagAnim(QFSPagAnimView qFSPagAnimView, String str, int i3, long j3, AnimatorSet animatorSet, AnimatorSet animatorSet2) {
        if (!QCircleDeviceInfoUtils.isLowDevice() && qFSPagAnimView != null) {
            qFSPagAnimView.setPagAnimListener(new d(animatorSet, animatorSet2));
            qFSPagAnimView.N(str, i3, j3);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void stopAndHideAnimView() {
        QFSPagAnimView qFSPagAnimView = this.mCallFollowAnim;
        if (qFSPagAnimView != null) {
            qFSPagAnimView.V();
            this.mCallFollowAnim.setVisibility(8);
        }
        QFSPagAnimView qFSPagAnimView2 = this.mFollowedAnim;
        if (qFSPagAnimView2 != null) {
            qFSPagAnimView2.V();
            this.mFollowedAnim.setVisibility(8);
        }
        QFSPagAnimView qFSPagAnimView3 = this.mAvatarCallFollowAnim;
        if (qFSPagAnimView3 != null) {
            qFSPagAnimView3.V();
            this.mAvatarCallFollowAnim.setVisibility(8);
        }
    }

    private void updateHighlightAnim(int i3) {
        QFSMessageItemInfo qFSMessageItemInfo;
        if (this.mBgView != null && (qFSMessageItemInfo = this.mItemInfo) != null && qFSMessageItemInfo.getStNotice() != null) {
            if (!isResumePage()) {
                QLog.d(getLogTag(), 2, "[updateHighlightAnim] current not resume page");
                return;
            }
            if (i3 == -1) {
                i3 = getCurTabLaunch();
            }
            if (i3 != this.mLaunchTo) {
                QLog.d(getLogTag(), 2, "[updateHighlightAnim] launchTo not equal tabLaunch : " + i3 + " mLaunchTo : " + this.mLaunchTo);
                return;
            }
            if (this.mItemInfo.canShowNoAnimHighLight()) {
                QLog.d(getLogTag(), 1, "updateHighlightAnim but use no anim highLight");
            } else if (this.mItemInfo.getStNotice().opMask.get().contains(6)) {
                this.mItemInfo.getStNotice().opMask.get().remove((Object) 6);
                startHighLightAnim();
            }
        }
    }

    private boolean updateThankContent(FeedCloudMeta$StNotice feedCloudMeta$StNotice, String str) {
        ConstraintLayout constraintLayout;
        if (!isShowThank(feedCloudMeta$StNotice) || TextUtils.isEmpty(str) || this.mTvMessage == null || (constraintLayout = this.mMessageContainer) == null) {
            return false;
        }
        constraintLayout.setVisibility(0);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str.trim());
        appendMessageTimeText(spannableStringBuilder, feedCloudMeta$StNotice);
        this.mTvMessage.setMinimumWidth(QFSBaseNoticeMessagePresenter.MESSAGE_VIEW_MIN_WIDTH);
        this.mTvMessage.setText(spannableStringBuilder);
        reportImpEvent(this.mTvMessage);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.QFSBaseNoticeMessagePresenter, com.tencent.biz.qqcircle.fragments.message.presenter.a
    public void bindCustomData(@NonNull QFSMessageItemInfo qFSMessageItemInfo, int i3) {
        String charSequence;
        super.bindCustomData(qFSMessageItemInfo, i3);
        this.mItemInfo = qFSMessageItemInfo;
        handleCallFollowBackType(qFSMessageItemInfo);
        QFSFollowView qFSFollowView = this.mFollow;
        if (qFSFollowView == null) {
            return;
        }
        FeedCloudMeta$StUser feedCloudMeta$StUser = qFSMessageItemInfo.getStNotice().operation.opUser.get();
        QCircleAsyncTextView qCircleAsyncTextView = this.mTvMessage;
        if (qCircleAsyncTextView == null) {
            charSequence = "";
        } else {
            charSequence = qCircleAsyncTextView.getText().toString();
        }
        qFSFollowView.setUserData(feedCloudMeta$StUser, charSequence);
        updateHighlightAnim(-1);
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
    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.QFSBaseNoticeMessagePresenter
    public void handleQFSLaunchToSelectedEvent(QFSLaunchToSelectedEvent qFSLaunchToSelectedEvent) {
        super.handleQFSLaunchToSelectedEvent(qFSLaunchToSelectedEvent);
        updateHighlightAnim(qFSLaunchToSelectedEvent.mLaunchTo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.QFSBaseNoticeMessagePresenter, com.tencent.biz.qqcircle.fragments.message.presenter.a
    public void initCustomView(Context context, @NonNull View view) {
        super.initCustomView(context, view);
        this.mContext = context;
        this.mBgView = view.findViewById(R.id.f1185674h);
        QFSFollowView qFSFollowView = (QFSFollowView) view.findViewById(R.id.f31030py);
        this.mFollow = qFSFollowView;
        qFSFollowView.setDtParentEmId(QCircleDaTongConstant.ElementId.EM_XSJ_MSG);
        this.mFollow.f(new a());
        this.mFollowAnimStub = (ViewStub) view.findViewById(R.id.f46911vv);
        this.mAvatarCallFollowAnimStub = (ViewStub) view.findViewById(R.id.f46821vm);
    }

    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.QFSBaseNoticeMessagePresenter, com.tencent.biz.qqcircle.fragments.message.presenter.a
    public void onDetachedFromWindow() {
        Runnable runnable;
        super.onDetachedFromWindow();
        QFSFollowView qFSFollowView = this.mFollow;
        if (qFSFollowView != null && (runnable = this.mCallFollowAnimRunnable) != null) {
            qFSFollowView.removeCallbacks(runnable);
        }
        View view = this.mBgView;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.QFSBaseNoticeMessagePresenter
    public void setContent(FeedCloudMeta$StNotice feedCloudMeta$StNotice) {
        QCircleAsyncTextView qCircleAsyncTextView;
        String str;
        if (feedCloudMeta$StNotice != null && this.mAvatarListView != null && this.mMessageContainer != null && (qCircleAsyncTextView = this.mTvMessage) != null) {
            qCircleAsyncTextView.setSingleLine(true);
            this.mTvMessage.setEllipsize(TextUtils.TruncateAt.END);
            this.mAvatarListView.setVisibility(8);
            this.mMessageContainer.setVisibility(8);
            if (!feedCloudMeta$StNotice.followRecom.has()) {
                PBStringField pBStringField = feedCloudMeta$StNotice.message;
                if (pBStringField == null) {
                    str = null;
                } else {
                    str = pBStringField.get();
                }
                if (updateThankContent(feedCloudMeta$StNotice, str)) {
                    return;
                }
                super.setContent(feedCloudMeta$StNotice);
                return;
            }
            QFSFollowRecommendParseInfo c16 = m30.a.c(feedCloudMeta$StNotice.followRecom.get());
            if (c16.getAvatarUrls() != null && c16.getAvatarUrls().size() > 0) {
                this.mAvatarListView.setVisibility(0);
                this.mAvatarListView.setData(c16.getAvatarUrls());
            }
            if (TextUtils.isEmpty(c16.getRecommendStr()) || updateThankContent(feedCloudMeta$StNotice, c16.getRecommendStr())) {
                return;
            }
            this.mMessageContainer.setVisibility(0);
            this.mTvMessage.setText(c16.getRecommendStr());
            reportImpEvent(this.mTvMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.QFSBaseNoticeMessagePresenter
    public void setTime(FeedCloudMeta$StNotice feedCloudMeta$StNotice) {
        if (isShowThank(feedCloudMeta$StNotice)) {
            this.mTvTime.setVisibility(8);
        } else {
            super.setTime(feedCloudMeta$StNotice);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b implements QFSFollowView.d {
        b() {
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSFollowView.d
        public /* synthetic */ void b() {
            aa.a(this);
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSFollowView.d
        public void onClick(int i3) {
            QFSFollowMessagePresenter.this.consumeItemNewFlag();
            if (i3 == 2) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(QFSFollowMessagePresenter.this.mFollow, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f);
                ofFloat.setDuration(200L);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.play(ofFloat);
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(QFSFollowMessagePresenter.this.mFollow, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
                ofFloat2.setDuration(200L);
                AnimatorSet animatorSet2 = new AnimatorSet();
                animatorSet2.play(ofFloat2);
                QFSFollowMessagePresenter qFSFollowMessagePresenter = QFSFollowMessagePresenter.this;
                qFSFollowMessagePresenter.playCommonPagAnim(qFSFollowMessagePresenter.mFollowedAnim, "https://qq-video.cdn-go.cn/android/latest/defaultmode/8938/friend_invitation/qvideo_newfriends_handclap.pag", 1, 3000L, animatorSet, animatorSet2);
            }
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSFollowView.d
        public void a() {
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
            if (QFSFollowMessagePresenter.this.mBgView == null) {
                return;
            }
            QFSFollowMessagePresenter.this.mBgView.setVisibility(8);
            QFSFollowMessagePresenter.this.mIsPlayingHighLightAnim = false;
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
