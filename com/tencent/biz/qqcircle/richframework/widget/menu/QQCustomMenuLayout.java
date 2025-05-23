package com.tencent.biz.qqcircle.richframework.widget.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.qqcircle.richframework.widget.menu.BubblePopupWindow;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QQCustomMenuLayout extends LinearLayout {
    private int C;
    private int D;
    private d E;
    private d F;
    private int G;
    private boolean H;
    private Integer I;
    private rb0.b J;
    private BubblePopupWindow.f K;

    /* renamed from: d, reason: collision with root package name */
    private BubblePopupWindow f92206d;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.biz.qqcircle.richframework.widget.menu.c f92207e;

    /* renamed from: f, reason: collision with root package name */
    private View.OnClickListener f92208f;

    /* renamed from: h, reason: collision with root package name */
    private Context f92209h;

    /* renamed from: i, reason: collision with root package name */
    private int f92210i;

    /* renamed from: m, reason: collision with root package name */
    private int f92211m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QQCustomMenuLayout.this.f92206d.u();
            QQCustomMenuLayout.this.f92208f.onClick(view);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f92214d;

        c(boolean z16) {
            this.f92214d = z16;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i3;
            EventCollector.getInstance().onViewClickedBefore(view);
            QQCustomMenuLayout qQCustomMenuLayout = QQCustomMenuLayout.this;
            if (this.f92214d) {
                i3 = qQCustomMenuLayout.f92210i + 1;
            } else {
                i3 = qQCustomMenuLayout.f92210i - 1;
            }
            qQCustomMenuLayout.f92210i = i3;
            qQCustomMenuLayout.l(qQCustomMenuLayout.r(i3), true);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class d extends LinearLayout {
        public d(Context context) {
            super(context);
            setOrientation(0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            addView(QQCustomMenuLayout.this.J.d(getContext()));
        }
    }

    public QQCustomMenuLayout(Context context) {
        super(context);
        this.f92210i = 0;
        this.D = qb0.a.f428778a;
        this.H = false;
        this.I = null;
        this.K = new a();
        this.f92209h = context;
        setOrientation(1);
        rb0.d dVar = new rb0.d();
        this.J = dVar;
        setMenuContainerStyle(dVar);
    }

    private void g(boolean z16) {
        int i3;
        int i16;
        View view = new View(this.f92209h);
        Resources resources = this.f92209h.getResources();
        if (z16) {
            i3 = R.color.c4z;
        } else {
            i3 = R.color.f157325c51;
        }
        view.setBackgroundColor(resources.getColor(i3));
        addView(view, new LinearLayout.LayoutParams(-1, 1));
        View view2 = new View(this.f92209h);
        Resources resources2 = this.f92209h.getResources();
        if (z16) {
            i16 = R.color.c4y;
        } else {
            i16 = R.color.f157324c50;
        }
        view2.setBackgroundColor(resources2.getColor(i16));
        addView(view2, new LinearLayout.LayoutParams(-1, 1));
    }

    private TextView i(int i3, boolean z16, float[] fArr) {
        int i16;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        Resources resources = this.f92209h.getResources();
        if (z16) {
            i16 = R.color.c4t;
        } else {
            i16 = R.color.c4v;
        }
        gradientDrawable.setColor(resources.getColor(i16));
        gradientDrawable.setCornerRadii(fArr);
        TextView textView = new TextView(getContext());
        textView.setText("");
        textView.setTextSize(1.0f);
        textView.setWidth(i3);
        textView.setMaxLines(1);
        textView.setPadding(0, 0, 0, 0);
        textView.setTextColor(-1);
        textView.setBackgroundDrawable(gradientDrawable);
        textView.setGravity(17);
        return textView;
    }

    private View k(com.tencent.biz.qqcircle.richframework.widget.menu.b bVar, float[] fArr) {
        StateListDrawable u16 = u(fArr);
        String c16 = bVar.c();
        if (this.H && c16.length() > 4) {
            c16 = c16.substring(0, 3) + "\u2026";
        }
        TextView textView = new TextView(getContext());
        textView.setText(c16);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setTextSize(bVar.b().a());
        textView.setMaxLines(1);
        textView.setContentDescription(bVar.c());
        textView.setTextColor(bVar.b().b(this.f92209h));
        textView.setIncludeFontPadding(true);
        textView.setCompoundDrawables(bVar.f92219c, null, null, null);
        textView.setGravity(17);
        View m3 = m(textView);
        m3.setBackgroundDrawable(u16);
        m3.setId(bVar.a());
        return m3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(int i3, boolean z16) {
        d dVar;
        TextView i16;
        View k3;
        float[] w3;
        float[] w16;
        float[] v3;
        int width = getWidth();
        removeAllViews();
        int f16 = this.f92207e.f() - i3;
        boolean z17 = true;
        int i17 = this.D;
        if (i3 != 0) {
            i17--;
        }
        int i18 = this.D * 2;
        if (i3 != 0) {
            i18--;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQCustomMenuNoIconLayout", 2, "[menu] showMenu offset: " + i3 + " count: " + f16);
        }
        int i19 = 0;
        while (true) {
            if (i19 >= f16) {
                break;
            }
            com.tencent.biz.qqcircle.richframework.widget.menu.b d16 = this.f92207e.d(i19 + i3);
            if (i19 == 0) {
                if (i3 == 0 && f16 == 1) {
                    v3 = p();
                } else if (f16 <= i17) {
                    v3 = q();
                } else {
                    v3 = v();
                }
                k3 = k(d16, v3);
            } else if ((i3 == 0 && i19 == i17 - 1) || (i3 == 0 && f16 < i17 && i19 == f16 - 1)) {
                if (f16 <= i17) {
                    w3 = t();
                } else {
                    w3 = w();
                }
                k3 = k(d16, w3);
            } else if (i19 == i17) {
                k3 = k(d16, n());
            } else if (i19 == i18 - 1) {
                k3 = k(d16, o());
            } else {
                k3 = k(d16, s());
            }
            if (i19 < i17) {
                if (this.E == null) {
                    this.E = new d(this.f92209h);
                }
                this.E.addView(k3, new LinearLayout.LayoutParams(this.f92211m, -1));
                if (i19 < i17 - 1) {
                    if (i19 != f16 - 1) {
                        this.E.b();
                    }
                } else if (i3 > 0) {
                    this.E.b();
                    d dVar2 = this.E;
                    if (f16 <= i17) {
                        w16 = t();
                    } else {
                        w16 = w();
                    }
                    dVar2.addView(j(false, w16), new LinearLayout.LayoutParams(this.f92211m, -1));
                }
            } else if (i19 < i18) {
                if (this.F == null) {
                    this.F = new d(this.f92209h);
                }
                this.F.addView(k3, new LinearLayout.LayoutParams(this.f92211m, -1));
                if (i19 < i18 - 1) {
                    this.F.b();
                }
            } else {
                d dVar3 = this.F;
                if (dVar3 != null) {
                    dVar3.removeViewAt(dVar3.getChildCount() - 1);
                    this.F.addView(j(true, o()), new LinearLayout.LayoutParams(this.f92211m, -1));
                }
            }
            i19++;
        }
        if (f16 > i17 && f16 < i18 && this.F != null) {
            int i26 = i18 - f16;
            for (int i27 = 0; i27 < i26; i27++) {
                int i28 = i26 - 1;
                if (i27 == i28) {
                    i16 = i(this.f92211m, false, o());
                } else {
                    i16 = i(this.f92211m, false, s());
                }
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.f92211m, -1);
                layoutParams.gravity = 16;
                this.F.addView(i16, layoutParams);
                if (i27 < i28) {
                    this.F.b();
                }
            }
        }
        if (i3 > 0 && f16 < i17 && (dVar = this.E) != null) {
            dVar.b();
            this.E.addView(j(false, t()), new LinearLayout.LayoutParams(this.f92211m, -1));
        }
        addView(this.E, new LinearLayout.LayoutParams(-2, this.C));
        if (this.F != null) {
            g(false);
            addView(this.F, new LinearLayout.LayoutParams(-2, this.C));
        }
        if (z16) {
            int min = ((this.f92211m + 1) * Math.min(f16 + 1, this.D)) - 1;
            BubblePopupWindow bubblePopupWindow = this.f92206d;
            if (f16 < i17) {
                z17 = false;
            }
            bubblePopupWindow.Q(min, z17, width);
        }
    }

    private float[] n() {
        int i3 = this.G;
        return new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, i3, i3};
    }

    private float[] o() {
        int i3 = this.G;
        return new float[]{0.0f, 0.0f, 0.0f, 0.0f, i3, i3, 0.0f, 0.0f};
    }

    private float[] p() {
        int i3 = this.G;
        return new float[]{i3, i3, i3, i3, i3, i3, i3, i3};
    }

    private float[] q() {
        int i3 = this.G;
        return new float[]{i3, i3, 0.0f, 0.0f, 0.0f, 0.0f, i3, i3};
    }

    private float[] s() {
        return new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
    }

    private float[] t() {
        int i3 = this.G;
        return new float[]{0.0f, 0.0f, i3, i3, i3, i3, 0.0f, 0.0f};
    }

    private StateListDrawable u(float[] fArr) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(this.J.e(this.f92209h));
        gradientDrawable.setCornerRadii(fArr);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(0);
        gradientDrawable2.setColor(this.J.f(this.f92209h));
        gradientDrawable2.setCornerRadii(fArr);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.setExitFadeDuration(400);
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, gradientDrawable2);
        stateListDrawable.addState(new int[0], gradientDrawable);
        return stateListDrawable;
    }

    private float[] v() {
        int i3 = this.G;
        return new float[]{i3, i3, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
    }

    private float[] w() {
        int i3 = this.G;
        return new float[]{0.0f, 0.0f, i3, i3, 0.0f, 0.0f, 0.0f, 0.0f};
    }

    public void h() {
        l(0, false);
    }

    protected ImageView j(boolean z16, float[] fArr) {
        int i3;
        int i16;
        StateListDrawable u16 = u(fArr);
        ImageView imageView = new ImageView(getContext());
        if (z16) {
            i3 = R.drawable.o09;
        } else {
            i3 = R.drawable.o0_;
        }
        imageView.setImageResource(i3);
        Resources resources = getResources();
        if (z16) {
            i16 = R.string.f221486ay;
        } else {
            i16 = R.string.f221496az;
        }
        imageView.setContentDescription(resources.getString(i16));
        imageView.setBackgroundDrawable(u16);
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        imageView.setOnClickListener(new c(z16));
        return imageView;
    }

    protected View m(View view) {
        FrameLayout frameLayout = new FrameLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        frameLayout.addView(view, layoutParams);
        frameLayout.setOnClickListener(new b());
        return frameLayout;
    }

    int r(int i3) {
        if (i3 <= 0) {
            return 0;
        }
        int i16 = this.D;
        return ((i16 * 2) - 1) + 0 + ((i3 - 1) * ((i16 * 2) - 2));
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        super.removeAllViews();
        this.E = null;
        this.F = null;
    }

    public void setContainerBottom(Integer num) {
        this.I = num;
    }

    public void setIgnoreTouchLocation(boolean z16) {
        this.H = z16;
    }

    public void setMenuContainerStyle(rb0.b bVar) {
        this.J = bVar;
        this.G = bVar.c();
        this.f92211m = bVar.a();
        this.C = bVar.b();
    }

    public void setMenuIconClickListener(View.OnClickListener onClickListener) {
        this.f92208f = onClickListener;
    }

    public void setMenuList(com.tencent.biz.qqcircle.richframework.widget.menu.c cVar) {
        this.f92207e = cVar.e();
        if (QLog.isColorLevel()) {
            QLog.d("QQCustomMenuNoIconLayout", 4, "[menu] setMenu MENU:" + this.f92207e.toString());
        }
    }

    public void setPopupWindow(BubblePopupWindow bubblePopupWindow) {
        this.f92206d = bubblePopupWindow;
        bubblePopupWindow.J(this.K);
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a implements BubblePopupWindow.f {
        a() {
        }

        @Override // com.tencent.biz.qqcircle.richframework.widget.menu.BubblePopupWindow.f
        public void onMenuNoIconEmptyClick() {
        }
    }
}
