package ge3;

import android.graphics.Rect;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u00a8\u0006\u0003"}, d2 = {"Landroid/view/View;", "Landroid/graphics/Rect;", "a", "zplan_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b {
    public static final Rect a(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Rect rect = new Rect();
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i3 = iArr[0];
        rect.left = i3;
        rect.top = iArr[1];
        rect.right = i3 + view.getWidth();
        rect.bottom = rect.top + view.getHeight();
        return rect;
    }
}
