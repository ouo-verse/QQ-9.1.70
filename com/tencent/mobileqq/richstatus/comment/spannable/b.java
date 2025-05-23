package com.tencent.mobileqq.richstatus.comment.spannable;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes18.dex */
public abstract class b extends ClickableSpan implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private int f282330d;

    public b(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
        } else {
            this.f282330d = i3;
        }
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) textPaint);
            return;
        }
        super.updateDrawState(textPaint);
        textPaint.setColor(this.f282330d);
        textPaint.setUnderlineText(false);
        textPaint.clearShadowLayer();
    }
}
