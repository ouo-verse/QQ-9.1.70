package androidx.compose.runtime;

import com.heytap.databaseengine.type.DeviceType;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u001d\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00028\u0000H&\u00a2\u0006\u0002\u0010\u0007J'\u0010\b\u001a\u0004\u0018\u00018\u00002\u0006\u0010\t\u001a\u00028\u00002\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\f\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\r\u00c0\u0006\u0003"}, d2 = {"Landroidx/compose/runtime/SnapshotMutationPolicy;", "T", "", "equivalent", "", "a", "b", "(Ljava/lang/Object;Ljava/lang/Object;)Z", DeviceType.DeviceCategory.MERGER, "previous", "current", "applied", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes39.dex */
public interface SnapshotMutationPolicy<T> {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes39.dex */
    public static final class DefaultImpls {
        @Deprecated
        public static <T> T merge(SnapshotMutationPolicy<T> snapshotMutationPolicy, T t16, T t17, T t18) {
            Object a16;
            a16 = e.a(snapshotMutationPolicy, t16, t17, t18);
            return (T) a16;
        }
    }

    boolean equivalent(T a16, T b16);

    T merge(T previous, T current, T applied);
}
