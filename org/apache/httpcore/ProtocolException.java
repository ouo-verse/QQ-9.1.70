package org.apache.httpcore;

/* loaded from: classes29.dex */
public class ProtocolException extends HttpException {
    private static final long serialVersionUID = -2143571074341228994L;

    public ProtocolException() {
    }

    public ProtocolException(String str) {
        super(str);
    }

    public ProtocolException(String str, Throwable th5) {
        super(str, th5);
    }
}
