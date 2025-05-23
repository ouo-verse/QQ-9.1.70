package com.tencent.mapsdk.internal;

import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public ByteBuffer f149372a;

    /* renamed from: b, reason: collision with root package name */
    protected String f149373b;

    /* renamed from: c, reason: collision with root package name */
    private r f149374c;

    n(ByteBuffer byteBuffer) {
        this.f149373b = "GBK";
        this.f149372a = byteBuffer;
    }

    private ByteBuffer b() {
        return this.f149372a;
    }

    private void c(String str, int i3) {
        a(str.length() + 10);
        byte[] a16 = i.a(str);
        if (a16.length > 255) {
            b((byte) 7, i3);
            this.f149372a.putInt(a16.length);
            this.f149372a.put(a16);
        } else {
            b((byte) 6, i3);
            this.f149372a.put((byte) a16.length);
            this.f149372a.put(a16);
        }
    }

    public final byte[] a() {
        byte[] bArr = new byte[this.f149372a.position()];
        System.arraycopy(this.f149372a.array(), 0, bArr, 0, this.f149372a.position());
        return bArr;
    }

    private void b(byte b16, int i3) {
        if (i3 < 15) {
            this.f149372a.put((byte) (b16 | (i3 << 4)));
        } else {
            if (i3 < 256) {
                this.f149372a.put((byte) (b16 | 240));
                this.f149372a.put((byte) i3);
                return;
            }
            throw new l("tag is too large: ".concat(String.valueOf(i3)));
        }
    }

    private void a(int i3) {
        if (this.f149372a.remaining() < i3) {
            try {
                ByteBuffer allocate = ByteBuffer.allocate((this.f149372a.capacity() + i3) * 2);
                allocate.put(this.f149372a.array(), 0, this.f149372a.position());
                this.f149372a = allocate;
            } catch (IllegalArgumentException e16) {
                throw e16;
            }
        }
    }

    public n(int i3) {
        this.f149373b = "GBK";
        this.f149372a = ByteBuffer.allocate(i3);
    }

    private void b(String str, int i3) {
        byte[] a16 = i.a(str);
        a(a16.length + 10);
        if (a16.length > 255) {
            b((byte) 7, i3);
            this.f149372a.putInt(a16.length);
            this.f149372a.put(a16);
        } else {
            b((byte) 6, i3);
            this.f149372a.put((byte) a16.length);
            this.f149372a.put(a16);
        }
    }

    public n() {
        this(128);
    }

    public final void a(boolean z16, int i3) {
        a(z16 ? (byte) 1 : (byte) 0, i3);
    }

    private r c() {
        return this.f149374c;
    }

    public final void a(byte b16, int i3) {
        a(3);
        if (b16 == 0) {
            b((byte) 12, i3);
        } else {
            b((byte) 0, i3);
            this.f149372a.put(b16);
        }
    }

    public final void a(short s16, int i3) {
        a(4);
        if (s16 >= -128 && s16 <= 127) {
            a((byte) s16, i3);
        } else {
            b((byte) 1, i3);
            this.f149372a.putShort(s16);
        }
    }

    private void b(Object[] objArr, int i3) {
        a(8);
        b((byte) 9, i3);
        a(objArr.length, 0);
        for (Object obj : objArr) {
            a(obj, 0);
        }
    }

    public final void a(int i3, int i16) {
        a(6);
        if (i3 >= -32768 && i3 <= 32767) {
            a((short) i3, i16);
        } else {
            b((byte) 2, i16);
            this.f149372a.putInt(i3);
        }
    }

    public final void a(long j3, int i3) {
        a(10);
        if (j3 >= WebViewConstants.WV.ENABLE_WEBAIO_SWITCH && j3 <= TTL.MAX_VALUE) {
            a((int) j3, i3);
        } else {
            b((byte) 3, i3);
            this.f149372a.putLong(j3);
        }
    }

    public final void a(float f16, int i3) {
        a(6);
        b((byte) 4, i3);
        this.f149372a.putFloat(f16);
    }

    public final void a(double d16, int i3) {
        a(10);
        b((byte) 5, i3);
        this.f149372a.putDouble(d16);
    }

    public final void a(String str, int i3) {
        byte[] bytes;
        try {
            bytes = str.getBytes(this.f149373b);
        } catch (UnsupportedEncodingException unused) {
            bytes = str.getBytes();
        }
        a(bytes.length + 10);
        if (bytes.length > 255) {
            b((byte) 7, i3);
            this.f149372a.putInt(bytes.length);
            this.f149372a.put(bytes);
        } else {
            b((byte) 6, i3);
            this.f149372a.put((byte) bytes.length);
            this.f149372a.put(bytes);
        }
    }

    public final <K, V> void a(Map<K, V> map, int i3) {
        a(8);
        b((byte) 8, i3);
        a(map == null ? 0 : map.size(), 0);
        if (map != null) {
            for (Map.Entry<K, V> entry : map.entrySet()) {
                a(entry.getKey(), 0);
                a(entry.getValue(), 1);
            }
        }
    }

    private void a(boolean[] zArr, int i3) {
        a(8);
        b((byte) 9, i3);
        a(zArr.length, 0);
        for (boolean z16 : zArr) {
            a(z16, 0);
        }
    }

    public final void a(byte[] bArr, int i3) {
        a(bArr.length + 8);
        b((byte) 13, i3);
        b((byte) 0, 0);
        a(bArr.length, 0);
        this.f149372a.put(bArr);
    }

    private void a(short[] sArr, int i3) {
        a(8);
        b((byte) 9, i3);
        a(sArr.length, 0);
        for (short s16 : sArr) {
            a(s16, 0);
        }
    }

    private void a(int[] iArr, int i3) {
        a(8);
        b((byte) 9, i3);
        a(iArr.length, 0);
        for (int i16 : iArr) {
            a(i16, 0);
        }
    }

    private void a(long[] jArr, int i3) {
        a(8);
        b((byte) 9, i3);
        a(jArr.length, 0);
        for (long j3 : jArr) {
            a(j3, 0);
        }
    }

    private void a(float[] fArr, int i3) {
        a(8);
        b((byte) 9, i3);
        a(fArr.length, 0);
        for (float f16 : fArr) {
            a(f16, 0);
        }
    }

    private void a(double[] dArr, int i3) {
        a(8);
        b((byte) 9, i3);
        a(dArr.length, 0);
        for (double d16 : dArr) {
            a(d16, 0);
        }
    }

    private <T> void a(T[] tArr, int i3) {
        b(tArr, i3);
    }

    public final <T> void a(Collection<T> collection, int i3) {
        a(8);
        b((byte) 9, i3);
        a(collection == null ? 0 : collection.size(), 0);
        if (collection != null) {
            Iterator<T> it = collection.iterator();
            while (it.hasNext()) {
                a(it.next(), 0);
            }
        }
    }

    public final void a(p pVar, int i3) {
        a(2);
        b((byte) 10, i3);
        pVar.writeTo(this);
        a(2);
        b((byte) 11, 0);
    }

    private void a(Byte b16, int i3) {
        a(b16.byteValue(), i3);
    }

    private void a(Boolean bool, int i3) {
        a(bool.booleanValue(), i3);
    }

    private void a(Short sh5, int i3) {
        a(sh5.shortValue(), i3);
    }

    private void a(Integer num, int i3) {
        a(num.intValue(), i3);
    }

    private void a(Long l3, int i3) {
        a(l3.longValue(), i3);
    }

    private void a(Float f16, int i3) {
        a(f16.floatValue(), i3);
    }

    private void a(Double d16, int i3) {
        a(d16.doubleValue(), i3);
    }

    public final void a(Object obj, int i3) {
        if (obj instanceof Byte) {
            a(((Byte) obj).byteValue(), i3);
            return;
        }
        if (obj instanceof Boolean) {
            a(((Boolean) obj).booleanValue(), i3);
            return;
        }
        if (obj instanceof Short) {
            a(((Short) obj).shortValue(), i3);
            return;
        }
        if (obj instanceof Integer) {
            a(((Integer) obj).intValue(), i3);
            return;
        }
        if (obj instanceof Long) {
            a(((Long) obj).longValue(), i3);
            return;
        }
        if (obj instanceof Float) {
            a(((Float) obj).floatValue(), i3);
            return;
        }
        if (obj instanceof Double) {
            a(((Double) obj).doubleValue(), i3);
            return;
        }
        if (obj instanceof String) {
            a((String) obj, i3);
            return;
        }
        if (obj instanceof Map) {
            a((Map) obj, i3);
            return;
        }
        if (obj instanceof List) {
            a((Collection) obj, i3);
            return;
        }
        if (obj instanceof p) {
            a((p) obj, i3);
            return;
        }
        if (obj instanceof byte[]) {
            a((byte[]) obj, i3);
            return;
        }
        if (obj instanceof boolean[]) {
            a((boolean[]) obj, i3);
            return;
        }
        if (obj instanceof short[]) {
            a((short[]) obj, i3);
            return;
        }
        if (obj instanceof int[]) {
            a((int[]) obj, i3);
            return;
        }
        if (obj instanceof long[]) {
            a((long[]) obj, i3);
            return;
        }
        if (obj instanceof float[]) {
            a((float[]) obj, i3);
            return;
        }
        if (obj instanceof double[]) {
            a((double[]) obj, i3);
            return;
        }
        if (obj.getClass().isArray()) {
            b((Object[]) obj, i3);
        } else if (obj instanceof Collection) {
            a((Collection) obj, i3);
        } else {
            throw new l("write object error: unsupport type. " + obj.getClass());
        }
    }

    public final int a(String str) {
        this.f149373b = str;
        return 0;
    }

    private void a(r rVar) {
        this.f149374c = rVar;
    }
}
