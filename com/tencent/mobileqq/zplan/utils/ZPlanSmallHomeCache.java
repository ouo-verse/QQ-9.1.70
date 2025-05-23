package com.tencent.mobileqq.zplan.utils;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.api.IZPlanMMKVApi;
import com.tencent.mobileqq.zplan.servlet.ZPlanUserInfoRequest;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0016\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nR \u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0017\u001a\u00020\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/zplan/utils/ZPlanSmallHomeCache;", "", "", "uin", "", "j", "", "smallHomeRigisterStatus", "", "k", "Lnk3/o;", "callback", tl.h.F, "f", "", "b", "Ljava/util/Map;", "accessMap", "Lcom/tencent/mobileqq/zplan/api/IZPlanMMKVApi;", "c", "Lkotlin/Lazy;", "e", "()Lcom/tencent/mobileqq/zplan/api/IZPlanMMKVApi;", "mmkv", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanSmallHomeCache {

    /* renamed from: a, reason: collision with root package name */
    public static final ZPlanSmallHomeCache f335745a = new ZPlanSmallHomeCache();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Map<Long, Integer> accessMap = new LinkedHashMap();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final Lazy mmkv;

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\u0007\u001a\u00020\u00062\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zplan/utils/ZPlanSmallHomeCache$a", "Lnk3/p;", "", "", "", "infoList", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a implements nk3.p {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ nk3.o f335748a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f335749b;

        a(nk3.o oVar, long j3) {
            this.f335748a = oVar;
            this.f335749b = j3;
        }

        @Override // nk3.p
        public void a(Map<Integer, String> infoList) {
            int i3;
            if (infoList == null) {
                QLog.e("[zplan]ZPlanSmallHomeCache", 1, "requestOidb1127 onResult ERROR infoList is null");
                this.f335748a.a(Boolean.FALSE);
                return;
            }
            if (infoList.containsKey(2)) {
                String str = infoList.get(2);
                Intrinsics.checkNotNull(str);
                long parseLong = Long.parseLong(str);
                ZPlanSmallHomeCache.f335745a.e().setLong(this.f335749b + "sp_key_zplan_smallhome_request_interval", parseLong);
            }
            if (infoList.containsKey(1)) {
                String str2 = infoList.get(1);
                Intrinsics.checkNotNull(str2);
                i3 = Integer.parseInt(str2);
            } else {
                i3 = 0;
            }
            this.f335748a.a(Boolean.valueOf(i3 == 1));
            ZPlanSmallHomeCache.f335745a.k(this.f335749b, i3);
        }
    }

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<IZPlanMMKVApi>() { // from class: com.tencent.mobileqq.zplan.utils.ZPlanSmallHomeCache$mmkv$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final IZPlanMMKVApi invoke() {
                return (IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class);
            }
        });
        mmkv = lazy;
    }

    ZPlanSmallHomeCache() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IZPlanMMKVApi e() {
        return (IZPlanMMKVApi) mmkv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(long j3, nk3.o callback) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        ZPlanSmallHomeCache zPlanSmallHomeCache = f335745a;
        if (zPlanSmallHomeCache.j(j3)) {
            QLog.i("[zplan]ZPlanSmallHomeCache", 1, "getSmallHomeAccess cache expire!");
            zPlanSmallHomeCache.h(j3, callback);
            return;
        }
        Map<Long, Integer> map = accessMap;
        if (map.containsKey(Long.valueOf(j3))) {
            Integer num = map.get(Long.valueOf(j3));
            Intrinsics.checkNotNull(num);
            callback.a(Boolean.valueOf(num.intValue() == 1));
            return;
        }
        int i3 = zPlanSmallHomeCache.e().getInt(j3 + "sp_key_zplan_smallhome_register_status", -1);
        if (i3 != -1) {
            map.put(Long.valueOf(j3), Integer.valueOf(i3));
            callback.a(Boolean.valueOf(i3 == 1));
        } else {
            QLog.i("[zplan]ZPlanSmallHomeCache", 1, "getSmallHomeAccess no cache!");
            zPlanSmallHomeCache.h(j3, callback);
        }
    }

    private final void h(final long uin, final nk3.o callback) {
        final ArrayList arrayList = new ArrayList();
        arrayList.add(new com.tencent.mobileqq.zplan.model.c(1, 3));
        arrayList.add(new com.tencent.mobileqq.zplan.model.c(2, 4));
        e().setLong(uin + "sp_key_zplan_smallhome_request_time", System.currentTimeMillis());
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.utils.az
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanSmallHomeCache.i(arrayList, uin, callback);
            }
        }, 128, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(List userInfoDesList, long j3, nk3.o callback) {
        Intrinsics.checkNotNullParameter(userInfoDesList, "$userInfoDesList");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        ZPlanUserInfoRequest.f335380a.q(userInfoDesList, j3, 3, new a(callback, j3));
    }

    private final boolean j(long uin) {
        long j3 = e().getLong(uin + "sp_key_zplan_smallhome_request_time", 0L);
        if (j3 == 0) {
            return true;
        }
        IZPlanMMKVApi e16 = e();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(uin);
        sb5.append("sp_key_zplan_smallhome_request_interval");
        return System.currentTimeMillis() - j3 > e16.getLong(sb5.toString(), 86400000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(long uin, int smallHomeRigisterStatus) {
        accessMap.put(Long.valueOf(uin), Integer.valueOf(smallHomeRigisterStatus));
        e().setInt(uin + "sp_key_zplan_smallhome_register_status", smallHomeRigisterStatus);
    }

    public final void f(final long uin, final nk3.o callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.utils.ay
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanSmallHomeCache.g(uin, callback);
            }
        }, 16, null, true);
    }
}
