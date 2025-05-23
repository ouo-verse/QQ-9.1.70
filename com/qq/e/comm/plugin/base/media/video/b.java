package com.qq.e.comm.plugin.base.media.video;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.qq.e.comm.plugin.base.media.video.GDTVideoView;
import com.qq.e.comm.plugin.base.media.video.e;
import com.qq.e.comm.plugin.k.aa;
import com.qq.e.comm.plugin.k.ak;
import com.qq.e.comm.util.GDTLogger;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b extends FrameLayout implements com.qq.e.comm.plugin.base.media.video.c, e.a {
    private c A;
    private int B;
    private WeakReference<View> C;
    private g D;
    private f E;
    private View.OnClickListener F;
    private View.OnClickListener G;
    private View.OnClickListener H;
    private View.OnClickListener I;
    private final GDTVideoView.a J;
    private final Handler K;

    /* renamed from: a, reason: collision with root package name */
    private h f39235a;

    /* renamed from: b, reason: collision with root package name */
    private e f39236b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f39237c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f39238d;

    /* renamed from: e, reason: collision with root package name */
    private int f39239e;

    /* renamed from: f, reason: collision with root package name */
    private a f39240f;

    /* renamed from: g, reason: collision with root package name */
    private FrameLayout f39241g;

    /* renamed from: h, reason: collision with root package name */
    private FrameLayout f39242h;

    /* renamed from: i, reason: collision with root package name */
    private ImageView f39243i;

    /* renamed from: j, reason: collision with root package name */
    private ImageView f39244j;

    /* renamed from: k, reason: collision with root package name */
    private ImageView f39245k;

    /* renamed from: l, reason: collision with root package name */
    private ImageView f39246l;

    /* renamed from: m, reason: collision with root package name */
    private com.qq.e.comm.plugin.base.widget.a f39247m;

    /* renamed from: n, reason: collision with root package name */
    private com.qq.e.comm.plugin.base.widget.e f39248n;

    /* renamed from: o, reason: collision with root package name */
    private Context f39249o;

    /* renamed from: p, reason: collision with root package name */
    private ImageView f39250p;

    /* renamed from: q, reason: collision with root package name */
    private String f39251q;

    /* renamed from: r, reason: collision with root package name */
    private int f39252r;

    /* renamed from: s, reason: collision with root package name */
    private int f39253s;

    /* renamed from: t, reason: collision with root package name */
    private int f39254t;

    /* renamed from: u, reason: collision with root package name */
    private int f39255u;

    /* renamed from: v, reason: collision with root package name */
    private int f39256v;

    /* renamed from: w, reason: collision with root package name */
    private int f39257w;

    /* renamed from: x, reason: collision with root package name */
    private boolean f39258x;

    /* renamed from: y, reason: collision with root package name */
    private boolean f39259y;

    /* renamed from: z, reason: collision with root package name */
    private boolean f39260z;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface a extends d {
        void b(boolean z16);

        void c(boolean z16);

        void q();
    }

    /* compiled from: P */
    /* renamed from: com.qq.e.comm.plugin.base.media.video.b$b, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private static class HandlerC0285b extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<b> f39271a;

        public HandlerC0285b(b bVar) {
            this.f39271a = new WeakReference<>(bVar);
        }

        private void a(b bVar) {
            if (bVar != null) {
                bVar.v();
                if (bVar.f39235a != null && bVar.f39235a.c()) {
                    sendMessageDelayed(obtainMessage(10002), 500L);
                }
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            b bVar = this.f39271a.get();
            if (bVar != null) {
                switch (message.what) {
                    case 10001:
                        if (bVar.f39235a != null && bVar.f39235a.c()) {
                            bVar.d();
                            return;
                        }
                        Message obtainMessage = obtainMessage(10001);
                        removeMessages(10001);
                        sendMessageDelayed(obtainMessage, 3000L);
                        return;
                    case 10002:
                        a(bVar);
                        return;
                    case 10003:
                        try {
                            bVar.setEnabled(false);
                            return;
                        } catch (Throwable th5) {
                            th5.printStackTrace();
                            return;
                        }
                    case 10004:
                        a(bVar);
                        bVar.d(true);
                        if (bVar.f39250p != null) {
                            bVar.f39250p.setVisibility(4);
                        }
                        bVar.a();
                        bVar.e();
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface c {
        void a();
    }

    public b(Context context, int i3, String str, boolean z16, boolean z17) {
        super(context);
        this.f39260z = false;
        this.B = Integer.MIN_VALUE;
        this.F = new View.OnClickListener() { // from class: com.qq.e.comm.plugin.base.media.video.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                if (b.this.f39240f != null) {
                    b.this.f39240f.q();
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        };
        this.G = new View.OnClickListener() { // from class: com.qq.e.comm.plugin.base.media.video.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                if (b.this.f39240f != null) {
                    b.this.f39240f.p();
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        };
        this.H = new View.OnClickListener() { // from class: com.qq.e.comm.plugin.base.media.video.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                b.this.q();
                EventCollector.getInstance().onViewClicked(view);
            }
        };
        this.I = new View.OnClickListener() { // from class: com.qq.e.comm.plugin.base.media.video.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                if (b.this.f39240f != null) {
                    b.this.f39240f.b(b.this.f39235a.c());
                }
                if (!b.this.f39238d) {
                    b.this.r();
                    b.this.a(3000, false);
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        };
        this.J = new GDTVideoView.b() { // from class: com.qq.e.comm.plugin.base.media.video.b.6
            @Override // com.qq.e.comm.plugin.base.media.video.GDTVideoView.b
            public void a(int i16) {
                if (b.this.f39240f != null) {
                    b.this.f39240f.e(i16);
                }
            }

            @Override // com.qq.e.comm.plugin.base.media.video.GDTVideoView.a
            public void b() {
                if (b.this.f39240f != null) {
                    b.this.f39240f.j();
                }
            }

            @Override // com.qq.e.comm.plugin.base.media.video.GDTVideoView.a
            public void c() {
                b.this.K.sendEmptyMessage(10004);
                if (b.this.f39240f != null) {
                    b.this.f39240f.k();
                }
            }

            @Override // com.qq.e.comm.plugin.base.media.video.GDTVideoView.a
            public void d() {
                b.this.K.removeMessages(10002);
                if (b.this.f39248n != null) {
                    b.this.f39248n.a(100);
                }
                if (b.this.A != null) {
                    b.this.A.a();
                }
                if (b.this.f39240f != null) {
                    b.this.f39240f.l();
                }
                if (b.this.f39250p != null && b.this.f39259y) {
                    b.this.f39250p.setVisibility(0);
                }
                b.this.d(false);
                b.this.c(true);
            }

            @Override // com.qq.e.comm.plugin.base.media.video.GDTVideoView.a
            public void e() {
                b.this.K.sendEmptyMessage(10003);
                if (b.this.f39240f != null) {
                    b.this.f39240f.m();
                }
            }

            @Override // com.qq.e.comm.plugin.base.media.video.GDTVideoView.a
            public void f() {
                b.this.K.removeMessages(10002);
                if (b.this.f39240f != null) {
                    b.this.f39240f.n();
                }
            }

            @Override // com.qq.e.comm.plugin.base.media.video.GDTVideoView.a
            public void g() {
                b.this.K.sendEmptyMessage(10002);
                if (b.this.f39240f != null) {
                    b.this.f39240f.o();
                }
            }

            @Override // com.qq.e.comm.plugin.base.media.video.GDTVideoView.b
            public void a() {
                if (b.this.D != null) {
                    b.this.D.a();
                }
            }
        };
        this.K = new HandlerC0285b(this);
        this.f39251q = str;
        this.f39239e = i3;
        this.f39258x = z16;
        this.f39259y = z17;
        this.f39249o = context.getApplicationContext();
        k();
        l();
    }

    private void n() {
        int i3 = 0;
        if (this.f39242h == null) {
            this.f39242h = new FrameLayout(getContext());
            GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{Integer.MIN_VALUE, 1073741824, 0});
            gradientDrawable.setShape(0);
            this.f39242h.setBackgroundDrawable(gradientDrawable);
            this.f39242h.setPadding(0, 0, 0, this.f39252r);
        }
        this.f39241g.addView(this.f39242h, new FrameLayout.LayoutParams(-1, -2));
        this.f39242h.setVisibility(4);
        if (this.f39245k == null) {
            ImageView imageView = new ImageView(getContext());
            this.f39245k = imageView;
            imageView.setImageBitmap(i.e(this.f39249o));
            this.f39245k.setOnClickListener(this.G);
        }
        int i16 = this.f39254t;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i16, i16);
        layoutParams.gravity = 53;
        ImageView imageView2 = this.f39245k;
        int i17 = this.f39252r;
        imageView2.setPadding(i17 / 2, i17, i17, i17);
        this.f39245k.setLayoutParams(layoutParams);
        this.f39242h.addView(this.f39245k);
        if (this.f39244j == null) {
            ImageView imageView3 = new ImageView(getContext());
            this.f39244j = imageView3;
            imageView3.setImageBitmap(i.c(this.f39249o));
            this.f39244j.setOnClickListener(this.H);
        }
        int i18 = this.f39254t;
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i18, i18);
        layoutParams2.gravity = 53;
        layoutParams2.rightMargin = this.f39254t;
        ImageView imageView4 = this.f39244j;
        int i19 = this.f39252r;
        imageView4.setPadding(i19, i19, i19 / 2, i19);
        this.f39244j.setLayoutParams(layoutParams2);
        this.f39242h.addView(this.f39244j);
        if (this.f39250p == null && this.f39251q != null) {
            this.f39250p = new ImageView(getContext());
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
            layoutParams3.gravity = 17;
            this.f39241g.addView(this.f39250p, layoutParams3);
            com.qq.e.comm.plugin.base.media.a.c.a().a(this.f39251q, this.f39250p);
            ImageView imageView5 = this.f39250p;
            if (!this.f39259y) {
                i3 = 4;
            }
            imageView5.setVisibility(i3);
        }
        if (this.f39243i == null) {
            ImageView imageView6 = new ImageView(getContext());
            this.f39243i = imageView6;
            imageView6.setImageBitmap(i.a(this.f39249o));
            this.f39243i.setOnClickListener(this.F);
        }
        int i26 = this.f39254t;
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(i26, i26);
        layoutParams4.gravity = 51;
        ImageView imageView7 = this.f39243i;
        int i27 = this.f39252r;
        imageView7.setPadding(i27, i27, i27, i27);
        this.f39243i.setLayoutParams(layoutParams4);
        this.f39241g.addView(this.f39243i);
        if (this.f39246l == null) {
            ImageView imageView8 = new ImageView(getContext());
            this.f39246l = imageView8;
            imageView8.setImageBitmap(i.f(this.f39249o));
            this.f39246l.setOnClickListener(this.I);
        }
        int i28 = this.f39256v;
        FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(i28, i28);
        layoutParams5.gravity = 17;
        this.f39246l.setVisibility(4);
        if (!u()) {
            this.f39241g.addView(this.f39246l, layoutParams5);
        }
    }

    private void o() {
        if (this.f39247m == null) {
            this.f39247m = new com.qq.e.comm.plugin.base.widget.a(getContext());
            int i3 = this.f39256v;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i3, i3);
            layoutParams.gravity = 17;
            this.f39247m.setVisibility(4);
            this.f39241g.addView(this.f39247m, layoutParams);
        }
    }

    private void p() {
        if (this.f39235a instanceof GDTVideoView) {
            this.E = new f() { // from class: com.qq.e.comm.plugin.base.media.video.b.1
                @Override // com.qq.e.comm.plugin.base.media.video.f
                public void a() {
                    if (b.this.f39247m != null && b.this.f39247m.getVisibility() == 4) {
                        aa.a(new Runnable() { // from class: com.qq.e.comm.plugin.base.media.video.b.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.f39247m != null) {
                                    b.this.f39247m.setVisibility(0);
                                }
                            }
                        });
                    }
                }

                @Override // com.qq.e.comm.plugin.base.media.video.f
                public void b() {
                    if (b.this.f39247m != null && b.this.f39247m.getVisibility() == 0) {
                        aa.a(new Runnable() { // from class: com.qq.e.comm.plugin.base.media.video.b.1.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.f39247m != null) {
                                    b.this.f39247m.setVisibility(4);
                                }
                            }
                        });
                    }
                }
            };
            g gVar = new g((GDTVideoView) this.f39235a, new WeakReference(this.E));
            this.D = gVar;
            gVar.a(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        h hVar = this.f39235a;
        if (hVar == null) {
            GDTLogger.e("player is null in doVolumeOnOff");
            return;
        }
        if (hVar.d()) {
            this.f39235a.i();
        } else {
            this.f39235a.h();
        }
        a aVar = this.f39240f;
        if (aVar != null) {
            try {
                aVar.c(this.f39235a.d());
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        h hVar = this.f39235a;
        if (hVar == null) {
            GDTLogger.e("player is null in doPauseResume");
            return;
        }
        if (hVar.c()) {
            this.f39235a.b();
        } else {
            this.f39235a.a();
        }
        a();
    }

    private void s() {
        h hVar = this.f39235a;
        if (hVar != null && hVar.c()) {
            this.f39246l.setImageBitmap(i.g(this.f39249o));
        } else {
            this.f39246l.setImageBitmap(i.f(this.f39249o));
        }
    }

    private void t() {
        h hVar;
        if (u() && (hVar = this.f39235a) != null && !hVar.c()) {
            e(true);
        }
    }

    private boolean u() {
        WeakReference<View> weakReference = this.C;
        if (weakReference != null && weakReference.get() != null && this.B != Integer.MIN_VALUE) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int v() {
        h hVar = this.f39235a;
        if (hVar == null) {
            GDTLogger.e("player is null in setProgress");
            return 0;
        }
        int f16 = hVar.f();
        int e16 = this.f39235a.e();
        com.qq.e.comm.plugin.base.widget.e eVar = this.f39248n;
        if (eVar != null && e16 > 0) {
            eVar.a((f16 * 100) / e16);
        }
        return f16;
    }

    private void w() {
        ImageView imageView = this.f39243i;
        if (imageView != null && this.f39244j != null && this.f39246l != null && this.f39245k != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) imageView.getLayoutParams();
            int i3 = this.f39254t;
            layoutParams.width = i3;
            layoutParams.height = i3;
            ImageView imageView2 = this.f39243i;
            int i16 = this.f39252r;
            imageView2.setPadding(i16, i16, i16, i16);
            this.f39243i.setLayoutParams(layoutParams);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f39244j.getLayoutParams();
            layoutParams2.rightMargin = this.f39254t;
            ImageView imageView3 = this.f39244j;
            int i17 = this.f39252r;
            imageView3.setPadding(i17, i17, i17 / 2, i17);
            int i18 = this.f39254t;
            layoutParams2.width = i18;
            layoutParams2.height = i18;
            this.f39244j.setLayoutParams(layoutParams2);
            FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.f39245k.getLayoutParams();
            int i19 = this.f39254t;
            layoutParams3.width = i19;
            layoutParams3.height = i19;
            ImageView imageView4 = this.f39245k;
            int i26 = this.f39252r;
            imageView4.setPadding(i26 / 2, i26, i26, i26);
            this.f39245k.setLayoutParams(layoutParams3);
            FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) this.f39246l.getLayoutParams();
            int i27 = this.f39256v;
            layoutParams4.width = i27;
            layoutParams4.height = i27;
            this.f39246l.setLayoutParams(layoutParams4);
        }
    }

    private void x() {
        ImageView imageView = this.f39243i;
        if (imageView != null && this.f39244j != null && this.f39246l != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) imageView.getLayoutParams();
            int i3 = this.f39255u;
            layoutParams.width = i3;
            layoutParams.height = i3;
            ImageView imageView2 = this.f39243i;
            int i16 = this.f39253s;
            imageView2.setPadding(i16, i16, i16, i16);
            this.f39243i.setLayoutParams(layoutParams);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f39244j.getLayoutParams();
            int i17 = this.f39255u;
            layoutParams2.width = i17;
            layoutParams2.height = i17;
            layoutParams2.rightMargin = 0;
            ImageView imageView3 = this.f39244j;
            int i18 = this.f39253s;
            imageView3.setPadding(i18, i18, i18, i18);
            this.f39244j.setLayoutParams(layoutParams2);
            FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.f39246l.getLayoutParams();
            int i19 = this.f39257w;
            layoutParams3.width = i19;
            layoutParams3.height = i19;
            this.f39246l.setLayoutParams(layoutParams3);
        }
    }

    @Override // android.view.View, com.qq.e.comm.plugin.base.media.video.c
    public boolean isShown() {
        return this.f39237c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(boolean z16) {
        ImageView imageView = this.f39244j;
        if (imageView == null) {
            return;
        }
        if (this.f39239e == 12) {
            imageView.setVisibility(8);
        } else {
            imageView.setVisibility((!z16 || this.f39260z) ? 4 : 0);
        }
    }

    private void e(boolean z16) {
        WeakReference<View> weakReference = this.C;
        if (weakReference == null || weakReference.get() == null || !u()) {
            return;
        }
        if (z16) {
            this.C.get().setVisibility(0);
        } else {
            this.C.get().setVisibility(4);
        }
    }

    private void k() {
        this.f39252r = ak.a(this.f39249o, 12);
        this.f39253s = ak.a(this.f39249o, 12);
        this.f39254t = ak.a(this.f39249o, 24) + (this.f39252r * 2);
        this.f39255u = ak.a(this.f39249o, 30) + (this.f39253s * 2);
        this.f39256v = ak.a(this.f39249o, 46);
        this.f39257w = ak.a(this.f39249o, 56);
    }

    private void l() {
        e eVar = new e(getContext());
        this.f39236b = eVar;
        eVar.setBackgroundColor(0);
        addView(this.f39236b, 0);
        this.f39236b.a(this);
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.f39241g = frameLayout;
        this.f39236b.addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
        m();
        n();
        o();
    }

    private void m() {
        if (this.f39248n == null) {
            com.qq.e.comm.plugin.base.widget.e eVar = new com.qq.e.comm.plugin.base.widget.e(getContext());
            this.f39248n = eVar;
            eVar.b(100);
        }
        this.f39248n.setVisibility(this.f39258x ? 0 : 4);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, ak.a(this.f39249o, 3));
        layoutParams.gravity = 80;
        this.f39241g.addView(this.f39248n, layoutParams);
    }

    public void b(boolean z16) {
        this.f39238d = z16;
        ImageView imageView = this.f39243i;
        if (imageView == null || this.f39242h == null) {
            return;
        }
        if (z16) {
            imageView.setVisibility(4);
            this.f39242h.setVisibility(4);
        } else {
            imageView.setVisibility(0);
            this.f39242h.setVisibility(0);
        }
    }

    @Override // com.qq.e.comm.plugin.base.media.video.c
    public void c() {
        h hVar = this.f39235a;
        if (hVar == null || !(hVar.g() == 0 || this.f39235a.g() == 1)) {
            a(3000, false);
        }
    }

    public void f() {
        ImageView imageView = this.f39245k;
        if (imageView == null) {
            return;
        }
        int i3 = this.f39239e;
        if (i3 != 4 && i3 != 12) {
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(8);
        }
    }

    public void g() {
        ImageView imageView = this.f39243i;
        if (imageView == null) {
            return;
        }
        if (this.f39239e == 12) {
            imageView.setVisibility(8);
        } else {
            imageView.setVisibility(0);
        }
        if (this.f39239e == 4) {
            this.f39243i.setImageBitmap(i.b(this.f39249o));
        } else {
            this.f39243i.setImageBitmap(i.a(this.f39249o));
        }
    }

    public void h() {
        ImageView imageView = this.f39244j;
        if (imageView == null) {
            return;
        }
        if (this.f39239e == 12) {
            imageView.setVisibility(8);
        } else {
            imageView.setVisibility(0);
        }
    }

    @Override // com.qq.e.comm.plugin.base.media.video.e.a
    public void i() {
        if (this.f39237c) {
            c();
        }
    }

    public void j() {
        Handler handler = this.K;
        if (handler != null) {
            handler.removeMessages(10002);
            this.K.removeMessages(10001);
        }
        if (this.f39247m != null) {
            this.f39247m = null;
        }
        g gVar = this.D;
        if (gVar != null) {
            gVar.b();
            this.D = null;
        }
    }

    public void a(c cVar) {
        this.A = cVar;
    }

    @Override // com.qq.e.comm.plugin.base.media.video.c
    public void a(h hVar) {
        this.f39235a = hVar;
        hVar.a(this.J);
        p();
        a();
    }

    public void c(boolean z16) {
        h hVar = this.f39235a;
        if (hVar == null || !(hVar.g() == 0 || this.f39235a.g() == 1 || this.f39235a.j())) {
            a(3000, z16);
        }
    }

    @Override // com.qq.e.comm.plugin.base.media.video.c
    public void e() {
        if (this.f39244j == null) {
            return;
        }
        h hVar = this.f39235a;
        if (hVar != null && hVar.d()) {
            this.f39244j.setImageBitmap(i.d(this.f39249o));
        } else {
            this.f39244j.setImageBitmap(i.c(this.f39249o));
        }
    }

    @Override // com.qq.e.comm.plugin.base.media.video.c
    public void d() {
        ImageView imageView;
        if (!this.f39237c || (imageView = this.f39246l) == null || this.f39242h == null) {
            return;
        }
        imageView.setVisibility(4);
        this.f39242h.setVisibility(4);
        e(false);
        this.f39237c = false;
    }

    public void a() {
        if (this.f39246l == null) {
            return;
        }
        if (u()) {
            t();
        } else {
            s();
        }
    }

    public void b() {
        ImageView imageView = this.f39243i;
        if (imageView == null || this.f39244j == null || this.f39245k == null || this.f39246l == null) {
            return;
        }
        this.f39260z = true;
        imageView.setVisibility(8);
        this.f39244j.setVisibility(8);
        this.f39245k.setVisibility(8);
        this.f39246l.setVisibility(8);
        WeakReference<View> weakReference = this.C;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.C.get().setVisibility(8);
    }

    public void a(boolean z16) {
        this.f39258x = z16;
        com.qq.e.comm.plugin.base.widget.e eVar = this.f39248n;
        if (eVar != null) {
            eVar.setVisibility(z16 ? 0 : 4);
        }
    }

    public void a(boolean z16, boolean z17) {
        h hVar;
        this.f39259y = z16;
        ImageView imageView = this.f39250p;
        if (imageView == null || !z17) {
            return;
        }
        if (z16 && (hVar = this.f39235a) != null) {
            int g16 = hVar.g();
            if (g16 == 6 || g16 == 4) {
                this.f39250p.setVisibility(0);
                return;
            }
            return;
        }
        imageView.setVisibility(4);
    }

    public void a(int i3, boolean z16) {
        if (!this.f39237c && this.f39246l != null && this.f39242h != null) {
            this.f39237c = true;
            setVisibility(0);
            if (!this.f39260z) {
                this.f39246l.setVisibility(0);
                e(true);
            }
            if (!z16 && !this.f39238d && !this.f39260z) {
                this.f39242h.setVisibility(0);
            }
        }
        a();
        e();
        Message obtainMessage = this.K.obtainMessage(10001);
        if (i3 != 0) {
            this.K.removeMessages(10001);
            this.K.sendMessageDelayed(obtainMessage, i3);
        }
    }

    public void a(d dVar) {
        if (dVar instanceof a) {
            this.f39240f = (a) dVar;
        }
    }

    public void a(int i3, int i16) {
        final FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f39250p.getLayoutParams();
        layoutParams.width = i3;
        layoutParams.height = i16;
        layoutParams.gravity = 17;
        this.f39250p.post(new Runnable() { // from class: com.qq.e.comm.plugin.base.media.video.b.7
            @Override // java.lang.Runnable
            public void run() {
                b.this.f39250p.setLayoutParams(layoutParams);
            }
        });
    }

    public void a(int i3) {
        this.f39239e = i3;
        if (i3 == 4) {
            x();
        } else if (i3 == 3) {
            w();
        }
    }
}
