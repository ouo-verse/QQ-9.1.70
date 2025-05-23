package com.tencent.mobileqq.videoplatform.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.videoplatform.VideoPlayerInnerCallback;
import com.tencent.mobileqq.videoplatform.VideoPlayerProxy;
import com.tencent.mobileqq.videoplatform.api.IBaseVideoView;
import com.tencent.mobileqq.videoplatform.api.PlayerState;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback;
import com.tencent.mobileqq.videoplatform.util.LogUtil;
import com.tencent.mobileqq.videoplatform.util.ThreadUtil;
import com.tencent.mobileqq.videoplatform.util.UIUtil;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalParam;
import java.util.List;

/* compiled from: P */
/* loaded from: classes20.dex */
public class BaseVideoView extends FrameLayout implements IBaseVideoView, VideoPlayerInnerCallback {
    static IPatchRedirector $redirector_ = null;
    private static final boolean DEBUG = false;
    Context mContext;
    private Drawable mCoverDrawable;
    private ImageView mCoverImage;
    private TextView mDebugTextView;
    private long mID;
    public boolean mIsPlayVideo;
    private VideoPlayParam mParams;
    boolean mScaleFullScreen;
    protected VideoPlayerProxy mVPProxy;

    public BaseVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
        } else {
            this.mContext = context;
            init(null);
        }
    }

    private void addCoverImageView() {
        try {
            if (this.mCoverImage == null) {
                this.mCoverImage = new ImageView(this.mContext);
            }
            Drawable drawable = this.mCoverDrawable;
            if (drawable != null) {
                this.mCoverImage.setImageDrawable(drawable);
            }
            if (this.mScaleFullScreen) {
                this.mCoverImage.setScaleType(ImageView.ScaleType.CENTER_CROP);
            } else {
                this.mCoverImage.setScaleType(ImageView.ScaleType.FIT_CENTER);
            }
            this.mCoverImage.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            this.mCoverImage.setVisibility(0);
            addView(this.mCoverImage, 1);
        } catch (Throwable th5) {
            LogUtil.e(getLogTag(), 1, "addCoverImageView error\u3002", th5);
        }
    }

    private void addDebugView() {
        try {
            if (findViewById(R.id.f1183673y) != null) {
                if (LogUtil.isColorLevel()) {
                    LogUtil.d(getLogTag(), 2, "addDebugView, debugTextView is exist");
                }
                removeView(findViewById(R.id.f1183673y));
            }
            TextView textView = new TextView(this.mContext);
            this.mDebugTextView = textView;
            textView.setId(R.id.f1183673y);
            this.mDebugTextView.setText(String.valueOf(this.mID));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -1);
            layoutParams.leftMargin = UIUtil.dp2px(6.0f, this.mContext.getResources());
            layoutParams.rightMargin = UIUtil.dp2px(6.0f, this.mContext.getResources());
            this.mDebugTextView.setGravity(17);
            this.mDebugTextView.setShadowLayer(3.0f, 1.0f, 1.0f, -16777216);
            this.mDebugTextView.setLayoutParams(layoutParams);
            addView(this.mDebugTextView, 2);
        } catch (Throwable th5) {
            LogUtil.e(getLogTag(), 1, "addDebugView error\u3002", th5);
        }
    }

    private void addVideoView() {
        try {
            if (findViewById(R.id.f1183773z) != null) {
                if (LogUtil.isColorLevel()) {
                    LogUtil.d(getLogTag(), 2, "addVideoView, videoView is exist");
                }
                removeView(findViewById(R.id.f1183773z));
            }
            View videoView = this.mVPProxy.getVideoView();
            if (videoView == null) {
                LogUtil.e(getLogTag(), 1, "addVideoView, videoView == null");
                return;
            }
            videoView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            videoView.setId(R.id.f1183773z);
            addView(videoView, 0);
            if (LogUtil.isColorLevel()) {
                LogUtil.d(getLogTag(), 2, "addVideoView. ");
            }
        } catch (Throwable th5) {
            LogUtil.e(getLogTag(), 1, "addVideoView error\u3002", th5);
        }
    }

    private String getLogTag() {
        return "[VideoPlatForm]BaseVideoView[" + getLogId() + "]";
    }

    @Override // com.tencent.mobileqq.videoplatform.api.IBaseVideoView
    public void addSubtitleSource(String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, this, str, str2, str3);
            return;
        }
        VideoPlayerProxy videoPlayerProxy = this.mVPProxy;
        if (videoPlayerProxy != null) {
            videoPlayerProxy.addSubtitleSource(str, str2, str3);
        }
    }

    @Override // com.tencent.mobileqq.videoplatform.api.IBaseVideoView
    public void captureCurFrame(long j3, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        VideoPlayerProxy videoPlayerProxy = this.mVPProxy;
        if (videoPlayerProxy != null) {
            videoPlayerProxy.captureCurFrame(j3, i3, i16);
        }
    }

    @Override // com.tencent.mobileqq.videoplatform.api.IBaseVideoView
    public void createMediaPlayer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this);
            return;
        }
        VideoPlayerProxy videoPlayerProxy = this.mVPProxy;
        if (videoPlayerProxy != null) {
            videoPlayerProxy.createMediaPlayer();
        }
    }

    @Override // com.tencent.mobileqq.videoplatform.api.IBaseVideoView
    public Drawable getCoverDrawable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Drawable) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.mCoverDrawable;
    }

    @Override // com.tencent.mobileqq.videoplatform.api.IBaseVideoView
    public ImageView getCoverImage() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (ImageView) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.mCoverImage;
    }

    @Override // com.tencent.mobileqq.videoplatform.api.IBaseVideoView
    public long getCurPlayingPos() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Long) iPatchRedirector.redirect((short) 12, (Object) this)).longValue();
        }
        try {
            return this.mVPProxy.getCurPostionMs();
        } catch (Throwable th5) {
            if (LogUtil.isColorLevel()) {
                LogUtil.e(getLogTag(), 2, "getCurPlayingPos() error ", th5);
            }
            return -1L;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long getLogId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return ((Long) iPatchRedirector.redirect((short) 31, (Object) this)).longValue();
        }
        return this.mID;
    }

    @Override // com.tencent.mobileqq.videoplatform.api.IBaseVideoView
    public long getVideoDurationMs() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Long) iPatchRedirector.redirect((short) 13, (Object) this)).longValue();
        }
        VideoPlayerProxy videoPlayerProxy = this.mVPProxy;
        if (videoPlayerProxy != null) {
            return videoPlayerProxy.getVideoDurationMs();
        }
        return 0L;
    }

    public void init(VideoPlayerInnerCallback videoPlayerInnerCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) videoPlayerInnerCallback);
            return;
        }
        if (videoPlayerInnerCallback == null) {
            this.mVPProxy = new VideoPlayerProxy(this.mContext, this.mID, this.mParams, this, this.mScaleFullScreen);
        } else {
            this.mVPProxy = new VideoPlayerProxy(this.mContext, this.mID, this.mParams, videoPlayerInnerCallback, this.mScaleFullScreen);
        }
        addVideoView();
        addCoverImageView();
    }

    @Override // com.tencent.mobileqq.videoplatform.api.IBaseVideoView
    public boolean isLocalPlay() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        if (this.mVPProxy.getVideoParam() != null) {
            return this.mVPProxy.getVideoParam().mIsLocal;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.videoplatform.api.IBaseVideoView
    public boolean isMute() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this)).booleanValue();
        }
        VideoPlayerProxy videoPlayerProxy = this.mVPProxy;
        if (videoPlayerProxy != null) {
            return videoPlayerProxy.isMute();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.videoplatform.api.IBaseVideoView
    public boolean isPlaying() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return this.mVPProxy.isPlaying();
    }

    @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
    public void onCapFrame(long j3, boolean z16, int i3, int i16, Bitmap bitmap) {
        VideoPlayerCallback videoPlayerCallback;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, this, Long.valueOf(j3), Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), bitmap);
            return;
        }
        VideoPlayParam videoPlayParam = this.mParams;
        if (videoPlayParam != null && (videoPlayerCallback = videoPlayParam.mCallback) != null) {
            videoPlayerCallback.onCapFrame(j3, z16, i3, i16, bitmap);
        }
    }

    @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
    public void onDownloadComplete(long j3) {
        VideoPlayerCallback videoPlayerCallback;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, j3);
            return;
        }
        VideoPlayParam videoPlayParam = this.mParams;
        if (videoPlayParam != null && (videoPlayerCallback = videoPlayParam.mCallback) != null) {
            videoPlayerCallback.onDownloadComplete(j3);
        }
    }

    @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
    public void onDownloadProgress(long j3, long j16) {
        VideoPlayerCallback videoPlayerCallback;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, this, Long.valueOf(j3), Long.valueOf(j16));
            return;
        }
        VideoPlayParam videoPlayParam = this.mParams;
        if (videoPlayParam != null && (videoPlayerCallback = videoPlayParam.mCallback) != null) {
            videoPlayerCallback.onDownloadProgress(j3, j16);
        }
    }

    @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
    public void onFirstFrameRendered(long j3) {
        VideoPlayerCallback videoPlayerCallback;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, (Object) this, j3);
            return;
        }
        if (LogUtil.isColorLevel()) {
            LogUtil.d(getLogTag(), 2, "onFirstFrameRendered , id = " + j3);
        }
        VideoPlayParam videoPlayParam = this.mParams;
        if (videoPlayParam != null && (videoPlayerCallback = videoPlayParam.mCallback) != null) {
            videoPlayerCallback.onFirstFrameRendered(j3);
        }
        ThreadUtil.postOnUIThread(new Runnable() { // from class: com.tencent.mobileqq.videoplatform.view.BaseVideoView.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) BaseVideoView.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    BaseVideoView.this.setCoverInVisible();
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
    public void onLoopBack(long j3, long j16) {
        VideoPlayerCallback videoPlayerCallback;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, this, Long.valueOf(j3), Long.valueOf(j16));
            return;
        }
        VideoPlayParam videoPlayParam = this.mParams;
        if (videoPlayParam != null && (videoPlayerCallback = videoPlayParam.mCallback) != null) {
            videoPlayerCallback.onLoopBack(j3, j16);
        }
    }

    @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
    public void onPlayError(long j3, int i3, int i16, int i17, String str) {
        VideoPlayerCallback videoPlayerCallback;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, this, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), str);
            return;
        }
        VideoPlayParam videoPlayParam = this.mParams;
        if (videoPlayParam != null && (videoPlayerCallback = videoPlayParam.mCallback) != null) {
            videoPlayerCallback.onPlayError(j3, i3, i16, i17, str);
        }
    }

    @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
    public void onPlayProgress(long j3, long j16) {
        VideoPlayerCallback videoPlayerCallback;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, this, Long.valueOf(j3), Long.valueOf(j16));
            return;
        }
        VideoPlayParam videoPlayParam = this.mParams;
        if (videoPlayParam != null && (videoPlayerCallback = videoPlayParam.mCallback) != null) {
            videoPlayerCallback.onPlayProgress(j3, j16);
        }
    }

    @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
    public void onStateChange(long j3, int i3) {
        VideoPlayerCallback videoPlayerCallback;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, this, Long.valueOf(j3), Integer.valueOf(i3));
            return;
        }
        if (LogUtil.isColorLevel()) {
            LogUtil.d(getLogTag(), 2, "onStateChange , state = " + PlayerState.getStateStr(i3));
        }
        VideoPlayParam videoPlayParam = this.mParams;
        if (videoPlayParam != null && (videoPlayerCallback = videoPlayParam.mCallback) != null) {
            videoPlayerCallback.onStateChange(j3, i3);
        }
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    return;
                }
            } else {
                if (this.mIsPlayVideo) {
                    play();
                    return;
                }
                return;
            }
        }
        setCoverVisible();
    }

    @Override // com.tencent.mobileqq.videoplatform.VideoPlayerInnerCallback
    public void onSurfaceDestroy(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, (Object) this, j3);
            return;
        }
        if (LogUtil.isColorLevel()) {
            LogUtil.d(getLogTag(), 2, "onSurfaceDestroy , id = " + j3);
        }
        ThreadUtil.postOnUIThread(new Runnable() { // from class: com.tencent.mobileqq.videoplatform.view.BaseVideoView.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) BaseVideoView.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    BaseVideoView.this.setCoverVisible();
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.videoplatform.api.IBaseVideoView
    public void pause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        VideoPlayerProxy videoPlayerProxy = this.mVPProxy;
        if (videoPlayerProxy != null) {
            videoPlayerProxy.pause();
        }
    }

    @Override // com.tencent.mobileqq.videoplatform.api.IBaseVideoView
    public void pauseDownload() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        VideoPlayerProxy videoPlayerProxy = this.mVPProxy;
        if (videoPlayerProxy != null) {
            videoPlayerProxy.pauseDownload();
        }
    }

    @Override // com.tencent.mobileqq.videoplatform.api.IBaseVideoView
    public void play() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        if (LogUtil.isColorLevel()) {
            LogUtil.d(getLogTag(), 2, "play");
        }
        this.mIsPlayVideo = true;
        VideoPlayerProxy videoPlayerProxy = this.mVPProxy;
        if (videoPlayerProxy != null) {
            videoPlayerProxy.play();
        }
    }

    @Override // com.tencent.mobileqq.videoplatform.api.IBaseVideoView
    public void releasePlayer(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, z16);
            return;
        }
        if (LogUtil.isColorLevel()) {
            LogUtil.e(getLogTag(), 2, "releasePlayer, print stack : \uff08 not a crash !!! \uff09", new RuntimeException());
        }
        this.mIsPlayVideo = false;
        VideoPlayerProxy videoPlayerProxy = this.mVPProxy;
        if (videoPlayerProxy != null) {
            videoPlayerProxy.release(z16, false);
        }
    }

    @Override // com.tencent.mobileqq.videoplatform.api.IBaseVideoView
    public void resume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
        } else {
            if (!this.mIsPlayVideo) {
                if (LogUtil.isColorLevel()) {
                    LogUtil.d(getLogTag(), 2, "resume , mIsPlayVideo is false , do nothing.");
                    return;
                }
                return;
            }
            play();
        }
    }

    @Override // com.tencent.mobileqq.videoplatform.api.IBaseVideoView
    public void resumeDownload() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
            return;
        }
        VideoPlayerProxy videoPlayerProxy = this.mVPProxy;
        if (videoPlayerProxy != null) {
            videoPlayerProxy.resumeDownload();
        }
    }

    @Override // com.tencent.mobileqq.videoplatform.api.IBaseVideoView
    public void seekTo(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, i3);
            return;
        }
        if (LogUtil.isColorLevel()) {
            LogUtil.d(getLogTag(), 2, "seekTo, positionMs = " + i3);
        }
        VideoPlayerProxy videoPlayerProxy = this.mVPProxy;
        if (videoPlayerProxy != null) {
            videoPlayerProxy.seekTo(i3);
        }
    }

    @Override // com.tencent.mobileqq.videoplatform.api.IBaseVideoView
    public void setCoverDrawable(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) drawable);
            return;
        }
        this.mCoverDrawable = drawable;
        ImageView imageView = this.mCoverImage;
        if (imageView != null) {
            imageView.setImageDrawable(drawable);
        }
    }

    public void setCoverInVisible() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this);
        } else if (this.mCoverImage != null) {
            if (LogUtil.isColorLevel()) {
                LogUtil.d(getLogTag(), 2, "setCoverInVisible");
            }
            this.mCoverImage.setVisibility(4);
        }
    }

    public void setCoverVisible() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this);
        } else if (this.mCoverImage != null) {
            if (LogUtil.isColorLevel()) {
                LogUtil.d(getLogTag(), 2, "setCoverVisible");
            }
            this.mCoverImage.setVisibility(0);
        }
    }

    public void setDebugText(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, (Object) str);
            return;
        }
        if (this.mDebugTextView == null) {
            addDebugView();
        }
        TextView textView = this.mDebugTextView;
        if (textView != null) {
            textView.setText(str);
        }
    }

    @Override // com.tencent.mobileqq.videoplatform.api.IBaseVideoView
    public void setID(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, j3);
        } else {
            this.mID = j3;
            this.mVPProxy.setID(j3);
        }
    }

    @Override // com.tencent.mobileqq.videoplatform.api.IBaseVideoView
    public void setMute(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, z16);
            return;
        }
        VideoPlayerProxy videoPlayerProxy = this.mVPProxy;
        if (videoPlayerProxy != null) {
            videoPlayerProxy.setMute(z16);
        }
    }

    @Override // com.tencent.mobileqq.videoplatform.api.IBaseVideoView
    public void setOnSubtitleDataListener(ISuperPlayer.OnSubtitleDataListener onSubtitleDataListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) onSubtitleDataListener);
            return;
        }
        VideoPlayerProxy videoPlayerProxy = this.mVPProxy;
        if (videoPlayerProxy != null) {
            videoPlayerProxy.setOnSubtitleDataListener(onSubtitleDataListener);
        }
    }

    @Override // com.tencent.mobileqq.videoplatform.api.IBaseVideoView
    public void setPlayerOptionalParamList(List<TPOptionalParam> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) list);
            return;
        }
        VideoPlayerProxy videoPlayerProxy = this.mVPProxy;
        if (videoPlayerProxy != null) {
            videoPlayerProxy.setPlayerOptionalParamList(list);
        }
    }

    @Override // com.tencent.mobileqq.videoplatform.api.IBaseVideoView
    public void setVideoParam(VideoPlayParam videoPlayParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) videoPlayParam);
            return;
        }
        this.mParams = videoPlayParam;
        VideoPlayParam videoParam = this.mVPProxy.getVideoParam();
        if (videoParam == null) {
            this.mVPProxy.setVideoParam(videoPlayParam);
            return;
        }
        if (videoPlayParam.isSameVideo(videoParam)) {
            if (LogUtil.isColorLevel()) {
                LogUtil.d(getLogTag(), 2, "setVideoParam, same video, do noting.");
            }
            videoPlayParam.mLastPlayPosMs = videoParam.mLastPlayPosMs;
        } else {
            if (LogUtil.isColorLevel()) {
                LogUtil.d(getLogTag(), 2, "setVideoParam, different video, addVideoView.");
            }
            this.mVPProxy.release(false, false);
            this.mVPProxy = new VideoPlayerProxy(this.mContext, this.mID, videoPlayParam, this, this.mScaleFullScreen);
            addVideoView();
        }
    }

    @Override // com.tencent.mobileqq.videoplatform.api.IBaseVideoView
    public void showCover(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) drawable);
            return;
        }
        if (LogUtil.isColorLevel()) {
            LogUtil.d(getLogTag(), 2, "showCover");
        }
        this.mIsPlayVideo = false;
        this.mCoverDrawable = drawable;
        ImageView imageView = this.mCoverImage;
        if (imageView != null) {
            imageView.setImageDrawable(drawable);
            this.mCoverImage.setVisibility(0);
        }
        releasePlayer(false);
    }

    public BaseVideoView(Context context, long j3, VideoPlayParam videoPlayParam, ImageView imageView, VideoPlayerInnerCallback videoPlayerInnerCallback) {
        this(context, j3, videoPlayParam, imageView, videoPlayerInnerCallback, false);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, Long.valueOf(j3), videoPlayParam, imageView, videoPlayerInnerCallback);
    }

    public BaseVideoView(Context context, long j3, VideoPlayParam videoPlayParam, ImageView imageView, VideoPlayerInnerCallback videoPlayerInnerCallback, boolean z16) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, Long.valueOf(j3), videoPlayParam, imageView, videoPlayerInnerCallback, Boolean.valueOf(z16));
            return;
        }
        this.mContext = context;
        this.mID = j3;
        this.mScaleFullScreen = z16;
        this.mParams = videoPlayParam;
        this.mCoverImage = imageView;
        init(videoPlayerInnerCallback);
    }

    @Override // com.tencent.mobileqq.videoplatform.api.IBaseVideoView
    public void seekTo(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (LogUtil.isColorLevel()) {
            LogUtil.d(getLogTag(), 2, "seekTo, positionMs = " + i3 + ", mode=" + i16);
        }
        VideoPlayerProxy videoPlayerProxy = this.mVPProxy;
        if (videoPlayerProxy != null) {
            videoPlayerProxy.seekTo(i3, i16);
        }
    }
}
