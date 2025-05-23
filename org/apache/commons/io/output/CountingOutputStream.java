package org.apache.commons.io.output;

import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import java.io.OutputStream;

/* compiled from: P */
/* loaded from: classes29.dex */
public class CountingOutputStream extends ProxyOutputStream {
    private long count;

    public CountingOutputStream(OutputStream outputStream) {
        super(outputStream);
        this.count = 0L;
    }

    @Override // org.apache.commons.io.output.ProxyOutputStream
    protected synchronized void beforeWrite(int i3) {
        this.count += i3;
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
}
