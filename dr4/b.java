package dr4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class b extends ExtendableMessageNano<b> {
    public int A;
    public long B;
    public int C;
    public int D;
    public String E;
    public a[] F;

    /* renamed from: a, reason: collision with root package name */
    public long f394691a;

    /* renamed from: b, reason: collision with root package name */
    public long f394692b;

    /* renamed from: c, reason: collision with root package name */
    public String f394693c;

    /* renamed from: d, reason: collision with root package name */
    public int f394694d;

    /* renamed from: e, reason: collision with root package name */
    public String f394695e;

    /* renamed from: f, reason: collision with root package name */
    public byte[] f394696f;

    /* renamed from: g, reason: collision with root package name */
    public int f394697g;

    /* renamed from: h, reason: collision with root package name */
    public int f394698h;

    /* renamed from: i, reason: collision with root package name */
    public String f394699i;

    /* renamed from: j, reason: collision with root package name */
    public String f394700j;

    /* renamed from: k, reason: collision with root package name */
    public int f394701k;

    /* renamed from: l, reason: collision with root package name */
    public int f394702l;

    /* renamed from: m, reason: collision with root package name */
    public String f394703m;

    /* renamed from: n, reason: collision with root package name */
    public int f394704n;

    /* renamed from: o, reason: collision with root package name */
    public a[] f394705o;

    /* renamed from: p, reason: collision with root package name */
    public byte[] f394706p;

    /* renamed from: q, reason: collision with root package name */
    public int f394707q;

    /* renamed from: r, reason: collision with root package name */
    public String f394708r;

    /* renamed from: s, reason: collision with root package name */
    public d[] f394709s;

    /* renamed from: t, reason: collision with root package name */
    public String f394710t;

    /* renamed from: u, reason: collision with root package name */
    public String f394711u;

    /* renamed from: v, reason: collision with root package name */
    public String f394712v;

    /* renamed from: w, reason: collision with root package name */
    public String f394713w;

    /* renamed from: z, reason: collision with root package name */
    public int f394714z;

    public b() {
        a();
    }

    public b a() {
        this.f394691a = 0L;
        this.f394692b = 0L;
        this.f394693c = "";
        this.f394694d = 0;
        this.f394695e = "";
        byte[] bArr = WireFormatNano.EMPTY_BYTES;
        this.f394696f = bArr;
        this.f394697g = 0;
        this.f394698h = 0;
        this.f394699i = "";
        this.f394700j = "";
        this.f394701k = 0;
        this.f394702l = 0;
        this.f394703m = "";
        this.f394704n = 0;
        this.f394705o = a.b();
        this.f394706p = bArr;
        this.f394707q = 0;
        this.f394708r = "";
        this.f394709s = d.b();
        this.f394710t = "";
        this.f394711u = "";
        this.f394712v = "";
        this.f394713w = "";
        this.f394714z = 0;
        this.A = 0;
        this.B = 0L;
        this.C = 0;
        this.D = 0;
        this.E = "";
        this.F = a.b();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        int length2;
        int length3;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.f394691a = codedInputByteBufferNano.readUInt64();
                    break;
                case 16:
                    this.f394692b = codedInputByteBufferNano.readUInt64();
                    break;
                case 26:
                    this.f394693c = codedInputByteBufferNano.readString();
                    break;
                case 32:
                    this.f394694d = codedInputByteBufferNano.readUInt32();
                    break;
                case 42:
                    this.f394695e = codedInputByteBufferNano.readString();
                    break;
                case 50:
                    this.f394696f = codedInputByteBufferNano.readBytes();
                    break;
                case 56:
                    this.f394697g = codedInputByteBufferNano.readUInt32();
                    break;
                case 64:
                    this.f394698h = codedInputByteBufferNano.readUInt32();
                    break;
                case 74:
                    this.f394699i = codedInputByteBufferNano.readString();
                    break;
                case 82:
                    this.f394700j = codedInputByteBufferNano.readString();
                    break;
                case 88:
                    this.f394701k = codedInputByteBufferNano.readUInt32();
                    break;
                case 96:
                    this.f394702l = codedInputByteBufferNano.readUInt32();
                    break;
                case 106:
                    this.f394703m = codedInputByteBufferNano.readString();
                    break;
                case 112:
                    this.f394704n = codedInputByteBufferNano.readUInt32();
                    break;
                case 122:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 122);
                    a[] aVarArr = this.f394705o;
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
                    this.f394705o = aVarArr2;
                    break;
                case 130:
                    this.f394706p = codedInputByteBufferNano.readBytes();
                    break;
                case 136:
                    this.f394707q = codedInputByteBufferNano.readUInt32();
                    break;
                case 146:
                    this.f394708r = codedInputByteBufferNano.readString();
                    break;
                case 154:
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 154);
                    d[] dVarArr = this.f394709s;
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
                    this.f394709s = dVarArr2;
                    break;
                case 162:
                    this.f394710t = codedInputByteBufferNano.readString();
                    break;
                case 170:
                    this.f394711u = codedInputByteBufferNano.readString();
                    break;
                case 178:
                    this.f394712v = codedInputByteBufferNano.readString();
                    break;
                case 186:
                    this.f394713w = codedInputByteBufferNano.readString();
                    break;
                case 192:
                    this.f394714z = codedInputByteBufferNano.readUInt32();
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
                case 242:
                    int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 242);
                    a[] aVarArr3 = this.F;
                    if (aVarArr3 == null) {
                        length3 = 0;
                    } else {
                        length3 = aVarArr3.length;
                    }
                    int i17 = repeatedFieldArrayLength3 + length3;
                    a[] aVarArr4 = new a[i17];
                    if (length3 != 0) {
                        System.arraycopy(aVarArr3, 0, aVarArr4, 0, length3);
                    }
                    while (length3 < i17 - 1) {
                        a aVar3 = new a();
                        aVarArr4[length3] = aVar3;
                        codedInputByteBufferNano.readMessage(aVar3);
                        codedInputByteBufferNano.readTag();
                        length3++;
                    }
                    a aVar4 = new a();
                    aVarArr4[length3] = aVar4;
                    codedInputByteBufferNano.readMessage(aVar4);
                    this.F = aVarArr4;
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
        long j3 = this.f394691a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        long j16 = this.f394692b;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j16);
        }
        if (!this.f394693c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f394693c);
        }
        int i3 = this.f394694d;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i3);
        }
        if (!this.f394695e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f394695e);
        }
        if (!Arrays.equals(this.f394696f, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(6, this.f394696f);
        }
        int i16 = this.f394697g;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(7, i16);
        }
        int i17 = this.f394698h;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(8, i17);
        }
        if (!this.f394699i.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.f394699i);
        }
        if (!this.f394700j.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.f394700j);
        }
        int i18 = this.f394701k;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(11, i18);
        }
        int i19 = this.f394702l;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(12, i19);
        }
        if (!this.f394703m.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(13, this.f394703m);
        }
        int i26 = this.f394704n;
        if (i26 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(14, i26);
        }
        a[] aVarArr = this.f394705o;
        int i27 = 0;
        if (aVarArr != null && aVarArr.length > 0) {
            int i28 = 0;
            while (true) {
                a[] aVarArr2 = this.f394705o;
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
        if (!Arrays.equals(this.f394706p, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(16, this.f394706p);
        }
        int i29 = this.f394707q;
        if (i29 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(17, i29);
        }
        if (!this.f394708r.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(18, this.f394708r);
        }
        d[] dVarArr = this.f394709s;
        if (dVarArr != null && dVarArr.length > 0) {
            int i36 = 0;
            while (true) {
                d[] dVarArr2 = this.f394709s;
                if (i36 >= dVarArr2.length) {
                    break;
                }
                d dVar = dVarArr2[i36];
                if (dVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(19, dVar);
                }
                i36++;
            }
        }
        if (!this.f394710t.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(20, this.f394710t);
        }
        if (!this.f394711u.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(21, this.f394711u);
        }
        if (!this.f394712v.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(22, this.f394712v);
        }
        if (!this.f394713w.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(23, this.f394713w);
        }
        int i37 = this.f394714z;
        if (i37 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(24, i37);
        }
        int i38 = this.A;
        if (i38 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(25, i38);
        }
        long j17 = this.B;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(26, j17);
        }
        int i39 = this.C;
        if (i39 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(27, i39);
        }
        int i46 = this.D;
        if (i46 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(28, i46);
        }
        if (!this.E.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(29, this.E);
        }
        a[] aVarArr3 = this.F;
        if (aVarArr3 != null && aVarArr3.length > 0) {
            while (true) {
                a[] aVarArr4 = this.F;
                if (i27 >= aVarArr4.length) {
                    break;
                }
                a aVar2 = aVarArr4[i27];
                if (aVar2 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(30, aVar2);
                }
                i27++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f394691a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        long j16 = this.f394692b;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j16);
        }
        if (!this.f394693c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f394693c);
        }
        int i3 = this.f394694d;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i3);
        }
        if (!this.f394695e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f394695e);
        }
        if (!Arrays.equals(this.f394696f, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(6, this.f394696f);
        }
        int i16 = this.f394697g;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i16);
        }
        int i17 = this.f394698h;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(8, i17);
        }
        if (!this.f394699i.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.f394699i);
        }
        if (!this.f394700j.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.f394700j);
        }
        int i18 = this.f394701k;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(11, i18);
        }
        int i19 = this.f394702l;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeUInt32(12, i19);
        }
        if (!this.f394703m.equals("")) {
            codedOutputByteBufferNano.writeString(13, this.f394703m);
        }
        int i26 = this.f394704n;
        if (i26 != 0) {
            codedOutputByteBufferNano.writeUInt32(14, i26);
        }
        a[] aVarArr = this.f394705o;
        int i27 = 0;
        if (aVarArr != null && aVarArr.length > 0) {
            int i28 = 0;
            while (true) {
                a[] aVarArr2 = this.f394705o;
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
        if (!Arrays.equals(this.f394706p, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(16, this.f394706p);
        }
        int i29 = this.f394707q;
        if (i29 != 0) {
            codedOutputByteBufferNano.writeUInt32(17, i29);
        }
        if (!this.f394708r.equals("")) {
            codedOutputByteBufferNano.writeString(18, this.f394708r);
        }
        d[] dVarArr = this.f394709s;
        if (dVarArr != null && dVarArr.length > 0) {
            int i36 = 0;
            while (true) {
                d[] dVarArr2 = this.f394709s;
                if (i36 >= dVarArr2.length) {
                    break;
                }
                d dVar = dVarArr2[i36];
                if (dVar != null) {
                    codedOutputByteBufferNano.writeMessage(19, dVar);
                }
                i36++;
            }
        }
        if (!this.f394710t.equals("")) {
            codedOutputByteBufferNano.writeString(20, this.f394710t);
        }
        if (!this.f394711u.equals("")) {
            codedOutputByteBufferNano.writeString(21, this.f394711u);
        }
        if (!this.f394712v.equals("")) {
            codedOutputByteBufferNano.writeString(22, this.f394712v);
        }
        if (!this.f394713w.equals("")) {
            codedOutputByteBufferNano.writeString(23, this.f394713w);
        }
        int i37 = this.f394714z;
        if (i37 != 0) {
            codedOutputByteBufferNano.writeUInt32(24, i37);
        }
        int i38 = this.A;
        if (i38 != 0) {
            codedOutputByteBufferNano.writeUInt32(25, i38);
        }
        long j17 = this.B;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeInt64(26, j17);
        }
        int i39 = this.C;
        if (i39 != 0) {
            codedOutputByteBufferNano.writeUInt32(27, i39);
        }
        int i46 = this.D;
        if (i46 != 0) {
            codedOutputByteBufferNano.writeUInt32(28, i46);
        }
        if (!this.E.equals("")) {
            codedOutputByteBufferNano.writeString(29, this.E);
        }
        a[] aVarArr3 = this.F;
        if (aVarArr3 != null && aVarArr3.length > 0) {
            while (true) {
                a[] aVarArr4 = this.F;
                if (i27 >= aVarArr4.length) {
                    break;
                }
                a aVar2 = aVarArr4[i27];
                if (aVar2 != null) {
                    codedOutputByteBufferNano.writeMessage(30, aVar2);
                }
                i27++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
