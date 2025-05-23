package com.tencent.luggage.wxa.lm;

import android.net.Uri;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.luggage.wxa.lm.a;
import com.tencent.luggage.wxa.sm.d;
import com.tencent.luggage.wxa.tn.b0;
import com.tencent.luggage.wxa.tn.c0;
import com.tencent.luggage.wxa.tn.h0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.qqmusic.mediaplayer.AudioFormat;
import com.tencent.qqmusic.mediaplayer.AudioInformation;
import com.tencent.qqmusic.mediaplayer.BaseMediaPlayer;
import com.tencent.qqmusic.mediaplayer.BufferInfo;
import com.tencent.qqmusic.mediaplayer.CommonPlayer;
import com.tencent.qqmusic.mediaplayer.FloatBufferInfo;
import com.tencent.qqmusic.mediaplayer.PlayerListenerCallback;
import com.tencent.qqmusic.mediaplayer.audiofx.IAudioListener;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import java.net.URL;

/* compiled from: P */
/* loaded from: classes8.dex */
public class m extends j {
    private static final String N = "MicroMsg.Audio.QQAudioPlayer";
    private static final int O = 20;
    private b0 F;
    private com.tencent.luggage.wxa.mm.a I;

    /* renamed from: o, reason: collision with root package name */
    private String f133673o;

    /* renamed from: p, reason: collision with root package name */
    protected com.tencent.luggage.wxa.qb.b f133674p;

    /* renamed from: q, reason: collision with root package name */
    CommonPlayer f133675q;

    /* renamed from: r, reason: collision with root package name */
    private com.tencent.luggage.wxa.qb.d f133676r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f133677s;

    /* renamed from: v, reason: collision with root package name */
    private c f133680v;

    /* renamed from: w, reason: collision with root package name */
    private com.tencent.luggage.wxa.vm.b f133681w;

    /* renamed from: t, reason: collision with root package name */
    private boolean f133678t = false;

    /* renamed from: u, reason: collision with root package name */
    private boolean f133679u = false;

    /* renamed from: x, reason: collision with root package name */
    private String f133682x = "";

    /* renamed from: y, reason: collision with root package name */
    private int f133683y = 0;

    /* renamed from: z, reason: collision with root package name */
    private int f133684z = 0;
    private int A = 0;
    private boolean B = false;
    private long C = 0;
    private AudioFormat.AudioType D = AudioFormat.AudioType.UNSUPPORT;
    private boolean E = false;
    private long G = 0;
    private long H = 0;
    private com.tencent.luggage.wxa.lm.a J = null;
    private String K = "";
    private PlayerListenerCallback L = new a();
    private IAudioListener M = new b();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements PlayerListenerCallback {

        /* renamed from: a, reason: collision with root package name */
        com.tencent.luggage.wxa.qb.b f133685a = null;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.lm.m$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC6449a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f133687a;

            public RunnableC6449a(int i3) {
                this.f133687a = i3;
            }

            @Override // java.lang.Runnable
            public void run() {
                w.d(m.N, "onSeekComplete, seekPosition:%d", Integer.valueOf(this.f133687a));
                if (m.this.A != 0) {
                    w.d(m.N, "seek complete to startTime :%d", Integer.valueOf(m.this.A));
                    m.this.A = 0;
                } else {
                    a.this.f();
                }
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (m.this.V()) {
                    com.tencent.luggage.wxa.y9.a.makeText(z.c(), z.c().getString(R.string.f169672iz), 0).show();
                }
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class c implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f133690a;

            public c(int i3) {
                this.f133690a = i3;
            }

            @Override // java.lang.Runnable
            public void run() {
                w.d(m.N, "onStateChanged state %d, %s", Integer.valueOf(this.f133690a), m.this.f133673o);
                int i3 = this.f133690a;
                if (i3 == 3) {
                    w.d(m.N, "onStateChanged PREPARING!");
                    a.this.e();
                    m.this.G = System.currentTimeMillis();
                    return;
                }
                if (i3 == 2) {
                    w.d(m.N, "onStateChanged PREPARED!");
                    w.d(m.N, "preparing cost time :%d!", Long.valueOf(System.currentTimeMillis() - m.this.G));
                    a.this.d();
                    return;
                }
                if (i3 == 4) {
                    w.d(m.N, "onStateChanged STARTED!");
                    w.d(m.N, "start cost time :%d!", Long.valueOf(System.currentTimeMillis() - m.this.G));
                    a.this.g();
                    return;
                }
                if (i3 == 5) {
                    w.d(m.N, "onStateChanged PAUSED!");
                    a.this.c();
                    return;
                }
                if (i3 == 6) {
                    w.d(m.N, "onStateChanged STOPPED!");
                    a.this.h();
                    return;
                }
                if (i3 == 7) {
                    w.d(m.N, "onStateChanged PLAYBACKCOMPLETED!");
                    a.this.a();
                } else if (i3 == 8) {
                    w.d(m.N, "onStateChanged END!");
                    a.this.b();
                } else if (i3 == 9) {
                    w.d(m.N, "onStateChanged ERROR!");
                }
            }
        }

        public a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void h() {
            w.d(m.N, "_onStop");
            if (this.f133685a != null) {
                m.this.f133677s = false;
                m.this.H = System.currentTimeMillis();
                if (m.this.f133673o.equalsIgnoreCase(this.f133685a.f138564a)) {
                    if (m.this.f133679u) {
                        w.d(m.N, "stop play, but send pause state event");
                        m.this.s();
                        return;
                    } else {
                        m.this.z();
                        return;
                    }
                }
                return;
            }
            w.b(m.N, "currentMusic is null");
        }

        @Override // com.tencent.qqmusic.mediaplayer.PlayerListenerCallback
        public void onCompletion(BaseMediaPlayer baseMediaPlayer) {
            w.d(m.N, "onCompletion");
        }

        @Override // com.tencent.qqmusic.mediaplayer.PlayerListenerCallback
        public void onError(BaseMediaPlayer baseMediaPlayer, int i3, int i16, int i17) {
            w.b(m.N, "onError what:%d, extra:%d, errCode:%d, audioId:%s", Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), m.this.f133673o);
            if (this.f133685a == null) {
                w.b(m.N, "onError, currentParam is null");
                return;
            }
            boolean k3 = h0.k(z.c());
            if (i16 == 80 && k3) {
                w.b(m.N, "connect success, but download is fail!");
            }
            if (m.this.f133683y < 1) {
                m.this.f133677s = false;
                m.p(m.this);
                m.this.f133684z = i16;
                m.this.H = System.currentTimeMillis();
                m.this.d(i16);
                if (m.this.f133673o.equalsIgnoreCase(this.f133685a.f138564a)) {
                    m.this.f();
                    c0.a(new b());
                }
                m.this.c(i16);
                if (m.this.f133680v != null) {
                    m.this.f133680v.c();
                    m.this.f133680v = null;
                }
                if (i3 == 91 && i16 == 55) {
                    w.d(m.N, "unknow format ,delete file");
                    com.tencent.luggage.wxa.om.g.a(m.this.f133682x);
                    return;
                }
                return;
            }
            w.b(m.N, "errorCount %d", Integer.valueOf(m.this.f133683y));
        }

        @Override // com.tencent.qqmusic.mediaplayer.PlayerListenerCallback
        public void onPrepared(BaseMediaPlayer baseMediaPlayer) {
            w.d(m.N, "onPrepared");
        }

        @Override // com.tencent.qqmusic.mediaplayer.PlayerListenerCallback
        public void onSeekComplete(BaseMediaPlayer baseMediaPlayer, int i3) {
            m.this.F.a((Runnable) new RunnableC6449a(i3));
        }

        @Override // com.tencent.qqmusic.mediaplayer.PlayerListenerCallback
        public void onStarted(BaseMediaPlayer baseMediaPlayer) {
            w.d(m.N, "onStarted");
        }

        @Override // com.tencent.qqmusic.mediaplayer.PlayerListenerCallback
        public void onStateChanged(BaseMediaPlayer baseMediaPlayer, int i3) {
            m.this.F.a((Runnable) new c(i3));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            w.d(m.N, "_onCompletion");
            m mVar = m.this;
            if (!mVar.f133674p.f138571h) {
                mVar.q();
            }
            if (m.this.f133680v != null) {
                m.this.f133680v.c();
                m.this.f133680v = null;
            }
            m.this.H = System.currentTimeMillis();
            w.d(m.N, "play end, isPausedOnBackground:%b, playParam.loop:%b, isStartPlaying:%b, ", Boolean.valueOf(m.this.f133679u), Boolean.valueOf(m.this.f133674p.f138571h), Boolean.valueOf(m.this.f133677s));
            if (m.this.p()) {
                m.this.f133677s = false;
                m.this.A = 0;
                m.this.B = true;
                w.d(m.N, "isPausedOnBackground is true, do stop player and don't play again");
                return;
            }
            if (m.this.N()) {
                m.this.f133677s = false;
                m.this.A = 0;
                m.this.B = true;
                w.d(m.N, "isForcePause is true, do stop player and don't play again");
                return;
            }
            m mVar2 = m.this;
            if (mVar2.f133674p.f138571h && mVar2.f133677s) {
                w.d(m.N, "play end normally and loop play again");
                m.this.f133677s = false;
                m.this.A = 0;
                m.this.B = true;
                m.this.J();
                return;
            }
            w.d(m.N, "play end, but not loop play");
            m.this.f133677s = false;
            m.this.A = 0;
            m.this.B = true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            w.d(m.N, "_onEnd");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c() {
            w.d(m.N, "_onPause");
            m.this.s();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d() {
            CommonPlayer commonPlayer;
            w.d(m.N, "_onPrepared");
            m mVar = m.this;
            this.f133685a = mVar.f133674p;
            if (!mVar.p() && !m.this.f133678t) {
                if (m.this.A != 0) {
                    w.d(m.N, "seek to startTime:%d", Integer.valueOf(m.this.A));
                    m mVar2 = m.this;
                    mVar2.b(mVar2.A);
                }
                CommonPlayer commonPlayer2 = m.this.f133675q;
                if (commonPlayer2 != null && commonPlayer2.getCurrentAudioInformation() != null && m.this.f133675q.getCurrentAudioInformation().getAudioType() != null) {
                    m mVar3 = m.this;
                    mVar3.D = mVar3.f133675q.getCurrentAudioInformation().getAudioType();
                    if (m.this.D != null) {
                        w.d(m.N, "getAudioType:%d", Integer.valueOf(m.this.D.getValue()));
                    }
                    m.this.H();
                }
                m.this.t();
                if (!m.this.B) {
                    w.d(m.N, "autoplay is false, don't start auto play!");
                    return;
                }
                w.d(m.N, "start to play");
                try {
                    m mVar4 = m.this;
                    CommonPlayer commonPlayer3 = mVar4.f133675q;
                    if (commonPlayer3 != null) {
                        float f16 = (float) mVar4.f133674p.f138575l;
                        commonPlayer3.setVolume(f16, f16);
                        m.this.D();
                    }
                } catch (Exception e16) {
                    w.a(m.N, e16, "_onPrepared", new Object[0]);
                    m.this.c(502);
                    m.this.d(502);
                }
                m.this.f133677s = true;
                return;
            }
            w.d(m.N, "isPausedOnBackground or isForcePause is true, do stop player and not send event");
            if (m.this.p() && (commonPlayer = m.this.f133675q) != null) {
                commonPlayer.stop();
            }
            if (m.this.f133678t) {
                m.this.s();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e() {
            w.d(m.N, "_onPreparing");
            m mVar = m.this;
            com.tencent.luggage.wxa.qb.b bVar = mVar.f133674p;
            this.f133685a = bVar;
            if (bVar == null) {
                w.b(m.N, "cbMusic is null");
            } else if (!mVar.p() && !m.this.f133678t) {
                m.this.u();
            } else {
                w.d(m.N, "isPausedOnBackground or isForcePause is true, do stop player and not send event");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g() {
            w.d(m.N, "_onStart");
            if (m.this.I != null) {
                com.tencent.luggage.wxa.mm.a aVar = m.this.I;
                com.tencent.luggage.wxa.qb.b bVar = m.this.f133674p;
                String str = bVar.f138564a;
                String str2 = bVar.f138565b;
                long currentTimeMillis = System.currentTimeMillis();
                com.tencent.luggage.wxa.qb.b bVar2 = m.this.f133674p;
                aVar.a(str, str2, currentTimeMillis - bVar2.f138578o, bVar2.f138579p, bVar2.f138580q, true);
            }
            m mVar = m.this;
            this.f133685a = mVar.f133674p;
            if (!mVar.p() && !m.this.f133678t) {
                m.this.y();
                if (m.this.f133680v != null) {
                    m.this.f133680v.c();
                }
                m mVar2 = m.this;
                mVar2.f133680v = new c(mVar2, null);
                m.this.f133680v.b();
                return;
            }
            w.d(m.N, "isPausedOnBackground or isForcePause is true, do stop player and not send event");
            m mVar3 = m.this;
            if (mVar3.f133675q == null || !mVar3.f133677s) {
                return;
            }
            m.this.f133677s = false;
            m.this.f133675q.stop();
        }

        public void f() {
            w.d(m.N, "_onSeekComplete");
            m.this.w();
            if (m.this.i()) {
                w.d(m.N, "seek end, send play event!");
                m.this.v();
            }
        }

        @Override // com.tencent.qqmusic.mediaplayer.PlayerListenerCallback
        public void onBufferingUpdate(BaseMediaPlayer baseMediaPlayer, int i3) {
        }
    }

    public m() {
        this.f133673o = "";
        this.f133673o = h.a();
        com.tencent.luggage.wxa.sm.a.c();
        i.o().a((k) this);
        w.d(N, "create QQAudioPlayer instance");
        this.F = new b0(Looper.myLooper());
        I();
    }

    private void C() {
        try {
            CommonPlayer commonPlayer = this.f133675q;
            if (commonPlayer != null) {
                commonPlayer.setVolume(0.0f, 0.0f);
                if (!P() && !O() && !i()) {
                    if (this.f133679u) {
                        w.d(N, "stop play, but send pause state event");
                        this.f133675q.reset();
                        s();
                    } else {
                        w.d(N, "reset and send stop event");
                        this.f133675q.reset();
                        z();
                    }
                }
                w.d(N, "stop");
                this.f133675q.stop();
            }
            c cVar = this.f133680v;
            if (cVar != null) {
                cVar.c();
                this.f133680v = null;
            }
        } catch (Exception e16) {
            w.a(N, e16, QZoneJsConstants.METHOD_RECORDER_STOP_PLAY, new Object[0]);
            c(504);
            d(504);
        }
        this.f133677s = false;
        this.f133678t = true;
        this.H = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        if (P() || O()) {
            this.f133675q.setAudioStreamType(G());
        }
        this.f133675q.start();
        CommonPlayer commonPlayer = this.f133675q;
        float f16 = (float) this.f133674p.f138575l;
        commonPlayer.setVolume(f16, f16);
    }

    private int G() {
        return i.o().b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H() {
        AudioFormat.AudioType audioType = this.D;
        if (audioType == null) {
            return;
        }
        w.d(N, "idKeyReportAudioMimeType audioType:%d, isStatMineType:%b", Integer.valueOf(audioType.getValue()), Boolean.valueOf(this.E));
        if (this.E) {
            return;
        }
        w.d(N, "idKeyReportAudioMimeType OK");
        this.E = true;
        com.tencent.luggage.wxa.mm.a aVar = this.I;
        if (aVar != null) {
            aVar.c(this.D.getValue());
        }
    }

    private void I() {
        String c16 = com.tencent.luggage.wxa.om.e.c();
        this.K = c16;
        w.d(N, "playCacheTempDir:%s", c16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        URL url;
        float f16;
        w.d(N, "initPlayer");
        if (b(this.f133674p)) {
            w.d(N, "play with pByteBuff");
            if (this.f133675q == null) {
                this.f133675q = new CommonPlayer(this.L);
            }
            this.f133675q.reset();
            com.tencent.luggage.wxa.qb.b bVar = this.f133674p;
            try {
                this.f133675q.setDataSource(new com.tencent.luggage.wxa.um.c(bVar.C, bVar.f138565b));
                this.f133675q.addAudioListener(this.M);
                this.f133675q.prepare();
            } catch (Exception e16) {
                w.b(N, "initPlayer exception:" + e16.getMessage());
                w.a(N, e16, "initPlayer", new Object[0]);
                c(501);
                d(501);
            }
        } else {
            if (!TextUtils.isEmpty(this.f133674p.f138566c)) {
                com.tencent.luggage.wxa.qb.b bVar2 = this.f133674p;
                if (bVar2.f138588y == null) {
                    w.d(N, "play with local file, filePath:%s", bVar2.f138566c);
                    if (this.f133675q == null) {
                        this.f133675q = new CommonPlayer(this.L);
                    }
                    this.f133675q.reset();
                    try {
                        this.f133675q.setDataSource(this.f133674p.f138566c);
                        this.f133675q.addAudioListener(this.M);
                        this.f133675q.prepare();
                    } catch (Exception e17) {
                        w.a(N, e17, "initPlayer exception", new Object[0]);
                        c(501);
                        d(501);
                    }
                }
            }
            if (!TextUtils.isEmpty(this.f133674p.f138566c)) {
                com.tencent.luggage.wxa.qb.b bVar3 = this.f133674p;
                if (bVar3.f138588y != null) {
                    w.d(N, "play with inputStream, filePath:%s", bVar3.f138566c);
                    if (this.f133675q == null) {
                        this.f133675q = new CommonPlayer(this.L);
                    }
                    this.f133675q.reset();
                    try {
                        this.f133675q.setDataSource(new com.tencent.luggage.wxa.um.c(this.f133674p.f138588y));
                        this.f133675q.addAudioListener(this.M);
                        this.f133675q.prepare();
                    } catch (Exception e18) {
                        w.b(N, "initPlayer exception:" + e18.getMessage());
                        w.a(N, e18, "initPlayer", new Object[0]);
                        c(501);
                        d(501);
                    }
                }
            }
            w.d(N, "play with src url :%s", this.f133674p.f138565b);
            K();
            try {
                url = new URL(this.f133682x);
            } catch (Exception e19) {
                w.a(N, e19, "initPlayer", new Object[0]);
                url = null;
            }
            if (url == null) {
                w.b(N, "initPlayer url is null");
                c(500);
                d(500);
                return;
            }
            if (this.f133675q == null) {
                this.f133675q = new CommonPlayer(this.L);
            }
            this.f133675q.reset();
            if (this.f133681w == null) {
                this.f133681w = new com.tencent.luggage.wxa.vm.b();
            }
            this.f133681w.a(this.f133682x, this.f133674p.f138586w);
            try {
                if (!TextUtils.isEmpty(this.K)) {
                    this.f133675q.setOnlinePlayCacheDir(this.K);
                }
                this.f133675q.setDataSource(this.f133681w, Uri.parse(url.toString()));
                this.f133675q.addAudioListener(this.M);
                this.f133675q.prepare();
            } catch (Exception e26) {
                w.b(N, "initPlayer exception:" + e26.getMessage());
                w.a(N, e26, "initPlayer", new Object[0]);
                c(501);
                d(501);
            }
        }
        com.tencent.luggage.wxa.qb.b bVar4 = this.f133674p;
        if (bVar4 != null) {
            f16 = (float) bVar4.f138576m;
        } else {
            f16 = 0.0f;
        }
        CommonPlayer commonPlayer = this.f133675q;
        if (commonPlayer != null) {
            if (f16 >= 0.5f && f16 <= 2.0f) {
                w.d(N, "set speed :%f", Float.valueOf(f16));
                this.f133675q.setSpeed(f16);
            } else {
                commonPlayer.setSpeed(1.0f);
            }
            CommonPlayer commonPlayer2 = this.f133675q;
            float f17 = (float) this.f133674p.f138575l;
            commonPlayer2.setVolume(f17, f17);
        }
    }

    private void K() {
        boolean z16;
        String str = this.f133674p.f138565b;
        this.f133682x = str;
        if (com.tencent.luggage.wxa.wm.e.b(str)) {
            w.d(N, "can match shake music wifi url");
            z16 = true;
        } else {
            z16 = false;
        }
        w.d(N, "mSrc:%s", this.f133682x);
        com.tencent.luggage.wxa.om.g.i(this.f133682x);
        com.tencent.luggage.wxa.om.g.a(this.f133682x, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean V() {
        return com.tencent.luggage.wxa.om.e.e();
    }

    public static /* synthetic */ int p(m mVar) {
        int i3 = mVar.f133683y;
        mVar.f133683y = i3 + 1;
        return i3;
    }

    @Override // com.tencent.luggage.wxa.lm.j
    public void A() {
        w.d(N, "pauseOnBackGround");
        this.f133679u = true;
        C();
    }

    @Override // com.tencent.luggage.wxa.lm.j
    public void B() {
        this.f133679u = false;
        this.f133678t = true;
        z();
        this.H = System.currentTimeMillis();
    }

    public int E() {
        return this.f133684z;
    }

    public long F() {
        return this.H;
    }

    public boolean L() {
        CommonPlayer commonPlayer = this.f133675q;
        if (commonPlayer == null || commonPlayer.getPlayerState() != 7) {
            return false;
        }
        return true;
    }

    public boolean M() {
        CommonPlayer commonPlayer = this.f133675q;
        if (commonPlayer == null || commonPlayer.getPlayerState() != 9) {
            return false;
        }
        return true;
    }

    public boolean N() {
        return this.f133678t;
    }

    public boolean O() {
        CommonPlayer commonPlayer = this.f133675q;
        if (commonPlayer == null || commonPlayer.getPlayerState() != 5) {
            return false;
        }
        return true;
    }

    public boolean P() {
        CommonPlayer commonPlayer = this.f133675q;
        if (commonPlayer == null || commonPlayer.getPlayerState() != 2) {
            return false;
        }
        return true;
    }

    public boolean Q() {
        CommonPlayer commonPlayer = this.f133675q;
        if (commonPlayer == null || commonPlayer.getPlayerState() != 3) {
            return false;
        }
        return true;
    }

    public boolean R() {
        CommonPlayer commonPlayer = this.f133675q;
        if (commonPlayer == null || commonPlayer.getPlayerState() != 6) {
            return false;
        }
        return true;
    }

    public void S() {
        d.a aVar;
        if (this.f133673o.equalsIgnoreCase(this.f133674p.f138564a) && this.f133675q != null && i()) {
            int currentPosition = (int) this.f133675q.getCurrentPosition();
            int duration = this.f133675q.getDuration();
            if (currentPosition > 0 && duration > 0 && (aVar = this.f133672m) != null) {
                aVar.a(currentPosition, duration);
            }
        }
    }

    public void T() {
        w.d(N, "release");
        this.f133671l = null;
        this.J = null;
        CommonPlayer commonPlayer = this.f133675q;
        if (commonPlayer != null) {
            commonPlayer.release();
            this.f133675q = null;
        }
        i.o().b(this);
    }

    public void U() {
        w.d(N, "setPauseOnBackground");
        this.f133679u = true;
        this.f133678t = true;
    }

    @Override // com.tencent.luggage.wxa.sm.d
    public void a(d.a aVar) {
    }

    @Override // com.tencent.luggage.wxa.sm.d
    public void b(d.a aVar) {
    }

    @Override // com.tencent.luggage.wxa.sm.d
    public int d() {
        return 0;
    }

    @Override // com.tencent.luggage.wxa.sm.d
    public int getDuration() {
        CommonPlayer commonPlayer = this.f133675q;
        if (commonPlayer != null) {
            return commonPlayer.getDuration();
        }
        return -1;
    }

    @Override // com.tencent.luggage.wxa.lm.j, com.tencent.luggage.wxa.sm.d
    public boolean k() {
        return true;
    }

    @Override // com.tencent.luggage.wxa.sm.d
    public void pause() {
        w.d(N, "pause, audioId:%s", this.f133673o);
        this.f133678t = true;
        if (this.f133675q != null && i()) {
            try {
                w.d(N, "pause success");
                this.f133675q.pause();
                return;
            } catch (Exception e16) {
                w.a(N, e16, "pause", new Object[0]);
                c(503);
                d(503);
                return;
            }
        }
        if (this.f133675q != null && L()) {
            w.d(N, "pause fail, play complete, set isStartPlaying false");
            this.f133677s = false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements IAudioListener {

        /* renamed from: a, reason: collision with root package name */
        private int f133692a = 0;

        /* renamed from: b, reason: collision with root package name */
        private int f133693b = 0;

        /* renamed from: c, reason: collision with root package name */
        private a.c f133694c;

        public b() {
            this.f133694c = new a.c(2, m.this.f133673o);
        }

        @Override // com.tencent.qqmusic.mediaplayer.audiofx.IAudioListener
        public long getActualTime(long j3) {
            return 0L;
        }

        @Override // com.tencent.qqmusic.mediaplayer.audiofx.IAudioListener
        public boolean isEnabled() {
            if (m.this.J != null) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.qqmusic.mediaplayer.audiofx.IAudioListener
        public boolean isTerminal() {
            return false;
        }

        @Override // com.tencent.qqmusic.mediaplayer.audiofx.IAudioListener
        public boolean onPcm(BufferInfo bufferInfo, BufferInfo bufferInfo2, long j3) {
            if (m.this.J == null) {
                return false;
            }
            m.this.J.a(this.f133694c, 1, this.f133692a, this.f133693b, bufferInfo.byteBuffer);
            return false;
        }

        @Override // com.tencent.qqmusic.mediaplayer.audiofx.IAudioListener
        public long onPlayerReady(int i3, AudioInformation audioInformation, long j3) {
            this.f133692a = audioInformation.getChannels();
            this.f133693b = (int) audioInformation.getSampleRate();
            if (m.this.J != null) {
                m.this.J.c(this.f133694c);
                return 0L;
            }
            return 0L;
        }

        @Override // com.tencent.qqmusic.mediaplayer.audiofx.IAudioListener
        public void onPlayerStopped() {
            if (m.this.J != null) {
                m.this.J.d(this.f133694c);
            }
            CommonPlayer commonPlayer = m.this.f133675q;
            if (commonPlayer != null) {
                commonPlayer.removeAudioListener(this);
            }
        }

        @Override // com.tencent.qqmusic.mediaplayer.audiofx.IAudioListener
        public boolean onPcm(FloatBufferInfo floatBufferInfo, FloatBufferInfo floatBufferInfo2, long j3) {
            if (m.this.J == null) {
                return false;
            }
            m.this.J.a(this.f133694c, 3, this.f133692a, this.f133693b, floatBufferInfo.floatBuffer);
            return false;
        }

        @Override // com.tencent.qqmusic.mediaplayer.audiofx.IAudioListener
        public void onPlayerSeekComplete(long j3) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private boolean f133696a;

        c() {
            this.f133696a = true;
        }

        public boolean a() {
            return this.f133696a;
        }

        public void b() {
            this.f133696a = false;
        }

        public void c() {
            this.f133696a = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            w.d(m.N, "start run play progress task");
            while (!this.f133696a) {
                try {
                    m mVar = m.this;
                    if (mVar.f133675q != null && mVar.i()) {
                        m.this.S();
                    }
                } catch (Exception e16) {
                    w.b(m.N, "PlayProgressTask run exception:" + e16.getMessage());
                }
                try {
                    LockMethodProxy.sleep(200L);
                } catch (InterruptedException unused) {
                }
            }
        }

        public /* synthetic */ c(m mVar, a aVar) {
            this();
        }
    }

    @Override // com.tencent.luggage.wxa.sm.d
    public void f() {
        w.d(N, QZoneJsConstants.METHOD_RECORDER_STOP_PLAY);
        this.f133679u = false;
        C();
    }

    @Override // com.tencent.luggage.wxa.sm.d
    public int g() {
        CommonPlayer commonPlayer = this.f133675q;
        if (commonPlayer != null) {
            return (int) commonPlayer.getCurrentPosition();
        }
        return -1;
    }

    @Override // com.tencent.luggage.wxa.sm.d
    public boolean i() {
        CommonPlayer commonPlayer = this.f133675q;
        return commonPlayer != null && commonPlayer.getPlayerState() == 4;
    }

    @Override // com.tencent.luggage.wxa.sm.d
    public void j() {
        w.d(N, "pauseAndAbandonFocus");
        pause();
    }

    @Override // com.tencent.luggage.wxa.sm.d
    public int l() {
        CommonPlayer commonPlayer = this.f133675q;
        int bufferedPercentage = commonPlayer != null ? commonPlayer.getBufferedPercentage() : 0;
        if (bufferedPercentage < 0 || bufferedPercentage > 100) {
            return 0;
        }
        return bufferedPercentage;
    }

    @Override // com.tencent.luggage.wxa.lm.j
    public String m() {
        com.tencent.luggage.wxa.qb.b bVar = this.f133674p;
        return bVar != null ? bVar.f138577n : "";
    }

    @Override // com.tencent.luggage.wxa.lm.j
    public String n() {
        return this.f133673o;
    }

    @Override // com.tencent.luggage.wxa.lm.j
    public com.tencent.luggage.wxa.qb.d o() {
        if (this.f133676r == null) {
            this.f133676r = new com.tencent.luggage.wxa.qb.d();
        }
        int duration = getDuration();
        int g16 = g();
        boolean i3 = i();
        int l3 = l();
        if (l3 < 0) {
            l3 = 0;
        }
        com.tencent.luggage.wxa.qb.d dVar = this.f133676r;
        dVar.f138591b = g16;
        dVar.f138590a = duration;
        dVar.f138592c = !i3;
        dVar.f138593d = this.f133679u;
        dVar.f138594e = (l3 * duration) / 100;
        com.tencent.luggage.wxa.qb.b bVar = this.f133674p;
        if (bVar == null) {
            return null;
        }
        dVar.f138596g = bVar.f138568e;
        dVar.f138595f = bVar.f138565b;
        dVar.f138597h = bVar.f138585v;
        return dVar;
    }

    @Override // com.tencent.luggage.wxa.lm.j
    public boolean p() {
        return this.f133679u;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i3) {
        com.tencent.luggage.wxa.mm.a aVar = this.I;
        if (aVar != null) {
            aVar.b(this.f133674p.f138572i, i3);
        }
    }

    public void c(com.tencent.luggage.wxa.qb.b bVar) {
        this.f133674p = bVar;
        this.A = bVar.f138567d;
        this.B = bVar.f138570g;
        if (this.f133675q == null || !i()) {
            return;
        }
        w.d(N, "audioId:%s, param.src:%s setVoume %f", this.f133673o, this.f133682x, Double.valueOf(this.f133674p.f138575l));
        CommonPlayer commonPlayer = this.f133675q;
        float f16 = (float) this.f133674p.f138575l;
        commonPlayer.setVolume(f16, f16);
        double d16 = this.f133674p.f138576m;
        if (d16 > 0.0d) {
            w.d(N, "set speed :%f", Double.valueOf(d16));
            this.f133675q.setSpeed((float) this.f133674p.f138576m);
        } else {
            this.f133675q.setSpeed(1.0f);
        }
    }

    private boolean b(com.tencent.luggage.wxa.qb.b bVar) {
        return (bVar == null || !bVar.f138565b.startsWith("wxblob://") || bVar.C == null) ? false : true;
    }

    @Override // com.tencent.luggage.wxa.sm.d
    public boolean b(int i3) {
        int duration = getDuration();
        w.d(N, "seekToMusic pos:%d, duration:%d", Integer.valueOf(i3), Integer.valueOf(duration));
        if (duration < 0) {
            w.b(N, "position is invalid, position:%d, duration:%d", Integer.valueOf(i3), Integer.valueOf(duration));
            f();
            return false;
        }
        if (i3 > duration) {
            w.b(N, "position is invalid, position:%d, duration:%d", Integer.valueOf(i3), Integer.valueOf(duration));
            return false;
        }
        if (this.f133675q != null) {
            x();
            this.f133675q.seekTo(i3);
        }
        return true;
    }

    public void a(String str) {
        w.d(N, "setAudioId:%s", str);
        this.f133673o = str;
    }

    @Override // com.tencent.luggage.wxa.sm.d
    public void a(com.tencent.luggage.wxa.qb.b bVar) {
        if (bVar == null) {
            w.d(N, "startPlay fail, play param is null");
            r();
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = currentTimeMillis - this.C;
        com.tencent.luggage.wxa.qb.b bVar2 = this.f133674p;
        if (bVar2 != null && bVar2.a(bVar) && j3 <= 20) {
            this.f133674p = bVar;
            this.A = bVar.f138567d;
            this.B = bVar.f138570g;
            w.b(N, "startPlay, is playing for audio src:%s, don't play again in 3 second, interval:%d", this.f133682x, Long.valueOf(j3));
            return;
        }
        com.tencent.luggage.wxa.mm.a aVar = (com.tencent.luggage.wxa.mm.a) com.tencent.luggage.wxa.tm.b.a(com.tencent.luggage.wxa.mm.a.class);
        this.I = aVar;
        if (aVar != null) {
            aVar.d(bVar.f138572i);
        }
        this.C = currentTimeMillis;
        this.f133674p = bVar;
        w.d(N, "startPlay, fromScene:%d, audioId:%s", Integer.valueOf(bVar.f138572i), this.f133673o);
        if (this.f133675q != null && i()) {
            this.f133675q.stop();
        }
        this.f133683y = 0;
        this.A = bVar.f138567d;
        this.B = bVar.f138570g;
        this.D = null;
        this.E = false;
        this.f133679u = false;
        this.f133678t = false;
        J();
    }

    @Override // com.tencent.luggage.wxa.sm.d
    public boolean c() {
        return this.f133677s && !Q();
    }

    @Override // com.tencent.luggage.wxa.sm.d
    public void a() {
        this.f133683y = 0;
        boolean Q = Q();
        boolean i3 = i();
        this.f133678t = false;
        this.f133679u = false;
        w.d(N, "resume, isPreparing:%b, isPlayingMusic:%b, isStartPlaying:%b, audioId:%s", Boolean.valueOf(Q), Boolean.valueOf(i3), Boolean.valueOf(this.f133677s), this.f133673o);
        if (this.f133675q != null && !P() && !Q && !i3 && !this.f133677s) {
            w.d(N, "audio play is complete, need initPlayer again");
            this.A = 0;
            this.B = true;
            J();
            com.tencent.luggage.wxa.mm.a aVar = this.I;
            if (aVar != null) {
                aVar.d(this.f133674p.f138572i);
                return;
            }
            return;
        }
        if (this.f133675q != null) {
            if ((O() || P()) && !i3) {
                w.d(N, "audio play is paused, need start to play");
                try {
                    CommonPlayer commonPlayer = this.f133675q;
                    float f16 = (float) this.f133674p.f138575l;
                    commonPlayer.setVolume(f16, f16);
                    D();
                } catch (Exception e16) {
                    w.a(N, e16, "resume", new Object[0]);
                    c(502);
                    d(502);
                }
                this.f133677s = true;
            }
        }
    }

    @Override // com.tencent.luggage.wxa.sm.d
    public void a(boolean z16) {
        a();
    }

    public void a(com.tencent.luggage.wxa.lm.a aVar) {
        this.J = aVar;
    }
}
