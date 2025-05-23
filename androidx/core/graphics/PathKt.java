package androidx.core.graphics;

import android.graphics.Path;
import androidx.annotation.RequiresApi;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\f\u001a\u001c\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004*\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007\u001a\u0015\u0010\b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\n\u001a\u0015\u0010\t\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\f\u001a\u0015\u0010\n\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\n\u001a\u0015\u0010\u000b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\f\u00a8\u0006\f"}, d2 = {"and", "Landroid/graphics/Path;", "p", "flatten", "", "Landroidx/core/graphics/PathSegment;", "error", "", "minus", "or", QCircleDaTongConstant.ElementParamValue.PLUS, "xor", "core-ktx_release"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class PathKt {
    @RequiresApi(19)
    @NotNull
    public static final Path and(@NotNull Path and, @NotNull Path p16) {
        Intrinsics.checkNotNullParameter(and, "$this$and");
        Intrinsics.checkNotNullParameter(p16, "p");
        Path path = new Path();
        path.op(and, p16, Path.Op.INTERSECT);
        return path;
    }

    @RequiresApi(26)
    @NotNull
    public static final Iterable<PathSegment> flatten(@NotNull Path flatten, float f16) {
        Intrinsics.checkNotNullParameter(flatten, "$this$flatten");
        Collection<PathSegment> flatten2 = PathUtils.flatten(flatten, f16);
        Intrinsics.checkNotNullExpressionValue(flatten2, "PathUtils.flatten(this, error)");
        return flatten2;
    }

    public static /* synthetic */ Iterable flatten$default(Path path, float f16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            f16 = 0.5f;
        }
        return flatten(path, f16);
    }

    @RequiresApi(19)
    @NotNull
    public static final Path minus(@NotNull Path minus, @NotNull Path p16) {
        Intrinsics.checkNotNullParameter(minus, "$this$minus");
        Intrinsics.checkNotNullParameter(p16, "p");
        Path path = new Path(minus);
        path.op(p16, Path.Op.DIFFERENCE);
        return path;
    }

    @RequiresApi(19)
    @NotNull
    public static final Path or(@NotNull Path or5, @NotNull Path p16) {
        Intrinsics.checkNotNullParameter(or5, "$this$or");
        Intrinsics.checkNotNullParameter(p16, "p");
        Path path = new Path(or5);
        path.op(p16, Path.Op.UNION);
        return path;
    }

    @RequiresApi(19)
    @NotNull
    public static final Path plus(@NotNull Path plus, @NotNull Path p16) {
        Intrinsics.checkNotNullParameter(plus, "$this$plus");
        Intrinsics.checkNotNullParameter(p16, "p");
        Path path = new Path(plus);
        path.op(p16, Path.Op.UNION);
        return path;
    }

    @RequiresApi(19)
    @NotNull
    public static final Path xor(@NotNull Path xor, @NotNull Path p16) {
        Intrinsics.checkNotNullParameter(xor, "$this$xor");
        Intrinsics.checkNotNullParameter(p16, "p");
        Path path = new Path(xor);
        path.op(p16, Path.Op.XOR);
        return path;
    }
}
