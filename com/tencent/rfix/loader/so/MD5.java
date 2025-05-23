package com.tencent.rfix.loader.so;

import android.util.Log;
import com.tencent.rfix.loader.utils.RFixConstants;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;

/* compiled from: P */
/* loaded from: classes25.dex */
public final class MD5 {
    private static final String TAG = "MD5";

    public static String getMD5(InputStream inputStream, int i3) {
        int i16;
        if (inputStream != null && i3 > 0) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                StringBuilder sb5 = new StringBuilder(32);
                byte[] bArr = new byte[i3];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    messageDigest.update(bArr, 0, read);
                }
                for (byte b16 : messageDigest.digest()) {
                    sb5.append(Integer.toString((b16 & 255) + 256, 16).substring(1));
                }
                return sb5.toString();
            } catch (Exception e16) {
                Log.e("MD5", "get md5 error ", e16);
            }
        }
        return null;
    }

    public static String getMD5(String str) {
        if (str == null) {
            return null;
        }
        File file = new File(str);
        if (file.exists()) {
            return getMD5(file, RFixConstants.MD5_FILE_BUF_LENGTH);
        }
        return null;
    }

    public static String getMD5(File file) {
        return getMD5(file, RFixConstants.MD5_FILE_BUF_LENGTH);
    }

    public static String getMD5(File file, int i3) {
        FileInputStream fileInputStream;
        long j3;
        FileInputStream fileInputStream2 = null;
        if (file == null || i3 <= 0 || !file.exists()) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(file);
            j3 = i3;
        } catch (Exception e16) {
            e = e16;
            fileInputStream = null;
        } catch (Throwable th5) {
            th = th5;
            IOHelper.closeQuietly(fileInputStream2);
            throw th;
        }
        try {
            try {
                if (j3 > file.length()) {
                    j3 = file.length();
                }
                String md5 = getMD5(fileInputStream, (int) j3);
                fileInputStream.close();
                IOHelper.closeQuietly(fileInputStream);
                return md5;
            } catch (Throwable th6) {
                th = th6;
                fileInputStream2 = fileInputStream;
                IOHelper.closeQuietly(fileInputStream2);
                throw th;
            }
        } catch (Exception e17) {
            e = e17;
            Log.e("MD5", "get md5 error ", e);
            IOHelper.closeQuietly(fileInputStream);
            return null;
        }
    }
}
