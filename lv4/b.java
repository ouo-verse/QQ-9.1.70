package lv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class b extends ExtendableMessageNano<b> {

    /* renamed from: a, reason: collision with root package name */
    public iv4.f f415637a;

    /* renamed from: b, reason: collision with root package name */
    public iv4.l f415638b;

    public b() {
        a();
    }

    public static b c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (b) MessageNano.mergeFrom(new b(), bArr);
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                if (this.f415637a == null) {
                    this.f415637a = new iv4.f();
                }
                codedInputByteBufferNano.readMessage(this.f415637a);
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.f415638b == null) {
                    this.f415638b = new iv4.l();
                }
                codedInputByteBufferNano.readMessage(this.f415638b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        iv4.f fVar = this.f415637a;
        if (fVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, fVar);
        }
        iv4.l lVar = this.f415638b;
        return lVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, lVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        iv4.f fVar = this.f415637a;
        if (fVar != null) {
            codedOutputByteBufferNano.writeMessage(1, fVar);
        }
        iv4.l lVar = this.f415638b;
        if (lVar != null) {
            codedOutputByteBufferNano.writeMessage(2, lVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public b a() {
        this.f415637a = null;
        this.f415638b = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
