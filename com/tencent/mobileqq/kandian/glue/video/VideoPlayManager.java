package com.tencent.mobileqq.kandian.glue.video;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.kandian.base.video.player.VideoPlayerWrapper;
import com.tencent.mobileqq.kandian.base.video.plugin.VideoPluginInstall;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.video.VideoUIManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import f62.e;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import r52.b;
import r62.a;
import r62.b;

/* loaded from: classes33.dex */
public class VideoPlayManager implements com.tencent.mobileqq.kandian.base.video.plugin.a, j62.b {

    /* renamed from: w, reason: collision with root package name */
    public static final String f239980w = "Q.readinjoy.video." + VideoPlayManager.class.getSimpleName();

    /* renamed from: a, reason: collision with root package name */
    private AtomicInteger f239981a;

    /* renamed from: b, reason: collision with root package name */
    private VideoPluginInstall f239982b;

    /* renamed from: c, reason: collision with root package name */
    private VideoPlayerWrapper f239983c;

    /* renamed from: d, reason: collision with root package name */
    private volatile Activity f239984d;

    /* renamed from: e, reason: collision with root package name */
    private k62.b f239985e;

    /* renamed from: f, reason: collision with root package name */
    private k62.b f239986f;

    /* renamed from: g, reason: collision with root package name */
    public k62.b f239987g;

    /* renamed from: h, reason: collision with root package name */
    private k62.b f239988h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f239989i;

    /* renamed from: j, reason: collision with root package name */
    protected int f239990j;

    /* renamed from: k, reason: collision with root package name */
    private int f239991k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f239992l;

    /* renamed from: m, reason: collision with root package name */
    private Map<String, WeakReference<VideoPlayerWrapper>> f239993m;

    /* renamed from: n, reason: collision with root package name */
    private CopyOnWriteArrayList<e> f239994n;

    /* renamed from: o, reason: collision with root package name */
    private VideoUIManager f239995o;

    /* renamed from: p, reason: collision with root package name */
    private volatile boolean f239996p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f239997q;

    /* renamed from: r, reason: collision with root package name */
    private String f239998r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f239999s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f240000t;

    /* renamed from: u, reason: collision with root package name */
    private Handler f240001u;

    /* renamed from: v, reason: collision with root package name */
    private Set<b> f240002v;

    /* renamed from: com.tencent.mobileqq.kandian.glue.video.VideoPlayManager$1, reason: invalid class name */
    /* loaded from: classes33.dex */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ VideoPlayManager this$0;

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.Y(6);
        }
    }

    /* renamed from: com.tencent.mobileqq.kandian.glue.video.VideoPlayManager$3, reason: invalid class name */
    /* loaded from: classes33.dex */
    class AnonymousClass3 implements Runnable {
        final /* synthetic */ VideoPlayManager this$0;

        @Override // java.lang.Runnable
        public void run() {
            VideoPlayManager videoPlayManager = this.this$0;
            videoPlayManager.v(videoPlayManager.f239985e, this.this$0.f239983c, 7, null);
            if (this.this$0.f240002v != null) {
                for (b bVar : this.this$0.f240002v) {
                    if (bVar != null) {
                        bVar.c(this.this$0.f239985e, this.this$0.f239995o.Q());
                    }
                }
            }
            if (this.this$0.f239985e != null) {
                this.this$0.f239985e.f411782n = -1;
                this.this$0.f239985e.f411778j = 0L;
                this.this$0.f239985e = null;
            }
            if (this.this$0.f239983c != null) {
                this.this$0.f239983c.t();
                this.this$0.f239983c = null;
            }
        }
    }

    /* renamed from: com.tencent.mobileqq.kandian.glue.video.VideoPlayManager$4, reason: invalid class name */
    /* loaded from: classes33.dex */
    class AnonymousClass4 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f240004d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f240005e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f240006f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ VideoPlayerWrapper f240007h;
        final /* synthetic */ VideoPlayManager this$0;

        @Override // java.lang.Runnable
        public void run() {
            if (this.this$0.f239985e != null) {
                int[] iArr = {this.f240004d, this.f240005e};
                VideoPlayManager videoPlayManager = this.this$0;
                videoPlayManager.v(videoPlayManager.f239985e, this.this$0.f239983c, 6, iArr);
                this.this$0.f239985e.f411785q.f428396g = this.f240004d + ":" + this.f240005e;
                this.this$0.f239985e.f411785q.f428398h = this.f240006f;
                this.this$0.f239985e.f411785q.f428390d = 0L;
                this.this$0.f239985e.f411785q.f428394f = false;
                this.this$0.f239985e.f411785q.f428416u = this.f240007h.E();
                this.this$0.f239985e.f411785q.f428417v = this.f240007h.D();
                this.this$0.f239985e.f411785q.f428418w = this.f240007h.I();
                this.this$0.f239985e.f411785q.f428419x = this.f240007h.A;
                this.this$0.f239985e.f411785q.C = this.f240007h.f239162w;
                this.this$0.f239985e.f411785q.B = this.f240007h.f239160u;
                this.this$0.f239985e.f411785q.D = this.f240007h.y();
                this.this$0.f239985e.f411785q.f428399h0 = this.f240007h.A();
                VideoPlayManager videoPlayManager2 = this.this$0;
                videoPlayManager2.x(videoPlayManager2.f239985e);
                this.f240007h.l(this.this$0.f239985e.f411785q.a());
            }
            this.this$0.f239985e = null;
            this.this$0.f239983c = null;
            this.f240007h.t();
        }
    }

    /* renamed from: com.tencent.mobileqq.kandian.glue.video.VideoPlayManager$5, reason: invalid class name */
    /* loaded from: classes33.dex */
    class AnonymousClass5 implements Runnable {
        final /* synthetic */ VideoPlayManager this$0;

        @Override // java.lang.Runnable
        public void run() {
            if (this.this$0.f240002v != null) {
                for (b bVar : this.this$0.f240002v) {
                    if (bVar != null) {
                        bVar.a(this.this$0.f239985e);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes33.dex */
    public class a implements b.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ VideoPlayerWrapper f240019a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ k62.b f240020b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ r52.b f240021c;

        a(VideoPlayerWrapper videoPlayerWrapper, k62.b bVar, r52.b bVar2) {
            this.f240019a = videoPlayerWrapper;
            this.f240020b = bVar;
            this.f240021c = bVar2;
        }
    }

    /* loaded from: classes33.dex */
    public interface b {
        void a(k62.b bVar);

        void c(k62.b bVar, boolean z16);
    }

    public static boolean I(String str) {
        QQAppInterface b16;
        if (TextUtils.isEmpty(str) || (b16 = com.tencent.mobileqq.kandian.base.utils.b.b()) == null) {
            return false;
        }
        return ((IPublicAccountDataManager) b16.getRuntimeService(IPublicAccountDataManager.class, "all")).isFollowedUin(Long.valueOf(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(VideoPlayerWrapper videoPlayerWrapper, k62.b bVar) {
        r62.a.e(videoPlayerWrapper);
    }

    private void S(VideoPlayerWrapper videoPlayerWrapper, k62.b bVar, boolean z16) {
        r62.a.b(this.f239984d, videoPlayerWrapper, a.C11116a.g(bVar).i("14").h(2).m(bVar.f411772d).n(videoPlayerWrapper.z()).k(videoPlayerWrapper.F()).l(z16 ? 2 : 1).j(1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void v(final k62.b bVar, final VideoPlayerWrapper videoPlayerWrapper, final int i3, final Object obj) {
        final int i16 = this.f239981a.get();
        if (i3 != i16) {
            if (QLog.isColorLevel()) {
                QLog.d(f239980w, 2, "changeStateAndNotify(): " + com.tencent.mobileqq.kandian.base.video.a.c(this.f239981a.get()) + " ===> " + com.tencent.mobileqq.kandian.base.video.a.c(i3) + ", extra = " + obj + ", videoPlayParam=" + bVar + ", videoPlayWrapper=" + videoPlayerWrapper);
            }
            this.f239981a.set(i3);
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                CopyOnWriteArrayList<e> copyOnWriteArrayList = this.f239994n;
                if (copyOnWriteArrayList != null) {
                    Iterator<e> it = copyOnWriteArrayList.iterator();
                    while (it.hasNext()) {
                        e next = it.next();
                        if (next != null) {
                            next.b(bVar, videoPlayerWrapper, i16, i3, obj);
                        }
                    }
                }
                A(i3, false);
            } else {
                this.f240001u.post(new Runnable() { // from class: com.tencent.mobileqq.kandian.glue.video.VideoPlayManager.6
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VideoPlayManager.this.f239994n != null) {
                            Iterator it5 = VideoPlayManager.this.f239994n.iterator();
                            while (it5.hasNext()) {
                                e eVar = (e) it5.next();
                                if (eVar != null) {
                                    eVar.b(bVar, videoPlayerWrapper, i16, i3, obj);
                                }
                            }
                        }
                        VideoPlayManager.this.A(i3, true);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(VideoPlayerWrapper videoPlayerWrapper, k62.b bVar) {
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.TAG_READINJOY_VIDEO, 2, "doOpenVideo executed On SubThread, busitype:" + bVar.f411783o + " vid:" + bVar.f411771c);
        }
        VideoPlayerWrapper videoPlayerWrapper2 = this.f239983c;
        if (videoPlayerWrapper2 == null || videoPlayerWrapper2 != videoPlayerWrapper) {
            return;
        }
        if (!TextUtils.isEmpty(bVar.f411771c)) {
            if (bVar.f411778j <= 0 && !bVar.f411790v) {
                bVar.f411778j = c.f240045a.c(bVar.f411784p, bVar.f411771c);
            }
            int i3 = bVar.f411783o;
            if (i3 != 2 && i3 != 6) {
                videoPlayerWrapper.e0(bVar.f411771c, 1, bVar.f411778j);
            } else {
                r52.b a16 = r52.b.a();
                a16.g(bVar.f411771c, new a(videoPlayerWrapper, bVar, a16));
            }
            ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).videoPlayRealtimeReport(bVar.f411784p, bVar.f411771c, 0, 0);
            return;
        }
        throw null;
    }

    public int B() {
        VideoPlayerWrapper videoPlayerWrapper = this.f239983c;
        int x16 = videoPlayerWrapper != null ? videoPlayerWrapper.x() : 0;
        if (x16 == this.f239981a.get()) {
            return x16;
        }
        if (QLog.isColorLevel()) {
            QLog.w(LogTag.TAG_READINJOY_VIDEO, 2, "getCurPlayState, should not happen...: mVideoPlayerWrapper.getCurrentStatus() = " + com.tencent.mobileqq.kandian.base.video.a.c(x16) + ",mState.get()=" + com.tencent.mobileqq.kandian.base.video.a.c(this.f239981a.get()));
        }
        return this.f239981a.get();
    }

    public long C() {
        VideoPlayerWrapper videoPlayerWrapper = this.f239983c;
        if (videoPlayerWrapper != null) {
            return videoPlayerWrapper.w();
        }
        return 0L;
    }

    public k62.b D() {
        return this.f239985e;
    }

    public int E() {
        VideoPlayerWrapper videoPlayerWrapper = this.f239983c;
        if (videoPlayerWrapper != null) {
            return videoPlayerWrapper.J();
        }
        return -1;
    }

    public VideoPlayerWrapper F(k62.b bVar) {
        if (this.f239984d == null) {
            return null;
        }
        VideoPlayerWrapper videoPlayerWrapper = new VideoPlayerWrapper(this.f239984d.getApplicationContext());
        videoPlayerWrapper.r0(true);
        videoPlayerWrapper.s0(null);
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.TAG_READINJOY_VIDEO, 2, "getVideoPlayer new instant!");
        }
        this.f239993m.put(bVar.a(), new WeakReference<>(videoPlayerWrapper));
        return videoPlayerWrapper;
    }

    public int G() {
        VideoPlayerWrapper videoPlayerWrapper = this.f239983c;
        if (videoPlayerWrapper != null) {
            return videoPlayerWrapper.M();
        }
        return -1;
    }

    public int H() {
        return this.f239990j;
    }

    public boolean J() {
        VideoPlayerWrapper videoPlayerWrapper = this.f239983c;
        return videoPlayerWrapper != null && videoPlayerWrapper.W();
    }

    public boolean K() {
        if (this.f239983c != null && this.f239985e != null) {
            if (B() == 5) {
                if (this.f239983c.X() || !QLog.isColorLevel()) {
                    return true;
                }
                QLog.w(f239980w, 2, "isPause(): return true. getCurPlayState is PLAY_STATE_PAUSED. But mVideoPlayerWrapper.isPause() == false;");
                return true;
            }
            if (this.f239983c.X() && QLog.isColorLevel()) {
                QLog.w(f239980w, 2, "isPause(): return false. getCurPlayState is " + com.tencent.mobileqq.kandian.base.video.a.c(B()) + ". But mVideoPlayerWrapper.isPause() == true;");
            }
        }
        return false;
    }

    public boolean L() {
        VideoPlayerWrapper videoPlayerWrapper = this.f239983c;
        return videoPlayerWrapper != null && videoPlayerWrapper.Y();
    }

    public boolean M() {
        return this.f239996p;
    }

    public void N() {
        if (this.f239999s) {
            V(false);
            this.f239999s = false;
        }
    }

    public void O() {
        if (J()) {
            return;
        }
        V(true);
        this.f239999s = true;
    }

    public void Q(boolean z16) {
        VideoPlayerWrapper videoPlayerWrapper = this.f239983c;
        if (videoPlayerWrapper == null || !videoPlayerWrapper.Y()) {
            return;
        }
        this.f239983c.d0();
        this.f239997q = z16;
        if (!NetworkUtil.isWifiConnected(this.f239984d.getApplicationContext())) {
            this.f239983c.E0();
        }
        v(this.f239985e, this.f239983c, 5, Boolean.valueOf(this.f239997q));
        this.f239985e.f411778j = C();
        this.f239985e.f411785q.f428390d = this.f239983c.H(false);
    }

    public void U(boolean z16) {
        if (K()) {
            if (VideoVolumeControl.isInCall(this.f239984d)) {
                if (QLog.isColorLevel()) {
                    QLog.d(LogTag.TAG_READINJOY_VIDEO, 2, "VideoPlayManager resume, in call return");
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(LogTag.TAG_READINJOY_VIDEO, 2, "VideoPlayManager : resume(), mannulResume:" + z16 + ", mPausedByMannul:" + this.f239997q);
            }
            this.f239983c.k0();
            this.f239989i = true;
            this.f239997q = false;
            v(this.f239985e, this.f239983c, 3, null);
            S(this.f239983c, this.f239985e, z16);
        }
    }

    public void V(boolean z16) {
        Object obj;
        k62.b bVar = this.f239985e;
        if (bVar != null && bVar.f411790v) {
            z16 = bVar.f411792x;
        }
        if (this.f239983c != null) {
            if (QLog.isColorLevel()) {
                String str = f239980w;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("setMute: mute=");
                sb5.append(z16);
                sb5.append(", isAd=");
                k62.b bVar2 = this.f239985e;
                if (bVar2 != null) {
                    obj = Boolean.valueOf(bVar2.f411790v);
                } else {
                    obj = "false";
                }
                sb5.append(obj);
                QLog.d(str, 2, sb5.toString());
            }
            this.f239983c.u0(z16);
        }
    }

    public void W(boolean z16) {
        this.f240000t = z16;
    }

    public void X(int i3) {
        this.f239990j = i3;
        VideoPlayerWrapper videoPlayerWrapper = this.f239983c;
        if (videoPlayerWrapper != null) {
            videoPlayerWrapper.A0(i3);
        }
        if (QLog.isColorLevel()) {
            QLog.e(LogTag.TAG_READINJOY_VIDEO, 2, "setXYaxis value:" + i3);
        }
    }

    public void Z(int i3, boolean z16) {
        this.f239992l = z16;
        k62.b bVar = this.f239985e;
        if (bVar != null && this.f239983c != null) {
            a0(bVar.f411777i, i3);
        } else {
            VideoPlayerWrapper videoPlayerWrapper = this.f239983c;
            if (videoPlayerWrapper != null) {
                v(bVar, videoPlayerWrapper, 0, null);
                this.f239983c.t();
                this.f239983c = null;
                this.f239985e = null;
            } else if (bVar != null) {
                v(bVar, videoPlayerWrapper, 0, null);
                this.f239983c = null;
                this.f239985e = null;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.TAG_READINJOY_VIDEO, 2, "stop , from : " + i3);
        }
    }

    @Override // j62.b
    public void b(boolean z16) {
        Object obj;
        if (this.f239983c != null) {
            if (QLog.isColorLevel()) {
                String str = f239980w;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("setMuteForce: mute=");
                sb5.append(z16);
                sb5.append(", isAd=");
                k62.b bVar = this.f239985e;
                if (bVar != null) {
                    obj = Boolean.valueOf(bVar.f411790v);
                } else {
                    obj = "false";
                }
                sb5.append(obj);
                QLog.d(str, 2, sb5.toString());
            }
            this.f239983c.u0(z16);
            k62.b bVar2 = this.f239985e;
            if (bVar2 == null || !bVar2.f411790v) {
                return;
            }
            bVar2.f411792x = z16;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w() {
        if (QLog.isColorLevel()) {
            QLog.d(f239980w, 2, "checkPlayStateAfterPhoneCall isVisible() = " + M());
        }
        if (M()) {
            T();
        }
    }

    /* renamed from: com.tencent.mobileqq.kandian.glue.video.VideoPlayManager$2, reason: invalid class name */
    /* loaded from: classes33.dex */
    class AnonymousClass2 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ k62.b f240003d;
        final /* synthetic */ VideoPlayManager this$0;

        @Override // java.lang.Runnable
        public void run() {
            String str;
            String str2;
            if (this.f240003d == null) {
                return;
            }
            long longExtra = (this.this$0.f239984d == null || this.this$0.f239984d.getIntent() == null) ? 0L : this.this$0.f239984d.getIntent().getLongExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L);
            k62.b bVar = this.f240003d;
            b.a k3 = new b.a(null, bVar.f411786r, bVar.f411771c, bVar.f411784p).t(this.f240003d.f411779k * 1000).x(this.f240003d.f411785q.f428390d).h((int) this.f240003d.f411773e).f(this.f240003d.f411787s).s(this.f240003d.f411788t).u(null, this.f240003d.f411777i).w(null).k(VideoPlayManager.I(this.f240003d.f411786r));
            VideoPlayManager videoPlayManager = this.this$0;
            int i3 = videoPlayManager.f239991k;
            videoPlayManager.f239991k = i3 + 1;
            String b16 = k3.p(i3).v(this.this$0.f239998r).i(this.f240003d.f411779k * 1000).e(this.f240003d.f411785q.H).d(this.f240003d.f411785q.I).o(this.f240003d.f411785q.E).n(this.f240003d.f411785q.F).j(0).g().b();
            k62.b bVar2 = this.f240003d;
            String str3 = bVar2.f411786r;
            if (bVar2.f411777i == longExtra) {
                str = "1";
            } else {
                str = "2";
            }
            String str4 = str;
            if (!TextUtils.isEmpty(bVar2.f411784p)) {
                str2 = this.f240003d.f411784p;
            } else {
                str2 = "0";
            }
            PublicAccountReportUtils.r(null, str3, "0X8007408", "0X8007408", 0, 0, str4, "", str2, b16, false);
            this.f240003d.f411785q.f428390d = 0L;
        }
    }

    public void P() {
        Q(false);
    }

    public void T() {
        U(false);
    }

    public void Y(int i3) {
        Z(i3, false);
    }

    @Override // j62.a
    public void c(k62.a aVar) {
        if (aVar == null || !(aVar instanceof k62.b)) {
            return;
        }
        if (VideoVolumeControl.isInCall(this.f239984d)) {
            if (QLog.isColorLevel()) {
                QLog.d(LogTag.TAG_READINJOY_VIDEO, 2, "playVideo in call return");
                return;
            }
            return;
        }
        final k62.b bVar = (k62.b) aVar;
        try {
            this.f239988h = null;
            this.f239987g = null;
            VideoUIManager videoUIManager = this.f239995o;
            if (videoUIManager != null) {
                videoUIManager.Y(bVar);
            }
            if (!this.f239982b.j()) {
                if (QLog.isColorLevel()) {
                    QLog.d(LogTag.TAG_READINJOY_VIDEO, 2, "start install tencent sdk plugin");
                }
                this.f239985e = bVar;
                v(bVar, null, 4, null);
                this.f239982b.i();
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(f239980w, 2, "play video start ! playParams : " + bVar.toString());
            }
            this.f239989i = true;
            final VideoPlayerWrapper F = F(bVar);
            this.f239983c = F;
            this.f239985e = bVar;
            if (F == null) {
                return;
            }
            v(bVar, F, 1, null);
            bVar.f411774f.removeAllViews();
            this.f239983c.O(bVar.f411774f);
            o52.d L = this.f239983c.L();
            if (L != null && L.a() != null) {
                bVar.f411776h = L;
                L.a().setId(R.id.hym);
                bVar.f411774f.setKeepScreenOn(true);
                this.f239983c.A0(this.f239990j);
                this.f239985e.f411785q.f428400i = SystemClock.uptimeMillis();
                this.f239985e.f411785q.f428402j = SystemClock.uptimeMillis();
                q52.a aVar2 = this.f239985e.f411785q;
                aVar2.M = 0;
                aVar2.N = 0;
                aVar2.O = 0;
                aVar2.Y = false;
                aVar2.Z = false;
                ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.kandian.glue.video.VideoPlayManager.7
                    @Override // java.lang.Runnable
                    public void run() {
                        VideoPlayManager.this.z(F, bVar);
                    }
                });
                return;
            }
            QLog.e(f239980w, 1, "playVideo failed, because get videoView == null!");
            v(this.f239985e, null, 6, "videoview null");
            this.f239983c = null;
            this.f239985e = null;
        } catch (Exception e16) {
            e16.printStackTrace();
            QLog.e(LogTag.TAG_READINJOY_VIDEO, 1, "playVideo error:", e16);
        }
    }

    public void u(e eVar) {
        CopyOnWriteArrayList<e> copyOnWriteArrayList;
        if (eVar == null || (copyOnWriteArrayList = this.f239994n) == null || copyOnWriteArrayList.contains(eVar)) {
            return;
        }
        this.f239994n.add(eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(int i3, boolean z16) {
        if (i3 != 3 || this.f239996p) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f239980w, 2, "pause for not visible\uff0cisSubThread:" + z16);
        }
        P();
    }

    @Override // com.tencent.mobileqq.kandian.base.video.plugin.a
    public void a(boolean z16) {
        if (z16) {
            if (QLog.isColorLevel()) {
                QLog.d(f239980w, 2, "install tencent video sdk success!");
            }
            k62.b bVar = this.f239985e;
            if (bVar != null) {
                c(bVar);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f239980w, 2, "install tencent video sdk fail!");
        }
        v(this.f239985e, this.f239983c, 6, "install failure");
        this.f239985e = null;
    }

    public void a0(long j3, int i3) {
        k62.b bVar;
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.TAG_READINJOY_VIDEO, 2, "player stop [async]  stopID : " + j3 + ", from : " + i3);
        }
        if (this.f239983c != null && (bVar = this.f239985e) != null && bVar.f411777i == j3) {
            bVar.f411774f.setKeepScreenOn(false);
            v(this.f239985e, this.f239983c, 0, null);
            this.f239985e.f411785q.f428390d = this.f239983c.H(false);
            this.f239985e.f411778j = C();
            c cVar = c.f240045a;
            k62.b bVar2 = this.f239985e;
            cVar.a(bVar2.f411784p, bVar2.f411771c, bVar2.f411778j, this.f239983c.z());
            q52.a aVar = this.f239985e.f411785q;
            if (aVar.f428390d == 0 && aVar.f428404k == 0 && aVar.f428400i != 0) {
                aVar.f428404k = SystemClock.uptimeMillis() - this.f239985e.f411785q.f428400i;
            }
            q52.a aVar2 = this.f239985e.f411785q;
            aVar2.f428409n = ((float) aVar2.f428390d) / r0.f411779k;
            aVar2.f428394f = true;
            aVar2.f428416u = this.f239983c.E();
            this.f239985e.f411785q.f428417v = this.f239983c.D();
            this.f239985e.f411785q.f428418w = this.f239983c.I();
            q52.a aVar3 = this.f239985e.f411785q;
            VideoPlayerWrapper videoPlayerWrapper = this.f239983c;
            aVar3.f428419x = videoPlayerWrapper.A;
            aVar3.C = videoPlayerWrapper.f239162w;
            aVar3.B = videoPlayerWrapper.f239160u;
            aVar3.D = videoPlayerWrapper.y();
            q52.a aVar4 = this.f239985e.f411785q;
            if (aVar4.f428390d == 0 && aVar4.f428404k == 0) {
                long uptimeMillis = SystemClock.uptimeMillis();
                q52.a aVar5 = this.f239985e.f411785q;
                aVar4.f428404k = uptimeMillis - aVar5.f428400i;
                aVar5.f428408m = aVar5.f428404k;
            }
            this.f239985e.f411785q.H = G();
            this.f239985e.f411785q.I = E();
            k62.b bVar3 = this.f239986f;
            if (bVar3 != null) {
                k62.b bVar4 = this.f239985e;
                bVar4.f411785q.f428385a0 = com.tencent.mobileqq.kandian.biz.common.b.b(bVar3.f411772d, bVar4.f411772d, bVar4.f411794z == 3);
            } else {
                this.f239985e.f411785q.f428385a0 = -1;
            }
            k62.b bVar5 = this.f239985e;
            bVar5.f411785q.f428411p = bVar5.f411794z;
            this.f239983c.z();
            this.f239983c.F();
            this.f239983c.l(this.f239985e.f411785q.a());
            VideoPlayerWrapper videoPlayerWrapper2 = this.f239983c;
            videoPlayerWrapper2.t();
            x(this.f239985e);
            k62.b bVar6 = this.f239985e;
            if (bVar6.f411778j > 0 && bVar6.f411785q.f428390d > 0) {
                ThreadManagerV2.post(new Runnable(bVar6, null, videoPlayerWrapper2, this.f239992l, i3) { // from class: com.tencent.mobileqq.kandian.glue.video.VideoPlayManager.9

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ k62.b f240015d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ VideoPlayerWrapper f240016e;

                    /* renamed from: f, reason: collision with root package name */
                    final /* synthetic */ boolean f240017f;

                    /* renamed from: h, reason: collision with root package name */
                    final /* synthetic */ int f240018h;

                    {
                        this.f240016e = videoPlayerWrapper2;
                        this.f240017f = r5;
                        this.f240018h = i3;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        String str;
                        String str2;
                        if (this.f240015d == null) {
                            return;
                        }
                        Activity activity = VideoPlayManager.this.f239984d;
                        if (activity != null) {
                            activity.getIntent();
                        }
                        k62.b bVar7 = this.f240015d;
                        b.a k3 = new b.a(null, bVar7.f411786r, bVar7.f411771c, bVar7.f411784p).t(this.f240015d.f411779k * 1000).x(this.f240015d.f411785q.f428390d).h((int) this.f240015d.f411773e).f(this.f240015d.f411787s).s(this.f240015d.f411788t).u(null, this.f240015d.f411777i).w(null).k(VideoPlayManager.I(this.f240015d.f411786r));
                        VideoPlayManager videoPlayManager = VideoPlayManager.this;
                        int i16 = videoPlayManager.f239991k;
                        videoPlayManager.f239991k = i16 + 1;
                        String b16 = k3.p(i16).v(VideoPlayManager.this.f239998r).i(this.f240015d.f411778j).e(this.f240015d.f411785q.H).d(this.f240015d.f411785q.I).o(this.f240015d.f411785q.E).n(this.f240015d.f411785q.F).j(0).g().b();
                        long longExtra = (activity == null || activity.getIntent() == null) ? 0L : activity.getIntent().getLongExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L);
                        k62.b bVar8 = this.f240015d;
                        String str3 = bVar8.f411786r;
                        if (bVar8.f411777i == longExtra) {
                            str = "1";
                        } else {
                            str = "2";
                        }
                        String str4 = str;
                        if (!TextUtils.isEmpty(bVar8.f411784p)) {
                            str2 = this.f240015d.f411784p;
                        } else {
                            str2 = "0";
                        }
                        PublicAccountReportUtils.r(null, str3, "0X8007408", "0X8007408", 0, 0, str4, "", str2, b16, false);
                        PublicAccountReportUtils.p("0X8007408", this.f240015d.f411786r, "", "", "", b16);
                        VideoPlayManager.this.R(this.f240016e, this.f240015d);
                        k62.b bVar9 = this.f240015d;
                        bVar9.f411785q.f428390d = 0L;
                        VideoPlayManager.this.y(this.f240017f, activity, bVar9, this.f240018h);
                    }
                }, 5, null, true);
            }
            this.f239997q = false;
            this.f239986f = this.f239985e;
            this.f239985e = null;
            this.f239983c = null;
            return;
        }
        QLog.e(LogTag.TAG_READINJOY_VIDEO, 1, "stop : current player is null or articleID is not equal!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(k62.b bVar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(boolean z16, Activity activity, k62.b bVar, int i3) {
    }
}
