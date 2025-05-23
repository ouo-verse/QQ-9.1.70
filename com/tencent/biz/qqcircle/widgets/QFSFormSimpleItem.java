package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import com.tencent.mobileqq.widget.QFormSimpleItem;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QFSFormSimpleItem extends QFormSimpleItem {
    public QFSFormSimpleItem(Context context) {
        this(context, null);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    }

    public QFSFormSimpleItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
