package com.tencent.qphone.base.util;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mobileqq.qwallet.preload.IPreloadResource;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qphone.base.util.exp.QLogItemCircularQueuePool;
import com.tencent.qphone.base.util.log.ILogWriter;
import com.tencent.qphone.base.util.log.QLogWriter;
import com.tencent.qphone.base.util.log.encrypt.XorKey;
import com.tencent.qphone.base.util.log.processor.XOREncryption;
import com.tencent.qphone.base.util.log.utils.FileUtil;
import com.tencent.qphone.base.util.log.wrapper.BufferWriterWrapper;
import com.tencent.qphone.base.util.log.wrapper.MmapLogWrapper;
import com.tenpay.proxy.dlg.location.QbAddrData;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.apache.commons.lang3.time.FastDateFormat;

/* compiled from: P */
/* loaded from: classes22.dex */
public class LogWriterManager {
    private static final long DELETE_EXPIRE_INTERVAL = 3600000;
    private static final int DELETE_LOG_EXPIRE_TIME = 1;
    private static final String DELETE_RECORD_FILE_NAME = "delete_expire_file_record.log";
    private static final int MMAP_BUFFER_SIZE = 8192;
    private static final long ONE_SECOND = 1000;
    public static String QLOG_PARENT_DIRECTORY = "/tencent/msflogs/";
    private static final int SKIP_WRITE_LOG_INTERVAL = 180000;
    private static final String TAG = "LogWriterManager";
    private static final long TWO_SECONDS = 2000;
    private static final int WRITE_MEMORY_INFO_INTERVAL = 180000;
    private ActivityManager activityManager;
    private final String build;
    private final Context context;
    private long currentLogSecond;
    private String deleteRecordFileName;
    private boolean fullEncryptedLogMode;
    private final boolean is64;
    private boolean isEncrypted;
    private long lastDeleteExpireFileTime;
    private long lastTimeSkipWriteLog;
    private long lastTimeWritingMemory;
    private String logPath;
    private final String packageName;
    private final String processName;
    private long timeToCreateLogFile;
    private ILogWriter writer;
    private static final CopyOnWriteArrayList<QLog.ILogCallback> logCallBacks = new CopyOnWriteArrayList<>();
    private static volatile boolean canWrite = true;
    private static final Runnable cacheExceedCallback = new Runnable() { // from class: com.tencent.qphone.base.util.h
        @Override // java.lang.Runnable
        public final void run() {
            LogWriterManager.forceStopWrite();
        }
    };
    public static long sucWriteLogNum = 0;

    @SuppressLint({"SimpleDateFormat"})
    private final SimpleDateFormat logFileFormatter = new SimpleDateFormat("yy.MM.dd.HH");

    @SuppressLint({"SimpleDateFormat"})
    private final FastDateFormat logTimeFormatter = FastDateFormat.getInstance("yy-MM-dd HH:mm:ss.SSS");

    public LogWriterManager(Context context, String str, String str2, String str3, boolean z16) {
        this.context = context;
        this.build = str3;
        this.is64 = z16;
        this.processName = str2;
        this.packageName = str;
        QLogItemCircularQueuePool.setCacheExceedCallback(cacheExceedCallback);
    }

    private File createLogFile() throws IOException {
        boolean z16;
        this.timeToCreateLogFile = System.currentTimeMillis();
        File file = new File(this.logPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        String logFileName = getLogFileName(this.logFileFormatter.format(Long.valueOf(this.timeToCreateLogFile)));
        File file2 = new File(logFileName);
        boolean exists = file2.exists();
        if (!exists) {
            z16 = file2.createNewFile();
        } else {
            z16 = false;
        }
        writePostMessage(logFileName, this.build, exists, z16, this.timeToCreateLogFile);
        return file2;
    }

    private ILogWriter createWriter(File file) throws IOException {
        boolean z16;
        String encryptedKey = XorKey.encryptedKey(XOREncryption.getXorKey());
        boolean z17 = !TextUtils.isEmpty(encryptedKey);
        if (this.fullEncryptedLogMode && z17) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.isEncrypted = z16;
        QLog.d(TAG, 1, "initLog: useNewLog ", Boolean.valueOf(z16), " MSF_IS_COLOR_LEVEL=", Boolean.valueOf(new File(this.logPath + QLog.MSF_IS_COLOR_LEVEL).exists()), " fullEncryptedLogMode=", Boolean.valueOf(this.fullEncryptedLogMode), " DebugVersion=", Boolean.valueOf(QLog.isDebugVersion()), " EncryptedKey=", encryptedKey, " QLog.isColorLevel()=", Boolean.valueOf(QLog.isColorLevel()), " UIN_REPORTLOG_LEVEL=", Integer.valueOf(QLog.getUIN_REPORTLOG_LEVEL()));
        if (this.isEncrypted) {
            return new MmapLogWrapper.Builder().setLogFilePath(file.getAbsolutePath()).setBufferSize(8192).setCompress(true).setEncrypt(true).setBufferFilePath(getLogFileName("mmapCacheLog")).create();
        }
        return new BufferWriterWrapper(new QLogWriter(file, true), 8192);
    }

    private boolean currentLogFileExists() {
        return new File(getLogFileName(this.logFileFormatter.format(Long.valueOf(System.currentTimeMillis())))).exists();
    }

    public static void forceStopWrite() {
        QLog.d(TAG, 1, "forceStopWrite");
        canWrite = false;
    }

    private String getLogFileName(String str) {
        return this.logPath + this.processName.replace(":", "_") + "." + str + ".log";
    }

    private boolean needSkipWrite(long j3) {
        if (j3 - this.lastTimeSkipWriteLog > 180000 && !currentLogFileExists()) {
            return true;
        }
        return false;
    }

    private boolean needWriteMemoryInfo() {
        if (QLog.isColorLevel() && System.currentTimeMillis() - this.lastTimeWritingMemory > 180000) {
            return true;
        }
        return false;
    }

    private long nextHourToCreateLogFile() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(this.timeToCreateLogFile);
        calendar.add(11, 1);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    @Deprecated
    public static void removeLogCallback(QLog.ILogCallback iLogCallback) {
        logCallBacks.remove(iLogCallback);
    }

    @Deprecated
    public static void setLogCallback(QLog.ILogCallback iLogCallback) {
        CopyOnWriteArrayList<QLog.ILogCallback> copyOnWriteArrayList = logCallBacks;
        if (!copyOnWriteArrayList.contains(iLogCallback)) {
            copyOnWriteArrayList.add(iLogCallback);
        }
    }

    private void writeInitMessage() throws IOException {
        String str;
        String format = this.logTimeFormatter.format(this.timeToCreateLogFile);
        ILogWriter iLogWriter = this.writer;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(format);
        sb5.append("|");
        sb5.append(this.processName);
        sb5.append("|D|");
        if (this.is64) {
            str = IPreloadResource.ABI_64;
        } else {
            str = "32";
        }
        sb5.append(str);
        sb5.append("|QQ_Version: ");
        sb5.append(this.build);
        sb5.append("\r\n");
        iLogWriter.write(sb5.toString());
        this.writer.flush();
    }

    private void writeLogItem(BaseQLogItem baseQLogItem, long j3) throws IOException {
        String format = this.logTimeFormatter.format(baseQLogItem.logTime);
        StringBuilder sb5 = new StringBuilder(baseQLogItem.computeStringCapacity());
        sb5.append(format);
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append(j3);
        sb5.append('[');
        sb5.append(Process.myTid());
        sb5.append(']');
        sb5.append((int) baseQLogItem.threadId);
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append((int) baseQLogItem.curJavaThreadId);
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append(QLog.byteLevel2StringLevel(Byte.valueOf(baseQLogItem.androidLogLevel)));
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append(baseQLogItem.tag);
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append(baseQLogItem.f344405msg);
        sb5.append('\n');
        this.writer.write(sb5.toString());
        Iterator<QLog.ILogCallback> it = logCallBacks.iterator();
        while (it.hasNext()) {
            it.next().onWriteLog(baseQLogItem.tag, baseQLogItem.f344405msg);
        }
        Throwable th5 = baseQLogItem.trace;
        if (th5 != null) {
            this.writer.write(Log.getStackTraceString(th5));
            this.writer.write(10);
        }
        sucWriteLogNum++;
        this.writer.flush();
    }

    private void writeMemoryInfo() {
        if (needWriteMemoryInfo()) {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            this.activityManager.getMemoryInfo(memoryInfo);
            QLog.d(TAG, 2, "availMem:" + ((memoryInfo.availMem / 1024) / 1024) + "M lowThreshold:" + ((memoryInfo.threshold / 1024) / 1024) + "M");
            this.lastTimeWritingMemory = System.currentTimeMillis();
        }
    }

    private void writePostMessage(String str, String str2, boolean z16, boolean z17, long j3) throws IOException {
        String str3;
        String str4;
        String format = this.logTimeFormatter.format(j3);
        ILogWriter iLogWriter = this.writer;
        if (iLogWriter != null) {
            iLogWriter.write(format + "|" + this.processName + "|D||QQ_Version: " + str2 + "\r\n");
            StringBuilder sb5 = new StringBuilder();
            sb5.append(format);
            sb5.append("|");
            sb5.append(this.processName);
            if (z16) {
                str3 = "|E|";
            } else {
                str3 = "|D|";
            }
            sb5.append(str3);
            sb5.append(TAG);
            sb5.append("|");
            sb5.append(DeviceInfoMonitor.getModel());
            sb5.append(" ");
            sb5.append(Build.VERSION.RELEASE);
            if (z16) {
                str4 = " newLogFile " + str + " is existed.\n";
            } else {
                str4 = " create newLogFile " + str + " " + z17 + "\n";
            }
            sb5.append(str4);
            this.writer.write(sb5.toString());
            this.writer.flush();
            this.writer.close();
            this.writer = null;
        }
    }

    public void deleteExpireLogFile() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.lastDeleteExpireFileTime < 3600000) {
            return;
        }
        this.lastDeleteExpireFileTime = currentTimeMillis;
        StringBuilder sb5 = new StringBuilder("deleteExpireLogFileActively invoked!\n");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(currentTimeMillis);
        String format = this.logTimeFormatter.format(calendar.getTime());
        sb5.append("time: ");
        sb5.append(format);
        sb5.append("\n");
        File file = new File(this.logPath);
        if (!file.exists()) {
            sb5.append("exit with logDir does not exist!\n");
            FileUtil.writeFile(this.deleteRecordFileName, sb5.toString(), true);
            return;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length != 0) {
            calendar.add(5, -1);
            long timeInMillis = calendar.getTimeInMillis();
            int i3 = 0;
            for (File file2 : listFiles) {
                if (!DELETE_RECORD_FILE_NAME.equals(file2.getName()) && timeInMillis >= file2.lastModified() && file2.delete()) {
                    i3++;
                }
            }
            sb5.append("delete file count: ");
            sb5.append(i3);
            sb5.append("\n");
            FileUtil.writeFile(this.deleteRecordFileName, sb5.toString(), true);
            return;
        }
        sb5.append("exit with logFiles is empty!\n");
        FileUtil.writeFile(this.deleteRecordFileName, sb5.toString(), true);
    }

    public String getDeleteRecordFileName() {
        return this.deleteRecordFileName;
    }

    public SimpleDateFormat getLogFileFormatter() {
        return this.logFileFormatter;
    }

    public String getLogPath() {
        return this.logPath;
    }

    public List<File> getOutOfCurHourLogs() {
        ArrayList arrayList = new ArrayList();
        File file = new File(this.logPath);
        if (!file.exists()) {
            return arrayList;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            String str = this.logFileFormatter.format(Long.valueOf(currentTimeMillis)) + ".log";
            String str2 = this.logFileFormatter.format(Long.valueOf(currentTimeMillis)) + ".qlog";
            for (File file2 : listFiles) {
                if (!DELETE_RECORD_FILE_NAME.equals(file2.getName())) {
                    String absolutePath = file2.getAbsolutePath();
                    if (!absolutePath.endsWith(str) && !absolutePath.endsWith(str2)) {
                        arrayList.add(file2);
                    }
                }
            }
        }
        return arrayList;
    }

    public void initialize() throws IOException {
        this.activityManager = (ActivityManager) this.context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        this.logPath = QLog.getLogExternalPath(this.context) + QLOG_PARENT_DIRECTORY + this.packageName.replace(".", "/") + "/";
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.logPath);
        sb5.append(DELETE_RECORD_FILE_NAME);
        this.deleteRecordFileName = sb5.toString();
        this.writer = createWriter(createLogFile());
        writeInitMessage();
    }

    public boolean isEncrypted() {
        return this.isEncrypted;
    }

    public void setFullEncryptedLogMode(boolean z16) {
        this.fullEncryptedLogMode = z16;
    }

    public boolean writeLogItems(List<QLogItem> list) {
        boolean z16;
        String str;
        boolean z17;
        if (this.writer == null) {
            QLog.d(TAG, 2, "writer is null, need to create new log file and related writer");
            return true;
        }
        writeMemoryInfo();
        long currentTimeMillis = System.currentTimeMillis();
        if (needSkipWrite(currentTimeMillis)) {
            this.lastTimeSkipWriteLog = currentTimeMillis;
            return true;
        }
        try {
            long nextHourToCreateLogFile = nextHourToCreateLogFile();
            boolean z18 = false;
            for (QLogItem qLogItem : list) {
                if (qLogItem.logTime > nextHourToCreateLogFile) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                writeLogItem(qLogItem, currentTimeMillis);
                qLogItem.recycle();
                z18 = z17;
            }
            return z18;
        } catch (Throwable th5) {
            Log.e(TAG, "writeLogToFile Exeption", th5);
            try {
                String message = th5.getMessage();
                if (message != null && !message.contains("ENOSPC")) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                Object[] objArr = new Object[3];
                objArr[0] = "writeLogToFile Exeption, ";
                if (z16) {
                    str = "no space, ";
                } else {
                    str = "";
                }
                objArr[1] = str;
                objArr[2] = th5;
                QLog.e(TAG, 1, objArr);
            } catch (Exception e16) {
                Log.e(TAG, "QLog write log failed. ", e16);
            }
            return true;
        }
    }

    public boolean writeNewQLogItems() {
        boolean z16;
        String str;
        if (this.writer == null) {
            QLog.d(TAG, 2, "writer is null, need to create new log file and related writer");
            return true;
        }
        writeMemoryInfo();
        long currentTimeMillis = System.currentTimeMillis();
        if (needSkipWrite(currentTimeMillis)) {
            this.lastTimeSkipWriteLog = currentTimeMillis;
            return true;
        }
        try {
            long nextHourToCreateLogFile = nextHourToCreateLogFile();
            canWrite = true;
            int i3 = QLogItemCircularQueuePool.getsMaxLogCacheNum();
            int rear = QLogItemCircularQueuePool.getRear();
            boolean z17 = false;
            for (int front = QLogItemCircularQueuePool.getFront(); front != rear && canWrite; front = (front + 1) & (i3 - 1)) {
                BaseQLogItem loc = QLogItemCircularQueuePool.loc(front);
                if (loc != null) {
                    if (loc.logTime > nextHourToCreateLogFile) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    writeLogItem(loc, currentTimeMillis);
                    QLogItemCircularQueuePool.recycleHead();
                }
            }
            if (!QLog.isUseNewQLog() && QLogItemCircularQueuePool.isNoUse()) {
                QLogItemCircularQueuePool.destroy();
            }
            QLog.d(TAG, 2, "writer log success. sumSucNum:" + sucWriteLogNum + ", sumLogNum:" + QLogItemCircularQueuePool.obtainCount);
            return z17;
        } catch (Throwable th5) {
            Log.e(TAG, "writeLogToFile Exeption", th5);
            try {
                String message = th5.getMessage();
                if (message != null && !message.contains("ENOSPC")) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                Object[] objArr = new Object[3];
                objArr[0] = "writeLogToFile Exeption, ";
                if (z16) {
                    str = "no space, ";
                } else {
                    str = "";
                }
                objArr[1] = str;
                objArr[2] = th5;
                QLog.e(TAG, 1, objArr);
            } catch (Exception e16) {
                Log.e(TAG, "QLog write log failed. ", e16);
            }
            return true;
        }
    }
}
