package com.tencent.mobileqq.qzoneplayer.ui;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.oskplayer.PlayerConfig;
import com.tencent.oskplayer.model.PlayerCallBack;
import com.tencent.oskplayer.util.PlayerUtils;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.lang.ref.WeakReference;
import java.util.Formatter;
import java.util.Locale;
import java.util.Set;
import org.light.LightConstants;

/* compiled from: P */
/* loaded from: classes16.dex */
public class VideoControllerView extends FrameLayout {
    static IPatchRedirector $redirector_ = null;
    protected static final int FADE_OUT = 1;
    private static String LOG_NAME = null;
    protected static final int SET_PROGRESS = 3;
    protected static final int SHOW_PROGRESS = 2;
    private static final String TAG = "VideoControllerView";
    public static int sDefaultTimeout;
    private static HandlerThread sVideoControllerViewHandlerThread;
    private int curFullscreenButtonDrawableRes;
    private int curLandscapeButtonDrawableRes;
    private String currentStringName;
    protected ViewGroup mAnchor;
    protected Context mContext;
    private TextView mCurrentTime;
    private boolean mDragging;
    private TextView mDuration;
    private StringBuilder mFormatBuilder;
    private Formatter mFormatter;
    private ImageButton mFullscreenButton;
    protected View.OnClickListener mFullscreenListener;
    protected Handler mHandler;
    private View.OnClickListener mPauseListener;
    protected MediaPlayerControl mPlayer;
    protected ProgressBar mProgress;
    protected View mRoot;
    private SeekBar.OnSeekBarChangeListener mSeekBarChangeListener;
    protected SeekBar.OnSeekBarChangeListener mSeekListener;
    protected volatile boolean mShowing;
    private View.OnClickListener mStreamSelectListener;
    private ImageButton mSwitchLandscapeButton;
    protected View.OnClickListener mSwitchLandscapeListener;
    public ImageButton mVideoDanmakuSwitch;
    protected int mVideoDuration;
    public ImageButton mVideoOrigin;
    protected PlayerResources playerResources;
    private int seekBarrier;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface MediaPlayerControl {
        boolean canPausePlay();

        boolean canSeekBackward();

        boolean canSeekForward();

        boolean enableToggleFullScreen();

        boolean enableToggleLandscape();

        int getBufferPercentage();

        int getCurrentPosition();

        int getDuration();

        String getVideoUriWithUuid();

        void hideTopBar();

        boolean isFullScreen();

        boolean isLandscape();

        boolean isLoading();

        boolean isPlayComplete();

        boolean isPlaying();

        void pause();

        void seekTo(int i3);

        void setRate(float f16);

        void start();

        String time2str(int i3);

        void toggleFullScreen();

        void toggleLandscape();

        void updatePlayPauseButton();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class MessageHandler extends Handler {
        static IPatchRedirector $redirector_;
        private final WeakReference<VideoControllerView> mView;

        MessageHandler(Looper looper, VideoControllerView videoControllerView) {
            super(looper);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) looper, (Object) videoControllerView);
            } else {
                this.mView = new WeakReference<>(videoControllerView);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            MediaPlayerControl mediaPlayerControl;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) message);
                return;
            }
            VideoControllerView videoControllerView = this.mView.get();
            if (videoControllerView != null && (mediaPlayerControl = videoControllerView.mPlayer) != null) {
                int i3 = message.what;
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 == 3) {
                            videoControllerView.setProgress();
                            return;
                        }
                        return;
                    }
                    if (!mediaPlayerControl.isPlayComplete()) {
                        int progress = videoControllerView.setProgress();
                        if (!videoControllerView.mDragging && videoControllerView.getParent() != null) {
                            if (videoControllerView.mShowing || videoControllerView.getVisibility() == 0) {
                                removeMessages(2);
                                sendMessageDelayed(obtainMessage(2), 1000 - (progress % 1000));
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    int duration = videoControllerView.mPlayer.getDuration();
                    if (duration > 0) {
                        videoControllerView.mVideoDuration = duration;
                    }
                    videoControllerView.setProgress(videoControllerView.mVideoDuration);
                    return;
                }
                PlayerUtils.runOnUiThread(new Runnable(videoControllerView) { // from class: com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView.MessageHandler.1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ VideoControllerView val$view;

                    {
                        this.val$view = videoControllerView;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MessageHandler.this, (Object) videoControllerView);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else {
                            this.val$view.hide();
                            this.val$view.mPlayer.hideTopBar();
                        }
                    }
                });
            }
        }

        @Override // android.os.Handler
        public boolean sendMessageAtTime(Message message, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, this, message, Long.valueOf(j3))).booleanValue();
            }
            VideoControllerView videoControllerView = this.mView.get();
            if (videoControllerView == null || videoControllerView.mPlayer == null) {
                return false;
            }
            return super.sendMessageAtTime(message, j3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface OnControllerEventListener {
        void onControllerHide(View view);

        void onGestureMoveDown();

        void onGestureMoveRight();

        void onGestureMoveUp();

        void onRequestOriginalVideo();

        void onRequestPauseVideo();

        void onRequestPlayVideo();

        void onRequestToggleFullscreen(View view, boolean z16);

        void onRequestToggleLandscape(View view, boolean z16);

        void onRequsetJumpAdvUrl();
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12274);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 33)) {
            redirector.redirect((short) 33);
        } else {
            sDefaultTimeout = 5000;
            LOG_NAME = "@lovelybone";
        }
    }

    public VideoControllerView(Context context, AttributeSet attributeSet, PlayerResources playerResources) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, attributeSet, playerResources);
            return;
        }
        this.seekBarrier = -1;
        this.mPauseListener = new View.OnClickListener() { // from class: com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) VideoControllerView.this);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) view);
                } else {
                    VideoControllerView.this.doPauseResume();
                    VideoControllerView.this.show(VideoControllerView.sDefaultTimeout);
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        };
        this.mFullscreenListener = new View.OnClickListener() { // from class: com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView.4
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) VideoControllerView.this);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) view);
                } else {
                    VideoControllerView.this.doToggleFullscreen();
                    VideoControllerView.this.show(VideoControllerView.sDefaultTimeout);
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        };
        this.mSwitchLandscapeListener = new View.OnClickListener() { // from class: com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView.5
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) VideoControllerView.this);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) view);
                } else {
                    VideoControllerView.this.doToggleLandscape();
                    VideoControllerView.this.show(VideoControllerView.sDefaultTimeout);
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        };
        this.mSeekListener = new SeekBar.OnSeekBarChangeListener() { // from class: com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView.6
            static IPatchRedirector $redirector_;
            private int mDestProgress;
            private int mStartProgress;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) VideoControllerView.this);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i3, boolean z16) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, this, seekBar, Integer.valueOf(i3), Boolean.valueOf(z16));
                    return;
                }
                if (VideoControllerView.this.mSeekBarChangeListener != null) {
                    VideoControllerView.this.mSeekBarChangeListener.onProgressChanged(seekBar, i3, z16);
                }
                if (VideoControllerView.this.mPlayer == null) {
                    return;
                }
                int progress = seekBar.getProgress();
                this.mDestProgress = progress;
                if (progress >= this.mStartProgress) {
                    if (!VideoControllerView.this.mPlayer.canSeekForward()) {
                        return;
                    }
                } else if (!VideoControllerView.this.mPlayer.canSeekBackward()) {
                    return;
                }
                if (!z16) {
                    return;
                }
                int duration = VideoControllerView.this.mPlayer.getDuration();
                if (duration > 0) {
                    VideoControllerView.this.mVideoDuration = duration;
                }
                long j3 = (duration * i3) / 1000;
                if (VideoControllerView.this.mCurrentTime != null) {
                    VideoControllerView.this.mCurrentTime.setText(VideoControllerView.this.mPlayer.time2str((int) j3));
                }
                Set<PlayerCallBack> callbacks = PlayerConfig.g().getCallbacks();
                if (callbacks != null) {
                    for (PlayerCallBack playerCallBack : callbacks) {
                        if (playerCallBack != null) {
                            playerCallBack.onMediaEvent(playerCallBack, PlayerCallBack.EVENT_SEEK_BAR_ON_SEEK, null, null);
                        }
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) seekBar);
                    return;
                }
                if (VideoControllerView.this.mSeekBarChangeListener != null) {
                    VideoControllerView.this.mSeekBarChangeListener.onStartTrackingTouch(seekBar);
                }
                this.mStartProgress = seekBar.getProgress();
                if (PlayerConfig.g().getVideoReporter() != null) {
                    MediaPlayerControl mediaPlayerControl = VideoControllerView.this.mPlayer;
                    if (mediaPlayerControl != null) {
                        PlayerConfig.g().getVideoReporter().progressBarSeekingBegin(PlayerUtils.getVideoUuidFromVideoUrl(mediaPlayerControl.getVideoUriWithUuid()), VideoControllerView.this.mPlayer.getCurrentPosition(), VideoControllerView.this.mPlayer.isPlaying());
                    } else {
                        PlayerConfig.g().getVideoReporter().progressBarSeekingBegin(null, -1L, false);
                    }
                }
                Set<PlayerCallBack> callbacks = PlayerConfig.g().getCallbacks();
                if (callbacks != null) {
                    for (PlayerCallBack playerCallBack : callbacks) {
                        playerCallBack.onMediaEvent(playerCallBack, PlayerCallBack.EVENT_SEEK_BAR_START_SEEK, null, null);
                    }
                }
                VideoControllerView.this.show(3600000);
                VideoControllerView.this.mDragging = true;
                VideoControllerView.this.mHandler.removeMessages(2);
            }

            /* JADX WARN: Removed duplicated region for block: B:23:0x0088  */
            /* JADX WARN: Removed duplicated region for block: B:31:0x00c5  */
            /* JADX WARN: Removed duplicated region for block: B:42:0x0154  */
            /* JADX WARN: Removed duplicated region for block: B:49:0x0119  */
            /* JADX WARN: Removed duplicated region for block: B:51:0x00e0  */
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onStopTrackingTouch(SeekBar seekBar) {
                int duration;
                int progress;
                long j3;
                Set<PlayerCallBack> callbacks;
                EventCollector.getInstance().onStopTrackingTouchBefore(seekBar);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    iPatchRedirector2.redirect((short) 4, (Object) this, (Object) seekBar);
                } else {
                    if (VideoControllerView.this.mSeekBarChangeListener != null) {
                        VideoControllerView.this.mSeekBarChangeListener.onStopTrackingTouch(seekBar);
                    }
                    if (VideoControllerView.this.isShowing()) {
                        VideoControllerView videoControllerView = VideoControllerView.this;
                        if (videoControllerView.mPlayer != null) {
                            videoControllerView.mDragging = false;
                            if (this.mDestProgress >= this.mStartProgress) {
                                if (!VideoControllerView.this.mPlayer.canSeekForward()) {
                                    VideoControllerView.this.mProgress.setProgress(this.mStartProgress);
                                    PlayerUtils.log(5, VideoControllerView.TAG, "seekforward is not possible");
                                }
                                duration = VideoControllerView.this.mPlayer.getDuration();
                                if (duration > 0) {
                                    VideoControllerView.this.mVideoDuration = duration;
                                }
                                progress = seekBar.getProgress();
                                if (PlayerConfig.g().getVideoReporter() != null && seekBar.getMax() > 0) {
                                    PlayerConfig.g().getVideoReporter().progressBarSeekingEnd(PlayerUtils.getVideoUuidFromVideoUrl(VideoControllerView.this.mPlayer.getVideoUriWithUuid()), (duration * progress) / seekBar.getMax());
                                }
                                if (progress != seekBar.getMax()) {
                                    if (duration > 0) {
                                        j3 = duration + LightConstants.ErrorCode.SDK_VERSION_NOT_SUPPORT;
                                        int max = (int) ((((float) j3) / duration) * seekBar.getMax());
                                        ProgressBar progressBar = VideoControllerView.this.mProgress;
                                        if (progressBar != null) {
                                            progressBar.setProgress(max);
                                        }
                                    } else {
                                        j3 = duration;
                                    }
                                } else {
                                    j3 = (duration * progress) / 1000;
                                }
                                if (VideoControllerView.this.seekBarrier < 0 && j3 >= VideoControllerView.this.seekBarrier) {
                                    VideoControllerView.this.mPlayer.seekTo(0);
                                    VideoControllerView.this.mPlayer.pause();
                                } else {
                                    int i3 = (int) j3;
                                    VideoControllerView.this.mPlayer.seekTo(i3);
                                    if (VideoControllerView.this.mCurrentTime != null) {
                                        VideoControllerView.this.mCurrentTime.setText(VideoControllerView.this.mPlayer.time2str(i3));
                                    }
                                }
                                VideoControllerView.this.postSetProgress();
                                VideoControllerView.this.updatePausePlay();
                                VideoControllerView.this.show(VideoControllerView.sDefaultTimeout);
                                VideoControllerView.this.mHandler.removeMessages(2);
                                VideoControllerView.this.mHandler.sendEmptyMessage(2);
                                callbacks = PlayerConfig.g().getCallbacks();
                                if (callbacks != null) {
                                    for (PlayerCallBack playerCallBack : callbacks) {
                                        playerCallBack.onMediaEvent(playerCallBack, PlayerCallBack.EVENT_SEEK_BAR_STOP_SEEK, null, null);
                                    }
                                }
                            } else {
                                if (!VideoControllerView.this.mPlayer.canSeekBackward()) {
                                    VideoControllerView.this.mProgress.setProgress(this.mStartProgress);
                                    PlayerUtils.log(5, VideoControllerView.TAG, "seekbackward is not possible");
                                }
                                duration = VideoControllerView.this.mPlayer.getDuration();
                                if (duration > 0) {
                                }
                                progress = seekBar.getProgress();
                                if (PlayerConfig.g().getVideoReporter() != null) {
                                    PlayerConfig.g().getVideoReporter().progressBarSeekingEnd(PlayerUtils.getVideoUuidFromVideoUrl(VideoControllerView.this.mPlayer.getVideoUriWithUuid()), (duration * progress) / seekBar.getMax());
                                }
                                if (progress != seekBar.getMax()) {
                                }
                                if (VideoControllerView.this.seekBarrier < 0) {
                                }
                                int i36 = (int) j3;
                                VideoControllerView.this.mPlayer.seekTo(i36);
                                if (VideoControllerView.this.mCurrentTime != null) {
                                }
                                VideoControllerView.this.postSetProgress();
                                VideoControllerView.this.updatePausePlay();
                                VideoControllerView.this.show(VideoControllerView.sDefaultTimeout);
                                VideoControllerView.this.mHandler.removeMessages(2);
                                VideoControllerView.this.mHandler.sendEmptyMessage(2);
                                callbacks = PlayerConfig.g().getCallbacks();
                                if (callbacks != null) {
                                }
                            }
                        }
                    }
                }
                EventCollector.getInstance().onStopTrackingTouch(seekBar);
            }
        };
        this.mRoot = null;
        this.mContext = context;
        this.playerResources = playerResources;
        maybeInitHandlerThread();
        initHandler();
    }

    private void destroyHandler() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    private boolean hasSmartBar() {
        if (!Build.MANUFACTURER.equals(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_MEIZU)) {
            return false;
        }
        try {
            return ((Boolean) Class.forName("android.os.Build").getMethod("hasSmartBar", new Class[0]).invoke(null, new Object[0])).booleanValue();
        } catch (Exception unused) {
            String str = Build.DEVICE;
            if (str.equals("mx2")) {
                return true;
            }
            if (!str.equals("mx")) {
                str.equals("m9");
            }
            return false;
        }
    }

    private void initHandler() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        if (sVideoControllerViewHandlerThread != null) {
            this.mHandler = new MessageHandler(sVideoControllerViewHandlerThread.getLooper(), this);
        } else {
            this.mHandler = new MessageHandler(Looper.getMainLooper(), this);
        }
    }

    private boolean isNotSupportFullscreen() {
        return DeviceInfoMonitor.getModel().equals("Lenovo A788T");
    }

    private void maybeInitHandlerThread() {
        HandlerThread handlerThread = sVideoControllerViewHandlerThread;
        if (handlerThread == null || !handlerThread.isAlive()) {
            BaseHandlerThread baseHandlerThread = new BaseHandlerThread("VideoControllerViewHandlerThread", -2);
            sVideoControllerViewHandlerThread = baseHandlerThread;
            baseHandlerThread.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int setProgress() {
        return setProgress(-1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void disableUnsupportedButtons() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        MediaPlayerControl mediaPlayerControl = this.mPlayer;
        if (mediaPlayerControl == null) {
            return;
        }
        try {
            if (this.mFullscreenButton != null && !mediaPlayerControl.enableToggleFullScreen()) {
                this.mFullscreenButton.setVisibility(8);
            }
            if (this.mSwitchLandscapeButton != null && !this.mPlayer.enableToggleLandscape()) {
                this.mSwitchLandscapeButton.setVisibility(8);
            }
        } catch (IncompatibleClassChangeError unused) {
        }
    }

    public void doPauseResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
            return;
        }
        MediaPlayerControl mediaPlayerControl = this.mPlayer;
        if (mediaPlayerControl == null || !mediaPlayerControl.canPausePlay()) {
            return;
        }
        if (this.mPlayer.isPlayComplete()) {
            this.mPlayer.seekTo(0);
            this.mPlayer.start();
        } else if (this.mPlayer.isPlaying()) {
            this.mPlayer.pause();
        } else {
            this.mPlayer.start();
        }
        updatePausePlay();
        show();
    }

    public void doToggleFullscreen() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this);
            return;
        }
        MediaPlayerControl mediaPlayerControl = this.mPlayer;
        if (mediaPlayerControl == null) {
            return;
        }
        mediaPlayerControl.toggleFullScreen();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void doToggleLandscape() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this);
            return;
        }
        MediaPlayerControl mediaPlayerControl = this.mPlayer;
        if (mediaPlayerControl == null) {
            return;
        }
        mediaPlayerControl.toggleLandscape();
    }

    @Override // android.view.View
    public View getRootView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (View) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.mRoot;
    }

    public void hide() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        ViewGroup viewGroup = this.mAnchor;
        if (viewGroup == null) {
            return;
        }
        try {
            viewGroup.removeView(this);
        } catch (IllegalArgumentException unused) {
            PlayerUtils.log(3, "MediaController", "already removed");
        }
        this.mShowing = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initControllerView(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) view);
            return;
        }
        ImageButton imageButton = (ImageButton) view.findViewById(this.playerResources.getViewId(555));
        this.mFullscreenButton = imageButton;
        if (imageButton != null) {
            imageButton.setOnClickListener(this.mFullscreenListener);
            if (hasSmartBar() || isNotSupportFullscreen()) {
                this.mFullscreenButton.setVisibility(8);
            }
        }
        ImageButton imageButton2 = (ImageButton) view.findViewById(this.playerResources.getViewId(PlayerResources.ViewId.SWITCH_LANDSCAPE_BUTTON));
        this.mSwitchLandscapeButton = imageButton2;
        if (imageButton2 != null) {
            imageButton2.setOnClickListener(this.mSwitchLandscapeListener);
        }
        ProgressBar progressBar = (ProgressBar) view.findViewById(this.playerResources.getViewId(PlayerResources.ViewId.CONTROLLER_PROGRESS));
        this.mProgress = progressBar;
        if (progressBar != null) {
            if (progressBar instanceof SeekBar) {
                ((SeekBar) progressBar).setOnSeekBarChangeListener(this.mSeekListener);
            }
            this.mProgress.setMax(1000);
        }
        this.mDuration = (TextView) view.findViewById(this.playerResources.getViewId(PlayerResources.ViewId.PLAYER_DURATION));
        this.mCurrentTime = (TextView) view.findViewById(this.playerResources.getViewId(PlayerResources.ViewId.CURRUNT_TIME));
        this.mFormatBuilder = new StringBuilder();
        this.mFormatter = new Formatter(this.mFormatBuilder, Locale.getDefault());
        this.mDuration.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView.1
            static IPatchRedirector $redirector_;
            int currentDownCount;
            String mTitle;
            int maxDownCount;
            long startTimestamp;
            long timeLimitMs;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) VideoControllerView.this);
                    return;
                }
                this.currentDownCount = 0;
                this.maxDownCount = 5;
                this.startTimestamp = 0L;
                this.timeLimitMs = 5000L;
                this.mTitle = "\u64ad\u653e\u901f\u5ea6\u8c03\u8282";
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) view2, (Object) motionEvent)).booleanValue();
                }
                if (motionEvent.getAction() == 0) {
                    if (System.currentTimeMillis() - this.startTimestamp > this.timeLimitMs) {
                        this.currentDownCount = 0;
                        PlayerUtils.log(2, "hahax", "restart counter");
                    }
                    if (this.currentDownCount == 0) {
                        this.startTimestamp = System.currentTimeMillis();
                    }
                    this.currentDownCount++;
                    PlayerUtils.log(2, "hahax", "count" + this.currentDownCount);
                    if (this.currentDownCount >= this.maxDownCount) {
                        PopupMenu popupMenu = new PopupMenu(VideoControllerView.this.getContext(), VideoControllerView.this.mDuration);
                        popupMenu.getMenu().add(this.mTitle);
                        popupMenu.getMenu().add("0.25\u500d\u901f");
                        popupMenu.getMenu().add("0.5\u500d\u901f");
                        popupMenu.getMenu().add("\u6b63\u5e38");
                        popupMenu.getMenu().add("1.5\u500d\u901f");
                        popupMenu.getMenu().add("2.0\u500d\u901f");
                        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView.1.1
                            static IPatchRedirector $redirector_;

                            {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                    iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                                }
                            }

                            @Override // android.widget.PopupMenu.OnMenuItemClickListener
                            public boolean onMenuItemClick(MenuItem menuItem) {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                    return ((Boolean) iPatchRedirector3.redirect((short) 2, (Object) this, (Object) menuItem)).booleanValue();
                                }
                                CharSequence title = menuItem.getTitle();
                                if (title.equals("0.25\u500d\u901f")) {
                                    VideoControllerView.this.mPlayer.setRate(0.25f);
                                    return false;
                                }
                                if (title.equals("0.5\u500d\u901f")) {
                                    VideoControllerView.this.mPlayer.setRate(0.5f);
                                    return false;
                                }
                                if (title.equals("\u6b63\u5e38")) {
                                    VideoControllerView.this.mPlayer.setRate(1.0f);
                                    return false;
                                }
                                if (title.equals("1.5\u500d\u901f")) {
                                    VideoControllerView.this.mPlayer.setRate(1.5f);
                                    return false;
                                }
                                if (title.equals("2.0\u500d\u901f")) {
                                    VideoControllerView.this.mPlayer.setRate(2.0f);
                                    return false;
                                }
                                return false;
                            }
                        });
                        popupMenu.show();
                        this.currentDownCount = 0;
                    }
                }
                return false;
            }
        });
        this.mCurrentTime.setAlpha(0.8f);
        this.mVideoOrigin = (ImageButton) view.findViewById(this.playerResources.getViewId(579));
        this.mVideoDanmakuSwitch = (ImageButton) view.findViewById(this.playerResources.getViewId(580));
    }

    public boolean isShowing() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        return this.mShowing;
    }

    protected View makeControllerView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (View) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        View inflate = ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(this.playerResources.getLayoutId(2), (ViewGroup) null);
        this.mRoot = inflate;
        initControllerView(inflate);
        return this.mRoot;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            super.onDetachedFromWindow();
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.onFinishInflate();
        View view = this.mRoot;
        if (view != null) {
            initControllerView(view);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this, (Object) motionEvent)).booleanValue();
        }
        show(sDefaultTimeout);
        return true;
    }

    @Override // android.view.View
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this, (Object) motionEvent)).booleanValue();
        }
        show(sDefaultTimeout);
        return false;
    }

    public void postSetProgress() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.sendEmptyMessage(3);
        }
    }

    public void resetDraggingState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this);
        } else {
            this.mDragging = false;
        }
    }

    public void setAnchorView(ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) viewGroup);
            return;
        }
        this.mAnchor = viewGroup;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        removeAllViews();
        addView(makeControllerView(), layoutParams);
    }

    public void setCurrentStreamName(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) str);
        } else {
            this.currentStringName = str;
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, z16);
            return;
        }
        ProgressBar progressBar = this.mProgress;
        if (progressBar != null) {
            progressBar.setEnabled(z16);
        }
        disableUnsupportedButtons();
        super.setEnabled(z16);
    }

    public void setFullscreenButtonVisible(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, i3);
            return;
        }
        ImageButton imageButton = this.mFullscreenButton;
        if (imageButton != null) {
            imageButton.setVisibility(i3);
        }
    }

    public void setMediaPlayer(MediaPlayerControl mediaPlayerControl) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) mediaPlayerControl);
            return;
        }
        this.mPlayer = mediaPlayerControl;
        if (mediaPlayerControl != null) {
            updatePausePlay();
            updateFullScreen();
            updateLandscapeIndicator();
        }
    }

    public void setSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) onSeekBarChangeListener);
        } else {
            this.mSeekBarChangeListener = onSeekBarChangeListener;
        }
    }

    public void setSeekBarrier(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, i3);
        } else {
            this.seekBarrier = i3;
        }
    }

    public void show() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) {
            show(sDefaultTimeout);
        } else {
            iPatchRedirector.redirect((short) 12, (Object) this);
        }
    }

    public void updateFullScreen() {
        MediaPlayerControl mediaPlayerControl;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
            return;
        }
        if (this.mRoot != null && this.mFullscreenButton != null && (mediaPlayerControl = this.mPlayer) != null) {
            if (mediaPlayerControl.isFullScreen()) {
                if (this.curFullscreenButtonDrawableRes != 1098) {
                    this.mFullscreenButton.setImageResource(this.playerResources.getDrawableId(1098));
                    this.curFullscreenButtonDrawableRes = 1098;
                    return;
                } else {
                    this.mFullscreenButton.setImageResource(this.playerResources.getDrawableId(1098));
                    return;
                }
            }
            if (this.curFullscreenButtonDrawableRes != 1099) {
                this.mFullscreenButton.setImageResource(this.playerResources.getDrawableId(1099));
                this.curFullscreenButtonDrawableRes = 1099;
            } else {
                this.mFullscreenButton.setImageResource(this.playerResources.getDrawableId(1099));
            }
        }
    }

    public void updateLandscapeIndicator() {
        MediaPlayerControl mediaPlayerControl;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
            return;
        }
        if (this.mRoot != null && this.mSwitchLandscapeButton != null && (mediaPlayerControl = this.mPlayer) != null) {
            if (mediaPlayerControl.isLandscape()) {
                if (this.curLandscapeButtonDrawableRes != 1097) {
                    this.mSwitchLandscapeButton.setImageResource(this.playerResources.getDrawableId(1097));
                    this.curLandscapeButtonDrawableRes = 1097;
                    return;
                }
                return;
            }
            if (this.curLandscapeButtonDrawableRes != 1096) {
                this.mSwitchLandscapeButton.setImageResource(this.playerResources.getDrawableId(1096));
                this.curLandscapeButtonDrawableRes = 1096;
            }
        }
    }

    public void updatePausePlay() {
        MediaPlayerControl mediaPlayerControl;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
        } else if (this.mRoot != null && (mediaPlayerControl = this.mPlayer) != null) {
            mediaPlayerControl.updatePlayPauseButton();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void updateStreamNameButton() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
        }
    }

    public int setProgress(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this, i3)).intValue();
        }
        MediaPlayerControl mediaPlayerControl = this.mPlayer;
        if (mediaPlayerControl != null && !this.mDragging && !mediaPlayerControl.isLoading()) {
            if (i3 == -1) {
                i3 = this.mPlayer.getCurrentPosition();
            }
            int duration = this.mPlayer.getDuration();
            if (duration > 0) {
                this.mVideoDuration = duration;
            }
            if (duration > 0 && i3 > duration) {
                i3 = duration;
            }
            int i16 = this.seekBarrier;
            r1 = (i16 < 0 || i3 < i16) ? i3 : 0;
            ProgressBar progressBar = this.mProgress;
            if (progressBar != null) {
                if (duration > 0) {
                    progressBar.setProgress((int) ((r1 * 1000) / duration));
                }
                this.mProgress.setSecondaryProgress(this.mPlayer.getBufferPercentage() * 10);
            }
            PlayerUtils.runOnUiThread(new Runnable(r1) { // from class: com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView.2
                static IPatchRedirector $redirector_;
                final /* synthetic */ int val$position2;

                {
                    this.val$position2 = r5;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) VideoControllerView.this, r5);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    VideoControllerView videoControllerView = VideoControllerView.this;
                    if (videoControllerView.mPlayer == null) {
                        return;
                    }
                    if (videoControllerView.mDuration != null) {
                        VideoControllerView videoControllerView2 = VideoControllerView.this;
                        VideoControllerView.this.mDuration.setText(videoControllerView2.mPlayer.time2str(videoControllerView2.mVideoDuration));
                    }
                    if (VideoControllerView.this.mCurrentTime != null) {
                        VideoControllerView.this.mCurrentTime.setText(VideoControllerView.this.mPlayer.time2str(this.val$position2));
                    }
                    VideoControllerView.this.updatePausePlay();
                }
            });
        }
        return r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void show(int i3) {
        FrameLayout.LayoutParams layoutParams;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, i3);
            return;
        }
        if (!this.mShowing && this.mAnchor != null) {
            postSetProgress();
            disableUnsupportedButtons();
            if (this.mAnchor instanceof RelativeLayout) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.addRule(12);
                layoutParams = layoutParams2;
            } else {
                layoutParams = new FrameLayout.LayoutParams(-1, -2, 80);
            }
            this.mAnchor.addView(this, layoutParams);
            this.mShowing = true;
        }
        updatePausePlay();
        updateFullScreen();
        updateLandscapeIndicator();
        updateStreamNameButton();
        this.mHandler.removeMessages(2);
        this.mHandler.sendEmptyMessage(2);
        Message obtainMessage = this.mHandler.obtainMessage(1);
        this.mHandler.removeMessages(1);
        if (i3 != 0) {
            this.mHandler.sendMessageDelayed(obtainMessage, i3);
        }
    }

    public VideoControllerView(Context context, boolean z16, PlayerResources playerResources) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, Boolean.valueOf(z16), playerResources);
            return;
        }
        this.seekBarrier = -1;
        this.mPauseListener = new View.OnClickListener() { // from class: com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) VideoControllerView.this);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) view);
                } else {
                    VideoControllerView.this.doPauseResume();
                    VideoControllerView.this.show(VideoControllerView.sDefaultTimeout);
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        };
        this.mFullscreenListener = new View.OnClickListener() { // from class: com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView.4
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) VideoControllerView.this);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) view);
                } else {
                    VideoControllerView.this.doToggleFullscreen();
                    VideoControllerView.this.show(VideoControllerView.sDefaultTimeout);
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        };
        this.mSwitchLandscapeListener = new View.OnClickListener() { // from class: com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView.5
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) VideoControllerView.this);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) view);
                } else {
                    VideoControllerView.this.doToggleLandscape();
                    VideoControllerView.this.show(VideoControllerView.sDefaultTimeout);
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        };
        this.mSeekListener = new SeekBar.OnSeekBarChangeListener() { // from class: com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView.6
            static IPatchRedirector $redirector_;
            private int mDestProgress;
            private int mStartProgress;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) VideoControllerView.this);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i3, boolean z162) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, this, seekBar, Integer.valueOf(i3), Boolean.valueOf(z162));
                    return;
                }
                if (VideoControllerView.this.mSeekBarChangeListener != null) {
                    VideoControllerView.this.mSeekBarChangeListener.onProgressChanged(seekBar, i3, z162);
                }
                if (VideoControllerView.this.mPlayer == null) {
                    return;
                }
                int progress = seekBar.getProgress();
                this.mDestProgress = progress;
                if (progress >= this.mStartProgress) {
                    if (!VideoControllerView.this.mPlayer.canSeekForward()) {
                        return;
                    }
                } else if (!VideoControllerView.this.mPlayer.canSeekBackward()) {
                    return;
                }
                if (!z162) {
                    return;
                }
                int duration = VideoControllerView.this.mPlayer.getDuration();
                if (duration > 0) {
                    VideoControllerView.this.mVideoDuration = duration;
                }
                long j3 = (duration * i3) / 1000;
                if (VideoControllerView.this.mCurrentTime != null) {
                    VideoControllerView.this.mCurrentTime.setText(VideoControllerView.this.mPlayer.time2str((int) j3));
                }
                Set<PlayerCallBack> callbacks = PlayerConfig.g().getCallbacks();
                if (callbacks != null) {
                    for (PlayerCallBack playerCallBack : callbacks) {
                        if (playerCallBack != null) {
                            playerCallBack.onMediaEvent(playerCallBack, PlayerCallBack.EVENT_SEEK_BAR_ON_SEEK, null, null);
                        }
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) seekBar);
                    return;
                }
                if (VideoControllerView.this.mSeekBarChangeListener != null) {
                    VideoControllerView.this.mSeekBarChangeListener.onStartTrackingTouch(seekBar);
                }
                this.mStartProgress = seekBar.getProgress();
                if (PlayerConfig.g().getVideoReporter() != null) {
                    MediaPlayerControl mediaPlayerControl = VideoControllerView.this.mPlayer;
                    if (mediaPlayerControl != null) {
                        PlayerConfig.g().getVideoReporter().progressBarSeekingBegin(PlayerUtils.getVideoUuidFromVideoUrl(mediaPlayerControl.getVideoUriWithUuid()), VideoControllerView.this.mPlayer.getCurrentPosition(), VideoControllerView.this.mPlayer.isPlaying());
                    } else {
                        PlayerConfig.g().getVideoReporter().progressBarSeekingBegin(null, -1L, false);
                    }
                }
                Set<PlayerCallBack> callbacks = PlayerConfig.g().getCallbacks();
                if (callbacks != null) {
                    for (PlayerCallBack playerCallBack : callbacks) {
                        playerCallBack.onMediaEvent(playerCallBack, PlayerCallBack.EVENT_SEEK_BAR_START_SEEK, null, null);
                    }
                }
                VideoControllerView.this.show(3600000);
                VideoControllerView.this.mDragging = true;
                VideoControllerView.this.mHandler.removeMessages(2);
            }

            /* JADX WARN: Removed duplicated region for block: B:23:0x0088  */
            /* JADX WARN: Removed duplicated region for block: B:31:0x00c5  */
            /* JADX WARN: Removed duplicated region for block: B:42:0x0154  */
            /* JADX WARN: Removed duplicated region for block: B:49:0x0119  */
            /* JADX WARN: Removed duplicated region for block: B:51:0x00e0  */
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onStopTrackingTouch(SeekBar seekBar) {
                int duration;
                int progress;
                long j3;
                Set<PlayerCallBack> callbacks;
                EventCollector.getInstance().onStopTrackingTouchBefore(seekBar);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    iPatchRedirector2.redirect((short) 4, (Object) this, (Object) seekBar);
                } else {
                    if (VideoControllerView.this.mSeekBarChangeListener != null) {
                        VideoControllerView.this.mSeekBarChangeListener.onStopTrackingTouch(seekBar);
                    }
                    if (VideoControllerView.this.isShowing()) {
                        VideoControllerView videoControllerView = VideoControllerView.this;
                        if (videoControllerView.mPlayer != null) {
                            videoControllerView.mDragging = false;
                            if (this.mDestProgress >= this.mStartProgress) {
                                if (!VideoControllerView.this.mPlayer.canSeekForward()) {
                                    VideoControllerView.this.mProgress.setProgress(this.mStartProgress);
                                    PlayerUtils.log(5, VideoControllerView.TAG, "seekforward is not possible");
                                }
                                duration = VideoControllerView.this.mPlayer.getDuration();
                                if (duration > 0) {
                                    VideoControllerView.this.mVideoDuration = duration;
                                }
                                progress = seekBar.getProgress();
                                if (PlayerConfig.g().getVideoReporter() != null && seekBar.getMax() > 0) {
                                    PlayerConfig.g().getVideoReporter().progressBarSeekingEnd(PlayerUtils.getVideoUuidFromVideoUrl(VideoControllerView.this.mPlayer.getVideoUriWithUuid()), (duration * progress) / seekBar.getMax());
                                }
                                if (progress != seekBar.getMax()) {
                                    if (duration > 0) {
                                        j3 = duration + LightConstants.ErrorCode.SDK_VERSION_NOT_SUPPORT;
                                        int max = (int) ((((float) j3) / duration) * seekBar.getMax());
                                        ProgressBar progressBar = VideoControllerView.this.mProgress;
                                        if (progressBar != null) {
                                            progressBar.setProgress(max);
                                        }
                                    } else {
                                        j3 = duration;
                                    }
                                } else {
                                    j3 = (duration * progress) / 1000;
                                }
                                if (VideoControllerView.this.seekBarrier < 0 && j3 >= VideoControllerView.this.seekBarrier) {
                                    VideoControllerView.this.mPlayer.seekTo(0);
                                    VideoControllerView.this.mPlayer.pause();
                                } else {
                                    int i36 = (int) j3;
                                    VideoControllerView.this.mPlayer.seekTo(i36);
                                    if (VideoControllerView.this.mCurrentTime != null) {
                                        VideoControllerView.this.mCurrentTime.setText(VideoControllerView.this.mPlayer.time2str(i36));
                                    }
                                }
                                VideoControllerView.this.postSetProgress();
                                VideoControllerView.this.updatePausePlay();
                                VideoControllerView.this.show(VideoControllerView.sDefaultTimeout);
                                VideoControllerView.this.mHandler.removeMessages(2);
                                VideoControllerView.this.mHandler.sendEmptyMessage(2);
                                callbacks = PlayerConfig.g().getCallbacks();
                                if (callbacks != null) {
                                    for (PlayerCallBack playerCallBack : callbacks) {
                                        playerCallBack.onMediaEvent(playerCallBack, PlayerCallBack.EVENT_SEEK_BAR_STOP_SEEK, null, null);
                                    }
                                }
                            } else {
                                if (!VideoControllerView.this.mPlayer.canSeekBackward()) {
                                    VideoControllerView.this.mProgress.setProgress(this.mStartProgress);
                                    PlayerUtils.log(5, VideoControllerView.TAG, "seekbackward is not possible");
                                }
                                duration = VideoControllerView.this.mPlayer.getDuration();
                                if (duration > 0) {
                                }
                                progress = seekBar.getProgress();
                                if (PlayerConfig.g().getVideoReporter() != null) {
                                    PlayerConfig.g().getVideoReporter().progressBarSeekingEnd(PlayerUtils.getVideoUuidFromVideoUrl(VideoControllerView.this.mPlayer.getVideoUriWithUuid()), (duration * progress) / seekBar.getMax());
                                }
                                if (progress != seekBar.getMax()) {
                                }
                                if (VideoControllerView.this.seekBarrier < 0) {
                                }
                                int i362 = (int) j3;
                                VideoControllerView.this.mPlayer.seekTo(i362);
                                if (VideoControllerView.this.mCurrentTime != null) {
                                }
                                VideoControllerView.this.postSetProgress();
                                VideoControllerView.this.updatePausePlay();
                                VideoControllerView.this.show(VideoControllerView.sDefaultTimeout);
                                VideoControllerView.this.mHandler.removeMessages(2);
                                VideoControllerView.this.mHandler.sendEmptyMessage(2);
                                callbacks = PlayerConfig.g().getCallbacks();
                                if (callbacks != null) {
                                }
                            }
                        }
                    }
                }
                EventCollector.getInstance().onStopTrackingTouch(seekBar);
            }
        };
        this.mContext = context;
        this.playerResources = playerResources;
        maybeInitHandlerThread();
        initHandler();
    }

    public VideoControllerView(Context context, PlayerResources playerResources) {
        this(context, true, playerResources);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) playerResources);
    }
}
