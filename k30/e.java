package k30;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import feedcloud.FeedCloudCommon$StCommonExt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import qqcircle.QQCircleFeedBase$StTabInfo;

/* compiled from: P */
/* loaded from: classes4.dex */
public class e {

    /* renamed from: j, reason: collision with root package name */
    private static volatile e f411466j;

    /* renamed from: e, reason: collision with root package name */
    private int f411471e;

    /* renamed from: f, reason: collision with root package name */
    private b f411472f;

    /* renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<String, a> f411467a = new ConcurrentHashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private final long f411468b = uq3.c.t3() * 1000;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f411469c = uq3.c.y3();

    /* renamed from: d, reason: collision with root package name */
    private int f411470d = QCirclePluginGlobalInfo.n();

    /* renamed from: g, reason: collision with root package name */
    private long f411473g = 0;

    /* renamed from: h, reason: collision with root package name */
    private long f411474h = System.currentTimeMillis();

    /* renamed from: i, reason: collision with root package name */
    private final Runnable f411475i = new Runnable() { // from class: k30.c
        @Override // java.lang.Runnable
        public final void run() {
            e.this.l();
        }
    };

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private int f411476a;

        /* renamed from: b, reason: collision with root package name */
        private int f411477b;

        /* renamed from: c, reason: collision with root package name */
        private QQCircleFeedBase$StTabInfo f411478c;

        /* renamed from: d, reason: collision with root package name */
        private ArrayList<e30.b> f411479d = null;

        /* renamed from: e, reason: collision with root package name */
        private boolean f411480e = false;

        /* renamed from: f, reason: collision with root package name */
        private FeedCloudCommon$StCommonExt f411481f = null;

        /* renamed from: g, reason: collision with root package name */
        private String f411482g = null;

        /* renamed from: h, reason: collision with root package name */
        private String f411483h = null;

        /* renamed from: i, reason: collision with root package name */
        private boolean f411484i = false;

        public static a o(k30.a aVar, int i3, int i16) {
            if (aVar == null) {
                QLog.d("QCircleFolderCacheHelper", 1, "wrap failed!model is null");
                return null;
            }
            a aVar2 = new a();
            QQCircleFeedBase$StTabInfo G = aVar.G();
            Collection<e30.b> s16 = aVar.s1();
            boolean U = aVar.U();
            FeedCloudCommon$StCommonExt extInfo = aVar.getExtInfo();
            String o06 = aVar.o0();
            String E1 = aVar.E1();
            if (G != null && s16 != null && !s16.isEmpty()) {
                if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_memory_feed_save_check_attach_info", false) && TextUtils.isEmpty(o06)) {
                    QLog.d("QCircleFolderCacheHelper", 1, "wrap failed!feedAttachInfo is null!");
                    return null;
                }
                aVar2.f411476a = i3;
                aVar2.f411477b = i16;
                aVar2.f411478c = G;
                ArrayList<e30.b> arrayList = new ArrayList<>();
                aVar2.f411479d = arrayList;
                arrayList.addAll(s16);
                aVar2.f411480e = U;
                aVar2.f411481f = extInfo;
                aVar2.f411482g = o06;
                aVar2.f411483h = E1;
                QLog.d("QCircleFolderCacheHelper", 1, "wrap success!");
                return aVar2;
            }
            QLog.d("QCircleFolderCacheHelper", 1, "wrap failed!miss key data!");
            return null;
        }

        public FeedCloudCommon$StCommonExt d() {
            return this.f411481f;
        }

        public String e() {
            return this.f411482g;
        }

        public ArrayList<e30.b> f() {
            return this.f411479d;
        }

        public boolean g() {
            return this.f411480e;
        }

        public int h() {
            return this.f411476a;
        }

        public String i() {
            return this.f411483h;
        }

        public QQCircleFeedBase$StTabInfo j() {
            return this.f411478c;
        }

        public int k() {
            return this.f411477b;
        }

        public boolean l() {
            return this.f411484i;
        }

        public void m(List<e30.b> list) {
            ArrayList<e30.b> arrayList = new ArrayList<>();
            this.f411479d = arrayList;
            arrayList.addAll(list);
        }

        public void n(boolean z16) {
            this.f411484i = z16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private final int f411485a;

        /* renamed from: b, reason: collision with root package name */
        private final String f411486b;

        /* renamed from: c, reason: collision with root package name */
        private final String f411487c;

        /* renamed from: d, reason: collision with root package name */
        private final int f411488d;

        public b(int i3, String str, int i16, String str2) {
            this.f411485a = i3;
            this.f411486b = str2;
            this.f411488d = i16;
            this.f411487c = str;
        }

        public String a() {
            return this.f411487c;
        }

        public String b() {
            return this.f411486b;
        }

        public int c() {
            return this.f411488d;
        }

        public int d() {
            return this.f411485a;
        }

        public String toString() {
            return "VideoInfoCache{mVideoProcess=" + this.f411485a + ", mFeedId='" + this.f411486b + "', mCoverUrl='" + this.f411487c + "', mPos=" + this.f411488d + '}';
        }
    }

    public static e i() {
        if (f411466j == null) {
            synchronized (e.class) {
                if (f411466j == null) {
                    f411466j = new e();
                }
            }
        }
        return f411466j;
    }

    private boolean k() {
        if (System.currentTimeMillis() - this.f411474h > this.f411468b) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l() {
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: k30.d
            @Override // java.lang.Runnable
            public final void run() {
                e.this.b();
            }
        });
    }

    public static void r() {
        QLog.d("QCircleFolderCacheHelper", 1, "releaseInstance");
        if (f411466j != null) {
            synchronized (e.class) {
                if (f411466j != null) {
                    f411466j = null;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b() {
        if (j()) {
            d();
            return true;
        }
        return false;
    }

    boolean c() {
        if (this.f411467a.isEmpty()) {
            d();
            return true;
        }
        return false;
    }

    public void d() {
        QLog.d("QCircleFolderCacheHelper", 1, "clearPageCache");
        this.f411467a.clear();
    }

    public void e() {
        this.f411472f = null;
    }

    public void f() {
        d();
        this.f411473g = 0L;
    }

    boolean g(@NonNull k30.a aVar) {
        a aVar2;
        QQCircleFeedBase$StTabInfo G = aVar.G();
        if (G != null) {
            String str = G.tabName.get();
            if (this.f411467a.containsKey(str) && (aVar2 = this.f411467a.get(str)) != null) {
                aVar.Q0(aVar2);
                if (aVar.M(aVar2)) {
                    QLog.d("QCircleFolderCacheHelper", 1, "readPageCache success\uff01tapid:" + str + ",pos:" + aVar2.f411476a + ",top:" + aVar2.f411477b);
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    boolean h(@NonNull k30.a aVar, int i3, int i16) {
        a o16 = a.o(aVar, i3, i16);
        if (o16 != null) {
            String str = o16.f411478c.tabName.get();
            this.f411467a.put(str, o16);
            QLog.d("QCircleFolderCacheHelper", 1, "savePageCache success\uff01tapid:" + str);
            return true;
        }
        return false;
    }

    public boolean j() {
        boolean z16;
        long currentTimeMillis = System.currentTimeMillis() - this.f411473g;
        if (this.f411469c && currentTimeMillis <= this.f411468b) {
            z16 = true;
        } else {
            z16 = false;
        }
        return !z16;
    }

    public int m() {
        QLog.d("QCircleFolderCacheHelper", 1, "readLastShowTabTypeCache mLastShowTabType:" + this.f411470d);
        int i3 = this.f411470d;
        this.f411470d = -1;
        return i3;
    }

    public boolean n(@NonNull k30.a aVar) {
        QLog.d("QCircleFolderCacheHelper", 1, "readPageCache");
        if (b()) {
            QLog.d("QCircleFolderCacheHelper", 1, "readPageCache fail,checkCacheAlive cache not alive");
            return false;
        }
        if (c()) {
            QLog.d("QCircleFolderCacheHelper", 1, "readPageCache fail,page cache is null");
            return false;
        }
        if (g(aVar)) {
            return true;
        }
        QLog.d("QCircleFolderCacheHelper", 1, "readPageCache fail,page cache is null or init error");
        return false;
    }

    public int o() {
        QLog.d("QCircleFolderCacheHelper", 1, "readPersonalDetailActiveCache: mPersonalDetailActive" + this.f411471e);
        int i3 = this.f411471e;
        this.f411471e = 0;
        return i3;
    }

    public b p() {
        QLog.d("QCircleFolderCacheHelper", 1, "readVideoInfoCache: mVideoInfoCache" + this.f411472f);
        return this.f411472f;
    }

    protected void q() {
        this.f411473g = System.currentTimeMillis();
        RFWThreadManager.getInstance().getSerialThreadHandler().removeCallbacks(this.f411475i);
        RFWThreadManager.getInstance().getSerialThreadHandler().postDelayed(this.f411475i, this.f411468b);
    }

    public void s(@NonNull k30.a aVar, int i3, int i16) {
        if (!this.f411469c) {
            QLog.d("QCircleFolderCacheHelper", 1, "savePageCache fail,disable page cache,direct return!");
            return;
        }
        if (k()) {
            QLog.d("QCircleFolderCacheHelper", 1, "savePageCache fail,idle over alive time,clean cache!");
            this.f411473g = 0L;
            d();
            return;
        }
        QLog.d("QCircleFolderCacheHelper", 1, "savePageCache,pos:" + i3 + ",top:" + i16);
        if (h(aVar, i3, i16)) {
            q();
            return;
        }
        QLog.d("QCircleFolderCacheHelper", 1, "savePageCache failed!");
        this.f411473g = 0L;
        d();
    }

    public void t(int i3) {
        this.f411471e = i3;
        QLog.d("QCircleFolderCacheHelper", 1, "savePersonalDetailActiveCache personalDetailActive:" + i3);
    }

    public void u(int i3) {
        if (!this.f411469c) {
            QLog.d("QCircleFolderCacheHelper", 1, "saveTabInfoCache() disable tab info cache,direct return!");
            return;
        }
        if (k()) {
            QLog.d("QCircleFolderCacheHelper", 1, "saveTabInfoCache fail,idle over alive time,clean cache!");
            this.f411473g = 0L;
            return;
        }
        this.f411470d = i3;
        q();
        QLog.d("QCircleFolderCacheHelper", 1, "saveTabInfoCache currentShowTabType:" + i3);
    }

    public void v(b bVar) {
        this.f411472f = bVar;
        QLog.d("QCircleFolderCacheHelper", 1, "saveVideoInfoCache mVideoInfoCache:" + bVar);
    }

    public void w() {
        QLog.d("QCircleFolderCacheHelper", 1, "updateLastIdleTimeStamp");
        this.f411474h = System.currentTimeMillis();
    }
}
