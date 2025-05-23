package cooperation.qzone.report.lp;

import NS_MOBILE_CLIENT_UPDATE.REPORT_INFO;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.report.lp.ILpReportUtils;
import common.config.service.QzoneConfig;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes28.dex */
public class LpReportManager {
    public static final String BASE = "LpReport.";
    private static final int DC00518_SUBTALBE = 48;
    public static final int DC02453_SUBTABLE = 32;
    public static final int MAX_RUNNING_TASK = 2;
    private static final String TAG = "LpReport.LpReportManager";
    private static LpReportManager lpReportManager;
    private static long startTime = SystemClock.uptimeMillis();
    private LpReportInfos storedClicks = new LpReportInfos();
    ConcurrentLinkedQueue<ReportRunner> mReportRunners = new ConcurrentLinkedQueue<>();
    volatile int mRunningTaskNum = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class ReportRunner implements Runnable {
        LpReportInfo info;
        boolean isNeedSample;
        boolean isReportNow;
        int subtype;

        public ReportRunner(int i3, LpReportInfo lpReportInfo, boolean z16, boolean z17) {
            this.subtype = i3;
            this.info = lpReportInfo;
            this.isNeedSample = z16;
            this.isReportNow = z17;
        }

        @Override // java.lang.Runnable
        public void run() {
            LpReportManager.this.report(this.subtype, this.info, this.isNeedSample, this.isReportNow);
            LpReportManager lpReportManager = LpReportManager.this;
            lpReportManager.mRunningTaskNum--;
            LpReportManager.this.runNext();
        }
    }

    private void addReportTask(ReportRunner reportRunner) {
        this.mReportRunners.offer(reportRunner);
        runNext();
    }

    public static boolean fileExists(String str) {
        if (TextUtils.isEmpty(str) || !new File(str).exists()) {
            return false;
        }
        return true;
    }

    public static LpReportManager getInstance() {
        if (lpReportManager == null) {
            synchronized (LpReportManager.class) {
                if (lpReportManager == null) {
                    lpReportManager = new LpReportManager();
                }
            }
        }
        return lpReportManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void report(int i3, LpReportInfo lpReportInfo, boolean z16, boolean z17) {
        if (lpReportInfo == null) {
            QLog.e(TAG, 1, "info=null");
            return;
        }
        if (z16 && !LpReportUtils.isNeedReport()) {
            LpReportUtils.showToast(lpReportInfo, false);
            return;
        }
        LpReportUtils.showToast(lpReportInfo, true);
        synchronized (this.storedClicks) {
            this.storedClicks.addInfo(i3, lpReportInfo);
        }
        if (i3 == 49) {
            startReportImediately(1);
        } else if (LpReportUtils.meetCondition(this.storedClicks, startTime)) {
            startReportImediately(3);
        }
    }

    private void reportAsync(final int i3, final LpReportInfo lpReportInfo, final boolean z16, final boolean z17) {
        if (Looper.myLooper() != null && Looper.myLooper() == Looper.getMainLooper()) {
            if (MobileQQ.sProcessId == 1) {
                addReportTask(new ReportRunner(i3, lpReportInfo, z16, z17));
                return;
            } else {
                QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.ReportThread).post(new Runnable() { // from class: cooperation.qzone.report.lp.LpReportManager.1
                    @Override // java.lang.Runnable
                    public void run() {
                        LpReportManager.this.report(i3, lpReportInfo, z16, z17);
                    }
                });
                return;
            }
        }
        report(i3, lpReportInfo, z16, z17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runNext() {
        ReportRunner poll;
        if (this.mRunningTaskNum < 2 && (poll = this.mReportRunners.poll()) != null) {
            this.mRunningTaskNum++;
            ThreadManagerV2.excute(poll, 64, null, true);
        }
    }

    public void reportToDC001831(LpReportInfo_dc01831 lpReportInfo_dc01831, boolean z16, boolean z17) {
        reportAsync(13, lpReportInfo_dc01831, z16, z17);
    }

    public void reportToDC00307(LpReportInfo_dc00307 lpReportInfo_dc00307, boolean z16, boolean z17) {
        reportAsync(57, lpReportInfo_dc00307, z16, z17);
    }

    public void reportToDC00321(LpReportInfo_dc00321 lpReportInfo_dc00321, boolean z16, boolean z17) {
        reportAsync(5, lpReportInfo_dc00321, z16, z17);
    }

    public void reportToDC00420(LpReportInfo_dc00420 lpReportInfo_dc00420, boolean z16, boolean z17) {
        reportAsync(1, lpReportInfo_dc00420, z16, z17);
    }

    public void reportToDC00518(LpReportInfo_dc00518 lpReportInfo_dc00518, boolean z16, boolean z17) {
        reportAsync(48, lpReportInfo_dc00518, z16, z17);
    }

    public void reportToDC01245(LpReportInfo_dc01245 lpReportInfo_dc01245, boolean z16, boolean z17) {
        reportAsync(7, lpReportInfo_dc01245, z16, z17);
    }

    public void reportToDC01500(LpReportInfo_dc01500 lpReportInfo_dc01500, boolean z16, boolean z17) {
        reportAsync(8, lpReportInfo_dc01500, z16, z17);
    }

    public void reportToDC01691(LpReportInfo_DC01691 lpReportInfo_DC01691, boolean z16, boolean z17) {
        reportAsync(11, lpReportInfo_DC01691, z16, z17);
    }

    public void reportToDC01796(LpReportInfo_DC01796 lpReportInfo_DC01796) {
        reportAsync(12, lpReportInfo_DC01796, false, false);
    }

    public void reportToDC02216(LpReportInfo_dc02216 lpReportInfo_dc02216, boolean z16, boolean z17) {
        reportAsync(40, lpReportInfo_dc02216, z16, z17);
    }

    public void reportToDC02293(LpReportInfo_DC02293 lpReportInfo_DC02293) {
        reportAsync(21, lpReportInfo_DC02293, false, false);
    }

    public void reportToDC02349(LpReportInfo_dc02349 lpReportInfo_dc02349, boolean z16, boolean z17) {
        reportAsync(22, lpReportInfo_dc02349, z16, z17);
    }

    public void reportToDC02467(LpReportInfo_dc02467 lpReportInfo_dc02467, boolean z16, boolean z17) {
        reportAsync(29, lpReportInfo_dc02467, z16, z17);
    }

    public void reportToDC02543(LpReportInfo_DC02543 lpReportInfo_DC02543) {
        reportAsync(32, lpReportInfo_DC02543, false, false);
    }

    public void reportToDC02727(LpReportInfo_dc02727 lpReportInfo_dc02727, boolean z16, boolean z17) {
        reportAsync(35, lpReportInfo_dc02727, z16, z17);
    }

    public void reportToDC02795(LpReportInfo_dc02795 lpReportInfo_dc02795, boolean z16, boolean z17) {
        reportAsync(39, lpReportInfo_dc02795, z16, z17);
    }

    public void reportToDC02880(LpReportInfo_dc02880 lpReportInfo_dc02880, boolean z16, boolean z17) {
        reportAsync(43, lpReportInfo_dc02880, z16, z17);
    }

    public void reportToDC02910(LpreportInfo_dc02910 lpreportInfo_dc02910, boolean z16, boolean z17) {
        reportAsync(42, lpreportInfo_dc02910, z16, z17);
    }

    public void reportToDC03179(LpReport_dc03179 lpReport_dc03179, boolean z16, boolean z17) {
        reportAsync(45, lpReport_dc03179, z16, z17);
    }

    public void reportToDC03208(LpReport_Retention_dc03208 lpReport_Retention_dc03208, boolean z16, boolean z17) {
        reportAsync(47, lpReport_Retention_dc03208, z16, z17);
    }

    public void reportToDC03701(LpReportInfo_dc03701 lpReportInfo_dc03701, boolean z16, boolean z17) {
        reportAsync(50, lpReportInfo_dc03701, z16, z17);
    }

    public void reportToDC03950(LpReportInfo_dc03950 lpReportInfo_dc03950, boolean z16, boolean z17) {
        reportAsync(56, lpReportInfo_dc03950, z16, z17);
    }

    public void reportToDC04021(LpReportInfo_dc04021 lpReportInfo_dc04021, boolean z16, boolean z17) {
        reportAsync(51, lpReportInfo_dc04021, z16, z17);
    }

    public void reportToDC04171(LpReportInfo_dc04171 lpReportInfo_dc04171, boolean z16, boolean z17) {
        reportAsync(52, lpReportInfo_dc04171, z16, z17);
    }

    public void reportToDC04233(LpReportInfo_dc04233 lpReportInfo_dc04233, boolean z16, boolean z17) {
        reportAsync(53, lpReportInfo_dc04233, z16, z17);
    }

    public void reportToDC04586(LpReportInfo_dc04586 lpReportInfo_dc04586, boolean z16, boolean z17) {
        reportAsync(58, lpReportInfo_dc04586, z16, z17);
    }

    public void reportToPF00064(LpReportInfo_pf00064 lpReportInfo_pf00064) {
        reportToPF00064(lpReportInfo_pf00064, true, false);
    }

    public void startReportImediately(final int i3) {
        if (Looper.myLooper() != null && Looper.myLooper() == Looper.getMainLooper()) {
            if (MobileQQ.sProcessId == 1) {
                ThreadManagerV2.excute(new Runnable() { // from class: cooperation.qzone.report.lp.LpReportManager.2
                    @Override // java.lang.Runnable
                    public void run() {
                        LpReportManager.this.report(i3);
                    }
                }, 64, null, true);
                return;
            } else {
                QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.ReportThread).post(new Runnable() { // from class: cooperation.qzone.report.lp.LpReportManager.3
                    @Override // java.lang.Runnable
                    public void run() {
                        LpReportManager.this.report(i3);
                    }
                });
                return;
            }
        }
        report(i3);
    }

    public void reportToPF00064(LpReportInfo_pf00064 lpReportInfo_pf00064, boolean z16) {
        reportToPF00064(lpReportInfo_pf00064, z16, false);
    }

    public void reportToPF00064(LpReportInfo_pf00064 lpReportInfo_pf00064, boolean z16, boolean z17) {
        reportAsync(0, lpReportInfo_pf00064, z16, z17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void report(int i3) {
        ArrayList<REPORT_INFO> infos;
        if (i3 == 1 && QzoneConfig.getInstance().getConfig("ClientReport", QzoneConfig.SECONDARY_CLICKREPORT_IMEDIATELY, 0) == 1) {
            synchronized (this.storedClicks) {
                if (!LpReportUtils.meetCondition(this.storedClicks, startTime)) {
                    return;
                }
            }
        }
        if (this.storedClicks.isEmpty()) {
            return;
        }
        synchronized (this.storedClicks) {
            infos = this.storedClicks.getInfos();
            this.storedClicks.clear();
            startTime = SystemClock.uptimeMillis();
        }
        LpReportNewIntent lpReportNewIntent = new LpReportNewIntent(MobileQQ.sMobileQQ, LpReportServlet.class);
        lpReportNewIntent.type = 33L;
        lpReportNewIntent.info = null;
        lpReportNewIntent.extra_info = null;
        lpReportNewIntent.multi_info = infos;
        ((ILpReportUtils) QRoute.api(ILpReportUtils.class)).startServlet(lpReportNewIntent);
    }
}
