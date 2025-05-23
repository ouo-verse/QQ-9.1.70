package com.tencent.mobileqq.zplan.servlet.avatar;

import com.tencent.mobileqq.vas.banner.c;
import com.tencent.mobileqq.zplan.model.ZPlanAvatar;
import com.tencent.mobileqq.zplan.persistent.ZplanDataRepository;
import com.tencent.mobileqq.zplan.utils.ZDispatchers;
import com.tencent.util.LRULinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import nk3.f;
import nk3.j;
import tl.h;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001&B\t\b\u0002\u00a2\u0006\u0004\b$\u0010%J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J#\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\b\u0010\tJ\u0016\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nJ\u0016\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u000eJ \u0010\u0013\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u000b\u001a\u0004\u0018\u00010\u0012R \u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00150\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R \u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00100\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0017R(\u0010\u001f\u001a\u0016\u0012\u0004\u0012\u00020\u001c\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00060\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/zplan/servlet/avatar/CachedZPlanAvatarRequest;", "", "", "uin", "", h.F, "Lkotlinx/coroutines/Deferred;", "Lcom/tencent/mobileqq/zplan/model/f;", "f", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lnk3/j;", "callback", "", "i", "Lnk3/f;", "g", "Lcom/tencent/mobileqq/zplan/model/f$a;", "dynamicAvatar", "Lnk3/a;", "j", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mobileqq/zplan/model/f$b;", "b", "Ljava/util/concurrent/ConcurrentHashMap;", "staticAvatarCache", "c", "dynamicAvatarCache", "Lcom/tencent/util/LRULinkedHashMap;", "Lcom/tencent/mobileqq/zplan/servlet/avatar/CachedZPlanAvatarRequest$a;", "d", "Lcom/tencent/util/LRULinkedHashMap;", "deferredCache", "Lkotlinx/coroutines/CoroutineScope;", "e", "Lkotlinx/coroutines/CoroutineScope;", "scope", "<init>", "()V", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class CachedZPlanAvatarRequest {

    /* renamed from: a, reason: collision with root package name */
    public static final CachedZPlanAvatarRequest f335391a = new CachedZPlanAvatarRequest();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final ConcurrentHashMap<Long, ZPlanAvatar.ZPlanStaticAvatar> staticAvatarCache = new ConcurrentHashMap<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final ConcurrentHashMap<Long, ZPlanAvatar.ZPlanDynamicAvatar> dynamicAvatarCache = new ConcurrentHashMap<>();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final LRULinkedHashMap<Key, Deferred<ZPlanAvatar>> deferredCache = new LRULinkedHashMap<>(50);

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final CoroutineScope scope = CoroutineScopeKt.CoroutineScope(ZDispatchers.f335734a.a());

    CachedZPlanAvatarRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object f(long j3, Continuation<? super Deferred<ZPlanAvatar>> continuation) {
        Deferred<ZPlanAvatar> deferred;
        Key key = new Key(j3, h(j3));
        synchronized (this) {
            LRULinkedHashMap<Key, Deferred<ZPlanAvatar>> lRULinkedHashMap = deferredCache;
            Deferred<ZPlanAvatar> deferred2 = lRULinkedHashMap.get(key);
            if (deferred2 == null) {
                deferred2 = BuildersKt__Builders_commonKt.async$default(scope, null, null, new CachedZPlanAvatarRequest$getCachedAvatarAsync$2$1$1(j3, key, null), 3, null);
                lRULinkedHashMap.put(key, deferred2);
            }
            deferred = deferred2;
        }
        Intrinsics.checkNotNullExpressionValue(deferred, "synchronized(this) {\n   \u2026}\n            }\n        }");
        return deferred;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String h(long uin) {
        return ZplanDataRepository.l(ZplanDataRepository.f334898a, String.valueOf(uin), false, 2, null).appearanceKey;
    }

    public final void g(long uin, f callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        BuildersKt__Builders_commonKt.launch$default(scope, null, null, new CachedZPlanAvatarRequest$getDynamicAvatar$1(uin, callback, null), 3, null);
    }

    public final void i(long uin, j callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        BuildersKt__Builders_commonKt.launch$default(scope, null, null, new CachedZPlanAvatarRequest$getStaticAvatar$1(uin, callback, null), 3, null);
    }

    public final void j(long uin, ZPlanAvatar.ZPlanDynamicAvatar dynamicAvatar, nk3.a callback) {
        Intrinsics.checkNotNullParameter(dynamicAvatar, "dynamicAvatar");
        ConcurrentHashMap<Long, ZPlanAvatar.ZPlanDynamicAvatar> concurrentHashMap = dynamicAvatarCache;
        ZPlanAvatar.ZPlanDynamicAvatar zPlanDynamicAvatar = concurrentHashMap.get(Long.valueOf(uin));
        if (zPlanDynamicAvatar == null || zPlanDynamicAvatar.getTimestamp() <= dynamicAvatar.getTimestamp()) {
            concurrentHashMap.put(Long.valueOf(uin), dynamicAvatar);
            b.f335401a.d(uin, dynamicAvatar, callback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\f\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\n\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/zplan/servlet/avatar/CachedZPlanAvatarRequest$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "getUin", "()J", "uin", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "appearanceKey", "<init>", "(JLjava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.servlet.avatar.CachedZPlanAvatarRequest$a, reason: from toString */
    /* loaded from: classes34.dex */
    public static final /* data */ class Key {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final long uin;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final String appearanceKey;

        public Key(long j3, String appearanceKey) {
            Intrinsics.checkNotNullParameter(appearanceKey, "appearanceKey");
            this.uin = j3;
            this.appearanceKey = appearanceKey;
        }

        /* renamed from: a, reason: from getter */
        public final String getAppearanceKey() {
            return this.appearanceKey;
        }

        public int hashCode() {
            return (c.a(this.uin) * 31) + this.appearanceKey.hashCode();
        }

        public String toString() {
            return "Key(uin=" + this.uin + ", appearanceKey=" + this.appearanceKey + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Key)) {
                return false;
            }
            Key key = (Key) other;
            return this.uin == key.uin && Intrinsics.areEqual(this.appearanceKey, key.appearanceKey);
        }
    }
}
