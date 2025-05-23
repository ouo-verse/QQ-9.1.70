package jv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class b extends ExtendableMessageNano<b> {

    /* renamed from: a, reason: collision with root package name */
    public iv4.k f411013a;

    public b() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                if (this.f411013a == null) {
                    this.f411013a = new iv4.k();
                }
                codedInputByteBufferNano.readMessage(this.f411013a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        iv4.k kVar = this.f411013a;
        return kVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(1, kVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        iv4.k kVar = this.f411013a;
        if (kVar != null) {
            codedOutputByteBufferNano.writeMessage(1, kVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public b a() {
        this.f411013a = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
