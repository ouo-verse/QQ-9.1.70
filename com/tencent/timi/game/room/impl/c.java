package com.tencent.timi.game.room.impl;

import com.tencent.timi.game.utils.l;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.MessageOuterClass$MsgContent;
import trpc.yes.common.MessageOuterClass$TimMsgBody;
import trpc.yes.common.MessageOuterClass$YoloRoomActionMsg;
import trpc.yes.common.MessageOuterClass$YoloRoomNewDataPushMsg;
import trpc.yes.common.UserProxyCmdOuterClass$QQUserInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0006*\u0001\u000b\u0018\u00002\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0006\u0010\u0003\u001a\u00020\u0002R$\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0005\u0010\u0007\"\u0004\b\b\u0010\tR\u0014\u0010\r\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/timi/game/room/impl/c;", "", "", "b", "Lcom/tencent/timi/game/room/impl/c$a;", "a", "Lcom/tencent/timi/game/room/impl/c$a;", "()Lcom/tencent/timi/game/room/impl/c$a;", "c", "(Lcom/tencent/timi/game/room/impl/c$a;)V", "actionMessageListener", "com/tencent/timi/game/room/impl/c$b", "Lcom/tencent/timi/game/room/impl/c$b;", "newMsgListener", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a actionMessageListener;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b newMsgListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006H&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/timi/game/room/impl/c$a;", "", "", "msgId", "Ltrpc/yes/common/MessageOuterClass$YoloRoomActionMsg;", "action", "", "groupId", "", "c", "a", "Ltrpc/yes/common/MessageOuterClass$YoloRoomNewDataPushMsg;", "b", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public interface a {
        void a(@NotNull MessageOuterClass$YoloRoomActionMsg action, long groupId);

        void b(@NotNull MessageOuterClass$YoloRoomNewDataPushMsg action, long groupId);

        void c(@NotNull String msgId, @NotNull MessageOuterClass$YoloRoomActionMsg action, long groupId);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/timi/game/room/impl/c$b", "Lcom/tencent/timi/game/tim/api/message/d;", "Lcom/tencent/timi/game/tim/api/message/a;", "msg", "", "c", "", "groupId", "Ltrpc/yes/common/MessageOuterClass$TimMsgBody;", "timMsgBody", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b implements com.tencent.timi.game.tim.api.message.d {
        b() {
        }

        @Override // com.tencent.timi.game.tim.api.message.d
        public void a(long groupId, @NotNull MessageOuterClass$TimMsgBody timMsgBody) {
            MessageOuterClass$MsgContent messageOuterClass$MsgContent;
            MessageOuterClass$MsgContent messageOuterClass$MsgContent2;
            Intrinsics.checkNotNullParameter(timMsgBody, "timMsgBody");
            if (eh4.a.c()) {
                l.i("YoloRoomManager", "YoloRoomChatManager#onGroupMsgNotify " + timMsgBody.msg_type.get() + " - " + groupId + " - " + timMsgBody.content);
            }
            if (timMsgBody.msg_type.get() == 49 && (messageOuterClass$MsgContent2 = timMsgBody.content) != null && messageOuterClass$MsgContent2.yolo_room_action_msg.has()) {
                a actionMessageListener = c.this.getActionMessageListener();
                if (actionMessageListener != null) {
                    MessageOuterClass$YoloRoomActionMsg messageOuterClass$YoloRoomActionMsg = timMsgBody.content.yolo_room_action_msg;
                    Intrinsics.checkNotNullExpressionValue(messageOuterClass$YoloRoomActionMsg, "timMsgBody.content.yolo_room_action_msg");
                    actionMessageListener.a(messageOuterClass$YoloRoomActionMsg, groupId);
                    return;
                }
                return;
            }
            if (timMsgBody.msg_type.get() == 69 && (messageOuterClass$MsgContent = timMsgBody.content) != null && messageOuterClass$MsgContent.yolo_room_new_data_push_msg.has()) {
                a actionMessageListener2 = c.this.getActionMessageListener();
                if (actionMessageListener2 != null) {
                    MessageOuterClass$YoloRoomNewDataPushMsg messageOuterClass$YoloRoomNewDataPushMsg = timMsgBody.content.yolo_room_new_data_push_msg;
                    Intrinsics.checkNotNullExpressionValue(messageOuterClass$YoloRoomNewDataPushMsg, "timMsgBody.content.yolo_room_new_data_push_msg");
                    actionMessageListener2.b(messageOuterClass$YoloRoomNewDataPushMsg, groupId);
                    return;
                }
                return;
            }
            if (timMsgBody.msg_type.get() == 80 && timMsgBody.content.user_info_modify_notify_msg.has()) {
                UserProxyCmdOuterClass$QQUserInfo info = timMsgBody.content.user_info_modify_notify_msg.qq_user_info;
                bo4.d dVar = (bo4.d) mm4.b.b(bo4.d.class);
                Intrinsics.checkNotNullExpressionValue(info, "info");
                dVar.L3(info);
            }
        }

        @Override // com.tencent.timi.game.tim.api.message.d
        public void c(@NotNull com.tencent.timi.game.tim.api.message.a msg2) {
            a actionMessageListener;
            Intrinsics.checkNotNullParameter(msg2, "msg");
            if (msg2.type() == 49 && msg2.a().yolo_room_action_msg.has() && (actionMessageListener = c.this.getActionMessageListener()) != null) {
                String id5 = msg2.id();
                MessageOuterClass$YoloRoomActionMsg messageOuterClass$YoloRoomActionMsg = msg2.a().yolo_room_action_msg;
                Intrinsics.checkNotNullExpressionValue(messageOuterClass$YoloRoomActionMsg, "msg.content().yolo_room_action_msg");
                actionMessageListener.c(id5, messageOuterClass$YoloRoomActionMsg, msg2.j());
            }
        }
    }

    public c() {
        b bVar = new b();
        this.newMsgListener = bVar;
        ((kn4.b) mm4.b.b(kn4.b.class)).r0(bVar);
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final a getActionMessageListener() {
        return this.actionMessageListener;
    }

    public final void b() {
        ((kn4.b) mm4.b.b(kn4.b.class)).q2(this.newMsgListener);
    }

    public final void c(@Nullable a aVar) {
        this.actionMessageListener = aVar;
    }
}
