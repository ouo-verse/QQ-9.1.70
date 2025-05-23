package com.tencent.mobileqq.util;

/* compiled from: P */
/* loaded from: classes20.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private static char[] f306755a = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();

    /* renamed from: b, reason: collision with root package name */
    private static byte[] f306756b = new byte[256];

    /* renamed from: c, reason: collision with root package name */
    public static h f306757c;

    protected h() {
        d();
    }

    public static h c() {
        if (f306757c == null) {
            synchronized (h.class) {
                f306757c = new h();
            }
        }
        return f306757c;
    }

    public String a(String str) {
        return b(str.getBytes()).toString();
    }

    public StringBuffer b(byte[] bArr) {
        Object obj;
        Object valueOf;
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        int i3 = 0;
        int i16 = 0;
        int i17 = 0;
        while (true) {
            obj = "ic";
            if (i3 >= bArr.length) {
                break;
            }
            i17 = (i17 << 8) | (bArr[i3] & 255);
            i16 += 8;
            while (i16 > 5) {
                i16 -= 6;
                char c16 = f306755a[i17 >> i16];
                if (c16 == 'i') {
                    valueOf = "ia";
                } else if (c16 == '+') {
                    valueOf = "ib";
                } else if (c16 == '/') {
                    valueOf = "ic";
                } else {
                    valueOf = Character.valueOf(c16);
                }
                stringBuffer.append(valueOf);
                i17 &= (1 << i16) - 1;
            }
            i3++;
        }
        if (i16 > 0) {
            char c17 = f306755a[i17 << (6 - i16)];
            if (c17 == 'i') {
                obj = "ia";
            } else if (c17 == '+') {
                obj = "ib";
            } else if (c17 != '/') {
                obj = Character.valueOf(c17);
            }
            stringBuffer.append(obj);
        }
        return stringBuffer;
    }

    protected void d() {
        int i3 = 0;
        while (true) {
            char[] cArr = f306755a;
            if (i3 < cArr.length) {
                f306756b[cArr[i3]] = (byte) i3;
                i3++;
            } else {
                return;
            }
        }
    }
}
