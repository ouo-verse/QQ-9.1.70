package com.tencent.mm.msgsubscription.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.commonsdk.util.notification.NotificationUtil;

/* compiled from: P */
/* loaded from: classes9.dex */
public class MaxRecyclerView extends RecyclerView {
    public MaxRecyclerView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onMeasure(int i3, int i16) {
        super.onMeasure(i3, View.MeasureSpec.makeMeasureSpec(NotificationUtil.Constants.NOTIFY_ID_HASH_VALUE_END, Integer.MIN_VALUE));
    }

    public MaxRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MaxRecyclerView(Context context) {
        super(context);
    }
}
