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
public final class j extends ExtendableMessageNano<j> {

    /* renamed from: a, reason: collision with root package name */
    public String f403301a;

    /* renamed from: b, reason: collision with root package name */
    public long f403302b;

    /* renamed from: c, reason: collision with root package name */
    public u f403303c;

    public j() {
        a();
    }

    public static j c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (j) MessageNano.mergeFrom(new j(), bArr);
    }

    public j a() {
        this.f403301a = "";
        this.f403302b = 0L;
        this.f403303c = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public j mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f403301a = codedInputByteBufferNano.readString();
            } else if (readTag == 16) {
                this.f403302b = codedInputByteBufferNano.readInt64();
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.f403303c == null) {
                    this.f403303c = new u();
                }
                codedInputByteBufferNano.readMessage(this.f403303c);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f403301a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f403301a);
        }
        long j3 = this.f403302b;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(2, j3);
        }
        u uVar = this.f403303c;
        return uVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(3, uVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f403301a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f403301a);
        }
        long j3 = this.f403302b;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(2, j3);
        }
        u uVar = this.f403303c;
        if (uVar != null) {
            codedOutputByteBufferNano.writeMessage(3, uVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
