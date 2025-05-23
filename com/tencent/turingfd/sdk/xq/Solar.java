package com.tencent.turingfd.sdk.xq;

import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Solar {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public ByteBuffer f383074a;

    /* renamed from: b, reason: collision with root package name */
    public String f383075b;

    public Solar(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
        } else {
            this.f383075b = "GBK";
            this.f383074a = ByteBuffer.allocate(i3);
        }
    }

    public byte[] a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (byte[]) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        byte[] bArr = new byte[this.f383074a.position()];
        System.arraycopy(this.f383074a.array(), 0, bArr, 0, this.f383074a.position());
        return bArr;
    }

    public void b(byte b16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Byte.valueOf(b16), Integer.valueOf(i3));
            return;
        }
        if (i3 < 15) {
            this.f383074a.put((byte) (b16 | (i3 << 4)));
        } else {
            if (i3 < 256) {
                this.f383074a.put((byte) (b16 | 240));
                this.f383074a.put((byte) i3);
                return;
            }
            throw new Scorpius(Sculptor.a("tag is too large: ", i3));
        }
    }

    public void a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else if (this.f383074a.remaining() < i3) {
            ByteBuffer allocate = ByteBuffer.allocate((this.f383074a.capacity() + i3) * 2);
            allocate.put(this.f383074a.array(), 0, this.f383074a.position());
            this.f383074a = allocate;
        }
    }

    public void a(byte b16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Byte.valueOf(b16), Integer.valueOf(i3));
            return;
        }
        a(3);
        if (b16 == 0) {
            b((byte) 12, i3);
        } else {
            b((byte) 0, i3);
            this.f383074a.put(b16);
        }
    }

    public void a(short s16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Short.valueOf(s16), Integer.valueOf(i3));
            return;
        }
        a(4);
        if (s16 >= -128 && s16 <= 127) {
            a((byte) s16, i3);
        } else {
            b((byte) 1, i3);
            this.f383074a.putShort(s16);
        }
    }

    public void a(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        a(6);
        if (i3 >= -32768 && i3 <= 32767) {
            a((short) i3, i16);
        } else {
            b((byte) 2, i16);
            this.f383074a.putInt(i3);
        }
    }

    public void a(long j3, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Long.valueOf(j3), Integer.valueOf(i3));
            return;
        }
        a(10);
        if (j3 >= WebViewConstants.WV.ENABLE_WEBAIO_SWITCH && j3 <= TTL.MAX_VALUE) {
            a((int) j3, i3);
        } else {
            b((byte) 3, i3);
            this.f383074a.putLong(j3);
        }
    }

    public void a(float f16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Float.valueOf(f16), Integer.valueOf(i3));
            return;
        }
        a(6);
        b((byte) 4, i3);
        this.f383074a.putFloat(f16);
    }

    public void a(double d16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Double.valueOf(d16), Integer.valueOf(i3));
            return;
        }
        a(10);
        b((byte) 5, i3);
        this.f383074a.putDouble(d16);
    }

    public void a(String str, int i3) {
        byte[] bytes;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) str, i3);
            return;
        }
        try {
            bytes = str.getBytes(this.f383075b);
        } catch (UnsupportedEncodingException unused) {
            bytes = str.getBytes();
        }
        a(bytes.length + 10);
        if (bytes.length > 255) {
            b((byte) 7, i3);
            this.f383074a.putInt(bytes.length);
            this.f383074a.put(bytes);
        } else {
            b((byte) 6, i3);
            this.f383074a.put((byte) bytes.length);
            this.f383074a.put(bytes);
        }
    }

    public <K, V> void a(Map<K, V> map, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) map, i3);
            return;
        }
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

    public void a(byte[] bArr, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) bArr, i3);
            return;
        }
        a(bArr.length + 8);
        b((byte) 13, i3);
        b((byte) 0, 0);
        a(bArr.length, 0);
        this.f383074a.put(bArr);
    }

    public <T> void a(Collection<T> collection, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) collection, i3);
            return;
        }
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

    public void a(Taurus taurus, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) taurus, i3);
            return;
        }
        a(2);
        b((byte) 10, i3);
        taurus.a(this);
        a(2);
        b((byte) 11, 0);
    }

    public void a(Object obj, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, obj, i3);
            return;
        }
        if (obj instanceof Byte) {
            a(((Byte) obj).byteValue(), i3);
            return;
        }
        if (obj instanceof Boolean) {
            a(((Boolean) obj).booleanValue() ? (byte) 1 : (byte) 0, i3);
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
        if (obj instanceof Taurus) {
            a((Taurus) obj, i3);
            return;
        }
        if (obj instanceof byte[]) {
            a((byte[]) obj, i3);
            return;
        }
        if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
            a(8);
            b((byte) 9, i3);
            a(zArr.length, 0);
            for (boolean z16 : zArr) {
                a(z16 ? (byte) 1 : (byte) 0, 0);
            }
            return;
        }
        if (obj instanceof short[]) {
            short[] sArr = (short[]) obj;
            a(8);
            b((byte) 9, i3);
            a(sArr.length, 0);
            for (short s16 : sArr) {
                a(s16, 0);
            }
            return;
        }
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            a(8);
            b((byte) 9, i3);
            a(iArr.length, 0);
            for (int i16 : iArr) {
                a(i16, 0);
            }
            return;
        }
        if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            a(8);
            b((byte) 9, i3);
            a(jArr.length, 0);
            for (long j3 : jArr) {
                a(j3, 0);
            }
            return;
        }
        if (obj instanceof float[]) {
            float[] fArr = (float[]) obj;
            a(8);
            b((byte) 9, i3);
            a(fArr.length, 0);
            for (float f16 : fArr) {
                a(f16, 0);
            }
            return;
        }
        if (obj instanceof double[]) {
            double[] dArr = (double[]) obj;
            a(8);
            b((byte) 9, i3);
            a(dArr.length, 0);
            for (double d16 : dArr) {
                a(d16, 0);
            }
            return;
        }
        if (obj.getClass().isArray()) {
            Object[] objArr = (Object[]) obj;
            a(8);
            b((byte) 9, i3);
            a(objArr.length, 0);
            for (Object obj2 : objArr) {
                a(obj2, 0);
            }
            return;
        }
        if (obj instanceof Collection) {
            a((Collection) obj, i3);
        } else {
            StringBuilder a16 = Flat.a("write object error: unsupport type. ");
            a16.append(obj.getClass());
            throw new Scorpius(a16.toString());
        }
    }
}
