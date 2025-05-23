package com.tencent.mobileqq.zplan.avatar.fragment;

import android.content.Context;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: P */
/* loaded from: classes35.dex */
public class b extends LinearLayoutManager {

    /* compiled from: P */
    /* loaded from: classes35.dex */
    private static class a extends LinearSmoothScroller {

        /* renamed from: c, reason: collision with root package name */
        private float f331747c;

        a(Context context, float f16) {
            super(context);
            this.f331747c = f16;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
            return super.calculateSpeedPerPixel(displayMetrics) * this.f331747c;
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public int calculateDtToFit(int i3, int i16, int i17, int i18, int i19) {
            return (i17 + ((i18 - i17) / 2)) - (i3 + ((i16 - i3) / 2));
        }
    }

    public b(Context context) {
        super(context);
    }

    public void a(RecyclerView recyclerView, RecyclerView.State state, int i3, float f16) {
        a aVar = new a(recyclerView.getContext(), f16);
        aVar.setTargetPosition(i3);
        startSmoothScroll(aVar);
    }
}
