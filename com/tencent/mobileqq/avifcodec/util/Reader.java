package com.tencent.mobileqq.avifcodec.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes11.dex */
public interface Reader {

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static final class EndOfFileException extends IOException {
        static IPatchRedirector $redirector_ = null;
        private static final long serialVersionUID = 1;

        /* JADX INFO: Access modifiers changed from: package-private */
        public EndOfFileException() {
            super("Unexpectedly reached end of a file");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    int getInt32BE() throws IOException;

    int read(byte[] bArr, int i3) throws IOException;
}
