package com.tencent.mobileqq.minigame.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.channels.FileLock;
import java.util.List;

/* compiled from: P */
/* loaded from: classes15.dex */
public class AssetsUtil {
    public static final String TAG = "[minigame] AssetsUtil";

    /* JADX WARN: Removed duplicated region for block: B:125:0x0155 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x016c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean copyAssetToFile(AssetManager assetManager, String str, String str2) {
        Throwable th5;
        FileOutputStream fileOutputStream;
        FileLock fileLock;
        BufferedInputStream bufferedInputStream = null;
        try {
            fileOutputStream = new FileOutputStream(str2);
        } catch (IOException e16) {
            e = e16;
            fileOutputStream = null;
            fileLock = null;
        } catch (Throwable th6) {
            th5 = th6;
            fileOutputStream = null;
            fileLock = null;
        }
        try {
            fileLock = fileOutputStream.getChannel().lock();
            try {
                try {
                    BufferedInputStream bufferedInputStream2 = new BufferedInputStream(assetManager.open(str));
                    try {
                        byte[] bArr = new byte[8192];
                        while (true) {
                            int read = bufferedInputStream2.read(bArr);
                            if (read != -1) {
                                fileOutputStream.write(bArr, 0, read);
                            } else {
                                try {
                                    break;
                                } catch (IOException e17) {
                                    QLog.e(TAG, 1, "copyAssetToFile error! assetFileName:", str, ", destFileName:", str2, e17);
                                }
                            }
                        }
                        bufferedInputStream2.close();
                        try {
                            try {
                                fileOutputStream.getFD().sync();
                                if (fileLock != null) {
                                    fileLock.release();
                                }
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e18) {
                                    QLog.e(TAG, 1, "copyAssetToFile error! assetFileName:", str, ", destFileName:", str2, e18);
                                }
                            } catch (IOException e19) {
                                QLog.e(TAG, 1, "copyAssetToFile error! assetFileName:", str, ", destFileName:", str2, e19);
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e26) {
                                    QLog.e(TAG, 1, "copyAssetToFile error! assetFileName:", str, ", destFileName:", str2, e26);
                                }
                            }
                            return true;
                        } finally {
                        }
                    } catch (IOException e27) {
                        e = e27;
                        bufferedInputStream = bufferedInputStream2;
                        QLog.e(TAG, 1, "copyAssetToFile error! assetFileName:", str, ", destFileName:", str2, e);
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e28) {
                                QLog.e(TAG, 1, "copyAssetToFile error! assetFileName:", str, ", destFileName:", str2, e28);
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                try {
                                    fileOutputStream.getFD().sync();
                                    if (fileLock != null) {
                                        fileLock.release();
                                    }
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException e29) {
                                        QLog.e(TAG, 1, "copyAssetToFile error! assetFileName:", str, ", destFileName:", str2, e29);
                                    }
                                } finally {
                                }
                            } catch (IOException e36) {
                                QLog.e(TAG, 1, "copyAssetToFile error! assetFileName:", str, ", destFileName:", str2, e36);
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e37) {
                                    QLog.e(TAG, 1, "copyAssetToFile error! assetFileName:", str, ", destFileName:", str2, e37);
                                }
                                return false;
                            }
                        }
                        return false;
                    } catch (Throwable th7) {
                        th = th7;
                        bufferedInputStream = bufferedInputStream2;
                        th5 = th;
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e38) {
                                QLog.e(TAG, 1, "copyAssetToFile error! assetFileName:", str, ", destFileName:", str2, e38);
                            }
                        }
                        if (fileOutputStream == null) {
                            try {
                                try {
                                    fileOutputStream.getFD().sync();
                                    if (fileLock != null) {
                                        fileLock.release();
                                    }
                                    try {
                                        fileOutputStream.close();
                                        throw th5;
                                    } catch (IOException e39) {
                                        QLog.e(TAG, 1, "copyAssetToFile error! assetFileName:", str, ", destFileName:", str2, e39);
                                        throw th5;
                                    }
                                } catch (IOException e46) {
                                    QLog.e(TAG, 1, "copyAssetToFile error! assetFileName:", str, ", destFileName:", str2, e46);
                                    try {
                                        fileOutputStream.close();
                                        throw th5;
                                    } catch (IOException e47) {
                                        QLog.e(TAG, 1, "copyAssetToFile error! assetFileName:", str, ", destFileName:", str2, e47);
                                        throw th5;
                                    }
                                }
                            } finally {
                            }
                        } else {
                            throw th5;
                        }
                    }
                } catch (Throwable th8) {
                    th = th8;
                }
            } catch (IOException e48) {
                e = e48;
            }
        } catch (IOException e49) {
            e = e49;
            fileLock = null;
        } catch (Throwable th9) {
            th5 = th9;
            fileLock = null;
            if (bufferedInputStream != null) {
            }
            if (fileOutputStream == null) {
            }
        }
    }

    public static boolean copyFileOrDir(Context context, String str, String str2, List<String> list) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && list != null && list.size() > 0) {
            try {
                AssetManager assets = context.getAssets();
                File file = new File(str2);
                if (!file.exists()) {
                    file.mkdir();
                }
                for (String str3 : list) {
                    if (!TextUtils.isEmpty(str3)) {
                        File file2 = new File(str2, str3);
                        if (!file2.exists()) {
                            file2.getParentFile().mkdirs();
                        }
                        String str4 = str + File.separator + str3;
                        String absolutePath = file2.getAbsolutePath();
                        if (!copyAssetToFile(assets, str4, absolutePath)) {
                            QLog.e(TAG, 1, String.format("copyAssetToFile from=%s, to=%s fail", str4, absolutePath));
                            return false;
                        }
                    }
                }
                return true;
            } catch (Throwable th5) {
                QLog.e(TAG, 1, String.format("copyFileOrDir assetsPath=%s, destPath=%s, exception", str, str2), th5);
                try {
                    File file3 = new File(str2);
                    if (file3.exists()) {
                        com.tencent.mobileqq.utils.FileUtils.deleteFile(file3);
                    }
                } catch (Throwable unused) {
                }
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00b0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x009e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getContentFromAssets(Context context, String str) {
        BufferedReader bufferedReader;
        Throwable th5;
        InputStream inputStream;
        String str2 = null;
        try {
            inputStream = context.getAssets().open(str);
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            } catch (IOException e16) {
                e = e16;
                bufferedReader = null;
            } catch (Throwable th6) {
                bufferedReader = null;
                th5 = th6;
                if (bufferedReader != null) {
                }
                if (inputStream == null) {
                }
            }
        } catch (IOException e17) {
            e = e17;
            inputStream = null;
            bufferedReader = null;
        } catch (Throwable th7) {
            bufferedReader = null;
            th5 = th7;
            inputStream = null;
        }
        try {
            try {
                StringBuilder sb5 = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb5.append(readLine);
                }
                str2 = sb5.toString();
                try {
                    bufferedReader.close();
                } catch (IOException e18) {
                    QLog.e(TAG, 1, "getContentFromAssets close input stream error, fileName:", str, e18);
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e19) {
                        QLog.e(TAG, 1, "getContentFromAssets close content reader error, fileName:", str, e19);
                    }
                }
            } catch (Throwable th8) {
                th5 = th8;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e26) {
                        QLog.e(TAG, 1, "getContentFromAssets close input stream error, fileName:", str, e26);
                    }
                }
                if (inputStream == null) {
                    try {
                        inputStream.close();
                        throw th5;
                    } catch (IOException e27) {
                        QLog.e(TAG, 1, "getContentFromAssets close content reader error, fileName:", str, e27);
                        throw th5;
                    }
                }
                throw th5;
            }
        } catch (IOException e28) {
            e = e28;
            QLog.e(TAG, 1, "getContentFromAssets error, fileName:", str, e);
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e29) {
                    QLog.e(TAG, 1, "getContentFromAssets close input stream error, fileName:", str, e29);
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e36) {
                    QLog.e(TAG, 1, "getContentFromAssets close content reader error, fileName:", str, e36);
                }
            }
            return str2;
        }
        return str2;
    }
}
