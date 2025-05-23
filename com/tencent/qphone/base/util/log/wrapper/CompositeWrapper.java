package com.tencent.qphone.base.util.log.wrapper;

import com.tencent.qphone.base.util.log.ILogWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes22.dex */
public class CompositeWrapper implements ILogWriter {
    ArrayList<ILogWriter> list = new ArrayList<>();

    public void add(ILogWriter iLogWriter) {
        this.list.add(iLogWriter);
    }

    @Override // com.tencent.qphone.base.util.log.ILogWriter
    public void close() throws IOException {
        Iterator<ILogWriter> it = this.list.iterator();
        while (it.hasNext()) {
            it.next().close();
        }
    }

    @Override // com.tencent.qphone.base.util.log.ILogWriter
    public void flush() throws IOException {
        Iterator<ILogWriter> it = this.list.iterator();
        while (it.hasNext()) {
            it.next().flush();
        }
    }

    @Override // com.tencent.qphone.base.util.log.ILogWriter
    public void write(String str) throws IOException {
        Iterator<ILogWriter> it = this.list.iterator();
        while (it.hasNext()) {
            it.next().write(str);
        }
    }

    @Override // com.tencent.qphone.base.util.log.ILogWriter
    public void write(int i3) throws IOException {
        Iterator<ILogWriter> it = this.list.iterator();
        while (it.hasNext()) {
            it.next().write(i3);
        }
    }

    @Override // com.tencent.qphone.base.util.log.ILogWriter
    public void write(char[] cArr, int i3, int i16) throws IOException {
        Iterator<ILogWriter> it = this.list.iterator();
        while (it.hasNext()) {
            it.next().write(cArr, i3, i16);
        }
    }

    @Override // com.tencent.qphone.base.util.log.ILogWriter
    public void write(byte[] bArr, int i3, int i16) throws IOException {
        Iterator<ILogWriter> it = this.list.iterator();
        while (it.hasNext()) {
            it.next().write(bArr, i3, i16);
        }
    }
}
