package com.tencent.mm.ui.widget.sortlist;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import com.tencent.luggage.wxa.lo.n;
import com.tencent.mm.ui.widget.sortlist.DragSortListView;

/* compiled from: P */
/* loaded from: classes9.dex */
public class SimpleFloatViewManager implements DragSortListView.FloatViewManager {

    /* renamed from: a, reason: collision with root package name */
    public Bitmap f153955a;

    /* renamed from: b, reason: collision with root package name */
    public ImageView f153956b;

    /* renamed from: c, reason: collision with root package name */
    public int f153957c = -16777216;

    /* renamed from: d, reason: collision with root package name */
    public ListView f153958d;

    public SimpleFloatViewManager(ListView listView) {
        this.f153958d = listView;
    }

    @Override // com.tencent.mm.ui.widget.sortlist.DragSortListView.FloatViewManager
    public View onCreateFloatView(int i3) {
        ListView listView = this.f153958d;
        View childAt = listView.getChildAt((i3 + listView.getHeaderViewsCount()) - this.f153958d.getFirstVisiblePosition());
        if (childAt == null) {
            return null;
        }
        childAt.setPressed(false);
        childAt.setDrawingCacheEnabled(true);
        this.f153955a = Bitmap.createBitmap(childAt.getDrawingCache());
        childAt.setDrawingCacheEnabled(false);
        if (this.f153956b == null) {
            this.f153956b = new ImageView(this.f153958d.getContext());
        }
        this.f153956b.setBackgroundColor(this.f153957c);
        this.f153956b.setPadding(0, 0, 0, 0);
        this.f153956b.setImageBitmap(this.f153955a);
        this.f153956b.setLayoutParams(new ViewGroup.LayoutParams(childAt.getWidth(), childAt.getHeight()));
        return this.f153956b;
    }

    @Override // com.tencent.mm.ui.widget.sortlist.DragSortListView.FloatViewManager
    public void onDestroyFloatView(View view) {
        if (view instanceof ImageView) {
            ((ImageView) view).setImageDrawable(null);
        }
        n.c("MicroMsg.SimpleFloatViewManager", "bitmap recycle %s", this.f153955a.toString());
        this.f153955a.recycle();
        this.f153955a = null;
    }

    public void setBackgroundColor(int i3) {
        this.f153957c = i3;
    }

    @Override // com.tencent.mm.ui.widget.sortlist.DragSortListView.FloatViewManager
    public void onDragFloatView(View view, Point point, Point point2) {
    }
}
