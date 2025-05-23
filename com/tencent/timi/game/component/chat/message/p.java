package com.tencent.timi.game.component.chat.message;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import trpc.yes.common.MessageOuterClass$MsgContent;
import trpc.yes.common.MessageOuterClass$TimMsgBody;
import trpc.yes.common.MessageOuterClass$YoloRoomActionMsg;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomAction;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0016\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u0006"}, d2 = {"Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomInfo;", "roomInfo", "Ltrpc/yes/common/MessageOuterClass$TimMsgBody;", "timMsgBody", "", "a", "timi-game-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class p {
    public static final boolean a(@NotNull YoloRoomOuterClass$YoloRoomInfo roomInfo, @NotNull MessageOuterClass$TimMsgBody timMsgBody) {
        YoloRoomOuterClass$YoloRoomAction yoloRoomOuterClass$YoloRoomAction;
        boolean z16;
        MessageOuterClass$YoloRoomActionMsg messageOuterClass$YoloRoomActionMsg;
        YoloRoomOuterClass$YoloRoomAction yoloRoomOuterClass$YoloRoomAction2;
        Intrinsics.checkNotNullParameter(roomInfo, "roomInfo");
        Intrinsics.checkNotNullParameter(timMsgBody, "timMsgBody");
        if (timMsgBody.msg_type.get() != 49) {
            return false;
        }
        MessageOuterClass$MsgContent messageOuterClass$MsgContent = timMsgBody.content;
        if (messageOuterClass$MsgContent != null && (messageOuterClass$YoloRoomActionMsg = messageOuterClass$MsgContent.yolo_room_action_msg) != null && (yoloRoomOuterClass$YoloRoomAction2 = messageOuterClass$YoloRoomActionMsg.yolo_room_action) != null) {
            yoloRoomOuterClass$YoloRoomAction = yoloRoomOuterClass$YoloRoomAction2.get();
        } else {
            yoloRoomOuterClass$YoloRoomAction = null;
        }
        if (yoloRoomOuterClass$YoloRoomAction == null) {
            return false;
        }
        if (yoloRoomOuterClass$YoloRoomAction.action_type.get() == 153) {
            String str = yoloRoomOuterClass$YoloRoomAction.yolo_game_room_send_notice_action.notice.get();
            Intrinsics.checkNotNullExpressionValue(str, "action.yolo_game_room_se\u2026otice_action.notice.get()");
            if (str.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return true;
            }
        }
        if (yoloRoomOuterClass$YoloRoomAction.action_type.get() != 101 || roomInfo.room_type.get() != 5) {
            return false;
        }
        return true;
    }
}
