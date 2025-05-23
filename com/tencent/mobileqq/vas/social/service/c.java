package com.tencent.mobileqq.vas.social.service;

import com.tencent.state.square.api.ISquarePushListener;
import com.tencent.state.square.api.ISquarePushService;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016RP\u0010\u0011\u001a>\u0012\u0004\u0012\u00020\u0005\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00070\fj\b\u0012\u0004\u0012\u00020\u0007`\r0\u000bj\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00070\fj\b\u0012\u0004\u0012\u00020\u0007`\r`\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/vas/social/service/c;", "Lcom/tencent/state/square/api/ISquarePushService;", "", "init", "release", "", "type", "Lcom/tencent/state/square/api/ISquarePushListener;", "listener", "addListener", "removeListener", "Ljava/util/HashMap;", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "Lkotlin/collections/HashMap;", "a", "Ljava/util/HashMap;", "listenerMap", "<init>", "()V", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class c implements ISquarePushService {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final HashMap<Integer, HashSet<ISquarePushListener>> listenerMap = new HashMap<>();

    @Override // com.tencent.state.square.api.ISquarePushService
    public void addListener(int type, ISquarePushListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (!this.listenerMap.containsKey(Integer.valueOf(type))) {
            this.listenerMap.put(Integer.valueOf(type), new HashSet<>());
        }
        HashSet<ISquarePushListener> hashSet = this.listenerMap.get(Integer.valueOf(type));
        if (hashSet != null) {
            hashSet.add(listener);
        }
        f33.a.f397786a.a(type, listener);
    }

    @Override // com.tencent.state.square.api.ISquarePushService
    public void release() {
        Set<Map.Entry<Integer, HashSet<ISquarePushListener>>> entrySet = this.listenerMap.entrySet();
        Intrinsics.checkNotNullExpressionValue(entrySet, "listenerMap.entries");
        Iterator<T> it = entrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object value = entry.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "entry.value");
            for (ISquarePushListener iSquarePushListener : (Iterable) value) {
                f33.a aVar = f33.a.f397786a;
                Object key = entry.getKey();
                Intrinsics.checkNotNullExpressionValue(key, "entry.key");
                aVar.c(((Number) key).intValue(), iSquarePushListener);
            }
        }
        this.listenerMap.clear();
    }

    @Override // com.tencent.state.square.api.ISquarePushService
    public void removeListener(int type, ISquarePushListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        f33.a.f397786a.c(type, listener);
        HashSet<ISquarePushListener> hashSet = this.listenerMap.get(Integer.valueOf(type));
        if (hashSet != null) {
            hashSet.remove(listener);
        }
    }

    @Override // com.tencent.state.square.api.ISquarePushService
    public void init() {
    }
}
