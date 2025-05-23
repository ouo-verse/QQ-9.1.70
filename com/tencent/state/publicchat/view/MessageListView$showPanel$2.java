package com.tencent.state.publicchat.view;

import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.tencent.state.publicchat.data.ShowMsgPanelParams;
import com.tencent.state.square.SquareUtil;
import com.tencent.state.square.common.ViewExtensionsKt;
import com.tencent.state.square.databinding.VasSquarePublicChatListBinding;
import com.tencent.state.view.SquareImageView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class MessageListView$showPanel$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ShowMsgPanelParams $params;
    final /* synthetic */ MessageListView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageListView$showPanel$2(MessageListView messageListView, ShowMsgPanelParams showMsgPanelParams) {
        super(0);
        this.this$0 = messageListView;
        this.$params = showMsgPanelParams;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        VasSquarePublicChatListBinding vasSquarePublicChatListBinding;
        VasSquarePublicChatListBinding vasSquarePublicChatListBinding2;
        vasSquarePublicChatListBinding = this.this$0.binding;
        RelativeLayout relativeLayout = vasSquarePublicChatListBinding.msgPanel;
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = this.$params.getX() - ViewExtensionsKt.dip(relativeLayout.getContext(), 41);
        final Ref.IntRef intRef2 = new Ref.IntRef();
        intRef2.element = ViewExtensionsKt.dip(relativeLayout.getContext(), 35);
        int screenWidth$default = (SquareUtil.getScreenWidth$default(SquareUtil.INSTANCE, 0.0f, 1, null) - (relativeLayout.getWidth() + intRef.element)) - ViewExtensionsKt.dip(relativeLayout.getContext(), 5);
        if (screenWidth$default < 0) {
            intRef.element += screenWidth$default;
            intRef2.element -= screenWidth$default;
        }
        vasSquarePublicChatListBinding2 = this.this$0.binding;
        SquareImageView squareImageView = vasSquarePublicChatListBinding2.msgPanelArrow;
        Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.msgPanelArrow");
        com.tencent.state.ViewExtensionsKt.updateLayoutParams(squareImageView, new Function1<RelativeLayout.LayoutParams, Unit>() { // from class: com.tencent.state.publicchat.view.MessageListView$showPanel$2$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
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
                receiver.leftMargin = Ref.IntRef.this.element;
            }
        });
        com.tencent.state.ViewExtensionsKt.updateLayoutParams(relativeLayout, new Function1<CoordinatorLayout.LayoutParams, Unit>() { // from class: com.tencent.state.publicchat.view.MessageListView$showPanel$2$$special$$inlined$apply$lambda$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(CoordinatorLayout.LayoutParams layoutParams) {
                invoke2(layoutParams);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(CoordinatorLayout.LayoutParams receiver) {
                int topOffsetPx;
                Intrinsics.checkNotNullParameter(receiver, "$receiver");
                int y16 = this.$params.getY() - ((ViewGroup.MarginLayoutParams) receiver).height;
                topOffsetPx = this.this$0.getTopOffsetPx();
                ((ViewGroup.MarginLayoutParams) receiver).topMargin = y16 - topOffsetPx;
                ((ViewGroup.MarginLayoutParams) receiver).leftMargin = Ref.IntRef.this.element;
            }
        });
        com.tencent.state.ViewExtensionsKt.setVisibility(relativeLayout, true);
    }
}
