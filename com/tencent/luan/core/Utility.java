package com.tencent.luan.core;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.Closeable;

/* compiled from: P */
/* loaded from: classes7.dex */
public class Utility {
    static IPatchRedirector $redirector_;

    public Utility() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void close(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (Throwable unused) {
        }
    }

    public static boolean isEmpty(CharSequence charSequence) {
        if (charSequence != null && charSequence.length() != 0) {
            return false;
        }
        return true;
    }

    public static void makeSureNotNull(Object obj, String str) {
        if (obj != null) {
            return;
        }
        throw new NullPointerException("input param " + str + " cannot be null");
    }
}
