package com.google.android.material.datepicker;

import android.content.Context;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: P */
/* loaded from: classes2.dex */
class j extends LinearLayoutManager {

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class a extends LinearSmoothScroller {
        a(Context context) {
            super(context);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
            return 100.0f / displayMetrics.densityDpi;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(Context context, int i3, boolean z16) {
        super(context, i3, z16);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i3) {
        a aVar = new a(recyclerView.getContext());
        aVar.setTargetPosition(i3);
        startSmoothScroll(aVar);
    }
}
