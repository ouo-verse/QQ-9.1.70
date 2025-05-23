package com.tencent.luggage.wxa.be;

import android.text.TextPaint;
import android.text.style.URLSpan;

/* compiled from: P */
/* loaded from: classes8.dex */
public class j extends URLSpan {
    public j(String str) {
        super(str);
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        textPaint.setUnderlineText(false);
    }
}
