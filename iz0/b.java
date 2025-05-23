package iz0;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class b extends ExtendableMessageNano<b> {
    public int A;
    public long B;
    public int C;
    public int D;
    public String E;

    /* renamed from: a, reason: collision with root package name */
    public long f408994a;

    /* renamed from: b, reason: collision with root package name */
    public long f408995b;

    /* renamed from: c, reason: collision with root package name */
    public String f408996c;

    /* renamed from: d, reason: collision with root package name */
    public int f408997d;

    /* renamed from: e, reason: collision with root package name */
    public String f408998e;

    /* renamed from: f, reason: collision with root package name */
    public byte[] f408999f;

    /* renamed from: g, reason: collision with root package name */
    public int f409000g;

    /* renamed from: h, reason: collision with root package name */
    public int f409001h;

    /* renamed from: i, reason: collision with root package name */
    public String f409002i;

    /* renamed from: j, reason: collision with root package name */
    public String f409003j;

    /* renamed from: k, reason: collision with root package name */
    public int f409004k;

    /* renamed from: l, reason: collision with root package name */
    public int f409005l;

    /* renamed from: m, reason: collision with root package name */
    public String f409006m;

    /* renamed from: n, reason: collision with root package name */
    public int f409007n;

    /* renamed from: o, reason: collision with root package name */
    public a[] f409008o;

    /* renamed from: p, reason: collision with root package name */
    public byte[] f409009p;

    /* renamed from: q, reason: collision with root package name */
    public int f409010q;

    /* renamed from: r, reason: collision with root package name */
    public String f409011r;

    /* renamed from: s, reason: collision with root package name */
    public d[] f409012s;

    /* renamed from: t, reason: collision with root package name */
    public String f409013t;

    /* renamed from: u, reason: collision with root package name */
    public String f409014u;

    /* renamed from: v, reason: collision with root package name */
    public String f409015v;

    /* renamed from: w, reason: collision with root package name */
    public String f409016w;

    /* renamed from: z, reason: collision with root package name */
    public int f409017z;

    public b() {
        a();
    }

    public b a() {
        this.f408994a = 0L;
        this.f408995b = 0L;
        this.f408996c = "";
        this.f408997d = 0;
        this.f408998e = "";
        byte[] bArr = WireFormatNano.EMPTY_BYTES;
        this.f408999f = bArr;
        this.f409000g = 0;
        this.f409001h = 0;
        this.f409002i = "";
        this.f409003j = "";
        this.f409004k = 0;
        this.f409005l = 0;
        this.f409006m = "";
        this.f409007n = 0;
        this.f409008o = a.b();
        this.f409009p = bArr;
        this.f409010q = 0;
        this.f409011r = "";
        this.f409012s = d.b();
        this.f409013t = "";
        this.f409014u = "";
        this.f409015v = "";
        this.f409016w = "";
        this.f409017z = 0;
        this.A = 0;
        this.B = 0L;
        this.C = 0;
        this.D = 0;
        this.E = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        int length2;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.f408994a = codedInputByteBufferNano.readUInt64();
                    break;
                case 16:
                    this.f408995b = codedInputByteBufferNano.readUInt64();
                    break;
                case 26:
                    this.f408996c = codedInputByteBufferNano.readString();
                    break;
                case 32:
                    this.f408997d = codedInputByteBufferNano.readUInt32();
                    break;
                case 42:
                    this.f408998e = codedInputByteBufferNano.readString();
                    break;
                case 50:
                    this.f408999f = codedInputByteBufferNano.readBytes();
                    break;
                case 56:
                    this.f409000g = codedInputByteBufferNano.readUInt32();
                    break;
                case 64:
                    this.f409001h = codedInputByteBufferNano.readUInt32();
                    break;
                case 74:
                    this.f409002i = codedInputByteBufferNano.readString();
                    break;
                case 82:
                    this.f409003j = codedInputByteBufferNano.readString();
                    break;
                case 88:
                    this.f409004k = codedInputByteBufferNano.readUInt32();
                    break;
                case 96:
                    this.f409005l = codedInputByteBufferNano.readUInt32();
                    break;
                case 106:
                    this.f409006m = codedInputByteBufferNano.readString();
                    break;
                case 112:
                    this.f409007n = codedInputByteBufferNano.readUInt32();
                    break;
                case 122:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 122);
                    a[] aVarArr = this.f409008o;
                    if (aVarArr == null) {
                        length = 0;
                    } else {
                        length = aVarArr.length;
                    }
                    int i3 = repeatedFieldArrayLength + length;
                    a[] aVarArr2 = new a[i3];
                    if (length != 0) {
                        System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                    }
                    while (length < i3 - 1) {
                        a aVar = new a();
                        aVarArr2[length] = aVar;
                        codedInputByteBufferNano.readMessage(aVar);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    a aVar2 = new a();
                    aVarArr2[length] = aVar2;
                    codedInputByteBufferNano.readMessage(aVar2);
                    this.f409008o = aVarArr2;
                    break;
                case 130:
                    this.f409009p = codedInputByteBufferNano.readBytes();
                    break;
                case 136:
                    this.f409010q = codedInputByteBufferNano.readUInt32();
                    break;
                case 146:
                    this.f409011r = codedInputByteBufferNano.readString();
                    break;
                case 154:
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 154);
                    d[] dVarArr = this.f409012s;
                    if (dVarArr == null) {
                        length2 = 0;
                    } else {
                        length2 = dVarArr.length;
                    }
                    int i16 = repeatedFieldArrayLength2 + length2;
                    d[] dVarArr2 = new d[i16];
                    if (length2 != 0) {
                        System.arraycopy(dVarArr, 0, dVarArr2, 0, length2);
                    }
                    while (length2 < i16 - 1) {
                        d dVar = new d();
                        dVarArr2[length2] = dVar;
                        codedInputByteBufferNano.readMessage(dVar);
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    d dVar2 = new d();
                    dVarArr2[length2] = dVar2;
                    codedInputByteBufferNano.readMessage(dVar2);
                    this.f409012s = dVarArr2;
                    break;
                case 162:
                    this.f409013t = codedInputByteBufferNano.readString();
                    break;
                case 170:
                    this.f409014u = codedInputByteBufferNano.readString();
                    break;
                case 178:
                    this.f409015v = codedInputByteBufferNano.readString();
                    break;
                case 186:
                    this.f409016w = codedInputByteBufferNano.readString();
                    break;
                case 192:
                    this.f409017z = codedInputByteBufferNano.readUInt32();
                    break;
                case 200:
                    this.A = codedInputByteBufferNano.readUInt32();
                    break;
                case 208:
                    this.B = codedInputByteBufferNano.readInt64();
                    break;
                case 216:
                    this.C = codedInputByteBufferNano.readUInt32();
                    break;
                case 224:
                    this.D = codedInputByteBufferNano.readUInt32();
                    break;
                case 234:
                    this.E = codedInputByteBufferNano.readString();
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
        long j3 = this.f408994a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        long j16 = this.f408995b;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j16);
        }
        if (!this.f408996c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f408996c);
        }
        int i3 = this.f408997d;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i3);
        }
        if (!this.f408998e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f408998e);
        }
        if (!Arrays.equals(this.f408999f, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(6, this.f408999f);
        }
        int i16 = this.f409000g;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(7, i16);
        }
        int i17 = this.f409001h;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(8, i17);
        }
        if (!this.f409002i.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.f409002i);
        }
        if (!this.f409003j.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.f409003j);
        }
        int i18 = this.f409004k;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(11, i18);
        }
        int i19 = this.f409005l;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(12, i19);
        }
        if (!this.f409006m.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(13, this.f409006m);
        }
        int i26 = this.f409007n;
        if (i26 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(14, i26);
        }
        a[] aVarArr = this.f409008o;
        int i27 = 0;
        if (aVarArr != null && aVarArr.length > 0) {
            int i28 = 0;
            while (true) {
                a[] aVarArr2 = this.f409008o;
                if (i28 >= aVarArr2.length) {
                    break;
                }
                a aVar = aVarArr2[i28];
                if (aVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(15, aVar);
                }
                i28++;
            }
        }
        if (!Arrays.equals(this.f409009p, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(16, this.f409009p);
        }
        int i29 = this.f409010q;
        if (i29 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(17, i29);
        }
        if (!this.f409011r.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(18, this.f409011r);
        }
        d[] dVarArr = this.f409012s;
        if (dVarArr != null && dVarArr.length > 0) {
            while (true) {
                d[] dVarArr2 = this.f409012s;
                if (i27 >= dVarArr2.length) {
                    break;
                }
                d dVar = dVarArr2[i27];
                if (dVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(19, dVar);
                }
                i27++;
            }
        }
        if (!this.f409013t.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(20, this.f409013t);
        }
        if (!this.f409014u.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(21, this.f409014u);
        }
        if (!this.f409015v.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(22, this.f409015v);
        }
        if (!this.f409016w.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(23, this.f409016w);
        }
        int i36 = this.f409017z;
        if (i36 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(24, i36);
        }
        int i37 = this.A;
        if (i37 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(25, i37);
        }
        long j17 = this.B;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(26, j17);
        }
        int i38 = this.C;
        if (i38 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(27, i38);
        }
        int i39 = this.D;
        if (i39 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(28, i39);
        }
        if (!this.E.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(29, this.E);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f408994a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        long j16 = this.f408995b;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j16);
        }
        if (!this.f408996c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f408996c);
        }
        int i3 = this.f408997d;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i3);
        }
        if (!this.f408998e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f408998e);
        }
        if (!Arrays.equals(this.f408999f, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(6, this.f408999f);
        }
        int i16 = this.f409000g;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i16);
        }
        int i17 = this.f409001h;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(8, i17);
        }
        if (!this.f409002i.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.f409002i);
        }
        if (!this.f409003j.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.f409003j);
        }
        int i18 = this.f409004k;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(11, i18);
        }
        int i19 = this.f409005l;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeUInt32(12, i19);
        }
        if (!this.f409006m.equals("")) {
            codedOutputByteBufferNano.writeString(13, this.f409006m);
        }
        int i26 = this.f409007n;
        if (i26 != 0) {
            codedOutputByteBufferNano.writeUInt32(14, i26);
        }
        a[] aVarArr = this.f409008o;
        int i27 = 0;
        if (aVarArr != null && aVarArr.length > 0) {
            int i28 = 0;
            while (true) {
                a[] aVarArr2 = this.f409008o;
                if (i28 >= aVarArr2.length) {
                    break;
                }
                a aVar = aVarArr2[i28];
                if (aVar != null) {
                    codedOutputByteBufferNano.writeMessage(15, aVar);
                }
                i28++;
            }
        }
        if (!Arrays.equals(this.f409009p, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(16, this.f409009p);
        }
        int i29 = this.f409010q;
        if (i29 != 0) {
            codedOutputByteBufferNano.writeUInt32(17, i29);
        }
        if (!this.f409011r.equals("")) {
            codedOutputByteBufferNano.writeString(18, this.f409011r);
        }
        d[] dVarArr = this.f409012s;
        if (dVarArr != null && dVarArr.length > 0) {
            while (true) {
                d[] dVarArr2 = this.f409012s;
                if (i27 >= dVarArr2.length) {
                    break;
                }
                d dVar = dVarArr2[i27];
                if (dVar != null) {
                    codedOutputByteBufferNano.writeMessage(19, dVar);
                }
                i27++;
            }
        }
        if (!this.f409013t.equals("")) {
            codedOutputByteBufferNano.writeString(20, this.f409013t);
        }
        if (!this.f409014u.equals("")) {
            codedOutputByteBufferNano.writeString(21, this.f409014u);
        }
        if (!this.f409015v.equals("")) {
            codedOutputByteBufferNano.writeString(22, this.f409015v);
        }
        if (!this.f409016w.equals("")) {
            codedOutputByteBufferNano.writeString(23, this.f409016w);
        }
        int i36 = this.f409017z;
        if (i36 != 0) {
            codedOutputByteBufferNano.writeUInt32(24, i36);
        }
        int i37 = this.A;
        if (i37 != 0) {
            codedOutputByteBufferNano.writeUInt32(25, i37);
        }
        long j17 = this.B;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeInt64(26, j17);
        }
        int i38 = this.C;
        if (i38 != 0) {
            codedOutputByteBufferNano.writeUInt32(27, i38);
        }
        int i39 = this.D;
        if (i39 != 0) {
            codedOutputByteBufferNano.writeUInt32(28, i39);
        }
        if (!this.E.equals("")) {
            codedOutputByteBufferNano.writeString(29, this.E);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
