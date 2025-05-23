package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mm.plugin.appbrand.widget.actionbar.AppBrandActionBarNavButtonContainerLayout;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class AppBrandActionBarNavButtonContainerLayout extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    public Runnable f152350a;

    public AppBrandActionBarNavButtonContainerLayout(@NonNull Context context) {
        super(context);
    }

    public final void b() {
        Runnable runnable = this.f152350a;
        if (runnable == null) {
            this.f152350a = new Runnable() { // from class: s51.a
                @Override // java.lang.Runnable
                public final void run() {
                    AppBrandActionBarNavButtonContainerLayout.this.a();
                }
            };
        } else {
            removeCallbacks(runnable);
        }
        post(this.f152350a);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.f152350a;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        b();
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        view.setOnTouchListener(new View.OnTouchListener() { // from class: s51.b
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                return AppBrandActionBarNavButtonContainerLayout.a(view2, motionEvent);
            }
        });
        b();
    }

    public AppBrandActionBarNavButtonContainerLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public static /* synthetic */ boolean a(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            view.setAlpha(0.5f);
            return false;
        }
        if (action != 1 && action != 3 && action != 4) {
            return false;
        }
        view.setAlpha(1.0f);
        return false;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new a(-1, -1, 8388627);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class a extends LinearLayout.LayoutParams {
        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            if (((LinearLayout.LayoutParams) this).gravity == -1) {
                ((LinearLayout.LayoutParams) this).gravity = 8388627;
            }
        }

        public a(int i3, int i16, int i17) {
            super(i3, i16, i17);
            if (((LinearLayout.LayoutParams) this).gravity == -1) {
                ((LinearLayout.LayoutParams) this).gravity = 8388627;
            }
        }

        public a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            if (((LinearLayout.LayoutParams) this).gravity == -1) {
                ((LinearLayout.LayoutParams) this).gravity = 8388627;
            }
        }
    }

    public AppBrandActionBarNavButtonContainerLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LinearLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    public AppBrandActionBarNavButtonContainerLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LinearLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new a(super.generateLayoutParams(layoutParams));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (childAt.getVisibility() == 0 && childAt.isClickable()) {
                Rect rect = new Rect();
                childAt.getHitRect(rect);
                rect.left = Math.max(0, rect.left - 100);
                rect.right = Math.min(getWidth(), rect.right + 100);
                rect.top = Math.max(0, rect.top - 100);
                rect.bottom = Math.min(getHeight(), rect.bottom + 100);
                setTouchDelegate(new TouchDelegate(rect, childAt));
                return;
            }
        }
        setTouchDelegate(null);
    }
}
