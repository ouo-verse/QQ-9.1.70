package gs4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import fs4.u;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class k extends ExtendableMessageNano<k> {

    /* renamed from: a, reason: collision with root package name */
    public String f403304a;

    /* renamed from: b, reason: collision with root package name */
    public long f403305b;

    /* renamed from: c, reason: collision with root package name */
    public u f403306c;

    /* renamed from: d, reason: collision with root package name */
    public long f403307d;

    /* renamed from: e, reason: collision with root package name */
    public String f403308e;

    public k() {
        a();
    }

    public static k c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (k) MessageNano.mergeFrom(new k(), bArr);
    }

    public k a() {
        this.f403304a = "";
        this.f403305b = 0L;
        this.f403306c = null;
        this.f403307d = 0L;
        this.f403308e = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public k mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f403304a = codedInputByteBufferNano.readString();
            } else if (readTag == 16) {
                this.f403305b = codedInputByteBufferNano.readInt64();
            } else if (readTag == 26) {
                if (this.f403306c == null) {
                    this.f403306c = new u();
                }
                codedInputByteBufferNano.readMessage(this.f403306c);
            } else if (readTag == 32) {
                this.f403307d = codedInputByteBufferNano.readInt64();
            } else if (readTag != 42) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f403308e = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f403304a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f403304a);
        }
        long j3 = this.f403305b;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(2, j3);
        }
        u uVar = this.f403306c;
        if (uVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, uVar);
        }
        long j16 = this.f403307d;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(4, j16);
        }
        return !this.f403308e.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(5, this.f403308e) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f403304a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f403304a);
        }
        long j3 = this.f403305b;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(2, j3);
        }
        u uVar = this.f403306c;
        if (uVar != null) {
            codedOutputByteBufferNano.writeMessage(3, uVar);
        }
        long j16 = this.f403307d;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeInt64(4, j16);
        }
        if (!this.f403308e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f403308e);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
