package com.tencent.mm.ui.widget.pulldown;

import android.graphics.Rect;
import android.view.View;
import com.tencent.luggage.wxa.lo.n;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u00a8\u0006\u0003"}, d2 = {"isCompleteVisible", "", "Landroid/view/View;", "weui-native-android-lib_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes9.dex */
public final class MMPullDownHelperKt {
    public static final boolean isCompleteVisible(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        boolean z16 = true;
        if (view.getVisibility() == 8) {
            return true;
        }
        if (!view.isShown()) {
            return false;
        }
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        if (rect.width() < view.getMeasuredWidth() || rect.height() < view.getMeasuredHeight()) {
            z16 = false;
        }
        if (MMPullDownHelper.INSTANCE.isDebug()) {
            n.a("WeUIPullDownView", "isComVisible:" + z16 + " acWidth:" + rect.width() + ", vwidth:" + view.getMeasuredWidth() + ",acHeight:" + rect.height() + ", vHeight:" + view.getMeasuredHeight(), new Object[0]);
        }
        return z16;
    }
}
