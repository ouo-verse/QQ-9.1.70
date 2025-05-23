package op;

import android.util.Log;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lop/f;", "", "", "tag", "msg", "", "d", "e", "fg_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public interface f {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    /* loaded from: classes3.dex */
    public static final class a {
        public static void a(f fVar, @NotNull String tag, @NotNull String msg2) {
            Intrinsics.checkParameterIsNotNull(tag, "tag");
            Intrinsics.checkParameterIsNotNull(msg2, "msg");
            Log.d(tag, msg2);
        }

        public static void b(f fVar, @NotNull String tag, @NotNull String msg2) {
            Intrinsics.checkParameterIsNotNull(tag, "tag");
            Intrinsics.checkParameterIsNotNull(msg2, "msg");
            Log.e(tag, msg2);
        }
    }

    void d(@NotNull String tag, @NotNull String msg2);

    void e(@NotNull String tag, @NotNull String msg2);
}
