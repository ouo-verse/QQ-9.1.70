package com.tencent.mobileqq.activity.activateFriend;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ScaleXSpan;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes9.dex */
public class LetterSpacingTextView extends TextView {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private float f177854d;

    /* renamed from: e, reason: collision with root package name */
    private CharSequence f177855e;

    public LetterSpacingTextView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.f177854d = 0.0f;
            this.f177855e = "";
        }
    }

    private void a() {
        if (this.f177855e == null) {
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        int i3 = 0;
        while (i3 < this.f177855e.length()) {
            sb5.append(this.f177855e.charAt(i3));
            i3++;
            if (i3 < this.f177855e.length()) {
                sb5.append("\u00a0");
            }
        }
        SpannableString spannableString = new SpannableString(sb5.toString());
        if (sb5.toString().length() > 1) {
            for (int i16 = 1; i16 < sb5.toString().length(); i16 += 2) {
                spannableString.setSpan(new ScaleXSpan(this.f177854d), i16, i16 + 1, 33);
            }
        }
        super.setText(spannableString, TextView.BufferType.SPANNABLE);
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (CharSequence) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.f177855e;
    }

    public void setSpacing(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Float.valueOf(f16));
        } else {
            this.f177854d = f16;
            a();
        }
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) charSequence, (Object) bufferType);
        } else {
            this.f177855e = charSequence;
            a();
        }
    }

    public LetterSpacingTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f177854d = 0.0f;
        this.f177855e = "";
        b(context, attributeSet);
    }

    public LetterSpacingTextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f177854d = 0.0f;
        this.f177855e = "";
        b(context, attributeSet);
    }

    private void b(Context context, AttributeSet attributeSet) {
    }
}
