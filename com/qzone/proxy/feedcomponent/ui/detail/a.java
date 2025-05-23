package com.qzone.proxy.feedcomponent.ui.detail;

import android.content.Context;
import android.widget.BaseAdapter;
import com.qzone.proxy.feedcomponent.ui.g;

/* compiled from: P */
/* loaded from: classes39.dex */
public abstract class a extends BaseAdapter {
    protected Context mContext;
    protected Object mWidgetData;
    protected int mWidgetType;
    protected g onFeedElementClickListener;

    public a(Context context, int i3) {
        this.mContext = context;
        this.mWidgetType = i3;
    }

    public void setOnDetailFeedElementClickListener(g gVar) {
        this.onFeedElementClickListener = gVar;
    }

    public void setWidgetData(Object obj) {
        this.mWidgetData = obj;
    }

    public void setNeedBackground(boolean z16) {
    }
}
