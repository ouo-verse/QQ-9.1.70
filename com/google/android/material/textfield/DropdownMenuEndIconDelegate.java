package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.n;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.textfield.TextInputLayout;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public class DropdownMenuEndIconDelegate extends com.google.android.material.textfield.d {

    /* renamed from: r, reason: collision with root package name */
    private static final boolean f34327r = true;

    /* renamed from: e, reason: collision with root package name */
    private final TextWatcher f34328e;

    /* renamed from: f, reason: collision with root package name */
    private final View.OnFocusChangeListener f34329f;

    /* renamed from: g, reason: collision with root package name */
    private final TextInputLayout.c f34330g;

    /* renamed from: h, reason: collision with root package name */
    private final TextInputLayout.d f34331h;

    /* renamed from: i, reason: collision with root package name */
    @SuppressLint({"ClickableViewAccessibility"})
    private final TextInputLayout.e f34332i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f34333j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f34334k;

    /* renamed from: l, reason: collision with root package name */
    private long f34335l;

    /* renamed from: m, reason: collision with root package name */
    private StateListDrawable f34336m;

    /* renamed from: n, reason: collision with root package name */
    private MaterialShapeDrawable f34337n;

    /* renamed from: o, reason: collision with root package name */
    @Nullable
    private AccessibilityManager f34338o;

    /* renamed from: p, reason: collision with root package name */
    private ValueAnimator f34339p;

    /* renamed from: q, reason: collision with root package name */
    private ValueAnimator f34340q;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate = DropdownMenuEndIconDelegate.this;
            dropdownMenuEndIconDelegate.f34419c.setChecked(dropdownMenuEndIconDelegate.f34334k);
            DropdownMenuEndIconDelegate.this.f34340q.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            DropdownMenuEndIconDelegate.this.f34419c.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class c implements View.OnFocusChangeListener {
        c() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z16) {
            DropdownMenuEndIconDelegate.this.f34417a.setEndIconActivated(z16);
            if (!z16) {
                DropdownMenuEndIconDelegate.this.E(false);
                DropdownMenuEndIconDelegate.this.f34333j = false;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class d extends TextInputLayout.c {
        d(TextInputLayout textInputLayout) {
            super(textInputLayout);
        }

        @Override // com.google.android.material.textfield.TextInputLayout.c, androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            if (!DropdownMenuEndIconDelegate.D(DropdownMenuEndIconDelegate.this.f34417a.L())) {
                accessibilityNodeInfoCompat.setClassName(Spinner.class.getName());
            }
            if (accessibilityNodeInfoCompat.isShowingHintText()) {
                accessibilityNodeInfoCompat.setHintText(null);
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onPopulateAccessibilityEvent(View view, @NonNull AccessibilityEvent accessibilityEvent) {
            super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            AutoCompleteTextView y16 = DropdownMenuEndIconDelegate.y(DropdownMenuEndIconDelegate.this.f34417a.L());
            if (accessibilityEvent.getEventType() == 1 && DropdownMenuEndIconDelegate.this.f34338o.isEnabled() && !DropdownMenuEndIconDelegate.D(DropdownMenuEndIconDelegate.this.f34417a.L())) {
                DropdownMenuEndIconDelegate.this.H(y16);
                DropdownMenuEndIconDelegate.this.I();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class e implements TextInputLayout.d {
        e() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.d
        public void a(@NonNull TextInputLayout textInputLayout) {
            AutoCompleteTextView y16 = DropdownMenuEndIconDelegate.y(textInputLayout.L());
            DropdownMenuEndIconDelegate.this.F(y16);
            DropdownMenuEndIconDelegate.this.v(y16);
            DropdownMenuEndIconDelegate.this.G(y16);
            y16.setThreshold(0);
            y16.removeTextChangedListener(DropdownMenuEndIconDelegate.this.f34328e);
            y16.addTextChangedListener(DropdownMenuEndIconDelegate.this.f34328e);
            textInputLayout.setEndIconCheckable(true);
            textInputLayout.setErrorIconDrawable((Drawable) null);
            if (!DropdownMenuEndIconDelegate.D(y16) && DropdownMenuEndIconDelegate.this.f34338o.isTouchExplorationEnabled()) {
                ViewCompat.setImportantForAccessibility(DropdownMenuEndIconDelegate.this.f34419c, 2);
            }
            textInputLayout.setTextInputAccessibilityDelegate(DropdownMenuEndIconDelegate.this.f34330g);
            textInputLayout.setEndIconVisible(true);
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            DropdownMenuEndIconDelegate.this.H((AutoCompleteTextView) DropdownMenuEndIconDelegate.this.f34417a.L());
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class g implements AccessibilityManager.TouchExplorationStateChangeListener {
        g() {
        }

        @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
        public void onTouchExplorationStateChanged(boolean z16) {
            int i3;
            if (DropdownMenuEndIconDelegate.this.f34417a.L() != null && !DropdownMenuEndIconDelegate.D(DropdownMenuEndIconDelegate.this.f34417a.L())) {
                CheckableImageButton checkableImageButton = DropdownMenuEndIconDelegate.this.f34419c;
                if (z16) {
                    i3 = 2;
                } else {
                    i3 = 1;
                }
                ViewCompat.setImportantForAccessibility(checkableImageButton, i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class h implements View.OnTouchListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AutoCompleteTextView f34354d;

        h(AutoCompleteTextView autoCompleteTextView) {
            this.f34354d = autoCompleteTextView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(@NonNull View view, @NonNull MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                if (DropdownMenuEndIconDelegate.this.C()) {
                    DropdownMenuEndIconDelegate.this.f34333j = false;
                }
                DropdownMenuEndIconDelegate.this.H(this.f34354d);
                DropdownMenuEndIconDelegate.this.I();
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class i implements AutoCompleteTextView.OnDismissListener {
        i() {
        }

        @Override // android.widget.AutoCompleteTextView.OnDismissListener
        public void onDismiss() {
            DropdownMenuEndIconDelegate.this.I();
            DropdownMenuEndIconDelegate.this.E(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DropdownMenuEndIconDelegate(@NonNull TextInputLayout textInputLayout, @DrawableRes int i3) {
        super(textInputLayout, i3);
        this.f34328e = new n() { // from class: com.google.android.material.textfield.DropdownMenuEndIconDelegate.1
            @Override // com.google.android.material.internal.n, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                final AutoCompleteTextView y16 = DropdownMenuEndIconDelegate.y(DropdownMenuEndIconDelegate.this.f34417a.L());
                if (DropdownMenuEndIconDelegate.this.f34338o.isTouchExplorationEnabled() && DropdownMenuEndIconDelegate.D(y16) && !DropdownMenuEndIconDelegate.this.f34419c.hasFocus()) {
                    y16.dismissDropDown();
                }
                y16.post(new Runnable() { // from class: com.google.android.material.textfield.DropdownMenuEndIconDelegate.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        boolean isPopupShowing = y16.isPopupShowing();
                        DropdownMenuEndIconDelegate.this.E(isPopupShowing);
                        DropdownMenuEndIconDelegate.this.f34333j = isPopupShowing;
                    }
                });
            }
        };
        this.f34329f = new c();
        this.f34330g = new d(this.f34417a);
        this.f34331h = new e();
        this.f34332i = new TextInputLayout.e() { // from class: com.google.android.material.textfield.DropdownMenuEndIconDelegate.5
            @Override // com.google.android.material.textfield.TextInputLayout.e
            public void a(@NonNull TextInputLayout textInputLayout2, int i16) {
                final AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) textInputLayout2.L();
                if (autoCompleteTextView != null && i16 == 3) {
                    autoCompleteTextView.post(new Runnable() { // from class: com.google.android.material.textfield.DropdownMenuEndIconDelegate.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            autoCompleteTextView.removeTextChangedListener(DropdownMenuEndIconDelegate.this.f34328e);
                        }
                    });
                    if (autoCompleteTextView.getOnFocusChangeListener() == DropdownMenuEndIconDelegate.this.f34329f) {
                        autoCompleteTextView.setOnFocusChangeListener(null);
                    }
                    autoCompleteTextView.setOnTouchListener(null);
                    if (DropdownMenuEndIconDelegate.f34327r) {
                        autoCompleteTextView.setOnDismissListener(null);
                    }
                }
            }
        };
        this.f34333j = false;
        this.f34334k = false;
        this.f34335l = Long.MAX_VALUE;
    }

    private MaterialShapeDrawable A(float f16, float f17, float f18, int i3) {
        com.google.android.material.shape.g m3 = com.google.android.material.shape.g.a().E(f16).I(f16).v(f17).z(f17).m();
        MaterialShapeDrawable m16 = MaterialShapeDrawable.m(this.f34418b, f18);
        m16.setShapeAppearanceModel(m3);
        m16.a0(0, i3, 0, i3);
        return m16;
    }

    private void B() {
        this.f34340q = z(67, 0.0f, 1.0f);
        ValueAnimator z16 = z(50, 1.0f, 0.0f);
        this.f34339p = z16;
        z16.addListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean C() {
        long currentTimeMillis = System.currentTimeMillis() - this.f34335l;
        if (currentTimeMillis >= 0 && currentTimeMillis <= 300) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean D(@NonNull EditText editText) {
        if (editText.getKeyListener() != null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(boolean z16) {
        if (this.f34334k != z16) {
            this.f34334k = z16;
            this.f34340q.cancel();
            this.f34339p.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(@NonNull AutoCompleteTextView autoCompleteTextView) {
        if (f34327r) {
            int I = this.f34417a.I();
            if (I == 2) {
                autoCompleteTextView.setDropDownBackgroundDrawable(this.f34337n);
            } else if (I == 1) {
                autoCompleteTextView.setDropDownBackgroundDrawable(this.f34336m);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ClickableViewAccessibility"})
    public void G(@NonNull AutoCompleteTextView autoCompleteTextView) {
        autoCompleteTextView.setOnTouchListener(new h(autoCompleteTextView));
        autoCompleteTextView.setOnFocusChangeListener(this.f34329f);
        if (f34327r) {
            autoCompleteTextView.setOnDismissListener(new i());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(@Nullable AutoCompleteTextView autoCompleteTextView) {
        if (autoCompleteTextView == null) {
            return;
        }
        if (C()) {
            this.f34333j = false;
        }
        if (!this.f34333j) {
            if (f34327r) {
                E(!this.f34334k);
            } else {
                this.f34334k = !this.f34334k;
                this.f34419c.toggle();
            }
            if (this.f34334k) {
                autoCompleteTextView.requestFocus();
                autoCompleteTextView.showDropDown();
                return;
            } else {
                autoCompleteTextView.dismissDropDown();
                return;
            }
        }
        this.f34333j = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I() {
        this.f34333j = true;
        this.f34335l = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(@NonNull AutoCompleteTextView autoCompleteTextView) {
        if (D(autoCompleteTextView)) {
            return;
        }
        int I = this.f34417a.I();
        MaterialShapeDrawable G = this.f34417a.G();
        int d16 = z0.a.d(autoCompleteTextView, R.attr.a7p);
        int[][] iArr = {new int[]{android.R.attr.state_pressed}, new int[0]};
        if (I == 2) {
            x(autoCompleteTextView, d16, iArr, G);
        } else if (I == 1) {
            w(autoCompleteTextView, d16, iArr, G);
        }
    }

    private void w(@NonNull AutoCompleteTextView autoCompleteTextView, int i3, int[][] iArr, @NonNull MaterialShapeDrawable materialShapeDrawable) {
        int H = this.f34417a.H();
        int[] iArr2 = {z0.a.h(i3, H, 0.1f), H};
        if (f34327r) {
            ViewCompat.setBackground(autoCompleteTextView, new RippleDrawable(new ColorStateList(iArr, iArr2), materialShapeDrawable, materialShapeDrawable));
            return;
        }
        MaterialShapeDrawable materialShapeDrawable2 = new MaterialShapeDrawable(materialShapeDrawable.E());
        materialShapeDrawable2.Y(new ColorStateList(iArr, iArr2));
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{materialShapeDrawable, materialShapeDrawable2});
        int paddingStart = ViewCompat.getPaddingStart(autoCompleteTextView);
        int paddingTop = autoCompleteTextView.getPaddingTop();
        int paddingEnd = ViewCompat.getPaddingEnd(autoCompleteTextView);
        int paddingBottom = autoCompleteTextView.getPaddingBottom();
        ViewCompat.setBackground(autoCompleteTextView, layerDrawable);
        ViewCompat.setPaddingRelative(autoCompleteTextView, paddingStart, paddingTop, paddingEnd, paddingBottom);
    }

    private void x(@NonNull AutoCompleteTextView autoCompleteTextView, int i3, int[][] iArr, @NonNull MaterialShapeDrawable materialShapeDrawable) {
        LayerDrawable layerDrawable;
        int d16 = z0.a.d(autoCompleteTextView, R.attr.a8g);
        MaterialShapeDrawable materialShapeDrawable2 = new MaterialShapeDrawable(materialShapeDrawable.E());
        int h16 = z0.a.h(i3, d16, 0.1f);
        materialShapeDrawable2.Y(new ColorStateList(iArr, new int[]{h16, 0}));
        if (f34327r) {
            materialShapeDrawable2.setTint(d16);
            ColorStateList colorStateList = new ColorStateList(iArr, new int[]{h16, d16});
            MaterialShapeDrawable materialShapeDrawable3 = new MaterialShapeDrawable(materialShapeDrawable.E());
            materialShapeDrawable3.setTint(-1);
            layerDrawable = new LayerDrawable(new Drawable[]{new RippleDrawable(colorStateList, materialShapeDrawable2, materialShapeDrawable3), materialShapeDrawable});
        } else {
            layerDrawable = new LayerDrawable(new Drawable[]{materialShapeDrawable2, materialShapeDrawable});
        }
        ViewCompat.setBackground(autoCompleteTextView, layerDrawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public static AutoCompleteTextView y(EditText editText) {
        if (editText instanceof AutoCompleteTextView) {
            return (AutoCompleteTextView) editText;
        }
        throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
    }

    private ValueAnimator z(int i3, float... fArr) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(x0.a.f446810a);
        ofFloat.setDuration(i3);
        ofFloat.addUpdateListener(new b());
        return ofFloat;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void J(@NonNull AutoCompleteTextView autoCompleteTextView) {
        if (!D(autoCompleteTextView) && this.f34417a.I() == 2 && (autoCompleteTextView.getBackground() instanceof LayerDrawable)) {
            v(autoCompleteTextView);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.d
    public void a() {
        float dimensionPixelOffset = this.f34418b.getResources().getDimensionPixelOffset(R.dimen.cvg);
        float dimensionPixelOffset2 = this.f34418b.getResources().getDimensionPixelOffset(R.dimen.ctn);
        int dimensionPixelOffset3 = this.f34418b.getResources().getDimensionPixelOffset(R.dimen.ctp);
        MaterialShapeDrawable A = A(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        MaterialShapeDrawable A2 = A(0.0f, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        this.f34337n = A;
        StateListDrawable stateListDrawable = new StateListDrawable();
        this.f34336m = stateListDrawable;
        stateListDrawable.addState(new int[]{android.R.attr.state_above_anchor}, A);
        this.f34336m.addState(new int[0], A2);
        int i3 = this.f34420d;
        if (i3 == 0) {
            if (f34327r) {
                i3 = R.drawable.k0o;
            } else {
                i3 = R.drawable.k0p;
            }
        }
        this.f34417a.setEndIconDrawable(i3);
        TextInputLayout textInputLayout = this.f34417a;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(R.string.zwz));
        this.f34417a.setEndIconOnClickListener(new f());
        this.f34417a.g(this.f34331h);
        this.f34417a.h(this.f34332i);
        B();
        AccessibilityManager accessibilityManager = (AccessibilityManager) this.f34418b.getSystemService("accessibility");
        this.f34338o = accessibilityManager;
        accessibilityManager.addTouchExplorationStateChangeListener(new g());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.d
    public boolean b(int i3) {
        if (i3 != 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.d
    public boolean d() {
        return true;
    }
}
