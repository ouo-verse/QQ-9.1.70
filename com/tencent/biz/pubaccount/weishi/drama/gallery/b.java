package com.tencent.biz.pubaccount.weishi.drama.gallery;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.biz.pubaccount.weishi.util.r;

/* compiled from: P */
/* loaded from: classes32.dex */
public class b extends RecyclerView.ItemDecoration {

    /* renamed from: d, reason: collision with root package name */
    public static final int f80699d = r.H(12.0f);

    /* renamed from: e, reason: collision with root package name */
    public static final int f80700e = r.H(4.0f);

    @Override // android.support.v7.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        super.getItemOffsets(rect, view, recyclerView, state);
        int childLayoutPosition = recyclerView.getChildLayoutPosition(view);
        if (childLayoutPosition == 0) {
            rect.left = f80699d;
        }
        if (childLayoutPosition == recyclerView.getAdapter().getItemCount() - 1) {
            rect.right = f80699d;
        } else {
            rect.right = f80700e;
        }
    }
}
