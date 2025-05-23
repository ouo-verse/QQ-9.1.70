package com.xiaomi.push;

import java.io.IOException;

/* compiled from: P */
/* loaded from: classes28.dex */
public abstract class dp {
    public abstract int a();

    public abstract dp b(ac acVar);

    public dp c(byte[] bArr) {
        return d(bArr, 0, bArr.length);
    }

    public dp d(byte[] bArr, int i3, int i16) {
        try {
            ac g16 = ac.g(bArr, i3, i16);
            b(g16);
            g16.j(0);
            return this;
        } catch (d e16) {
            throw e16;
        } catch (IOException unused) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
        }
    }

    public abstract void e(c cVar);

    public void f(byte[] bArr, int i3, int i16) {
        try {
            c p16 = c.p(bArr, i3, i16);
            e(p16);
            p16.K();
        } catch (IOException unused) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean g(ac acVar, int i3) {
        return acVar.m(i3);
    }

    public byte[] h() {
        int i3 = i();
        byte[] bArr = new byte[i3];
        f(bArr, 0, i3);
        return bArr;
    }

    public abstract int i();
}
