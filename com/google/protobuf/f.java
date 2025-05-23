package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.WireFormat;
import com.google.protobuf.ad;
import cooperation.qzone.QZoneHelper;
import java.io.IOException;
import org.jf.dexlib2.analysis.RegisterType;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public final class f {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f35846a;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            f35846a = iArr;
            try {
                iArr[WireFormat.FieldType.DOUBLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f35846a[WireFormat.FieldType.FLOAT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f35846a[WireFormat.FieldType.INT64.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f35846a[WireFormat.FieldType.UINT64.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f35846a[WireFormat.FieldType.INT32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f35846a[WireFormat.FieldType.UINT32.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f35846a[WireFormat.FieldType.FIXED64.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f35846a[WireFormat.FieldType.SFIXED64.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f35846a[WireFormat.FieldType.FIXED32.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f35846a[WireFormat.FieldType.SFIXED32.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f35846a[WireFormat.FieldType.BOOL.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f35846a[WireFormat.FieldType.SINT32.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f35846a[WireFormat.FieldType.SINT64.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f35846a[WireFormat.FieldType.ENUM.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f35846a[WireFormat.FieldType.BYTES.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f35846a[WireFormat.FieldType.STRING.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f35846a[WireFormat.FieldType.f35631GROUP.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f35846a[WireFormat.FieldType.MESSAGE.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public int f35847a;

        /* renamed from: b, reason: collision with root package name */
        public long f35848b;

        /* renamed from: c, reason: collision with root package name */
        public Object f35849c;

        /* renamed from: d, reason: collision with root package name */
        public final t f35850d;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(t tVar) {
            tVar.getClass();
            this.f35850d = tVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int A(int i3, byte[] bArr, int i16, int i17, ad.j<?> jVar, b bVar) {
        ac acVar = (ac) jVar;
        int I = I(bArr, i16, bVar);
        acVar.e(k.b(bVar.f35847a));
        while (I < i17) {
            int I2 = I(bArr, I, bVar);
            if (i3 != bVar.f35847a) {
                break;
            }
            I = I(bArr, I2, bVar);
            acVar.e(k.b(bVar.f35847a));
        }
        return I;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int B(int i3, byte[] bArr, int i16, int i17, ad.j<?> jVar, b bVar) {
        aj ajVar = (aj) jVar;
        int L = L(bArr, i16, bVar);
        ajVar.m(k.c(bVar.f35848b));
        while (L < i17) {
            int I = I(bArr, L, bVar);
            if (i3 != bVar.f35847a) {
                break;
            }
            L = L(bArr, I, bVar);
            ajVar.m(k.c(bVar.f35848b));
        }
        return L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int C(byte[] bArr, int i3, b bVar) throws InvalidProtocolBufferException {
        int I = I(bArr, i3, bVar);
        int i16 = bVar.f35847a;
        if (i16 >= 0) {
            if (i16 == 0) {
                bVar.f35849c = "";
                return I;
            }
            bVar.f35849c = new String(bArr, I, i16, ad.f35640a);
            return I + i16;
        }
        throw InvalidProtocolBufferException.negativeSize();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int D(int i3, byte[] bArr, int i16, int i17, ad.j<?> jVar, b bVar) throws InvalidProtocolBufferException {
        int I = I(bArr, i16, bVar);
        int i18 = bVar.f35847a;
        if (i18 >= 0) {
            if (i18 == 0) {
                jVar.add("");
            } else {
                jVar.add(new String(bArr, I, i18, ad.f35640a));
                I += i18;
            }
            while (I < i17) {
                int I2 = I(bArr, I, bVar);
                if (i3 != bVar.f35847a) {
                    break;
                }
                I = I(bArr, I2, bVar);
                int i19 = bVar.f35847a;
                if (i19 >= 0) {
                    if (i19 == 0) {
                        jVar.add("");
                    } else {
                        jVar.add(new String(bArr, I, i19, ad.f35640a));
                        I += i19;
                    }
                } else {
                    throw InvalidProtocolBufferException.negativeSize();
                }
            }
            return I;
        }
        throw InvalidProtocolBufferException.negativeSize();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int E(int i3, byte[] bArr, int i16, int i17, ad.j<?> jVar, b bVar) throws InvalidProtocolBufferException {
        int I = I(bArr, i16, bVar);
        int i18 = bVar.f35847a;
        if (i18 >= 0) {
            if (i18 == 0) {
                jVar.add("");
            } else {
                int i19 = I + i18;
                if (Utf8.t(bArr, I, i19)) {
                    jVar.add(new String(bArr, I, i18, ad.f35640a));
                    I = i19;
                } else {
                    throw InvalidProtocolBufferException.invalidUtf8();
                }
            }
            while (I < i17) {
                int I2 = I(bArr, I, bVar);
                if (i3 != bVar.f35847a) {
                    break;
                }
                I = I(bArr, I2, bVar);
                int i26 = bVar.f35847a;
                if (i26 >= 0) {
                    if (i26 == 0) {
                        jVar.add("");
                    } else {
                        int i27 = I + i26;
                        if (Utf8.t(bArr, I, i27)) {
                            jVar.add(new String(bArr, I, i26, ad.f35640a));
                            I = i27;
                        } else {
                            throw InvalidProtocolBufferException.invalidUtf8();
                        }
                    }
                } else {
                    throw InvalidProtocolBufferException.negativeSize();
                }
            }
            return I;
        }
        throw InvalidProtocolBufferException.negativeSize();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int F(byte[] bArr, int i3, b bVar) throws InvalidProtocolBufferException {
        int I = I(bArr, i3, bVar);
        int i16 = bVar.f35847a;
        if (i16 >= 0) {
            if (i16 == 0) {
                bVar.f35849c = "";
                return I;
            }
            bVar.f35849c = Utf8.h(bArr, I, i16);
            return I + i16;
        }
        throw InvalidProtocolBufferException.negativeSize();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int G(int i3, byte[] bArr, int i16, int i17, cd cdVar, b bVar) throws InvalidProtocolBufferException {
        if (WireFormat.a(i3) != 0) {
            int b16 = WireFormat.b(i3);
            if (b16 != 0) {
                if (b16 != 1) {
                    if (b16 != 2) {
                        if (b16 != 3) {
                            if (b16 == 5) {
                                cdVar.r(i3, Integer.valueOf(h(bArr, i16)));
                                return i16 + 4;
                            }
                            throw InvalidProtocolBufferException.invalidTag();
                        }
                        cd p16 = cd.p();
                        int i18 = (i3 & (-8)) | 4;
                        int i19 = 0;
                        while (true) {
                            if (i16 >= i17) {
                                break;
                            }
                            int I = I(bArr, i16, bVar);
                            int i26 = bVar.f35847a;
                            if (i26 == i18) {
                                i19 = i26;
                                i16 = I;
                                break;
                            }
                            i19 = i26;
                            i16 = G(i26, bArr, I, i17, p16, bVar);
                        }
                        if (i16 <= i17 && i19 == i18) {
                            cdVar.r(i3, p16);
                            return i16;
                        }
                        throw InvalidProtocolBufferException.parseFailure();
                    }
                    int I2 = I(bArr, i16, bVar);
                    int i27 = bVar.f35847a;
                    if (i27 >= 0) {
                        if (i27 <= bArr.length - I2) {
                            if (i27 == 0) {
                                cdVar.r(i3, ByteString.EMPTY);
                            } else {
                                cdVar.r(i3, ByteString.copyFrom(bArr, I2, i27));
                            }
                            return I2 + i27;
                        }
                        throw InvalidProtocolBufferException.truncatedMessage();
                    }
                    throw InvalidProtocolBufferException.negativeSize();
                }
                cdVar.r(i3, Long.valueOf(j(bArr, i16)));
                return i16 + 8;
            }
            int L = L(bArr, i16, bVar);
            cdVar.r(i3, Long.valueOf(bVar.f35848b));
            return L;
        }
        throw InvalidProtocolBufferException.invalidTag();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int H(int i3, byte[] bArr, int i16, b bVar) {
        int i17 = i3 & 127;
        int i18 = i16 + 1;
        byte b16 = bArr[i16];
        if (b16 >= 0) {
            bVar.f35847a = i17 | (b16 << 7);
            return i18;
        }
        int i19 = i17 | ((b16 & Byte.MAX_VALUE) << 7);
        int i26 = i18 + 1;
        byte b17 = bArr[i18];
        if (b17 >= 0) {
            bVar.f35847a = i19 | (b17 << RegisterType.DOUBLE_LO);
            return i26;
        }
        int i27 = i19 | ((b17 & Byte.MAX_VALUE) << 14);
        int i28 = i26 + 1;
        byte b18 = bArr[i26];
        if (b18 >= 0) {
            bVar.f35847a = i27 | (b18 << QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER);
            return i28;
        }
        int i29 = i27 | ((b18 & Byte.MAX_VALUE) << 21);
        int i36 = i28 + 1;
        byte b19 = bArr[i28];
        if (b19 >= 0) {
            bVar.f35847a = i29 | (b19 << 28);
            return i36;
        }
        int i37 = i29 | ((b19 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i38 = i36 + 1;
            if (bArr[i36] < 0) {
                i36 = i38;
            } else {
                bVar.f35847a = i37;
                return i38;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int I(byte[] bArr, int i3, b bVar) {
        int i16 = i3 + 1;
        byte b16 = bArr[i3];
        if (b16 >= 0) {
            bVar.f35847a = b16;
            return i16;
        }
        return H(b16, bArr, i16, bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int J(int i3, byte[] bArr, int i16, int i17, ad.j<?> jVar, b bVar) {
        ac acVar = (ac) jVar;
        int I = I(bArr, i16, bVar);
        acVar.e(bVar.f35847a);
        while (I < i17) {
            int I2 = I(bArr, I, bVar);
            if (i3 != bVar.f35847a) {
                break;
            }
            I = I(bArr, I2, bVar);
            acVar.e(bVar.f35847a);
        }
        return I;
    }

    static int K(long j3, byte[] bArr, int i3, b bVar) {
        int i16 = i3 + 1;
        byte b16 = bArr[i3];
        long j16 = (j3 & 127) | ((b16 & Byte.MAX_VALUE) << 7);
        int i17 = 7;
        while (b16 < 0) {
            int i18 = i16 + 1;
            byte b17 = bArr[i16];
            i17 += 7;
            j16 |= (b17 & Byte.MAX_VALUE) << i17;
            i16 = i18;
            b16 = b17;
        }
        bVar.f35848b = j16;
        return i16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int L(byte[] bArr, int i3, b bVar) {
        int i16 = i3 + 1;
        long j3 = bArr[i3];
        if (j3 >= 0) {
            bVar.f35848b = j3;
            return i16;
        }
        return K(j3, bArr, i16, bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int M(int i3, byte[] bArr, int i16, int i17, ad.j<?> jVar, b bVar) {
        aj ajVar = (aj) jVar;
        int L = L(bArr, i16, bVar);
        ajVar.m(bVar.f35848b);
        while (L < i17) {
            int I = I(bArr, L, bVar);
            if (i3 != bVar.f35847a) {
                break;
            }
            L = L(bArr, I, bVar);
            ajVar.m(bVar.f35848b);
        }
        return L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int N(int i3, byte[] bArr, int i16, int i17, b bVar) throws InvalidProtocolBufferException {
        if (WireFormat.a(i3) != 0) {
            int b16 = WireFormat.b(i3);
            if (b16 != 0) {
                if (b16 != 1) {
                    if (b16 != 2) {
                        if (b16 != 3) {
                            if (b16 == 5) {
                                return i16 + 4;
                            }
                            throw InvalidProtocolBufferException.invalidTag();
                        }
                        int i18 = (i3 & (-8)) | 4;
                        int i19 = 0;
                        while (i16 < i17) {
                            i16 = I(bArr, i16, bVar);
                            i19 = bVar.f35847a;
                            if (i19 == i18) {
                                break;
                            }
                            i16 = N(i19, bArr, i16, i17, bVar);
                        }
                        if (i16 <= i17 && i19 == i18) {
                            return i16;
                        }
                        throw InvalidProtocolBufferException.parseFailure();
                    }
                    return I(bArr, i16, bVar) + bVar.f35847a;
                }
                return i16 + 8;
            }
            return L(bArr, i16, bVar);
        }
        throw InvalidProtocolBufferException.invalidTag();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i3, byte[] bArr, int i16, int i17, ad.j<?> jVar, b bVar) {
        boolean z16;
        boolean z17;
        h hVar = (h) jVar;
        int L = L(bArr, i16, bVar);
        if (bVar.f35848b != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        hVar.m(z16);
        while (L < i17) {
            int I = I(bArr, L, bVar);
            if (i3 != bVar.f35847a) {
                break;
            }
            L = L(bArr, I, bVar);
            if (bVar.f35848b != 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            hVar.m(z17);
        }
        return L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(byte[] bArr, int i3, b bVar) throws InvalidProtocolBufferException {
        int I = I(bArr, i3, bVar);
        int i16 = bVar.f35847a;
        if (i16 >= 0) {
            if (i16 <= bArr.length - I) {
                if (i16 == 0) {
                    bVar.f35849c = ByteString.EMPTY;
                    return I;
                }
                bVar.f35849c = ByteString.copyFrom(bArr, I, i16);
                return I + i16;
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        throw InvalidProtocolBufferException.negativeSize();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(int i3, byte[] bArr, int i16, int i17, ad.j<?> jVar, b bVar) throws InvalidProtocolBufferException {
        int I = I(bArr, i16, bVar);
        int i18 = bVar.f35847a;
        if (i18 >= 0) {
            if (i18 <= bArr.length - I) {
                if (i18 == 0) {
                    jVar.add(ByteString.EMPTY);
                } else {
                    jVar.add(ByteString.copyFrom(bArr, I, i18));
                    I += i18;
                }
                while (I < i17) {
                    int I2 = I(bArr, I, bVar);
                    if (i3 != bVar.f35847a) {
                        break;
                    }
                    I = I(bArr, I2, bVar);
                    int i19 = bVar.f35847a;
                    if (i19 >= 0) {
                        if (i19 <= bArr.length - I) {
                            if (i19 == 0) {
                                jVar.add(ByteString.EMPTY);
                            } else {
                                jVar.add(ByteString.copyFrom(bArr, I, i19));
                                I += i19;
                            }
                        } else {
                            throw InvalidProtocolBufferException.truncatedMessage();
                        }
                    } else {
                        throw InvalidProtocolBufferException.negativeSize();
                    }
                }
                return I;
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        throw InvalidProtocolBufferException.negativeSize();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static double d(byte[] bArr, int i3) {
        return Double.longBitsToDouble(j(bArr, i3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int e(int i3, byte[] bArr, int i16, int i17, ad.j<?> jVar, b bVar) {
        o oVar = (o) jVar;
        oVar.i(d(bArr, i16));
        int i18 = i16 + 8;
        while (i18 < i17) {
            int I = I(bArr, i18, bVar);
            if (i3 != bVar.f35847a) {
                break;
            }
            oVar.i(d(bArr, I));
            i18 = I + 8;
        }
        return i18;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:60:0x013e. Please report as an issue. */
    static int f(int i3, byte[] bArr, int i16, int i17, GeneratedMessageLite.c<?, ?> cVar, GeneratedMessageLite.e<?, ?> eVar, cb<cd, cd> cbVar, b bVar) throws IOException {
        boolean z16;
        Object s16;
        z<GeneratedMessageLite.d> zVar = cVar.f35494d;
        int i18 = i3 >>> 3;
        Object obj = null;
        if (eVar.f35503d.isRepeated() && eVar.f35503d.isPacked()) {
            switch (a.f35846a[eVar.b().ordinal()]) {
                case 1:
                    o oVar = new o();
                    int s17 = s(bArr, i16, oVar, bVar);
                    zVar.M(eVar.f35503d, oVar);
                    return s17;
                case 2:
                    aa aaVar = new aa();
                    int v3 = v(bArr, i16, aaVar, bVar);
                    zVar.M(eVar.f35503d, aaVar);
                    return v3;
                case 3:
                case 4:
                    aj ajVar = new aj();
                    int z17 = z(bArr, i16, ajVar, bVar);
                    zVar.M(eVar.f35503d, ajVar);
                    return z17;
                case 5:
                case 6:
                    ac acVar = new ac();
                    int y16 = y(bArr, i16, acVar, bVar);
                    zVar.M(eVar.f35503d, acVar);
                    return y16;
                case 7:
                case 8:
                    aj ajVar2 = new aj();
                    int u16 = u(bArr, i16, ajVar2, bVar);
                    zVar.M(eVar.f35503d, ajVar2);
                    return u16;
                case 9:
                case 10:
                    ac acVar2 = new ac();
                    int t16 = t(bArr, i16, acVar2, bVar);
                    zVar.M(eVar.f35503d, acVar2);
                    return t16;
                case 11:
                    h hVar = new h();
                    int r16 = r(bArr, i16, hVar, bVar);
                    zVar.M(eVar.f35503d, hVar);
                    return r16;
                case 12:
                    ac acVar3 = new ac();
                    int w3 = w(bArr, i16, acVar3, bVar);
                    zVar.M(eVar.f35503d, acVar3);
                    return w3;
                case 13:
                    aj ajVar3 = new aj();
                    int x16 = x(bArr, i16, ajVar3, bVar);
                    zVar.M(eVar.f35503d, ajVar3);
                    return x16;
                case 14:
                    ac acVar4 = new ac();
                    int y17 = y(bArr, i16, acVar4, bVar);
                    cd cdVar = cVar.unknownFields;
                    if (cdVar != cd.e()) {
                        obj = cdVar;
                    }
                    cd cdVar2 = (cd) bs.z(i18, acVar4, eVar.f35503d.h(), obj, cbVar);
                    if (cdVar2 != null) {
                        cVar.unknownFields = cdVar2;
                    }
                    zVar.M(eVar.f35503d, acVar4);
                    return y17;
                default:
                    throw new IllegalStateException("Type cannot be packed: " + eVar.f35503d.getLiteType());
            }
        }
        if (eVar.b() == WireFormat.FieldType.ENUM) {
            i16 = I(bArr, i16, bVar);
            if (eVar.f35503d.h().findValueByNumber(bVar.f35847a) == null) {
                cd cdVar3 = cVar.unknownFields;
                if (cdVar3 == cd.e()) {
                    cdVar3 = cd.p();
                    cVar.unknownFields = cdVar3;
                }
                bs.M(i18, bVar.f35847a, cdVar3, cbVar);
                return i16;
            }
            obj = Integer.valueOf(bVar.f35847a);
        } else {
            switch (a.f35846a[eVar.b().ordinal()]) {
                case 1:
                    obj = Double.valueOf(d(bArr, i16));
                    i16 += 8;
                    break;
                case 2:
                    obj = Float.valueOf(l(bArr, i16));
                    i16 += 4;
                    break;
                case 3:
                case 4:
                    i16 = L(bArr, i16, bVar);
                    obj = Long.valueOf(bVar.f35848b);
                    break;
                case 5:
                case 6:
                    i16 = I(bArr, i16, bVar);
                    obj = Integer.valueOf(bVar.f35847a);
                    break;
                case 7:
                case 8:
                    obj = Long.valueOf(j(bArr, i16));
                    i16 += 8;
                    break;
                case 9:
                case 10:
                    obj = Integer.valueOf(h(bArr, i16));
                    i16 += 4;
                    break;
                case 11:
                    i16 = L(bArr, i16, bVar);
                    if (bVar.f35848b != 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    obj = Boolean.valueOf(z16);
                    break;
                case 12:
                    i16 = I(bArr, i16, bVar);
                    obj = Integer.valueOf(k.b(bVar.f35847a));
                    break;
                case 13:
                    i16 = L(bArr, i16, bVar);
                    obj = Long.valueOf(k.c(bVar.f35848b));
                    break;
                case 14:
                    throw new IllegalStateException("Shouldn't reach here.");
                case 15:
                    i16 = b(bArr, i16, bVar);
                    obj = bVar.f35849c;
                    break;
                case 16:
                    i16 = C(bArr, i16, bVar);
                    obj = bVar.f35849c;
                    break;
                case 17:
                    i16 = n(bi.a().d(eVar.c().getClass()), bArr, i16, i17, (i18 << 3) | 4, bVar);
                    obj = bVar.f35849c;
                    break;
                case 18:
                    i16 = p(bi.a().d(eVar.c().getClass()), bArr, i16, i17, bVar);
                    obj = bVar.f35849c;
                    break;
            }
        }
        if (eVar.e()) {
            zVar.f(eVar.f35503d, obj);
        } else {
            int i19 = a.f35846a[eVar.b().ordinal()];
            if ((i19 == 17 || i19 == 18) && (s16 = zVar.s(eVar.f35503d)) != null) {
                obj = ad.j(s16, obj);
            }
            zVar.M(eVar.f35503d, obj);
        }
        return i16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int g(int i3, byte[] bArr, int i16, int i17, Object obj, au auVar, cb<cd, cd> cbVar, b bVar) throws IOException {
        GeneratedMessageLite.e a16 = bVar.f35850d.a(auVar, i3 >>> 3);
        if (a16 == null) {
            return G(i3, bArr, i16, i17, ay.v(obj), bVar);
        }
        GeneratedMessageLite.c cVar = (GeneratedMessageLite.c) obj;
        cVar.p();
        return f(i3, bArr, i16, i17, cVar, a16, cbVar, bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int h(byte[] bArr, int i3) {
        return ((bArr[i3 + 3] & 255) << 24) | (bArr[i3] & 255) | ((bArr[i3 + 1] & 255) << 8) | ((bArr[i3 + 2] & 255) << 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int i(int i3, byte[] bArr, int i16, int i17, ad.j<?> jVar, b bVar) {
        ac acVar = (ac) jVar;
        acVar.e(h(bArr, i16));
        int i18 = i16 + 4;
        while (i18 < i17) {
            int I = I(bArr, i18, bVar);
            if (i3 != bVar.f35847a) {
                break;
            }
            acVar.e(h(bArr, I));
            i18 = I + 4;
        }
        return i18;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long j(byte[] bArr, int i3) {
        return ((bArr[i3 + 7] & 255) << 56) | (bArr[i3] & 255) | ((bArr[i3 + 1] & 255) << 8) | ((bArr[i3 + 2] & 255) << 16) | ((bArr[i3 + 3] & 255) << 24) | ((bArr[i3 + 4] & 255) << 32) | ((bArr[i3 + 5] & 255) << 40) | ((bArr[i3 + 6] & 255) << 48);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int k(int i3, byte[] bArr, int i16, int i17, ad.j<?> jVar, b bVar) {
        aj ajVar = (aj) jVar;
        ajVar.m(j(bArr, i16));
        int i18 = i16 + 8;
        while (i18 < i17) {
            int I = I(bArr, i18, bVar);
            if (i3 != bVar.f35847a) {
                break;
            }
            ajVar.m(j(bArr, I));
            i18 = I + 8;
        }
        return i18;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float l(byte[] bArr, int i3) {
        return Float.intBitsToFloat(h(bArr, i3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int m(int i3, byte[] bArr, int i16, int i17, ad.j<?> jVar, b bVar) {
        aa aaVar = (aa) jVar;
        aaVar.j(l(bArr, i16));
        int i18 = i16 + 4;
        while (i18 < i17) {
            int I = I(bArr, i18, bVar);
            if (i3 != bVar.f35847a) {
                break;
            }
            aaVar.j(l(bArr, I));
            i18 = I + 4;
        }
        return i18;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int n(bq bqVar, byte[] bArr, int i3, int i16, int i17, b bVar) throws IOException {
        ay ayVar = (ay) bqVar;
        Object newInstance = ayVar.newInstance();
        int c06 = ayVar.c0(newInstance, bArr, i3, i16, i17, bVar);
        ayVar.g(newInstance);
        bVar.f35849c = newInstance;
        return c06;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int o(bq bqVar, int i3, byte[] bArr, int i16, int i17, ad.j<?> jVar, b bVar) throws IOException {
        int i18 = (i3 & (-8)) | 4;
        int n3 = n(bqVar, bArr, i16, i17, i18, bVar);
        jVar.add(bVar.f35849c);
        while (n3 < i17) {
            int I = I(bArr, n3, bVar);
            if (i3 != bVar.f35847a) {
                break;
            }
            n3 = n(bqVar, bArr, I, i17, i18, bVar);
            jVar.add(bVar.f35849c);
        }
        return n3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int p(bq bqVar, byte[] bArr, int i3, int i16, b bVar) throws IOException {
        int i17 = i3 + 1;
        int i18 = bArr[i3];
        if (i18 < 0) {
            i17 = H(i18, bArr, i17, bVar);
            i18 = bVar.f35847a;
        }
        int i19 = i17;
        if (i18 >= 0 && i18 <= i16 - i19) {
            Object newInstance = bqVar.newInstance();
            int i26 = i18 + i19;
            bqVar.f(newInstance, bArr, i19, i26, bVar);
            bqVar.g(newInstance);
            bVar.f35849c = newInstance;
            return i26;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int q(bq<?> bqVar, int i3, byte[] bArr, int i16, int i17, ad.j<?> jVar, b bVar) throws IOException {
        int p16 = p(bqVar, bArr, i16, i17, bVar);
        jVar.add(bVar.f35849c);
        while (p16 < i17) {
            int I = I(bArr, p16, bVar);
            if (i3 != bVar.f35847a) {
                break;
            }
            p16 = p(bqVar, bArr, I, i17, bVar);
            jVar.add(bVar.f35849c);
        }
        return p16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int r(byte[] bArr, int i3, ad.j<?> jVar, b bVar) throws IOException {
        boolean z16;
        h hVar = (h) jVar;
        int I = I(bArr, i3, bVar);
        int i16 = bVar.f35847a + I;
        while (I < i16) {
            I = L(bArr, I, bVar);
            if (bVar.f35848b != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            hVar.m(z16);
        }
        if (I == i16) {
            return I;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int s(byte[] bArr, int i3, ad.j<?> jVar, b bVar) throws IOException {
        o oVar = (o) jVar;
        int I = I(bArr, i3, bVar);
        int i16 = bVar.f35847a + I;
        while (I < i16) {
            oVar.i(d(bArr, I));
            I += 8;
        }
        if (I == i16) {
            return I;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int t(byte[] bArr, int i3, ad.j<?> jVar, b bVar) throws IOException {
        ac acVar = (ac) jVar;
        int I = I(bArr, i3, bVar);
        int i16 = bVar.f35847a + I;
        while (I < i16) {
            acVar.e(h(bArr, I));
            I += 4;
        }
        if (I == i16) {
            return I;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int u(byte[] bArr, int i3, ad.j<?> jVar, b bVar) throws IOException {
        aj ajVar = (aj) jVar;
        int I = I(bArr, i3, bVar);
        int i16 = bVar.f35847a + I;
        while (I < i16) {
            ajVar.m(j(bArr, I));
            I += 8;
        }
        if (I == i16) {
            return I;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int v(byte[] bArr, int i3, ad.j<?> jVar, b bVar) throws IOException {
        aa aaVar = (aa) jVar;
        int I = I(bArr, i3, bVar);
        int i16 = bVar.f35847a + I;
        while (I < i16) {
            aaVar.j(l(bArr, I));
            I += 4;
        }
        if (I == i16) {
            return I;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int w(byte[] bArr, int i3, ad.j<?> jVar, b bVar) throws IOException {
        ac acVar = (ac) jVar;
        int I = I(bArr, i3, bVar);
        int i16 = bVar.f35847a + I;
        while (I < i16) {
            I = I(bArr, I, bVar);
            acVar.e(k.b(bVar.f35847a));
        }
        if (I == i16) {
            return I;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int x(byte[] bArr, int i3, ad.j<?> jVar, b bVar) throws IOException {
        aj ajVar = (aj) jVar;
        int I = I(bArr, i3, bVar);
        int i16 = bVar.f35847a + I;
        while (I < i16) {
            I = L(bArr, I, bVar);
            ajVar.m(k.c(bVar.f35848b));
        }
        if (I == i16) {
            return I;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int y(byte[] bArr, int i3, ad.j<?> jVar, b bVar) throws IOException {
        ac acVar = (ac) jVar;
        int I = I(bArr, i3, bVar);
        int i16 = bVar.f35847a + I;
        while (I < i16) {
            I = I(bArr, I, bVar);
            acVar.e(bVar.f35847a);
        }
        if (I == i16) {
            return I;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int z(byte[] bArr, int i3, ad.j<?> jVar, b bVar) throws IOException {
        aj ajVar = (aj) jVar;
        int I = I(bArr, i3, bVar);
        int i16 = bVar.f35847a + I;
        while (I < i16) {
            I = L(bArr, I, bVar);
            ajVar.m(bVar.f35848b);
        }
        if (I == i16) {
            return I;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }
}
