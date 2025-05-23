package org.apache.httpcore.impl.entity;

import org.apache.httpcore.HttpException;
import org.apache.httpcore.HttpMessage;
import org.apache.httpcore.ProtocolException;
import org.apache.httpcore.annotation.Contract;
import org.apache.httpcore.annotation.ThreadingBehavior;
import org.apache.httpcore.entity.ContentLengthStrategy;

/* compiled from: P */
@Contract(threading = ThreadingBehavior.IMMUTABLE_CONDITIONAL)
/* loaded from: classes29.dex */
public class DisallowIdentityContentLengthStrategy implements ContentLengthStrategy {
    public static final DisallowIdentityContentLengthStrategy INSTANCE = new DisallowIdentityContentLengthStrategy(new LaxContentLengthStrategy(0));
    private final ContentLengthStrategy contentLengthStrategy;

    public DisallowIdentityContentLengthStrategy(ContentLengthStrategy contentLengthStrategy) {
        this.contentLengthStrategy = contentLengthStrategy;
    }

    @Override // org.apache.httpcore.entity.ContentLengthStrategy
    public long determineLength(HttpMessage httpMessage) throws HttpException {
        long determineLength = this.contentLengthStrategy.determineLength(httpMessage);
        if (determineLength != -1) {
            return determineLength;
        }
        throw new ProtocolException("Identity transfer encoding cannot be used");
    }
}
