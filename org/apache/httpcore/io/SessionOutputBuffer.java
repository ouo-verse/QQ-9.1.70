package org.apache.httpcore.io;

import java.io.IOException;
import org.apache.httpcore.util.CharArrayBuffer;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface SessionOutputBuffer {
    void flush() throws IOException;

    HttpTransportMetrics getMetrics();

    void write(int i3) throws IOException;

    void write(byte[] bArr) throws IOException;

    void write(byte[] bArr, int i3, int i16) throws IOException;

    void writeLine(String str) throws IOException;

    void writeLine(CharArrayBuffer charArrayBuffer) throws IOException;
}
