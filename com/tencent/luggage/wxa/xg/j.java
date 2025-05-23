package com.tencent.luggage.wxa.xg;

import android.media.MediaPlayer;
import android.media.PlaybackParams;
import android.net.Uri;
import android.os.Build;
import android.view.Surface;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;

/* compiled from: P */
/* loaded from: classes9.dex */
public class j extends com.tencent.luggage.wxa.xg.a {

    /* renamed from: n, reason: collision with root package name */
    public MediaPlayer f144938n;

    /* renamed from: o, reason: collision with root package name */
    public MediaPlayer.OnPreparedListener f144939o = new a();

    /* renamed from: p, reason: collision with root package name */
    public MediaPlayer.OnVideoSizeChangedListener f144940p = new b();

    /* renamed from: q, reason: collision with root package name */
    public MediaPlayer.OnCompletionListener f144941q = new c();

    /* renamed from: r, reason: collision with root package name */
    public MediaPlayer.OnInfoListener f144942r = new d();

    /* renamed from: s, reason: collision with root package name */
    public MediaPlayer.OnSeekCompleteListener f144943s = new e();

    /* renamed from: t, reason: collision with root package name */
    public MediaPlayer.OnErrorListener f144944t = new f();

    /* renamed from: u, reason: collision with root package name */
    public MediaPlayer.OnBufferingUpdateListener f144945u = new g();

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements MediaPlayer.OnPreparedListener {
        public a() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            j.this.b(2);
            j.this.b();
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b implements MediaPlayer.OnVideoSizeChangedListener {
        public b() {
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i3, int i16) {
            j.this.c(i3, i16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class c implements MediaPlayer.OnCompletionListener {
        public c() {
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            j.this.b(6);
            j.this.a();
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class d implements MediaPlayer.OnInfoListener {
        public d() {
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i3, int i16) {
            return j.this.b(i3, i16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class e implements MediaPlayer.OnSeekCompleteListener {
        public e() {
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            j.this.c();
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class f implements MediaPlayer.OnErrorListener {
        public f() {
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i3, int i16) {
            return j.this.a(i3, i16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class g implements MediaPlayer.OnBufferingUpdateListener {
        public g() {
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i3) {
            j.this.a(i3);
        }
    }

    public j() {
        e();
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public com.tencent.luggage.wxa.xg.g a(Class cls) {
        if (j.class.isAssignableFrom(cls)) {
            return this;
        }
        return null;
    }

    public final void c(int i3) {
        MediaPlayer.OnErrorListener onErrorListener = this.f144944t;
        if (onErrorListener != null) {
            onErrorListener.onError(this.f144938n, -1024, i3);
        }
    }

    public final boolean d() {
        if (this.f144938n != null) {
            return true;
        }
        return false;
    }

    public final void e() {
        com.tencent.luggage.wxa.s9.h hVar = new com.tencent.luggage.wxa.s9.h();
        this.f144938n = hVar;
        hVar.setScreenOnWhilePlaying(true);
        this.f144938n.setAudioStreamType(3);
        this.f144938n.setOnInfoListener(this.f144942r);
        this.f144938n.setOnErrorListener(this.f144944t);
        this.f144938n.setOnPreparedListener(this.f144939o);
        this.f144938n.setOnCompletionListener(this.f144941q);
        this.f144938n.setOnSeekCompleteListener(this.f144943s);
        this.f144938n.setOnVideoSizeChangedListener(this.f144940p);
        this.f144938n.setOnBufferingUpdateListener(this.f144945u);
    }

    public final void f() {
        MediaPlayer mediaPlayer = this.f144938n;
        if (mediaPlayer == null) {
            return;
        }
        mediaPlayer.setOnInfoListener(null);
        this.f144938n.setOnErrorListener(null);
        this.f144938n.setOnPreparedListener(null);
        this.f144938n.setOnCompletionListener(null);
        this.f144938n.setOnSeekCompleteListener(null);
        this.f144938n.setOnBufferingUpdateListener(null);
        this.f144938n.setOnVideoSizeChangedListener(null);
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public int getCurrentPosition() {
        try {
            if (d() && (getState() == 2 || getState() == 3 || getState() == 4 || getState() == 6)) {
                return this.f144938n.getCurrentPosition();
            }
        } catch (Exception e16) {
            w.a("MicroMsg.SameLayer.SystemMediaPlayer", e16, "%s getCurrentPosition fail", Integer.valueOf(hashCode()));
            c(-15);
        }
        return 0;
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public int getDuration() {
        try {
            if (d() && getState() != -1 && getState() != 1 && getState() != 0) {
                return this.f144938n.getDuration();
            }
        } catch (Exception e16) {
            w.a("MicroMsg.SameLayer.SystemMediaPlayer", e16, "%s getDuration fail", Integer.valueOf(hashCode()));
            c(-16);
        }
        return 0;
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public int getPlayerType() {
        return 1;
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public int getVideoHeight() {
        try {
            if (d()) {
                return this.f144938n.getVideoHeight();
            }
        } catch (Exception e16) {
            w.a("MicroMsg.SameLayer.SystemMediaPlayer", e16, "%s getVideoHeight fail", Integer.valueOf(hashCode()));
            c(-18);
        }
        return 0;
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public int getVideoWidth() {
        try {
            if (d()) {
                return this.f144938n.getVideoWidth();
            }
        } catch (Exception e16) {
            w.a("MicroMsg.SameLayer.SystemMediaPlayer", e16, "%s getVideoWidth fail", Integer.valueOf(hashCode()));
            c(-17);
        }
        return 0;
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public boolean isPlaying() {
        try {
            if (d() && getState() != -1 && getState() != -2 && getState() != 0 && getState() != 1) {
                return this.f144938n.isPlaying();
            }
        } catch (Exception e16) {
            w.a("MicroMsg.SameLayer.SystemMediaPlayer", e16, "%s isPlaying fail", Integer.valueOf(hashCode()));
            c(-9);
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public void pause() {
        try {
            if (d()) {
                if (getState() == 2 || getState() == 3 || getState() == 6) {
                    this.f144938n.pause();
                    b(4);
                }
            }
        } catch (Exception e16) {
            w.a("MicroMsg.SameLayer.SystemMediaPlayer", e16, "%s pause fail", Integer.valueOf(hashCode()));
            c(-2);
        }
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public void prepareAsync() {
        try {
            if (d()) {
                this.f144938n.prepareAsync();
            }
        } catch (Exception e16) {
            w.a("MicroMsg.SameLayer.SystemMediaPlayer", e16, "%s prepareAsync fail", Integer.valueOf(hashCode()));
            c(-6);
        }
    }

    @Override // com.tencent.luggage.wxa.xg.a, com.tencent.luggage.wxa.xg.g
    public void release() {
        try {
            if (d()) {
                f();
                this.f144938n.release();
                b(-2);
                super.release();
            }
        } catch (Exception e16) {
            w.a("MicroMsg.SameLayer.SystemMediaPlayer", e16, "%s release fail", Integer.valueOf(hashCode()));
            c(-8);
        }
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public void reset() {
        try {
            if (d()) {
                this.f144938n.reset();
                b(0);
            }
        } catch (Exception e16) {
            w.a("MicroMsg.SameLayer.SystemMediaPlayer", e16, "%s reset fail", Integer.valueOf(hashCode()));
            c(-7);
        }
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public void setMute(boolean z16) {
        if (d()) {
            if (z16) {
                a(0.0f, 0.0f);
            } else {
                a(1.0f, 1.0f);
            }
        }
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public void setSurface(Surface surface) {
        try {
            if (d()) {
                this.f144938n.setSurface(surface);
            }
        } catch (Exception e16) {
            w.a("MicroMsg.SameLayer.SystemMediaPlayer", e16, "%s setSurface fail", Integer.valueOf(hashCode()));
            c(-12);
        }
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public void start() {
        try {
            if (d()) {
                if (getState() == 2 || getState() == 4 || getState() == 6) {
                    this.f144938n.start();
                    b(3);
                }
            }
        } catch (Exception e16) {
            w.a("MicroMsg.SameLayer.SystemMediaPlayer", e16, "%s start fail", Integer.valueOf(hashCode()));
            c(-1);
        }
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public void stop() {
        try {
            if (d()) {
                if (getState() == 2 || getState() == 3 || getState() == 4 || getState() == 6) {
                    this.f144938n.stop();
                    b(5);
                }
            }
        } catch (Exception e16) {
            w.a("MicroMsg.SameLayer.SystemMediaPlayer", e16, "%s stop fail", Integer.valueOf(hashCode()));
            c(-4);
        }
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public void a(String str, String str2) {
        try {
            if (d()) {
                if (str2 == null) {
                    this.f144938n.setDataSource(str);
                } else {
                    w.d("MicroMsg.SameLayer.SystemMediaPlayer", "setDataSource, referrer: " + str2);
                    this.f144938n.setDataSource(z.c(), Uri.parse(str), com.tencent.luggage.wxa.cg.d.a(str2));
                }
                b(1);
            }
        } catch (Exception e16) {
            w.a("MicroMsg.SameLayer.SystemMediaPlayer", e16, "%s setDataSource fail", Integer.valueOf(hashCode()));
            c(-11);
        }
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public void a(float f16, float f17) {
        try {
            if (d()) {
                this.f144938n.setVolume(f16, f17);
            }
        } catch (Exception e16) {
            w.a("MicroMsg.SameLayer.SystemMediaPlayer", e16, "%s setVolume fail", Integer.valueOf(hashCode()));
            c(-13);
        }
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public boolean a(float f16) {
        if (f16 <= 0.0f) {
            return false;
        }
        try {
        } catch (Exception e16) {
            w.a("MicroMsg.SameLayer.SystemMediaPlayer", e16, "%s setSpeed fail", Integer.valueOf(hashCode()));
            c(-14);
        }
        if (!d()) {
            w.h("MicroMsg.SameLayer.SystemMediaPlayer", "%s setSpeed, current system(%d) not support play speed setting", Integer.valueOf(hashCode()), Integer.valueOf(Build.VERSION.SDK_INT));
            return false;
        }
        PlaybackParams playbackParams = this.f144938n.getPlaybackParams();
        playbackParams.setSpeed(f16);
        if (!this.f144938n.isPlaying()) {
            this.f144938n.setPlaybackParams(playbackParams);
            this.f144938n.pause();
        } else {
            this.f144938n.setPlaybackParams(playbackParams);
        }
        return true;
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public void a(boolean z16) {
        try {
            if (d()) {
                this.f144938n.setLooping(z16);
            }
        } catch (Exception e16) {
            w.a("MicroMsg.SameLayer.SystemMediaPlayer", e16, "%s setLooping fail", Integer.valueOf(hashCode()));
            c(-10);
        }
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public void a(long j3) {
        try {
            if (d()) {
                if (getState() == 2 || getState() == 3 || getState() == 4 || getState() == 6) {
                    this.f144938n.seekTo((int) j3);
                }
            }
        } catch (Exception e16) {
            w.a("MicroMsg.SameLayer.SystemMediaPlayer", e16, "%s seekTo fail", Integer.valueOf(hashCode()));
            c(-3);
        }
    }
}
