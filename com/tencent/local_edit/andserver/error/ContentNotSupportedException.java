package com.tencent.local_edit.andserver.error;

import com.tencent.local_edit.andserver.util.MediaType;

/* compiled from: P */
/* loaded from: classes7.dex */
public class ContentNotSupportedException extends HttpException {
    public ContentNotSupportedException(MediaType mediaType) {
        super(415, String.format("The content type [%s] is not supported.", mediaType));
    }

    public ContentNotSupportedException(MediaType mediaType, Throwable th5) {
        super(415, String.format("The content type [%s] is not supported.", mediaType), th5);
    }
}
