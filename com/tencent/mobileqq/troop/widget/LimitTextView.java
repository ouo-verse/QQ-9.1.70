package com.tencent.mobileqq.troop.widget;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes19.dex */
public class LimitTextView extends AnimationTextView {
    static IPatchRedirector $redirector_;
    private boolean V;
    private CharSequence W;

    public LimitTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
        } else {
            this.V = true;
            this.W = null;
        }
    }

    @Override // android.widget.TextView
    @TargetApi(16)
    public int getMaxLines() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return super.getMaxLines();
    }

    @Override // android.widget.TextView, android.view.View
    @SuppressLint({"NewApi"})
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        super.onLayout(z16, i3, i16, i17, i18);
        int maxLines = getMaxLines();
        if (maxLines > 0 && super.getLineCount() > maxLines) {
            int lineVisibleEnd = super.getLayout().getLineVisibleEnd(maxLines - 1);
            CharSequence text = getText();
            this.W = text;
            String charSequence = text.toString();
            int i19 = lineVisibleEnd - 2;
            int codePointAt = charSequence.codePointAt(i19);
            int i26 = lineVisibleEnd - 1;
            int codePointAt2 = charSequence.codePointAt(i26);
            if ((codePointAt == 20 && codePointAt2 >= 0 && codePointAt2 < EmotcationConstants.VALID_SYS_EMOTCATION_COUNT) || codePointAt > 65535) {
                str = ((Object) this.W.subSequence(0, i19)) + "\u2026";
                if (QLog.isColorLevel()) {
                    QLog.e(QQText.TAG, 2, "\u622a\u53d6\u7684\u662f\u7cfb\u7edf\u8868\u60c5\u6216\u8005emoji\u8868\u60c5------------");
                }
            } else {
                str = ((Object) this.W.subSequence(0, i26)) + "\u2026";
                if (QLog.isColorLevel()) {
                    QLog.e(QQText.TAG, 2, "\u622a\u53d6\u6b63\u5e38\u6587\u672c------------");
                }
            }
            setText(str);
        }
    }

    @Override // com.tencent.mobileqq.widget.AnimationTextView, com.tencent.mobileqq.widget.PatchedTextView, android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) charSequence, (Object) bufferType);
        } else {
            super.setText(new QQText(charSequence, 45, 32, 1), TextView.BufferType.SPANNABLE);
        }
    }

    public LimitTextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3));
        } else {
            this.V = true;
            this.W = null;
        }
    }
}
