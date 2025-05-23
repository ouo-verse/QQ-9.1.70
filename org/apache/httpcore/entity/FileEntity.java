package org.apache.httpcore.entity;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.httpcore.util.Args;

/* compiled from: P */
/* loaded from: classes29.dex */
public class FileEntity extends AbstractHttpEntity implements Cloneable {
    protected final File file;

    @Deprecated
    public FileEntity(File file, String str) {
        this.file = (File) Args.notNull(file, "File");
        setContentType(str);
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override // org.apache.httpcore.HttpEntity
    public InputStream getContent() throws IOException {
        return new FileInputStream(this.file);
    }

    @Override // org.apache.httpcore.HttpEntity
    public long getContentLength() {
        return this.file.length();
    }

    @Override // org.apache.httpcore.HttpEntity
    public boolean isRepeatable() {
        return true;
    }

    @Override // org.apache.httpcore.HttpEntity
    public boolean isStreaming() {
        return false;
    }

    @Override // org.apache.httpcore.HttpEntity
    public void writeTo(OutputStream outputStream) throws IOException {
        Args.notNull(outputStream, "Output stream");
        FileInputStream fileInputStream = new FileInputStream(this.file);
        try {
            byte[] bArr = new byte[4096];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read != -1) {
                    outputStream.write(bArr, 0, read);
                } else {
                    outputStream.flush();
                    return;
                }
            }
        } finally {
            fileInputStream.close();
        }
    }

    public FileEntity(File file, ContentType contentType) {
        this.file = (File) Args.notNull(file, "File");
        if (contentType != null) {
            setContentType(contentType.toString());
        }
    }

    public FileEntity(File file) {
        this.file = (File) Args.notNull(file, "File");
    }
}
