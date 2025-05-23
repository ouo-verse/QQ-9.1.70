package com.tencent.mtt.hippy.c.a;

import com.tencent.mtt.hippy.c.c;
import com.tencent.mtt.hippy.c.e;
import com.tencent.mtt.hippy.c.f;
import com.tencent.mtt.hippy.common.ConstantValue;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import java.math.BigInteger;

/* compiled from: P */
/* loaded from: classes20.dex */
public class a extends c {

    /* renamed from: f, reason: collision with root package name */
    private boolean f337110f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mtt.hippy.c.a.a$1, reason: invalid class name */
    /* loaded from: classes20.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f337111a;

        static {
            int[] iArr = new int[com.tencent.mtt.hippy.c.b.values().length];
            f337111a = iArr;
            try {
                iArr[com.tencent.mtt.hippy.c.b.EVAL_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f337111a[com.tencent.mtt.hippy.c.b.RANGE_ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f337111a[com.tencent.mtt.hippy.c.b.REFERENCE_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f337111a[com.tencent.mtt.hippy.c.b.SYNTAX_ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f337111a[com.tencent.mtt.hippy.c.b.TYPE_ERROR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f337111a[com.tencent.mtt.hippy.c.b.URI_ERROR.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f337111a[com.tencent.mtt.hippy.c.b.MESSAGE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f337111a[com.tencent.mtt.hippy.c.b.STACK.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public a(com.tencent.mtt.hippy.c.c.a.a aVar, com.tencent.mtt.hippy.c.e.c cVar) {
        super(aVar, cVar);
        this.f337110f = false;
    }

    private HippyMap A() {
        boolean z16 = false;
        String str = null;
        String str2 = null;
        String str3 = null;
        while (!z16) {
            com.tencent.mtt.hippy.c.b p16 = p();
            if (p16 != null) {
                switch (AnonymousClass1.f337111a[p16.ordinal()]) {
                    case 1:
                        str3 = "EvalError";
                        break;
                    case 2:
                        str3 = "RangeError";
                        break;
                    case 3:
                        str3 = "ReferenceError";
                        break;
                    case 4:
                        str3 = "SyntaxError";
                        break;
                    case 5:
                        str3 = "TypeError";
                        break;
                    case 6:
                        str3 = "URIError";
                        break;
                    case 7:
                        str = b(f.ERROR_MESSAGE, null);
                        break;
                    case 8:
                        str2 = b(f.ERROR_STACK, null);
                        break;
                    default:
                        if (p16 == com.tencent.mtt.hippy.c.b.END) {
                            z16 = true;
                            break;
                        } else {
                            throw new AssertionError("ErrorTag: " + p16);
                        }
                }
            } else {
                HippyMap hippyMap = new HippyMap();
                hippyMap.pushString("message", str);
                hippyMap.pushString("stack", str2);
                hippyMap.pushString("type", str3);
                a((a) hippyMap);
                return hippyMap;
            }
        }
        HippyMap hippyMap2 = new HippyMap();
        hippyMap2.pushString("message", str);
        hippyMap2.pushString("stack", str2);
        hippyMap2.pushString("type", str3);
        a((a) hippyMap2);
        return hippyMap2;
    }

    private Object B() {
        return a((a) this.f337161c);
    }

    private Object C() {
        this.f337123a.c();
        return a((a) this.f337161c);
    }

    private Object D() {
        this.f337123a.c();
        a((a) this.f337161c);
        if (g() == 86) {
            z();
            return null;
        }
        return null;
    }

    private Object E() {
        this.f337123a.c();
        a((a) this.f337161c);
        if (g() == 86) {
            z();
            return null;
        }
        return null;
    }

    private Object F() {
        this.f337123a.c();
        a((a) this.f337161c);
        return null;
    }

    private Object G() {
        this.f337123a.c();
        E();
        a((a) this.f337161c);
        return null;
    }

    private String f(f fVar, Object obj) {
        return (String) a((a) b(fVar, obj));
    }

    private com.tencent.mtt.hippy.c.b p() {
        return com.tencent.mtt.hippy.c.b.a((byte) this.f337123a.c());
    }

    private Number q() {
        return (Number) a((a) Double.valueOf(this.f337123a.b()));
    }

    private BigInteger r() {
        return (BigInteger) a((a) i());
    }

    private Object s() {
        int c16 = (int) this.f337123a.c();
        if (c16 >= 0) {
            com.tencent.mtt.hippy.c.c.a.a aVar = this.f337123a;
            aVar.b(aVar.e() + c16);
            a((a) this.f337161c);
            if (g() == 86) {
                z();
                return null;
            }
            return null;
        }
        throw new com.tencent.mtt.hippy.c.b.c(c16);
    }

    private Object t() {
        b(f.VOID, null);
        this.f337123a.c();
        return a((a) this.f337161c);
    }

    private HippyMap u() {
        HippyMap hippyMap = new HippyMap();
        a((a) hippyMap);
        if (a(hippyMap, (byte) 123) == ((int) this.f337123a.c())) {
            return hippyMap;
        }
        throw new com.tencent.mtt.hippy.b.a("unexpected number of properties");
    }

    private HippyMap v() {
        HippyMap hippyMap = new HippyMap();
        a((a) hippyMap);
        int i3 = 0;
        while (true) {
            byte f16 = f();
            if (f16 == 58) {
                break;
            }
            i3++;
            String obj = a(f16, f.MAP_KEY, (Object) null).toString();
            Object a16 = a(f.MAP_VALUE, obj);
            if (a16 != this.f337161c) {
                if (obj == "null") {
                    hippyMap.pushObject(null, a16);
                } else {
                    hippyMap.pushObject(obj, a16);
                }
            }
        }
        if (i3 * 2 == ((int) this.f337123a.c())) {
            return hippyMap;
        }
        throw new com.tencent.mtt.hippy.b.a("unexpected number of entries");
    }

    private HippyArray w() {
        HippyArray hippyArray = new HippyArray();
        a((a) hippyArray);
        int i3 = 0;
        while (true) {
            byte f16 = f();
            if (f16 == 44) {
                break;
            }
            i3++;
            hippyArray.pushObject(a(f16, f.SET_ITEM, (Object) null));
        }
        if (i3 == ((int) this.f337123a.c())) {
            return hippyArray;
        }
        throw new com.tencent.mtt.hippy.b.a("unexpected number of values");
    }

    private HippyArray x() {
        int c16 = (int) this.f337123a.c();
        if (c16 >= 0) {
            HippyArray hippyArray = new HippyArray();
            a((a) hippyArray);
            for (int i3 = 0; i3 < c16; i3++) {
                byte f16 = f();
                if (f16 != 45) {
                    hippyArray.pushObject(a(f16, f.DENSE_ARRAY_ITEM, Integer.valueOf(i3)));
                }
            }
            if (a((HippyMap) null, (byte) 36) == ((int) this.f337123a.c())) {
                if (c16 == ((int) this.f337123a.c())) {
                    return hippyArray;
                }
                throw new AssertionError("length ambiguity");
            }
            throw new com.tencent.mtt.hippy.b.a("unexpected number of properties");
        }
        throw new com.tencent.mtt.hippy.c.b.c(c16);
    }

    private HippyArray y() {
        int parseInt;
        long c16 = this.f337123a.c();
        HippyArray hippyArray = new HippyArray();
        a((a) hippyArray);
        int i3 = 0;
        while (true) {
            byte f16 = f();
            if (f16 == 64) {
                break;
            }
            i3++;
            Object a16 = a(f16, f.SPARSE_ARRAY_KEY, (Object) null);
            Object a17 = a(f.SPARSE_ARRAY_ITEM, a16);
            if (a16 instanceof Number) {
                parseInt = ((Number) a16).intValue();
            } else {
                if (a16 instanceof String) {
                    try {
                        parseInt = Integer.parseInt((String) a16);
                    } catch (NumberFormatException unused) {
                    }
                }
                parseInt = -1;
            }
            if (parseInt >= 0) {
                int size = (parseInt + 1) - hippyArray.size();
                if (size == 1) {
                    hippyArray.pushObject(a17);
                } else {
                    for (int i16 = 0; i16 < size; i16++) {
                        hippyArray.pushNull();
                    }
                    hippyArray.setObject(parseInt, a17);
                }
            }
        }
        if (i3 == ((int) this.f337123a.c())) {
            if (c16 == this.f337123a.c()) {
                return hippyArray;
            }
            throw new AssertionError("length ambiguity");
        }
        throw new com.tencent.mtt.hippy.b.a("unexpected number of properties");
    }

    private void z() {
        byte f16 = f();
        if (f16 == 86) {
            this.f337123a.c();
            this.f337123a.c();
            if (l() >= 14 || this.f337110f) {
                this.f337123a.c();
            }
            this.f337123a.c();
            a((a) this.f337161c);
            return;
        }
        throw new AssertionError("ArrayBufferViewTag: " + ((int) f16));
    }

    @Override // com.tencent.mtt.hippy.c.c
    protected int a() {
        return 15;
    }

    @Override // com.tencent.mtt.hippy.c.c
    public Object e() {
        int e16 = this.f337123a.e();
        try {
            return super.e();
        } catch (Exception e17) {
            if (l() == 13) {
                this.f337123a.b(e16);
                this.f337110f = true;
                return super.e();
            }
            throw e17;
        }
    }

    @Override // com.tencent.mtt.hippy.c.e
    protected Object m() {
        return ConstantValue.Undefined;
    }

    @Override // com.tencent.mtt.hippy.c.e
    protected Object n() {
        return ConstantValue.Null;
    }

    @Override // com.tencent.mtt.hippy.c.e
    protected Object o() {
        return ConstantValue.Hole;
    }

    private int a(HippyMap hippyMap, byte b16) {
        f fVar;
        f fVar2;
        String valueOf;
        if (b16 == 36) {
            fVar = f.DENSE_ARRAY_KEY;
            fVar2 = f.DENSE_ARRAY_ITEM;
        } else {
            if (b16 != 123) {
                throw new com.tencent.mtt.hippy.b.b();
            }
            fVar = f.OBJECT_KEY;
            fVar2 = f.OBJECT_VALUE;
        }
        int i3 = 0;
        while (true) {
            byte f16 = f();
            if (f16 == b16) {
                return i3;
            }
            i3++;
            Object a16 = a(f16, fVar, (Object) null);
            Object a17 = a(fVar2, a16);
            if (hippyMap != null && a17 != this.f337161c) {
                if (a16 instanceof Number) {
                    valueOf = String.valueOf(a16);
                } else {
                    if (!(a16 instanceof String)) {
                        throw new AssertionError("Object key is not of String(null) nor Number type");
                    }
                    if (a16 == "null") {
                        hippyMap.pushObject(null, a17);
                    } else {
                        valueOf = (String) a16;
                    }
                }
                hippyMap.pushObject(valueOf, a17);
            }
        }
    }

    private Boolean a(boolean z16) {
        return (Boolean) a((a) Boolean.valueOf(z16));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mtt.hippy.c.c
    public Object a(byte b16, f fVar, Object obj) {
        Object a16 = super.a(b16, fVar, obj);
        if (a16 != e.f337159e) {
            return a16;
        }
        if (b16 == 39) {
            return w();
        }
        if (b16 == 59) {
            return v();
        }
        if (b16 == 82) {
            return t();
        }
        if (b16 == 92) {
            return B();
        }
        if (b16 == 97) {
            return y();
        }
        if (b16 == 65) {
            return x();
        }
        if (b16 == 66) {
            return s();
        }
        switch (b16) {
            case 109:
                return G();
            case 110:
                return q();
            case 111:
                return u();
            case 112:
                if (l() >= 15) {
                    return C();
                }
                break;
            default:
                switch (b16) {
                    case 114:
                        return A();
                    case 115:
                        return f(fVar, obj);
                    case 116:
                        return D();
                    case 117:
                        return E();
                    default:
                        switch (b16) {
                            case 119:
                                return F();
                            case 120:
                                return a(false);
                            case 121:
                                return a(true);
                            case 122:
                                return r();
                        }
                }
        }
        if (l() >= 13) {
            return this.f337161c;
        }
        this.f337123a.b(-1);
        return B();
    }
}
