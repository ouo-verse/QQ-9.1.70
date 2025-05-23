package g55;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class t extends ExtendableMessageNano<t> {

    /* renamed from: a, reason: collision with root package name */
    public long f401391a;

    /* renamed from: b, reason: collision with root package name */
    public String f401392b;

    /* renamed from: c, reason: collision with root package name */
    public int f401393c;

    public t() {
        a();
    }

    public t a() {
        this.f401391a = 0L;
        this.f401392b = "";
        this.f401393c = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public t mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 18) {
                        if (readTag != 24) {
                            if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                return this;
                            }
                        } else {
                            this.f401393c = codedInputByteBufferNano.readUInt32();
                        }
                    } else {
                        this.f401392b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f401391a = codedInputByteBufferNano.readUInt64();
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
        long j3 = this.f401391a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        if (!this.f401392b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f401392b);
        }
        int i3 = this.f401393c;
        if (i3 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(3, i3);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f401391a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        if (!this.f401392b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f401392b);
        }
        int i3 = this.f401393c;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
