package com.tencent.luggage.wxa.rm;

import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.thumbplayer.api.ITPPlayer;
import com.tencent.thumbplayer.api.ITPPlayerListener;
import com.tencent.thumbplayer.tplayer.TPPlayer;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes8.dex */
public class g extends com.tencent.luggage.wxa.rm.a {
    private static final String D = "MicroMsg.Music.TPMusicPlayer";
    private static final int E = 100;
    private static final int F = 1000;
    private static final int G = 2000;
    private boolean A;
    private boolean B;
    public boolean C = false;

    /* renamed from: x, reason: collision with root package name */
    private com.tencent.luggage.wxa.rb.c f139886x;

    /* renamed from: y, reason: collision with root package name */
    private TPPlayer f139887y;

    /* renamed from: z, reason: collision with root package name */
    private com.tencent.luggage.wxa.rb.d f139888z;

    private /* synthetic */ void a(ITPPlayer iTPPlayer, int i3, int i16, long j3, long j16) {
        com.tencent.luggage.wxa.rb.d a16 = com.tencent.luggage.wxa.qm.k.f().a();
        if (a16 == null) {
            return;
        }
        f();
        k(this.f139888z);
        b(a16, i3, i16);
    }

    private /* synthetic */ void b(ITPPlayer iTPPlayer) {
        w.d(D, "setEvents, onStart");
        com.tencent.luggage.wxa.rb.d a16 = com.tencent.luggage.wxa.qm.k.f().a();
        if (a16 == null) {
            return;
        }
        x();
        j(a16);
        t();
    }

    private void o(final com.tencent.luggage.wxa.rb.d dVar) {
        if (this.f139887y == null) {
            TPPlayer tPPlayer = new TPPlayer(z.c());
            this.f139887y = tPPlayer;
            tPPlayer.setDataSource(dVar.T);
            this.f139887y.setOnErrorListener(new ITPPlayerListener.IOnErrorListener() { // from class: com.tencent.luggage.wxa.rm.h
            });
            this.f139887y.setOnCompletionListener(new ITPPlayerListener.IOnCompletionListener() { // from class: com.tencent.luggage.wxa.rm.i
            });
            this.f139887y.setOnStopAsyncCompleteListener(new ITPPlayerListener.IOnStopAsyncCompleteListener() { // from class: com.tencent.luggage.wxa.rm.j
            });
            this.f139887y.setOnPreparedListener(new ITPPlayerListener.IOnPreparedListener() { // from class: com.tencent.luggage.wxa.rm.k
            });
            this.f139887y.setOnInfoListener(new a());
            try {
                this.f139887y.prepareAsync();
            } catch (IOException unused) {
                w.b(D, "mediaPlayer prepareAsync error");
            }
        }
    }

    private boolean v() {
        if (this.f139887y.getCurrentState() == 5) {
            return true;
        }
        return false;
    }

    private void x() {
        if (m(this.f139888z) && !r()) {
            w.b(D, "request focus error");
            return;
        }
        w.d(D, "startPlay");
        try {
            TPPlayer tPPlayer = this.f139887y;
            if (tPPlayer != null) {
                tPPlayer.start();
            }
        } catch (Exception e16) {
            w.a(D, e16, "startPlay", new Object[0]);
        }
        this.A = true;
        this.B = false;
    }

    @Override // com.tencent.luggage.wxa.sm.d
    public boolean c() {
        return this.A;
    }

    @Override // com.tencent.luggage.wxa.sm.d
    public void e() {
        this.C = true;
        w.d(D, "passivePause");
        try {
            if (this.f139887y != null && v()) {
                this.f139887y.pause();
                d(this.f139888z);
            }
        } catch (Exception e16) {
            w.a(D, e16, "passivePause", new Object[0]);
        }
    }

    @Override // com.tencent.luggage.wxa.sm.d
    public void f() {
        w.d(D, QZoneJsConstants.METHOD_RECORDER_STOP_PLAY);
        try {
            TPPlayer tPPlayer = this.f139887y;
            if (tPPlayer != null) {
                tPPlayer.stop();
                this.f139887y = null;
            }
        } catch (Exception e16) {
            w.a(D, e16, QZoneJsConstants.METHOD_RECORDER_STOP_PLAY, new Object[0]);
        }
        m();
        this.A = false;
        this.C = false;
    }

    @Override // com.tencent.luggage.wxa.sm.d
    public int g() {
        TPPlayer tPPlayer = this.f139887y;
        if (tPPlayer != null) {
            return (int) tPPlayer.getCurrentPositionMs();
        }
        return -1;
    }

    @Override // com.tencent.luggage.wxa.sm.d
    public int getDuration() {
        TPPlayer tPPlayer = this.f139887y;
        if (tPPlayer != null) {
            return (int) tPPlayer.getDurationMs();
        }
        return -1;
    }

    @Override // com.tencent.luggage.wxa.sm.d
    public boolean h() {
        if (this.A && this.C) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.sm.d
    public boolean i() {
        if (this.f139887y != null) {
            try {
                return v();
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.sm.d
    public void j() {
        w.d(D, "pauseAndAbandonFocus");
        pause();
        m();
    }

    @Override // com.tencent.luggage.wxa.sm.d
    public boolean k() {
        return false;
    }

    @Override // com.tencent.luggage.wxa.sm.d
    public int l() {
        return 0;
    }

    @Override // com.tencent.luggage.wxa.rm.a
    public void p() {
        com.tencent.luggage.wxa.k0.d.a(com.tencent.luggage.wxa.tm.b.a(com.tencent.luggage.wxa.qm.e.class));
        this.f139833o = com.tencent.luggage.wxa.qm.k.h();
    }

    @Override // com.tencent.luggage.wxa.sm.d
    public void pause() {
        this.C = false;
        w.d(D, "pause");
        try {
            if (this.f139887y != null && v()) {
                this.f139887y.pause();
                this.B = true;
                d(this.f139888z);
            }
        } catch (Exception e16) {
            w.a(D, e16, "pause", new Object[0]);
        }
    }

    public boolean u() {
        if (this.A && (this.B || this.f139829k)) {
            return true;
        }
        return false;
    }

    public void w() {
        try {
            TPPlayer tPPlayer = this.f139887y;
            if (tPPlayer != null) {
                tPPlayer.release();
                this.f139887y = null;
            }
        } catch (Exception e16) {
            w.a(D, e16, "release", new Object[0]);
        }
    }

    private /* synthetic */ void a(ITPPlayer iTPPlayer) {
        w.d(D, "setEvents, onComplete");
        if (com.tencent.luggage.wxa.qm.k.f().a() == null) {
            return;
        }
        b(this.f139888z);
    }

    @Override // com.tencent.luggage.wxa.sm.d
    public boolean b(int i3) {
        int duration;
        w.d(D, "seekToMusic pos:%d", Integer.valueOf(i3));
        try {
            duration = getDuration();
        } catch (Exception e16) {
            w.a(D, e16, "seekTo", new Object[0]);
        }
        if (duration >= 0 && i3 <= duration) {
            TPPlayer tPPlayer = this.f139887y;
            if (tPPlayer != null && i3 >= 0) {
                tPPlayer.seekTo(i3);
                h(this.f139888z);
                return true;
            }
            return false;
        }
        w.b(D, "duration or position is illegal, stop");
        f();
        return false;
    }

    private /* synthetic */ void a(com.tencent.luggage.wxa.rb.d dVar, ITPPlayer iTPPlayer) {
        w.d(D, "setEvents, onStop");
        com.tencent.luggage.wxa.rb.d a16 = com.tencent.luggage.wxa.qm.k.f().a();
        if (a16 == null) {
            return;
        }
        if (a16.a(dVar)) {
            f();
        }
        k(this.f139888z);
    }

    @Override // com.tencent.luggage.wxa.rm.a, com.tencent.luggage.wxa.sm.d
    public void a(com.tencent.luggage.wxa.rb.d dVar) {
        super.a(dVar);
        w.d(D, "init and start download");
        f();
        if (dVar == null) {
            w.d(D, "music is null");
            return;
        }
        this.f139888z = dVar;
        o(dVar);
        w.d(D, "startPlay src:%s,  playUrl:%s", dVar.f139447i, dVar.T);
        n();
    }

    @Override // com.tencent.luggage.wxa.sm.d
    public com.tencent.luggage.wxa.rb.c b() {
        int i3;
        int duration = getDuration();
        int g16 = g();
        if (i()) {
            i3 = 1;
        } else {
            i3 = u() ? 0 : 2;
        }
        w.d(D, "get music status = %d", Integer.valueOf(i3));
        int l3 = l();
        if (duration <= 0) {
            l3 = 0;
        }
        com.tencent.luggage.wxa.rb.c cVar = this.f139886x;
        if (cVar != null) {
            cVar.a(duration, g16, i3, l3);
        } else {
            this.f139886x = new com.tencent.luggage.wxa.rb.c(duration, g16, i3, l3);
        }
        com.tencent.luggage.wxa.rb.c cVar2 = this.f139886x;
        cVar2.f139437e = false;
        cVar2.f139438f = o();
        return this.f139886x;
    }

    @Override // com.tencent.luggage.wxa.sm.d
    public void a() {
        a(true);
    }

    private void t() {
    }

    @Override // com.tencent.luggage.wxa.sm.d
    public void a(boolean z16) {
        try {
            if (this.f139887y != null && !v()) {
                w.d(D, "resume requestFocus:%b", Boolean.valueOf(z16));
                if (z16 && m(this.f139888z) && !r()) {
                    w.b(D, "request focus error");
                }
                this.f139887y.start();
                g(this.f139888z);
            } else {
                w.d(D, "music is playing");
            }
        } catch (Exception e16) {
            w.a(D, e16, "resume", new Object[0]);
        }
    }

    private void b(com.tencent.luggage.wxa.rb.d dVar, int i3, int i16) {
        if (dVar == null) {
            w.b(D, "currentMusic is null, don't idKeyReportMusicError");
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements ITPPlayerListener.IOnInfoListener {
        public a() {
        }

        public void onInfo(ITPPlayer iTPPlayer, int i3, long j3, long j16, Object obj) {
        }
    }
}
