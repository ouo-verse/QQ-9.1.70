package com.tencent.mobileqq.tts.stream;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a extends InputStream {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private int f303415d;

    /* renamed from: e, reason: collision with root package name */
    private int f303416e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f303417f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f303418h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f303419i;

    /* renamed from: m, reason: collision with root package name */
    private final InputStream f303420m;

    public a(InputStream inputStream) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) inputStream);
            return;
        }
        this.f303416e = 0;
        this.f303417f = true;
        this.f303418h = false;
        this.f303419i = false;
        this.f303420m = inputStream;
    }

    private static int b(InputStream inputStream) throws IOException {
        StringBuilder sb5 = new StringBuilder();
        if (inputStream == null) {
            return -1;
        }
        char c16 = 0;
        while (c16 != '\uffff') {
            int read = inputStream.read();
            if (read == 123) {
                if (QLog.isColorLevel()) {
                    QLog.d("ChunkedInputStream", 1, "Server did not return any chunk");
                }
                StringBuilder sb6 = new StringBuilder("{");
                while (true) {
                    int read2 = inputStream.read();
                    if (-1 != read2) {
                        sb6.append((char) read2);
                    } else {
                        QLog.d("ChunkedInputStream", 1, "[getChunkSize] error: " + ((Object) sb6));
                        return -1;
                    }
                }
            } else if (c16 != 0) {
                if (c16 != 1) {
                    continue;
                } else if (read == 10) {
                    c16 = '\uffff';
                } else {
                    throw new IOException("Read CRLF invalid!");
                }
            } else if (read == 13) {
                c16 = 1;
            } else {
                sb5.append((char) read);
            }
        }
        try {
            return Integer.parseInt(sb5.toString(), 16);
        } catch (NumberFormatException e16) {
            QLog.e("ChunkedInputStream", 1, "number format error : ", e16);
            return -1;
        }
    }

    private boolean d() throws IOException {
        boolean z16;
        if (!this.f303417f) {
            z16 = e();
        } else {
            z16 = false;
        }
        int b16 = b(this.f303420m);
        this.f303415d = b16;
        this.f303417f = false;
        this.f303416e = 0;
        if (b16 == 0) {
            this.f303418h = true;
        }
        if (b16 < 0 || !z16) {
            return false;
        }
        return true;
    }

    private boolean e() throws IOException {
        int read = this.f303420m.read();
        int read2 = this.f303420m.read();
        if (read == 13 && read2 == 10) {
            return true;
        }
        return false;
    }

    public byte[] a() throws IOException {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (byte[]) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        if (!this.f303417f) {
            z16 = e();
        } else {
            z16 = true;
        }
        this.f303417f = false;
        InputStream inputStream = this.f303420m;
        if (inputStream == null) {
            return new byte[0];
        }
        int b16 = b(inputStream);
        this.f303415d = b16;
        if (4 == b16) {
            read(new byte[4], 0, 4);
        }
        int i3 = this.f303415d;
        if (i3 > 0 && z16) {
            byte[] bArr = new byte[i3];
            do {
                int read = read(bArr, this.f303416e, i3);
                if (read < 0) {
                    return new byte[0];
                }
                i3 -= read;
            } while (i3 > 0);
            return bArr;
        }
        return new byte[0];
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        if (!this.f303419i) {
            if (this.f303418h) {
                return -1;
            }
            if (this.f303416e >= this.f303415d) {
                d();
                if (this.f303418h) {
                    return -1;
                }
            }
            this.f303416e++;
            return this.f303420m.read();
        }
        throw new IOException("Attempted read from closed stream.");
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i3, int i16) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, this, bArr, Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
        }
        if (!this.f303419i) {
            if (this.f303418h) {
                return -1;
            }
            if (this.f303416e >= this.f303415d) {
                boolean d16 = d();
                if (this.f303418h || !d16) {
                    return -1;
                }
            }
            int read = this.f303420m.read(bArr, i3, Math.min(i16, this.f303415d - this.f303416e));
            int i17 = this.f303416e + read;
            this.f303416e = i17;
            if (i17 == this.f303415d) {
                this.f303416e = 0;
            }
            return read;
        }
        throw new IOException("Attempted read from closed stream.");
    }
}
