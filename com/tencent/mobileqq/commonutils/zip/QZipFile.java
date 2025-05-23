package com.tencent.mobileqq.commonutils.zip;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QZipFile extends ZipFile {
    public QZipFile(File file) throws ZipException, IOException {
        super(file);
    }

    @Override // java.util.zip.ZipFile
    public InputStream getInputStream(ZipEntry zipEntry) throws IOException {
        if (!QZipIOException.isInvalidEntry(zipEntry)) {
            return super.getInputStream(zipEntry);
        }
        throw new QZipIOException();
    }

    public QZipFile(File file, int i3) throws IOException {
        super(file, i3);
    }

    public QZipFile(String str) throws IOException {
        super(str);
    }
}
