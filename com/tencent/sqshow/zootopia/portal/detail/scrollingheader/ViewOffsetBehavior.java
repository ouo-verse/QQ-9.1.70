package com.tencent.sqshow.zootopia.portal.detail.scrollingheader;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.tencent.qphone.base.util.QLog;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes34.dex */
public class ViewOffsetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    /* renamed from: g, reason: collision with root package name */
    private a f372338g;

    /* renamed from: h, reason: collision with root package name */
    private int f372339h;

    /* renamed from: i, reason: collision with root package name */
    private int f372340i;

    public ViewOffsetBehavior() {
        this.f372339h = 0;
        this.f372340i = 0;
    }

    public int getTopAndBottomOffset() {
        a aVar = this.f372338g;
        if (aVar != null) {
            return aVar.b();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void layoutChild(CoordinatorLayout coordinatorLayout, V v3, int i3) {
        coordinatorLayout.onLayoutChild(v3, i3);
    }

    public boolean setTopAndBottomOffset(int i3) {
        a aVar = this.f372338g;
        if (aVar != null) {
            return aVar.e(i3);
        }
        this.f372339h = i3;
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v3, int i3) {
        try {
            layoutChild(coordinatorLayout, v3, i3);
        } catch (Exception e16) {
            QLog.e("ViewOffsetBehavior", 1, "onLayoutChild exception", e16);
        }
        if (this.f372338g == null) {
            this.f372338g = new a(v3);
        }
        this.f372338g.c();
        this.f372338g.a();
        int i16 = this.f372339h;
        if (i16 != 0) {
            this.f372338g.e(i16);
            this.f372339h = 0;
        }
        int i17 = this.f372340i;
        if (i17 != 0) {
            this.f372338g.d(i17);
            this.f372340i = 0;
        }
        return true;
    }

    public ViewOffsetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f372339h = 0;
        this.f372340i = 0;
    }
}
