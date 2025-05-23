package dz3;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes25.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: a, reason: collision with root package name */
    public b f395276a;

    public a() {
        a();
    }

    public a a() {
        this.f395276a = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                } else {
                    if (this.f395276a == null) {
                        this.f395276a = new b();
                    }
                    codedInputByteBufferNano.readMessage(this.f395276a);
                }
            } else {
                return this;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        b bVar = this.f395276a;
        if (bVar != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(1, bVar);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        b bVar = this.f395276a;
        if (bVar != null) {
            codedOutputByteBufferNano.writeMessage(1, bVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
