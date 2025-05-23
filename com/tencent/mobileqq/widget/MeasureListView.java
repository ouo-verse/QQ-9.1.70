package com.tencent.mobileqq.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.commonsdk.util.notification.NotificationUtil;
import com.tencent.widget.XListView;

/* compiled from: P */
/* loaded from: classes20.dex */
public class MeasureListView extends XListView {
    public MeasureListView(Context context) {
        super(context);
    }

    @Override // com.tencent.widget.XListView, com.tencent.widget.ListView, com.tencent.widget.AbsListView, android.view.View
    public void onMeasure(int i3, int i16) {
        super.onMeasure(i3, View.MeasureSpec.makeMeasureSpec(NotificationUtil.Constants.NOTIFY_ID_HASH_VALUE_END, Integer.MIN_VALUE));
        getLayoutParams().height = getMeasuredHeight();
    }

    public MeasureListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
