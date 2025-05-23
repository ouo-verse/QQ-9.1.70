package com.tencent.luggage.wxa.rm;

import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.luggage.wxa.tn.c0;
import com.tencent.luggage.wxa.tn.h0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.qqmusic.mediaplayer.AudioFormat;
import com.tencent.qqmusic.mediaplayer.BaseMediaPlayer;
import com.tencent.qqmusic.mediaplayer.CommonPlayer;
import com.tencent.qqmusic.mediaplayer.PlayerListenerCallback;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import java.net.URL;

/* compiled from: P */
/* loaded from: classes8.dex */
public class f extends com.tencent.luggage.wxa.rm.a {
    private static final String N = "MicroMsg.Music.QQMusicPlayer";
    private static final int O = 20;
    private boolean A;
    private b B;
    private com.tencent.luggage.wxa.vm.b C;
    private String E;

    /* renamed from: x, reason: collision with root package name */
    private com.tencent.luggage.wxa.rb.d f139878x;

    /* renamed from: y, reason: collision with root package name */
    private CommonPlayer f139879y;

    /* renamed from: z, reason: collision with root package name */
    private com.tencent.luggage.wxa.rb.c f139880z;
    private String D = "";
    private int F = 0;
    private int G = 0;
    private long H = 0;
    private AudioFormat.AudioType I = AudioFormat.AudioType.UNSUPPORT;
    private boolean J = false;
    private String K = "";
    public boolean L = false;
    private PlayerListenerCallback M = new a();

    public f() {
        com.tencent.luggage.wxa.sm.a.c();
    }

    private void B() {
        this.f139834p = 0L;
        this.f139835q = SystemClock.elapsedRealtime();
        this.f139836r = 0L;
        this.f139837s = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        if (this.f139879y != null) {
            this.f139834p = g();
            this.f139836r += SystemClock.elapsedRealtime() - this.f139835q;
            this.f139837s = getDuration();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean D() {
        if (com.tencent.luggage.wxa.qm.k.f().a() == null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.tencent.luggage.wxa.rb.d dVar, int i3) {
    }

    public static /* synthetic */ int f(f fVar) {
        int i3 = fVar.F;
        fVar.F = i3 + 1;
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean o(com.tencent.luggage.wxa.rb.d dVar) {
        if (dVar != null && dVar.a(com.tencent.luggage.wxa.qm.k.f().a())) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        AudioFormat.AudioType audioType = this.I;
        if (audioType == null) {
            return;
        }
        w.d(N, "idKeyReportMusicMimeType audioType:%d, isStatMineType:%b", Integer.valueOf(audioType.getValue()), Boolean.valueOf(this.J));
        if (this.J) {
            return;
        }
        w.d(N, "idKeyReportMusicMimeType OK");
        this.J = true;
    }

    private void u() {
        URL url;
        String str;
        w.d(N, "initPlayer");
        v();
        if (!w0.c(this.E)) {
            w.d(N, "play with local file, filePath:%s", this.E);
            if (this.f139879y == null) {
                this.f139879y = new CommonPlayer(this.M);
            }
            this.f139879y.reset();
            if (this.E.startsWith("file://")) {
                this.E = this.E.substring(7);
            }
            try {
                this.f139879y.setDataSource(this.E);
                this.f139879y.prepare();
            } catch (Exception e16) {
                w.b(N, "initPlayer exception:" + e16.getMessage());
                w.a(N, e16, "initPlayer", new Object[0]);
                a(this.f139878x, 501);
                b(this.f139878x, 501);
            }
        } else {
            try {
                url = new URL(this.D);
            } catch (Exception e17) {
                w.a(N, e17, "initPlayer", new Object[0]);
                w.b(N, "new URL exception:" + e17.getMessage());
                url = null;
            }
            if (url == null) {
                w.b(N, "initPlayer url is null");
                a(this.f139878x, 500);
                b(this.f139878x, 500);
                return;
            }
            if (this.f139879y == null) {
                this.f139879y = new CommonPlayer(this.M);
            }
            this.f139879y.reset();
            if (this.C == null) {
                this.C = new com.tencent.luggage.wxa.vm.b();
            }
            com.tencent.luggage.wxa.rb.d dVar = this.f139878x;
            if (dVar == null) {
                str = "invalidReferrer";
            } else {
                str = dVar.V;
            }
            w.d(N, "initPlayer, referrer: " + str);
            this.C.a(this.D, str);
            try {
                w.d(N, "QQMusicPlayer temp cache dir:%s", this.K);
                if (!TextUtils.isEmpty(this.K)) {
                    this.f139879y.setOnlinePlayCacheDir(this.K);
                }
                this.f139879y.setDataSource(this.C, Uri.parse(url.toString()));
                this.f139879y.prepare();
            } catch (Exception e18) {
                w.b(N, "initPlayer exception:" + e18.getMessage());
                w.a(N, e18, "initPlayer", new Object[0]);
                a(this.f139878x, 501);
                b(this.f139878x, 501);
            }
        }
        a((float) this.f139878x.P);
        b(this.f139878x.Q);
    }

    private void v() {
        com.tencent.luggage.wxa.rb.d dVar = this.f139878x;
        String str = dVar.T;
        this.D = str;
        String str2 = dVar.D;
        this.E = str2;
        w.d(N, "mSrc:%s mSongLocalPath:%s", str, str2);
        w.d(N, "field_songWifiUrl:%s", this.f139878x.f139447i);
        if (!w0.c(this.D) && w0.c(this.E)) {
            com.tencent.luggage.wxa.om.g.i(this.D);
            com.tencent.luggage.wxa.om.g.b(this.D, 0);
            com.tencent.luggage.wxa.om.g.a(this.D, 0);
            com.tencent.luggage.wxa.rb.d dVar2 = this.f139878x;
            com.tencent.luggage.wxa.om.g.b(dVar2.T, dVar2.R);
        }
    }

    private boolean y() {
        CommonPlayer commonPlayer = this.f139879y;
        if (commonPlayer == null || commonPlayer.getPlayerState() != 3) {
            return false;
        }
        return true;
    }

    public void A() {
        w.d(N, "release");
        CommonPlayer commonPlayer = this.f139879y;
        if (commonPlayer != null) {
            commonPlayer.release();
            this.f139879y = null;
        }
        q();
    }

    @Override // com.tencent.luggage.wxa.sm.d
    public int getDuration() {
        CommonPlayer commonPlayer = this.f139879y;
        if (commonPlayer != null) {
            return commonPlayer.getDuration();
        }
        return -1;
    }

    @Override // com.tencent.luggage.wxa.sm.d
    public boolean k() {
        return true;
    }

    @Override // com.tencent.luggage.wxa.sm.d
    public int l() {
        int i3;
        CommonPlayer commonPlayer = this.f139879y;
        if (commonPlayer != null) {
            i3 = commonPlayer.getBufferedPercentage();
        } else {
            i3 = 0;
        }
        if (i3 < 0 || i3 > 100) {
            return 0;
        }
        return i3;
    }

    @Override // com.tencent.luggage.wxa.rm.a
    public void m() {
        if (m(this.f139878x)) {
            super.m();
        }
    }

    @Override // com.tencent.luggage.wxa.rm.a
    public void n(com.tencent.luggage.wxa.rb.d dVar) {
        com.tencent.luggage.wxa.rb.d dVar2 = this.f139878x;
        if (dVar2 != null && dVar2.a(dVar)) {
            w.d(N, "updateCurrentMusicWrapper src:%s", this.D);
            double d16 = dVar.P;
            if (d16 > 0.0d && d16 != this.f139878x.P) {
                w.d(N, "setPlaybackRate playbackRate:%f", Double.valueOf(d16));
                a((float) dVar.P);
                this.f139878x.P = dVar.P;
            }
            float f16 = dVar.Q;
            if (f16 >= 0.0f && f16 != this.f139878x.Q) {
                w.d(N, "setVolume volume:%f", Float.valueOf(f16));
                b(dVar.Q);
                this.f139878x.Q = dVar.Q;
            }
        }
    }

    @Override // com.tencent.luggage.wxa.rm.a
    public void p() {
        com.tencent.luggage.wxa.k0.d.a(com.tencent.luggage.wxa.tm.b.a(com.tencent.luggage.wxa.qm.e.class));
        com.tencent.luggage.wxa.qm.b h16 = com.tencent.luggage.wxa.qm.k.h();
        this.f139833o = h16;
        if (h16 != null) {
            this.K = h16.d();
        }
    }

    @Override // com.tencent.luggage.wxa.sm.d
    public void pause() {
        this.L = false;
        w.d(N, "pause");
        if (this.f139879y != null && i()) {
            try {
                this.f139879y.pause();
            } catch (Exception e16) {
                w.a(N, e16, "pause", new Object[0]);
                a(this.f139878x, 503);
                b(this.f139878x, 503);
            }
        }
    }

    @Override // com.tencent.luggage.wxa.rm.a
    public boolean r() {
        if (m(this.f139878x)) {
            return super.r();
        }
        return true;
    }

    public boolean w() {
        CommonPlayer commonPlayer = this.f139879y;
        if (commonPlayer == null || commonPlayer.getPlayerState() != 5) {
            return false;
        }
        return true;
    }

    public boolean x() {
        CommonPlayer commonPlayer = this.f139879y;
        if (commonPlayer == null || commonPlayer.getPlayerState() != 2) {
            return false;
        }
        return true;
    }

    public void z() {
        if (!D() && o(this.f139878x) && this.f139879y != null && i()) {
            int currentPosition = (int) this.f139879y.getCurrentPosition();
            int duration = this.f139879y.getDuration();
            if (currentPosition > 0 && duration > 0) {
                a(currentPosition, duration);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private boolean f139884a;

        b() {
            this.f139884a = true;
        }

        public boolean a() {
            return this.f139884a;
        }

        public void b() {
            this.f139884a = false;
            com.tencent.luggage.wxa.co.a.a(this, "music_play_progress_runnable");
        }

        public void c() {
            this.f139884a = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            w.d(f.N, "start run play progress task");
            while (!this.f139884a) {
                try {
                    if (f.this.f139879y != null && f.this.i()) {
                        f.this.z();
                    }
                } catch (Exception e16) {
                    w.b(f.N, "PlayProgressTask run exception:" + e16.getMessage());
                }
                try {
                    LockMethodProxy.sleep(200L);
                } catch (InterruptedException unused) {
                }
            }
        }

        public /* synthetic */ b(f fVar, a aVar) {
            this();
        }
    }

    private void c(boolean z16) {
        this.F = 0;
        boolean y16 = y();
        boolean i3 = i();
        w.d(N, "resume, isPreparing:%b, isPlayingMusic:%b, paused:%b, isPrepared:%b", Boolean.valueOf(y16), Boolean.valueOf(i3), Boolean.valueOf(w()), Boolean.valueOf(x()));
        if (this.f139879y != null) {
            if ((w() || x()) && !i3) {
                w.d(N, "requestFocus:%b", Boolean.valueOf(z16));
                if (z16 && !r()) {
                    w.b(N, "request focus error");
                } else {
                    try {
                        this.f139879y.start();
                    } catch (Exception e16) {
                        w.a(N, e16, "resume", new Object[0]);
                        a(this.f139878x, 502);
                        b(this.f139878x, 502);
                    }
                }
                this.A = true;
            }
        }
    }

    @Override // com.tencent.luggage.wxa.sm.d
    public void e() {
        this.L = true;
        w.d(N, "passivePause");
        if (this.f139879y == null || !i()) {
            return;
        }
        try {
            this.f139879y.pause();
        } catch (Exception e16) {
            w.a(N, e16, "passivePause", new Object[0]);
            a(this.f139878x, 503);
            b(this.f139878x, 503);
        }
    }

    @Override // com.tencent.luggage.wxa.sm.d
    public void f() {
        w.d(N, QZoneJsConstants.METHOD_RECORDER_STOP_PLAY);
        try {
            C();
            CommonPlayer commonPlayer = this.f139879y;
            if (commonPlayer != null) {
                commonPlayer.stop();
            }
            b bVar = this.B;
            if (bVar != null) {
                bVar.c();
                this.B = null;
            }
        } catch (Exception e16) {
            w.a(N, e16, QZoneJsConstants.METHOD_RECORDER_STOP_PLAY, new Object[0]);
            a(this.f139878x, 504);
            b(this.f139878x, 504);
        }
        m();
        this.A = false;
        this.L = false;
    }

    @Override // com.tencent.luggage.wxa.sm.d
    public int g() {
        CommonPlayer commonPlayer = this.f139879y;
        if (commonPlayer != null) {
            return (int) commonPlayer.getCurrentPosition();
        }
        return -1;
    }

    @Override // com.tencent.luggage.wxa.sm.d
    public boolean h() {
        return this.A && this.L;
    }

    @Override // com.tencent.luggage.wxa.sm.d
    public boolean i() {
        CommonPlayer commonPlayer = this.f139879y;
        return commonPlayer != null && commonPlayer.getPlayerState() == 4;
    }

    @Override // com.tencent.luggage.wxa.sm.d
    public void j() {
        w.d(N, "pauseAndAbandonFocus");
        pause();
        m();
    }

    public void b(float f16) {
        CommonPlayer commonPlayer = this.f139879y;
        if (commonPlayer == null || f16 < 0.0f) {
            return;
        }
        commonPlayer.setVolume(f16, f16);
    }

    @Override // com.tencent.luggage.wxa.sm.d
    public boolean b(int i3) {
        int duration = getDuration();
        w.d(N, "seekToMusic pos:%d, duration:%d", Integer.valueOf(i3), Integer.valueOf(duration));
        if (duration >= 0 && i3 <= duration) {
            if (this.f139879y != null) {
                i(this.f139878x);
                this.f139879y.seekTo(i3);
            }
            return true;
        }
        w.b(N, "position is invalid, position:%d, duration:%d", Integer.valueOf(i3), Integer.valueOf(duration));
        f();
        return false;
    }

    @Override // com.tencent.luggage.wxa.rm.a, com.tencent.luggage.wxa.sm.d
    public void a(com.tencent.luggage.wxa.rb.d dVar) {
        super.a(dVar);
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = currentTimeMillis - this.H;
        com.tencent.luggage.wxa.rb.d dVar2 = this.f139878x;
        if (dVar2 != null && dVar2.a(dVar) && j3 <= 20) {
            this.f139878x = dVar;
            w.b(N, "startPlay, is playing for music src:%s, don't play again in 3 second, interval:%d", this.D, Long.valueOf(j3));
            return;
        }
        if (dVar == null) {
            w.b(N, "music is null");
            return;
        }
        B();
        this.H = currentTimeMillis;
        this.f139878x = dVar;
        w.d(N, "startPlay, currentTime:%d, startTime:%d", Long.valueOf(currentTimeMillis), Integer.valueOf(dVar.J));
        if (this.f139879y != null && i()) {
            this.f139879y.stop();
        }
        com.tencent.luggage.wxa.sm.a.b();
        this.F = 0;
        this.G = dVar.J;
        this.I = null;
        this.J = false;
        u();
        n();
    }

    @Override // com.tencent.luggage.wxa.sm.d
    public com.tencent.luggage.wxa.rb.c b() {
        int duration = getDuration();
        int g16 = g();
        boolean i3 = i();
        int l3 = l();
        if (l3 < 0) {
            l3 = 0;
        }
        com.tencent.luggage.wxa.rb.c cVar = this.f139880z;
        if (cVar != null) {
            cVar.a(duration, g16, i3 ? 1 : 0, l3);
        } else {
            this.f139880z = new com.tencent.luggage.wxa.rb.c(duration, g16, i3 ? 1 : 0, l3);
        }
        com.tencent.luggage.wxa.rb.c cVar2 = this.f139880z;
        cVar2.f139437e = true;
        cVar2.f139438f = o();
        return this.f139880z;
    }

    @Override // com.tencent.luggage.wxa.sm.d
    public boolean c() {
        return this.A && !y();
    }

    public void a(float f16) {
        CommonPlayer commonPlayer = this.f139879y;
        if (commonPlayer == null) {
            return;
        }
        if (f16 >= 0.5f && f16 <= 2.0f) {
            w.d(N, "set speed :%f", Float.valueOf(f16));
            this.f139879y.setSpeed(f16);
        } else {
            commonPlayer.setSpeed(1.0f);
        }
    }

    @Override // com.tencent.luggage.wxa.sm.d
    public void a() {
        c(true);
    }

    @Override // com.tencent.luggage.wxa.sm.d
    public void a(boolean z16) {
        c(z16);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements PlayerListenerCallback {

        /* renamed from: a, reason: collision with root package name */
        com.tencent.luggage.wxa.rb.d f139881a = null;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.rm.f$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC6694a implements Runnable {
            public RunnableC6694a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                com.tencent.luggage.wxa.y9.a.makeText(z.c(), z.c().getString(R.string.f169672iz), 0).show();
            }
        }

        public a() {
        }

        private void a() {
            w.d(f.N, "_onCompletion");
            if (this.f139881a != null) {
                f.this.C();
                f.this.A = false;
                f fVar = f.this;
                fVar.b(fVar.f139878x);
                if (f.this.B != null) {
                    f.this.B.c();
                    f.this.B = null;
                    return;
                }
                return;
            }
            w.b(f.N, "cbMusic is null");
        }

        private void b() {
            w.d(f.N, "_onEnd");
        }

        private void c() {
            w.d(f.N, "_onPause");
            if (this.f139881a == null) {
                w.b(f.N, "cbMusic is null");
                return;
            }
            f fVar = f.this;
            long j3 = fVar.f139836r;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            f fVar2 = f.this;
            fVar.f139836r = j3 + (elapsedRealtime - fVar2.f139835q);
            fVar2.d(this.f139881a);
        }

        private void d() {
            w.d(f.N, "_onPrepared");
            if (f.this.G != 0) {
                w.d(f.N, "seek to startTime:%d", Integer.valueOf(f.this.G));
                f fVar = f.this;
                fVar.b(fVar.G);
            }
            w.d(f.N, "start to play");
            if (f.this.r()) {
                if (f.this.f139878x == null) {
                    w.b(f.N, "cbMusic is null");
                    return;
                }
                f fVar2 = f.this;
                fVar2.e(fVar2.f139878x);
                try {
                    if (f.this.f139879y != null) {
                        f.this.f139879y.start();
                        if (f.this.f139879y.getCurrentAudioInformation() != null && f.this.f139879y.getCurrentAudioInformation().getAudioType() != null) {
                            w.d(f.N, "getAudioType:%d", Integer.valueOf(f.this.f139879y.getCurrentAudioInformation().getAudioType().getValue()));
                            f fVar3 = f.this;
                            fVar3.I = fVar3.f139879y.getCurrentAudioInformation().getAudioType();
                            f.this.t();
                        }
                    }
                } catch (Exception e16) {
                    w.a(f.N, e16, "_onPrepared", new Object[0]);
                    f fVar4 = f.this;
                    fVar4.a(fVar4.f139878x, 502);
                    f fVar5 = f.this;
                    fVar5.b(fVar5.f139878x, 502);
                }
                f.this.A = true;
                return;
            }
            w.b(f.N, "request focus error");
        }

        private void e() {
            w.d(f.N, "_onPreparing");
            com.tencent.luggage.wxa.rb.d dVar = f.this.f139878x;
            this.f139881a = dVar;
            if (dVar == null) {
                w.b(f.N, "cbMusic is null");
            } else {
                f.this.f(dVar);
            }
        }

        private void g() {
            w.d(f.N, "_onStart");
            com.tencent.luggage.wxa.rb.d dVar = f.this.f139878x;
            this.f139881a = dVar;
            if (dVar == null) {
                w.b(f.N, "cbMusic is null");
                return;
            }
            f.this.f139835q = SystemClock.elapsedRealtime();
            if ("pause".equals(f.this.f139830l)) {
                f.this.g(this.f139881a);
            } else {
                f.this.j(this.f139881a);
            }
            if (f.this.B != null) {
                f.this.B.c();
            }
            f fVar = f.this;
            fVar.B = new b(fVar, null);
            f.this.B.b();
        }

        private void h() {
            w.d(f.N, "_onStop");
            if (this.f139881a == null) {
                w.b(f.N, "cbMusic is null");
                return;
            }
            if (f.this.D()) {
                w.b(f.N, "currentMusic is null");
            } else if (f.this.o(this.f139881a)) {
                f.this.k(this.f139881a);
            } else {
                f.this.l(this.f139881a);
            }
        }

        public void f() {
            w.d(f.N, "_onSeekComplete");
            com.tencent.luggage.wxa.rb.d dVar = this.f139881a;
            if (dVar == null) {
                w.b(f.N, "cbMusic is null");
                return;
            }
            f.this.h(dVar);
            if (f.this.i()) {
                w.d(f.N, "seek end, send play event!");
                f.this.g(this.f139881a);
            }
        }

        @Override // com.tencent.qqmusic.mediaplayer.PlayerListenerCallback
        public void onCompletion(BaseMediaPlayer baseMediaPlayer) {
            w.d(f.N, "onCompletion");
        }

        @Override // com.tencent.qqmusic.mediaplayer.PlayerListenerCallback
        public void onError(BaseMediaPlayer baseMediaPlayer, int i3, int i16, int i17) {
            w.b(f.N, "onError what:%d, extra:%d, errCode:%d", Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            if (!f.this.D()) {
                com.tencent.luggage.wxa.rb.d dVar = f.this.f139878x;
                this.f139881a = dVar;
                if (dVar == null) {
                    w.b(f.N, "onError, cbMusic is null");
                    return;
                }
                boolean k3 = h0.k(z.c());
                if (i16 == 80 && k3) {
                    w.b(f.N, "connect success, but download is fail!");
                }
                if (f.this.F >= 1) {
                    w.b(f.N, "errorCount %d", Integer.valueOf(f.this.F));
                    return;
                }
                f.f(f.this);
                f.this.C();
                f.this.b(this.f139881a, i16);
                if (f.this.o(this.f139881a)) {
                    f.this.f();
                    c0.a(new RunnableC6694a());
                }
                f.this.k(this.f139881a);
                f.this.a(this.f139881a, i16);
                if (f.this.B != null) {
                    f.this.B.c();
                    f.this.B = null;
                }
                if (i3 == 91 && i16 == 55) {
                    w.d(f.N, "unknow format ,delete file");
                    com.tencent.luggage.wxa.om.g.a(f.this.D);
                    return;
                }
                return;
            }
            w.b(f.N, "onError, currentMusic is null");
        }

        @Override // com.tencent.qqmusic.mediaplayer.PlayerListenerCallback
        public void onPrepared(BaseMediaPlayer baseMediaPlayer) {
            w.d(f.N, "onPrepared");
        }

        @Override // com.tencent.qqmusic.mediaplayer.PlayerListenerCallback
        public void onSeekComplete(BaseMediaPlayer baseMediaPlayer, int i3) {
            w.d(f.N, "onSeekComplete seekPosition:%d", Integer.valueOf(i3));
            if (f.this.G != 0) {
                w.d(f.N, "seek complete to startTime :%d", Integer.valueOf(f.this.G));
                f.this.G = 0;
            } else {
                f();
            }
        }

        @Override // com.tencent.qqmusic.mediaplayer.PlayerListenerCallback
        public void onStarted(BaseMediaPlayer baseMediaPlayer) {
            w.d(f.N, "onStarted");
        }

        @Override // com.tencent.qqmusic.mediaplayer.PlayerListenerCallback
        public void onStateChanged(BaseMediaPlayer baseMediaPlayer, int i3) {
            w.d(f.N, "onStateChanged state %d", Integer.valueOf(i3));
            if (i3 == 3) {
                w.d(f.N, "onStateChanged PREPARING!");
                e();
                return;
            }
            if (i3 == 2) {
                w.d(f.N, "onStateChanged PREPARED!");
                d();
                return;
            }
            if (i3 == 4) {
                w.d(f.N, "onStateChanged STARTED!");
                g();
                return;
            }
            if (i3 == 5) {
                w.d(f.N, "onStateChanged PAUSED!");
                c();
                return;
            }
            if (i3 == 6) {
                w.d(f.N, "onStateChanged STOPPED!");
                h();
                return;
            }
            if (i3 == 7) {
                w.d(f.N, "onStateChanged PLAYBACKCOMPLETED!");
                a();
            } else if (i3 == 8) {
                w.d(f.N, "onStateChanged END!");
                b();
            } else if (i3 == 9) {
                w.d(f.N, "onStateChanged ERROR!");
            }
        }

        @Override // com.tencent.qqmusic.mediaplayer.PlayerListenerCallback
        public void onBufferingUpdate(BaseMediaPlayer baseMediaPlayer, int i3) {
        }
    }
}
