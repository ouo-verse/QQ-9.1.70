package com.tencent.state.publicchat.view.msgPanel;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.R;
import com.tencent.state.ViewExtensionsKt;
import com.tencent.state.publicchat.action.MsgAction;
import com.tencent.state.publicchat.action.SayHiAction;
import com.tencent.state.publicchat.data.ShowMsgPanelParams;
import com.tencent.state.view.SquareImageView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB8\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012!\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0007\u00a2\u0006\u0002\u0010\r\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/state/publicchat/view/msgPanel/ItemViewSayHiView;", "Lcom/tencent/state/publicchat/view/msgPanel/AbstractItemView;", "context", "Landroid/content/Context;", "params", "Lcom/tencent/state/publicchat/data/ShowMsgPanelParams;", "dispatchAction", "Lkotlin/Function1;", "Lcom/tencent/state/publicchat/action/MsgAction;", "Lkotlin/ParameterName;", "name", "action", "", "(Landroid/content/Context;Lcom/tencent/state/publicchat/data/ShowMsgPanelParams;Lkotlin/jvm/functions/Function1;)V", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class ItemViewSayHiView extends AbstractItemView {
    public static final String TAG = "ItemViewReportView";

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ItemViewSayHiView(final Context context, final ShowMsgPanelParams params, final Function1<? super MsgAction, Unit> dispatchAction) {
        super(context, params, dispatchAction);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(dispatchAction, "dispatchAction");
        if (params.getShowSayHi()) {
            ViewExtensionsKt.setVisibility(getRoot(), true);
            initPageReport(params.getAppId());
            doBindImage(R.drawable.i99);
            doBindText(R.string.f169758xg0);
            SquareImageView squareImageView = getBinding().image;
            Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.image");
            ViewExtensionsKt.updateLayoutParams(squareImageView, new Function1<ViewGroup.LayoutParams, Unit>() { // from class: com.tencent.state.publicchat.view.msgPanel.ItemViewSayHiView.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ViewGroup.LayoutParams layoutParams) {
                    invoke2(layoutParams);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ViewGroup.LayoutParams receiver) {
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    receiver.width = com.tencent.state.square.common.ViewExtensionsKt.dip(context, 34);
                }
            });
            setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.publicchat.view.msgPanel.ItemViewSayHiView.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Function1.this.invoke(new SayHiAction(String.valueOf(params.getUser().getUin()), params.getUser().getNick()));
                }
            });
            return;
        }
        ViewExtensionsKt.setVisibility(getRoot(), false);
    }
}
