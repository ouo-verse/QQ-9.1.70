package com.tencent.now.od.ui.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: P */
/* loaded from: classes22.dex */
public class SlowRecyclerView extends RecyclerView {
    public SlowRecyclerView(Context context) {
        super(context);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public boolean fling(int i3, int i16) {
        return super.fling((int) (i3 * 0.5f), (int) (i16 * 0.5f));
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return true;
    }

    public SlowRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SlowRecyclerView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
