package com.tencent.qqnt.emotion.utils;

import androidx.annotation.NonNull;
import com.tencent.commonsdk.pool.ByteArrayPool;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: P */
/* loaded from: classes24.dex */
public class p extends FilterOutputStream {
    static IPatchRedirector $redirector_;
    private static final Object C;

    /* renamed from: i, reason: collision with root package name */
    private static p f356694i;

    /* renamed from: m, reason: collision with root package name */
    private static int f356695m;

    /* renamed from: d, reason: collision with root package name */
    private boolean f356696d;

    /* renamed from: e, reason: collision with root package name */
    private p f356697e;

    /* renamed from: f, reason: collision with root package name */
    protected byte[] f356698f;

    /* renamed from: h, reason: collision with root package name */
    protected int f356699h;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43791);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            f356695m = 0;
            C = new Object();
        }
    }

    p(@NonNull OutputStream outputStream) {
        this(outputStream, 8192);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) outputStream);
    }

    private void a() throws IOException {
        if (this.f356696d) {
        } else {
            throw new IOException("BufferedOutputStream is closed");
        }
    }

    public static void b(int i3, int i16, int i17) {
        if ((i16 | i17) >= 0 && i16 <= i3 && i3 - i16 >= i17) {
            return;
        }
        throw new IndexOutOfBoundsException("length=" + i3 + "; regionStart=" + i16 + "; regionLength=" + i17);
    }

    private void d() {
        this.f356699h = 0;
        ((FilterOutputStream) this).out = null;
        this.f356696d = false;
    }

    private void e() throws IOException {
        int i3 = this.f356699h;
        if (i3 > 0) {
            ((FilterOutputStream) this).out.write(this.f356698f, 0, i3);
            this.f356699h = 0;
        }
    }

    public static p f(@NonNull OutputStream outputStream) {
        p pVar;
        synchronized (C) {
            pVar = f356694i;
            if (pVar != null) {
                f356694i = pVar.f356697e;
                pVar.f356697e = null;
                f356695m--;
            } else {
                pVar = null;
            }
        }
        if (pVar != null) {
            ((FilterOutputStream) pVar).out = outputStream;
            pVar.f356696d = true;
            return pVar;
        }
        return new p(outputStream);
    }

    private void g() {
        d();
        synchronized (C) {
            int i3 = f356695m;
            if (i3 < 4) {
                this.f356697e = f356694i;
                f356694i = this;
                f356695m = i3 + 1;
            }
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            if (!this.f356696d) {
                return;
            }
            try {
                super.close();
            } finally {
                g();
            }
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public synchronized void flush() throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        a();
        e();
        ((FilterOutputStream) this).out.flush();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public synchronized void write(int i3) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
            return;
        }
        a();
        int i16 = this.f356699h;
        byte[] bArr = this.f356698f;
        if (i16 == bArr.length) {
            ((FilterOutputStream) this).out.write(bArr, 0, i16);
            this.f356699h = 0;
        }
        byte[] bArr2 = this.f356698f;
        int i17 = this.f356699h;
        this.f356699h = i17 + 1;
        bArr2[i17] = (byte) i3;
    }

    p(@NonNull OutputStream outputStream, int i3) {
        super(outputStream);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) outputStream, i3);
        } else {
            this.f356698f = ByteArrayPool.getGenericInstance().getBuf(i3);
            this.f356696d = true;
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public synchronized void write(byte[] bArr, int i3, int i16) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, bArr, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        a();
        if (bArr != null) {
            byte[] bArr2 = this.f356698f;
            if (i16 >= bArr2.length) {
                e();
                ((FilterOutputStream) this).out.write(bArr, i3, i16);
                return;
            }
            b(bArr.length, i3, i16);
            if (i16 > bArr2.length - this.f356699h) {
                e();
            }
            System.arraycopy(bArr, i3, bArr2, this.f356699h, i16);
            this.f356699h += i16;
            return;
        }
        throw new NullPointerException("buffer == null");
    }
}
