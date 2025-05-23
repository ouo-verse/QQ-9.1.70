package cooperation.qqcircle.utils;

import com.tencent.commonsdk.pool.ByteArrayPool;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QCircleFileUtils {
    private static final int DEFAULT_BUFFER_SIZE = 3072;
    private static final String TAG = "QCircleFileUtils";

    public static boolean copyFile(File file, File file2) {
        return copyFile(file, file2, false);
    }

    public static long copyStream(InputStream inputStream, OutputStream outputStream) {
        if (inputStream != null && outputStream != null) {
            try {
                byte[] bArr = new byte[3072];
                long j3 = 0;
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read > 0) {
                        outputStream.write(bArr, 0, read);
                        j3 += read;
                    } else {
                        outputStream.flush();
                        return j3;
                    }
                }
            } catch (IOException e16) {
                e16.printStackTrace();
            }
        }
        return 0L;
    }

    public static File createFile(String str) throws IOException {
        File file = new File(str);
        if (!file.exists()) {
            if (file.getParentFile() != null && !file.getParentFile().exists()) {
                if (file.getParentFile().mkdirs()) {
                    file.createNewFile();
                }
            } else {
                file.createNewFile();
            }
        }
        return file;
    }

    public static boolean moveFile(String str, String str2) {
        if (str == null || str2 == null) {
            return false;
        }
        File file = new File(str);
        if (!file.exists()) {
            return false;
        }
        try {
            copyFile(file, createFile(str2));
            file.delete();
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x00cf, code lost:
    
        if (r9 == false) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0096, code lost:
    
        com.tencent.qphone.base.util.QLog.e(cooperation.qqcircle.utils.QCircleFileUtils.TAG, 1, "copyFile error, ", r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0094, code lost:
    
        if (r9 == false) goto L89;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v14, types: [java.io.BufferedInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r8v4, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean copyFile(File file, File file2, boolean z16) {
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2;
        FileOutputStream fileOutputStream = null;
        try {
            try {
                if (file2.getParentFile() != null && !file2.getParentFile().exists()) {
                    file2.getParentFile().mkdirs();
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream((File) file2);
                try {
                    file2 = new BufferedInputStream(new FileInputStream(file));
                    try {
                        byte[] buf = ByteArrayPool.getGenericInstance().getBuf(4096);
                        while (true) {
                            int read = file2.read(buf);
                            if (read == -1) {
                                break;
                            }
                            fileOutputStream2.write(buf, 0, read);
                            fileOutputStream2.flush();
                        }
                        ByteArrayPool.getGenericInstance().returnBuf(buf);
                        try {
                            fileOutputStream2.close();
                        } catch (IOException e16) {
                            if (z16) {
                                QLog.e(TAG, 1, "copyFile error, ", e16);
                            }
                        }
                        try {
                            file2.close();
                            return true;
                        } catch (IOException e17) {
                            if (!z16) {
                                return true;
                            }
                            QLog.e(TAG, 1, "copyFile error, ", e17);
                            return true;
                        }
                    } catch (IOException e18) {
                        e = e18;
                        fileOutputStream = fileOutputStream2;
                        bufferedInputStream2 = file2;
                        if (z16) {
                            QLog.e(TAG, 1, "copyFile error, ", e);
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e19) {
                                if (z16) {
                                    QLog.e(TAG, 1, "copyFile error, ", e19);
                                }
                            }
                        }
                        if (bufferedInputStream2 != null) {
                            try {
                                bufferedInputStream2.close();
                            } catch (IOException e26) {
                                e = e26;
                            }
                        }
                        return false;
                    } catch (OutOfMemoryError e27) {
                        e = e27;
                        fileOutputStream = fileOutputStream2;
                        bufferedInputStream = file2;
                        if (z16) {
                            QLog.e(TAG, 1, "copyFile error, ", e);
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e28) {
                                if (z16) {
                                    QLog.e(TAG, 1, "copyFile error, ", e28);
                                }
                            }
                        }
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e29) {
                                e = e29;
                            }
                        }
                        return false;
                    } catch (Throwable th5) {
                        th = th5;
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e36) {
                                if (z16) {
                                    QLog.e(TAG, 1, "copyFile error, ", e36);
                                }
                            }
                        }
                        if (file2 != 0) {
                            try {
                                file2.close();
                            } catch (IOException e37) {
                                if (z16) {
                                    QLog.e(TAG, 1, "copyFile error, ", e37);
                                }
                            }
                        }
                        throw th;
                    }
                } catch (IOException e38) {
                    e = e38;
                    file2 = 0;
                } catch (OutOfMemoryError e39) {
                    e = e39;
                    file2 = 0;
                } catch (Throwable th6) {
                    th = th6;
                    file2 = 0;
                }
            } catch (IOException e46) {
                e = e46;
                bufferedInputStream2 = null;
            } catch (OutOfMemoryError e47) {
                e = e47;
                bufferedInputStream = null;
            } catch (Throwable th7) {
                th = th7;
                file2 = 0;
            }
        } catch (Throwable th8) {
            th = th8;
        }
    }
}
