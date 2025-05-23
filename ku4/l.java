package ku4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class l extends ExtendableMessageNano<l> {

    /* renamed from: a, reason: collision with root package name */
    public e f413114a;

    /* renamed from: b, reason: collision with root package name */
    public c f413115b;

    /* renamed from: c, reason: collision with root package name */
    public d f413116c;

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
            if (readTag == 10) {
                if (this.f413114a == null) {
                    this.f413114a = new e();
                }
                codedInputByteBufferNano.readMessage(this.f413114a);
            } else if (readTag == 18) {
                if (this.f413115b == null) {
                    this.f413115b = new c();
                }
                codedInputByteBufferNano.readMessage(this.f413115b);
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.f413116c == null) {
                    this.f413116c = new d();
                }
                codedInputByteBufferNano.readMessage(this.f413116c);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        e eVar = this.f413114a;
        if (eVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, eVar);
        }
        c cVar = this.f413115b;
        if (cVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, cVar);
        }
        d dVar = this.f413116c;
        return dVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(3, dVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        e eVar = this.f413114a;
        if (eVar != null) {
            codedOutputByteBufferNano.writeMessage(1, eVar);
        }
        c cVar = this.f413115b;
        if (cVar != null) {
            codedOutputByteBufferNano.writeMessage(2, cVar);
        }
        d dVar = this.f413116c;
        if (dVar != null) {
            codedOutputByteBufferNano.writeMessage(3, dVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public l a() {
        this.f413114a = null;
        this.f413115b = null;
        this.f413116c = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
