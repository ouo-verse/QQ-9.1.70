package com.tencent.mtt.hippy.utils;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

/* compiled from: P */
/* loaded from: classes20.dex */
public class FileUtils {
    public static File createDir(File file, String str) {
        if (file == null || str == null || str.length() == 0) {
            return null;
        }
        File file2 = new File(file, str);
        if (!file2.exists() && !file2.mkdirs()) {
            LogUtils.e("FileUtils", "mkdirs failed!!");
            return null;
        }
        return file2;
    }

    public static File getHippyFile(Context context) {
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        File filesDir = context.getFilesDir();
        if (filesDir == null) {
            return null;
        }
        return createDir(filesDir, "hippy");
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x005f A[Catch: all -> 0x003a, TRY_ENTER, TRY_LEAVE, TryCatch #9 {all -> 0x003a, blocks: (B:21:0x0036, B:32:0x005f), top: B:6:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0055 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0070 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0066 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:61:0x003b -> B:21:0x0062). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String readFile(String str) {
        ByteArrayOutputStream byteArrayOutputStream;
        FileInputStream fileInputStream;
        Throwable th5;
        Exception e16;
        File file = new File(str);
        String str2 = "";
        if (!file.exists()) {
            return "";
        }
        try {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
            } catch (Exception e17) {
                e = e17;
                byteArrayOutputStream = null;
                fileInputStream = null;
            } catch (Throwable th6) {
                th = th6;
                byteArrayOutputStream = null;
                fileInputStream = null;
            }
            try {
                fileInputStream = new FileInputStream(file);
            } catch (Exception e18) {
                e = e18;
                fileInputStream = null;
                e16 = e;
                e16.printStackTrace();
                if (fileInputStream != null) {
                }
                if (byteArrayOutputStream != null) {
                }
                return str2;
            } catch (Throwable th7) {
                th = th7;
                fileInputStream = null;
                th5 = th;
                if (fileInputStream != null) {
                }
                if (byteArrayOutputStream == null) {
                }
            }
        } catch (Throwable th8) {
            th8.printStackTrace();
        }
        try {
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = fileInputStream.read(bArr, 0, 4096);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                str2 = byteArrayOutputStream.toString();
                try {
                    fileInputStream.close();
                } catch (Throwable th9) {
                    th9.printStackTrace();
                }
                byteArrayOutputStream.close();
            } catch (Throwable th10) {
                th5 = th10;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable th11) {
                        th11.printStackTrace();
                    }
                }
                if (byteArrayOutputStream == null) {
                    try {
                        byteArrayOutputStream.close();
                        throw th5;
                    } catch (Throwable th12) {
                        th12.printStackTrace();
                        throw th5;
                    }
                }
                throw th5;
            }
        } catch (Exception e19) {
            e16 = e19;
            e16.printStackTrace();
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Throwable th13) {
                    th13.printStackTrace();
                }
            }
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            return str2;
        }
        return str2;
    }

    public static byte[] readFileToByteArray(String str) {
        File file = new File(str);
        byte[] bArr = null;
        if (!file.exists()) {
            return null;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr2 = new byte[4096];
                while (true) {
                    int read = fileInputStream.read(bArr2, 0, 4096);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr2, 0, read);
                }
            } catch (Throwable th5) {
                LogUtils.d("FileUtils", "readFileToByteArray: " + th5.getMessage());
            }
            fileInputStream.close();
            bArr = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return bArr;
        } catch (Exception e16) {
            e16.printStackTrace();
            return bArr;
        }
    }
}
