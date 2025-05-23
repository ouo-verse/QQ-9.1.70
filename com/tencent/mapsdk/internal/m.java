package com.tencent.mapsdk.internal;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    protected String f149295a = "GBK";

    /* renamed from: b, reason: collision with root package name */
    private ByteBuffer f149296b;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public byte f149297a;

        /* renamed from: b, reason: collision with root package name */
        public int f149298b;

        private void a() {
            this.f149297a = (byte) 0;
            this.f149298b = 0;
        }
    }

    public m() {
    }

    private void b(byte[] bArr) {
        a(bArr);
    }

    private Map<String, String> d(int i3, boolean z16) {
        HashMap hashMap = new HashMap();
        if (b(i3)) {
            a aVar = new a();
            a(aVar);
            if (aVar.f149297a == 8) {
                int a16 = a(0, 0, true);
                if (a16 >= 0) {
                    for (int i16 = 0; i16 < a16; i16++) {
                        hashMap.put(b(0, true), b(1, true));
                    }
                } else {
                    throw new j("size invalid: ".concat(String.valueOf(a16)));
                }
            } else {
                throw new j("type mismatch.");
            }
        } else if (z16) {
            throw new j("require field not exist.");
        }
        return hashMap;
    }

    private List e(int i3, boolean z16) {
        ArrayList arrayList = new ArrayList();
        if (b(i3)) {
            a aVar = new a();
            a(aVar);
            if (aVar.f149297a == 9) {
                int a16 = a(0, 0, true);
                if (a16 >= 0) {
                    for (int i16 = 0; i16 < a16; i16++) {
                        a aVar2 = new a();
                        a(aVar2);
                        switch (aVar2.f149297a) {
                            case 0:
                                a(1);
                                break;
                            case 1:
                                a(2);
                                break;
                            case 2:
                                a(4);
                                break;
                            case 3:
                                a(8);
                                break;
                            case 4:
                                a(4);
                                break;
                            case 5:
                                a(8);
                                break;
                            case 6:
                                int i17 = this.f149296b.get();
                                if (i17 < 0) {
                                    i17 += 256;
                                }
                                a(i17);
                                break;
                            case 7:
                                a(this.f149296b.getInt());
                                break;
                            case 8:
                            case 9:
                                break;
                            case 10:
                                try {
                                    p pVar = (p) Class.forName(p.class.getName()).getConstructor(new Class[0]).newInstance(new Object[0]);
                                    pVar.readFrom(this);
                                    a();
                                    arrayList.add(pVar);
                                    break;
                                } catch (Exception e16) {
                                    e16.printStackTrace();
                                    throw new j("type mismatch.".concat(String.valueOf(e16)));
                                }
                            case 11:
                            default:
                                throw new j("type mismatch.");
                            case 12:
                                arrayList.add(0);
                                break;
                        }
                    }
                } else {
                    throw new j("size invalid: ".concat(String.valueOf(a16)));
                }
            } else {
                throw new j("type mismatch.");
            }
        } else if (z16) {
            throw new j("require field not exist.");
        }
        return arrayList;
    }

    private boolean[] f(int i3, boolean z16) {
        if (b(i3)) {
            a aVar = new a();
            a(aVar);
            if (aVar.f149297a == 9) {
                int a16 = a(0, 0, true);
                if (a16 >= 0) {
                    boolean[] zArr = new boolean[a16];
                    for (int i16 = 0; i16 < a16; i16++) {
                        zArr[i16] = a(0, true);
                    }
                    return zArr;
                }
                throw new j("size invalid: ".concat(String.valueOf(a16)));
            }
            throw new j("type mismatch.");
        }
        if (!z16) {
            return null;
        }
        throw new j("require field not exist.");
    }

    private short[] g(int i3, boolean z16) {
        if (b(i3)) {
            a aVar = new a();
            a(aVar);
            if (aVar.f149297a == 9) {
                int a16 = a(0, 0, true);
                if (a16 >= 0) {
                    short[] sArr = new short[a16];
                    for (int i16 = 0; i16 < a16; i16++) {
                        sArr[i16] = a(sArr[0], 0, true);
                    }
                    return sArr;
                }
                throw new j("size invalid: ".concat(String.valueOf(a16)));
            }
            throw new j("type mismatch.");
        }
        if (!z16) {
            return null;
        }
        throw new j("require field not exist.");
    }

    private int[] h(int i3, boolean z16) {
        if (b(i3)) {
            a aVar = new a();
            a(aVar);
            if (aVar.f149297a == 9) {
                int a16 = a(0, 0, true);
                if (a16 >= 0) {
                    int[] iArr = new int[a16];
                    for (int i16 = 0; i16 < a16; i16++) {
                        iArr[i16] = a(iArr[0], 0, true);
                    }
                    return iArr;
                }
                throw new j("size invalid: ".concat(String.valueOf(a16)));
            }
            throw new j("type mismatch.");
        }
        if (!z16) {
            return null;
        }
        throw new j("require field not exist.");
    }

    private long[] i(int i3, boolean z16) {
        if (b(i3)) {
            a aVar = new a();
            a(aVar);
            if (aVar.f149297a == 9) {
                int a16 = a(0, 0, true);
                if (a16 >= 0) {
                    long[] jArr = new long[a16];
                    for (int i16 = 0; i16 < a16; i16++) {
                        jArr[i16] = a(jArr[0], 0, true);
                    }
                    return jArr;
                }
                throw new j("size invalid: ".concat(String.valueOf(a16)));
            }
            throw new j("type mismatch.");
        }
        if (!z16) {
            return null;
        }
        throw new j("require field not exist.");
    }

    private float[] j(int i3, boolean z16) {
        if (b(i3)) {
            a aVar = new a();
            a(aVar);
            if (aVar.f149297a == 9) {
                int a16 = a(0, 0, true);
                if (a16 >= 0) {
                    float[] fArr = new float[a16];
                    for (int i16 = 0; i16 < a16; i16++) {
                        fArr[i16] = a(fArr[0], 0, true);
                    }
                    return fArr;
                }
                throw new j("size invalid: ".concat(String.valueOf(a16)));
            }
            throw new j("type mismatch.");
        }
        if (!z16) {
            return null;
        }
        throw new j("require field not exist.");
    }

    private double[] k(int i3, boolean z16) {
        if (b(i3)) {
            a aVar = new a();
            a(aVar);
            if (aVar.f149297a == 9) {
                int a16 = a(0, 0, true);
                if (a16 >= 0) {
                    double[] dArr = new double[a16];
                    for (int i16 = 0; i16 < a16; i16++) {
                        dArr[i16] = a(dArr[0], 0, true);
                    }
                    return dArr;
                }
                throw new j("size invalid: ".concat(String.valueOf(a16)));
            }
            throw new j("type mismatch.");
        }
        if (!z16) {
            return null;
        }
        throw new j("require field not exist.");
    }

    public final void a(byte[] bArr) {
        this.f149296b = ByteBuffer.wrap(bArr);
    }

    public final byte[] c(int i3, boolean z16) {
        if (!b(i3)) {
            if (z16) {
                throw new j("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        a(aVar);
        byte b16 = aVar.f149297a;
        if (b16 == 9) {
            int a16 = a(0, 0, true);
            if (a16 >= 0 && a16 <= this.f149296b.capacity()) {
                byte[] bArr = new byte[a16];
                for (int i16 = 0; i16 < a16; i16++) {
                    bArr[i16] = a(bArr[0], 0, true);
                }
                return bArr;
            }
            throw new j("size invalid: ".concat(String.valueOf(a16)));
        }
        if (b16 == 13) {
            a aVar2 = new a();
            a(aVar2);
            if (aVar2.f149297a == 0) {
                int a17 = a(0, 0, true);
                if (a17 >= 0 && a17 <= this.f149296b.capacity()) {
                    byte[] bArr2 = new byte[a17];
                    this.f149296b.get(bArr2);
                    return bArr2;
                }
                throw new j("invalid size, tag: " + i3 + ", type: " + ((int) aVar.f149297a) + ", " + ((int) aVar2.f149297a) + ", size: " + a17);
            }
            throw new j("type mismatch, tag: " + i3 + ", type: " + ((int) aVar.f149297a) + ", " + ((int) aVar2.f149297a));
        }
        throw new j("type mismatch.");
    }

    private static int a(a aVar, ByteBuffer byteBuffer) {
        byte b16 = byteBuffer.get();
        aVar.f149297a = (byte) (b16 & RegisterType.DOUBLE_HI);
        int i3 = (b16 & 240) >> 4;
        aVar.f149298b = i3;
        if (i3 != 15) {
            return 1;
        }
        aVar.f149298b = byteBuffer.get() & 255;
        return 2;
    }

    private int b(a aVar) {
        return a(aVar, this.f149296b.duplicate());
    }

    m(ByteBuffer byteBuffer) {
        this.f149296b = byteBuffer;
    }

    private boolean b(int i3) {
        a aVar;
        int i16;
        try {
            aVar = new a();
            while (true) {
                int a16 = a(aVar, this.f149296b.duplicate());
                i16 = aVar.f149298b;
                if (i3 <= i16 || aVar.f149297a == 11) {
                    break;
                }
                a(a16);
                a(aVar.f149297a);
            }
        } catch (j | BufferUnderflowException unused) {
        }
        return aVar.f149297a != 11 && i3 == i16;
    }

    public m(byte[] bArr) {
        this.f149296b = ByteBuffer.wrap(bArr);
    }

    private void a(a aVar) {
        a(aVar, this.f149296b);
    }

    private void a(int i3) {
        ByteBuffer byteBuffer = this.f149296b;
        byteBuffer.position(byteBuffer.position() + i3);
    }

    private void a() {
        a aVar = new a();
        do {
            a(aVar);
            a(aVar.f149297a);
        } while (aVar.f149297a != 11);
    }

    public m(byte[] bArr, byte b16) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        this.f149296b = wrap;
        wrap.position(4);
    }

    private void b() {
        a aVar = new a();
        a(aVar);
        a(aVar.f149297a);
    }

    private void a(byte b16) {
        int i3 = 0;
        switch (b16) {
            case 0:
                a(1);
                return;
            case 1:
                a(2);
                return;
            case 2:
                a(4);
                return;
            case 3:
                a(8);
                return;
            case 4:
                a(4);
                return;
            case 5:
                a(8);
                return;
            case 6:
                int i16 = this.f149296b.get();
                if (i16 < 0) {
                    i16 += 256;
                }
                a(i16);
                return;
            case 7:
                a(this.f149296b.getInt());
                return;
            case 8:
                int a16 = a(0, 0, true);
                while (i3 < a16 * 2) {
                    b();
                    i3++;
                }
                return;
            case 9:
                int a17 = a(0, 0, true);
                while (i3 < a17) {
                    b();
                    i3++;
                }
                return;
            case 10:
                a();
                return;
            case 11:
            case 12:
                return;
            case 13:
                a aVar = new a();
                a(aVar);
                if (aVar.f149297a == 0) {
                    a(a(0, 0, true));
                    return;
                }
                throw new j("skipField with invalid type, type value: " + ((int) b16) + ", " + ((int) aVar.f149297a));
            default:
                throw new j("invalid type.");
        }
    }

    private String b(String str, int i3, boolean z16) {
        String str2;
        if (!b(i3)) {
            if (z16) {
                throw new j("require field not exist.");
            }
            return str;
        }
        a aVar = new a();
        a(aVar);
        byte b16 = aVar.f149297a;
        if (b16 == 6) {
            int i16 = this.f149296b.get();
            if (i16 < 0) {
                i16 += 256;
            }
            byte[] bArr = new byte[i16];
            this.f149296b.get(bArr);
            try {
                str2 = new String(bArr, this.f149295a);
            } catch (UnsupportedEncodingException unused) {
                str2 = new String(bArr);
            }
        } else if (b16 == 7) {
            int i17 = this.f149296b.getInt();
            if (i17 <= 104857600 && i17 >= 0 && i17 <= this.f149296b.capacity()) {
                byte[] bArr2 = new byte[i17];
                this.f149296b.get(bArr2);
                try {
                    str2 = new String(bArr2, this.f149295a);
                } catch (UnsupportedEncodingException unused2) {
                    str2 = new String(bArr2);
                }
            } else {
                throw new j("String too long: ".concat(String.valueOf(i17)));
            }
        } else {
            throw new j("type mismatch.");
        }
        return str2;
    }

    private ByteBuffer c() {
        return this.f149296b;
    }

    public final String b(int i3, boolean z16) {
        if (!b(i3)) {
            if (z16) {
                throw new j("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        a(aVar);
        byte b16 = aVar.f149297a;
        if (b16 == 6) {
            int i16 = this.f149296b.get();
            if (i16 < 0) {
                i16 += 256;
            }
            byte[] bArr = new byte[i16];
            this.f149296b.get(bArr);
            try {
                return new String(bArr, this.f149295a);
            } catch (UnsupportedEncodingException unused) {
                return new String(bArr);
            }
        }
        if (b16 == 7) {
            int i17 = this.f149296b.getInt();
            if (i17 <= 104857600 && i17 >= 0 && i17 <= this.f149296b.capacity()) {
                byte[] bArr2 = new byte[i17];
                this.f149296b.get(bArr2);
                try {
                    return new String(bArr2, this.f149295a);
                } catch (UnsupportedEncodingException unused2) {
                    return new String(bArr2);
                }
            }
            throw new j("String too long: ".concat(String.valueOf(i17)));
        }
        throw new j("type mismatch.");
    }

    public final boolean a(int i3, boolean z16) {
        return a((byte) 0, i3, z16) != 0;
    }

    public final byte a(byte b16, int i3, boolean z16) {
        if (!b(i3)) {
            if (z16) {
                throw new j("require field not exist.");
            }
            return b16;
        }
        a aVar = new a();
        a(aVar);
        byte b17 = aVar.f149297a;
        if (b17 == 0) {
            return this.f149296b.get();
        }
        if (b17 == 12) {
            return (byte) 0;
        }
        throw new j("type mismatch.");
    }

    public final short a(short s16, int i3, boolean z16) {
        if (!b(i3)) {
            if (z16) {
                throw new j("require field not exist.");
            }
            return s16;
        }
        a aVar = new a();
        a(aVar);
        byte b16 = aVar.f149297a;
        if (b16 == 0) {
            return this.f149296b.get();
        }
        if (b16 == 1) {
            return this.f149296b.getShort();
        }
        if (b16 == 12) {
            return (short) 0;
        }
        throw new j("type mismatch.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T> T[] b(T t16, int i3, boolean z16) {
        if (!b(i3)) {
            if (z16) {
                throw new j("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        a(aVar);
        if (aVar.f149297a == 9) {
            int a16 = a(0, 0, true);
            if (a16 >= 0) {
                T[] tArr = (T[]) ((Object[]) Array.newInstance(t16.getClass(), a16));
                for (int i16 = 0; i16 < a16; i16++) {
                    tArr[i16] = a((m) t16, 0, true);
                }
                return tArr;
            }
            throw new j("size invalid: ".concat(String.valueOf(a16)));
        }
        throw new j("type mismatch.");
    }

    public final int a(int i3, int i16, boolean z16) {
        if (!b(i16)) {
            if (z16) {
                throw new j("require field not exist.");
            }
            return i3;
        }
        a aVar = new a();
        a(aVar);
        byte b16 = aVar.f149297a;
        if (b16 == 0) {
            return this.f149296b.get();
        }
        if (b16 == 1) {
            return this.f149296b.getShort();
        }
        if (b16 == 2) {
            return this.f149296b.getInt();
        }
        if (b16 == 12) {
            return 0;
        }
        throw new j("type mismatch.");
    }

    public final long a(long j3, int i3, boolean z16) {
        int i16;
        if (!b(i3)) {
            if (z16) {
                throw new j("require field not exist.");
            }
            return j3;
        }
        a aVar = new a();
        a(aVar);
        byte b16 = aVar.f149297a;
        if (b16 == 0) {
            i16 = this.f149296b.get();
        } else if (b16 == 1) {
            i16 = this.f149296b.getShort();
        } else {
            if (b16 != 2) {
                if (b16 == 3) {
                    return this.f149296b.getLong();
                }
                if (b16 == 12) {
                    return 0L;
                }
                throw new j("type mismatch.");
            }
            i16 = this.f149296b.getInt();
        }
        return i16;
    }

    public final float a(float f16, int i3, boolean z16) {
        if (!b(i3)) {
            if (z16) {
                throw new j("require field not exist.");
            }
            return f16;
        }
        a aVar = new a();
        a(aVar);
        byte b16 = aVar.f149297a;
        if (b16 == 4) {
            return this.f149296b.getFloat();
        }
        if (b16 == 12) {
            return 0.0f;
        }
        throw new j("type mismatch.");
    }

    public final double a(double d16, int i3, boolean z16) {
        if (!b(i3)) {
            if (z16) {
                throw new j("require field not exist.");
            }
            return d16;
        }
        a aVar = new a();
        a(aVar);
        byte b16 = aVar.f149297a;
        if (b16 == 4) {
            return this.f149296b.getFloat();
        }
        if (b16 == 5) {
            return this.f149296b.getDouble();
        }
        if (b16 == 12) {
            return 0.0d;
        }
        throw new j("type mismatch.");
    }

    private String a(String str, int i3, boolean z16) {
        if (!b(i3)) {
            if (z16) {
                throw new j("require field not exist.");
            }
            return str;
        }
        a aVar = new a();
        a(aVar);
        byte b16 = aVar.f149297a;
        if (b16 == 6) {
            int i16 = this.f149296b.get();
            if (i16 < 0) {
                i16 += 256;
            }
            byte[] bArr = new byte[i16];
            this.f149296b.get(bArr);
            return i.a(bArr);
        }
        if (b16 == 7) {
            int i17 = this.f149296b.getInt();
            if (i17 <= 104857600 && i17 >= 0 && i17 <= this.f149296b.capacity()) {
                byte[] bArr2 = new byte[i17];
                this.f149296b.get(bArr2);
                return i.a(bArr2);
            }
            throw new j("String too long: ".concat(String.valueOf(i17)));
        }
        throw new j("type mismatch.");
    }

    private String[] a(String[] strArr, int i3, boolean z16) {
        return (String[]) a((Object[]) strArr, i3, z16);
    }

    public final <K, V> HashMap<K, V> a(Map<K, V> map, int i3, boolean z16) {
        return (HashMap) a(new HashMap(), map, i3, z16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <K, V> Map<K, V> a(Map<K, V> map, Map<K, V> map2, int i3, boolean z16) {
        if (map2 != null && !map2.isEmpty()) {
            Map.Entry<K, V> next = map2.entrySet().iterator().next();
            K key = next.getKey();
            V value = next.getValue();
            if (b(i3)) {
                a aVar = new a();
                a(aVar);
                if (aVar.f149297a == 8) {
                    int a16 = a(0, 0, true);
                    if (a16 < 0) {
                        throw new j("size invalid: ".concat(String.valueOf(a16)));
                    }
                    for (int i16 = 0; i16 < a16; i16++) {
                        map.put(a((m) key, 0, true), a((m) value, 1, true));
                    }
                } else {
                    throw new j("type mismatch.");
                }
            } else if (z16) {
                throw new j("require field not exist.");
            }
            return map;
        }
        return new HashMap();
    }

    private <T> T[] a(T[] tArr, int i3, boolean z16) {
        if (tArr != null && tArr.length != 0) {
            return (T[]) b((m) tArr[0], i3, z16);
        }
        throw new j("unable to get type of key and value.");
    }

    private <T> List<T> a(List<T> list, int i3, boolean z16) {
        if (list != null && !list.isEmpty()) {
            Object[] b16 = b((m) list.get(0), i3, z16);
            if (b16 == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Object obj : b16) {
                arrayList.add(obj);
            }
            return arrayList;
        }
        return new ArrayList();
    }

    public final p a(p pVar) {
        if (b(0)) {
            try {
                p newInit = pVar.newInit();
                a aVar = new a();
                a(aVar);
                if (aVar.f149297a == 10) {
                    newInit.readFrom(this);
                    a();
                    return newInit;
                }
                throw new j("type mismatch.");
            } catch (Exception e16) {
                throw new j(e16.getMessage());
            }
        }
        throw new j("require field not exist.");
    }

    public final p a(p pVar, int i3, boolean z16) {
        if (!b(i3)) {
            if (z16) {
                throw new j("require field not exist.");
            }
            return null;
        }
        try {
            p pVar2 = (p) pVar.getClass().newInstance();
            a aVar = new a();
            a(aVar);
            if (aVar.f149297a == 10) {
                pVar2.readFrom(this);
                a();
                return pVar2;
            }
            throw new j("type mismatch.");
        } catch (Exception e16) {
            throw new j(e16.getMessage());
        }
    }

    private p[] a(p[] pVarArr, int i3, boolean z16) {
        return (p[]) a((Object[]) pVarArr, i3, z16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> Object a(T t16, int i3, boolean z16) {
        if (t16 instanceof Byte) {
            return Byte.valueOf(a((byte) 0, i3, z16));
        }
        if (t16 instanceof Boolean) {
            return Boolean.valueOf(a(i3, z16));
        }
        if (t16 instanceof Short) {
            return Short.valueOf(a((short) 0, i3, z16));
        }
        if (t16 instanceof Integer) {
            return Integer.valueOf(a(0, i3, z16));
        }
        if (t16 instanceof Long) {
            return Long.valueOf(a(0L, i3, z16));
        }
        if (t16 instanceof Float) {
            return Float.valueOf(a(0.0f, i3, z16));
        }
        if (t16 instanceof Double) {
            return Double.valueOf(a(0.0d, i3, z16));
        }
        if (t16 instanceof String) {
            return b(i3, z16);
        }
        if (t16 instanceof Map) {
            return a((Map) t16, i3, z16);
        }
        if (t16 instanceof List) {
            return a((List) t16, i3, z16);
        }
        if (t16 instanceof p) {
            return a((p) t16, i3, z16);
        }
        if (t16.getClass().isArray()) {
            if (!(t16 instanceof byte[]) && !(t16 instanceof Byte[])) {
                if (t16 instanceof boolean[]) {
                    return f(i3, z16);
                }
                if (t16 instanceof short[]) {
                    return g(i3, z16);
                }
                if (t16 instanceof int[]) {
                    return h(i3, z16);
                }
                if (t16 instanceof long[]) {
                    return i(i3, z16);
                }
                if (t16 instanceof float[]) {
                    return j(i3, z16);
                }
                if (t16 instanceof double[]) {
                    return k(i3, z16);
                }
                return a((Object[]) t16, i3, z16);
            }
            return c(i3, z16);
        }
        throw new j("read object error: unsupport type.");
    }

    public final int a(String str) {
        this.f149295a = str;
        return 0;
    }
}
