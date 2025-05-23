package d01;

import android.view.View;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH&J\b\u0010\u000b\u001a\u00020\u0006H&J\b\u0010\f\u001a\u00020\u0006H&J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH&J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH&J\u0016\u0010\u0014\u001a\u00020\u00062\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H&J\u0018\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004H'J\u0018\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H'J\u0018\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0001H\u0016\u00a8\u0006\u001d"}, d2 = {"Ld01/s;", "", "Landroid/view/View;", "d", "", "filePath", "", "setFilePath", "", "count", "setPAGViewRepeatCount", "f", "i", "Ld01/t;", "listener", tl.h.F, "e", "", "Ld01/x;", "items", "g", "layerName", "text", "c", "b", "propKey", "propValue", "", "a", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public interface s {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes7.dex */
    public static final class a {
        public static boolean a(@NotNull s sVar, @NotNull String propKey, @NotNull Object propValue) {
            Intrinsics.checkNotNullParameter(propKey, "propKey");
            Intrinsics.checkNotNullParameter(propValue, "propValue");
            return false;
        }
    }

    boolean a(@NotNull String propKey, @NotNull Object propValue);

    @Deprecated(message = "use replaceLayerContents instead", replaceWith = @ReplaceWith(expression = "replaceLayerContents(items)", imports = {}))
    void b(@NotNull String layerName, @NotNull String filePath);

    @Deprecated(message = "use replaceLayerContents instead", replaceWith = @ReplaceWith(expression = "replaceLayerContents(items)", imports = {}))
    void c(@NotNull String layerName, @NotNull String text);

    @NotNull
    View d();

    void e(@NotNull t listener);

    void f();

    void g(@NotNull List<x> items);

    void h(@NotNull t listener);

    void i();

    void setFilePath(@NotNull String filePath);

    void setPAGViewRepeatCount(int count);
}
