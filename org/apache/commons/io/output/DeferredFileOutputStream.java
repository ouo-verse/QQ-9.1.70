package org.apache.commons.io.output;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

/* compiled from: P */
/* loaded from: classes29.dex */
public class DeferredFileOutputStream extends ThresholdingOutputStream {
    private boolean closed;
    private OutputStream currentOutputStream;
    private final File directory;
    private ByteArrayOutputStream memoryOutputStream;
    private File outputFile;
    private final String prefix;
    private final String suffix;

    public DeferredFileOutputStream(int i3, File file) {
        this(i3, file, null, null, null, 1024);
    }

    @Override // org.apache.commons.io.output.ThresholdingOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        super.close();
        this.closed = true;
    }

    public byte[] getData() {
        ByteArrayOutputStream byteArrayOutputStream = this.memoryOutputStream;
        if (byteArrayOutputStream != null) {
            return byteArrayOutputStream.toByteArray();
        }
        return null;
    }

    public File getFile() {
        return this.outputFile;
    }

    @Override // org.apache.commons.io.output.ThresholdingOutputStream
    protected OutputStream getStream() throws IOException {
        return this.currentOutputStream;
    }

    public boolean isInMemory() {
        return !isThresholdExceeded();
    }

    @Override // org.apache.commons.io.output.ThresholdingOutputStream
    protected void thresholdReached() throws IOException {
        String str = this.prefix;
        if (str != null) {
            this.outputFile = File.createTempFile(str, this.suffix, this.directory);
        }
        FileUtils.forceMkdirParent(this.outputFile);
        FileOutputStream fileOutputStream = new FileOutputStream(this.outputFile);
        try {
            this.memoryOutputStream.writeTo(fileOutputStream);
            this.currentOutputStream = fileOutputStream;
            this.memoryOutputStream = null;
        } catch (IOException e16) {
            fileOutputStream.close();
            throw e16;
        }
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        if (this.closed) {
            if (isInMemory()) {
                this.memoryOutputStream.writeTo(outputStream);
                return;
            }
            FileInputStream fileInputStream = new FileInputStream(this.outputFile);
            try {
                IOUtils.copy(fileInputStream, outputStream);
                fileInputStream.close();
                return;
            } catch (Throwable th5) {
                try {
                    throw th5;
                } catch (Throwable th6) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable th7) {
                        th5.addSuppressed(th7);
                    }
                    throw th6;
                }
            }
        }
        throw new IOException("Stream not closed");
    }

    public DeferredFileOutputStream(int i3, int i16, File file) {
        this(i3, file, null, null, null, i16);
        if (i16 < 0) {
            throw new IllegalArgumentException("Initial buffer size must be atleast 0.");
        }
    }

    public DeferredFileOutputStream(int i3, String str, String str2, File file) {
        this(i3, null, str, str2, file, 1024);
        if (str == null) {
            throw new IllegalArgumentException("Temporary file prefix is missing");
        }
    }

    public DeferredFileOutputStream(int i3, int i16, String str, String str2, File file) {
        this(i3, null, str, str2, file, i16);
        if (str == null) {
            throw new IllegalArgumentException("Temporary file prefix is missing");
        }
        if (i16 < 0) {
            throw new IllegalArgumentException("Initial buffer size must be atleast 0.");
        }
    }

    DeferredFileOutputStream(int i3, File file, String str, String str2, File file2, int i16) {
        super(i3);
        this.closed = false;
        this.outputFile = file;
        this.prefix = str;
        this.suffix = str2;
        this.directory = file2;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i16);
        this.memoryOutputStream = byteArrayOutputStream;
        this.currentOutputStream = byteArrayOutputStream;
    }
}
