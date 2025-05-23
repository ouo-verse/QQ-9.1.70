package com.tencent.mobileqq.nearby.now.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import t92.a;
import t92.b;

/* compiled from: P */
/* loaded from: classes15.dex */
public class CommonRecyclerView extends RecyclerView {

    /* renamed from: d, reason: collision with root package name */
    private List<View> f253016d;

    /* renamed from: e, reason: collision with root package name */
    private List<View> f253017e;

    /* renamed from: f, reason: collision with root package name */
    private int f253018f;

    public CommonRecyclerView(Context context) {
        this(context, null);
    }

    @Nullable
    public b c() {
        if (getAdapter() == null || !(((a) getAdapter()).p() instanceof b)) {
            return null;
        }
        return (b) ((a) getAdapter()).p();
    }

    @Override // android.support.v7.widget.RecyclerView
    public void setAdapter(RecyclerView.Adapter adapter) throws IllegalArgumentException {
        if (adapter == null) {
            super.setAdapter(null);
            return;
        }
        if (c() != null && adapter == c()) {
            return;
        }
        if (adapter instanceof b) {
            super.setAdapter(new a(adapter));
            if (this.f253016d.size() > 0) {
                Iterator<View> it = this.f253016d.iterator();
                while (it.hasNext()) {
                    ((a) getAdapter()).addHeaderView(it.next());
                }
            }
            if (this.f253017e.size() > 0) {
                Iterator<View> it5 = this.f253017e.iterator();
                while (it5.hasNext()) {
                    ((a) getAdapter()).addFooterView(it5.next());
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
        this.f253016d = new ArrayList();
        this.f253017e = new ArrayList();
        this.f253018f = -1;
    }
}
