package com.tencent.aelight.camera.ae.view.scrollingheader;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* compiled from: P */
/* loaded from: classes32.dex */
class ViewOffsetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    /* renamed from: g, reason: collision with root package name */
    private a f65953g;

    /* renamed from: h, reason: collision with root package name */
    private int f65954h;

    /* renamed from: i, reason: collision with root package name */
    private int f65955i;

    public ViewOffsetBehavior() {
        this.f65954h = 0;
        this.f65955i = 0;
    }

    public int getTopAndBottomOffset() {
        a aVar = this.f65953g;
        if (aVar != null) {
            return aVar.b();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void layoutChild(CoordinatorLayout coordinatorLayout, V v3, int i3) {
        coordinatorLayout.onLayoutChild(v3, i3);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v3, int i3) {
        layoutChild(coordinatorLayout, v3, i3);
        if (this.f65953g == null) {
            this.f65953g = new a(v3);
        }
        this.f65953g.c();
        this.f65953g.a();
        int i16 = this.f65954h;
        if (i16 != 0) {
            this.f65953g.e(i16);
            this.f65954h = 0;
        }
        int i17 = this.f65955i;
        if (i17 == 0) {
            return true;
        }
        this.f65953g.d(i17);
        this.f65955i = 0;
        return true;
    }

    public boolean setTopAndBottomOffset(int i3) {
        a aVar = this.f65953g;
        if (aVar != null) {
            return aVar.e(i3);
        }
        this.f65954h = i3;
        return false;
    }

    public ViewOffsetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f65954h = 0;
        this.f65955i = 0;
    }
}
