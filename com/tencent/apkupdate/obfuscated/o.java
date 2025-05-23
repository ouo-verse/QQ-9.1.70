package com.tencent.apkupdate.obfuscated;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class o {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public Context f72564a;

    public o(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.f72564a = context;
        }
    }

    public final StringBuffer a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (StringBuffer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (TextUtils.isEmpty(str)) {
            stringBuffer.append("NA");
            return stringBuffer;
        }
        for (char c16 : str.toCharArray()) {
            if (c16 > ' ' && c16 != '/' && c16 != '_' && c16 != '&' && c16 != '|' && c16 != '-') {
                stringBuffer.append(c16);
            }
        }
        return stringBuffer;
    }
}
