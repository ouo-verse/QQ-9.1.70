package ko1;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.ViewGroupUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a4\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u0001H\u0007\u00a8\u0006\b"}, d2 = {"Landroid/view/View;", "", "leftPx", "topPx", "rightPx", "bottomPx", "", "b", "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class b {
    @SuppressLint({"RestrictedApi"})
    public static final void b(@NotNull final View view, final int i3, final int i16, final int i17, final int i18) {
        ViewGroup viewGroup;
        Intrinsics.checkNotNullParameter(view, "<this>");
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            viewGroup = (ViewGroup) parent;
        } else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            return;
        }
        final ViewGroup viewGroup2 = viewGroup;
        viewGroup.post(new Runnable() { // from class: ko1.a
            @Override // java.lang.Runnable
            public final void run() {
                b.d(viewGroup2, view, i3, i16, i17, i18);
            }
        });
    }

    public static /* synthetic */ void c(View view, int i3, int i16, int i17, int i18, int i19, Object obj) {
        if ((i19 & 1) != 0) {
            i3 = 0;
        }
        if ((i19 & 2) != 0) {
            i16 = 0;
        }
        if ((i19 & 4) != 0) {
            i17 = 0;
        }
        if ((i19 & 8) != 0) {
            i18 = 0;
        }
        b(view, i3, i16, i17, i18);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(ViewGroup parentView, View this_expandTouchZone, int i3, int i16, int i17, int i18) {
        Intrinsics.checkNotNullParameter(parentView, "$parentView");
        Intrinsics.checkNotNullParameter(this_expandTouchZone, "$this_expandTouchZone");
        Rect rect = new Rect();
        ViewGroupUtils.getDescendantRect(parentView, this_expandTouchZone, rect);
        rect.left -= i3;
        rect.top -= i16;
        rect.right += i17;
        rect.bottom += i18;
        parentView.setTouchDelegate(new TouchDelegate(rect, this_expandTouchZone));
    }
}
