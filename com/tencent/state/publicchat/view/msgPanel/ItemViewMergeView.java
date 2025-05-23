package com.tencent.state.publicchat.view.msgPanel;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.state.publicchat.action.MergeAction;
import com.tencent.state.publicchat.action.MsgAction;
import com.tencent.state.publicchat.data.ShowMsgPanelParams;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.square.SquareBaseKt;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB8\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012!\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0007\u00a2\u0006\u0002\u0010\r\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/state/publicchat/view/msgPanel/ItemViewMergeView;", "Lcom/tencent/state/publicchat/view/msgPanel/AbstractItemView;", "context", "Landroid/content/Context;", "params", "Lcom/tencent/state/publicchat/data/ShowMsgPanelParams;", "dispatchAction", "Lkotlin/Function1;", "Lcom/tencent/state/publicchat/action/MsgAction;", "Lkotlin/ParameterName;", "name", "action", "", "(Landroid/content/Context;Lcom/tencent/state/publicchat/data/ShowMsgPanelParams;Lkotlin/jvm/functions/Function1;)V", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class ItemViewMergeView extends AbstractItemView {
    public static final String TAG = "ItemViewMergeView";

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ItemViewMergeView(Context context, final ShowMsgPanelParams params, final Function1<? super MsgAction, Unit> dispatchAction) {
        super(context, params, dispatchAction);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(dispatchAction, "dispatchAction");
        initPageReport(params.getAppId());
        doBindImage(R.drawable.i9b);
        doBindText(R.string.xfx);
        SquareBaseKt.getSquareReporter().setElementInfo(getItem(), SquareReportConst.ElementId.ELEMENT_ID_CHAT_LAND_ZPLAN_FIT, new LinkedHashMap(), false, false);
        setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.publicchat.view.msgPanel.ItemViewMergeView.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dispatchAction.invoke(new MergeAction(String.valueOf(params.getUser().getUin())));
                SquareBaseKt.getSquareReporter().reportEvent("clck", ItemViewMergeView.this.getItem(), new LinkedHashMap());
            }
        });
    }
}
