package com.tencent.bugly.matrix.backtrace;

import android.content.Context;
import android.os.CancellationSignal;
import com.nostra13.universalimageloader.utils.IoUtils;
import com.tencent.bugly.matrix.backtrace.WeChatBacktrace;
import com.tencent.bugly.matrix.util.MatrixLog;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes5.dex */
public class WarmUpUtility {
    private static final String DIR_WECHAT_BACKTRACE = "wechat-backtrace";
    static final long DURATION_CLEAN_UP = 172800000;
    static final long DURATION_CLEAN_UP_EXPIRED = 172800000;
    static final long DURATION_DISK_USAGE_COMPUTATION = 259200000;
    static final long DURATION_LAST_ACCESS_EXPIRED = 259200000;
    static final long DURATION_LAST_ACCESS_FAR_FUTURE = 604800000;
    private static final String FILE_BLOCKED_LIST = "blocked-list";
    private static final String FILE_CLEAN_UP_TIMESTAMP = "clean-up.timestamp";
    private static final String FILE_DEFAULT_SAVING_PATH = "saving-cache";
    private static final String FILE_DISK_USAGE = "disk-usage.timestamp";
    private static final String FILE_UNFINISHED = "unfinished";
    private static final String FILE_WARMED_UP = "warmed-up";
    private static final String TAG = "Matrix.Backtrace.WarmUp";
    static final String UNFINISHED_KEY_SPLIT = ":";
    static final String UNFINISHED_RETRY_SPLIT = "|";
    static final int WARM_UP_FILE_MAX_RETRY = 3;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class UnfinishedManagement {
        private static Map<String, Integer> mUnfinishedWarmUp;

        UnfinishedManagement() {
        }

        public static boolean check(Context context, String str, int i3) {
            if (retryCount(context, WarmUpUtility.unfinishedKey(str, i3)) >= 3) {
                return false;
            }
            return true;
        }

        public static boolean checkAndMark(Context context, String str, int i3) {
            String unfinishedKey = WarmUpUtility.unfinishedKey(str, i3);
            int retryCount = retryCount(context, unfinishedKey);
            if (retryCount >= 3) {
                return false;
            }
            mUnfinishedWarmUp.put(unfinishedKey, Integer.valueOf(retryCount + 1));
            WarmUpUtility.flushUnfinishedMaps(context, mUnfinishedWarmUp);
            return true;
        }

        public static void result(Context context, String str, int i3, boolean z16) {
            String unfinishedKey = WarmUpUtility.unfinishedKey(str, i3);
            int retryCount = retryCount(context, unfinishedKey);
            if (z16) {
                mUnfinishedWarmUp.remove(unfinishedKey);
            } else {
                mUnfinishedWarmUp.put(unfinishedKey, Integer.valueOf(retryCount + 1));
            }
            WarmUpUtility.flushUnfinishedMaps(context, mUnfinishedWarmUp);
        }

        private static int retryCount(Context context, String str) {
            if (mUnfinishedWarmUp == null) {
                mUnfinishedWarmUp = WarmUpUtility.readUnfinishedMaps(context);
            }
            Integer num = mUnfinishedWarmUp.get(str);
            if (num != null) {
                return num.intValue();
            }
            return 0;
        }
    }

    WarmUpUtility() {
    }

    static File cleanUpTimestampFile(Context context) {
        File file = new File(context.getFilesDir().getAbsolutePath() + "/" + DIR_WECHAT_BACKTRACE + "/" + FILE_CLEAN_UP_TIMESTAMP);
        file.getParentFile().mkdirs();
        return file;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String defaultSavingPath(WeChatBacktrace.Configuration configuration) {
        return configuration.mContext.getFilesDir().getAbsolutePath() + "/" + DIR_WECHAT_BACKTRACE + "/" + FILE_DEFAULT_SAVING_PATH + "/";
    }

    static File diskUsageFile(Context context) {
        File file = new File(context.getFilesDir().getAbsolutePath() + "/" + DIR_WECHAT_BACKTRACE + "/" + FILE_DISK_USAGE);
        file.getParentFile().mkdirs();
        return file;
    }

    static void flushUnfinishedMaps(Context context, Map<String, Integer> map) {
        File unfinishedFile = unfinishedFile(context);
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            stringBuffer.append(entry.getKey() + "|" + entry.getValue() + "\n");
        }
        writeContentToFile(unfinishedFile, stringBuffer.toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean hasWarmedUp(Context context) {
        return warmUpMarkedFile(context).exists();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void iterateTargetDirectory(File file, CancellationSignal cancellationSignal, FileFilter fileFilter) {
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    iterateTargetDirectory(file2, cancellationSignal, fileFilter);
                    cancellationSignal.throwIfCanceled();
                }
                return;
            }
            return;
        }
        fileFilter.accept(file);
        cancellationSignal.throwIfCanceled();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void markCleanUpTimestamp(Context context) {
        File cleanUpTimestampFile = cleanUpTimestampFile(context);
        try {
            cleanUpTimestampFile.createNewFile();
            cleanUpTimestampFile.setLastModified(System.currentTimeMillis());
        } catch (IOException e16) {
            MatrixLog.printErrStackTrace(TAG, e16, "", new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void markComputeDiskUsageTimestamp(Context context) {
        File diskUsageFile = diskUsageFile(context);
        try {
            diskUsageFile.createNewFile();
            diskUsageFile.setLastModified(System.currentTimeMillis());
        } catch (IOException e16) {
            MatrixLog.printErrStackTrace(TAG, e16, "", new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean needCleanUp(Context context) {
        File cleanUpTimestampFile = cleanUpTimestampFile(context);
        if (!cleanUpTimestampFile.exists()) {
            try {
                cleanUpTimestampFile.createNewFile();
            } catch (IOException e16) {
                MatrixLog.printErrStackTrace(TAG, e16, "", new Object[0]);
            }
            return false;
        }
        if (System.currentTimeMillis() - cleanUpTimestampFile.lastModified() < 172800000) {
            return false;
        }
        return true;
    }

    static boolean pathValidation(WeChatBacktrace.Configuration configuration) {
        if (configuration.mSavingPath == null) {
            return false;
        }
        try {
        } catch (IOException e16) {
            MatrixLog.printErrStackTrace(TAG, e16, "", new Object[0]);
        }
        if (new File(configuration.mSavingPath).getCanonicalPath().startsWith(configuration.mContext.getFilesDir().getParentFile().getCanonicalFile().getAbsolutePath())) {
            return true;
        }
        MatrixLog.e(TAG, "Saving path should under private storage path %s", configuration.mContext.getFilesDir().getParentFile().getAbsolutePath());
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002f, code lost:
    
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0030, code lost:
    
        com.tencent.bugly.matrix.util.MatrixLog.printErrStackTrace(com.tencent.bugly.matrix.backtrace.WarmUpUtility.TAG, r8, "", new java.lang.Object[0]);
     */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0061 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String readFileContent(File file, int i3) {
        FileReader fileReader;
        StringBuilder sb5;
        FileReader fileReader2 = null;
        if (file.isFile()) {
            try {
                sb5 = new StringBuilder(4096);
                fileReader = new FileReader(file);
            } catch (Exception e16) {
                e = e16;
                fileReader = null;
            } catch (Throwable th5) {
                th = th5;
                if (fileReader2 != null) {
                }
                throw th;
            }
            try {
                try {
                    char[] cArr = new char[1024];
                    int i16 = 0;
                    do {
                        int read = fileReader.read(cArr);
                        if (read > 0) {
                            sb5.append(cArr, 0, read);
                            i16 += read;
                        } else {
                            String sb6 = sb5.toString();
                            try {
                                fileReader.close();
                            } catch (IOException e17) {
                                MatrixLog.printErrStackTrace(TAG, e17, "", new Object[0]);
                            }
                            return sb6;
                        }
                    } while (i16 <= i3);
                    fileReader.close();
                    return null;
                } catch (Throwable th6) {
                    th = th6;
                    fileReader2 = fileReader;
                    if (fileReader2 != null) {
                        try {
                            fileReader2.close();
                        } catch (IOException e18) {
                            MatrixLog.printErrStackTrace(TAG, e18, "", new Object[0]);
                        }
                    }
                    throw th;
                }
            } catch (Exception e19) {
                e = e19;
                MatrixLog.printErrStackTrace(TAG, e, "", new Object[0]);
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (IOException e26) {
                        MatrixLog.printErrStackTrace(TAG, e26, "", new Object[0]);
                    }
                }
                return null;
            }
        }
        return null;
    }

    static Map<String, Integer> readUnfinishedMaps(Context context) {
        HashMap hashMap = new HashMap();
        File unfinishedFile = unfinishedFile(context);
        String readFileContent = readFileContent(unfinishedFile, IoUtils.DEFAULT_IMAGE_TOTAL_SIZE);
        if (readFileContent == null) {
            MatrixLog.w(TAG, "Read unfinished maps file failed, file size %s", Long.valueOf(unfinishedFile.length()));
            if (unfinishedFile.length() > 512000) {
                unfinishedFile.delete();
            }
        } else {
            for (String str : readFileContent.split("\n")) {
                int lastIndexOf = str.lastIndexOf("|");
                if (lastIndexOf >= 0) {
                    try {
                        hashMap.put(str.substring(0, lastIndexOf), Integer.valueOf(Integer.parseInt(str.substring(lastIndexOf + 1))));
                    } catch (Throwable th5) {
                        MatrixLog.printErrStackTrace(TAG, th5, "", new Object[0]);
                    }
                }
            }
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean shouldComputeDiskUsage(Context context) {
        File diskUsageFile = diskUsageFile(context);
        if (!diskUsageFile.exists()) {
            try {
                diskUsageFile.createNewFile();
            } catch (IOException e16) {
                MatrixLog.printErrStackTrace(TAG, e16, "", new Object[0]);
            }
            return false;
        }
        if (System.currentTimeMillis() - diskUsageFile.lastModified() < 259200000) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static File unfinishedFile(Context context) {
        File file = new File(context.getFilesDir().getAbsolutePath() + "/" + DIR_WECHAT_BACKTRACE + "/" + FILE_UNFINISHED);
        file.getParentFile().mkdirs();
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e16) {
                MatrixLog.printErrStackTrace(TAG, e16, "", new Object[0]);
            }
        }
        return file;
    }

    static String unfinishedKey(String str, int i3) {
        return str + ":" + i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String validateSavingPath(WeChatBacktrace.Configuration configuration) {
        if (pathValidation(configuration)) {
            return configuration.mSavingPath;
        }
        return defaultSavingPath(configuration);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static File warmUpMarkedFile(Context context) {
        File file = new File(context.getFilesDir().getAbsolutePath() + "/" + DIR_WECHAT_BACKTRACE + "/" + FILE_WARMED_UP);
        file.getParentFile().mkdirs();
        return file;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean writeContentToFile(File file, String str) {
        if (file.isFile()) {
            FileWriter fileWriter = null;
            try {
                try {
                    FileWriter fileWriter2 = new FileWriter(file);
                    try {
                        fileWriter2.write(str);
                        try {
                            fileWriter2.close();
                            return true;
                        } catch (IOException e16) {
                            MatrixLog.printErrStackTrace(TAG, e16, "", new Object[0]);
                            return true;
                        }
                    } catch (Exception e17) {
                        e = e17;
                        fileWriter = fileWriter2;
                        MatrixLog.printErrStackTrace(TAG, e, "", new Object[0]);
                        if (fileWriter != null) {
                            try {
                                fileWriter.close();
                            } catch (IOException e18) {
                                MatrixLog.printErrStackTrace(TAG, e18, "", new Object[0]);
                            }
                        }
                        return false;
                    } catch (Throwable th5) {
                        th = th5;
                        fileWriter = fileWriter2;
                        if (fileWriter != null) {
                            try {
                                fileWriter.close();
                            } catch (IOException e19) {
                                MatrixLog.printErrStackTrace(TAG, e19, "", new Object[0]);
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                }
            } catch (Exception e26) {
                e = e26;
            }
        }
        return false;
    }
}
