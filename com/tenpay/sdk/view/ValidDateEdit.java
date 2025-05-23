package com.tenpay.sdk.view;

import android.content.Context;
import android.util.AttributeSet;
import java.util.Calendar;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ValidDateEdit extends TenpayEditText {
    public static final int VALID_FORMAT_ERROR = 1;
    public static final int VALID_OK = 0;
    public static final int VALID_OUT_TIME = 3;
    public static final int VALID_TIME_ERROR = 2;
    private int focus;
    private boolean setted;

    public ValidDateEdit(Context context) {
        super(context);
    }

    public String getData() {
        StringBuilder sb5 = new StringBuilder();
        String obj = getText().toString();
        if (obj.length() > 4) {
            String substring = obj.substring(0, 2);
            sb5.append(obj.substring(3, 5));
            sb5.append(substring);
        }
        return sb5.toString();
    }

    public int isValid(long j3) {
        try {
            String obj = getText().toString();
            if (obj.length() < 5 || obj.indexOf("/") != 2) {
                return 1;
            }
            String substring = obj.substring(0, 2);
            String substring2 = obj.substring(3, 5);
            int parseInt = Integer.parseInt(substring);
            int parseInt2 = Integer.parseInt(substring2);
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(j3);
            int i3 = calendar.get(2) + 1;
            int i16 = calendar.get(1) % 1000;
            if (parseInt > 12) {
                return 2;
            }
            if (parseInt2 >= i16 && (parseInt2 != i16 || parseInt >= i3)) {
                return 0;
            }
            return 3;
        } catch (Exception unused) {
            return 2;
        }
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        int i18;
        int length;
        super.onTextChanged(charSequence, i3, i16, i17);
        try {
            String obj = getText().toString();
            if (i16 > i17 && obj.length() > 1 && obj.indexOf(47) < 0) {
                if (obj.length() > 2) {
                    obj = obj.substring(0, 1) + obj.substring(2);
                } else {
                    obj = obj.substring(0, 1);
                }
                i17--;
            }
            if (!this.setted) {
                this.focus = i3 + i17;
                if (obj.length() > 0) {
                    if (this.focus <= obj.length()) {
                        String substring = obj.substring(0, this.focus);
                        i18 = substring.length() - substring.replaceAll("/", "").length();
                    } else {
                        i18 = 0;
                    }
                    String replaceAll = obj.replaceAll("/", "");
                    StringBuffer stringBuffer = new StringBuffer();
                    if (replaceAll.length() > 1) {
                        stringBuffer.append(replaceAll.substring(0, 2));
                        stringBuffer.append("/");
                        stringBuffer.append(replaceAll.subSequence(2, replaceAll.length()));
                        setSelection(replaceAll.length());
                    } else {
                        stringBuffer.append(replaceAll);
                    }
                    String stringBuffer2 = stringBuffer.toString();
                    if (this.focus <= stringBuffer2.length()) {
                        String substring2 = stringBuffer2.substring(0, this.focus);
                        length = substring2.length() - substring2.replaceAll("/", "").length();
                    } else {
                        length = stringBuffer2.length() - stringBuffer2.replaceAll("/", "").length();
                    }
                    int i19 = (this.focus + length) - i18;
                    this.setted = true;
                    setText(stringBuffer2);
                    if (i19 == 2 && stringBuffer2.length() > 2) {
                        i19 = 3;
                    }
                    if (i19 > 0) {
                        setSelection(i19);
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

    public ValidDateEdit(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
