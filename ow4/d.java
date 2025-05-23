package ow4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class d extends ExtendableMessageNano<d> {

    /* renamed from: a, reason: collision with root package name */
    public b f424395a;

    /* renamed from: b, reason: collision with root package name */
    public f f424396b;

    public d() {
        a();
    }

    public static d c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (d) MessageNano.mergeFrom(new d(), bArr);
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public d mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                if (this.f424395a == null) {
                    this.f424395a = new b();
                }
                codedInputByteBufferNano.readMessage(this.f424395a);
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.f424396b == null) {
                    this.f424396b = new f();
                }
                codedInputByteBufferNano.readMessage(this.f424396b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        b bVar = this.f424395a;
        if (bVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, bVar);
        }
        f fVar = this.f424396b;
        return fVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, fVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        b bVar = this.f424395a;
        if (bVar != null) {
            codedOutputByteBufferNano.writeMessage(1, bVar);
        }
        f fVar = this.f424396b;
        if (fVar != null) {
            codedOutputByteBufferNano.writeMessage(2, fVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public d a() {
        this.f424395a = null;
        this.f424396b = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
