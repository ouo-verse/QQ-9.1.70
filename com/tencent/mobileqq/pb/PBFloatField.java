package com.tencent.mobileqq.pb;

import java.io.IOException;

/* loaded from: classes16.dex */
public final class PBFloatField extends PBPrimitiveField<Float> {
    public static final PBFloatField __repeatHelper__ = new PBFloatField(0.0f, false);
    private float value = 0.0f;

    public PBFloatField(float f16, boolean z16) {
        set(f16, z16);
    }

    @Override // com.tencent.mobileqq.pb.PBField
    public void clear(Object obj) {
        float f16;
        if (obj instanceof Float) {
            f16 = ((Float) obj).floatValue();
        } else {
            f16 = 0.0f;
        }
        this.value = f16;
        setHasFlag(false);
    }

    @Override // com.tencent.mobileqq.pb.PBField
    public int computeSize(int i3) {
        if (has()) {
            return CodedOutputStreamMicro.computeFloatSize(i3, this.value);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.pb.PBField
    public int computeSizeDirectly(int i3, Float f16) {
        return CodedOutputStreamMicro.computeFloatSize(i3, f16.floatValue());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.pb.PBField
    public void copyFrom(PBField<Float> pBField) {
        PBFloatField pBFloatField = (PBFloatField) pBField;
        set(pBFloatField.value, pBFloatField.has());
    }

    public float get() {
        return this.value;
    }

    @Override // com.tencent.mobileqq.pb.PBField
    public void readFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        this.value = codedInputStreamMicro.readFloat();
        setHasFlag(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.pb.PBField
    public Float readFromDirectly(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return Float.valueOf(codedInputStreamMicro.readFloat());
    }

    public void set(float f16) {
        set(f16, true);
    }

    @Override // com.tencent.mobileqq.pb.PBField
    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro, int i3) throws IOException {
        if (has()) {
            codedOutputStreamMicro.writeFloat(i3, this.value);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.pb.PBField
    public void writeToDirectly(CodedOutputStreamMicro codedOutputStreamMicro, int i3, Float f16) throws IOException {
        codedOutputStreamMicro.writeFloat(i3, f16.floatValue());
    }

    public void set(float f16, boolean z16) {
        this.value = f16;
        setHasFlag(z16);
    }
}
