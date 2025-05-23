package com.tencent.state.view;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.state.square.common.ViewExtensionsKt;
import com.tencent.state.square.databinding.VasSquareTextPopupWindowBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/state/view/TextBubblePopupWindow;", "Landroid/widget/PopupWindow;", "context", "Landroid/content/Context;", "text", "", "(Landroid/content/Context;Ljava/lang/String;)V", "binding", "Lcom/tencent/state/square/databinding/VasSquareTextPopupWindowBinding;", "getTextView", "Landroid/widget/TextView;", "getTextViewWidth", "", "updateBubbleBg", "", "isCenterX", "", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class TextBubblePopupWindow extends PopupWindow {
    public static final int HEIGHT_DP = 40;
    public static final int WIDTH_DP = 200;
    private final VasSquareTextPopupWindowBinding binding;

    public TextBubblePopupWindow(Context context, String text) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(text, "text");
        VasSquareTextPopupWindowBinding inflate = VasSquareTextPopupWindowBinding.inflate(LayoutInflater.from(context));
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareTextPopupWindow\u2026utInflater.from(context))");
        this.binding = inflate;
        setHeight(ViewExtensionsKt.dip(context, 40));
        setWidth(ViewExtensionsKt.dip(context, 200));
        setOutsideTouchable(true);
        setFocusable(true);
        TextView textView = inflate.textView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.textView");
        textView.setText(text);
        setContentView(inflate.getRoot());
    }

    public final TextView getTextView() {
        TextView textView = this.binding.textView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.textView");
        return textView;
    }

    public final void updateBubbleBg(boolean isCenterX) {
        this.binding.textView.setBackground(new BubbleBgDrawable(Color.parseColor("#99000000"), ViewExtensionsKt.dip(r0.getContext(), 3.0f), ViewExtensionsKt.dip(r0.getContext(), 6.0f), null, isCenterX));
    }

    public final int getTextViewWidth() {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.binding.textView.measure(makeMeasureSpec, makeMeasureSpec);
        TextView textView = this.binding.textView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.textView");
        return textView.getMeasuredWidth();
    }
}
