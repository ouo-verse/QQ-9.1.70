package com.tencent.mobileqq.commonutils.zip;

import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QZipInputStream extends ZipInputStream {
    public QZipInputStream(InputStream inputStream) {
        super(inputStream);
    }

    @Override // java.util.zip.ZipInputStream
    public ZipEntry getNextEntry() throws IOException {
        ZipEntry nextEntry = super.getNextEntry();
        if (!QZipIOException.isInvalidEntry(nextEntry)) {
            return nextEntry;
        }
        throw new QZipIOException();
    }
}
