package com.tencent.mobileqq.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mobileqq.R;

/* loaded from: classes20.dex */
public class PhoneNumClearableEditText extends ConfigClearableEditText {
    public PhoneNumClearableEditText(Context context) {
        super(context);
    }

    @Override // com.tencent.mobileqq.widget.ConfigClearableEditText, android.widget.EditText, android.widget.TextView
    public boolean onTextContextMenuItem(int i3) {
        if (i3 == 16908322) {
            String a16 = com.tencent.mobileqq.utils.v.a(getContext());
            if (a16.length() == 0) {
                QQToast.makeText(getContext(), 1, R.string.f173332sv, 0).show();
            } else {
                setText(a16);
                setSelection(getText().length());
            }
            return true;
        }
        return super.onTextContextMenuItem(i3);
    }

    public PhoneNumClearableEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
