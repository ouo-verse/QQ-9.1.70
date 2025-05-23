package com.tencent.state.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.state.ViewExtensionsKt;
import com.tencent.state.square.databinding.VasSquareSingleCheckboxLayoutBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0010\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u000fH\u0002J\u0006\u0010\u0016\u001a\u00020\u000fJ\u000e\u0010\u0017\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u0018\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u0019\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\nH\u0002J1\u0010\u001a\u001a\u00020\u00132)\u0010\u001b\u001a%\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000ej\u0004\u0018\u0001`\u0014J\u0006\u0010\u001c\u001a\u00020\u0013R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R1\u0010\r\u001a%\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000ej\u0004\u0018\u0001`\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/state/view/SquareSingleCheckBoxView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", DownloadInfo.spKey_Config, "Lcom/tencent/state/view/SquareSingleCheckBoxConfig;", "content", "Lcom/tencent/state/square/databinding/VasSquareSingleCheckboxLayoutBinding;", "onCheckCallback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "selected", "", "Lcom/tencent/state/view/OnChangeCallbackFun;", "changeIconState", "hasSelected", "refreshContent", "refreshIcon", "refreshText", "setOnCheckCallback", "cb", "toggle", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareSingleCheckBoxView extends FrameLayout {
    private SquareSingleCheckBoxConfig config;
    private final VasSquareSingleCheckboxLayoutBinding content;
    private Function1<? super Boolean, Unit> onCheckCallback;

    public SquareSingleCheckBoxView(Context context) {
        this(context, null, 0, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void changeIconState(boolean selected) {
        int iconNormalRes;
        SquareImageView squareImageView = this.content.checkboxIcon;
        Intrinsics.checkNotNullExpressionValue(squareImageView, "content.checkboxIcon");
        squareImageView.setSelected(selected);
        SquareImageView squareImageView2 = this.content.checkboxIcon;
        if (selected) {
            iconNormalRes = this.config.getIconSelectedRes();
        } else {
            iconNormalRes = this.config.getIconNormalRes();
        }
        squareImageView2.setImageResource(iconNormalRes);
        Function1<? super Boolean, Unit> function1 = this.onCheckCallback;
        if (function1 != null) {
            function1.invoke(Boolean.valueOf(selected));
        }
    }

    private final void refreshIcon(final SquareSingleCheckBoxConfig config) {
        SquareImageView squareImageView = this.content.checkboxIcon;
        Intrinsics.checkNotNullExpressionValue(squareImageView, "content.checkboxIcon");
        ViewExtensionsKt.updateLayoutParams(squareImageView, new Function1<LinearLayout.LayoutParams, Unit>() { // from class: com.tencent.state.view.SquareSingleCheckBoxView$refreshIcon$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(LinearLayout.LayoutParams layoutParams) {
                invoke2(layoutParams);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(LinearLayout.LayoutParams receiver) {
                Intrinsics.checkNotNullParameter(receiver, "$receiver");
                receiver.width = SquareSingleCheckBoxConfig.this.getIconSize().getWidth();
                receiver.height = SquareSingleCheckBoxConfig.this.getIconSize().getHeight();
            }
        });
        changeIconState(config.getIconDefaultSelected());
    }

    private final void refreshText(final SquareSingleCheckBoxConfig config) {
        TextView textView = this.content.checkboxText;
        Intrinsics.checkNotNullExpressionValue(textView, "content.checkboxText");
        ViewExtensionsKt.updateLayoutParams(textView, new Function1<LinearLayout.LayoutParams, Unit>() { // from class: com.tencent.state.view.SquareSingleCheckBoxView$refreshText$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(LinearLayout.LayoutParams layoutParams) {
                invoke2(layoutParams);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(LinearLayout.LayoutParams receiver) {
                Intrinsics.checkNotNullParameter(receiver, "$receiver");
                receiver.setMargins(SquareSingleCheckBoxConfig.this.getTextMargin().left, SquareSingleCheckBoxConfig.this.getTextMargin().top, SquareSingleCheckBoxConfig.this.getTextMargin().right, SquareSingleCheckBoxConfig.this.getTextMargin().bottom);
            }
        });
        this.content.checkboxText.setTextSize(0, config.getTextSize());
        this.content.checkboxText.setTextColor(config.getTextColor());
        this.content.checkboxText.setText(config.getText());
    }

    public final boolean hasSelected() {
        SquareImageView squareImageView = this.content.checkboxIcon;
        Intrinsics.checkNotNullExpressionValue(squareImageView, "content.checkboxIcon");
        return squareImageView.isSelected();
    }

    public final void refreshContent(SquareSingleCheckBoxConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.config = config;
        refreshIcon(config);
        refreshText(config);
    }

    public final void setOnCheckCallback(Function1<? super Boolean, Unit> cb5) {
        this.onCheckCallback = cb5;
    }

    public final void toggle() {
        Intrinsics.checkNotNullExpressionValue(this.content.checkboxIcon, "content.checkboxIcon");
        changeIconState(!r0.isSelected());
    }

    public SquareSingleCheckBoxView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ SquareSingleCheckBoxView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SquareSingleCheckBoxView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        VasSquareSingleCheckboxLayoutBinding inflate = VasSquareSingleCheckboxLayoutBinding.inflate(LayoutInflater.from(context));
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareSingleCheckboxL\u2026utInflater.from(context))");
        this.content = inflate;
        SquareSingleCheckBoxConfig squareSingleCheckBoxConfig = new SquareSingleCheckBoxConfig(context);
        this.config = squareSingleCheckBoxConfig;
        refreshContent(squareSingleCheckBoxConfig);
        addView(inflate.getRoot(), new FrameLayout.LayoutParams(-2, -2));
        inflate.checkboxContainer.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.view.SquareSingleCheckBoxView.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SquareSingleCheckBoxView squareSingleCheckBoxView = SquareSingleCheckBoxView.this;
                Intrinsics.checkNotNullExpressionValue(squareSingleCheckBoxView.content.checkboxIcon, "content.checkboxIcon");
                squareSingleCheckBoxView.changeIconState(!r0.isSelected());
            }
        });
    }
}
