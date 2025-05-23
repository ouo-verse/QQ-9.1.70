package org.apache.httpcore.entity;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes29.dex */
public interface ContentProducer {
    void writeTo(OutputStream outputStream) throws IOException;
}
