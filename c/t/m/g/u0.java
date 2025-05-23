package c.t.m.g;

import java.util.Random;

/* compiled from: P */
/* loaded from: classes.dex */
public class u0 {

    /* renamed from: a, reason: collision with root package name */
    public static final Random f30027a = new Random();

    /* renamed from: b, reason: collision with root package name */
    public static final a f30028b = new a();

    public static byte[] a(int i3) {
        byte[] bArr = new byte[i3];
        f30027a.nextBytes(bArr);
        return bArr;
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public t0 f30029a = new t0();

        /* renamed from: b, reason: collision with root package name */
        public boolean f30030b = false;

        public a() {
            a();
        }

        public void a() {
            a(l0.a("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDMi0gKCzapHg05OXTOlWf9sT20tJJ8C+h41HJZI+nGU2h4sdirRTUB7wdwRR1w604QZJmn55p4S9xBRVCZWIXX2kWmekr90vvvpQow55PYk1JyGXKz7a+yzQxmyEIsD4mtw+M7G76YQrgrjD42EcGH453xTUTdJGwjrn/eCJng6QIDAQAB"), "0000");
        }

        public void a(byte[] bArr, String str) {
            c1.a("RsaAes", "setPublicKey:" + bArr.length + "," + str + ", ignored:" + this.f30030b);
            if (str.length() == 4 && !h1.a(bArr)) {
                this.f30029a.a(bArr);
            } else {
                a();
            }
        }
    }

    public static void a(byte[] bArr, String str) {
        c1.a("EncRsaAesUtil", "setPubKey version " + str);
        f30028b.a(bArr, str);
    }
}
