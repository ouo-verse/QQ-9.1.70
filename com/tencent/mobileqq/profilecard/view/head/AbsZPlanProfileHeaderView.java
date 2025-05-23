package com.tencent.mobileqq.profilecard.view.head;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.lifecycle.Observer;
import com.airbnb.lottie.LottieDrawable;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.config.AppSetting;
import com.tencent.common.config.pad.DeviceType;
import com.tencent.common.config.pad.PadUtil;
import com.tencent.filament.zplan.scene.minihome.IMiniHomeLoadCallback;
import com.tencent.filament.zplan.scene.minihome.IMiniHomeMessageCallback;
import com.tencent.filament.zplan.scene.minihome.MiniHomeScene;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.onlinestatus.be;
import com.tencent.mobileqq.onlinestatus.utils.LottieHelper;
import com.tencent.mobileqq.profilecard.AbsHandleEventListener;
import com.tencent.mobileqq.profilecard.ProfileCardDtReportUtil;
import com.tencent.mobileqq.profilecard.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate;
import com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView;
import com.tencent.mobileqq.profilecard.base.view.ProfileBaseView;
import com.tencent.mobileqq.profilecard.base.view.PullToZoomHeaderListView;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.utils.ZPlanProfileAvatarUtils;
import com.tencent.mobileqq.profilecard.view.head.AbsZPlanProfileHeaderView;
import com.tencent.mobileqq.profilecard.zplan.IZPlanChangeTitleStatusListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.VasIpcTempData;
import com.tencent.mobileqq.vas.qid.QidCoolTextView;
import com.tencent.mobileqq.vas.util.PrettyAccountUtil;
import com.tencent.mobileqq.widget.tip.QUIDefaultBubbleTip;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.bubble.api.IZPlanAvatarBubbleControllerFactory;
import com.tencent.mobileqq.zplan.meme.frameanim.StrategyId;
import com.tencent.mobileqq.zplan.meme.frameanim.ZPlanAvatarBannerParams;
import com.tencent.mobileqq.zplan.meme.frameanim.model.ZPlanAvatarSource;
import com.tencent.mobileqq.zplan.minihome.CreateMiniHomeSource;
import com.tencent.mobileqq.zplan.minihome.EditMiniHomeSource;
import com.tencent.mobileqq.zplan.minihome.EventErrorCallback;
import com.tencent.mobileqq.zplan.minihome.EventFirstFrameImageReady;
import com.tencent.mobileqq.zplan.minihome.EventPixelCallback;
import com.tencent.mobileqq.zplan.minihome.EventTimeStatCallback;
import com.tencent.mobileqq.zplan.minihome.EventType;
import com.tencent.mobileqq.zplan.minihome.GiftDesc;
import com.tencent.mobileqq.zplan.minihome.GiftPopSource;
import com.tencent.mobileqq.zplan.minihome.GiftReportInfo;
import com.tencent.mobileqq.zplan.minihome.GuidanceSource;
import com.tencent.mobileqq.zplan.minihome.MiniHomeInfo;
import com.tencent.mobileqq.zplan.minihome.MiniHomeLoadSource;
import com.tencent.mobileqq.zplan.minihome.MiniHomeProfileCardType;
import com.tencent.mobileqq.zplan.minihome.MiniHomeSceneEnum;
import com.tencent.mobileqq.zplan.minihome.api.IMiniHomeHelper;
import com.tencent.mobileqq.zplan.servlet.api.IZPlanRequest;
import com.tencent.mobileqq.zplan.utils.api.IZPlanAccessibleHelper;
import com.tencent.mobileqq.zplan.utils.api.IZPlanClassObjectFactory;
import com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper;
import com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanQQMC;
import com.tencent.mobileqq.zplan.view.AbsZPlanStaticFrameLayout;
import com.tencent.mobileqq.zplan.view.b;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.api.IZPlanRefreshMoveListener;
import cooperation.qzone.api.OnRefreshStateListener;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* loaded from: classes35.dex */
public abstract class AbsZPlanProfileHeaderView extends ProfileBaseView {
    private static final int ANIMATION_REPEAT_COUNT = -1;
    protected static final int MODE_ZPLAN_COVER = 2;
    protected static final int QID_DEFAULT_UIN_MARGIN_TOP = 0;
    protected static final int QID_PRETTY_UIN_MARGIN_TOP = -3;
    protected static final int QID_SVIP_UIN_MARGIN_TOP = -2;
    private static final String TAG = "AbsZPlanProfileHeaderView";
    private static final String ZPLAN_USER_GUIDE_JSON = "zplan/qzone_zplan_guide_lottie.json";
    private final AtomicBoolean disableAddView;
    private boolean enableMiniHomeProfile;
    private boolean hasDestroy;
    private final AtomicBoolean hasPixelCallback;
    private boolean hasResume;
    private boolean lastEnableMiniHome;
    private IMiniHomeLoadCallback loadAvatarCallback;
    private IMiniHomeLoadCallback loadRoomCallback;
    private com.tencent.mobileqq.zplan.minihome.ao loadingRoomDesc;
    private WeakReference<Activity> mActivityWeakRef;
    private com.tencent.mobileqq.zplan.bubble.b mAvatarBubbleController;
    private long mAvatarLoadDuration;
    private final AtomicBoolean mAvatarLoaded;
    private com.tencent.mobileqq.zplan.meme.frameanim.e mAvatarOverlayViewWiringHelper;
    protected IProfileActivityDelegate mDelegate;
    private long mEngineStartTime;
    private long mFirstFrameTime;
    private final AtomicBoolean mFirstFramed;
    private GiftDesc mGiftDesc;
    private AtomicBoolean mHasManagerResumed;
    private boolean mHasPausedBeforeFirstFrame;
    private boolean mHasReported;
    private long mHideStaticImageTime;
    private boolean mIsResetRoomAndAvatar;
    public boolean mIsShowZplanCover;
    private long mLoadStartTime;
    private final Observer<Boolean> mLoadingOverlayObserver;
    private int mMaxPullDownHeight;
    private long mMiniHomeAvatarLoadStartTime;
    private com.tencent.mobileqq.zplan.minihome.y mMiniHomeController;
    private ImageView mMiniHomeEditImage;
    private String mMiniHomeEntranceFrom;
    private ImageView mMiniHomeGiftImage;
    private long mMiniHomeInitStartTime;
    private com.tencent.mobileqq.zplan.minihome.aa mMiniHomeReporter;
    private com.tencent.mobileqq.zplan.minihome.ab mMiniHomeReporterV2;
    private long mMiniHomeRoomLoadStartTime;
    private final com.tencent.mobileqq.zplan.minihome.ac mMiniHomeSceneEventCallback;
    private final WeakReference<com.tencent.mobileqq.zplan.minihome.ac> mMiniHomeSceneEventCallbackRef;
    protected LinearLayout mOnlineStatusLayout;
    private long mPageEndTime;
    private long mPageStartTime;
    private long mPixelCallbackDuration;
    private ProfileZPlanScrollController mProfileZPlanControlManager;
    protected QidCoolTextView mQidInfoView;
    private long mRoomLoadDuration;
    private final AtomicBoolean mRoomLoaded;
    private int mState;
    private final AtomicBoolean mTimeStatCallbacked;
    protected ImageView mVipMedalView;
    private ImageView mXiaowoImage;
    private AbsZPlanStaticFrameLayout mZPlanBannerLayout;
    protected IZPlanChangeTitleStatusListener mZPlanChangeTitleStatusListener;
    private ImageView mZPlanCornerBg;
    private com.tencent.mobileqq.zplan.view.b mZPlanHeaderTouchDelegate;
    private View mZPlanMiniHomeView;
    private final com.tencent.mobileqq.zplan.servlet.b mZPlanRequestObserver;
    private com.tencent.mobileqq.zplan.meme.frameanim.a mZplanAvatarBannerManager;
    protected FrameLayout mZplanCoverView;
    protected LottieDrawable mZplanLottieDrawable;
    protected ImageView mZplanUserGuideImage;
    protected RelativeLayout mZplanUserGuideImageLayout;
    private final AtomicBoolean needForceReload;
    private boolean recordMiniHomeFirstFrame;
    private RequestMiniHomeCallback requestMiniHomeCallback;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.mobileqq.profilecard.view.head.AbsZPlanProfileHeaderView$12, reason: invalid class name */
    /* loaded from: classes35.dex */
    public static /* synthetic */ class AnonymousClass12 {
        static final /* synthetic */ int[] $SwitchMap$com$tencent$mobileqq$zplan$minihome$EventType;

        static {
            int[] iArr = new int[EventType.values().length];
            $SwitchMap$com$tencent$mobileqq$zplan$minihome$EventType = iArr;
            try {
                iArr[EventType.EVENT_FIRST_FRAME_IMAGE_READY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$tencent$mobileqq$zplan$minihome$EventType[EventType.EVENT_PIXEL_CALLBACK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$tencent$mobileqq$zplan$minihome$EventType[EventType.EVENT_TIME_STAT_CALLBACK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$tencent$mobileqq$zplan$minihome$EventType[EventType.EVENT_ERROR_CALLBACK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes35.dex */
    public class ProfileZPlanScrollController extends AbsHandleEventListener {
        private ArrayList<IZPlanRefreshMoveListener> mRefreshMoveListeners;
        private ArrayList<OnRefreshStateListener> mRefreshStateListeners;
        private float mTouchEventLastY;
        private String targetUin = "";
        private boolean isMyCard = true;
        private boolean mIsSlideDown = false;
        private final b.a mZPlanHeaderClickListener = new b.a() { // from class: com.tencent.mobileqq.profilecard.view.head.AbsZPlanProfileHeaderView.ProfileZPlanScrollController.1
            @Override // com.tencent.mobileqq.zplan.view.b.a
            public void gotoSmallHome() {
                String str;
                if (((AbsProfileHeaderView) AbsZPlanProfileHeaderView.this).mCardInfo != null && ((AbsProfileHeaderView) AbsZPlanProfileHeaderView.this).mCardInfo.card != null) {
                    QLog.i(AbsZPlanProfileHeaderView.TAG, 1, "gotoSmallHome");
                    if (AbsZPlanProfileHeaderView.this.isFriendCard()) {
                        str = "guest_avatar_profile";
                    } else {
                        str = "owner_avatar_profile";
                    }
                    ((IZPlanApi) QRoute.api(IZPlanApi.class)).launchScheme(AbsZPlanProfileHeaderView.this.getContext(), ((IZPlanApi) QRoute.api(IZPlanApi.class)).generateXWConnectScheme(str, null, ((AbsProfileHeaderView) AbsZPlanProfileHeaderView.this).mCardInfo.card.uin, false, null));
                    ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).reportDtZplanEntranceClick(((AbsProfileHeaderView) AbsZPlanProfileHeaderView.this).mCardInfo, IProfileCardApi.ZPlanJumpSource.CLICK, IProfileCardApi.ZPlanJumpMode.SMALL_HOME, "xiaowo", 1);
                    return;
                }
                QLog.e(AbsZPlanProfileHeaderView.TAG, 1, "gotoSmallHome failed, cardInfo null.");
            }

            @Override // com.tencent.mobileqq.zplan.view.b.a
            public void showMaintain() {
                QLog.i(AbsZPlanProfileHeaderView.TAG, 1, "showMaintain");
                gotoPortal(1);
            }

            @Override // com.tencent.mobileqq.zplan.view.b.a
            public void gotoPortal(int i3) {
                QLog.i(AbsZPlanProfileHeaderView.TAG, 1, "gotoPortal");
                ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).jumpToZplanLoadingPage(AbsZPlanProfileHeaderView.this.getContext(), ((AbsProfileHeaderView) AbsZPlanProfileHeaderView.this).mCardInfo, IProfileCardApi.ZPlanJumpSource.CLICK);
            }
        };

        public ProfileZPlanScrollController() {
            init();
        }

        private void callBackRefreshReleaseListener() {
            ArrayList<IZPlanRefreshMoveListener> arrayList = this.mRefreshMoveListeners;
            if (arrayList == null) {
                return;
            }
            Iterator<IZPlanRefreshMoveListener> it = arrayList.iterator();
            while (it.hasNext()) {
                IZPlanRefreshMoveListener next = it.next();
                if (next != null) {
                    next.onRelease();
                }
            }
        }

        private void callBackRefreshStateChangeListener(int i3) {
            ArrayList<IZPlanRefreshMoveListener> arrayList = this.mRefreshMoveListeners;
            if (arrayList == null) {
                return;
            }
            Iterator<IZPlanRefreshMoveListener> it = arrayList.iterator();
            while (it.hasNext()) {
                IZPlanRefreshMoveListener next = it.next();
                if (next != null) {
                    next.onStateChange(i3);
                }
            }
        }

        private void callBackRefreshStateListener(int i3, Object obj) {
            ArrayList<OnRefreshStateListener> arrayList = this.mRefreshStateListeners;
            if (arrayList == null || arrayList.size() <= 0) {
                return;
            }
            Iterator<OnRefreshStateListener> it = this.mRefreshStateListeners.iterator();
            while (it.hasNext()) {
                OnRefreshStateListener next = it.next();
                if (next != null) {
                    next.onRefreshStateChange(i3, null);
                }
            }
        }

        private void init() {
            String str;
            if (((AbsProfileHeaderView) AbsZPlanProfileHeaderView.this).mCardInfo != null && ((AbsProfileHeaderView) AbsZPlanProfileHeaderView.this).mCardInfo.allInOne != null) {
                this.targetUin = ((AbsProfileHeaderView) AbsZPlanProfileHeaderView.this).mCardInfo.allInOne.uin;
            }
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                str = peekAppRuntime.getCurrentAccountUin();
            } else {
                str = "";
            }
            this.isMyCard = !TextUtils.isEmpty(str) && str.equals(this.targetUin);
            QLog.i(AbsZPlanProfileHeaderView.TAG, 1, "isMyCard: " + this.isMyCard);
        }

        private boolean isOnTop() {
            Rect rect = new Rect();
            View childAt = ((ProfileBaseView) AbsZPlanProfileHeaderView.this).mListView != null ? ((ProfileBaseView) AbsZPlanProfileHeaderView.this).mListView.getChildAt(0) : null;
            if (childAt == null) {
                return false;
            }
            childAt.getLocalVisibleRect(rect);
            return rect.top == 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ boolean lambda$initZPlanBannerListener$0(View view, MotionEvent motionEvent) {
            QLog.i(AbsZPlanProfileHeaderView.TAG, 1, "setOnTouchListener " + motionEvent.getActionMasked() + "; " + motionEvent.getRawY());
            if (motionEvent.getActionMasked() == 0) {
                AbsZPlanProfileHeaderView.this.mZPlanHeaderTouchDelegate.c(null);
                return false;
            }
            if (motionEvent.getActionMasked() != 1) {
                return false;
            }
            AbsZPlanProfileHeaderView.this.mZPlanHeaderTouchDelegate.c(motionEvent);
            return false;
        }

        public void callBackRefreshMoveListener(int i3) {
            ArrayList<IZPlanRefreshMoveListener> arrayList = this.mRefreshMoveListeners;
            if (arrayList == null) {
                return;
            }
            Iterator<IZPlanRefreshMoveListener> it = arrayList.iterator();
            while (it.hasNext()) {
                IZPlanRefreshMoveListener next = it.next();
                if (next != null) {
                    next.onMove(i3);
                }
            }
        }

        public void handleDefaultMotionEvent(boolean z16) {
            if (isHandleMoveEvent(z16)) {
                onRelease(z16);
            }
        }

        @Override // com.tencent.mobileqq.profilecard.AbsHandleEventListener
        public boolean handleEvent(MotionEvent motionEvent) {
            if (!AbsZPlanProfileHeaderView.this.mIsShowZplanCover) {
                return false;
            }
            int actionMasked = motionEvent.getActionMasked() & 255;
            if (actionMasked != 0) {
                if (actionMasked == 1) {
                    this.mTouchEventLastY = 0.0f;
                    if (MiniHomeSceneEnum.SCENE_PROFILE.getSceneConfig().getUseTouchEvent() && AbsZPlanProfileHeaderView.this.mMiniHomeController != null && motionEvent.getRawY() < AbsZPlanProfileHeaderView.this.getInitHeight().intValue()) {
                        AbsZPlanProfileHeaderView.this.mMiniHomeController.onTouchEvent(motionEvent);
                    }
                    handleDefaultMotionEvent(this.mIsSlideDown);
                } else if (actionMasked == 2) {
                    if ((((ProfileBaseView) AbsZPlanProfileHeaderView.this).mListView != null ? ((ProfileBaseView) AbsZPlanProfileHeaderView.this).mListView.getFirstVisiblePosition() : -1) != 0) {
                        return false;
                    }
                    if (MiniHomeSceneEnum.SCENE_PROFILE.getSceneConfig().getUseTouchEvent() && AbsZPlanProfileHeaderView.this.mMiniHomeController != null && motionEvent.getRawY() < AbsZPlanProfileHeaderView.this.getInitHeight().intValue()) {
                        AbsZPlanProfileHeaderView.this.mMiniHomeController.onTouchEvent(motionEvent);
                        return true;
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
            } else {
                this.mTouchEventLastY = motionEvent.getRawY();
                if (MiniHomeSceneEnum.SCENE_PROFILE.getSceneConfig().getUseTouchEvent() && AbsZPlanProfileHeaderView.this.mMiniHomeController != null && motionEvent.getRawY() < AbsZPlanProfileHeaderView.this.getInitHeight().intValue()) {
                    AbsZPlanProfileHeaderView.this.mMiniHomeController.onTouchEvent(motionEvent);
                }
            }
            return false;
        }

        public void initZPlanBannerListener() {
            if (AbsZPlanProfileHeaderView.this.mZplanAvatarBannerManager == null && AbsZPlanProfileHeaderView.this.mMiniHomeController == null) {
                return;
            }
            if (AbsZPlanProfileHeaderView.this.mZplanAvatarBannerManager != null) {
                this.mRefreshStateListeners = (ArrayList) AbsZPlanProfileHeaderView.this.mZplanAvatarBannerManager.d();
                this.mRefreshMoveListeners = (ArrayList) AbsZPlanProfileHeaderView.this.mZplanAvatarBannerManager.c();
            }
            if (AbsZPlanProfileHeaderView.this.mZPlanBannerLayout == null || AbsZPlanProfileHeaderView.this.mZPlanHeaderTouchDelegate == null) {
                return;
            }
            AbsZPlanProfileHeaderView.this.mZPlanBannerLayout.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.profilecard.view.head.x
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    boolean lambda$initZPlanBannerListener$0;
                    lambda$initZPlanBannerListener$0 = AbsZPlanProfileHeaderView.ProfileZPlanScrollController.this.lambda$initZPlanBannerListener$0(view, motionEvent);
                    return lambda$initZPlanBannerListener$0;
                }
            });
            AbsZPlanProfileHeaderView.this.mZPlanBannerLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.profilecard.view.head.AbsZPlanProfileHeaderView.ProfileZPlanScrollController.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    QLog.i(AbsZPlanProfileHeaderView.TAG, 2, "mZPlanBannerLayout onClick");
                    if (AbsZPlanProfileHeaderView.this.enableMiniHomeProfile()) {
                        if (AbsZPlanProfileHeaderView.this.hasPixelCallback.get()) {
                            QLog.i(AbsZPlanProfileHeaderView.TAG, 2, "mZPlanBannerLayout onClick jumpToZplanLoadingPage");
                            ((IZPlanApi) QRoute.api(IZPlanApi.class)).launchSchemeWithContext(view.getContext(), ((IZPlanApi) QRoute.api(IZPlanApi.class)).generateXWConnectScheme("owner_profile", null, ((AbsProfileHeaderView) AbsZPlanProfileHeaderView.this).mApp.getCurrentUin(), false, null));
                            return;
                        }
                        return;
                    }
                    QLog.i(AbsZPlanProfileHeaderView.TAG, 2, "mZPlanBannerLayout onClick mZPlanHeaderClickListener");
                    AbsZPlanProfileHeaderView.this.mZPlanHeaderTouchDelegate.d(ProfileZPlanScrollController.this.mZPlanHeaderClickListener);
                }
            });
        }

        public boolean isHandleMoveEvent(boolean z16) {
            if (AbsZPlanProfileHeaderView.this.mState == 17) {
                return false;
            }
            return AbsZPlanProfileHeaderView.this.mState != -1 || (isOnTop() && z16);
        }

        public void onDestroy() {
            releaseZPlanAvatarBannerManager();
            VasIpcTempData.INSTANCE.getTempVar().setLong("key_profile_half_screen", -1L);
        }

        public boolean onMove(float f16, boolean z16) {
            if (!isHandleMoveEvent(z16)) {
                return false;
            }
            int visibleHeight = AbsZPlanProfileHeaderView.this.getVisibleHeight();
            AbsZPlanProfileHeaderView.this.setVisibleHeight(((int) f16) + visibleHeight);
            ni3.a aVar = ni3.a.f420201a;
            Integer d16 = aVar.d();
            if (d16 != null && visibleHeight > d16.intValue()) {
                setState(16);
                return true;
            }
            Integer f17 = aVar.f();
            if (f17 == null || visibleHeight <= f17.intValue()) {
                Integer initHeight = AbsZPlanProfileHeaderView.this.getInitHeight();
                if (initHeight == null || visibleHeight < initHeight.intValue()) {
                    Integer attachTopHeightLower = AbsZPlanProfileHeaderView.this.getAttachTopHeightLower();
                    if (attachTopHeightLower == null || visibleHeight <= attachTopHeightLower.intValue()) {
                        Integer attachTopHeightUpper = AbsZPlanProfileHeaderView.this.getAttachTopHeightUpper();
                        if (attachTopHeightUpper != null && visibleHeight > attachTopHeightUpper.intValue()) {
                            setState(11);
                            return true;
                        }
                        if (visibleHeight > aVar.c()) {
                            setState(10);
                            AbsZPlanProfileHeaderView.this.setZPlanCornerBgVisible(8);
                            return true;
                        }
                        setState(-1);
                        return true;
                    }
                    setState(12);
                    return true;
                }
                setState(13);
                return true;
            }
            setState(14);
            return true;
        }

        public void onPause() {
            if (AbsZPlanProfileHeaderView.this.mZplanAvatarBannerManager != null) {
                AbsZPlanProfileHeaderView.this.mZplanAvatarBannerManager.m();
            }
        }

        public void onReset() {
            smoothScrollToInitHeight();
            AbsZPlanProfileHeaderView.this.adjustTitle();
        }

        public void onResume() {
            if (AbsZPlanProfileHeaderView.this.mState == 17) {
                smoothScrollToInitHeight();
            }
            AbsZPlanProfileHeaderView.this.adjustTitle();
            if (AbsZPlanProfileHeaderView.this.mZplanAvatarBannerManager != null) {
                AbsZPlanProfileHeaderView.this.mZplanAvatarBannerManager.o();
            }
        }

        public void setState(int i3) {
            if (AbsZPlanProfileHeaderView.this.mState != i3) {
                AbsZPlanProfileHeaderView.this.mState = i3;
                callBackRefreshStateListener(AbsZPlanProfileHeaderView.this.mState, null);
                FrameLayout frameLayout = AbsZPlanProfileHeaderView.this.mZplanCoverView;
                if (frameLayout != null) {
                    callBackRefreshMoveListener(frameLayout.getHeight());
                }
                AbsZPlanProfileHeaderView.this.adjustTitle();
                if (AbsZPlanProfileHeaderView.this.mState == 17) {
                    IProfileCardApi iProfileCardApi = (IProfileCardApi) QRoute.api(IProfileCardApi.class);
                    QBaseActivity qBaseActivity = ((AbsProfileHeaderView) AbsZPlanProfileHeaderView.this).mActivity;
                    ProfileCardInfo profileCardInfo = ((AbsProfileHeaderView) AbsZPlanProfileHeaderView.this).mCardInfo;
                    IProfileCardApi.ZPlanJumpSource zPlanJumpSource = IProfileCardApi.ZPlanJumpSource.PULL;
                    iProfileCardApi.jumpToZplanLoadingPage(qBaseActivity, profileCardInfo, zPlanJumpSource);
                    ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).reportDtZplanEntranceClick(((AbsProfileHeaderView) AbsZPlanProfileHeaderView.this).mCardInfo, zPlanJumpSource, IProfileCardApi.ZPlanJumpMode.PORTAL, "default", 2);
                }
                if (AbsZPlanProfileHeaderView.this.mState == -1) {
                    if (AbsZPlanProfileHeaderView.this.mZplanAvatarBannerManager != null) {
                        AbsZPlanProfileHeaderView.this.mZplanAvatarBannerManager.m();
                    }
                    if (AbsZPlanProfileHeaderView.this.mMiniHomeController != null) {
                        AbsZPlanProfileHeaderView.this.mMiniHomeController.pause();
                    }
                }
                if (AbsZPlanProfileHeaderView.this.mState == 13) {
                    if (AbsZPlanProfileHeaderView.this.mZplanAvatarBannerManager != null) {
                        AbsZPlanProfileHeaderView.this.mZplanAvatarBannerManager.o();
                    }
                    if (AbsZPlanProfileHeaderView.this.mMiniHomeController != null) {
                        AbsZPlanProfileHeaderView.this.mMiniHomeController.resume();
                    }
                }
            }
        }

        public void smoothScrollToInitHeight() {
            QLog.d(AbsZPlanProfileHeaderView.TAG, 1, "[smoothScrollToInitHeight]");
            Integer initHeight = AbsZPlanProfileHeaderView.this.getInitHeight();
            if (initHeight == null) {
                QLog.e(AbsZPlanProfileHeaderView.TAG, 1, "smoothScrollToInitHeight failed, initHeight null.");
            } else {
                smoothScrollTo(initHeight.intValue());
                setState(13);
            }
        }

        public void onRelease(boolean z16) {
            QLog.d(AbsZPlanProfileHeaderView.TAG, 1, "[onRelease] mState:", Integer.valueOf(AbsZPlanProfileHeaderView.this.mState));
            callBackRefreshStateChangeListener(AbsZPlanProfileHeaderView.this.mState);
            callBackRefreshReleaseListener();
            switch (AbsZPlanProfileHeaderView.this.mState) {
                case 10:
                    smoothScrollToClose();
                    return;
                case 11:
                    if (z16) {
                        smoothScrollToInitHeight();
                        return;
                    } else {
                        smoothScrollToClose();
                        return;
                    }
                case 12:
                case 13:
                case 14:
                    smoothScrollToInitHeight();
                    return;
                case 15:
                default:
                    return;
                case 16:
                    setState(17);
                    AbsZPlanProfileHeaderView.this.dismissUserGuide();
                    if (((IProfileCardApi) QRoute.api(IProfileCardApi.class)).isZplanUnderMaintenance()) {
                        smoothScrollToInitHeight();
                        return;
                    } else {
                        smoothScrollTo(ScreenUtil.getRealHeight(BaseApplication.getContext()));
                        return;
                    }
            }
        }

        public void releaseZPlanAvatarBannerManager() {
            QLog.i(AbsZPlanProfileHeaderView.TAG, 1, "releaseZPlanAvatarBannerManager");
            if (AbsZPlanProfileHeaderView.this.mAvatarOverlayViewWiringHelper != null) {
                AbsZPlanProfileHeaderView.this.mAvatarOverlayViewWiringHelper.release();
                AbsZPlanProfileHeaderView.this.mAvatarOverlayViewWiringHelper = null;
            }
            if (AbsZPlanProfileHeaderView.this.mZplanAvatarBannerManager != null) {
                AbsZPlanProfileHeaderView.this.mZplanAvatarBannerManager.n();
                AbsZPlanProfileHeaderView.this.mZplanAvatarBannerManager = null;
            }
        }

        protected void smoothScrollTo(int i3) {
            ValueAnimator ofInt = ValueAnimator.ofInt(AbsZPlanProfileHeaderView.this.getVisibleHeight(), i3);
            ofInt.setDuration(200L).start();
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.profilecard.view.head.AbsZPlanProfileHeaderView.ProfileZPlanScrollController.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AbsZPlanProfileHeaderView.this.setVisibleHeight(((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            });
            ofInt.addListener(new Animator.AnimatorListener() { // from class: com.tencent.mobileqq.profilecard.view.head.AbsZPlanProfileHeaderView.ProfileZPlanScrollController.4
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (AbsZPlanProfileHeaderView.this.mState == -1) {
                        AbsZPlanProfileHeaderView.this.setZPlanCornerBgVisible(0);
                    } else {
                        AbsZPlanProfileHeaderView.this.setZPlanCornerBgVisible(8);
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    AbsZPlanProfileHeaderView.this.setZPlanCornerBgVisible(8);
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

        public void smoothScrollToClose() {
            QLog.d(AbsZPlanProfileHeaderView.TAG, 1, "[smoothScrollToClose]");
            int c16 = ni3.a.f420201a.c();
            setState(-1);
            smoothScrollTo(c16);
        }
    }

    public AbsZPlanProfileHeaderView(QBaseActivity qBaseActivity, ProfileCardInfo profileCardInfo) {
        super(qBaseActivity, profileCardInfo);
        this.mMaxPullDownHeight = ViewUtils.getScreenHeight() / 2;
        this.mIsShowZplanCover = false;
        this.mState = 0;
        this.mMiniHomeController = null;
        this.loadingRoomDesc = null;
        this.needForceReload = new AtomicBoolean(false);
        this.disableAddView = new AtomicBoolean(false);
        this.mGiftDesc = null;
        this.mMiniHomeReporterV2 = null;
        this.mPageStartTime = 0L;
        this.mPageEndTime = 0L;
        this.mEngineStartTime = 0L;
        this.mLoadStartTime = 0L;
        this.mRoomLoaded = new AtomicBoolean(false);
        this.mAvatarLoaded = new AtomicBoolean(false);
        this.mFirstFramed = new AtomicBoolean(false);
        this.mFirstFrameTime = 0L;
        this.mHideStaticImageTime = 0L;
        this.mTimeStatCallbacked = new AtomicBoolean(false);
        this.mHasPausedBeforeFirstFrame = false;
        this.mHasReported = false;
        this.mMiniHomeReporter = null;
        this.mPixelCallbackDuration = -1L;
        this.mRoomLoadDuration = -1L;
        this.mAvatarLoadDuration = -1L;
        this.mIsResetRoomAndAvatar = false;
        this.mMiniHomeEntranceFrom = "";
        this.requestMiniHomeCallback = null;
        this.hasResume = false;
        this.hasDestroy = false;
        this.enableMiniHomeProfile = false;
        this.lastEnableMiniHome = false;
        this.hasPixelCallback = new AtomicBoolean(false);
        this.recordMiniHomeFirstFrame = true;
        this.mActivityWeakRef = null;
        this.mZPlanRequestObserver = new com.tencent.mobileqq.zplan.servlet.b() { // from class: com.tencent.mobileqq.profilecard.view.head.AbsZPlanProfileHeaderView.1
            @Override // com.tencent.mobileqq.app.BusinessObserver
            public void onUpdate(int i3, boolean z16, Object obj) {
                List emptyList;
                if (i3 == 27405) {
                    try {
                        emptyList = (List) obj;
                    } catch (Throwable th5) {
                        QLog.e(AbsZPlanProfileHeaderView.TAG, 1, "onUpdate PROFILE_APPEARANCE_KEY exception", th5);
                        emptyList = Collections.emptyList();
                    }
                    if (((AbsProfileHeaderView) AbsZPlanProfileHeaderView.this).mCardInfo != null && ((AbsProfileHeaderView) AbsZPlanProfileHeaderView.this).mCardInfo.card != null) {
                        if (emptyList.contains(((AbsProfileHeaderView) AbsZPlanProfileHeaderView.this).mCardInfo.card.uin)) {
                            if (AbsZPlanProfileHeaderView.this.mZplanAvatarBannerManager != null) {
                                AbsZPlanProfileHeaderView.this.mZplanAvatarBannerManager.g();
                            }
                            if (AbsZPlanProfileHeaderView.this.mMiniHomeController == null || AbsZPlanProfileHeaderView.this.hasResume) {
                                return;
                            }
                            AbsZPlanProfileHeaderView.this.mMiniHomeController.resume();
                            AbsZPlanProfileHeaderView.this.needForceReload.set(true);
                            AbsZPlanProfileHeaderView.this.disableAddView.set(true);
                            AbsZPlanProfileHeaderView.this.loadRoomAndAvatar(MiniHomeLoadSource.APPERANCE_CHANGE);
                            return;
                        }
                        QLog.i(AbsZPlanProfileHeaderView.TAG, 1, "onUpdate PROFILE_APPEARANCE_KEY current uin's appearanceKey not changed.");
                        return;
                    }
                    QLog.i(AbsZPlanProfileHeaderView.TAG, 1, "onUpdate PROFILE_APPEARANCE_KEY mCardInfo is null.");
                }
            }
        };
        com.tencent.mobileqq.zplan.minihome.ac acVar = new com.tencent.mobileqq.zplan.minihome.ac() { // from class: com.tencent.mobileqq.profilecard.view.head.v
            @Override // com.tencent.mobileqq.zplan.minihome.ac
            public final void a(com.tencent.mobileqq.zplan.minihome.am amVar, MiniHomeSceneEnum miniHomeSceneEnum) {
                AbsZPlanProfileHeaderView.this.lambda$new$0(amVar, miniHomeSceneEnum);
            }
        };
        this.mMiniHomeSceneEventCallback = acVar;
        this.mMiniHomeSceneEventCallbackRef = new WeakReference<>(acVar);
        this.mHasManagerResumed = new AtomicBoolean(false);
        this.loadRoomCallback = new IMiniHomeLoadCallback() { // from class: com.tencent.mobileqq.profilecard.view.head.AbsZPlanProfileHeaderView.3
            @Override // com.tencent.filament.zplan.scene.minihome.IMiniHomeLoadCallback
            public void onMiniHomeLoadResult(boolean z16, String str) {
                QLog.i(AbsZPlanProfileHeaderView.TAG, 1, "loadRoom onMiniHomeLoadResult success: " + z16);
                AbsZPlanProfileHeaderView.this.mRoomLoaded.compareAndSet(false, z16);
                long currentTimeMillis = System.currentTimeMillis();
                AbsZPlanProfileHeaderView absZPlanProfileHeaderView = AbsZPlanProfileHeaderView.this;
                absZPlanProfileHeaderView.mRoomLoadDuration = currentTimeMillis - absZPlanProfileHeaderView.mMiniHomeRoomLoadStartTime;
                QLog.i(AbsZPlanProfileHeaderView.TAG, 1, "roomLoadDuration: " + AbsZPlanProfileHeaderView.this.mRoomLoadDuration + "; startTime " + AbsZPlanProfileHeaderView.this.mMiniHomeRoomLoadStartTime + ", endTime: " + currentTimeMillis);
            }
        };
        this.loadAvatarCallback = new IMiniHomeLoadCallback() { // from class: com.tencent.mobileqq.profilecard.view.head.AbsZPlanProfileHeaderView.4
            @Override // com.tencent.filament.zplan.scene.minihome.IMiniHomeLoadCallback
            public void onMiniHomeLoadResult(boolean z16, String str) {
                QLog.i(AbsZPlanProfileHeaderView.TAG, 1, "loadAvatar onMiniHomeLoadResult success: " + z16);
                AbsZPlanProfileHeaderView.this.mAvatarLoaded.compareAndSet(false, z16);
                long currentTimeMillis = System.currentTimeMillis();
                AbsZPlanProfileHeaderView absZPlanProfileHeaderView = AbsZPlanProfileHeaderView.this;
                absZPlanProfileHeaderView.mAvatarLoadDuration = currentTimeMillis - absZPlanProfileHeaderView.mMiniHomeAvatarLoadStartTime;
                QLog.i(AbsZPlanProfileHeaderView.TAG, 1, "avatarLoadDuration: " + AbsZPlanProfileHeaderView.this.mAvatarLoadDuration + "; startTime " + AbsZPlanProfileHeaderView.this.mMiniHomeAvatarLoadStartTime + ", endTime: " + currentTimeMillis);
            }
        };
        this.mLoadingOverlayObserver = new Observer<Boolean>() { // from class: com.tencent.mobileqq.profilecard.view.head.AbsZPlanProfileHeaderView.10
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                if (AbsZPlanProfileHeaderView.this.mZplanUserGuideImageLayout == null) {
                    QLog.w(AbsZPlanProfileHeaderView.TAG, 1, "zplan guide layout haven't init yet.");
                    if (AbsZPlanProfileHeaderView.this.mAvatarOverlayViewWiringHelper == null || AbsZPlanProfileHeaderView.this.mAvatarOverlayViewWiringHelper.c() == null) {
                        return;
                    }
                    AbsZPlanProfileHeaderView.this.mAvatarOverlayViewWiringHelper.c().removeObserver(AbsZPlanProfileHeaderView.this.mLoadingOverlayObserver);
                    return;
                }
                if (bool.booleanValue()) {
                    AbsZPlanProfileHeaderView.this.mZplanUserGuideImageLayout.setVisibility(8);
                } else {
                    AbsZPlanProfileHeaderView.this.checkZPlanUserGuideStatus();
                }
                if (AbsZPlanProfileHeaderView.this.mAvatarOverlayViewWiringHelper == null || AbsZPlanProfileHeaderView.this.mAvatarOverlayViewWiringHelper.c() == null) {
                    return;
                }
                AbsZPlanProfileHeaderView.this.mAvatarOverlayViewWiringHelper.c().removeObserver(AbsZPlanProfileHeaderView.this.mLoadingOverlayObserver);
            }
        };
        this.mActivityWeakRef = new WeakReference<>(this.mActivity);
        resetMaxVisibilityHeight();
        this.mPageStartTime = System.currentTimeMillis();
        createMiniHomeReporterV2();
    }

    private void addMiniHomeEditImage() {
        if (!isFriendCard() && ((IZPlanQQMC) QRoute.api(IZPlanQQMC.class)).enableMiniHomeEdit()) {
            if (this.mZPlanBannerLayout != null && this.mMiniHomeController != null) {
                if (this.mMiniHomeEditImage != null) {
                    return;
                }
                ImageView imageView = new ImageView(getContext());
                this.mMiniHomeEditImage = imageView;
                imageView.setScaleType(ImageView.ScaleType.CENTER);
                this.mMiniHomeEditImage.setBackgroundResource(R.drawable.f161203k73);
                this.mMiniHomeEditImage.setImageDrawable(getResources().getDrawable(R.drawable.g_q));
                AccessibilityUtil.s(this.mMiniHomeEditImage, HardCodeUtil.qqStr(R.string.x5y));
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ViewUtils.dpToPx(36.0f), ViewUtils.dpToPx(36.0f));
                layoutParams.gravity = 5;
                layoutParams.rightMargin = ViewUtils.dpToPx(66.0f);
                layoutParams.topMargin = (int) (getContext().getResources().getDisplayMetrics().heightPixels * getMiniHomeButtonHeightRate());
                this.mZPlanBannerLayout.addView(this.mMiniHomeEditImage, layoutParams);
                this.mMiniHomeEditImage.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.profilecard.view.head.o
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        AbsZPlanProfileHeaderView.this.lambda$addMiniHomeEditImage$11(view);
                    }
                });
                ProfileCardDtReportUtil.initElementWithExposureClick(this.mMiniHomeEditImage, "em_zplan_decorate_btn");
                VideoReport.reportEvent("imp", this.mMiniHomeEditImage, null);
                return;
            }
            QLog.e(TAG, 1, "addMiniHomeEditImage error, mZPlanBannerLayout: " + this.mZPlanBannerLayout + "; mMiniHomeController: " + this.mMiniHomeController);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addMiniHomeGiftImageIfNeed() {
        GiftDesc giftDesc;
        if (isFriendCard() && (giftDesc = this.mGiftDesc) != null) {
            if (this.mZPlanBannerLayout != null && this.mMiniHomeController != null) {
                if (this.mMiniHomeGiftImage != null) {
                    return;
                }
                String iconUrl = giftDesc.getIconUrl();
                String giftBubbleText = this.mGiftDesc.getGiftBubbleText();
                if (TextUtils.isEmpty(iconUrl)) {
                    return;
                }
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                Drawable drawable = com.tencent.mobileqq.urldrawable.b.f306350a;
                obtain.mFailedDrawable = drawable;
                obtain.mLoadingDrawable = drawable;
                obtain.mUseApngImage = true;
                URLDrawable drawable2 = URLDrawable.getDrawable(iconUrl, obtain);
                ImageView imageView = new ImageView(getContext());
                this.mMiniHomeGiftImage = imageView;
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                this.mMiniHomeGiftImage.setImageDrawable(drawable2);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ViewUtils.dpToPx(64.0f), ViewUtils.dpToPx(64.0f));
                layoutParams.gravity = 3;
                layoutParams.topMargin = (int) (getContext().getResources().getDisplayMetrics().heightPixels * 0.33d);
                layoutParams.leftMargin = ViewUtils.dpToPx(7.5f);
                this.mZPlanBannerLayout.addView(this.mMiniHomeGiftImage, layoutParams);
                this.mMiniHomeGiftImage.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.profilecard.view.head.m
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        AbsZPlanProfileHeaderView.this.lambda$addMiniHomeGiftImageIfNeed$12(view);
                    }
                });
                showRewardGiftBubbleIfNeed(giftBubbleText);
                ProfileCardDtReportUtil.initElementWithExposureClick(this.mMiniHomeGiftImage, "em_zplan_gift_entrance");
                VideoReport.reportEvent("imp", this.mMiniHomeGiftImage, null);
                return;
            }
            QLog.e(TAG, 1, "addMiniHomeEditImage error, mZPlanBannerLayout: " + this.mZPlanBannerLayout + "; mMiniHomeController: " + this.mMiniHomeController);
            return;
        }
        QLog.i(TAG, 1, "addMiniHomeGiftImageIfNeed failed, isFriendCard: " + isFriendCard());
    }

    private void addMiniHomeView() {
        if (this.disableAddView.get()) {
            this.disableAddView.set(false);
        } else {
            runOnUIThread(new Runnable() { // from class: com.tencent.mobileqq.profilecard.view.head.k
                @Override // java.lang.Runnable
                public final void run() {
                    AbsZPlanProfileHeaderView.this.lambda$addMiniHomeView$8();
                }
            });
        }
    }

    private void addXiaoWoImage() {
        if (this.mZPlanBannerLayout != null && this.mMiniHomeController != null) {
            if (this.mXiaowoImage != null) {
                return;
            }
            ImageView imageView = new ImageView(getContext());
            this.mXiaowoImage = imageView;
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            this.mXiaowoImage.setBackgroundResource(R.drawable.f161203k73);
            this.mXiaowoImage.setImageDrawable(getResources().getDrawable(R.drawable.g_r));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ViewUtils.dpToPx(36.0f), ViewUtils.dpToPx(36.0f));
            layoutParams.gravity = 5;
            layoutParams.rightMargin = ViewUtils.dpToPx(15.0f);
            layoutParams.topMargin = (int) (getContext().getResources().getDisplayMetrics().heightPixels * getMiniHomeButtonHeightRate());
            this.mZPlanBannerLayout.addView(this.mXiaowoImage, layoutParams);
            AccessibilityUtil.s(this.mXiaowoImage, HardCodeUtil.qqStr(R.string.x5v));
            this.mXiaowoImage.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.profilecard.view.head.u
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AbsZPlanProfileHeaderView.this.lambda$addXiaoWoImage$10(view);
                }
            });
            ProfileCardDtReportUtil.initElementWithExposureClick(this.mXiaowoImage, "em_zplan_goto_xiaowo");
            return;
        }
        QLog.e(TAG, 1, "addXiaoWoButton error, mZPlanBannerLayout: " + this.mZPlanBannerLayout + "; mMiniHomeController: " + this.mMiniHomeController);
    }

    private void addZPlanBannerLayout() {
        QLog.i(TAG, 1, "addZPlanBannerLayout");
        if (this.mZPlanBannerLayout != null) {
            QLog.e(TAG, 1, "addZPlanBannerLayout mZPlanBannerLayout is not null, return.");
            return;
        }
        if (this.mZplanCoverView == null) {
            QLog.e(TAG, 1, "addZPlanBannerLayout failed, cover view null.");
            return;
        }
        QLog.i(TAG, 2, "[showZPlanStaticView]");
        com.tencent.mobileqq.zplan.utils.ag agVar = com.tencent.mobileqq.zplan.utils.ag.f335760a;
        this.mZPlanBannerLayout = agVar.c(BaseApplication.getContext());
        this.mZPlanHeaderTouchDelegate = agVar.b(this, ZPlanAvatarSource.PROFILE, enableFoldSplit(), getFriendUin());
        this.mZplanCoverView.addView(this.mZPlanBannerLayout, new RelativeLayout.LayoutParams(-1, ViewUtils.getScreenHeight()));
        this.needForceReload.set(true);
        if (this.enableMiniHomeProfile) {
            initZPlanMiniHomeController();
        } else {
            initZPlanAvatarBannerManager();
        }
        if (this.mProfileZPlanControlManager == null) {
            this.mProfileZPlanControlManager = new ProfileZPlanScrollController();
        }
        this.mProfileZPlanControlManager.initZPlanBannerListener();
        initAvatarLoadingOverlay();
    }

    private void addZPlanObserver() {
        removeZPlanObserver();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.e(TAG, 1, "AppRuntime is null when ZPlan appearanceKey changed!");
        } else if (peekAppRuntime instanceof QQAppInterface) {
            QLog.i(TAG, 4, "addZPlanObserver");
            ((QQAppInterface) peekAppRuntime).addObserver(this.mZPlanRequestObserver);
        }
    }

    private void createMiniHomeReporter(MiniHomeLoadSource miniHomeLoadSource) {
        MiniHomeProfileCardType miniHomeProfileCardType;
        if (this.mMiniHomeReporter != null) {
            reportMiniHomeExit(miniHomeLoadSource.getResportString());
            if (miniHomeLoadSource == MiniHomeLoadSource.APPERANCE_CHANGE) {
                this.mMiniHomeEntranceFrom = "appearance_chg";
            }
        }
        this.mMiniHomeReporter = ((IMiniHomeHelper) QRoute.api(IMiniHomeHelper.class)).createMiniHomeReporter();
        if (TextUtils.isEmpty(this.mMiniHomeEntranceFrom)) {
            this.mMiniHomeEntranceFrom = "normal";
        }
        if (isFriendCard()) {
            miniHomeProfileCardType = MiniHomeProfileCardType.FRIEND_CARD;
        } else {
            miniHomeProfileCardType = MiniHomeProfileCardType.SELF_CARD;
        }
        this.mMiniHomeReporter.a(miniHomeProfileCardType);
        String str = this.mCardInfo.card.uin;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mMiniHomeReporter.d(str);
    }

    private void createMiniHomeReporterV2() {
        MiniHomeProfileCardType miniHomeProfileCardType;
        this.mMiniHomeReporterV2 = ((IMiniHomeHelper) QRoute.api(IMiniHomeHelper.class)).createMiniHomeReporterV2();
        if (isFriendCard()) {
            miniHomeProfileCardType = MiniHomeProfileCardType.FRIEND_CARD;
        } else {
            miniHomeProfileCardType = MiniHomeProfileCardType.SELF_CARD;
        }
        this.mMiniHomeReporterV2.a(miniHomeProfileCardType);
    }

    private void doOnErrorCallback(com.tencent.mobileqq.zplan.minihome.am amVar) {
        if (amVar instanceof EventErrorCallback) {
            QLog.i(TAG, 1, "doOnErrorCallback");
            String data = ((EventErrorCallback) amVar).getData();
            long currentTimeMillis = this.mMiniHomeInitStartTime == 0 ? -1L : System.currentTimeMillis() - this.mMiniHomeInitStartTime;
            com.tencent.mobileqq.zplan.minihome.aa aaVar = this.mMiniHomeReporter;
            if (aaVar != null) {
                aaVar.b("zplanMiniHomeErrorMsg", data, Long.toString(currentTimeMillis));
            }
        }
    }

    private void doOnFirstFrameImgReady(EventFirstFrameImageReady eventFirstFrameImageReady) {
        ProfileCardInfo profileCardInfo;
        Card card;
        String data = eventFirstFrameImageReady.getData();
        QLog.i(TAG, 1, "doOnFirstFrameImgReady, data: " + data + " recordMiniHomeFirstFrame\uff1a" + this.recordMiniHomeFirstFrame);
        JSONObject b16 = com.tencent.zplan.common.utils.h.f385294a.b(data);
        if (b16 != null && (profileCardInfo = this.mCardInfo) != null && (card = profileCardInfo.card) != null) {
            String str = card.uin;
            String optString = b16.optString("imagePath", "");
            if (TextUtils.isEmpty(optString) || !this.recordMiniHomeFirstFrame) {
                return;
            }
            saveFirstFrameFileAsync(optString, str);
            return;
        }
        QLog.e(TAG, 1, "doOnFirstFrameImgReady card is null, return.");
    }

    private void doOnPixelCallback(com.tencent.mobileqq.zplan.minihome.am amVar) {
        com.tencent.mobileqq.zplan.minihome.y yVar;
        if (amVar instanceof EventPixelCallback) {
            QLog.i(TAG, 1, "doOnPixelCallback");
            this.hasPixelCallback.set(true);
            if (!this.hasResume && (yVar = this.mMiniHomeController) != null) {
                yVar.pause();
            }
            runOnUIThread(new Runnable() { // from class: com.tencent.mobileqq.profilecard.view.head.f
                @Override // java.lang.Runnable
                public final void run() {
                    AbsZPlanProfileHeaderView.this.lambda$doOnPixelCallback$17();
                }
            });
        }
    }

    private void doOnTimeStatCallback(com.tencent.mobileqq.zplan.minihome.am amVar) {
        if (amVar instanceof EventTimeStatCallback) {
            String data = ((EventTimeStatCallback) amVar).getData();
            if (!TextUtils.isEmpty(data)) {
                QLog.i(TAG, 1, "doOnTimeStatCallback, timeStat: " + data);
            } else {
                QLog.i(TAG, 1, "doOnTimeStatCallback, timeStat empty.");
            }
            com.tencent.mobileqq.zplan.minihome.aa aaVar = this.mMiniHomeReporter;
            if (aaVar != null) {
                aaVar.f("zplanMiniHomeStartUpStatistic", data, Long.toString(this.mPixelCallbackDuration));
            }
            com.tencent.mobileqq.zplan.minihome.ab abVar = this.mMiniHomeReporterV2;
            if (abVar == null || this.mHasReported) {
                return;
            }
            abVar.e(data);
            this.mMiniHomeReporterV2.c(this.mHasPausedBeforeFirstFrame, this.mHideStaticImageTime - this.mPageStartTime);
            com.tencent.mobileqq.zplan.minihome.ab abVar2 = this.mMiniHomeReporterV2;
            boolean z16 = this.mHasPausedBeforeFirstFrame;
            long j3 = this.mFirstFrameTime;
            abVar2.b(z16, j3 - this.mEngineStartTime, j3 - this.mLoadStartTime);
            this.mHasReported = true;
        }
    }

    private boolean enableFoldSplit() {
        IProfileActivityDelegate iProfileActivityDelegate = this.mDelegate;
        if (iProfileActivityDelegate == null) {
            return false;
        }
        return iProfileActivityDelegate.enableFoldSplit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean enableMiniHomeProfile() {
        ProfileCardInfo profileCardInfo = this.mCardInfo;
        if (profileCardInfo == null || profileCardInfo.card == null) {
            return false;
        }
        if (StudyModeManager.t()) {
            QLog.e(TAG, 1, "getStudyModeSwitch true, return false.");
            return false;
        }
        if (!((IZPlanApi) QRoute.api(IZPlanApi.class)).miniHomeQQMCSwitchOn()) {
            QLog.e(TAG, 1, "enableMiniHomeProfile enableMiniHomeQQMC false.");
            return false;
        }
        if (!((IZPlanAccessibleHelper) QRoute.api(IZPlanAccessibleHelper.class)).enableZPlanNativeAppFilament(isFriendCard() ? 3 : 2)) {
            QLog.e(TAG, 1, "enableMiniHomeProfile enableFilament false.");
            return false;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.e(TAG, 1, "enableMiniHomeProfile app null.");
            return false;
        }
        if (isFriendCard()) {
            QLog.i(TAG, 2, "enableMiniHomeProfile isZPlanProfileCardMiniHomeShow : " + this.mCardInfo.card.isZPlanProfileCardMiniHomeShow);
            if (!"1".equals(this.mCardInfo.card.isZPlanProfileCardMiniHomeShow)) {
                QLog.e(TAG, 1, "enableMiniHomeProfile isZPlanProfileCardMiniHomeShow false.");
                return false;
            }
        } else if (!((IMiniHomeHelper) QRoute.api(IMiniHomeHelper.class)).getZPlanMiniHomeSettingSwitch(peekAppRuntime.getLongAccountUin())) {
            QLog.e(TAG, 1, "enableMiniHomeProfile 1012 failed.");
            return false;
        }
        return getRoomDesc(this.mCardInfo.card.uin) != null;
    }

    private void ensureBubbleControllerCreated(FrameLayout frameLayout) {
        String str;
        com.tencent.mobileqq.zplan.bubble.b bVar = this.mAvatarBubbleController;
        if (bVar != null) {
            bVar.a(frameLayout);
            return;
        }
        FrameLayout frameLayout2 = this.mZplanCoverView;
        if (frameLayout2 == null) {
            QLog.e(TAG, 1, "ensureBubbleControllerCreated failed, mZplanCoverView null.");
            return;
        }
        int width = frameLayout2.getWidth();
        int height = this.mZplanCoverView.getHeight();
        if (this.mAvatarBubbleController == null && width != 0 && height != 0) {
            if (((IProfileCardApi) QRoute.api(IProfileCardApi.class)).isZplanUnderMaintenance()) {
                QLog.i(TAG, 1, "[showZplanBubble] ZPlanUnderMaintaince");
                return;
            }
            if (this.mCardInfo != null && this.mZplanCoverView != null) {
                if (!((IProfileCardApi) QRoute.api(IProfileCardApi.class)).isMyCard(this.mCardInfo) && this.mCardInfo.allInOne != null) {
                    str = ZootopiaSource.SUB_SOURCE_PROFILE_VISITOR;
                } else {
                    str = ZootopiaSource.SUB_SOURCE_PROFILE_OWNER;
                }
                this.mAvatarBubbleController = ((IZPlanAvatarBubbleControllerFactory) QRoute.api(IZPlanAvatarBubbleControllerFactory.class)).generateController(this.mZplanCoverView, width, height, str);
                if (be.k()) {
                    this.mAvatarBubbleController.b(new com.tencent.mobileqq.zplan.bubble.a() { // from class: com.tencent.mobileqq.profilecard.view.head.AbsZPlanProfileHeaderView.9
                        @Override // com.tencent.mobileqq.zplan.bubble.a
                        public void hiddeOnlineStatusBubble() {
                            QLog.i(AbsZPlanProfileHeaderView.TAG, 1, "hiddeOnlineStatusBubble");
                            AbsZPlanProfileHeaderView.this.hiddeMyDialog();
                        }

                        @Override // com.tencent.mobileqq.zplan.bubble.a
                        public void showOnlineStatusBubble() {
                            QLog.i(AbsZPlanProfileHeaderView.TAG, 1, "showOnlineStatusBubble");
                            AbsZPlanProfileHeaderView.this.showMyDialog();
                        }
                    });
                    return;
                }
                return;
            }
            QLog.i(TAG, 1, "[showZplanBubble] invalid view or cardInfo");
            return;
        }
        QLog.i(TAG, 1, "[showZplanBubble] mHasGetBubbleInfo or invalid param" + height + "   " + width);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Integer getAttachTopHeightLower() {
        ni3.a aVar = ni3.a.f420201a;
        return this.enableMiniHomeProfile ? aVar.i() : aVar.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Integer getAttachTopHeightUpper() {
        ni3.a aVar = ni3.a.f420201a;
        return this.enableMiniHomeProfile ? aVar.j() : aVar.b();
    }

    private long getFriendUin() {
        ProfileCardInfo profileCardInfo = this.mCardInfo;
        if (profileCardInfo != null && profileCardInfo.card != null) {
            if (MobileQQ.sMobileQQ.peekAppRuntime() == null) {
                QLog.e(TAG, 1, "getFriendUin failed, app null.");
                return -1L;
            }
            try {
                return Long.parseLong(this.mCardInfo.card.uin);
            } catch (Throwable unused) {
            }
        }
        return -1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Integer getInitHeight() {
        ni3.a aVar = ni3.a.f420201a;
        return this.enableMiniHomeProfile ? aVar.k() : aVar.e();
    }

    private int getMaxPullDownVisibilityHeight() {
        if (isPadLandscape(this.mActivity.getBaseContext())) {
            return ImmersiveUtils.getScreenWidth() / 2;
        }
        return ViewUtils.getScreenHeight() / 2;
    }

    private float getMiniHomeButtonHeightRate() {
        int i3 = getResources().getConfiguration().orientation;
        DeviceType a16 = PadUtil.a(getContext());
        boolean isInMagicWindow = isInMagicWindow(getContext());
        QLog.i(TAG, 1, "isInMagicWindow : " + isInMagicWindow + "; getDeviceType : " + a16 + "; orientation : " + i3);
        if (isInMagicWindow) {
            return 0.3f;
        }
        return (i3 == 2 && a16 == DeviceType.TABLET) ? 0.3f : 0.35f;
    }

    private com.tencent.mobileqq.zplan.minihome.ao getRoomDesc(String str) {
        return ((IMiniHomeHelper) QRoute.api(IMiniHomeHelper.class)).getSaveRoomDesc(str);
    }

    private void initAvatarLoadingOverlay() {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.profilecard.view.head.h
            @Override // java.lang.Runnable
            public final void run() {
                AbsZPlanProfileHeaderView.this.lambda$initAvatarLoadingOverlay$14();
            }
        });
    }

    private void initZPlanAvatarBannerManager() {
        setContentDescription(HardCodeUtil.qqStr(isFriendCard() ? R.string.x5t : R.string.x5u));
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.e(TAG, 1, "initZPlanAvatarBannerManager failed, app null.");
            return;
        }
        ProfileCardInfo profileCardInfo = this.mCardInfo;
        if (profileCardInfo != null && profileCardInfo.card != null) {
            if (this.mZplanAvatarBannerManager != null) {
                QLog.w(TAG, 2, "initZPlanAvatarBannerManager already init");
                return;
            }
            if (this.mZPlanBannerLayout == null) {
                QLog.e(TAG, 1, "initZPlanAvatarBannerManager failed, mZPlanBannerLayout null.");
                return;
            }
            QLog.i(TAG, 1, "initZPlanAvatarBannerManager");
            StrategyId a16 = com.tencent.mobileqq.zplan.meme.frameanim.h.INSTANCE.a();
            int i3 = peekAppRuntime.getCurrentUin().equals(this.mCardInfo.card.uin) ? 2 : 3;
            if (!((IProfileCardApi) QRoute.api(IProfileCardApi.class)).isMyCard(this.mCardInfo)) {
                QLog.i(TAG, 1, "friendCard static img, day: " + ZPlanProfileAvatarUtils.getZplanUrl(this.mCardInfo, false) + ", night: " + ZPlanProfileAvatarUtils.getZplanUrl(this.mCardInfo, true));
            }
            ZPlanAvatarBannerParams zPlanAvatarBannerParams = new ZPlanAvatarBannerParams(this.mCardInfo.card.uin, a16, 2, i3);
            IZPlanApi iZPlanApi = (IZPlanApi) QRoute.api(IZPlanApi.class);
            BaseApplication context = BaseApplication.getContext();
            AbsZPlanStaticFrameLayout absZPlanStaticFrameLayout = this.mZPlanBannerLayout;
            com.tencent.mobileqq.zplan.meme.frameanim.a createZPlanAvatarBannerManager = iZPlanApi.createZPlanAvatarBannerManager(context, absZPlanStaticFrameLayout, absZPlanStaticFrameLayout.getAvatarIv(), this.mZPlanBannerLayout.getBackgroundContainer(), zPlanAvatarBannerParams);
            this.mZplanAvatarBannerManager = createZPlanAvatarBannerManager;
            createZPlanAvatarBannerManager.r(new com.tencent.mobileqq.zplan.meme.frameanim.f() { // from class: com.tencent.mobileqq.profilecard.view.head.AbsZPlanProfileHeaderView.7
                @Override // com.tencent.mobileqq.zplan.meme.frameanim.f
                public void onManagerResume() {
                    if (((AbsProfileHeaderView) AbsZPlanProfileHeaderView.this).mCardInfo == null || AbsZPlanProfileHeaderView.this.mHasManagerResumed.getAndSet(true)) {
                        return;
                    }
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.profilecard.view.head.AbsZPlanProfileHeaderView.7.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AbsZPlanProfileHeaderView.this.showZplanBubble();
                        }
                    });
                }

                public void onDynamicAvatarManagerCreate() {
                }
            });
            ((IZPlanApi) QRoute.api(IZPlanApi.class)).preRequestMiniHomeFlag(getFriendUin());
            return;
        }
        QLog.e(TAG, 1, "initZPlanAvatarBannerManager failed, cardInfo null.");
    }

    private void initZPlanGuide() {
        if (((IProfileCardApi) QRoute.api(IProfileCardApi.class)).showProfileZplanUserGuide()) {
            this.mZplanUserGuideImageLayout = (RelativeLayout) this.mContentView.findViewById(R.id.f126967q7);
            this.mZplanUserGuideImage = (ImageView) this.mContentView.findViewById(R.id.f126957q6);
            this.mZplanUserGuideImageLayout.setVisibility(8);
        }
    }

    private void initZPlanMiniHomeController() {
        Activity activity;
        setContentDescription(HardCodeUtil.qqStr(isFriendCard() ? R.string.x5w : R.string.x5x));
        com.tencent.mobileqq.zplan.minihome.y yVar = this.mMiniHomeController;
        if (yVar != null) {
            yVar.h(MiniHomeSceneEnum.SCENE_PROFILE);
            QLog.i(TAG, 1, "initZPlanMiniHomeController mMiniHomeController is not null, return.");
            return;
        }
        ProfileCardInfo profileCardInfo = this.mCardInfo;
        if (profileCardInfo != null && profileCardInfo.card != null) {
            QLog.i(TAG, 1, "initZPlanMiniHomeController hasResume: " + this.hasResume);
            MiniHomeSceneEnum miniHomeSceneEnum = MiniHomeSceneEnum.SCENE_PROFILE;
            if (miniHomeSceneEnum.getSceneConfig().getUseTouchEvent() && (activity = this.mActivityWeakRef.get()) != null && !activity.isFinishing()) {
                ((FriendProfileCardActivity) activity).disableTopGestureLR();
            }
            this.mEngineStartTime = System.currentTimeMillis();
            com.tencent.mobileqq.zplan.minihome.y miniHomeController = ((IMiniHomeHelper) QRoute.api(IMiniHomeHelper.class)).getMiniHomeController(this.mCardInfo.card.uin, this.mCardInfo.card.uin + this, miniHomeSceneEnum);
            this.mMiniHomeController = miniHomeController;
            miniHomeController.r(this.mMiniHomeSceneEventCallbackRef);
            this.mMiniHomeController.create();
            this.mMiniHomeController.createView();
            this.mMiniHomeController.f();
            this.mMiniHomeController.h(miniHomeSceneEnum);
            return;
        }
        QLog.e(TAG, 1, "initZPlanMiniHomeController failed, cardInfo null.");
    }

    private boolean innerRequestMiniHomeInfo(String str) {
        if (!((IZPlanApi) QRoute.api(IZPlanApi.class)).miniHomeQQMCSwitchOn()) {
            QLog.e(TAG, 1, "requestMiniHomeInfo enableMiniHomeQQMC false.");
            return false;
        }
        if (!((IZPlanAccessibleHelper) QRoute.api(IZPlanAccessibleHelper.class)).enableZPlanNativeAppFilament(isFriendCard() ? 3 : 2)) {
            QLog.e(TAG, 1, "requestMiniHomeInfo enableFilament false.");
            return false;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.e(TAG, 1, "requestMiniHomeInfo failed, app null.");
            return false;
        }
        String currentUin = peekAppRuntime.getCurrentUin();
        if (str != null) {
            currentUin = str;
        }
        this.requestMiniHomeCallback = new RequestMiniHomeCallback(currentUin);
        ((IMiniHomeHelper) QRoute.api(IMiniHomeHelper.class)).requestMiniHomeInfoFromNet(str, new WeakReference<>(this.requestMiniHomeCallback));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isFriendCard() {
        ProfileCardInfo profileCardInfo = this.mCardInfo;
        if (profileCardInfo != null && profileCardInfo.card != null) {
            if (MobileQQ.sMobileQQ.peekAppRuntime() == null) {
                QLog.e(TAG, 1, "initZPlanAvatarBannerManager failed, app null.");
                return false;
            }
            return !r0.getCurrentUin().equals(this.mCardInfo.card.uin);
        }
        QLog.e(TAG, 1, "initZPlanAvatarBannerManager failed, cardInfo null.");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addMiniHomeEditImage$11(View view) {
        String str;
        this.needForceReload.set(true);
        com.tencent.mobileqq.zplan.minihome.ao roomDesc = getRoomDesc(this.mCardInfo.card.uin);
        if (roomDesc != null) {
            str = roomDesc.getRoomDescJson();
        } else {
            str = "";
        }
        this.recordMiniHomeFirstFrame = false;
        IMiniHomeHelper iMiniHomeHelper = (IMiniHomeHelper) QRoute.api(IMiniHomeHelper.class);
        Context context = getContext();
        String str2 = this.mCardInfo.card.uin;
        iMiniHomeHelper.startEditMiniHomeFragment(context, str2, this.mCardInfo.card.uin + this, str, EditMiniHomeSource.SELF_PROFILE_CARD);
        ProfileCardDtReportUtil.dtReportClick(this.mMiniHomeEditImage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addMiniHomeGiftImageIfNeed$12(View view) {
        ((IMiniHomeHelper) QRoute.api(IMiniHomeHelper.class)).askShowGiftRewardDialog(getContext(), this.mCardInfo.card.uin, new GiftReportInfo(GiftPopSource.FRIEND_PROFILE_CARD, null), this.mActivityWeakRef.get());
        ProfileCardDtReportUtil.dtReportClick(this.mMiniHomeGiftImage);
        removeMiniHomeGiftImage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addMiniHomeView$5(MotionEvent motionEvent, String str, View view) {
        String str2;
        try {
            if (MiniHomeViewActionConfig.INSTANCE.handleMotion(motionEvent)) {
                if ("MainAvatar".equals(new JSONObject(str).optString("slot", ""))) {
                    QLog.i(TAG, 1, "click avatar, jump to portal");
                    if (isFriendCard()) {
                        ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).jumpToZplanLoadingPage(getContext(), this.mCardInfo, IProfileCardApi.ZPlanJumpSource.CLICK);
                        return;
                    } else {
                        ((IZPlanApi) QRoute.api(IZPlanApi.class)).launchSchemeWithContext(view.getContext(), "mqqapi://zplan/enterAvatarScene?referer=1020&sceneType=1&pageData=%7B%22enterNum%22%3A0%7D&sceneData=%7B%22ViewType%22%3A1%7D&src_type=app&version=1.0");
                        return;
                    }
                }
                AbsZPlanStaticFrameLayout absZPlanStaticFrameLayout = this.mZPlanBannerLayout;
                if (absZPlanStaticFrameLayout != null) {
                    ProfileCardDtReportUtil.dtReportClick(absZPlanStaticFrameLayout);
                }
                final Activity activity = this.mActivityWeakRef.get();
                if (activity != null && !activity.isFinishing()) {
                    final AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                    if (peekAppRuntime == null) {
                        QLog.e(TAG, 1, "showGuidanceDialog failed, app null.");
                        return;
                    }
                    int hasCreatedMiniHome = ((IMiniHomeHelper) QRoute.api(IMiniHomeHelper.class)).getHasCreatedMiniHome();
                    QLog.i(TAG, 1, "click others, \u521b\u7a9d, " + hasCreatedMiniHome);
                    if (hasCreatedMiniHome == 0) {
                        if (isFriendCard()) {
                            ((IZPlanApi) QRoute.api(IZPlanApi.class)).launchSchemeWithContext(activity, ((IZPlanApi) QRoute.api(IZPlanApi.class)).generateXWConnectScheme("guest_profile", null, this.mCardInfo.card.uin, false, null));
                            return;
                        } else {
                            ((IMiniHomeHelper) QRoute.api(IMiniHomeHelper.class)).showGuidanceDialog(activity, null, GuidanceSource.SOURCE_FRIEND_PROFILE, new IMiniHomeHelper.c() { // from class: com.tencent.mobileqq.profilecard.view.head.p
                                @Override // com.tencent.mobileqq.zplan.minihome.api.IMiniHomeHelper.c
                                public final void onResult(boolean z16) {
                                    AbsZPlanProfileHeaderView.lambda$addMiniHomeView$4(AppRuntime.this, activity, z16);
                                }
                            });
                            return;
                        }
                    }
                    if (hasCreatedMiniHome == -1) {
                        requestMiniHomeInfo(null);
                    }
                    IZPlanApi iZPlanApi = (IZPlanApi) QRoute.api(IZPlanApi.class);
                    IZPlanApi iZPlanApi2 = (IZPlanApi) QRoute.api(IZPlanApi.class);
                    if (isFriendCard()) {
                        str2 = "guest_profile";
                    } else {
                        str2 = "owner_profile";
                    }
                    iZPlanApi.launchSchemeWithContext(activity, iZPlanApi2.generateXWConnectScheme(str2, null, this.mCardInfo.card.uin, false, null));
                }
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "selectDecorateRaycast callback error, " + th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addMiniHomeView$6(final MotionEvent motionEvent, final View view, final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        runOnUIThread(new Runnable() { // from class: com.tencent.mobileqq.profilecard.view.head.l
            @Override // java.lang.Runnable
            public final void run() {
                AbsZPlanProfileHeaderView.this.lambda$addMiniHomeView$5(motionEvent, str, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$addMiniHomeView$7(final View view, final MotionEvent motionEvent) {
        QLog.i(TAG, 1, "OnTouchListener " + motionEvent);
        if (!this.hasPixelCallback.get() || motionEvent.getAction() == 2) {
            return false;
        }
        this.mMiniHomeController.g((int) motionEvent.getX(), (int) (this.mZPlanMiniHomeView.getHeight() - motionEvent.getY()), new IMiniHomeMessageCallback() { // from class: com.tencent.mobileqq.profilecard.view.head.j
            @Override // com.tencent.filament.zplan.scene.minihome.IMiniHomeMessageCallback
            public final void onMiniHomeMessage(String str) {
                AbsZPlanProfileHeaderView.this.lambda$addMiniHomeView$6(motionEvent, view, str);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addMiniHomeView$8() {
        if (this.mZPlanBannerLayout != null && this.mMiniHomeController != null) {
            QLog.i(TAG, 1, "addMiniHomeView");
            removeMiniHomeView();
            this.mZPlanMiniHomeView = this.mMiniHomeController.getView();
            this.mZPlanBannerLayout.addView(this.mZPlanMiniHomeView, new FrameLayout.LayoutParams(-1, (int) (getContext().getResources().getDisplayMetrics().heightPixels * 0.5f)));
            this.mZPlanMiniHomeView.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.profilecard.view.head.s
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    boolean lambda$addMiniHomeView$7;
                    lambda$addMiniHomeView$7 = AbsZPlanProfileHeaderView.this.lambda$addMiniHomeView$7(view, motionEvent);
                    return lambda$addMiniHomeView$7;
                }
            });
            addXiaoWoImage();
            return;
        }
        QLog.e(TAG, 1, "addMiniHomeView error, mZPlanBannerLayout: " + this.mZPlanBannerLayout + "; mMiniHomeController: " + this.mMiniHomeController);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addXiaoWoImage$10(View view) {
        String str;
        if (isFriendCard()) {
            str = "guest_profile_icon";
        } else {
            str = "owner_profile_icon";
        }
        ((IZPlanApi) QRoute.api(IZPlanApi.class)).launchSchemeWithContext(view.getContext(), ((IZPlanApi) QRoute.api(IZPlanApi.class)).generateXWConnectScheme(str, null, this.mCardInfo.card.uin, false, null));
        ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).reportDtZplanEntranceClick(this.mCardInfo, IProfileCardApi.ZPlanJumpSource.CLICK, IProfileCardApi.ZPlanJumpMode.SMALL_HOME, "xiaowo", 1);
        ProfileCardDtReportUtil.dtReportClick(this.mXiaowoImage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$doOnPixelCallback$17() {
        com.tencent.mobileqq.zplan.minihome.y yVar = this.mMiniHomeController;
        if (yVar != null) {
            yVar.p();
            this.mHideStaticImageTime = System.currentTimeMillis();
            addMiniHomeEditImage();
            addMiniHomeGiftImageIfNeed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initAvatarLoadingOverlay$14() {
        com.tencent.mobileqq.zplan.meme.frameanim.a aVar = this.mZplanAvatarBannerManager;
        if (aVar != null && this.mZPlanBannerLayout != null) {
            if (!aVar.e()) {
                QLog.e(TAG, 1, "no dynamic avatar, initAvatarLoadingOverlay return");
                return;
            }
            if (!((IZPlanFeatureSwitchHelper) QRoute.api(IZPlanFeatureSwitchHelper.class)).enableQzoneRecordLoadingAnim()) {
                QLog.w(TAG, 1, "record loading overlay is disable by FeatureSwitch.");
                return;
            }
            if (this.mAvatarOverlayViewWiringHelper != null) {
                QLog.w(TAG, 2, "already init overlay helper.");
                return;
            }
            QLog.i(TAG, 1, "initAvatarLoadingOverlay");
            ensureBubbleControllerCreated(this.mZPlanBannerLayout);
            this.mAvatarOverlayViewWiringHelper = ((IZPlanApi) QRoute.api(IZPlanApi.class)).createAvatarLoadingViewHelper(LayoutInflater.from(getContext()), this.mActivity, ((IZPlanClassObjectFactory) QRoute.api(IZPlanClassObjectFactory.class)).getZPlanProfileAvatarOverlayViewModelClass());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            this.mAvatarOverlayViewWiringHelper.e(this.mAvatarBubbleController);
            this.mZPlanBannerLayout.addView(this.mAvatarOverlayViewWiringHelper.f(), layoutParams);
            this.mZplanAvatarBannerManager.q(this.mAvatarOverlayViewWiringHelper);
            this.mAvatarOverlayViewWiringHelper.c().observe(this.mActivity, this.mLoadingOverlayObserver);
            return;
        }
        QLog.e(TAG, 1, "initAvatarLoadingOverlay failed, banner manager or layout null.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(com.tencent.mobileqq.zplan.minihome.am amVar, MiniHomeSceneEnum miniHomeSceneEnum) {
        if (miniHomeSceneEnum != MiniHomeSceneEnum.SCENE_PROFILE) {
            return;
        }
        int i3 = AnonymousClass12.$SwitchMap$com$tencent$mobileqq$zplan$minihome$EventType[amVar.getType().ordinal()];
        if (i3 == 1) {
            long currentTimeMillis = System.currentTimeMillis();
            QLog.i(TAG, 1, "firstFrameDuration: " + (currentTimeMillis - this.mMiniHomeInitStartTime) + "; startTime " + this.mMiniHomeInitStartTime + ", endTime: " + currentTimeMillis);
            doOnFirstFrameImgReady((EventFirstFrameImageReady) amVar);
            return;
        }
        if (i3 != 2) {
            if (i3 == 3) {
                QLog.i(TAG, 1, "EVENT_TIME_STAT_CALLBACK");
                this.mTimeStatCallbacked.compareAndSet(false, true);
                doOnTimeStatCallback(amVar);
                return;
            } else {
                if (i3 != 4) {
                    return;
                }
                QLog.i(TAG, 1, "EVENT_ERROR_CALLBACK");
                doOnErrorCallback(amVar);
                return;
            }
        }
        this.mFirstFramed.compareAndSet(false, true);
        this.mFirstFrameTime = System.currentTimeMillis();
        long currentTimeMillis2 = System.currentTimeMillis();
        this.mPixelCallbackDuration = currentTimeMillis2 - this.mMiniHomeInitStartTime;
        QLog.i(TAG, 1, "pixelCallbackDuration: " + this.mPixelCallbackDuration + "; startTime " + this.mMiniHomeInitStartTime + ", endTime: " + currentTimeMillis2);
        doOnPixelCallback(amVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onDestroy$1() {
        this.mMiniHomeController.destroy();
        this.mMiniHomeController = null;
        ((IMiniHomeHelper) QRoute.api(IMiniHomeHelper.class)).releaseMiniHomeController();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$removeMiniHomeView$9() {
        if (this.mZPlanBannerLayout != null && this.mMiniHomeController != null) {
            if (this.mZPlanMiniHomeView == null) {
                return;
            }
            QLog.i(TAG, 1, "removeMiniHomeView");
            this.mZPlanBannerLayout.removeView(this.mZPlanMiniHomeView);
            this.mZPlanMiniHomeView = null;
            removeXiaoWoImage();
            removeMiniHomeEditImage();
            removeMiniHomeGiftImage();
            return;
        }
        QLog.e(TAG, 1, "removeMiniHomeView, mZPlanBannerLayout: " + this.mZPlanBannerLayout + "; mMiniHomeController: " + this.mMiniHomeController);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$removeZPlanBannerLayout$2() {
        if (this.mZplanCoverView == null || this.mZPlanBannerLayout == null) {
            return;
        }
        QLog.i(TAG, 1, "onDestroy, remove ZPlanBannerLayout view");
        this.mZplanCoverView.removeView(this.mZPlanBannerLayout);
        this.mZPlanBannerLayout = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$saveFirstFrameFileAsync$16(String str, String str2) {
        String absolutePath = new File(new File(str).getParentFile(), this.loadingRoomDesc.getHash() + ".png").getAbsolutePath();
        boolean j3 = com.tencent.zplan.common.utils.c.f385288a.j(str, absolutePath);
        QLog.i(TAG, 1, "saveFirstFrameFileAsync, rename from: " + str + " to: " + absolutePath + " success: " + j3);
        com.tencent.mobileqq.zplan.minihome.ao roomDesc = getRoomDesc(this.mCardInfo.card.uin);
        if (roomDesc == null) {
            QLog.w(TAG, 1, "saveFirstFrameFileAsync currentUinRoomDesc null, return.");
            return;
        }
        IMiniHomeHelper iMiniHomeHelper = (IMiniHomeHelper) QRoute.api(IMiniHomeHelper.class);
        MiniHomeSceneEnum miniHomeSceneEnum = MiniHomeSceneEnum.SCENE_PROFILE;
        if (j3) {
            str = absolutePath;
        }
        iMiniHomeHelper.setStaticImagePath(str2, miniHomeSceneEnum, str, roomDesc.getHash());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showZplanUserGuide$15() {
        LottieHelper.b(this.mActivity, ZPLAN_USER_GUIDE_JSON, null, 20, 20, -1, new LottieHelper.d() { // from class: com.tencent.mobileqq.profilecard.view.head.AbsZPlanProfileHeaderView.11
            @Override // com.tencent.mobileqq.onlinestatus.utils.LottieHelper.d
            public void onLoad(LottieDrawable lottieDrawable) {
                AbsZPlanProfileHeaderView absZPlanProfileHeaderView = AbsZPlanProfileHeaderView.this;
                if (absZPlanProfileHeaderView.mZplanUserGuideImageLayout == null || absZPlanProfileHeaderView.mZplanUserGuideImage == null) {
                    return;
                }
                absZPlanProfileHeaderView.mZplanLottieDrawable = lottieDrawable;
                lottieDrawable.playAnimation();
                AbsZPlanProfileHeaderView.this.mZplanUserGuideImage.setImageDrawable(lottieDrawable);
                AbsZPlanProfileHeaderView.this.mZplanUserGuideImageLayout.setVisibility(0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$tryRequestBackgroundUrl$13() {
        Card card;
        if (MobileQQ.sMobileQQ.peekAppRuntime() == null) {
            QLog.e(TAG, 1, "tryRequestBackgroundUrl failed, appRuntime null.");
            return;
        }
        ProfileCardInfo profileCardInfo = this.mCardInfo;
        if (profileCardInfo != null && (card = profileCardInfo.card) != null) {
            try {
                ((IZPlanRequest) QRoute.api(IZPlanRequest.class)).requestAddDCBackImage(Long.parseLong(card.uin), 5, null, new nk3.i() { // from class: com.tencent.mobileqq.profilecard.view.head.AbsZPlanProfileHeaderView.6
                    @Override // nk3.i
                    public void onResultForSelectImage(com.tencent.mobileqq.zplan.model.g gVar) {
                        QLog.i(AbsZPlanProfileHeaderView.TAG, 1, "tryRequestBackground success, dayUrl=" + gVar.i() + ", darkUrl=" + gVar.b());
                        if (AbsZPlanProfileHeaderView.this.mZplanAvatarBannerManager != null) {
                            AbsZPlanProfileHeaderView.this.mZplanAvatarBannerManager.t();
                        }
                    }

                    @Override // nk3.i
                    public void onResultFailed() {
                        QLog.e(AbsZPlanProfileHeaderView.TAG, 1, "tryRequestBackground failed");
                    }
                });
                return;
            } catch (NumberFormatException e16) {
                QLog.e(TAG, 1, "tryRequestBackgroundUrl failed.", e16);
                return;
            }
        }
        QLog.e(TAG, 1, "tryRequestBackgroundUrl failed, mCardInfo null.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateAvatarAndRoom$3(MiniHomeLoadSource miniHomeLoadSource) {
        PullToZoomHeaderListView pullToZoomHeaderListView;
        this.disableAddView.set(false);
        if (this.mProfileZPlanControlManager == null) {
            this.mProfileZPlanControlManager = new ProfileZPlanScrollController();
        }
        this.enableMiniHomeProfile = enableMiniHomeProfile();
        QLog.i(TAG, 2, "updateAvatarAndRoom enableMiniHomeProfile:" + this.enableMiniHomeProfile);
        if (this.lastEnableMiniHome != this.enableMiniHomeProfile) {
            QLog.i(TAG, 1, "updateAvatarAndRoom " + miniHomeLoadSource + " enable change");
            this.needForceReload.set(true);
            if (!"guide_dialog".equals(this.mMiniHomeEntranceFrom)) {
                this.mMiniHomeEntranceFrom = "switch_on";
            }
            PullToZoomHeaderListView pullToZoomHeaderListView2 = this.mListView;
            if (pullToZoomHeaderListView2 != null) {
                pullToZoomHeaderListView2.smoothScrollToPosition(0);
            }
            ProfileZPlanScrollController profileZPlanScrollController = this.mProfileZPlanControlManager;
            if (profileZPlanScrollController != null) {
                profileZPlanScrollController.smoothScrollToInitHeight();
            }
        }
        boolean z16 = this.enableMiniHomeProfile;
        this.lastEnableMiniHome = z16;
        if (z16) {
            MiniHomeSceneEnum miniHomeSceneEnum = MiniHomeSceneEnum.SCENE_PROFILE;
            if (miniHomeSceneEnum.getSceneConfig().getUseTouchEvent() && (pullToZoomHeaderListView = this.mListView) != null) {
                pullToZoomHeaderListView.setHandleEventEnableX(true);
            }
            ProfileZPlanScrollController profileZPlanScrollController2 = this.mProfileZPlanControlManager;
            if (profileZPlanScrollController2 != null) {
                profileZPlanScrollController2.releaseZPlanAvatarBannerManager();
                this.mProfileZPlanControlManager.onResume();
            }
            initZPlanMiniHomeController();
            com.tencent.mobileqq.zplan.minihome.y yVar = this.mMiniHomeController;
            if (yVar != null) {
                yVar.h(miniHomeSceneEnum);
                loadRoomAndAvatar(miniHomeLoadSource);
                return;
            }
            return;
        }
        PullToZoomHeaderListView pullToZoomHeaderListView3 = this.mListView;
        if (pullToZoomHeaderListView3 != null) {
            pullToZoomHeaderListView3.setHandleEventEnableX(false);
        }
        if (this.mMiniHomeController != null) {
            removeMiniHomeView();
            this.mMiniHomeController.q();
            this.mMiniHomeController.destroy();
            this.mMiniHomeController = null;
            ((IMiniHomeHelper) QRoute.api(IMiniHomeHelper.class)).releaseMiniHomeController();
        }
        this.mMiniHomeReporter = null;
        initAvatarLoadingOverlay();
        initZPlanAvatarBannerManager();
        ProfileZPlanScrollController profileZPlanScrollController3 = this.mProfileZPlanControlManager;
        if (profileZPlanScrollController3 != null) {
            profileZPlanScrollController3.initZPlanBannerListener();
            this.mProfileZPlanControlManager.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadRoomAndAvatar(MiniHomeLoadSource miniHomeLoadSource) {
        String str;
        com.tencent.mobileqq.zplan.minihome.ao aoVar;
        QLog.i(TAG, 2, "before loadRoomAndAvatar loadSource: " + miniHomeLoadSource.name());
        if (this.hasResume) {
            this.mMiniHomeController.resume();
            QLog.i(TAG, 1, "mMiniHomeController resume loadRoomAndAvatar 2");
        }
        com.tencent.mobileqq.zplan.minihome.ao roomDesc = getRoomDesc(this.mCardInfo.card.uin);
        if (roomDesc == null) {
            QLog.w(TAG, 1, "loadRoomAndAvatar currentUinRoomDesc null, return.");
            return;
        }
        QLog.i(TAG, 2, "loadRoomAndAvatar currentUinRoomDesc: " + roomDesc);
        boolean z16 = needReaddMiniHomeView(this.mZPlanBannerLayout, this.mZPlanMiniHomeView) && this.hasResume;
        boolean z17 = this.needForceReload.get() && (this.hasResume || miniHomeLoadSource == MiniHomeLoadSource.APPERANCE_CHANGE);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("loadRoomAndAvatar needReAddView: ");
        sb5.append(z16);
        sb5.append("; needForceReloadResource: ");
        sb5.append(z17);
        sb5.append("; loadingRoomDesc hash: ");
        com.tencent.mobileqq.zplan.minihome.ao aoVar2 = this.loadingRoomDesc;
        if (aoVar2 != null) {
            str = aoVar2.getHash();
        } else {
            str = "";
        }
        sb5.append(str);
        sb5.append("; currentUinRoomDesc hash: ");
        sb5.append(roomDesc.getHash());
        QLog.i(TAG, 2, sb5.toString());
        if (!z16 && !z17 && (aoVar = this.loadingRoomDesc) != null && aoVar.getHash().equals(roomDesc.getHash())) {
            QLog.e(TAG, 1, "loadRoomAndAvatar same room, return.");
            return;
        }
        QLog.i(TAG, 2, "loadRoomAndAvatar " + Log.getStackTraceString(new Throwable()));
        createMiniHomeReporter(miniHomeLoadSource);
        this.mLoadStartTime = System.currentTimeMillis();
        this.hasPixelCallback.set(false);
        this.mIsResetRoomAndAvatar = true;
        this.mMiniHomeController.o(MiniHomeScene.Companion.CAMERAMODE.NORMAL);
        addMiniHomeView();
        boolean isNowThemeIsNight = QQTheme.isNowThemeIsNight();
        this.mMiniHomeController.e(isNowThemeIsNight);
        if (miniHomeLoadSource != MiniHomeLoadSource.APPERANCE_CHANGE) {
            this.mMiniHomeController.w(roomDesc.a(isNowThemeIsNight, ((IMiniHomeHelper) QRoute.api(IMiniHomeHelper.class)).getStaticImagePath(this.mCardInfo.card.uin, MiniHomeSceneEnum.SCENE_PROFILE, roomDesc.getHash())), isNowThemeIsNight);
        }
        this.mMiniHomeController.h(MiniHomeSceneEnum.SCENE_PROFILE);
        this.mMiniHomeInitStartTime = System.currentTimeMillis();
        QLog.i(TAG, 4, "loadRoomAndAvatar, mMiniHomeInitStartTime: " + this.mMiniHomeInitStartTime);
        this.mMiniHomeController.l();
        this.mMiniHomeRoomLoadStartTime = System.currentTimeMillis();
        QLog.i(TAG, 4, "loadRoomAndAvatar, mMiniHomeRoomLoadStartTime: " + this.mMiniHomeRoomLoadStartTime);
        this.mMiniHomeController.c(roomDesc.getRoomDescJson(), this.loadRoomCallback);
        this.loadingRoomDesc = roomDesc;
        this.mMiniHomeAvatarLoadStartTime = System.currentTimeMillis();
        QLog.i(TAG, 4, "loadRoomAndAvatar, mMiniHomeAvatarLoadStartTime: " + this.mMiniHomeAvatarLoadStartTime);
        this.mMiniHomeController.a(this.loadAvatarCallback);
        this.needForceReload.set(false);
    }

    private void removeMiniHomeEditImage() {
        AbsZPlanStaticFrameLayout absZPlanStaticFrameLayout = this.mZPlanBannerLayout;
        if (absZPlanStaticFrameLayout != null && this.mMiniHomeController != null) {
            ImageView imageView = this.mMiniHomeEditImage;
            if (imageView != null) {
                absZPlanStaticFrameLayout.removeView(imageView);
            }
            this.mMiniHomeEditImage = null;
            return;
        }
        QLog.e(TAG, 1, "removeMiniHomeEditImage, mZPlanBannerLayout: " + this.mZPlanBannerLayout + "; mMiniHomeController: " + this.mMiniHomeController);
    }

    private void removeMiniHomeGiftImage() {
        AbsZPlanStaticFrameLayout absZPlanStaticFrameLayout = this.mZPlanBannerLayout;
        if (absZPlanStaticFrameLayout != null && this.mMiniHomeController != null) {
            ImageView imageView = this.mMiniHomeGiftImage;
            if (imageView != null) {
                absZPlanStaticFrameLayout.removeView(imageView);
            }
            this.mMiniHomeGiftImage = null;
            return;
        }
        QLog.e(TAG, 1, "removeMiniHomeGiftImage, mZPlanBannerLayout: " + this.mZPlanBannerLayout + "; mMiniHomeController: " + this.mMiniHomeController);
    }

    private void removeMiniHomeView() {
        runOnUIThread(new Runnable() { // from class: com.tencent.mobileqq.profilecard.view.head.w
            @Override // java.lang.Runnable
            public final void run() {
                AbsZPlanProfileHeaderView.this.lambda$removeMiniHomeView$9();
            }
        });
    }

    private void removeXiaoWoImage() {
        AbsZPlanStaticFrameLayout absZPlanStaticFrameLayout = this.mZPlanBannerLayout;
        if (absZPlanStaticFrameLayout != null && this.mMiniHomeController != null) {
            ImageView imageView = this.mXiaowoImage;
            if (imageView != null) {
                absZPlanStaticFrameLayout.removeView(imageView);
            }
            this.mXiaowoImage = null;
            return;
        }
        QLog.e(TAG, 1, "removeMiniHomeView, mZPlanBannerLayout: " + this.mZPlanBannerLayout + "; mMiniHomeController: " + this.mMiniHomeController);
    }

    private void removeZPlanBannerLayout() {
        runOnUIThread(new Runnable() { // from class: com.tencent.mobileqq.profilecard.view.head.t
            @Override // java.lang.Runnable
            public final void run() {
                AbsZPlanProfileHeaderView.this.lambda$removeZPlanBannerLayout$2();
            }
        });
    }

    private void removeZPlanObserver() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            QLog.i(TAG, 4, "removeZPlanObserver");
            ((QQAppInterface) peekAppRuntime).removeObserver(this.mZPlanRequestObserver);
        }
    }

    private void reportMiniHomeExit(String str) {
        String str2;
        long currentTimeMillis = this.mMiniHomeInitStartTime == 0 ? -1L : System.currentTimeMillis() - this.mMiniHomeInitStartTime;
        com.tencent.mobileqq.zplan.minihome.aa aaVar = this.mMiniHomeReporter;
        if (aaVar != null) {
            String str3 = this.mMiniHomeEntranceFrom;
            if (this.mIsResetRoomAndAvatar) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            aaVar.c("zplanMiniHomeExit", str3, str, str2, Long.toString(this.mPixelCallbackDuration), Long.toString(this.mRoomLoadDuration), Long.toString(this.mAvatarLoadDuration), Long.toString(currentTimeMillis));
        }
    }

    private void requestMiniHomeInfo(String str) {
        if (innerRequestMiniHomeInfo(str)) {
            return;
        }
        VasIpcTempData.INSTANCE.getTempVar().setLong("key_profile_half_screen", 1L);
    }

    private void saveFirstFrameFileAsync(final String str, final String str2) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.profilecard.view.head.i
            @Override // java.lang.Runnable
            public final void run() {
                AbsZPlanProfileHeaderView.this.lambda$saveFirstFrameFileAsync$16(str, str2);
            }
        }, 64, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setZPlanCornerBgVisible(int i3) {
        ImageView imageView;
        if (this.mZplanCoverView == null || (imageView = this.mZPlanCornerBg) == null || i3 == imageView.getVisibility()) {
            return;
        }
        this.mZPlanCornerBg.setVisibility(i3);
    }

    private void showRewardGiftBubbleIfNeed(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.profilecard.view.head.AbsZPlanProfileHeaderView.5
            @Override // java.lang.Runnable
            public void run() {
                if (Boolean.valueOf(((IZPlanApi) QRoute.api(IZPlanApi.class)).getMiniHomeRewardGiftBubbleMMKV()).booleanValue()) {
                    return;
                }
                ((IZPlanApi) QRoute.api(IZPlanApi.class)).setMiniHomeRewardGiftBubbleMMKV();
                ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.profilecard.view.head.AbsZPlanProfileHeaderView.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        String str2 = str;
                        if (TextUtils.isEmpty(str2)) {
                            return;
                        }
                        QUIDefaultBubbleTip.r(AbsZPlanProfileHeaderView.this.getContext()).S(AbsZPlanProfileHeaderView.this.mMiniHomeGiftImage).o0(str2.replace(RedTouch.NEWLINE_CHAR, "\n")).k0(0).R(0).m0(3).g0(false).i0(0.0f, ViewUtils.dip2px(3.0f)).s0();
                    }
                }, 1000L);
            }
        }, 16, null, true);
    }

    private void showZplanUserGuide() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.profilecard.view.head.n
            @Override // java.lang.Runnable
            public final void run() {
                AbsZPlanProfileHeaderView.this.lambda$showZplanUserGuide$15();
            }
        }, 64, null, true);
    }

    private void tryRequestBackgroundUrl() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.profilecard.view.head.g
            @Override // java.lang.Runnable
            public final void run() {
                AbsZPlanProfileHeaderView.this.lambda$tryRequestBackgroundUrl$13();
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAvatarAndRoom(final MiniHomeLoadSource miniHomeLoadSource) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.profilecard.view.head.q
            @Override // java.lang.Runnable
            public final void run() {
                AbsZPlanProfileHeaderView.this.lambda$updateAvatarAndRoom$3(miniHomeLoadSource);
            }
        });
    }

    public void adjustTitle() {
        int i3;
        if (this.mZPlanChangeTitleStatusListener == null) {
            IProfileActivityDelegate iProfileActivityDelegate = this.mDelegate;
            this.mZPlanChangeTitleStatusListener = iProfileActivityDelegate != null ? iProfileActivityDelegate.getZPlanChangeTitleStatusListener() : null;
        }
        IZPlanChangeTitleStatusListener iZPlanChangeTitleStatusListener = this.mZPlanChangeTitleStatusListener;
        if (iZPlanChangeTitleStatusListener == null || (i3 = this.mState) == 10 || i3 == 11) {
            return;
        }
        iZPlanChangeTitleStatusListener.onSetTitleStatus(i3 == -1);
    }

    protected void checkZPlanUserGuideStatus() {
        if (this.mIsShowZplanCover && ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).showProfileZplanUserGuide()) {
            showZplanUserGuide();
            return;
        }
        RelativeLayout relativeLayout = this.mZplanUserGuideImageLayout;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
    }

    public void dismissUserGuide() {
        LottieDrawable lottieDrawable = this.mZplanLottieDrawable;
        if (lottieDrawable == null || this.mZplanUserGuideImageLayout == null) {
            return;
        }
        lottieDrawable.cancelAnimation();
        this.mZplanLottieDrawable.clearComposition();
        this.mZplanLottieDrawable = null;
        this.mZplanUserGuideImageLayout.setVisibility(8);
        ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).updateProfileZplanUserGuideStatus();
    }

    protected int getVisibleHeight() {
        FrameLayout frameLayout = this.mZplanCoverView;
        if (frameLayout == null) {
            return 0;
        }
        return frameLayout.getLayoutParams().height;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.profilecard.base.view.ProfileBaseView
    public void initCover(ProfileCardInfo profileCardInfo, int i3) {
        super.initCover(profileCardInfo, i3);
        QLog.i(TAG, 1, "initCover");
        if (profileCardInfo != null && profileCardInfo.card != null && !isFriendCard()) {
            requestMiniHomeInfo(profileCardInfo.card.uin);
        }
        updateZPlanObserver(this.mIsShowZplanCover);
        if (this.mIsShowZplanCover) {
            initZplanCover();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initZplanCover() {
        if (this.mZplanCoverView != null) {
            return;
        }
        QLog.i(TAG, 1, "initZplanCover");
        FrameLayout frameLayout = (FrameLayout) this.mContentView.findViewById(R.id.f165810xn3);
        this.mZplanCoverView = frameLayout;
        frameLayout.setVisibility(8);
        addZPlanBannerLayout();
        requestDataOnInit();
        showZPlanStaticView();
        initZPlanGuide();
        ImageView imageView = (ImageView) this.mContentView.findViewById(R.id.f165809xn2);
        this.mZPlanCornerBg = imageView;
        imageView.setVisibility(8);
        AbsZPlanStaticFrameLayout absZPlanStaticFrameLayout = this.mZPlanBannerLayout;
        if (absZPlanStaticFrameLayout != null) {
            ProfileCardDtReportUtil.initElementWithExposureClick(absZPlanStaticFrameLayout, "em_zplan_xiaowo_background");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (!this.mIsShowZplanCover) {
            QLog.i(TAG, 1, "onConfigurationChanged: mIsShowZplanCover false return");
            return;
        }
        QLog.i(TAG, 1, "onConfigurationChanged, newConfig: " + configuration);
        com.tencent.mobileqq.zplan.meme.frameanim.a aVar = this.mZplanAvatarBannerManager;
        if (aVar != null) {
            aVar.i(configuration);
        }
        if (this.mMiniHomeController != null) {
            removeMiniHomeView();
            addMiniHomeView();
            if (!isFriendCard()) {
                addMiniHomeEditImage();
            }
        }
        resetZPlanState();
        resetMaxVisibilityHeight();
    }

    @Override // com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView
    public void onDestroy() {
        super.onDestroy();
        QLog.i(TAG, 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        this.mPageEndTime = System.currentTimeMillis();
        this.hasDestroy = true;
        this.hasResume = false;
        this.hasPixelCallback.set(false);
        ProfileZPlanScrollController profileZPlanScrollController = this.mProfileZPlanControlManager;
        if (profileZPlanScrollController != null) {
            profileZPlanScrollController.onDestroy();
        }
        if (this.mMiniHomeController != null) {
            removeMiniHomeView();
            reportMiniHomeExit("exit_profile_card");
            this.mMiniHomeReporter = null;
            this.mIsResetRoomAndAvatar = false;
            this.mMiniHomeController.t(this.mMiniHomeSceneEventCallbackRef);
            runOnUIThread(new Runnable() { // from class: com.tencent.mobileqq.profilecard.view.head.r
                @Override // java.lang.Runnable
                public final void run() {
                    AbsZPlanProfileHeaderView.this.lambda$onDestroy$1();
                }
            });
            com.tencent.mobileqq.zplan.minihome.ab abVar = this.mMiniHomeReporterV2;
            if (abVar != null) {
                abVar.d(this.mRoomLoaded.get(), this.mAvatarLoaded.get(), this.mFirstFramed.get(), this.mTimeStatCallbacked.get(), this.mHasPausedBeforeFirstFrame, this.mPageEndTime - this.mPageStartTime);
            }
        }
        removeZPlanObserver();
        releaseAvatarOverlay();
        removeZPlanBannerLayout();
        this.mDelegate = null;
    }

    @Override // com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView
    public void onPause() {
        super.onPause();
        QLog.i(TAG, 1, MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
        this.hasResume = false;
        if (!this.mFirstFramed.get()) {
            this.mHasPausedBeforeFirstFrame = true;
        }
        if (!this.mIsShowZplanCover) {
            QLog.i(TAG, 1, "onPause: mIsShowZplanCover false return");
            return;
        }
        ProfileZPlanScrollController profileZPlanScrollController = this.mProfileZPlanControlManager;
        if (profileZPlanScrollController != null) {
            profileZPlanScrollController.onPause();
        }
        com.tencent.mobileqq.zplan.minihome.y yVar = this.mMiniHomeController;
        if (yVar != null) {
            yVar.pause();
        }
        this.mHasManagerResumed.getAndSet(false);
    }

    @Override // com.tencent.mobileqq.profilecard.base.view.ProfileBaseView, com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView
    public void onResume() {
        super.onResume();
        QLog.i(TAG, 1, "onResume");
        this.hasResume = true;
        if (!this.mIsShowZplanCover) {
            QLog.i(TAG, 1, "onResume: mIsShowZplanCover false return");
            return;
        }
        ProfileCardInfo profileCardInfo = this.mCardInfo;
        if (profileCardInfo == null || profileCardInfo.card == null) {
            return;
        }
        updateAvatarAndRoom(MiniHomeLoadSource.RESUME);
    }

    @Override // com.tencent.mobileqq.profilecard.base.view.ProfileBaseView, com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView
    public void onUpdate(ProfileCardInfo profileCardInfo, boolean z16) {
        super.onUpdate(profileCardInfo, z16);
        QLog.i(TAG, 1, "onUpdate");
        IProfileActivityDelegate iProfileActivityDelegate = this.mDelegate;
        if (iProfileActivityDelegate != null) {
            boolean isShowZplanCover = iProfileActivityDelegate.getIsShowZplanCover();
            this.mIsShowZplanCover = isShowZplanCover;
            updateZPlanObserver(isShowZplanCover);
            if (this.mIsShowZplanCover) {
                if (this.mProfileZPlanControlManager == null) {
                    this.mProfileZPlanControlManager = new ProfileZPlanScrollController();
                }
            } else {
                setZPlanCornerBgVisible(8);
            }
            PullToZoomHeaderListView pullToZoomHeaderListView = this.mListView;
            if (pullToZoomHeaderListView != null) {
                pullToZoomHeaderListView.setHandleEvent(this.mIsShowZplanCover ? this.mProfileZPlanControlManager : null);
            }
        }
    }

    public void resetMaxVisibilityHeight() {
        int maxPullDownVisibilityHeight = getMaxPullDownVisibilityHeight();
        QLog.i(TAG, 1, "resetMaxVisibilityHeight:" + maxPullDownVisibilityHeight);
        this.mMaxPullDownHeight = maxPullDownVisibilityHeight;
    }

    public void resetZPlanState() {
        if (this.mProfileZPlanControlManager == null) {
            this.mProfileZPlanControlManager = new ProfileZPlanScrollController();
        }
        this.mProfileZPlanControlManager.onReset();
    }

    protected void setVisibleHeight(int i3) {
        FrameLayout frameLayout = this.mZplanCoverView;
        if (frameLayout == null) {
            return;
        }
        if (i3 < 0) {
            i3 = 0;
        }
        int i16 = this.mMaxPullDownHeight;
        if (i3 > i16) {
            i3 = i16;
        }
        ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
        layoutParams.height = i3;
        this.mZplanCoverView.setLayoutParams(layoutParams);
        ProfileZPlanScrollController profileZPlanScrollController = this.mProfileZPlanControlManager;
        if (profileZPlanScrollController != null) {
            profileZPlanScrollController.callBackRefreshMoveListener(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.profilecard.base.view.ProfileBaseView
    public void updateCover(ProfileCardInfo profileCardInfo) {
        super.updateCover(profileCardInfo);
        QLog.i(TAG, 1, "updateCover");
        int c16 = this.mCoverView.c();
        if (this.mIsShowZplanCover) {
            if (this.mZplanCoverView == null) {
                initZplanCover();
            }
            updateAvatarAndRoom(MiniHomeLoadSource.UPDATE_COVER);
            c16 = 2;
        }
        if (this.mCoverView.c() != c16 || this.mCurrentNightMode != QQTheme.isNowThemeIsNight()) {
            this.mCoverView.a(c16);
            onCoverModeChange(c16, profileCardInfo);
        }
        checkZPlanUserGuideStatus();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void updateQidViewMargin(ProfileCardInfo profileCardInfo) {
        QidCoolTextView qidCoolTextView = this.mQidInfoView;
        if (qidCoolTextView != null) {
            int baseCardBottomMargin = qidCoolTextView.baseCardBottomMargin(profileCardInfo);
            int zplanCardTopMargin = zplanCardTopMargin(profileCardInfo);
            if (baseCardBottomMargin != 0) {
                this.mQidInfoView.adapterQidMargin(zplanCardTopMargin, baseCardBottomMargin);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void updateZplanCoverMode() {
        this.mCoverView.setVisibility(8);
        Integer initHeight = getInitHeight();
        if (initHeight != null && this.mState == 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mZplanCoverView.getLayoutParams();
            layoutParams.height = initHeight.intValue();
            this.mZplanCoverView.setLayoutParams(layoutParams);
        }
        this.mZplanCoverView.setVisibility(0);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mContentBgView.getLayoutParams();
        layoutParams2.addRule(3, R.id.f165810xn3);
        layoutParams2.addRule(10, 0);
        layoutParams2.topMargin = 0;
        this.mContentBgView.setLayoutParams(layoutParams2);
        HashMap hashMap = new HashMap();
        hashMap.put(ProfileCardDtReportUtil.DT_REPORT_PARAM_COVER_TYPE, "3");
        ProfileCardDtReportUtil.initElementWithExposureClickAndParams(this.mZplanCoverView, ProfileCardDtReportUtil.DT_REPORT_COVER, hashMap);
    }

    private void releaseAvatarOverlay() {
        QLog.i(TAG, 1, "releaseAvatarOverlay");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.profilecard.view.head.AbsZPlanProfileHeaderView.2
            @Override // java.lang.Runnable
            public void run() {
                if (AbsZPlanProfileHeaderView.this.mAvatarOverlayViewWiringHelper != null) {
                    if (AbsZPlanProfileHeaderView.this.mAvatarOverlayViewWiringHelper.c() != null) {
                        AbsZPlanProfileHeaderView.this.mAvatarOverlayViewWiringHelper.c().removeObserver(AbsZPlanProfileHeaderView.this.mLoadingOverlayObserver);
                    }
                    AbsZPlanProfileHeaderView.this.mAvatarOverlayViewWiringHelper.release();
                    AbsZPlanProfileHeaderView.this.mAvatarOverlayViewWiringHelper = null;
                }
            }
        });
    }

    private void requestDataOnInit() {
        QLog.i(TAG, 1, "requestDataOnInit");
        ProfileCardInfo profileCardInfo = this.mCardInfo;
        if (profileCardInfo != null && profileCardInfo.card != null) {
            requestMiniHomeInfo(isFriendCard() ? this.mCardInfo.card.uin : null);
        }
        tryRequestBackgroundUrl();
    }

    private void showZPlanStaticView() {
        QLog.e(TAG, 1, "showZPlanStaticView");
        com.tencent.mobileqq.zplan.meme.frameanim.a aVar = this.mZplanAvatarBannerManager;
        if (aVar != null) {
            aVar.o();
            com.tencent.mobileqq.zplan.meme.frameanim.e eVar = this.mAvatarOverlayViewWiringHelper;
            if (eVar != null) {
                eVar.b(this.mZplanAvatarBannerManager.a());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.profilecard.base.view.ProfileBaseView
    public int initCoverMode(ProfileCardInfo profileCardInfo) {
        QLog.i(TAG, 1, "initCoverMode");
        int initCoverMode = super.initCoverMode(profileCardInfo);
        if (this.mIsShowZplanCover) {
            return 2;
        }
        return initCoverMode;
    }

    public void showZplanBubble() {
        AllInOne allInOne;
        QLog.i(TAG, 1, "showZplanBubble");
        ensureBubbleControllerCreated(this.mZPlanBannerLayout);
        final long parseLong = (((IProfileCardApi) QRoute.api(IProfileCardApi.class)).isMyCard(this.mCardInfo) || (allInOne = this.mCardInfo.allInOne) == null) ? 0L : Long.parseLong(allInOne.uin);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.profilecard.view.head.AbsZPlanProfileHeaderView.8
            @Override // java.lang.Runnable
            public void run() {
                if (AbsZPlanProfileHeaderView.this.mAvatarBubbleController == null) {
                    return;
                }
                AbsZPlanProfileHeaderView.this.mAvatarBubbleController.g(parseLong);
            }
        }, 16, null, false);
    }

    /* loaded from: classes35.dex */
    public class RequestMiniHomeCallback implements IMiniHomeHelper.b {
        private String uin;

        public RequestMiniHomeCallback(String str) {
            this.uin = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResult$1(boolean z16) {
            final Activity activity;
            QLog.e(AbsZPlanProfileHeaderView.TAG, 1, "requestMiniHomeInfo startCreateMiniHomePage showGuidanceDialog.");
            if (!z16 || AbsZPlanProfileHeaderView.this.mActivityWeakRef == null || (activity = (Activity) AbsZPlanProfileHeaderView.this.mActivityWeakRef.get()) == null || activity.isFinishing()) {
                return;
            }
            ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).setBizPopGuideShow(true);
            ((IMiniHomeHelper) QRoute.api(IMiniHomeHelper.class)).showGuidanceDialog(activity, null, GuidanceSource.SOURCE_PROFILE, new IMiniHomeHelper.c() { // from class: com.tencent.mobileqq.profilecard.view.head.aa
                @Override // com.tencent.mobileqq.zplan.minihome.api.IMiniHomeHelper.c
                public final void onResult(boolean z17) {
                    AbsZPlanProfileHeaderView.RequestMiniHomeCallback.this.lambda$onResult$0(activity, z17);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResult$2(MiniHomeInfo miniHomeInfo) {
            if (!AbsZPlanProfileHeaderView.this.isFriendCard()) {
                boolean zPlanMiniHomeSettingSwitch = ((IMiniHomeHelper) QRoute.api(IMiniHomeHelper.class)).getZPlanMiniHomeSettingSwitch(Long.parseLong(((AbsProfileHeaderView) AbsZPlanProfileHeaderView.this).mCardInfo.card.uin));
                QLog.i(AbsZPlanProfileHeaderView.TAG, 1, "requestMiniHomeInfo 1012 accessible: " + zPlanMiniHomeSettingSwitch);
                if (!zPlanMiniHomeSettingSwitch) {
                    QLog.i(AbsZPlanProfileHeaderView.TAG, 1, "requestMiniHomeInfo 1012 false, return.");
                    return;
                }
            } else {
                QLog.i(AbsZPlanProfileHeaderView.TAG, 1, "requestMiniHomeInfo isZPlanProfileCardMiniHomeShow: " + ((AbsProfileHeaderView) AbsZPlanProfileHeaderView.this).mCardInfo.card.isZPlanProfileCardMiniHomeShow);
                if (!"1".equals(((AbsProfileHeaderView) AbsZPlanProfileHeaderView.this).mCardInfo.card.isZPlanProfileCardMiniHomeShow)) {
                    QLog.i(AbsZPlanProfileHeaderView.TAG, 1, "requestMiniHomeInfo isZPlanProfileCardMiniHomeShow false, return.");
                    return;
                }
                if (miniHomeInfo.getHasGift()) {
                    AbsZPlanProfileHeaderView.this.mGiftDesc = miniHomeInfo.getGiftDesc();
                    QLog.i(AbsZPlanProfileHeaderView.TAG, 1, "mGiftDesc: " + AbsZPlanProfileHeaderView.this.mGiftDesc);
                } else {
                    QLog.i(AbsZPlanProfileHeaderView.TAG, 1, "mGiftDesc, getHasGift: false");
                }
            }
            AbsZPlanProfileHeaderView.this.updateAvatarAndRoom(MiniHomeLoadSource.REUQEST_MINI_HOME);
            AbsZPlanProfileHeaderView.this.addMiniHomeGiftImageIfNeed();
        }

        @Override // com.tencent.mobileqq.zplan.minihome.api.IMiniHomeHelper.b
        public void onResult(boolean z16, final MiniHomeInfo miniHomeInfo) {
            QLog.i(AbsZPlanProfileHeaderView.TAG, 1, "requestMiniHomeInfo success: " + z16 + "; hasDestroy : " + AbsZPlanProfileHeaderView.this.hasDestroy);
            if (AbsZPlanProfileHeaderView.this.hasDestroy) {
                return;
            }
            if (((AbsProfileHeaderView) AbsZPlanProfileHeaderView.this).mCardInfo != null && ((AbsProfileHeaderView) AbsZPlanProfileHeaderView.this).mCardInfo.card != null) {
                int i3 = 0;
                final boolean askShowGuidanceDialog = (miniHomeInfo == null || !((AbsProfileHeaderView) AbsZPlanProfileHeaderView.this).mCardInfo.card.uin.equals(this.uin) || AbsZPlanProfileHeaderView.this.isFriendCard() || !miniHomeInfo.getIsGrayUser() || miniHomeInfo.getHasCreatedMiniHome() || StudyModeManager.t() || ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).isBizPopGuideShow()) ? false : ((IMiniHomeHelper) QRoute.api(IMiniHomeHelper.class)).askShowGuidanceDialog();
                VasIpcTempData.INSTANCE.getTempVar().setLong("key_profile_half_screen", askShowGuidanceDialog ? 3L : 2L);
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                if (peekAppRuntime == null) {
                    QLog.e(AbsZPlanProfileHeaderView.TAG, 1, "requestMiniHomeInfo failed, app null.");
                    return;
                }
                if (miniHomeInfo != null) {
                    QLog.i(AbsZPlanProfileHeaderView.TAG, 1, "requestMiniHomeInfo isGrayUser: " + miniHomeInfo.getIsGrayUser() + "; hasCreatedMiniHome: " + miniHomeInfo.getHasCreatedMiniHome() + "; roomDesc: " + miniHomeInfo.getRoomDesc());
                    if (!AbsZPlanProfileHeaderView.this.isFriendCard() || peekAppRuntime.getCurrentUin().equals(this.uin)) {
                        boolean zPlanMiniHomeSettingSwitch = ((IMiniHomeHelper) QRoute.api(IMiniHomeHelper.class)).getZPlanMiniHomeSettingSwitch(Long.parseLong(((AbsProfileHeaderView) AbsZPlanProfileHeaderView.this).mCardInfo.card.uin));
                        boolean hasCreatedMiniHome = miniHomeInfo.getHasCreatedMiniHome();
                        if (hasCreatedMiniHome && zPlanMiniHomeSettingSwitch) {
                            i3 = 2;
                        } else if (hasCreatedMiniHome) {
                            i3 = 1;
                        }
                        QLog.i(AbsZPlanProfileHeaderView.TAG, 1, "requestMiniHomeInfo saveHasCreatedMiniHome " + i3);
                        ((IMiniHomeHelper) QRoute.api(IMiniHomeHelper.class)).saveHasCreatedMiniHome(i3);
                    }
                    if (((AbsProfileHeaderView) AbsZPlanProfileHeaderView.this).mCardInfo.card.uin.equals(this.uin)) {
                        if (!miniHomeInfo.getHasCreatedMiniHome()) {
                            ((IMiniHomeHelper) QRoute.api(IMiniHomeHelper.class)).setTemporaryRoomDesc(((AbsProfileHeaderView) AbsZPlanProfileHeaderView.this).mCardInfo.card.uin, null);
                            ((IMiniHomeHelper) QRoute.api(IMiniHomeHelper.class)).setStaticImagePath(((AbsProfileHeaderView) AbsZPlanProfileHeaderView.this).mCardInfo.card.uin, MiniHomeSceneEnum.SCENE_PROFILE, "", "");
                        }
                        if (!AbsZPlanProfileHeaderView.this.isFriendCard() && miniHomeInfo.getIsGrayUser() && !miniHomeInfo.getHasCreatedMiniHome() && !StudyModeManager.t()) {
                            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.profilecard.view.head.y
                                @Override // java.lang.Runnable
                                public final void run() {
                                    AbsZPlanProfileHeaderView.RequestMiniHomeCallback.this.lambda$onResult$1(askShowGuidanceDialog);
                                }
                            });
                        }
                        com.tencent.mobileqq.zplan.minihome.ao roomDesc = miniHomeInfo.getRoomDesc();
                        if (!miniHomeInfo.getHasCreatedMiniHome() || roomDesc.getRoomDescJson().isEmpty()) {
                            return;
                        }
                        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.profilecard.view.head.z
                            @Override // java.lang.Runnable
                            public final void run() {
                                AbsZPlanProfileHeaderView.RequestMiniHomeCallback.this.lambda$onResult$2(miniHomeInfo);
                            }
                        });
                        return;
                    }
                    return;
                }
                return;
            }
            QLog.e(AbsZPlanProfileHeaderView.TAG, 1, "requestMiniHomeInfo failed, cardInfo null.");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResult$0(Activity activity, boolean z16) {
            if (z16) {
                ((IMiniHomeHelper) QRoute.api(IMiniHomeHelper.class)).startCreateMiniHomePage(activity, ((AbsProfileHeaderView) AbsZPlanProfileHeaderView.this).mCardInfo.card.uin, CreateMiniHomeSource.SELF_PROFILE_CARD);
                AbsZPlanProfileHeaderView.this.needForceReload.set(true);
                AbsZPlanProfileHeaderView.this.mMiniHomeEntranceFrom = "guide_dialog";
                return;
            }
            QLog.i(AbsZPlanProfileHeaderView.TAG, 1, "requestMiniHomeInfo startCreateMiniHomePage showGuidanceDialog cancel.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$addMiniHomeView$4(AppRuntime appRuntime, Activity activity, boolean z16) {
        if (z16) {
            ((IMiniHomeHelper) QRoute.api(IMiniHomeHelper.class)).startCreateMiniHomePage(activity, appRuntime.getCurrentUin(), CreateMiniHomeSource.SELF_PROFILE_CARD);
        } else {
            QLog.i(TAG, 1, "requestMiniHomeInfo startCreateMiniHomePage showGuidanceDialog cancel.");
        }
    }

    private void updateZPlanObserver(boolean z16) {
        if (z16) {
            addZPlanObserver();
        } else {
            removeZPlanObserver();
        }
    }

    public static void runOnUIThread(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            ThreadManagerV2.getUIHandlerV2().post(runnable);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.view.ProfileBaseView
    public void onCoverModeChange(int i3, ProfileCardInfo profileCardInfo) {
        if (i3 == 2) {
            updateZplanCoverMode();
        }
    }

    protected int zplanCardTopMargin(ProfileCardInfo profileCardInfo) {
        Card card;
        if (profileCardInfo != null && (card = profileCardInfo.card) != null) {
            boolean z16 = PrettyAccountUtil.isPrettyOpenForCard(card) == 1;
            if (!TextUtils.isEmpty(profileCardInfo.card.qidLogoUrl)) {
                return z16 ? -3 : -2;
            }
        }
        return 0;
    }

    private boolean isInMagicWindow(Context context) {
        if (context == null) {
            return false;
        }
        String configuration = context.getResources().getConfiguration().toString();
        return configuration.contains("hw-magic-windows") || configuration.contains("hwMultiwindow-magic") || configuration.contains("miui-magic-windows");
    }

    private boolean isPadLandscape(Context context) {
        return context != null && AppSetting.p(context) && context.getResources().getConfiguration().orientation == 2;
    }

    private boolean needReaddMiniHomeView(FrameLayout frameLayout, View view) {
        if (frameLayout == null || view == null) {
            return false;
        }
        for (int i3 = 0; i3 < frameLayout.getChildCount(); i3++) {
            if (frameLayout.getChildAt(i3).equals(view)) {
                return false;
            }
        }
        return true;
    }

    protected void hiddeMyDialog() {
    }

    protected void showMyDialog() {
    }
}
