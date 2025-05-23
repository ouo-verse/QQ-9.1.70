package com.tencent.mobileqq.weiyun.channel;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.util.z;

/* compiled from: P */
/* loaded from: classes20.dex */
final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    public static int f315143f;

    /* renamed from: a, reason: collision with root package name */
    int f315144a;

    /* renamed from: b, reason: collision with root package name */
    short f315145b;

    /* renamed from: c, reason: collision with root package name */
    int f315146c;

    /* renamed from: d, reason: collision with root package name */
    int f315147d;

    /* renamed from: e, reason: collision with root package name */
    short f315148e;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19829);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
        } else {
            f315143f = 16;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f315144a = 538116905;
        this.f315145b = (short) 1;
        this.f315148e = (short) 0;
    }

    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.f315147d;
    }

    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.f315146c;
    }

    public void c(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) bArr);
            return;
        }
        byte[] bArr2 = new byte[4];
        System.arraycopy(bArr, 0, bArr2, 0, 4);
        this.f315144a = z.e(bArr2);
        byte[] bArr3 = new byte[2];
        System.arraycopy(bArr, 4, bArr3, 0, 2);
        this.f315145b = z.g(bArr3);
        byte[] bArr4 = new byte[4];
        System.arraycopy(bArr, 6, bArr4, 0, 4);
        this.f315146c = z.e(bArr4);
        byte[] bArr5 = new byte[4];
        System.arraycopy(bArr, 10, bArr5, 0, 4);
        this.f315147d = z.e(bArr5);
        byte[] bArr6 = new byte[2];
        System.arraycopy(bArr, 14, bArr6, 0, 2);
        this.f315148e = z.g(bArr6);
    }

    public void d(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
        } else {
            this.f315147d = i3;
        }
    }

    public void e(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        } else {
            this.f315146c = i3;
        }
    }

    public byte[] f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (byte[]) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        byte[] bArr = new byte[16];
        System.arraycopy(z.b(this.f315144a), 0, bArr, 0, 4);
        System.arraycopy(z.c(this.f315145b), 0, bArr, 4, 2);
        System.arraycopy(z.b(this.f315146c), 0, bArr, 6, 4);
        System.arraycopy(z.b(this.f315147d), 0, bArr, 10, 4);
        System.arraycopy(z.c(this.f315148e), 0, bArr, 14, 2);
        return bArr;
    }
}
