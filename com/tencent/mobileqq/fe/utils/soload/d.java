package com.tencent.mobileqq.fe.utils.soload;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;

/* compiled from: P */
/* loaded from: classes12.dex */
class d implements Cloneable {
    static IPatchRedirector $redirector_;
    int C;
    int D;
    byte[] E;
    int F;
    long G;
    long H;
    int I;
    int J;
    int K;
    int L;
    int M;
    int N;
    int P;
    long Q;
    byte[] R;
    boolean S;

    /* renamed from: d, reason: collision with root package name */
    String f205852d;

    /* renamed from: e, reason: collision with root package name */
    String f205853e;

    /* renamed from: f, reason: collision with root package name */
    long f205854f;

    /* renamed from: h, reason: collision with root package name */
    long f205855h;

    /* renamed from: i, reason: collision with root package name */
    long f205856i;

    /* renamed from: m, reason: collision with root package name */
    int f205857m;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(byte[] bArr, InputStream inputStream) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) bArr, (Object) inputStream);
            return;
        }
        this.f205854f = -1L;
        this.f205855h = -1L;
        this.f205856i = -1L;
        this.f205857m = -1;
        this.C = -1;
        this.D = -1;
        this.F = -1;
        this.G = -1L;
        this.H = -1L;
        this.I = -1;
        this.J = -1;
        this.K = -1;
        this.L = -1;
        this.M = -1;
        this.N = -1;
        this.P = -1;
        this.Q = -1L;
        this.S = false;
        g.a(inputStream, bArr, 0, bArr.length);
        b d16 = b.d(bArr, 0, bArr.length, ByteOrder.LITTLE_ENDIAN);
        d16.a();
        this.I = d16.b();
        this.J = d16.b();
        this.K = d16.b();
        this.f205857m = d16.b();
        this.C = d16.b();
        this.D = d16.b();
        this.f205855h = d16.a() & 4294967295L;
        this.f205854f = d16.a() & 4294967295L;
        this.f205856i = d16.a() & 4294967295L;
        this.F = d16.b();
        this.L = d16.b();
        this.M = d16.b();
        this.N = d16.b();
        this.P = d16.b();
        this.Q = d16.a() & 4294967295L;
        this.G = d16.a() & 4294967295L;
        byte[] bArr2 = new byte[this.F];
        this.R = bArr2;
        g.a(inputStream, bArr2, 0, bArr2.length);
        byte[] bArr3 = this.R;
        this.f205852d = new String(bArr3, 0, bArr3.length, StandardCharsets.UTF_8);
        int i3 = this.M;
        if (i3 > 0) {
            byte[] bArr4 = new byte[i3];
            g.a(inputStream, bArr4, 0, i3);
            this.f205853e = new String(bArr4, 0, i3, StandardCharsets.UTF_8);
        }
        int i16 = this.L;
        if (i16 > 0) {
            byte[] bArr5 = new byte[i16];
            this.E = bArr5;
            g.a(inputStream, bArr5, 0, i16);
        }
    }

    public String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f205852d;
    }

    public long b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
        }
        return this.f205856i;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f205852d;
    }
}
