package com.tencent.state.square.chatland.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.state.ViewExtensionsKt;
import com.tencent.state.square.databinding.VasSquareChatLandTableViewBinding;
import com.tencent.state.view.SquareImageView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000  2\u00020\u0001:\u0001 B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0016\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000RL\u0010\u000b\u001a4\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u00188F\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006!"}, d2 = {"Lcom/tencent/state/square/chatland/view/ChatLandTableView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/tencent/state/square/databinding/VasSquareChatLandTableViewBinding;", "clickListener", "Lkotlin/Function2;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "v", "type", "", "getClickListener", "()Lkotlin/jvm/functions/Function2;", "setClickListener", "(Lkotlin/jvm/functions/Function2;)V", "table", "Lcom/tencent/state/view/SquareImageView;", "getTable", "()Lcom/tencent/state/view/SquareImageView;", "bindTableImage", "url", "", "size", "Landroid/util/Size;", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class ChatLandTableView extends RelativeLayout {
    public static final int CLICK_HIT_AREA = 0;
    private static final String TAG = "ChatLandTableView";
    private final VasSquareChatLandTableViewBinding binding;
    private Function2<? super View, ? super Integer, Unit> clickListener;

    public ChatLandTableView(Context context) {
        this(context, null, 0, 6, null);
    }

    public final void bindTableImage(String url, final Size size) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(size, "size");
        SquareImageView squareImageView = this.binding.table;
        Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.table");
        ViewExtensionsKt.updateLayoutParams(squareImageView, new Function1<RelativeLayout.LayoutParams, Unit>() { // from class: com.tencent.state.square.chatland.view.ChatLandTableView$bindTableImage$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(RelativeLayout.LayoutParams layoutParams) {
                invoke2(layoutParams);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(RelativeLayout.LayoutParams receiver) {
                Intrinsics.checkNotNullParameter(receiver, "$receiver");
                receiver.width = size.getWidth();
                receiver.height = size.getHeight();
            }
        });
        SquareImageView squareImageView2 = this.binding.table;
        Intrinsics.checkNotNullExpressionValue(squareImageView2, "binding.table");
        ViewExtensionsKt.setUri(squareImageView2, url);
    }

    public final Function2<View, Integer, Unit> getClickListener() {
        return this.clickListener;
    }

    public final SquareImageView getTable() {
        SquareImageView squareImageView = this.binding.table;
        Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.table");
        return squareImageView;
    }

    public final void setClickListener(Function2<? super View, ? super Integer, Unit> function2) {
        this.clickListener = function2;
    }

    public ChatLandTableView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ ChatLandTableView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatLandTableView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        VasSquareChatLandTableViewBinding inflate = VasSquareChatLandTableViewBinding.inflate(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareChatLandTableVi\u2026ater.from(context), this)");
        this.binding = inflate;
        inflate.table.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.chatland.view.ChatLandTableView.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View it) {
                Function2<View, Integer, Unit> clickListener = ChatLandTableView.this.getClickListener();
                if (clickListener != null) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    clickListener.invoke(it, 0);
                }
            }
        });
    }
}
