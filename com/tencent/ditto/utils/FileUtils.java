package com.tencent.ditto.utils;

import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes5.dex */
public class FileUtils {
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static boolean deleteFile(File file) {
        if (file != null) {
            if (file.isFile()) {
                if (!file.delete()) {
                    file.deleteOnExit();
                    return false;
                }
                return true;
            }
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    for (File file2 : listFiles) {
                        deleteFile(file2);
                    }
                }
                return file.delete();
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0057 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getMd5ByFile(File file) {
        FileInputStream fileInputStream;
        MessageDigest messageDigest;
        FileInputStream fileInputStream2 = null;
        if (file == null || !file.exists() || file.isDirectory()) {
            return null;
        }
        try {
            messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            messageDigest.reset();
            fileInputStream = new FileInputStream(file);
        } catch (Exception e16) {
            e = e16;
            fileInputStream = null;
        } catch (Throwable th5) {
            th = th5;
            if (fileInputStream2 != null) {
            }
            throw th;
        }
        try {
            try {
                messageDigest.update(fileInputStream.getChannel().map(FileChannel.MapMode.READ_ONLY, 0L, file.length()));
                String hexString = toHexString(messageDigest.digest());
                try {
                    fileInputStream.close();
                } catch (IOException unused) {
                }
                return hexString;
            } catch (Throwable th6) {
                th = th6;
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        } catch (Exception e17) {
            e = e17;
            DittoLog.e(DittoLog.defaultTag, "", e);
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException unused3) {
                }
            }
            return null;
        }
    }

    public static String getMd5ByStream(InputStream inputStream) {
        try {
            byte[] bArr = new byte[4096];
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            int i3 = 0;
            while (i3 != -1) {
                i3 = inputStream.read(bArr);
                if (i3 > 0) {
                    messageDigest.update(bArr, 0, i3);
                }
            }
            return toHexString(messageDigest.digest());
        } catch (Exception e16) {
            DittoLog.e(DittoLog.defaultTag, "", e16);
            return null;
        }
    }

    public static String getMd5ByString(String str) {
        try {
            byte[] bytes = str.getBytes();
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            messageDigest.update(bytes, 0, bytes.length);
            return toHexString(messageDigest.digest());
        } catch (Exception unused) {
            return null;
        }
    }

    public static String toHexString(byte[] bArr) {
        StringBuilder sb5 = new StringBuilder(bArr.length * 2);
        for (int i3 = 0; i3 < bArr.length; i3++) {
            char[] cArr = HEX_DIGITS;
            sb5.append(cArr[(bArr[i3] & 240) >>> 4]);
            sb5.append(cArr[bArr[i3] & RegisterType.DOUBLE_HI]);
        }
        return sb5.toString();
    }
}
