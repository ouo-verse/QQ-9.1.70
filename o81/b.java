package o81;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0012\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0012\u0010\u0005\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u001a-\u0010\n\u001a\u00028\u0000\"\b\b\u0000\u0010\u0006*\u00020\u0000*\u00028\u00002\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0001\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"Landroid/view/View;", "", "padding", "", "d", "c", "V", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "index", "a", "(Landroid/view/View;Landroid/view/ViewGroup;I)Landroid/view/View;", "aio_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class b {
    @NotNull
    public static final <V extends View> V a(@NotNull V v3, @NotNull ViewGroup parent, int i3) {
        ViewGroup viewGroup;
        Intrinsics.checkNotNullParameter(v3, "<this>");
        Intrinsics.checkNotNullParameter(parent, "parent");
        ViewParent parent2 = v3.getParent();
        if (parent2 instanceof ViewGroup) {
            viewGroup = (ViewGroup) parent2;
        } else {
            viewGroup = null;
        }
        if (viewGroup != null && !Intrinsics.areEqual(viewGroup, parent)) {
            viewGroup.removeViewInLayout(v3);
            parent.addView(v3, i3);
        } else if (viewGroup == null) {
            parent.addView(v3, i3);
        }
        return v3;
    }

    public static /* synthetic */ View b(View view, ViewGroup viewGroup, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = -1;
        }
        return a(view, viewGroup, i3);
    }

    public static final void c(@NotNull View view, int i3) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), i3);
    }

    public static final void d(@NotNull View view, int i3) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), i3, view.getPaddingBottom());
    }
}
