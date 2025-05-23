package hs4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class l extends ExtendableMessageNano<l> {

    /* renamed from: a, reason: collision with root package name */
    public b f406166a;

    /* renamed from: b, reason: collision with root package name */
    public b f406167b;

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
                if (this.f406166a == null) {
                    this.f406166a = new b();
                }
                codedInputByteBufferNano.readMessage(this.f406166a);
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.f406167b == null) {
                    this.f406167b = new b();
                }
                codedInputByteBufferNano.readMessage(this.f406167b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        b bVar = this.f406166a;
        if (bVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, bVar);
        }
        b bVar2 = this.f406167b;
        return bVar2 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, bVar2) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        b bVar = this.f406166a;
        if (bVar != null) {
            codedOutputByteBufferNano.writeMessage(1, bVar);
        }
        b bVar2 = this.f406167b;
        if (bVar2 != null) {
            codedOutputByteBufferNano.writeMessage(2, bVar2);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public l a() {
        this.f406166a = null;
        this.f406167b = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
