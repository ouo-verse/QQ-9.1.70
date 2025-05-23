package androidx.recyclerview.widget;

import android.graphics.Matrix;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/graphics/Matrix;", "invoke"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes.dex */
final class AIOSkeletonRecycleView$skeletonOutlineMatrix$2 extends Lambda implements Function0<Matrix> {
    public static final AIOSkeletonRecycleView$skeletonOutlineMatrix$2 INSTANCE = new AIOSkeletonRecycleView$skeletonOutlineMatrix$2();

    AIOSkeletonRecycleView$skeletonOutlineMatrix$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final Matrix invoke() {
        return new Matrix();
    }
}
