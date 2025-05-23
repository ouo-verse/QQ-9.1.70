package com.tencent.tinker.bsdiff;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes26.dex */
public class b {
    static IPatchRedirector $redirector_;

    public static byte[] a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream.read(bArr, 0, 8192);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    public static final boolean b(InputStream inputStream, byte[] bArr, int i3, int i16) throws IOException {
        int i17 = 0;
        while (i17 < i16) {
            int read = inputStream.read(bArr, i3 + i17, i16 - i17);
            if (read < 0) {
                return false;
            }
            i17 += read;
        }
        return true;
    }
}
