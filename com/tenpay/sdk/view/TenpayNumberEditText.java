package com.tenpay.sdk.view;

import android.content.Context;
import android.util.AttributeSet;

/* compiled from: P */
/* loaded from: classes27.dex */
public class TenpayNumberEditText extends ClearableEditText {
    public int changeStart;
    private int focus;
    private boolean setted;

    public TenpayNumberEditText(Context context) {
        super(context);
    }

    public String getData() {
        return getText().toString().replaceAll(" ", "");
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        int i18;
        int length;
        super.onTextChanged(charSequence, i3, i16, i17);
        try {
            String obj = getText().toString();
            if (getGravity() == 5) {
                if (obj.length() > 0) {
                    setGravity(5);
                } else {
                    setGravity(3);
                }
            }
            if (!this.setted) {
                this.changeStart = i3;
                this.focus = i3 + i17;
                if (obj.length() > 0) {
                    if (this.focus <= obj.length()) {
                        String substring = obj.substring(0, this.focus);
                        i18 = substring.length() - substring.replaceAll(" ", "").length();
                    } else {
                        i18 = 0;
                    }
                    String replaceAll = obj.replaceAll(" ", "");
                    StringBuffer stringBuffer = new StringBuffer();
                    int i19 = 0;
                    while (true) {
                        int i26 = i19 + 4;
                        if (i26 >= replaceAll.length()) {
                            break;
                        }
                        stringBuffer.append(replaceAll.substring(i19, i26));
                        stringBuffer.append(" ");
                        i19 = i26;
                    }
                    stringBuffer.append(replaceAll.substring(i19));
                    String stringBuffer2 = stringBuffer.toString();
                    if (!stringBuffer2.equals(obj)) {
                        this.setted = true;
                        setText(stringBuffer2);
                        if (this.focus <= stringBuffer2.length()) {
                            String substring2 = stringBuffer2.substring(0, this.focus);
                            length = substring2.length() - substring2.replaceAll(" ", "").length();
                        } else {
                            length = stringBuffer2.length() - stringBuffer2.replaceAll(" ", "").length();
                        }
                        setSelection((this.focus + length) - i18);
                        return;
                    }
                    return;
                }
                return;
            }
            this.setted = false;
        } catch (Exception unused) {
        }
    }

    public TenpayNumberEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TenpayNumberEditText(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
