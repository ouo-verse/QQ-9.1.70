package gr4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class d extends ExtendableMessageNano<d> {

    /* renamed from: a, reason: collision with root package name */
    public long f403103a;

    /* renamed from: b, reason: collision with root package name */
    public String f403104b;

    /* renamed from: c, reason: collision with root package name */
    public String f403105c;

    /* renamed from: d, reason: collision with root package name */
    public String f403106d;

    /* renamed from: e, reason: collision with root package name */
    public long f403107e;

    /* renamed from: f, reason: collision with root package name */
    public byte[] f403108f;

    /* renamed from: g, reason: collision with root package name */
    public String f403109g;

    /* renamed from: h, reason: collision with root package name */
    public int f403110h;

    public d() {
        a();
    }

    public d a() {
        this.f403103a = 0L;
        this.f403104b = "";
        this.f403105c = "";
        this.f403106d = "";
        this.f403107e = 0L;
        this.f403108f = WireFormatNano.EMPTY_BYTES;
        this.f403109g = "";
        this.f403110h = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public d mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 18) {
                        if (readTag != 26) {
                            if (readTag != 34) {
                                if (readTag != 40) {
                                    if (readTag != 50) {
                                        if (readTag != 58) {
                                            if (readTag != 64) {
                                                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                                    return this;
                                                }
                                            } else {
                                                int readInt32 = codedInputByteBufferNano.readInt32();
                                                if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2 || readInt32 == 3) {
                                                    this.f403110h = readInt32;
                                                }
                                            }
                                        } else {
                                            this.f403109g = codedInputByteBufferNano.readString();
                                        }
                                    } else {
                                        this.f403108f = codedInputByteBufferNano.readBytes();
                                    }
                                } else {
                                    this.f403107e = codedInputByteBufferNano.readUInt64();
                                }
                            } else {
                                this.f403106d = codedInputByteBufferNano.readString();
                            }
                        } else {
                            this.f403105c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        this.f403104b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f403103a = codedInputByteBufferNano.readUInt64();
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
        long j3 = this.f403103a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        if (!this.f403104b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f403104b);
        }
        if (!this.f403105c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f403105c);
        }
        if (!this.f403106d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f403106d);
        }
        long j16 = this.f403107e;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j16);
        }
        if (!Arrays.equals(this.f403108f, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(6, this.f403108f);
        }
        if (!this.f403109g.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.f403109g);
        }
        int i3 = this.f403110h;
        if (i3 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(8, i3);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f403103a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        if (!this.f403104b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f403104b);
        }
        if (!this.f403105c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f403105c);
        }
        if (!this.f403106d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f403106d);
        }
        long j16 = this.f403107e;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j16);
        }
        if (!Arrays.equals(this.f403108f, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(6, this.f403108f);
        }
        if (!this.f403109g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f403109g);
        }
        int i3 = this.f403110h;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(8, i3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
