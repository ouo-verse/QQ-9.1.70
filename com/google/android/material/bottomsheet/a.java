package com.google.android.material.bottomsheet;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.app.AppCompatDialog;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes2.dex */
public class a extends AppCompatDialog {
    private BottomSheetBehavior<FrameLayout> behavior;
    private FrameLayout bottomSheet;

    @NonNull
    private BottomSheetBehavior.e bottomSheetCallback;
    boolean cancelable;
    private boolean canceledOnTouchOutside;
    private boolean canceledOnTouchOutsideSet;
    private FrameLayout container;
    private CoordinatorLayout coordinator;
    boolean dismissWithAnimation;
    private BottomSheetBehavior.e edgeToEdgeCallback;
    private boolean edgeToEdgeEnabled;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.google.android.material.bottomsheet.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0228a implements OnApplyWindowInsetsListener {
        C0228a() {
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            if (a.this.edgeToEdgeCallback != null) {
                a.this.behavior.removeBottomSheetCallback(a.this.edgeToEdgeCallback);
            }
            if (windowInsetsCompat != null) {
                a aVar = a.this;
                aVar.edgeToEdgeCallback = new f(aVar.bottomSheet, windowInsetsCompat, null);
                a.this.behavior.addBottomSheetCallback(a.this.edgeToEdgeCallback);
            }
            return windowInsetsCompat;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            a aVar = a.this;
            if (aVar.cancelable && aVar.isShowing() && a.this.shouldWindowCloseOnTouchOutside()) {
                a.this.cancel();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class c extends AccessibilityDelegateCompat {
        c() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            if (a.this.cancelable) {
                accessibilityNodeInfoCompat.addAction(1048576);
                accessibilityNodeInfoCompat.setDismissable(true);
            } else {
                accessibilityNodeInfoCompat.setDismissable(false);
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean performAccessibilityAction(View view, int i3, Bundle bundle) {
            if (i3 == 1048576) {
                a aVar = a.this;
                if (aVar.cancelable) {
                    aVar.cancel();
                    return true;
                }
            }
            return super.performAccessibilityAction(view, i3, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class d implements View.OnTouchListener {
        d() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private static class f extends BottomSheetBehavior.e {

        /* renamed from: b, reason: collision with root package name */
        private final boolean f33366b;

        /* renamed from: c, reason: collision with root package name */
        private final boolean f33367c;

        /* renamed from: d, reason: collision with root package name */
        private final WindowInsetsCompat f33368d;

        /* synthetic */ f(View view, WindowInsetsCompat windowInsetsCompat, C0228a c0228a) {
            this(view, windowInsetsCompat);
        }

        private void a(View view) {
            if (view.getTop() < this.f33368d.getSystemWindowInsetTop()) {
                a.setLightStatusBar(view, this.f33366b);
                view.setPadding(view.getPaddingLeft(), this.f33368d.getSystemWindowInsetTop() - view.getTop(), view.getPaddingRight(), view.getPaddingBottom());
            } else if (view.getTop() != 0) {
                a.setLightStatusBar(view, this.f33367c);
                view.setPadding(view.getPaddingLeft(), 0, view.getPaddingRight(), view.getPaddingBottom());
            }
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.e
        void onLayout(@NonNull View view) {
            a(view);
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.e
        public void onSlide(@NonNull View view, float f16) {
            a(view);
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.e
        public void onStateChanged(@NonNull View view, int i3) {
            a(view);
        }

        f(@NonNull View view, @NonNull WindowInsetsCompat windowInsetsCompat) {
            ColorStateList backgroundTintList;
            this.f33368d = windowInsetsCompat;
            boolean z16 = (view.getSystemUiVisibility() & 8192) != 0;
            this.f33367c = z16;
            MaterialShapeDrawable materialShapeDrawable = BottomSheetBehavior.from(view).getMaterialShapeDrawable();
            if (materialShapeDrawable != null) {
                backgroundTintList = materialShapeDrawable.x();
            } else {
                backgroundTintList = ViewCompat.getBackgroundTintList(view);
            }
            if (backgroundTintList != null) {
                this.f33366b = z0.a.f(backgroundTintList.getDefaultColor());
            } else if (view.getBackground() instanceof ColorDrawable) {
                this.f33366b = z0.a.f(((ColorDrawable) view.getBackground()).getColor());
            } else {
                this.f33366b = z16;
            }
        }
    }

    public a(@NonNull Context context) {
        this(context, 0);
        this.edgeToEdgeEnabled = getContext().getTheme().obtainStyledAttributes(new int[]{R.attr.adl}).getBoolean(0, false);
    }

    private FrameLayout ensureContainerAndBehavior() {
        if (this.container == null) {
            FrameLayout frameLayout = (FrameLayout) View.inflate(getContext(), R.layout.e5j, null);
            this.container = frameLayout;
            this.coordinator = (CoordinatorLayout) frameLayout.findViewById(R.id.u9g);
            FrameLayout frameLayout2 = (FrameLayout) this.container.findViewById(R.id.ugk);
            this.bottomSheet = frameLayout2;
            BottomSheetBehavior<FrameLayout> from = BottomSheetBehavior.from(frameLayout2);
            this.behavior = from;
            from.addBottomSheetCallback(this.bottomSheetCallback);
            this.behavior.setHideable(this.cancelable);
        }
        return this.container;
    }

    private static int getThemeResId(@NonNull Context context, int i3) {
        if (i3 == 0) {
            TypedValue typedValue = new TypedValue();
            if (context.getTheme().resolveAttribute(R.attr.a2v, typedValue, true)) {
                return typedValue.resourceId;
            }
            return R.style.add;
        }
        return i3;
    }

    public static void setLightStatusBar(@NonNull View view, boolean z16) {
        int i3;
        int systemUiVisibility = view.getSystemUiVisibility();
        if (z16) {
            i3 = systemUiVisibility | 8192;
        } else {
            i3 = systemUiVisibility & (-8193);
        }
        view.setSystemUiVisibility(i3);
    }

    private View wrapInBottomSheet(int i3, @Nullable View view, @Nullable ViewGroup.LayoutParams layoutParams) {
        ensureContainerAndBehavior();
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) this.container.findViewById(R.id.u9g);
        if (i3 != 0 && view == null) {
            view = getLayoutInflater().inflate(i3, (ViewGroup) coordinatorLayout, false);
        }
        if (this.edgeToEdgeEnabled) {
            ViewCompat.setOnApplyWindowInsetsListener(this.bottomSheet, new C0228a());
        }
        this.bottomSheet.removeAllViews();
        if (layoutParams == null) {
            this.bottomSheet.addView(view);
        } else {
            this.bottomSheet.addView(view, layoutParams);
        }
        coordinatorLayout.findViewById(R.id.f100585sw).setOnClickListener(new b());
        ViewCompat.setAccessibilityDelegate(this.bottomSheet, new c());
        this.bottomSheet.setOnTouchListener(new d());
        return this.container;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        BottomSheetBehavior<FrameLayout> behavior = getBehavior();
        if (this.dismissWithAnimation && behavior.getState() != 5) {
            behavior.setState(5);
        } else {
            super.cancel();
        }
    }

    @NonNull
    public BottomSheetBehavior<FrameLayout> getBehavior() {
        if (this.behavior == null) {
            ensureContainerAndBehavior();
        }
        return this.behavior;
    }

    public boolean getDismissWithAnimation() {
        return this.dismissWithAnimation;
    }

    public boolean getEdgeToEdgeEnabled() {
        return this.edgeToEdgeEnabled;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        boolean z16;
        super.onAttachedToWindow();
        Window window = getWindow();
        if (window != null) {
            if (this.edgeToEdgeEnabled && Color.alpha(window.getNavigationBarColor()) < 255) {
                z16 = true;
            } else {
                z16 = false;
            }
            FrameLayout frameLayout = this.container;
            if (frameLayout != null) {
                frameLayout.setFitsSystemWindows(!z16);
            }
            CoordinatorLayout coordinatorLayout = this.coordinator;
            if (coordinatorLayout != null) {
                coordinatorLayout.setFitsSystemWindows(!z16);
            }
            if (z16) {
                window.getDecorView().setSystemUiVisibility(768);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            window.setStatusBarColor(0);
            window.addFlags(Integer.MIN_VALUE);
            window.setLayout(-1, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.behavior;
        if (bottomSheetBehavior != null && bottomSheetBehavior.getState() == 5) {
            this.behavior.setState(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removeDefaultCallback() {
        this.behavior.removeBottomSheetCallback(this.bottomSheetCallback);
    }

    @Override // android.app.Dialog
    public void setCancelable(boolean z16) {
        super.setCancelable(z16);
        if (this.cancelable != z16) {
            this.cancelable = z16;
            BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.behavior;
            if (bottomSheetBehavior != null) {
                bottomSheetBehavior.setHideable(z16);
            }
        }
    }

    @Override // android.app.Dialog
    public void setCanceledOnTouchOutside(boolean z16) {
        super.setCanceledOnTouchOutside(z16);
        if (z16 && !this.cancelable) {
            this.cancelable = true;
        }
        this.canceledOnTouchOutside = z16;
        this.canceledOnTouchOutsideSet = true;
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void setContentView(@LayoutRes int i3) {
        super.setContentView(wrapInBottomSheet(i3, null, null));
    }

    public void setDismissWithAnimation(boolean z16) {
        this.dismissWithAnimation = z16;
    }

    boolean shouldWindowCloseOnTouchOutside() {
        if (!this.canceledOnTouchOutsideSet) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(new int[]{android.R.attr.windowCloseOnTouchOutside});
            this.canceledOnTouchOutside = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
            this.canceledOnTouchOutsideSet = true;
        }
        return this.canceledOnTouchOutside;
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void setContentView(View view) {
        super.setContentView(wrapInBottomSheet(0, view, null));
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(wrapInBottomSheet(0, view, layoutParams));
    }

    public a(@NonNull Context context, @StyleRes int i3) {
        super(context, getThemeResId(context, i3));
        this.cancelable = true;
        this.canceledOnTouchOutside = true;
        this.bottomSheetCallback = new e();
        supportRequestWindowFeature(1);
        this.edgeToEdgeEnabled = getContext().getTheme().obtainStyledAttributes(new int[]{R.attr.adl}).getBoolean(0, false);
    }

    protected a(@NonNull Context context, boolean z16, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z16, onCancelListener);
        this.cancelable = true;
        this.canceledOnTouchOutside = true;
        this.bottomSheetCallback = new e();
        supportRequestWindowFeature(1);
        this.cancelable = z16;
        this.edgeToEdgeEnabled = getContext().getTheme().obtainStyledAttributes(new int[]{R.attr.adl}).getBoolean(0, false);
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class e extends BottomSheetBehavior.e {
        e() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.e
        public void onStateChanged(@NonNull View view, int i3) {
            if (i3 == 5) {
                a.this.cancel();
            }
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.e
        public void onSlide(@NonNull View view, float f16) {
        }
    }
}
