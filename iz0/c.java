package iz0;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class c extends ExtendableMessageNano<c> {

    /* renamed from: a, reason: collision with root package name */
    public int f409018a;

    /* renamed from: b, reason: collision with root package name */
    public String f409019b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f409020c;

    /* renamed from: d, reason: collision with root package name */
    public int f409021d;

    /* renamed from: e, reason: collision with root package name */
    public int f409022e;

    /* renamed from: f, reason: collision with root package name */
    public int f409023f;

    /* renamed from: g, reason: collision with root package name */
    public String f409024g;

    public c() {
        a();
    }

    public static c c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (c) MessageNano.mergeFrom(new c(), bArr);
    }

    public c a() {
        this.f409018a = 0;
        this.f409019b = "";
        this.f409020c = WireFormatNano.EMPTY_BYTES;
        this.f409021d = 0;
        this.f409022e = 0;
        this.f409023f = 0;
        this.f409024g = "";
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
                    if (readTag != 18) {
                        if (readTag != 26) {
                            if (readTag != 32) {
                                if (readTag != 40) {
                                    if (readTag != 48) {
                                        if (readTag != 58) {
                                            if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                                return this;
                                            }
                                        } else {
                                            this.f409024g = codedInputByteBufferNano.readString();
                                        }
                                    } else {
                                        this.f409023f = codedInputByteBufferNano.readUInt32();
                                    }
                                } else {
                                    this.f409022e = codedInputByteBufferNano.readUInt32();
                                }
                            } else {
                                this.f409021d = codedInputByteBufferNano.readUInt32();
                            }
                        } else {
                            this.f409020c = codedInputByteBufferNano.readBytes();
                        }
                    } else {
                        this.f409019b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f409018a = codedInputByteBufferNano.readUInt32();
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
        int i3 = this.f409018a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        if (!this.f409019b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f409019b);
        }
        if (!Arrays.equals(this.f409020c, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(3, this.f409020c);
        }
        int i16 = this.f409021d;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i16);
        }
        int i17 = this.f409022e;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i17);
        }
        int i18 = this.f409023f;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i18);
        }
        if (!this.f409024g.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(7, this.f409024g);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f409018a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        if (!this.f409019b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f409019b);
        }
        if (!Arrays.equals(this.f409020c, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(3, this.f409020c);
        }
        int i16 = this.f409021d;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i16);
        }
        int i17 = this.f409022e;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i17);
        }
        int i18 = this.f409023f;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i18);
        }
        if (!this.f409024g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f409024g);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
