package com.tencent.sqshow.zootopia.recommend.main.dress.ui.detail;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.internal.view.SupportMenu;
import androidx.viewpager.widget.ViewPager;

/* compiled from: P */
/* loaded from: classes34.dex */
public class SimpleCircleIndicator extends View implements ViewPager.OnPageChangeListener {
    private int C;
    private int D;
    private int E;
    private int F;
    private Paint G;
    private int H;
    private Paint I;
    private int J;
    private ViewPager K;
    private int L;

    /* renamed from: d, reason: collision with root package name */
    private int f372611d;

    /* renamed from: e, reason: collision with root package name */
    private int f372612e;

    /* renamed from: f, reason: collision with root package name */
    private int f372613f;

    /* renamed from: h, reason: collision with root package name */
    private int f372614h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f372615i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f372616m;

    /* compiled from: P */
    /* loaded from: classes34.dex */
    class a extends DataSetObserver {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewPager f372617a;

        a(ViewPager viewPager) {
            this.f372617a = viewPager;
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            super.onChanged();
            SimpleCircleIndicator.this.setCurrentItem(this.f372617a.getCurrentItem());
        }
    }

    public SimpleCircleIndicator(Context context) {
        this(context, null);
    }

    private void c(Context context, AttributeSet attributeSet) {
        Paint.Style style;
        Paint.Style style2;
        if (isInEditMode()) {
            return;
        }
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m74.a.f416395h);
            this.f372611d = obtainStyledAttributes.getDimensionPixelSize(m74.a.f416396i, 40);
            this.f372612e = obtainStyledAttributes.getDimensionPixelSize(m74.a.f416399l, 10);
            this.f372613f = obtainStyledAttributes.getDimensionPixelSize(m74.a.f416403p, 10);
            this.F = obtainStyledAttributes.getColor(m74.a.f416398k, SupportMenu.CATEGORY_MASK);
            this.H = obtainStyledAttributes.getColor(m74.a.f416402o, -1);
            this.C = obtainStyledAttributes.getDimensionPixelSize(m74.a.f416400m, 1);
            this.D = obtainStyledAttributes.getDimensionPixelSize(m74.a.f416404q, 1);
            this.f372615i = obtainStyledAttributes.getBoolean(m74.a.f416397j, false);
            this.f372616m = obtainStyledAttributes.getBoolean(m74.a.f416401n, false);
            obtainStyledAttributes.recycle();
        }
        this.f372614h = Math.max(this.f372612e, this.f372613f);
        this.E = Math.max(this.C, this.D);
        Paint paint = new Paint();
        this.G = paint;
        if (this.f372615i) {
            style = Paint.Style.STROKE;
        } else {
            style = Paint.Style.FILL;
        }
        paint.setStyle(style);
        this.G.setStrokeWidth(this.C);
        this.G.setAntiAlias(true);
        this.G.setColor(this.F);
        Paint paint2 = new Paint();
        this.I = paint2;
        if (this.f372616m) {
            style2 = Paint.Style.STROKE;
        } else {
            style2 = Paint.Style.FILL;
        }
        paint2.setStyle(style2);
        this.I.setStrokeWidth(this.D);
        this.I.setStyle(Paint.Style.FILL);
        this.I.setAntiAlias(true);
        this.I.setColor(this.H);
    }

    public int a() {
        return this.L;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f16;
        float f17;
        int i3;
        int i16;
        int width = getWidth();
        int b16 = b();
        if (b16 <= 1) {
            return;
        }
        int i17 = this.C;
        int i18 = this.D;
        int i19 = this.f372611d + i18;
        int i26 = this.f372613f;
        int i27 = ((b16 - 1) * (i19 + (i26 * 2))) + i17;
        int i28 = this.f372612e;
        int i29 = i27 + (i28 * 2);
        if (this.J == 0) {
            f16 = ((width - i29) / 2.0f) + i28;
            f17 = i17 / 2;
        } else {
            f16 = ((width - i29) / 2.0f) + i26;
            f17 = i18 / 2;
        }
        int i36 = (int) (f16 + f17 + 0.5d);
        int height = (int) ((getHeight() / 2.0f) + 0.5d);
        int i37 = 0;
        while (i37 < b16) {
            if (i37 == this.J) {
                canvas.drawCircle(i36, height, this.f372612e, this.G);
                i36 += this.f372611d + this.f372613f + this.f372612e + ((this.D + this.C) / 2);
                i37++;
            } else {
                canvas.drawCircle(i36, height, this.f372613f, this.I);
                i37++;
                if (i37 == this.J) {
                    i3 = this.f372611d + this.f372613f + this.f372612e;
                    i16 = (this.D + this.C) / 2;
                } else {
                    i3 = this.f372611d + (this.f372613f * 2);
                    i16 = this.D;
                }
                i36 += i3 + i16;
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        int i17;
        int i18;
        super.onMeasure(i3, i16);
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        int mode2 = View.MeasureSpec.getMode(i16);
        int size2 = View.MeasureSpec.getSize(i16);
        if (mode != 1073741824) {
            size = (this.f372612e * 2) + this.C + ((b() - 1) * (this.D + this.f372611d + (this.f372613f * 2)));
            if (mode2 != 1073741824) {
                i17 = this.f372614h * 2;
                i18 = this.E;
                size2 = i17 + i18;
            }
        } else if (mode2 != 1073741824) {
            i17 = this.f372614h * 2;
            i18 = this.E;
            size2 = i17 + i18;
        }
        setMeasuredDimension(size, size2);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i3) {
        if (i3 >= b()) {
            i3 = b() - 1;
        }
        if (b() > 0) {
            this.J = i3 % b();
        } else {
            this.J = -1;
        }
        invalidate();
    }

    public void setCurrentItem(int i3) {
        onPageSelected(i3);
    }

    public void setMaxCount(int i3) {
        this.L = i3;
        invalidate();
    }

    public SimpleCircleIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f372611d = 30;
        this.L = -1;
        c(context, attributeSet);
    }

    private int b() {
        try {
            ViewPager viewPager = this.K;
            if (viewPager == null) {
                return 0;
            }
            int count = viewPager.getAdapter().getCount();
            return (a() <= 0 || a() >= count) ? count : a();
        } catch (Exception unused) {
            return 0;
        }
    }

    public void setViewPager(ViewPager viewPager) {
        if (viewPager != null && viewPager.getAdapter() != null) {
            viewPager.removeOnPageChangeListener(this);
            viewPager.addOnPageChangeListener(this);
            this.K = viewPager;
            viewPager.getAdapter().registerDataSetObserver(new a(viewPager));
            setCurrentItem(0);
            return;
        }
        throw new IllegalStateException("you must initial the viewpager with adapter");
    }

    public SimpleCircleIndicator(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f372611d = 30;
        this.L = -1;
        c(context, attributeSet);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i3) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i3, float f16, int i16) {
    }
}
