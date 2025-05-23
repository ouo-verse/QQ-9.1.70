package fu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class ab extends ExtendableMessageNano<ab> {

    /* renamed from: a, reason: collision with root package name */
    public int f400650a;

    /* renamed from: b, reason: collision with root package name */
    public String f400651b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f400652c;

    /* renamed from: d, reason: collision with root package name */
    public byte[] f400653d;

    /* renamed from: e, reason: collision with root package name */
    public int f400654e;

    /* renamed from: f, reason: collision with root package name */
    public int f400655f;

    /* renamed from: g, reason: collision with root package name */
    public int f400656g;

    public ab() {
        a();
    }

    public ab a() {
        this.f400650a = 0;
        this.f400651b = "";
        byte[] bArr = WireFormatNano.EMPTY_BYTES;
        this.f400652c = bArr;
        this.f400653d = bArr;
        this.f400654e = 0;
        this.f400655f = 0;
        this.f400656g = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ab mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 18) {
                        if (readTag != 90) {
                            if (readTag != 98) {
                                if (readTag != 8008) {
                                    if (readTag != 8016) {
                                        if (readTag != 8024) {
                                            if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                                return this;
                                            }
                                        } else {
                                            this.f400656g = codedInputByteBufferNano.readUInt32();
                                        }
                                    } else {
                                        int readInt32 = codedInputByteBufferNano.readInt32();
                                        if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2 || readInt32 == 3 || readInt32 == 4 || readInt32 == 5) {
                                            this.f400655f = readInt32;
                                        }
                                    }
                                } else {
                                    int readInt322 = codedInputByteBufferNano.readInt32();
                                    if (readInt322 == 0 || readInt322 == 1 || readInt322 == 2 || readInt322 == 3 || readInt322 == 4 || readInt322 == 5) {
                                        this.f400654e = readInt322;
                                    }
                                }
                            } else {
                                this.f400653d = codedInputByteBufferNano.readBytes();
                            }
                        } else {
                            this.f400652c = codedInputByteBufferNano.readBytes();
                        }
                    } else {
                        this.f400651b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f400650a = codedInputByteBufferNano.readUInt32();
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
        int i3 = this.f400650a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        if (!this.f400651b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f400651b);
        }
        byte[] bArr = this.f400652c;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(11, this.f400652c);
        }
        if (!Arrays.equals(this.f400653d, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(12, this.f400653d);
        }
        int i16 = this.f400654e;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1001, i16);
        }
        int i17 = this.f400655f;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1002, i17);
        }
        int i18 = this.f400656g;
        if (i18 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(1003, i18);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f400650a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        if (!this.f400651b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f400651b);
        }
        byte[] bArr = this.f400652c;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            codedOutputByteBufferNano.writeBytes(11, this.f400652c);
        }
        if (!Arrays.equals(this.f400653d, bArr2)) {
            codedOutputByteBufferNano.writeBytes(12, this.f400653d);
        }
        int i16 = this.f400654e;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(1001, i16);
        }
        int i17 = this.f400655f;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(1002, i17);
        }
        int i18 = this.f400656g;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(1003, i18);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
