package com.tencent.state.square.detail;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.state.square.common.ViewExtensionsKt;
import com.tencent.state.square.databinding.VasSquareDetailMeDressBubbleBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0010J\b\u0010\u0012\u001a\u00020\u0013H\u0002R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/state/square/detail/DetailMeDressTipsBubble;", "Landroid/widget/PopupWindow;", "context", "Landroid/content/Context;", "tips", "", "(Landroid/content/Context;Ljava/lang/String;)V", "binding", "Lcom/tencent/state/square/databinding/VasSquareDetailMeDressBubbleBinding;", "getBinding", "()Lcom/tencent/state/square/databinding/VasSquareDetailMeDressBubbleBinding;", "getContext", "()Landroid/content/Context;", "getTips", "()Ljava/lang/String;", "getTipsHeight", "", "getTipsWidth", "initView", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class DetailMeDressTipsBubble extends PopupWindow {
    private final VasSquareDetailMeDressBubbleBinding binding;
    private final Context context;
    private final String tips;

    public DetailMeDressTipsBubble(Context context, String tips) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(tips, "tips");
        this.context = context;
        this.tips = tips;
        VasSquareDetailMeDressBubbleBinding inflate = VasSquareDetailMeDressBubbleBinding.inflate(LayoutInflater.from(context));
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareDetailMeDressBu\u2026later.from(context)\n    )");
        this.binding = inflate;
        initView();
    }

    private final void initView() {
        TextView textView = this.binding.tipsText;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.tipsText");
        textView.setText(this.tips);
        setWidth(-2);
        setHeight(-2);
        setOutsideTouchable(false);
        setFocusable(false);
        setContentView(this.binding.getRoot());
    }

    public final VasSquareDetailMeDressBubbleBinding getBinding() {
        return this.binding;
    }

    public final Context getContext() {
        return this.context;
    }

    public final String getTips() {
        return this.tips;
    }

    public final int getTipsHeight() {
        return ViewExtensionsKt.dip(this.context, 46);
    }

    public final int getTipsWidth() {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.binding.tipsText.measure(makeMeasureSpec, makeMeasureSpec);
        TextView textView = this.binding.tipsText;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.tipsText");
        return textView.getMeasuredWidth();
    }
}
