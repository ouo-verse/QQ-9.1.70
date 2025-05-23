package com.qzone.module.feedcomponent.ui;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qzone.canvasui.widget.CanvasQcircleRecomBottomView;
import com.qzone.commoncode.module.videorecommend.widget.PopupText;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdFeedDataExtKt;
import com.qzone.proxy.feedcomponent.model.t;
import com.qzone.proxy.feedcomponent.text.CellTextView;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qzoneplayer.video.AutoVideoProgressRecorder;
import com.tencent.mobileqq.qzoneplayer.video.BaseVideo;
import com.tencent.mobileqq.qzoneplayer.video.BaseVideoCover;
import com.tencent.mobileqq.qzoneplayer.video.BaseVideoManager;
import com.tencent.mobileqq.qzoneplayer.video.BaseVideoManagerUtils;
import com.tencent.mobileqq.qzoneplayer.video.DescTextView;
import com.tencent.mobileqq.qzoneplayer.video.FeedVideoElement;
import com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv;
import com.tencent.mobileqq.qzoneplayer.video.SoundLines;
import com.tencent.mobileqq.qzoneplayer.video.VideoPlayInfo;
import com.tencent.mobileqq.qzoneplayer.video.VideoPlayInfoHolder;
import com.tencent.mobileqq.winkpublish.publishconst.FSUploadConst;
import com.tencent.oskplayer.util.PlayerUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.TipsElementData;
import com.tencent.qqnt.kernel.nativeinterface.JsonGrayBusiId;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FeedAutoVideo extends BaseVideo {
    private static final long FRIEND_LIKE_VIDEO_DESC_SHOW_TIME_LIMIT = 3;
    protected static final String KEY_SHOW_RAPID_FORWARD_LAYOUT_GUIDE = "FeedAutoVideo.Key_show_rapid_forward_layout_guide";
    public static final int REQUEST_DATA_BEFORE_TIME = 5;
    private static final String SOUND_ICON_CONTENT_DESCRIPTION_CLOSED = "\u53d6\u6d88\u9759\u97f3";
    private static final String SOUND_ICON_CONTENT_DESCRIPTION_OPENED = "\u9759\u97f3";
    static final String TAG = "FeedAutoVideo";
    static int alphaAnimationDuration = 3;
    private static final Object mLockObj = new Object();
    static int sBaseId;
    private LinearLayout FriendLikeVideoDescLinearLayout;
    private com.qzone.proxy.feedcomponent.ui.f advButtonAnimationListener;
    boolean clickReplay;
    private long friendLikeVideoDescStartTime;
    boolean hasRecievedData;
    boolean hasRequestData;
    private boolean isFriendLikeContainer;
    boolean isStop;
    CanvasQcircleRecomBottomView mBottomView;
    boolean mCheckM3U8IsStop;
    int mCheckTimes;
    long mCurPositionMills;
    long mCurrentPlaySecond;
    long mCurrentPositionMills;
    private float mDownX;
    private float mDownY;
    BusinessFeedData mFeedData;
    private TextView mFriendLikeVideoDesc;
    ImageView mGdtAdVideoVolumeImg;
    private int mHasSeeCurrentTime;
    boolean mIsForwardFeeds;
    private boolean mIsNeedRapidForwardLayout;
    private boolean mIsVideoPicMixMode;
    long mLastValidPositionMills;
    View mMaskView;
    private OnVideoPlayStatusListener mOnVideoPlayStatusListener;
    private int mOriginalPicHeight;
    private int mOriginalPicWidth;
    long mPlayId;
    private LinearLayout mRapidForwardLayout;
    FeedVideoRecommView mRecommView;
    private CellTextView mRemarkView;
    int mSeq;
    private int mShowTimeRapidForwardBeginTime;
    private int mShowTimeRapidForwardLimitMinTime;
    private int mShowTimeRapidForwardTime;
    int mTSSeq;
    TextView mTextView;
    long mTotalDurationMills;
    boolean mVideoClick;
    LinearLayout mVideoDescLayer;
    private long mVideoPlayStartTime;
    TextView mView;
    Matrix matrix;
    private boolean needUpdateFriendLikeVideoDescTime;
    private Runnable onVideoStartCallback;
    BaseVideoManager.VideoPlayInfoListener videoPlayInfoListener;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface OnVideoPlayStatusListener {
        void onVideoPlayComplete(BaseVideo baseVideo);

        void onVideoPlayProgressUpdate(BaseVideo baseVideo);

        void onVideoPlayStart(BaseVideo baseVideo);

        void onVideoPlayStop(BaseVideo baseVideo);
    }

    public FeedAutoVideo(Context context) {
        super(context);
        this.matrix = new Matrix();
        this.mCurrentPositionMills = 0L;
        this.mCheckTimes = 0;
        this.needUpdateFriendLikeVideoDescTime = false;
        this.friendLikeVideoDescStartTime = 0L;
        this.mIsNeedRapidForwardLayout = false;
        this.mShowTimeRapidForwardBeginTime = -1;
        this.mShowTimeRapidForwardTime = -1;
        this.mShowTimeRapidForwardLimitMinTime = -1;
        this.mHasSeeCurrentTime = 0;
        this.onVideoStartCallback = null;
        this.videoPlayInfoListener = new BaseVideoManager.VideoPlayInfoListener() { // from class: com.qzone.module.feedcomponent.ui.FeedAutoVideo.8
            private void invokeGdtVideoStatusListener() {
                OnVideoPlayStatusListener onVideoPlayStatusListener = FeedAutoVideo.this.mOnVideoPlayStatusListener;
                if (onVideoPlayStatusListener != null) {
                    onVideoPlayStatusListener.onVideoPlayStop(FeedAutoVideo.this);
                    return;
                }
                FeedAutoVideo.this.debugLog(FeedAutoVideo.TAG, "onVideoPlayStop has been recycled " + FeedAutoVideo.this.feedPosition);
            }

            @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideoManager.VideoPlayInfoListener
            public void onVideoPlayComplete(VideoPlayInfoHolder videoPlayInfoHolder) {
                if (FeedAutoVideo.this.mOnVideoPlayStatusListener != null) {
                    synchronized (FeedAutoVideo.mLockObj) {
                        if (FeedAutoVideo.this.mOnVideoPlayStatusListener != null) {
                            FeedAutoVideo.this.mOnVideoPlayStatusListener.onVideoPlayComplete(FeedAutoVideo.this);
                        }
                    }
                }
                FeedAutoVideo.this.hideRaidForwardLayout();
                FeedAutoVideo.this.debugLog(FeedAutoVideo.TAG, "onVideoPlayComplete");
                FeedAutoVideo.this.reportVideoPlayToTTT(videoPlayInfoHolder);
                FeedAutoVideo.this.setGdtAdVideoPlayingStatus(false);
            }

            @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideoManager.VideoPlayInfoListener
            public void onVideoPlayError(VideoPlayInfoHolder videoPlayInfoHolder) {
                FeedAutoVideo.this.debugLog(FeedAutoVideo.TAG, "onVideoPlayError error detail=" + videoPlayInfoHolder.errorDetail + " error type=" + videoPlayInfoHolder.errorType);
                if (FeedAutoVideo.this.mOnVideoPlayStatusListener != null) {
                    synchronized (FeedAutoVideo.mLockObj) {
                        if (FeedAutoVideo.this.mOnVideoPlayStatusListener != null) {
                            FeedAutoVideo.this.mOnVideoPlayStatusListener.onVideoPlayComplete(FeedAutoVideo.this);
                        }
                    }
                }
                FeedAutoVideo.this.hideRaidForwardLayout();
                FeedAutoVideo.this.setGdtAdVideoPlayingStatus(false);
            }

            @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideoManager.VideoPlayInfoListener
            public void onVideoPlayPause(VideoPlayInfoHolder videoPlayInfoHolder) {
                FeedAutoVideo.this.hideRaidForwardLayout();
                FeedAutoVideo.this.reportVideoPlayToTTT(videoPlayInfoHolder);
                FeedAutoVideo.this.setGdtAdVideoPlayingStatus(false);
            }

            @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideoManager.VideoPlayInfoListener
            public void onVideoPlayProgressUpdate(VideoPlayInfoHolder videoPlayInfoHolder) {
                OnVideoPlayStatusListener onVideoPlayStatusListener = FeedAutoVideo.this.mOnVideoPlayStatusListener;
                FeedAutoVideo.this.mHasSeeCurrentTime++;
                FeedAutoVideo feedAutoVideo = FeedAutoVideo.this;
                feedAutoVideo.mCurPositionMills = videoPlayInfoHolder == null ? 0L : videoPlayInfoHolder.currentPositionMills;
                feedAutoVideo.mTotalDurationMills = videoPlayInfoHolder == null ? 1L : videoPlayInfoHolder.totalDurationMills;
                feedAutoVideo.mLastValidPositionMills = videoPlayInfoHolder == null ? 0L : videoPlayInfoHolder.lastValidPositionMills;
                if (onVideoPlayStatusListener != null) {
                    onVideoPlayStatusListener.onVideoPlayProgressUpdate(feedAutoVideo);
                }
                FeedAutoVideo feedAutoVideo2 = FeedAutoVideo.this;
                feedAutoVideo2.showOrHideRapidForwardLayout(videoPlayInfoHolder, feedAutoVideo2.mHasSeeCurrentTime);
                if (FeedAutoVideo.this.needShowMoreRecomm()) {
                    FeedAutoVideo feedAutoVideo3 = FeedAutoVideo.this;
                    if (!feedAutoVideo3.hasRequestData && FeedVideoRecommView.isSupportWidthHeight(feedAutoVideo3.getVideoCoverWidth(), FeedAutoVideo.this.getVideoCoverHeight()) && videoPlayInfoHolder != null) {
                        long j3 = videoPlayInfoHolder.totalDurationSec;
                        if (j3 < 5 || j3 < videoPlayInfoHolder.currentPositionSec + 5) {
                            FeedAutoVideo feedAutoVideo4 = FeedAutoVideo.this;
                            t tVar = new t(feedAutoVideo4.mHandler, feedAutoVideo4.mFeedData, FeedVideoRecommView.getSupportVideoNum(feedAutoVideo4.getVideoCoverWidth(), FeedAutoVideo.this.getVideoCoverHeight()));
                            FeedAutoVideo feedAutoVideo5 = FeedAutoVideo.this;
                            com.tencent.mobileqq.qzoneplayer.video.g gVar = feedAutoVideo5.onFeedVideoElementClickListener;
                            if (gVar != null) {
                                gVar.onClick(((BaseVideo) feedAutoVideo5).mVideoView, FeedVideoElement.FEEDVIDEO_GET_MORE_RECOMMEND_REQ, FeedAutoVideo.this.feedPosition, tVar);
                            }
                            FeedAutoVideo.this.hasRequestData = true;
                        }
                    }
                }
                if (FeedAutoVideo.this.needUpdateFriendLikeVideoDescTime) {
                    if (videoPlayInfoHolder != null) {
                        FeedAutoVideo.this.friendLikeVideoDescStartTime = videoPlayInfoHolder.currentPositionSec;
                    }
                    FeedAutoVideo.this.needUpdateFriendLikeVideoDescTime = false;
                }
                if (videoPlayInfoHolder != null) {
                    FeedAutoVideo feedAutoVideo6 = FeedAutoVideo.this;
                    feedAutoVideo6.checkHideFriendLikeVideoDesc(feedAutoVideo6.friendLikeVideoDescStartTime, videoPlayInfoHolder.currentPositionSec);
                }
                AnimationViewHelper.getAdvButtonAnimation(FeedAutoVideo.this.mFeedData.getFeedCommInfo());
                if (videoPlayInfoHolder != null) {
                    FeedAutoVideo.a(FeedAutoVideo.this);
                }
                FeedAutoVideo.this.setGdtAdVideoPlayingStatus(true);
                if (FeedAutoVideo.this.onVideoStartCallback != null) {
                    FeedAutoVideo feedAutoVideo7 = FeedAutoVideo.this;
                    long j16 = feedAutoVideo7.mLastValidPositionMills;
                    if ((j16 != 0 || feedAutoVideo7.mCurPositionMills <= 0) && feedAutoVideo7.mCurPositionMills >= j16) {
                        return;
                    }
                    feedAutoVideo7.onVideoStartCallback.run();
                }
            }

            @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideoManager.VideoPlayInfoListener
            public void onVideoPlayStart(VideoPlayInfoHolder videoPlayInfoHolder) {
                if (FeedAutoVideo.this.mOnVideoPlayStatusListener != null) {
                    synchronized (FeedAutoVideo.mLockObj) {
                        OnVideoPlayStatusListener onVideoPlayStatusListener = FeedAutoVideo.this.mOnVideoPlayStatusListener;
                        if (onVideoPlayStatusListener != null) {
                            onVideoPlayStatusListener.onVideoPlayStart(FeedAutoVideo.this);
                        }
                    }
                }
                FeedAutoVideo.this.mVideoPlayStartTime = System.currentTimeMillis();
                FeedAutoVideo.this.mHasSeeCurrentTime = 0;
                FeedAutoVideo.this.hideRaidForwardLayout();
                FeedAutoVideo feedAutoVideo = FeedAutoVideo.this;
                feedAutoVideo.mSeq = 0;
                feedAutoVideo.mCurrentPlaySecond = 0L;
                feedAutoVideo.mTotalDurationMills = videoPlayInfoHolder == null ? 1L : videoPlayInfoHolder.totalDurationMills;
                feedAutoVideo.mVideoClick = false;
                feedAutoVideo.needUpdateFriendLikeVideoDescTime = true;
                PlayerUtils.runOnUiThread(new Runnable() { // from class: com.qzone.module.feedcomponent.ui.FeedAutoVideo.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (FeedAutoVideo.this.mFriendLikeVideoDesc != null) {
                            FeedAutoVideo.this.mFriendLikeVideoDesc.setVisibility(0);
                        }
                    }
                });
                FeedAutoVideo.this.setGdtAdVideoVolumeEnabled();
                FeedAutoVideo.this.setGdtAdVideoPlayingStatus(true);
                com.qzone.adapter.feedcomponent.i.H().J1(1);
            }

            @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideoManager.VideoPlayInfoListener
            public void onVideoPlayStop(VideoPlayInfoHolder videoPlayInfoHolder) {
                invokeGdtVideoStatusListener();
                FeedAutoVideo.this.hideRaidForwardLayout();
                FeedAutoVideo.this.mHasSeeCurrentTime = 0;
                FeedAutoVideo.this.reportVideoPlayToTTT(videoPlayInfoHolder);
                FeedAutoVideo.this.setGdtAdVideoPlayingStatus(false);
            }
        };
        setFocusable(true);
        setFocusableInTouchMode(true);
        setContentDescription("\u89c6\u9891");
        this.LOG_TAG = TAG;
        initData();
    }

    static /* bridge */ /* synthetic */ com.qzone.proxy.feedcomponent.ui.f a(FeedAutoVideo feedAutoVideo) {
        feedAutoVideo.getClass();
        return null;
    }

    private void addGdtVideoVolumeImg() {
        String str;
        BusinessFeedData businessFeedData = this.mFeedData;
        if ((businessFeedData != null && businessFeedData.isSupportSoundPlayOut()) || QZoneAdFeedDataExtKt.isGdt585AdVideo(this.mFeedData)) {
            final Drawable g16 = com.qzone.adapter.feedcomponent.j.g(922);
            final Drawable g17 = com.qzone.adapter.feedcomponent.j.g(923);
            if (this.mGdtAdVideoVolumeImg == null) {
                this.mGdtAdVideoVolumeImg = new ImageView(getContext());
                setGdtVideoVolumeIcon(g16, g17);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 85;
                layoutParams.rightMargin = com.qzone.proxy.feedcomponent.util.g.a(0.0f);
                layoutParams.bottomMargin = com.qzone.proxy.feedcomponent.util.g.a(5.0f);
                BusinessFeedData businessFeedData2 = this.mFeedData;
                if (businessFeedData2 != null && QZoneAdFeedDataExtKt.isGdt585AdVideo(businessFeedData2)) {
                    layoutParams.bottomMargin = com.qzone.proxy.feedcomponent.util.g.a(7.0f);
                }
                ImageView imageView = this.mGdtAdVideoVolumeImg;
                if (BaseVideoManager.getFeedVideoManager().isCurSoundOpened()) {
                    str = SOUND_ICON_CONTENT_DESCRIPTION_OPENED;
                } else {
                    str = SOUND_ICON_CONTENT_DESCRIPTION_CLOSED;
                }
                imageView.setContentDescription(str);
                this.mGdtAdVideoVolumeImg.setScaleType(ImageView.ScaleType.FIT_START);
                addView(this.mGdtAdVideoVolumeImg, layoutParams);
                this.mGdtAdVideoVolumeImg.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.module.feedcomponent.ui.FeedAutoVideo.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        EventCollector.getInstance().onViewClickedBefore(view);
                        AudioManager audioManager = (AudioManager) FeedAutoVideo.this.getContext().getApplicationContext().getSystemService("audio");
                        if (SystemMethodProxy.getStreamVolume(audioManager, 3) == 0) {
                            audioManager.setStreamVolume(3, (int) (audioManager.getStreamMaxVolume(3) * 0.5d), 4);
                        }
                        if (BaseVideoManager.getFeedVideoManager().isCurSoundOpened()) {
                            BaseVideoManager.getFeedVideoManager().f();
                            FeedAutoVideo.this.setGdtVideoVolumeStatus(false);
                            FeedAutoVideo.this.mGdtAdVideoVolumeImg.setContentDescription(FeedAutoVideo.SOUND_ICON_CONTENT_DESCRIPTION_CLOSED);
                        } else {
                            BaseVideoManager.getFeedVideoManager().enableAutoVideoSound();
                            FeedAutoVideo.this.setGdtVideoVolumeStatus(true);
                            FeedAutoVideo.this.mGdtAdVideoVolumeImg.setContentDescription(FeedAutoVideo.SOUND_ICON_CONTENT_DESCRIPTION_OPENED);
                        }
                        FeedAutoVideo.this.setGdtVideoVolumeIcon(g16, g17);
                        PlayerUtils.runOnUiThread(new Runnable() { // from class: com.qzone.module.feedcomponent.ui.FeedAutoVideo.6.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AnonymousClass6 anonymousClass6 = AnonymousClass6.this;
                                FeedAutoVideo.this.setGdtVideoVolumeIcon(g16, g17);
                            }
                        }, 500);
                        EventCollector.getInstance().onViewClicked(view);
                    }
                });
            }
            hideGdtVolumeImg();
            return;
        }
        ImageView imageView2 = this.mGdtAdVideoVolumeImg;
        if (imageView2 != null) {
            imageView2.setVisibility(8);
        }
    }

    private void checkShowOrHideMask() {
        if (com.qzone.adapter.feedcomponent.i.H().p1()) {
            if (this.mMaskView == null) {
                View view = new View(getContext());
                this.mMaskView = view;
                view.setBackgroundColor(com.qzone.adapter.feedcomponent.j.p());
                addView(this.mMaskView, new FrameLayout.LayoutParams(-1, -1));
            }
            this.mMaskView.setVisibility(0);
            return;
        }
        View view2 = this.mMaskView;
        if (view2 != null) {
            view2.setVisibility(8);
        }
    }

    private void getRemarkView() {
        if (this.mRemarkView == null) {
            CellTextView cellTextView = new CellTextView(getContext());
            this.mRemarkView = cellTextView;
            addView(cellTextView, -1);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mRemarkView.getLayoutParams();
        layoutParams.leftMargin = FeedVideoEnv.dp10;
        this.mRemarkView.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideGdtVolumeImg() {
        ImageView imageView = this.mGdtAdVideoVolumeImg;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        DescTextView descTextView = this.mTimeview;
        if (descTextView != null) {
            descTextView.setPadding(descTextView.getPaddingLeft(), this.mTimeview.getPaddingTop(), this.mTimeview.getPaddingRight(), this.mTimeview.getPaddingBottom());
            this.mTimeview.setVisibility(0);
        }
    }

    private void initQcircleRecommBottomView() {
        BusinessFeedData businessFeedData = this.mFeedData;
        if (businessFeedData != null) {
            CanvasQcircleRecomBottomView canvasQcircleRecomBottomView = this.mBottomView;
            if (canvasQcircleRecomBottomView == null) {
                this.mBottomView = new CanvasQcircleRecomBottomView(getContext(), this.mFeedData, true);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                layoutParams.gravity = 1;
                addView(this.mBottomView, layoutParams);
            } else {
                canvasQcircleRecomBottomView.resetFeedData(businessFeedData, true);
                this.mBottomView.postInvalidate();
            }
            this.mBottomView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rapidForwardButtonEventReport(int i3) {
        String str;
        BusinessFeedData businessFeedData = this.mFeedData;
        if (businessFeedData == null) {
            return;
        }
        int i16 = businessFeedData.feedType;
        if (i16 == 4097) {
            str = "1";
        } else if (i16 == 12289) {
            str = "4";
        } else if (i16 == 2) {
            str = "2";
        } else {
            str = i16 == 3 ? "3" : null;
        }
        if (str != null) {
            com.qzone.adapter.feedcomponent.i.H().f2(668, i3, 1, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGdtAdVideoPlayingStatus(boolean z16) {
        BusinessFeedData businessFeedData = this.mFeedData;
        if (businessFeedData == null || !businessFeedData.isSupportSoundPlayOut() || this.mFeedData.getVideoInfo() == null) {
            return;
        }
        this.mFeedData.getVideoInfo().isGdtAdVideoPlaying = z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGdtAdVideoVolumeEnabled() {
        BusinessFeedData businessFeedData = this.mFeedData;
        if (businessFeedData != null && businessFeedData.isSupportSoundPlayOut()) {
            if (this.mGdtAdVideoVolumeImg == null) {
                return;
            }
            PlayerUtils.runOnUiThread(new Runnable() { // from class: com.qzone.module.feedcomponent.ui.FeedAutoVideo.3
                @Override // java.lang.Runnable
                public void run() {
                    FeedAutoVideo.this.mGdtAdVideoVolumeImg.setVisibility(0);
                    if (((BaseVideo) FeedAutoVideo.this).mTimeview == null || ((BaseVideo) FeedAutoVideo.this).mTimeview.getPaddingRight() == com.qzone.proxy.feedcomponent.util.g.a(30.0f)) {
                        return;
                    }
                    ((BaseVideo) FeedAutoVideo.this).mTimeview.setPadding(((BaseVideo) FeedAutoVideo.this).mTimeview.getPaddingLeft(), ((BaseVideo) FeedAutoVideo.this).mTimeview.getPaddingTop(), com.qzone.proxy.feedcomponent.util.g.a(30.0f), ((BaseVideo) FeedAutoVideo.this).mTimeview.getPaddingRight());
                }
            });
            VideoInfo videoInfo = this.mFeedData.getVideoInfo();
            if (videoInfo != null && videoInfo.isGdtVideoVolumeOpened) {
                BaseVideoManager.getFeedVideoManager().enableAutoVideoSound();
                PlayerUtils.runOnUiThread(new Runnable() { // from class: com.qzone.module.feedcomponent.ui.FeedAutoVideo.4
                    @Override // java.lang.Runnable
                    public void run() {
                        FeedAutoVideo feedAutoVideo = FeedAutoVideo.this;
                        feedAutoVideo.mGdtAdVideoVolumeImg.setImageDrawable(feedAutoVideo.getResDrawable(922));
                    }
                });
                return;
            } else {
                if (this.mFeedData.isGDTAdvFeed()) {
                    BaseVideoManager.getFeedVideoManager().f();
                }
                PlayerUtils.runOnUiThread(new Runnable() { // from class: com.qzone.module.feedcomponent.ui.FeedAutoVideo.5
                    @Override // java.lang.Runnable
                    public void run() {
                        FeedAutoVideo feedAutoVideo = FeedAutoVideo.this;
                        feedAutoVideo.mGdtAdVideoVolumeImg.setImageDrawable(feedAutoVideo.getResDrawable(923));
                    }
                });
                return;
            }
        }
        ImageView imageView = this.mGdtAdVideoVolumeImg;
        if (imageView != null) {
            imageView.post(new Runnable() { // from class: com.qzone.module.feedcomponent.ui.FeedAutoVideo.2
                @Override // java.lang.Runnable
                public void run() {
                    FeedAutoVideo.this.hideGdtVolumeImg();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGdtVideoVolumeStatus(boolean z16) {
        BusinessFeedData businessFeedData = this.mFeedData;
        if (businessFeedData == null || businessFeedData.getVideoInfo() == null) {
            return;
        }
        this.mFeedData.getVideoInfo().isGdtVideoVolumeOpened = z16;
    }

    private void setShowPlayIcon(boolean z16) {
        if (isBaseVideoCoverWrapperNotNull()) {
            this.mVideoCoverWrapper.setShowPlayIcon(z16);
        } else if (isVideoCoverNotNull()) {
            this.mVideoCover.setShowPlayIcon(z16);
            this.mVideoCover.postInvalidate();
        }
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    protected void addAutoVideoCover(Context context) {
        AutoVideoCover autoVideoCover = new AutoVideoCover(context, this);
        this.mVideoCover = autoVideoCover;
        autoVideoCover.setContentDescription(BaseVideoCover.LOG_TAG);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 1;
        addView(this.mVideoCover, layoutParams);
    }

    void debugLog(String str, String str2) {
        com.qzone.proxy.feedcomponent.b.e("LIVE-" + str, str2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        BusinessFeedData businessFeedData;
        if (this.mRecommView != null) {
            if (motionEvent.getAction() == 0) {
                com.qzone.adapter.feedcomponent.i.H().u2(getContext(), false);
            } else if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
                com.qzone.adapter.feedcomponent.i.H().u2(getContext(), true);
            }
        } else {
            BusinessFeedData businessFeedData2 = this.mFeedData;
            if (businessFeedData2 != null && !businessFeedData2.isSubFeed) {
                com.qzone.adapter.feedcomponent.i.H().u2(getContext(), true);
            }
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1 && !isMove(motionEvent.getX(), motionEvent.getY(), this.mDownX, this.mDownY) && (businessFeedData = this.mFeedData) != null && businessFeedData.isQCircleShareCardFeed()) {
                com.qzone.adapter.feedcomponent.i.H().f(805, 3, 2);
            }
        } else {
            this.mDownX = motionEvent.getX();
            this.mDownY = motionEvent.getY();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    public long getCurrentPosition() {
        return this.mCurrentPositionMills;
    }

    Drawable getResDrawable(int i3) {
        return FeedGlobalEnv.getContext().getResources().getDrawable(com.qzone.adapter.feedcomponent.j.h(i3));
    }

    public long getmCurPositionMills() {
        return this.mCurPositionMills;
    }

    public long getmLastValidPositionMills() {
        return this.mLastValidPositionMills;
    }

    public long getmTotalDurationMills() {
        return this.mTotalDurationMills;
    }

    public boolean hasGdtVideoPlayedBefore() {
        if (getVideoPlayInfo() == null || getVideoPlayInfo().videoPlayInfoHolder == null || !getVideoPlayInfo().isGdtAd || getVideoPlayInfo().videoPlayInfoHolder.currentPositionMills <= 0) {
            return false;
        }
        getVideoPlayInfo().videoPlayInfoHolder.currentPositionMills = 0L;
        AutoVideoProgressRecorder.getInstance().putVideoProgerssRecord(getVideoPlayInfo().videoId, getVideoPlayInfo().videoPlayInfoHolder);
        return true;
    }

    protected void hideRaidForwardLayout() {
        if (this.mIsNeedRapidForwardLayout) {
            PlayerUtils.runOnUiThread(new Runnable() { // from class: com.qzone.module.feedcomponent.ui.FeedAutoVideo.13
                @Override // java.lang.Runnable
                public void run() {
                    if (FeedAutoVideo.this.mRapidForwardLayout == null || FeedAutoVideo.this.mRapidForwardLayout.getVisibility() != 0) {
                        return;
                    }
                    TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 1.0f, 1, 0.0f, 1, 0.0f);
                    translateAnimation.setDuration(300L);
                    translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.qzone.module.feedcomponent.ui.FeedAutoVideo.13.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            FeedAutoVideo.this.mRapidForwardLayout.setVisibility(4);
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }
                    });
                    FeedAutoVideo.this.mRapidForwardLayout.startAnimation(translateAnimation);
                }
            });
        }
    }

    protected void hideRecommView() {
        if (this.mRecommView != null) {
            this.hasRequestData = false;
            this.hasRecievedData = false;
            PlayerUtils.runOnUiThread(new Runnable() { // from class: com.qzone.module.feedcomponent.ui.FeedAutoVideo.10
                @Override // java.lang.Runnable
                public void run() {
                    FeedVideoRecommView feedVideoRecommView = FeedAutoVideo.this.mRecommView;
                    if (feedVideoRecommView != null) {
                        feedVideoRecommView.setVisibility(8);
                    }
                }
            });
        }
    }

    public void hideRoundedCover() {
        TextView textView = this.mView;
        if (textView == null || textView.getVisibility() != 0) {
            return;
        }
        this.mView.setVisibility(8);
    }

    public void hideVideoCover() {
        TextView textView = this.mTextView;
        if (textView == null || textView.getVisibility() != 0) {
            return;
        }
        this.mTextView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    public void initChildView() {
        super.initChildView();
        TextView textView = new TextView(getContext());
        this.mView = textView;
        textView.setVisibility(8);
        this.mView.setBackgroundResource(com.qzone.adapter.feedcomponent.j.h(com.tencent.luggage.wxa.sm.e.P));
        ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.mView.setContentDescription("mySelfView");
        addView(this.mView, -1, layoutParams);
        TextView textView2 = new TextView(getContext());
        this.mTextView = textView2;
        textView2.setVisibility(8);
        this.mTextView.setBackgroundResource(com.qzone.adapter.feedcomponent.j.h(775));
        if (com.qzone.adapter.feedcomponent.i.H().p1()) {
            this.mTextView.setBackgroundResource(com.qzone.adapter.feedcomponent.j.h(962));
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        this.mTextView.setContentDescription("myTextView");
        layoutParams2.leftMargin = -1;
        layoutParams2.rightMargin = -1;
        addView(this.mTextView, -2, layoutParams2);
        this.FriendLikeVideoDescLinearLayout = new LinearLayout(getContext());
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.leftMargin = AreaConst.dp6;
        layoutParams3.bottomMargin = AreaConst.dp3_5;
        layoutParams3.gravity = 83;
        TextView textView3 = new TextView(getContext());
        this.mFriendLikeVideoDesc = textView3;
        textView3.setTextColor(Color.parseColor(TipsElementData.DEFAULT_COLOR));
        this.mFriendLikeVideoDesc.setTextSize(14.0f);
        this.mFriendLikeVideoDesc.setVisibility(8);
        this.mFriendLikeVideoDesc.setSingleLine(true);
        this.mFriendLikeVideoDesc.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.mFriendLikeVideoDesc.setMaxWidth(com.qzone.proxy.feedcomponent.util.g.a(267.0f));
        this.mFriendLikeVideoDesc.setContentDescription("\u597d\u53cb\u70ed\u64ad\u89c6\u9891\u63cf\u8ff0");
        this.FriendLikeVideoDescLinearLayout.addView(this.mFriendLikeVideoDesc, -1, new LinearLayout.LayoutParams(-2, -2));
        addView(this.FriendLikeVideoDescLinearLayout, -1, layoutParams3);
    }

    protected void initData() {
        this.mVideoPlayInfoListener = new BaseVideoManager.VideoPlayInfoListener() { // from class: com.qzone.module.feedcomponent.ui.FeedAutoVideo.1
            @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideoManager.VideoPlayInfoListener
            public void onVideoPlayError(VideoPlayInfoHolder videoPlayInfoHolder) {
                com.qzone.adapter.feedcomponent.i.H().F2();
            }

            @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideoManager.VideoPlayInfoListener
            public void onVideoPlayStart(VideoPlayInfoHolder videoPlayInfoHolder) {
                com.qzone.adapter.feedcomponent.i.H().G2();
            }

            @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideoManager.VideoPlayInfoListener
            public void onVideoPlayStop(VideoPlayInfoHolder videoPlayInfoHolder) {
                com.qzone.adapter.feedcomponent.i.H().F2();
            }

            @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideoManager.VideoPlayInfoListener
            public void onVideoPlayComplete(VideoPlayInfoHolder videoPlayInfoHolder) {
            }

            @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideoManager.VideoPlayInfoListener
            public void onVideoPlayPause(VideoPlayInfoHolder videoPlayInfoHolder) {
            }

            @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideoManager.VideoPlayInfoListener
            public void onVideoPlayProgressUpdate(VideoPlayInfoHolder videoPlayInfoHolder) {
            }
        };
    }

    protected void initShowRapidForwardTimeConfig() {
        if (this.mShowTimeRapidForwardLimitMinTime == -1) {
            this.mShowTimeRapidForwardLimitMinTime = com.qzone.adapter.feedcomponent.i.H().S("QZoneSetting", "VideoShowRapidForwardMinTime", 10);
        }
        if (this.mShowTimeRapidForwardTime == -1) {
            this.mShowTimeRapidForwardTime = com.qzone.adapter.feedcomponent.i.H().S("QZoneSetting", "VideoShowRapidForwardTime", 5);
        }
        if (this.mShowTimeRapidForwardBeginTime == -1) {
            this.mShowTimeRapidForwardBeginTime = com.qzone.adapter.feedcomponent.i.H().S("QZoneSetting", "VideoShowRapidForwardBeginTime", 5);
        }
    }

    protected boolean isHideRapidForwardLayout(VideoPlayInfoHolder videoPlayInfoHolder, int i3) {
        LinearLayout linearLayout;
        return this.mIsNeedRapidForwardLayout && (i3 - this.mShowTimeRapidForwardBeginTime) - this.mShowTimeRapidForwardTime >= 0 && (linearLayout = this.mRapidForwardLayout) != null && linearLayout.getVisibility() == 0;
    }

    public boolean isMove(float f16, float f17, float f18, float f19) {
        if (getContext() != null && ViewConfiguration.get(getContext()) != null) {
            int scaledTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
            float abs = Math.abs(f16 - f18);
            float f26 = scaledTouchSlop;
            if (abs <= f26 && Math.abs(f17 - f19) <= f26) {
                return false;
            }
        }
        return true;
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    protected boolean isSetBackgroundColor() {
        return !isWeishiVideo(getVideoPlayInfo());
    }

    protected boolean isShowRapidForwardLayout(VideoPlayInfoHolder videoPlayInfoHolder, int i3) {
        initShowRapidForwardTimeConfig();
        return this.mIsNeedRapidForwardLayout && videoPlayInfoHolder.totalDurationSec > ((long) this.mShowTimeRapidForwardLimitMinTime) && i3 == this.mShowTimeRapidForwardBeginTime;
    }

    public boolean isValidVideo() {
        return getVideoPlayInfo() != null;
    }

    public boolean isVideoPicMixMode() {
        return this.mIsVideoPicMixMode;
    }

    protected boolean needShowMoreRecomm() {
        BusinessFeedData businessFeedData = this.mFeedData;
        if (businessFeedData == null) {
            return false;
        }
        return (!this.mIsForwardFeeds || businessFeedData.getOriginalInfo() == null) ? this.mFeedData.getVideoInfo() != null && this.mFeedData.getVideoInfo().isGetRecommAfterPlay == 1 : this.mFeedData.getOriginalInfo().getVideoInfo() != null && this.mFeedData.getOriginalInfo().getVideoInfo().isGetRecommAfterPlay == 1;
    }

    public void onClickMoreVideo(View view) {
        com.tencent.mobileqq.qzoneplayer.video.g gVar = this.onFeedVideoElementClickListener;
        if (gVar != null) {
            gVar.onClick(view, FeedVideoElement.FEEDVIDEO_GOTO_VIDEO_TAB, this.feedPosition, 0);
            this.mFeedData.setVideoRecommAutoPlay(false);
        }
    }

    public void onClickReplay(View view) {
        com.tencent.mobileqq.qzoneplayer.video.g gVar = this.onFeedVideoElementClickListener;
        if (gVar != null) {
            gVar.onClick(view, FeedVideoElement.AUTO_VIDEO, this.feedPosition, this.mVideoPlayInfo);
            this.clickReplay = true;
            this.mFeedData.setVideoRecommAutoPlay(true);
            com.qzone.adapter.feedcomponent.i.H().Z1("4", "");
        }
    }

    public void onClickVideo(View view, com.qzone.proxy.feedcomponent.model.h hVar) {
        com.tencent.mobileqq.qzoneplayer.video.g gVar = this.onFeedVideoElementClickListener;
        if (gVar != null) {
            gVar.onClick(view, FeedVideoElement.FEEDVIDEO_PLAY_RECOMMEND, this.feedPosition, hVar);
            this.mFeedData.setVideoRecommAutoPlay(false);
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        TextView textView;
        if (this.mFeedData != null && (textView = this.mTextView) != null) {
            ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                if (this.mFeedData.isGDTAdvFeed()) {
                    ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = 0;
                } else {
                    ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = -1;
                }
            }
        }
        CellTextView cellTextView = this.mRemarkView;
        if (cellTextView != null && cellTextView.getVisibility() == 0) {
            ViewGroup.LayoutParams layoutParams2 = this.mRemarkView.getLayoutParams();
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = (getHeight() - this.mRemarkView.getHeight()) - FeedVideoEnv.f279795dp3;
            }
        }
        super.onLayout(z16, i3, i16, i17, i18);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i3, int i16) {
        BaseVideoCover baseVideoCover;
        BusinessFeedData businessFeedData;
        CellTextView cellTextView;
        if (QZoneAdFeedDataExtKt.isGdt585AdVideo(this.mFeedData)) {
            resetGdt585AdVideoSize(i3, i16);
            measureCover(i3, i16);
        } else {
            BusinessFeedData businessFeedData2 = this.mFeedData;
            if (businessFeedData2 != null && businessFeedData2.isQCircleShareCardFeed() && (baseVideoCover = this.mVideoCover) != null) {
                ((AutoVideoCover) baseVideoCover).fitQcircleShareFeed();
                measureCover(i3, i16);
            } else {
                resetWeishiVideoSize(i3, i16);
                measureCover(i3, i16);
            }
        }
        LinearLayout linearLayout = this.mVideoDescLayer;
        if (linearLayout != null && linearLayout.getVisibility() != 8) {
            LinearLayout linearLayout2 = this.mVideoDescLayer;
            linearLayout2.measure(ViewGroup.getChildMeasureSpec(i3, 0, linearLayout2.getLayoutParams().width), ViewGroup.getChildMeasureSpec(i3, 0, this.mVideoDescLayer.getLayoutParams().height));
        }
        int videoCoverHeight = getVideoCoverHeight();
        VideoPlayInfo videoPlayInfo = this.mVideoPlayInfo;
        if (videoPlayInfo != null && !TextUtils.isEmpty(videoPlayInfo.getDisplayRemark()) && !this.mVideoPlayInfo.isInvalidState() && this.remarkLayout.getVisibility() != 8) {
            this.remarkLayout.measure(View.MeasureSpec.makeMeasureSpec(getVideoCoverWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(FeedVideoEnv.REMARK_LAYOUT_HEIGHT, 1073741824));
            videoCoverHeight += FeedVideoEnv.REMARK_LAYOUT_HEIGHT;
        }
        VideoPlayInfo videoPlayInfo2 = this.mVideoPlayInfo;
        if (videoPlayInfo2 != null && !TextUtils.isEmpty(videoPlayInfo2.getDisplayRemark()) && !this.mVideoPlayInfo.isInvalidState() && (cellTextView = this.mRemarkView) != null && cellTextView.getVisibility() != 8) {
            int size = View.MeasureSpec.getSize(i3);
            DescTextView descTextView = this.mTimeview;
            if (descTextView != null && descTextView.getVisibility() != 8) {
                size -= this.mTimeview.getMeasuredWidth();
            }
            SoundLines soundLines = this.mSoundLinesLayout;
            if (soundLines != null && soundLines.getVisibility() != 8) {
                size -= this.mSoundLinesLayout.getMeasuredWidth();
            }
            this.mRemarkView.measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), i16);
        }
        measureVideoView(i3, i16);
        FeedVideoRecommView feedVideoRecommView = this.mRecommView;
        if (feedVideoRecommView != null) {
            feedVideoRecommView.measure(i3, i16);
        }
        if (this.mGdtAdVideoVolumeImg != null && (businessFeedData = this.mFeedData) != null && businessFeedData.isSupportSoundPlayOut() && this.mGdtAdVideoVolumeImg.getVisibility() == 0) {
            this.mGdtAdVideoVolumeImg.measure(View.MeasureSpec.makeMeasureSpec(com.qzone.proxy.feedcomponent.util.g.a(26.0f), 1073741824), View.MeasureSpec.makeMeasureSpec(com.qzone.proxy.feedcomponent.util.g.a(11.5f), 1073741824));
        }
        TextView textView = this.mView;
        if (textView != null) {
            textView.measure(View.MeasureSpec.makeMeasureSpec(getVideoCoverWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(videoCoverHeight, 1073741824));
        }
        TextView textView2 = this.mTextView;
        if (textView2 != null) {
            if (this.isFriendLikeContainer) {
                textView2.measure(i3, i16);
            } else {
                textView2.measure(View.MeasureSpec.makeMeasureSpec(getVideoCoverWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(videoCoverHeight, 1073741824));
            }
        }
        View view = this.mMaskView;
        if (view != null) {
            if (this.isFriendLikeContainer) {
                view.measure(i3, i16);
            } else {
                view.measure(View.MeasureSpec.makeMeasureSpec(getVideoCoverWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(videoCoverHeight, 1073741824));
            }
        }
        CanvasQcircleRecomBottomView canvasQcircleRecomBottomView = this.mBottomView;
        if (canvasQcircleRecomBottomView != null) {
            canvasQcircleRecomBottomView.measure(View.MeasureSpec.makeMeasureSpec(getVideoCoverWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(videoCoverHeight, 1073741824));
        }
        LinearLayout linearLayout3 = this.FriendLikeVideoDescLinearLayout;
        if (linearLayout3 != null) {
            linearLayout3.measure(i3, i16);
        }
        LinearLayout linearLayout4 = this.mRapidForwardLayout;
        if (linearLayout4 != null) {
            linearLayout4.measure(View.MeasureSpec.makeMeasureSpec(getVideoCoverWidth(), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(FeedVideoEnv.dpToPx(30.0f), 1073741824));
        }
        if (isWeishiVideo(getVideoPlayInfo())) {
            onSetMeasureDimensionForWeishi(View.MeasureSpec.getSize(i3), videoCoverHeight);
        } else if (QZoneAdFeedDataExtKt.isGdt585AdVideo(this.mFeedData)) {
            onSetMeasureDimensionForGdt585AdVideo(View.MeasureSpec.makeMeasureSpec(com.qzone.proxy.feedcomponent.util.g.a(181.0f), 1073741824), View.MeasureSpec.makeMeasureSpec(com.qzone.proxy.feedcomponent.util.g.a(323.0f), 1073741824));
        } else {
            onSetMeasuredDimension(getVideoCoverWidth(), videoCoverHeight);
        }
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    public void onPause() {
        BaseVideoManagerUtils.ChangeSurfaceResult changeSurfaceResult;
        debugLog(TAG, MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
        BaseVideoManagerUtils.ChangeSurfaceHolder globalChangeSurfaceHolder = BaseVideoManagerUtils.getGlobalChangeSurfaceHolder();
        if (globalChangeSurfaceHolder != null && (changeSurfaceResult = globalChangeSurfaceHolder.changeSurfaceResult) != null && changeSurfaceResult.isSwitchBackSurfaceOccurred) {
            super.onPause();
            return;
        }
        VideoPlayInfo videoPlayInfo = this.mVideoPlayInfo;
        if (videoPlayInfo != null && !videoPlayInfo.k() && globalChangeSurfaceHolder != null) {
            com.qzone.proxy.feedcomponent.b.e(this.LOG_TAG, "onPause does nothing");
        } else {
            super.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    public void onReceivedMessage(Message message) {
        DescTextView descTextView;
        DescTextView descTextView2;
        super.onReceivedMessage(message);
        int i3 = message.what;
        if (i3 == 1) {
            DescTextView descTextView3 = this.mTimeview;
            if (descTextView3 != null) {
                BaseVideo.setViewVisibility(descTextView3, this.hasTimeview ? 0 : 8);
            }
            if (!this.mIsVideoPicMixMode || (descTextView = this.mTimeview) == null) {
                return;
            }
            BaseVideo.setViewVisibility(descTextView, 0);
            return;
        }
        if (i3 != 5) {
            if (i3 == 256 && this.mFeedData != null) {
                this.hasRecievedData = true;
                showRecommView();
                return;
            }
            return;
        }
        if (!this.mIsVideoPicMixMode || (descTextView2 = this.mTimeview) == null) {
            return;
        }
        BaseVideo.setViewVisibility(descTextView2, 8);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo, com.tencent.mobileqq.qzoneplayer.video.Recycleable
    public void onRecycled() {
        FeedVideoRecommView feedVideoRecommView = this.mRecommView;
        if (feedVideoRecommView != null) {
            feedVideoRecommView.onRecycled();
        }
        this.mOnVideoPlayStatusListener = null;
        BaseVideoManagerUtils.ChangeSurfaceHolder globalChangeSurfaceHolder = BaseVideoManagerUtils.getGlobalChangeSurfaceHolder();
        if (globalChangeSurfaceHolder == null || globalChangeSurfaceHolder.oldSurface != this) {
            super.onRecycled();
        }
    }

    public void onReportExposed(View view, ArrayList<com.qzone.proxy.feedcomponent.model.h> arrayList) {
        com.tencent.mobileqq.qzoneplayer.video.g gVar = this.onFeedVideoElementClickListener;
        if (gVar != null) {
            gVar.onClick(view, FeedVideoElement.FEEDVIDEO_REPORT_RECOMMEND_EXPOSED, this.feedPosition, arrayList);
        }
    }

    protected void onSetMeasureDimensionForGdt585AdVideo(int i3, int i16) {
        onSetMeasuredDimension(i3, i16);
    }

    protected void onSetMeasureDimensionForWeishi(int i3, int i16) {
        VideoPlayInfo videoPlayInfo = getVideoPlayInfo();
        if (videoPlayInfo != null) {
            int i17 = videoPlayInfo.width;
            int i18 = videoPlayInfo.height;
            if (i18 != 0 && i17 != 0) {
                double d16 = i17 / i18;
                if (Math.abs(d16 - 1.7777777777777777d) >= 0.1d && Math.abs(d16 - 1.3333333333333333d) >= 0.1d) {
                    if (d16 < 1.3333333333333333d) {
                        onSetMeasuredDimension(i3, (int) (i3 * 0.5625d));
                        return;
                    } else {
                        onSetMeasuredDimension(i3, (int) (i3 * 0.5625d));
                        return;
                    }
                }
            }
        }
        onSetMeasuredDimension(i3, i16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    public void onSetVideoPlayInfo(VideoPlayInfo videoPlayInfo) {
        super.onSetVideoPlayInfo(videoPlayInfo);
        if (this.mIsForwardFeeds) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
            marginLayoutParams.leftMargin = 0;
            setLayoutParams(marginLayoutParams);
        }
        BusinessFeedData businessFeedData = this.mFeedData;
        if (businessFeedData != null && businessFeedData.isAdFeeds() && this.mFeedData.getLocalInfo() != null && this.mFeedData.getLocalInfo().canLike && this.mFeedData.getLocalInfo().canShare && this.mFeedData.getLocalInfo().canComment && this.mFeedData.getRecommHeader() != null && this.mFeedData.getRecommAction() != null && this.mFeedData.getRecommAction().isHideActionArea == 0) {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) getLayoutParams();
            marginLayoutParams2.leftMargin = 0;
            setLayoutParams(marginLayoutParams2);
        }
        BusinessFeedData businessFeedData2 = this.mFeedData;
        if (businessFeedData2 != null && businessFeedData2.getAllVideoInfo() != null && this.mFeedData.getAllVideoInfo() != null) {
            this.mFeedData.getAllVideoInfo();
        }
        getBaseVideoManager().schedulePreload(videoPlayInfo);
    }

    public void onShowPage(int i3) {
        BusinessFeedData businessFeedData = this.mFeedData;
        if (businessFeedData != null) {
            businessFeedData.setRecommendPageIndex(i3);
        }
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    protected void onVideoClick() {
        com.qzone.adapter.feedcomponent.i.H();
        com.qzone.adapter.feedcomponent.i.f41887a = true;
        BusinessFeedData businessFeedData = this.mFeedData;
        if (businessFeedData != null && !businessFeedData.isSubFeed) {
            BaseVideoManagerUtils.ChangeSurfaceHolder changeSurfaceHolder = new BaseVideoManagerUtils.ChangeSurfaceHolder();
            changeSurfaceHolder.oldSurface = this;
            BaseVideoManagerUtils.setGlobalChangeSurfaceHolder(changeSurfaceHolder);
        }
        debugLog(TAG, "onVideoClick");
        this.mVideoClick = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    public void playSoundLines() {
        super.playSoundLines();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    public void reLayoutSurfaceView(BaseVideo.VideoSize videoSize) {
        int videoCoverWidth = getVideoCoverWidth();
        int videoCoverHeight = getVideoCoverHeight();
        this.matrix.reset();
        if (this.mIsVideoPicMixMode) {
            BaseVideo.VideoSize videoSize2 = new BaseVideo.VideoSize(videoCoverWidth, videoCoverHeight);
            this.mVideoSize = videoSize2;
            super.reLayoutSurfaceView(videoSize2);
            initMatrix(videoCoverWidth, videoCoverHeight, this.mOriginalPicWidth, this.mOriginalPicHeight);
            View view = this.mVideoView;
            if (view instanceof TextureView) {
                ((TextureView) view).setTransform(this.matrix);
                return;
            }
            return;
        }
        if (com.qzone.proxy.feedcomponent.model.c.c(this.mFeedData)) {
            int i3 = this.mFeedData.getVideoInfo().width;
            int i16 = this.mFeedData.getVideoInfo().height;
            if (i3 < i16) {
                initCenterCropMatrix(getVideoCoverWidth(), getVideoCoverHeight(), i3, i16);
            } else {
                initFitCenterMatrix(getVideoCoverWidth(), getVideoCoverHeight(), i3, i16);
            }
            View view2 = this.mVideoView;
            if (view2 instanceof TextureView) {
                ((TextureView) view2).setTransform(this.matrix);
                return;
            }
            return;
        }
        View view3 = this.mVideoView;
        if (view3 instanceof TextureView) {
            ((TextureView) view3).setTransform(this.matrix);
        }
        super.reLayoutSurfaceView(videoSize);
    }

    protected void reportVideoPlayToTTT(VideoPlayInfoHolder videoPlayInfoHolder) {
        if (this.mVideoPlayStartTime > 0) {
            com.qzone.adapter.feedcomponent.i.H().x(this.mFeedData.getRecommendReportUUID(), 12, 20, 31, this.mFeedData, this.feedPosition, System.currentTimeMillis() - this.mVideoPlayStartTime);
            this.mVideoPlayStartTime = 0L;
        }
    }

    protected void resetGdt585AdVideoSize(int i3, int i16) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mVideoCover.getLayoutParams();
        layoutParams.width = com.qzone.proxy.feedcomponent.util.g.a(181.0f);
        layoutParams.height = com.qzone.proxy.feedcomponent.util.g.a(323.0f);
        this.mVideoView.setLayoutParams(layoutParams);
        this.mVideoView.requestLayout();
    }

    protected void resetWeishiVideoSize(int i3, int i16) {
        FrameLayout.LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2;
        if (this.mVideoCover != null) {
            if (isWeishiVideo(getVideoPlayInfo()) || isFrdContainerVideo(getVideoPlayInfo())) {
                if (isWeishiVideo(getVideoPlayInfo())) {
                    int size = (int) ((View.MeasureSpec.getSize(i3) / 16.0d) * 9.0d);
                    if ((this.mVideoCover.getPicHeight() > 0 && Math.abs((this.mVideoCover.getPicWidth() / this.mVideoCover.getPicHeight()) - 1.7777777777777777d) < 0.1d) || Math.abs((this.mVideoCover.getPicWidth() / this.mVideoCover.getPicHeight()) - 1.3333333333333333d) < 0.1d) {
                        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.mVideoCover.getLayoutParams();
                        if (layoutParams3 == null || layoutParams3.gravity == 1) {
                            return;
                        }
                        layoutParams3.gravity = 1;
                        this.mVideoCover.setLayoutParams(layoutParams3);
                        return;
                    }
                    if (this.mVideoCover.getPicHeight() > size && this.mVideoCover.getPicHeight() > 0) {
                        int picWidth = (this.mVideoCover.getPicWidth() * size) / this.mVideoCover.getPicHeight();
                        ((AutoVideoCover) this.mVideoCover).setPicWidth(picWidth);
                        ((AutoVideoCover) this.mVideoCover).setPicHeight(size);
                        FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) this.mVideoCover.getLayoutParams();
                        if (layoutParams4 != null && layoutParams4.gravity != 1) {
                            layoutParams4.gravity = 1;
                            this.mVideoCover.setLayoutParams(layoutParams4);
                        }
                        View view = this.mVideoView;
                        if (view == null || (layoutParams2 = view.getLayoutParams()) == null) {
                            return;
                        }
                        layoutParams2.width = picWidth;
                        this.mVideoView.setLayoutParams(layoutParams2);
                        return;
                    }
                    if (this.mVideoCover.getPicHeight() < size && this.mVideoCover.getPicHeight() > 0) {
                        FrameLayout.LayoutParams layoutParams5 = (FrameLayout.LayoutParams) this.mVideoCover.getLayoutParams();
                        if (layoutParams5 == null || layoutParams5.gravity == 17) {
                            return;
                        }
                        layoutParams5.gravity = 17;
                        this.mVideoCover.setLayoutParams(layoutParams5);
                        return;
                    }
                    FrameLayout.LayoutParams layoutParams6 = (FrameLayout.LayoutParams) this.mVideoCover.getLayoutParams();
                    if (layoutParams6 == null || layoutParams6.gravity == 1) {
                        return;
                    }
                    layoutParams6.gravity = 1;
                    this.mVideoCover.setLayoutParams(layoutParams6);
                    return;
                }
                if (isFrdContainerVideo(getVideoPlayInfo())) {
                    int picWidth2 = this.mVideoCover.getPicWidth();
                    this.mVideoCover.getPicHeight();
                    FrameLayout.LayoutParams layoutParams7 = (FrameLayout.LayoutParams) this.mVideoCover.getLayoutParams();
                    if (layoutParams7 != null) {
                        layoutParams7.gravity = 17;
                        this.mVideoCover.setLayoutParams(layoutParams7);
                    }
                    View view2 = this.mVideoView;
                    if (view2 == null || (layoutParams = (FrameLayout.LayoutParams) view2.getLayoutParams()) == null) {
                        return;
                    }
                    layoutParams.width = picWidth2;
                    layoutParams.gravity = 17;
                    this.mVideoView.setLayoutParams(layoutParams);
                    return;
                }
                FrameLayout.LayoutParams layoutParams8 = (FrameLayout.LayoutParams) this.mVideoCover.getLayoutParams();
                if (layoutParams8 == null || layoutParams8.gravity == 1) {
                    return;
                }
                layoutParams8.gravity = 1;
                this.mVideoCover.setLayoutParams(layoutParams8);
            }
        }
    }

    public void seekTo(long j3) {
        BaseVideoManager.getFeedVideoManager().seekVideoRealManual((int) j3);
    }

    public void setAdjustToHeight(boolean z16, int i3) {
        ((AutoVideoCover) this.mVideoCover).setAdjustToHeight(z16, i3);
    }

    public void setAdjustToWidth(boolean z16, int i3) {
        ((AutoVideoCover) this.mVideoCover).setAdjustToWidth(z16, i3);
    }

    public void setFeedData(BusinessFeedData businessFeedData) {
        BusinessFeedData businessFeedData2;
        this.mFeedData = businessFeedData;
        if (this.isStop && this.hasRecievedData) {
            showRecommView();
            com.qzone.adapter.feedcomponent.i.H().w2(this.mFeedData.getVideoRecommAutoPlay());
        } else {
            hideRecommView();
            com.qzone.adapter.feedcomponent.i.H().w2(true);
        }
        addGdtVideoVolumeImg();
        checkShowOrHideMask();
        if (businessFeedData != null && (businessFeedData2 = businessFeedData.parentFeedData) != null && businessFeedData2.isFriendLikeContainer()) {
            this.isFriendLikeContainer = true;
        } else {
            this.isFriendLikeContainer = false;
        }
        if (QZoneAdFeedDataExtKt.isGdt585AdVideo(this.mFeedData)) {
            setGdtAdVideoVolumeEnabled();
        } else if (this.mIsVideoPicMixMode) {
            DescTextView descTextView = this.mTimeview;
            if (descTextView != null) {
                BaseVideo.setViewVisibility(descTextView, 8);
            }
            this.hasPlayCountView = false;
        } else if (this.isFriendLikeContainer) {
            this.hasPlayCountView = false;
            this.hasSoundLinesLayout = false;
        } else if (businessFeedData != null && businessFeedData.getVideoInfo() != null && !TextUtils.isEmpty(businessFeedData.getVideoInfo().gauseBackgroudUrl)) {
            this.hasPlayCountView = false;
            this.hasSoundLinesLayout = true;
        } else {
            this.hasPlayCountView = true;
            this.hasSoundLinesLayout = true;
        }
        if (this.mFeedData.isSoundIconEnabled()) {
            this.hasSoundLinesLayout = false;
        }
        initQcircleRecommBottomView();
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    public void setFeedPos(int i3, int i16) {
        super.setFeedPos(i3, i16);
        setTag(com.qzone.adapter.feedcomponent.j.O(JsonGrayBusiId.AIO_ZPLAN_SCENE_LINKAGE), Integer.valueOf(i16));
        LinearLayout linearLayout = this.mRapidForwardLayout;
        if (linearLayout != null) {
            linearLayout.setTag(com.qzone.adapter.feedcomponent.j.O(JsonGrayBusiId.AIO_ZPLAN_SCENE_LINKAGE), Integer.valueOf(i16));
        }
    }

    public void setForceToWH(boolean z16, int i3, int i16) {
        ((AutoVideoCover) this.mVideoCover).setForceToWH(z16, i3, i16);
    }

    public void setIsCenterCrop(boolean z16) {
        ((AutoVideoCover) this.mVideoCover).setIsCenterCrop(z16);
    }

    public void setIsCenterInside(boolean z16) {
        ((AutoVideoCover) this.mVideoCover).setIsFitCenter(z16);
    }

    public void setIsClipCoverCenter(boolean z16) {
        ((AutoVideoCover) this.mVideoCover).setIsClipCoverCenter(z16);
    }

    public void setIsFeedTypeDetail(boolean z16) {
        if (!isBaseVideoCoverWrapperNotNull() && isVideoCoverNotNull()) {
            ((AutoVideoCover) this.mVideoCover).setIsFeedTypeDetail(z16);
        }
    }

    public void setIsForwardFeeds(boolean z16) {
        this.mIsForwardFeeds = z16;
        if (!isBaseVideoCoverWrapperNotNull() && isVideoCoverNotNull()) {
            ((AutoVideoCover) this.mVideoCover).setIsForward(z16);
        }
        if (z16) {
            setBackgroundColor(com.qzone.adapter.feedcomponent.j.c(12));
        }
    }

    public void setLikeFriendVideo(boolean z16) {
        if (!isBaseVideoCoverWrapperNotNull() && isVideoCoverNotNull()) {
            this.mVideoCover.setLikeFriendVideo(z16);
        }
    }

    public void setOnVideoPlayStatusListener(OnVideoPlayStatusListener onVideoPlayStatusListener) {
        this.mOnVideoPlayStatusListener = onVideoPlayStatusListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setRemarkLayoutTrans(int i3) {
        RelativeLayout relativeLayout = this.remarkLayout;
        if (relativeLayout != null) {
            com.qzone.reborn.feedx.widget.i.a(relativeLayout, i3);
        }
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    public void setVideoOriginalSize(int i3, int i16) {
        this.mOriginalPicWidth = i3;
        this.mOriginalPicHeight = i16;
    }

    public void setVideoPicMixMode(boolean z16) {
        this.mIsVideoPicMixMode = z16;
        if (!isBaseVideoCoverWrapperNotNull() && isVideoCoverNotNull()) {
            this.mVideoCover.setVideoPicMixMode(z16);
        }
    }

    public void setVideoPicMixModeClipSize(int i3) {
        if (!isBaseVideoCoverWrapperNotNull() && isVideoCoverNotNull()) {
            this.mVideoCover.setVideoPicMixModeClipSize(i3);
        }
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    public void setVideoPlayInfo(VideoPlayInfo videoPlayInfo) {
        BaseVideoCover baseVideoCover;
        BaseVideoCover baseVideoCover2;
        BaseVideo baseVideo;
        BaseVideoCover baseVideoCover3 = this.mVideoCover;
        if (baseVideoCover3 != null) {
            baseVideoCover3.setShowOpenFreeTrafficIcon(false);
        }
        BaseVideoManagerUtils.ChangeSurfaceHolder globalChangeSurfaceHolder = BaseVideoManagerUtils.getGlobalChangeSurfaceHolder();
        if (globalChangeSurfaceHolder != null && (baseVideo = globalChangeSurfaceHolder.oldSurface) == this && baseVideo != null && baseVideo.isPlayingTheSameVideo(videoPlayInfo)) {
            setShowPlayIcon(true);
            BaseVideoManager.getFeedVideoManager().setVideoPlayInfoListener(this.videoPlayInfoListener);
            return;
        }
        if (videoPlayInfo == this.mVideoPlayInfo) {
            return;
        }
        if (videoPlayInfo != null && videoPlayInfo.isAdvMicro) {
            this.hasTimeview = false;
            if (!isBaseVideoCoverWrapperNotNull() && isVideoCoverNotNull() && (baseVideoCover2 = this.mVideoCover) != null) {
                ((AutoVideoCover) baseVideoCover2).setCoverHide(true);
            }
        } else if (QZoneAdFeedDataExtKt.isGdt585AdVideo(this.mFeedData)) {
            this.hasTimeview = true;
        } else {
            if (!isBaseVideoCoverWrapperNotNull() && isVideoCoverNotNull() && (baseVideoCover = this.mVideoCover) != null) {
                ((AutoVideoCover) baseVideoCover).setCoverHide(false);
            }
            this.hasTimeview = true;
        }
        setShowRaidForwardLayoutFlag(videoPlayInfo);
        super.setVideoPlayInfo(videoPlayInfo);
        setVideoDescLayer(videoPlayInfo);
        if (videoPlayInfo != null && isWeishiVideo(videoPlayInfo)) {
            RelativeLayout relativeLayout = this.remarkLayout;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(8);
            }
            if (!TextUtils.isEmpty(videoPlayInfo.getDisplayRemark())) {
                getRemarkView();
                this.mRemarkView.setVisibility(0);
                this.mRemarkView.setRichText(videoPlayInfo.getDisplayRemark());
                this.mRemarkView.setTextColor(-1);
                this.mRemarkView.setTextSize(com.qzone.proxy.feedcomponent.util.g.a(13.0f));
                this.mRemarkView.setMaxLine(1);
                this.mRemarkView.setContentDescription(videoPlayInfo.getDisplayRemark());
            }
            setBackgroundForWeishi(videoPlayInfo);
            DescTextView descTextView = this.mPlayCountView;
            if (descTextView != null) {
                descTextView.setVisibility(8);
            }
            this.hasPlayCountView = false;
            return;
        }
        CellTextView cellTextView = this.mRemarkView;
        if (cellTextView != null) {
            cellTextView.setVisibility(8);
        }
        if (this.mPlayCountView != null) {
            this.hasPlayCountView = true;
        }
    }

    public void setVideoPlayStartListener(Runnable runnable) {
        this.onVideoStartCallback = runnable;
    }

    protected void showOrHideRapidForwardLayout(VideoPlayInfoHolder videoPlayInfoHolder, int i3) {
        if (isShowRapidForwardLayout(videoPlayInfoHolder, i3)) {
            showRapidForwardLayout();
        } else if (isHideRapidForwardLayout(videoPlayInfoHolder, i3)) {
            hideRaidForwardLayout();
        }
    }

    protected void showRapidForwardLayout() {
        PlayerUtils.runOnUiThread(new Runnable() { // from class: com.qzone.module.feedcomponent.ui.FeedAutoVideo.12
            @Override // java.lang.Runnable
            public void run() {
                if (FeedAutoVideo.this.mIsNeedRapidForwardLayout) {
                    if (FeedAutoVideo.this.mRapidForwardLayout == null) {
                        FeedAutoVideo feedAutoVideo = FeedAutoVideo.this;
                        feedAutoVideo.mRapidForwardLayout = (LinearLayout) LayoutInflater.from(feedAutoVideo.getContext()).inflate(com.qzone.adapter.feedcomponent.j.j(FSUploadConst.ERR_LOGIN_UIN_ILLEGAL), (ViewGroup) null);
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, FeedVideoEnv.dpToPx(30.0f));
                        layoutParams.gravity = 53;
                        layoutParams.height = FeedVideoEnv.dpToPx(30.0f);
                        layoutParams.topMargin = FeedVideoEnv.dp10;
                        FeedAutoVideo feedAutoVideo2 = FeedAutoVideo.this;
                        feedAutoVideo2.addView(feedAutoVideo2.mRapidForwardLayout, layoutParams);
                        FeedAutoVideo.this.mRapidForwardLayout.getBackground().setAlpha(128);
                        FeedAutoVideo.this.mRapidForwardLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.module.feedcomponent.ui.FeedAutoVideo.12.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                EventCollector.getInstance().onViewClickedBefore(view);
                                FeedAutoVideo feedAutoVideo3 = FeedAutoVideo.this;
                                com.tencent.mobileqq.qzoneplayer.video.g gVar = feedAutoVideo3.onFeedVideoElementClickListener;
                                if (gVar != null) {
                                    gVar.onClick(view, FeedVideoElement.FEEDVIDEO_RAPID_FORWARD_BUTTON, feedAutoVideo3.feedPosition, 0);
                                    FeedAutoVideo.this.rapidForwardButtonEventReport(2);
                                    FeedAutoVideo.this.mRapidForwardLayout.setVisibility(4);
                                }
                                EventCollector.getInstance().onViewClicked(view);
                            }
                        });
                    }
                    if (FeedAutoVideo.this.mRapidForwardLayout != null) {
                        FeedAutoVideo.this.mRapidForwardLayout.setVisibility(0);
                        TranslateAnimation translateAnimation = new TranslateAnimation(1, 1.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f);
                        translateAnimation.setDuration(300L);
                        FeedAutoVideo.this.mRapidForwardLayout.setAnimation(translateAnimation);
                        translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.qzone.module.feedcomponent.ui.FeedAutoVideo.12.2
                            @Override // android.view.animation.Animation.AnimationListener
                            public void onAnimationEnd(Animation animation) {
                                if (FeedAutoVideo.this.mIsNeedRapidForwardLayout && PopupText.d(FeedAutoVideo.KEY_SHOW_RAPID_FORWARD_LAYOUT_GUIDE)) {
                                    new PopupText(FeedAutoVideo.this.getContext(), com.qzone.adapter.feedcomponent.h.c(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AudioForwardQuickly", "\u70b9\u51fb\u79d2\u8f6c\uff0c\u5373\u523b\u8f6c\u53d1"), 0).g(FeedAutoVideo.this.mRapidForwardLayout, true);
                                    FeedAutoVideo.this.rapidForwardButtonEventReport(3);
                                }
                            }

                            @Override // android.view.animation.Animation.AnimationListener
                            public void onAnimationRepeat(Animation animation) {
                            }

                            @Override // android.view.animation.Animation.AnimationListener
                            public void onAnimationStart(Animation animation) {
                            }
                        });
                        FeedAutoVideo.this.mRapidForwardLayout.startAnimation(translateAnimation);
                        FeedAutoVideo.this.rapidForwardButtonEventReport(1);
                    }
                }
            }
        });
    }

    protected void showRecommView(ArrayList<com.qzone.proxy.feedcomponent.model.h> arrayList) {
        if (arrayList == null) {
            return;
        }
        if (this.mRecommView == null) {
            this.mRecommView = new FeedVideoRecommView();
        }
        this.mRecommView.setVisibility(0);
        if (!this.mRecommView.attach(getContext(), this, getVideoCoverWidth(), getVideoCoverHeight(), arrayList)) {
            this.mRecommView.setVisibility(8);
            com.qzone.adapter.feedcomponent.i.H().w2(true);
            this.mFeedData.setVideoRecommAutoPlay(true);
            return;
        }
        this.mRecommView.setCurrentItem(this.mFeedData.getRecommendPageIndex());
        setShowPlayIcon(false);
        if (this.clickReplay) {
            com.qzone.adapter.feedcomponent.i.H().w2(true);
            this.mFeedData.setVideoRecommAutoPlay(true);
        } else {
            com.qzone.adapter.feedcomponent.i.H().w2(false);
            this.mFeedData.setVideoRecommAutoPlay(false);
        }
        this.clickReplay = false;
    }

    public void showRoundedCover() {
        if (this.mView.getVisibility() != 0) {
            this.mView.setVisibility(0);
        }
    }

    public void showVideoCover() {
        if (this.mTextView.getVisibility() != 0) {
            this.mTextView.setVisibility(0);
        }
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    public void startLoadingLight(boolean z16) {
        super.startLoadingLight(z16);
        debugLog(TAG, "\u5f00\u59cb\u8fdb\u5165Loading");
        hideRecommView();
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    public void stop() {
        super.videoUIStop();
        BaseVideoManager.getFeedVideoManager().setVideoPlayInfoListener(null);
        this.isStop = true;
        showRecommView();
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    public void updateWithoutDelay(boolean z16) {
        super.updateWithoutDelay(z16);
        hideRecommView();
        BusinessFeedData businessFeedData = this.mFeedData;
        if (businessFeedData.feedType != 2) {
            businessFeedData.setVideoRecommendInfo(null);
        }
        this.isStop = false;
        this.hasRecievedData = false;
        this.hasRequestData = false;
        BaseVideoManager.getFeedVideoManager().setVideoPlayInfoListener(this.videoPlayInfoListener);
    }

    public void hideDurationTextView() {
        this.hasTimeview = false;
        DescTextView descTextView = this.mTimeview;
        if (descTextView != null) {
            BaseVideo.setViewVisibility(descTextView, 8);
        }
    }

    public void hideSoundLine() {
        this.hasSoundLinesLayout = false;
    }

    public void resetCheckTimes() {
        this.mCheckTimes = 0;
    }

    private boolean isFrdContainerVideo(VideoPlayInfo videoPlayInfo) {
        return videoPlayInfo != null && videoPlayInfo.isFrdLikeVideo;
    }

    private boolean isWeishiVideo(VideoPlayInfo videoPlayInfo) {
        return (videoPlayInfo == null || TextUtils.isEmpty(videoPlayInfo.gaussBackgroundUrl)) ? false : true;
    }

    private void setBackgroundForWeishi(VideoPlayInfo videoPlayInfo) {
        if (videoPlayInfo == null || TextUtils.isEmpty(videoPlayInfo.gaussBackgroundUrl)) {
            return;
        }
        ImageLoader.getInstance().loadImageAsync(videoPlayInfo.gaussBackgroundUrl, new AnonymousClass7());
    }

    protected void setShowRaidForwardLayoutFlag(VideoPlayInfo videoPlayInfo) {
        if (videoPlayInfo == null) {
            this.mIsNeedRapidForwardLayout = false;
        } else {
            initShowRapidForwardTimeConfig();
            this.mIsNeedRapidForwardLayout = videoPlayInfo.isShowRapidForwardIcon;
        }
    }

    protected void setVideoDescLayer(VideoPlayInfo videoPlayInfo) {
        CellTextView cellTextView;
        if (videoPlayInfo == null) {
            return;
        }
        if (this.mVideoDescLayer == null && videoPlayInfo.isOriginalContent) {
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(getContext()).inflate(com.qzone.adapter.feedcomponent.j.j(FSUploadConst.ERR_COMPRESS_ENV_UNPREPAERD), (ViewGroup) null);
            this.mVideoDescLayer = linearLayout;
            addView(linearLayout);
        }
        LinearLayout linearLayout2 = this.mVideoDescLayer;
        if (linearLayout2 == null || (cellTextView = (CellTextView) linearLayout2.findViewById(com.qzone.adapter.feedcomponent.j.O(2686))) == null) {
            return;
        }
        BaseVideo.setViewVisibility(cellTextView, videoPlayInfo.isOriginalContent ? 0 : 8);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    public void startLoadingLight() {
        super.startLoadingLight();
        debugLog(TAG, "\u5f00\u59cb\u8fdb\u5165Loading");
        hideRecommView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGdtVideoVolumeIcon(Drawable drawable, Drawable drawable2) {
        if (drawable == null || drawable2 == null || this.mGdtAdVideoVolumeImg == null) {
            return;
        }
        if (BaseVideoManager.getFeedVideoManager().isCurSoundOpened()) {
            this.mGdtAdVideoVolumeImg.setImageDrawable(drawable);
        } else {
            this.mGdtAdVideoVolumeImg.setImageDrawable(drawable2);
        }
    }

    private void initMatrix(int i3, int i16, int i17, int i18) {
        float f16 = i3;
        float f17 = i17;
        float f18 = i16;
        float f19 = i18;
        float max = Math.max(f16 / f17, f18 / f19);
        Matrix matrix = this.matrix;
        if (matrix == null) {
            this.matrix = new Matrix();
        } else {
            matrix.reset();
        }
        if (i17 >= i18) {
            this.matrix.preTranslate((i3 - i17) / 2.0f, (i16 - i18) / 2.0f);
        } else {
            float f26 = (i3 - i17) / 2.0f;
            this.matrix.preTranslate(f26, ((i17 - i18) / 3.0f) + f26);
        }
        this.matrix.preScale(f17 / f16, f19 / f18);
        this.matrix.postScale(max, max, f16 / 2.0f, f18 / 2.0f);
    }

    private void initCenterCropMatrix(int i3, int i16, int i17, int i18) {
        float f16 = (i3 * 1.0f) / i17;
        float f17 = (i16 * 1.0f) / i18;
        float max = Math.max(f16, f17);
        int i19 = i3 / 2;
        int i26 = i16 / 2;
        Matrix matrix = this.matrix;
        if (matrix == null) {
            this.matrix = new Matrix();
        } else {
            matrix.reset();
        }
        this.matrix.setScale(max / f16, max / f17, i19, i26);
    }

    private void initFitCenterMatrix(int i3, int i16, int i17, int i18) {
        float f16 = (i3 * 1.0f) / i17;
        float f17 = (i16 * 1.0f) / i18;
        float min = Math.min(f16, f17);
        int i19 = i3 / 2;
        int i26 = i16 / 2;
        Matrix matrix = this.matrix;
        if (matrix == null) {
            this.matrix = new Matrix();
        } else {
            matrix.reset();
        }
        this.matrix.setScale(min / f16, min / f17, i19, i26);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkHideFriendLikeVideoDesc(long j3, long j16) {
        if (j16 <= j3 || j16 - j3 <= 3) {
            return;
        }
        PlayerUtils.runOnUiThread(new Runnable() { // from class: com.qzone.module.feedcomponent.ui.FeedAutoVideo.9
            @Override // java.lang.Runnable
            public void run() {
                if (FeedAutoVideo.this.mFriendLikeVideoDesc == null || FeedAutoVideo.this.mFriendLikeVideoDesc.getVisibility() != 0) {
                    return;
                }
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setDuration(1000L);
                alphaAnimation.setRepeatCount(0);
                alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.qzone.module.feedcomponent.ui.FeedAutoVideo.9.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        if (FeedAutoVideo.this.mFriendLikeVideoDesc != null) {
                            FeedAutoVideo.this.mFriendLikeVideoDesc.setVisibility(8);
                        }
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }
                });
                FeedAutoVideo.this.mFriendLikeVideoDesc.startAnimation(alphaAnimation);
            }
        });
    }

    protected void showRecommView() {
        if (this.isStop && this.hasRecievedData && this.mFeedData.feedType != 2) {
            PlayerUtils.runOnUiThread(new Runnable() { // from class: com.qzone.module.feedcomponent.ui.FeedAutoVideo.11
                @Override // java.lang.Runnable
                public void run() {
                    ArrayList<com.qzone.proxy.feedcomponent.model.h> d16 = com.qzone.proxy.feedcomponent.ui.c.d(FeedAutoVideo.this.mFeedData);
                    if (d16 != null) {
                        d16.size();
                    }
                    FeedAutoVideo.this.showRecommView(d16);
                }
            });
        }
    }

    public FeedAutoVideo(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.matrix = new Matrix();
        this.mCurrentPositionMills = 0L;
        this.mCheckTimes = 0;
        this.needUpdateFriendLikeVideoDescTime = false;
        this.friendLikeVideoDescStartTime = 0L;
        this.mIsNeedRapidForwardLayout = false;
        this.mShowTimeRapidForwardBeginTime = -1;
        this.mShowTimeRapidForwardTime = -1;
        this.mShowTimeRapidForwardLimitMinTime = -1;
        this.mHasSeeCurrentTime = 0;
        this.onVideoStartCallback = null;
        this.videoPlayInfoListener = new BaseVideoManager.VideoPlayInfoListener() { // from class: com.qzone.module.feedcomponent.ui.FeedAutoVideo.8
            private void invokeGdtVideoStatusListener() {
                OnVideoPlayStatusListener onVideoPlayStatusListener = FeedAutoVideo.this.mOnVideoPlayStatusListener;
                if (onVideoPlayStatusListener != null) {
                    onVideoPlayStatusListener.onVideoPlayStop(FeedAutoVideo.this);
                    return;
                }
                FeedAutoVideo.this.debugLog(FeedAutoVideo.TAG, "onVideoPlayStop has been recycled " + FeedAutoVideo.this.feedPosition);
            }

            @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideoManager.VideoPlayInfoListener
            public void onVideoPlayComplete(VideoPlayInfoHolder videoPlayInfoHolder) {
                if (FeedAutoVideo.this.mOnVideoPlayStatusListener != null) {
                    synchronized (FeedAutoVideo.mLockObj) {
                        if (FeedAutoVideo.this.mOnVideoPlayStatusListener != null) {
                            FeedAutoVideo.this.mOnVideoPlayStatusListener.onVideoPlayComplete(FeedAutoVideo.this);
                        }
                    }
                }
                FeedAutoVideo.this.hideRaidForwardLayout();
                FeedAutoVideo.this.debugLog(FeedAutoVideo.TAG, "onVideoPlayComplete");
                FeedAutoVideo.this.reportVideoPlayToTTT(videoPlayInfoHolder);
                FeedAutoVideo.this.setGdtAdVideoPlayingStatus(false);
            }

            @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideoManager.VideoPlayInfoListener
            public void onVideoPlayError(VideoPlayInfoHolder videoPlayInfoHolder) {
                FeedAutoVideo.this.debugLog(FeedAutoVideo.TAG, "onVideoPlayError error detail=" + videoPlayInfoHolder.errorDetail + " error type=" + videoPlayInfoHolder.errorType);
                if (FeedAutoVideo.this.mOnVideoPlayStatusListener != null) {
                    synchronized (FeedAutoVideo.mLockObj) {
                        if (FeedAutoVideo.this.mOnVideoPlayStatusListener != null) {
                            FeedAutoVideo.this.mOnVideoPlayStatusListener.onVideoPlayComplete(FeedAutoVideo.this);
                        }
                    }
                }
                FeedAutoVideo.this.hideRaidForwardLayout();
                FeedAutoVideo.this.setGdtAdVideoPlayingStatus(false);
            }

            @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideoManager.VideoPlayInfoListener
            public void onVideoPlayPause(VideoPlayInfoHolder videoPlayInfoHolder) {
                FeedAutoVideo.this.hideRaidForwardLayout();
                FeedAutoVideo.this.reportVideoPlayToTTT(videoPlayInfoHolder);
                FeedAutoVideo.this.setGdtAdVideoPlayingStatus(false);
            }

            @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideoManager.VideoPlayInfoListener
            public void onVideoPlayProgressUpdate(VideoPlayInfoHolder videoPlayInfoHolder) {
                OnVideoPlayStatusListener onVideoPlayStatusListener = FeedAutoVideo.this.mOnVideoPlayStatusListener;
                FeedAutoVideo.this.mHasSeeCurrentTime++;
                FeedAutoVideo feedAutoVideo = FeedAutoVideo.this;
                feedAutoVideo.mCurPositionMills = videoPlayInfoHolder == null ? 0L : videoPlayInfoHolder.currentPositionMills;
                feedAutoVideo.mTotalDurationMills = videoPlayInfoHolder == null ? 1L : videoPlayInfoHolder.totalDurationMills;
                feedAutoVideo.mLastValidPositionMills = videoPlayInfoHolder == null ? 0L : videoPlayInfoHolder.lastValidPositionMills;
                if (onVideoPlayStatusListener != null) {
                    onVideoPlayStatusListener.onVideoPlayProgressUpdate(feedAutoVideo);
                }
                FeedAutoVideo feedAutoVideo2 = FeedAutoVideo.this;
                feedAutoVideo2.showOrHideRapidForwardLayout(videoPlayInfoHolder, feedAutoVideo2.mHasSeeCurrentTime);
                if (FeedAutoVideo.this.needShowMoreRecomm()) {
                    FeedAutoVideo feedAutoVideo3 = FeedAutoVideo.this;
                    if (!feedAutoVideo3.hasRequestData && FeedVideoRecommView.isSupportWidthHeight(feedAutoVideo3.getVideoCoverWidth(), FeedAutoVideo.this.getVideoCoverHeight()) && videoPlayInfoHolder != null) {
                        long j3 = videoPlayInfoHolder.totalDurationSec;
                        if (j3 < 5 || j3 < videoPlayInfoHolder.currentPositionSec + 5) {
                            FeedAutoVideo feedAutoVideo4 = FeedAutoVideo.this;
                            t tVar = new t(feedAutoVideo4.mHandler, feedAutoVideo4.mFeedData, FeedVideoRecommView.getSupportVideoNum(feedAutoVideo4.getVideoCoverWidth(), FeedAutoVideo.this.getVideoCoverHeight()));
                            FeedAutoVideo feedAutoVideo5 = FeedAutoVideo.this;
                            com.tencent.mobileqq.qzoneplayer.video.g gVar = feedAutoVideo5.onFeedVideoElementClickListener;
                            if (gVar != null) {
                                gVar.onClick(((BaseVideo) feedAutoVideo5).mVideoView, FeedVideoElement.FEEDVIDEO_GET_MORE_RECOMMEND_REQ, FeedAutoVideo.this.feedPosition, tVar);
                            }
                            FeedAutoVideo.this.hasRequestData = true;
                        }
                    }
                }
                if (FeedAutoVideo.this.needUpdateFriendLikeVideoDescTime) {
                    if (videoPlayInfoHolder != null) {
                        FeedAutoVideo.this.friendLikeVideoDescStartTime = videoPlayInfoHolder.currentPositionSec;
                    }
                    FeedAutoVideo.this.needUpdateFriendLikeVideoDescTime = false;
                }
                if (videoPlayInfoHolder != null) {
                    FeedAutoVideo feedAutoVideo6 = FeedAutoVideo.this;
                    feedAutoVideo6.checkHideFriendLikeVideoDesc(feedAutoVideo6.friendLikeVideoDescStartTime, videoPlayInfoHolder.currentPositionSec);
                }
                AnimationViewHelper.getAdvButtonAnimation(FeedAutoVideo.this.mFeedData.getFeedCommInfo());
                if (videoPlayInfoHolder != null) {
                    FeedAutoVideo.a(FeedAutoVideo.this);
                }
                FeedAutoVideo.this.setGdtAdVideoPlayingStatus(true);
                if (FeedAutoVideo.this.onVideoStartCallback != null) {
                    FeedAutoVideo feedAutoVideo7 = FeedAutoVideo.this;
                    long j16 = feedAutoVideo7.mLastValidPositionMills;
                    if ((j16 != 0 || feedAutoVideo7.mCurPositionMills <= 0) && feedAutoVideo7.mCurPositionMills >= j16) {
                        return;
                    }
                    feedAutoVideo7.onVideoStartCallback.run();
                }
            }

            @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideoManager.VideoPlayInfoListener
            public void onVideoPlayStart(VideoPlayInfoHolder videoPlayInfoHolder) {
                if (FeedAutoVideo.this.mOnVideoPlayStatusListener != null) {
                    synchronized (FeedAutoVideo.mLockObj) {
                        OnVideoPlayStatusListener onVideoPlayStatusListener = FeedAutoVideo.this.mOnVideoPlayStatusListener;
                        if (onVideoPlayStatusListener != null) {
                            onVideoPlayStatusListener.onVideoPlayStart(FeedAutoVideo.this);
                        }
                    }
                }
                FeedAutoVideo.this.mVideoPlayStartTime = System.currentTimeMillis();
                FeedAutoVideo.this.mHasSeeCurrentTime = 0;
                FeedAutoVideo.this.hideRaidForwardLayout();
                FeedAutoVideo feedAutoVideo = FeedAutoVideo.this;
                feedAutoVideo.mSeq = 0;
                feedAutoVideo.mCurrentPlaySecond = 0L;
                feedAutoVideo.mTotalDurationMills = videoPlayInfoHolder == null ? 1L : videoPlayInfoHolder.totalDurationMills;
                feedAutoVideo.mVideoClick = false;
                feedAutoVideo.needUpdateFriendLikeVideoDescTime = true;
                PlayerUtils.runOnUiThread(new Runnable() { // from class: com.qzone.module.feedcomponent.ui.FeedAutoVideo.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (FeedAutoVideo.this.mFriendLikeVideoDesc != null) {
                            FeedAutoVideo.this.mFriendLikeVideoDesc.setVisibility(0);
                        }
                    }
                });
                FeedAutoVideo.this.setGdtAdVideoVolumeEnabled();
                FeedAutoVideo.this.setGdtAdVideoPlayingStatus(true);
                com.qzone.adapter.feedcomponent.i.H().J1(1);
            }

            @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideoManager.VideoPlayInfoListener
            public void onVideoPlayStop(VideoPlayInfoHolder videoPlayInfoHolder) {
                invokeGdtVideoStatusListener();
                FeedAutoVideo.this.hideRaidForwardLayout();
                FeedAutoVideo.this.mHasSeeCurrentTime = 0;
                FeedAutoVideo.this.reportVideoPlayToTTT(videoPlayInfoHolder);
                FeedAutoVideo.this.setGdtAdVideoPlayingStatus(false);
            }
        };
        setFocusable(true);
        setFocusableInTouchMode(true);
        setContentDescription("\u89c6\u9891");
        this.LOG_TAG = TAG;
        initData();
    }

    public void setAdvButtonAnimationListener(com.qzone.proxy.feedcomponent.ui.f fVar) {
    }

    public FeedAutoVideo(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.matrix = new Matrix();
        this.mCurrentPositionMills = 0L;
        this.mCheckTimes = 0;
        this.needUpdateFriendLikeVideoDescTime = false;
        this.friendLikeVideoDescStartTime = 0L;
        this.mIsNeedRapidForwardLayout = false;
        this.mShowTimeRapidForwardBeginTime = -1;
        this.mShowTimeRapidForwardTime = -1;
        this.mShowTimeRapidForwardLimitMinTime = -1;
        this.mHasSeeCurrentTime = 0;
        this.onVideoStartCallback = null;
        this.videoPlayInfoListener = new BaseVideoManager.VideoPlayInfoListener() { // from class: com.qzone.module.feedcomponent.ui.FeedAutoVideo.8
            private void invokeGdtVideoStatusListener() {
                OnVideoPlayStatusListener onVideoPlayStatusListener = FeedAutoVideo.this.mOnVideoPlayStatusListener;
                if (onVideoPlayStatusListener != null) {
                    onVideoPlayStatusListener.onVideoPlayStop(FeedAutoVideo.this);
                    return;
                }
                FeedAutoVideo.this.debugLog(FeedAutoVideo.TAG, "onVideoPlayStop has been recycled " + FeedAutoVideo.this.feedPosition);
            }

            @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideoManager.VideoPlayInfoListener
            public void onVideoPlayComplete(VideoPlayInfoHolder videoPlayInfoHolder) {
                if (FeedAutoVideo.this.mOnVideoPlayStatusListener != null) {
                    synchronized (FeedAutoVideo.mLockObj) {
                        if (FeedAutoVideo.this.mOnVideoPlayStatusListener != null) {
                            FeedAutoVideo.this.mOnVideoPlayStatusListener.onVideoPlayComplete(FeedAutoVideo.this);
                        }
                    }
                }
                FeedAutoVideo.this.hideRaidForwardLayout();
                FeedAutoVideo.this.debugLog(FeedAutoVideo.TAG, "onVideoPlayComplete");
                FeedAutoVideo.this.reportVideoPlayToTTT(videoPlayInfoHolder);
                FeedAutoVideo.this.setGdtAdVideoPlayingStatus(false);
            }

            @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideoManager.VideoPlayInfoListener
            public void onVideoPlayError(VideoPlayInfoHolder videoPlayInfoHolder) {
                FeedAutoVideo.this.debugLog(FeedAutoVideo.TAG, "onVideoPlayError error detail=" + videoPlayInfoHolder.errorDetail + " error type=" + videoPlayInfoHolder.errorType);
                if (FeedAutoVideo.this.mOnVideoPlayStatusListener != null) {
                    synchronized (FeedAutoVideo.mLockObj) {
                        if (FeedAutoVideo.this.mOnVideoPlayStatusListener != null) {
                            FeedAutoVideo.this.mOnVideoPlayStatusListener.onVideoPlayComplete(FeedAutoVideo.this);
                        }
                    }
                }
                FeedAutoVideo.this.hideRaidForwardLayout();
                FeedAutoVideo.this.setGdtAdVideoPlayingStatus(false);
            }

            @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideoManager.VideoPlayInfoListener
            public void onVideoPlayPause(VideoPlayInfoHolder videoPlayInfoHolder) {
                FeedAutoVideo.this.hideRaidForwardLayout();
                FeedAutoVideo.this.reportVideoPlayToTTT(videoPlayInfoHolder);
                FeedAutoVideo.this.setGdtAdVideoPlayingStatus(false);
            }

            @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideoManager.VideoPlayInfoListener
            public void onVideoPlayProgressUpdate(VideoPlayInfoHolder videoPlayInfoHolder) {
                OnVideoPlayStatusListener onVideoPlayStatusListener = FeedAutoVideo.this.mOnVideoPlayStatusListener;
                FeedAutoVideo.this.mHasSeeCurrentTime++;
                FeedAutoVideo feedAutoVideo = FeedAutoVideo.this;
                feedAutoVideo.mCurPositionMills = videoPlayInfoHolder == null ? 0L : videoPlayInfoHolder.currentPositionMills;
                feedAutoVideo.mTotalDurationMills = videoPlayInfoHolder == null ? 1L : videoPlayInfoHolder.totalDurationMills;
                feedAutoVideo.mLastValidPositionMills = videoPlayInfoHolder == null ? 0L : videoPlayInfoHolder.lastValidPositionMills;
                if (onVideoPlayStatusListener != null) {
                    onVideoPlayStatusListener.onVideoPlayProgressUpdate(feedAutoVideo);
                }
                FeedAutoVideo feedAutoVideo2 = FeedAutoVideo.this;
                feedAutoVideo2.showOrHideRapidForwardLayout(videoPlayInfoHolder, feedAutoVideo2.mHasSeeCurrentTime);
                if (FeedAutoVideo.this.needShowMoreRecomm()) {
                    FeedAutoVideo feedAutoVideo3 = FeedAutoVideo.this;
                    if (!feedAutoVideo3.hasRequestData && FeedVideoRecommView.isSupportWidthHeight(feedAutoVideo3.getVideoCoverWidth(), FeedAutoVideo.this.getVideoCoverHeight()) && videoPlayInfoHolder != null) {
                        long j3 = videoPlayInfoHolder.totalDurationSec;
                        if (j3 < 5 || j3 < videoPlayInfoHolder.currentPositionSec + 5) {
                            FeedAutoVideo feedAutoVideo4 = FeedAutoVideo.this;
                            t tVar = new t(feedAutoVideo4.mHandler, feedAutoVideo4.mFeedData, FeedVideoRecommView.getSupportVideoNum(feedAutoVideo4.getVideoCoverWidth(), FeedAutoVideo.this.getVideoCoverHeight()));
                            FeedAutoVideo feedAutoVideo5 = FeedAutoVideo.this;
                            com.tencent.mobileqq.qzoneplayer.video.g gVar = feedAutoVideo5.onFeedVideoElementClickListener;
                            if (gVar != null) {
                                gVar.onClick(((BaseVideo) feedAutoVideo5).mVideoView, FeedVideoElement.FEEDVIDEO_GET_MORE_RECOMMEND_REQ, FeedAutoVideo.this.feedPosition, tVar);
                            }
                            FeedAutoVideo.this.hasRequestData = true;
                        }
                    }
                }
                if (FeedAutoVideo.this.needUpdateFriendLikeVideoDescTime) {
                    if (videoPlayInfoHolder != null) {
                        FeedAutoVideo.this.friendLikeVideoDescStartTime = videoPlayInfoHolder.currentPositionSec;
                    }
                    FeedAutoVideo.this.needUpdateFriendLikeVideoDescTime = false;
                }
                if (videoPlayInfoHolder != null) {
                    FeedAutoVideo feedAutoVideo6 = FeedAutoVideo.this;
                    feedAutoVideo6.checkHideFriendLikeVideoDesc(feedAutoVideo6.friendLikeVideoDescStartTime, videoPlayInfoHolder.currentPositionSec);
                }
                AnimationViewHelper.getAdvButtonAnimation(FeedAutoVideo.this.mFeedData.getFeedCommInfo());
                if (videoPlayInfoHolder != null) {
                    FeedAutoVideo.a(FeedAutoVideo.this);
                }
                FeedAutoVideo.this.setGdtAdVideoPlayingStatus(true);
                if (FeedAutoVideo.this.onVideoStartCallback != null) {
                    FeedAutoVideo feedAutoVideo7 = FeedAutoVideo.this;
                    long j16 = feedAutoVideo7.mLastValidPositionMills;
                    if ((j16 != 0 || feedAutoVideo7.mCurPositionMills <= 0) && feedAutoVideo7.mCurPositionMills >= j16) {
                        return;
                    }
                    feedAutoVideo7.onVideoStartCallback.run();
                }
            }

            @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideoManager.VideoPlayInfoListener
            public void onVideoPlayStart(VideoPlayInfoHolder videoPlayInfoHolder) {
                if (FeedAutoVideo.this.mOnVideoPlayStatusListener != null) {
                    synchronized (FeedAutoVideo.mLockObj) {
                        OnVideoPlayStatusListener onVideoPlayStatusListener = FeedAutoVideo.this.mOnVideoPlayStatusListener;
                        if (onVideoPlayStatusListener != null) {
                            onVideoPlayStatusListener.onVideoPlayStart(FeedAutoVideo.this);
                        }
                    }
                }
                FeedAutoVideo.this.mVideoPlayStartTime = System.currentTimeMillis();
                FeedAutoVideo.this.mHasSeeCurrentTime = 0;
                FeedAutoVideo.this.hideRaidForwardLayout();
                FeedAutoVideo feedAutoVideo = FeedAutoVideo.this;
                feedAutoVideo.mSeq = 0;
                feedAutoVideo.mCurrentPlaySecond = 0L;
                feedAutoVideo.mTotalDurationMills = videoPlayInfoHolder == null ? 1L : videoPlayInfoHolder.totalDurationMills;
                feedAutoVideo.mVideoClick = false;
                feedAutoVideo.needUpdateFriendLikeVideoDescTime = true;
                PlayerUtils.runOnUiThread(new Runnable() { // from class: com.qzone.module.feedcomponent.ui.FeedAutoVideo.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (FeedAutoVideo.this.mFriendLikeVideoDesc != null) {
                            FeedAutoVideo.this.mFriendLikeVideoDesc.setVisibility(0);
                        }
                    }
                });
                FeedAutoVideo.this.setGdtAdVideoVolumeEnabled();
                FeedAutoVideo.this.setGdtAdVideoPlayingStatus(true);
                com.qzone.adapter.feedcomponent.i.H().J1(1);
            }

            @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideoManager.VideoPlayInfoListener
            public void onVideoPlayStop(VideoPlayInfoHolder videoPlayInfoHolder) {
                invokeGdtVideoStatusListener();
                FeedAutoVideo.this.hideRaidForwardLayout();
                FeedAutoVideo.this.mHasSeeCurrentTime = 0;
                FeedAutoVideo.this.reportVideoPlayToTTT(videoPlayInfoHolder);
                FeedAutoVideo.this.setGdtAdVideoPlayingStatus(false);
            }
        };
        setFocusable(true);
        setFocusableInTouchMode(true);
        setContentDescription("\u89c6\u9891");
        this.LOG_TAG = TAG;
        initData();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.qzone.module.feedcomponent.ui.FeedAutoVideo$7, reason: invalid class name */
    /* loaded from: classes39.dex */
    public class AnonymousClass7 implements ImageLoader.ImageLoadListener {
        WeakReference<FeedAutoVideo> feedAutoVideoWeakReference;

        AnonymousClass7() {
            this.feedAutoVideoWeakReference = new WeakReference<>(FeedAutoVideo.this);
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageLoaded(String str, final Drawable drawable, ImageLoader.Options options) {
            PlayerUtils.runOnUiThread(new Runnable() { // from class: com.qzone.module.feedcomponent.ui.FeedAutoVideo.7.1
                @Override // java.lang.Runnable
                public void run() {
                    WeakReference<FeedAutoVideo> weakReference = AnonymousClass7.this.feedAutoVideoWeakReference;
                    if (weakReference == null || weakReference.get() == null) {
                        return;
                    }
                    AnonymousClass7.this.feedAutoVideoWeakReference.get().setBackgroundDrawable(drawable);
                }
            });
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
}
