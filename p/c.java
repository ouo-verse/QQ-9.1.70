package p;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* compiled from: P */
/* loaded from: classes.dex */
class c implements Closeable {

    /* renamed from: d, reason: collision with root package name */
    private final InputStream f424848d;

    /* renamed from: e, reason: collision with root package name */
    private final Charset f424849e;

    /* renamed from: f, reason: collision with root package name */
    private byte[] f424850f;

    /* renamed from: h, reason: collision with root package name */
    private int f424851h;

    /* renamed from: i, reason: collision with root package name */
    private int f424852i;

    /* compiled from: P */
    /* loaded from: classes.dex */
    class a extends ByteArrayOutputStream {
        a(int i3) {
            super(i3);
        }

        @Override // java.io.ByteArrayOutputStream
        public String toString() {
            int i3 = ((ByteArrayOutputStream) this).count;
            if (i3 > 0 && ((ByteArrayOutputStream) this).buf[i3 - 1] == 13) {
                i3--;
            }
            try {
                return new String(((ByteArrayOutputStream) this).buf, 0, i3, c.this.f424849e.name());
            } catch (UnsupportedEncodingException e16) {
                throw new AssertionError(e16);
            }
        }
    }

    public c(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    private void d() throws IOException {
        InputStream inputStream = this.f424848d;
        byte[] bArr = this.f424850f;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read != -1) {
            this.f424851h = 0;
            this.f424852i = read;
            return;
        }
        throw new EOFException();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this.f424848d) {
            if (this.f424850f != null) {
                this.f424850f = null;
                this.f424848d.close();
            }
        }
    }

    public boolean e() {
        if (this.f424852i == -1) {
            return true;
        }
        return false;
    }

    public String readLine() throws IOException {
        int i3;
        byte[] bArr;
        int i16;
        synchronized (this.f424848d) {
            if (this.f424850f != null) {
                if (this.f424851h >= this.f424852i) {
                    d();
                }
                for (int i17 = this.f424851h; i17 != this.f424852i; i17++) {
                    byte[] bArr2 = this.f424850f;
                    if (bArr2[i17] == 10) {
                        int i18 = this.f424851h;
                        if (i17 != i18) {
                            i16 = i17 - 1;
                            if (bArr2[i16] == 13) {
                                String str = new String(bArr2, i18, i16 - i18, this.f424849e.name());
                                this.f424851h = i17 + 1;
                                return str;
                            }
                        }
                        i16 = i17;
                        String str2 = new String(bArr2, i18, i16 - i18, this.f424849e.name());
                        this.f424851h = i17 + 1;
                        return str2;
                    }
                }
                a aVar = new a((this.f424852i - this.f424851h) + 80);
                loop1: while (true) {
                    byte[] bArr3 = this.f424850f;
                    int i19 = this.f424851h;
                    aVar.write(bArr3, i19, this.f424852i - i19);
                    this.f424852i = -1;
                    d();
                    i3 = this.f424851h;
                    while (i3 != this.f424852i) {
                        bArr = this.f424850f;
                        if (bArr[i3] == 10) {
                            break loop1;
                        }
                        i3++;
                    }
                }
                int i26 = this.f424851h;
                if (i3 != i26) {
                    aVar.write(bArr, i26, i3 - i26);
                }
                this.f424851h = i3 + 1;
                return aVar.toString();
            }
            throw new IOException("LineReader is closed");
        }
    }

    public c(InputStream inputStream, int i3, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        }
        if (i3 >= 0) {
            if (charset.equals(d.f424854a)) {
                this.f424848d = inputStream;
                this.f424849e = charset;
                this.f424850f = new byte[i3];
                return;
            }
            throw new IllegalArgumentException("Unsupported encoding");
        }
        throw new IllegalArgumentException("capacity <= 0");
    }
}
