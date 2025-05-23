package com.tencent.qcircle.weseevideo.model.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.qcircle.tavcut.util.Logger;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: P */
/* loaded from: classes22.dex */
public class FileUtils {
    private static final String TAG = "FileUtils";

    /* JADX WARN: Removed duplicated region for block: B:47:0x00d2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00c8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:65:0x00c1 -> B:21:0x00c4). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void copyAssets(Context context, String str, String str2, String str3) {
        FileOutputStream fileOutputStream;
        InputStream open;
        FileOutputStream fileOutputStream2;
        SharedPreferences sharedPreferences = context.getSharedPreferences("isFirstCopyAsset", 0);
        boolean z16 = sharedPreferences.getBoolean("isFristDownLoad", true);
        sharedPreferences.edit();
        if (!z16 && new File(str3, str2).exists()) {
            Log.d("FileUtils", "copyAssets \u6587\u4ef6\u5df2\u7ecf\u5b58\u5728 pAssetFilePath = [" + str + "], pDestDirPath = [" + str3 + "]");
            return;
        }
        InputStream inputStream = null;
        try {
            try {
                open = context.getAssets().open(str);
                try {
                    File file = new File(str3, str2);
                    if (!file.getParentFile().exists()) {
                        file.getParentFile().mkdirs();
                    }
                    fileOutputStream2 = new FileOutputStream(file);
                } catch (IOException e16) {
                    e = e16;
                    inputStream = open;
                    fileOutputStream = null;
                } catch (Throwable th5) {
                    th = th5;
                    inputStream = open;
                    fileOutputStream = null;
                }
            } catch (IOException e17) {
                e = e17;
                fileOutputStream = null;
            } catch (Throwable th6) {
                th = th6;
                fileOutputStream = null;
            }
            try {
                copyFile(open, fileOutputStream2);
                fileOutputStream2.flush();
                if (open != null) {
                    try {
                        open.close();
                    } catch (IOException e18) {
                        e18.printStackTrace();
                    }
                }
                fileOutputStream2.close();
            } catch (IOException e19) {
                inputStream = open;
                fileOutputStream = fileOutputStream2;
                e = e19;
                try {
                    Log.e("tag", "Failed to copy asset file: " + str, e);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e26) {
                            e26.printStackTrace();
                        }
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                } catch (Throwable th7) {
                    th = th7;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e27) {
                            e27.printStackTrace();
                        }
                    }
                    if (fileOutputStream == null) {
                        try {
                            fileOutputStream.close();
                            throw th;
                        } catch (IOException e28) {
                            e28.printStackTrace();
                            throw th;
                        }
                    }
                    throw th;
                }
            } catch (Throwable th8) {
                th = th8;
                inputStream = open;
                fileOutputStream = fileOutputStream2;
                if (inputStream != null) {
                }
                if (fileOutputStream == null) {
                }
            }
        } catch (IOException e29) {
            e29.printStackTrace();
        }
    }

    private static void copyFile(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[16384];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    public static boolean exists(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.indexOf("assets") < 0 && !new File(str).exists()) {
            return false;
        }
        return true;
    }

    public static String getFilePathBySuffix(String str, String str2) {
        File[] listFiles;
        if (TextUtils.isEmpty(str) && !exists(str)) {
            return "";
        }
        if (str.endsWith(str2)) {
            return str;
        }
        File file = new File(str);
        if (!file.isDirectory() || (listFiles = file.listFiles()) == null) {
            return null;
        }
        for (File file2 : listFiles) {
            if (file2.getName().endsWith(str2)) {
                String absolutePath = file2.getAbsolutePath();
                Logger.i("FileUtils", "getFilePathBySuffix: " + absolutePath);
                return absolutePath;
            }
        }
        return null;
    }
}
