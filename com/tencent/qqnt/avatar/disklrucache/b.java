package com.tencent.qqnt.avatar.disklrucache;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* compiled from: P */
/* loaded from: classes23.dex */
class b implements Closeable {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private final InputStream f352763d;

    /* renamed from: e, reason: collision with root package name */
    private final Charset f352764e;

    /* renamed from: f, reason: collision with root package name */
    private byte[] f352765f;

    /* renamed from: h, reason: collision with root package name */
    private int f352766h;

    /* renamed from: i, reason: collision with root package name */
    private int f352767i;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    class a extends ByteArrayOutputStream {
        static IPatchRedirector $redirector_;

        a(int i3) {
            super(i3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this, i3);
            }
        }

        @Override // java.io.ByteArrayOutputStream
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            int i3 = ((ByteArrayOutputStream) this).count;
            if (i3 > 0 && ((ByteArrayOutputStream) this).buf[i3 - 1] == 13) {
                i3--;
            }
            try {
                return new String(((ByteArrayOutputStream) this).buf, 0, i3, b.this.f352764e.name());
            } catch (UnsupportedEncodingException e16) {
                throw new AssertionError(e16);
            }
        }
    }

    public b(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) inputStream, (Object) charset);
    }

    private void d() throws IOException {
        InputStream inputStream = this.f352763d;
        byte[] bArr = this.f352765f;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read != -1) {
            this.f352766h = 0;
            this.f352767i = read;
            return;
        }
        throw new EOFException();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        synchronized (this.f352763d) {
            if (this.f352765f != null) {
                this.f352765f = null;
                this.f352763d.close();
            }
        }
    }

    public boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        if (this.f352767i == -1) {
            return true;
        }
        return false;
    }

    public String readLine() throws IOException {
        int i3;
        byte[] bArr;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        synchronized (this.f352763d) {
            if (this.f352765f != null) {
                if (this.f352766h >= this.f352767i) {
                    d();
                }
                for (int i17 = this.f352766h; i17 != this.f352767i; i17++) {
                    byte[] bArr2 = this.f352765f;
                    if (bArr2[i17] == 10) {
                        int i18 = this.f352766h;
                        if (i17 != i18) {
                            i16 = i17 - 1;
                            if (bArr2[i16] == 13) {
                                String str = new String(bArr2, i18, i16 - i18, this.f352764e.name());
                                this.f352766h = i17 + 1;
                                return str;
                            }
                        }
                        i16 = i17;
                        String str2 = new String(bArr2, i18, i16 - i18, this.f352764e.name());
                        this.f352766h = i17 + 1;
                        return str2;
                    }
                }
                a aVar = new a((this.f352767i - this.f352766h) + 80);
                loop1: while (true) {
                    byte[] bArr3 = this.f352765f;
                    int i19 = this.f352766h;
                    aVar.write(bArr3, i19, this.f352767i - i19);
                    this.f352767i = -1;
                    d();
                    i3 = this.f352766h;
                    while (i3 != this.f352767i) {
                        bArr = this.f352765f;
                        if (bArr[i3] == 10) {
                            break loop1;
                        }
                        i3++;
                    }
                }
                int i26 = this.f352766h;
                if (i3 != i26) {
                    aVar.write(bArr, i26, i3 - i26);
                }
                this.f352766h = i3 + 1;
                return aVar.toString();
            }
            throw new IOException("LineReader is closed");
        }
    }

    public b(InputStream inputStream, int i3, Charset charset) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, inputStream, Integer.valueOf(i3), charset);
            return;
        }
        if (inputStream == null || charset == null) {
            throw null;
        }
        if (i3 >= 0) {
            if (charset.equals(c.f352769a)) {
                this.f352763d = inputStream;
                this.f352764e = charset;
                this.f352765f = new byte[i3];
                return;
            }
            throw new IllegalArgumentException("Unsupported encoding");
        }
        throw new IllegalArgumentException("capacity <= 0");
    }
}
