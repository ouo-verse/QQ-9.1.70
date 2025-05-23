package k01;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u001c\n\u0002\b\u0003\u001a)\u0010\u0003\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"", "T", "", "a", "(Ljava/lang/Iterable;)Ljava/lang/Comparable;", "core-render-android_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class b {
    @Nullable
    public static final <T extends Comparable<? super T>> T a(@NotNull Iterable<? extends T> getMax) {
        Intrinsics.checkNotNullParameter(getMax, "$this$getMax");
        Iterator<? extends T> it = getMax.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (next.compareTo(next2) < 0) {
                next = next2;
            }
        }
        return next;
    }
}
