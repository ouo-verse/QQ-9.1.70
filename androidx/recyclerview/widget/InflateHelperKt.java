package androidx.recyclerview.widget;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0001\u00a8\u0006\b"}, d2 = {"getInflateResId", "", "Landroid/view/View;", "considerChild", "", "setInflateResId", "", "resId", "layoutinflater_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes.dex */
public final class InflateHelperKt {
    public static final int getInflateResId(@NotNull View getInflateResId, boolean z16) {
        int i3;
        Intrinsics.checkNotNullParameter(getInflateResId, "$this$getInflateResId");
        if (Build.VERSION.SDK_INT >= 29) {
            i3 = getInflateResId.getSourceLayoutResId();
        } else {
            Object tag = getInflateResId.getTag(R.id.sv9);
            if (!(tag instanceof Integer)) {
                tag = null;
            }
            Integer num = (Integer) tag;
            if (num != null) {
                i3 = num.intValue();
            } else {
                i3 = 0;
            }
        }
        if (i3 == 0 && (getInflateResId instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) getInflateResId;
            if (viewGroup.getChildCount() == 1 && z16) {
                View childAt = viewGroup.getChildAt(0);
                Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(0)");
                return getInflateResId(childAt, false);
            }
        }
        return i3;
    }

    public static /* synthetic */ int getInflateResId$default(View view, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        return getInflateResId(view, z16);
    }

    public static final void setInflateResId(@NotNull View setInflateResId, int i3) {
        int sourceLayoutResId;
        Intrinsics.checkNotNullParameter(setInflateResId, "$this$setInflateResId");
        if (Build.VERSION.SDK_INT > 28) {
            sourceLayoutResId = setInflateResId.getSourceLayoutResId();
            if (sourceLayoutResId != 0) {
                return;
            }
        }
        setInflateResId.setTag(R.id.sv9, Integer.valueOf(i3));
    }
}
