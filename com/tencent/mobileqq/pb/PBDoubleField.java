package com.tencent.mobileqq.pb;

import java.io.IOException;

/* loaded from: classes16.dex */
public final class PBDoubleField extends PBPrimitiveField<Double> {
    public static final PBDoubleField __repeatHelper__ = new PBDoubleField(0.0d, false);
    private double value = 0.0d;

    public PBDoubleField(double d16, boolean z16) {
        set(d16, z16);
    }

    @Override // com.tencent.mobileqq.pb.PBField
    public void clear(Object obj) {
        double d16;
        if (obj instanceof Double) {
            d16 = ((Double) obj).doubleValue();
        } else {
            d16 = 0.0d;
        }
        this.value = d16;
        setHasFlag(false);
    }

    @Override // com.tencent.mobileqq.pb.PBField
    public int computeSize(int i3) {
        if (has()) {
            return CodedOutputStreamMicro.computeDoubleSize(i3, this.value);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.pb.PBField
    public int computeSizeDirectly(int i3, Double d16) {
        return CodedOutputStreamMicro.computeDoubleSize(i3, d16.doubleValue());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.pb.PBField
    public void copyFrom(PBField<Double> pBField) {
        PBDoubleField pBDoubleField = (PBDoubleField) pBField;
        set(pBDoubleField.value, pBDoubleField.has());
    }

    public double get() {
        return this.value;
    }

    @Override // com.tencent.mobileqq.pb.PBField
    public void readFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        this.value = codedInputStreamMicro.readDouble();
        setHasFlag(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.pb.PBField
    public Double readFromDirectly(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return Double.valueOf(codedInputStreamMicro.readDouble());
    }

    public void set(double d16) {
        set(d16, true);
    }

    @Override // com.tencent.mobileqq.pb.PBField
    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro, int i3) throws IOException {
        if (has()) {
            codedOutputStreamMicro.writeDouble(i3, this.value);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.pb.PBField
    public void writeToDirectly(CodedOutputStreamMicro codedOutputStreamMicro, int i3, Double d16) throws IOException {
        codedOutputStreamMicro.writeDouble(i3, d16.doubleValue());
    }

    public void set(double d16, boolean z16) {
        this.value = d16;
        setHasFlag(z16);
    }
}
