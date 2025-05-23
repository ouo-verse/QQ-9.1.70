package com.tencent.qphone.base.util.log.processor;

/* loaded from: classes22.dex */
public interface IByteProcessor {
    public static final int MAX_PROCESS_BUFFER = 2048;

    void close();

    ProcessByteData handleData(ProcessByteData processByteData);

    void reset();
}
