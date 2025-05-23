package nv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class m extends ExtendableMessageNano<m> {

    /* renamed from: u, reason: collision with root package name */
    private static volatile m[] f421415u;

    /* renamed from: a, reason: collision with root package name */
    public int f421416a;

    /* renamed from: b, reason: collision with root package name */
    public String f421417b;

    /* renamed from: c, reason: collision with root package name */
    public String f421418c;

    /* renamed from: d, reason: collision with root package name */
    public long f421419d;

    /* renamed from: e, reason: collision with root package name */
    public int f421420e;

    /* renamed from: f, reason: collision with root package name */
    public String f421421f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f421422g;

    /* renamed from: h, reason: collision with root package name */
    public String f421423h;

    /* renamed from: i, reason: collision with root package name */
    public String f421424i;

    /* renamed from: j, reason: collision with root package name */
    public long f421425j;

    /* renamed from: k, reason: collision with root package name */
    public o[] f421426k;

    /* renamed from: l, reason: collision with root package name */
    public String f421427l;

    /* renamed from: m, reason: collision with root package name */
    public long f421428m;

    /* renamed from: n, reason: collision with root package name */
    public long f421429n;

    /* renamed from: o, reason: collision with root package name */
    public int[] f421430o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f421431p;

    /* renamed from: q, reason: collision with root package name */
    public String f421432q;

    /* renamed from: r, reason: collision with root package name */
    public k[] f421433r;

    /* renamed from: s, reason: collision with root package name */
    public a f421434s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f421435t;

    public m() {
        a();
    }

    public static m[] b() {
        if (f421415u == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f421415u == null) {
                    f421415u = new m[0];
                }
            }
        }
        return f421415u;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public m mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.f421416a = codedInputByteBufferNano.readUInt32();
                    break;
                case 18:
                    this.f421417b = codedInputByteBufferNano.readString();
                    break;
                case 26:
                    this.f421418c = codedInputByteBufferNano.readString();
                    break;
                case 32:
                    this.f421419d = codedInputByteBufferNano.readUInt64();
                    break;
                case 40:
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    if (readInt32 != 0 && readInt32 != 1 && readInt32 != 2 && readInt32 != 3 && readInt32 != 4 && readInt32 != 5) {
                        break;
                    } else {
                        this.f421420e = readInt32;
                        break;
                    }
                case 50:
                    this.f421421f = codedInputByteBufferNano.readString();
                    break;
                case 56:
                    this.f421422g = codedInputByteBufferNano.readBool();
                    break;
                case 66:
                    this.f421423h = codedInputByteBufferNano.readString();
                    break;
                case 74:
                    this.f421424i = codedInputByteBufferNano.readString();
                    break;
                case 80:
                    this.f421425j = codedInputByteBufferNano.readUInt64();
                    break;
                case 90:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 90);
                    o[] oVarArr = this.f421426k;
                    int length = oVarArr == null ? 0 : oVarArr.length;
                    int i3 = repeatedFieldArrayLength + length;
                    o[] oVarArr2 = new o[i3];
                    if (length != 0) {
                        System.arraycopy(oVarArr, 0, oVarArr2, 0, length);
                    }
                    while (length < i3 - 1) {
                        o oVar = new o();
                        oVarArr2[length] = oVar;
                        codedInputByteBufferNano.readMessage(oVar);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    o oVar2 = new o();
                    oVarArr2[length] = oVar2;
                    codedInputByteBufferNano.readMessage(oVar2);
                    this.f421426k = oVarArr2;
                    break;
                case 98:
                    this.f421427l = codedInputByteBufferNano.readString();
                    break;
                case 104:
                    this.f421428m = codedInputByteBufferNano.readUInt64();
                    break;
                case 112:
                    this.f421429n = codedInputByteBufferNano.readInt64();
                    break;
                case 120:
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 120);
                    int[] iArr = this.f421430o;
                    int length2 = iArr == null ? 0 : iArr.length;
                    int i16 = repeatedFieldArrayLength2 + length2;
                    int[] iArr2 = new int[i16];
                    if (length2 != 0) {
                        System.arraycopy(iArr, 0, iArr2, 0, length2);
                    }
                    while (length2 < i16 - 1) {
                        iArr2[length2] = codedInputByteBufferNano.readUInt32();
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    iArr2[length2] = codedInputByteBufferNano.readUInt32();
                    this.f421430o = iArr2;
                    break;
                case 122:
                    int pushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                    int position = codedInputByteBufferNano.getPosition();
                    int i17 = 0;
                    while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                        codedInputByteBufferNano.readUInt32();
                        i17++;
                    }
                    codedInputByteBufferNano.rewindToPosition(position);
                    int[] iArr3 = this.f421430o;
                    int length3 = iArr3 == null ? 0 : iArr3.length;
                    int i18 = i17 + length3;
                    int[] iArr4 = new int[i18];
                    if (length3 != 0) {
                        System.arraycopy(iArr3, 0, iArr4, 0, length3);
                    }
                    while (length3 < i18) {
                        iArr4[length3] = codedInputByteBufferNano.readUInt32();
                        length3++;
                    }
                    this.f421430o = iArr4;
                    codedInputByteBufferNano.popLimit(pushLimit);
                    break;
                case 128:
                    this.f421431p = codedInputByteBufferNano.readBool();
                    break;
                case 138:
                    this.f421432q = codedInputByteBufferNano.readString();
                    break;
                case 146:
                    int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 146);
                    k[] kVarArr = this.f421433r;
                    int length4 = kVarArr == null ? 0 : kVarArr.length;
                    int i19 = repeatedFieldArrayLength3 + length4;
                    k[] kVarArr2 = new k[i19];
                    if (length4 != 0) {
                        System.arraycopy(kVarArr, 0, kVarArr2, 0, length4);
                    }
                    while (length4 < i19 - 1) {
                        k kVar = new k();
                        kVarArr2[length4] = kVar;
                        codedInputByteBufferNano.readMessage(kVar);
                        codedInputByteBufferNano.readTag();
                        length4++;
                    }
                    k kVar2 = new k();
                    kVarArr2[length4] = kVar2;
                    codedInputByteBufferNano.readMessage(kVar2);
                    this.f421433r = kVarArr2;
                    break;
                case 154:
                    if (this.f421434s == null) {
                        this.f421434s = new a();
                    }
                    codedInputByteBufferNano.readMessage(this.f421434s);
                    break;
                case 160:
                    this.f421435t = codedInputByteBufferNano.readBool();
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
        int[] iArr;
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f421416a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        if (!this.f421417b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f421417b);
        }
        if (!this.f421418c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f421418c);
        }
        long j3 = this.f421419d;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j3);
        }
        int i16 = this.f421420e;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(5, i16);
        }
        if (!this.f421421f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f421421f);
        }
        boolean z16 = this.f421422g;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(7, z16);
        }
        if (!this.f421423h.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.f421423h);
        }
        if (!this.f421424i.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.f421424i);
        }
        long j16 = this.f421425j;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(10, j16);
        }
        o[] oVarArr = this.f421426k;
        int i17 = 0;
        if (oVarArr != null && oVarArr.length > 0) {
            int i18 = 0;
            while (true) {
                o[] oVarArr2 = this.f421426k;
                if (i18 >= oVarArr2.length) {
                    break;
                }
                o oVar = oVarArr2[i18];
                if (oVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(11, oVar);
                }
                i18++;
            }
        }
        if (!this.f421427l.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(12, this.f421427l);
        }
        long j17 = this.f421428m;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(13, j17);
        }
        long j18 = this.f421429n;
        if (j18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(14, j18);
        }
        int[] iArr2 = this.f421430o;
        if (iArr2 != null && iArr2.length > 0) {
            int i19 = 0;
            int i26 = 0;
            while (true) {
                iArr = this.f421430o;
                if (i19 >= iArr.length) {
                    break;
                }
                i26 += CodedOutputByteBufferNano.computeUInt32SizeNoTag(iArr[i19]);
                i19++;
            }
            computeSerializedSize = computeSerializedSize + i26 + (iArr.length * 1);
        }
        boolean z17 = this.f421431p;
        if (z17) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(16, z17);
        }
        if (!this.f421432q.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(17, this.f421432q);
        }
        k[] kVarArr = this.f421433r;
        if (kVarArr != null && kVarArr.length > 0) {
            while (true) {
                k[] kVarArr2 = this.f421433r;
                if (i17 >= kVarArr2.length) {
                    break;
                }
                k kVar = kVarArr2[i17];
                if (kVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(18, kVar);
                }
                i17++;
            }
        }
        a aVar = this.f421434s;
        if (aVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(19, aVar);
        }
        boolean z18 = this.f421435t;
        return z18 ? computeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(20, z18) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f421416a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        if (!this.f421417b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f421417b);
        }
        if (!this.f421418c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f421418c);
        }
        long j3 = this.f421419d;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j3);
        }
        int i16 = this.f421420e;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(5, i16);
        }
        if (!this.f421421f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f421421f);
        }
        boolean z16 = this.f421422g;
        if (z16) {
            codedOutputByteBufferNano.writeBool(7, z16);
        }
        if (!this.f421423h.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.f421423h);
        }
        if (!this.f421424i.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.f421424i);
        }
        long j16 = this.f421425j;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(10, j16);
        }
        o[] oVarArr = this.f421426k;
        int i17 = 0;
        if (oVarArr != null && oVarArr.length > 0) {
            int i18 = 0;
            while (true) {
                o[] oVarArr2 = this.f421426k;
                if (i18 >= oVarArr2.length) {
                    break;
                }
                o oVar = oVarArr2[i18];
                if (oVar != null) {
                    codedOutputByteBufferNano.writeMessage(11, oVar);
                }
                i18++;
            }
        }
        if (!this.f421427l.equals("")) {
            codedOutputByteBufferNano.writeString(12, this.f421427l);
        }
        long j17 = this.f421428m;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeUInt64(13, j17);
        }
        long j18 = this.f421429n;
        if (j18 != 0) {
            codedOutputByteBufferNano.writeInt64(14, j18);
        }
        int[] iArr = this.f421430o;
        if (iArr != null && iArr.length > 0) {
            int i19 = 0;
            while (true) {
                int[] iArr2 = this.f421430o;
                if (i19 >= iArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeUInt32(15, iArr2[i19]);
                i19++;
            }
        }
        boolean z17 = this.f421431p;
        if (z17) {
            codedOutputByteBufferNano.writeBool(16, z17);
        }
        if (!this.f421432q.equals("")) {
            codedOutputByteBufferNano.writeString(17, this.f421432q);
        }
        k[] kVarArr = this.f421433r;
        if (kVarArr != null && kVarArr.length > 0) {
            while (true) {
                k[] kVarArr2 = this.f421433r;
                if (i17 >= kVarArr2.length) {
                    break;
                }
                k kVar = kVarArr2[i17];
                if (kVar != null) {
                    codedOutputByteBufferNano.writeMessage(18, kVar);
                }
                i17++;
            }
        }
        a aVar = this.f421434s;
        if (aVar != null) {
            codedOutputByteBufferNano.writeMessage(19, aVar);
        }
        boolean z18 = this.f421435t;
        if (z18) {
            codedOutputByteBufferNano.writeBool(20, z18);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public m a() {
        this.f421416a = 0;
        this.f421417b = "";
        this.f421418c = "";
        this.f421419d = 0L;
        this.f421420e = 0;
        this.f421421f = "";
        this.f421422g = false;
        this.f421423h = "";
        this.f421424i = "";
        this.f421425j = 0L;
        this.f421426k = o.b();
        this.f421427l = "";
        this.f421428m = 0L;
        this.f421429n = 0L;
        this.f421430o = WireFormatNano.EMPTY_INT_ARRAY;
        this.f421431p = false;
        this.f421432q = "";
        this.f421433r = k.b();
        this.f421434s = null;
        this.f421435t = false;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
