package com.tencent.midas.comm.log.util.compressor;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.zip.CRC32;
import java.util.zip.Deflater;

/* compiled from: P */
/* loaded from: classes9.dex */
public class GzipCompressorOutputStream extends OutputStream {
    private boolean closed;
    private final OutputStream out;
    private final byte[] deflateBuffer = new byte[512];
    private final CRC32 crc = new CRC32();
    private final byte[] _header = {31, -117, 8, 0, 0, 0, 0, 0, 0, 0};
    private final Deflater deflater = new Deflater(-1, true);

    public GzipCompressorOutputStream(OutputStream outputStream) throws IOException {
        this.out = outputStream;
    }

    private void deflate() throws IOException {
        Deflater deflater = this.deflater;
        byte[] bArr = this.deflateBuffer;
        int deflate = deflater.deflate(bArr, 0, bArr.length);
        if (deflate > 0) {
            this.out.write(this.deflateBuffer, 0, deflate);
        }
    }

    private void writeTrailer() throws IOException {
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.putInt((int) this.crc.getValue());
        allocate.putInt(this.deflater.getTotalIn());
        this.out.write(allocate.array());
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.closed) {
            finish();
            this.deflater.end();
            this.out.close();
            this.closed = true;
        }
    }

    public void continued() throws IOException {
        this.crc.reset();
        this.deflater.reset();
    }

    public void finish() throws IOException {
        if (!this.deflater.finished()) {
            this.deflater.finish();
            while (!this.deflater.finished()) {
                deflate();
            }
            writeTrailer();
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this.out.flush();
    }

    @Override // java.io.OutputStream
    public void write(int i3) throws IOException {
        write(new byte[]{(byte) (i3 & 255)}, 0, 1);
    }

    public void writeHeader() throws IOException {
        this.out.write(this._header);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i3, int i16) throws IOException {
        if (this.deflater.finished()) {
            throw new IOException("Cannot write more data, the end of the compressed data stream has been reached");
        }
        if (i16 > 0) {
            this.deflater.setInput(bArr, i3, i16);
            while (!this.deflater.needsInput()) {
                deflate();
            }
            this.crc.update(bArr, i3, i16);
        }
    }
}
