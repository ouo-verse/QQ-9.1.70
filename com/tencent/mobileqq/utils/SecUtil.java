package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.text.TextUtils;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.security.MessageDigest;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes20.dex */
public class SecUtil {
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET, 'B', 'C', 'D', 'E', 'F'};

    public static boolean check0DayRepack(Context context) {
        if (context == null) {
            return false;
        }
        try {
            JarFile jarFile = new JarFile(new File(context.getApplicationContext().getApplicationInfo().sourceDir));
            Enumeration<JarEntry> entries = jarFile.entries();
            HashSet hashSet = new HashSet();
            while (entries.hasMoreElements()) {
                String name = entries.nextElement().getName();
                if (hashSet.contains(name)) {
                    jarFile.close();
                    return true;
                }
                hashSet.add(name);
            }
            jarFile.close();
        } catch (Exception e16) {
            e16.printStackTrace();
        } catch (OutOfMemoryError e17) {
            e17.printStackTrace();
        }
        return false;
    }

    public static String getFileMd5(String str) {
        String str2 = "";
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(str);
                try {
                    str2 = getFileMd5(fileInputStream2);
                    fileInputStream2.close();
                } catch (Throwable th5) {
                    th = th5;
                    fileInputStream = fileInputStream2;
                    try {
                        th.printStackTrace();
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        return str2;
                    } catch (Throwable th6) {
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Throwable th7) {
                                th7.printStackTrace();
                            }
                        }
                        throw th6;
                    }
                }
            } catch (Throwable th8) {
                th = th8;
            }
        } catch (Throwable th9) {
            th9.printStackTrace();
        }
        return str2;
    }

    public static String getPackageVersion(Context context) {
        if (context == null) {
            return null;
        }
        PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(context.getApplicationContext().getApplicationInfo().sourceDir, 1);
        if (packageArchiveInfo == null) {
            return "";
        }
        return packageArchiveInfo.versionName;
    }

    public static byte[] getSign(Context context) {
        String str = "fail " + context.getPackageName() + " ";
        try {
            PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 64);
            if (packageInfo == null) {
                return (str + " get sign fail ").getBytes();
            }
            Signature[] signatureArr = packageInfo.signatures;
            if (signatureArr == null) {
                return (str + " get signatures fail ").getBytes();
            }
            Signature signature = signatureArr[0];
            if (signature == null) {
                return (str + " get signatures[0] fail ").getBytes();
            }
            if (signature.toByteArray().length == 0) {
                return (str + " byteSig len 0 ").getBytes();
            }
            return packageInfo.signatures[0].toByteArray();
        } catch (Exception unused) {
            return (str + " getInstallPackages exception ").getBytes();
        }
    }

    public static String getSignatureHash(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            String str = new String(bArr);
            if (str.indexOf("fail") != -1) {
                return str;
            }
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
                messageDigest.update(bArr);
                return toHexString(messageDigest.digest());
            } catch (Exception e16) {
                e16.printStackTrace();
                return "get signature hash failed!";
            }
        }
        return "getPublicKey signature null ";
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

    public static String getFileMd5(InputStream inputStream) {
        if (inputStream == null) {
            return "";
        }
        try {
            byte[] bArr = new byte[8192];
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    messageDigest.update(bArr, 0, read);
                } else {
                    return toHexString(messageDigest.digest());
                }
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
            return "";
        }
    }

    public static String getFileMd5(File file) {
        RandomAccessFile randomAccessFile = null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            if (file == null || !file.exists()) {
                return "";
            }
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "r");
            try {
                byte[] bArr = new byte[10485760];
                while (true) {
                    int read = randomAccessFile2.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    messageDigest.update(bArr, 0, read);
                }
                String hexString = toHexString(messageDigest.digest());
                try {
                    randomAccessFile2.close();
                } catch (IOException e16) {
                    e16.printStackTrace();
                }
                return hexString;
            } catch (Throwable th5) {
                th = th5;
                randomAccessFile = randomAccessFile2;
                try {
                    th.printStackTrace();
                    return "";
                } finally {
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException e17) {
                            e17.printStackTrace();
                        }
                    }
                }
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }
}
