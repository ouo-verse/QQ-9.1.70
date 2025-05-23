package com.tencent.mobileqq.qqvideoedit.view.scrollingheader;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* compiled from: P */
/* loaded from: classes17.dex */
class ViewOffsetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    /* renamed from: g, reason: collision with root package name */
    private a f276343g;

    /* renamed from: h, reason: collision with root package name */
    private int f276344h;

    /* renamed from: i, reason: collision with root package name */
    private int f276345i;

    public ViewOffsetBehavior() {
        this.f276344h = 0;
        this.f276345i = 0;
    }

    public int getTopAndBottomOffset() {
        a aVar = this.f276343g;
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
        if (this.f276343g == null) {
            this.f276343g = new a(v3);
        }
        this.f276343g.c();
        this.f276343g.a();
        int i16 = this.f276344h;
        if (i16 != 0) {
            this.f276343g.e(i16);
            this.f276344h = 0;
        }
        int i17 = this.f276345i;
        if (i17 != 0) {
            this.f276343g.d(i17);
            this.f276345i = 0;
            return true;
        }
        return true;
    }

    public boolean setTopAndBottomOffset(int i3) {
        a aVar = this.f276343g;
        if (aVar != null) {
            return aVar.e(i3);
        }
        this.f276344h = i3;
        return false;
    }

    public ViewOffsetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f276344h = 0;
        this.f276345i = 0;
    }
}
