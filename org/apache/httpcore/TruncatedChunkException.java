package org.apache.httpcore;

/* compiled from: P */
/* loaded from: classes29.dex */
public class TruncatedChunkException extends MalformedChunkCodingException {
    private static final long serialVersionUID = -23506263930279460L;

    public TruncatedChunkException(String str) {
        super(str);
    }

    public TruncatedChunkException(String str, Object... objArr) {
        super(HttpException.clean(String.format(str, objArr)));
    }
}
