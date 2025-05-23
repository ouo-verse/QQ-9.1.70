package com.tencent.luggage.wxa.kj;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.tencent.ams.dsdk.monitor.metric.event.TagValue;
import com.tencent.mobileqq.R;
import com.tencent.qqmini.sdk.core.MiniAppConst;

/* compiled from: P */
/* loaded from: classes8.dex */
public class z extends y {
    public a D;
    public b E;
    public boolean F;
    public String G;
    public String H;
    public final o0 I;
    public LinearLayout J;
    public TextView K;
    public View L;
    public ImageView M;
    public ImageView N;
    public ImageView O;
    public Runnable P;
    public long Q;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface a {
        void a();
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface b {
        void a(int i3);
    }

    public z(Context context, o0 o0Var) {
        super(context);
        this.F = false;
        this.Q = 0L;
        this.I = o0Var;
        super.setContentView(o0Var.getWrapperView());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j() {
        this.J.setTranslationY(-r0.getHeight());
    }

    @Override // com.tencent.luggage.wxa.kj.y
    public boolean a() {
        return this.I.A();
    }

    @Override // com.tencent.luggage.wxa.kj.y
    public void c() {
        if (this.J == null) {
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.dye, (ViewGroup) this, false);
            this.J = linearLayout;
            super.setBackgroundView(linearLayout);
            i();
            if (ViewCompat.isAttachedToWindow(this)) {
                post(this.P);
            }
            if (!TextUtils.isEmpty(this.H)) {
                setPullDownText(this.H);
            }
            if (TextUtils.isEmpty(this.G)) {
                return;
            }
            setBackgroundTextStyle(this.G);
        }
    }

    @Override // com.tencent.luggage.wxa.kj.y
    public void f() {
        q();
    }

    @Override // com.tencent.luggage.wxa.kj.y
    public void g() {
        p();
        a aVar = this.D;
        if (aVar != null) {
            aVar.a();
        }
        this.Q = System.currentTimeMillis();
    }

    @Override // com.tencent.luggage.wxa.kj.y
    public int getStayHeight() {
        return this.J.getHeight();
    }

    public final void k() {
        if (this.P == null) {
            this.P = new Runnable() { // from class: b31.aa
                @Override // java.lang.Runnable
                public final void run() {
                    com.tencent.luggage.wxa.kj.z.this.j();
                }
            };
        }
        removeCallbacks(this.P);
        post(this.P);
    }

    public final void l() {
        this.K.setTextColor(-16777216);
        this.K.setAlpha(0.2f);
    }

    public final void m() {
        this.K.setTextColor(-1);
        this.K.setAlpha(0.4f);
    }

    public final void n() {
        ImageView imageView = this.M;
        if (imageView == null) {
            com.tencent.luggage.wxa.tn.w.f("MicroMsg.AppBrandPullDownWebView", "setupDarkLoading but mLoading0 is null, try protect");
            return;
        }
        imageView.setImageDrawable(a(-16777216, new float[]{0.1f, 0.4f, 0.2f, 0.1f}));
        this.N.setImageDrawable(a(-16777216, new float[]{0.1f, 0.1f, 0.4f, 0.2f}));
        this.O.setImageDrawable(a(-16777216, new float[]{0.1f, 0.2f, 0.1f, 0.4f}));
    }

    public final void o() {
        ImageView imageView = this.M;
        if (imageView == null) {
            com.tencent.luggage.wxa.tn.w.f("MicroMsg.AppBrandPullDownWebView", "setupLightLoading but mLoading0 is null, try protect");
            return;
        }
        imageView.setImageDrawable(a(-1, new float[]{0.2f, 0.6f, 0.4f, 0.2f}));
        this.N.setImageDrawable(a(-1, new float[]{0.2f, 0.2f, 0.6f, 0.4f}));
        this.O.setImageDrawable(a(-1, new float[]{0.2f, 0.4f, 0.2f, 0.6f}));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.J != null) {
            k();
        }
    }

    public void p() {
        if (this.J == null) {
            c();
        }
        ImageView imageView = this.M;
        if (imageView == null) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandPullDownWebView", "startLoadingAnimation, mLoading0 is null");
            return;
        }
        if (imageView.getDrawable() == null) {
            com.tencent.luggage.wxa.tn.w.f("MicroMsg.AppBrandPullDownWebView", "startLoadingAnimation but drawable is null, try protect");
            n();
            l();
        }
        ((AnimationDrawable) this.M.getDrawable()).start();
        ((AnimationDrawable) this.N.getDrawable()).start();
        ((AnimationDrawable) this.O.getDrawable()).start();
    }

    public void q() {
        ImageView imageView = this.M;
        if (imageView != null && imageView.getDrawable() != null) {
            ((AnimationDrawable) this.M.getDrawable()).stop();
            ((AnimationDrawable) this.M.getDrawable()).selectDrawable(0);
            ((AnimationDrawable) this.N.getDrawable()).stop();
            ((AnimationDrawable) this.N.getDrawable()).selectDrawable(0);
            ((AnimationDrawable) this.O.getDrawable()).stop();
            ((AnimationDrawable) this.O.getDrawable()).selectDrawable(0);
            return;
        }
        com.tencent.luggage.wxa.tn.w.f("MicroMsg.AppBrandPullDownWebView", "stopLoadingAnimation but drawable is null, try protect");
    }

    public void r() {
        long currentTimeMillis = System.currentTimeMillis() - this.Q;
        if (currentTimeMillis < 1000) {
            postDelayed(new Runnable() { // from class: b31.ab
                @Override // java.lang.Runnable
                public final void run() {
                    com.tencent.luggage.wxa.kj.z.this.b();
                }
            }, Math.max(0L, 1000 - currentTimeMillis));
        } else {
            b();
        }
    }

    public void setBackgroundTextStyle(String str) {
        this.G = str;
        if (this.J == null) {
            return;
        }
        if (MiniAppConst.MENU_STYLE_LIGHT.equals(str)) {
            o();
            m();
        } else if (MiniAppConst.MENU_STYLE_DARK.equals(str)) {
            n();
            l();
        } else if (!TagValue.IGNORE.equals(str)) {
            n();
            l();
        }
    }

    public void setHeadViewHeight(int i3) {
        if (i3 <= this.J.getHeight()) {
            return;
        }
        this.J.getLayoutParams().height = i3;
        this.J.requestLayout();
    }

    public void setOnPullDownListener(a aVar) {
        this.D = aVar;
    }

    public void setOnPullDownOffsetListener(b bVar) {
        this.E = bVar;
    }

    public void setPullDownText(String str) {
        this.H = str;
        if (this.J != null && this.K != null) {
            if (com.tencent.luggage.wxa.tn.w0.c(str)) {
                this.K.setVisibility(8);
            } else {
                this.K.setVisibility(0);
                this.K.setText(str);
            }
        }
    }

    public void a(String str, int i3) {
        setBackgroundTextStyle(str);
        setPullDownBackgroundColor(i3);
    }

    public final void i() {
        this.K = (TextView) findViewById(R.id.ss9);
        this.L = findViewById(R.id.ss5);
        this.M = (ImageView) findViewById(R.id.ss6);
        this.N = (ImageView) findViewById(R.id.ss7);
        this.O = (ImageView) findViewById(R.id.ss8);
    }

    public void a(boolean z16) {
        this.F = z16;
        if (z16 && this.J == null) {
            c();
        }
        setNeedStay(z16);
        View view = this.L;
        if (view != null) {
            view.setVisibility(z16 ? 0 : 4);
        }
    }

    public final AnimationDrawable a(int i3, float[] fArr) {
        AnimationDrawable animationDrawable = new AnimationDrawable();
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandPullDownWebView", "AnimationDrawable hash:" + animationDrawable.hashCode());
        animationDrawable.setOneShot(false);
        animationDrawable.addFrame(a(i3, fArr[0]), 0);
        animationDrawable.addFrame(a(i3, fArr[1]), 300);
        animationDrawable.addFrame(a(i3, fArr[2]), 300);
        animationDrawable.addFrame(a(i3, fArr[3]), 300);
        return animationDrawable;
    }

    @Override // com.tencent.luggage.wxa.kj.y
    public void c(int i3) {
        b bVar = this.E;
        if (bVar != null) {
            bVar.a(i3);
        }
        if (this.F) {
            removeCallbacks(this.P);
            if (i3 > this.J.getHeight()) {
                i3 = this.J.getHeight();
            }
            this.J.setTranslationY(i3 - r0.getHeight());
        }
    }

    public final Drawable a(int i3, float f16) {
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        shapeDrawable.setIntrinsicHeight(32);
        shapeDrawable.setIntrinsicWidth(32);
        shapeDrawable.getPaint().setColor(i3);
        shapeDrawable.getPaint().setAlpha((int) (f16 * 255.0f));
        return shapeDrawable;
    }
}
