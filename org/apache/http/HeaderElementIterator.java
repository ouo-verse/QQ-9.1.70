package org.apache.http;

import java.util.Iterator;

/* compiled from: P */
@Deprecated
/* loaded from: classes29.dex */
public interface HeaderElementIterator extends Iterator {
    @Override // java.util.Iterator
    boolean hasNext();

    HeaderElement nextElement();
}
