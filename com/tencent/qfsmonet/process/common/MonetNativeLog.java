package com.tencent.qfsmonet.process.common;

import androidx.annotation.Keep;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qfsmonet.utils.a;

/* compiled from: P */
@Keep
/* loaded from: classes22.dex */
public class MonetNativeLog {
    static IPatchRedirector $redirector_ = null;
    private static final String CHAR_SET_NAME = "UTF-8";
    private static final String DEFAULT_TAG = "Monet";

    public MonetNativeLog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Keep
    public static void onPrintLog(int i3, byte[] bArr, int i16, byte[] bArr2, int i17) {
        try {
            a.e(i3, new String(bArr, 0, i16, "UTF-8"), new String(bArr2, 0, i17, "UTF-8"));
        } catch (OutOfMemoryError e16) {
            a.b(DEFAULT_TAG, e16.toString());
        } catch (Throwable th5) {
            a.b(DEFAULT_TAG, th5.toString());
        }
    }
}
