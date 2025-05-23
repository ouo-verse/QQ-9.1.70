package com.qzone.module.feedcomponent.ui;

import android.content.Context;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qzone.commoncode.module.videorecommend.widget.PopupText;
import com.qzone.module.feedcomponent.FeedUtil;
import com.qzone.module.feedcomponent.ui.FeedOperation;
import com.qzone.module.feedcomponent.ui.canvasui.CanvasAttachView;
import com.qzone.module.feedcomponent.ui.common.SuperLikeView;
import com.qzone.module.feedcomponent.util.AlarmTask;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellCommentInfo;
import com.qzone.proxy.feedcomponent.model.CellDecorateInfo;
import com.qzone.proxy.feedcomponent.model.CellForwardListInfo;
import com.qzone.proxy.feedcomponent.model.CellLbsInfo;
import com.qzone.proxy.feedcomponent.model.CellLikeInfo;
import com.qzone.proxy.feedcomponent.model.CellPermissionInfo;
import com.qzone.proxy.feedcomponent.model.CellReferInfo;
import com.qzone.proxy.feedcomponent.model.CellRemarkInfo;
import com.qzone.proxy.feedcomponent.model.CellTitleInfo;
import com.qzone.proxy.feedcomponent.model.CellVisitorInfo;
import com.qzone.proxy.feedcomponent.model.ClickedPoint;
import com.qzone.proxy.feedcomponent.model.Comment;
import com.qzone.proxy.feedcomponent.model.CustomPraiseData;
import com.qzone.proxy.feedcomponent.service.QzoneCustomPraiseService;
import com.qzone.proxy.feedcomponent.text.CellTextView;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.qzone.proxy.feedcomponent.ui.SuperLikeAnimator$Event;
import com.qzone.proxy.feedcomponent.widget.ToastUtils;
import com.qzone.widget.AsyncImageView;
import com.qzone.widget.QzoneZipAnimateUtil;
import com.tencent.ditto.shell.DittoUIEngine;
import com.tencent.ditto.utils.DittoLog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.oskplayer.util.PlayerUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.report.lp.LpReportInfoConfig;
import cooperation.qzone.zipanimate.AnimationDrawableLoadedListener;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FeedOperation extends FeedViewSection implements View.OnClickListener, View.OnLongClickListener {
    private static int GUIDEVIEW_HEIGHT = 120;
    public static final String KEY_FEED_FORWARD_GUIDE = "feeds_forward_guide";
    public static final int OPERATION_ICON_ALIGN_LEFT = 1;
    public static final int OPERATION_ICON_ALIGN_RIGHT = 0;
    static final String TAG = "FeedOperation";
    private static String VISITOR_BUSINESS_TYPE = "feed_visitor";
    private com.qzone.proxy.feedcomponent.ui.f advButtonAnimationListener;
    boolean canComment;
    boolean canForward;
    boolean canPraise;
    Drawable commentDrawable;
    Drawable defaultLikeDrawable;
    int fakeType;
    BusinessFeedData feedData;
    Drawable forwardDrawable;
    boolean hasPraised;
    CharSequence hasPraisedStr;
    boolean isBizRecomFeeds;
    boolean isFriendLikeContainer;
    boolean isOnBottom;
    boolean isPicUpLayout;
    boolean isQunfeed;
    boolean isRecommendFeed;
    long lastLikeClickTime;
    private AnimationDrawableLoadedListener mAnimationDrawableListener;
    public CanvasAttachView mAttachView;
    private AlarmTask mAutoShowPolymorphicPraiseTask;
    GuideCommentBar mCellCommentGuideView;
    View mCommentContainer;
    TextView mCommentCountView;
    ImageView mCommentView;
    AsyncImageView mCustomBrowserInfoImage;
    TextView mCustomBrowserInfoText;
    private AlarmTask mDualWarmCommentIndicatorTask;
    View mForwardContainer;
    TextView mForwardCountView;
    private AlarmTask mForwardGuideTask;
    ImageView mForwardView;
    View mInteractTagContainer;
    CellTextView mInteractTagText;
    boolean mIsQbossPurchaseOrAdvFeed;
    View mLikeContainer;
    ViewGroup mOperationContainer;
    VisitAndPraiseAvatarsView mPraiseAvatarsView;
    TextView mPraiseCountView;
    SuperLikeView mPraiseView;
    CanvasPresentInfoView mPresentInfoView;
    ImageView mPriaseGuideView;
    View mRecommendContainer;
    ImageView mRecommendView;
    protected int mTrans;
    private Handler mUiHandler;
    int mVisitorDecoShowType;
    protected CellVisitorInfo mVisitorInfo;
    CharSequence notPraisedStr;
    private AlarmTask.OnAlarmListener onForwardGuideListener;
    private AlarmTask.OnAlarmListener onPolyPraiseListener;
    View operationLine;
    View operationPlaceHolder;
    boolean showPresentView;
    VisitView visitView;
    private static final boolean RECOMMEND_FEED_SHOW_ATTACH_VIEW = com.qzone.adapter.feedcomponent.i.H().U("QZoneSetting", "RecommendFeedShowAttachView", false);
    private static final boolean RECOMMEND_FEED_SHOW_TOPIC_TAG_VIEW = com.qzone.adapter.feedcomponent.i.H().U("QZoneSetting", "RecommendFeedShowTopicTagView", false);
    public static final String SOFT_TIME_FAKE_FEED_COMMENT_CLICK_TIP = com.qzone.adapter.feedcomponent.i.H().T("QZoneSetting", "secondary_fake_feed_soft_period_comment_tips", "\u53d1\u8868\u4e2d\uff0c\u8bf7\u7a0d\u540e\u518d\u8bc4\u8bba");
    public static final String SOFT_TIME_FAKE_FEED_FORWARD_CLICK_TIP = com.qzone.adapter.feedcomponent.i.H().T("QZoneSetting", "secondary_fake_feed_soft_period_comment_tips", "\u53d1\u8868\u4e2d\uff0c\u8bf7\u7a0d\u540e\u518d\u8f6c\u53d1");
    static final int PRAISE_AVATARS_VIEW_TOPMARGIN = (int) (FeedGlobalEnv.g().getDensity() * 15.0f);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.qzone.module.feedcomponent.ui.FeedOperation$1, reason: invalid class name */
    /* loaded from: classes39.dex */
    public class AnonymousClass1 extends AnimationDrawableLoadedListener {
        AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onNewLoadSuccess$0(com.tencent.mobileqq.vas.ui.c cVar) {
            AsyncImageView asyncImageView = FeedOperation.this.mCustomBrowserInfoImage;
            if (asyncImageView != null) {
                asyncImageView.setImageDrawable(cVar.getDrawable());
            }
        }

        @Override // cooperation.qzone.zipanimate.AnimationDrawableLoadedListener
        public void onLoadedSuccess(AnimationDrawable animationDrawable) {
            FeedOperation.this.setVisitorDecoImageWithAnimationDrawable(animationDrawable);
            super.onLoadedSuccess(animationDrawable);
        }

        @Override // cooperation.qzone.zipanimate.AnimationDrawableLoadedListener
        public void onNewLoadSuccess(final com.tencent.mobileqq.vas.ui.c cVar) {
            FeedOperation feedOperation = FeedOperation.this;
            if (feedOperation.mCustomBrowserInfoImage != null) {
                feedOperation.mUiHandler.post(new Runnable() { // from class: com.qzone.module.feedcomponent.ui.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        FeedOperation.AnonymousClass1.this.lambda$onNewLoadSuccess$0(cVar);
                    }
                });
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.qzone.module.feedcomponent.ui.FeedOperation$7, reason: invalid class name */
    /* loaded from: classes39.dex */
    static /* synthetic */ class AnonymousClass7 {
        static final /* synthetic */ int[] $SwitchMap$com$qzone$proxy$feedcomponent$ui$SuperLikeAnimator$Event;

        static {
            int[] iArr = new int[SuperLikeAnimator$Event.values().length];
            $SwitchMap$com$qzone$proxy$feedcomponent$ui$SuperLikeAnimator$Event = iArr;
            try {
                iArr[SuperLikeAnimator$Event.CLICK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$qzone$proxy$feedcomponent$ui$SuperLikeAnimator$Event[SuperLikeAnimator$Event.START_LONG_PRESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$qzone$proxy$feedcomponent$ui$SuperLikeAnimator$Event[SuperLikeAnimator$Event.CANCEL_LONG_PRESS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$qzone$proxy$feedcomponent$ui$SuperLikeAnimator$Event[SuperLikeAnimator$Event.END_LONG_PRESS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class CommentObj {
        public final View commentView;
        public final ClickedPoint point;

        CommentObj(ClickedPoint clickedPoint, View view) {
            this.point = clickedPoint;
            this.commentView = view;
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    private class OnEventBack implements SuperLikeView.OnEventBack {
        OnEventBack() {
        }

        @Override // com.qzone.module.feedcomponent.ui.common.SuperLikeView.OnEventBack
        public void onEventBack(SuperLikeAnimator$Event superLikeAnimator$Event, View view) {
            if (FeedOperation.this.fakeType == 0) {
                return;
            }
            int i3 = AnonymousClass7.$SwitchMap$com$qzone$proxy$feedcomponent$ui$SuperLikeAnimator$Event[superLikeAnimator$Event.ordinal()];
            if (i3 == 1) {
                view.performClick();
                return;
            }
            if (i3 == 2) {
                SuperLikeView superLikeView = FeedOperation.this.mPraiseView;
                if (superLikeView == null || view != superLikeView) {
                    return;
                }
                superLikeView.setTag("praise_click_tag");
                FeedOperation feedOperation = FeedOperation.this;
                feedOperation.onFeedElementClickListener.onClick(feedOperation.rootContainer, FeedElement.POLYMORPHIC_LIKE, feedOperation.feedPosition, view);
                return;
            }
            if (i3 == 3) {
                FeedOperation feedOperation2 = FeedOperation.this;
                feedOperation2.onFeedElementClickListener.onClick(feedOperation2.rootContainer, FeedElement.SUPERLIKE_ANIMATION, feedOperation2.feedPosition, superLikeAnimator$Event);
            } else {
                if (i3 != 4) {
                    return;
                }
                FeedOperation feedOperation3 = FeedOperation.this;
                feedOperation3.onFeedElementClickListener.onClick(feedOperation3.rootContainer, FeedElement.SUPERLIKE_ANIMATION, feedOperation3.feedPosition, superLikeAnimator$Event);
            }
        }
    }

    public FeedOperation(Context context, FeedView feedView) {
        super(context, feedView);
        this.hasPraisedStr = "";
        this.notPraisedStr = "";
        this.showPresentView = true;
        this.mTrans = 255;
        this.mUiHandler = new Handler(Looper.getMainLooper());
        this.mAnimationDrawableListener = new AnimationDrawableLoadedListener() { // from class: com.qzone.module.feedcomponent.ui.FeedOperation.2
            @Override // cooperation.qzone.zipanimate.AnimationDrawableLoadedListener
            public void onLoadedSuccess(AnimationDrawable animationDrawable) {
                FeedOperation.this.setVisitorDecoImageWithAnimationDrawable(animationDrawable);
                super.onLoadedSuccess(animationDrawable);
            }
        };
        this.onPolyPraiseListener = new AlarmTask.OnAlarmListener() { // from class: com.qzone.module.feedcomponent.ui.FeedOperation.4
            @Override // com.qzone.module.feedcomponent.util.AlarmTask.OnAlarmListener
            public void onAlarm(AlarmTask alarmTask) {
                if (FeedOperation.this.needShowPolyPraise()) {
                    FeedOperation.this.showPolyPraise();
                }
            }
        };
        this.onForwardGuideListener = new AlarmTask.OnAlarmListener() { // from class: com.qzone.module.feedcomponent.ui.FeedOperation.5
            @Override // com.qzone.module.feedcomponent.util.AlarmTask.OnAlarmListener
            public void onAlarm(AlarmTask alarmTask) {
                int[] iArr = new int[2];
                FeedOperation.this.mForwardView.getLocationOnScreen(iArr);
                FeedOperation feedOperation = FeedOperation.this;
                if (feedOperation.canShowForwardGuide(feedOperation.mForwardView, iArr, feedOperation.feedData)) {
                    PopupText popupText = new PopupText(FeedOperation.this.getContext(), "\u5206\u4eab\u642c\u5bb6\u5230\u8fd9\u91cc\u5566~", 1000);
                    int height = FeedOperation.this.mForwardView.getHeight();
                    int screenWidth = ((ViewUtils.getScreenWidth() - iArr[0]) - FeedOperation.this.mForwardView.getWidth()) / 2;
                    if (popupText.b() != null) {
                        screenWidth = (popupText.b().getMeasuredWidth() - FeedOperation.this.mForwardView.getWidth()) + AreaManager.f48752dp3;
                        height += popupText.b().getMeasuredHeight();
                    }
                    popupText.e(FeedOperation.this.mForwardView, -screenWidth, -height, true, true, com.qzone.adapter.feedcomponent.h.b("QZoneSetting", "forwardDisplayTime", 10000));
                }
            }
        };
        init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canShowForwardGuide(View view, int[] iArr, BusinessFeedData businessFeedData) {
        if (view != null && view.getVisibility() == 0) {
            if (businessFeedData != null && businessFeedData.feedType == 4097) {
                if (iArr[1] > ViewUtils.getScreenHeight() - view.getHeight()) {
                    if (DittoLog.isColoredLevel()) {
                        DittoLog.i(TAG, "not show forwardguide : forwardview not all visible");
                    }
                    return false;
                }
                if (iArr[1] < com.qzone.proxy.feedcomponent.util.g.a(GUIDEVIEW_HEIGHT)) {
                    if (DittoLog.isColoredLevel()) {
                        DittoLog.i(TAG, "not show forwardguide : this is no enough space to place guide view");
                    }
                    return false;
                }
                int i3 = iArr[0];
                if (i3 >= 0 && i3 + view.getWidth() <= ViewUtils.getScreenWidth()) {
                    if (!com.qzone.adapter.feedcomponent.i.H().l()) {
                        if (DittoLog.isColoredLevel()) {
                            DittoLog.i(TAG, "not show forwardguide : not meet condation");
                        }
                        return false;
                    }
                    if (!com.qzone.adapter.feedcomponent.i.H().g1()) {
                        if (DittoLog.isColoredLevel()) {
                            DittoLog.i(TAG, "not show forwardguide : the listveiw is scroll");
                        }
                        return false;
                    }
                    if (PopupText.d(KEY_FEED_FORWARD_GUIDE)) {
                        return true;
                    }
                    if (DittoLog.isColoredLevel()) {
                        DittoLog.i(TAG, "not show forwardguide : the guideview has shown");
                    }
                    return false;
                }
                if (DittoLog.isColoredLevel()) {
                    DittoLog.i(TAG, "not show forwardguide : forwardview not all visible");
                }
                return false;
            }
            if (DittoLog.isColoredLevel()) {
                DittoLog.i(TAG, "not show forwardguide : this is not in friendfeed");
            }
            return false;
        }
        if (DittoLog.isColoredLevel()) {
            DittoLog.i(TAG, "not show forwardguide : ForwardView is invisible");
        }
        return false;
    }

    private void checkAutoShowPolyPraise() {
        if (this.mAutoShowPolymorphicPraiseTask == null) {
            this.mAutoShowPolymorphicPraiseTask = new AlarmTask();
        }
        this.mAutoShowPolymorphicPraiseTask.cancelAlarm();
        this.mAutoShowPolymorphicPraiseTask.setAlarmListener(this.onPolyPraiseListener);
        this.mAutoShowPolymorphicPraiseTask.setTriggerTime(3000L);
    }

    private void checkForwardGuide() {
        if (!com.qzone.adapter.feedcomponent.i.H().f1()) {
            FeedGlobalEnv.g().postRunnableToNormalThread(new Runnable() { // from class: com.qzone.module.feedcomponent.ui.FeedOperation.6
                @Override // java.lang.Runnable
                public void run() {
                    if (com.qzone.adapter.feedcomponent.i.H().l()) {
                        PlayerUtils.runOnUiThread(new Runnable() { // from class: com.qzone.module.feedcomponent.ui.FeedOperation.6.1
                            @Override // java.lang.Runnable
                            public void run() {
                                FeedOperation.this.startForwardGuideTask();
                            }
                        });
                    }
                }
            });
        } else if (com.qzone.adapter.feedcomponent.i.H().l()) {
            startForwardGuideTask();
        }
    }

    private boolean hasCustomPraise(BusinessFeedData businessFeedData) {
        return ((businessFeedData.isGDTAdvFeed() && businessFeedData.feedType == 2) || !businessFeedData.getFeedCommInfo().canCustomPraise() || businessFeedData.getCellDecorateInfo() == null || businessFeedData.getCellDecorateInfo().cellCustomPraise == null || businessFeedData.getCellDecorateInfo().cellCustomPraise.iItemId <= 0) ? false : true;
    }

    private boolean hasFriendLikedCountData() {
        return false;
    }

    private boolean hasPolymorphicPraise(BusinessFeedData businessFeedData) {
        return (businessFeedData.getCellDecorateInfo() == null || businessFeedData.getCellDecorateInfo().cellPolymorphicPraise == null || businessFeedData.getCellDecorateInfo().cellPolymorphicPraise.iItemId <= 0) ? false : true;
    }

    private boolean needBirthdayRes(BusinessFeedData businessFeedData) {
        if (businessFeedData.getUser().customPraiseData == null || businessFeedData.getUser().customPraiseData.itemId <= 0) {
            return false;
        }
        return !hasCustomPraise(businessFeedData) || businessFeedData.getCellDecorateInfo().cellCustomPraise.iItemId == businessFeedData.getUser().customPraiseData.itemId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean needShowPolyPraise() {
        SuperLikeView superLikeView = this.mPraiseView;
        if (superLikeView == null) {
            DittoLog.i(TAG, "[polyPraise] needShowPolyPraise, mPraiseView = " + this.mPraiseView);
            return false;
        }
        int[] iArr = new int[2];
        superLikeView.getLocationOnScreen(iArr);
        int a16 = com.qzone.proxy.feedcomponent.util.g.a(127.0f);
        int screenHeight = ViewUtils.getScreenHeight() - ViewUtils.dpToPx(60.0f);
        BusinessFeedData businessFeedData = this.feedData;
        if (businessFeedData == null) {
            DittoLog.i(TAG, "[polyPraise] needShowPolyPraise, feedData = " + this.feedData);
            return false;
        }
        if (businessFeedData.getLikeInfo().isLiked) {
            if (DittoLog.isColoredLevel()) {
                DittoLog.i(TAG, "[polyPraise] needShowPolyPraise, isLike = " + this.feedData.getLikeInfo().isLiked);
            }
            return false;
        }
        if (!com.qzone.adapter.feedcomponent.i.H().g1()) {
            if (DittoLog.isColoredLevel()) {
                DittoLog.i(TAG, "[polyPraise] needShowPolyPraise, the listView is scroll");
            }
            return false;
        }
        if (!this.mPraiseView.isShown()) {
            if (DittoLog.isColoredLevel()) {
                DittoLog.i(TAG, "[polyPraise] needShowPolyPraise, mPraise isShown = " + this.mPraiseView.isShown());
            }
            return false;
        }
        if (!this.mPraiseView.hasWindowFocus()) {
            if (DittoLog.isColoredLevel()) {
                DittoLog.i(TAG, "[polyPraise] needShowPolyPraise, mPraise hasWindowFocus = " + this.mPraiseView.hasWindowFocus());
            }
            return false;
        }
        int i3 = iArr[1];
        if (i3 >= a16 && i3 <= screenHeight) {
            return true;
        }
        if (DittoLog.isColoredLevel()) {
            DittoLog.i(TAG, "[polyPraise] needShowPolyPraise, postion Y = " + iArr[1] + ", topLevel = " + a16 + ", bottomLevel = " + screenHeight);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVisitorDecoImageWithAnimationDrawable(final AnimationDrawable animationDrawable) {
        if (this.mCustomBrowserInfoImage != null) {
            this.mUiHandler.post(new Runnable() { // from class: com.qzone.module.feedcomponent.ui.FeedOperation.3
                @Override // java.lang.Runnable
                public void run() {
                    AsyncImageView asyncImageView = FeedOperation.this.mCustomBrowserInfoImage;
                    if (asyncImageView != null) {
                        asyncImageView.setImageDrawable(animationDrawable);
                        FeedOperation.this.mCustomBrowserInfoImage.setScaleType(ImageView.ScaleType.FIT_XY);
                        animationDrawable.setOneShot(false);
                        animationDrawable.start();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showPolyPraise() {
        SuperLikeView superLikeView = this.mPraiseView;
        if (superLikeView == null || this.onFeedElementClickListener == null) {
            return;
        }
        superLikeView.setTag("praise_click_tag");
        this.onFeedElementClickListener.onClick(this.rootContainer, FeedElement.AUTO_SHOW_POLYMORPHIC_LIKE, this.feedPosition, this.mPraiseView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startForwardGuideTask() {
        if (this.mForwardGuideTask == null) {
            this.mForwardGuideTask = new AlarmTask();
        }
        this.mForwardGuideTask.cancelAlarm();
        this.mForwardGuideTask.setAlarmListener(this.onForwardGuideListener);
        this.mForwardGuideTask.setTriggerTime(200L);
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    protected void attachView(NormalAbsFeedView normalAbsFeedView) {
        attachViewForRootContainer(normalAbsFeedView);
    }

    boolean canLikeClick() {
        if ((this.feedData.getFeedCommInfo().canCustomPraise() && QzoneCustomPraiseService.i().g() != null) || (this.feedData.isGDTAdvFeed() && this.feedData.getCellDecorateInfo() != null && com.qzone.proxy.feedcomponent.service.a.b().c(this.feedData.getCellDecorateInfo().cellCustomPraise) != null)) {
            this.lastLikeClickTime = SystemClock.uptimeMillis() + 500;
            return true;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.lastLikeClickTime <= 1000) {
            return false;
        }
        this.lastLikeClickTime = uptimeMillis;
        return true;
    }

    boolean canShowCommentCount() {
        return (FeedComment.RECOMMEND_FEED_SHOW_PRAISE_LIST_VIEW || this.feedData.feedType == 2) ? false : true;
    }

    boolean canShowForwardCount() {
        return (FeedComment.RECOMMEND_FEED_SHOW_PRAISE_LIST_VIEW || this.feedData.feedType == 2) ? false : true;
    }

    boolean canShowPraiseCount() {
        return (FeedComment.RECOMMEND_FEED_SHOW_PRAISE_LIST_VIEW || this.feedData.feedType == 2) ? false : true;
    }

    boolean canShowPresentInfoView(BusinessFeedData businessFeedData) {
        return false;
    }

    public int getOperationBottom() {
        ViewGroup viewGroup = this.mOperationContainer;
        if (viewGroup == null) {
            return 0;
        }
        return viewGroup.getBottom();
    }

    public Object getTag(int i3) {
        ImageView imageView = this.mCommentView;
        if (imageView == null || imageView.getTag(i3) == null) {
            return null;
        }
        return this.mCommentView.getTag(i3);
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    public boolean haveMultipleViews() {
        return true;
    }

    public void insertBgView(Drawable drawable) {
        ViewGroup viewGroup = this.mOperationContainer;
        if (viewGroup != null) {
            viewGroup.setBackground(drawable);
        }
    }

    public boolean isLineVisible() {
        View view = this.operationLine;
        return view != null && view.getVisibility() == 0;
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    public List<View> obtainViews() {
        ArrayList arrayList = new ArrayList();
        if (this.mAttachView == null) {
            CanvasAttachView canvasAttachView = new CanvasAttachView(getContext(), null);
            this.mAttachView = canvasAttachView;
            canvasAttachView.setLayoutParams(generateLayoutParams());
        }
        if (this.mOperationContainer == null) {
            ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(getContext()).inflate(DittoUIEngine.g().getResourceId("@layout/qzone_widget_feed_operation"), (ViewGroup) null);
            this.mOperationContainer = viewGroup;
            viewGroup.setLayoutParams(generateLayoutParams());
            this.mPraiseView = (SuperLikeView) this.mOperationContainer.findViewById(com.qzone.adapter.feedcomponent.j.O(2188));
            this.mLikeContainer = this.mOperationContainer.findViewById(com.qzone.adapter.feedcomponent.j.O(2917));
            this.mCommentContainer = this.mOperationContainer.findViewById(com.qzone.adapter.feedcomponent.j.O(2791));
            this.mCommentView = (ImageView) this.mOperationContainer.findViewById(com.qzone.adapter.feedcomponent.j.O(2189));
            this.mForwardView = (ImageView) this.mOperationContainer.findViewById(com.qzone.adapter.feedcomponent.j.O(2190));
            this.mForwardContainer = this.mOperationContainer.findViewById(com.qzone.adapter.feedcomponent.j.O(2790));
            this.mRecommendContainer = this.mOperationContainer.findViewById(com.qzone.adapter.feedcomponent.j.O(2860));
            this.mRecommendView = (ImageView) this.mOperationContainer.findViewById(com.qzone.adapter.feedcomponent.j.O(2861));
            this.mPriaseGuideView = (ImageView) this.mOperationContainer.findViewById(com.qzone.adapter.feedcomponent.j.O(2473));
            this.mPraiseCountView = (TextView) this.mOperationContainer.findViewById(com.qzone.adapter.feedcomponent.j.O(2725));
            this.mCommentCountView = (TextView) this.mOperationContainer.findViewById(com.qzone.adapter.feedcomponent.j.O(2726));
            this.mForwardCountView = (TextView) this.mOperationContainer.findViewById(com.qzone.adapter.feedcomponent.j.O(2727));
            this.visitView = (VisitView) this.mOperationContainer.findViewById(com.qzone.adapter.feedcomponent.j.O(2331));
            this.mCustomBrowserInfoImage = (AsyncImageView) this.mOperationContainer.findViewById(com.qzone.adapter.feedcomponent.j.O(2786));
            this.mCustomBrowserInfoText = (TextView) this.mOperationContainer.findViewById(com.qzone.adapter.feedcomponent.j.O(2788));
            this.mInteractTagContainer = this.mOperationContainer.findViewById(com.qzone.adapter.feedcomponent.j.O(2867));
            this.mInteractTagText = (CellTextView) this.mOperationContainer.findViewById(com.qzone.adapter.feedcomponent.j.O(2868));
            this.operationLine = this.mOperationContainer.findViewById(com.qzone.adapter.feedcomponent.j.O(2332));
            this.operationPlaceHolder = this.mOperationContainer.findViewById(com.qzone.adapter.feedcomponent.j.O(2333));
            this.mPraiseView.setOnClickListener(this);
            this.mLikeContainer.setOnClickListener(this);
            this.mCommentView.setOnClickListener(this);
            this.mCommentContainer.setOnClickListener(this);
            this.mForwardView.setOnClickListener(this);
            this.mForwardContainer.setOnClickListener(this);
            this.mRecommendView.setOnClickListener(this);
            this.mForwardView.setOnLongClickListener(this);
            this.mCommentView.setOnLongClickListener(this);
            this.defaultLikeDrawable = this.mPraiseView.getDrawable();
            this.mPraiseView.setOnEventBack(new OnEventBack());
        }
        if (this.mPresentInfoView == null) {
            this.mPresentInfoView = new CanvasPresentInfoView(getContext(), null);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            int i3 = AreaConst.dp8;
            ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = i3;
            ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = i3;
            this.mPresentInfoView.setLayoutParams(layoutParams);
        }
        AsyncImageView asyncImageView = this.mCustomBrowserInfoImage;
        if (asyncImageView != null) {
            asyncImageView.setOnClickListener(this);
            this.mCustomBrowserInfoImage.setFocusable(true);
        }
        TextView textView = this.mCustomBrowserInfoText;
        if (textView != null) {
            textView.setOnClickListener(this);
            this.mCustomBrowserInfoText.setFocusable(true);
        }
        CellTextView cellTextView = this.mInteractTagText;
        if (cellTextView != null) {
            cellTextView.setOnClickListener(this);
            this.mInteractTagText.setFocusable(true);
        }
        arrayList.add(this.mAttachView);
        arrayList.add(this.mOperationContainer);
        arrayList.add(this.mPresentInfoView);
        return arrayList;
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    protected void onApplyFeedData() {
        ArrayList<Comment> arrayList;
        ArrayList<Comment> arrayList2;
        BusinessFeedData businessFeedData = this.mFeedData;
        if (businessFeedData != null) {
            if (businessFeedData.feedType == 4098) {
                CellCommentInfo commentInfoV2 = businessFeedData.getCommentInfoV2();
                if (commentInfoV2 == null || (arrayList2 = commentInfoV2.commments) == null || arrayList2.size() == 0) {
                    commentInfoV2 = this.mFeedData.getOriginalInfo() == null ? null : this.mFeedData.getOriginalInfo().getCommentInfoV2();
                }
                MyFeedViewBuilder.setOperationData(this, this.mFeedData, commentInfoV2 == null || (arrayList = commentInfoV2.commments) == null || arrayList.size() == 0);
            } else {
                setFakeType(businessFeedData.getLocalInfo().fakeType);
                if (!this.mFeedData.getFeedCommInfo().isBizRecomFamousFeeds() && !this.mFeedData.getFeedCommInfo().isQbossPurchaseFeeds() && ((this.mFeedData.getRecommAction() == null || !this.mFeedData.isNewAdvStyle()) && !this.mFeedData.isSpecialCareInContainerFeed() && !this.mFeedData.isCardFriendsRecommendContainerFeed() && !this.mFeedData.isCardSpecialFollowMoreRecommendContainerFeed() && !this.mFeedData.isCardSchoolRecommendContainerFeed() && !this.mFeedData.isFollowGuideFeed() && !this.mFeedData.isCardFollowMoreRecommendContainerFeed() && !this.mFeedData.isSubOfFriendBirthdayContainerFeed() && !this.mFeedData.isSubOfSingleAdvContainerFeed())) {
                    setCanPraise(this.mFeedData.getLocalInfo().canLike);
                    setCanComment(this.mFeedData.getLocalInfo().canComment);
                    setCanForward(FeedViewBuilder.canForward(this.mFeedData));
                } else {
                    setCanPraise(false);
                    setCanComment(false);
                    setCanForward(false);
                }
                setHasPraised(this.mFeedData.getLikeInfoV2() != null ? this.mFeedData.getLikeInfoV2().isLiked : false);
                setIsOnBottom(this.isOnBottom);
                setFeedData(this.mFeedData);
                if (this.mFeedData.getOriginalInfo() != null && this.mFeedData.getOriginalInfo().getPermissionInfoV2() != null) {
                    setPermissionInfo(this.mFeedData.getOriginalInfo().getPermissionInfoV2());
                } else {
                    setPermissionInfo(this.mFeedData.getPermissionInfoV2());
                }
                if (this.mFeedData.getOriginalInfo() != null && this.mFeedData.getOriginalInfo().getReferInfoV2() != null) {
                    setReferInfo(this.mFeedData.getOriginalInfo().getReferInfoV2());
                } else {
                    setReferInfo(this.mFeedData.getReferInfoV2());
                }
                if (this.mFeedData.getOriginalInfo() != null && this.mFeedData.getOriginalInfo().getLbsInfoV2() != null) {
                    setLbsInfo(this.mFeedData.getOriginalInfo().getLbsInfoV2());
                } else {
                    setLbsInfo(this.mFeedData.getLbsInfoV2());
                }
                if (this.mFeedData.getOriginalInfo() != null && this.mFeedData.getOriginalInfo().getRemarkInfoV2() != null) {
                    setRemarkInfo(this.mFeedData.getOriginalInfo().getRemarkInfoV2());
                } else {
                    setRemarkInfo(this.mFeedData.getRemarkInfoV2());
                }
                update();
            }
            if (this.mPresentInfoView == null || !canShowPresentInfoView(this.feedData)) {
                return;
            }
            this.mPresentInfoView.setFeedData(this.feedData);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        NormalAbsFeedView normalAbsFeedView;
        EventCollector.getInstance().onViewClickedBefore(view);
        if (this.fakeType != 0 && this.onFeedElementClickListener != null) {
            if (this.mCellCommentGuideView == null && (normalAbsFeedView = this.mRootView) != null && normalAbsFeedView.getFeedComment() != null) {
                this.mCellCommentGuideView = this.mRootView.getFeedComment().getCommentBar();
            }
            if (view != this.mPraiseView && view != this.mLikeContainer) {
                if (view != this.mCommentContainer && view != this.mCommentView) {
                    if (view != this.mForwardContainer && view != this.mForwardView) {
                        if (view == this.mRecommendView) {
                            com.qzone.proxy.feedcomponent.ui.g gVar = this.onFeedElementClickListener;
                            View view2 = this.rootContainer;
                            FeedElement feedElement = FeedElement.RECOMMEND_BUTTON;
                            int i3 = this.feedPosition;
                            gVar.onClick(view2, feedElement, i3, Integer.valueOf(i3));
                        } else if (view != this.mCustomBrowserInfoImage && view != this.mCustomBrowserInfoText) {
                            if (view == this.mInteractTagText) {
                                com.qzone.proxy.feedcomponent.ui.g gVar2 = this.onFeedElementClickListener;
                                if (gVar2 != null) {
                                    FeedElement feedElement2 = FeedElement.INTERACT_TAG;
                                    int i16 = this.feedPosition;
                                    gVar2.onClick(view, feedElement2, i16, Integer.valueOf(i16));
                                }
                            } else {
                                com.qzone.proxy.feedcomponent.ui.g gVar3 = this.onFeedElementClickListener;
                                View view3 = this.rootContainer;
                                FeedElement feedElement3 = FeedElement.NOTHING;
                                int i17 = this.feedPosition;
                                gVar3.onClick(view3, feedElement3, i17, Integer.valueOf(i17));
                            }
                        } else {
                            com.qzone.proxy.feedcomponent.ui.g gVar4 = this.onFeedElementClickListener;
                            if (gVar4 != null) {
                                gVar4.onClick(view, FeedElement.VISIT, this.feedPosition, this.mVisitorInfo);
                            }
                        }
                    } else if (this.mFeedData.isSoftFakeFeed()) {
                        ToastUtils.b(FeedGlobalEnv.getContext(), SOFT_TIME_FAKE_FEED_FORWARD_CLICK_TIP);
                    } else {
                        GuideCommentBar guideCommentBar = this.mCellCommentGuideView;
                        this.onFeedElementClickListener.onClick(this.mCellCommentGuideView, FeedElement.FORWARD_BUTTON, this.feedPosition, new CommentObj(guideCommentBar != null ? guideCommentBar.getGuideAreaClickedPoint() : null, this.mForwardView));
                    }
                } else if (this.mFeedData.isSoftFakeFeed()) {
                    ToastUtils.b(FeedGlobalEnv.getContext(), SOFT_TIME_FAKE_FEED_COMMENT_CLICK_TIP);
                } else {
                    GuideCommentBar guideCommentBar2 = this.mCellCommentGuideView;
                    this.onFeedElementClickListener.onClick(this.mCellCommentGuideView, FeedElement.COMMENT_BUTTON, this.feedPosition, new CommentObj(guideCommentBar2 != null ? guideCommentBar2.getGuideAreaClickedPoint() : null, this.mCommentView));
                }
            } else if (canLikeClick()) {
                onPraiseViewClick();
                this.mPraiseView.setTag("praise_click_tag");
                com.qzone.proxy.feedcomponent.ui.g gVar5 = this.onFeedElementClickListener;
                View view4 = this.rootContainer;
                FeedElement feedElement4 = FeedElement.PRAISE_BUTTON;
                int i18 = this.feedPosition;
                gVar5.onClick(view4, feedElement4, i18, Integer.valueOf(i18));
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        EventCollector.getInstance().onViewLongClickedBefore(view);
        boolean z16 = false;
        if (this.fakeType != 0 && this.onFeedElementClickListener != null) {
            if (view == this.mForwardView) {
                if (this.mFeedData.isSoftFakeFeed()) {
                    ToastUtils.b(FeedGlobalEnv.getContext(), SOFT_TIME_FAKE_FEED_FORWARD_CLICK_TIP);
                } else {
                    this.onFeedElementClickListener.a(FeedElement.FORWARD_BUTTON, Integer.valueOf(this.feedPosition), null, null);
                }
            } else if (view == this.mCommentView) {
                if (this.mFeedData.isSoftFakeFeed()) {
                    ToastUtils.b(FeedGlobalEnv.getContext(), SOFT_TIME_FAKE_FEED_COMMENT_CLICK_TIP);
                } else {
                    z16 = this.onFeedElementClickListener.a(FeedElement.COMMENT_LONG_CLICK, Integer.valueOf(this.feedPosition), this.rootContainer, null);
                }
            }
            z16 = true;
        }
        EventCollector.getInstance().onViewLongClicked(view);
        return z16;
    }

    void onPraiseViewClick() {
        CustomPraiseData g16;
        if (this.mPraiseView.isSelected()) {
            this.mPraiseView.setImageDrawable(this.defaultLikeDrawable);
            return;
        }
        if (this.feedData.isGDTAdvFeed()) {
            g16 = (this.feedData.getCellDecorateInfo() == null || this.feedData.getCellDecorateInfo().cellCustomPraise == null) ? null : com.qzone.proxy.feedcomponent.service.a.b().c(this.feedData.getCellDecorateInfo().cellCustomPraise);
        } else {
            g16 = QzoneCustomPraiseService.i().g();
        }
        if (this.feedData.getUser().customPraiseData != null && this.feedData.getUser().customPraiseData.itemId > 0) {
            g16 = this.feedData.getUser().customPraiseData;
        }
        if (g16 != null) {
            if (g16.praiseType == 1) {
                this.mPraiseView.setAsyncImage(g16.praiseIconUrl);
                return;
            }
            return;
        }
        this.mPraiseView.setImageDrawable(this.defaultLikeDrawable);
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection, com.qzone.proxy.feedcomponent.widget.g
    public void onRecycled() {
        CanvasAttachView canvasAttachView = this.mAttachView;
        if (canvasAttachView != null) {
            canvasAttachView.onRecycled();
        }
        AsyncImageView asyncImageView = this.mCustomBrowserInfoImage;
        if (asyncImageView != null) {
            asyncImageView.setAnimation(null);
        }
        CanvasPresentInfoView canvasPresentInfoView = this.mPresentInfoView;
        if (canvasPresentInfoView != null) {
            canvasPresentInfoView.onRecycled();
        }
        this.mCellCommentGuideView = null;
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    protected void onUpdate() {
        if (this.feedData == null) {
            return;
        }
        if (!updateOperation(r0)) {
            boolean z16 = this.isOnBottom;
        }
        if (!this.mIsQbossPurchaseOrAdvFeed && !this.isBizRecomFeeds && !this.feedData.isGDTAdvFeed()) {
            FeedViewSection.setViewVisbile(this.mAttachView);
            this.mAttachView.update();
            this.mAttachView.forceLayout();
        } else {
            FeedViewSection.setViewGone(this.mAttachView);
        }
        BusinessFeedData businessFeedData = this.feedData;
        if (businessFeedData.feedType == 2) {
            this.visitView.setVisitInfo(this.mVisitorInfo, true, businessFeedData);
        } else {
            this.visitView.setVisitInfo(this.mVisitorInfo, false, businessFeedData);
        }
        BusinessFeedData businessFeedData2 = this.feedData.parentFeedData;
        boolean z17 = businessFeedData2 != null && businessFeedData2.isFriendLikeContainer();
        boolean z18 = this.feedData.getFeedCommInfo().recomlayout == 1;
        if ((this.feedData.isAdFeeds() || this.feedData.isBrandUgcAdvFeeds()) && this.feedData.getRecommAction() != null) {
            if (this.feedData.getRecommAction() != null && !TextUtils.isEmpty(this.feedData.getRecommAction().interact_left_text)) {
                this.visitView.setRemarkStr(this.feedData.getRecommAction().interact_left_text);
            }
        } else if (z17 && !z18 && this.feedData.getCellFrdlikeContainer() != null && this.feedData.getCellFrdlikeContainer().rightDesc != null) {
            this.visitView.setRemarkStr(this.feedData.getCellFrdlikeContainer().rightDesc);
        }
        if (canShowPresentInfoView(this.feedData)) {
            FeedViewSection.setViewVisbile(this.mPresentInfoView);
        } else {
            FeedViewSection.setViewGone(this.mPresentInfoView);
        }
        this.visitView.requestLayout();
        this.rootContainer.forceLayout();
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    public void setAlpha(int i3) {
        this.mTrans = i3;
        View view = this.operationLine;
        if (view == null || view.getBackground() == null) {
            return;
        }
        this.operationLine.getBackground().setAlpha(this.mTrans);
    }

    public void setAttachVisibility(int i3) {
        CanvasAttachView canvasAttachView = this.mAttachView;
        if (canvasAttachView != null) {
            canvasAttachView.setVisibility(i3);
        }
    }

    public void setCanComment(boolean z16) {
        this.canComment = z16;
    }

    public void setCanForward(boolean z16) {
        this.canForward = z16;
    }

    public void setCanPraise(boolean z16) {
        this.canPraise = z16;
    }

    public void setFakeType(int i3) {
        this.fakeType = i3;
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    public void setFeedPosition(int i3) {
        VisitView visitView;
        NormalAbsFeedView normalAbsFeedView;
        super.setFeedPosition(i3);
        CanvasAttachView canvasAttachView = this.mAttachView;
        if (canvasAttachView != null) {
            canvasAttachView.setFeedPosition(i3);
        }
        CanvasPresentInfoView canvasPresentInfoView = this.mPresentInfoView;
        if (canvasPresentInfoView != null && this.mRootView != null) {
            canvasPresentInfoView.setFeedPosition(i3);
        }
        VisitAndPraiseAvatarsView visitAndPraiseAvatarsView = this.mPraiseAvatarsView;
        if (visitAndPraiseAvatarsView != null && (normalAbsFeedView = this.mRootView) != null) {
            visitAndPraiseAvatarsView.setFeedPosition(i3, normalAbsFeedView.mIndex);
        }
        NormalAbsFeedView normalAbsFeedView2 = this.mRootView;
        if (normalAbsFeedView2 == null || (visitView = this.visitView) == null) {
            return;
        }
        visitView.setFeedPosition(i3, normalAbsFeedView2.mIndex);
    }

    public void setFeedTitleInfo(CellTitleInfo cellTitleInfo) {
        this.mAttachView.setTitleInfo(cellTitleInfo);
    }

    public void setHasPraised(boolean z16) {
        this.hasPraised = z16;
    }

    public void setIsOnBottom(boolean z16) {
        this.isOnBottom = z16;
    }

    public void setLbsInfo(CellLbsInfo cellLbsInfo) {
        this.mAttachView.setLbsInfo(cellLbsInfo);
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    public void setOnFeedElementClickListener(com.qzone.proxy.feedcomponent.ui.g gVar) {
        super.setOnFeedElementClickListener(gVar);
        CanvasAttachView canvasAttachView = this.mAttachView;
        if (canvasAttachView != null) {
            canvasAttachView.setOnFeedElementClickListener(gVar);
        }
        VisitView visitView = this.visitView;
        if (visitView != null) {
            visitView.setOnFeedElementClickListener(gVar);
        }
        CanvasPresentInfoView canvasPresentInfoView = this.mPresentInfoView;
        if (canvasPresentInfoView != null) {
            canvasPresentInfoView.setOnFeedElementClickListener(gVar);
        }
    }

    public void setOperationVisibility(int i3) {
        ViewGroup viewGroup = this.mOperationContainer;
        if (viewGroup != null) {
            viewGroup.setVisibility(i3);
        }
    }

    public void setPraiseInfo(List<CellLikeInfo.LikeMan> list, int i3) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mPraiseAvatarsView.getLayoutParams();
        if (list != null && list.size() != 0) {
            this.mPraiseAvatarsView.setPraiseData(list, i3);
            int i16 = marginLayoutParams.topMargin;
            int i17 = PRAISE_AVATARS_VIEW_TOPMARGIN;
            if (i16 == i17 && marginLayoutParams.bottomMargin == 0) {
                return;
            }
            marginLayoutParams.topMargin = i17;
            marginLayoutParams.bottomMargin = 0;
            this.mPraiseAvatarsView.requestLayout();
            if (com.qzone.adapter.feedcomponent.i.H().S0()) {
                VisitAndPraiseAvatarsView visitAndPraiseAvatarsView = this.mPraiseAvatarsView;
                visitAndPraiseAvatarsView.setContentDescription(visitAndPraiseAvatarsView.getReadStr());
                return;
            }
            return;
        }
        this.mPraiseAvatarsView.setPraiseData(null, 0);
        if (marginLayoutParams.topMargin == 0 && marginLayoutParams.bottomMargin == 0) {
            return;
        }
        marginLayoutParams.topMargin = 0;
        marginLayoutParams.bottomMargin = 0;
        this.mPraiseAvatarsView.requestLayout();
    }

    public void setReferInfo(CellReferInfo cellReferInfo) {
        this.mAttachView.setReferInfo(cellReferInfo);
    }

    public void setRemarkInfo(CellRemarkInfo cellRemarkInfo) {
        this.mAttachView.setRemarkInfo(cellRemarkInfo);
    }

    public void setShowPresentView(boolean z16) {
        this.showPresentView = z16;
    }

    public void setVisitorInfo(CellVisitorInfo cellVisitorInfo) {
        this.mVisitorInfo = cellVisitorInfo;
    }

    public void updateLikeInfo(BusinessFeedData businessFeedData) {
        updateOperation(businessFeedData);
    }

    public void updateOperationButtonBackgroud() {
        com.qzone.adapter.feedcomponent.i.H().g1();
    }

    void updateOperationLine(BusinessFeedData businessFeedData) {
        if (this.isRecommendFeed && !FeedComment.RECOMMEND_FEED_SHOW_PRAISE_LIST_VIEW) {
            boolean z16 = (businessFeedData.getCommentInfoV2() == null || businessFeedData.getCommentInfoV2().commments == null || businessFeedData.getCommentInfoV2().commments.size() <= 0) ? false : true;
            if (!FeedComment.RECOMMEND_FEED_SHOW_COMMENT_LIST || !z16) {
                FeedViewSection.setViewGone(this.operationLine);
                FeedViewSection.setViewGone(this.operationPlaceHolder);
                return;
            }
        }
        this.operationLine.setBackgroundColor(com.qzone.adapter.feedcomponent.j.H());
        if (this.isFriendLikeContainer && !this.isPicUpLayout) {
            this.operationLine.setVisibility(4);
            this.operationPlaceHolder.setVisibility(8);
            return;
        }
        if (!canShowPresentInfoView(businessFeedData) && (((!FeedUtil.hasPraiseList(businessFeedData) && (!FeedUtil.hasComment(businessFeedData) || businessFeedData.getCommentInfoV2().showHeader)) || businessFeedData.getFeedCommInfo().recomtype == 7) && !FeedUtil.hasRedBonus(businessFeedData) && (businessFeedData.getCellForwardInfo() == null || TextUtils.isEmpty(businessFeedData.getCellForwardInfo().displayStr)))) {
            this.operationLine.setVisibility(4);
            this.operationPlaceHolder.setVisibility(8);
            return;
        }
        this.operationLine.setVisibility(0);
        this.operationPlaceHolder.setVisibility(0);
        ViewGroup.LayoutParams layoutParams = this.operationPlaceHolder.getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        layoutParams.height = AreaConst.dp10;
        this.operationPlaceHolder.setLayoutParams(layoutParams);
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    public void reset() {
        this.isQunfeed = false;
        this.fakeType = 2;
        this.canComment = false;
        this.canPraise = false;
        this.canForward = false;
        this.hasPraised = false;
        this.isOnBottom = false;
        this.mVisitorInfo = null;
        this.feedData = null;
        SuperLikeView superLikeView = this.mPraiseView;
        if (superLikeView != null) {
            superLikeView.setTag(null);
        }
        VisitView visitView = this.visitView;
        if (visitView != null) {
            visitView.reset();
        }
        SuperLikeView superLikeView2 = this.mPraiseView;
        if (superLikeView2 != null) {
            superLikeView2.setImageDrawable(null);
        }
        AsyncImageView asyncImageView = this.mCustomBrowserInfoImage;
        if (asyncImageView != null) {
            asyncImageView.setAnimation(null);
        }
    }

    void init() {
        this.hasPraisedStr = com.qzone.adapter.feedcomponent.j.M(1366);
        this.notPraisedStr = com.qzone.adapter.feedcomponent.j.M(1367);
        this.commentDrawable = com.qzone.adapter.feedcomponent.j.g(663);
        this.forwardDrawable = com.qzone.adapter.feedcomponent.j.g(LpReportInfoConfig.ACTION_VIDEO_EDITOR);
    }

    protected void updatePraiseCountColor(boolean z16) {
        if (z16) {
            this.mPraiseCountView.setTextColor(Color.parseColor("#EDBF04"));
        } else {
            this.mPraiseCountView.setTextColor(-16777216);
        }
    }

    public void setCommentCountInfo(CellCommentInfo cellCommentInfo) {
        int i3;
        if (cellCommentInfo != null) {
            i3 = cellCommentInfo.realCount;
            if (i3 == 0) {
                i3 = cellCommentInfo.commentNum;
            }
        } else {
            i3 = 0;
        }
        if (i3 > 0 && canShowCommentCount()) {
            String calculateDisplayCount = calculateDisplayCount(i3);
            this.mCommentCountView.setText(calculateDisplayCount);
            this.mCommentCountView.setVisibility(0);
            if (com.qzone.adapter.feedcomponent.i.H().S0()) {
                this.mCommentView.setContentDescription("\u8bc4\u8bba" + calculateDisplayCount);
                return;
            }
            return;
        }
        this.mCommentCountView.setVisibility(8);
        if (com.qzone.adapter.feedcomponent.i.H().S0()) {
            this.mCommentView.setContentDescription("\u8bc4\u8bba");
        }
    }

    public void setForwardCountInfo(CellForwardListInfo cellForwardListInfo) {
        int i3 = cellForwardListInfo != null ? cellForwardListInfo.num : 0;
        if (i3 > 0 && canShowForwardCount()) {
            String calculateDisplayCount = calculateDisplayCount(i3);
            this.mForwardCountView.setText(calculateDisplayCount(i3));
            if (com.qzone.adapter.feedcomponent.i.H().S0()) {
                this.mForwardView.setContentDescription("\u8f6c\u53d1" + calculateDisplayCount);
            }
            this.mForwardCountView.setVisibility(0);
            return;
        }
        if (com.qzone.adapter.feedcomponent.i.H().S0()) {
            this.mForwardView.setContentDescription("\u8f6c\u53d1");
        }
        this.mForwardCountView.setVisibility(8);
    }

    public void setPraiseCountInfo(CellLikeInfo cellLikeInfo) {
        int i3 = cellLikeInfo != null ? cellLikeInfo.likeNum : 0;
        if (i3 > 0 && canShowPraiseCount()) {
            String calculateDisplayCount = calculateDisplayCount(i3);
            this.mPraiseCountView.setText(calculateDisplayCount);
            updatePraiseCountColor(cellLikeInfo.isLiked);
            if (com.qzone.adapter.feedcomponent.i.H().S0()) {
                this.mPraiseView.setContentDescription("\u70b9\u8d5e" + calculateDisplayCount);
            }
            this.mPraiseCountView.setVisibility(0);
            return;
        }
        if (com.qzone.adapter.feedcomponent.i.H().S0()) {
            this.mPraiseView.setContentDescription("\u70b9\u8d5e");
        }
        this.mPraiseCountView.setVisibility(8);
    }

    protected String calculateDisplayCount(int i3) {
        if (i3 < 10000) {
            return String.valueOf(i3);
        }
        return (i3 / 10000) + "\u4e07+";
    }

    public void setFeedData(BusinessFeedData businessFeedData) {
        CellVisitorInfo cellVisitorInfo;
        CellDecorateInfo cellDecorateInfo;
        CellVisitorInfo cellVisitorInfo2;
        CellVisitorInfo cellVisitorInfo3;
        CanvasAttachView canvasAttachView;
        this.feedData = businessFeedData;
        if (businessFeedData != null && (businessFeedData.getFeedCommInfo().feedsAttr & 3072) != 0) {
            this.mIsQbossPurchaseOrAdvFeed = true;
        } else {
            this.mIsQbossPurchaseOrAdvFeed = false;
        }
        if (businessFeedData == null) {
            return;
        }
        this.isBizRecomFeeds = businessFeedData.getFeedCommInfo().isBizRecomFeeds();
        this.isPicUpLayout = businessFeedData.getFeedCommInfo().isPicUpLayout();
        BusinessFeedData businessFeedData2 = businessFeedData.parentFeedData;
        if (businessFeedData2 != null) {
            this.isFriendLikeContainer = businessFeedData2.isFriendLikeContainer();
        }
        setVisitorInfo(businessFeedData.getVisitorInfo());
        this.isQunfeed = com.qzone.adapter.feedcomponent.i.H().u1(businessFeedData);
        this.isRecommendFeed = businessFeedData.isRecommendFeed();
        if (com.qzone.adapter.feedcomponent.i.H().S0()) {
            if (TextUtils.isEmpty(businessFeedData.feedAttachReadstr) && (canvasAttachView = this.mAttachView) != null) {
                canvasAttachView.setContentDescription(businessFeedData.feedAttachReadstr);
            }
            this.mPraiseView.setContentDescription("\u70b9\u8d5e");
            this.mForwardView.setContentDescription("\u8f6c\u53d1");
            this.mCommentView.setContentDescription("\u8bc4\u8bba");
            businessFeedData.isRecommendFeed();
        }
        if (businessFeedData.isAdFeeds()) {
            this.mOperationContainer.setOnClickListener(this);
        } else {
            this.mOperationContainer.setOnClickListener(null);
            this.mOperationContainer.setClickable(false);
        }
        if (com.qzone.adapter.feedcomponent.i.H().S0() && businessFeedData.getRecommAction() != null && !TextUtils.isEmpty(businessFeedData.getRecommAction().interact_left_text)) {
            this.visitView.setContentDescription(businessFeedData.getRecommAction().interact_left_text);
        }
        if (businessFeedData.isNewAdvStyle() && businessFeedData.getRecommAction() != null && !hasFriendLikedCountData()) {
            this.visitView.setVisibility(8);
        } else {
            this.visitView.setVisibility(0);
        }
        if (this.isRecommendFeed && !RECOMMEND_FEED_SHOW_ATTACH_VIEW) {
            FeedViewSection.setViewGone(this.mAttachView);
        } else {
            CanvasAttachView canvasAttachView2 = this.mAttachView;
            if (canvasAttachView2 != null) {
                canvasAttachView2.setFeedData(businessFeedData);
            }
            FeedViewSection.setViewVisbile(this.mAttachView);
        }
        this.mOperationContainer.setPadding(ViewUtils.dpToPx(8.0f), 0, ViewUtils.dpToPx(8.0f), 0);
        this.mPraiseCountView.setPadding(0, 0, 0, 0);
        this.mCommentCountView.setPadding(0, 0, 0, 0);
        this.mForwardCountView.setPadding(0, 0, 0, 0);
        if (this.isRecommendFeed) {
            this.mPraiseCountView.setTextColor(-16777216);
            this.mCommentCountView.setTextColor(-16777216);
            this.mForwardCountView.setTextColor(-16777216);
        } else if (com.qzone.adapter.feedcomponent.i.H().p1()) {
            this.mPraiseCountView.setTextColor(com.qzone.adapter.feedcomponent.j.F());
            this.mCommentCountView.setTextColor(com.qzone.adapter.feedcomponent.j.F());
            this.mForwardCountView.setTextColor(com.qzone.adapter.feedcomponent.j.F());
        } else {
            this.mPraiseCountView.setTextColor(-16777216);
            this.mCommentCountView.setTextColor(-16777216);
            this.mForwardCountView.setTextColor(-16777216);
        }
        updateOperationLine(businessFeedData);
        if (!hasFriendLikedCountData() && (cellDecorateInfo = businessFeedData.cellDecorateInfo) != null && cellDecorateInfo.cellPrdData != null && (cellVisitorInfo2 = this.mVisitorInfo) != null && cellVisitorInfo2.viewCount > 0 && com.qzone.personalize.business.b.n().d()) {
            CellDecorateInfo.CellPrdData cellPrdData = businessFeedData.cellDecorateInfo.cellPrdData;
            int i3 = cellPrdData.iType;
            this.mVisitorDecoShowType = i3;
            if (i3 == 0) {
                this.mCustomBrowserInfoImage.setAsyncImage(cellPrdData.strResUrl);
            } else {
                QzoneZipAnimateUtil.j(cellPrdData.strResUrl, VISITOR_BUSINESS_TYPE, cellPrdData.strResUrl.hashCode() + "", ViewUtils.dpToPx(16.0f), ViewUtils.dpToPx(16.0f), 100, new AnonymousClass1());
            }
            try {
                this.mCustomBrowserInfoText.getPaint().setShader(new LinearGradient(0.0f, 0.0f, 0.0f, ViewUtils.dpToPx(20.0f), new int[]{Color.parseColor(cellPrdData.strColorBegin), Color.parseColor(cellPrdData.strColorEnd)}, (float[]) null, Shader.TileMode.CLAMP));
            } catch (Exception e16) {
                com.qzone.proxy.feedcomponent.b.c(TAG, e16.toString());
            }
            this.mCustomBrowserInfoText.setText(this.mVisitorInfo.visitorDecoDisplayStr);
            this.mCustomBrowserInfoText.setContentDescription(this.mVisitorInfo.visitorDecoDisplayStr);
            this.mCustomBrowserInfoImage.setContentDescription(this.mVisitorInfo.visitorDecoDisplayStr);
            this.mCustomBrowserInfoImage.setVisibility(0);
            this.mCustomBrowserInfoText.setVisibility(0);
            this.visitView.setVisibility(8);
            if (com.qzone.proxy.feedcomponent.util.d.j(businessFeedData.getFeedCommInfo().operatemask3, 6) && (cellVisitorInfo3 = this.mVisitorInfo) != null && !TextUtils.isEmpty(cellVisitorInfo3.visitorDecoDisplayStr)) {
                this.mInteractTagContainer.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = this.mInteractTagContainer.getLayoutParams();
                if (layoutParams instanceof RelativeLayout.LayoutParams) {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                    layoutParams2.addRule(1, com.qzone.adapter.feedcomponent.j.O(2788));
                    layoutParams2.addRule(6, com.qzone.adapter.feedcomponent.j.O(2788));
                    layoutParams2.topMargin = AreaConst.f48746dp1;
                    this.mInteractTagContainer.setLayoutParams(layoutParams2);
                    return;
                }
                return;
            }
            this.mInteractTagContainer.setVisibility(8);
            return;
        }
        this.mCustomBrowserInfoText.setVisibility(8);
        this.mCustomBrowserInfoImage.setVisibility(8);
        if (com.qzone.proxy.feedcomponent.util.d.j(businessFeedData.getFeedCommInfo().operatemask3, 6) && (cellVisitorInfo = this.mVisitorInfo) != null && !TextUtils.isEmpty(cellVisitorInfo.displayStr)) {
            this.mInteractTagContainer.setVisibility(0);
            ViewGroup.LayoutParams layoutParams3 = this.mInteractTagContainer.getLayoutParams();
            if (layoutParams3 instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) layoutParams3;
                layoutParams4.addRule(1, com.qzone.adapter.feedcomponent.j.O(2331));
                layoutParams4.addRule(6, com.qzone.adapter.feedcomponent.j.O(2331));
                layoutParams4.topMargin = 0;
                this.mInteractTagContainer.setLayoutParams(layoutParams4);
                return;
            }
            return;
        }
        this.mInteractTagContainer.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean updateOperation(BusinessFeedData businessFeedData) {
        if (businessFeedData == null) {
            return false;
        }
        if ((this.canPraise || this.canComment || this.canForward) && !this.isPicUpLayout && !businessFeedData.isAlbumRecFeed() && !businessFeedData.isPublicAccountContent() && !businessFeedData.isQCircleRecommFeed()) {
            FeedViewSection.setViewVisbile(this.mOperationContainer);
            updateOperationButtonBackgroud();
            FeedViewSection.setVisibility(0, this.mPraiseView);
            if (businessFeedData.getLikeInfo().stateChanged) {
                this.mPraiseView.setSelected(this.hasPraised);
                if (this.hasPraised) {
                    if (hasPolymorphicPraise(businessFeedData)) {
                        this.mPraiseView.setAsyncImage(businessFeedData.getCellDecorateInfo().cellPolymorphicPraise.strPraisePic);
                    } else if (needBirthdayRes(businessFeedData)) {
                        QzoneCustomPraiseService.i().b(null, this.mPraiseView, businessFeedData.getUser().customPraiseData);
                    } else if (hasCustomPraise(businessFeedData)) {
                        this.mPraiseView.setAsyncImage(businessFeedData.getCellDecorateInfo().cellCustomPraise.strPraiseButton);
                    } else {
                        this.mPraiseView.setImageDrawable(this.defaultLikeDrawable);
                    }
                } else if (businessFeedData.getUser().customPraiseData != null && businessFeedData.getUser().customPraiseData.itemId > 0) {
                    this.mPraiseView.setAsyncImage(businessFeedData.getUser().customPraiseData.strPraisePicBefore);
                } else {
                    this.mPraiseView.setImageDrawable(this.defaultLikeDrawable);
                }
            }
            boolean z16 = this.fakeType != 0;
            this.mPraiseView.setEnabled(z16);
            if (this.mCommentView.getVisibility() == 8) {
                FeedViewSection.setVisibility(0, this.mCommentView);
            }
            this.mCommentView.setEnabled(z16);
            this.mForwardView.setEnabled(z16);
            this.mRecommendView.setEnabled(z16);
            this.mRecommendView.setSelected(businessFeedData.getCellRecommendListSafe().isRecommended);
            if (businessFeedData.getFeedCommInfo().isShowFeedRecommend() && businessFeedData.feedType != 2) {
                FeedViewSection.setViewVisbile(this.mForwardContainer);
                this.mCommentView.setImageDrawable(this.commentDrawable);
                this.mForwardView.setImageDrawable(this.forwardDrawable);
                setPraiseCountInfo(businessFeedData.getLikeInfoV2());
                setCommentCountInfo(businessFeedData.getCommentInfoV2());
                setForwardCountInfo(businessFeedData.getCellForwardInfo());
                FeedViewSection.setViewVisbile(this.mRecommendContainer);
            } else {
                FeedViewSection.setViewVisbile(this.mForwardContainer);
                this.mCommentView.setImageDrawable(this.commentDrawable);
                this.mForwardView.setImageDrawable(this.forwardDrawable);
                setPraiseCountInfo(null);
                setCommentCountInfo(null);
                setForwardCountInfo(null);
                FeedViewSection.setViewGone(this.mRecommendContainer);
            }
            if (this.mRecommendContainer.getVisibility() != 0) {
                ViewGroup.LayoutParams layoutParams = this.mForwardContainer.getLayoutParams();
                if (layoutParams.width != -2) {
                    layoutParams.width = -2;
                    this.mForwardContainer.setLayoutParams(layoutParams);
                }
            } else {
                ViewGroup.LayoutParams layoutParams2 = this.mForwardContainer.getLayoutParams();
                int i3 = layoutParams2.width;
                int i16 = AreaConst.dp58;
                if (i3 != i16) {
                    layoutParams2.width = i16;
                    this.mForwardContainer.setLayoutParams(layoutParams2);
                }
            }
            if (this.mForwardContainer.getVisibility() != 0) {
                ViewGroup.LayoutParams layoutParams3 = this.mCommentContainer.getLayoutParams();
                if (layoutParams3.width != -2) {
                    layoutParams3.width = -2;
                    this.mCommentContainer.setLayoutParams(layoutParams3);
                }
            } else {
                ViewGroup.LayoutParams layoutParams4 = this.mCommentContainer.getLayoutParams();
                int i17 = layoutParams4.width;
                int i18 = AreaConst.dp58;
                if (i17 != i18) {
                    layoutParams4.width = i18;
                    this.mCommentContainer.setLayoutParams(layoutParams4);
                }
            }
            updateOperationLine(businessFeedData);
            if (businessFeedData.isSubFeed) {
                RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) this.mCommentView.getLayoutParams();
                if (layoutParams5 != null) {
                    int i19 = AreaConst.dp14;
                    layoutParams5.rightMargin = i19;
                    layoutParams5.leftMargin = i19;
                    this.mCommentView.setLayoutParams(layoutParams5);
                }
                LinearLayout.LayoutParams layoutParams6 = (LinearLayout.LayoutParams) this.mOperationContainer.getLayoutParams();
                if (layoutParams6 != null) {
                    layoutParams6.topMargin = 0;
                    this.mOperationContainer.setLayoutParams(layoutParams6);
                }
            }
            return true;
        }
        FeedViewSection.setViewGone(this.mOperationContainer);
        FeedViewSection.setViewGone(this.operationLine);
        FeedViewSection.setViewGone(this.operationPlaceHolder);
        return false;
    }

    public FeedOperation(Context context, View view, Object obj) {
        super(context, view, obj);
        this.hasPraisedStr = "";
        this.notPraisedStr = "";
        this.showPresentView = true;
        this.mTrans = 255;
        this.mUiHandler = new Handler(Looper.getMainLooper());
        this.mAnimationDrawableListener = new AnimationDrawableLoadedListener() { // from class: com.qzone.module.feedcomponent.ui.FeedOperation.2
            @Override // cooperation.qzone.zipanimate.AnimationDrawableLoadedListener
            public void onLoadedSuccess(AnimationDrawable animationDrawable) {
                FeedOperation.this.setVisitorDecoImageWithAnimationDrawable(animationDrawable);
                super.onLoadedSuccess(animationDrawable);
            }
        };
        this.onPolyPraiseListener = new AlarmTask.OnAlarmListener() { // from class: com.qzone.module.feedcomponent.ui.FeedOperation.4
            @Override // com.qzone.module.feedcomponent.util.AlarmTask.OnAlarmListener
            public void onAlarm(AlarmTask alarmTask) {
                if (FeedOperation.this.needShowPolyPraise()) {
                    FeedOperation.this.showPolyPraise();
                }
            }
        };
        this.onForwardGuideListener = new AlarmTask.OnAlarmListener() { // from class: com.qzone.module.feedcomponent.ui.FeedOperation.5
            @Override // com.qzone.module.feedcomponent.util.AlarmTask.OnAlarmListener
            public void onAlarm(AlarmTask alarmTask) {
                int[] iArr = new int[2];
                FeedOperation.this.mForwardView.getLocationOnScreen(iArr);
                FeedOperation feedOperation = FeedOperation.this;
                if (feedOperation.canShowForwardGuide(feedOperation.mForwardView, iArr, feedOperation.feedData)) {
                    PopupText popupText = new PopupText(FeedOperation.this.getContext(), "\u5206\u4eab\u642c\u5bb6\u5230\u8fd9\u91cc\u5566~", 1000);
                    int height = FeedOperation.this.mForwardView.getHeight();
                    int screenWidth = ((ViewUtils.getScreenWidth() - iArr[0]) - FeedOperation.this.mForwardView.getWidth()) / 2;
                    if (popupText.b() != null) {
                        screenWidth = (popupText.b().getMeasuredWidth() - FeedOperation.this.mForwardView.getWidth()) + AreaManager.f48752dp3;
                        height += popupText.b().getMeasuredHeight();
                    }
                    popupText.e(FeedOperation.this.mForwardView, -screenWidth, -height, true, true, com.qzone.adapter.feedcomponent.h.b("QZoneSetting", "forwardDisplayTime", 10000));
                }
            }
        };
        if (view != null) {
            if (this.mAttachView == null) {
                CanvasAttachView canvasAttachView = (CanvasAttachView) view.findViewById(com.qzone.adapter.feedcomponent.j.O(2191));
                this.mAttachView = canvasAttachView;
                canvasAttachView.setLayoutParams(generateLayoutParams());
            }
            if (this.mOperationContainer == null) {
                ViewGroup viewGroup = (ViewGroup) view.findViewById(com.qzone.adapter.feedcomponent.j.O(2187));
                this.mOperationContainer = viewGroup;
                this.mPraiseView = (SuperLikeView) viewGroup.findViewById(com.qzone.adapter.feedcomponent.j.O(2188));
                this.mLikeContainer = this.mOperationContainer.findViewById(com.qzone.adapter.feedcomponent.j.O(2917));
                this.mCommentContainer = this.mOperationContainer.findViewById(com.qzone.adapter.feedcomponent.j.O(2791));
                this.mCommentView = (ImageView) this.mOperationContainer.findViewById(com.qzone.adapter.feedcomponent.j.O(2189));
                this.mForwardView = (ImageView) this.mOperationContainer.findViewById(com.qzone.adapter.feedcomponent.j.O(2190));
                this.mForwardContainer = this.mOperationContainer.findViewById(com.qzone.adapter.feedcomponent.j.O(2790));
                this.mRecommendContainer = this.mOperationContainer.findViewById(com.qzone.adapter.feedcomponent.j.O(2860));
                this.mRecommendView = (ImageView) this.mOperationContainer.findViewById(com.qzone.adapter.feedcomponent.j.O(2861));
                this.mPriaseGuideView = (ImageView) this.mOperationContainer.findViewById(com.qzone.adapter.feedcomponent.j.O(2473));
                this.mPraiseCountView = (TextView) this.mOperationContainer.findViewById(com.qzone.adapter.feedcomponent.j.O(2725));
                this.mCommentCountView = (TextView) this.mOperationContainer.findViewById(com.qzone.adapter.feedcomponent.j.O(2726));
                this.mForwardCountView = (TextView) this.mOperationContainer.findViewById(com.qzone.adapter.feedcomponent.j.O(2727));
                this.visitView = (VisitView) this.mOperationContainer.findViewById(com.qzone.adapter.feedcomponent.j.O(2331));
                this.mCustomBrowserInfoImage = (AsyncImageView) this.mOperationContainer.findViewById(com.qzone.adapter.feedcomponent.j.O(2786));
                this.mCustomBrowserInfoText = (TextView) this.mOperationContainer.findViewById(com.qzone.adapter.feedcomponent.j.O(2788));
                this.mInteractTagContainer = this.mOperationContainer.findViewById(com.qzone.adapter.feedcomponent.j.O(2867));
                this.mInteractTagText = (CellTextView) this.mOperationContainer.findViewById(com.qzone.adapter.feedcomponent.j.O(2868));
                this.operationLine = this.mOperationContainer.findViewById(com.qzone.adapter.feedcomponent.j.O(2332));
                this.operationPlaceHolder = this.mOperationContainer.findViewById(com.qzone.adapter.feedcomponent.j.O(2333));
                this.mPraiseView.setOnClickListener(this);
                this.mLikeContainer.setOnClickListener(this);
                this.mCommentView.setOnClickListener(this);
                this.mCommentContainer.setOnClickListener(this);
                this.mForwardView.setOnClickListener(this);
                this.mForwardContainer.setOnClickListener(this);
                this.mRecommendView.setOnClickListener(this);
                this.mForwardView.setOnLongClickListener(this);
                this.mCommentView.setOnLongClickListener(this);
                TextView textView = this.mCustomBrowserInfoText;
                if (textView != null) {
                    textView.setOnClickListener(this);
                }
                CellTextView cellTextView = this.mInteractTagText;
                if (cellTextView != null) {
                    cellTextView.setOnClickListener(this);
                }
                this.defaultLikeDrawable = this.mPraiseView.getDrawable();
                this.mPraiseView.setOnEventBack(new OnEventBack());
            }
        }
        init();
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    protected void attachViewForRootContainer(View view) {
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    public void onStateIdle() {
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    public void onStateScrolling() {
    }

    public void setAdvButtonAnimationListener(com.qzone.proxy.feedcomponent.ui.f fVar) {
    }

    public void setPermissionInfo(CellPermissionInfo cellPermissionInfo) {
    }
}
