package c;

import c.e;
import com.tencent.mobileqq.qqbattery.feature.g;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.CharBuffer;
import java.util.NoSuchElementException;

/* compiled from: P */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f29450a;

    /* renamed from: b, reason: collision with root package name */
    public final String f29451b;

    /* renamed from: c, reason: collision with root package name */
    public RandomAccessFile f29452c;

    /* renamed from: e, reason: collision with root package name */
    public int f29454e;

    /* renamed from: f, reason: collision with root package name */
    public char f29455f;

    /* renamed from: g, reason: collision with root package name */
    public char f29456g;

    /* renamed from: d, reason: collision with root package name */
    public int f29453d = -1;

    /* renamed from: h, reason: collision with root package name */
    public boolean f29457h = true;

    /* renamed from: i, reason: collision with root package name */
    public boolean f29458i = false;

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class a extends RuntimeException {
        public a(String str) {
            super(str);
        }
    }

    public d(String str, byte[] bArr) {
        this.f29451b = str;
        this.f29450a = bArr;
    }

    public final CharBuffer a(CharBuffer charBuffer) {
        charBuffer.clear();
        boolean z16 = true;
        while (true) {
            if (!e()) {
                break;
            }
            f();
            if (')' != this.f29455f) {
                if (!charBuffer.hasRemaining()) {
                    CharBuffer allocate = CharBuffer.allocate(charBuffer.capacity() * 2);
                    charBuffer.flip();
                    allocate.put(charBuffer);
                    charBuffer = allocate;
                }
                charBuffer.put(this.f29455f);
                z16 = false;
            } else if (!z16) {
                h();
            } else {
                throw new a("Couldn't read string!");
            }
        }
        if (!z16) {
            charBuffer.flip();
            return charBuffer;
        }
        throw new a("Couldn't read string because file ended!");
    }

    public final void b() {
        RandomAccessFile randomAccessFile = this.f29452c;
        if (randomAccessFile != null) {
            try {
                randomAccessFile.close();
            } catch (IOException unused) {
            } catch (Throwable th5) {
                this.f29452c = null;
                throw th5;
            }
            this.f29452c = null;
        }
    }

    public final void c(char c16) {
        boolean z16 = false;
        while (e()) {
            f();
            if (this.f29455f == c16) {
                z16 = true;
            } else if (z16) {
                h();
                return;
            }
        }
    }

    public final CharBuffer d(CharBuffer charBuffer) {
        charBuffer.clear();
        boolean z16 = true;
        while (true) {
            if (!e()) {
                break;
            }
            f();
            if (!Character.isWhitespace(this.f29455f)) {
                if (!charBuffer.hasRemaining()) {
                    CharBuffer allocate = CharBuffer.allocate(charBuffer.capacity() * 2);
                    charBuffer.flip();
                    allocate.put(charBuffer);
                    charBuffer = allocate;
                }
                charBuffer.put(this.f29455f);
                z16 = false;
            } else if (!z16) {
                h();
            } else {
                throw new a("Couldn't read string!");
            }
        }
        if (!z16) {
            charBuffer.flip();
            return charBuffer;
        }
        throw new a("Couldn't read string because file ended!");
    }

    public final boolean e() {
        RandomAccessFile randomAccessFile;
        int i3;
        int i16;
        if (!this.f29457h || (randomAccessFile = this.f29452c) == null || (i3 = this.f29453d) > (i16 = this.f29454e - 1)) {
            return false;
        }
        if (i3 < i16) {
            return true;
        }
        try {
            this.f29454e = randomAccessFile.read(this.f29450a);
            this.f29453d = -1;
        } catch (IOException unused) {
            this.f29457h = false;
            b();
        }
        return e();
    }

    public final void f() {
        if (e()) {
            int i3 = this.f29453d + 1;
            this.f29453d = i3;
            this.f29456g = this.f29455f;
            this.f29455f = (char) this.f29450a[i3];
            this.f29458i = false;
            return;
        }
        throw new NoSuchElementException();
    }

    public final void finalize() {
        b();
    }

    public final d g() {
        this.f29457h = true;
        RandomAccessFile randomAccessFile = this.f29452c;
        if (randomAccessFile != null) {
            try {
                randomAccessFile.seek(0L);
            } catch (IOException unused) {
                b();
            }
        }
        if (this.f29452c == null) {
            try {
                this.f29452c = new RandomAccessFile(this.f29451b, "r");
            } catch (IOException e16) {
                this.f29457h = false;
                b();
                StringBuilder a16 = g.a("RAF err: ");
                a16.append(e16.getMessage());
                throw new e.b(a16.toString());
            }
        }
        if (this.f29457h) {
            this.f29453d = -1;
            this.f29454e = 0;
            this.f29455f = (char) 0;
            this.f29456g = (char) 0;
            this.f29458i = false;
        }
        return this;
    }

    public final void h() {
        if (!this.f29458i) {
            this.f29453d--;
            this.f29455f = this.f29456g;
            this.f29458i = true;
            return;
        }
        throw new a("Can only rewind one step!");
    }
}
