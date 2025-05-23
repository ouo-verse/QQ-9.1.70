package com.tencent.biz.richframework.part.block.base;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.tencent.biz.richframework.part.utils.LayoutManagerUtils;

/* compiled from: P */
/* loaded from: classes5.dex */
public class SafeStaggeredGridLayoutManager extends StaggeredGridLayoutManager {
    public SafeStaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
    }

    @Override // androidx.recyclerview.widget.StaggeredGridLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        try {
            super.onLayoutChildren(recycler, state);
        } catch (Exception e16) {
            if (!LayoutManagerUtils.needThrowException(e16)) {
            } else {
                throw e16;
            }
        }
    }

    @Override // androidx.recyclerview.widget.StaggeredGridLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i3, RecyclerView.Recycler recycler, RecyclerView.State state) {
        try {
            return super.scrollVerticallyBy(i3, recycler, state);
        } catch (IndexOutOfBoundsException e16) {
            if (!LayoutManagerUtils.needThrowException(e16)) {
                return 0;
            }
            throw e16;
        }
    }

    public SafeStaggeredGridLayoutManager(int i3, int i16) {
        super(i3, i16);
    }
}
