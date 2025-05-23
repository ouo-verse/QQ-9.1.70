package com.tencent.android.androidbypass.span;

import android.text.TextPaint;
import android.text.style.ForegroundColorSpan;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class BypassForegroundColorSpan extends ForegroundColorSpan {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private com.tencent.android.androidbypass.enhance.e f72430d;

    public BypassForegroundColorSpan(@NonNull com.tencent.android.androidbypass.enhance.e eVar) {
        super(eVar.a());
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) eVar);
        } else {
            this.f72430d = eVar;
        }
    }

    @Override // android.text.style.ForegroundColorSpan
    public int getForegroundColor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        com.tencent.android.androidbypass.enhance.e eVar = this.f72430d;
        if (eVar != null) {
            return eVar.a();
        }
        return super.getForegroundColor();
    }

    @Override // android.text.style.ForegroundColorSpan, android.text.style.CharacterStyle
    public void updateDrawState(@NonNull TextPaint textPaint) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) textPaint);
            return;
        }
        com.tencent.android.androidbypass.enhance.e eVar = this.f72430d;
        if (eVar != null) {
            textPaint.setColor(eVar.a());
        } else {
            super.updateDrawState(textPaint);
        }
    }
}
