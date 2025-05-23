package com.tencent.state.library.focus.view;

import android.content.Context;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/state/library/focus/view/FocusCommonViewConfig;", "Lcom/tencent/state/library/focus/view/ICommonViewConfig;", "()V", "getBubbleGroupTitle", "", "context", "Landroid/content/Context;", "getBubbleSingleTitle", "getCommonTitle", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class FocusCommonViewConfig implements ICommonViewConfig {
    @Override // com.tencent.state.library.focus.view.ICommonViewConfig
    public String getBubbleGroupTitle(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String string = context.getString(R.string.xgj);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026ary_together_focus_title)");
        return string;
    }

    @Override // com.tencent.state.library.focus.view.ICommonViewConfig
    public String getBubbleSingleTitle(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String string = context.getString(R.string.xgg);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026brary_single_focus_title)");
        return string;
    }

    @Override // com.tencent.state.library.focus.view.ICommonViewConfig
    public String getCommonTitle(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return "\u4e13\u6ce8\u4e2d";
    }
}
