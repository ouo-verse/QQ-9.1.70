package com.tencent.ams.fusion.a;

import java.io.Closeable;

/* compiled from: P */
/* loaded from: classes3.dex */
public class d {
    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th5) {
                f.d("IOUtils", th5);
            }
        }
    }
}
