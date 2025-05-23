package com.tencent.mobileqq.mini.appbrand.utils;

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
import okio.Utf8;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniLogWriter extends Writer {
    static boolean mCanRecycle = true;
    static Field sBackingArrayField;
    static Field sCapacityField;
    static Class sCharBufferClass;
    private ByteBuffer bytes;
    private CharsetEncoder encoder;
    boolean mInited;
    CharBuffer mRecycleBuffer;
    private final OutputStream out;

    public MiniLogWriter(OutputStream outputStream) {
        this(outputStream, Charset.defaultCharset());
    }

    private void checkStatus() throws IOException {
        if (this.encoder == null) {
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

    @Override // java.io.Writer
    public void write(char[] cArr, int i3, int i16) throws IOException {
        synchronized (((Writer) this).lock) {
            checkStatus();
            checkOffsetAndCount(cArr.length, i3, i16);
            convert(wrap(cArr, i3, i16));
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class LargerInteger {
        private static final Integer[] LARGER_VALUES = new Integer[Utf8.MASK_2BYTES];
        private static final int MAX = 4096;

        static {
            for (int i3 = 128; i3 < 4096; i3++) {
                LARGER_VALUES[i3 - 128] = new Integer(i3);
            }
        }

        public static Integer valueOf(int i3) {
            if (i3 >= 128 && i3 < 4096) {
                i3 = LARGER_VALUES[i3 - 128].intValue();
            }
            return Integer.valueOf(i3);
        }
    }

    public MiniLogWriter(OutputStream outputStream, String str) throws UnsupportedEncodingException {
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

    @Override // java.io.Writer, java.io.Flushable
    public void flush() throws IOException {
        flushBytes(true);
    }

    @Override // java.io.Writer
    public void write(int i3) throws IOException {
        synchronized (((Writer) this).lock) {
            checkStatus();
            convert(CharBuffer.wrap(new char[]{(char) i3}));
        }
    }

    public MiniLogWriter(File file, boolean z16) throws IOException {
        this(new BufferedOutputStream(new FileOutputStream(file, z16)));
    }

    public MiniLogWriter(OutputStream outputStream, Charset charset) {
        super(outputStream);
        this.bytes = ByteBuffer.allocate(8192);
        this.mInited = false;
        this.out = outputStream;
        CharsetEncoder newEncoder = charset.newEncoder();
        this.encoder = newEncoder;
        newEncoder.onMalformedInput(CodingErrorAction.REPLACE);
        this.encoder.onUnmappableCharacter(CodingErrorAction.REPLACE);
    }

    public static void checkOffsetAndCount(int i3, int i16, int i17) {
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

    public MiniLogWriter(OutputStream outputStream, CharsetEncoder charsetEncoder) {
        super(outputStream);
        this.bytes = ByteBuffer.allocate(8192);
        this.mInited = false;
        charsetEncoder.charset();
        this.out = outputStream;
        this.encoder = charsetEncoder;
    }
}
