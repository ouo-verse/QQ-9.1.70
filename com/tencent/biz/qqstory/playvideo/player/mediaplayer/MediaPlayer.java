package com.tencent.biz.qqstory.playvideo.player.mediaplayer;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.os.PowerManager;
import android.os.SystemClock;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.c;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import fd0.a;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes5.dex */
public class MediaPlayer implements fd0.a {
    protected a.c A;
    protected a.d B;
    protected a.g C;
    protected a.InterfaceC10303a D;
    protected boolean F;
    protected boolean G;
    protected boolean H;
    protected AudioPlayback I;
    protected com.tencent.biz.qqstory.playvideo.player.mediaplayer.a J;
    protected boolean K;
    private CountDownLatch Q;

    /* renamed from: b, reason: collision with root package name */
    protected Surface f94149b;

    /* renamed from: c, reason: collision with root package name */
    protected SurfaceHolder f94150c;

    /* renamed from: d, reason: collision with root package name */
    protected e f94151d;

    /* renamed from: e, reason: collision with root package name */
    protected e f94152e;

    /* renamed from: f, reason: collision with root package name */
    protected int f94153f;

    /* renamed from: g, reason: collision with root package name */
    protected MediaFormat f94154g;

    /* renamed from: h, reason: collision with root package name */
    protected long f94155h;

    /* renamed from: i, reason: collision with root package name */
    protected int f94156i;

    /* renamed from: j, reason: collision with root package name */
    protected MediaFormat f94157j;

    /* renamed from: k, reason: collision with root package name */
    protected long f94158k;

    /* renamed from: q, reason: collision with root package name */
    protected long f94164q;

    /* renamed from: r, reason: collision with root package name */
    protected long f94165r;

    /* renamed from: s, reason: collision with root package name */
    protected boolean f94166s;

    /* renamed from: t, reason: collision with root package name */
    protected int f94167t;

    /* renamed from: v, reason: collision with root package name */
    protected Uri f94169v;

    /* renamed from: x, reason: collision with root package name */
    protected a.e f94171x;

    /* renamed from: y, reason: collision with root package name */
    protected a.b f94172y;

    /* renamed from: z, reason: collision with root package name */
    protected a.f f94173z;

    /* renamed from: a, reason: collision with root package name */
    protected c f94148a = c.c(4);

    /* renamed from: n, reason: collision with root package name */
    protected float f94161n = 1.0f;

    /* renamed from: o, reason: collision with root package name */
    protected float f94162o = 1.0f;
    protected PowerManager.WakeLock E = null;
    protected boolean L = false;
    protected int M = 0;
    protected final Object P = new Object();

    /* renamed from: p, reason: collision with root package name */
    protected PlaybackThread f94163p = null;

    /* renamed from: w, reason: collision with root package name */
    protected b f94170w = new b();

    /* renamed from: u, reason: collision with root package name */
    protected g f94168u = new g();
    protected int N = 1;
    protected int O = 1;

    /* renamed from: l, reason: collision with root package name */
    protected int f94159l = 0;

    /* renamed from: m, reason: collision with root package name */
    protected int f94160m = 3;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class PlaybackThread extends BaseHandlerThread implements Handler.Callback {
        private boolean C;
        private boolean D;
        private c.a E;
        private boolean F;
        private boolean G;
        private double H;
        private boolean I;

        /* renamed from: m, reason: collision with root package name */
        private Handler f94174m;

        public PlaybackThread() {
            super("Story-MediaPlayer#" + PlaybackThread.class.getSimpleName(), -16);
            this.C = true;
            this.D = false;
            this.F = d.a(MediaPlayer.this.N);
            this.G = true;
            this.I = false;
        }

        private void g() throws IOException, InterruptedException {
            c.a aVar;
            long d16 = MediaPlayer.this.J.d();
            if (d16 != -1) {
                b bVar = MediaPlayer.this.f94170w;
                bVar.sendMessage(bVar.obtainMessage(3, (int) ((100.0d / (r5.getDuration() * 1000)) * (MediaPlayer.this.f94164q + d16)), 0));
            }
            MediaPlayer mediaPlayer = MediaPlayer.this;
            if (mediaPlayer.K && d16 > -1 && d16 < 2000000 && !mediaPlayer.J.h()) {
                this.f94174m.sendEmptyMessageDelayed(3, 100L);
                return;
            }
            if (MediaPlayer.this.J.g() != null && this.E == null) {
                c.a b16 = MediaPlayer.this.J.b(false);
                this.E = b16;
                if (b16 == null && !MediaPlayer.this.J.i()) {
                    this.f94174m.sendEmptyMessageDelayed(3, 10L);
                    return;
                }
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            MediaPlayer mediaPlayer2 = MediaPlayer.this;
            if (mediaPlayer2.K) {
                mediaPlayer2.K = false;
                b bVar2 = mediaPlayer2.f94170w;
                bVar2.sendMessage(bVar2.obtainMessage(200, 702, 0));
                MediaPlayer mediaPlayer3 = MediaPlayer.this;
                mediaPlayer3.f94168u.f(mediaPlayer3.J.e());
            }
            c.a aVar2 = this.E;
            if (aVar2 != null && MediaPlayer.this.f94168u.b(aVar2.f94201c) > 60000) {
                this.f94174m.sendEmptyMessageDelayed(3, 50L);
                return;
            }
            MediaPlayer mediaPlayer4 = MediaPlayer.this;
            mediaPlayer4.f94164q = mediaPlayer4.J.e();
            if (MediaPlayer.this.J.g() != null && (aVar = this.E) != null) {
                l(aVar);
                this.E = null;
                if (this.G) {
                    this.G = false;
                    b bVar3 = MediaPlayer.this.f94170w;
                    bVar3.sendMessage(bVar3.obtainMessage(200, 3, 0));
                }
            }
            MediaPlayer mediaPlayer5 = MediaPlayer.this;
            if (mediaPlayer5.I != null) {
                if (this.H != mediaPlayer5.f94168u.c()) {
                    double c16 = MediaPlayer.this.f94168u.c();
                    this.H = c16;
                    MediaPlayer.this.I.p((float) c16);
                }
                long e16 = MediaPlayer.this.I.e();
                if (e16 > AudioPlayback.f94125q) {
                    MediaPlayer.this.f94168u.f(e16);
                }
            }
            if (MediaPlayer.this.J.i()) {
                MediaPlayer.this.f94170w.sendEmptyMessage(2);
                MediaPlayer mediaPlayer6 = MediaPlayer.this;
                if (mediaPlayer6.H) {
                    AudioPlayback audioPlayback = mediaPlayer6.I;
                    if (audioPlayback != null) {
                        audioPlayback.b();
                    }
                    MediaPlayer.this.J.l(c.c(0), 0L);
                    MediaPlayer.this.J.k();
                } else {
                    this.C = true;
                    i(true);
                }
            } else {
                this.E = MediaPlayer.this.J.b(false);
            }
            if (!this.C) {
                long c17 = ((long) (10 / MediaPlayer.this.f94168u.c())) - (SystemClock.elapsedRealtime() - elapsedRealtime);
                if (c17 > 0) {
                    this.f94174m.sendEmptyMessageDelayed(3, c17);
                } else {
                    this.f94174m.sendEmptyMessage(3);
                }
            }
        }

        private void h() {
            i(false);
        }

        private void i(boolean z16) {
            this.f94174m.removeMessages(3);
            AudioPlayback audioPlayback = MediaPlayer.this.I;
            if (audioPlayback != null) {
                if (z16) {
                    this.f94174m.sendEmptyMessageDelayed(6, ((audioPlayback.h() + MediaPlayer.this.I.f()) / 1000) + 1);
                } else {
                    audioPlayback.m(false);
                }
            }
        }

        private void j() {
            AudioPlayback audioPlayback = MediaPlayer.this.I;
            if (audioPlayback != null) {
                audioPlayback.l();
            }
        }

        private void k() throws IOException, InterruptedException {
            if (MediaPlayer.this.J.i()) {
                MediaPlayer mediaPlayer = MediaPlayer.this;
                mediaPlayer.f94164q = 0L;
                mediaPlayer.J.l(c.c(0), 0L);
            }
            MediaPlayer mediaPlayer2 = MediaPlayer.this;
            mediaPlayer2.f94168u.f(mediaPlayer2.J.e());
            if (MediaPlayer.this.I != null) {
                this.f94174m.removeMessages(6);
                MediaPlayer.this.I.n();
            }
            double c16 = MediaPlayer.this.f94168u.c();
            this.H = c16;
            AudioPlayback audioPlayback = MediaPlayer.this.I;
            if (audioPlayback != null) {
                audioPlayback.p((float) c16);
            }
            this.f94174m.removeMessages(3);
            g();
        }

        private void l(c.a aVar) throws InterruptedException {
            if (aVar.f94202d) {
                MediaPlayer.this.J.g().e(aVar);
                return;
            }
            long b16 = MediaPlayer.this.f94168u.b(aVar.f94201c);
            if (b16 < -1000) {
                Log.d("Story-MediaPlayer", "LAGGING " + b16);
                b bVar = MediaPlayer.this.f94170w;
                bVar.sendMessage(bVar.obtainMessage(200, 700, 0));
            }
            if (aVar.f94203e) {
                MediaPlayer mediaPlayer = MediaPlayer.this;
                if (mediaPlayer.L) {
                    b bVar2 = mediaPlayer.f94170w;
                    bVar2.sendMessage(bVar2.obtainMessage(5, mediaPlayer.J.g().z(), MediaPlayer.this.J.g().A()));
                } else {
                    b bVar3 = mediaPlayer.f94170w;
                    bVar3.sendMessage(bVar3.obtainMessage(5, mediaPlayer.J.g().A(), MediaPlayer.this.J.g().z()));
                }
            }
            if (!this.F && b16 > 5000) {
                LockMethodProxy.sleep(b16 / 1000);
            }
            MediaPlayer.this.J.g().t(aVar, b16);
        }

        private void m(long j3) throws IOException, InterruptedException {
            if (this.E != null) {
                MediaPlayer.this.J.g().e(this.E);
                this.E = null;
            }
            AudioPlayback audioPlayback = MediaPlayer.this.I;
            if (audioPlayback != null) {
                audioPlayback.m(true);
            }
            MediaPlayer mediaPlayer = MediaPlayer.this;
            mediaPlayer.J.l(mediaPlayer.f94148a, j3);
            MediaPlayer mediaPlayer2 = MediaPlayer.this;
            mediaPlayer2.f94168u.f(mediaPlayer2.J.e());
            boolean hasMessages = this.f94174m.hasMessages(4);
            if (hasMessages) {
                MediaPlayer.this.J.c();
            } else {
                MediaPlayer.this.J.k();
            }
            if (!hasMessages) {
                MediaPlayer mediaPlayer3 = MediaPlayer.this;
                mediaPlayer3.f94164q = mediaPlayer3.J.e();
                MediaPlayer mediaPlayer4 = MediaPlayer.this;
                mediaPlayer4.f94166s = false;
                this.I = false;
                mediaPlayer4.f94170w.sendEmptyMessage(4);
                if (!this.C) {
                    k();
                }
            }
        }

        private void o(Surface surface) {
            com.tencent.biz.qqstory.playvideo.player.mediaplayer.a aVar = MediaPlayer.this.J;
            if (aVar != null && aVar.g() != null) {
                if (this.E != null) {
                    MediaPlayer.this.J.g().e(this.E);
                    this.E = null;
                }
                MediaPlayer.this.J.g().C(surface);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void release() {
            if (!isAlive()) {
                return;
            }
            this.C = true;
            synchronized (MediaPlayer.this.P) {
                this.D = true;
                if (this.f94174m.sendEmptyMessage(5)) {
                    try {
                        LockMethodProxy.wait(MediaPlayer.this.P);
                    } catch (InterruptedException e16) {
                        Log.e("Story-MediaPlayer", "wait lock interrupted", e16);
                    }
                }
            }
            Log.d("Story-MediaPlayer", "PlaybackThread released");
        }

        private void releaseInternal() {
            try {
                interrupt();
                quit();
                this.C = true;
                com.tencent.biz.qqstory.playvideo.player.mediaplayer.a aVar = MediaPlayer.this.J;
                if (aVar != null && this.E != null) {
                    aVar.g().q(this.E);
                    this.E = null;
                }
                MediaPlayer.this.k();
                Log.d("Story-MediaPlayer", "PlaybackThread destroyed");
                synchronized (MediaPlayer.this.P) {
                    MediaPlayer.this.P.notify();
                }
            } catch (Throwable th5) {
                Log.d("Story-MediaPlayer", "PlaybackThread destroyed");
                synchronized (MediaPlayer.this.P) {
                    MediaPlayer.this.P.notify();
                    throw th5;
                }
            }
        }

        public void e(int i3, Object obj) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 4) {
                        this.f94174m.removeMessages(4);
                        this.f94174m.obtainMessage(4, obj).sendToTarget();
                        return;
                    }
                    throw new IllegalArgumentException("Message should be Play or Pause or Seek");
                }
                this.C = true;
                this.f94174m.sendEmptyMessage(2);
                return;
            }
            this.C = false;
            this.f94174m.sendEmptyMessage(1);
        }

        public boolean f() {
            return this.C;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (this.D) {
                releaseInternal();
                return true;
            }
            try {
                int i3 = message.what;
                if (i3 != 100) {
                    switch (i3) {
                        case 1:
                            k();
                            return true;
                        case 2:
                            h();
                            return true;
                        case 3:
                            g();
                            return true;
                        case 4:
                            m(((Long) message.obj).longValue());
                            return true;
                        case 5:
                            releaseInternal();
                            return true;
                        case 6:
                            j();
                            return true;
                        default:
                            Log.d("Story-MediaPlayer", "unknown/invalid message");
                            return false;
                    }
                }
                o((Surface) message.obj);
                return true;
            } catch (IOException e16) {
                Log.e("Story-MediaPlayer", "decoder error, codec can not be created", e16);
                b bVar = MediaPlayer.this.f94170w;
                bVar.sendMessage(bVar.obtainMessage(100, 1, -1004));
                releaseInternal();
                return true;
            } catch (IllegalStateException e17) {
                Log.e("Story-MediaPlayer", "decoder error, too many instances?", e17);
                b bVar2 = MediaPlayer.this.f94170w;
                bVar2.sendMessage(bVar2.obtainMessage(100, 1, 0));
                releaseInternal();
                return true;
            } catch (InterruptedException e18) {
                Log.d("Story-MediaPlayer", "decoder interrupted", e18);
                b bVar3 = MediaPlayer.this.f94170w;
                bVar3.sendMessage(bVar3.obtainMessage(100, 1, 0));
                releaseInternal();
                return true;
            }
        }

        public void n(Surface surface) {
            Handler handler = this.f94174m;
            handler.sendMessage(handler.obtainMessage(100, surface));
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread, java.lang.Thread
        public synchronized void start() {
            super.start();
            this.f94174m = new Handler(getLooper(), this);
            Log.d("Story-MediaPlayer", "PlaybackThread started");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a implements c.b {
        a() {
        }

        @Override // com.tencent.biz.qqstory.playvideo.player.mediaplayer.c.b
        public void a(com.tencent.biz.qqstory.playvideo.player.mediaplayer.c cVar) {
            PlaybackThread playbackThread = MediaPlayer.this.f94163p;
            if (playbackThread != null && !playbackThread.f()) {
                MediaPlayer mediaPlayer = MediaPlayer.this;
                if (!mediaPlayer.K && mediaPlayer.J.d() < 2000000 && !MediaPlayer.this.J.h()) {
                    MediaPlayer mediaPlayer2 = MediaPlayer.this;
                    mediaPlayer2.K = true;
                    b bVar = mediaPlayer2.f94170w;
                    bVar.sendMessage(bVar.obtainMessage(200, 701, 0));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class b extends Handler {
        b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            boolean z16;
            int i3 = message.what;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 != 5) {
                                if (i3 != 100) {
                                    if (i3 != 200) {
                                        return;
                                    }
                                    Log.d("Story-MediaPlayer", "onInfo");
                                    MediaPlayer mediaPlayer = MediaPlayer.this;
                                    a.d dVar = mediaPlayer.B;
                                    if (dVar != null) {
                                        dVar.c(mediaPlayer, message.arg1, message.arg2);
                                        return;
                                    }
                                    return;
                                }
                                Log.e("Story-MediaPlayer", "Error (" + message.arg1 + "," + message.arg2 + ")");
                                MediaPlayer mediaPlayer2 = MediaPlayer.this;
                                a.c cVar = mediaPlayer2.A;
                                if (cVar != null) {
                                    z16 = cVar.d(mediaPlayer2, message.arg1, message.arg2);
                                } else {
                                    z16 = false;
                                }
                                MediaPlayer mediaPlayer3 = MediaPlayer.this;
                                a.b bVar = mediaPlayer3.f94172y;
                                if (bVar != null && !z16) {
                                    bVar.b(mediaPlayer3);
                                }
                                MediaPlayer.this.o(false);
                                return;
                            }
                            Log.d("Story-MediaPlayer", "onVideoSizeChanged");
                            MediaPlayer mediaPlayer4 = MediaPlayer.this;
                            a.g gVar = mediaPlayer4.C;
                            if (gVar != null) {
                                gVar.a(mediaPlayer4, message.arg1, message.arg2);
                                return;
                            }
                            return;
                        }
                        Log.d("Story-MediaPlayer", "onSeekComplete");
                        MediaPlayer mediaPlayer5 = MediaPlayer.this;
                        a.f fVar = mediaPlayer5.f94173z;
                        if (fVar != null) {
                            fVar.d(mediaPlayer5);
                            return;
                        }
                        return;
                    }
                    MediaPlayer mediaPlayer6 = MediaPlayer.this;
                    a.InterfaceC10303a interfaceC10303a = mediaPlayer6.D;
                    if (interfaceC10303a != null) {
                        interfaceC10303a.a(mediaPlayer6, message.arg1);
                    }
                    MediaPlayer.this.f94167t = message.arg1;
                    return;
                }
                Log.d("Story-MediaPlayer", "onPlaybackComplete");
                MediaPlayer mediaPlayer7 = MediaPlayer.this;
                a.b bVar2 = mediaPlayer7.f94172y;
                if (bVar2 != null) {
                    bVar2.b(mediaPlayer7);
                }
                MediaPlayer.this.o(false);
                return;
            }
            Log.d("Story-MediaPlayer", "onPrepared");
            MediaPlayer mediaPlayer8 = MediaPlayer.this;
            a.e eVar = mediaPlayer8.f94171x;
            if (eVar != null) {
                eVar.a(mediaPlayer8);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        private int f94177a;

        c(int i3) {
            this.f94177a = i3;
        }

        public static c c(int i3) {
            return new c(i3);
        }

        public int a() {
            int i3 = this.f94177a;
            if (i3 != 3 && i3 != 4 && i3 != 5 && i3 != 6) {
                return i3;
            }
            return 0;
        }

        public int b() {
            return this.f94177a;
        }
    }

    /* loaded from: classes5.dex */
    public static class d {
        public static boolean a(int i3) {
            if (i3 == 1 || i3 == 3) {
                return true;
            }
            return false;
        }
    }

    public static boolean i() {
        return false;
    }

    private void p() {
        boolean z16;
        SurfaceHolder surfaceHolder = this.f94150c;
        if (surfaceHolder != null) {
            if (this.F && this.G) {
                z16 = true;
            } else {
                z16 = false;
            }
            surfaceHolder.setKeepScreenOn(z16);
        }
    }

    @Override // fd0.a
    public void a(a.e eVar) {
        this.f94171x = eVar;
    }

    @Override // fd0.a
    public void b(a.c cVar) {
        this.A = cVar;
    }

    @Override // fd0.a
    public void c(a.g gVar) {
        this.C = gVar;
    }

    @Override // fd0.a
    public void d(a.InterfaceC10303a interfaceC10303a) {
        this.D = interfaceC10303a;
    }

    @Override // fd0.a
    public void e(a.b bVar) {
        this.f94172y = bVar;
    }

    @Override // fd0.a
    public void f(a.d dVar) {
        this.B = dVar;
    }

    @Override // fd0.a
    public void g(a.f fVar) {
        this.f94173z = fVar;
    }

    @Override // fd0.a
    public int getAudioSessionId() {
        return this.f94159l;
    }

    @Override // fd0.a
    public int getCurrentPosition() {
        long j3;
        if (this.O < 6) {
            if (this.f94166s) {
                j3 = this.f94165r;
            } else {
                j3 = this.f94164q;
            }
            return (int) (j3 / 1000);
        }
        this.O = 8;
        throw new IllegalStateException();
    }

    @Override // fd0.a
    @TargetApi(16)
    public int getDuration() {
        long j3;
        int i3 = this.O;
        if (i3 <= 3 && i3 >= 6) {
            this.O = 8;
            throw new IllegalStateException();
        }
        MediaFormat mediaFormat = this.f94154g;
        if (mediaFormat != null) {
            j3 = mediaFormat.getLong("durationUs") / 1000;
        } else {
            MediaFormat mediaFormat2 = this.f94157j;
            if (mediaFormat2 != null && mediaFormat2.containsKey("durationUs")) {
                j3 = this.f94157j.getLong("durationUs") / 1000;
            } else {
                return 0;
            }
        }
        return (int) j3;
    }

    @Override // fd0.a
    @TargetApi(16)
    public int getVideoHeight() {
        if (this.O >= 6) {
            hd0.c.h("Story-MediaPlayer", "getVideoHeight() with wrong state: " + this.O + "!", new IllegalStateException());
            this.O = 8;
            return 0;
        }
        if (this.L && !i()) {
            if (this.f94154g == null) {
                return 0;
            }
            return (int) (r0.getInteger("height") * this.f94154g.getFloat("mpx-dar"));
        }
        MediaFormat mediaFormat = this.f94154g;
        if (mediaFormat == null) {
            return 0;
        }
        return mediaFormat.getInteger("height");
    }

    @Override // fd0.a
    @TargetApi(16)
    public int getVideoWidth() {
        if (this.O >= 6) {
            hd0.c.h("Story-MediaPlayer", "getVideoWidth() with wrong state: " + this.O + "!", new IllegalStateException());
            this.O = 8;
            return 0;
        }
        if (this.L && !i()) {
            MediaFormat mediaFormat = this.f94154g;
            if (mediaFormat == null) {
                return 0;
            }
            return mediaFormat.getInteger("height");
        }
        if (this.f94154g == null) {
            return 0;
        }
        return (int) (r0.getInteger("height") * this.f94154g.getFloat("mpx-dar"));
    }

    @Override // fd0.a
    public boolean isPlaying() {
        if (this.O < 6) {
            PlaybackThread playbackThread = this.f94163p;
            if (playbackThread != null && !playbackThread.f()) {
                return true;
            }
            return false;
        }
        this.O = 8;
        throw new IllegalStateException();
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x0079  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void j() throws IOException, IllegalStateException {
        boolean z16;
        if (this.f94157j != null) {
            AudioPlayback audioPlayback = new AudioPlayback();
            this.I = audioPlayback;
            audioPlayback.o(this.f94159l);
            setVolume(this.f94161n, this.f94162o);
        }
        a aVar = new a();
        if (this.O == 6) {
            return;
        }
        this.J = new com.tencent.biz.qqstory.playvideo.player.mediaplayer.a();
        int i3 = this.f94153f;
        if (i3 != -1) {
            try {
                this.J.a(new com.tencent.biz.qqstory.playvideo.player.mediaplayer.d(this.f94151d, false, i3, aVar, this.f94149b, d.a(this.N)));
            } catch (Exception e16) {
                Log.e("Story-MediaPlayer", "cannot create video decoder: " + e16.getMessage());
            }
        }
        int i16 = this.f94156i;
        if (i16 != -1) {
            try {
                e eVar = this.f94152e;
                e eVar2 = this.f94151d;
                if (eVar != eVar2 && eVar != null) {
                    z16 = false;
                    if (eVar != null) {
                        eVar2 = eVar;
                    }
                    this.J.a(new com.tencent.biz.qqstory.playvideo.player.mediaplayer.b(eVar2, z16, i16, aVar, this.I));
                }
                z16 = true;
                if (eVar != null) {
                }
                this.J.a(new com.tencent.biz.qqstory.playvideo.player.mediaplayer.b(eVar2, z16, i16, aVar, this.I));
            } catch (Exception e17) {
                Log.e("Story-MediaPlayer", "cannot create audio decoder: " + e17.getMessage());
            }
        }
        if (!this.J.f().isEmpty()) {
            AudioPlayback audioPlayback2 = this.I;
            if (audioPlayback2 != null) {
                this.f94159l = audioPlayback2.c();
                this.f94160m = this.I.d();
            }
            if (this.J.g() != null) {
                int A = this.J.g().A();
                int z17 = this.J.g().z();
                int i17 = this.M;
                if (i17 > 0 && i17 != 180) {
                    this.L = true;
                    z17 = A;
                    A = z17;
                }
                b bVar = this.f94170w;
                bVar.sendMessage(bVar.obtainMessage(5, A, z17));
            }
            if (this.O == 6) {
                return;
            }
            if (this.J.g() != null) {
                this.J.g().q(this.J.b(true));
            } else {
                this.J.b(false);
            }
            AudioPlayback audioPlayback3 = this.I;
            if (audioPlayback3 != null) {
                audioPlayback3.m(true);
            }
            this.J.l(c.c(0), 0L);
            if (this.O == 6) {
                return;
            }
            PlaybackThread playbackThread = new PlaybackThread();
            this.f94163p = playbackThread;
            playbackThread.start();
            this.O = 4;
            return;
        }
        throw new IOException("cannot decode any stream");
    }

    protected void k() {
        boolean z16;
        com.tencent.biz.qqstory.playvideo.player.mediaplayer.a aVar = this.J;
        if (aVar != null) {
            try {
                aVar.j();
            } catch (Exception e16) {
                hd0.c.h("Story-MediaPlayer", "release decoders error!", e16);
            }
        }
        AudioPlayback audioPlayback = this.I;
        if (audioPlayback != null) {
            audioPlayback.r();
        }
        e eVar = this.f94152e;
        boolean z17 = true;
        if (eVar != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (eVar == this.f94151d) {
            z17 = false;
        }
        if (z17 & z16) {
            eVar.j();
        }
        e eVar2 = this.f94151d;
        if (eVar2 != null) {
            eVar2.j();
        }
    }

    public void l(long j3) {
        int i3 = this.O;
        if (i3 < 4 && i3 >= 6) {
            this.O = 8;
            throw new IllegalStateException();
        }
        Log.d("Story-MediaPlayer", "seekTo " + j3);
        this.f94166s = true;
        long max = Math.max(this.f94155h, j3);
        this.f94165r = max;
        this.f94163p.e(4, Long.valueOf(max));
    }

    @TargetApi(16)
    public void m(f fVar) throws IOException, IllegalStateException {
        if (this.O == 1) {
            this.f94151d = fVar.a();
            this.f94152e = fVar.b();
            this.f94153f = -1;
            this.f94156i = -1;
            for (int i3 = 0; i3 < this.f94151d.e(); i3++) {
                MediaFormat f16 = this.f94151d.f(i3);
                Log.d("Story-MediaPlayer", f16.toString());
                String string = f16.getString("mime");
                if (this.f94153f < 0 && string.startsWith("video/")) {
                    this.f94151d.m(i3);
                    this.f94153f = i3;
                    this.f94154g = f16;
                    this.f94155h = this.f94151d.c();
                } else if (this.f94152e == null && this.f94156i < 0 && string.startsWith("audio/")) {
                    this.f94151d.m(i3);
                    this.f94156i = i3;
                    this.f94157j = f16;
                    this.f94158k = this.f94151d.c();
                    this.f94152e = this.f94151d;
                }
            }
            if (this.f94152e != null && this.f94156i == -1) {
                for (int i16 = 0; i16 < this.f94152e.e(); i16++) {
                    MediaFormat f17 = this.f94152e.f(i16);
                    Log.d("Story-MediaPlayer", f17.toString());
                    String string2 = f17.getString("mime");
                    if (this.f94156i < 0 && string2.startsWith("audio/")) {
                        this.f94152e.m(i16);
                        this.f94156i = i16;
                        this.f94157j = f17;
                        this.f94158k = this.f94152e.c();
                    }
                }
            }
            int i17 = this.f94153f;
            if (i17 == -1) {
                this.f94151d = null;
            }
            if (i17 == -1 && this.f94156i == -1) {
                throw new IOException("invalid data source, no supported stream found");
            }
            if (i17 != -1 && this.f94163p == null && this.f94149b == null) {
                Log.i("Story-MediaPlayer", "no video output surface specified");
            }
            this.O = 2;
            if (!this.f94154g.containsKey("rotation-degrees")) {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(this.f94169v.getPath());
                try {
                    int parseInt = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
                    this.M = parseInt;
                    this.f94154g.setInteger("rotation-degrees", parseInt);
                } catch (NumberFormatException unused) {
                }
                mediaMetadataRetriever.release();
                return;
            }
            this.M = this.f94154g.getInteger("rotation-degrees");
            return;
        }
        throw new IllegalStateException();
    }

    void n(int i3) {
        if (this.f94163p == null) {
            Log.d("Story-MediaPlayer", "setVideoRenderTimingMode " + i3);
            this.N = i3;
            return;
        }
        throw new IllegalStateException("called after prepare/prepareAsync");
    }

    protected void o(boolean z16) {
        PowerManager.WakeLock wakeLock = this.E;
        if (wakeLock != null) {
            if (z16 && !wakeLock.isHeld()) {
                this.E.acquire();
            } else if (!z16 && this.E.isHeld()) {
                this.E.release();
            }
        }
        this.G = z16;
        p();
    }

    @Override // fd0.a
    public void pause() {
        if (this.O == 4) {
            this.f94163p.e(2, null);
            o(false);
        } else {
            this.O = 8;
            throw new IllegalStateException();
        }
    }

    @Override // fd0.a
    public void prepareAsync() throws IllegalStateException {
        int i3 = this.O;
        if (i3 != 2 && i3 != 5) {
            throw new IllegalStateException();
        }
        this.Q = new CountDownLatch(1);
        this.O = 3;
        new BaseThread(new Runnable() { // from class: com.tencent.biz.qqstory.playvideo.player.mediaplayer.MediaPlayer.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    try {
                        try {
                            MediaPlayer.this.j();
                            MediaPlayer mediaPlayer = MediaPlayer.this;
                            if (mediaPlayer.O == 4) {
                                mediaPlayer.f94170w.sendEmptyMessage(1);
                            }
                        } catch (IOException e16) {
                            Log.e("Story-MediaPlayer", "prepareAsync() failed: cannot decode stream(s)", e16);
                            b bVar = MediaPlayer.this.f94170w;
                            bVar.sendMessage(bVar.obtainMessage(100, 1, -1004));
                        } catch (IllegalArgumentException e17) {
                            Log.e("Story-MediaPlayer", "prepareAsync() failed: surface might be gone", e17);
                            b bVar2 = MediaPlayer.this.f94170w;
                            bVar2.sendMessage(bVar2.obtainMessage(100, 1, 0));
                        }
                    } catch (IllegalStateException e18) {
                        Log.e("Story-MediaPlayer", "prepareAsync() failed: something is in a wrong state", e18);
                        b bVar3 = MediaPlayer.this.f94170w;
                        bVar3.sendMessage(bVar3.obtainMessage(100, 1, 0));
                    }
                } finally {
                    MediaPlayer.this.Q.countDown();
                }
            }
        }).start();
    }

    @Override // fd0.a
    public void release() {
        this.O = 6;
        CountDownLatch countDownLatch = this.Q;
        if (countDownLatch != null) {
            try {
                countDownLatch.await();
            } catch (InterruptedException unused) {
            } catch (Throwable th5) {
                this.Q = null;
                throw th5;
            }
            this.Q = null;
        }
        PlaybackThread playbackThread = this.f94163p;
        if (playbackThread != null) {
            playbackThread.release();
            this.f94163p = null;
        } else {
            k();
        }
        o(false);
        this.O = 7;
    }

    @Override // fd0.a
    public void reset() {
        stop();
        this.O = 1;
    }

    @Override // fd0.a
    public void seekTo(int i3) {
        l(i3 * 1000);
    }

    @Override // fd0.a
    public void setAudioSessionId(int i3) {
        if (this.O == 1) {
            this.f94159l = i3;
            return;
        }
        throw new IllegalStateException();
    }

    @Override // fd0.a
    public void setAudioStreamType(int i3) {
        this.f94160m = i3;
    }

    @Override // fd0.a
    @Deprecated
    public void setDataSource(Context context, Uri uri, Map<String, String> map) throws IOException {
        this.f94169v = uri;
        m(new h(context, uri, map));
    }

    @Override // fd0.a
    public void setLooping(boolean z16) {
        this.H = z16;
    }

    @Override // fd0.a
    public void setScreenOnWhilePlaying(boolean z16) {
        if (this.F != z16) {
            if (z16 && this.f94150c == null) {
                Log.w("Story-MediaPlayer", "setScreenOnWhilePlaying(true) is ineffective without a SurfaceHolder");
            }
            this.F = z16;
            p();
        }
    }

    @Override // fd0.a
    public void setSurface(Surface surface) {
        this.f94149b = surface;
        if (this.F && surface != null) {
            Log.w("Story-MediaPlayer", "setScreenOnWhilePlaying(true) is ineffective for Surface");
        }
        this.f94150c = null;
        PlaybackThread playbackThread = this.f94163p;
        if (playbackThread == null) {
            n(2);
            p();
        } else {
            playbackThread.n(this.f94149b);
        }
    }

    @Override // fd0.a
    public void setVolume(float f16, float f17) {
        this.f94161n = f16;
        this.f94162o = f17;
        AudioPlayback audioPlayback = this.I;
        if (audioPlayback != null) {
            audioPlayback.q(f16, f17);
        }
    }

    @Override // fd0.a
    public void start() {
        if (this.O == 4) {
            this.f94163p.e(1, null);
            o(true);
        } else {
            this.O = 8;
            throw new IllegalStateException();
        }
    }

    @Override // fd0.a
    public void stop() {
        release();
        this.O = 5;
    }
}
