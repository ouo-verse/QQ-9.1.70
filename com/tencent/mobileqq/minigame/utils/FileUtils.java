package com.tencent.mobileqq.minigame.utils;

import android.content.Context;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes33.dex */
public class FileUtils {
    private static final String JS_TYPE = "js";
    private static final String TAG = "MiniGame-FileUtils";

    public static void copyFilesFromAssets(Context context, String str, String str2) {
        FileOutputStream fileOutputStream;
        try {
            String[] list = context.getAssets().list(str);
            if (list.length > 0) {
                new File(str2).mkdirs();
                for (String str3 : list) {
                    copyFilesFromAssets(context, str + "/" + str3, str2 + "/" + str3);
                }
                return;
            }
            InputStream inputStream = null;
            try {
                InputStream open = context.getAssets().open(str);
                try {
                    fileOutputStream = new FileOutputStream(new File(str2));
                } catch (Throwable th5) {
                    th = th5;
                    fileOutputStream = null;
                }
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = open.read(bArr);
                        if (read == -1) {
                            break;
                        } else {
                            fileOutputStream.write(bArr, 0, read);
                        }
                    }
                    fileOutputStream.flush();
                    open.close();
                    fileOutputStream.close();
                    open.close();
                } catch (Throwable th6) {
                    th = th6;
                    inputStream = open;
                    try {
                        QLog.e(TAG, 1, "copyFilesFromAssets t:" + th.getMessage());
                        th.printStackTrace();
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        return;
                    } catch (Throwable th7) {
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        throw th7;
                    }
                }
            } catch (Throwable th8) {
                th = th8;
                fileOutputStream = null;
            }
            fileOutputStream.close();
        } catch (Exception e16) {
            QLog.e(TAG, 1, "copyFilesFromAssets e:" + e16.getMessage());
            e16.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x015e A[Catch: Exception -> 0x0175, TRY_ENTER, TryCatch #3 {Exception -> 0x0175, blocks: (B:3:0x0008, B:6:0x0016, B:8:0x001c, B:11:0x0023, B:13:0x0030, B:15:0x003a, B:16:0x0067, B:18:0x0088, B:20:0x0164, B:21:0x00b1, B:84:0x00b7, B:23:0x00be, B:81:0x00c4, B:25:0x00cb, B:78:0x00d1, B:27:0x00d8, B:29:0x00de, B:31:0x00e4, B:33:0x00ea, B:35:0x00f6, B:51:0x0130, B:52:0x0133, B:59:0x015e, B:66:0x016b, B:68:0x0170, B:69:0x0173, B:86:0x004f, B:57:0x0140), top: B:2:0x0008, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0164 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean copyFolder(String str, String str2) {
        File file;
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        Throwable th5;
        try {
            File file2 = new File(str2);
            if (!file2.exists() && !file2.mkdirs()) {
                QLog.e("--Method--", 1, "copyFolder: cannot create directory.");
                return false;
            }
            for (String str3 : new File(str).list()) {
                String str4 = File.separator;
                if (str.endsWith(str4)) {
                    file = new File(str + str3);
                } else {
                    file = new File(str + str4 + str3);
                }
                File file3 = new File(str2 + "/" + file.getName());
                if (file.isDirectory()) {
                    copyFolder(str + "/" + str3, str2 + "/" + str3);
                } else {
                    if (!file.exists()) {
                        QLog.e("--Method--", 1, "copyFolder:  oldFile not exist.");
                        return false;
                    }
                    if (!file.isFile()) {
                        QLog.e("--Method--", 1, "copyFolder:  oldFile not file.");
                        return false;
                    }
                    if (!file.canRead()) {
                        QLog.e("--Method--", 1, "copyFolder:  oldFile cannot read.");
                        return false;
                    }
                    if (!file.isFile() || !file3.exists() || !file3.isFile()) {
                        try {
                            fileInputStream = new FileInputStream(file);
                        } catch (Throwable th6) {
                            th = th6;
                            fileInputStream = null;
                            fileOutputStream = null;
                        }
                        try {
                            fileOutputStream = new FileOutputStream(str2 + "/" + file.getName());
                        } catch (Throwable th7) {
                            th = th7;
                            fileOutputStream = null;
                            th5 = th;
                            try {
                                QLog.e(TAG, 1, "copyFolder Throwable t:" + th5.getMessage());
                                th5.printStackTrace();
                                if (fileInputStream != null) {
                                }
                                if (fileOutputStream == null) {
                                }
                            } catch (Throwable th8) {
                                if (fileInputStream != null) {
                                    fileInputStream.close();
                                }
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                                throw th8;
                            }
                        }
                        try {
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int read = fileInputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                fileOutputStream.write(bArr, 0, read);
                            }
                            fileOutputStream.flush();
                            fileInputStream.close();
                        } catch (Throwable th9) {
                            th5 = th9;
                            QLog.e(TAG, 1, "copyFolder Throwable t:" + th5.getMessage());
                            th5.printStackTrace();
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            if (fileOutputStream == null) {
                                fileOutputStream.close();
                            }
                        }
                        fileOutputStream.close();
                    } else if (file.length() == file3.length()) {
                        QLog.e("--Method--", 1, "exist the same file,continue! ");
                    }
                }
            }
            return true;
        } catch (Exception e16) {
            QLog.e(TAG, 1, "copyFolder Throwable e:" + e16.getMessage());
            e16.printStackTrace();
            return false;
        }
    }
}
