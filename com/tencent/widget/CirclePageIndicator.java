package com.tencent.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.viewpager.widget.ViewPager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* loaded from: classes27.dex */
public class CirclePageIndicator extends View implements ViewPager.OnPageChangeListener {
    static IPatchRedirector $redirector_;
    private int C;
    private int D;
    private float E;
    private int F;
    private int G;
    private boolean H;
    private boolean I;
    private int J;
    private int K;
    private float L;
    private int M;
    private boolean N;

    /* renamed from: d, reason: collision with root package name */
    private float f384535d;

    /* renamed from: e, reason: collision with root package name */
    private final Paint f384536e;

    /* renamed from: f, reason: collision with root package name */
    private final Paint f384537f;

    /* renamed from: h, reason: collision with root package name */
    private final Paint f384538h;

    /* renamed from: i, reason: collision with root package name */
    private ViewPager f384539i;

    /* renamed from: m, reason: collision with root package name */
    private ViewPager.OnPageChangeListener f384540m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes27.dex */
    public static class SavedState extends View.BaseSavedState {
        static IPatchRedirector $redirector_;
        public static final Parcelable.Creator<SavedState> CREATOR;

        /* renamed from: d, reason: collision with root package name */
        int f384541d;

        /* loaded from: classes27.dex */
        class a implements Parcelable.Creator<SavedState> {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (SavedState) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
                }
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return (SavedState[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
                }
                return new SavedState[i3];
            }
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(77635);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 4)) {
                redirector.redirect((short) 4);
            } else {
                CREATOR = new a();
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) parcel, i3);
            } else {
                super.writeToParcel(parcel, i3);
                parcel.writeInt(this.f384541d);
            }
        }

        SavedState(Parcel parcel) {
            super(parcel);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                this.f384541d = parcel.readInt();
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
        }
    }

    public CirclePageIndicator(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private int a(int i3) {
        ViewPager viewPager;
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        if (mode != 1073741824 && (viewPager = this.f384539i) != null) {
            int f373114d = viewPager.getAdapter().getF373114d();
            float paddingLeft = getPaddingLeft() + getPaddingRight();
            float f16 = this.f384535d;
            int i16 = (int) (paddingLeft + (f373114d * 2 * f16) + ((f373114d - 1) * f16) + 1.0f);
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
            int paddingTop = (int) ((this.f384535d * 2.0f) + getPaddingTop() + getPaddingBottom() + 1.0f);
            if (mode == Integer.MIN_VALUE) {
                return Math.min(paddingTop, size);
            }
            return paddingTop;
        }
        return size;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int f373114d;
        int height;
        int paddingTop;
        int paddingBottom;
        int paddingLeft;
        int i3;
        float f16;
        float f17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) canvas);
            return;
        }
        super.onDraw(canvas);
        ViewPager viewPager = this.f384539i;
        if (viewPager == null || (f373114d = viewPager.getAdapter().getF373114d()) == 0) {
            return;
        }
        if (this.C >= f373114d) {
            setCurrentItem(f373114d - 1);
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
        float f18 = this.f384535d;
        float f19 = f18 * 2.0f;
        int i16 = this.J;
        float f26 = f19 + (i16 == 0 ? f18 : i16);
        float f27 = paddingLeft + f18;
        float f28 = paddingTop + f18;
        if (this.H) {
            f28 += (((height - paddingTop) - paddingBottom) / 2.0f) - ((f373114d * f26) / 2.0f);
        }
        if (this.f384537f.getStrokeWidth() > 0.0f) {
            f18 -= this.f384537f.getStrokeWidth() / 2.0f;
        }
        for (int i17 = 0; i17 < f373114d; i17++) {
            float f29 = (i17 * f26) + f28;
            if (this.G == 0) {
                f17 = f27;
            } else {
                f17 = f29;
                f29 = f27;
            }
            if (this.f384536e.getAlpha() > 0) {
                canvas.drawCircle(f29, f17, f18, this.f384536e);
            }
            float f36 = this.f384535d;
            if (f18 != f36) {
                canvas.drawCircle(f29, f17, f36, this.f384537f);
            }
        }
        boolean z16 = this.I;
        if (z16) {
            i3 = this.D;
        } else {
            i3 = this.C;
        }
        float f37 = i3 * f26;
        if (!z16) {
            f37 += this.E * f26;
        }
        if (this.G == 0) {
            float f38 = f28 + f37;
            f16 = f27;
            f27 = f38;
        } else {
            f16 = f28 + f37;
        }
        canvas.drawCircle(f27, f16, this.f384535d, this.f384538h);
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else if (this.G == 0) {
            setMeasuredDimension(a(i3), b(i16));
        } else {
            setMeasuredDimension(b(i3), a(i16));
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, i3);
            return;
        }
        this.F = i3;
        ViewPager.OnPageChangeListener onPageChangeListener = this.f384540m;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrollStateChanged(i3);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i3, float f16, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, this, Integer.valueOf(i3), Float.valueOf(f16), Integer.valueOf(i16));
            return;
        }
        this.C = i3;
        this.E = f16;
        invalidate();
        ViewPager.OnPageChangeListener onPageChangeListener = this.f384540m;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrolled(i3, f16, i16);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, i3);
            return;
        }
        if (this.I || this.F == 0) {
            this.C = i3;
            this.D = i3;
            invalidate();
        }
        ViewPager.OnPageChangeListener onPageChangeListener = this.f384540m;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageSelected(i3);
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, (Object) parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        int i3 = savedState.f384541d;
        this.C = i3;
        this.D = i3;
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return (Parcelable) iPatchRedirector.redirect((short) 34, (Object) this);
        }
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f384541d = this.C;
        return savedState;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (super.onTouchEvent(motionEvent)) {
            return true;
        }
        ViewPager viewPager = this.f384539i;
        int i3 = 0;
        if (viewPager == null || viewPager.getAdapter().getF373114d() == 0) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        if (action != 5) {
                            if (action == 6) {
                                int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                                if (MotionEventCompat.getPointerId(motionEvent, actionIndex) == this.M) {
                                    if (actionIndex == 0) {
                                        i3 = 1;
                                    }
                                    this.M = MotionEventCompat.getPointerId(motionEvent, i3);
                                }
                                this.L = MotionEventCompat.getX(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.M));
                            }
                        } else {
                            int actionIndex2 = MotionEventCompat.getActionIndex(motionEvent);
                            this.L = MotionEventCompat.getX(motionEvent, actionIndex2);
                            this.M = MotionEventCompat.getPointerId(motionEvent, actionIndex2);
                        }
                    }
                } else {
                    float x16 = MotionEventCompat.getX(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.M));
                    float f16 = x16 - this.L;
                    if (!this.N && Math.abs(f16) > this.K) {
                        this.N = true;
                    }
                    if (this.N) {
                        this.L = x16;
                        if (this.f384539i.isFakeDragging() || this.f384539i.beginFakeDrag()) {
                            this.f384539i.fakeDragBy(f16);
                        }
                    }
                }
            }
            if (!this.N) {
                int f373114d = this.f384539i.getAdapter().getF373114d();
                float width = getWidth();
                float f17 = width / 2.0f;
                float f18 = width / 6.0f;
                if (this.C > 0 && motionEvent.getX() < f17 - f18) {
                    if (action != 3) {
                        this.f384539i.setCurrentItem(this.C - 1);
                    }
                    return true;
                }
                if (this.C < f373114d - 1 && motionEvent.getX() > f17 + f18) {
                    if (action != 3) {
                        this.f384539i.setCurrentItem(this.C + 1);
                    }
                    return true;
                }
            }
            this.N = false;
            this.M = -1;
            if (this.f384539i.isFakeDragging()) {
                this.f384539i.endFakeDrag();
            }
        } else {
            this.M = MotionEventCompat.getPointerId(motionEvent, 0);
            this.L = motionEvent.getX();
        }
        return true;
    }

    public void setCentered(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        } else {
            this.H = z16;
            invalidate();
        }
    }

    public void setCirclePadding(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        } else {
            this.J = i3;
        }
    }

    public void setCurrentItem(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, i3);
            return;
        }
        ViewPager viewPager = this.f384539i;
        if (viewPager != null) {
            viewPager.setCurrentItem(i3);
            this.C = i3;
            invalidate();
            return;
        }
        throw new IllegalStateException("ViewPager has not been bound.");
    }

    public void setFillColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
        } else {
            this.f384538h.setColor(i3);
            invalidate();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, (Object) onPageChangeListener);
        } else {
            this.f384540m = onPageChangeListener;
        }
    }

    public void setOrientation(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3);
        } else {
            if (i3 != 0 && i3 != 1) {
                throw new IllegalArgumentException("Orientation must be either HORIZONTAL or VERTICAL.");
            }
            this.G = i3;
            requestLayout();
        }
    }

    public void setPageColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
        } else {
            this.f384536e.setColor(i3);
            invalidate();
        }
    }

    public void setRadius(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Float.valueOf(f16));
        } else {
            this.f384535d = f16;
            invalidate();
        }
    }

    public void setSnap(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, z16);
        } else {
            this.I = z16;
            invalidate();
        }
    }

    public void setStrokeColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, i3);
        } else {
            this.f384537f.setColor(i3);
            invalidate();
        }
    }

    public void setStrokeWidth(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Float.valueOf(f16));
        } else {
            this.f384537f.setStrokeWidth(f16);
            invalidate();
        }
    }

    public void setViewPager(ViewPager viewPager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) viewPager);
            return;
        }
        ViewPager viewPager2 = this.f384539i;
        if (viewPager2 == viewPager) {
            return;
        }
        if (viewPager2 != null) {
            viewPager2.setOnPageChangeListener(null);
        }
        if (viewPager.getAdapter() != null) {
            this.f384539i = viewPager;
            viewPager.setOnPageChangeListener(this);
            invalidate();
            return;
        }
        throw new IllegalStateException("ViewPager does not have adapter instance.");
    }

    public CirclePageIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.f155281b);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public CirclePageIndicator(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        Paint paint = new Paint(1);
        this.f384536e = paint;
        Paint paint2 = new Paint(1);
        this.f384537f = paint2;
        Paint paint3 = new Paint(1);
        this.f384538h = paint3;
        this.L = -1.0f;
        this.M = -1;
        if (isInEditMode()) {
            return;
        }
        Resources resources = getResources();
        int color = resources.getColor(R.color.f157021hs);
        int color2 = resources.getColor(R.color.skin_default_indicator);
        int color3 = resources.getColor(R.color.f157022ht);
        float dimension = resources.getDimension(R.dimen.f158651ll);
        float dimension2 = resources.getDimension(R.dimen.f158650lk);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CirclePageIndicator, i3, 0);
        this.H = obtainStyledAttributes.getBoolean(R.styleable.CirclePageIndicator_centered, true);
        this.G = obtainStyledAttributes.getInt(R.styleable.CirclePageIndicator_android_orientation, 0);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(obtainStyledAttributes.getColor(R.styleable.CirclePageIndicator_pageColor, color));
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setColor(obtainStyledAttributes.getColor(R.styleable.CirclePageIndicator_strokeColor, color3));
        paint2.setStrokeWidth(obtainStyledAttributes.getDimension(R.styleable.CirclePageIndicator_strokeWidth, dimension));
        paint3.setStyle(Paint.Style.FILL);
        paint3.setColor(obtainStyledAttributes.getColor(R.styleable.CirclePageIndicator_fillColor, color2));
        this.f384535d = obtainStyledAttributes.getDimension(R.styleable.CirclePageIndicator_circle_radius, dimension2);
        this.I = obtainStyledAttributes.getBoolean(R.styleable.CirclePageIndicator_snap, false);
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.CirclePageIndicator_android_background);
        if (drawable != null) {
            setBackgroundDrawable(drawable);
        }
        obtainStyledAttributes.recycle();
        this.K = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(context));
    }

    public void setViewPager(ViewPager viewPager, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) viewPager, i3);
        } else {
            setViewPager(viewPager);
            setCurrentItem(i3);
        }
    }
}
