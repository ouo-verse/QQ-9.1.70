package com.tencent.bugly.proguard;

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
/* loaded from: classes5.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    protected String f98518a = "GBK";

    /* renamed from: b, reason: collision with root package name */
    private ByteBuffer f98519b;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public byte f98520a;

        /* renamed from: b, reason: collision with root package name */
        public int f98521b;
    }

    public k() {
    }

    private boolean b(int i3) {
        int i16;
        try {
            a aVar = new a();
            while (true) {
                int a16 = a(aVar, this.f98519b.duplicate());
                i16 = aVar.f98521b;
                if (i3 <= i16 || aVar.f98520a == 11) {
                    break;
                }
                a(a16);
                a(aVar.f98520a);
            }
        } catch (h | BufferUnderflowException unused) {
        }
        return i3 == i16;
    }

    private boolean[] d(int i3, boolean z16) {
        if (b(i3)) {
            a aVar = new a();
            a(aVar);
            if (aVar.f98520a == 9) {
                int a16 = a(0, 0, true);
                if (a16 >= 0) {
                    boolean[] zArr = new boolean[a16];
                    for (int i16 = 0; i16 < a16; i16++) {
                        zArr[i16] = a(0, true);
                    }
                    return zArr;
                }
                throw new h("size invalid: ".concat(String.valueOf(a16)));
            }
            throw new h("type mismatch.");
        }
        if (!z16) {
            return null;
        }
        throw new h("require field not exist.");
    }

    private short[] e(int i3, boolean z16) {
        if (b(i3)) {
            a aVar = new a();
            a(aVar);
            if (aVar.f98520a == 9) {
                int a16 = a(0, 0, true);
                if (a16 >= 0) {
                    short[] sArr = new short[a16];
                    for (int i16 = 0; i16 < a16; i16++) {
                        sArr[i16] = a(sArr[0], 0, true);
                    }
                    return sArr;
                }
                throw new h("size invalid: ".concat(String.valueOf(a16)));
            }
            throw new h("type mismatch.");
        }
        if (!z16) {
            return null;
        }
        throw new h("require field not exist.");
    }

    private int[] f(int i3, boolean z16) {
        if (b(i3)) {
            a aVar = new a();
            a(aVar);
            if (aVar.f98520a == 9) {
                int a16 = a(0, 0, true);
                if (a16 >= 0) {
                    int[] iArr = new int[a16];
                    for (int i16 = 0; i16 < a16; i16++) {
                        iArr[i16] = a(iArr[0], 0, true);
                    }
                    return iArr;
                }
                throw new h("size invalid: ".concat(String.valueOf(a16)));
            }
            throw new h("type mismatch.");
        }
        if (!z16) {
            return null;
        }
        throw new h("require field not exist.");
    }

    private long[] g(int i3, boolean z16) {
        if (b(i3)) {
            a aVar = new a();
            a(aVar);
            if (aVar.f98520a == 9) {
                int a16 = a(0, 0, true);
                if (a16 >= 0) {
                    long[] jArr = new long[a16];
                    for (int i16 = 0; i16 < a16; i16++) {
                        jArr[i16] = a(jArr[0], 0, true);
                    }
                    return jArr;
                }
                throw new h("size invalid: ".concat(String.valueOf(a16)));
            }
            throw new h("type mismatch.");
        }
        if (!z16) {
            return null;
        }
        throw new h("require field not exist.");
    }

    private float[] h(int i3, boolean z16) {
        if (b(i3)) {
            a aVar = new a();
            a(aVar);
            if (aVar.f98520a == 9) {
                int a16 = a(0, 0, true);
                if (a16 >= 0) {
                    float[] fArr = new float[a16];
                    for (int i16 = 0; i16 < a16; i16++) {
                        fArr[i16] = a(fArr[0], 0, true);
                    }
                    return fArr;
                }
                throw new h("size invalid: ".concat(String.valueOf(a16)));
            }
            throw new h("type mismatch.");
        }
        if (!z16) {
            return null;
        }
        throw new h("require field not exist.");
    }

    private double[] i(int i3, boolean z16) {
        if (b(i3)) {
            a aVar = new a();
            a(aVar);
            if (aVar.f98520a == 9) {
                int a16 = a(0, 0, true);
                if (a16 >= 0) {
                    double[] dArr = new double[a16];
                    for (int i16 = 0; i16 < a16; i16++) {
                        dArr[i16] = a(dArr[0], 0, true);
                    }
                    return dArr;
                }
                throw new h("size invalid: ".concat(String.valueOf(a16)));
            }
            throw new h("type mismatch.");
        }
        if (!z16) {
            return null;
        }
        throw new h("require field not exist.");
    }

    public final void a(byte[] bArr) {
        ByteBuffer byteBuffer = this.f98519b;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
        this.f98519b = ByteBuffer.wrap(bArr);
    }

    public final byte[] c(int i3, boolean z16) {
        if (b(i3)) {
            a aVar = new a();
            a(aVar);
            byte b16 = aVar.f98520a;
            if (b16 != 9) {
                if (b16 == 13) {
                    a aVar2 = new a();
                    a(aVar2);
                    if (aVar2.f98520a == 0) {
                        int a16 = a(0, 0, true);
                        if (a16 >= 0) {
                            byte[] bArr = new byte[a16];
                            this.f98519b.get(bArr);
                            return bArr;
                        }
                        throw new h("invalid size, tag: " + i3 + ", type: " + ((int) aVar.f98520a) + ", " + ((int) aVar2.f98520a) + ", size: " + a16);
                    }
                    throw new h("type mismatch, tag: " + i3 + ", type: " + ((int) aVar.f98520a) + ", " + ((int) aVar2.f98520a));
                }
                throw new h("type mismatch.");
            }
            int a17 = a(0, 0, true);
            if (a17 >= 0) {
                byte[] bArr2 = new byte[a17];
                for (int i16 = 0; i16 < a17; i16++) {
                    bArr2[i16] = a(bArr2[0], 0, true);
                }
                return bArr2;
            }
            throw new h("size invalid: ".concat(String.valueOf(a17)));
        }
        if (!z16) {
            return null;
        }
        throw new h("require field not exist.");
    }

    public k(byte[] bArr) {
        this.f98519b = ByteBuffer.wrap(bArr);
    }

    private static int a(a aVar, ByteBuffer byteBuffer) {
        byte b16 = byteBuffer.get();
        aVar.f98520a = (byte) (b16 & RegisterType.DOUBLE_HI);
        int i3 = (b16 & 240) >> 4;
        aVar.f98521b = i3;
        if (i3 != 15) {
            return 1;
        }
        aVar.f98521b = byteBuffer.get();
        return 2;
    }

    public k(byte[] bArr, byte b16) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        this.f98519b = wrap;
        wrap.position(4);
    }

    private void b() {
        a aVar = new a();
        a(aVar);
        a(aVar.f98520a);
    }

    private void a(a aVar) {
        a(aVar, this.f98519b);
    }

    private void a(int i3) {
        ByteBuffer byteBuffer = this.f98519b;
        byteBuffer.position(byteBuffer.position() + i3);
    }

    public final String b(int i3, boolean z16) {
        if (!b(i3)) {
            if (z16) {
                throw new h("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        a(aVar);
        byte b16 = aVar.f98520a;
        if (b16 == 6) {
            int i16 = this.f98519b.get();
            if (i16 < 0) {
                i16 += 256;
            }
            byte[] bArr = new byte[i16];
            this.f98519b.get(bArr);
            try {
                return new String(bArr, this.f98518a);
            } catch (UnsupportedEncodingException unused) {
                return new String(bArr);
            }
        }
        if (b16 == 7) {
            int i17 = this.f98519b.getInt();
            if (i17 <= 104857600 && i17 >= 0) {
                byte[] bArr2 = new byte[i17];
                this.f98519b.get(bArr2);
                try {
                    return new String(bArr2, this.f98518a);
                } catch (UnsupportedEncodingException unused2) {
                    return new String(bArr2);
                }
            }
            throw new h("String too long: ".concat(String.valueOf(i17)));
        }
        throw new h("type mismatch.");
    }

    private void a() {
        a aVar = new a();
        do {
            a(aVar);
            a(aVar.f98520a);
        } while (aVar.f98520a != 11);
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
                int i16 = this.f98519b.get();
                if (i16 < 0) {
                    i16 += 256;
                }
                a(i16);
                return;
            case 7:
                a(this.f98519b.getInt());
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
                if (aVar.f98520a == 0) {
                    a(a(0, 0, true));
                    return;
                }
                throw new h("skipField with invalid type, type value: " + ((int) b16) + ", " + ((int) aVar.f98520a));
            default:
                throw new h("invalid type.");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T> T[] b(T t16, int i3, boolean z16) {
        if (!b(i3)) {
            if (z16) {
                throw new h("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        a(aVar);
        if (aVar.f98520a == 9) {
            int a16 = a(0, 0, true);
            if (a16 >= 0) {
                T[] tArr = (T[]) ((Object[]) Array.newInstance(t16.getClass(), a16));
                for (int i16 = 0; i16 < a16; i16++) {
                    tArr[i16] = a((k) t16, 0, true);
                }
                return tArr;
            }
            throw new h("size invalid: ".concat(String.valueOf(a16)));
        }
        throw new h("type mismatch.");
    }

    public final boolean a(int i3, boolean z16) {
        return a((byte) 0, i3, z16) != 0;
    }

    public final byte a(byte b16, int i3, boolean z16) {
        if (!b(i3)) {
            if (z16) {
                throw new h("require field not exist.");
            }
            return b16;
        }
        a aVar = new a();
        a(aVar);
        byte b17 = aVar.f98520a;
        if (b17 == 0) {
            return this.f98519b.get();
        }
        if (b17 == 12) {
            return (byte) 0;
        }
        throw new h("type mismatch.");
    }

    public final short a(short s16, int i3, boolean z16) {
        if (!b(i3)) {
            if (z16) {
                throw new h("require field not exist.");
            }
            return s16;
        }
        a aVar = new a();
        a(aVar);
        byte b16 = aVar.f98520a;
        if (b16 == 0) {
            return this.f98519b.get();
        }
        if (b16 == 1) {
            return this.f98519b.getShort();
        }
        if (b16 == 12) {
            return (short) 0;
        }
        throw new h("type mismatch.");
    }

    public final int a(int i3, int i16, boolean z16) {
        if (!b(i16)) {
            if (z16) {
                throw new h("require field not exist.");
            }
            return i3;
        }
        a aVar = new a();
        a(aVar);
        byte b16 = aVar.f98520a;
        if (b16 == 0) {
            return this.f98519b.get();
        }
        if (b16 == 1) {
            return this.f98519b.getShort();
        }
        if (b16 == 2) {
            return this.f98519b.getInt();
        }
        if (b16 == 12) {
            return 0;
        }
        throw new h("type mismatch.");
    }

    public final long a(long j3, int i3, boolean z16) {
        int i16;
        if (!b(i3)) {
            if (z16) {
                throw new h("require field not exist.");
            }
            return j3;
        }
        a aVar = new a();
        a(aVar);
        byte b16 = aVar.f98520a;
        if (b16 == 0) {
            i16 = this.f98519b.get();
        } else if (b16 == 1) {
            i16 = this.f98519b.getShort();
        } else {
            if (b16 != 2) {
                if (b16 == 3) {
                    return this.f98519b.getLong();
                }
                if (b16 == 12) {
                    return 0L;
                }
                throw new h("type mismatch.");
            }
            i16 = this.f98519b.getInt();
        }
        return i16;
    }

    private float a(float f16, int i3, boolean z16) {
        if (!b(i3)) {
            if (z16) {
                throw new h("require field not exist.");
            }
            return f16;
        }
        a aVar = new a();
        a(aVar);
        byte b16 = aVar.f98520a;
        if (b16 == 4) {
            return this.f98519b.getFloat();
        }
        if (b16 == 12) {
            return 0.0f;
        }
        throw new h("type mismatch.");
    }

    private double a(double d16, int i3, boolean z16) {
        if (!b(i3)) {
            if (z16) {
                throw new h("require field not exist.");
            }
            return d16;
        }
        a aVar = new a();
        a(aVar);
        byte b16 = aVar.f98520a;
        if (b16 == 4) {
            return this.f98519b.getFloat();
        }
        if (b16 == 5) {
            return this.f98519b.getDouble();
        }
        if (b16 == 12) {
            return 0.0d;
        }
        throw new h("type mismatch.");
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
                if (aVar.f98520a == 8) {
                    int a16 = a(0, 0, true);
                    if (a16 < 0) {
                        throw new h("size invalid: ".concat(String.valueOf(a16)));
                    }
                    for (int i16 = 0; i16 < a16; i16++) {
                        map.put(a((k) key, 0, true), a((k) value, 1, true));
                    }
                } else {
                    throw new h("type mismatch.");
                }
            } else if (z16) {
                throw new h("require field not exist.");
            }
            return map;
        }
        return new HashMap();
    }

    private <T> T[] a(T[] tArr, int i3, boolean z16) {
        if (tArr != null && tArr.length != 0) {
            return (T[]) b(tArr[0], i3, z16);
        }
        throw new h("unable to get type of key and value.");
    }

    private <T> List<T> a(List<T> list, int i3, boolean z16) {
        if (list != null && !list.isEmpty()) {
            Object[] b16 = b(list.get(0), i3, z16);
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

    public final m a(m mVar, int i3, boolean z16) {
        if (!b(i3)) {
            if (z16) {
                throw new h("require field not exist.");
            }
            return null;
        }
        try {
            m mVar2 = (m) mVar.getClass().newInstance();
            a aVar = new a();
            a(aVar);
            if (aVar.f98520a == 10) {
                mVar2.a(this);
                a();
                return mVar2;
            }
            throw new h("type mismatch.");
        } catch (Exception e16) {
            throw new h(e16.getMessage());
        }
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
            return String.valueOf(b(i3, z16));
        }
        if (t16 instanceof Map) {
            return a((Map) t16, i3, z16);
        }
        if (t16 instanceof List) {
            return a((List) t16, i3, z16);
        }
        if (t16 instanceof m) {
            return a((m) t16, i3, z16);
        }
        if (t16.getClass().isArray()) {
            if (!(t16 instanceof byte[]) && !(t16 instanceof Byte[])) {
                if (t16 instanceof boolean[]) {
                    return d(i3, z16);
                }
                if (t16 instanceof short[]) {
                    return e(i3, z16);
                }
                if (t16 instanceof int[]) {
                    return f(i3, z16);
                }
                if (t16 instanceof long[]) {
                    return g(i3, z16);
                }
                if (t16 instanceof float[]) {
                    return h(i3, z16);
                }
                if (t16 instanceof double[]) {
                    return i(i3, z16);
                }
                return a((Object[]) t16, i3, z16);
            }
            return c(i3, z16);
        }
        throw new h("read object error: unsupport type.");
    }

    public final int a(String str) {
        this.f98518a = str;
        return 0;
    }
}
