package com.tencent.mobileqq.gamecenter.media;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor;
import com.tencent.ecommerce.base.runtime.api.IECScreenReceiver;
import com.tencent.hippy.qq.api.IHippyAccessHelper;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.apollo.game.api.ICmGameHelper;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gamecenter.api.IGameCenterVideoReportApi;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData;
import com.tencent.mobileqq.gamecenter.view.VideoLoadingImage;
import com.tencent.mobileqq.kandian.base.utils.api.IReadInJoyDisplayUtils;
import com.tencent.mobileqq.qqgamepub.api.IQQGameConfigUtil;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHelper;
import com.tencent.mobileqq.qqvideoplatform.api.PlatformInfo;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerOption;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.view.ISPlayerVideoView;
import com.tencent.superplayer.view.SPlayerVideoView;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes12.dex */
public class GameCenterVideoViewController extends FrameLayout implements Handler.Callback, View.OnClickListener, SeekBar.OnSeekBarChangeListener {
    private static final long DELAY_2S = 2000;
    private static final String FILE_PROTOCOL_HEADER = "file://";
    public static final String GRAY_MASK = "#33000000";
    public static final int MSG_TYPE_AUTO_PLAY = 13;
    public static final int MSG_TYPE_ENTER_FULLSCREEN = 8;
    public static final int MSG_TYPE_EXIT_FULLSCREEN = 9;
    public static final int MSG_TYPE_HIDE_CONTROL_PANLE = 2;
    public static final int MSG_TYPE_INITAL_VIDEO = 6;
    public static final int MSG_TYPE_PRELOAD = 20;
    public static final int MSG_TYPE_SET_XYAXIS = 18;
    public static final int MSG_TYPE_SHOW_CONTROL_PANLE = 1;
    public static final int MSG_TYPE_SHOW_DANMAKU_SWITCH = 17;
    public static final int MSG_TYPE_SHOW_FIRST_FRAME = 19;
    public static final int MSG_TYPE_SHOW_FLOAT_WINDOW = 14;
    public static final int MSG_TYPE_SHOW_FULLSCREEN = 12;
    public static final int MSG_TYPE_SHOW_OUT_LAYER_INFO = 7;
    public static final int MSG_TYPE_SHOW_PLAY = 16;
    public static final int MSG_TYPE_SHOW_PROGRESS = 15;
    public static final int MSG_TYPE_SHOW_VOLUME = 11;
    public static final int MSG_TYPE_UPDATE_PANEL = 4;
    public static final int MSG_TYPE_UPDATE_SEEKBAR = 3;
    public static final int MSG_TYPE_UPDATE_VIDEO_PROGRESS = 5;
    public static final int MSG_TYPE_UPDATE_VOLUME = 10;
    public static final int SRC_GAME_CENTER = 1;
    public static final int SRC_PUB_ACCOUT = 2;
    public static final int STYLE_DEFAULT = 0;
    public static final int STYLE_NEW = 1;
    public static final int STYLE_NORMAL = 2;
    public static final int STYLE_RESIDENT_PROGRESS = 3;
    public static final String TAG = "GameCenterVideoViewController";
    public static final String UPDATE_PANEL_SCENE_CLICK_TWO_PAUSE = "clickTwoPause";
    public static int sPlayCount;
    public boolean isFromSeekComplete;
    private ImageView mAudioBtn;
    private ImageView mAudioBtnResident;
    private RelativeLayout mControlPanel;
    private RelativeLayout mControlPanelResident;
    protected View mCoverContainer;
    private TextView mCoverDuration;
    private URLImageView mCoverImage;
    private AtomicInteger mCurrentStatus;
    private DanmakuLayout mDanmakuLayout;
    private CheckBox mDanmakuSwitch;
    private int mDanmakuSwitchStyle;
    private FeedsItemData mData;
    private boolean mEnableAudio;
    private boolean mEnableFullScreen;
    private boolean mEnablePlayNoneNet;
    private boolean mEnableProgress;
    private boolean mEnableShowErrorToast;
    private ImageView mFullScreenBtn;
    private ViewGroup mFullScreenContainer;
    private d mIPlayerListener;
    private boolean mIStartTrackingTouch;
    private boolean mInterceptSurfaceTextureDestroyed;
    private boolean mIsAutoPlay;
    private boolean mIsFirstFrameShowed;
    private boolean mIsFromPreload;
    private boolean mIsFullScreen;
    private boolean mIsLandscapeWhenFullScreen;
    private boolean mIsMute;
    private boolean mIsScreenOff;
    private long mLastPlayTimestamp;
    private AtomicInteger mLastStatus;
    private VideoLoadingImage mLoadingButton;
    private int mLoadingStyle;
    private boolean mNeedReport;
    private ViewGroup.LayoutParams mOldlp;
    private e mOnDanmakuChangeListener;
    private f mOnProgressChangeListener;
    private g mOnSeekListener;
    private URLImageView mOperateButton;
    private ViewGroup mParentView;
    private int mPlayBtnVisibility;
    private long mPlayTime;
    private int mPlayingClickCount;
    private TextView mProgressTime;
    private RFWPlayerBaseInterceptor mReportInterceptor;
    private SeekBar mResidentVideoSeek;
    private FrameLayout mRootView;
    private BroadcastReceiver mScreenReceiver;
    private float mSpeedRatio;
    private int mSrc;
    private h mStatusListener;
    private TextView mTvDurationProgressTimeResident;
    private TextView mTvDurationResident;
    protected Handler mUiHandler;
    private FrameLayout mVideoContainer;
    private TextView mVideoDuration;
    private int mVideoDurationValue;
    private int mVideoId;
    private ISuperPlayer mVideoPlayer;
    private SeekBar mVideoSeek;
    private View mVideoView;
    private int mXYaxis;
    private final Set<String> openedSet;
    private int progressMax;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (QLog.isColorLevel()) {
                QLog.d(GameCenterVideoViewController.TAG, 2, "[action]:" + action + ",status:" + GameCenterVideoViewController.this.mCurrentStatus.get());
            }
            if (GameCenterVideoViewController.this.mVideoPlayer == null) {
                return;
            }
            if (IECScreenReceiver.ACTION_SCREEN_ON.equals(action)) {
                GameCenterVideoViewController.this.mIsScreenOff = false;
            }
            if (IECScreenReceiver.ACTION_SCREEN_OFF.equals(action)) {
                GameCenterVideoViewController.this.mIsScreenOff = true;
                if (GameCenterVideoViewController.this.mCurrentStatus.get() == 3) {
                    GameCenterVideoViewController.this.pause();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b implements com.tencent.mobileqq.gamecenter.media.b {
        b() {
        }

        @Override // com.tencent.mobileqq.gamecenter.media.b
        public long getTime() {
            return GameCenterVideoViewController.this.getCurrentPostion();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class c implements CompoundButton.OnCheckedChangeListener {
        c() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            GameCenterVideoViewController.this.mDanmakuLayout.setShown(z16);
            if (GameCenterVideoViewController.this.mOnDanmakuChangeListener != null) {
                GameCenterVideoViewController.this.mOnDanmakuChangeListener.a(z16, GameCenterVideoViewController.this.mVideoId);
            }
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class d implements ISuperPlayer.OnVideoPreparedListener, ISuperPlayer.OnCompletionListener, ISuperPlayer.OnInfoListener, ISuperPlayer.OnErrorListener, ISuperPlayer.OnSeekCompleteListener {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<GameCenterVideoViewController> f212193d;

        public d(GameCenterVideoViewController gameCenterVideoViewController) {
            this.f212193d = new WeakReference<>(gameCenterVideoViewController);
        }

        private GameCenterVideoViewController a() {
            WeakReference<GameCenterVideoViewController> weakReference = this.f212193d;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }

        @Override // com.tencent.superplayer.api.ISuperPlayer.OnCompletionListener
        public void onCompletion(ISuperPlayer iSuperPlayer) {
            GameCenterVideoViewController a16 = a();
            if (a16 == null) {
                return;
            }
            a16.onCompletion(iSuperPlayer);
        }

        @Override // com.tencent.superplayer.api.ISuperPlayer.OnErrorListener
        public boolean onError(ISuperPlayer iSuperPlayer, int i3, int i16, int i17, String str) {
            GameCenterVideoViewController a16 = a();
            if (a16 == null) {
                return false;
            }
            return a16.onError(iSuperPlayer, i3, i16, i17, str);
        }

        @Override // com.tencent.superplayer.api.ISuperPlayer.OnInfoListener
        public boolean onInfo(ISuperPlayer iSuperPlayer, int i3, long j3, long j16, Object obj) {
            GameCenterVideoViewController a16 = a();
            if (a16 == null) {
                return false;
            }
            return a16.onInfo(iSuperPlayer, i3, j3, j16, obj);
        }

        @Override // com.tencent.superplayer.api.ISuperPlayer.OnSeekCompleteListener
        public void onSeekComplete(ISuperPlayer iSuperPlayer) {
            GameCenterVideoViewController a16 = a();
            if (a16 == null) {
                return;
            }
            a16.onSeekComplete(iSuperPlayer);
        }

        @Override // com.tencent.superplayer.api.ISuperPlayer.OnVideoPreparedListener
        public void onVideoPrepared(ISuperPlayer iSuperPlayer) {
            GameCenterVideoViewController a16 = a();
            if (a16 == null) {
                return;
            }
            a16.onVideoPrepared(iSuperPlayer);
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface e {
        void a(boolean z16, int i3);
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface f {
        void onProgressChanged(int i3, int i16);
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface g {
        void a(int i3, int i16);
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface h {
        void onAudioMute(boolean z16, int i3, boolean z17);

        void onSrceenModeChanged(boolean z16, int i3);

        void onVideoStatusChanged(int i3, int i16);
    }

    public GameCenterVideoViewController(@NonNull Context context) {
        super(context);
        this.openedSet = new HashSet();
        this.mUiHandler = new Handler(Looper.getMainLooper(), this);
        this.mCurrentStatus = new AtomicInteger(0);
        this.mLastStatus = new AtomicInteger(0);
        this.mXYaxis = 0;
        this.mIsFullScreen = false;
        this.mNeedReport = false;
        this.mIsMute = false;
        this.mSpeedRatio = 1.0f;
        this.mIsAutoPlay = false;
        this.mEnableFullScreen = false;
        this.mEnableAudio = false;
        this.mEnableProgress = true;
        this.mEnableShowErrorToast = false;
        this.mPlayBtnVisibility = 0;
        this.mVideoId = 0;
        this.mPlayTime = 0L;
        this.mLastPlayTimestamp = 0L;
        this.mLoadingStyle = 1;
        this.mIsLandscapeWhenFullScreen = true;
        this.mIsFirstFrameShowed = false;
        this.mIsFromPreload = false;
        this.mEnablePlayNoneNet = false;
        this.mIStartTrackingTouch = false;
        this.mPlayingClickCount = 0;
        this.mIsScreenOff = false;
        this.mInterceptSurfaceTextureDestroyed = false;
        this.mScreenReceiver = new a();
        initView();
    }

    private void checkView(View view) {
        if (view != null && view.getParent() != null && view.getVisibility() == 0) {
            if (view.getWidth() == 0 || view.getHeight() == 0 || view.getWidth() > getWidth() || view.getHeight() > getHeight()) {
                onViewChanged((View) view.getParent());
            }
        }
    }

    @androidx.annotation.NonNull
    private SuperPlayerVideoInfo createVideoInfo() {
        if (TextUtils.isEmpty(this.mData.videoUrl)) {
            return SuperPlayerFactory.createVideoInfoForTVideo(PlatformInfo.ID_QQGAME, this.mData.videoVid);
        }
        FeedsItemData feedsItemData = this.mData;
        if (feedsItemData.type == 1) {
            return SuperPlayerFactory.createVideoInfoForUrl(feedsItemData.videoUrl, 201, "");
        }
        String offlineResPath = ((IHippyAccessHelper) QRoute.api(IHippyAccessHelper.class)).getOfflineResPath(this.mData.videoUrl);
        if (TextUtils.isEmpty(offlineResPath)) {
            return SuperPlayerFactory.createVideoInfoForUrl(this.mData.videoUrl, 104, "");
        }
        return SuperPlayerFactory.createVideoInfoForUrl(this.mData.videoUrl, 104, "", offlineResPath);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doOnVideoPrepared() {
        start();
        if (this.mSrc == 2) {
            int i3 = sPlayCount + 1;
            sPlayCount = i3;
            if (i3 >= 3 && ((IQQGameConfigUtil) QRoute.api(IQQGameConfigUtil.class)).canShowFloatWindow(this.mData.gameInfo.gameAppId)) {
                sPlayCount = 0;
                this.mUiHandler.sendEmptyMessageDelayed(14, 30000 - this.mPlayTime);
            }
        }
        int durationMs = (int) this.mVideoPlayer.getDurationMs();
        this.progressMax = durationMs;
        if (isResidentProgressStyle()) {
            this.mResidentVideoSeek.setMax(this.progressMax);
            this.mTvDurationResident.setText(((IReadInJoyDisplayUtils) QRoute.api(IReadInJoyDisplayUtils.class)).getDisplayDuration(durationMs / 1000));
        } else {
            this.mVideoSeek.setMax(this.progressMax);
            this.mVideoDuration.setText(((IReadInJoyDisplayUtils) QRoute.api(IReadInJoyDisplayUtils.class)).getDisplayDuration(durationMs / 1000));
        }
        updateControlPanle();
        postUpdateProgress(0L);
        hideControlPanel();
    }

    private String getCoverImageUrl() {
        FeedsItemData feedsItemData = this.mData;
        if (feedsItemData != null && !TextUtils.isEmpty(feedsItemData.coverImgUrl)) {
            String offlineResPath = ((IHippyAccessHelper) QRoute.api(IHippyAccessHelper.class)).getOfflineResPath(this.mData.coverImgUrl);
            if (TextUtils.isEmpty(offlineResPath)) {
                return this.mData.coverImgUrl;
            }
            return FILE_PROTOCOL_HEADER + offlineResPath;
        }
        return null;
    }

    private int getPlayerStatus() {
        ISuperPlayer iSuperPlayer = this.mVideoPlayer;
        if (iSuperPlayer != null) {
            return iSuperPlayer.getCurrentPlayerState();
        }
        return 0;
    }

    private String getUrlForURLImageView(URLImageView uRLImageView) {
        if (uRLImageView == null) {
            return null;
        }
        Drawable drawable = uRLImageView.getDrawable();
        if (!(drawable instanceof URLDrawable)) {
            return null;
        }
        URLDrawable uRLDrawable = (URLDrawable) drawable;
        if (uRLDrawable.getURL() == null) {
            return null;
        }
        return uRLDrawable.getURL().toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getVideoKey() {
        return getVideoKey(this.mData);
    }

    private void handleOperateClick() {
        if (this.mCurrentStatus.get() == 0) {
            if (this.mNeedReport && !this.mIsAutoPlay) {
                HashMap hashMap = new HashMap();
                hl0.a.a(hashMap, this.mData.msgId);
                hashMap.put(2, this.mData.msgId);
                hashMap.put(6, this.mData.feedId);
                hashMap.put(4, "20");
                hashMap.put(43, this.mData.algorithmId);
                hashMap.put(44, this.mData.type + "");
                hl0.a.c(((ICmGameHelper) QRoute.api(ICmGameHelper.class)).getAppInterface(), "769", "205023", this.mData.gameInfo.gameAppId, "76902", "1", "160", hashMap);
            }
            saveCurrentVideoPlayer();
            this.mOperateButton.setVisibility(8);
            this.mLoadingButton.setVisibility(0);
            play();
            return;
        }
        if (this.mCurrentStatus.get() == 3) {
            if (this.mNeedReport) {
                HashMap hashMap2 = new HashMap();
                hl0.a.a(hashMap2, this.mData.msgId);
                hashMap2.put(2, this.mData.msgId);
                hashMap2.put(6, this.mData.feedId);
                hashMap2.put(4, "20");
                hashMap2.put(42, getCurrentPostion() + "");
                hashMap2.put(43, this.mData.algorithmId);
                hashMap2.put(44, this.mData.type + "");
                hl0.a.c(((ICmGameHelper) QRoute.api(ICmGameHelper.class)).getAppInterface(), "769", "205034", this.mData.gameInfo.gameAppId, "76902", "1", "160", hashMap2);
            }
            if (isResidentProgressStyle()) {
                this.mPlayingClickCount++;
                if (isPlayingClickCountOnce()) {
                    updateControlPanel(UPDATE_PANEL_SCENE_CLICK_TWO_PAUSE);
                    ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.media.d
                        @Override // java.lang.Runnable
                        public final void run() {
                            GameCenterVideoViewController.this.lambda$handleOperateClick$2();
                        }
                    }, 2000L);
                    return;
                }
            }
            this.mPlayingClickCount = 0;
            pause();
            return;
        }
        if (this.mCurrentStatus.get() == 5) {
            if (this.mNeedReport) {
                HashMap hashMap3 = new HashMap();
                hl0.a.a(hashMap3, this.mData.msgId);
                hashMap3.put(2, this.mData.msgId);
                hashMap3.put(6, this.mData.feedId);
                hashMap3.put(4, "20");
                hashMap3.put(42, getCurrentPostion() + "");
                hashMap3.put(43, this.mData.algorithmId);
                hashMap3.put(44, this.mData.type + "");
                hl0.a.c(((ICmGameHelper) QRoute.api(ICmGameHelper.class)).getAppInterface(), "769", "205034", this.mData.gameInfo.gameAppId, "76902", "1", "160", hashMap3);
            }
            showFloatWindow();
            start();
        }
    }

    private void handleResidentTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1 || action == 3) {
                this.mResidentVideoSeek.getParent().requestDisallowInterceptTouchEvent(false);
                return;
            }
            return;
        }
        this.mResidentVideoSeek.getParent().requestDisallowInterceptTouchEvent(true);
        this.mTvDurationResident.setVisibility(0);
    }

    private void handleVideoEvent(int i3) {
        if (this.mSrc == 2) {
            if (i3 != 5 && i3 != 7 && i3 != 0) {
                if (i3 == 3) {
                    ((IQQGameHelper) QRoute.api(IQQGameHelper.class)).dispatchVideoEvent(6);
                    return;
                }
                return;
            }
            ((IQQGameHelper) QRoute.api(IQQGameHelper.class)).dispatchVideoEvent(5);
        }
    }

    private void hideNormalProgressView() {
        this.mProgressTime.setVisibility(8);
        this.mVideoSeek.setVisibility(8);
        this.mVideoDuration.setVisibility(8);
    }

    private void hideResidentProgressView() {
        this.mTvDurationResident.setVisibility(8);
        this.mResidentVideoSeek.setVisibility(8);
        this.mTvDurationProgressTimeResident.setVisibility(8);
    }

    private void initSdkReady() {
        boolean isSDKReady = QQVideoPlaySDKManager.isSDKReady();
        boolean isSoLoadSucess = QQVideoPlaySDKManager.isSoLoadSucess();
        if (!isSDKReady || !isSoLoadSucess) {
            QQVideoPlaySDKManager.initSDKAsync(BaseApplication.getContext(), null);
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "initSdkReady,isSdkReady:" + isSDKReady + ",isSoLoadSuc:" + isSoLoadSucess);
        }
    }

    private void initView() {
        initSdkReady();
        FrameLayout frameLayout = (FrameLayout) ((FrameLayout) LayoutInflater.from(getContext()).inflate(R.layout.f167995og, this)).findViewById(R.id.kti);
        this.mRootView = frameLayout;
        this.mVideoContainer = (FrameLayout) frameLayout.findViewById(R.id.f167092kq3);
        this.mControlPanel = (RelativeLayout) this.mRootView.findViewById(R.id.enm);
        this.mControlPanelResident = (RelativeLayout) this.mRootView.findViewById(R.id.yxy);
        this.mOperateButton = (URLImageView) this.mRootView.findViewById(R.id.fet);
        this.mLoadingButton = (VideoLoadingImage) this.mRootView.findViewById(R.id.f163827k);
        this.mProgressTime = (TextView) this.mRootView.findViewById(R.id.g2a);
        this.mVideoDuration = (TextView) this.mRootView.findViewById(R.id.bqq);
        this.mVideoSeek = (SeekBar) this.mRootView.findViewById(R.id.dmb);
        this.mResidentVideoSeek = (SeekBar) this.mRootView.findViewById(R.id.f81894fe);
        this.mTvDurationResident = (TextView) this.mRootView.findViewById(R.id.f107606av);
        this.mTvDurationProgressTimeResident = (TextView) this.mRootView.findViewById(R.id.f107596au);
        this.mAudioBtn = (ImageView) this.mRootView.findViewById(R.id.kvk);
        this.mAudioBtnResident = (ImageView) this.mRootView.findViewById(R.id.y_n);
        this.mFullScreenBtn = (ImageView) this.mRootView.findViewById(R.id.f165307cq3);
        this.mCoverContainer = this.mRootView.findViewById(R.id.f164919bb0);
        this.mCoverDuration = (TextView) this.mRootView.findViewById(R.id.bqo);
        this.mCoverImage = (URLImageView) this.mRootView.findViewById(R.id.f164921bb4);
        this.mRootView.setOnClickListener(this);
        this.mOperateButton.setOnClickListener(this);
        this.mVideoSeek.setOnSeekBarChangeListener(this);
        this.mResidentVideoSeek.setOnSeekBarChangeListener(this);
        this.mResidentVideoSeek.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.gamecenter.media.f
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean lambda$initView$0;
                lambda$initView$0 = GameCenterVideoViewController.this.lambda$initView$0(view, motionEvent);
                return lambda$initView$0;
            }
        });
        this.mAudioBtn.setOnClickListener(this);
        this.mAudioBtnResident.setOnClickListener(this);
        this.mFullScreenBtn.setOnClickListener(this);
        this.mIPlayerListener = new d(this);
        DanmakuLayout danmakuLayout = (DanmakuLayout) this.mRootView.findViewById(R.id.a3x);
        this.mDanmakuLayout = danmakuLayout;
        danmakuLayout.setTimeSupplier(new b(), 150L);
        CheckBox checkBox = (CheckBox) this.mRootView.findViewById(R.id.ude);
        this.mDanmakuSwitch = checkBox;
        checkBox.setOnCheckedChangeListener(new c());
    }

    private boolean isResidentProgressStyle() {
        if (this.mLoadingStyle == 3) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleOperateClick$2() {
        if (isPlayingClickCountOnce()) {
            this.mPlayingClickCount = 0;
            updateControlPanel(UPDATE_PANEL_SCENE_CLICK_TWO_PAUSE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$initView$0(View view, MotionEvent motionEvent) {
        handleResidentTouchEvent(motionEvent);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onClick$1() {
        showResidentDurationAndMask(false);
    }

    private void onPlayerInfoBufferingEnd() {
        RFWPlayerBaseInterceptor rFWPlayerBaseInterceptor = this.mReportInterceptor;
        if (rFWPlayerBaseInterceptor != null) {
            rFWPlayerBaseInterceptor.onPlayerInfoBufferingEnd();
        }
    }

    private void onPlayerInfoBufferingStart() {
        RFWPlayerBaseInterceptor rFWPlayerBaseInterceptor = this.mReportInterceptor;
        if (rFWPlayerBaseInterceptor != null) {
            rFWPlayerBaseInterceptor.onPlayerInfoBufferingStart();
        }
    }

    private void onPlayerInfoCurrentLoopEnd() {
        RFWPlayerBaseInterceptor rFWPlayerBaseInterceptor = this.mReportInterceptor;
        if (rFWPlayerBaseInterceptor != null) {
            rFWPlayerBaseInterceptor.onPlayerInfoCurrentLoopEnd();
        }
    }

    private void onPlayerInfoFirstVideoFrameRendered() {
        RFWPlayerBaseInterceptor rFWPlayerBaseInterceptor = this.mReportInterceptor;
        if (rFWPlayerBaseInterceptor != null) {
            rFWPlayerBaseInterceptor.onPlayerInfoFirstVideoFrameRendered();
        }
        this.mIsFirstFrameShowed = true;
        this.mUiHandler.sendEmptyMessage(19);
    }

    private void postUpdateProgress(long j3) {
        FeedsItemData feedsItemData = this.mData;
        if (feedsItemData.type == 2 || feedsItemData.videoDuration > 0) {
            this.mUiHandler.removeMessages(5);
            if (getParent() != null) {
                this.mUiHandler.sendEmptyMessageDelayed(5, j3);
            }
        }
    }

    private void registerScreenStatusRec() {
        try {
            QLog.i(TAG, 1, "[registerScreenStatusRec]");
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(IECScreenReceiver.ACTION_SCREEN_ON);
            intentFilter.addAction(IECScreenReceiver.ACTION_SCREEN_OFF);
            BaseApplication.getContext().registerReceiver(this.mScreenReceiver, intentFilter);
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
        }
    }

    private void removeAllURLImageCache() {
        removeURLImageCache(this.mCoverImage);
        removeURLImageCache(this.mOperateButton);
        this.mCoverImage.setImageDrawable(null);
        this.mOperateButton.setImageDrawable(null);
    }

    private void removeURLImageCache(URLImageView uRLImageView) {
        String urlForURLImageView = getUrlForURLImageView(uRLImageView);
        if (!TextUtils.isEmpty(urlForURLImageView)) {
            URLDrawable.removeMemoryCacheByUrl(urlForURLImageView, URLDrawable.URLDrawableOptions.obtain());
        }
    }

    private void resetCoverImageUrl() {
        String coverImageUrl = getCoverImageUrl();
        if (TextUtils.isEmpty(coverImageUrl)) {
            removeURLImageCache(this.mCoverImage);
            this.mCoverImage.setImageDrawable(null);
            this.mCoverImage.setVisibility(8);
            return;
        }
        String urlForURLImageView = getUrlForURLImageView(this.mCoverImage);
        if (urlForURLImageView != null && !urlForURLImageView.equals(coverImageUrl)) {
            removeURLImageCache(this.mCoverImage);
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        Drawable drawable = com.tencent.mobileqq.urldrawable.b.f306350a;
        obtain.mLoadingDrawable = drawable;
        obtain.mFailedDrawable = drawable;
        this.mCoverImage.setImageDrawable(URLDrawable.getDrawable(coverImageUrl, obtain));
        this.mCoverImage.setVisibility(0);
    }

    private void saveCurrentVideoPlayer() {
        FeedsItemData feedsItemData = this.mData;
        if (feedsItemData != null && feedsItemData.independentPlayer) {
            return;
        }
        com.tencent.mobileqq.gamecenter.media.c.b().d(this);
    }

    private void setProgressVisibility(int i3) {
        QLog.i(TAG, 2, "[setProgressVisibility] visibility:" + i3 + ",mLoadingStyle:" + this.mLoadingStyle);
        if (isResidentProgressStyle()) {
            this.mTvDurationResident.setVisibility(i3);
            this.mResidentVideoSeek.setVisibility(i3);
            this.mTvDurationProgressTimeResident.setVisibility(i3);
            hideNormalProgressView();
            return;
        }
        this.mProgressTime.setVisibility(i3);
        this.mVideoSeek.setVisibility(i3);
        this.mVideoDuration.setVisibility(i3);
        hideResidentProgressView();
    }

    private void showFloatWindow() {
        if (this.mSrc == 2 && sPlayCount == 0) {
            this.mUiHandler.removeMessages(14);
            this.mUiHandler.sendEmptyMessageDelayed(14, 30000 - this.mPlayTime);
        }
    }

    private void showResidentDurationAndMask(boolean z16) {
        int i3;
        TextView textView = this.mTvDurationResident;
        int i16 = 0;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        textView.setVisibility(i3);
        RelativeLayout relativeLayout = this.mControlPanelResident;
        if (z16) {
            i16 = Color.parseColor(GRAY_MASK);
        }
        relativeLayout.setBackgroundColor(i16);
    }

    private void stopWhenNoUsePreloadOrVideoChange(FeedsItemData feedsItemData, boolean z16) {
        String videoKey = getVideoKey();
        String videoKey2 = getVideoKey(feedsItemData);
        if (z16 && !TextUtils.isEmpty(videoKey) && videoKey.equals(videoKey2)) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "[stopWhenNoUsePreloadOrVideoChange] video is the same,curState:" + this.mCurrentStatus.get() + ",curVideoKey:" + videoKey2.hashCode());
                return;
            }
            return;
        }
        stop();
        try {
            this.openedSet.remove(videoKey);
            View view = this.mVideoView;
            if (view != null && this.mVideoContainer == view.getParent()) {
                this.mVideoContainer.removeView(this.mVideoView);
                this.mVideoView = null;
            }
        } catch (Exception unused) {
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "[stopWhenNoUsePreloadOrVideoChange] videoKey change,curState:" + this.mCurrentStatus.get() + ",lastVideoKey:" + videoKey.hashCode() + ",curVideoKey:" + videoKey2.hashCode());
        }
    }

    private void unRegisterScreenStatusRec() {
        try {
            QLog.i(TAG, 1, "[unRegisterScreenStatusRec]");
            BaseApplication.getContext().unregisterReceiver(this.mScreenReceiver);
        } catch (IllegalArgumentException e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
        }
    }

    private void updateOperateButton(boolean z16) {
        if (this.mLoadingStyle == 0) {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            if (z16) {
                obtain.mLoadingDrawable = getResources().getDrawable(R.drawable.duf);
                obtain.mFailedDrawable = getResources().getDrawable(R.drawable.duf);
                this.mOperateButton.setImageDrawable(URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/gameCenter/gameCenter_video_play@2x.png", obtain));
                return;
            }
            obtain.mLoadingDrawable = getResources().getDrawable(R.drawable.due);
            obtain.mFailedDrawable = getResources().getDrawable(R.drawable.due);
            this.mOperateButton.setImageDrawable(URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/gameCenter/gameCenter_video_stop@2x.png", obtain));
            return;
        }
        if (isResidentProgressStyle()) {
            this.mControlPanelResident.setBackgroundColor(0);
            this.mTvDurationResident.setVisibility(8);
            if (z16) {
                this.mOperateButton.setImageResource(R.drawable.mxg);
                return;
            } else if (isPlayingClickCountOnce()) {
                this.mOperateButton.setImageResource(R.drawable.mxf);
                showResidentDurationAndMask(true);
                return;
            } else {
                this.mOperateButton.setImageResource(0);
                return;
            }
        }
        if (z16) {
            this.mOperateButton.setImageResource(R.drawable.mre);
        } else {
            this.mOperateButton.setImageResource(R.drawable.mrd);
        }
    }

    @SuppressLint({"SetTextI18n"})
    private void updateResidentDurationProgressView(int i3) {
        long duration = getDuration();
        if (duration > 0) {
            String displayDuration = ((IReadInJoyDisplayUtils) QRoute.api(IReadInJoyDisplayUtils.class)).getDisplayDuration(i3 / 1000);
            String displayDuration2 = ((IReadInJoyDisplayUtils) QRoute.api(IReadInJoyDisplayUtils.class)).getDisplayDuration((int) (duration / 1000));
            this.mTvDurationProgressTimeResident.setText(displayDuration + " / " + displayDuration2);
            this.mTvDurationProgressTimeResident.setVisibility(0);
            showResidentDurationAndMask(true);
            return;
        }
        this.mTvDurationProgressTimeResident.setVisibility(8);
    }

    private void updateVideoProgress(int i3) {
        QLog.i(TAG, 2, "[updateVideoProgress] mIStartTrackingTouch:" + this.mIStartTrackingTouch + ",milliSeconds:" + i3);
        if (isResidentProgressStyle()) {
            if (!this.mIStartTrackingTouch) {
                this.mResidentVideoSeek.setProgress(i3);
            }
        } else {
            this.mVideoSeek.setProgress(i3);
            this.mProgressTime.setText(((IReadInJoyDisplayUtils) QRoute.api(IReadInJoyDisplayUtils.class)).getDisplayDuration(i3 / 1000));
        }
        postUpdateProgress(1000 - (i3 % 1000));
    }

    public void autoPlay() {
        this.mUiHandler.removeMessages(13);
        this.mUiHandler.sendEmptyMessage(13);
    }

    public void checkAndPlay() {
        if (NetworkUtil.isNetworkAvailable(getContext()) && NetworkUtil.isWifiConnected(getContext())) {
            this.mIsAutoPlay = true;
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            int height = getHeight();
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            if (iArr[1] > BaseAIOUtils.f(50.0f, getResources()) && iArr[1] + height < ((height + displayMetrics.heightPixels) / 2) + BaseAIOUtils.f(50.0f, getResources()) && this.mCurrentStatus.get() == 0) {
                this.mUiHandler.removeMessages(13);
                this.mUiHandler.sendEmptyMessage(13);
                setMute(com.tencent.mobileqq.qqgamepub.data.b.f264501a);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "[checkAndPlay] network err or not wifi,auto play failed.");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public View createVideoView() {
        QLog.d(TAG, 4, "[createVideoPlayer]");
        if (!QQVideoPlaySDKManager.isSDKReady()) {
            QLog.w(TAG, 1, "sdk NOT installed.");
            return null;
        }
        ISPlayerVideoView createPlayerVideoView = SuperPlayerFactory.createPlayerVideoView(BaseApplication.getContext());
        if (createPlayerVideoView.getRenderView() instanceof TextureView) {
            ((TextureView) createPlayerVideoView.getRenderView()).setOpaque(false);
        }
        ISuperPlayer iSuperPlayer = this.mVideoPlayer;
        ISuperPlayer createMediaPlayer = SuperPlayerFactory.createMediaPlayer(BaseApplication.getContext(), 106, createPlayerVideoView);
        this.mVideoPlayer = createMediaPlayer;
        if (createMediaPlayer == null) {
            QLog.e(TAG, 1, "[createVideoView] create media player fail.");
            return null;
        }
        createMediaPlayer.setOnCompletionListener(this.mIPlayerListener);
        this.mVideoPlayer.setOnVideoPreparedListener(this.mIPlayerListener);
        this.mVideoPlayer.setOnErrorListener(this.mIPlayerListener);
        this.mVideoPlayer.setOnSeekCompleteListener(this.mIPlayerListener);
        this.mVideoPlayer.setOnInfoListener(this.mIPlayerListener);
        onPlayerCreated(this.mVideoPlayer);
        registerScreenStatusRec();
        if (iSuperPlayer != null && iSuperPlayer != this.mVideoPlayer) {
            RFWPlayerBaseInterceptor rFWPlayerBaseInterceptor = this.mReportInterceptor;
            if (rFWPlayerBaseInterceptor != null) {
                rFWPlayerBaseInterceptor.onRelease(0);
            }
            iSuperPlayer.stop();
            iSuperPlayer.release();
        }
        if (((IGameCenterVideoReportApi) QRoute.api(IGameCenterVideoReportApi.class)).getHippyReportInterceptor(this.mData.videoUrl) instanceof RFWPlayerBaseInterceptor) {
            this.mReportInterceptor = (RFWPlayerBaseInterceptor) ((IGameCenterVideoReportApi) QRoute.api(IGameCenterVideoReportApi.class)).getHippyReportInterceptor(this.mData.videoUrl);
        }
        return (View) createPlayerVideoView;
    }

    public void destroy() {
        FeedsItemData feedsItemData = this.mData;
        if (feedsItemData != null) {
            feedsItemData.coverImgUrl = "";
        }
        removeAllURLImageCache();
        release();
    }

    public void enableFullScreenSwitch() {
        this.mEnableFullScreen = true;
        this.mUiHandler.sendEmptyMessage(12);
    }

    public void enableReport() {
        this.mNeedReport = true;
    }

    public void enableVolumeSwitch() {
        this.mEnableAudio = true;
        this.mUiHandler.sendEmptyMessage(11);
    }

    public void enterFullScreen() {
        QLog.d(TAG, 4, "enterFullScreen");
        this.mUiHandler.removeMessages(8);
        this.mUiHandler.sendEmptyMessageDelayed(8, 300L);
        this.mStatusListener.onSrceenModeChanged(true, this.mVideoId);
    }

    public void exitFullScreen() {
        QLog.d(TAG, 4, "exitFullScreen");
        this.mUiHandler.removeMessages(9);
        this.mUiHandler.sendEmptyMessageDelayed(9, 300L);
        this.mStatusListener.onSrceenModeChanged(false, this.mVideoId);
    }

    public long getCurrentPostion() {
        QLog.d(TAG, 4, "---> getCurrentPostion");
        ISuperPlayer iSuperPlayer = this.mVideoPlayer;
        if (iSuperPlayer == null) {
            return 0L;
        }
        return iSuperPlayer.getCurrentPositionMs();
    }

    public int getCurrentStatus() {
        return this.mCurrentStatus.get();
    }

    public DanmakuLayout getDanmakuLayout() {
        return this.mDanmakuLayout;
    }

    public long getDuration() {
        ISuperPlayer iSuperPlayer = this.mVideoPlayer;
        if (iSuperPlayer == null) {
            return 0L;
        }
        return iSuperPlayer.getDurationMs();
    }

    public boolean getOutputMute() {
        ISuperPlayer iSuperPlayer = this.mVideoPlayer;
        if (iSuperPlayer != null) {
            return iSuperPlayer.isOutputMute();
        }
        return false;
    }

    public int getVideoId() {
        return this.mVideoId;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x0410, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean handleMessage(Message message) {
        int i3 = 8;
        switch (message.what) {
            case 1:
                if (isResidentProgressStyle()) {
                    if (this.mEnableAudio) {
                        this.mAudioBtnResident.setVisibility(0);
                        checkView(this.mAudioBtnResident);
                        break;
                    }
                } else {
                    if (this.mCurrentStatus.get() != 0) {
                        RelativeLayout relativeLayout = this.mControlPanel;
                        if (this.mEnableFullScreen || this.mEnableAudio || this.mEnableProgress || this.mPlayBtnVisibility == 0) {
                            i3 = 0;
                        }
                        relativeLayout.setVisibility(i3);
                        checkView(this.mControlPanel);
                        FeedsItemData feedsItemData = this.mData;
                        if (feedsItemData.type == 1 && feedsItemData.videoDuration == 0) {
                            setProgressVisibility(4);
                        }
                        if (this.mEnableAudio) {
                            this.mAudioBtn.setVisibility(0);
                            checkView(this.mAudioBtn);
                        }
                        if (this.mEnableFullScreen) {
                            this.mFullScreenBtn.setVisibility(0);
                            checkView(this.mFullScreenBtn);
                        }
                    }
                    this.mOperateButton.setVisibility(this.mPlayBtnVisibility);
                    hideControlPanel();
                    break;
                }
                break;
            case 2:
                if (this.mCurrentStatus.get() != 5) {
                    this.mControlPanel.setVisibility(8);
                    if (this.mCurrentStatus.get() != 0) {
                        this.mOperateButton.setVisibility(8);
                        this.mLoadingButton.setVisibility(8);
                        break;
                    }
                }
                break;
            case 4:
                if (this.mCurrentStatus.get() == 3) {
                    this.mOperateButton.setVisibility(this.mPlayBtnVisibility);
                    this.mLoadingButton.setVisibility(8);
                    updateOperateButton(false);
                    showControlPanel();
                    if (this.mIsFirstFrameShowed) {
                        this.mCoverContainer.setVisibility(8);
                        break;
                    }
                } else if (this.mCurrentStatus.get() == 0) {
                    this.mOperateButton.setVisibility(this.mPlayBtnVisibility);
                    this.mLoadingButton.setVisibility(8);
                    updateOperateButton(true);
                    this.mCoverContainer.setVisibility(0);
                    resetCoverImageUrl();
                    this.mControlPanel.setVisibility(8);
                    this.mProgressTime.setText(((IReadInJoyDisplayUtils) QRoute.api(IReadInJoyDisplayUtils.class)).getDisplayDuration(0));
                    String displayDuration = ((IReadInJoyDisplayUtils) QRoute.api(IReadInJoyDisplayUtils.class)).getDisplayDuration(this.mData.videoDuration);
                    this.mVideoDuration.setText(displayDuration);
                    if (this.mData.videoDuration == 0) {
                        this.mCoverDuration.setText("");
                        break;
                    } else {
                        this.mCoverDuration.setText(displayDuration);
                        break;
                    }
                } else if (this.mCurrentStatus.get() == 5) {
                    this.mOperateButton.setVisibility(this.mPlayBtnVisibility);
                    this.mLoadingButton.setVisibility(8);
                    updateOperateButton(true);
                    break;
                } else {
                    this.mOperateButton.setVisibility(this.mPlayBtnVisibility);
                    this.mLoadingButton.setVisibility(8);
                    updateOperateButton(false);
                    break;
                }
                break;
            case 5:
                updateVideoProgress((int) this.mVideoPlayer.getCurrentPositionMs());
                break;
            case 8:
                if (!this.mIsFullScreen && scanForActivity(getContext()) != null) {
                    if (this.mParentView == null) {
                        this.mParentView = (ViewGroup) getParent();
                        this.mFullScreenContainer = (ViewGroup) scanForActivity(getContext()).findViewById(android.R.id.content);
                    }
                    scanForActivity(getContext()).getWindow().setFlags(1024, 1024);
                    this.mOldlp = getLayoutParams();
                    this.mParentView.removeView(this);
                    if (this.mIsLandscapeWhenFullScreen) {
                        scanForActivity(getContext()).setRequestedOrientation(0);
                    }
                    this.mFullScreenContainer.addView(this, new FrameLayout.LayoutParams(-1, -1));
                    this.mVideoPlayer.setXYaxis(0);
                    this.mFullScreenBtn.setImageResource(R.drawable.mxe);
                    this.mIsFullScreen = true;
                    saveCurrentVideoPlayer();
                    break;
                }
                break;
            case 9:
                if (this.mIsFullScreen && scanForActivity(getContext()) != null) {
                    this.mFullScreenContainer.removeView(this);
                    this.mParentView.addView(this, this.mOldlp);
                    scanForActivity(getContext()).getWindow().clearFlags(1024);
                    this.mVideoPlayer.setXYaxis(0);
                    if (this.mIsLandscapeWhenFullScreen && getResources().getConfiguration().orientation != 1) {
                        scanForActivity(getContext()).setRequestedOrientation(1);
                    }
                    this.mFullScreenBtn.setImageResource(R.drawable.mxd);
                    this.mIsFullScreen = false;
                    break;
                }
                break;
            case 10:
                if (this.mVideoPlayer.isOutputMute()) {
                    if (isResidentProgressStyle()) {
                        this.mAudioBtnResident.setImageResource(R.drawable.qui_volume_off_2);
                        this.mAudioBtnResident.setColorFilter(-1);
                        break;
                    } else {
                        this.mAudioBtn.setImageResource(R.drawable.mxh);
                        break;
                    }
                } else if (isResidentProgressStyle()) {
                    this.mAudioBtnResident.setImageResource(R.drawable.qui_volume_plus);
                    this.mAudioBtnResident.setColorFilter(-1);
                    break;
                } else {
                    this.mAudioBtn.setImageResource(R.drawable.mxi);
                    break;
                }
            case 11:
                if (isResidentProgressStyle()) {
                    this.mAudioBtnResident.setVisibility(0);
                    checkView(this.mAudioBtnResident);
                    break;
                } else {
                    this.mAudioBtn.setVisibility(0);
                    checkView(this.mAudioBtn);
                    break;
                }
            case 12:
                this.mFullScreenBtn.setVisibility(0);
                checkView(this.mFullScreenBtn);
                break;
            case 13:
                if (this.mCurrentStatus.get() == 0) {
                    if (this.mNeedReport && this.mData != null) {
                        HashMap hashMap = new HashMap();
                        hl0.a.a(hashMap, this.mData.msgId);
                        hashMap.put(2, this.mData.msgId);
                        hashMap.put(6, this.mData.feedId);
                        hashMap.put(4, "20");
                        hashMap.put(43, this.mData.algorithmId);
                        hashMap.put(44, this.mData.type + "");
                        hl0.a.c(((ICmGameHelper) QRoute.api(ICmGameHelper.class)).getAppInterface(), "769", "205020", this.mData.gameInfo.gameAppId, "76902", "1", "160", hashMap);
                    }
                    saveCurrentVideoPlayer();
                    this.mOperateButton.setVisibility(8);
                    this.mLoadingButton.setVisibility(0);
                    play();
                    break;
                } else {
                    QLog.e(TAG, 1, "[handleMessage] autoplay mCurrentStatus:" + this.mCurrentStatus.get());
                    break;
                }
            case 15:
                setProgressVisibility(((Integer) message.obj).intValue());
                break;
            case 16:
                QLog.i(TAG, 2, "MSG_TYPE_SHOW_PLAY,mLoadingStyle:" + this.mLoadingStyle);
                this.mOperateButton.setVisibility(((Integer) message.obj).intValue());
                break;
            case 17:
                CheckBox checkBox = this.mDanmakuSwitch;
                if (this.mDanmakuSwitchStyle > 0) {
                    i3 = 0;
                }
                checkBox.setVisibility(i3);
                int i16 = this.mDanmakuSwitchStyle;
                if (i16 == 1) {
                    this.mDanmakuSwitch.setChecked(false);
                } else if (i16 == 2) {
                    this.mDanmakuSwitch.setChecked(true);
                }
                checkView(this.mDanmakuSwitch);
                break;
            case 18:
                ISuperPlayer iSuperPlayer = this.mVideoPlayer;
                if (iSuperPlayer != null) {
                    iSuperPlayer.setXYaxis(this.mXYaxis);
                    break;
                }
                break;
            case 19:
                View view = this.mVideoView;
                if (view != null && !this.mInterceptSurfaceTextureDestroyed) {
                    ((SPlayerVideoView) view).disableViewCallback();
                    this.mInterceptSurfaceTextureDestroyed = true;
                }
                this.mCoverContainer.setVisibility(8);
                break;
            case 20:
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "[handleMessage] preload mCurrentStatus:" + this.mCurrentStatus.get());
                }
                if (this.mCurrentStatus.get() == 0 || this.mCurrentStatus.get() == 5) {
                    if (!this.openedSet.contains(getVideoKey())) {
                        play(true);
                        break;
                    }
                }
                break;
        }
    }

    public void hideControlPanel() {
        QLog.d(TAG, 1, "[hideControlPanel] hide,mLoadingStyle:" + this.mLoadingStyle);
        if (isResidentProgressStyle()) {
            return;
        }
        this.mUiHandler.removeMessages(2);
        this.mUiHandler.sendMessageDelayed(Message.obtain(this.mUiHandler, 2), 2000L);
    }

    public boolean isFromClickTwoPauseScene(String str) {
        return UPDATE_PANEL_SCENE_CLICK_TWO_PAUSE.equals(str);
    }

    public boolean isFullScreenMode() {
        return this.mIsFullScreen;
    }

    public boolean isPlayingClickCountOnce() {
        if (this.mPlayingClickCount == 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        View view = this.mVideoView;
        if (view != null && this.mInterceptSurfaceTextureDestroyed) {
            SPlayerVideoView sPlayerVideoView = (SPlayerVideoView) view;
            sPlayerVideoView.enableViewCallback();
            sPlayerVideoView.disableViewCallback();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.fet) {
            handleOperateClick();
        } else if (id5 != R.id.kvk && id5 != R.id.y_n) {
            if (id5 == R.id.f165307cq3) {
                if (this.mIsFullScreen) {
                    exitFullScreen();
                } else {
                    enterFullScreen();
                }
            } else if (id5 == R.id.kti) {
                if (isResidentProgressStyle()) {
                    if (this.mPlayBtnVisibility == 0) {
                        handleOperateClick();
                    } else if (this.mTvDurationResident.getVisibility() != 0 || this.mControlPanelResident.getVisibility() != 0) {
                        showResidentDurationAndMask(true);
                        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.media.e
                            @Override // java.lang.Runnable
                            public final void run() {
                                GameCenterVideoViewController.this.lambda$onClick$1();
                            }
                        }, 2000L);
                    }
                } else if (this.mControlPanel.getVisibility() != 0) {
                    showControlPanel();
                }
                onEmptyAreaClicked();
            }
        } else {
            if (this.mVideoPlayer != null) {
                com.tencent.mobileqq.qqgamepub.data.b.f264501a = !r0.isOutputMute();
                setMute(!this.mVideoPlayer.isOutputMute());
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void onCompletion(ISuperPlayer iSuperPlayer) {
        RFWPlayerBaseInterceptor rFWPlayerBaseInterceptor = this.mReportInterceptor;
        if (rFWPlayerBaseInterceptor != null) {
            rFWPlayerBaseInterceptor.onCompletion(iSuperPlayer);
        }
        QLog.d(TAG, 4, "onCompletion");
        setCurrentStatus(7);
        stop();
        release();
    }

    public boolean onError(ISuperPlayer iSuperPlayer, int i3, int i16, int i17, String str) {
        RFWPlayerBaseInterceptor rFWPlayerBaseInterceptor = this.mReportInterceptor;
        if (rFWPlayerBaseInterceptor != null) {
            rFWPlayerBaseInterceptor.onError(iSuperPlayer, i3, i16, i17, str);
        }
        QLog.d(TAG, 4, "SuperPlayer onError:module" + i3 + " errorType" + i16 + " errorCode" + i17 + " extraInfo" + str);
        release();
        this.mUiHandler.post(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController.4
            @Override // java.lang.Runnable
            public void run() {
                if (!GameCenterVideoViewController.this.mEnableShowErrorToast) {
                    return;
                }
                String qqStr = HardCodeUtil.qqStr(R.string.mw7);
                if (!NetworkUtil.isNetworkAvailable(GameCenterVideoViewController.this.getContext())) {
                    qqStr = GameCenterVideoViewController.this.getContext().getString(R.string.f173056gt1);
                } else if (GameCenterVideoViewController.this.mData.type == 1) {
                    qqStr = HardCodeUtil.qqStr(R.string.mwd);
                }
                QQToast.makeText(GameCenterVideoViewController.this.getContext(), 1, qqStr, 0).show(0);
            }
        });
        QLog.e(TAG, 1, "[onError] " + i3 + ", " + i16 + ", " + i17);
        return false;
    }

    public boolean onInfo(ISuperPlayer iSuperPlayer, int i3, long j3, long j16, Object obj) {
        RFWPlayerBaseInterceptor rFWPlayerBaseInterceptor = this.mReportInterceptor;
        if (rFWPlayerBaseInterceptor != null) {
            rFWPlayerBaseInterceptor.onInfo(i3, j3, j16, obj);
        }
        if (i3 != 105) {
            if (i3 != 108) {
                if (i3 != 112) {
                    if (i3 == 113) {
                        onPlayerInfoBufferingEnd();
                        return false;
                    }
                    return false;
                }
                onPlayerInfoBufferingStart();
                return false;
            }
            onPlayerInfoCurrentLoopEnd();
            return false;
        }
        onPlayerInfoFirstVideoFrameRendered();
        return false;
    }

    public void onProgressChanged(SeekBar seekBar, int i3, boolean z16) {
        f fVar = this.mOnProgressChangeListener;
        if (fVar != null) {
            fVar.onProgressChanged(i3, this.mVideoId);
        }
        if (z16 && isResidentProgressStyle()) {
            updateResidentDurationProgressView(i3);
        }
    }

    public void onSeekComplete(ISuperPlayer iSuperPlayer) {
        QLog.d(TAG, 4, "onSeekComplete: ", Long.valueOf(getCurrentPostion()));
        RFWPlayerBaseInterceptor rFWPlayerBaseInterceptor = this.mReportInterceptor;
        if (rFWPlayerBaseInterceptor != null) {
            rFWPlayerBaseInterceptor.onSeekComplete(iSuperPlayer);
        }
        this.isFromSeekComplete = true;
        start();
        g gVar = this.mOnSeekListener;
        if (gVar != null) {
            gVar.a((int) getCurrentPostion(), this.mVideoId);
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        this.mIStartTrackingTouch = true;
        this.mUiHandler.removeMessages(2);
        QLog.i(TAG, 2, "onStartTrackingTouch");
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        EventCollector.getInstance().onStopTrackingTouchBefore(seekBar);
        this.mIStartTrackingTouch = false;
        int progress = seekBar.getProgress();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onStopTrackingTouch(): progress=" + progress);
        }
        seekTo(progress);
        if (isResidentProgressStyle()) {
            showResidentDurationAndMask(false);
            this.mTvDurationProgressTimeResident.setVisibility(8);
        } else {
            hideControlPanel();
        }
        EventCollector.getInstance().onStopTrackingTouch(seekBar);
    }

    public void onVideoPrepared(ISuperPlayer iSuperPlayer) {
        RFWPlayerBaseInterceptor rFWPlayerBaseInterceptor = this.mReportInterceptor;
        if (rFWPlayerBaseInterceptor != null) {
            rFWPlayerBaseInterceptor.onVideoPrepare();
        }
        this.mUiHandler.post(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController.5
            @Override // java.lang.Runnable
            public void run() {
                QLog.i(GameCenterVideoViewController.TAG, 1, "[onVideoPrepared] status:" + GameCenterVideoViewController.this.mCurrentStatus.get() + ",sPlayCount = " + GameCenterVideoViewController.sPlayCount + ",ConfigCount=3" + GameCenterVideoViewController.this.hashCode() + ",videoKey:" + GameCenterVideoViewController.this.getVideoKey().hashCode() + ",mIsFromPreload:" + GameCenterVideoViewController.this.mIsFromPreload);
                if (GameCenterVideoViewController.this.mCurrentStatus.get() == 5) {
                    return;
                }
                GameCenterVideoViewController.this.setCurrentStatus(2);
                if (GameCenterVideoViewController.this.mIsFromPreload) {
                    GameCenterVideoViewController.this.mIsFromPreload = false;
                    QLog.d(GameCenterVideoViewController.TAG, 4, "prepared when IsFromPreload,return,this:" + GameCenterVideoViewController.this.hashCode());
                    return;
                }
                GameCenterVideoViewController.this.doOnVideoPrepared();
                if (GameCenterVideoViewController.this.mIsScreenOff) {
                    GameCenterVideoViewController.this.pause();
                }
            }
        });
    }

    public void pause() {
        if (this.mCurrentStatus.get() == 3) {
            this.mUiHandler.removeMessages(5);
            if (this.mSrc == 2 && sPlayCount == 0) {
                this.mUiHandler.removeMessages(14);
            }
            this.mPlayTime += System.currentTimeMillis() - this.mLastPlayTimestamp;
            ISuperPlayer iSuperPlayer = this.mVideoPlayer;
            if (iSuperPlayer != null) {
                iSuperPlayer.pause();
                setCurrentStatus(5);
                updateControlPanle();
            }
        }
    }

    public void play() {
        play(false);
    }

    public void preload() {
        this.mUiHandler.removeMessages(20);
        this.mUiHandler.sendEmptyMessage(20);
    }

    public void release() {
        RFWPlayerBaseInterceptor rFWPlayerBaseInterceptor = this.mReportInterceptor;
        if (rFWPlayerBaseInterceptor != null) {
            rFWPlayerBaseInterceptor.onRelease(1);
        }
        setCurrentStatus(0);
        ISuperPlayer iSuperPlayer = this.mVideoPlayer;
        if (iSuperPlayer != null) {
            iSuperPlayer.stop();
            this.mVideoPlayer.release();
            unRegisterScreenStatusRec();
            QLog.e(TAG, 1, "[release] release video ok:" + this.mVideoPlayer.toString());
        }
        this.mUiHandler.removeCallbacksAndMessages(null);
        updateControlPanle();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Activity scanForActivity(Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (!(context instanceof ContextWrapper)) {
            return null;
        }
        return scanForActivity(((ContextWrapper) context).getBaseContext());
    }

    public void seekTo(int i3) {
        RFWPlayerBaseInterceptor rFWPlayerBaseInterceptor = this.mReportInterceptor;
        if (rFWPlayerBaseInterceptor != null) {
            rFWPlayerBaseInterceptor.onStopTrackingTouch(i3, this.progressMax);
        }
        ISuperPlayer iSuperPlayer = this.mVideoPlayer;
        if (iSuperPlayer != null) {
            iSuperPlayer.seekTo(i3, 3);
        }
    }

    public void setCurrentStatus(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "[setCurrentStatus] status:" + i3 + ", obj:" + hashCode());
        }
        this.mLastStatus.set(this.mCurrentStatus.get());
        this.mCurrentStatus.set(i3);
        handleVideoEvent(i3);
        h hVar = this.mStatusListener;
        if (hVar != null) {
            hVar.onVideoStatusChanged(i3, this.mVideoId);
        }
    }

    public void setDanmakuSwitch(int i3) {
        this.mDanmakuSwitchStyle = i3;
        this.mUiHandler.sendEmptyMessage(17);
    }

    public void setData(FeedsItemData feedsItemData, int i3, boolean z16) {
        stopWhenNoUsePreloadOrVideoChange(feedsItemData, z16);
        this.mData = feedsItemData;
        int i16 = this.mVideoDurationValue;
        if (i16 > 0 && feedsItemData.videoDuration == 0) {
            feedsItemData.videoDuration = i16;
        }
        this.mSrc = i3;
        updateControlPanle();
    }

    public void setIsLandscapeWhenFullScreen(boolean z16) {
        this.mIsLandscapeWhenFullScreen = z16;
    }

    public void setLoadingIconStyle(int i3) {
        this.mLoadingStyle = i3;
        this.mLoadingButton.setStyle(i3);
        if (isResidentProgressStyle()) {
            this.mControlPanel.setVisibility(8);
            this.mControlPanelResident.setVisibility(0);
        }
    }

    public void setMute(boolean z16) {
        boolean z17;
        this.mIsMute = z16;
        ISuperPlayer iSuperPlayer = this.mVideoPlayer;
        if (iSuperPlayer != null) {
            if (z16 != iSuperPlayer.isOutputMute()) {
                z17 = true;
            } else {
                z17 = false;
            }
            this.mVideoPlayer.setOutputMute(z16);
            this.mUiHandler.removeMessages(10);
            this.mUiHandler.sendEmptyMessageDelayed(10, 300L);
            h hVar = this.mStatusListener;
            if (hVar != null) {
                hVar.onAudioMute(z16, this.mVideoId, z17);
            }
        }
    }

    public void setOnDanmakuChangeListener(e eVar) {
        this.mOnDanmakuChangeListener = eVar;
    }

    public void setOnProgressChangeListener(f fVar) {
        this.mOnProgressChangeListener = fVar;
    }

    public void setOnSeekListener(g gVar) {
        this.mOnSeekListener = gVar;
    }

    public void setPlayEnabled(boolean z16) {
        int i3;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        this.mPlayBtnVisibility = i3;
        Message.obtain(this.mUiHandler, 16, Integer.valueOf(i3)).sendToTarget();
    }

    public void setPlayNoneNet(boolean z16) {
        this.mEnablePlayNoneNet = z16;
    }

    public void setProgressEnabled(boolean z16) {
        int i3;
        this.mEnableProgress = z16;
        Handler handler = this.mUiHandler;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 4;
        }
        Message.obtain(handler, 15, Integer.valueOf(i3)).sendToTarget();
    }

    public void setShowErrorToast(boolean z16) {
        this.mEnableShowErrorToast = z16;
    }

    public void setSpeedRatio(float f16) {
        if (f16 <= 0.0f) {
            return;
        }
        this.mSpeedRatio = f16;
        ISuperPlayer iSuperPlayer = this.mVideoPlayer;
        if (iSuperPlayer != null) {
            iSuperPlayer.setPlaySpeedRatio(f16);
        }
    }

    public void setVideoDuration(int i3) {
        this.mVideoDurationValue = i3;
        FeedsItemData feedsItemData = this.mData;
        if (feedsItemData != null) {
            feedsItemData.videoDuration = i3;
        }
    }

    public void setVideoId(int i3) {
        this.mVideoId = i3;
    }

    public void setVideoStatusChangerListener(h hVar) {
        this.mStatusListener = hVar;
    }

    public void setXYaxis(int i3) {
        this.mXYaxis = i3;
        if (this.mVideoPlayer != null) {
            this.mUiHandler.removeMessages(18);
            this.mUiHandler.sendEmptyMessage(18);
        }
    }

    public void showControlPanel() {
        this.mUiHandler.removeMessages(1);
        this.mUiHandler.sendMessage(Message.obtain(this.mUiHandler, 1));
    }

    public void start() {
        ISuperPlayer iSuperPlayer = this.mVideoPlayer;
        if (iSuperPlayer != null) {
            iSuperPlayer.start();
            setCurrentStatus(3);
            updateControlPanle();
            this.mLastPlayTimestamp = System.currentTimeMillis();
            postUpdateProgress(0L);
            RFWPlayerBaseInterceptor rFWPlayerBaseInterceptor = this.mReportInterceptor;
            if (rFWPlayerBaseInterceptor != null) {
                rFWPlayerBaseInterceptor.onStart();
            }
        }
    }

    public void stop() {
        if (this.mVideoPlayer != null && this.mCurrentStatus.get() != 0) {
            if (this.mIsAutoPlay && this.mNeedReport) {
                HashMap hashMap = new HashMap();
                hl0.a.a(hashMap, this.mData.msgId);
                hashMap.put(2, this.mData.msgId);
                hashMap.put(6, this.mData.feedId);
                hashMap.put(4, "-1");
                hashMap.put(42, getCurrentPostion() + "");
                hashMap.put(43, this.mData.algorithmId);
                hashMap.put(44, this.mData.type + "");
                hl0.a.c(((ICmGameHelper) QRoute.api(ICmGameHelper.class)).getAppInterface(), "769", "205026", this.mData.gameInfo.gameAppId, "76902", "1", "160", hashMap);
            }
            this.mVideoPlayer.stop();
            setCurrentStatus(0);
            updateControlPanle();
        }
    }

    public void updateControlPanel(String str) {
        QLog.e(TAG, 1, "[updateControlPanel] " + this.mCurrentStatus.get() + ",scene:" + str);
        this.mUiHandler.removeMessages(4);
        Message obtain = Message.obtain(this.mUiHandler, 4);
        obtain.obj = str;
        this.mUiHandler.sendMessage(obtain);
    }

    public void updateControlPanle() {
        int i3 = this.mCurrentStatus.get();
        if (i3 != 0) {
            QLog.e(TAG, 1, "[updateControlPanle] " + i3);
        }
        this.mUiHandler.removeMessages(4);
        this.mUiHandler.sendEmptyMessage(4);
    }

    private String getVideoKey(FeedsItemData feedsItemData) {
        if (feedsItemData == null) {
            return "";
        }
        String str = feedsItemData.videoUrl;
        if (TextUtils.isEmpty(str)) {
            str = feedsItemData.videoVid;
        }
        return str == null ? "" : str;
    }

    public void play(boolean z16) {
        this.mIsFromPreload = z16;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(z16 ? "[preload]" : "[play]");
        sb5.append(hashCode());
        sb5.append(",mCurrentStatus:");
        sb5.append(this.mCurrentStatus.get());
        sb5.append(",playerStatues:");
        sb5.append(getPlayerStatus());
        sb5.append(",videoKey:");
        sb5.append(getVideoKey().hashCode());
        QLog.i(TAG, 1, sb5.toString());
        if (!z16) {
            if (this.mCurrentStatus.get() == 2) {
                QLog.i(TAG, 1, "[play] isPrepared just start " + hashCode() + ",videoKey:" + getVideoKey().hashCode());
                setMute(this.mIsMute);
                doOnVideoPrepared();
                return;
            }
            if (this.mCurrentStatus.get() == 5) {
                start();
                showFloatWindow();
                return;
            }
        }
        if (this.mCurrentStatus.get() == 3) {
            return;
        }
        if (!this.mEnablePlayNoneNet && !NetworkUtil.isNetworkAvailable(getContext())) {
            if (z16) {
                return;
            }
            this.mUiHandler.post(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController.6
                @Override // java.lang.Runnable
                public void run() {
                    QQToast.makeText(GameCenterVideoViewController.this.getContext(), 1, GameCenterVideoViewController.this.getContext().getString(R.string.f173056gt1), 0).show(0);
                }
            });
            QLog.d(TAG, 2, "commentReport network error, stop request.");
            setCurrentStatus(0);
            updateControlPanle();
            return;
        }
        SuperPlayerVideoInfo createVideoInfo = createVideoInfo();
        try {
            View view = this.mVideoView;
            if (view != null && this.mVideoContainer == view.getParent()) {
                this.mVideoContainer.removeView(this.mVideoView);
                this.mVideoView = null;
            }
        } catch (Exception unused) {
        }
        View createVideoView = createVideoView();
        this.mVideoView = createVideoView;
        if (createVideoView != null) {
            this.mVideoContainer.addView(createVideoView, -1, -1);
            checkView(this.mVideoView);
        }
        this.mInterceptSurfaceTextureDestroyed = false;
        this.mIsFirstFrameShowed = false;
        if (this.mVideoPlayer != null) {
            this.openedSet.add(getVideoKey());
            setCurrentStatus(1);
            this.mVideoPlayer.setXYaxis(this.mXYaxis);
            SuperPlayerOption obtain = SuperPlayerOption.obtain();
            obtain.isPrePlay = z16;
            RFWPlayerBaseInterceptor rFWPlayerBaseInterceptor = this.mReportInterceptor;
            if (rFWPlayerBaseInterceptor != null) {
                rFWPlayerBaseInterceptor.beforeOpenMedia(obtain, this.mVideoPlayer);
            }
            this.mVideoPlayer.openMediaPlayer(getContext(), createVideoInfo, 0L, obtain);
            RFWPlayerBaseInterceptor rFWPlayerBaseInterceptor2 = this.mReportInterceptor;
            if (rFWPlayerBaseInterceptor2 != null) {
                rFWPlayerBaseInterceptor2.afterOpenMedia(obtain, this.mVideoPlayer);
            }
        } else {
            QLog.e(TAG, 1, "[play] mVideoPlayer is null");
        }
        setMute(this.mIsMute);
    }

    public void onEmptyAreaClicked() {
    }

    protected void onPlayerCreated(ISuperPlayer iSuperPlayer) {
    }

    protected void onViewChanged(View view) {
    }

    public GameCenterVideoViewController(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.openedSet = new HashSet();
        this.mUiHandler = new Handler(Looper.getMainLooper(), this);
        this.mCurrentStatus = new AtomicInteger(0);
        this.mLastStatus = new AtomicInteger(0);
        this.mXYaxis = 0;
        this.mIsFullScreen = false;
        this.mNeedReport = false;
        this.mIsMute = false;
        this.mSpeedRatio = 1.0f;
        this.mIsAutoPlay = false;
        this.mEnableFullScreen = false;
        this.mEnableAudio = false;
        this.mEnableProgress = true;
        this.mEnableShowErrorToast = false;
        this.mPlayBtnVisibility = 0;
        this.mVideoId = 0;
        this.mPlayTime = 0L;
        this.mLastPlayTimestamp = 0L;
        this.mLoadingStyle = 1;
        this.mIsLandscapeWhenFullScreen = true;
        this.mIsFirstFrameShowed = false;
        this.mIsFromPreload = false;
        this.mEnablePlayNoneNet = false;
        this.mIStartTrackingTouch = false;
        this.mPlayingClickCount = 0;
        this.mIsScreenOff = false;
        this.mInterceptSurfaceTextureDestroyed = false;
        this.mScreenReceiver = new a();
        initView();
    }

    public GameCenterVideoViewController(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.openedSet = new HashSet();
        this.mUiHandler = new Handler(Looper.getMainLooper(), this);
        this.mCurrentStatus = new AtomicInteger(0);
        this.mLastStatus = new AtomicInteger(0);
        this.mXYaxis = 0;
        this.mIsFullScreen = false;
        this.mNeedReport = false;
        this.mIsMute = false;
        this.mSpeedRatio = 1.0f;
        this.mIsAutoPlay = false;
        this.mEnableFullScreen = false;
        this.mEnableAudio = false;
        this.mEnableProgress = true;
        this.mEnableShowErrorToast = false;
        this.mPlayBtnVisibility = 0;
        this.mVideoId = 0;
        this.mPlayTime = 0L;
        this.mLastPlayTimestamp = 0L;
        this.mLoadingStyle = 1;
        this.mIsLandscapeWhenFullScreen = true;
        this.mIsFirstFrameShowed = false;
        this.mIsFromPreload = false;
        this.mEnablePlayNoneNet = false;
        this.mIStartTrackingTouch = false;
        this.mPlayingClickCount = 0;
        this.mIsScreenOff = false;
        this.mInterceptSurfaceTextureDestroyed = false;
        this.mScreenReceiver = new a();
        initView();
    }
}
