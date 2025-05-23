package com.tencent.biz.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;
import com.tencent.commonsdk.util.notification.NotificationUtil;

/* compiled from: P */
/* loaded from: classes5.dex */
public class GridViewForScrollView extends GridView {
    public GridViewForScrollView(Context context) {
        super(context);
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, View.MeasureSpec.makeMeasureSpec(NotificationUtil.Constants.NOTIFY_ID_HASH_VALUE_END, Integer.MIN_VALUE));
    }

    public GridViewForScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public GridViewForScrollView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
