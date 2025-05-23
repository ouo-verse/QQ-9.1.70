package com.tencent.tab.exp.sdk.impl;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.tab.exp.sdk.export.config.TabEnvironment;
import com.tencent.tab.exp.sdk.export.injector.network.TabNetworkMethod;
import com.tencent.tab.exp.sdk.pbdata.DataUpdateType;
import com.tencent.tab.exp.sdk.pbdata.FilterOptions;
import com.tencent.tab.exp.sdk.pbdata.GetExperimentsReqV2;
import com.tencent.tab.exp.sdk.pbdata.GetExperimentsRespV2;
import com.tencent.tab.exp.sdk.pbdata.ProfileValues;
import com.tencent.tab.exp.sdk.pbdata.RetCode;
import fd4.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes26.dex */
public final class f {

    /* renamed from: f, reason: collision with root package name */
    private static String f374081f = "";

    /* renamed from: g, reason: collision with root package name */
    private static String f374082g = "";

    /* renamed from: h, reason: collision with root package name */
    private static final List<String> f374083h = new ArrayList();

    /* renamed from: i, reason: collision with root package name */
    private static final List<String> f374084i = new ArrayList();

    /* renamed from: j, reason: collision with root package name */
    private static final List<String> f374085j = new ArrayList();

    /* renamed from: k, reason: collision with root package name */
    private static final Map<String, ProfileValues> f374086k = new HashMap();

    /* renamed from: l, reason: collision with root package name */
    private static final Map<String, String> f374087l = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final q f374088a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    private final TabExpDependInjector f374089b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    private final dd4.a f374090c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private final com.tencent.tab.exp.sdk.export.injector.network.a f374091d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    private final w f374092e = new w();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f374093a;

        static {
            int[] iArr = new int[TabEnvironment.values().length];
            f374093a = iArr;
            try {
                iArr[TabEnvironment.DEVELOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(@NonNull q qVar, @NonNull TabExpDependInjector tabExpDependInjector) {
        this.f374088a = qVar;
        this.f374089b = tabExpDependInjector;
        this.f374090c = tabExpDependInjector.getLogImpl();
        this.f374091d = tabExpDependInjector.getNetworkImpl();
    }

    private byte[] a(long j3, String str, List<String> list) {
        GetExperimentsReqV2 build = new GetExperimentsReqV2.a().a(this.f374088a.f()).e(this.f374088a.j()).d(new FilterOptions.a().b(d(list)).c(f()).d(i()).build()).g(h()).c(e()).f(Long.valueOf(g(j3))).i(str).h(j()).build();
        o(String.format("expUrl: %s, %s", k(), build));
        return build.encode();
    }

    private String c() {
        String str;
        if (!TextUtils.isEmpty(f374081f)) {
            return f374081f;
        }
        String l3 = this.f374088a.l();
        if (TextUtils.isEmpty(l3)) {
            str = "https://data.ab.qq.com/v2/tab/get_experiments";
        } else {
            str = l3 + "/v2/tab/get_experiments";
        }
        f374081f = str;
        return str;
    }

    private List<String> d(List<String> list) {
        if (list != null && !list.isEmpty()) {
            return new ArrayList(list);
        }
        return f374083h;
    }

    private Map<String, String> e() {
        Map<String, String> a16 = this.f374088a.a();
        if (a16 != null && !a16.isEmpty()) {
            return a16;
        }
        return f374087l;
    }

    private List<String> f() {
        String k3 = this.f374088a.k();
        if (TextUtils.isEmpty(k3)) {
            return f374085j;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(k3);
        return arrayList;
    }

    private long g(long j3) {
        return Math.max(j3, 0L);
    }

    private Map<String, ProfileValues> h() {
        Map<String, String> b16 = this.f374088a.b();
        if (b16 != null && !b16.isEmpty()) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, String> entry : b16.entrySet()) {
                hashMap.put(entry.getKey(), new ProfileValues.a().b(Arrays.asList(entry.getValue())).build());
            }
            return hashMap;
        }
        return f374086k;
    }

    private List<String> i() {
        String n3 = this.f374088a.n();
        if (TextUtils.isEmpty(n3)) {
            return f374084i;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(n3);
        return arrayList;
    }

    private String j() {
        if (!TextUtils.isEmpty(f374082g)) {
            return f374082g;
        }
        String str = "4.5.0-" + x.b();
        f374082g = str;
        return str;
    }

    private String k() {
        TabEnvironment i3 = this.f374088a.i();
        if (i3 == null) {
            return c();
        }
        if (a.f374093a[i3.ordinal()] != 1) {
            return c();
        }
        return "https://tdata.ab.qq.com/v2/tab/get_experiments";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(long j3, String str, List<String> list, ed4.b bVar) {
        if (!n()) {
            o("fetch-----return by is not using");
            return;
        }
        int m3 = this.f374088a.m();
        fd4.b h16 = new b.C10307b().d(TabNetworkMethod.POST).f(k()).b(a(j3, str, list)).a(m3).e(m3).g(m3).h();
        o("fetch----- " + k());
        v(h16, bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l() {
        synchronized (this.f374092e) {
            if (this.f374092e.b()) {
                o("initUse-----return by isCalledInitUse");
            } else {
                this.f374092e.f();
                o("initUse-----finish");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean m(Object obj) {
        RetCode retCode;
        GetExperimentsRespV2 c16 = g.c(obj);
        if (c16 == null || (retCode = c16.ret_code) == null) {
            return false;
        }
        RetCode retCode2 = RetCode.RET_CODE_SUCCESS;
        if (retCode != retCode2) {
            o("isResponseSuccess-----return ret_code\uff1a" + c16.ret_code);
            return false;
        }
        if (retCode != retCode2) {
            return false;
        }
        return true;
    }

    protected boolean n() {
        return this.f374092e.e();
    }

    protected void o(String str) {
        dd4.a aVar = this.f374090c;
        if (aVar == null) {
            return;
        }
        aVar.d("TAB.TabExpDataFetcher", x.a(this.f374088a.i(), this.f374088a.f(), this.f374088a.n(), this.f374088a.j(), str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ConcurrentHashMap<String, k> p(Object obj) {
        return g.h(g.c(obj));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e q(Object obj) {
        return g.f(g.c(obj));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DataUpdateType r(Object obj) {
        return g.d(g.c(obj));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<String> s(Object obj) {
        return g.i(g.c(obj));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long t(Object obj) {
        return g.e(g.c(obj));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String u(Object obj) {
        return g.g(g.c(obj));
    }

    protected long v(fd4.b bVar, ed4.b bVar2) {
        com.tencent.tab.exp.sdk.export.injector.network.a aVar = this.f374091d;
        if (aVar != null && bVar != null) {
            return aVar.a(bVar, bVar2);
        }
        o("sendBytesRequestWithBytesResponse-----return by bytesRequest null");
        return -1L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w() {
        synchronized (this.f374092e) {
            if (this.f374092e.c()) {
                o("startUse-----return by isCalledStartUse");
            } else {
                this.f374092e.g();
                o("startUse-----finish");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x() {
        synchronized (this.f374092e) {
            if (this.f374092e.d()) {
                o("stopUse-----return by isCalledStopUse");
            } else {
                this.f374092e.h();
                o("stopUse-----finish");
            }
        }
    }
}
