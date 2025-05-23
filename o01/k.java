package o01;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public static final k f421690a = new k();

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f421691b = new int[256];

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f421692c = new int[256];

    static {
        int i3;
        int i16 = 0;
        while (true) {
            if (i16 >= 8) {
                break;
            }
            f421691b[i16] = 1 << i16;
            i16++;
        }
        for (i3 = 8; i3 < 256; i3++) {
            int[] iArr = f421691b;
            iArr[i3] = ((iArr[i3 - 4] ^ iArr[i3 - 5]) ^ iArr[i3 - 6]) ^ iArr[i3 - 8];
        }
        for (int i17 = 0; i17 < 255; i17++) {
            f421692c[f421691b[i17]] = i17;
        }
    }

    public final int a(int i3) {
        while (i3 < 0) {
            i3 += 255;
        }
        while (i3 >= 256) {
            i3 -= 255;
        }
        return f421691b[i3];
    }
}
