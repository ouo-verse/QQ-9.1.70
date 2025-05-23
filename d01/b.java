package d01;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH&J\b\u0010\u000b\u001a\u00020\u0004H&J\b\u0010\f\u001a\u00020\u0004H&J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH&J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH&J\u0018\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0001H\u0016\u00a8\u0006\u0015"}, d2 = {"Ld01/b;", "", "", "filePath", "", "setFilePath", "Landroid/view/View;", "d", "", "count", "setRepeatCount", "b", "stopAnimation", "Ld01/c;", "listener", "e", "c", "propKey", "propValue", "", "a", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public interface b {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes7.dex */
    public static final class a {
        public static boolean a(@NotNull b bVar, @NotNull String propKey, @NotNull Object propValue) {
            Intrinsics.checkNotNullParameter(propKey, "propKey");
            Intrinsics.checkNotNullParameter(propValue, "propValue");
            return false;
        }
    }

    boolean a(@NotNull String propKey, @NotNull Object propValue);

    void b();

    void c(@NotNull c listener);

    @NotNull
    View d();

    void e(@NotNull c listener);

    void setFilePath(@NotNull String filePath);

    void setRepeatCount(int count);

    void stopAnimation();
}
