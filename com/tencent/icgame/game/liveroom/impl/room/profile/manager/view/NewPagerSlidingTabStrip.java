package com.tencent.icgame.game.liveroom.impl.room.profile.manager.view;

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
import qw0.m;

/* loaded from: classes7.dex */
public class NewPagerSlidingTabStrip extends HorizontalScrollView {

    /* renamed from: l0, reason: collision with root package name */
    private static final int[] f115546l0 = {R.attr.textSize, R.attr.textColor};
    protected int C;
    protected int D;
    protected float E;
    protected Paint F;
    private Paint G;
    protected int H;
    private int I;
    private int J;
    private boolean K;
    private boolean L;
    protected int M;
    protected int N;
    private int P;
    private int Q;
    private int R;
    private int S;
    private int T;
    protected int U;
    private int V;
    private int W;

    /* renamed from: a0, reason: collision with root package name */
    private int f115547a0;

    /* renamed from: b0, reason: collision with root package name */
    private Typeface f115548b0;

    /* renamed from: c0, reason: collision with root package name */
    private int f115549c0;

    /* renamed from: d, reason: collision with root package name */
    private LinearLayout.LayoutParams f115550d;

    /* renamed from: d0, reason: collision with root package name */
    private int f115551d0;

    /* renamed from: e, reason: collision with root package name */
    private LinearLayout.LayoutParams f115552e;

    /* renamed from: e0, reason: collision with root package name */
    private Typeface f115553e0;

    /* renamed from: f, reason: collision with root package name */
    private final f f115554f;

    /* renamed from: f0, reason: collision with root package name */
    private int f115555f0;

    /* renamed from: g0, reason: collision with root package name */
    protected int f115556g0;

    /* renamed from: h, reason: collision with root package name */
    public ViewPager.OnPageChangeListener f115557h;

    /* renamed from: h0, reason: collision with root package name */
    private int f115558h0;

    /* renamed from: i, reason: collision with root package name */
    protected LinearLayout f115559i;

    /* renamed from: i0, reason: collision with root package name */
    private Locale f115560i0;

    /* renamed from: j0, reason: collision with root package name */
    private int f115561j0;

    /* renamed from: k0, reason: collision with root package name */
    protected int f115562k0;

    /* renamed from: m, reason: collision with root package name */
    protected ViewPager f115563m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: d, reason: collision with root package name */
        int f115564d;

        /* loaded from: classes7.dex */
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
            parcel.writeInt(this.f115564d);
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.f115564d = parcel.readInt();
        }
    }

    /* loaded from: classes7.dex */
    class a implements g {
        a() {
        }

        @Override // com.tencent.icgame.game.liveroom.impl.room.profile.manager.view.NewPagerSlidingTabStrip.g
        public void a(int i3) {
            int i16 = 0;
            while (true) {
                NewPagerSlidingTabStrip newPagerSlidingTabStrip = NewPagerSlidingTabStrip.this;
                if (i16 < newPagerSlidingTabStrip.C) {
                    View childAt = newPagerSlidingTabStrip.f115559i.getChildAt(i16);
                    if (childAt instanceof FrameLayout) {
                        childAt = ((FrameLayout) childAt).getChildAt(0);
                    }
                    if (childAt instanceof TextView) {
                        TextView textView = (TextView) childAt;
                        if (i16 == i3) {
                            textView.setTextColor(NewPagerSlidingTabStrip.this.f115547a0);
                            textView.setTypeface(NewPagerSlidingTabStrip.this.f115553e0, NewPagerSlidingTabStrip.this.f115555f0);
                        } else {
                            textView.setTextColor(NewPagerSlidingTabStrip.this.f115551d0);
                            textView.setTypeface(NewPagerSlidingTabStrip.this.f115548b0, NewPagerSlidingTabStrip.this.f115549c0);
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
    /* loaded from: classes7.dex */
    public class b implements ViewTreeObserver.OnGlobalLayoutListener {
        b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        @SuppressLint({"NewApi"})
        public void onGlobalLayout() {
            NewPagerSlidingTabStrip.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            NewPagerSlidingTabStrip newPagerSlidingTabStrip = NewPagerSlidingTabStrip.this;
            newPagerSlidingTabStrip.D = newPagerSlidingTabStrip.f115563m.getCurrentItem();
            NewPagerSlidingTabStrip newPagerSlidingTabStrip2 = NewPagerSlidingTabStrip.this;
            newPagerSlidingTabStrip2.m(newPagerSlidingTabStrip2.D, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f115567d;

        c(int i3) {
            this.f115567d = i3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            NewPagerSlidingTabStrip.this.getClass();
            NewPagerSlidingTabStrip.this.f115563m.setCurrentItem(this.f115567d);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes7.dex */
    public interface d {
    }

    /* loaded from: classes7.dex */
    public interface e {
        int a(int i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class f implements ViewPager.OnPageChangeListener {

        /* renamed from: d, reason: collision with root package name */
        private g f115569d;

        f() {
        }

        public void a(g gVar) {
            this.f115569d = gVar;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i3) {
            if (i3 == 0) {
                NewPagerSlidingTabStrip newPagerSlidingTabStrip = NewPagerSlidingTabStrip.this;
                newPagerSlidingTabStrip.m(newPagerSlidingTabStrip.f115563m.getCurrentItem(), 0);
            }
            ViewPager.OnPageChangeListener onPageChangeListener = NewPagerSlidingTabStrip.this.f115557h;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageScrollStateChanged(i3);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i3, float f16, int i16) {
            NewPagerSlidingTabStrip newPagerSlidingTabStrip = NewPagerSlidingTabStrip.this;
            newPagerSlidingTabStrip.D = i3;
            newPagerSlidingTabStrip.E = f16;
            if (newPagerSlidingTabStrip.f115559i.getChildAt(i3) == null) {
                return;
            }
            NewPagerSlidingTabStrip.this.m(i3, (int) (r0.getWidth() * f16));
            NewPagerSlidingTabStrip.this.invalidate();
            ViewPager.OnPageChangeListener onPageChangeListener = NewPagerSlidingTabStrip.this.f115557h;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageScrolled(i3, f16, i16);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i3) {
            NewPagerSlidingTabStrip.this.n();
            g gVar = this.f115569d;
            if (gVar != null) {
                gVar.a(i3);
            }
            ViewPager.OnPageChangeListener onPageChangeListener = NewPagerSlidingTabStrip.this.f115557h;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageSelected(i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
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
        for (int i16 = 0; i16 < this.C; i16++) {
            View childAt = this.f115559i.getChildAt(i16);
            if (childAt instanceof FrameLayout) {
                childAt = ((FrameLayout) childAt).getChildAt(0);
            }
            if (childAt instanceof TextView) {
                if (i16 == i3) {
                    ((TextView) childAt).setTextColor(this.f115547a0);
                } else {
                    ((TextView) childAt).setTextColor(this.f115551d0);
                }
            }
        }
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        for (int i3 = 0; i3 < this.C; i3++) {
            View childAt = this.f115559i.getChildAt(i3);
            childAt.setBackgroundResource(this.f115558h0);
            if (childAt instanceof FrameLayout) {
                childAt = ((FrameLayout) childAt).getChildAt(0);
            }
            if (childAt instanceof TextView) {
                TextView textView = (TextView) childAt;
                if (this.f115563m.getCurrentItem() == i3) {
                    int i16 = this.W;
                    if (i16 == 12) {
                        i16 = this.V;
                    }
                    textView.setTextSize(0, i16);
                    textView.setTypeface(this.f115553e0, this.f115555f0);
                    textView.setTextColor(this.f115547a0);
                } else {
                    textView.setTextSize(0, this.V);
                    textView.setTypeface(this.f115548b0, this.f115549c0);
                    textView.setTextColor(this.f115551d0);
                }
                if (this.L) {
                    textView.setAllCaps(true);
                }
            }
        }
    }

    protected void i(int i3, View view) {
        LinearLayout.LayoutParams layoutParams;
        view.setFocusable(true);
        view.setOnClickListener(new c(i3));
        int i16 = this.R;
        view.setPadding(i16, 0, i16, 0);
        LinearLayout linearLayout = this.f115559i;
        if (this.K) {
            layoutParams = this.f115552e;
        } else {
            layoutParams = this.f115550d;
        }
        linearLayout.addView(view, i3, layoutParams);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void l() {
        PagerAdapter adapter;
        this.f115559i.removeAllViews();
        ViewPager viewPager = this.f115563m;
        if (viewPager == null || (adapter = viewPager.getAdapter()) == 0) {
            return;
        }
        int f373114d = adapter.getF373114d();
        this.C = f373114d;
        if (f373114d == 0) {
            return;
        }
        for (int i3 = 0; i3 < this.C; i3++) {
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
        k(this.f115563m.getCurrentItem());
        getViewTreeObserver().addOnGlobalLayoutListener(new b());
    }

    protected void m(int i3, int i16) {
        if (this.C == 0) {
            return;
        }
        int left = this.f115559i.getChildAt(i3).getLeft() + i16;
        if (i3 > 0 || i16 > 0) {
            left -= this.M;
        }
        if (left != this.f115556g0) {
            this.f115556g0 = left;
            scrollTo(left, 0);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i3;
        super.onDraw(canvas);
        if (!isInEditMode() && this.C != 0) {
            int height = getHeight();
            this.F.setColor(this.H);
            View childAt = this.f115559i.getChildAt(this.D);
            float left = childAt.getLeft();
            float right = childAt.getRight();
            float f16 = ((right - left) - this.U) / 2.0f;
            float f17 = left + f16;
            float f18 = right - f16;
            if (this.E >= 0.0f && (i3 = this.D) < this.C - 1) {
                float left2 = this.f115559i.getChildAt(i3 + 1).getLeft();
                int i16 = this.U;
                float f19 = this.E;
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
            int i17 = height - this.N;
            int i18 = this.f115562k0;
            canvas.drawRect(f28, i17 - i18, f27, height - i18, this.F);
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.D = savedState.f115564d;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f115564d = this.D;
        return savedState;
    }

    public void setAllCaps(boolean z16) {
        this.L = z16;
    }

    public void setDividerColor(int i3) {
        this.J = i3;
        invalidate();
    }

    public void setDividerColorResource(int i3) {
        this.J = getResources().getColor(i3);
        invalidate();
    }

    public void setDividerPadding(int i3) {
        this.Q = i3;
        invalidate();
    }

    public void setIndicatorColor(int i3) {
        this.H = i3;
        invalidate();
    }

    public void setIndicatorColorResource(int i3) {
        this.H = getResources().getColor(i3);
        invalidate();
    }

    public void setIndicatorHeight(int i3) {
        this.N = i3;
        invalidate();
    }

    public void setIndicatorWidth(int i3) {
        this.U = i3;
        invalidate();
    }

    public void setIndictorBottomMargin(int i3) {
        this.f115562k0 = i3;
    }

    public void setIndictorTopMargin(int i3) {
        this.f115561j0 = i3;
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.f115557h = onPageChangeListener;
    }

    public void setScrollOffset(int i3) {
        this.M = i3;
        invalidate();
    }

    public void setSelectedTextSize(int i3) {
        this.W = i3;
        n();
    }

    public void setSelectedTypeface(Typeface typeface, int i3) {
        this.f115553e0 = typeface;
        this.f115555f0 = i3;
        n();
    }

    public void setShouldExpand(boolean z16) {
        this.K = z16;
        requestLayout();
    }

    public void setTabBackground(int i3) {
        this.f115558h0 = i3;
    }

    public void setTabPaddingLeftRight(int i3) {
        this.R = i3;
        n();
    }

    public void setTextColor(int i3) {
        this.f115547a0 = i3;
        n();
    }

    public void setTextColorResource(int i3) {
        this.f115547a0 = getResources().getColor(i3);
        n();
    }

    public void setTextSize(int i3) {
        this.V = i3;
        n();
    }

    public void setTypeface(Typeface typeface, int i3) {
        this.f115548b0 = typeface;
        this.f115549c0 = i3;
        n();
    }

    public void setUnSelectedTextColor(int i3) {
        this.f115551d0 = i3;
    }

    public void setUnderlineColor(int i3) {
        this.I = i3;
        invalidate();
    }

    public void setUnderlineColorResource(int i3) {
        this.I = getResources().getColor(i3);
        invalidate();
    }

    public void setUnderlineHeight(int i3) {
        this.P = i3;
        invalidate();
    }

    public void setViewPager(ViewPager viewPager) {
        this.f115563m = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.f115554f);
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
        this.f115554f = fVar;
        this.D = 0;
        this.E = 0.0f;
        this.H = -10066330;
        this.I = 436207616;
        this.J = 436207616;
        this.K = false;
        this.L = true;
        this.M = 52;
        this.N = 8;
        this.P = 2;
        this.Q = 12;
        this.R = 14;
        this.S = 1;
        this.T = 0;
        this.U = m.b(getContext(), 20.0f);
        this.V = 12;
        this.W = 12;
        this.f115547a0 = RichStatus.ACTION_COLOR_NORMAL;
        this.f115548b0 = null;
        this.f115549c0 = 1;
        this.f115551d0 = -7829368;
        this.f115553e0 = null;
        this.f115555f0 = 1;
        this.f115556g0 = 0;
        this.f115558h0 = com.tencent.mobileqq.R.drawable.jc_;
        this.f115561j0 = 0;
        this.f115562k0 = m.b(getContext(), 2.0f);
        setFillViewport(true);
        setWillNotDraw(false);
        LinearLayout linearLayout = new LinearLayout(context);
        this.f115559i = linearLayout;
        linearLayout.setId(com.tencent.mobileqq.R.id.f919556k);
        this.f115559i.setOrientation(0);
        this.f115559i.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.f115559i);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.M = (int) TypedValue.applyDimension(1, this.M, displayMetrics);
        this.N = (int) TypedValue.applyDimension(1, this.N, displayMetrics);
        this.P = (int) TypedValue.applyDimension(1, this.P, displayMetrics);
        this.Q = (int) TypedValue.applyDimension(1, this.Q, displayMetrics);
        this.R = (int) TypedValue.applyDimension(1, this.R, displayMetrics);
        this.S = (int) TypedValue.applyDimension(1, this.S, displayMetrics);
        this.V = (int) TypedValue.applyDimension(2, this.V, displayMetrics);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f115546l0);
        this.V = obtainStyledAttributes.getDimensionPixelSize(0, this.V);
        this.f115547a0 = obtainStyledAttributes.getColor(1, this.f115547a0);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, d52.a.C3);
        this.H = obtainStyledAttributes2.getColor(d52.a.F3, this.H);
        this.I = obtainStyledAttributes2.getColor(d52.a.N3, this.I);
        this.J = obtainStyledAttributes2.getColor(d52.a.D3, this.J);
        this.N = obtainStyledAttributes2.getDimensionPixelSize(d52.a.G3, this.N);
        this.P = obtainStyledAttributes2.getDimensionPixelSize(d52.a.O3, this.P);
        this.Q = obtainStyledAttributes2.getDimensionPixelSize(d52.a.E3, this.Q);
        this.R = obtainStyledAttributes2.getDimensionPixelSize(d52.a.L3, this.R);
        this.f115558h0 = obtainStyledAttributes2.getResourceId(d52.a.K3, this.f115558h0);
        this.K = obtainStyledAttributes2.getBoolean(d52.a.J3, this.K);
        this.M = obtainStyledAttributes2.getDimensionPixelSize(d52.a.I3, this.M);
        this.L = obtainStyledAttributes2.getBoolean(d52.a.M3, this.L);
        this.U = obtainStyledAttributes2.getDimensionPixelSize(d52.a.H3, this.U);
        obtainStyledAttributes2.recycle();
        Paint paint = new Paint();
        this.F = paint;
        paint.setAntiAlias(true);
        this.F.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.G = paint2;
        paint2.setAntiAlias(true);
        this.G.setStrokeWidth(this.S);
        this.f115550d = new LinearLayout.LayoutParams(-2, -1);
        this.f115552e = new LinearLayout.LayoutParams(0, -1, 1.0f);
        if (this.f115560i0 == null) {
            this.f115560i0 = getResources().getConfiguration().locale;
        }
        fVar.a(new a());
    }

    public void setChildTabClickListener(d dVar) {
    }
}
