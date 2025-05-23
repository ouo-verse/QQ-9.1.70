package g55;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ax extends ExtendableMessageNano<ax> {

    /* renamed from: a, reason: collision with root package name */
    public ag f401344a;

    /* renamed from: b, reason: collision with root package name */
    public long f401345b;

    public ax() {
        a();
    }

    public static ax c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (ax) MessageNano.mergeFrom(new ax(), bArr);
    }

    public ax a() {
        this.f401344a = null;
        this.f401345b = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ax mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 16) {
                        if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                    } else {
                        this.f401345b = codedInputByteBufferNano.readInt64();
                    }
                } else {
                    if (this.f401344a == null) {
                        this.f401344a = new ag();
                    }
                    codedInputByteBufferNano.readMessage(this.f401344a);
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
        ag agVar = this.f401344a;
        if (agVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, agVar);
        }
        long j3 = this.f401345b;
        if (j3 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeInt64Size(2, j3);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        ag agVar = this.f401344a;
        if (agVar != null) {
            codedOutputByteBufferNano.writeMessage(1, agVar);
        }
        long j3 = this.f401345b;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(2, j3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
