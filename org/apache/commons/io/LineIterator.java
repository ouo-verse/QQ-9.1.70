package org.apache.commons.io;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: P */
/* loaded from: classes29.dex */
public class LineIterator implements Iterator<String>, Closeable {
    private final BufferedReader bufferedReader;
    private String cachedLine;
    private boolean finished = false;

    public LineIterator(Reader reader) throws IllegalArgumentException {
        if (reader != null) {
            if (reader instanceof BufferedReader) {
                this.bufferedReader = (BufferedReader) reader;
                return;
            } else {
                this.bufferedReader = new BufferedReader(reader);
                return;
            }
        }
        throw new IllegalArgumentException("Reader must not be null");
    }

    @Deprecated
    public static void closeQuietly(LineIterator lineIterator) {
        if (lineIterator != null) {
            try {
                lineIterator.close();
            } catch (IOException unused) {
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.finished = true;
        this.cachedLine = null;
        BufferedReader bufferedReader = this.bufferedReader;
        if (bufferedReader != null) {
            bufferedReader.close();
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        String readLine;
        if (this.cachedLine != null) {
            return true;
        }
        if (this.finished) {
            return false;
        }
        do {
            try {
                readLine = this.bufferedReader.readLine();
                if (readLine == null) {
                    this.finished = true;
                    return false;
                }
            } catch (IOException e16) {
                try {
                    close();
                } catch (IOException e17) {
                    e16.addSuppressed(e17);
                }
                throw new IllegalStateException(e16);
            }
        } while (!isValidLine(readLine));
        this.cachedLine = readLine;
        return true;
    }

    protected boolean isValidLine(String str) {
        return true;
    }

    public String nextLine() {
        if (hasNext()) {
            String str = this.cachedLine;
            this.cachedLine = null;
            return str;
        }
        throw new NoSuchElementException("No more lines");
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Remove unsupported on LineIterator");
    }

    @Override // java.util.Iterator
    public String next() {
        return nextLine();
    }
}
