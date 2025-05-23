package org.java_websocket.exceptions;

/* compiled from: P */
/* loaded from: classes38.dex */
public class InvalidHandshakeException extends InvalidDataException {
    private static final long serialVersionUID = -1426533877490484964L;

    public InvalidHandshakeException() {
        super(1002);
    }

    public InvalidHandshakeException(String str, Throwable th5) {
        super(1002, str, th5);
    }

    public InvalidHandshakeException(String str) {
        super(1002, str);
    }

    public InvalidHandshakeException(Throwable th5) {
        super(1002, th5);
    }
}
