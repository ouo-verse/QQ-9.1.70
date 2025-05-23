package com.qzone.proxy.feedcomponent.ui.detail;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.qzone.proxy.feedcomponent.ui.g;

/* compiled from: P */
/* loaded from: classes39.dex */
public abstract class AbsDetailWidgetView extends LinearLayout {
    protected Object mWidgetData;
    protected int mWidgetType;
    protected g onFeedElementClickListener;

    public AbsDetailWidgetView(Context context) {
        super(context);
        this.mWidgetType = -1;
    }

    public int getWidgetType() {
        return this.mWidgetType;
    }

    public void setOnDetailFeedElementClickListener(g gVar) {
        this.onFeedElementClickListener = gVar;
    }

    public void setWidgetData(Object obj) {
        this.mWidgetData = obj;
    }

    public AbsDetailWidgetView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mWidgetType = -1;
    }

    public AbsDetailWidgetView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.mWidgetType = -1;
    }
}
