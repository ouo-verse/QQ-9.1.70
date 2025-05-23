package com.tencent.widget;

import android.text.SpannableString;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public abstract class SpanAdapter {
    static IPatchRedirector $redirector_ = null;
    protected static final String TAG = "spanStyle";
    public String apendString;
    public int end;
    public int start;

    public SpanAdapter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public abstract void getSpan(SpannableString spannableString);
}
