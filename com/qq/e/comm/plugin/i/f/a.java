package com.qq.e.comm.plugin.i.f;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a {
    public static final void a(Closeable closeable) throws IOException {
        if (closeable != null) {
            synchronized (a.class) {
                try {
                    closeable.close();
                } catch (EOFException e16) {
                    e16.printStackTrace();
                }
            }
        }
    }
}
