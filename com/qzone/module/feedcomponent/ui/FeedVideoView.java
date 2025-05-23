package com.qzone.module.feedcomponent.ui;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.qzone.canvasui.gdtui.prenster.DownloadImmediatelyPresenter;
import com.qzone.canvasui.widget.danmaku.GdtDanmakuPresenter;
import com.qzone.canvasui.widget.danmaku.bubble.GdtBubbleDanmakuPresenter;
import com.qzone.common.activities.base.BaseActivity;
import com.qzone.commoncode.module.gdt.GdtFeedUtilForQZone;
import com.qzone.module.feedcomponent.ui.FeedAutoVideo;
import com.qzone.module.feedcomponent.ui.FeedVideoSensorManager;
import com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleView;
import com.qzone.module.feedcomponent.ui.video.OnFeedVideoElementClickListenerImpl;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellBottomRecomm;
import com.qzone.proxy.feedcomponent.model.CellOperationRegion;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.model.Point;
import com.qzone.proxy.feedcomponent.model.RegionData;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdFeedData;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdFeedDataExtKt;
import com.qzone.proxy.feedcomponent.model.s;
import com.qzone.proxy.feedcomponent.text.CellTextView;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.qzone.shakead.ShakeCaiDanAdManager;
import com.qzone.widget.DrawActionView;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.image.processor.NormalFeedImageProcessor;
import com.tencent.component.media.image.processor.OvalProcessor;
import com.tencent.component.media.image.view.AsyncImageView;
import com.tencent.mobileqq.qzoneplayer.video.AutoVideoProgressRecorder;
import com.tencent.mobileqq.qzoneplayer.video.BaseVideo;
import com.tencent.mobileqq.qzoneplayer.video.BaseVideoManager;
import com.tencent.mobileqq.qzoneplayer.video.VideoPlayInfo;
import com.tencent.mobileqq.qzoneplayer.video.VideoPlayInfoHolder;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.widget.lottie.LottieLoader;
import com.tencent.mobileqq.vip.diy.common.DIYLottieLoader;
import com.tencent.oskplayer.util.PlayerUtils;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FeedVideoView extends FrameLayout implements DrawActionView.a {
    public static final boolean CONFIG_SHOW_PROGRESS_BAR;
    private static final OvalProcessor DEFAULT_OVAL_PROCESSOR = new OvalProcessor();
    public static final int PROGRESS_INIT_VALUE = 0;
    public static final int PROGRESS_MAX_VALUE = 100;
    static final String TAG = "FeedVideoView";
    public static s sVerticalVideoData;
    private RegionData drawActionRegionData;
    private boolean enableRoundedCorner;
    private View.OnClickListener gdtVideoComponentClickListener;
    private boolean isNeedShowCover;
    private boolean isSeeking;
    private TextView mAdvGuideContent;
    private LottieAnimationView mAdvGuideImageView;
    private LottieLoader mAdvGuideLottieLoader;
    private TextView mAdvShaderContent;
    private TextView mAdvShaderContentTitle;
    private LottieAnimationView mAdvShaderImageView;
    private LottieLoader mAdvShaderLottieLoader;
    private String mAoYunLottieUrl;
    private Region mAreaRegion;
    FeedAutoVideo mAutoVideoView;
    private AsyncImageView mAvatarOfGdtAdvRightView;
    private View mBackgroundView;
    private Button mButtonOfGdtAdvRightView;
    private Path mClipPath;
    private DrawActionView mDrawActionView;
    private DrawActionView mDrawGestureAdView;
    private int mEventTagHeight;
    FeedPicTextCardView mEventTagView;
    List<FeedAutoVideo> mFeedAutoViewList;
    BusinessFeedData mFeedData;
    private FeedVideoSensorManager mFeedVideoSensorManager;
    private LinearLayout mGdtAdvRightView;
    private GdtBubbleDanmakuPresenter mGdtBubbleDanmakuPresenter;
    private GdtDanmakuPresenter mGdtFloatDanmakuPresenter;
    private boolean mHasShowAoYunShade;
    int mIndex;
    boolean mInterceptTouchEvent;
    boolean mIsForwardFeed;
    private RectF mLayer;
    protected Handler mMainHandler;
    int mMaxVideoWidth;
    boolean mNeedShowProgressBar;
    private FeedVideoSensorManager.ShakeListener mOnShakeInterface;
    private final FeedAutoVideo.OnVideoPlayStatusListener mOnVideoPlayListener;
    private Paint mPaint;
    int mPostion;
    private ValueAnimator mProgressAnimator;
    private ProgressBar mProgressBar;
    int mRecBusinessFeedDatasSize;
    private TextView mTextOfGdtAdvRightView;
    CellTextView mTextView;
    int mTextViewH;
    private TextView mTitleOfGdtAdvRightView;
    ExFeedTitleView mTitleView;
    private LinearLayout mVideoAdvGuideLayout;
    private LinearLayout mVideoAdvShaderLayout;
    VideoInfo mVideoInfo;
    com.qzone.proxy.feedcomponent.ui.g onFeedElementClickListener;
    private float[] radii;
    private View.OnClickListener rightViewOnClickListener;
    private boolean showGestureAction;
    private int showGestureViewDuration;
    private boolean showProgress;
    int topDiff;
    private RegionData touchedRegionData;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class RoundBlurEffectImageProcessor extends NormalFeedImageProcessor {
        public RoundBlurEffectImageProcessor(int i3, int i16, float f16, float f17) {
            super(i3, i16, f16, f17);
        }

        @Override // com.tencent.component.media.image.processor.NormalFeedImageProcessor, com.tencent.component.media.image.ImageProcessor
        public int getType() {
            return RoundBlurEffectImageProcessor.class.hashCode();
        }

        @Override // com.tencent.component.media.image.processor.NormalFeedImageProcessor, com.tencent.component.media.image.processor.CropByPivotProcessor, com.tencent.component.media.image.ImageProcessor
        public Drawable process(Drawable drawable) {
            Drawable process = super.process(drawable);
            long currentTimeMillis = System.currentTimeMillis();
            Drawable i3 = com.qzone.adapter.feedcomponent.i.H().i(process);
            com.qzone.proxy.feedcomponent.b.e(FeedVideoView.TAG, "blur cost time = " + (System.currentTimeMillis() - currentTimeMillis));
            return i3;
        }
    }

    static {
        CONFIG_SHOW_PROGRESS_BAR = com.qzone.adapter.feedcomponent.h.b("QZoneSetting", "FeedVideoShowProgressBar", 1) != 0;
    }

    public FeedVideoView(Context context) {
        super(context);
        this.mEventTagHeight = com.qzone.proxy.feedcomponent.util.g.a(50.0f);
        this.mFeedAutoViewList = new ArrayList();
        this.mRecBusinessFeedDatasSize = -1;
        this.mInterceptTouchEvent = false;
        this.mMaxVideoWidth = 0;
        this.isNeedShowCover = true;
        this.mNeedShowProgressBar = false;
        this.mMainHandler = new Handler(Looper.getMainLooper());
        this.mHasShowAoYunShade = false;
        this.mOnShakeInterface = new FeedVideoSensorManager.ShakeListener() { // from class: com.qzone.module.feedcomponent.ui.FeedVideoView.9
            @Override // com.qzone.module.feedcomponent.ui.FeedVideoSensorManager.ShakeListener
            public void shake() {
                FeedVideoView.this.hideAoYunShader(false);
                ShakeCaiDanAdManager c16 = ShakeCaiDanAdManager.c();
                FeedVideoView feedVideoView = FeedVideoView.this;
                Context context2 = feedVideoView.getContext();
                Activity topActivity = BaseActivity.getTopActivity();
                FeedVideoView feedVideoView2 = FeedVideoView.this;
                c16.d(feedVideoView, context2, topActivity, feedVideoView2.mFeedData, feedVideoView2.mPostion);
            }
        };
        this.mOnVideoPlayListener = new FeedAutoVideo.OnVideoPlayStatusListener() { // from class: com.qzone.module.feedcomponent.ui.FeedVideoView.10
            @Override // com.qzone.module.feedcomponent.ui.FeedAutoVideo.OnVideoPlayStatusListener
            public void onVideoPlayComplete(BaseVideo baseVideo) {
                if (baseVideo instanceof FeedAutoVideo) {
                    FeedVideoView feedVideoView = FeedVideoView.this;
                    if (feedVideoView.mAutoVideoView != null) {
                        feedVideoView.mMainHandler.post(new Runnable() { // from class: com.qzone.module.feedcomponent.ui.FeedVideoView.10.7
                            @Override // java.lang.Runnable
                            public void run() {
                                FeedVideoView.this.hideDrawActionView();
                                FeedVideoView.this.hideDrawGestureAdView();
                            }
                        });
                        Log.i(FeedVideoView.TAG, "onVideoPlayComplete: ");
                        FeedAutoVideo feedAutoVideo = (FeedAutoVideo) baseVideo;
                        FeedVideoView.this.updateProgress(feedAutoVideo.getmTotalDurationMills(), feedAutoVideo.getmTotalDurationMills(), feedAutoVideo.getmTotalDurationMills());
                    }
                }
                if (FeedGlobalEnv.g().isDebug()) {
                    com.qzone.proxy.feedcomponent.b.e(FeedVideoView.TAG, "[jinqianli] [debug] onVideoPlayComplete()");
                }
                FeedVideoView.this.onVideoStopOrComplete();
            }

            @Override // com.qzone.module.feedcomponent.ui.FeedAutoVideo.OnVideoPlayStatusListener
            public void onVideoPlayStart(BaseVideo baseVideo) {
                FeedVideoView.this.mHasShowAoYunShade = false;
                if (baseVideo instanceof FeedAutoVideo) {
                    FeedVideoView feedVideoView = FeedVideoView.this;
                    if (feedVideoView.mAutoVideoView != null) {
                        if (feedVideoView.showProgress) {
                            FeedVideoView.this.updateProgress(0L, 1L, 0L);
                        }
                        FeedVideoView.this.mMainHandler.post(new Runnable() { // from class: com.qzone.module.feedcomponent.ui.FeedVideoView.10.1
                            @Override // java.lang.Runnable
                            public void run() {
                                FeedVideoView.this.hideDrawActionView();
                                FeedVideoView.this.hideDrawGestureAdView();
                                if (QZoneAdFeedDataExtKt.isDanmakuAdv(FeedVideoView.this.mFeedData)) {
                                    if (QZoneAdFeedDataExtKt.isGdt185AdVideo(FeedVideoView.this.mFeedData)) {
                                        FeedVideoView.this.showBubbleDanmakuAdView();
                                    } else if (QZoneAdFeedDataExtKt.isGdt585AdVideo(FeedVideoView.this.mFeedData)) {
                                        FeedVideoView.this.showFloatDanmakuAdView();
                                    }
                                }
                            }
                        });
                        Log.i(FeedVideoView.TAG, "onVideoPlayStart: ");
                        if (FeedGlobalEnv.g().isDebug()) {
                            com.qzone.proxy.feedcomponent.b.e(FeedVideoView.TAG, "[jinqianli] [debug] onVideoPlayStart()");
                        }
                    }
                }
                BusinessFeedData businessFeedData = FeedVideoView.this.mFeedData;
                if (businessFeedData != null) {
                    businessFeedData.getAdData();
                    if (!FeedVideoView.this.mFeedData.isAdFeeds() || FeedVideoView.this.mFeedData.isBrandUgcAdvFeeds() || TextUtils.isEmpty(QZoneAdFeedDataExtKt.getC2SVideoPlayUrl(FeedVideoView.this.mFeedData)) || TextUtils.isEmpty(QZoneAdFeedDataExtKt.getC2SVideoPlayDuration(FeedVideoView.this.mFeedData)) || !"0".equals(QZoneAdFeedDataExtKt.getC2SVideoPlayDuration(FeedVideoView.this.mFeedData)) || FeedVideoView.this.mFeedData.getOperationInfoV2().IsVideoPlayExpose != 0) {
                        return;
                    }
                    com.qzone.proxy.feedcomponent.b.e(FeedVideoView.TAG, "@adVideoPlayerExpose  onVideoPlayStart =0s");
                    FeedVideoView.this.mFeedData.getOperationInfoV2().IsVideoPlayExpose = 1;
                    com.tencent.gdtad.statistics.a.b(2, 3, GdtFeedUtilForQZone.f(FeedVideoView.this.mFeedData));
                }
            }

            @Override // com.qzone.module.feedcomponent.ui.FeedAutoVideo.OnVideoPlayStatusListener
            public void onVideoPlayStop(BaseVideo baseVideo) {
                if (FeedGlobalEnv.g().isDebug()) {
                    com.qzone.proxy.feedcomponent.b.e(FeedVideoView.TAG, "[onVideoPlayStop]");
                }
                FeedVideoView.this.onVideoStopOrComplete();
            }

            @Override // com.qzone.module.feedcomponent.ui.FeedAutoVideo.OnVideoPlayStatusListener
            public void onVideoPlayProgressUpdate(BaseVideo baseVideo) {
                VideoInfo videoInfo;
                String str;
                int i3;
                if (!(baseVideo instanceof FeedAutoVideo) || FeedVideoView.this.mAutoVideoView == null) {
                    return;
                }
                FeedAutoVideo feedAutoVideo = (FeedAutoVideo) baseVideo;
                long j3 = feedAutoVideo.getmCurPositionMills();
                final long j16 = feedAutoVideo.getmTotalDurationMills();
                long j17 = j16 - j3;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("onVideoPlayProgressUpdate: ");
                sb5.append(j3);
                sb5.append("/");
                sb5.append(j16);
                sb5.append(" ");
                sb5.append(baseVideo == FeedVideoView.this.mAutoVideoView);
                Log.i(FeedVideoView.TAG, sb5.toString());
                FeedVideoView feedVideoView = FeedVideoView.this;
                BusinessFeedData businessFeedData = feedVideoView.mFeedData;
                if (businessFeedData != null && feedVideoView.onFeedElementClickListener != null && businessFeedData.isAdFeeds() && !FeedVideoView.this.mFeedData.isBrandUgcAdvFeeds() && !TextUtils.isEmpty(QZoneAdFeedDataExtKt.getC2SVideoPlayDuration(FeedVideoView.this.mFeedData)) && !"0".equals(QZoneAdFeedDataExtKt.getC2SVideoPlayDuration(FeedVideoView.this.mFeedData)) && !TextUtils.isEmpty(QZoneAdFeedDataExtKt.getC2SVideoPlayUrl(FeedVideoView.this.mFeedData)) && FeedVideoView.this.mFeedData.getOperationInfoV2().IsVideoPlayExpose == 0) {
                    try {
                        i3 = Integer.parseInt(QZoneAdFeedDataExtKt.getC2SVideoPlayDuration(FeedVideoView.this.mFeedData));
                    } catch (Exception e16) {
                        com.qzone.proxy.feedcomponent.b.c(FeedVideoView.TAG, "@adVideoPlayerExpose Integer.parseIn playduration erro" + e16);
                        i3 = 0;
                    }
                    long j18 = j3 / 1000;
                    int i16 = i3 / 1000;
                    if (i16 != 0 && i16 == j18) {
                        com.qzone.proxy.feedcomponent.b.e(FeedVideoView.TAG, "@adVideoPlayerExpose  onVideoPlayProgressUpdate playduration is " + i16);
                        FeedVideoView.this.mFeedData.getOperationInfoV2().IsVideoPlayExpose = 1;
                        com.tencent.gdtad.statistics.a.b(2, 3, GdtFeedUtilForQZone.f(FeedVideoView.this.mFeedData));
                    }
                }
                if (FeedVideoView.this.showGestureAction && j16 > FeedVideoView.this.showGestureViewDuration && j17 < FeedVideoView.this.showGestureViewDuration) {
                    FeedVideoView.this.mMainHandler.post(new Runnable() { // from class: com.qzone.module.feedcomponent.ui.FeedVideoView.10.2
                        @Override // java.lang.Runnable
                        public void run() {
                            FeedVideoView.this.showDrawActionView();
                        }
                    });
                    if (!FeedVideoView.this.isSeeking && j17 < 2000 && ((videoInfo = FeedVideoView.this.mVideoInfo) == null || (str = videoInfo.videoId) == null || !str.equals(com.qzone.adapter.feedcomponent.i.H().p0()))) {
                        FeedVideoView.this.isSeeking = true;
                        Log.i(FeedVideoView.TAG, "onVideoPlayProgressUpdate: ready to seek");
                        FeedVideoView.this.mMainHandler.postDelayed(new Runnable() { // from class: com.qzone.module.feedcomponent.ui.FeedVideoView.10.3
                            @Override // java.lang.Runnable
                            public void run() {
                                if (FeedVideoView.this.isSeeking) {
                                    FeedVideoView.this.mAutoVideoView.seekTo(j16 - r0.showGestureViewDuration);
                                    FeedVideoView.this.isSeeking = false;
                                }
                            }
                        }, j17 - 500);
                    }
                }
                if (FeedVideoView.this.isNeedHideShakeMaskView(j3)) {
                    FeedVideoView.this.mHasShowAoYunShade = false;
                }
                if (FeedVideoView.this.isNeedShowShakeMaskView(j3)) {
                    FeedVideoView.this.mHasShowAoYunShade = true;
                    FeedVideoView.this.mMainHandler.post(new Runnable() { // from class: com.qzone.module.feedcomponent.ui.FeedVideoView.10.4
                        @Override // java.lang.Runnable
                        public void run() {
                            FeedVideoView.this.showShakeMaskView();
                        }
                    });
                }
                BusinessFeedData businessFeedData2 = FeedVideoView.this.mFeedData;
                if (businessFeedData2 != null) {
                    QZoneAdFeedData adData = businessFeedData2.getAdData();
                    if (QZoneAdFeedDataExtKt.isGestureAd(FeedVideoView.this.mFeedData) && QZoneAdFeedDataExtKt.isGdt185AdVideo(FeedVideoView.this.mFeedData) && j16 > adData.getGestureAdEndTime() * 1000 && j3 > adData.getGestureAdBeginTime() * 1000 && j3 < adData.getGestureAdEndTime() * 1000) {
                        FeedVideoView.this.mMainHandler.post(new Runnable() { // from class: com.qzone.module.feedcomponent.ui.FeedVideoView.10.5
                            @Override // java.lang.Runnable
                            public void run() {
                                FeedVideoView.this.showDrawGestureAdView();
                            }
                        });
                    }
                    if (QZoneAdFeedDataExtKt.isGestureAd(FeedVideoView.this.mFeedData) && QZoneAdFeedDataExtKt.isGdt185AdVideo(FeedVideoView.this.mFeedData) && (j3 < adData.getGestureAdBeginTime() * 1000 || j3 > adData.getGestureAdEndTime() * 1000)) {
                        FeedVideoView.this.mMainHandler.post(new Runnable() { // from class: com.qzone.module.feedcomponent.ui.FeedVideoView.10.6
                            @Override // java.lang.Runnable
                            public void run() {
                                FeedVideoView.this.hideDrawGestureAdView();
                            }
                        });
                    }
                }
                if (FeedVideoView.this.showProgress) {
                    FeedVideoView.this.updateProgress(j3, j16, feedAutoVideo.getmLastValidPositionMills());
                }
            }
        };
        this.enableRoundedCorner = false;
        this.radii = new float[8];
        this.rightViewOnClickListener = new View.OnClickListener() { // from class: com.qzone.module.feedcomponent.ui.FeedVideoView.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FeedElement feedElement;
                EventCollector.getInstance().onViewClickedBefore(view);
                if (view != null) {
                    FeedVideoView feedVideoView = FeedVideoView.this;
                    if (feedVideoView.onFeedElementClickListener != null) {
                        if (view.equals(feedVideoView.mAvatarOfGdtAdvRightView)) {
                            feedElement = FeedElement.USER_AVATAR;
                        } else if (view.equals(FeedVideoView.this.mTitleOfGdtAdvRightView)) {
                            feedElement = FeedElement.USER_NICKNAME;
                        } else if (view.equals(FeedVideoView.this.mTextOfGdtAdvRightView)) {
                            feedElement = FeedElement.SUMMARY;
                        } else if (view.equals(FeedVideoView.this.mButtonOfGdtAdvRightView)) {
                            feedElement = FeedElement.RECOMM_CLOSE;
                        } else {
                            feedElement = FeedElement.NOTHING;
                        }
                        FeedVideoView feedVideoView2 = FeedVideoView.this;
                        feedVideoView2.onFeedElementClickListener.onClick(feedVideoView2, feedElement, feedVideoView2.mPostion, null);
                    }
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        };
        this.gdtVideoComponentClickListener = new View.OnClickListener() { // from class: com.qzone.module.feedcomponent.ui.FeedVideoView.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FeedElement feedElement;
                EventCollector.getInstance().onViewClickedBefore(view);
                if (view != null) {
                    FeedVideoView feedVideoView = FeedVideoView.this;
                    if (feedVideoView.onFeedElementClickListener != null) {
                        if (!view.equals(feedVideoView.mGdtFloatDanmakuPresenter) && !view.equals(FeedVideoView.this.mGdtBubbleDanmakuPresenter)) {
                            feedElement = FeedElement.NOTHING;
                        } else {
                            feedElement = FeedElement.GDT_DANMAKU_AD_COMPONENT;
                        }
                        FeedVideoView feedVideoView2 = FeedVideoView.this;
                        feedVideoView2.onFeedElementClickListener.onClick(feedVideoView2, feedElement, feedVideoView2.mPostion, null);
                    }
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        };
        initUI(context);
        setFocusable(true);
        setFocusableInTouchMode(true);
    }

    private void addAdGuideView() {
        if (this.mVideoAdvGuideLayout == null) {
            this.mVideoAdvGuideLayout = (LinearLayout) LayoutInflater.from(getContext()).inflate(com.qzone.adapter.feedcomponent.j.j(1722), (ViewGroup) null);
        }
        LinearLayout linearLayout = this.mVideoAdvGuideLayout;
        if (linearLayout != null) {
            if (linearLayout.getParent() == null) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, ViewUtils.dpToPx(45.0f));
                layoutParams.gravity = 80;
                addView(this.mVideoAdvGuideLayout, layoutParams);
            }
            this.mVideoAdvGuideLayout.setVisibility(4);
            LottieAnimationView lottieAnimationView = (LottieAnimationView) this.mVideoAdvGuideLayout.findViewById(com.qzone.adapter.feedcomponent.j.O(2912));
            this.mAdvGuideImageView = lottieAnimationView;
            lottieAnimationView.setScaleType(ImageView.ScaleType.FIT_XY);
            this.mAdvGuideImageView.setRepeatCount(-1);
            this.mAdvGuideImageView.setRepeatMode(1);
            TextView textView = (TextView) this.mVideoAdvGuideLayout.findViewById(com.qzone.adapter.feedcomponent.j.O(2913));
            this.mAdvGuideContent = textView;
            textView.setText("\u6447\u52a8\u624b\u673a");
        }
    }

    private void addAdView() {
        if (this.mVideoAdvShaderLayout == null) {
            this.mVideoAdvShaderLayout = (LinearLayout) LayoutInflater.from(getContext()).inflate(com.qzone.adapter.feedcomponent.j.j(1721), (ViewGroup) null);
        }
        LinearLayout linearLayout = this.mVideoAdvShaderLayout;
        if (linearLayout != null) {
            if (linearLayout.getParent() == null) {
                addView(this.mVideoAdvShaderLayout, new FrameLayout.LayoutParams(-1, -1));
            }
            this.mVideoAdvShaderLayout.setVisibility(4);
            LottieAnimationView lottieAnimationView = (LottieAnimationView) this.mVideoAdvShaderLayout.findViewById(com.qzone.adapter.feedcomponent.j.O(2909));
            this.mAdvShaderImageView = lottieAnimationView;
            lottieAnimationView.setRepeatCount(-1);
            this.mAdvShaderImageView.setRepeatMode(1);
            this.mAdvShaderImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            this.mAdvShaderContentTitle = (TextView) this.mVideoAdvShaderLayout.findViewById(com.qzone.adapter.feedcomponent.j.O(2910));
            this.mAdvShaderContent = (TextView) this.mVideoAdvShaderLayout.findViewById(com.qzone.adapter.feedcomponent.j.O(2911));
        }
    }

    private void addGdtRightView() {
        if (this.mGdtAdvRightView == null) {
            this.mGdtAdvRightView = (LinearLayout) LayoutInflater.from(getContext()).inflate(com.qzone.adapter.feedcomponent.j.j(1719), (ViewGroup) null);
        }
        LinearLayout linearLayout = this.mGdtAdvRightView;
        if (linearLayout != null) {
            if (linearLayout.getParent() == null) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                layoutParams.gravity = 5;
                layoutParams.setMargins(0, 0, AreaManager.FEED_INTERVAL, 0);
                addView(this.mGdtAdvRightView, layoutParams);
            }
            AsyncImageView asyncImageView = (AsyncImageView) this.mGdtAdvRightView.findViewById(com.qzone.adapter.feedcomponent.j.O(BaseConstants.CODE_SEND_WITH_NO_AUTH_ERROR));
            this.mAvatarOfGdtAdvRightView = asyncImageView;
            asyncImageView.setAsyncImageProcessor(DEFAULT_OVAL_PROCESSOR);
            this.mTitleOfGdtAdvRightView = (TextView) this.mGdtAdvRightView.findViewById(com.qzone.adapter.feedcomponent.j.O(2903));
            this.mTextOfGdtAdvRightView = (TextView) this.mGdtAdvRightView.findViewById(com.qzone.adapter.feedcomponent.j.O(2904));
            Button button = (Button) this.mGdtAdvRightView.findViewById(com.qzone.adapter.feedcomponent.j.O(2905));
            this.mButtonOfGdtAdvRightView = button;
            button.setOnClickListener(this.rightViewOnClickListener);
            this.mAvatarOfGdtAdvRightView.setOnClickListener(this.rightViewOnClickListener);
            this.mTitleOfGdtAdvRightView.setOnClickListener(this.rightViewOnClickListener);
            this.mTextOfGdtAdvRightView.setOnClickListener(this.rightViewOnClickListener);
            this.mGdtAdvRightView.setOnClickListener(this.rightViewOnClickListener);
        }
    }

    private int calculateVerticalVideoMaxWidth(float f16, float f17) {
        int screenWidth = FeedGlobalEnv.g().getScreenWidth() - (AreaManager.FEED_INTERVAL * 2);
        int screenHeight = FeedGlobalEnv.g().getScreenHeight() - AreaManager.DEFAULT_TITLEBAR_HEIGHT;
        int i3 = screenWidth / 2;
        int i16 = sVerticalVideoData.f50438a;
        if (i16 == 1) {
            float f18 = (r4.f50439b / 100.0f) * screenWidth;
            if (((int) ((f18 / f16) * f17)) >= screenHeight) {
                f18 = (int) ((screenHeight / f17) * f16);
            }
            return (int) f18;
        }
        if (i16 != 2) {
            return i3;
        }
        int i17 = (int) ((((((r4.f50439b * screenWidth) / 100.0f) * r4.f50441d) / r4.f50440c) / f17) * f16);
        return i17 >= screenWidth ? screenWidth : i17;
    }

    private DIYLottieLoader createLottieLoader() {
        DIYLottieLoader dIYLottieLoader = new DIYLottieLoader(getContext());
        dIYLottieLoader.setMemoryCacheSize((int) (sy3.b.a() / 2));
        return dIYLottieLoader;
    }

    public static s getVerticalVideo() {
        s sVar = sVerticalVideoData;
        return sVar == null ? com.qzone.adapter.feedcomponent.i.H().H0() : sVar;
    }

    private boolean hasEventTagInForwardArea(BusinessFeedData businessFeedData) {
        return (!this.mIsForwardFeed || this.mEventTagView == null || businessFeedData == null || businessFeedData.getOriginalInfo() == null || businessFeedData.getOriginalInfo().getCellBottomRecomm() == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideDrawActionView() {
        DrawActionView drawActionView = this.mDrawActionView;
        if (drawActionView != null) {
            drawActionView.a();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mDrawActionView.getLayoutParams();
            layoutParams.width = 1;
            layoutParams.height = 1;
            this.mDrawActionView.setLayoutParams(layoutParams);
            this.mDrawActionView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideDrawGestureAdView() {
        DrawActionView drawActionView = this.mDrawGestureAdView;
        if (drawActionView != null) {
            drawActionView.a();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mDrawGestureAdView.getLayoutParams();
            layoutParams.width = 1;
            layoutParams.height = 1;
            this.mDrawGestureAdView.setLayoutParams(layoutParams);
            this.mDrawGestureAdView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isNeedHideShakeMaskView(long j3) {
        return ih.j.o(this.mFeedData) && j3 < ((long) ih.j.e(this.mFeedData)) && this.mHasShowAoYunShade;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isNeedShowShakeMaskView(long j3) {
        return ih.j.o(this.mFeedData) && j3 > ((long) ih.j.e(this.mFeedData)) && !this.mHasShowAoYunShade;
    }

    private boolean needHandleVerticalVideo() {
        int i3;
        s sVar = sVerticalVideoData;
        return (sVar == null || (i3 = sVar.f50438a) == -1 || i3 == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onVideoStopOrComplete() {
        Handler handler = this.mMainHandler;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.qzone.module.feedcomponent.ui.FeedVideoView.11
                @Override // java.lang.Runnable
                public void run() {
                    if (ih.j.o(FeedVideoView.this.mFeedData)) {
                        FeedVideoView.this.mVideoAdvGuideLayout.setVisibility(0);
                        FeedVideoView.this.mVideoAdvShaderLayout.setVisibility(4);
                    }
                }
            });
        }
    }

    private boolean setEventTagInfo(BusinessFeedData businessFeedData) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mEventTagView.getLayoutParams();
        if (shouldDisplayBlurBackground(this.mFeedData, this.mVideoInfo)) {
            layoutParams.leftMargin = AreaManager.FEED_INTERVAL;
        }
        layoutParams.topMargin = AreaConst.dp5;
        this.mEventTagView.setLayoutParams(layoutParams);
        this.mEventTagView.setVisibility(0);
        this.mEventTagView.setEventTagInOriginalArea();
        CellBottomRecomm cellBottomRecomm = businessFeedData.getOriginalInfo().getCellBottomRecomm();
        cellBottomRecomm.preCalculate();
        this.mEventTagView.setData(businessFeedData, cellBottomRecomm, 0);
        FeedPicTextCardView feedPicTextCardView = this.mEventTagView;
        if (feedPicTextCardView instanceof FeedPicTextCardSmallTailView) {
            this.mEventTagHeight = ((FeedPicTextCardSmallTailView) feedPicTextCardView).getViewHeight();
        }
        this.mEventTagView.requestLayout();
        return this.mEventTagView.getVisibility() != 8;
    }

    private void setGdtRightInfo(BusinessFeedData businessFeedData) {
        String str;
        String str2;
        if (this.mTitleOfGdtAdvRightView == null || this.mAvatarOfGdtAdvRightView == null || this.mTextOfGdtAdvRightView == null || this.mButtonOfGdtAdvRightView == null || this.mFeedData == null) {
            return;
        }
        if (com.qzone.adapter.feedcomponent.i.H().p1()) {
            this.mTitleOfGdtAdvRightView.setTextColor(Color.parseColor("#FFFFFFFF"));
            this.mTextOfGdtAdvRightView.setTextColor(Color.parseColor("#66FFFFFF"));
            int parseColor = Color.parseColor("#FF0071FF");
            Drawable background = this.mButtonOfGdtAdvRightView.getBackground();
            if (background != null) {
                background.setColorFilter(parseColor, PorterDuff.Mode.SRC_ATOP);
                this.mButtonOfGdtAdvRightView.setBackground(background);
            }
            this.mButtonOfGdtAdvRightView.setTextColor(Color.parseColor("#FFFFFFFF"));
            this.mGdtAdvRightView.setBackgroundColor(Color.parseColor("#FF1F1F1F"));
        }
        if (this.mFeedData.getUser() != null) {
            this.mAvatarOfGdtAdvRightView.setAsyncImage(this.mFeedData.getUser().logo);
        }
        if (this.mFeedData.getOperationInfoV2() != null) {
            this.mTitleOfGdtAdvRightView.setText(this.mFeedData.getOperationInfoV2().title);
            this.mTextOfGdtAdvRightView.setText(this.mFeedData.getOperationInfoV2().summary);
        }
        String str3 = this.mFeedData.getOperationInfoV2() == null ? null : this.mFeedData.getOperationInfoV2().appid;
        if (this.mFeedData.getRecommAction() != null) {
            str = this.mFeedData.getRecommAction().buttonText;
            str2 = this.mFeedData.getRecommAction().installed_buttontxt;
        } else {
            str = "";
            str2 = "";
        }
        if (FeedGlobalEnv.g().checkHasInstallPackage(getContext(), str3)) {
            str = !TextUtils.isEmpty(str2) ? str2 : DownloadImmediatelyPresenter.openText;
        } else if (TextUtils.isEmpty(str)) {
            str = DownloadImmediatelyPresenter.downloadText;
        }
        this.mButtonOfGdtAdvRightView.setText(str);
    }

    public static final void setViewVisibility(View view, int i3) {
        if (view.getVisibility() != i3) {
            view.setVisibility(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showBubbleDanmakuAdView() {
        final String[] danmakuAdContents = this.mFeedData.getAdData().getDanmakuAdContents();
        if (danmakuAdContents == null || danmakuAdContents.length == 0) {
            return;
        }
        GdtBubbleDanmakuPresenter gdtBubbleDanmakuPresenter = this.mGdtBubbleDanmakuPresenter;
        if (gdtBubbleDanmakuPresenter == null) {
            this.mGdtBubbleDanmakuPresenter = new GdtBubbleDanmakuPresenter(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.leftMargin = com.qzone.proxy.feedcomponent.util.g.a(7.0f);
            addView(this.mGdtBubbleDanmakuPresenter, layoutParams);
            this.mGdtBubbleDanmakuPresenter.setContentDescription("\u6c14\u6ce1\u5f39\u5e55");
            this.mGdtBubbleDanmakuPresenter.setOnClickListener(this.gdtVideoComponentClickListener);
            com.qzone.proxy.feedcomponent.b.e("GdtBubbleDanmakuContainer", "GdtBubbleDanmakuContainer has been initialized");
        } else if (gdtBubbleDanmakuPresenter.getVisibility() == 0) {
            com.qzone.proxy.feedcomponent.b.e("GdtBubbleDanmakuContainer", "GdtBubbleDanmakuContainer is already visible");
            return;
        }
        if (!updateBubbleDanmakuAdViewSize()) {
            this.mAutoVideoView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.qzone.module.feedcomponent.ui.FeedVideoView.5
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (FeedVideoView.this.updateBubbleDanmakuAdViewSize()) {
                        FeedVideoView.this.mAutoVideoView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        FeedVideoView.this.mGdtBubbleDanmakuPresenter.initDanmakuItemViews(danmakuAdContents);
                        FeedVideoView.this.mGdtBubbleDanmakuPresenter.start();
                        FeedVideoView.this.mGdtBubbleDanmakuPresenter.setVisibility(0);
                    }
                }
            });
            return;
        }
        this.mGdtBubbleDanmakuPresenter.initDanmakuItemViews(danmakuAdContents);
        this.mGdtBubbleDanmakuPresenter.start();
        this.mGdtBubbleDanmakuPresenter.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDrawActionView() {
        CellOperationRegion cellOperationRegion;
        String str;
        BusinessFeedData businessFeedData = this.mFeedData;
        if (businessFeedData != null) {
            cellOperationRegion = businessFeedData.cellOperationRegion;
            if (cellOperationRegion != null) {
                if (cellOperationRegion.interactiveType == 1) {
                    List<RegionData> list = cellOperationRegion.regions;
                    if (list != null && !list.isEmpty()) {
                        DrawActionView drawActionView = this.mDrawActionView;
                        if (drawActionView == null) {
                            DrawActionView drawActionView2 = new DrawActionView(getContext());
                            this.mDrawActionView = drawActionView2;
                            drawActionView2.setContentDescription("\u89c6\u9891\u624b\u52bf");
                            addView(this.mDrawActionView, new FrameLayout.LayoutParams(1, 1));
                            this.mDrawActionView.setDrawActionListener(this);
                            this.mDrawActionView.setBgColor(1358954496);
                        } else {
                            drawActionView.setDrawActionListener(this);
                            if (this.mDrawActionView.getVisibility() == 0) {
                                return;
                            } else {
                                this.mDrawActionView.setVisibility(0);
                            }
                        }
                        this.mDrawActionView.setLineStyle(cellOperationRegion.gestureLineColor, AreaConst.dp12);
                        ArrayList arrayList = new ArrayList(list.size());
                        for (RegionData regionData : list) {
                            if (regionData.leftTopP == null) {
                                com.qzone.proxy.feedcomponent.b.e(TAG, "showDrawActionView: null region");
                            } else {
                                Point point = regionData.leftTopP;
                                arrayList.add(new android.graphics.Point(point.f50265x, point.f50266y));
                            }
                        }
                        int a16 = com.qzone.proxy.feedcomponent.util.g.a(cellOperationRegion.gestureRadius / 2.0f);
                        this.mDrawActionView.setData(arrayList, 1000, 1000, a16, false);
                        com.qzone.proxy.feedcomponent.b.e(TAG, "showDrawActionView: set data " + arrayList.size() + " " + a16);
                        com.qzone.adapter.feedcomponent.i.H().k2(this.mFeedData, this.mPostion, 214, 19);
                        if (updateDrawActionViewSize()) {
                            return;
                        }
                        this.mAutoVideoView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.qzone.module.feedcomponent.ui.FeedVideoView.2
                            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                            public void onGlobalLayout() {
                                if (FeedVideoView.this.updateDrawActionViewSize()) {
                                    FeedVideoView.this.mAutoVideoView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                                }
                            }
                        });
                        return;
                    }
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("showDrawActionView: null or empty region data ");
                    sb5.append(list == null);
                    com.qzone.proxy.feedcomponent.b.e(TAG, sb5.toString());
                    return;
                }
            }
        } else {
            cellOperationRegion = null;
        }
        StringBuilder sb6 = new StringBuilder();
        sb6.append("showDrawActionView: null feed data or wrong operation data ");
        if (this.mFeedData == null) {
            str = "null";
        } else if (cellOperationRegion == null) {
            str = "nonnull null";
        } else {
            str = "nonnull nonnull";
        }
        sb6.append(str);
        com.qzone.proxy.feedcomponent.b.e(TAG, sb6.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDrawGestureAdView() {
        DrawActionView drawActionView = this.mDrawGestureAdView;
        if (drawActionView == null) {
            DrawActionView drawActionView2 = new DrawActionView(getContext());
            this.mDrawGestureAdView = drawActionView2;
            drawActionView2.setContentDescription("\u89c6\u9891\u624b\u52bf");
            addView(this.mDrawGestureAdView, new FrameLayout.LayoutParams(1, 1));
            this.mDrawGestureAdView.setBgColor(1358954496);
        } else if (drawActionView.getVisibility() == 0) {
            return;
        } else {
            this.mDrawGestureAdView.setVisibility(0);
        }
        this.mDrawGestureAdView.setDrawActionListener(this);
        this.mDrawGestureAdView.setLineStyle(-1, AreaConst.dp6);
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new android.graphics.Point(0, 0));
        int a16 = com.qzone.proxy.feedcomponent.util.g.a(500.0f);
        this.mDrawGestureAdView.setData(arrayList, 1000, 1000, a16, false);
        com.qzone.proxy.feedcomponent.b.e(TAG, "showDrawGestureAdView: set data " + arrayList.size() + " " + a16);
        if (updateDrawGestureAdViewSize()) {
            return;
        }
        this.mAutoVideoView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.qzone.module.feedcomponent.ui.FeedVideoView.3
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (FeedVideoView.this.updateDrawGestureAdViewSize()) {
                    FeedVideoView.this.mAutoVideoView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showFloatDanmakuAdView() {
        final String[] danmakuAdContents = this.mFeedData.getAdData().getDanmakuAdContents();
        if (danmakuAdContents == null || danmakuAdContents.length == 0) {
            return;
        }
        GdtDanmakuPresenter gdtDanmakuPresenter = this.mGdtFloatDanmakuPresenter;
        if (gdtDanmakuPresenter == null) {
            this.mGdtFloatDanmakuPresenter = new GdtDanmakuPresenter(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = com.qzone.proxy.feedcomponent.util.g.a(7.0f);
            addView(this.mGdtFloatDanmakuPresenter, layoutParams);
            this.mGdtFloatDanmakuPresenter.setContentDescription("\u6d6e\u52a8\u5f39\u5e55");
            this.mGdtFloatDanmakuPresenter.setClickable(false);
        } else if (gdtDanmakuPresenter.getVisibility() == 0) {
            return;
        }
        if (!updateFloatDanmakuAdViewSize()) {
            this.mAutoVideoView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.qzone.module.feedcomponent.ui.FeedVideoView.4
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (FeedVideoView.this.updateFloatDanmakuAdViewSize()) {
                        FeedVideoView.this.mAutoVideoView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        FeedVideoView.this.mGdtFloatDanmakuPresenter.initDanmakuItemViews(FeedVideoView.this.mAutoVideoView.getWidth(), danmakuAdContents);
                        if (FeedVideoView.this.mGdtFloatDanmakuPresenter.start()) {
                            FeedVideoView.this.mGdtFloatDanmakuPresenter.setVisibility(0);
                        } else {
                            com.qzone.proxy.feedcomponent.b.e(FeedVideoView.TAG, "mGdtFloatDanmakuPresenter cannot start");
                            FeedVideoView.this.mGdtFloatDanmakuPresenter.setVisibility(8);
                        }
                    }
                }
            });
            return;
        }
        this.mGdtFloatDanmakuPresenter.initDanmakuItemViews(this.mAutoVideoView.getWidth(), danmakuAdContents);
        if (this.mGdtFloatDanmakuPresenter.start()) {
            this.mGdtFloatDanmakuPresenter.setVisibility(0);
        } else {
            com.qzone.proxy.feedcomponent.b.e(TAG, "mGdtFloatDanmakuPresenter cannot start");
            this.mGdtFloatDanmakuPresenter.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showShakeMaskView() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(500L);
        this.mVideoAdvShaderLayout.startAnimation(alphaAnimation);
        this.mVideoAdvShaderLayout.setVisibility(0);
        startAoYunShadeLottie();
        AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
        this.mVideoAdvGuideLayout.startAnimation(alphaAnimation2);
        alphaAnimation2.setAnimationListener(new Animation.AnimationListener() { // from class: com.qzone.module.feedcomponent.ui.FeedVideoView.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                FeedVideoView.this.mVideoAdvGuideLayout.setVisibility(4);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        this.mMainHandler.postDelayed(new Runnable() { // from class: com.qzone.module.feedcomponent.ui.FeedVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                FeedVideoView.this.hideAoYunShader(true);
            }
        }, ih.j.d(this.mFeedData));
    }

    private void startAoYunGuideLottie() {
        LottieLoader lottieLoader;
        if (TextUtils.isEmpty(this.mAoYunLottieUrl) || (lottieLoader = this.mAdvGuideLottieLoader) == null) {
            return;
        }
        lottieLoader.fromNetworkWithCacheBitmap(this.mAdvGuideImageView, this.mAoYunLottieUrl, LottieLoader.makeApolloZipPath(this.mAoYunLottieUrl + "guide"), true);
    }

    private void startAoYunShadeLottie() {
        LottieLoader lottieLoader;
        if (TextUtils.isEmpty(this.mAoYunLottieUrl) || (lottieLoader = this.mAdvShaderLottieLoader) == null) {
            return;
        }
        lottieLoader.fromNetworkWithCacheBitmap(this.mAdvShaderImageView, this.mAoYunLottieUrl, LottieLoader.makeApolloZipPath(this.mAoYunLottieUrl + "shader"), true);
    }

    private void updateAoYunAdvInfo() {
        if (ih.j.o(this.mFeedData)) {
            if (this.mAdvShaderLottieLoader == null) {
                this.mAdvShaderLottieLoader = createLottieLoader();
            }
            if (this.mAdvGuideLottieLoader == null) {
                this.mAdvGuideLottieLoader = createLottieLoader();
            }
            String b16 = ih.j.b(this.mFeedData);
            String a16 = ih.j.a(this.mFeedData);
            this.mVideoAdvGuideLayout.setVisibility(0);
            try {
                JSONObject jSONObject = new JSONObject(b16);
                this.mAdvShaderContentTitle.setText(jSONObject.optString("title"));
                this.mAdvShaderContent.setText(jSONObject.optString("description"));
                this.mAoYunLottieUrl = jSONObject.optString("shake_lottie_animation");
                startAoYunGuideLottie();
                ShakeCaiDanAdManager.c().h(jSONObject.optString("transition_animation_url"));
                ShakeCaiDanAdManager.c().h(new JSONObject(a16).optString("drop_animation_url"));
                if (this.mFeedVideoSensorManager == null) {
                    this.mFeedVideoSensorManager = new FeedVideoSensorManager();
                }
                this.mFeedVideoSensorManager.register(getContext(), this.mOnShakeInterface);
            } catch (Exception e16) {
                com.qzone.proxy.feedcomponent.b.c(TAG, "parse json error " + e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean updateBubbleDanmakuAdViewSize() {
        int width = this.mAutoVideoView.getWidth();
        if (width == 0) {
            return false;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mGdtBubbleDanmakuPresenter.getLayoutParams();
        layoutParams.height = com.qzone.proxy.feedcomponent.util.g.a(90.0f);
        layoutParams.width = width;
        layoutParams.gravity = 80;
        Log.i(TAG, "updateBubbleDanmakuAdViewSize: reset width " + width);
        this.mGdtBubbleDanmakuPresenter.setLayoutParams(layoutParams);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean updateDrawActionViewSize() {
        int width = this.mAutoVideoView.getWidth();
        int height = this.mAutoVideoView.getHeight();
        if (width == 0 || height == 0) {
            return false;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mAutoVideoView.getLayoutParams();
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.mDrawActionView.getLayoutParams();
        layoutParams2.width = this.mAutoVideoView.getWidth();
        layoutParams2.height = this.mAutoVideoView.getHeight();
        layoutParams2.gravity = layoutParams.gravity;
        layoutParams2.topMargin = layoutParams.topMargin;
        layoutParams2.leftMargin = layoutParams.leftMargin;
        Log.i(TAG, "updateDrawActionViewSize: reset action view " + width + " " + height);
        this.mDrawActionView.setLayoutParams(layoutParams2);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean updateDrawGestureAdViewSize() {
        int width = this.mAutoVideoView.getWidth();
        int height = this.mAutoVideoView.getHeight();
        if (width == 0 || height == 0) {
            return false;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mAutoVideoView.getLayoutParams();
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.mDrawGestureAdView.getLayoutParams();
        layoutParams2.width = this.mAutoVideoView.getWidth();
        layoutParams2.height = this.mAutoVideoView.getHeight();
        layoutParams2.gravity = layoutParams.gravity;
        layoutParams2.topMargin = layoutParams.topMargin;
        layoutParams2.leftMargin = layoutParams.leftMargin;
        Log.i(TAG, "updateDrawActionViewSize: reset action view " + width + " " + height);
        this.mDrawGestureAdView.setLayoutParams(layoutParams2);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean updateFloatDanmakuAdViewSize() {
        int width = this.mAutoVideoView.getWidth();
        if (width == 0) {
            return false;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mGdtFloatDanmakuPresenter.getLayoutParams();
        layoutParams.width = width;
        layoutParams.gravity = 48;
        Log.i(TAG, "updateFloatDanmakuAdViewSize: reset width " + width);
        this.mGdtFloatDanmakuPresenter.setLayoutParams(layoutParams);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.enableRoundedCorner) {
            canvas.saveLayer(this.mLayer, null, 31);
            super.dispatchDraw(canvas);
            this.mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            this.mPaint.setColor(-1);
            this.mPaint.setStyle(Paint.Style.FILL);
            canvas.drawPath(this.mClipPath, this.mPaint);
            canvas.restore();
            return;
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        RegionData regionData;
        CellOperationRegion cellOperationRegion = this.mFeedData.cellOperationRegion;
        if (cellOperationRegion != null && cellOperationRegion.regions.size() != 0 && this.mFeedData.cellOperationRegion.interactiveType == 0) {
            int measuredHeight = this.mAutoVideoView.getMeasuredHeight();
            int measuredWidth = this.mAutoVideoView.getMeasuredWidth();
            if (motionEvent.getAction() == 0) {
                for (RegionData regionData2 : this.mFeedData.cellOperationRegion.regions) {
                    if (regionData2.checkHit(measuredHeight, measuredWidth, motionEvent.getX(), motionEvent.getY())) {
                        this.touchedRegionData = regionData2;
                        return true;
                    }
                }
            } else if (motionEvent.getAction() == 3) {
                this.touchedRegionData = null;
            } else if (motionEvent.getAction() == 1 && (regionData = this.touchedRegionData) != null && regionData.checkHit(measuredHeight, measuredWidth, motionEvent.getX(), motionEvent.getY())) {
                com.qzone.proxy.feedcomponent.b.c("GAMESHARE", String.format("touched feed video view, size: %d %d", Integer.valueOf(measuredWidth), Integer.valueOf(measuredHeight)));
                com.qzone.proxy.feedcomponent.ui.g gVar = this.onFeedElementClickListener;
                if (gVar != null) {
                    RegionData regionData3 = this.touchedRegionData;
                    if (regionData3.actionType == 2) {
                        gVar.onClick(this, FeedElement.GAME_SHARE_HOT_AREA, this.mPostion, regionData3.parseClickParamMap());
                        return true;
                    }
                }
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void doPlayVideoOnlyDetail(boolean z16) {
        if (this.mVideoInfo == null) {
            return;
        }
        com.qzone.proxy.feedcomponent.b.e(TAG, "doPlayVideo. feed pos:" + this.mPostion + " index:" + this.mIndex);
        if ((z16 || com.qzone.adapter.feedcomponent.i.H().m()) && isAutoVideoFeed()) {
            BaseVideoManager.getFeedVideoManager().onListIdleSingleVideo(this.mFeedAutoViewList);
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (this.enableRoundedCorner) {
            canvas.save();
            canvas.clipPath(this.mClipPath);
            super.draw(canvas);
            canvas.restore();
            return;
        }
        super.draw(canvas);
    }

    public void enableRoundedCorner(boolean z16) {
        this.enableRoundedCorner = z16;
        this.mClipPath = new Path();
        this.mAreaRegion = new Region();
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setColor(-1);
        this.mPaint.setAntiAlias(true);
        this.radii = new float[]{12.0f, 12.0f, 12.0f, 12.0f, 12.0f, 12.0f, 12.0f, 12.0f};
    }

    public FeedAutoVideo getAutoVideoView() {
        return this.mAutoVideoView;
    }

    int getCoverMaxWidth(VideoInfo videoInfo) {
        BusinessFeedData businessFeedData;
        BusinessFeedData businessFeedData2;
        if (com.qzone.adapter.feedcomponent.i.H().r1() && (businessFeedData = this.mFeedData) != null && ((businessFeedData.getCellLive() == null || com.qzone.adapter.feedcomponent.i.H().h1()) && ((businessFeedData2 = this.mFeedData) == null || !businessFeedData2.isAdFeeds()))) {
            com.qzone.adapter.feedcomponent.i.H().d0();
            float f16 = videoInfo.width;
            float f17 = videoInfo.height;
            com.qzone.adapter.feedcomponent.i.H().J0();
            float screenWidth = (FeedGlobalEnv.g().getScreenWidth() - (AreaManager.FEED_INTERVAL * 2)) * com.qzone.adapter.feedcomponent.i.H().L0();
            float K0 = com.qzone.adapter.feedcomponent.i.H().K0(this.mFeedData) * screenWidth;
            if (K0 <= 0.0f) {
                K0 = FeedGlobalEnv.g().getScreenWidth();
            }
            if (FeedGlobalEnv.g().isDebug() || com.qzone.proxy.feedcomponent.b.g()) {
                com.qzone.proxy.feedcomponent.b.c("getCoverMaxWidth", "maxWidth == " + String.valueOf(screenWidth) + "   maxHeight  ==" + String.valueOf(K0) + "  coverWidth ==" + String.valueOf(f16) + " coverHeight == " + String.valueOf(f17));
            }
            if (!com.qzone.adapter.feedcomponent.i.H().m1()) {
                if (f16 == 0.0f || f17 == 0.0f) {
                    return (int) K0;
                }
                if (f16 / screenWidth >= f17 / K0) {
                    return (int) Math.min(screenWidth, screenWidth);
                }
                return (int) Math.min(((f16 * K0) * 1.0f) / f17, screenWidth);
            }
            if (needHandleVerticalVideo() && f16 != 0.0f && f17 != 0.0f && f16 < f17 && !this.mAutoVideoView.isVideoPicMixMode()) {
                return calculateVerticalVideoMaxWidth(f16, f17);
            }
            if (f16 == 0.0f || f17 == 0.0f) {
                return FeedGlobalEnv.g().getScreenWidth() - (AreaManager.FEED_INTERVAL * 2);
            }
            if (f16 >= f17) {
                return FeedGlobalEnv.g().getScreenWidth() - (AreaManager.FEED_INTERVAL * 2);
            }
            return (FeedGlobalEnv.g().getScreenWidth() - (AreaManager.FEED_INTERVAL * 2)) / 2;
        }
        VideoInfo.VideoRemark videoRemark = videoInfo.videoRemark;
        boolean z16 = com.qzone.adapter.feedcomponent.i.H().s1() && TextUtils.isEmpty(videoRemark != null ? videoRemark.remark : null);
        int screenWidth2 = FeedGlobalEnv.g().getScreenWidth();
        if (!z16 || this.mIsForwardFeed) {
            screenWidth2 = FeedGlobalEnv.g().getScreenWidth() - (AreaManager.FEED_INTERVAL * 2);
        }
        float f18 = videoInfo.width;
        float f19 = videoInfo.height;
        float screenWidth3 = FeedGlobalEnv.g().getScreenWidth();
        if (QZoneAdFeedDataExtKt.isGdt585AdVideo(this.mFeedData)) {
            return com.qzone.proxy.feedcomponent.util.g.a(181.0f);
        }
        BusinessFeedData businessFeedData3 = this.mFeedData;
        boolean z17 = businessFeedData3 != null && businessFeedData3.isAdFeeds() && this.mFeedData.getLocalInfo() != null && this.mFeedData.getLocalInfo().canLike && this.mFeedData.getLocalInfo().canShare && this.mFeedData.getLocalInfo().canComment && this.mFeedData.getRecommHeader() != null && this.mFeedData.getRecommAction() != null && this.mFeedData.getRecommAction().isHideActionArea == 0;
        BusinessFeedData businessFeedData4 = this.mFeedData;
        if ((businessFeedData4 != null && businessFeedData4.isGDTAdvFeed()) || z17) {
            return (int) (screenWidth3 - (AreaManager.FEED_INTERVAL * 2));
        }
        if (!com.qzone.adapter.feedcomponent.i.H().r1() || !com.qzone.adapter.feedcomponent.i.H().m1()) {
            return f18 >= f19 ? screenWidth2 : Math.min((int) (((f18 * screenWidth3) * 1.0f) / f19), screenWidth2);
        }
        if (needHandleVerticalVideo() && f18 != 0.0f && f19 != 0.0f && f18 < f19 && !this.mAutoVideoView.isVideoPicMixMode()) {
            return calculateVerticalVideoMaxWidth(f18, f19);
        }
        if (f18 == 0.0f || f19 == 0.0f) {
            return FeedGlobalEnv.g().getScreenWidth() - (AreaManager.FEED_INTERVAL * 2);
        }
        if (f18 >= f19) {
            return FeedGlobalEnv.g().getScreenWidth() - (AreaManager.FEED_INTERVAL * 2);
        }
        return (FeedGlobalEnv.g().getScreenWidth() - (AreaManager.FEED_INTERVAL * 2)) / 2;
    }

    public FeedPicTextCardView getFeedPicTextCardView() {
        return this.mEventTagView;
    }

    public CanvasTitleView getTitleView() {
        ExFeedTitleView exFeedTitleView = this.mTitleView;
        if (exFeedTitleView == null || exFeedTitleView.getVisibility() != 0) {
            return null;
        }
        return this.mTitleView.mSimpleTitleView;
    }

    public VideoPlayInfo getVideoPlayInfo() {
        int i3 = this.mMaxVideoWidth;
        BusinessFeedData businessFeedData = this.mFeedData;
        if (businessFeedData == null || businessFeedData.getVideoInfo() == null) {
            return null;
        }
        if (i3 <= 0) {
            BusinessFeedData businessFeedData2 = this.mFeedData;
            if (businessFeedData2.isSubFeed) {
                i3 = AreaConst.commentWidth_Rec;
            } else {
                i3 = getCoverMaxWidth(businessFeedData2.getVideoInfo());
            }
        }
        VideoPlayInfo preCalVideoPlayInfo = this.mFeedData.getPreCalVideoPlayInfo(i3);
        if (preCalVideoPlayInfo != null) {
            return preCalVideoPlayInfo;
        }
        BusinessFeedData businessFeedData3 = this.mFeedData;
        return com.qzone.proxy.feedcomponent.ui.c.c(businessFeedData3, businessFeedData3.getVideoInfo(), i3);
    }

    void initUI(Context context) {
        FeedPicTextCardView feedPicTextCardView;
        this.mBackgroundView = new View(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ViewUtils.getScreenWidth() - (AreaManager.FEED_INTERVAL * 2), -2);
        layoutParams.gravity = 1;
        this.mBackgroundView.setVisibility(8);
        addView(this.mBackgroundView, layoutParams);
        this.mTitleView = new ExFeedTitleView(context);
        int i3 = ExFeedTitleView.HEIGHT;
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, i3);
        layoutParams2.gravity = 80;
        this.mTitleView.setContentDescription("ExFeedTitleView");
        addView(this.mTitleView, layoutParams2);
        this.mTextViewH = AreaConst.dp30;
        this.mTextView = new CellTextView(context);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, this.mTextViewH);
        layoutParams3.gravity = 48;
        layoutParams3.topMargin = i3;
        this.mTextView.setVisibility(8);
        this.mTextView.setTextSize(FeedGlobalEnv.g().getSpValue(AreaConst.summaryTextSize));
        this.mTextView.setTextColor(com.qzone.adapter.feedcomponent.j.o());
        this.mTextView.setMaxLine(1);
        CellTextView cellTextView = this.mTextView;
        int i16 = AreaConst.dp10;
        cellTextView.setPadding(AreaConst.f48748dp3 + i16, 0, i16, 0);
        this.mTextView.setContentDescription("TextView");
        addView(this.mTextView, layoutParams3);
        this.mTextView.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.module.feedcomponent.ui.FeedVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                FeedVideoView feedVideoView = FeedVideoView.this;
                com.qzone.proxy.feedcomponent.ui.g gVar = feedVideoView.onFeedElementClickListener;
                if (gVar != null) {
                    gVar.onClick(feedVideoView, FeedElement.AUTO_VIDEO, feedVideoView.mPostion, null);
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        this.mAutoVideoView = new FeedAutoVideo(context);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams4.gravity = 48;
        addView(this.mAutoVideoView, layoutParams4);
        ProgressBar progressBar = (ProgressBar) LayoutInflater.from(getContext()).inflate(com.qzone.adapter.feedcomponent.j.j(1711), (ViewGroup) null).findViewById(com.qzone.adapter.feedcomponent.j.O(2777));
        this.mProgressBar = progressBar;
        progressBar.setMax(100);
        this.mProgressBar.setProgress(0);
        this.mProgressBar.setContentDescription("\u89c6\u9891\u64ad\u653e\u8fdb\u5ea6");
        this.mProgressBar.setVisibility(8);
        int i17 = AreaConst.f48747dp2;
        FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(-1, i17);
        layoutParams5.gravity = 80;
        addView(this.mProgressBar, layoutParams5);
        if (com.qzone.adapter.feedcomponent.i.H().V0()) {
            feedPicTextCardView = new FeedPicTextCardSmallTailView(context);
        } else {
            feedPicTextCardView = new FeedPicTextCardView(context);
        }
        this.mEventTagView = feedPicTextCardView;
        feedPicTextCardView.setContentDescription("\u4e8b\u4ef6\u6807\u7b7e");
        FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams6.gravity = 80;
        this.mEventTagView.setVisibility(8);
        addView(this.mEventTagView, layoutParams6);
        this.mFeedAutoViewList.add(this.mAutoVideoView);
        addGdtRightView();
        this.mGdtAdvRightView.setVisibility(8);
        addAdView();
        addAdGuideView();
        setPadding(i17, i17, 0, getPaddingBottom());
    }

    public boolean isAutoVideoFeed() {
        BusinessFeedData businessFeedData = this.mFeedData;
        if (businessFeedData == null) {
            return false;
        }
        if (businessFeedData.getLocalInfo().isFake() || this.mFeedData.getVideoInfo() == null || !this.mFeedData.getVideoInfo().isAutoPlay()) {
            return (this.mFeedData.getOriginalInfo() == null || this.mFeedData.getOriginalInfo().getVideoInfo() == null || !this.mFeedData.getOriginalInfo().getVideoInfo().isAutoPlay()) ? false : true;
        }
        return true;
    }

    public boolean isShowProgressBar() {
        return this.mNeedShowProgressBar;
    }

    @Override // com.qzone.widget.DrawActionView.a
    public void onAction() {
        RegionData regionData;
        VideoPlayInfo videoPlayInfo = getVideoPlayInfo();
        com.qzone.proxy.feedcomponent.ui.g gVar = this.onFeedElementClickListener;
        if (gVar != null && videoPlayInfo != null) {
            gVar.onClick(this, FeedElement.GESTURE_AD_VIEW, this.mPostion, videoPlayInfo);
        }
        com.qzone.proxy.feedcomponent.ui.g gVar2 = this.onFeedElementClickListener;
        if (gVar2 != null && (regionData = this.drawActionRegionData) != null) {
            gVar2.onClick(this, FeedElement.GAME_SHARE_HOT_AREA, this.mPostion, regionData.parseClickParamMap());
        }
        com.qzone.adapter.feedcomponent.i.H().k2(this.mFeedData, this.mPostion, 214, 4);
    }

    @Override // com.qzone.widget.DrawActionView.a
    public boolean onClickAction() {
        VideoPlayInfo videoPlayInfo = getVideoPlayInfo();
        com.qzone.proxy.feedcomponent.ui.g gVar = this.onFeedElementClickListener;
        if (gVar == null || videoPlayInfo == null) {
            return false;
        }
        gVar.onClick(this, FeedElement.GESTURE_AD_CLICK_VIEW, this.mPostion, videoPlayInfo);
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.mInterceptTouchEvent) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        int screenWidth;
        FeedAutoVideo feedAutoVideo;
        FeedAutoVideo feedAutoVideo2;
        boolean z16 = false;
        if (this.mFeedData == null) {
            setMeasuredDimension(0, 0);
            return;
        }
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        if (this.mFeedData.isSubFeed) {
            screenWidth = AreaConst.commentWidth_Rec;
        } else {
            screenWidth = FeedGlobalEnv.g().getScreenWidth();
        }
        if (mode != 1073741824) {
            size = screenWidth;
        }
        int i17 = this.mRecBusinessFeedDatasSize > 0 ? size - AreaConst.dp8 : size;
        this.mFeedData.getAdData();
        if (QZoneAdFeedDataExtKt.isGdt585AdVideo(this.mFeedData)) {
            measureChild(this.mAutoVideoView, View.MeasureSpec.makeMeasureSpec((size - getPaddingLeft()) - getPaddingRight(), Integer.MIN_VALUE), i16);
            LinearLayout linearLayout = this.mGdtAdvRightView;
            if (linearLayout != null && linearLayout.getVisibility() != 8 && QZoneAdFeedDataExtKt.isGdt585ABTest(this.mFeedData) && this.mAutoVideoView != null) {
                this.mGdtAdvRightView.measure(View.MeasureSpec.makeMeasureSpec(((size - getPaddingLeft()) - AreaManager.FEED_INTERVAL) - this.mAutoVideoView.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(this.mAutoVideoView.getMeasuredHeight(), 1073741824));
            }
        } else if (isWeishiVideo(this.mFeedData)) {
            measureChild(this.mAutoVideoView, View.MeasureSpec.makeMeasureSpec((size - getPaddingLeft()) - getPaddingRight(), 1073741824), i16);
        } else if (!this.mIsForwardFeed && (!this.mFeedData.isAdFeeds() || !this.mFeedData.getLocalInfo().canLike || !this.mFeedData.getLocalInfo().canShare || !this.mFeedData.getLocalInfo().canComment || this.mFeedData.getRecommHeader() == null || this.mFeedData.getRecommAction() == null || this.mFeedData.getRecommAction().isHideActionArea != 0)) {
            FeedAutoVideo feedAutoVideo3 = this.mAutoVideoView;
            if (feedAutoVideo3 != null) {
                feedAutoVideo3.measure(View.MeasureSpec.makeMeasureSpec(size - AreaConst.f48747dp2, 1073741824), i16);
            }
        } else {
            measureChild(this.mAutoVideoView, i3, i16);
        }
        if (ih.j.o(this.mFeedData)) {
            LinearLayout linearLayout2 = this.mVideoAdvShaderLayout;
            if (linearLayout2 != null && linearLayout2.getVisibility() != 8 && (feedAutoVideo2 = this.mAutoVideoView) != null) {
                this.mVideoAdvShaderLayout.measure(View.MeasureSpec.makeMeasureSpec(feedAutoVideo2.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(this.mAutoVideoView.getMeasuredHeight(), 1073741824));
            }
            LinearLayout linearLayout3 = this.mVideoAdvGuideLayout;
            if (linearLayout3 != null && linearLayout3.getVisibility() != 8 && (feedAutoVideo = this.mAutoVideoView) != null) {
                this.mVideoAdvGuideLayout.measure(View.MeasureSpec.makeMeasureSpec(feedAutoVideo.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(ViewUtils.dip2px(45.0f), 1073741824));
            }
        }
        FeedAutoVideo feedAutoVideo4 = this.mAutoVideoView;
        int measuredHeight = feedAutoVideo4 != null ? feedAutoVideo4.getMeasuredHeight() : 0;
        DrawActionView drawActionView = this.mDrawActionView;
        if (drawActionView != null) {
            measureChild(drawActionView, i3, i16);
        }
        DrawActionView drawActionView2 = this.mDrawGestureAdView;
        if (drawActionView2 != null) {
            measureChild(drawActionView2, i3, i16);
        }
        GdtBubbleDanmakuPresenter gdtBubbleDanmakuPresenter = this.mGdtBubbleDanmakuPresenter;
        if (gdtBubbleDanmakuPresenter != null) {
            measureChild(gdtBubbleDanmakuPresenter, i3, i16);
        }
        GdtDanmakuPresenter gdtDanmakuPresenter = this.mGdtFloatDanmakuPresenter;
        if (gdtDanmakuPresenter != null) {
            measureChild(gdtDanmakuPresenter, i3, i16);
        }
        if (this.mTitleView.getVisibility() != 8) {
            ExFeedTitleView exFeedTitleView = this.mTitleView;
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i17, 1073741824);
            int i18 = ExFeedTitleView.HEIGHT;
            exFeedTitleView.measure(makeMeasureSpec, View.MeasureSpec.makeMeasureSpec(i18, 1073741824));
            measuredHeight += i18;
        }
        if (this.mTextView.getVisibility() != 8) {
            this.mTextView.measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(this.mTextViewH, 1073741824));
            measuredHeight += this.mTextViewH;
        }
        if (hasEventTagInForwardArea(this.mFeedData) && this.mEventTagView.getVisibility() != 8) {
            measuredHeight += this.mEventTagHeight + AreaConst.dp5;
            this.mEventTagView.measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(this.mEventTagHeight, 1073741824));
        }
        if (shouldDisplayBlurBackground(this.mFeedData, this.mVideoInfo) && this.mBackgroundView != null) {
            z16 = true;
        }
        if (z16 && this.mAutoVideoView != null) {
            this.mBackgroundView.measure(View.MeasureSpec.makeMeasureSpec(ViewUtils.getScreenWidth() - (AreaManager.FEED_INTERVAL * 2), 1073741824), View.MeasureSpec.makeMeasureSpec(this.mAutoVideoView.getMeasuredHeight(), 1073741824));
        }
        ProgressBar progressBar = this.mProgressBar;
        if (progressBar != null && progressBar.getVisibility() != 8) {
            if (z16) {
                this.mProgressBar.measure(View.MeasureSpec.makeMeasureSpec(ViewUtils.getScreenWidth() - (AreaManager.FEED_INTERVAL * 2), 1073741824), View.MeasureSpec.makeMeasureSpec(AreaConst.f48747dp2, 1073741824));
            } else {
                FeedAutoVideo feedAutoVideo5 = this.mAutoVideoView;
                if (feedAutoVideo5 != null) {
                    this.mProgressBar.measure(View.MeasureSpec.makeMeasureSpec(feedAutoVideo5.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(AreaConst.f48747dp2, 1073741824));
                }
            }
        }
        int mode2 = View.MeasureSpec.getMode(i16);
        int size2 = View.MeasureSpec.getSize(i16);
        if (mode2 != Integer.MIN_VALUE ? mode2 == 1073741824 : !(size2 <= 0 || measuredHeight <= size2)) {
            measuredHeight = size2;
        }
        if (this.mIsForwardFeed && !this.mFeedData.isSubFeed) {
            setMeasuredDimension(View.getDefaultSize(getSuggestedMinimumWidth(), i3), measuredHeight + getPaddingTop() + getPaddingBottom());
            return;
        }
        if (this.mFeedData.isAdFeeds() && this.mFeedData.getLocalInfo().canLike && this.mFeedData.getLocalInfo().canShare && this.mFeedData.getLocalInfo().canComment) {
            setMeasuredDimension(View.getDefaultSize(getSuggestedMinimumWidth(), i3), measuredHeight + getPaddingTop() + getPaddingBottom());
        } else if (QZoneAdFeedDataExtKt.isGdt585AdVideo(this.mFeedData)) {
            setMeasuredDimension(View.getDefaultSize(getSuggestedMinimumWidth(), i3), measuredHeight);
        } else {
            setMeasuredDimension(size, measuredHeight + getPaddingTop() + getPaddingBottom());
        }
    }

    public void onPause() {
        if (this.mVideoInfo == null) {
            return;
        }
        this.mAutoVideoView.onPause();
    }

    public void onRecycled(boolean z16) {
        BusinessFeedData businessFeedData = this.mFeedData;
        if (businessFeedData != null && businessFeedData.isGDTAdvFeed()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onRecycled ");
            FeedAutoVideo feedAutoVideo = this.mAutoVideoView;
            sb5.append(feedAutoVideo != null ? feedAutoVideo.feedPosition : -1);
            com.qzone.proxy.feedcomponent.b.e(TAG, sb5.toString());
        }
        this.onFeedElementClickListener = null;
        FeedVideoSensorManager feedVideoSensorManager = this.mFeedVideoSensorManager;
        if (feedVideoSensorManager != null) {
            feedVideoSensorManager.unregister(getContext());
        }
        if (this.mVideoInfo == null) {
            return;
        }
        LottieLoader lottieLoader = this.mAdvShaderLottieLoader;
        if (lottieLoader != null) {
            lottieLoader.destroy();
            this.mAdvShaderLottieLoader = null;
        }
        LottieLoader lottieLoader2 = this.mAdvGuideLottieLoader;
        if (lottieLoader2 != null) {
            lottieLoader2.destroy();
            this.mAdvGuideLottieLoader = null;
        }
        LinearLayout linearLayout = this.mVideoAdvShaderLayout;
        if (linearLayout != null) {
            linearLayout.clearAnimation();
            this.mVideoAdvShaderLayout.setVisibility(4);
        }
        LinearLayout linearLayout2 = this.mVideoAdvGuideLayout;
        if (linearLayout2 != null) {
            linearLayout2.clearAnimation();
            this.mVideoAdvGuideLayout.setVisibility(4);
        }
        Handler handler = this.mMainHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        if (z16) {
            this.mAutoVideoView.onRecycled();
        }
        if (com.qzone.adapter.feedcomponent.i.H().o0()) {
            this.mTitleView.onRecycled();
        }
        FeedPicTextCardView feedPicTextCardView = this.mEventTagView;
        if (feedPicTextCardView != null) {
            feedPicTextCardView.onRecycled();
        }
        GdtBubbleDanmakuPresenter gdtBubbleDanmakuPresenter = this.mGdtBubbleDanmakuPresenter;
        if (gdtBubbleDanmakuPresenter != null) {
            gdtBubbleDanmakuPresenter.recycle();
            this.mGdtBubbleDanmakuPresenter = null;
            com.qzone.proxy.feedcomponent.b.e(TAG, "GdtBubbleDanmakuContainer is removed from its parent");
        }
        GdtDanmakuPresenter gdtDanmakuPresenter = this.mGdtFloatDanmakuPresenter;
        if (gdtDanmakuPresenter != null) {
            gdtDanmakuPresenter.stop();
            this.mGdtFloatDanmakuPresenter = null;
            com.qzone.proxy.feedcomponent.b.e("GdtFloatDanmakuPresenter", "GdtFloatDanmakuPresenter is removed from its parent");
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        if (this.enableRoundedCorner) {
            this.mLayer = new RectF(0.0f, 0.0f, i3, i16);
            RectF rectF = new RectF();
            rectF.left = getPaddingLeft();
            rectF.top = getPaddingTop();
            rectF.right = i3 - getPaddingRight();
            rectF.bottom = i16 - getPaddingBottom();
            this.mClipPath.reset();
            this.mClipPath.addRoundRect(rectF, this.radii, Path.Direction.CW);
            this.mAreaRegion.setPath(this.mClipPath, new Region((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom));
        }
    }

    @Override // com.qzone.widget.DrawActionView.a
    public void onStateChange(boolean z16) {
        com.qzone.adapter.feedcomponent.i.H().x2(!z16);
        if (z16) {
            com.qzone.adapter.feedcomponent.i.H().k2(this.mFeedData, this.mPostion, 214, 2);
        }
    }

    public void onStateIdle() {
        if (this.mVideoInfo == null) {
            return;
        }
        com.qzone.proxy.feedcomponent.b.e(TAG, "onStateIdle. feed pos:" + this.mPostion + " index:" + this.mIndex);
        if (com.qzone.adapter.feedcomponent.i.H().m() && this.mVideoInfo.isAutoPlay()) {
            BaseVideoManager.getFeedVideoManager().D(this.mFeedAutoViewList);
        }
    }

    public void setAdjustToHeight(boolean z16, int i3) {
        this.mAutoVideoView.setAdjustToHeight(z16, i3);
    }

    public void setAdjustToWidth(boolean z16, int i3) {
        this.mAutoVideoView.setAdjustToWidth(z16, i3);
    }

    public void setAdvButtonAnimationListener(com.qzone.proxy.feedcomponent.ui.f fVar) {
        this.mAutoVideoView.setAdvButtonAnimationListener(fVar);
    }

    public void setFeedPos(int i3, int i16) {
        this.mAutoVideoView.setFeedPos(i3, i16);
        this.mTitleView.setFeedPos(i3, i16);
        this.mPostion = i3;
        this.mIndex = i16;
        FeedPicTextCardView feedPicTextCardView = this.mEventTagView;
        if (feedPicTextCardView != null) {
            feedPicTextCardView.setFeedPosition(i3);
        }
    }

    public void setForceToWH(boolean z16, int i3, int i16) {
        this.mAutoVideoView.setForceToWH(z16, i3, i16);
    }

    public void setIfNeedShowVideoCover(boolean z16) {
        this.isNeedShowCover = z16;
    }

    public void setInterceptTouchEvent(boolean z16) {
        this.mInterceptTouchEvent = z16;
    }

    public void setIsCenterCrop(boolean z16) {
        this.mAutoVideoView.setIsCenterCrop(z16);
    }

    public void setIsClipCoverCenter(boolean z16) {
        this.mAutoVideoView.setIsClipCoverCenter(z16);
    }

    public void setIsForward(boolean z16) {
        this.mIsForwardFeed = z16;
        this.mAutoVideoView.setIsForwardFeeds(z16);
        if (z16) {
            BusinessFeedData businessFeedData = this.mFeedData;
            if (businessFeedData != null && (businessFeedData.isQCircleRecommFeed() || this.mFeedData.isQCircleShareCardFeed())) {
                int i3 = AreaConst.dp10;
                int i16 = AreaConst.f48748dp3;
                setPadding(i3, i16, i3, i16);
            } else {
                int i17 = AreaConst.dp10;
                setPadding(i17, AreaConst.f48748dp3, i17, AreaConst.dp15);
            }
            setOnClickListener(new View.OnClickListener() { // from class: com.qzone.module.feedcomponent.ui.FeedVideoView.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    EventCollector.getInstance().onViewClickedBefore(view);
                    FeedVideoView feedVideoView = FeedVideoView.this;
                    com.qzone.proxy.feedcomponent.ui.g gVar = feedVideoView.onFeedElementClickListener;
                    if (gVar != null) {
                        gVar.onClick(feedVideoView, FeedElement.NOTHING, feedVideoView.mPostion, Boolean.valueOf(feedVideoView.mIsForwardFeed));
                    }
                    EventCollector.getInstance().onViewClicked(view);
                }
            });
        }
    }

    public void setMaxVideoWidth(int i3) {
        this.mMaxVideoWidth = i3;
    }

    public void setOnFeedElementClickListener(com.qzone.proxy.feedcomponent.ui.g gVar) {
        this.onFeedElementClickListener = gVar;
        this.mAutoVideoView.setOnFeedVideoElementClickListener(new OnFeedVideoElementClickListenerImpl(gVar));
        this.mTitleView.setOnFeedElementClickListener(gVar);
        FeedPicTextCardView feedPicTextCardView = this.mEventTagView;
        if (feedPicTextCardView != null) {
            feedPicTextCardView.setOnFeedElementClickListener(gVar);
        }
    }

    public void setOnVideoPlayStatusListener(FeedAutoVideo.OnVideoPlayStatusListener onVideoPlayStatusListener) {
        this.mAutoVideoView.setOnVideoPlayStatusListener(onVideoPlayStatusListener);
    }

    public void setTrans(int i3) {
        if (!shouldDisplayBlurBackground(this.mFeedData, this.mVideoInfo)) {
            setBackgroundDrawable(null);
        }
        FeedAutoVideo feedAutoVideo = this.mAutoVideoView;
        if (feedAutoVideo != null) {
            feedAutoVideo.setRemarkLayoutTrans(i3);
        }
    }

    void setVideoInfo(VideoPlayInfo videoPlayInfo) {
        VideoPlayInfoHolder videoProgressRecord = AutoVideoProgressRecorder.getInstance().getVideoProgressRecord(videoPlayInfo.videoId);
        if (videoProgressRecord != null) {
            if (Math.abs(videoProgressRecord.currentPositionSec - videoProgressRecord.totalDurationSec) > 1) {
                AutoVideoProgressRecorder.getInstance().putVideoProgerssRecord(videoPlayInfo.videoId, videoProgressRecord);
            } else {
                videoProgressRecord.currentPositionSec = 0L;
                videoProgressRecord.currentPositionMills = 0L;
                AutoVideoProgressRecorder.getInstance().putVideoProgerssRecord(videoPlayInfo.videoId, videoProgressRecord);
            }
            videoPlayInfo.isFeedFirstComplete = Math.abs(videoProgressRecord.totalDurationMills - videoProgressRecord.lastValidPositionMills) < 1000 || (!videoProgressRecord.isNeverPlayed && videoProgressRecord.currentPositionSec == 0);
            if (videoPlayInfo.k() && !videoPlayInfo.isFeedFirstComplete) {
                BaseVideoManager.f279598j.remove(videoPlayInfo.feedKey);
            }
            videoPlayInfo.videoPlayInfoHolder = videoProgressRecord;
        }
        if (this.mFeedData.isGDTAdvFeed()) {
            QZoneAdFeedDataExtKt.setVideoPlayInfoForReportAdPlay(this.mFeedData, videoPlayInfo);
        }
        this.mAutoVideoView.setVideoPlayInfo(videoPlayInfo);
        this.mTitleView.setVideoPlayInfo(videoPlayInfo);
    }

    public void setVideoPicMixMode(boolean z16) {
        FeedAutoVideo feedAutoVideo = this.mAutoVideoView;
        if (feedAutoVideo != null) {
            feedAutoVideo.setVideoPicMixMode(z16);
            setPadding(0, 0, 0, 0);
        }
    }

    public void setVideoPicMixModeClipSize(int i3) {
        FeedAutoVideo feedAutoVideo = this.mAutoVideoView;
        if (feedAutoVideo != null) {
            feedAutoVideo.setVideoPicMixModeClipSize(i3);
        }
    }

    public void showProgressBar(boolean z16) {
        this.mNeedShowProgressBar = z16;
        ProgressBar progressBar = this.mProgressBar;
        if (progressBar != null) {
            progressBar.setVisibility(z16 ? 0 : 8);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    private class CoverPicListener implements ImageLoader.ImageLoadListener {
        CoverPicListener() {
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageLoaded(String str, final Drawable drawable, ImageLoader.Options options) {
            if (drawable != null) {
                PlayerUtils.runOnUiThread(new Runnable() { // from class: com.qzone.module.feedcomponent.ui.FeedVideoView.CoverPicListener.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (FeedVideoView.this.mBackgroundView != null) {
                            FeedVideoView.this.mBackgroundView.setBackground(drawable);
                            FeedVideoView.this.mBackgroundView.setVisibility(0);
                        }
                    }
                });
            }
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
    }

    public void updateProgress(final long j3, final long j16, final long j17) {
        Handler handler = this.mMainHandler;
        if (handler == null || 0 == j16) {
            return;
        }
        handler.post(new Runnable() { // from class: com.qzone.module.feedcomponent.ui.FeedVideoView.12
            @Override // java.lang.Runnable
            public void run() {
                long j18 = j3;
                if (j18 < 0) {
                    j18 = 0;
                }
                if (FeedVideoView.this.mProgressBar != null) {
                    int progress = FeedVideoView.this.mProgressBar.getProgress();
                    float f16 = ((float) j18) / ((float) j16);
                    int i3 = (int) (100.0f * f16);
                    FeedVideoView.this.mProgressBar.setVisibility(0);
                    FeedVideoView.this.mProgressBar.setProgress(i3);
                    if (FeedVideoView.this.mProgressAnimator != null) {
                        FeedVideoView.this.mProgressAnimator.end();
                    }
                    double d16 = f16;
                    if (d16 < 1.0E-4d) {
                        FeedVideoView feedVideoView = FeedVideoView.this;
                        feedVideoView.startSmoothProgress(feedVideoView.mProgressBar, i3, 0L);
                    } else if (f16 > 0.0f && d16 < 0.9999d) {
                        FeedVideoView feedVideoView2 = FeedVideoView.this;
                        feedVideoView2.startSmoothProgress(feedVideoView2.mProgressBar, i3, 1000L);
                    } else if (d16 >= 0.9999d) {
                        FeedVideoView feedVideoView3 = FeedVideoView.this;
                        feedVideoView3.startSmoothProgress(feedVideoView3.mProgressBar, i3, 50L);
                    }
                    float f17 = ((float) j17) / ((float) j16);
                    if (FeedGlobalEnv.g().isDebug()) {
                        com.qzone.proxy.feedcomponent.b.e(FeedVideoView.TAG, "[jinqianli] [debug] video play last progress is " + progress + ", current percent is " + f16 + ", buffer percent is " + f17);
                    }
                }
            }
        });
    }

    private boolean isLiveVideo(BusinessFeedData businessFeedData) {
        return (businessFeedData == null || businessFeedData.getCellLive() == null) ? false : true;
    }

    private boolean isWeishiVideo(BusinessFeedData businessFeedData) {
        return (businessFeedData == null || businessFeedData.getVideoInfo() == null || TextUtils.isEmpty(businessFeedData.getVideoInfo().gauseBackgroudUrl)) ? false : true;
    }

    private void resetVideoWH() {
        setForceToWH(false, -1, -1);
        setIsClipCoverCenter(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideAoYunShader(boolean z16) {
        if (z16) {
            if (this.mVideoAdvGuideLayout.getVisibility() != 0) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(500L);
                this.mVideoAdvGuideLayout.startAnimation(alphaAnimation);
                this.mVideoAdvGuideLayout.setVisibility(0);
            }
            if (this.mVideoAdvShaderLayout.getVisibility() == 0) {
                AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation2.setDuration(500L);
                this.mVideoAdvShaderLayout.startAnimation(alphaAnimation2);
                alphaAnimation2.setAnimationListener(new Animation.AnimationListener() { // from class: com.qzone.module.feedcomponent.ui.FeedVideoView.8
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        FeedVideoView.this.mVideoAdvShaderLayout.setVisibility(4);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }
                });
            }
        } else {
            this.mVideoAdvGuideLayout.clearAnimation();
            this.mVideoAdvGuideLayout.setVisibility(0);
            this.mVideoAdvShaderLayout.clearAnimation();
            this.mVideoAdvShaderLayout.setVisibility(4);
        }
        startAoYunGuideLottie();
    }

    private boolean shouldDisplayBlurBackground(BusinessFeedData businessFeedData, VideoInfo videoInfo) {
        return (businessFeedData == null || videoInfo == null || !needHandleVerticalVideo() || sVerticalVideoData.f50438a != 2 || !businessFeedData.isFriendFeed() || this.mAutoVideoView.isVideoPicMixMode() || isLiveVideo(businessFeedData) || businessFeedData.isGDTAdvFeed() || businessFeedData.isAdFeeds() || videoInfo.width >= videoInfo.height) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startSmoothProgress(final ProgressBar progressBar, int i3, long j3) {
        if (progressBar == null || j3 < 0 || i3 < 0) {
            return;
        }
        ValueAnimator duration = ValueAnimator.ofInt(progressBar.getProgress(), i3).setDuration(j3);
        this.mProgressAnimator = duration;
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.qzone.module.feedcomponent.ui.FeedVideoView.13
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                progressBar.setProgress(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        this.mProgressAnimator.start();
    }

    public void setFeedData(BusinessFeedData businessFeedData, VideoInfo videoInfo) {
        int paddingBottom;
        boolean z16;
        int i3;
        if (businessFeedData != null && videoInfo != null) {
            sVerticalVideoData = getVerticalVideo();
            BusinessFeedData businessFeedData2 = businessFeedData.parentFeedData;
            boolean z17 = businessFeedData2 != null && businessFeedData2.isFriendLikeContainer();
            this.mAutoVideoView.setLikeFriendVideo(z17);
            hideDrawActionView();
            hideDrawGestureAdView();
            CellOperationRegion cellOperationRegion = businessFeedData.cellOperationRegion;
            boolean z18 = cellOperationRegion != null && cellOperationRegion.interactiveType == 1;
            this.showGestureAction = z18;
            if (z18) {
                this.showGestureViewDuration = (int) TimeUnit.SECONDS.toMillis(cellOperationRegion.gestureStartTime);
                this.drawActionRegionData = null;
                List<RegionData> list = businessFeedData.cellOperationRegion.regions;
                if (list != null && list.size() > 0) {
                    this.drawActionRegionData = businessFeedData.cellOperationRegion.regions.get(0);
                }
            }
            this.isSeeking = false;
            BusinessFeedData businessFeedData3 = businessFeedData.parentFeedData;
            if (businessFeedData3 != null && businessFeedData3.getRecBusinessFeedDatas() != null) {
                this.mRecBusinessFeedDatasSize = businessFeedData.parentFeedData.getRecBusinessFeedDatas().size();
            }
            if (hasEventTagInForwardArea(businessFeedData)) {
                paddingBottom = AreaConst.dp12;
            } else {
                paddingBottom = getPaddingBottom();
            }
            if (businessFeedData.isSubFeed) {
                setPadding(0, 0, getPaddingRight(), paddingBottom);
            } else {
                int i16 = (!com.qzone.adapter.feedcomponent.i.H().s1() || videoInfo.width < videoInfo.height) ? AreaManager.FEED_INTERVAL : 0;
                VideoInfo.VideoRemark videoRemark = videoInfo.videoRemark;
                if (!TextUtils.isEmpty(videoRemark != null ? videoRemark.remark : null) || this.mIsForwardFeed) {
                    i16 = AreaManager.FEED_INTERVAL;
                }
                setPadding(i16, 1, 0, paddingBottom);
            }
            this.mFeedData = businessFeedData;
            this.mVideoInfo = videoInfo;
            s sVar = sVerticalVideoData;
            boolean z19 = CONFIG_SHOW_PROGRESS_BAR && (sVar != null && (i3 = sVar.f50440c) > 0 && sVar.f50441d / i3 >= 1) && (!businessFeedData.isLiveVideoFeed() && !businessFeedData.isAdFeeds());
            this.showProgress = z19;
            showProgressBar(z19);
            this.mAutoVideoView.setOnVideoPlayStatusListener(this.mOnVideoPlayListener);
            BusinessFeedData businessFeedData4 = this.mFeedData;
            if (businessFeedData4 != null) {
                this.mAutoVideoView.setIsFeedTypeDetail(businessFeedData4.feedType == 2);
            }
            int i17 = this.mMaxVideoWidth;
            if (i17 <= 0) {
                if (this.mFeedData.isSubFeed) {
                    i17 = AreaConst.commentWidth_Rec;
                } else {
                    i17 = getCoverMaxWidth(videoInfo);
                }
                if (FeedGlobalEnv.g().isDebug() || com.qzone.proxy.feedcomponent.b.g()) {
                    com.qzone.proxy.feedcomponent.b.c("getCoverMaxWidth  \u8fd9\u4e2a\u51fd\u6570\u8fd4\u56de\u7684\u7ed3\u679c", "maxCoverWidth == " + String.valueOf(getCoverMaxWidth(videoInfo)));
                }
            }
            if (FeedGlobalEnv.g().isDebug() || com.qzone.proxy.feedcomponent.b.g()) {
                com.qzone.proxy.feedcomponent.b.c("getCoverMaxWidth  \u6700\u7ec8\u8bbe\u7f6e\u5230videoinfo\u7684\u5bbd\u5ea6", "maxCoverWidth == " + String.valueOf(i17));
            }
            if (this.mFeedData.isQCircleRecommFeed()) {
                i17 = com.qzone.adapter.feedcomponent.b.a();
                int i18 = videoInfo.coverUrl.width;
                if (i18 != 0) {
                    setForceToWH(true, com.qzone.adapter.feedcomponent.b.a(), (int) (com.qzone.adapter.feedcomponent.b.a() * Math.min(r1.height / i18, 1.13f)));
                    setIsClipCoverCenter(true);
                } else {
                    resetVideoWH();
                }
            } else if (!com.qzone.proxy.feedcomponent.model.c.c(this.mFeedData)) {
                resetVideoWH();
            }
            if (this.mFeedData.isQCircleShareCardFeed()) {
                setIsCenterCrop(true);
            } else {
                setIsCenterCrop(false);
            }
            VideoPlayInfo preCalVideoPlayInfo = this.mFeedData.getPreCalVideoPlayInfo(i17);
            if (preCalVideoPlayInfo == null) {
                preCalVideoPlayInfo = com.qzone.proxy.feedcomponent.ui.c.c(this.mFeedData, videoInfo, i17);
            }
            this.mAutoVideoView.setFeedData(this.mFeedData);
            updateAoYunAdvInfo();
            this.mTitleView.setFeedData(this.mFeedData);
            setVideoInfo(preCalVideoPlayInfo);
            this.mAutoVideoView.hideVideoCover();
            if (shouldDisplayBlurBackground(this.mFeedData, this.mVideoInfo)) {
                ViewGroup.LayoutParams layoutParams = this.mAutoVideoView.getLayoutParams();
                if (layoutParams instanceof FrameLayout.LayoutParams) {
                    ((FrameLayout.LayoutParams) layoutParams).gravity = 49;
                    this.mAutoVideoView.setLayoutParams(layoutParams);
                }
                ImageLoader.Options obtain = ImageLoader.Options.obtain();
                PictureUrl pictureUrl = videoInfo.coverUrl;
                obtain.extraProcessor = new RoundBlurEffectImageProcessor(pictureUrl.width, pictureUrl.height, 0.5f, 0.5f);
                PictureUrl pictureUrl2 = videoInfo.coverUrl;
                obtain.clipHeight = pictureUrl2.height;
                obtain.clipWidth = pictureUrl2.width;
                ImageLoader imageLoader = ImageLoader.getInstance();
                PictureUrl pictureUrl3 = videoInfo.coverUrl;
                Drawable loadImage = imageLoader.loadImage(pictureUrl3.imageUrl, pictureUrl3.url, new CoverPicListener(), obtain);
                if (loadImage != null && this.mBackgroundView != null) {
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(ViewUtils.getScreenWidth() - (AreaManager.FEED_INTERVAL * 2), -2);
                    layoutParams2.gravity = 1;
                    this.mBackgroundView.setLayoutParams(layoutParams2);
                    this.mBackgroundView.setBackground(loadImage);
                    this.mBackgroundView.setVisibility(0);
                    this.mBackgroundView.requestLayout();
                }
            } else {
                ViewGroup.LayoutParams layoutParams3 = this.mAutoVideoView.getLayoutParams();
                if (layoutParams3 instanceof FrameLayout.LayoutParams) {
                    ((FrameLayout.LayoutParams) layoutParams3).gravity = 48;
                    this.mAutoVideoView.setLayoutParams(layoutParams3);
                }
                this.mBackgroundView.setVisibility(8);
            }
            boolean z26 = (businessFeedData.getCellSummaryV2() == null || TextUtils.isEmpty(businessFeedData.getCellSummaryV2().displayStr)) ? false : true;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
            if (this.mIsForwardFeed) {
                if (marginLayoutParams != null && marginLayoutParams.topMargin != 0) {
                    marginLayoutParams.topMargin = 0;
                    setLayoutParams(marginLayoutParams);
                }
            } else if (marginLayoutParams != null) {
                if (this.mFeedData.isSubFeed) {
                    marginLayoutParams.topMargin = 0;
                } else if (businessFeedData.isGDTAdvFeed()) {
                    marginLayoutParams.topMargin = AreaConst.dp9;
                } else if (z26) {
                    marginLayoutParams.topMargin = AreaConst.dp9;
                } else {
                    marginLayoutParams.topMargin = 0;
                }
                setLayoutParams(marginLayoutParams);
            }
            boolean z27 = businessFeedData.getFeedCommInfo().recomlayout == 1;
            if (!businessFeedData.getFeedCommInfo().isBizRecomFamousFeeds() && !z17) {
                this.mAutoVideoView.hideRoundedCover();
                this.mTextView.setVisibility(8);
                this.mTitleView.setVisibility(8);
                this.topDiff = 0;
            } else {
                this.mTitleView.setVisibility(0);
                FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) this.mTitleView.getLayoutParams();
                if (layoutParams4 == null) {
                    int i19 = ExFeedTitleView.HEIGHT;
                    layoutParams4 = new FrameLayout.LayoutParams(-1, i19);
                    layoutParams4.gravity = businessFeedData.getFeedCommInfo().recomlayout == 1 ? 80 : 48;
                    if (businessFeedData.getFeedCommInfo().recomlayout == 1) {
                        i19 = 0;
                    }
                    this.topDiff = i19;
                } else {
                    int i26 = ExFeedTitleView.HEIGHT;
                    layoutParams4.height = i26;
                    layoutParams4.width = -1;
                    layoutParams4.gravity = businessFeedData.getFeedCommInfo().recomlayout == 1 ? 80 : 48;
                    if (businessFeedData.getFeedCommInfo().recomlayout == 1) {
                        i26 = 0;
                    }
                    this.topDiff = i26;
                }
                boolean z28 = businessFeedData.isSubFeed;
                if (z28 && z17) {
                    if (z27) {
                        this.mAutoVideoView.hideRoundedCover();
                    } else {
                        this.mAutoVideoView.showRoundedCover();
                    }
                    if (!z27 && businessFeedData.getCellSummaryV2() != null && !TextUtils.isEmpty(businessFeedData.getCellSummaryV2().summary)) {
                        this.mTextView.setVisibility(0);
                        this.mTextView.setRichText(businessFeedData.getCellSummaryV2().summary);
                        layoutParams4.gravity = 48;
                        this.topDiff = ExFeedTitleView.HEIGHT + this.mTextViewH;
                    } else {
                        this.mTextView.setVisibility(8);
                    }
                } else if (z28) {
                    layoutParams4.gravity = 48;
                    this.topDiff = ExFeedTitleView.HEIGHT + this.mTextViewH;
                    if (businessFeedData.getCellSummaryV2() != null) {
                        this.mTextView.setRichText(businessFeedData.getCellSummaryV2().summary);
                    } else {
                        this.mTextView.setText("FeedVideoView.java -- 206 Error");
                    }
                    this.mTextView.setVisibility(0);
                    this.mAutoVideoView.showRoundedCover();
                } else {
                    this.mTextView.setVisibility(8);
                    this.mAutoVideoView.hideRoundedCover();
                }
                if (z17) {
                    layoutParams4.height -= AreaConst.f48747dp2;
                }
                layoutParams4.leftMargin = AreaConst.f48748dp3;
                this.mTitleView.setLayoutParams(layoutParams4);
                this.mTitleView.setFeedData(businessFeedData);
                this.mTitleView.onUpdate();
            }
            FrameLayout.LayoutParams layoutParams5 = (FrameLayout.LayoutParams) this.mAutoVideoView.getLayoutParams();
            if (layoutParams5 == null) {
                layoutParams5 = new FrameLayout.LayoutParams(-1, -2);
                layoutParams5.topMargin = this.topDiff;
            } else {
                layoutParams5.topMargin = this.topDiff;
            }
            if (this.mFeedData.getFeedCommInfo().isBizRecomFeeds() || this.mAutoVideoView.isVideoPicMixMode()) {
                layoutParams5.leftMargin = 0;
            }
            if (this.mFeedData.isAdFeeds() && this.mFeedData.getLocalInfo().canLike && this.mFeedData.getLocalInfo().canShare && this.mFeedData.getLocalInfo().canComment && this.mFeedData.getRecommHeader() != null && this.mFeedData.getRecommAction() != null && this.mFeedData.getRecommAction().isHideActionArea == 0) {
                this.mAutoVideoView.showVideoCover();
                int i27 = AreaManager.FEED_INTERVAL;
                setPadding(i27, 0, i27, 0);
            } else if ((this.mIsForwardFeed && this.mFeedData.isQCircleRecommFeed()) || this.mFeedData.isQCircleShareCardFeed()) {
                setPadding(AreaConst.MARGIN_LEFT, AreaConst.f48748dp3, AreaConst.MARGIN_RIGHT, 0);
            }
            if (this.mFeedData.isSingleCardStyle()) {
                this.mAutoVideoView.showVideoCover();
            }
            if (QZoneAdFeedDataExtKt.isGdt585AdVideo(this.mFeedData)) {
                this.mAutoVideoView.hideVideoCover();
                if (QZoneAdFeedDataExtKt.isGdt585ABTest(this.mFeedData)) {
                    setGdtRightInfo(this.mFeedData);
                    this.mGdtAdvRightView.setVisibility(0);
                } else {
                    this.mGdtAdvRightView.setVisibility(8);
                }
            } else {
                this.mGdtAdvRightView.setVisibility(8);
            }
            if (z17 && z27) {
                layoutParams5.topMargin -= com.qzone.proxy.feedcomponent.util.g.a(1.0f);
                this.mAutoVideoView.showVideoCover();
                int i28 = AreaConst.f48746dp1;
                setPadding(i28 * (-1), 0, i28, 0);
            }
            if (this.mAutoVideoView.isVideoPicMixMode()) {
                setPadding(0, 0, 0, 0);
            }
            this.mAutoVideoView.setLayoutParams(layoutParams5);
            if (hasEventTagInForwardArea(this.mFeedData)) {
                z16 = setEventTagInfo(this.mFeedData);
            } else {
                FeedPicTextCardView feedPicTextCardView = this.mEventTagView;
                if (feedPicTextCardView != null) {
                    feedPicTextCardView.setVisibility(8);
                }
                z16 = false;
            }
            this.mTitleView.onUpdate();
            if (shouldDisplayBlurBackground(this.mFeedData, this.mVideoInfo)) {
                setPadding(0, 0, 0, 0);
            }
            ProgressBar progressBar = this.mProgressBar;
            if (progressBar == null || progressBar.getVisibility() == 8) {
                return;
            }
            boolean shouldDisplayBlurBackground = shouldDisplayBlurBackground(this.mFeedData, this.mVideoInfo);
            FrameLayout.LayoutParams layoutParams6 = (FrameLayout.LayoutParams) this.mProgressBar.getLayoutParams();
            layoutParams6.gravity = 80;
            if (shouldDisplayBlurBackground) {
                layoutParams6.leftMargin = AreaManager.FEED_INTERVAL;
            } else {
                layoutParams6.leftMargin = 0;
            }
            if (z16) {
                layoutParams6.bottomMargin = com.qzone.proxy.feedcomponent.util.g.a(50.0f) + AreaConst.f48748dp3;
            } else {
                layoutParams6.bottomMargin = 0;
            }
            this.mProgressBar.setMax(100);
            this.mProgressBar.setProgress(0);
            this.mProgressBar.setLayoutParams(layoutParams6);
            return;
        }
        setViewVisibility(this, 8);
    }

    public FeedVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mEventTagHeight = com.qzone.proxy.feedcomponent.util.g.a(50.0f);
        this.mFeedAutoViewList = new ArrayList();
        this.mRecBusinessFeedDatasSize = -1;
        this.mInterceptTouchEvent = false;
        this.mMaxVideoWidth = 0;
        this.isNeedShowCover = true;
        this.mNeedShowProgressBar = false;
        this.mMainHandler = new Handler(Looper.getMainLooper());
        this.mHasShowAoYunShade = false;
        this.mOnShakeInterface = new FeedVideoSensorManager.ShakeListener() { // from class: com.qzone.module.feedcomponent.ui.FeedVideoView.9
            @Override // com.qzone.module.feedcomponent.ui.FeedVideoSensorManager.ShakeListener
            public void shake() {
                FeedVideoView.this.hideAoYunShader(false);
                ShakeCaiDanAdManager c16 = ShakeCaiDanAdManager.c();
                FeedVideoView feedVideoView = FeedVideoView.this;
                Context context2 = feedVideoView.getContext();
                Activity topActivity = BaseActivity.getTopActivity();
                FeedVideoView feedVideoView2 = FeedVideoView.this;
                c16.d(feedVideoView, context2, topActivity, feedVideoView2.mFeedData, feedVideoView2.mPostion);
            }
        };
        this.mOnVideoPlayListener = new FeedAutoVideo.OnVideoPlayStatusListener() { // from class: com.qzone.module.feedcomponent.ui.FeedVideoView.10
            @Override // com.qzone.module.feedcomponent.ui.FeedAutoVideo.OnVideoPlayStatusListener
            public void onVideoPlayComplete(BaseVideo baseVideo) {
                if (baseVideo instanceof FeedAutoVideo) {
                    FeedVideoView feedVideoView = FeedVideoView.this;
                    if (feedVideoView.mAutoVideoView != null) {
                        feedVideoView.mMainHandler.post(new Runnable() { // from class: com.qzone.module.feedcomponent.ui.FeedVideoView.10.7
                            @Override // java.lang.Runnable
                            public void run() {
                                FeedVideoView.this.hideDrawActionView();
                                FeedVideoView.this.hideDrawGestureAdView();
                            }
                        });
                        Log.i(FeedVideoView.TAG, "onVideoPlayComplete: ");
                        FeedAutoVideo feedAutoVideo = (FeedAutoVideo) baseVideo;
                        FeedVideoView.this.updateProgress(feedAutoVideo.getmTotalDurationMills(), feedAutoVideo.getmTotalDurationMills(), feedAutoVideo.getmTotalDurationMills());
                    }
                }
                if (FeedGlobalEnv.g().isDebug()) {
                    com.qzone.proxy.feedcomponent.b.e(FeedVideoView.TAG, "[jinqianli] [debug] onVideoPlayComplete()");
                }
                FeedVideoView.this.onVideoStopOrComplete();
            }

            @Override // com.qzone.module.feedcomponent.ui.FeedAutoVideo.OnVideoPlayStatusListener
            public void onVideoPlayStart(BaseVideo baseVideo) {
                FeedVideoView.this.mHasShowAoYunShade = false;
                if (baseVideo instanceof FeedAutoVideo) {
                    FeedVideoView feedVideoView = FeedVideoView.this;
                    if (feedVideoView.mAutoVideoView != null) {
                        if (feedVideoView.showProgress) {
                            FeedVideoView.this.updateProgress(0L, 1L, 0L);
                        }
                        FeedVideoView.this.mMainHandler.post(new Runnable() { // from class: com.qzone.module.feedcomponent.ui.FeedVideoView.10.1
                            @Override // java.lang.Runnable
                            public void run() {
                                FeedVideoView.this.hideDrawActionView();
                                FeedVideoView.this.hideDrawGestureAdView();
                                if (QZoneAdFeedDataExtKt.isDanmakuAdv(FeedVideoView.this.mFeedData)) {
                                    if (QZoneAdFeedDataExtKt.isGdt185AdVideo(FeedVideoView.this.mFeedData)) {
                                        FeedVideoView.this.showBubbleDanmakuAdView();
                                    } else if (QZoneAdFeedDataExtKt.isGdt585AdVideo(FeedVideoView.this.mFeedData)) {
                                        FeedVideoView.this.showFloatDanmakuAdView();
                                    }
                                }
                            }
                        });
                        Log.i(FeedVideoView.TAG, "onVideoPlayStart: ");
                        if (FeedGlobalEnv.g().isDebug()) {
                            com.qzone.proxy.feedcomponent.b.e(FeedVideoView.TAG, "[jinqianli] [debug] onVideoPlayStart()");
                        }
                    }
                }
                BusinessFeedData businessFeedData = FeedVideoView.this.mFeedData;
                if (businessFeedData != null) {
                    businessFeedData.getAdData();
                    if (!FeedVideoView.this.mFeedData.isAdFeeds() || FeedVideoView.this.mFeedData.isBrandUgcAdvFeeds() || TextUtils.isEmpty(QZoneAdFeedDataExtKt.getC2SVideoPlayUrl(FeedVideoView.this.mFeedData)) || TextUtils.isEmpty(QZoneAdFeedDataExtKt.getC2SVideoPlayDuration(FeedVideoView.this.mFeedData)) || !"0".equals(QZoneAdFeedDataExtKt.getC2SVideoPlayDuration(FeedVideoView.this.mFeedData)) || FeedVideoView.this.mFeedData.getOperationInfoV2().IsVideoPlayExpose != 0) {
                        return;
                    }
                    com.qzone.proxy.feedcomponent.b.e(FeedVideoView.TAG, "@adVideoPlayerExpose  onVideoPlayStart =0s");
                    FeedVideoView.this.mFeedData.getOperationInfoV2().IsVideoPlayExpose = 1;
                    com.tencent.gdtad.statistics.a.b(2, 3, GdtFeedUtilForQZone.f(FeedVideoView.this.mFeedData));
                }
            }

            @Override // com.qzone.module.feedcomponent.ui.FeedAutoVideo.OnVideoPlayStatusListener
            public void onVideoPlayStop(BaseVideo baseVideo) {
                if (FeedGlobalEnv.g().isDebug()) {
                    com.qzone.proxy.feedcomponent.b.e(FeedVideoView.TAG, "[onVideoPlayStop]");
                }
                FeedVideoView.this.onVideoStopOrComplete();
            }

            @Override // com.qzone.module.feedcomponent.ui.FeedAutoVideo.OnVideoPlayStatusListener
            public void onVideoPlayProgressUpdate(BaseVideo baseVideo) {
                VideoInfo videoInfo;
                String str;
                int i3;
                if (!(baseVideo instanceof FeedAutoVideo) || FeedVideoView.this.mAutoVideoView == null) {
                    return;
                }
                FeedAutoVideo feedAutoVideo = (FeedAutoVideo) baseVideo;
                long j3 = feedAutoVideo.getmCurPositionMills();
                final long j16 = feedAutoVideo.getmTotalDurationMills();
                long j17 = j16 - j3;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("onVideoPlayProgressUpdate: ");
                sb5.append(j3);
                sb5.append("/");
                sb5.append(j16);
                sb5.append(" ");
                sb5.append(baseVideo == FeedVideoView.this.mAutoVideoView);
                Log.i(FeedVideoView.TAG, sb5.toString());
                FeedVideoView feedVideoView = FeedVideoView.this;
                BusinessFeedData businessFeedData = feedVideoView.mFeedData;
                if (businessFeedData != null && feedVideoView.onFeedElementClickListener != null && businessFeedData.isAdFeeds() && !FeedVideoView.this.mFeedData.isBrandUgcAdvFeeds() && !TextUtils.isEmpty(QZoneAdFeedDataExtKt.getC2SVideoPlayDuration(FeedVideoView.this.mFeedData)) && !"0".equals(QZoneAdFeedDataExtKt.getC2SVideoPlayDuration(FeedVideoView.this.mFeedData)) && !TextUtils.isEmpty(QZoneAdFeedDataExtKt.getC2SVideoPlayUrl(FeedVideoView.this.mFeedData)) && FeedVideoView.this.mFeedData.getOperationInfoV2().IsVideoPlayExpose == 0) {
                    try {
                        i3 = Integer.parseInt(QZoneAdFeedDataExtKt.getC2SVideoPlayDuration(FeedVideoView.this.mFeedData));
                    } catch (Exception e16) {
                        com.qzone.proxy.feedcomponent.b.c(FeedVideoView.TAG, "@adVideoPlayerExpose Integer.parseIn playduration erro" + e16);
                        i3 = 0;
                    }
                    long j18 = j3 / 1000;
                    int i16 = i3 / 1000;
                    if (i16 != 0 && i16 == j18) {
                        com.qzone.proxy.feedcomponent.b.e(FeedVideoView.TAG, "@adVideoPlayerExpose  onVideoPlayProgressUpdate playduration is " + i16);
                        FeedVideoView.this.mFeedData.getOperationInfoV2().IsVideoPlayExpose = 1;
                        com.tencent.gdtad.statistics.a.b(2, 3, GdtFeedUtilForQZone.f(FeedVideoView.this.mFeedData));
                    }
                }
                if (FeedVideoView.this.showGestureAction && j16 > FeedVideoView.this.showGestureViewDuration && j17 < FeedVideoView.this.showGestureViewDuration) {
                    FeedVideoView.this.mMainHandler.post(new Runnable() { // from class: com.qzone.module.feedcomponent.ui.FeedVideoView.10.2
                        @Override // java.lang.Runnable
                        public void run() {
                            FeedVideoView.this.showDrawActionView();
                        }
                    });
                    if (!FeedVideoView.this.isSeeking && j17 < 2000 && ((videoInfo = FeedVideoView.this.mVideoInfo) == null || (str = videoInfo.videoId) == null || !str.equals(com.qzone.adapter.feedcomponent.i.H().p0()))) {
                        FeedVideoView.this.isSeeking = true;
                        Log.i(FeedVideoView.TAG, "onVideoPlayProgressUpdate: ready to seek");
                        FeedVideoView.this.mMainHandler.postDelayed(new Runnable() { // from class: com.qzone.module.feedcomponent.ui.FeedVideoView.10.3
                            @Override // java.lang.Runnable
                            public void run() {
                                if (FeedVideoView.this.isSeeking) {
                                    FeedVideoView.this.mAutoVideoView.seekTo(j16 - r0.showGestureViewDuration);
                                    FeedVideoView.this.isSeeking = false;
                                }
                            }
                        }, j17 - 500);
                    }
                }
                if (FeedVideoView.this.isNeedHideShakeMaskView(j3)) {
                    FeedVideoView.this.mHasShowAoYunShade = false;
                }
                if (FeedVideoView.this.isNeedShowShakeMaskView(j3)) {
                    FeedVideoView.this.mHasShowAoYunShade = true;
                    FeedVideoView.this.mMainHandler.post(new Runnable() { // from class: com.qzone.module.feedcomponent.ui.FeedVideoView.10.4
                        @Override // java.lang.Runnable
                        public void run() {
                            FeedVideoView.this.showShakeMaskView();
                        }
                    });
                }
                BusinessFeedData businessFeedData2 = FeedVideoView.this.mFeedData;
                if (businessFeedData2 != null) {
                    QZoneAdFeedData adData = businessFeedData2.getAdData();
                    if (QZoneAdFeedDataExtKt.isGestureAd(FeedVideoView.this.mFeedData) && QZoneAdFeedDataExtKt.isGdt185AdVideo(FeedVideoView.this.mFeedData) && j16 > adData.getGestureAdEndTime() * 1000 && j3 > adData.getGestureAdBeginTime() * 1000 && j3 < adData.getGestureAdEndTime() * 1000) {
                        FeedVideoView.this.mMainHandler.post(new Runnable() { // from class: com.qzone.module.feedcomponent.ui.FeedVideoView.10.5
                            @Override // java.lang.Runnable
                            public void run() {
                                FeedVideoView.this.showDrawGestureAdView();
                            }
                        });
                    }
                    if (QZoneAdFeedDataExtKt.isGestureAd(FeedVideoView.this.mFeedData) && QZoneAdFeedDataExtKt.isGdt185AdVideo(FeedVideoView.this.mFeedData) && (j3 < adData.getGestureAdBeginTime() * 1000 || j3 > adData.getGestureAdEndTime() * 1000)) {
                        FeedVideoView.this.mMainHandler.post(new Runnable() { // from class: com.qzone.module.feedcomponent.ui.FeedVideoView.10.6
                            @Override // java.lang.Runnable
                            public void run() {
                                FeedVideoView.this.hideDrawGestureAdView();
                            }
                        });
                    }
                }
                if (FeedVideoView.this.showProgress) {
                    FeedVideoView.this.updateProgress(j3, j16, feedAutoVideo.getmLastValidPositionMills());
                }
            }
        };
        this.enableRoundedCorner = false;
        this.radii = new float[8];
        this.rightViewOnClickListener = new View.OnClickListener() { // from class: com.qzone.module.feedcomponent.ui.FeedVideoView.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FeedElement feedElement;
                EventCollector.getInstance().onViewClickedBefore(view);
                if (view != null) {
                    FeedVideoView feedVideoView = FeedVideoView.this;
                    if (feedVideoView.onFeedElementClickListener != null) {
                        if (view.equals(feedVideoView.mAvatarOfGdtAdvRightView)) {
                            feedElement = FeedElement.USER_AVATAR;
                        } else if (view.equals(FeedVideoView.this.mTitleOfGdtAdvRightView)) {
                            feedElement = FeedElement.USER_NICKNAME;
                        } else if (view.equals(FeedVideoView.this.mTextOfGdtAdvRightView)) {
                            feedElement = FeedElement.SUMMARY;
                        } else if (view.equals(FeedVideoView.this.mButtonOfGdtAdvRightView)) {
                            feedElement = FeedElement.RECOMM_CLOSE;
                        } else {
                            feedElement = FeedElement.NOTHING;
                        }
                        FeedVideoView feedVideoView2 = FeedVideoView.this;
                        feedVideoView2.onFeedElementClickListener.onClick(feedVideoView2, feedElement, feedVideoView2.mPostion, null);
                    }
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        };
        this.gdtVideoComponentClickListener = new View.OnClickListener() { // from class: com.qzone.module.feedcomponent.ui.FeedVideoView.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FeedElement feedElement;
                EventCollector.getInstance().onViewClickedBefore(view);
                if (view != null) {
                    FeedVideoView feedVideoView = FeedVideoView.this;
                    if (feedVideoView.onFeedElementClickListener != null) {
                        if (!view.equals(feedVideoView.mGdtFloatDanmakuPresenter) && !view.equals(FeedVideoView.this.mGdtBubbleDanmakuPresenter)) {
                            feedElement = FeedElement.NOTHING;
                        } else {
                            feedElement = FeedElement.GDT_DANMAKU_AD_COMPONENT;
                        }
                        FeedVideoView feedVideoView2 = FeedVideoView.this;
                        feedVideoView2.onFeedElementClickListener.onClick(feedVideoView2, feedElement, feedVideoView2.mPostion, null);
                    }
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        };
        initUI(context);
        setFocusable(true);
        setFocusableInTouchMode(true);
    }

    public FeedVideoView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.mEventTagHeight = com.qzone.proxy.feedcomponent.util.g.a(50.0f);
        this.mFeedAutoViewList = new ArrayList();
        this.mRecBusinessFeedDatasSize = -1;
        this.mInterceptTouchEvent = false;
        this.mMaxVideoWidth = 0;
        this.isNeedShowCover = true;
        this.mNeedShowProgressBar = false;
        this.mMainHandler = new Handler(Looper.getMainLooper());
        this.mHasShowAoYunShade = false;
        this.mOnShakeInterface = new FeedVideoSensorManager.ShakeListener() { // from class: com.qzone.module.feedcomponent.ui.FeedVideoView.9
            @Override // com.qzone.module.feedcomponent.ui.FeedVideoSensorManager.ShakeListener
            public void shake() {
                FeedVideoView.this.hideAoYunShader(false);
                ShakeCaiDanAdManager c16 = ShakeCaiDanAdManager.c();
                FeedVideoView feedVideoView = FeedVideoView.this;
                Context context2 = feedVideoView.getContext();
                Activity topActivity = BaseActivity.getTopActivity();
                FeedVideoView feedVideoView2 = FeedVideoView.this;
                c16.d(feedVideoView, context2, topActivity, feedVideoView2.mFeedData, feedVideoView2.mPostion);
            }
        };
        this.mOnVideoPlayListener = new FeedAutoVideo.OnVideoPlayStatusListener() { // from class: com.qzone.module.feedcomponent.ui.FeedVideoView.10
            @Override // com.qzone.module.feedcomponent.ui.FeedAutoVideo.OnVideoPlayStatusListener
            public void onVideoPlayComplete(BaseVideo baseVideo) {
                if (baseVideo instanceof FeedAutoVideo) {
                    FeedVideoView feedVideoView = FeedVideoView.this;
                    if (feedVideoView.mAutoVideoView != null) {
                        feedVideoView.mMainHandler.post(new Runnable() { // from class: com.qzone.module.feedcomponent.ui.FeedVideoView.10.7
                            @Override // java.lang.Runnable
                            public void run() {
                                FeedVideoView.this.hideDrawActionView();
                                FeedVideoView.this.hideDrawGestureAdView();
                            }
                        });
                        Log.i(FeedVideoView.TAG, "onVideoPlayComplete: ");
                        FeedAutoVideo feedAutoVideo = (FeedAutoVideo) baseVideo;
                        FeedVideoView.this.updateProgress(feedAutoVideo.getmTotalDurationMills(), feedAutoVideo.getmTotalDurationMills(), feedAutoVideo.getmTotalDurationMills());
                    }
                }
                if (FeedGlobalEnv.g().isDebug()) {
                    com.qzone.proxy.feedcomponent.b.e(FeedVideoView.TAG, "[jinqianli] [debug] onVideoPlayComplete()");
                }
                FeedVideoView.this.onVideoStopOrComplete();
            }

            @Override // com.qzone.module.feedcomponent.ui.FeedAutoVideo.OnVideoPlayStatusListener
            public void onVideoPlayStart(BaseVideo baseVideo) {
                FeedVideoView.this.mHasShowAoYunShade = false;
                if (baseVideo instanceof FeedAutoVideo) {
                    FeedVideoView feedVideoView = FeedVideoView.this;
                    if (feedVideoView.mAutoVideoView != null) {
                        if (feedVideoView.showProgress) {
                            FeedVideoView.this.updateProgress(0L, 1L, 0L);
                        }
                        FeedVideoView.this.mMainHandler.post(new Runnable() { // from class: com.qzone.module.feedcomponent.ui.FeedVideoView.10.1
                            @Override // java.lang.Runnable
                            public void run() {
                                FeedVideoView.this.hideDrawActionView();
                                FeedVideoView.this.hideDrawGestureAdView();
                                if (QZoneAdFeedDataExtKt.isDanmakuAdv(FeedVideoView.this.mFeedData)) {
                                    if (QZoneAdFeedDataExtKt.isGdt185AdVideo(FeedVideoView.this.mFeedData)) {
                                        FeedVideoView.this.showBubbleDanmakuAdView();
                                    } else if (QZoneAdFeedDataExtKt.isGdt585AdVideo(FeedVideoView.this.mFeedData)) {
                                        FeedVideoView.this.showFloatDanmakuAdView();
                                    }
                                }
                            }
                        });
                        Log.i(FeedVideoView.TAG, "onVideoPlayStart: ");
                        if (FeedGlobalEnv.g().isDebug()) {
                            com.qzone.proxy.feedcomponent.b.e(FeedVideoView.TAG, "[jinqianli] [debug] onVideoPlayStart()");
                        }
                    }
                }
                BusinessFeedData businessFeedData = FeedVideoView.this.mFeedData;
                if (businessFeedData != null) {
                    businessFeedData.getAdData();
                    if (!FeedVideoView.this.mFeedData.isAdFeeds() || FeedVideoView.this.mFeedData.isBrandUgcAdvFeeds() || TextUtils.isEmpty(QZoneAdFeedDataExtKt.getC2SVideoPlayUrl(FeedVideoView.this.mFeedData)) || TextUtils.isEmpty(QZoneAdFeedDataExtKt.getC2SVideoPlayDuration(FeedVideoView.this.mFeedData)) || !"0".equals(QZoneAdFeedDataExtKt.getC2SVideoPlayDuration(FeedVideoView.this.mFeedData)) || FeedVideoView.this.mFeedData.getOperationInfoV2().IsVideoPlayExpose != 0) {
                        return;
                    }
                    com.qzone.proxy.feedcomponent.b.e(FeedVideoView.TAG, "@adVideoPlayerExpose  onVideoPlayStart =0s");
                    FeedVideoView.this.mFeedData.getOperationInfoV2().IsVideoPlayExpose = 1;
                    com.tencent.gdtad.statistics.a.b(2, 3, GdtFeedUtilForQZone.f(FeedVideoView.this.mFeedData));
                }
            }

            @Override // com.qzone.module.feedcomponent.ui.FeedAutoVideo.OnVideoPlayStatusListener
            public void onVideoPlayStop(BaseVideo baseVideo) {
                if (FeedGlobalEnv.g().isDebug()) {
                    com.qzone.proxy.feedcomponent.b.e(FeedVideoView.TAG, "[onVideoPlayStop]");
                }
                FeedVideoView.this.onVideoStopOrComplete();
            }

            @Override // com.qzone.module.feedcomponent.ui.FeedAutoVideo.OnVideoPlayStatusListener
            public void onVideoPlayProgressUpdate(BaseVideo baseVideo) {
                VideoInfo videoInfo;
                String str;
                int i36;
                if (!(baseVideo instanceof FeedAutoVideo) || FeedVideoView.this.mAutoVideoView == null) {
                    return;
                }
                FeedAutoVideo feedAutoVideo = (FeedAutoVideo) baseVideo;
                long j3 = feedAutoVideo.getmCurPositionMills();
                final long j16 = feedAutoVideo.getmTotalDurationMills();
                long j17 = j16 - j3;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("onVideoPlayProgressUpdate: ");
                sb5.append(j3);
                sb5.append("/");
                sb5.append(j16);
                sb5.append(" ");
                sb5.append(baseVideo == FeedVideoView.this.mAutoVideoView);
                Log.i(FeedVideoView.TAG, sb5.toString());
                FeedVideoView feedVideoView = FeedVideoView.this;
                BusinessFeedData businessFeedData = feedVideoView.mFeedData;
                if (businessFeedData != null && feedVideoView.onFeedElementClickListener != null && businessFeedData.isAdFeeds() && !FeedVideoView.this.mFeedData.isBrandUgcAdvFeeds() && !TextUtils.isEmpty(QZoneAdFeedDataExtKt.getC2SVideoPlayDuration(FeedVideoView.this.mFeedData)) && !"0".equals(QZoneAdFeedDataExtKt.getC2SVideoPlayDuration(FeedVideoView.this.mFeedData)) && !TextUtils.isEmpty(QZoneAdFeedDataExtKt.getC2SVideoPlayUrl(FeedVideoView.this.mFeedData)) && FeedVideoView.this.mFeedData.getOperationInfoV2().IsVideoPlayExpose == 0) {
                    try {
                        i36 = Integer.parseInt(QZoneAdFeedDataExtKt.getC2SVideoPlayDuration(FeedVideoView.this.mFeedData));
                    } catch (Exception e16) {
                        com.qzone.proxy.feedcomponent.b.c(FeedVideoView.TAG, "@adVideoPlayerExpose Integer.parseIn playduration erro" + e16);
                        i36 = 0;
                    }
                    long j18 = j3 / 1000;
                    int i16 = i36 / 1000;
                    if (i16 != 0 && i16 == j18) {
                        com.qzone.proxy.feedcomponent.b.e(FeedVideoView.TAG, "@adVideoPlayerExpose  onVideoPlayProgressUpdate playduration is " + i16);
                        FeedVideoView.this.mFeedData.getOperationInfoV2().IsVideoPlayExpose = 1;
                        com.tencent.gdtad.statistics.a.b(2, 3, GdtFeedUtilForQZone.f(FeedVideoView.this.mFeedData));
                    }
                }
                if (FeedVideoView.this.showGestureAction && j16 > FeedVideoView.this.showGestureViewDuration && j17 < FeedVideoView.this.showGestureViewDuration) {
                    FeedVideoView.this.mMainHandler.post(new Runnable() { // from class: com.qzone.module.feedcomponent.ui.FeedVideoView.10.2
                        @Override // java.lang.Runnable
                        public void run() {
                            FeedVideoView.this.showDrawActionView();
                        }
                    });
                    if (!FeedVideoView.this.isSeeking && j17 < 2000 && ((videoInfo = FeedVideoView.this.mVideoInfo) == null || (str = videoInfo.videoId) == null || !str.equals(com.qzone.adapter.feedcomponent.i.H().p0()))) {
                        FeedVideoView.this.isSeeking = true;
                        Log.i(FeedVideoView.TAG, "onVideoPlayProgressUpdate: ready to seek");
                        FeedVideoView.this.mMainHandler.postDelayed(new Runnable() { // from class: com.qzone.module.feedcomponent.ui.FeedVideoView.10.3
                            @Override // java.lang.Runnable
                            public void run() {
                                if (FeedVideoView.this.isSeeking) {
                                    FeedVideoView.this.mAutoVideoView.seekTo(j16 - r0.showGestureViewDuration);
                                    FeedVideoView.this.isSeeking = false;
                                }
                            }
                        }, j17 - 500);
                    }
                }
                if (FeedVideoView.this.isNeedHideShakeMaskView(j3)) {
                    FeedVideoView.this.mHasShowAoYunShade = false;
                }
                if (FeedVideoView.this.isNeedShowShakeMaskView(j3)) {
                    FeedVideoView.this.mHasShowAoYunShade = true;
                    FeedVideoView.this.mMainHandler.post(new Runnable() { // from class: com.qzone.module.feedcomponent.ui.FeedVideoView.10.4
                        @Override // java.lang.Runnable
                        public void run() {
                            FeedVideoView.this.showShakeMaskView();
                        }
                    });
                }
                BusinessFeedData businessFeedData2 = FeedVideoView.this.mFeedData;
                if (businessFeedData2 != null) {
                    QZoneAdFeedData adData = businessFeedData2.getAdData();
                    if (QZoneAdFeedDataExtKt.isGestureAd(FeedVideoView.this.mFeedData) && QZoneAdFeedDataExtKt.isGdt185AdVideo(FeedVideoView.this.mFeedData) && j16 > adData.getGestureAdEndTime() * 1000 && j3 > adData.getGestureAdBeginTime() * 1000 && j3 < adData.getGestureAdEndTime() * 1000) {
                        FeedVideoView.this.mMainHandler.post(new Runnable() { // from class: com.qzone.module.feedcomponent.ui.FeedVideoView.10.5
                            @Override // java.lang.Runnable
                            public void run() {
                                FeedVideoView.this.showDrawGestureAdView();
                            }
                        });
                    }
                    if (QZoneAdFeedDataExtKt.isGestureAd(FeedVideoView.this.mFeedData) && QZoneAdFeedDataExtKt.isGdt185AdVideo(FeedVideoView.this.mFeedData) && (j3 < adData.getGestureAdBeginTime() * 1000 || j3 > adData.getGestureAdEndTime() * 1000)) {
                        FeedVideoView.this.mMainHandler.post(new Runnable() { // from class: com.qzone.module.feedcomponent.ui.FeedVideoView.10.6
                            @Override // java.lang.Runnable
                            public void run() {
                                FeedVideoView.this.hideDrawGestureAdView();
                            }
                        });
                    }
                }
                if (FeedVideoView.this.showProgress) {
                    FeedVideoView.this.updateProgress(j3, j16, feedAutoVideo.getmLastValidPositionMills());
                }
            }
        };
        this.enableRoundedCorner = false;
        this.radii = new float[8];
        this.rightViewOnClickListener = new View.OnClickListener() { // from class: com.qzone.module.feedcomponent.ui.FeedVideoView.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FeedElement feedElement;
                EventCollector.getInstance().onViewClickedBefore(view);
                if (view != null) {
                    FeedVideoView feedVideoView = FeedVideoView.this;
                    if (feedVideoView.onFeedElementClickListener != null) {
                        if (view.equals(feedVideoView.mAvatarOfGdtAdvRightView)) {
                            feedElement = FeedElement.USER_AVATAR;
                        } else if (view.equals(FeedVideoView.this.mTitleOfGdtAdvRightView)) {
                            feedElement = FeedElement.USER_NICKNAME;
                        } else if (view.equals(FeedVideoView.this.mTextOfGdtAdvRightView)) {
                            feedElement = FeedElement.SUMMARY;
                        } else if (view.equals(FeedVideoView.this.mButtonOfGdtAdvRightView)) {
                            feedElement = FeedElement.RECOMM_CLOSE;
                        } else {
                            feedElement = FeedElement.NOTHING;
                        }
                        FeedVideoView feedVideoView2 = FeedVideoView.this;
                        feedVideoView2.onFeedElementClickListener.onClick(feedVideoView2, feedElement, feedVideoView2.mPostion, null);
                    }
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        };
        this.gdtVideoComponentClickListener = new View.OnClickListener() { // from class: com.qzone.module.feedcomponent.ui.FeedVideoView.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FeedElement feedElement;
                EventCollector.getInstance().onViewClickedBefore(view);
                if (view != null) {
                    FeedVideoView feedVideoView = FeedVideoView.this;
                    if (feedVideoView.onFeedElementClickListener != null) {
                        if (!view.equals(feedVideoView.mGdtFloatDanmakuPresenter) && !view.equals(FeedVideoView.this.mGdtBubbleDanmakuPresenter)) {
                            feedElement = FeedElement.NOTHING;
                        } else {
                            feedElement = FeedElement.GDT_DANMAKU_AD_COMPONENT;
                        }
                        FeedVideoView feedVideoView2 = FeedVideoView.this;
                        feedVideoView2.onFeedElementClickListener.onClick(feedVideoView2, feedElement, feedVideoView2.mPostion, null);
                    }
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        };
        initUI(context);
        setFocusable(true);
        setFocusableInTouchMode(true);
    }
}
