package nl4;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomSpeakingPosInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&J\u001c\u0010\u000b\u001a\u00020\u00052\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007H&\u00a8\u0006\f"}, d2 = {"Lnl4/b;", "", "", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomSpeakingPosInfo;", "dataList", "", "b", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "memberMicLevelList", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public interface b {
    void a(@NotNull ConcurrentHashMap<String, Integer> memberMicLevelList);

    void b(@NotNull List<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> dataList);
}
