package org.apache.http;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: P */
@Deprecated
/* loaded from: classes29.dex */
public interface HttpEntity {
    void consumeContent() throws IOException;

    InputStream getContent() throws IOException, IllegalStateException;

    Header getContentEncoding();

    long getContentLength();

    Header getContentType();

    boolean isChunked();

    boolean isRepeatable();

    boolean isStreaming();

    void writeTo(OutputStream outputStream) throws IOException;
}
