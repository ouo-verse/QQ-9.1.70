package org.apache.commons.io.output;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import org.apache.commons.io.FileUtils;

/* compiled from: P */
/* loaded from: classes29.dex */
public class FileWriterWithEncoding extends Writer {
    private final Writer out;

    public FileWriterWithEncoding(String str, String str2) throws IOException {
        this(new File(str), str2, false);
    }

    private static Writer initWriter(File file, Object obj, boolean z16) throws IOException {
        if (file != null) {
            if (obj != null) {
                boolean exists = file.exists();
                FileOutputStream fileOutputStream = null;
                try {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file, z16);
                    try {
                        if (obj instanceof Charset) {
                            return new OutputStreamWriter(fileOutputStream2, (Charset) obj);
                        }
                        if (obj instanceof CharsetEncoder) {
                            return new OutputStreamWriter(fileOutputStream2, (CharsetEncoder) obj);
                        }
                        return new OutputStreamWriter(fileOutputStream2, (String) obj);
                    } catch (IOException | RuntimeException e16) {
                        e = e16;
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e17) {
                                e.addSuppressed(e17);
                            }
                        }
                        if (!exists) {
                            FileUtils.deleteQuietly(file);
                            throw e;
                        }
                        throw e;
                    }
                } catch (IOException e18) {
                    e = e18;
                } catch (RuntimeException e19) {
                    e = e19;
                }
            } else {
                throw new NullPointerException("Encoding is missing");
            }
        } else {
            throw new NullPointerException("File is missing");
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.out.close();
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() throws IOException {
        this.out.flush();
    }

    @Override // java.io.Writer
    public void write(int i3) throws IOException {
        this.out.write(i3);
    }

    public FileWriterWithEncoding(String str, String str2, boolean z16) throws IOException {
        this(new File(str), str2, z16);
    }

    @Override // java.io.Writer
    public void write(char[] cArr) throws IOException {
        this.out.write(cArr);
    }

    public FileWriterWithEncoding(String str, Charset charset) throws IOException {
        this(new File(str), charset, false);
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i3, int i16) throws IOException {
        this.out.write(cArr, i3, i16);
    }

    public FileWriterWithEncoding(String str, Charset charset, boolean z16) throws IOException {
        this(new File(str), charset, z16);
    }

    @Override // java.io.Writer
    public void write(String str) throws IOException {
        this.out.write(str);
    }

    public FileWriterWithEncoding(String str, CharsetEncoder charsetEncoder) throws IOException {
        this(new File(str), charsetEncoder, false);
    }

    @Override // java.io.Writer
    public void write(String str, int i3, int i16) throws IOException {
        this.out.write(str, i3, i16);
    }

    public FileWriterWithEncoding(String str, CharsetEncoder charsetEncoder, boolean z16) throws IOException {
        this(new File(str), charsetEncoder, z16);
    }

    public FileWriterWithEncoding(File file, String str) throws IOException {
        this(file, str, false);
    }

    public FileWriterWithEncoding(File file, String str, boolean z16) throws IOException {
        this.out = initWriter(file, str, z16);
    }

    public FileWriterWithEncoding(File file, Charset charset) throws IOException {
        this(file, charset, false);
    }

    public FileWriterWithEncoding(File file, Charset charset, boolean z16) throws IOException {
        this.out = initWriter(file, charset, z16);
    }

    public FileWriterWithEncoding(File file, CharsetEncoder charsetEncoder) throws IOException {
        this(file, charsetEncoder, false);
    }

    public FileWriterWithEncoding(File file, CharsetEncoder charsetEncoder, boolean z16) throws IOException {
        this.out = initWriter(file, charsetEncoder, z16);
    }
}
