package org.apache.commons.io.output;

import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;

/* compiled from: P */
/* loaded from: classes29.dex */
public class WriterOutputStream extends OutputStream {
    private static final int DEFAULT_BUFFER_SIZE = 1024;
    private final CharsetDecoder decoder;
    private final ByteBuffer decoderIn;
    private final CharBuffer decoderOut;
    private final boolean writeImmediately;
    private final Writer writer;

    public WriterOutputStream(Writer writer, CharsetDecoder charsetDecoder) {
        this(writer, charsetDecoder, 1024, false);
    }

    private static void checkIbmJdkWithBrokenUTF16(Charset charset) {
        boolean z16;
        if (!"UTF-16".equals(charset.name())) {
            return;
        }
        byte[] bytes = "v\u00e9s".getBytes(charset);
        CharsetDecoder newDecoder = charset.newDecoder();
        ByteBuffer allocate = ByteBuffer.allocate(16);
        CharBuffer allocate2 = CharBuffer.allocate(3);
        int length = bytes.length;
        for (int i3 = 0; i3 < length; i3++) {
            allocate.put(bytes[i3]);
            allocate.flip();
            if (i3 == length - 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            try {
                newDecoder.decode(allocate, allocate2, z16);
                allocate.compact();
            } catch (IllegalArgumentException unused) {
                throw new UnsupportedOperationException("UTF-16 requested when runninng on an IBM JDK with broken UTF-16 support. Please find a JDK that supports UTF-16 if you intend to use UF-16 with WriterOutputStream");
            }
        }
        allocate2.rewind();
        if (!"v\u00e9s".equals(allocate2.toString())) {
            throw new UnsupportedOperationException("UTF-16 requested when runninng on an IBM JDK with broken UTF-16 support. Please find a JDK that supports UTF-16 if you intend to use UF-16 with WriterOutputStream");
        }
    }

    private void flushOutput() throws IOException {
        if (this.decoderOut.position() > 0) {
            this.writer.write(this.decoderOut.array(), 0, this.decoderOut.position());
            this.decoderOut.rewind();
        }
    }

    private void processInput(boolean z16) throws IOException {
        CoderResult decode;
        this.decoderIn.flip();
        while (true) {
            decode = this.decoder.decode(this.decoderIn, this.decoderOut, z16);
            if (!decode.isOverflow()) {
                break;
            } else {
                flushOutput();
            }
        }
        if (decode.isUnderflow()) {
            this.decoderIn.compact();
            return;
        }
        throw new IOException("Unexpected coder result");
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        processInput(true);
        flushOutput();
        this.writer.close();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        flushOutput();
        this.writer.flush();
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i3, int i16) throws IOException {
        while (i16 > 0) {
            int min = Math.min(i16, this.decoderIn.remaining());
            this.decoderIn.put(bArr, i3, min);
            processInput(false);
            i16 -= min;
            i3 += min;
        }
        if (this.writeImmediately) {
            flushOutput();
        }
    }

    public WriterOutputStream(Writer writer, CharsetDecoder charsetDecoder, int i3, boolean z16) {
        this.decoderIn = ByteBuffer.allocate(128);
        checkIbmJdkWithBrokenUTF16(charsetDecoder.charset());
        this.writer = writer;
        this.decoder = charsetDecoder;
        this.writeImmediately = z16;
        this.decoderOut = CharBuffer.allocate(i3);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(int i3) throws IOException {
        write(new byte[]{(byte) i3}, 0, 1);
    }

    public WriterOutputStream(Writer writer, Charset charset, int i3, boolean z16) {
        this(writer, charset.newDecoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE).replaceWith(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER), i3, z16);
    }

    public WriterOutputStream(Writer writer, Charset charset) {
        this(writer, charset, 1024, false);
    }

    public WriterOutputStream(Writer writer, String str, int i3, boolean z16) {
        this(writer, Charset.forName(str), i3, z16);
    }

    public WriterOutputStream(Writer writer, String str) {
        this(writer, str, 1024, false);
    }

    @Deprecated
    public WriterOutputStream(Writer writer) {
        this(writer, Charset.defaultCharset(), 1024, false);
    }
}
