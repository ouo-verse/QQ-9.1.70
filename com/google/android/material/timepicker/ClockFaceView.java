package com.google.android.material.timepicker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.timepicker.ClockHandView;
import com.tencent.mobileqq.R;
import g1.c;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes2.dex */
class ClockFaceView extends RadialViewGroup implements ClockHandView.c {
    private final SparseArray<TextView> C;
    private final AccessibilityDelegateCompat D;
    private final int[] E;
    private final float[] F;
    private final int G;
    private final int H;
    private final int I;
    private final int J;
    private String[] K;
    private float L;
    private final ColorStateList M;

    /* renamed from: h, reason: collision with root package name */
    private final ClockHandView f34460h;

    /* renamed from: i, reason: collision with root package name */
    private final Rect f34461i;

    /* renamed from: m, reason: collision with root package name */
    private final RectF f34462m;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class a implements ViewTreeObserver.OnPreDrawListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            if (!ClockFaceView.this.isShown()) {
                return true;
            }
            ClockFaceView.this.getViewTreeObserver().removeOnPreDrawListener(this);
            ClockFaceView.this.B0(((ClockFaceView.this.getHeight() / 2) - ClockFaceView.this.f34460h.g()) - ClockFaceView.this.G);
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class b extends AccessibilityDelegateCompat {
        b() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            int intValue = ((Integer) view.getTag(R.id.yys)).intValue();
            if (intValue > 0) {
                accessibilityNodeInfoCompat.setTraversalAfter((View) ClockFaceView.this.C.get(intValue - 1));
            }
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(0, 1, intValue, 1, false, view.isSelected()));
            accessibilityNodeInfoCompat.setClickable(true);
            accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean performAccessibilityAction(View view, int i3, Bundle bundle) {
            if (i3 == 16) {
                long uptimeMillis = SystemClock.uptimeMillis();
                float x16 = view.getX() + (view.getWidth() / 2.0f);
                float height = (view.getHeight() / 2.0f) + view.getY();
                ClockFaceView.this.f34460h.onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, x16, height, 0));
                ClockFaceView.this.f34460h.onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 1, x16, height, 0));
                return true;
            }
            return super.performAccessibilityAction(view, i3, bundle);
        }
    }

    public ClockFaceView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.av5);
    }

    private void I0() {
        RectF d16 = this.f34460h.d();
        for (int i3 = 0; i3 < this.C.size(); i3++) {
            TextView textView = this.C.get(i3);
            if (textView != null) {
                textView.getDrawingRect(this.f34461i);
                offsetDescendantRectToMyCoords(textView, this.f34461i);
                textView.setSelected(d16.contains(this.f34461i.centerX(), this.f34461i.centerY()));
                textView.getPaint().setShader(J0(d16, this.f34461i, textView));
                textView.invalidate();
            }
        }
    }

    @Nullable
    private RadialGradient J0(RectF rectF, Rect rect, TextView textView) {
        this.f34462m.set(rect);
        this.f34462m.offset(textView.getPaddingLeft(), textView.getPaddingTop());
        if (!RectF.intersects(rectF, this.f34462m)) {
            return null;
        }
        return new RadialGradient(rectF.centerX() - this.f34462m.left, rectF.centerY() - this.f34462m.top, rectF.width() * 0.5f, this.E, this.F, Shader.TileMode.CLAMP);
    }

    private static float K0(float f16, float f17, float f18) {
        return Math.max(Math.max(f16, f17), f18);
    }

    private void M0(@StringRes int i3) {
        LayoutInflater from = LayoutInflater.from(getContext());
        int size = this.C.size();
        for (int i16 = 0; i16 < Math.max(this.K.length, size); i16++) {
            TextView textView = this.C.get(i16);
            if (i16 >= this.K.length) {
                removeView(textView);
                this.C.remove(i16);
            } else {
                if (textView == null) {
                    textView = (TextView) from.inflate(R.layout.fgz, (ViewGroup) this, false);
                    this.C.put(i16, textView);
                    addView(textView);
                }
                textView.setVisibility(0);
                textView.setText(this.K[i16]);
                textView.setTag(R.id.yys, Integer.valueOf(i16));
                ViewCompat.setAccessibilityDelegate(textView, this.D);
                textView.setTextColor(this.M);
                if (i3 != 0) {
                    textView.setContentDescription(getResources().getString(i3, this.K[i16]));
                }
            }
        }
    }

    @Override // com.google.android.material.timepicker.RadialViewGroup
    public void B0(int i3) {
        if (i3 != A0()) {
            super.B0(i3);
            this.f34460h.j(A0());
        }
    }

    public void L0(String[] strArr, @StringRes int i3) {
        this.K = strArr;
        M0(i3);
    }

    @Override // com.google.android.material.timepicker.ClockHandView.c
    public void j0(float f16, boolean z16) {
        if (Math.abs(this.L - f16) > 0.001f) {
            this.L = f16;
            I0();
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, this.K.length, false, 1));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        I0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public void onMeasure(int i3, int i16) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int K0 = (int) (this.J / K0(this.H / displayMetrics.heightPixels, this.I / displayMetrics.widthPixels, 1.0f));
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(K0, 1073741824);
        setMeasuredDimension(K0, K0);
        super.onMeasure(makeMeasureSpec, makeMeasureSpec);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public ClockFaceView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f34461i = new Rect();
        this.f34462m = new RectF();
        this.C = new SparseArray<>();
        this.F = new float[]{0.0f, 0.9f, 1.0f};
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, w0.a.P1, i3, R.style.asx);
        Resources resources = getResources();
        ColorStateList a16 = c.a(context, obtainStyledAttributes, w0.a.R1);
        this.M = a16;
        LayoutInflater.from(context).inflate(R.layout.f168259fh0, (ViewGroup) this, true);
        ClockHandView clockHandView = (ClockHandView) findViewById(R.id.yya);
        this.f34460h = clockHandView;
        this.G = resources.getDimensionPixelSize(R.dimen.cot);
        int colorForState = a16.getColorForState(new int[]{android.R.attr.state_selected}, a16.getDefaultColor());
        this.E = new int[]{colorForState, colorForState, a16.getDefaultColor()};
        clockHandView.b(this);
        int defaultColor = AppCompatResources.getColorStateList(context, R.color.c4q).getDefaultColor();
        ColorStateList a17 = c.a(context, obtainStyledAttributes, w0.a.Q1);
        setBackgroundColor(a17 != null ? a17.getDefaultColor() : defaultColor);
        getViewTreeObserver().addOnPreDrawListener(new a());
        setFocusable(true);
        obtainStyledAttributes.recycle();
        this.D = new b();
        String[] strArr = new String[12];
        Arrays.fill(strArr, "");
        L0(strArr, 0);
        this.H = resources.getDimensionPixelSize(R.dimen.cpp);
        this.I = resources.getDimensionPixelSize(R.dimen.cpq);
        this.J = resources.getDimensionPixelSize(R.dimen.f159131cp0);
    }
}
