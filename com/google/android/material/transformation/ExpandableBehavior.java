package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import java.util.List;

/* compiled from: P */
@Deprecated
/* loaded from: classes2.dex */
public abstract class ExpandableBehavior extends CoordinatorLayout.Behavior<View> {

    /* renamed from: g, reason: collision with root package name */
    private int f34494g;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class a implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f34495d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f34496e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ d1.a f34497f;

        a(View view, int i3, d1.a aVar) {
            this.f34495d = view;
            this.f34496e = i3;
            this.f34497f = aVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            this.f34495d.getViewTreeObserver().removeOnPreDrawListener(this);
            if (ExpandableBehavior.this.f34494g == this.f34496e) {
                ExpandableBehavior expandableBehavior = ExpandableBehavior.this;
                d1.a aVar = this.f34497f;
                expandableBehavior.e((View) aVar, this.f34495d, aVar.isExpanded(), false);
            }
            return false;
        }
    }

    public ExpandableBehavior() {
        this.f34494g = 0;
    }

    private boolean c(boolean z16) {
        if (z16) {
            int i3 = this.f34494g;
            if (i3 != 0 && i3 != 2) {
                return false;
            }
            return true;
        }
        if (this.f34494g != 1) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    protected d1.a d(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view) {
        List<View> dependencies = coordinatorLayout.getDependencies(view);
        int size = dependencies.size();
        for (int i3 = 0; i3 < size; i3++) {
            View view2 = dependencies.get(i3);
            if (layoutDependsOn(coordinatorLayout, view, view2)) {
                return (d1.a) view2;
            }
        }
        return null;
    }

    protected abstract boolean e(View view, View view2, boolean z16, boolean z17);

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public abstract boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    @CallSuper
    public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
        int i3;
        d1.a aVar = (d1.a) view2;
        if (c(aVar.isExpanded())) {
            if (aVar.isExpanded()) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            this.f34494g = i3;
            return e((View) aVar, view, aVar.isExpanded(), true);
        }
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    @CallSuper
    public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i3) {
        d1.a d16;
        int i16;
        if (!ViewCompat.isLaidOut(view) && (d16 = d(coordinatorLayout, view)) != null && c(d16.isExpanded())) {
            if (d16.isExpanded()) {
                i16 = 1;
            } else {
                i16 = 2;
            }
            this.f34494g = i16;
            view.getViewTreeObserver().addOnPreDrawListener(new a(view, i16, d16));
            return false;
        }
        return false;
    }

    public ExpandableBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f34494g = 0;
    }
}
