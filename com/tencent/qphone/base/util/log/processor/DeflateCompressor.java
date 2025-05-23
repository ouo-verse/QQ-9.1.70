package com.tencent.qphone.base.util.log.processor;

import android.annotation.TargetApi;
import java.util.zip.Deflater;

/* compiled from: P */
/* loaded from: classes22.dex */
public class DeflateCompressor implements IByteProcessor {
    private static final int DEFLATE_OFFSET = 10;
    private final boolean compress;
    Deflater deflater;
    public ProcessByteData out = new ProcessByteData(2058);

    public DeflateCompressor(boolean z16) {
        Deflater deflater = new Deflater();
        this.deflater = deflater;
        this.compress = z16;
        deflater.setStrategy(1);
        this.deflater.setLevel(1);
    }

    @Override // com.tencent.qphone.base.util.log.processor.IByteProcessor
    public void close() {
        Deflater deflater = this.deflater;
        if (deflater != null) {
            deflater.end();
        }
    }

    @Override // com.tencent.qphone.base.util.log.processor.IByteProcessor
    @TargetApi(19)
    public ProcessByteData handleData(ProcessByteData processByteData) {
        if (this.compress) {
            this.deflater.setInput(processByteData.bytes, processByteData.offset, processByteData.length);
            ProcessByteData processByteData2 = this.out;
            processByteData2.length = this.deflater.deflate(processByteData2.bytes, 0, processByteData2.capacity, 2);
            ProcessByteData processByteData3 = this.out;
            processByteData3.offset = 0;
            return processByteData3;
        }
        return processByteData;
    }

    @Override // com.tencent.qphone.base.util.log.processor.IByteProcessor
    public void reset() {
        this.deflater.reset();
    }
}
