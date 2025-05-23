package com.tencent.mobileqq.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;

/* compiled from: P */
/* loaded from: classes20.dex */
public class MarqueeText extends TextView {
    public MarqueeText(Context context) {
        this(context, null);
    }

    private void a() {
        setMarqueeRepeatLimit(-1);
        setSingleLine();
        setEllipsize(TextUtils.TruncateAt.MARQUEE);
        setFocusable(false);
        setSelected(true);
        setHorizontallyScrolling(true);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        setSelected(true);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setSelected(false);
    }

    public MarqueeText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MarqueeText(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        a();
    }
}
