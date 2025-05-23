package com.tencent.now.app.common.widget.recyclerview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import vl3.a;
import vl3.b;

/* compiled from: P */
/* loaded from: classes22.dex */
public class CommonRecyclerView extends RecyclerView {

    /* renamed from: f, reason: collision with root package name */
    private List<View> f337980f;

    /* renamed from: h, reason: collision with root package name */
    private List<View> f337981h;

    /* renamed from: i, reason: collision with root package name */
    private int f337982i;

    public CommonRecyclerView(Context context) {
        this(context, null);
    }

    public void C(View view) {
        if (getAdapter() == null) {
            this.f337980f.add(view);
            return;
        }
        throw new IllegalStateException("Cannot add header view, setAdapter has already been called.");
    }

    @Nullable
    public b D() {
        if (getAdapter() == null || !(((a) getAdapter()).k0() instanceof b)) {
            return null;
        }
        return (b) ((a) getAdapter()).k0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        if (D() != null) {
            D().onDetachedFromRecyclerView(this);
        }
        super.onDetachedFromWindow();
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void onScrollStateChanged(int i3) {
        this.f337982i = i3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(RecyclerView.Adapter adapter) throws IllegalArgumentException {
        if (adapter == null) {
            super.setAdapter(null);
            return;
        }
        if (D() != null && adapter == D()) {
            return;
        }
        if (adapter instanceof b) {
            super.setAdapter(new a(adapter));
            if (this.f337980f.size() > 0) {
                Iterator<View> it = this.f337980f.iterator();
                while (it.hasNext()) {
                    ((a) getAdapter()).j0(it.next());
                }
            }
            if (this.f337981h.size() > 0) {
                Iterator<View> it5 = this.f337981h.iterator();
                while (it5.hasNext()) {
                    ((a) getAdapter()).i0(it5.next());
                }
                return;
            }
            return;
        }
        throw new IllegalArgumentException("adapter must extends CommonAdapter");
    }

    public CommonRecyclerView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CommonRecyclerView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f337980f = new ArrayList();
        this.f337981h = new ArrayList();
        this.f337982i = -1;
    }
}
