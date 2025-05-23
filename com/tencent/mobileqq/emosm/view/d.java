package com.tencent.mobileqq.emosm.view;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mobileqq.emosm.view.DragSortListView;
import com.tencent.widget.XListView;

/* compiled from: P */
/* loaded from: classes6.dex */
public class d implements DragSortListView.i {

    /* renamed from: d, reason: collision with root package name */
    private Bitmap f204455d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f204456e;

    /* renamed from: f, reason: collision with root package name */
    private int f204457f = -16777216;

    /* renamed from: h, reason: collision with root package name */
    private XListView f204458h;

    public d(XListView xListView) {
        this.f204458h = xListView;
    }

    public void a(int i3) {
        this.f204457f = i3;
    }

    @Override // com.tencent.mobileqq.emosm.view.DragSortListView.i
    public View onCreateFloatView(int i3) {
        XListView xListView = this.f204458h;
        View childAt = xListView.getChildAt((i3 + xListView.getHeaderViewsCount()) - this.f204458h.getFirstVisiblePosition());
        if (childAt == null) {
            return null;
        }
        childAt.setPressed(false);
        childAt.setDrawingCacheEnabled(true);
        if (childAt.getDrawingCache() == null) {
            return null;
        }
        this.f204455d = Bitmap.createBitmap(childAt.getDrawingCache());
        childAt.setDrawingCacheEnabled(false);
        if (this.f204456e == null) {
            this.f204456e = new ImageView(this.f204458h.getContext());
        }
        this.f204456e.setBackgroundColor(this.f204457f);
        this.f204456e.setPadding(0, 0, 0, 0);
        this.f204456e.setImageBitmap(this.f204455d);
        this.f204456e.setLayoutParams(new ViewGroup.LayoutParams(childAt.getWidth(), childAt.getHeight()));
        return this.f204456e;
    }

    @Override // com.tencent.mobileqq.emosm.view.DragSortListView.i
    public void onDestroyFloatView(View view) {
        ((ImageView) view).setImageDrawable(null);
        this.f204455d.recycle();
        this.f204455d = null;
    }
}
