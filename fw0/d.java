package fw0;

import android.graphics.PointF;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J \u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J \u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lfw0/d;", "Lfw0/c;", "Landroid/graphics/PointF;", "start", "end", "", "percent", "getX", "getY", "Lfw0/b;", "a", "Lfw0/b;", "getCurveUtil", "()Lfw0/b;", "curveUtil", "<init>", "()V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class d implements c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b curveUtil;

    public d() {
        b bVar = new b();
        this.curveUtil = bVar;
        bVar.c(true);
    }

    @Override // fw0.c
    public float getX(@NotNull PointF start, @NotNull PointF end, float percent) {
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(end, "end");
        return this.curveUtil.a(start, end, percent);
    }

    @Override // fw0.c
    public float getY(@NotNull PointF start, @NotNull PointF end, float percent) {
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(end, "end");
        return this.curveUtil.b(start, end, percent);
    }
}
