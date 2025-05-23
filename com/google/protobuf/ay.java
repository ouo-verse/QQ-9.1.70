package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.WireFormat;
import com.google.protobuf.Writer;
import com.google.protobuf.ad;
import com.google.protobuf.am;
import com.google.protobuf.f;
import com.google.protobuf.z;
import com.qzone.proxy.feedcomponent.text.TextCell;
import com.tencent.mobileqq.startup.step.InitSkin;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public final class ay<T> implements bq<T> {

    /* renamed from: r, reason: collision with root package name */
    private static final int[] f35687r = new int[0];

    /* renamed from: s, reason: collision with root package name */
    private static final Unsafe f35688s = ch.G();

    /* renamed from: a, reason: collision with root package name */
    private final int[] f35689a;

    /* renamed from: b, reason: collision with root package name */
    private final Object[] f35690b;

    /* renamed from: c, reason: collision with root package name */
    private final int f35691c;

    /* renamed from: d, reason: collision with root package name */
    private final int f35692d;

    /* renamed from: e, reason: collision with root package name */
    private final au f35693e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f35694f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f35695g;

    /* renamed from: h, reason: collision with root package name */
    private final boolean f35696h;

    /* renamed from: i, reason: collision with root package name */
    private final boolean f35697i;

    /* renamed from: j, reason: collision with root package name */
    private final int[] f35698j;

    /* renamed from: k, reason: collision with root package name */
    private final int f35699k;

    /* renamed from: l, reason: collision with root package name */
    private final int f35700l;

    /* renamed from: m, reason: collision with root package name */
    private final bb f35701m;

    /* renamed from: n, reason: collision with root package name */
    private final ai f35702n;

    /* renamed from: o, reason: collision with root package name */
    private final cb<?, ?> f35703o;

    /* renamed from: p, reason: collision with root package name */
    private final u<?> f35704p;

    /* renamed from: q, reason: collision with root package name */
    private final an f35705q;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f35706a;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            f35706a = iArr;
            try {
                iArr[WireFormat.FieldType.BOOL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f35706a[WireFormat.FieldType.BYTES.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f35706a[WireFormat.FieldType.DOUBLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f35706a[WireFormat.FieldType.FIXED32.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f35706a[WireFormat.FieldType.SFIXED32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f35706a[WireFormat.FieldType.FIXED64.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f35706a[WireFormat.FieldType.SFIXED64.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f35706a[WireFormat.FieldType.FLOAT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f35706a[WireFormat.FieldType.ENUM.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f35706a[WireFormat.FieldType.INT32.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f35706a[WireFormat.FieldType.UINT32.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f35706a[WireFormat.FieldType.INT64.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f35706a[WireFormat.FieldType.UINT64.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f35706a[WireFormat.FieldType.MESSAGE.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f35706a[WireFormat.FieldType.SINT32.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f35706a[WireFormat.FieldType.SINT64.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f35706a[WireFormat.FieldType.STRING.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    ay(int[] iArr, Object[] objArr, int i3, int i16, au auVar, boolean z16, boolean z17, int[] iArr2, int i17, int i18, bb bbVar, ai aiVar, cb<?, ?> cbVar, u<?> uVar, an anVar) {
        boolean z18;
        this.f35689a = iArr;
        this.f35690b = objArr;
        this.f35691c = i3;
        this.f35692d = i16;
        this.f35695g = auVar instanceof GeneratedMessageLite;
        this.f35696h = z16;
        if (uVar != null && uVar.e(auVar)) {
            z18 = true;
        } else {
            z18 = false;
        }
        this.f35694f = z18;
        this.f35697i = z17;
        this.f35698j = iArr2;
        this.f35699k = i17;
        this.f35700l = i18;
        this.f35701m = bbVar;
        this.f35702n = aiVar;
        this.f35703o = cbVar;
        this.f35704p = uVar;
        this.f35693e = auVar;
        this.f35705q = anVar;
    }

    private static boolean A(int i3) {
        if ((i3 & 536870912) != 0) {
            return true;
        }
        return false;
    }

    private boolean B(T t16, int i3) {
        if (this.f35696h) {
            int s06 = s0(i3);
            long U = U(s06);
            switch (r0(s06)) {
                case 0:
                    if (ch.y(t16, U) == 0.0d) {
                        return false;
                    }
                    return true;
                case 1:
                    if (ch.z(t16, U) == 0.0f) {
                        return false;
                    }
                    return true;
                case 2:
                    if (ch.C(t16, U) == 0) {
                        return false;
                    }
                    return true;
                case 3:
                    if (ch.C(t16, U) == 0) {
                        return false;
                    }
                    return true;
                case 4:
                    if (ch.A(t16, U) == 0) {
                        return false;
                    }
                    return true;
                case 5:
                    if (ch.C(t16, U) == 0) {
                        return false;
                    }
                    return true;
                case 6:
                    if (ch.A(t16, U) == 0) {
                        return false;
                    }
                    return true;
                case 7:
                    return ch.r(t16, U);
                case 8:
                    Object E = ch.E(t16, U);
                    if (E instanceof String) {
                        return !((String) E).isEmpty();
                    }
                    if (E instanceof ByteString) {
                        return !ByteString.EMPTY.equals(E);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    if (ch.E(t16, U) == null) {
                        return false;
                    }
                    return true;
                case 10:
                    return !ByteString.EMPTY.equals(ch.E(t16, U));
                case 11:
                    if (ch.A(t16, U) == 0) {
                        return false;
                    }
                    return true;
                case 12:
                    if (ch.A(t16, U) == 0) {
                        return false;
                    }
                    return true;
                case 13:
                    if (ch.A(t16, U) == 0) {
                        return false;
                    }
                    return true;
                case 14:
                    if (ch.C(t16, U) == 0) {
                        return false;
                    }
                    return true;
                case 15:
                    if (ch.A(t16, U) == 0) {
                        return false;
                    }
                    return true;
                case 16:
                    if (ch.C(t16, U) == 0) {
                        return false;
                    }
                    return true;
                case 17:
                    if (ch.E(t16, U) == null) {
                        return false;
                    }
                    return true;
                default:
                    throw new IllegalArgumentException();
            }
        }
        if ((ch.A(t16, r9 & 1048575) & (1 << (h0(i3) >>> 20))) == 0) {
            return false;
        }
        return true;
    }

    private boolean C(T t16, int i3, int i16, int i17) {
        if (this.f35696h) {
            return B(t16, i3);
        }
        if ((i16 & i17) != 0) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean D(Object obj, int i3, bq bqVar) {
        return bqVar.b(ch.E(obj, U(i3)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <N> boolean E(Object obj, int i3, int i16) {
        List list = (List) ch.E(obj, U(i3));
        if (list.isEmpty()) {
            return true;
        }
        bq u16 = u(i16);
        for (int i17 = 0; i17 < list.size(); i17++) {
            if (!u16.b(list.get(i17))) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8, types: [com.google.protobuf.bq] */
    private boolean F(T t16, int i3, int i16) {
        Map<?, ?> h16 = this.f35705q.h(ch.E(t16, U(i3)));
        if (h16.isEmpty()) {
            return true;
        }
        if (this.f35705q.e(t(i16)).f35683c.getJavaType() != WireFormat.JavaType.MESSAGE) {
            return true;
        }
        ?? r56 = 0;
        for (Object obj : h16.values()) {
            r56 = r56;
            if (r56 == 0) {
                r56 = bi.a().d(obj.getClass());
            }
            if (!r56.b(obj)) {
                return false;
            }
        }
        return true;
    }

    private boolean G(T t16, T t17, int i3) {
        long h06 = h0(i3) & 1048575;
        if (ch.A(t16, h06) == ch.A(t17, h06)) {
            return true;
        }
        return false;
    }

    private boolean H(T t16, int i3, int i16) {
        if (ch.A(t16, h0(i16) & 1048575) == i3) {
            return true;
        }
        return false;
    }

    private static boolean I(int i3) {
        if ((i3 & 268435456) != 0) {
            return true;
        }
        return false;
    }

    private static List<?> J(Object obj, long j3) {
        return (List) ch.E(obj, j3);
    }

    private static <T> long K(T t16, long j3) {
        return ch.C(t16, j3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:324:0x0077, code lost:
    
        r0 = r16.f35699k;
     */
    /* JADX WARN: Code restructure failed: missing block: B:326:0x007b, code lost:
    
        if (r0 >= r16.f35700l) goto L359;
     */
    /* JADX WARN: Code restructure failed: missing block: B:327:0x007d, code lost:
    
        r13 = p(r19, r16.f35698j[r0], r13, r17);
        r0 = r0 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:329:0x0088, code lost:
    
        if (r13 == null) goto L363;
     */
    /* JADX WARN: Code restructure failed: missing block: B:330:0x008a, code lost:
    
        r17.o(r19, r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:331:0x008d, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:332:?, code lost:
    
        return;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x0098. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private <UT, UB, ET extends z.c<ET>> void L(cb<UT, UB> cbVar, u<ET> uVar, T t16, bn bnVar, t tVar) throws IOException {
        Object obj = null;
        z<ET> zVar = null;
        while (true) {
            try {
                int t17 = bnVar.t();
                int f06 = f0(t17);
                if (f06 < 0) {
                    if (t17 == Integer.MAX_VALUE) {
                        for (int i3 = this.f35699k; i3 < this.f35700l; i3++) {
                            obj = p(t16, this.f35698j[i3], obj, cbVar);
                        }
                        if (obj != null) {
                            cbVar.o(t16, obj);
                            return;
                        }
                        return;
                    }
                    Object b16 = !this.f35694f ? null : uVar.b(tVar, this.f35693e, t17);
                    if (b16 != null) {
                        if (zVar == null) {
                            zVar = uVar.d(t16);
                        }
                        obj = uVar.g(bnVar, b16, tVar, zVar, obj, cbVar);
                    } else if (cbVar.q(bnVar)) {
                        if (bnVar.m()) {
                        }
                    } else {
                        if (obj == null) {
                            obj = cbVar.f(t16);
                        }
                        if (cbVar.m(obj, bnVar)) {
                        }
                    }
                } else {
                    int s06 = s0(f06);
                    try {
                        switch (r0(s06)) {
                            case 0:
                                ch.Q(t16, U(s06), bnVar.readDouble());
                                n0(t16, f06);
                                break;
                            case 1:
                                ch.R(t16, U(s06), bnVar.readFloat());
                                n0(t16, f06);
                                break;
                            case 2:
                                ch.T(t16, U(s06), bnVar.b());
                                n0(t16, f06);
                                break;
                            case 3:
                                ch.T(t16, U(s06), bnVar.f());
                                n0(t16, f06);
                                break;
                            case 4:
                                ch.S(t16, U(s06), bnVar.h());
                                n0(t16, f06);
                                break;
                            case 5:
                                ch.T(t16, U(s06), bnVar.w());
                                n0(t16, f06);
                                break;
                            case 6:
                                ch.S(t16, U(s06), bnVar.p());
                                n0(t16, f06);
                                break;
                            case 7:
                                ch.K(t16, U(s06), bnVar.c());
                                n0(t16, f06);
                                break;
                            case 8:
                                k0(t16, s06, bnVar);
                                n0(t16, f06);
                                break;
                            case 9:
                                if (B(t16, f06)) {
                                    ch.U(t16, U(s06), ad.j(ch.E(t16, U(s06)), bnVar.J(u(f06), tVar)));
                                    break;
                                } else {
                                    ch.U(t16, U(s06), bnVar.J(u(f06), tVar));
                                    n0(t16, f06);
                                    break;
                                }
                            case 10:
                                ch.U(t16, U(s06), bnVar.e());
                                n0(t16, f06);
                                break;
                            case 11:
                                ch.S(t16, U(s06), bnVar.a());
                                n0(t16, f06);
                                break;
                            case 12:
                                int C = bnVar.C();
                                ad.e s16 = s(f06);
                                if (s16 != null && !s16.isInRange(C)) {
                                    obj = bs.M(t17, C, obj, cbVar);
                                    break;
                                }
                                ch.S(t16, U(s06), C);
                                n0(t16, f06);
                                break;
                            case 13:
                                ch.S(t16, U(s06), bnVar.A());
                                n0(t16, f06);
                                break;
                            case 14:
                                ch.T(t16, U(s06), bnVar.K());
                                n0(t16, f06);
                                break;
                            case 15:
                                ch.S(t16, U(s06), bnVar.r());
                                n0(t16, f06);
                                break;
                            case 16:
                                ch.T(t16, U(s06), bnVar.Q());
                                n0(t16, f06);
                                break;
                            case 17:
                                if (B(t16, f06)) {
                                    ch.U(t16, U(s06), ad.j(ch.E(t16, U(s06)), bnVar.E(u(f06), tVar)));
                                    break;
                                } else {
                                    ch.U(t16, U(s06), bnVar.E(u(f06), tVar));
                                    n0(t16, f06);
                                    break;
                                }
                            case 18:
                                bnVar.N(this.f35702n.e(t16, U(s06)));
                                break;
                            case 19:
                                bnVar.u(this.f35702n.e(t16, U(s06)));
                                break;
                            case 20:
                                bnVar.z(this.f35702n.e(t16, U(s06)));
                                break;
                            case 21:
                                bnVar.G(this.f35702n.e(t16, U(s06)));
                                break;
                            case 22:
                                bnVar.k(this.f35702n.e(t16, U(s06)));
                                break;
                            case 23:
                                bnVar.I(this.f35702n.e(t16, U(s06)));
                                break;
                            case 24:
                                bnVar.L(this.f35702n.e(t16, U(s06)));
                                break;
                            case 25:
                                bnVar.D(this.f35702n.e(t16, U(s06)));
                                break;
                            case 26:
                                l0(t16, s06, bnVar);
                                break;
                            case 27:
                                j0(t16, s06, bnVar, u(f06), tVar);
                                break;
                            case 28:
                                bnVar.v(this.f35702n.e(t16, U(s06)));
                                break;
                            case 29:
                                bnVar.P(this.f35702n.e(t16, U(s06)));
                                break;
                            case 30:
                                List<Integer> e16 = this.f35702n.e(t16, U(s06));
                                bnVar.O(e16);
                                obj = bs.A(t17, e16, s(f06), obj, cbVar);
                                break;
                            case 31:
                                bnVar.x(this.f35702n.e(t16, U(s06)));
                                break;
                            case 32:
                                bnVar.j(this.f35702n.e(t16, U(s06)));
                                break;
                            case 33:
                                bnVar.i(this.f35702n.e(t16, U(s06)));
                                break;
                            case 34:
                                bnVar.q(this.f35702n.e(t16, U(s06)));
                                break;
                            case 35:
                                bnVar.N(this.f35702n.e(t16, U(s06)));
                                break;
                            case 36:
                                bnVar.u(this.f35702n.e(t16, U(s06)));
                                break;
                            case 37:
                                bnVar.z(this.f35702n.e(t16, U(s06)));
                                break;
                            case 38:
                                bnVar.G(this.f35702n.e(t16, U(s06)));
                                break;
                            case 39:
                                bnVar.k(this.f35702n.e(t16, U(s06)));
                                break;
                            case 40:
                                bnVar.I(this.f35702n.e(t16, U(s06)));
                                break;
                            case 41:
                                bnVar.L(this.f35702n.e(t16, U(s06)));
                                break;
                            case 42:
                                bnVar.D(this.f35702n.e(t16, U(s06)));
                                break;
                            case 43:
                                bnVar.P(this.f35702n.e(t16, U(s06)));
                                break;
                            case 44:
                                List<Integer> e17 = this.f35702n.e(t16, U(s06));
                                bnVar.O(e17);
                                obj = bs.A(t17, e17, s(f06), obj, cbVar);
                                break;
                            case 45:
                                bnVar.x(this.f35702n.e(t16, U(s06)));
                                break;
                            case 46:
                                bnVar.j(this.f35702n.e(t16, U(s06)));
                                break;
                            case 47:
                                bnVar.i(this.f35702n.e(t16, U(s06)));
                                break;
                            case 48:
                                bnVar.q(this.f35702n.e(t16, U(s06)));
                                break;
                            case 49:
                                i0(t16, U(s06), bnVar, u(f06), tVar);
                                break;
                            case 50:
                                M(t16, f06, t(f06), tVar, bnVar);
                                break;
                            case 51:
                                ch.U(t16, U(s06), Double.valueOf(bnVar.readDouble()));
                                o0(t16, t17, f06);
                                break;
                            case 52:
                                ch.U(t16, U(s06), Float.valueOf(bnVar.readFloat()));
                                o0(t16, t17, f06);
                                break;
                            case 53:
                                ch.U(t16, U(s06), Long.valueOf(bnVar.b()));
                                o0(t16, t17, f06);
                                break;
                            case 54:
                                ch.U(t16, U(s06), Long.valueOf(bnVar.f()));
                                o0(t16, t17, f06);
                                break;
                            case 55:
                                ch.U(t16, U(s06), Integer.valueOf(bnVar.h()));
                                o0(t16, t17, f06);
                                break;
                            case 56:
                                ch.U(t16, U(s06), Long.valueOf(bnVar.w()));
                                o0(t16, t17, f06);
                                break;
                            case 57:
                                ch.U(t16, U(s06), Integer.valueOf(bnVar.p()));
                                o0(t16, t17, f06);
                                break;
                            case 58:
                                ch.U(t16, U(s06), Boolean.valueOf(bnVar.c()));
                                o0(t16, t17, f06);
                                break;
                            case 59:
                                k0(t16, s06, bnVar);
                                o0(t16, t17, f06);
                                break;
                            case 60:
                                if (H(t16, t17, f06)) {
                                    ch.U(t16, U(s06), ad.j(ch.E(t16, U(s06)), bnVar.J(u(f06), tVar)));
                                } else {
                                    ch.U(t16, U(s06), bnVar.J(u(f06), tVar));
                                    n0(t16, f06);
                                }
                                o0(t16, t17, f06);
                                break;
                            case 61:
                                ch.U(t16, U(s06), bnVar.e());
                                o0(t16, t17, f06);
                                break;
                            case 62:
                                ch.U(t16, U(s06), Integer.valueOf(bnVar.a()));
                                o0(t16, t17, f06);
                                break;
                            case 63:
                                int C2 = bnVar.C();
                                ad.e s17 = s(f06);
                                if (s17 != null && !s17.isInRange(C2)) {
                                    obj = bs.M(t17, C2, obj, cbVar);
                                    break;
                                }
                                ch.U(t16, U(s06), Integer.valueOf(C2));
                                o0(t16, t17, f06);
                                break;
                            case 64:
                                ch.U(t16, U(s06), Integer.valueOf(bnVar.A()));
                                o0(t16, t17, f06);
                                break;
                            case 65:
                                ch.U(t16, U(s06), Long.valueOf(bnVar.K()));
                                o0(t16, t17, f06);
                                break;
                            case 66:
                                ch.U(t16, U(s06), Integer.valueOf(bnVar.r()));
                                o0(t16, t17, f06);
                                break;
                            case 67:
                                ch.U(t16, U(s06), Long.valueOf(bnVar.Q()));
                                o0(t16, t17, f06);
                                break;
                            case 68:
                                ch.U(t16, U(s06), bnVar.E(u(f06), tVar));
                                o0(t16, t17, f06);
                                break;
                            default:
                                if (obj == null) {
                                    obj = cbVar.n();
                                }
                                if (!cbVar.m(obj, bnVar)) {
                                    for (int i16 = this.f35699k; i16 < this.f35700l; i16++) {
                                        obj = p(t16, this.f35698j[i16], obj, cbVar);
                                    }
                                    if (obj != null) {
                                        cbVar.o(t16, obj);
                                        return;
                                    }
                                    return;
                                }
                                break;
                        }
                    } catch (InvalidProtocolBufferException.InvalidWireTypeException unused) {
                        if (cbVar.q(bnVar)) {
                            if (!bnVar.m()) {
                                for (int i17 = this.f35699k; i17 < this.f35700l; i17++) {
                                    obj = p(t16, this.f35698j[i17], obj, cbVar);
                                }
                                if (obj != null) {
                                    cbVar.o(t16, obj);
                                    return;
                                }
                                return;
                            }
                        } else {
                            if (obj == null) {
                                obj = cbVar.f(t16);
                            }
                            if (!cbVar.m(obj, bnVar)) {
                                for (int i18 = this.f35699k; i18 < this.f35700l; i18++) {
                                    obj = p(t16, this.f35698j[i18], obj, cbVar);
                                }
                                if (obj != null) {
                                    cbVar.o(t16, obj);
                                    return;
                                }
                                return;
                            }
                        }
                    }
                }
            } catch (Throwable th5) {
                for (int i19 = this.f35699k; i19 < this.f35700l; i19++) {
                    obj = p(t16, this.f35698j[i19], obj, cbVar);
                }
                if (obj != null) {
                    cbVar.o(t16, obj);
                }
                throw th5;
            }
        }
    }

    private final <K, V> void M(Object obj, int i3, Object obj2, t tVar, bn bnVar) throws IOException {
        long U = U(s0(i3));
        Object E = ch.E(obj, U);
        if (E == null) {
            E = this.f35705q.b(obj2);
            ch.U(obj, U, E);
        } else if (this.f35705q.d(E)) {
            Object b16 = this.f35705q.b(obj2);
            this.f35705q.a(b16, E);
            ch.U(obj, U, b16);
            E = b16;
        }
        bnVar.s(this.f35705q.g(E), this.f35705q.e(obj2), tVar);
    }

    private void N(T t16, T t17, int i3) {
        long U = U(s0(i3));
        if (!B(t17, i3)) {
            return;
        }
        Object E = ch.E(t16, U);
        Object E2 = ch.E(t17, U);
        if (E != null && E2 != null) {
            ch.U(t16, U, ad.j(E, E2));
            n0(t16, i3);
        } else if (E2 != null) {
            ch.U(t16, U, E2);
            n0(t16, i3);
        }
    }

    private void O(T t16, T t17, int i3) {
        int s06 = s0(i3);
        int T = T(i3);
        long U = U(s06);
        if (!H(t17, T, i3)) {
            return;
        }
        Object E = ch.E(t16, U);
        Object E2 = ch.E(t17, U);
        if (E != null && E2 != null) {
            ch.U(t16, U, ad.j(E, E2));
            o0(t16, T, i3);
        } else if (E2 != null) {
            ch.U(t16, U, E2);
            o0(t16, T, i3);
        }
    }

    private void P(T t16, T t17, int i3) {
        int s06 = s0(i3);
        long U = U(s06);
        int T = T(i3);
        switch (r0(s06)) {
            case 0:
                if (B(t17, i3)) {
                    ch.Q(t16, U, ch.y(t17, U));
                    n0(t16, i3);
                    return;
                }
                return;
            case 1:
                if (B(t17, i3)) {
                    ch.R(t16, U, ch.z(t17, U));
                    n0(t16, i3);
                    return;
                }
                return;
            case 2:
                if (B(t17, i3)) {
                    ch.T(t16, U, ch.C(t17, U));
                    n0(t16, i3);
                    return;
                }
                return;
            case 3:
                if (B(t17, i3)) {
                    ch.T(t16, U, ch.C(t17, U));
                    n0(t16, i3);
                    return;
                }
                return;
            case 4:
                if (B(t17, i3)) {
                    ch.S(t16, U, ch.A(t17, U));
                    n0(t16, i3);
                    return;
                }
                return;
            case 5:
                if (B(t17, i3)) {
                    ch.T(t16, U, ch.C(t17, U));
                    n0(t16, i3);
                    return;
                }
                return;
            case 6:
                if (B(t17, i3)) {
                    ch.S(t16, U, ch.A(t17, U));
                    n0(t16, i3);
                    return;
                }
                return;
            case 7:
                if (B(t17, i3)) {
                    ch.K(t16, U, ch.r(t17, U));
                    n0(t16, i3);
                    return;
                }
                return;
            case 8:
                if (B(t17, i3)) {
                    ch.U(t16, U, ch.E(t17, U));
                    n0(t16, i3);
                    return;
                }
                return;
            case 9:
                N(t16, t17, i3);
                return;
            case 10:
                if (B(t17, i3)) {
                    ch.U(t16, U, ch.E(t17, U));
                    n0(t16, i3);
                    return;
                }
                return;
            case 11:
                if (B(t17, i3)) {
                    ch.S(t16, U, ch.A(t17, U));
                    n0(t16, i3);
                    return;
                }
                return;
            case 12:
                if (B(t17, i3)) {
                    ch.S(t16, U, ch.A(t17, U));
                    n0(t16, i3);
                    return;
                }
                return;
            case 13:
                if (B(t17, i3)) {
                    ch.S(t16, U, ch.A(t17, U));
                    n0(t16, i3);
                    return;
                }
                return;
            case 14:
                if (B(t17, i3)) {
                    ch.T(t16, U, ch.C(t17, U));
                    n0(t16, i3);
                    return;
                }
                return;
            case 15:
                if (B(t17, i3)) {
                    ch.S(t16, U, ch.A(t17, U));
                    n0(t16, i3);
                    return;
                }
                return;
            case 16:
                if (B(t17, i3)) {
                    ch.T(t16, U, ch.C(t17, U));
                    n0(t16, i3);
                    return;
                }
                return;
            case 17:
                N(t16, t17, i3);
                return;
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
                this.f35702n.d(t16, t17, U);
                return;
            case 50:
                bs.G(this.f35705q, t16, t17, U);
                return;
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
                if (H(t17, T, i3)) {
                    ch.U(t16, U, ch.E(t17, U));
                    o0(t16, T, i3);
                    return;
                }
                return;
            case 60:
                O(t16, t17, i3);
                return;
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
                if (H(t17, T, i3)) {
                    ch.U(t16, U, ch.E(t17, U));
                    o0(t16, T, i3);
                    return;
                }
                return;
            case 68:
                O(t16, t17, i3);
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> ay<T> Q(Class<T> cls, as asVar, bb bbVar, ai aiVar, cb<?, ?> cbVar, u<?> uVar, an anVar) {
        if (asVar instanceof bm) {
            return S((bm) asVar, bbVar, aiVar, cbVar, uVar, anVar);
        }
        return R((bw) asVar, bbVar, aiVar, cbVar, uVar, anVar);
    }

    static <T> ay<T> R(bw bwVar, bb bbVar, ai aiVar, cb<?, ?> cbVar, u<?> uVar, an anVar) {
        boolean z16;
        int q16;
        int q17;
        int[] iArr;
        int i3;
        if (bwVar.getSyntax() == ProtoSyntax.PROTO3) {
            z16 = true;
        } else {
            z16 = false;
        }
        y[] d16 = bwVar.d();
        if (d16.length == 0) {
            q16 = 0;
            q17 = 0;
        } else {
            q16 = d16[0].q();
            q17 = d16[d16.length - 1].q();
        }
        int length = d16.length;
        int[] iArr2 = new int[length * 3];
        Object[] objArr = new Object[length * 2];
        int i16 = 0;
        int i17 = 0;
        for (y yVar : d16) {
            if (yVar.w() == FieldType.MAP) {
                i16++;
            } else if (yVar.w().id() >= 18 && yVar.w().id() <= 49) {
                i17++;
            }
        }
        int[] iArr3 = null;
        if (i16 > 0) {
            iArr = new int[i16];
        } else {
            iArr = null;
        }
        if (i17 > 0) {
            iArr3 = new int[i17];
        }
        int[] c16 = bwVar.c();
        if (c16 == null) {
            c16 = f35687r;
        }
        int i18 = 0;
        int i19 = 0;
        int i26 = 0;
        int i27 = 0;
        int i28 = 0;
        while (i18 < d16.length) {
            y yVar2 = d16[i18];
            int q18 = yVar2.q();
            q0(yVar2, iArr2, i19, z16, objArr);
            if (i26 < c16.length && c16[i26] == q18) {
                c16[i26] = i19;
                i26++;
            }
            if (yVar2.w() == FieldType.MAP) {
                iArr[i27] = i19;
                i27++;
            } else if (yVar2.w().id() >= 18 && yVar2.w().id() <= 49) {
                i3 = i19;
                iArr3[i28] = (int) ch.J(yVar2.p());
                i28++;
                i18++;
                i19 = i3 + 3;
            }
            i3 = i19;
            i18++;
            i19 = i3 + 3;
        }
        if (iArr == null) {
            iArr = f35687r;
        }
        if (iArr3 == null) {
            iArr3 = f35687r;
        }
        int[] iArr4 = new int[c16.length + iArr.length + iArr3.length];
        System.arraycopy(c16, 0, iArr4, 0, c16.length);
        System.arraycopy(iArr, 0, iArr4, c16.length, iArr.length);
        System.arraycopy(iArr3, 0, iArr4, c16.length + iArr.length, iArr3.length);
        return new ay<>(iArr2, objArr, q16, q17, bwVar.b(), z16, true, iArr4, c16.length, c16.length + iArr.length, bbVar, aiVar, cbVar, uVar, anVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x033c  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x039e  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0391  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0295  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x027a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static <T> ay<T> S(bm bmVar, bb bbVar, ai aiVar, cb<?, ?> cbVar, u<?> uVar, an anVar) {
        boolean z16;
        int i3;
        int charAt;
        int charAt2;
        int charAt3;
        int i16;
        int i17;
        int[] iArr;
        int i18;
        int i19;
        char charAt4;
        int i26;
        char charAt5;
        int i27;
        char charAt6;
        int i28;
        char charAt7;
        int i29;
        char charAt8;
        int i36;
        char charAt9;
        int i37;
        char charAt10;
        int i38;
        char charAt11;
        int i39;
        int i46;
        boolean z17;
        int i47;
        int[] iArr2;
        int i48;
        int i49;
        String str;
        Class<?> cls;
        int i56;
        int i57;
        int i58;
        int i59;
        int i65;
        int i66;
        Field m06;
        int i67;
        char charAt12;
        int i68;
        int i69;
        int i75;
        int i76;
        Object obj;
        Field m07;
        Object obj2;
        Field m08;
        int i77;
        char charAt13;
        int i78;
        char charAt14;
        int i79;
        char charAt15;
        int i85;
        char charAt16;
        char charAt17;
        int i86 = 0;
        if (bmVar.getSyntax() == ProtoSyntax.PROTO3) {
            z16 = true;
        } else {
            z16 = false;
        }
        String d16 = bmVar.d();
        int length = d16.length();
        int charAt18 = d16.charAt(0);
        if (charAt18 >= 55296) {
            int i87 = charAt18 & InitSkin.DRAWABLE_COUNT;
            int i88 = 1;
            int i89 = 13;
            while (true) {
                i3 = i88 + 1;
                charAt17 = d16.charAt(i88);
                if (charAt17 < '\ud800') {
                    break;
                }
                i87 |= (charAt17 & '\u1fff') << i89;
                i89 += 13;
                i88 = i3;
            }
            charAt18 = i87 | (charAt17 << i89);
        } else {
            i3 = 1;
        }
        int i95 = i3 + 1;
        int charAt19 = d16.charAt(i3);
        if (charAt19 >= 55296) {
            int i96 = charAt19 & InitSkin.DRAWABLE_COUNT;
            int i97 = 13;
            while (true) {
                i85 = i95 + 1;
                charAt16 = d16.charAt(i95);
                if (charAt16 < '\ud800') {
                    break;
                }
                i96 |= (charAt16 & '\u1fff') << i97;
                i97 += 13;
                i95 = i85;
            }
            charAt19 = i96 | (charAt16 << i97);
            i95 = i85;
        }
        if (charAt19 == 0) {
            i18 = 0;
            charAt = 0;
            charAt2 = 0;
            i16 = 0;
            charAt3 = 0;
            iArr = f35687r;
            i17 = 0;
        } else {
            int i98 = i95 + 1;
            int charAt20 = d16.charAt(i95);
            if (charAt20 >= 55296) {
                int i99 = charAt20 & InitSkin.DRAWABLE_COUNT;
                int i100 = 13;
                while (true) {
                    i38 = i98 + 1;
                    charAt11 = d16.charAt(i98);
                    if (charAt11 < '\ud800') {
                        break;
                    }
                    i99 |= (charAt11 & '\u1fff') << i100;
                    i100 += 13;
                    i98 = i38;
                }
                charAt20 = i99 | (charAt11 << i100);
                i98 = i38;
            }
            int i101 = i98 + 1;
            int charAt21 = d16.charAt(i98);
            if (charAt21 >= 55296) {
                int i102 = charAt21 & InitSkin.DRAWABLE_COUNT;
                int i103 = 13;
                while (true) {
                    i37 = i101 + 1;
                    charAt10 = d16.charAt(i101);
                    if (charAt10 < '\ud800') {
                        break;
                    }
                    i102 |= (charAt10 & '\u1fff') << i103;
                    i103 += 13;
                    i101 = i37;
                }
                charAt21 = i102 | (charAt10 << i103);
                i101 = i37;
            }
            int i104 = i101 + 1;
            int charAt22 = d16.charAt(i101);
            if (charAt22 >= 55296) {
                int i105 = charAt22 & InitSkin.DRAWABLE_COUNT;
                int i106 = 13;
                while (true) {
                    i36 = i104 + 1;
                    charAt9 = d16.charAt(i104);
                    if (charAt9 < '\ud800') {
                        break;
                    }
                    i105 |= (charAt9 & '\u1fff') << i106;
                    i106 += 13;
                    i104 = i36;
                }
                charAt22 = i105 | (charAt9 << i106);
                i104 = i36;
            }
            int i107 = i104 + 1;
            charAt = d16.charAt(i104);
            if (charAt >= 55296) {
                int i108 = charAt & InitSkin.DRAWABLE_COUNT;
                int i109 = 13;
                while (true) {
                    i29 = i107 + 1;
                    charAt8 = d16.charAt(i107);
                    if (charAt8 < '\ud800') {
                        break;
                    }
                    i108 |= (charAt8 & '\u1fff') << i109;
                    i109 += 13;
                    i107 = i29;
                }
                charAt = i108 | (charAt8 << i109);
                i107 = i29;
            }
            int i110 = i107 + 1;
            charAt2 = d16.charAt(i107);
            if (charAt2 >= 55296) {
                int i111 = charAt2 & InitSkin.DRAWABLE_COUNT;
                int i112 = 13;
                while (true) {
                    i28 = i110 + 1;
                    charAt7 = d16.charAt(i110);
                    if (charAt7 < '\ud800') {
                        break;
                    }
                    i111 |= (charAt7 & '\u1fff') << i112;
                    i112 += 13;
                    i110 = i28;
                }
                charAt2 = i111 | (charAt7 << i112);
                i110 = i28;
            }
            int i113 = i110 + 1;
            int charAt23 = d16.charAt(i110);
            if (charAt23 >= 55296) {
                int i114 = charAt23 & InitSkin.DRAWABLE_COUNT;
                int i115 = 13;
                while (true) {
                    i27 = i113 + 1;
                    charAt6 = d16.charAt(i113);
                    if (charAt6 < '\ud800') {
                        break;
                    }
                    i114 |= (charAt6 & '\u1fff') << i115;
                    i115 += 13;
                    i113 = i27;
                }
                charAt23 = i114 | (charAt6 << i115);
                i113 = i27;
            }
            int i116 = i113 + 1;
            int charAt24 = d16.charAt(i113);
            if (charAt24 >= 55296) {
                int i117 = charAt24 & InitSkin.DRAWABLE_COUNT;
                int i118 = 13;
                while (true) {
                    i26 = i116 + 1;
                    charAt5 = d16.charAt(i116);
                    if (charAt5 < '\ud800') {
                        break;
                    }
                    i117 |= (charAt5 & '\u1fff') << i118;
                    i118 += 13;
                    i116 = i26;
                }
                charAt24 = i117 | (charAt5 << i118);
                i116 = i26;
            }
            int i119 = i116 + 1;
            charAt3 = d16.charAt(i116);
            if (charAt3 >= 55296) {
                int i120 = charAt3 & InitSkin.DRAWABLE_COUNT;
                int i121 = i119;
                int i122 = 13;
                while (true) {
                    i19 = i121 + 1;
                    charAt4 = d16.charAt(i121);
                    if (charAt4 < '\ud800') {
                        break;
                    }
                    i120 |= (charAt4 & '\u1fff') << i122;
                    i122 += 13;
                    i121 = i19;
                }
                charAt3 = i120 | (charAt4 << i122);
                i119 = i19;
            }
            int[] iArr3 = new int[charAt3 + charAt23 + charAt24];
            i16 = (charAt20 * 2) + charAt21;
            i17 = charAt20;
            i95 = i119;
            int i123 = charAt23;
            iArr = iArr3;
            i86 = charAt22;
            i18 = i123;
        }
        Unsafe unsafe = f35688s;
        Object[] c16 = bmVar.c();
        Class<?> cls2 = bmVar.b().getClass();
        int[] iArr4 = new int[charAt2 * 3];
        Object[] objArr = new Object[charAt2 * 2];
        int i124 = charAt3 + i18;
        int i125 = charAt3;
        int i126 = i124;
        int i127 = 0;
        int i128 = 0;
        while (i95 < length) {
            int i129 = i95 + 1;
            int charAt25 = d16.charAt(i95);
            int i130 = length;
            if (charAt25 >= 55296) {
                int i131 = charAt25 & InitSkin.DRAWABLE_COUNT;
                int i132 = i129;
                int i133 = 13;
                while (true) {
                    i79 = i132 + 1;
                    charAt15 = d16.charAt(i132);
                    i39 = charAt3;
                    if (charAt15 < '\ud800') {
                        break;
                    }
                    i131 |= (charAt15 & '\u1fff') << i133;
                    i133 += 13;
                    i132 = i79;
                    charAt3 = i39;
                }
                charAt25 = i131 | (charAt15 << i133);
                i46 = i79;
            } else {
                i39 = charAt3;
                i46 = i129;
            }
            int i134 = i46 + 1;
            int charAt26 = d16.charAt(i46);
            if (charAt26 >= 55296) {
                int i135 = charAt26 & InitSkin.DRAWABLE_COUNT;
                int i136 = i134;
                int i137 = 13;
                while (true) {
                    i78 = i136 + 1;
                    charAt14 = d16.charAt(i136);
                    z17 = z16;
                    if (charAt14 < '\ud800') {
                        break;
                    }
                    i135 |= (charAt14 & '\u1fff') << i137;
                    i137 += 13;
                    i136 = i78;
                    z16 = z17;
                }
                charAt26 = i135 | (charAt14 << i137);
                i47 = i78;
            } else {
                z17 = z16;
                i47 = i134;
            }
            int i138 = charAt26 & 255;
            int i139 = charAt;
            if ((charAt26 & 1024) != 0) {
                iArr[i127] = i128;
                i127++;
            }
            int i140 = i127;
            if (i138 >= 51) {
                int i141 = i47 + 1;
                int charAt27 = d16.charAt(i47);
                char c17 = '\ud800';
                if (charAt27 >= 55296) {
                    int i142 = charAt27 & InitSkin.DRAWABLE_COUNT;
                    int i143 = 13;
                    while (true) {
                        i77 = i141 + 1;
                        charAt13 = d16.charAt(i141);
                        if (charAt13 < c17) {
                            break;
                        }
                        i142 |= (charAt13 & '\u1fff') << i143;
                        i143 += 13;
                        i141 = i77;
                        c17 = '\ud800';
                    }
                    charAt27 = i142 | (charAt13 << i143);
                    i141 = i77;
                }
                int i144 = i138 - 51;
                int i145 = i141;
                if (i144 != 9 && i144 != 17) {
                    if (i144 == 12 && (charAt18 & 1) == 1) {
                        i76 = i16 + 1;
                        objArr[((i128 / 3) * 2) + 1] = c16[i16];
                    }
                    int i146 = charAt27 * 2;
                    obj = c16[i146];
                    if (!(obj instanceof Field)) {
                        m07 = (Field) obj;
                    } else {
                        m07 = m0(cls2, (String) obj);
                        c16[i146] = m07;
                    }
                    iArr2 = iArr4;
                    i48 = charAt25;
                    int objectFieldOffset = (int) unsafe.objectFieldOffset(m07);
                    int i147 = i146 + 1;
                    obj2 = c16[i147];
                    if (!(obj2 instanceof Field)) {
                        m08 = (Field) obj2;
                    } else {
                        m08 = m0(cls2, (String) obj2);
                        c16[i147] = m08;
                    }
                    str = d16;
                    cls = cls2;
                    i56 = charAt18;
                    i59 = (int) unsafe.objectFieldOffset(m08);
                    i66 = objectFieldOffset;
                    i57 = i138;
                    i95 = i145;
                    i65 = 0;
                } else {
                    i76 = i16 + 1;
                    objArr[((i128 / 3) * 2) + 1] = c16[i16];
                }
                i16 = i76;
                int i1462 = charAt27 * 2;
                obj = c16[i1462];
                if (!(obj instanceof Field)) {
                }
                iArr2 = iArr4;
                i48 = charAt25;
                int objectFieldOffset2 = (int) unsafe.objectFieldOffset(m07);
                int i1472 = i1462 + 1;
                obj2 = c16[i1472];
                if (!(obj2 instanceof Field)) {
                }
                str = d16;
                cls = cls2;
                i56 = charAt18;
                i59 = (int) unsafe.objectFieldOffset(m08);
                i66 = objectFieldOffset2;
                i57 = i138;
                i95 = i145;
                i65 = 0;
            } else {
                iArr2 = iArr4;
                i48 = charAt25;
                int i148 = i16 + 1;
                Field m09 = m0(cls2, (String) c16[i16]);
                if (i138 != 9 && i138 != 17) {
                    if (i138 != 27 && i138 != 49) {
                        if (i138 != 12 && i138 != 30 && i138 != 44) {
                            if (i138 == 50) {
                                int i149 = i125 + 1;
                                iArr[i125] = i128;
                                int i150 = (i128 / 3) * 2;
                                int i151 = i148 + 1;
                                objArr[i150] = c16[i148];
                                if ((charAt26 & 2048) != 0) {
                                    i148 = i151 + 1;
                                    objArr[i150 + 1] = c16[i151];
                                    i125 = i149;
                                } else {
                                    i125 = i149;
                                    i148 = i151;
                                }
                            }
                        } else if ((charAt18 & 1) == 1) {
                            i68 = i148 + 1;
                            objArr[((i128 / 3) * 2) + 1] = c16[i148];
                        }
                    } else {
                        i68 = i148 + 1;
                        objArr[((i128 / 3) * 2) + 1] = c16[i148];
                    }
                    i49 = i138;
                    i148 = i68;
                    int objectFieldOffset3 = (int) unsafe.objectFieldOffset(m09);
                    if ((charAt18 & 1) != 1) {
                        i57 = i49;
                        if (i57 <= 17) {
                            i58 = i47 + 1;
                            int charAt28 = d16.charAt(i47);
                            if (charAt28 >= 55296) {
                                int i152 = charAt28 & InitSkin.DRAWABLE_COUNT;
                                int i153 = 13;
                                while (true) {
                                    i67 = i58 + 1;
                                    charAt12 = d16.charAt(i58);
                                    if (charAt12 < '\ud800') {
                                        break;
                                    }
                                    i152 |= (charAt12 & '\u1fff') << i153;
                                    i153 += 13;
                                    i58 = i67;
                                }
                                charAt28 = i152 | (charAt12 << i153);
                                i58 = i67;
                            }
                            int i154 = (i17 * 2) + (charAt28 / 32);
                            Object obj3 = c16[i154];
                            str = d16;
                            if (obj3 instanceof Field) {
                                m06 = (Field) obj3;
                            } else {
                                m06 = m0(cls2, (String) obj3);
                                c16[i154] = m06;
                            }
                            cls = cls2;
                            i56 = charAt18;
                            i59 = (int) unsafe.objectFieldOffset(m06);
                            i65 = charAt28 % 32;
                            if (i57 >= 18 && i57 <= 49) {
                                iArr[i126] = objectFieldOffset3;
                                i126++;
                            }
                            int i155 = i58;
                            i16 = i148;
                            i66 = objectFieldOffset3;
                            i95 = i155;
                        } else {
                            str = d16;
                            cls = cls2;
                            i56 = charAt18;
                        }
                    } else {
                        str = d16;
                        cls = cls2;
                        i56 = charAt18;
                        i57 = i49;
                    }
                    i58 = i47;
                    i59 = 0;
                    i65 = 0;
                    if (i57 >= 18) {
                        iArr[i126] = objectFieldOffset3;
                        i126++;
                    }
                    int i1552 = i58;
                    i16 = i148;
                    i66 = objectFieldOffset3;
                    i95 = i1552;
                } else {
                    objArr[((i128 / 3) * 2) + 1] = m09.getType();
                }
                i49 = i138;
                int objectFieldOffset32 = (int) unsafe.objectFieldOffset(m09);
                if ((charAt18 & 1) != 1) {
                }
                i58 = i47;
                i59 = 0;
                i65 = 0;
                if (i57 >= 18) {
                }
                int i15522 = i58;
                i16 = i148;
                i66 = objectFieldOffset32;
                i95 = i15522;
            }
            int i156 = i128 + 1;
            iArr2[i128] = i48;
            int i157 = i156 + 1;
            int i158 = i56;
            if ((charAt26 & 512) != 0) {
                i69 = 536870912;
            } else {
                i69 = 0;
            }
            if ((charAt26 & 256) != 0) {
                i75 = 268435456;
            } else {
                i75 = 0;
            }
            iArr2[i156] = i69 | i75 | (i57 << 20) | i66;
            int i159 = i157 + 1;
            iArr2[i157] = (i65 << 20) | i59;
            iArr4 = iArr2;
            cls2 = cls;
            charAt18 = i158;
            charAt = i139;
            length = i130;
            charAt3 = i39;
            z16 = z17;
            i127 = i140;
            i128 = i159;
            d16 = str;
        }
        return new ay<>(iArr4, objArr, i86, charAt, bmVar.b(), z16, false, iArr, charAt3, i124, bbVar, aiVar, cbVar, uVar, anVar);
    }

    private int T(int i3) {
        return this.f35689a[i3];
    }

    private static long U(int i3) {
        return i3 & 1048575;
    }

    private static <T> boolean V(T t16, long j3) {
        return ((Boolean) ch.E(t16, j3)).booleanValue();
    }

    private static <T> double W(T t16, long j3) {
        return ((Double) ch.E(t16, j3)).doubleValue();
    }

    private static <T> float X(T t16, long j3) {
        return ((Float) ch.E(t16, j3)).floatValue();
    }

    private static <T> int Y(T t16, long j3) {
        return ((Integer) ch.E(t16, j3)).intValue();
    }

    private static <T> long Z(T t16, long j3) {
        return ((Long) ch.E(t16, j3)).longValue();
    }

    private <K, V> int a0(T t16, byte[] bArr, int i3, int i16, int i17, long j3, f.b bVar) throws IOException {
        Unsafe unsafe = f35688s;
        Object t17 = t(i17);
        Object object = unsafe.getObject(t16, j3);
        if (this.f35705q.d(object)) {
            Object b16 = this.f35705q.b(t17);
            this.f35705q.a(b16, object);
            unsafe.putObject(t16, j3, b16);
            object = b16;
        }
        return l(bArr, i3, i16, this.f35705q.e(t17), this.f35705q.g(object), bVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0023. Please report as an issue. */
    private int b0(T t16, byte[] bArr, int i3, int i16, int i17, int i18, int i19, int i26, int i27, long j3, int i28, f.b bVar) throws IOException {
        Unsafe unsafe = f35688s;
        long j16 = this.f35689a[i28 + 2] & 1048575;
        switch (i27) {
            case 51:
                if (i19 == 1) {
                    unsafe.putObject(t16, j3, Double.valueOf(f.d(bArr, i3)));
                    int i29 = i3 + 8;
                    unsafe.putInt(t16, j16, i18);
                    return i29;
                }
                return i3;
            case 52:
                if (i19 == 5) {
                    unsafe.putObject(t16, j3, Float.valueOf(f.l(bArr, i3)));
                    int i36 = i3 + 4;
                    unsafe.putInt(t16, j16, i18);
                    return i36;
                }
                return i3;
            case 53:
            case 54:
                if (i19 == 0) {
                    int L = f.L(bArr, i3, bVar);
                    unsafe.putObject(t16, j3, Long.valueOf(bVar.f35848b));
                    unsafe.putInt(t16, j16, i18);
                    return L;
                }
                return i3;
            case 55:
            case 62:
                if (i19 == 0) {
                    int I = f.I(bArr, i3, bVar);
                    unsafe.putObject(t16, j3, Integer.valueOf(bVar.f35847a));
                    unsafe.putInt(t16, j16, i18);
                    return I;
                }
                return i3;
            case 56:
            case 65:
                if (i19 == 1) {
                    unsafe.putObject(t16, j3, Long.valueOf(f.j(bArr, i3)));
                    int i37 = i3 + 8;
                    unsafe.putInt(t16, j16, i18);
                    return i37;
                }
                return i3;
            case 57:
            case 64:
                if (i19 == 5) {
                    unsafe.putObject(t16, j3, Integer.valueOf(f.h(bArr, i3)));
                    int i38 = i3 + 4;
                    unsafe.putInt(t16, j16, i18);
                    return i38;
                }
                return i3;
            case 58:
                if (i19 == 0) {
                    int L2 = f.L(bArr, i3, bVar);
                    unsafe.putObject(t16, j3, Boolean.valueOf(bVar.f35848b != 0));
                    unsafe.putInt(t16, j16, i18);
                    return L2;
                }
                return i3;
            case 59:
                if (i19 == 2) {
                    int I2 = f.I(bArr, i3, bVar);
                    int i39 = bVar.f35847a;
                    if (i39 == 0) {
                        unsafe.putObject(t16, j3, "");
                    } else {
                        if ((i26 & 536870912) != 0 && !Utf8.t(bArr, I2, I2 + i39)) {
                            throw InvalidProtocolBufferException.invalidUtf8();
                        }
                        unsafe.putObject(t16, j3, new String(bArr, I2, i39, ad.f35640a));
                        I2 += i39;
                    }
                    unsafe.putInt(t16, j16, i18);
                    return I2;
                }
                return i3;
            case 60:
                if (i19 == 2) {
                    int p16 = f.p(u(i28), bArr, i3, i16, bVar);
                    Object object = unsafe.getInt(t16, j16) == i18 ? unsafe.getObject(t16, j3) : null;
                    if (object == null) {
                        unsafe.putObject(t16, j3, bVar.f35849c);
                    } else {
                        unsafe.putObject(t16, j3, ad.j(object, bVar.f35849c));
                    }
                    unsafe.putInt(t16, j16, i18);
                    return p16;
                }
                return i3;
            case 61:
                if (i19 == 2) {
                    int b16 = f.b(bArr, i3, bVar);
                    unsafe.putObject(t16, j3, bVar.f35849c);
                    unsafe.putInt(t16, j16, i18);
                    return b16;
                }
                return i3;
            case 63:
                if (i19 == 0) {
                    int I3 = f.I(bArr, i3, bVar);
                    int i46 = bVar.f35847a;
                    ad.e s16 = s(i28);
                    if (s16 != null && !s16.isInRange(i46)) {
                        v(t16).r(i17, Long.valueOf(i46));
                    } else {
                        unsafe.putObject(t16, j3, Integer.valueOf(i46));
                        unsafe.putInt(t16, j16, i18);
                    }
                    return I3;
                }
                return i3;
            case 66:
                if (i19 == 0) {
                    int I4 = f.I(bArr, i3, bVar);
                    unsafe.putObject(t16, j3, Integer.valueOf(k.b(bVar.f35847a)));
                    unsafe.putInt(t16, j16, i18);
                    return I4;
                }
                return i3;
            case 67:
                if (i19 == 0) {
                    int L3 = f.L(bArr, i3, bVar);
                    unsafe.putObject(t16, j3, Long.valueOf(k.c(bVar.f35848b)));
                    unsafe.putInt(t16, j16, i18);
                    return L3;
                }
                return i3;
            case 68:
                if (i19 == 3) {
                    int n3 = f.n(u(i28), bArr, i3, i16, (i17 & (-8)) | 4, bVar);
                    Object object2 = unsafe.getInt(t16, j16) == i18 ? unsafe.getObject(t16, j3) : null;
                    if (object2 == null) {
                        unsafe.putObject(t16, j3, bVar.f35849c);
                    } else {
                        unsafe.putObject(t16, j3, ad.j(object2, bVar.f35849c));
                    }
                    unsafe.putInt(t16, j16, i18);
                    return n3;
                }
                return i3;
            default:
                return i3;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:121:0x01de, code lost:
    
        if (r0 != r15) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x022e, code lost:
    
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x020c, code lost:
    
        if (r0 != r15) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x022b, code lost:
    
        if (r0 != r15) goto L106;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:14:0x005c. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v12, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int d0(T t16, byte[] bArr, int i3, int i16, f.b bVar) throws IOException {
        byte b16;
        int i17;
        int f06;
        int i18;
        int i19;
        Unsafe unsafe;
        int i26;
        int i27;
        int i28;
        int i29;
        int i36;
        int L;
        ay<T> ayVar = this;
        T t17 = t16;
        byte[] bArr2 = bArr;
        int i37 = i16;
        f.b bVar2 = bVar;
        Unsafe unsafe2 = f35688s;
        int i38 = -1;
        int i39 = i3;
        int i46 = -1;
        int i47 = 0;
        while (i39 < i37) {
            int i48 = i39 + 1;
            byte b17 = bArr2[i39];
            if (b17 < 0) {
                i17 = f.H(b17, bArr2, i48, bVar2);
                b16 = bVar2.f35847a;
            } else {
                b16 = b17;
                i17 = i48;
            }
            int i49 = b16 >>> 3;
            int i56 = b16 & 7;
            if (i49 > i46) {
                f06 = ayVar.g0(i49, i47 / 3);
            } else {
                f06 = ayVar.f0(i49);
            }
            int i57 = f06;
            if (i57 == i38) {
                i18 = i49;
                i19 = i17;
                unsafe = unsafe2;
                i26 = i38;
                i27 = 0;
            } else {
                int i58 = ayVar.f35689a[i57 + 1];
                int r06 = r0(i58);
                long U = U(i58);
                if (r06 <= 17) {
                    boolean z16 = true;
                    switch (r06) {
                        case 0:
                            i36 = i57;
                            if (i56 == 1) {
                                ch.Q(t17, U, f.d(bArr2, i17));
                                i39 = i17 + 8;
                                i46 = i49;
                                i47 = i36;
                                i38 = -1;
                                break;
                            } else {
                                i18 = i49;
                                i28 = i17;
                                unsafe = unsafe2;
                                i27 = i36;
                                i26 = -1;
                                break;
                            }
                        case 1:
                            i36 = i57;
                            if (i56 == 5) {
                                ch.R(t17, U, f.l(bArr2, i17));
                                i39 = i17 + 4;
                                i46 = i49;
                                i47 = i36;
                                i38 = -1;
                                break;
                            } else {
                                i18 = i49;
                                i28 = i17;
                                unsafe = unsafe2;
                                i27 = i36;
                                i26 = -1;
                                break;
                            }
                        case 2:
                        case 3:
                            i36 = i57;
                            if (i56 == 0) {
                                L = f.L(bArr2, i17, bVar2);
                                unsafe2.putLong(t16, U, bVar2.f35848b);
                                i39 = L;
                                i46 = i49;
                                i47 = i36;
                                i38 = -1;
                                break;
                            } else {
                                i18 = i49;
                                i28 = i17;
                                unsafe = unsafe2;
                                i27 = i36;
                                i26 = -1;
                                break;
                            }
                        case 4:
                        case 11:
                            i36 = i57;
                            if (i56 == 0) {
                                i39 = f.I(bArr2, i17, bVar2);
                                unsafe2.putInt(t17, U, bVar2.f35847a);
                                i46 = i49;
                                i47 = i36;
                                i38 = -1;
                                break;
                            } else {
                                i18 = i49;
                                i28 = i17;
                                unsafe = unsafe2;
                                i27 = i36;
                                i26 = -1;
                                break;
                            }
                        case 5:
                        case 14:
                            if (i56 == 1) {
                                i36 = i57;
                                unsafe2.putLong(t16, U, f.j(bArr2, i17));
                                i39 = i17 + 8;
                                i46 = i49;
                                i47 = i36;
                                i38 = -1;
                                break;
                            } else {
                                i27 = i57;
                                i18 = i49;
                                i28 = i17;
                                unsafe = unsafe2;
                                i26 = -1;
                                break;
                            }
                        case 6:
                        case 13:
                            if (i56 == 5) {
                                unsafe2.putInt(t17, U, f.h(bArr2, i17));
                                i39 = i17 + 4;
                                i47 = i57;
                                i46 = i49;
                                i38 = -1;
                                break;
                            } else {
                                i27 = i57;
                                i18 = i49;
                                i28 = i17;
                                unsafe = unsafe2;
                                i26 = -1;
                                break;
                            }
                        case 7:
                            if (i56 == 0) {
                                int L2 = f.L(bArr2, i17, bVar2);
                                if (bVar2.f35848b == 0) {
                                    z16 = false;
                                }
                                ch.K(t17, U, z16);
                                i39 = L2;
                                i47 = i57;
                                i46 = i49;
                                i38 = -1;
                                break;
                            } else {
                                i27 = i57;
                                i18 = i49;
                                i28 = i17;
                                unsafe = unsafe2;
                                i26 = -1;
                                break;
                            }
                        case 8:
                            if (i56 == 2) {
                                if ((536870912 & i58) == 0) {
                                    i39 = f.C(bArr2, i17, bVar2);
                                } else {
                                    i39 = f.F(bArr2, i17, bVar2);
                                }
                                unsafe2.putObject(t17, U, bVar2.f35849c);
                                i47 = i57;
                                i46 = i49;
                                i38 = -1;
                                break;
                            } else {
                                i27 = i57;
                                i18 = i49;
                                i28 = i17;
                                unsafe = unsafe2;
                                i26 = -1;
                                break;
                            }
                        case 9:
                            if (i56 == 2) {
                                i39 = f.p(ayVar.u(i57), bArr2, i17, i37, bVar2);
                                Object object = unsafe2.getObject(t17, U);
                                if (object == null) {
                                    unsafe2.putObject(t17, U, bVar2.f35849c);
                                } else {
                                    unsafe2.putObject(t17, U, ad.j(object, bVar2.f35849c));
                                }
                                i47 = i57;
                                i46 = i49;
                                i38 = -1;
                                break;
                            } else {
                                i27 = i57;
                                i18 = i49;
                                i28 = i17;
                                unsafe = unsafe2;
                                i26 = -1;
                                break;
                            }
                        case 10:
                            if (i56 == 2) {
                                i39 = f.b(bArr2, i17, bVar2);
                                unsafe2.putObject(t17, U, bVar2.f35849c);
                                i47 = i57;
                                i46 = i49;
                                i38 = -1;
                                break;
                            } else {
                                i27 = i57;
                                i18 = i49;
                                i28 = i17;
                                unsafe = unsafe2;
                                i26 = -1;
                                break;
                            }
                        case 12:
                            i36 = i57;
                            if (i56 == 0) {
                                i39 = f.I(bArr2, i17, bVar2);
                                unsafe2.putInt(t17, U, bVar2.f35847a);
                                i46 = i49;
                                i47 = i36;
                                i38 = -1;
                                break;
                            } else {
                                i18 = i49;
                                i28 = i17;
                                unsafe = unsafe2;
                                i27 = i36;
                                i26 = -1;
                                break;
                            }
                        case 15:
                            i36 = i57;
                            if (i56 == 0) {
                                i39 = f.I(bArr2, i17, bVar2);
                                unsafe2.putInt(t17, U, k.b(bVar2.f35847a));
                                i46 = i49;
                                i47 = i36;
                                i38 = -1;
                                break;
                            } else {
                                i18 = i49;
                                i28 = i17;
                                unsafe = unsafe2;
                                i27 = i36;
                                i26 = -1;
                                break;
                            }
                        case 16:
                            if (i56 == 0) {
                                L = f.L(bArr2, i17, bVar2);
                                i36 = i57;
                                unsafe2.putLong(t16, U, k.c(bVar2.f35848b));
                                i39 = L;
                                i46 = i49;
                                i47 = i36;
                                i38 = -1;
                                break;
                            } else {
                                i27 = i57;
                                i18 = i49;
                                i28 = i17;
                                unsafe = unsafe2;
                                i26 = -1;
                                break;
                            }
                        default:
                            i27 = i57;
                            i18 = i49;
                            i28 = i17;
                            unsafe = unsafe2;
                            i26 = -1;
                            break;
                    }
                } else if (r06 == 27) {
                    if (i56 == 2) {
                        ad.j jVar = (ad.j) unsafe2.getObject(t17, U);
                        if (!jVar.z()) {
                            int size = jVar.size();
                            if (size == 0) {
                                i29 = 10;
                            } else {
                                i29 = size * 2;
                            }
                            jVar = jVar.b2(i29);
                            unsafe2.putObject(t17, U, jVar);
                        }
                        i39 = f.q(ayVar.u(i57), b16, bArr, i17, i16, jVar, bVar);
                        i46 = i49;
                        i47 = i57;
                        i38 = -1;
                    } else {
                        i27 = i57;
                        i18 = i49;
                        i28 = i17;
                        unsafe = unsafe2;
                        i26 = -1;
                    }
                } else {
                    i27 = i57;
                    if (r06 <= 49) {
                        i18 = i49;
                        int i59 = i17;
                        unsafe = unsafe2;
                        i26 = -1;
                        i39 = e0(t16, bArr, i17, i16, b16, i49, i56, i27, i58, r06, U, bVar);
                    } else {
                        i18 = i49;
                        i28 = i17;
                        unsafe = unsafe2;
                        i26 = -1;
                        if (r06 == 50) {
                            if (i56 == 2) {
                                i39 = a0(t16, bArr, i28, i16, i27, U, bVar);
                            }
                        } else {
                            i39 = b0(t16, bArr, i28, i16, b16, i18, i56, i58, r06, U, i27, bVar);
                        }
                    }
                    ayVar = this;
                    t17 = t16;
                    bArr2 = bArr;
                    i37 = i16;
                    bVar2 = bVar;
                    unsafe2 = unsafe;
                    i47 = i27;
                    i46 = i18;
                    i38 = i26;
                }
                i19 = i28;
            }
            i39 = f.G(b16, bArr, i19, i16, v(t16), bVar);
            ayVar = this;
            t17 = t16;
            bArr2 = bArr;
            i37 = i16;
            bVar2 = bVar;
            unsafe2 = unsafe;
            i47 = i27;
            i46 = i18;
            i38 = i26;
        }
        if (i39 == i37) {
            return i39;
        }
        throw InvalidProtocolBufferException.parseFailure();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:9:0x002f. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    private int e0(T t16, byte[] bArr, int i3, int i16, int i17, int i18, int i19, int i26, long j3, int i27, long j16, f.b bVar) throws IOException {
        int J;
        Unsafe unsafe = f35688s;
        ad.j jVar = (ad.j) unsafe.getObject(t16, j16);
        if (!jVar.z()) {
            int size = jVar.size();
            jVar = jVar.b2(size == 0 ? 10 : size * 2);
            unsafe.putObject(t16, j16, jVar);
        }
        switch (i27) {
            case 18:
            case 35:
                if (i19 == 2) {
                    return f.s(bArr, i3, jVar, bVar);
                }
                if (i19 == 1) {
                    return f.e(i17, bArr, i3, i16, jVar, bVar);
                }
                return i3;
            case 19:
            case 36:
                if (i19 == 2) {
                    return f.v(bArr, i3, jVar, bVar);
                }
                if (i19 == 5) {
                    return f.m(i17, bArr, i3, i16, jVar, bVar);
                }
                return i3;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i19 == 2) {
                    return f.z(bArr, i3, jVar, bVar);
                }
                if (i19 == 0) {
                    return f.M(i17, bArr, i3, i16, jVar, bVar);
                }
                return i3;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i19 == 2) {
                    return f.y(bArr, i3, jVar, bVar);
                }
                if (i19 == 0) {
                    return f.J(i17, bArr, i3, i16, jVar, bVar);
                }
                return i3;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i19 == 2) {
                    return f.u(bArr, i3, jVar, bVar);
                }
                if (i19 == 1) {
                    return f.k(i17, bArr, i3, i16, jVar, bVar);
                }
                return i3;
            case 24:
            case 31:
            case 41:
            case 45:
                if (i19 == 2) {
                    return f.t(bArr, i3, jVar, bVar);
                }
                if (i19 == 5) {
                    return f.i(i17, bArr, i3, i16, jVar, bVar);
                }
                return i3;
            case 25:
            case 42:
                if (i19 == 2) {
                    return f.r(bArr, i3, jVar, bVar);
                }
                if (i19 == 0) {
                    return f.a(i17, bArr, i3, i16, jVar, bVar);
                }
                return i3;
            case 26:
                if (i19 == 2) {
                    if ((j3 & 536870912) == 0) {
                        return f.D(i17, bArr, i3, i16, jVar, bVar);
                    }
                    return f.E(i17, bArr, i3, i16, jVar, bVar);
                }
                return i3;
            case 27:
                if (i19 == 2) {
                    return f.q(u(i26), i17, bArr, i3, i16, jVar, bVar);
                }
                return i3;
            case 28:
                if (i19 == 2) {
                    return f.c(i17, bArr, i3, i16, jVar, bVar);
                }
                return i3;
            case 30:
            case 44:
                if (i19 != 2) {
                    if (i19 == 0) {
                        J = f.J(i17, bArr, i3, i16, jVar, bVar);
                    }
                    return i3;
                }
                J = f.y(bArr, i3, jVar, bVar);
                GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) t16;
                cd cdVar = generatedMessageLite.unknownFields;
                if (cdVar == cd.e()) {
                    cdVar = null;
                }
                cd cdVar2 = (cd) bs.A(i18, jVar, s(i26), cdVar, this.f35703o);
                if (cdVar2 != null) {
                    generatedMessageLite.unknownFields = cdVar2;
                }
                return J;
            case 33:
            case 47:
                if (i19 == 2) {
                    return f.w(bArr, i3, jVar, bVar);
                }
                if (i19 == 0) {
                    return f.A(i17, bArr, i3, i16, jVar, bVar);
                }
                return i3;
            case 34:
            case 48:
                if (i19 == 2) {
                    return f.x(bArr, i3, jVar, bVar);
                }
                if (i19 == 0) {
                    return f.B(i17, bArr, i3, i16, jVar, bVar);
                }
                return i3;
            case 49:
                if (i19 == 3) {
                    return f.o(u(i26), i17, bArr, i3, i16, jVar, bVar);
                }
                return i3;
            default:
                return i3;
        }
    }

    private int f0(int i3) {
        if (i3 >= this.f35691c && i3 <= this.f35692d) {
            return p0(i3, 0);
        }
        return -1;
    }

    private int g0(int i3, int i16) {
        if (i3 >= this.f35691c && i3 <= this.f35692d) {
            return p0(i3, i16);
        }
        return -1;
    }

    private int h0(int i3) {
        return this.f35689a[i3 + 2];
    }

    private <E> void i0(Object obj, long j3, bn bnVar, bq<E> bqVar, t tVar) throws IOException {
        bnVar.y(this.f35702n.e(obj, j3), bqVar, tVar);
    }

    private boolean j(T t16, T t17, int i3) {
        if (B(t16, i3) == B(t17, i3)) {
            return true;
        }
        return false;
    }

    private <E> void j0(Object obj, int i3, bn bnVar, bq<E> bqVar, t tVar) throws IOException {
        bnVar.F(this.f35702n.e(obj, U(i3)), bqVar, tVar);
    }

    private static <T> boolean k(T t16, long j3) {
        return ch.r(t16, j3);
    }

    private void k0(Object obj, int i3, bn bnVar) throws IOException {
        if (A(i3)) {
            ch.U(obj, U(i3), bnVar.B());
        } else if (this.f35695g) {
            ch.U(obj, U(i3), bnVar.d());
        } else {
            ch.U(obj, U(i3), bnVar.e());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r19v0, types: [java.util.Map, java.util.Map<K, V>] */
    /* JADX WARN: Type inference failed for: r1v10, types: [int] */
    private <K, V> int l(byte[] bArr, int i3, int i16, am.b<K, V> bVar, Map<K, V> map, f.b bVar2) throws IOException {
        int i17;
        int I = f.I(bArr, i3, bVar2);
        int i18 = bVar2.f35847a;
        if (i18 >= 0 && i18 <= i16 - I) {
            int i19 = I + i18;
            Object obj = bVar.f35682b;
            Object obj2 = bVar.f35684d;
            while (I < i19) {
                int i26 = I + 1;
                byte b16 = bArr[I];
                if (b16 < 0) {
                    i17 = f.H(b16, bArr, i26, bVar2);
                    b16 = bVar2.f35847a;
                } else {
                    i17 = i26;
                }
                int i27 = b16 >>> 3;
                int i28 = b16 & 7;
                if (i27 != 1) {
                    if (i27 == 2 && i28 == bVar.f35683c.getWireType()) {
                        I = m(bArr, i17, i16, bVar.f35683c, bVar.f35684d.getClass(), bVar2);
                        obj2 = bVar2.f35849c;
                    }
                    I = f.N(b16, bArr, i17, i16, bVar2);
                } else if (i28 == bVar.f35681a.getWireType()) {
                    I = m(bArr, i17, i16, bVar.f35681a, null, bVar2);
                    obj = bVar2.f35849c;
                } else {
                    I = f.N(b16, bArr, i17, i16, bVar2);
                }
            }
            if (I == i19) {
                map.put(obj, obj2);
                return i19;
            }
            throw InvalidProtocolBufferException.parseFailure();
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    private void l0(Object obj, int i3, bn bnVar) throws IOException {
        if (A(i3)) {
            bnVar.n(this.f35702n.e(obj, U(i3)));
        } else {
            bnVar.M(this.f35702n.e(obj, U(i3)));
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0008. Please report as an issue. */
    private int m(byte[] bArr, int i3, int i16, WireFormat.FieldType fieldType, Class<?> cls, f.b bVar) throws IOException {
        boolean z16;
        switch (a.f35706a[fieldType.ordinal()]) {
            case 1:
                int L = f.L(bArr, i3, bVar);
                if (bVar.f35848b != 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                bVar.f35849c = Boolean.valueOf(z16);
                return L;
            case 2:
                return f.b(bArr, i3, bVar);
            case 3:
                bVar.f35849c = Double.valueOf(f.d(bArr, i3));
                return i3 + 8;
            case 4:
            case 5:
                bVar.f35849c = Integer.valueOf(f.h(bArr, i3));
                return i3 + 4;
            case 6:
            case 7:
                bVar.f35849c = Long.valueOf(f.j(bArr, i3));
                return i3 + 8;
            case 8:
                bVar.f35849c = Float.valueOf(f.l(bArr, i3));
                return i3 + 4;
            case 9:
            case 10:
            case 11:
                int I = f.I(bArr, i3, bVar);
                bVar.f35849c = Integer.valueOf(bVar.f35847a);
                return I;
            case 12:
            case 13:
                int L2 = f.L(bArr, i3, bVar);
                bVar.f35849c = Long.valueOf(bVar.f35848b);
                return L2;
            case 14:
                return f.p(bi.a().d(cls), bArr, i3, i16, bVar);
            case 15:
                int I2 = f.I(bArr, i3, bVar);
                bVar.f35849c = Integer.valueOf(k.b(bVar.f35847a));
                return I2;
            case 16:
                int L3 = f.L(bArr, i3, bVar);
                bVar.f35849c = Long.valueOf(k.c(bVar.f35848b));
                return L3;
            case 17:
                return f.F(bArr, i3, bVar);
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    private static Field m0(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    private static <T> double n(T t16, long j3) {
        return ch.y(t16, j3);
    }

    private void n0(T t16, int i3) {
        if (this.f35696h) {
            return;
        }
        int h06 = h0(i3);
        long j3 = h06 & 1048575;
        ch.S(t16, j3, ch.A(t16, j3) | (1 << (h06 >>> 20)));
    }

    private boolean o(T t16, T t17, int i3) {
        int s06 = s0(i3);
        long U = U(s06);
        switch (r0(s06)) {
            case 0:
                if (!j(t16, t17, i3) || Double.doubleToLongBits(ch.y(t16, U)) != Double.doubleToLongBits(ch.y(t17, U))) {
                    return false;
                }
                return true;
            case 1:
                if (!j(t16, t17, i3) || Float.floatToIntBits(ch.z(t16, U)) != Float.floatToIntBits(ch.z(t17, U))) {
                    return false;
                }
                return true;
            case 2:
                if (!j(t16, t17, i3) || ch.C(t16, U) != ch.C(t17, U)) {
                    return false;
                }
                return true;
            case 3:
                if (!j(t16, t17, i3) || ch.C(t16, U) != ch.C(t17, U)) {
                    return false;
                }
                return true;
            case 4:
                if (!j(t16, t17, i3) || ch.A(t16, U) != ch.A(t17, U)) {
                    return false;
                }
                return true;
            case 5:
                if (!j(t16, t17, i3) || ch.C(t16, U) != ch.C(t17, U)) {
                    return false;
                }
                return true;
            case 6:
                if (!j(t16, t17, i3) || ch.A(t16, U) != ch.A(t17, U)) {
                    return false;
                }
                return true;
            case 7:
                if (!j(t16, t17, i3) || ch.r(t16, U) != ch.r(t17, U)) {
                    return false;
                }
                return true;
            case 8:
                if (!j(t16, t17, i3) || !bs.L(ch.E(t16, U), ch.E(t17, U))) {
                    return false;
                }
                return true;
            case 9:
                if (!j(t16, t17, i3) || !bs.L(ch.E(t16, U), ch.E(t17, U))) {
                    return false;
                }
                return true;
            case 10:
                if (!j(t16, t17, i3) || !bs.L(ch.E(t16, U), ch.E(t17, U))) {
                    return false;
                }
                return true;
            case 11:
                if (!j(t16, t17, i3) || ch.A(t16, U) != ch.A(t17, U)) {
                    return false;
                }
                return true;
            case 12:
                if (!j(t16, t17, i3) || ch.A(t16, U) != ch.A(t17, U)) {
                    return false;
                }
                return true;
            case 13:
                if (!j(t16, t17, i3) || ch.A(t16, U) != ch.A(t17, U)) {
                    return false;
                }
                return true;
            case 14:
                if (!j(t16, t17, i3) || ch.C(t16, U) != ch.C(t17, U)) {
                    return false;
                }
                return true;
            case 15:
                if (!j(t16, t17, i3) || ch.A(t16, U) != ch.A(t17, U)) {
                    return false;
                }
                return true;
            case 16:
                if (!j(t16, t17, i3) || ch.C(t16, U) != ch.C(t17, U)) {
                    return false;
                }
                return true;
            case 17:
                if (!j(t16, t17, i3) || !bs.L(ch.E(t16, U), ch.E(t17, U))) {
                    return false;
                }
                return true;
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
                return bs.L(ch.E(t16, U), ch.E(t17, U));
            case 50:
                return bs.L(ch.E(t16, U), ch.E(t17, U));
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
                if (!G(t16, t17, i3) || !bs.L(ch.E(t16, U), ch.E(t17, U))) {
                    return false;
                }
                return true;
            default:
                return true;
        }
    }

    private void o0(T t16, int i3, int i16) {
        ch.S(t16, h0(i16) & 1048575, i3);
    }

    private final <UT, UB> UB p(Object obj, int i3, UB ub5, cb<UT, UB> cbVar) {
        int T = T(i3);
        Object E = ch.E(obj, U(s0(i3)));
        if (E == null) {
            return ub5;
        }
        ad.e s16 = s(i3);
        if (s16 == null) {
            return ub5;
        }
        return (UB) q(i3, T, this.f35705q.g(E), s16, ub5, cbVar);
    }

    private int p0(int i3, int i16) {
        int length = (this.f35689a.length / 3) - 1;
        while (i16 <= length) {
            int i17 = (length + i16) >>> 1;
            int i18 = i17 * 3;
            int T = T(i18);
            if (i3 == T) {
                return i18;
            }
            if (i3 < T) {
                length = i17 - 1;
            } else {
                i16 = i17 + 1;
            }
        }
        return -1;
    }

    private final <K, V, UT, UB> UB q(int i3, int i16, Map<K, V> map, ad.e eVar, UB ub5, cb<UT, UB> cbVar) {
        am.b<?, ?> e16 = this.f35705q.e(t(i3));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (!eVar.isInRange(((Integer) next.getValue()).intValue())) {
                if (ub5 == null) {
                    ub5 = cbVar.n();
                }
                ByteString.g newCodedBuilder = ByteString.newCodedBuilder(am.b(e16, next.getKey(), next.getValue()));
                try {
                    am.f(newCodedBuilder.b(), e16, next.getKey(), next.getValue());
                    cbVar.d(ub5, i16, newCodedBuilder.a());
                    it.remove();
                } catch (IOException e17) {
                    throw new RuntimeException(e17);
                }
            }
        }
        return ub5;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0081  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void q0(y yVar, int[] iArr, int i3, boolean z16, Object[] objArr) {
        int J;
        int J2;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        bf t16 = yVar.t();
        int i27 = 0;
        if (t16 != null) {
            i16 = yVar.w().id() + 51;
            J = (int) ch.J(t16.b());
            J2 = (int) ch.J(t16.a());
        } else {
            FieldType w3 = yVar.w();
            J = (int) ch.J(yVar.p());
            int id5 = w3.id();
            if (!z16 && !w3.isList() && !w3.isMap()) {
                int J3 = (int) ch.J(yVar.u());
                i17 = Integer.numberOfTrailingZeros(yVar.v());
                i16 = id5;
                i18 = J;
                i19 = J3;
            } else if (yVar.n() == null) {
                i17 = 0;
                i16 = id5;
                i18 = J;
                i19 = 0;
            } else {
                J2 = (int) ch.J(yVar.n());
                i16 = id5;
            }
            iArr[i3] = yVar.q();
            int i28 = i3 + 1;
            if (!yVar.x()) {
                i26 = 536870912;
            } else {
                i26 = 0;
            }
            if (yVar.z()) {
                i27 = 268435456;
            }
            iArr[i28] = (i16 << 20) | i27 | i26 | i18;
            iArr[i3 + 2] = (i17 << 20) | i19;
            Class<?> s16 = yVar.s();
            if (yVar.r() == null) {
                int i29 = (i3 / 3) * 2;
                objArr[i29] = yVar.r();
                if (s16 != null) {
                    objArr[i29 + 1] = s16;
                    return;
                } else {
                    if (yVar.o() != null) {
                        objArr[i29 + 1] = yVar.o();
                        return;
                    }
                    return;
                }
            }
            if (s16 != null) {
                objArr[((i3 / 3) * 2) + 1] = s16;
                return;
            } else {
                if (yVar.o() != null) {
                    objArr[((i3 / 3) * 2) + 1] = yVar.o();
                    return;
                }
                return;
            }
        }
        i18 = J;
        i19 = J2;
        i17 = 0;
        iArr[i3] = yVar.q();
        int i282 = i3 + 1;
        if (!yVar.x()) {
        }
        if (yVar.z()) {
        }
        iArr[i282] = (i16 << 20) | i27 | i26 | i18;
        iArr[i3 + 2] = (i17 << 20) | i19;
        Class<?> s162 = yVar.s();
        if (yVar.r() == null) {
        }
    }

    private static <T> float r(T t16, long j3) {
        return ch.z(t16, j3);
    }

    private static int r0(int i3) {
        return (i3 & TextCell.FLAG_LINEBREAK_MASK) >>> 20;
    }

    private ad.e s(int i3) {
        return (ad.e) this.f35690b[((i3 / 3) * 2) + 1];
    }

    private int s0(int i3) {
        return this.f35689a[i3 + 1];
    }

    private Object t(int i3) {
        return this.f35690b[(i3 / 3) * 2];
    }

    /* JADX WARN: Removed duplicated region for block: B:231:0x049e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void t0(T t16, Writer writer) throws IOException {
        Iterator<Map.Entry<?, Object>> it;
        Map.Entry<?, ?> entry;
        int length;
        int i3;
        Map.Entry<?, ?> entry2;
        int i16;
        if (this.f35694f) {
            z<?> c16 = this.f35704p.c(t16);
            if (!c16.A()) {
                it = c16.F();
                entry = (Map.Entry) it.next();
                length = this.f35689a.length;
                Unsafe unsafe = f35688s;
                int i17 = -1;
                i3 = 0;
                int i18 = 0;
                while (i3 < length) {
                    int s06 = s0(i3);
                    int T = T(i3);
                    int r06 = r0(s06);
                    if (!this.f35696h && r06 <= 17) {
                        int i19 = this.f35689a[i3 + 2];
                        int i26 = i19 & 1048575;
                        Map.Entry<?, ?> entry3 = entry;
                        if (i26 != i17) {
                            i18 = unsafe.getInt(t16, i26);
                            i17 = i26;
                        }
                        i16 = 1 << (i19 >>> 20);
                        entry2 = entry3;
                    } else {
                        entry2 = entry;
                        i16 = 0;
                    }
                    while (entry2 != null && this.f35704p.a(entry2) <= T) {
                        this.f35704p.j(writer, entry2);
                        if (it.hasNext()) {
                            entry2 = (Map.Entry) it.next();
                        } else {
                            entry2 = null;
                        }
                    }
                    Map.Entry<?, ?> entry4 = entry2;
                    int i27 = length;
                    long U = U(s06);
                    switch (r06) {
                        case 0:
                            if ((i16 & i18) == 0) {
                                break;
                            } else {
                                writer.g(T, n(t16, U));
                                continue;
                            }
                        case 1:
                            if ((i16 & i18) != 0) {
                                writer.d(T, r(t16, U));
                                break;
                            } else {
                                continue;
                            }
                        case 2:
                            if ((i16 & i18) != 0) {
                                writer.c(T, unsafe.getLong(t16, U));
                                break;
                            } else {
                                continue;
                            }
                        case 3:
                            if ((i16 & i18) != 0) {
                                writer.i(T, unsafe.getLong(t16, U));
                                break;
                            } else {
                                continue;
                            }
                        case 4:
                            if ((i16 & i18) != 0) {
                                writer.e(T, unsafe.getInt(t16, U));
                                break;
                            } else {
                                continue;
                            }
                        case 5:
                            if ((i16 & i18) != 0) {
                                writer.J(T, unsafe.getLong(t16, U));
                                break;
                            } else {
                                continue;
                            }
                        case 6:
                            if ((i16 & i18) != 0) {
                                writer.j(T, unsafe.getInt(t16, U));
                                break;
                            } else {
                                continue;
                            }
                        case 7:
                            if ((i16 & i18) != 0) {
                                writer.b(T, k(t16, U));
                                break;
                            } else {
                                continue;
                            }
                        case 8:
                            if ((i16 & i18) != 0) {
                                x0(T, unsafe.getObject(t16, U), writer);
                                break;
                            } else {
                                continue;
                            }
                        case 9:
                            if ((i16 & i18) != 0) {
                                writer.E(T, unsafe.getObject(t16, U), u(i3));
                                break;
                            } else {
                                continue;
                            }
                        case 10:
                            if ((i16 & i18) != 0) {
                                writer.m(T, (ByteString) unsafe.getObject(t16, U));
                                break;
                            } else {
                                continue;
                            }
                        case 11:
                            if ((i16 & i18) != 0) {
                                writer.f(T, unsafe.getInt(t16, U));
                                break;
                            } else {
                                continue;
                            }
                        case 12:
                            if ((i16 & i18) != 0) {
                                writer.h(T, unsafe.getInt(t16, U));
                                break;
                            } else {
                                continue;
                            }
                        case 13:
                            if ((i16 & i18) != 0) {
                                writer.v(T, unsafe.getInt(t16, U));
                                break;
                            } else {
                                continue;
                            }
                        case 14:
                            if ((i16 & i18) != 0) {
                                writer.P(T, unsafe.getLong(t16, U));
                                break;
                            } else {
                                continue;
                            }
                        case 15:
                            if ((i16 & i18) != 0) {
                                writer.H(T, unsafe.getInt(t16, U));
                                break;
                            } else {
                                continue;
                            }
                        case 16:
                            if ((i16 & i18) != 0) {
                                writer.n(T, unsafe.getLong(t16, U));
                                break;
                            } else {
                                continue;
                            }
                        case 17:
                            if ((i16 & i18) != 0) {
                                writer.q(T, unsafe.getObject(t16, U), u(i3));
                                break;
                            } else {
                                continue;
                            }
                        case 18:
                            bs.R(T(i3), (List) unsafe.getObject(t16, U), writer, false);
                            continue;
                        case 19:
                            bs.V(T(i3), (List) unsafe.getObject(t16, U), writer, false);
                            continue;
                        case 20:
                            bs.Z(T(i3), (List) unsafe.getObject(t16, U), writer, false);
                            continue;
                        case 21:
                            bs.i0(T(i3), (List) unsafe.getObject(t16, U), writer, false);
                            continue;
                        case 22:
                            bs.Y(T(i3), (List) unsafe.getObject(t16, U), writer, false);
                            continue;
                        case 23:
                            bs.U(T(i3), (List) unsafe.getObject(t16, U), writer, false);
                            continue;
                        case 24:
                            bs.T(T(i3), (List) unsafe.getObject(t16, U), writer, false);
                            continue;
                        case 25:
                            bs.P(T(i3), (List) unsafe.getObject(t16, U), writer, false);
                            continue;
                        case 26:
                            bs.g0(T(i3), (List) unsafe.getObject(t16, U), writer);
                            break;
                        case 27:
                            bs.b0(T(i3), (List) unsafe.getObject(t16, U), writer, u(i3));
                            break;
                        case 28:
                            bs.Q(T(i3), (List) unsafe.getObject(t16, U), writer);
                            break;
                        case 29:
                            bs.h0(T(i3), (List) unsafe.getObject(t16, U), writer, false);
                            continue;
                        case 30:
                            bs.S(T(i3), (List) unsafe.getObject(t16, U), writer, false);
                            continue;
                        case 31:
                            bs.c0(T(i3), (List) unsafe.getObject(t16, U), writer, false);
                            continue;
                        case 32:
                            bs.d0(T(i3), (List) unsafe.getObject(t16, U), writer, false);
                            continue;
                        case 33:
                            bs.e0(T(i3), (List) unsafe.getObject(t16, U), writer, false);
                            continue;
                        case 34:
                            bs.f0(T(i3), (List) unsafe.getObject(t16, U), writer, false);
                            continue;
                        case 35:
                            bs.R(T(i3), (List) unsafe.getObject(t16, U), writer, true);
                            break;
                        case 36:
                            bs.V(T(i3), (List) unsafe.getObject(t16, U), writer, true);
                            break;
                        case 37:
                            bs.Z(T(i3), (List) unsafe.getObject(t16, U), writer, true);
                            break;
                        case 38:
                            bs.i0(T(i3), (List) unsafe.getObject(t16, U), writer, true);
                            break;
                        case 39:
                            bs.Y(T(i3), (List) unsafe.getObject(t16, U), writer, true);
                            break;
                        case 40:
                            bs.U(T(i3), (List) unsafe.getObject(t16, U), writer, true);
                            break;
                        case 41:
                            bs.T(T(i3), (List) unsafe.getObject(t16, U), writer, true);
                            break;
                        case 42:
                            bs.P(T(i3), (List) unsafe.getObject(t16, U), writer, true);
                            break;
                        case 43:
                            bs.h0(T(i3), (List) unsafe.getObject(t16, U), writer, true);
                            break;
                        case 44:
                            bs.S(T(i3), (List) unsafe.getObject(t16, U), writer, true);
                            break;
                        case 45:
                            bs.c0(T(i3), (List) unsafe.getObject(t16, U), writer, true);
                            break;
                        case 46:
                            bs.d0(T(i3), (List) unsafe.getObject(t16, U), writer, true);
                            break;
                        case 47:
                            bs.e0(T(i3), (List) unsafe.getObject(t16, U), writer, true);
                            break;
                        case 48:
                            bs.f0(T(i3), (List) unsafe.getObject(t16, U), writer, true);
                            break;
                        case 49:
                            bs.X(T(i3), (List) unsafe.getObject(t16, U), writer, u(i3));
                            break;
                        case 50:
                            w0(writer, T, unsafe.getObject(t16, U), i3);
                            break;
                        case 51:
                            if (H(t16, T, i3)) {
                                writer.g(T, W(t16, U));
                                break;
                            }
                            break;
                        case 52:
                            if (H(t16, T, i3)) {
                                writer.d(T, X(t16, U));
                                break;
                            }
                            break;
                        case 53:
                            if (H(t16, T, i3)) {
                                writer.c(T, Z(t16, U));
                                break;
                            }
                            break;
                        case 54:
                            if (H(t16, T, i3)) {
                                writer.i(T, Z(t16, U));
                                break;
                            }
                            break;
                        case 55:
                            if (H(t16, T, i3)) {
                                writer.e(T, Y(t16, U));
                                break;
                            }
                            break;
                        case 56:
                            if (H(t16, T, i3)) {
                                writer.J(T, Z(t16, U));
                                break;
                            }
                            break;
                        case 57:
                            if (H(t16, T, i3)) {
                                writer.j(T, Y(t16, U));
                                break;
                            }
                            break;
                        case 58:
                            if (H(t16, T, i3)) {
                                writer.b(T, V(t16, U));
                                break;
                            }
                            break;
                        case 59:
                            if (H(t16, T, i3)) {
                                x0(T, unsafe.getObject(t16, U), writer);
                                break;
                            }
                            break;
                        case 60:
                            if (H(t16, T, i3)) {
                                writer.E(T, unsafe.getObject(t16, U), u(i3));
                                break;
                            }
                            break;
                        case 61:
                            if (H(t16, T, i3)) {
                                writer.m(T, (ByteString) unsafe.getObject(t16, U));
                                break;
                            }
                            break;
                        case 62:
                            if (H(t16, T, i3)) {
                                writer.f(T, Y(t16, U));
                                break;
                            }
                            break;
                        case 63:
                            if (H(t16, T, i3)) {
                                writer.h(T, Y(t16, U));
                                break;
                            }
                            break;
                        case 64:
                            if (H(t16, T, i3)) {
                                writer.v(T, Y(t16, U));
                                break;
                            }
                            break;
                        case 65:
                            if (H(t16, T, i3)) {
                                writer.P(T, Z(t16, U));
                                break;
                            }
                            break;
                        case 66:
                            if (H(t16, T, i3)) {
                                writer.H(T, Y(t16, U));
                                break;
                            }
                            break;
                        case 67:
                            if (H(t16, T, i3)) {
                                writer.n(T, Z(t16, U));
                                break;
                            }
                            break;
                        case 68:
                            if (H(t16, T, i3)) {
                                writer.q(T, unsafe.getObject(t16, U), u(i3));
                                break;
                            }
                            break;
                    }
                    i3 += 3;
                    length = i27;
                    entry = entry4;
                }
                while (entry != null) {
                    this.f35704p.j(writer, entry);
                    if (it.hasNext()) {
                        entry = (Map.Entry) it.next();
                    } else {
                        entry = null;
                    }
                }
                y0(this.f35703o, t16, writer);
            }
        }
        it = null;
        entry = null;
        length = this.f35689a.length;
        Unsafe unsafe2 = f35688s;
        int i172 = -1;
        i3 = 0;
        int i182 = 0;
        while (i3 < length) {
        }
        while (entry != null) {
        }
        y0(this.f35703o, t16, writer);
    }

    private bq u(int i3) {
        int i16 = (i3 / 3) * 2;
        bq bqVar = (bq) this.f35690b[i16];
        if (bqVar != null) {
            return bqVar;
        }
        bq<T> d16 = bi.a().d((Class) this.f35690b[i16 + 1]);
        this.f35690b[i16] = d16;
        return d16;
    }

    /* JADX WARN: Removed duplicated region for block: B:275:0x0588  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void u0(T t16, Writer writer) throws IOException {
        Iterator<Map.Entry<?, Object>> it;
        Map.Entry<?, ?> entry;
        int length;
        int i3;
        if (this.f35694f) {
            z<?> c16 = this.f35704p.c(t16);
            if (!c16.A()) {
                it = c16.F();
                entry = (Map.Entry) it.next();
                length = this.f35689a.length;
                for (i3 = 0; i3 < length; i3 += 3) {
                    int s06 = s0(i3);
                    int T = T(i3);
                    while (entry != null && this.f35704p.a(entry) <= T) {
                        this.f35704p.j(writer, entry);
                        if (it.hasNext()) {
                            entry = (Map.Entry) it.next();
                        } else {
                            entry = null;
                        }
                    }
                    switch (r0(s06)) {
                        case 0:
                            if (B(t16, i3)) {
                                writer.g(T, n(t16, U(s06)));
                                break;
                            } else {
                                break;
                            }
                        case 1:
                            if (B(t16, i3)) {
                                writer.d(T, r(t16, U(s06)));
                                break;
                            } else {
                                break;
                            }
                        case 2:
                            if (B(t16, i3)) {
                                writer.c(T, K(t16, U(s06)));
                                break;
                            } else {
                                break;
                            }
                        case 3:
                            if (B(t16, i3)) {
                                writer.i(T, K(t16, U(s06)));
                                break;
                            } else {
                                break;
                            }
                        case 4:
                            if (B(t16, i3)) {
                                writer.e(T, z(t16, U(s06)));
                                break;
                            } else {
                                break;
                            }
                        case 5:
                            if (B(t16, i3)) {
                                writer.J(T, K(t16, U(s06)));
                                break;
                            } else {
                                break;
                            }
                        case 6:
                            if (B(t16, i3)) {
                                writer.j(T, z(t16, U(s06)));
                                break;
                            } else {
                                break;
                            }
                        case 7:
                            if (B(t16, i3)) {
                                writer.b(T, k(t16, U(s06)));
                                break;
                            } else {
                                break;
                            }
                        case 8:
                            if (B(t16, i3)) {
                                x0(T, ch.E(t16, U(s06)), writer);
                                break;
                            } else {
                                break;
                            }
                        case 9:
                            if (B(t16, i3)) {
                                writer.E(T, ch.E(t16, U(s06)), u(i3));
                                break;
                            } else {
                                break;
                            }
                        case 10:
                            if (B(t16, i3)) {
                                writer.m(T, (ByteString) ch.E(t16, U(s06)));
                                break;
                            } else {
                                break;
                            }
                        case 11:
                            if (B(t16, i3)) {
                                writer.f(T, z(t16, U(s06)));
                                break;
                            } else {
                                break;
                            }
                        case 12:
                            if (B(t16, i3)) {
                                writer.h(T, z(t16, U(s06)));
                                break;
                            } else {
                                break;
                            }
                        case 13:
                            if (B(t16, i3)) {
                                writer.v(T, z(t16, U(s06)));
                                break;
                            } else {
                                break;
                            }
                        case 14:
                            if (B(t16, i3)) {
                                writer.P(T, K(t16, U(s06)));
                                break;
                            } else {
                                break;
                            }
                        case 15:
                            if (B(t16, i3)) {
                                writer.H(T, z(t16, U(s06)));
                                break;
                            } else {
                                break;
                            }
                        case 16:
                            if (B(t16, i3)) {
                                writer.n(T, K(t16, U(s06)));
                                break;
                            } else {
                                break;
                            }
                        case 17:
                            if (B(t16, i3)) {
                                writer.q(T, ch.E(t16, U(s06)), u(i3));
                                break;
                            } else {
                                break;
                            }
                        case 18:
                            bs.R(T(i3), (List) ch.E(t16, U(s06)), writer, false);
                            break;
                        case 19:
                            bs.V(T(i3), (List) ch.E(t16, U(s06)), writer, false);
                            break;
                        case 20:
                            bs.Z(T(i3), (List) ch.E(t16, U(s06)), writer, false);
                            break;
                        case 21:
                            bs.i0(T(i3), (List) ch.E(t16, U(s06)), writer, false);
                            break;
                        case 22:
                            bs.Y(T(i3), (List) ch.E(t16, U(s06)), writer, false);
                            break;
                        case 23:
                            bs.U(T(i3), (List) ch.E(t16, U(s06)), writer, false);
                            break;
                        case 24:
                            bs.T(T(i3), (List) ch.E(t16, U(s06)), writer, false);
                            break;
                        case 25:
                            bs.P(T(i3), (List) ch.E(t16, U(s06)), writer, false);
                            break;
                        case 26:
                            bs.g0(T(i3), (List) ch.E(t16, U(s06)), writer);
                            break;
                        case 27:
                            bs.b0(T(i3), (List) ch.E(t16, U(s06)), writer, u(i3));
                            break;
                        case 28:
                            bs.Q(T(i3), (List) ch.E(t16, U(s06)), writer);
                            break;
                        case 29:
                            bs.h0(T(i3), (List) ch.E(t16, U(s06)), writer, false);
                            break;
                        case 30:
                            bs.S(T(i3), (List) ch.E(t16, U(s06)), writer, false);
                            break;
                        case 31:
                            bs.c0(T(i3), (List) ch.E(t16, U(s06)), writer, false);
                            break;
                        case 32:
                            bs.d0(T(i3), (List) ch.E(t16, U(s06)), writer, false);
                            break;
                        case 33:
                            bs.e0(T(i3), (List) ch.E(t16, U(s06)), writer, false);
                            break;
                        case 34:
                            bs.f0(T(i3), (List) ch.E(t16, U(s06)), writer, false);
                            break;
                        case 35:
                            bs.R(T(i3), (List) ch.E(t16, U(s06)), writer, true);
                            break;
                        case 36:
                            bs.V(T(i3), (List) ch.E(t16, U(s06)), writer, true);
                            break;
                        case 37:
                            bs.Z(T(i3), (List) ch.E(t16, U(s06)), writer, true);
                            break;
                        case 38:
                            bs.i0(T(i3), (List) ch.E(t16, U(s06)), writer, true);
                            break;
                        case 39:
                            bs.Y(T(i3), (List) ch.E(t16, U(s06)), writer, true);
                            break;
                        case 40:
                            bs.U(T(i3), (List) ch.E(t16, U(s06)), writer, true);
                            break;
                        case 41:
                            bs.T(T(i3), (List) ch.E(t16, U(s06)), writer, true);
                            break;
                        case 42:
                            bs.P(T(i3), (List) ch.E(t16, U(s06)), writer, true);
                            break;
                        case 43:
                            bs.h0(T(i3), (List) ch.E(t16, U(s06)), writer, true);
                            break;
                        case 44:
                            bs.S(T(i3), (List) ch.E(t16, U(s06)), writer, true);
                            break;
                        case 45:
                            bs.c0(T(i3), (List) ch.E(t16, U(s06)), writer, true);
                            break;
                        case 46:
                            bs.d0(T(i3), (List) ch.E(t16, U(s06)), writer, true);
                            break;
                        case 47:
                            bs.e0(T(i3), (List) ch.E(t16, U(s06)), writer, true);
                            break;
                        case 48:
                            bs.f0(T(i3), (List) ch.E(t16, U(s06)), writer, true);
                            break;
                        case 49:
                            bs.X(T(i3), (List) ch.E(t16, U(s06)), writer, u(i3));
                            break;
                        case 50:
                            w0(writer, T, ch.E(t16, U(s06)), i3);
                            break;
                        case 51:
                            if (H(t16, T, i3)) {
                                writer.g(T, W(t16, U(s06)));
                                break;
                            } else {
                                break;
                            }
                        case 52:
                            if (H(t16, T, i3)) {
                                writer.d(T, X(t16, U(s06)));
                                break;
                            } else {
                                break;
                            }
                        case 53:
                            if (H(t16, T, i3)) {
                                writer.c(T, Z(t16, U(s06)));
                                break;
                            } else {
                                break;
                            }
                        case 54:
                            if (H(t16, T, i3)) {
                                writer.i(T, Z(t16, U(s06)));
                                break;
                            } else {
                                break;
                            }
                        case 55:
                            if (H(t16, T, i3)) {
                                writer.e(T, Y(t16, U(s06)));
                                break;
                            } else {
                                break;
                            }
                        case 56:
                            if (H(t16, T, i3)) {
                                writer.J(T, Z(t16, U(s06)));
                                break;
                            } else {
                                break;
                            }
                        case 57:
                            if (H(t16, T, i3)) {
                                writer.j(T, Y(t16, U(s06)));
                                break;
                            } else {
                                break;
                            }
                        case 58:
                            if (H(t16, T, i3)) {
                                writer.b(T, V(t16, U(s06)));
                                break;
                            } else {
                                break;
                            }
                        case 59:
                            if (H(t16, T, i3)) {
                                x0(T, ch.E(t16, U(s06)), writer);
                                break;
                            } else {
                                break;
                            }
                        case 60:
                            if (H(t16, T, i3)) {
                                writer.E(T, ch.E(t16, U(s06)), u(i3));
                                break;
                            } else {
                                break;
                            }
                        case 61:
                            if (H(t16, T, i3)) {
                                writer.m(T, (ByteString) ch.E(t16, U(s06)));
                                break;
                            } else {
                                break;
                            }
                        case 62:
                            if (H(t16, T, i3)) {
                                writer.f(T, Y(t16, U(s06)));
                                break;
                            } else {
                                break;
                            }
                        case 63:
                            if (H(t16, T, i3)) {
                                writer.h(T, Y(t16, U(s06)));
                                break;
                            } else {
                                break;
                            }
                        case 64:
                            if (H(t16, T, i3)) {
                                writer.v(T, Y(t16, U(s06)));
                                break;
                            } else {
                                break;
                            }
                        case 65:
                            if (H(t16, T, i3)) {
                                writer.P(T, Z(t16, U(s06)));
                                break;
                            } else {
                                break;
                            }
                        case 66:
                            if (H(t16, T, i3)) {
                                writer.H(T, Y(t16, U(s06)));
                                break;
                            } else {
                                break;
                            }
                        case 67:
                            if (H(t16, T, i3)) {
                                writer.n(T, Z(t16, U(s06)));
                                break;
                            } else {
                                break;
                            }
                        case 68:
                            if (H(t16, T, i3)) {
                                writer.q(T, ch.E(t16, U(s06)), u(i3));
                                break;
                            } else {
                                break;
                            }
                    }
                }
                while (entry != null) {
                    this.f35704p.j(writer, entry);
                    if (it.hasNext()) {
                        entry = (Map.Entry) it.next();
                    } else {
                        entry = null;
                    }
                }
                y0(this.f35703o, t16, writer);
            }
        }
        it = null;
        entry = null;
        length = this.f35689a.length;
        while (i3 < length) {
        }
        while (entry != null) {
        }
        y0(this.f35703o, t16, writer);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static cd v(Object obj) {
        GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) obj;
        cd cdVar = generatedMessageLite.unknownFields;
        if (cdVar == cd.e()) {
            cd p16 = cd.p();
            generatedMessageLite.unknownFields = p16;
            return p16;
        }
        return cdVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:275:0x058e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void v0(T t16, Writer writer) throws IOException {
        Iterator<Map.Entry<?, Object>> it;
        Map.Entry<?, ?> entry;
        int length;
        y0(this.f35703o, t16, writer);
        if (this.f35694f) {
            z<?> c16 = this.f35704p.c(t16);
            if (!c16.A()) {
                it = c16.p();
                entry = (Map.Entry) it.next();
                for (length = this.f35689a.length - 3; length >= 0; length -= 3) {
                    int s06 = s0(length);
                    int T = T(length);
                    while (entry != null && this.f35704p.a(entry) > T) {
                        this.f35704p.j(writer, entry);
                        if (it.hasNext()) {
                            entry = (Map.Entry) it.next();
                        } else {
                            entry = null;
                        }
                    }
                    switch (r0(s06)) {
                        case 0:
                            if (B(t16, length)) {
                                writer.g(T, n(t16, U(s06)));
                                break;
                            } else {
                                break;
                            }
                        case 1:
                            if (B(t16, length)) {
                                writer.d(T, r(t16, U(s06)));
                                break;
                            } else {
                                break;
                            }
                        case 2:
                            if (B(t16, length)) {
                                writer.c(T, K(t16, U(s06)));
                                break;
                            } else {
                                break;
                            }
                        case 3:
                            if (B(t16, length)) {
                                writer.i(T, K(t16, U(s06)));
                                break;
                            } else {
                                break;
                            }
                        case 4:
                            if (B(t16, length)) {
                                writer.e(T, z(t16, U(s06)));
                                break;
                            } else {
                                break;
                            }
                        case 5:
                            if (B(t16, length)) {
                                writer.J(T, K(t16, U(s06)));
                                break;
                            } else {
                                break;
                            }
                        case 6:
                            if (B(t16, length)) {
                                writer.j(T, z(t16, U(s06)));
                                break;
                            } else {
                                break;
                            }
                        case 7:
                            if (B(t16, length)) {
                                writer.b(T, k(t16, U(s06)));
                                break;
                            } else {
                                break;
                            }
                        case 8:
                            if (B(t16, length)) {
                                x0(T, ch.E(t16, U(s06)), writer);
                                break;
                            } else {
                                break;
                            }
                        case 9:
                            if (B(t16, length)) {
                                writer.E(T, ch.E(t16, U(s06)), u(length));
                                break;
                            } else {
                                break;
                            }
                        case 10:
                            if (B(t16, length)) {
                                writer.m(T, (ByteString) ch.E(t16, U(s06)));
                                break;
                            } else {
                                break;
                            }
                        case 11:
                            if (B(t16, length)) {
                                writer.f(T, z(t16, U(s06)));
                                break;
                            } else {
                                break;
                            }
                        case 12:
                            if (B(t16, length)) {
                                writer.h(T, z(t16, U(s06)));
                                break;
                            } else {
                                break;
                            }
                        case 13:
                            if (B(t16, length)) {
                                writer.v(T, z(t16, U(s06)));
                                break;
                            } else {
                                break;
                            }
                        case 14:
                            if (B(t16, length)) {
                                writer.P(T, K(t16, U(s06)));
                                break;
                            } else {
                                break;
                            }
                        case 15:
                            if (B(t16, length)) {
                                writer.H(T, z(t16, U(s06)));
                                break;
                            } else {
                                break;
                            }
                        case 16:
                            if (B(t16, length)) {
                                writer.n(T, K(t16, U(s06)));
                                break;
                            } else {
                                break;
                            }
                        case 17:
                            if (B(t16, length)) {
                                writer.q(T, ch.E(t16, U(s06)), u(length));
                                break;
                            } else {
                                break;
                            }
                        case 18:
                            bs.R(T(length), (List) ch.E(t16, U(s06)), writer, false);
                            break;
                        case 19:
                            bs.V(T(length), (List) ch.E(t16, U(s06)), writer, false);
                            break;
                        case 20:
                            bs.Z(T(length), (List) ch.E(t16, U(s06)), writer, false);
                            break;
                        case 21:
                            bs.i0(T(length), (List) ch.E(t16, U(s06)), writer, false);
                            break;
                        case 22:
                            bs.Y(T(length), (List) ch.E(t16, U(s06)), writer, false);
                            break;
                        case 23:
                            bs.U(T(length), (List) ch.E(t16, U(s06)), writer, false);
                            break;
                        case 24:
                            bs.T(T(length), (List) ch.E(t16, U(s06)), writer, false);
                            break;
                        case 25:
                            bs.P(T(length), (List) ch.E(t16, U(s06)), writer, false);
                            break;
                        case 26:
                            bs.g0(T(length), (List) ch.E(t16, U(s06)), writer);
                            break;
                        case 27:
                            bs.b0(T(length), (List) ch.E(t16, U(s06)), writer, u(length));
                            break;
                        case 28:
                            bs.Q(T(length), (List) ch.E(t16, U(s06)), writer);
                            break;
                        case 29:
                            bs.h0(T(length), (List) ch.E(t16, U(s06)), writer, false);
                            break;
                        case 30:
                            bs.S(T(length), (List) ch.E(t16, U(s06)), writer, false);
                            break;
                        case 31:
                            bs.c0(T(length), (List) ch.E(t16, U(s06)), writer, false);
                            break;
                        case 32:
                            bs.d0(T(length), (List) ch.E(t16, U(s06)), writer, false);
                            break;
                        case 33:
                            bs.e0(T(length), (List) ch.E(t16, U(s06)), writer, false);
                            break;
                        case 34:
                            bs.f0(T(length), (List) ch.E(t16, U(s06)), writer, false);
                            break;
                        case 35:
                            bs.R(T(length), (List) ch.E(t16, U(s06)), writer, true);
                            break;
                        case 36:
                            bs.V(T(length), (List) ch.E(t16, U(s06)), writer, true);
                            break;
                        case 37:
                            bs.Z(T(length), (List) ch.E(t16, U(s06)), writer, true);
                            break;
                        case 38:
                            bs.i0(T(length), (List) ch.E(t16, U(s06)), writer, true);
                            break;
                        case 39:
                            bs.Y(T(length), (List) ch.E(t16, U(s06)), writer, true);
                            break;
                        case 40:
                            bs.U(T(length), (List) ch.E(t16, U(s06)), writer, true);
                            break;
                        case 41:
                            bs.T(T(length), (List) ch.E(t16, U(s06)), writer, true);
                            break;
                        case 42:
                            bs.P(T(length), (List) ch.E(t16, U(s06)), writer, true);
                            break;
                        case 43:
                            bs.h0(T(length), (List) ch.E(t16, U(s06)), writer, true);
                            break;
                        case 44:
                            bs.S(T(length), (List) ch.E(t16, U(s06)), writer, true);
                            break;
                        case 45:
                            bs.c0(T(length), (List) ch.E(t16, U(s06)), writer, true);
                            break;
                        case 46:
                            bs.d0(T(length), (List) ch.E(t16, U(s06)), writer, true);
                            break;
                        case 47:
                            bs.e0(T(length), (List) ch.E(t16, U(s06)), writer, true);
                            break;
                        case 48:
                            bs.f0(T(length), (List) ch.E(t16, U(s06)), writer, true);
                            break;
                        case 49:
                            bs.X(T(length), (List) ch.E(t16, U(s06)), writer, u(length));
                            break;
                        case 50:
                            w0(writer, T, ch.E(t16, U(s06)), length);
                            break;
                        case 51:
                            if (H(t16, T, length)) {
                                writer.g(T, W(t16, U(s06)));
                                break;
                            } else {
                                break;
                            }
                        case 52:
                            if (H(t16, T, length)) {
                                writer.d(T, X(t16, U(s06)));
                                break;
                            } else {
                                break;
                            }
                        case 53:
                            if (H(t16, T, length)) {
                                writer.c(T, Z(t16, U(s06)));
                                break;
                            } else {
                                break;
                            }
                        case 54:
                            if (H(t16, T, length)) {
                                writer.i(T, Z(t16, U(s06)));
                                break;
                            } else {
                                break;
                            }
                        case 55:
                            if (H(t16, T, length)) {
                                writer.e(T, Y(t16, U(s06)));
                                break;
                            } else {
                                break;
                            }
                        case 56:
                            if (H(t16, T, length)) {
                                writer.J(T, Z(t16, U(s06)));
                                break;
                            } else {
                                break;
                            }
                        case 57:
                            if (H(t16, T, length)) {
                                writer.j(T, Y(t16, U(s06)));
                                break;
                            } else {
                                break;
                            }
                        case 58:
                            if (H(t16, T, length)) {
                                writer.b(T, V(t16, U(s06)));
                                break;
                            } else {
                                break;
                            }
                        case 59:
                            if (H(t16, T, length)) {
                                x0(T, ch.E(t16, U(s06)), writer);
                                break;
                            } else {
                                break;
                            }
                        case 60:
                            if (H(t16, T, length)) {
                                writer.E(T, ch.E(t16, U(s06)), u(length));
                                break;
                            } else {
                                break;
                            }
                        case 61:
                            if (H(t16, T, length)) {
                                writer.m(T, (ByteString) ch.E(t16, U(s06)));
                                break;
                            } else {
                                break;
                            }
                        case 62:
                            if (H(t16, T, length)) {
                                writer.f(T, Y(t16, U(s06)));
                                break;
                            } else {
                                break;
                            }
                        case 63:
                            if (H(t16, T, length)) {
                                writer.h(T, Y(t16, U(s06)));
                                break;
                            } else {
                                break;
                            }
                        case 64:
                            if (H(t16, T, length)) {
                                writer.v(T, Y(t16, U(s06)));
                                break;
                            } else {
                                break;
                            }
                        case 65:
                            if (H(t16, T, length)) {
                                writer.P(T, Z(t16, U(s06)));
                                break;
                            } else {
                                break;
                            }
                        case 66:
                            if (H(t16, T, length)) {
                                writer.H(T, Y(t16, U(s06)));
                                break;
                            } else {
                                break;
                            }
                        case 67:
                            if (H(t16, T, length)) {
                                writer.n(T, Z(t16, U(s06)));
                                break;
                            } else {
                                break;
                            }
                        case 68:
                            if (H(t16, T, length)) {
                                writer.q(T, ch.E(t16, U(s06)), u(length));
                                break;
                            } else {
                                break;
                            }
                    }
                }
                while (entry != null) {
                    this.f35704p.j(writer, entry);
                    if (it.hasNext()) {
                        entry = (Map.Entry) it.next();
                    } else {
                        entry = null;
                    }
                }
            }
        }
        it = null;
        entry = null;
        while (length >= 0) {
        }
        while (entry != null) {
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:11:0x0060. Please report as an issue. */
    private int w(T t16) {
        int i3;
        int i16;
        int j3;
        int e16;
        int N;
        boolean z16;
        int f16;
        int i17;
        int X;
        int Z;
        Unsafe unsafe = f35688s;
        int i18 = -1;
        int i19 = 0;
        int i26 = 0;
        int i27 = 0;
        while (i19 < this.f35689a.length) {
            int s06 = s0(i19);
            int T = T(i19);
            int r06 = r0(s06);
            if (r06 <= 17) {
                i3 = this.f35689a[i19 + 2];
                int i28 = 1048575 & i3;
                int i29 = 1 << (i3 >>> 20);
                if (i28 != i18) {
                    i27 = unsafe.getInt(t16, i28);
                    i18 = i28;
                }
                i16 = i29;
            } else {
                if (this.f35697i && r06 >= FieldType.DOUBLE_LIST_PACKED.id() && r06 <= FieldType.SINT64_LIST_PACKED.id()) {
                    i3 = this.f35689a[i19 + 2] & 1048575;
                } else {
                    i3 = 0;
                }
                i16 = 0;
            }
            long U = U(s06);
            int i36 = i18;
            switch (r06) {
                case 0:
                    if ((i27 & i16) == 0) {
                        break;
                    } else {
                        j3 = CodedOutputStream.j(T, 0.0d);
                        i26 += j3;
                        break;
                    }
                case 1:
                    if ((i27 & i16) == 0) {
                        break;
                    } else {
                        j3 = CodedOutputStream.r(T, 0.0f);
                        i26 += j3;
                        break;
                    }
                case 2:
                    if ((i27 & i16) == 0) {
                        break;
                    } else {
                        j3 = CodedOutputStream.z(T, unsafe.getLong(t16, U));
                        i26 += j3;
                        break;
                    }
                case 3:
                    if ((i27 & i16) == 0) {
                        break;
                    } else {
                        j3 = CodedOutputStream.a0(T, unsafe.getLong(t16, U));
                        i26 += j3;
                        break;
                    }
                case 4:
                    if ((i27 & i16) == 0) {
                        break;
                    } else {
                        j3 = CodedOutputStream.x(T, unsafe.getInt(t16, U));
                        i26 += j3;
                        break;
                    }
                case 5:
                    if ((i27 & i16) == 0) {
                        break;
                    } else {
                        j3 = CodedOutputStream.p(T, 0L);
                        i26 += j3;
                        break;
                    }
                case 6:
                    if ((i27 & i16) != 0) {
                        j3 = CodedOutputStream.n(T, 0);
                        i26 += j3;
                        break;
                    }
                    break;
                case 7:
                    if ((i27 & i16) != 0) {
                        e16 = CodedOutputStream.e(T, true);
                        i26 += e16;
                    }
                    break;
                case 8:
                    if ((i27 & i16) != 0) {
                        Object object = unsafe.getObject(t16, U);
                        if (object instanceof ByteString) {
                            e16 = CodedOutputStream.h(T, (ByteString) object);
                        } else {
                            e16 = CodedOutputStream.V(T, (String) object);
                        }
                        i26 += e16;
                    }
                    break;
                case 9:
                    if ((i27 & i16) != 0) {
                        e16 = bs.o(T, unsafe.getObject(t16, U), u(i19));
                        i26 += e16;
                    }
                    break;
                case 10:
                    if ((i27 & i16) != 0) {
                        e16 = CodedOutputStream.h(T, (ByteString) unsafe.getObject(t16, U));
                        i26 += e16;
                    }
                    break;
                case 11:
                    if ((i27 & i16) != 0) {
                        e16 = CodedOutputStream.Y(T, unsafe.getInt(t16, U));
                        i26 += e16;
                    }
                    break;
                case 12:
                    if ((i27 & i16) != 0) {
                        e16 = CodedOutputStream.l(T, unsafe.getInt(t16, U));
                        i26 += e16;
                    }
                    break;
                case 13:
                    if ((i27 & i16) != 0) {
                        N = CodedOutputStream.N(T, 0);
                        i26 += N;
                    }
                    break;
                case 14:
                    if ((i27 & i16) != 0) {
                        e16 = CodedOutputStream.P(T, 0L);
                        i26 += e16;
                    }
                    break;
                case 15:
                    if ((i27 & i16) != 0) {
                        e16 = CodedOutputStream.R(T, unsafe.getInt(t16, U));
                        i26 += e16;
                    }
                    break;
                case 16:
                    if ((i27 & i16) != 0) {
                        e16 = CodedOutputStream.T(T, unsafe.getLong(t16, U));
                        i26 += e16;
                    }
                    break;
                case 17:
                    if ((i27 & i16) != 0) {
                        e16 = CodedOutputStream.u(T, (au) unsafe.getObject(t16, U), u(i19));
                        i26 += e16;
                    }
                    break;
                case 18:
                    e16 = bs.h(T, (List) unsafe.getObject(t16, U), false);
                    i26 += e16;
                    break;
                case 19:
                    z16 = false;
                    f16 = bs.f(T, (List) unsafe.getObject(t16, U), false);
                    i26 += f16;
                    break;
                case 20:
                    z16 = false;
                    f16 = bs.m(T, (List) unsafe.getObject(t16, U), false);
                    i26 += f16;
                    break;
                case 21:
                    z16 = false;
                    f16 = bs.x(T, (List) unsafe.getObject(t16, U), false);
                    i26 += f16;
                    break;
                case 22:
                    z16 = false;
                    f16 = bs.k(T, (List) unsafe.getObject(t16, U), false);
                    i26 += f16;
                    break;
                case 23:
                    z16 = false;
                    f16 = bs.h(T, (List) unsafe.getObject(t16, U), false);
                    i26 += f16;
                    break;
                case 24:
                    z16 = false;
                    f16 = bs.f(T, (List) unsafe.getObject(t16, U), false);
                    i26 += f16;
                    break;
                case 25:
                    z16 = false;
                    f16 = bs.a(T, (List) unsafe.getObject(t16, U), false);
                    i26 += f16;
                    break;
                case 26:
                    e16 = bs.u(T, (List) unsafe.getObject(t16, U));
                    i26 += e16;
                    break;
                case 27:
                    e16 = bs.p(T, (List) unsafe.getObject(t16, U), u(i19));
                    i26 += e16;
                    break;
                case 28:
                    e16 = bs.c(T, (List) unsafe.getObject(t16, U));
                    i26 += e16;
                    break;
                case 29:
                    e16 = bs.v(T, (List) unsafe.getObject(t16, U), false);
                    i26 += e16;
                    break;
                case 30:
                    z16 = false;
                    f16 = bs.d(T, (List) unsafe.getObject(t16, U), false);
                    i26 += f16;
                    break;
                case 31:
                    z16 = false;
                    f16 = bs.f(T, (List) unsafe.getObject(t16, U), false);
                    i26 += f16;
                    break;
                case 32:
                    z16 = false;
                    f16 = bs.h(T, (List) unsafe.getObject(t16, U), false);
                    i26 += f16;
                    break;
                case 33:
                    z16 = false;
                    f16 = bs.q(T, (List) unsafe.getObject(t16, U), false);
                    i26 += f16;
                    break;
                case 34:
                    z16 = false;
                    f16 = bs.s(T, (List) unsafe.getObject(t16, U), false);
                    i26 += f16;
                    break;
                case 35:
                    i17 = bs.i((List) unsafe.getObject(t16, U));
                    if (i17 > 0) {
                        if (this.f35697i) {
                            unsafe.putInt(t16, i3, i17);
                        }
                        X = CodedOutputStream.X(T);
                        Z = CodedOutputStream.Z(i17);
                        N = X + Z + i17;
                        i26 += N;
                    }
                    break;
                case 36:
                    i17 = bs.g((List) unsafe.getObject(t16, U));
                    if (i17 > 0) {
                        if (this.f35697i) {
                            unsafe.putInt(t16, i3, i17);
                        }
                        X = CodedOutputStream.X(T);
                        Z = CodedOutputStream.Z(i17);
                        N = X + Z + i17;
                        i26 += N;
                    }
                    break;
                case 37:
                    i17 = bs.n((List) unsafe.getObject(t16, U));
                    if (i17 > 0) {
                        if (this.f35697i) {
                            unsafe.putInt(t16, i3, i17);
                        }
                        X = CodedOutputStream.X(T);
                        Z = CodedOutputStream.Z(i17);
                        N = X + Z + i17;
                        i26 += N;
                    }
                    break;
                case 38:
                    i17 = bs.y((List) unsafe.getObject(t16, U));
                    if (i17 > 0) {
                        if (this.f35697i) {
                            unsafe.putInt(t16, i3, i17);
                        }
                        X = CodedOutputStream.X(T);
                        Z = CodedOutputStream.Z(i17);
                        N = X + Z + i17;
                        i26 += N;
                    }
                    break;
                case 39:
                    i17 = bs.l((List) unsafe.getObject(t16, U));
                    if (i17 > 0) {
                        if (this.f35697i) {
                            unsafe.putInt(t16, i3, i17);
                        }
                        X = CodedOutputStream.X(T);
                        Z = CodedOutputStream.Z(i17);
                        N = X + Z + i17;
                        i26 += N;
                    }
                    break;
                case 40:
                    i17 = bs.i((List) unsafe.getObject(t16, U));
                    if (i17 > 0) {
                        if (this.f35697i) {
                            unsafe.putInt(t16, i3, i17);
                        }
                        X = CodedOutputStream.X(T);
                        Z = CodedOutputStream.Z(i17);
                        N = X + Z + i17;
                        i26 += N;
                    }
                    break;
                case 41:
                    i17 = bs.g((List) unsafe.getObject(t16, U));
                    if (i17 > 0) {
                        if (this.f35697i) {
                            unsafe.putInt(t16, i3, i17);
                        }
                        X = CodedOutputStream.X(T);
                        Z = CodedOutputStream.Z(i17);
                        N = X + Z + i17;
                        i26 += N;
                    }
                    break;
                case 42:
                    i17 = bs.b((List) unsafe.getObject(t16, U));
                    if (i17 > 0) {
                        if (this.f35697i) {
                            unsafe.putInt(t16, i3, i17);
                        }
                        X = CodedOutputStream.X(T);
                        Z = CodedOutputStream.Z(i17);
                        N = X + Z + i17;
                        i26 += N;
                    }
                    break;
                case 43:
                    i17 = bs.w((List) unsafe.getObject(t16, U));
                    if (i17 > 0) {
                        if (this.f35697i) {
                            unsafe.putInt(t16, i3, i17);
                        }
                        X = CodedOutputStream.X(T);
                        Z = CodedOutputStream.Z(i17);
                        N = X + Z + i17;
                        i26 += N;
                    }
                    break;
                case 44:
                    i17 = bs.e((List) unsafe.getObject(t16, U));
                    if (i17 > 0) {
                        if (this.f35697i) {
                            unsafe.putInt(t16, i3, i17);
                        }
                        X = CodedOutputStream.X(T);
                        Z = CodedOutputStream.Z(i17);
                        N = X + Z + i17;
                        i26 += N;
                    }
                    break;
                case 45:
                    i17 = bs.g((List) unsafe.getObject(t16, U));
                    if (i17 > 0) {
                        if (this.f35697i) {
                            unsafe.putInt(t16, i3, i17);
                        }
                        X = CodedOutputStream.X(T);
                        Z = CodedOutputStream.Z(i17);
                        N = X + Z + i17;
                        i26 += N;
                    }
                    break;
                case 46:
                    i17 = bs.i((List) unsafe.getObject(t16, U));
                    if (i17 > 0) {
                        if (this.f35697i) {
                            unsafe.putInt(t16, i3, i17);
                        }
                        X = CodedOutputStream.X(T);
                        Z = CodedOutputStream.Z(i17);
                        N = X + Z + i17;
                        i26 += N;
                    }
                    break;
                case 47:
                    i17 = bs.r((List) unsafe.getObject(t16, U));
                    if (i17 > 0) {
                        if (this.f35697i) {
                            unsafe.putInt(t16, i3, i17);
                        }
                        X = CodedOutputStream.X(T);
                        Z = CodedOutputStream.Z(i17);
                        N = X + Z + i17;
                        i26 += N;
                    }
                    break;
                case 48:
                    i17 = bs.t((List) unsafe.getObject(t16, U));
                    if (i17 > 0) {
                        if (this.f35697i) {
                            unsafe.putInt(t16, i3, i17);
                        }
                        X = CodedOutputStream.X(T);
                        Z = CodedOutputStream.Z(i17);
                        N = X + Z + i17;
                        i26 += N;
                    }
                    break;
                case 49:
                    e16 = bs.j(T, (List) unsafe.getObject(t16, U), u(i19));
                    i26 += e16;
                    break;
                case 50:
                    e16 = this.f35705q.c(T, unsafe.getObject(t16, U), t(i19));
                    i26 += e16;
                    break;
                case 51:
                    if (H(t16, T, i19)) {
                        e16 = CodedOutputStream.j(T, 0.0d);
                        i26 += e16;
                    }
                    break;
                case 52:
                    if (H(t16, T, i19)) {
                        e16 = CodedOutputStream.r(T, 0.0f);
                        i26 += e16;
                    }
                    break;
                case 53:
                    if (H(t16, T, i19)) {
                        e16 = CodedOutputStream.z(T, Z(t16, U));
                        i26 += e16;
                    }
                    break;
                case 54:
                    if (H(t16, T, i19)) {
                        e16 = CodedOutputStream.a0(T, Z(t16, U));
                        i26 += e16;
                    }
                    break;
                case 55:
                    if (H(t16, T, i19)) {
                        e16 = CodedOutputStream.x(T, Y(t16, U));
                        i26 += e16;
                    }
                    break;
                case 56:
                    if (H(t16, T, i19)) {
                        e16 = CodedOutputStream.p(T, 0L);
                        i26 += e16;
                    }
                    break;
                case 57:
                    if (H(t16, T, i19)) {
                        N = CodedOutputStream.n(T, 0);
                        i26 += N;
                    }
                    break;
                case 58:
                    if (H(t16, T, i19)) {
                        e16 = CodedOutputStream.e(T, true);
                        i26 += e16;
                    }
                    break;
                case 59:
                    if (H(t16, T, i19)) {
                        Object object2 = unsafe.getObject(t16, U);
                        if (object2 instanceof ByteString) {
                            e16 = CodedOutputStream.h(T, (ByteString) object2);
                        } else {
                            e16 = CodedOutputStream.V(T, (String) object2);
                        }
                        i26 += e16;
                    }
                    break;
                case 60:
                    if (H(t16, T, i19)) {
                        e16 = bs.o(T, unsafe.getObject(t16, U), u(i19));
                        i26 += e16;
                    }
                    break;
                case 61:
                    if (H(t16, T, i19)) {
                        e16 = CodedOutputStream.h(T, (ByteString) unsafe.getObject(t16, U));
                        i26 += e16;
                    }
                    break;
                case 62:
                    if (H(t16, T, i19)) {
                        e16 = CodedOutputStream.Y(T, Y(t16, U));
                        i26 += e16;
                    }
                    break;
                case 63:
                    if (H(t16, T, i19)) {
                        e16 = CodedOutputStream.l(T, Y(t16, U));
                        i26 += e16;
                    }
                    break;
                case 64:
                    if (H(t16, T, i19)) {
                        N = CodedOutputStream.N(T, 0);
                        i26 += N;
                    }
                    break;
                case 65:
                    if (H(t16, T, i19)) {
                        e16 = CodedOutputStream.P(T, 0L);
                        i26 += e16;
                    }
                    break;
                case 66:
                    if (H(t16, T, i19)) {
                        e16 = CodedOutputStream.R(T, Y(t16, U));
                        i26 += e16;
                    }
                    break;
                case 67:
                    if (H(t16, T, i19)) {
                        e16 = CodedOutputStream.T(T, Z(t16, U));
                        i26 += e16;
                    }
                    break;
                case 68:
                    if (H(t16, T, i19)) {
                        e16 = CodedOutputStream.u(T, (au) unsafe.getObject(t16, U), u(i19));
                        i26 += e16;
                    }
                    break;
            }
            i19 += 3;
            i18 = i36;
        }
        int y16 = i26 + y(this.f35703o, t16);
        if (this.f35694f) {
            return y16 + this.f35704p.c(t16).x();
        }
        return y16;
    }

    private <K, V> void w0(Writer writer, int i3, Object obj, int i16) throws IOException {
        if (obj != null) {
            writer.w(i3, this.f35705q.e(t(i16)), this.f35705q.h(obj));
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x003d. Please report as an issue. */
    private int x(T t16) {
        int i3;
        int j3;
        int i16;
        int X;
        int Z;
        Unsafe unsafe = f35688s;
        int i17 = 0;
        for (int i18 = 0; i18 < this.f35689a.length; i18 += 3) {
            int s06 = s0(i18);
            int r06 = r0(s06);
            int T = T(i18);
            long U = U(s06);
            if (r06 >= FieldType.DOUBLE_LIST_PACKED.id() && r06 <= FieldType.SINT64_LIST_PACKED.id()) {
                i3 = this.f35689a[i18 + 2] & 1048575;
            } else {
                i3 = 0;
            }
            switch (r06) {
                case 0:
                    if (B(t16, i18)) {
                        j3 = CodedOutputStream.j(T, 0.0d);
                        i17 += j3;
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (B(t16, i18)) {
                        j3 = CodedOutputStream.r(T, 0.0f);
                        i17 += j3;
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (B(t16, i18)) {
                        j3 = CodedOutputStream.z(T, ch.C(t16, U));
                        i17 += j3;
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (B(t16, i18)) {
                        j3 = CodedOutputStream.a0(T, ch.C(t16, U));
                        i17 += j3;
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (B(t16, i18)) {
                        j3 = CodedOutputStream.x(T, ch.A(t16, U));
                        i17 += j3;
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (B(t16, i18)) {
                        j3 = CodedOutputStream.p(T, 0L);
                        i17 += j3;
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (B(t16, i18)) {
                        j3 = CodedOutputStream.n(T, 0);
                        i17 += j3;
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (B(t16, i18)) {
                        j3 = CodedOutputStream.e(T, true);
                        i17 += j3;
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (B(t16, i18)) {
                        Object E = ch.E(t16, U);
                        if (E instanceof ByteString) {
                            j3 = CodedOutputStream.h(T, (ByteString) E);
                        } else {
                            j3 = CodedOutputStream.V(T, (String) E);
                        }
                        i17 += j3;
                        break;
                    } else {
                        break;
                    }
                case 9:
                    if (B(t16, i18)) {
                        j3 = bs.o(T, ch.E(t16, U), u(i18));
                        i17 += j3;
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if (B(t16, i18)) {
                        j3 = CodedOutputStream.h(T, (ByteString) ch.E(t16, U));
                        i17 += j3;
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (B(t16, i18)) {
                        j3 = CodedOutputStream.Y(T, ch.A(t16, U));
                        i17 += j3;
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (B(t16, i18)) {
                        j3 = CodedOutputStream.l(T, ch.A(t16, U));
                        i17 += j3;
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (B(t16, i18)) {
                        j3 = CodedOutputStream.N(T, 0);
                        i17 += j3;
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (B(t16, i18)) {
                        j3 = CodedOutputStream.P(T, 0L);
                        i17 += j3;
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (B(t16, i18)) {
                        j3 = CodedOutputStream.R(T, ch.A(t16, U));
                        i17 += j3;
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (B(t16, i18)) {
                        j3 = CodedOutputStream.T(T, ch.C(t16, U));
                        i17 += j3;
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if (B(t16, i18)) {
                        j3 = CodedOutputStream.u(T, (au) ch.E(t16, U), u(i18));
                        i17 += j3;
                        break;
                    } else {
                        break;
                    }
                case 18:
                    j3 = bs.h(T, J(t16, U), false);
                    i17 += j3;
                    break;
                case 19:
                    j3 = bs.f(T, J(t16, U), false);
                    i17 += j3;
                    break;
                case 20:
                    j3 = bs.m(T, J(t16, U), false);
                    i17 += j3;
                    break;
                case 21:
                    j3 = bs.x(T, J(t16, U), false);
                    i17 += j3;
                    break;
                case 22:
                    j3 = bs.k(T, J(t16, U), false);
                    i17 += j3;
                    break;
                case 23:
                    j3 = bs.h(T, J(t16, U), false);
                    i17 += j3;
                    break;
                case 24:
                    j3 = bs.f(T, J(t16, U), false);
                    i17 += j3;
                    break;
                case 25:
                    j3 = bs.a(T, J(t16, U), false);
                    i17 += j3;
                    break;
                case 26:
                    j3 = bs.u(T, J(t16, U));
                    i17 += j3;
                    break;
                case 27:
                    j3 = bs.p(T, J(t16, U), u(i18));
                    i17 += j3;
                    break;
                case 28:
                    j3 = bs.c(T, J(t16, U));
                    i17 += j3;
                    break;
                case 29:
                    j3 = bs.v(T, J(t16, U), false);
                    i17 += j3;
                    break;
                case 30:
                    j3 = bs.d(T, J(t16, U), false);
                    i17 += j3;
                    break;
                case 31:
                    j3 = bs.f(T, J(t16, U), false);
                    i17 += j3;
                    break;
                case 32:
                    j3 = bs.h(T, J(t16, U), false);
                    i17 += j3;
                    break;
                case 33:
                    j3 = bs.q(T, J(t16, U), false);
                    i17 += j3;
                    break;
                case 34:
                    j3 = bs.s(T, J(t16, U), false);
                    i17 += j3;
                    break;
                case 35:
                    i16 = bs.i((List) unsafe.getObject(t16, U));
                    if (i16 <= 0) {
                        break;
                    } else {
                        if (this.f35697i) {
                            unsafe.putInt(t16, i3, i16);
                        }
                        X = CodedOutputStream.X(T);
                        Z = CodedOutputStream.Z(i16);
                        j3 = X + Z + i16;
                        i17 += j3;
                        break;
                    }
                case 36:
                    i16 = bs.g((List) unsafe.getObject(t16, U));
                    if (i16 <= 0) {
                        break;
                    } else {
                        if (this.f35697i) {
                            unsafe.putInt(t16, i3, i16);
                        }
                        X = CodedOutputStream.X(T);
                        Z = CodedOutputStream.Z(i16);
                        j3 = X + Z + i16;
                        i17 += j3;
                        break;
                    }
                case 37:
                    i16 = bs.n((List) unsafe.getObject(t16, U));
                    if (i16 <= 0) {
                        break;
                    } else {
                        if (this.f35697i) {
                            unsafe.putInt(t16, i3, i16);
                        }
                        X = CodedOutputStream.X(T);
                        Z = CodedOutputStream.Z(i16);
                        j3 = X + Z + i16;
                        i17 += j3;
                        break;
                    }
                case 38:
                    i16 = bs.y((List) unsafe.getObject(t16, U));
                    if (i16 <= 0) {
                        break;
                    } else {
                        if (this.f35697i) {
                            unsafe.putInt(t16, i3, i16);
                        }
                        X = CodedOutputStream.X(T);
                        Z = CodedOutputStream.Z(i16);
                        j3 = X + Z + i16;
                        i17 += j3;
                        break;
                    }
                case 39:
                    i16 = bs.l((List) unsafe.getObject(t16, U));
                    if (i16 <= 0) {
                        break;
                    } else {
                        if (this.f35697i) {
                            unsafe.putInt(t16, i3, i16);
                        }
                        X = CodedOutputStream.X(T);
                        Z = CodedOutputStream.Z(i16);
                        j3 = X + Z + i16;
                        i17 += j3;
                        break;
                    }
                case 40:
                    i16 = bs.i((List) unsafe.getObject(t16, U));
                    if (i16 <= 0) {
                        break;
                    } else {
                        if (this.f35697i) {
                            unsafe.putInt(t16, i3, i16);
                        }
                        X = CodedOutputStream.X(T);
                        Z = CodedOutputStream.Z(i16);
                        j3 = X + Z + i16;
                        i17 += j3;
                        break;
                    }
                case 41:
                    i16 = bs.g((List) unsafe.getObject(t16, U));
                    if (i16 <= 0) {
                        break;
                    } else {
                        if (this.f35697i) {
                            unsafe.putInt(t16, i3, i16);
                        }
                        X = CodedOutputStream.X(T);
                        Z = CodedOutputStream.Z(i16);
                        j3 = X + Z + i16;
                        i17 += j3;
                        break;
                    }
                case 42:
                    i16 = bs.b((List) unsafe.getObject(t16, U));
                    if (i16 <= 0) {
                        break;
                    } else {
                        if (this.f35697i) {
                            unsafe.putInt(t16, i3, i16);
                        }
                        X = CodedOutputStream.X(T);
                        Z = CodedOutputStream.Z(i16);
                        j3 = X + Z + i16;
                        i17 += j3;
                        break;
                    }
                case 43:
                    i16 = bs.w((List) unsafe.getObject(t16, U));
                    if (i16 <= 0) {
                        break;
                    } else {
                        if (this.f35697i) {
                            unsafe.putInt(t16, i3, i16);
                        }
                        X = CodedOutputStream.X(T);
                        Z = CodedOutputStream.Z(i16);
                        j3 = X + Z + i16;
                        i17 += j3;
                        break;
                    }
                case 44:
                    i16 = bs.e((List) unsafe.getObject(t16, U));
                    if (i16 <= 0) {
                        break;
                    } else {
                        if (this.f35697i) {
                            unsafe.putInt(t16, i3, i16);
                        }
                        X = CodedOutputStream.X(T);
                        Z = CodedOutputStream.Z(i16);
                        j3 = X + Z + i16;
                        i17 += j3;
                        break;
                    }
                case 45:
                    i16 = bs.g((List) unsafe.getObject(t16, U));
                    if (i16 <= 0) {
                        break;
                    } else {
                        if (this.f35697i) {
                            unsafe.putInt(t16, i3, i16);
                        }
                        X = CodedOutputStream.X(T);
                        Z = CodedOutputStream.Z(i16);
                        j3 = X + Z + i16;
                        i17 += j3;
                        break;
                    }
                case 46:
                    i16 = bs.i((List) unsafe.getObject(t16, U));
                    if (i16 <= 0) {
                        break;
                    } else {
                        if (this.f35697i) {
                            unsafe.putInt(t16, i3, i16);
                        }
                        X = CodedOutputStream.X(T);
                        Z = CodedOutputStream.Z(i16);
                        j3 = X + Z + i16;
                        i17 += j3;
                        break;
                    }
                case 47:
                    i16 = bs.r((List) unsafe.getObject(t16, U));
                    if (i16 <= 0) {
                        break;
                    } else {
                        if (this.f35697i) {
                            unsafe.putInt(t16, i3, i16);
                        }
                        X = CodedOutputStream.X(T);
                        Z = CodedOutputStream.Z(i16);
                        j3 = X + Z + i16;
                        i17 += j3;
                        break;
                    }
                case 48:
                    i16 = bs.t((List) unsafe.getObject(t16, U));
                    if (i16 <= 0) {
                        break;
                    } else {
                        if (this.f35697i) {
                            unsafe.putInt(t16, i3, i16);
                        }
                        X = CodedOutputStream.X(T);
                        Z = CodedOutputStream.Z(i16);
                        j3 = X + Z + i16;
                        i17 += j3;
                        break;
                    }
                case 49:
                    j3 = bs.j(T, J(t16, U), u(i18));
                    i17 += j3;
                    break;
                case 50:
                    j3 = this.f35705q.c(T, ch.E(t16, U), t(i18));
                    i17 += j3;
                    break;
                case 51:
                    if (H(t16, T, i18)) {
                        j3 = CodedOutputStream.j(T, 0.0d);
                        i17 += j3;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (H(t16, T, i18)) {
                        j3 = CodedOutputStream.r(T, 0.0f);
                        i17 += j3;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (H(t16, T, i18)) {
                        j3 = CodedOutputStream.z(T, Z(t16, U));
                        i17 += j3;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (H(t16, T, i18)) {
                        j3 = CodedOutputStream.a0(T, Z(t16, U));
                        i17 += j3;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (H(t16, T, i18)) {
                        j3 = CodedOutputStream.x(T, Y(t16, U));
                        i17 += j3;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (H(t16, T, i18)) {
                        j3 = CodedOutputStream.p(T, 0L);
                        i17 += j3;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (H(t16, T, i18)) {
                        j3 = CodedOutputStream.n(T, 0);
                        i17 += j3;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (H(t16, T, i18)) {
                        j3 = CodedOutputStream.e(T, true);
                        i17 += j3;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (H(t16, T, i18)) {
                        Object E2 = ch.E(t16, U);
                        if (E2 instanceof ByteString) {
                            j3 = CodedOutputStream.h(T, (ByteString) E2);
                        } else {
                            j3 = CodedOutputStream.V(T, (String) E2);
                        }
                        i17 += j3;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (H(t16, T, i18)) {
                        j3 = bs.o(T, ch.E(t16, U), u(i18));
                        i17 += j3;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (H(t16, T, i18)) {
                        j3 = CodedOutputStream.h(T, (ByteString) ch.E(t16, U));
                        i17 += j3;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (H(t16, T, i18)) {
                        j3 = CodedOutputStream.Y(T, Y(t16, U));
                        i17 += j3;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (H(t16, T, i18)) {
                        j3 = CodedOutputStream.l(T, Y(t16, U));
                        i17 += j3;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (H(t16, T, i18)) {
                        j3 = CodedOutputStream.N(T, 0);
                        i17 += j3;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (H(t16, T, i18)) {
                        j3 = CodedOutputStream.P(T, 0L);
                        i17 += j3;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (H(t16, T, i18)) {
                        j3 = CodedOutputStream.R(T, Y(t16, U));
                        i17 += j3;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (H(t16, T, i18)) {
                        j3 = CodedOutputStream.T(T, Z(t16, U));
                        i17 += j3;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (H(t16, T, i18)) {
                        j3 = CodedOutputStream.u(T, (au) ch.E(t16, U), u(i18));
                        i17 += j3;
                        break;
                    } else {
                        break;
                    }
            }
        }
        return i17 + y(this.f35703o, t16);
    }

    private void x0(int i3, Object obj, Writer writer) throws IOException {
        if (obj instanceof String) {
            writer.a(i3, (String) obj);
        } else {
            writer.m(i3, (ByteString) obj);
        }
    }

    private <UT, UB> int y(cb<UT, UB> cbVar, T t16) {
        return cbVar.h(cbVar.g(t16));
    }

    private <UT, UB> void y0(cb<UT, UB> cbVar, T t16, Writer writer) throws IOException {
        cbVar.t(cbVar.g(t16), writer);
    }

    private static <T> int z(T t16, long j3) {
        return ch.A(t16, j3);
    }

    @Override // com.google.protobuf.bq
    public void a(T t16, T t17) {
        t17.getClass();
        for (int i3 = 0; i3 < this.f35689a.length; i3 += 3) {
            P(t16, t17, i3);
        }
        bs.H(this.f35703o, t16, t17);
        if (this.f35694f) {
            bs.F(this.f35704p, t16, t17);
        }
    }

    @Override // com.google.protobuf.bq
    public final boolean b(T t16) {
        int i3;
        int i16 = -1;
        int i17 = 0;
        for (int i18 = 0; i18 < this.f35699k; i18++) {
            int i19 = this.f35698j[i18];
            int T = T(i19);
            int s06 = s0(i19);
            if (!this.f35696h) {
                int i26 = this.f35689a[i19 + 2];
                int i27 = 1048575 & i26;
                i3 = 1 << (i26 >>> 20);
                if (i27 != i16) {
                    i17 = f35688s.getInt(t16, i27);
                    i16 = i27;
                }
            } else {
                i3 = 0;
            }
            if (I(s06) && !C(t16, i19, i17, i3)) {
                return false;
            }
            int r06 = r0(s06);
            if (r06 != 9 && r06 != 17) {
                if (r06 != 27) {
                    if (r06 != 60 && r06 != 68) {
                        if (r06 != 49) {
                            if (r06 == 50 && !F(t16, s06, i19)) {
                                return false;
                            }
                        }
                    } else if (H(t16, T, i19) && !D(t16, s06, u(i19))) {
                        return false;
                    }
                }
                if (!E(t16, s06, i19)) {
                    return false;
                }
            } else if (C(t16, i19, i17, i3) && !D(t16, s06, u(i19))) {
                return false;
            }
        }
        if (this.f35694f && !this.f35704p.c(t16).C()) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x0019. Please report as an issue. */
    @Override // com.google.protobuf.bq
    public int c(T t16) {
        int i3;
        int h16;
        int length = this.f35689a.length;
        int i16 = 0;
        for (int i17 = 0; i17 < length; i17 += 3) {
            int s06 = s0(i17);
            int T = T(i17);
            long U = U(s06);
            int i18 = 37;
            switch (r0(s06)) {
                case 0:
                    i3 = i16 * 53;
                    h16 = ad.h(Double.doubleToLongBits(ch.y(t16, U)));
                    i16 = i3 + h16;
                    break;
                case 1:
                    i3 = i16 * 53;
                    h16 = Float.floatToIntBits(ch.z(t16, U));
                    i16 = i3 + h16;
                    break;
                case 2:
                    i3 = i16 * 53;
                    h16 = ad.h(ch.C(t16, U));
                    i16 = i3 + h16;
                    break;
                case 3:
                    i3 = i16 * 53;
                    h16 = ad.h(ch.C(t16, U));
                    i16 = i3 + h16;
                    break;
                case 4:
                    i3 = i16 * 53;
                    h16 = ch.A(t16, U);
                    i16 = i3 + h16;
                    break;
                case 5:
                    i3 = i16 * 53;
                    h16 = ad.h(ch.C(t16, U));
                    i16 = i3 + h16;
                    break;
                case 6:
                    i3 = i16 * 53;
                    h16 = ch.A(t16, U);
                    i16 = i3 + h16;
                    break;
                case 7:
                    i3 = i16 * 53;
                    h16 = ad.c(ch.r(t16, U));
                    i16 = i3 + h16;
                    break;
                case 8:
                    i3 = i16 * 53;
                    h16 = ((String) ch.E(t16, U)).hashCode();
                    i16 = i3 + h16;
                    break;
                case 9:
                    Object E = ch.E(t16, U);
                    if (E != null) {
                        i18 = E.hashCode();
                    }
                    i16 = (i16 * 53) + i18;
                    break;
                case 10:
                    i3 = i16 * 53;
                    h16 = ch.E(t16, U).hashCode();
                    i16 = i3 + h16;
                    break;
                case 11:
                    i3 = i16 * 53;
                    h16 = ch.A(t16, U);
                    i16 = i3 + h16;
                    break;
                case 12:
                    i3 = i16 * 53;
                    h16 = ch.A(t16, U);
                    i16 = i3 + h16;
                    break;
                case 13:
                    i3 = i16 * 53;
                    h16 = ch.A(t16, U);
                    i16 = i3 + h16;
                    break;
                case 14:
                    i3 = i16 * 53;
                    h16 = ad.h(ch.C(t16, U));
                    i16 = i3 + h16;
                    break;
                case 15:
                    i3 = i16 * 53;
                    h16 = ch.A(t16, U);
                    i16 = i3 + h16;
                    break;
                case 16:
                    i3 = i16 * 53;
                    h16 = ad.h(ch.C(t16, U));
                    i16 = i3 + h16;
                    break;
                case 17:
                    Object E2 = ch.E(t16, U);
                    if (E2 != null) {
                        i18 = E2.hashCode();
                    }
                    i16 = (i16 * 53) + i18;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i3 = i16 * 53;
                    h16 = ch.E(t16, U).hashCode();
                    i16 = i3 + h16;
                    break;
                case 50:
                    i3 = i16 * 53;
                    h16 = ch.E(t16, U).hashCode();
                    i16 = i3 + h16;
                    break;
                case 51:
                    if (H(t16, T, i17)) {
                        i3 = i16 * 53;
                        h16 = ad.h(Double.doubleToLongBits(W(t16, U)));
                        i16 = i3 + h16;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (H(t16, T, i17)) {
                        i3 = i16 * 53;
                        h16 = Float.floatToIntBits(X(t16, U));
                        i16 = i3 + h16;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (H(t16, T, i17)) {
                        i3 = i16 * 53;
                        h16 = ad.h(Z(t16, U));
                        i16 = i3 + h16;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (H(t16, T, i17)) {
                        i3 = i16 * 53;
                        h16 = ad.h(Z(t16, U));
                        i16 = i3 + h16;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (H(t16, T, i17)) {
                        i3 = i16 * 53;
                        h16 = Y(t16, U);
                        i16 = i3 + h16;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (H(t16, T, i17)) {
                        i3 = i16 * 53;
                        h16 = ad.h(Z(t16, U));
                        i16 = i3 + h16;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (H(t16, T, i17)) {
                        i3 = i16 * 53;
                        h16 = Y(t16, U);
                        i16 = i3 + h16;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (H(t16, T, i17)) {
                        i3 = i16 * 53;
                        h16 = ad.c(V(t16, U));
                        i16 = i3 + h16;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (H(t16, T, i17)) {
                        i3 = i16 * 53;
                        h16 = ((String) ch.E(t16, U)).hashCode();
                        i16 = i3 + h16;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (H(t16, T, i17)) {
                        i3 = i16 * 53;
                        h16 = ch.E(t16, U).hashCode();
                        i16 = i3 + h16;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (H(t16, T, i17)) {
                        i3 = i16 * 53;
                        h16 = ch.E(t16, U).hashCode();
                        i16 = i3 + h16;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (H(t16, T, i17)) {
                        i3 = i16 * 53;
                        h16 = Y(t16, U);
                        i16 = i3 + h16;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (H(t16, T, i17)) {
                        i3 = i16 * 53;
                        h16 = Y(t16, U);
                        i16 = i3 + h16;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (H(t16, T, i17)) {
                        i3 = i16 * 53;
                        h16 = Y(t16, U);
                        i16 = i3 + h16;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (H(t16, T, i17)) {
                        i3 = i16 * 53;
                        h16 = ad.h(Z(t16, U));
                        i16 = i3 + h16;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (H(t16, T, i17)) {
                        i3 = i16 * 53;
                        h16 = Y(t16, U);
                        i16 = i3 + h16;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (H(t16, T, i17)) {
                        i3 = i16 * 53;
                        h16 = ad.h(Z(t16, U));
                        i16 = i3 + h16;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (H(t16, T, i17)) {
                        i3 = i16 * 53;
                        h16 = ch.E(t16, U).hashCode();
                        i16 = i3 + h16;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int hashCode = (i16 * 53) + this.f35703o.g(t16).hashCode();
        if (this.f35694f) {
            return (hashCode * 53) + this.f35704p.c(t16).hashCode();
        }
        return hashCode;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:201:0x0359, code lost:
    
        if (r0 != r11) goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:202:0x035b, code lost:
    
        r15 = r30;
        r14 = r31;
        r12 = r32;
        r13 = r34;
        r11 = r35;
        r9 = r36;
        r1 = r17;
        r3 = r18;
        r7 = r19;
        r2 = r20;
        r6 = r22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:203:0x03c8, code lost:
    
        r2 = r0;
        r8 = r18;
        r0 = r35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:209:0x03a2, code lost:
    
        if (r0 != r15) goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:211:0x03c5, code lost:
    
        if (r0 != r15) goto L120;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:20:0x008b. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int c0(T t16, byte[] bArr, int i3, int i16, int i17, f.b bVar) throws IOException {
        Unsafe unsafe;
        int i18;
        ay<T> ayVar;
        T t17;
        int i19;
        int i26;
        int f06;
        int i27;
        int i28;
        int i29;
        int i36;
        int i37;
        int i38;
        int i39;
        int i46;
        int i47;
        int i48;
        int i49;
        char c16;
        int i56;
        int i57;
        int i58;
        int L;
        int i59;
        boolean z16;
        ay<T> ayVar2 = this;
        T t18 = t16;
        byte[] bArr2 = bArr;
        int i65 = i16;
        int i66 = i17;
        f.b bVar2 = bVar;
        Unsafe unsafe2 = f35688s;
        int i67 = i3;
        int i68 = 0;
        int i69 = 0;
        int i75 = 0;
        int i76 = -1;
        int i77 = -1;
        while (true) {
            if (i67 < i65) {
                int i78 = i67 + 1;
                byte b16 = bArr2[i67];
                if (b16 < 0) {
                    i26 = f.H(b16, bArr2, i78, bVar2);
                    i19 = bVar2.f35847a;
                } else {
                    i19 = b16;
                    i26 = i78;
                }
                int i79 = i19 >>> 3;
                int i85 = i19 & 7;
                if (i79 > i76) {
                    f06 = ayVar2.g0(i79, i68 / 3);
                } else {
                    f06 = ayVar2.f0(i79);
                }
                int i86 = f06;
                if (i86 == -1) {
                    i27 = i79;
                    i28 = i26;
                    i29 = i19;
                    i36 = i75;
                    i37 = i77;
                    unsafe = unsafe2;
                    i38 = i66;
                    i39 = 0;
                } else {
                    int i87 = ayVar2.f35689a[i86 + 1];
                    int r06 = r0(i87);
                    long U = U(i87);
                    int i88 = i19;
                    if (r06 <= 17) {
                        int i89 = ayVar2.f35689a[i86 + 2];
                        int i95 = 1 << (i89 >>> 20);
                        int i96 = i89 & 1048575;
                        if (i96 != i77) {
                            c16 = '\uffff';
                            i49 = i86;
                            if (i77 != -1) {
                                unsafe2.putInt(t18, i77, i75);
                            }
                            i75 = unsafe2.getInt(t18, i96);
                            i77 = i96;
                        } else {
                            i49 = i86;
                            c16 = '\uffff';
                        }
                        switch (r06) {
                            case 0:
                                i56 = i49;
                                i27 = i79;
                                bArr2 = bArr;
                                i57 = i26;
                                i58 = i88;
                                if (i85 == 1) {
                                    ch.Q(t18, U, f.d(bArr2, i57));
                                    i67 = i57 + 8;
                                    i75 |= i95;
                                    i66 = i17;
                                    i68 = i56;
                                    i69 = i58;
                                    i76 = i27;
                                    i65 = i16;
                                } else {
                                    i38 = i17;
                                    i36 = i75;
                                    i37 = i77;
                                    i39 = i56;
                                    unsafe = unsafe2;
                                    i28 = i57;
                                    i29 = i58;
                                    break;
                                }
                            case 1:
                                i56 = i49;
                                i27 = i79;
                                bArr2 = bArr;
                                i57 = i26;
                                i58 = i88;
                                if (i85 == 5) {
                                    ch.R(t18, U, f.l(bArr2, i57));
                                    i67 = i57 + 4;
                                    i75 |= i95;
                                    i66 = i17;
                                    i68 = i56;
                                    i69 = i58;
                                    i76 = i27;
                                    i65 = i16;
                                } else {
                                    i38 = i17;
                                    i36 = i75;
                                    i37 = i77;
                                    i39 = i56;
                                    unsafe = unsafe2;
                                    i28 = i57;
                                    i29 = i58;
                                    break;
                                }
                            case 2:
                            case 3:
                                i56 = i49;
                                i27 = i79;
                                bArr2 = bArr;
                                i57 = i26;
                                i58 = i88;
                                if (i85 == 0) {
                                    L = f.L(bArr2, i57, bVar2);
                                    unsafe2.putLong(t16, U, bVar2.f35848b);
                                    i75 |= i95;
                                    i68 = i56;
                                    i67 = L;
                                    i69 = i58;
                                    i76 = i27;
                                    i65 = i16;
                                    i66 = i17;
                                } else {
                                    i38 = i17;
                                    i36 = i75;
                                    i37 = i77;
                                    i39 = i56;
                                    unsafe = unsafe2;
                                    i28 = i57;
                                    i29 = i58;
                                    break;
                                }
                            case 4:
                            case 11:
                                i56 = i49;
                                i27 = i79;
                                bArr2 = bArr;
                                i57 = i26;
                                i58 = i88;
                                if (i85 == 0) {
                                    i67 = f.I(bArr2, i57, bVar2);
                                    unsafe2.putInt(t18, U, bVar2.f35847a);
                                    i75 |= i95;
                                    i66 = i17;
                                    i68 = i56;
                                    i69 = i58;
                                    i76 = i27;
                                    i65 = i16;
                                } else {
                                    i38 = i17;
                                    i36 = i75;
                                    i37 = i77;
                                    i39 = i56;
                                    unsafe = unsafe2;
                                    i28 = i57;
                                    i29 = i58;
                                    break;
                                }
                            case 5:
                            case 14:
                                i56 = i49;
                                i27 = i79;
                                bArr2 = bArr;
                                i58 = i88;
                                if (i85 == 1) {
                                    i57 = i26;
                                    unsafe2.putLong(t16, U, f.j(bArr2, i26));
                                    i67 = i57 + 8;
                                    i75 |= i95;
                                    i66 = i17;
                                    i68 = i56;
                                    i69 = i58;
                                    i76 = i27;
                                    i65 = i16;
                                } else {
                                    i57 = i26;
                                    i38 = i17;
                                    i36 = i75;
                                    i37 = i77;
                                    i39 = i56;
                                    unsafe = unsafe2;
                                    i28 = i57;
                                    i29 = i58;
                                    break;
                                }
                            case 6:
                            case 13:
                                i56 = i49;
                                i27 = i79;
                                bArr2 = bArr;
                                i59 = i16;
                                i58 = i88;
                                if (i85 == 5) {
                                    unsafe2.putInt(t18, U, f.h(bArr2, i26));
                                    i67 = i26 + 4;
                                    i75 |= i95;
                                    i68 = i56;
                                    i69 = i58;
                                    i76 = i27;
                                    i65 = i59;
                                    i66 = i17;
                                } else {
                                    i57 = i26;
                                    i38 = i17;
                                    i36 = i75;
                                    i37 = i77;
                                    i39 = i56;
                                    unsafe = unsafe2;
                                    i28 = i57;
                                    i29 = i58;
                                    break;
                                }
                            case 7:
                                i56 = i49;
                                i27 = i79;
                                bArr2 = bArr;
                                i59 = i16;
                                i58 = i88;
                                if (i85 == 0) {
                                    i67 = f.L(bArr2, i26, bVar2);
                                    if (bVar2.f35848b != 0) {
                                        z16 = true;
                                    } else {
                                        z16 = false;
                                    }
                                    ch.K(t18, U, z16);
                                    i75 |= i95;
                                    i68 = i56;
                                    i69 = i58;
                                    i76 = i27;
                                    i65 = i59;
                                    i66 = i17;
                                } else {
                                    i57 = i26;
                                    i38 = i17;
                                    i36 = i75;
                                    i37 = i77;
                                    i39 = i56;
                                    unsafe = unsafe2;
                                    i28 = i57;
                                    i29 = i58;
                                    break;
                                }
                            case 8:
                                i56 = i49;
                                i27 = i79;
                                bArr2 = bArr;
                                i59 = i16;
                                i58 = i88;
                                if (i85 == 2) {
                                    if ((i87 & 536870912) == 0) {
                                        i67 = f.C(bArr2, i26, bVar2);
                                    } else {
                                        i67 = f.F(bArr2, i26, bVar2);
                                    }
                                    unsafe2.putObject(t18, U, bVar2.f35849c);
                                    i75 |= i95;
                                    i68 = i56;
                                    i69 = i58;
                                    i76 = i27;
                                    i65 = i59;
                                    i66 = i17;
                                } else {
                                    i57 = i26;
                                    i38 = i17;
                                    i36 = i75;
                                    i37 = i77;
                                    i39 = i56;
                                    unsafe = unsafe2;
                                    i28 = i57;
                                    i29 = i58;
                                    break;
                                }
                            case 9:
                                i56 = i49;
                                i58 = i88;
                                i27 = i79;
                                bArr2 = bArr;
                                if (i85 == 2) {
                                    i59 = i16;
                                    i67 = f.p(ayVar2.u(i56), bArr2, i26, i59, bVar2);
                                    if ((i75 & i95) == 0) {
                                        unsafe2.putObject(t18, U, bVar2.f35849c);
                                    } else {
                                        unsafe2.putObject(t18, U, ad.j(unsafe2.getObject(t18, U), bVar2.f35849c));
                                    }
                                    i75 |= i95;
                                    i68 = i56;
                                    i69 = i58;
                                    i76 = i27;
                                    i65 = i59;
                                    i66 = i17;
                                } else {
                                    i57 = i26;
                                    i38 = i17;
                                    i36 = i75;
                                    i37 = i77;
                                    i39 = i56;
                                    unsafe = unsafe2;
                                    i28 = i57;
                                    i29 = i58;
                                    break;
                                }
                            case 10:
                                i56 = i49;
                                i58 = i88;
                                i27 = i79;
                                bArr2 = bArr;
                                if (i85 == 2) {
                                    i67 = f.b(bArr2, i26, bVar2);
                                    unsafe2.putObject(t18, U, bVar2.f35849c);
                                    i75 |= i95;
                                    i66 = i17;
                                    i68 = i56;
                                    i69 = i58;
                                    i76 = i27;
                                    i65 = i16;
                                } else {
                                    i57 = i26;
                                    i38 = i17;
                                    i36 = i75;
                                    i37 = i77;
                                    i39 = i56;
                                    unsafe = unsafe2;
                                    i28 = i57;
                                    i29 = i58;
                                    break;
                                }
                            case 12:
                                i56 = i49;
                                i58 = i88;
                                i27 = i79;
                                bArr2 = bArr;
                                if (i85 == 0) {
                                    i67 = f.I(bArr2, i26, bVar2);
                                    int i97 = bVar2.f35847a;
                                    ad.e s16 = ayVar2.s(i56);
                                    if (s16 != null && !s16.isInRange(i97)) {
                                        v(t16).r(i58, Long.valueOf(i97));
                                        i66 = i17;
                                        i68 = i56;
                                        i69 = i58;
                                        i76 = i27;
                                        i65 = i16;
                                    } else {
                                        unsafe2.putInt(t18, U, i97);
                                        i75 |= i95;
                                        i66 = i17;
                                        i68 = i56;
                                        i69 = i58;
                                        i76 = i27;
                                        i65 = i16;
                                    }
                                } else {
                                    i57 = i26;
                                    i38 = i17;
                                    i36 = i75;
                                    i37 = i77;
                                    i39 = i56;
                                    unsafe = unsafe2;
                                    i28 = i57;
                                    i29 = i58;
                                    break;
                                }
                                break;
                            case 15:
                                i56 = i49;
                                i58 = i88;
                                i27 = i79;
                                bArr2 = bArr;
                                if (i85 == 0) {
                                    i67 = f.I(bArr2, i26, bVar2);
                                    unsafe2.putInt(t18, U, k.b(bVar2.f35847a));
                                    i75 |= i95;
                                    i66 = i17;
                                    i68 = i56;
                                    i69 = i58;
                                    i76 = i27;
                                    i65 = i16;
                                } else {
                                    i57 = i26;
                                    i38 = i17;
                                    i36 = i75;
                                    i37 = i77;
                                    i39 = i56;
                                    unsafe = unsafe2;
                                    i28 = i57;
                                    i29 = i58;
                                    break;
                                }
                            case 16:
                                i56 = i49;
                                i58 = i88;
                                i27 = i79;
                                if (i85 == 0) {
                                    bArr2 = bArr;
                                    L = f.L(bArr2, i26, bVar2);
                                    unsafe2.putLong(t16, U, k.c(bVar2.f35848b));
                                    i75 |= i95;
                                    i68 = i56;
                                    i67 = L;
                                    i69 = i58;
                                    i76 = i27;
                                    i65 = i16;
                                    i66 = i17;
                                } else {
                                    i57 = i26;
                                    i38 = i17;
                                    i36 = i75;
                                    i37 = i77;
                                    i39 = i56;
                                    unsafe = unsafe2;
                                    i28 = i57;
                                    i29 = i58;
                                    break;
                                }
                            case 17:
                                if (i85 == 3) {
                                    int i98 = i49;
                                    i56 = i98;
                                    i27 = i79;
                                    i58 = i88;
                                    i67 = f.n(ayVar2.u(i98), bArr, i26, i16, (i79 << 3) | 4, bVar);
                                    if ((i75 & i95) == 0) {
                                        unsafe2.putObject(t18, U, bVar2.f35849c);
                                    } else {
                                        unsafe2.putObject(t18, U, ad.j(unsafe2.getObject(t18, U), bVar2.f35849c));
                                    }
                                    i75 |= i95;
                                    bArr2 = bArr;
                                    i66 = i17;
                                    i68 = i56;
                                    i69 = i58;
                                    i76 = i27;
                                    i65 = i16;
                                } else {
                                    i56 = i49;
                                    i58 = i88;
                                    i27 = i79;
                                    i57 = i26;
                                    i38 = i17;
                                    i36 = i75;
                                    i37 = i77;
                                    i39 = i56;
                                    unsafe = unsafe2;
                                    i28 = i57;
                                    i29 = i58;
                                    break;
                                }
                            default:
                                i57 = i26;
                                i56 = i49;
                                i27 = i79;
                                i58 = i88;
                                i38 = i17;
                                i36 = i75;
                                i37 = i77;
                                i39 = i56;
                                unsafe = unsafe2;
                                i28 = i57;
                                i29 = i58;
                                break;
                        }
                    } else {
                        i27 = i79;
                        bArr2 = bArr;
                        int i99 = i26;
                        if (r06 == 27) {
                            if (i85 == 2) {
                                ad.j jVar = (ad.j) unsafe2.getObject(t18, U);
                                if (!jVar.z()) {
                                    int size = jVar.size();
                                    if (size == 0) {
                                        i48 = 10;
                                    } else {
                                        i48 = size * 2;
                                    }
                                    jVar = jVar.b2(i48);
                                    unsafe2.putObject(t18, U, jVar);
                                }
                                i67 = f.q(ayVar2.u(i86), i88, bArr, i99, i16, jVar, bVar);
                                i66 = i17;
                                i69 = i88;
                                i76 = i27;
                                i68 = i86;
                                i75 = i75;
                                i65 = i16;
                            } else {
                                i39 = i86;
                                i36 = i75;
                                i37 = i77;
                                unsafe = unsafe2;
                                i46 = i99;
                                i47 = i88;
                            }
                        } else {
                            i39 = i86;
                            i36 = i75;
                            if (r06 <= 49) {
                                i37 = i77;
                                unsafe = unsafe2;
                                i47 = i88;
                                i67 = e0(t16, bArr, i99, i16, i88, i27, i85, i39, i87, r06, U, bVar);
                            } else {
                                unsafe = unsafe2;
                                i46 = i99;
                                i47 = i88;
                                i37 = i77;
                                if (r06 == 50) {
                                    if (i85 == 2) {
                                        i67 = a0(t16, bArr, i46, i16, i39, U, bVar);
                                    }
                                } else {
                                    i67 = b0(t16, bArr, i46, i16, i47, i27, i85, i87, r06, U, i39, bVar);
                                }
                            }
                        }
                        i38 = i17;
                        i28 = i46;
                        i29 = i47;
                    }
                }
                if (i29 == i38 && i38 != 0) {
                    ayVar = this;
                    i18 = i38;
                    i67 = i28;
                    i69 = i29;
                    i77 = i37;
                    i75 = i36;
                } else {
                    int i100 = i38;
                    if (this.f35694f && bVar.f35850d != t.b()) {
                        i67 = f.g(i29, bArr, i28, i16, t16, this.f35693e, this.f35703o, bVar);
                    } else {
                        i67 = f.G(i29, bArr, i28, i16, v(t16), bVar);
                    }
                    t18 = t16;
                    bArr2 = bArr;
                    i65 = i16;
                    i69 = i29;
                    ayVar2 = this;
                    bVar2 = bVar;
                    i76 = i27;
                    i77 = i37;
                    i68 = i39;
                    i75 = i36;
                    i66 = i100;
                    unsafe2 = unsafe;
                }
            } else {
                unsafe = unsafe2;
                i18 = i66;
                ayVar = ayVar2;
            }
        }
        if (i77 != -1) {
            t17 = t16;
            unsafe.putInt(t17, i77, i75);
        } else {
            t17 = t16;
        }
        cd cdVar = null;
        for (int i101 = ayVar.f35699k; i101 < ayVar.f35700l; i101++) {
            cdVar = (cd) ayVar.p(t17, ayVar.f35698j[i101], cdVar, ayVar.f35703o);
        }
        if (cdVar != null) {
            ayVar.f35703o.o(t17, cdVar);
        }
        if (i18 == 0) {
            if (i67 != i16) {
                throw InvalidProtocolBufferException.parseFailure();
            }
        } else if (i67 > i16 || i69 != i18) {
            throw InvalidProtocolBufferException.parseFailure();
        }
        return i67;
    }

    @Override // com.google.protobuf.bq
    public boolean d(T t16, T t17) {
        int length = this.f35689a.length;
        for (int i3 = 0; i3 < length; i3 += 3) {
            if (!o(t16, t17, i3)) {
                return false;
            }
        }
        if (!this.f35703o.g(t16).equals(this.f35703o.g(t17))) {
            return false;
        }
        if (this.f35694f) {
            return this.f35704p.c(t16).equals(this.f35704p.c(t17));
        }
        return true;
    }

    @Override // com.google.protobuf.bq
    public void e(T t16, Writer writer) throws IOException {
        if (writer.F() == Writer.FieldOrder.DESCENDING) {
            v0(t16, writer);
        } else if (this.f35696h) {
            u0(t16, writer);
        } else {
            t0(t16, writer);
        }
    }

    @Override // com.google.protobuf.bq
    public void f(T t16, byte[] bArr, int i3, int i16, f.b bVar) throws IOException {
        if (this.f35696h) {
            d0(t16, bArr, i3, i16, bVar);
        } else {
            c0(t16, bArr, i3, i16, 0, bVar);
        }
    }

    @Override // com.google.protobuf.bq
    public void g(T t16) {
        int i3;
        int i16 = this.f35699k;
        while (true) {
            i3 = this.f35700l;
            if (i16 >= i3) {
                break;
            }
            long U = U(s0(this.f35698j[i16]));
            Object E = ch.E(t16, U);
            if (E != null) {
                ch.U(t16, U, this.f35705q.f(E));
            }
            i16++;
        }
        int length = this.f35698j.length;
        while (i3 < length) {
            this.f35702n.c(t16, this.f35698j[i3]);
            i3++;
        }
        this.f35703o.j(t16);
        if (this.f35694f) {
            this.f35704p.f(t16);
        }
    }

    @Override // com.google.protobuf.bq
    public int h(T t16) {
        if (this.f35696h) {
            return x(t16);
        }
        return w(t16);
    }

    @Override // com.google.protobuf.bq
    public void i(T t16, bn bnVar, t tVar) throws IOException {
        tVar.getClass();
        L(this.f35703o, this.f35704p, t16, bnVar, tVar);
    }

    @Override // com.google.protobuf.bq
    public T newInstance() {
        return (T) this.f35701m.a(this.f35693e);
    }
}
