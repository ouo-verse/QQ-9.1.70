package com.tencent.tab.exp.sdk.impl;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.tab.exp.sdk.export.config.TabEnvironment;
import com.tencent.tab.exp.sdk.pbdata.DataUpdateType;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes26.dex */
public final class j {

    /* renamed from: m, reason: collision with root package name */
    private static final byte[] f374103m = null;

    /* renamed from: n, reason: collision with root package name */
    private static final byte[] f374104n = null;

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final q f374105a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    private final TabExpDependInjector f374106b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    private final dd4.a f374107c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private final id4.b f374108d;

    /* renamed from: f, reason: collision with root package name */
    private long f374110f;

    /* renamed from: g, reason: collision with root package name */
    private String f374111g;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    private final w f374109e = new w();

    /* renamed from: h, reason: collision with root package name */
    private final ConcurrentHashMap<String, k> f374112h = new ConcurrentHashMap<>();

    /* renamed from: i, reason: collision with root package name */
    private final ConcurrentHashMap<String, String> f374113i = new ConcurrentHashMap<>();

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    private final e f374114j = h();

    /* renamed from: k, reason: collision with root package name */
    @Nullable
    private final id4.a f374115k = j(s());

    /* renamed from: l, reason: collision with root package name */
    @Nullable
    final id4.a f374116l = j(r());

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(@NonNull q qVar, @NonNull TabExpDependInjector tabExpDependInjector) {
        this.f374105a = qVar;
        this.f374106b = tabExpDependInjector;
        this.f374107c = tabExpDependInjector.getLogImpl();
        this.f374108d = tabExpDependInjector.getStorageFactoryImpl();
    }

    private void G(ConcurrentHashMap<String, k> concurrentHashMap) {
        e(this.f374112h, concurrentHashMap);
        f(this.f374112h, concurrentHashMap);
    }

    private void J(ConcurrentHashMap<String, k> concurrentHashMap, List<String> list) {
        e(this.f374112h, concurrentHashMap);
        g(this.f374112h, list);
    }

    private boolean Q(String str) {
        return !TextUtils.isEmpty(str);
    }

    private boolean S(boolean z16) {
        if (z16) {
            V("isNeedToFetchStorage-----return true by is init fetch");
            return true;
        }
        if (!T()) {
            V("isNeedToFetchStorage-----return false by is not using");
            return false;
        }
        long v3 = v();
        long D = D();
        if (v3 >= D) {
            V("isNeedToFetchStorage-----return false by storageDataVersion not upgrade, memoryDataVersion = " + v3 + ", storageDataVersion = " + D);
            return false;
        }
        V("isNeedToFetchStorage-----return true by storageDataVersion should upgrade, memoryDataVersion = " + v3 + ", storageDataVersion = " + D);
        return true;
    }

    private void U(@Nullable id4.a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.lock();
    }

    private synchronized void W(e eVar) {
        if (eVar == null) {
            return;
        }
        a0(eVar);
        f0(this.f374114j);
    }

    private synchronized void X(String str, k kVar) {
        if (Q(str) && kVar != null) {
            b0(str, kVar);
            g0(kVar);
        }
    }

    private synchronized void Y(long j3) {
        c0(j3);
        i0(j3);
    }

    private synchronized void Z(String str) {
        d0(str);
        j0(str);
    }

    private void a(String str) {
        if (this.f374115k != null && TextUtils.isEmpty(str)) {
            this.f374115k.clear();
        } else {
            id4.a aVar = this.f374115k;
            if (aVar != null) {
                n0(aVar, str);
            }
        }
        if (this.f374116l != null && TextUtils.isEmpty(str)) {
            this.f374116l.clear();
        }
    }

    private synchronized void a0(e eVar) {
        if (eVar == null) {
            return;
        }
        V("updateControlInfo = " + eVar.toString());
        this.f374114j.f(eVar.b(), eVar.e(), eVar.d(), eVar.c());
    }

    private synchronized void b0(String str, k kVar) {
        if (Q(str) && kVar != null) {
            ConcurrentHashMap<String, k> concurrentHashMap = this.f374112h;
            if (concurrentHashMap == null) {
                V("putMemoryData-----mTabExpInfoMap null");
                return;
            }
            concurrentHashMap.put(str, kVar);
            String d16 = kVar.d();
            if (!TextUtils.isEmpty(d16)) {
                this.f374113i.put(d16, str);
            }
        }
    }

    private void c(String str) {
        if (TextUtils.isEmpty(str)) {
            Y(0L);
            p0();
        }
        d(str);
    }

    private void c0(long j3) {
        this.f374110f = j3;
        V("putMemoryModifyVersion-----modifyVersion = " + j3);
    }

    private void d(String str) {
        ConcurrentHashMap<String, k> concurrentHashMap = this.f374112h;
        if (concurrentHashMap != null && !concurrentHashMap.isEmpty() && TextUtils.isEmpty(str)) {
            this.f374112h.clear();
        } else {
            ConcurrentHashMap<String, k> concurrentHashMap2 = this.f374112h;
            if (concurrentHashMap2 != null && !concurrentHashMap2.isEmpty()) {
                this.f374112h.remove(str);
            }
        }
        ConcurrentHashMap<String, String> concurrentHashMap3 = this.f374113i;
        if (concurrentHashMap3 != null && !concurrentHashMap3.isEmpty() && TextUtils.isEmpty(str)) {
            this.f374113i.clear();
        }
    }

    private void d0(String str) {
        this.f374111g = str;
        V("putMemorySnapshotVersion-----mSnapshotVersion = " + this.f374111g);
    }

    private void e(ConcurrentHashMap<String, k> concurrentHashMap, ConcurrentHashMap<String, k> concurrentHashMap2) {
        Set<String> keySet;
        k kVar;
        k kVar2;
        if (concurrentHashMap != null && concurrentHashMap2 != null && !concurrentHashMap2.isEmpty() && (keySet = concurrentHashMap2.keySet()) != null && !keySet.isEmpty()) {
            for (String str : new HashSet(keySet)) {
                if (!TextUtils.isEmpty(str) && (kVar = concurrentHashMap2.get(str)) != null && ((kVar2 = concurrentHashMap.get(str)) == null || !kVar2.equals(kVar))) {
                    X(str, kVar);
                }
            }
        }
    }

    private void e0(@Nullable id4.a aVar, String str, byte[] bArr) {
        if (aVar != null && !TextUtils.isEmpty(str)) {
            aVar.putByteArray(str, bArr);
        }
    }

    private void f(ConcurrentHashMap<String, k> concurrentHashMap, ConcurrentHashMap<String, k> concurrentHashMap2) {
        Set<String> keySet;
        if (concurrentHashMap != null && concurrentHashMap2 != null && (keySet = concurrentHashMap.keySet()) != null && !keySet.isEmpty()) {
            for (String str : new HashSet(keySet)) {
                if (!TextUtils.isEmpty(str) && !concurrentHashMap2.containsKey(str)) {
                    l0(str);
                }
            }
        }
    }

    private void g(ConcurrentHashMap<String, k> concurrentHashMap, List<String> list) {
        if (concurrentHashMap != null && list != null && !list.isEmpty()) {
            for (String str : list) {
                if (!TextUtils.isEmpty(str) && concurrentHashMap.containsKey(str)) {
                    l0(str);
                }
            }
        }
    }

    private void g0(k kVar) {
        byte[] l3;
        if (kVar == null) {
            return;
        }
        String f16 = kVar.f();
        if (TextUtils.isEmpty(f16) || (l3 = g.l(kVar)) == null) {
            return;
        }
        e0(this.f374115k, f16, l3);
    }

    private void i0(long j3) {
        h0(this.f374116l, "modify_version", j3);
    }

    @Nullable
    private id4.a j(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return i(str + "_" + x.d(TabEnvironment.toStorageName(this.f374105a.i()), "EmptyEnvironment") + "_" + x.d(this.f374105a.f(), "EmptyAppId") + "_" + x.d(this.f374105a.n(), "EmptySceneId") + "_" + x.d(this.f374105a.j(), "EmptyGuid"));
    }

    private void j0(String str) {
        k0(this.f374116l, "snapshot_version", str);
    }

    private synchronized void l0(String str) {
        if (!Q(str)) {
            return;
        }
        o0(m0(str));
    }

    private synchronized k m0(String str) {
        if (!Q(str)) {
            return null;
        }
        ConcurrentHashMap<String, k> concurrentHashMap = this.f374112h;
        if (concurrentHashMap == null) {
            V("removeMemoryData-----mTabExpInfoMap null");
            return null;
        }
        return concurrentHashMap.remove(str);
    }

    private void n() {
        t0(this.f374115k);
        V("-----fetchStorageEnd-----");
    }

    private void o() {
        c0(D());
    }

    private void p() {
        d0(E());
    }

    private void p0() {
        this.f374114j.a();
    }

    private void q() {
        U(this.f374115k);
        V("-----fetchStorageStart-----");
    }

    private void t0(@Nullable id4.a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.unlock();
    }

    byte[] A(@Nullable id4.a aVar, String str, byte[] bArr) {
        if (aVar != null && !TextUtils.isEmpty(str)) {
            return aVar.getByteArray(str);
        }
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public k B(String str) {
        byte[] A;
        if (!Q(str) || (A = A(this.f374115k, str, f374103m)) == null) {
            return null;
        }
        return g.j(A);
    }

    long C(@Nullable id4.a aVar, String str, long j3) {
        if (aVar != null && !TextUtils.isEmpty(str)) {
            return aVar.getLong(str, j3);
        }
        return j3;
    }

    @NonNull
    long D() {
        return C(this.f374116l, "modify_version", 0L);
    }

    @NonNull
    String E() {
        return F(this.f374116l, "snapshot_version", "");
    }

    String F(@Nullable id4.a aVar, String str, String str2) {
        byte[] byteArray;
        if (aVar != null && !TextUtils.isEmpty(str) && (byteArray = aVar.getByteArray(str)) != null && byteArray.length != 0) {
            return new String(byteArray);
        }
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void H(e eVar) {
        if (eVar == null || eVar.equals(this.f374114j)) {
            return;
        }
        W(eVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void I(ConcurrentHashMap<String, k> concurrentHashMap, List<String> list, DataUpdateType dataUpdateType) {
        if (concurrentHashMap != null && list != null) {
            V(String.format("handleResponseData-----responseAddOrUpdateMap = %d, responseDeletedList = %d, dataUpdateType = %d", Integer.valueOf(concurrentHashMap.size()), Integer.valueOf(list.size()), Integer.valueOf(dataUpdateType.getValue())));
            Iterator<Map.Entry<String, k>> it = concurrentHashMap.entrySet().iterator();
            while (it.hasNext()) {
                V(it.next().getValue().toString());
            }
            V("handleResponseData-----responseDeletedList = " + list);
            if (this.f374112h == null) {
                V("handleResponseData-----mTabExpInfoMap null");
                return;
            }
            if (this.f374113i == null) {
                V("handleResponseData-----mTabExpKeyLayerMap null");
                return;
            }
            if (DataUpdateType.DATA_UPDATE_TYPE_ALL == dataUpdateType) {
                V("handleResponseAllData");
                G(concurrentHashMap);
                return;
            } else {
                if (DataUpdateType.DATA_UPDATE_TYPE_DIFF == dataUpdateType) {
                    V("handleResponseDiffData");
                    J(concurrentHashMap, list);
                    return;
                }
                return;
            }
        }
        V("handleResponseData-----responseAddOrUpdateMap or responseDeletedList null");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void K() {
        t0(this.f374115k);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void L(long j3) {
        Y(j3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void M(String str) {
        Z(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void N() {
        U(this.f374115k);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void O() {
        s0(this.f374115k);
        s0(this.f374116l);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void P() {
        synchronized (this.f374109e) {
            if (this.f374109e.b()) {
                V("initUse-----return by isCalledInitUse");
                return;
            }
            k(true);
            this.f374109e.f();
            V("initUse-----finish");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean R() {
        return this.f374114j.e();
    }

    boolean T() {
        return this.f374109e.e();
    }

    void V(String str) {
        dd4.a aVar = this.f374107c;
        if (aVar == null) {
            return;
        }
        aVar.d("TAB.TabExpDataStorage", x.a(this.f374105a.i(), this.f374105a.f(), this.f374105a.n(), this.f374105a.j(), str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void b(String str) {
        q();
        V("-----start clearExpCache----- " + str);
        try {
            try {
                a(str);
                c(str);
                V("-----end clearExpCache----- " + str);
            } catch (Throwable th5) {
                V("-----end clearExpCache----- " + str);
                n();
                throw th5;
            }
        } catch (Exception e16) {
            V(e16.toString());
            V("-----end clearExpCache----- " + str);
        }
        n();
    }

    void f0(e eVar) {
        byte[] m3 = g.m(eVar);
        if (m3 == null) {
            return;
        }
        e0(this.f374116l, "control_data", m3);
    }

    @NonNull
    e h() {
        return new e();
    }

    void h0(@Nullable id4.a aVar, String str, long j3) {
        if (aVar != null && !TextUtils.isEmpty(str)) {
            aVar.putLong(str, j3);
        }
    }

    @Nullable
    id4.a i(@NonNull String str) {
        id4.b bVar = this.f374108d;
        if (bVar == null) {
            return null;
        }
        return bVar.create(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean k(boolean z16) {
        q();
        try {
            if (!S(z16)) {
                V("fetchStorage-----return by is not need");
                return false;
            }
            V("fetchStorage-----is need to fetch");
            o();
            p();
            m();
            l();
            return true;
        } finally {
            n();
        }
    }

    void k0(@Nullable id4.a aVar, String str, String str2) {
        if (aVar != null && !TextUtils.isEmpty(str)) {
            aVar.putByteArray(str, str2.getBytes());
        }
    }

    void l() {
        byte[] A = A(this.f374116l, "control_data", f374104n);
        if (A == null) {
            this.f374114j.a();
            V("initControlInfo-----return by controlInfoBytes null");
            return;
        }
        e k3 = g.k(A);
        if (k3 == null) {
            this.f374114j.a();
            n0(this.f374116l, "control_data");
            V("initControlInfo-----return by decodeTabExpControlInfo null");
            return;
        }
        a0(k3);
    }

    void m() {
        String[] z16 = z(this.f374115k);
        if (z16 != null && z16.length > 0) {
            V("initData-----storageAllKeys length = " + z16.length);
            for (String str : z16) {
                if (!TextUtils.isEmpty(str)) {
                    byte[] A = A(this.f374115k, str, f374103m);
                    if (A == null) {
                        n0(this.f374115k, str);
                        V("initData-----dataBytes null, remove dataKey = " + str);
                    } else {
                        k j3 = g.j(A);
                        if (j3 == null) {
                            n0(this.f374115k, str);
                            V("initData-----decodeExpInfo null, remove dataKey = " + str);
                        } else {
                            String f16 = j3.f();
                            if (TextUtils.isEmpty(f16)) {
                                n0(this.f374115k, str);
                                V("initData-----tabExpInfoKey empty, dataKey = " + str);
                            } else {
                                b0(f16, j3);
                            }
                        }
                    }
                }
            }
            return;
        }
        V("initData-----return by storageAllKeys empty");
    }

    void n0(@Nullable id4.a aVar, String str) {
        if (aVar != null && !TextUtils.isEmpty(str)) {
            aVar.remove(str);
        }
    }

    void o0(k kVar) {
        if (kVar == null) {
            return;
        }
        String f16 = kVar.f();
        if (TextUtils.isEmpty(f16)) {
            return;
        }
        n0(this.f374115k, f16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q0() {
        synchronized (this.f374109e) {
            if (this.f374109e.c()) {
                V("startUse-----return by isCalledStartUse");
            } else {
                this.f374109e.g();
                V("startUse-----finish");
            }
        }
    }

    @NonNull
    String r() {
        return "tab_exp_sdk_control_info";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r0() {
        synchronized (this.f374109e) {
            if (this.f374109e.d()) {
                V("stopUse-----return by isCalledStopUse");
            } else {
                this.f374109e.h();
                V("stopUse-----finish");
            }
        }
    }

    @NonNull
    String s() {
        return "tab_exp_sdk_data_info";
    }

    void s0(@Nullable id4.a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.trim();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public k t(String str) {
        if (!Q(str)) {
            return null;
        }
        ConcurrentHashMap<String, String> concurrentHashMap = this.f374113i;
        if (concurrentHashMap != null && this.f374112h != null) {
            String str2 = concurrentHashMap.get(str);
            if (!Q(str2)) {
                return null;
            }
            return this.f374112h.get(str2);
        }
        V("getMemoryData-----mTabExpKeyLayerMap or mTabExpInfoMap null");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public k u(String str) {
        if (!Q(str)) {
            return null;
        }
        ConcurrentHashMap<String, k> concurrentHashMap = this.f374112h;
        if (concurrentHashMap == null) {
            V("getMemoryData-----mTabExpInfoMap null");
            return null;
        }
        return concurrentHashMap.get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public long v() {
        return this.f374110f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String w() {
        return this.f374111g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int x() {
        return this.f374114j.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int y() {
        return this.f374114j.d();
    }

    @Nullable
    String[] z(@Nullable id4.a aVar) {
        if (aVar == null) {
            return null;
        }
        return aVar.allKeys();
    }
}
