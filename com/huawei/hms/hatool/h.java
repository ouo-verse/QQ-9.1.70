package com.huawei.hms.hatool;

/* compiled from: P */
/* loaded from: classes2.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private byte[] f37123a;

    /* renamed from: b, reason: collision with root package name */
    private int f37124b = 0;

    public h(int i3) {
        this.f37123a = null;
        this.f37123a = new byte[i3];
    }

    public void a(byte[] bArr, int i3) {
        if (i3 <= 0) {
            return;
        }
        byte[] bArr2 = this.f37123a;
        int length = bArr2.length;
        int i16 = this.f37124b;
        if (length - i16 >= i3) {
            System.arraycopy(bArr, 0, bArr2, i16, i3);
        } else {
            byte[] bArr3 = new byte[(bArr2.length + i3) << 1];
            System.arraycopy(bArr2, 0, bArr3, 0, i16);
            System.arraycopy(bArr, 0, bArr3, this.f37124b, i3);
            this.f37123a = bArr3;
        }
        this.f37124b += i3;
    }

    public int b() {
        return this.f37124b;
    }

    public byte[] a() {
        int i3 = this.f37124b;
        if (i3 <= 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[i3];
        System.arraycopy(this.f37123a, 0, bArr, 0, i3);
        return bArr;
    }
}
