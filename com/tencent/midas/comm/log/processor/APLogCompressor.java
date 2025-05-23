package com.tencent.midas.comm.log.processor;

import com.tencent.midas.comm.log.util.compressor.CachedByteArrayStream;
import com.tencent.midas.comm.log.util.compressor.GzipCompressorOutputStream;
import java.io.IOException;

/* loaded from: classes9.dex */
public class APLogCompressor {
    private CachedByteArrayStream out = null;
    private GzipCompressorOutputStream gziper = null;

    public static APLogCompressor create() {
        APLogCompressor aPLogCompressor = new APLogCompressor();
        try {
            aPLogCompressor.out = new CachedByteArrayStream(512);
            aPLogCompressor.gziper = new GzipCompressorOutputStream(aPLogCompressor.out);
            return aPLogCompressor;
        } catch (IOException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public void close() throws IOException {
        GzipCompressorOutputStream gzipCompressorOutputStream = this.gziper;
        if (gzipCompressorOutputStream != null) {
            gzipCompressorOutputStream.close();
        }
        CachedByteArrayStream cachedByteArrayStream = this.out;
        if (cachedByteArrayStream != null) {
            cachedByteArrayStream.close();
        }
    }

    public synchronized byte[] compress(byte[] bArr) throws IOException {
        this.gziper.continued();
        this.out.reset();
        this.gziper.writeHeader();
        this.gziper.write(bArr, 0, bArr.length);
        this.gziper.finish();
        this.gziper.flush();
        return this.out.toByteArray();
    }
}
