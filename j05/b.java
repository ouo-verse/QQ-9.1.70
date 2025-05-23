package j05;

import com.tencent.bugly.common.constants.Constants;
import com.tencent.hippy.qq.api.TabPreloadItem;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomRotateMessage;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\fJ\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0003H&\u00a8\u0006\r"}, d2 = {"Lj05/b;", "", "Lmm4/a;", "", "roomId", "", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomRotateMessage;", TabPreloadItem.TAB_NAME_MESSAGE, "", "p2", "R2", Constants.APK_CERTIFICATE, "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes28.dex */
public interface b extends mm4.a {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&\u00a8\u0006\u0007"}, d2 = {"Lj05/b$a;", "", "", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomRotateMessage;", TabPreloadItem.TAB_NAME_MESSAGE, "", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes28.dex */
    public interface a {
        void a(@NotNull List<YoloRoomOuterClass$YoloRoomRotateMessage> msgList);
    }

    void G1(long roomId);

    @NotNull
    List<YoloRoomOuterClass$YoloRoomRotateMessage> R2();

    void p2(long roomId, @NotNull List<YoloRoomOuterClass$YoloRoomRotateMessage> msgList);
}
