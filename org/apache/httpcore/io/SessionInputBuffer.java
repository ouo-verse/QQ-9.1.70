package org.apache.httpcore.io;

import java.io.IOException;
import org.apache.httpcore.util.CharArrayBuffer;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface SessionInputBuffer {
    HttpTransportMetrics getMetrics();

    @Deprecated
    boolean isDataAvailable(int i3) throws IOException;

    int read() throws IOException;

    int read(byte[] bArr) throws IOException;

    int read(byte[] bArr, int i3, int i16) throws IOException;

    int readLine(CharArrayBuffer charArrayBuffer) throws IOException;

    String readLine() throws IOException;
}
