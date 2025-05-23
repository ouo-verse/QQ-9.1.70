package com.tencent.qqmini.v8rt.engine;

import android.content.res.AssetManager;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* compiled from: P */
/* loaded from: classes23.dex */
public class AssetUtil {
    public static final String LOG_TAG = "AssetUtil";

    public static boolean copyAssetToFile(AssetManager assetManager, String str, String str2) {
        FileOutputStream fileOutputStream;
        StringBuilder sb5;
        StringBuilder sb6;
        StringBuilder sb7;
        BufferedInputStream bufferedInputStream = null;
        try {
            try {
                String str3 = str2 + ".tmp";
                fileOutputStream = new FileOutputStream(str3);
                try {
                    BufferedInputStream bufferedInputStream2 = new BufferedInputStream(assetManager.open(str));
                    try {
                        byte[] bArr = new byte[8192];
                        while (true) {
                            int read = bufferedInputStream2.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, read);
                        }
                        boolean renameTo = new File(str3).renameTo(new File(str2));
                        try {
                            bufferedInputStream2.close();
                        } catch (IOException e16) {
                            Logger.e(LOG_TAG, "copyAssetToFile error !assetFileName:" + str + ",destFileName" + str2 + ",e:" + e16.getMessage());
                        }
                        try {
                            try {
                                fileOutputStream.getFD().sync();
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e17) {
                                    e = e17;
                                    sb7 = new StringBuilder();
                                    sb7.append("copyAssetToFile error !assetFileName:");
                                    sb7.append(str);
                                    sb7.append(",destFileName");
                                    sb7.append(str2);
                                    sb7.append(",e:");
                                    sb7.append(e.getMessage());
                                    Logger.e(LOG_TAG, sb7.toString());
                                    return renameTo;
                                }
                            } catch (IOException e18) {
                                Logger.e(LOG_TAG, "copyAssetToFile error !assetFileName:" + str + ",destFileName" + str2 + ",e:" + e18.getMessage());
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e19) {
                                    e = e19;
                                    sb7 = new StringBuilder();
                                    sb7.append("copyAssetToFile error !assetFileName:");
                                    sb7.append(str);
                                    sb7.append(",destFileName");
                                    sb7.append(str2);
                                    sb7.append(",e:");
                                    sb7.append(e.getMessage());
                                    Logger.e(LOG_TAG, sb7.toString());
                                    return renameTo;
                                }
                            }
                            return renameTo;
                        } finally {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e26) {
                                Logger.e(LOG_TAG, "copyAssetToFile error !assetFileName:" + str + ",destFileName" + str2 + ",e:" + e26.getMessage());
                            }
                        }
                    } catch (IOException e27) {
                        e = e27;
                        bufferedInputStream = bufferedInputStream2;
                        Logger.e(LOG_TAG, "copyAssetToFile error !assetFileName:" + str + ",destFileName" + str2, e);
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e28) {
                                Logger.e(LOG_TAG, "copyAssetToFile error !assetFileName:" + str + ",destFileName" + str2 + ",e:" + e28.getMessage());
                            }
                        }
                        try {
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.getFD().sync();
                                } catch (IOException e29) {
                                    Logger.e(LOG_TAG, "copyAssetToFile error !assetFileName:" + str + ",destFileName" + str2 + ",e:" + e29.getMessage());
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException e36) {
                                        e = e36;
                                        sb6 = new StringBuilder();
                                        sb6.append("copyAssetToFile error !assetFileName:");
                                        sb6.append(str);
                                        sb6.append(",destFileName");
                                        sb6.append(str2);
                                        sb6.append(",e:");
                                        sb6.append(e.getMessage());
                                        Logger.e(LOG_TAG, sb6.toString());
                                        return false;
                                    }
                                    return false;
                                }
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e37) {
                                    e = e37;
                                    sb6 = new StringBuilder();
                                    sb6.append("copyAssetToFile error !assetFileName:");
                                    sb6.append(str);
                                    sb6.append(",destFileName");
                                    sb6.append(str2);
                                    sb6.append(",e:");
                                    sb6.append(e.getMessage());
                                    Logger.e(LOG_TAG, sb6.toString());
                                    return false;
                                }
                            }
                            return false;
                        } catch (Throwable th5) {
                            throw th5;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        bufferedInputStream = bufferedInputStream2;
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e38) {
                                Logger.e(LOG_TAG, "copyAssetToFile error !assetFileName:" + str + ",destFileName" + str2 + ",e:" + e38.getMessage());
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                try {
                                    fileOutputStream.getFD().sync();
                                    try {
                                        fileOutputStream.close();
                                        throw th;
                                    } catch (IOException e39) {
                                        e = e39;
                                        sb5 = new StringBuilder();
                                        sb5.append("copyAssetToFile error !assetFileName:");
                                        sb5.append(str);
                                        sb5.append(",destFileName");
                                        sb5.append(str2);
                                        sb5.append(",e:");
                                        sb5.append(e.getMessage());
                                        Logger.e(LOG_TAG, sb5.toString());
                                        throw th;
                                    }
                                } catch (Throwable th7) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException e46) {
                                        Logger.e(LOG_TAG, "copyAssetToFile error !assetFileName:" + str + ",destFileName" + str2 + ",e:" + e46.getMessage());
                                    }
                                    throw th7;
                                }
                            } catch (IOException e47) {
                                Logger.e(LOG_TAG, "copyAssetToFile error !assetFileName:" + str + ",destFileName" + str2 + ",e:" + e47.getMessage());
                                try {
                                    fileOutputStream.close();
                                    throw th;
                                } catch (IOException e48) {
                                    e = e48;
                                    sb5 = new StringBuilder();
                                    sb5.append("copyAssetToFile error !assetFileName:");
                                    sb5.append(str);
                                    sb5.append(",destFileName");
                                    sb5.append(str2);
                                    sb5.append(",e:");
                                    sb5.append(e.getMessage());
                                    Logger.e(LOG_TAG, sb5.toString());
                                    throw th;
                                }
                            }
                        }
                        throw th;
                    }
                } catch (IOException e49) {
                    e = e49;
                }
            } catch (IOException e56) {
                e = e56;
                fileOutputStream = null;
            } catch (Throwable th8) {
                th = th8;
                fileOutputStream = null;
            }
        } catch (Throwable th9) {
            th = th9;
        }
    }

    public static String loadFileAsString(String str) {
        File file = new File(str);
        if (file.exists() && file.isFile()) {
            return loadFileAsString(file);
        }
        Logger.e(LOG_TAG, "can not open file " + str);
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x00ae, code lost:
    
        if (r2 == null) goto L47;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String loadFileAsString(File file) {
        InputStreamReader inputStreamReader;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        r0 = null;
        String str = null;
        if (file == null) {
            return null;
        }
        if (file.exists()) {
            if (file.isDirectory()) {
                Logger.e(LOG_TAG, "File '" + file + "' exists but is a directory");
                return null;
            }
            if (!file.canRead()) {
                Logger.e(LOG_TAG, "File '" + file + "' cannot be read");
                return null;
            }
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
                } catch (Exception unused) {
                    inputStreamReader = null;
                } catch (Throwable th5) {
                    th = th5;
                    inputStreamReader = null;
                }
            } catch (Exception unused2) {
                fileInputStream = null;
                inputStreamReader = null;
            } catch (Throwable th6) {
                th = th6;
                inputStreamReader = null;
            }
            try {
                int length = (int) file.length();
                if (length > 12288) {
                    char[] cArr = new char[4096];
                    StringBuilder sb5 = new StringBuilder(12288);
                    while (true) {
                        int read = inputStreamReader.read(cArr);
                        if (-1 == read) {
                            break;
                        }
                        sb5.append(cArr, 0, read);
                    }
                    str = sb5.toString();
                } else {
                    char[] cArr2 = new char[length];
                    str = new String(cArr2, 0, inputStreamReader.read(cArr2));
                }
                try {
                    fileInputStream.close();
                } catch (Exception unused3) {
                }
            } catch (Exception unused4) {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception unused5) {
                    }
                }
            } catch (Throwable th7) {
                th = th7;
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (Exception unused6) {
                    }
                }
                if (inputStreamReader != null) {
                    try {
                        inputStreamReader.close();
                        throw th;
                    } catch (Exception unused7) {
                        throw th;
                    }
                }
                throw th;
            }
            try {
                inputStreamReader.close();
            } catch (Exception unused8) {
                return str;
            }
        } else {
            Logger.e(LOG_TAG, "File '" + file + "' does not exist");
            return null;
        }
    }
}
