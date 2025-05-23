package gr4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class aa extends ExtendableMessageNano<aa> {

    /* renamed from: a, reason: collision with root package name */
    public long f403092a;

    /* renamed from: b, reason: collision with root package name */
    public long f403093b;

    /* renamed from: c, reason: collision with root package name */
    public String f403094c;

    /* renamed from: d, reason: collision with root package name */
    public String f403095d;

    /* renamed from: e, reason: collision with root package name */
    public int f403096e;

    /* renamed from: f, reason: collision with root package name */
    public String f403097f;

    /* renamed from: g, reason: collision with root package name */
    public long f403098g;

    /* renamed from: h, reason: collision with root package name */
    public int f403099h;

    public aa() {
        a();
    }

    public aa a() {
        this.f403092a = 0L;
        this.f403093b = 0L;
        this.f403094c = "";
        this.f403095d = "";
        this.f403096e = 0;
        this.f403097f = "";
        this.f403098g = 0L;
        this.f403099h = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public aa mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 16) {
                        if (readTag != 26) {
                            if (readTag != 34) {
                                if (readTag != 40) {
                                    if (readTag != 50) {
                                        if (readTag != 56) {
                                            if (readTag != 248) {
                                                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                                    return this;
                                                }
                                            } else {
                                                this.f403099h = codedInputByteBufferNano.readUInt32();
                                            }
                                        } else {
                                            this.f403098g = codedInputByteBufferNano.readUInt64();
                                        }
                                    } else {
                                        this.f403097f = codedInputByteBufferNano.readString();
                                    }
                                } else {
                                    this.f403096e = codedInputByteBufferNano.readUInt32();
                                }
                            } else {
                                this.f403095d = codedInputByteBufferNano.readString();
                            }
                        } else {
                            this.f403094c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        this.f403093b = codedInputByteBufferNano.readInt64();
                    }
                } else {
                    this.f403092a = codedInputByteBufferNano.readUInt64();
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
        long j3 = this.f403092a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        long j16 = this.f403093b;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(2, j16);
        }
        if (!this.f403094c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f403094c);
        }
        if (!this.f403095d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f403095d);
        }
        int i3 = this.f403096e;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i3);
        }
        if (!this.f403097f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f403097f);
        }
        long j17 = this.f403098g;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(7, j17);
        }
        int i16 = this.f403099h;
        if (i16 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(31, i16);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f403092a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        long j16 = this.f403093b;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeInt64(2, j16);
        }
        if (!this.f403094c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f403094c);
        }
        if (!this.f403095d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f403095d);
        }
        int i3 = this.f403096e;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i3);
        }
        if (!this.f403097f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f403097f);
        }
        long j17 = this.f403098g;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeUInt64(7, j17);
        }
        int i16 = this.f403099h;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(31, i16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
