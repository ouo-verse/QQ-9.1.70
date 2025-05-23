package com.tencent.mtt.hippy.c.d;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.wink.storage.kv.MaskType;
import com.tencent.mtt.hippy.c.b.d;
import com.tencent.mtt.hippy.c.d.c;
import com.tencent.mtt.hippy.c.f;
import com.tencent.mtt.hippy.runtime.builtins.JSSharedArrayBuffer;
import com.tencent.mtt.hippy.runtime.builtins.b;
import com.tencent.mtt.hippy.runtime.builtins.b.e;
import com.tencent.mtt.hippy.runtime.builtins.c;
import com.tencent.mtt.hippy.runtime.builtins.g;
import com.tencent.mtt.hippy.runtime.builtins.h;
import com.tencent.mtt.hippy.runtime.builtins.i;
import com.tencent.mtt.hippy.runtime.builtins.wasm.WasmModule;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes20.dex */
public class a extends com.tencent.mtt.hippy.c.c {

    /* renamed from: f, reason: collision with root package name */
    private final InterfaceC9224a f337145f;

    /* renamed from: g, reason: collision with root package name */
    private Map<Integer, Object> f337146g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f337147h;

    /* renamed from: i, reason: collision with root package name */
    private c f337148i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mtt.hippy.c.d.a$2, reason: invalid class name */
    /* loaded from: classes20.dex */
    public static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f337150a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f337151b;

        static {
            int[] iArr = new int[com.tencent.mtt.hippy.c.b.values().length];
            f337151b = iArr;
            try {
                iArr[com.tencent.mtt.hippy.c.b.EVAL_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f337151b[com.tencent.mtt.hippy.c.b.RANGE_ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f337151b[com.tencent.mtt.hippy.c.b.REFERENCE_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f337151b[com.tencent.mtt.hippy.c.b.SYNTAX_ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f337151b[com.tencent.mtt.hippy.c.b.TYPE_ERROR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f337151b[com.tencent.mtt.hippy.c.b.URI_ERROR.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f337151b[com.tencent.mtt.hippy.c.b.MESSAGE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f337151b[com.tencent.mtt.hippy.c.b.STACK.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            int[] iArr2 = new int[com.tencent.mtt.hippy.c.a.values().length];
            f337150a = iArr2;
            try {
                iArr2[com.tencent.mtt.hippy.c.a.DATA_VIEW.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f337150a[com.tencent.mtt.hippy.c.a.BIGUINT64_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f337150a[com.tencent.mtt.hippy.c.a.BIGINT64_ARRAY.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f337150a[com.tencent.mtt.hippy.c.a.FLOAT32_ARRAY.ordinal()] = 4;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f337150a[com.tencent.mtt.hippy.c.a.FLOAT64_ARRAY.ordinal()] = 5;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f337150a[com.tencent.mtt.hippy.c.a.INT8_ARRAY.ordinal()] = 6;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f337150a[com.tencent.mtt.hippy.c.a.INT16_ARRAY.ordinal()] = 7;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f337150a[com.tencent.mtt.hippy.c.a.INT32_ARRAY.ordinal()] = 8;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f337150a[com.tencent.mtt.hippy.c.a.UINT8_ARRAY.ordinal()] = 9;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f337150a[com.tencent.mtt.hippy.c.a.UINT8_CLAMPED_ARRAY.ordinal()] = 10;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f337150a[com.tencent.mtt.hippy.c.a.UINT16_ARRAY.ordinal()] = 11;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f337150a[com.tencent.mtt.hippy.c.a.UINT32_ARRAY.ordinal()] = 12;
            } catch (NoSuchFieldError unused20) {
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mtt.hippy.c.d.a$a, reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    public interface InterfaceC9224a {
        JSSharedArrayBuffer a(a aVar, int i3);

        Object a(a aVar);

        c b(a aVar);

        WasmModule b(a aVar, int i3);
    }

    public a(com.tencent.mtt.hippy.c.c.a.a aVar, com.tencent.mtt.hippy.c.e.c cVar) {
        this(aVar, cVar, null);
    }

    private com.tencent.mtt.hippy.runtime.builtins.c A() {
        c.a aVar = c.a.Error;
        boolean z16 = false;
        String str = null;
        String str2 = null;
        while (!z16) {
            com.tencent.mtt.hippy.c.b q16 = q();
            if (q16 != null) {
                switch (AnonymousClass2.f337151b[q16.ordinal()]) {
                    case 1:
                        aVar = c.a.EvalError;
                        break;
                    case 2:
                        aVar = c.a.RangeError;
                        break;
                    case 3:
                        aVar = c.a.ReferenceError;
                        break;
                    case 4:
                        aVar = c.a.SyntaxError;
                        break;
                    case 5:
                        aVar = c.a.TypeError;
                        break;
                    case 6:
                        aVar = c.a.URIError;
                        break;
                    case 7:
                        str = b(f.ERROR_MESSAGE, null);
                        break;
                    case 8:
                        str2 = b(f.ERROR_STACK, null);
                        break;
                    default:
                        if (q16 == com.tencent.mtt.hippy.c.b.END) {
                            z16 = true;
                            break;
                        } else {
                            throw new AssertionError("ErrorTag: " + q16);
                        }
                }
            } else {
                com.tencent.mtt.hippy.runtime.builtins.c cVar = new com.tencent.mtt.hippy.runtime.builtins.c(aVar, str, str2);
                a((a) cVar);
                return cVar;
            }
        }
        com.tencent.mtt.hippy.runtime.builtins.c cVar2 = new com.tencent.mtt.hippy.runtime.builtins.c(aVar, str, str2);
        a((a) cVar2);
        return cVar2;
    }

    private Object B() {
        InterfaceC9224a interfaceC9224a = this.f337145f;
        if (interfaceC9224a != null) {
            return a((a) interfaceC9224a.a(this));
        }
        throw new com.tencent.mtt.hippy.c.b.a();
    }

    private c.a C() {
        c.a a16;
        InterfaceC9224a interfaceC9224a = this.f337145f;
        if (interfaceC9224a != null) {
            if (this.f337148i == null) {
                c b16 = interfaceC9224a.b(this);
                this.f337148i = b16;
                if (b16 == null) {
                    a16 = new c.a() { // from class: com.tencent.mtt.hippy.c.d.a.1
                    };
                    return (c.a) a((a) a16);
                }
            }
            int c16 = (int) this.f337123a.c();
            if (c16 >= 0) {
                a16 = this.f337148i.a(c16);
                return (c.a) a((a) a16);
            }
            throw new d(c16);
        }
        throw new com.tencent.mtt.hippy.c.b.a();
    }

    private Object D() {
        int c16 = (int) this.f337123a.c();
        if (c16 >= 0) {
            Map<Integer, Object> map = this.f337146g;
            if (map != null) {
                com.tencent.mtt.hippy.runtime.builtins.a aVar = (com.tencent.mtt.hippy.runtime.builtins.a) map.get(Integer.valueOf(c16));
                if (aVar != null) {
                    a((a) aVar);
                    if (g() == 86) {
                        return a(aVar);
                    }
                    return aVar;
                }
                throw new AssertionError("Invalid transfer id " + c16);
            }
            throw new AssertionError("Call |transferArrayBuffer(int, JSArrayBuffer)| first.");
        }
        throw new d(c16);
    }

    private Object E() {
        if (this.f337145f != null) {
            int c16 = (int) this.f337123a.c();
            if (c16 >= 0) {
                JSSharedArrayBuffer a16 = this.f337145f.a(this, c16);
                a((a) a16);
                if (g() == 86) {
                    return a((com.tencent.mtt.hippy.runtime.builtins.a) a16);
                }
                return a16;
            }
            throw new d(c16);
        }
        throw new com.tencent.mtt.hippy.c.b.a();
    }

    private Object F() {
        if (this.f337145f != null) {
            int c16 = (int) this.f337123a.c();
            if (c16 >= 0) {
                return a((a) this.f337145f.b(this, c16));
            }
            throw new d(c16);
        }
        throw new com.tencent.mtt.hippy.c.b.a();
    }

    private Object G() {
        long c16 = this.f337123a.c();
        i iVar = (i) E();
        if (iVar.s()) {
            return a((a) new com.tencent.mtt.hippy.runtime.builtins.wasm.a(c16, (JSSharedArrayBuffer) iVar));
        }
        throw new com.tencent.mtt.hippy.b.a("expected SharedArrayBuffer");
    }

    private e f(f fVar, Object obj) {
        return (e) a((a) new e(b(fVar, obj)));
    }

    private com.tencent.mtt.hippy.c.a p() {
        return com.tencent.mtt.hippy.c.a.a((byte) this.f337123a.c());
    }

    private com.tencent.mtt.hippy.c.b q() {
        return com.tencent.mtt.hippy.c.b.a((byte) this.f337123a.c());
    }

    private com.tencent.mtt.hippy.runtime.builtins.b.c r() {
        return (com.tencent.mtt.hippy.runtime.builtins.b.c) a((a) new com.tencent.mtt.hippy.runtime.builtins.b.c(Double.valueOf(this.f337123a.b())));
    }

    private com.tencent.mtt.hippy.runtime.builtins.b.a s() {
        return (com.tencent.mtt.hippy.runtime.builtins.b.a) a((a) new com.tencent.mtt.hippy.runtime.builtins.b.a(i()));
    }

    private Object t() {
        int c16 = (int) this.f337123a.c();
        if (c16 >= 0) {
            com.tencent.mtt.hippy.runtime.builtins.a a16 = com.tencent.mtt.hippy.runtime.builtins.a.a(c16);
            ByteBuffer a17 = a16.a();
            a17.put(this.f337123a.a(c16));
            a((a) a16);
            if (g() == 86) {
                return a(a16);
            }
            return a17;
        }
        throw new com.tencent.mtt.hippy.c.b.c(c16);
    }

    private g u() {
        String b16 = b(f.REGEXP, null);
        int c16 = (int) this.f337123a.c();
        if (c16 >= 0) {
            return (g) a((a) new g(b16, c16));
        }
        throw new d(c16);
    }

    private com.tencent.mtt.hippy.runtime.builtins.e v() {
        com.tencent.mtt.hippy.runtime.builtins.e eVar = new com.tencent.mtt.hippy.runtime.builtins.e();
        a((a) eVar);
        if (a(eVar, (byte) 123) == ((int) this.f337123a.c())) {
            return eVar;
        }
        throw new com.tencent.mtt.hippy.b.a("unexpected number of properties");
    }

    private com.tencent.mtt.hippy.runtime.builtins.d w() {
        com.tencent.mtt.hippy.runtime.builtins.d dVar = new com.tencent.mtt.hippy.runtime.builtins.d();
        a((a) dVar);
        HashMap<Object, Object> a16 = dVar.a();
        int i3 = 0;
        while (true) {
            byte f16 = f();
            if (f16 == 58) {
                break;
            }
            i3++;
            Object a17 = a(f16, f.MAP_KEY, (Object) null);
            a16.put(a17, a(f.MAP_VALUE, a17));
        }
        if (i3 * 2 == ((int) this.f337123a.c())) {
            return dVar;
        }
        throw new com.tencent.mtt.hippy.b.a("unexpected number of entries");
    }

    private h x() {
        h hVar = new h();
        a((a) hVar);
        HashSet<Object> a16 = hVar.a();
        int i3 = 0;
        while (true) {
            byte f16 = f();
            if (f16 == 44) {
                break;
            }
            i3++;
            a16.add(a(f16, f.SET_ITEM, (Object) null));
        }
        if (i3 == ((int) this.f337123a.c())) {
            return hVar;
        }
        throw new com.tencent.mtt.hippy.b.a("unexpected number of values");
    }

    private com.tencent.mtt.hippy.runtime.builtins.a.b y() {
        int c16 = (int) this.f337123a.c();
        if (c16 >= 0) {
            com.tencent.mtt.hippy.runtime.builtins.a.b bVar = new com.tencent.mtt.hippy.runtime.builtins.a.b(c16);
            a((a) bVar);
            for (int i3 = 0; i3 < c16; i3++) {
                bVar.c(a(f(), f.DENSE_ARRAY_ITEM, Integer.valueOf(i3)));
            }
            if (a(bVar, (byte) 36) == ((int) this.f337123a.c())) {
                if (c16 == ((int) this.f337123a.c())) {
                    return bVar;
                }
                throw new AssertionError("length ambiguity");
            }
            throw new com.tencent.mtt.hippy.b.a("unexpected number of properties");
        }
        throw new com.tencent.mtt.hippy.c.b.c(c16);
    }

    private com.tencent.mtt.hippy.runtime.builtins.a.c z() {
        long c16 = this.f337123a.c();
        com.tencent.mtt.hippy.runtime.builtins.a.c cVar = new com.tencent.mtt.hippy.runtime.builtins.a.c();
        a((a) cVar);
        if (a(cVar, MaskType.MASK_TYPE_EXTERNAL) == ((int) this.f337123a.c())) {
            if (c16 == this.f337123a.c()) {
                return cVar;
            }
            throw new AssertionError("length ambiguity");
        }
        throw new com.tencent.mtt.hippy.b.a("unexpected number of properties");
    }

    @Override // com.tencent.mtt.hippy.c.c
    public int a() {
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
                this.f337147h = true;
                return super.e();
            }
            throw e17;
        }
    }

    @Override // com.tencent.mtt.hippy.c.e
    protected Object m() {
        return com.tencent.mtt.hippy.runtime.builtins.f.f337627b;
    }

    @Override // com.tencent.mtt.hippy.c.e
    protected Object n() {
        return com.tencent.mtt.hippy.runtime.builtins.f.f337628c;
    }

    @Override // com.tencent.mtt.hippy.c.e
    protected Object o() {
        return com.tencent.mtt.hippy.runtime.builtins.f.f337626a;
    }

    public a(com.tencent.mtt.hippy.c.c.a.a aVar, com.tencent.mtt.hippy.c.e.c cVar, InterfaceC9224a interfaceC9224a) {
        super(aVar, cVar);
        this.f337147h = false;
        this.f337145f = interfaceC9224a;
    }

    private int a(@NonNull com.tencent.mtt.hippy.runtime.builtins.e eVar, byte b16) {
        f fVar;
        f fVar2;
        Object a16;
        String str;
        if (b16 == 36) {
            fVar = f.DENSE_ARRAY_KEY;
            fVar2 = f.DENSE_ARRAY_ITEM;
        } else if (b16 == 64) {
            fVar = f.SPARSE_ARRAY_KEY;
            fVar2 = f.SPARSE_ARRAY_ITEM;
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
            Object a17 = a(f16, fVar, (Object) null);
            if (a17 instanceof Integer) {
                a16 = a(fVar2, a17);
                if (b16 == 64) {
                    ((com.tencent.mtt.hippy.runtime.builtins.a.c) eVar).a(((Integer) a17).intValue(), a16);
                } else {
                    str = String.valueOf(a17);
                }
            } else {
                if (!(a17 instanceof String)) {
                    throw new AssertionError("Object key is not of String nor Integer type");
                }
                a16 = a(fVar2, a17);
                str = (String) a17;
            }
            eVar.a(str, a16);
        }
    }

    private com.tencent.mtt.hippy.runtime.builtins.b<com.tencent.mtt.hippy.runtime.builtins.a> a(com.tencent.mtt.hippy.runtime.builtins.a aVar) {
        b.a aVar2;
        int c16;
        byte f16 = f();
        if (f16 != 86) {
            throw new AssertionError("ArrayBufferViewTag: " + ((int) f16));
        }
        com.tencent.mtt.hippy.c.a p16 = p();
        if (p16 == null) {
            p16 = com.tencent.mtt.hippy.c.a.INT8_ARRAY;
        }
        switch (AnonymousClass2.f337150a[p16.ordinal()]) {
            case 1:
                aVar2 = b.a.DATA_VIEW;
                break;
            case 2:
                aVar2 = b.a.BIGUINT64_ARRAY;
                break;
            case 3:
                aVar2 = b.a.BIGINT64_ARRAY;
                break;
            case 4:
                aVar2 = b.a.FLOAT32_ARRAY;
                break;
            case 5:
                aVar2 = b.a.FLOAT64_ARRAY;
                break;
            case 6:
                aVar2 = b.a.INT8_ARRAY;
                break;
            case 7:
                aVar2 = b.a.INT16_ARRAY;
                break;
            case 8:
                aVar2 = b.a.INT32_ARRAY;
                break;
            case 9:
                aVar2 = b.a.UINT8_ARRAY;
                break;
            case 10:
                aVar2 = b.a.UINT8_CLAMPED_ARRAY;
                break;
            case 11:
                aVar2 = b.a.UINT16_ARRAY;
                break;
            case 12:
                aVar2 = b.a.UINT32_ARRAY;
                break;
            default:
                throw new com.tencent.mtt.hippy.b.b();
        }
        b.a aVar3 = aVar2;
        int c17 = (int) this.f337123a.c();
        if (c17 < 0) {
            throw new d(c17);
        }
        int c18 = (int) this.f337123a.c();
        if (c18 < 0) {
            throw new d(c18);
        }
        if (l() >= 14 || this.f337147h) {
            c16 = (int) this.f337123a.c();
            if (c16 < 0) {
                throw new d(c16);
            }
        } else {
            c16 = 0;
        }
        com.tencent.mtt.hippy.runtime.builtins.b<com.tencent.mtt.hippy.runtime.builtins.a> bVar = new com.tencent.mtt.hippy.runtime.builtins.b<>(aVar, aVar3, c17, c18, c16);
        a((a) bVar);
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mtt.hippy.c.c
    public Object a(byte b16, f fVar, Object obj) {
        Object a16 = super.a(b16, fVar, obj);
        if (a16 != com.tencent.mtt.hippy.c.e.f337159e) {
            return a16;
        }
        if (b16 == 39) {
            return x();
        }
        if (b16 == 59) {
            return w();
        }
        if (b16 == 82) {
            return u();
        }
        if (b16 == 92) {
            return B();
        }
        if (b16 == 97) {
            return z();
        }
        if (b16 == 65) {
            return y();
        }
        if (b16 == 66) {
            return t();
        }
        switch (b16) {
            case 109:
                return G();
            case 110:
                return r();
            case 111:
                return v();
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
                                return s();
                        }
                }
        }
        if (l() >= 13) {
            return this.f337161c;
        }
        this.f337123a.b(-1);
        return B();
    }

    private Object a(boolean z16) {
        return a((a) (z16 ? com.tencent.mtt.hippy.runtime.builtins.b.b.f337605a : com.tencent.mtt.hippy.runtime.builtins.b.b.f337606b));
    }
}
