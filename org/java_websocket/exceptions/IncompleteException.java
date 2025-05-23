package org.java_websocket.exceptions;

/* compiled from: P */
/* loaded from: classes38.dex */
public class IncompleteException extends Exception {
    private static final long serialVersionUID = 7330519489840500997L;
    private final int preferredSize;

    public IncompleteException(int i3) {
        this.preferredSize = i3;
    }

    public int getPreferredSize() {
        return this.preferredSize;
    }
}
