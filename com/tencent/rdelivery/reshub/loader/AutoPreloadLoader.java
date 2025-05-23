package com.tencent.rdelivery.reshub.loader;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.raft.codegenmeta.utils.Constants;
import com.tencent.raft.standard.net.IRNetwork;
import com.tencent.rdelivery.RDelivery;
import com.tencent.rdelivery.data.RDeliveryData;
import com.tencent.rdelivery.monitor.AppStateMonitor;
import com.tencent.rdelivery.reshub.api.g;
import com.tencent.rdelivery.reshub.api.h;
import com.tencent.rdelivery.reshub.api.n;
import com.tencent.rdelivery.reshub.core.i;
import com.tencent.rdelivery.reshub.core.j;
import com.tencent.rdelivery.reshub.loader.AutoPreloadLoader;
import com.tencent.rdelivery.reshub.util.ThreadUtil;
import iz3.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000_\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0003 $(\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u00100\u001a\u00020,\u0012\u0006\u00105\u001a\u000201\u0012\u0006\u00107\u001a\u000206\u00a2\u0006\u0004\b8\u00109J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\u0007\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u0012\u0010\f\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005H\u0002J\u0016\u0010\u000e\u001a\u00020\u00022\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0014\u001a\u00020\u0012H\u0002J\u0006\u0010\u0015\u001a\u00020\u0002R\u0014\u0010\u0018\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\"\u0010\u001f\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010+\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0017\u00100\u001a\u00020,8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010-\u001a\u0004\b.\u0010/R\u0017\u00105\u001a\u0002018\u0006\u00a2\u0006\f\n\u0004\b\u0015\u00102\u001a\u0004\b3\u00104\u00a8\u0006:"}, d2 = {"Lcom/tencent/rdelivery/reshub/loader/AutoPreloadLoader;", "", "", "o", "", "Lcom/tencent/rdelivery/data/RDeliveryData;", "dataList", "l", "", "Ljz3/e;", "i", "data", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, Constants.Configs.CONFIGS, h.F, "", "resId", "f", "", "k", "j", "g", "a", "Ljava/lang/String;", "TAG", "b", "Z", "getAutoPreloadChecking", "()Z", DomainData.DOMAIN_NAME, "(Z)V", "autoPreloadChecking", "com/tencent/rdelivery/reshub/loader/AutoPreloadLoader$c", "c", "Lcom/tencent/rdelivery/reshub/loader/AutoPreloadLoader$c;", "fullReqResultListener", "com/tencent/rdelivery/reshub/loader/AutoPreloadLoader$a", "d", "Lcom/tencent/rdelivery/reshub/loader/AutoPreloadLoader$a;", "appStateChangeListener", "com/tencent/rdelivery/reshub/loader/AutoPreloadLoader$d", "e", "Lcom/tencent/rdelivery/reshub/loader/AutoPreloadLoader$d;", "rdDataChangeListener", "Lcom/tencent/rdelivery/RDelivery;", "Lcom/tencent/rdelivery/RDelivery;", "getRDelivery", "()Lcom/tencent/rdelivery/RDelivery;", "rDelivery", "Lcom/tencent/rdelivery/reshub/core/i;", "Lcom/tencent/rdelivery/reshub/core/i;", "getResHub", "()Lcom/tencent/rdelivery/reshub/core/i;", "resHub", "Lcom/tencent/rdelivery/reshub/core/a;", "appInfo", "<init>", "(Lcom/tencent/rdelivery/RDelivery;Lcom/tencent/rdelivery/reshub/core/i;Lcom/tencent/rdelivery/reshub/core/a;)V", "reshub_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class AutoPreloadLoader {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String TAG;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private volatile boolean autoPreloadChecking;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final c fullReqResultListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final a appStateChangeListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final d rdDataChangeListener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RDelivery rDelivery;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final i resHub;

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/rdelivery/reshub/loader/AutoPreloadLoader$b", "Lcom/tencent/rdelivery/reshub/api/h;", "", "isSuccess", "Lcom/tencent/rdelivery/reshub/api/g;", "result", "Lcom/tencent/rdelivery/reshub/api/n;", "error", "", "onComplete", "reshub_debug"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes25.dex */
    public static final class b implements com.tencent.rdelivery.reshub.api.h {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f364509b;

        b(String str) {
            this.f364509b = str;
        }

        @Override // com.tencent.rdelivery.reshub.api.h
        public void onComplete(boolean isSuccess, @Nullable g result, @NotNull n error) {
            Long l3;
            Intrinsics.checkParameterIsNotNull(error, "error");
            StringBuilder sb5 = new StringBuilder();
            sb5.append("Res ");
            sb5.append(this.f364509b);
            sb5.append(" Check & Preload Result: Success[");
            sb5.append(isSuccess);
            sb5.append(']');
            sb5.append(" Version[");
            if (result != null) {
                l3 = Long.valueOf(result.getVersion());
            } else {
                l3 = null;
            }
            sb5.append(l3);
            sb5.append("] Err[");
            sb5.append(error.b());
            sb5.append(", ");
            sb5.append(error.message());
            sb5.append(']');
            String sb6 = sb5.toString();
            if (isSuccess) {
                jz3.d.e(AutoPreloadLoader.this.TAG, sb6);
            } else {
                jz3.d.c(AutoPreloadLoader.this.TAG, sb6);
            }
        }

        @Override // com.tencent.rdelivery.reshub.api.h
        public void onProgress(float f16) {
            h.a.a(this, f16);
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J2\u0010\f\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/rdelivery/reshub/loader/AutoPreloadLoader$c", "Liz3/e;", "", "reason", "", "onFail", "onSuccess", "", "Lcom/tencent/rdelivery/data/RDeliveryData;", "remainedDatas", "updatedDatas", "deletedDatas", "a", "reshub_debug"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes25.dex */
    public static final class c implements e {
        c() {
        }

        @Override // iz3.e, iz3.m
        public void a(@NotNull List<RDeliveryData> remainedDatas, @NotNull List<RDeliveryData> updatedDatas, @NotNull List<RDeliveryData> deletedDatas) {
            List plus;
            Intrinsics.checkParameterIsNotNull(remainedDatas, "remainedDatas");
            Intrinsics.checkParameterIsNotNull(updatedDatas, "updatedDatas");
            Intrinsics.checkParameterIsNotNull(deletedDatas, "deletedDatas");
            AutoPreloadLoader autoPreloadLoader = AutoPreloadLoader.this;
            plus = CollectionsKt___CollectionsKt.plus((Collection) remainedDatas, (Iterable) updatedDatas);
            autoPreloadLoader.l(plus);
            AutoPreloadLoader.this.n(false);
        }

        @Override // iz3.m
        public void onFail(@NotNull String reason) {
            Intrinsics.checkParameterIsNotNull(reason, "reason");
            AutoPreloadLoader.this.n(false);
            jz3.d.c(AutoPreloadLoader.this.TAG, "Request Full Configs Fail when Auto Check & Preload Res: " + reason);
        }

        @Override // iz3.e
        public void onSuccess() {
            AutoPreloadLoader.this.n(false);
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/rdelivery/reshub/loader/AutoPreloadLoader$d", "Liz3/c;", "", "key", "Lcom/tencent/rdelivery/data/RDeliveryData;", "oldData", "newData", "", "a", "reshub_debug"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes25.dex */
    public static final class d implements iz3.c {
        d() {
        }

        @Override // iz3.c
        public void a(@NotNull String key, @Nullable RDeliveryData oldData, @Nullable RDeliveryData newData) {
            Intrinsics.checkParameterIsNotNull(key, "key");
            AutoPreloadLoader.this.m(newData);
        }
    }

    public AutoPreloadLoader(@NotNull RDelivery rDelivery, @NotNull i resHub, @NotNull com.tencent.rdelivery.reshub.core.a appInfo) {
        Intrinsics.checkParameterIsNotNull(rDelivery, "rDelivery");
        Intrinsics.checkParameterIsNotNull(resHub, "resHub");
        Intrinsics.checkParameterIsNotNull(appInfo, "appInfo");
        this.rDelivery = rDelivery;
        this.resHub = resHub;
        this.TAG = "AutoPreload-" + appInfo.c();
        this.fullReqResultListener = new c();
        this.appStateChangeListener = new a();
        this.rdDataChangeListener = new d();
    }

    private final void f(String resId) {
        this.resHub.y(resId, new b(resId));
    }

    private final void h(List<jz3.e> configs) {
        int collectionSizeOrDefault;
        if (!j()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : configs) {
            boolean z16 = true;
            if (((jz3.e) obj).f411281v != 1) {
                z16 = false;
            }
            if (z16) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        configs.removeAll(arrayList);
        String str = this.TAG;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("Forbid Auto Check & Preload Res in MobileNet: ");
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((jz3.e) it.next()).f411260a);
        }
        sb5.append(arrayList2);
        jz3.d.e(str, sb5.toString());
    }

    private final List<jz3.e> i(List<RDeliveryData> dataList) {
        List<jz3.e> mutableList;
        int collectionSizeOrDefault;
        boolean z16;
        ArrayList arrayList = new ArrayList();
        for (Object obj : dataList) {
            if (true ^ lz3.h.a((RDeliveryData) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            jz3.e b16 = lz3.h.b((RDeliveryData) it.next());
            if (b16 != null) {
                arrayList2.add(b16);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : arrayList2) {
            if (((jz3.e) obj2).f411280u == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                arrayList3.add(obj2);
            }
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList3);
        if (mutableList.isEmpty()) {
            jz3.d.e(this.TAG, "No Auto Check & Preload Res Configs(Total: " + dataList.size() + "), Ignore.");
        } else {
            String str = this.TAG;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("Find Auto Check & Preload Res: ");
            List<jz3.e> list = mutableList;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList4 = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it5 = list.iterator();
            while (it5.hasNext()) {
                arrayList4.add(((jz3.e) it5.next()).f411260a);
            }
            sb5.append(arrayList4);
            jz3.d.e(str, sb5.toString());
        }
        return mutableList;
    }

    private final boolean j() {
        if (k() && j.L.v().getNetworkStatus() != IRNetwork.NetworkStatus.WIFI) {
            return true;
        }
        return false;
    }

    private final boolean k() {
        if (j.L.v().getNetworkStatus() != IRNetwork.NetworkStatus.NO_NETWORK) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(List<RDeliveryData> dataList) {
        List<jz3.e> i3 = i(dataList);
        h(i3);
        Iterator<T> it = i3.iterator();
        while (it.hasNext()) {
            String str = ((jz3.e) it.next()).f411260a;
            Intrinsics.checkExpressionValueIsNotNull(str, "it.id");
            f(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(RDeliveryData data) {
        jz3.e b16;
        List<jz3.e> mutableListOf;
        if (this.autoPreloadChecking || data == null || (b16 = lz3.h.b(data)) == null || b16.f411280u != 1) {
            return;
        }
        jz3.d.e(this.TAG, "Find Auto Check & Preload Res On DataChange: " + b16.f411260a);
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(b16);
        h(mutableListOf);
        if (!mutableListOf.isEmpty()) {
            String str = b16.f411260a;
            Intrinsics.checkExpressionValueIsNotNull(str, "config.id");
            f(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o() {
        if (!k()) {
            jz3.d.i(this.TAG, "No Network, Ignore Auto Check & Preload Res.");
        } else {
            if (this.autoPreloadChecking) {
                jz3.d.i(this.TAG, "Auto Check & Preload Res Already Processing, Ignore New Request.");
                return;
            }
            jz3.d.e(this.TAG, "Start Auto Check & Preload Res...");
            this.autoPreloadChecking = true;
            this.rDelivery.G(this.fullReqResultListener);
        }
    }

    public final void g() {
        this.rDelivery.g(this.rdDataChangeListener);
        ThreadUtil.f364593c.e(new Runnable() { // from class: com.tencent.rdelivery.reshub.loader.AutoPreloadLoader$enableAutoPreload$1
            @Override // java.lang.Runnable
            public final void run() {
                AutoPreloadLoader.a aVar;
                j jVar = j.L;
                if (jVar.l()) {
                    AutoPreloadLoader.this.o();
                }
                if (jVar.k()) {
                    AppStateMonitor appStateMonitor = new AppStateMonitor();
                    aVar = AutoPreloadLoader.this.appStateChangeListener;
                    appStateMonitor.a(aVar);
                }
            }
        });
    }

    public final void n(boolean z16) {
        this.autoPreloadChecking = z16;
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/rdelivery/reshub/loader/AutoPreloadLoader$a", "Lcom/tencent/rdelivery/monitor/AppStateMonitor$a;", "", "onEnterBackground", "onEnterForeground", "reshub_debug"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes25.dex */
    public static final class a implements AppStateMonitor.a {
        a() {
        }

        @Override // com.tencent.rdelivery.monitor.AppStateMonitor.a
        public void onEnterForeground() {
            AutoPreloadLoader.this.o();
        }

        @Override // com.tencent.rdelivery.monitor.AppStateMonitor.a
        public void onEnterBackground() {
        }
    }
}
