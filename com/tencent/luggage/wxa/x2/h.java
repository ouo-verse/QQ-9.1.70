package com.tencent.luggage.wxa.x2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.ViewCompat;
import com.tencent.luggage.wxa.fd.n0;
import com.tencent.luggage.wxa.ic.e;
import com.tencent.luggage.wxa.kl.i;
import com.tencent.luggage.wxa.ok.j;
import com.tencent.luggage.wxa.ok.l;
import com.tencent.luggage.wxa.ok.q;
import com.tencent.luggage.wxa.tn.c0;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.mm.ui.statusbar.DrawStatusBarFrameLayout;
import com.tencent.mobileqq.R;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
/* loaded from: classes9.dex */
public class h extends DrawStatusBarFrameLayout implements j, l {
    public com.tencent.luggage.wxa.ic.g F;
    public i G;
    public Function0 H;
    public n0.g I;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (h.this.F != null) {
                com.tencent.luggage.wxa.ic.e.a(h.this.F.getAppId(), e.d.CLOSE);
                h.this.F.D();
            } else if (h.this.H != null) {
                h.this.H.invoke();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f144552a;

        public b(Function0 function0) {
            this.f144552a = function0;
        }

        @Override // java.lang.Runnable
        public void run() {
            h.this.setVisibility(8);
            if (h.this.getParent() != null) {
                ((ViewGroup) h.this.getParent()).removeView(h.this);
            }
            h.this.G.destroy();
            Function0 function0 = this.f144552a;
            if (function0 != null) {
                function0.invoke();
            }
        }
    }

    public h(@NonNull Context context, @Nullable com.tencent.luggage.wxa.ic.g gVar, @Nullable n0.g gVar2) {
        super(context);
        this.F = gVar;
        this.I = gVar2;
        a(context);
    }

    public final boolean m() {
        com.tencent.luggage.wxa.ic.g gVar = this.F;
        if (gVar != null && (gVar instanceof com.tencent.luggage.wxa.c5.e) && ((com.tencent.luggage.wxa.c5.e) gVar).y1()) {
            return true;
        }
        return false;
    }

    public void n() {
        this.G.a(false, i.a.EnumC6399a.PageConfig);
        a aVar = new a();
        this.G.setCloseButtonClickListener(aVar);
        this.G.setBackButtonClickListener(aVar);
        int color = getContext().getResources().getColor(R.color.agv);
        int color2 = getContext().getResources().getColor(R.color.c7u);
        com.tencent.luggage.wxa.ic.g gVar = this.F;
        if (gVar != null) {
            gVar.S();
        }
        String str = "white";
        if (this.I != null) {
            if (com.tencent.luggage.wxa.h6.l.f126905a.c()) {
                if (!w0.c(this.I.H)) {
                    color = com.tencent.luggage.wxa.tk.g.a(this.I.H, getContext().getResources().getColor(R.color.agv));
                }
                if (!w0.c(this.I.G)) {
                    color2 = com.tencent.luggage.wxa.tk.g.a(this.I.G, getContext().getResources().getColor(R.color.c7u));
                }
            } else {
                if (!w0.c(this.I.F)) {
                    color = com.tencent.luggage.wxa.tk.g.a(this.I.F, getContext().getResources().getColor(R.color.agv));
                }
                if (!w0.c(this.I.E)) {
                    color2 = com.tencent.luggage.wxa.tk.g.a(this.I.E, getContext().getResources().getColor(R.color.c7u));
                }
                str = "black";
            }
        }
        a(getContext().getString(R.string.ywk), color, str, color2);
        c(color);
    }

    @Override // android.view.View
    public final boolean post(Runnable runnable) {
        if (runnable == null) {
            return false;
        }
        if (!ViewCompat.isAttachedToWindow(this) && m()) {
            c0.a(runnable);
            return true;
        }
        return super.post(runnable);
    }

    @Override // android.view.View
    public final boolean postDelayed(Runnable runnable, long j3) {
        if (runnable == null) {
            return false;
        }
        if (!ViewCompat.isAttachedToWindow(this) && m()) {
            c0.a(runnable, j3);
            return true;
        }
        return super.postDelayed(runnable, j3);
    }

    @Override // com.tencent.luggage.wxa.ok.j
    public /* bridge */ /* synthetic */ void setAppServiceType(int i3) {
        o31.b.a(this, i3);
    }

    @Override // com.tencent.luggage.wxa.ok.j
    public /* bridge */ /* synthetic */ void setCanShowHideAnimation(boolean z16) {
        o31.b.b(this, z16);
    }

    public final void a(Context context) {
        setBackgroundColor(getResources().getColor(R.color.agv));
        q qVar = new q(context);
        this.G = qVar;
        qVar.setBackgroundColor(ContextCompat.getColor(context, R.color.ajr));
        addView(this.G.getActionView());
        n();
    }

    @Override // com.tencent.luggage.wxa.ok.j
    public void c(Function0 function0) {
        post(new b(function0));
    }

    public void c(int i3) {
        setBackgroundColor(ColorUtils.compositeColors(i3, getContext().getResources().getColor(R.color.agv)));
    }

    public void a(String str, int i3, String str2, int i16) {
        this.G.setMainTitle(str);
        this.G.setForegroundStyle(str2);
        this.G.setLoadingIconVisibility(true);
        this.G.setForegroundColor(i16);
        a(i3, "black".equals(str2));
    }

    @Override // com.tencent.luggage.wxa.ok.j
    public void a(String str, String str2) {
        this.G.setMainTitle(getContext().getString(R.string.ywk));
    }

    @Override // com.tencent.luggage.wxa.ok.l
    public void a(Function0 function0) {
        this.H = function0;
    }

    @Override // com.tencent.luggage.wxa.ok.j
    public View getView() {
        return this;
    }

    @Override // com.tencent.luggage.wxa.ok.j
    public void setProgress(int i3) {
    }
}
