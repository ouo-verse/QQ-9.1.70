package com.tencent.biz.richframework.part.block.base;

import android.content.Context;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.part.utils.LayoutManagerUtils;

/* compiled from: P */
/* loaded from: classes5.dex */
public class SafeGridLayoutManager extends GridLayoutManager {
    public SafeGridLayoutManager(Context context, int i3) {
        super(context, i3);
    }

    @Override // androidx.recyclerview.widget.GridLayoutManager, androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
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

    @Override // androidx.recyclerview.widget.GridLayoutManager, androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i3, RecyclerView.Recycler recycler, RecyclerView.State state) {
        try {
            return super.scrollVerticallyBy(i3, recycler, state);
        } catch (Exception e16) {
            if (!LayoutManagerUtils.needThrowException(e16)) {
                return 0;
            }
            throw e16;
        }
    }

    public SafeGridLayoutManager(Context context, int i3, int i16, boolean z16) {
        super(context, i3, i16, z16);
    }
}
