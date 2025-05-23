package org.apache.httpcore.message;

import java.util.NoSuchElementException;
import org.apache.httpcore.Header;
import org.apache.httpcore.HeaderIterator;
import org.apache.httpcore.util.Args;

/* compiled from: P */
/* loaded from: classes29.dex */
public class BasicHeaderIterator implements HeaderIterator {
    protected final Header[] allHeaders;
    protected int currentIndex = findNext(-1);
    protected String headerName;

    public BasicHeaderIterator(Header[] headerArr, String str) {
        this.allHeaders = (Header[]) Args.notNull(headerArr, "Header array");
        this.headerName = str;
    }

    protected boolean filterHeader(int i3) {
        String str = this.headerName;
        if (str != null && !str.equalsIgnoreCase(this.allHeaders[i3].getName())) {
            return false;
        }
        return true;
    }

    protected int findNext(int i3) {
        if (i3 < -1) {
            return -1;
        }
        int length = this.allHeaders.length - 1;
        boolean z16 = false;
        while (!z16 && i3 < length) {
            i3++;
            z16 = filterHeader(i3);
        }
        if (!z16) {
            return -1;
        }
        return i3;
    }

    @Override // org.apache.httpcore.HeaderIterator, java.util.Iterator
    public boolean hasNext() {
        if (this.currentIndex >= 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() throws NoSuchElementException {
        return nextHeader();
    }

    @Override // org.apache.httpcore.HeaderIterator
    public Header nextHeader() throws NoSuchElementException {
        int i3 = this.currentIndex;
        if (i3 >= 0) {
            this.currentIndex = findNext(i3);
            return this.allHeaders[i3];
        }
        throw new NoSuchElementException("Iteration already finished.");
    }

    @Override // java.util.Iterator
    public void remove() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Removing headers is not supported.");
    }
}
