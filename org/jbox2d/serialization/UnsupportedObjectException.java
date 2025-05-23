package org.jbox2d.serialization;

/* compiled from: P */
/* loaded from: classes29.dex */
public class UnsupportedObjectException extends RuntimeException {
    private static final long serialVersionUID = 5915827472093183385L;
    public Type type;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public enum Type {
        BODY,
        JOINT,
        SHAPE,
        OTHER
    }

    public UnsupportedObjectException() {
    }

    @Override // java.lang.Throwable
    public String getLocalizedMessage() {
        return getMessage() + " [" + this.type + "]";
    }

    public UnsupportedObjectException(String str, Type type) {
        super(str);
        this.type = type;
    }

    public UnsupportedObjectException(Throwable th5) {
        super(th5);
    }

    public UnsupportedObjectException(String str, Throwable th5) {
        super(str, th5);
    }
}
