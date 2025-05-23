package org.light.extDecoder.apng.io;

import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.light.utils.LightLogUtil;

/* compiled from: P */
/* loaded from: classes29.dex */
public class StreamReader extends FilterInputStream implements Reader {
    private static final String TAG = "StreamReader";
    private int position;

    public StreamReader(InputStream inputStream) {
        super(inputStream);
        if (!(inputStream instanceof FileInputStream)) {
            try {
                inputStream.reset();
            } catch (IOException e16) {
                LightLogUtil.e(TAG, e16.getMessage(), e16);
            }
        }
    }

    @Override // org.light.extDecoder.apng.io.Reader
    public byte peek() throws IOException {
        byte read = (byte) read();
        this.position++;
        return read;
    }

    @Override // org.light.extDecoder.apng.io.Reader
    public int position() {
        return this.position;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, org.light.extDecoder.apng.io.Reader
    public int read(byte[] bArr, int i3, int i16) throws IOException {
        int read = super.read(bArr, i3, i16);
        this.position += Math.max(0, read);
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, org.light.extDecoder.apng.io.Reader
    public synchronized void reset() throws IOException {
        super.reset();
        this.position = 0;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, org.light.extDecoder.apng.io.Reader
    public long skip(long j3) throws IOException {
        long skip = super.skip(j3);
        this.position = (int) (this.position + skip);
        return skip;
    }

    @Override // org.light.extDecoder.apng.io.Reader
    public InputStream toInputStream() throws IOException {
        return this;
    }
}
