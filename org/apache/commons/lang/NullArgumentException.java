package org.apache.commons.lang;

/* compiled from: P */
/* loaded from: classes29.dex */
public class NullArgumentException extends IllegalArgumentException {
    private static final long serialVersionUID = 1174360235354917591L;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public NullArgumentException(String str) {
        super(r0.toString());
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str == null ? "Argument" : str);
        stringBuffer.append(" must not be null.");
    }
}
