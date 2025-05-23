package ge0;

import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.qui.quiblurview.QQBlurViewWrapper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\",\u0010\u0007\u001a\u0004\u0018\u00010\u0001*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qui/quiblurview/QQBlurViewWrapper;", "Landroid/view/View;", "value", "a", "(Lcom/tencent/qui/quiblurview/QQBlurViewWrapper;)Landroid/view/View;", "b", "(Lcom/tencent/qui/quiblurview/QQBlurViewWrapper;Landroid/view/View;)V", "bgView", "QUISecNavBar_debug"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes5.dex */
public final class a {
    @Nullable
    public static final View a(@NotNull QQBlurViewWrapper bgView) {
        Intrinsics.checkNotNullParameter(bgView, "$this$bgView");
        Object tag = bgView.getTag(R.id.f164619t92);
        if (!(tag instanceof View)) {
            tag = null;
        }
        return (View) tag;
    }

    public static final void b(@NotNull QQBlurViewWrapper bgView, @Nullable View view) {
        Intrinsics.checkNotNullParameter(bgView, "$this$bgView");
        bgView.setTag(R.id.f164619t92, view);
    }
}
