package com.tencent.open.agent.util;

import java.io.Closeable;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes22.dex */
public class h {
    public static void a(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException e16) {
            t.d("CloseableUtil", "IOException", e16);
        }
    }
}
