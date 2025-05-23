package org.apache.commons.io.output;

import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;

/* loaded from: classes29.dex */
public class ProxyWriter extends FilterWriter {
    public ProxyWriter(Writer writer) {
        super(writer);
    }

    @Override // java.io.FilterWriter, java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            ((FilterWriter) this).out.close();
        } catch (IOException e16) {
            handleIOException(e16);
        }
    }

    @Override // java.io.FilterWriter, java.io.Writer, java.io.Flushable
    public void flush() throws IOException {
        try {
            ((FilterWriter) this).out.flush();
        } catch (IOException e16) {
            handleIOException(e16);
        }
    }

    @Override // java.io.FilterWriter, java.io.Writer
    public void write(int i3) throws IOException {
        try {
            beforeWrite(1);
            ((FilterWriter) this).out.write(i3);
            afterWrite(1);
        } catch (IOException e16) {
            handleIOException(e16);
        }
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(char c16) throws IOException {
        try {
            beforeWrite(1);
            ((FilterWriter) this).out.append(c16);
            afterWrite(1);
        } catch (IOException e16) {
            handleIOException(e16);
        }
        return this;
    }

    @Override // java.io.Writer
    public void write(char[] cArr) throws IOException {
        int length;
        if (cArr != null) {
            try {
                length = cArr.length;
            } catch (IOException e16) {
                handleIOException(e16);
                return;
            }
        } else {
            length = 0;
        }
        beforeWrite(length);
        ((FilterWriter) this).out.write(cArr);
        afterWrite(length);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(CharSequence charSequence, int i3, int i16) throws IOException {
        int i17 = i16 - i3;
        try {
            beforeWrite(i17);
            ((FilterWriter) this).out.append(charSequence, i3, i16);
            afterWrite(i17);
        } catch (IOException e16) {
            handleIOException(e16);
        }
        return this;
    }

    @Override // java.io.FilterWriter, java.io.Writer
    public void write(char[] cArr, int i3, int i16) throws IOException {
        try {
            beforeWrite(i16);
            ((FilterWriter) this).out.write(cArr, i3, i16);
            afterWrite(i16);
        } catch (IOException e16) {
            handleIOException(e16);
        }
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(CharSequence charSequence) throws IOException {
        int length;
        if (charSequence != null) {
            try {
                length = charSequence.length();
            } catch (IOException e16) {
                handleIOException(e16);
            }
        } else {
            length = 0;
        }
        beforeWrite(length);
        ((FilterWriter) this).out.append(charSequence);
        afterWrite(length);
        return this;
    }

    @Override // java.io.Writer
    public void write(String str) throws IOException {
        int length;
        if (str != null) {
            try {
                length = str.length();
            } catch (IOException e16) {
                handleIOException(e16);
                return;
            }
        } else {
            length = 0;
        }
        beforeWrite(length);
        ((FilterWriter) this).out.write(str);
        afterWrite(length);
    }

    @Override // java.io.FilterWriter, java.io.Writer
    public void write(String str, int i3, int i16) throws IOException {
        try {
            beforeWrite(i16);
            ((FilterWriter) this).out.write(str, i3, i16);
            afterWrite(i16);
        } catch (IOException e16) {
            handleIOException(e16);
        }
    }

    protected void afterWrite(int i3) throws IOException {
    }

    protected void beforeWrite(int i3) throws IOException {
    }

    protected void handleIOException(IOException iOException) throws IOException {
        throw iOException;
    }
}
