package com.tencent.component.network.downloader.impl.strategy;

import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;

/* loaded from: classes5.dex */
public class ExGZIPInputStream extends GZIPInputStream {
    protected long realReadLen;

    public ExGZIPInputStream(InputStream inputStream) throws IOException {
        super(inputStream);
        this.realReadLen = 0L;
    }

    @Override // java.util.zip.InflaterInputStream
    protected void fill() throws IOException {
        super.fill();
        this.realReadLen += ((GZIPInputStream) this).len;
    }

    public long getRealReadLen() {
        return this.realReadLen + 10;
    }

    public ExGZIPInputStream(InputStream inputStream, int i3) throws IOException {
        super(inputStream, i3);
        this.realReadLen = 0L;
    }
}
