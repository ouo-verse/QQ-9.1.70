package com.tencent.luggage.wxa.qg;

import java.io.IOException;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;

/* compiled from: P */
/* loaded from: classes8.dex */
public class f extends Reader {

    /* renamed from: a, reason: collision with root package name */
    public e f138699a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f138700b;

    /* renamed from: c, reason: collision with root package name */
    public CharsetDecoder f138701c;

    /* renamed from: d, reason: collision with root package name */
    public final ByteBuffer f138702d;

    public f(e eVar, String str) {
        super(eVar);
        this.f138700b = false;
        ByteBuffer allocate = ByteBuffer.allocate(8192);
        this.f138702d = allocate;
        str.getClass();
        this.f138699a = eVar;
        try {
            this.f138701c = Charset.forName(str).newDecoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE);
            allocate.limit(0);
        } catch (IllegalArgumentException e16) {
            throw ((UnsupportedEncodingException) new UnsupportedEncodingException(str).initCause(e16));
        }
    }

    public static void a(int i3, int i16, int i17) {
        if ((i16 | i17) >= 0 && i16 <= i3 && i3 - i16 >= i17) {
            return;
        }
        throw new ArrayIndexOutOfBoundsException("arrayLength=" + i3 + ",offset=" + i16 + ",count=" + i17);
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (((Reader) this).lock) {
            CharsetDecoder charsetDecoder = this.f138701c;
            if (charsetDecoder != null) {
                charsetDecoder.reset();
            }
            this.f138701c = null;
            e eVar = this.f138699a;
            if (eVar != null) {
                eVar.close();
                this.f138699a = null;
            }
        }
    }

    public final boolean isOpen() {
        if (this.f138699a != null) {
            return true;
        }
        return false;
    }

    @Override // java.io.Reader
    public int read() {
        char c16;
        synchronized (((Reader) this).lock) {
            if (isOpen()) {
                char[] cArr = new char[1];
                c16 = read(cArr, 0, 1) != -1 ? cArr[0] : '\uffff';
            } else {
                throw new IOException("DataSourceReader is closed");
            }
        }
        return c16;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x003e, code lost:
    
        if (r12.position() > r13) goto L38;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00e2 A[Catch: all -> 0x00f3, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0009, B:8:0x0010, B:11:0x0012, B:15:0x0025, B:25:0x002e, B:27:0x003a, B:19:0x007f, B:21:0x008d, B:23:0x009b, B:29:0x0042, B:32:0x0047, B:34:0x006f, B:37:0x0075, B:40:0x00b1, B:42:0x00b5, B:44:0x00b9, B:45:0x00cb, B:47:0x00d1, B:49:0x00da, B:52:0x00e8, B:54:0x00e2, B:55:0x00d7, B:57:0x00ea, B:58:0x00f2), top: B:3:0x0003 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0099 -> B:14:0x00ae). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x009b -> B:14:0x00ae). Please report as a decompilation issue!!! */
    @Override // java.io.Reader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int read(char[] cArr, int i3, int i16) {
        boolean z16;
        synchronized (((Reader) this).lock) {
            if (isOpen()) {
                a(cArr.length, i3, i16);
                if (i16 == 0) {
                    return 0;
                }
                CharBuffer wrap = CharBuffer.wrap(cArr, i3, i16);
                CoderResult coderResult = CoderResult.UNDERFLOW;
                if (!this.f138702d.hasRemaining()) {
                    z16 = true;
                    int i17 = -1;
                    if (wrap.hasRemaining()) {
                        if (z16) {
                            if (this.f138699a.available() == 0) {
                            }
                            if (!this.f138700b) {
                                int read = this.f138699a.read(this.f138702d.array(), this.f138702d.arrayOffset() + this.f138702d.limit(), this.f138702d.capacity() - this.f138702d.limit());
                                if (read == -1) {
                                    this.f138700b = true;
                                } else if (read != 0) {
                                    ByteBuffer byteBuffer = this.f138702d;
                                    byteBuffer.limit(byteBuffer.limit() + read);
                                }
                            }
                        }
                        coderResult = this.f138701c.decode(this.f138702d, wrap, false);
                        if (coderResult.isUnderflow()) {
                            if (this.f138702d.limit() == this.f138702d.capacity()) {
                                this.f138702d.compact();
                                ByteBuffer byteBuffer2 = this.f138702d;
                                byteBuffer2.limit(byteBuffer2.position());
                                this.f138702d.position(0);
                            }
                            z16 = true;
                            int i172 = -1;
                            if (wrap.hasRemaining()) {
                            }
                        }
                    }
                    if (coderResult == CoderResult.UNDERFLOW && this.f138700b) {
                        coderResult = this.f138701c.decode(this.f138702d, wrap, true);
                        this.f138701c.flush(wrap);
                        this.f138701c.reset();
                    }
                    if (!coderResult.isMalformed() || coderResult.isUnmappable()) {
                        coderResult.throwException();
                    }
                    if (wrap.position() - i3 == 0) {
                        i172 = wrap.position() - i3;
                    }
                    return i172;
                }
                z16 = false;
                int i1722 = -1;
                if (wrap.hasRemaining()) {
                }
                if (coderResult == CoderResult.UNDERFLOW) {
                    coderResult = this.f138701c.decode(this.f138702d, wrap, true);
                    this.f138701c.flush(wrap);
                    this.f138701c.reset();
                }
                if (!coderResult.isMalformed()) {
                }
                coderResult.throwException();
                if (wrap.position() - i3 == 0) {
                }
                return i1722;
            }
            throw new IOException("DataSourceReader is closed");
        }
    }
}
