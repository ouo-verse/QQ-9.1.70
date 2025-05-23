package com.tencent.oskplayer.support.util;

import android.text.TextUtils;
import com.tencent.oskplayer.support.OskSupport;
import com.tencent.oskplayer.support.log.Logger;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;

/* compiled from: P */
/* loaded from: classes22.dex */
public class OskFile {
    private static final long FILE_COPY_BUFFER_SIZE = 31457280;
    public static final long ONE_EB = 1152921504606846976L;
    public static final BigInteger ONE_EB_BI;
    public static final long ONE_GB = 1073741824;
    public static final BigInteger ONE_GB_BI;
    public static final long ONE_KB = 1024;
    public static final BigInteger ONE_KB_BI;
    public static final long ONE_MB = 1048576;
    public static final BigInteger ONE_MB_BI;
    public static final long ONE_PB = 1125899906842624L;
    public static final BigInteger ONE_PB_BI;
    public static final long ONE_TB = 1099511627776L;
    public static final BigInteger ONE_TB_BI;
    public static final BigInteger ONE_YB;
    public static final BigInteger ONE_ZB;
    public static final String TAG = "OskFile";

    static {
        BigInteger valueOf = BigInteger.valueOf(1024L);
        ONE_KB_BI = valueOf;
        BigInteger multiply = valueOf.multiply(valueOf);
        ONE_MB_BI = multiply;
        BigInteger multiply2 = valueOf.multiply(multiply);
        ONE_GB_BI = multiply2;
        BigInteger multiply3 = valueOf.multiply(multiply2);
        ONE_TB_BI = multiply3;
        BigInteger multiply4 = valueOf.multiply(multiply3);
        ONE_PB_BI = multiply4;
        ONE_EB_BI = valueOf.multiply(multiply4);
        BigInteger multiply5 = BigInteger.valueOf(1024L).multiply(BigInteger.valueOf(1152921504606846976L));
        ONE_ZB = multiply5;
        ONE_YB = valueOf.multiply(multiply5);
    }

    public static String byteCountToDisplaySize(BigInteger bigInteger) {
        BigInteger bigInteger2 = ONE_EB_BI;
        BigInteger divide = bigInteger.divide(bigInteger2);
        BigInteger bigInteger3 = BigInteger.ZERO;
        if (divide.compareTo(bigInteger3) > 0) {
            return String.valueOf(bigInteger.divide(bigInteger2)) + " EB";
        }
        BigInteger bigInteger4 = ONE_PB_BI;
        if (bigInteger.divide(bigInteger4).compareTo(bigInteger3) > 0) {
            return String.valueOf(bigInteger.divide(bigInteger4)) + " PB";
        }
        BigInteger bigInteger5 = ONE_TB_BI;
        if (bigInteger.divide(bigInteger5).compareTo(bigInteger3) > 0) {
            return String.valueOf(bigInteger.divide(bigInteger5)) + " TB";
        }
        BigInteger bigInteger6 = ONE_GB_BI;
        if (bigInteger.divide(bigInteger6).compareTo(bigInteger3) > 0) {
            return String.valueOf(bigInteger.divide(bigInteger6)) + " GB";
        }
        BigInteger bigInteger7 = ONE_MB_BI;
        if (bigInteger.divide(bigInteger7).compareTo(bigInteger3) > 0) {
            return String.valueOf(bigInteger.divide(bigInteger7)) + " MB";
        }
        BigInteger bigInteger8 = ONE_KB_BI;
        if (bigInteger.divide(bigInteger8).compareTo(bigInteger3) > 0) {
            return String.valueOf(bigInteger.divide(bigInteger8)) + " KB";
        }
        return String.valueOf(bigInteger) + " bytes";
    }

    public static void copy(File file, File file2) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            try {
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read > 0) {
                        fileOutputStream.write(bArr, 0, read);
                    } else {
                        return;
                    }
                }
            } finally {
                fileOutputStream.close();
            }
        } finally {
            fileInputStream.close();
        }
    }

    private static String ensureDir(File file) {
        boolean z16;
        if (file.exists() && file.isFile()) {
            z16 = file.delete();
        } else {
            z16 = false;
        }
        if (!file.exists()) {
            z16 = file.mkdirs();
        }
        if (file.isDirectory() && file.exists()) {
            z16 = true;
        }
        Logger.g().i(TAG, "ensureDir " + file + " result:" + z16);
        if (z16) {
            return file.getAbsolutePath();
        }
        return null;
    }

    public static boolean ensureDirEmpty(String str) {
        boolean z16 = false;
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (file.exists()) {
                z16 = file.delete();
            }
            if (!file.exists()) {
                z16 = file.mkdirs();
            }
            if (file.isDirectory() && file.exists()) {
                z16 = true;
            }
            Logger.g().i(TAG, "ensureDirEmpty " + file + " result:" + z16);
        } else {
            Logger.g().i(TAG, "ensureDirEmpty invalidPath");
        }
        return z16;
    }

    public static String ensureFilesDir(String str) {
        File file;
        String str2 = "";
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        File file2 = null;
        try {
            file = OskSupport.getContext().getExternalFilesDir(null);
        } catch (Exception e16) {
            Logger.g().e(TAG, "cant get extFilesRootDir", e16);
            file = null;
        }
        if (file != null) {
            str2 = ensureDir(new File(file + File.separator + str));
        }
        if (TextUtils.isEmpty(str2)) {
            try {
                file2 = OskSupport.getContext().getFilesDir();
            } catch (Exception e17) {
                Logger.g().e(TAG, "cant get internalFilesRootDir", e17);
            }
            if (file2 != null) {
                return ensureDir(new File(file2 + File.separator + str));
            }
            return str2;
        }
        return str2;
    }

    public static String getFileExtension(String str) {
        String name;
        int lastIndexOf;
        if (TextUtils.isEmpty(str) || (lastIndexOf = (name = new File(str).getName()).lastIndexOf(46)) == -1) {
            return "";
        }
        return name.substring(lastIndexOf + 1);
    }

    public static boolean isLocalFile(String str) {
        if (!TextUtils.isEmpty(str) && (str.startsWith("/") || str.startsWith("file://"))) {
            return true;
        }
        return false;
    }

    public static String byteCountToDisplaySize(long j3) {
        return byteCountToDisplaySize(BigInteger.valueOf(j3));
    }
}
