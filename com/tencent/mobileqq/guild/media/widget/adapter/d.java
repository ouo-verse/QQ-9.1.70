package com.tencent.mobileqq.guild.media.widget.adapter;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: P */
/* loaded from: classes14.dex */
public class d extends RecyclerView.ItemDecoration {
    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int i3 = c.f229815c;
        rect.left = i3;
        rect.right = i3;
        rect.top = c.f229814b;
    }
}
