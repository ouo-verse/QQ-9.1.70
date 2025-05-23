package com.tencent.mobileqq.profilecard.view.head;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.biz.richframework.video.timer.IRFWVideoTimerListener;
import com.tencent.biz.richframework.video.timer.RFWVideoTimerManager;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.DecodeFormat;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.profilecard.ProfileCardDtReportUtil;
import com.tencent.mobileqq.profilecard.constant.QCircleProfileConstant;
import com.tencent.mobileqq.profilecard.utils.CoverBlurUtil;
import com.tencent.mobileqq.profilecard.utils.QCircleCoverBlurCacheUtil;
import com.tencent.mobileqq.profilecard.view.head.CoverBlurView;
import com.tencent.mobileqq.profilecard.view.head.QCircleFeedHeadLayout;
import com.tencent.mobileqq.qcircle.api.QCircleCoverStateChangeListener;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcircle.api.data.QCircleFeedCoverBean;
import com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.view.ISPlayerVideoView;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qzone.video.QzoneVideoBeaconReport;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes35.dex */
public class QCircleFeedHeadLayout extends FrameLayout implements IRFWVideoTimerListener, QCircleCoverStateChangeListener, View.OnClickListener, CoverBlurView.IBlurLoadListener {
    public static final String EV_USER_PROFILE_ABNORMAL_CLK = "ev_user_profile_abnormal_clk";
    public static final String EV_XSJ_VIDEO_END = "dt_video_end";
    public static final String EV_XSJ_VIDEO_START = "dt_video_start";
    private static final int MAX_RETRY_TIME = 5;
    public static final String TAG = "QCircleFeedHeadView";
    private static final int TIME_INTERVAL_MILLS = 200;
    private QBaseActivity mActivity;
    private int mBgClipHeight;
    private OnVideoPlayCallBack mCallBack;
    private int mClipHeight;
    private QCircleFeedCoverBean mCoverBean;
    private QCirclePicStateListener mCoverPicStateListener;
    private Drawable mDefaultPic;
    private volatile boolean mHasLoadCover;
    private int mHasPullDistance;
    private boolean mHasReportVideoEnd;
    private boolean mIsInitByFeedSuccess;
    private PlayerListener mPlayerListener;
    private int mRetryTime;
    private WeakReference<QCircleFeedHeadLayout> mSelfLayoutRef;
    private long mStartPlayTime;
    private CoverBlurView mVideBg;
    private ImageView mVideoCover;
    private ISuperPlayer mVideoPlayer;
    private View mVideoView;
    private static final int MAX_PULL_DOWN_DIS = QCircleProfileConstant.FULL_SCREEN_HEIGHT - QCircleProfileConstant.INIT_HEIGHT;
    private static final int BOTTOM_COMPENSATORY_DIS = ViewUtils.dip2px(20.0f);

    /* compiled from: P */
    /* loaded from: classes35.dex */
    public interface OnVideoPlayCallBack {
        void onVideoLoadStart();

        void onVideoPlayStart();
    }

    public QCircleFeedHeadLayout(QBaseActivity qBaseActivity) {
        super(qBaseActivity);
        this.mPlayerListener = null;
        initInternal(qBaseActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bindBgCover, reason: merged with bridge method [inline-methods] */
    public void lambda$loadCover$1(Bitmap bitmap, Bitmap bitmap2) {
        if (getVideoViewHeight() >= QCircleProfileConstant.FULL_SCREEN_HEIGHT) {
            this.mHasLoadCover = true;
            View view = this.mVideoView;
            if (view != null) {
                view.setVisibility(0);
            }
        } else if (bitmap2 != null) {
            this.mVideBg.loadCover(bitmap2, -this.mClipHeight, getVideoViewHeight() - this.mClipHeight, this.mBgClipHeight, true);
        } else {
            loadBlur(bitmap);
        }
        ImageView imageView = this.mVideoCover;
        if (imageView != null) {
            removeView(imageView);
            addView(this.mVideoCover);
            this.mVideoCover.setImageDrawable(new BitmapDrawable(this.mActivity.getResources(), bitmap));
        }
        removeView(this.mVideBg);
        addView(this.mVideBg);
    }

    private void calculateBgMarginTop() {
        int videoViewHeight = getVideoViewHeight();
        int i3 = QCircleProfileConstant.FULL_SCREEN_HEIGHT;
        if (videoViewHeight > i3) {
            this.mBgClipHeight = 0;
        } else {
            this.mBgClipHeight = (i3 - this.mClipHeight) - getVideoViewHeight();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void calculateMarginTop(float f16) {
        int i3;
        QCircleFeedCoverBean qCircleFeedCoverBean = this.mCoverBean;
        if (qCircleFeedCoverBean != null && !TextUtils.isEmpty(qCircleFeedCoverBean.qcircleVideoUrl) && this.mCoverBean.qcircleVideoHeight > 0) {
            int videoViewHeight = getVideoViewHeight();
            if (f16 > 0.0f) {
                i3 = (int) (f16 * videoViewHeight);
            } else {
                int i16 = QCircleProfileConstant.INIT_HEIGHT;
                if (videoViewHeight < i16) {
                    i3 = -((i16 - videoViewHeight) / 2);
                }
            }
            if (i3 == getVideoViewHeight() - QCircleProfileConstant.INIT_HEIGHT) {
                i3 -= BOTTOM_COMPENSATORY_DIS;
            }
            this.mClipHeight = i3;
        }
        i3 = 0;
        if (i3 == getVideoViewHeight() - QCircleProfileConstant.INIT_HEIGHT) {
        }
        this.mClipHeight = i3;
    }

    private int getVideoViewHeight() {
        QCircleFeedCoverBean qCircleFeedCoverBean = this.mCoverBean;
        if (qCircleFeedCoverBean != null && qCircleFeedCoverBean.qcircleVideoWidth != 0 && qCircleFeedCoverBean.qcircleVideoHeight != 0) {
            float screenWidth = ViewUtils.getScreenWidth();
            QCircleFeedCoverBean qCircleFeedCoverBean2 = this.mCoverBean;
            int i3 = (int) ((screenWidth / qCircleFeedCoverBean2.qcircleVideoWidth) * qCircleFeedCoverBean2.qcircleVideoHeight);
            QLog.e(TAG, 1, "[getVideoViewHeight]:" + i3 + ",vh:" + this.mCoverBean.qcircleVideoHeight);
            return i3;
        }
        QLog.e(TAG, 1, "[getVideoViewHeight] empty feed buff or invalid video size, return init height");
        return QCircleProfileConstant.FULL_SCREEN_HEIGHT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleFailed() {
        QLog.i(TAG, 1, "[handleFailed]: mIsInitByFeedSuccess:" + this.mIsInitByFeedSuccess);
        this.mVideBg.setFailed();
        this.mVideBg.setBackground(this.mDefaultPic);
        View view = this.mVideoView;
        if (view != null) {
            view.setVisibility(8);
        }
        ImageView imageView = this.mVideoCover;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mVideBg.getLayoutParams();
        layoutParams.height = QCircleProfileConstant.FULL_SCREEN_HEIGHT;
        layoutParams.topMargin = 0;
        this.mVideBg.setLayoutParams(layoutParams);
        this.mHasLoadCover = false;
        removeView(this.mVideBg);
        addView(this.mVideBg);
    }

    private void initCoverView(Context context) {
        if (this.mIsInitByFeedSuccess) {
            this.mVideoCover = new ImageView(context);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, getVideoViewHeight());
            layoutParams.setMargins(0, -this.mClipHeight, 0, 0);
            this.mVideoCover.setLayoutParams(layoutParams);
            this.mVideoCover.setImageDrawable(null);
            this.mVideoCover.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
    }

    private void initFeedData(QCircleFeedCoverBean qCircleFeedCoverBean) {
        if (TextUtils.isEmpty(qCircleFeedCoverBean.qcircleFeedId)) {
            QLog.e(TAG, 1, "[init] empty feed buff");
            return;
        }
        this.mCoverBean = qCircleFeedCoverBean;
        this.mIsInitByFeedSuccess = true;
        HashMap hashMap = new HashMap();
        hashMap.put(ProfileCardDtReportUtil.DT_REPORT_PARAM_COVER_TYPE, "5");
        hashMap.put("feed_id", qCircleFeedCoverBean.qcircleFeedId);
        ProfileCardDtReportUtil.initElementWithExposureClickAndParams(this, ProfileCardDtReportUtil.DT_REPORT_COVER, hashMap);
    }

    private void initInternal(QBaseActivity qBaseActivity) {
        this.mActivity = qBaseActivity;
        this.mSelfLayoutRef = new WeakReference<>(this);
        setOnClickListener(this);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setBackgroundColor(-16777216);
    }

    private void initVideoBg(Context context) {
        this.mVideBg = new CoverBlurView(context, null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ViewUtils.getScreenWidth(), QCircleProfileConstant.FULL_SCREEN_HEIGHT + this.mBgClipHeight);
        layoutParams.setMargins(0, -this.mBgClipHeight, 0, 0);
        this.mVideBg.setLayoutParams(layoutParams);
        this.mVideBg.setLoadBlurListener(this);
    }

    private void initVideoView() {
        if (this.mIsInitByFeedSuccess) {
            if (!QQVideoPlaySDKManager.isSoLoadSucess()) {
                QQVideoPlaySDKManager.initSDKAsync(getContext(), new SDKInitListener() { // from class: com.tencent.mobileqq.profilecard.view.head.ai
                    @Override // com.tencent.mobileqq.videoplatform.SDKInitListener
                    public final void onSDKInited(boolean z16) {
                        QCircleFeedHeadLayout.this.lambda$initVideoView$0(z16);
                    }
                });
            } else {
                initVideoViewInner();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initVideoViewInner() {
        initVideoPlayer(getContext());
        addView(this.mVideoView);
        this.mVideoView.setVisibility(8);
    }

    private void jumpToQCircleLayer() {
        if (!this.mIsInitByFeedSuccess || this.mCoverBean == null) {
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("key_jump_from", QzoneVideoBeaconReport.RESULTCODE_VIDEO_TRIIMRECORD_DOWNLOADERROR);
        hashMap.put("feedid", this.mCoverBean.qcircleFeedId);
        hashMap.put("uin", this.mCoverBean.qcircleFeedPosterUin);
        hashMap.put("sourcetype", QzoneVideoBeaconReport.RESULTCODE_VIDEO_TRIIMRECORD_DOWNLOADERROR);
        hashMap.put(QCircleSchemeAttr.Detail.IS_MIDDLE_PAGE, "1");
        hashMap.put("xsj_main_entrance", QCircleDaTongConstant.ElementParamValue.QQ_PROFILE);
        hashMap.put("xsj_sub_entrance", "card_background");
        hashMap.put("xsj_custom_pgid", WinkDaTongReportConstant.PageId.PG_QQ_PROFILE_TASKID);
        com.tencent.mobileqq.activity.qcircle.utils.c.g().enterBySchemeAction(this.mActivity, QCircleScheme.Q_CIRCLE_ACTION_OPEN_CIRCLE_CONTENT_DETAIL, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initVideoView$0(boolean z16) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.profilecard.view.head.an
            @Override // java.lang.Runnable
            public final void run() {
                QCircleFeedHeadLayout.this.initVideoViewInner();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadCover$2() {
        QBaseActivity qBaseActivity = this.mActivity;
        QCircleFeedCoverBean qCircleFeedCoverBean = this.mCoverBean;
        final Bitmap cache = QCircleCoverBlurCacheUtil.getCache(qBaseActivity, qCircleFeedCoverBean.qcircleFeedPosterUin, qCircleFeedCoverBean.qcircleFeedId, 1, ViewUtils.getScreenWidth(), getVideoViewHeight());
        QBaseActivity qBaseActivity2 = this.mActivity;
        QCircleFeedCoverBean qCircleFeedCoverBean2 = this.mCoverBean;
        final Bitmap cache2 = QCircleCoverBlurCacheUtil.getCache(qBaseActivity2, qCircleFeedCoverBean2.qcircleFeedPosterUin, qCircleFeedCoverBean2.qcircleFeedId, 0, ViewUtils.getScreenWidth(), QCircleProfileConstant.FULL_SCREEN_HEIGHT);
        if (cache != null) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.profilecard.view.head.al
                @Override // java.lang.Runnable
                public final void run() {
                    QCircleFeedHeadLayout.this.lambda$loadCover$1(cache, cache2);
                }
            });
        } else {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.profilecard.view.head.am
                @Override // java.lang.Runnable
                public final void run() {
                    QCircleFeedHeadLayout.this.loadCoverWithPicLoader();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadCoverWithPicLoader$4(String str) {
        final Bitmap decodeBitmap = QCircleCoverBlurCacheUtil.decodeBitmap(str, ViewUtils.getScreenWidth(), getVideoViewHeight());
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.profilecard.view.head.ak
            @Override // java.lang.Runnable
            public final void run() {
                QCircleFeedHeadLayout.this.lambda$loadCoverWithPicLoader$3(decodeBitmap);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$resetVideoViewPos$5(FrameLayout.LayoutParams layoutParams, ValueAnimator valueAnimator) {
        if (this.mVideoView != null) {
            layoutParams.topMargin = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            this.mVideoView.setLayoutParams(layoutParams);
            this.mVideBg.onVideoPosChange(this.mVideoView.getTop() - layoutParams.topMargin, this.mVideoView.getBottom() - layoutParams.topMargin);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$resetVideoViewPos$6(FrameLayout.LayoutParams layoutParams, ValueAnimator valueAnimator) {
        layoutParams.topMargin = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        this.mVideBg.setLayoutParams(layoutParams);
    }

    private void loadBlur(Bitmap bitmap) {
        Bitmap reSizeBitmap = CoverBlurUtil.INSTANCE.reSizeBitmap(bitmap, ViewUtils.getScreenWidth(), this.mVideBg.getLayoutParams().height);
        if (reSizeBitmap != null) {
            this.mVideBg.loadCover(reSizeBitmap, -this.mClipHeight, getVideoViewHeight() - this.mClipHeight, this.mBgClipHeight, false);
        }
    }

    private void loadCover() {
        if (this.mIsInitByFeedSuccess) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.profilecard.view.head.aj
                @Override // java.lang.Runnable
                public final void run() {
                    QCircleFeedHeadLayout.this.lambda$loadCover$2();
                }
            }, 64, null, true);
        } else {
            handleFailed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadCoverWithPicLoader() {
        final QCircleCoverBlurCacheUtil.ISaveCacheCallBack iSaveCacheCallBack = new QCircleCoverBlurCacheUtil.ISaveCacheCallBack() { // from class: com.tencent.mobileqq.profilecard.view.head.ap
            @Override // com.tencent.mobileqq.profilecard.utils.QCircleCoverBlurCacheUtil.ISaveCacheCallBack
            public final void onSave(String str) {
                QCircleFeedHeadLayout.this.lambda$loadCoverWithPicLoader$4(str);
            }
        };
        this.mCoverPicStateListener = new QCirclePicStateListener() { // from class: com.tencent.mobileqq.profilecard.view.head.QCircleFeedHeadLayout.1
            @Override // com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener, com.tencent.libra.listener.IPicLoadStateListener
            public void onStateChange(LoadState loadState, Option option) {
                super.onStateChange(loadState, option);
                QLog.d(QCircleFeedHeadLayout.TAG, 1, "[loadCoverWithPicLoader] get bitmap state:" + loadState);
                if (loadState == LoadState.STATE_SUCCESS) {
                    QCircleCoverBlurCacheUtil.saveCache(QCircleFeedHeadLayout.this.mActivity, option.getResultBitMap(), QCircleFeedHeadLayout.this.mCoverBean.qcircleFeedPosterUin, QCircleFeedHeadLayout.this.mCoverBean.qcircleFeedId, 1, iSaveCacheCallBack);
                } else if (loadState == LoadState.STATE_DOWNLOAD_FAILED || loadState == LoadState.STATE_DECODE_FAILED) {
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.profilecard.view.head.QCircleFeedHeadLayout.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            QCircleFeedHeadLayout.this.handleFailed();
                        }
                    });
                }
            }
        };
        Option targetView = Option.obtain().setUrl(this.mCoverBean.qcircleVideoCoverUrl).setRequestWidth(ViewUtils.getScreenWidth()).setRequestHeight(getVideoViewHeight()).setPicType(4).setTargetView(this.mVideoCover);
        if (Build.VERSION.SDK_INT <= 25) {
            targetView.setPreferDecodeFormat(DecodeFormat.PREFER_RGB_565);
        }
        QCircleFeedPicLoader.g().loadImage(targetView, this.mCoverPicStateListener);
    }

    private void releasePlayerResource() {
        ISuperPlayer iSuperPlayer = this.mVideoPlayer;
        if (iSuperPlayer == null) {
            return;
        }
        iSuperPlayer.stop();
        this.mVideoPlayer.release();
        if (this.mVideoPlayer.getVideoView() != null && this.mPlayerListener != null) {
            this.mVideoPlayer.getVideoView().removeViewCallBack(this.mPlayerListener);
        }
        removeView(this.mVideoView);
        this.mVideoView = null;
        this.mVideoPlayer = null;
        videoPlayEndDtReport();
    }

    private void releaseTimer() {
        RFWVideoTimerManager.g().unRegisterTimerListener(this);
    }

    private void removeOldView() {
        CoverBlurView coverBlurView = this.mVideBg;
        if (coverBlurView != null) {
            removeView(coverBlurView);
        }
        ImageView imageView = this.mVideoCover;
        if (imageView != null) {
            removeView(imageView);
        }
        View view = this.mVideoView;
        if (view != null) {
            removeView(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startVideoPlay() {
        QBaseActivity qBaseActivity = this.mActivity;
        if (qBaseActivity == null || qBaseActivity.isFinishing() || this.mActivity.isDestroyed()) {
            return;
        }
        if (this.mVideoPlayer == null) {
            initVideoPlayer(getContext());
            removeView(this.mVideoView);
            addView(this.mVideoView, Math.max(0, getChildCount() - 2));
            this.mVideoView.setVisibility(0);
        }
        ISuperPlayer iSuperPlayer = this.mVideoPlayer;
        if (iSuperPlayer != null) {
            iSuperPlayer.start();
        }
    }

    private void videoPlayEndDtReport() {
        if (this.mHasReportVideoEnd) {
            return;
        }
        this.mHasReportVideoEnd = true;
        long currentTimeMillis = System.currentTimeMillis() - this.mStartPlayTime;
        HashMap hashMap = new HashMap();
        hashMap.put("dt_play_duration", String.valueOf(currentTimeMillis));
        VideoReport.reportEvent("dt_video_end", this, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void videoPlayStartDtReport() {
        this.mStartPlayTime = System.currentTimeMillis();
        VideoReport.reportEvent("dt_video_start", this, null);
    }

    public boolean hasLoadCover() {
        return this.mHasLoadCover;
    }

    public boolean isInitByFeedSuccess() {
        return this.mIsInitByFeedSuccess;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mIsInitByFeedSuccess) {
            playTimer();
            startVideoPlay();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mIsInitByFeedSuccess && this.mHasLoadCover) {
            jumpToQCircleLayer();
            VideoReport.reportEvent(EV_USER_PROFILE_ABNORMAL_CLK, this, null);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mIsInitByFeedSuccess) {
            releaseTimer();
            releasePlayerResource();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // com.tencent.mobileqq.qcircle.api.QCircleCoverStateChangeListener
    public void onMaxPull() {
        if (this.mIsInitByFeedSuccess && this.mHasLoadCover) {
            jumpToQCircleLayer();
            VideoReport.reportEvent(EV_USER_PROFILE_ABNORMAL_CLK, this, null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006c  */
    @Override // com.tencent.mobileqq.qcircle.api.QCircleCoverStateChangeListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMoveVideo(float f16) {
        int i3;
        float f17;
        int i16;
        int i17;
        int i18;
        FrameLayout.LayoutParams layoutParams;
        int i19;
        int i26;
        if (!this.mHasLoadCover) {
            QLog.d(TAG, 1, "[onMoveVideo] cover do not load yet");
            return;
        }
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.mVideoView.getLayoutParams();
        int i27 = this.mClipHeight;
        if (i27 == 0) {
            QLog.d(TAG, 1, "[onMoveVideo] no space to move");
            return;
        }
        if (f16 >= 0.0f) {
            if (i27 > 0) {
                int i28 = layoutParams2.topMargin;
                if (i28 + f16 > 0.0f) {
                    i3 = -i28;
                    f16 = i3;
                }
            }
            int i29 = this.mHasPullDistance;
            f17 = i29 + f16;
            i16 = MAX_PULL_DOWN_DIS;
            if (f17 > i16) {
                f16 = i16 - i29;
            }
            this.mHasPullDistance = (int) (i29 + f16);
            i17 = layoutParams2.topMargin;
            int i36 = (int) f16;
            i18 = i17 + i36;
            if (i18 != i17) {
                layoutParams2.setMargins(0, i18, 0, 0);
                this.mVideoView.setLayoutParams(layoutParams2);
                this.mVideoCover.setLayoutParams(layoutParams2);
                this.mVideBg.onVideoPosChange(this.mVideoView.getTop() + i18, this.mVideoView.getBottom() + i18);
            }
            if (this.mHasLoadCover || (i26 = i36 + (i19 = (layoutParams = (FrameLayout.LayoutParams) this.mVideBg.getLayoutParams()).topMargin)) == i19 || i26 < (-this.mBgClipHeight)) {
                return;
            }
            layoutParams.setMargins(0, i26, 0, 0);
            this.mVideBg.setLayoutParams(layoutParams);
            return;
        }
        if (i27 > 0) {
            int i37 = layoutParams2.topMargin;
            if (i37 + f16 < (-i27)) {
                f16 = -(i37 + i27);
            }
        }
        if (i27 < 0) {
            int i38 = layoutParams2.topMargin;
            if (i38 + f16 < (-i27)) {
                i3 = -(i27 + i38);
                f16 = i3;
            }
        }
        int i292 = this.mHasPullDistance;
        f17 = i292 + f16;
        i16 = MAX_PULL_DOWN_DIS;
        if (f17 > i16) {
        }
        this.mHasPullDistance = (int) (i292 + f16);
        i17 = layoutParams2.topMargin;
        int i362 = (int) f16;
        i18 = i17 + i362;
        if (i18 != i17) {
        }
        if (this.mHasLoadCover) {
        }
    }

    public void playTimer() {
        releaseTimer();
        RFWVideoTimerManager.g().registerTimerListener(this);
    }

    public void resetVideoViewPos() {
        if (!this.mHasLoadCover) {
            QLog.d(TAG, 1, "[onMoveVideo] cover do not load yet");
            return;
        }
        if (this.mVideoView == null || this.mVideBg == null) {
            return;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        final FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mVideoView.getLayoutParams();
        ValueAnimator ofInt = ValueAnimator.ofInt(layoutParams.topMargin, -this.mClipHeight);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.profilecard.view.head.aq
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                QCircleFeedHeadLayout.this.lambda$resetVideoViewPos$5(layoutParams, valueAnimator);
            }
        });
        final FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.mVideBg.getLayoutParams();
        ValueAnimator ofInt2 = ValueAnimator.ofInt(layoutParams2.topMargin, -this.mBgClipHeight);
        ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.profilecard.view.head.ar
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                QCircleFeedHeadLayout.this.lambda$resetVideoViewPos$6(layoutParams2, valueAnimator);
            }
        });
        animatorSet.play(ofInt).with(ofInt2);
        animatorSet.setDuration(200L);
        animatorSet.start();
        this.mHasPullDistance = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadCoverWithPicLoader$3(Bitmap bitmap) {
        lambda$loadCover$1(bitmap, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onLoadBlurFinish$7() {
        this.mHasLoadCover = true;
        View view = this.mVideoView;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initVideoPlayer(Context context) {
        if (context != null) {
            this.mPlayerListener = new PlayerListener(this.mSelfLayoutRef);
            ISPlayerVideoView createPlayerVideoView = SuperPlayerFactory.createPlayerVideoView(context);
            createPlayerVideoView.addViewCallBack(this.mPlayerListener);
            this.mVideoView = (View) createPlayerVideoView;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, getVideoViewHeight());
            layoutParams.setMargins(0, -this.mClipHeight, 0, 0);
            this.mVideoView.setLayoutParams(layoutParams);
            this.mVideoView.setBackgroundColor(-16777216);
            SuperPlayerVideoInfo createVideoInfoForUrl = SuperPlayerFactory.createVideoInfoForUrl(this.mCoverBean.qcircleVideoUrl, 1, (String) null);
            ISuperPlayer createMediaPlayer = SuperPlayerFactory.createMediaPlayer(context, 104, (ISPlayerVideoView) this.mVideoView);
            this.mVideoPlayer = createMediaPlayer;
            createMediaPlayer.setXYaxis(2);
            this.mVideoPlayer.setOnVideoPreparedListener(this.mPlayerListener);
            this.mVideoPlayer.setOnErrorListener(this.mPlayerListener);
            this.mVideoPlayer.setOnInfoListener(this.mPlayerListener);
            this.mVideoPlayer.setOnCompletionListener(this.mPlayerListener);
            this.mVideoPlayer.setLoopback(false);
            this.mVideoPlayer.openMediaPlayer(context, createVideoInfoForUrl, 0L);
            this.mVideoPlayer.setOutputMute(true);
        }
    }

    public QCircleFeedHeadLayout(QBaseActivity qBaseActivity, AttributeSet attributeSet) {
        super(qBaseActivity, attributeSet);
        this.mPlayerListener = null;
        initInternal(qBaseActivity);
    }

    public void init(QCircleFeedCoverBean qCircleFeedCoverBean) {
        if (qCircleFeedCoverBean == null) {
            QLog.e(TAG, 1, "[init] coverbean is null");
            return;
        }
        if (this.mIsInitByFeedSuccess && this.mCoverBean.qcircleFeedId.equals(qCircleFeedCoverBean.qcircleFeedId) && this.mCoverBean.qcircleCoverY == qCircleFeedCoverBean.qcircleCoverY) {
            return;
        }
        if (this.mDefaultPic == null) {
            this.mDefaultPic = this.mActivity.getResources().getDrawable(R.drawable.f2v);
        }
        if (this.mCallBack == null) {
            this.mCallBack = new VideoCallBack();
        }
        initFeedData(qCircleFeedCoverBean);
        calculateMarginTop(qCircleFeedCoverBean.qcircleCoverY);
        calculateBgMarginTop();
        removeOldView();
        initVideoBg(this.mActivity);
        initCoverView(this.mActivity);
        initVideoView();
        loadCover();
    }

    @Override // com.tencent.mobileqq.profilecard.view.head.CoverBlurView.IBlurLoadListener
    public void onLoadBlurFinish(Bitmap bitmap, boolean z16) {
        if (bitmap != null && !z16) {
            QBaseActivity qBaseActivity = this.mActivity;
            QCircleFeedCoverBean qCircleFeedCoverBean = this.mCoverBean;
            QCircleCoverBlurCacheUtil.saveCache(qBaseActivity, bitmap, qCircleFeedCoverBean.qcircleFeedPosterUin, qCircleFeedCoverBean.qcircleFeedId, 0, null);
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.profilecard.view.head.ao
            @Override // java.lang.Runnable
            public final void run() {
                QCircleFeedHeadLayout.this.lambda$onLoadBlurFinish$7();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public static class PlayerListener implements ISuperPlayer.OnVideoPreparedListener, ISuperPlayer.OnCompletionListener, ISuperPlayer.OnErrorListener, ISPlayerVideoView.IVideoViewCallBack, ISuperPlayer.OnInfoListener {
        private final QCircleFeedHeadLayout cachedLayout;

        PlayerListener(WeakReference<QCircleFeedHeadLayout> weakReference) {
            this.cachedLayout = weakReference.get();
        }

        @Override // com.tencent.superplayer.api.ISuperPlayer.OnCompletionListener
        public void onCompletion(ISuperPlayer iSuperPlayer) {
            QCircleFeedHeadLayout qCircleFeedHeadLayout = this.cachedLayout;
            if (qCircleFeedHeadLayout == null || qCircleFeedHeadLayout.mVideoPlayer == null) {
                return;
            }
            this.cachedLayout.mVideoPlayer.seekTo(0);
            this.cachedLayout.startVideoPlay();
        }

        @Override // com.tencent.superplayer.api.ISuperPlayer.OnErrorListener
        public boolean onError(ISuperPlayer iSuperPlayer, int i3, int i16, int i17, String str) {
            return false;
        }

        @Override // com.tencent.superplayer.api.ISuperPlayer.OnInfoListener
        public boolean onInfo(ISuperPlayer iSuperPlayer, int i3, long j3, long j16, Object obj) {
            QCircleFeedHeadLayout qCircleFeedHeadLayout = this.cachedLayout;
            if (qCircleFeedHeadLayout == null || qCircleFeedHeadLayout.mCallBack == null) {
                return false;
            }
            if (i3 == 105) {
                this.cachedLayout.mCallBack.onVideoPlayStart();
            }
            if (!QLog.isColorLevel()) {
                return false;
            }
            QLog.i(QCircleFeedHeadLayout.TAG, 2, "[VideoPreparedListener]: info:" + i3);
            return false;
        }

        @Override // com.tencent.superplayer.api.ISuperPlayer.OnVideoPreparedListener
        public void onVideoPrepared(ISuperPlayer iSuperPlayer) {
            QCircleFeedHeadLayout qCircleFeedHeadLayout = this.cachedLayout;
            if (qCircleFeedHeadLayout != null) {
                qCircleFeedHeadLayout.startVideoPlay();
            }
        }

        @Override // com.tencent.superplayer.view.ISPlayerVideoView.IVideoViewCallBack
        public void onSurfaceChanged(Object obj) {
        }

        @Override // com.tencent.superplayer.view.ISPlayerVideoView.IVideoViewCallBack
        public void onSurfaceCreated(Object obj) {
        }

        @Override // com.tencent.superplayer.view.ISPlayerVideoView.IVideoViewCallBack
        public void onSurfaceDestroy(Object obj) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class VideoCallBack implements OnVideoPlayCallBack {
        VideoCallBack() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onVideoPlayStart$0() {
            if (QCircleFeedHeadLayout.this.mVideoCover != null) {
                QCircleFeedHeadLayout.this.mVideoCover.setVisibility(8);
            }
        }

        @Override // com.tencent.mobileqq.profilecard.view.head.QCircleFeedHeadLayout.OnVideoPlayCallBack
        public void onVideoPlayStart() {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.profilecard.view.head.as
                @Override // java.lang.Runnable
                public final void run() {
                    QCircleFeedHeadLayout.VideoCallBack.this.lambda$onVideoPlayStart$0();
                }
            });
            QCircleFeedHeadLayout.this.videoPlayStartDtReport();
        }

        @Override // com.tencent.mobileqq.profilecard.view.head.QCircleFeedHeadLayout.OnVideoPlayCallBack
        public void onVideoLoadStart() {
        }
    }

    @Override // com.tencent.biz.richframework.video.timer.IRFWVideoTimerListener
    public void onTimerCallback() {
    }
}
