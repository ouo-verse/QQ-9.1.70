package com.eclipsesource.v8;

import java.io.Closeable;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface Releasable extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    void release();
}
