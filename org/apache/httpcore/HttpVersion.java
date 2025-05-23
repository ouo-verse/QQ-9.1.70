package org.apache.httpcore;

import org.apache.httpcore.annotation.Contract;
import org.apache.httpcore.annotation.ThreadingBehavior;

/* compiled from: P */
@Contract(threading = ThreadingBehavior.IMMUTABLE)
/* loaded from: classes29.dex */
public final class HttpVersion extends ProtocolVersion {
    public static final String HTTP = "HTTP";
    public static final HttpVersion HTTP_0_9 = new HttpVersion(0, 9);
    public static final HttpVersion HTTP_1_0 = new HttpVersion(1, 0);
    public static final HttpVersion HTTP_1_1 = new HttpVersion(1, 1);
    private static final long serialVersionUID = -5856653513894415344L;

    public HttpVersion(int i3, int i16) {
        super("HTTP", i3, i16);
    }

    @Override // org.apache.httpcore.ProtocolVersion
    public ProtocolVersion forVersion(int i3, int i16) {
        if (i3 == this.major && i16 == this.minor) {
            return this;
        }
        if (i3 == 1) {
            if (i16 == 0) {
                return HTTP_1_0;
            }
            if (i16 == 1) {
                return HTTP_1_1;
            }
        }
        if (i3 == 0 && i16 == 9) {
            return HTTP_0_9;
        }
        return new HttpVersion(i3, i16);
    }
}
