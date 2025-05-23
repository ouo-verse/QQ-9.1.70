package com.tencent.luggage.wxa.mg;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.luggage.wxa.mg.g;
import com.tencent.luggage.wxa.p004if.o;
import com.tencent.luggage.wxa.p004if.p;
import com.tencent.luggage.wxa.so.c;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b extends RelativeLayout implements g, g.c {
    public static final com.tencent.luggage.wxa.so.c I = com.tencent.luggage.wxa.so.c.a(new c.a() { // from class: i31.b
        @Override // com.tencent.luggage.wxa.so.c.a
        public final Object a() {
            return com.tencent.luggage.wxa.mg.b.b();
        }
    });
    public static final com.tencent.luggage.wxa.so.c J = com.tencent.luggage.wxa.so.c.a(new c.a() { // from class: i31.c
        @Override // com.tencent.luggage.wxa.so.c.a
        public final Object a() {
            return com.tencent.luggage.wxa.mg.b.e();
        }
    });
    public int C;
    public com.tencent.luggage.wxa.xd.d D;
    public final com.tencent.luggage.wxa.p004if.o E;
    public boolean F;
    public int G;
    public k H;

    /* renamed from: a, reason: collision with root package name */
    public final Context f134531a;

    /* renamed from: b, reason: collision with root package name */
    public g f134532b;

    /* renamed from: c, reason: collision with root package name */
    public h f134533c;

    /* renamed from: d, reason: collision with root package name */
    public g.c f134534d;

    /* renamed from: e, reason: collision with root package name */
    public g.b f134535e;

    /* renamed from: f, reason: collision with root package name */
    public g.h f134536f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f134537g;

    /* renamed from: h, reason: collision with root package name */
    public long f134538h;

    /* renamed from: i, reason: collision with root package name */
    public float f134539i;

    /* renamed from: j, reason: collision with root package name */
    public int f134540j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f134541k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f134542l;

    /* renamed from: m, reason: collision with root package name */
    public String f134543m;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements p.a {
        public a() {
        }

        @Override // com.tencent.luggage.wxa.if.p.a
        public void onPause() {
            b.this.b(MiniSDKConst.NOTIFY_EVENT_ONPAUSE, new Object[0]);
            b.this.pause();
        }

        @Override // com.tencent.luggage.wxa.if.p.a
        public void onResume() {
            b.this.b("onResume", new Object[0]);
            b.this.c();
        }

        @Override // com.tencent.luggage.wxa.if.p.a
        public void onStop() {
            b.this.b(DKHippyEvent.EVENT_STOP, new Object[0]);
            b.this.stop();
        }
    }

    public b(Context context) {
        this(context, null);
    }

    public static /* synthetic */ h b() {
        return (h) com.tencent.luggage.wxa.eo.g.a(h.class);
    }

    public static /* synthetic */ o.a e() {
        o.a aVar = (o.a) com.tencent.luggage.wxa.eo.g.a(o.a.class);
        return aVar != null ? aVar : com.tencent.luggage.wxa.ng.b.f135811b;
    }

    @Override // com.tencent.luggage.wxa.mg.g
    public boolean c() {
        if (this.f134532b == null) {
            return false;
        }
        setKeepScreenOn(true);
        return this.f134532b.c();
    }

    @Override // com.tencent.luggage.wxa.mg.g
    public void d() {
        g gVar = this.f134532b;
        if (gVar != null) {
            gVar.d();
        }
    }

    @Override // com.tencent.luggage.wxa.mg.g
    public void f() {
        g gVar = this.f134532b;
        if (gVar != null) {
            gVar.f();
        }
        if (this.F) {
            this.E.a();
        }
        setKeepScreenOn(false);
    }

    @Override // com.tencent.luggage.wxa.mg.g
    public void g() {
        g gVar = this.f134532b;
        if (gVar != null) {
            gVar.g();
        }
        if (this.F) {
            this.E.a();
        }
        setKeepScreenOn(false);
    }

    @Override // com.tencent.luggage.wxa.mg.g
    public int getCacheTimeSec() {
        g gVar = this.f134532b;
        if (gVar != null) {
            return gVar.getCacheTimeSec();
        }
        return 0;
    }

    @Override // com.tencent.luggage.wxa.mg.g
    public int getCurrPosMs() {
        g gVar = this.f134532b;
        if (gVar != null) {
            return gVar.getCurrPosMs();
        }
        return 0;
    }

    @Override // com.tencent.luggage.wxa.mg.g
    public int getCurrPosSec() {
        g gVar = this.f134532b;
        if (gVar != null) {
            return gVar.getCurrPosSec();
        }
        return 0;
    }

    @Override // com.tencent.luggage.wxa.mg.g
    public int getPlayerType() {
        g gVar = this.f134532b;
        if (gVar != null) {
            return gVar.getPlayerType();
        }
        return 0;
    }

    public TextureView getTexture() {
        g gVar = this.f134532b;
        if (gVar != null && (gVar.getView() instanceof com.tencent.luggage.wxa.fh.a)) {
            return ((com.tencent.luggage.wxa.fh.a) this.f134532b.getView()).C();
        }
        return null;
    }

    @Override // com.tencent.luggage.wxa.mg.g
    public int getVideoDurationSec() {
        g gVar = this.f134532b;
        if (gVar != null) {
            return gVar.getVideoDurationSec();
        }
        return this.f134540j;
    }

    @Override // com.tencent.luggage.wxa.mg.g
    public boolean i() {
        g gVar = this.f134532b;
        if (gVar != null) {
            return gVar.i();
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.mg.g
    public boolean isPlaying() {
        g gVar = this.f134532b;
        if (gVar != null) {
            return gVar.isPlaying();
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.mg.g
    public void j() {
        b("preload video url %s", this.f134543m);
        if (!w0.c(this.f134543m)) {
            this.f134532b.j();
        }
    }

    @Override // com.tencent.luggage.wxa.mg.g
    public boolean pause() {
        if (this.f134532b == null) {
            return false;
        }
        setKeepScreenOn(false);
        return this.f134532b.pause();
    }

    @Override // com.tencent.luggage.wxa.mg.g
    public void setCover(Bitmap bitmap) {
        g gVar = this.f134532b;
        if (gVar != null) {
            gVar.setCover(bitmap);
        }
    }

    public void setFocusAudio(boolean z16) {
        this.F = z16;
    }

    @Override // com.tencent.luggage.wxa.mg.g
    public void setFullDirection(int i3) {
        g gVar = this.f134532b;
        if (gVar != null) {
            gVar.setFullDirection(i3);
        }
    }

    public void setHostComponent(@Nullable com.tencent.luggage.wxa.xd.d dVar) {
        this.D = dVar;
    }

    @Override // com.tencent.luggage.wxa.mg.g
    public void setIMMVideoViewCallback(g.c cVar) {
        this.f134534d = cVar;
    }

    @Override // com.tencent.luggage.wxa.mg.g
    public void setIsShowBasicControls(boolean z16) {
        g gVar = this.f134532b;
        if (gVar != null) {
            gVar.setIsShowBasicControls(z16);
        }
    }

    @Override // android.view.View
    public void setKeepScreenOn(boolean z16) {
        a("set keep screen on:%s", Boolean.valueOf(z16));
        super.setKeepScreenOn(z16);
    }

    @Override // com.tencent.luggage.wxa.mg.g
    public void setMinBufferDuration(long j3) {
        this.f134538h = j3;
        g gVar = this.f134532b;
        if (gVar != null) {
            gVar.setMinBufferDuration(j3);
        }
    }

    @Override // com.tencent.luggage.wxa.mg.g
    public void setMute(boolean z16) {
        this.f134537g = z16;
        g gVar = this.f134532b;
        if (gVar != null) {
            gVar.setMute(z16);
        }
    }

    public void setMyVideoViewFactory(@NonNull h hVar) {
        b("setMyVideoViewFactory, videoViewFactory: " + hVar.getName(), new Object[0]);
        this.f134533c = hVar;
    }

    public void setPlayerHint(int i3) {
        b("setPlayerHint, playerHint: " + i3, new Object[0]);
        this.G = i3;
    }

    @Override // com.tencent.luggage.wxa.mg.g
    public void setScaleType(g.h hVar) {
        this.f134536f = hVar;
        g gVar = this.f134532b;
        if (gVar != null) {
            gVar.setScaleType(hVar);
        }
    }

    @Override // com.tencent.luggage.wxa.mg.g
    public void setVideoContext(@NonNull k kVar) {
        this.H = kVar;
        g gVar = this.f134532b;
        if (gVar != null) {
            gVar.setVideoContext(kVar);
        }
    }

    @Override // com.tencent.luggage.wxa.mg.g
    public void setVideoFooterView(g.b bVar) {
        this.f134535e = bVar;
        g gVar = this.f134532b;
        if (gVar != null) {
            gVar.setVideoFooterView(bVar);
        }
    }

    @Override // com.tencent.luggage.wxa.mg.g
    public void setVideoSource(int i3) {
        this.C = i3;
    }

    @Override // com.tencent.luggage.wxa.mg.g
    public void start() {
        g gVar = this.f134532b;
        if (gVar != null) {
            gVar.start();
            setKeepScreenOn(true);
        }
    }

    @Override // com.tencent.luggage.wxa.mg.g
    public void stop() {
        g gVar = this.f134532b;
        if (gVar != null) {
            gVar.stop();
            if (this.F) {
                this.E.a();
            }
            setKeepScreenOn(false);
        }
    }

    public b(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // com.tencent.luggage.wxa.mg.g.c
    public void b(String str, String str2) {
        b("onVideoPause", new Object[0]);
        setKeepScreenOn(false);
        if (this.F) {
            this.E.a();
        }
        g.c cVar = this.f134534d;
        if (cVar != null) {
            cVar.b(str, str2);
        }
    }

    public b(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f134533c = null;
        this.f134536f = g.h.CONTAIN;
        this.f134537g = false;
        this.f134538h = 10000L;
        this.f134539i = -1.0f;
        this.C = 0;
        this.D = null;
        this.F = true;
        this.G = 0;
        this.H = null;
        this.f134531a = context;
        this.f134533c = (h) I.b();
        this.E = ((o.a) J.b()).a(new Function0() { // from class: i31.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                com.tencent.luggage.wxa.xd.d a16;
                a16 = com.tencent.luggage.wxa.mg.b.this.a();
                return a16;
            }
        }, new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ com.tencent.luggage.wxa.xd.d a() {
        return this.D;
    }

    @Override // com.tencent.luggage.wxa.mg.g.c
    public void d(String str, String str2) {
        g.c cVar = this.f134534d;
        if (cVar != null) {
            cVar.d(str, str2);
        }
    }

    @Override // com.tencent.luggage.wxa.mg.g.c
    public void e(String str, String str2) {
        g.c cVar = this.f134534d;
        if (cVar != null) {
            cVar.e(str, str2);
        }
    }

    @Override // com.tencent.luggage.wxa.mg.g
    public void a(boolean z16, String str, int i3) {
        this.f134540j = i3;
        this.f134541k = z16;
        com.tencent.luggage.wxa.dn.e eVar = new com.tencent.luggage.wxa.dn.e();
        eVar.f124399a = str;
        this.f134542l = a(eVar);
        this.f134543m = eVar.f124399a;
        g gVar = this.f134532b;
        boolean z17 = false;
        if (gVar == null) {
            h hVar = this.f134533c;
            b("setVideoPath, videoViewFactory: " + hVar.getName(), new Object[0]);
            g a16 = hVar.a(this.f134531a, this.G);
            this.f134532b = a16;
            k kVar = this.H;
            if (kVar != null) {
                a16.setVideoContext(kVar);
            }
            this.f134532b.setMinBufferDuration(this.f134538h);
            this.f134532b.setVideoSource(this.C);
            this.f134532b.setIMMVideoViewCallback(this);
            z17 = true;
        } else {
            gVar.stop();
        }
        setScaleType(this.f134536f);
        a(this.f134539i);
        setMute(this.f134537g);
        if (z17) {
            setVideoFooterView(this.f134535e);
            addView(this.f134532b.getView(), new RelativeLayout.LayoutParams(-1, -1));
        }
        this.f134532b.a(this.f134541k, this.f134543m, this.f134540j);
    }

    @Override // com.tencent.luggage.wxa.mg.g.c
    public void c(String str, String str2) {
        b("onVideoPlay", new Object[0]);
        setKeepScreenOn(true);
        if (this.F) {
            this.E.b();
        }
        g.c cVar = this.f134534d;
        if (cVar != null) {
            cVar.c(str, str2);
        }
    }

    @Override // com.tencent.luggage.wxa.mg.g.c
    public void f(String str, String str2) {
        b("onVideoEnded", new Object[0]);
        g.c cVar = this.f134534d;
        if (cVar != null) {
            cVar.f(str, str2);
        }
    }

    public final void b(String str, Object... objArr) {
        w.d("MicroMsg.Video.AppBrandVideoWrapper", this.H + " " + str, objArr);
    }

    public final void c(String str, Object... objArr) {
        w.h("MicroMsg.Video.AppBrandVideoWrapper", this.H + " " + str, objArr);
    }

    @Override // com.tencent.luggage.wxa.mg.g
    public View getView() {
        return this;
    }

    public final boolean a(com.tencent.luggage.wxa.dn.e eVar) {
        if (w0.c(eVar.f124399a) || eVar.f124399a.indexOf("file://") != 0) {
            return false;
        }
        eVar.f124399a = eVar.f124399a.substring(7);
        return true;
    }

    @Override // com.tencent.luggage.wxa.mg.g
    public boolean a(double d16) {
        g gVar = this.f134532b;
        if (gVar != null) {
            return gVar.a(d16);
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.mg.g
    public boolean a(double d16, boolean z16) {
        g gVar = this.f134532b;
        if (gVar != null) {
            return gVar.a(d16, z16);
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.mg.g
    public boolean a(float f16) {
        if (f16 <= 0.0f) {
            return false;
        }
        this.f134539i = f16;
        g gVar = this.f134532b;
        if (gVar != null) {
            return gVar.a(f16);
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.mg.g.c
    public void a(String str, String str2, String str3, int i3, int i16) {
        c("onError[%s %d, %d]", str3, Integer.valueOf(i3), Integer.valueOf(i16));
        g.c cVar = this.f134534d;
        if (cVar != null) {
            cVar.a(str, str2, str3, i3, i16);
        }
    }

    @Override // com.tencent.luggage.wxa.mg.g.c
    public void a(String str, String str2) {
        b("onPrepared", new Object[0]);
        g.c cVar = this.f134534d;
        if (cVar != null) {
            cVar.a(str, str2);
        }
    }

    @Override // com.tencent.luggage.wxa.mg.g.c
    public void a(String str, String str2, int i3, int i16) {
        b("onGetVideoSize[%d %d]", Integer.valueOf(i3), Integer.valueOf(i16));
        g.c cVar = this.f134534d;
        if (cVar != null) {
            cVar.a(str, str2, i3, i16);
        }
    }

    public final void a(String str, Object... objArr) {
        w.a("MicroMsg.Video.AppBrandVideoWrapper", this.H + " " + str, objArr);
    }
}
