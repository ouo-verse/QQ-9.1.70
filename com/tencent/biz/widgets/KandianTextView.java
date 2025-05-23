package com.tencent.biz.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/* compiled from: P */
/* loaded from: classes5.dex */
public class KandianTextView extends TextView {

    /* renamed from: d, reason: collision with root package name */
    private boolean f97702d;

    public KandianTextView(Context context) {
        super(context);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        int i19;
        boolean z17;
        super.onLayout(z16, i3, i16, i17, i18);
        if (this.f97702d) {
            return;
        }
        if (super.getLineCount() == 2) {
            int lineVisibleEnd = super.getLayout().getLineVisibleEnd(0);
            int lineVisibleEnd2 = super.getLayout().getLineVisibleEnd(1);
            int i26 = lineVisibleEnd - 1;
            if (i26 >= 0 && ((i19 = lineVisibleEnd2 - lineVisibleEnd) == 1 || i19 == 2)) {
                String charSequence = super.getText().toString();
                if (i19 != 2 ? !(charSequence.charAt(i26) < '\u4e00' || charSequence.charAt(i26) > '\u9fa5') : !(charSequence.charAt(i26) < '\u4e00' || charSequence.charAt(i26) > '\u9fa5')) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    super.setText(charSequence.substring(0, i26) + "\n" + charSequence.substring(i26, lineVisibleEnd2));
                }
            }
        }
        this.f97702d = true;
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        this.f97702d = false;
        super.setText(charSequence, bufferType);
    }

    public KandianTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public KandianTextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
