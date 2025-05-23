package f33;

import com.tencent.mobileqq.vas.social.AccountChangedNotifier;
import com.tencent.state.square.api.ISquarePushListener;
import com.tencent.xaction.log.b;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bJ\u0016\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bR0\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\b0\rj\b\u0012\u0004\u0012\u00020\b`\u000e0\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lf33/a;", "", "", "type", "", "data", "", "b", "Lcom/tencent/state/square/api/ISquarePushListener;", "observer", "a", "c", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "Ljava/util/concurrent/ConcurrentHashMap;", "pushObserverMap", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f397786a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final ConcurrentHashMap<Integer, HashSet<ISquarePushListener>> pushObserverMap;

    static {
        AccountChangedNotifier.a();
        pushObserverMap = new ConcurrentHashMap<>();
    }

    a() {
    }

    public final synchronized void a(int type, ISquarePushListener observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        ConcurrentHashMap<Integer, HashSet<ISquarePushListener>> concurrentHashMap = pushObserverMap;
        if (!concurrentHashMap.containsKey(Integer.valueOf(type))) {
            concurrentHashMap.put(Integer.valueOf(type), new HashSet<>());
        }
        HashSet<ISquarePushListener> hashSet = concurrentHashMap.get(Integer.valueOf(type));
        if (hashSet != null) {
            hashSet.add(observer);
        }
    }

    public final void b(int type, byte[] data) {
        Intrinsics.checkNotNullParameter(data, "data");
        b.a("ZPlanVasOIDBPushManager", 2, "onReceive type:" + type);
        HashSet<ISquarePushListener> hashSet = pushObserverMap.get(Integer.valueOf(type));
        if (hashSet != null) {
            Iterator<T> it = hashSet.iterator();
            while (it.hasNext()) {
                ((ISquarePushListener) it.next()).onResult(data);
            }
        }
    }

    public final synchronized void c(int type, ISquarePushListener observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        HashSet<ISquarePushListener> hashSet = pushObserverMap.get(Integer.valueOf(type));
        if (hashSet != null) {
            hashSet.remove(observer);
        }
    }
}
