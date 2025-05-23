package jx4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class a extends ExtendableMessageNano<a> {
    public int A;
    public int B;
    public int C;
    public String[] D;
    public int E;
    public float[] F;
    public float[] G;
    public float[] H;

    /* renamed from: a, reason: collision with root package name */
    public int f411115a;

    /* renamed from: b, reason: collision with root package name */
    public String f411116b;

    /* renamed from: c, reason: collision with root package name */
    public int[] f411117c;

    /* renamed from: d, reason: collision with root package name */
    public int f411118d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f411119e;

    /* renamed from: f, reason: collision with root package name */
    public String f411120f;

    /* renamed from: g, reason: collision with root package name */
    public int f411121g;

    /* renamed from: h, reason: collision with root package name */
    public int f411122h;

    /* renamed from: i, reason: collision with root package name */
    public int f411123i;

    /* renamed from: j, reason: collision with root package name */
    public int f411124j;

    /* renamed from: k, reason: collision with root package name */
    public String[] f411125k;

    /* renamed from: l, reason: collision with root package name */
    public String[] f411126l;

    /* renamed from: m, reason: collision with root package name */
    public String[] f411127m;

    /* renamed from: n, reason: collision with root package name */
    public String[] f411128n;

    /* renamed from: o, reason: collision with root package name */
    public String[] f411129o;

    /* renamed from: p, reason: collision with root package name */
    public String[] f411130p;

    /* renamed from: q, reason: collision with root package name */
    public String[] f411131q;

    /* renamed from: r, reason: collision with root package name */
    public String[] f411132r;

    /* renamed from: s, reason: collision with root package name */
    public String[] f411133s;

    /* renamed from: t, reason: collision with root package name */
    public String[] f411134t;

    /* renamed from: u, reason: collision with root package name */
    public String[] f411135u;

    /* renamed from: v, reason: collision with root package name */
    public String[] f411136v;

    /* renamed from: w, reason: collision with root package name */
    public String f411137w;

    /* renamed from: z, reason: collision with root package name */
    public String[] f411138z;

    public a() {
        a();
    }

    public static a c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (a) MessageNano.mergeFrom(new a(), bArr);
    }

    public a a() {
        this.f411115a = 0;
        this.f411116b = "";
        this.f411117c = WireFormatNano.EMPTY_INT_ARRAY;
        this.f411118d = 0;
        this.f411119e = false;
        this.f411120f = "";
        this.f411121g = 0;
        this.f411122h = 0;
        this.f411123i = 0;
        this.f411124j = 0;
        String[] strArr = WireFormatNano.EMPTY_STRING_ARRAY;
        this.f411125k = strArr;
        this.f411126l = strArr;
        this.f411127m = strArr;
        this.f411128n = strArr;
        this.f411129o = strArr;
        this.f411130p = strArr;
        this.f411131q = strArr;
        this.f411132r = strArr;
        this.f411133s = strArr;
        this.f411134t = strArr;
        this.f411135u = strArr;
        this.f411136v = strArr;
        this.f411137w = "";
        this.f411138z = strArr;
        this.A = 0;
        this.B = 0;
        this.C = 0;
        this.D = strArr;
        this.E = 0;
        float[] fArr = WireFormatNano.EMPTY_FLOAT_ARRAY;
        this.F = fArr;
        this.G = fArr;
        this.H = fArr;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
        int length11;
        int length12;
        int length13;
        int length14;
        int length15;
        int length16;
        int length17;
        int length18;
        int length19;
        int length20;
        int length21;
        int length22;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.f411115a = codedInputByteBufferNano.readUInt32();
                    break;
                case 18:
                    this.f411116b = codedInputByteBufferNano.readString();
                    break;
                case 24:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 24);
                    int[] iArr = this.f411117c;
                    if (iArr == null) {
                        length = 0;
                    } else {
                        length = iArr.length;
                    }
                    int i3 = repeatedFieldArrayLength + length;
                    int[] iArr2 = new int[i3];
                    if (length != 0) {
                        System.arraycopy(iArr, 0, iArr2, 0, length);
                    }
                    while (length < i3 - 1) {
                        iArr2[length] = codedInputByteBufferNano.readUInt32();
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    iArr2[length] = codedInputByteBufferNano.readUInt32();
                    this.f411117c = iArr2;
                    break;
                case 26:
                    int pushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                    int position = codedInputByteBufferNano.getPosition();
                    int i16 = 0;
                    while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                        codedInputByteBufferNano.readUInt32();
                        i16++;
                    }
                    codedInputByteBufferNano.rewindToPosition(position);
                    int[] iArr3 = this.f411117c;
                    if (iArr3 == null) {
                        length2 = 0;
                    } else {
                        length2 = iArr3.length;
                    }
                    int i17 = i16 + length2;
                    int[] iArr4 = new int[i17];
                    if (length2 != 0) {
                        System.arraycopy(iArr3, 0, iArr4, 0, length2);
                    }
                    while (length2 < i17) {
                        iArr4[length2] = codedInputByteBufferNano.readUInt32();
                        length2++;
                    }
                    this.f411117c = iArr4;
                    codedInputByteBufferNano.popLimit(pushLimit);
                    break;
                case 32:
                    this.f411118d = codedInputByteBufferNano.readUInt32();
                    break;
                case 40:
                    this.f411119e = codedInputByteBufferNano.readBool();
                    break;
                case 50:
                    this.f411120f = codedInputByteBufferNano.readString();
                    break;
                case 56:
                    this.f411121g = codedInputByteBufferNano.readUInt32();
                    break;
                case 64:
                    this.f411122h = codedInputByteBufferNano.readUInt32();
                    break;
                case 72:
                    this.f411123i = codedInputByteBufferNano.readUInt32();
                    break;
                case 80:
                    this.f411124j = codedInputByteBufferNano.readUInt32();
                    break;
                case 90:
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 90);
                    String[] strArr = this.f411125k;
                    if (strArr == null) {
                        length3 = 0;
                    } else {
                        length3 = strArr.length;
                    }
                    int i18 = repeatedFieldArrayLength2 + length3;
                    String[] strArr2 = new String[i18];
                    if (length3 != 0) {
                        System.arraycopy(strArr, 0, strArr2, 0, length3);
                    }
                    while (length3 < i18 - 1) {
                        strArr2[length3] = codedInputByteBufferNano.readString();
                        codedInputByteBufferNano.readTag();
                        length3++;
                    }
                    strArr2[length3] = codedInputByteBufferNano.readString();
                    this.f411125k = strArr2;
                    break;
                case 98:
                    int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 98);
                    String[] strArr3 = this.f411126l;
                    if (strArr3 == null) {
                        length4 = 0;
                    } else {
                        length4 = strArr3.length;
                    }
                    int i19 = repeatedFieldArrayLength3 + length4;
                    String[] strArr4 = new String[i19];
                    if (length4 != 0) {
                        System.arraycopy(strArr3, 0, strArr4, 0, length4);
                    }
                    while (length4 < i19 - 1) {
                        strArr4[length4] = codedInputByteBufferNano.readString();
                        codedInputByteBufferNano.readTag();
                        length4++;
                    }
                    strArr4[length4] = codedInputByteBufferNano.readString();
                    this.f411126l = strArr4;
                    break;
                case 106:
                    int repeatedFieldArrayLength4 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 106);
                    String[] strArr5 = this.f411127m;
                    if (strArr5 == null) {
                        length5 = 0;
                    } else {
                        length5 = strArr5.length;
                    }
                    int i26 = repeatedFieldArrayLength4 + length5;
                    String[] strArr6 = new String[i26];
                    if (length5 != 0) {
                        System.arraycopy(strArr5, 0, strArr6, 0, length5);
                    }
                    while (length5 < i26 - 1) {
                        strArr6[length5] = codedInputByteBufferNano.readString();
                        codedInputByteBufferNano.readTag();
                        length5++;
                    }
                    strArr6[length5] = codedInputByteBufferNano.readString();
                    this.f411127m = strArr6;
                    break;
                case 114:
                    int repeatedFieldArrayLength5 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 114);
                    String[] strArr7 = this.f411128n;
                    if (strArr7 == null) {
                        length6 = 0;
                    } else {
                        length6 = strArr7.length;
                    }
                    int i27 = repeatedFieldArrayLength5 + length6;
                    String[] strArr8 = new String[i27];
                    if (length6 != 0) {
                        System.arraycopy(strArr7, 0, strArr8, 0, length6);
                    }
                    while (length6 < i27 - 1) {
                        strArr8[length6] = codedInputByteBufferNano.readString();
                        codedInputByteBufferNano.readTag();
                        length6++;
                    }
                    strArr8[length6] = codedInputByteBufferNano.readString();
                    this.f411128n = strArr8;
                    break;
                case 122:
                    int repeatedFieldArrayLength6 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 122);
                    String[] strArr9 = this.f411129o;
                    if (strArr9 == null) {
                        length7 = 0;
                    } else {
                        length7 = strArr9.length;
                    }
                    int i28 = repeatedFieldArrayLength6 + length7;
                    String[] strArr10 = new String[i28];
                    if (length7 != 0) {
                        System.arraycopy(strArr9, 0, strArr10, 0, length7);
                    }
                    while (length7 < i28 - 1) {
                        strArr10[length7] = codedInputByteBufferNano.readString();
                        codedInputByteBufferNano.readTag();
                        length7++;
                    }
                    strArr10[length7] = codedInputByteBufferNano.readString();
                    this.f411129o = strArr10;
                    break;
                case 130:
                    int repeatedFieldArrayLength7 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 130);
                    String[] strArr11 = this.f411130p;
                    if (strArr11 == null) {
                        length8 = 0;
                    } else {
                        length8 = strArr11.length;
                    }
                    int i29 = repeatedFieldArrayLength7 + length8;
                    String[] strArr12 = new String[i29];
                    if (length8 != 0) {
                        System.arraycopy(strArr11, 0, strArr12, 0, length8);
                    }
                    while (length8 < i29 - 1) {
                        strArr12[length8] = codedInputByteBufferNano.readString();
                        codedInputByteBufferNano.readTag();
                        length8++;
                    }
                    strArr12[length8] = codedInputByteBufferNano.readString();
                    this.f411130p = strArr12;
                    break;
                case 138:
                    int repeatedFieldArrayLength8 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 138);
                    String[] strArr13 = this.f411131q;
                    if (strArr13 == null) {
                        length9 = 0;
                    } else {
                        length9 = strArr13.length;
                    }
                    int i36 = repeatedFieldArrayLength8 + length9;
                    String[] strArr14 = new String[i36];
                    if (length9 != 0) {
                        System.arraycopy(strArr13, 0, strArr14, 0, length9);
                    }
                    while (length9 < i36 - 1) {
                        strArr14[length9] = codedInputByteBufferNano.readString();
                        codedInputByteBufferNano.readTag();
                        length9++;
                    }
                    strArr14[length9] = codedInputByteBufferNano.readString();
                    this.f411131q = strArr14;
                    break;
                case 146:
                    int repeatedFieldArrayLength9 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 146);
                    String[] strArr15 = this.f411132r;
                    if (strArr15 == null) {
                        length10 = 0;
                    } else {
                        length10 = strArr15.length;
                    }
                    int i37 = repeatedFieldArrayLength9 + length10;
                    String[] strArr16 = new String[i37];
                    if (length10 != 0) {
                        System.arraycopy(strArr15, 0, strArr16, 0, length10);
                    }
                    while (length10 < i37 - 1) {
                        strArr16[length10] = codedInputByteBufferNano.readString();
                        codedInputByteBufferNano.readTag();
                        length10++;
                    }
                    strArr16[length10] = codedInputByteBufferNano.readString();
                    this.f411132r = strArr16;
                    break;
                case 154:
                    int repeatedFieldArrayLength10 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 154);
                    String[] strArr17 = this.f411133s;
                    if (strArr17 == null) {
                        length11 = 0;
                    } else {
                        length11 = strArr17.length;
                    }
                    int i38 = repeatedFieldArrayLength10 + length11;
                    String[] strArr18 = new String[i38];
                    if (length11 != 0) {
                        System.arraycopy(strArr17, 0, strArr18, 0, length11);
                    }
                    while (length11 < i38 - 1) {
                        strArr18[length11] = codedInputByteBufferNano.readString();
                        codedInputByteBufferNano.readTag();
                        length11++;
                    }
                    strArr18[length11] = codedInputByteBufferNano.readString();
                    this.f411133s = strArr18;
                    break;
                case 162:
                    int repeatedFieldArrayLength11 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 162);
                    String[] strArr19 = this.f411134t;
                    if (strArr19 == null) {
                        length12 = 0;
                    } else {
                        length12 = strArr19.length;
                    }
                    int i39 = repeatedFieldArrayLength11 + length12;
                    String[] strArr20 = new String[i39];
                    if (length12 != 0) {
                        System.arraycopy(strArr19, 0, strArr20, 0, length12);
                    }
                    while (length12 < i39 - 1) {
                        strArr20[length12] = codedInputByteBufferNano.readString();
                        codedInputByteBufferNano.readTag();
                        length12++;
                    }
                    strArr20[length12] = codedInputByteBufferNano.readString();
                    this.f411134t = strArr20;
                    break;
                case 170:
                    int repeatedFieldArrayLength12 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 170);
                    String[] strArr21 = this.f411135u;
                    if (strArr21 == null) {
                        length13 = 0;
                    } else {
                        length13 = strArr21.length;
                    }
                    int i46 = repeatedFieldArrayLength12 + length13;
                    String[] strArr22 = new String[i46];
                    if (length13 != 0) {
                        System.arraycopy(strArr21, 0, strArr22, 0, length13);
                    }
                    while (length13 < i46 - 1) {
                        strArr22[length13] = codedInputByteBufferNano.readString();
                        codedInputByteBufferNano.readTag();
                        length13++;
                    }
                    strArr22[length13] = codedInputByteBufferNano.readString();
                    this.f411135u = strArr22;
                    break;
                case 178:
                    int repeatedFieldArrayLength13 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 178);
                    String[] strArr23 = this.f411136v;
                    if (strArr23 == null) {
                        length14 = 0;
                    } else {
                        length14 = strArr23.length;
                    }
                    int i47 = repeatedFieldArrayLength13 + length14;
                    String[] strArr24 = new String[i47];
                    if (length14 != 0) {
                        System.arraycopy(strArr23, 0, strArr24, 0, length14);
                    }
                    while (length14 < i47 - 1) {
                        strArr24[length14] = codedInputByteBufferNano.readString();
                        codedInputByteBufferNano.readTag();
                        length14++;
                    }
                    strArr24[length14] = codedInputByteBufferNano.readString();
                    this.f411136v = strArr24;
                    break;
                case 186:
                    this.f411137w = codedInputByteBufferNano.readString();
                    break;
                case 194:
                    int repeatedFieldArrayLength14 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 194);
                    String[] strArr25 = this.f411138z;
                    if (strArr25 == null) {
                        length15 = 0;
                    } else {
                        length15 = strArr25.length;
                    }
                    int i48 = repeatedFieldArrayLength14 + length15;
                    String[] strArr26 = new String[i48];
                    if (length15 != 0) {
                        System.arraycopy(strArr25, 0, strArr26, 0, length15);
                    }
                    while (length15 < i48 - 1) {
                        strArr26[length15] = codedInputByteBufferNano.readString();
                        codedInputByteBufferNano.readTag();
                        length15++;
                    }
                    strArr26[length15] = codedInputByteBufferNano.readString();
                    this.f411138z = strArr26;
                    break;
                case 200:
                    this.A = codedInputByteBufferNano.readUInt32();
                    break;
                case 208:
                    this.B = codedInputByteBufferNano.readUInt32();
                    break;
                case 216:
                    this.C = codedInputByteBufferNano.readUInt32();
                    break;
                case 226:
                    int repeatedFieldArrayLength15 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 226);
                    String[] strArr27 = this.D;
                    if (strArr27 == null) {
                        length16 = 0;
                    } else {
                        length16 = strArr27.length;
                    }
                    int i49 = repeatedFieldArrayLength15 + length16;
                    String[] strArr28 = new String[i49];
                    if (length16 != 0) {
                        System.arraycopy(strArr27, 0, strArr28, 0, length16);
                    }
                    while (length16 < i49 - 1) {
                        strArr28[length16] = codedInputByteBufferNano.readString();
                        codedInputByteBufferNano.readTag();
                        length16++;
                    }
                    strArr28[length16] = codedInputByteBufferNano.readString();
                    this.D = strArr28;
                    break;
                case 232:
                    this.E = codedInputByteBufferNano.readUInt32();
                    break;
                case 242:
                    int readRawVarint32 = codedInputByteBufferNano.readRawVarint32();
                    int pushLimit2 = codedInputByteBufferNano.pushLimit(readRawVarint32);
                    int i56 = readRawVarint32 / 4;
                    float[] fArr = this.F;
                    if (fArr == null) {
                        length17 = 0;
                    } else {
                        length17 = fArr.length;
                    }
                    int i57 = i56 + length17;
                    float[] fArr2 = new float[i57];
                    if (length17 != 0) {
                        System.arraycopy(fArr, 0, fArr2, 0, length17);
                    }
                    while (length17 < i57) {
                        fArr2[length17] = codedInputByteBufferNano.readFloat();
                        length17++;
                    }
                    this.F = fArr2;
                    codedInputByteBufferNano.popLimit(pushLimit2);
                    break;
                case 245:
                    int repeatedFieldArrayLength16 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 245);
                    float[] fArr3 = this.F;
                    if (fArr3 == null) {
                        length18 = 0;
                    } else {
                        length18 = fArr3.length;
                    }
                    int i58 = repeatedFieldArrayLength16 + length18;
                    float[] fArr4 = new float[i58];
                    if (length18 != 0) {
                        System.arraycopy(fArr3, 0, fArr4, 0, length18);
                    }
                    while (length18 < i58 - 1) {
                        fArr4[length18] = codedInputByteBufferNano.readFloat();
                        codedInputByteBufferNano.readTag();
                        length18++;
                    }
                    fArr4[length18] = codedInputByteBufferNano.readFloat();
                    this.F = fArr4;
                    break;
                case 250:
                    int readRawVarint322 = codedInputByteBufferNano.readRawVarint32();
                    int pushLimit3 = codedInputByteBufferNano.pushLimit(readRawVarint322);
                    int i59 = readRawVarint322 / 4;
                    float[] fArr5 = this.G;
                    if (fArr5 == null) {
                        length19 = 0;
                    } else {
                        length19 = fArr5.length;
                    }
                    int i65 = i59 + length19;
                    float[] fArr6 = new float[i65];
                    if (length19 != 0) {
                        System.arraycopy(fArr5, 0, fArr6, 0, length19);
                    }
                    while (length19 < i65) {
                        fArr6[length19] = codedInputByteBufferNano.readFloat();
                        length19++;
                    }
                    this.G = fArr6;
                    codedInputByteBufferNano.popLimit(pushLimit3);
                    break;
                case 253:
                    int repeatedFieldArrayLength17 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 253);
                    float[] fArr7 = this.G;
                    if (fArr7 == null) {
                        length20 = 0;
                    } else {
                        length20 = fArr7.length;
                    }
                    int i66 = repeatedFieldArrayLength17 + length20;
                    float[] fArr8 = new float[i66];
                    if (length20 != 0) {
                        System.arraycopy(fArr7, 0, fArr8, 0, length20);
                    }
                    while (length20 < i66 - 1) {
                        fArr8[length20] = codedInputByteBufferNano.readFloat();
                        codedInputByteBufferNano.readTag();
                        length20++;
                    }
                    fArr8[length20] = codedInputByteBufferNano.readFloat();
                    this.G = fArr8;
                    break;
                case 258:
                    int readRawVarint323 = codedInputByteBufferNano.readRawVarint32();
                    int pushLimit4 = codedInputByteBufferNano.pushLimit(readRawVarint323);
                    int i67 = readRawVarint323 / 4;
                    float[] fArr9 = this.H;
                    if (fArr9 == null) {
                        length21 = 0;
                    } else {
                        length21 = fArr9.length;
                    }
                    int i68 = i67 + length21;
                    float[] fArr10 = new float[i68];
                    if (length21 != 0) {
                        System.arraycopy(fArr9, 0, fArr10, 0, length21);
                    }
                    while (length21 < i68) {
                        fArr10[length21] = codedInputByteBufferNano.readFloat();
                        length21++;
                    }
                    this.H = fArr10;
                    codedInputByteBufferNano.popLimit(pushLimit4);
                    break;
                case 261:
                    int repeatedFieldArrayLength18 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 261);
                    float[] fArr11 = this.H;
                    if (fArr11 == null) {
                        length22 = 0;
                    } else {
                        length22 = fArr11.length;
                    }
                    int i69 = repeatedFieldArrayLength18 + length22;
                    float[] fArr12 = new float[i69];
                    if (length22 != 0) {
                        System.arraycopy(fArr11, 0, fArr12, 0, length22);
                    }
                    while (length22 < i69 - 1) {
                        fArr12[length22] = codedInputByteBufferNano.readFloat();
                        codedInputByteBufferNano.readTag();
                        length22++;
                    }
                    fArr12[length22] = codedInputByteBufferNano.readFloat();
                    this.H = fArr12;
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
        int i3 = this.f411115a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        if (!this.f411116b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f411116b);
        }
        int[] iArr2 = this.f411117c;
        int i16 = 0;
        if (iArr2 != null && iArr2.length > 0) {
            int i17 = 0;
            int i18 = 0;
            while (true) {
                iArr = this.f411117c;
                if (i17 >= iArr.length) {
                    break;
                }
                i18 += CodedOutputByteBufferNano.computeUInt32SizeNoTag(iArr[i17]);
                i17++;
            }
            computeSerializedSize = computeSerializedSize + i18 + (iArr.length * 1);
        }
        int i19 = this.f411118d;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i19);
        }
        boolean z16 = this.f411119e;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(5, z16);
        }
        if (!this.f411120f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f411120f);
        }
        int i26 = this.f411121g;
        if (i26 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(7, i26);
        }
        int i27 = this.f411122h;
        if (i27 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(8, i27);
        }
        int i28 = this.f411123i;
        if (i28 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(9, i28);
        }
        int i29 = this.f411124j;
        if (i29 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(10, i29);
        }
        String[] strArr = this.f411125k;
        if (strArr != null && strArr.length > 0) {
            int i36 = 0;
            int i37 = 0;
            int i38 = 0;
            while (true) {
                String[] strArr2 = this.f411125k;
                if (i36 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i36];
                if (str != null) {
                    i38++;
                    i37 += CodedOutputByteBufferNano.computeStringSizeNoTag(str);
                }
                i36++;
            }
            computeSerializedSize = computeSerializedSize + i37 + (i38 * 1);
        }
        String[] strArr3 = this.f411126l;
        if (strArr3 != null && strArr3.length > 0) {
            int i39 = 0;
            int i46 = 0;
            int i47 = 0;
            while (true) {
                String[] strArr4 = this.f411126l;
                if (i39 >= strArr4.length) {
                    break;
                }
                String str2 = strArr4[i39];
                if (str2 != null) {
                    i47++;
                    i46 += CodedOutputByteBufferNano.computeStringSizeNoTag(str2);
                }
                i39++;
            }
            computeSerializedSize = computeSerializedSize + i46 + (i47 * 1);
        }
        String[] strArr5 = this.f411127m;
        if (strArr5 != null && strArr5.length > 0) {
            int i48 = 0;
            int i49 = 0;
            int i56 = 0;
            while (true) {
                String[] strArr6 = this.f411127m;
                if (i48 >= strArr6.length) {
                    break;
                }
                String str3 = strArr6[i48];
                if (str3 != null) {
                    i56++;
                    i49 += CodedOutputByteBufferNano.computeStringSizeNoTag(str3);
                }
                i48++;
            }
            computeSerializedSize = computeSerializedSize + i49 + (i56 * 1);
        }
        String[] strArr7 = this.f411128n;
        if (strArr7 != null && strArr7.length > 0) {
            int i57 = 0;
            int i58 = 0;
            int i59 = 0;
            while (true) {
                String[] strArr8 = this.f411128n;
                if (i57 >= strArr8.length) {
                    break;
                }
                String str4 = strArr8[i57];
                if (str4 != null) {
                    i59++;
                    i58 += CodedOutputByteBufferNano.computeStringSizeNoTag(str4);
                }
                i57++;
            }
            computeSerializedSize = computeSerializedSize + i58 + (i59 * 1);
        }
        String[] strArr9 = this.f411129o;
        if (strArr9 != null && strArr9.length > 0) {
            int i65 = 0;
            int i66 = 0;
            int i67 = 0;
            while (true) {
                String[] strArr10 = this.f411129o;
                if (i65 >= strArr10.length) {
                    break;
                }
                String str5 = strArr10[i65];
                if (str5 != null) {
                    i67++;
                    i66 += CodedOutputByteBufferNano.computeStringSizeNoTag(str5);
                }
                i65++;
            }
            computeSerializedSize = computeSerializedSize + i66 + (i67 * 1);
        }
        String[] strArr11 = this.f411130p;
        if (strArr11 != null && strArr11.length > 0) {
            int i68 = 0;
            int i69 = 0;
            int i75 = 0;
            while (true) {
                String[] strArr12 = this.f411130p;
                if (i68 >= strArr12.length) {
                    break;
                }
                String str6 = strArr12[i68];
                if (str6 != null) {
                    i75++;
                    i69 += CodedOutputByteBufferNano.computeStringSizeNoTag(str6);
                }
                i68++;
            }
            computeSerializedSize = computeSerializedSize + i69 + (i75 * 2);
        }
        String[] strArr13 = this.f411131q;
        if (strArr13 != null && strArr13.length > 0) {
            int i76 = 0;
            int i77 = 0;
            int i78 = 0;
            while (true) {
                String[] strArr14 = this.f411131q;
                if (i76 >= strArr14.length) {
                    break;
                }
                String str7 = strArr14[i76];
                if (str7 != null) {
                    i78++;
                    i77 += CodedOutputByteBufferNano.computeStringSizeNoTag(str7);
                }
                i76++;
            }
            computeSerializedSize = computeSerializedSize + i77 + (i78 * 2);
        }
        String[] strArr15 = this.f411132r;
        if (strArr15 != null && strArr15.length > 0) {
            int i79 = 0;
            int i85 = 0;
            int i86 = 0;
            while (true) {
                String[] strArr16 = this.f411132r;
                if (i79 >= strArr16.length) {
                    break;
                }
                String str8 = strArr16[i79];
                if (str8 != null) {
                    i86++;
                    i85 += CodedOutputByteBufferNano.computeStringSizeNoTag(str8);
                }
                i79++;
            }
            computeSerializedSize = computeSerializedSize + i85 + (i86 * 2);
        }
        String[] strArr17 = this.f411133s;
        if (strArr17 != null && strArr17.length > 0) {
            int i87 = 0;
            int i88 = 0;
            int i89 = 0;
            while (true) {
                String[] strArr18 = this.f411133s;
                if (i87 >= strArr18.length) {
                    break;
                }
                String str9 = strArr18[i87];
                if (str9 != null) {
                    i89++;
                    i88 += CodedOutputByteBufferNano.computeStringSizeNoTag(str9);
                }
                i87++;
            }
            computeSerializedSize = computeSerializedSize + i88 + (i89 * 2);
        }
        String[] strArr19 = this.f411134t;
        if (strArr19 != null && strArr19.length > 0) {
            int i95 = 0;
            int i96 = 0;
            int i97 = 0;
            while (true) {
                String[] strArr20 = this.f411134t;
                if (i95 >= strArr20.length) {
                    break;
                }
                String str10 = strArr20[i95];
                if (str10 != null) {
                    i97++;
                    i96 += CodedOutputByteBufferNano.computeStringSizeNoTag(str10);
                }
                i95++;
            }
            computeSerializedSize = computeSerializedSize + i96 + (i97 * 2);
        }
        String[] strArr21 = this.f411135u;
        if (strArr21 != null && strArr21.length > 0) {
            int i98 = 0;
            int i99 = 0;
            int i100 = 0;
            while (true) {
                String[] strArr22 = this.f411135u;
                if (i98 >= strArr22.length) {
                    break;
                }
                String str11 = strArr22[i98];
                if (str11 != null) {
                    i100++;
                    i99 += CodedOutputByteBufferNano.computeStringSizeNoTag(str11);
                }
                i98++;
            }
            computeSerializedSize = computeSerializedSize + i99 + (i100 * 2);
        }
        String[] strArr23 = this.f411136v;
        if (strArr23 != null && strArr23.length > 0) {
            int i101 = 0;
            int i102 = 0;
            int i103 = 0;
            while (true) {
                String[] strArr24 = this.f411136v;
                if (i101 >= strArr24.length) {
                    break;
                }
                String str12 = strArr24[i101];
                if (str12 != null) {
                    i103++;
                    i102 += CodedOutputByteBufferNano.computeStringSizeNoTag(str12);
                }
                i101++;
            }
            computeSerializedSize = computeSerializedSize + i102 + (i103 * 2);
        }
        if (!this.f411137w.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(23, this.f411137w);
        }
        String[] strArr25 = this.f411138z;
        if (strArr25 != null && strArr25.length > 0) {
            int i104 = 0;
            int i105 = 0;
            int i106 = 0;
            while (true) {
                String[] strArr26 = this.f411138z;
                if (i104 >= strArr26.length) {
                    break;
                }
                String str13 = strArr26[i104];
                if (str13 != null) {
                    i106++;
                    i105 += CodedOutputByteBufferNano.computeStringSizeNoTag(str13);
                }
                i104++;
            }
            computeSerializedSize = computeSerializedSize + i105 + (i106 * 2);
        }
        int i107 = this.A;
        if (i107 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(25, i107);
        }
        int i108 = this.B;
        if (i108 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(26, i108);
        }
        int i109 = this.C;
        if (i109 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(27, i109);
        }
        String[] strArr27 = this.D;
        if (strArr27 != null && strArr27.length > 0) {
            int i110 = 0;
            int i111 = 0;
            while (true) {
                String[] strArr28 = this.D;
                if (i16 >= strArr28.length) {
                    break;
                }
                String str14 = strArr28[i16];
                if (str14 != null) {
                    i111++;
                    i110 += CodedOutputByteBufferNano.computeStringSizeNoTag(str14);
                }
                i16++;
            }
            computeSerializedSize = computeSerializedSize + i110 + (i111 * 2);
        }
        int i112 = this.E;
        if (i112 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(29, i112);
        }
        float[] fArr = this.F;
        if (fArr != null && fArr.length > 0) {
            computeSerializedSize = computeSerializedSize + (fArr.length * 4) + (fArr.length * 2);
        }
        float[] fArr2 = this.G;
        if (fArr2 != null && fArr2.length > 0) {
            computeSerializedSize = computeSerializedSize + (fArr2.length * 4) + (fArr2.length * 2);
        }
        float[] fArr3 = this.H;
        if (fArr3 != null && fArr3.length > 0) {
            return computeSerializedSize + (fArr3.length * 4) + (fArr3.length * 2);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f411115a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        if (!this.f411116b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f411116b);
        }
        int[] iArr = this.f411117c;
        int i16 = 0;
        if (iArr != null && iArr.length > 0) {
            int i17 = 0;
            while (true) {
                int[] iArr2 = this.f411117c;
                if (i17 >= iArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeUInt32(3, iArr2[i17]);
                i17++;
            }
        }
        int i18 = this.f411118d;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i18);
        }
        boolean z16 = this.f411119e;
        if (z16) {
            codedOutputByteBufferNano.writeBool(5, z16);
        }
        if (!this.f411120f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f411120f);
        }
        int i19 = this.f411121g;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i19);
        }
        int i26 = this.f411122h;
        if (i26 != 0) {
            codedOutputByteBufferNano.writeUInt32(8, i26);
        }
        int i27 = this.f411123i;
        if (i27 != 0) {
            codedOutputByteBufferNano.writeUInt32(9, i27);
        }
        int i28 = this.f411124j;
        if (i28 != 0) {
            codedOutputByteBufferNano.writeUInt32(10, i28);
        }
        String[] strArr = this.f411125k;
        if (strArr != null && strArr.length > 0) {
            int i29 = 0;
            while (true) {
                String[] strArr2 = this.f411125k;
                if (i29 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i29];
                if (str != null) {
                    codedOutputByteBufferNano.writeString(11, str);
                }
                i29++;
            }
        }
        String[] strArr3 = this.f411126l;
        if (strArr3 != null && strArr3.length > 0) {
            int i36 = 0;
            while (true) {
                String[] strArr4 = this.f411126l;
                if (i36 >= strArr4.length) {
                    break;
                }
                String str2 = strArr4[i36];
                if (str2 != null) {
                    codedOutputByteBufferNano.writeString(12, str2);
                }
                i36++;
            }
        }
        String[] strArr5 = this.f411127m;
        if (strArr5 != null && strArr5.length > 0) {
            int i37 = 0;
            while (true) {
                String[] strArr6 = this.f411127m;
                if (i37 >= strArr6.length) {
                    break;
                }
                String str3 = strArr6[i37];
                if (str3 != null) {
                    codedOutputByteBufferNano.writeString(13, str3);
                }
                i37++;
            }
        }
        String[] strArr7 = this.f411128n;
        if (strArr7 != null && strArr7.length > 0) {
            int i38 = 0;
            while (true) {
                String[] strArr8 = this.f411128n;
                if (i38 >= strArr8.length) {
                    break;
                }
                String str4 = strArr8[i38];
                if (str4 != null) {
                    codedOutputByteBufferNano.writeString(14, str4);
                }
                i38++;
            }
        }
        String[] strArr9 = this.f411129o;
        if (strArr9 != null && strArr9.length > 0) {
            int i39 = 0;
            while (true) {
                String[] strArr10 = this.f411129o;
                if (i39 >= strArr10.length) {
                    break;
                }
                String str5 = strArr10[i39];
                if (str5 != null) {
                    codedOutputByteBufferNano.writeString(15, str5);
                }
                i39++;
            }
        }
        String[] strArr11 = this.f411130p;
        if (strArr11 != null && strArr11.length > 0) {
            int i46 = 0;
            while (true) {
                String[] strArr12 = this.f411130p;
                if (i46 >= strArr12.length) {
                    break;
                }
                String str6 = strArr12[i46];
                if (str6 != null) {
                    codedOutputByteBufferNano.writeString(16, str6);
                }
                i46++;
            }
        }
        String[] strArr13 = this.f411131q;
        if (strArr13 != null && strArr13.length > 0) {
            int i47 = 0;
            while (true) {
                String[] strArr14 = this.f411131q;
                if (i47 >= strArr14.length) {
                    break;
                }
                String str7 = strArr14[i47];
                if (str7 != null) {
                    codedOutputByteBufferNano.writeString(17, str7);
                }
                i47++;
            }
        }
        String[] strArr15 = this.f411132r;
        if (strArr15 != null && strArr15.length > 0) {
            int i48 = 0;
            while (true) {
                String[] strArr16 = this.f411132r;
                if (i48 >= strArr16.length) {
                    break;
                }
                String str8 = strArr16[i48];
                if (str8 != null) {
                    codedOutputByteBufferNano.writeString(18, str8);
                }
                i48++;
            }
        }
        String[] strArr17 = this.f411133s;
        if (strArr17 != null && strArr17.length > 0) {
            int i49 = 0;
            while (true) {
                String[] strArr18 = this.f411133s;
                if (i49 >= strArr18.length) {
                    break;
                }
                String str9 = strArr18[i49];
                if (str9 != null) {
                    codedOutputByteBufferNano.writeString(19, str9);
                }
                i49++;
            }
        }
        String[] strArr19 = this.f411134t;
        if (strArr19 != null && strArr19.length > 0) {
            int i56 = 0;
            while (true) {
                String[] strArr20 = this.f411134t;
                if (i56 >= strArr20.length) {
                    break;
                }
                String str10 = strArr20[i56];
                if (str10 != null) {
                    codedOutputByteBufferNano.writeString(20, str10);
                }
                i56++;
            }
        }
        String[] strArr21 = this.f411135u;
        if (strArr21 != null && strArr21.length > 0) {
            int i57 = 0;
            while (true) {
                String[] strArr22 = this.f411135u;
                if (i57 >= strArr22.length) {
                    break;
                }
                String str11 = strArr22[i57];
                if (str11 != null) {
                    codedOutputByteBufferNano.writeString(21, str11);
                }
                i57++;
            }
        }
        String[] strArr23 = this.f411136v;
        if (strArr23 != null && strArr23.length > 0) {
            int i58 = 0;
            while (true) {
                String[] strArr24 = this.f411136v;
                if (i58 >= strArr24.length) {
                    break;
                }
                String str12 = strArr24[i58];
                if (str12 != null) {
                    codedOutputByteBufferNano.writeString(22, str12);
                }
                i58++;
            }
        }
        if (!this.f411137w.equals("")) {
            codedOutputByteBufferNano.writeString(23, this.f411137w);
        }
        String[] strArr25 = this.f411138z;
        if (strArr25 != null && strArr25.length > 0) {
            int i59 = 0;
            while (true) {
                String[] strArr26 = this.f411138z;
                if (i59 >= strArr26.length) {
                    break;
                }
                String str13 = strArr26[i59];
                if (str13 != null) {
                    codedOutputByteBufferNano.writeString(24, str13);
                }
                i59++;
            }
        }
        int i65 = this.A;
        if (i65 != 0) {
            codedOutputByteBufferNano.writeUInt32(25, i65);
        }
        int i66 = this.B;
        if (i66 != 0) {
            codedOutputByteBufferNano.writeUInt32(26, i66);
        }
        int i67 = this.C;
        if (i67 != 0) {
            codedOutputByteBufferNano.writeUInt32(27, i67);
        }
        String[] strArr27 = this.D;
        if (strArr27 != null && strArr27.length > 0) {
            int i68 = 0;
            while (true) {
                String[] strArr28 = this.D;
                if (i68 >= strArr28.length) {
                    break;
                }
                String str14 = strArr28[i68];
                if (str14 != null) {
                    codedOutputByteBufferNano.writeString(28, str14);
                }
                i68++;
            }
        }
        int i69 = this.E;
        if (i69 != 0) {
            codedOutputByteBufferNano.writeUInt32(29, i69);
        }
        float[] fArr = this.F;
        if (fArr != null && fArr.length > 0) {
            int i75 = 0;
            while (true) {
                float[] fArr2 = this.F;
                if (i75 >= fArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeFloat(30, fArr2[i75]);
                i75++;
            }
        }
        float[] fArr3 = this.G;
        if (fArr3 != null && fArr3.length > 0) {
            int i76 = 0;
            while (true) {
                float[] fArr4 = this.G;
                if (i76 >= fArr4.length) {
                    break;
                }
                codedOutputByteBufferNano.writeFloat(31, fArr4[i76]);
                i76++;
            }
        }
        float[] fArr5 = this.H;
        if (fArr5 != null && fArr5.length > 0) {
            while (true) {
                float[] fArr6 = this.H;
                if (i16 >= fArr6.length) {
                    break;
                }
                codedOutputByteBufferNano.writeFloat(32, fArr6[i16]);
                i16++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
