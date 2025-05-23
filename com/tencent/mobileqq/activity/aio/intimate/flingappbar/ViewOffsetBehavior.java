package com.tencent.mobileqq.activity.aio.intimate.flingappbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes10.dex */
public class ViewOffsetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    /* renamed from: g, reason: collision with root package name */
    private b f178971g;

    /* renamed from: h, reason: collision with root package name */
    private int f178972h;

    /* renamed from: i, reason: collision with root package name */
    private int f178973i;

    public ViewOffsetBehavior() {
        this.f178972h = 0;
        this.f178973i = 0;
    }

    public int getTopAndBottomOffset() {
        b bVar = this.f178971g;
        if (bVar != null) {
            return bVar.b();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void layoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v3, int i3) {
        coordinatorLayout.onLayoutChild(v3, i3);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v3, int i3) {
        layoutChild(coordinatorLayout, v3, i3);
        if (this.f178971g == null) {
            this.f178971g = new b(v3);
        }
        this.f178971g.c();
        this.f178971g.a();
        int i16 = this.f178972h;
        if (i16 != 0) {
            this.f178971g.e(i16);
            this.f178972h = 0;
        }
        int i17 = this.f178973i;
        if (i17 != 0) {
            this.f178971g.d(i17);
            this.f178973i = 0;
            return true;
        }
        return true;
    }

    public boolean setTopAndBottomOffset(int i3) {
        b bVar = this.f178971g;
        if (bVar != null) {
            return bVar.e(i3);
        }
        this.f178972h = i3;
        return false;
    }

    public ViewOffsetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f178972h = 0;
        this.f178973i = 0;
    }
}
