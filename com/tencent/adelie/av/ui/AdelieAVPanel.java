package com.tencent.adelie.av.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.ui.m;
import com.tencent.av.utils.QQFrameByFrameAnimation;
import com.tencent.av.utils.TraeHelper;
import com.tencent.av.utils.ba;
import com.tencent.av.utils.e;
import com.tencent.av.utils.l;
import com.tencent.luggage.wxa.yf.x;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes37.dex */
public class AdelieAVPanel extends RelativeLayout {
    private static String K;
    View C;
    Button D;
    Button E;
    RelativeLayout F;
    ClipDrawable G;
    private int H;
    private ValueAnimator I;
    private volatile boolean J;

    /* renamed from: d, reason: collision with root package name */
    int f61457d;

    /* renamed from: e, reason: collision with root package name */
    View f61458e;

    /* renamed from: f, reason: collision with root package name */
    boolean f61459f;

    /* renamed from: h, reason: collision with root package name */
    View f61460h;

    /* renamed from: i, reason: collision with root package name */
    Button f61461i;

    /* renamed from: m, reason: collision with root package name */
    View f61462m;

    /* loaded from: classes37.dex */
    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ClipDrawable clipDrawable;
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (!AdelieAVPanel.this.J || (clipDrawable = AdelieAVPanel.this.G) == null) {
                return;
            }
            clipDrawable.setLevel(intValue);
        }
    }

    public AdelieAVPanel(Context context) {
        super(context);
        this.f61457d = 0;
        this.f61458e = null;
        this.f61459f = false;
        this.f61460h = null;
        this.f61461i = null;
        this.f61462m = null;
        this.C = null;
        this.D = null;
        this.E = null;
        this.F = null;
        this.G = null;
        this.H = 0;
        this.J = false;
        K = "AdelieAVPanel_" + e.d();
    }

    private void e(int i3) {
        f(i3);
    }

    private void f(int i3) {
        ClipDrawable clipDrawable = (ClipDrawable) this.D.getResources().getDrawable(R.drawable.k9h);
        this.G = clipDrawable;
        setBtnTopDrawableWithForeGround(this.D, R.drawable.k9g, clipDrawable);
    }

    private void i(boolean z16, boolean z17) {
        this.f61460h = this.f61458e.findViewById(R.id.g7c);
        this.f61461i = (Button) this.f61458e.findViewById(m.l.f76074t);
        this.F = (RelativeLayout) this.f61458e.findViewById(R.id.g6n);
        k();
        this.D = (Button) this.f61458e.findViewById(m.l.O);
        this.E = (Button) this.f61458e.findViewById(m.l.P);
        this.C = this.f61458e.findViewById(m.l.N);
        n(z16, z17 ? 2 : 1, false);
    }

    private void j(int i3) {
        QavPanel.s0((ImageButton) this.f61462m, R.drawable.d_z);
    }

    private void k() {
        View findViewById = ((ViewGroup) getParent()).findViewById(R.id.rba);
        this.f61462m = findViewById;
        if (findViewById == null && e.j()) {
            throw new IllegalArgumentException("\u6ca1\u627e\u5230VIEW_ENUM.HIDE");
        }
    }

    public void b(int i3) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.a87);
        int i16 = this.f61457d;
        int i17 = (i16 == m.a.f75990a || i16 == m.a.f75991b) ? (displayMetrics.widthPixels * x.CTRL_INDEX) / 750 : 0;
        if (QLog.isColorLevel()) {
            QLog.d(K, 2, "adjustPanel, heightPixels[" + displayMetrics.heightPixels + "], widthPixels[" + displayMetrics.widthPixels + "], shadowHeight[" + dimensionPixelSize + "], videoHeight[" + i17 + "], mPanelType[" + this.f61457d + "]");
        }
    }

    public void c() {
        RelativeLayout relativeLayout = this.F;
        if (relativeLayout == null || this.f61461i == null || this.C == null || this.E == null || this.D == null) {
            return;
        }
        relativeLayout.setVisibility(4);
        this.f61461i.setVisibility(0);
        this.C.setVisibility(0);
        QavPanel.setBtnTopDrawable(this.E, R.drawable.k9i);
        o(TraeHelper.I());
        setBtnTopDrawableWithForeGround(this.D, R.drawable.k9g, this.G);
    }

    View d(int i3) {
        View inflate = LayoutInflater.from(getContext()).inflate(i3, (ViewGroup) this, false);
        this.f61458e = inflate;
        return inflate;
    }

    public void h(int i3, boolean z16, boolean z17) {
        if (this.f61459f) {
            return;
        }
        this.f61457d = i3;
        d(i3);
        QLog.d("AVDebug", 1, "init panel type: " + i3);
        i(z16, z17);
        View view = this.f61458e;
        if (view != null) {
            addView(view);
        }
        b(ba.getScreenWidth(getContext()));
        this.f61459f = true;
        e(this.f61457d);
        j(this.f61457d);
        m(z16);
        c();
    }

    void m(boolean z16) {
        r(z16);
    }

    public void n(boolean z16, int i3, boolean z17) {
        if (QLog.isColorLevel()) {
            QLog.d(K, 2, "videoSession :" + z16 + ", localHasVideo:" + i3 + ", isVipFunCall:" + z17);
        }
        m(z16);
    }

    public boolean p(int i3, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d(K, 2, "setViewSelected, id" + m.a(i3) + ", selected[" + z16 + "]");
        }
        View t16 = t(i3);
        if (t16 == null) {
            return false;
        }
        t16.setSelected(z16);
        return true;
    }

    public void r(boolean z16) {
        View view = this.f61460h;
        if (view == null) {
            return;
        }
        if (z16) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
        if (e.e(0) == 1) {
            this.f61460h.setBackgroundColor(-536894208);
        }
    }

    public void setAudioVolumeValue(int i3) {
        int i16;
        Button button = this.D;
        if (button == null || !button.isShown()) {
            return;
        }
        int i17 = this.H;
        this.H = i3;
        if (i3 != i17) {
            ValueAnimator valueAnimator = this.I;
            if (valueAnimator == null || !valueAnimator.isRunning()) {
                i16 = -1;
            } else {
                i17 = ((Integer) this.I.getAnimatedValue()).intValue();
                this.I.cancel();
                i16 = i17;
            }
            if (this.I == null) {
                ValueAnimator valueAnimator2 = new ValueAnimator();
                this.I = valueAnimator2;
                valueAnimator2.addUpdateListener(new a());
            }
            this.I.setDuration(this.H > i17 ? 100L : 200L);
            ValueAnimator valueAnimator3 = this.I;
            int[] iArr = new int[2];
            if (i16 != -1) {
                i17 = i16;
            }
            iArr[0] = i17;
            iArr[1] = this.H;
            valueAnimator3.setIntValues(iArr);
            this.I.start();
            return;
        }
        ClipDrawable clipDrawable = this.G;
        if (clipDrawable != null) {
            clipDrawable.setLevel(i3);
        }
    }

    public void setViewEnable(int i3, boolean z16) {
        if (QLog.isDevelopLevel()) {
            QLog.d(K, 2, "setViewEnable, id" + m.a(i3) + ", enable[" + z16 + "]");
        }
        View t16 = t(i3);
        boolean y06 = QavPanel.y0(i3);
        if (t16 != null) {
            t16.setEnabled(z16);
        }
        if (t16 == null || !y06) {
            return;
        }
        QavPanel.setTopLayerImageBtnEnable((ImageButton) t16, z16);
    }

    public View t(int i3) {
        if (i3 == m.l.O) {
            return this.D;
        }
        if (i3 == m.l.P) {
            return this.E;
        }
        if (i3 == m.l.f76074t) {
            return this.f61461i;
        }
        if (i3 == R.id.rba) {
            return this.f61462m;
        }
        String str = HardCodeUtil.qqStr(R.string.pqz) + i3 + "]\uff0cName[" + m.a(i3) + "]\uff0cName[" + e.h(this, i3);
        QLog.d(K, 1, str);
        if (e.j()) {
            throw new IllegalArgumentException(str);
        }
        return null;
    }

    public void g(int i3) {
        h(i3, false, false);
    }

    public void l(long j3) {
        this.H = 0;
        ValueAnimator valueAnimator = this.I;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.I = null;
        }
        View view = this.f61458e;
        if (view != null) {
            removeView(view);
            this.f61458e = null;
        }
        View view2 = this.f61460h;
        if (view2 != null) {
            view2.setBackground(null);
            this.f61460h = null;
        }
        Button button = this.f61461i;
        if (button != null) {
            button.setBackground(null);
            this.f61461i = null;
        }
        View view3 = this.f61462m;
        if (view3 != null) {
            ((ImageButton) view3).setImageDrawable(null);
            this.f61462m = null;
        }
        this.G = null;
        RelativeLayout relativeLayout = this.F;
        if (relativeLayout != null) {
            relativeLayout.clearAnimation();
            this.F = null;
        }
        View view4 = this.C;
        if (view4 != null) {
            view4.clearAnimation();
            this.C = null;
        }
        Button button2 = this.D;
        if (button2 != null) {
            button2.setCompoundDrawables(null, null, null, null);
            this.D = null;
        }
        Button button3 = this.E;
        if (button3 != null) {
            button3.setCompoundDrawables(null, null, null, null);
            this.E = null;
        }
        QLog.d(K, 1, "onDestroy.");
    }

    public boolean o(TraeHelper traeHelper) {
        Button button;
        if (traeHelper == null || (button = this.E) == null) {
            return false;
        }
        traeHelper.c0(button);
        return true;
    }

    public static void setBtnTopDrawableWithForeGround(TextView textView, int i3, Drawable drawable) {
        if (textView == null) {
            return;
        }
        textView.setCompoundDrawables(null, l.a(textView.getResources(), i3, R.color.f157511rl, false, R.drawable.d_p, R.color.b46, drawable, true), null, null);
    }

    public void s(boolean z16, boolean z17) {
        if (z17) {
            this.J = false;
            this.H = 0;
            ValueAnimator valueAnimator = this.I;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.I = null;
            }
            ClipDrawable clipDrawable = this.G;
            if (clipDrawable != null) {
                clipDrawable.setLevel(0);
                return;
            }
            return;
        }
        this.J = true;
    }

    public AdelieAVPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f61457d = 0;
        this.f61458e = null;
        this.f61459f = false;
        this.f61460h = null;
        this.f61461i = null;
        this.f61462m = null;
        this.C = null;
        this.D = null;
        this.E = null;
        this.F = null;
        this.G = null;
        this.H = 0;
        this.J = false;
        K = "AdelieAVPanel_" + e.d();
    }

    public AdelieAVPanel(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f61457d = 0;
        this.f61458e = null;
        this.f61459f = false;
        this.f61460h = null;
        this.f61461i = null;
        this.f61462m = null;
        this.C = null;
        this.D = null;
        this.E = null;
        this.F = null;
        this.G = null;
        this.H = 0;
        this.J = false;
        K = "AdelieAVPanel_" + e.d();
    }

    public void q(QQFrameByFrameAnimation qQFrameByFrameAnimation) {
    }
}
