package nr4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class e extends ExtendableMessageNano<e> {

    /* renamed from: a, reason: collision with root package name */
    public String f421219a;

    /* renamed from: b, reason: collision with root package name */
    public int f421220b;

    /* renamed from: c, reason: collision with root package name */
    public int f421221c;

    /* renamed from: d, reason: collision with root package name */
    public int f421222d;

    /* renamed from: e, reason: collision with root package name */
    public int f421223e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f421224f;

    /* renamed from: g, reason: collision with root package name */
    public long f421225g;

    /* renamed from: h, reason: collision with root package name */
    public String f421226h;

    public e() {
        a();
    }

    public e a() {
        this.f421219a = "";
        this.f421220b = 0;
        this.f421221c = 0;
        this.f421222d = 0;
        this.f421223e = 0;
        this.f421224f = false;
        this.f421225g = 0L;
        this.f421226h = "";
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
                if (readTag != 10) {
                    if (readTag != 16) {
                        if (readTag != 24) {
                            if (readTag != 32) {
                                if (readTag != 40) {
                                    if (readTag != 48) {
                                        if (readTag != 56) {
                                            if (readTag != 66) {
                                                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                                    return this;
                                                }
                                            } else {
                                                this.f421226h = codedInputByteBufferNano.readString();
                                            }
                                        } else {
                                            this.f421225g = codedInputByteBufferNano.readUInt64();
                                        }
                                    } else {
                                        this.f421224f = codedInputByteBufferNano.readBool();
                                    }
                                } else {
                                    this.f421223e = codedInputByteBufferNano.readUInt32();
                                }
                            } else {
                                this.f421222d = codedInputByteBufferNano.readUInt32();
                            }
                        } else {
                            this.f421221c = codedInputByteBufferNano.readUInt32();
                        }
                    } else {
                        this.f421220b = codedInputByteBufferNano.readUInt32();
                    }
                } else {
                    this.f421219a = codedInputByteBufferNano.readString();
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
        if (!this.f421219a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f421219a);
        }
        int i3 = this.f421220b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        int i16 = this.f421221c;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i16);
        }
        int i17 = this.f421222d;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i17);
        }
        int i18 = this.f421223e;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i18);
        }
        boolean z16 = this.f421224f;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(6, z16);
        }
        long j3 = this.f421225g;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(7, j3);
        }
        if (!this.f421226h.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(8, this.f421226h);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f421219a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f421219a);
        }
        int i3 = this.f421220b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        int i16 = this.f421221c;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i16);
        }
        int i17 = this.f421222d;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i17);
        }
        int i18 = this.f421223e;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i18);
        }
        boolean z16 = this.f421224f;
        if (z16) {
            codedOutputByteBufferNano.writeBool(6, z16);
        }
        long j3 = this.f421225g;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(7, j3);
        }
        if (!this.f421226h.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.f421226h);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
