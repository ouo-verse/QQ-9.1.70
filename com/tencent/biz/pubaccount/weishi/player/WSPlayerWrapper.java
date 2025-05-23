package com.tencent.biz.pubaccount.weishi.player;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.avbiz.Constants;
import com.tencent.biz.pubaccount.weishi.player.wrapper.WSPlayerDownloadInfo;
import com.tencent.biz.pubaccount.weishi.player.wrapper.m;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.biz.richframework.video.RFWMediaFocusManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.util.VersionUtils;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes32.dex */
public class WSPlayerWrapper implements com.tencent.biz.pubaccount.weishi.player.wrapper.e {
    private c A;
    private Context B;
    private Object C;
    private RFWMediaFocusManager D;

    /* renamed from: c, reason: collision with root package name */
    private boolean f81065c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f81066d;

    /* renamed from: g, reason: collision with root package name */
    private int f81069g;

    /* renamed from: h, reason: collision with root package name */
    private int f81070h;

    /* renamed from: i, reason: collision with root package name */
    private long f81071i;

    /* renamed from: j, reason: collision with root package name */
    private long f81072j;

    /* renamed from: k, reason: collision with root package name */
    private long f81073k;

    /* renamed from: l, reason: collision with root package name */
    private long f81074l;

    /* renamed from: m, reason: collision with root package name */
    private long f81075m;

    /* renamed from: n, reason: collision with root package name */
    private long f81076n;

    /* renamed from: o, reason: collision with root package name */
    private long f81077o;

    /* renamed from: q, reason: collision with root package name */
    private long f81079q;

    /* renamed from: s, reason: collision with root package name */
    private long f81081s;

    /* renamed from: t, reason: collision with root package name */
    private String f81082t;

    /* renamed from: u, reason: collision with root package name */
    private String f81083u;

    /* renamed from: v, reason: collision with root package name */
    private com.tencent.biz.pubaccount.weishi.player.wrapper.b f81084v;

    /* renamed from: w, reason: collision with root package name */
    private com.tencent.biz.pubaccount.weishi.player.wrapper.d f81085w;

    /* renamed from: x, reason: collision with root package name */
    private com.tencent.biz.pubaccount.weishi.player.wrapper.h f81086x;

    /* renamed from: y, reason: collision with root package name */
    private volatile ArrayList<Integer> f81087y;

    /* renamed from: a, reason: collision with root package name */
    private AtomicInteger f81063a = new AtomicInteger(0);

    /* renamed from: b, reason: collision with root package name */
    private int f81064b = 0;

    /* renamed from: e, reason: collision with root package name */
    private boolean f81067e = false;

    /* renamed from: f, reason: collision with root package name */
    private boolean f81068f = false;

    /* renamed from: p, reason: collision with root package name */
    private long f81078p = -1;

    /* renamed from: r, reason: collision with root package name */
    private long f81080r = 0;

    /* renamed from: z, reason: collision with root package name */
    private final Object f81088z = new Object();

    public WSPlayerWrapper(Context context) {
        this.B = context;
        X();
    }

    private void W(final com.tencent.biz.pubaccount.weishi.player.wrapper.b bVar) {
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.player.WSPlayerWrapper.1
            @Override // java.lang.Runnable
            public void run() {
                Properties G;
                com.tencent.biz.pubaccount.weishi.player.wrapper.b bVar2 = bVar;
                String streamDumpInfo = bVar2 != null ? bVar2.getStreamDumpInfo() : null;
                if (TextUtils.isEmpty(streamDumpInfo) || (G = i.G(streamDumpInfo)) == null) {
                    return;
                }
                try {
                    WSPlayerWrapper.this.f81079q = Long.parseLong(G.getProperty("VideoBitRate"));
                } catch (NumberFormatException e16) {
                    x.f("WS_VIDEO_PLAYER", e16.getLocalizedMessage());
                }
                c cVar = WSPlayerWrapper.this.A;
                if (cVar != null) {
                    WSPlayerWrapper wSPlayerWrapper = WSPlayerWrapper.this;
                    cVar.a(wSPlayerWrapper, wSPlayerWrapper.f81079q);
                }
            }
        }, 5, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f0(int i3, int i16, int i17) {
        this.f81084v.e(i3, i16, i17);
        c cVar = this.A;
        if (cVar != null) {
            cVar.i(i3, i16, i17);
        }
    }

    private void k0() {
        RFWMediaFocusManager createMediaFocusManager = RFWMediaFocusManager.createMediaFocusManager(Constants.Business.QQ_WEISHI_VIDEO);
        this.D = createMediaFocusManager;
        createMediaFocusManager.requestMediaFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l0() {
        RFWMediaFocusManager rFWMediaFocusManager = this.D;
        if (rFWMediaFocusManager != null) {
            rFWMediaFocusManager.requestMediaUnFocus();
        }
    }

    private void q(int i3) {
        if (this.f81087y == null) {
            synchronized (this.f81088z) {
                if (this.f81087y == null) {
                    this.f81087y = new ArrayList<>();
                }
            }
        }
        ArrayList<Integer> arrayList = this.f81087y;
        if (arrayList == null || arrayList.size() > 20) {
            return;
        }
        arrayList.add(Integer.valueOf(i3));
    }

    private boolean s() {
        if (this.f81063a.compareAndSet(0, 1) || this.f81063a.compareAndSet(7, 1) || this.f81063a.compareAndSet(6, 1)) {
            return false;
        }
        x.j("WS_VIDEO_PLAYER", "[WSPlayerWrapper.java][checkPlayerStartState] not idle or complete state, should't reopen media player mState:" + i.s(this.f81063a.get()));
        return true;
    }

    private void t() {
        this.f81085w = m.d().b();
    }

    private com.tencent.biz.pubaccount.weishi.player.wrapper.a u(l lVar, int i3, boolean z16) {
        com.tencent.biz.pubaccount.weishi.player.wrapper.a b16 = this.f81085w.b();
        b16.a(lVar, i3, z16);
        return b16;
    }

    private com.tencent.biz.pubaccount.weishi.player.wrapper.h v() {
        if (this.f81085w == null) {
            X();
            if (this.f81085w == null) {
                return null;
            }
        }
        Context context = this.B;
        if (context == null) {
            x.f("WS_VIDEO_PLAYER", "[WSPlayerWrapper.java][createVideoViewScroll]: error, mContext null");
            return null;
        }
        return this.f81085w.d(context, VersionUtils.isIceScreamSandwich());
    }

    public void A0() {
        if (this.f81084v != null) {
            this.f81063a.set(3);
            this.f81084v.start();
            x.j("WS_VIDEO_PLAYER", "[WSPlayerWrapper.java][start]");
            k0();
        }
    }

    public int B() {
        return this.f81063a.get();
    }

    public void B0() {
        if (this.f81084v == null) {
            return;
        }
        if (this.f81063a.get() == 8) {
            x.j("WS_VIDEO_PLAYER", "[WSPlayerWrapper.java][stop] player had destroyed! return!");
            return;
        }
        this.f81063a.set(0);
        this.f81084v.stop();
        l0();
        x.j("WS_VIDEO_PLAYER", "[WSPlayerWrapper.java][stop]");
    }

    public int C() {
        com.tencent.biz.pubaccount.weishi.player.wrapper.b bVar = this.f81084v;
        if (bVar != null) {
            return bVar.d();
        }
        return -1;
    }

    public void C0() {
        com.tencent.biz.pubaccount.weishi.player.wrapper.b bVar = this.f81084v;
        if (bVar != null) {
            bVar.pauseDownload();
        }
    }

    public long D() {
        long j3 = this.f81071i;
        if (j3 > 0) {
            return j3;
        }
        com.tencent.biz.pubaccount.weishi.player.wrapper.b bVar = this.f81084v;
        if (bVar == null) {
            return -1L;
        }
        if (bVar.getDuration() > 0) {
            return this.f81084v.getDuration();
        }
        return this.f81072j;
    }

    public void D0(com.tencent.biz.pubaccount.weishi.player.wrapper.h hVar) {
        com.tencent.biz.pubaccount.weishi.player.wrapper.b bVar = this.f81084v;
        if (bVar == null) {
            return;
        }
        this.f81086x = hVar;
        bVar.a(hVar);
        this.f81084v.setXYAxis(this.f81064b);
    }

    public long E() {
        return this.f81081s;
    }

    public long F() {
        long j3;
        synchronized (this.f81088z) {
            j3 = -1;
            if (this.f81087y != null && this.f81087y.size() > 0) {
                int size = this.f81087y.size();
                int i3 = 0;
                while (i3 < size) {
                    int N = N(this.f81087y, i3);
                    j3 = i3 == 0 ? N : Math.max(N, j3);
                    i3++;
                }
            }
        }
        return j3;
    }

    public com.tencent.biz.pubaccount.weishi.player.wrapper.b G() {
        return this.f81084v;
    }

    public long H() {
        long j3;
        synchronized (this.f81088z) {
            j3 = -1;
            if (this.f81087y != null && this.f81087y.size() > 0) {
                int size = this.f81087y.size();
                int i3 = 0;
                while (i3 < size) {
                    int N = N(this.f81087y, i3);
                    j3 = i3 == 0 ? N : Math.min(N, j3);
                    i3++;
                }
            }
        }
        return j3;
    }

    public com.tencent.biz.pubaccount.weishi.player.wrapper.l I() {
        return this.f81084v.g();
    }

    public long J() {
        return this.f81074l + Q(Y());
    }

    public int K() {
        return this.f81070h;
    }

    public long L() {
        return this.f81077o;
    }

    public int M() {
        return this.f81069g;
    }

    public String O() {
        synchronized (this.f81088z) {
            if (this.f81087y != null && this.f81087y.size() > 0) {
                StringBuilder sb5 = new StringBuilder();
                int min = Math.min(20, this.f81087y.size());
                for (int i3 = 0; i3 < min; i3++) {
                    sb5.append(N(this.f81087y, i3));
                    if (i3 != min - 1) {
                        sb5.append(",");
                    }
                }
                return sb5.toString();
            }
            return "";
        }
    }

    public Object P() {
        return this.C;
    }

    public long Q(boolean z16) {
        long z17;
        long j3 = this.f81073k;
        if (z16) {
            z17 = D();
        } else {
            z17 = z();
        }
        long j16 = this.f81075m;
        if (z17 - j16 > 0) {
            j3 += z17 - j16;
        }
        x.m("WS_VIDEO_PLAY_TIME", "[WSPlayerWrapper.java][getTotalPlayTime] result:" + j3);
        return j3;
    }

    public long R() {
        return this.f81079q;
    }

    public String S() {
        return this.f81083u;
    }

    public int T() {
        com.tencent.biz.pubaccount.weishi.player.wrapper.b bVar = this.f81084v;
        if (bVar != null) {
            return bVar.getVideoHeight();
        }
        return -1;
    }

    public com.tencent.biz.pubaccount.weishi.player.wrapper.h U() {
        View a16;
        if (this.f81086x == null) {
            synchronized (this) {
                if (this.f81086x == null) {
                    this.f81086x = v();
                }
            }
        }
        com.tencent.biz.pubaccount.weishi.player.wrapper.h hVar = this.f81086x;
        if (hVar != null && (a16 = hVar.a()) != null) {
            j0(a16);
        }
        return this.f81086x;
    }

    public int V() {
        com.tencent.biz.pubaccount.weishi.player.wrapper.b bVar = this.f81084v;
        if (bVar != null) {
            return bVar.getVideoWidth();
        }
        return -1;
    }

    public void X() {
        t();
        if (this.f81085w == null || this.B == null) {
            return;
        }
        x.j("WS_VIDEO_PLAYER", "[WSPlayerWrapper.java][initMediaPlayer] success!");
        com.tencent.biz.pubaccount.weishi.player.wrapper.b c16 = this.f81085w.c(this.B, null);
        this.f81084v = c16;
        c16.setOutputMute(false);
        this.f81084v.f(this);
    }

    public boolean Y() {
        return this.f81063a.get() == 7;
    }

    public boolean Z() {
        return this.f81063a.get() == 0;
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.wrapper.e
    public void a(com.tencent.biz.pubaccount.weishi.player.wrapper.b bVar) {
        this.f81063a.set(7);
        c cVar = this.A;
        if (cVar != null) {
            cVar.c(this);
        }
    }

    public boolean a0() {
        com.tencent.biz.pubaccount.weishi.player.wrapper.b bVar = this.f81084v;
        if (bVar != null) {
            return bVar.isPausing();
        }
        return false;
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.wrapper.e
    public void b(com.tencent.biz.pubaccount.weishi.player.wrapper.b bVar, int i3, int i16, int i17, Bitmap bitmap) {
        c cVar = this.A;
        if (cVar != null) {
            cVar.b(this, true, 0, i3, bitmap);
        }
    }

    public boolean b0() {
        com.tencent.biz.pubaccount.weishi.player.wrapper.b bVar = this.f81084v;
        if (bVar != null) {
            return bVar.isPlaying();
        }
        return false;
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.wrapper.e
    public void c(com.tencent.biz.pubaccount.weishi.player.wrapper.b bVar) {
        x.j("WS_VIDEO_PLAYER", "[WSPlayerWrapper.java][onVideoPrepared] streamDumpInfo:" + bVar.getStreamDumpInfo());
        this.f81063a.set(2);
        c cVar = this.A;
        if (cVar != null) {
            cVar.j(this, this.C);
        }
        com.tencent.biz.pubaccount.weishi.player.wrapper.b bVar2 = this.f81084v;
        if (bVar2 != null) {
            this.f81071i = bVar2.getDuration();
        }
        W(bVar);
    }

    public boolean c0() {
        return this.f81068f;
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.wrapper.e
    public void d(com.tencent.biz.pubaccount.weishi.player.wrapper.b bVar, int i3, int i16) {
        c cVar = this.A;
        if (cVar != null) {
            cVar.b(this, false, i16, i3, null);
        }
    }

    public boolean d0() {
        return this.f81063a.get() == 2;
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.wrapper.e
    public void e(com.tencent.biz.pubaccount.weishi.player.wrapper.b bVar, WSPlayerDownloadInfo wSPlayerDownloadInfo) {
        this.f81081s = wSPlayerDownloadInfo.getTotalSizeBytes();
        q(wSPlayerDownloadInfo.getDownloadSpeedKBps());
        this.f81068f = wSPlayerDownloadInfo.getHitDownloaded() == 1;
        c cVar = this.A;
        if (cVar != null) {
            cVar.d(this, wSPlayerDownloadInfo);
        }
    }

    public boolean e0() {
        return this.f81065c;
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.wrapper.e
    public boolean f(com.tencent.biz.pubaccount.weishi.player.wrapper.b bVar, int i3, int i16, int i17, String str) {
        x.f("WS_VIDEO_PLAYER", "[WSPlayerWrapper.java][onError]!!");
        this.f81063a.set(6);
        c cVar = this.A;
        if (cVar == null) {
            return false;
        }
        cVar.e(this, i16, i17, i3, str, null);
        return false;
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.wrapper.e
    public void g(com.tencent.biz.pubaccount.weishi.player.wrapper.b bVar) {
        x.j("WS_VIDEO_PLAYER", "[WSPlayerWrapper.java][onSeekComplete] isPause:" + a0());
        c cVar = this.A;
        if (cVar != null) {
            cVar.h(this);
        }
        this.f81065c = false;
    }

    public void g0() {
        if (this.f81084v != null) {
            this.f81063a.set(5);
            this.f81084v.pause();
            l0();
        }
    }

    public boolean h0(l lVar, int i3, long j3, boolean z16) {
        com.tencent.biz.pubaccount.weishi.player.wrapper.b bVar;
        x.j("WS_VIDEO_PLAYER", "[WSPlayerWrapper.java][innerPlayerStartByUrl] url:" + lVar.f81171f + ", fileSize:" + lVar.f81170e + ", videoDuration:" + lVar.f81169d + ", mState:" + i.s(this.f81063a.get()));
        if (s()) {
            x.f("WS_VIDEO_PLAYER", "[WSPlayerWrapper.java][innerPlayerStartByUrl] checkPlayerStartState return true.");
            return false;
        }
        com.tencent.biz.pubaccount.weishi.player.wrapper.a u16 = u(lVar, i3, z16);
        Context context = this.B;
        if (context != null && (bVar = this.f81084v) != null) {
            try {
                bVar.c(context, j3, 0, u16);
            } catch (Exception e16) {
                x.f("WS_VIDEO_PLAYER", "[WSPlayerWrapper.java][innerPlayerStartByUrl] openMediaPlayerByUrl error:" + e16.getMessage());
            }
        }
        this.f81082t = lVar.f81171f;
        this.f81072j = u16.f81195d;
        this.f81073k = 0L;
        this.f81071i = 0L;
        this.f81074l = 0L;
        this.f81075m = j3;
        return true;
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.wrapper.e
    public void i(com.tencent.biz.pubaccount.weishi.player.wrapper.b bVar, WSPlayerDownloadInfo wSPlayerDownloadInfo) {
        c cVar = this.A;
        if (cVar != null) {
            cVar.g(this, wSPlayerDownloadInfo);
        }
    }

    public void i0() {
        this.f81074l += Q(Y());
        this.f81075m = z();
        this.f81073k = 0L;
    }

    public void o0() {
        com.tencent.biz.pubaccount.weishi.player.wrapper.b bVar = this.f81084v;
        if (bVar != null) {
            bVar.resumeDownload();
        }
    }

    public void p0(com.tencent.biz.pubaccount.weishi.player.wrapper.h hVar, ViewGroup viewGroup) {
        com.tencent.biz.pubaccount.weishi.player.wrapper.b bVar = this.f81084v;
        if (bVar == null || viewGroup == null) {
            return;
        }
        bVar.b(hVar, viewGroup);
    }

    public void q0(int i3) {
        if (this.f81084v == null || this.f81063a.get() == 0 || this.f81063a.get() == 2 || this.f81063a.get() == 1 || this.f81063a.get() == 4 || this.f81063a.get() == 8) {
            return;
        }
        long z16 = z();
        long j3 = this.f81075m;
        if (z16 - j3 > 0) {
            this.f81073k += z16 - j3;
        }
        this.f81075m = i3;
        this.f81084v.seekTo(i3);
        this.f81065c = true;
        x.m("WS_VIDEO_PLAY_TIME", "[WSPlayerWrapper.java][seekTo] mTotalPlayTime:" + this.f81073k + ", mLastPlayPosition:" + this.f81075m);
    }

    public void r() {
        long D = D();
        long j3 = this.f81075m;
        this.f81073k += D - j3 > 0 ? D - j3 : 0L;
        x.m("WS_VIDEO_PLAY_TIME", "[WSPlayerWrapper.java][addTotalPlayTimeForLoop] mTotalPlayTime:" + this.f81073k);
    }

    public void r0(boolean z16) {
        this.f81066d = z16;
    }

    public void s0(boolean z16) {
        this.f81068f = z16;
    }

    public void t0(boolean z16) {
        this.f81067e = z16;
    }

    public void u0(final boolean z16) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.player.WSPlayerWrapper.3
                @Override // java.lang.Runnable
                public void run() {
                    if (WSPlayerWrapper.this.f81084v == null || WSPlayerWrapper.this.f81063a.get() == 6 || WSPlayerWrapper.this.f81063a.get() == 8) {
                        return;
                    }
                    WSPlayerWrapper.this.f81084v.setLoopback(z16);
                }
            }, 16, null, false);
        } else {
            if (this.f81084v == null || this.f81063a.get() == 6 || this.f81063a.get() == 8) {
                return;
            }
            this.f81084v.setLoopback(z16);
        }
    }

    public void v0(float f16) {
        com.tencent.biz.pubaccount.weishi.player.wrapper.b bVar = this.f81084v;
        if (bVar != null) {
            bVar.setPlaySpeedRatio(f16);
        }
    }

    public void w0(c cVar) {
        this.A = cVar;
    }

    public void x(boolean z16) {
        com.tencent.biz.pubaccount.weishi.player.wrapper.h hVar;
        View a16;
        this.f81063a.set(8);
        final com.tencent.biz.pubaccount.weishi.player.wrapper.b bVar = this.f81084v;
        if (bVar != null) {
            ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.player.WSPlayerWrapper.2
                @Override // java.lang.Runnable
                public void run() {
                    bVar.stop();
                    bVar.release();
                    WSPlayerWrapper.this.l0();
                }
            });
        }
        if (z16 && (hVar = this.f81086x) != null && (a16 = hVar.a()) != null && a16.getParent() != null) {
            ViewParent parent = a16.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(a16);
            }
        }
        this.A = null;
        this.f81086x = null;
        this.B = null;
        synchronized (this.f81088z) {
            this.f81087y = null;
        }
        this.f81078p = 0L;
        this.f81080r = 0L;
        x.j("WS_VIDEO_PLAYER", "[WSPlayerWrapper.java][destroy]");
    }

    public void x0(Object obj) {
        this.C = obj;
    }

    public long y() {
        if (this.f81078p == -1) {
            synchronized (this.f81088z) {
                if (this.f81087y != null && this.f81087y.size() > 0) {
                    int min = Math.min(10, this.f81087y.size());
                    int i3 = 0;
                    for (int i16 = 0; i16 < min; i16++) {
                        i3 += this.f81087y.get(i16).intValue();
                    }
                    if (min != 0) {
                        this.f81078p = i3 / min;
                    }
                }
            }
        }
        return this.f81078p;
    }

    public void y0(int i3) {
        this.f81064b = i3;
        com.tencent.biz.pubaccount.weishi.player.wrapper.b bVar = this.f81084v;
        if (bVar != null) {
            bVar.setXYAxis(i3);
        }
        x.j("WS_VIDEO_PLAYER", "[WSPlayerWrapper.java][setXYAxis] value:" + i3);
    }

    public long z() {
        com.tencent.biz.pubaccount.weishi.player.wrapper.b bVar = this.f81084v;
        if (bVar == null) {
            return 0L;
        }
        return bVar.getCurrentPosition();
    }

    public void z0(final int i3, final int i16, final int i17) {
        if (this.f81084v == null || i3 <= 0 || i16 <= 0) {
            return;
        }
        i.I(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.player.j
            @Override // java.lang.Runnable
            public final void run() {
                WSPlayerWrapper.this.f0(i3, i16, i17);
            }
        });
    }

    public void n0() {
        this.f81065c = false;
        this.f81071i = 0L;
        this.f81072j = 0L;
        this.f81073k = 0L;
        this.f81075m = 0L;
        this.f81074l = 0L;
        this.f81076n = 0L;
        this.f81077o = 0L;
        this.f81070h = 0;
        this.f81079q = 0L;
        this.f81081s = 0L;
        this.f81078p = -1L;
        this.f81080r = 0L;
        this.f81082t = "";
        this.f81083u = "";
        synchronized (this.f81088z) {
            this.f81087y = null;
        }
    }

    public void w() {
        x(true);
    }

    public long A(boolean z16) {
        if (z16) {
            return D();
        }
        return z();
    }

    public void j0(View view) {
        if (view == null || view.getParent() == null) {
            return;
        }
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(view);
        }
        x.j("WS_VIDEO_PLAYER", "[WSPlayerWrapper.java][removeVideoViewFromParent] remove scroll view parents!");
    }

    public void m0() {
        this.f81075m = 0L;
    }

    private int N(ArrayList<Integer> arrayList, int i3) {
        if (arrayList == null) {
            return 0;
        }
        try {
            return arrayList.get(i3).intValue();
        } catch (Exception e16) {
            x.j("WS_VIDEO_PLAYER", "[WSPlayerWrapper.java][getSpeedFromListCache] e:" + e16.getMessage());
            return 0;
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.wrapper.e
    public boolean h(com.tencent.biz.pubaccount.weishi.player.wrapper.b bVar, int i3, Object obj) {
        int i16;
        if (i3 != 40) {
            if (i3 == 112) {
                x.m("WS_VIDEO_PLAYER", "[WSPlayerWrapper.java][onInfo] start buffering ===> isSeeking:" + this.f81065c);
                if (this.f81063a.get() != 5) {
                    this.f81063a.set(4);
                }
                this.f81076n = System.currentTimeMillis();
            } else if (i3 == 113) {
                x.m("WS_VIDEO_PLAYER", "[WSPlayerWrapper.java][onInfo] end buffering <=== isSeeking:" + this.f81065c);
                if (this.f81063a.get() != 5) {
                    this.f81063a.set(3);
                }
                if (!this.f81065c) {
                    this.f81070h++;
                    this.f81077o += System.currentTimeMillis() - this.f81076n;
                }
            }
        } else if (obj instanceof String) {
            try {
                i16 = new JSONObject((String) obj).optInt("skipFrameCount", 1);
            } catch (JSONException e16) {
                e16.printStackTrace();
                i16 = 0;
            }
            if (i16 > 0) {
                this.f81069g += i16;
            }
        }
        c cVar = this.A;
        if (cVar != null) {
            cVar.f(this, i3, obj);
        }
        return false;
    }
}
