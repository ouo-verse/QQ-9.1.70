package en0;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class b extends ExtendableMessageNano<b> {
    public int A;
    public long B;

    /* renamed from: a, reason: collision with root package name */
    public long f396836a;

    /* renamed from: b, reason: collision with root package name */
    public long f396837b;

    /* renamed from: c, reason: collision with root package name */
    public String f396838c;

    /* renamed from: d, reason: collision with root package name */
    public int f396839d;

    /* renamed from: e, reason: collision with root package name */
    public String f396840e;

    /* renamed from: f, reason: collision with root package name */
    public byte[] f396841f;

    /* renamed from: g, reason: collision with root package name */
    public int f396842g;

    /* renamed from: h, reason: collision with root package name */
    public int f396843h;

    /* renamed from: i, reason: collision with root package name */
    public String f396844i;

    /* renamed from: j, reason: collision with root package name */
    public String f396845j;

    /* renamed from: k, reason: collision with root package name */
    public int f396846k;

    /* renamed from: l, reason: collision with root package name */
    public int f396847l;

    /* renamed from: m, reason: collision with root package name */
    public String f396848m;

    /* renamed from: n, reason: collision with root package name */
    public int f396849n;

    /* renamed from: o, reason: collision with root package name */
    public a[] f396850o;

    /* renamed from: p, reason: collision with root package name */
    public byte[] f396851p;

    /* renamed from: q, reason: collision with root package name */
    public int f396852q;

    /* renamed from: r, reason: collision with root package name */
    public String f396853r;

    /* renamed from: s, reason: collision with root package name */
    public d[] f396854s;

    /* renamed from: t, reason: collision with root package name */
    public String f396855t;

    /* renamed from: u, reason: collision with root package name */
    public String f396856u;

    /* renamed from: v, reason: collision with root package name */
    public String f396857v;

    /* renamed from: w, reason: collision with root package name */
    public String f396858w;

    /* renamed from: z, reason: collision with root package name */
    public int f396859z;

    public b() {
        a();
    }

    public b a() {
        this.f396836a = 0L;
        this.f396837b = 0L;
        this.f396838c = "";
        this.f396839d = 0;
        this.f396840e = "";
        byte[] bArr = WireFormatNano.EMPTY_BYTES;
        this.f396841f = bArr;
        this.f396842g = 0;
        this.f396843h = 0;
        this.f396844i = "";
        this.f396845j = "";
        this.f396846k = 0;
        this.f396847l = 0;
        this.f396848m = "";
        this.f396849n = 0;
        this.f396850o = a.b();
        this.f396851p = bArr;
        this.f396852q = 0;
        this.f396853r = "";
        this.f396854s = d.b();
        this.f396855t = "";
        this.f396856u = "";
        this.f396857v = "";
        this.f396858w = "";
        this.f396859z = 0;
        this.A = 0;
        this.B = 0L;
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
                    this.f396836a = codedInputByteBufferNano.readUInt64();
                    break;
                case 16:
                    this.f396837b = codedInputByteBufferNano.readUInt64();
                    break;
                case 26:
                    this.f396838c = codedInputByteBufferNano.readString();
                    break;
                case 32:
                    this.f396839d = codedInputByteBufferNano.readUInt32();
                    break;
                case 42:
                    this.f396840e = codedInputByteBufferNano.readString();
                    break;
                case 50:
                    this.f396841f = codedInputByteBufferNano.readBytes();
                    break;
                case 56:
                    this.f396842g = codedInputByteBufferNano.readUInt32();
                    break;
                case 64:
                    this.f396843h = codedInputByteBufferNano.readUInt32();
                    break;
                case 74:
                    this.f396844i = codedInputByteBufferNano.readString();
                    break;
                case 82:
                    this.f396845j = codedInputByteBufferNano.readString();
                    break;
                case 88:
                    this.f396846k = codedInputByteBufferNano.readUInt32();
                    break;
                case 96:
                    this.f396847l = codedInputByteBufferNano.readUInt32();
                    break;
                case 106:
                    this.f396848m = codedInputByteBufferNano.readString();
                    break;
                case 112:
                    this.f396849n = codedInputByteBufferNano.readUInt32();
                    break;
                case 122:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 122);
                    a[] aVarArr = this.f396850o;
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
                    this.f396850o = aVarArr2;
                    break;
                case 130:
                    this.f396851p = codedInputByteBufferNano.readBytes();
                    break;
                case 136:
                    this.f396852q = codedInputByteBufferNano.readUInt32();
                    break;
                case 146:
                    this.f396853r = codedInputByteBufferNano.readString();
                    break;
                case 154:
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 154);
                    d[] dVarArr = this.f396854s;
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
                    this.f396854s = dVarArr2;
                    break;
                case 162:
                    this.f396855t = codedInputByteBufferNano.readString();
                    break;
                case 170:
                    this.f396856u = codedInputByteBufferNano.readString();
                    break;
                case 178:
                    this.f396857v = codedInputByteBufferNano.readString();
                    break;
                case 186:
                    this.f396858w = codedInputByteBufferNano.readString();
                    break;
                case 192:
                    this.f396859z = codedInputByteBufferNano.readUInt32();
                    break;
                case 200:
                    this.A = codedInputByteBufferNano.readUInt32();
                    break;
                case 208:
                    this.B = codedInputByteBufferNano.readInt64();
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
        long j3 = this.f396836a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        long j16 = this.f396837b;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j16);
        }
        if (!this.f396838c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f396838c);
        }
        int i3 = this.f396839d;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i3);
        }
        if (!this.f396840e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f396840e);
        }
        if (!Arrays.equals(this.f396841f, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(6, this.f396841f);
        }
        int i16 = this.f396842g;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(7, i16);
        }
        int i17 = this.f396843h;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(8, i17);
        }
        if (!this.f396844i.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.f396844i);
        }
        if (!this.f396845j.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.f396845j);
        }
        int i18 = this.f396846k;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(11, i18);
        }
        int i19 = this.f396847l;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(12, i19);
        }
        if (!this.f396848m.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(13, this.f396848m);
        }
        int i26 = this.f396849n;
        if (i26 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(14, i26);
        }
        a[] aVarArr = this.f396850o;
        int i27 = 0;
        if (aVarArr != null && aVarArr.length > 0) {
            int i28 = 0;
            while (true) {
                a[] aVarArr2 = this.f396850o;
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
        if (!Arrays.equals(this.f396851p, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(16, this.f396851p);
        }
        int i29 = this.f396852q;
        if (i29 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(17, i29);
        }
        if (!this.f396853r.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(18, this.f396853r);
        }
        d[] dVarArr = this.f396854s;
        if (dVarArr != null && dVarArr.length > 0) {
            while (true) {
                d[] dVarArr2 = this.f396854s;
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
        if (!this.f396855t.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(20, this.f396855t);
        }
        if (!this.f396856u.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(21, this.f396856u);
        }
        if (!this.f396857v.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(22, this.f396857v);
        }
        if (!this.f396858w.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(23, this.f396858w);
        }
        int i36 = this.f396859z;
        if (i36 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(24, i36);
        }
        int i37 = this.A;
        if (i37 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(25, i37);
        }
        long j17 = this.B;
        if (j17 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeInt64Size(26, j17);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f396836a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        long j16 = this.f396837b;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j16);
        }
        if (!this.f396838c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f396838c);
        }
        int i3 = this.f396839d;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i3);
        }
        if (!this.f396840e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f396840e);
        }
        if (!Arrays.equals(this.f396841f, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(6, this.f396841f);
        }
        int i16 = this.f396842g;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i16);
        }
        int i17 = this.f396843h;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(8, i17);
        }
        if (!this.f396844i.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.f396844i);
        }
        if (!this.f396845j.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.f396845j);
        }
        int i18 = this.f396846k;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(11, i18);
        }
        int i19 = this.f396847l;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeUInt32(12, i19);
        }
        if (!this.f396848m.equals("")) {
            codedOutputByteBufferNano.writeString(13, this.f396848m);
        }
        int i26 = this.f396849n;
        if (i26 != 0) {
            codedOutputByteBufferNano.writeUInt32(14, i26);
        }
        a[] aVarArr = this.f396850o;
        int i27 = 0;
        if (aVarArr != null && aVarArr.length > 0) {
            int i28 = 0;
            while (true) {
                a[] aVarArr2 = this.f396850o;
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
        if (!Arrays.equals(this.f396851p, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(16, this.f396851p);
        }
        int i29 = this.f396852q;
        if (i29 != 0) {
            codedOutputByteBufferNano.writeUInt32(17, i29);
        }
        if (!this.f396853r.equals("")) {
            codedOutputByteBufferNano.writeString(18, this.f396853r);
        }
        d[] dVarArr = this.f396854s;
        if (dVarArr != null && dVarArr.length > 0) {
            while (true) {
                d[] dVarArr2 = this.f396854s;
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
        if (!this.f396855t.equals("")) {
            codedOutputByteBufferNano.writeString(20, this.f396855t);
        }
        if (!this.f396856u.equals("")) {
            codedOutputByteBufferNano.writeString(21, this.f396856u);
        }
        if (!this.f396857v.equals("")) {
            codedOutputByteBufferNano.writeString(22, this.f396857v);
        }
        if (!this.f396858w.equals("")) {
            codedOutputByteBufferNano.writeString(23, this.f396858w);
        }
        int i36 = this.f396859z;
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
        super.writeTo(codedOutputByteBufferNano);
    }
}
