package com.qzone.module.feedcomponent.ui;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.TabActivity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import ch.l;
import com.qzone.commoncode.module.gdt.GdtFeedUtilForQZone;
import com.qzone.feed.gift.widget.FeedGiftLayout;
import com.qzone.feed.panorama.PanoramaLayout;
import com.qzone.feed.utils.AlbumRecReporter;
import com.qzone.module.feedcomponent.FeedUtil;
import com.qzone.module.feedcomponent.base.FeedViewSectionManager;
import com.qzone.module.feedcomponent.ui.FeedViewSection;
import com.qzone.module.feedcomponent.ui.canvasui.CampusShardCardView;
import com.qzone.module.feedcomponent.ui.canvasui.CanvasAttachView;
import com.qzone.module.feedcomponent.ui.canvasui.CanvasFeedContentView;
import com.qzone.module.feedcomponent.ui.canvasui.CanvasFeedDrawerView;
import com.qzone.module.feedcomponent.ui.canvasui.CanvasLeftThumbView;
import com.qzone.module.feedcomponent.ui.canvasui.CanvasQCircleTailView;
import com.qzone.module.feedcomponent.ui.canvasui.CanvasQzoneCardView;
import com.qzone.module.feedcomponent.ui.canvasui.CanvasRecommAction;
import com.qzone.module.feedcomponent.ui.canvasui.CanvasRecommActionNonAd;
import com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleView;
import com.qzone.module.feedcomponent.util.CardUtils;
import com.qzone.module.feedcomponent.util.GdtCanvasTestUtil;
import com.qzone.module.feedcomponent.util.SimpleModelUtils;
import com.qzone.personalize.business.FeedSkinData;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.ViewSectionType;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellFeedCommInfo;
import com.qzone.proxy.feedcomponent.model.CellPicTextInfo;
import com.qzone.proxy.feedcomponent.model.FeedPictureInfo;
import com.qzone.proxy.feedcomponent.model.PicText;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.qzone.proxy.feedcomponent.model.gdt.GdtAdFeedUtil;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdFeedData;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdFeedDataExtKt;
import com.qzone.proxy.feedcomponent.model.gdt.reporter.GdtCrossAdReporterForQzone;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.qzone.proxy.feedcomponent.util.QzoneZipCacheHelper;
import com.qzone.proxy.feedcomponent.widget.FeedDate;
import com.tencent.ad.tangram.util.AdExposureChecker;
import com.tencent.ad.tangram.views.floattips.AdFloatTipsViewContainer;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.image.ImageUrl;
import com.tencent.ditto.shell.DittoUIEngine;
import com.tencent.gdtad.views.crossad.GdtCrossView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qzoneplayer.video.BaseVideoManager;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.mobileqq.vas.apng.api.IVasSharpPFactoryForQzone;
import com.tencent.mobileqq.vas.ui.APNGDrawable;
import com.tencent.mobileqq.vas.ui.IDynamicDrawable;
import com.tencent.mobileqq.vashealth.api.impl.QQHealthReportApiImpl;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqnt.kernel.nativeinterface.JsonGrayBusiId;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.zipanimate.ZipDrawableLoader;
import java.io.File;
import java.io.FileFilter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mqq.app.Foreground;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FeedView extends NormalAbsFeedView {
    static final int LIVE_ROOM_STATUS_LIVE = 1;
    static final int SWIPE_THRESHOLD = 100;
    static final int SWIPE_VELOCITY_THRESHOLD = 100;
    private static final String TAG = "CF-FEED_VIEW";
    public static ImageUrl backgroundImageUrl = null;
    private static Drawable coupleFeedBackgroundDrawablePart2 = null;
    public static ImageUrl detailBackgroundImageUrl = null;
    private static Drawable detailCoupleFeedBackgroundDrawablePart2 = null;
    public static boolean isIdle = true;
    static boolean mHasSetTrans = false;
    static com.qzone.proxy.feedcomponent.ui.i mOnFeedFirstDrawListener = null;
    public static final float sLuxuryFeedSkinHightRatio = 0.37333333f;
    private ValueAnimator animator;
    View.OnClickListener blankListener;
    protected GestureDetector gestureDetector;
    public boolean hasHeader;
    private boolean isFriendLikeContainer;
    private final int labelAdStyle;
    private final int labelAdStyleKey;
    private FeedViewSection lastSection;
    private final int logoAndNickAdStyle;
    private l lvTenStaticDrawable;
    private Drawable mBackgroundDrawablePart2;
    CampusShardCardView mCampusShardCardView;
    boolean mCanShowDate;
    boolean mCanShowSeparator;
    CanvasFeedDrawerView mCanvasDrawerView;
    CanvasQzoneCardView mCardView;
    protected final Context mContext;
    FeedCommonSection mDateHeaderSection;
    FeedFamousRecommView mFamousRecommView;
    FeedAppShareCardViewSection mFeedAppShareCardView;
    FeedBottomGuideView mFeedBottomGuideView;
    FeedCanvasAdRecommAction mFeedCanvasRecommAction;
    protected FeedComment mFeedComment;
    protected FeedContent mFeedContent;
    FeedDate mFeedDate;
    FeedDateHeader mFeedDateHeader;
    FeedFollowGuideView mFeedFollowGuideView;
    protected FeedForward mFeedForward;
    FeedFriendBirthdayGiftPanel mFeedFriendBirthdayGiftPanel;
    FeedGoods mFeedGoods;
    FeedHandBlogSection mFeedHandBlogForwardSection;
    FeedHandBlogSection mFeedHandBlogSection;
    FeedInterest mFeedInterest;
    protected FeedOperation mFeedOperation;
    FeedPicTextCardView mFeedPicTextCardView;
    protected int mFeedPosition;
    CanvasRecommAction mFeedRecommAction;
    FeedRecommHeader mFeedRecommHeader;
    protected ViewStub mFeedRecommVideoStub;
    FeedRecommendFriendsHorizontalCardView mFeedRecommendFriendsHorizontalCardView;
    FeedScrollContainerArea mFeedScrollContainerArea;
    FeedSearchNoResultTip mFeedSearchNoResultTip;
    FeedSearchSeparator mFeedSearchSeparator;
    protected SparseArray<FeedViewSection> mFeedSections;
    FeedSeparator mFeedSeparator;
    private Paint mFeedSkinBgPaint;
    private Drawable mFeedSkinDrawable;
    private String mFeedSkinDrawableUrl;
    private boolean mFeedSkinDrawed;
    private int mFeedSkinGradientColorBg;
    private int mFeedSkinGradientColorEnd;
    private int mFeedSkinGradientColorStart;
    private Paint mFeedSkinGradientPaint;
    FeedSpecialCare mFeedSpecialCare;
    FeedSuggestMoreViewB mFeedSuggestMoreViewB;
    FeedTitle mFeedTitle;
    FeedTitleForward mFeedTitleForward;
    FeedTopHeader mFeedTopHeader;
    protected com.qzone.proxy.feedcomponent.ui.j mFeedViewPauseListener;
    Paint mFrameLinePaint;
    private GdtCrossView.Params mGdtCrossAdParams;
    private GdtCrossView mGdtCrossView;
    private AdExposureChecker.ExposureCallback mGdtExposureCallback;
    private AdExposureChecker mGdtExposureChecker;
    protected h6.a mGdtFeedCarouselCard;
    protected h6.a mGdtFeedDescription;
    FeedHorizontalListView mHorizontalListView;
    boolean mIsTodayInHistoryDetail;
    private final int[] mLocation;
    private int mLuxuryFeedSkinHeight;
    private String mLuxuryFeedSkinPath;
    private String mLv10FeedSkinPath;
    private int mLvTenHeight;
    private int mLvTenWidth;
    protected com.qzone.proxy.feedcomponent.ui.g mOnFeedElementClickListener;
    protected com.qzone.proxy.feedcomponent.ui.h mOnFeedEventListener;
    private FeedViewSection.FeedViewOptions mOptions;
    FeedPlayBarView mPlayBarView;
    CanvasPresentInfoView mPresentInfoView;
    boolean mShowDateHeader;
    boolean mShowFrameLine;
    boolean mShowSearchNoResultTip;
    private Drawable mTopDrawable;
    int mTrans;
    private final Handler mUiHandler;
    boolean misPicTop;
    boolean needBackground;
    GestureDetector.OnGestureListener onGestureListener;
    Rect part1Bound;
    Rect part2Bound;
    private Paint shadowPaint;
    public static Drawable mBackgroundDrawablePart1 = new ColorDrawable(com.qzone.adapter.feedcomponent.j.s());
    public static int sFeedSkinGradientHeight = ViewUtils.dpToPx(200.0f);
    public static int sFeedSkinImageHeight = ViewUtils.dpToPx(75.0f);
    public static Drawable mBackgroundDrawableForward = new ColorDrawable(com.qzone.adapter.feedcomponent.j.q());
    private static final int[] mKuolieFeedBottomLineBackgroundColorArray = {-13900833, -37464, -12331403, -5544982};
    public static String detailBackgroundUrl = com.qzone.adapter.feedcomponent.h.c("QZoneSetting", "coupleFeedDetailBackgroundImageUrl", "https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/feed_couple_detail_bg.9.png");
    public static String backgroundUrl = com.qzone.adapter.feedcomponent.h.c("QZoneSetting", "coupleFeedBackgroundImageUrl", "https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/feed_couple_bg_img.9.png");

    public FeedView(Context context, boolean z16) {
        super(context);
        this.logoAndNickAdStyle = 2;
        this.labelAdStyle = 3;
        this.labelAdStyleKey = 23;
        this.mTrans = 255;
        this.mBackgroundDrawablePart2 = new ColorDrawable(com.qzone.adapter.feedcomponent.j.m());
        this.mFeedSkinDrawableUrl = null;
        this.mFeedSkinDrawable = null;
        this.mLuxuryFeedSkinHeight = 0;
        this.mLvTenHeight = 0;
        this.mLvTenWidth = 0;
        this.mLuxuryFeedSkinPath = "";
        this.mLv10FeedSkinPath = "";
        this.isFriendLikeContainer = false;
        this.mFeedSections = new SparseArray<>();
        this.mFeedSkinDrawed = false;
        this.mTopDrawable = null;
        this.mUiHandler = new Handler(Looper.getMainLooper());
        this.mLocation = new int[2];
        this.needBackground = true;
        this.part1Bound = new Rect();
        this.part2Bound = new Rect();
        this.blankListener = new View.OnClickListener() { // from class: com.qzone.module.feedcomponent.ui.FeedView.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                FeedView feedView = FeedView.this;
                com.qzone.proxy.feedcomponent.ui.g gVar = feedView.mOnFeedElementClickListener;
                if (gVar != null) {
                    FeedElement feedElement = FeedElement.NOTHING;
                    int i3 = feedView.mFeedPosition;
                    gVar.onClick(feedView, feedElement, i3, Integer.valueOf(i3));
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        };
        this.onGestureListener = new GestureDetector.OnGestureListener() { // from class: com.qzone.module.feedcomponent.ui.FeedView.11
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
                if (motionEvent != null && motionEvent2 != null) {
                    float x16 = motionEvent2.getX() - motionEvent.getX();
                    if (Math.abs(x16) * 0.25d > Math.abs(motionEvent2.getY() - motionEvent.getY()) && Math.abs(x16) > 100.0f && Math.abs(f16) > 100.0f && x16 > 0.0f) {
                        return FeedView.this.getParent() == null || !(FeedView.this.getParent() instanceof TabActivity);
                    }
                }
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onShowPress(MotionEvent motionEvent) {
            }
        };
        this.mContext = context;
        this.mCanShowDate = z16;
        setOrientation(1);
        setId(com.qzone.adapter.feedcomponent.j.O(2184));
        setDescendantFocusability(393216);
        this.mFeedSkinBgPaint = new Paint();
        this.mFeedSkinGradientPaint = new Paint();
        setDrawingCacheEnabled(false);
        setPadding(0, 0, 0, AreaConst.AREA_VERTICAL_MARGIN);
        setWillNotDraw(false);
        setOnClickListener(this.blankListener);
        if (FeedGlobalEnv.g().isDebug()) {
            setOnLongClickListener(new View.OnLongClickListener() { // from class: com.qzone.module.feedcomponent.ui.FeedView.1
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    EventCollector.getInstance().onViewLongClickedBefore(view);
                    FeedView feedView = FeedView.this;
                    com.qzone.proxy.feedcomponent.ui.g gVar = feedView.mOnFeedElementClickListener;
                    if (gVar != null) {
                        gVar.onClick(feedView, FeedElement.Debug, feedView.mFeedPosition, null);
                    }
                    EventCollector.getInstance().onViewLongClicked(view);
                    return false;
                }
            });
        }
        initUI(getContext());
    }

    private void attachGdtExposureChecker() {
        AdExposureChecker adExposureChecker = new AdExposureChecker(GdtFeedUtilForQZone.E(this.mFeedData), new WeakReference(this));
        final WeakReference weakReference = new WeakReference(this);
        this.mGdtExposureCallback = new AdExposureChecker.ExposureCallback() { // from class: com.qzone.module.feedcomponent.ui.b
            @Override // com.tencent.ad.tangram.util.AdExposureChecker.ExposureCallback
            public final void onExposure(WeakReference weakReference2) {
                FeedView.lambda$attachGdtExposureChecker$0(weakReference, weakReference2);
            }
        };
        adExposureChecker.setCallback(new WeakReference<>(this.mGdtExposureCallback));
        adExposureChecker.startCheck();
        this.mGdtExposureChecker = adExposureChecker;
    }

    private void checkMsgReport() {
        BusinessFeedData businessFeedData;
        CellFeedCommInfo cellFeedCommInfo;
        Map<String, String> map;
        if (!na.c.f419539a.e() || (businessFeedData = this.mFeedData) == null || (cellFeedCommInfo = businessFeedData.cellFeedCommInfo) == null || (map = cellFeedCommInfo.extendInfo) == null) {
            return;
        }
        String str = map.get(QQHealthReportApiImpl.MSG_TYPE_KEY);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        RFWLog.d(TAG, RFWLog.USR, "checkMsgReport imp: " + str);
        HashMap hashMap = new HashMap();
        hashMap.put("trigger_reason", str);
        fo.b l3 = new fo.b().l(hashMap);
        l3.k(ExposurePolicy.REPORT_FIRST);
        l3.i(ef.b.a(this.mFeedData));
        fo.c.b("dt_imp", this, "em_qz_msg", l3);
    }

    private void drawFeedSkin(Canvas canvas) {
        l lVar;
        BusinessFeedData businessFeedData;
        BusinessFeedData businessFeedData2;
        if (this.mFeedSkinDrawable != null && com.qzone.adapter.feedcomponent.i.H().d1() && (!com.qzone.adapter.feedcomponent.i.H().p1() || canShowSpecialFeedSkin())) {
            canvas.saveLayerAlpha(0.0f, 0.0f, getWidth(), getHeight(), this.mTrans, 31);
            int feedBackgroundPart1Height = getFeedBackgroundPart1Height();
            if (this.mShowDateHeader && this.mFeedDateHeader != null && !this.mDateHeaderSection.isEmpty()) {
                FeedSearchNoResultTip feedSearchNoResultTip = getFeedSearchNoResultTip();
                BusinessFeedData businessFeedData3 = this.mFeedData;
                if (businessFeedData3 != null && businessFeedData3.isNeedShowSearchNoResultTip() && feedSearchNoResultTip != null) {
                    feedBackgroundPart1Height += feedSearchNoResultTip.getMeasuredHeight();
                }
                feedBackgroundPart1Height += this.mFeedDateHeader.getMeasuredHeight();
            }
            FeedTopHeader feedTopHeader = this.mFeedTopHeader;
            if (feedTopHeader != null && feedTopHeader.hasUsed() && (businessFeedData2 = this.mFeedData) != null && businessFeedData2.feedType == 3) {
                feedBackgroundPart1Height = (feedBackgroundPart1Height + this.mFeedTopHeader.getMeasuredHeight()) - getFeedBackgroundPart1Height();
            }
            FeedViewSection section = getSection(5);
            if (section != null && section.getView() != null && (section.getView() instanceof View)) {
                feedBackgroundPart1Height = ((View) section.getView()).getMeasuredHeight();
            }
            canvas.drawRect(0.0f, feedBackgroundPart1Height, getWidth(), sFeedSkinGradientHeight + feedBackgroundPart1Height, this.mFeedSkinGradientPaint);
            canvas.drawRect(0.0f, sFeedSkinGradientHeight + feedBackgroundPart1Height, getWidth(), getHeight(), this.mFeedSkinBgPaint);
            if (canShowSpecialFeedSkin()) {
                if (!TextUtils.isEmpty(this.mLv10FeedSkinPath)) {
                    if (this.mLvTenHeight == 0) {
                        updateLvTenHeight();
                    }
                    this.mFeedSkinDrawable.setBounds(getWidth() - this.mLvTenWidth, feedBackgroundPart1Height, getWidth(), this.mLvTenHeight + feedBackgroundPart1Height);
                } else {
                    this.mFeedSkinDrawable.setBounds(0, feedBackgroundPart1Height, getWidth(), this.mLuxuryFeedSkinHeight + feedBackgroundPart1Height);
                }
            } else {
                this.mFeedSkinDrawable.setBounds(0, feedBackgroundPart1Height, getWidth(), sFeedSkinImageHeight + feedBackgroundPart1Height);
            }
            playLuxuryFeedsAnimation();
            this.mFeedSkinDrawable.draw(canvas);
            if (canShowSpecialFeedSkin() && !TextUtils.isEmpty(this.mLv10FeedSkinPath) && (lVar = this.lvTenStaticDrawable) != null && (businessFeedData = this.mFeedData) != null && businessFeedData.feedType != 2) {
                lVar.d(canvas);
            }
            canvas.restore();
            this.mFeedSkinDrawed = true;
            return;
        }
        this.mFeedSkinDrawed = false;
    }

    private int getAdVideoViewCenterPosition() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if ((childAt instanceof FeedVideoView) && childAt.getVisibility() == 0) {
                return (childAt.getBottom() + childAt.getTop()) / 2;
            }
        }
        return -1;
    }

    private h6.a getGdtCarouselCard() {
        if (this.mGdtFeedCarouselCard == null) {
            Object createViewSection = FeedGlobalEnv.g().createViewSection(ViewSectionType.GDT_CAROUSEL_CARD, this.mContext, this);
            if (createViewSection instanceof h6.a) {
                h6.a aVar = (h6.a) createViewSection;
                this.mGdtFeedCarouselCard = aVar;
                aVar.setFeedPosition(this.mFeedPosition);
                this.mGdtFeedCarouselCard.setOnFeedElementClickListener(this.mOnFeedElementClickListener);
            }
        }
        return this.mGdtFeedCarouselCard;
    }

    private FeedAutoVideo getGdtCarouselCardVideoView() {
        h6.a aVar;
        if (!GdtAdFeedUtil.isCarouselCard(this.mFeedData) || (aVar = this.mGdtFeedCarouselCard) == null) {
            return null;
        }
        return aVar.c();
    }

    private h6.a getGdtDescription() {
        if (this.mGdtFeedDescription == null) {
            Object createViewSection = FeedGlobalEnv.g().createViewSection(ViewSectionType.GDT_DESCRIPTION, this.mContext, this);
            if (createViewSection instanceof h6.a) {
                h6.a aVar = (h6.a) createViewSection;
                this.mGdtFeedDescription = aVar;
                aVar.setFeedPosition(this.mFeedPosition);
                this.mGdtFeedDescription.setOnFeedElementClickListener(this.mOnFeedElementClickListener);
            }
        }
        return this.mGdtFeedDescription;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$attachGdtExposureChecker$0(WeakReference weakReference, WeakReference weakReference2) {
        BusinessFeedData businessFeedData;
        FeedView feedView = (FeedView) weakReference.get();
        if (feedView == null || (businessFeedData = feedView.mFeedData) == null) {
            return;
        }
        QZLog.w(TAG, "[onExposure] " + businessFeedData.hashCode());
        GdtAdFeedUtil.doEffectiveExposureReport(businessFeedData, feedView.getMFeedPosition(), 0);
    }

    private void notifyGdtSectionOnPause() {
        h6.a aVar = this.mGdtFeedDescription;
        if (aVar != null) {
            aVar.onPause();
        }
        h6.a aVar2 = this.mGdtFeedCarouselCard;
        if (aVar2 != null) {
            aVar2.onPause();
        }
    }

    @Deprecated
    private void oldStateScrolling() {
        if (getFeedPanoramaView() != null) {
            BusinessFeedData businessFeedData = this.mFeedData;
            if (businessFeedData == null || businessFeedData.feedType != 2) {
                getFeedPanoramaView().y(0);
            }
        }
    }

    private void onDrawTopDrawable(Canvas canvas) {
        Drawable drawable = this.mTopDrawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = this.mTopDrawable.getIntrinsicHeight();
            if (intrinsicWidth == 0 || intrinsicHeight == 0) {
                return;
            }
            int height = canvas.getHeight();
            int width = height - ((canvas.getWidth() * intrinsicHeight) / intrinsicWidth);
            int adVideoViewCenterPosition = getAdVideoViewCenterPosition();
            if (adVideoViewCenterPosition > 0 && adVideoViewCenterPosition < intrinsicHeight) {
                int width2 = ((canvas.getWidth() * intrinsicHeight) / intrinsicWidth) / 2;
                width = adVideoViewCenterPosition - width2;
                height = adVideoViewCenterPosition + width2;
            }
            this.mTopDrawable.setBounds(0, width, canvas.getWidth(), height);
            this.mTopDrawable.draw(canvas);
        }
    }

    private void playLuxuryFeedsAnimation() {
        if (this.mFeedSkinDrawable == null) {
            return;
        }
        if (canShowSpecialFeedSkin()) {
            this.mFeedSkinDrawable.setCallback(new Drawable.Callback() { // from class: com.qzone.module.feedcomponent.ui.FeedView.2
                @Override // android.graphics.drawable.Drawable.Callback
                public void invalidateDrawable(Drawable drawable) {
                    if (FeedView.isIdle) {
                        FeedView.this.invalidate();
                    }
                }

                @Override // android.graphics.drawable.Drawable.Callback
                public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
                }

                @Override // android.graphics.drawable.Drawable.Callback
                public void scheduleDrawable(Drawable drawable, Runnable runnable, long j3) {
                }
            });
        } else {
            this.mFeedSkinDrawable.setCallback(null);
        }
        this.mFeedSkinDrawable.invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void recycleGdtCrossView() {
        GdtCrossView gdtCrossView = this.mGdtCrossView;
        if (gdtCrossView == null || gdtCrossView.getParent() == null) {
            return;
        }
        gdtCrossView.setVisibility(8);
        ((ViewGroup) gdtCrossView.getParent()).removeView(gdtCrossView);
        gdtCrossView.onRecycled();
        gdtCrossView.setTag(null);
    }

    @Deprecated
    private void resetExtraInvoke() {
        FeedDate feedDate = this.mFeedDate;
        if (feedDate != null) {
            feedDate.setUsed(false);
        }
        FeedDateHeader feedDateHeader = this.mFeedDateHeader;
        if (feedDateHeader != null) {
            feedDateHeader.setUsed(false);
        }
        FeedSearchNoResultTip feedSearchNoResultTip = this.mFeedSearchNoResultTip;
        if (feedSearchNoResultTip != null) {
            feedSearchNoResultTip.setUsed(false);
        }
        FeedRecommHeader feedRecommHeader = this.mFeedRecommHeader;
        if (feedRecommHeader != null) {
            feedRecommHeader.setUsed(false);
        }
        FeedScrollContainerArea feedScrollContainerArea = this.mFeedScrollContainerArea;
        if (feedScrollContainerArea != null) {
            feedScrollContainerArea.setUsed(false);
        }
        FeedHorizontalListView feedHorizontalListView = this.mHorizontalListView;
        if (feedHorizontalListView != null) {
            feedHorizontalListView.setUsed(false);
        }
        FeedGoods feedGoods = this.mFeedGoods;
        if (feedGoods != null) {
            feedGoods.setUsed(false);
        }
        FeedSpecialCare feedSpecialCare = this.mFeedSpecialCare;
        if (feedSpecialCare != null) {
            feedSpecialCare.setUsed(false);
        }
        FeedRecommendFriendsHorizontalCardView feedRecommendFriendsHorizontalCardView = this.mFeedRecommendFriendsHorizontalCardView;
        if (feedRecommendFriendsHorizontalCardView != null) {
            feedRecommendFriendsHorizontalCardView.setUsed(false);
        }
        FeedSeparator feedSeparator = this.mFeedSeparator;
        if (feedSeparator != null) {
            feedSeparator.setUsed(false);
        }
        FeedFamousRecommView feedFamousRecommView = this.mFamousRecommView;
        if (feedFamousRecommView != null) {
            feedFamousRecommView.setUsed(false);
        }
        FeedFriendBirthdayGiftPanel feedFriendBirthdayGiftPanel = this.mFeedFriendBirthdayGiftPanel;
        if (feedFriendBirthdayGiftPanel != null) {
            feedFriendBirthdayGiftPanel.setUsed(false);
        }
        FeedPicTextCardView feedPicTextCardView = this.mFeedPicTextCardView;
        if (feedPicTextCardView != null) {
            feedPicTextCardView.setUsed(false);
        }
        FeedCanvasAdRecommAction feedCanvasAdRecommAction = this.mFeedCanvasRecommAction;
        if (feedCanvasAdRecommAction != null) {
            feedCanvasAdRecommAction.setUsed(false);
        }
    }

    private void setCoupleBg() {
        boolean z16 = false;
        if (this.mFeedData.isCoupleFeed() && com.qzone.adapter.feedcomponent.h.b("QZoneSetting", "coupleFeedShowBackGround", 0) != 0) {
            z16 = true;
        }
        if (z16) {
            Drawable drawable = coupleFeedBackgroundDrawablePart2;
            if (drawable == null) {
                ImageLoader.Options obtain = ImageLoader.Options.obtain();
                obtain.extraProcessor = new com.qzone.widget.i(FeedGlobalEnv.g().getScreenWidth() / 720.0f);
                ImageLoader.getInstance(this.mContext).loadImageAsync(backgroundImageUrl, backgroundUrl, new ImageLoader.ImageLoadListener() { // from class: com.qzone.module.feedcomponent.ui.FeedView.7
                    @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
                    public void onImageLoaded(String str, Drawable drawable2, ImageLoader.Options options) {
                        FeedView.coupleFeedBackgroundDrawablePart2 = drawable2;
                        FeedView.this.mBackgroundDrawablePart2 = FeedView.coupleFeedBackgroundDrawablePart2;
                        FeedView.this.postInvalidate();
                    }

                    @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
                    public void onImageCanceled(String str, ImageLoader.Options options) {
                    }

                    @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
                    public void onImageFailed(String str, ImageLoader.Options options) {
                    }

                    @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
                    public void onImageProgress(String str, float f16, ImageLoader.Options options) {
                    }
                }, obtain);
                return;
            }
            this.mBackgroundDrawablePart2 = drawable;
            return;
        }
        Drawable maskImageDrawable = GdtAdFeedUtil.getMaskImageDrawable(this.mFeedData);
        if (maskImageDrawable != null) {
            com.qzone.adapter.feedcomponent.j.U(maskImageDrawable);
            this.mBackgroundDrawablePart2 = maskImageDrawable;
        } else {
            this.mBackgroundDrawablePart2 = new ColorDrawable(com.qzone.adapter.feedcomponent.j.m());
        }
    }

    private void setGdtCrossView() {
        if (this.mGdtCrossView == null) {
            this.mGdtCrossView = new GdtCrossView(getContext());
        }
        if (this.mGdtCrossAdParams == null) {
            this.mGdtCrossAdParams = new GdtCrossView.Params();
        }
    }

    public static final void setViewVisibility(View view, int i3) {
        if (view.getVisibility() != i3) {
            view.setVisibility(i3);
        }
    }

    private void setupAdFloatTipsView() {
        GdtAdFeedUtil.AdFloatTipsInfo[] adFloatTipsContainer = GdtAdFeedUtil.getAdFloatTipsContainer(this.mFeedData);
        if (adFloatTipsContainer.length == 0) {
            return;
        }
        AdFloatTipsViewContainer.Params params = null;
        AdFloatTipsViewContainer.Params params2 = null;
        for (GdtAdFeedUtil.AdFloatTipsInfo adFloatTipsInfo : adFloatTipsContainer) {
            AdFloatTipsViewContainer.Params params3 = new AdFloatTipsViewContainer.Params();
            params3.iconUrl = adFloatTipsInfo.iconUrl;
            params3.text = adFloatTipsInfo.text;
            int i3 = AreaConst.dp9;
            params3.iconSize = i3;
            params3.textSize = i3;
            params3.textColor = Color.parseColor("#FFB0B3BE");
            params3.backgroundColor = 0;
            int i16 = adFloatTipsInfo.type;
            if (i16 == 1) {
                params = params3;
            } else if (i16 != 2) {
                com.qzone.proxy.feedcomponent.b.e("FeedView-Gdt-Only", "[setupAdFloatTipsView] unsupported type=" + adFloatTipsInfo.type);
            } else {
                params2 = params3;
            }
        }
        setPadding(0, 0, 0, 0);
        AdFloatTipsViewContainer adFloatTipsViewContainer = new AdFloatTipsViewContainer(getContext(), params, params2);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        int i17 = AreaConst.dp8;
        int i18 = AreaConst.dp8_5;
        layoutParams.setMargins(i17, i18, i18, AreaConst.dp9);
        adFloatTipsViewContainer.setLayoutParams(layoutParams);
        View industrialView = adFloatTipsViewContainer.getIndustrialView();
        if (industrialView != null) {
            industrialView.setOnClickListener(null);
        }
        View industrialView2 = adFloatTipsViewContainer.getIndustrialView();
        if (industrialView2 != null) {
            industrialView2.setOnClickListener(null);
        }
        addView(adFloatTipsViewContainer);
        com.qzone.proxy.feedcomponent.b.e("FeedView-Gdt-Only", "[setupAdFloatTipsView] container is added");
    }

    private void setupPublicAccountContainerIfNeed() {
        BusinessFeedData businessFeedData = this.mFeedData;
        if (businessFeedData != null && businessFeedData.isPublicAccountContainer()) {
            FeedComment feedComment = this.mFeedComment;
            if (feedComment != null) {
                feedComment.setCommentViewVisibile(false);
                this.mFeedComment.setPraiseViewVisible(false);
                this.mFeedComment.setShowGuide(false);
            }
            FeedOperation feedOperation = this.mFeedOperation;
            if (feedOperation != null) {
                feedOperation.setOperationVisibility(8);
                this.mFeedOperation.setAttachVisibility(8);
            }
        }
    }

    private void updateGdtCrossView() {
        View feedContentView;
        if (!GdtAdFeedUtil.canShowCrossAd(this.mFeedData, this.mFeedPosition) || this.mGdtCrossAdParams == null || this.mFeedContent == null || this.mGdtCrossView == null) {
            return;
        }
        if (this.mFeedData.isVideo()) {
            feedContentView = this.mFeedContent.mAutoVideo;
        } else {
            feedContentView = getFeedContentView();
        }
        if (feedContentView == null) {
            return;
        }
        feedContentView.getLocationInWindow(this.mLocation);
        if (this.mGdtCrossView.getParent() == null) {
            Activity topActivity = Foreground.getTopActivity();
            Window window = topActivity != null ? topActivity.getWindow() : null;
            View decorView = window != null ? window.getDecorView() : null;
            if (decorView instanceof ViewGroup) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                layoutParams.topMargin = GdtFeedUtilForQZone.m();
                layoutParams.leftMargin = AreaConst.MARGIN_LEFT;
                layoutParams.rightMargin = AreaConst.MARGIN_RIGHT;
                this.mGdtCrossView.setLayoutParams(layoutParams);
                this.mGdtCrossView.setVisibility(4);
                ((ViewGroup) decorView).addView(this.mGdtCrossView);
            } else {
                recycleGdtCrossView();
                return;
            }
        }
        if (this.mGdtCrossView.getTag() == null) {
            GdtCrossView.Listener listener = new GdtCrossView.Listener() { // from class: com.qzone.module.feedcomponent.ui.FeedView.6
                @Override // com.tencent.gdtad.views.crossad.GdtCrossView.Listener
                public void onClosed() {
                    BusinessFeedData businessFeedData = FeedView.this.mFeedData;
                    if (businessFeedData != null) {
                        businessFeedData.getAdData().setGdtCrossAdClosed(true);
                    }
                    FeedView.this.recycleGdtCrossView();
                }

                @Override // com.tencent.gdtad.views.crossad.GdtCrossView.Listener
                public void onInteractionTriggered() {
                    GdtCrossAdReporterForQzone.reportForInteraction(FeedView.this.mFeedData);
                }

                @Override // com.tencent.gdtad.views.crossad.GdtCrossView.Listener
                public void onShowCrossViewFailed(int i3) {
                    QZLog.e(FeedView.TAG, "[onShowCrossViewFailed] " + i3);
                    FeedView.this.recycleGdtCrossView();
                }
            };
            this.mGdtCrossView.setTag(listener);
            this.mGdtCrossView.setListener(new WeakReference<>(listener));
        }
        if (!this.mGdtCrossView.isInitialized()) {
            this.mGdtCrossAdParams.topOfHOnScreen = GdtFeedUtilForQZone.m();
            this.mGdtCrossAdParams.imageWidthPx = getWidth();
            this.mGdtCrossAdParams.imageHeightPx = (int) (getWidth() * GdtAdFeedUtil.getRatioOfImageHeightAndWidthForCrossAd(this.mFeedData));
            this.mGdtCrossAdParams.imageUrl = GdtAdFeedUtil.getImageUrlForCrossAd(this.mFeedData);
            this.mGdtCrossView.init(this.mGdtCrossAdParams);
        }
        this.mGdtCrossView.update(this.mLocation[1] + feedContentView.getHeight());
    }

    private void updateLvTenHeight() {
        Drawable drawable = this.mFeedSkinDrawable;
        if (drawable != null && (drawable instanceof APNGDrawable)) {
            ((APNGDrawable) drawable).setLoadedListener(new Function1<IDynamicDrawable, Unit>() { // from class: com.qzone.module.feedcomponent.ui.FeedView.3
                @Override // kotlin.jvm.functions.Function1
                public Unit invoke(IDynamicDrawable iDynamicDrawable) {
                    if (FeedView.this.mFeedSkinDrawable == null) {
                        return null;
                    }
                    int intrinsicHeight = FeedView.this.mFeedSkinDrawable.getIntrinsicHeight();
                    float intrinsicWidth = FeedView.this.mFeedSkinDrawable.getIntrinsicWidth();
                    float f16 = intrinsicHeight;
                    int width = (int) ((FeedView.this.getWidth() / intrinsicWidth) * f16);
                    if (width <= FeedView.this.getHeight()) {
                        FeedView.this.mLvTenHeight = width;
                        FeedView feedView = FeedView.this;
                        feedView.mLvTenWidth = feedView.getWidth();
                    } else {
                        FeedView feedView2 = FeedView.this;
                        feedView2.mLvTenHeight = feedView2.getHeight();
                        FeedView.this.mLvTenWidth = (int) ((r2.mLvTenHeight / f16) * intrinsicWidth);
                    }
                    return null;
                }
            });
        }
    }

    public FeedViewSection addSection(int i3, FeedViewSection feedViewSection) {
        this.mFeedSections.put(i3, feedViewSection);
        FeedViewSection feedViewSection2 = this.lastSection;
        if (feedViewSection2 != null) {
            feedViewSection2.nextSection = feedViewSection;
        }
        feedViewSection.previousSection = feedViewSection2;
        this.lastSection = feedViewSection;
        FeedViewSectionManager.INSTANCE.addCombineSection(this, i3);
        return feedViewSection;
    }

    public void beginSetData() {
        reset();
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public boolean canLiveFeedAutoPlay() {
        BusinessFeedData businessFeedData = this.mFeedData;
        if (businessFeedData == null) {
            com.qzone.proxy.feedcomponent.b.a("FeedView", "canLiveFeedAutoPlay mFeedData == null");
            return false;
        }
        if (!businessFeedData.isLiveVideoFeed() || this.mFeedData.getCellLive().roomstat != 1) {
            return true;
        }
        if (this.mFeedData.getOriginalInfo() != null && this.mFeedData.getOriginalInfo().getCellLive() != null) {
            return true;
        }
        long h06 = com.qzone.adapter.feedcomponent.i.H().h0(12000);
        if (this.mFeedData.getFeedCommInfo() != null && System.currentTimeMillis() - this.mFeedData.getFeedCommInfo().time >= h06) {
            return true;
        }
        if (this.mFeedData.getFeedCommInfo() != null) {
            com.qzone.proxy.feedcomponent.b.a("FeedView", "canLiveFeedAutoPlay return false, delay=" + h06 + ", diff=" + (System.currentTimeMillis() - this.mFeedData.getFeedCommInfo().time));
        }
        return false;
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public boolean canShowFeedSkin() {
        BusinessFeedData businessFeedData;
        FeedTitle feedTitle = this.mFeedTitle;
        return feedTitle != null && feedTitle.canShowFeedSkin() && (businessFeedData = this.mFeedData) != null && businessFeedData.getCellFeedSkinInfo() != null && this.mFeedData.getCellFeedSkinInfo().nSkinType == 392 && this.mFeedData.getCoverInfo() == null && com.qzone.adapter.feedcomponent.i.H().d1();
    }

    public boolean canShowSpecialFeedSkin() {
        String str;
        final String str2;
        FeedSkinData cellFeedSkinInfo = this.mFeedData.getCellFeedSkinInfo();
        if (cellFeedSkinInfo == null) {
            return false;
        }
        if (!TextUtils.isEmpty(cellFeedSkinInfo.strFrameZip)) {
            str = QzoneZipCacheHelper.d(ZipDrawableLoader.DEFAULT_BUSINESS, String.valueOf(cellFeedSkinInfo.strFrameZip.hashCode()), 0);
        } else {
            str = "";
        }
        if (new File(str).exists() && new File(str).isDirectory()) {
            if (new File(str, "lv10").exists()) {
                this.mLv10FeedSkinPath = str + "/lv10";
                return true;
            }
            if (new File(str, "luxury10").exists()) {
                if (com.qzone.adapter.feedcomponent.i.H().p1()) {
                    str2 = "_dark";
                } else {
                    str2 = "_light";
                }
                File[] listFiles = new File(str + "/luxury10/").listFiles(new FileFilter() { // from class: com.qzone.module.feedcomponent.ui.FeedView.5
                    @Override // java.io.FileFilter
                    public boolean accept(File file) {
                        return file.getName().contains(str2);
                    }
                });
                if (listFiles != null && listFiles.length == 1) {
                    this.mLuxuryFeedSkinPath = listFiles[0].getAbsolutePath();
                    return true;
                }
            }
            return false;
        }
        if (!TextUtils.isEmpty(cellFeedSkinInfo.strFrameZip)) {
            String str3 = cellFeedSkinInfo.strFrameZip;
            QzoneZipCacheHelper.b(str3, ZipDrawableLoader.DEFAULT_BUSINESS, String.valueOf(str3.hashCode()), 0, null);
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        onDrawTopDrawable(canvas);
    }

    protected void doBeforeOnDraw(Canvas canvas) {
        FeedDate feedDate;
        FeedDate feedDate2;
        if (this.mFeedData.isFriendBirthdayContainerFeed()) {
            setBackgroundDrawable(null);
            if (this.shadowPaint == null) {
                Paint paint = new Paint();
                this.shadowPaint = paint;
                paint.setStrokeWidth(1.0f);
                this.shadowPaint.setStyle(Paint.Style.STROKE);
            }
            CardUtils.drawCardShadow(canvas, new RectF(AreaConst.f48747dp2, AreaConst.f48746dp1, getWidth(), getHeight() - AreaConst.dp6), false, 8, this.shadowPaint);
        }
        if (this.mShowDateHeader && getFeedDateHeader() != null) {
            this.mFeedDateHeader = getFeedDateHeader();
            FeedSearchNoResultTip feedSearchNoResultTip = getFeedSearchNoResultTip();
            if (this.mFeedData.isNeedShowSearchNoResultTip() && feedSearchNoResultTip != null) {
                setBackgroundDrawablePosition(0, feedSearchNoResultTip.getMeasuredHeight() + this.mFeedDateHeader.getMeasuredHeight(), getMeasuredWidth(), getMeasuredHeight());
            } else {
                setBackgroundDrawablePosition(0, this.mFeedDateHeader.getMeasuredHeight(), getMeasuredWidth(), getMeasuredHeight());
            }
        } else {
            FeedSeparator feedSeparator = this.mFeedSeparator;
            if (feedSeparator != null && feedSeparator.isDataValid()) {
                if (this.mCanShowDate && (feedDate2 = this.mFeedDate) != null && feedDate2.d()) {
                    setBackgroundDrawablePosition(0, this.part1Bound.top + this.mFeedSeparator.getMeasuredHeight() + this.mFeedDate.getMeasuredHeight(), getMeasuredWidth(), getMeasuredHeight());
                } else {
                    setBackgroundDrawablePosition(0, this.part1Bound.top + this.mFeedSeparator.getMeasuredHeight(), getMeasuredWidth(), getMeasuredHeight());
                }
            } else if (this.mCanShowDate && (feedDate = this.mFeedDate) != null && feedDate.d()) {
                setBackgroundDrawablePosition(0, this.mFeedDate.getMeasuredHeight(), getMeasuredWidth(), getMeasuredHeight());
            } else {
                FeedSearchSeparator feedSearchSeparator = this.mFeedSearchSeparator;
                if (feedSearchSeparator != null && this.mCanShowSeparator) {
                    setBackgroundDrawablePosition(0, feedSearchSeparator.getMeasuredHeight(), getMeasuredWidth(), getMeasuredHeight());
                } else {
                    setBackgroundDrawablePosition(0, 0, getMeasuredWidth(), getMeasuredHeight());
                }
            }
        }
        FeedSearchSeparator feedSearchSeparator2 = this.mFeedSearchSeparator;
        if (feedSearchSeparator2 != null) {
            if (this.mCanShowSeparator) {
                feedSearchSeparator2.setVisibility(0);
            } else {
                feedSearchSeparator2.setVisibility(8);
            }
        }
        drawFeedSkin(canvas);
        drawBackground(canvas);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        long j3;
        long j16;
        System.currentTimeMillis();
        if (com.qzone.adapter.feedcomponent.i.H().e1()) {
            j3 = System.currentTimeMillis();
            j16 = SystemClock.currentThreadTimeMillis();
        } else {
            j3 = 0;
            j16 = 0;
        }
        super.draw(canvas);
        if (com.qzone.adapter.feedcomponent.i.H().e1()) {
            long currentTimeMillis = System.currentTimeMillis();
            com.qzone.proxy.feedcomponent.b.a("FeedsScrollPerformanceAutoMonitor", "FeedView draw: realTime:" + (currentTimeMillis - j3) + " threadTime:" + (SystemClock.currentThreadTimeMillis() - j16));
        }
    }

    void drawBackground(Canvas canvas) {
        int i3;
        BusinessFeedData businessFeedData;
        BusinessFeedData businessFeedData2 = this.mFeedData;
        if ((businessFeedData2 != null && businessFeedData2.setFeedViewGapWhite) || FeedUtil.isCurrentFeedAdvFeedTopAfter(businessFeedData2)) {
            mBackgroundDrawablePart1 = new ColorDrawable(com.qzone.adapter.feedcomponent.j.m());
        } else {
            mBackgroundDrawablePart1 = new ColorDrawable(com.qzone.adapter.feedcomponent.j.s());
        }
        if (this.needBackground || needShowForwardView()) {
            mBackgroundDrawableForward = new ColorDrawable(com.qzone.adapter.feedcomponent.j.q());
            if (mHasSetTrans) {
                if (mBackgroundDrawablePart1 != null) {
                    BusinessFeedData businessFeedData3 = this.mFeedData;
                    if (businessFeedData3 != null && businessFeedData3.cellFollowGuide != null) {
                        ColorDrawable colorDrawable = new ColorDrawable(com.qzone.adapter.feedcomponent.j.s());
                        mBackgroundDrawablePart1 = colorDrawable;
                        colorDrawable.setAlpha(this.mTrans);
                    } else if (!FeedUtil.isCurrentFeedAdvFeedTopAfter(businessFeedData3) && ((businessFeedData = this.mFeedData) == null || !businessFeedData.setFeedViewGapWhite)) {
                        ColorDrawable colorDrawable2 = new ColorDrawable(com.qzone.adapter.feedcomponent.j.s());
                        mBackgroundDrawablePart1 = colorDrawable2;
                        colorDrawable2.setAlpha(this.mTrans);
                    } else {
                        ColorDrawable colorDrawable3 = new ColorDrawable(com.qzone.adapter.feedcomponent.j.m());
                        mBackgroundDrawablePart1 = colorDrawable3;
                        colorDrawable3.setAlpha(this.mTrans);
                    }
                }
                Drawable drawable = this.mBackgroundDrawablePart2;
                if (drawable != null) {
                    drawable.setAlpha(this.mTrans);
                }
                Drawable drawable2 = mBackgroundDrawableForward;
                if (drawable2 != null) {
                    drawable2.setAlpha(this.mTrans);
                }
            }
            if (FeedUtil.isCurrentFeedAdvFeedTopAfter(this.mFeedData)) {
                ColorDrawable colorDrawable4 = new ColorDrawable(com.qzone.adapter.feedcomponent.j.m());
                mBackgroundDrawablePart1 = colorDrawable4;
                colorDrawable4.setAlpha(this.mTrans);
            }
            mBackgroundDrawablePart1.setBounds(this.part1Bound);
            mBackgroundDrawablePart1.draw(canvas);
            if (needShowForwardView()) {
                int forwardTop = getForwardTop();
                FeedForward feedForward = this.mFeedForward;
                if (feedForward != null) {
                    if (feedForward.getFeedContentContainer() != null) {
                        i3 = this.mFeedForward.getFeedContentContainer().getBottom();
                    } else {
                        i3 = this.mFeedForward.getContentView().getBottom();
                    }
                    if (this.mFeedForward.getVideoView() != null && this.mFeedForward.getVideoView().getVisibility() == 0) {
                        i3 = this.mFeedForward.getVideoView().getBottom();
                    }
                    FeedPicTextCardNewView feedPicTextCardNewView = this.mFeedForward.mFeedPicTextCardNewView;
                    if (feedPicTextCardNewView != null && feedPicTextCardNewView.getVisibility() == 0) {
                        i3 = this.mFeedForward.mFeedPicTextCardNewView.getBottom();
                    }
                } else {
                    i3 = 0;
                }
                Drawable drawable3 = this.mBackgroundDrawablePart2;
                if (drawable3 != null && !this.mFeedSkinDrawed) {
                    Rect rect = this.part2Bound;
                    drawable3.setBounds(rect.left, rect.top, rect.right, forwardTop);
                    this.mBackgroundDrawablePart2.draw(canvas);
                }
                Drawable drawable4 = mBackgroundDrawableForward;
                Rect rect2 = this.part2Bound;
                drawable4.setBounds(rect2.left, forwardTop, rect2.right, i3);
                mBackgroundDrawableForward.draw(canvas);
                Drawable drawable5 = this.mBackgroundDrawablePart2;
                if (drawable5 == null || this.mFeedSkinDrawed) {
                    return;
                }
                Rect rect3 = this.part2Bound;
                drawable5.setBounds(rect3.left, i3, rect3.right, rect3.bottom);
                this.mBackgroundDrawablePart2.draw(canvas);
                return;
            }
            Drawable drawable6 = this.mBackgroundDrawablePart2;
            if (drawable6 == null || this.mFeedSkinDrawed) {
                return;
            }
            drawable6.setBounds(this.part2Bound);
            this.mBackgroundDrawablePart2.draw(canvas);
        }
    }

    public String dumpAllAreaView() {
        return GdtCanvasTestUtil.areas2Json(GdtCanvasTestUtil.getAllVisibleCanvasArea(this));
    }

    public void finishSetData() {
        ArrayList<PicText> arrayList;
        int i3;
        int i16;
        BusinessFeedData businessFeedData;
        BusinessFeedData businessFeedData2;
        FeedPictureInfo[] feedPictureInfoArr;
        finishSetDataUpdateFeedSections();
        FeedCommonSection dateHeaderSection = getDateHeaderSection();
        if (dateHeaderSection != null && !dateHeaderSection.isEmpty()) {
            setShowDateHeader(true);
        }
        FeedDate feedDate = this.mFeedDate;
        if (feedDate != null) {
            if (!feedDate.d()) {
                setViewVisibility(this.mFeedDate, 8);
            } else {
                setViewVisibility(this.mFeedDate, 0);
            }
        }
        FeedPicTextCardView feedPicTextCardView = this.mFeedPicTextCardView;
        if (feedPicTextCardView != null) {
            if (!feedPicTextCardView.hasUsed()) {
                setViewVisibility(this.mFeedPicTextCardView, 8);
            } else {
                setViewVisibility(this.mFeedPicTextCardView, 0);
            }
        }
        FeedSearchNoResultTip feedSearchNoResultTip = this.mFeedSearchNoResultTip;
        if (feedSearchNoResultTip != null) {
            if (!feedSearchNoResultTip.hasUsed()) {
                setViewVisibility(this.mFeedSearchNoResultTip, 8);
            } else {
                setViewVisibility(this.mFeedSearchNoResultTip, 0);
            }
        }
        FeedRecommHeader feedRecommHeader = this.mFeedRecommHeader;
        if (feedRecommHeader != null) {
            if (!feedRecommHeader.hasUsed()) {
                setViewVisibility(this.mFeedRecommHeader, 8);
            } else {
                setViewVisibility(this.mFeedRecommHeader, 0);
            }
        }
        FeedViewSection section = getSection(62);
        if (section != null && section.getView() != null && (section.getView() instanceof View) && ((View) section.getView()).getLayoutParams() != null && this.mFeedDate != null) {
            if (!QZoneAdFeedDataExtKt.isBrandOptimizationAdv(this.mFeedData) && !QZoneAdFeedDataExtKt.isAddGroupAdv(this.mFeedData)) {
                if (QZoneAdFeedDataExtKt.isAdvContainerSixGridStyle(this.mFeedData)) {
                    ((View) section.getView()).getLayoutParams().height = 0;
                } else {
                    ((View) section.getView()).getLayoutParams().height = AreaConst.dp53;
                }
            } else {
                ((View) section.getView()).getLayoutParams().height = 0;
                BusinessFeedData businessFeedData3 = this.mFeedData;
                if (businessFeedData3 != null && businessFeedData3.getAdData().getIsBrandOptimizationShow()) {
                    ((View) section.getView()).getLayoutParams().height = com.qzone.proxy.feedcomponent.util.g.a(68.0f);
                }
            }
        }
        FeedContent feedContent = this.mFeedContent;
        if (feedContent != null && feedContent.getContentView() != null && this.mFeedContent.getContentView().gdt_addGroup_container != null && this.mFeedContent.getContentView().gdt_addGroup != null && this.mFeedContent.getContentView().gdt_addGroup_button != null && (businessFeedData = this.mFeedData) != null) {
            if (QZoneAdFeedDataExtKt.isAddGroupAdv(businessFeedData) && (feedPictureInfoArr = (businessFeedData2 = this.mFeedData).pics) != null && feedPictureInfoArr.length > 0 && feedPictureInfoArr[0] != null) {
                if (businessFeedData2.getAdData().getIsAddGroupAdShow()) {
                    this.mFeedContent.getContentView().gdt_addGroup_container.width = com.qzone.proxy.feedcomponent.util.g.a(106.0f);
                    this.mFeedContent.getContentView().gdt_addGroup.width = this.mFeedData.pics[0].f50256s;
                    this.mFeedContent.getContentView().setAddGroupView(this.mFeedData.pics);
                    this.mFeedContent.getContentView().gdt_addGroup_button.setVisibility(0);
                } else {
                    this.mFeedContent.getContentView().gdt_addGroup_container.width = com.qzone.proxy.feedcomponent.util.g.a(0.0f);
                    this.mFeedContent.getContentView().gdt_addGroup.width = com.qzone.proxy.feedcomponent.util.g.a(0.0f);
                }
            } else {
                this.mFeedContent.getContentView().gdt_addGroup_container.width = com.qzone.proxy.feedcomponent.util.g.a(0.0f);
                this.mFeedContent.getContentView().gdt_addGroup.width = com.qzone.proxy.feedcomponent.util.g.a(0.0f);
            }
        }
        FeedCanvasAdRecommAction feedCanvasAdRecommAction = this.mFeedCanvasRecommAction;
        if (feedCanvasAdRecommAction != null) {
            if (!feedCanvasAdRecommAction.hasUsed()) {
                setViewVisibility(this.mFeedCanvasRecommAction, 8);
            } else {
                setViewVisibility(this.mFeedCanvasRecommAction, 0);
            }
        }
        FeedGoods feedGoods = this.mFeedGoods;
        if (feedGoods != null) {
            if (!feedGoods.hasUsed()) {
                setViewVisibility(this.mFeedGoods, 8);
            } else {
                setViewVisibility(this.mFeedGoods, 0);
            }
        }
        FeedSeparator feedSeparator = this.mFeedSeparator;
        if (feedSeparator != null) {
            if (!feedSeparator.hasUsed()) {
                setViewVisibility(this.mFeedSeparator, 8);
            } else {
                setViewVisibility(this.mFeedSeparator, 0);
            }
        }
        FeedScrollContainerArea feedScrollContainerArea = this.mFeedScrollContainerArea;
        if (feedScrollContainerArea != null) {
            if (!feedScrollContainerArea.hasUsed()) {
                setViewVisibility(this.mFeedScrollContainerArea, 8);
            } else {
                setViewVisibility(this.mFeedScrollContainerArea, 0);
            }
        }
        FeedHorizontalListView feedHorizontalListView = this.mHorizontalListView;
        if (feedHorizontalListView != null) {
            if (!feedHorizontalListView.hasUsed()) {
                setViewVisibility(this.mHorizontalListView, 8);
            } else {
                setViewVisibility(this.mHorizontalListView, 0);
            }
        }
        FeedGoods feedGoods2 = this.mFeedGoods;
        if (feedGoods2 != null) {
            if (!feedGoods2.hasUsed()) {
                setViewVisibility(this.mFeedGoods, 8);
            } else {
                setViewVisibility(this.mFeedGoods, 0);
            }
        }
        FeedSpecialCare feedSpecialCare = this.mFeedSpecialCare;
        if (feedSpecialCare != null) {
            if (!feedSpecialCare.hasUsed()) {
                setViewVisibility(this.mFeedSpecialCare, 8);
            } else {
                setViewVisibility(this.mFeedSpecialCare, 0);
            }
        }
        FeedPlayBarView feedPlayBarView = this.mPlayBarView;
        if (feedPlayBarView != null) {
            if (feedPlayBarView.canHide()) {
                setViewVisibility(this.mPlayBarView, 8);
            } else {
                setViewVisibility(this.mPlayBarView, 0);
            }
        }
        FeedRecommendFriendsHorizontalCardView feedRecommendFriendsHorizontalCardView = this.mFeedRecommendFriendsHorizontalCardView;
        if (feedRecommendFriendsHorizontalCardView != null) {
            if (!feedRecommendFriendsHorizontalCardView.hasUsed()) {
                setViewVisibility(this.mFeedRecommendFriendsHorizontalCardView, 8);
            } else {
                setViewVisibility(this.mFeedRecommendFriendsHorizontalCardView, 0);
            }
        }
        FeedSeparator feedSeparator2 = this.mFeedSeparator;
        if (feedSeparator2 != null) {
            if (!feedSeparator2.hasUsed()) {
                setViewVisibility(this.mFeedSeparator, 8);
            } else {
                setViewVisibility(this.mFeedSeparator, 0);
            }
        }
        FeedFamousRecommView feedFamousRecommView = this.mFamousRecommView;
        if (feedFamousRecommView != null) {
            if (!feedFamousRecommView.hasUsed()) {
                setViewVisibility(this.mFamousRecommView, 8);
            } else {
                setViewVisibility(this.mFamousRecommView, 0);
            }
        }
        FeedFriendBirthdayGiftPanel feedFriendBirthdayGiftPanel = this.mFeedFriendBirthdayGiftPanel;
        if (feedFriendBirthdayGiftPanel != null) {
            if (!feedFriendBirthdayGiftPanel.hasUsed()) {
                setViewVisibility(this.mFeedFriendBirthdayGiftPanel, 8);
            } else {
                setViewVisibility(this.mFeedFriendBirthdayGiftPanel, 0);
            }
        }
        BusinessFeedData businessFeedData4 = this.mFeedData;
        if (businessFeedData4 != null) {
            CellPicTextInfo picTextInfo = businessFeedData4.getPicTextInfo();
            BusinessFeedData businessFeedData5 = this.mFeedData;
            if (businessFeedData5.feedType == 4098) {
                if ((businessFeedData5.getOriginalInfo() == null || this.mFeedData.getOriginalInfo().getCommentInfoV2() == null || this.mFeedData.getOriginalInfo().getCommentInfoV2().commments == null || this.mFeedData.getOriginalInfo().getCommentInfoV2().commments.size() <= 0) ? false : true) {
                    int i17 = AreaManager.dp4_5;
                    if (com.qzone.adapter.feedcomponent.i.H().k1()) {
                        i16 = AreaManager.dp12;
                    } else {
                        i16 = AreaManager.dp15;
                    }
                    setPadding(0, i17, 0, i16);
                } else {
                    int i18 = AreaManager.dp4_5;
                    if (com.qzone.adapter.feedcomponent.i.H().k1()) {
                        i3 = AreaManager.dp9;
                    } else {
                        i3 = AreaManager.dp15;
                    }
                    setPadding(0, i18, 0, i3);
                }
                if (this.mFeedData.getCellQbossPsvAdv() != null) {
                    setPadding(0, AreaManager.dp4_5, 0, 0);
                }
            } else if ((picTextInfo != null && (arrayList = picTextInfo.picTexts) != null && arrayList.size() > 0) || this.mFeedData.isFriendPlayingFeed()) {
                setPadding(0, 0, 0, AreaManager.f48751dp2);
            } else {
                BusinessFeedData businessFeedData6 = this.mFeedData;
                if (businessFeedData6.cellFollowGuide != null) {
                    setPadding(0, 0, 0, 0);
                } else if (businessFeedData6.feedType == 2) {
                    setPadding(0, 0, 0, 0);
                } else if (this.isFriendLikeContainer) {
                    setPadding(getPaddingLeft(), 0, getPaddingRight(), getPaddingBottom());
                } else if (businessFeedData6.isAdvContainerThreeGridStyle()) {
                    setPadding(0, 0, 0, 0);
                } else if (this.mFeedData.getFeedCommInfo().isBizRecomFamousFeeds() && this.mFeedData.isSubFeed) {
                    setPadding(0, 0, 0, 0);
                } else if (this.mFeedData.getCellQbossPsvAdv() != null) {
                    setPadding(0, 0, 0, 0);
                } else if (this.mFeedData.isGDTAdvFeed() && !this.mFeedData.isSubFeed) {
                    setPadding(0, 0, 0, AreaConst.AREA_VERTICAL_MARGIN);
                } else if (this.mFeedData.isAdFeeds()) {
                    setPadding(0, 0, 0, 0);
                } else if (this.mFeedData.isQCircleRecommFeed()) {
                    setPadding(0, 0, 0, AreaConst.AREA_VERTICAL_MARGIN);
                } else {
                    setPadding(0, 0, 0, 0);
                }
            }
        }
        if (this.mShowFrameLine) {
            setBackgroundResource(com.qzone.adapter.feedcomponent.j.h(766));
        } else {
            setBackgroundResource(0);
        }
        FeedTitleForward feedTitleForward = this.mFeedTitleForward;
        if (feedTitleForward != null) {
            feedTitleForward.onFinishSetData();
        }
        setCoupleBg();
        updateFeedSkin();
        setupPublicAccountContainerIfNeed();
        BusinessFeedData businessFeedData7 = this.mFeedData;
        if (businessFeedData7 == null || !businessFeedData7.isGDTAdvFeed()) {
            return;
        }
        attachGdtExposureChecker();
        setupAdFloatTipsView();
        if (GdtAdFeedUtil.canShowCrossAd(this.mFeedData, this.mFeedPosition)) {
            setGdtCrossView();
        }
    }

    protected void finishSetDataUpdateFeedSections() {
        try {
            inertNewView();
        } catch (Exception e16) {
            com.qzone.proxy.feedcomponent.b.d(FeedViewSection.TAG, "finishSetData - err", e16);
        }
    }

    protected LinearLayout.LayoutParams generateLayoutParams(int i3, int i16) {
        return generateLayoutParams(i3, 0, i16, 0);
    }

    @Override // com.qzone.module.feedcomponent.ui.NormalAbsFeedView
    public FeedAutoVideo getAutoVideoView() {
        if (this.mFeedData != null && getFeedForward() != null && getFeedContent() != null) {
            if (GdtAdFeedUtil.isCarouselCard(this.mFeedData)) {
                return getGdtCarouselCardVideoView();
            }
            if (this.mFeedData.getOriginalInfo() != null && this.mFeedData.getOriginalInfo().getVideoInfo() != null && getFeedForward().mAutoVideo != null) {
                return getFeedForward().mAutoVideo.getAutoVideoView();
            }
            if (getFeedContent().mAutoVideo != null) {
                return getFeedContent().mAutoVideo.getAutoVideoView();
            }
        }
        return null;
    }

    public CampusShardCardView getCampusShardCardView() {
        return this.mCampusShardCardView;
    }

    public FeedCommonSection getDateHeaderSection() {
        if (this.mDateHeaderSection == null) {
            this.mDateHeaderSection = new FeedCommonSection(this.mContext, FeedDateHeader.class, FeedDateHeader.DateHeaderController, this);
        }
        return this.mDateHeaderSection;
    }

    @Override // android.view.View
    public Bitmap getDrawingCache(boolean z16) {
        return null;
    }

    public FeedAppShareCardViewSection getFeedAppShareCardView() {
        if (this.mFeedAppShareCardView == null) {
            FeedAppShareCardViewSection feedAppShareCardViewSection = new FeedAppShareCardViewSection(this.mContext, this);
            this.mFeedAppShareCardView = feedAppShareCardViewSection;
            feedAppShareCardViewSection.setFeedPosition(this.mFeedPosition);
            this.mFeedAppShareCardView.setOnFeedElementClickListener(this.mOnFeedElementClickListener);
        }
        return this.mFeedAppShareCardView;
    }

    int getFeedBackgroundPart1Height() {
        if (SimpleModelUtils.isFirstFeed(this.mFeedPosition) && SimpleModelUtils.isSimpleModeFeed() && SimpleModelUtils.isFeedSkinPlus(this.mFeedData)) {
            return 0;
        }
        if (this.mFeedData == null || !this.mIsTodayInHistoryDetail) {
            return AreaConst.FEED_BACKGROUND_PART1_HEIGHT;
        }
        return 0;
    }

    public FeedBottomGuideView getFeedBottomGuideView() {
        if (this.mFeedBottomGuideView == null) {
            FeedBottomGuideView feedBottomGuideView = new FeedBottomGuideView(this.mContext, this);
            this.mFeedBottomGuideView = feedBottomGuideView;
            feedBottomGuideView.setFeedPosition(this.mFeedPosition);
            this.mFeedBottomGuideView.setOnFeedElementClickListener(this.mOnFeedElementClickListener);
        }
        return this.mFeedBottomGuideView;
    }

    @Override // com.qzone.module.feedcomponent.ui.NormalAbsFeedView
    public FeedComment getFeedComment() {
        if (this.mFeedComment == null) {
            FeedComment feedComment = new FeedComment(this.mContext, this);
            this.mFeedComment = feedComment;
            feedComment.setFeedPosition(this.mFeedPosition);
            this.mFeedComment.setOnFeedElementClickListener(this.mOnFeedElementClickListener);
        }
        return this.mFeedComment;
    }

    @Override // com.qzone.module.feedcomponent.ui.NormalAbsFeedView
    public FeedContent getFeedContent() {
        if (this.mFeedContent == null) {
            FeedContent feedContent = new FeedContent(this.mContext, this);
            this.mFeedContent = feedContent;
            feedContent.setSectionController(FeedContent.FeedContentController);
            this.mFeedContent.setFeedPosition(this.mFeedPosition);
            this.mFeedContent.setOnFeedElementClickListener(this.mOnFeedElementClickListener);
        }
        return this.mFeedContent;
    }

    @Override // com.qzone.module.feedcomponent.ui.NormalAbsFeedView
    public FeedAutoVideo getFeedContentAutoVideo() {
        BusinessFeedData businessFeedData = this.mFeedData;
        if (businessFeedData == null || businessFeedData.isFakeFeed()) {
            return null;
        }
        if (getFeedForward() != null && getFeedForward().isMultiPicVideoFeed() && getFeedForward().mContentViewVideo != null && this.mFeedData.getOriginalInfo() != null && this.mFeedData.getOriginalInfo().getPictureInfo() != null) {
            return getFeedForward().mContentViewVideo.getAutoVideoView();
        }
        if (getFeedContent() == null || !getFeedContent().isMultiPicVideoFeed() || getFeedContent().mContentViewVideo == null) {
            return null;
        }
        return getFeedContent().mContentViewVideo.getAutoVideoView();
    }

    @Override // com.qzone.module.feedcomponent.ui.NormalAbsFeedView
    public CanvasFeedContentView getFeedContentView() {
        FeedContent feedContent = this.mFeedContent;
        if (feedContent == null) {
            return null;
        }
        return feedContent.getContentView();
    }

    public FeedDate getFeedDate() {
        return this.mFeedDate;
    }

    public CanvasFeedDrawerView getFeedDrawerView() {
        CanvasFeedDrawerView canvasFeedDrawerView = this.mCanvasDrawerView;
        if (canvasFeedDrawerView != null) {
            canvasFeedDrawerView.setOnFeedElementClickListener(this.mOnFeedElementClickListener);
            this.mCanvasDrawerView.setFeedPosition(this.mFeedPosition);
        }
        return this.mCanvasDrawerView;
    }

    public FeedFollowGuideView getFeedFollowGuideView() {
        if (this.mFeedFollowGuideView == null) {
            FeedFollowGuideView feedFollowGuideView = new FeedFollowGuideView(this.mContext, this);
            this.mFeedFollowGuideView = feedFollowGuideView;
            feedFollowGuideView.setFeedPosition(this.mFeedPosition);
            this.mFeedFollowGuideView.setOnFeedElementClickListener(this.mOnFeedElementClickListener);
        }
        return this.mFeedFollowGuideView;
    }

    @Override // com.qzone.module.feedcomponent.ui.NormalAbsFeedView
    public FeedForward getFeedForward() {
        if (this.mFeedForward == null) {
            FeedForward feedForward = new FeedForward(this.mContext, this);
            this.mFeedForward = feedForward;
            feedForward.setFeedPosition(this.mFeedPosition);
            this.mFeedForward.setOnFeedElementClickListener(this.mOnFeedElementClickListener);
        }
        return this.mFeedForward;
    }

    public FeedTitleForward getFeedForwardTitle() {
        if (this.mFeedTitleForward == null) {
            FeedTitleForward feedTitleForward = new FeedTitleForward(this.mContext, this);
            this.mFeedTitleForward = feedTitleForward;
            feedTitleForward.setFeedPosition(this.mFeedPosition);
            this.mFeedTitleForward.setOnFeedElementClickListener(this.mOnFeedElementClickListener);
        }
        return this.mFeedTitleForward;
    }

    @Override // com.qzone.module.feedcomponent.ui.NormalAbsFeedView
    public FeedGiftLayout getFeedGiftLayout() {
        if (getFeedContent() != null) {
            return getFeedContent().getFeedGiftView();
        }
        return null;
    }

    public FeedHandBlogSection getFeedHandBlogForwardSection() {
        if (this.mFeedHandBlogForwardSection == null) {
            FeedHandBlogSection feedHandBlogSection = new FeedHandBlogSection(this.mContext, this);
            this.mFeedHandBlogForwardSection = feedHandBlogSection;
            feedHandBlogSection.setForward(true);
            this.mFeedHandBlogForwardSection.setFeedPosition(this.mFeedPosition);
            this.mFeedHandBlogForwardSection.setOnFeedElementClickListener(this.mOnFeedElementClickListener);
        }
        return this.mFeedHandBlogForwardSection;
    }

    public FeedHandBlogSection getFeedHandBlogSection() {
        if (this.mFeedHandBlogSection == null) {
            FeedHandBlogSection feedHandBlogSection = new FeedHandBlogSection(this.mContext, this);
            this.mFeedHandBlogSection = feedHandBlogSection;
            feedHandBlogSection.setFeedPosition(this.mFeedPosition);
            this.mFeedHandBlogSection.setOnFeedElementClickListener(this.mOnFeedElementClickListener);
        }
        return this.mFeedHandBlogSection;
    }

    public FeedInterest getFeedInterest() {
        if (this.mFeedInterest == null) {
            FeedInterest feedInterest = new FeedInterest(this.mContext, this);
            this.mFeedInterest = feedInterest;
            feedInterest.setFeedPosition(this.mFeedPosition);
            this.mFeedInterest.setOnFeedElementClickListener(this.mOnFeedElementClickListener);
        }
        return this.mFeedInterest;
    }

    public FeedOperation getFeedOperation() {
        if (this.mFeedOperation == null) {
            FeedOperation feedOperation = new FeedOperation(this.mContext, this);
            this.mFeedOperation = feedOperation;
            feedOperation.setFeedPosition(this.mFeedPosition);
            this.mFeedOperation.setOnFeedElementClickListener(this.mOnFeedElementClickListener);
        }
        return this.mFeedOperation;
    }

    @Override // com.qzone.module.feedcomponent.ui.NormalAbsFeedView
    public PanoramaLayout getFeedPanoramaView() {
        BusinessFeedData businessFeedData = this.mFeedData;
        if (businessFeedData == null) {
            return null;
        }
        if (businessFeedData.getOriginalInfo() != null && this.mFeedData.getOriginalInfo().getPictureInfo() != null && this.mFeedData.getOriginalInfo().getPictureInfo().isPanorama()) {
            if (getFeedForward() != null) {
                return getFeedForward().getPanoramaView();
            }
            return null;
        }
        if (getFeedContent() != null) {
            return getFeedContent().getPanoramaView();
        }
        return null;
    }

    public FeedPicTextCardView getFeedPicTextCardView() {
        return this.mFeedPicTextCardView;
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    /* renamed from: getFeedPosition */
    public int getMFeedPosition() {
        return this.mFeedPosition;
    }

    @Override // com.qzone.module.feedcomponent.ui.NormalAbsFeedView
    public FeedScrollContainerArea getFeedScrollContainer() {
        return this.mFeedScrollContainerArea;
    }

    public FeedTitle getFeedTitle() {
        if (this.mFeedTitle == null) {
            FeedTitle feedTitle = new FeedTitle(this.mContext, this);
            this.mFeedTitle = feedTitle;
            feedTitle.setFeedPosition(this.mFeedPosition);
            this.mFeedTitle.setOnFeedElementClickListener(this.mOnFeedElementClickListener);
        }
        return this.mFeedTitle;
    }

    int getForwardTop() {
        FeedTitleForward feedTitleForward = this.mFeedTitleForward;
        if (feedTitleForward != null && !feedTitleForward.isEmpty()) {
            return this.mFeedTitleForward.getTop();
        }
        FeedForward feedForward = this.mFeedForward;
        if (feedForward == null) {
            return 0;
        }
        if (feedForward.getFeedContentContainer() != null) {
            return this.mFeedForward.getFeedContentContainer().getTop();
        }
        return this.mFeedForward.getContentView().getTop();
    }

    public boolean getIsTodayInHistoryDetail() {
        return this.mIsTodayInHistoryDetail;
    }

    public com.qzone.proxy.feedcomponent.ui.g getOnFeedElementClickListener() {
        return this.mOnFeedElementClickListener;
    }

    public FeedPlayBarView getPlayBarView() {
        return this.mPlayBarView;
    }

    @Override // com.qzone.module.feedcomponent.ui.NormalAbsFeedView
    public CanvasQzoneCardView getQzoneCardView() {
        return this.mCardView;
    }

    @Override // com.qzone.module.feedcomponent.ui.NormalAbsFeedView
    public CanvasRecommAction getRecommAction() {
        return this.mFeedRecommAction;
    }

    public FeedRecommHeader getRecommHeader() {
        return this.mFeedRecommHeader;
    }

    public FeedViewSection getSection(int i3) {
        return this.mFeedSections.get(i3);
    }

    public FeedSeparator getSeparator() {
        return this.mFeedSeparator;
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public View getSinglePicAreaPos(Rect rect) {
        CanvasFeedContentView contentView = getFeedContent() != null ? getFeedContent().getContentView() : null;
        if (contentView != null) {
            contentView.getSinglePicAreaPos(rect);
        }
        return this;
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public View getVideoView() {
        if (getFeedContent() != null) {
            return getFeedContent().getVideoView();
        }
        return null;
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public View getVideoViewPos(Rect rect, boolean z16) {
        return null;
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public boolean hasVideoPlayed() {
        BusinessFeedData businessFeedData = this.mFeedData;
        return (businessFeedData == null || businessFeedData.getVideoInfo() == null || !this.mFeedData.getVideoInfo().hasVideoPlayed()) ? false : true;
    }

    protected void initUI(Context context) {
        Class cls;
        addSection(0, new FeedCommonSection(context, FeedSeparator.class, FeedSeparator.FeedSeparatorController, this));
        addSection(1, new FeedCommonSection(context, FeedSearchNoResultTip.class, FeedSearchNoResultTip.SearchTipController, this));
        addSection(2, getDateHeaderSection());
        addSection(3, new FeedFakeGapSection(context, this));
        addSection(5, new FeedCommonSection(context, FeedTopHeader.class, FeedTopHeader.TopHeaderController, this));
        addSection(8, new FeedCommonSection(context, FeedRecommHeaderNonAd.class, FeedRecommHeaderNonAd.RecommHeaderController, this));
        addSection(6, new FeedCommonSection(context, FeedRecommHeader.class, FeedRecommHeader.RecommHeaderController, this));
        addSection(7, getFeedInterest());
        FeedViewSection.SectionController sectionController = FeedRecommTitleView.controller;
        int i3 = AreaConst.MARGIN_LEFT;
        int i16 = AreaConst.MARGIN_RIGHT;
        addSection(9, new FeedCommonSection(context, FeedRecommTitleView.class, sectionController, this, generateLayoutParams(i3, 0, i16, 0)));
        addSection(10, getFeedTitle());
        addSection(12, getGdtDescription());
        addSection(13, getFeedContent());
        addSection(61, getGdtCarouselCard());
        addSection(20, getFeedHandBlogSection());
        addSection(21, new FeedCommonSection(context, CampusShardCardView.class, CampusShardCardView.CampusCardController, this));
        addSection(22, new FeedCommonSection(context, CanvasQzoneCardView.class, CanvasQzoneCardView.QzoneCardController, this));
        addSection(23, getFeedAppShareCardView());
        addSection(30, new FeedCommonSection(context, FeedScrollContainerArea.class, FeedScrollContainerArea.ScrollContainerController, this));
        addSection(31, new FeedCommonSection(context, FeedHorizontalListView.class, FeedHorizontalListView.FriendPlayingController, this));
        FeedViewSection.SectionController sectionController2 = FeedPlayBarView.FeedPlayBarController;
        int i17 = AreaConst.dp10;
        addSection(32, new FeedCommonSection(context, FeedPlayBarView.class, sectionController2, this, generateLayoutParams(0, i17, 0, 0)));
        addSection(33, getFeedForwardTitle());
        addSection(40, getFeedForward());
        addSection(45, getFeedHandBlogForwardSection());
        if (com.qzone.adapter.feedcomponent.i.H().V0()) {
            cls = FeedPicTextCardSmallTailView.class;
        } else {
            cls = FeedPicTextCardView.class;
        }
        addSection(51, new FeedCommonSection(context, cls, FeedPicTextCardView.PicTextCardController, this, generateLayoutParams(i3, AreaConst.f48746dp1, i16, 0)).setShouldBeenPutBackToPool(false).setViewId(DittoUIEngine.g().getResourceId("@id/feed_pic_text_card_view")));
        addSection(53, new FeedCommonSection(context, CanvasQCircleTailView.class, CanvasQCircleTailView.QCircleTailController, this, generateLayoutParams(i3, 0, i16, 0)).setShouldBeenPutBackToPool(false));
        addSection(63, new FeedCommonSection(context, CanvasRecommActionNonAd.class, CanvasRecommActionNonAd.RecommActionController, this).setViewId(DittoUIEngine.g().getResourceId("@id/feed_recomm_action_area")));
        addSection(62, new FeedCommonSection(context, CanvasRecommAction.class, CanvasRecommAction.RecommActionController, this).setViewId(DittoUIEngine.g().getResourceId("@id/feed_recomm_action_area")));
        addSection(64, new FeedCommonSection(context, FeedCanvasAdRecommAction.class, FeedCanvasAdRecommAction.AdRecommActionController, this).setViewId(DittoUIEngine.g().getResourceId("@id/feed_canvas_recomm_action_area")));
        addSection(65, new FeedCommonSection(context, FeedGoods.class, FeedGoods.FeedGoodsController, this, generateLayoutParams(i17, i17)));
        addSection(100, new FeedCommonSection(context, FeedSuggestMoreViewB.class, FeedSuggestMoreViewB.SuggestMoreController, this));
        addSection(101, new FeedCommonSection(context, FeedSpecialCare.class, FeedSpecialCare.SpecialCareController, this));
        addSection(102, new FeedCommonSection(context, FeedRecommendFriendsHorizontalCardView.class, FeedRecommendFriendsHorizontalCardView.RecommendFriendsCardController, this));
        addSection(103, new FeedBirthdayGiftSection(context, FeedFriendBirthdayGiftPanel.class, FeedFriendBirthdayGiftPanel.BirthdayGiftController, this));
        addSection(110, getFeedOperation());
        addSection(111, getFeedComment());
        addSection(115, getFeedBottomGuideView());
        addSection(112, getFeedFollowGuideView());
        addSection(114, new FeedCommonSection(context, FeedAlbumRec.class, FeedAlbumRec.SECTION_CONTROLLER, this));
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public boolean isAlwaysAutoPlayFeed() {
        BusinessFeedData businessFeedData = this.mFeedData;
        return businessFeedData != null && businessFeedData.isAdvMicroVideo();
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public boolean isAutoVideoFeed() {
        BusinessFeedData businessFeedData = this.mFeedData;
        if (businessFeedData == null) {
            return false;
        }
        VideoInfo videoInfo = businessFeedData.getVideoInfo();
        boolean z16 = videoInfo != null && videoInfo.isAutoPlay();
        BusinessFeedData originalInfo = this.mFeedData.getOriginalInfo();
        VideoInfo videoInfo2 = originalInfo == null ? null : originalInfo.getVideoInfo();
        return z16 || (videoInfo2 != null && videoInfo2.isAutoPlay());
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public boolean isDateHeaderShow() {
        return this.mShowDateHeader;
    }

    public void needBackground(boolean z16) {
        this.needBackground = z16;
    }

    boolean needShowForwardView() {
        FeedForward feedForward = this.mFeedForward;
        if (feedForward == null || !feedForward.isForwardVisible() || this.mFeedForward.getContentView() == null || this.mFeedForward.isEmpty()) {
            return false;
        }
        FeedForward feedForward2 = this.mFeedForward;
        return !feedForward2.isPassive && feedForward2.isForward && feedForward2.getContentView().getVisibility() == 0 && this.mFeedForward.getContentView().getParent() != null && this.mFeedForward.getContentView().getHeight() > 0 && this.mFeedForward.getContentView().getWidth() > 0;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        doBeforeOnDraw(canvas);
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.mLastTouchDownX = (int) motionEvent.getX();
            this.mLastTouchDownY = (int) motionEvent.getY();
            this.mLastTouchDownTime = System.currentTimeMillis();
        } else if (action == 1) {
            this.mLastTouchUpX = (int) motionEvent.getX();
            this.mLastTouchUpY = (int) motionEvent.getY();
            this.mLastTouchUpTime = System.currentTimeMillis();
        }
        com.qzone.adapter.feedcomponent.i.H().t2(motionEvent);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void onListScroll() {
        updateGdtCrossView();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        long j3;
        long j16;
        System.currentTimeMillis();
        if (com.qzone.adapter.feedcomponent.i.H().e1()) {
            j3 = System.currentTimeMillis();
            j16 = SystemClock.currentThreadTimeMillis();
        } else {
            j3 = 0;
            j16 = 0;
        }
        super.onMeasure(i3, i16);
        if (com.qzone.adapter.feedcomponent.i.H().e1()) {
            com.qzone.proxy.feedcomponent.b.a("FeedsScrollPerformanceAutoMonitor", "FeedView onMeasure: realTime:" + (System.currentTimeMillis() - j3) + " threadTime:" + (SystemClock.currentThreadTimeMillis() - j16));
        }
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void onPause() {
        FeedViewSection section;
        FeedTitle feedTitle = this.mFeedTitle;
        if (feedTitle != null) {
            feedTitle.onPause();
        }
        FeedContent feedContent = this.mFeedContent;
        if (feedContent != null) {
            feedContent.onPause();
        }
        FeedForward feedForward = this.mFeedForward;
        if (feedForward != null) {
            feedForward.onPause();
        }
        FeedComment feedComment = this.mFeedComment;
        if (feedComment != null) {
            feedComment.onPause();
        }
        FeedPlayBarView feedPlayBarView = this.mPlayBarView;
        if (feedPlayBarView != null) {
            feedPlayBarView.onPause();
        }
        com.qzone.proxy.feedcomponent.ui.j jVar = this.mFeedViewPauseListener;
        if (jVar != null) {
            jVar.a();
        }
        BusinessFeedData businessFeedData = this.mFeedData;
        if (businessFeedData != null && businessFeedData.isGDTAdvFeed() && (section = getSection(62)) != null && section.getView() != null && (section.getView() instanceof CanvasRecommAction)) {
            ((CanvasRecommAction) section.getView()).onPause();
        }
        notifyGdtSectionOnPause();
        AdExposureChecker adExposureChecker = this.mGdtExposureChecker;
        if (adExposureChecker != null) {
            adExposureChecker.onActivityPause();
        }
        super.onPause();
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void onRecycled(boolean z16) {
        long j3;
        long j16;
        if (com.qzone.adapter.feedcomponent.i.H().e1()) {
            j3 = System.currentTimeMillis();
            j16 = SystemClock.currentThreadTimeMillis();
        } else {
            j3 = 0;
            j16 = 0;
        }
        FeedContent feedContent = this.mFeedContent;
        if (feedContent != null) {
            feedContent.onRecycled(z16);
        }
        FeedForward feedForward = this.mFeedForward;
        if (feedForward != null) {
            feedForward.onRecycled(z16);
        }
        this.mOnFeedElementClickListener = null;
        try {
            BusinessFeedData businessFeedData = this.mFeedData;
            if (businessFeedData != null && businessFeedData.feedType == 2 && BaseVideoManager.getFeedVideoManager().r() && !z16) {
                for (int childCount = getChildCount() - 1; childCount >= 0 && !(getChildAt(childCount) instanceof FeedVideoView); childCount--) {
                    removeViewAt(childCount);
                }
            } else {
                removeAllViews();
            }
            notifyAllSectionRecycled();
        } catch (Exception e16) {
            com.qzone.proxy.feedcomponent.b.d(FeedViewSection.TAG, "onRecycled - err", e16);
        }
        this.mTopDrawable = null;
        if (GdtAdFeedUtil.isCrossAd(this.mFeedData)) {
            this.mUiHandler.post(new Runnable() { // from class: com.qzone.module.feedcomponent.ui.FeedView.8
                @Override // java.lang.Runnable
                public void run() {
                    FeedView.this.recycleGdtCrossView();
                }
            });
        }
        AdExposureChecker adExposureChecker = this.mGdtExposureChecker;
        if (adExposureChecker != null) {
            adExposureChecker.onActivityDestroy();
            this.mGdtExposureChecker = null;
        }
        this.mGdtExposureCallback = null;
        super.onRecycled(z16);
        if (com.qzone.adapter.feedcomponent.i.H().e1()) {
            long currentTimeMillis = System.currentTimeMillis();
            com.qzone.proxy.feedcomponent.b.a("FeedsScrollPerformanceAutoMonitor", "FeedView onRecycled: realTime:" + (currentTimeMillis - j3) + " threadTime:" + (SystemClock.currentThreadTimeMillis() - j16));
        }
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void onStateIdleOnDetail(boolean z16) {
        if (!com.qzone.adapter.feedcomponent.i.H().c0() || getFeedContent() == null) {
            return;
        }
        getFeedContent().startVideoIfNeed(z16);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        GestureDetector gestureDetector = this.gestureDetector;
        if (gestureDetector == null || !gestureDetector.onTouchEvent(motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public String printViewTree() {
        PraiseListView praiseListView;
        CanvasAttachView canvasAttachView;
        CanvasTitleView canvasTitleView;
        StringBuilder sb5 = new StringBuilder();
        FeedTitle feedTitle = this.mFeedTitle;
        if (feedTitle != null && (canvasTitleView = feedTitle.mCanvasTitleView) != null) {
            sb5.append(canvasTitleView.convertToViewTree());
        }
        FeedContent feedContent = this.mFeedContent;
        if (feedContent != null) {
            CanvasFeedContentView canvasFeedContentView = feedContent.mCanvasFeedContentView;
            if (canvasFeedContentView != null) {
                sb5.append(canvasFeedContentView.convertToViewTree());
            }
            CanvasLeftThumbView canvasLeftThumbView = this.mFeedContent.mLeftThumbView;
            if (canvasLeftThumbView != null) {
                sb5.append(canvasLeftThumbView.convertToViewTree());
            }
        }
        FeedOperation feedOperation = this.mFeedOperation;
        if (feedOperation != null && (canvasAttachView = feedOperation.mAttachView) != null) {
            sb5.append(canvasAttachView.convertToViewTree());
        }
        FeedComment feedComment = this.mFeedComment;
        if (feedComment != null && (praiseListView = feedComment.praiseListView) != null) {
            sb5.append(praiseListView.convertToViewTree());
        }
        return sb5.toString();
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void reportFeed(BusinessFeedData businessFeedData, int i3) {
        if (com.qzone.adapter.feedcomponent.i.H().R1(businessFeedData, i3)) {
            return;
        }
        this.timeStamp = System.currentTimeMillis();
        this.mFeedData = businessFeedData;
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void reset() {
        notifyAllSectionReset();
        resetExtraInvoke();
        setPadding(0, 0, 0, AreaConst.AREA_VERTICAL_MARGIN);
        this.needBackground = true;
        this.mShowFrameLine = false;
        this.misPicTop = false;
        this.mShowDateHeader = false;
        this.isFriendLikeContainer = false;
        this.mFeedSkinDrawed = false;
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setAlpha(int i3) {
        this.mTrans = i3;
        mHasSetTrans = true;
        notifyAllSectionSetAlpha(i3);
    }

    void setBackgroundDrawablePosition(int i3, int i16, int i17, int i18) {
        Rect rect = this.part1Bound;
        rect.left = i3;
        rect.top = 0;
        rect.right = i17;
        rect.bottom = getFeedBackgroundPart1Height() + i16;
        Rect rect2 = this.part2Bound;
        rect2.left = i3;
        rect2.top = getFeedBackgroundPart1Height() + i16;
        Rect rect3 = this.part2Bound;
        rect3.right = i17;
        rect3.bottom = i18;
        BusinessFeedData businessFeedData = this.mFeedData;
        if (businessFeedData == null || businessFeedData.cellFollowGuide == null) {
            return;
        }
        Rect rect4 = this.part1Bound;
        rect4.left = i3;
        rect4.top = 0;
        rect4.right = i17;
        rect4.bottom = i18;
        rect3.left = i3;
        rect3.top = i18;
        rect3.right = i17;
        rect3.bottom = i18;
    }

    public void setBlankListener() {
        setOnClickListener(this.blankListener);
    }

    @Override // com.qzone.module.feedcomponent.ui.NormalAbsFeedView
    public void setFeedViewPauseListener(com.qzone.proxy.feedcomponent.ui.j jVar) {
        this.mFeedViewPauseListener = jVar;
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setHasRecommHeader(boolean z16) {
        if (this.hasHeader == z16) {
            return;
        }
        this.hasHeader = z16;
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setHasSearchSeparator(boolean z16) {
        this.mCanShowSeparator = z16;
    }

    public void setIsLikeFriendContainer(boolean z16) {
        this.isFriendLikeContainer = z16;
    }

    public void setIsTodayInHistoryDetail(boolean z16) {
        this.mIsTodayInHistoryDetail = z16;
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setNeedFillBlackArea(boolean z16) {
        FeedRecommendFriendsHorizontalCardView feedRecommendFriendsHorizontalCardView = this.mFeedRecommendFriendsHorizontalCardView;
        if (feedRecommendFriendsHorizontalCardView != null) {
            feedRecommendFriendsHorizontalCardView.setNeedFillBlackArea(z16);
        }
        FeedSpecialCare feedSpecialCare = this.mFeedSpecialCare;
        if (feedSpecialCare != null) {
            feedSpecialCare.setNeedFillBlackArea(z16);
        }
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setOnFeedElementClickListener(com.qzone.proxy.feedcomponent.ui.g gVar) {
        this.mOnFeedElementClickListener = gVar;
        for (int i3 = 0; i3 < this.mFeedSections.size(); i3++) {
            FeedViewSection valueAt = this.mFeedSections.valueAt(i3);
            if (valueAt != null) {
                valueAt.setOnFeedElementClickListener(gVar);
            }
        }
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setOnFeedEventListener(com.qzone.proxy.feedcomponent.ui.h hVar) {
        this.mOnFeedEventListener = hVar;
        FeedFriendBirthdayGiftPanel feedFriendBirthdayGiftPanel = this.mFeedFriendBirthdayGiftPanel;
        if (feedFriendBirthdayGiftPanel != null) {
            feedFriendBirthdayGiftPanel.setOnFeedEventListener(hVar);
        }
        FeedViewSection section = getSection(103);
        if (section == null || !(section instanceof FeedBirthdayGiftSection)) {
            return;
        }
        ((FeedBirthdayGiftSection) section).setOnFeedEventListener(hVar);
    }

    @Override // android.view.View
    public void setPadding(int i3, int i16, int i17, int i18) {
        super.setPadding(i3, i16, i17, i18);
    }

    public void setShowDateHeader(boolean z16) {
        this.mShowDateHeader = z16;
    }

    public void setTopDrawable(Drawable drawable) {
        this.mTopDrawable = drawable;
    }

    public void setisPicTop(boolean z16) {
        this.misPicTop = z16;
    }

    public void showFrameLine(boolean z16) {
        this.mShowFrameLine = z16;
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void showSearchSeparator(boolean z16, String str) {
        FeedSearchSeparator feedSearchSeparator;
        if (!this.mCanShowSeparator || (feedSearchSeparator = this.mFeedSearchSeparator) == null) {
            return;
        }
        feedSearchSeparator.setText(str);
        if (z16) {
            this.mFeedSearchSeparator.setVisibility(0);
        } else {
            this.mFeedSearchSeparator.setVisibility(8);
        }
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void startFlashNickName() {
        if (getFeedTitle() != null) {
            getFeedTitle().onStateIdle();
        }
    }

    public void startVideoIfNeed() {
        BusinessFeedData businessFeedData = this.mFeedData;
        if (businessFeedData != null && businessFeedData.getOriginalInfo() != null && this.mFeedData.getOriginalInfo().getVideoInfo() != null) {
            if (getFeedForward() != null) {
                getFeedForward().mAutoVideo.onStateIdle();
            }
        } else {
            BusinessFeedData businessFeedData2 = this.mFeedData;
            if (businessFeedData2 == null || businessFeedData2.getVideoInfo() == null || getFeedContent() == null) {
                return;
            }
            getFeedContent().mAutoVideo.onStateIdle();
        }
    }

    protected void updateFeedSkin() {
        resetFeedSkinData();
        if (this.mFeedData != null && this.mFeedTitle != null && ((canShowFeedSkin() || canShowSpecialFeedSkin()) && this.mFeedData.getCoverInfo() == null && com.qzone.adapter.feedcomponent.i.H().d1())) {
            FeedSkinData cellFeedSkinInfo = this.mFeedData.getCellFeedSkinInfo();
            if (canShowSpecialFeedSkin()) {
                if (!TextUtils.isEmpty(this.mLv10FeedSkinPath)) {
                    if (this.lvTenStaticDrawable == null) {
                        this.lvTenStaticDrawable = new l();
                    }
                    this.lvTenStaticDrawable.g(this.mLv10FeedSkinPath, cellFeedSkinInfo.lv10Numbers);
                    this.mFeedSkinDrawable = ((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getApngDrawable(TAG, "", new ApngOptions(), new File(this.mLv10FeedSkinPath, "top.png").getAbsolutePath());
                    updateLvTenHeight();
                } else if (!TextUtils.isEmpty(this.mLuxuryFeedSkinPath) && this.mLuxuryFeedSkinPath.contains("shp")) {
                    IVasSharpPFactoryForQzone iVasSharpPFactoryForQzone = (IVasSharpPFactoryForQzone) QRoute.api(IVasSharpPFactoryForQzone.class);
                    String str = this.mLuxuryFeedSkinPath;
                    this.mFeedSkinDrawable = iVasSharpPFactoryForQzone.getSharpPURLDrawable(str, str);
                } else if (!TextUtils.isEmpty(this.mLuxuryFeedSkinPath)) {
                    String str2 = this.mLuxuryFeedSkinPath;
                    this.mFeedSkinDrawable = VasApngUtil.getOptimizedApngDrawable(str2, str2, new ColorDrawable(16777215), VasApngUtil.VIP_APNG_TAGS, "luxury_10", null);
                }
                if (this.mFeedSkinDrawable != null) {
                    this.mLuxuryFeedSkinHeight = (int) (getWidth() * 0.37333333f);
                }
            } else if (cellFeedSkinInfo.nSkinType == 392) {
                String str3 = cellFeedSkinInfo.sPicUrl;
                if (str3 != null && !str3.equals(this.mFeedSkinDrawableUrl)) {
                    com.qzone.util.image.c.J(cellFeedSkinInfo.sPicUrl, true, new ImageLoader.ImageLoadListener() { // from class: com.qzone.module.feedcomponent.ui.FeedView.4
                        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
                        public void onImageLoaded(String str4, Drawable drawable, ImageLoader.Options options) {
                            FeedView.this.mFeedSkinDrawable = drawable;
                            FeedView.this.postInvalidate();
                        }

                        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
                        public void onImageCanceled(String str4, ImageLoader.Options options) {
                        }

                        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
                        public void onImageFailed(String str4, ImageLoader.Options options) {
                        }

                        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
                        public void onImageProgress(String str4, float f16, ImageLoader.Options options) {
                        }
                    }, Bitmap.Config.ARGB_8888);
                    this.mFeedSkinDrawableUrl = cellFeedSkinInfo.sPicUrl;
                }
            } else {
                resetFeedSkinData();
            }
            if (com.qzone.adapter.feedcomponent.i.H().p1()) {
                this.mFeedSkinBgPaint.setColor(com.qzone.adapter.feedcomponent.j.m());
                this.mFeedSkinGradientPaint.setColor(com.qzone.adapter.feedcomponent.j.m());
                this.mFeedSkinGradientPaint.setDither(false);
                this.mFeedSkinGradientPaint.setAntiAlias(false);
                this.mFeedSkinGradientPaint.setShader(null);
                return;
            }
            try {
                this.mFeedSkinGradientColorBg = Color.parseColor(cellFeedSkinInfo.strBgColor);
                this.mFeedSkinGradientColorStart = Color.parseColor(cellFeedSkinInfo.strGradientColorBegin);
                this.mFeedSkinGradientColorEnd = Color.parseColor(cellFeedSkinInfo.strGradientColorEnd);
                LinearGradient linearGradient = new LinearGradient(getWidth() / 2, 0.0f, getWidth() / 2, sFeedSkinGradientHeight, this.mFeedSkinGradientColorStart, this.mFeedSkinGradientColorEnd, Shader.TileMode.CLAMP);
                this.mFeedSkinGradientPaint.setDither(true);
                this.mFeedSkinGradientPaint.setAntiAlias(true);
                this.mFeedSkinGradientPaint.setShader(linearGradient);
                this.mFeedSkinBgPaint.setColor(this.mFeedSkinGradientColorBg);
                return;
            } catch (Exception e16) {
                this.mFeedSkinBgPaint.setColor(-1);
                this.mFeedSkinGradientPaint.setColor(-1);
                com.qzone.proxy.feedcomponent.b.c("feedskin", "" + e16);
                return;
            }
        }
        resetFeedSkinData();
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void updateFollowGuide() {
        if (getFeedFollowGuideView() != null) {
            getFeedFollowGuideView().update();
        }
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void updateFollowInfo(BusinessFeedData businessFeedData, long j3, boolean z16) {
        BusinessFeedData businessFeedData2;
        BusinessFeedData businessFeedData3 = this.mFeedData;
        if ((businessFeedData3 == null || businessFeedData3.getUser().uin != j3) && ((businessFeedData2 = this.mFeedData) == null || businessFeedData2.getOriginalInfoSafe() == null || this.mFeedData.getOriginalInfoSafe().getUser().uin != j3)) {
            return;
        }
        FeedViewBuilder.updateFollowInfo(this.mContext, this, this.mFeedData);
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void updateMenuArea(BusinessFeedData businessFeedData) {
        if (getFeedTitle() == null || businessFeedData == null || businessFeedData.getLocalInfo() == null) {
            return;
        }
        getFeedTitle().setCanJoinAlbum(businessFeedData.getLocalInfo().canJoinAlbum);
        getFeedTitle().setJoinedAlbum(businessFeedData.getLocalInfo().joinedAlbum);
        getFeedTitle().update();
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void updateRecommAction(BusinessFeedData businessFeedData) {
        FeedViewBuilder.setRecommActionData(getRecommAction(), businessFeedData);
    }

    public void updateRecommendListInfo(BusinessFeedData businessFeedData) {
        FeedViewBuilder.updateRecommendListInfo(this.mContext, this, businessFeedData);
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void updateTitle(BusinessFeedData businessFeedData, @Deprecated Boolean bool) {
        FeedViewBuilder.updateFeedTitle(this, businessFeedData, bool);
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void updateTransparentBackground(BusinessFeedData businessFeedData) {
        invalidate();
    }

    public boolean useWhiteCommentBg() {
        return canShowFeedSkin();
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        if (this.mTopDrawable != null) {
            return true;
        }
        return super.verifyDrawable(drawable);
    }

    private void inertNewView() {
        for (int i3 = 0; i3 < this.mFeedSections.size(); i3++) {
            FeedViewSection valueAt = this.mFeedSections.valueAt(i3);
            valueAt.viewIdx = getChildCount();
            if (valueAt.haveMultipleViews()) {
                List<View> orGenerateViews = valueAt.getOrGenerateViews(this);
                if (orGenerateViews != null) {
                    for (View view : orGenerateViews) {
                        if (view != null) {
                            if (view.getParent() == null) {
                                addView(view);
                            } else if (view.getParent() != this) {
                                com.qzone.proxy.feedcomponent.b.c(FeedViewSection.TAG, "trying to add view while it has parent " + view.getClass());
                            }
                        }
                    }
                }
            } else {
                tryToInsertViewElement(valueAt, valueAt.getOrGenerateView(this));
            }
            valueAt.onInsertedIntoView();
        }
    }

    private void notifyAllSectionOnStateIdle() {
        for (int i3 = 0; i3 < this.mFeedSections.size(); i3++) {
            if (this.mFeedSections.valueAt(i3) != null) {
                this.mFeedSections.valueAt(i3).onStateIdle();
            }
        }
    }

    private void notifyAllSectionRecycled() {
        for (int i3 = 0; i3 < this.mFeedSections.size(); i3++) {
            FeedViewSection valueAt = this.mFeedSections.valueAt(i3);
            if (valueAt != null && valueAt != this.mFeedContent && valueAt != this.mFeedForward) {
                valueAt.onRecycled();
            }
        }
    }

    private void notifyAllSectionReset() {
        for (int i3 = 0; i3 < this.mFeedSections.size(); i3++) {
            if (this.mFeedSections.valueAt(i3) != null) {
                this.mFeedSections.valueAt(i3).reset();
            }
        }
    }

    private void notifyAllSectionScrolling() {
        for (int i3 = 0; i3 < this.mFeedSections.size(); i3++) {
            if (this.mFeedSections.valueAt(i3) != null) {
                this.mFeedSections.valueAt(i3).onStateScrolling();
            }
        }
    }

    private void notifyAllSectionSetAlpha(int i3) {
        for (int i16 = 0; i16 < this.mFeedSections.size(); i16++) {
            FeedViewSection valueAt = this.mFeedSections.valueAt(i16);
            if (valueAt != null) {
                valueAt.setAlpha(i3);
            }
        }
    }

    private void notifyAllSectionSetData(BusinessFeedData businessFeedData, FeedViewSection.FeedViewOptions feedViewOptions) {
        for (int i3 = 0; i3 < this.mFeedSections.size(); i3++) {
            FeedViewSection valueAt = this.mFeedSections.valueAt(i3);
            if (valueAt != null) {
                valueAt.setFeedData(businessFeedData, feedViewOptions);
            }
        }
    }

    private void resetFeedSkinData() {
        this.mFeedSkinDrawable = null;
        this.mFeedSkinDrawableUrl = null;
        this.mFeedSkinGradientColorBg = -1;
        this.mFeedSkinGradientColorStart = -1;
        this.mFeedSkinGradientColorEnd = -1;
    }

    protected LinearLayout.LayoutParams generateLayoutParams(int i3, int i16, int i17, int i18) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.leftMargin = i3;
        layoutParams.topMargin = i16;
        layoutParams.rightMargin = i17;
        layoutParams.bottomMargin = i18;
        return layoutParams;
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public FeedDateHeader getFeedDateHeader() {
        FeedCommonSection dateHeaderSection = getDateHeaderSection();
        if (dateHeaderSection == null) {
            return null;
        }
        FeedChildView view = dateHeaderSection.getView();
        if (view instanceof FeedDateHeader) {
            return (FeedDateHeader) view;
        }
        return null;
    }

    public FeedSearchNoResultTip getFeedSearchNoResultTip() {
        if (getSection(1) == null) {
            return null;
        }
        FeedChildView view = getSection(1).getView();
        if (view instanceof FeedSearchNoResultTip) {
            return (FeedSearchNoResultTip) view;
        }
        return null;
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void onStateIdle() {
        isIdle = true;
        notifyAllSectionOnStateIdle();
        oldOnStateIdle();
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void onStateScrolling() {
        isIdle = false;
        notifyAllSectionScrolling();
        oldStateScrolling();
    }

    @Deprecated
    private void oldOnStateIdle() {
        final FeedViewSection section;
        if (getFeedOperation() != null) {
            getFeedOperation().updateOperationButtonBackgroud();
        }
        FeedGoods feedGoods = this.mFeedGoods;
        if (feedGoods != null) {
            feedGoods.onStateIdle();
        }
        FeedPlayBarView feedPlayBarView = this.mPlayBarView;
        if (feedPlayBarView != null) {
            feedPlayBarView.onStateIdle();
        }
        if (this.mFeedDate != null) {
            QZoneAdFeedData adData = this.mFeedData.getAdData();
            if (QZoneAdFeedDataExtKt.isBrandOptimizationAdv(this.mFeedData) && (section = getSection(62)) != null && section.getView() != null && (section.getView() instanceof View) && ((View) section.getView()) != null) {
                if (adData.getIsBrandOptimizationShow()) {
                    ((View) section.getView()).setVisibility(0);
                } else {
                    ((View) section.getView()).setVisibility(8);
                }
                ((View) section.getView()).getLocationOnScreen(new int[2]);
                if (r9[1] / FeedGlobalEnv.g().getScreenHeight() <= 0.6d && !adData.getIsBrandOptimizationShow()) {
                    ValueAnimator ofInt = ValueAnimator.ofInt(0, com.qzone.proxy.feedcomponent.util.g.a(68.0f));
                    this.animator = ofInt;
                    ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.qzone.module.feedcomponent.ui.FeedView.9
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            FeedViewSection feedViewSection;
                            if (valueAnimator == null || (feedViewSection = section) == null || feedViewSection.getView() == null || !(section.getView() instanceof View) || ((View) section.getView()) == null) {
                                return;
                            }
                            ((View) section.getView()).getLayoutParams().height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                            ((View) section.getView()).requestLayout();
                        }
                    });
                    this.animator.setDuration(600L);
                    this.animator.start();
                    adData.setBrandOptimizationShow(true);
                }
            }
            BusinessFeedData businessFeedData = this.mFeedData;
            if (businessFeedData.pics != null && QZoneAdFeedDataExtKt.isAddGroupAdv(businessFeedData) && this.mFeedContent.getContentView() != null) {
                if (adData.getIsAddGroupAdShow()) {
                    this.mFeedContent.getContentView().setAddGroupView(this.mFeedData.pics);
                } else {
                    this.mFeedContent.getContentView().gdt_addGroup_container.setVisibility(8);
                    this.mFeedContent.getContentView().gdt_addGroup.setVisibility(8);
                }
                this.mFeedContent.getContentView().getLocationOnScreen(new int[2]);
                if (r2[1] / FeedGlobalEnv.g().getScreenHeight() <= 0.4d && !adData.getIsAddGroupAdShow()) {
                    this.mFeedContent.getContentView().setAddGroupView(this.mFeedData.pics);
                    TranslateAnimation translateAnimation = new TranslateAnimation(1, 1.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f);
                    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                    AnimationSet animationSet = new AnimationSet(false);
                    animationSet.addAnimation(alphaAnimation);
                    animationSet.addAnimation(translateAnimation);
                    animationSet.setDuration(600L);
                    this.mFeedContent.getContentView().gdt_addGroup_container.startAnimation(animationSet);
                    adData.setAddGroupAdShow(true);
                }
            }
        }
        playLuxuryFeedsAnimation();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void tryToInsertViewElement(FeedViewSection feedViewSection, View view) {
        if (view != 0) {
            if (view.getParent() == null) {
                addView(view);
                if (view instanceof IFeedViewElement) {
                    feedViewSection.setSectionController(((IFeedViewElement) view).getSectionController());
                    return;
                }
                return;
            }
            if (view.getParent() != this) {
                com.qzone.proxy.feedcomponent.b.c(FeedViewSection.TAG, "trying to add view while it has parent " + view.getClass());
            }
        }
    }

    public FeedRecommendFriendsHorizontalCardView getRecommendFriendsHorizontalCardView() {
        FeedViewSection section = getSection(102);
        if (section == null || section.isEmpty()) {
            return null;
        }
        return (FeedRecommendFriendsHorizontalCardView) section.obtainView();
    }

    public FeedSpecialCare getSpecialCare() {
        FeedViewSection section = getSection(101);
        if (section == null || section.isEmpty()) {
            return null;
        }
        return (FeedSpecialCare) section.obtainView();
    }

    public void setData(BusinessFeedData businessFeedData, FeedViewSection.FeedViewOptions feedViewOptions) {
        if (businessFeedData != null) {
            this.mFeedData = businessFeedData;
            if (businessFeedData.isAlbumRecFeed()) {
                BusinessFeedData businessFeedData2 = this.mFeedData;
                businessFeedData2.albumRecInfo = AlbumRecReporter.D.c(businessFeedData2.getAlbumRecType());
            }
            feedViewOptions.isTodayInHistoryDetail = this.mIsTodayInHistoryDetail;
            this.mOptions = feedViewOptions;
            notifyAllSectionSetData(businessFeedData, feedViewOptions);
            checkMsgReport();
        }
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setFeedPosition(int i3) {
        setTag(com.qzone.adapter.feedcomponent.j.O(JsonGrayBusiId.AIO_ZPLAN_SCENE_LINKAGE), Integer.valueOf(this.mIndex));
        this.mFeedPosition = i3;
        for (int i16 = 0; i16 < this.mFeedSections.size(); i16++) {
            FeedViewSection valueAt = this.mFeedSections.valueAt(i16);
            if (valueAt != null) {
                valueAt.setFeedPosition(this.mFeedPosition);
            }
        }
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void updateLikeInfo(BusinessFeedData businessFeedData) {
        if (businessFeedData == null) {
            return;
        }
        FeedViewBuilder.updateLikeInfo(this.mContext, this, businessFeedData);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z16) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public View getFollowButtonPos(Rect rect) {
        return this;
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setOnFeedFirstDrawListener(com.qzone.proxy.feedcomponent.ui.i iVar) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView, com.qzone.proxy.feedcomponent.widget.g
    public void onRecycled() {
        onRecycled(true);
    }

    public FeedView(Context context, boolean z16, boolean z17) {
        this(context, z16);
        this.mCanShowSeparator = z17;
        if (z17) {
            this.mFeedSearchSeparator = (FeedSearchSeparator) ((ViewGroup) LayoutInflater.from(context).inflate(com.qzone.adapter.feedcomponent.j.j(1644), this)).findViewById(com.qzone.adapter.feedcomponent.j.O(2242));
        }
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void updateSpecialFollowInfo(BusinessFeedData businessFeedData, long j3, boolean z16) {
    }
}
