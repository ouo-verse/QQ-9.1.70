package org.apache.httpcore;

import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface HeaderElementIterator extends Iterator<Object> {
    @Override // java.util.Iterator
    boolean hasNext();

    HeaderElement nextElement();
}
