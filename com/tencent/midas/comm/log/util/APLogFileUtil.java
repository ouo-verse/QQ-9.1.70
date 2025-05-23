package com.tencent.midas.comm.log.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Log;
import com.heytap.databaseengine.utils.DateUtil;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.midas.comm.APLogInfo;
import com.tencent.midas.data.APPluginDataInterface;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes9.dex */
public class APLogFileUtil {
    private static final String DEBUG_CONF = "MidasLogDebug.ini";
    private static final int DEFAULT_MAX_LOG_FILE_NUM = 2;
    private static final int DEFAULT_MAX_LOG_FILE_SIZE_MB = 1;
    private static final int DEFAULT_MAX_LOG_KEEP_DAYS = 15;
    public static final String SEPARATOR_LINE = "\r\n";
    public static final String SEPARATOR_LOG = " | ";
    private static int maxDirSizeMB = (15 * 2) * 1;
    public static int maxLogFileNum = 2;
    public static int maxLogFileSizeMB = 1;
    public static int maxLogKeepDays = 15;
    public static int minSDCardSpace = 20;

    public static void deleteFileUpMaxInDir(String str, long j3, long j16, int i3) {
        boolean z16;
        try {
            File file = new File(str);
            if (file.exists() && !file.isFile()) {
                double d16 = j16;
                if (getFileOrFilesSize(str) >= d16) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length != 0) {
                    long currentTimeMillis = System.currentTimeMillis();
                    for (File file2 : listFiles) {
                        long lastModified = file2.lastModified();
                        if (!file2.getName().equals("MidasLog.mmap") && file2.isFile() && (z16 || currentTimeMillis - lastModified > i3 * 24 * 3600 * 1000 || (getFileSize(file2) / 1024) / 1024 >= j3)) {
                            file2.delete();
                        }
                    }
                }
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    public static void deleteOldFileToday(String str) {
        deleteOldFileToday(str, maxLogFileNum);
    }

    private static int getConfValue(SharedPreferences sharedPreferences, String str, int i3) {
        String string = sharedPreferences.getString(str, null);
        if (!TextUtils.isEmpty(string)) {
            try {
                Log.e(APLogInfo.LOG_TAG, String.format(Locale.CHINA, "Read log conf[%s]: %s", str, string));
                int parseInt = Integer.parseInt(string);
                if (parseInt > 0) {
                    return parseInt;
                }
                return i3;
            } catch (Throwable th5) {
                Log.e(APLogInfo.LOG_TAG, String.format(Locale.CHINA, "Read log conf[%s] error: %s", str, th5.getMessage()));
                return i3;
            }
        }
        return i3;
    }

    public static double getFileOrFilesSize(String str) {
        long j3;
        File file = new File(str);
        try {
            if (file.isDirectory()) {
                j3 = getFileSizes(file);
            } else {
                j3 = getFileSize(file);
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
            j3 = 0;
        }
        return (j3 / 1024) / 1024;
    }

    private static long getFileSize(File file) {
        long j3 = 0;
        try {
            if (file.exists()) {
                FileInputStream fileInputStream = new FileInputStream(file);
                j3 = fileInputStream.available();
                fileInputStream.close();
            } else {
                file.createNewFile();
            }
        } catch (Throwable unused) {
        }
        return j3;
    }

    private static long getFileSizes(File file) {
        long fileSize;
        File[] listFiles = file.listFiles();
        long j3 = 0;
        for (int i3 = 0; i3 < listFiles.length; i3++) {
            if (listFiles[i3].isDirectory()) {
                fileSize = getFileSizes(listFiles[i3]);
            } else {
                fileSize = getFileSize(listFiles[i3]);
            }
            j3 += fileSize;
        }
        return j3;
    }

    public static String getLastLogFileName(String str) {
        ArrayList<File> logFiles = getLogFiles(str, getToday());
        if (logFiles.size() > 0) {
            return logFiles.get(logFiles.size() - 1).getName();
        }
        return "";
    }

    public static ArrayList<File> getLogFiles(String str, final String str2) {
        File file = new File(str);
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles(new FilenameFilter() { // from class: com.tencent.midas.comm.log.util.APLogFileUtil.1
                @Override // java.io.FilenameFilter
                public boolean accept(File file2, String str3) {
                    return str3.startsWith(str2);
                }
            });
            Arrays.sort(listFiles, new Comparator<File>() { // from class: com.tencent.midas.comm.log.util.APLogFileUtil.2
                private int extractNumber(String str3) {
                    try {
                        return Integer.parseInt(str3.substring(str3.indexOf(95) + 1, str3.lastIndexOf(46)));
                    } catch (Throwable unused) {
                        return 0;
                    }
                }

                @Override // java.util.Comparator
                public int compare(File file2, File file3) {
                    return extractNumber(file2.getName()) - extractNumber(file3.getName());
                }
            });
            return new ArrayList<>(Arrays.asList(listFiles));
        }
        return new ArrayList<>();
    }

    public static double getSDCardSpace() {
        long j3;
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            j3 = ((statFs.getAvailableBlocks() * statFs.getBlockSize()) / 1024) / 1024;
        } catch (Throwable th5) {
            Log.i(APLogInfo.LOG_TAG, "getSDCardSpace: " + th5.toString());
            j3 = 0;
        }
        return j3;
    }

    public static String getToday() {
        return new SimpleDateFormat(DateUtil.DATE_FORMAT_8, Locale.CHINA).format(new Date(System.currentTimeMillis()));
    }

    public static boolean initLogDir(String str) {
        try {
            File file = new File(str);
            if (!file.exists()) {
                boolean mkdirs = file.mkdirs();
                Log.i(APLogInfo.LOG_TAG, "create log dir result: " + mkdirs);
                return mkdirs;
            }
            deleteFileUpMaxInDir(str, maxLogFileSizeMB, maxDirSizeMB, maxLogKeepDays);
            deleteOldFileToday(str, maxLogFileNum);
            return true;
        } catch (Throwable th5) {
            Log.e(APLogInfo.LOG_TAG, "init log dir error: " + th5.toString());
            return false;
        }
    }

    public static boolean isDebugMode(String str) {
        return new File(str + DEBUG_CONF).exists();
    }

    public static void readLogKeepConf(Context context) {
        int i3 = maxLogFileSizeMB;
        if (i3 <= 0) {
            i3 = 1;
        }
        maxLogFileSizeMB = i3;
        int i16 = maxLogFileNum;
        if (i16 <= 0) {
            i16 = 2;
        }
        maxLogFileNum = i16;
        int i17 = maxLogKeepDays;
        if (i17 <= 0) {
            i17 = 15;
        }
        maxLogKeepDays = i17;
        maxDirSizeMB = i3 * i16 * i17;
        Log.d(APLogInfo.LOG_TAG, String.format(Locale.CHINA, "current config: max log size: %d MB, max log num: %d, max keep %d DAYS", Integer.valueOf(maxLogFileSizeMB), Integer.valueOf(maxLogFileNum), Integer.valueOf(maxLogKeepDays)));
        SharedPreferences sharedPreferences = context.getSharedPreferences(APPluginDataInterface.SHARE_PREFERENCE_NAME, 4);
        maxLogFileSizeMB = getConfValue(sharedPreferences, "size", maxLogFileSizeMB);
        maxLogFileNum = getConfValue(sharedPreferences, WidgetCacheConstellationData.NUM, maxLogFileNum);
        int confValue = getConfValue(sharedPreferences, "log_keep_time", maxLogKeepDays);
        maxLogKeepDays = confValue;
        maxDirSizeMB = maxLogFileSizeMB * maxLogFileNum * confValue;
        Log.d(APLogInfo.LOG_TAG, String.format(Locale.CHINA, "final config: max log size: %d MB, max log num: %d, max keep %d DAYS", Integer.valueOf(maxLogFileSizeMB), Integer.valueOf(maxLogFileNum), Integer.valueOf(maxLogKeepDays)));
    }

    public static void deleteOldFileToday(String str, int i3) {
        ArrayList<File> logFiles = getLogFiles(str, getToday() + "_");
        int size = logFiles.size();
        if (size < i3 || i3 <= 0) {
            return;
        }
        for (int i16 = 0; i16 < size; i16++) {
            File file = logFiles.get(i16);
            if (file != null) {
                Log.w(APLogInfo.LOG_TAG, "get: " + file.getName());
                if (i16 < size - i3) {
                    Log.w(APLogInfo.LOG_TAG, "delete: " + file.getName());
                    file.delete();
                }
            }
        }
    }
}
