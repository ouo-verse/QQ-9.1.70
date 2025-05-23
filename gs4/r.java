package gs4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class r extends ExtendableMessageNano<r> {

    /* renamed from: a, reason: collision with root package name */
    public long f403332a;

    /* renamed from: b, reason: collision with root package name */
    public long f403333b;

    /* renamed from: c, reason: collision with root package name */
    public long f403334c;

    /* renamed from: d, reason: collision with root package name */
    public fs4.t f403335d;

    /* renamed from: e, reason: collision with root package name */
    public fs4.k f403336e;

    public r() {
        a();
    }

    public static r c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (r) MessageNano.mergeFrom(new r(), bArr);
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public r mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f403332a = codedInputByteBufferNano.readInt64();
            } else if (readTag == 16) {
                this.f403333b = codedInputByteBufferNano.readInt64();
            } else if (readTag == 24) {
                this.f403334c = codedInputByteBufferNano.readInt64();
            } else if (readTag == 34) {
                if (this.f403335d == null) {
                    this.f403335d = new fs4.t();
                }
                codedInputByteBufferNano.readMessage(this.f403335d);
            } else if (readTag != 42) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.f403336e == null) {
                    this.f403336e = new fs4.k();
                }
                codedInputByteBufferNano.readMessage(this.f403336e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.f403332a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(1, j3);
        }
        long j16 = this.f403333b;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(2, j16);
        }
        long j17 = this.f403334c;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(3, j17);
        }
        fs4.t tVar = this.f403335d;
        if (tVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, tVar);
        }
        fs4.k kVar = this.f403336e;
        return kVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(5, kVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f403332a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(1, j3);
        }
        long j16 = this.f403333b;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeInt64(2, j16);
        }
        long j17 = this.f403334c;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeInt64(3, j17);
        }
        fs4.t tVar = this.f403335d;
        if (tVar != null) {
            codedOutputByteBufferNano.writeMessage(4, tVar);
        }
        fs4.k kVar = this.f403336e;
        if (kVar != null) {
            codedOutputByteBufferNano.writeMessage(5, kVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public r a() {
        this.f403332a = 0L;
        this.f403333b = 0L;
        this.f403334c = 0L;
        this.f403335d = null;
        this.f403336e = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
