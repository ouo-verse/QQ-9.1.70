package com.tencent.qqmini.sdk.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.utils.FileUtils;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.channels.FileLock;
import java.util.List;

/* compiled from: P */
/* loaded from: classes23.dex */
public class AssetsUtil {
    public static final String TAG = "AssetsUtil";

    private static boolean copyAssetToFile(AssetManager assetManager, String str, String str2) {
        FileOutputStream fileOutputStream;
        FileLock fileLock;
        StringBuilder sb5;
        StringBuilder sb6;
        StringBuilder sb7;
        BufferedInputStream bufferedInputStream = null;
        try {
            fileOutputStream = new FileOutputStream(str2);
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
                                    } catch (IOException e16) {
                                        QMLog.e("AssetsUtil", "copyAssetToFile error! assetFileName:" + str + ", destFileName:" + str2, e16);
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
                                        return true;
                                    } catch (IOException e17) {
                                        e = e17;
                                        sb7 = new StringBuilder();
                                        sb7.append("copyAssetToFile error! assetFileName:");
                                        sb7.append(str);
                                        sb7.append(", destFileName:");
                                        sb7.append(str2);
                                        QMLog.e("AssetsUtil", sb7.toString(), e);
                                        return true;
                                    }
                                } catch (Throwable th5) {
                                    throw th5;
                                }
                            } catch (IOException e18) {
                                QMLog.e("AssetsUtil", "copyAssetToFile error! assetFileName:" + str + ", destFileName:" + str2, e18);
                                try {
                                    fileOutputStream.close();
                                    return true;
                                } catch (IOException e19) {
                                    e = e19;
                                    sb7 = new StringBuilder();
                                    sb7.append("copyAssetToFile error! assetFileName:");
                                    sb7.append(str);
                                    sb7.append(", destFileName:");
                                    sb7.append(str2);
                                    QMLog.e("AssetsUtil", sb7.toString(), e);
                                    return true;
                                }
                            }
                        } catch (IOException e26) {
                            e = e26;
                            bufferedInputStream = bufferedInputStream2;
                            QMLog.e("AssetsUtil", "copyAssetToFile error! assetFileName:" + str + ", destFileName:" + str2, e);
                            if (bufferedInputStream != null) {
                                try {
                                    bufferedInputStream.close();
                                } catch (IOException e27) {
                                    QMLog.e("AssetsUtil", "copyAssetToFile error! assetFileName:" + str + ", destFileName:" + str2, e27);
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
                                        } catch (IOException e28) {
                                            e = e28;
                                            sb6 = new StringBuilder();
                                            sb6.append("copyAssetToFile error! assetFileName:");
                                            sb6.append(str);
                                            sb6.append(", destFileName:");
                                            sb6.append(str2);
                                            QMLog.e("AssetsUtil", sb6.toString(), e);
                                            return false;
                                        }
                                    } finally {
                                        try {
                                            fileOutputStream.close();
                                        } catch (IOException e29) {
                                            QMLog.e("AssetsUtil", "copyAssetToFile error! assetFileName:" + str + ", destFileName:" + str2, e29);
                                        }
                                    }
                                } catch (IOException e36) {
                                    QMLog.e("AssetsUtil", "copyAssetToFile error! assetFileName:" + str + ", destFileName:" + str2, e36);
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException e37) {
                                        e = e37;
                                        sb6 = new StringBuilder();
                                        sb6.append("copyAssetToFile error! assetFileName:");
                                        sb6.append(str);
                                        sb6.append(", destFileName:");
                                        sb6.append(str2);
                                        QMLog.e("AssetsUtil", sb6.toString(), e);
                                        return false;
                                    }
                                    return false;
                                }
                            }
                            return false;
                        } catch (Throwable th6) {
                            th = th6;
                            bufferedInputStream = bufferedInputStream2;
                            if (bufferedInputStream != null) {
                                try {
                                    bufferedInputStream.close();
                                } catch (IOException e38) {
                                    QMLog.e("AssetsUtil", "copyAssetToFile error! assetFileName:" + str + ", destFileName:" + str2, e38);
                                }
                            }
                            try {
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.getFD().sync();
                                        if (fileLock != null) {
                                            fileLock.release();
                                        }
                                        try {
                                            fileOutputStream.close();
                                            throw th;
                                        } catch (IOException e39) {
                                            e = e39;
                                            sb5 = new StringBuilder();
                                            sb5.append("copyAssetToFile error! assetFileName:");
                                            sb5.append(str);
                                            sb5.append(", destFileName:");
                                            sb5.append(str2);
                                            QMLog.e("AssetsUtil", sb5.toString(), e);
                                            throw th;
                                        }
                                    } catch (IOException e46) {
                                        QMLog.e("AssetsUtil", "copyAssetToFile error! assetFileName:" + str + ", destFileName:" + str2, e46);
                                        try {
                                            fileOutputStream.close();
                                            throw th;
                                        } catch (IOException e47) {
                                            e = e47;
                                            sb5 = new StringBuilder();
                                            sb5.append("copyAssetToFile error! assetFileName:");
                                            sb5.append(str);
                                            sb5.append(", destFileName:");
                                            sb5.append(str2);
                                            QMLog.e("AssetsUtil", sb5.toString(), e);
                                            throw th;
                                        }
                                    }
                                }
                                throw th;
                            } catch (Throwable th7) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e48) {
                                    QMLog.e("AssetsUtil", "copyAssetToFile error! assetFileName:" + str + ", destFileName:" + str2, e48);
                                }
                                throw th7;
                            }
                        }
                    } catch (Throwable th8) {
                        th = th8;
                    }
                } catch (IOException e49) {
                    e = e49;
                }
            } catch (IOException e56) {
                e = e56;
                fileLock = null;
            } catch (Throwable th9) {
                th = th9;
                fileLock = null;
            }
        } catch (IOException e57) {
            e = e57;
            fileOutputStream = null;
            fileLock = null;
        } catch (Throwable th10) {
            th = th10;
            fileOutputStream = null;
            fileLock = null;
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
                            QMLog.e("AssetsUtil", String.format("copyAssetToFile from=%s, to=%s fail", str4, absolutePath));
                            return false;
                        }
                    }
                }
                return true;
            } catch (Throwable th5) {
                QMLog.e("AssetsUtil", String.format("copyFileOrDir assetsPath=%s, destPath=%s, exception", str, str2), th5);
                try {
                    if (new File(str2).exists()) {
                        FileUtils.delete(str2, false);
                    }
                } catch (Throwable unused) {
                }
            }
        }
        return false;
    }

    public static String readFile(Context context, String str) {
        AssetManager assets = context.getAssets();
        StringBuilder sb5 = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(assets.open(str)));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb5.append(readLine);
                    sb5.append('\n');
                } finally {
                }
            }
            bufferedReader.close();
        } catch (IOException e16) {
            QMLog.e("AssetsUtil", "readFile: path=" + str + ", failed.", e16);
        }
        return sb5.toString();
    }
}
