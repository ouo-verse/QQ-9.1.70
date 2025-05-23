package com.tencent.mm.ui.widget.pulldown;

import android.view.View;
import android.widget.AbsListView;
import android.widget.ScrollView;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0003\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0004\u001a\n\u0010\u0005\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0005\u001a\u00020\u0001*\u00020\u0003\u001a\n\u0010\u0005\u001a\u00020\u0001*\u00020\u0004\u001a\u0014\u0010\u0006\u001a\u00020\u0007*\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\t\u001a\u0014\u0010\n\u001a\u00020\u0007*\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u000b\u00a8\u0006\f"}, d2 = {"isAtEnd", "", "Landroid/view/View;", "Landroid/widget/AbsListView;", "Landroid/widget/ScrollView;", "isAtStart", "setAtEndCallback", "", "callback", "Lcom/tencent/mm/ui/widget/pulldown/AtEndCallback;", "setAtStartCallback", "Lcom/tencent/mm/ui/widget/pulldown/AtStartCallback;", "weui-native-android-lib_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes9.dex */
public final class WeUIBounceCommonKt {
    public static final boolean isAtEnd(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Object tag = view.getTag(R.id.f122267dh);
        if (tag instanceof AtEndCallback) {
            return ((AtEndCallback) tag).isAtEnd();
        }
        if (view instanceof ScrollView) {
            return isAtEnd((ScrollView) view);
        }
        if (view instanceof AbsListView) {
            return isAtEnd((AbsListView) view);
        }
        return true;
    }

    public static final boolean isAtStart(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Object tag = view.getTag(R.id.f122277di);
        if (tag instanceof AtStartCallback) {
            return ((AtStartCallback) tag).isAtStart();
        }
        if (view instanceof ScrollView) {
            return isAtStart((ScrollView) view);
        }
        if (view instanceof AbsListView) {
            return isAtStart((AbsListView) view);
        }
        return true;
    }

    public static final void setAtEndCallback(@NotNull View view, @Nullable AtEndCallback atEndCallback) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setTag(R.id.f122267dh, atEndCallback);
    }

    public static final void setAtStartCallback(@NotNull View view, @Nullable AtStartCallback atStartCallback) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setTag(R.id.f122277di, atStartCallback);
    }

    public static final boolean isAtEnd(@NotNull ScrollView scrollView) {
        Intrinsics.checkNotNullParameter(scrollView, "<this>");
        return !scrollView.canScrollVertically(1);
    }

    public static final boolean isAtStart(@NotNull ScrollView scrollView) {
        Intrinsics.checkNotNullParameter(scrollView, "<this>");
        return !scrollView.canScrollVertically(-1);
    }

    public static final boolean isAtEnd(@NotNull AbsListView absListView) {
        Intrinsics.checkNotNullParameter(absListView, "<this>");
        if (absListView.getChildCount() <= 0) {
            return false;
        }
        int childCount = absListView.getChildCount();
        return absListView.getFirstVisiblePosition() + childCount >= absListView.getCount() && absListView.getChildAt(childCount - 1).getBottom() <= absListView.getHeight() - absListView.getListPaddingBottom();
    }

    public static final boolean isAtStart(@NotNull AbsListView absListView) {
        Intrinsics.checkNotNullParameter(absListView, "<this>");
        if (absListView.getChildCount() <= 0) {
            return true;
        }
        return absListView.getFirstVisiblePosition() <= 0 && absListView.getChildAt(0).getTop() >= absListView.getListPaddingTop();
    }
}
