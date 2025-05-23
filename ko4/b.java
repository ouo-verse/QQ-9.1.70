package ko4;

import androidx.lifecycle.LiveData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a%\u0010\u0003\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0002\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"T", "Landroidx/lifecycle/LiveData;", "default", "a", "(Landroidx/lifecycle/LiveData;Ljava/lang/Object;)Ljava/lang/Object;", "timi-game-api_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class b {
    public static final <T> T a(@NotNull LiveData<T> liveData, T t16) {
        Intrinsics.checkNotNullParameter(liveData, "<this>");
        T value = liveData.getValue();
        if (value != null) {
            return value;
        }
        return t16;
    }
}
