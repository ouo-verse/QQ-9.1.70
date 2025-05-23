package org.light.extDecoder.apng.io;

import java.io.IOException;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes29.dex */
public class FilterReader implements Reader {
    protected Reader reader;

    public FilterReader(Reader reader) {
        this.reader = reader;
    }

    @Override // org.light.extDecoder.apng.io.Reader
    public int available() throws IOException {
        return this.reader.available();
    }

    @Override // org.light.extDecoder.apng.io.Reader
    public void close() throws IOException {
        this.reader.close();
    }

    @Override // org.light.extDecoder.apng.io.Reader
    public byte peek() throws IOException {
        return this.reader.peek();
    }

    @Override // org.light.extDecoder.apng.io.Reader
    public int position() {
        return this.reader.position();
    }

    @Override // org.light.extDecoder.apng.io.Reader
    public int read(byte[] bArr, int i3, int i16) throws IOException {
        return this.reader.read(bArr, i3, i16);
    }

    @Override // org.light.extDecoder.apng.io.Reader
    public void reset() throws IOException {
        this.reader.reset();
    }

    @Override // org.light.extDecoder.apng.io.Reader
    public long skip(long j3) throws IOException {
        return this.reader.skip(j3);
    }

    @Override // org.light.extDecoder.apng.io.Reader
    public InputStream toInputStream() throws IOException {
        reset();
        return this.reader.toInputStream();
    }
}
