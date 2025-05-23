package com.tencent.mobileqq.colornote.swipe;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.colornote.api.IColorNoteUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQTheme;

/* loaded from: classes5.dex */
public class PostTable extends RelativeLayout {
    private int C;
    private int D;
    private int E;
    private int F;
    private int G;
    private ImageView H;
    private ImageView I;
    private TextView J;
    private TextView K;
    private View L;
    private boolean M;

    /* renamed from: d, reason: collision with root package name */
    public RelativeLayout f201707d;

    /* renamed from: e, reason: collision with root package name */
    private Context f201708e;

    /* renamed from: f, reason: collision with root package name */
    private int f201709f;

    /* renamed from: h, reason: collision with root package name */
    private int f201710h;

    /* renamed from: i, reason: collision with root package name */
    private int f201711i;

    /* renamed from: m, reason: collision with root package name */
    private int f201712m;

    public PostTable(Context context) {
        super(context);
        this.M = false;
        a(context);
    }

    private void a(Context context) {
        this.f201708e = context;
        this.G = 0;
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.c7p, this);
        this.f201707d = relativeLayout;
        this.H = (ImageView) relativeLayout.findViewById(R.id.f166535m05);
        this.I = (ImageView) this.f201707d.findViewById(R.id.m06);
        this.J = (TextView) this.f201707d.findViewById(R.id.m07);
        this.K = (TextView) this.f201707d.findViewById(R.id.f166534m04);
        this.L = this.f201707d.findViewById(R.id.f166533m03);
        d();
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        this.f201711i = windowManager.getDefaultDisplay().getWidth();
        this.f201712m = windowManager.getDefaultDisplay().getHeight();
        c();
    }

    private void c() {
        this.f201709f = this.f201708e.getResources().getDimensionPixelSize(R.dimen.b7j);
        int dimensionPixelSize = this.f201708e.getResources().getDimensionPixelSize(R.dimen.b7k);
        this.f201709f = (int) (this.f201709f * 1.0833334f);
        this.f201710h = (int) (dimensionPixelSize * 1.0f);
        int dimensionPixelSize2 = this.f201712m - getResources().getDimensionPixelSize(R.dimen.b7i);
        this.E = dimensionPixelSize2;
        this.D = dimensionPixelSize2 - this.f201709f;
        int i3 = this.f201711i;
        this.C = i3;
        this.F = i3 + this.f201710h;
    }

    private void d() {
        Drawable drawable;
        boolean isUseNewColorNoteStyle = ((IColorNoteUtil) QRoute.api(IColorNoteUtil.class)).isUseNewColorNoteStyle();
        if (QQTheme.isNowThemeIsNight()) {
            if (isUseNewColorNoteStyle) {
                drawable = getResources().getDrawable(R.drawable.jhi);
            } else {
                drawable = getResources().getDrawable(R.drawable.hbx);
            }
        } else if (isUseNewColorNoteStyle) {
            drawable = getResources().getDrawable(R.drawable.jhg);
        } else {
            drawable = getResources().getDrawable(R.drawable.hbw);
        }
        this.L.setBackground(drawable);
    }

    private void e() {
        this.K.setVisibility(0);
        this.J.setVisibility(8);
        this.I.setVisibility(8);
        this.H.setVisibility(8);
    }

    private void f() {
        this.K.setVisibility(4);
        this.J.setVisibility(0);
        this.I.setVisibility(0);
        this.H.setVisibility(0);
        this.I.setScaleX(0.0f);
        this.I.setScaleY(0.0f);
    }

    public void b(double d16) {
        if (this.M) {
            c();
            this.M = false;
        }
        int i3 = this.f201711i;
        int i16 = this.f201710h;
        int i17 = i3 - ((int) (i16 * d16));
        this.C = i17;
        int i18 = (i3 - ((int) (d16 * i16))) + i16;
        this.F = i18;
        layout(i17, this.D, i18, this.E);
        invalidate();
    }

    public void g() {
        int i3 = this.G;
        if (i3 == 1) {
            return;
        }
        if (i3 == 2) {
            f();
        }
        this.M = true;
        this.G = 1;
        b.b(this.H, 300, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f);
        b.b(this.I, 300, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f);
        b.a(this.L, 300, 1.0f, 1.0f, 1.0f, 1.0833334f);
    }

    public void h() {
        if (this.G == 2) {
            return;
        }
        this.M = true;
        e();
        this.G = 2;
        this.L.setScaleX(1.0f);
        this.L.setScaleY(1.0833334f);
    }

    public void i() {
        int i3 = this.G;
        if (i3 == 0) {
            return;
        }
        if (i3 == 2) {
            f();
        }
        this.M = true;
        this.G = 0;
        b.b(this.I, 300, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f);
        b.b(this.H, 300, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f);
        b.a(this.L, 300, 1.0f, 1.0f, 1.0833334f, 1.0f);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, this.C, this.D, this.F, this.E);
        if (i16 == 0) {
            layout(this.C, this.D, this.F, this.E);
        }
    }

    public PostTable(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.M = false;
        a(context);
    }
}
