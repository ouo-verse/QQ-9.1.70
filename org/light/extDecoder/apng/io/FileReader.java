package org.light.extDecoder.apng.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes29.dex */
public class FileReader extends FilterReader {
    private final File mFile;

    public FileReader(File file) throws IOException {
        super(new StreamReader(new FileInputStream(file)));
        this.mFile = file;
    }

    @Override // org.light.extDecoder.apng.io.FilterReader, org.light.extDecoder.apng.io.Reader
    public void reset() throws IOException {
        this.reader.close();
        this.reader = new StreamReader(new FileInputStream(this.mFile));
    }
}
