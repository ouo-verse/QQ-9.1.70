package com.tencent.mobileqq.qqaudio.audioprocessor;

import android.annotation.TargetApi;
import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqaudio.audioprocessor.c;
import java.io.IOException;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a extends InputStream implements c {
    static IPatchRedirector $redirector_;
    protected c.a C;
    protected byte[] D;
    protected int E;

    /* renamed from: d, reason: collision with root package name */
    protected Context f262200d;

    /* renamed from: e, reason: collision with root package name */
    protected PipedOutputStream f262201e;

    /* renamed from: f, reason: collision with root package name */
    protected PipedInputStream f262202f;

    /* renamed from: h, reason: collision with root package name */
    protected byte[] f262203h;

    /* renamed from: i, reason: collision with root package name */
    protected byte[] f262204i;

    /* renamed from: m, reason: collision with root package name */
    protected byte[] f262205m;

    public a(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.D = new byte[1];
            this.f262200d = context;
        }
    }

    @Override // com.tencent.mobileqq.qqaudio.audioprocessor.c
    public c.a a(byte[] bArr, int i3, int i16) throws IOException {
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (c.a) iPatchRedirector.redirect((short) 5, this, bArr, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        this.C.f262208a = 0;
        while (i16 > 0) {
            if (i16 > 1920 - this.f262202f.available()) {
                i17 = 1920 - this.f262202f.available();
            } else {
                i17 = i16;
            }
            c(bArr, i3, i17);
            i3 += i17;
            i16 -= i17;
        }
        return this.C;
    }

    @Override // com.tencent.mobileqq.qqaudio.audioprocessor.c
    @TargetApi(9)
    public void b(int i3, int i16, int i17) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        } else {
            this.f262201e = new PipedOutputStream();
            this.f262202f = new PipedInputStream(this.f262201e, 1920);
        }
    }

    protected void c(byte[] bArr, int i3, int i16) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, bArr, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.f262201e.write(bArr, i3, i16);
        while (this.f262202f.available() >= this.E) {
            this.C.f262208a += d(this.f262205m, this.C.f262208a);
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        PipedInputStream pipedInputStream = this.f262202f;
        if (pipedInputStream != null) {
            pipedInputStream.close();
            this.f262202f = null;
        }
    }

    public int d(byte[] bArr, int i3) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this, (Object) bArr, i3)).intValue();
        }
        return read(bArr, i3, bArr.length);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        if (read(this.D, 0, 1) == 1) {
            return this.D[0] & 255;
        }
        return -1;
    }

    @Override // com.tencent.mobileqq.qqaudio.audioprocessor.c
    public void release() throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        PipedOutputStream pipedOutputStream = this.f262201e;
        if (pipedOutputStream != null) {
            pipedOutputStream.close();
            this.f262201e = null;
        }
        close();
    }
}
