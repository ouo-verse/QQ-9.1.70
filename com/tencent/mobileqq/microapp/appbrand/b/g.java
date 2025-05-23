package com.tencent.mobileqq.microapp.appbrand.b;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;
import okio.Utf8;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class g extends Writer {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    static boolean f245976c;

    /* renamed from: d, reason: collision with root package name */
    static Class f245977d;

    /* renamed from: e, reason: collision with root package name */
    static Field f245978e;

    /* renamed from: f, reason: collision with root package name */
    static Field f245979f;

    /* renamed from: a, reason: collision with root package name */
    CharBuffer f245980a;

    /* renamed from: b, reason: collision with root package name */
    boolean f245981b;

    /* renamed from: g, reason: collision with root package name */
    private final OutputStream f245982g;

    /* renamed from: h, reason: collision with root package name */
    private CharsetEncoder f245983h;

    /* renamed from: i, reason: collision with root package name */
    private ByteBuffer f245984i;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private static final Integer[] f245985a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14727);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            f245985a = new Integer[Utf8.MASK_2BYTES];
            for (int i3 = 128; i3 < 4096; i3++) {
                f245985a[i3 - 128] = new Integer(i3);
            }
        }

        public static Integer a(int i3) {
            if (i3 >= 128 && i3 < 4096) {
                i3 = f245985a[i3 - 128].intValue();
            }
            return Integer.valueOf(i3);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14743);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            f245976c = true;
        }
    }

    public g(OutputStream outputStream) {
        this(outputStream, Charset.defaultCharset());
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) outputStream);
    }

    private void a(boolean z16) throws IOException {
        synchronized (((Writer) this).lock) {
            b();
            int position = this.f245984i.position();
            if (position > 0) {
                this.f245984i.flip();
                this.f245982g.write(this.f245984i.array(), this.f245984i.arrayOffset(), position);
                this.f245984i.clear();
            }
            if (z16) {
                this.f245982g.flush();
            }
        }
    }

    private void b() throws IOException {
        if (this.f245983h != null) {
        } else {
            throw new IOException("OutputStreamWriter is closed");
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        synchronized (((Writer) this).lock) {
            if (this.f245983h != null) {
                a();
                a(false);
                this.f245982g.close();
                this.f245983h = null;
                this.f245984i = null;
            }
        }
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            a(true);
        }
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i3, int i16) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, cArr, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        synchronized (((Writer) this).lock) {
            b();
            a(cArr.length, i3, i16);
            a(a(cArr, i3, i16));
        }
    }

    public g(File file, boolean z16) throws IOException {
        this(new BufferedOutputStream(new FileOutputStream(file, z16)));
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, file, Boolean.valueOf(z16));
    }

    public g(OutputStream outputStream, Charset charset) {
        super(outputStream);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) outputStream, (Object) charset);
            return;
        }
        this.f245984i = ByteBuffer.allocate(8192);
        this.f245981b = false;
        this.f245982g = outputStream;
        CharsetEncoder newEncoder = charset.newEncoder();
        this.f245983h = newEncoder;
        newEncoder.onMalformedInput(CodingErrorAction.REPLACE);
        this.f245983h.onUnmappableCharacter(CodingErrorAction.REPLACE);
    }

    @Override // java.io.Writer
    public void write(int i3) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
            return;
        }
        synchronized (((Writer) this).lock) {
            b();
            a(CharBuffer.wrap(new char[]{(char) i3}));
        }
    }

    private void a(CharBuffer charBuffer) throws IOException {
        CoderResult encode;
        while (true) {
            encode = this.f245983h.encode(charBuffer, this.f245984i, false);
            if (!encode.isOverflow()) {
                break;
            } else {
                a(false);
            }
        }
        if (encode.isError()) {
            encode.throwException();
        }
    }

    @Override // java.io.Writer
    public void write(String str, int i3, int i16) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        synchronized (((Writer) this).lock) {
            if (i16 < 0) {
                StringBuilder sb5 = new StringBuilder(50);
                sb5.append("length=");
                sb5.append(str.length());
                sb5.append("; regionStart=");
                sb5.append(i3);
                sb5.append("; regionLength=");
                sb5.append(i16);
                throw new StringIndexOutOfBoundsException(sb5.toString());
            }
            if (str != null) {
                if ((i3 | i16) >= 0 && i3 <= str.length() - i16) {
                    b();
                    a(CharBuffer.wrap(str, i3, i16 + i3));
                } else {
                    StringBuilder sb6 = new StringBuilder(50);
                    sb6.append("length=");
                    sb6.append(str.length());
                    sb6.append("; regionStart=");
                    sb6.append(i3);
                    sb6.append("; regionLength=");
                    sb6.append(i16);
                    throw new StringIndexOutOfBoundsException(sb6.toString());
                }
            } else {
                throw new NullPointerException("str == null");
            }
        }
    }

    private void a() throws IOException {
        CharBuffer allocate = CharBuffer.allocate(0);
        while (true) {
            CoderResult encode = this.f245983h.encode(allocate, this.f245984i, true);
            if (encode.isError()) {
                encode.throwException();
                break;
            } else if (!encode.isOverflow()) {
                break;
            } else {
                a(false);
            }
        }
        CoderResult flush = this.f245983h.flush(this.f245984i);
        while (!flush.isUnderflow()) {
            if (flush.isOverflow()) {
                a(false);
                flush = this.f245983h.flush(this.f245984i);
            } else {
                flush.throwException();
            }
        }
    }

    private CharBuffer a(char[] cArr, int i3, int i16) {
        Class cls;
        if (!this.f245981b) {
            CharBuffer wrap = CharBuffer.wrap(cArr, i3, i16);
            this.f245980a = wrap;
            this.f245981b = true;
            return wrap;
        }
        if (f245976c) {
            this.f245980a.clear();
            try {
                if (f245977d == null || f245978e == null || f245979f == null) {
                    Class<?> cls2 = Class.forName("java.nio.CharArrayBuffer");
                    f245977d = cls2;
                    f245978e = cls2.getDeclaredField("backingArray");
                    f245979f = f245977d.getSuperclass().getSuperclass().getDeclaredField("capacity");
                    Field field = f245978e;
                    if (field != null) {
                        field.setAccessible(true);
                    }
                    Field field2 = f245979f;
                    if (field2 != null) {
                        field2.setAccessible(true);
                    }
                }
                if (f245979f != null && f245978e != null && (cls = f245977d) != null && cls.isInstance(this.f245980a)) {
                    f245978e.set(this.f245980a, cArr);
                    f245979f.set(this.f245980a, a.a(cArr.length));
                    this.f245980a.position(i3);
                    this.f245980a.limit(i3 + i16);
                    return this.f245980a;
                }
            } catch (ClassNotFoundException e16) {
                e16.printStackTrace();
            } catch (IllegalAccessException e17) {
                e17.printStackTrace();
            } catch (IllegalArgumentException e18) {
                e18.printStackTrace();
            } catch (NoSuchFieldException e19) {
                e19.printStackTrace();
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
            f245976c = false;
            this.f245980a = null;
        }
        return CharBuffer.wrap(cArr, i3, i16);
    }

    public static void a(int i3, int i16, int i17) {
        if ((i16 | i17) < 0 || i16 > i3 || i3 - i16 < i17) {
            StringBuilder sb5 = new StringBuilder(50);
            sb5.append("length=");
            sb5.append(i3);
            sb5.append("; regionStart=");
            sb5.append(i16);
            sb5.append("; regionLength=");
            sb5.append(i17);
            throw new ArrayIndexOutOfBoundsException(sb5.toString());
        }
    }
}
