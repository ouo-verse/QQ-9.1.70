package ds4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class e extends ExtendableMessageNano<e> {

    /* renamed from: a, reason: collision with root package name */
    public long f394772a;

    /* renamed from: b, reason: collision with root package name */
    public long f394773b;

    /* renamed from: c, reason: collision with root package name */
    public long f394774c;

    /* renamed from: d, reason: collision with root package name */
    public bs4.j f394775d;

    public e() {
        a();
    }

    public static e c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (e) MessageNano.mergeFrom(new e(), bArr);
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public e mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f394772a = codedInputByteBufferNano.readInt64();
            } else if (readTag == 16) {
                this.f394773b = codedInputByteBufferNano.readInt64();
            } else if (readTag == 24) {
                this.f394774c = codedInputByteBufferNano.readInt64();
            } else if (readTag != 34) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.f394775d == null) {
                    this.f394775d = new bs4.j();
                }
                codedInputByteBufferNano.readMessage(this.f394775d);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.f394772a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(1, j3);
        }
        long j16 = this.f394773b;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(2, j16);
        }
        long j17 = this.f394774c;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(3, j17);
        }
        bs4.j jVar = this.f394775d;
        return jVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(4, jVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f394772a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(1, j3);
        }
        long j16 = this.f394773b;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeInt64(2, j16);
        }
        long j17 = this.f394774c;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeInt64(3, j17);
        }
        bs4.j jVar = this.f394775d;
        if (jVar != null) {
            codedOutputByteBufferNano.writeMessage(4, jVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public e a() {
        this.f394772a = 0L;
        this.f394773b = 0L;
        this.f394774c = 0L;
        this.f394775d = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
