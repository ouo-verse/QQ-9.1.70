package com.tencent.ecommerce.base.ui.refreshview;

import androidx.recyclerview.widget.GridLayoutManager;

/* compiled from: P */
/* loaded from: classes32.dex */
public class a extends GridLayoutManager.SpanSizeLookup {

    /* renamed from: a, reason: collision with root package name */
    private final RecyclerViewHeaderViewAdapter f101228a;

    /* renamed from: b, reason: collision with root package name */
    private final GridLayoutManager f101229b;

    /* renamed from: c, reason: collision with root package name */
    private GridLayoutManager.SpanSizeLookup f101230c;

    public a(RecyclerViewHeaderViewAdapter recyclerViewHeaderViewAdapter, GridLayoutManager gridLayoutManager) {
        this.f101228a = recyclerViewHeaderViewAdapter;
        this.f101229b = gridLayoutManager;
    }

    public void a(GridLayoutManager.SpanSizeLookup spanSizeLookup) {
        this.f101230c = spanSizeLookup;
    }

    @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
    public int getSpanSize(int i3) {
        if (this.f101228a.isHeaderPosition(i3) || this.f101228a.isFooterPosition(i3)) {
            return this.f101229b.getSpanCount();
        }
        GridLayoutManager.SpanSizeLookup spanSizeLookup = this.f101230c;
        if (spanSizeLookup == null) {
            return 1;
        }
        return spanSizeLookup.getSpanSize(i3 - this.f101228a.getHeaderCount());
    }
}
