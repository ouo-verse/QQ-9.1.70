package com.tencent.luggage.wxa.k6;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.ams.dsdk.monitor.metric.event.TagValue;
import com.tencent.luggage.wxa.kj.y;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.mobileqq.R;
import com.tencent.qqmini.sdk.core.MiniAppConst;

/* compiled from: P */
/* loaded from: classes8.dex */
public class l extends y {
    public m D;
    public LinearLayout E;
    public TextView F;
    public View G;
    public ImageView H;
    public ImageView I;
    public ImageView J;

    public l(Context context, m mVar) {
        super(context);
        this.D = mVar;
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.dye, (ViewGroup) this, false);
        this.E = linearLayout;
        setBackgroundView(linearLayout);
        setContentView(mVar);
        i();
    }

    @Override // com.tencent.luggage.wxa.kj.y
    public boolean a() {
        return this.D.A();
    }

    @Override // com.tencent.luggage.wxa.kj.y
    public int getStayHeight() {
        return this.E.getHeight();
    }

    public final void i() {
        this.F = (TextView) findViewById(R.id.ss9);
        this.G = findViewById(R.id.ss5);
        this.H = (ImageView) findViewById(R.id.ss6);
        this.I = (ImageView) findViewById(R.id.ss7);
        this.J = (ImageView) findViewById(R.id.ss8);
    }

    public final void j() {
        this.F.setTextColor(-16777216);
        this.F.setAlpha(0.2f);
    }

    public final void k() {
        this.F.setTextColor(-1);
        this.F.setAlpha(0.4f);
    }

    public final void l() {
        ImageView imageView = this.H;
        if (imageView == null) {
            w.f("MicroMsg.AppBrandPullDownWebView", "setupDarkLoading but mLoading0 is null, try protect");
            return;
        }
        imageView.setImageDrawable(a(-16777216, new float[]{0.1f, 0.4f, 0.2f, 0.1f}));
        this.I.setImageDrawable(a(-16777216, new float[]{0.1f, 0.1f, 0.4f, 0.2f}));
        this.J.setImageDrawable(a(-16777216, new float[]{0.1f, 0.2f, 0.1f, 0.4f}));
    }

    public final void m() {
        ImageView imageView = this.H;
        if (imageView == null) {
            w.f("MicroMsg.AppBrandPullDownWebView", "setupLightLoading but mLoading0 is null, try protect");
            return;
        }
        imageView.setImageDrawable(a(-1, new float[]{0.2f, 0.6f, 0.4f, 0.2f}));
        this.I.setImageDrawable(a(-1, new float[]{0.2f, 0.2f, 0.6f, 0.4f}));
        this.J.setImageDrawable(a(-1, new float[]{0.2f, 0.4f, 0.2f, 0.6f}));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        setDescendantFocusability(262144);
    }

    public void setBackgroundTextStyle(String str) {
        if (MiniAppConst.MENU_STYLE_LIGHT.equals(str)) {
            m();
            k();
        } else if (MiniAppConst.MENU_STYLE_DARK.equals(str)) {
            l();
            j();
        } else if (!TagValue.IGNORE.equals(str)) {
            l();
            j();
        }
    }

    public void setHeadViewHeight(int i3) {
        if (i3 <= this.E.getHeight()) {
            return;
        }
        this.E.getLayoutParams().height = i3;
        this.E.requestLayout();
    }

    public void setPullDownText(String str) {
        if (w0.c(str)) {
            this.F.setVisibility(8);
        } else {
            this.F.setVisibility(0);
            this.F.setText(str);
        }
    }

    public final AnimationDrawable a(int i3, float[] fArr) {
        AnimationDrawable animationDrawable = new AnimationDrawable();
        w.d("MicroMsg.AppBrandPullDownWebView", "AnimationDrawable hash:" + animationDrawable.hashCode());
        animationDrawable.setOneShot(false);
        animationDrawable.addFrame(a(i3, fArr[0]), 0);
        animationDrawable.addFrame(a(i3, fArr[1]), 300);
        animationDrawable.addFrame(a(i3, fArr[2]), 300);
        animationDrawable.addFrame(a(i3, fArr[3]), 300);
        return animationDrawable;
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
