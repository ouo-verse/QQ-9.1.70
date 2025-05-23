package com.tencent.mobileqq.now.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.internal.view.SupportMenu;
import androidx.viewpager.widget.ViewPager;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes9.dex */
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
    private int f254402d;

    /* renamed from: e, reason: collision with root package name */
    private int f254403e;

    /* renamed from: f, reason: collision with root package name */
    private int f254404f;

    /* renamed from: h, reason: collision with root package name */
    private int f254405h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f254406i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f254407m;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class a extends DataSetObserver {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewPager f254408a;

        a(ViewPager viewPager) {
            this.f254408a = viewPager;
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            super.onChanged();
            SimpleCircleIndicator.this.setCurrentItem(this.f254408a.getCurrentItem());
        }
    }

    public SimpleCircleIndicator(Context context) {
        this(context, null);
    }

    private int b() {
        try {
            ViewPager viewPager = this.K;
            if (viewPager == null) {
                return 0;
            }
            int count = viewPager.getAdapter().getCount();
            if (a() > 0 && a() < count) {
                return a();
            }
            return count;
        } catch (Exception unused) {
            return 0;
        }
    }

    private void c(Context context, AttributeSet attributeSet) {
        Paint.Style style;
        Paint.Style style2;
        if (isInEditMode()) {
            return;
        }
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SimpleCircleIndicator);
            this.f254402d = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SimpleCircleIndicator_dot_interval, 40);
            this.f254403e = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SimpleCircleIndicator_selected_radius, 10);
            this.f254404f = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SimpleCircleIndicator_unselected_radius, 10);
            this.F = obtainStyledAttributes.getColor(R.styleable.SimpleCircleIndicator_selected_color, SupportMenu.CATEGORY_MASK);
            this.H = obtainStyledAttributes.getColor(R.styleable.SimpleCircleIndicator_unselected_color, -1);
            this.C = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SimpleCircleIndicator_selected_strokeWidth, 1);
            this.D = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SimpleCircleIndicator_unselected_strokeWidth, 1);
            this.f254406i = obtainStyledAttributes.getBoolean(R.styleable.SimpleCircleIndicator_selectedStroke, false);
            this.f254407m = obtainStyledAttributes.getBoolean(R.styleable.SimpleCircleIndicator_unselectedStroke, false);
            obtainStyledAttributes.recycle();
        }
        this.f254405h = Math.max(this.f254403e, this.f254404f);
        this.E = Math.max(this.C, this.D);
        Paint paint = new Paint();
        this.G = paint;
        if (this.f254406i) {
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
        if (this.f254407m) {
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
        int i19 = this.f254402d + i18;
        int i26 = this.f254404f;
        int i27 = ((b16 - 1) * (i19 + (i26 * 2))) + i17;
        int i28 = this.f254403e;
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
                canvas.drawCircle(i36, height, this.f254403e, this.G);
                i36 += this.f254402d + this.f254404f + this.f254403e + ((this.D + this.C) / 2);
                i37++;
            } else {
                canvas.drawCircle(i36, height, this.f254404f, this.I);
                i37++;
                if (i37 == this.J) {
                    i3 = this.f254402d + this.f254404f + this.f254403e;
                    i16 = (this.D + this.C) / 2;
                } else {
                    i3 = this.f254402d + (this.f254404f * 2);
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
        if (mode == 1073741824) {
            if (mode2 != 1073741824) {
                i17 = this.f254405h * 2;
                i18 = this.E;
                size2 = i17 + i18;
            }
        } else {
            size = (this.f254403e * 2) + this.C + ((b() - 1) * (this.D + this.f254402d + (this.f254404f * 2)));
            if (mode2 != 1073741824) {
                i17 = this.f254405h * 2;
                i18 = this.E;
                size2 = i17 + i18;
            }
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

    public SimpleCircleIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f254402d = 30;
        this.L = -1;
        c(context, attributeSet);
    }

    public SimpleCircleIndicator(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f254402d = 30;
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
