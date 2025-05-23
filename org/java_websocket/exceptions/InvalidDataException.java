package org.java_websocket.exceptions;

/* compiled from: P */
/* loaded from: classes38.dex */
public class InvalidDataException extends Exception {
    private static final long serialVersionUID = 3731842424390998726L;
    private final int closecode;

    public InvalidDataException(int i3) {
        this.closecode = i3;
    }

    public int getCloseCode() {
        return this.closecode;
    }

    public InvalidDataException(int i3, String str) {
        super(str);
        this.closecode = i3;
    }

    public InvalidDataException(int i3, Throwable th5) {
        super(th5);
        this.closecode = i3;
    }

    public InvalidDataException(int i3, String str, Throwable th5) {
        super(str, th5);
        this.closecode = i3;
    }
}
