package com.tencent.mobileqq.wink.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.viewpager.widget.ViewPager;
import com.tencent.mobileqq.R;

/* loaded from: classes21.dex */
public class WinkPageIndicator extends View implements ViewPager.OnPageChangeListener {
    private int C;
    private int D;
    private float E;
    private int F;
    private int G;
    private boolean H;
    private boolean I;
    private float J;

    /* renamed from: d, reason: collision with root package name */
    private float f326886d;

    /* renamed from: e, reason: collision with root package name */
    private final Paint f326887e;

    /* renamed from: f, reason: collision with root package name */
    private final Paint f326888f;

    /* renamed from: h, reason: collision with root package name */
    private final Paint f326889h;

    /* renamed from: i, reason: collision with root package name */
    private ViewPager f326890i;

    /* renamed from: m, reason: collision with root package name */
    private ViewPager.OnPageChangeListener f326891m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes21.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: d, reason: collision with root package name */
        int f326892d;

        /* loaded from: classes21.dex */
        class a implements Parcelable.Creator<SavedState> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i3) {
                return new SavedState[i3];
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeInt(this.f326892d);
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.f326892d = parcel.readInt();
        }
    }

    public WinkPageIndicator(Context context) {
        this(context, null);
    }

    private int a(int i3) {
        ViewPager viewPager;
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        if (mode != 1073741824 && (viewPager = this.f326890i) != null) {
            int count = viewPager.getAdapter().getCount();
            float paddingLeft = getPaddingLeft() + getPaddingRight();
            float f16 = this.f326886d;
            int i16 = (int) (paddingLeft + (count * 2 * f16) + ((count - 1) * f16) + 1.0f);
            if (mode == Integer.MIN_VALUE) {
                return Math.min(i16, size);
            }
            return i16;
        }
        return size;
    }

    private int b(int i3) {
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        if (mode != 1073741824) {
            int paddingTop = (int) ((this.f326886d * 2.0f) + getPaddingTop() + getPaddingBottom() + 1.0f);
            if (mode == Integer.MIN_VALUE) {
                return Math.min(paddingTop, size);
            }
            return paddingTop;
        }
        return size;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int count;
        int height;
        int paddingTop;
        int paddingBottom;
        int paddingLeft;
        int i3;
        float f16;
        float f17;
        super.onDraw(canvas);
        Log.i("WinkPageIndicator", "onDraw");
        ViewPager viewPager = this.f326890i;
        if (viewPager == null || (count = viewPager.getAdapter().getCount()) == 0) {
            return;
        }
        if (this.C >= count) {
            setCurrentItem(count - 1);
            return;
        }
        if (this.G == 0) {
            height = getWidth();
            paddingTop = getPaddingLeft();
            paddingBottom = getPaddingRight();
            paddingLeft = getPaddingTop();
        } else {
            height = getHeight();
            paddingTop = getPaddingTop();
            paddingBottom = getPaddingBottom();
            paddingLeft = getPaddingLeft();
        }
        float f18 = this.f326886d;
        float f19 = f18 * 2.0f;
        float f26 = this.J;
        if (f26 == 0.0f) {
            f26 = f18;
        }
        float f27 = f19 + f26;
        float f28 = paddingLeft + f18;
        float f29 = paddingTop + f18;
        if (this.H) {
            f29 += (((height - paddingTop) - paddingBottom) / 2.0f) - ((count * f27) / 2.0f);
        }
        if (this.f326888f.getStrokeWidth() > 0.0f) {
            f18 -= this.f326888f.getStrokeWidth() / 2.0f;
        }
        for (int i16 = 0; i16 < count; i16++) {
            float f36 = (i16 * f27) + f29;
            if (this.G == 0) {
                f17 = f28;
            } else {
                f17 = f36;
                f36 = f28;
            }
            if (this.f326887e.getAlpha() > 0) {
                canvas.drawCircle(f36, f17, f18, this.f326887e);
            }
            float f37 = this.f326886d;
            if (f18 != f37) {
                canvas.drawCircle(f36, f17, f37, this.f326888f);
            }
        }
        boolean z16 = this.I;
        if (z16) {
            i3 = this.D;
        } else {
            i3 = this.C;
        }
        float f38 = i3 * f27;
        if (!z16) {
            f38 += this.E * f27;
        }
        if (this.G == 0) {
            float f39 = f29 + f38;
            f16 = f28;
            f28 = f39;
        } else {
            f16 = f29 + f38;
        }
        canvas.drawCircle(f28, f16, this.f326886d, this.f326889h);
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        if (this.G == 0) {
            setMeasuredDimension(a(i3), b(i16));
        } else {
            setMeasuredDimension(b(i3), a(i16));
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i3) {
        this.F = i3;
        ViewPager.OnPageChangeListener onPageChangeListener = this.f326891m;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrollStateChanged(i3);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i3, float f16, int i16) {
        this.C = i3;
        this.E = f16;
        invalidate();
        ViewPager.OnPageChangeListener onPageChangeListener = this.f326891m;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrolled(i3, f16, i16);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i3) {
        if (this.I || this.F == 0) {
            this.C = i3;
            this.D = i3;
            postInvalidate();
        }
        ViewPager.OnPageChangeListener onPageChangeListener = this.f326891m;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageSelected(i3);
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        int i3 = savedState.f326892d;
        this.C = i3;
        this.D = i3;
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f326892d = this.C;
        return savedState;
    }

    public void setCentered(boolean z16) {
        this.H = z16;
        invalidate();
    }

    public void setCirclePadding(int i3) {
        this.J = i3;
    }

    public void setCurrentItem(int i3) {
        ViewPager viewPager = this.f326890i;
        if (viewPager != null) {
            viewPager.setCurrentItem(i3);
            this.C = i3;
            invalidate();
            return;
        }
        throw new IllegalStateException("ViewPager has not been bound.");
    }

    public void setFillColor(int i3) {
        this.f326889h.setColor(i3);
        invalidate();
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.f326891m = onPageChangeListener;
    }

    public void setOrientation(int i3) {
        if (i3 != 0 && i3 != 1) {
            throw new IllegalArgumentException("Orientation must be either HORIZONTAL or VERTICAL.");
        }
        this.G = i3;
        requestLayout();
    }

    public void setPageColor(int i3) {
        this.f326887e.setColor(i3);
        invalidate();
    }

    public void setRadius(float f16) {
        this.f326886d = f16;
        invalidate();
    }

    public void setSnap(boolean z16) {
        this.I = z16;
        invalidate();
    }

    public void setStrokeColor(int i3) {
        this.f326888f.setColor(i3);
        invalidate();
    }

    public void setStrokeWidth(float f16) {
        this.f326888f.setStrokeWidth(f16);
        invalidate();
    }

    public void setViewPager(ViewPager viewPager) {
        if (this.f326890i == viewPager && viewPager.getCurrentItem() == this.C) {
            return;
        }
        ViewPager viewPager2 = this.f326890i;
        if (viewPager2 != null) {
            int currentItem = viewPager2.getCurrentItem();
            int i3 = this.C;
            if (currentItem != i3) {
                this.f326890i.setCurrentItem(i3);
            }
            this.f326890i.setOnPageChangeListener(null);
        }
        if (viewPager.getAdapter() != null) {
            this.f326890i = viewPager;
            viewPager.setOnPageChangeListener(this);
            invalidate();
        }
    }

    public WinkPageIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.f155281b);
    }

    public WinkPageIndicator(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Paint paint = new Paint(1);
        this.f326887e = paint;
        Paint paint2 = new Paint(1);
        this.f326888f = paint2;
        Paint paint3 = new Paint(1);
        this.f326889h = paint3;
        if (isInEditMode()) {
            return;
        }
        Resources resources = getResources();
        int color = resources.getColor(R.color.f157021hs);
        int color2 = resources.getColor(R.color.skin_default_indicator);
        int color3 = resources.getColor(R.color.f157022ht);
        float dimension = resources.getDimension(R.dimen.f158651ll);
        float dimension2 = resources.getDimension(R.dimen.f158650lk);
        float dimension3 = resources.getDimension(R.dimen.c7w);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.tencent.mobileqq.wink.j.F0, i3, 0);
        this.H = obtainStyledAttributes.getBoolean(com.tencent.mobileqq.wink.j.I0, true);
        this.G = obtainStyledAttributes.getInt(com.tencent.mobileqq.wink.j.G0, 0);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(obtainStyledAttributes.getColor(com.tencent.mobileqq.wink.j.M0, color));
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setColor(obtainStyledAttributes.getColor(com.tencent.mobileqq.wink.j.O0, color3));
        paint2.setStrokeWidth(obtainStyledAttributes.getDimension(com.tencent.mobileqq.wink.j.P0, dimension));
        paint3.setStyle(Paint.Style.FILL);
        paint3.setColor(obtainStyledAttributes.getColor(com.tencent.mobileqq.wink.j.L0, color2));
        this.f326886d = obtainStyledAttributes.getDimension(com.tencent.mobileqq.wink.j.K0, dimension2);
        this.I = obtainStyledAttributes.getBoolean(com.tencent.mobileqq.wink.j.N0, false);
        this.J = obtainStyledAttributes.getDimension(com.tencent.mobileqq.wink.j.J0, dimension3);
        Drawable drawable = obtainStyledAttributes.getDrawable(com.tencent.mobileqq.wink.j.H0);
        if (drawable != null) {
            setBackgroundDrawable(drawable);
        }
        obtainStyledAttributes.recycle();
        ViewConfiguration.get(context);
    }

    public void setViewPager(ViewPager viewPager, int i3) {
        setViewPager(viewPager);
        setCurrentItem(i3);
    }
}
