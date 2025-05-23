package com.tencent.state.publicchat.view.msgPanel;

import android.content.Context;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.state.publicchat.action.MsgAction;
import com.tencent.state.publicchat.data.ShowMsgPanelParams;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J;\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\tH&\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/state/publicchat/view/msgPanel/IMessagePanelItemFactory;", "", OperateCustomButton.OPERATE_CREATE, "Lcom/tencent/state/publicchat/view/msgPanel/AbstractItemView;", "context", "Landroid/content/Context;", "params", "Lcom/tencent/state/publicchat/data/ShowMsgPanelParams;", "dispatchAction", "Lkotlin/Function1;", "Lcom/tencent/state/publicchat/action/MsgAction;", "Lkotlin/ParameterName;", "name", "action", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public interface IMessagePanelItemFactory {
    AbstractItemView create(Context context, ShowMsgPanelParams params, Function1<? super MsgAction, Unit> dispatchAction);
}
