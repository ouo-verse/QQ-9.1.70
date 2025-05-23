package al2;

import android.view.View;
import androidx.viewpager2.widget.ViewPager2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lal2/g;", "Landroidx/viewpager2/widget/ViewPager2$PageTransformer;", "Landroid/view/View;", "page", "", "position", "", "transformPage", "<init>", "()V", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class g implements ViewPager2.PageTransformer {
    @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
    public void transformPage(@NotNull View page, float position) {
        float coerceAtMost;
        Intrinsics.checkNotNullParameter(page, "page");
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(Math.abs(position), 1.0f);
        float f16 = 1.0f - (coerceAtMost * 0.15f);
        page.setScaleX(f16);
        page.setScaleY(f16);
    }
}
