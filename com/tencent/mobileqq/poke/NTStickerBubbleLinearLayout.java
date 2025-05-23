package com.tencent.mobileqq.poke;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0004\b\f\u0010\rJ \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0018\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/poke/NTStickerBubbleLinearLayout;", "Landroid/widget/LinearLayout;", "Landroid/view/View;", "view", "", HippyTKDListViewAdapter.X, "y", "", "a", "b", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class NTStickerBubbleLinearLayout extends LinearLayout {
    static IPatchRedirector $redirector_;

    public NTStickerBubbleLinearLayout(@Nullable Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    private final boolean a(View view, float x16, float y16) {
        if (x16 < view.getLeft() || x16 > view.getRight() || y16 < view.getTop() || y16 > view.getBottom()) {
            return false;
        }
        return true;
    }

    @Nullable
    public final View b(float x16, float y16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, this, Float.valueOf(x16), Float.valueOf(y16));
        }
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childView = getChildAt(i3);
            Intrinsics.checkNotNullExpressionValue(childView, "childView");
            if (a(childView, x16, y16)) {
                return childView;
            }
        }
        return null;
    }
}
