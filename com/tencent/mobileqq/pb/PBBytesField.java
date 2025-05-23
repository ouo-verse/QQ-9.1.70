package com.tencent.mobileqq.pb;

import java.io.IOException;

/* loaded from: classes16.dex */
public final class PBBytesField extends PBPrimitiveField<ByteStringMicro> {
    public static final PBBytesField __repeatHelper__ = new PBBytesField(ByteStringMicro.EMPTY, false);
    private ByteStringMicro value = ByteStringMicro.EMPTY;

    public PBBytesField(ByteStringMicro byteStringMicro, boolean z16) {
        set(byteStringMicro, z16);
    }

    @Override // com.tencent.mobileqq.pb.PBField
    public void clear(Object obj) {
        ByteStringMicro byteStringMicro;
        if (obj instanceof ByteStringMicro) {
            byteStringMicro = (ByteStringMicro) obj;
        } else {
            byteStringMicro = ByteStringMicro.EMPTY;
        }
        this.value = byteStringMicro;
        setHasFlag(false);
    }

    @Override // com.tencent.mobileqq.pb.PBField
    public int computeSize(int i3) {
        if (has()) {
            return CodedOutputStreamMicro.computeBytesSize(i3, this.value);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.pb.PBField
    public int computeSizeDirectly(int i3, ByteStringMicro byteStringMicro) {
        return CodedOutputStreamMicro.computeBytesSize(i3, byteStringMicro);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.pb.PBField
    public void copyFrom(PBField<ByteStringMicro> pBField) {
        PBBytesField pBBytesField = (PBBytesField) pBField;
        set(pBBytesField.value, pBBytesField.has());
    }

    public ByteStringMicro get() {
        return this.value;
    }

    @Override // com.tencent.mobileqq.pb.PBField
    public void readFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        this.value = codedInputStreamMicro.readBytes();
        setHasFlag(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.pb.PBField
    public ByteStringMicro readFromDirectly(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return codedInputStreamMicro.readBytes();
    }

    public void set(ByteStringMicro byteStringMicro) {
        set(byteStringMicro, true);
    }

    @Override // com.tencent.mobileqq.pb.PBField
    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro, int i3) throws IOException {
        if (has()) {
            codedOutputStreamMicro.writeBytes(i3, this.value);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.pb.PBField
    public void writeToDirectly(CodedOutputStreamMicro codedOutputStreamMicro, int i3, ByteStringMicro byteStringMicro) throws IOException {
        codedOutputStreamMicro.writeBytes(i3, byteStringMicro);
    }

    public void set(ByteStringMicro byteStringMicro, boolean z16) {
        this.value = byteStringMicro;
        setHasFlag(z16);
    }
}
