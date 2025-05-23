package com.tencent.open.agent;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;
import com.tencent.commonsdk.util.notification.NotificationUtil;

/* compiled from: P */
/* loaded from: classes22.dex */
public class FitHeightListView extends ListView {
    public FitHeightListView(Context context) {
        super(context);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, View.MeasureSpec.makeMeasureSpec(NotificationUtil.Constants.NOTIFY_ID_HASH_VALUE_END, Integer.MIN_VALUE));
    }

    public FitHeightListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FitHeightListView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
