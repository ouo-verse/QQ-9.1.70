package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.widget.ViewDragHelper;

/* compiled from: P */
/* loaded from: classes2.dex */
public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    /* renamed from: g, reason: collision with root package name */
    ViewDragHelper f33282g;

    /* renamed from: h, reason: collision with root package name */
    c f33283h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f33284i;

    /* renamed from: k, reason: collision with root package name */
    private boolean f33286k;

    /* renamed from: j, reason: collision with root package name */
    private float f33285j = 0.0f;

    /* renamed from: l, reason: collision with root package name */
    int f33287l = 2;

    /* renamed from: m, reason: collision with root package name */
    float f33288m = 0.5f;

    /* renamed from: n, reason: collision with root package name */
    float f33289n = 0.0f;

    /* renamed from: o, reason: collision with root package name */
    float f33290o = 0.5f;

    /* renamed from: p, reason: collision with root package name */
    private final ViewDragHelper.Callback f33291p = new a();

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private class SettleRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private final View f33292d;

        /* renamed from: e, reason: collision with root package name */
        private final boolean f33293e;

        SettleRunnable(View view, boolean z16) {
            this.f33292d = view;
            this.f33293e = z16;
        }

        @Override // java.lang.Runnable
        public void run() {
            c cVar;
            ViewDragHelper viewDragHelper = SwipeDismissBehavior.this.f33282g;
            if (viewDragHelper != null && viewDragHelper.continueSettling(true)) {
                ViewCompat.postOnAnimation(this.f33292d, this);
            } else if (this.f33293e && (cVar = SwipeDismissBehavior.this.f33283h) != null) {
                cVar.b(this.f33292d);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class a extends ViewDragHelper.Callback {

        /* renamed from: a, reason: collision with root package name */
        private int f33294a;

        /* renamed from: b, reason: collision with root package name */
        private int f33295b = -1;

        a() {
        }

        private boolean a(@NonNull View view, float f16) {
            boolean z16;
            if (f16 != 0.0f) {
                if (ViewCompat.getLayoutDirection(view) == 1) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                int i3 = SwipeDismissBehavior.this.f33287l;
                if (i3 == 2) {
                    return true;
                }
                if (i3 == 0) {
                    if (z16) {
                        if (f16 >= 0.0f) {
                            return false;
                        }
                    } else if (f16 <= 0.0f) {
                        return false;
                    }
                    return true;
                }
                if (i3 != 1) {
                    return false;
                }
                if (z16) {
                    if (f16 <= 0.0f) {
                        return false;
                    }
                } else if (f16 >= 0.0f) {
                    return false;
                }
                return true;
            }
            if (Math.abs(view.getLeft() - this.f33294a) < Math.round(view.getWidth() * SwipeDismissBehavior.this.f33288m)) {
                return false;
            }
            return true;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionHorizontal(@NonNull View view, int i3, int i16) {
            boolean z16;
            int width;
            int width2;
            int width3;
            if (ViewCompat.getLayoutDirection(view) == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            int i17 = SwipeDismissBehavior.this.f33287l;
            if (i17 == 0) {
                if (z16) {
                    width = this.f33294a - view.getWidth();
                    width2 = this.f33294a;
                } else {
                    width = this.f33294a;
                    width3 = view.getWidth();
                    width2 = width3 + width;
                }
            } else if (i17 == 1) {
                if (z16) {
                    width = this.f33294a;
                    width3 = view.getWidth();
                    width2 = width3 + width;
                } else {
                    width = this.f33294a - view.getWidth();
                    width2 = this.f33294a;
                }
            } else {
                width = this.f33294a - view.getWidth();
                width2 = view.getWidth() + this.f33294a;
            }
            return SwipeDismissBehavior.d(width, i3, width2);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionVertical(@NonNull View view, int i3, int i16) {
            return view.getTop();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int getViewHorizontalDragRange(@NonNull View view) {
            return view.getWidth();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewCaptured(@NonNull View view, int i3) {
            this.f33295b = i3;
            this.f33294a = view.getLeft();
            ViewParent parent = view.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewDragStateChanged(int i3) {
            c cVar = SwipeDismissBehavior.this.f33283h;
            if (cVar != null) {
                cVar.a(i3);
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewPositionChanged(@NonNull View view, int i3, int i16, int i17, int i18) {
            float width = this.f33294a + (view.getWidth() * SwipeDismissBehavior.this.f33289n);
            float width2 = this.f33294a + (view.getWidth() * SwipeDismissBehavior.this.f33290o);
            float f16 = i3;
            if (f16 <= width) {
                view.setAlpha(1.0f);
            } else if (f16 >= width2) {
                view.setAlpha(0.0f);
            } else {
                view.setAlpha(SwipeDismissBehavior.c(0.0f, 1.0f - SwipeDismissBehavior.f(width, width2, f16), 1.0f));
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewReleased(@NonNull View view, float f16, float f17) {
            int i3;
            boolean z16;
            c cVar;
            this.f33295b = -1;
            int width = view.getWidth();
            if (a(view, f16)) {
                int left = view.getLeft();
                int i16 = this.f33294a;
                if (left < i16) {
                    i3 = i16 - width;
                } else {
                    i3 = i16 + width;
                }
                z16 = true;
            } else {
                i3 = this.f33294a;
                z16 = false;
            }
            if (SwipeDismissBehavior.this.f33282g.settleCapturedViewAt(i3, view.getTop())) {
                ViewCompat.postOnAnimation(view, new SettleRunnable(view, z16));
            } else if (z16 && (cVar = SwipeDismissBehavior.this.f33283h) != null) {
                cVar.b(view);
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(View view, int i3) {
            int i16 = this.f33295b;
            if ((i16 == -1 || i16 == i3) && SwipeDismissBehavior.this.b(view)) {
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class b implements AccessibilityViewCommand {
        b() {
        }

        @Override // androidx.core.view.accessibility.AccessibilityViewCommand
        public boolean perform(@NonNull View view, @Nullable AccessibilityViewCommand.CommandArguments commandArguments) {
            boolean z16;
            boolean z17 = false;
            if (!SwipeDismissBehavior.this.b(view)) {
                return false;
            }
            if (ViewCompat.getLayoutDirection(view) == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            int i3 = SwipeDismissBehavior.this.f33287l;
            if ((i3 == 0 && z16) || (i3 == 1 && !z16)) {
                z17 = true;
            }
            int width = view.getWidth();
            if (z17) {
                width = -width;
            }
            ViewCompat.offsetLeftAndRight(view, width);
            view.setAlpha(0.0f);
            c cVar = SwipeDismissBehavior.this.f33283h;
            if (cVar != null) {
                cVar.b(view);
            }
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface c {
        void a(int i3);

        void b(View view);
    }

    static float c(float f16, float f17, float f18) {
        return Math.min(Math.max(f16, f17), f18);
    }

    static int d(int i3, int i16, int i17) {
        return Math.min(Math.max(i3, i16), i17);
    }

    private void e(ViewGroup viewGroup) {
        ViewDragHelper create;
        if (this.f33282g == null) {
            if (this.f33286k) {
                create = ViewDragHelper.create(viewGroup, this.f33285j, this.f33291p);
            } else {
                create = ViewDragHelper.create(viewGroup, this.f33291p);
            }
            this.f33282g = create;
        }
    }

    static float f(float f16, float f17, float f18) {
        return (f18 - f16) / (f17 - f16);
    }

    private void k(View view) {
        ViewCompat.removeAccessibilityAction(view, 1048576);
        if (b(view)) {
            ViewCompat.replaceAccessibilityAction(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DISMISS, null, new b());
        }
    }

    public boolean b(@NonNull View view) {
        return true;
    }

    public void g(float f16) {
        this.f33290o = c(0.0f, f16, 1.0f);
    }

    public void h(@Nullable c cVar) {
        this.f33283h = cVar;
    }

    public void i(float f16) {
        this.f33289n = c(0.0f, f16, 1.0f);
    }

    public void j(int i3) {
        this.f33287l = i3;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v3, @NonNull MotionEvent motionEvent) {
        boolean z16 = this.f33284i;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 1 || actionMasked == 3) {
                this.f33284i = false;
            }
        } else {
            z16 = coordinatorLayout.isPointInChildBounds(v3, (int) motionEvent.getX(), (int) motionEvent.getY());
            this.f33284i = z16;
        }
        if (!z16) {
            return false;
        }
        e(coordinatorLayout);
        return this.f33282g.shouldInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v3, int i3) {
        boolean onLayoutChild = super.onLayoutChild(coordinatorLayout, v3, i3);
        if (ViewCompat.getImportantForAccessibility(v3) == 0) {
            ViewCompat.setImportantForAccessibility(v3, 1);
            k(v3);
        }
        return onLayoutChild;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v3, MotionEvent motionEvent) {
        ViewDragHelper viewDragHelper = this.f33282g;
        if (viewDragHelper != null) {
            viewDragHelper.processTouchEvent(motionEvent);
            return true;
        }
        return false;
    }
}
