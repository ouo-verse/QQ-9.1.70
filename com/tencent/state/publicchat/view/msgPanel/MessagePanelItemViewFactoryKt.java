package com.tencent.state.publicchat.view.msgPanel;

import android.content.Context;
import com.tencent.state.publicchat.action.MsgAction;
import com.tencent.state.publicchat.data.ShowMsgPanelParams;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\"\u0011\u0010\u0000\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0011\u0010\u0004\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0003\"\u0011\u0010\u0006\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0003\"\u0011\u0010\b\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0003\"\u0011\u0010\n\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0003\"\u0011\u0010\f\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0003\"\u0011\u0010\u000e\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0003\u00a8\u0006\u0010"}, d2 = {"ItemViewAddToSquareViewFactory", "Lcom/tencent/state/publicchat/view/msgPanel/IMessagePanelItemFactory;", "getItemViewAddToSquareViewFactory", "()Lcom/tencent/state/publicchat/view/msgPanel/IMessagePanelItemFactory;", "ItemViewFocusViewFactory", "getItemViewFocusViewFactory", "ItemViewMergeViewFactory", "getItemViewMergeViewFactory", "ItemViewOpenExtraMenuViewFactory", "getItemViewOpenExtraMenuViewFactory", "ItemViewProfileViewFactory", "getItemViewProfileViewFactory", "ItemViewReportViewFactory", "getItemViewReportViewFactory", "ItemViewSayHiViewFactory", "getItemViewSayHiViewFactory", "state_square_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class MessagePanelItemViewFactoryKt {
    private static final IMessagePanelItemFactory ItemViewFocusViewFactory = new IMessagePanelItemFactory() { // from class: com.tencent.state.publicchat.view.msgPanel.MessagePanelItemViewFactoryKt$ItemViewFocusViewFactory$1
        @Override // com.tencent.state.publicchat.view.msgPanel.IMessagePanelItemFactory
        public AbstractItemView create(Context context, ShowMsgPanelParams params, Function1<? super MsgAction, Unit> dispatchAction) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(params, "params");
            Intrinsics.checkNotNullParameter(dispatchAction, "dispatchAction");
            return new ItemViewFocusView(context, params, dispatchAction);
        }
    };
    private static final IMessagePanelItemFactory ItemViewAddToSquareViewFactory = new IMessagePanelItemFactory() { // from class: com.tencent.state.publicchat.view.msgPanel.MessagePanelItemViewFactoryKt$ItemViewAddToSquareViewFactory$1
        @Override // com.tencent.state.publicchat.view.msgPanel.IMessagePanelItemFactory
        public AbstractItemView create(Context context, ShowMsgPanelParams params, Function1<? super MsgAction, Unit> dispatchAction) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(params, "params");
            Intrinsics.checkNotNullParameter(dispatchAction, "dispatchAction");
            return new ItemViewAddToSquareView(context, params, dispatchAction);
        }
    };
    private static final IMessagePanelItemFactory ItemViewProfileViewFactory = new IMessagePanelItemFactory() { // from class: com.tencent.state.publicchat.view.msgPanel.MessagePanelItemViewFactoryKt$ItemViewProfileViewFactory$1
        @Override // com.tencent.state.publicchat.view.msgPanel.IMessagePanelItemFactory
        public AbstractItemView create(Context context, ShowMsgPanelParams params, Function1<? super MsgAction, Unit> dispatchAction) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(params, "params");
            Intrinsics.checkNotNullParameter(dispatchAction, "dispatchAction");
            return new ItemViewProfileView(context, params, dispatchAction);
        }
    };
    private static final IMessagePanelItemFactory ItemViewReportViewFactory = new IMessagePanelItemFactory() { // from class: com.tencent.state.publicchat.view.msgPanel.MessagePanelItemViewFactoryKt$ItemViewReportViewFactory$1
        @Override // com.tencent.state.publicchat.view.msgPanel.IMessagePanelItemFactory
        public AbstractItemView create(Context context, ShowMsgPanelParams params, Function1<? super MsgAction, Unit> dispatchAction) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(params, "params");
            Intrinsics.checkNotNullParameter(dispatchAction, "dispatchAction");
            return new ItemViewReportView(context, params, dispatchAction);
        }
    };
    private static final IMessagePanelItemFactory ItemViewOpenExtraMenuViewFactory = new IMessagePanelItemFactory() { // from class: com.tencent.state.publicchat.view.msgPanel.MessagePanelItemViewFactoryKt$ItemViewOpenExtraMenuViewFactory$1
        @Override // com.tencent.state.publicchat.view.msgPanel.IMessagePanelItemFactory
        public AbstractItemView create(Context context, ShowMsgPanelParams params, Function1<? super MsgAction, Unit> dispatchAction) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(params, "params");
            Intrinsics.checkNotNullParameter(dispatchAction, "dispatchAction");
            return new ItemViewOpenExtraMenuView(context, params, dispatchAction);
        }
    };
    private static final IMessagePanelItemFactory ItemViewMergeViewFactory = new IMessagePanelItemFactory() { // from class: com.tencent.state.publicchat.view.msgPanel.MessagePanelItemViewFactoryKt$ItemViewMergeViewFactory$1
        @Override // com.tencent.state.publicchat.view.msgPanel.IMessagePanelItemFactory
        public AbstractItemView create(Context context, ShowMsgPanelParams params, Function1<? super MsgAction, Unit> dispatchAction) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(params, "params");
            Intrinsics.checkNotNullParameter(dispatchAction, "dispatchAction");
            return new ItemViewMergeView(context, params, dispatchAction);
        }
    };
    private static final IMessagePanelItemFactory ItemViewSayHiViewFactory = new IMessagePanelItemFactory() { // from class: com.tencent.state.publicchat.view.msgPanel.MessagePanelItemViewFactoryKt$ItemViewSayHiViewFactory$1
        @Override // com.tencent.state.publicchat.view.msgPanel.IMessagePanelItemFactory
        public AbstractItemView create(Context context, ShowMsgPanelParams params, Function1<? super MsgAction, Unit> dispatchAction) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(params, "params");
            Intrinsics.checkNotNullParameter(dispatchAction, "dispatchAction");
            return new ItemViewSayHiView(context, params, dispatchAction);
        }
    };

    public static final IMessagePanelItemFactory getItemViewAddToSquareViewFactory() {
        return ItemViewAddToSquareViewFactory;
    }

    public static final IMessagePanelItemFactory getItemViewFocusViewFactory() {
        return ItemViewFocusViewFactory;
    }

    public static final IMessagePanelItemFactory getItemViewMergeViewFactory() {
        return ItemViewMergeViewFactory;
    }

    public static final IMessagePanelItemFactory getItemViewOpenExtraMenuViewFactory() {
        return ItemViewOpenExtraMenuViewFactory;
    }

    public static final IMessagePanelItemFactory getItemViewProfileViewFactory() {
        return ItemViewProfileViewFactory;
    }

    public static final IMessagePanelItemFactory getItemViewReportViewFactory() {
        return ItemViewReportViewFactory;
    }

    public static final IMessagePanelItemFactory getItemViewSayHiViewFactory() {
        return ItemViewSayHiViewFactory;
    }
}
