package com.tencent.biz.troopgift;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import java.util.ArrayList;

/* loaded from: classes5.dex */
public class GridListViewPager extends absMultiViewPager {
    protected int D;
    protected int E;
    protected int F;
    protected String G;
    public TroopGiftPanel H;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a extends GridView {
        a(Context context) {
            super(context);
        }

        @Override // android.view.View
        public void setOverScrollMode(int i3) {
            super.setOverScrollMode(2);
        }
    }

    public GridListViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.E = 4;
        this.F = 2;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.D = Math.min(displayMetrics.heightPixels, displayMetrics.widthPixels);
    }

    @Override // com.tencent.biz.troopgift.absMultiViewPager
    public View a(int i3) {
        return i(i3, k(i3));
    }

    @Override // com.tencent.biz.troopgift.absMultiViewPager
    public int b() {
        int size = this.f96914d.size() / (this.E * this.F);
        if (this.f96914d.size() % (this.E * this.F) > 0) {
            return size + 1;
        }
        return size;
    }

    public View i(int i3, ArrayList<Object> arrayList) {
        a aVar = new a(getContext());
        aVar.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        aVar.setVerticalSpacing(0);
        aVar.setHorizontalSpacing(10);
        aVar.setColumnWidth((this.D / this.E) - 40);
        aVar.setNumColumns(this.E);
        Resources resources = getContext().getResources();
        aVar.setPadding(BaseAIOUtils.f(5.0f, resources), BaseAIOUtils.f(1.0f, resources), BaseAIOUtils.f(5.0f, resources), BaseAIOUtils.f(1.0f, resources));
        aVar.setGravity(1);
        aVar.setSelector(new ColorDrawable(0));
        GridListAdapter gridListAdapter = new GridListAdapter(getContext(), this.H);
        gridListAdapter.setData(arrayList);
        gridListAdapter.b(this.G);
        aVar.setAdapter((ListAdapter) gridListAdapter);
        aVar.setOnItemClickListener(this);
        gridListAdapter.notifyDataSetChanged();
        return aVar;
    }

    public ArrayList<Object> k(int i3) {
        if (i3 == this.f96918i - 1) {
            ArrayList<Object> arrayList = this.f96914d;
            return absMultiViewPager.h(arrayList, this.E * this.F * i3, arrayList.size());
        }
        ArrayList<Object> arrayList2 = this.f96914d;
        int i16 = this.E;
        int i17 = this.F;
        return absMultiViewPager.h(arrayList2, i16 * i17 * i3, (i3 + 1) * i16 * i17);
    }

    public void setGridGiftIcon(String str) {
        this.G = str;
    }

    public void setGridSize(int i3, int i16) {
        boolean z16;
        boolean z17 = true;
        if (this.E != i3) {
            this.E = i3;
            z16 = true;
        } else {
            z16 = false;
        }
        if (this.F != i16) {
            this.F = i16;
        } else {
            z17 = z16;
        }
        if (z17) {
            g();
        }
    }

    public GridListViewPager(Context context) {
        super(context);
        this.E = 4;
        this.F = 2;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.D = Math.min(displayMetrics.heightPixels, displayMetrics.widthPixels);
    }
}
