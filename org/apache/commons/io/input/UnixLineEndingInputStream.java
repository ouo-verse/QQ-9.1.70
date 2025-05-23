package org.apache.commons.io.input;

import java.io.IOException;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes29.dex */
public class UnixLineEndingInputStream extends InputStream {
    private final boolean ensureLineFeedAtEndOfFile;
    private final InputStream target;
    private boolean slashNSeen = false;
    private boolean slashRSeen = false;
    private boolean eofSeen = false;

    public UnixLineEndingInputStream(InputStream inputStream, boolean z16) {
        this.target = inputStream;
        this.ensureLineFeedAtEndOfFile = z16;
    }

    private int eofGame(boolean z16) {
        if (z16 || !this.ensureLineFeedAtEndOfFile || this.slashNSeen) {
            return -1;
        }
        this.slashNSeen = true;
        return 10;
    }

    private int readWithUpdate() throws IOException {
        boolean z16;
        boolean z17;
        int read = this.target.read();
        boolean z18 = true;
        if (read == -1) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.eofSeen = z16;
        if (z16) {
            return read;
        }
        if (read == 10) {
            z17 = true;
        } else {
            z17 = false;
        }
        this.slashNSeen = z17;
        if (read != 13) {
            z18 = false;
        }
        this.slashRSeen = z18;
        return read;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        super.close();
        this.target.close();
    }

    @Override // java.io.InputStream
    public synchronized void mark(int i3) {
        throw new UnsupportedOperationException("Mark notsupported");
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        boolean z16 = this.slashRSeen;
        if (this.eofSeen) {
            return eofGame(z16);
        }
        int readWithUpdate = readWithUpdate();
        if (this.eofSeen) {
            return eofGame(z16);
        }
        if (this.slashRSeen) {
            return 10;
        }
        if (z16 && this.slashNSeen) {
            return read();
        }
        return readWithUpdate;
    }
}
