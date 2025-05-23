package org.apache.httpcore.impl.entity;

import org.apache.httpcore.Header;
import org.apache.httpcore.HeaderElement;
import org.apache.httpcore.HttpException;
import org.apache.httpcore.HttpMessage;
import org.apache.httpcore.ParseException;
import org.apache.httpcore.ProtocolException;
import org.apache.httpcore.annotation.Contract;
import org.apache.httpcore.annotation.ThreadingBehavior;
import org.apache.httpcore.entity.ContentLengthStrategy;
import org.apache.httpcore.util.Args;

/* compiled from: P */
@Contract(threading = ThreadingBehavior.IMMUTABLE)
/* loaded from: classes29.dex */
public class LaxContentLengthStrategy implements ContentLengthStrategy {
    public static final LaxContentLengthStrategy INSTANCE = new LaxContentLengthStrategy();
    private final int implicitLen;

    public LaxContentLengthStrategy(int i3) {
        this.implicitLen = i3;
    }

    @Override // org.apache.httpcore.entity.ContentLengthStrategy
    public long determineLength(HttpMessage httpMessage) throws HttpException {
        long j3;
        Args.notNull(httpMessage, "HTTP message");
        Header firstHeader = httpMessage.getFirstHeader("Transfer-Encoding");
        if (firstHeader != null) {
            try {
                HeaderElement[] elements = firstHeader.getElements();
                int length = elements.length;
                if ("identity".equalsIgnoreCase(firstHeader.getValue()) || length <= 0 || !"chunked".equalsIgnoreCase(elements[length - 1].getName())) {
                    return -1L;
                }
                return -2L;
            } catch (ParseException e16) {
                throw new ProtocolException("Invalid Transfer-Encoding header value: " + firstHeader, e16);
            }
        }
        if (httpMessage.getFirstHeader("Content-Length") != null) {
            Header[] headers = httpMessage.getHeaders("Content-Length");
            int length2 = headers.length - 1;
            while (true) {
                if (length2 >= 0) {
                    try {
                        j3 = Long.parseLong(headers[length2].getValue());
                        break;
                    } catch (NumberFormatException unused) {
                        length2--;
                    }
                } else {
                    j3 = -1;
                    break;
                }
            }
            if (j3 < 0) {
                return -1L;
            }
            return j3;
        }
        return this.implicitLen;
    }

    public LaxContentLengthStrategy() {
        this(-1);
    }
}
