package com.tencent.luggage.wxa.eh;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.eh.d;
import com.tencent.luggage.wxa.mg.g;
import com.tencent.luggage.wxa.tn.b0;
import com.tencent.luggage.wxa.tn.e0;
import com.tencent.luggage.wxa.tn.h0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.VideoPlayerSeekBar;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class b extends RelativeLayout implements com.tencent.luggage.wxa.mg.g, d.a, d.e, d.c, d.b, d.InterfaceC6170d {
    public int C;
    public boolean D;
    public g.c E;
    public b0 F;
    public int G;
    public boolean H;
    public int I;
    public int J;
    public boolean K;
    public boolean L;
    public long M;
    public int N;
    public com.tencent.luggage.wxa.mg.k O;
    public e0 P;
    public e0 Q;
    public e0 R;
    public g.d S;
    public View.OnClickListener T;
    public boolean U;
    public Runnable V;

    /* renamed from: a, reason: collision with root package name */
    public Context f124826a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f124827b;

    /* renamed from: c, reason: collision with root package name */
    public ImageView f124828c;

    /* renamed from: d, reason: collision with root package name */
    public RelativeLayout f124829d;

    /* renamed from: e, reason: collision with root package name */
    public TextView f124830e;

    /* renamed from: f, reason: collision with root package name */
    public ProgressBar f124831f;

    /* renamed from: g, reason: collision with root package name */
    public TextView f124832g;

    /* renamed from: h, reason: collision with root package name */
    public LinearLayout f124833h;

    /* renamed from: i, reason: collision with root package name */
    public VideoPlayerSeekBar f124834i;

    /* renamed from: j, reason: collision with root package name */
    public g.b f124835j;

    /* renamed from: k, reason: collision with root package name */
    public com.tencent.luggage.wxa.eh.d f124836k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f124837l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f124838m;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                b.this.c(0);
                b bVar = b.this;
                bVar.c(bVar.isPlaying());
            } catch (Throwable unused) {
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.eh.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC6169b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f124840a;

        public RunnableC6169b(int i3) {
            this.f124840a = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar = b.this;
            bVar.K = true;
            bVar.c(this.f124840a);
            b.this.a(this.f124840a, true);
            b.this.K = false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements e0.a {
        public c() {
        }

        @Override // com.tencent.luggage.wxa.tn.e0.a
        public boolean a() {
            if (!b.this.isPlaying()) {
                return false;
            }
            b bVar = b.this;
            if (bVar.D) {
                g.c cVar = bVar.E;
                if (cVar != null) {
                    cVar.c(bVar.getSessionId(), b.this.getMediaId());
                }
                b.this.D = false;
            }
            b bVar2 = b.this;
            bVar2.c(bVar2.getCurrPosSec());
            b bVar3 = b.this;
            bVar3.c(bVar3.isPlaying());
            if (b.this.t()) {
                return b.this.k();
            }
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d implements e0.a {
        public d() {
        }

        @Override // com.tencent.luggage.wxa.tn.e0.a
        public boolean a() {
            boolean isPlaying = b.this.isPlaying();
            int currPosMs = b.this.getCurrPosMs();
            b.this.b("MicroMsg.Video.AbstractVideoView", "prepare start checker isplaying[%b] currPosMs[%d]", Boolean.valueOf(isPlaying), Integer.valueOf(currPosMs));
            com.tencent.luggage.wxa.eh.d dVar = b.this.f124836k;
            if (dVar != null && currPosMs <= 50) {
                dVar.a(0.0d);
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class e implements e0.a {
        public e() {
        }

        @Override // com.tencent.luggage.wxa.tn.e0.a
        public boolean a() {
            b bVar = b.this;
            if (bVar.J <= 0) {
                return false;
            }
            if (bVar.isPlaying()) {
                b.this.w();
                return false;
            }
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class f implements g.d {
        public f() {
        }

        @Override // com.tencent.luggage.wxa.mg.g.d
        public void a() {
        }

        @Override // com.tencent.luggage.wxa.mg.g.d
        public void a(int i3) {
            if (b.this.a(i3, true)) {
                b.this.b(false);
            }
            VideoPlayerSeekBar videoPlayerSeekBar = b.this.f124834i;
            if (videoPlayerSeekBar != null) {
                videoPlayerSeekBar.setIsPlay(true);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.b("MicroMsg.Video.AbstractVideoView", "seek bar play button on click ", new Object[0]);
            b.this.u();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.U = true;
            ProgressBar progressBar = b.this.f124831f;
            if (progressBar != null && progressBar.getVisibility() != 0) {
                b.this.b("MicroMsg.Video.AbstractVideoView", "show loading", new Object[0]);
                b.this.f124831f.setVisibility(0);
            }
            b bVar = b.this;
            g.c cVar = bVar.E;
            if (cVar != null) {
                cVar.d(bVar.getSessionId(), b.this.getMediaId());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.U) {
                b.this.U = false;
                b bVar = b.this;
                g.c cVar = bVar.E;
                if (cVar != null) {
                    cVar.e(bVar.getSessionId(), b.this.getMediaId());
                }
                ProgressBar progressBar = b.this.f124831f;
                if (progressBar != null && progressBar.getVisibility() != 8) {
                    b.this.b("MicroMsg.Video.AbstractVideoView", "hide loading", new Object[0]);
                    b.this.f124831f.setVisibility(8);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class j implements Runnable {
        public j() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LinearLayout linearLayout = b.this.f124833h;
            if (linearLayout != null && linearLayout.getVisibility() != 0) {
                b.this.f124833h.setVisibility(0);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class k implements Runnable {
        public k() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LinearLayout linearLayout = b.this.f124833h;
            if (linearLayout != null && linearLayout.getVisibility() != 8) {
                b.this.f124833h.setVisibility(8);
            }
        }
    }

    public b(Context context) {
        this(context, null);
    }

    public void A() {
        this.R.f();
    }

    public void B() {
        this.P.f();
        this.Q.f();
    }

    @Override // com.tencent.luggage.wxa.eh.d.a
    public int a(int i3, int i16) {
        return 0;
    }

    public abstract com.tencent.luggage.wxa.eh.d a(Context context);

    public final void c(boolean z16) {
        g.b bVar = this.f124835j;
        if (bVar != null) {
            bVar.a(z16);
        }
    }

    @Override // com.tencent.luggage.wxa.mg.g
    public void d() {
        b("MicroMsg.Video.AbstractVideoView", "onUIResume %s", w0.b());
        this.f124827b = true;
    }

    public final String e(int i3, int i16) {
        return (i3 == -1010 || i3 == -1007) ? "MEDIA_ERR_SRC_NOT_SUPPORTED" : i3 == -1004 ? !h0.j(this.f124826a) ? "MEDIA_ERR_NETWORK" : "MEDIA_ERR_DECODE" : !h0.j(this.f124826a) ? "MEDIA_ERR_NETWORK" : "MEDIA_ERR_DECODE";
    }

    @Override // com.tencent.luggage.wxa.mg.g
    public void f() {
        b("MicroMsg.Video.AbstractVideoView", "onUIPause %s", w0.b());
        this.C = getCurrPosSec();
        this.D = isPlaying();
        this.N = 0;
        this.M = 0;
        pause();
        B();
        this.f124827b = false;
    }

    @Override // com.tencent.luggage.wxa.mg.g
    public void g() {
        b("MicroMsg.Video.AbstractVideoView", "onUIDestroy", new Object[0]);
        stop();
        this.F.a((Object) null);
        B();
        A();
    }

    @Override // com.tencent.luggage.wxa.mg.g
    public int getCacheTimeSec() {
        return 0;
    }

    @Override // com.tencent.luggage.wxa.mg.g
    public int getCurrPosMs() {
        com.tencent.luggage.wxa.eh.d dVar = this.f124836k;
        if (dVar != null) {
            return dVar.getCurrentPosition();
        }
        return 0;
    }

    @Override // com.tencent.luggage.wxa.mg.g
    public int getCurrPosSec() {
        if (this.f124836k != null) {
            return Math.round((r0.getCurrentPosition() * 1.0f) / 1000.0f);
        }
        return 0;
    }

    public String getMediaId() {
        return "";
    }

    @Override // com.tencent.luggage.wxa.mg.g
    public int getPlayerType() {
        return this.G;
    }

    public String getSessionId() {
        return "";
    }

    @Override // com.tencent.luggage.wxa.mg.g
    public int getVideoDurationSec() {
        if (this.f124836k != null) {
            return Math.round((r0.getDuration() * 1.0f) / 1000.0f);
        }
        return -1;
    }

    public int getVideoSource() {
        return 0;
    }

    @Override // com.tencent.luggage.wxa.mg.g
    public abstract /* synthetic */ View getView();

    @Override // com.tencent.luggage.wxa.eh.d.e
    public void h() {
        b("MicroMsg.Video.AbstractVideoView", "onTextureUpdate ", new Object[0]);
        n();
    }

    @Override // com.tencent.luggage.wxa.mg.g
    public boolean isPlaying() {
        com.tencent.luggage.wxa.eh.d dVar = this.f124836k;
        if (dVar != null) {
            return dVar.isPlaying();
        }
        return false;
    }

    public boolean k() {
        long lastSurfaceUpdateTime = this.f124836k.getLastSurfaceUpdateTime();
        int currentPosition = this.f124836k.getCurrentPosition();
        a("MicroMsg.Video.AbstractVideoView", "check surface is update surface[%d %d] playtime[%d %d]", Long.valueOf(this.M), Long.valueOf(lastSurfaceUpdateTime), Integer.valueOf(this.N), Integer.valueOf(currentPosition));
        if (lastSurfaceUpdateTime > 0 && lastSurfaceUpdateTime == this.M && currentPosition != this.N) {
            d("MicroMsg.Video.AbstractVideoView", "check surface is update error", new Object[0]);
            a(this.N / 1000, true);
            return false;
        }
        this.M = lastSurfaceUpdateTime;
        this.N = currentPosition;
        return true;
    }

    public g.d l() {
        return new f();
    }

    public View.OnClickListener m() {
        return new g();
    }

    public void n() {
        this.F.b(this.V);
        this.F.a((Runnable) new i());
    }

    public void o() {
        this.F.a((Runnable) new k());
    }

    public void p() {
        b("MicroMsg.Video.AbstractVideoView", "init abstract video view", new Object[0]);
        LayoutInflater.from(this.f124826a).inflate(r(), this);
        this.f124828c = (ImageView) a(R.id.kuw);
        this.f124829d = (RelativeLayout) a(R.id.f1179872x);
        this.f124830e = (TextView) a(R.id.kqr);
        this.f124831f = (ProgressBar) a(R.id.f11770726);
        this.f124832g = (TextView) a(R.id.f11801730);
        this.f124833h = (LinearLayout) a(R.id.f1176171x);
        VideoPlayerSeekBar videoPlayerSeekBar = (VideoPlayerSeekBar) a(R.id.f1178272h);
        this.f124834i = videoPlayerSeekBar;
        this.f124835j = videoPlayerSeekBar;
        if (videoPlayerSeekBar != null) {
            videoPlayerSeekBar.setIplaySeekCallback(this.S);
            this.f124834i.setOnClickListener(this.T);
        }
        com.tencent.luggage.wxa.eh.d a16 = a(this.f124826a);
        this.f124836k = a16;
        a16.setVideoCallback(this);
        this.f124836k.setOnSeekCompleteCallback(this);
        this.f124836k.setOnInfoCallback(this);
        this.f124836k.setOnSurfaceCallback(this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        this.f124829d.addView((View) this.f124836k, 0, layoutParams);
    }

    @Override // com.tencent.luggage.wxa.mg.g
    public boolean pause() {
        b("MicroMsg.Video.AbstractVideoView", "pause", new Object[0]);
        if (this.f124836k == null) {
            return false;
        }
        c(false);
        this.f124836k.pause();
        B();
        g.c cVar = this.E;
        if (cVar != null) {
            cVar.b(getSessionId(), getMediaId());
        }
        return true;
    }

    public boolean q() {
        com.tencent.luggage.wxa.eh.d dVar = this.f124836k;
        if (dVar == null || w0.c(dVar.getVideoPath()) || !this.L) {
            return false;
        }
        return true;
    }

    public int r() {
        return R.layout.dxc;
    }

    public boolean s() {
        return true;
    }

    @Override // com.tencent.luggage.wxa.mg.g
    public void setCover(Bitmap bitmap) {
        ImageView imageView;
        b("MicroMsg.Video.AbstractVideoView", "set cover", new Object[0]);
        if (bitmap != null && !bitmap.isRecycled() && (imageView = this.f124828c) != null) {
            imageView.setImageBitmap(bitmap);
        }
    }

    @Override // com.tencent.luggage.wxa.mg.g
    public void setIMMVideoViewCallback(g.c cVar) {
        this.E = cVar;
    }

    @Override // com.tencent.luggage.wxa.mg.g
    public void setIsShowBasicControls(boolean z16) {
        b("MicroMsg.Video.AbstractVideoView", "is show seek bar[%b]", Boolean.valueOf(z16));
        this.f124837l = z16;
        if (z16) {
            y();
        } else {
            o();
        }
    }

    @Override // com.tencent.luggage.wxa.mg.g
    public void setMinBufferDuration(long j3) {
        com.tencent.luggage.wxa.eh.d dVar = this.f124836k;
        if (dVar != null) {
            dVar.setMinBufferDuration(j3);
        }
    }

    @Override // com.tencent.luggage.wxa.mg.g
    public void setMute(boolean z16) {
        com.tencent.luggage.wxa.eh.d dVar = this.f124836k;
        if (dVar != null) {
            dVar.setMute(z16);
        }
    }

    @Override // com.tencent.luggage.wxa.mg.g
    public abstract /* synthetic */ void setScaleType(g.h hVar);

    @Override // com.tencent.luggage.wxa.mg.g
    public void setVideoContext(@NonNull com.tencent.luggage.wxa.mg.k kVar) {
        this.O = kVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.luggage.wxa.mg.g
    public void setVideoFooterView(g.b bVar) {
        if (!(bVar instanceof View)) {
            d("MicroMsg.Video.AbstractVideoView", "set video footer view but is not view", new Object[0]);
            return;
        }
        v();
        this.f124835j = bVar;
        this.f124838m = false;
        this.f124833h.addView((View) bVar);
    }

    @Override // com.tencent.luggage.wxa.mg.g
    public abstract /* synthetic */ void setVideoSource(int i3);

    public void setVideoTotalTime(int i3) {
        g.b bVar = this.f124835j;
        if (bVar != null && bVar.getVideoTotalTime() != i3) {
            this.f124835j.setVideoTotalTime(i3);
        }
    }

    @Override // com.tencent.luggage.wxa.mg.g
    public void stop() {
        b("MicroMsg.Video.AbstractVideoView", "stop", new Object[0]);
        com.tencent.luggage.wxa.eh.d dVar = this.f124836k;
        if (dVar != null) {
            dVar.stop();
        }
        this.I = -1;
        this.H = true;
        this.L = false;
        this.N = 0;
        this.M = 0;
        B();
        this.F.a(new a(), 10L);
    }

    public boolean t() {
        return false;
    }

    public boolean u() {
        if (this.f124836k == null) {
            return false;
        }
        if (isPlaying()) {
            pause();
            return true;
        }
        if (w0.c(this.f124836k.getVideoPath())) {
            start();
            return true;
        }
        c();
        return true;
    }

    public void v() {
        Object obj = this.f124835j;
        if (obj != null) {
            this.f124833h.removeView((View) obj);
        }
    }

    public final void w() {
        b("MicroMsg.Video.AbstractVideoView", "reset error count ", new Object[0]);
        this.J = 0;
    }

    public void x() {
        a(500L);
    }

    public void y() {
        this.F.a((Runnable) new j());
    }

    public void z() {
        if (this.J > 0) {
            a("MicroMsg.Video.AbstractVideoView", "start error check timer", new Object[0]);
            this.R.a(5000L);
        }
    }

    public b(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f124827b = true;
        this.f124838m = true;
        this.C = 0;
        this.D = false;
        this.F = new b0(Looper.getMainLooper());
        this.G = 0;
        this.H = true;
        this.I = -1;
        this.J = 0;
        this.K = false;
        this.L = false;
        this.M = 0L;
        this.N = 0;
        this.O = null;
        this.P = new e0(new c(), true);
        this.Q = new e0(new d(), false);
        this.R = new e0(new e(), true);
        this.S = l();
        this.T = m();
        this.U = false;
        this.V = new h();
        this.f124826a = context;
        p();
    }

    public void b(int i3) {
        g.b bVar = this.f124835j;
        if (bVar != null) {
            bVar.b(i3);
        }
    }

    public void c(int i3) {
        b(i3);
    }

    @Override // com.tencent.luggage.wxa.eh.d.a
    public void d(int i3, int i16) {
        b("MicroMsg.Video.AbstractVideoView", "on get video size [%d, %d]", Integer.valueOf(i3), Integer.valueOf(i16));
        g.c cVar = this.E;
        if (cVar != null) {
            cVar.a(getSessionId(), getMediaId(), i3, i16);
        }
    }

    @Override // com.tencent.luggage.wxa.eh.d.InterfaceC6170d
    public void e() {
        b("MicroMsg.Video.AbstractVideoView", "on surface available", new Object[0]);
        b(false);
    }

    public void a(long j3) {
        this.F.b(this.V);
        this.F.a(this.V, j3);
    }

    @Override // com.tencent.luggage.wxa.mg.g
    public boolean c() {
        if (!this.f124827b) {
            d("MicroMsg.Video.AbstractVideoView", "ui on pause now, why u call me to play? [%s]", w0.b());
            return false;
        }
        com.tencent.luggage.wxa.eh.d dVar = this.f124836k;
        if (dVar == null) {
            return false;
        }
        boolean start = dVar.start();
        b("MicroMsg.Video.AbstractVideoView", "video play [%b] isPlayOnUiPause[%b]", Boolean.valueOf(start), Boolean.valueOf(this.D));
        c(start);
        if (start) {
            this.D = false;
            b(false);
            g.c cVar = this.E;
            if (cVar != null) {
                cVar.c(getSessionId(), getMediaId());
            }
        }
        return start;
    }

    public void b(boolean z16) {
        a("MicroMsg.Video.AbstractVideoView", "start timer rightNow[%b]", Boolean.valueOf(z16));
        this.P.a(500L);
    }

    public Object a(int i3) {
        return findViewById(i3);
    }

    public final void d(String str, String str2, Object... objArr) {
        w.h(str, this.O + " " + str2, objArr);
    }

    @Override // com.tencent.luggage.wxa.mg.g
    public boolean a(double d16) {
        return a(d16, isPlaying());
    }

    @Override // com.tencent.luggage.wxa.eh.d.a
    public void b() {
        b("MicroMsg.Video.AbstractVideoView", "onCompletion, curMs %d, duration %d", Integer.valueOf(getCurrPosSec()), Integer.valueOf(getVideoDurationSec()));
        c(getVideoDurationSec());
        n();
        B();
        g.c cVar = this.E;
        if (cVar != null) {
            cVar.f(getSessionId(), getMediaId());
        }
        this.N = 0;
        this.M = 0;
    }

    @Override // com.tencent.luggage.wxa.mg.g
    public boolean a(double d16, boolean z16) {
        boolean q16 = q();
        int videoDurationSec = getVideoDurationSec();
        int i3 = (int) d16;
        if (videoDurationSec > 0 && d16 > videoDurationSec) {
            i3 = videoDurationSec;
        }
        com.tencent.luggage.wxa.eh.d dVar = this.f124836k;
        c("MicroMsg.Video.AbstractVideoView", "seek to [%d %s] seconds afterPlay[%b] isPrepared[%b] duration[%d] hadSetPath[%b]", Integer.valueOf(i3), Double.valueOf(d16), Boolean.valueOf(z16), Boolean.valueOf(q16), Integer.valueOf(videoDurationSec), Boolean.valueOf((dVar == null || w0.c(dVar.getVideoPath())) ? false : true));
        if (q16) {
            if (this.f124836k != null) {
                x();
                c(i3);
                this.f124836k.a(i3 * 1000, z16);
                return z16;
            }
        } else {
            this.I = i3;
            this.H = z16;
        }
        return false;
    }

    public final void b(String str, String str2, Object... objArr) {
        w.d(str, this.O + " " + str2, objArr);
    }

    @Override // com.tencent.luggage.wxa.eh.d.a
    public void c(int i3, int i16) {
        d("MicroMsg.Video.AbstractVideoView", "onError info [%d %d] errorCount[%d]", Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(this.J));
        int i17 = this.J + 1;
        this.J = i17;
        if (i17 > 0) {
            g.c cVar = this.E;
            if (cVar != null) {
                cVar.a(getSessionId(), getMediaId(), e(i3, i16), i3, i16);
            }
            stop();
            n();
            return;
        }
        int currPosSec = getCurrPosSec();
        int i18 = this.I;
        if (i18 == -1) {
            i18 = currPosSec;
        }
        b("MicroMsg.Video.AbstractVideoView", "onError now, try to start again. currPlaySec[%d] seekTimeWhenPrepared[%d] currPosSec[%d]", Integer.valueOf(i18), Integer.valueOf(this.I), Integer.valueOf(currPosSec));
        stop();
        x();
        this.F.a(new RunnableC6169b(i18), 200L);
    }

    @Override // com.tencent.luggage.wxa.eh.d.a
    public void a() {
        b("MicroMsg.Video.AbstractVideoView", "onPrepared startWhenPrepared[%b] seekTimeWhenPrepared[%d] isPrepared[%b]", Boolean.valueOf(this.H), Integer.valueOf(this.I), Boolean.valueOf(this.L));
        this.L = true;
        com.tencent.luggage.wxa.eh.d dVar = this.f124836k;
        if (dVar != null) {
            dVar.setOneTimeVideoTextureUpdateCallback(this);
        }
        setVideoTotalTime(getVideoDurationSec());
        if (this.H) {
            if (this.I <= -1) {
                if (c() && s()) {
                    this.Q.a(1000L);
                }
            } else if (!i()) {
                a(this.I, this.H);
            } else {
                c();
            }
        } else {
            int i3 = this.I;
            if (i3 >= 0) {
                a(i3, false);
            }
        }
        this.I = -1;
        this.H = true;
        this.N = 0;
        this.M = 0;
        g.c cVar = this.E;
        if (cVar != null) {
            cVar.a(getSessionId(), getMediaId());
        }
        z();
    }

    public final void c(String str, String str2, Object... objArr) {
        w.f(str, this.O + " " + str2, objArr);
    }

    @Override // com.tencent.luggage.wxa.mg.g
    public void setFullDirection(int i3) {
    }

    @Override // com.tencent.luggage.wxa.eh.d.c
    public void a(boolean z16) {
        b("MicroMsg.Video.AbstractVideoView", "on seek complete startPlay[%b]", Boolean.valueOf(z16));
        com.tencent.luggage.wxa.eh.d dVar = this.f124836k;
        if (dVar != null) {
            dVar.setOneTimeVideoTextureUpdateCallback(this);
        }
        n();
        c(z16);
        c(getCurrPosSec());
        if (z16) {
            b(false);
            this.D = false;
            g.c cVar = this.E;
            if (cVar != null) {
                cVar.c(getSessionId(), getMediaId());
            }
        }
    }

    public final void a(String str, String str2, Object... objArr) {
        w.a(str, this.O + " " + str2, objArr);
    }

    public final void a(String str, Throwable th5, String str2, Object... objArr) {
        w.a(str, th5, this.O + " " + str2, objArr);
    }
}
