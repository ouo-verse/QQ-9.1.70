package k64;

import com.tencent.mvi.runtime.strategy.IStrategyFetcher;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J*\u0010\b\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0016J%\u0010\t\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016\u00a2\u0006\u0004\b\t\u0010\nJ\u001c\u0010\f\u001a\u00020\u000b\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016R(\u0010\u000f\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lk64/b;", "Lcom/tencent/mvi/runtime/strategy/b;", "T", "Ljava/lang/Class;", "clazz", "Lcom/tencent/mvi/runtime/strategy/IStrategyFetcher;", "fetcher", "", "c", "b", "(Ljava/lang/Class;)Ljava/lang/Object;", "", "a", "", "Ljava/util/Map;", "servicePool", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public class b implements com.tencent.mvi.runtime.strategy.b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<Class<?>, IStrategyFetcher<?>> servicePool = new LinkedHashMap();

    @Override // com.tencent.mvi.runtime.strategy.b
    public <T> boolean a(@NotNull Class<T> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        return this.servicePool.containsKey(clazz);
    }

    @Override // com.tencent.mvi.runtime.strategy.b
    @Nullable
    public <T> T b(@NotNull Class<T> clazz) {
        IStrategyFetcher<?> iStrategyFetcher;
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        IStrategyFetcher<?> iStrategyFetcher2 = this.servicePool.get(clazz);
        if (iStrategyFetcher2 instanceof IStrategyFetcher) {
            iStrategyFetcher = iStrategyFetcher2;
        } else {
            iStrategyFetcher = null;
        }
        if (iStrategyFetcher == null) {
            return null;
        }
        return (T) iStrategyFetcher.b();
    }

    @Override // com.tencent.mvi.runtime.strategy.b
    public <T> void c(@NotNull Class<T> clazz, @NotNull IStrategyFetcher<T> fetcher) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(fetcher, "fetcher");
        this.servicePool.put(clazz, fetcher);
    }
}
