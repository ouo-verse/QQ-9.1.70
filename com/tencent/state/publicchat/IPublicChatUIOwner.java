package com.tencent.state.publicchat;

import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.state.publicchat.IPublicChatOwner;
import com.tencent.state.publicchat.action.MsgAction;
import com.tencent.state.publicchat.data.PublicChatConfInfo;
import com.tencent.state.publicchat.data.Scene;
import com.tencent.state.publicchat.data.ShowMsgPanelParams;
import com.tencent.state.publicchat.service.SendMsgReq;
import com.tencent.state.publicchat.view.IMessageItemViewFactory;
import com.tencent.state.publicchat.view.msgPanel.IMessagePanelItemFactory;
import com.tencent.state.template.data.RoomThemeData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH&J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\t2\u0006\u0010\r\u001a\u00020\u000eH&J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H&J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0005H&\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/state/publicchat/IPublicChatUIOwner;", "Lcom/tencent/state/publicchat/IPublicChatOwner;", "createTextMsg", "Lcom/tencent/state/publicchat/service/SendMsgReq;", "channelId", "", "msgTxt", "", "getMsgItemViewFactories", "", "Lcom/tencent/state/publicchat/view/IMessageItemViewFactory;", "getMsgPanelItemView", "Lcom/tencent/state/publicchat/view/msgPanel/IMessagePanelItemFactory;", "params", "Lcom/tencent/state/publicchat/data/ShowMsgPanelParams;", "getPublicChatViewSlots", "Lcom/tencent/state/publicchat/PublicChatViewSlots;", "getTextMsgMaxLen", "", "conf", "Lcom/tencent/state/publicchat/data/PublicChatConfInfo;", IProfileProtocolConst.PARAM_IS_FRIEND, "", "uin", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public interface IPublicChatUIOwner extends IPublicChatOwner {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class DefaultImpls {
        public static long getRoomId(IPublicChatUIOwner iPublicChatUIOwner) {
            return IPublicChatOwner.DefaultImpls.getRoomId(iPublicChatUIOwner);
        }

        public static RoomThemeData getRoomThemeData(IPublicChatUIOwner iPublicChatUIOwner) {
            return IPublicChatOwner.DefaultImpls.getRoomThemeData(iPublicChatUIOwner);
        }

        public static Scene getScene(IPublicChatUIOwner iPublicChatUIOwner) {
            return IPublicChatOwner.DefaultImpls.getScene(iPublicChatUIOwner);
        }

        public static void onMsgAction(IPublicChatUIOwner iPublicChatUIOwner, MsgAction action) {
            Intrinsics.checkNotNullParameter(action, "action");
            IPublicChatOwner.DefaultImpls.onMsgAction(iPublicChatUIOwner, action);
        }
    }

    SendMsgReq createTextMsg(long channelId, String msgTxt);

    List<IMessageItemViewFactory> getMsgItemViewFactories();

    List<IMessagePanelItemFactory> getMsgPanelItemView(ShowMsgPanelParams params);

    PublicChatViewSlots getPublicChatViewSlots();

    int getTextMsgMaxLen(PublicChatConfInfo conf);

    boolean isFriend(long uin);
}
