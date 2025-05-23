package com.tencent.luggage.wxa.ch;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.luggage.wxa.mg.g;
import com.tencent.luggage.wxa.tn.e0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.VideoPlayerSeekBar;
import com.tencent.mobileqq.R;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c extends VideoPlayerSeekBar implements g.a {
    public ImageView M;
    public ImageView N;
    public LinearLayout O;
    public ImageView P;
    public FrameLayout Q;
    public ImageView R;
    public ImageView S;
    public ImageView T;
    public TextView U;
    public LinearLayout V;
    public LinearLayout W;

    /* renamed from: a0, reason: collision with root package name */
    public g.i f123513a0;

    /* renamed from: b0, reason: collision with root package name */
    public e0 f123514b0;

    /* renamed from: c0, reason: collision with root package name */
    public e0 f123515c0;

    /* renamed from: d0, reason: collision with root package name */
    public boolean f123516d0;

    /* renamed from: e0, reason: collision with root package name */
    public boolean f123517e0;

    /* renamed from: f0, reason: collision with root package name */
    public boolean f123518f0;

    /* renamed from: g0, reason: collision with root package name */
    public boolean f123519g0;

    /* renamed from: h0, reason: collision with root package name */
    public boolean f123520h0;

    /* renamed from: i0, reason: collision with root package name */
    public boolean f123521i0;

    /* renamed from: j0, reason: collision with root package name */
    public boolean f123522j0;

    /* renamed from: k0, reason: collision with root package name */
    public boolean f123523k0;

    /* renamed from: l0, reason: collision with root package name */
    public g.e f123524l0;

    /* renamed from: m0, reason: collision with root package name */
    public ConcurrentLinkedQueue f123525m0;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g.InterfaceC6475g f123526a;

        public a(g.InterfaceC6475g interfaceC6475g) {
            this.f123526a = interfaceC6475g;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.B();
            g.InterfaceC6475g interfaceC6475g = this.f123526a;
            if (interfaceC6475g != null) {
                interfaceC6475g.a(view, c.this.f123517e0);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements e0.a {
        public b() {
        }

        @Override // com.tencent.luggage.wxa.tn.e0.a
        public boolean a() {
            c.this.setVisibility(8);
            c.this.f123514b0.f();
            return false;
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.ch.c$c, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6112c implements e0.a {
        public C6112c() {
        }

        @Override // com.tencent.luggage.wxa.tn.e0.a
        public boolean a() {
            if (!c.this.D()) {
                return false;
            }
            return true;
        }
    }

    public c(Context context) {
        super(context);
        this.f123523k0 = true;
        this.f123525m0 = new ConcurrentLinkedQueue();
    }

    public final void A() {
        boolean z16;
        int i3;
        int i16;
        int i17 = 0;
        if (this.f123520h0) {
            z16 = this.f123519g0;
        } else {
            z16 = false;
        }
        FrameLayout frameLayout = this.Q;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        frameLayout.setVisibility(i3);
        TextView textView = this.f123505g;
        if (z16) {
            i16 = 0;
        } else {
            i16 = 8;
        }
        textView.setVisibility(i16);
        TextView textView2 = this.f123506h;
        if (!z16) {
            i17 = 8;
        }
        textView2.setVisibility(i17);
    }

    public final void B() {
        this.f123517e0 = !this.f123517e0;
        t();
    }

    public final void C() {
        int dimensionPixelSize;
        if (this.f123516d0) {
            dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.c2o);
        } else {
            dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.c2e);
        }
        ImageView imageView = this.f123504f;
        if (imageView != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
            marginLayoutParams.setMarginStart(dimensionPixelSize);
            this.f123504f.setLayoutParams(marginLayoutParams);
        }
        LinearLayout linearLayout = this.W;
        if (linearLayout != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) linearLayout.getLayoutParams();
            marginLayoutParams2.setMarginStart(dimensionPixelSize);
            this.W.setLayoutParams(marginLayoutParams2);
        }
        ImageView imageView2 = this.N;
        if (imageView2 != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) imageView2.getLayoutParams();
            marginLayoutParams3.setMarginStart(dimensionPixelSize);
            this.N.setLayoutParams(marginLayoutParams3);
        }
        ImageView imageView3 = this.R;
        if (imageView3 != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) imageView3.getLayoutParams();
            marginLayoutParams4.setMarginStart(dimensionPixelSize);
            this.R.setLayoutParams(marginLayoutParams4);
        }
        ImageView imageView4 = this.M;
        if (imageView4 != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams5 = (ViewGroup.MarginLayoutParams) imageView4.getLayoutParams();
            marginLayoutParams5.setMarginStart(dimensionPixelSize);
            this.M.setLayoutParams(marginLayoutParams5);
        }
    }

    public final boolean D() {
        g.i iVar = this.f123513a0;
        int i3 = 0;
        if (iVar == null) {
            w.d("MicroMsg.AppBrandVideoViewControlBar", "updateMiddleBar mStatePorter null");
            return false;
        }
        int a16 = iVar.a();
        int b16 = this.f123513a0.b();
        if (a16 < 0 || b16 < 0) {
            return false;
        }
        if (a16 > b16) {
            a16 = b16;
        }
        int barLen = getBarLen();
        if (barLen <= 0) {
            return true;
        }
        if (b16 != 0) {
            i3 = (int) (barLen * ((a16 * 1.0d) / b16));
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.P.getLayoutParams();
        layoutParams.width = i3;
        this.P.setLayoutParams(layoutParams);
        return true;
    }

    @Override // com.tencent.luggage.wxa.mg.g.a
    public void e() {
        this.f123516d0 = true;
        s();
    }

    @Override // com.tencent.luggage.wxa.mg.g.a
    public boolean f() {
        if (this.Q == null || getVisibility() != 0 || this.Q.getVisibility() != 0) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.luggage.wxa.mg.g.a
    public void g() {
        if (this.f123521i0 && this.f123522j0) {
            this.S.setVisibility(0);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.VideoPlayerSeekBar, com.tencent.luggage.wxa.ch.a
    public int getLayoutId() {
        return R.layout.dyw;
    }

    @Override // com.tencent.luggage.wxa.mg.g.a
    public boolean h() {
        return this.f123523k0;
    }

    @Override // com.tencent.luggage.wxa.mg.g.a
    public void i() {
        setVisibility(0);
        if (!this.f123523k0) {
            return;
        }
        if (this.f123514b0 == null) {
            this.f123514b0 = new e0(new b(), false);
        }
        this.f123514b0.f();
        this.f123514b0.a(7000L);
    }

    @Override // com.tencent.luggage.wxa.mg.g.a
    public boolean j() {
        if (getVisibility() == 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.mg.g.a
    public void k() {
        if (this.f123515c0 == null) {
            this.f123515c0 = new e0(new C6112c(), true);
        }
        D();
        this.f123515c0.f();
        this.f123515c0.a(500L);
    }

    @Override // com.tencent.luggage.wxa.mg.g.a
    public boolean l() {
        return this.f123517e0;
    }

    @Override // com.tencent.luggage.wxa.mg.g.a
    public void m() {
        e0 e0Var = this.f123515c0;
        if (e0Var != null) {
            e0Var.f();
        }
    }

    @Override // com.tencent.luggage.wxa.mg.g.a
    public void n() {
        setVisibility(8);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.VideoPlayerSeekBar, com.tencent.luggage.wxa.ch.a
    public void o() {
        super.o();
        this.M = (ImageView) this.f123500b.findViewById(R.id.vgo);
        this.N = (ImageView) this.f123500b.findViewById(R.id.udd);
        this.P = (ImageView) this.f123500b.findViewById(R.id.f25910c4);
        this.Q = (FrameLayout) this.f123500b.findViewById(R.id.f25930c6);
        this.O = (LinearLayout) findViewById(R.id.root);
        this.R = (ImageView) findViewById(R.id.f166362f42);
        this.S = (ImageView) findViewById(R.id.tqd);
        this.T = (ImageView) findViewById(R.id.uxv);
        this.U = (TextView) findViewById(R.id.title);
        this.V = (LinearLayout) findViewById(R.id.vgx);
        this.W = (LinearLayout) findViewById(R.id.f25880c1);
    }

    @Override // com.tencent.luggage.wxa.mg.g.a
    public void onDestroy() {
        e0 e0Var = this.f123515c0;
        if (e0Var != null) {
            e0Var.f();
        }
        e0 e0Var2 = this.f123514b0;
        if (e0Var2 != null) {
            e0Var2.f();
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.VideoPlayerSeekBar, com.tencent.luggage.wxa.ch.a
    public void q() {
        if (this.f123507i == 0 || this.f123511m || this.f123503e == null) {
            return;
        }
        this.f123505g.setText(c(this.f123508j / 60) + ":" + c(this.f123508j % 60));
        if (getBarLen() == 0) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f123503e.getLayoutParams();
        int barLen = getBarLen();
        layoutParams.leftMargin = a(this.f123508j, barLen);
        this.f123503e.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f123501c.getLayoutParams();
        layoutParams2.width = (int) (((this.f123508j * 1.0d) / this.f123507i) * barLen);
        this.f123501c.setLayoutParams(layoutParams2);
        requestLayout();
        b(this.f123508j, this.f123507i);
    }

    @Override // com.tencent.luggage.wxa.mg.g.a
    public void quitFullScreen() {
        this.f123516d0 = false;
        s();
    }

    public final void s() {
        y();
        u();
        v();
        z();
        C();
    }

    public void setAutoHide(boolean z16) {
        this.f123523k0 = z16;
    }

    @Override // com.tencent.luggage.wxa.mg.g.a
    public void setDanmakuBtnOnClickListener(g.InterfaceC6475g interfaceC6475g) {
        this.N.setOnClickListener(new a(interfaceC6475g));
    }

    @Override // com.tencent.luggage.wxa.mg.g.a
    public void setDanmakuBtnOpen(boolean z16) {
        this.f123517e0 = z16;
        t();
    }

    @Override // com.tencent.luggage.wxa.mg.g.a
    public void setExitFullScreenBtnOnClickListener(View.OnClickListener onClickListener) {
        this.T.setOnClickListener(onClickListener);
    }

    @Override // com.tencent.luggage.wxa.mg.g.a
    public void setFullScreenBtnOnClickListener(View.OnClickListener onClickListener) {
        this.M.setOnClickListener(onClickListener);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.VideoPlayerSeekBar, com.tencent.luggage.wxa.ch.a, com.tencent.luggage.wxa.mg.g.a
    public void setIsPlay(boolean z16) {
        this.I = z16;
        w();
    }

    @Override // com.tencent.luggage.wxa.mg.g.a
    public void setMuteBtnOnClickListener(View.OnClickListener onClickListener) {
        this.R.setOnClickListener(onClickListener);
    }

    @Override // com.tencent.luggage.wxa.mg.g.a
    public void setMuteBtnState(boolean z16) {
        if (z16) {
            this.R.setImageResource(R.raw.f169269b0);
        } else {
            this.R.setImageResource(R.raw.f169270b1);
        }
    }

    @Override // com.tencent.luggage.wxa.ch.a, com.tencent.luggage.wxa.mg.g.a
    public void setOnPlayButtonClickListener(View.OnClickListener onClickListener) {
        super.setOnPlayButtonClickListener(onClickListener);
        this.S.setOnClickListener(onClickListener);
    }

    @Override // com.tencent.luggage.wxa.mg.g.a
    public void setOnUpdateProgressLenListener(g.e eVar) {
        this.f123524l0 = eVar;
    }

    @Override // com.tencent.luggage.wxa.mg.g.a
    public void setPlayBtnInCenterPosition(boolean z16) {
        this.f123522j0 = z16;
        x();
    }

    @Override // com.tencent.luggage.wxa.mg.g.a
    public void setShowControlProgress(boolean z16) {
        this.f123520h0 = z16;
        A();
    }

    @Override // com.tencent.luggage.wxa.mg.g.a
    public void setShowDanmakuBtn(boolean z16) {
        if (z16) {
            this.N.setVisibility(0);
        } else {
            this.N.setVisibility(8);
        }
    }

    @Override // com.tencent.luggage.wxa.mg.g.a
    public void setShowFullScreenBtn(boolean z16) {
        this.f123518f0 = z16;
        u();
        v();
    }

    @Override // com.tencent.luggage.wxa.mg.g.a
    public void setShowMuteBtn(boolean z16) {
        int i3;
        ImageView imageView = this.R;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        imageView.setVisibility(i3);
    }

    @Override // com.tencent.luggage.wxa.mg.g.a
    public void setShowPlayBtn(boolean z16) {
        this.f123521i0 = z16;
        x();
    }

    @Override // com.tencent.luggage.wxa.mg.g.a
    public void setShowProgress(boolean z16) {
        this.f123519g0 = z16;
        A();
    }

    @Override // com.tencent.luggage.wxa.mg.g.a
    public void setStatePorter(g.i iVar) {
        this.f123513a0 = iVar;
    }

    @Override // com.tencent.luggage.wxa.mg.g.a
    public void setTitle(String str) {
        if (!w0.c(str)) {
            this.U.setText(str);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i3) {
        super.setVisibility(i3);
        if (i3 == 0) {
            Iterator it = this.f123525m0.iterator();
            while (it.hasNext()) {
                g.f fVar = (g.f) it.next();
                if (fVar != null) {
                    fVar.a(true);
                }
            }
            return;
        }
        if (i3 == 8 || i3 == 4) {
            Iterator it5 = this.f123525m0.iterator();
            while (it5.hasNext()) {
                g.f fVar2 = (g.f) it5.next();
                if (fVar2 != null) {
                    fVar2.a(false);
                }
            }
        }
    }

    public final void t() {
        if (this.f123517e0) {
            this.N.setImageResource(R.raw.f169265aw);
        } else {
            this.N.setImageResource(R.raw.f169264av);
        }
    }

    public void u() {
        if (this.f123518f0) {
            this.M.setVisibility(0);
            if (this.f123516d0) {
                this.M.setImageResource(R.raw.f169268az);
                return;
            } else {
                this.M.setImageResource(R.raw.f169267ay);
                return;
            }
        }
        this.M.setVisibility(8);
    }

    public void v() {
        if (this.f123516d0) {
            this.V.setVisibility(0);
        } else {
            this.V.setVisibility(8);
        }
    }

    public final void w() {
        if (this.I) {
            this.f123504f.setImageResource(R.raw.f169271b2);
            this.S.setImageResource(R.raw.f169271b2);
        } else {
            this.f123504f.setImageResource(R.raw.f169272b3);
            this.S.setImageResource(R.raw.f169272b3);
        }
    }

    public final void x() {
        if (this.f123521i0) {
            if (this.f123522j0) {
                this.f123504f.setVisibility(8);
                this.S.setVisibility(0);
                return;
            } else {
                this.f123504f.setVisibility(0);
                this.S.setVisibility(8);
                return;
            }
        }
        this.f123504f.setVisibility(8);
        this.S.setVisibility(8);
    }

    public final void y() {
        int dimensionPixelSize;
        ViewGroup.LayoutParams layoutParams = this.O.getLayoutParams();
        if (this.f123516d0) {
            layoutParams.height = getResources().getDimensionPixelSize(R.dimen.c2p);
        } else {
            layoutParams.height = getResources().getDimensionPixelSize(R.dimen.c2g);
        }
        this.O.setLayoutParams(layoutParams);
        if (this.f123516d0) {
            dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.c2q);
        } else {
            dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.c2h);
        }
        this.O.setPadding(0, 0, dimensionPixelSize, 0);
        LinearLayout linearLayout = this.V;
        if (linearLayout != null) {
            linearLayout.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
        }
    }

    public final void z() {
        int dimensionPixelSize;
        if (this.f123516d0) {
            dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.c2r);
        } else {
            dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.c2k);
        }
        float f16 = dimensionPixelSize;
        this.f123505g.setTextSize(0, f16);
        this.f123506h.setTextSize(0, f16);
    }

    @Override // com.tencent.luggage.wxa.mg.g.a
    public void a() {
        if (j()) {
            setVisibility(8);
        } else {
            i();
        }
    }

    @Override // com.tencent.luggage.wxa.mg.g.a
    public void b() {
        e0 e0Var = this.f123514b0;
        if (e0Var != null) {
            e0Var.f();
            this.f123514b0.a(7000L);
        }
    }

    @Override // com.tencent.luggage.wxa.mg.g.a
    public boolean c() {
        return this.f123516d0;
    }

    @Override // com.tencent.luggage.wxa.mg.g.a
    public void d() {
        if (this.f123521i0 && this.f123522j0) {
            this.S.setVisibility(8);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.VideoPlayerSeekBar, com.tencent.luggage.wxa.mg.g.a
    public void a(int i3) {
        super.a(i3);
        b(this.f123508j, this.f123507i);
    }

    public void b(int i3, int i16) {
        g.e eVar = this.f123524l0;
        if (eVar != null) {
            eVar.a(i3, i16);
        }
    }

    @Override // com.tencent.luggage.wxa.mg.g.a
    public void a(g.f fVar) {
        this.f123525m0.add(fVar);
    }
}
