package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import com.tencent.mobileqq.mqsafeedit.libsafeedit;

/* compiled from: P */
/* loaded from: classes20.dex */
public class CustomSafeEditText extends ConfigClearableEditText {
    public CustomSafeEditText(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.ConfigClearableEditText, android.widget.TextView, android.view.View
    public void onFocusChanged(boolean z16, int i3, Rect rect) {
        super.onFocusChanged(z16, i3, rect);
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        super.onTextChanged(charSequence, i3, i16, i17);
        libsafeedit.getLoginLegal(charSequence.toString());
    }

    public CustomSafeEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CustomSafeEditText(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        setClearButtonVisible(false);
    }
}
