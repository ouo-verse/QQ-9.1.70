package cp4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class k extends ExtendableMessageNano<k> {

    /* renamed from: a, reason: collision with root package name */
    public long f391615a;

    /* renamed from: b, reason: collision with root package name */
    public long f391616b;

    /* renamed from: c, reason: collision with root package name */
    public String f391617c;

    /* renamed from: d, reason: collision with root package name */
    public long f391618d;

    /* renamed from: e, reason: collision with root package name */
    public String f391619e;

    public k() {
        a();
    }

    public k a() {
        this.f391615a = 0L;
        this.f391616b = 0L;
        this.f391617c = "";
        this.f391618d = 0L;
        this.f391619e = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public k mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 16) {
                        if (readTag != 26) {
                            if (readTag != 32) {
                                if (readTag != 42) {
                                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                        return this;
                                    }
                                } else {
                                    this.f391619e = codedInputByteBufferNano.readString();
                                }
                            } else {
                                this.f391618d = codedInputByteBufferNano.readUInt64();
                            }
                        } else {
                            this.f391617c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        this.f391616b = codedInputByteBufferNano.readUInt64();
                    }
                } else {
                    this.f391615a = codedInputByteBufferNano.readUInt64();
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
        long j3 = this.f391615a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        long j16 = this.f391616b;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j16);
        }
        if (!this.f391617c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f391617c);
        }
        long j17 = this.f391618d;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j17);
        }
        if (!this.f391619e.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(5, this.f391619e);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f391615a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        long j16 = this.f391616b;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j16);
        }
        if (!this.f391617c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f391617c);
        }
        long j17 = this.f391618d;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j17);
        }
        if (!this.f391619e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f391619e);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
