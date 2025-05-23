package com.tencent.commonsdk.soload;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes5.dex */
public class Streams {
    static IPatchRedirector $redirector_;

    Streams() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void readFully(InputStream inputStream, byte[] bArr, int i3, int i16) throws IOException {
        if (i16 == 0) {
            return;
        }
        if (inputStream != null) {
            if (bArr != null) {
                if ((i3 | i16) >= 0 && i3 <= bArr.length && bArr.length - i3 >= i16) {
                    while (i16 > 0) {
                        int read = inputStream.read(bArr, i3, i16);
                        if (read >= 0) {
                            i3 += read;
                            i16 -= read;
                        } else {
                            throw new EOFException();
                        }
                    }
                    return;
                }
                return;
            }
            throw new NullPointerException("dst == null");
        }
        throw new NullPointerException("in == null");
    }

    public static int readSingleByte(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[1];
        if (inputStream.read(bArr, 0, 1) == -1) {
            return -1;
        }
        return bArr[0] & 255;
    }
}
