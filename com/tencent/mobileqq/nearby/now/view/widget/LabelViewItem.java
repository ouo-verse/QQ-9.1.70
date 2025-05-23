package com.tencent.mobileqq.nearby.now.view.widget;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.mobileqq.nearby.now.IResourceUtil;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes15.dex */
public class LabelViewItem extends TextView {
    public LabelViewItem(Context context) {
        super(context);
        b(context);
    }

    private void b(Context context) {
        setBackgroundResource(((IResourceUtil) QRoute.api(IResourceUtil.class)).getQQNearbyTopicLabelBkg());
        setTextSize(2, 11.0f);
        setTextColor(Color.parseColor("#ffaf4efb"));
        int a16 = a(8.0f);
        int a17 = a(3.0f);
        setPadding(a16, a17, a16, a17);
        setGravity(17);
    }

    public int a(float f16) {
        return (int) ((f16 * getResources().getDisplayMetrics().density) + 0.5f);
    }

    public LabelViewItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context);
    }

    public LabelViewItem(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        b(context);
    }
}
