package cp1;

import androidx.collection.LruCache;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002R \u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcp1/d;", "", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "task", "", "a", "", "b", "Landroidx/collection/LruCache;", "", "Landroidx/collection/LruCache;", "lruCache", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f391542a = new d();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final LruCache<String, Boolean> lruCache = new LruCache<>(10);

    d() {
    }

    public final void a(@NotNull IPerformanceReportTask task) {
        Intrinsics.checkNotNullParameter(task, "task");
        String traceId = task.getTraceId();
        LruCache<String, Boolean> lruCache2 = lruCache;
        if (lruCache2.get(traceId) == null) {
            lruCache2.put(traceId, Boolean.TRUE);
        }
    }

    public final boolean b(@NotNull IPerformanceReportTask task) {
        Intrinsics.checkNotNullParameter(task, "task");
        String traceId = task.getTraceId();
        LruCache<String, Boolean> lruCache2 = lruCache;
        if (lruCache2.get(traceId) != null) {
            task.duplicate("guild_id").setStageCode("stage_first_tab").report();
            lruCache2.remove(traceId);
            return true;
        }
        return false;
    }
}
