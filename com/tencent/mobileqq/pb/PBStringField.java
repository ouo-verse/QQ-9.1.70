package com.tencent.mobileqq.pb;

import java.io.IOException;

/* loaded from: classes16.dex */
public final class PBStringField extends PBPrimitiveField<String> {
    public static final PBStringField __repeatHelper__ = new PBStringField("", false);
    private String value = "";

    public PBStringField(String str, boolean z16) {
        set(str, z16);
    }

    @Override // com.tencent.mobileqq.pb.PBField
    public void clear(Object obj) {
        String str;
        if (obj instanceof String) {
            str = (String) obj;
        } else {
            str = "";
        }
        this.value = str;
        setHasFlag(false);
    }

    @Override // com.tencent.mobileqq.pb.PBField
    public int computeSize(int i3) {
        if (has()) {
            String str = this.value;
            if (str != null) {
                return CodedOutputStreamMicro.computeStringSize(i3, str);
            }
            throw new RuntimeException(this + " encounter string null, null for PBStringField is forbidden!");
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.pb.PBField
    public void copyFrom(PBField<String> pBField) {
        PBStringField pBStringField = (PBStringField) pBField;
        set(pBStringField.value, pBStringField.has());
    }

    public String get() {
        return this.value;
    }

    @Override // com.tencent.mobileqq.pb.PBField
    public void readFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        this.value = codedInputStreamMicro.readString();
        setHasFlag(true);
    }

    public void set(String str) {
        set(str, true);
    }

    @Override // com.tencent.mobileqq.pb.PBField
    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro, int i3) throws IOException {
        if (has()) {
            codedOutputStreamMicro.writeString(i3, this.value);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.pb.PBField
    public int computeSizeDirectly(int i3, String str) {
        return CodedOutputStreamMicro.computeStringSize(i3, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.pb.PBField
    public String readFromDirectly(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return codedInputStreamMicro.readString();
    }

    public void set(String str, boolean z16) {
        this.value = str;
        setHasFlag(z16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.pb.PBField
    public void writeToDirectly(CodedOutputStreamMicro codedOutputStreamMicro, int i3, String str) throws IOException {
        codedOutputStreamMicro.writeString(i3, str);
    }
}
