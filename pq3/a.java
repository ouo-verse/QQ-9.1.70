package pq3;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: a, reason: collision with root package name */
    public long f426998a;

    /* renamed from: b, reason: collision with root package name */
    public long f426999b;

    /* renamed from: c, reason: collision with root package name */
    public long f427000c;

    /* renamed from: d, reason: collision with root package name */
    public long f427001d;

    /* renamed from: e, reason: collision with root package name */
    public long f427002e;

    /* renamed from: f, reason: collision with root package name */
    public long f427003f;

    /* renamed from: g, reason: collision with root package name */
    public int f427004g;

    /* renamed from: h, reason: collision with root package name */
    public String f427005h;

    /* renamed from: i, reason: collision with root package name */
    public String f427006i;

    /* renamed from: j, reason: collision with root package name */
    public int f427007j;

    /* renamed from: k, reason: collision with root package name */
    public int f427008k;

    public a() {
        a();
    }

    public a a() {
        this.f426998a = 0L;
        this.f426999b = 0L;
        this.f427000c = 0L;
        this.f427001d = 0L;
        this.f427002e = 0L;
        this.f427003f = 0L;
        this.f427004g = 0;
        this.f427005h = "";
        this.f427006i = "";
        this.f427007j = 0;
        this.f427008k = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.f426998a = codedInputByteBufferNano.readUInt64();
                    break;
                case 16:
                    this.f426999b = codedInputByteBufferNano.readUInt64();
                    break;
                case 24:
                    this.f427000c = codedInputByteBufferNano.readUInt64();
                    break;
                case 32:
                    this.f427001d = codedInputByteBufferNano.readUInt64();
                    break;
                case 40:
                    this.f427002e = codedInputByteBufferNano.readUInt64();
                    break;
                case 48:
                    this.f427003f = codedInputByteBufferNano.readUInt64();
                    break;
                case 56:
                    this.f427004g = codedInputByteBufferNano.readUInt32();
                    break;
                case 66:
                    this.f427005h = codedInputByteBufferNano.readString();
                    break;
                case 74:
                    this.f427006i = codedInputByteBufferNano.readString();
                    break;
                case 80:
                    this.f427007j = codedInputByteBufferNano.readUInt32();
                    break;
                case 88:
                    this.f427008k = codedInputByteBufferNano.readUInt32();
                    break;
                default:
                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.f426998a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        long j16 = this.f426999b;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j16);
        }
        long j17 = this.f427000c;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j17);
        }
        long j18 = this.f427001d;
        if (j18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j18);
        }
        long j19 = this.f427002e;
        if (j19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j19);
        }
        long j26 = this.f427003f;
        if (j26 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j26);
        }
        int i3 = this.f427004g;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(7, i3);
        }
        if (!this.f427005h.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.f427005h);
        }
        if (!this.f427006i.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.f427006i);
        }
        int i16 = this.f427007j;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(10, i16);
        }
        int i17 = this.f427008k;
        if (i17 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(11, i17);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f426998a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        long j16 = this.f426999b;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j16);
        }
        long j17 = this.f427000c;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j17);
        }
        long j18 = this.f427001d;
        if (j18 != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j18);
        }
        long j19 = this.f427002e;
        if (j19 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j19);
        }
        long j26 = this.f427003f;
        if (j26 != 0) {
            codedOutputByteBufferNano.writeUInt64(6, j26);
        }
        int i3 = this.f427004g;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i3);
        }
        if (!this.f427005h.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.f427005h);
        }
        if (!this.f427006i.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.f427006i);
        }
        int i16 = this.f427007j;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(10, i16);
        }
        int i17 = this.f427008k;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(11, i17);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
