package com.tencent.biz.pubaccount.weishi.follow.joingroup;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.utils.ViewUtils;

/* compiled from: P */
/* loaded from: classes32.dex */
public class MaxHeightRecyclerView extends RecyclerView {

    /* renamed from: d, reason: collision with root package name */
    private static final int f80728d = ViewUtils.dpToPx(300.0f);

    public MaxHeightRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.widget.RecyclerView, android.view.View
    public void onMeasure(int i3, int i16) {
        super.onMeasure(i3, View.MeasureSpec.makeMeasureSpec(f80728d, Integer.MIN_VALUE));
    }

    public MaxHeightRecyclerView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
