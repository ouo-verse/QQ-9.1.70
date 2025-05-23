package com.tencent.mobileqq.qzoneplayer.video;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.hippy.qq.view.boodo.CommonVideoViewController;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qzoneplayer.cover.data.VideoPlayerEventCenter;
import com.tencent.mobileqq.qzoneplayer.cover.presenter.BaseVideoPresenter;
import com.tencent.mobileqq.qzoneplayer.cover.wrapper.ICoverWrapper;
import com.tencent.mobileqq.qzoneplayer.panorama.GLTextureView;
import com.tencent.mobileqq.qzoneplayer.video.BaseVideoCover;
import com.tencent.mobileqq.qzoneplayer.video.BaseVideoManager;
import com.tencent.mobileqq.qzoneplayer.video.DescTextView;
import com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import com.tencent.oskplayer.PlayerConfig;
import com.tencent.oskplayer.model.SegmentVideoInfo;
import com.tencent.oskplayer.proxy.HttpRetryLogic;
import com.tencent.oskplayer.proxy.VideoManager;
import com.tencent.oskplayer.util.PlayerUtils;
import com.tencent.oskplayer.videorenderer.OnSurfaceSizeChangedListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.soter.core.biometric.FaceManager;
import cooperation.qzone.report.lp.LpReportInfoConfig;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: P */
/* loaded from: classes35.dex */
public class BaseVideo extends FrameLayout implements Recycleable {
    private static final int DEFUALT_DELAY_HIDE_COVER_TIME = 200;
    public static final int EVENT_FLOAT_SHOW_REDPOCKET = 51;
    public static final int EVENT_JUMP_TO_ADVICE_VIDEO = 52;
    public static final int MSG_DELAY_HIDE_COVER = 17;
    public static final int MSG_DELAY_SHOW_SOUND_TIP_VIEW = 6;
    public static final int MSG_HIDE_LIGHT_TIP_TEXT = 32;
    public static final int MSG_HIDE_SOUNDTIPVIEW = 5;
    public static final int MSG_HIDE_VALID_TIME_TEXT = 21;
    public static final int MSG_LAYOUT_SURFACEVIEW = 22;
    public static final int MSG_PLAY_COMPLETE = 7;
    public static final int MSG_SHOW_NEXT_VIDEO_TIP = 23;
    public static final int MSG_START_INDICATE_PAUSE = 8;
    public static final int MSG_START_LOADING_LIGHT = 3;
    public static final int MSG_START_PLAYING = 1;
    public static final int MSG_START_PLAYING_NODELAY = 20;
    public static final int MSG_STATE_FLOAT_BOTTOM_HIDE = 25;
    public static final int MSG_STATE_FLOAT_COMPLETE = 24;
    public static final int MSG_STOP_PLAY = 2;
    public static final int MSG_STOP_TIMEVIEW = 4;
    public static final int MSG_SURFACETEXTURE_DESTROYED = 19;
    public static final int MSG_SURFACETEXTURE_SAFEURL = 16;
    public static final int MSG_VIDEO_ILLEAGL = 18;
    public static final int MSG_VIDEO_SIZE_CHANGE = 33;
    public static final int STATE_ERROR = 6;
    public static final int STATE_FLOAT_COMPLETE = 8;
    public static final int STATE_PAUSE = 5;
    public static final int STATE_PLAYING = 3;
    public static final int STATE_PLAY_COMPLETE = 4;
    public static final int STATE_RECYLED = 0;
    public static final int STATE_RETRY = 7;
    public static final int STATE_STOP = 1;
    public static final int STATE_WAIT = 2;
    public static final String VIDEO_PALY_SCENE_CONTEXT_FEED_DETAIL_STR = "com.tencent.mobileqq.pluginsdk.";
    public static final String VIDEO_PALY_SCENE_CONTEXT_FEED_DETAIL_STR_QZONE = "QZoneShuoShuoDetailActivity";
    public static final String VIDEO_PALY_SCENE_CONTEXT_FEED_DETAIL_STR_QZONE_2 = "QZoneShareDetailActivity";
    public static final String VIDEO_PALY_SCENE_CONTEXT_FEED_STR = "app.ResourcePreloader";
    public static final String VIDEO_PALY_SCENE_CONTEXT_FEED_STR_QZONE = "app.QZoneRealApplication";
    public static final String VIDEO_PALY_SCENE_CONTEXT_RECOMMEND_STR = "QzoneVideoRecommendActivity";
    public static final int VIDEO_PALY_SCENE_FEED = 1;
    public static final int VIDEO_PALY_SCENE_FEED_DETAIL = 2;
    public static final int VIDEO_PALY_SCENE_RECOMMEND = 3;
    protected String LOG_TAG;
    protected Animation alphaAnimation;
    protected int alphaAnimationDuration;
    protected WeakReference<BaseVideoManager> baseVideoManager;
    protected RelativeLayout bottomShadow;
    public int errCode;
    protected boolean eventIsHandled;
    public int feedPosition;
    public volatile boolean hasLayout;
    protected boolean hasPlayCountView;
    public boolean hasShowLightTip;
    protected boolean hasSoundLinesLayout;
    protected boolean hasSoundTipLayout;
    protected boolean hasTimeview;
    public boolean isAutoPlay;
    public boolean isFirstPlay;
    protected VideoSize lastVideoSize;
    protected LinearLayout lightTipLayout;
    private DescTextView lightTipText;
    public int mCurPlayScene;
    public DescTextView mErrorView;
    public Handler mHandler;
    protected volatile boolean mHasAddVideoView;
    private HttpRetryLogic mHttpRetryLogic;
    private TreeMap<p, String> mHudTextMap;
    protected DescTextView mHudView;
    private boolean mHudViewIsHideManually;
    private com.tencent.mobileqq.qzoneplayer.video.o mIllegalCallback;
    public int mIndex;
    private boolean mIsMoved;
    protected boolean mIsNeedHideCover;
    private boolean mIsPressed;
    protected volatile boolean mIsSafeUrl;
    private boolean mIsSupport360;
    protected boolean mIsVip;
    protected FrameLayout mLiveEndAnimContainer;
    protected ImageView mLiveEndIV;
    protected ImageView mLiveStatIcon;
    protected int mLiveStatIconWidth;
    private Runnable mLongPressRunnable;
    private WeakReference<OnSurfaceSizeChangedListener> mOnSurfaceSizeChangedListener;
    protected DescTextView mPlayCountView;
    protected VideoPlayerEventCenter.ConcreteSubject mPlayStateSubject;
    private float mPreviousPosX;
    private float mPreviousPoxY;
    protected volatile int mRealVideoHeight;
    protected volatile int mRealVideoWidth;
    protected String mRecordVideoId;
    protected boolean mShowCoverWarnType;
    protected SoundLines mSoundLinesLayout;
    private boolean mSoundLinesPlayed;
    public ImageView mSoundTipImageView;
    private volatile int mState;
    protected Pair<Integer, Integer> mSurfaceSize;
    protected DescTextView mTimeview;
    private boolean mTouchMoved;
    protected View.OnClickListener mVideoClickListener;
    public BaseVideoCover mVideoCover;
    protected BaseVideoPresenter mVideoCoverPresenter;
    public ICoverWrapper mVideoCoverWrapper;
    private View.OnLongClickListener mVideoLongClickListener;
    protected VideoPlayInfo mVideoPlayInfo;
    protected BaseVideoManager.VideoPlayInfoListener mVideoPlayInfoListener;
    private BaseVideoManager.VideoPlayInfoListener mVideoPlayInfoListenerWrapper;
    protected VideoSize mVideoSize;
    protected View mVideoView;
    public com.tencent.mobileqq.qzoneplayer.video.g onFeedVideoElementClickListener;
    protected com.tencent.mobileqq.qzoneplayer.video.h onFeedVideoElementLongClickListener;
    private SurfaceTexture outSurfaceTexture;
    protected RelativeLayout remarkLayout;
    protected DescTextView remarkText;
    private boolean showCoverImage;
    public volatile boolean surfaceCreated;
    public int validTime;
    protected LinearLayout validTimeLayout;
    private DescTextView validTimeText;

    /* compiled from: P */
    /* loaded from: classes35.dex */
    public static class VideoSize {
        public int videoNatureHeight;
        public int videoNatureWidth;

        public VideoSize(int i3, int i16) {
            this.videoNatureHeight = i16;
            this.videoNatureWidth = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BaseVideo baseVideo;
            com.tencent.mobileqq.qzoneplayer.video.g gVar;
            EventCollector.getInstance().onViewClickedBefore(view);
            if (BaseVideo.this.hasVideoOrigUrl() && (gVar = (baseVideo = BaseVideo.this).onFeedVideoElementClickListener) != null) {
                RelativeLayout remarkLayout = baseVideo.getRemarkLayout();
                FeedVideoElement feedVideoElement = FeedVideoElement.VIDEO_REMARK;
                BaseVideo baseVideo2 = BaseVideo.this;
                gVar.onClick(remarkLayout, feedVideoElement, baseVideo2.feedPosition, baseVideo2);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.tencent.mobileqq.qzoneplayer.video.g gVar;
            EventCollector.getInstance().onViewClickedBefore(view);
            BaseVideo baseVideo = BaseVideo.this;
            if (baseVideo.mVideoPlayInfo != null && (gVar = baseVideo.onFeedVideoElementClickListener) != null) {
                RelativeLayout remarkLayout = baseVideo.getRemarkLayout();
                FeedVideoElement feedVideoElement = FeedVideoElement.VIDEO_REMARK;
                BaseVideo baseVideo2 = BaseVideo.this;
                gVar.onClick(remarkLayout, feedVideoElement, baseVideo2.feedPosition, baseVideo2);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class c extends GLTextureView {
        c(Context context) {
            super(context);
        }

        @Override // android.view.TextureView, android.view.View
        protected void onSizeChanged(int i3, int i16, int i17, int i18) {
            OnSurfaceSizeChangedListener onSurfaceSizeChangedListener;
            if (BaseVideo.this.mOnSurfaceSizeChangedListener != null && (onSurfaceSizeChangedListener = (OnSurfaceSizeChangedListener) BaseVideo.this.mOnSurfaceSizeChangedListener.get()) != null) {
                onSurfaceSizeChangedListener.onSurfaceSizeChanged(i3, i16);
            }
            super.onSizeChanged(i3, i16, i17, i18);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class d implements TextureView.SurfaceTextureListener {
        d() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i3, int i16) {
            BaseVideo.this.surfaceCreated = true;
            BaseVideo.this.mSurfaceSize = new Pair<>(Integer.valueOf(i3), Integer.valueOf(i16));
            BaseVideo.this.onGLTextureViewAvailable(i3, i16);
            PlayerUtils.log(4, BaseVideo.this.LOG_TAG, "VideoAreaDebug onSurfaceTextureAvailable width=" + i3 + ",height=" + i16 + " video = " + PlayerUtils.toString(BaseVideo.this));
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            if (BaseVideo.this.outSurfaceTexture != null && BaseVideo.this.outSurfaceTexture == surfaceTexture) {
                BaseVideo.this.outSurfaceTexture = null;
                return true;
            }
            PlayerUtils.log(4, BaseVideo.this.LOG_TAG, "VideoAreaDebug onSurfaceTextureDestroyed video = " + PlayerUtils.toString(BaseVideo.this));
            BaseVideo baseVideo = BaseVideo.this;
            baseVideo.mHandler.obtainMessage(19, baseVideo).sendToTarget();
            BaseVideo.this.surfaceCreated = false;
            BaseVideo.this.onGLTextureViewDestroy();
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i3, int i16) {
            BaseVideo.this.mSurfaceSize = new Pair<>(Integer.valueOf(i3), Integer.valueOf(i16));
            PlayerUtils.log(4, BaseVideo.this.LOG_TAG, "onSurfaceTextureSizeChanged width=" + i3 + ",height=" + i16);
            BaseVideo.this.onGLTextureViewSizeChanged(i3, i16);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            BaseVideo baseVideo = BaseVideo.this;
            if (baseVideo.mIsNeedHideCover) {
                PlayerUtils.log(4, baseVideo.LOG_TAG, "onSurfaceTextureUpdated hideCover");
                if (BaseVideo.this.isBaseVideoCoverWrapperNotNull()) {
                    BaseVideo baseVideo2 = BaseVideo.this;
                    Handler handler = baseVideo2.mHandler;
                    handler.sendMessage(Message.obtain(handler, 17, baseVideo2.mVideoCoverWrapper.getCover()));
                    BaseVideo.this.mIsNeedHideCover = false;
                    return;
                }
                if (BaseVideo.this.isVideoCoverNotNull()) {
                    BaseVideo baseVideo3 = BaseVideo.this;
                    Handler handler2 = baseVideo3.mHandler;
                    handler2.sendMessage(Message.obtain(handler2, 17, baseVideo3.mVideoCover));
                    BaseVideo.this.mIsNeedHideCover = false;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class e extends SafeTextureView {
        e(Context context) {
            super(context);
        }

        @Override // android.view.TextureView, android.view.View
        protected void onSizeChanged(int i3, int i16, int i17, int i18) {
            OnSurfaceSizeChangedListener onSurfaceSizeChangedListener;
            if (BaseVideo.this.mOnSurfaceSizeChangedListener != null && (onSurfaceSizeChangedListener = (OnSurfaceSizeChangedListener) BaseVideo.this.mOnSurfaceSizeChangedListener.get()) != null) {
                onSurfaceSizeChangedListener.onSurfaceSizeChanged(i3, i16);
            }
            super.onSizeChanged(i3, i16, i17, i18);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class f implements TextureView.SurfaceTextureListener {
        f() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i3, int i16) {
            BaseVideo.this.surfaceCreated = true;
            BaseVideo.this.mSurfaceSize = new Pair<>(Integer.valueOf(i3), Integer.valueOf(i16));
            PlayerUtils.log(4, BaseVideo.this.LOG_TAG, "VideoAreaDebug  onSurfaceTextureAvailable width=" + i3 + ",height=" + i16 + " video = " + PlayerUtils.toString(BaseVideo.this));
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            if (BaseVideo.this.outSurfaceTexture != null && BaseVideo.this.outSurfaceTexture == surfaceTexture) {
                BaseVideo.this.outSurfaceTexture = null;
                return true;
            }
            PlayerUtils.log(4, BaseVideo.this.LOG_TAG, "VideoAreaDebug  onSurfaceTextureDestroyed video = " + PlayerUtils.toString(BaseVideo.this));
            BaseVideo baseVideo = BaseVideo.this;
            baseVideo.mHandler.obtainMessage(19, baseVideo).sendToTarget();
            BaseVideo.this.surfaceCreated = false;
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i3, int i16) {
            BaseVideo.this.mSurfaceSize = new Pair<>(Integer.valueOf(i3), Integer.valueOf(i16));
            PlayerUtils.log(4, BaseVideo.this.LOG_TAG, "onSurfaceTextureSizeChanged width=" + i3 + ",height=" + i16);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            BaseVideo baseVideo = BaseVideo.this;
            if (baseVideo.mIsNeedHideCover) {
                PlayerUtils.log(4, baseVideo.LOG_TAG, "onSurfaceTextureUpdated hideCover");
                if (BaseVideo.this.isBaseVideoCoverWrapperNotNull()) {
                    BaseVideo baseVideo2 = BaseVideo.this;
                    Handler handler = baseVideo2.mHandler;
                    handler.sendMessage(Message.obtain(handler, 17, baseVideo2.mVideoCoverWrapper.getCover()));
                    BaseVideo.this.mIsNeedHideCover = false;
                    return;
                }
                if (BaseVideo.this.isVideoCoverNotNull()) {
                    BaseVideo baseVideo3 = BaseVideo.this;
                    Handler handler2 = baseVideo3.mHandler;
                    handler2.sendMessage(Message.obtain(handler2, 17, baseVideo3.mVideoCover));
                    BaseVideo.this.mIsNeedHideCover = false;
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class g implements ViewTreeObserver.OnGlobalLayoutListener {
        g() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            BaseVideo.this.hasLayout = true;
            BaseVideo.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class i extends Handler {
        i(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            VideoPlayInfo videoPlayInfo;
            PlayerUtils.log(4, BaseVideo.this.LOG_TAG, "--------------------handleMessage msg.what=" + message.what + " video=" + PlayerUtils.toString(BaseVideo.this));
            int i3 = message.what;
            String str = "\u89c6\u9891\u6682\u65e0\u6cd5\u64ad\u653e\uff0c\u6253\u5f00\u7f51\u9875\u770b\u770b\u5427";
            if (i3 != 24) {
                if (i3 == 25) {
                    Object obj = message.obj;
                    if (obj != null) {
                        BaseVideo.this.onTimeViewController(((Boolean) obj).booleanValue());
                    }
                } else if (i3 == 32) {
                    BaseVideo.this.setLightTipTextWithAnimation(8);
                } else if (i3 == 33) {
                    BaseVideo.this.doOnVideoSizeChanged();
                } else {
                    switch (i3) {
                        case 1:
                            BaseVideo baseVideo = BaseVideo.this;
                            baseVideo.errCode = 0;
                            baseVideo.mShowCoverWarnType = false;
                            BaseVideo.setViewVisibility(baseVideo.mVideoView, 0);
                            BaseVideo.this.layoutVideoView();
                            BaseVideo baseVideo2 = BaseVideo.this;
                            baseVideo2.mIsNeedHideCover = true;
                            Handler handler = baseVideo2.mHandler;
                            handler.sendMessageDelayed(Message.obtain(handler, 17, message.obj), 1000);
                            if (BaseVideo.this.needShowSoundLine()) {
                                BaseVideo.this.mHandler.sendMessageDelayed(Message.obtain(BaseVideo.this.mHandler, 6), BaseVideo.this.getDelayHideCoverTime() + 200);
                            }
                            BaseVideo.this.showValidTimeText();
                            BaseVideo.this.hasShowLightTip = false;
                            break;
                        case 2:
                            Object obj2 = message.obj;
                            if (obj2 != null && BaseVideo.this.errCode != 403) {
                                BaseVideo.setViewVisibility((View) obj2, 0);
                            }
                            BaseVideo baseVideo3 = BaseVideo.this;
                            if (baseVideo3.errCode == 403) {
                                DescTextView errorView = baseVideo3.getErrorView();
                                if (!BaseVideo.this.hasVideoOrigUrl()) {
                                    str = "\u89c6\u9891\u6682\u65e0\u6cd5\u64ad\u653e";
                                }
                                errorView.setText(str);
                                BaseVideo.this.getErrorView().setVisibility(0);
                            } else {
                                DescTextView descTextView = baseVideo3.mErrorView;
                                if (descTextView != null) {
                                    descTextView.setVisibility(8);
                                }
                            }
                            BaseVideo.this.hideValidTimeText();
                            break;
                        case 3:
                            BaseVideo baseVideo4 = (BaseVideo) message.obj;
                            if (BaseVideo.this.getState(baseVideo4) == 2) {
                                BaseVideo.setViewVisibility(BaseVideo.this.mVideoView, 0);
                                if (baseVideo4.isBaseVideoCoverWrapperNotNull()) {
                                    baseVideo4.mVideoCoverWrapper.getCover().setVisibility(0);
                                    baseVideo4.mVideoCoverWrapper.getCover().invalidate();
                                } else if (baseVideo4.isVideoCoverNotNull()) {
                                    baseVideo4.mVideoCover.setVisibility(0);
                                    baseVideo4.mVideoCover.invalidate();
                                }
                                BaseVideo.this.stopSoundLines();
                                break;
                            }
                            break;
                        case 4:
                            BaseVideo.this.resetTimeView();
                            break;
                        case 5:
                            BaseVideo.this.mHandler.removeMessages(6);
                            if (BaseVideo.this.needShowTimeView() && (videoPlayInfo = BaseVideo.this.mVideoPlayInfo) != null && !TextUtils.isEmpty(videoPlayInfo.showVideoTime)) {
                                BaseVideo.this.getTimeview();
                                BaseVideo baseVideo5 = BaseVideo.this;
                                DescTextView descTextView2 = baseVideo5.mTimeview;
                                if (descTextView2 != null && baseVideo5.hasTimeview) {
                                    descTextView2.setText(baseVideo5.mVideoPlayInfo.showVideoTime);
                                    BaseVideo.setViewVisibility(BaseVideo.this.mTimeview, 0);
                                } else {
                                    BaseVideo.setViewVisibility(descTextView2, 8);
                                }
                                BaseVideo baseVideo6 = BaseVideo.this;
                                if (baseVideo6.mPlayCountView != null) {
                                    String c16 = baseVideo6.mVideoPlayInfo.c();
                                    if (!TextUtils.isEmpty(c16)) {
                                        BaseVideo baseVideo7 = BaseVideo.this;
                                        if (baseVideo7.hasPlayCountView) {
                                            baseVideo7.mPlayCountView.setText(c16);
                                            BaseVideo.setViewVisibility(BaseVideo.this.mPlayCountView, 0);
                                        }
                                    }
                                    BaseVideo.setViewVisibility(BaseVideo.this.mPlayCountView, 8);
                                }
                            }
                            BaseVideo.this.stopSoundLines();
                            break;
                        case 6:
                            VideoPlayInfo videoPlayInfo2 = BaseVideo.this.mVideoPlayInfo;
                            if (videoPlayInfo2 != null && !videoPlayInfo2.k()) {
                                BaseVideo.this.playSoundLines();
                                break;
                            }
                            break;
                        case 7:
                            break;
                        case 8:
                            BaseVideo baseVideo8 = (BaseVideo) message.obj;
                            if (BaseVideo.this.getState(baseVideo8) == 5) {
                                BaseVideo.setViewVisibility(BaseVideo.this.mVideoView, 0);
                                if (baseVideo8.isBaseVideoCoverWrapperNotNull()) {
                                    baseVideo8.mVideoCoverWrapper.getCover().setVisibility(0);
                                    baseVideo8.mVideoCoverWrapper.getCover().invalidate();
                                } else if (baseVideo8.isVideoCoverNotNull()) {
                                    baseVideo8.mVideoCover.setVisibility(0);
                                    baseVideo8.mVideoCover.invalidate();
                                }
                                BaseVideo.this.stopSoundLines();
                                break;
                            }
                            break;
                        default:
                            switch (i3) {
                                case 17:
                                    Object obj3 = message.obj;
                                    if (obj3 != null && ((View) obj3).getVisibility() == 0) {
                                        BaseVideo.setViewVisibility((View) message.obj, 8);
                                        DescTextView descTextView3 = BaseVideo.this.mErrorView;
                                        if (descTextView3 != null) {
                                            BaseVideo.setViewVisibility(descTextView3, 8);
                                        }
                                        BaseVideo.setViewVisibility(BaseVideo.this.mVideoView, 0);
                                        break;
                                    }
                                    break;
                                case 18:
                                    BaseVideo.this.getBaseVideoManager().stopVideo(BaseVideo.this);
                                    VideoManager.getInstance().clearCacheByInfo(BaseVideo.this.getSegmentVideoInfo());
                                    break;
                                case 19:
                                    BaseVideo.this.getBaseVideoManager().B(BaseVideo.this);
                                    break;
                                case 20:
                                    BaseVideo.this.startPlayNoDelay();
                                    break;
                                case 21:
                                    BaseVideo.this.hideValidTimeTextWithAnimation();
                                    break;
                                case 22:
                                    BaseVideo.this.reLayoutSurfaceView((VideoSize) message.obj);
                                    break;
                            }
                    }
                }
                BaseVideo.this.onReceivedMessage(message);
            }
            Object obj4 = message.obj;
            if (obj4 != null && BaseVideo.this.errCode != 403) {
                BaseVideo.setViewVisibility((View) obj4, 0);
            }
            BaseVideo baseVideo9 = BaseVideo.this;
            if (baseVideo9.errCode == 403) {
                DescTextView errorView2 = baseVideo9.getErrorView();
                if (!BaseVideo.this.hasVideoOrigUrl()) {
                    str = "\u89c6\u9891\u6682\u65e0\u6cd5\u64ad\u653e";
                }
                errorView2.setText(str);
                BaseVideo.this.getErrorView().setVisibility(0);
            } else {
                DescTextView descTextView4 = baseVideo9.mErrorView;
                if (descTextView4 != null) {
                    descTextView4.setVisibility(8);
                }
            }
            BaseVideo.this.hideValidTimeText();
            BaseVideo.this.resetTimeView();
            BaseVideo.this.hasShowLightTip = false;
            BaseVideo.this.onReceivedMessage(message);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class j implements ViewTreeObserver.OnGlobalLayoutListener {
        j() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            BaseVideo.this.hasLayout = true;
            BaseVideo.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class k implements BaseVideoManager.VideoPlayInfoListener {
        k() {
        }

        @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideoManager.VideoPlayInfoListener
        public void onVideoPlayComplete(VideoPlayInfoHolder videoPlayInfoHolder) {
            BaseVideoManager.VideoPlayInfoListener videoPlayInfoListener = BaseVideo.this.mVideoPlayInfoListener;
            if (videoPlayInfoListener != null) {
                videoPlayInfoListener.onVideoPlayComplete(videoPlayInfoHolder);
            }
        }

        @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideoManager.VideoPlayInfoListener
        public void onVideoPlayError(VideoPlayInfoHolder videoPlayInfoHolder) {
            BaseVideoManager.VideoPlayInfoListener videoPlayInfoListener = BaseVideo.this.mVideoPlayInfoListener;
            if (videoPlayInfoListener != null) {
                videoPlayInfoListener.onVideoPlayError(videoPlayInfoHolder);
            }
        }

        @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideoManager.VideoPlayInfoListener
        public void onVideoPlayPause(VideoPlayInfoHolder videoPlayInfoHolder) {
            BaseVideoManager.VideoPlayInfoListener videoPlayInfoListener = BaseVideo.this.mVideoPlayInfoListener;
            if (videoPlayInfoListener != null) {
                videoPlayInfoListener.onVideoPlayPause(videoPlayInfoHolder);
            }
        }

        @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideoManager.VideoPlayInfoListener
        public void onVideoPlayProgressUpdate(VideoPlayInfoHolder videoPlayInfoHolder) {
            BaseVideoManager.VideoPlayInfoListener videoPlayInfoListener = BaseVideo.this.mVideoPlayInfoListener;
            if (videoPlayInfoListener != null) {
                videoPlayInfoListener.onVideoPlayProgressUpdate(videoPlayInfoHolder);
            }
        }

        @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideoManager.VideoPlayInfoListener
        public void onVideoPlayStart(VideoPlayInfoHolder videoPlayInfoHolder) {
            BaseVideoManager.VideoPlayInfoListener videoPlayInfoListener = BaseVideo.this.mVideoPlayInfoListener;
            if (videoPlayInfoListener != null) {
                videoPlayInfoListener.onVideoPlayStart(videoPlayInfoHolder);
            }
        }

        @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideoManager.VideoPlayInfoListener
        public void onVideoPlayStop(VideoPlayInfoHolder videoPlayInfoHolder) {
            BaseVideoManager.VideoPlayInfoListener videoPlayInfoListener = BaseVideo.this.mVideoPlayInfoListener;
            if (videoPlayInfoListener != null) {
                videoPlayInfoListener.onVideoPlayStop(videoPlayInfoHolder);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class l implements View.OnClickListener {
        l() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.tencent.mobileqq.qzoneplayer.video.g gVar;
            EventCollector.getInstance().onViewClickedBefore(view);
            PlayerUtils.log(4, BaseVideo.this.LOG_TAG, "Feed Video View onClick: enter video popup");
            BaseVideo baseVideo = BaseVideo.this;
            VideoPlayInfo videoPlayInfo = baseVideo.mVideoPlayInfo;
            if (videoPlayInfo != null && videoPlayInfo.isAdvMicro) {
                baseVideo.onFeedVideoElementClickListener.onClick(view, FeedVideoElement.ADV_MICRO, baseVideo.feedPosition, videoPlayInfo);
            } else if (videoPlayInfo != null && videoPlayInfo.k() && BaseVideo.this.getState() == 1) {
                if (!BaseVideoManager.belowICE_CREAM && !FeedVideoEnv.CLOSE_HARDWARE_ACCELERATED) {
                    BaseVideo.this.getBaseVideoManager().startVideo(BaseVideo.this);
                    FeedVideoEnv.externalFunc.hideWindowPlay();
                } else {
                    BaseVideo baseVideo2 = BaseVideo.this;
                    baseVideo2.onFeedVideoElementClickListener.onClick(view, FeedVideoElement.AUTO_VIDEO, baseVideo2.feedPosition, baseVideo2.mVideoPlayInfo);
                }
            } else {
                BaseVideo baseVideo3 = BaseVideo.this;
                com.tencent.mobileqq.qzoneplayer.video.g gVar2 = baseVideo3.onFeedVideoElementClickListener;
                if (gVar2 != null) {
                    gVar2.onClick(view, FeedVideoElement.AUTO_VIDEO, baseVideo3.feedPosition, baseVideo3.mVideoPlayInfo);
                    if (BaseVideo.this.mVideoPlayInfo != null && FeedVideoEnv.externalFunc.isFreeTraffic() && !FeedVideoEnv.isWifiConnected()) {
                        FeedVideoEnv.externalFunc.reportClick("8", ThemeReporter.FROM_NIGHT_ROAMING, "2");
                        if (BaseVideo.this.mVideoPlayInfo.isLiveVideo) {
                            FeedVideoEnv.externalFunc.reportToLp00064(LpReportInfoConfig.ACTION_TYPE_DAWANG, 2, 1);
                        } else {
                            FeedVideoEnv.externalFunc.reportToLp00064(LpReportInfoConfig.ACTION_TYPE_DAWANG, 2, 2);
                        }
                    }
                }
                if (BaseVideo.this.getState() != 3 && BaseVideo.this.getState() != 2 && BaseVideo.this.getState() != 1 && !BaseVideoManager.belowICE_CREAM && !FeedVideoEnv.CLOSE_HARDWARE_ACCELERATED) {
                    if (BaseVideo.this.getState() == 5) {
                        BaseVideo.this.getBaseVideoManager().F();
                    }
                } else {
                    BaseVideo baseVideo4 = BaseVideo.this;
                    VideoPlayInfo videoPlayInfo2 = baseVideo4.mVideoPlayInfo;
                    if (videoPlayInfo2 != null && (gVar = baseVideo4.onFeedVideoElementClickListener) != null) {
                        gVar.onClick(view, FeedVideoElement.AUTO_VIDEO_CLICK, baseVideo4.feedPosition, videoPlayInfo2);
                        BaseVideo baseVideo5 = BaseVideo.this;
                        PictureUrl pictureUrl = baseVideo5.mVideoPlayInfo.coverUrl;
                        if (pictureUrl != null) {
                            pictureUrl.width = baseVideo5.getVideoCoverWidth();
                            BaseVideo baseVideo6 = BaseVideo.this;
                            baseVideo6.mVideoPlayInfo.coverUrl.height = baseVideo6.getVideoCoverHeight();
                        }
                        FeedVideoEnv.externalFunc.hidePlayTips();
                        if (BaseVideo.this.getState() != 2 && BaseVideo.this.getState() != 1 && !BaseVideo.this.mVideoPlayInfo.k()) {
                            BaseVideo.this.onVideoClick();
                        }
                    }
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class m implements View.OnLongClickListener {
        m() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            EventCollector.getInstance().onViewLongClickedBefore(view);
            com.tencent.mobileqq.qzoneplayer.video.h hVar = BaseVideo.this.onFeedVideoElementLongClickListener;
            if (hVar != null) {
                hVar.onVideoLongClick(view);
            } else if (FeedVideoEnv.externalFunc.isDebugVersion()) {
                FeedVideoEnv.FeedVideoExternalFunc feedVideoExternalFunc = FeedVideoEnv.externalFunc;
                Context context = BaseVideo.this.getContext();
                String str = "null";
                if (BaseVideo.this.mVideoPlayInfo != null) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(BaseVideo.this.LOG_TAG);
                    sb5.append("basevideodebug @this=");
                    sb5.append(BaseVideo.this.toString());
                    sb5.append("\n, vid=");
                    sb5.append(BaseVideo.this.mVideoPlayInfo.videoId);
                    sb5.append("\n, feedkey=");
                    sb5.append(BaseVideo.this.mVideoPlayInfo.feedKey);
                    sb5.append("\n,v=");
                    sb5.append(view.toString());
                    sb5.append("\n,textureview=");
                    sb5.append(BaseVideo.this.mVideoView.toString());
                    sb5.append("\n,cover=");
                    BaseVideoCover baseVideoCover = BaseVideo.this.mVideoCover;
                    if (baseVideoCover != null) {
                        str = baseVideoCover.toString();
                    }
                    sb5.append(str);
                    sb5.append("\n,videoplayinfo=");
                    sb5.append(BaseVideo.this.mVideoPlayInfo.b());
                    sb5.append("\n,cache=");
                    sb5.append(VideoManager.getInstance().getVideoKey(BaseVideo.this.mVideoPlayInfo.segmentVideoInfo.getDefaultUrl()));
                    str = sb5.toString();
                }
                feedVideoExternalFunc.showDebugDialog(context, str);
            }
            EventCollector.getInstance().onViewLongClicked(view);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class n implements View.OnTouchListener {
        n() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return BaseVideo.this.onTouchExt(view, motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class o implements DescTextView.b {
        o() {
        }

        @Override // com.tencent.mobileqq.qzoneplayer.video.DescTextView.b
        public boolean a() {
            DescTextView descTextView = BaseVideo.this.mHudView;
            if (descTextView != null && descTextView.getVisibility() == 0) {
                BaseVideo.setViewVisibility(BaseVideo.this.mHudView, 8);
                BaseVideo.this.mHudViewIsHideManually = true;
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public static class p implements Comparable<p> {

        /* renamed from: d, reason: collision with root package name */
        int f279584d;

        /* renamed from: e, reason: collision with root package name */
        String f279585e;

        p() {
        }

        @Override // java.lang.Comparable
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int compareTo(p pVar) {
            return this.f279584d - pVar.f279584d;
        }

        public int hashCode() {
            int i3 = this.f279584d * 31;
            String str = this.f279585e;
            return i3 + (str != null ? str.hashCode() : 0);
        }

        /* synthetic */ p(i iVar) {
            this();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            p pVar = (p) obj;
            if (this.f279584d != pVar.f279584d) {
                return false;
            }
            String str = this.f279585e;
            String str2 = pVar.f279585e;
            if (str != null) {
                return str.equals(str2);
            }
            return str2 == null;
        }
    }

    public BaseVideo(Context context) {
        super(context);
        this.LOG_TAG = "BaseVideo";
        this.mState = 0;
        this.hasTimeview = true;
        this.hasPlayCountView = true;
        this.hasSoundTipLayout = true;
        this.hasSoundLinesLayout = true;
        this.showCoverImage = true;
        this.mIsNeedHideCover = false;
        this.mShowCoverWarnType = false;
        this.eventIsHandled = true;
        this.mIsSupport360 = false;
        this.alphaAnimationDuration = 3;
        this.mPlayStateSubject = new VideoPlayerEventCenter.ConcreteSubject();
        this.mRealVideoWidth = 0;
        this.mRealVideoHeight = 0;
        this.mHudTextMap = new TreeMap<>();
        this.mHandler = new i(Looper.getMainLooper());
        this.mVideoClickListener = new l();
        this.mTouchMoved = false;
        this.mIsPressed = false;
        this.mIsMoved = false;
        this.mVideoLongClickListener = new m();
        this.mHudViewIsHideManually = false;
        this.mLongPressRunnable = new Runnable() { // from class: com.tencent.mobileqq.qzoneplayer.video.BaseVideo.12
            @Override // java.lang.Runnable
            public void run() {
                BaseVideo.this.mIsPressed = false;
                BaseVideo baseVideo = BaseVideo.this;
                baseVideo.onLongClickVideoEventProcess(baseVideo);
            }
        };
        this.mVideoPlayInfoListenerWrapper = new k();
        this.mVideoPlayInfoListener = null;
        initChildView();
        setContentDescription(this.LOG_TAG);
    }

    private void createSurfaceNormal() {
        e eVar = new e(getContext());
        this.mVideoView = eVar;
        eVar.setContentDescription("SafeTextureView");
        ((SafeTextureView) this.mVideoView).setSurfaceTextureListener(new f());
    }

    private void createSurfaceSupport360() {
        c cVar = new c(getContext());
        this.mVideoView = cVar;
        cVar.setContentDescription("GLTextureView");
        ((GLTextureView) this.mVideoView).setSurfaceTextureListener(new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doOnVideoSizeChanged() {
        if (getState() != 0 && this.mVideoView != null) {
            this.hasLayout = false;
            requestLayout();
            this.mVideoView.getViewTreeObserver().addOnGlobalLayoutListener(new j());
        }
        this.lastVideoSize = null;
        layoutSurfaceView();
    }

    private String getCoverUrlDetail(PictureUrl pictureUrl) {
        StringBuilder sb5 = new StringBuilder("{");
        if (pictureUrl != null) {
            sb5.append("url=");
            sb5.append(pictureUrl.url);
            sb5.append(",width=");
            sb5.append(pictureUrl.width);
            sb5.append(",height=");
            sb5.append(pictureUrl.height);
        }
        sb5.append("}");
        return sb5.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DescTextView getErrorView() {
        if (this.mErrorView == null) {
            DescTextView descTextView = new DescTextView(getContext(), "mErrorView");
            this.mErrorView = descTextView;
            descTextView.setTextColor(-1);
            Drawable drawable = FeedVideoEnv.feedResources.getDrawable(1114);
            if (drawable == null) {
                PlayerUtils.log(6, this.LOG_TAG, "drawable FEEDS_VIDEO_TIMER_BG is null");
                return null;
            }
            this.mErrorView.setBackgroundDrawable(drawable);
            this.mErrorView.setTextSize(15.0f);
            DescTextView descTextView2 = this.mErrorView;
            int i3 = FeedVideoEnv.dp5;
            descTextView2.setPadding(0, i3, 0, i3);
            this.mErrorView.setVisibility(8);
            this.mErrorView.setGravity(17);
            this.mErrorView.setSingleLine(true);
            this.mErrorView.setEllipsize(TextUtils.TruncateAt.END);
            this.mErrorView.setText("\u89c6\u9891\u6682\u65e0\u6cd5\u64ad\u653e\uff0c\u6253\u5f00\u7f51\u9875\u770b\u770b\u5427");
            addView(this.mErrorView);
            this.mErrorView.setOnClickListener(new a());
        }
        return this.mErrorView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RelativeLayout getRemarkLayout() {
        if (this.remarkLayout == null) {
            Context context = getContext();
            this.remarkLayout = new RelativeLayout(context);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, FeedVideoEnv.REMARK_LAYOUT_HEIGHT);
            layoutParams.gravity = 80;
            this.remarkLayout.setBackgroundColor(FeedVideoEnv.feedResources.getColor(1639));
            this.remarkText = new DescTextView(context, "remarkText");
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams2.addRule(15, -1);
            int i3 = FeedVideoEnv.dp12;
            layoutParams2.setMargins(i3, 0, i3, 0);
            this.remarkText.setTextColor(FeedVideoEnv.feedResources.getColor(1640));
            this.remarkText.setTextSize(14.0f);
            this.remarkText.setSingleLine(true);
            this.remarkText.setEllipsize(TextUtils.TruncateAt.END);
            this.remarkLayout.addView(this.remarkText, layoutParams2);
            DescTextView descTextView = new DescTextView(context, "line_btm");
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, 1);
            layoutParams3.addRule(12, -1);
            descTextView.setBackgroundColor(FeedVideoEnv.feedResources.getColor(1641));
            this.remarkLayout.addView(descTextView, layoutParams3);
            DescTextView descTextView2 = new DescTextView(context, "line_left");
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(1, -1);
            layoutParams4.addRule(9, -1);
            descTextView2.setBackgroundColor(FeedVideoEnv.feedResources.getColor(1641));
            this.remarkLayout.addView(descTextView2, layoutParams4);
            DescTextView descTextView3 = new DescTextView(context, "line_right");
            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(1, -1);
            layoutParams5.addRule(11, -1);
            descTextView3.setBackgroundColor(FeedVideoEnv.feedResources.getColor(1641));
            this.remarkLayout.addView(descTextView3, layoutParams5);
            addView(this.remarkLayout, layoutParams);
            this.remarkLayout.setOnClickListener(new b());
        }
        return this.remarkLayout;
    }

    private void getSoundLinesLayout() {
        if (this.mSoundLinesLayout == null && this.hasSoundLinesLayout) {
            SoundLines soundLines = new SoundLines(getContext());
            this.mSoundLinesLayout = soundLines;
            addView(soundLines, -1);
            this.mSoundLinesLayout.setVisibility(8);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mSoundLinesLayout.getLayoutParams();
            layoutParams.topMargin = getVideoCoverHeight() - FeedVideoEnv.dp20;
            layoutParams.rightMargin = FeedVideoEnv.f279795dp3;
            layoutParams.gravity = 53;
            this.mSoundLinesLayout.setLayoutParams(layoutParams);
            t.d(this.mSoundLinesLayout, 1.0f);
        }
        SoundLines soundLines2 = this.mSoundLinesLayout;
        if (soundLines2 != null) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) soundLines2.getLayoutParams();
            layoutParams2.topMargin = getVideoCoverHeight() - FeedVideoEnv.dp20;
            layoutParams2.rightMargin = FeedVideoEnv.f279795dp3;
            layoutParams2.gravity = 53;
            this.mSoundLinesLayout.setLayoutParams(layoutParams2);
        }
    }

    private LinearLayout getValidTimeLayout() {
        if (this.validTimeLayout == null) {
            Context context = getContext();
            new FrameLayout.LayoutParams(-1, FeedVideoEnv.REMARK_LAYOUT_HEIGHT);
            LinearLayout linearLayout = new LinearLayout(context);
            this.validTimeLayout = linearLayout;
            linearLayout.setContentDescription("validTimeLayout");
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, FeedVideoEnv.dp32);
            layoutParams.gravity = 53;
            this.validTimeLayout.setBackgroundColor(-1153153980);
            this.validTimeText = new DescTextView(context, "validTimeText");
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 17;
            int i3 = FeedVideoEnv.dp12;
            layoutParams2.setMargins(i3, 0, i3, 0);
            this.validTimeText.setTextColor(-1);
            this.validTimeText.setTextSize(14.0f);
            this.validTimeText.setSingleLine(true);
            this.validTimeText.setText("\u8bd5\u770b5\u5206\u949f");
            this.validTimeText.setEllipsize(TextUtils.TruncateAt.END);
            this.validTimeLayout.addView(this.validTimeText, layoutParams2);
            hideValidTimeText();
            addView(this.validTimeLayout, layoutParams);
        }
        return this.validTimeLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLiveEndAnim() {
        FrameLayout frameLayout = this.mLiveEndAnimContainer;
        if (frameLayout == null) {
            return;
        }
        setViewVisibility(frameLayout, 4);
    }

    private void initLightTipLayout(int i3) {
        View view = this.lightTipLayout;
        if (view == null) {
            Context context = getContext();
            LinearLayout linearLayout = new LinearLayout(context);
            this.lightTipLayout = linearLayout;
            linearLayout.setContentDescription("lightTipLayout");
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i3, -2);
            layoutParams.gravity = 48;
            this.lightTipLayout.setBackgroundColor(-1728053248);
            this.lightTipText = new DescTextView(context, "lightTipText");
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i3 - (FeedVideoEnv.dp12 * 2), -2);
            layoutParams2.gravity = 19;
            layoutParams2.setMargins(FeedVideoEnv.dp12, FeedVideoEnv.dpToPx(7.5f), FeedVideoEnv.dp12, FeedVideoEnv.dpToPx(7.5f));
            this.lightTipText.setTextColor(-1);
            this.lightTipText.setTextSize(14.0f);
            this.lightTipText.setText("\u89c6\u9891\u5df2\u5168\u90e8\u7f13\u5b58\uff0c\u89c2\u770b\u4e0d\u6d88\u8017\u6d41\u91cf");
            this.lightTipText.setSingleLine(false);
            this.lightTipText.setVisibility(0);
            this.lightTipLayout.addView(this.lightTipText, layoutParams2);
            hideLightTipTimeText();
            addView(this.lightTipLayout, layoutParams);
            this.lightTipLayout.measure(0, 0);
            return;
        }
        removeView(view);
        this.lightTipLayout = null;
        initLightTipLayout(i3);
    }

    private void layoutSurfaceView() {
        layoutSurfaceView(0);
    }

    private static void makeVkeyOutDate(SegmentVideoInfo.StreamInfo streamInfo) {
        SegmentVideoInfo.SegmentInfo next;
        ArrayList<SegmentVideoInfo.SegmentInfo> arrayList = streamInfo.segmentInfos;
        if (arrayList == null) {
            return;
        }
        Iterator<SegmentVideoInfo.SegmentInfo> it = arrayList.iterator();
        while (it.hasNext() && (next = it.next()) != null && !TextUtils.isEmpty(next.url)) {
            next.url = PlayerUtils.replaceUriParameter(Uri.parse(next.url), "vkey", "aaaaa").toString();
        }
    }

    private void showLiveEndAnim() {
        FrameLayout frameLayout = this.mLiveEndAnimContainer;
        if (frameLayout == null) {
            return;
        }
        setViewVisibility(frameLayout, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlayNoDelay() {
        View view = this.mVideoView;
        if (view != null) {
            view.setVisibility(0);
        }
        layoutVideoView();
        if (isBaseVideoCoverWrapperNotNull()) {
            this.mVideoCoverWrapper.getCover().setVisibility(8);
            DescTextView descTextView = this.mErrorView;
            if (descTextView != null) {
                setViewVisibility(descTextView, 8);
            }
            hideValidTimeText();
        } else if (isVideoCoverNotNull()) {
            this.mVideoCover.setVisibility(8);
            DescTextView descTextView2 = this.mErrorView;
            if (descTextView2 != null) {
                setViewVisibility(descTextView2, 8);
            }
            hideValidTimeText();
        }
        this.mHandler.removeMessages(6);
        this.mHandler.sendMessageDelayed(Message.obtain(this.mHandler, 6), 500);
        showValidTimeText();
        this.mShowCoverWarnType = false;
    }

    protected void addAutoVideoCover(Context context) {
        if (FeedVideoEnv.externalFunc.getWnsConfig("VideoSDKSetting", "UseNewVideoCoverSetting", 1) != 0) {
            BaseVideoCover baseVideoCover = new BaseVideoCover(context, this);
            this.mVideoCover = baseVideoCover;
            addView(baseVideoCover);
            this.mVideoCover.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            return;
        }
        BaseVideoCover baseVideoCover2 = new BaseVideoCover(context, this);
        this.mVideoCover = baseVideoCover2;
        addView(baseVideoCover2);
        this.mVideoCover.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    protected void addHudView() {
        DescTextView descTextView = new DescTextView(getContext(), "hudview");
        this.mHudView = descTextView;
        descTextView.enableTextScroll(true);
        this.mHudView.setOnSingleTapConfirmedListener(new o());
        this.mHudView.setText("");
        this.mHudView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        this.mHudView.setTextSize(12.0f);
        this.mHudView.setTextColor(-1);
        this.mHudView.setBackgroundColor(1996488704);
        this.mHudView.setPadding(10, 10, 10, 10);
        ((FrameLayout.LayoutParams) this.mHudView.getLayoutParams()).gravity = 51;
        addView(this.mHudView);
        this.mHudView.setVisibility(8);
    }

    protected void addLiveStatIcon() {
        ImageView imageView = new ImageView(getContext());
        this.mLiveStatIcon = imageView;
        imageView.setContentDescription("BaseVideo.mLiveStatIcon");
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        int i3 = FeedVideoEnv.dp10;
        layoutParams.leftMargin = i3;
        layoutParams.topMargin = i3;
        layoutParams.gravity = 3;
        addView(this.mLiveStatIcon, layoutParams);
    }

    public void checkIlleaglVideo() {
        if (this.mVideoPlayInfo != null) {
            if (this.mIllegalCallback == null) {
                this.mIllegalCallback = new com.tencent.mobileqq.qzoneplayer.video.o(this);
            }
            FeedVideoEnv.externalFunc.checkVideoIllegal(this.mVideoPlayInfo.videoId, this.mIllegalCallback);
        }
    }

    protected void checkSupport360() {
        if (!BaseVideoManager.belowICE_CREAM && com.tencent.mobileqq.qzoneplayer.panorama.a.e(getContext())) {
            this.mIsSupport360 = true;
        } else {
            this.mIsSupport360 = false;
            PlayerUtils.log(4, this.LOG_TAG, "can not support 360video");
        }
    }

    public void clearHudText() {
        TreeMap<p, String> treeMap = this.mHudTextMap;
        if (treeMap != null) {
            treeMap.clear();
        }
    }

    protected void createSurface() {
        FeedVideoEnv.FeedVideoExternalFunc feedVideoExternalFunc = FeedVideoEnv.externalFunc;
        if (feedVideoExternalFunc != null && feedVideoExternalFunc.isEnable360Video()) {
            createSurfaceSupport360();
        } else {
            createSurfaceNormal();
        }
    }

    public void doPlayVideo() {
        getBaseVideoManager().startVideo(this);
    }

    protected int getBackgroundColor() {
        return -16777216;
    }

    public BaseVideoManager getBaseVideoManager() {
        WeakReference<BaseVideoManager> weakReference = this.baseVideoManager;
        if (weakReference != null && weakReference.get() != null) {
            return this.baseVideoManager.get();
        }
        return BaseVideoManager.getFeedVideoManager();
    }

    public long getCurrentPosition() {
        return 0L;
    }

    protected int getDelayHideCoverTime() {
        return 200;
    }

    public SegmentVideoInfo.StreamInfo getH265StreamInfo() {
        if (this.mVideoPlayInfo == null) {
            return null;
        }
        return getStreamInfo(4);
    }

    public HttpRetryLogic getHttpRetryLogic() {
        return this.mHttpRetryLogic;
    }

    public int getHudOrderBySubject(String str) {
        TreeMap<p, String> treeMap = this.mHudTextMap;
        if (treeMap == null) {
            return -1;
        }
        for (p pVar : treeMap.keySet()) {
            if (pVar.f279585e.equals(str)) {
                return pVar.f279584d;
            }
        }
        return -1;
    }

    public int getOrgwebsite() {
        VideoPlayInfo videoPlayInfo = this.mVideoPlayInfo;
        if (videoPlayInfo == null) {
            return 0;
        }
        return videoPlayInfo.orgwebsite;
    }

    public String getPlayVideoUrl() {
        if (getBaseVideoManager() != null) {
            return getBaseVideoManager().j();
        }
        return null;
    }

    public int getRealVideoHeight() {
        return this.mRealVideoHeight;
    }

    public int getRealVideoWidth() {
        return this.mRealVideoWidth;
    }

    public String getRecordVideoId() {
        return this.mRecordVideoId;
    }

    public SegmentVideoInfo getSegmentVideoInfo() {
        VideoPlayInfo videoPlayInfo = this.mVideoPlayInfo;
        if (videoPlayInfo == null) {
            return null;
        }
        return videoPlayInfo.segmentVideoInfo;
    }

    public int getState() {
        return this.mState;
    }

    public SegmentVideoInfo.StreamInfo getStreamInfo() {
        if (getSegmentVideoInfo() != null && VideoManager.getInstance().isCached(getSegmentVideoInfo().getStreamInfo(3)) && getStreamInfo(3) != null) {
            PlayerUtils.log(4, this.LOG_TAG, "play origin url=" + getStreamInfo(3).getUrl());
            return getStreamInfo(3);
        }
        VideoPlayInfo videoPlayInfo = this.mVideoPlayInfo;
        if (videoPlayInfo == null || videoPlayInfo.segmentVideoInfo == null) {
            return null;
        }
        return yl2.c.e().g(FeedVideoEnv.getNetworkType()).e(this.mVideoPlayInfo.segmentVideoInfo);
    }

    public Surface getSurface() {
        Surface surface;
        View view;
        if (!isSurfaceAvailable()) {
            return null;
        }
        try {
            if (isUse360VideoRender() && (view = this.mVideoView) != null && (view instanceof GLTextureView)) {
                surface = ((GLTextureView) view).d(GLTextureView.RendererType.VIDEO360);
                PlayerUtils.log(4, this.LOG_TAG, "create 360 surface " + surface + ", " + this);
            } else {
                surface = null;
            }
            if (surface == null) {
                View view2 = this.mVideoView;
                if (view2 != null) {
                    SurfaceTexture surfaceTexture = ((SafeTextureView) view2).getSurfaceTexture();
                    surface = surfaceTexture == null ? null : new Surface(surfaceTexture);
                }
                PlayerUtils.log(4, this.LOG_TAG, "create normal surface " + surface + ", " + this);
            }
            return surface;
        } catch (Exception unused) {
            return null;
        }
    }

    public SurfaceTexture getSurfaceTexture() {
        if (BaseVideoManager.belowICE_CREAM) {
            return null;
        }
        try {
            this.outSurfaceTexture = ((SafeTextureView) this.mVideoView).getSurfaceTexture();
        } catch (Exception unused) {
            this.outSurfaceTexture = null;
        }
        return this.outSurfaceTexture;
    }

    public void getTimeview() {
        if (this.mTimeview == null && this.hasTimeview) {
            Context context = getContext();
            DescTextView descTextView = new DescTextView(context, "mTimeview");
            this.mTimeview = descTextView;
            descTextView.setTextColor(-1);
            this.mTimeview.setCompoundDrawables(FeedVideoEnv.feedResources.getDrawable(FaceManager.FACE_ACQUIRED_MULTI_FACE), null, null, null);
            this.mTimeview.setTextSize(12.0f);
            this.mTimeview.setPadding(0, 0, FeedVideoEnv.dp5 + FeedVideoEnv.f279794dp1, 0);
            this.mTimeview.setGravity(53);
            this.mTimeview.setSingleLine();
            if (this.bottomShadow == null) {
                RelativeLayout relativeLayout = new RelativeLayout(getContext());
                this.bottomShadow = relativeLayout;
                relativeLayout.setContentDescription("bottomShadow");
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, FeedVideoEnv.dp37);
                layoutParams.gravity = 53;
                this.bottomShadow.setBackground(FeedVideoEnv.feedResources.getDrawable(AppConstants.RiskHintTemplate.TEMPLATE_TYPE_RISK_FOR_PROTECT));
                addView(this.bottomShadow, layoutParams);
            }
            addView(this.mTimeview);
            DescTextView descTextView2 = new DescTextView(context, "\u64ad\u653e\u91cf");
            this.mPlayCountView = descTextView2;
            descTextView2.setTextColor(-1);
            this.mPlayCountView.setCompoundDrawablesWithIntrinsicBounds(FeedVideoEnv.feedResources.getDrawable(1122), (Drawable) null, (Drawable) null, (Drawable) null);
            this.mPlayCountView.setTextSize(12.0f);
            this.mPlayCountView.setCompoundDrawablePadding(FeedVideoEnv.dp5);
            this.mPlayCountView.setGravity(19);
            this.mPlayCountView.setSingleLine();
            addView(this.mPlayCountView);
        }
        DescTextView descTextView3 = this.mTimeview;
        if (descTextView3 != null) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) descTextView3.getLayoutParams();
            layoutParams2.topMargin = getVideoCoverHeight() - FeedVideoEnv.dp20;
            layoutParams2.rightMargin = FeedVideoEnv.f279795dp3;
            layoutParams2.gravity = 53;
            this.mTimeview.setLayoutParams(layoutParams2);
        }
        DescTextView descTextView4 = this.mPlayCountView;
        if (descTextView4 != null) {
            FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) descTextView4.getLayoutParams();
            layoutParams3.topMargin = getVideoCoverHeight() - FeedVideoEnv.dp24;
            layoutParams3.leftMargin = FeedVideoEnv.dp10;
            this.mPlayCountView.setLayoutParams(layoutParams3);
        }
        RelativeLayout relativeLayout2 = this.bottomShadow;
        if (relativeLayout2 != null) {
            FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) relativeLayout2.getLayoutParams();
            layoutParams4.topMargin = getVideoCoverHeight() - FeedVideoEnv.dp34;
            layoutParams4.gravity = 53;
            this.bottomShadow.setLayoutParams(layoutParams4);
        }
    }

    public View getVideoCover() {
        if (isBaseVideoCoverWrapperNotNull()) {
            return this.mVideoCoverWrapper.getCover();
        }
        return this.mVideoCover;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getVideoCoverHeight() {
        if (isBaseVideoCoverWrapperNotNull()) {
            return this.mVideoCoverWrapper.getPicHeight();
        }
        return this.mVideoCover.picHeight;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getVideoCoverWidth() {
        if (isBaseVideoCoverWrapperNotNull()) {
            return this.mVideoCoverWrapper.getPicWidth();
        }
        return this.mVideoCover.picWidth;
    }

    public ICoverWrapper getVideoCoverWrapper() {
        return this.mVideoCoverWrapper;
    }

    public VideoPlayInfo getVideoPlayInfo() {
        return this.mVideoPlayInfo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseVideoManager.VideoPlayInfoListener getVideoPlayInfoListener() {
        return this.mVideoPlayInfoListenerWrapper;
    }

    public Pair<Integer, Integer> getVideoSurfaceSize() {
        return this.mSurfaceSize;
    }

    public View getVideoView() {
        return this.mVideoView;
    }

    public boolean hasVideoOrigUrl() {
        VideoPlayInfo videoPlayInfo = this.mVideoPlayInfo;
        return (videoPlayInfo == null || TextUtils.isEmpty(videoPlayInfo.actionurl)) ? false : true;
    }

    public void hideHudView() {
        DescTextView descTextView = this.mHudView;
        if (descTextView != null) {
            setViewVisibility(descTextView, 8);
        }
    }

    public void hideLightTipTimeText() {
        setViewVisibility(this.lightTipLayout, 4);
    }

    public void hideValidTimeText() {
        setViewVisibility(this.validTimeLayout, 8);
    }

    public void hideValidTimeTextWithAnimation() {
        if (this.validTimeLayout != null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(500L);
            alphaAnimation.setAnimationListener(new h());
            this.validTimeLayout.startAnimation(alphaAnimation);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initChildView() {
        Context context = getContext();
        FeedVideoEnv.FeedVideoExternalFunc feedVideoExternalFunc = FeedVideoEnv.externalFunc;
        if (feedVideoExternalFunc != null && feedVideoExternalFunc.isEnable360Video()) {
            checkSupport360();
        }
        initVideoView();
        addAutoVideoCover(context);
        if (FeedVideoEnv.feedResources == null) {
            return;
        }
        setOnTouchListener(new n());
        setOnLongClickListener(this.mVideoLongClickListener);
        addHudView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initVideoView() {
        if (BaseVideoManager.belowICE_CREAM) {
            View view = new View(getContext());
            this.mVideoView = view;
            view.setContentDescription(CommonVideoViewController.CLASS_NAME);
            this.mHasAddVideoView = true;
        } else {
            createSurface();
        }
        this.mVideoView.setVisibility(8);
    }

    public boolean isBaseVideoCoverWrapperNotNull() {
        ICoverWrapper iCoverWrapper = this.mVideoCoverWrapper;
        return (iCoverWrapper == null || iCoverWrapper.getParentView() == null) ? false : true;
    }

    public boolean isCanControl360Video(int i3, int i16) {
        if (this.mVideoView != null && isInControl360VideoState()) {
            int[] iArr = new int[2];
            this.mVideoView.getLocationOnScreen(iArr);
            int measuredWidth = this.mVideoView.getMeasuredWidth();
            int measuredHeight = this.mVideoView.getMeasuredHeight();
            Rect rect = new Rect();
            int i17 = iArr[0];
            rect.left = i17;
            rect.right = i17 + measuredWidth;
            int i18 = iArr[1];
            rect.top = i18;
            rect.bottom = i18 + measuredHeight;
            if (rect.contains(i3, i16)) {
                return true;
            }
        }
        return false;
    }

    public boolean isCurrentPlay360Video() {
        VideoPlayInfo videoPlayInfo = this.mVideoPlayInfo;
        return videoPlayInfo != null && videoPlayInfo.d();
    }

    public boolean isInControl360VideoState() {
        return (getState() == 3 || getState() == 5) && isUse360VideoRender();
    }

    protected boolean isIntentPlayingVideo() {
        if (getBaseVideoManager() != null) {
            return getBaseVideoManager().v(this);
        }
        return false;
    }

    public boolean isLandscape() {
        return false;
    }

    public boolean isNeedShowEndCover() {
        VideoPlayInfo videoPlayInfo = this.mVideoPlayInfo;
        if (videoPlayInfo != null && videoPlayInfo.k()) {
            return true;
        }
        VideoPlayInfo videoPlayInfo2 = this.mVideoPlayInfo;
        return videoPlayInfo2 != null && videoPlayInfo2.orgwebsite == 1 && this.mIsVip;
    }

    protected boolean isSetBackgroundColor() {
        return true;
    }

    public synchronized boolean isShowCoverImage() {
        return this.showCoverImage;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isSpecialVideo() {
        VideoPlayInfo videoPlayInfo = this.mVideoPlayInfo;
        return videoPlayInfo != null && videoPlayInfo.k();
    }

    public boolean isSupport360() {
        return this.mIsSupport360;
    }

    public boolean isSurfaceAvailable() {
        View view;
        if (BaseVideoManager.belowICE_CREAM || FeedVideoEnv.CLOSE_HARDWARE_ACCELERATED || (view = this.mVideoView) == null) {
            return false;
        }
        if (view == null || !(view instanceof TextureView)) {
            return this.surfaceCreated;
        }
        return this.surfaceCreated && ((SafeTextureView) this.mVideoView).isAvailable();
    }

    public void isTimeViewVisible(boolean z16) {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeMessages(25);
            Handler handler2 = this.mHandler;
            handler2.sendMessage(handler2.obtainMessage(25, Boolean.valueOf(z16)));
        }
    }

    public boolean isUse360VideoRender() {
        return isCurrentPlay360Video() && isSupport360();
    }

    public boolean isVideoCoverNotNull() {
        return this.mVideoCover != null;
    }

    public void jumpToVideoTab() {
        FeedVideoEnv.externalFunc.sendEvent(52);
    }

    protected void layoutVideoView() {
        setViewVisibility(this.mVideoView, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void measureCover(int i3, int i16) {
        if (isBaseVideoCoverWrapperNotNull() && this.mVideoCoverWrapper.getParentView().getVisibility() != 8) {
            this.mVideoCoverWrapper.getParentView().measure(i3, i16);
        } else if (isVideoCoverNotNull() && this.mVideoCover.getVisibility() != 8) {
            this.mVideoCover.measure(i3, i16);
        }
        DescTextView descTextView = this.mHudView;
        if (descTextView != null && descTextView.getVisibility() != 8) {
            DescTextView descTextView2 = this.mHudView;
            descTextView2.measure(ViewGroup.getChildMeasureSpec(i3, 0, descTextView2.getLayoutParams().width), ViewGroup.getChildMeasureSpec(i16, 0, this.mHudView.getLayoutParams().height));
        }
        DescTextView descTextView3 = this.mTimeview;
        if (descTextView3 != null && descTextView3.getVisibility() != 8) {
            this.mTimeview.measure(View.MeasureSpec.makeMeasureSpec(FeedVideoEnv.getNumberCharWidth() * 13, 1073741824), View.MeasureSpec.makeMeasureSpec(FeedVideoEnv.dp32, 1073741824));
        }
        DescTextView descTextView4 = this.mPlayCountView;
        if (descTextView4 != null && descTextView4.getVisibility() != 8) {
            this.mPlayCountView.measure(ViewGroup.getChildMeasureSpec(i3, 0, -2), View.MeasureSpec.makeMeasureSpec(FeedVideoEnv.dp24, 1073741824));
        }
        SoundLines soundLines = this.mSoundLinesLayout;
        if (soundLines != null && soundLines.getVisibility() != 8) {
            this.mSoundLinesLayout.measure(View.MeasureSpec.makeMeasureSpec(FeedVideoEnv.dp22, 1073741824), View.MeasureSpec.makeMeasureSpec(FeedVideoEnv.dp22, 1073741824));
        }
        DescTextView descTextView5 = this.mErrorView;
        if (descTextView5 != null && descTextView5.getVisibility() != 8) {
            this.mErrorView.measure(View.MeasureSpec.makeMeasureSpec(getVideoCoverWidth() - FeedVideoEnv.dp20, 1073741824), View.MeasureSpec.makeMeasureSpec(-2, 1073741824));
        }
        LinearLayout linearLayout = this.validTimeLayout;
        if (linearLayout != null && linearLayout.getVisibility() != 8) {
            this.validTimeLayout.measure(View.MeasureSpec.makeMeasureSpec(-2, 1073741824), View.MeasureSpec.makeMeasureSpec(FeedVideoEnv.dp32, 1073741824));
        }
        LinearLayout linearLayout2 = this.lightTipLayout;
        if (linearLayout2 != null && linearLayout2.getVisibility() != 8) {
            this.lightTipLayout.measure(i3, View.MeasureSpec.makeMeasureSpec(-2, 1073741824));
        }
        RelativeLayout relativeLayout = this.bottomShadow;
        if (relativeLayout != null) {
            relativeLayout.getVisibility();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void measureLiveEndAnim(int i3, int i16) {
        FrameLayout frameLayout = this.mLiveEndAnimContainer;
        if (frameLayout != null) {
            frameLayout.measure(View.MeasureSpec.makeMeasureSpec(i3, 1073741824), View.MeasureSpec.makeMeasureSpec(i16, 1073741824));
        }
    }

    protected void measureLiveStatIcon(int i3, int i16) {
        ImageView imageView = this.mLiveStatIcon;
        if (imageView != null) {
            imageView.measure(View.MeasureSpec.makeMeasureSpec(this.mLiveStatIconWidth, 1073741824), i16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void measureVideoView(int i3, int i16) {
        int childMeasureSpec;
        int childMeasureSpec2;
        View view = this.mVideoView;
        if (view == null || view.getVisibility() == 8) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        if (marginLayoutParams == null) {
            PlayerUtils.log(5, this.LOG_TAG, "measureVideoView: lp == null!!! Abort measure!");
            return;
        }
        int i17 = marginLayoutParams.width;
        if (i17 == -1) {
            childMeasureSpec = View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin, 1073741824);
        } else {
            childMeasureSpec = ViewGroup.getChildMeasureSpec(i3, marginLayoutParams.leftMargin + marginLayoutParams.rightMargin, i17);
        }
        int i18 = marginLayoutParams.height;
        if (i18 == -1) {
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - marginLayoutParams.topMargin) - marginLayoutParams.bottomMargin, 1073741824);
        } else {
            childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i16, marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, i18);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    public boolean needShowLightTip() {
        long j3;
        ArrayList<SegmentVideoInfo.SegmentInfo> arrayList;
        VideoPlayInfo videoPlayInfo = this.mVideoPlayInfo;
        if (videoPlayInfo == null || videoPlayInfo.segmentVideoInfo.getDefaultUrl() == null) {
            j3 = -1;
        } else {
            String defaultUrl = this.mVideoPlayInfo.segmentVideoInfo.getDefaultUrl();
            com.tencent.mobileqq.qzoneplayer.video.l h16 = s.g().h(this.mVideoPlayInfo.segmentVideoInfo.getDefaultUrl(), false);
            if (h16 != null && (arrayList = h16.f280002b) != null && arrayList.size() > 0) {
                defaultUrl = h16.f280002b.get(0).url;
            }
            j3 = VideoManager.getInstance().getUnCachedSize(defaultUrl);
            PlayerUtils.log(5, "zakiwang", "remainUnCachedBytes:" + j3);
        }
        return j3 == 0;
    }

    protected boolean needShowSoundLine() {
        return true;
    }

    public boolean needShowTimeView() {
        VideoPlayInfo videoPlayInfo = this.mVideoPlayInfo;
        return ((videoPlayInfo == null || !videoPlayInfo.k() || !this.mVideoPlayInfo.isAdvMicro) && !this.mShowCoverWarnType) && this.hasTimeview;
    }

    public void onAdvertiseMoreClicked() {
        com.tencent.mobileqq.qzoneplayer.video.g gVar = this.onFeedVideoElementClickListener;
        if (gVar == null) {
            return;
        }
        gVar.onClick(this.mVideoView, FeedVideoElement.AUTO_VIDEO_ADV_GET_MORE, this.feedPosition, this);
    }

    protected void onClickVideoEventProcess(View view) {
        View.OnClickListener onClickListener = this.mVideoClickListener;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    public void onGLTextureViewAvailable(int i3, int i16) {
        View view = this.mVideoView;
        if (view == null || !(view instanceof GLTextureView)) {
            return;
        }
        ((GLTextureView) view).g(i3, i16);
    }

    public void onGLTextureViewDestroy() {
        View view = this.mVideoView;
        if (view == null || !(view instanceof GLTextureView)) {
            return;
        }
        ((GLTextureView) view).i();
    }

    public void onGLTextureViewSizeChanged(int i3, int i16) {
        View view = this.mVideoView;
        if (view == null || !(view instanceof GLTextureView)) {
            return;
        }
        ((GLTextureView) view).h(i3, i16);
    }

    protected void onLongClickVideoEventProcess(View view) {
        View.OnLongClickListener onLongClickListener = this.mVideoLongClickListener;
        if (onLongClickListener != null) {
            onLongClickListener.onLongClick(view);
            performHapticFeedback(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i3, int i16) {
        measureCover(i3, i16);
        int videoCoverHeight = getVideoCoverHeight();
        VideoPlayInfo videoPlayInfo = this.mVideoPlayInfo;
        if (videoPlayInfo != null && !TextUtils.isEmpty(videoPlayInfo.getDisplayRemark()) && !this.mVideoPlayInfo.isInvalidState()) {
            getRemarkLayout().measure(View.MeasureSpec.makeMeasureSpec(getVideoCoverWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(FeedVideoEnv.REMARK_LAYOUT_HEIGHT, 1073741824));
            videoCoverHeight += FeedVideoEnv.REMARK_LAYOUT_HEIGHT;
        }
        measureVideoView(i3, i16);
        onSetMeasuredDimension(getVideoCoverWidth(), videoCoverHeight);
        measureLiveEndAnim(getVideoCoverWidth(), videoCoverHeight);
        measureLiveStatIcon(i3, i16);
    }

    public void onPause() {
        PlayerUtils.log(4, this.LOG_TAG, this + " onPause State=" + getState());
        setShowCoverImage(true);
        if (getState() != 4 && getState() != 8) {
            setState(1);
        }
        DescTextView descTextView = this.mErrorView;
        if (descTextView != null) {
            descTextView.setVisibility(8);
        }
        getBaseVideoManager().removeVideoView(this);
        setViewVisibility(this.mVideoView, 8);
        if (isBaseVideoCoverWrapperNotNull()) {
            setAutoVideoCover(this.mVideoPlayInfo);
            setViewVisibility(this.mVideoCoverWrapper.getCover(), 0);
        } else if (isVideoCoverNotNull()) {
            setAutoVideoCover(this.mVideoPlayInfo);
            setViewVisibility(this.mVideoCover, 0);
        }
        this.mHandler.removeMessages(17);
        this.mHandler.removeMessages(6);
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(8);
        PlayerUtils.log(4, this.LOG_TAG, this + "[onPause] mVideoView remove all message...");
    }

    public void onRecycled() {
        PlayerUtils.log(3, this.LOG_TAG, this + " onRecycled State=" + getState());
        if (getState() == 0) {
            return;
        }
        setState(0);
        VideoPlayerEventCenter.ConcreteSubject concreteSubject = this.mPlayStateSubject;
        if (concreteSubject != null) {
            concreteSubject.removeAllObservers();
        }
        this.hasLayout = false;
        getBaseVideoManager().removeVideoView(this);
        if (isBaseVideoCoverWrapperNotNull()) {
            this.mVideoCoverWrapper.onRecycled();
        } else if (isVideoCoverNotNull()) {
            this.mVideoCover.onRecycled();
        }
        View view = this.mVideoView;
        if (view != null) {
            setViewVisibility(view, 8);
            PlayerUtils.log(3, this.LOG_TAG, this + " mVideoView GONE position:3");
        }
        stopSoundLines();
        this.lastVideoSize = null;
        DescTextView descTextView = this.mHudView;
        if (descTextView != null) {
            setViewVisibility(descTextView, 8);
        }
        this.mRealVideoWidth = 0;
        this.mRealVideoHeight = 0;
        this.mHandler.removeMessages(22);
        PlayerUtils.log(3, this.LOG_TAG, "basevideodebug onRecycled this=" + toString());
    }

    public void onReplayClicked() {
        com.tencent.mobileqq.qzoneplayer.video.g gVar = this.onFeedVideoElementClickListener;
        if (gVar == null) {
            return;
        }
        gVar.onClick(this.mVideoView, FeedVideoElement.VIDEO_REPLAY, this.feedPosition, this.mVideoPlayInfo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onSetMeasuredDimension(int i3, int i16) {
        setMeasuredDimension(i3, i16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onSetVideoPlayInfo(VideoPlayInfo videoPlayInfo) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        PlayerUtils.log(4, this.LOG_TAG, "basevideodebug onSetVideoPlayInfo");
        try {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
        } catch (Exception e16) {
            PlayerUtils.log(5, this.LOG_TAG, PlayerUtils.getPrintableStackTrace(e16));
            marginLayoutParams = null;
        }
        if (marginLayoutParams == null) {
            marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
        }
        if (videoPlayInfo != null && !TextUtils.isEmpty(videoPlayInfo.getDisplayRemark())) {
            PlayerUtils.log(4, this.LOG_TAG, "basevideodebug getDisplayRemark");
            return;
        }
        if (FeedVideoEnv.externalFunc.isPicBigMode() && getVideoCoverWidth() >= FeedVideoEnv.getScreenWidth() - FeedVideoEnv.dp20) {
            PlayerUtils.log(4, this.LOG_TAG, "basevideodebug leftMargin set to 0");
            if (marginLayoutParams.leftMargin != 0) {
                marginLayoutParams.leftMargin = 0;
                setLayoutParams(marginLayoutParams);
                return;
            }
            return;
        }
        PlayerUtils.log(4, this.LOG_TAG, "basevideodebug isPicBigMode");
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
    }

    public void onTimeViewController(boolean z16) {
        DescTextView descTextView = this.mTimeview;
        if (descTextView != null) {
            if (z16 && this.hasTimeview) {
                descTextView.setVisibility(0);
            } else {
                descTextView.setVisibility(4);
            }
        }
        DescTextView descTextView2 = this.mPlayCountView;
        if (descTextView2 != null) {
            if (z16 && this.hasPlayCountView) {
                setViewVisibility(descTextView2, 0);
            } else {
                setViewVisibility(descTextView2, 4);
            }
        }
        SoundLines soundLines = this.mSoundLinesLayout;
        if (soundLines != null) {
            if (z16 && this.hasSoundLinesLayout) {
                setViewVisibility(soundLines, 0);
            } else {
                setViewVisibility(soundLines, 4);
            }
        }
    }

    protected boolean onTouch360VideoEventProcess(View view, MotionEvent motionEvent) {
        if (!isSupport360()) {
            return true;
        }
        View view2 = this.mVideoView;
        if (!(view2 instanceof GLTextureView) || !((GLTextureView) view2).e()) {
            return true;
        }
        ((GLTextureView) this.mVideoView).j(view, motionEvent);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean onTouchExt(View view, MotionEvent motionEvent) {
        if (getTouchDelegate() != null) {
            getTouchDelegate().onTouchEvent(motionEvent);
        }
        if (motionEvent.getAction() == 0) {
            this.mPreviousPosX = motionEvent.getX();
            this.mPreviousPoxY = motionEvent.getY();
            this.mIsPressed = true;
            this.mIsMoved = false;
            postDelayed(this.mLongPressRunnable, ViewConfiguration.getLongPressTimeout());
        } else if (motionEvent.getAction() != 1 && motionEvent.getAction() != 3) {
            if (motionEvent.getAction() == 2 && !this.mIsMoved && (Math.abs(motionEvent.getX() - this.mPreviousPosX) > FeedVideoEnv.dp5 || Math.abs(motionEvent.getY() - this.mPreviousPoxY) > FeedVideoEnv.dp5)) {
                removeCallbacks(this.mLongPressRunnable);
            }
        } else {
            removeCallbacks(this.mLongPressRunnable);
            if (this.mIsPressed && (Math.abs(motionEvent.getX() - this.mPreviousPosX) > FeedVideoEnv.dp5 || Math.abs(motionEvent.getY() - this.mPreviousPoxY) > FeedVideoEnv.dp5)) {
                this.mIsPressed = false;
            }
            if (this.mIsPressed) {
                this.mIsPressed = false;
                onClickVideoEventProcess(view);
            }
        }
        onTouch360VideoEventProcess(view, motionEvent);
        return true;
    }

    public void onVideoCoverBlankClicked() {
        VideoPlayInfo videoPlayInfo;
        com.tencent.mobileqq.qzoneplayer.video.g gVar = this.onFeedVideoElementClickListener;
        if (gVar == null || (videoPlayInfo = this.mVideoPlayInfo) == null) {
            return;
        }
        gVar.onClick(this.mVideoView, FeedVideoElement.VIDEO_COVER, this.feedPosition, videoPlayInfo);
    }

    public void playLiveEndAnim() {
        VideoPlayInfo videoPlayInfo = this.mVideoPlayInfo;
        if (videoPlayInfo == null || !videoPlayInfo.i()) {
            return;
        }
        Animation animation = this.alphaAnimation;
        if (animation == null) {
            this.alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        } else {
            animation.reset();
        }
        this.alphaAnimation.setDuration(this.alphaAnimationDuration * 1000);
        this.alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.tencent.mobileqq.qzoneplayer.video.BaseVideo.7
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation2) {
                PlayerUtils.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.qzoneplayer.video.BaseVideo.7.1
                    @Override // java.lang.Runnable
                    public void run() {
                        BaseVideo.this.hideLiveEndAnim();
                        if (BaseVideo.this.isBaseVideoCoverWrapperNotNull()) {
                            BaseVideo.this.mVideoCoverWrapper.setShowPlayIcon(true);
                        } else if (BaseVideo.this.isVideoCoverNotNull()) {
                            BaseVideo.this.mVideoCover.setShowPlayIcon(true);
                            BaseVideo.this.mVideoCover.postInvalidate();
                        }
                    }
                });
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation2) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation2) {
            }
        });
        if (this.mLiveEndAnimContainer == null || this.mLiveEndIV == null) {
            return;
        }
        if (isBaseVideoCoverWrapperNotNull()) {
            this.mVideoCoverWrapper.setShowPlayIcon(false);
        } else if (isVideoCoverNotNull()) {
            this.mVideoCover.setShowPlayIcon(false);
            this.mVideoCover.postInvalidate();
        }
        showLiveEndAnim();
        this.mLiveEndIV.startAnimation(this.alphaAnimation);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void playSoundLines() {
        getSoundLinesLayout();
        SoundLines soundLines = this.mSoundLinesLayout;
        if (soundLines == null || this.mSoundLinesPlayed) {
            return;
        }
        setViewVisibility(soundLines, 0);
        this.mSoundLinesLayout.startPlaySound();
        this.mSoundLinesPlayed = true;
        DescTextView descTextView = this.mTimeview;
        if (descTextView != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) descTextView.getLayoutParams();
            layoutParams.topMargin = getVideoCoverHeight() - FeedVideoEnv.dp20;
            layoutParams.rightMargin = FeedVideoEnv.dp22;
            this.mTimeview.setLayoutParams(layoutParams);
        }
    }

    public void preparedVideoView() {
        View view = this.mVideoView;
        if (view != null) {
            setViewVisibility(view, 0);
        } else {
            PlayerUtils.log(4, this.LOG_TAG, "preparedVideoView mVideoView is null");
        }
    }

    public void recommendComplete() {
        setState(PlayerConfig.g().getFloafVideoCompleteType());
        if (isBaseVideoCoverWrapperNotNull()) {
            this.mHandler.obtainMessage(24, this.mVideoCoverWrapper.getCover()).sendToTarget();
        } else if (isVideoCoverNotNull()) {
            this.mHandler.obtainMessage(24, this.mVideoCover).sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reconfigureSurface() {
        final View view = this.mVideoView;
        this.mVideoView = null;
        this.surfaceCreated = false;
        final int indexOfChild = indexOfChild(view);
        PlayerUtils.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.qzoneplayer.video.BaseVideo.22
            @Override // java.lang.Runnable
            public void run() {
                PlayerUtils.log(4, BaseVideo.this.LOG_TAG, "releaseSurface release old TextureView " + view);
                BaseVideo.this.removeView(view);
                BaseVideo.this.createSurface();
                BaseVideo baseVideo = BaseVideo.this;
                baseVideo.addView(baseVideo.mVideoView, indexOfChild);
                PlayerUtils.log(4, BaseVideo.this.LOG_TAG, "releaseSurface init new TextureView " + BaseVideo.this.mVideoView);
            }
        });
    }

    public void refreshHudText() {
        StringBuilder sb5 = new StringBuilder();
        Iterator<Map.Entry<p, String>> it = this.mHudTextMap.entrySet().iterator();
        while (it.hasNext()) {
            sb5.append(it.next().getValue());
            if (it.hasNext()) {
                sb5.append("\n");
            }
        }
        updateHudText(sb5.toString());
    }

    public void resetGLTextureView() {
        if (this.mVideoView == null || !isSupport360()) {
            return;
        }
        View view = this.mVideoView;
        if (view instanceof GLTextureView) {
            ((GLTextureView) view).k();
        }
    }

    public void resetTimeView() {
        if (getState() == 1 || getState() == 4 || getState() == 0) {
            getTimeview();
            if (this.mTimeview != null) {
                VideoPlayInfo videoPlayInfo = this.mVideoPlayInfo;
                if (videoPlayInfo != null && !TextUtils.isEmpty(videoPlayInfo.showVideoTime) && this.hasTimeview && !this.mVideoPlayInfo.isInvalidState()) {
                    if (this.mTimeview.getVisibility() != 0) {
                        this.mTimeview.setVisibility(0);
                    }
                    if (this.mTimeview.getCurrentTextColor() != -1) {
                        this.mTimeview.setTextColor(-1);
                    }
                    if (!this.mTimeview.getText().equals(this.mVideoPlayInfo.showVideoTime)) {
                        this.mTimeview.setText(this.mVideoPlayInfo.showVideoTime);
                    }
                } else {
                    this.mTimeview.setVisibility(8);
                }
            }
            if (this.mPlayCountView != null) {
                VideoPlayInfo videoPlayInfo2 = this.mVideoPlayInfo;
                String c16 = videoPlayInfo2 == null ? null : videoPlayInfo2.c();
                if (!TextUtils.isEmpty(c16) && this.hasPlayCountView) {
                    if (!this.mPlayCountView.getText().equals(c16)) {
                        this.mPlayCountView.setText(c16);
                    }
                    setViewVisibility(this.mPlayCountView, 0);
                } else {
                    setViewVisibility(this.mPlayCountView, 8);
                }
            }
            stopSoundLines();
        }
    }

    public void setFeedPos(int i3, int i16) {
        this.feedPosition = i3;
        this.mIndex = i16;
        if (!PlayerConfig.hasInit()) {
            vl2.b.a();
        }
        FeedResources feedResources = FeedVideoEnv.feedResources;
        if (feedResources != null) {
            try {
                setTag(feedResources.getViewId(584), Integer.valueOf(i16));
                return;
            } catch (IllegalArgumentException e16) {
                PlayerUtils.log(6, this.LOG_TAG, "failed to setTag:" + e16.toString());
                return;
            }
        }
        PlayerUtils.log(6, this.LOG_TAG, "FeedVideoEnv.feedResources is null");
    }

    public void setJustShowReplyIcon(boolean z16) {
        if (isBaseVideoCoverWrapperNotNull()) {
            this.mVideoCoverWrapper.setJustShowReplyIcon(z16);
        } else if (isVideoCoverNotNull()) {
            this.mVideoCover.setJustShowReplyIcon(z16);
        }
    }

    public void setLightTipTextWithAnimation(int i3) {
        LinearLayout linearLayout = this.lightTipLayout;
        if (linearLayout != null) {
            int measuredHeight = linearLayout.getMeasuredHeight();
            if (this.lightTipLayout.getVisibility() != i3) {
                if (i3 == 0) {
                    setViewVisibility(this.lightTipLayout, 0);
                    TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, -measuredHeight, 0.0f);
                    translateAnimation.setDuration(300L);
                    translateAnimation.setRepeatCount(0);
                    this.lightTipLayout.setAnimation(translateAnimation);
                    translateAnimation.start();
                    return;
                }
                if (i3 == 8) {
                    setViewVisibility(this.lightTipLayout, 8);
                    TranslateAnimation translateAnimation2 = new TranslateAnimation(0.0f, 0.0f, 0.0f, -measuredHeight);
                    translateAnimation2.setDuration(300L);
                    translateAnimation2.setRepeatCount(0);
                    this.lightTipLayout.setAnimation(translateAnimation2);
                    translateAnimation2.start();
                }
            }
        }
    }

    public void setMaxWidth(int i3) {
        if (isBaseVideoCoverWrapperNotNull()) {
            this.mVideoCoverWrapper.setMaxWidth(i3);
        } else if (isVideoCoverNotNull()) {
            this.mVideoCover.setMaxWidth(i3);
        }
    }

    public void setOnFeedVideoElementClickListener(com.tencent.mobileqq.qzoneplayer.video.g gVar) {
        this.onFeedVideoElementClickListener = gVar;
    }

    public void setOnFeedVideoElementLongClickListener(com.tencent.mobileqq.qzoneplayer.video.h hVar) {
        this.onFeedVideoElementLongClickListener = hVar;
    }

    public void setPlayScene(int i3) {
        this.mCurPlayScene = i3;
    }

    public void setRecordVideoId(String str) {
        this.mRecordVideoId = str;
    }

    public synchronized void setShowCoverImage(boolean z16) {
        this.showCoverImage = z16;
    }

    public void setShowCoverWarnType(boolean z16) {
        this.mShowCoverWarnType = z16;
    }

    @Deprecated
    public void setState(int i3) {
        int i16 = this.mState;
        this.mState = i3;
        switch (i3) {
            case 1:
                this.mPlayStateSubject.setState(1);
                break;
            case 2:
                this.mPlayStateSubject.setState(2);
                break;
            case 3:
                this.mPlayStateSubject.setState(10);
                break;
            case 4:
                this.mPlayStateSubject.setState(4);
                break;
            case 5:
                this.mPlayStateSubject.setState(5);
                break;
            case 6:
                this.mPlayStateSubject.setState(6);
                break;
            case 7:
                this.mPlayStateSubject.setState(7);
                break;
            case 8:
                this.mPlayStateSubject.setState(8);
                break;
            default:
                this.mPlayStateSubject.setState(9);
                break;
        }
        PlayerUtils.log(4, this.LOG_TAG, this + " setState " + i16 + "->" + i3);
    }

    public void setStreamInfo(SegmentVideoInfo.StreamInfo streamInfo, int i3) {
        SegmentVideoInfo segmentVideoInfo = getSegmentVideoInfo();
        if (segmentVideoInfo != null) {
            segmentVideoInfo.setStreamInfo(streamInfo, i3);
        }
    }

    public void setSurfaceTextureListener(OnSurfaceSizeChangedListener onSurfaceSizeChangedListener) {
        this.mOnSurfaceSizeChangedListener = new WeakReference<>(onSurfaceSizeChangedListener);
    }

    public void setValidTime(int i3) {
        this.validTime = i3;
    }

    public void setVideoPlayInfo(VideoPlayInfo videoPlayInfo) {
        int i3;
        int i16;
        int i17;
        int i18;
        if (getState() == 3) {
            PlayerUtils.log(5, this.LOG_TAG, this + " basevideodebug refuse to setvideoplayinfo while video is playing");
            return;
        }
        this.validTime = 0;
        this.mIsNeedHideCover = false;
        this.mIsSafeUrl = false;
        this.lastVideoSize = null;
        this.mHudViewIsHideManually = false;
        this.mIsVip = false;
        if (isBaseVideoCoverWrapperNotNull()) {
            this.mVideoCoverWrapper.setShowPlayIcon(true);
            this.mVideoCoverWrapper.reset();
            if (videoPlayInfo != null && (i18 = videoPlayInfo.coverMaxWidth) != 0) {
                this.mVideoCoverWrapper.setMaxWidth(i18);
            }
        } else if (isVideoCoverNotNull()) {
            this.mVideoCover.setShowPlayIcon(true);
            this.mVideoCover.reset();
            if (videoPlayInfo != null && (i3 = videoPlayInfo.coverMaxWidth) != 0) {
                this.mVideoCover.setMaxWidth(i3);
            }
        }
        if (videoPlayInfo == null) {
            setViewVisibility(this, 8);
            PlayerUtils.log(6, this.LOG_TAG, "basevideodebug Call BaseVideo setVideoPlayInfo:videoPlayInfo is null");
            return;
        }
        if (videoPlayInfo.videoTime == 0) {
            PlayerUtils.log(6, this.LOG_TAG, "basevideodebug setVideoPlayInfo totalDurationMills can not be 0");
        }
        PlayerUtils.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.qzoneplayer.video.BaseVideo.17
            @Override // java.lang.Runnable
            public void run() {
                BaseVideo.this.setBackground(null);
            }
        });
        setShowCoverImage(videoPlayInfo.showCoverImage);
        if (videoPlayInfo.coverUrl == null) {
            PlayerUtils.log(6, this.LOG_TAG, "Call BaseVideo setVideoPlayInfo:videoPlayInfo.coverUrl is null");
            videoPlayInfo.coverUrl = videoPlayInfo.currentUrl;
        }
        Map<Integer, SegmentVideoInfo.StreamInfo> b16 = vl2.a.a().b();
        if (b16 != null) {
            for (Map.Entry<Integer, SegmentVideoInfo.StreamInfo> entry : b16.entrySet()) {
                videoPlayInfo.segmentVideoInfo.setStreamInfo(entry.getValue(), entry.getKey().intValue());
            }
        }
        StringBuilder sb5 = new StringBuilder("basevideodebug setVideoPlayInfo hashcode=");
        sb5.append(hashCode());
        sb5.append(",videoTime=");
        sb5.append(videoPlayInfo.videoTime);
        sb5.append(",coverMaxWidth=");
        sb5.append(videoPlayInfo.coverMaxWidth);
        sb5.append(",showCoverImage=");
        sb5.append(videoPlayInfo.showCoverImage);
        sb5.append(",coverUrl=");
        sb5.append(getCoverUrlDetail(videoPlayInfo.coverUrl));
        try {
            sb5.append(",segmentVideoInfo=");
            sb5.append(videoPlayInfo.segmentVideoInfo.toString());
        } catch (Exception e16) {
            PlayerUtils.log(6, this.LOG_TAG, "segmentVideoInfo exception=" + PlayerUtils.getPrintableStackTrace(e16));
            sb5.append(",segmentVideoInfo=");
            sb5.append(e16.toString());
        }
        PlayerUtils.log(4, this.LOG_TAG, sb5.toString());
        PictureUrl pictureUrl = videoPlayInfo.coverUrl;
        if (pictureUrl != null && (i16 = pictureUrl.width) > 0 && (i17 = pictureUrl.height) > 0 && videoPlayInfo.width == 0 && videoPlayInfo.height == 0) {
            videoPlayInfo.width = i16;
            videoPlayInfo.height = i17;
        }
        setState(1);
        setAutoVideoCover(videoPlayInfo);
        this.mVideoSize = null;
        this.mVideoSize = new VideoSize(getVideoCoverWidth(), getVideoCoverHeight());
        SegmentVideoInfo segmentVideoInfo = videoPlayInfo.segmentVideoInfo;
        if (segmentVideoInfo != null && segmentVideoInfo.isValid() && !videoPlayInfo.isInvalidState()) {
            if (videoPlayInfo.coverUrl == null) {
                setViewVisibility(this, 8);
                PlayerUtils.log(6, this.LOG_TAG, "basevideodebug coverUrl is null");
                return;
            }
            if (BaseVideoManager.f279598j == null) {
                BaseVideoManager.f279598j = new HashSet<>();
            }
            if (videoPlayInfo.k() && BaseVideoManager.f279598j.contains(videoPlayInfo.feedKey)) {
                setState(4);
                videoPlayInfo.isFeedFirstComplete = true;
            }
            if (videoPlayInfo.k() && BaseVideoManager.f279599k.contains(videoPlayInfo.feedKey)) {
                videoPlayInfo.isFeedFirst = false;
            }
            this.mVideoPlayInfo = videoPlayInfo;
            this.mHttpRetryLogic = FeedVideoEnv.externalFunc.getHttpRetryLogic();
            if (this.mVideoPlayInfo.orgwebsite == 1) {
                hideValidTimeText();
                String realSegmentUrl = videoPlayInfo.segmentVideoInfo.getRealSegmentUrl(4, 0);
                if (TextUtils.isEmpty(realSegmentUrl)) {
                    realSegmentUrl = videoPlayInfo.segmentVideoInfo.getDefaultUrl();
                }
                String str = realSegmentUrl;
                this.mHttpRetryLogic = new TencentVideoHttpRetryLogic(str, videoPlayInfo.videoId, videoPlayInfo.videoPlayScene);
                if (s.g().j(str)) {
                    PlayerUtils.log(4, this.LOG_TAG, "safeUrlLockDebug request safe vid = " + videoPlayInfo.videoId + " , url = " + str);
                    FeedVideoEnv.externalFunc.getSafeurl(str, videoPlayInfo.videoId, null, videoPlayInfo.videoPlayScene, s.g());
                }
            }
            resetTimeView();
            onSetVideoPlayInfo(videoPlayInfo);
            DescTextView descTextView = this.mErrorView;
            if (descTextView != null) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) descTextView.getLayoutParams();
                layoutParams.topMargin = getVideoCoverHeight() / 2;
                layoutParams.gravity = 1;
                this.mErrorView.setLayoutParams(layoutParams);
            }
            setVideoView();
            if (!TextUtils.isEmpty(videoPlayInfo.getDisplayRemark())) {
                getRemarkLayout().setVisibility(0);
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) getRemarkLayout().getLayoutParams();
                if (layoutParams2 == null) {
                    FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, FeedVideoEnv.REMARK_LAYOUT_HEIGHT);
                    layoutParams3.gravity = 80;
                    getRemarkLayout().setLayoutParams(layoutParams3);
                } else {
                    layoutParams2.height = FeedVideoEnv.REMARK_LAYOUT_HEIGHT;
                    layoutParams2.width = -1;
                    layoutParams2.gravity = 80;
                    getRemarkLayout().setLayoutParams(layoutParams2);
                }
                DescTextView descTextView2 = this.remarkText;
                if (descTextView2 != null) {
                    descTextView2.setText(videoPlayInfo.getDisplayRemark());
                    this.remarkText.setContentDescription(videoPlayInfo.getDisplayRemark());
                }
            } else {
                RelativeLayout relativeLayout = this.remarkLayout;
                if (relativeLayout != null) {
                    relativeLayout.setVisibility(8);
                }
            }
            setLiveEndAnim(videoPlayInfo);
            setLiveStatIcon(videoPlayInfo);
            hideValidTimeText();
            setVisibility(0);
            this.hasLayout = false;
            requestLayout();
            View view = this.mVideoView;
            if (view != null) {
                view.getViewTreeObserver().addOnGlobalLayoutListener(new g());
            } else {
                this.hasLayout = true;
            }
            this.mRealVideoWidth = 0;
            this.mRealVideoHeight = 0;
            return;
        }
        this.mVideoPlayInfo = videoPlayInfo;
        hideValidTimeText();
        resetTimeView();
        RelativeLayout relativeLayout2 = this.remarkLayout;
        if (relativeLayout2 != null) {
            relativeLayout2.setVisibility(8);
        }
        PlayerUtils.log(6, this.LOG_TAG, "basevideodebug segmentVideoInfo is invalid");
        forceLayout();
    }

    protected void setVideoView() {
        if (!this.mHasAddVideoView) {
            addView(this.mVideoView, 0);
            this.mHasAddVideoView = true;
        }
        if (this.outSurfaceTexture != null) {
            reconfigureSurface();
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mVideoView.getLayoutParams();
        layoutParams.topMargin = 0;
        layoutParams.gravity = 1;
        this.mVideoView.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean shouldResponseToAudioFocusChange() {
        return true;
    }

    public void showRedpocket() {
        FeedVideoEnv.externalFunc.sendEvent(51);
    }

    public void showValidTimeText() {
        VideoPlayInfo videoPlayInfo = this.mVideoPlayInfo;
        if (videoPlayInfo != null && videoPlayInfo.orgwebsite == 1) {
            int i3 = this.validTime;
            if (i3 > 0) {
                int round = Math.round(i3 / 60.0f);
                getValidTimeLayout().setVisibility(0);
                DescTextView descTextView = this.validTimeText;
                if (descTextView != null) {
                    descTextView.setText("\u8bd5\u770b" + round + "\u5206\u949f");
                }
            }
            this.mHandler.sendMessageDelayed(Message.obtain(this.mHandler, 21), 3000L);
            return;
        }
        hideValidTimeText();
    }

    @Deprecated
    public void startLayout() {
        PlayerUtils.log(4, this.LOG_TAG, "startLayout -> state=" + getState() + ",hasLayout=" + this.hasLayout);
        if (getState() == 0 || this.hasLayout) {
            return;
        }
        layoutVideoView();
    }

    public void startLoadingLight(boolean z16) {
        setShowCoverImage(z16);
        startLoadingLight();
    }

    protected void stopSoundLines() {
        FrameLayout.LayoutParams layoutParams;
        getSoundLinesLayout();
        SoundLines soundLines = this.mSoundLinesLayout;
        if (soundLines != null) {
            setViewVisibility(soundLines, 8);
            this.mSoundLinesLayout.stopPlaySound();
            this.mSoundLinesPlayed = false;
            DescTextView descTextView = this.mTimeview;
            if (descTextView != null && (layoutParams = (FrameLayout.LayoutParams) descTextView.getLayoutParams()) != null) {
                layoutParams.topMargin = getVideoCoverHeight() - FeedVideoEnv.dp20;
                layoutParams.rightMargin = FeedVideoEnv.f279795dp3;
                this.mTimeview.setLayoutParams(layoutParams);
            }
            DescTextView descTextView2 = this.mPlayCountView;
            if (descTextView2 != null) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) descTextView2.getLayoutParams();
                layoutParams2.topMargin = getVideoCoverHeight() - FeedVideoEnv.dp24;
                layoutParams2.leftMargin = FeedVideoEnv.dp10;
                this.mPlayCountView.setLayoutParams(layoutParams2);
            }
            RelativeLayout relativeLayout = this.bottomShadow;
            if (relativeLayout != null) {
                FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) relativeLayout.getLayoutParams();
                layoutParams3.topMargin = getVideoCoverHeight() - FeedVideoEnv.dp34;
                layoutParams3.gravity = 53;
                this.bottomShadow.setLayoutParams(layoutParams3);
            }
        }
    }

    public void update() {
        PlayerUtils.log(4, this.LOG_TAG, this + "[update] remove start playing message.");
        setState(3);
        this.mHandler.removeMessages(3, this);
        this.mHandler.removeMessages(1);
        if (isBaseVideoCoverWrapperNotNull()) {
            Handler handler = this.mHandler;
            handler.sendMessage(handler.obtainMessage(1, this.mVideoCoverWrapper.getCover()));
            PlayerUtils.log(4, this.LOG_TAG, this + " update isBaseVideoCoverWrapperNotNull send MSG_START_PLAYING.");
            return;
        }
        if (isVideoCoverNotNull()) {
            Handler handler2 = this.mHandler;
            handler2.sendMessage(handler2.obtainMessage(1, this.mVideoCover));
            PlayerUtils.log(4, this.LOG_TAG, this + " update isVideoCoverNotNull send MSG_START_PLAYING.");
        }
    }

    public void updateHudText(int i3, String str, String str2, boolean z16) {
        if (TextUtils.isEmpty(str2)) {
            str2 = "-";
        }
        if (!TextUtils.isEmpty(str)) {
            str2 = str + ":" + str2;
        }
        if (TextUtils.isEmpty(str)) {
            str = "nosubject";
        }
        p pVar = new p(null);
        pVar.f279584d = i3;
        pVar.f279585e = str;
        this.mHudTextMap.put(pVar, str2);
        if (z16) {
            return;
        }
        refreshHudText();
    }

    public void videoUIPause(BaseVideoCover.CoverWarnType coverWarnType) {
        if (isBaseVideoCoverWrapperNotNull()) {
            this.mVideoCoverWrapper.setCoverWarnType(coverWarnType);
            if (coverWarnType != BaseVideoCover.CoverWarnType.DEFAULT) {
                setAutoVideoCover(this.mVideoPlayInfo);
                setViewVisibility(this.mVideoCoverWrapper.getCover(), 0);
                return;
            }
            return;
        }
        if (isVideoCoverNotNull()) {
            this.mVideoCover.mWarnType = coverWarnType;
            if (coverWarnType != BaseVideoCover.CoverWarnType.DEFAULT) {
                setAutoVideoCover(this.mVideoPlayInfo);
                setViewVisibility(this.mVideoCover, 0);
            }
        }
    }

    public void videoUIStop(int i3, int i16) {
        int state = getState();
        setState(i3);
        if (getState() == state) {
            return;
        }
        setShowCoverImage(true);
        this.mHandler.removeMessages(17);
        setViewVisibility(this.mVideoView, 8);
        PlayerUtils.log(4, this.LOG_TAG, this + " mVideoView GONE position:5");
        if (isBaseVideoCoverWrapperNotNull()) {
            this.mVideoCoverWrapper.setLoadFailedText(FeedVideoEnv.feedResources.getString(i16));
            setAutoVideoCover(this.mVideoPlayInfo);
            setViewVisibility(this.mVideoCoverWrapper.getCover(), 0);
        } else if (isVideoCoverNotNull()) {
            this.mVideoCover.loadFailedTextId = i16;
            setAutoVideoCover(this.mVideoPlayInfo);
            setViewVisibility(this.mVideoCover, 0);
        }
        DescTextView descTextView = this.mErrorView;
        if (descTextView != null) {
            setViewVisibility(descTextView, 8);
        }
        PlayerUtils.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.qzoneplayer.video.BaseVideo.2
            @Override // java.lang.Runnable
            public void run() {
                BaseVideo.this.stopSoundLines();
            }
        });
        PlayerUtils.log(4, this.LOG_TAG, "basevideodebug videoUIStop pos 1" + toString());
    }

    private void layoutSurfaceView(int i3) {
        this.mHandler.removeMessages(22);
        if (i3 > 0) {
            Handler handler = this.mHandler;
            handler.sendMessageDelayed(handler.obtainMessage(22, this.mVideoSize), i3);
        } else {
            Handler handler2 = this.mHandler;
            handler2.sendMessage(handler2.obtainMessage(22, this.mVideoSize));
        }
    }

    public void complete() {
        setState(4);
        this.mPlayStateSubject.setState(4);
        this.mHandler.obtainMessage(7, this.mVideoCover).sendToTarget();
    }

    int getState(BaseVideo baseVideo) {
        return baseVideo.getState();
    }

    public void hideTextViewAndSoundLinear() {
        this.hasTimeview = false;
        this.hasSoundLinesLayout = false;
        DescTextView descTextView = this.mTimeview;
        if (descTextView != null) {
            setViewVisibility(descTextView, 8);
        }
        SoundLines soundLines = this.mSoundLinesLayout;
        if (soundLines != null) {
            setViewVisibility(soundLines, 8);
        }
        this.mTimeview = null;
        this.mSoundLinesLayout = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isAllOnScreen() {
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        int i3 = iArr[1];
        return i3 >= FeedVideoEnv.DEFAULT_TITLEBAR_HEIGHT && i3 + getMeasuredHeight() < FeedVideoEnv.getScreenHeight();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isPartlyOnScreen() {
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        return iArr[1] + getMeasuredHeight() >= FeedVideoEnv.DEFAULT_TITLEBAR_HEIGHT && iArr[1] < FeedVideoEnv.getScreenHeight();
    }

    public void onPlayResumeClicked() {
        this.mShowCoverWarnType = false;
        PlayerUtils.log(4, this.LOG_TAG, "show cover warn type = " + this.mShowCoverWarnType);
        DescTextView descTextView = this.mTimeview;
        if (descTextView != null) {
            descTextView.setVisibility(0);
        }
        DescTextView descTextView2 = this.mPlayCountView;
        if (descTextView2 != null) {
            descTextView2.setVisibility(0);
        }
        SoundLines soundLines = this.mSoundLinesLayout;
        if (soundLines != null) {
            soundLines.setVisibility(0);
        }
    }

    public void setTimeMap(SegmentVideoInfo.StreamInfo streamInfo) {
        long j3;
        SegmentVideoInfo.SegmentInfo segment = streamInfo.getSegment(0);
        String str = segment != null ? segment.url : null;
        if (this.mVideoPlayInfo != null) {
            if (TextUtils.isEmpty(str)) {
                str = getSegmentVideoInfo().getDefaultUrl();
            }
            j3 = this.mVideoPlayInfo.validVideoTime;
        } else {
            j3 = 0;
        }
        com.tencent.mobileqq.qzoneplayer.videosource.b.b().f(str, j3);
        if (FeedVideoEnv.externalFunc.needForceVkeyOutDate()) {
            PlayerUtils.log(3, this.LOG_TAG, "force vkey out date...");
            makeVkeyOutDate(streamInfo);
        }
    }

    public void showLightTipTextWithAnimation() {
        setLightTipTextWithAnimation(0);
        this.mHandler.sendMessageDelayed(Message.obtain(this.mHandler, 32), 3000L);
    }

    public void showLightTipTimeText() {
        this.hasShowLightTip = true;
        initLightTipLayout(getMeasuredWidth());
        showLightTipTextWithAnimation();
    }

    public void startIndicatePause() {
        setShowCoverImage(false);
        setState(5);
        this.mHandler.removeMessages(8);
        Handler handler = this.mHandler;
        handler.sendMessageDelayed(handler.obtainMessage(8, this), 500L);
    }

    public void stop() {
        setState(1);
        this.mHandler.obtainMessage(2, this.mVideoCover).sendToTarget();
    }

    public void updateWithoutDelay(boolean z16) {
        setState(3);
        this.mHandler.removeMessages(3, this);
        int i3 = z16 ? 1 : 20;
        this.mHandler.removeMessages(20);
        this.mHandler.removeMessages(1);
        PlayerUtils.log(4, this.LOG_TAG, "updateWithoutDelay needDelay: " + z16);
        if (isBaseVideoCoverWrapperNotNull()) {
            Handler handler = this.mHandler;
            handler.sendMessage(handler.obtainMessage(i3, this.mVideoCoverWrapper.getCover()));
            PlayerUtils.log(4, this.LOG_TAG, "updateWithoutDelay isBaseVideoCoverWrapperNotNull msg: " + i3);
            return;
        }
        if (isVideoCoverNotNull()) {
            Handler handler2 = this.mHandler;
            handler2.sendMessage(handler2.obtainMessage(i3, this.mVideoCover));
            PlayerUtils.log(4, this.LOG_TAG, "updateWithoutDelay isVideoCoverNotNull msg: " + i3);
        }
    }

    private void setLiveEndAnim(VideoPlayInfo videoPlayInfo) {
        if (videoPlayInfo != null && videoPlayInfo.i()) {
            if (this.mLiveEndAnimContainer == null) {
                FrameLayout frameLayout = new FrameLayout(getContext());
                this.mLiveEndAnimContainer = frameLayout;
                frameLayout.setContentDescription("BaseVideo.mLiveEndAnimContainer");
                this.mLiveEndAnimContainer.setBackgroundColor(Color.argb(128, 0, 0, 0));
                addView(this.mLiveEndAnimContainer, new FrameLayout.LayoutParams(-1, -1));
                if (this.mLiveEndIV == null) {
                    ImageView imageView = new ImageView(getContext());
                    this.mLiveEndIV = imageView;
                    imageView.setContentDescription("BaseVideo.mLiveEndIV");
                    if (FeedVideoEnv.getLiveVideoEndAnimPicDrawable() != null) {
                        this.mLiveEndIV.setImageDrawable(FeedVideoEnv.getLiveVideoEndAnimPicDrawable());
                    }
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 17;
                    this.mLiveEndAnimContainer.addView(this.mLiveEndIV, layoutParams);
                }
            }
            hideLiveEndAnim();
            return;
        }
        hideLiveEndAnim();
    }

    public static void setViewVisibility(final View view, final int i3) {
        if (view == null || view.getVisibility() == i3) {
            return;
        }
        PlayerUtils.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.qzoneplayer.video.BaseVideo.20
            @Override // java.lang.Runnable
            public void run() {
                view.setVisibility(i3);
            }
        });
    }

    public boolean isPlayingTheSameVideo(VideoPlayInfo videoPlayInfo) {
        return videoPlayInfo != null && videoPlayInfo.equals(this.mVideoPlayInfo);
    }

    protected void setLiveStatIcon(VideoPlayInfo videoPlayInfo) {
        if (videoPlayInfo != null && videoPlayInfo.i()) {
            if (this.mLiveStatIcon == null) {
                addLiveStatIcon();
            }
            Drawable liveStatusDrawable = getLiveStatusDrawable(videoPlayInfo.liveVideoPreviewRoomState);
            if (liveStatusDrawable != null) {
                this.mLiveStatIconWidth = liveStatusDrawable.getIntrinsicWidth();
                this.mLiveStatIcon.setImageDrawable(liveStatusDrawable);
                return;
            }
            return;
        }
        ImageView imageView = this.mLiveStatIcon;
        if (imageView != null) {
            imageView.setImageDrawable(null);
        }
    }

    public void startLoadingLight() {
        setState(2);
        this.mHandler.removeMessages(3);
        Handler handler = this.mHandler;
        handler.sendMessageDelayed(handler.obtainMessage(3, this), 700L);
    }

    private Drawable getLiveStatusDrawable(int i3) {
        if (i3 == 1) {
            return FeedVideoEnv.getLiveVideoStatusLiveDrawable();
        }
        if (i3 == 2) {
            return FeedVideoEnv.getLiveVideoStatusEndDrawable();
        }
        if (i3 == 3) {
            return FeedVideoEnv.getLiveVideoStatusReplayDrawable();
        }
        return FeedVideoEnv.getLiveVideoStatusEndDrawable();
    }

    protected void setAutoVideoCover(VideoPlayInfo videoPlayInfo) {
        String str;
        if (videoPlayInfo == null) {
            return;
        }
        if (isBaseVideoCoverWrapperNotNull()) {
            if (!videoPlayInfo.f() && !videoPlayInfo.e()) {
                this.mVideoCoverWrapper.setPicInfoOnCoverThread(videoPlayInfo.coverUrl, null, videoPlayInfo);
            } else {
                this.mVideoCoverWrapper.setPicInfoOnCoverThread(videoPlayInfo.coverUrl, videoPlayInfo.showVideoTime, videoPlayInfo);
            }
            try {
                this.mVideoCoverWrapper.reportStoreIconToLp(BaseVideoCover.PLAY_ON_WIFI_REPORT_EXPOSE, Integer.parseInt(videoPlayInfo.videoPlayScene));
            } catch (Exception unused) {
                PlayerUtils.log(6, this.LOG_TAG, "videoPlayInfo.videoPlayScene = " + videoPlayInfo.videoPlayScene);
            }
            setViewVisibility(this.mVideoCoverWrapper.getCover(), 0);
            return;
        }
        if (isVideoCoverNotNull()) {
            if (!videoPlayInfo.f() && !videoPlayInfo.e()) {
                BaseVideoCover baseVideoCover = this.mVideoCover;
                if (baseVideoCover instanceof WindowPlayVideoCover) {
                    baseVideoCover.setPicInfo(videoPlayInfo.coverUrl, videoPlayInfo.showVideoTime, videoPlayInfo);
                } else {
                    baseVideoCover.setPicInfoOnCoverThread(videoPlayInfo.coverUrl, null, videoPlayInfo);
                }
            } else {
                BaseVideoCover baseVideoCover2 = this.mVideoCover;
                if (baseVideoCover2 instanceof WindowPlayVideoCover) {
                    baseVideoCover2.setPicInfo(videoPlayInfo.coverUrl, videoPlayInfo.showVideoTime, videoPlayInfo);
                } else {
                    baseVideoCover2.setPicInfoOnCoverThread(videoPlayInfo.coverUrl, videoPlayInfo.showVideoTime, videoPlayInfo);
                }
            }
            try {
                this.mVideoCover.reportStoreIconToLp(BaseVideoCover.PLAY_ON_WIFI_REPORT_EXPOSE, Integer.parseInt(videoPlayInfo.videoPlayScene));
            } catch (Exception unused2) {
                PlayerUtils.log(6, this.LOG_TAG, "videoPlayInfo.videoPlayScene = " + videoPlayInfo.videoPlayScene);
            }
            if (BaseVideoCover.sPlayOnWifiMap != null) {
                if (!TextUtils.isEmpty(videoPlayInfo.originCellId)) {
                    str = videoPlayInfo.originCellId;
                } else {
                    str = videoPlayInfo.cellId;
                }
                if (!TextUtils.isEmpty(str) && !BaseVideoCover.sPlayOnWifiMap.containsKey(str)) {
                    BaseVideoCover.sPlayOnWifiMap.put(str, Boolean.FALSE);
                }
            }
            setViewVisibility(this.mVideoCover, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onVideoSizeChanged(int i3, int i16) {
        if (i3 != 0 && i16 != 0) {
            this.mRealVideoWidth = i3;
            this.mRealVideoHeight = i16;
        }
        this.mVideoSize = new VideoSize(i3, i16);
        this.mHandler.removeMessages(33);
        this.mHandler.sendEmptyMessage(33);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void reLayoutSurfaceView(VideoSize videoSize) {
        int i3;
        if (this.mVideoView == null) {
            PlayerUtils.log(4, this.LOG_TAG, "mVideoView is null");
            return;
        }
        if (!this.hasLayout && this.mVideoView.getVisibility() == 0 && this.mVideoView.isShown()) {
            PlayerUtils.log(4, this.LOG_TAG, "no layoutyet");
            layoutSurfaceView(100);
            return;
        }
        if (videoSize == null) {
            PlayerUtils.log(4, this.LOG_TAG, "videoSize is null");
            return;
        }
        VideoSize videoSize2 = this.lastVideoSize;
        if (videoSize == videoSize2) {
            PlayerUtils.log(4, this.LOG_TAG, "videoSize is same object");
            return;
        }
        if (videoSize2 != null && videoSize2.videoNatureWidth == videoSize.videoNatureWidth && videoSize2.videoNatureHeight == videoSize.videoNatureHeight) {
            PlayerUtils.log(4, this.LOG_TAG, "no need to relayout");
            return;
        }
        int i16 = videoSize.videoNatureWidth;
        int i17 = videoSize.videoNatureHeight;
        if (i16 <= 0 || i17 <= 0) {
            return;
        }
        layoutVideoView();
        ViewGroup.LayoutParams layoutParams = this.mVideoView.getLayoutParams();
        int videoCoverWidth = getVideoCoverWidth();
        int videoCoverHeight = getVideoCoverHeight();
        if (layoutParams == null) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(videoCoverWidth, videoCoverHeight);
            ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin = 0;
            ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = 0;
            this.mVideoView.setLayoutParams(layoutParams2);
        } else if (videoCoverHeight != layoutParams.height || videoCoverWidth != layoutParams.width) {
            layoutParams.height = videoCoverHeight;
            layoutParams.width = videoCoverWidth;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.leftMargin = 0;
            marginLayoutParams.topMargin = 0;
            this.mVideoView.setLayoutParams(layoutParams);
        }
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        RelativeLayout relativeLayout = this.remarkLayout;
        if (relativeLayout != null && relativeLayout.getVisibility() == 0) {
            measuredHeight -= FeedVideoEnv.REMARK_LAYOUT_HEIGHT;
        }
        if (measuredWidth <= 0 || measuredHeight <= 0) {
            PlayerUtils.log(4, this.LOG_TAG, "mVideoView currW <= 0 || currH <= 0");
            return;
        }
        float f16 = i16 / i17;
        float f17 = measuredWidth / measuredHeight;
        if (Math.abs(f16 - f17) <= 0.1d) {
            PlayerUtils.log(4, this.LOG_TAG, "mVideoView not scale");
            return;
        }
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.mVideoView.getLayoutParams();
        if (layoutParams3 == null) {
            layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        }
        int backgroundColor = getBackgroundColor();
        if (f16 < f17) {
            layoutParams3.width = (i16 * measuredHeight) / i17;
            layoutParams3.height = measuredHeight;
            layoutParams3.gravity = 1;
            layoutParams3.topMargin = 0;
            PlayerUtils.log(4, this.LOG_TAG, "mVideoView width=" + layoutParams3.width + ",height=" + layoutParams3.height + ",gravity=CENTER_HORIZONTAL,topMargin=" + layoutParams3.topMargin);
            if (isSetBackgroundColor()) {
                setBackgroundColor(backgroundColor);
            }
        } else if (f16 > f17) {
            layoutParams3.width = measuredWidth;
            int i18 = (i17 * measuredWidth) / i16;
            layoutParams3.height = i18;
            layoutParams3.gravity = 1;
            layoutParams3.topMargin = (measuredHeight - i18) / 2;
            i3 = 4;
            PlayerUtils.log(4, this.LOG_TAG, "mVideoView width=" + layoutParams3.width + ",height=" + layoutParams3.height + ",gravity=CENTER_HORIZONTAL,topMargin=" + layoutParams3.topMargin);
            if (isSetBackgroundColor()) {
                setBackgroundColor(backgroundColor);
            }
            PlayerUtils.log(i3, this.LOG_TAG, "mVideoView updatelayout");
            this.lastVideoSize = videoSize;
            this.mVideoView.setLayoutParams(layoutParams3);
        }
        i3 = 4;
        PlayerUtils.log(i3, this.LOG_TAG, "mVideoView updatelayout");
        this.lastVideoSize = videoSize;
        this.mVideoView.setLayoutParams(layoutParams3);
    }

    private SegmentVideoInfo.StreamInfo getStreamInfo(int i3) {
        SegmentVideoInfo segmentVideoInfo = getSegmentVideoInfo();
        if (segmentVideoInfo == null) {
            return null;
        }
        return segmentVideoInfo.getStreamInfo(i3);
    }

    private void updateHudText(final String str) {
        if (this.mHudView == null || this.mHudViewIsHideManually || TextUtils.isEmpty(str) || !FeedVideoEnv.externalFunc.isDebugVersion()) {
            return;
        }
        PlayerUtils.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.qzoneplayer.video.BaseVideo.9
            @Override // java.lang.Runnable
            public void run() {
                BaseVideo baseVideo = BaseVideo.this;
                if (baseVideo.mHudView == null) {
                    PlayerUtils.log(5, baseVideo.LOG_TAG, "[updateHudText] mHudView is null");
                    return;
                }
                if (baseVideo.getLeft() < 0) {
                    BaseVideo.this.mHudView.setTranslationX(-r0);
                }
                BaseVideo baseVideo2 = BaseVideo.this;
                baseVideo2.mHudView.setWidth(baseVideo2.getWidth());
                int height = BaseVideo.this.getHeight();
                int height2 = BaseVideo.this.mHudView.getHeight();
                if (height2 > height) {
                    PlayerUtils.log(5, BaseVideo.this.LOG_TAG, "[updateHudText] height=" + height2 + ", parentHeight=" + height);
                    BaseVideo baseVideo3 = BaseVideo.this;
                    baseVideo3.mHudView.setHeight(baseVideo3.getHeight());
                }
                if (BaseVideo.this.mHudView.getVisibility() != 0) {
                    BaseVideo.setViewVisibility(BaseVideo.this.mHudView, 0);
                }
                BaseVideo.this.mHudView.setText(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class h implements Animation.AnimationListener {
        h() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            BaseVideo.this.validTimeLayout.setVisibility(8);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public void videoUIStop() {
        int state = getState();
        setState(1);
        if (getState() == state) {
            return;
        }
        setShowCoverImage(true);
        this.mHandler.removeMessages(17);
        setViewVisibility(this.mVideoView, 8);
        PlayerUtils.log(4, this.LOG_TAG, this + " mVideoView GONE position:6");
        if (isBaseVideoCoverWrapperNotNull()) {
            setAutoVideoCover(this.mVideoPlayInfo);
            setViewVisibility(this.mVideoCoverWrapper.getCover(), 0);
        } else if (isVideoCoverNotNull()) {
            setAutoVideoCover(this.mVideoPlayInfo);
            setViewVisibility(this.mVideoCover, 0);
        }
        DescTextView descTextView = this.mErrorView;
        if (descTextView != null) {
            setViewVisibility(descTextView, 8);
        }
        PlayerUtils.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.qzoneplayer.video.BaseVideo.3
            @Override // java.lang.Runnable
            public void run() {
                BaseVideo.this.stopSoundLines();
            }
        });
        PlayerUtils.log(4, this.LOG_TAG, "basevideodebug videoUIStop pos 2" + toString());
    }

    public void currentPlayState(VideoPlayInfo videoPlayInfo) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onReceivedMessage(Message message) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onVideoBufferingUpdate(int i3) {
    }

    protected void onVideoClick() {
    }

    public BaseVideo(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.LOG_TAG = "BaseVideo";
        this.mState = 0;
        this.hasTimeview = true;
        this.hasPlayCountView = true;
        this.hasSoundTipLayout = true;
        this.hasSoundLinesLayout = true;
        this.showCoverImage = true;
        this.mIsNeedHideCover = false;
        this.mShowCoverWarnType = false;
        this.eventIsHandled = true;
        this.mIsSupport360 = false;
        this.alphaAnimationDuration = 3;
        this.mPlayStateSubject = new VideoPlayerEventCenter.ConcreteSubject();
        this.mRealVideoWidth = 0;
        this.mRealVideoHeight = 0;
        this.mHudTextMap = new TreeMap<>();
        this.mHandler = new i(Looper.getMainLooper());
        this.mVideoClickListener = new l();
        this.mTouchMoved = false;
        this.mIsPressed = false;
        this.mIsMoved = false;
        this.mVideoLongClickListener = new m();
        this.mHudViewIsHideManually = false;
        this.mLongPressRunnable = new Runnable() { // from class: com.tencent.mobileqq.qzoneplayer.video.BaseVideo.12
            @Override // java.lang.Runnable
            public void run() {
                BaseVideo.this.mIsPressed = false;
                BaseVideo baseVideo = BaseVideo.this;
                baseVideo.onLongClickVideoEventProcess(baseVideo);
            }
        };
        this.mVideoPlayInfoListenerWrapper = new k();
        this.mVideoPlayInfoListener = null;
        initChildView();
        setContentDescription(this.LOG_TAG);
    }

    public void setVideoOriginalSize(int i3, int i16) {
    }

    public BaseVideo(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.LOG_TAG = "BaseVideo";
        this.mState = 0;
        this.hasTimeview = true;
        this.hasPlayCountView = true;
        this.hasSoundTipLayout = true;
        this.hasSoundLinesLayout = true;
        this.showCoverImage = true;
        this.mIsNeedHideCover = false;
        this.mShowCoverWarnType = false;
        this.eventIsHandled = true;
        this.mIsSupport360 = false;
        this.alphaAnimationDuration = 3;
        this.mPlayStateSubject = new VideoPlayerEventCenter.ConcreteSubject();
        this.mRealVideoWidth = 0;
        this.mRealVideoHeight = 0;
        this.mHudTextMap = new TreeMap<>();
        this.mHandler = new i(Looper.getMainLooper());
        this.mVideoClickListener = new l();
        this.mTouchMoved = false;
        this.mIsPressed = false;
        this.mIsMoved = false;
        this.mVideoLongClickListener = new m();
        this.mHudViewIsHideManually = false;
        this.mLongPressRunnable = new Runnable() { // from class: com.tencent.mobileqq.qzoneplayer.video.BaseVideo.12
            @Override // java.lang.Runnable
            public void run() {
                BaseVideo.this.mIsPressed = false;
                BaseVideo baseVideo = BaseVideo.this;
                baseVideo.onLongClickVideoEventProcess(baseVideo);
            }
        };
        this.mVideoPlayInfoListenerWrapper = new k();
        this.mVideoPlayInfoListener = null;
        initChildView();
        setContentDescription(this.LOG_TAG);
    }
}
