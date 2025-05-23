package com.tencent.mobileqq.pb;

import java.io.IOException;

/* loaded from: classes16.dex */
public final class PBBoolField extends PBPrimitiveField<Boolean> {
    public static final PBBoolField __repeatHelper__ = new PBBoolField(false, false);
    private boolean value = false;

    public PBBoolField(boolean z16, boolean z17) {
        set(z16, z17);
    }

    @Override // com.tencent.mobileqq.pb.PBField
    public void clear(Object obj) {
        if (obj instanceof Boolean) {
            this.value = ((Boolean) obj).booleanValue();
        } else {
            this.value = false;
        }
        setHasFlag(false);
    }

    @Override // com.tencent.mobileqq.pb.PBField
    public int computeSize(int i3) {
        if (has()) {
            return CodedOutputStreamMicro.computeBoolSize(i3, this.value);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.pb.PBField
    public int computeSizeDirectly(int i3, Boolean bool) {
        return CodedOutputStreamMicro.computeBoolSize(i3, bool.booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.pb.PBField
    public void copyFrom(PBField<Boolean> pBField) {
        PBBoolField pBBoolField = (PBBoolField) pBField;
        set(pBBoolField.value, pBBoolField.has());
    }

    public boolean get() {
        return this.value;
    }

    @Override // com.tencent.mobileqq.pb.PBField
    public void readFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        this.value = codedInputStreamMicro.readBool();
        setHasFlag(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.pb.PBField
    public Boolean readFromDirectly(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return Boolean.valueOf(codedInputStreamMicro.readBool());
    }

    public void set(boolean z16) {
        set(z16, true);
    }

    @Override // com.tencent.mobileqq.pb.PBField
    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro, int i3) throws IOException {
        if (has()) {
            codedOutputStreamMicro.writeBool(i3, this.value);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.pb.PBField
    public void writeToDirectly(CodedOutputStreamMicro codedOutputStreamMicro, int i3, Boolean bool) throws IOException {
        codedOutputStreamMicro.writeBool(i3, bool.booleanValue());
    }

    public void set(boolean z16, boolean z17) {
        this.value = z16;
        setHasFlag(z17);
    }
}
