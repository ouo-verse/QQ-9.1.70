package nz;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a extends LinearLayoutManager {

    /* renamed from: a, reason: collision with root package name */
    int f421601a;

    /* compiled from: P */
    /* renamed from: nz.a$a, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    private static class C10873a extends LinearSmoothScroller {

        /* renamed from: a, reason: collision with root package name */
        int f421602a;

        C10873a(Context context, int i3) {
            super(context);
            this.f421602a = i3;
        }

        @Override // android.support.v7.widget.LinearSmoothScroller
        protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
            return 100.0f / displayMetrics.densityDpi;
        }

        @Override // android.support.v7.widget.LinearSmoothScroller
        public PointF computeScrollVectorForPosition(int i3) {
            return null;
        }

        @Override // android.support.v7.widget.LinearSmoothScroller
        public int calculateDtToFit(int i3, int i16, int i17, int i18, int i19) {
            return ((i17 + ((i18 - i17) / 2)) - (i3 + ((i16 - i3) / 2))) + (this.f421602a / 2);
        }
    }

    public a(Context context, int i3) {
        super(context);
        this.f421601a = i3;
    }

    @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i3) {
        C10873a c10873a = new C10873a(recyclerView.getContext(), this.f421601a);
        c10873a.setTargetPosition(i3);
        startSmoothScroll(c10873a);
    }
}
