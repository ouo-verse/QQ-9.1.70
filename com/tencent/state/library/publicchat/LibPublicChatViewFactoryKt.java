package com.tencent.state.library.publicchat;

import android.content.Context;
import com.tencent.state.publicchat.action.MsgAction;
import com.tencent.state.publicchat.data.MsgConfInfo;
import com.tencent.state.publicchat.data.MsgInfo;
import com.tencent.state.publicchat.view.AbstractMessageItemView;
import com.tencent.state.publicchat.view.IMessageItemViewFactory;
import com.tencent.state.template.data.RoomThemeData;
import com.tencent.state.template.publicchat.view.FocusInviteChatMsgItemView;
import com.tencent.state.template.publicchat.view.FocusKeepChatMsgItemView;
import com.tencent.state.template.publicchat.view.FocusNormalChatMsgItemView;
import com.tencent.state.template.publicchat.view.FocusWelcomeAnnouncementMsgItemView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\"\u0011\u0010\u0000\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0011\u0010\u0004\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0003\"\u0011\u0010\u0006\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0003\"\u0011\u0010\b\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0003\u00a8\u0006\n"}, d2 = {"LibFocusKeepChatMsgItemViewFactory", "Lcom/tencent/state/publicchat/view/IMessageItemViewFactory;", "getLibFocusKeepChatMsgItemViewFactory", "()Lcom/tencent/state/publicchat/view/IMessageItemViewFactory;", "LibInviteChatMsgItemViewFactory", "getLibInviteChatMsgItemViewFactory", "LibNormalChatMsgItemViewFactory", "getLibNormalChatMsgItemViewFactory", "LibWelcomeAnnouncementMsgItemFactory", "getLibWelcomeAnnouncementMsgItemFactory", "state_square_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class LibPublicChatViewFactoryKt {
    private static final IMessageItemViewFactory LibWelcomeAnnouncementMsgItemFactory = new IMessageItemViewFactory() { // from class: com.tencent.state.library.publicchat.LibPublicChatViewFactoryKt$LibWelcomeAnnouncementMsgItemFactory$1
        private final String TEMPLATE_ID = "lib_welcome_announcement";

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
    private static final IMessageItemViewFactory LibNormalChatMsgItemViewFactory = new IMessageItemViewFactory() { // from class: com.tencent.state.library.publicchat.LibPublicChatViewFactoryKt$LibNormalChatMsgItemViewFactory$1
        private final String TEMPLATE_ID = "lib_normal_chat";

        @Override // com.tencent.state.publicchat.view.IMessageItemViewFactory
        public AbstractMessageItemView create(Context context, MsgConfInfo conf, MsgInfo msg2, Function1<? super MsgAction, Unit> dispatchAction, RoomThemeData themeData) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(conf, "conf");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            Intrinsics.checkNotNullParameter(dispatchAction, "dispatchAction");
            return new FocusNormalChatMsgItemView(context, conf, msg2, dispatchAction, null, 16, null);
        }

        @Override // com.tencent.state.publicchat.view.IMessageItemViewFactory
        /* renamed from: templateId, reason: from getter */
        public String getTEMPLATE_ID() {
            return this.TEMPLATE_ID;
        }
    };
    private static final IMessageItemViewFactory LibInviteChatMsgItemViewFactory = new IMessageItemViewFactory() { // from class: com.tencent.state.library.publicchat.LibPublicChatViewFactoryKt$LibInviteChatMsgItemViewFactory$1
        private final String TEMPLATE_ID = "lib_invite_chat";

        @Override // com.tencent.state.publicchat.view.IMessageItemViewFactory
        public AbstractMessageItemView create(Context context, MsgConfInfo conf, MsgInfo msg2, Function1<? super MsgAction, Unit> dispatchAction, RoomThemeData themeData) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(conf, "conf");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            Intrinsics.checkNotNullParameter(dispatchAction, "dispatchAction");
            return new FocusInviteChatMsgItemView(context, conf, msg2, dispatchAction);
        }

        @Override // com.tencent.state.publicchat.view.IMessageItemViewFactory
        /* renamed from: templateId, reason: from getter */
        public String getTEMPLATE_ID() {
            return this.TEMPLATE_ID;
        }
    };
    private static final IMessageItemViewFactory LibFocusKeepChatMsgItemViewFactory = new IMessageItemViewFactory() { // from class: com.tencent.state.library.publicchat.LibPublicChatViewFactoryKt$LibFocusKeepChatMsgItemViewFactory$1
        private final String TEMPLATE_ID = "lib_focus_keep";

        @Override // com.tencent.state.publicchat.view.IMessageItemViewFactory
        public AbstractMessageItemView create(Context context, MsgConfInfo conf, MsgInfo msg2, Function1<? super MsgAction, Unit> dispatchAction, RoomThemeData themeData) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(conf, "conf");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            Intrinsics.checkNotNullParameter(dispatchAction, "dispatchAction");
            return new FocusKeepChatMsgItemView(context, conf, msg2, dispatchAction);
        }

        @Override // com.tencent.state.publicchat.view.IMessageItemViewFactory
        /* renamed from: templateId, reason: from getter */
        public String getTEMPLATE_ID() {
            return this.TEMPLATE_ID;
        }
    };

    public static final IMessageItemViewFactory getLibFocusKeepChatMsgItemViewFactory() {
        return LibFocusKeepChatMsgItemViewFactory;
    }

    public static final IMessageItemViewFactory getLibInviteChatMsgItemViewFactory() {
        return LibInviteChatMsgItemViewFactory;
    }

    public static final IMessageItemViewFactory getLibNormalChatMsgItemViewFactory() {
        return LibNormalChatMsgItemViewFactory;
    }

    public static final IMessageItemViewFactory getLibWelcomeAnnouncementMsgItemFactory() {
        return LibWelcomeAnnouncementMsgItemFactory;
    }
}
