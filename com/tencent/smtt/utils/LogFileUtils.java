package com.tencent.smtt.utils;

import android.util.Log;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: P */
/* loaded from: classes25.dex */
public class LogFileUtils {

    /* renamed from: a, reason: collision with root package name */
    private static OutputStream f369643a;

    public static void closeOutputStream(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e16) {
                Log.e("LOG_FILE", "Couldn't close stream!", e16);
            }
        }
    }

    public static byte[] createHeaderText(String str, String str2) {
        try {
            byte[] encryptKey = encryptKey(str, str2);
            String format = String.format("%03d", Integer.valueOf(encryptKey.length));
            byte[] bArr = new byte[encryptKey.length + 3];
            bArr[0] = (byte) format.charAt(0);
            bArr[1] = (byte) format.charAt(1);
            bArr[2] = (byte) format.charAt(2);
            System.arraycopy(encryptKey, 0, bArr, 3, encryptKey.length);
            return bArr;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String createKey() {
        return String.valueOf(System.currentTimeMillis());
    }

    public static byte[] encrypt(String str, String str2) {
        try {
            byte[] bytes = str2.getBytes("UTF-8");
            Cipher cipher = Cipher.getInstance("RC4");
            cipher.init(1, new SecretKeySpec(str.getBytes("UTF-8"), "RC4"));
            return cipher.update(bytes);
        } catch (Throwable th5) {
            Log.e("LOG_FILE", "encrypt exception:" + th5.getMessage());
            return null;
        }
    }

    public static byte[] encryptKey(String str, String str2) {
        try {
            byte[] bytes = str2.getBytes("UTF-8");
            Cipher cipher = Cipher.getInstance("RC4");
            cipher.init(1, new SecretKeySpec(str.getBytes("UTF-8"), "RC4"));
            return cipher.update(bytes);
        } catch (Throwable th5) {
            Log.e("LOG_FILE", "encrypt exception:" + th5.getMessage());
            return null;
        }
    }

    /* JADX WARN: Finally extract failed */
    public static synchronized void writeDataToStorage(File file, String str, byte[] bArr, String str2, boolean z16) {
        String str3;
        String str4;
        synchronized (LogFileUtils.class) {
            byte[] encrypt = encrypt(str, str2);
            if (encrypt != null) {
                str2 = null;
            } else {
                encrypt = null;
            }
            try {
                file.getParentFile().mkdirs();
                if (file.isFile() && file.exists() && file.length() > 2097152) {
                    file.delete();
                    file.createNewFile();
                }
                if (f369643a == null) {
                    f369643a = new BufferedOutputStream(new FileOutputStream(file, z16));
                }
                if (str2 != null) {
                    f369643a.write(str2.getBytes());
                } else {
                    f369643a.write(bArr);
                    f369643a.write(encrypt);
                    f369643a.write(new byte[]{10, 10});
                }
                OutputStream outputStream = f369643a;
                if (outputStream != null) {
                    try {
                        outputStream.flush();
                    } catch (Throwable th5) {
                        str3 = "LOG_FILE";
                        str4 = "writeDataToStorage outputStream.flush() exception:" + th5;
                        Log.i(str3, str4);
                    }
                }
            } catch (Throwable th6) {
                try {
                    Log.i("LOG_FILE", "writeDataToStorage exception, swap_str:" + str2 + ",keyHeadText:" + bArr + ",swap_bytes:" + encrypt + ",append=" + z16 + ",detail:" + th6);
                    OutputStream outputStream2 = f369643a;
                    if (outputStream2 != null) {
                        try {
                            outputStream2.flush();
                        } catch (Throwable th7) {
                            str3 = "LOG_FILE";
                            str4 = "writeDataToStorage outputStream.flush() exception:" + th7;
                            Log.i(str3, str4);
                        }
                    }
                } catch (Throwable th8) {
                    OutputStream outputStream3 = f369643a;
                    if (outputStream3 != null) {
                        try {
                            outputStream3.flush();
                        } catch (Throwable th9) {
                            Log.i("LOG_FILE", "writeDataToStorage outputStream.flush() exception:" + th9);
                        }
                    }
                    throw th8;
                }
            }
        }
    }
}
