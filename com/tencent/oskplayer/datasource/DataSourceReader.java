package com.tencent.oskplayer.datasource;

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
/* loaded from: classes22.dex */
public class DataSourceReader extends Reader {
    private final ByteBuffer bytes;
    private CharsetDecoder decoder;
    private boolean endOfInput;

    /* renamed from: in, reason: collision with root package name */
    private DataSource f341932in;

    public DataSourceReader(DataSource dataSource) {
        this(dataSource, Charset.defaultCharset());
    }

    public static void checkOffsetAndCount(int i3, int i16, int i17) {
        if ((i16 | i17) >= 0 && i16 <= i3 && i3 - i16 >= i17) {
            return;
        }
        throw new ArrayIndexOutOfBoundsException("arrayLength=" + i3 + ",offset=" + i16 + ",count=" + i17);
    }

    private boolean isOpen() {
        if (this.f341932in != null) {
            return true;
        }
        return false;
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (((Reader) this).lock) {
            CharsetDecoder charsetDecoder = this.decoder;
            if (charsetDecoder != null) {
                charsetDecoder.reset();
            }
            this.decoder = null;
            DataSource dataSource = this.f341932in;
            if (dataSource != null) {
                dataSource.close();
                this.f341932in = null;
            }
        }
    }

    @Override // java.io.Reader
    public int read() throws IOException {
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

    public DataSourceReader(DataSource dataSource, String str) throws UnsupportedEncodingException {
        super(dataSource);
        this.endOfInput = false;
        ByteBuffer allocate = ByteBuffer.allocate(8192);
        this.bytes = allocate;
        str.getClass();
        this.f341932in = dataSource;
        try {
            this.decoder = Charset.forName(str).newDecoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE);
            allocate.limit(0);
        } catch (IllegalArgumentException e16) {
            throw ((UnsupportedEncodingException) new UnsupportedEncodingException(str).initCause(e16));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x003d, code lost:
    
        if (r11.position() > r12) goto L38;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00e1 A[Catch: all -> 0x00f2, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0009, B:8:0x0010, B:11:0x0012, B:15:0x0024, B:25:0x002d, B:27:0x0039, B:19:0x007e, B:21:0x008c, B:23:0x009a, B:29:0x0041, B:32:0x0046, B:34:0x006e, B:37:0x0074, B:40:0x00b0, B:42:0x00b4, B:44:0x00b8, B:45:0x00ca, B:47:0x00d0, B:49:0x00d9, B:52:0x00e7, B:54:0x00e1, B:55:0x00d6, B:57:0x00e9, B:58:0x00f1), top: B:3:0x0003 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0098 -> B:14:0x00ad). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x009a -> B:14:0x00ad). Please report as a decompilation issue!!! */
    @Override // java.io.Reader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int read(char[] cArr, int i3, int i16) throws IOException {
        boolean z16;
        synchronized (((Reader) this).lock) {
            if (isOpen()) {
                checkOffsetAndCount(cArr.length, i3, i16);
                if (i16 == 0) {
                    return 0;
                }
                CharBuffer wrap = CharBuffer.wrap(cArr, i3, i16);
                CoderResult coderResult = CoderResult.UNDERFLOW;
                if (!this.bytes.hasRemaining()) {
                    z16 = true;
                    int i17 = -1;
                    if (wrap.hasRemaining()) {
                        if (z16) {
                            if (this.f341932in.available() == 0) {
                            }
                            if (!this.endOfInput) {
                                int read = this.f341932in.read(this.bytes.array(), this.bytes.arrayOffset() + this.bytes.limit(), this.bytes.capacity() - this.bytes.limit());
                                if (read == -1) {
                                    this.endOfInput = true;
                                } else if (read != 0) {
                                    ByteBuffer byteBuffer = this.bytes;
                                    byteBuffer.limit(byteBuffer.limit() + read);
                                }
                            }
                        }
                        coderResult = this.decoder.decode(this.bytes, wrap, false);
                        if (coderResult.isUnderflow()) {
                            if (this.bytes.limit() == this.bytes.capacity()) {
                                this.bytes.compact();
                                ByteBuffer byteBuffer2 = this.bytes;
                                byteBuffer2.limit(byteBuffer2.position());
                                this.bytes.position(0);
                            }
                            z16 = true;
                            int i172 = -1;
                            if (wrap.hasRemaining()) {
                            }
                        }
                    }
                    if (coderResult == CoderResult.UNDERFLOW && this.endOfInput) {
                        coderResult = this.decoder.decode(this.bytes, wrap, true);
                        this.decoder.flush(wrap);
                        this.decoder.reset();
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
                    coderResult = this.decoder.decode(this.bytes, wrap, true);
                    this.decoder.flush(wrap);
                    this.decoder.reset();
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

    public DataSourceReader(DataSource dataSource, CharsetDecoder charsetDecoder) {
        super(dataSource);
        this.endOfInput = false;
        ByteBuffer allocate = ByteBuffer.allocate(8192);
        this.bytes = allocate;
        charsetDecoder.averageCharsPerByte();
        this.f341932in = dataSource;
        this.decoder = charsetDecoder;
        allocate.limit(0);
    }

    public DataSourceReader(DataSource dataSource, Charset charset) {
        super(dataSource);
        this.endOfInput = false;
        ByteBuffer allocate = ByteBuffer.allocate(8192);
        this.bytes = allocate;
        this.f341932in = dataSource;
        this.decoder = charset.newDecoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE);
        allocate.limit(0);
    }
}
