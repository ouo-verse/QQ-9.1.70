package com.tencent.qphone.base.util.log.wrapper;

import com.tencent.qphone.base.util.log.ILogWriter;
import com.tencent.qphone.base.util.log.QBufferedWriter;
import com.tencent.qphone.base.util.log.QLogWriter;

/* compiled from: P */
/* loaded from: classes22.dex */
public class BufferWriterWrapper extends QBufferedWriter implements ILogWriter {
    public BufferWriterWrapper(QLogWriter qLogWriter, int i3) {
        super(qLogWriter, i3);
    }
}
