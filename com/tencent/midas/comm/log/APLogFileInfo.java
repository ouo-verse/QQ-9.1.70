package com.tencent.midas.comm.log;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.comm.APLogInfo;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import java.io.File;

/* loaded from: classes9.dex */
public class APLogFileInfo {
    public static String dirName = "";
    public static String fileName = "";
    public static String mmapName = "";

    private static String buildDirName() {
        APLogInfo logInfo = APLog.getLogInfo();
        if (logInfo != null && logInfo.getLogPath() != null) {
            String logPath = logInfo.getLogPath();
            String str = File.separator;
            if (!logPath.endsWith(str)) {
                logPath = logPath + str;
            }
            String str2 = logPath + logInfo.getPkgName() + str;
            if (!TextUtils.isEmpty(logInfo.getProcessName())) {
                return str2 + logInfo.getProcessName() + str;
            }
            return str2;
        }
        Log.e(APLogInfo.LOG_TAG, "log info is null");
        return "";
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0071 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0075  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String buildFileName(boolean z16) {
        StringBuffer stringBuffer = null;
        try {
            if (!TextUtils.isEmpty(dirName)) {
                StringBuffer stringBuffer2 = new StringBuffer(dirName);
                try {
                    String str = dirName;
                    String str2 = File.separator;
                    if (!str.endsWith(str2)) {
                        stringBuffer2.append(str2);
                    }
                    String lastLogFileName = APLogFileUtil.getLastLogFileName(dirName);
                    if (z16 && !TextUtils.isEmpty(lastLogFileName)) {
                        stringBuffer2.append(lastLogFileName);
                        return stringBuffer2.toString();
                    }
                    stringBuffer2.append(APLogFileUtil.getToday());
                    stringBuffer2.append("_");
                    stringBuffer2.append(buildFileNumber(lastLogFileName));
                    stringBuffer2.append(".txt");
                    stringBuffer = stringBuffer2;
                } catch (Throwable th5) {
                    th = th5;
                    stringBuffer = stringBuffer2;
                    Log.i(APLogInfo.LOG_TAG, "create log file name error:" + th.toString());
                    if (stringBuffer != null) {
                    }
                }
            }
        } catch (Throwable th6) {
            th = th6;
        }
        if (stringBuffer != null) {
            return "";
        }
        return stringBuffer.toString();
    }

    private static int buildFileNumber(String str) {
        if (TextUtils.isEmpty(str)) {
            return 1;
        }
        try {
            String[] split = str.split(APLogFileUtil.getToday() + "_");
            if (split.length <= 1) {
                return 1;
            }
            return Integer.parseInt(split[1].split(".txt")[0]) + 1;
        } catch (Throwable th5) {
            th5.printStackTrace();
            Log.e(APLogInfo.LOG_TAG, "build file number error: " + th5.getMessage());
            return 1;
        }
    }

    private static String buildMmapName() {
        return dirName + File.separator + "MidasLog.mmap";
    }

    public static void create() {
        try {
            dirName = buildDirName();
            fileName = buildFileName(true);
            mmapName = buildMmapName();
            Log.d(APLogInfo.LOG_TAG, "log dir: " + dirName);
            Log.d(APLogInfo.LOG_TAG, "log file: " + fileName);
        } catch (Throwable th5) {
            Log.e(APLogInfo.LOG_TAG, "file info create error: " + th5.toString());
        }
    }

    public static void updateFileName() {
        fileName = buildFileName(false);
        Log.d(APLogInfo.LOG_TAG, "update file name: " + fileName);
    }
}
