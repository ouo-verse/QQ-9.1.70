package com.tencent.qqmini.proxyimpl;

import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.view.ISPlayerVideoView;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes34.dex */
public class ad implements IMediaPlayer {

    /* renamed from: a, reason: collision with root package name */
    private ISuperPlayer f347755a;

    /* renamed from: b, reason: collision with root package name */
    private ISPlayerVideoView f347756b;

    /* renamed from: c, reason: collision with root package name */
    private SuperPlayerVideoInfo f347757c;

    /* compiled from: P */
    /* loaded from: classes34.dex */
    class a implements ISPlayerVideoView.IVideoViewCallBack {
        a() {
        }

        @Override // com.tencent.superplayer.view.ISPlayerVideoView.IVideoViewCallBack
        public void onSurfaceChanged(Object obj) {
            QLog.d("MediaPlayerSuperImpl", 1, "[onSurfaceChanged]");
        }

        @Override // com.tencent.superplayer.view.ISPlayerVideoView.IVideoViewCallBack
        public void onSurfaceCreated(Object obj) {
            QLog.d("MediaPlayerSuperImpl", 1, "[onSurfaceCreated]");
        }

        @Override // com.tencent.superplayer.view.ISPlayerVideoView.IVideoViewCallBack
        public void onSurfaceDestroy(Object obj) {
            QLog.d("MediaPlayerSuperImpl", 1, "[onSurfaceDestroy]");
        }
    }

    /* compiled from: P */
    /* loaded from: classes34.dex */
    class b implements ISuperPlayer.OnVideoPreparedListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ IMediaPlayer.OnPreparedListener f347759d;

        b(IMediaPlayer.OnPreparedListener onPreparedListener) {
            this.f347759d = onPreparedListener;
        }

        @Override // com.tencent.superplayer.api.ISuperPlayer.OnVideoPreparedListener
        public void onVideoPrepared(ISuperPlayer iSuperPlayer) {
            this.f347759d.onPrepared(ad.this);
        }
    }

    /* compiled from: P */
    /* loaded from: classes34.dex */
    class c implements ISuperPlayer.OnCompletionListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ IMediaPlayer.OnCompletionListener f347761d;

        c(IMediaPlayer.OnCompletionListener onCompletionListener) {
            this.f347761d = onCompletionListener;
        }

        @Override // com.tencent.superplayer.api.ISuperPlayer.OnCompletionListener
        public void onCompletion(ISuperPlayer iSuperPlayer) {
            this.f347761d.onCompletion(ad.this);
        }
    }

    /* compiled from: P */
    /* loaded from: classes34.dex */
    class d implements ISuperPlayer.OnSeekCompleteListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ IMediaPlayer.OnSeekCompleteListener f347763d;

        d(IMediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
            this.f347763d = onSeekCompleteListener;
        }

        @Override // com.tencent.superplayer.api.ISuperPlayer.OnSeekCompleteListener
        public void onSeekComplete(ISuperPlayer iSuperPlayer) {
            this.f347763d.onSeekComplete(ad.this);
        }
    }

    /* compiled from: P */
    /* loaded from: classes34.dex */
    class e implements ISuperPlayer.OnVideoSizeChangedListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ IMediaPlayer.OnVideoSizeChangedListener f347765d;

        e(IMediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
            this.f347765d = onVideoSizeChangedListener;
        }

        @Override // com.tencent.superplayer.api.ISuperPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(ISuperPlayer iSuperPlayer, int i3, int i16) {
            this.f347765d.onVideoSizeChanged(ad.this, i3, i16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes34.dex */
    class f implements ISuperPlayer.OnErrorListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ IMediaPlayer.OnErrorListener f347767d;

        f(IMediaPlayer.OnErrorListener onErrorListener) {
            this.f347767d = onErrorListener;
        }

        @Override // com.tencent.superplayer.api.ISuperPlayer.OnErrorListener
        public boolean onError(ISuperPlayer iSuperPlayer, int i3, int i16, int i17, String str) {
            QLog.e("MediaPlayerSuperImpl", 1, "[startPlay] onError  module:" + i3 + " errorType:" + i16 + "  errorCode:" + i17 + "  extraInfo:" + str);
            return this.f347767d.onError(ad.this, i3, i16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes34.dex */
    class g implements ISuperPlayer.OnInfoListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ IMediaPlayer.OnInfoListener f347769d;

        g(IMediaPlayer.OnInfoListener onInfoListener) {
            this.f347769d = onInfoListener;
        }

        @Override // com.tencent.superplayer.api.ISuperPlayer.OnInfoListener
        public boolean onInfo(ISuperPlayer iSuperPlayer, int i3, long j3, long j16, Object obj) {
            return this.f347769d.onInfo(ad.this, i3, 0);
        }
    }

    public ad() {
        if (this.f347756b == null || this.f347755a == null) {
            try {
                QLog.d("MediaPlayerSuperImpl", 1, "[createPlayerVideoView]");
                this.f347756b = SuperPlayerFactory.createPlayerVideoView(BaseApplication.getContext());
                this.f347755a = SuperPlayerFactory.createMediaPlayer(BaseApplication.getContext(), 114, this.f347756b);
                this.f347756b.addViewCallBack(new a());
            } catch (Exception e16) {
                QLog.e("MediaPlayerSuperImpl", 1, "[init superPlayer error]", e16);
                this.f347756b = null;
                this.f347755a = null;
            }
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer
    public int getBufferPercent() {
        if (this.f347755a == null) {
            QLog.e("MediaPlayerSuperImpl", 1, "[getBufferPercent error] mMediaPlayer is null.");
        }
        return 0;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer
    public long getCurrentPosition() {
        ISuperPlayer iSuperPlayer = this.f347755a;
        if (iSuperPlayer == null) {
            QLog.e("MediaPlayerSuperImpl", 1, "[getCurrentPosition error], mMediaPlayer is null.");
            return -1L;
        }
        return iSuperPlayer.getCurrentPositionMs();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer
    public long getDuration() {
        ISuperPlayer iSuperPlayer = this.f347755a;
        if (iSuperPlayer == null) {
            QLog.e("MediaPlayerSuperImpl", 1, "[getDuration error], mMediaPlayer is null.");
            return -1L;
        }
        return iSuperPlayer.getDurationMs();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer
    public int getVideoHeight() {
        ISuperPlayer iSuperPlayer = this.f347755a;
        if (iSuperPlayer == null) {
            QLog.e("MediaPlayerSuperImpl", 1, "[getVideoHight error] mMediaPlayer is null.");
            return -1;
        }
        return iSuperPlayer.getVideoHeight();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer
    public int getVideoWidth() {
        ISuperPlayer iSuperPlayer = this.f347755a;
        if (iSuperPlayer == null) {
            QLog.e("MediaPlayerSuperImpl", 1, "[getVideoWidth error] mMediaPlayer is null.");
            return -1;
        }
        return iSuperPlayer.getVideoWidth();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer
    public boolean isLooping() {
        ISuperPlayer iSuperPlayer = this.f347755a;
        if (iSuperPlayer == null) {
            QLog.e("MediaPlayerSuperImpl", 1, "[isLooping error] mMediaPlayer is null.");
            return false;
        }
        return iSuperPlayer.isLoopBack();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer
    public boolean isPlaying() {
        if (this.f347755a == null) {
            QLog.e("MediaPlayerSuperImpl", 1, "[isPlaying error] mMediaPlayer is null.");
            return false;
        }
        QLog.d("MediaPlayerSuperImpl", 1, "mMediaPlayer isPlaying:" + this.f347755a.isPlaying());
        return this.f347755a.isPlaying();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer
    public boolean isSuperPlayer() {
        return true;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer
    public void pause() throws IllegalStateException {
        if (this.f347755a == null) {
            QLog.e("MediaPlayerSuperImpl", 1, "[pause error] mMediaPlayer is null.");
        } else {
            QLog.d("MediaPlayerSuperImpl", 1, "mMediaPlayer pause!");
            this.f347755a.pause();
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer
    public void prepareAsync() throws IllegalStateException {
        ISuperPlayer iSuperPlayer = this.f347755a;
        if (iSuperPlayer != null && this.f347757c != null) {
            iSuperPlayer.openMediaPlayer(BaseApplication.getContext(), this.f347757c, 0L);
        } else {
            QLog.e("MediaPlayerSuperImpl", 1, "[openMediaPlayer error] mMediaPlayer/videoInfo is null.");
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer
    public void release() {
        if (this.f347755a == null) {
            QLog.e("MediaPlayerSuperImpl", 1, "[release error], mMediaPlayer is null.");
        } else {
            QLog.d("MediaPlayerSuperImpl", 1, "mMediaPlayer release!");
            this.f347755a.release();
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer
    public void reset() {
        ISuperPlayer iSuperPlayer = this.f347755a;
        if (iSuperPlayer == null) {
            QLog.e("MediaPlayerSuperImpl", 1, "[reset error], mMediaPlayer is null.");
        } else {
            iSuperPlayer.reset();
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer
    public void setDataSource(String str) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException, UnsupportedOperationException {
        if (this.f347755a == null) {
            QLog.e("MediaPlayerSuperImpl", 1, "[startPlay(setDataSource) error] mMediaPlayer is null.");
            return;
        }
        QLog.d("MediaPlayerSuperImpl", 1, "[startPlay] url = " + str);
        this.f347757c = SuperPlayerFactory.createVideoInfoForUrl(str, 100, (String) null);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer
    public void setDrmDataSource(String str, String str2, String str3) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException, UnsupportedOperationException {
        if (this.f347755a == null) {
            QLog.e("MediaPlayerSuperImpl", 1, "[startPlay(setDataSource) error] mMediaPlayer is null.");
            return;
        }
        QLog.d("MediaPlayerSuperImpl", 1, "[startPlay drm] url = " + str);
        this.f347757c = SuperPlayerFactory.createVideoInfoForDRM(0, str, 102, str2, str3);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer
    public void setLooping(boolean z16) {
        ISuperPlayer iSuperPlayer = this.f347755a;
        if (iSuperPlayer == null) {
            QLog.e("MediaPlayerSuperImpl", 1, "[setLooping error] mMediaPlayer is null.");
        } else {
            iSuperPlayer.setLoopback(z16);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer
    public void setOnCompletionListener(IMediaPlayer.OnCompletionListener onCompletionListener) {
        ISuperPlayer iSuperPlayer = this.f347755a;
        if (iSuperPlayer == null) {
            QLog.e("MediaPlayerSuperImpl", 1, "[setOnCompletionListener error], mMediaPlayer is null.");
        } else {
            iSuperPlayer.setOnCompletionListener(new c(onCompletionListener));
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer
    public void setOnErrorListener(IMediaPlayer.OnErrorListener onErrorListener) {
        ISuperPlayer iSuperPlayer = this.f347755a;
        if (iSuperPlayer == null) {
            QLog.e("MediaPlayerSuperImpl", 1, "[setOnErrorListener error] mMediaPlayer is null.");
        } else {
            iSuperPlayer.setOnErrorListener(new f(onErrorListener));
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer
    public void setOnInfoListener(IMediaPlayer.OnInfoListener onInfoListener) {
        ISuperPlayer iSuperPlayer = this.f347755a;
        if (iSuperPlayer == null) {
            QLog.e("MediaPlayerSuperImpl", 1, "[setOnInfoListener error] mMediaPlayer is null.");
        } else {
            iSuperPlayer.setOnInfoListener(new g(onInfoListener));
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer
    public void setOnPreparedListener(IMediaPlayer.OnPreparedListener onPreparedListener) {
        ISuperPlayer iSuperPlayer = this.f347755a;
        if (iSuperPlayer == null) {
            QLog.e("MediaPlayerSuperImpl", 1, "[setOnPreparedListener error], mMediaPlayer is null.");
        } else {
            iSuperPlayer.setOnVideoPreparedListener(new b(onPreparedListener));
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer
    public void setOnSeekCompleteListener(IMediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        ISuperPlayer iSuperPlayer = this.f347755a;
        if (iSuperPlayer == null) {
            QLog.e("MediaPlayerSuperImpl", 1, "[setOnSeekCompleteListener error] mMediaPlayer is null.");
        } else {
            iSuperPlayer.setOnSeekCompleteListener(new d(onSeekCompleteListener));
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer
    public void setOnVideoSizeChangedListener(IMediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        ISuperPlayer iSuperPlayer = this.f347755a;
        if (iSuperPlayer == null) {
            QLog.e("MediaPlayerSuperImpl", 1, "[setOnVideoSizeChangedListener error] mMediaPlayer is null.");
        } else {
            iSuperPlayer.setOnVideoSizeChangedListener(new e(onVideoSizeChangedListener));
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer
    public void setRate(float f16) {
        ISuperPlayer iSuperPlayer = this.f347755a;
        if (iSuperPlayer == null) {
            QLog.e("MediaPlayerSuperImpl", 1, "[setRate error] mMediaPlayer is null.");
        } else {
            iSuperPlayer.setPlaySpeedRatio(f16);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer
    public void setSurface(Surface surface) {
        ISuperPlayer iSuperPlayer = this.f347755a;
        if (iSuperPlayer == null) {
            QLog.e("MediaPlayerSuperImpl", 1, "[setSurface error] mMediaPlayer is null.");
        } else {
            iSuperPlayer.setSurface(surface);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer
    public void setVolume(float f16, float f17) {
        ISuperPlayer iSuperPlayer = this.f347755a;
        if (iSuperPlayer == null) {
            QLog.e("MediaPlayerSuperImpl", 1, "[setVolume error], mMediaPlayer is null.");
        } else {
            iSuperPlayer.setOutputMute(f16 == 0.0f && f17 == 0.0f);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer
    public void start() throws IllegalStateException {
        if (this.f347755a == null) {
            QLog.e("MediaPlayerSuperImpl", 1, "[start error] mMediaPlayer is null.");
        } else {
            QLog.d("MediaPlayerSuperImpl", 1, "mMediaPlayer start!");
            this.f347755a.start();
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer
    public void stop() throws IllegalStateException {
        if (this.f347755a == null) {
            QLog.e("MediaPlayerSuperImpl", 1, "[stop error] mMediaPlayer is null.");
        } else {
            QLog.d("MediaPlayerSuperImpl", 1, "mMediaPlayer stop!");
            this.f347755a.stop();
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer
    public void seekTo(long j3) throws IllegalStateException {
        ISuperPlayer iSuperPlayer;
        int i3 = (int) j3;
        if (i3 != Integer.MIN_VALUE && (iSuperPlayer = this.f347755a) != null) {
            iSuperPlayer.seekTo(i3, 3);
        } else {
            QLog.e("MediaPlayerSuperImpl", 1, "[seekTo error] mMediaPlayer is null or invalid params.");
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer
    public void setDisplay(SurfaceHolder surfaceHolder) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer
    public void setOnBufferingUpdateListener(IMediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer
    public void setOnLoopStartListener(IMediaPlayer.OnLoopStartListener onLoopStartListener) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer
    public void setScreenOnWhilePlaying(boolean z16) {
    }
}
