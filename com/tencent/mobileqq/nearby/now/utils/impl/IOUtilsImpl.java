package com.tencent.mobileqq.nearby.now.utils.impl;

import com.tencent.mobileqq.nearby.now.utils.IIOUtils;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.security.MessageDigest;

/* compiled from: P */
/* loaded from: classes33.dex */
public class IOUtilsImpl implements IIOUtils {
    private static final int MAX_BUFFER_BYTES = 1024;

    @Override // com.tencent.mobileqq.nearby.now.utils.IIOUtils
    public ReadableByteChannel getChannel(InputStream inputStream) {
        if (inputStream != null) {
            return Channels.newChannel(inputStream);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x003f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.tencent.mobileqq.nearby.now.utils.IIOUtils
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] getFileMD5(File file) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        if (!file.isFile()) {
            return null;
        }
        byte[] bArr = new byte[1024];
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            fileInputStream = new FileInputStream(file);
            while (true) {
                try {
                    try {
                        int read = fileInputStream.read(bArr, 0, 1024);
                        if (read != -1) {
                            messageDigest.update(bArr, 0, read);
                        } else {
                            try {
                                break;
                            } catch (IOException unused) {
                            }
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        fileInputStream2 = fileInputStream;
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (IOException unused2) {
                            }
                        }
                        throw th;
                    }
                } catch (Exception e16) {
                    e = e16;
                    e.printStackTrace();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused3) {
                        }
                    }
                    return null;
                }
            }
            fileInputStream.close();
            return messageDigest.digest();
        } catch (Exception e17) {
            e = e17;
            fileInputStream = null;
        } catch (Throwable th6) {
            th = th6;
            if (fileInputStream2 != null) {
            }
            throw th;
        }
    }

    @Override // com.tencent.mobileqq.nearby.now.utils.IIOUtils
    public byte[] numberToBytes(long j3, int i3, boolean z16) {
        byte[] bArr = new byte[i3];
        if (z16) {
            i3 = -1;
        }
        int i16 = z16 ? -1 : 1;
        for (int i17 = z16 ? i3 - 1 : 0; i17 != i3; i17 += i16) {
            bArr[i17] = (byte) (255 & j3);
            j3 >>>= 8;
        }
        return bArr;
    }

    @Override // com.tencent.mobileqq.nearby.now.utils.IIOUtils
    public float readFloat(InputStream inputStream) throws IOException {
        return readFloat(inputStream, true);
    }

    @Override // com.tencent.mobileqq.nearby.now.utils.IIOUtils
    public long readInt(InputStream inputStream) throws IOException {
        return readNumber(inputStream, 4, true);
    }

    @Override // com.tencent.mobileqq.nearby.now.utils.IIOUtils
    public String readString(InputStream inputStream, int i3) throws IOException {
        int min = Math.min(i3, 1024);
        byte[] bArr = new byte[min];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
        while (i3 > 0) {
            try {
                int read = inputStream.read(bArr, 0, min);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
                i3 -= read;
            } finally {
                byteArrayOutputStream.close();
            }
        }
        return byteArrayOutputStream.toString();
    }

    @Override // com.tencent.mobileqq.nearby.now.utils.IIOUtils
    public void writeFloat(OutputStream outputStream, float f16) throws IOException {
        writeFloat(outputStream, f16, true);
    }

    @Override // com.tencent.mobileqq.nearby.now.utils.IIOUtils
    public void writeInt(OutputStream outputStream, long j3) throws IOException {
        outputStream.write(new byte[]{(byte) ((j3 >> 24) & 255), (byte) ((j3 >> 16) & 255), (byte) ((j3 >> 8) & 255), (byte) (j3 & 255)});
        outputStream.flush();
    }

    @Override // com.tencent.mobileqq.nearby.now.utils.IIOUtils
    public void writeShort(OutputStream outputStream, int i3) throws IOException {
        outputStream.write(new byte[]{(byte) ((i3 >> 8) & 255), (byte) (i3 & 255)});
        outputStream.flush();
    }

    @Override // com.tencent.mobileqq.nearby.now.utils.IIOUtils
    public WritableByteChannel getChannel(OutputStream outputStream) {
        if (outputStream != null) {
            return Channels.newChannel(outputStream);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.nearby.now.utils.IIOUtils
    public float readFloat(InputStream inputStream, boolean z16) throws IOException {
        return Float.intBitsToFloat((int) readInt(inputStream, z16));
    }

    @Override // com.tencent.mobileqq.nearby.now.utils.IIOUtils
    public long readInt(InputStream inputStream, boolean z16) throws IOException {
        return readNumber(inputStream, 4, z16);
    }

    @Override // com.tencent.mobileqq.nearby.now.utils.IIOUtils
    public void writeFloat(OutputStream outputStream, float f16, boolean z16) throws IOException {
        writeInt(outputStream, Float.floatToIntBits(f16), z16);
    }

    @Override // com.tencent.mobileqq.nearby.now.utils.IIOUtils
    public void writeInt(OutputStream outputStream, long j3, boolean z16) throws IOException {
        writeNumber(outputStream, j3, 4, z16);
    }

    @Override // com.tencent.mobileqq.nearby.now.utils.IIOUtils
    public void writeShort(OutputStream outputStream, int i3, boolean z16) throws IOException {
        writeNumber(outputStream, i3, 2, z16);
    }

    @Override // com.tencent.mobileqq.nearby.now.utils.IIOUtils
    public int indexOf(byte[] bArr, int i3, byte[] bArr2) {
        if (bArr != null && bArr2 != null) {
            int length = bArr.length;
            int length2 = bArr2.length;
            if (i3 >= length || length - i3 < length2) {
                return -1;
            }
            while (i3 <= length - length2) {
                int i16 = 0;
                while (i16 < length2 && bArr[i3 + i16] == bArr2[i16]) {
                    i16++;
                }
                if (i16 == length2) {
                    return i3;
                }
                i3++;
            }
            return -1;
        }
        throw new NullPointerException("source or target array is null!");
    }

    @Override // com.tencent.mobileqq.nearby.now.utils.IIOUtils
    public byte[] readBytes(InputStream inputStream, int i3) throws IOException {
        if (i3 <= 0) {
            return null;
        }
        byte[] bArr = new byte[i3];
        int i16 = 0;
        while (i16 < i3) {
            int read = inputStream.read(bArr, i16, i3 - i16);
            if (read <= 0) {
                break;
            }
            i16 += read;
        }
        return bArr;
    }

    @Override // com.tencent.mobileqq.nearby.now.utils.IIOUtils
    public long readNumber(InputStream inputStream, int i3, boolean z16) throws IOException {
        if (i3 > 0 && i3 <= 8) {
            byte[] bArr = new byte[i3];
            if (inputStream.markSupported()) {
                inputStream.mark(i3);
            }
            int read = inputStream.read(bArr, 0, i3);
            if (read <= 0) {
                return -1L;
            }
            if (!z16) {
                read = -1;
            }
            int i16 = z16 ? 1 : -1;
            long j3 = 0;
            for (int i17 = z16 ? 0 : read - 1; i17 != read; i17 += i16) {
                j3 = (j3 << 8) | (bArr[i17] & 255);
            }
            return j3;
        }
        throw new IllegalArgumentException("length must between 1 and 8.");
    }

    @Override // com.tencent.mobileqq.nearby.now.utils.IIOUtils
    public void skip(InputStream inputStream, int i3) throws IOException {
        if (inputStream == null || i3 <= 0) {
            return;
        }
        byte[] bArr = new byte[512];
        do {
            int read = inputStream.read(bArr, 0, Math.min(512, i3));
            if (read < 0) {
                return;
            } else {
                i3 -= read;
            }
        } while (i3 > 0);
    }

    @Override // com.tencent.mobileqq.nearby.now.utils.IIOUtils
    public void writeNumber(OutputStream outputStream, long j3, int i3, boolean z16) throws IOException {
        if (i3 > 0 && i3 <= 8) {
            outputStream.write(numberToBytes(j3, i3, z16));
            outputStream.flush();
            return;
        }
        throw new IllegalArgumentException("length must between 1 and 8.");
    }

    @Override // com.tencent.mobileqq.nearby.now.utils.IIOUtils
    public String readString(InputStream inputStream, int i3, String str) throws IOException {
        int min = Math.min(i3, 1024);
        byte[] bArr = new byte[min];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
        while (i3 > 0) {
            int read = inputStream.read(bArr, 0, min);
            if (read == -1) {
                break;
            }
            byteArrayOutputStream.write(bArr, 0, read);
            i3 -= read;
        }
        String byteArrayOutputStream2 = byteArrayOutputStream.toString(str);
        byteArrayOutputStream.close();
        return byteArrayOutputStream2;
    }
}
