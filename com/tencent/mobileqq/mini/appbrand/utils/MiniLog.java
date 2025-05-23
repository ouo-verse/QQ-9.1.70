package com.tencent.mobileqq.mini.appbrand.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import android.util.LruCache;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.commonsdk.pool.RecyclablePool;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.utils.MiniAppGlobal;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.proxy.dlg.location.QbAddrData;
import java.io.BufferedWriter;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniLog {
    public static final int CLR = 2;
    public static final int DEV = 4;
    public static final int MAX_MINI_LOG_NUM = 5;
    public static final String MINI_LOG_TAG = "log";
    private static final int RECYCLE_CAPACITY = 512;
    private static final String TAG = "MiniLog";
    public static final int USR = 1;
    private static final int WRITE_MINI_LOG_MSG = 2;
    private static final int WRITE_NATIVE_LOG_MSG = 1;
    private static long currentLogSecond = 0;
    private static String logTime = "";
    private static volatile WriteHandler mWriteHandler;
    private static RecyclablePool sPool;
    private static StringBuilder sBuilder = new StringBuilder(10240);
    private static final int myProcessId = Process.myPid();
    private static String processName = "";
    private static QLogItem sHead = null;
    private static QLogItem sTail = null;
    private static String packageName = "";
    private static String sBuildNumber = "";
    private static HashMap<String, Boolean> debugControlMap = new HashMap<>();
    private static Map<String, BufferedWriter> nativeFlushMap = new HashMap();
    private static SimpleDateFormat logFileFormatter = new SimpleDateFormat("yy.MM.dd.HH");
    private static SimpleDateFormat timeFormatter = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
    private static Map<String, BufferedWriter> miniFlushMap = new HashMap();
    private static LinkedBlockingQueue<MiniItem> miniQueue = new LinkedBlockingQueue<>(256);
    private static LruCache<String, Integer> mLastNumCache = new LruCache<>(5);
    private static long lastCheckLogSizeTime = 0;
    private static long MAX_MINI_LOG_SIZE = 1048576;

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class MiniItem {
        public String filePath;

        /* renamed from: msg, reason: collision with root package name */
        public String f246326msg;
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class QLogItem extends RecyclablePool.Recyclable {
        public String appId;
        public int level;
        public long logTime;

        /* renamed from: msg, reason: collision with root package name */
        public String f246327msg;
        public String tag;
        public int threadId;
        public Throwable trace;

        @Override // com.tencent.commonsdk.pool.RecyclablePool.Recyclable
        public void recycle() {
            super.recycle();
            this.logTime = 0L;
            this.threadId = 0;
            this.level = 0;
            this.tag = "";
            this.f246327msg = "";
            this.trace = null;
            this.appId = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class WriteHandler extends Handler {
        WriteHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i3 = message.what;
            if (i3 == 1) {
                if (MiniLog.sHead == null || MiniLog.sPool == null) {
                    return;
                }
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mini.appbrand.utils.MiniLog.WriteHandler.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MiniLog.writeNativeLogToFile();
                    }
                }, 64, null, false);
                return;
            }
            if (i3 == 2 && !MiniLog.miniQueue.isEmpty()) {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mini.appbrand.utils.MiniLog.WriteHandler.2
                    @Override // java.lang.Runnable
                    public void run() {
                        MiniLog.writeMiniLogToFile();
                    }
                }, 64, null, false);
            }
        }
    }

    private static void addMiniLogItem(String str, String str2) {
        MiniItem miniItem = new MiniItem();
        miniItem.f246326msg = str2;
        miniItem.filePath = str;
        initWriteHandler();
        if (miniQueue.offer(miniItem)) {
            mWriteHandler.removeMessages(2);
            mWriteHandler.sendEmptyMessageDelayed(2, 1000L);
        }
    }

    private static void addNativeLogItem(String str, String str2, int i3, String str3, Throwable th5) {
        QLogItem qLogItem;
        if (sPool == null || StringUtil.isEmpty(str) || (qLogItem = (QLogItem) sPool.obtain(QLogItem.class)) == null) {
            return;
        }
        qLogItem.logTime = System.currentTimeMillis();
        qLogItem.threadId = Process.myTid();
        qLogItem.level = i3;
        qLogItem.tag = str2;
        qLogItem.f246327msg = str3;
        qLogItem.trace = th5;
        qLogItem.appId = str;
        synchronized (processName) {
            if (sHead == null) {
                sHead = qLogItem;
                sTail = qLogItem;
            } else {
                sTail.changeNext(qLogItem, true);
                sTail = qLogItem;
            }
        }
        initWriteHandler();
        mWriteHandler.removeMessages(1);
        mWriteHandler.sendEmptyMessageDelayed(1, 1000L);
    }

    private static String getLogFileName(String str) {
        return processName.replace(":", "_") + "." + str + ".log";
    }

    public static String getMiniLogFolderPath(String str) {
        return MiniAppGlobal.getMiniCacheFilePath() + MD5.toMD5(str) + "/" + BaseApplicationImpl.getApplication().getRuntime().getAccount() + "/miniprogramLog/";
    }

    private static String getMiniLogPath(String str) {
        String miniLogFolderPath = getMiniLogFolderPath(str);
        Integer num = mLastNumCache.get(str);
        File file = new File(miniLogFolderPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        if (num == null) {
            num = 1;
            try {
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length > 0) {
                    for (File file2 : listFiles) {
                        String name = file2.getName();
                        if (name.contains("log")) {
                            String substring = name.substring(name.lastIndexOf("log") + 1);
                            if (isInteger(substring) && Integer.valueOf(substring).intValue() > num.intValue()) {
                                num = Integer.valueOf(substring);
                            }
                        }
                    }
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, str, e16);
                }
            }
        }
        if (System.currentTimeMillis() - lastCheckLogSizeTime > 60000) {
            lastCheckLogSizeTime = System.currentTimeMillis();
            try {
                if (com.tencent.mobileqq.utils.FileUtils.createFile(miniLogFolderPath + "log" + num).length() > MAX_MINI_LOG_SIZE) {
                    if (num.intValue() < 5) {
                        num = Integer.valueOf(num.intValue() + 1);
                    } else {
                        new File(miniLogFolderPath + "log1").delete();
                        num = 1;
                        for (int i3 = 2; i3 <= 5; i3++) {
                            File file3 = new File(miniLogFolderPath + "log" + i3);
                            if (file3.exists()) {
                                if (QLog.isColorLevel()) {
                                    QLog.i(TAG, 2, "rename from file:log" + i3 + " to file:" + num);
                                }
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append(miniLogFolderPath);
                                sb5.append("log");
                                Integer valueOf = Integer.valueOf(num.intValue() + 1);
                                try {
                                    sb5.append(num);
                                    file3.renameTo(new File(sb5.toString()));
                                    num = valueOf;
                                } catch (Exception e17) {
                                    e = e17;
                                    num = valueOf;
                                    e.printStackTrace();
                                    mLastNumCache.put(str, num);
                                    return miniLogFolderPath + "log" + num;
                                }
                            }
                        }
                    }
                }
            } catch (Exception e18) {
                e = e18;
            }
        }
        mLastNumCache.put(str, num);
        return miniLogFolderPath + "log" + num;
    }

    public static String getStackTraceString(Throwable th5) {
        return QLog.getStackTraceString(th5);
    }

    public static void i(String str, int i3, String str2, String str3) {
        i(str, i3, str2, str3, (Throwable) null);
    }

    public static void init() {
        if (sPool == null && BaseApplicationImpl.getApplication() != null) {
            sBuildNumber = AppSetting.d();
            processName = BaseApplicationImpl.getApplication().getQQProcessName();
            packageName = BaseApplicationImpl.getApplication().getPackageName();
            sPool = new RecyclablePool(QLogItem.class, 512);
        }
        MiniLogManager.init();
    }

    private static void initWriteHandler() {
        if (mWriteHandler == null) {
            synchronized (MiniLog.class) {
                if (mWriteHandler == null) {
                    mWriteHandler = new WriteHandler(ThreadManagerV2.getSubThreadLooper());
                }
            }
        }
    }

    public static boolean isColorLevel(String str) {
        return isEnableDebug(str).booleanValue() || QLog.isColorLevel();
    }

    public static boolean isDevelopLevel(String str) {
        return isEnableDebug(str).booleanValue() || QLog.isDevelopLevel();
    }

    public static Boolean isEnableDebug(String str) {
        return Boolean.valueOf(debugControlMap.get(str) != null && debugControlMap.get(str).booleanValue());
    }

    private static boolean isInteger(String str) {
        return Pattern.compile("^[-\\+]?[\\d]*$").matcher(str).matches();
    }

    private static void miniFlushAndClean() {
        for (BufferedWriter bufferedWriter : miniFlushMap.values()) {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.flush();
                    bufferedWriter.close();
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
        }
        miniFlushMap.clear();
    }

    private static void nativeFlushAndClean() {
        for (BufferedWriter bufferedWriter : nativeFlushMap.values()) {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.flush();
                    bufferedWriter.close();
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
        }
        nativeFlushMap.clear();
    }

    public static void p(String str, String str2) {
        QLog.p(str, str2);
    }

    public static void setEnableDebug(String str, boolean z16) {
        debugControlMap.put(str, Boolean.valueOf(z16));
    }

    public static void w(String str, int i3, String str2, String str3) {
        w(str, i3, str2, str3, (Throwable) null);
    }

    public static void writeMiniLog(String str, String str2) {
        addMiniLogItem(getMiniLogPath(str), str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void writeMiniLogToFile() {
        BufferedWriter bufferedWriter;
        synchronized (MiniLog.class) {
            while (!miniQueue.isEmpty()) {
                try {
                    MiniItem poll = miniQueue.poll();
                    if (poll != null && !StringUtil.isEmpty(poll.filePath)) {
                        String str = poll.filePath;
                        File file = new File(str);
                        if (!file.exists()) {
                            com.tencent.mobileqq.utils.FileUtils.createFile(str);
                            bufferedWriter = new BufferedWriter(new MiniLogWriter(file, true), 8192);
                        } else {
                            bufferedWriter = miniFlushMap.get(str);
                            if (bufferedWriter == null) {
                                bufferedWriter = new BufferedWriter(new MiniLogWriter(file, true), 8192);
                            }
                        }
                        bufferedWriter.write(poll.f246326msg);
                        miniFlushMap.put(str, bufferedWriter);
                    }
                } finally {
                    try {
                    } finally {
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void writeNativeLogToFile() {
        QLogItem qLogItem;
        QLogItem qLogItem2;
        BufferedWriter bufferedWriter;
        synchronized (MiniLog.class) {
            try {
                synchronized (processName) {
                    qLogItem = sTail;
                    qLogItem2 = sHead;
                    sTail = null;
                    sHead = null;
                }
            } finally {
                try {
                } finally {
                }
            }
            if (qLogItem2 == null) {
                return;
            }
            while (true) {
                long j3 = qLogItem2.logTime;
                long j16 = currentLogSecond;
                if (j3 >= j16 + 1000 || j3 < j16) {
                    logTime = timeFormatter.format(Long.valueOf(j3));
                    long j17 = currentLogSecond;
                    if (j3 >= j17 + 1000 && j3 < 2000 + j17) {
                        currentLogSecond = j17 + 1000;
                    } else {
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTimeInMillis(j3);
                        calendar.set(14, 0);
                        currentLogSecond = calendar.getTimeInMillis();
                    }
                }
                String str = getMiniLogFolderPath(qLogItem2.appId) + getLogFileName(logFileFormatter.format(Long.valueOf(System.currentTimeMillis())));
                File file = new File(str);
                if (!file.exists()) {
                    com.tencent.mobileqq.utils.FileUtils.createFile(str);
                    bufferedWriter = new BufferedWriter(new MiniLogWriter(file, true), 8192);
                    bufferedWriter.write(logTime + "|" + processName + "|D||QQ_Version: " + sBuildNumber + "\r\n");
                } else {
                    bufferedWriter = nativeFlushMap.get(str);
                    if (bufferedWriter == null) {
                        bufferedWriter = new BufferedWriter(new MiniLogWriter(file, true), 8192);
                    }
                }
                StringBuilder sb5 = sBuilder;
                StringBuilder delete = sb5.delete(0, sb5.length());
                delete.append(logTime);
                delete.append(QbAddrData.DATA_SPLITER);
                delete.append(qLogItem2.logTime);
                delete.append(qLogItem2.appId);
                delete.append('[');
                delete.append(myProcessId);
                delete.append(']');
                delete.append(qLogItem2.threadId);
                delete.append(QbAddrData.DATA_SPLITER);
                delete.append(QLog.getReportLevel(qLogItem2.level));
                delete.append(QbAddrData.DATA_SPLITER);
                delete.append(qLogItem2.tag);
                delete.append(QbAddrData.DATA_SPLITER);
                delete.append(qLogItem2.f246327msg);
                delete.append('\n');
                bufferedWriter.write(delete.toString());
                Throwable th5 = qLogItem2.trace;
                if (th5 != null) {
                    bufferedWriter.write(Log.getStackTraceString(th5));
                    bufferedWriter.write(10);
                }
                nativeFlushMap.put(str, bufferedWriter);
                QLogItem qLogItem3 = (QLogItem) qLogItem2.getNext();
                sPool.recycle(qLogItem2);
                if (qLogItem2 == qLogItem) {
                    break;
                } else {
                    qLogItem2 = qLogItem3;
                }
            }
            nativeFlushAndClean();
        }
    }

    public static void d(String str, int i3, String str2, String str3) {
        d(str, i3, str2, str3, (Throwable) null);
    }

    public static void e(String str, int i3, String str2, String str3) {
        e(str, i3, str2, str3, (Throwable) null);
    }

    public static void i(String str, int i3, String str2, Object... objArr) {
        i(str, i3, str2, (Throwable) null, objArr);
    }

    public static void w(String str, int i3, String str2, Object... objArr) {
        w(str, i3, str2, (Throwable) null, objArr);
    }

    public static void d(String str, int i3, String str2, Object... objArr) {
        d(str, i3, str2, (Throwable) null, objArr);
    }

    public static void e(String str, int i3, String str2, Object... objArr) {
        e(str, i3, str2, (Throwable) null, objArr);
    }

    public static String getMiniLogFolderPath() {
        return MiniAppGlobal.getMiniCacheFilePath();
    }

    public static void i(String str, int i3, String str2, Throwable th5, Object... objArr) {
        StringBuilder sb5 = new StringBuilder((objArr.length * 30) + (th5 == null ? 0 : 128));
        for (Object obj : objArr) {
            sb5.append(obj);
        }
        i(str, i3, str2, sb5.toString(), th5);
    }

    public static void w(String str, int i3, String str2, Throwable th5, Object... objArr) {
        StringBuilder sb5 = new StringBuilder((objArr.length * 30) + (th5 == null ? 0 : 128));
        for (Object obj : objArr) {
            sb5.append(obj);
        }
        w(str, i3, str2, sb5.toString(), th5);
    }

    public static void d(String str, int i3, String str2, Throwable th5, Object... objArr) {
        StringBuilder sb5 = new StringBuilder((objArr.length * 30) + (th5 == null ? 0 : 128));
        for (Object obj : objArr) {
            sb5.append(obj);
        }
        d(str, i3, str2, sb5.toString(), th5);
    }

    public static void e(String str, int i3, String str2, Throwable th5, Object... objArr) {
        StringBuilder sb5 = new StringBuilder((objArr.length * 30) + (th5 == null ? 0 : 128));
        for (Object obj : objArr) {
            sb5.append(obj);
        }
        e(str, i3, str2, sb5.toString(), th5);
    }

    public static void i(String str, int i3, String str2, String str3, Throwable th5) {
        if (isEnableDebug(str2).booleanValue()) {
            addNativeLogItem(str2, str, i3, str3, th5);
        }
        if (QLog.isColorLevel()) {
            QLog.i(str, i3, str3, th5);
        }
    }

    public static void w(String str, int i3, String str2, String str3, Throwable th5) {
        if (isEnableDebug(str2).booleanValue()) {
            addNativeLogItem(str2, str, i3, str3, th5);
        }
        if (QLog.isColorLevel()) {
            QLog.w(str, i3, str3, th5);
        }
    }

    public static void d(String str, int i3, String str2, String str3, Throwable th5) {
        if (isEnableDebug(str2).booleanValue()) {
            addNativeLogItem(str2, str, i3, str3, th5);
        }
        if (QLog.isColorLevel()) {
            QLog.d(str, i3, str3, th5);
        }
    }

    public static void e(String str, int i3, String str2, String str3, Throwable th5) {
        if (isEnableDebug(str2).booleanValue()) {
            addNativeLogItem(str2, str, i3, str3, th5);
        }
        if (QLog.isColorLevel()) {
            QLog.e(str, i3, str3, th5);
        }
    }
}
