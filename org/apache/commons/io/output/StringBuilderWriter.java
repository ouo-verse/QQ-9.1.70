package org.apache.commons.io.output;

import java.io.Serializable;
import java.io.Writer;

/* compiled from: P */
/* loaded from: classes29.dex */
public class StringBuilderWriter extends Writer implements Serializable {
    private static final long serialVersionUID = -146927496096066153L;
    private final StringBuilder builder;

    public StringBuilderWriter() {
        this.builder = new StringBuilder();
    }

    public StringBuilder getBuilder() {
        return this.builder;
    }

    public String toString() {
        return this.builder.toString();
    }

    @Override // java.io.Writer
    public void write(String str) {
        if (str != null) {
            this.builder.append(str);
        }
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i3, int i16) {
        if (cArr != null) {
            this.builder.append(cArr, i3, i16);
        }
    }

    public StringBuilderWriter(int i3) {
        this.builder = new StringBuilder(i3);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(char c16) {
        this.builder.append(c16);
        return this;
    }

    public StringBuilderWriter(StringBuilder sb5) {
        this.builder = sb5 == null ? new StringBuilder() : sb5;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(CharSequence charSequence) {
        this.builder.append(charSequence);
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(CharSequence charSequence, int i3, int i16) {
        this.builder.append(charSequence, i3, i16);
        return this;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
    }
}
