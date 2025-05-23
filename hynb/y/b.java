package hynb.y;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes28.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public byte[] f406918a;

    /* renamed from: b, reason: collision with root package name */
    public int f406919b;

    /* renamed from: c, reason: collision with root package name */
    public int f406920c;

    public b(int i3, int i16) {
        if (i3 >= 0) {
            this.f406918a = new byte[i3];
            this.f406920c = i16;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + i3);
        }
    }

    public void a(byte b16) {
        c(this.f406919b + 1);
        byte[] bArr = this.f406918a;
        int i3 = this.f406919b;
        this.f406919b = i3 + 1;
        bArr[i3] = b16;
    }

    public final void b(short s16) {
        int i3 = 0;
        int i16 = s16;
        while (i3 < 2) {
            this.f406918a[this.f406919b + i3] = (byte) (i16 & 255);
            i3++;
            i16 >>= 8;
        }
        this.f406919b += 2;
    }

    public final void c(int i3) {
        int i16;
        byte[] bArr = this.f406918a;
        int length = bArr.length;
        if (i3 > length) {
            int i17 = this.f406920c;
            if (i17 > 0) {
                i16 = length + i17;
            } else {
                i16 = length * 2;
            }
            if (i16 >= i3) {
                i3 = i16;
            }
            byte[] bArr2 = new byte[i3];
            this.f406918a = bArr2;
            System.arraycopy(bArr, 0, bArr2, 0, this.f406919b);
        }
    }

    public String toString() {
        return new String(this.f406918a, 0, this.f406919b);
    }

    public void a(short s16) {
        c(this.f406919b + 2);
        b(s16);
    }

    public final void b(int i3) {
        for (int i16 = 0; i16 < 4; i16++) {
            this.f406918a[this.f406919b + i16] = (byte) (i3 & 255);
            i3 >>= 8;
        }
        this.f406919b += 4;
    }

    public b(int i3) {
        this(i3, 0);
    }

    public void a(int i3) {
        c(this.f406919b + 4);
        b(i3);
    }

    public void a(Long l3) {
        c(this.f406919b + 8);
        a(l3.longValue());
    }

    public final void a(long j3) {
        for (int i3 = 0; i3 < 8; i3++) {
            this.f406918a[this.f406919b + i3] = (byte) (255 & j3);
            j3 >>= 8;
        }
        this.f406919b += 8;
    }

    public void a(String str) {
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        a((short) bytes.length);
        c(this.f406919b + bytes.length);
        System.arraycopy(bytes, 0, this.f406918a, this.f406919b, bytes.length);
        this.f406919b += bytes.length;
    }

    public void a(byte[] bArr) {
        a((short) bArr.length);
        c(this.f406919b + bArr.length);
        System.arraycopy(bArr, 0, this.f406918a, this.f406919b, bArr.length);
        this.f406919b += bArr.length;
    }

    public byte[] a() {
        return Arrays.copyOf(this.f406918a, this.f406919b);
    }
}
