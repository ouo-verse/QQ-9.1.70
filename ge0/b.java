package ge0;

import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.biz.qui.quisecnavbar.f;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u001a\u001c\u0010\u0005\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\"(\u0010\f\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00068F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\u00a8\u0006\r"}, d2 = {"Landroid/widget/ImageView;", "view", "Landroid/graphics/drawable/Drawable;", "drawable", "", "c", "", "value", "a", "(Landroid/widget/ImageView;)Z", "b", "(Landroid/widget/ImageView;Z)V", "isCircleBg", "QUISecNavBar_debug"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes5.dex */
public final class b {
    public static final boolean a(@NotNull ImageView isCircleBg) {
        Intrinsics.checkNotNullParameter(isCircleBg, "$this$isCircleBg");
        return Intrinsics.areEqual(isCircleBg.getTag(R.id.f165729xe3), Boolean.TRUE);
    }

    public static final void b(@NotNull ImageView isCircleBg, boolean z16) {
        Intrinsics.checkNotNullParameter(isCircleBg, "$this$isCircleBg");
        isCircleBg.setTag(R.id.f165729xe3, Boolean.valueOf(z16));
    }

    public static final void c(@NotNull ImageView setCircleImageView, @NotNull ImageView view, @Nullable Drawable drawable) {
        Intrinsics.checkNotNullParameter(setCircleImageView, "$this$setCircleImageView");
        Intrinsics.checkNotNullParameter(view, "view");
        if (drawable == null) {
            return;
        }
        Matrix matrix = new Matrix();
        matrix.setScale(f.e() / drawable.getIntrinsicWidth(), f.e() / drawable.getIntrinsicHeight());
        float f16 = 2;
        matrix.postTranslate((f.d() - f.e()) / f16, (f.d() - f.e()) / f16);
        view.setScaleType(ImageView.ScaleType.MATRIX);
        view.setImageMatrix(matrix);
    }
}
