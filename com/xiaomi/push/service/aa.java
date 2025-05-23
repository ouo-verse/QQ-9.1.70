package com.xiaomi.push.service;

import com.huawei.hms.framework.common.ContainerUtils;

/* compiled from: P */
/* loaded from: classes28.dex */
public class aa {

    /* renamed from: d, reason: collision with root package name */
    private int f389560d = -666;

    /* renamed from: a, reason: collision with root package name */
    private byte[] f389557a = new byte[256];

    /* renamed from: c, reason: collision with root package name */
    private int f389559c = 0;

    /* renamed from: b, reason: collision with root package name */
    private int f389558b = 0;

    public static int b(byte b16) {
        if (b16 >= 0) {
            return b16;
        }
        return b16 + 256;
    }

    private void c() {
        this.f389559c = 0;
        this.f389558b = 0;
    }

    private void d(int i3, byte[] bArr, boolean z16) {
        int length = bArr.length;
        for (int i16 = 0; i16 < 256; i16++) {
            this.f389557a[i16] = (byte) i16;
        }
        this.f389559c = 0;
        this.f389558b = 0;
        while (true) {
            int i17 = this.f389558b;
            if (i17 >= i3) {
                break;
            }
            int b16 = ((this.f389559c + b(this.f389557a[i17])) + b(bArr[this.f389558b % length])) % 256;
            this.f389559c = b16;
            f(this.f389557a, this.f389558b, b16);
            this.f389558b++;
        }
        if (i3 != 256) {
            this.f389560d = ((this.f389559c + b(this.f389557a[i3])) + b(bArr[i3 % length])) % 256;
        }
        if (z16) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("S_");
            int i18 = i3 - 1;
            sb5.append(i18);
            sb5.append(":");
            for (int i19 = 0; i19 <= i3; i19++) {
                sb5.append(" ");
                sb5.append(b(this.f389557a[i19]));
            }
            sb5.append("   j_");
            sb5.append(i18);
            sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb5.append(this.f389559c);
            sb5.append("   j_");
            sb5.append(i3);
            sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb5.append(this.f389560d);
            sb5.append("   S_");
            sb5.append(i18);
            sb5.append("[j_");
            sb5.append(i18);
            sb5.append("]=");
            sb5.append(b(this.f389557a[this.f389559c]));
            sb5.append("   S_");
            sb5.append(i18);
            sb5.append("[j_");
            sb5.append(i3);
            sb5.append("]=");
            sb5.append(b(this.f389557a[this.f389560d]));
            if (this.f389557a[1] != 0) {
                sb5.append("   S[1]!=0");
            }
            jz4.c.m(sb5.toString());
        }
    }

    private void e(byte[] bArr) {
        d(256, bArr, false);
    }

    private static void f(byte[] bArr, int i3, int i16) {
        byte b16 = bArr[i3];
        bArr[i3] = bArr[i16];
        bArr[i16] = b16;
    }

    public static byte[] g(String str, String str2) {
        byte[] b16 = com.xiaomi.push.aa.b(str);
        byte[] bytes = str2.getBytes();
        byte[] bArr = new byte[b16.length + 1 + bytes.length];
        for (int i3 = 0; i3 < b16.length; i3++) {
            bArr[i3] = b16[i3];
        }
        bArr[b16.length] = 95;
        for (int i16 = 0; i16 < bytes.length; i16++) {
            bArr[b16.length + 1 + i16] = bytes[i16];
        }
        return bArr;
    }

    public static byte[] h(byte[] bArr, String str) {
        return i(bArr, com.xiaomi.push.aa.b(str));
    }

    public static byte[] i(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr2.length];
        aa aaVar = new aa();
        aaVar.e(bArr);
        aaVar.c();
        for (int i3 = 0; i3 < bArr2.length; i3++) {
            bArr3[i3] = (byte) (bArr2[i3] ^ aaVar.a());
        }
        return bArr3;
    }

    public static byte[] j(byte[] bArr, byte[] bArr2, boolean z16, int i3, int i16) {
        byte[] bArr3;
        int i17;
        if (i3 >= 0 && i3 <= bArr2.length && i3 + i16 <= bArr2.length) {
            if (!z16) {
                bArr3 = new byte[i16];
                i17 = 0;
            } else {
                bArr3 = bArr2;
                i17 = i3;
            }
            aa aaVar = new aa();
            aaVar.e(bArr);
            aaVar.c();
            for (int i18 = 0; i18 < i16; i18++) {
                bArr3[i17 + i18] = (byte) (bArr2[i3 + i18] ^ aaVar.a());
            }
            return bArr3;
        }
        throw new IllegalArgumentException("start = " + i3 + " len = " + i16);
    }

    byte a() {
        int i3 = (this.f389558b + 1) % 256;
        this.f389558b = i3;
        int b16 = (this.f389559c + b(this.f389557a[i3])) % 256;
        this.f389559c = b16;
        f(this.f389557a, this.f389558b, b16);
        byte[] bArr = this.f389557a;
        return bArr[(b(bArr[this.f389558b]) + b(this.f389557a[this.f389559c])) % 256];
    }
}
