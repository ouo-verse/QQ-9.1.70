package com.tencent.biz.pubaccount.weishi.player;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.avbiz.Constants;
import com.tencent.biz.pubaccount.weishi.player.WSVideoPluginInstall;
import com.tencent.biz.pubaccount.weishi.player.wrapper.WSPlayerDownloadInfo;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.video.event.RFWMediaFocusChangeEvent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import mqq.util.WeakReference;

/* loaded from: classes32.dex */
public class WSPlayerManager implements WSVideoPluginInstall.b, SimpleEventReceiver {

    /* renamed from: a0, reason: collision with root package name */
    private static final Object f81031a0 = new Object();
    private WSVideoPreDownloadManager C;
    private WSPlayerForNetInfoHandler D;
    private boolean P;
    private boolean Q;
    private int X;
    private int Y;

    /* renamed from: d, reason: collision with root package name */
    private WeakReference<QQAppInterface> f81032d;

    /* renamed from: f, reason: collision with root package name */
    private WSVideoPluginInstall f81034f;

    /* renamed from: h, reason: collision with root package name */
    private e f81035h;

    /* renamed from: i, reason: collision with root package name */
    private e f81036i;

    /* renamed from: m, reason: collision with root package name */
    private ArrayList<f> f81037m;
    private final MediaPlayListenerAdapterImpl E = new MediaPlayListenerAdapterImpl();
    private final ConcurrentHashMap<WSPlayerWrapper, Object> F = new ConcurrentHashMap<>();
    private final Handler G = new a(this, Looper.getMainLooper());
    private boolean H = false;
    private boolean I = false;
    private boolean J = false;
    private boolean K = false;
    private boolean L = false;
    private boolean M = true;
    private boolean N = false;
    private boolean R = false;
    private boolean S = false;
    private boolean T = false;
    private boolean U = false;
    private boolean V = false;
    private boolean W = false;
    private int Z = -1;

    /* renamed from: e, reason: collision with root package name */
    private Context f81033e = BaseApplicationImpl.getApplication().getApplicationContext();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes32.dex */
    public class PlayStartVideoRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private final e f81059d;

        /* renamed from: e, reason: collision with root package name */
        private final WSPlayerWrapper f81060e;

        /* renamed from: f, reason: collision with root package name */
        private final boolean f81061f;

        PlayStartVideoRunnable(e eVar, WSPlayerWrapper wSPlayerWrapper, boolean z16) {
            this.f81059d = eVar;
            this.f81060e = wSPlayerWrapper;
            this.f81061f = z16;
        }

        @Override // java.lang.Runnable
        public void run() {
            x.j("WS_VIDEO_PLAYER", "[WSPlayerManager.java][PlayStartVideoRunnable.run] post thread");
            if ((!this.f81061f && !WSPlayerManager.this.Z(this.f81060e)) || this.f81059d == null || this.f81060e == null || WSPlayerManager.this.I) {
                return;
            }
            if (!this.f81061f) {
                WSPlayerManager.this.U = true;
            }
            long j3 = this.f81059d.f81132h;
            if (j3 > 0) {
                WSPlayerManager.this.R = true;
            }
            if (TextUtils.isEmpty(this.f81059d.f81127c.f81171f)) {
                return;
            }
            WSPlayerManager.this.W0(this.f81059d, this.f81060e);
            WSVideoPreDownloadManager wSVideoPreDownloadManager = WSPlayerManager.this.C;
            boolean z16 = wSVideoPreDownloadManager != null && wSVideoPreDownloadManager.n(this.f81059d.f81127c.f81171f);
            x.j("WS_VIDEO_PLAYER", "[WSPlayerManager.java][PlayStartVideoRunnable.run] goto playerStartByUrl!! isPreDownload:" + z16 + ", videoUrl:" + this.f81059d.f81127c.f81171f);
            this.f81060e.s0(z16);
            if (this.f81060e.h0(this.f81059d.f81127c, 101, j3, this.f81061f)) {
                return;
            }
            x.f("WS_VIDEO_PLAYER", "[WSPlayerManager.java][PlayStartVideoRunnable.run] playerStartByUrl failed, sendMsg retry.");
            WSPlayerManager.this.G.sendEmptyMessage(-4);
        }
    }

    public WSPlayerManager(QQAppInterface qQAppInterface) {
        this.f81032d = new WeakReference<>(qQAppInterface);
        WSVideoPluginInstall wSVideoPluginInstall = new WSVideoPluginInstall();
        this.f81034f = wSVideoPluginInstall;
        wSVideoPluginInstall.k(this);
        this.f81037m = new ArrayList<>();
        WSPlayerForNetInfoHandler wSPlayerForNetInfoHandler = new WSPlayerForNetInfoHandler(this);
        this.D = wSPlayerForNetInfoHandler;
        AppNetConnInfo.registerConnectionChangeReceiver(this.f81033e, wSPlayerForNetInfoHandler);
        SimpleEventBus.getInstance().registerReceiver(this);
        this.P = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I0() {
        WSPlayerWrapper i06 = i0();
        if (i06 != null) {
            if (i06.B() == 5 || i06.B() == 2) {
                i06.A0();
                u10.b.g(this.f81035h);
                if (!this.M) {
                    i06.g0();
                    this.T = true;
                    this.U = false;
                    x.j("WS_VIDEO_PLAYER", "[WSPlayerManager.java][restart] activity become onPause after videoPlayer.restart(), so we need to pause it!");
                    return;
                }
                e eVar = this.f81035h;
                com.tencent.biz.pubaccount.weishi.player.a aVar = eVar.f81136l;
                if (aVar != null) {
                    aVar.b(eVar);
                }
                ArrayList<f> arrayList = this.f81037m;
                if (arrayList != null) {
                    Iterator<f> it = arrayList.iterator();
                    while (it.hasNext()) {
                        it.next().b(this.f81035h);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J0() {
        x.m("WS_VIDEO_PLAYER", "<------------------------------- [WSPlayerManager.java][onVideoStart] title:" + r0(this.f81035h));
        e eVar = this.f81035h;
        if (eVar == null) {
            return;
        }
        u10.b.h(eVar);
        this.G.removeMessages(-2);
        this.G.sendEmptyMessage(-2);
        this.G.post(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.player.WSPlayerManager.4
            @Override // java.lang.Runnable
            public void run() {
                if (WSPlayerManager.this.i0() == null || WSPlayerManager.this.f81035h == null || WSPlayerManager.this.f81035h.f81126b == null) {
                    return;
                }
                if (WSPlayerManager.this.f81035h.f81136l != null) {
                    WSPlayerManager.this.f81035h.f81136l.e(WSPlayerManager.this.f81035h);
                }
                if (WSPlayerManager.this.f81037m != null) {
                    Iterator it = WSPlayerManager.this.f81037m.iterator();
                    while (it.hasNext()) {
                        ((f) it.next()).e(WSPlayerManager.this.f81035h);
                    }
                }
            }
        });
        t00.a m06 = m0(this.f81035h);
        if (m06 != null) {
            m06.g(q0(this.f81035h));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Y(e eVar) {
        return a0(eVar) != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Z(WSPlayerWrapper wSPlayerWrapper) {
        return b0(wSPlayerWrapper) != null;
    }

    private e a0(e eVar) {
        if (eVar == this.f81035h) {
            return eVar;
        }
        return null;
    }

    private WSPlayerWrapper b0(WSPlayerWrapper wSPlayerWrapper) {
        if (wSPlayerWrapper == i0()) {
            return wSPlayerWrapper;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WSPlayerWrapper c0() {
        Context context = this.f81033e;
        if (context == null) {
            return null;
        }
        WSPlayerWrapper wSPlayerWrapper = new WSPlayerWrapper(context);
        wSPlayerWrapper.w0(this.E);
        return wSPlayerWrapper;
    }

    private void h0() {
        if (D0()) {
            O0();
        } else if (F0() || z0() || y0() || A0()) {
            L0(this.f81035h, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WSPlayerWrapper i0() {
        return q0(this.f81035h);
    }

    private void u0(RFWMediaFocusChangeEvent rFWMediaFocusChangeEvent) {
        if (TextUtils.equals(rFWMediaFocusChangeEvent.getFocusBusinessName(), Constants.Business.QQ_CIRCLE_WINDOW) && TextUtils.equals(Constants.Business.QQ_WEISHI_VIDEO, rFWMediaFocusChangeEvent.getConflictBusinessName()) && rFWMediaFocusChangeEvent.hasFocusConflict()) {
            K0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w0(e eVar, boolean z16) {
        ViewGroup viewGroup;
        View a16;
        int i3;
        int i16;
        WSPlayerWrapper q06 = q0(eVar);
        if (eVar != null && q06 != null && (viewGroup = eVar.f81125a) != null) {
            viewGroup.setKeepScreenOn(true);
            if (eVar.f81126b == null) {
                x.j("WS_VIDEO_PRE_PLAY", "[WSPlayerManager.java][innerPlayVideo] videoView null. goto getVideoViewScroll.");
                com.tencent.biz.pubaccount.weishi.player.wrapper.h U = q06.U();
                if (U != null && (a16 = U.a()) != null) {
                    eVar.f81126b = U;
                    eVar.f81125a.addView(a16, new ViewGroup.LayoutParams(-1, -1));
                    q06.D0(U);
                    com.tencent.biz.pubaccount.weishi.player.a aVar = eVar.f81136l;
                    if (aVar != null) {
                        aVar.n(eVar);
                    }
                    l lVar = eVar.f81127c;
                    if (lVar != null && (i3 = lVar.f81167b) > 0 && (i16 = lVar.f81168c) > 0 && i16 < 10000 && i3 < 10000) {
                        U.setFixedSize(i3, i16);
                    }
                } else {
                    com.tencent.biz.pubaccount.weishi.player.a aVar2 = eVar.f81136l;
                    if (aVar2 != null) {
                        aVar2.c(eVar, 999, 999, null);
                    }
                    eVar.f81129e = null;
                    return;
                }
            }
            int i17 = this.H ? 2 : eVar.f81130f;
            q06.y0(i17);
            q06.u0(this.S || this.N);
            q06.r0(this.P);
            q06.t0(eVar.f81134j);
            q06.G().setOutputMute(this.Q);
            x.j("WS_VIDEO_PLAYER", "[WSPlayerManager.java][innerPlayVideo] xyAxis:" + i17 + ", isMuted:" + this.Q + ", mPreOutputFirstFrame:" + this.P);
            View a17 = eVar.f81126b.a();
            if (a17 != null) {
                a17.setVisibility(0);
            }
            ThreadManagerV2.excute(new PlayStartVideoRunnable(eVar, q06, z16), 16, null, true);
            return;
        }
        x.f("WS_VIDEO_PRE_PLAY", "[WSPlayerManager.java][innerPlayVideo] playParam:" + eVar);
    }

    public boolean A0() {
        return k0() == 0;
    }

    public boolean B0() {
        return this.N;
    }

    public boolean C0() {
        return this.Q;
    }

    public boolean D0() {
        return k0() == 5;
    }

    public boolean E0() {
        return k0() == 3;
    }

    public boolean F0() {
        return k0() == 2;
    }

    public boolean G0() {
        return k0() == 4;
    }

    public boolean H0() {
        return k0() == 1;
    }

    public void K0() {
        if (this.f81035h == null || i0() == null) {
            return;
        }
        if (i0().B() == 3 || i0().B() == 4) {
            u10.b.f(this.f81035h);
            i0().g0();
            e eVar = this.f81035h;
            com.tencent.biz.pubaccount.weishi.player.a aVar = eVar.f81136l;
            if (aVar != null) {
                aVar.d(eVar);
            }
            ArrayList<f> arrayList = this.f81037m;
            if (arrayList != null) {
                Iterator<f> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().d(this.f81035h);
                }
            }
        }
    }

    public void L0(e eVar, boolean z16) {
        Object obj;
        x.m("WS_VIDEO_PLAYER", "-------------------------------> [WSPlayerManager.java][playVideo] title:" + r0(eVar) + ", id:" + o0(eVar) + ", fileSize:" + l0(eVar));
        if (eVar != null && eVar.f81127c != null) {
            x.j("WS_VIDEO_PLAYER", "[WSPlayerManager.java][playVideo] videoUrl:" + eVar.f81127c.f81171f);
            this.J = false;
            this.X = 0;
            this.K = false;
            this.L = false;
            this.R = false;
            this.f81035h = eVar;
            this.Y = 0;
            ArrayList<f> arrayList = this.f81037m;
            if (arrayList != null) {
                Iterator<f> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().i(this.f81035h);
                }
            }
            e eVar2 = this.f81035h;
            com.tencent.biz.pubaccount.weishi.player.a aVar = eVar2.f81136l;
            if (aVar != null) {
                aVar.l(eVar2, z16);
            }
            this.G.removeMessages(-3);
            this.G.removeMessages(-4);
            WSPlayerWrapper q06 = q0(eVar);
            t00.a m06 = m0(eVar);
            if (q06 != null && q06.d0() && q06.P() == eVar.f81127c) {
                eVar.f81133i = false;
                this.W = false;
                this.f81036i = null;
                eVar.f81129e.o0();
                if (m06 != null) {
                    m06.i(true);
                    m06.h(2);
                    m06.c(q0(eVar));
                }
                x.j("WS_VIDEO_PLAYER", "[WSPlayerManager.java][playVideo] hasPrePlay, just go startVideoAfterPrepared! title:" + r0(eVar));
                this.E.s();
                return;
            }
            if (eVar.f81133i && (q06 == null || q06.P() == eVar.f81127c)) {
                if (q06 != null) {
                    q06.o0();
                }
                this.U = true;
                if (m06 != null) {
                    m06.i(false);
                    m06.h(1);
                }
                StringBuilder sb5 = new StringBuilder();
                sb5.append("[WSPlayerManager.java][playVideo] prePlaying, just do nothing! playerStatus:");
                if (q06 != null) {
                    obj = Integer.valueOf(q06.B());
                } else {
                    obj = " ";
                }
                sb5.append(obj);
                sb5.append(", title:");
                sb5.append(r0(eVar));
                x.f("WS_VIDEO_PRE_PLAY", sb5.toString());
                this.G.sendEmptyMessageDelayed(-3, 150L);
                return;
            }
            this.W = false;
            this.f81036i = null;
            v0(this.f81035h, false);
            WSVideoPluginInstall wSVideoPluginInstall = this.f81034f;
            if (wSVideoPluginInstall != null && !wSVideoPluginInstall.j()) {
                x.f("WS_VIDEO_PLAYER", "[WSPlayerManager.java][playVideo] installPlugin!");
                this.f81034f.i();
                return;
            } else {
                x.j("WS_VIDEO_PLAYER", "[WSPlayerManager.java][playVideo] createVideoPlayerAndPlay!");
                d0(eVar, false);
                return;
            }
        }
        x.f("WS_VIDEO_PLAYER", "[WSPlayerManager.java][playVideo] error, playerParam or videoInfo is null.");
    }

    public void M0(e eVar) {
        x.m("WS_VIDEO_PRE_PLAY", "===============================> [WSPlayerManager.java][prePlayVideo] title:" + r0(eVar));
        if (eVar == null) {
            x.f("WS_VIDEO_PRE_PLAY", "[WSPlayerManager.java][prePlayVideo] playerParam is null.");
            return;
        }
        WSPlayerWrapper q06 = q0(eVar);
        if (q06 != null && eVar.f81133i && q06.P() == eVar.f81127c) {
            return;
        }
        WSVideoPluginInstall wSVideoPluginInstall = this.f81034f;
        if (wSVideoPluginInstall != null && !wSVideoPluginInstall.j()) {
            this.f81034f.i();
            return;
        }
        if (q06 == null || q06.Z() || q06.B() == 6 || q06.B() == 7) {
            eVar.f81133i = true;
            this.f81036i = eVar;
            v0(eVar, true);
            e eVar2 = this.f81036i;
            com.tencent.biz.pubaccount.weishi.player.a aVar = eVar2.f81136l;
            if (aVar != null) {
                aVar.j(eVar2);
            }
            d0(eVar, true);
        }
    }

    public void N0() {
        WSPlayerWrapper i06 = i0();
        if (i06 != null) {
            i06.i0();
        }
    }

    public void O0() {
        this.G.post(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.player.d
            @Override // java.lang.Runnable
            public final void run() {
                WSPlayerManager.this.I0();
            }
        });
    }

    public void P0(int i3, boolean z16) {
        e eVar;
        if (this.f81035h == null || i0() == null) {
            return;
        }
        this.R = true;
        i0().q0(i3);
        if (z16 && (eVar = this.f81035h) != null && eVar.f81136l != null) {
            long D = i0().D();
            e eVar2 = this.f81035h;
            eVar2.f81136l.m(eVar2, i3, D);
        }
        this.G.removeMessages(-2);
    }

    public void Q0(boolean z16) {
        this.N = z16;
        WSPlayerWrapper i06 = i0();
        if (i06 != null) {
            i06.u0(z16);
        }
        WSPlayerWrapper q06 = q0(this.f81036i);
        if (q06 != null) {
            q06.u0(z16);
        }
    }

    public void R0(boolean z16) {
        this.S = z16;
        WSPlayerWrapper i06 = i0();
        if (i06 != null) {
            i06.u0(z16 || this.N);
        }
        WSPlayerWrapper q06 = q0(this.f81036i);
        if (q06 != null) {
            q06.u0(z16 || this.N);
        }
    }

    public void S0(boolean z16) {
        this.Q = z16;
        if (i0() != null && i0().G() != null) {
            i0().G().setOutputMute(z16);
        }
        WSPlayerWrapper q06 = q0(this.f81036i);
        if (q06 == null || q06.G() == null) {
            return;
        }
        q06.G().setOutputMute(z16);
    }

    public void T0(float f16) {
        WSPlayerWrapper i06 = i0();
        if (i06 != null) {
            i06.v0(f16);
        }
    }

    public void U0(WSVideoPreDownloadManager wSVideoPreDownloadManager) {
        this.C = wSVideoPreDownloadManager;
    }

    public void V0(boolean z16) {
        e eVar;
        if (this.H != z16) {
            this.H = z16;
            if (i0() == null || (eVar = this.f81035h) == null) {
                return;
            }
            i0().y0(this.H ? 2 : eVar.f81130f);
        }
    }

    public void X(f fVar) {
        ArrayList<f> arrayList = this.f81037m;
        if (arrayList == null || arrayList.contains(fVar)) {
            return;
        }
        this.f81037m.add(fVar);
    }

    public void X0() {
        if (i0() != null) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                ThreadManager.getSubThreadHandler().postAtFrontOfQueue(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.player.WSPlayerManager.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (WSPlayerManager.this.i0() != null) {
                            WSPlayerManager.this.i0().A0();
                            x.j("WS_VIDEO_PLAYER", "[WSPlayerManager.java][start] subThread videoPlayer.start!");
                            if (!WSPlayerManager.this.M && WSPlayerManager.this.i0() != null) {
                                WSPlayerManager.this.i0().g0();
                                WSPlayerManager.this.T = true;
                                WSPlayerManager.this.U = false;
                                x.j("WS_VIDEO_PLAYER", "[WSPlayerManager.java][start] activity become onPause after videoPlayer.start(), so we need to pause it!");
                            }
                            WSPlayerManager.this.J0();
                        }
                    }
                });
                return;
            }
            WSPlayerWrapper i06 = i0();
            if (i06 != null) {
                x.j("WS_VIDEO_PLAYER", "[WSPlayerManager.java][start] videoPlayer.start!");
                i06.A0();
                J0();
            }
        }
    }

    public void Y0() {
        if (this.f81035h != null && i0() != null) {
            u10.b.i(this.f81035h);
            t00.a m06 = m0(this.f81035h);
            if (m06 != null) {
                m06.f(this.f81035h.f81129e, this.J);
            }
            e eVar = this.f81035h;
            eVar.f81133i = false;
            com.tencent.biz.pubaccount.weishi.player.a aVar = eVar.f81136l;
            if (aVar != null) {
                aVar.h(eVar);
            }
            ArrayList<f> arrayList = this.f81037m;
            if (arrayList != null) {
                Iterator<f> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().a(this.f81035h, this.J);
                }
            }
            x.j("WS_VIDEO_PLAYER", "[WSPlayerManager.java][stop] title:" + r0(this.f81035h));
            Z0(this.f81035h);
        }
        if (this.f81035h != null) {
            this.f81035h = null;
        }
        this.X = 0;
        this.K = false;
        this.G.removeMessages(-2);
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.WSVideoPluginInstall.b
    public void a(boolean z16) {
        x.f("WS_VIDEO_PLAYER", "[WSPlayerManager.java][onInstallComplete] success:" + z16);
        if (z16) {
            e eVar = this.f81035h;
            if (eVar != null) {
                L0(eVar, false);
                return;
            }
            return;
        }
        this.f81035h = null;
    }

    public void a1(final e eVar, boolean z16) {
        x.j("WS_VIDEO_PLAYER", "[WSPlayerManager.java][switchPlayerVideoViewLayout] startTime:" + System.currentTimeMillis());
        if (eVar == null) {
            x.f("WS_VIDEO_PLAYER", "[WSPlayerManager.java][switchPlayerVideoViewLayout] playerParam null.");
            return;
        }
        if (eVar.f81126b == null) {
            x.f("WS_VIDEO_PLAYER", "[WSPlayerManager.java][switchPlayerVideoViewLayout] videoView:null, videoLayout:" + eVar.f81125a);
            return;
        }
        if (eVar.f81125a == null) {
            x.f("WS_VIDEO_PLAYER", "[WSPlayerManager.java][switchPlayerVideoViewLayout] videoView:" + eVar.f81126b + ", videoLayout:null");
            View a16 = eVar.f81126b.a();
            if (a16 == null || !(a16.getParent() instanceof ViewGroup)) {
                return;
            }
            ((ViewGroup) a16.getParent()).removeView(a16);
            return;
        }
        WSPlayerWrapper q06 = q0(eVar);
        if (q06 == null) {
            x.f("WS_VIDEO_PLAYER", "[WSPlayerManager.java][switchPlayerVideoViewLayout] videoPlayer null.");
            return;
        }
        this.f81035h = eVar;
        q06.y0(eVar.f81130f);
        q06.p0(eVar.f81126b, eVar.f81125a);
        eVar.f81125a.setKeepScreenOn(true);
        q06.w0(this.E);
        this.G.removeMessages(-2);
        this.G.sendEmptyMessage(-2);
        if (z16) {
            h0();
        }
        this.F.put(q06, f81031a0);
        q06.i0();
        this.G.post(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.player.WSPlayerManager.1
            @Override // java.lang.Runnable
            public void run() {
                x.j("WS_VIDEO_PLAYER", "[WSPlayerManager.java][switchPlayerVideoViewLayout] endTime:" + System.currentTimeMillis());
                if (WSPlayerManager.this.f81037m != null) {
                    Iterator it = WSPlayerManager.this.f81037m.iterator();
                    while (it.hasNext()) {
                        ((f) it.next()).f(eVar);
                    }
                }
                e eVar2 = eVar;
                com.tencent.biz.pubaccount.weishi.player.a aVar = eVar2.f81136l;
                if (aVar != null) {
                    aVar.f(eVar2);
                    if (WSPlayerManager.this.D0()) {
                        e eVar3 = eVar;
                        eVar3.f81136l.d(eVar3);
                    } else if (WSPlayerManager.this.G0()) {
                        e eVar4 = eVar;
                        eVar4.f81136l.q(eVar4);
                    } else if (WSPlayerManager.this.y0()) {
                        e eVar5 = eVar;
                        eVar5.f81136l.o(eVar5);
                    }
                }
            }
        });
    }

    public void e0(boolean z16) {
        x.j("WS_VIDEO_PLAYER", "[WSPlayerManager.java][doOnDestroy] isStopVideo:" + z16);
        this.I = true;
        WSVideoPreDownloadManager wSVideoPreDownloadManager = this.C;
        if (wSVideoPreDownloadManager != null) {
            wSVideoPreDownloadManager.o();
            this.C = null;
        }
        if (z16) {
            Y0();
        }
        this.G.removeCallbacksAndMessages(this.f81035h);
        this.G.removeCallbacksAndMessages(this.f81036i);
        if (this.f81035h != null && z16) {
            if (i0() != null) {
                i0().w();
                this.f81035h.f81129e = null;
            }
            this.f81035h = null;
        }
        e eVar = this.f81036i;
        if (eVar != null && eVar != this.f81035h) {
            WSPlayerWrapper q06 = q0(eVar);
            if (q06 != null) {
                q06.w();
                this.f81036i.f81129e = null;
            }
            this.W = false;
            this.f81036i = null;
        }
        ConcurrentHashMap<WSPlayerWrapper, Object> concurrentHashMap = this.F;
        if (concurrentHashMap != null) {
            for (WSPlayerWrapper wSPlayerWrapper : concurrentHashMap.keySet()) {
                if (wSPlayerWrapper != null && wSPlayerWrapper.B() != 8 && (wSPlayerWrapper != i0() || z16)) {
                    wSPlayerWrapper.w();
                }
            }
            this.F.clear();
        }
        WSVideoPluginInstall wSVideoPluginInstall = this.f81034f;
        if (wSVideoPluginInstall != null) {
            wSVideoPluginInstall.g();
            this.f81034f = null;
        }
        this.G.removeCallbacksAndMessages(null);
        ArrayList<f> arrayList = this.f81037m;
        if (arrayList != null) {
            arrayList.clear();
            this.f81037m = null;
        }
        WSPlayerForNetInfoHandler wSPlayerForNetInfoHandler = this.D;
        if (wSPlayerForNetInfoHandler != null) {
            AppNetConnInfo.unregisterNetInfoHandler(wSPlayerForNetInfoHandler);
            this.D = null;
        }
        WeakReference<QQAppInterface> weakReference = this.f81032d;
        if (weakReference != null) {
            weakReference.clear();
            this.f81032d = null;
        }
        this.f81033e = null;
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    public void g0() {
        QQAppInterface qQAppInterface;
        x.j("WS_VIDEO_PLAYER", "[WSPlayerManager.java][doOnResume] mIsNeedStartOnResume:" + this.V + ", mIsNeedRestartOnResume:" + this.T);
        this.M = true;
        if (this.V && i0() != null && i0().d0()) {
            X0();
        } else if (this.T) {
            WeakReference<QQAppInterface> weakReference = this.f81032d;
            if (!((weakReference == null || (qQAppInterface = weakReference.get()) == null) ? false : qQAppInterface.isVideoChatting())) {
                this.U = true;
                O0();
            }
        }
        this.T = false;
        this.V = false;
        s00.c.f433052d.start(this.f81033e);
        s00.b.f433050a.c(this.f81033e);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(RFWMediaFocusChangeEvent.class);
        return arrayList;
    }

    public long j0() {
        if (this.f81035h == null || i0() == null) {
            return 0L;
        }
        return i0().z();
    }

    public int k0() {
        if (i0() != null) {
            return i0().B();
        }
        return 0;
    }

    public e n0() {
        return this.f81035h;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof RFWMediaFocusChangeEvent) {
            u0((RFWMediaFocusChangeEvent) simpleBaseEvent);
        }
    }

    public String p0() {
        return o0(this.f81035h);
    }

    public boolean y0() {
        return k0() == 7;
    }

    public boolean z0() {
        return k0() == 6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes32.dex */
    public class MediaPlayListenerAdapterImpl extends c {
        MediaPlayListenerAdapterImpl() {
        }

        private boolean k() {
            if (!WSPlayerManager.this.N) {
                return false;
            }
            WSPlayerManager.this.G.post(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.player.WSPlayerManager.MediaPlayListenerAdapterImpl.3
                @Override // java.lang.Runnable
                public void run() {
                    WSPlayerManager wSPlayerManager = WSPlayerManager.this;
                    wSPlayerManager.L0(wSPlayerManager.f81035h, false);
                    WSPlayerWrapper i06 = WSPlayerManager.this.i0();
                    if (i06 != null) {
                        WSPlayerManager.this.X++;
                        i06.r();
                        i06.m0();
                        x.f("WS_VIDEO_PLAYER", "[WSPlayerManager.java][checkPlayerLoop] mReplayCount:" + WSPlayerManager.this.X);
                    }
                    if (WSPlayerManager.this.f81037m != null) {
                        Iterator it = WSPlayerManager.this.f81037m.iterator();
                        while (it.hasNext()) {
                            ((f) it.next()).g(WSPlayerManager.this.f81035h, WSPlayerManager.this.X);
                        }
                    }
                }
            });
            return true;
        }

        private void m(final e eVar) {
            x.j("WS_VIDEO_PLAYER", "[WSPlayerManager.java][onInfo] \u64ad\u653e\u72b6\u6001\u56de\u8c03 PLAYER_INFO_ENDOF_BUFFERING");
            if (WSPlayerManager.this.f81036i != null && o()) {
                WSPlayerManager wSPlayerManager = WSPlayerManager.this;
                WSPlayerWrapper q06 = wSPlayerManager.q0(wSPlayerManager.f81036i);
                if (q06 != null && !q06.d0()) {
                    WSPlayerManager.this.f81036i.f81129e.o0();
                }
            }
            u10.b.d(eVar);
            WSPlayerManager.this.G.post(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.player.WSPlayerManager.MediaPlayListenerAdapterImpl.6
                @Override // java.lang.Runnable
                public void run() {
                    com.tencent.biz.pubaccount.weishi.player.a aVar;
                    e eVar2 = eVar;
                    if (eVar2 == null || (aVar = eVar2.f81136l) == null) {
                        return;
                    }
                    aVar.p(eVar2);
                }
            });
        }

        private void n(final e eVar) {
            x.j("WS_VIDEO_PLAYER", "[WSPlayerManager.java][onInfo] \u64ad\u653e\u72b6\u6001\u56de\u8c03 PLAYER_INFO_START_BUFFERING");
            if (WSPlayerManager.this.f81036i != null && o()) {
                WSPlayerManager wSPlayerManager = WSPlayerManager.this;
                WSPlayerWrapper q06 = wSPlayerManager.q0(wSPlayerManager.f81036i);
                if (q06 != null && !q06.d0()) {
                    WSPlayerManager.this.f81036i.f81129e.C0();
                }
            }
            u10.b.e(eVar);
            WSPlayerManager.this.G.post(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.player.WSPlayerManager.MediaPlayListenerAdapterImpl.7
                @Override // java.lang.Runnable
                public void run() {
                    com.tencent.biz.pubaccount.weishi.player.a aVar;
                    e eVar2 = eVar;
                    if (eVar2 == null || (aVar = eVar2.f81136l) == null) {
                        return;
                    }
                    aVar.q(eVar2);
                }
            });
        }

        private boolean o() {
            e eVar = WSPlayerManager.this.f81036i;
            if (eVar == null) {
                return false;
            }
            return eVar.f81133i;
        }

        private void p(final int i3, final int i16, final int i17, String str, final e eVar) {
            WSPlayerManager.this.G.post(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.player.WSPlayerManager.MediaPlayListenerAdapterImpl.5
                @Override // java.lang.Runnable
                public void run() {
                    com.tencent.biz.pubaccount.weishi.player.a aVar;
                    String a16 = com.tencent.biz.pubaccount.weishi.player.wrapper.k.a(i3, i16, i17);
                    x.f("WS_VIDEO_PLAYER", "[WSPlayerManager.java][notifyPlayerError] \u64ad\u653e\u72b6\u6001\u56de\u8c03 errorContent:" + a16);
                    e eVar2 = eVar;
                    if (eVar2 != null && (aVar = eVar2.f81136l) != null) {
                        aVar.c(eVar2, i3, i16, a16);
                    }
                    if (WSPlayerManager.this.f81037m != null) {
                        Iterator it = WSPlayerManager.this.f81037m.iterator();
                        while (it.hasNext()) {
                            ((f) it.next()).c(eVar, i3, i16, a16);
                        }
                    }
                }
            });
            t00.a m06 = WSPlayerManager.this.m0(eVar);
            if (m06 != null) {
                m06.onError(i3, i16, str);
            }
        }

        private void q() {
            WSPlayerManager wSPlayerManager = WSPlayerManager.this;
            WSPlayerWrapper q06 = wSPlayerManager.q0(wSPlayerManager.f81036i);
            if (q06 != null) {
                q06.C0();
            }
            WSPlayerManager.this.G.post(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.player.WSPlayerManager.MediaPlayListenerAdapterImpl.1
                @Override // java.lang.Runnable
                public void run() {
                    if (WSPlayerManager.this.f81036i != null && WSPlayerManager.this.f81036i.f81136l != null) {
                        WSPlayerManager.this.f81036i.f81136l.g(WSPlayerManager.this.f81036i, WSPlayerManager.this.P, !WSPlayerManager.this.W);
                    }
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("<=============================== [WSPlayerManager.java][onPrePlayFinished] title:");
                    WSPlayerManager wSPlayerManager2 = WSPlayerManager.this;
                    sb5.append(wSPlayerManager2.r0(wSPlayerManager2.f81036i));
                    x.m("WS_VIDEO_PRE_PLAY", sb5.toString());
                }
            });
            r();
        }

        private void r() {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[WSPlayerManager.java][onDownloadFinish] \u9884\u64ad\u4efb\u52a1 prePlayTitle:");
            WSPlayerManager wSPlayerManager = WSPlayerManager.this;
            sb5.append(wSPlayerManager.r0(wSPlayerManager.f81036i));
            x.j("WS_VIDEO_PRE_PLAY", sb5.toString());
            e eVar = WSPlayerManager.this.f81036i;
            WSVideoPreDownloadManager wSVideoPreDownloadManager = WSPlayerManager.this.C;
            if (wSVideoPreDownloadManager == null || eVar == null) {
                return;
            }
            int i3 = eVar.f81131g;
            wSVideoPreDownloadManager.w(i3, i3 > WSPlayerManager.this.Z);
            WSPlayerManager.this.Z = i3;
        }

        @Override // com.tencent.biz.pubaccount.weishi.player.c
        public void c(WSPlayerWrapper wSPlayerWrapper) {
            super.c(wSPlayerWrapper);
            if (!WSPlayerManager.this.Z(wSPlayerWrapper)) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("[WSPlayerManager.java][onCompletion] checkIsPlayerPlaying false! playingVideoUrl:");
                WSPlayerManager wSPlayerManager = WSPlayerManager.this;
                sb5.append(wSPlayerManager.t0(wSPlayerManager.f81035h));
                x.f("WS_VIDEO_PLAYER", sb5.toString());
                return;
            }
            StringBuilder sb6 = new StringBuilder();
            sb6.append("[WSPlayerManager.java][onCompletion] \u64ad\u653e\u72b6\u6001\u56de\u8c03 playingVideoUrl:");
            WSPlayerManager wSPlayerManager2 = WSPlayerManager.this;
            sb6.append(wSPlayerManager2.t0(wSPlayerManager2.f81035h));
            x.j("WS_VIDEO_PLAYER", sb6.toString());
            if (k()) {
                x.f("WS_VIDEO_PLAYER", "[WSPlayerManager.java][onCompletion] checkPlayerLoop:true!");
            } else {
                WSPlayerManager.this.G.post(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.player.WSPlayerManager.MediaPlayListenerAdapterImpl.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (WSPlayerManager.this.f81035h != null && WSPlayerManager.this.f81035h.f81136l != null) {
                            WSPlayerManager.this.f81035h.f81136l.o(WSPlayerManager.this.f81035h);
                        }
                        if (WSPlayerManager.this.f81037m != null) {
                            Iterator it = WSPlayerManager.this.f81037m.iterator();
                            while (it.hasNext()) {
                                ((f) it.next()).h(WSPlayerManager.this.f81035h);
                            }
                        }
                    }
                });
                WSPlayerManager.this.J = true;
            }
        }

        @Override // com.tencent.biz.pubaccount.weishi.player.c
        public void d(WSPlayerWrapper wSPlayerWrapper, WSPlayerDownloadInfo wSPlayerDownloadInfo) {
            super.d(wSPlayerWrapper, wSPlayerDownloadInfo);
            WSPlayerManager wSPlayerManager = WSPlayerManager.this;
            t00.a m06 = wSPlayerManager.m0(wSPlayerManager.f81035h);
            if (m06 != null) {
                WSPlayerManager wSPlayerManager2 = WSPlayerManager.this;
                int l06 = wSPlayerManager2.l0(wSPlayerManager2.f81035h);
                WSPlayerManager wSPlayerManager3 = WSPlayerManager.this;
                wSPlayerDownloadInfo.O(i.q(wSPlayerManager3.s0(wSPlayerManager3.f81035h), l06));
                m06.e(wSPlayerWrapper, wSPlayerDownloadInfo);
            }
        }

        @Override // com.tencent.biz.pubaccount.weishi.player.c
        public boolean e(WSPlayerWrapper wSPlayerWrapper, int i3, int i16, int i17, String str, Object obj) {
            String str2;
            String str3;
            super.e(wSPlayerWrapper, i3, i16, i17, str, obj);
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
            if (WSPlayerManager.this.Z(wSPlayerWrapper)) {
                e eVar = WSPlayerManager.this.f81035h;
                StringBuilder sb7 = new StringBuilder();
                sb7.append("[WSPlayerManager.java][onError] \u64ad\u653e\u72b6\u6001\u56de\u8c03 errorStr:");
                sb7.append(sb6);
                sb7.append(", playingVideoUrl:");
                if (eVar == null) {
                    str3 = "playingVideoParam is null.";
                } else {
                    l lVar = eVar.f81127c;
                    if (lVar != null) {
                        str3 = lVar.f81171f;
                    } else {
                        str3 = "videoInfo is null.";
                    }
                }
                sb7.append(str3);
                x.f("WS_VIDEO_PLAYER", sb7.toString());
                if (l(eVar)) {
                    return false;
                }
                p(i3, i16, i17, str, eVar);
                return false;
            }
            WSPlayerManager wSPlayerManager = WSPlayerManager.this;
            if (wSPlayerManager.q0(wSPlayerManager.f81036i) == wSPlayerWrapper && wSPlayerWrapper != null) {
                wSPlayerWrapper.C0();
                WSPlayerManager.this.f81036i.f81133i = false;
            }
            return false;
        }

        @Override // com.tencent.biz.pubaccount.weishi.player.c
        public boolean f(WSPlayerWrapper wSPlayerWrapper, int i3, Object obj) {
            super.f(wSPlayerWrapper, i3, obj);
            if (i3 == 42 || WSPlayerManager.this.Z(wSPlayerWrapper)) {
                e eVar = WSPlayerManager.this.f81035h;
                if (i3 == 112) {
                    n(eVar);
                } else if (i3 == 113) {
                    m(eVar);
                }
                t00.a m06 = WSPlayerManager.this.m0(eVar);
                if (m06 != null) {
                    m06.a(i3, obj);
                }
                return false;
            }
            if (i3 == 39) {
                if (WSPlayerManager.this.f81036i != null && o()) {
                    WSPlayerManager.this.W = true;
                }
                x.f("WS_VIDEO_PLAYER", "[WSPlayerManager.java][onInfo] \u64ad\u653e\u72b6\u6001\u56de\u8c03 PLAYER_INFO_HW_DECODE_FAILED mIsPrePlayHWDecodeFailed:" + WSPlayerManager.this.W);
            }
            return false;
        }

        @Override // com.tencent.biz.pubaccount.weishi.player.c
        public void g(WSPlayerWrapper wSPlayerWrapper, WSPlayerDownloadInfo wSPlayerDownloadInfo) {
            super.g(wSPlayerWrapper, wSPlayerDownloadInfo);
            WSPlayerManager wSPlayerManager = WSPlayerManager.this;
            t00.a m06 = wSPlayerManager.m0(wSPlayerManager.f81035h);
            if (m06 != null) {
                m06.b(wSPlayerWrapper, wSPlayerDownloadInfo);
            }
        }

        @Override // com.tencent.biz.pubaccount.weishi.player.c
        public void h(WSPlayerWrapper wSPlayerWrapper) {
            super.h(wSPlayerWrapper);
            WSPlayerManager.this.G.sendEmptyMessageDelayed(-2, 500L);
        }

        @Override // com.tencent.biz.pubaccount.weishi.player.c
        void i(int i3, int i16, int i17) {
            super.i(i3, i16, i17);
            WSPlayerManager wSPlayerManager = WSPlayerManager.this;
            t00.a m06 = wSPlayerManager.m0(wSPlayerManager.f81035h);
            if (m06 != null) {
                m06.j(i3, i16, i17);
            }
        }

        @Override // com.tencent.biz.pubaccount.weishi.player.c
        public void j(WSPlayerWrapper wSPlayerWrapper, Object obj) {
            e eVar = WSPlayerManager.this.f81035h;
            x.j("WS_VIDEO_PLAYER", "[WSPlayerManager.java][onVideoPrepared] \u89c6\u9891\u51c6\u5907\u5b8c\u6210\u72b6\u6001! mIsOpenedVideo:" + WSPlayerManager.this.U + ", playingTitle:" + WSPlayerManager.this.r0(eVar));
            if (WSPlayerManager.this.Z(wSPlayerWrapper)) {
                if (WSPlayerManager.this.U) {
                    WSPlayerManager.this.U = false;
                    if (WSPlayerManager.this.m0(eVar) != null) {
                        WSPlayerManager.this.m0(eVar).c(WSPlayerManager.this.q0(eVar));
                    }
                    x.j("WS_VIDEO_PLAYER", "[WSPlayerManager.java][onVideoPrepared] startVideoAfterPrepared!");
                    s();
                    return;
                }
                x.f("WS_VIDEO_PLAYER", "[WSPlayerManager.java][onVideoPrepared] mIsOpenedVideo is false. return!");
                return;
            }
            x.j("WS_VIDEO_PRE_PLAY", "[WSPlayerManager.java][onVideoPrepared] prePlayVideo prepared!");
            WSPlayerManager wSPlayerManager = WSPlayerManager.this;
            if (wSPlayerManager.q0(wSPlayerManager.f81036i) == wSPlayerWrapper && o()) {
                q();
            }
        }

        void s() {
            WSPlayerManager.this.G.removeMessages(-3);
            WSPlayerManager.this.G.removeMessages(-4);
            if (!WSPlayerManager.this.M) {
                WSPlayerManager.this.V = true;
            } else {
                WSPlayerManager.this.X0();
            }
        }

        private boolean l(final e eVar) {
            l lVar;
            if (eVar == null || eVar.f81128d >= 1 || (lVar = eVar.f81127c) == null) {
                return false;
            }
            int i3 = lVar.f81179n;
            if ((i3 != 2 && i3 != 1) || WSPlayerManager.this.j0() != 0) {
                return false;
            }
            WSPlayerManager.this.G.post(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.player.WSPlayerManager.MediaPlayListenerAdapterImpl.4
                @Override // java.lang.Runnable
                public void run() {
                    i.H(eVar.f81127c);
                    WSPlayerManager.this.L0(eVar, false);
                    eVar.f81128d++;
                    x.f("WS_VIDEO_PLAYER", "[WSPlayerManager.java][handleOnErrorForRetryPlayVideo] retryPlayCount:" + eVar.f81128d + ", url:" + eVar.f81127c.f81171f);
                }
            });
            return true;
        }
    }

    /* loaded from: classes32.dex */
    private static class a extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<WSPlayerManager> f81062a;

        a(WSPlayerManager wSPlayerManager, Looper looper) {
            super(looper);
            this.f81062a = new WeakReference<>(wSPlayerManager);
        }

        @Override // android.os.Handler
        public void dispatchMessage(Message message) {
            WSPlayerManager wSPlayerManager = this.f81062a.get();
            if (wSPlayerManager == null || wSPlayerManager.I) {
                return;
            }
            Object obj = message.obj;
            if (obj instanceof e) {
                if (wSPlayerManager.Y((e) obj)) {
                    super.dispatchMessage(message);
                    return;
                }
                return;
            }
            super.dispatchMessage(message);
        }

        @Override // android.os.Handler
        public boolean sendMessageAtTime(Message message, long j3) {
            WSPlayerManager wSPlayerManager = this.f81062a.get();
            if (wSPlayerManager == null || wSPlayerManager.I) {
                return false;
            }
            if (Looper.myLooper() == Looper.getMainLooper() && j3 <= SystemClock.uptimeMillis()) {
                if (message.getCallback() != null) {
                    message.getCallback().run();
                    return true;
                }
                handleMessage(message);
                return true;
            }
            if (message.obj == null) {
                message.obj = wSPlayerManager.f81035h;
            }
            return super.sendMessageAtTime(message, j3);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            String str;
            com.tencent.biz.pubaccount.weishi.player.a aVar;
            long j3;
            WSPlayerManager wSPlayerManager = this.f81062a.get();
            if (wSPlayerManager == null) {
                return;
            }
            int i3 = message.what;
            boolean z16 = true;
            if (i3 == -4) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("[WSPlayerManager.java][handleMessage] MSG_PLAY_BY_URL_FAILED. playerStartByUrl failed, retry again. RetryVideoUrl:");
                if (wSPlayerManager.f81035h.f81127c != null) {
                    str = wSPlayerManager.f81035h.f81127c.f81171f;
                } else {
                    str = "videoInfo is null.";
                }
                sb5.append(str);
                x.f("WS_VIDEO_PLAYER", sb5.toString());
                if (wSPlayerManager.Y == 1) {
                    return;
                }
                wSPlayerManager.f81035h.f81133i = false;
                wSPlayerManager.Z0(wSPlayerManager.f81035h);
                wSPlayerManager.d0(wSPlayerManager.f81035h, false);
                wSPlayerManager.Y++;
                return;
            }
            if (i3 == -3) {
                x.j("WS_VIDEO_PRE_PLAY", "[WSPlayerManager.java][handleMessage] MSG_PRE_PLAY_TIME_OUT. prePlay timeout, try rePlay");
                WSPlayerWrapper q06 = wSPlayerManager.q0(wSPlayerManager.f81035h);
                if (q06 != null && q06.d0() && q06.P() == wSPlayerManager.f81035h.f81127c) {
                    x.j("WS_VIDEO_PLAYER", "[WSPlayerManager.java][handleMessage] MSG_PRE_PLAY_TIME_OUT. startVideoAfterPrepared!");
                    wSPlayerManager.E.s();
                    return;
                } else {
                    wSPlayerManager.f81035h.f81133i = false;
                    wSPlayerManager.Z0(wSPlayerManager.f81035h);
                    wSPlayerManager.d0(wSPlayerManager.f81035h, false);
                    return;
                }
            }
            if (i3 != -2) {
                return;
            }
            WSPlayerWrapper i06 = wSPlayerManager.i0();
            e eVar = wSPlayerManager.f81035h;
            if (i06 != null && i06.b0() && (((aVar = eVar.f81136l) == null || !aVar.k(eVar)) && !i06.e0())) {
                long z17 = i06.z();
                long D = i06.D();
                com.tencent.biz.pubaccount.weishi.player.a aVar2 = eVar.f81136l;
                if (aVar2 != null) {
                    j3 = D;
                    aVar2.m(eVar, z17, D);
                } else {
                    j3 = D;
                }
                long j16 = j3;
                if (z17 >= j16 - 300) {
                    wSPlayerManager.K = true;
                    int i16 = (int) (j16 - z17);
                    x.j("WS_VIDEO_PLAYER", "[WSPlayerManager.java][handleMessage] MSG_FOR_UPDATE_VIDEO_PLAY_POSITION onVideoEndSoon pos:" + z17 + ", duration:" + j16 + ", remainDuration:" + i16 + ", mHasCallEndingSoon:" + wSPlayerManager.L);
                    if (!wSPlayerManager.L && wSPlayerManager.f81037m != null) {
                        wSPlayerManager.L = true;
                        if (eVar.f81136l != null && !wSPlayerManager.R) {
                            if (!wSPlayerManager.N && !wSPlayerManager.S) {
                                z16 = false;
                            }
                            eVar.f81136l.i(wSPlayerManager.f81035h, i16, z16);
                        }
                    }
                } else if (z17 <= 500 && z17 >= 0 && wSPlayerManager.K) {
                    x.j("WS_VIDEO_PLAYER", "[WSPlayerManager.java][handleMessage] MSG_FOR_UPDATE_VIDEO_PLAY_POSITION onVideoReplayOnLoop pos:" + z17);
                    wSPlayerManager.R = false;
                    wSPlayerManager.L = false;
                    wSPlayerManager.K = false;
                    wSPlayerManager.X++;
                    i06.r();
                    i06.m0();
                    if (wSPlayerManager.f81037m != null) {
                        Iterator it = wSPlayerManager.f81037m.iterator();
                        while (it.hasNext()) {
                            ((f) it.next()).g(wSPlayerManager.f81035h, wSPlayerManager.X);
                        }
                    }
                }
            }
            wSPlayerManager.G.sendEmptyMessageDelayed(-2, 100L);
        }
    }

    public void f0() {
        this.M = false;
        x.j("WS_VIDEO_PLAYER", "[WSPlayerManager.java][doOnPause] isPlaying:" + E0());
        if (E0() || G0()) {
            this.T = true;
            this.U = false;
            K0();
        }
        for (WSPlayerWrapper wSPlayerWrapper : this.F.keySet()) {
            if (wSPlayerWrapper != null && wSPlayerWrapper.b0()) {
                x.j("WS_VIDEO_PLAYER", "[WSPlayerManager.java][doOnPause] stop!");
                wSPlayerWrapper.B0();
            }
        }
        s00.c.f433052d.stop(this.f81033e);
        s00.b.f433050a.e(this.f81033e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W0(e eVar, WSPlayerWrapper wSPlayerWrapper) {
        l lVar = eVar != null ? eVar.f81127c : null;
        if (lVar != null) {
            x.j("WS_VIDEO_Buffer", "[WSPlayerManager.java][setupBufferRange] videoTitle:" + lVar.f81175j);
            s00.f.f433060d.p(wSPlayerWrapper, lVar.f81169d / 1000, (long) l0(eVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z0(e eVar) {
        if (eVar != null) {
            x0(eVar.f81129e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int l0(e eVar) {
        l lVar;
        if (eVar == null || (lVar = eVar.f81127c) == null) {
            return 0;
        }
        return lVar.f81170e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public t00.a m0(e eVar) {
        if (eVar != null) {
            return eVar.f81137m;
        }
        return null;
    }

    private String o0(e eVar) {
        l lVar;
        if (eVar != null && (lVar = eVar.f81127c) != null) {
            return lVar.f81166a;
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WSPlayerWrapper q0(e eVar) {
        if (eVar != null) {
            return eVar.f81129e;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String r0(e eVar) {
        if (eVar == null) {
            return "WSPlayerParam is null.";
        }
        l lVar = eVar.f81127c;
        if (lVar == null) {
            return "VideoInfo is null.";
        }
        return lVar.f81175j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String s0(e eVar) {
        l lVar;
        if (eVar != null && (lVar = eVar.f81127c) != null) {
            return lVar.f81171f;
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String t0(e eVar) {
        if (eVar == null) {
            return "WSPlayerParam is null!";
        }
        l lVar = eVar.f81127c;
        if (lVar == null) {
            return "VideoInfo is null!";
        }
        return lVar.f81171f;
    }

    private void v0(e eVar, boolean z16) {
        if (eVar != null) {
            if (eVar.f81137m == null) {
                eVar.f81137m = new t00.f();
            }
            eVar.f81137m.d(eVar.f81127c, z16, eVar.f81135k);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d0(e eVar, final boolean z16) {
        View a16;
        if (eVar == null) {
            return;
        }
        com.tencent.biz.pubaccount.weishi.player.wrapper.h hVar = eVar.f81126b;
        if (hVar != null && (a16 = hVar.a()) != null && a16.getParent() != eVar.f81125a) {
            x.f("WS_VIDEO_PLAYER", "[WSPlayerManager.java][createVideoPlayerAndPlay] playerParam.mVideoView.getParent:" + a16.getParent() + ", playerParam.mVideoLayout:" + eVar.f81125a);
            eVar.f81129e = null;
            eVar.f81126b = null;
        }
        WSPlayerWrapper q06 = q0(eVar);
        if (q06 != null && q06.P() == null) {
            x.j("WS_VIDEO_PRE_PLAY", "[WSPlayerManager.java][createVideoPlayerAndPlay] hit getVideoPlayerFromParam. goto innerPlayVideo!");
            eVar.f81129e.x0(eVar.f81127c);
            w0(eVar, z16);
            return;
        }
        final boolean z17 = false;
        if (q06 != null && q06.P() != null) {
            q06.x(false);
            x.j("WS_VIDEO_PRE_PLAY", "[WSPlayerManager.java][createVideoPlayerAndPlay] videoPlayer.tag isn't null!");
            z17 = true;
        }
        final WeakReference weakReference = new WeakReference(eVar);
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.player.WSPlayerManager.2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                e eVar2 = (e) weakReference.get();
                if (eVar2 == null) {
                    return;
                }
                WSPlayerWrapper c06 = WSPlayerManager.this.c0();
                eVar2.f81129e = c06;
                if (c06 != null && WSPlayerManager.this.G != null) {
                    c06.x0(eVar2.f81127c);
                    WSPlayerManager.this.F.put(c06, WSPlayerManager.f81031a0);
                    WSPlayerManager.this.G.post(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.player.WSPlayerManager.2.1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.lang.Runnable
                        public void run() {
                            e eVar3 = (e) weakReference.get();
                            if (eVar3 == null) {
                                return;
                            }
                            x.j("WS_VIDEO_PLAYER", "[WSPlayerManager.java][createVideoPlayerAndPlay] innerPlayVideo miss cache.");
                            if (z17 && eVar3.f81126b != null) {
                                x.j("WS_VIDEO_PLAYER", "[WSPlayerManager.java][createVideoPlayerAndPlay] set videoView null !!!");
                                eVar3.f81126b = null;
                            }
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            WSPlayerManager.this.w0(eVar3, z16);
                        }
                    });
                } else {
                    x.e("WS_VIDEO_PLAYER", 2, "[WSPlayerManager.java][createVideoPlayerAndPlay] async run error! playerParam.videoPlayer:" + eVar2.f81129e + ", mUIHandler:" + WSPlayerManager.this.G);
                }
            }
        }, 5, null, true);
    }

    private void x0(final WSPlayerWrapper wSPlayerWrapper) {
        if (wSPlayerWrapper == null) {
            return;
        }
        wSPlayerWrapper.n0();
        int B = wSPlayerWrapper.B();
        if (B == 7 || B == 8 || B == 0 || B == 6) {
            return;
        }
        wSPlayerWrapper.C0();
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.player.WSPlayerManager.5
            @Override // java.lang.Runnable
            public void run() {
                wSPlayerWrapper.B0();
                wSPlayerWrapper.x0(null);
            }
        }, 16, null, true);
    }
}
