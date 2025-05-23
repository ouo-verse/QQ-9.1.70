package ip4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class d extends ExtendableMessageNano<d> {

    /* renamed from: a, reason: collision with root package name */
    public a f408158a;

    /* renamed from: b, reason: collision with root package name */
    public f f408159b;

    /* renamed from: c, reason: collision with root package name */
    public b f408160c;

    public d() {
        a();
    }

    public static d c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (d) MessageNano.mergeFrom(new d(), bArr);
    }

    public d a() {
        this.f408158a = null;
        this.f408159b = null;
        this.f408160c = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public d mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 18) {
                        if (readTag != 26) {
                            if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                return this;
                            }
                        } else {
                            if (this.f408160c == null) {
                                this.f408160c = new b();
                            }
                            codedInputByteBufferNano.readMessage(this.f408160c);
                        }
                    } else {
                        if (this.f408159b == null) {
                            this.f408159b = new f();
                        }
                        codedInputByteBufferNano.readMessage(this.f408159b);
                    }
                } else {
                    if (this.f408158a == null) {
                        this.f408158a = new a();
                    }
                    codedInputByteBufferNano.readMessage(this.f408158a);
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
        a aVar = this.f408158a;
        if (aVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, aVar);
        }
        f fVar = this.f408159b;
        if (fVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, fVar);
        }
        b bVar = this.f408160c;
        if (bVar != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(3, bVar);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        a aVar = this.f408158a;
        if (aVar != null) {
            codedOutputByteBufferNano.writeMessage(1, aVar);
        }
        f fVar = this.f408159b;
        if (fVar != null) {
            codedOutputByteBufferNano.writeMessage(2, fVar);
        }
        b bVar = this.f408160c;
        if (bVar != null) {
            codedOutputByteBufferNano.writeMessage(3, bVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
