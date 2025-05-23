package com.tencent.mobileqq.kandian.base.image;

import java.io.File;

/* compiled from: P */
/* loaded from: classes15.dex */
public class RIJImageOptBitmapFile extends File {
    private byte[] bitmapBytes;
    private long length;

    public RIJImageOptBitmapFile() {
        super("");
    }

    @Override // java.io.File
    public boolean delete() {
        if (this.bitmapBytes != null) {
            this.bitmapBytes = null;
            return true;
        }
        return true;
    }

    public byte[] getBytes() {
        return this.bitmapBytes;
    }

    public long getLength() {
        return this.length;
    }

    public RIJImageOptBitmapFile(byte[] bArr, long j3) {
        super("");
        this.bitmapBytes = bArr;
        this.length = j3;
    }
}
