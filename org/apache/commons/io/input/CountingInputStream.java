package org.apache.commons.io.input;

import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes29.dex */
public class CountingInputStream extends ProxyInputStream {
    private long count;

    public CountingInputStream(InputStream inputStream) {
        super(inputStream);
    }

    @Override // org.apache.commons.io.input.ProxyInputStream
    protected synchronized void afterRead(int i3) {
        if (i3 != -1) {
            this.count += i3;
        }
    }

    public synchronized long getByteCount() {
        return this.count;
    }

    public int getCount() {
        long byteCount = getByteCount();
        if (byteCount <= TTL.MAX_VALUE) {
            return (int) byteCount;
        }
        throw new ArithmeticException("The byte count " + byteCount + " is too large to be converted to an int");
    }

    public synchronized long resetByteCount() {
        long j3;
        j3 = this.count;
        this.count = 0L;
        return j3;
    }

    public int resetCount() {
        long resetByteCount = resetByteCount();
        if (resetByteCount <= TTL.MAX_VALUE) {
            return (int) resetByteCount;
        }
        throw new ArithmeticException("The byte count " + resetByteCount + " is too large to be converted to an int");
    }

    @Override // org.apache.commons.io.input.ProxyInputStream, java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long j3) throws IOException {
        long skip;
        skip = super.skip(j3);
        this.count += skip;
        return skip;
    }
}
