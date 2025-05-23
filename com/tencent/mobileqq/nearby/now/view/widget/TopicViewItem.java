package com.tencent.mobileqq.nearby.now.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/* compiled from: P */
/* loaded from: classes15.dex */
public class TopicViewItem extends TextView {
    public TopicViewItem(Context context) {
        super(context);
        b(context);
    }

    private void b(Context context) {
        int a16 = a(8.0f);
        setPadding(a16, 0, a16, 0);
        setGravity(17);
    }

    public int a(float f16) {
        return (int) ((f16 * getResources().getDisplayMetrics().density) + 0.5f);
    }

    public TopicViewItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context);
    }

    public TopicViewItem(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        b(context);
    }
}
