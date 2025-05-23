package com.tencent.qphone.base.util.log;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;

/* compiled from: P */
/* loaded from: classes22.dex */
public class QLogWriter extends QWriter {
    static boolean mCanRecycle = true;
    static Field sBackingArrayField;
    static Field sCapacityField;
    static Class sCharBufferClass;
    private ByteBuffer bytes;
    private CharsetEncoder encoder;
    boolean mInited;
    CharBuffer mRecycleBuffer;
    private final OutputStream out;

    public QLogWriter(OutputStream outputStream) {
        this(outputStream, Charset.defaultCharset());
    }

    public static void checkOffsetAndCount(int i3, int i16, int i17) {
        if ((i16 | i17) >= 0 && i16 <= i3 && i3 - i16 >= i17) {
            return;
        }
        StringBuilder sb5 = new StringBuilder(50);
        sb5.append("length=");
        sb5.append(i3);
        sb5.append("; regionStart=");
        sb5.append(i16);
        sb5.append("; regionLength=");
        sb5.append(i17);
        throw new ArrayIndexOutOfBoundsException(sb5.toString());
    }

    private void checkStatus() throws IOException {
        if (this.encoder != null) {
        } else {
            throw new IOException("OutputStreamWriter is closed");
        }
    }

    private void convert(CharBuffer charBuffer) throws IOException {
        CoderResult encode;
        while (true) {
            encode = this.encoder.encode(charBuffer, this.bytes, false);
            if (!encode.isOverflow()) {
                break;
            } else {
                flushBytes(false);
            }
        }
        if (encode.isError()) {
            encode.throwException();
        }
    }

    private void drainEncoder() throws IOException {
        CharBuffer allocate = CharBuffer.allocate(0);
        while (true) {
            CoderResult encode = this.encoder.encode(allocate, this.bytes, true);
            if (encode.isError()) {
                encode.throwException();
                break;
            } else if (!encode.isOverflow()) {
                break;
            } else {
                flushBytes(false);
            }
        }
        CoderResult flush = this.encoder.flush(this.bytes);
        while (!flush.isUnderflow()) {
            if (flush.isOverflow()) {
                flushBytes(false);
                flush = this.encoder.flush(this.bytes);
            } else {
                flush.throwException();
            }
        }
    }

    private void flushBytes(boolean z16) throws IOException {
        synchronized (((Writer) this).lock) {
            checkStatus();
            int position = this.bytes.position();
            if (position > 0) {
                this.bytes.flip();
                this.out.write(this.bytes.array(), this.bytes.arrayOffset(), position);
                this.bytes.clear();
            }
            if (z16) {
                this.out.flush();
            }
        }
    }

    private CharBuffer wrap(char[] cArr, int i3, int i16) {
        Class cls;
        if (!this.mInited) {
            CharBuffer wrap = CharBuffer.wrap(cArr, i3, i16);
            this.mRecycleBuffer = wrap;
            this.mInited = true;
            return wrap;
        }
        if (mCanRecycle) {
            this.mRecycleBuffer.clear();
            try {
                if (sCharBufferClass == null || sBackingArrayField == null || sCapacityField == null) {
                    Class<?> cls2 = Class.forName("java.nio.CharArrayBuffer");
                    sCharBufferClass = cls2;
                    sBackingArrayField = cls2.getDeclaredField("backingArray");
                    sCapacityField = sCharBufferClass.getSuperclass().getSuperclass().getDeclaredField("capacity");
                    Field field = sBackingArrayField;
                    if (field != null) {
                        field.setAccessible(true);
                    }
                    Field field2 = sCapacityField;
                    if (field2 != null) {
                        field2.setAccessible(true);
                    }
                }
                if (sCapacityField != null && sBackingArrayField != null && (cls = sCharBufferClass) != null && cls.isInstance(this.mRecycleBuffer)) {
                    sBackingArrayField.set(this.mRecycleBuffer, cArr);
                    sCapacityField.set(this.mRecycleBuffer, LargerInteger.valueOf(cArr.length));
                    this.mRecycleBuffer.position(i3);
                    this.mRecycleBuffer.limit(i3 + i16);
                    return this.mRecycleBuffer;
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
            mCanRecycle = false;
            this.mRecycleBuffer = null;
        }
        return CharBuffer.wrap(cArr, i3, i16);
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (((Writer) this).lock) {
            if (this.encoder != null) {
                drainEncoder();
                flushBytes(false);
                this.out.close();
                this.encoder = null;
                this.bytes = null;
            }
        }
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() throws IOException {
        flushBytes(true);
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i3, int i16) throws IOException {
        synchronized (((Writer) this).lock) {
            checkStatus();
            checkOffsetAndCount(cArr.length, i3, i16);
            convert(wrap(cArr, i3, i16));
        }
    }

    public QLogWriter(OutputStream outputStream, String str) throws UnsupportedEncodingException {
        super(outputStream);
        this.bytes = ByteBuffer.allocate(8192);
        this.mInited = false;
        str.getClass();
        this.out = outputStream;
        try {
            CharsetEncoder newEncoder = Charset.forName(str).newEncoder();
            this.encoder = newEncoder;
            newEncoder.onMalformedInput(CodingErrorAction.REPLACE);
            this.encoder.onUnmappableCharacter(CodingErrorAction.REPLACE);
        } catch (Exception unused) {
            throw new UnsupportedEncodingException(str);
        }
    }

    @Override // com.tencent.qphone.base.util.log.QWriter
    public void write(byte[] bArr, int i3, int i16) throws IOException {
        synchronized (((Writer) this).lock) {
            checkOffsetAndCount(bArr.length, i3, i16);
            if (this.bytes.capacity() - this.bytes.limit() < i16) {
                flushBytes(false);
            }
            this.bytes.put(bArr, i3, i16);
            if (this.bytes.limit() == this.bytes.capacity()) {
                flushBytes(false);
            }
        }
    }

    public QLogWriter(File file, boolean z16) throws IOException {
        this(new BufferedOutputStream(new FileOutputStream(file, z16)));
    }

    public QLogWriter(OutputStream outputStream, Charset charset) {
        super(outputStream);
        this.bytes = ByteBuffer.allocate(8192);
        this.mInited = false;
        this.out = outputStream;
        CharsetEncoder newEncoder = charset.newEncoder();
        this.encoder = newEncoder;
        newEncoder.onMalformedInput(CodingErrorAction.REPLACE);
        this.encoder.onUnmappableCharacter(CodingErrorAction.REPLACE);
    }

    @Override // java.io.Writer
    public void write(int i3) throws IOException {
        synchronized (((Writer) this).lock) {
            checkStatus();
            convert(CharBuffer.wrap(new char[]{(char) i3}));
        }
    }

    public QLogWriter(OutputStream outputStream, CharsetEncoder charsetEncoder) {
        super(outputStream);
        this.bytes = ByteBuffer.allocate(8192);
        this.mInited = false;
        charsetEncoder.charset();
        this.out = outputStream;
        this.encoder = charsetEncoder;
    }

    @Override // java.io.Writer
    public void write(String str, int i3, int i16) throws IOException {
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
                    checkStatus();
                    convert(CharBuffer.wrap(str, i3, i16 + i3));
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
}
