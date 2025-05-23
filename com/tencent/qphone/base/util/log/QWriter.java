package com.tencent.qphone.base.util.log;

import java.io.IOException;
import java.io.Writer;

/* compiled from: P */
/* loaded from: classes22.dex */
public abstract class QWriter extends Writer {
    /* JADX INFO: Access modifiers changed from: protected */
    public QWriter(Object obj) {
        super(obj);
    }

    public abstract void write(byte[] bArr, int i3, int i16) throws IOException;
}
