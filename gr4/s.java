package gr4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.tencent.component.media.MtpConstants;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class s extends ExtendableMessageNano<s> {

    /* renamed from: a, reason: collision with root package name */
    public long f403194a;

    /* renamed from: b, reason: collision with root package name */
    public String f403195b;

    /* renamed from: c, reason: collision with root package name */
    public String f403196c;

    /* renamed from: d, reason: collision with root package name */
    public String f403197d;

    /* renamed from: e, reason: collision with root package name */
    public int f403198e;

    /* renamed from: f, reason: collision with root package name */
    public String f403199f;

    /* renamed from: g, reason: collision with root package name */
    public int f403200g;

    /* renamed from: h, reason: collision with root package name */
    public t f403201h;

    /* renamed from: i, reason: collision with root package name */
    public String f403202i;

    /* renamed from: j, reason: collision with root package name */
    public String f403203j;

    /* renamed from: k, reason: collision with root package name */
    public byte[] f403204k;

    /* renamed from: l, reason: collision with root package name */
    public int f403205l;

    /* renamed from: m, reason: collision with root package name */
    public String f403206m;

    /* renamed from: n, reason: collision with root package name */
    public int f403207n;

    /* renamed from: o, reason: collision with root package name */
    public int f403208o;

    /* renamed from: p, reason: collision with root package name */
    public String f403209p;

    /* renamed from: q, reason: collision with root package name */
    public String f403210q;

    /* renamed from: r, reason: collision with root package name */
    public int f403211r;

    /* renamed from: s, reason: collision with root package name */
    public rq4.a f403212s;

    public s() {
        a();
    }

    public s a() {
        this.f403194a = 0L;
        this.f403195b = "";
        this.f403196c = "";
        this.f403197d = "";
        this.f403198e = 0;
        this.f403199f = "";
        this.f403200g = 0;
        this.f403201h = null;
        this.f403202i = "";
        this.f403203j = "";
        this.f403204k = WireFormatNano.EMPTY_BYTES;
        this.f403205l = 0;
        this.f403206m = "";
        this.f403207n = 0;
        this.f403208o = 0;
        this.f403209p = "";
        this.f403210q = "";
        this.f403211r = 0;
        this.f403212s = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public s mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.f403194a = codedInputByteBufferNano.readUInt64();
                    break;
                case 18:
                    this.f403195b = codedInputByteBufferNano.readString();
                    break;
                case 26:
                    this.f403196c = codedInputByteBufferNano.readString();
                    break;
                case 34:
                    this.f403197d = codedInputByteBufferNano.readString();
                    break;
                case 40:
                    this.f403198e = codedInputByteBufferNano.readInt32();
                    break;
                case 50:
                    this.f403199f = codedInputByteBufferNano.readString();
                    break;
                case 56:
                    this.f403200g = codedInputByteBufferNano.readInt32();
                    break;
                case 66:
                    if (this.f403201h == null) {
                        this.f403201h = new t();
                    }
                    codedInputByteBufferNano.readMessage(this.f403201h);
                    break;
                case 74:
                    this.f403202i = codedInputByteBufferNano.readString();
                    break;
                case 82:
                    this.f403203j = codedInputByteBufferNano.readString();
                    break;
                case 90:
                    this.f403204k = codedInputByteBufferNano.readBytes();
                    break;
                case 96:
                    this.f403205l = codedInputByteBufferNano.readInt32();
                    break;
                case 106:
                    this.f403206m = codedInputByteBufferNano.readString();
                    break;
                case 112:
                    this.f403207n = codedInputByteBufferNano.readInt32();
                    break;
                case 120:
                    this.f403208o = codedInputByteBufferNano.readUInt32();
                    break;
                case 130:
                    this.f403209p = codedInputByteBufferNano.readString();
                    break;
                case 138:
                    this.f403210q = codedInputByteBufferNano.readString();
                    break;
                case 8192:
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    if (readInt32 != 0 && readInt32 != 1) {
                        break;
                    } else {
                        this.f403211r = readInt32;
                        break;
                    }
                case MtpConstants.RESPONSE_DEVICE_PROP_NOT_SUPPORTED /* 8202 */:
                    if (this.f403212s == null) {
                        this.f403212s = new rq4.a();
                    }
                    codedInputByteBufferNano.readMessage(this.f403212s);
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
        long j3 = this.f403194a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        if (!this.f403195b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f403195b);
        }
        if (!this.f403196c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f403196c);
        }
        if (!this.f403197d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f403197d);
        }
        int i3 = this.f403198e;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(5, i3);
        }
        if (!this.f403199f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f403199f);
        }
        int i16 = this.f403200g;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(7, i16);
        }
        t tVar = this.f403201h;
        if (tVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(8, tVar);
        }
        if (!this.f403202i.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.f403202i);
        }
        if (!this.f403203j.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.f403203j);
        }
        if (!Arrays.equals(this.f403204k, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(11, this.f403204k);
        }
        int i17 = this.f403205l;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(12, i17);
        }
        if (!this.f403206m.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(13, this.f403206m);
        }
        int i18 = this.f403207n;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(14, i18);
        }
        int i19 = this.f403208o;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(15, i19);
        }
        if (!this.f403209p.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(16, this.f403209p);
        }
        if (!this.f403210q.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(17, this.f403210q);
        }
        int i26 = this.f403211r;
        if (i26 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1024, i26);
        }
        rq4.a aVar = this.f403212s;
        if (aVar != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(1025, aVar);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f403194a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        if (!this.f403195b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f403195b);
        }
        if (!this.f403196c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f403196c);
        }
        if (!this.f403197d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f403197d);
        }
        int i3 = this.f403198e;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(5, i3);
        }
        if (!this.f403199f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f403199f);
        }
        int i16 = this.f403200g;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(7, i16);
        }
        t tVar = this.f403201h;
        if (tVar != null) {
            codedOutputByteBufferNano.writeMessage(8, tVar);
        }
        if (!this.f403202i.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.f403202i);
        }
        if (!this.f403203j.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.f403203j);
        }
        if (!Arrays.equals(this.f403204k, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(11, this.f403204k);
        }
        int i17 = this.f403205l;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(12, i17);
        }
        if (!this.f403206m.equals("")) {
            codedOutputByteBufferNano.writeString(13, this.f403206m);
        }
        int i18 = this.f403207n;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeInt32(14, i18);
        }
        int i19 = this.f403208o;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeUInt32(15, i19);
        }
        if (!this.f403209p.equals("")) {
            codedOutputByteBufferNano.writeString(16, this.f403209p);
        }
        if (!this.f403210q.equals("")) {
            codedOutputByteBufferNano.writeString(17, this.f403210q);
        }
        int i26 = this.f403211r;
        if (i26 != 0) {
            codedOutputByteBufferNano.writeInt32(1024, i26);
        }
        rq4.a aVar = this.f403212s;
        if (aVar != null) {
            codedOutputByteBufferNano.writeMessage(1025, aVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
