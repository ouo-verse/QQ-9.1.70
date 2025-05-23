package com.tencent.now.app.common.widget;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Locale;

/* loaded from: classes22.dex */
public class NewPagerSlidingTabStrip extends HorizontalScrollView {

    /* renamed from: m0, reason: collision with root package name */
    private static final int[] f337903m0 = {R.attr.textSize, R.attr.textColor};
    private BadgeView C;
    protected int D;
    protected int E;
    protected float F;
    protected Paint G;
    private Paint H;
    protected int I;
    private int J;
    private int K;
    private boolean L;
    private boolean M;
    protected int N;
    protected int P;
    private int Q;
    private int R;
    private int S;
    private int T;
    private int U;
    protected int V;
    private int W;

    /* renamed from: a0, reason: collision with root package name */
    private int f337904a0;

    /* renamed from: b0, reason: collision with root package name */
    private int f337905b0;

    /* renamed from: c0, reason: collision with root package name */
    private Typeface f337906c0;

    /* renamed from: d, reason: collision with root package name */
    private LinearLayout.LayoutParams f337907d;

    /* renamed from: d0, reason: collision with root package name */
    private int f337908d0;

    /* renamed from: e, reason: collision with root package name */
    private LinearLayout.LayoutParams f337909e;

    /* renamed from: e0, reason: collision with root package name */
    private int f337910e0;

    /* renamed from: f, reason: collision with root package name */
    private final f f337911f;

    /* renamed from: f0, reason: collision with root package name */
    private Typeface f337912f0;

    /* renamed from: g0, reason: collision with root package name */
    private int f337913g0;

    /* renamed from: h, reason: collision with root package name */
    public ViewPager.OnPageChangeListener f337914h;

    /* renamed from: h0, reason: collision with root package name */
    protected int f337915h0;

    /* renamed from: i, reason: collision with root package name */
    protected LinearLayout f337916i;

    /* renamed from: i0, reason: collision with root package name */
    private int f337917i0;

    /* renamed from: j0, reason: collision with root package name */
    private Locale f337918j0;

    /* renamed from: k0, reason: collision with root package name */
    private int f337919k0;

    /* renamed from: l0, reason: collision with root package name */
    protected int f337920l0;

    /* renamed from: m, reason: collision with root package name */
    protected ViewPager f337921m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes22.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: d, reason: collision with root package name */
        int f337922d;

        /* loaded from: classes22.dex */
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
            parcel.writeInt(this.f337922d);
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.f337922d = parcel.readInt();
        }
    }

    /* loaded from: classes22.dex */
    class a implements g {
        a() {
        }

        @Override // com.tencent.now.app.common.widget.NewPagerSlidingTabStrip.g
        public void a(int i3) {
            int i16 = 0;
            while (true) {
                NewPagerSlidingTabStrip newPagerSlidingTabStrip = NewPagerSlidingTabStrip.this;
                if (i16 < newPagerSlidingTabStrip.D) {
                    View childAt = newPagerSlidingTabStrip.f337916i.getChildAt(i16);
                    if (childAt instanceof FrameLayout) {
                        childAt = ((FrameLayout) childAt).getChildAt(0);
                    }
                    if (childAt instanceof TextView) {
                        TextView textView = (TextView) childAt;
                        if (i16 == i3) {
                            textView.setTextColor(NewPagerSlidingTabStrip.this.f337905b0);
                            textView.setTypeface(NewPagerSlidingTabStrip.this.f337912f0, NewPagerSlidingTabStrip.this.f337913g0);
                        } else {
                            textView.setTextColor(NewPagerSlidingTabStrip.this.f337910e0);
                            textView.setTypeface(NewPagerSlidingTabStrip.this.f337906c0, NewPagerSlidingTabStrip.this.f337908d0);
                        }
                    }
                    i16++;
                } else {
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes22.dex */
    public class b implements ViewTreeObserver.OnGlobalLayoutListener {
        b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        @SuppressLint({"NewApi"})
        public void onGlobalLayout() {
            NewPagerSlidingTabStrip.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            NewPagerSlidingTabStrip newPagerSlidingTabStrip = NewPagerSlidingTabStrip.this;
            newPagerSlidingTabStrip.E = newPagerSlidingTabStrip.f337921m.getCurrentItem();
            NewPagerSlidingTabStrip newPagerSlidingTabStrip2 = NewPagerSlidingTabStrip.this;
            newPagerSlidingTabStrip2.m(newPagerSlidingTabStrip2.E, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes22.dex */
    public class c implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f337925d;

        c(int i3) {
            this.f337925d = i3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            NewPagerSlidingTabStrip.this.getClass();
            NewPagerSlidingTabStrip.this.f337921m.setCurrentItem(this.f337925d);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes22.dex */
    public interface d {
    }

    /* loaded from: classes22.dex */
    public interface e {
        int a(int i3);
    }

    /* loaded from: classes22.dex */
    private class f implements ViewPager.OnPageChangeListener {

        /* renamed from: d, reason: collision with root package name */
        private g f337927d;

        f() {
        }

        public void a(g gVar) {
            this.f337927d = gVar;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i3) {
            if (i3 == 0) {
                NewPagerSlidingTabStrip newPagerSlidingTabStrip = NewPagerSlidingTabStrip.this;
                newPagerSlidingTabStrip.m(newPagerSlidingTabStrip.f337921m.getCurrentItem(), 0);
            }
            ViewPager.OnPageChangeListener onPageChangeListener = NewPagerSlidingTabStrip.this.f337914h;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageScrollStateChanged(i3);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i3, float f16, int i16) {
            NewPagerSlidingTabStrip newPagerSlidingTabStrip = NewPagerSlidingTabStrip.this;
            newPagerSlidingTabStrip.E = i3;
            newPagerSlidingTabStrip.F = f16;
            if (newPagerSlidingTabStrip.f337916i.getChildAt(i3) == null) {
                return;
            }
            NewPagerSlidingTabStrip.this.m(i3, (int) (r0.getWidth() * f16));
            NewPagerSlidingTabStrip.this.invalidate();
            ViewPager.OnPageChangeListener onPageChangeListener = NewPagerSlidingTabStrip.this.f337914h;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageScrolled(i3, f16, i16);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i3) {
            NewPagerSlidingTabStrip.this.n();
            g gVar = this.f337927d;
            if (gVar != null) {
                gVar.a(i3);
            }
            ViewPager.OnPageChangeListener onPageChangeListener = NewPagerSlidingTabStrip.this.f337914h;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageSelected(i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
    public interface g {
        void a(int i3);
    }

    public NewPagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    private void h(int i3, int i16) {
        ImageButton imageButton = new ImageButton(getContext());
        imageButton.setImageResource(i16);
        i(i3, imageButton);
    }

    private void j(int i3, String str) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setGravity(17);
        textView.setSingleLine();
        i(i3, textView);
    }

    private void k(int i3) {
        for (int i16 = 0; i16 < this.D; i16++) {
            View childAt = this.f337916i.getChildAt(i16);
            if (childAt instanceof FrameLayout) {
                childAt = ((FrameLayout) childAt).getChildAt(0);
            }
            if (childAt instanceof TextView) {
                if (i16 == i3) {
                    ((TextView) childAt).setTextColor(this.f337905b0);
                } else {
                    ((TextView) childAt).setTextColor(this.f337910e0);
                }
            }
        }
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        for (int i3 = 0; i3 < this.D; i3++) {
            View childAt = this.f337916i.getChildAt(i3);
            childAt.setBackgroundResource(this.f337917i0);
            if (childAt instanceof FrameLayout) {
                childAt = ((FrameLayout) childAt).getChildAt(0);
            }
            if (childAt instanceof TextView) {
                TextView textView = (TextView) childAt;
                if (this.f337921m.getCurrentItem() == i3) {
                    int i16 = this.f337904a0;
                    if (i16 == 12) {
                        i16 = this.W;
                    }
                    textView.setTextSize(0, i16);
                    textView.setTypeface(this.f337912f0, this.f337913g0);
                    textView.setTextColor(this.f337905b0);
                } else {
                    textView.setTextSize(0, this.W);
                    textView.setTypeface(this.f337906c0, this.f337908d0);
                    textView.setTextColor(this.f337910e0);
                }
                if (this.M) {
                    textView.setAllCaps(true);
                }
            }
        }
    }

    protected void i(int i3, View view) {
        LinearLayout.LayoutParams layoutParams;
        view.setFocusable(true);
        view.setOnClickListener(new c(i3));
        int i16 = this.S;
        view.setPadding(i16, 0, i16, 0);
        LinearLayout linearLayout = this.f337916i;
        if (this.L) {
            layoutParams = this.f337909e;
        } else {
            layoutParams = this.f337907d;
        }
        linearLayout.addView(view, i3, layoutParams);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void l() {
        PagerAdapter adapter;
        this.f337916i.removeAllViews();
        ViewPager viewPager = this.f337921m;
        if (viewPager == null || (adapter = viewPager.getAdapter()) == 0) {
            return;
        }
        int f373114d = adapter.getF373114d();
        this.D = f373114d;
        if (f373114d == 0) {
            return;
        }
        for (int i3 = 0; i3 < this.D; i3++) {
            if (adapter instanceof e) {
                h(i3, ((e) adapter).a(i3));
            } else {
                CharSequence pageTitle = adapter.getPageTitle(i3);
                if (pageTitle != null) {
                    j(i3, pageTitle.toString());
                }
            }
        }
        n();
        k(this.f337921m.getCurrentItem());
        getViewTreeObserver().addOnGlobalLayoutListener(new b());
    }

    protected void m(int i3, int i16) {
        if (this.D == 0) {
            return;
        }
        int left = this.f337916i.getChildAt(i3).getLeft() + i16;
        if (i3 > 0 || i16 > 0) {
            left -= this.N;
        }
        if (left != this.f337915h0) {
            this.f337915h0 = left;
            scrollTo(left, 0);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i3;
        super.onDraw(canvas);
        if (!isInEditMode() && this.D != 0) {
            int height = getHeight();
            this.G.setColor(this.I);
            View childAt = this.f337916i.getChildAt(this.E);
            float left = childAt.getLeft();
            float right = childAt.getRight();
            float f16 = ((right - left) - this.V) / 2.0f;
            float f17 = left + f16;
            float f18 = right - f16;
            if (this.F >= 0.0f && (i3 = this.E) < this.D - 1) {
                float left2 = this.f337916i.getChildAt(i3 + 1).getLeft();
                int i16 = this.V;
                float f19 = this.F;
                if ((i16 * 2 * f19) + f17 < f18) {
                    f18 += ((left2 + f16) - f18) * 2.0f * f19;
                } else {
                    float f26 = left2 + f16;
                    f17 += (f26 - f17) * (f19 - 0.5f) * 2.0f;
                    f18 = (i16 * (f19 - 0.5f) * 2.0f) + f26;
                }
            }
            float f27 = f18;
            float f28 = f17;
            int i17 = height - this.P;
            int i18 = this.f337920l0;
            canvas.drawRect(f28, i17 - i18, f27, height - i18, this.G);
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.E = savedState.f337922d;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f337922d = this.E;
        return savedState;
    }

    public void setAllCaps(boolean z16) {
        this.M = z16;
    }

    public void setDividerColor(int i3) {
        this.K = i3;
        invalidate();
    }

    public void setDividerColorResource(int i3) {
        this.K = getResources().getColor(i3);
        invalidate();
    }

    public void setDividerPadding(int i3) {
        this.R = i3;
        invalidate();
    }

    public void setIndicatorColor(int i3) {
        this.I = i3;
        invalidate();
    }

    public void setIndicatorColorResource(int i3) {
        this.I = getResources().getColor(i3);
        invalidate();
    }

    public void setIndicatorHeight(int i3) {
        this.P = i3;
        invalidate();
    }

    public void setIndicatorWidth(int i3) {
        this.V = i3;
        invalidate();
    }

    public void setIndictorBottomMargin(int i3) {
        this.f337920l0 = i3;
    }

    public void setIndictorTopMargin(int i3) {
        this.f337919k0 = i3;
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.f337914h = onPageChangeListener;
    }

    public void setScrollOffset(int i3) {
        this.N = i3;
        invalidate();
    }

    public void setSelectedTextSize(int i3) {
        this.f337904a0 = i3;
        n();
    }

    public void setSelectedTypeface(Typeface typeface, int i3) {
        this.f337912f0 = typeface;
        this.f337913g0 = i3;
        n();
    }

    public void setShouldExpand(boolean z16) {
        this.L = z16;
        requestLayout();
    }

    public void setTabBackground(int i3) {
        this.f337917i0 = i3;
    }

    public void setTabPaddingLeftRight(int i3) {
        this.S = i3;
        n();
    }

    public void setTextColor(int i3) {
        this.f337905b0 = i3;
        n();
    }

    public void setTextColorResource(int i3) {
        this.f337905b0 = getResources().getColor(i3);
        n();
    }

    public void setTextSize(int i3) {
        this.W = i3;
        n();
    }

    public void setTypeface(Typeface typeface, int i3) {
        this.f337906c0 = typeface;
        this.f337908d0 = i3;
        n();
    }

    public void setUnSelectedTextColor(int i3) {
        this.f337910e0 = i3;
    }

    public void setUnderlineColor(int i3) {
        this.J = i3;
        invalidate();
    }

    public void setUnderlineColorResource(int i3) {
        this.J = getResources().getColor(i3);
        invalidate();
    }

    public void setUnderlineHeight(int i3) {
        this.Q = i3;
        invalidate();
    }

    public void setViewPager(ViewPager viewPager) {
        this.f337921m = viewPager;
        this.C = null;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.f337911f);
            l();
            return;
        }
        throw new IllegalStateException("ViewPager does not have adapter instance.");
    }

    public NewPagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NewPagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        f fVar = new f();
        this.f337911f = fVar;
        this.E = 0;
        this.F = 0.0f;
        this.I = -10066330;
        this.J = 436207616;
        this.K = 436207616;
        this.L = false;
        this.M = true;
        this.N = 52;
        this.P = 8;
        this.Q = 2;
        this.R = 12;
        this.S = 14;
        this.T = 1;
        this.U = 0;
        this.V = com.tencent.misc.utils.a.b(getContext(), 20.0f);
        this.W = 12;
        this.f337904a0 = 12;
        this.f337905b0 = RichStatus.ACTION_COLOR_NORMAL;
        this.f337906c0 = null;
        this.f337908d0 = 1;
        this.f337910e0 = -7829368;
        this.f337912f0 = null;
        this.f337913g0 = 1;
        this.f337915h0 = 0;
        this.f337917i0 = com.tencent.mobileqq.R.drawable.jc_;
        this.f337919k0 = 0;
        this.f337920l0 = com.tencent.misc.utils.a.b(getContext(), 2.0f);
        setFillViewport(true);
        setWillNotDraw(false);
        LinearLayout linearLayout = new LinearLayout(context);
        this.f337916i = linearLayout;
        linearLayout.setId(com.tencent.mobileqq.R.id.f919556k);
        this.f337916i.setOrientation(0);
        this.f337916i.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.f337916i);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.N = (int) TypedValue.applyDimension(1, this.N, displayMetrics);
        this.P = (int) TypedValue.applyDimension(1, this.P, displayMetrics);
        this.Q = (int) TypedValue.applyDimension(1, this.Q, displayMetrics);
        this.R = (int) TypedValue.applyDimension(1, this.R, displayMetrics);
        this.S = (int) TypedValue.applyDimension(1, this.S, displayMetrics);
        this.T = (int) TypedValue.applyDimension(1, this.T, displayMetrics);
        this.W = (int) TypedValue.applyDimension(2, this.W, displayMetrics);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f337903m0);
        this.W = obtainStyledAttributes.getDimensionPixelSize(0, this.W);
        this.f337905b0 = obtainStyledAttributes.getColor(1, this.f337905b0);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, li2.a.H3);
        this.I = obtainStyledAttributes2.getColor(li2.a.K3, this.I);
        this.J = obtainStyledAttributes2.getColor(li2.a.S3, this.J);
        this.K = obtainStyledAttributes2.getColor(li2.a.I3, this.K);
        this.P = obtainStyledAttributes2.getDimensionPixelSize(li2.a.L3, this.P);
        this.Q = obtainStyledAttributes2.getDimensionPixelSize(li2.a.T3, this.Q);
        this.R = obtainStyledAttributes2.getDimensionPixelSize(li2.a.J3, this.R);
        this.S = obtainStyledAttributes2.getDimensionPixelSize(li2.a.Q3, this.S);
        this.f337917i0 = obtainStyledAttributes2.getResourceId(li2.a.P3, this.f337917i0);
        this.L = obtainStyledAttributes2.getBoolean(li2.a.O3, this.L);
        this.N = obtainStyledAttributes2.getDimensionPixelSize(li2.a.N3, this.N);
        this.M = obtainStyledAttributes2.getBoolean(li2.a.R3, this.M);
        this.V = obtainStyledAttributes2.getDimensionPixelSize(li2.a.M3, this.V);
        obtainStyledAttributes2.recycle();
        Paint paint = new Paint();
        this.G = paint;
        paint.setAntiAlias(true);
        this.G.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.H = paint2;
        paint2.setAntiAlias(true);
        this.H.setStrokeWidth(this.T);
        this.f337907d = new LinearLayout.LayoutParams(-2, -1);
        this.f337909e = new LinearLayout.LayoutParams(0, -1, 1.0f);
        if (this.f337918j0 == null) {
            this.f337918j0 = getResources().getConfiguration().locale;
        }
        fVar.a(new a());
    }

    public void setChildTabClickListener(d dVar) {
    }
}
