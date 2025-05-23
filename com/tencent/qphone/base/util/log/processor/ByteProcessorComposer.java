package com.tencent.qphone.base.util.log.processor;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes22.dex */
public class ByteProcessorComposer implements IByteProcessor {
    ArrayList<IByteProcessor> list = new ArrayList<>();

    public void addProcessor(IByteProcessor iByteProcessor) {
        this.list.add(iByteProcessor);
    }

    @Override // com.tencent.qphone.base.util.log.processor.IByteProcessor
    public void close() {
        Iterator<IByteProcessor> it = this.list.iterator();
        while (it.hasNext()) {
            it.next().close();
        }
    }

    @Override // com.tencent.qphone.base.util.log.processor.IByteProcessor
    public ProcessByteData handleData(ProcessByteData processByteData) {
        Iterator<IByteProcessor> it = this.list.iterator();
        while (it.hasNext()) {
            processByteData = it.next().handleData(processByteData);
        }
        return processByteData;
    }

    @Override // com.tencent.qphone.base.util.log.processor.IByteProcessor
    public void reset() {
        Iterator<IByteProcessor> it = this.list.iterator();
        while (it.hasNext()) {
            it.next().reset();
        }
    }
}
