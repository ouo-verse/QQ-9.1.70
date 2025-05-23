package com.tencent.timi.game.component.chat.message;

import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomAction;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomCommunityConf;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomConf;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomInfo;
import trpc.yes.wuji.WujiYoloRoomOuterClass$WujiYoloCommunityRoomConf;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/timi/game/component/chat/message/ad;", "messageViewProvider", "Lcom/tencent/timi/game/tim/api/message/a;", "msg", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomInfo;", "roomInfo", "", "a", "timi-game-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class q {
    public static final boolean a(@NotNull ad messageViewProvider, @NotNull com.tencent.timi.game.tim.api.message.a msg2, @NotNull YoloRoomOuterClass$YoloRoomInfo roomInfo) {
        boolean isBlank;
        boolean z16;
        long j3;
        String str;
        YoloRoomOuterClass$YoloRoomCommunityConf yoloRoomOuterClass$YoloRoomCommunityConf;
        WujiYoloRoomOuterClass$WujiYoloCommunityRoomConf wujiYoloRoomOuterClass$WujiYoloCommunityRoomConf;
        PBStringField pBStringField;
        boolean z17;
        boolean z18;
        Intrinsics.checkNotNullParameter(messageViewProvider, "messageViewProvider");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(roomInfo, "roomInfo");
        if (msg2.type() == 49) {
            YoloRoomOuterClass$YoloRoomAction yoloRoomOuterClass$YoloRoomAction = msg2.a().yolo_room_action_msg.yolo_room_action.get();
            if (yoloRoomOuterClass$YoloRoomAction.action_type.get() == 153) {
                String str2 = yoloRoomOuterClass$YoloRoomAction.yolo_game_room_send_notice_action.notice.get();
                if (str2 != null && str2.length() != 0) {
                    z18 = false;
                } else {
                    z18 = true;
                }
                if (z18) {
                    return false;
                }
            }
            if (yoloRoomOuterClass$YoloRoomAction.action_type.get() == 101 && roomInfo.room_type.get() == 5 && zf4.c.f452468a.h(msg2)) {
                if (2 == roomInfo.room_data_info.create_from.get()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    str = "";
                } else {
                    fm4.g gVar = (fm4.g) mm4.b.b(fm4.g.class);
                    PBUInt64Field pBUInt64Field = roomInfo.room_id;
                    if (pBUInt64Field != null) {
                        j3 = pBUInt64Field.get();
                    } else {
                        j3 = 0;
                    }
                    YoloRoomOuterClass$YoloRoomConf Y = gVar.K0(j3).Y();
                    if (Y != null && (yoloRoomOuterClass$YoloRoomCommunityConf = Y.yolo_room_community_conf) != null && (wujiYoloRoomOuterClass$WujiYoloCommunityRoomConf = yoloRoomOuterClass$YoloRoomCommunityConf.wuji_yolo_room_community_conf) != null && (pBStringField = wujiYoloRoomOuterClass$WujiYoloCommunityRoomConf.notice) != null) {
                        str = pBStringField.get();
                    } else {
                        str = null;
                    }
                }
                if (str != null && str.length() != 0) {
                    z17 = false;
                } else {
                    z17 = true;
                }
                if (z17) {
                    return false;
                }
            }
        }
        int b16 = messageViewProvider.b(msg2);
        if (b16 == 4) {
            isBlank = StringsKt__StringsJVMKt.isBlank(msg2.g());
            if (!isBlank) {
                return true;
            }
        } else {
            switch (b16) {
                case 13:
                case 14:
                case 15:
                    if (msg2.a().share_ark_msg.game_id.get() != 101) {
                        return true;
                    }
                    break;
                default:
                    return true;
            }
        }
        return false;
    }
}
