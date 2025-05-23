package com.tencent.turingfd.sdk.xq;

import com.google.protobuf.MapFieldLite;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
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
/* loaded from: classes27.dex */
public final class Serpens {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public ByteBuffer f383067a;

    /* renamed from: b, reason: collision with root package name */
    public String f383068b;

    public Serpens() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.f383068b = "GBK";
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        ByteBuffer byteBuffer = this.f383067a;
        byte b16 = byteBuffer.get();
        byte b17 = (byte) (b16 & RegisterType.DOUBLE_HI);
        if (((b16 & 240) >> 4) == 15) {
            byteBuffer.get();
        }
        a(b17);
    }

    public boolean b(int i3) {
        int i16;
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, i3)).booleanValue();
        }
        while (true) {
            try {
                ByteBuffer duplicate = this.f383067a.duplicate();
                byte b16 = duplicate.get();
                byte b17 = (byte) (b16 & RegisterType.DOUBLE_HI);
                i16 = (b16 & 240) >> 4;
                if (i16 == 15) {
                    i16 = duplicate.get() & 255;
                    i17 = 2;
                } else {
                    i17 = 1;
                }
                if (i3 <= i16 || b17 == 11) {
                    break;
                }
                a(i17);
                a(b17);
            } catch (Sagittarius | BufferUnderflowException unused) {
                return false;
            }
        }
        return i3 == i16;
    }

    public Serpens(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bArr);
        } else {
            this.f383068b = "GBK";
            this.f383067a = ByteBuffer.wrap(bArr);
        }
    }

    public final void a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else {
            ByteBuffer byteBuffer = this.f383067a;
            byteBuffer.position(byteBuffer.position() + i3);
        }
    }

    public Serpens(byte[] bArr, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bArr, i3);
            return;
        }
        this.f383068b = "GBK";
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        this.f383067a = wrap;
        wrap.position(i3);
    }

    public final void a(byte b16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Byte.valueOf(b16));
            return;
        }
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
                int i16 = this.f383067a.get();
                if (i16 < 0) {
                    i16 += 256;
                }
                a(i16);
                return;
            case 7:
                a(this.f383067a.getInt());
                return;
            case 8:
                int a16 = a(0, 0, true);
                while (i3 < a16 * 2) {
                    a();
                    i3++;
                }
                return;
            case 9:
                int a17 = a(0, 0, true);
                while (i3 < a17) {
                    a();
                    i3++;
                }
                return;
            case 10:
                b();
                return;
            case 11:
            case 12:
                return;
            case 13:
                ByteBuffer byteBuffer = this.f383067a;
                byte b17 = byteBuffer.get();
                byte b18 = (byte) (b17 & RegisterType.DOUBLE_HI);
                if (((b17 & 240) >> 4) == 15) {
                    byteBuffer.get();
                }
                if (b18 == 0) {
                    a(a(0, 0, true));
                    return;
                }
                throw new Sagittarius("skipField with invalid type, type value: " + ((int) b16) + ", " + ((int) b18));
            default:
                throw new Sagittarius("invalid type.");
        }
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        while (this.f383067a.remaining() != 0) {
            ByteBuffer byteBuffer = this.f383067a;
            byte b16 = byteBuffer.get();
            byte b17 = (byte) (b16 & RegisterType.DOUBLE_HI);
            if (((b16 & 240) >> 4) == 15) {
                byteBuffer.get();
            }
            a(b17);
            if (b17 == 11) {
                return;
            }
        }
    }

    public String b(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (String) iPatchRedirector.redirect((short) 18, this, Integer.valueOf(i3), Boolean.valueOf(z16));
        }
        if (b(i3)) {
            ByteBuffer byteBuffer = this.f383067a;
            byte b16 = byteBuffer.get();
            byte b17 = (byte) (b16 & RegisterType.DOUBLE_HI);
            if (((b16 & 240) >> 4) == 15) {
                byteBuffer.get();
            }
            if (b17 == 6) {
                int i16 = this.f383067a.get();
                if (i16 < 0) {
                    i16 += 256;
                }
                byte[] bArr = new byte[i16];
                this.f383067a.get(bArr);
                try {
                    return new String(bArr, this.f383068b);
                } catch (UnsupportedEncodingException unused) {
                    return new String(bArr);
                }
            }
            if (b17 == 7) {
                int i17 = this.f383067a.getInt();
                if (i17 <= 104857600 && i17 >= 0) {
                    byte[] bArr2 = new byte[i17];
                    this.f383067a.get(bArr2);
                    try {
                        return new String(bArr2, this.f383068b);
                    } catch (UnsupportedEncodingException unused2) {
                        return new String(bArr2);
                    }
                }
                throw new Sagittarius(Sculptor.a("String too long: ", i17));
            }
            if (b17 != 11) {
                throw new Sagittarius("type mismatch.");
            }
        } else if (z16) {
            throw new Sagittarius("require field not exist.");
        }
        return null;
    }

    public boolean a(boolean z16, int i3, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) ? a(z16 ? (byte) 1 : (byte) 0, i3, z17) != 0 : ((Boolean) iPatchRedirector.redirect((short) 10, this, Boolean.valueOf(z16), Integer.valueOf(i3), Boolean.valueOf(z17))).booleanValue();
    }

    public byte a(byte b16, int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Byte) iPatchRedirector.redirect((short) 11, this, Byte.valueOf(b16), Integer.valueOf(i3), Boolean.valueOf(z16))).byteValue();
        }
        if (!b(i3)) {
            if (z16) {
                throw new Sagittarius("require field not exist.");
            }
            return b16;
        }
        ByteBuffer byteBuffer = this.f383067a;
        byte b17 = byteBuffer.get();
        byte b18 = (byte) (b17 & RegisterType.DOUBLE_HI);
        if (((b17 & 240) >> 4) == 15) {
            byteBuffer.get();
        }
        if (b18 == 0) {
            return this.f383067a.get();
        }
        if (b18 == 11) {
            return b16;
        }
        if (b18 == 12) {
            return (byte) 0;
        }
        throw new Sagittarius("type mismatch.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> T[] b(T t16, int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (T[]) ((Object[]) iPatchRedirector.redirect((short) 7, this, t16, Integer.valueOf(i3), Boolean.valueOf(z16)));
        }
        if (!b(i3)) {
            if (z16) {
                throw new Sagittarius("require field not exist.");
            }
            return null;
        }
        ByteBuffer byteBuffer = this.f383067a;
        byte b16 = byteBuffer.get();
        byte b17 = (byte) (b16 & RegisterType.DOUBLE_HI);
        if (((b16 & 240) >> 4) == 15) {
            byteBuffer.get();
        }
        if (b17 != 9) {
            if (b17 == 11) {
                return null;
            }
            throw new Sagittarius("type mismatch.");
        }
        int a16 = a(0, 0, true);
        if (a16 >= 0) {
            T[] tArr = (T[]) ((Object[]) Array.newInstance(t16.getClass(), a16));
            for (int i16 = 0; i16 < a16; i16++) {
                tArr[i16] = a((Serpens) t16, 0, true);
            }
            return tArr;
        }
        throw new Sagittarius(Sculptor.a("size invalid: ", a16));
    }

    public short a(short s16, int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Short) iPatchRedirector.redirect((short) 12, this, Short.valueOf(s16), Integer.valueOf(i3), Boolean.valueOf(z16))).shortValue();
        }
        if (!b(i3)) {
            if (z16) {
                throw new Sagittarius("require field not exist.");
            }
            return s16;
        }
        ByteBuffer byteBuffer = this.f383067a;
        byte b16 = byteBuffer.get();
        byte b17 = (byte) (b16 & RegisterType.DOUBLE_HI);
        if (((b16 & 240) >> 4) == 15) {
            byteBuffer.get();
        }
        if (b17 == 0) {
            return this.f383067a.get();
        }
        if (b17 == 1) {
            return this.f383067a.getShort();
        }
        if (b17 == 11) {
            return s16;
        }
        if (b17 == 12) {
            return (short) 0;
        }
        throw new Sagittarius("type mismatch.");
    }

    public int a(int i3, int i16, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, this, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16))).intValue();
        }
        if (!b(i16)) {
            if (z16) {
                throw new Sagittarius("require field not exist.");
            }
            return i3;
        }
        ByteBuffer byteBuffer = this.f383067a;
        byte b16 = byteBuffer.get();
        byte b17 = (byte) (b16 & RegisterType.DOUBLE_HI);
        if (((b16 & 240) >> 4) == 15) {
            byteBuffer.get();
        }
        if (b17 == 0) {
            return this.f383067a.get();
        }
        if (b17 == 1) {
            return this.f383067a.getShort();
        }
        if (b17 == 2) {
            return this.f383067a.getInt();
        }
        if (b17 == 11) {
            return i3;
        }
        if (b17 == 12) {
            return 0;
        }
        throw new Sagittarius("type mismatch.");
    }

    public long a(long j3, int i3, boolean z16) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Long) iPatchRedirector.redirect((short) 14, this, Long.valueOf(j3), Integer.valueOf(i3), Boolean.valueOf(z16))).longValue();
        }
        if (!b(i3)) {
            if (z16) {
                throw new Sagittarius("require field not exist.");
            }
            return j3;
        }
        ByteBuffer byteBuffer = this.f383067a;
        byte b16 = byteBuffer.get();
        byte b17 = (byte) (b16 & RegisterType.DOUBLE_HI);
        if (((b16 & 240) >> 4) == 15) {
            byteBuffer.get();
        }
        if (b17 == 11) {
            return j3;
        }
        if (b17 == 12) {
            return 0L;
        }
        if (b17 == 0) {
            i16 = this.f383067a.get();
        } else if (b17 == 1) {
            i16 = this.f383067a.getShort();
        } else {
            if (b17 != 2) {
                if (b17 == 3) {
                    return this.f383067a.getLong();
                }
                throw new Sagittarius("type mismatch.");
            }
            i16 = this.f383067a.getInt();
        }
        return i16;
    }

    public float a(float f16, int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Float) iPatchRedirector.redirect((short) 15, this, Float.valueOf(f16), Integer.valueOf(i3), Boolean.valueOf(z16))).floatValue();
        }
        if (!b(i3)) {
            if (z16) {
                throw new Sagittarius("require field not exist.");
            }
            return f16;
        }
        ByteBuffer byteBuffer = this.f383067a;
        byte b16 = byteBuffer.get();
        byte b17 = (byte) (b16 & RegisterType.DOUBLE_HI);
        if (((b16 & 240) >> 4) == 15) {
            byteBuffer.get();
        }
        if (b17 == 4) {
            return this.f383067a.getFloat();
        }
        if (b17 == 11) {
            return f16;
        }
        if (b17 == 12) {
            return 0.0f;
        }
        throw new Sagittarius("type mismatch.");
    }

    public double a(double d16, int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Double) iPatchRedirector.redirect((short) 16, this, Double.valueOf(d16), Integer.valueOf(i3), Boolean.valueOf(z16))).doubleValue();
        }
        if (!b(i3)) {
            if (z16) {
                throw new Sagittarius("require field not exist.");
            }
            return d16;
        }
        ByteBuffer byteBuffer = this.f383067a;
        byte b16 = byteBuffer.get();
        byte b17 = (byte) (b16 & RegisterType.DOUBLE_HI);
        if (((b16 & 240) >> 4) == 15) {
            byteBuffer.get();
        }
        if (b17 == 4) {
            return this.f383067a.getFloat();
        }
        if (b17 == 5) {
            return this.f383067a.getDouble();
        }
        if (b17 == 11) {
            return d16;
        }
        if (b17 == 12) {
            return 0.0d;
        }
        throw new Sagittarius("type mismatch.");
    }

    public String a(String str, int i3, boolean z16) {
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (String) iPatchRedirector.redirect((short) 17, this, str, Integer.valueOf(i3), Boolean.valueOf(z16));
        }
        if (!b(i3)) {
            if (z16) {
                throw new Sagittarius("require field not exist.");
            }
            return str;
        }
        ByteBuffer byteBuffer = this.f383067a;
        byte b16 = byteBuffer.get();
        byte b17 = (byte) (b16 & RegisterType.DOUBLE_HI);
        if (((b16 & 240) >> 4) == 15) {
            byteBuffer.get();
        }
        if (b17 == 6) {
            int i16 = this.f383067a.get();
            if (i16 < 0) {
                i16 += 256;
            }
            byte[] bArr = new byte[i16];
            this.f383067a.get(bArr);
            try {
                str2 = new String(bArr, this.f383068b);
            } catch (UnsupportedEncodingException unused) {
                str2 = new String(bArr);
            }
        } else {
            if (b17 != 7) {
                if (b17 == 11) {
                    return str;
                }
                throw new Sagittarius("type mismatch.");
            }
            int i17 = this.f383067a.getInt();
            if (i17 <= 104857600 && i17 >= 0) {
                byte[] bArr2 = new byte[i17];
                this.f383067a.get(bArr2);
                try {
                    str2 = new String(bArr2, this.f383068b);
                } catch (UnsupportedEncodingException unused2) {
                    str2 = new String(bArr2);
                }
            } else {
                throw new Sagittarius(Sculptor.a("String too long: ", i17));
            }
        }
        return str2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <K, V> HashMap<K, V> a(Map<K, V> map, int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (HashMap) iPatchRedirector.redirect((short) 19, this, map, Integer.valueOf(i3), Boolean.valueOf(z16));
        }
        MapFieldLite mapFieldLite = (HashMap<K, V>) new HashMap();
        if (map != null && !map.isEmpty()) {
            Map.Entry<K, V> next = map.entrySet().iterator().next();
            K key = next.getKey();
            V value = next.getValue();
            if (!b(i3)) {
                if (z16) {
                    throw new Sagittarius("require field not exist.");
                }
                return mapFieldLite;
            }
            ByteBuffer byteBuffer = this.f383067a;
            byte b16 = byteBuffer.get();
            byte b17 = (byte) (b16 & RegisterType.DOUBLE_HI);
            if (((b16 & 240) >> 4) == 15) {
                byteBuffer.get();
            }
            if (b17 != 8) {
                if (b17 == 11) {
                    return mapFieldLite;
                }
                throw new Sagittarius("type mismatch.");
            }
            int a16 = a(0, 0, true);
            if (a16 < 0) {
                throw new Sagittarius(Sculptor.a("size invalid: ", a16));
            }
            for (int i16 = 0; i16 < a16; i16++) {
                mapFieldLite.put(a((Serpens) key, 0, true), a((Serpens) value, 1, true));
            }
            return mapFieldLite;
        }
        return new HashMap<>();
    }

    public byte[] a(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (byte[]) iPatchRedirector.redirect((short) 22, this, Integer.valueOf(i3), Boolean.valueOf(z16));
        }
        if (b(i3)) {
            ByteBuffer byteBuffer = this.f383067a;
            byte b16 = byteBuffer.get();
            byte b17 = (byte) (b16 & RegisterType.DOUBLE_HI);
            if (((b16 & 240) >> 4) == 15) {
                byteBuffer.get();
            }
            if (b17 == 9) {
                int a16 = a(0, 0, true);
                if (a16 >= 0) {
                    byte[] bArr = new byte[a16];
                    for (int i16 = 0; i16 < a16; i16++) {
                        bArr[i16] = a(bArr[0], 0, true);
                    }
                    return bArr;
                }
                throw new Sagittarius(Sculptor.a("size invalid: ", a16));
            }
            if (b17 != 11) {
                if (b17 == 13) {
                    ByteBuffer byteBuffer2 = this.f383067a;
                    byte b18 = byteBuffer2.get();
                    byte b19 = (byte) (b18 & RegisterType.DOUBLE_HI);
                    if (((b18 & 240) >> 4) == 15) {
                        byteBuffer2.get();
                    }
                    if (b19 == 0) {
                        int a17 = a(0, 0, true);
                        if (a17 >= 0) {
                            byte[] bArr2 = new byte[a17];
                            this.f383067a.get(bArr2);
                            return bArr2;
                        }
                        throw new Sagittarius("invalid size, tag: " + i3 + ", type: " + ((int) b17) + ", " + ((int) b19) + ", size: " + a17);
                    }
                    throw new Sagittarius("type mismatch, tag: " + i3 + ", type: " + ((int) b17) + ", " + ((int) b19));
                }
                throw new Sagittarius("type mismatch.");
            }
        } else if (z16) {
            throw new Sagittarius("require field not exist.");
        }
        return null;
    }

    public Taurus a(Taurus taurus, int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (Taurus) iPatchRedirector.redirect((short) 20, this, taurus, Integer.valueOf(i3), Boolean.valueOf(z16));
        }
        if (!b(i3)) {
            if (z16) {
                throw new Sagittarius("require field not exist.");
            }
            return null;
        }
        try {
            Taurus taurus2 = (Taurus) taurus.getClass().newInstance();
            ByteBuffer byteBuffer = this.f383067a;
            byte b16 = byteBuffer.get();
            byte b17 = (byte) (b16 & RegisterType.DOUBLE_HI);
            if (((b16 & 240) >> 4) == 15) {
                byteBuffer.get();
            }
            if (b17 == 10) {
                taurus2.a(this);
                b();
                return taurus2;
            }
            throw new Sagittarius("type mismatch.");
        } catch (Exception e16) {
            throw new Sagittarius(e16.getMessage());
        }
    }

    public <T> Object a(T t16, int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return iPatchRedirector.redirect((short) 21, this, t16, Integer.valueOf(i3), Boolean.valueOf(z16));
        }
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
            return b(i3, z16);
        }
        if (t16 instanceof Map) {
            return a((Map) t16, i3, z16);
        }
        double[] dArr = null;
        r4 = null;
        boolean[] zArr = null;
        r4 = null;
        short[] sArr = null;
        r4 = null;
        int[] iArr = null;
        r4 = null;
        long[] jArr = null;
        r4 = null;
        float[] fArr = null;
        dArr = null;
        if (t16 instanceof List) {
            List list = (List) t16;
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
        if (t16 instanceof Taurus) {
            return a((Taurus) t16, i3, z16);
        }
        if (t16.getClass().isArray()) {
            if (!(t16 instanceof byte[]) && !(t16 instanceof Byte[])) {
                if (t16 instanceof boolean[]) {
                    if (b(i3)) {
                        ByteBuffer byteBuffer = this.f383067a;
                        byte b17 = byteBuffer.get();
                        byte b18 = (byte) (b17 & RegisterType.DOUBLE_HI);
                        if (((b17 & 240) >> 4) == 15) {
                            byteBuffer.get();
                        }
                        if (b18 == 9) {
                            int a16 = a(0, 0, true);
                            if (a16 >= 0) {
                                zArr = new boolean[a16];
                                for (int i16 = 0; i16 < a16; i16++) {
                                    zArr[i16] = a(zArr[0], 0, true);
                                }
                            } else {
                                throw new Sagittarius(Sculptor.a("size invalid: ", a16));
                            }
                        } else if (b18 != 11) {
                            throw new Sagittarius("type mismatch.");
                        }
                    } else if (z16) {
                        throw new Sagittarius("require field not exist.");
                    }
                    return zArr;
                }
                if (t16 instanceof short[]) {
                    if (b(i3)) {
                        ByteBuffer byteBuffer2 = this.f383067a;
                        byte b19 = byteBuffer2.get();
                        byte b26 = (byte) (b19 & RegisterType.DOUBLE_HI);
                        if (((b19 & 240) >> 4) == 15) {
                            byteBuffer2.get();
                        }
                        if (b26 == 9) {
                            int a17 = a(0, 0, true);
                            if (a17 >= 0) {
                                sArr = new short[a17];
                                for (int i17 = 0; i17 < a17; i17++) {
                                    sArr[i17] = a(sArr[0], 0, true);
                                }
                            } else {
                                throw new Sagittarius(Sculptor.a("size invalid: ", a17));
                            }
                        } else if (b26 != 11) {
                            throw new Sagittarius("type mismatch.");
                        }
                    } else if (z16) {
                        throw new Sagittarius("require field not exist.");
                    }
                    return sArr;
                }
                if (t16 instanceof int[]) {
                    if (b(i3)) {
                        ByteBuffer byteBuffer3 = this.f383067a;
                        byte b27 = byteBuffer3.get();
                        byte b28 = (byte) (b27 & RegisterType.DOUBLE_HI);
                        if (((b27 & 240) >> 4) == 15) {
                            byteBuffer3.get();
                        }
                        if (b28 == 9) {
                            int a18 = a(0, 0, true);
                            if (a18 >= 0) {
                                iArr = new int[a18];
                                for (int i18 = 0; i18 < a18; i18++) {
                                    iArr[i18] = a(iArr[0], 0, true);
                                }
                            } else {
                                throw new Sagittarius(Sculptor.a("size invalid: ", a18));
                            }
                        } else if (b28 != 11) {
                            throw new Sagittarius("type mismatch.");
                        }
                    } else if (z16) {
                        throw new Sagittarius("require field not exist.");
                    }
                    return iArr;
                }
                if (t16 instanceof long[]) {
                    if (b(i3)) {
                        ByteBuffer byteBuffer4 = this.f383067a;
                        byte b29 = byteBuffer4.get();
                        byte b36 = (byte) (b29 & RegisterType.DOUBLE_HI);
                        if (((b29 & 240) >> 4) == 15) {
                            byteBuffer4.get();
                        }
                        if (b36 == 9) {
                            int a19 = a(0, 0, true);
                            if (a19 >= 0) {
                                jArr = new long[a19];
                                for (int i19 = 0; i19 < a19; i19++) {
                                    jArr[i19] = a(jArr[0], 0, true);
                                }
                            } else {
                                throw new Sagittarius(Sculptor.a("size invalid: ", a19));
                            }
                        } else if (b36 != 11) {
                            throw new Sagittarius("type mismatch.");
                        }
                    } else if (z16) {
                        throw new Sagittarius("require field not exist.");
                    }
                    return jArr;
                }
                if (t16 instanceof float[]) {
                    if (b(i3)) {
                        ByteBuffer byteBuffer5 = this.f383067a;
                        byte b37 = byteBuffer5.get();
                        byte b38 = (byte) (b37 & RegisterType.DOUBLE_HI);
                        if (((b37 & 240) >> 4) == 15) {
                            byteBuffer5.get();
                        }
                        if (b38 == 9) {
                            int a26 = a(0, 0, true);
                            if (a26 >= 0) {
                                fArr = new float[a26];
                                for (int i26 = 0; i26 < a26; i26++) {
                                    fArr[i26] = a(fArr[0], 0, true);
                                }
                            } else {
                                throw new Sagittarius(Sculptor.a("size invalid: ", a26));
                            }
                        } else if (b38 != 11) {
                            throw new Sagittarius("type mismatch.");
                        }
                    } else if (z16) {
                        throw new Sagittarius("require field not exist.");
                    }
                    return fArr;
                }
                if (t16 instanceof double[]) {
                    if (b(i3)) {
                        ByteBuffer byteBuffer6 = this.f383067a;
                        byte b39 = byteBuffer6.get();
                        byte b46 = (byte) (b39 & RegisterType.DOUBLE_HI);
                        if (((b39 & 240) >> 4) == 15) {
                            byteBuffer6.get();
                        }
                        if (b46 == 9) {
                            int a27 = a(0, 0, true);
                            if (a27 >= 0) {
                                dArr = new double[a27];
                                for (int i27 = 0; i27 < a27; i27++) {
                                    dArr[i27] = a(dArr[0], 0, true);
                                }
                            } else {
                                throw new Sagittarius(Sculptor.a("size invalid: ", a27));
                            }
                        } else if (b46 != 11) {
                            throw new Sagittarius("type mismatch.");
                        }
                    } else if (z16) {
                        throw new Sagittarius("require field not exist.");
                    }
                    return dArr;
                }
                Object[] objArr = (Object[]) t16;
                if (objArr.length != 0) {
                    return b(objArr[0], i3, z16);
                }
                throw new Sagittarius("unable to get type of key and value.");
            }
            return a(i3, z16);
        }
        throw new Sagittarius("read object error: unsupport type.");
    }
}
