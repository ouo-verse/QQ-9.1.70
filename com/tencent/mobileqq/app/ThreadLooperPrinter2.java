package com.tencent.mobileqq.app;

import android.os.SystemClock;
import android.util.Printer;
import com.tencent.maxvideo.MaxVideoConst;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public class ThreadLooperPrinter2 implements Printer {
    static IPatchRedirector $redirector_ = null;
    public static final int DEFAULT_THRESHOLD_TIME = 200;
    public static final int FAMILY_DISPATCHER_TASK = 2;
    public static final int FAMILY_FILW_TASK = 3;
    public static final int FAMILY_SUB_TASK = 1;
    public static final String START_PREFIX = ">>";
    public static final String STOP_PREFIX = "<<";
    private static final String TAG = "TM.global.LooperPrinter";
    public static int sLogThreshold;
    private String lastLog;
    private int mFamily;
    private String mLooperName;
    private long msgCount;
    private int notReortedLoopCount;
    private long startTime;
    private long totalCost;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41060);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            sLogThreshold = 200;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ThreadLooperPrinter2(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) str);
            return;
        }
        this.notReortedLoopCount = 0;
        this.mFamily = i3;
        this.mLooperName = str;
    }

    private static String format(String str) {
        int indexOf;
        int indexOf2;
        if (str == null || str.length() == 0 || !str.startsWith(">>>") || (indexOf = str.indexOf(40)) == -1 || (indexOf2 = str.indexOf(41, indexOf)) == -1) {
            return null;
        }
        String substring = str.substring(indexOf + 1, indexOf2);
        int indexOf3 = str.indexOf("} ", indexOf2);
        if (indexOf3 == -1) {
            return null;
        }
        int i3 = indexOf3 + 2;
        int indexOf4 = str.indexOf(64, i3);
        if (indexOf4 == -1 && (indexOf4 = str.indexOf(58, i3)) == -1 && (indexOf4 = str.indexOf(32, i3)) == -1) {
            return null;
        }
        String substring2 = str.substring(i3, indexOf4);
        int indexOf5 = str.indexOf(MsgSummary.STR_COLON, indexOf4);
        if (indexOf5 == -1) {
            return null;
        }
        return String.format(MaxVideoConst.REPORT_CLICK_FORMAT, substring, substring2, str.substring(indexOf5 + 2));
    }

    @Override // android.util.Printer
    public void println(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            return;
        }
        if (str.startsWith(START_PREFIX)) {
            this.startTime = SystemClock.uptimeMillis();
            this.lastLog = str;
            return;
        }
        if (this.startTime != 0 && str.startsWith(STOP_PREFIX)) {
            this.msgCount++;
            long uptimeMillis = SystemClock.uptimeMillis() - this.startTime;
            this.startTime = 0L;
            this.totalCost += uptimeMillis;
            if (ThreadSetting.logcatBgTaskMonitor) {
                ThreadLog.printQLog("AutoMonitor", this.mLooperName + ", cost=" + uptimeMillis + ", " + format(this.lastLog));
                return;
            }
            if (uptimeMillis >= sLogThreshold) {
                ThreadLog.printQLog("AutoMonitor", this.mLooperName + " OOT cost=" + uptimeMillis + ", " + format(this.lastLog));
            }
        }
    }

    void setDebugSettings(int i3, boolean z16) {
        ThreadLog.printQLog(TAG, "setting threshold, threshold=" + i3);
        sLogThreshold = i3;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return super.toString() + "(msgCount = " + this.msgCount + ", totalCost = " + this.totalCost + ")";
    }
}
