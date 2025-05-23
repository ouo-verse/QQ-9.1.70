package com.tencent.mobileqq.kandian.base.video.player;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.kandian.base.utils.g;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.SuperPlayerDownOption;
import com.tencent.superplayer.api.SuperPlayerOption;
import com.tencent.superplayer.seamless.SPSeamlessHelper;
import com.tencent.superplayer.view.ISPlayerVideoView;
import com.tencent.thumbplayer.api.TPPlayerMsg;
import com.tencent.thumbplayer.api.common.TPMediaCodecReadyInfo;
import com.tencent.util.VersionUtils;
import java.net.URL;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;
import p52.a;
import p52.c;
import t52.PlayerVideoInfo;

/* loaded from: classes33.dex */
public class VideoPlayerWrapper implements o52.a, o52.c {
    private static int Z = 6;

    /* renamed from: a0, reason: collision with root package name */
    private static boolean f239139a0 = true;
    public boolean A;
    private boolean B;
    private boolean C;
    private boolean D;
    private boolean E;
    private boolean F;
    public String G;
    public int H;
    private p52.a I;
    private boolean J;
    private String K;
    private boolean L;
    private p52.c M;
    public long N;
    public long O;
    public long P;
    public long Q;
    public long R;
    public long S;
    public long T;
    public int U;
    public int V;
    public int W;
    public int X;
    public Set<Integer> Y;

    /* renamed from: a, reason: collision with root package name */
    private final String f239140a;

    /* renamed from: b, reason: collision with root package name */
    private int f239141b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f239142c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f239143d;

    /* renamed from: e, reason: collision with root package name */
    protected Context f239144e;

    /* renamed from: f, reason: collision with root package name */
    private o52.b f239145f;

    /* renamed from: g, reason: collision with root package name */
    private t52.a f239146g;

    /* renamed from: h, reason: collision with root package name */
    private o52.d f239147h;

    /* renamed from: i, reason: collision with root package name */
    private ViewGroup f239148i;

    /* renamed from: j, reason: collision with root package name */
    private AtomicInteger f239149j;

    /* renamed from: k, reason: collision with root package name */
    private o52.e f239150k;

    /* renamed from: l, reason: collision with root package name */
    private Object f239151l;

    /* renamed from: m, reason: collision with root package name */
    private int f239152m;

    /* renamed from: n, reason: collision with root package name */
    private long f239153n;

    /* renamed from: o, reason: collision with root package name */
    private long f239154o;

    /* renamed from: p, reason: collision with root package name */
    private long f239155p;

    /* renamed from: q, reason: collision with root package name */
    private long f239156q;

    /* renamed from: r, reason: collision with root package name */
    private long f239157r;

    /* renamed from: s, reason: collision with root package name */
    private long f239158s;

    /* renamed from: t, reason: collision with root package name */
    private int f239159t;

    /* renamed from: u, reason: collision with root package name */
    public long f239160u;

    /* renamed from: v, reason: collision with root package name */
    public int f239161v;

    /* renamed from: w, reason: collision with root package name */
    public long f239162w;

    /* renamed from: x, reason: collision with root package name */
    private final Object f239163x;

    /* renamed from: y, reason: collision with root package name */
    public long f239164y;

    /* renamed from: z, reason: collision with root package name */
    private int f239165z;

    public VideoPlayerWrapper(Context context) {
        this(context, "");
    }

    private String C(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new URL(str).getHost();
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    private boolean F0() {
        o52.b bVar = this.f239145f;
        if (bVar == null) {
            return false;
        }
        if (bVar.e()) {
            this.f239149j.set(1);
        } else if (this.f239145f.isPrepared()) {
            this.f239149j.set(2);
        } else if (this.f239145f.isBuffering()) {
            this.f239149j.set(4);
        } else if (this.f239145f.isPlaying()) {
            this.f239149j.set(3);
        } else if (this.f239145f.a()) {
            this.f239149j.set(5);
        } else {
            this.f239149j.set(6);
            if (QLog.isColorLevel()) {
                QLog.d(this.f239140a, 2, "seamlessAttachVideoView: error state");
            }
            return false;
        }
        return true;
    }

    private void N(String str) {
        this.f239146g = t52.e.INSTANCE.b();
        if (this.f239144e != null) {
            if (QLog.isColorLevel()) {
                QLog.d(this.f239140a, 2, "VideoPlayerWrapper initPlayer success!");
            }
            boolean z16 = !TextUtils.isEmpty(str);
            if (z16) {
                boolean m3 = m(str);
                this.F = m3;
                if (!m3) {
                    QLog.e(this.f239140a, 2, "SeamlessPlay error for that token(" + str + ") is not validate.");
                }
            }
            if (!this.F) {
                this.D = f239139a0;
                this.f239145f = this.f239146g.b(null);
            }
            this.f239145f.c(this);
            u0(this.D);
            t0(this.E);
            if (QLog.isColorLevel()) {
                QLog.d(this.f239140a, 2, "new VideoPlayerWrapper, needSeamlessPlay:" + z16 + " ,mIsSeamlessPlay:" + this.F);
            }
        }
    }

    private o52.d Q() {
        Context context = this.f239144e;
        if (context == null) {
            QLog.d(this.f239140a, 2, "createVideoView_Scroll: error, mContext null");
            return null;
        }
        return this.f239146g.a(context, VersionUtils.isIceScreamSandwich());
    }

    private void R(String str, String str2, int i3, long j3, long j16, int i16, boolean z16, boolean z17, boolean z18, String str3) {
        String[] strArr;
        if (QLog.isColorLevel()) {
            QLog.d(this.f239140a, 2, "#VideoPlayerWrapper# playerStartByUrl, url:" + str2 + ", fileSize:" + j16 + ", videoDuration:" + i16 + "\uff0cmState:" + com.tencent.mobileqq.kandian.base.video.a.c(this.f239149j.get()));
        }
        if (!p()) {
            QLog.e(this.f239140a, 1, "not idle or complete state, should't reopen mediaplayer, vid:" + str + "\uff0cmState:" + com.tencent.mobileqq.kandian.base.video.a.c(this.f239149j.get()) + " ,mIsSeamlessPlay:" + this.F);
            return;
        }
        j0();
        if (z17) {
            strArr = r52.b.a().e(str2);
            v0(strArr);
        } else {
            strArr = new String[]{str2};
            v0(strArr);
        }
        PlayerVideoInfo playerVideoInfo = new PlayerVideoInfo(i3, str, strArr);
        playerVideoInfo.l(z18);
        playerVideoInfo.g(i16 * 1000);
        playerVideoInfo.i(z16);
        playerVideoInfo.h(str3);
        q(playerVideoInfo);
        if (this.f239144e != null && this.f239145f != null) {
            SuperPlayerOption r16 = r(z18);
            SuperPlayerDownOption superPlayerDownOption = r16.superPlayerDownOption;
            c.Companion companion = p52.c.INSTANCE;
            superPlayerDownOption.quicEnableMode = companion.b(this.f239144e, str2);
            r16.superPlayerDownOption.enableQuicPlaintext = companion.e();
            r16.superPlayerDownOption.enableQuicConnectionMigration = companion.a();
            r16.superPlayerDownOption.quicCongestionType = companion.f();
            r16.superPlayerDownOption.bandwidthReportHost = C(str2);
            this.M.a(r16.superPlayerDownOption.quicEnableMode > 0);
            this.f239145f.f(this.f239144e, playerVideoInfo, j3, r16);
        }
        this.f239155p = 0L;
        this.f239154o = 0L;
        this.f239153n = 0L;
        this.f239156q = j3;
        this.f239141b = i3;
    }

    static /* bridge */ /* synthetic */ a.b i(VideoPlayerWrapper videoPlayerWrapper) {
        videoPlayerWrapper.getClass();
        return null;
    }

    private int m0(ViewGroup viewGroup) {
        o52.d dVar = this.f239147h;
        if (dVar == null || !(dVar.a() instanceof ISPlayerVideoView)) {
            return 0;
        }
        if (QLog.isColorLevel()) {
            QLog.d(this.f239140a, 2, "seamlessAttachVideoView: ");
        }
        SPSeamlessHelper.get().attachVideoView(viewGroup, (ISPlayerVideoView) this.f239147h.a(), new ViewGroup.LayoutParams(-1, -1));
        if (!this.F) {
            return 1;
        }
        if (!F0()) {
            return 2;
        }
        c0();
        return 0;
    }

    private boolean p() {
        if (this.F) {
            return false;
        }
        if (t52.e.INSTANCE.a()) {
            return this.f239149j.compareAndSet(0, 1);
        }
        return this.f239149j.compareAndSet(0, 1) || this.f239149j.compareAndSet(7, 1) || this.f239149j.compareAndSet(6, 1);
    }

    public boolean A() {
        return this.F;
    }

    public void A0(int i3) {
        this.f239152m = i3;
        o52.b bVar = this.f239145f;
        if (bVar != null) {
            bVar.setXYaxis(i3);
        }
        if (QLog.isColorLevel()) {
            QLog.i(this.f239140a, 2, "VideoPlayerWrapper: setXYaxis value:" + i3);
        }
    }

    public Properties B() {
        return new Properties();
    }

    public void B0() {
        if (this.f239145f == null) {
            return;
        }
        if (!o()) {
            QLog.e(this.f239140a, 1, "VideoPlayerWrapper: start failed, wrong state:" + com.tencent.mobileqq.kandian.base.video.a.c(this.f239149j.get()) + ", just return;");
            return;
        }
        this.f239149j.set(3);
        this.f239145f.start();
        if (QLog.isColorLevel()) {
            QLog.d(this.f239140a, 2, "VideoPlayerWrapper: start");
        }
    }

    public void C0() {
        o52.d dVar = this.f239147h;
        if (dVar != null) {
            dVar.b();
        }
    }

    public int D() {
        return this.f239159t;
    }

    public void D0() {
        if (this.f239145f == null) {
            return;
        }
        if (this.f239149j.get() == 8) {
            QLog.e(this.f239140a, 1, "VideoPlayerWrapper: stop failed, because has destoryed, just return;");
            return;
        }
        this.f239149j.set(0);
        this.f239145f.stop();
        j0();
        if (QLog.isColorLevel()) {
            QLog.d(this.f239140a, 2, "VideoPlayerWrapper: stop ");
        }
    }

    public long E() {
        return this.f239158s;
    }

    public void E0() {
        o52.b bVar = this.f239145f;
        if (bVar != null) {
            bVar.pauseDownload();
        }
    }

    public String F() {
        return this.K;
    }

    public Object G() {
        return this.f239151l;
    }

    public long H(boolean z16) {
        long w3;
        long j3 = this.f239154o;
        if (z16) {
            w3 = z();
        } else {
            w3 = w();
        }
        long j16 = this.f239156q;
        return w3 - j16 > 0 ? j3 + (w3 - j16) : j3;
    }

    public int I() {
        int i3 = this.f239141b;
        return (i3 == 104 || i3 == 102) ? 1 : 0;
    }

    public int J() {
        o52.b bVar = this.f239145f;
        if (bVar != null) {
            return bVar.getVideoHeight();
        }
        return -1;
    }

    public View K() {
        o52.d dVar = this.f239147h;
        if (dVar != null) {
            return dVar.a();
        }
        return null;
    }

    public o52.d L() {
        return this.f239147h;
    }

    public int M() {
        o52.b bVar = this.f239145f;
        if (bVar != null) {
            return bVar.getVideoWidth();
        }
        return -1;
    }

    public void P(ViewGroup viewGroup, boolean z16, boolean z17) {
        o52.d dVar;
        if (QLog.isColorLevel()) {
            QLog.d(this.f239140a, 2, "initVideoView parent:" + viewGroup + " ,reUseVideoView:" + z16 + " ,autoAttachVideoView:" + z17);
        }
        this.f239148i = viewGroup;
        o52.b bVar = this.f239145f;
        o52.d videoView = bVar != null ? bVar.getVideoView() : null;
        boolean z18 = z16 && this.F && videoView != null;
        if (z18) {
            this.f239147h = videoView;
        } else {
            s();
        }
        if (viewGroup == null || (dVar = this.f239147h) == null || dVar.a() == null) {
            return;
        }
        if (!z18) {
            viewGroup.addView(this.f239147h.a(), new ViewGroup.LayoutParams(-1, -1));
        } else if (z17) {
            m0(viewGroup);
        }
        n(this.f239147h);
    }

    public boolean S() {
        return this.f239149j.get() == 4;
    }

    public boolean T() {
        return this.f239149j.get() == 8;
    }

    public boolean U() {
        return this.f239149j.get() == 0;
    }

    public boolean V() {
        return this.E;
    }

    public boolean W() {
        o52.b bVar = this.f239145f;
        if (bVar != null) {
            return bVar.getOutputMute();
        }
        return this.D;
    }

    public boolean X() {
        return this.f239149j.get() == 5;
    }

    public boolean Y() {
        return this.f239149j.get() == 3 || this.f239149j.get() == 4;
    }

    public boolean Z() {
        return this.f239149j.get() == 1;
    }

    @Override // o52.a
    public void a(o52.b bVar) {
        if (QLog.isColorLevel()) {
            QLog.d(this.f239140a, 2, "onCompletion: ");
        }
        this.f239149j.set(7);
        o52.e eVar = this.f239150k;
        if (eVar != null) {
            eVar.c(this);
        }
    }

    public boolean a0() {
        return this.f239149j.get() == 2;
    }

    @Override // o52.a
    public void b(o52.b bVar, int i3, int i16, int i17, Bitmap bitmap) {
        o52.e eVar = this.f239150k;
        if (eVar != null) {
            eVar.f(this, true, 0, i3, bitmap);
        }
    }

    public boolean b0() {
        int i3 = this.f239149j.get();
        return t52.e.INSTANCE.a() ? i3 == 0 : i3 == 7 || i3 == 0 || i3 == 6;
    }

    @Override // o52.a
    public void c(final o52.b bVar) {
        if (QLog.isColorLevel()) {
            QLog.d(this.f239140a, 2, "[IPlayer] onVideoPrepared(): stremDumpInfo=" + bVar.getStreamDumpInfo());
        }
        this.f239149j.set(2);
        o52.e eVar = this.f239150k;
        if (eVar != null) {
            eVar.d(this, this.f239151l);
        }
        o52.b bVar2 = this.f239145f;
        if (bVar2 != null) {
            this.f239153n = bVar2.getDurationMs();
        }
        long j3 = this.f239162w;
        if (j3 > 0) {
            long j16 = this.f239153n;
            if (j16 > 0) {
                this.f239161v = (int) (((((float) j3) / 1024.0f) * 8.0f) / (((float) j16) / 1000.0f));
            }
        }
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.kandian.base.video.player.VideoPlayerWrapper.1
            @Override // java.lang.Runnable
            public void run() {
                String streamDumpInfo = bVar.getStreamDumpInfo();
                if (TextUtils.isEmpty(streamDumpInfo)) {
                    return;
                }
                Properties a16 = com.tencent.mobileqq.kandian.base.utils.d.a(streamDumpInfo);
                String property = a16 != null ? a16.getProperty("VideoBitRate") : null;
                if (TextUtils.isEmpty(property)) {
                    return;
                }
                VideoPlayerWrapper.this.f239160u = Long.parseLong(property);
            }
        }, 5, null, false);
    }

    public void c0() {
        this.f239150k.h(this);
    }

    @Override // o52.a
    public void d(long j3, long j16, String str) {
        if (QLog.isColorLevel()) {
            QLog.d(this.f239140a, 2, "[IPlayer] onDownloadCallback downloadedSizeBytes: " + j3 + ", totalSizeBytes=" + j16);
        }
        if (this.f239162w != j16) {
            h0();
        }
        this.f239162w = j16;
        this.f239164y = Math.max(this.f239164y, j3);
        if (this.f239161v <= 0) {
            long j17 = this.f239162w;
            if (j17 > 0) {
                long j18 = this.f239153n;
                if (j18 > 0) {
                    this.f239161v = (int) (((((float) j17) / 1024.0f) * 8.0f) / (((float) j18) / 1000.0f));
                }
            }
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.N = Math.max(jSONObject.optLong("HttpDownloadSize"), this.N);
            this.O = Math.max(jSONObject.optLong("HttpRepeatedSize"), this.O);
            this.P = Math.max(jSONObject.optLong("PcdnDownloadSize"), this.P);
            this.Q = Math.max(jSONObject.optLong("PcdnRepeatedSize"), this.Q);
            this.R = Math.max(jSONObject.optLong("P2PDownloadSize"), this.R);
            this.S = Math.max(jSONObject.optLong("P2PRepeatedSize"), this.S);
            this.T = Math.max(jSONObject.optLong("pcdnRequestSize"), this.T);
            this.U = Math.max(jSONObject.optInt("pcdnRequestCount"), this.U);
            this.V = Math.max(jSONObject.optInt("pcdnDownloadFailCount"), this.V);
            this.W = Math.max(jSONObject.optInt("pcdnDownloadSuccessCount"), this.W);
            boolean z16 = true;
            if (jSONObject.optInt("hitDownloaded") != 1) {
                z16 = false;
            }
            this.A = z16;
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    public void d0() {
        if (this.f239145f != null) {
            if (!o()) {
                QLog.e(this.f239140a, 1, "VideoPlayerWrapper: pause failed, wrong state:" + com.tencent.mobileqq.kandian.base.video.a.c(this.f239149j.get()) + ", just return;");
                return;
            }
            this.f239149j.set(5);
            this.f239145f.pause();
        }
    }

    @Override // o52.a
    public void f(o52.b bVar) {
        if (QLog.isColorLevel()) {
            QLog.d(this.f239140a, 2, "VideoPlayerWrapper: onSeekComplete\uff0c isPause=" + X());
        }
        o52.e eVar = this.f239150k;
        if (eVar != null) {
            eVar.g(this);
        }
        this.f239143d = false;
    }

    public void f0(String str, int i3, long j3, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d(this.f239140a, 2, "#VideoPlayerWrapper# playerStart, vid:" + str + ", playType:" + i3 + ", startPosition:" + j3 + "\uff0cmState:" + com.tencent.mobileqq.kandian.base.video.a.c(this.f239149j.get()));
        }
        if (!p()) {
            QLog.e(this.f239140a, 1, "not idle or complete state, should't reopen mediaplayer, vid:" + str + "\uff0cmState:" + com.tencent.mobileqq.kandian.base.video.a.c(this.f239149j.get()) + ", mSeamlessPlay:" + this.F);
            return;
        }
        j0();
        PlayerVideoInfo playerVideoInfo = new PlayerVideoInfo(i3, str);
        playerVideoInfo.l(z16);
        playerVideoInfo.k("cache_video");
        q(playerVideoInfo);
        if (this.f239144e != null && this.f239145f != null) {
            r(z16).superPlayerDownOption.bandwidthReportHost = "txvideo";
            this.f239145f.f(this.f239144e, playerVideoInfo, j3, r(z16));
        }
        this.f239155p = 0L;
        this.f239154o = 0L;
        this.f239153n = 0L;
        this.f239156q = j3;
        this.f239141b = i3;
    }

    @Override // o52.a
    public boolean g(o52.b bVar, int i3, int i16, int i17, String str) {
        if (QLog.isColorLevel()) {
            QLog.d(this.f239140a, 2, "VideoPlayerWrapper onError!");
        }
        this.f239149j.set(6);
        o52.e eVar = this.f239150k;
        if (eVar == null) {
            return false;
        }
        eVar.b(this, i16, i17, i3, str, null);
        return false;
    }

    public void g0(String str, String str2, int i3, long j3, long j16, int i16, boolean z16, boolean z17, boolean z18, String str3) {
        R(str, str2, i3, j3, j16, i16, z16, z17, z18, str3);
    }

    @Override // o52.a
    public void h(o52.b bVar, int i3, int i16) {
        o52.e eVar = this.f239150k;
        if (eVar != null) {
            eVar.f(this, false, i16, i3, null);
        }
    }

    public void i0() {
        this.f239155p += H(true);
        this.f239154o = 0L;
        this.f239156q = 0L;
    }

    public void j0() {
        if (QLog.isColorLevel()) {
            QLog.d(this.f239140a, 2, "resetVariables: ");
        }
        this.f239141b = 101;
        this.f239142c = false;
        this.f239143d = false;
        this.f239153n = 0L;
        this.f239154o = 0L;
        this.f239155p = 0L;
        this.f239156q = 0L;
        this.f239157r = 0L;
        this.f239158s = 0L;
        this.f239159t = 0;
        this.f239160u = 0L;
        this.f239161v = 0;
        this.A = false;
        this.H = -1;
        this.F = false;
        this.L = false;
        h0();
    }

    public void k0() {
        B0();
    }

    public void l(Map<String, String> map) {
        o52.b bVar = this.f239145f;
        if (bVar != null) {
            bVar.addExtReportData(map);
        }
    }

    public void l0() {
        o52.b bVar = this.f239145f;
        if (bVar != null) {
            bVar.resumeDownload();
        }
    }

    public boolean m(String str) {
        if (QLog.isColorLevel()) {
            QLog.d(this.f239140a, 2, "attachVideoPlayer: ");
        }
        if (TextUtils.isEmpty(str)) {
            QLog.e(this.f239140a, 2, "attachVideoPlayer failed for token is null.");
            return false;
        }
        o52.b c16 = this.f239146g.c(str);
        this.f239145f = c16;
        if (c16 != null) {
            this.J = false;
            c16.c(this);
            return F0();
        }
        QLog.e(this.f239140a, 2, "AttachVideoPlayer error for can't obtain player by token.");
        return false;
    }

    public void n(o52.d dVar) {
        if (QLog.isColorLevel()) {
            QLog.d(this.f239140a, 2, "attachVideoView: ");
        }
        o52.b bVar = this.f239145f;
        if (bVar == null) {
            if (QLog.isColorLevel()) {
                QLog.d(this.f239140a, 2, "attachVideoView: videoplayer null");
            }
        } else {
            this.f239147h = dVar;
            bVar.b(dVar);
            this.f239145f.setXYaxis(this.f239152m);
        }
    }

    public boolean o() {
        return (this.f239149j.get() == 0 || this.f239149j.get() == 8 || this.f239149j.get() == 6 || this.f239149j.get() == 7) ? false : true;
    }

    public void o0(int i3, int i16) {
        if (this.f239145f == null || this.f239149j.get() == 0 || this.f239149j.get() == 2 || this.f239149j.get() == 1 || this.f239149j.get() == 4 || this.f239149j.get() == 8) {
            return;
        }
        long w3 = w();
        long j3 = this.f239156q;
        if (w3 - j3 > 0) {
            this.f239154o += w3 - j3;
        }
        this.f239156q = i3;
        this.f239145f.seekTo(i3, i16);
        this.f239143d = true;
    }

    public void p0(boolean z16) {
        this.L = z16;
    }

    public void q0(boolean z16) {
        this.B = z16;
    }

    public void r0(boolean z16) {
        this.C = z16;
    }

    public View s() {
        if (this.f239147h == null) {
            synchronized (this) {
                if (this.f239147h == null) {
                    this.f239147h = Q();
                }
            }
        }
        o52.d dVar = this.f239147h;
        if (dVar == null) {
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.d(this.f239140a, 2, "createVideoView: null");
            return null;
        }
        View a16 = dVar.a();
        if (a16 != null && a16.getParent() != null) {
            ViewParent parent = a16.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(a16);
            }
            if (QLog.isColorLevel()) {
                QLog.d(this.f239140a, 2, "remove scroll view parents!");
            }
        }
        return a16;
    }

    public void s0(o52.e eVar) {
        this.f239150k = eVar;
    }

    public void t() {
        u(!this.J);
    }

    public void t0(final boolean z16) {
        this.E = z16;
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.kandian.base.video.player.VideoPlayerWrapper.5
                @Override // java.lang.Runnable
                public void run() {
                    if (VideoPlayerWrapper.this.f239145f == null || VideoPlayerWrapper.this.f239149j.get() == 6 || VideoPlayerWrapper.this.f239149j.get() == 8) {
                        return;
                    }
                    VideoPlayerWrapper.this.f239145f.setLoopback(z16);
                }
            }, 16, null, false);
        } else {
            if (this.f239145f == null || this.f239149j.get() == 6 || this.f239149j.get() == 8) {
                return;
            }
            this.f239145f.setLoopback(z16);
        }
    }

    public void u(final boolean z16) {
        if (this.f239149j.get() == 8) {
            return;
        }
        this.f239149j.set(8);
        final o52.b bVar = this.f239145f;
        if (bVar != null) {
            ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.kandian.base.video.player.VideoPlayerWrapper.3
                @Override // java.lang.Runnable
                public void run() {
                    bVar.stop();
                    bVar.release();
                }
            });
        }
        o52.d dVar = this.f239147h;
        final View a16 = dVar != null ? dVar.a() : null;
        g.a(new Runnable() { // from class: com.tencent.mobileqq.kandian.base.video.player.VideoPlayerWrapper.4
            @Override // java.lang.Runnable
            public void run() {
                View view;
                if (!z16 || (view = a16) == null) {
                    return;
                }
                ViewParent parent = view.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(a16);
                }
            }
        });
        this.f239150k = null;
        this.f239147h = null;
        this.f239148i = null;
        this.f239144e = null;
        this.f239142c = true;
        this.f239164y = 0L;
        if (QLog.isColorLevel()) {
            QLog.d(this.f239140a, 2, "VideoPlayerWrapper: destory removeView=" + z16);
        }
    }

    public void u0(boolean z16) {
        this.D = z16;
        o52.b bVar = this.f239145f;
        if (bVar != null) {
            bVar.setOutputMute(z16);
        }
    }

    public void v() {
        o52.d dVar = this.f239147h;
        if (dVar != null) {
            dVar.c();
        }
    }

    public void v0(String[] strArr) {
        StringBuilder sb5 = new StringBuilder();
        if (strArr != null) {
            for (int i3 = 0; i3 < strArr.length; i3++) {
                if (i3 != 0) {
                    sb5.append(" ,");
                }
                sb5.append(strArr[i3]);
            }
        }
        this.G = sb5.toString();
    }

    public long w() {
        o52.b bVar = this.f239145f;
        if (bVar == null) {
            return 0L;
        }
        return bVar.getCurrentPositionMs();
    }

    public void w0() {
        o52.b bVar = this.f239145f;
        if (bVar != null) {
            bVar.setPlayerActive();
        }
    }

    public int x() {
        return this.f239149j.get();
    }

    public void x0(String str) {
        o52.b bVar = this.f239145f;
        if (bVar != null) {
            bVar.setReportContentId(str);
        }
    }

    public int y() {
        if (this.f239145f == null) {
            return 0;
        }
        long j3 = this.f239162w;
        if (j3 == 0) {
            return 0;
        }
        return Math.round((((float) z()) * (((float) this.f239164y) / ((float) j3))) / 1000.0f);
    }

    public void y0(float f16) {
        o52.b bVar = this.f239145f;
        if (bVar != null) {
            bVar.d(f16);
        }
    }

    public long z() {
        long j3 = this.f239153n;
        if (j3 != 0) {
            return j3;
        }
        o52.b bVar = this.f239145f;
        if (bVar != null) {
            return bVar.getDurationMs();
        }
        return -1L;
    }

    public void z0(Object obj) {
        this.f239151l = obj;
    }

    public VideoPlayerWrapper(Context context, String str) {
        this.f239140a = "Q.readinjoy.video.VideoPlayerWrapper<" + Integer.toHexString(hashCode()) + ">";
        this.f239141b = 101;
        this.f239142c = false;
        this.f239143d = false;
        this.f239149j = new AtomicInteger(0);
        this.f239152m = 0;
        this.f239163x = new Object();
        this.f239164y = 0L;
        this.f239165z = 0;
        this.A = false;
        this.C = false;
        this.E = false;
        this.F = false;
        this.H = -1;
        this.I = new p52.a();
        this.J = false;
        this.L = false;
        this.M = new p52.c();
        this.Y = new HashSet();
        this.f239144e = context;
        N(str);
    }

    private void h0() {
        this.f239165z = 0;
        this.f239164y = 0L;
        this.f239162w = 0L;
        this.N = 0L;
        this.O = 0L;
        this.P = 0L;
        this.Q = 0L;
        this.R = 0L;
        this.S = 0L;
        this.T = 0L;
        this.U = 0;
        this.V = 0;
        this.W = 0;
        this.X = 0;
        this.Y.clear();
    }

    public void n0(int i3) {
        o0(i3, 1);
    }

    private void q(PlayerVideoInfo playerVideoInfo) {
        if (playerVideoInfo != null) {
            playerVideoInfo.f(this.B);
            playerVideoInfo.j(this.C);
            playerVideoInfo.m(Z);
        }
    }

    private SuperPlayerOption r(boolean z16) {
        SuperPlayerOption obtain = SuperPlayerOption.obtain(104);
        obtain.isPrePlay = z16;
        if (QLog.isColorLevel()) {
            QLog.d(this.f239140a, 2, "commonPlayerOption: " + obtain);
        }
        return obtain;
    }

    public void O(ViewGroup viewGroup) {
        P(viewGroup, false, true);
    }

    public void e0(String str, int i3, long j3) {
        f0(str, i3, j3, false);
    }

    @Override // o52.a
    public boolean e(o52.b bVar, int i3, Object obj) {
        if (i3 == 112) {
            if (QLog.isColorLevel()) {
                QLog.d(this.f239140a, 2, "VideoPlayerWrapper onInfo, start buffering ==> isSeeking = " + this.f239143d);
            }
            if (this.f239149j.get() != 5) {
                this.f239149j.set(4);
            }
            this.f239157r = System.currentTimeMillis();
        } else if (i3 == 113) {
            if (QLog.isColorLevel()) {
                QLog.d(this.f239140a, 2, "VideoPlayerWrapper onInfo, end buffering <== isSeeking = " + this.f239143d);
            }
            if (this.f239149j.get() != 5) {
                this.f239149j.set(3);
            }
            if (!this.f239143d) {
                this.f239159t++;
                this.f239158s += System.currentTimeMillis() - this.f239157r;
            }
        } else if (i3 == 124) {
            o52.e eVar = this.f239150k;
            if (eVar != null) {
                eVar.a(this, "");
            }
        } else if (i3 != 205) {
            if (i3 == 208) {
                if (obj instanceof TPMediaCodecReadyInfo) {
                    this.I.b((TPMediaCodecReadyInfo) obj);
                }
                com.tencent.qav.thread.a.b(new Runnable() { // from class: com.tencent.mobileqq.kandian.base.video.player.VideoPlayerWrapper.2
                    @Override // java.lang.Runnable
                    public void run() {
                        VideoPlayerWrapper.i(VideoPlayerWrapper.this);
                    }
                });
            } else if (i3 == 251) {
                boolean z16 = obj instanceof String;
            }
        } else if (obj instanceof TPPlayerMsg.TPProtocolInfo) {
            this.M.b((TPPlayerMsg.TPProtocolInfo) obj);
        }
        o52.e eVar2 = this.f239150k;
        if (eVar2 == null) {
            return false;
        }
        eVar2.e(this, i3, obj);
        return false;
    }
}
