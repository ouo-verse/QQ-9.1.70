package org.apache.commons.io.input;

import java.io.Reader;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes29.dex */
public class CharSequenceReader extends Reader implements Serializable {
    private static final long serialVersionUID = 3724187752191401220L;
    private final CharSequence charSequence;
    private int idx;
    private int mark;

    public CharSequenceReader(String str) {
        this.charSequence = str == null ? "" : str;
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.idx = 0;
        this.mark = 0;
    }

    @Override // java.io.Reader
    public void mark(int i3) {
        this.mark = this.idx;
    }

    @Override // java.io.Reader
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.Reader
    public int read() {
        if (this.idx >= this.charSequence.length()) {
            return -1;
        }
        CharSequence charSequence = this.charSequence;
        int i3 = this.idx;
        this.idx = i3 + 1;
        return charSequence.charAt(i3);
    }

    @Override // java.io.Reader
    public void reset() {
        this.idx = this.mark;
    }

    @Override // java.io.Reader
    public long skip(long j3) {
        if (j3 >= 0) {
            if (this.idx >= this.charSequence.length()) {
                return -1L;
            }
            int min = (int) Math.min(this.charSequence.length(), this.idx + j3);
            int i3 = min - this.idx;
            this.idx = min;
            return i3;
        }
        throw new IllegalArgumentException("Number of characters to skip is less than zero: " + j3);
    }

    public String toString() {
        return this.charSequence.toString();
    }

    @Override // java.io.Reader
    public int read(char[] cArr, int i3, int i16) {
        if (this.idx >= this.charSequence.length()) {
            return -1;
        }
        if (cArr != null) {
            if (i16 < 0 || i3 < 0 || i3 + i16 > cArr.length) {
                throw new IndexOutOfBoundsException("Array Size=" + cArr.length + ", offset=" + i3 + ", length=" + i16);
            }
            int i17 = 0;
            for (int i18 = 0; i18 < i16; i18++) {
                int read = read();
                if (read == -1) {
                    return i17;
                }
                cArr[i3 + i18] = (char) read;
                i17++;
            }
            return i17;
        }
        throw new NullPointerException("Character array is missing");
    }
}
