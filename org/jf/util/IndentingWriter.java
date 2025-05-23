package org.jf.util;

import java.io.IOException;
import java.io.Writer;

/* compiled from: P */
/* loaded from: classes29.dex */
public class IndentingWriter extends Writer {
    private static final String newLine = System.getProperty("line.separator");
    protected final Writer writer;
    protected final char[] buffer = new char[24];
    protected int indentLevel = 0;
    private boolean beginningOfLine = true;

    public IndentingWriter(Writer writer) {
        this.writer = writer;
    }

    private void writeLine(char[] cArr, int i3, int i16) throws IOException {
        if (this.beginningOfLine && i16 > 0) {
            writeIndent();
            this.beginningOfLine = false;
        }
        this.writer.write(cArr, i3, i16);
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.writer.close();
    }

    public void deindent(int i3) {
        int i16 = this.indentLevel - i3;
        this.indentLevel = i16;
        if (i16 < 0) {
            this.indentLevel = 0;
        }
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() throws IOException {
        this.writer.flush();
    }

    public void indent(int i3) {
        int i16 = this.indentLevel + i3;
        this.indentLevel = i16;
        if (i16 < 0) {
            this.indentLevel = 0;
        }
    }

    @Override // java.io.Writer
    public void write(int i3) throws IOException {
        if (i3 == 10) {
            this.writer.write(newLine);
            this.beginningOfLine = true;
        } else {
            if (this.beginningOfLine) {
                writeIndent();
            }
            this.beginningOfLine = false;
            this.writer.write(i3);
        }
    }

    protected void writeIndent() throws IOException {
        for (int i3 = 0; i3 < this.indentLevel; i3++) {
            this.writer.write(32);
        }
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(CharSequence charSequence) throws IOException {
        write(charSequence.toString());
        return this;
    }

    private void writeLine(String str, int i3, int i16) throws IOException {
        if (this.beginningOfLine && i16 > 0) {
            writeIndent();
            this.beginningOfLine = false;
        }
        this.writer.write(str, i3, i16);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(CharSequence charSequence, int i3, int i16) throws IOException {
        write(charSequence.subSequence(i3, i16).toString());
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(char c16) throws IOException {
        write(c16);
        return this;
    }

    @Override // java.io.Writer
    public void write(char[] cArr) throws IOException {
        write(cArr, 0, cArr.length);
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i3, int i16) throws IOException {
        int i17 = i16 + i3;
        int i18 = i3;
        while (i3 < i17) {
            if (cArr[i3] == '\n') {
                writeLine(cArr, i18, i3 - i18);
                this.writer.write(newLine);
                this.beginningOfLine = true;
                i18 = i3 + 1;
                i3 = i18;
            } else {
                i3++;
            }
        }
        writeLine(cArr, i18, i3 - i18);
    }

    @Override // java.io.Writer
    public void write(String str) throws IOException {
        write(str, 0, str.length());
    }

    @Override // java.io.Writer
    public void write(String str, int i3, int i16) throws IOException {
        int i17 = i16 + i3;
        int i18 = i3;
        while (i3 < i17) {
            i3 = str.indexOf(10, i18);
            if (i3 != -1 && i3 < i17) {
                writeLine(str, i18, i3 - i18);
                this.writer.write(newLine);
                this.beginningOfLine = true;
                i18 = i3 + 1;
            } else {
                writeLine(str, i18, i17 - i18);
                return;
            }
        }
    }
}
