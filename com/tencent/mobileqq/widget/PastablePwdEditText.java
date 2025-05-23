package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import com.tencent.mobileqq.mqsafeedit.libsafeedit;

/* loaded from: classes20.dex */
public class PastablePwdEditText extends ConfigClearableEditText {
    public PastablePwdEditText(Context context) {
        super(context);
    }

    @Override // com.tencent.mobileqq.widget.ConfigClearableEditText
    protected boolean g() {
        return true;
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

    public PastablePwdEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PastablePwdEditText(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        setClearButtonVisible(false);
    }
}
