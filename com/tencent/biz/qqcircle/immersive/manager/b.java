package com.tencent.biz.qqcircle.immersive.manager;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: P */
/* loaded from: classes4.dex */
public class b extends LinearLayoutManager {

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a extends LinearSmoothScroller {
        a(Context context) {
            super(context);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
            return 15.0f / displayMetrics.density;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
        @Nullable
        public PointF computeScrollVectorForPosition(int i3) {
            return b.this.computeScrollVectorForPosition(i3);
        }
    }

    public b(Context context, int i3, boolean z16) {
        super(context, i3, z16);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i3) {
        a aVar = new a(recyclerView.getContext());
        aVar.setTargetPosition(i3);
        startSmoothScroll(aVar);
    }
}
