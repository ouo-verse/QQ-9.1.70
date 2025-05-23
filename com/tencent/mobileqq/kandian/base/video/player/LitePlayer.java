package com.tencent.mobileqq.kandian.base.video.player;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.utils.g;
import com.tencent.mobileqq.kandian.base.video.plugin.VideoPluginInstall;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: classes33.dex */
public class LitePlayer implements com.tencent.mobileqq.kandian.base.video.plugin.a {
    private static int H;
    private VideoPluginInstall A;
    private a B;
    private c C;
    private String D;
    private boolean E;
    private boolean F;
    private boolean G;

    /* renamed from: a, reason: collision with root package name */
    private final String f239090a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f239091b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f239092c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f239093d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f239094e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f239095f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f239096g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f239097h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f239098i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f239099j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f239100k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f239101l;

    /* renamed from: m, reason: collision with root package name */
    private float f239102m;

    /* renamed from: n, reason: collision with root package name */
    private int f239103n;

    /* renamed from: o, reason: collision with root package name */
    private int f239104o;

    /* renamed from: p, reason: collision with root package name */
    private int f239105p;

    /* renamed from: q, reason: collision with root package name */
    private long f239106q;

    /* renamed from: r, reason: collision with root package name */
    private long f239107r;

    /* renamed from: s, reason: collision with root package name */
    protected Context f239108s;

    /* renamed from: t, reason: collision with root package name */
    private b f239109t;

    /* renamed from: u, reason: collision with root package name */
    protected VideoPlayerWrapper f239110u;

    /* renamed from: v, reason: collision with root package name */
    protected ViewGroup f239111v;

    /* renamed from: w, reason: collision with root package name */
    protected boolean f239112w;

    /* renamed from: x, reason: collision with root package name */
    private ConcurrentLinkedQueue<f> f239113x;

    /* renamed from: y, reason: collision with root package name */
    private ConcurrentLinkedQueue<e> f239114y;

    /* renamed from: z, reason: collision with root package name */
    private ConcurrentLinkedQueue<com.tencent.mobileqq.kandian.base.video.player.c> f239115z;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes33.dex */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        String f239132a;

        /* renamed from: b, reason: collision with root package name */
        String f239133b;

        /* renamed from: c, reason: collision with root package name */
        int f239134c;

        /* renamed from: d, reason: collision with root package name */
        long f239135d;

        /* renamed from: e, reason: collision with root package name */
        int f239136e;

        b(String str, String str2, int i3, long j3, int i16) {
            this.f239132a = str;
            this.f239133b = str2;
            this.f239134c = i3;
            this.f239135d = j3;
            this.f239136e = i16;
        }

        public String toString() {
            String str;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("PlayParams{vid='");
            sb5.append(this.f239132a);
            sb5.append('\'');
            sb5.append(", url='");
            sb5.append(this.f239133b);
            sb5.append('\'');
            sb5.append(", playType=");
            if (this.f239134c == 101) {
                str = "VOD";
            } else {
                str = "LIVE";
            }
            sb5.append(str);
            sb5.append('}');
            return sb5.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes33.dex */
    public static class c extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<LitePlayer> f239138a;

        public c(LitePlayer litePlayer) {
            this.f239138a = new WeakReference<>(litePlayer);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i3 = message.what;
            if (i3 != 0) {
                if (i3 == 1 && this.f239138a.get() != null) {
                    if (QLog.isColorLevel()) {
                        QLog.d(this.f239138a.get().f239090a, 2, "prePlay timeout, try rePlay");
                    }
                    if (!this.f239138a.get().Z() || this.f239138a.get().f239110u.G() != this.f239138a.get().f239109t) {
                        this.f239138a.get().f239097h = false;
                        this.f239138a.get().h0(this.f239138a.get().f239110u);
                        this.f239138a.get().a0(this.f239138a.get().f239109t);
                        return;
                    }
                    this.f239138a.get().T();
                    return;
                }
                return;
            }
            if (this.f239138a.get() != null) {
                this.f239138a.get().Q();
                this.f239138a.get().C.sendEmptyMessageDelayed(0, this.f239138a.get().f239105p);
            }
        }
    }

    public LitePlayer(Context context, String str, boolean z16, boolean z17) {
        String str2 = "LitePlayer<" + Integer.toHexString(hashCode()) + ">";
        this.f239090a = str2;
        this.f239091b = false;
        this.f239092c = false;
        this.f239093d = true;
        this.f239094e = false;
        this.f239095f = false;
        this.f239096g = false;
        this.f239097h = false;
        this.f239098i = true;
        this.f239099j = false;
        this.f239100k = false;
        this.f239101l = false;
        this.f239102m = 1.0f;
        this.f239103n = 0;
        this.f239105p = 100;
        this.f239106q = 0L;
        this.f239107r = 0L;
        this.f239112w = false;
        this.B = new a();
        this.C = new c(this);
        this.F = true;
        this.D = str;
        this.E = z16;
        this.G = z17;
        this.f239108s = context.getApplicationContext();
        VideoPluginInstall videoPluginInstall = new VideoPluginInstall();
        this.A = videoPluginInstall;
        videoPluginInstall.k(this);
        this.f239113x = new ConcurrentLinkedQueue<>();
        this.f239114y = new ConcurrentLinkedQueue<>();
        this.f239111v = new FrameLayout(this.f239108s);
        this.f239110u = O();
        this.f239115z = new ConcurrentLinkedQueue<>();
        if (!this.A.j()) {
            this.A.i();
        }
        H++;
        if (QLog.isColorLevel()) {
            QLog.d(str2, 2, "LitePlayer: create player, player_num=" + H);
        }
    }

    private void M() {
        if (QLog.isColorLevel()) {
            QLog.d(this.f239090a, 2, "checkPlayer: tag=" + this.f239110u.G());
        }
        if (this.f239110u.G() != null || !this.f239110u.b0()) {
            U(this.f239110u);
            this.f239110u.t();
            this.f239110u = O();
        }
        this.f239111v.setKeepScreenOn(true);
    }

    private boolean N(long j3) {
        if (this.f239109t != null && this.f239097h && this.f239110u.G() == this.f239109t) {
            if (QLog.isColorLevel()) {
                QLog.d(this.f239090a, 2, "checkPreload: status=" + this.f239110u.x());
            }
            this.f239109t.f239135d = j3;
            if (!Z() && !b() && !V()) {
                if (!W() && !Y()) {
                    this.f239097h = false;
                    if (QLog.isColorLevel()) {
                        QLog.d(this.f239090a, 2, "checkPreload: checkPreload player was preload but status error");
                    }
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.d(this.f239090a, 2, "checkPreload: prePlaying, just do nothing ");
                    }
                    Iterator<com.tencent.mobileqq.kandian.base.video.player.c> it = this.f239115z.iterator();
                    while (it.hasNext()) {
                        it.next().d(false);
                    }
                    this.f239097h = false;
                    this.f239110u.l0();
                    this.f239110u.w0();
                    this.f239091b = true;
                    this.C.sendEmptyMessageDelayed(1, 10000L);
                    return true;
                }
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d(this.f239090a, 2, "checkPreload: hasPrePlay, just go onVideoPrepared");
                }
                Iterator<com.tencent.mobileqq.kandian.base.video.player.c> it5 = this.f239115z.iterator();
                while (it5.hasNext()) {
                    it5.next().d(true);
                }
                Iterator<com.tencent.mobileqq.kandian.base.video.player.c> it6 = this.f239115z.iterator();
                while (it6.hasNext()) {
                    it6.next().i(this.f239110u);
                }
                this.f239110u.l0();
                this.f239110u.w0();
                T();
                return true;
            }
        }
        return false;
    }

    private VideoPlayerWrapper O() {
        VideoPlayerWrapper videoPlayerWrapper = new VideoPlayerWrapper(this.f239108s.getApplicationContext(), this.D);
        videoPlayerWrapper.s0(this.B);
        this.f239111v.removeAllViews();
        videoPlayerWrapper.P(this.f239111v, !TextUtils.isEmpty(this.D), this.E);
        View K = videoPlayerWrapper.K();
        if (K != null) {
            K.setId(R.id.hym);
            this.f239111v.setKeepScreenOn(true);
        }
        videoPlayerWrapper.q0(this.f239101l);
        videoPlayerWrapper.u0(this.f239100k);
        videoPlayerWrapper.r0(this.f239098i);
        videoPlayerWrapper.y0(this.f239102m);
        videoPlayerWrapper.t0(this.f239099j);
        videoPlayerWrapper.A0(this.f239103n);
        return videoPlayerWrapper;
    }

    private void P(b bVar) {
        this.f239110u.z0(bVar);
        this.f239091b = true;
        this.f239104o = 0;
        this.C.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q() {
        VideoPlayerWrapper videoPlayerWrapper = this.f239110u;
        if (videoPlayerWrapper.Y()) {
            long w3 = videoPlayerWrapper.w();
            if (w3 >= videoPlayerWrapper.z() - 500) {
                this.f239096g = true;
            } else if (w3 >= 0 && this.f239096g && videoPlayerWrapper.V()) {
                if (QLog.isColorLevel()) {
                    QLog.d(this.f239090a, 2, "onVideoReplayOnLoop: pos=" + w3);
                }
                this.f239096g = false;
                this.f239104o++;
                videoPlayerWrapper.i0();
                ConcurrentLinkedQueue<f> concurrentLinkedQueue = this.f239113x;
                if (concurrentLinkedQueue != null) {
                    Iterator<f> it = concurrentLinkedQueue.iterator();
                    while (it.hasNext()) {
                        it.next().onVideoEnd(this.f239104o);
                    }
                }
            }
            ConcurrentLinkedQueue<f> concurrentLinkedQueue2 = this.f239113x;
            if (concurrentLinkedQueue2 != null) {
                Iterator<f> it5 = concurrentLinkedQueue2.iterator();
                while (it5.hasNext()) {
                    it5.next().onProgressChanged(w3);
                }
            }
        }
    }

    private void R(String str, String str2) {
        Iterator<com.tencent.mobileqq.kandian.base.video.player.c> it = this.f239115z.iterator();
        while (it.hasNext()) {
            it.next().f(str, str2, this.f239097h, this.f239101l);
        }
        Iterator<f> it5 = this.f239113x.iterator();
        while (it5.hasNext()) {
            it5.next().onVideoOpen();
        }
        P(this.f239109t);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(final boolean z16, final String str, final String str2, final String str3, final boolean z17, final int i3, final long j3, final int i16) {
        if (QLog.isColorLevel()) {
            String str4 = this.f239090a;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("openByUrl: vid=");
            sb5.append(str);
            sb5.append(", url=");
            sb5.append(str2);
            sb5.append(", playType=");
            sb5.append(i3);
            sb5.append(", startPosition=");
            sb5.append(j3);
            sb5.append(", mainThread=");
            sb5.append(Looper.getMainLooper() == Looper.myLooper());
            QLog.d(str4, 2, sb5.toString());
        }
        if (!this.f239092c && this.F) {
            if (z16 && TextUtils.isEmpty(str2)) {
                this.B.b(null, 201, 61, 0, "url null", null);
                return;
            }
            if (!z16 && TextUtils.isEmpty(str)) {
                this.B.b(null, 201, 61, 0, "vid null", null);
                return;
            }
            this.f239106q = 0L;
            this.f239107r = System.currentTimeMillis();
            if (N(j3)) {
                return;
            }
            this.f239109t = new b(str, str2, i3, j3, i16);
            if (!this.A.j()) {
                this.A.i();
                return;
            }
            M();
            R(str, str2);
            this.f239110u.p0(this.f239112w);
            g0(new Runnable() { // from class: com.tencent.mobileqq.kandian.base.video.player.LitePlayer.3
                @Override // java.lang.Runnable
                public void run() {
                    if (z16) {
                        LitePlayer litePlayer = LitePlayer.this;
                        litePlayer.f239110u.g0(str, str2, i3, j3, 0L, i16, z17, true, litePlayer.f239097h, str3);
                    } else {
                        LitePlayer litePlayer2 = LitePlayer.this;
                        litePlayer2.f239110u.f0(str, i3, j3, litePlayer2.f239097h);
                    }
                }
            });
            return;
        }
        this.B.b(null, 201, 109, 0, "player had destoryed", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a0(b bVar) {
        if (TextUtils.isEmpty(bVar.f239133b)) {
            e0(bVar.f239132a, bVar.f239134c, bVar.f239135d);
        } else {
            c0(bVar.f239132a, bVar.f239133b, bVar.f239134c, bVar.f239135d, bVar.f239136e);
        }
    }

    static void g0(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            ThreadManager.getUIHandler().post(runnable);
        }
    }

    public void K(com.tencent.mobileqq.kandian.base.video.player.c cVar) {
        this.f239115z.add(cVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void L(int i3, int i16, int i17, String str) {
        this.B.b(null, i3, i16, i17, str, null);
    }

    public boolean V() {
        return this.f239110u.S();
    }

    public boolean W() {
        return this.f239110u.U();
    }

    public boolean X() {
        return this.f239110u.A;
    }

    public boolean Y() {
        return this.f239110u.Z();
    }

    public boolean Z() {
        return this.f239110u.a0();
    }

    @Override // com.tencent.mobileqq.kandian.base.video.plugin.a
    public void a(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d(this.f239090a, 2, "onInstallComplete: success=" + z16 + ", mHasDestory=" + this.f239092c);
        }
        if (z16) {
            if (this.f239092c || !this.F) {
                return;
            }
            this.f239110u = O();
            b bVar = this.f239109t;
            if (bVar != null) {
                a0(bVar);
                return;
            }
            return;
        }
        Iterator<f> it = this.f239113x.iterator();
        while (it.hasNext()) {
            it.next().onVideoError(123, 99, null);
        }
    }

    public boolean b() {
        return this.f239110u.X();
    }

    public void b0(String str, int i3, long j3, int i16) {
        d0("", str, null, true, i3, j3, i16);
    }

    public boolean c() {
        return this.f239097h;
    }

    public void d(boolean z16) {
        this.f239098i = z16;
        this.f239110u.r0(z16);
    }

    public void d0(final String str, final String str2, final String str3, final boolean z16, final int i3, final long j3, final int i16) {
        g0(new Runnable() { // from class: com.tencent.mobileqq.kandian.base.video.player.LitePlayer.2
            @Override // java.lang.Runnable
            public void run() {
                LitePlayer.this.S(true, str, str2, str3, z16, i3, j3, i16);
            }
        });
    }

    public void e(int i3) {
        this.f239105p = i3;
    }

    public void e0(final String str, final int i3, final long j3) {
        g0(new Runnable() { // from class: com.tencent.mobileqq.kandian.base.video.player.LitePlayer.1
            @Override // java.lang.Runnable
            public void run() {
                LitePlayer.this.S(false, str, null, null, true, i3, j3, 0);
            }
        });
    }

    public void f0() {
        if (QLog.isColorLevel()) {
            QLog.d(this.f239090a, 2, "restart: status=" + getCurrentState());
        }
        if (b() || Z()) {
            this.f239110u.k0();
            g.a(new Runnable() { // from class: com.tencent.mobileqq.kandian.base.video.player.LitePlayer.6
                @Override // java.lang.Runnable
                public void run() {
                    Iterator it = LitePlayer.this.f239113x.iterator();
                    while (it.hasNext()) {
                        ((f) it.next()).onVideoRestart();
                    }
                }
            });
        }
    }

    public boolean g() {
        return this.f239109t != null && (Y() || Z() || b() || isPlaying() || V());
    }

    public long getCurrentPosition() {
        return this.f239110u.w();
    }

    public int getCurrentState() {
        return this.f239110u.x();
    }

    public long getDuration() {
        return this.f239110u.z();
    }

    public int getVideoHeight() {
        return this.f239110u.J();
    }

    public int getVideoWidth() {
        return this.f239110u.M();
    }

    public void h(ViewGroup viewGroup) {
        if (QLog.isColorLevel()) {
            QLog.d(this.f239090a, 2, "attach: " + viewGroup);
        }
        n();
        if (this.f239111v.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.f239111v.getParent()).removeView(this.f239111v);
        }
        j();
        viewGroup.addView(this.f239111v, -1, -1);
    }

    public void i(f fVar) {
        this.f239113x.add(fVar);
    }

    public boolean isPlaying() {
        return this.f239110u.Y();
    }

    public void j() {
        this.f239110u.v();
    }

    public void n() {
        this.f239110u.C0();
    }

    public void onDestroy() {
        if (!this.f239092c) {
            H--;
        }
        this.f239092c = true;
        this.f239093d = false;
        if (QLog.isColorLevel()) {
            QLog.d(this.f239090a, 2, "doOnDestory: destroy player, player_num=" + H);
        }
        stop();
        this.f239110u.t();
        VideoPluginInstall videoPluginInstall = this.A;
        if (videoPluginInstall != null) {
            videoPluginInstall.g();
        }
        this.C.removeCallbacksAndMessages(null);
        this.f239113x.clear();
        this.f239115z.clear();
    }

    public void pause() {
        if (QLog.isColorLevel()) {
            QLog.d(this.f239090a, 2, "pause: status=" + getCurrentState());
        }
        if (isPlaying() || V()) {
            this.f239110u.d0();
            g.a(new Runnable() { // from class: com.tencent.mobileqq.kandian.base.video.player.LitePlayer.5
                @Override // java.lang.Runnable
                public void run() {
                    Iterator it = LitePlayer.this.f239113x.iterator();
                    while (it.hasNext()) {
                        ((f) it.next()).onVideoPause();
                    }
                }
            });
        }
    }

    public void seekTo(int i3) {
        this.f239110u.n0(i3);
    }

    public void setLoopback(boolean z16) {
        this.f239099j = z16;
        this.f239110u.t0(z16);
    }

    public void setMute(boolean z16) {
        this.f239100k = z16;
        this.f239110u.u0(z16);
    }

    public void setXYaxis(int i3) {
        this.f239103n = i3;
        this.f239110u.A0(i3);
    }

    public void start() {
        if (QLog.isColorLevel()) {
            QLog.d(this.f239090a, 2, "start: status=" + getCurrentState());
        }
        Iterator<f> it = this.f239113x.iterator();
        while (it.hasNext()) {
            it.next().beforeVideoStart();
        }
        this.f239110u.B0();
        this.C.removeMessages(0);
        this.C.sendEmptyMessage(0);
        g.a(new Runnable() { // from class: com.tencent.mobileqq.kandian.base.video.player.LitePlayer.4
            @Override // java.lang.Runnable
            public void run() {
                Iterator it5 = LitePlayer.this.f239113x.iterator();
                while (it5.hasNext()) {
                    ((f) it5.next()).onVideoStart();
                }
            }
        });
        Iterator<com.tencent.mobileqq.kandian.base.video.player.c> it5 = this.f239115z.iterator();
        while (it5.hasNext()) {
            it5.next().g(this.f239110u);
        }
    }

    public void stop() {
        if (QLog.isColorLevel()) {
            QLog.d(this.f239090a, 2, "stop: mPlayParam=" + this.f239109t);
        }
        if (this.f239109t != null) {
            Iterator<f> it = this.f239113x.iterator();
            while (it.hasNext()) {
                it.next().onVideoStop();
            }
            Iterator<com.tencent.mobileqq.kandian.base.video.player.c> it5 = this.f239115z.iterator();
            while (it5.hasNext()) {
                it5.next().h(this.f239110u, this.f239104o);
            }
        }
        U(this.f239110u);
        this.f239097h = false;
        this.f239098i = true;
        this.f239099j = false;
        this.f239100k = false;
        this.f239101l = false;
        this.f239102m = 1.0f;
        this.f239103n = 0;
        this.f239109t = null;
        this.f239104o = 0;
        this.D = null;
        this.f239111v.setKeepScreenOn(false);
        this.C.removeMessages(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T() {
        this.f239097h = false;
        this.C.removeMessages(1);
        if (this.f239093d) {
            start();
            b bVar = this.f239109t;
            if (bVar == null || bVar.f239135d / 1000 == this.f239110u.w() / 1000) {
                return;
            }
            seekTo((int) (this.f239109t.f239135d / 1000));
            return;
        }
        this.f239094e = true;
    }

    public void m(boolean z16) {
        this.f239097h = true;
        this.f239101l = z16;
        this.f239110u.q0(z16);
        if (QLog.isColorLevel()) {
            QLog.d(this.f239090a, 2, "startPreload: coverFrame=" + z16);
        }
    }

    public void onPause() {
        this.f239093d = false;
        if (QLog.isColorLevel()) {
            QLog.d(this.f239090a, 2, "doOnPause() isPlaying()=" + isPlaying());
        }
        if (isPlaying() || V()) {
            this.f239095f = true;
            this.f239091b = false;
            pause();
        }
    }

    public void onResume() {
        this.f239093d = true;
        if (QLog.isColorLevel()) {
            QLog.d(this.f239090a, 2, "onResume: ");
        }
        if (this.f239094e && Z()) {
            T();
        } else if (this.f239095f) {
            this.f239091b = true;
            f0();
        }
        this.f239095f = false;
        this.f239094e = false;
    }

    public void h0(VideoPlayerWrapper videoPlayerWrapper) {
        if (videoPlayerWrapper != null) {
            U(videoPlayerWrapper);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(VideoPlayerWrapper videoPlayerWrapper) {
        if (videoPlayerWrapper == null) {
            return;
        }
        videoPlayerWrapper.j0();
        if (videoPlayerWrapper.b0() || videoPlayerWrapper.T()) {
            return;
        }
        videoPlayerWrapper.D0();
        videoPlayerWrapper.z0(null);
    }

    public void c0(String str, String str2, int i3, long j3, int i16) {
        d0(str, str2, null, true, i3, j3, i16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes33.dex */
    public class a extends d {
        a() {
        }

        private void i() {
            if (QLog.isColorLevel()) {
                QLog.d(LitePlayer.this.f239090a, 2, "onPreloadFinished()");
            }
        }

        @Override // o52.e
        public void a(o52.c cVar, String str) {
            if (QLog.isColorLevel()) {
                QLog.d(LitePlayer.this.f239090a, 2, "onConnectQualityCallback json= " + str);
            }
            b unused = LitePlayer.this.f239109t;
            Iterator it = LitePlayer.this.f239115z.iterator();
            while (it.hasNext()) {
                ((com.tencent.mobileqq.kandian.base.video.player.c) it.next()).b(str);
            }
        }

        @Override // o52.e
        public boolean b(o52.c cVar, int i3, int i16, int i17, String str, Object obj) {
            String str2;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("model : ");
            sb5.append(i3);
            sb5.append(" what : ");
            sb5.append(i16);
            sb5.append(" extra : ");
            sb5.append(i17);
            sb5.append("detailInfo : ");
            sb5.append(str);
            sb5.append(" obj : ");
            if (obj != null) {
                str2 = obj.toString();
            } else {
                str2 = "";
            }
            sb5.append(str2);
            String sb6 = sb5.toString();
            if (QLog.isColorLevel()) {
                String str3 = LitePlayer.this.f239090a;
                StringBuilder sb7 = new StringBuilder();
                sb7.append("\u64ad\u653e\u72b6\u6001\u56de\u8c03 onError() ");
                sb7.append(sb6);
                sb7.append(", vid=");
                sb7.append(LitePlayer.this.f239109t != null ? LitePlayer.this.f239109t.f239132a : null);
                QLog.d(str3, 2, sb7.toString());
            }
            if (LitePlayer.this.f239097h) {
                LitePlayer litePlayer = LitePlayer.this;
                litePlayer.U(litePlayer.f239110u);
                LitePlayer.this.f239097h = false;
            }
            String a16 = com.tencent.mobileqq.kandian.base.video.player.b.a(i3, i16, i17);
            Iterator it = LitePlayer.this.f239113x.iterator();
            while (it.hasNext()) {
                ((f) it.next()).onVideoError(i3, i16, a16);
            }
            if (LitePlayer.this.f239115z != null) {
                Iterator it5 = LitePlayer.this.f239115z.iterator();
                while (it5.hasNext()) {
                    ((com.tencent.mobileqq.kandian.base.video.player.c) it5.next()).c(i3, i16, a16);
                }
            }
            return false;
        }

        @Override // o52.e
        public void c(o52.c cVar) {
            String str;
            if (QLog.isColorLevel()) {
                String str2 = LitePlayer.this.f239090a;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("\u64ad\u653e\u72b6\u6001\u56de\u8c03 onCompletion() vid=");
                if (LitePlayer.this.f239109t != null) {
                    str = LitePlayer.this.f239109t.f239132a;
                } else {
                    str = "param null";
                }
                sb5.append(str);
                QLog.d(str2, 2, sb5.toString());
            }
            LitePlayer.this.f239110u.z0(null);
            Iterator it = LitePlayer.this.f239113x.iterator();
            while (it.hasNext()) {
                ((f) it.next()).onCompletion();
            }
            Iterator it5 = LitePlayer.this.f239115z.iterator();
            while (it5.hasNext()) {
                ((com.tencent.mobileqq.kandian.base.video.player.c) it5.next()).a();
            }
        }

        @Override // o52.e
        public void d(o52.c cVar, Object obj) {
            if (QLog.isColorLevel()) {
                QLog.d(LitePlayer.this.f239090a, 2, "onVideoPrepared(VideoPlayerWrapper player, Object tag) ");
            }
            LitePlayer.this.f239106q = System.currentTimeMillis() - LitePlayer.this.f239107r;
            if (QLog.isColorLevel()) {
                String str = LitePlayer.this.f239109t != null ? LitePlayer.this.f239109t.f239132a : null;
                QLog.d(LitePlayer.this.f239090a, 2, "\u64ad\u653e\u72b6\u6001\u56de\u8c03 onVideoPrepared() vid=" + str + ", mIsOpenedVideo = " + LitePlayer.this.f239091b + ", preload=" + LitePlayer.this.f239097h + ", mActivityOnResume=" + LitePlayer.this.f239093d + ", isPredownloadHit=" + LitePlayer.this.X() + ", cost=" + LitePlayer.this.f239106q + "ms");
            }
            if (!LitePlayer.this.f239097h) {
                if (LitePlayer.this.f239091b && !LitePlayer.this.f239092c && LitePlayer.this.F) {
                    LitePlayer.this.f239091b = false;
                    LitePlayer.this.C.removeMessages(0);
                    LitePlayer.this.C.sendEmptyMessage(0);
                    Iterator it = LitePlayer.this.f239113x.iterator();
                    while (it.hasNext()) {
                        ((f) it.next()).onVideoPrepared();
                    }
                    Iterator it5 = LitePlayer.this.f239115z.iterator();
                    while (it5.hasNext()) {
                        ((com.tencent.mobileqq.kandian.base.video.player.c) it5.next()).i(LitePlayer.this.f239110u);
                    }
                    LitePlayer.this.T();
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(LitePlayer.this.f239090a, 2, "onVideoPrepared  return mIsOpenedVideo=" + LitePlayer.this.f239091b + ", mHasDestory=" + LitePlayer.this.f239092c);
                    return;
                }
                return;
            }
            i();
        }

        @Override // com.tencent.mobileqq.kandian.base.video.player.d, o52.e
        public void f(o52.c cVar, boolean z16, int i3, int i16, Bitmap bitmap) {
            super.f(cVar, z16, i3, i16, bitmap);
            if (z16 && i3 == 0) {
                Iterator it = LitePlayer.this.f239114y.iterator();
                while (it.hasNext()) {
                    ((e) it.next()).onCaptureImageSucceed(i16, bitmap.getWidth(), bitmap.getHeight(), bitmap);
                }
            } else {
                Iterator it5 = LitePlayer.this.f239114y.iterator();
                while (it5.hasNext()) {
                    ((e) it5.next()).onCaptureImageFailed(i16, i3);
                }
            }
        }

        @Override // o52.e
        public boolean e(o52.c cVar, int i3, Object obj) {
            if (i3 == 105) {
                if (QLog.isColorLevel()) {
                    QLog.d(LitePlayer.this.f239090a, 2, "onInfo: PLAYER_INFO_FIRST_VIDEO_FRAME_REDNERED");
                }
                Iterator it = LitePlayer.this.f239113x.iterator();
                while (it.hasNext()) {
                    ((f) it.next()).onFirstFrameRendered();
                }
            } else if (i3 == 112) {
                if (QLog.isColorLevel()) {
                    QLog.d(LitePlayer.this.f239090a, 2, "\u64ad\u653e\u72b6\u6001\u56de\u8c03 onInfo() PLAYER_INFO_START_BUFFERING");
                }
                Iterator it5 = LitePlayer.this.f239113x.iterator();
                while (it5.hasNext()) {
                    ((f) it5.next()).onBufferStart();
                }
            } else if (i3 == 113) {
                if (QLog.isColorLevel()) {
                    QLog.d(LitePlayer.this.f239090a, 2, "\u64ad\u653e\u72b6\u6001\u56de\u8c03 onInfo() PLAYER_INFO_ENDOF_BUFFERING");
                }
                Iterator it6 = LitePlayer.this.f239113x.iterator();
                while (it6.hasNext()) {
                    ((f) it6.next()).onBufferEnd();
                }
            }
            Iterator it7 = LitePlayer.this.f239115z.iterator();
            while (it7.hasNext()) {
                ((com.tencent.mobileqq.kandian.base.video.player.c) it7.next()).e(i3, obj);
            }
            return false;
        }
    }
}
