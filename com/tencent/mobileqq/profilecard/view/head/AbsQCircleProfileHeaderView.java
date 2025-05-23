package com.tencent.mobileqq.profilecard.view.head;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.AbsHandleEventListener;
import com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate;
import com.tencent.mobileqq.profilecard.base.view.ProfileBaseView;
import com.tencent.mobileqq.profilecard.constant.QCircleProfileConstant;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.view.head.AbsQCircleProfileHeaderView;
import com.tencent.mobileqq.profilecard.zplan.IZPlanChangeTitleStatusListener;
import com.tencent.mobileqq.qcircle.api.data.QCircleFeedCoverBean;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes35.dex */
public abstract class AbsQCircleProfileHeaderView extends AbsZPlanProfileHeaderView {
    public static final int MODE_QCIRCLE_COVER = 3;
    public static final String TAG = "AbsQCircleProfileHeaderView";
    public boolean mIsShowQCircleCover;
    private ProfileQCircleControlManager mProfileQCircleControlManager;
    private int mQCircleCoverState;
    protected FrameLayout mQCircleCoverView;
    private QCircleFeedHeadLayout mQCircleFeedHeadLayout;
    private ImageView mQCircleFeedHeadLayoutCover;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes35.dex */
    public class ProfileQCircleControlManager extends AbsHandleEventListener {
        private boolean mIsSlideDown = false;
        private float mTouchEventLastY;

        ProfileQCircleControlManager() {
        }

        private boolean isOnTop() {
            Rect rect = new Rect();
            View childAt = ((ProfileBaseView) AbsQCircleProfileHeaderView.this).mListView != null ? ((ProfileBaseView) AbsQCircleProfileHeaderView.this).mListView.getChildAt(0) : null;
            if (childAt == null) {
                return false;
            }
            childAt.getLocalVisibleRect(rect);
            return rect.top == 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$smoothQCircleCoverScrollTo$0(ValueAnimator valueAnimator) {
            setQCircleCoverVisibleHeight(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }

        private void setQCircleCoverVisibleHeight(int i3) {
            FrameLayout frameLayout = AbsQCircleProfileHeaderView.this.mQCircleCoverView;
            if (frameLayout == null) {
                return;
            }
            if (i3 < 0) {
                i3 = 0;
            }
            int i16 = QCircleProfileConstant.FULL_SCREEN_HEIGHT;
            if (i3 > i16) {
                i3 = i16;
            }
            ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
            layoutParams.height = i3;
            AbsQCircleProfileHeaderView.this.mQCircleCoverView.setLayoutParams(layoutParams);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setQCircleFeedHeadLayoutCoverVisible(int i3) {
            AbsQCircleProfileHeaderView absQCircleProfileHeaderView = AbsQCircleProfileHeaderView.this;
            if (absQCircleProfileHeaderView.mQCircleCoverView == null || absQCircleProfileHeaderView.mQCircleFeedHeadLayoutCover == null || i3 == AbsQCircleProfileHeaderView.this.mQCircleFeedHeadLayoutCover.getVisibility()) {
                return;
            }
            AbsQCircleProfileHeaderView.this.mQCircleFeedHeadLayoutCover.setVisibility(i3);
        }

        private void tryResetPos() {
            FrameLayout frameLayout = AbsQCircleProfileHeaderView.this.mQCircleCoverView;
            if (frameLayout == null || frameLayout.getChildCount() <= 0) {
                return;
            }
            try {
                ((QCircleFeedHeadLayout) AbsQCircleProfileHeaderView.this.mQCircleCoverView.getChildAt(0)).resetVideoViewPos();
            } catch (Exception e16) {
                QLog.e(AbsQCircleProfileHeaderView.TAG, 1, e16, new Object[0]);
            }
        }

        protected int getQCircleCoverVisibleHeight() {
            FrameLayout frameLayout = AbsQCircleProfileHeaderView.this.mQCircleCoverView;
            if (frameLayout == null) {
                return 0;
            }
            return frameLayout.getLayoutParams().height;
        }

        public void handleDefaultMotionEvent(boolean z16) {
            if (isHandleMoveEvent(z16)) {
                if (AbsQCircleProfileHeaderView.this.mQCircleCoverState != 14) {
                    tryResetPos();
                }
                onRelease(z16);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x0018, code lost:
        
            if (r0 != 3) goto L36;
         */
        @Override // com.tencent.mobileqq.profilecard.AbsHandleEventListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean handleEvent(MotionEvent motionEvent) {
            if (!AbsQCircleProfileHeaderView.this.mIsShowQCircleCover) {
                return false;
            }
            int actionMasked = motionEvent.getActionMasked() & 255;
            if (actionMasked != 0) {
                if (actionMasked != 1) {
                    if (actionMasked == 2) {
                        if ((((ProfileBaseView) AbsQCircleProfileHeaderView.this).mListView != null ? ((ProfileBaseView) AbsQCircleProfileHeaderView.this).mListView.getFirstVisiblePosition() : -1) != 0) {
                            return false;
                        }
                        float rawY = motionEvent.getRawY();
                        float f16 = this.mTouchEventLastY;
                        float f17 = (rawY - f16) / 2.0f;
                        boolean z16 = f16 == 0.0f;
                        this.mTouchEventLastY = motionEvent.getRawY();
                        boolean z17 = f17 > 0.0f && !z16;
                        this.mIsSlideDown = z17;
                        if (z16) {
                            return false;
                        }
                        return onMove(f17, z17);
                    }
                }
                this.mTouchEventLastY = 0.0f;
                handleDefaultMotionEvent(this.mIsSlideDown);
            } else {
                this.mTouchEventLastY = motionEvent.getRawY();
            }
            return false;
        }

        public boolean isHandleMoveEvent(boolean z16) {
            if (AbsQCircleProfileHeaderView.this.mQCircleCoverState == 15) {
                return false;
            }
            return AbsQCircleProfileHeaderView.this.mQCircleCoverState != -1 || (isOnTop() && z16);
        }

        public boolean onMove(float f16, boolean z16) {
            if (!isHandleMoveEvent(z16)) {
                return false;
            }
            int qCircleCoverVisibleHeight = getQCircleCoverVisibleHeight();
            setQCircleCoverVisibleHeight(((int) f16) + qCircleCoverVisibleHeight);
            if (qCircleCoverVisibleHeight >= QCircleProfileConstant.FULL_SCREEN_HEIGHT) {
                setQCircleCoverState(14);
                return true;
            }
            if (qCircleCoverVisibleHeight > QCircleProfileConstant.INIT_HEIGHT) {
                setQCircleCoverState(13);
                ((QCircleFeedHeadLayout) AbsQCircleProfileHeaderView.this.mQCircleCoverView.getChildAt(0)).onMoveVideo(f16);
                return true;
            }
            int i3 = QCircleProfileConstant.ATTACH_TOP_HEIGHT_UP;
            if (qCircleCoverVisibleHeight < i3) {
                setQCircleCoverState(10);
                setQCircleFeedHeadLayoutCoverVisible(8);
                return true;
            }
            if (qCircleCoverVisibleHeight > QCircleProfileConstant.ATTACH_TOP_HEIGHT_DOWN) {
                setQCircleCoverState(12);
                return true;
            }
            if (qCircleCoverVisibleHeight > i3) {
                setQCircleCoverState(11);
                return true;
            }
            setQCircleCoverState(-1);
            return true;
        }

        public void onReset() {
            smoothQCircleCoverScrollToInitHeight();
            AbsQCircleProfileHeaderView.this.adjustTitle();
        }

        public void onResume() {
            if (AbsQCircleProfileHeaderView.this.mQCircleCoverState == 15) {
                smoothQCircleCoverScrollToInitHeight();
                tryResetPos();
            }
            AbsQCircleProfileHeaderView.this.adjustTitle();
        }

        public void setQCircleCoverState(int i3) {
            if (AbsQCircleProfileHeaderView.this.mQCircleCoverState != i3) {
                AbsQCircleProfileHeaderView.this.mQCircleCoverState = i3;
                FrameLayout frameLayout = AbsQCircleProfileHeaderView.this.mQCircleCoverView;
                if (frameLayout != null && frameLayout.getChildCount() > 0) {
                    try {
                        QCircleFeedHeadLayout qCircleFeedHeadLayout = (QCircleFeedHeadLayout) AbsQCircleProfileHeaderView.this.mQCircleCoverView.getChildAt(0);
                        if (qCircleFeedHeadLayout != null && i3 == 15) {
                            if (qCircleFeedHeadLayout.isInitByFeedSuccess() && qCircleFeedHeadLayout.hasLoadCover()) {
                                qCircleFeedHeadLayout.onMaxPull();
                            } else {
                                smoothQCircleCoverScrollToInitHeight();
                            }
                        }
                    } catch (Exception e16) {
                        QLog.e(AbsQCircleProfileHeaderView.TAG, 1, e16, new Object[0]);
                    }
                }
                AbsQCircleProfileHeaderView.this.adjustTitle();
            }
        }

        public void onRelease(boolean z16) {
            QLog.d(AbsQCircleProfileHeaderView.TAG, 1, "[onRelease] mState:", Integer.valueOf(AbsQCircleProfileHeaderView.this.mQCircleCoverState));
            switch (AbsQCircleProfileHeaderView.this.mQCircleCoverState) {
                case 10:
                    smoothQCircleCoverScrollToClose();
                    return;
                case 11:
                    if (z16) {
                        smoothQCircleCoverScrollToInitHeight();
                        return;
                    } else {
                        smoothQCircleCoverScrollToClose();
                        return;
                    }
                case 12:
                case 13:
                    smoothQCircleCoverScrollToInitHeight();
                    return;
                case 14:
                    setQCircleCoverState(15);
                    smoothQCircleCoverScrollTo(ScreenUtil.getRealHeight(BaseApplication.getContext()));
                    return;
                default:
                    return;
            }
        }

        protected void smoothQCircleCoverScrollTo(int i3) {
            ValueAnimator ofInt = ValueAnimator.ofInt(getQCircleCoverVisibleHeight(), i3);
            ofInt.setDuration(200L).start();
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.profilecard.view.head.e
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AbsQCircleProfileHeaderView.ProfileQCircleControlManager.this.lambda$smoothQCircleCoverScrollTo$0(valueAnimator);
                }
            });
            ofInt.addListener(new Animator.AnimatorListener() { // from class: com.tencent.mobileqq.profilecard.view.head.AbsQCircleProfileHeaderView.ProfileQCircleControlManager.1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (AbsQCircleProfileHeaderView.this.mQCircleCoverState == -1) {
                        ProfileQCircleControlManager.this.setQCircleFeedHeadLayoutCoverVisible(0);
                    } else {
                        ProfileQCircleControlManager.this.setQCircleFeedHeadLayoutCoverVisible(8);
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    ProfileQCircleControlManager.this.setQCircleFeedHeadLayoutCoverVisible(8);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            ofInt.start();
        }

        public void smoothQCircleCoverScrollToClose() {
            setQCircleCoverState(-1);
            smoothQCircleCoverScrollTo(QCircleProfileConstant.CEILING_HEIGHT);
        }

        public void smoothQCircleCoverScrollToInitHeight() {
            setQCircleCoverState(13);
            smoothQCircleCoverScrollTo(QCircleProfileConstant.INIT_HEIGHT);
        }
    }

    public AbsQCircleProfileHeaderView(QBaseActivity qBaseActivity, ProfileCardInfo profileCardInfo) {
        super(qBaseActivity, profileCardInfo);
        this.mQCircleCoverState = 0;
        this.mIsShowQCircleCover = false;
    }

    private void initQCircleCover() {
        if (this.mQCircleCoverView == null) {
            this.mQCircleCoverView = (FrameLayout) this.mContentView.findViewById(R.id.xmt);
        }
        FrameLayout frameLayout = this.mQCircleCoverView;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, QCircleProfileConstant.FULL_SCREEN_HEIGHT);
            QCircleFeedHeadLayout qCircleFeedHeadLayout = new QCircleFeedHeadLayout(this.mActivity);
            this.mQCircleFeedHeadLayout = qCircleFeedHeadLayout;
            qCircleFeedHeadLayout.setLayoutParams(layoutParams);
            this.mQCircleCoverView.addView(this.mQCircleFeedHeadLayout);
            ImageView imageView = new ImageView(this.mActivity);
            this.mQCircleFeedHeadLayoutCover = imageView;
            imageView.setLayoutParams(layoutParams);
            this.mQCircleFeedHeadLayoutCover.setBackgroundResource(R.drawable.qui_common_bg_bottom_light_bg);
            this.mQCircleFeedHeadLayoutCover.setVisibility(8);
            this.mQCircleCoverView.addView(this.mQCircleFeedHeadLayoutCover);
            this.mQCircleCoverView.setVisibility(8);
            updateCoverFeedData();
        }
    }

    private void updateCoverFeedData() {
        if (this.mCardInfo.card == null || this.mQCircleFeedHeadLayout == null) {
            return;
        }
        QCircleFeedCoverBean qCircleFeedCoverBean = new QCircleFeedCoverBean();
        Card card = this.mCardInfo.card;
        qCircleFeedCoverBean.qcircleFeedId = card.qcircleFeedId;
        qCircleFeedCoverBean.qcircleFeedPosterUin = card.qcircleFeedPosterUin;
        qCircleFeedCoverBean.qcircleVideoUrl = card.qcircleVideoUrl;
        qCircleFeedCoverBean.qcircleCoverY = card.qcircleCoverY;
        qCircleFeedCoverBean.qcircleVideoCoverUrl = card.qcircleVideoCoverUrl;
        qCircleFeedCoverBean.qcircleVideoHeight = card.qcircleVideoHeight;
        qCircleFeedCoverBean.qcircleVideoWidth = card.qcircleVideoWidth;
        this.mQCircleFeedHeadLayout.init(qCircleFeedCoverBean);
    }

    @Override // com.tencent.mobileqq.profilecard.view.head.AbsZPlanProfileHeaderView
    public void adjustTitle() {
        int i3;
        if (this.mIsShowZplanCover) {
            super.adjustTitle();
            return;
        }
        if (this.mIsShowQCircleCover) {
            if (this.mZPlanChangeTitleStatusListener == null) {
                IProfileActivityDelegate iProfileActivityDelegate = this.mDelegate;
                this.mZPlanChangeTitleStatusListener = iProfileActivityDelegate != null ? iProfileActivityDelegate.getZPlanChangeTitleStatusListener() : null;
            }
            IZPlanChangeTitleStatusListener iZPlanChangeTitleStatusListener = this.mZPlanChangeTitleStatusListener;
            if (iZPlanChangeTitleStatusListener == null || (i3 = this.mQCircleCoverState) == 10 || i3 == 11) {
                return;
            }
            iZPlanChangeTitleStatusListener.onSetTitleStatus(i3 == -1);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.view.head.AbsZPlanProfileHeaderView, com.tencent.mobileqq.profilecard.base.view.ProfileBaseView
    protected void initCover(ProfileCardInfo profileCardInfo, int i3) {
        super.initCover(profileCardInfo, i3);
        if (this.mIsShowZplanCover) {
            initZplanCover();
        } else if (this.mIsShowQCircleCover) {
            initQCircleCover();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.profilecard.view.head.AbsZPlanProfileHeaderView, com.tencent.mobileqq.profilecard.base.view.ProfileBaseView
    public int initCoverMode(ProfileCardInfo profileCardInfo) {
        int initCoverMode = super.initCoverMode(profileCardInfo);
        if (this.mIsShowZplanCover) {
            return 2;
        }
        if (this.mIsShowQCircleCover) {
            return 3;
        }
        return initCoverMode;
    }

    @Override // com.tencent.mobileqq.profilecard.view.head.AbsZPlanProfileHeaderView, com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView, android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (AppSetting.t(BaseApplication.getContext())) {
            resetQCircleState();
        }
    }

    @Override // com.tencent.mobileqq.profilecard.view.head.AbsZPlanProfileHeaderView, com.tencent.mobileqq.profilecard.base.view.ProfileBaseView, com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView
    public void onResume() {
        super.onResume();
        ProfileQCircleControlManager profileQCircleControlManager = this.mProfileQCircleControlManager;
        if (profileQCircleControlManager != null) {
            profileQCircleControlManager.onResume();
        }
    }

    @Override // com.tencent.mobileqq.profilecard.view.head.AbsZPlanProfileHeaderView, com.tencent.mobileqq.profilecard.base.view.ProfileBaseView, com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView
    public void onUpdate(ProfileCardInfo profileCardInfo, boolean z16) {
        IProfileActivityDelegate iProfileActivityDelegate = this.mDelegate;
        if (iProfileActivityDelegate != null) {
            this.mIsShowZplanCover = iProfileActivityDelegate.getIsShowZplanCover();
            boolean isShowQCircleCover = this.mDelegate.isShowQCircleCover();
            this.mIsShowQCircleCover = isShowQCircleCover;
            if (!this.mIsShowZplanCover && isShowQCircleCover) {
                if (this.mProfileQCircleControlManager == null) {
                    this.mProfileQCircleControlManager = new ProfileQCircleControlManager();
                }
                this.mListView.setHandleEvent(this.mProfileQCircleControlManager);
            }
        }
        super.onUpdate(profileCardInfo, z16);
    }

    public void resetQCircleState() {
        if (this.mProfileQCircleControlManager == null) {
            this.mProfileQCircleControlManager = new ProfileQCircleControlManager();
        }
        this.mProfileQCircleControlManager.onReset();
    }

    @Override // com.tencent.mobileqq.profilecard.view.head.AbsZPlanProfileHeaderView, com.tencent.mobileqq.profilecard.base.view.ProfileBaseView
    protected void updateCover(ProfileCardInfo profileCardInfo) {
        if (!this.mIsShowZplanCover && this.mIsShowQCircleCover) {
            if (this.mQCircleCoverView == null) {
                initQCircleCover();
            } else {
                updateCoverFeedData();
            }
            if (this.mCoverView.c() == 3 && this.mCurrentNightMode == QQTheme.isNowThemeIsNight()) {
                return;
            }
            this.mCoverView.a(3);
            onCoverModeChange(3, profileCardInfo);
            return;
        }
        super.updateCover(profileCardInfo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void updateQCircleCoverMode() {
        if (this.mQCircleCoverView != null) {
            this.mCoverView.setVisibility(8);
            FrameLayout frameLayout = this.mZplanCoverView;
            if (frameLayout != null) {
                frameLayout.setVisibility(8);
            }
            dismissUserGuide();
            if (this.mQCircleCoverState == 0) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mCoverView.getLayoutParams();
                layoutParams.height = QCircleProfileConstant.INIT_HEIGHT;
                this.mQCircleCoverView.setLayoutParams(layoutParams);
            }
            this.mQCircleCoverView.setVisibility(0);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mContentBgView.getLayoutParams();
            layoutParams2.addRule(3, R.id.xmt);
            layoutParams2.addRule(10, 0);
            layoutParams2.topMargin = 0;
            this.mContentBgView.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.profilecard.view.head.AbsZPlanProfileHeaderView
    public void updateZplanCoverMode() {
        super.updateZplanCoverMode();
        FrameLayout frameLayout = this.mQCircleCoverView;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.view.head.AbsZPlanProfileHeaderView, com.tencent.mobileqq.profilecard.base.view.ProfileBaseView
    public void onCoverModeChange(int i3, ProfileCardInfo profileCardInfo) {
        if (i3 == 2) {
            updateZplanCoverMode();
        } else if (i3 == 3) {
            updateQCircleCoverMode();
        }
    }
}
