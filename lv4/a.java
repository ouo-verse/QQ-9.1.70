package lv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: a, reason: collision with root package name */
    public iv4.e f415635a;

    /* renamed from: b, reason: collision with root package name */
    public kv4.a f415636b;

    public a() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                if (this.f415635a == null) {
                    this.f415635a = new iv4.e();
                }
                codedInputByteBufferNano.readMessage(this.f415635a);
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.f415636b == null) {
                    this.f415636b = new kv4.a();
                }
                codedInputByteBufferNano.readMessage(this.f415636b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        iv4.e eVar = this.f415635a;
        if (eVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, eVar);
        }
        kv4.a aVar = this.f415636b;
        return aVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, aVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        iv4.e eVar = this.f415635a;
        if (eVar != null) {
            codedOutputByteBufferNano.writeMessage(1, eVar);
        }
        kv4.a aVar = this.f415636b;
        if (aVar != null) {
            codedOutputByteBufferNano.writeMessage(2, aVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public a a() {
        this.f415635a = null;
        this.f415636b = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
