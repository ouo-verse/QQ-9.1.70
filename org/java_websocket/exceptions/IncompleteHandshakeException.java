package org.java_websocket.exceptions;

/* compiled from: P */
/* loaded from: classes38.dex */
public class IncompleteHandshakeException extends RuntimeException {
    private static final long serialVersionUID = 7906596804233893092L;
    private final int preferredSize;

    public IncompleteHandshakeException(int i3) {
        this.preferredSize = i3;
    }

    public int getPreferredSize() {
        return this.preferredSize;
    }

    public IncompleteHandshakeException() {
        this.preferredSize = 0;
    }
}
