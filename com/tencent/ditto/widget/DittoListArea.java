package com.tencent.ditto.widget;

import com.tencent.ditto.area.DittoArea;
import com.tencent.ditto.area.DittoHost;
import com.tencent.ditto.shell.LayoutAttrSet;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class DittoListArea extends LinearAreaLayout {
    private ListAreaAdapter adapter;
    private int mItemInterval;
    private List<Integer> numbersOfRows;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface ListAreaAdapter {
        DittoArea getArea(DittoListArea dittoListArea, int i3, int i16);

        int numberOfRows(DittoListArea dittoListArea, int i3);
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface ListAreaAdapterWithSection extends ListAreaAdapter {
        int numberOfSections(DittoListArea dittoListArea);
    }

    public DittoListArea(DittoHost dittoHost, LayoutAttrSet layoutAttrSet) {
        super(dittoHost, layoutAttrSet);
        this.numbersOfRows = new ArrayList();
        this.mItemInterval = 0;
    }

    public ListAreaAdapter getAdapter() {
        return this.adapter;
    }

    public int getItemInterval() {
        return this.mItemInterval;
    }

    public void reloadRows() {
        int i3;
        if (this.adapter == null) {
            return;
        }
        this.numbersOfRows.clear();
        removeAllChildren();
        ListAreaAdapter listAreaAdapter = this.adapter;
        if (listAreaAdapter instanceof ListAreaAdapterWithSection) {
            i3 = ((ListAreaAdapterWithSection) listAreaAdapter).numberOfSections(this);
        } else {
            i3 = 1;
        }
        for (int i16 = 0; i16 < i3; i16++) {
            int numberOfRows = this.adapter.numberOfRows(this, i16);
            this.numbersOfRows.add(Integer.valueOf(numberOfRows));
            for (int i17 = 0; i17 < numberOfRows; i17++) {
                DittoArea area = this.adapter.getArea(this, i16, i17);
                if (area != null) {
                    if (i17 != 0 && this.mItemInterval != 0) {
                        if (getOrientation() == 1) {
                            area.setMargin(0, this.mItemInterval, 0, 0);
                        } else {
                            area.setMargin(this.mItemInterval, 0, 0, 0);
                        }
                    }
                    addChild(area);
                }
            }
        }
        requestLayout();
    }

    public void setAdapter(ListAreaAdapter listAreaAdapter) {
        this.adapter = listAreaAdapter;
        reloadRows();
    }

    public void setItemInterval(int i3) {
        this.mItemInterval = i3;
        reloadRows();
    }
}
