package com.tencent.state.square.detail;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.tencent.state.square.common.ViewExtensionsKt;
import com.tencent.state.square.databinding.VasSquareDetailMeSettingTipsBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\fJ\b\u0010\u000e\u001a\u00020\u000fH\u0002R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/state/square/detail/DetailMeSettingTipsBubble;", "Landroid/widget/PopupWindow;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "binding", "Lcom/tencent/state/square/databinding/VasSquareDetailMeSettingTipsBinding;", "getBinding", "()Lcom/tencent/state/square/databinding/VasSquareDetailMeSettingTipsBinding;", "getContext", "()Landroid/content/Context;", "getTipsHeight", "", "getTipsWidth", "initView", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class DetailMeSettingTipsBubble extends PopupWindow {
    private final VasSquareDetailMeSettingTipsBinding binding;
    private final Context context;

    public DetailMeSettingTipsBubble(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        VasSquareDetailMeSettingTipsBinding inflate = VasSquareDetailMeSettingTipsBinding.inflate(LayoutInflater.from(context));
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareDetailMeSetting\u2026later.from(context)\n    )");
        this.binding = inflate;
        initView();
    }

    public final VasSquareDetailMeSettingTipsBinding getBinding() {
        return this.binding;
    }

    public final Context getContext() {
        return this.context;
    }

    public final int getTipsHeight() {
        return ViewExtensionsKt.dip(this.context, 46);
    }

    private final void initView() {
        setWidth(-2);
        setHeight(-2);
        setOutsideTouchable(false);
        setFocusable(false);
        setContentView(this.binding.getRoot());
    }

    public final int getTipsWidth() {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.binding.getRoot().measure(makeMeasureSpec, makeMeasureSpec);
        RelativeLayout root = this.binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root.getMeasuredWidth();
    }
}
