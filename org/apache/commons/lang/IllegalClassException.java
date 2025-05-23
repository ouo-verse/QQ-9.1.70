package org.apache.commons.lang;

/* compiled from: P */
/* loaded from: classes29.dex */
public class IllegalClassException extends IllegalArgumentException {
    private static final long serialVersionUID = 8063272569377254819L;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public IllegalClassException(Class cls, Object obj) {
        super(r0.toString());
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Expected: ");
        stringBuffer.append(safeGetClassName(cls));
        stringBuffer.append(", actual: ");
        stringBuffer.append(obj == null ? "null" : obj.getClass().getName());
    }

    private static final String safeGetClassName(Class cls) {
        if (cls == null) {
            return null;
        }
        return cls.getName();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public IllegalClassException(Class cls, Class cls2) {
        super(r0.toString());
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Expected: ");
        stringBuffer.append(safeGetClassName(cls));
        stringBuffer.append(", actual: ");
        stringBuffer.append(safeGetClassName(cls2));
    }

    public IllegalClassException(String str) {
        super(str);
    }
}
