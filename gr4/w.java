package gr4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class w extends ExtendableMessageNano<w> {

    /* renamed from: a, reason: collision with root package name */
    public long f403230a;

    /* renamed from: b, reason: collision with root package name */
    public long f403231b;

    /* renamed from: c, reason: collision with root package name */
    public String f403232c;

    /* renamed from: d, reason: collision with root package name */
    public String f403233d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f403234e;

    /* renamed from: f, reason: collision with root package name */
    public long f403235f;

    /* renamed from: g, reason: collision with root package name */
    public long f403236g;

    public w() {
        a();
    }

    public w a() {
        this.f403230a = 0L;
        this.f403231b = 0L;
        this.f403232c = "";
        this.f403233d = "";
        this.f403234e = false;
        this.f403235f = 0L;
        this.f403236g = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public w mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 16) {
                        if (readTag != 26) {
                            if (readTag != 34) {
                                if (readTag != 40) {
                                    if (readTag != 48) {
                                        if (readTag != 56) {
                                            if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                                return this;
                                            }
                                        } else {
                                            this.f403236g = codedInputByteBufferNano.readUInt64();
                                        }
                                    } else {
                                        this.f403235f = codedInputByteBufferNano.readUInt64();
                                    }
                                } else {
                                    this.f403234e = codedInputByteBufferNano.readBool();
                                }
                            } else {
                                this.f403233d = codedInputByteBufferNano.readString();
                            }
                        } else {
                            this.f403232c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        this.f403231b = codedInputByteBufferNano.readUInt64();
                    }
                } else {
                    this.f403230a = codedInputByteBufferNano.readUInt64();
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
        long j3 = this.f403230a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        long j16 = this.f403231b;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j16);
        }
        if (!this.f403232c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f403232c);
        }
        if (!this.f403233d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f403233d);
        }
        boolean z16 = this.f403234e;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(5, z16);
        }
        long j17 = this.f403235f;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j17);
        }
        long j18 = this.f403236g;
        if (j18 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(7, j18);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f403230a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        long j16 = this.f403231b;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j16);
        }
        if (!this.f403232c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f403232c);
        }
        if (!this.f403233d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f403233d);
        }
        boolean z16 = this.f403234e;
        if (z16) {
            codedOutputByteBufferNano.writeBool(5, z16);
        }
        long j17 = this.f403235f;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeUInt64(6, j17);
        }
        long j18 = this.f403236g;
        if (j18 != 0) {
            codedOutputByteBufferNano.writeUInt64(7, j18);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
