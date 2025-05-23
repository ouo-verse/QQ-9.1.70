package com.tencent.luggage.wxa.j;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class e {
    public static InputStream a(InputStream inputStream) {
        InputStream bufferedInputStream;
        if (!inputStream.markSupported()) {
            if (inputStream instanceof FileInputStream) {
                bufferedInputStream = new c((FileInputStream) inputStream);
            } else {
                bufferedInputStream = new BufferedInputStream(inputStream);
            }
            return bufferedInputStream;
        }
        return inputStream;
    }

    public static void b(InputStream inputStream) {
        inputStream.mark(8388608);
    }
}
