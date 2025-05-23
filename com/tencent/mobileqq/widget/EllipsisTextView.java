package com.tencent.mobileqq.widget;

import android.content.Context;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;

/* compiled from: P */
/* loaded from: classes20.dex */
public class EllipsisTextView extends TextView {
    public EllipsisTextView(Context context) {
        super(context);
        a();
    }

    private void a() {
        setMaxLines(1);
        setEllipsize(TextUtils.TruncateAt.END);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        Layout layout = getLayout();
        if (layout.getEllipsisCount(0) > 0) {
            int lineRight = (int) (layout.getLineRight(0) + 0.5f);
            setMeasuredDimension(getCompoundPaddingLeft() + lineRight + getCompoundPaddingRight(), getMeasuredHeight());
        }
    }

    public EllipsisTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public EllipsisTextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        a();
    }
}
