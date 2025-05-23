package com.tencent.mtt.hippy.modules.nativemodules.audio;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.Log;
import com.tencent.mtt.hippy.utils.LogUtils;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer;
import java.io.IOException;
import java.util.EnumSet;

/* compiled from: P */
/* loaded from: classes20.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final MediaPlayer f337483a;

    /* renamed from: b, reason: collision with root package name */
    private EnumC9229a f337484b;

    /* renamed from: c, reason: collision with root package name */
    private final a f337485c;

    /* renamed from: d, reason: collision with root package name */
    private final MediaPlayer.OnPreparedListener f337486d;

    /* renamed from: e, reason: collision with root package name */
    private final MediaPlayer.OnCompletionListener f337487e;

    /* renamed from: f, reason: collision with root package name */
    private final MediaPlayer.OnBufferingUpdateListener f337488f;

    /* renamed from: g, reason: collision with root package name */
    private final MediaPlayer.OnErrorListener f337489g;

    /* compiled from: P */
    /* renamed from: com.tencent.mtt.hippy.modules.nativemodules.audio.a$a, reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    public enum EnumC9229a {
        IDLE,
        ERROR,
        INITIALIZED,
        PREPARING,
        PREPARED,
        STARTED,
        STOPPED,
        PLAYBACK_COMPLETE,
        PAUSED
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a() {
        MediaPlayer.OnPreparedListener onPreparedListener = new MediaPlayer.OnPreparedListener() { // from class: com.tencent.mtt.hippy.modules.nativemodules.audio.a.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                Log.d("MediaPlayerWrapper", "on prepared");
                a.this.f337484b = EnumC9229a.PREPARED;
                a.this.f337485c.a(mediaPlayer);
                a.this.f337483a.start();
                a.this.f337484b = EnumC9229a.STARTED;
            }
        };
        this.f337486d = onPreparedListener;
        MediaPlayer.OnCompletionListener onCompletionListener = new MediaPlayer.OnCompletionListener() { // from class: com.tencent.mtt.hippy.modules.nativemodules.audio.a.2
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                Log.d("MediaPlayerWrapper", "on completion");
                a.this.f337484b = EnumC9229a.PLAYBACK_COMPLETE;
                a.this.f337485c.b(mediaPlayer);
            }
        };
        this.f337487e = onCompletionListener;
        MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener = new MediaPlayer.OnBufferingUpdateListener() { // from class: com.tencent.mtt.hippy.modules.nativemodules.audio.a.3
            @Override // android.media.MediaPlayer.OnBufferingUpdateListener
            public void onBufferingUpdate(MediaPlayer mediaPlayer, int i3) {
                Log.d("MediaPlayerWrapper", "on buffering update");
                a.this.f337485c.a(mediaPlayer, i3);
            }
        };
        this.f337488f = onBufferingUpdateListener;
        MediaPlayer.OnErrorListener onErrorListener = new MediaPlayer.OnErrorListener() { // from class: com.tencent.mtt.hippy.modules.nativemodules.audio.a.4
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i3, int i16) {
                Log.d("MediaPlayerWrapper", "on error");
                a.this.f337484b = EnumC9229a.ERROR;
                a.this.f337485c.a(mediaPlayer, i3, i16);
                return false;
            }
        };
        this.f337489g = onErrorListener;
        this.f337485c = this;
        ReportMediaPlayer reportMediaPlayer = new ReportMediaPlayer();
        this.f337483a = reportMediaPlayer;
        this.f337484b = EnumC9229a.IDLE;
        reportMediaPlayer.setOnPreparedListener(onPreparedListener);
        reportMediaPlayer.setOnCompletionListener(onCompletionListener);
        reportMediaPlayer.setOnBufferingUpdateListener(onBufferingUpdateListener);
        reportMediaPlayer.setOnErrorListener(onErrorListener);
    }

    public void e() {
        Log.d("MediaPlayerWrapper", "stop()");
        EnumC9229a enumC9229a = EnumC9229a.PREPARED;
        EnumC9229a enumC9229a2 = EnumC9229a.STARTED;
        EnumC9229a enumC9229a3 = EnumC9229a.STOPPED;
        if (EnumSet.of(enumC9229a, enumC9229a2, enumC9229a3, EnumC9229a.PAUSED, EnumC9229a.PLAYBACK_COMPLETE).contains(this.f337484b)) {
            this.f337483a.stop();
            this.f337484b = enumC9229a3;
            return;
        }
        throw new RuntimeException();
    }

    public void f() {
        Log.d("MediaPlayerWrapper", "release()");
        this.f337483a.release();
    }

    public int g() {
        if (this.f337484b != EnumC9229a.ERROR) {
            return this.f337483a.getCurrentPosition();
        }
        return 0;
    }

    public int h() {
        if (EnumSet.of(EnumC9229a.PREPARED, EnumC9229a.STARTED, EnumC9229a.PAUSED, EnumC9229a.STOPPED, EnumC9229a.PLAYBACK_COMPLETE).contains(this.f337484b)) {
            return this.f337483a.getDuration();
        }
        return 100;
    }

    public void i() throws IOException {
        this.f337483a.prepare();
    }

    public void b(int i3) {
        this.f337483a.setAudioStreamType(i3);
    }

    public void c() {
        Log.d("MediaPlayerWrapper", "pause()");
        EnumC9229a enumC9229a = EnumC9229a.STARTED;
        EnumC9229a enumC9229a2 = EnumC9229a.PAUSED;
        if (!EnumSet.of(enumC9229a, enumC9229a2).contains(this.f337484b)) {
            throw new RuntimeException();
        }
        this.f337483a.pause();
        this.f337484b = enumC9229a2;
    }

    public void d() {
        Log.d("MediaPlayerWrapper", "start()");
        EnumC9229a enumC9229a = EnumC9229a.PREPARED;
        EnumC9229a enumC9229a2 = EnumC9229a.STARTED;
        if (!EnumSet.of(enumC9229a, enumC9229a2, EnumC9229a.PAUSED, EnumC9229a.PLAYBACK_COMPLETE).contains(this.f337484b)) {
            throw new RuntimeException();
        }
        this.f337483a.start();
        this.f337484b = enumC9229a2;
    }

    public void a() {
        Log.d("MediaPlayerWrapper", "prepareAsync()");
        if (!EnumSet.of(EnumC9229a.INITIALIZED, EnumC9229a.STOPPED).contains(this.f337484b)) {
            throw new RuntimeException();
        }
        this.f337483a.prepareAsync();
        this.f337484b = EnumC9229a.PREPARING;
    }

    public void b(MediaPlayer mediaPlayer) {
        LogUtils.d("MediaPlayerStateWrapper", "onCompletion");
    }

    public void a(int i3) {
        Log.d("MediaPlayerWrapper", "seekTo()");
        if (!EnumSet.of(EnumC9229a.PREPARED, EnumC9229a.STARTED, EnumC9229a.PAUSED, EnumC9229a.PLAYBACK_COMPLETE).contains(this.f337484b)) {
            throw new RuntimeException();
        }
        this.f337483a.seekTo(i3);
    }

    public boolean b() {
        Log.d("MediaPlayerWrapper", "isPlaying()");
        if (this.f337484b != EnumC9229a.ERROR) {
            return this.f337483a.isPlaying();
        }
        throw new RuntimeException();
    }

    public void a(Context context, Uri uri) {
        if (this.f337484b != EnumC9229a.IDLE) {
            throw new RuntimeException();
        }
        try {
            this.f337483a.setDataSource(context, uri);
            this.f337484b = EnumC9229a.INITIALIZED;
        } catch (IOException | IllegalArgumentException | IllegalStateException e16) {
            e16.printStackTrace();
        }
    }

    public void a(final MediaPlayer.OnCompletionListener onCompletionListener) {
        this.f337483a.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.tencent.mtt.hippy.modules.nativemodules.audio.a.6
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                a.this.f337487e.onCompletion(mediaPlayer);
                onCompletionListener.onCompletion(mediaPlayer);
            }
        });
    }

    public void a(final MediaPlayer.OnPreparedListener onPreparedListener) {
        this.f337483a.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.tencent.mtt.hippy.modules.nativemodules.audio.a.5
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                a.this.f337486d.onPrepared(mediaPlayer);
                onPreparedListener.onPrepared(mediaPlayer);
            }
        });
    }

    public void a(MediaPlayer mediaPlayer) {
        LogUtils.d("MediaPlayerStateWrapper", "onPrepared");
    }

    public void a(MediaPlayer mediaPlayer, int i3) {
        LogUtils.d("MediaPlayerStateWrapper", "onBufferingUpdate");
    }

    boolean a(MediaPlayer mediaPlayer, int i3, int i16) {
        return false;
    }
}
