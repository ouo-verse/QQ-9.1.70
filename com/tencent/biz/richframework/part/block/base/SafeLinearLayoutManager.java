package com.tencent.biz.richframework.part.block.base;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.part.utils.LayoutManagerUtils;

/* compiled from: P */
/* loaded from: classes5.dex */
public class SafeLinearLayoutManager extends LinearLayoutManager {
    private static final String TAG = "SafeLinearLayoutManager";

    public SafeLinearLayoutManager(Context context) {
        super(context);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
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

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i3, RecyclerView.Recycler recycler, RecyclerView.State state) {
        try {
            return super.scrollHorizontallyBy(i3, recycler, state);
        } catch (Exception e16) {
            if (!LayoutManagerUtils.needThrowException(e16)) {
                return 0;
            }
            throw e16;
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
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

    public SafeLinearLayoutManager(Context context, int i3, boolean z16) {
        super(context, i3, z16);
    }

    public SafeLinearLayoutManager(Context context, AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
    }
}
