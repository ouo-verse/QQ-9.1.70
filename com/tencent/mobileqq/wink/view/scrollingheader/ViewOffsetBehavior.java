package com.tencent.mobileqq.wink.view.scrollingheader;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* compiled from: P */
/* loaded from: classes21.dex */
class ViewOffsetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    /* renamed from: g, reason: collision with root package name */
    private a f327110g;

    /* renamed from: h, reason: collision with root package name */
    private int f327111h;

    /* renamed from: i, reason: collision with root package name */
    private int f327112i;

    public ViewOffsetBehavior() {
        this.f327111h = 0;
        this.f327112i = 0;
    }

    public int getTopAndBottomOffset() {
        a aVar = this.f327110g;
        if (aVar != null) {
            return aVar.b();
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
        if (this.f327110g == null) {
            this.f327110g = new a(v3);
        }
        this.f327110g.c();
        this.f327110g.a();
        int i16 = this.f327111h;
        if (i16 != 0) {
            this.f327110g.e(i16);
            this.f327111h = 0;
        }
        int i17 = this.f327112i;
        if (i17 != 0) {
            this.f327110g.d(i17);
            this.f327112i = 0;
            return true;
        }
        return true;
    }

    public boolean setTopAndBottomOffset(int i3) {
        a aVar = this.f327110g;
        if (aVar != null) {
            return aVar.e(i3);
        }
        this.f327111h = i3;
        return false;
    }

    public ViewOffsetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f327111h = 0;
        this.f327112i = 0;
    }
}
