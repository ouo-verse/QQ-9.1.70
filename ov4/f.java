package ov4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class f extends ExtendableMessageNano<f> {

    /* renamed from: a, reason: collision with root package name */
    public String f424156a;

    /* renamed from: b, reason: collision with root package name */
    public l f424157b;

    /* renamed from: c, reason: collision with root package name */
    public q f424158c;

    public f() {
        a();
    }

    public static f c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (f) MessageNano.mergeFrom(new f(), bArr);
    }

    public f a() {
        this.f424156a = "";
        this.f424157b = null;
        this.f424158c = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public f mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f424156a = codedInputByteBufferNano.readString();
            } else if (readTag == 18) {
                if (this.f424157b == null) {
                    this.f424157b = new l();
                }
                codedInputByteBufferNano.readMessage(this.f424157b);
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.f424158c == null) {
                    this.f424158c = new q();
                }
                codedInputByteBufferNano.readMessage(this.f424158c);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f424156a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f424156a);
        }
        l lVar = this.f424157b;
        if (lVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, lVar);
        }
        q qVar = this.f424158c;
        return qVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(3, qVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f424156a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f424156a);
        }
        l lVar = this.f424157b;
        if (lVar != null) {
            codedOutputByteBufferNano.writeMessage(2, lVar);
        }
        q qVar = this.f424158c;
        if (qVar != null) {
            codedOutputByteBufferNano.writeMessage(3, qVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
