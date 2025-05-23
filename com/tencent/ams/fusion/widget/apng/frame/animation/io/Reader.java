package com.tencent.ams.fusion.widget.apng.frame.animation.io;

import java.io.IOException;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface Reader {
    int available() throws IOException;

    void close() throws IOException;

    byte peek() throws IOException;

    int position();

    int read(byte[] bArr, int i3, int i16) throws IOException;

    void reset() throws IOException;

    long skip(long j3) throws IOException;

    InputStream toInputStream() throws IOException;
}
