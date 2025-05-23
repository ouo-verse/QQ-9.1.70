package com.tencent.qqmini.proxyimpl;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerOption;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.view.ISPlayerVideoView;

/* compiled from: P */
/* loaded from: classes34.dex */
public class a extends AbsVideoPlayer {

    /* renamed from: a, reason: collision with root package name */
    private ISuperPlayer f347718a;

    /* renamed from: b, reason: collision with root package name */
    private ISPlayerVideoView f347719b;

    /* renamed from: c, reason: collision with root package name */
    private SuperPlayerVideoInfo f347720c;

    /* compiled from: P */
    /* renamed from: com.tencent.qqmini.proxyimpl.a$a, reason: collision with other inner class name */
    /* loaded from: classes34.dex */
    class C9405a implements SDKInitListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f347721d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ AbsVideoPlayer.OnVideoViewInitListener f347722e;

        C9405a(boolean z16, AbsVideoPlayer.OnVideoViewInitListener onVideoViewInitListener) {
            this.f347721d = z16;
            this.f347722e = onVideoViewInitListener;
        }

        @Override // com.tencent.mobileqq.videoplatform.SDKInitListener
        public void onSDKInited(boolean z16) {
            QLog.d("MiniAppVideoPlayer_SuperPlayer", 1, "superPlayer onSDKInited :" + z16);
            if (z16) {
                a.this.f347719b = SuperPlayerFactory.createPlayerVideoView(BaseApplication.getContext(), !this.f347721d);
                a.this.f347718a = SuperPlayerFactory.createMediaPlayer(BaseApplication.getContext(), 114, a.this.f347719b);
                if (this.f347722e == null || !(a.this.f347719b instanceof View)) {
                    return;
                }
                this.f347722e.onVideoViewInit((View) a.this.f347719b);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes34.dex */
    class b implements ISuperPlayer.OnVideoPreparedListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AbsVideoPlayer.OnVideoPreparedListener f347724d;

        b(AbsVideoPlayer.OnVideoPreparedListener onVideoPreparedListener) {
            this.f347724d = onVideoPreparedListener;
        }

        @Override // com.tencent.superplayer.api.ISuperPlayer.OnVideoPreparedListener
        public void onVideoPrepared(ISuperPlayer iSuperPlayer) {
            this.f347724d.onVideoPrepared(a.this);
        }
    }

    /* compiled from: P */
    /* loaded from: classes34.dex */
    class c implements ISuperPlayer.OnCompletionListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AbsVideoPlayer.OnCompletionListener f347726d;

        c(AbsVideoPlayer.OnCompletionListener onCompletionListener) {
            this.f347726d = onCompletionListener;
        }

        @Override // com.tencent.superplayer.api.ISuperPlayer.OnCompletionListener
        public void onCompletion(ISuperPlayer iSuperPlayer) {
            this.f347726d.onCompletion(a.this);
        }
    }

    /* compiled from: P */
    /* loaded from: classes34.dex */
    class d implements ISuperPlayer.OnErrorListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AbsVideoPlayer.OnErrorListener f347728d;

        d(AbsVideoPlayer.OnErrorListener onErrorListener) {
            this.f347728d = onErrorListener;
        }

        @Override // com.tencent.superplayer.api.ISuperPlayer.OnErrorListener
        public boolean onError(ISuperPlayer iSuperPlayer, int i3, int i16, int i17, String str) {
            QLog.e("AbsVideoPlayerSuperImpl", 1, "onError i =" + i3 + "i1 =" + i16 + " i2 =" + i17 + "s =" + str);
            return this.f347728d.onError(a.this, i3, i16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes34.dex */
    class e implements ISuperPlayer.OnInfoListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AbsVideoPlayer.OnInfoListener f347730d;

        e(AbsVideoPlayer.OnInfoListener onInfoListener) {
            this.f347730d = onInfoListener;
        }

        @Override // com.tencent.superplayer.api.ISuperPlayer.OnInfoListener
        public boolean onInfo(ISuperPlayer iSuperPlayer, int i3, long j3, long j16, Object obj) {
            return this.f347730d.onInfo(a.this, i3, 0);
        }
    }

    /* compiled from: P */
    /* loaded from: classes34.dex */
    class f implements ISuperPlayer.OnSeekCompleteListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AbsVideoPlayer.OnSeekCompleteListener f347732d;

        f(AbsVideoPlayer.OnSeekCompleteListener onSeekCompleteListener) {
            this.f347732d = onSeekCompleteListener;
        }

        @Override // com.tencent.superplayer.api.ISuperPlayer.OnSeekCompleteListener
        public void onSeekComplete(ISuperPlayer iSuperPlayer) {
            this.f347732d.onSeekComplete(a.this);
        }
    }

    /* compiled from: P */
    /* loaded from: classes34.dex */
    class g implements ISuperPlayer.OnCaptureImageListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AbsVideoPlayer.OnCaptureImageListener f347734d;

        g(AbsVideoPlayer.OnCaptureImageListener onCaptureImageListener) {
            this.f347734d = onCaptureImageListener;
        }

        @Override // com.tencent.superplayer.api.ISuperPlayer.OnCaptureImageListener
        public void onCaptureImageFailed(ISuperPlayer iSuperPlayer, int i3, int i16) {
            this.f347734d.onCaptureImageFailed();
        }

        @Override // com.tencent.superplayer.api.ISuperPlayer.OnCaptureImageListener
        public void onCaptureImageSucceed(ISuperPlayer iSuperPlayer, int i3, int i16, int i17, Bitmap bitmap) {
            this.f347734d.onCaptureImageSucceed(bitmap);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer
    public int captureImageInTime(int i3, int i16) {
        ISuperPlayer iSuperPlayer = this.f347718a;
        if (iSuperPlayer == null) {
            return 0;
        }
        try {
            return iSuperPlayer.captureImageInTime(-1L, i3, i16);
        } catch (IllegalAccessException e16) {
            e16.printStackTrace();
            return 0;
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer
    public void createVideoView(Context context, AbsVideoPlayer.OnVideoViewInitListener onVideoViewInitListener, boolean z16) {
        if (QQVideoPlaySDKManager.isSDKReady()) {
            QLog.d("MiniAppVideoPlayer_SuperPlayer", 1, "createVideoView: superPlayer sdk is ready, isUseSurface=" + z16);
            this.f347719b = SuperPlayerFactory.createPlayerVideoView(BaseApplication.getContext(), z16 ^ true);
            this.f347718a = SuperPlayerFactory.createMediaPlayer(BaseApplication.getContext(), 114, this.f347719b);
            if (onVideoViewInitListener != null) {
                Object obj = this.f347719b;
                if (obj instanceof View) {
                    onVideoViewInitListener.onVideoViewInit((View) obj);
                    return;
                }
                return;
            }
            return;
        }
        QLog.e("MiniAppVideoPlayer_SuperPlayer", 1, "superPlayer sdk no ready when doing createVideoView, isUseSurface=" + z16);
        QQVideoPlaySDKManager.initSDKAsync(BaseApplicationImpl.getApplication(), new C9405a(z16, onVideoViewInitListener));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer
    public long getCurrentPostion() {
        ISuperPlayer iSuperPlayer = this.f347718a;
        if (iSuperPlayer != null) {
            return iSuperPlayer.getCurrentPositionMs();
        }
        return 0L;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer
    public long getDuration() {
        ISuperPlayer iSuperPlayer = this.f347718a;
        if (iSuperPlayer != null) {
            return iSuperPlayer.getDurationMs();
        }
        return 0L;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer
    public boolean getOutputMute() {
        ISuperPlayer iSuperPlayer = this.f347718a;
        if (iSuperPlayer != null) {
            return iSuperPlayer.isOutputMute();
        }
        return false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer
    public int getVideoHeight() {
        ISuperPlayer iSuperPlayer = this.f347718a;
        if (iSuperPlayer != null) {
            return iSuperPlayer.getVideoHeight();
        }
        return 0;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer
    public int getVideoWidth() {
        ISuperPlayer iSuperPlayer = this.f347718a;
        if (iSuperPlayer != null) {
            return iSuperPlayer.getVideoWidth();
        }
        return 0;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer
    public boolean isPlaying() {
        ISuperPlayer iSuperPlayer = this.f347718a;
        if (iSuperPlayer != null) {
            return iSuperPlayer.isPlaying();
        }
        return false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer
    public boolean isSuperPlayer() {
        return true;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer
    public void openMediaPlayerByUrl(Context context, String str, long j3) {
        ISuperPlayer iSuperPlayer = this.f347718a;
        if (iSuperPlayer != null) {
            if (iSuperPlayer.getVideoView() == null && this.f347719b != null) {
                QLog.i("AbsVideoPlayerSuperImpl", 1, "openMediaPlayerByUrl: with url, update player video view");
                this.f347718a.updatePlayerVideoView(this.f347719b);
            }
            SuperPlayerVideoInfo createVideoInfoForUrl = SuperPlayerFactory.createVideoInfoForUrl(str, 104, MD5Utils.toMD5(str));
            SuperPlayerOption obtain = SuperPlayerOption.obtain();
            obtain.enableCodecReuse = false;
            obtain.isPrePlay = false;
            this.f347718a.openMediaPlayer(context, createVideoInfoForUrl, j3);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer
    public void pause() {
        ISuperPlayer iSuperPlayer = this.f347718a;
        if (iSuperPlayer != null) {
            iSuperPlayer.pause();
            QLog.d("AbsVideoPlayerSuperImpl", 1, "mPlayer pause!");
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer
    public void release() {
        ISuperPlayer iSuperPlayer = this.f347718a;
        if (iSuperPlayer != null) {
            iSuperPlayer.release();
            QLog.d("AbsVideoPlayerSuperImpl", 1, "mPlayer release!");
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer
    public void reset() {
        ISuperPlayer iSuperPlayer = this.f347718a;
        if (iSuperPlayer == null) {
            QLog.e("AbsVideoPlayerSuperImpl", 1, "reset error, player is null.");
        } else {
            iSuperPlayer.reset();
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer
    public void seekTo(int i3) {
        ISuperPlayer iSuperPlayer = this.f347718a;
        if (iSuperPlayer != null) {
            iSuperPlayer.seekTo(i3, 3);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer
    public void setDataSource(String str) throws IllegalArgumentException, SecurityException, IllegalStateException, UnsupportedOperationException {
        if (this.f347718a == null) {
            QLog.e("AbsVideoPlayerSuperImpl", 1, "[startPlay(setDataSource) error] mMediaPlayer is null.");
            return;
        }
        QLog.d("AbsVideoPlayerSuperImpl", 1, "setDataSource [startPlay] url = " + str);
        this.f347720c = SuperPlayerFactory.createVideoInfoForUrl(str, 100, MD5Utils.toMD5(str));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer
    public void setDrmDataSource(String str, String str2, String str3) throws IllegalArgumentException, SecurityException, IllegalStateException, UnsupportedOperationException {
        if (this.f347718a == null) {
            QLog.e("AbsVideoPlayerSuperImpl", 1, "[startPlay(setDataSource) error] mMediaPlayer is null.");
            return;
        }
        QLog.d("AbsVideoPlayerSuperImpl", 1, "setDrmDataSource [startPlay drm] url = " + str);
        this.f347720c = SuperPlayerFactory.createVideoInfoForDRM(0, str, 102, str2, str3);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer
    public void setLoopback(boolean z16) {
        ISuperPlayer iSuperPlayer = this.f347718a;
        if (iSuperPlayer != null) {
            iSuperPlayer.setLoopback(z16);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer
    public void setOnCaptureImageListener(AbsVideoPlayer.OnCaptureImageListener onCaptureImageListener) {
        ISuperPlayer iSuperPlayer = this.f347718a;
        if (iSuperPlayer != null) {
            iSuperPlayer.setOnCaptureImageListener(new g(onCaptureImageListener));
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer
    public void setOnCompletionListener(AbsVideoPlayer.OnCompletionListener onCompletionListener) {
        ISuperPlayer iSuperPlayer = this.f347718a;
        if (iSuperPlayer != null) {
            iSuperPlayer.setOnCompletionListener(new c(onCompletionListener));
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer
    public void setOnErrorListener(AbsVideoPlayer.OnErrorListener onErrorListener) {
        ISuperPlayer iSuperPlayer = this.f347718a;
        if (iSuperPlayer != null) {
            iSuperPlayer.setOnErrorListener(new d(onErrorListener));
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer
    public void setOnInfoListener(AbsVideoPlayer.OnInfoListener onInfoListener) {
        ISuperPlayer iSuperPlayer = this.f347718a;
        if (iSuperPlayer != null) {
            iSuperPlayer.setOnInfoListener(new e(onInfoListener));
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer
    public void setOnSeekCompleteListener(AbsVideoPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        ISuperPlayer iSuperPlayer = this.f347718a;
        if (iSuperPlayer != null) {
            iSuperPlayer.setOnSeekCompleteListener(new f(onSeekCompleteListener));
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer
    public void setOnVideoPreparedListener(AbsVideoPlayer.OnVideoPreparedListener onVideoPreparedListener) {
        ISuperPlayer iSuperPlayer = this.f347718a;
        if (iSuperPlayer != null) {
            iSuperPlayer.setOnVideoPreparedListener(new b(onVideoPreparedListener));
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer
    public boolean setOutputMute(boolean z16) {
        ISuperPlayer iSuperPlayer = this.f347718a;
        if (iSuperPlayer == null) {
            return false;
        }
        iSuperPlayer.setOutputMute(z16);
        return true;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer
    public void setXYaxis(int i3) {
        ISuperPlayer iSuperPlayer = this.f347718a;
        if (iSuperPlayer != null) {
            iSuperPlayer.setXYaxis(i3);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer
    public void start() {
        ISuperPlayer iSuperPlayer = this.f347718a;
        if (iSuperPlayer != null) {
            iSuperPlayer.start();
            QLog.d("AbsVideoPlayerSuperImpl", 1, "mPlayer start!");
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer
    public void stop() {
        ISuperPlayer iSuperPlayer = this.f347718a;
        if (iSuperPlayer != null) {
            iSuperPlayer.stop();
            this.f347718a.reset();
            QLog.d("AbsVideoPlayerSuperImpl", 1, "mPlayer stop!");
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer
    public void openMediaPlayerByUrl(Context context, long j3) {
        ISuperPlayer iSuperPlayer = this.f347718a;
        if (iSuperPlayer != null) {
            if (iSuperPlayer.getVideoView() == null && this.f347719b != null) {
                QLog.d("AbsVideoPlayerSuperImpl", 1, "openMediaPlayerByUrl: update player video view");
                this.f347718a.updatePlayerVideoView(this.f347719b);
            }
            this.f347718a.openMediaPlayer(context, this.f347720c, j3);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer
    public void startPlayDanmu() {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer
    public void stopPlayDanmu() {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer
    public void setOnControllerClickListener(AbsVideoPlayer.OnControllerClickListener onControllerClickListener) {
    }
}
