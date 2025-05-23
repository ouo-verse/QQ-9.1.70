package fu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class af extends ExtendableMessageNano<af> {

    /* renamed from: a, reason: collision with root package name */
    public long f400663a;

    /* renamed from: b, reason: collision with root package name */
    public int f400664b;

    /* renamed from: c, reason: collision with root package name */
    public int f400665c;

    /* renamed from: d, reason: collision with root package name */
    public int f400666d;

    /* renamed from: e, reason: collision with root package name */
    public byte[] f400667e;

    /* renamed from: f, reason: collision with root package name */
    public int f400668f;

    /* renamed from: g, reason: collision with root package name */
    public byte[] f400669g;

    /* renamed from: h, reason: collision with root package name */
    public byte[] f400670h;

    /* renamed from: i, reason: collision with root package name */
    public byte[] f400671i;

    public af() {
        a();
    }

    public af a() {
        this.f400663a = 0L;
        this.f400664b = 0;
        this.f400665c = 0;
        this.f400666d = 0;
        byte[] bArr = WireFormatNano.EMPTY_BYTES;
        this.f400667e = bArr;
        this.f400668f = 0;
        this.f400669g = bArr;
        this.f400670h = bArr;
        this.f400671i = bArr;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public af mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 16) {
                        if (readTag != 24) {
                            if (readTag != 32) {
                                if (readTag != 42) {
                                    if (readTag != 48) {
                                        if (readTag != 90) {
                                            if (readTag != 98) {
                                                if (readTag != 106) {
                                                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                                        return this;
                                                    }
                                                } else {
                                                    this.f400671i = codedInputByteBufferNano.readBytes();
                                                }
                                            } else {
                                                this.f400670h = codedInputByteBufferNano.readBytes();
                                            }
                                        } else {
                                            this.f400669g = codedInputByteBufferNano.readBytes();
                                        }
                                    } else {
                                        this.f400668f = codedInputByteBufferNano.readUInt32();
                                    }
                                } else {
                                    this.f400667e = codedInputByteBufferNano.readBytes();
                                }
                            } else {
                                this.f400666d = codedInputByteBufferNano.readUInt32();
                            }
                        } else {
                            int readInt32 = codedInputByteBufferNano.readInt32();
                            if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2 || readInt32 == 3) {
                                this.f400665c = readInt32;
                            }
                        }
                    } else {
                        int readInt322 = codedInputByteBufferNano.readInt32();
                        if (readInt322 == 0 || readInt322 == 1 || readInt322 == 2 || readInt322 == 3 || readInt322 == 4 || readInt322 == 5) {
                            this.f400664b = readInt322;
                        }
                    }
                } else {
                    this.f400663a = codedInputByteBufferNano.readUInt64();
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
        long j3 = this.f400663a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        int i3 = this.f400664b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i3);
        }
        int i16 = this.f400665c;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i16);
        }
        int i17 = this.f400666d;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i17);
        }
        byte[] bArr = this.f400667e;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(5, this.f400667e);
        }
        int i18 = this.f400668f;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i18);
        }
        if (!Arrays.equals(this.f400669g, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(11, this.f400669g);
        }
        if (!Arrays.equals(this.f400670h, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(12, this.f400670h);
        }
        if (!Arrays.equals(this.f400671i, bArr2)) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeBytesSize(13, this.f400671i);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f400663a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        int i3 = this.f400664b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i3);
        }
        int i16 = this.f400665c;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(3, i16);
        }
        int i17 = this.f400666d;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i17);
        }
        byte[] bArr = this.f400667e;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            codedOutputByteBufferNano.writeBytes(5, this.f400667e);
        }
        int i18 = this.f400668f;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i18);
        }
        if (!Arrays.equals(this.f400669g, bArr2)) {
            codedOutputByteBufferNano.writeBytes(11, this.f400669g);
        }
        if (!Arrays.equals(this.f400670h, bArr2)) {
            codedOutputByteBufferNano.writeBytes(12, this.f400670h);
        }
        if (!Arrays.equals(this.f400671i, bArr2)) {
            codedOutputByteBufferNano.writeBytes(13, this.f400671i);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
