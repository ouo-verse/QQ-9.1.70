package org.apache.commons.fileupload.util;

import java.io.IOException;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface Closeable {
    void close() throws IOException;

    boolean isClosed() throws IOException;
}
