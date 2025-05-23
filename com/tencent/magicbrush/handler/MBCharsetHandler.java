package com.tencent.magicbrush.handler;

import androidx.annotation.Keep;
import com.tencent.luggage.wxa.p8.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.UnsupportedEncodingException;

/* compiled from: P */
@Keep
/* loaded from: classes9.dex */
public class MBCharsetHandler {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "MicroMsg.MBCharsetHandler";

    public MBCharsetHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Keep
    public static String decode(byte[] bArr, String str) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        try {
            return new String(bArr, str);
        } catch (UnsupportedEncodingException e16) {
            f.b(TAG, "UnsupportedDecoding [%s] [%s]", str, e16);
            return null;
        }
    }

    @Keep
    public static byte[] encode(String str, String str2) {
        if (str == null) {
            return null;
        }
        try {
            return str.getBytes(str2);
        } catch (UnsupportedEncodingException e16) {
            f.b(TAG, "MBCharsetHandler encode failed. [%s]", e16);
            return null;
        }
    }
}
