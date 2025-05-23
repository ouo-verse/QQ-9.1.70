package com.tencent.qqmini.proxyimpl;

import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.oskplayer.player.OskExoMediaPlayer;
import com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer;
import java.io.IOException;
import tv.danmaku.ijk.media.player.IMediaPlayer;

/* compiled from: P */
/* loaded from: classes34.dex */
public class ac implements IMediaPlayer {

    /* renamed from: a, reason: collision with root package name */
    OskExoMediaPlayer f347738a = new OskExoMediaPlayer();

    /* compiled from: P */
    /* loaded from: classes34.dex */
    class a implements IMediaPlayer.OnPreparedListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ IMediaPlayer.OnPreparedListener f347739d;

        a(IMediaPlayer.OnPreparedListener onPreparedListener) {
            this.f347739d = onPreparedListener;
        }

        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener
        public void onPrepared(tv.danmaku.ijk.media.player.IMediaPlayer iMediaPlayer) {
            this.f347739d.onPrepared(ac.this);
        }
    }

    /* compiled from: P */
    /* loaded from: classes34.dex */
    class b implements IMediaPlayer.OnCompletionListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ IMediaPlayer.OnCompletionListener f347741d;

        b(IMediaPlayer.OnCompletionListener onCompletionListener) {
            this.f347741d = onCompletionListener;
        }

        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnCompletionListener
        public void onCompletion(tv.danmaku.ijk.media.player.IMediaPlayer iMediaPlayer) {
            this.f347741d.onCompletion(ac.this);
        }
    }

    /* compiled from: P */
    /* loaded from: classes34.dex */
    class c implements IMediaPlayer.OnBufferingUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ IMediaPlayer.OnBufferingUpdateListener f347743d;

        c(IMediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
            this.f347743d = onBufferingUpdateListener;
        }

        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(tv.danmaku.ijk.media.player.IMediaPlayer iMediaPlayer, int i3) {
            this.f347743d.onBufferingUpdate(ac.this, i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes34.dex */
    class d implements IMediaPlayer.OnSeekCompleteListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ IMediaPlayer.OnSeekCompleteListener f347745d;

        d(IMediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
            this.f347745d = onSeekCompleteListener;
        }

        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(tv.danmaku.ijk.media.player.IMediaPlayer iMediaPlayer) {
            this.f347745d.onSeekComplete(ac.this);
        }
    }

    /* compiled from: P */
    /* loaded from: classes34.dex */
    class e implements IMediaPlayer.OnVideoSizeChangedListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ IMediaPlayer.OnVideoSizeChangedListener f347747d;

        e(IMediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
            this.f347747d = onVideoSizeChangedListener;
        }

        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(tv.danmaku.ijk.media.player.IMediaPlayer iMediaPlayer, int i3, int i16) {
            this.f347747d.onVideoSizeChanged(ac.this, i3, i16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes34.dex */
    class f implements IMediaPlayer.OnErrorListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ IMediaPlayer.OnErrorListener f347749d;

        f(IMediaPlayer.OnErrorListener onErrorListener) {
            this.f347749d = onErrorListener;
        }

        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnErrorListener
        public boolean onError(tv.danmaku.ijk.media.player.IMediaPlayer iMediaPlayer, int i3, int i16) {
            return this.f347749d.onError(ac.this, i3, i16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes34.dex */
    class g implements IMediaPlayer.OnInfoListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ IMediaPlayer.OnInfoListener f347751d;

        g(IMediaPlayer.OnInfoListener onInfoListener) {
            this.f347751d = onInfoListener;
        }

        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener
        public boolean onInfo(tv.danmaku.ijk.media.player.IMediaPlayer iMediaPlayer, int i3, int i16) {
            return this.f347751d.onInfo(ac.this, i3, i16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes34.dex */
    class h implements IMediaPlayer.OnLoopStartListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ IMediaPlayer.OnLoopStartListener f347753d;

        h(IMediaPlayer.OnLoopStartListener onLoopStartListener) {
            this.f347753d = onLoopStartListener;
        }

        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnLoopStartListener
        public void onLoopStart(tv.danmaku.ijk.media.player.IMediaPlayer iMediaPlayer) {
            this.f347753d.onLoopStart(ac.this);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer
    public int getBufferPercent() {
        return 0;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer
    public long getCurrentPosition() {
        return this.f347738a.getCurrentPosition();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer
    public long getDuration() {
        return this.f347738a.getDuration();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer
    public int getVideoHeight() {
        return this.f347738a.getVideoHeight();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer
    public int getVideoWidth() {
        return this.f347738a.getVideoWidth();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer
    public boolean isLooping() {
        return this.f347738a.isLooping();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer
    public boolean isPlaying() {
        return this.f347738a.isPlaying();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer
    public boolean isSuperPlayer() {
        return false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer
    public void pause() throws IllegalStateException {
        try {
            this.f347738a.pause();
        } catch (IMediaPlayer.InternalOperationException e16) {
            throw new IllegalStateException(e16);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer
    public void prepareAsync() throws IllegalStateException {
        this.f347738a.prepareAsync();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer
    public void release() {
        this.f347738a.release();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer
    public void reset() {
        this.f347738a.reset();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer
    public void seekTo(long j3) throws IllegalStateException {
        this.f347738a.seekTo(j3);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer
    public void setDataSource(String str) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException, UnsupportedOperationException {
        this.f347738a.setDataSource(str);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer
    public void setDisplay(SurfaceHolder surfaceHolder) {
        this.f347738a.setDisplay(surfaceHolder);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer
    public void setDrmDataSource(String str, String str2, String str3) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException, UnsupportedOperationException {
        this.f347738a.setDataSource(str);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer
    public void setLooping(boolean z16) {
        this.f347738a.setLooping(z16);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer
    public void setOnBufferingUpdateListener(IMediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
        this.f347738a.setOnBufferingUpdateListener(new c(onBufferingUpdateListener));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer
    public void setOnCompletionListener(IMediaPlayer.OnCompletionListener onCompletionListener) {
        this.f347738a.setOnCompletionListener(new b(onCompletionListener));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer
    public void setOnErrorListener(IMediaPlayer.OnErrorListener onErrorListener) {
        this.f347738a.setOnErrorListener(new f(onErrorListener));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer
    public void setOnInfoListener(IMediaPlayer.OnInfoListener onInfoListener) {
        this.f347738a.setOnInfoListener(new g(onInfoListener));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer
    public void setOnLoopStartListener(IMediaPlayer.OnLoopStartListener onLoopStartListener) {
        this.f347738a.setOnLoopStartListener(new h(onLoopStartListener));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer
    public void setOnPreparedListener(IMediaPlayer.OnPreparedListener onPreparedListener) {
        this.f347738a.setOnPreparedListener(new a(onPreparedListener));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer
    public void setOnSeekCompleteListener(IMediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        this.f347738a.setOnSeekCompleteListener(new d(onSeekCompleteListener));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer
    public void setOnVideoSizeChangedListener(IMediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        this.f347738a.setOnVideoSizeChangedListener(new e(onVideoSizeChangedListener));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer
    public void setRate(float f16) {
        this.f347738a.setRate(f16);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer
    public void setScreenOnWhilePlaying(boolean z16) {
        this.f347738a.setScreenOnWhilePlaying(z16);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer
    public void setSurface(Surface surface) {
        this.f347738a.setSurface(surface);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer
    public void setVolume(float f16, float f17) {
        this.f347738a.setVolume(f16, f17);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer
    public void start() throws IllegalStateException {
        try {
            this.f347738a.start();
        } catch (IMediaPlayer.InternalOperationException e16) {
            throw new IllegalStateException(e16);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer
    public void stop() throws IllegalStateException {
        this.f347738a.stop();
    }
}
