package eu0;

import com.tencent.icgame.trpc.yes.common.MessageOuterClass$YoloRoomActionMsg;
import com.tencent.icgame.trpc.yes.common.YoloRoomOuterClass$YoloRoomAction;
import com.tencent.mobileqq.pb.PBEnumField;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\"\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/icgame/game/tim/api/message/a;", "", "a", "(Lcom/tencent/icgame/game/tim/api/message/a;)I", "actionType", "ic-game-timi-game-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class b {
    public static final int a(@NotNull com.tencent.icgame.game.tim.api.message.a aVar) {
        YoloRoomOuterClass$YoloRoomAction yoloRoomOuterClass$YoloRoomAction;
        PBEnumField pBEnumField;
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        MessageOuterClass$YoloRoomActionMsg messageOuterClass$YoloRoomActionMsg = aVar.a().yolo_room_action_msg;
        if (messageOuterClass$YoloRoomActionMsg != null && (yoloRoomOuterClass$YoloRoomAction = messageOuterClass$YoloRoomActionMsg.yolo_room_action) != null && (pBEnumField = yoloRoomOuterClass$YoloRoomAction.action_type) != null) {
            return pBEnumField.get();
        }
        return -1;
    }
}
