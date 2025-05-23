package org.apache.httpcore.pool;

import java.io.IOException;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface ConnFactory<T, C> {
    C create(T t16) throws IOException;
}
