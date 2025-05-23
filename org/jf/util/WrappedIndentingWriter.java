package org.jf.util;

import com.google.common.collect.Lists;
import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes29.dex */
public class WrappedIndentingWriter extends FilterWriter {
    private int currentIndent;
    private final StringBuilder line;
    private final int maxIndent;
    private final int maxWidth;

    public WrappedIndentingWriter(Writer writer, int i3, int i16) {
        super(writer);
        this.currentIndent = 0;
        this.line = new StringBuilder();
        this.maxIndent = i3;
        this.maxWidth = i16;
    }

    private int getIndent() {
        int i3 = this.currentIndent;
        if (i3 < 0) {
            return 0;
        }
        int i16 = this.maxIndent;
        if (i3 > i16) {
            return i16;
        }
        return i3;
    }

    private void wrapLine() throws IOException {
        ArrayList i3 = Lists.i(StringWrapper.wrapStringOnBreaks(this.line.toString(), this.maxWidth));
        ((FilterWriter) this).out.write((String) i3.get(0), 0, ((String) i3.get(0)).length());
        ((FilterWriter) this).out.write(10);
        StringBuilder sb5 = this.line;
        sb5.replace(0, sb5.length(), "");
        writeIndent();
        for (int i16 = 1; i16 < i3.size(); i16++) {
            if (i16 > 1) {
                write(10);
            }
            write((String) i3.get(i16));
        }
    }

    private void writeIndent() throws IOException {
        for (int i3 = 0; i3 < getIndent(); i3++) {
            write(32);
        }
    }

    public void deindent(int i3) {
        this.currentIndent -= i3;
    }

    @Override // java.io.FilterWriter, java.io.Writer, java.io.Flushable
    public void flush() throws IOException {
        ((FilterWriter) this).out.write(this.line.toString());
        StringBuilder sb5 = this.line;
        sb5.replace(0, sb5.length(), "");
    }

    public void indent(int i3) {
        this.currentIndent += i3;
    }

    @Override // java.io.FilterWriter, java.io.Writer
    public void write(int i3) throws IOException {
        if (i3 == 10) {
            ((FilterWriter) this).out.write(this.line.toString());
            ((FilterWriter) this).out.write(i3);
            StringBuilder sb5 = this.line;
            sb5.replace(0, sb5.length(), "");
            writeIndent();
            return;
        }
        this.line.append((char) i3);
        if (this.line.length() > this.maxWidth) {
            wrapLine();
        }
    }

    @Override // java.io.FilterWriter, java.io.Writer
    public void write(char[] cArr, int i3, int i16) throws IOException {
        for (int i17 = 0; i17 < i16; i17++) {
            write(cArr[i17 + i3]);
        }
    }

    @Override // java.io.FilterWriter, java.io.Writer
    public void write(String str, int i3, int i16) throws IOException {
        for (int i17 = 0; i17 < i16; i17++) {
            write(str.charAt(i17 + i3));
        }
    }
}
