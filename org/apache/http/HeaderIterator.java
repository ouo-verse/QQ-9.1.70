package org.apache.http;

import java.util.Iterator;

/* compiled from: P */
@Deprecated
/* loaded from: classes29.dex */
public interface HeaderIterator extends Iterator {
    @Override // java.util.Iterator
    boolean hasNext();

    Header nextHeader();
}
