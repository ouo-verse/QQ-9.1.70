package com.tencent.qqlive.tvkplayer.dex.sdkupdate;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.qqlive.tvkplayer.api.ITVKLogListener;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKUpdateUtils {
    private static final String TAG = "TVKPlayer[TVKUpdateUtils]";
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET, 'B', 'C', 'D', 'E', 'F'};
    private static boolean isDebugMode = false;
    private static ITVKLogListener mOnLogListener = null;

    public static String checkMD5(File file) {
        FileInputStream fileInputStream;
        byte[] bArr = new byte[8192];
        FileInputStream fileInputStream2 = null;
        if (file == null) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(file);
        } catch (Exception unused) {
            fileInputStream = null;
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                messageDigest.update(bArr, 0, read);
            }
            String hexString = toHexString(messageDigest.digest());
            try {
                fileInputStream.close();
            } catch (IOException e16) {
                e(TAG, e16);
            }
            return hexString;
        } catch (Exception unused2) {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e17) {
                    e(TAG, e17);
                }
            }
            return null;
        } catch (Throwable th6) {
            th = th6;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException e18) {
                    e(TAG, e18);
                }
            }
            throw th;
        }
    }

    public static boolean copyFile(File file, File file2) {
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
            } catch (Exception unused) {
            } catch (Throwable th5) {
                th = th5;
            }
        } catch (Exception unused2) {
            fileInputStream = null;
        } catch (Throwable th6) {
            th = th6;
            fileInputStream = null;
        }
        try {
            byte[] bArr = new byte[8192];
            while (true) {
                int read = fileInputStream.read(bArr, 0, 8192);
                if (read <= -1) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
            }
            fileOutputStream.flush();
            try {
                fileOutputStream.close();
            } catch (Exception e16) {
                e(TAG, e16);
            }
            try {
                fileInputStream.close();
                return true;
            } catch (Exception e17) {
                e(TAG, e17);
                return true;
            }
        } catch (Exception unused3) {
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (Exception e18) {
                    e(TAG, e18);
                }
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception e19) {
                    e(TAG, e19);
                }
            }
            return false;
        } catch (Throwable th7) {
            th = th7;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (Exception e26) {
                    e(TAG, e26);
                }
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                    throw th;
                } catch (Exception e27) {
                    e(TAG, e27);
                    throw th;
                }
            }
            throw th;
        }
    }

    public static void d(String str, String str2) {
        ITVKLogListener iTVKLogListener = mOnLogListener;
        if (iTVKLogListener != null) {
            iTVKLogListener.d(str, str2);
        } else if (isDebugMode) {
            Log.d(str, str2);
        }
    }

    public static void e(String str, String str2) {
        ITVKLogListener iTVKLogListener = mOnLogListener;
        if (iTVKLogListener != null) {
            iTVKLogListener.e(str, str2);
        } else if (isDebugMode) {
            Log.e(str, str2);
        }
    }

    public static void i(String str, String str2) {
        ITVKLogListener iTVKLogListener = mOnLogListener;
        if (iTVKLogListener != null) {
            iTVKLogListener.i(str, str2);
        } else if (isDebugMode) {
            Log.i(str, str2);
        }
    }

    public static boolean isWifiConnected(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
            if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null) {
                if (NetworkMonitor.getType(activeNetworkInfo) == 1) {
                    return true;
                }
                return false;
            }
            return false;
        } catch (Exception e16) {
            e(TAG, e16);
            return false;
        }
    }

    public static void recursionDeleteFile(File file) {
        if (file.isFile()) {
            if (!file.delete()) {
                i(TAG, "recursionDeleteFile, file.delete()");
                return;
            }
            return;
        }
        try {
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length != 0) {
                    for (File file2 : listFiles) {
                        recursionDeleteFile(file2);
                    }
                    if (!file.delete()) {
                        i(TAG, "recursionDeleteFile, file.delete()");
                        return;
                    }
                    return;
                }
                if (!file.delete()) {
                    i(TAG, "recursionDeleteFile, file.delete()");
                }
            }
        } catch (OutOfMemoryError e16) {
            e(TAG, e16);
        }
    }

    public static void setDebugMode(boolean z16) {
        isDebugMode = z16;
    }

    public static void setOnLogListener(ITVKLogListener iTVKLogListener) {
        mOnLogListener = iTVKLogListener;
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

    private static void unZipFile(ZipEntry zipEntry, InputStream inputStream, FileOutputStream fileOutputStream, String str) throws Exception {
        String name = zipEntry.getName();
        if (!TextUtils.isEmpty(name) && name.contains("../")) {
            throw new Exception("contain ../, throw err");
        }
        if (zipEntry.isDirectory()) {
            if (!new File(str + File.separator + name.substring(0, name.length() - 1)).mkdirs()) {
                w(TAG, "unZipFolder, folder.mkdirs()");
            }
        } else {
            File file = new File(str + File.separator + name);
            if (!file.getParentFile().exists() && !file.getParentFile().mkdirs()) {
                w(TAG, "unZipFolder, file.getParentFile().mkdirs()");
            }
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            byte[] bArr = new byte[8192];
            while (true) {
                int read = inputStream.read(bArr, 0, 8192);
                if (read == -1) {
                    break;
                }
                fileOutputStream2.write(bArr, 0, read);
                fileOutputStream2.flush();
            }
            fileOutputStream2.close();
        }
        inputStream.close();
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0047 A[Catch: Exception -> 0x0043, TRY_LEAVE, TryCatch #6 {Exception -> 0x0043, blocks: (B:38:0x003f, B:31:0x0047), top: B:37:0x003f }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x003f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void unZipFolder(String str, String str2) throws Exception {
        InputStream inputStream;
        ZipFile zipFile = null;
        try {
            ZipFile zipFile2 = new ZipFile(str);
            try {
                Enumeration<? extends ZipEntry> entries = zipFile2.entries();
                inputStream = null;
                while (entries.hasMoreElements()) {
                    try {
                        ZipEntry nextElement = entries.nextElement();
                        inputStream = zipFile2.getInputStream(nextElement);
                        unZipFile(nextElement, inputStream, null, str2);
                    } catch (Exception e16) {
                        e = e16;
                        zipFile = zipFile2;
                        try {
                            throw e;
                        } catch (Throwable th5) {
                            th = th5;
                            if (zipFile != null) {
                                try {
                                    zipFile.close();
                                } catch (Exception e17) {
                                    throw e17;
                                }
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        zipFile = zipFile2;
                        if (zipFile != null) {
                        }
                        if (inputStream != null) {
                        }
                        throw th;
                    }
                }
                try {
                    zipFile2.close();
                    if (inputStream != null) {
                        inputStream.close();
                    }
                } catch (Exception e18) {
                    throw e18;
                }
            } catch (Exception e19) {
                e = e19;
                inputStream = null;
            } catch (Throwable th7) {
                th = th7;
                inputStream = null;
            }
        } catch (Exception e26) {
            e = e26;
            inputStream = null;
        } catch (Throwable th8) {
            th = th8;
            inputStream = null;
        }
    }

    public static void v(String str, String str2) {
        ITVKLogListener iTVKLogListener = mOnLogListener;
        if (iTVKLogListener != null) {
            iTVKLogListener.v(str, str2);
        } else if (isDebugMode) {
            Log.v(str, str2);
        }
    }

    public static void w(String str, String str2) {
        ITVKLogListener iTVKLogListener = mOnLogListener;
        if (iTVKLogListener != null) {
            iTVKLogListener.w(str, str2);
        } else if (isDebugMode) {
            Log.w(str, str2);
        }
    }

    public static void e(String str, Throwable th5) {
        e(str, th5, "");
    }

    public static void e(String str, Throwable th5, String str2) {
        String str3;
        if (TextUtils.isEmpty(str2)) {
            str3 = "";
        } else {
            str3 = str2 + "\n";
        }
        if (th5 != null) {
            str3 = str3 + Log.getStackTraceString(th5);
        }
        e(str, str3);
    }
}
