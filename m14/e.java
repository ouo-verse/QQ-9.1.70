package m14;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.bugly.common.meta.UserMeta;
import com.tencent.bugly.common.privacy.PrivacyInformation;
import com.tencent.bugly.common.sp.ISharedPreferencesProvider;
import com.tencent.bugly.common.sp.SharedPreferencesProvider;
import com.tencent.bugly.common.utils.ContextUtil;
import com.tencent.bugly.library.BuglyAppVersionMode;
import com.tencent.rmonitor.base.config.ConfigProxy;
import com.tencent.rmonitor.base.meta.BaseInfo;
import com.tencent.rmonitor.base.plugin.listener.IBaseListener;
import com.tencent.rmonitor.base.plugin.listener.IBatteryListener;
import com.tencent.rmonitor.base.plugin.listener.ICustomDataCollector;
import com.tencent.rmonitor.base.plugin.listener.ICustomDataCollectorForIssue;
import com.tencent.rmonitor.base.plugin.listener.IDBTracerListener;
import com.tencent.rmonitor.base.plugin.listener.IDeviceInfoListener;
import com.tencent.rmonitor.base.plugin.listener.IDropFrameListener;
import com.tencent.rmonitor.base.plugin.listener.IIoTracerListener;
import com.tencent.rmonitor.base.plugin.listener.ILooperListener;
import com.tencent.rmonitor.base.plugin.listener.IMemoryCeilingListener;
import com.tencent.rmonitor.base.plugin.listener.IMemoryLeakListener;
import com.tencent.rmonitor.base.plugin.listener.IMemoryPeakListener;
import com.tencent.rmonitor.base.plugin.listener.IPluginStateListener;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.rmonitor.common.util.CrashProtector;

/* compiled from: P */
/* loaded from: classes25.dex */
public class e {

    /* renamed from: d, reason: collision with root package name */
    private static e f416009d;

    /* renamed from: a, reason: collision with root package name */
    private final SparseArray<m14.c> f416010a;

    /* renamed from: b, reason: collision with root package name */
    private final SparseArray<m14.a> f416011b;

    /* renamed from: c, reason: collision with root package name */
    private final SparseArray<m14.b> f416012c;

    /* compiled from: P */
    /* loaded from: classes25.dex */
    static class a implements m14.c {
        a() {
        }

        @Override // m14.c
        public boolean b(String str) {
            if (str == null) {
                str = "";
            }
            BaseInfo.userMeta.appId = str;
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    static class b implements m14.c {
        b() {
        }

        @Override // m14.c
        public boolean b(String str) {
            if (str == null) {
                str = "";
            }
            BaseInfo.userMeta.appKey = str;
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    static class c implements m14.c {
        c() {
        }

        private boolean a(String str) {
            String[] strArr = {"Unknown", "Gray", BuglyAppVersionMode.RELEASE, BuglyAppVersionMode.DEBUG};
            for (int i3 = 0; i3 < 4; i3++) {
                if (TextUtils.equals(str, strArr[i3])) {
                    return true;
                }
            }
            return false;
        }

        @Override // m14.c
        public boolean b(String str) {
            if (a(str)) {
                BaseInfo.userMeta.appVersionMode = str;
                ConfigProxy.INSTANCE.getConfig().s();
                return true;
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    static class d implements m14.c {
        d() {
        }

        @Override // m14.c
        public boolean b(String str) {
            if (!TextUtils.isEmpty(str)) {
                com.tencent.rmonitor.common.util.b.f365535j.g(str);
                ConfigProxy.INSTANCE.getConfig().s();
                return true;
            }
            return false;
        }
    }

    /* compiled from: P */
    /* renamed from: m14.e$e, reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    static class C10757e implements m14.a {
        C10757e() {
        }

        @Override // m14.a
        public boolean a(Object obj) {
            boolean z16;
            if (obj instanceof Application) {
                BaseInfo.app = (Application) obj;
                ContextUtil.setGlobalContext((Context) obj);
                z16 = true;
            } else {
                z16 = false;
            }
            if (obj == null || !z16) {
                Logger.f365497g.w("RMonitor_manager_Property", "AppInstance is not instance of android.app.Application.");
            }
            return z16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    static class f implements m14.c {
        f() {
        }

        @Override // m14.c
        public boolean b(String str) {
            if ("force_refresh_config".equals(str)) {
                ConfigProxy.INSTANCE.getConfig().s();
                return true;
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    static class g implements m14.c {
        g() {
        }

        @Override // m14.c
        public boolean b(String str) {
            if ("v7".equalsIgnoreCase(str)) {
                ConfigProxy.INSTANCE.getConfig().v("CONFIG_USE_V7", true);
                return true;
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    static class h implements m14.a {
        h() {
        }

        @Override // m14.a
        public boolean a(Object obj) {
            CrashProtector.b(((Boolean) obj).booleanValue());
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    static class i implements m14.c {
        i() {
        }

        @Override // m14.c
        public boolean b(String str) {
            if (!TextUtils.isEmpty(str)) {
                PrivacyInformation.getInstance().setModel(str);
                ConfigProxy.INSTANCE.getConfig().s();
                return true;
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    static class j implements m14.c, m14.a {
        j() {
        }

        @Override // m14.a
        public boolean a(Object obj) {
            try {
                Logger.f365497g.k(((Integer) obj).intValue());
                return true;
            } catch (Throwable th5) {
                Logger.f365497g.c("RMonitor_manager_Property", th5);
                return false;
            }
        }

        @Override // m14.c
        public boolean b(String str) {
            try {
                Logger.f365497g.k(Integer.parseInt(str));
                return true;
            } catch (Throwable th5) {
                Logger.f365497g.c("RMonitor_manager_Property", th5);
                return false;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    static class k implements m14.c {
        k() {
        }

        @Override // m14.c
        public boolean b(String str) {
            if (!TextUtils.isEmpty(str)) {
                com.tencent.rmonitor.common.util.b.f365535j.h(str);
                return true;
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    static class l implements m14.a {
        l() {
        }

        @Override // m14.a
        public boolean a(Object obj) {
            if (obj == null) {
                SharedPreferencesProvider.getInstance().setProvider(null);
                return true;
            }
            if (obj instanceof ISharedPreferencesProvider) {
                SharedPreferencesProvider.getInstance().setProvider((ISharedPreferencesProvider) obj);
                return true;
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    static class m implements m14.c {
        m() {
        }

        @Override // m14.c
        public boolean b(String str) {
            if (!TextUtils.isEmpty(str)) {
                BaseInfo.userMeta.setUniqueID(str);
                ConfigProxy.INSTANCE.getConfig().s();
                return true;
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    static class n implements m14.c {
        n() {
        }

        @Override // m14.c
        public boolean b(String str) {
            if (!TextUtils.isEmpty(str)) {
                UserMeta userMeta = BaseInfo.userMeta;
                if (!TextUtils.equals(str, userMeta.uin)) {
                    userMeta.uin = str;
                    ConfigProxy.INSTANCE.getConfig().s();
                    return true;
                }
            }
            return false;
        }
    }

    e() {
        SparseArray<m14.c> sparseArray = new SparseArray<>(8);
        this.f416010a = sparseArray;
        SparseArray<m14.a> sparseArray2 = new SparseArray<>(12);
        this.f416011b = sparseArray2;
        this.f416012c = new SparseArray<>(3);
        j jVar = new j();
        sparseArray.put(104, jVar);
        sparseArray.put(102, new n());
        sparseArray.put(101, new a());
        sparseArray.put(100, new b());
        sparseArray.put(103, new d());
        sparseArray.put(106, new m());
        sparseArray.put(113, new i());
        sparseArray.put(108, new f());
        sparseArray.put(109, new k());
        sparseArray.put(110, new g());
        sparseArray.put(112, new c());
        sparseArray2.put(104, jVar);
        sparseArray2.put(107, new C10757e());
        sparseArray2.put(214, new h());
        sparseArray2.put(111, new l());
        e();
    }

    public static e a() {
        if (f416009d == null) {
            synchronized (e.class) {
                if (f416009d == null) {
                    f416009d = new e();
                }
            }
        }
        return f416009d;
    }

    private void e() {
        this.f416012c.put(207, new m14.d(IIoTracerListener.class, i04.a.ioTracerListener));
        this.f416012c.put(213, new m14.d(IDBTracerListener.class, i04.a.dbTracerListener));
        this.f416012c.put(201, new m14.d(IMemoryLeakListener.class, i04.a.memoryLeakListener));
        this.f416012c.put(202, new m14.d(IMemoryCeilingListener.class, i04.a.memoryCeilingListener));
        this.f416012c.put(203, new m14.d(IDropFrameListener.class, i04.a.dropFrameListener));
        this.f416012c.put(205, new m14.d(ILooperListener.class, i04.a.looperListener));
        this.f416012c.put(210, new m14.d(IBaseListener.class, i04.a.bigBitmapListener));
        this.f416012c.put(208, new m14.d(IBaseListener.class, i04.a.fdLeakListener));
        this.f416012c.put(209, new m14.d(IBaseListener.class, i04.a.natMemListener));
        this.f416012c.put(211, new m14.d(IDeviceInfoListener.class, i04.a.deviceInfoListener));
        this.f416012c.put(212, new m14.d(IBatteryListener.class, i04.a.batteryListener));
        this.f416012c.put(215, new m14.d(IPluginStateListener.class, i04.a.pluginStateListener));
        this.f416012c.put(216, new m14.d(ICustomDataCollector.class, i04.a.customDataCollector));
        this.f416012c.put(217, new m14.d(ICustomDataCollectorForIssue.class, i04.a.customDataCollectorForIssue));
        this.f416012c.put(219, new m14.d(IMemoryPeakListener.class, i04.a.memoryPeakListener));
    }

    public m14.a b(int i3) {
        return this.f416011b.get(i3);
    }

    public m14.b c(int i3) {
        return this.f416012c.get(i3);
    }

    public m14.c d(int i3) {
        return this.f416010a.get(i3);
    }
}
