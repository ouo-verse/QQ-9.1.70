package com.tencent.android.androidbypass;

import android.text.SpannableStringBuilder;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class g extends SpannableStringBuilder {
    static IPatchRedirector $redirector_;

    public g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static void a(Object[] objArr) {
        if (objArr == null) {
            return;
        }
        int length = objArr.length - 1;
        for (int i3 = 0; length > i3; i3++) {
            Object obj = objArr[length];
            objArr[length] = objArr[i3];
            objArr[i3] = obj;
            length--;
        }
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public <T> T[] getSpans(int i3, int i16, Class<T> cls) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (T[]) ((Object[]) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), cls));
        }
        T[] tArr = (T[]) super.getSpans(i3, i16, cls);
        a(tArr);
        return tArr;
    }
}
