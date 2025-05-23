package com.tencent.mobileqq.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/* compiled from: P */
/* loaded from: classes20.dex */
public class MonitorSizeChangeRelativeLayout extends RelativeLayout {

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface a {
    }

    public MonitorSizeChangeRelativeLayout(Context context) {
        super(context);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
    }

    public MonitorSizeChangeRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setCallBack(a aVar) {
    }
}
