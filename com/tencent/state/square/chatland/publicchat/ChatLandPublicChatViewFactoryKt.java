package com.tencent.state.square.chatland.publicchat;

import android.content.Context;
import com.tencent.state.publicchat.action.MsgAction;
import com.tencent.state.publicchat.data.MsgConfInfo;
import com.tencent.state.publicchat.data.MsgInfo;
import com.tencent.state.publicchat.view.AbstractMessageItemView;
import com.tencent.state.publicchat.view.IMessageItemViewFactory;
import com.tencent.state.square.chatland.publicchat.view.InteractionDoubleClickMsgItemView;
import com.tencent.state.square.chatland.publicchat.view.InteractionSuccessChatMsgItemView;
import com.tencent.state.template.data.RoomThemeData;
import com.tencent.state.template.publicchat.view.FocusNormalChatMsgItemView;
import com.tencent.state.template.publicchat.view.FocusWelcomeAnnouncementMsgItemView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\"\u0011\u0010\u0000\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0011\u0010\u0004\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0003\"\u0011\u0010\u0006\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0003\"\u0011\u0010\b\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0003\u00a8\u0006\n"}, d2 = {"ChatLandInteractionDoubleClickMsgItemViewFactory", "Lcom/tencent/state/publicchat/view/IMessageItemViewFactory;", "getChatLandInteractionDoubleClickMsgItemViewFactory", "()Lcom/tencent/state/publicchat/view/IMessageItemViewFactory;", "ChatLandInteractionSuccessChatMsgItemViewFactory", "getChatLandInteractionSuccessChatMsgItemViewFactory", "ChatLandNormalChatMsgItemViewFactory", "getChatLandNormalChatMsgItemViewFactory", "ChatLandWelcomeAnnouncementMsgItemFactory", "getChatLandWelcomeAnnouncementMsgItemFactory", "state_square_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class ChatLandPublicChatViewFactoryKt {
    private static final IMessageItemViewFactory ChatLandWelcomeAnnouncementMsgItemFactory = new IMessageItemViewFactory() { // from class: com.tencent.state.square.chatland.publicchat.ChatLandPublicChatViewFactoryKt$ChatLandWelcomeAnnouncementMsgItemFactory$1
        private final String TEMPLATE_ID = "room_welcome_announcement";

        @Override // com.tencent.state.publicchat.view.IMessageItemViewFactory
        public AbstractMessageItemView create(Context context, MsgConfInfo conf, MsgInfo msg2, Function1<? super MsgAction, Unit> dispatchAction, RoomThemeData themeData) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(conf, "conf");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            Intrinsics.checkNotNullParameter(dispatchAction, "dispatchAction");
            return new FocusWelcomeAnnouncementMsgItemView(context, conf, msg2, dispatchAction);
        }

        @Override // com.tencent.state.publicchat.view.IMessageItemViewFactory
        /* renamed from: templateId, reason: from getter */
        public String getTEMPLATE_ID() {
            return this.TEMPLATE_ID;
        }
    };
    private static final IMessageItemViewFactory ChatLandNormalChatMsgItemViewFactory = new IMessageItemViewFactory() { // from class: com.tencent.state.square.chatland.publicchat.ChatLandPublicChatViewFactoryKt$ChatLandNormalChatMsgItemViewFactory$1
        private final String TEMPLATE_ID = "room_normal_chat";

        @Override // com.tencent.state.publicchat.view.IMessageItemViewFactory
        public AbstractMessageItemView create(Context context, MsgConfInfo conf, MsgInfo msg2, Function1<? super MsgAction, Unit> dispatchAction, RoomThemeData themeData) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(conf, "conf");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            Intrinsics.checkNotNullParameter(dispatchAction, "dispatchAction");
            return new FocusNormalChatMsgItemView(context, conf, msg2, dispatchAction, themeData);
        }

        @Override // com.tencent.state.publicchat.view.IMessageItemViewFactory
        /* renamed from: templateId, reason: from getter */
        public String getTEMPLATE_ID() {
            return this.TEMPLATE_ID;
        }
    };
    private static final IMessageItemViewFactory ChatLandInteractionSuccessChatMsgItemViewFactory = new IMessageItemViewFactory() { // from class: com.tencent.state.square.chatland.publicchat.ChatLandPublicChatViewFactoryKt$ChatLandInteractionSuccessChatMsgItemViewFactory$1
        private final String TEMPLATE_ID = "room_interaction_success";

        @Override // com.tencent.state.publicchat.view.IMessageItemViewFactory
        public AbstractMessageItemView create(Context context, MsgConfInfo conf, MsgInfo msg2, Function1<? super MsgAction, Unit> dispatchAction, RoomThemeData themeData) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(conf, "conf");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            Intrinsics.checkNotNullParameter(dispatchAction, "dispatchAction");
            return new InteractionSuccessChatMsgItemView(context, conf, msg2, dispatchAction);
        }

        @Override // com.tencent.state.publicchat.view.IMessageItemViewFactory
        /* renamed from: templateId, reason: from getter */
        public String getTEMPLATE_ID() {
            return this.TEMPLATE_ID;
        }
    };
    private static final IMessageItemViewFactory ChatLandInteractionDoubleClickMsgItemViewFactory = new IMessageItemViewFactory() { // from class: com.tencent.state.square.chatland.publicchat.ChatLandPublicChatViewFactoryKt$ChatLandInteractionDoubleClickMsgItemViewFactory$1
        private final String TEMPLATE_ID = "tickle_interaction";

        @Override // com.tencent.state.publicchat.view.IMessageItemViewFactory
        public AbstractMessageItemView create(Context context, MsgConfInfo conf, MsgInfo msg2, Function1<? super MsgAction, Unit> dispatchAction, RoomThemeData themeData) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(conf, "conf");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            Intrinsics.checkNotNullParameter(dispatchAction, "dispatchAction");
            return new InteractionDoubleClickMsgItemView(context, conf, msg2, dispatchAction);
        }

        @Override // com.tencent.state.publicchat.view.IMessageItemViewFactory
        /* renamed from: templateId, reason: from getter */
        public String getTEMPLATE_ID() {
            return this.TEMPLATE_ID;
        }
    };

    public static final IMessageItemViewFactory getChatLandInteractionDoubleClickMsgItemViewFactory() {
        return ChatLandInteractionDoubleClickMsgItemViewFactory;
    }

    public static final IMessageItemViewFactory getChatLandInteractionSuccessChatMsgItemViewFactory() {
        return ChatLandInteractionSuccessChatMsgItemViewFactory;
    }

    public static final IMessageItemViewFactory getChatLandNormalChatMsgItemViewFactory() {
        return ChatLandNormalChatMsgItemViewFactory;
    }

    public static final IMessageItemViewFactory getChatLandWelcomeAnnouncementMsgItemFactory() {
        return ChatLandWelcomeAnnouncementMsgItemFactory;
    }
}
