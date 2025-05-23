package com.tencent.beacon.pack;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    protected String f78095a = "GBK";

    /* renamed from: b, reason: collision with root package name */
    private ByteBuffer f78096b;

    /* compiled from: P */
    /* renamed from: com.tencent.beacon.pack.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0788a {

        /* renamed from: a, reason: collision with root package name */
        public byte f78097a;

        /* renamed from: b, reason: collision with root package name */
        public int f78098b;
    }

    public a() {
    }

    public static int a(C0788a c0788a, ByteBuffer byteBuffer) {
        byte b16 = byteBuffer.get();
        c0788a.f78097a = (byte) (b16 & RegisterType.DOUBLE_HI);
        int i3 = (b16 & 240) >> 4;
        c0788a.f78098b = i3;
        if (i3 != 15) {
            return 1;
        }
        c0788a.f78098b = byteBuffer.get() & 255;
        return 2;
    }

    private int b(C0788a c0788a) {
        return a(c0788a, this.f78096b.duplicate());
    }

    private void b(int i3) {
        ByteBuffer byteBuffer = this.f78096b;
        byteBuffer.position(byteBuffer.position() + i3);
    }

    public a(byte[] bArr) {
        this.f78096b = ByteBuffer.wrap(bArr);
    }

    private void b() {
        C0788a c0788a = new C0788a();
        a(c0788a);
        a(c0788a.f78097a);
    }

    public void a(C0788a c0788a) {
        a(c0788a, this.f78096b);
    }

    public a(byte[] bArr, int i3) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        this.f78096b = wrap;
        wrap.position(i3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T> T[] b(T t16, int i3, boolean z16) {
        if (!a(i3)) {
            if (z16) {
                throw new RuntimeException("require field not exist.");
            }
            return null;
        }
        C0788a c0788a = new C0788a();
        a(c0788a);
        if (c0788a.f78097a == 9) {
            int a16 = a(0, 0, true);
            if (a16 >= 0) {
                T[] tArr = (T[]) ((Object[]) Array.newInstance(t16.getClass(), a16));
                for (int i16 = 0; i16 < a16; i16++) {
                    tArr[i16] = a((a) t16, 0, true);
                }
                return tArr;
            }
            throw new RuntimeException("size invalid: " + a16);
        }
        throw new RuntimeException("type mismatch.");
    }

    public void a(byte[] bArr) {
        this.f78096b = ByteBuffer.wrap(bArr);
    }

    public boolean a(int i3) {
        try {
            C0788a c0788a = new C0788a();
            while (true) {
                int b16 = b(c0788a);
                if (c0788a.f78097a == 11) {
                    return false;
                }
                int i16 = c0788a.f78098b;
                if (i3 <= i16) {
                    return i3 == i16;
                }
                b(b16);
                a(c0788a.f78097a);
            }
        } catch (BufferUnderflowException e16) {
            com.tencent.beacon.base.util.c.a(e16);
            return false;
        } catch (RuntimeException e17) {
            com.tencent.beacon.base.util.c.a(e17);
            return false;
        }
    }

    public void a() {
        C0788a c0788a = new C0788a();
        do {
            a(c0788a);
            a(c0788a.f78097a);
        } while (c0788a.f78097a != 11);
    }

    private void a(byte b16) {
        int i3 = 0;
        switch (b16) {
            case 0:
                b(1);
                return;
            case 1:
                b(2);
                return;
            case 2:
                b(4);
                return;
            case 3:
                b(8);
                return;
            case 4:
                b(4);
                return;
            case 5:
                b(8);
                return;
            case 6:
                int i16 = this.f78096b.get();
                if (i16 < 0) {
                    i16 += 256;
                }
                b(i16);
                return;
            case 7:
                b(this.f78096b.getInt());
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
                C0788a c0788a = new C0788a();
                a(c0788a);
                if (c0788a.f78097a == 0) {
                    b(a(0, 0, true));
                    return;
                }
                throw new RuntimeException("skipField with invalid type, type value: " + ((int) b16) + ", " + ((int) c0788a.f78097a));
            default:
                throw new RuntimeException("invalid type.");
        }
    }

    public boolean a(boolean z16, int i3, boolean z17) {
        return a((byte) 0, i3, z17) != 0;
    }

    public byte a(byte b16, int i3, boolean z16) {
        if (!a(i3)) {
            if (z16) {
                throw new RuntimeException("require field not exist.");
            }
            return b16;
        }
        C0788a c0788a = new C0788a();
        a(c0788a);
        byte b17 = c0788a.f78097a;
        if (b17 == 0) {
            return this.f78096b.get();
        }
        if (b17 == 12) {
            return (byte) 0;
        }
        throw new RuntimeException("type mismatch.");
    }

    public short a(short s16, int i3, boolean z16) {
        if (!a(i3)) {
            if (z16) {
                throw new RuntimeException("require field not exist.");
            }
            return s16;
        }
        C0788a c0788a = new C0788a();
        a(c0788a);
        byte b16 = c0788a.f78097a;
        if (b16 == 0) {
            return this.f78096b.get();
        }
        if (b16 == 1) {
            return this.f78096b.getShort();
        }
        if (b16 == 12) {
            return (short) 0;
        }
        throw new RuntimeException("type mismatch.");
    }

    public int a(int i3, int i16, boolean z16) {
        if (!a(i16)) {
            if (z16) {
                throw new RuntimeException("require field not exist.");
            }
            return i3;
        }
        C0788a c0788a = new C0788a();
        a(c0788a);
        byte b16 = c0788a.f78097a;
        if (b16 == 0) {
            return this.f78096b.get();
        }
        if (b16 == 1) {
            return this.f78096b.getShort();
        }
        if (b16 == 2) {
            return this.f78096b.getInt();
        }
        if (b16 == 12) {
            return 0;
        }
        throw new RuntimeException("type mismatch.");
    }

    public long a(long j3, int i3, boolean z16) {
        int i16;
        if (!a(i3)) {
            if (z16) {
                throw new RuntimeException("require field not exist.");
            }
            return j3;
        }
        C0788a c0788a = new C0788a();
        a(c0788a);
        byte b16 = c0788a.f78097a;
        if (b16 == 12) {
            return 0L;
        }
        if (b16 == 0) {
            i16 = this.f78096b.get();
        } else if (b16 == 1) {
            i16 = this.f78096b.getShort();
        } else {
            if (b16 != 2) {
                if (b16 == 3) {
                    return this.f78096b.getLong();
                }
                throw new RuntimeException("type mismatch.");
            }
            i16 = this.f78096b.getInt();
        }
        return i16;
    }

    public float a(float f16, int i3, boolean z16) {
        if (!a(i3)) {
            if (z16) {
                throw new RuntimeException("require field not exist.");
            }
            return f16;
        }
        C0788a c0788a = new C0788a();
        a(c0788a);
        byte b16 = c0788a.f78097a;
        if (b16 == 4) {
            return this.f78096b.getFloat();
        }
        if (b16 == 12) {
            return 0.0f;
        }
        throw new RuntimeException("type mismatch.");
    }

    public double a(double d16, int i3, boolean z16) {
        if (!a(i3)) {
            if (z16) {
                throw new RuntimeException("require field not exist.");
            }
            return d16;
        }
        C0788a c0788a = new C0788a();
        a(c0788a);
        byte b16 = c0788a.f78097a;
        if (b16 == 4) {
            return this.f78096b.getFloat();
        }
        if (b16 == 5) {
            return this.f78096b.getDouble();
        }
        if (b16 == 12) {
            return 0.0d;
        }
        throw new RuntimeException("type mismatch.");
    }

    public boolean[] a(boolean[] zArr, int i3, boolean z16) {
        if (!a(i3)) {
            if (z16) {
                throw new RuntimeException("require field not exist.");
            }
            return null;
        }
        C0788a c0788a = new C0788a();
        a(c0788a);
        if (c0788a.f78097a == 9) {
            int a16 = a(0, 0, true);
            if (a16 >= 0) {
                boolean[] zArr2 = new boolean[a16];
                for (int i16 = 0; i16 < a16; i16++) {
                    zArr2[i16] = a(zArr2[0], 0, true);
                }
                return zArr2;
            }
            throw new RuntimeException("size invalid: " + a16);
        }
        throw new RuntimeException("type mismatch.");
    }

    public byte[] a(byte[] bArr, int i3, boolean z16) {
        if (!a(i3)) {
            if (z16) {
                throw new RuntimeException("require field not exist.");
            }
            return null;
        }
        C0788a c0788a = new C0788a();
        a(c0788a);
        byte b16 = c0788a.f78097a;
        if (b16 == 9) {
            int a16 = a(0, 0, true);
            if (a16 >= 0 && a16 <= this.f78096b.capacity()) {
                byte[] bArr2 = new byte[a16];
                for (int i16 = 0; i16 < a16; i16++) {
                    bArr2[i16] = a(bArr2[0], 0, true);
                }
                return bArr2;
            }
            throw new RuntimeException("size invalid: " + a16);
        }
        if (b16 == 13) {
            C0788a c0788a2 = new C0788a();
            a(c0788a2);
            if (c0788a2.f78097a == 0) {
                int a17 = a(0, 0, true);
                if (a17 >= 0 && a17 <= this.f78096b.capacity()) {
                    byte[] bArr3 = new byte[a17];
                    this.f78096b.get(bArr3);
                    return bArr3;
                }
                throw new RuntimeException("invalid size, tag: " + i3 + ", type: " + ((int) c0788a.f78097a) + ", " + ((int) c0788a2.f78097a) + ", size: " + a17);
            }
            throw new RuntimeException("type mismatch, tag: " + i3 + ", type: " + ((int) c0788a.f78097a) + ", " + ((int) c0788a2.f78097a));
        }
        throw new RuntimeException("type mismatch.");
    }

    public short[] a(short[] sArr, int i3, boolean z16) {
        if (!a(i3)) {
            if (z16) {
                throw new RuntimeException("require field not exist.");
            }
            return null;
        }
        C0788a c0788a = new C0788a();
        a(c0788a);
        if (c0788a.f78097a == 9) {
            int a16 = a(0, 0, true);
            if (a16 >= 0) {
                short[] sArr2 = new short[a16];
                for (int i16 = 0; i16 < a16; i16++) {
                    sArr2[i16] = a(sArr2[0], 0, true);
                }
                return sArr2;
            }
            throw new RuntimeException("size invalid: " + a16);
        }
        throw new RuntimeException("type mismatch.");
    }

    public int[] a(int[] iArr, int i3, boolean z16) {
        if (!a(i3)) {
            if (z16) {
                throw new RuntimeException("require field not exist.");
            }
            return null;
        }
        C0788a c0788a = new C0788a();
        a(c0788a);
        if (c0788a.f78097a == 9) {
            int a16 = a(0, 0, true);
            if (a16 >= 0) {
                int[] iArr2 = new int[a16];
                for (int i16 = 0; i16 < a16; i16++) {
                    iArr2[i16] = a(iArr2[0], 0, true);
                }
                return iArr2;
            }
            throw new RuntimeException("size invalid: " + a16);
        }
        throw new RuntimeException("type mismatch.");
    }

    public long[] a(long[] jArr, int i3, boolean z16) {
        if (!a(i3)) {
            if (z16) {
                throw new RuntimeException("require field not exist.");
            }
            return null;
        }
        C0788a c0788a = new C0788a();
        a(c0788a);
        if (c0788a.f78097a == 9) {
            int a16 = a(0, 0, true);
            if (a16 >= 0) {
                long[] jArr2 = new long[a16];
                for (int i16 = 0; i16 < a16; i16++) {
                    jArr2[i16] = a(jArr2[0], 0, true);
                }
                return jArr2;
            }
            throw new RuntimeException("size invalid: " + a16);
        }
        throw new RuntimeException("type mismatch.");
    }

    public float[] a(float[] fArr, int i3, boolean z16) {
        if (!a(i3)) {
            if (z16) {
                throw new RuntimeException("require field not exist.");
            }
            return null;
        }
        C0788a c0788a = new C0788a();
        a(c0788a);
        if (c0788a.f78097a == 9) {
            int a16 = a(0, 0, true);
            if (a16 >= 0) {
                float[] fArr2 = new float[a16];
                for (int i16 = 0; i16 < a16; i16++) {
                    fArr2[i16] = a(fArr2[0], 0, true);
                }
                return fArr2;
            }
            throw new RuntimeException("size invalid: " + a16);
        }
        throw new RuntimeException("type mismatch.");
    }

    public double[] a(double[] dArr, int i3, boolean z16) {
        if (!a(i3)) {
            if (z16) {
                throw new RuntimeException("require field not exist.");
            }
            return null;
        }
        C0788a c0788a = new C0788a();
        a(c0788a);
        if (c0788a.f78097a == 9) {
            int a16 = a(0, 0, true);
            if (a16 >= 0) {
                double[] dArr2 = new double[a16];
                for (int i16 = 0; i16 < a16; i16++) {
                    dArr2[i16] = a(dArr2[0], 0, true);
                }
                return dArr2;
            }
            throw new RuntimeException("size invalid: " + a16);
        }
        throw new RuntimeException("type mismatch.");
    }

    public AbstractJceStruct a(AbstractJceStruct abstractJceStruct, int i3, boolean z16) {
        if (!a(i3)) {
            if (z16) {
                throw new RuntimeException("require field not exist.");
            }
            return null;
        }
        try {
            AbstractJceStruct abstractJceStruct2 = (AbstractJceStruct) abstractJceStruct.getClass().newInstance();
            C0788a c0788a = new C0788a();
            a(c0788a);
            if (c0788a.f78097a == 10) {
                abstractJceStruct2.readFrom(this);
                a();
                return abstractJceStruct2;
            }
            throw new RuntimeException("type mismatch.");
        } catch (Exception e16) {
            throw new RuntimeException(e16.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> Object a(T t16, int i3, boolean z16) {
        if (t16 instanceof Byte) {
            return Byte.valueOf(a((byte) 0, i3, z16));
        }
        if (t16 instanceof Boolean) {
            return Boolean.valueOf(a(false, i3, z16));
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
            return a(i3, z16);
        }
        if (t16 instanceof Map) {
            return a((Map) t16, i3, z16);
        }
        if (t16 instanceof List) {
            return a((List) t16, i3, z16);
        }
        if (t16 instanceof AbstractJceStruct) {
            return a((AbstractJceStruct) t16, i3, z16);
        }
        if (t16.getClass().isArray()) {
            if (!(t16 instanceof byte[]) && !(t16 instanceof Byte[])) {
                if (t16 instanceof boolean[]) {
                    return a((boolean[]) null, i3, z16);
                }
                if (t16 instanceof short[]) {
                    return a((short[]) null, i3, z16);
                }
                if (t16 instanceof int[]) {
                    return a((int[]) null, i3, z16);
                }
                if (t16 instanceof long[]) {
                    return a((long[]) null, i3, z16);
                }
                if (t16 instanceof float[]) {
                    return a((float[]) null, i3, z16);
                }
                if (t16 instanceof double[]) {
                    return a((double[]) null, i3, z16);
                }
                return a((Object[]) t16, i3, z16);
            }
            return a((byte[]) null, i3, z16);
        }
        throw new RuntimeException("read object error: unsupport type.");
    }

    public String a(int i3, boolean z16) {
        if (!a(i3)) {
            if (z16) {
                throw new RuntimeException("require field not exist.");
            }
            return null;
        }
        C0788a c0788a = new C0788a();
        a(c0788a);
        byte b16 = c0788a.f78097a;
        if (b16 == 6) {
            int i16 = this.f78096b.get();
            if (i16 < 0) {
                i16 += 256;
            }
            byte[] bArr = new byte[i16];
            this.f78096b.get(bArr);
            try {
                return new String(bArr, this.f78095a);
            } catch (UnsupportedEncodingException unused) {
                return new String(bArr, Charset.forName("UTF-8"));
            }
        }
        if (b16 == 7) {
            int i17 = this.f78096b.getInt();
            if (i17 <= 104857600 && i17 >= 0 && i17 <= this.f78096b.capacity()) {
                byte[] bArr2 = new byte[i17];
                this.f78096b.get(bArr2);
                try {
                    return new String(bArr2, this.f78095a);
                } catch (UnsupportedEncodingException unused2) {
                    return new String(bArr2, Charset.forName("UTF-8"));
                }
            }
            throw new RuntimeException("String too long: " + i17);
        }
        throw new RuntimeException("type mismatch.");
    }

    public <K, V> HashMap<K, V> a(Map<K, V> map, int i3, boolean z16) {
        return (HashMap) a(new HashMap(), map, i3, z16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <K, V> Map<K, V> a(Map<K, V> map, Map<K, V> map2, int i3, boolean z16) {
        if (map2 != null && !map2.isEmpty()) {
            Map.Entry<K, V> next = map2.entrySet().iterator().next();
            K key = next.getKey();
            V value = next.getValue();
            if (a(i3)) {
                C0788a c0788a = new C0788a();
                a(c0788a);
                if (c0788a.f78097a == 8) {
                    int a16 = a(0, 0, true);
                    if (a16 < 0) {
                        throw new RuntimeException("size invalid: " + a16);
                    }
                    for (int i16 = 0; i16 < a16; i16++) {
                        map.put(a((a) key, 0, true), a((a) value, 1, true));
                    }
                } else {
                    throw new RuntimeException("type mismatch.");
                }
            } else if (z16) {
                throw new RuntimeException("require field not exist.");
            }
            return map;
        }
        return new HashMap();
    }

    public <T> T[] a(T[] tArr, int i3, boolean z16) {
        if (tArr != null && tArr.length != 0) {
            return (T[]) b(tArr[0], i3, z16);
        }
        throw new RuntimeException("unable to get type of key and value.");
    }

    public <T> List<T> a(List<T> list, int i3, boolean z16) {
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

    public int a(String str) {
        this.f78095a = str;
        return 0;
    }
}
