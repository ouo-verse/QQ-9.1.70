package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public class ViewOffsetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    private int tempLeftRightOffset;
    private int tempTopBottomOffset;
    private e viewOffsetHelper;

    public ViewOffsetBehavior() {
        this.tempTopBottomOffset = 0;
        this.tempLeftRightOffset = 0;
    }

    public int getLeftAndRightOffset() {
        e eVar = this.viewOffsetHelper;
        if (eVar != null) {
            return eVar.c();
        }
        return 0;
    }

    public int getTopAndBottomOffset() {
        e eVar = this.viewOffsetHelper;
        if (eVar != null) {
            return eVar.d();
        }
        return 0;
    }

    public boolean isHorizontalOffsetEnabled() {
        e eVar = this.viewOffsetHelper;
        if (eVar != null && eVar.e()) {
            return true;
        }
        return false;
    }

    public boolean isVerticalOffsetEnabled() {
        e eVar = this.viewOffsetHelper;
        if (eVar != null && eVar.f()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void layoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v3, int i3) {
        coordinatorLayout.onLayoutChild(v3, i3);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v3, int i3) {
        layoutChild(coordinatorLayout, v3, i3);
        if (this.viewOffsetHelper == null) {
            this.viewOffsetHelper = new e(v3);
        }
        this.viewOffsetHelper.g();
        this.viewOffsetHelper.a();
        int i16 = this.tempTopBottomOffset;
        if (i16 != 0) {
            this.viewOffsetHelper.j(i16);
            this.tempTopBottomOffset = 0;
        }
        int i17 = this.tempLeftRightOffset;
        if (i17 != 0) {
            this.viewOffsetHelper.i(i17);
            this.tempLeftRightOffset = 0;
            return true;
        }
        return true;
    }

    public void setHorizontalOffsetEnabled(boolean z16) {
        e eVar = this.viewOffsetHelper;
        if (eVar != null) {
            eVar.h(z16);
        }
    }

    public boolean setLeftAndRightOffset(int i3) {
        e eVar = this.viewOffsetHelper;
        if (eVar != null) {
            return eVar.i(i3);
        }
        this.tempLeftRightOffset = i3;
        return false;
    }

    public boolean setTopAndBottomOffset(int i3) {
        e eVar = this.viewOffsetHelper;
        if (eVar != null) {
            return eVar.j(i3);
        }
        this.tempTopBottomOffset = i3;
        return false;
    }

    public void setVerticalOffsetEnabled(boolean z16) {
        e eVar = this.viewOffsetHelper;
        if (eVar != null) {
            eVar.k(z16);
        }
    }

    public ViewOffsetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.tempTopBottomOffset = 0;
        this.tempLeftRightOffset = 0;
    }
}
