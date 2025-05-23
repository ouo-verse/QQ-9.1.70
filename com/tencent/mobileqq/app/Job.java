package com.tencent.mobileqq.app;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadExcutor;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/* compiled from: P */
/* loaded from: classes11.dex */
public class Job extends WeakReference<Object> implements Runnable, Comparable<Job> {
    static IPatchRedirector $redirector_ = null;
    private static long RUNNING_TIME_OUT = 0;
    private static final String TAG = "Job";
    public static ConcurrentLinkedQueue<String> runningJmapInAync;
    public static ConcurrentLinkedQueue<String> runningJmapInDB;
    public static ConcurrentLinkedQueue<String> runningJmapInDownload;
    public static ConcurrentLinkedQueue<String> runningJmapInFile;
    public static ConcurrentLinkedQueue<String> runningJmapInHeavy;
    public static ConcurrentLinkedQueue<String> runningJmapInLight;
    public static ConcurrentLinkedQueue<String> runningJmapInNet;
    public static ConcurrentLinkedQueue<String> runningJmapInNormal;
    public static ConcurrentLinkedQueue<String> runningJmapInOther;
    public long addPoint;
    public long blcokingCost;
    private boolean canAutoRetrieve;
    public long cost;
    private boolean hasKey;
    private long jobReportTimeThreshold;
    public long mId;
    public Runnable mJob;
    public ThreadExcutor.IThreadListener mListener;
    public String mName;
    public int mType;
    public int poolNum;
    public long postCost;
    private String stacktrace;
    private com.tencent.mobileqq.app.monitor.f threadPoolMonitor;
    public long wait;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40865);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
            return;
        }
        runningJmapInHeavy = new ConcurrentLinkedQueue<>();
        runningJmapInLight = new ConcurrentLinkedQueue<>();
        runningJmapInDownload = new ConcurrentLinkedQueue<>();
        runningJmapInNormal = new ConcurrentLinkedQueue<>();
        runningJmapInDB = new ConcurrentLinkedQueue<>();
        runningJmapInFile = new ConcurrentLinkedQueue<>();
        runningJmapInNet = new ConcurrentLinkedQueue<>();
        runningJmapInAync = new ConcurrentLinkedQueue<>();
        runningJmapInOther = new ConcurrentLinkedQueue<>();
        RUNNING_TIME_OUT = 9990000L;
    }

    public Job(Object obj, Runnable runnable, boolean z16) {
        super(obj);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, obj, runnable, Boolean.valueOf(z16));
            return;
        }
        this.mId = 0L;
        this.mType = 0;
        this.addPoint = 0L;
        this.cost = -1L;
        this.wait = -1L;
        this.hasKey = false;
        this.blcokingCost = -1L;
        this.postCost = -1L;
        this.poolNum = -1;
        this.jobReportTimeThreshold = 60000L;
        if (obj != null) {
            this.hasKey = true;
        }
        this.mJob = runnable;
        this.canAutoRetrieve = z16;
    }

    private void afterRun() {
        this.cost = SystemClock.uptimeMillis() - (this.wait + this.addPoint);
        ThreadExcutor.IThreadListener iThreadListener = this.mListener;
        if (iThreadListener != null) {
            iThreadListener.onPostRun();
        }
        com.tencent.mobileqq.app.monitor.f fVar = this.threadPoolMonitor;
        if (fVar != null) {
            fVar.e(this);
        }
        ThreadMonitor.INSTANCE.upDataTask(this.poolNum, this.wait, this.cost);
        reportRunningTooLong();
        if (ThreadSetting.logcatBgTaskMonitor) {
            ThreadLog.printQLog(ThreadManagerV2.TAG, "tsp execute-" + toString());
        }
        if (ThreadLog.needRecordJob()) {
            int i3 = this.poolNum;
            if (i3 != 1) {
                if (i3 != 2) {
                    switch (i3) {
                        case 5:
                            runningJmapInDownload.remove(this.mName);
                            return;
                        case 6:
                            runningJmapInNormal.remove(this.mName);
                            return;
                        case 7:
                            runningJmapInDB.remove(this.mName);
                            return;
                        case 8:
                            runningJmapInFile.remove(this.mName);
                            return;
                        case 9:
                            runningJmapInNet.remove(this.mName);
                            return;
                        case 10:
                            runningJmapInAync.remove(this.mName);
                            return;
                        case 11:
                            runningJmapInOther.remove(this.mName);
                            return;
                        default:
                            return;
                    }
                }
                runningJmapInHeavy.remove(this.mName);
                return;
            }
            runningJmapInLight.remove(this.mName);
        }
    }

    private void beforeRun() {
        long uptimeMillis = SystemClock.uptimeMillis() - this.addPoint;
        this.wait = uptimeMillis;
        JobReporter.reportJobTime(uptimeMillis);
        ThreadExcutor.IThreadListener iThreadListener = this.mListener;
        if (iThreadListener != null) {
            iThreadListener.onPreRun();
        }
        com.tencent.mobileqq.app.monitor.f fVar = this.threadPoolMonitor;
        if (fVar != null) {
            fVar.f(this);
        }
        if (ThreadSetting.logcatBgTaskMonitor) {
            ThreadLog.printQLog(ThreadManagerV2.TAG, "tsp execute|" + toString());
        }
        if (ThreadLog.needRecordJob()) {
            int i3 = this.poolNum;
            if (i3 != 1) {
                if (i3 != 2) {
                    switch (i3) {
                        case 5:
                            runningJmapInDownload.add(this.mName);
                            return;
                        case 6:
                            runningJmapInNormal.add(this.mName);
                            return;
                        case 7:
                            runningJmapInDB.add(this.mName);
                            return;
                        case 8:
                            runningJmapInFile.add(this.mName);
                            return;
                        case 9:
                            runningJmapInNet.add(this.mName);
                            return;
                        case 10:
                            runningJmapInAync.add(this.mName);
                            return;
                        case 11:
                            runningJmapInOther.add(this.mName);
                            return;
                        default:
                            return;
                    }
                }
                runningJmapInHeavy.add(this.mName);
                return;
            }
            runningJmapInLight.add(this.mName);
        }
    }

    private long getJobReportTimeThreshold() {
        if (!ThreadSetting.isPublicVersion) {
            RUNNING_TIME_OUT = this.jobReportTimeThreshold;
        }
        return RUNNING_TIME_OUT;
    }

    private void reportRunningTooLong() {
        if (ThreadLog.needReportRunOrBlocking() && this.cost >= getJobReportTimeThreshold() && ThreadManagerV2.OPEN_RDM_REPORT && ThreadManagerV2.sThreadWrapContext != null) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("process_" + ThreadSetting.sProcessId);
            sb5.append(" mjobName_" + this.mName);
            sb5.append(" mType_" + this.mType);
            sb5.append(" cost_" + this.cost);
            ThreadLog.printQLog(TAG, sb5.toString());
            if (ThreadSmartPoolMonitorConfig.getMonitorFeatureSwitchState() && !TextUtils.isEmpty(this.stacktrace)) {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("jobInfo", sb5.toString());
                hashMap.put("jobStacktrace", this.stacktrace);
                hashMap.put("jobName", this.mName);
                hashMap.put("jobType", String.valueOf(this.mType));
                hashMap.put("jobCost", String.valueOf(this.cost));
                hashMap.put("revision", ThreadSetting.revision);
                ThreadLog.printQLog(ThreadManagerV2.TAG, "Block info:" + hashMap);
                ThreadManagerV2.sThreadWrapContext.reportDengTaException("", "threadPoolBlockingMonitor", true, 0L, 0L, hashMap, "", false);
            }
            ThreadManagerV2.sThreadWrapContext.reportRDMException(new TSPRunTooLongCatchedException("max_reportJobRunningTooLong"), "max_reportJobRunningTooLong", sb5.toString());
        }
    }

    public boolean checkShouldRun() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        if (!this.canAutoRetrieve || !this.hasKey) {
            return true;
        }
        Object obj = get();
        if (obj != null) {
            try {
                Field declaredField = this.mJob.getClass().getDeclaredField("this$0");
                declaredField.setAccessible(true);
                declaredField.set(this.mJob, obj);
                return true;
            } catch (IllegalAccessException e16) {
                ThreadLog.printQLog(TAG, this.mName, e16);
            } catch (IllegalArgumentException e17) {
                ThreadLog.printQLog(TAG, this.mName, e17);
            } catch (NoSuchFieldException e18) {
                ThreadLog.printQLog(TAG, this.mName, e18);
            }
        } else {
            ThreadLog.printQLog(TAG, this.mName + " never run, becuse outer object is retrieve already");
        }
        return false;
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, obj)).booleanValue();
        }
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Job job = (Job) obj;
        Runnable runnable = this.mJob;
        if (runnable == null) {
            if (job.mJob != null) {
                return false;
            }
        } else if (!runnable.equals(job.mJob)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        Runnable runnable = this.mJob;
        if (runnable == null) {
            hashCode = 0;
        } else {
            hashCode = runnable.hashCode();
        }
        return 31 + hashCode;
    }

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (checkShouldRun()) {
            beforeRun();
            this.mJob.run();
            afterRun();
        } else {
            ThreadLog.printQLog(TAG, this.mName + " is recycled");
        }
    }

    public void setMonitorConfig(ThreadSmartPoolMonitorConfig threadSmartPoolMonitorConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) threadSmartPoolMonitorConfig);
        } else {
            this.jobReportTimeThreshold = threadSmartPoolMonitorConfig.getJobReportTimeThreshold();
        }
    }

    public void setStacktrace(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
        } else {
            this.stacktrace = str;
        }
    }

    public void setThreadPoolMonitor(com.tencent.mobileqq.app.monitor.f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) fVar);
        } else {
            this.threadPoolMonitor = fVar;
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder(64);
        sb5.append(" cost=");
        sb5.append(this.cost);
        sb5.append(", ");
        sb5.append(this.mName);
        sb5.append("|pool-");
        sb5.append(this.poolNum);
        sb5.append("|t-id=");
        sb5.append(this.mId);
        sb5.append("|mType=");
        sb5.append(this.mType);
        sb5.append("|wait=");
        sb5.append(this.wait);
        sb5.append("|postCost=");
        sb5.append(this.postCost);
        sb5.append("|bCost=");
        sb5.append(this.blcokingCost);
        return sb5.toString();
    }

    @Override // java.lang.Comparable
    public int compareTo(Job job) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this, (Object) job)).intValue();
        }
        int i3 = this.mType;
        int i16 = job.mType;
        if (i3 == i16) {
            return 0;
        }
        return i3 > i16 ? -1 : 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Job(Object obj, String str, int i3, Runnable runnable, ThreadExcutor.IThreadListener iThreadListener, boolean z16) {
        super(obj);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, obj, str, Integer.valueOf(i3), runnable, iThreadListener, Boolean.valueOf(z16));
            return;
        }
        this.mId = 0L;
        this.mType = 0;
        this.addPoint = 0L;
        this.cost = -1L;
        this.wait = -1L;
        this.hasKey = false;
        this.blcokingCost = -1L;
        this.postCost = -1L;
        this.poolNum = -1;
        this.jobReportTimeThreshold = 60000L;
        if (obj != null) {
            this.hasKey = true;
        }
        this.mName = runnable.toString();
        this.mType = i3;
        this.mJob = runnable;
        this.mListener = iThreadListener;
        if (iThreadListener != null) {
            iThreadListener.onAdded();
        }
        this.addPoint = SystemClock.uptimeMillis();
        this.canAutoRetrieve = z16;
    }
}
