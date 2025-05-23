package jr4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class e extends ExtendableMessageNano<e> {

    /* renamed from: a, reason: collision with root package name */
    public long f410892a;

    /* renamed from: b, reason: collision with root package name */
    public long f410893b;

    /* renamed from: c, reason: collision with root package name */
    public String f410894c;

    /* renamed from: d, reason: collision with root package name */
    public String f410895d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f410896e;

    /* renamed from: f, reason: collision with root package name */
    public long f410897f;

    /* renamed from: g, reason: collision with root package name */
    public long f410898g;

    public e() {
        a();
    }

    public e a() {
        this.f410892a = 0L;
        this.f410893b = 0L;
        this.f410894c = "";
        this.f410895d = "";
        this.f410896e = false;
        this.f410897f = 0L;
        this.f410898g = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public e mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                                            this.f410898g = codedInputByteBufferNano.readUInt64();
                                        }
                                    } else {
                                        this.f410897f = codedInputByteBufferNano.readUInt64();
                                    }
                                } else {
                                    this.f410896e = codedInputByteBufferNano.readBool();
                                }
                            } else {
                                this.f410895d = codedInputByteBufferNano.readString();
                            }
                        } else {
                            this.f410894c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        this.f410893b = codedInputByteBufferNano.readUInt64();
                    }
                } else {
                    this.f410892a = codedInputByteBufferNano.readUInt64();
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
        long j3 = this.f410892a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        long j16 = this.f410893b;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j16);
        }
        if (!this.f410894c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f410894c);
        }
        if (!this.f410895d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f410895d);
        }
        boolean z16 = this.f410896e;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(5, z16);
        }
        long j17 = this.f410897f;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j17);
        }
        long j18 = this.f410898g;
        if (j18 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(7, j18);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f410892a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        long j16 = this.f410893b;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j16);
        }
        if (!this.f410894c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f410894c);
        }
        if (!this.f410895d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f410895d);
        }
        boolean z16 = this.f410896e;
        if (z16) {
            codedOutputByteBufferNano.writeBool(5, z16);
        }
        long j17 = this.f410897f;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeUInt64(6, j17);
        }
        long j18 = this.f410898g;
        if (j18 != 0) {
            codedOutputByteBufferNano.writeUInt64(7, j18);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
