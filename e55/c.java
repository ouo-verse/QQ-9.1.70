package e55;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class c extends ExtendableMessageNano<c> {

    /* renamed from: a, reason: collision with root package name */
    public long f395735a;

    /* renamed from: b, reason: collision with root package name */
    public long f395736b;

    /* renamed from: c, reason: collision with root package name */
    public String f395737c;

    /* renamed from: d, reason: collision with root package name */
    public String f395738d;

    public c() {
        a();
    }

    public c a() {
        this.f395735a = 0L;
        this.f395736b = 0L;
        this.f395737c = "";
        this.f395738d = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public c mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 16) {
                        if (readTag != 26) {
                            if (readTag != 34) {
                                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                    return this;
                                }
                            } else {
                                this.f395738d = codedInputByteBufferNano.readString();
                            }
                        } else {
                            this.f395737c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        this.f395736b = codedInputByteBufferNano.readUInt64();
                    }
                } else {
                    this.f395735a = codedInputByteBufferNano.readUInt64();
                }
            } else {
                return this;
            }
        }
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    protected int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.f395735a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        long j16 = this.f395736b;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j16);
        }
        if (!this.f395737c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f395737c);
        }
        if (!this.f395738d.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, this.f395738d);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f395735a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        long j16 = this.f395736b;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j16);
        }
        if (!this.f395737c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f395737c);
        }
        if (!this.f395738d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f395738d);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
