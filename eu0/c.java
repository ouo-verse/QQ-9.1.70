package eu0;

import com.tencent.icgame.trpc.yes.common.CommonOuterClass$QQUserId;
import com.tencent.icgame.trpc.yes.common.MessageOuterClass$YoloRoomActionMsg;
import com.tencent.icgame.trpc.yes.common.YoloRoomOuterClass$YoloRoomAction;
import com.tencent.icgame.trpc.yes.common.YoloRoomOuterClass$YoloRoomEnterAction;
import com.tencent.mobileqq.pb.PBUInt64Field;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006\u00a8\u0006\f"}, d2 = {"Leu0/c;", "", "Lcom/tencent/icgame/game/tim/api/message/a;", "msg", "", "b", "", "roomId", "", "a", "<init>", "()V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f397132a = new c();

    c() {
    }

    public final int a(long roomId) {
        return 10004;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x004b, code lost:
    
        if (r2 == false) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean b(@NotNull com.tencent.icgame.game.tim.api.message.a msg2) {
        YoloRoomOuterClass$YoloRoomAction yoloRoomOuterClass$YoloRoomAction;
        YoloRoomOuterClass$YoloRoomEnterAction yoloRoomOuterClass$YoloRoomEnterAction;
        CommonOuterClass$QQUserId commonOuterClass$QQUserId;
        boolean z16;
        PBUInt64Field pBUInt64Field;
        boolean z17;
        PBUInt64Field pBUInt64Field2;
        Intrinsics.checkNotNullParameter(msg2, "msg");
        MessageOuterClass$YoloRoomActionMsg messageOuterClass$YoloRoomActionMsg = msg2.a().yolo_room_action_msg;
        if (messageOuterClass$YoloRoomActionMsg == null || (yoloRoomOuterClass$YoloRoomAction = messageOuterClass$YoloRoomActionMsg.yolo_room_action) == null || (yoloRoomOuterClass$YoloRoomEnterAction = yoloRoomOuterClass$YoloRoomAction.yolo_room_enter_action) == null || (commonOuterClass$QQUserId = yoloRoomOuterClass$YoloRoomEnterAction.user_id) == null) {
            return false;
        }
        CommonOuterClass$QQUserId E = ((mx0.a) qx0.a.b(mx0.a.class)).E();
        if (commonOuterClass$QQUserId.uid.get() != 0) {
            if (E != null && (pBUInt64Field2 = E.uid) != null && commonOuterClass$QQUserId.uid.get() == pBUInt64Field2.get()) {
                z17 = true;
            } else {
                z17 = false;
            }
        }
        if (commonOuterClass$QQUserId.yes_uid.get() == 0) {
            return false;
        }
        if (E != null && (pBUInt64Field = E.yes_uid) != null && commonOuterClass$QQUserId.yes_uid.get() == pBUInt64Field.get()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        return true;
    }
}
