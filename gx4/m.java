package gx4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class m extends ExtendableMessageNano<m> {
    public int A;
    public String B;

    /* renamed from: a, reason: collision with root package name */
    public String f403794a;

    /* renamed from: b, reason: collision with root package name */
    public String f403795b;

    /* renamed from: c, reason: collision with root package name */
    public String[] f403796c;

    /* renamed from: d, reason: collision with root package name */
    public String[] f403797d;

    /* renamed from: e, reason: collision with root package name */
    public String f403798e;

    /* renamed from: f, reason: collision with root package name */
    public int f403799f;

    /* renamed from: g, reason: collision with root package name */
    public String f403800g;

    /* renamed from: h, reason: collision with root package name */
    public float f403801h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f403802i;

    /* renamed from: j, reason: collision with root package name */
    public String f403803j;

    /* renamed from: k, reason: collision with root package name */
    public String f403804k;

    /* renamed from: l, reason: collision with root package name */
    public String f403805l;

    /* renamed from: m, reason: collision with root package name */
    public int[] f403806m;

    /* renamed from: n, reason: collision with root package name */
    public String f403807n;

    /* renamed from: o, reason: collision with root package name */
    public int[] f403808o;

    /* renamed from: p, reason: collision with root package name */
    public int f403809p;

    /* renamed from: q, reason: collision with root package name */
    public String[] f403810q;

    /* renamed from: r, reason: collision with root package name */
    public String[] f403811r;

    /* renamed from: s, reason: collision with root package name */
    public String[] f403812s;

    /* renamed from: t, reason: collision with root package name */
    public String[] f403813t;

    /* renamed from: u, reason: collision with root package name */
    public String f403814u;

    /* renamed from: v, reason: collision with root package name */
    public String f403815v;

    /* renamed from: w, reason: collision with root package name */
    public String f403816w;

    /* renamed from: z, reason: collision with root package name */
    public String f403817z;

    public m() {
        a();
    }

    public m a() {
        this.f403794a = "";
        this.f403795b = "";
        String[] strArr = WireFormatNano.EMPTY_STRING_ARRAY;
        this.f403796c = strArr;
        this.f403797d = strArr;
        this.f403798e = "";
        this.f403799f = 0;
        this.f403800g = "";
        this.f403801h = 0.0f;
        this.f403802i = false;
        this.f403803j = "";
        this.f403804k = "";
        this.f403805l = "";
        int[] iArr = WireFormatNano.EMPTY_INT_ARRAY;
        this.f403806m = iArr;
        this.f403807n = "";
        this.f403808o = iArr;
        this.f403809p = 0;
        this.f403810q = strArr;
        this.f403811r = strArr;
        this.f403812s = strArr;
        this.f403813t = strArr;
        this.f403814u = "";
        this.f403815v = "";
        this.f403816w = "";
        this.f403817z = "";
        this.A = 0;
        this.B = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public m mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        int length2;
        int length3;
        int length4;
        int length5;
        int length6;
        int length7;
        int length8;
        int length9;
        int length10;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 10:
                    this.f403794a = codedInputByteBufferNano.readString();
                    break;
                case 18:
                    this.f403795b = codedInputByteBufferNano.readString();
                    break;
                case 26:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                    String[] strArr = this.f403796c;
                    if (strArr == null) {
                        length = 0;
                    } else {
                        length = strArr.length;
                    }
                    int i3 = repeatedFieldArrayLength + length;
                    String[] strArr2 = new String[i3];
                    if (length != 0) {
                        System.arraycopy(strArr, 0, strArr2, 0, length);
                    }
                    while (length < i3 - 1) {
                        strArr2[length] = codedInputByteBufferNano.readString();
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    strArr2[length] = codedInputByteBufferNano.readString();
                    this.f403796c = strArr2;
                    break;
                case 34:
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                    String[] strArr3 = this.f403797d;
                    if (strArr3 == null) {
                        length2 = 0;
                    } else {
                        length2 = strArr3.length;
                    }
                    int i16 = repeatedFieldArrayLength2 + length2;
                    String[] strArr4 = new String[i16];
                    if (length2 != 0) {
                        System.arraycopy(strArr3, 0, strArr4, 0, length2);
                    }
                    while (length2 < i16 - 1) {
                        strArr4[length2] = codedInputByteBufferNano.readString();
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    strArr4[length2] = codedInputByteBufferNano.readString();
                    this.f403797d = strArr4;
                    break;
                case 42:
                    this.f403798e = codedInputByteBufferNano.readString();
                    break;
                case 48:
                    this.f403799f = codedInputByteBufferNano.readUInt32();
                    break;
                case 74:
                    this.f403800g = codedInputByteBufferNano.readString();
                    break;
                case 85:
                    this.f403801h = codedInputByteBufferNano.readFloat();
                    break;
                case 88:
                    this.f403802i = codedInputByteBufferNano.readBool();
                    break;
                case 98:
                    this.f403803j = codedInputByteBufferNano.readString();
                    break;
                case 106:
                    this.f403804k = codedInputByteBufferNano.readString();
                    break;
                case 114:
                    this.f403805l = codedInputByteBufferNano.readString();
                    break;
                case 120:
                    int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 120);
                    int[] iArr = this.f403806m;
                    if (iArr == null) {
                        length3 = 0;
                    } else {
                        length3 = iArr.length;
                    }
                    int i17 = repeatedFieldArrayLength3 + length3;
                    int[] iArr2 = new int[i17];
                    if (length3 != 0) {
                        System.arraycopy(iArr, 0, iArr2, 0, length3);
                    }
                    while (length3 < i17 - 1) {
                        iArr2[length3] = codedInputByteBufferNano.readUInt32();
                        codedInputByteBufferNano.readTag();
                        length3++;
                    }
                    iArr2[length3] = codedInputByteBufferNano.readUInt32();
                    this.f403806m = iArr2;
                    break;
                case 122:
                    int pushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                    int position = codedInputByteBufferNano.getPosition();
                    int i18 = 0;
                    while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                        codedInputByteBufferNano.readUInt32();
                        i18++;
                    }
                    codedInputByteBufferNano.rewindToPosition(position);
                    int[] iArr3 = this.f403806m;
                    if (iArr3 == null) {
                        length4 = 0;
                    } else {
                        length4 = iArr3.length;
                    }
                    int i19 = i18 + length4;
                    int[] iArr4 = new int[i19];
                    if (length4 != 0) {
                        System.arraycopy(iArr3, 0, iArr4, 0, length4);
                    }
                    while (length4 < i19) {
                        iArr4[length4] = codedInputByteBufferNano.readUInt32();
                        length4++;
                    }
                    this.f403806m = iArr4;
                    codedInputByteBufferNano.popLimit(pushLimit);
                    break;
                case 130:
                    this.f403807n = codedInputByteBufferNano.readString();
                    break;
                case 184:
                    int repeatedFieldArrayLength4 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 184);
                    int[] iArr5 = this.f403808o;
                    if (iArr5 == null) {
                        length5 = 0;
                    } else {
                        length5 = iArr5.length;
                    }
                    int i26 = repeatedFieldArrayLength4 + length5;
                    int[] iArr6 = new int[i26];
                    if (length5 != 0) {
                        System.arraycopy(iArr5, 0, iArr6, 0, length5);
                    }
                    while (length5 < i26 - 1) {
                        iArr6[length5] = codedInputByteBufferNano.readUInt32();
                        codedInputByteBufferNano.readTag();
                        length5++;
                    }
                    iArr6[length5] = codedInputByteBufferNano.readUInt32();
                    this.f403808o = iArr6;
                    break;
                case 186:
                    int pushLimit2 = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                    int position2 = codedInputByteBufferNano.getPosition();
                    int i27 = 0;
                    while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                        codedInputByteBufferNano.readUInt32();
                        i27++;
                    }
                    codedInputByteBufferNano.rewindToPosition(position2);
                    int[] iArr7 = this.f403808o;
                    if (iArr7 == null) {
                        length6 = 0;
                    } else {
                        length6 = iArr7.length;
                    }
                    int i28 = i27 + length6;
                    int[] iArr8 = new int[i28];
                    if (length6 != 0) {
                        System.arraycopy(iArr7, 0, iArr8, 0, length6);
                    }
                    while (length6 < i28) {
                        iArr8[length6] = codedInputByteBufferNano.readUInt32();
                        length6++;
                    }
                    this.f403808o = iArr8;
                    codedInputByteBufferNano.popLimit(pushLimit2);
                    break;
                case 192:
                    this.f403809p = codedInputByteBufferNano.readUInt32();
                    break;
                case 202:
                    int repeatedFieldArrayLength5 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 202);
                    String[] strArr5 = this.f403810q;
                    if (strArr5 == null) {
                        length7 = 0;
                    } else {
                        length7 = strArr5.length;
                    }
                    int i29 = repeatedFieldArrayLength5 + length7;
                    String[] strArr6 = new String[i29];
                    if (length7 != 0) {
                        System.arraycopy(strArr5, 0, strArr6, 0, length7);
                    }
                    while (length7 < i29 - 1) {
                        strArr6[length7] = codedInputByteBufferNano.readString();
                        codedInputByteBufferNano.readTag();
                        length7++;
                    }
                    strArr6[length7] = codedInputByteBufferNano.readString();
                    this.f403810q = strArr6;
                    break;
                case 210:
                    int repeatedFieldArrayLength6 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 210);
                    String[] strArr7 = this.f403811r;
                    if (strArr7 == null) {
                        length8 = 0;
                    } else {
                        length8 = strArr7.length;
                    }
                    int i36 = repeatedFieldArrayLength6 + length8;
                    String[] strArr8 = new String[i36];
                    if (length8 != 0) {
                        System.arraycopy(strArr7, 0, strArr8, 0, length8);
                    }
                    while (length8 < i36 - 1) {
                        strArr8[length8] = codedInputByteBufferNano.readString();
                        codedInputByteBufferNano.readTag();
                        length8++;
                    }
                    strArr8[length8] = codedInputByteBufferNano.readString();
                    this.f403811r = strArr8;
                    break;
                case 218:
                    int repeatedFieldArrayLength7 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 218);
                    String[] strArr9 = this.f403812s;
                    if (strArr9 == null) {
                        length9 = 0;
                    } else {
                        length9 = strArr9.length;
                    }
                    int i37 = repeatedFieldArrayLength7 + length9;
                    String[] strArr10 = new String[i37];
                    if (length9 != 0) {
                        System.arraycopy(strArr9, 0, strArr10, 0, length9);
                    }
                    while (length9 < i37 - 1) {
                        strArr10[length9] = codedInputByteBufferNano.readString();
                        codedInputByteBufferNano.readTag();
                        length9++;
                    }
                    strArr10[length9] = codedInputByteBufferNano.readString();
                    this.f403812s = strArr10;
                    break;
                case 226:
                    int repeatedFieldArrayLength8 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 226);
                    String[] strArr11 = this.f403813t;
                    if (strArr11 == null) {
                        length10 = 0;
                    } else {
                        length10 = strArr11.length;
                    }
                    int i38 = repeatedFieldArrayLength8 + length10;
                    String[] strArr12 = new String[i38];
                    if (length10 != 0) {
                        System.arraycopy(strArr11, 0, strArr12, 0, length10);
                    }
                    while (length10 < i38 - 1) {
                        strArr12[length10] = codedInputByteBufferNano.readString();
                        codedInputByteBufferNano.readTag();
                        length10++;
                    }
                    strArr12[length10] = codedInputByteBufferNano.readString();
                    this.f403813t = strArr12;
                    break;
                case 234:
                    this.f403814u = codedInputByteBufferNano.readString();
                    break;
                case 242:
                    this.f403815v = codedInputByteBufferNano.readString();
                    break;
                case 250:
                    this.f403816w = codedInputByteBufferNano.readString();
                    break;
                case 258:
                    this.f403817z = codedInputByteBufferNano.readString();
                    break;
                case 264:
                    this.A = codedInputByteBufferNano.readUInt32();
                    break;
                case 274:
                    this.B = codedInputByteBufferNano.readString();
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
        int[] iArr2;
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f403794a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f403794a);
        }
        if (!this.f403795b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f403795b);
        }
        String[] strArr = this.f403796c;
        int i3 = 0;
        if (strArr != null && strArr.length > 0) {
            int i16 = 0;
            int i17 = 0;
            int i18 = 0;
            while (true) {
                String[] strArr2 = this.f403796c;
                if (i16 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i16];
                if (str != null) {
                    i18++;
                    i17 += CodedOutputByteBufferNano.computeStringSizeNoTag(str);
                }
                i16++;
            }
            computeSerializedSize = computeSerializedSize + i17 + (i18 * 1);
        }
        String[] strArr3 = this.f403797d;
        if (strArr3 != null && strArr3.length > 0) {
            int i19 = 0;
            int i26 = 0;
            int i27 = 0;
            while (true) {
                String[] strArr4 = this.f403797d;
                if (i19 >= strArr4.length) {
                    break;
                }
                String str2 = strArr4[i19];
                if (str2 != null) {
                    i27++;
                    i26 += CodedOutputByteBufferNano.computeStringSizeNoTag(str2);
                }
                i19++;
            }
            computeSerializedSize = computeSerializedSize + i26 + (i27 * 1);
        }
        if (!this.f403798e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f403798e);
        }
        int i28 = this.f403799f;
        if (i28 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i28);
        }
        if (!this.f403800g.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.f403800g);
        }
        if (Float.floatToIntBits(this.f403801h) != Float.floatToIntBits(0.0f)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(10, this.f403801h);
        }
        boolean z16 = this.f403802i;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(11, z16);
        }
        if (!this.f403803j.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(12, this.f403803j);
        }
        if (!this.f403804k.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(13, this.f403804k);
        }
        if (!this.f403805l.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(14, this.f403805l);
        }
        int[] iArr3 = this.f403806m;
        if (iArr3 != null && iArr3.length > 0) {
            int i29 = 0;
            int i36 = 0;
            while (true) {
                iArr2 = this.f403806m;
                if (i29 >= iArr2.length) {
                    break;
                }
                i36 += CodedOutputByteBufferNano.computeUInt32SizeNoTag(iArr2[i29]);
                i29++;
            }
            computeSerializedSize = computeSerializedSize + i36 + (iArr2.length * 1);
        }
        if (!this.f403807n.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(16, this.f403807n);
        }
        int[] iArr4 = this.f403808o;
        if (iArr4 != null && iArr4.length > 0) {
            int i37 = 0;
            int i38 = 0;
            while (true) {
                iArr = this.f403808o;
                if (i37 >= iArr.length) {
                    break;
                }
                i38 += CodedOutputByteBufferNano.computeUInt32SizeNoTag(iArr[i37]);
                i37++;
            }
            computeSerializedSize = computeSerializedSize + i38 + (iArr.length * 2);
        }
        int i39 = this.f403809p;
        if (i39 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(24, i39);
        }
        String[] strArr5 = this.f403810q;
        if (strArr5 != null && strArr5.length > 0) {
            int i46 = 0;
            int i47 = 0;
            int i48 = 0;
            while (true) {
                String[] strArr6 = this.f403810q;
                if (i46 >= strArr6.length) {
                    break;
                }
                String str3 = strArr6[i46];
                if (str3 != null) {
                    i48++;
                    i47 += CodedOutputByteBufferNano.computeStringSizeNoTag(str3);
                }
                i46++;
            }
            computeSerializedSize = computeSerializedSize + i47 + (i48 * 2);
        }
        String[] strArr7 = this.f403811r;
        if (strArr7 != null && strArr7.length > 0) {
            int i49 = 0;
            int i56 = 0;
            int i57 = 0;
            while (true) {
                String[] strArr8 = this.f403811r;
                if (i49 >= strArr8.length) {
                    break;
                }
                String str4 = strArr8[i49];
                if (str4 != null) {
                    i57++;
                    i56 += CodedOutputByteBufferNano.computeStringSizeNoTag(str4);
                }
                i49++;
            }
            computeSerializedSize = computeSerializedSize + i56 + (i57 * 2);
        }
        String[] strArr9 = this.f403812s;
        if (strArr9 != null && strArr9.length > 0) {
            int i58 = 0;
            int i59 = 0;
            int i65 = 0;
            while (true) {
                String[] strArr10 = this.f403812s;
                if (i58 >= strArr10.length) {
                    break;
                }
                String str5 = strArr10[i58];
                if (str5 != null) {
                    i65++;
                    i59 += CodedOutputByteBufferNano.computeStringSizeNoTag(str5);
                }
                i58++;
            }
            computeSerializedSize = computeSerializedSize + i59 + (i65 * 2);
        }
        String[] strArr11 = this.f403813t;
        if (strArr11 != null && strArr11.length > 0) {
            int i66 = 0;
            int i67 = 0;
            while (true) {
                String[] strArr12 = this.f403813t;
                if (i3 >= strArr12.length) {
                    break;
                }
                String str6 = strArr12[i3];
                if (str6 != null) {
                    i67++;
                    i66 += CodedOutputByteBufferNano.computeStringSizeNoTag(str6);
                }
                i3++;
            }
            computeSerializedSize = computeSerializedSize + i66 + (i67 * 2);
        }
        if (!this.f403814u.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(29, this.f403814u);
        }
        if (!this.f403815v.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(30, this.f403815v);
        }
        if (!this.f403816w.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(31, this.f403816w);
        }
        if (!this.f403817z.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(32, this.f403817z);
        }
        int i68 = this.A;
        if (i68 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(33, i68);
        }
        if (!this.B.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(34, this.B);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f403794a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f403794a);
        }
        if (!this.f403795b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f403795b);
        }
        String[] strArr = this.f403796c;
        int i3 = 0;
        if (strArr != null && strArr.length > 0) {
            int i16 = 0;
            while (true) {
                String[] strArr2 = this.f403796c;
                if (i16 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i16];
                if (str != null) {
                    codedOutputByteBufferNano.writeString(3, str);
                }
                i16++;
            }
        }
        String[] strArr3 = this.f403797d;
        if (strArr3 != null && strArr3.length > 0) {
            int i17 = 0;
            while (true) {
                String[] strArr4 = this.f403797d;
                if (i17 >= strArr4.length) {
                    break;
                }
                String str2 = strArr4[i17];
                if (str2 != null) {
                    codedOutputByteBufferNano.writeString(4, str2);
                }
                i17++;
            }
        }
        if (!this.f403798e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f403798e);
        }
        int i18 = this.f403799f;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i18);
        }
        if (!this.f403800g.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.f403800g);
        }
        if (Float.floatToIntBits(this.f403801h) != Float.floatToIntBits(0.0f)) {
            codedOutputByteBufferNano.writeFloat(10, this.f403801h);
        }
        boolean z16 = this.f403802i;
        if (z16) {
            codedOutputByteBufferNano.writeBool(11, z16);
        }
        if (!this.f403803j.equals("")) {
            codedOutputByteBufferNano.writeString(12, this.f403803j);
        }
        if (!this.f403804k.equals("")) {
            codedOutputByteBufferNano.writeString(13, this.f403804k);
        }
        if (!this.f403805l.equals("")) {
            codedOutputByteBufferNano.writeString(14, this.f403805l);
        }
        int[] iArr = this.f403806m;
        if (iArr != null && iArr.length > 0) {
            int i19 = 0;
            while (true) {
                int[] iArr2 = this.f403806m;
                if (i19 >= iArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeUInt32(15, iArr2[i19]);
                i19++;
            }
        }
        if (!this.f403807n.equals("")) {
            codedOutputByteBufferNano.writeString(16, this.f403807n);
        }
        int[] iArr3 = this.f403808o;
        if (iArr3 != null && iArr3.length > 0) {
            int i26 = 0;
            while (true) {
                int[] iArr4 = this.f403808o;
                if (i26 >= iArr4.length) {
                    break;
                }
                codedOutputByteBufferNano.writeUInt32(23, iArr4[i26]);
                i26++;
            }
        }
        int i27 = this.f403809p;
        if (i27 != 0) {
            codedOutputByteBufferNano.writeUInt32(24, i27);
        }
        String[] strArr5 = this.f403810q;
        if (strArr5 != null && strArr5.length > 0) {
            int i28 = 0;
            while (true) {
                String[] strArr6 = this.f403810q;
                if (i28 >= strArr6.length) {
                    break;
                }
                String str3 = strArr6[i28];
                if (str3 != null) {
                    codedOutputByteBufferNano.writeString(25, str3);
                }
                i28++;
            }
        }
        String[] strArr7 = this.f403811r;
        if (strArr7 != null && strArr7.length > 0) {
            int i29 = 0;
            while (true) {
                String[] strArr8 = this.f403811r;
                if (i29 >= strArr8.length) {
                    break;
                }
                String str4 = strArr8[i29];
                if (str4 != null) {
                    codedOutputByteBufferNano.writeString(26, str4);
                }
                i29++;
            }
        }
        String[] strArr9 = this.f403812s;
        if (strArr9 != null && strArr9.length > 0) {
            int i36 = 0;
            while (true) {
                String[] strArr10 = this.f403812s;
                if (i36 >= strArr10.length) {
                    break;
                }
                String str5 = strArr10[i36];
                if (str5 != null) {
                    codedOutputByteBufferNano.writeString(27, str5);
                }
                i36++;
            }
        }
        String[] strArr11 = this.f403813t;
        if (strArr11 != null && strArr11.length > 0) {
            while (true) {
                String[] strArr12 = this.f403813t;
                if (i3 >= strArr12.length) {
                    break;
                }
                String str6 = strArr12[i3];
                if (str6 != null) {
                    codedOutputByteBufferNano.writeString(28, str6);
                }
                i3++;
            }
        }
        if (!this.f403814u.equals("")) {
            codedOutputByteBufferNano.writeString(29, this.f403814u);
        }
        if (!this.f403815v.equals("")) {
            codedOutputByteBufferNano.writeString(30, this.f403815v);
        }
        if (!this.f403816w.equals("")) {
            codedOutputByteBufferNano.writeString(31, this.f403816w);
        }
        if (!this.f403817z.equals("")) {
            codedOutputByteBufferNano.writeString(32, this.f403817z);
        }
        int i37 = this.A;
        if (i37 != 0) {
            codedOutputByteBufferNano.writeUInt32(33, i37);
        }
        if (!this.B.equals("")) {
            codedOutputByteBufferNano.writeString(34, this.B);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
