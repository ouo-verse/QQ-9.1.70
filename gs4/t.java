package gs4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class t extends ExtendableMessageNano<t> {

    /* renamed from: a, reason: collision with root package name */
    public fs4.t f403339a;

    public t() {
        a();
    }

    public static t c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (t) MessageNano.mergeFrom(new t(), bArr);
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public t mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                if (this.f403339a == null) {
                    this.f403339a = new fs4.t();
                }
                codedInputByteBufferNano.readMessage(this.f403339a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        fs4.t tVar = this.f403339a;
        return tVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(1, tVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        fs4.t tVar = this.f403339a;
        if (tVar != null) {
            codedOutputByteBufferNano.writeMessage(1, tVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public t a() {
        this.f403339a = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
