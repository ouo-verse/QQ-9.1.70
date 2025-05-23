package c.t.m.g;

/* compiled from: P */
/* loaded from: classes.dex */
public class m0 {
    public static void a(byte[] bArr, int i3, boolean z16) {
        if (z16) {
            int i16 = i3 / 8;
            bArr[i16] = (byte) ((1 << (i3 % 8)) | bArr[i16]);
        } else {
            int i17 = i3 / 8;
            bArr[i17] = (byte) ((~(1 << (i3 % 8))) & bArr[i17]);
        }
    }

    public static boolean a(byte[] bArr, int i3) {
        return (bArr[i3 / 8] & (1 << (i3 % 8))) != 0;
    }
}
