package gs4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class q extends ExtendableMessageNano<q> {

    /* renamed from: a, reason: collision with root package name */
    public fs4.s f403331a;

    public q() {
        a();
    }

    public static q c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (q) MessageNano.mergeFrom(new q(), bArr);
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public q mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                if (this.f403331a == null) {
                    this.f403331a = new fs4.s();
                }
                codedInputByteBufferNano.readMessage(this.f403331a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        fs4.s sVar = this.f403331a;
        return sVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(1, sVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        fs4.s sVar = this.f403331a;
        if (sVar != null) {
            codedOutputByteBufferNano.writeMessage(1, sVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public q a() {
        this.f403331a = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
