package org.apache.httpcore;

import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface TokenIterator extends Iterator<Object> {
    @Override // java.util.Iterator
    boolean hasNext();

    String nextToken();
}
