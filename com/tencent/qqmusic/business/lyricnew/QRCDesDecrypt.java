package com.tencent.qqmusic.business.lyricnew;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes23.dex */
public class QRCDesDecrypt implements Serializable {
    static IPatchRedirector $redirector_ = null;
    private static final QRCDesDecrypt INSTANCE;
    private static final String TAG = "QRCDesDecrypt";
    private static boolean sIsLoaded;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13686);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        sIsLoaded = false;
        try {
            System.loadLibrary("desdecrypt");
            sIsLoaded = true;
        } catch (Throwable unused) {
            sIsLoaded = false;
        }
        INSTANCE = new QRCDesDecrypt();
    }

    public QRCDesDecrypt() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private native int desDecrypt(byte[] bArr, int i3);

    public static synchronized QRCDesDecrypt get() {
        QRCDesDecrypt qRCDesDecrypt;
        synchronized (QRCDesDecrypt.class) {
            qRCDesDecrypt = INSTANCE;
        }
        return qRCDesDecrypt;
    }

    public final int decrypt(byte[] bArr, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bArr, i3)).intValue();
        }
        if (!sIsLoaded) {
            return -1;
        }
        return desDecrypt(bArr, i3);
    }
}
