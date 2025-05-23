package com.tencent.qphone.base.util.log;

import java.io.IOException;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface ILogWriter {
    void close() throws IOException;

    void flush() throws IOException;

    void write(int i3) throws IOException;

    void write(String str) throws IOException;

    void write(byte[] bArr, int i3, int i16) throws IOException;

    void write(char[] cArr, int i3, int i16) throws IOException;
}
