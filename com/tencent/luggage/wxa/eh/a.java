package com.tencent.luggage.wxa.eh;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.tencent.ark.EGLContextHolder;
import com.tencent.luggage.wxa.eh.d;
import com.tencent.luggage.wxa.mg.g;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.xg.g;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a extends TextureView implements com.tencent.luggage.wxa.eh.d {
    public long C;
    public long D;
    public int E;
    public boolean F;
    public boolean G;
    public com.tencent.luggage.wxa.mg.k H;
    public g.i I;
    public final g.h J;
    public g.f K;
    public g.InterfaceC6908g L;
    public g.a M;
    public g.e N;
    public g.b O;
    public g.d P;
    public long Q;
    public boolean R;
    public boolean S;
    public boolean T;
    public TextureView.SurfaceTextureListener U;
    public boolean V;
    public long W;

    /* renamed from: a, reason: collision with root package name */
    public String f124793a;

    /* renamed from: a0, reason: collision with root package name */
    public com.tencent.luggage.wxa.eh.e f124794a0;

    /* renamed from: b, reason: collision with root package name */
    public int f124795b;

    /* renamed from: b0, reason: collision with root package name */
    public float f124796b0;

    /* renamed from: c, reason: collision with root package name */
    public Surface f124797c;

    /* renamed from: d, reason: collision with root package name */
    public com.tencent.luggage.wxa.xg.g f124798d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f124799e;

    /* renamed from: f, reason: collision with root package name */
    public int f124800f;

    /* renamed from: g, reason: collision with root package name */
    public int f124801g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f124802h;

    /* renamed from: i, reason: collision with root package name */
    public d.a f124803i;

    /* renamed from: j, reason: collision with root package name */
    public d.e f124804j;

    /* renamed from: k, reason: collision with root package name */
    public d.c f124805k;

    /* renamed from: l, reason: collision with root package name */
    public d.b f124806l;

    /* renamed from: m, reason: collision with root package name */
    public d.InterfaceC6170d f124807m;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.eh.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6168a implements g.e {
        public C6168a() {
        }

        @Override // com.tencent.luggage.wxa.xg.g.e
        public boolean a(com.tencent.luggage.wxa.xg.g gVar, int i3, int i16) {
            a.this.a("onInfo [%d %d]", Integer.valueOf(i3), Integer.valueOf(i16));
            if (a.this.f124806l != null) {
                a.this.f124806l.b(i3, i16);
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements g.b {
        public b() {
        }

        @Override // com.tencent.luggage.wxa.xg.g.b
        public void a(com.tencent.luggage.wxa.xg.g gVar) {
            a.this.b("video on completion", new Object[0]);
            a.this.D = w0.d();
            if (a.this.f124803i != null) {
                a.this.f124803i.b();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements g.d {
        public c() {
        }

        @Override // com.tencent.luggage.wxa.xg.g.d
        public boolean a(com.tencent.luggage.wxa.xg.g gVar, int i3, int i16) {
            a.this.c("Error: " + i3 + "," + i16, new Object[0]);
            if (a.this.f124803i != null) {
                a.this.f124803i.c(i3, i16);
                return true;
            }
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d implements TextureView.SurfaceTextureListener {
        public d() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i3, int i16) {
            a aVar = a.this;
            aVar.a(aVar.f124797c);
            a.this.f124797c = new Surface(surfaceTexture);
            a.this.b("on texture available %d*%d mIsPrepared[%b] mSurface[%d] ", Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(a.this.f124799e), Integer.valueOf(a.this.f124797c.hashCode()));
            a aVar2 = a.this;
            if (aVar2.f124798d == null || !aVar2.f124799e) {
                a.this.d();
            } else {
                a aVar3 = a.this;
                aVar3.f124798d.setSurface(aVar3.f124797c);
                if (!a.this.R) {
                    a.this.S = true;
                    a.this.f124798d.a(0.0f, 0.0f);
                    a.this.f124798d.start();
                } else {
                    a.this.f124798d.start();
                }
                a.this.R = false;
            }
            if (a.this.f124807m != null) {
                a.this.f124807m.e();
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            a aVar = a.this;
            aVar.b("on texture destroyed mIsPrepared[%b]", Boolean.valueOf(aVar.f124799e));
            a aVar2 = a.this;
            aVar2.a(aVar2.f124797c);
            a.this.f124797c = null;
            a aVar3 = a.this;
            if (aVar3.f124798d == null || !aVar3.f124799e) {
                a.this.e();
                a.this.R = false;
            } else if (a.this.isPlaying()) {
                a.this.R = true;
                a.this.f124798d.pause();
            }
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i3, int i16) {
            a.this.b("on texture size changed width : " + i3 + " height : " + i16, new Object[0]);
            a aVar = a.this;
            if (aVar.f124798d != null && aVar.f124799e && a.this.f124800f == i3 && a.this.f124801g == i16) {
                a.this.f124798d.start();
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            a.this.a("on surface texture updated", new Object[0]);
            if (a.this.S) {
                com.tencent.luggage.wxa.xg.g gVar = a.this.f124798d;
                if (gVar != null) {
                    gVar.pause();
                    if (a.this.V) {
                        a.this.f124798d.a(0.0f, 0.0f);
                    } else {
                        a.this.f124798d.a(1.0f, 1.0f);
                    }
                }
                a.this.S = false;
            }
            if (a.this.Q > 0 && a.this.f124804j != null) {
                a.this.f124804j.h();
                a.this.f124804j = null;
            }
            a.this.Q = System.currentTimeMillis();
            if (a.this.T) {
                a aVar = a.this;
                aVar.b("flush surface pause now time[%d]", Integer.valueOf(aVar.getCurrentPosition()));
                com.tencent.luggage.wxa.xg.g gVar2 = a.this.f124798d;
                if (gVar2 != null) {
                    gVar2.pause();
                    a aVar2 = a.this;
                    aVar2.setMute(aVar2.V);
                }
                a.this.T = false;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Surface f124812a;

        public e(Surface surface) {
            this.f124812a = surface;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Surface surface = this.f124812a;
                if (surface != null && surface.isValid()) {
                    a.this.b("release surface [%d]", Integer.valueOf(this.f124812a.hashCode()));
                    this.f124812a.release();
                }
            } catch (Exception e16) {
                a.this.a(e16, "release Surface error", new Object[0]);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class f implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xg.g f124814a;

        public f(com.tencent.luggage.wxa.xg.g gVar) {
            this.f124814a = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f124814a.reset();
                this.f124814a.release();
            } catch (Exception e16) {
                a.this.a(e16, "reset media player error", new Object[0]);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class g extends BaseThread {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xg.g f124816a;

        public g(com.tencent.luggage.wxa.xg.g gVar) {
            this.f124816a = gVar;
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                com.tencent.luggage.wxa.xg.g gVar = this.f124816a;
                if (gVar != null) {
                    a.this.b("MicroMsg.Video.AbstractVideoTextureView", "another thread to release player[%s]", gVar);
                    this.f124816a.stop();
                    this.f124816a.release();
                }
            } catch (Exception unused) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                a aVar = a.this;
                aVar.f124798d.setSurface(aVar.f124797c);
                a.this.f124798d.prepareAsync();
                a aVar2 = a.this;
                aVar2.f124801g = aVar2.f124798d.getVideoHeight();
                a aVar3 = a.this;
                aVar3.f124800f = aVar3.f124798d.getVideoWidth();
                a aVar4 = a.this;
                aVar4.setMute(aVar4.V);
                a aVar5 = a.this;
                aVar5.a(aVar5.f124796b0);
            } catch (Exception e16) {
                a.this.a(e16, "prepare async error path", new Object[0]);
                if (a.this.f124803i != null) {
                    a.this.f124803i.c(-1, -1);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class i implements g.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f124819a;

        public i(Runnable runnable) {
            this.f124819a = runnable;
        }

        @Override // com.tencent.luggage.wxa.xg.g.c
        public void a() {
            a.this.b("onDataSourceSet#openVideo", new Object[0]);
            if (Looper.getMainLooper() == Looper.myLooper()) {
                this.f124819a.run();
            } else {
                a.this.post(this.f124819a);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class j implements g.i {
        public j() {
        }

        @Override // com.tencent.luggage.wxa.xg.g.i
        public void a(com.tencent.luggage.wxa.xg.g gVar, int i3, int i16) {
            a aVar;
            com.tencent.luggage.wxa.xg.g gVar2;
            try {
                aVar = a.this;
                gVar2 = aVar.f124798d;
            } catch (Exception e16) {
                a.this.a(e16, "on video size changed error[%d, %d]", Integer.valueOf(i3), Integer.valueOf(i16));
            }
            if (gVar == gVar2) {
                aVar.f124800f = gVar.getVideoWidth();
                a.this.f124801g = gVar.getVideoHeight();
                a.this.b("on size change size:( " + a.this.f124800f + " , " + a.this.f124801g + " )", new Object[0]);
                if (a.this.f124803i != null) {
                    a.this.f124803i.d(a.this.f124800f, a.this.f124801g);
                }
                a.this.g();
                return;
            }
            aVar.c("another player on video size changed, return now.[%s, %s]", gVar, gVar2);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class k implements g.h {
        public k() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class l implements g.f {
        public l() {
        }

        @Override // com.tencent.luggage.wxa.xg.g.f
        public void a(com.tencent.luggage.wxa.xg.g gVar) {
            int i3;
            int i16;
            a aVar = a.this;
            com.tencent.luggage.wxa.xg.g gVar2 = aVar.f124798d;
            if (gVar != gVar2 && gVar != null) {
                aVar.c("another player callback, release now.[%s, %s]", gVar, gVar2);
                a.this.a(gVar);
                return;
            }
            aVar.f124799e = true;
            a aVar2 = a.this;
            if (gVar != null) {
                i3 = gVar.getVideoWidth();
            } else {
                i3 = 0;
            }
            aVar2.f124800f = i3;
            a aVar3 = a.this;
            if (gVar != null) {
                i16 = gVar.getVideoHeight();
            } else {
                i16 = 0;
            }
            aVar3.f124801g = i16;
            a aVar4 = a.this;
            aVar4.b("on prepared. size [%d, %d] mStartWhenPrepared %b ", Integer.valueOf(aVar4.f124800f), Integer.valueOf(a.this.f124801g), Boolean.valueOf(a.this.f124802h));
            a.this.g();
            if (a.this.f124800f != 0 && a.this.f124801g != 0) {
                if (a.this.f124802h) {
                    a.this.f124798d.start();
                    a aVar5 = a.this;
                    aVar5.f124798d.a(aVar5.F);
                    a.this.f124802h = false;
                }
            } else if (a.this.f124802h) {
                a.this.f124798d.start();
                a.this.f124802h = false;
                a aVar6 = a.this;
                aVar6.f124798d.a(aVar6.F);
            }
            if (a.this.f124803i != null) {
                a.this.f124803i.a();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class m implements g.InterfaceC6908g {
        public m() {
        }

        @Override // com.tencent.luggage.wxa.xg.g.InterfaceC6908g
        public void a(com.tencent.luggage.wxa.xg.g gVar) {
            int i3;
            if (gVar != null) {
                i3 = gVar.getCurrentPosition();
            } else {
                i3 = -1;
            }
            a.this.b("video seek complete curPos[%d] mStartWhenPrepared[%b] pauseWhenUpdated[%b]", Integer.valueOf(i3), Boolean.valueOf(a.this.f124802h), Boolean.valueOf(a.this.S));
            if (a.this.f124802h) {
                if (a.this.S) {
                    return;
                } else {
                    a.this.start();
                }
            } else {
                a.this.pause();
            }
            if (a.this.f124805k != null) {
                a.this.f124805k.a(a.this.f124802h);
            }
            a.this.Q = 0L;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class n implements g.a {
        public n() {
        }

        @Override // com.tencent.luggage.wxa.xg.g.a
        public void a(com.tencent.luggage.wxa.xg.g gVar, int i3) {
            a.this.a("onBufferingUpdate percent[%d]", Integer.valueOf(i3));
            a.this.E = i3;
        }
    }

    public a(Context context) {
        this(context, null);
    }

    public abstract com.tencent.luggage.wxa.xg.g a();

    @Override // com.tencent.luggage.wxa.eh.d
    public int getCurrentPosition() {
        com.tencent.luggage.wxa.xg.g gVar = this.f124798d;
        if (gVar != null && this.f124799e) {
            return gVar.getCurrentPosition();
        }
        if (gVar == null) {
            return -1;
        }
        return 0;
    }

    public int getDownloadPercent() {
        return this.E;
    }

    @Override // com.tencent.luggage.wxa.eh.d
    public int getDuration() {
        com.tencent.luggage.wxa.xg.g gVar = this.f124798d;
        if (gVar != null && this.f124799e) {
            int i3 = this.f124795b;
            if (i3 > 0) {
                return i3;
            }
            int duration = gVar.getDuration();
            this.f124795b = duration;
            return duration;
        }
        this.f124795b = -1;
        return -1;
    }

    public double getLastProgresstime() {
        return 0.0d;
    }

    @Override // com.tencent.luggage.wxa.eh.d
    public long getLastSurfaceUpdateTime() {
        return this.Q;
    }

    @Override // com.tencent.luggage.wxa.eh.d
    public String getVideoPath() {
        return this.f124793a;
    }

    @Override // com.tencent.luggage.wxa.eh.d
    public boolean isPlaying() {
        boolean z16;
        com.tencent.luggage.wxa.xg.g gVar = this.f124798d;
        if (gVar != null && this.f124799e && !this.S && !this.T) {
            z16 = gVar.isPlaying();
        } else {
            z16 = false;
        }
        a("is playing result [%b] pauseWhenUpdated[%b] mIsPrepared[%b]", Boolean.valueOf(z16), Boolean.valueOf(this.S), Boolean.valueOf(this.f124799e));
        return z16;
    }

    @Override // android.view.View
    public void onMeasure(int i3, int i16) {
        if (this.f124800f != 0 && this.f124801g != 0) {
            this.f124794a0.a(View.getDefaultSize(1, i3), View.getDefaultSize(1, i16), this.f124800f, this.f124801g);
            com.tencent.luggage.wxa.eh.e eVar = this.f124794a0;
            setMeasuredDimension(eVar.f124862g, eVar.f124863h);
            return;
        }
        setMeasuredDimension(1, 1);
    }

    @Override // com.tencent.luggage.wxa.eh.d
    public void pause() {
        com.tencent.luggage.wxa.xg.g gVar = this.f124798d;
        if (gVar != null && this.f124799e && gVar.isPlaying()) {
            a("pause video.", new Object[0]);
            this.f124798d.pause();
        }
        this.f124802h = false;
    }

    public void setForceScaleFullScreen(boolean z16) {
        this.G = z16;
        this.f124794a0.f124856a = z16;
    }

    public void setLoop(boolean z16) {
        com.tencent.luggage.wxa.xg.g gVar = this.f124798d;
        if (gVar != null) {
            gVar.a(z16);
        }
        this.F = true;
    }

    @Override // com.tencent.luggage.wxa.eh.d
    public void setMinBufferDuration(long j3) {
        b("set minBufferDuration %d", Long.valueOf(j3));
        this.W = j3;
        com.tencent.luggage.wxa.xg.g gVar = this.f124798d;
        if (gVar != null) {
            gVar.setMinBufferDuration(j3);
        }
    }

    @Override // com.tencent.luggage.wxa.eh.d
    public void setMute(boolean z16) {
        b("set mute %b", Boolean.valueOf(z16));
        this.V = z16;
        com.tencent.luggage.wxa.xg.g gVar = this.f124798d;
        if (gVar != null) {
            if (z16) {
                gVar.a(0.0f, 0.0f);
            } else {
                gVar.a(1.0f, 1.0f);
            }
        }
    }

    @Override // com.tencent.luggage.wxa.eh.d
    public void setOnInfoCallback(d.b bVar) {
        this.f124806l = bVar;
    }

    @Override // com.tencent.luggage.wxa.eh.d
    public void setOnSeekCompleteCallback(d.c cVar) {
        this.f124805k = cVar;
    }

    @Override // com.tencent.luggage.wxa.eh.d
    public void setOnSurfaceCallback(d.InterfaceC6170d interfaceC6170d) {
        this.f124807m = interfaceC6170d;
    }

    @Override // com.tencent.luggage.wxa.eh.d
    public void setOneTimeVideoTextureUpdateCallback(d.e eVar) {
        this.f124804j = eVar;
    }

    public void setScaleType(g.h hVar) {
        this.f124794a0.a(hVar);
        requestLayout();
    }

    @Override // com.tencent.luggage.wxa.eh.d
    public void setVideoCallback(d.a aVar) {
        this.f124803i = aVar;
    }

    public void setVideoContext(@NonNull com.tencent.luggage.wxa.mg.k kVar) {
        this.H = kVar;
    }

    @Override // com.tencent.luggage.wxa.eh.d
    public void setVideoPath(String str) {
        this.f124793a = str;
        this.f124802h = false;
        d();
        requestLayout();
    }

    @Override // com.tencent.luggage.wxa.eh.d
    public boolean start() {
        if (this.f124797c == null) {
            c("it surface not ready, do not start", new Object[0]);
            this.R = true;
            this.f124802h = true;
            return false;
        }
        long j3 = this.C;
        if (j3 == 0) {
            j3 = w0.d();
        }
        this.C = j3;
        b("start %d mIsPrepared %b pauseWhenUpdated %b mediaPlayer %s", Long.valueOf(j3), Boolean.valueOf(this.f124799e), Boolean.valueOf(this.S), this.f124798d);
        com.tencent.luggage.wxa.xg.g gVar = this.f124798d;
        if (gVar != null && this.f124799e) {
            if (this.S) {
                this.S = false;
                setMute(this.V);
            }
            this.f124798d.start();
            this.f124802h = true;
            return true;
        }
        if (gVar == null && this.f124799e) {
            this.f124802h = true;
            d();
            requestLayout();
            return true;
        }
        this.f124802h = true;
        return false;
    }

    @Override // com.tencent.luggage.wxa.eh.d
    public void stop() {
        long j3;
        long j16;
        long j17 = this.D;
        if (j17 > 0) {
            j3 = j17 - this.C;
        } else {
            j3 = TTL.MAX_VALUE;
        }
        long d16 = w0.d() - this.C;
        if (j3 > d16) {
            j16 = d16;
        } else {
            j16 = j3;
        }
        int i3 = ((int) j16) * 1000;
        if (i3 > getDuration()) {
            i3 = getDuration();
        }
        b("stop : dur:%d stop:%d comp:%d", Integer.valueOf(getDuration()), Long.valueOf(d16), Long.valueOf(j3));
        d.a aVar = this.f124803i;
        if (aVar != null) {
            aVar.a(i3, getDuration());
        }
        e();
        this.f124794a0.a();
        f();
        this.f124793a = "";
        this.E = 0;
        this.f124799e = false;
        this.f124802h = false;
        this.Q = 0L;
    }

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void f() {
        SurfaceTexture surfaceTexture;
        try {
            if (this.f124797c == null || !this.f124799e || (surfaceTexture = getSurfaceTexture()) == null) {
                return;
            }
            b("releaseSurface", new Object[0]);
            a(surfaceTexture);
        } catch (Exception e16) {
            a(e16, "release surface", new Object[0]);
        }
    }

    public final void g() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
        layoutParams.addRule(13);
        setLayoutParams(layoutParams);
    }

    public a(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f124797c = null;
        this.f124798d = null;
        this.C = 0L;
        this.D = 0L;
        this.E = 0;
        this.F = false;
        this.G = false;
        this.H = null;
        this.I = new j();
        this.J = new k();
        this.K = new l();
        this.L = new m();
        this.M = new n();
        this.N = new C6168a();
        this.O = new b();
        this.P = new c();
        this.Q = 0L;
        this.R = false;
        this.S = false;
        this.T = false;
        this.U = new d();
        this.V = false;
        this.W = 10000L;
        this.f124794a0 = new com.tencent.luggage.wxa.eh.e();
        this.f124796b0 = -1.0f;
        c();
    }

    public final void d() {
        if (w0.c(this.f124793a) || this.f124797c == null) {
            b("MicroMsg.Video.AbstractVideoTextureView", "openVideo, try later, url:%s, surface:%s", this.f124793a, this.f124797c);
            return;
        }
        e();
        b("MicroMsg.Video.AbstractVideoTextureView", "open video %s", this.f124793a);
        try {
            com.tencent.luggage.wxa.xg.g a16 = a();
            this.f124798d = a16;
            a16.a(this.K);
            this.f124798d.a(this.I);
            this.f124798d.a(this.J);
            this.f124799e = false;
            this.f124795b = -1;
            this.E = 0;
            this.f124798d.a(this.O);
            this.f124798d.a(this.P);
            this.f124798d.a(this.L);
            this.f124798d.a(this.M);
            this.f124798d.a(this.N);
            h hVar = new h();
            if (!w0.c(this.f124793a)) {
                this.f124798d.setMinBufferDuration(this.W);
                this.f124798d.a(this.f124793a, null, new i(hVar));
            } else {
                hVar.run();
            }
            b("open video success player[%s]", this.f124798d);
        } catch (Exception e16) {
            a(e16, "prepare async error path", new Object[0]);
            d.a aVar = this.f124803i;
            if (aVar != null) {
                aVar.c(-1, -1);
            }
        }
    }

    public final void e() {
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(this.f124799e);
        objArr[1] = Boolean.valueOf(this.f124798d == null);
        b("release media player isPrepared[%b] player is null[%b] ", objArr);
        com.tencent.luggage.wxa.xg.g gVar = this.f124798d;
        if (gVar != null) {
            gVar.a((g.d) null);
            this.f124798d.a((g.i) null);
            this.f124798d.a((g.h) null);
            try {
                this.f124798d.stop();
            } catch (Exception e16) {
                a(e16, "stop media player error", new Object[0]);
            }
            com.tencent.luggage.wxa.zp.h.f146825d.execute(new f(this.f124798d));
            this.f124798d = null;
        }
    }

    public final void c() {
        this.f124800f = 0;
        this.f124801g = 0;
        setSurfaceTextureListener(this.U);
        setFocusable(true);
        setFocusableInTouchMode(true);
    }

    public void b() {
        Surface surface;
        if (this.f124798d == null || !this.f124799e || (surface = this.f124797c) == null || !surface.isValid()) {
            return;
        }
        b("flush surface start time[%d] ", Integer.valueOf(getCurrentPosition()));
        this.T = true;
        this.f124798d.a(0.0f, 0.0f);
        this.f124798d.start();
    }

    public final void a(SurfaceTexture surfaceTexture) {
        EGL10 egl10 = (EGL10) EGLContext.getEGL();
        EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        egl10.eglInitialize(eglGetDisplay, null);
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        egl10.eglChooseConfig(eglGetDisplay, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12344, 0, 12344}, eGLConfigArr, 1, new int[1]);
        EGLConfig eGLConfig = eGLConfigArr[0];
        EGLContext eglCreateContext = egl10.eglCreateContext(eglGetDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{EGLContextHolder.EGL_CONTEXT_CLIENT_VERSION, 2, 12344});
        EGLSurface eglCreateWindowSurface = egl10.eglCreateWindowSurface(eglGetDisplay, eGLConfig, surfaceTexture, new int[]{12344});
        egl10.eglMakeCurrent(eglGetDisplay, eglCreateWindowSurface, eglCreateWindowSurface, eglCreateContext);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GLES20.glClear(16384);
        egl10.eglSwapBuffers(eglGetDisplay, eglCreateWindowSurface);
        egl10.eglDestroySurface(eglGetDisplay, eglCreateWindowSurface);
        EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
        egl10.eglMakeCurrent(eglGetDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
        egl10.eglDestroyContext(eglGetDisplay, eglCreateContext);
        egl10.eglTerminate(eglGetDisplay);
    }

    public final void c(String str, Object... objArr) {
        w.h("MicroMsg.Video.AbstractVideoTextureView", this.H + " " + str, objArr);
    }

    public final void b(String str, Object... objArr) {
        w.d("MicroMsg.Video.AbstractVideoTextureView", this.H + " " + str, objArr);
    }

    public final void a(com.tencent.luggage.wxa.xg.g gVar) {
        new g(gVar).start();
    }

    public void a(Surface surface) {
        com.tencent.luggage.wxa.zp.h.f146825d.execute(new e(surface));
    }

    @Override // com.tencent.luggage.wxa.eh.d
    public void a(double d16) {
        com.tencent.luggage.wxa.xg.g gVar = this.f124798d;
        if (gVar != null) {
            gVar.a((int) d16);
            this.f124802h = true;
            a("seek to time: " + d16 + " curr pos : " + this.f124798d.getCurrentPosition(), new Object[0]);
        }
    }

    @Override // com.tencent.luggage.wxa.eh.d
    public void a(double d16, boolean z16) {
        a(d16);
        this.f124802h = z16;
    }

    public void setPlayProgressCallback(boolean z16) {
    }

    public void setThumb(Bitmap bitmap) {
    }

    public boolean a(float f16) {
        if (f16 <= 0.0f) {
            return false;
        }
        this.f124796b0 = f16;
        com.tencent.luggage.wxa.xg.g gVar = this.f124798d;
        if (gVar != null) {
            gVar.a(f16);
        }
        return false;
    }

    public final void a(String str, Object... objArr) {
        w.a("MicroMsg.Video.AbstractVideoTextureView", this.H + " " + str, objArr);
    }

    public final void a(Throwable th5, String str, Object... objArr) {
        w.a("MicroMsg.Video.AbstractVideoTextureView", th5, this.H + " " + str, objArr);
    }
}
