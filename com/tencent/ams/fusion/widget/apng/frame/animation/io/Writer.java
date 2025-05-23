package com.tencent.ams.fusion.widget.apng.frame.animation.io;

import java.io.IOException;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface Writer {
    void close() throws IOException;

    int position();

    void putByte(byte b16);

    void putBytes(byte[] bArr);

    void reset(int i3);

    void skip(int i3);

    byte[] toByteArray();
}
