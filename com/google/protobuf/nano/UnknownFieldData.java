package com.google.protobuf.nano;

import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public final class UnknownFieldData {
    final byte[] bytes;
    final int tag;

    /* JADX INFO: Access modifiers changed from: package-private */
    public UnknownFieldData(int i3, byte[] bArr) {
        this.tag = i3;
        this.bytes = bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int computeSerializedSize() {
        return CodedOutputByteBufferNano.computeRawVarint32Size(this.tag) + 0 + this.bytes.length;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UnknownFieldData)) {
            return false;
        }
        UnknownFieldData unknownFieldData = (UnknownFieldData) obj;
        if (this.tag == unknownFieldData.tag && Arrays.equals(this.bytes, unknownFieldData.bytes)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((527 + this.tag) * 31) + Arrays.hashCode(this.bytes);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeRawVarint32(this.tag);
        codedOutputByteBufferNano.writeRawBytes(this.bytes);
    }
}
