package com.tencent.tab.exp.sdk.impl;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mtt.abtestsdk.BuildConfig;
import com.tencent.tab.exp.sdk.export.config.TabEnvironment;
import com.tencent.tab.exp.sdk.export.injector.network.TabMetricsNetInfo;
import com.tencent.tab.exp.sdk.export.injector.network.b;
import com.tencent.tab.exp.sdk.impl.i;
import com.tencent.tab.exp.sdk.pbdata.DataUpdateType;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import nd4.y;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes26.dex */
public final class TabExpDataManager implements cd4.c {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    final q f374030a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    final TabExpDependInjector f374031b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    final dd4.a f374032c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    final hd4.a f374033d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    final jd4.a f374034e;

    /* renamed from: l, reason: collision with root package name */
    @Nullable
    private WeakReference<kd4.a> f374041l;

    /* renamed from: m, reason: collision with root package name */
    @NonNull
    y f374042m;

    /* renamed from: n, reason: collision with root package name */
    protected final i.c f374043n = new a();

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    private long f374036g = 0;

    /* renamed from: h, reason: collision with root package name */
    private String f374037h = "";

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    private final w f374035f = new w();

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    private final j f374038i = n();

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    private final f f374039j = l();

    /* renamed from: k, reason: collision with root package name */
    @NonNull
    final i f374040k = m();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class ExpNetworkFetchTask extends TabSoftTask<TabExpDataManager> {

        /* renamed from: e, reason: collision with root package name */
        @NonNull
        private final long f374044e;

        /* renamed from: f, reason: collision with root package name */
        @NonNull
        private final String f374045f;

        /* renamed from: h, reason: collision with root package name */
        @NonNull
        private final WeakReference<kd4.a> f374046h;

        /* compiled from: P */
        /* loaded from: classes26.dex */
        class a implements ed4.b {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ TabExpDataManager f374047a;

            a(TabExpDataManager tabExpDataManager) {
                this.f374047a = tabExpDataManager;
            }

            @Override // ed4.a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(com.tencent.tab.exp.sdk.export.injector.network.b bVar, gd4.b bVar2, TabMetricsNetInfo tabMetricsNetInfo) {
                this.f374047a.A(ExpNetworkFetchTask.this.f374044e, ExpNetworkFetchTask.this.f374045f, bVar2, tabMetricsNetInfo);
                kd4.a aVar = (kd4.a) ExpNetworkFetchTask.this.f374046h.get();
                if (aVar != null) {
                    aVar.a(bVar);
                    this.f374047a.Q(String.format("fetch----refreshListener onRefresh Finished: %s", bVar.toString()));
                }
                this.f374047a.z(tabMetricsNetInfo);
            }
        }

        protected ExpNetworkFetchTask(TabExpDataManager tabExpDataManager, @NonNull long j3, @NonNull String str, @NonNull WeakReference<kd4.a> weakReference) {
            super(tabExpDataManager);
            this.f374044e = j3;
            this.f374045f = str;
            this.f374046h = weakReference;
        }

        @Override // java.lang.Runnable
        public void run() {
            TabExpDataManager e16 = e();
            if (e16 == null) {
                return;
            }
            e16.Q("refreshData-----ExpNetworkFetchTask");
            e16.f374039j.b(this.f374044e, this.f374045f, null, new a(e16));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class ExpStorageFetchTask extends TabSoftTask<TabExpDataManager> {

        /* renamed from: e, reason: collision with root package name */
        private final WeakReference<kd4.a> f374049e;

        protected ExpStorageFetchTask(TabExpDataManager tabExpDataManager, @NonNull WeakReference<kd4.a> weakReference) {
            super(tabExpDataManager);
            this.f374049e = weakReference;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i3;
            String str;
            TabExpDataManager e16 = e();
            if (e16 == null) {
                return;
            }
            e16.Q("refreshData-----ExpStorageFetchTask");
            boolean p16 = e16.p();
            if (p16) {
                i3 = 1;
            } else {
                i3 = -1;
            }
            if (p16) {
                str = "\u8bf7\u6c42\u6210\u529f";
            } else {
                str = "\u8bf7\u6c42\u5931\u8d25";
            }
            com.tencent.tab.exp.sdk.export.injector.network.b e17 = new b.C9878b().h(i3).i(str).e();
            kd4.a aVar = this.f374049e.get();
            if (aVar != null) {
                aVar.a(e17);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class InitTask extends TabSoftTask<TabExpDataManager> {
        /* synthetic */ InitTask(TabExpDataManager tabExpDataManager, TabExpDataManager tabExpDataManager2, a aVar) {
            this(tabExpDataManager2);
        }

        @Override // java.lang.Runnable
        public void run() {
            TabExpDataManager e16 = e();
            if (e16 == null) {
                return;
            }
            e16.K();
            TabExpDataManager.this.J();
        }

        InitTask(TabExpDataManager tabExpDataManager) {
            super(tabExpDataManager);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class a implements i.c {
        a() {
        }

        @Override // com.tencent.tab.exp.sdk.impl.i.c
        public void a(int i3) {
            if (i3 == 1) {
                TabExpDataManager.this.Q("onHandleRollMessage-----DATA_ROLL_MSG");
                TabExpDataManager.this.R(null, TabExpDataManager.this.v(), TabExpDataManager.this.w());
                TabExpDataManager.this.U();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f374051a;

        static {
            int[] iArr = new int[TabMetricsNetInfo.RecordType.values().length];
            f374051a = iArr;
            try {
                iArr[TabMetricsNetInfo.RecordType.RECORD_SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f374051a[TabMetricsNetInfo.RecordType.RECORD_TIMEOUT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f374051a[TabMetricsNetInfo.RecordType.RECORD_FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TabExpDataManager(@NonNull q qVar, @NonNull TabExpDependInjector tabExpDependInjector) {
        this.f374030a = qVar;
        this.f374031b = tabExpDependInjector;
        this.f374032c = tabExpDependInjector.getLogImpl();
        this.f374033d = tabExpDependInjector.getReportImpl();
        this.f374034e = tabExpDependInjector.getThreadImpl();
        I();
    }

    private void B(Object obj) {
        boolean z16;
        e q16 = this.f374039j.q(obj);
        if (q16 != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        Q("handleResponseControlInfo-----" + q16 + ", isResponseControlInfo = " + z16);
        if (z16) {
            this.f374038i.H(q16);
        }
    }

    private void C(Object obj, TabMetricsNetInfo tabMetricsNetInfo) {
        long currentTimeMillis = System.currentTimeMillis();
        ConcurrentHashMap<String, k> p16 = this.f374039j.p(obj);
        List<String> s16 = this.f374039j.s(obj);
        if (tabMetricsNetInfo != null) {
            tabMetricsNetInfo.j((float) (System.currentTimeMillis() - currentTimeMillis));
        }
        if (p16 != null && s16 != null) {
            this.f374038i.I(p16, s16, this.f374039j.r(obj));
        } else {
            Q("  handleResponseData-----responseAddOrUpdateMap or responseDeletedList null");
        }
    }

    private void E(Object obj) {
        long t16 = this.f374039j.t(obj);
        Q("handleResponseModifyVersion-----responseModifyVersion = " + t16);
        Z(t16);
        this.f374038i.L(t16);
    }

    private void F(Object obj) {
        String u16 = this.f374039j.u(obj);
        Q("handleResponseSnapshotVersion-----responseSnapshotVersion = " + u16);
        a0(u16);
        this.f374038i.M(u16);
    }

    private void H() {
        this.f374038i.O();
        Q("handleTrimStorage");
    }

    private void I() {
        o(new InitTask(this, this, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        nd4.r b16 = nd4.s.c().b(x.f(this.f374030a.f(), this.f374030a.n()));
        if (b16 != null) {
            this.f374042m = (y) b16.a("tab_metrics");
        }
    }

    private boolean L(String str) {
        return !TextUtils.isEmpty(str);
    }

    private boolean M() {
        boolean R = this.f374038i.R();
        Q("isEnableReport is " + R);
        return R;
    }

    private boolean O(long j3, String str, Object obj) {
        if (!P()) {
            Q("isNeedToHandleResponse-----return false by is not using");
            return false;
        }
        if (!this.f374039j.m(obj)) {
            Q("isNeedToHandleResponse-----return false by is not responseSuccess");
            return false;
        }
        if (j3 == 0) {
            Q("isNeedToHandleResponse-----return true by is defaultModifyVersion 0L");
            return true;
        }
        if (DataUpdateType.DATA_UPDATE_TYPE_NO_NEED == this.f374039j.r(obj)) {
            Q("isNeedToHandleResponse-----return false by responseDataUpdateType not need to upgrade");
            return false;
        }
        String w3 = this.f374038i.w();
        String u16 = this.f374039j.u(obj);
        if (!TextUtils.equals(w3, u16)) {
            Q(String.format("isNeedToHandleResponse-----return true by memorySnapshotVersion is %s not equal responseSnapshotVersion = %s", w3, u16));
            return true;
        }
        long v3 = this.f374038i.v();
        long t16 = this.f374039j.t(obj);
        if (v3 < t16) {
            return true;
        }
        Q("isNeedToHandleResponse-----return false by responseModifyVersion not upgrade, memoryModifyVersion = " + v3 + ", responseModifyVersion = " + t16);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(@Nullable kd4.a aVar, long j3, String str) {
        WeakReference weakReference = new WeakReference(aVar);
        if (this.f374030a.e()) {
            o(new ExpNetworkFetchTask(this, j3, str, weakReference));
        } else {
            o(new ExpStorageFetchTask(this, weakReference));
        }
    }

    private boolean S(boolean z16, k kVar) {
        if (z16 && M()) {
            return h.b(this.f374033d, this.f374030a, kVar, P(), u());
        }
        return false;
    }

    private boolean T(k kVar) {
        if (M()) {
            return h.c(this.f374033d, this.f374030a, kVar, P(), u());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void U() {
        this.f374040k.f();
        this.f374040k.g(1, x() * 1000);
    }

    private synchronized void V(@Nullable kd4.a aVar) {
        WeakReference<kd4.a> weakReference = this.f374041l;
        if (weakReference != null) {
            weakReference.clear();
            this.f374041l = null;
        }
        this.f374041l = new WeakReference<>(aVar);
        Q("setStartUseRefreshListener-----finish");
    }

    private synchronized void X(@Nullable kd4.a aVar) {
        this.f374038i.q0();
        this.f374039j.w();
        this.f374040k.h();
        R(aVar, v(), w());
        U();
        Q("startUseInternal-----finish");
    }

    private synchronized void Z(long j3) {
        this.f374036g = j3;
        Q("updateRequestModifyVersion-----mRequestModifyVersion = " + this.f374036g);
    }

    private synchronized void a0(String str) {
        this.f374037h = str;
        Q("updateRequestSnapshotVersion-----mRequestSnapshotVersion = " + this.f374037h);
    }

    @NonNull
    private f l() {
        return new f(this.f374030a, this.f374031b);
    }

    @NonNull
    private i m() {
        return new i(this.f374030a, this.f374031b, this.f374043n);
    }

    @NonNull
    private j n() {
        return new j(this.f374030a, this.f374031b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean p() {
        return this.f374038i.k(false);
    }

    private k q(@NonNull String str) {
        if (N()) {
            return this.f374038i.t(str);
        }
        return null;
    }

    @Nullable
    private k r(@NonNull String str) {
        if (N()) {
            return this.f374038i.u(str);
        }
        return this.f374038i.B(str);
    }

    private int u() {
        return Math.max(this.f374038i.x(), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long v() {
        long v3 = this.f374038i.v();
        if (v3 == 0) {
            return 0L;
        }
        return v3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String w() {
        String w3 = this.f374038i.w();
        if (TextUtils.isEmpty(w3)) {
            return "";
        }
        return w3;
    }

    private int x() {
        int y16 = this.f374038i.y();
        if (this.f374030a.i() == TabEnvironment.RELEASE) {
            return Math.max(y16, 600);
        }
        return Math.min(y16, 600);
    }

    @Nullable
    private kd4.a y() {
        Q("getStartUseRefreshListener-----finish");
        WeakReference<kd4.a> weakReference = this.f374041l;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    protected synchronized void A(long j3, String str, Object obj, TabMetricsNetInfo tabMetricsNetInfo) {
        try {
            G();
            try {
            } catch (Exception e16) {
                Q("handleResponse is failed and ex is" + e16.getMessage());
            }
            if (!O(j3, str, obj)) {
                Q("handleResponse-----return false by is not need");
                return;
            }
            Q("handleResponse-----is need to handle response");
            E(obj);
            F(obj);
            C(obj, tabMetricsNetInfo);
            B(obj);
            H();
        } finally {
            D();
        }
    }

    void D() {
        this.f374038i.K();
        Q("handleResponseEnd");
    }

    void G() {
        this.f374038i.N();
        Q("handleResponseStart");
    }

    void K() {
        synchronized (this.f374035f) {
            if (this.f374035f.b()) {
                Q("initUse-----return by true");
                return;
            }
            this.f374038i.P();
            this.f374039j.l();
            this.f374040k.c();
            this.f374035f.f();
            Q("initUse-----finish");
            if (this.f374035f.c()) {
                X(y());
                Q("initUse-----finish isCalledStartUse");
            }
        }
    }

    protected boolean N() {
        return this.f374035f.a();
    }

    protected boolean P() {
        return this.f374035f.e();
    }

    protected void Q(String str) {
        dd4.a aVar = this.f374032c;
        if (aVar == null) {
            return;
        }
        aVar.d("TAB.TabExpDataManager", x.a(this.f374030a.i(), this.f374030a.f(), this.f374030a.n(), this.f374030a.j(), str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void W(@Nullable kd4.a aVar) {
        synchronized (this.f374035f) {
            boolean b16 = this.f374035f.b();
            boolean c16 = this.f374035f.c();
            if (b16 && !c16) {
                X(aVar);
                this.f374035f.g();
                Q("startUse-----finish");
                return;
            }
            V(aVar);
            this.f374035f.g();
            Q("startUse-----return by isInitUse = " + b16 + ", isStartUse = " + c16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Y() {
        synchronized (this.f374035f) {
            if (this.f374035f.d()) {
                Q("stopUse-----return by isCalledStopUse");
                return;
            }
            this.f374038i.r0();
            this.f374039j.x();
            this.f374040k.i();
            this.f374035f.h();
            Q("stopUse-----finish");
        }
    }

    @Override // cd4.a
    @Nullable
    public k a(@NonNull String str, boolean z16) {
        k s16 = s(str);
        S(z16, s16);
        return s16;
    }

    @Override // cd4.b
    @NonNull
    public boolean b(@NonNull k kVar) {
        return T(kVar);
    }

    @Override // cd4.a
    @Nullable
    public k c(@NonNull String str, boolean z16) {
        k t16 = t(str);
        S(z16, t16);
        return t16;
    }

    @Override // cd4.c
    public void d(String str) {
        this.f374038i.b(str);
    }

    protected void o(@NonNull Runnable runnable) {
        jd4.a aVar = this.f374034e;
        if (aVar == null) {
            return;
        }
        aVar.execWorkTask(runnable);
    }

    k s(@NonNull String str) {
        if (!L(str)) {
            return null;
        }
        return q(str);
    }

    @Nullable
    k t(@NonNull String str) {
        if (!L(str)) {
            return null;
        }
        return r(str);
    }

    protected synchronized void z(TabMetricsNetInfo tabMetricsNetInfo) {
        if (tabMetricsNetInfo == null) {
            return;
        }
        tabMetricsNetInfo.i(this.f374030a.f());
        Q("handleMonitorRecord-----" + tabMetricsNetInfo);
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<String, String>(tabMetricsNetInfo) { // from class: com.tencent.tab.exp.sdk.impl.TabExpDataManager.2
            final /* synthetic */ TabMetricsNetInfo val$netInfo;

            {
                this.val$netInfo = tabMetricsNetInfo;
                put("tab_monitor_api", tabMetricsNetInfo.a());
                put("tab_monitor_status_code", String.valueOf(tabMetricsNetInfo.f()));
                put("tab_monitor_app_id", tabMetricsNetInfo.b());
                put("tab_monitor_channel", BuildConfig.VERSION_NAME);
            }
        };
        ConcurrentHashMap<String, Float> concurrentHashMap2 = new ConcurrentHashMap<String, Float>(tabMetricsNetInfo) { // from class: com.tencent.tab.exp.sdk.impl.TabExpDataManager.3
            final /* synthetic */ TabMetricsNetInfo val$netInfo;

            {
                this.val$netInfo = tabMetricsNetInfo;
                put("NetTTFBTimeKey", Float.valueOf(tabMetricsNetInfo.g()));
                put("NetRequestTimeKey", Float.valueOf(tabMetricsNetInfo.e()));
                put("NetParseTimeKey", Float.valueOf(tabMetricsNetInfo.c()));
            }
        };
        TabMetricsNetInfo.RecordType d16 = tabMetricsNetInfo.d();
        if (this.f374042m == null) {
            Q("network monitor is null and ignore this record");
            return;
        }
        int i3 = b.f374051a[d16.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    this.f374042m.j(concurrentHashMap, concurrentHashMap2);
                }
            } else {
                this.f374042m.l(concurrentHashMap, concurrentHashMap2);
            }
        } else {
            this.f374042m.k(concurrentHashMap, concurrentHashMap2);
        }
    }
}
