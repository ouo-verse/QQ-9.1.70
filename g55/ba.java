package g55;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ba extends ExtendableMessageNano<ba> {

    /* renamed from: a, reason: collision with root package name */
    public ab f401351a;

    public ba() {
        a();
    }

    public ba a() {
        this.f401351a = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ba mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                } else {
                    if (this.f401351a == null) {
                        this.f401351a = new ab();
                    }
                    codedInputByteBufferNano.readMessage(this.f401351a);
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
        ab abVar = this.f401351a;
        if (abVar != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(1, abVar);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        ab abVar = this.f401351a;
        if (abVar != null) {
            codedOutputByteBufferNano.writeMessage(1, abVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
