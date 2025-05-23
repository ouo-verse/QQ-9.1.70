package com.tencent.mobileqq.pb;

import java.io.IOException;

/* loaded from: classes16.dex */
public final class PBFixed64Field extends PBPrimitiveField<Long> {
    public static final PBFixed64Field __repeatHelper__ = new PBFixed64Field(0, false);
    private long value = 0;

    public PBFixed64Field(long j3, boolean z16) {
        set(j3, z16);
    }

    @Override // com.tencent.mobileqq.pb.PBField
    public void clear(Object obj) {
        long j3;
        if (obj instanceof Long) {
            j3 = ((Long) obj).longValue();
        } else {
            j3 = 0;
        }
        this.value = j3;
        setHasFlag(false);
    }

    @Override // com.tencent.mobileqq.pb.PBField
    public int computeSize(int i3) {
        if (has()) {
            return CodedOutputStreamMicro.computeFixed64Size(i3, this.value);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.pb.PBField
    public int computeSizeDirectly(int i3, Long l3) {
        return CodedOutputStreamMicro.computeFixed64Size(i3, l3.longValue());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.pb.PBField
    public void copyFrom(PBField<Long> pBField) {
        PBFixed64Field pBFixed64Field = (PBFixed64Field) pBField;
        set(pBFixed64Field.value, pBFixed64Field.has());
    }

    public long get() {
        return this.value;
    }

    @Override // com.tencent.mobileqq.pb.PBField
    public void readFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        this.value = codedInputStreamMicro.readFixed64();
        setHasFlag(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.pb.PBField
    public Long readFromDirectly(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return Long.valueOf(codedInputStreamMicro.readFixed64());
    }

    public void set(long j3) {
        set(j3, true);
    }

    @Override // com.tencent.mobileqq.pb.PBField
    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro, int i3) throws IOException {
        if (has()) {
            codedOutputStreamMicro.writeFixed64(i3, this.value);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.pb.PBField
    public void writeToDirectly(CodedOutputStreamMicro codedOutputStreamMicro, int i3, Long l3) throws IOException {
        codedOutputStreamMicro.writeFixed64(i3, l3.longValue());
    }

    public void set(long j3, boolean z16) {
        this.value = j3;
        setHasFlag(z16);
    }
}
