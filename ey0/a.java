package ey0;

import androidx.collection.LruCache;
import com.tencent.icgame.game.utils.g;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.aspectj.lang.JoinPoint;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u00020\u0001B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u0001\u00a2\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\t\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u0001\u00a2\u0006\u0004\b\t\u0010\bJ\u0017\u0010\n\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0004\u001a\u00028\u0000\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\f\u001a\u00020\u0006J\u0014\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\rH\u0004R\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0010R \u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Ley0/a;", "", "K", "V", "key", "value", "", "e", "(Ljava/lang/Object;Ljava/lang/Object;)V", "d", "a", "(Ljava/lang/Object;)Ljava/lang/Object;", "c", "", "b", "", "I", "maxCache", "Landroidx/collection/LruCache;", "Landroidx/collection/LruCache;", "lruCahce", "Ljava/lang/Object;", JoinPoint.SYNCHRONIZATION_LOCK, "<init>", "(I)V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public class a<K, V> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int maxCache;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LruCache<K, V> lruCahce;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Object lock = new Object();

    public a(int i3) {
        this.maxCache = i3;
        this.lruCahce = new LruCache<>(i3);
    }

    @Nullable
    public final V a(@NotNull K key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.lruCahce.get(key);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final Map<K, V> b() {
        Map<K, V> snapshot = this.lruCahce.snapshot();
        Intrinsics.checkNotNullExpressionValue(snapshot, "lruCahce.snapshot()");
        return snapshot;
    }

    public final void c() {
        g.h("BaseCacheManager ", "clear " + this.lruCahce.size());
        synchronized (this.lock) {
            this.lruCahce.evictAll();
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void d(@NotNull K key, @NotNull V value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        synchronized (this.lock) {
            this.lruCahce.put(key, value);
        }
    }

    public final void e(@NotNull K key, @NotNull V value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        if (this.lruCahce.get(key) != null) {
            d(key, value);
        }
    }
}
