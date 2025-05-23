package com.xingin.xhssharesdk.a;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes28.dex */
public abstract class e implements Iterable<Byte>, Serializable {

    /* renamed from: b, reason: collision with root package name */
    public static final d f389907b = new d(f.f389912b);

    /* renamed from: c, reason: collision with root package name */
    public static final b f389908c;

    /* renamed from: a, reason: collision with root package name */
    public int f389909a = 0;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class a implements b {
        @Override // com.xingin.xhssharesdk.a.e.b
        public final byte[] a(byte[] bArr, int i3, int i16) {
            return Arrays.copyOfRange(bArr, i3, i16 + i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public interface b {
        byte[] a(byte[] bArr, int i3, int i16);
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static abstract class c extends e {
        @Override // com.xingin.xhssharesdk.a.e, java.lang.Iterable
        public final Iterator<Byte> iterator() {
            return new nz4.c(this);
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class d extends c {

        /* renamed from: d, reason: collision with root package name */
        public final byte[] f389910d;

        public d(byte[] bArr) {
            this.f389910d = bArr;
        }

        @Override // com.xingin.xhssharesdk.a.e
        public byte a(int i3) {
            return this.f389910d[i3];
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof e) || size() != ((e) obj).size()) {
                return false;
            }
            if (size() == 0) {
                return true;
            }
            if (obj instanceof d) {
                d dVar = (d) obj;
                int i3 = this.f389909a;
                int i16 = dVar.f389909a;
                if (i3 != 0 && i16 != 0 && i3 != i16) {
                    return false;
                }
                int size = size();
                if (size <= dVar.size()) {
                    if (size + 0 <= dVar.size()) {
                        byte[] bArr = this.f389910d;
                        byte[] bArr2 = dVar.f389910d;
                        int a16 = a() + size;
                        int a17 = a();
                        int a18 = dVar.a() + 0;
                        while (a17 < a16) {
                            if (bArr[a17] != bArr2[a18]) {
                                return false;
                            }
                            a17++;
                            a18++;
                        }
                        return true;
                    }
                    throw new IllegalArgumentException("Ran off end of other: 0, " + size + ", " + dVar.size());
                }
                throw new IllegalArgumentException("Length too large: " + size + size());
            }
            return obj.equals(this);
        }

        @Override // com.xingin.xhssharesdk.a.e
        public int size() {
            return this.f389910d.length;
        }

        public int a() {
            return 0;
        }

        @Override // com.xingin.xhssharesdk.a.e
        public final void a(nz4.b bVar) {
            bVar.a(this.f389910d, a(), size());
        }

        @Override // com.xingin.xhssharesdk.a.e
        public final int a(int i3, int i16) {
            byte[] bArr = this.f389910d;
            int a16 = a() + 0;
            Charset charset = f.f389911a;
            for (int i17 = a16; i17 < a16 + i16; i17++) {
                i3 = (i3 * 31) + bArr[i17];
            }
            return i3;
        }
    }

    /* compiled from: P */
    /* renamed from: com.xingin.xhssharesdk.a.e$e, reason: collision with other inner class name */
    /* loaded from: classes28.dex */
    public static final class C10095e implements b {
        @Override // com.xingin.xhssharesdk.a.e.b
        public final byte[] a(byte[] bArr, int i3, int i16) {
            byte[] bArr2 = new byte[i16];
            System.arraycopy(bArr, i3, bArr2, 0, i16);
            return bArr2;
        }
    }

    static {
        boolean z16;
        b aVar;
        try {
            Class.forName("android.content.Context");
            z16 = true;
        } catch (ClassNotFoundException unused) {
            z16 = false;
        }
        if (z16) {
            aVar = new C10095e();
        } else {
            aVar = new a();
        }
        f389908c = aVar;
    }

    public static d a(String str) {
        return new d(str.getBytes(f.f389911a));
    }

    public abstract byte a(int i3);

    public abstract int a(int i3, int i16);

    public abstract void a(nz4.b bVar);

    public final int hashCode() {
        int i3 = this.f389909a;
        if (i3 == 0) {
            int size = size();
            i3 = a(size, size);
            if (i3 == 0) {
                i3 = 1;
            }
            this.f389909a = i3;
        }
        return i3;
    }

    @Override // java.lang.Iterable
    public Iterator<Byte> iterator() {
        return new nz4.c(this);
    }

    public abstract int size();

    public final String toString() {
        return String.format("<ByteString@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()));
    }
}
