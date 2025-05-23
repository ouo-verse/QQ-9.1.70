package com.tencent.biz.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.commonsdk.util.notification.NotificationUtil;
import com.tencent.widget.ListView;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ListViewForListview extends ListView {
    public ListViewForListview(Context context) {
        super(context);
    }

    @Override // com.tencent.widget.ListView, com.tencent.widget.AbsListView, android.view.View
    public void onMeasure(int i3, int i16) {
        super.onMeasure(i3, View.MeasureSpec.makeMeasureSpec(NotificationUtil.Constants.NOTIFY_ID_HASH_VALUE_END, Integer.MIN_VALUE));
    }

    public ListViewForListview(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
