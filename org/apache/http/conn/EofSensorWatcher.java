package org.apache.http.conn;

import java.io.IOException;
import java.io.InputStream;

/* compiled from: P */
@Deprecated
/* loaded from: classes29.dex */
public interface EofSensorWatcher {
    boolean eofDetected(InputStream inputStream) throws IOException;

    boolean streamAbort(InputStream inputStream) throws IOException;

    boolean streamClosed(InputStream inputStream) throws IOException;
}
