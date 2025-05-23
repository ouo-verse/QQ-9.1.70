package com.tencent.qqmini.sdk.widget.media;

import android.app.Activity;
import android.util.Log;
import com.tencent.hippy.qq.view.video.constants.HVideoConstants;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.lang.ref.WeakReference;

/* loaded from: classes23.dex */
public class IVideoPlayerImpl implements IVideoPlayer {
    private static final String TAG = "IVideoPlayerImpl";
    private AbsVideoPlayer absVideoPlayer = null;
    private WeakReference<Activity> mWeakReferenceActivity;

    public IVideoPlayerImpl(Activity activity) {
        this.mWeakReferenceActivity = new WeakReference<>(activity);
    }

    private void setAbsVideoPlayer() {
        AbsVideoPlayer absVideoPlayer;
        ChannelProxy channelProxy = (ChannelProxy) ProxyManager.get(ChannelProxy.class);
        if (channelProxy != null) {
            absVideoPlayer = channelProxy.getVideoPlayer();
        } else {
            absVideoPlayer = null;
        }
        this.absVideoPlayer = absVideoPlayer;
    }

    private void updatePlayerListener(MiniAppVideoPlayerListenerHolder miniAppVideoPlayerListenerHolder) {
        if (miniAppVideoPlayerListenerHolder != null) {
            AbsVideoPlayer.OnControllerClickListener onControllerClickListener = miniAppVideoPlayerListenerHolder.onControllerClickListener;
            if (onControllerClickListener != null) {
                this.absVideoPlayer.setOnControllerClickListener(onControllerClickListener);
            }
            AbsVideoPlayer.OnVideoPreparedListener onVideoPreparedListener = miniAppVideoPlayerListenerHolder.onVideoPreparedListener;
            if (onVideoPreparedListener != null) {
                this.absVideoPlayer.setOnVideoPreparedListener(onVideoPreparedListener);
            }
            AbsVideoPlayer.OnCompletionListener onCompletionListener = miniAppVideoPlayerListenerHolder.onCompletionListener;
            if (onCompletionListener != null) {
                this.absVideoPlayer.setOnCompletionListener(onCompletionListener);
            }
            AbsVideoPlayer.OnErrorListener onErrorListener = miniAppVideoPlayerListenerHolder.onErrorListener;
            if (onErrorListener != null) {
                this.absVideoPlayer.setOnErrorListener(onErrorListener);
            }
            AbsVideoPlayer.OnInfoListener onInfoListener = miniAppVideoPlayerListenerHolder.onInfoListener;
            if (onInfoListener != null) {
                this.absVideoPlayer.setOnInfoListener(onInfoListener);
            }
            AbsVideoPlayer.OnSeekCompleteListener onSeekCompleteListener = miniAppVideoPlayerListenerHolder.onSeekCompleteListener;
            if (onSeekCompleteListener != null) {
                this.absVideoPlayer.setOnSeekCompleteListener(onSeekCompleteListener);
            }
            AbsVideoPlayer.OnCaptureImageListener onCaptureImageListener = miniAppVideoPlayerListenerHolder.onCaptureImageListener;
            if (onCaptureImageListener != null) {
                this.absVideoPlayer.setOnCaptureImageListener(onCaptureImageListener);
            }
        }
    }

    @Override // com.tencent.qqmini.sdk.widget.media.IVideoPlayer
    public void captureImageInTime(int i3, int i16) {
        this.absVideoPlayer.captureImageInTime(i3, i16);
    }

    @Override // com.tencent.qqmini.sdk.widget.media.IVideoPlayer
    public void createVideoView(AbsVideoPlayer.OnVideoViewInitListener onVideoViewInitListener, boolean z16) {
        if (this.absVideoPlayer == null) {
            setAbsVideoPlayer();
        }
        if (this.absVideoPlayer == null) {
            QMLog.e(TAG, "initPlayer absVideoPlayer is null, return.");
        } else if (this.mWeakReferenceActivity.get() == null) {
            QMLog.e(TAG, "mWeakReferenceActivity is null!");
        } else {
            this.absVideoPlayer.createVideoView(this.mWeakReferenceActivity.get(), onVideoViewInitListener, z16);
        }
    }

    @Override // com.tencent.qqmini.sdk.widget.media.IVideoPlayer
    public long getCurrentPostion() {
        return this.absVideoPlayer.getCurrentPostion();
    }

    @Override // com.tencent.qqmini.sdk.widget.media.IVideoPlayer
    public long getDuration() {
        return this.absVideoPlayer.getDuration();
    }

    @Override // com.tencent.qqmini.sdk.widget.media.IVideoPlayer
    public boolean getOutputMute() {
        return this.absVideoPlayer.getOutputMute();
    }

    @Override // com.tencent.qqmini.sdk.widget.media.IVideoPlayer
    public int getVideoHeight() {
        return this.absVideoPlayer.getVideoHeight();
    }

    @Override // com.tencent.qqmini.sdk.widget.media.IVideoPlayer
    public int getVideoWidth() {
        return this.absVideoPlayer.getVideoWidth();
    }

    @Override // com.tencent.qqmini.sdk.widget.media.IVideoPlayer
    public boolean isPlaying() {
        return this.absVideoPlayer.isPlaying();
    }

    @Override // com.tencent.qqmini.sdk.widget.media.IVideoPlayer
    public void openMediaPlayerByUrl(Activity activity, String str, long j3) {
        this.absVideoPlayer.openMediaPlayerByUrl(activity, str, j3);
    }

    @Override // com.tencent.qqmini.sdk.widget.media.IVideoPlayer
    public void pause() {
        this.absVideoPlayer.pause();
    }

    @Override // com.tencent.qqmini.sdk.widget.media.IVideoPlayer
    public void release() {
        this.absVideoPlayer.release();
    }

    @Override // com.tencent.qqmini.sdk.widget.media.IVideoPlayer
    public void seekTo(int i3) {
        this.absVideoPlayer.seekTo(i3);
    }

    @Override // com.tencent.qqmini.sdk.widget.media.IVideoPlayer
    public void setOnCaptureImageListener(AbsVideoPlayer.OnCaptureImageListener onCaptureImageListener) {
        this.absVideoPlayer.setOnCaptureImageListener(onCaptureImageListener);
    }

    @Override // com.tencent.qqmini.sdk.widget.media.IVideoPlayer
    public void setupPlayer(MiniAppVideoConfig miniAppVideoConfig, MiniAppVideoPlayerListenerHolder miniAppVideoPlayerListenerHolder) {
        updatePlayerListener(miniAppVideoPlayerListenerHolder);
        this.absVideoPlayer.setLoopback(miniAppVideoConfig.loop);
        this.absVideoPlayer.setXYaxis(!HVideoConstants.ResizeType.RESIZE_CONTAIN.equals(miniAppVideoConfig.objectFit) ? 1 : 0);
    }

    @Override // com.tencent.qqmini.sdk.widget.media.IVideoPlayer
    public void start() {
        this.absVideoPlayer.start();
    }

    @Override // com.tencent.qqmini.sdk.widget.media.IVideoPlayer
    public void startPlayDanmu() {
        this.absVideoPlayer.startPlayDanmu();
    }

    @Override // com.tencent.qqmini.sdk.widget.media.IVideoPlayer
    public void stop() {
        this.absVideoPlayer.stop();
    }

    @Override // com.tencent.qqmini.sdk.widget.media.IVideoPlayer
    public boolean updateMute(MiniAppVideoConfig miniAppVideoConfig) {
        AbsVideoPlayer absVideoPlayer = this.absVideoPlayer;
        if (absVideoPlayer == null) {
            return false;
        }
        if (absVideoPlayer.getOutputMute() != miniAppVideoConfig.muted) {
            Log.i(TAG, "initSetting: set mute " + miniAppVideoConfig.muted);
            return this.absVideoPlayer.setOutputMute(miniAppVideoConfig.muted);
        }
        return true;
    }

    @Override // com.tencent.qqmini.sdk.widget.media.IVideoPlayer
    public void updateObjFit(MiniAppVideoConfig miniAppVideoConfig) {
        if (this.absVideoPlayer != null) {
            if (HVideoConstants.ResizeType.RESIZE_CONTAIN.equals(miniAppVideoConfig.objectFit)) {
                this.absVideoPlayer.setXYaxis(0);
            } else if (CanvasView.CUSTOM_ACTION_FILL.equals(miniAppVideoConfig.objectFit)) {
                this.absVideoPlayer.setXYaxis(1);
            }
        }
    }

    @Override // com.tencent.qqmini.sdk.widget.media.IVideoPlayer
    public void openMediaPlayerByUrl(Activity activity, String str, long j3, String str2, String str3, Boolean bool) {
        AbsVideoPlayer absVideoPlayer = this.absVideoPlayer;
        if (absVideoPlayer == null) {
            QMLog.e(TAG, "[openMediaPlayerByUrl for superPlayer] player null error.");
            return;
        }
        if (!absVideoPlayer.isSuperPlayer()) {
            openMediaPlayerByUrl(activity, str, j3);
            return;
        }
        if (bool.booleanValue()) {
            this.absVideoPlayer.setDrmDataSource(str, str2, str3);
        } else {
            this.absVideoPlayer.setDataSource(str);
        }
        this.absVideoPlayer.openMediaPlayerByUrl(activity, j3);
    }
}
