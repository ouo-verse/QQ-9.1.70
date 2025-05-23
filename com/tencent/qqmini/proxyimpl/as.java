package com.tencent.qqmini.proxyimpl;

import android.content.Context;
import android.net.Uri;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.oskplayer.PlayerConfig;
import com.tencent.oskplayer.player.OskExoMediaPlayer;
import com.tencent.oskplayer.proxy.VideoManager;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.widget.ReliableVideoPlayer;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.Map;
import tv.danmaku.ijk.media.player.IMediaPlayer;

/* compiled from: P */
/* loaded from: classes34.dex */
public class as implements ReliableVideoPlayer {

    /* renamed from: a, reason: collision with root package name */
    private OskExoMediaPlayer f347799a;

    /* compiled from: P */
    /* loaded from: classes34.dex */
    class a implements IMediaPlayer.OnLoopStartListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ReliableVideoPlayer.OnLoopStartListener f347800d;

        a(ReliableVideoPlayer.OnLoopStartListener onLoopStartListener) {
            this.f347800d = onLoopStartListener;
        }

        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnLoopStartListener
        public void onLoopStart(IMediaPlayer iMediaPlayer) {
            ReliableVideoPlayer.OnLoopStartListener onLoopStartListener = this.f347800d;
            if (onLoopStartListener != null) {
                onLoopStartListener.onLoopStart(as.this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes34.dex */
    class b implements IMediaPlayer.OnPreparedListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ReliableVideoPlayer.OnPreparedListener f347802d;

        b(ReliableVideoPlayer.OnPreparedListener onPreparedListener) {
            this.f347802d = onPreparedListener;
        }

        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener
        public void onPrepared(IMediaPlayer iMediaPlayer) {
            ReliableVideoPlayer.OnPreparedListener onPreparedListener = this.f347802d;
            if (onPreparedListener != null) {
                onPreparedListener.onPrepared(as.this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes34.dex */
    class c implements IMediaPlayer.OnCompletionListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ReliableVideoPlayer.OnCompletionListener f347804d;

        c(ReliableVideoPlayer.OnCompletionListener onCompletionListener) {
            this.f347804d = onCompletionListener;
        }

        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnCompletionListener
        public void onCompletion(IMediaPlayer iMediaPlayer) {
            ReliableVideoPlayer.OnCompletionListener onCompletionListener = this.f347804d;
            if (onCompletionListener != null) {
                onCompletionListener.onCompletion(as.this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes34.dex */
    class d implements IMediaPlayer.OnBufferingUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ReliableVideoPlayer.OnBufferingUpdateListener f347806d;

        d(ReliableVideoPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
            this.f347806d = onBufferingUpdateListener;
        }

        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(IMediaPlayer iMediaPlayer, int i3) {
            ReliableVideoPlayer.OnBufferingUpdateListener onBufferingUpdateListener = this.f347806d;
            if (onBufferingUpdateListener != null) {
                onBufferingUpdateListener.onBufferingUpdate(as.this, i3);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes34.dex */
    class e implements IMediaPlayer.OnSeekCompleteListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ReliableVideoPlayer.OnSeekCompleteListener f347808d;

        e(ReliableVideoPlayer.OnSeekCompleteListener onSeekCompleteListener) {
            this.f347808d = onSeekCompleteListener;
        }

        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(IMediaPlayer iMediaPlayer) {
            ReliableVideoPlayer.OnSeekCompleteListener onSeekCompleteListener = this.f347808d;
            if (onSeekCompleteListener != null) {
                onSeekCompleteListener.onSeekComplete(as.this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes34.dex */
    class f implements IMediaPlayer.OnVideoSizeChangedListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ReliableVideoPlayer.OnVideoSizeChangedListener f347810d;

        f(ReliableVideoPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
            this.f347810d = onVideoSizeChangedListener;
        }

        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(IMediaPlayer iMediaPlayer, int i3, int i16) {
            ReliableVideoPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener = this.f347810d;
            if (onVideoSizeChangedListener != null) {
                onVideoSizeChangedListener.onVideoSizeChanged(as.this, i3, i16);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes34.dex */
    class g implements IMediaPlayer.OnErrorListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ReliableVideoPlayer.OnErrorListener f347812d;

        g(ReliableVideoPlayer.OnErrorListener onErrorListener) {
            this.f347812d = onErrorListener;
        }

        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnErrorListener
        public boolean onError(IMediaPlayer iMediaPlayer, int i3, int i16) {
            ReliableVideoPlayer.OnErrorListener onErrorListener = this.f347812d;
            if (onErrorListener != null) {
                return onErrorListener.onError(as.this, i3, i16);
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes34.dex */
    class h implements IMediaPlayer.OnInfoListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ReliableVideoPlayer.OnInfoListener f347814d;

        h(ReliableVideoPlayer.OnInfoListener onInfoListener) {
            this.f347814d = onInfoListener;
        }

        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener
        public boolean onInfo(IMediaPlayer iMediaPlayer, int i3, int i16) {
            ReliableVideoPlayer.OnInfoListener onInfoListener = this.f347814d;
            if (onInfoListener != null) {
                return onInfoListener.onInfo(as.this, i3, i16);
            }
            return false;
        }
    }

    public as() {
        if (!PlayerConfig.hasInit()) {
            Context context = AppLoaderFactory.g().getContext();
            if (context != null) {
                PlayerConfig.init(context);
                PlayerConfig.g().setLogger(new v());
            } else {
                throw new RuntimeException("BaseApplicationImpl ctx is null");
            }
        }
        if (!VideoManager.hasInit()) {
            VideoManager.init(AppLoaderFactory.g().getContext());
        }
        ChannelProxyImpl.r(AppLoaderFactory.g().getContext());
        this.f347799a = new OskExoMediaPlayer();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.widget.ReliableVideoPlayer
    public int getAudioSessionId() {
        return this.f347799a.getAudioSessionId();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.widget.ReliableVideoPlayer
    public long getCurrentPosition() {
        return this.f347799a.getCurrentPosition();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.widget.ReliableVideoPlayer
    public String getDataSource() {
        return this.f347799a.getDataSource();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.widget.ReliableVideoPlayer
    public long getDuration() {
        return this.f347799a.getDuration();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.widget.ReliableVideoPlayer
    public int getScore() {
        return this.f347799a.getScore();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.widget.ReliableVideoPlayer
    public int getVideoHeight() {
        return this.f347799a.getVideoHeight();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.widget.ReliableVideoPlayer
    public int getVideoSarDen() {
        return this.f347799a.getVideoSarDen();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.widget.ReliableVideoPlayer
    public int getVideoSarNum() {
        return this.f347799a.getVideoSarNum();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.widget.ReliableVideoPlayer
    public int getVideoWidth() {
        return this.f347799a.getVideoWidth();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.widget.ReliableVideoPlayer
    public boolean isLooping() {
        return this.f347799a.isLooping();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.widget.ReliableVideoPlayer
    public boolean isPlayable() {
        return this.f347799a.isPlayable();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.widget.ReliableVideoPlayer
    public boolean isPlaying() {
        return this.f347799a.isPlaying();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.widget.ReliableVideoPlayer
    public void pause() throws Exception {
        this.f347799a.pause();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.widget.ReliableVideoPlayer
    public void prepareAsync() throws IllegalStateException {
        this.f347799a.prepareAsync();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.widget.ReliableVideoPlayer
    public void release() {
        this.f347799a.release();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.widget.ReliableVideoPlayer
    public void reset() {
        this.f347799a.reset();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.widget.ReliableVideoPlayer
    public void seekTo(long j3) throws IllegalStateException {
        this.f347799a.seekTo(j3);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.widget.ReliableVideoPlayer
    public void setAudioStreamType(int i3) {
        this.f347799a.setAudioStreamType(i3);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.widget.ReliableVideoPlayer
    public void setDataSource(Context context, Uri uri) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException, UnsupportedOperationException {
        this.f347799a.setDataSource(context, uri);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.widget.ReliableVideoPlayer
    public void setDisplay(SurfaceHolder surfaceHolder) {
        this.f347799a.setDisplay(surfaceHolder);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.widget.ReliableVideoPlayer
    public void setKeepInBackground(boolean z16) {
        this.f347799a.setKeepInBackground(z16);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.widget.ReliableVideoPlayer
    public void setLogEnabled(boolean z16) {
        this.f347799a.setLogEnabled(z16);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.widget.ReliableVideoPlayer
    public void setLooping(boolean z16) {
        this.f347799a.setLooping(z16);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.widget.ReliableVideoPlayer
    public void setNextMediaPlayer(ReliableVideoPlayer reliableVideoPlayer) throws UnsupportedOperationException {
        if (reliableVideoPlayer instanceof as) {
            this.f347799a.setNextMediaPlayer(((as) reliableVideoPlayer).f347799a);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.widget.ReliableVideoPlayer
    public void setOnBufferingUpdateListener(ReliableVideoPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
        this.f347799a.setOnBufferingUpdateListener(new d(onBufferingUpdateListener));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.widget.ReliableVideoPlayer
    public void setOnCompletionListener(ReliableVideoPlayer.OnCompletionListener onCompletionListener) {
        this.f347799a.setOnCompletionListener(new c(onCompletionListener));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.widget.ReliableVideoPlayer
    public void setOnErrorListener(ReliableVideoPlayer.OnErrorListener onErrorListener) {
        this.f347799a.setOnErrorListener(new g(onErrorListener));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.widget.ReliableVideoPlayer
    public void setOnInfoListener(ReliableVideoPlayer.OnInfoListener onInfoListener) {
        this.f347799a.setOnInfoListener(new h(onInfoListener));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.widget.ReliableVideoPlayer
    public void setOnLoopStartListener(ReliableVideoPlayer.OnLoopStartListener onLoopStartListener) {
        this.f347799a.setOnLoopStartListener(new a(onLoopStartListener));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.widget.ReliableVideoPlayer
    public void setOnPreparedListener(ReliableVideoPlayer.OnPreparedListener onPreparedListener) {
        this.f347799a.setOnPreparedListener(new b(onPreparedListener));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.widget.ReliableVideoPlayer
    public void setOnSeekCompleteListener(ReliableVideoPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        this.f347799a.setOnSeekCompleteListener(new e(onSeekCompleteListener));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.widget.ReliableVideoPlayer
    public void setOnVideoSizeChangedListener(ReliableVideoPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        this.f347799a.setOnVideoSizeChangedListener(new f(onVideoSizeChangedListener));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.widget.ReliableVideoPlayer
    public void setScreenOnWhilePlaying(boolean z16) {
        this.f347799a.setScreenOnWhilePlaying(z16);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.widget.ReliableVideoPlayer
    public void setSurface(Surface surface) {
        this.f347799a.setSurface(surface);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.widget.ReliableVideoPlayer
    public void setVolume(float f16, float f17) {
        this.f347799a.setVolume(f16, f17);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.widget.ReliableVideoPlayer
    public void setWakeMode(Context context, int i3) {
        this.f347799a.setWakeMode(context, i3);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.widget.ReliableVideoPlayer
    public void start() throws Exception {
        this.f347799a.start();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.widget.ReliableVideoPlayer
    public void stop() throws IllegalStateException {
        this.f347799a.stop();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.widget.ReliableVideoPlayer
    public void setDataSource(Context context, Uri uri, Map<String, String> map) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException, UnsupportedOperationException {
        this.f347799a.setDataSource(context, uri, map);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.widget.ReliableVideoPlayer
    public void setDataSource(FileDescriptor fileDescriptor) throws IOException, IllegalArgumentException, IllegalStateException, UnsupportedOperationException {
        this.f347799a.setDataSource(fileDescriptor);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.widget.ReliableVideoPlayer
    public void setDataSource(String str) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException, UnsupportedOperationException {
        this.f347799a.setDataSource(str);
    }
}
