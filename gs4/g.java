package gs4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class g extends ExtendableMessageNano<g> {

    /* renamed from: a, reason: collision with root package name */
    public long f403292a;

    /* renamed from: b, reason: collision with root package name */
    public long f403293b;

    /* renamed from: c, reason: collision with root package name */
    public long f403294c;

    /* renamed from: d, reason: collision with root package name */
    public fs4.t f403295d;

    public g() {
        a();
    }

    public static g c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (g) MessageNano.mergeFrom(new g(), bArr);
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public g mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f403292a = codedInputByteBufferNano.readInt64();
            } else if (readTag == 16) {
                this.f403293b = codedInputByteBufferNano.readInt64();
            } else if (readTag == 24) {
                this.f403294c = codedInputByteBufferNano.readInt64();
            } else if (readTag != 34) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.f403295d == null) {
                    this.f403295d = new fs4.t();
                }
                codedInputByteBufferNano.readMessage(this.f403295d);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.f403292a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(1, j3);
        }
        long j16 = this.f403293b;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(2, j16);
        }
        long j17 = this.f403294c;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(3, j17);
        }
        fs4.t tVar = this.f403295d;
        return tVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(4, tVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f403292a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(1, j3);
        }
        long j16 = this.f403293b;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeInt64(2, j16);
        }
        long j17 = this.f403294c;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeInt64(3, j17);
        }
        fs4.t tVar = this.f403295d;
        if (tVar != null) {
            codedOutputByteBufferNano.writeMessage(4, tVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public g a() {
        this.f403292a = 0L;
        this.f403293b = 0L;
        this.f403294c = 0L;
        this.f403295d = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
