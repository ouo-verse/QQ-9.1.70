package com.qzone.homepage.ui.component.newpanel;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.commonsdk.util.notification.NotificationUtil;

/* compiled from: P */
/* loaded from: classes39.dex */
public class SafeListViewEx extends ListView {
    public SafeListViewEx(Context context) {
        super(context);
    }

    @Override // android.widget.ListView, android.widget.AbsListView
    protected void layoutChildren() {
        try {
            super.layoutChildren();
        } catch (Exception e16) {
            RFWLog.fatal(getClass().getSimpleName(), 1, e16);
        }
    }

    public SafeListViewEx(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SafeListViewEx(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, View.MeasureSpec.makeMeasureSpec(NotificationUtil.Constants.NOTIFY_ID_HASH_VALUE_END, Integer.MIN_VALUE));
    }
}
