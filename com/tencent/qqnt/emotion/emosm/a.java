package com.tencent.qqnt.emotion.emosm;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* compiled from: P */
/* loaded from: classes24.dex */
public class a extends RandomAccessFile {

    /* renamed from: d, reason: collision with root package name */
    private final byte[] f356271d;

    public a(String str, String str2) throws FileNotFoundException {
        super(new File(str), str2);
        this.f356271d = new byte[8];
    }

    @Override // java.io.RandomAccessFile
    public int read(byte[] bArr, int i3, int i16) throws IOException {
        long filePointer = super.getFilePointer();
        int read = super.read(bArr, i3, i16);
        if (read > -1) {
            b.i(bArr, i3, read, filePointer);
        }
        return read;
    }

    @Override // java.io.RandomAccessFile
    public int read() throws IOException {
        if (read(this.f356271d, 0, 1) != -1) {
            return this.f356271d[0] & 255;
        }
        return -1;
    }

    @Override // java.io.RandomAccessFile
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }
}
