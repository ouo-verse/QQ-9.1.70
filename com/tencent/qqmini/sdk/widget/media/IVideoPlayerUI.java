package com.tencent.qqmini.sdk.widget.media;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.widget.VideoGestureRelativeLayout;

/* loaded from: classes23.dex */
public interface IVideoPlayerUI {
    void changeState();

    void fullScreen(MiniAppVideoConfig miniAppVideoConfig, IMiniAppContext iMiniAppContext, boolean z16, String str);

    MiniAppVideoController getController();

    int getGestureProgress();

    boolean getIsBarrageOn();

    int getPlayerViewHeight();

    int getPlayerViewWidth();

    int getStatusImgVisibility();

    FrameLayout getUI();

    void hideControllerPopContainer();

    void hideLoadingView();

    void hidePlayerStatusImg();

    void hideVideoPosterImg();

    void onBrightnessGesture(MiniAppVideoConfig miniAppVideoConfig, MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17);

    void onCaptureImageSucceed(Canvas canvas);

    void onDoubleTapGesture(MiniAppVideoConfig miniAppVideoConfig, boolean z16);

    void onDown(int i3, int i16);

    void onEndFF_REW(MotionEvent motionEvent);

    void onProgressChanged(String str);

    void onProgressGesture(MiniAppVideoConfig miniAppVideoConfig, MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17);

    void onSingleTapGesture(MiniAppVideoConfig miniAppVideoConfig, MotionEvent motionEvent);

    void onStartTrackingTouch(MiniAppVideoConfig miniAppVideoConfig);

    void onStopTrackingTouch(MiniAppVideoConfig miniAppVideoConfig);

    void onVolumeGesture(MiniAppVideoConfig miniAppVideoConfig, MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17, int i3, AudioManager audioManager);

    void performClickControlBtn();

    void release();

    void resetBarrageDrawable(MiniAppVideoConfig miniAppVideoConfig);

    void resetControlIvDrawable(boolean z16);

    void resetMuteImage(MiniAppVideoConfig miniAppVideoConfig, boolean z16);

    void resetWindowIvDrawable(MiniAppVideoConfig miniAppVideoConfig);

    void setController(MiniAppVideoController miniAppVideoController);

    void setPoster(Bitmap bitmap);

    void setPoster(Drawable drawable);

    void setProgressByPlayingTime(long j3, long j16);

    void setSeekBarGone();

    void setSeekBarInvisible();

    void setSeekBarVisible();

    void setUpUI(View.OnClickListener onClickListener, VideoGestureRelativeLayout.VideoGestureListener videoGestureListener, SeekBar.OnSeekBarChangeListener onSeekBarChangeListener);

    void setUpVideoView(View view, MiniAppVideoConfig miniAppVideoConfig);

    void setVideoPauseImg();

    void showBarrageNextTime(String str, int i3);

    void showLoadingView();

    void showPopCtrViewNoAutoHide(MiniAppVideoConfig miniAppVideoConfig);

    void showPopCtrViewThenAutoHide(MiniAppVideoConfig miniAppVideoConfig);

    void smallScreen(IMiniAppContext iMiniAppContext, MiniAppVideoConfig miniAppVideoConfig);

    void updateCenterBtn(MiniAppVideoConfig miniAppVideoConfig);

    void updateControllerView(MiniAppVideoConfig miniAppVideoConfig);

    void updateDanmuTime(long j3);

    void updateDanmuView(MiniAppVideoConfig miniAppVideoConfig);

    void updatePlayingTime(String str);

    void updatePopCtrView(MiniAppVideoConfig miniAppVideoConfig, boolean z16);

    void updateTotalTimeText(String str);

    void updateVideoGestureSetting(MiniAppVideoConfig miniAppVideoConfig);

    void updateVideoPosition(MiniAppVideoConfig miniAppVideoConfig, boolean z16);
}
