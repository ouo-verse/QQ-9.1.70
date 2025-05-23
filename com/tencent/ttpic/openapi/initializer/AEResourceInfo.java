package com.tencent.ttpic.openapi.initializer;

import android.support.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes27.dex */
public class AEResourceInfo {
    public String fileName;
    public int fileSizeBytes;
    public String sha1;

    public String getFileName() {
        return this.fileName;
    }

    public int getFileSizeInBytes() {
        return this.fileSizeBytes;
    }

    @NonNull
    public String toString() {
        return String.format("%s(%s)", this.fileName, this.sha1);
    }
}
