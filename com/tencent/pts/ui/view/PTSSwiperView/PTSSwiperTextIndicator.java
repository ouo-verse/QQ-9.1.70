package com.tencent.pts.ui.view.PTSSwiperView;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.pts.utils.PTSLog;

/* loaded from: classes22.dex */
public class PTSSwiperTextIndicator extends LinearLayout implements a {
    static IPatchRedirector $redirector_;
    private final int C;
    private final int D;
    private final int E;
    private final int F;
    private final int G;
    private final int H;
    private final int I;
    private final int J;
    private final int K;
    private final int L;
    private final int M;
    private final int N;

    /* renamed from: d, reason: collision with root package name */
    private String f342225d;

    /* renamed from: e, reason: collision with root package name */
    private final Context f342226e;

    /* renamed from: f, reason: collision with root package name */
    private int f342227f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f342228h;

    /* renamed from: i, reason: collision with root package name */
    private final GradientDrawable f342229i;

    /* renamed from: m, reason: collision with root package name */
    private final int f342230m;

    public PTSSwiperTextIndicator(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f342225d = "PTSSwiperTextIndicator";
        this.f342227f = 0;
        this.f342229i = new GradientDrawable();
        this.f342230m = 36;
        this.C = 100;
        this.D = 32;
        this.E = 32;
        this.F = 32;
        this.G = 32;
        this.H = 30;
        this.I = 4;
        this.J = 30;
        this.K = 4;
        this.L = 12;
        this.M = Color.parseColor("#80000000");
        this.N = Color.parseColor("#FFFFFF");
        this.f342226e = context;
        d();
    }

    private void d() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, 36);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.setMargins(32, 32, 32, 32);
        setPadding(30, 4, 30, 4);
        setLayoutParams(layoutParams);
        this.f342229i.setCornerRadius(100.0f);
        this.f342229i.setColor(this.M);
        setBackgroundDrawable(this.f342229i);
        TextView textView = new TextView(this.f342226e);
        this.f342228h = textView;
        textView.setTextColor(this.N);
        this.f342228h.setTextSize(12.0f);
        addView(this.f342228h, new ViewGroup.LayoutParams(-2, -2));
    }

    @Override // com.tencent.pts.ui.view.PTSSwiperView.a
    public void a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
            return;
        }
        if (getVisibility() != 0) {
            return;
        }
        int i16 = i3 + 1;
        if (i16 > this.f342227f) {
            PTSLog.e(this.f342225d, "[updateIndicatorFocusStatus] (currentFocusItemIndex + 1) > itemCount, means numerator is greater than denominator");
        } else {
            this.f342228h.setText(String.format("%s / %s", Integer.valueOf(i16), Integer.valueOf(this.f342227f)));
        }
    }

    @Override // com.tencent.pts.ui.view.PTSSwiperView.a
    public RelativeLayout.LayoutParams b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (RelativeLayout.LayoutParams) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return (RelativeLayout.LayoutParams) getLayoutParams();
    }

    @Override // com.tencent.pts.ui.view.PTSSwiperView.a
    public void c(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
            return;
        }
        this.f342227f = i3;
        if (i3 == 0) {
            setIndicatorVisible(false);
        }
    }

    @Override // com.tencent.pts.ui.view.PTSSwiperView.a
    public void setIndicatorLayoutParams(ViewGroup.LayoutParams layoutParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) layoutParams);
        } else {
            setLayoutParams(layoutParams);
        }
    }

    @Override // com.tencent.pts.ui.view.PTSSwiperView.a
    public void setIndicatorVisible(boolean z16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, z16);
            return;
        }
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        setVisibility(i3);
    }
}
