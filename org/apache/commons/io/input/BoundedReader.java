package org.apache.commons.io.input;

import java.io.IOException;
import java.io.Reader;

/* compiled from: P */
/* loaded from: classes29.dex */
public class BoundedReader extends Reader {
    private static final int INVALID = -1;
    private int charsRead = 0;
    private int markedAt = -1;
    private final int maxCharsFromTargetReader;
    private int readAheadLimit;
    private final Reader target;

    public BoundedReader(Reader reader, int i3) throws IOException {
        this.target = reader;
        this.maxCharsFromTargetReader = i3;
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.target.close();
    }

    @Override // java.io.Reader
    public void mark(int i3) throws IOException {
        int i16 = this.charsRead;
        this.readAheadLimit = i3 - i16;
        this.markedAt = i16;
        this.target.mark(i3);
    }

    @Override // java.io.Reader
    public int read() throws IOException {
        int i3 = this.charsRead;
        if (i3 >= this.maxCharsFromTargetReader) {
            return -1;
        }
        int i16 = this.markedAt;
        if (i16 >= 0 && i3 - i16 >= this.readAheadLimit) {
            return -1;
        }
        this.charsRead = i3 + 1;
        return this.target.read();
    }

    @Override // java.io.Reader
    public void reset() throws IOException {
        this.charsRead = this.markedAt;
        this.target.reset();
    }

    @Override // java.io.Reader
    public int read(char[] cArr, int i3, int i16) throws IOException {
        for (int i17 = 0; i17 < i16; i17++) {
            int read = read();
            if (read == -1) {
                if (i17 == 0) {
                    return -1;
                }
                return i17;
            }
            cArr[i3 + i17] = (char) read;
        }
        return i16;
    }
}
