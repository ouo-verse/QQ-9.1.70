package jv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class l extends ExtendableMessageNano<l> {

    /* renamed from: a, reason: collision with root package name */
    public iv4.l f411040a;

    public l() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public l mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag != 10) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.f411040a == null) {
                    this.f411040a = new iv4.l();
                }
                codedInputByteBufferNano.readMessage(this.f411040a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        iv4.l lVar = this.f411040a;
        return lVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(1, lVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        iv4.l lVar = this.f411040a;
        if (lVar != null) {
            codedOutputByteBufferNano.writeMessage(1, lVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public l a() {
        this.f411040a = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
