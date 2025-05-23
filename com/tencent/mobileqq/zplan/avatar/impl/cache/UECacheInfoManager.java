package com.tencent.mobileqq.zplan.avatar.impl.cache;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.zplan.api.UECacheData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import ue3.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001f\u0010 J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000bH\u0016J\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0004H\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0016J\b\u0010\u0010\u001a\u00020\u0006H\u0016R7\u0010\u0017\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u0011j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004`\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R+\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u00190\u0018j\b\u0012\u0004\u0012\u00020\u0019`\u001a8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0014\u001a\u0004\b\u001c\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/zplan/avatar/impl/cache/UECacheInfoManager;", "Lue3/b;", "", "cacheKey", "Lcom/tencent/mobileqq/zplan/api/UECacheData;", "Y0", "", "W0", "refreshCache", "queryCache", "deleteCache", "", "getAllCacheData", "cacheData", "V", "doWhenQQLogout", "sync", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "c", "Lkotlin/Lazy;", "Z0", "()Ljava/util/HashMap;", "mCachePool", "Ljava/util/HashSet;", "Lue3/d;", "Lkotlin/collections/HashSet;", "d", ICustomDataEditor.STRING_ARRAY_PARAM_1, "()Ljava/util/HashSet;", "mCacheProvider", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class UECacheInfoManager implements ue3.b {

    /* renamed from: b, reason: collision with root package name */
    public static final UECacheInfoManager f331873b = new UECacheInfoManager();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final Lazy mCachePool;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final Lazy mCacheProvider;

    static {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<HashMap<String, UECacheData>>() { // from class: com.tencent.mobileqq.zplan.avatar.impl.cache.UECacheInfoManager$mCachePool$2
            @Override // kotlin.jvm.functions.Function0
            public final HashMap<String, UECacheData> invoke() {
                return new HashMap<>();
            }
        });
        mCachePool = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<HashSet<d>>() { // from class: com.tencent.mobileqq.zplan.avatar.impl.cache.UECacheInfoManager$mCacheProvider$2
            @Override // kotlin.jvm.functions.Function0
            public final HashSet<d> invoke() {
                HashSet<d> hashSet = new HashSet<>();
                hashSet.add(cf3.a.f30778a);
                hashSet.add(cf3.b.f30779a);
                return hashSet;
            }
        });
        mCacheProvider = lazy2;
    }

    UECacheInfoManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X0() {
        QLog.i("UECacheInfoManager_", 1, "doSync begin");
        bf3.b bVar = bf3.b.f28358a;
        bVar.d();
        bVar.g();
        QLog.i("UECacheInfoManager_", 1, "doSync end");
    }

    private final UECacheData Y0(String cacheKey) {
        UECacheData uECacheData = Z0().get(cacheKey);
        if (uECacheData != null) {
            QLog.i("UECacheInfoManager_", 1, "getCacheData from mem. cacheKey:" + cacheKey + ", data:" + uECacheData);
            return uECacheData;
        }
        UECacheData uECacheData2 = (UECacheData) bf3.a.f28357a.c(bf3.b.f28358a.a(cacheKey));
        QLog.i("UECacheInfoManager_", 1, "getCacheData from mmkv. cacheKey:" + cacheKey + ", dataFromMMKV:" + uECacheData2);
        return uECacheData2;
    }

    private final HashMap<String, UECacheData> Z0() {
        return (HashMap) mCachePool.getValue();
    }

    private final HashSet<d> a1() {
        return (HashSet) mCacheProvider.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b1() {
        Iterator<T> it = f331873b.a1().iterator();
        while (it.hasNext()) {
            ((d) it.next()).refreshCache();
        }
    }

    @Override // ue3.b
    public void V(String cacheKey, UECacheData cacheData) {
        Intrinsics.checkNotNullParameter(cacheKey, "cacheKey");
        Intrinsics.checkNotNullParameter(cacheData, "cacheData");
        Z0().put(cacheKey, cacheData);
        QLog.i("UECacheInfoManager_", 1, "saveCache cacheKey:" + cacheKey + ", cacheData:" + cacheData);
        byte[] a16 = bf3.a.f28357a.a(cacheData);
        if (a16 == null) {
            return;
        }
        bf3.b.f28358a.f(cacheKey, a16);
    }

    @Override // ue3.a
    public String deleteCache(String cacheKey) {
        Intrinsics.checkNotNullParameter(cacheKey, "cacheKey");
        QLog.i("UECacheInfoManager_", 1, "deleteCache cacheKey:" + cacheKey);
        bf3.b.f28358a.e(cacheKey);
        UECacheData remove = Z0().remove(cacheKey);
        Iterator<T> it = a1().iterator();
        while (it.hasNext()) {
            ((d) it.next()).c(cacheKey);
        }
        if (remove != null && remove.isValid()) {
            return remove.getValue();
        }
        return "";
    }

    @Override // ue3.a
    public List<UECacheData> getAllCacheData() {
        ArrayList arrayList = new ArrayList();
        Collection<UECacheData> values = Z0().values();
        Intrinsics.checkNotNullExpressionValue(values, "mCachePool.values");
        for (UECacheData uECacheData : values) {
            if (uECacheData.isValid()) {
                arrayList.add(uECacheData);
            }
        }
        QLog.i("UECacheInfoManager_", 1, "getAllCacheData result:" + arrayList);
        return arrayList;
    }

    @Override // ue3.a
    public String queryCache(String cacheKey) {
        Intrinsics.checkNotNullParameter(cacheKey, "cacheKey");
        UECacheData Y0 = Y0(cacheKey);
        if (Y0 != null && Y0.isValid()) {
            QLog.i("UECacheInfoManager_", 1, "queryCache cacheKey:" + cacheKey + ", return value:" + CommonExKt.g(Y0.getValue()));
            return Y0.getValue();
        }
        QLog.i("UECacheInfoManager_", 1, "queryCache cacheKey:" + cacheKey + ", return empty");
        return "";
    }

    @Override // ue3.a
    public void sync() {
        W0();
    }

    private final void W0() {
        QLog.i("UECacheInfoManager_", 1, "doSync in");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.avatar.impl.cache.a
            @Override // java.lang.Runnable
            public final void run() {
                UECacheInfoManager.X0();
            }
        }, 64, null, false);
    }

    @Override // ue3.b
    public void doWhenQQLogout() {
        QLog.i("UECacheInfoManager_", 1, "doWhenQQLogout");
        Iterator<T> it = a1().iterator();
        while (it.hasNext()) {
            ((d) it.next()).doWhenQQLogout();
        }
        Z0().clear();
        W0();
    }

    @Override // ue3.b
    public void refreshCache() {
        QLog.i("UECacheInfoManager_", 1, "refreshCache");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.avatar.impl.cache.b
            @Override // java.lang.Runnable
            public final void run() {
                UECacheInfoManager.b1();
            }
        });
    }
}
