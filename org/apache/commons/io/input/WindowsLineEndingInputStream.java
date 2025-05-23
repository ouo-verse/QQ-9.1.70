package org.apache.commons.io.input;

import java.io.IOException;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes29.dex */
public class WindowsLineEndingInputStream extends InputStream {
    private final boolean ensureLineFeedAtEndOfFile;
    private final InputStream target;
    private boolean slashRSeen = false;
    private boolean slashNSeen = false;
    private boolean injectSlashN = false;
    private boolean eofSeen = false;

    public WindowsLineEndingInputStream(InputStream inputStream, boolean z16) {
        this.target = inputStream;
        this.ensureLineFeedAtEndOfFile = z16;
    }

    private int eofGame() {
        if (!this.ensureLineFeedAtEndOfFile) {
            return -1;
        }
        boolean z16 = this.slashNSeen;
        if (!z16 && !this.slashRSeen) {
            this.slashRSeen = true;
            return 13;
        }
        if (z16) {
            return -1;
        }
        this.slashRSeen = false;
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
        if (read == 13) {
            z17 = true;
        } else {
            z17 = false;
        }
        this.slashRSeen = z17;
        if (read != 10) {
            z18 = false;
        }
        this.slashNSeen = z18;
        return read;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        super.close();
        this.target.close();
    }

    @Override // java.io.InputStream
    public synchronized void mark(int i3) {
        throw new UnsupportedOperationException("Mark not supported");
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.eofSeen) {
            return eofGame();
        }
        if (this.injectSlashN) {
            this.injectSlashN = false;
            return 10;
        }
        boolean z16 = this.slashRSeen;
        int readWithUpdate = readWithUpdate();
        if (this.eofSeen) {
            return eofGame();
        }
        if (readWithUpdate == 10 && !z16) {
            this.injectSlashN = true;
            return 13;
        }
        return readWithUpdate;
    }
}
