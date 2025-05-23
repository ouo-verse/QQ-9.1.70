package lv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class h extends ExtendableMessageNano<h> {

    /* renamed from: a, reason: collision with root package name */
    public iv4.f f415649a;

    /* renamed from: b, reason: collision with root package name */
    public iv4.l f415650b;

    /* renamed from: c, reason: collision with root package name */
    public long f415651c;

    public h() {
        a();
    }

    public static h c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (h) MessageNano.mergeFrom(new h(), bArr);
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public h mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                if (this.f415649a == null) {
                    this.f415649a = new iv4.f();
                }
                codedInputByteBufferNano.readMessage(this.f415649a);
            } else if (readTag == 18) {
                if (this.f415650b == null) {
                    this.f415650b = new iv4.l();
                }
                codedInputByteBufferNano.readMessage(this.f415650b);
            } else if (readTag != 24) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f415651c = codedInputByteBufferNano.readUInt64();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        iv4.f fVar = this.f415649a;
        if (fVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, fVar);
        }
        iv4.l lVar = this.f415650b;
        if (lVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, lVar);
        }
        long j3 = this.f415651c;
        return j3 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(3, j3) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        iv4.f fVar = this.f415649a;
        if (fVar != null) {
            codedOutputByteBufferNano.writeMessage(1, fVar);
        }
        iv4.l lVar = this.f415650b;
        if (lVar != null) {
            codedOutputByteBufferNano.writeMessage(2, lVar);
        }
        long j3 = this.f415651c;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public h a() {
        this.f415649a = null;
        this.f415650b = null;
        this.f415651c = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
