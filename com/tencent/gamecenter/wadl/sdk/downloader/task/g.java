package com.tencent.gamecenter.wadl.sdk.downloader.task;

import java.io.File;
import java.io.RandomAccessFile;

/* compiled from: P */
/* loaded from: classes6.dex */
class g extends RandomAccessFile {
    public g(File file, String str) {
        super(file, str);
    }

    @Override // java.io.RandomAccessFile
    protected void finalize() {
        try {
            super.finalize();
        } catch (Throwable unused) {
        }
    }
}
