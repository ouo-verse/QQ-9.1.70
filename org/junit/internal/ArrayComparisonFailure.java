package org.junit.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ArrayComparisonFailure extends AssertionError {
    private static final long serialVersionUID = 1;
    private final List<Integer> fIndices = new ArrayList();
    private final String fMessage;

    public ArrayComparisonFailure(String str, AssertionError assertionError, int i3) {
        this.fMessage = str;
        initCause(assertionError);
        addDimension(i3);
    }

    public void addDimension(int i3) {
        this.fIndices.add(0, Integer.valueOf(i3));
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        StringBuilder sb5 = new StringBuilder();
        String str = this.fMessage;
        if (str != null) {
            sb5.append(str);
        }
        sb5.append("arrays first differed at element ");
        Iterator<Integer> it = this.fIndices.iterator();
        while (it.hasNext()) {
            int intValue = it.next().intValue();
            sb5.append("[");
            sb5.append(intValue);
            sb5.append("]");
        }
        sb5.append("; ");
        sb5.append(getCause().getMessage());
        return sb5.toString();
    }

    @Override // java.lang.Throwable
    public String toString() {
        return getMessage();
    }
}
