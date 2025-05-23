package com.tencent.mobileqq.pb;

import java.io.IOException;

/* loaded from: classes16.dex */
public final class PBFixed32Field extends PBPrimitiveField<Integer> {
    public static final PBFixed32Field __repeatHelper__ = new PBFixed32Field(0, false);
    private int value = 0;

    public PBFixed32Field(int i3, boolean z16) {
        set(i3, z16);
    }

    @Override // com.tencent.mobileqq.pb.PBField
    public void clear(Object obj) {
        if (obj instanceof Integer) {
            this.value = ((Integer) obj).intValue();
        } else {
            this.value = 0;
        }
        setHasFlag(false);
    }

    @Override // com.tencent.mobileqq.pb.PBField
    public int computeSize(int i3) {
        if (has()) {
            return CodedOutputStreamMicro.computeFixed32Size(i3, this.value);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.pb.PBField
    public int computeSizeDirectly(int i3, Integer num) {
        return CodedOutputStreamMicro.computeFixed32Size(i3, num.intValue());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.pb.PBField
    public void copyFrom(PBField<Integer> pBField) {
        PBFixed32Field pBFixed32Field = (PBFixed32Field) pBField;
        set(pBFixed32Field.value, pBFixed32Field.has());
    }

    public int get() {
        return this.value;
    }

    @Override // com.tencent.mobileqq.pb.PBField
    public void readFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        this.value = codedInputStreamMicro.readFixed32();
        setHasFlag(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.pb.PBField
    public Integer readFromDirectly(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return Integer.valueOf(codedInputStreamMicro.readFixed32());
    }

    public void set(int i3) {
        set(i3, true);
    }

    @Override // com.tencent.mobileqq.pb.PBField
    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro, int i3) throws IOException {
        if (has()) {
            codedOutputStreamMicro.writeFixed32(i3, this.value);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.pb.PBField
    public void writeToDirectly(CodedOutputStreamMicro codedOutputStreamMicro, int i3, Integer num) throws IOException {
        codedOutputStreamMicro.writeFixed32(i3, num.intValue());
    }

    public void set(int i3, boolean z16) {
        this.value = i3;
        setHasFlag(z16);
    }
}
