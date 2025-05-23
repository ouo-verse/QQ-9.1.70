package com.tencent.state.publicchat.view;

import android.content.Context;
import android.widget.FrameLayout;
import com.tencent.state.ViewExtensionsKt;
import com.tencent.state.publicchat.action.MsgAction;
import com.tencent.state.publicchat.data.MsgConfInfo;
import com.tencent.state.publicchat.data.MsgInfo;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.template.data.RoomThemeData;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB0\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012!\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005\u00a2\u0006\u0002\u0010\u000bJ,\u0010\u0011\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u0019R)\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/state/publicchat/view/MessageItemView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "dispatchAction", "Lkotlin/Function1;", "Lcom/tencent/state/publicchat/action/MsgAction;", "Lkotlin/ParameterName;", "name", "action", "", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;)V", "msgId", "", "Ljava/lang/Long;", "view", "Lcom/tencent/state/publicchat/view/AbstractMessageItemView;", "bind", "msg", "Lcom/tencent/state/publicchat/data/MsgInfo;", "conf", "Lcom/tencent/state/publicchat/data/MsgConfInfo;", "themeData", "Lcom/tencent/state/template/data/RoomThemeData;", "isFirst", "", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class MessageItemView extends FrameLayout {
    private static final String TAG = "MessageItemView";
    private final Function1<MsgAction, Unit> dispatchAction;
    private Long msgId;
    private AbstractMessageItemView view;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static Map<String, IMessageItemViewFactory> factories = new LinkedHashMap();

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004J\u001f\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u000e\"\u00020\u0007\u00a2\u0006\u0002\u0010\u000fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/state/publicchat/view/MessageItemView$Companion;", "", "()V", "TAG", "", "factories", "", "Lcom/tencent/state/publicchat/view/IMessageItemViewFactory;", "hasFactory", "", "templateId", "registerFactory", "", "fs", "", "([Lcom/tencent/state/publicchat/view/IMessageItemViewFactory;)V", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class Companion {
        Companion() {
        }

        public final boolean hasFactory(String templateId) {
            Intrinsics.checkNotNullParameter(templateId, "templateId");
            return MessageItemView.factories.containsKey(templateId);
        }

        public final void registerFactory(IMessageItemViewFactory... fs5) {
            Intrinsics.checkNotNullParameter(fs5, "fs");
            for (IMessageItemViewFactory iMessageItemViewFactory : fs5) {
                MessageItemView.factories.put(iMessageItemViewFactory.getTEMPLATE_ID(), iMessageItemViewFactory);
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public MessageItemView(Context context, Function1<? super MsgAction, Unit> dispatchAction) {
        super(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dispatchAction, "dispatchAction");
        this.dispatchAction = dispatchAction;
    }

    public final void bind(MsgInfo msg2, MsgConfInfo conf, RoomThemeData themeData, final boolean isFirst) {
        MsgExpReporter msgExpReporter;
        if (msg2 != null) {
            msgExpReporter = MessageItemViewKt.reporter;
            msgExpReporter.report(msg2);
            setVisibility(0);
            AbstractMessageItemView abstractMessageItemView = this.view;
            if (abstractMessageItemView != null) {
                ViewExtensionsKt.updateLayoutParams(abstractMessageItemView, new Function1<FrameLayout.LayoutParams, Unit>() { // from class: com.tencent.state.publicchat.view.MessageItemView$bind$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(FrameLayout.LayoutParams layoutParams) {
                        invoke2(layoutParams);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(FrameLayout.LayoutParams receiver) {
                        Intrinsics.checkNotNullParameter(receiver, "$receiver");
                        receiver.topMargin = com.tencent.state.square.common.ViewExtensionsKt.dip(MessageItemView.this.getContext(), isFirst ? 0 : 5);
                    }
                });
            }
            Long l3 = this.msgId;
            long msgId = msg2.getHeader().getMsgId();
            if (l3 != null && l3.longValue() == msgId) {
                return;
            }
            removeAllViews();
            IMessageItemViewFactory iMessageItemViewFactory = factories.get(msg2.getHeader().getTemplateId());
            if (iMessageItemViewFactory == null) {
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "unknown templateId " + msg2.getHeader().getTemplateId(), null, 4, null);
                return;
            }
            if (conf == null) {
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "no message config for templateId " + msg2.getHeader().getTemplateId(), null, 4, null);
                return;
            }
            this.msgId = Long.valueOf(msg2.getHeader().getMsgId());
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            AbstractMessageItemView create = iMessageItemViewFactory.create(context, conf, msg2, this.dispatchAction, themeData);
            this.view = create;
            addView(create);
            AbstractMessageItemView abstractMessageItemView2 = this.view;
            if (abstractMessageItemView2 != null) {
                ViewExtensionsKt.updateLayoutParams(abstractMessageItemView2, new Function1<FrameLayout.LayoutParams, Unit>() { // from class: com.tencent.state.publicchat.view.MessageItemView$bind$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(FrameLayout.LayoutParams layoutParams) {
                        invoke2(layoutParams);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(FrameLayout.LayoutParams receiver) {
                        Intrinsics.checkNotNullParameter(receiver, "$receiver");
                        receiver.topMargin = com.tencent.state.square.common.ViewExtensionsKt.dip(MessageItemView.this.getContext(), isFirst ? 0 : 5);
                    }
                });
                return;
            }
            return;
        }
        this.msgId = null;
        this.view = null;
        setVisibility(8);
        removeAllViews();
    }
}
