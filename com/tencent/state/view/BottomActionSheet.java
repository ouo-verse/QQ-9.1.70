package com.tencent.state.view;

import android.app.Dialog;
import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.state.ViewExtensionsKt;
import com.tencent.state.square.SquareUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0018R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000RL\u0010\t\u001a4\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/state/view/BottomActionSheet;", "Landroid/app/Dialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "cancelView", "Landroid/widget/TextView;", ParseCommon.CONTAINER, "Landroid/widget/LinearLayout;", "itemClickListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "type", "Landroid/view/View;", "view", "", "getItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "addActionSheet", "text", "", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class BottomActionSheet extends Dialog {
    private static final int HEIGHT = 56;
    private final TextView cancelView;
    private final LinearLayout container;
    private Function2<? super Integer, ? super View, Unit> itemClickListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BottomActionSheet(Context context) {
        super(context, R.style.f243250a);
        Intrinsics.checkNotNullParameter(context, "context");
        setContentView(R.layout.d3f);
        View findViewById = findViewById(R.id.p9x);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.actions)");
        this.container = (LinearLayout) findViewById;
        View findViewById2 = findViewById(R.id.f163325pi4);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.cancel)");
        TextView textView = (TextView) findViewById2;
        this.cancelView = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.view.BottomActionSheet.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BottomActionSheet.this.dismiss();
            }
        });
        setCanceledOnTouchOutside(true);
        Window window = getWindow();
        if (window != null) {
            window.setGravity(80);
        }
        Window window2 = getWindow();
        if (window2 != null) {
            window2.setLayout(SquareUtil.getScreenWidth$default(SquareUtil.INSTANCE, 0.0f, 1, null), -2);
        }
        Window window3 = getWindow();
        if (window3 != null) {
            window3.setWindowAnimations(R.style.f243260b);
        }
    }

    public final View addActionSheet(final int type, String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        TextView textView = new TextView(new ContextThemeWrapper(getContext(), R.style.f243240_));
        textView.setBackgroundColor(-1);
        textView.setText(text);
        this.container.addView(textView);
        textView.getLayoutParams().height = ViewExtensionsKt.dip((View) textView, 56);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.view.BottomActionSheet$addActionSheet$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View it) {
                Function2<Integer, View, Unit> itemClickListener = BottomActionSheet.this.getItemClickListener();
                if (itemClickListener != null) {
                    Integer valueOf = Integer.valueOf(type);
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    itemClickListener.invoke(valueOf, it);
                }
            }
        });
        return textView;
    }

    public final Function2<Integer, View, Unit> getItemClickListener() {
        return this.itemClickListener;
    }

    public final void setItemClickListener(Function2<? super Integer, ? super View, Unit> function2) {
        this.itemClickListener = function2;
    }
}
