package lq4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class e extends ExtendableMessageNano<e> {

    /* renamed from: a, reason: collision with root package name */
    public String f415424a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f415425b;

    /* renamed from: c, reason: collision with root package name */
    public int f415426c;

    /* renamed from: d, reason: collision with root package name */
    public byte[] f415427d;

    /* renamed from: e, reason: collision with root package name */
    public b f415428e;

    /* renamed from: f, reason: collision with root package name */
    public byte[] f415429f;

    /* renamed from: g, reason: collision with root package name */
    public int f415430g;

    /* renamed from: h, reason: collision with root package name */
    public a f415431h;

    public e() {
        a();
    }

    public e a() {
        this.f415424a = "";
        byte[] bArr = WireFormatNano.EMPTY_BYTES;
        this.f415425b = bArr;
        this.f415426c = 0;
        this.f415427d = bArr;
        this.f415428e = null;
        this.f415429f = bArr;
        this.f415430g = 0;
        this.f415431h = null;
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
                    if (readTag != 18) {
                        if (readTag != 24) {
                            if (readTag != 34) {
                                if (readTag != 42) {
                                    if (readTag != 50) {
                                        if (readTag != 80) {
                                            if (readTag != 90) {
                                                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                                    return this;
                                                }
                                            } else {
                                                if (this.f415431h == null) {
                                                    this.f415431h = new a();
                                                }
                                                codedInputByteBufferNano.readMessage(this.f415431h);
                                            }
                                        } else {
                                            this.f415430g = codedInputByteBufferNano.readUInt32();
                                        }
                                    } else {
                                        this.f415429f = codedInputByteBufferNano.readBytes();
                                    }
                                } else {
                                    if (this.f415428e == null) {
                                        this.f415428e = new b();
                                    }
                                    codedInputByteBufferNano.readMessage(this.f415428e);
                                }
                            } else {
                                this.f415427d = codedInputByteBufferNano.readBytes();
                            }
                        } else {
                            this.f415426c = codedInputByteBufferNano.readUInt32();
                        }
                    } else {
                        this.f415425b = codedInputByteBufferNano.readBytes();
                    }
                } else {
                    this.f415424a = codedInputByteBufferNano.readString();
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
        if (!this.f415424a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f415424a);
        }
        byte[] bArr = this.f415425b;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(2, this.f415425b);
        }
        int i3 = this.f415426c;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i3);
        }
        if (!Arrays.equals(this.f415427d, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(4, this.f415427d);
        }
        b bVar = this.f415428e;
        if (bVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, bVar);
        }
        if (!Arrays.equals(this.f415429f, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(6, this.f415429f);
        }
        int i16 = this.f415430g;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(10, i16);
        }
        a aVar = this.f415431h;
        if (aVar != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(11, aVar);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f415424a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f415424a);
        }
        byte[] bArr = this.f415425b;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            codedOutputByteBufferNano.writeBytes(2, this.f415425b);
        }
        int i3 = this.f415426c;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i3);
        }
        if (!Arrays.equals(this.f415427d, bArr2)) {
            codedOutputByteBufferNano.writeBytes(4, this.f415427d);
        }
        b bVar = this.f415428e;
        if (bVar != null) {
            codedOutputByteBufferNano.writeMessage(5, bVar);
        }
        if (!Arrays.equals(this.f415429f, bArr2)) {
            codedOutputByteBufferNano.writeBytes(6, this.f415429f);
        }
        int i16 = this.f415430g;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(10, i16);
        }
        a aVar = this.f415431h;
        if (aVar != null) {
            codedOutputByteBufferNano.writeMessage(11, aVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
