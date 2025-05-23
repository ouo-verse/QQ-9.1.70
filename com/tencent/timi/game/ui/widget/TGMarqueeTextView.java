package com.tencent.timi.game.ui.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TGMarqueeTextView extends AppCompatTextView {
    public TGMarqueeTextView(Context context) {
        this(context, null);
    }

    private void e() {
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

    public TGMarqueeTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TGMarqueeTextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        e();
    }
}
