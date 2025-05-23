package com.tencent.luggage.wxa.y8;

import com.tencent.luggage.wxa.tn.w;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class a {
    public static long a(InputStream inputStream, OutputStream outputStream) {
        if (inputStream != null && outputStream != null) {
            try {
                byte[] bArr = new byte[4096];
                long j3 = 0;
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        return j3;
                    }
                    outputStream.write(bArr, 0, read);
                    j3 += read;
                }
            } catch (Exception e16) {
                w.h("MicroMsg.FileOperation", "copyStream error: %s", e16.getMessage());
            }
        }
        return 0L;
    }
}
