package com.tencent.component.network.utils.http.pool;

import java.io.IOException;

/* compiled from: P */
/* loaded from: classes5.dex */
public interface ConnFactory<T, C> {
    C create(T t16) throws IOException;
}
