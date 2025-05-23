package com.tencent.midas.comm;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.util.Log;
import com.tencent.midas.comm.log.APLogFileInfo;
import com.tencent.midas.comm.log.processor.APLogEncryptor;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import java.io.File;

/* loaded from: classes9.dex */
public class APLogInfo {
    public static final String LOG_TAG = "MidasComm<Log>";
    public static final int LOG_VERSION_CODE = 45;
    public static final String LOG_VERSION_NAME = "1.3.4";
    private String logCallbackClassName;
    private Context context = null;
    private String logTag = "Midas";
    private boolean logEnable = true;
    private String logPath = "";
    private boolean hasWritePermission = false;
    private String pkgName = "";
    private String processName = "";
    private boolean writeLog = true;
    private boolean printLog = false;
    private boolean compressLog = true;
    private boolean encryptLog = true;
    private boolean autoFlush = true;

    private void initLogPath() {
        String path;
        try {
            Context context = this.context;
            StringBuilder sb5 = new StringBuilder();
            sb5.append(MiniProgramLpReportDC04239.MIDAS_ACTION);
            String str = File.separator;
            sb5.append(str);
            sb5.append("log");
            sb5.append(str);
            File externalFilesDir = context.getExternalFilesDir(sb5.toString());
            if (externalFilesDir == null) {
                path = "";
            } else {
                path = externalFilesDir.getPath();
            }
            this.logPath = path;
        } catch (Throwable th5) {
            Log.w(LOG_TAG, "init log path error: " + th5.getMessage());
            th5.printStackTrace();
        }
    }

    private void initPermission() {
        boolean z16;
        if (this.context.getPackageManager().checkPermission(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE, this.pkgName) == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.hasWritePermission = z16;
        Log.d(LOG_TAG, "has WRITE_EXTERNAL_STORAGE? : " + this.hasWritePermission);
    }

    private void initPkgName() {
        Context context = this.context;
        if (context == null) {
            return;
        }
        try {
            this.pkgName = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), this.context.getApplicationContext().getPackageName(), 0).packageName;
        } catch (Throwable th5) {
            Log.w(LOG_TAG, "getPackage: " + th5.toString());
        }
        Log.w(LOG_TAG, "get pkgName: " + this.pkgName);
    }

    private void initProcessName() {
        try {
            int myPid = Process.myPid();
            ActivityManager activityManager = (ActivityManager) this.context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
            if (activityManager != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : SystemMethodProxy.getRunningAppProcesses(activityManager)) {
                    if (runningAppProcessInfo.pid == myPid) {
                        String[] split = runningAppProcessInfo.processName.split(":");
                        if (split.length > 1) {
                            this.processName = split[1];
                        } else {
                            this.processName = "";
                        }
                    }
                }
            }
        } catch (Throwable th5) {
            Log.w(LOG_TAG, "get process: " + th5.toString());
        }
        Log.w(LOG_TAG, "get process name: " + this.processName);
    }

    private void setPrintLog(boolean z16) {
        this.printLog = z16;
        Log.d(LOG_TAG, "set print log: " + z16);
    }

    private void setWriteLog(boolean z16) {
        this.writeLog = z16;
        Log.d(LOG_TAG, "set write log: " + z16);
    }

    public Context getContext() {
        return this.context;
    }

    public String getLogCallbackClassName() {
        return this.logCallbackClassName;
    }

    public String getLogPath() {
        return this.logPath;
    }

    public String getLogTag() {
        return this.logTag;
    }

    public String getPkgName() {
        return this.pkgName;
    }

    public String getProcessName() {
        return this.processName;
    }

    public void init() {
        if (this.context == null) {
            Log.e(LOG_TAG, "APLogInfo init failed because of null context");
            return;
        }
        initPkgName();
        initLogPath();
        Log.i(LOG_TAG, "Log lib versionName: 1.3.4 versionCode: 45");
    }

    public boolean isAutoFlush() {
        return this.autoFlush;
    }

    public boolean isCompressLog() {
        return this.compressLog;
    }

    public boolean isEncryptLog() {
        return this.encryptLog;
    }

    public boolean isHasWritePermission() {
        return this.hasWritePermission;
    }

    public boolean isLogEnable() {
        return this.logEnable;
    }

    public boolean isPrintLog() {
        return this.printLog;
    }

    public boolean isWriteLog() {
        try {
            long freeSpace = (this.context.getExternalFilesDir(null).getFreeSpace() / 1024) / 1024;
            Log.d(LOG_TAG, "freeSpace: " + freeSpace);
            if (freeSpace < 500) {
                return false;
            }
            return this.writeLog;
        } catch (Throwable unused) {
            return false;
        }
    }

    public void setAutoFlush(boolean z16) {
        this.autoFlush = z16;
    }

    public void setCompressLog(boolean z16) {
        this.compressLog = z16;
        Log.d(LOG_TAG, "set compress log: " + z16);
    }

    public void setContext(Context context) {
        this.context = context.getApplicationContext();
    }

    public void setEncryptKey(String str) {
        APLogEncryptor.setEncryptKey(str);
    }

    public void setEncryptLog(boolean z16) {
        this.encryptLog = z16;
        Log.d(LOG_TAG, "set encrypt log: " + z16);
    }

    public void setEncryptProtocolVersion(byte b16) {
        APLogEncryptor.setProtocolVersion(b16);
    }

    public void setLogCallbackClassName(String str) {
        this.logCallbackClassName = str;
    }

    public void setLogEnable(boolean z16) {
        this.logEnable = z16;
    }

    public void setLogFileKeepDays(int i3) {
        APLogFileUtil.maxLogKeepDays = i3;
        Log.d(LOG_TAG, "set log file keep days: " + i3);
    }

    public void setLogFileNum(int i3) {
        APLogFileUtil.maxLogFileNum = i3;
        Log.d(LOG_TAG, "set log file num: " + i3);
    }

    public void setLogFileSizeMB(int i3) {
        APLogFileUtil.maxLogFileSizeMB = i3;
        Log.d(LOG_TAG, "set log file size: " + i3 + " MB");
    }

    public void setLogParamFromServer(String str) {
        setLogWrite(str);
    }

    public void setLogPath(String str) {
        this.logPath = str;
    }

    public void setLogTag(String str) {
        this.logTag = str;
    }

    public void setLogWrite(String str) {
        int i3;
        boolean z16;
        try {
            i3 = Integer.valueOf(str).intValue();
        } catch (Throwable th5) {
            th5.printStackTrace();
            i3 = 3;
        }
        boolean z17 = false;
        if ((i3 & 1) == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        setPrintLog(z16);
        if ((i3 & 2) == 2) {
            z17 = true;
        }
        setWriteLog(z17);
    }

    public boolean shouldPrintLog() {
        if (!this.logEnable && !this.printLog && !APLogFileUtil.isDebugMode(APLogFileInfo.dirName)) {
            return false;
        }
        return true;
    }
}
