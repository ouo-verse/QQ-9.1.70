package com.tencent.biz.pubaccount.weishi.verticalvideo.choicepanel;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.LinearSmoothScroller;
import android.util.DisplayMetrics;

/* compiled from: P */
/* loaded from: classes32.dex */
public class d extends LinearSmoothScroller {
    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Context context) {
        super(context);
    }

    @Override // android.support.v7.widget.LinearSmoothScroller
    public int calculateDtToFit(int i3, int i16, int i17, int i18, int i19) {
        return (i17 - i3) + (i16 - i3);
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
    protected int getVerticalSnapPreference() {
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.widget.LinearSmoothScroller, android.support.v7.widget.RecyclerView.SmoothScroller
    public void onStop() {
        super.onStop();
    }
}
