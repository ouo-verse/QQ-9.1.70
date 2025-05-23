package org.apache.commons.io.output;

import java.io.Writer;

/* compiled from: P */
/* loaded from: classes29.dex */
public class NullWriter extends Writer {
    public static final NullWriter NULL_WRITER = new NullWriter();

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(char c16) {
        return this;
    }

    @Override // java.io.Writer
    public void write(int i3) {
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(CharSequence charSequence) {
        return this;
    }

    @Override // java.io.Writer
    public void write(String str) {
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(CharSequence charSequence, int i3, int i16) {
        return this;
    }

    @Override // java.io.Writer
    public void write(String str, int i3, int i16) {
    }

    @Override // java.io.Writer
    public void write(char[] cArr) {
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i3, int i16) {
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
    }
}
