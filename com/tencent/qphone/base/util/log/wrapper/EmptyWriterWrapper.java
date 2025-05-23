package com.tencent.qphone.base.util.log.wrapper;

import com.tencent.qphone.base.util.log.ILogWriter;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes22.dex */
public class EmptyWriterWrapper implements ILogWriter {
    @Override // com.tencent.qphone.base.util.log.ILogWriter
    public void write(int i3) throws IOException {
    }

    @Override // com.tencent.qphone.base.util.log.ILogWriter
    public void write(String str) throws IOException {
    }

    @Override // com.tencent.qphone.base.util.log.ILogWriter
    public void write(byte[] bArr, int i3, int i16) throws IOException {
    }

    @Override // com.tencent.qphone.base.util.log.ILogWriter
    public void write(char[] cArr, int i3, int i16) throws IOException {
    }

    @Override // com.tencent.qphone.base.util.log.ILogWriter
    public void close() throws IOException {
    }

    @Override // com.tencent.qphone.base.util.log.ILogWriter
    public void flush() throws IOException {
    }
}
