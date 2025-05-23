package com.tencent.state.publicchat.view.msgPanel;

import android.content.Context;
import android.view.View;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.state.ViewExtensionsKt;
import com.tencent.state.event.ChatCheckUinInSquare;
import com.tencent.state.publicchat.action.AddToSquareAction;
import com.tencent.state.publicchat.action.MsgAction;
import com.tencent.state.publicchat.data.ShowMsgPanelParams;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.SquareBaseKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB8\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012!\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0007\u00a2\u0006\u0002\u0010\r\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/state/publicchat/view/msgPanel/ItemViewAddToSquareView;", "Lcom/tencent/state/publicchat/view/msgPanel/AbstractItemView;", "context", "Landroid/content/Context;", "params", "Lcom/tencent/state/publicchat/data/ShowMsgPanelParams;", "dispatchAction", "Lkotlin/Function1;", "Lcom/tencent/state/publicchat/action/MsgAction;", "Lkotlin/ParameterName;", "name", "action", "", "(Landroid/content/Context;Lcom/tencent/state/publicchat/data/ShowMsgPanelParams;Lkotlin/jvm/functions/Function1;)V", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class ItemViewAddToSquareView extends AbstractItemView {
    public static final String TAG = "ItemViewProfileView";

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ItemViewAddToSquareView(Context context, final ShowMsgPanelParams params, final Function1<? super MsgAction, Unit> dispatchAction) {
        super(context, params, dispatchAction);
        Map<String, Object> mutableMapOf;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(dispatchAction, "dispatchAction");
        initPageReport(params.getAppId());
        doBindImage(R.drawable.f159796i91);
        doBindText(R.string.xfv);
        IReporter squareReporter = SquareBaseKt.getSquareReporter();
        View item = getItem();
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_PLOT_APPID_ID, Integer.valueOf(params.getAppId())));
        squareReporter.setElementInfo(item, SquareReportConst.ElementId.ELEMENT_ID_CHAT_MSG_PANEL_ADD_TO_SQUARE_BTN, mutableMapOf, false, false);
        setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.publicchat.view.msgPanel.ItemViewAddToSquareView.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dispatchAction.invoke(new AddToSquareAction(String.valueOf(params.getUser().getUin()), params.getUser().getRelationType()));
                SquareBaseKt.getSquareReporter().reportEvent("clck", ItemViewAddToSquareView.this.getItem(), new LinkedHashMap());
            }
        });
        SimpleEventBus.getInstance().dispatchEvent(new ChatCheckUinInSquare(String.valueOf(params.getUser().getUin()), new Function1<Boolean, Unit>() { // from class: com.tencent.state.publicchat.view.msgPanel.ItemViewAddToSquareView.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                ViewExtensionsKt.setVisibility(ItemViewAddToSquareView.this.getRoot(), !z16);
            }
        }));
    }
}
