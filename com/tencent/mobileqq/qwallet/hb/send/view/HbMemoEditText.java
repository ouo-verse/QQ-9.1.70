package com.tencent.mobileqq.qwallet.hb.send.view;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import com.tencent.mobileqq.widget.ClearableEditText;

/* compiled from: P */
/* loaded from: classes16.dex */
public class HbMemoEditText extends ClearableEditText implements TextWatcher {
    public HbMemoEditText(Context context) {
        super(context);
        f();
    }

    private void f() {
        setCanMultiLine(true);
        addTextChangedListener(this);
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        boolean z16;
        if (isFocused() && getText().length() != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        setClearButtonVisible(z16);
    }

    public HbMemoEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        f();
    }

    public HbMemoEditText(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        f();
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
    }

    @Override // android.widget.TextView, android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
    }
}
