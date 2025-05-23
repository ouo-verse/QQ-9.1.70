package com.tencent.mobileqq.emosm;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* compiled from: P */
/* loaded from: classes6.dex */
public class d extends RandomAccessFile {

    /* renamed from: d, reason: collision with root package name */
    private final byte[] f204271d;

    public d(String str, String str2) throws FileNotFoundException {
        super(new File(str), str2);
        this.f204271d = new byte[8];
    }

    @Override // java.io.RandomAccessFile
    public int read(byte[] bArr, int i3, int i16) throws IOException {
        long filePointer = super.getFilePointer();
        int read = super.read(bArr, i3, i16);
        if (read > -1) {
            e.d(bArr, i3, read, filePointer);
        }
        return read;
    }

    @Override // java.io.RandomAccessFile
    public int read() throws IOException {
        if (read(this.f204271d, 0, 1) != -1) {
            return this.f204271d[0] & 255;
        }
        return -1;
    }

    @Override // java.io.RandomAccessFile
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }
}
