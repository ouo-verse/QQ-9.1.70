package org.apache.httpcore.impl.entity;

import org.apache.httpcore.Header;
import org.apache.httpcore.HttpException;
import org.apache.httpcore.HttpMessage;
import org.apache.httpcore.HttpVersion;
import org.apache.httpcore.ProtocolException;
import org.apache.httpcore.annotation.Contract;
import org.apache.httpcore.annotation.ThreadingBehavior;
import org.apache.httpcore.entity.ContentLengthStrategy;
import org.apache.httpcore.util.Args;

/* compiled from: P */
@Contract(threading = ThreadingBehavior.IMMUTABLE)
/* loaded from: classes29.dex */
public class StrictContentLengthStrategy implements ContentLengthStrategy {
    public static final StrictContentLengthStrategy INSTANCE = new StrictContentLengthStrategy();
    private final int implicitLen;

    public StrictContentLengthStrategy(int i3) {
        this.implicitLen = i3;
    }

    @Override // org.apache.httpcore.entity.ContentLengthStrategy
    public long determineLength(HttpMessage httpMessage) throws HttpException {
        Args.notNull(httpMessage, "HTTP message");
        Header firstHeader = httpMessage.getFirstHeader("Transfer-Encoding");
        if (firstHeader != null) {
            String value = firstHeader.getValue();
            if ("chunked".equalsIgnoreCase(value)) {
                if (!httpMessage.getProtocolVersion().lessEquals(HttpVersion.HTTP_1_0)) {
                    return -2L;
                }
                throw new ProtocolException("Chunked transfer encoding not allowed for " + httpMessage.getProtocolVersion());
            }
            if ("identity".equalsIgnoreCase(value)) {
                return -1L;
            }
            throw new ProtocolException("Unsupported transfer encoding: " + value);
        }
        Header firstHeader2 = httpMessage.getFirstHeader("Content-Length");
        if (firstHeader2 != null) {
            String value2 = firstHeader2.getValue();
            try {
                long parseLong = Long.parseLong(value2);
                if (parseLong >= 0) {
                    return parseLong;
                }
                throw new ProtocolException("Negative content length: " + value2);
            } catch (NumberFormatException unused) {
                throw new ProtocolException("Invalid content length: " + value2);
            }
        }
        return this.implicitLen;
    }

    public StrictContentLengthStrategy() {
        this(-1);
    }
}
