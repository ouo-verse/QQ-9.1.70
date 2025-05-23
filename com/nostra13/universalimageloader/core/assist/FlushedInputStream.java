package com.nostra13.universalimageloader.core.assist;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes2.dex */
public class FlushedInputStream extends FilterInputStream {
    public FlushedInputStream(InputStream inputStream) {
        super(inputStream);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j3) throws IOException {
        long j16 = 0;
        while (j16 < j3) {
            long skip = ((FilterInputStream) this).in.skip(j3 - j16);
            if (skip == 0) {
                if (read() < 0) {
                    break;
                }
                skip = 1;
            }
            j16 += skip;
        }
        return j16;
    }
}
