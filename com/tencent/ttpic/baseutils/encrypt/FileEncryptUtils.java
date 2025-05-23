package com.tencent.ttpic.baseutils.encrypt;

import android.annotation.SuppressLint;
import com.tencent.ttpic.baseutils.io.IOUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

/* compiled from: P */
@SuppressLint({"NewApi"})
/* loaded from: classes27.dex */
public class FileEncryptUtils {
    public static final byte[] ENCRYPE_HEAD = {69, 78, 67, 82};
    public static final int ENCRYPT_SIZE = 1024;

    public static byte[] decryptFile(InputStream inputStream) {
        try {
            byte[] bArr = new byte[4];
            inputStream.read(bArr);
            byte b16 = bArr[0];
            byte[] bArr2 = ENCRYPE_HEAD;
            if (b16 == bArr2[0] && bArr[1] == bArr2[1] && bArr[2] == bArr2[2] && bArr[3] == bArr2[3]) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(readInt(inputStream));
                int readInt = readInt(inputStream);
                byte[] bArr3 = new byte[readInt];
                int read = inputStream.read(bArr3, 0, readInt);
                while (read < readInt) {
                    int read2 = inputStream.read(bArr3, read, readInt - read);
                    if (-1 != read2) {
                        read += read2;
                    } else {
                        throw new RuntimeException("decryptFile: inputStream end before all data read");
                    }
                }
                LogUtils.d("decryptFile m - ", Integer.toString(read));
                byte[] decode = EncryptUtils.decode(bArr3);
                byteArrayOutputStream.write(decode, 0, decode.length);
                IOUtils.copy(inputStream, byteArrayOutputStream);
                return byteArrayOutputStream.toByteArray();
            }
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            byteArrayOutputStream2.write(bArr);
            IOUtils.copy(inputStream, byteArrayOutputStream2);
            return byteArrayOutputStream2.toByteArray();
        } catch (AssertionError e16) {
            LogUtils.e("FileEncryptUtils", e16.toString());
            return null;
        } catch (Exception e17) {
            e17.printStackTrace();
            return null;
        } catch (OutOfMemoryError e18) {
            LogUtils.e("FileEncryptUtils", "decryptFile OOM");
            e18.printStackTrace();
            return null;
        }
    }

    public static void encryptByte2File(byte[] bArr, String str) {
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(new File(str)));
            dataOutputStream.write(ENCRYPE_HEAD);
            if (bArr.length > 1024) {
                writeInt(dataOutputStream, bArr.length);
                byte[] encode = EncryptUtils.encode(Arrays.copyOfRange(bArr, 0, 1024));
                writeInt(dataOutputStream, encode.length);
                dataOutputStream.write(encode);
                dataOutputStream.write(bArr, 1024, bArr.length - 1024);
            } else {
                writeInt(dataOutputStream, bArr.length);
                byte[] encode2 = EncryptUtils.encode(bArr);
                writeInt(dataOutputStream, encode2.length);
                dataOutputStream.write(encode2);
            }
            dataOutputStream.close();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public static void encryptFile(String str, String str2) {
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(str));
            byte[] byteArray = IOUtils.toByteArray(fileInputStream);
            fileInputStream.close();
            encryptByte2File(byteArray, str2);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    static int readInt(InputStream inputStream) throws IOException {
        int read = inputStream.read();
        int read2 = inputStream.read();
        int read3 = inputStream.read();
        int read4 = inputStream.read();
        if ((read | read2 | read3 | read4) >= 0) {
            return (read << 24) + (read2 << 16) + (read3 << 8) + (read4 << 0);
        }
        throw new EOFException();
    }

    static void writeInt(OutputStream outputStream, int i3) throws IOException {
        outputStream.write(new byte[]{(byte) ((i3 >> 24) & 255), (byte) ((i3 >> 16) & 255), (byte) ((i3 >> 8) & 255), (byte) (i3 & 255)});
    }
}
