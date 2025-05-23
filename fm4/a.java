package fm4;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.YoloRoomOuterClass$DoYoloRoomCmdRsp;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomCmdRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\u001a\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH&\u00a8\u0006\r"}, d2 = {"Lfm4/a;", "", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomCmdRsp;", "cmdRsp", "Ltrpc/yes/common/YoloRoomOuterClass$DoYoloRoomCmdRsp;", "doYoloRoomCmdRsp", "", "a", "", "errorCode", "", "errorMessage", "onError", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public interface a {
    void a(@Nullable YoloRoomOuterClass$YoloRoomCmdRsp cmdRsp, @Nullable YoloRoomOuterClass$DoYoloRoomCmdRsp doYoloRoomCmdRsp);

    void onError(int errorCode, @Nullable String errorMessage);
}
