package fu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class o extends ExtendableMessageNano<o> {

    /* renamed from: a, reason: collision with root package name */
    public String f400793a;

    /* renamed from: b, reason: collision with root package name */
    public long f400794b;

    /* renamed from: c, reason: collision with root package name */
    public k f400795c;

    /* renamed from: d, reason: collision with root package name */
    public int f400796d;

    public o() {
        a();
    }

    public o a() {
        this.f400793a = "";
        this.f400794b = 0L;
        this.f400795c = null;
        this.f400796d = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public o mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 16) {
                        if (readTag != 26) {
                            if (readTag != 32) {
                                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                    return this;
                                }
                            } else {
                                this.f400796d = codedInputByteBufferNano.readUInt32();
                            }
                        } else {
                            if (this.f400795c == null) {
                                this.f400795c = new k();
                            }
                            codedInputByteBufferNano.readMessage(this.f400795c);
                        }
                    } else {
                        this.f400794b = codedInputByteBufferNano.readInt64();
                    }
                } else {
                    this.f400793a = codedInputByteBufferNano.readString();
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
        if (!this.f400793a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f400793a);
        }
        long j3 = this.f400794b;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(2, j3);
        }
        k kVar = this.f400795c;
        if (kVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, kVar);
        }
        int i3 = this.f400796d;
        if (i3 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(4, i3);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f400793a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f400793a);
        }
        long j3 = this.f400794b;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(2, j3);
        }
        k kVar = this.f400795c;
        if (kVar != null) {
            codedOutputByteBufferNano.writeMessage(3, kVar);
        }
        int i3 = this.f400796d;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
