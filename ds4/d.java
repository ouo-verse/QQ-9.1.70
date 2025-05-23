package ds4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class d extends ExtendableMessageNano<d> {

    /* renamed from: a, reason: collision with root package name */
    public long f394769a;

    /* renamed from: b, reason: collision with root package name */
    public long f394770b;

    /* renamed from: c, reason: collision with root package name */
    public bs4.k f394771c;

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
            if (readTag == 8) {
                this.f394769a = codedInputByteBufferNano.readInt64();
            } else if (readTag == 16) {
                this.f394770b = codedInputByteBufferNano.readInt64();
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.f394771c == null) {
                    this.f394771c = new bs4.k();
                }
                codedInputByteBufferNano.readMessage(this.f394771c);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.f394769a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(1, j3);
        }
        long j16 = this.f394770b;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(2, j16);
        }
        bs4.k kVar = this.f394771c;
        return kVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(3, kVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f394769a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(1, j3);
        }
        long j16 = this.f394770b;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeInt64(2, j16);
        }
        bs4.k kVar = this.f394771c;
        if (kVar != null) {
            codedOutputByteBufferNano.writeMessage(3, kVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public d a() {
        this.f394769a = 0L;
        this.f394770b = 0L;
        this.f394771c = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
