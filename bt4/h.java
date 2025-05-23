package bt4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes39.dex */
public final class h extends ExtendableMessageNano<h> {

    /* renamed from: a, reason: collision with root package name */
    public fs4.h f29124a;

    public h() {
        a();
    }

    public static h c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (h) MessageNano.mergeFrom(new h(), bArr);
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public h mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                if (this.f29124a == null) {
                    this.f29124a = new fs4.h();
                }
                codedInputByteBufferNano.readMessage(this.f29124a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        fs4.h hVar = this.f29124a;
        return hVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(1, hVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        fs4.h hVar = this.f29124a;
        if (hVar != null) {
            codedOutputByteBufferNano.writeMessage(1, hVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public h a() {
        this.f29124a = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
