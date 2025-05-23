package com.tencent.gamecenter.wadl.util;

import com.tencent.commonsdk.soload.MyZipConstants;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.zip.ZipException;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    private static final m f107678a = new m(MyZipConstants.ENDSIG);

    private static byte[] a(RandomAccessFile randomAccessFile) throws IOException {
        boolean z16;
        long length = randomAccessFile.length() - 22;
        randomAccessFile.seek(length);
        byte[] a16 = f107678a.a();
        int read = randomAccessFile.read();
        while (true) {
            z16 = false;
            if (read == -1) {
                break;
            }
            if (read == a16[0]) {
                z16 = true;
                if (randomAccessFile.read() == a16[1] && randomAccessFile.read() == a16[2] && randomAccessFile.read() == a16[3]) {
                    break;
                }
            }
            length--;
            randomAccessFile.seek(length);
            read = randomAccessFile.read();
        }
        if (z16) {
            randomAccessFile.seek(length + 16 + 4);
            byte[] bArr = new byte[2];
            randomAccessFile.readFully(bArr);
            int b16 = new n(bArr).b();
            if (b16 == 0) {
                return null;
            }
            byte[] bArr2 = new byte[b16];
            randomAccessFile.read(bArr2);
            return bArr2;
        }
        throw new ZipException("archive is not a ZIP archive");
    }

    public static byte[] b(String str) throws IOException {
        if (str == null || str.length() <= 0) {
            return null;
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, "r");
        if (randomAccessFile.length() == 0) {
            randomAccessFile.close();
            QLog.e("ZipEocdCommentTool", 2, "ERROR:[ZipEocdCommentTool]Your file length is zero!");
            return null;
        }
        byte[] a16 = a(randomAccessFile);
        randomAccessFile.close();
        return a16;
    }
}
