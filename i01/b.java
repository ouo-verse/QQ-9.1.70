package i01;

import android.util.SizeF;
import androidx.annotation.WorkerThread;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0001H'J\u001a\u0010\t\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH'R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\r8&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0013"}, d2 = {"Li01/b;", "", "", "propKey", "propValue", "", "b", "methodName", "params", "d", "Landroid/util/SizeF;", "constraintSize", "c", "Lcom/tencent/kuikly/core/render/android/a;", "getKuiklyRenderContext", "()Lcom/tencent/kuikly/core/render/android/a;", "setKuiklyRenderContext", "(Lcom/tencent/kuikly/core/render/android/a;)V", "kuiklyRenderContext", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public interface b {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes7.dex */
    public static final class a {
        @Nullable
        public static Object a(@NotNull b bVar, @NotNull String methodName, @NotNull String params) {
            Intrinsics.checkNotNullParameter(methodName, "methodName");
            Intrinsics.checkNotNullParameter(params, "params");
            return null;
        }
    }

    @WorkerThread
    void b(@NotNull String propKey, @NotNull Object propValue);

    @WorkerThread
    @NotNull
    SizeF c(@NotNull SizeF constraintSize);

    @Nullable
    Object d(@NotNull String methodName, @NotNull String params);

    void setKuiklyRenderContext(@Nullable com.tencent.kuikly.core.render.android.a aVar);
}
