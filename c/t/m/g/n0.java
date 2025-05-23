package c.t.m.g;

/* compiled from: P */
/* loaded from: classes.dex */
public class n0 {
    public static byte[] a(int i3) {
        return new byte[]{(byte) (i3 >>> 24), (byte) (i3 >>> 16), (byte) (i3 >>> 8), (byte) i3};
    }

    public static String a(byte[] bArr, String str) {
        StringBuilder sb5 = new StringBuilder();
        for (byte b16 : bArr) {
            String hexString = Integer.toHexString(b16 & 255);
            if (hexString.length() != 2) {
                hexString = "0" + hexString;
            }
            sb5.append(hexString);
            sb5.append(str);
        }
        return sb5.toString();
    }
}
