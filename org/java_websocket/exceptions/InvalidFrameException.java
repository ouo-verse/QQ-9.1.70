package org.java_websocket.exceptions;

/* compiled from: P */
/* loaded from: classes38.dex */
public class InvalidFrameException extends InvalidDataException {
    private static final long serialVersionUID = -9016496369828887591L;

    public InvalidFrameException() {
        super(1002);
    }

    public InvalidFrameException(String str) {
        super(1002, str);
    }

    public InvalidFrameException(Throwable th5) {
        super(1002, th5);
    }

    public InvalidFrameException(String str, Throwable th5) {
        super(1002, str, th5);
    }
}
