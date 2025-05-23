package org.apache.httpcore.io;

import org.apache.httpcore.HttpMessage;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface HttpMessageWriterFactory<T extends HttpMessage> {
    HttpMessageWriter<T> create(SessionOutputBuffer sessionOutputBuffer);
}
