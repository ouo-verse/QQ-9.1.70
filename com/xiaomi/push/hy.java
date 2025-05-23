package com.xiaomi.push;

/* compiled from: P */
/* loaded from: classes28.dex */
public abstract class hy {
    public abstract int a(byte[] bArr, int i3, int i16);

    public abstract void c(byte[] bArr, int i3, int i16);

    public byte[] d() {
        return null;
    }

    public int e() {
        return 0;
    }

    public int f() {
        return -1;
    }

    public int g(byte[] bArr, int i3, int i16) {
        int i17 = 0;
        while (i17 < i16) {
            int a16 = a(bArr, i3 + i17, i16 - i17);
            if (a16 > 0) {
                i17 += a16;
            } else {
                throw new il("Cannot read. Remote side has closed. Tried to read " + i16 + " bytes, but only got " + i17 + " bytes.");
            }
        }
        return i17;
    }

    public void b(int i3) {
    }
}
