package com.tencent.mobileqq.app;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes11.dex */
public class JobReporter {
    static IPatchRedirector $redirector_ = null;
    private static final String KEY_CREATE_STACK = "createStack";
    private static final String KEY_CREATE_TIME = "createTime";
    private static final String KEY_CURRENT_THREAD_NAME = "currentThreadName";
    private static final String KEY_FD_COUNT = "fdCount";
    private static final String KEY_HANDLER_THREAD_COUNT = "HandlerThreadCount";
    private static final String KEY_INTERVAL_TIME = "intervalTime";
    private static final String KEY_IS_HANDLER_THREAD = "isHandlerThread";
    private static final String KEY_NEW_THREAD_NAME = "newThreadName";
    private static final String KEY_PRIORITY = "priority";
    private static final String KEY_PROCESS_NAME = "currentProcessName";
    private static final String KEY_SYSTEM_THREAD_COUNT = "systemThreadCount";
    private static final String KEY_THREAD_COUNT = "threadCount";
    private static final String KEY_THREAD_PRIORITY = "threadPriority";
    private static final int LEVEL_COUNT = 3;
    private static final int MSG_PUT_INTO_THRED_LIST = 1;
    private static final int MSG_REPORT_THRED_PEAK = 2;
    private static final int MSG_THRED_CREATE_CHECK = 3;
    private static final long REPORT_INTERVAL_TIME = 20000;
    private static final int REPORT_LEVEL_SEPARATOR = 500;
    private static final int REPORT_THRESHOLD = 200;
    private static final String TAG = "JobReporter";
    private static final long THREAD_COUNT_REPORT_INTERVAL_Debug = 20000;
    private static final long THREAD_COUNT_REPORT_INTERVAL_Release = 86400000;
    private static final String THREAD_MONITOR_REPORT_EVENT_NAME = "thread_monitor_report";
    private static final String ThreadMonitorPeakCount = "thread_monitor_peak_count";
    public static final String ThreadOnCreatedCallBack = "com/tencent/mobileqq/app/JobReporter";
    private static Handler mFileHandler;
    public static ThreadCheck mThreadCheck;
    private static Field nativePeerF;
    private static boolean nativePeerGetFailed;
    private static boolean nativePeerReflectFailed;
    private static List<String> reportThreadBlackList;
    public static long sInitThreadMonitorTime;
    private static boolean sInited;
    private static long sMonitorStartTime;
    private static Random sRandom;
    private static int sReportCount;
    public static AtomicLong sThreadJobReportCountLevelOne;
    public static AtomicLong sThreadJobReportCountLevelThree;
    public static AtomicLong sThreadJobReportCountLevelTwo;
    public static AtomicLong sThreadJobReportLastReportTs;
    public static AtomicLong sThreadJobReportTotalCount;
    private static List<WeakReference<HandlerThread>> weakHandlerThreadList;
    private static List<WeakReference<Thread>> weakThreadList;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class CheckParams {
        static IPatchRedirector $redirector_;
        public long createTime;
        public String currentProcessName;
        public int currentThreadCount;
        public String currentThreadName;
        public boolean isHandlerThread;
        public String newThreadName;
        public int priority;
        public StackTraceElement[] ste;
        public int threadPriority;
        public long tid;

        public CheckParams() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.newThreadName = "";
            this.currentThreadName = "";
            this.currentProcessName = "";
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "CheckParams{newThreadName='" + this.newThreadName + "', currentThreadName='" + this.currentThreadName + "', threadPriority=" + this.threadPriority + ", priority=" + this.priority + ", isHandlerThread=" + this.isHandlerThread + ", currentProcessName='" + this.currentProcessName + "', createTime=" + this.createTime + ", currentThreadCount=" + this.currentThreadCount + ", ste=" + Arrays.toString(this.ste) + '}';
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a extends Handler {
        static IPatchRedirector $redirector_;

        a(Looper looper) {
            super(looper);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) looper);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            ThreadCheck threadCheck;
            Object obj;
            long j3;
            Object obj2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            int i3 = message.what;
            if (i3 == 1 && (obj2 = message.obj) != null) {
                Thread thread = (Thread) obj2;
                JobReporter.weakThreadList.add(new WeakReference(thread));
                if (thread instanceof HandlerThread) {
                    JobReporter.weakHandlerThreadList.add(new WeakReference((HandlerThread) thread));
                    return;
                }
                return;
            }
            if (i3 == 2) {
                if (ThreadManagerV2.sThreadWrapContext != null) {
                    try {
                        JobReporter.setsInitThreadMonitorTime();
                        long currentTimeMillis = System.currentTimeMillis();
                        if (ThreadSetting.isPublicVersion) {
                            j3 = 86400000;
                        } else {
                            j3 = 20000;
                        }
                        if (currentTimeMillis - JobReporter.sMonitorStartTime > j3 && JobReporter.i()) {
                            long longValue = ((Long) message.obj).longValue();
                            if (longValue == 0) {
                                longValue = SystemClock.uptimeMillis() - JobReporter.sInitThreadMonitorTime;
                            }
                            HashMap hashMap = new HashMap();
                            long h16 = JobReporter.h();
                            long g16 = JobReporter.g();
                            int fdCount = ThreadManagerV2.sThreadWrapContext.getFdCount();
                            int activeCount = Thread.activeCount();
                            hashMap.put(JobReporter.KEY_THREAD_COUNT, String.valueOf(h16));
                            hashMap.put(JobReporter.KEY_HANDLER_THREAD_COUNT, String.valueOf(g16));
                            hashMap.put(JobReporter.KEY_INTERVAL_TIME, String.valueOf(longValue));
                            hashMap.put(JobReporter.KEY_FD_COUNT, String.valueOf(fdCount));
                            hashMap.put(JobReporter.KEY_SYSTEM_THREAD_COUNT, String.valueOf(activeCount));
                            ThreadLog.printQLog(JobReporter.TAG, "reportThreadCount. reportParam: " + hashMap);
                            ThreadManagerV2.sThreadWrapContext.reportBeacon(JobReporter.ThreadMonitorPeakCount, hashMap);
                            JobReporter.sMonitorStartTime = currentTimeMillis;
                            ThreadManagerV2.sThreadWrapContext.setMainProccessThreadMonitorTime(currentTimeMillis);
                            return;
                        }
                        return;
                    } catch (Exception e16) {
                        ThreadLog.printQLog(JobReporter.TAG, "reportThreadCount error: ", e16);
                        return;
                    }
                }
                return;
            }
            if (i3 == 3) {
                if (!ThreadSetting.isPublicVersion && (threadCheck = JobReporter.mThreadCheck) != null && (obj = message.obj) != null) {
                    threadCheck.isLegalName((CheckParams) obj);
                }
                Object obj3 = message.obj;
                if (obj3 != null) {
                    CheckParams checkParams = (CheckParams) obj3;
                    if (ThreadManagerV2.sThreadWrapContext != null) {
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put(JobReporter.KEY_NEW_THREAD_NAME, checkParams.newThreadName);
                        hashMap2.put(JobReporter.KEY_CURRENT_THREAD_NAME, checkParams.currentThreadName);
                        hashMap2.put(JobReporter.KEY_IS_HANDLER_THREAD, String.valueOf(checkParams.isHandlerThread));
                        hashMap2.put(JobReporter.KEY_PROCESS_NAME, checkParams.currentProcessName);
                        hashMap2.put("createTime", String.valueOf(checkParams.createTime));
                        hashMap2.put(JobReporter.KEY_CREATE_STACK, Arrays.toString(checkParams.ste));
                        hashMap2.put(JobReporter.KEY_THREAD_PRIORITY, String.valueOf(checkParams.threadPriority));
                        hashMap2.put("priority", String.valueOf(checkParams.priority));
                        ThreadLog.printQLog(JobReporter.TAG, "onThreadCreatedCallback. reportParam: " + checkParams);
                        ThreadManagerV2.sThreadWrapContext.reportBeacon(JobReporter.THREAD_MONITOR_REPORT_EVENT_NAME, hashMap2);
                        return;
                    }
                    return;
                }
                return;
            }
            super.handleMessage(message);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40896);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        sMonitorStartTime = 0L;
        sInited = false;
        weakThreadList = Collections.synchronizedList(new LinkedList());
        weakHandlerThreadList = Collections.synchronizedList(new LinkedList());
        sThreadJobReportLastReportTs = new AtomicLong(0L);
        sThreadJobReportTotalCount = new AtomicLong(0L);
        sThreadJobReportCountLevelOne = new AtomicLong(0L);
        sThreadJobReportCountLevelTwo = new AtomicLong(0L);
        sThreadJobReportCountLevelThree = new AtomicLong(0L);
        sInitThreadMonitorTime = 0L;
        sReportCount = 0;
        reportThreadBlackList = new ArrayList<String>() { // from class: com.tencent.mobileqq.app.JobReporter.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                } else {
                    add("QQ_DISPATCHER");
                    add("SharedPreferencesImpl-load");
                }
            }
        };
        mFileHandler = new a(ThreadManagerV2.getFileThreadLooper());
        nativePeerGetFailed = false;
        nativePeerF = null;
        nativePeerReflectFailed = false;
        sRandom = new Random();
    }

    public JobReporter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static /* bridge */ /* synthetic */ int g() {
        return getCurrentHandlerThreadCount();
    }

    private static int getCurrentHandlerThreadCount() {
        weakHandlerThreadList.size();
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        for (WeakReference<HandlerThread> weakReference : weakHandlerThreadList) {
            if (weakReference.get() != null) {
                if (!weakReference.get().isAlive()) {
                    arrayList.add(weakReference);
                } else {
                    i3++;
                }
            } else {
                arrayList.add(weakReference);
            }
        }
        int size = arrayList.size();
        for (int i16 = 0; i16 < size; i16++) {
            weakHandlerThreadList.remove(arrayList.get(i16));
        }
        return i3;
    }

    private static int getCurrentThreadCount() {
        Field nativePeerField = getNativePeerField();
        if (nativePeerField != null && !nativePeerGetFailed) {
            int size = weakThreadList.size();
            if (size > 1024) {
                ThreadLog.printQLog(TAG, "getCurrentThreadCount beyond 1024:" + size);
                ThreadWrapContext threadWrapContext = ThreadManagerV2.sThreadWrapContext;
                if (threadWrapContext != null) {
                    threadWrapContext.reportDengTaException("", "ThreadPeakCountOverLimit", true, size, 0L, null, "", false);
                }
                weakThreadList.clear();
                return 0;
            }
            ArrayList arrayList = new ArrayList();
            int i3 = 0;
            for (int i16 = 0; i16 < size; i16++) {
                if (nativePeerGetFailed) {
                    weakThreadList.clear();
                    return 0;
                }
                WeakReference<Thread> weakReference = weakThreadList.get(i16);
                Thread thread = weakReference.get();
                if (thread != null) {
                    try {
                        if (((Long) nativePeerField.get(thread)).longValue() == 0) {
                            arrayList.add(weakReference);
                        } else {
                            i3++;
                        }
                    } catch (Exception e16) {
                        ThreadLog.printQLog(TAG, "getCurrentThreadCoun nativePeer err ", e16);
                        nativePeerGetFailed = true;
                        weakThreadList.clear();
                        return 0;
                    }
                } else {
                    arrayList.add(weakReference);
                }
            }
            int size2 = arrayList.size();
            for (int i17 = 0; i17 < size2; i17++) {
                weakThreadList.remove(arrayList.get(i17));
            }
            return i3;
        }
        weakThreadList.clear();
        return 0;
    }

    private static Field getFieldGrayList(String str, String str2) {
        try {
            Field field = (Field) Class.class.getDeclaredMethod("getDeclaredField", String.class).invoke(Class.forName(str), str2);
            field.setAccessible(true);
            return field;
        } catch (ClassNotFoundException e16) {
            ThreadLog.printQLog(TAG, "getFieldGrayList error.", e16);
            return null;
        } catch (IllegalAccessException e17) {
            ThreadLog.printQLog(TAG, "getFieldGrayList error.", e17);
            return null;
        } catch (NoSuchMethodException e18) {
            ThreadLog.printQLog(TAG, "getFieldGrayList error.", e18);
            return null;
        } catch (InvocationTargetException e19) {
            ThreadLog.printQLog(TAG, "getFieldGrayList error.", e19);
            return null;
        }
    }

    private static Field getNativePeerField() {
        Field field = nativePeerF;
        if (field == null && !nativePeerReflectFailed) {
            Field fieldGrayList = getFieldGrayList("java.lang.Thread", "nativePeer");
            nativePeerF = fieldGrayList;
            if (fieldGrayList == null) {
                nativePeerReflectFailed = true;
                ThreadLog.printQLog(TAG, "getNativePeerField error.");
            }
            return nativePeerF;
        }
        return field;
    }

    static /* bridge */ /* synthetic */ int h() {
        return getCurrentThreadCount();
    }

    static /* bridge */ /* synthetic */ boolean i() {
        return peakCountRamdomReport();
    }

    private static boolean isCanReport(String str, String str2) {
        int i3;
        if (str != null && reportThreadBlackList.contains(str)) {
            return false;
        }
        if (str != null && reportThreadBlackList.contains(str2)) {
            return false;
        }
        if (ThreadSetting.isPublicVersion) {
            i3 = ThreadManagerV2.sThreadWrapContext.threadMonitorReportSample();
        } else {
            i3 = 10;
        }
        if (new Random().nextInt(i3) != 0) {
            return false;
        }
        return true;
    }

    public static void onThreadCreatedCallback(Object obj) {
        int i3;
        if (obj != null && (obj instanceof Thread)) {
            Message obtainMessage = mFileHandler.obtainMessage(1);
            obtainMessage.obj = obj;
            mFileHandler.sendMessage(obtainMessage);
            String name = Thread.currentThread().getName();
            Thread thread = (Thread) obj;
            String name2 = thread.getName();
            if (isCanReport(name, name2)) {
                CheckParams checkParams = new CheckParams();
                checkParams.tid = thread.getId();
                checkParams.newThreadName = name2;
                checkParams.ste = Thread.currentThread().getStackTrace();
                checkParams.currentThreadName = name;
                checkParams.isHandlerThread = obj instanceof HandlerThread;
                try {
                    i3 = Process.getThreadPriority((int) thread.getId());
                } catch (Exception unused) {
                    i3 = -100;
                }
                checkParams.threadPriority = i3;
                checkParams.priority = thread.getPriority();
                MobileQQ mobileQQ = MobileQQ.sMobileQQ;
                if (mobileQQ != null) {
                    checkParams.currentProcessName = mobileQQ.getQQProcessName();
                }
                if (sInitThreadMonitorTime != 0) {
                    checkParams.createTime = SystemClock.uptimeMillis() - sInitThreadMonitorTime;
                }
                Message obtainMessage2 = mFileHandler.obtainMessage(3);
                obtainMessage2.obj = checkParams;
                mFileHandler.sendMessage(obtainMessage2);
            }
        }
    }

    private static boolean peakCountRamdomReport() {
        if (!ThreadSetting.isPublicVersion) {
            return ramdomReport(100);
        }
        if (ThreadSetting.isGrayVersion) {
            return ramdomReport(10000);
        }
        return ramdomReport(1000000);
    }

    public static boolean ramdomReport(int i3) {
        if (!ThreadSetting.isPublicVersion) {
            return true;
        }
        if (i3 > 0 && sRandom.nextInt(i3) == 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void reportJobTime(long j3) {
        try {
            if (ThreadSetting.sProcessId != ThreadSetting.PROCESS_QQ) {
                return;
            }
            sThreadJobReportTotalCount.incrementAndGet();
            if (j3 > 200) {
                int min = Math.min((int) (j3 / 500), 2);
                if (min != 0) {
                    if (min != 1) {
                        if (min == 2) {
                            sThreadJobReportCountLevelThree.incrementAndGet();
                        }
                    } else {
                        sThreadJobReportCountLevelTwo.incrementAndGet();
                    }
                } else {
                    sThreadJobReportCountLevelOne.incrementAndGet();
                }
            }
        } catch (Throwable th5) {
            ThreadLog.printQLog(TAG, "reportJobTime error!!!  : ", th5);
        }
    }

    public static void reportThreadPeakCount(long j3) {
        Message obtainMessage = mFileHandler.obtainMessage(2);
        obtainMessage.obj = Long.valueOf(j3);
        mFileHandler.sendMessage(obtainMessage);
    }

    public static void setReportThread() {
        ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.app.JobReporter.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    JobReporter.sReportCount++;
                    JobReporter.reportThreadPeakCount(JobReporter.sReportCount * 20000);
                    if (JobReporter.sReportCount < 5) {
                        ThreadManagerV2.executeDelay(this, 16, null, true, 20000L);
                        return;
                    }
                    return;
                }
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }, 16, null, true, 20000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void setsInitThreadMonitorTime() {
        ThreadWrapContext threadWrapContext;
        if (!sInited && (threadWrapContext = ThreadManagerV2.sThreadWrapContext) != null) {
            sMonitorStartTime = threadWrapContext.getMainProccessThreadMonitorTime();
            ThreadLog.printQLog(TAG, "sMonitorStartTime:" + sMonitorStartTime);
            sInited = true;
        }
    }

    public static String stackToStringByIndex(StackTraceElement[] stackTraceElementArr, int i3, int i16) {
        StringBuilder sb5 = new StringBuilder();
        for (int i17 = i3; i17 < stackTraceElementArr.length && i17 < i3 + i16; i17++) {
            sb5.append(stackTraceElementArr[i17]);
            sb5.append("\n");
        }
        return sb5.toString();
    }
}
