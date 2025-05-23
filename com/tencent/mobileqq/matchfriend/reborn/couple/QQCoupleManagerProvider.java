package com.tencent.mobileqq.matchfriend.reborn.couple;

import com.tencent.mobileqq.matchfriend.reborn.couple.model.IQQCoupleModel;
import com.tencent.mobileqq.matchfriend.reborn.couple.preprocessor.QQStrangerInteractiveMarkPreprocessor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0006\u001a\u00020\u0004J.\u0010\f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000b\"\b\b\u0000\u0010\b*\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\tR$\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b0\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000eR \u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000eR?\u0010\u0017\u001a&\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00130\u0012j\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0013`\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u0010\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/couple/QQCoupleManagerProvider;", "", "", "bizId", "", "a", "d", "Lcom/tencent/mobileqq/matchfriend/reborn/couple/model/IQQCoupleModel;", "T", "Ljava/lang/Class;", "clz", "Lcom/tencent/mobileqq/matchfriend/reborn/couple/QQCoupleManager;", "b", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "managerMap", "c", "managerLock", "Ljava/util/HashMap;", "Lcom/tencent/mobileqq/matchfriend/reborn/couple/preprocessor/a;", "Lkotlin/collections/HashMap;", "Lkotlin/Lazy;", "()Ljava/util/HashMap;", "preprocessorMap", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQCoupleManagerProvider {

    /* renamed from: a, reason: collision with root package name */
    public static final QQCoupleManagerProvider f245049a = new QQCoupleManagerProvider();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final ConcurrentHashMap<Integer, QQCoupleManager<?>> managerMap = new ConcurrentHashMap<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final ConcurrentHashMap<Integer, Object> managerLock = new ConcurrentHashMap<>();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final Lazy preprocessorMap;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<HashMap<Integer, com.tencent.mobileqq.matchfriend.reborn.couple.preprocessor.a<?>>>() { // from class: com.tencent.mobileqq.matchfriend.reborn.couple.QQCoupleManagerProvider$preprocessorMap$2
            @Override // kotlin.jvm.functions.Function0
            public final HashMap<Integer, com.tencent.mobileqq.matchfriend.reborn.couple.preprocessor.a<?>> invoke() {
                HashMap<Integer, com.tencent.mobileqq.matchfriend.reborn.couple.preprocessor.a<?>> hashMapOf;
                com.tencent.mobileqq.matchfriend.reborn.couple.model.b bVar = com.tencent.mobileqq.matchfriend.reborn.couple.model.b.f245072a;
                hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to(Integer.valueOf(bVar.b()), new QQStrangerInteractiveMarkPreprocessor()), TuplesKt.to(Integer.valueOf(bVar.a()), new QQStrangerInteractiveMarkPreprocessor()));
                return hashMapOf;
            }
        });
        preprocessorMap = lazy;
    }

    QQCoupleManagerProvider() {
    }

    private final void a(int bizId) {
        ConcurrentHashMap<Integer, Object> concurrentHashMap = managerLock;
        if (concurrentHashMap.get(Integer.valueOf(bizId)) == null) {
            synchronized (concurrentHashMap) {
                if (concurrentHashMap.get(Integer.valueOf(bizId)) == null) {
                    concurrentHashMap.put(Integer.valueOf(bizId), new Object());
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    private final HashMap<Integer, com.tencent.mobileqq.matchfriend.reborn.couple.preprocessor.a<?>> c() {
        return (HashMap) preprocessorMap.getValue();
    }

    public final <T extends IQQCoupleModel> QQCoupleManager<T> b(int bizId, Class<T> clz) {
        QQCoupleManager<T> qQCoupleManager;
        Intrinsics.checkNotNullParameter(clz, "clz");
        ConcurrentHashMap<Integer, QQCoupleManager<?>> concurrentHashMap = managerMap;
        Object obj = concurrentHashMap.get(Integer.valueOf(bizId));
        QQCoupleManager<T> qQCoupleManager2 = obj instanceof QQCoupleManager ? (QQCoupleManager) obj : null;
        if (qQCoupleManager2 != null) {
            return qQCoupleManager2;
        }
        a(bizId);
        Object obj2 = managerLock.get(Integer.valueOf(bizId));
        Intrinsics.checkNotNull(obj2);
        synchronized (obj2) {
            qQCoupleManager = new QQCoupleManager<>(String.valueOf(bizId), clz);
            Object obj3 = f245049a.c().get(Integer.valueOf(bizId));
            qQCoupleManager.z(obj3 instanceof com.tencent.mobileqq.matchfriend.reborn.couple.preprocessor.a ? (com.tencent.mobileqq.matchfriend.reborn.couple.preprocessor.a) obj3 : null);
            concurrentHashMap.put(Integer.valueOf(bizId), qQCoupleManager);
            Unit unit = Unit.INSTANCE;
        }
        return qQCoupleManager;
    }

    public final void d() {
        Iterator<Map.Entry<Integer, QQCoupleManager<?>>> it = managerMap.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().r();
        }
        managerMap.clear();
    }
}
