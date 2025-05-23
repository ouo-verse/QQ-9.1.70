package com.tencent.timi.game.room.impl.util;

import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.timi.game.utils.l;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.GameDataServerOuterClass$SmobaGameMode;
import trpc.yes.common.MessageOuterClass$GiftMsg;
import trpc.yes.common.MessageOuterClass$MsgContent;
import trpc.yes.common.MessageOuterClass$TextMsg;
import trpc.yes.common.MessageOuterClass$TimMsgBody;
import trpc.yes.common.MessageOuterClass$YoloRoomActionMsg;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomAction;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomInfo;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u0004\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u001e\u0010\r\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002J\u001e\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0011J\u001e\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u001e\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u000e\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/timi/game/room/impl/util/g;", "", "", "roomId", "a", "(Ljava/lang/Long;)J", "groupID", "", "f", "g", "d", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "userId", "e", "", "msgText", "c", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomInfo;", "roomInfo", "b", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomAction;", "action", "i", "txtContent", tl.h.F, "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f379335a = new g();

    g() {
    }

    private final long a(Long roomId) {
        long j3;
        fm4.g gVar = (fm4.g) mm4.b.b(fm4.g.class);
        if (roomId != null) {
            j3 = roomId.longValue();
        } else {
            j3 = 0;
        }
        return ((bo4.d) mm4.b.b(bo4.d.class)).t3(gVar.K0(j3).o1());
    }

    public final void b(@NotNull YoloRoomOuterClass$YoloRoomInfo roomInfo) {
        PBInt32Field pBInt32Field;
        Intrinsics.checkNotNullParameter(roomInfo, "roomInfo");
        roomInfo.tim_group_id.get();
        GameDataServerOuterClass$SmobaGameMode t06 = ((pm4.a) mm4.b.b(pm4.a.class)).t0(roomInfo.game_data_info.smoba_game_data_info.game_mode.get());
        if (t06 != null) {
            pBInt32Field = t06.game_type;
        } else {
            pBInt32Field = null;
        }
        l.i("YoloRoomIMUtil ", "sendEntertainmentAnnouncementMessage " + pBInt32Field);
        if (t06 != null) {
            t06.game_type.get();
        }
    }

    public final void c(long groupID, long roomId, @NotNull String msgText) {
        Intrinsics.checkNotNullParameter(msgText, "msgText");
        com.tencent.timi.game.tim.api.message.c M = ((kn4.b) mm4.b.b(kn4.b.class)).M(groupID);
        MessageOuterClass$TimMsgBody messageOuterClass$TimMsgBody = new MessageOuterClass$TimMsgBody();
        messageOuterClass$TimMsgBody.msg_type.set(pn4.e.a());
        MessageOuterClass$MsgContent messageOuterClass$MsgContent = messageOuterClass$TimMsgBody.content;
        MessageOuterClass$MsgContent messageOuterClass$MsgContent2 = new MessageOuterClass$MsgContent();
        MessageOuterClass$TextMsg messageOuterClass$TextMsg = messageOuterClass$MsgContent2.text_msg;
        MessageOuterClass$TextMsg messageOuterClass$TextMsg2 = new MessageOuterClass$TextMsg();
        messageOuterClass$TextMsg2.text.set(msgText);
        messageOuterClass$TextMsg.set(messageOuterClass$TextMsg2);
        messageOuterClass$MsgContent.set(messageOuterClass$MsgContent2);
        CommonOuterClass$QQUserId commonOuterClass$QQUserId = new CommonOuterClass$QQUserId();
        commonOuterClass$QQUserId.uid.set(f379335a.a(Long.valueOf(roomId)));
        Unit unit = Unit.INSTANCE;
        M.a(messageOuterClass$TimMsgBody, commonOuterClass$QQUserId);
    }

    public final void d(long groupID, long roomId) {
        com.tencent.timi.game.tim.api.message.c M = ((kn4.b) mm4.b.b(kn4.b.class)).M(groupID);
        MessageOuterClass$TimMsgBody messageOuterClass$TimMsgBody = new MessageOuterClass$TimMsgBody();
        messageOuterClass$TimMsgBody.msg_type.set(pn4.e.b());
        CommonOuterClass$QQUserId commonOuterClass$QQUserId = new CommonOuterClass$QQUserId();
        commonOuterClass$QQUserId.uid.set(f379335a.a(Long.valueOf(roomId)));
        Unit unit = Unit.INSTANCE;
        M.a(messageOuterClass$TimMsgBody, commonOuterClass$QQUserId);
    }

    public final void e(long groupID, @NotNull CommonOuterClass$QQUserId userId, long roomId) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        com.tencent.timi.game.tim.api.message.c M = ((kn4.b) mm4.b.b(kn4.b.class)).M(groupID);
        MessageOuterClass$TimMsgBody messageOuterClass$TimMsgBody = new MessageOuterClass$TimMsgBody();
        messageOuterClass$TimMsgBody.msg_type.set(pn4.e.c());
        MessageOuterClass$MsgContent messageOuterClass$MsgContent = messageOuterClass$TimMsgBody.content;
        MessageOuterClass$MsgContent messageOuterClass$MsgContent2 = new MessageOuterClass$MsgContent();
        MessageOuterClass$GiftMsg messageOuterClass$GiftMsg = messageOuterClass$MsgContent2.gift_msg;
        MessageOuterClass$GiftMsg messageOuterClass$GiftMsg2 = new MessageOuterClass$GiftMsg();
        messageOuterClass$GiftMsg2.recv_user_id.set(userId);
        messageOuterClass$GiftMsg.set(messageOuterClass$GiftMsg2);
        messageOuterClass$MsgContent.set(messageOuterClass$MsgContent2);
        CommonOuterClass$QQUserId commonOuterClass$QQUserId = new CommonOuterClass$QQUserId();
        commonOuterClass$QQUserId.uid.set(f379335a.a(Long.valueOf(roomId)));
        Unit unit = Unit.INSTANCE;
        M.a(messageOuterClass$TimMsgBody, commonOuterClass$QQUserId);
    }

    public final void f(long groupID, long roomId) {
        com.tencent.timi.game.tim.api.message.c M = ((kn4.b) mm4.b.b(kn4.b.class)).M(groupID);
        MessageOuterClass$TimMsgBody messageOuterClass$TimMsgBody = new MessageOuterClass$TimMsgBody();
        messageOuterClass$TimMsgBody.msg_type.set(pn4.e.d());
        CommonOuterClass$QQUserId commonOuterClass$QQUserId = new CommonOuterClass$QQUserId();
        commonOuterClass$QQUserId.uid.set(f379335a.a(Long.valueOf(roomId)));
        Unit unit = Unit.INSTANCE;
        M.a(messageOuterClass$TimMsgBody, commonOuterClass$QQUserId);
    }

    public final void g(long groupID, long roomId) {
        com.tencent.timi.game.tim.api.message.c M = ((kn4.b) mm4.b.b(kn4.b.class)).M(groupID);
        MessageOuterClass$TimMsgBody messageOuterClass$TimMsgBody = new MessageOuterClass$TimMsgBody();
        messageOuterClass$TimMsgBody.msg_type.set(pn4.e.e());
        CommonOuterClass$QQUserId commonOuterClass$QQUserId = new CommonOuterClass$QQUserId();
        commonOuterClass$QQUserId.uid.set(f379335a.a(Long.valueOf(roomId)));
        Unit unit = Unit.INSTANCE;
        M.a(messageOuterClass$TimMsgBody, commonOuterClass$QQUserId);
    }

    public final void h(long groupID, long roomId, @NotNull String txtContent) {
        Intrinsics.checkNotNullParameter(txtContent, "txtContent");
        MessageOuterClass$TextMsg messageOuterClass$TextMsg = new MessageOuterClass$TextMsg();
        messageOuterClass$TextMsg.text.set(txtContent);
        MessageOuterClass$MsgContent messageOuterClass$MsgContent = new MessageOuterClass$MsgContent();
        messageOuterClass$MsgContent.text_msg.set(messageOuterClass$TextMsg);
        com.tencent.timi.game.tim.api.message.c M = ((kn4.b) mm4.b.b(kn4.b.class)).M(groupID);
        MessageOuterClass$TimMsgBody messageOuterClass$TimMsgBody = new MessageOuterClass$TimMsgBody();
        messageOuterClass$TimMsgBody.msg_type.set(1);
        messageOuterClass$TimMsgBody.content.set(messageOuterClass$MsgContent);
        CommonOuterClass$QQUserId commonOuterClass$QQUserId = new CommonOuterClass$QQUserId();
        commonOuterClass$QQUserId.uid.set(f379335a.a(Long.valueOf(roomId)));
        Unit unit = Unit.INSTANCE;
        M.a(messageOuterClass$TimMsgBody, commonOuterClass$QQUserId);
    }

    public final void i(@NotNull YoloRoomOuterClass$YoloRoomAction action, long groupID, long roomId) {
        Intrinsics.checkNotNullParameter(action, "action");
        MessageOuterClass$YoloRoomActionMsg messageOuterClass$YoloRoomActionMsg = new MessageOuterClass$YoloRoomActionMsg();
        messageOuterClass$YoloRoomActionMsg.yolo_room_action.set(action);
        MessageOuterClass$MsgContent messageOuterClass$MsgContent = new MessageOuterClass$MsgContent();
        messageOuterClass$MsgContent.yolo_room_action_msg.set(messageOuterClass$YoloRoomActionMsg);
        l.i("YoloRoomIMUtil ", "sendYoloActionMessage " + action.action_type);
        com.tencent.timi.game.tim.api.message.c M = ((kn4.b) mm4.b.b(kn4.b.class)).M(groupID);
        MessageOuterClass$TimMsgBody messageOuterClass$TimMsgBody = new MessageOuterClass$TimMsgBody();
        messageOuterClass$TimMsgBody.msg_type.set(49);
        messageOuterClass$TimMsgBody.content.set(messageOuterClass$MsgContent);
        CommonOuterClass$QQUserId commonOuterClass$QQUserId = new CommonOuterClass$QQUserId();
        commonOuterClass$QQUserId.uid.set(f379335a.a(Long.valueOf(roomId)));
        Unit unit = Unit.INSTANCE;
        M.g(messageOuterClass$TimMsgBody, commonOuterClass$QQUserId);
    }
}
