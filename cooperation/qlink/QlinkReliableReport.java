package cooperation.qlink;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QlinkReliableReport {

    /* renamed from: d, reason: collision with root package name */
    private static QlinkReliableReport f390436d;

    /* renamed from: a, reason: collision with root package name */
    private final Object f390437a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private List<a> f390438b;

    /* renamed from: c, reason: collision with root package name */
    private Runnable f390439c;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private String f390440a;

        /* renamed from: b, reason: collision with root package name */
        private String f390441b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f390442c;

        /* renamed from: d, reason: collision with root package name */
        private long f390443d;

        /* renamed from: e, reason: collision with root package name */
        private long f390444e;

        /* renamed from: f, reason: collision with root package name */
        private HashMap<String, String> f390445f;

        public a(String str, String str2, boolean z16, long j3, long j16, HashMap<String, String> hashMap) {
            this.f390440a = str;
            this.f390441b = str2;
            this.f390442c = z16;
            this.f390443d = j3;
            this.f390444e = j16;
            this.f390445f = hashMap;
        }

        public long a() {
            return this.f390443d;
        }

        public HashMap<String, String> b() {
            return this.f390445f;
        }

        public long c() {
            return this.f390444e;
        }

        public String d() {
            return this.f390441b;
        }

        public String e() {
            return this.f390440a;
        }

        public boolean f() {
            return this.f390442c;
        }

        public String toString() {
            return "uin[" + this.f390440a + "], tagName[" + this.f390441b + "], success[" + this.f390442c + "], size[" + this.f390444e + "]" + this.f390442c;
        }
    }

    private void c(a aVar) {
        if (QLog.isDevelopLevel()) {
            QLog.d("QlinkReliableReport", 2, "addPerformanceReporting:" + aVar);
        }
        synchronized (this.f390437a) {
            if (this.f390438b == null) {
                this.f390438b = new ArrayList();
            }
            this.f390438b.add(aVar);
        }
    }

    public static void d(String str, String str2, boolean z16, long j3, long j16, HashMap<String, String> hashMap) {
        if (QLog.isDevelopLevel()) {
            QLog.d("QlinkReliableReport", 2, "collectPerformance:tagName[" + str2 + "]");
        }
        QlinkReliableReport i3 = i();
        if (i3 != null) {
            i3.c(new a(str, str2, z16, j3, j16, hashMap));
        }
    }

    private void f() {
        List<a> list;
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            if (QLog.isDevelopLevel()) {
                QLog.d("QlinkReliableReport", 2, "doReportPerformance: network is not surpport");
                return;
            }
            return;
        }
        synchronized (this.f390437a) {
            list = this.f390438b;
            this.f390438b = null;
        }
        if (list != null && list.size() != 0) {
            StatisticCollector statisticCollector = StatisticCollector.getInstance(BaseApplication.getContext());
            for (a aVar : list) {
                statisticCollector.collectPerformance(aVar.e(), aVar.d(), aVar.f(), aVar.a(), aVar.c(), aVar.b(), null);
            }
            list.clear();
        }
    }

    public static QlinkReliableReport i() {
        if (f390436d == null) {
            synchronized ("QlinkReliableReport") {
                if (f390436d == null) {
                    f390436d = new QlinkReliableReport();
                }
            }
        }
        return f390436d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void k() {
        if (QLog.isDevelopLevel()) {
            QLog.d("QlinkReliableReport", 2, "start:");
        }
        QlinkReliableReport i3 = i();
        if (i3 != null) {
            i3.f();
        }
    }

    public static void l() {
        QlinkReliableReport i3 = i();
        if (i3 != null) {
            i3.g();
        }
    }

    public static void m() {
        QlinkReliableReport i3 = i();
        if (i3 != null) {
            i3.h();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e() {
        h();
        synchronized ("QlinkReliableReport") {
            f390436d = null;
        }
    }

    public void g() {
        QLog.d("QlinkReliableReport", 2, "doStartReportTimer");
        if (this.f390439c == null) {
            this.f390439c = new Runnable() { // from class: cooperation.qlink.QlinkReliableReport.1
                @Override // java.lang.Runnable
                public void run() {
                    QLog.d("QlinkReliableReport", 2, "doStopReportTimer :  on timer");
                    QlinkReliableReport.this.f390439c = null;
                    QlinkReliableReport.k();
                }
            };
            ThreadManager.getSubThreadHandler().postDelayed(this.f390439c, 60000L);
        }
    }

    public void h() {
        QLog.d("QlinkReliableReport", 2, "doStopReportTimer");
        if (this.f390439c != null) {
            ThreadManager.getSubThreadHandler().removeCallbacks(this.f390439c);
            this.f390439c = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j() {
    }
}
