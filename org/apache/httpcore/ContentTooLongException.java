package org.apache.httpcore;

import java.io.IOException;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ContentTooLongException extends IOException {
    private static final long serialVersionUID = -924287689552495383L;

    public ContentTooLongException(String str) {
        super(str);
    }

    public ContentTooLongException(String str, Object... objArr) {
        super(HttpException.clean(String.format(str, objArr)));
    }
}
