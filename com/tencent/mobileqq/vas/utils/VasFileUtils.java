package com.tencent.mobileqq.vas.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.vas.VasTempConstant;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* compiled from: P */
/* loaded from: classes20.dex */
public class VasFileUtils {
    private static final String TAG = "VasFileUtils";

    public static String getCacheFilePath(String str) {
        if (!TextUtils.isEmpty(str) && new File(str).exists()) {
            return str;
        }
        return VasTempConstant.CARD_DOWN_LOAD_DIR + str.hashCode() + ".png";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0174 A[Catch: Exception -> 0x0119, TRY_ENTER, TRY_LEAVE, TryCatch #15 {Exception -> 0x0119, blocks: (B:59:0x0150, B:38:0x0174, B:110:0x0114), top: B:3:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x016a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0160 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0150 A[Catch: Exception -> 0x0119, TRY_ENTER, TRY_LEAVE, TryCatch #15 {Exception -> 0x0119, blocks: (B:59:0x0150, B:38:0x0174, B:110:0x0114), top: B:3:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0146 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x013c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:123:0x011a -> B:43:0x0177). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String unZipFile(File file, String str) {
        InputStream inputStream;
        ZipFile zipFile;
        ?? r85;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                try {
                    zipFile = new ZipFile(file);
                } catch (Exception e16) {
                    e = e16;
                    zipFile = null;
                    inputStream = null;
                } catch (OutOfMemoryError e17) {
                    e = e17;
                    zipFile = null;
                    inputStream = null;
                } catch (Throwable th5) {
                    th = th5;
                    zipFile = null;
                    inputStream = null;
                }
                try {
                    Enumeration<? extends ZipEntry> entries = zipFile.entries();
                    byte[] bArr = new byte[8192];
                    inputStream = null;
                    r85 = 0;
                    while (entries.hasMoreElements()) {
                        try {
                            ZipEntry nextElement = entries.nextElement();
                            if (!nextElement.getName().contains("..")) {
                                if (nextElement.isDirectory()) {
                                    if (QLog.isDevelopLevel()) {
                                        QLog.d("upZipFile", 4, "ze.getName() = " + nextElement.getName());
                                    }
                                    String str2 = new String((str + nextElement.getName()).getBytes("8859_1"), "GB2312");
                                    if (QLog.isColorLevel()) {
                                        QLog.d("upZipFile", 2, "str = " + str2);
                                    }
                                    new File(str2).mkdir();
                                    r85 = str2;
                                } else {
                                    r85 = nextElement.getName();
                                    File file2 = new File(str + nextElement.getName());
                                    file2.getParentFile().mkdirs();
                                    if (file2.exists()) {
                                        file2.delete();
                                    }
                                    BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file2));
                                    try {
                                        inputStream = zipFile.getInputStream(nextElement);
                                        while (true) {
                                            int read = inputStream.read(bArr, 0, 8192);
                                            if (read == -1) {
                                                break;
                                            }
                                            bufferedOutputStream2.write(bArr, 0, read);
                                        }
                                        inputStream.close();
                                        bufferedOutputStream2.close();
                                        bufferedOutputStream = bufferedOutputStream2;
                                    } catch (Exception e18) {
                                        e = e18;
                                        bufferedOutputStream = bufferedOutputStream2;
                                        QLog.e(TAG, 1, "unZipFile error: ", e);
                                        if (bufferedOutputStream != null) {
                                        }
                                        if (inputStream != null) {
                                        }
                                        if (zipFile != null) {
                                        }
                                        return r85;
                                    } catch (OutOfMemoryError e19) {
                                        e = e19;
                                        bufferedOutputStream = bufferedOutputStream2;
                                        QLog.e(TAG, 1, "unZipFile oom: ", e);
                                        if (bufferedOutputStream != null) {
                                        }
                                        if (inputStream != null) {
                                        }
                                        if (zipFile != null) {
                                        }
                                        return r85;
                                    } catch (Throwable th6) {
                                        th = th6;
                                        bufferedOutputStream = bufferedOutputStream2;
                                        if (bufferedOutputStream != null) {
                                            try {
                                                bufferedOutputStream.close();
                                            } catch (Exception e26) {
                                                QLog.e(TAG, 1, "unZipFile close error: ", e26);
                                            }
                                        }
                                        if (inputStream != null) {
                                            try {
                                                inputStream.close();
                                            } catch (Exception e27) {
                                                QLog.e(TAG, 1, "unZipFile close error: ", e27);
                                            }
                                        }
                                        if (zipFile != null) {
                                            try {
                                                zipFile.close();
                                                throw th;
                                            } catch (Exception e28) {
                                                QLog.e(TAG, 1, "unZipFile close error: ", e28);
                                                throw th;
                                            }
                                        }
                                        throw th;
                                    }
                                }
                            }
                        } catch (Exception e29) {
                            e = e29;
                        } catch (OutOfMemoryError e36) {
                            e = e36;
                        }
                    }
                    zipFile.close();
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (Exception e37) {
                            QLog.e(TAG, 1, "unZipFile close error: ", e37);
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e38) {
                            QLog.e(TAG, 1, "unZipFile close error: ", e38);
                        }
                    }
                    zipFile.close();
                    r85 = r85;
                } catch (Exception e39) {
                    e = e39;
                    inputStream = null;
                    r85 = inputStream;
                    QLog.e(TAG, 1, "unZipFile error: ", e);
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (Exception e46) {
                            QLog.e(TAG, 1, "unZipFile close error: ", e46);
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e47) {
                            QLog.e(TAG, 1, "unZipFile close error: ", e47);
                        }
                    }
                    if (zipFile != null) {
                        zipFile.close();
                        r85 = r85;
                    }
                    return r85;
                } catch (OutOfMemoryError e48) {
                    e = e48;
                    inputStream = null;
                    r85 = inputStream;
                    QLog.e(TAG, 1, "unZipFile oom: ", e);
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (Exception e49) {
                            QLog.e(TAG, 1, "unZipFile close error: ", e49);
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e56) {
                            QLog.e(TAG, 1, "unZipFile close error: ", e56);
                        }
                    }
                    if (zipFile != null) {
                        zipFile.close();
                        r85 = r85;
                    }
                    return r85;
                } catch (Throwable th7) {
                    th = th7;
                    inputStream = null;
                }
            } catch (Exception e57) {
                QLog.e(TAG, 1, "unZipFile close error: ", e57);
                r85 = r85;
            }
            return r85;
        } catch (Throwable th8) {
            th = th8;
        }
    }
}
