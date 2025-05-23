package ny3;

import android.app.Activity;
import android.os.Build;
import com.tencent.feedback.eup.CrashReport;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.crash.QQCrashReportManager;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.Foreground;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes25.dex */
public class b {

    /* renamed from: b, reason: collision with root package name */
    private static volatile b f421591b;

    /* renamed from: a, reason: collision with root package name */
    private CopyOnWriteArrayList<a> f421592a = new CopyOnWriteArrayList<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        WeakReference<Activity> f421593a;

        /* renamed from: b, reason: collision with root package name */
        String f421594b;

        /* renamed from: c, reason: collision with root package name */
        long f421595c = System.currentTimeMillis();

        a(Activity activity) {
            this.f421593a = new WeakReference<>(activity);
            this.f421594b = activity.getClass().getName();
        }

        boolean a(Activity activity, long j3) {
            Activity activity2;
            boolean z16;
            if (activity == null) {
                return false;
            }
            if (!this.f421593a.isEnqueued()) {
                activity2 = this.f421593a.get();
            } else {
                activity2 = null;
            }
            if (activity2 != null && activity2 == activity) {
                return true;
            }
            if (this.f421594b.equalsIgnoreCase(activity.getClass().getName())) {
                if (Math.abs(j3 - this.f421595c) < 20000) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    return true;
                }
            }
            return false;
        }
    }

    private synchronized void a(Activity activity) {
        if (activity == null) {
            return;
        }
        this.f421592a.add(new a(activity));
    }

    private synchronized boolean b(Activity activity, long j3) {
        boolean z16 = false;
        if (activity == null) {
            return false;
        }
        Iterator<a> it = this.f421592a.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            if (it.next().a(activity, j3)) {
                z16 = true;
                break;
            }
        }
        return z16;
    }

    public static b e() {
        if (f421591b == null) {
            f421591b = new b();
        }
        return f421591b;
    }

    private void f(Activity activity, long j3, boolean z16) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("crashUin", QQCrashReportManager.f363157a);
        hashMap.put(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, activity.getLocalClassName());
        hashMap.put("crashTime", new SimpleDateFormat("MM.dd HH:mm:ss.SSS").format(new Date(j3)));
        hashMap.put("crashTimelong", j3 + "");
        hashMap.put("isFind", z16 + "");
        StatisticCollector.getInstance(MobileQQ.sMobileQQ).collectPerformance(QQCrashReportManager.f363157a, "badtoken_crash_monitor", true, 0L, 0L, hashMap, "", false);
    }

    private void g(Activity activity, long j3) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("crashUin", QQCrashReportManager.f363157a);
        hashMap.put(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, activity.getLocalClassName());
        hashMap.put("crashTime", new SimpleDateFormat("MM.dd HH:mm:ss.SSS").format(new Date(j3)));
        hashMap.put("crashTimelong", j3 + "");
        StatisticCollector.getInstance(MobileQQ.sMobileQQ).collectPerformance(QQCrashReportManager.f363157a, "activity_resume_has_destroy_monitor", true, 0L, 0L, hashMap, "", false);
    }

    public void c(Activity activity) {
        boolean z16;
        if (Build.VERSION.SDK_INT > 28 || activity == null) {
            return;
        }
        if ((activity.getIntent().getFlags() & 1073741824) != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            QLog.e("BadTokenIssueHelper", 1, "doOnActivityPostResumeEnd topActivity isNoHistory is true");
        }
        my3.a a16 = my3.b.b().a();
        if ((a16.g() || ly3.a.f415786a.booleanValue()) && com.tencent.qqperf.monitor.crash.tools.c.a(activity)) {
            g(activity, System.currentTimeMillis());
            QLog.e("BadTokenIssueHelper", 1, "doOnActivityResumeEnd find DestroyTimeOutMsg " + activity);
            a(activity);
            if (a16.h()) {
                activity.finish();
            } else {
                QLog.e("BadTokenIssueHelper", 1, "doOnActivityResumeEnd isBadTokenActivityFinishSwitch is false.");
            }
        }
    }

    public void d(String str, String str2, long j3) {
        boolean z16;
        boolean z17;
        boolean b16 = com.tencent.qqperf.monitor.crash.tools.c.b(str, str2);
        Activity topActivity = Foreground.getTopActivity();
        if (Build.VERSION.SDK_INT > 28) {
            return;
        }
        boolean z18 = false;
        if (!my3.b.b().a().g() && !ly3.a.f415786a.booleanValue()) {
            z16 = false;
        } else {
            z16 = true;
        }
        CrashReport.putUserData(BaseApplication.getContext(), "isActivityResumeWithDestoryMsgCheckSwitch", "" + z16);
        if (b16 && z16 && topActivity != null) {
            if ((topActivity.getIntent().getFlags() & 1073741824) != 0) {
                z18 = true;
            }
            boolean b17 = b(topActivity, j3);
            f(topActivity, j3, b17);
            boolean z19 = z18;
            z18 = b17;
            z17 = z19;
        } else {
            z17 = false;
        }
        QLog.e("BadTokenIssueHelper", 1, "BadToken Crash info is topActivity is " + topActivity + "| isFinded = " + z18 + "| isActivityResumeWithDestoryMsgCheckSwitch = " + z16 + "| isNoHistory = " + z17);
    }
}
