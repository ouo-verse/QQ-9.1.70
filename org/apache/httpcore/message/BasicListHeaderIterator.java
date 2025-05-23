package org.apache.httpcore.message;

import java.util.List;
import java.util.NoSuchElementException;
import org.apache.httpcore.Header;
import org.apache.httpcore.HeaderIterator;
import org.apache.httpcore.util.Args;
import org.apache.httpcore.util.Asserts;

/* compiled from: P */
/* loaded from: classes29.dex */
public class BasicListHeaderIterator implements HeaderIterator {
    protected final List<Header> allHeaders;
    protected String headerName;
    protected int currentIndex = findNext(-1);
    protected int lastIndex = -1;

    public BasicListHeaderIterator(List<Header> list, String str) {
        this.allHeaders = (List) Args.notNull(list, "Header list");
        this.headerName = str;
    }

    protected boolean filterHeader(int i3) {
        if (this.headerName == null) {
            return true;
        }
        return this.headerName.equalsIgnoreCase(this.allHeaders.get(i3).getName());
    }

    protected int findNext(int i3) {
        if (i3 < -1) {
            return -1;
        }
        int size = this.allHeaders.size() - 1;
        boolean z16 = false;
        while (!z16 && i3 < size) {
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
            this.lastIndex = i3;
            this.currentIndex = findNext(i3);
            return this.allHeaders.get(i3);
        }
        throw new NoSuchElementException("Iteration already finished.");
    }

    @Override // java.util.Iterator
    public void remove() throws UnsupportedOperationException {
        boolean z16;
        if (this.lastIndex >= 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        Asserts.check(z16, "No header to remove");
        this.allHeaders.remove(this.lastIndex);
        this.lastIndex = -1;
        this.currentIndex--;
    }
}
