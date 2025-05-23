package com.tencent.tinker.bsdiff;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.zip.GZIPInputStream;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a {
    static IPatchRedirector $redirector_;

    public static int a(InputStream inputStream, InputStream inputStream2, File file) throws IOException {
        if (inputStream == null) {
            return 3;
        }
        if (file == null) {
            return 4;
        }
        if (inputStream2 == null) {
            return 2;
        }
        byte[] a16 = b.a(inputStream);
        byte[] a17 = b.a(inputStream2);
        byte[] b16 = b(a16, a16.length, a17, a17.length, 0);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            fileOutputStream.write(b16);
            fileOutputStream.close();
            return 1;
        } catch (Throwable th5) {
            fileOutputStream.close();
            throw th5;
        }
    }

    public static byte[] b(byte[] bArr, int i3, byte[] bArr2, int i16, int i17) throws IOException {
        int i18;
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr2, 0, i16));
        dataInputStream.skip(8L);
        long readLong = dataInputStream.readLong();
        long readLong2 = dataInputStream.readLong();
        int readLong3 = (int) dataInputStream.readLong();
        dataInputStream.close();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr2, 0, i16);
        byteArrayInputStream.skip(32L);
        DataInputStream dataInputStream2 = new DataInputStream(new GZIPInputStream(byteArrayInputStream));
        ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(bArr2, 0, i16);
        byteArrayInputStream2.skip(readLong + 32);
        GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream2);
        ByteArrayInputStream byteArrayInputStream3 = new ByteArrayInputStream(bArr2, 0, i16);
        byteArrayInputStream3.skip(readLong2 + readLong + 32);
        GZIPInputStream gZIPInputStream2 = new GZIPInputStream(byteArrayInputStream3);
        byte[] bArr3 = new byte[readLong3];
        int[] iArr = new int[3];
        int i19 = 0;
        int i26 = 0;
        while (i19 < readLong3) {
            for (int i27 = 0; i27 <= 2; i27++) {
                iArr[i27] = dataInputStream2.readInt();
            }
            int i28 = iArr[0];
            if (i19 + i28 <= readLong3) {
                if (b.b(gZIPInputStream, bArr3, i19, i28)) {
                    int i29 = 0;
                    while (true) {
                        i18 = iArr[0];
                        if (i29 >= i18) {
                            break;
                        }
                        int i36 = i26 + i29;
                        if (i36 >= 0 && i36 < i3) {
                            int i37 = i19 + i29;
                            bArr3[i37] = (byte) (bArr3[i37] + bArr[i36]);
                        }
                        i29++;
                    }
                    int i38 = i19 + i18;
                    int i39 = i26 + i18;
                    int i46 = iArr[1];
                    if (i38 + i46 <= readLong3) {
                        if (b.b(gZIPInputStream2, bArr3, i38, i46)) {
                            i19 = i38 + iArr[1];
                            i26 = i39 + iArr[2];
                        } else {
                            throw new IOException("Corrupt by wrong patch file.");
                        }
                    } else {
                        throw new IOException("Corrupt by wrong patch file.");
                    }
                } else {
                    throw new IOException("Corrupt by wrong patch file.");
                }
            } else {
                throw new IOException("Corrupt by wrong patch file.");
            }
        }
        dataInputStream2.close();
        gZIPInputStream.close();
        gZIPInputStream2.close();
        return bArr3;
    }

    public static int c(RandomAccessFile randomAccessFile, int i3, byte[] bArr, int i16, File file, int i17) throws IOException {
        if (randomAccessFile != null && i3 > 0) {
            if (file == null) {
                return 4;
            }
            if (bArr != null && i16 > 0) {
                DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr, 0, i16));
                dataInputStream.skip(8L);
                long readLong = dataInputStream.readLong();
                long readLong2 = dataInputStream.readLong();
                int readLong3 = (int) dataInputStream.readLong();
                dataInputStream.close();
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr, 0, i16);
                byteArrayInputStream.skip(32L);
                DataInputStream dataInputStream2 = new DataInputStream(new GZIPInputStream(byteArrayInputStream));
                ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(bArr, 0, i16);
                byteArrayInputStream2.skip(readLong + 32);
                GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream2);
                ByteArrayInputStream byteArrayInputStream3 = new ByteArrayInputStream(bArr, 0, i16);
                byteArrayInputStream3.skip(readLong2 + readLong + 32);
                GZIPInputStream gZIPInputStream2 = new GZIPInputStream(byteArrayInputStream3);
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                try {
                    int[] iArr = new int[3];
                    int i18 = 0;
                    int i19 = 0;
                    while (i18 < readLong3) {
                        for (int i26 = 0; i26 <= 2; i26++) {
                            iArr[i26] = dataInputStream2.readInt();
                        }
                        int i27 = iArr[0];
                        if (i18 + i27 > readLong3) {
                            fileOutputStream.close();
                        } else {
                            byte[] bArr2 = new byte[i27];
                            if (!b.b(gZIPInputStream, bArr2, 0, i27)) {
                                fileOutputStream.close();
                            } else {
                                int i28 = iArr[0];
                                byte[] bArr3 = new byte[i28];
                                try {
                                    if (randomAccessFile.read(bArr3, 0, i28) < iArr[0]) {
                                        fileOutputStream.close();
                                    } else {
                                        for (int i29 = 0; i29 < iArr[0]; i29++) {
                                            int i36 = i19 + i29;
                                            if (i36 >= 0 && i36 < i3) {
                                                bArr2[i29] = (byte) (bArr2[i29] + bArr3[i29]);
                                            }
                                        }
                                        fileOutputStream.write(bArr2);
                                        int i37 = iArr[0];
                                        int i38 = i18 + i37;
                                        int i39 = i19 + i37;
                                        int i46 = iArr[1];
                                        if (i38 + i46 > readLong3) {
                                            fileOutputStream.close();
                                        } else {
                                            byte[] bArr4 = new byte[i46];
                                            if (!b.b(gZIPInputStream2, bArr4, 0, i46)) {
                                                fileOutputStream.close();
                                                randomAccessFile.close();
                                                fileOutputStream.close();
                                                return 2;
                                            }
                                            fileOutputStream.write(bArr4);
                                            fileOutputStream.flush();
                                            i18 = i38 + iArr[1];
                                            i19 = i39 + iArr[2];
                                            randomAccessFile.seek(i19);
                                        }
                                    }
                                    randomAccessFile.close();
                                    fileOutputStream.close();
                                    return 2;
                                } catch (Throwable th5) {
                                    th = th5;
                                    randomAccessFile.close();
                                    fileOutputStream.close();
                                    throw th;
                                }
                            }
                        }
                        randomAccessFile.close();
                        fileOutputStream.close();
                        return 2;
                    }
                    dataInputStream2.close();
                    gZIPInputStream.close();
                    gZIPInputStream2.close();
                    randomAccessFile.close();
                    fileOutputStream.close();
                    return 1;
                } catch (Throwable th6) {
                    th = th6;
                }
            } else {
                return 2;
            }
        } else {
            return 3;
        }
    }

    public static int d(RandomAccessFile randomAccessFile, File file, File file2, int i3) throws IOException {
        if (randomAccessFile != null && randomAccessFile.length() > 0) {
            if (file == null) {
                return 4;
            }
            if (file2 != null && file2.length() > 0) {
                int length = (int) file2.length();
                byte[] bArr = new byte[length];
                FileInputStream fileInputStream = new FileInputStream(file2);
                try {
                    b.b(fileInputStream, bArr, 0, length);
                    fileInputStream.close();
                    return c(randomAccessFile, (int) randomAccessFile.length(), bArr, length, file, i3);
                } catch (Throwable th5) {
                    fileInputStream.close();
                    throw th5;
                }
            }
            return 2;
        }
        return 3;
    }
}
