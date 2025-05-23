package com.tencent.ams.fusion.widget.olympic2024.floating;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.fusion.widget.alphaplayer.AlphaPlayer;
import com.tencent.ams.fusion.widget.alphaplayer.AlphaVideoView;
import com.tencent.ams.fusion.widget.alphaplayer.PlayInfo;
import com.tencent.ams.fusion.widget.alphaplayer.gl.FormatType;
import com.tencent.ams.fusion.widget.alphaplayer.gl.ScaleType;
import com.tencent.ams.fusion.widget.utils.Logger;
import com.tencent.ams.fusion.widget.utils.NetworkResLoader;
import com.tencent.ams.fusion.widget.utils.Utils;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import java.io.File;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes3.dex */
public class OlympicFloatingVideoView extends FrameLayout implements AlphaPlayer.AlphaPlayerListener {
    static IPatchRedirector $redirector_ = null;
    private static final String CLOSE_AD = "\u5173\u95ed\u5e7f\u544a";
    private static final int MSG_HIDE_ANIM_END = 2;
    private static final int MSG_UPDATE_COUNTDOWN = 0;
    private static final int MSG_VIDEO_PLAY_COMPLETE = 1;
    private static final int NOT_SET = -1;
    private static final String TAG = "OlympicFloatingVideoView";
    private int mClickBottomPaddingRatio;
    private int mClickDelayMs;
    private int mClickHeightRatio;
    private int mClickLeftPaddingRatio;
    private int mClickRightPaddingRatio;

    @NonNull
    private final View mClickView;

    @NonNull
    private final TextView mCountdownCloseView;
    private long mCurrentPosition;
    private long mDuration;
    private boolean mEnableFloatingVideoClickArea;
    private final Handler mHandler;
    private boolean mIsVideoPlaying;
    private FloatingVideoViewListener mListener;
    private boolean mVideoClickable;
    private long mVideoDuration;

    @NonNull
    private final AlphaVideoView mVideoView;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface FloatingVideoViewListener {
        void onCloseViewClick();

        void onVideoPlayComplete();

        void onVideoPlayError(int i3);

        void onVideoPlayPause();

        void onVideoPlayStart();

        void onVideoPlayStop();

        void onVideoPlayUpdate(long j3);

        void onVideoViewClick();
    }

    public OlympicFloatingVideoView(@NonNull Context context) {
        this(context, 2);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private AlphaVideoView createAndAddAlphaVideoView(Context context, int i3) {
        AlphaVideoView alphaVideoView = new AlphaVideoView(context, i3);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, getVideoHeight(getWidth()));
        layoutParams.gravity = 80;
        alphaVideoView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.ams.fusion.widget.olympic2024.floating.OlympicFloatingVideoView.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) OlympicFloatingVideoView.this);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        addView(alphaVideoView, layoutParams);
        return alphaVideoView;
    }

    private View createAndAddClickView(Context context) {
        View view = new View(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, getVideoHeight(getWidth()));
        layoutParams.gravity = 80;
        addView(view, layoutParams);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.ams.fusion.widget.olympic2024.floating.OlympicFloatingVideoView.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) OlympicFloatingVideoView.this);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                FloatingVideoViewListener floatingVideoViewListener;
                EventCollector.getInstance().onViewClickedBefore(view2);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) view2);
                } else if (OlympicFloatingVideoView.this.mVideoClickable && (floatingVideoViewListener = OlympicFloatingVideoView.this.mListener) != null && OlympicFloatingVideoView.this.mIsVideoPlaying) {
                    floatingVideoViewListener.onVideoViewClick();
                }
                EventCollector.getInstance().onViewClicked(view2);
            }
        });
        return view;
    }

    private TextView createAndAddCountdownCloseView(Context context) {
        TextView textView = new TextView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) Utils.dp2px(84.0f), (int) Utils.dp2px(24.0f));
        layoutParams.gravity = 85;
        layoutParams.rightMargin = (int) Utils.dp2px(8.0f);
        layoutParams.bottomMargin = getVideoHeight(getWidth());
        textView.setGravity(17);
        textView.setText(CLOSE_AD);
        textView.setTextSize(0, Utils.dp2px(12.0f));
        textView.setTextColor(-1);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(1291845632);
        gradientDrawable.setCornerRadius(Utils.dp2px(32.0f));
        textView.setBackground(gradientDrawable);
        addView(textView, layoutParams);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.ams.fusion.widget.olympic2024.floating.OlympicFloatingVideoView.4
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) OlympicFloatingVideoView.this);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    FloatingVideoViewListener floatingVideoViewListener = OlympicFloatingVideoView.this.mListener;
                    if (floatingVideoViewListener != null) {
                        floatingVideoViewListener.onCloseViewClick();
                    }
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        textView.setVisibility(8);
        return textView;
    }

    private int getVideoHeight(int i3) {
        if (i3 == 0) {
            i3 = Utils.getScreenWidth(getContext());
        }
        return (i3 * 3) / 4;
    }

    private boolean hasSetClickHotArea() {
        if (this.mEnableFloatingVideoClickArea && this.mClickBottomPaddingRatio != -1 && this.mClickLeftPaddingRatio != -1 && this.mClickRightPaddingRatio != -1 && this.mClickHeightRatio != -1) {
            return true;
        }
        return false;
    }

    private String tryGetCachePath(String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith("http")) {
            String cacheFilePath = NetworkResLoader.getCacheFilePath(getContext(), str);
            if (cacheFilePath != null) {
                if (new File(cacheFilePath).exists()) {
                    Logger.i(TAG, "get cache path success for url: " + str);
                    return cacheFilePath;
                }
            } else {
                Logger.w(TAG, "not found cache for url: " + str);
            }
        }
        Logger.i(TAG, "tryGetCachePath video path: " + str);
        return str;
    }

    private void updateClickArea(int i3) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mClickView.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(-1, i3);
        }
        if (hasSetClickHotArea()) {
            if (this.mClickBottomPaddingRatio > 0) {
                layoutParams.bottomMargin = (int) ((this.mClickView.getMeasuredHeight() * this.mClickBottomPaddingRatio) / 100.0f);
            }
            if (this.mClickLeftPaddingRatio > 0) {
                layoutParams.leftMargin = (int) ((this.mClickView.getMeasuredWidth() * this.mClickLeftPaddingRatio) / 100.0f);
            }
            if (this.mClickRightPaddingRatio > 0) {
                layoutParams.rightMargin = (int) ((this.mClickView.getMeasuredWidth() * this.mClickRightPaddingRatio) / 100.0f);
            }
            if (this.mClickHeightRatio >= 0) {
                int i16 = layoutParams.bottomMargin;
                int i17 = (i3 - ((int) ((r1 * i3) / 100.0f))) - i16;
                if (i17 > 0) {
                    layoutParams.height = (i3 - i16) - i17;
                } else {
                    layoutParams.height = i3 - i16;
                }
            }
        } else {
            layoutParams.height = i3;
        }
        Logger.i(TAG, "updateClickArea: bottomMargin=" + layoutParams.bottomMargin + ", leftMargin=" + layoutParams.leftMargin + ", rightMargin=" + layoutParams.rightMargin + ", height=" + layoutParams.height);
        this.mClickView.setLayoutParams(layoutParams);
    }

    private void updateVideoHeight(int i3) {
        Logger.i(TAG, "updateVideoHeight: " + i3);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mVideoView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = i3;
            this.mVideoView.setLayoutParams(layoutParams);
        }
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.mCountdownCloseView.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.bottomMargin = i3;
            this.mCountdownCloseView.setLayoutParams(layoutParams2);
        }
    }

    public void animHide() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
        } else {
            if (getVisibility() == 8) {
                return;
            }
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, c.f123400v, 1.0f, 0.0f);
            ofFloat.setDuration(100L);
            ofFloat.start();
            ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.tencent.ams.fusion.widget.olympic2024.floating.OlympicFloatingVideoView.5
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) OlympicFloatingVideoView.this);
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) animator);
                    } else {
                        OlympicFloatingVideoView.this.setVisibility(8);
                        OlympicFloatingVideoView.this.mHandler.sendEmptyMessage(2);
                    }
                }
            });
        }
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.AlphaPlayer.AlphaPlayerListener
    public boolean executeTask(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this, (Object) runnable)).booleanValue();
        }
        return false;
    }

    public long getCurrentPosition() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Long) iPatchRedirector.redirect((short) 12, (Object) this)).longValue();
        }
        return this.mCurrentPosition;
    }

    public long getDuration() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Long) iPatchRedirector.redirect((short) 11, (Object) this)).longValue();
        }
        return this.mDuration;
    }

    public boolean isVideoPlaying() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return this.mIsVideoPlaying;
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.AlphaPlayer.AlphaPlayerListener
    public void onComplete() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        Logger.i(TAG, "onComplete");
        this.mHandler.removeMessages(0);
        this.mHandler.sendEmptyMessage(1);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
            return;
        }
        this.mHandler.removeCallbacksAndMessages(null);
        this.mVideoView.stop();
        super.onDetachedFromWindow();
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.AlphaPlayer.AlphaPlayerListener
    public void onError(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, i3);
            return;
        }
        this.mIsVideoPlaying = false;
        this.mHandler.removeMessages(0);
        FloatingVideoViewListener floatingVideoViewListener = this.mListener;
        if (floatingVideoViewListener != null) {
            floatingVideoViewListener.onVideoPlayError(i3);
        }
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.AlphaPlayer.AlphaPlayerListener
    public boolean onInfo(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, this, Integer.valueOf(i3), Integer.valueOf(i16))).booleanValue();
        }
        Logger.i(TAG, "onInfo - what:" + i3 + ", extra:" + i16);
        return false;
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.AlphaPlayer.AlphaPlayerListener
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        Logger.i(TAG, MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
        FloatingVideoViewListener floatingVideoViewListener = this.mListener;
        if (floatingVideoViewListener != null) {
            floatingVideoViewListener.onVideoPlayPause();
        }
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.AlphaPlayer.AlphaPlayerListener
    public void onPrepared(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        Logger.i(TAG, "onPrepared - videoWidth:" + i3 + ", videoHeight:" + i16);
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.AlphaPlayer.AlphaPlayerListener
    public void onSeekComplete() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        super.onSizeChanged(i3, i16, i17, i18);
        if (i3 > 0) {
            int videoHeight = getVideoHeight(i3);
            updateVideoHeight(videoHeight);
            updateClickArea(videoHeight);
        }
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.AlphaPlayer.AlphaPlayerListener
    public void onStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        Logger.i(TAG, "onStart");
        this.mIsVideoPlaying = true;
        FloatingVideoViewListener floatingVideoViewListener = this.mListener;
        if (floatingVideoViewListener != null) {
            floatingVideoViewListener.onVideoPlayStart();
        }
        this.mHandler.removeMessages(0);
        this.mHandler.sendEmptyMessage(0);
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.AlphaPlayer.AlphaPlayerListener
    public void onStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        Logger.i(TAG, DKHippyEvent.EVENT_STOP);
        this.mIsVideoPlaying = false;
        FloatingVideoViewListener floatingVideoViewListener = this.mListener;
        if (floatingVideoViewListener != null) {
            floatingVideoViewListener.onVideoPlayStop();
        }
        this.mHandler.removeMessages(0);
    }

    public void setEnableFloatingVideoClickArea(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, z16);
        } else {
            this.mEnableFloatingVideoClickArea = z16;
        }
    }

    public void setFloatingVideoClickArea(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        this.mClickBottomPaddingRatio = i3;
        this.mClickLeftPaddingRatio = i16;
        this.mClickRightPaddingRatio = i17;
        this.mClickHeightRatio = i18;
        this.mEnableFloatingVideoClickArea = true;
    }

    public void setFloatingVideoClickAreaDebug(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
        } else if (z16) {
            this.mClickView.setBackgroundColor(1442775040);
        } else {
            this.mClickView.setBackground(null);
        }
    }

    public void setFloatingVideoClickDelay(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        } else if (i3 >= 0) {
            this.mClickDelayMs = i3;
        }
    }

    public void setListener(FloatingVideoViewListener floatingVideoViewListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) floatingVideoViewListener);
        } else {
            this.mListener = floatingVideoViewListener;
        }
    }

    public void setVideoDuration(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, j3);
        } else {
            this.mVideoDuration = j3;
        }
    }

    public void setVideoPath(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            return;
        }
        PlayInfo playInfo = new PlayInfo();
        playInfo.setVideoPath(tryGetCachePath(str));
        playInfo.setLoopPlay(false);
        playInfo.setScaleType(ScaleType.FIT_WIDTH);
        playInfo.setFormatType(FormatType.ALIGNED);
        this.mVideoView.setPlayInfo(playInfo);
        this.mVideoView.start();
        this.mVideoView.setPlayerListener(this);
    }

    public OlympicFloatingVideoView(Context context, int i3) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, i3);
            return;
        }
        this.mClickDelayMs = 500;
        this.mClickBottomPaddingRatio = -1;
        this.mClickLeftPaddingRatio = -1;
        this.mClickRightPaddingRatio = -1;
        this.mClickHeightRatio = -1;
        this.mEnableFloatingVideoClickArea = false;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.tencent.ams.fusion.widget.olympic2024.floating.OlympicFloatingVideoView.1
            static IPatchRedirector $redirector_;

            {
                super(r5);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) OlympicFloatingVideoView.this, (Object) r5);
                }
            }

            @Override // android.os.Handler
            public void handleMessage(@NonNull Message message) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    FloatingVideoViewListener floatingVideoViewListener = OlympicFloatingVideoView.this.mListener;
                    int i16 = message.what;
                    if (i16 == 0) {
                        OlympicFloatingVideoView.this.mCountdownCloseView.setVisibility(0);
                        long duration = OlympicFloatingVideoView.this.mVideoView.getDuration();
                        if (duration == 0 && OlympicFloatingVideoView.this.mVideoDuration > 0) {
                            duration = OlympicFloatingVideoView.this.mVideoDuration;
                        }
                        long position = OlympicFloatingVideoView.this.mVideoView.getPosition();
                        if (floatingVideoViewListener != null) {
                            floatingVideoViewListener.onVideoPlayUpdate(position);
                        }
                        if (duration > 0 && position > 0) {
                            OlympicFloatingVideoView.this.mCountdownCloseView.setText(String.format(Locale.CHINA, "%d %s", Integer.valueOf(Double.valueOf(Math.ceil((duration - position) / 1000.0d)).intValue()), OlympicFloatingVideoView.CLOSE_AD));
                        } else {
                            OlympicFloatingVideoView.this.mCountdownCloseView.setText(OlympicFloatingVideoView.CLOSE_AD);
                        }
                        if (position >= OlympicFloatingVideoView.this.mClickDelayMs && !OlympicFloatingVideoView.this.mVideoClickable) {
                            OlympicFloatingVideoView.this.mVideoClickable = true;
                            Logger.i(OlympicFloatingVideoView.TAG, "set clickable, position: " + position);
                        }
                        OlympicFloatingVideoView olympicFloatingVideoView = OlympicFloatingVideoView.this;
                        olympicFloatingVideoView.mDuration = Math.max(duration, olympicFloatingVideoView.mDuration);
                        OlympicFloatingVideoView olympicFloatingVideoView2 = OlympicFloatingVideoView.this;
                        olympicFloatingVideoView2.mCurrentPosition = Math.max(position, olympicFloatingVideoView2.mCurrentPosition);
                        sendEmptyMessageDelayed(0, 200L);
                        return;
                    }
                    if (i16 == 1) {
                        if (floatingVideoViewListener != null) {
                            floatingVideoViewListener.onVideoPlayUpdate(OlympicFloatingVideoView.this.mVideoView.getDuration());
                        }
                        OlympicFloatingVideoView.this.animHide();
                        return;
                    } else {
                        if (i16 == 2) {
                            if (floatingVideoViewListener != null) {
                                floatingVideoViewListener.onVideoPlayComplete();
                            }
                            OlympicFloatingVideoView.this.mVideoView.stop();
                            return;
                        }
                        return;
                    }
                }
                iPatchRedirector2.redirect((short) 2, (Object) this, (Object) message);
            }
        };
        this.mVideoView = createAndAddAlphaVideoView(context, i3);
        this.mClickView = createAndAddClickView(context);
        this.mCountdownCloseView = createAndAddCountdownCloseView(context);
    }
}
