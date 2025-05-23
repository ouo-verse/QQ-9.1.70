package com.xiaomi.push;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.zip.GZIPInputStream;

/* compiled from: P */
/* loaded from: classes28.dex */
public class eg {

    /* renamed from: e, reason: collision with root package name */
    public static final byte[] f388683e = {80, 85, 83, 72};

    /* renamed from: a, reason: collision with root package name */
    private short f388684a;

    /* renamed from: b, reason: collision with root package name */
    private byte f388685b;

    /* renamed from: c, reason: collision with root package name */
    private int f388686c;

    /* renamed from: d, reason: collision with root package name */
    private byte[] f388687d;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static final c f388688a = new c();

        /* renamed from: b, reason: collision with root package name */
        public static final d f388689b = new d();

        public static byte[] a(byte[] bArr) {
            return b(bArr, f388689b);
        }

        public static byte[] b(byte[] bArr, b bVar) {
            if (eg.f(bArr)) {
                eg e16 = eg.e(bArr);
                if (e16.f388685b == 0 || e16.f388685b != bVar.a()) {
                    return e16.f388687d;
                }
                return bVar.a(e16.f388687d, e16.f388686c);
            }
            return bArr;
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public interface b {
        byte a();

        byte[] a(byte[] bArr, int i3);
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class c {
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class d implements b {
        @Override // com.xiaomi.push.eg.b
        public byte a() {
            return (byte) 2;
        }

        @Override // com.xiaomi.push.eg.b
        public byte[] a(byte[] bArr, int i3) {
            GZIPInputStream gZIPInputStream;
            GZIPInputStream gZIPInputStream2 = null;
            try {
                gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(bArr), i3);
            } catch (IOException unused) {
            } catch (Throwable th5) {
                th = th5;
            }
            try {
                byte[] bArr2 = new byte[i3];
                gZIPInputStream.read(bArr2);
                try {
                    gZIPInputStream.close();
                } catch (IOException unused2) {
                }
                return bArr2;
            } catch (IOException unused3) {
                gZIPInputStream2 = gZIPInputStream;
                if (gZIPInputStream2 != null) {
                    try {
                        gZIPInputStream2.close();
                    } catch (IOException unused4) {
                    }
                }
                return bArr;
            } catch (Throwable th6) {
                th = th6;
                gZIPInputStream2 = gZIPInputStream;
                if (gZIPInputStream2 != null) {
                    try {
                        gZIPInputStream2.close();
                    } catch (IOException unused5) {
                    }
                }
                throw th;
            }
        }
    }

    protected eg(byte b16, int i3, byte[] bArr) {
        this((short) 1, b16, i3, bArr);
    }

    public static eg c(byte b16, int i3, byte[] bArr) {
        return new eg(b16, i3, bArr);
    }

    public static eg d(short s16, byte b16, int i3, byte[] bArr) {
        return new eg(s16, b16, i3, bArr);
    }

    public static eg e(byte[] bArr) {
        if (f(bArr)) {
            ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN);
            order.getInt();
            short s16 = order.getShort();
            byte b16 = order.get();
            int i3 = order.getInt();
            byte[] bArr2 = new byte[order.getInt()];
            order.get(bArr2);
            return d(s16, b16, i3, bArr2);
        }
        return c((byte) 0, bArr.length, bArr);
    }

    public static boolean f(byte[] bArr) {
        byte[] bArr2 = f388683e;
        return g(bArr2, bArr, bArr2.length);
    }

    public static boolean g(byte[] bArr, byte[] bArr2, int i3) {
        if (bArr.length < i3 || bArr2.length < i3) {
            return false;
        }
        for (int i16 = 0; i16 < i3; i16++) {
            if (bArr[i16] != bArr2[i16]) {
                return false;
            }
        }
        return true;
    }

    protected eg(short s16, byte b16, int i3, byte[] bArr) {
        this.f388684a = s16;
        this.f388685b = b16;
        this.f388686c = i3;
        this.f388687d = bArr;
    }
}
