package com.tencent.beacon.pack;

import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f78099a = new byte[0];

    /* renamed from: b, reason: collision with root package name */
    private static final char[] f78100b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET, 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: c, reason: collision with root package name */
    protected String f78101c;

    /* renamed from: d, reason: collision with root package name */
    private ByteBuffer f78102d;

    public b(int i3) {
        this.f78101c = "GBK";
        this.f78102d = ByteBuffer.allocate(i3);
    }

    public ByteBuffer a() {
        return this.f78102d;
    }

    public byte[] b() {
        byte[] bArr = new byte[this.f78102d.position()];
        System.arraycopy(this.f78102d.array(), 0, bArr, 0, this.f78102d.position());
        return bArr;
    }

    public void a(int i3) {
        if (this.f78102d.remaining() < i3) {
            try {
                ByteBuffer allocate = ByteBuffer.allocate((this.f78102d.capacity() + i3) * 2);
                allocate.put(this.f78102d.array(), 0, this.f78102d.position());
                this.f78102d = allocate;
            } catch (IllegalArgumentException e16) {
                throw e16;
            }
        }
    }

    public void b(byte b16, int i3) {
        if (i3 < 15) {
            this.f78102d.put((byte) (b16 | (i3 << 4)));
        } else if (i3 < 256) {
            this.f78102d.put((byte) (b16 | 240));
            this.f78102d.put((byte) i3);
        } else {
            throw new RuntimeException("tag is too large: " + i3);
        }
    }

    public b() {
        this(128);
    }

    public void a(boolean z16, int i3) {
        a(z16 ? (byte) 1 : (byte) 0, i3);
    }

    public void a(byte b16, int i3) {
        a(3);
        if (b16 == 0) {
            b((byte) 12, i3);
        } else {
            b((byte) 0, i3);
            this.f78102d.put(b16);
        }
    }

    public void a(short s16, int i3) {
        a(4);
        if (s16 >= -128 && s16 <= 127) {
            a((byte) s16, i3);
        } else {
            b((byte) 1, i3);
            this.f78102d.putShort(s16);
        }
    }

    public void a(int i3, int i16) {
        a(6);
        if (i3 >= -32768 && i3 <= 32767) {
            a((short) i3, i16);
        } else {
            b((byte) 2, i16);
            this.f78102d.putInt(i3);
        }
    }

    public void a(long j3, int i3) {
        a(10);
        if (j3 >= WebViewConstants.WV.ENABLE_WEBAIO_SWITCH && j3 <= TTL.MAX_VALUE) {
            a((int) j3, i3);
        } else {
            b((byte) 3, i3);
            this.f78102d.putLong(j3);
        }
    }

    public void a(float f16, int i3) {
        a(6);
        b((byte) 4, i3);
        this.f78102d.putFloat(f16);
    }

    public void a(double d16, int i3) {
        a(10);
        b((byte) 5, i3);
        this.f78102d.putDouble(d16);
    }

    public void a(String str, int i3) {
        byte[] bytes;
        try {
            bytes = str.getBytes(this.f78101c);
        } catch (UnsupportedEncodingException unused) {
            bytes = str.getBytes(Charset.forName("UTF-8"));
        }
        a(bytes.length + 10);
        if (bytes.length > 255) {
            b((byte) 7, i3);
            this.f78102d.putInt(bytes.length);
            this.f78102d.put(bytes);
        } else {
            b((byte) 6, i3);
            this.f78102d.put((byte) bytes.length);
            this.f78102d.put(bytes);
        }
    }

    public <K, V> void a(Map<K, V> map, int i3) {
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

    public void a(boolean[] zArr, int i3) {
        a(8);
        b((byte) 9, i3);
        a(zArr.length, 0);
        for (boolean z16 : zArr) {
            a(z16, 0);
        }
    }

    public void a(byte[] bArr, int i3) {
        a(bArr.length + 8);
        b((byte) 13, i3);
        b((byte) 0, 0);
        a(bArr.length, 0);
        this.f78102d.put(bArr);
    }

    public void a(short[] sArr, int i3) {
        a(8);
        b((byte) 9, i3);
        a(sArr.length, 0);
        for (short s16 : sArr) {
            a(s16, 0);
        }
    }

    public void a(int[] iArr, int i3) {
        a(8);
        b((byte) 9, i3);
        a(iArr.length, 0);
        for (int i16 : iArr) {
            a(i16, 0);
        }
    }

    public void a(long[] jArr, int i3) {
        a(8);
        b((byte) 9, i3);
        a(jArr.length, 0);
        for (long j3 : jArr) {
            a(j3, 0);
        }
    }

    public void a(float[] fArr, int i3) {
        a(8);
        b((byte) 9, i3);
        a(fArr.length, 0);
        for (float f16 : fArr) {
            a(f16, 0);
        }
    }

    public void a(double[] dArr, int i3) {
        a(8);
        b((byte) 9, i3);
        a(dArr.length, 0);
        for (double d16 : dArr) {
            a(d16, 0);
        }
    }

    public <T> void a(Collection<T> collection, int i3) {
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

    public void a(AbstractJceStruct abstractJceStruct, int i3) {
        a(2);
        b((byte) 10, i3);
        abstractJceStruct.writeTo(this);
        a(2);
        b((byte) 11, 0);
    }

    public void a(Object obj, int i3) {
        if (obj == null) {
            obj = "";
        }
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
        if (obj instanceof AbstractJceStruct) {
            a((AbstractJceStruct) obj, i3);
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
            a((Object[]) obj, i3);
        } else {
            if (obj instanceof Collection) {
                a((Collection) obj, i3);
                return;
            }
            throw new RuntimeException("write object error: unsupport type. " + obj.getClass());
        }
    }

    private void a(Object[] objArr, int i3) {
        a(8);
        b((byte) 9, i3);
        a(objArr.length, 0);
        for (Object obj : objArr) {
            a(obj, 0);
        }
    }

    public int a(String str) {
        this.f78101c = str;
        return 0;
    }
}
