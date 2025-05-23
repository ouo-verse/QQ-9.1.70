package org.apache.commons.lang;

import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes29.dex */
public class IncompleteArgumentException extends IllegalArgumentException {
    private static final long serialVersionUID = 4954193403612068178L;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public IncompleteArgumentException(String str) {
        super(r0.toString());
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append(" is incomplete.");
    }

    private static final String safeArrayToString(Object[] objArr) {
        if (objArr == null) {
            return null;
        }
        return Arrays.asList(objArr).toString();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public IncompleteArgumentException(String str, String[] strArr) {
        super(r0.toString());
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append(" is missing the following items: ");
        stringBuffer.append(safeArrayToString(strArr));
    }
}
