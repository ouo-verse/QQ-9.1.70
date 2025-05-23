package com.tencent.qqmini.sdk.widget.media;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqmini.sdk.R;
import com.tencent.qqmini.sdk.action.GetPageIntAction;
import com.tencent.qqmini.sdk.action.GetPageStringAction;
import com.tencent.qqmini.sdk.action.SetViewVisibilityAction;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.WindowInfo;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.launcher.utils.LiuHaiUtils;
import com.tencent.qqmini.sdk.launcher.widget.VideoGestureRelativeLayout;
import com.tencent.qqmini.sdk.utils.ImmersiveUtils;
import com.tencent.qqmini.sdk.widget.media.danmu.Barrage;
import com.tencent.qqmini.sdk.widget.media.danmu.BarrageView;
import java.lang.ref.WeakReference;

/* loaded from: classes23.dex */
public class IVideoPlayerUIImpl extends FrameLayout implements IVideoPlayerUI, Handler.Callback {
    private static final String TAG = "IVideoPlayerUIImpl";
    private ImageView barrageIv;
    private ImageView bottomControlIv;
    private float brightness;
    private ImageView centerControlIv;
    private TextView centerSeekTv;
    private int componentLayoutScrollY;
    private LinearLayout controlBar;
    private MiniAppVideoController controller;
    private RelativeLayout controllerPopContainer;
    private BarrageView danmuView;
    private ImageView fullScreenBackIv;
    private ImageView fullScreenIv;
    private TextView fullScreenTitleTv;
    private final Handler handler;
    private boolean hasSetUp;
    private boolean isChangingProgress;
    private int lastNavBarVisibility;
    private int lastTabBarVisibility;
    private RelativeLayout loadingContainer;
    private WeakReference<Activity> mActivityRef;
    private WindowManager.LayoutParams mLayoutParams;
    private VideoGestureLayout mVideoGestureLayout;
    private Window mWindow;
    private ImageView muteIv;
    private int newProgress;
    private TextView nowTimeTv;
    private int oldProgress;
    private int oldVolume;
    private FrameLayout playerPopContainer;
    private SeekBar playerSeekBar;
    private View playerView;
    private ViewGroup.LayoutParams smallLayoutParams;
    private TextView totalTimeTv;
    private FrameLayout videoActionContainer;
    private VideoGestureRelativeLayout videoGestureRelativeLayout;
    private ImageView videoPosterImg;
    private ImageView videoStatusImg;
    private View videoView;

    public IVideoPlayerUIImpl(@NonNull WeakReference<Activity> weakReference) {
        super(weakReference.get());
        this.handler = new Handler(Looper.getMainLooper(), this);
        this.hasSetUp = false;
        this.isChangingProgress = true;
        this.brightness = 1.0f;
        this.newProgress = 0;
        this.oldProgress = 0;
        this.oldVolume = 0;
        this.lastNavBarVisibility = 8;
        this.lastTabBarVisibility = 8;
        this.componentLayoutScrollY = 0;
        this.mActivityRef = weakReference;
    }

    private void enterFullScreenMode(Activity activity) {
        activity.getWindow().getDecorView().getSystemUiVisibility();
        activity.getWindow().getDecorView().setSystemUiVisibility(5894 | 2048);
    }

    private void hidePopCtrView() {
        Message obtain = Message.obtain();
        obtain.what = 2003;
        this.handler.sendMessageDelayed(obtain, 500L);
    }

    private void initDanmuView(MiniAppVideoConfig miniAppVideoConfig) {
        if (miniAppVideoConfig.isShowBasicControl && miniAppVideoConfig.enableDanmu) {
            this.danmuView = new BarrageView(this.mActivityRef.get(), null);
            addView(this.danmuView, new FrameLayout.LayoutParams(-1, -1));
            this.danmuView.setBarrages(miniAppVideoConfig.barrages);
        }
    }

    private boolean isActivityRefValid() {
        WeakReference<Activity> weakReference = this.mActivityRef;
        if (weakReference != null && weakReference.get() != null) {
            return true;
        }
        return false;
    }

    private void resetOrientationForSmallScreen(Activity activity, IMiniAppContext iMiniAppContext) {
        int i3;
        String pageOrientation = GetPageStringAction.obtain(iMiniAppContext).getPageOrientation();
        if (WindowInfo.ORIENTATION_AUTO.equals(pageOrientation)) {
            i3 = 4;
        } else if (WindowInfo.ORIENTATION_LANDSCAPE.equals(pageOrientation)) {
            i3 = 0;
        } else {
            i3 = 1;
        }
        activity.setRequestedOrientation(i3);
    }

    private void resetStatusbarForSmallScreen(Activity activity, IMiniAppContext iMiniAppContext) {
        if (!iMiniAppContext.isMiniGame()) {
            activity.getWindow().getDecorView().setSystemUiVisibility(1024);
            try {
                int naviBarTextStyle = GetPageIntAction.obtain(iMiniAppContext).getNaviBarTextStyle();
                if (naviBarTextStyle == -1) {
                    ImmersiveUtils.setStatusTextColor(false, activity.getWindow());
                } else if (naviBarTextStyle == -16777216) {
                    ImmersiveUtils.setStatusTextColor(true, activity.getWindow());
                }
            } catch (Exception e16) {
                QMLog.e(TAG, "smallScreen: ", e16);
            }
        }
    }

    private void setOrientationForFullScreen(MiniAppVideoConfig miniAppVideoConfig, Activity activity, boolean z16) {
        int i3;
        if (z16) {
            int i16 = miniAppVideoConfig.direction;
            if (i16 != -90 && i16 != 270) {
                i3 = 0;
            } else {
                i3 = 8;
            }
        } else {
            int i17 = miniAppVideoConfig.direction;
            if (i17 != 180 && i17 != -180) {
                i3 = 1;
            } else {
                i3 = 9;
            }
        }
        activity.setRequestedOrientation(i3);
    }

    private void updateVideoViewPosition(IMiniAppContext iMiniAppContext, boolean z16) {
        int i3;
        int i16;
        if (isActivityRefValid()) {
            LiuHaiUtils.initLiuHaiProperty(this.mActivityRef.get());
            i3 = LiuHaiUtils.getNotchInScreenHeight(this.mActivityRef.get());
        } else {
            i3 = 0;
        }
        int realHeight = DisplayUtil.getRealHeight(getContext());
        if (!z16 && LiuHaiUtils.sHasNotch) {
            realHeight -= i3;
        }
        int screenWidth = DisplayUtil.getScreenWidth(getContext());
        if (z16) {
            i16 = realHeight;
        } else {
            i16 = screenWidth;
        }
        if (z16) {
            realHeight = screenWidth;
        }
        if (iMiniAppContext != null && iMiniAppContext.isMiniGame()) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i16, realHeight);
            layoutParams.leftMargin = 0;
            layoutParams.topMargin = 0;
            ((CoverVideoView) getParent()).setLayoutParams(layoutParams);
            return;
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i16, realHeight);
        layoutParams2.leftMargin = 0;
        layoutParams2.topMargin = 0;
        ((CoverVideoView) getParent()).setLayoutParams(layoutParams2);
    }

    @Override // com.tencent.qqmini.sdk.widget.media.IVideoPlayerUI
    public void changeState() {
        this.bottomControlIv.performClick();
    }

    @Override // com.tencent.qqmini.sdk.widget.media.IVideoPlayerUI
    public void fullScreen(MiniAppVideoConfig miniAppVideoConfig, IMiniAppContext iMiniAppContext, boolean z16, String str) {
        if (!isActivityRefValid()) {
            QMLog.e(TAG, "fullScreen ActivityRef is invalid!");
            return;
        }
        this.fullScreenBackIv.setVisibility(0);
        this.fullScreenTitleTv.setVisibility(0);
        if (miniAppVideoConfig.hideTimeDesc) {
            this.totalTimeTv.setVisibility(0);
            this.nowTimeTv.setVisibility(0);
            this.playerSeekBar.setVisibility(0);
            this.totalTimeTv.setText(str);
        }
        if (iMiniAppContext != null) {
            this.lastNavBarVisibility = GetPageIntAction.obtain(iMiniAppContext).getNaviBarVisibility();
            this.lastTabBarVisibility = GetPageIntAction.obtain(iMiniAppContext).getTabBarVisibility();
            SetViewVisibilityAction.obtain(iMiniAppContext).setNaviBarVisibility(8);
            SetViewVisibilityAction.obtain(iMiniAppContext).setTabBarVisibility(8);
        }
        this.smallLayoutParams = ((CoverVideoView) getParent()).getLayoutParams();
        if (getParent().getParent() != null) {
            this.componentLayoutScrollY = ((ViewGroup) getParent().getParent()).getScrollY();
            ((ViewGroup) getParent().getParent()).scrollTo(0, 0);
        }
        updateVideoViewPosition(iMiniAppContext, z16);
        this.mActivityRef.get().getWindow().getDecorView().setSystemUiVisibility(2);
        setOrientationForFullScreen(miniAppVideoConfig, this.mActivityRef.get(), z16);
        enterFullScreenMode(this.mActivityRef.get());
        resetWindowIvDrawable(miniAppVideoConfig);
    }

    @Override // com.tencent.qqmini.sdk.widget.media.IVideoPlayerUI
    public MiniAppVideoController getController() {
        return this.controller;
    }

    @Override // com.tencent.qqmini.sdk.widget.media.IVideoPlayerUI
    public int getGestureProgress() {
        return this.newProgress;
    }

    @Override // com.tencent.qqmini.sdk.widget.media.IVideoPlayerUI
    public boolean getIsBarrageOn() {
        BarrageView barrageView = this.danmuView;
        if (barrageView != null && barrageView.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqmini.sdk.widget.media.IVideoPlayerUI
    public int getPlayerViewHeight() {
        return this.playerView.getHeight();
    }

    @Override // com.tencent.qqmini.sdk.widget.media.IVideoPlayerUI
    public int getPlayerViewWidth() {
        return this.playerView.getWidth();
    }

    @Override // com.tencent.qqmini.sdk.widget.media.IVideoPlayerUI
    public int getStatusImgVisibility() {
        ImageView imageView = this.videoStatusImg;
        if (imageView != null) {
            return imageView.getVisibility();
        }
        return 8;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 2003) {
            this.controllerPopContainer.setVisibility(4);
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqmini.sdk.widget.media.IVideoPlayerUI
    public void hideControllerPopContainer() {
        this.controllerPopContainer.setVisibility(8);
    }

    @Override // com.tencent.qqmini.sdk.widget.media.IVideoPlayerUI
    public void hideLoadingView() {
        this.loadingContainer.setVisibility(8);
    }

    @Override // com.tencent.qqmini.sdk.widget.media.IVideoPlayerUI
    public void hidePlayerStatusImg() {
        this.videoStatusImg.setVisibility(8);
    }

    @Override // com.tencent.qqmini.sdk.widget.media.IVideoPlayerUI
    public void hideVideoPosterImg() {
        this.videoPosterImg.setVisibility(8);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0028, code lost:
    
        if (r1 > 1.0f) goto L9;
     */
    @Override // com.tencent.qqmini.sdk.widget.media.IVideoPlayerUI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onBrightnessGesture(MiniAppVideoConfig miniAppVideoConfig, MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
        WindowManager.LayoutParams layoutParams;
        if (miniAppVideoConfig.pageGesture && !miniAppVideoConfig.isFullScreen) {
            float y16 = ((motionEvent.getY() - motionEvent2.getY()) / this.videoGestureRelativeLayout.getHeight()) + this.brightness;
            float f18 = 0.0f;
            if (y16 >= 0.0f) {
                f18 = 1.0f;
            }
            y16 = f18;
            Window window = this.mWindow;
            if (window != null && (layoutParams = this.mLayoutParams) != null) {
                layoutParams.screenBrightness = y16;
                window.setAttributes(layoutParams);
            }
            this.mVideoGestureLayout.setProgress((int) (y16 * 100.0f));
            this.mVideoGestureLayout.setImageResource(R.drawable.mini_sdk_video_brightness);
            this.mVideoGestureLayout.show();
        }
    }

    @Override // com.tencent.qqmini.sdk.widget.media.IVideoPlayerUI
    public void onCaptureImageSucceed(Canvas canvas) {
        FrameLayout frameLayout = this.playerPopContainer;
        if (frameLayout != null && frameLayout.getVisibility() == 0) {
            this.playerPopContainer.setDrawingCacheEnabled(true);
            this.playerPopContainer.buildDrawingCache();
            this.playerPopContainer.setDrawingCacheEnabled(false);
        }
        FrameLayout frameLayout2 = this.videoActionContainer;
        if (frameLayout2 != null && frameLayout2.getVisibility() == 0) {
            this.videoActionContainer.setDrawingCacheEnabled(true);
            this.videoActionContainer.buildDrawingCache();
            Bitmap drawingCache = this.videoActionContainer.getDrawingCache();
            if (drawingCache != null) {
                canvas.drawBitmap(Bitmap.createBitmap(drawingCache), 0.0f, 0.0f, (Paint) null);
            }
            this.videoActionContainer.setDrawingCacheEnabled(false);
        }
    }

    @Override // com.tencent.qqmini.sdk.widget.media.IVideoPlayerUI
    public void onDoubleTapGesture(MiniAppVideoConfig miniAppVideoConfig, boolean z16) {
        resetControlIvDrawable(z16);
        updatePopCtrView(miniAppVideoConfig, z16);
    }

    @Override // com.tencent.qqmini.sdk.widget.media.IVideoPlayerUI
    public void onDown(int i3, int i16) {
        this.oldProgress = this.newProgress;
        this.oldVolume = i3;
        WindowManager.LayoutParams layoutParams = this.mLayoutParams;
        if (layoutParams != null) {
            this.brightness = layoutParams.screenBrightness;
        }
        if (this.brightness == -1.0f) {
            this.brightness = i16;
        }
    }

    @Override // com.tencent.qqmini.sdk.widget.media.IVideoPlayerUI
    public void onProgressChanged(String str) {
        this.centerSeekTv.setText(str);
        this.nowTimeTv.setText(str);
    }

    @Override // com.tencent.qqmini.sdk.widget.media.IVideoPlayerUI
    public void onProgressGesture(MiniAppVideoConfig miniAppVideoConfig, MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
        if (!miniAppVideoConfig.enableProgressGesture) {
            return;
        }
        float x16 = motionEvent2.getX() - motionEvent.getX();
        if (x16 > 0.0f) {
            this.mVideoGestureLayout.setImageResource(R.drawable.mini_sdk_video_progress_ff);
            int width = (int) (this.oldProgress + ((x16 / this.videoGestureRelativeLayout.getWidth()) * 100.0f));
            this.newProgress = width;
            if (width > 100) {
                this.newProgress = 100;
            }
        } else {
            this.mVideoGestureLayout.setImageResource(R.drawable.mini_sdk_video_progress_fr);
            int width2 = (int) (this.oldProgress + ((x16 / this.videoGestureRelativeLayout.getWidth()) * 100.0f));
            this.newProgress = width2;
            if (width2 < 0) {
                this.newProgress = 0;
            }
        }
        this.mVideoGestureLayout.setProgress(this.newProgress);
        this.mVideoGestureLayout.show();
    }

    @Override // com.tencent.qqmini.sdk.widget.media.IVideoPlayerUI
    public void onSingleTapGesture(MiniAppVideoConfig miniAppVideoConfig, MotionEvent motionEvent) {
        if (this.controllerPopContainer.getVisibility() == 4) {
            showPopCtrViewThenAutoHide(miniAppVideoConfig);
        } else if (this.controllerPopContainer.getVisibility() == 0) {
            hidePopCtrView();
        }
    }

    @Override // com.tencent.qqmini.sdk.widget.media.IVideoPlayerUI
    public void onStartTrackingTouch(MiniAppVideoConfig miniAppVideoConfig) {
        this.isChangingProgress = true;
        this.centerSeekTv.setVisibility(0);
        this.centerSeekTv.setText("");
        showPopCtrViewNoAutoHide(miniAppVideoConfig);
        if (miniAppVideoConfig.showCenterPlayBtn && "center".equals(miniAppVideoConfig.playBtnPosition)) {
            this.centerControlIv.setVisibility(8);
        }
    }

    @Override // com.tencent.qqmini.sdk.widget.media.IVideoPlayerUI
    public void onStopTrackingTouch(MiniAppVideoConfig miniAppVideoConfig) {
        this.isChangingProgress = false;
        this.loadingContainer.setVisibility(0);
        this.centerSeekTv.setVisibility(8);
        showPopCtrViewThenAutoHide(miniAppVideoConfig);
        if (miniAppVideoConfig.showCenterPlayBtn && "center".equals(miniAppVideoConfig.playBtnPosition)) {
            this.centerControlIv.setVisibility(0);
        }
    }

    @Override // com.tencent.qqmini.sdk.widget.media.IVideoPlayerUI
    public void onVolumeGesture(MiniAppVideoConfig miniAppVideoConfig, MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17, int i3, AudioManager audioManager) {
        if (miniAppVideoConfig.pageGesture && !miniAppVideoConfig.isFullScreen && i3 != 0) {
            int y16 = (int) (((motionEvent.getY() - motionEvent2.getY()) / (this.videoGestureRelativeLayout.getHeight() / i3)) + this.oldVolume);
            if (audioManager != null) {
                audioManager.setStreamVolume(3, y16, 4);
            }
            int i16 = (int) ((y16 / i3) * 100.0f);
            if (i16 >= 50) {
                this.mVideoGestureLayout.setImageResource(R.drawable.mini_sdk_video_volume_higher);
            } else if (i16 > 0) {
                this.mVideoGestureLayout.setImageResource(R.drawable.mini_sdk_video_volume_lower);
            } else {
                this.mVideoGestureLayout.setImageResource(R.drawable.mini_sdk_video_volume_off);
            }
            this.mVideoGestureLayout.setProgress(i16);
            this.mVideoGestureLayout.show();
        }
    }

    @Override // com.tencent.qqmini.sdk.widget.media.IVideoPlayerUI
    public void performClickControlBtn() {
        this.bottomControlIv.performClick();
    }

    @Override // com.tencent.qqmini.sdk.widget.media.IVideoPlayerUI
    public void release() {
        BarrageView barrageView = this.danmuView;
        if (barrageView != null) {
            barrageView.destroy();
        }
        this.hasSetUp = false;
        this.mActivityRef = null;
    }

    @Override // com.tencent.qqmini.sdk.widget.media.IVideoPlayerUI
    public void resetBarrageDrawable(MiniAppVideoConfig miniAppVideoConfig) {
        int i3;
        ImageView imageView = this.barrageIv;
        if (miniAppVideoConfig.isBarrageOpen) {
            i3 = R.drawable.mini_sdk_player_barrage_open;
        } else {
            i3 = R.drawable.mini_sdk_player_barrage_close;
        }
        imageView.setImageResource(i3);
    }

    @Override // com.tencent.qqmini.sdk.widget.media.IVideoPlayerUI
    public void resetControlIvDrawable(boolean z16) {
        if (z16) {
            ImageView imageView = this.bottomControlIv;
            int i3 = R.drawable.mini_sdk_player_pause;
            imageView.setImageResource(i3);
            this.centerControlIv.setImageResource(i3);
            return;
        }
        ImageView imageView2 = this.bottomControlIv;
        int i16 = R.drawable.mini_sdk_player_resume;
        imageView2.setImageResource(i16);
        this.centerControlIv.setImageResource(i16);
    }

    @Override // com.tencent.qqmini.sdk.widget.media.IVideoPlayerUI
    public void resetMuteImage(MiniAppVideoConfig miniAppVideoConfig, boolean z16) {
        int i3;
        if (!miniAppVideoConfig.showMuteBtn) {
            this.muteIv.setVisibility(8);
            return;
        }
        ImageView imageView = this.muteIv;
        if (z16) {
            i3 = R.drawable.mini_sdk_video_mute;
        } else {
            i3 = R.drawable.mini_sdk_video_unmute;
        }
        imageView.setImageResource(i3);
        this.muteIv.setVisibility(0);
    }

    @Override // com.tencent.qqmini.sdk.widget.media.IVideoPlayerUI
    public void resetWindowIvDrawable(MiniAppVideoConfig miniAppVideoConfig) {
        int i3;
        ImageView imageView = this.fullScreenIv;
        if (miniAppVideoConfig.isFullScreen) {
            i3 = R.drawable.mini_sdk_player_shrink_back;
        } else {
            i3 = R.drawable.mini_sdk_player_stretch_back;
        }
        imageView.setImageResource(i3);
    }

    @Override // com.tencent.qqmini.sdk.widget.media.IVideoPlayerUI
    public void setController(MiniAppVideoController miniAppVideoController) {
        this.controller = miniAppVideoController;
    }

    @Override // com.tencent.qqmini.sdk.widget.media.IVideoPlayerUI
    public void setPoster(Drawable drawable) {
        ImageView imageView = this.videoPosterImg;
        if (imageView != null) {
            imageView.setVisibility(0);
            this.videoPosterImg.setImageDrawable(drawable);
            this.videoPosterImg.setScaleType(ImageView.ScaleType.FIT_XY);
        }
    }

    @Override // com.tencent.qqmini.sdk.widget.media.IVideoPlayerUI
    public void setProgressByPlayingTime(long j3, long j16) {
        if (j3 == 0) {
            j3 = 1;
        }
        this.playerSeekBar.setProgress((int) ((j16 * r0.getMax()) / j3));
    }

    @Override // com.tencent.qqmini.sdk.widget.media.IVideoPlayerUI
    public void setSeekBarGone() {
        this.totalTimeTv.setVisibility(8);
        this.nowTimeTv.setVisibility(8);
        this.playerSeekBar.setVisibility(8);
    }

    @Override // com.tencent.qqmini.sdk.widget.media.IVideoPlayerUI
    public void setSeekBarInvisible() {
        this.totalTimeTv.setVisibility(4);
        this.nowTimeTv.setVisibility(4);
        this.playerSeekBar.setVisibility(4);
    }

    @Override // com.tencent.qqmini.sdk.widget.media.IVideoPlayerUI
    public void setSeekBarVisible() {
        this.totalTimeTv.setVisibility(0);
        this.nowTimeTv.setVisibility(0);
        this.playerSeekBar.setVisibility(0);
    }

    @Override // com.tencent.qqmini.sdk.widget.media.IVideoPlayerUI
    public void setUpUI(View.OnClickListener onClickListener, VideoGestureRelativeLayout.VideoGestureListener videoGestureListener, SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        if (this.hasSetUp) {
            return;
        }
        if (!isActivityRefValid()) {
            QMLog.e(TAG, "setUpUI ActivityRef is invalid!");
            return;
        }
        this.hasSetUp = true;
        setTag("MiniAppVideoPlayer");
        Window window = this.mActivityRef.get().getWindow();
        this.mWindow = window;
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            this.mLayoutParams = attributes;
            if (attributes != null) {
                this.brightness = attributes.screenBrightness;
            }
        }
        setTag("MiniAppVideoPlayer");
        View inflate = LayoutInflater.from(this.mActivityRef.get()).inflate(R.layout.mini_sdk_player_view, (ViewGroup) null);
        this.playerView = inflate;
        this.videoGestureRelativeLayout = (VideoGestureRelativeLayout) inflate.findViewById(R.id.layout_videolayout);
        this.playerPopContainer = (FrameLayout) this.playerView.findViewById(R.id.video_pop_container);
        this.videoPosterImg = (ImageView) this.playerView.findViewById(R.id.video_img);
        this.videoStatusImg = (ImageView) this.playerView.findViewById(R.id.play_status_img);
        this.controllerPopContainer = (RelativeLayout) this.playerView.findViewById(R.id.video_playing_pop_container);
        this.nowTimeTv = (TextView) this.playerView.findViewById(R.id.video_playing_tv_time_now);
        this.totalTimeTv = (TextView) this.playerView.findViewById(R.id.video_playing_tv_time_total);
        this.bottomControlIv = (ImageView) this.playerView.findViewById(R.id.video_playing_iv_control);
        this.centerControlIv = (ImageView) this.playerView.findViewById(R.id.video_playing_iv_control_center);
        this.controlBar = (LinearLayout) this.playerView.findViewById(R.id.video_playing_control_bar);
        this.fullScreenIv = (ImageView) this.playerView.findViewById(R.id.video_playing_iv_window);
        this.playerSeekBar = (SeekBar) this.playerView.findViewById(R.id.video_playing_bar);
        this.loadingContainer = (RelativeLayout) this.playerView.findViewById(R.id.video_loading_container);
        this.barrageIv = (ImageView) this.playerView.findViewById(R.id.video_playing_iv_barrage);
        this.centerSeekTv = (TextView) this.playerView.findViewById(R.id.video_playing_tv_seek);
        this.fullScreenBackIv = (ImageView) this.playerView.findViewById(R.id.video_playing_iv_back_fullscreen);
        this.fullScreenTitleTv = (TextView) this.playerView.findViewById(R.id.video_playing_tv_title);
        this.muteIv = (ImageView) this.playerView.findViewById(R.id.video_playing_iv_mute);
        this.videoActionContainer = (FrameLayout) this.playerView.findViewById(R.id.video_action_container);
        this.playerSeekBar.getThumb().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
        if (onClickListener != null) {
            this.videoStatusImg.setOnClickListener(onClickListener);
            this.bottomControlIv.setOnClickListener(onClickListener);
            this.centerControlIv.setOnClickListener(onClickListener);
            this.fullScreenIv.setOnClickListener(onClickListener);
            this.barrageIv.setOnClickListener(onClickListener);
            this.fullScreenBackIv.setOnClickListener(onClickListener);
            this.muteIv.setOnClickListener(onClickListener);
        }
        this.mVideoGestureLayout = new VideoGestureLayout(this.mActivityRef.get());
        if (videoGestureListener != null) {
            this.videoGestureRelativeLayout.setVideoGestureListener(videoGestureListener);
        }
        if (onSeekBarChangeListener != null) {
            this.playerSeekBar.setOnSeekBarChangeListener(onSeekBarChangeListener);
        }
        addView(this.playerView);
    }

    @Override // com.tencent.qqmini.sdk.widget.media.IVideoPlayerUI
    public void setUpVideoView(View view, MiniAppVideoConfig miniAppVideoConfig) {
        if (!isActivityRefValid()) {
            QMLog.e(TAG, "setUpVideoView ActivityRef is invalid!");
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.videoView = view;
        view.setLayoutParams(layoutParams);
        this.videoView.setVisibility(0);
        initDanmuView(miniAppVideoConfig);
        this.videoGestureRelativeLayout.removeAllViews();
        this.videoGestureRelativeLayout.addView(this.videoView);
        this.videoGestureRelativeLayout.setBackgroundColor(-16777216);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(DisplayUtil.dip2px(this.mActivityRef.get(), 100.0f), DisplayUtil.dip2px(this.mActivityRef.get(), 100.0f));
        layoutParams2.gravity = 17;
        this.videoGestureRelativeLayout.addView(this.mVideoGestureLayout, layoutParams2);
    }

    @Override // com.tencent.qqmini.sdk.widget.media.IVideoPlayerUI
    public void setVideoPauseImg() {
        ImageView imageView = this.bottomControlIv;
        if (imageView != null) {
            imageView.setImageResource(R.drawable.mini_sdk_player_resume);
        }
        ImageView imageView2 = this.centerControlIv;
        if (imageView2 != null) {
            imageView2.setImageResource(R.drawable.mini_sdk_player_resume);
        }
    }

    @Override // com.tencent.qqmini.sdk.widget.media.IVideoPlayerUI
    public void showBarrageNextTime(String str, int i3) {
        BarrageView barrageView = this.danmuView;
        if (barrageView != null) {
            barrageView.showBarrageNextTime(new Barrage(str, i3, 0L));
        }
    }

    @Override // com.tencent.qqmini.sdk.widget.media.IVideoPlayerUI
    public void showLoadingView() {
        this.loadingContainer.setVisibility(0);
    }

    @Override // com.tencent.qqmini.sdk.widget.media.IVideoPlayerUI
    public void showPopCtrViewNoAutoHide(MiniAppVideoConfig miniAppVideoConfig) {
        if (miniAppVideoConfig.isShowBasicControl) {
            int i3 = 0;
            this.controllerPopContainer.setVisibility(0);
            LinearLayout linearLayout = this.controlBar;
            if (!miniAppVideoConfig.isShowControlBar) {
                i3 = 8;
            }
            linearLayout.setVisibility(i3);
        } else {
            this.controllerPopContainer.setVisibility(4);
        }
        this.handler.removeMessages(2003);
    }

    @Override // com.tencent.qqmini.sdk.widget.media.IVideoPlayerUI
    public void showPopCtrViewThenAutoHide(MiniAppVideoConfig miniAppVideoConfig) {
        showPopCtrViewNoAutoHide(miniAppVideoConfig);
        Message obtain = Message.obtain();
        obtain.what = 2003;
        this.handler.sendMessageDelayed(obtain, 5000L);
    }

    @Override // com.tencent.qqmini.sdk.widget.media.IVideoPlayerUI
    public void smallScreen(IMiniAppContext iMiniAppContext, final MiniAppVideoConfig miniAppVideoConfig) {
        if (!miniAppVideoConfig.isBusyInChangeScreen && miniAppVideoConfig.isFullScreen) {
            if (!isActivityRefValid()) {
                QMLog.e(TAG, "smallScreen ActivityRef is invalid!");
                return;
            }
            miniAppVideoConfig.isFullScreen = false;
            this.fullScreenBackIv.setVisibility(8);
            this.fullScreenTitleTv.setVisibility(8);
            if (miniAppVideoConfig.hideTimeDesc) {
                this.totalTimeTv.setVisibility(8);
                this.nowTimeTv.setVisibility(8);
                this.playerSeekBar.setVisibility(8);
            }
            if (iMiniAppContext != null) {
                SetViewVisibilityAction.obtain(iMiniAppContext).setNaviBarVisibility(this.lastNavBarVisibility);
                SetViewVisibilityAction.obtain(iMiniAppContext).setTabBarVisibility(this.lastTabBarVisibility);
            }
            this.mActivityRef.get().getWindow().clearFlags(1024);
            if (iMiniAppContext != null) {
                resetOrientationForSmallScreen(this.mActivityRef.get(), iMiniAppContext);
                resetStatusbarForSmallScreen(this.mActivityRef.get(), iMiniAppContext);
            }
            miniAppVideoConfig.lastSmallScreenTime = System.currentTimeMillis();
            miniAppVideoConfig.isBusyInChangeScreen = true;
            this.handler.postDelayed(new Runnable() { // from class: com.tencent.qqmini.sdk.widget.media.IVideoPlayerUIImpl.1
                @Override // java.lang.Runnable
                public void run() {
                    ((CoverVideoView) IVideoPlayerUIImpl.this.getParent()).setLayoutParams(IVideoPlayerUIImpl.this.smallLayoutParams);
                    if (IVideoPlayerUIImpl.this.getParent().getParent() != null) {
                        ((ViewGroup) IVideoPlayerUIImpl.this.getParent().getParent()).scrollTo(0, IVideoPlayerUIImpl.this.componentLayoutScrollY);
                    }
                    miniAppVideoConfig.isBusyInChangeScreen = false;
                }
            }, 200L);
            resetWindowIvDrawable(miniAppVideoConfig);
        }
    }

    @Override // com.tencent.qqmini.sdk.widget.media.IVideoPlayerUI
    public void updateCenterBtn(MiniAppVideoConfig miniAppVideoConfig) {
        if (miniAppVideoConfig.showCenterPlayBtn) {
            this.videoStatusImg.setVisibility(0);
            this.videoPosterImg.setVisibility(0);
        } else {
            this.videoStatusImg.setVisibility(8);
            this.videoPosterImg.setVisibility(8);
        }
    }

    @Override // com.tencent.qqmini.sdk.widget.media.IVideoPlayerUI
    public void updateControllerView(MiniAppVideoConfig miniAppVideoConfig) {
        int i3;
        ImageView imageView = this.barrageIv;
        int i16 = 0;
        if (imageView != null) {
            if (miniAppVideoConfig.showDanmuBtn) {
                i3 = 0;
            } else {
                i3 = 4;
            }
            imageView.setVisibility(i3);
        }
        if ("center".equals(miniAppVideoConfig.playBtnPosition)) {
            ImageView imageView2 = this.centerControlIv;
            if (!miniAppVideoConfig.showCenterPlayBtn) {
                i16 = 8;
            }
            imageView2.setVisibility(i16);
            this.bottomControlIv.setVisibility(8);
        } else {
            this.centerControlIv.setVisibility(8);
            this.bottomControlIv.setVisibility(0);
        }
        if (!TextUtils.isEmpty(miniAppVideoConfig.title)) {
            this.fullScreenTitleTv.setText(miniAppVideoConfig.title);
        }
    }

    @Override // com.tencent.qqmini.sdk.widget.media.IVideoPlayerUI
    public void updateDanmuTime(long j3) {
        BarrageView barrageView = this.danmuView;
        if (barrageView != null) {
            barrageView.updateTime(j3);
        }
    }

    @Override // com.tencent.qqmini.sdk.widget.media.IVideoPlayerUI
    public void updateDanmuView(MiniAppVideoConfig miniAppVideoConfig) {
        BarrageView barrageView = this.danmuView;
        if (barrageView != null) {
            if (miniAppVideoConfig.isBarrageOpen) {
                barrageView.setVisibility(4);
                miniAppVideoConfig.isBarrageOpen = false;
            } else {
                barrageView.setVisibility(0);
                miniAppVideoConfig.isBarrageOpen = true;
            }
        }
    }

    @Override // com.tencent.qqmini.sdk.widget.media.IVideoPlayerUI
    public void updatePlayingTime(String str) {
        this.nowTimeTv.setText(str);
    }

    @Override // com.tencent.qqmini.sdk.widget.media.IVideoPlayerUI
    public void updatePopCtrView(MiniAppVideoConfig miniAppVideoConfig, boolean z16) {
        if (z16) {
            showPopCtrViewThenAutoHide(miniAppVideoConfig);
        } else {
            showPopCtrViewNoAutoHide(miniAppVideoConfig);
        }
    }

    @Override // com.tencent.qqmini.sdk.widget.media.IVideoPlayerUI
    public void updateTotalTimeText(String str) {
        this.totalTimeTv.setText(str);
    }

    @Override // com.tencent.qqmini.sdk.widget.media.IVideoPlayerUI
    public void updateVideoGestureSetting(MiniAppVideoConfig miniAppVideoConfig) {
        VideoGestureRelativeLayout videoGestureRelativeLayout = this.videoGestureRelativeLayout;
        if (videoGestureRelativeLayout != null) {
            videoGestureRelativeLayout.setEnablePageGesture(miniAppVideoConfig.pageGesture);
            this.videoGestureRelativeLayout.setEnableProgressGesture(miniAppVideoConfig.enableProgressGesture);
            this.videoGestureRelativeLayout.setEnablePlayGesture(miniAppVideoConfig.enablePlayGesture);
        }
    }

    @Override // com.tencent.qqmini.sdk.widget.media.IVideoPlayerUI
    public void updateVideoPosition(MiniAppVideoConfig miniAppVideoConfig, boolean z16) {
        if (!isActivityRefValid()) {
            QMLog.e(TAG, "updateVideoPosition ActivityRef is invalid!");
            return;
        }
        Activity activity = this.mActivityRef.get();
        if (!miniAppVideoConfig.isFullScreen) {
            if (z16) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(DisplayUtil.dip2px(activity, miniAppVideoConfig.videoWidth), DisplayUtil.dip2px(activity, miniAppVideoConfig.videoHeight));
                layoutParams.leftMargin = DisplayUtil.dip2px(activity, miniAppVideoConfig.videoX);
                layoutParams.topMargin = DisplayUtil.dip2px(activity, miniAppVideoConfig.videoY);
                ((CoverVideoView) getParent()).setLayoutParams(layoutParams);
                return;
            }
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(DisplayUtil.dip2px(activity, miniAppVideoConfig.videoWidth), DisplayUtil.dip2px(activity, miniAppVideoConfig.videoHeight));
            layoutParams2.leftMargin = DisplayUtil.dip2px(activity, miniAppVideoConfig.videoX);
            layoutParams2.topMargin = DisplayUtil.dip2px(activity, miniAppVideoConfig.videoY);
            ((CoverVideoView) getParent()).setLayoutParams(layoutParams2);
        }
    }

    @Override // com.tencent.qqmini.sdk.widget.media.IVideoPlayerUI
    public void setPoster(Bitmap bitmap) {
        ImageView imageView = this.videoPosterImg;
        if (imageView != null) {
            imageView.setImageBitmap(bitmap);
        }
    }

    public IVideoPlayerUIImpl(@NonNull WeakReference<Activity> weakReference, @Nullable AttributeSet attributeSet) {
        super(weakReference.get(), attributeSet);
        this.handler = new Handler(Looper.getMainLooper(), this);
        this.hasSetUp = false;
        this.isChangingProgress = true;
        this.brightness = 1.0f;
        this.newProgress = 0;
        this.oldProgress = 0;
        this.oldVolume = 0;
        this.lastNavBarVisibility = 8;
        this.lastTabBarVisibility = 8;
        this.componentLayoutScrollY = 0;
        this.mActivityRef = weakReference;
    }

    @Override // com.tencent.qqmini.sdk.widget.media.IVideoPlayerUI
    public FrameLayout getUI() {
        return this;
    }

    @Override // com.tencent.qqmini.sdk.widget.media.IVideoPlayerUI
    public void onEndFF_REW(MotionEvent motionEvent) {
    }
}
