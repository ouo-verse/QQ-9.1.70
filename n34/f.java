package n34;

import com.tencent.qqnt.kernel.nativeinterface.GroupRobot;
import com.tencent.qqnt.kernel.nativeinterface.GroupRobotStoreCategoryListRsp;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/qqnt/kernel/nativeinterface/GroupRobotStoreCategoryListRsp;", "", "a", "robot-business-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class f {
    @NotNull
    public static final String a(@NotNull GroupRobotStoreCategoryListRsp groupRobotStoreCategoryListRsp) {
        String joinToString$default;
        Intrinsics.checkNotNullParameter(groupRobotStoreCategoryListRsp, "<this>");
        boolean z16 = groupRobotStoreCategoryListRsp.isEnd;
        ArrayList<GroupRobot> robots = groupRobotStoreCategoryListRsp.robots;
        Intrinsics.checkNotNullExpressionValue(robots, "robots");
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(robots, null, null, null, 0, null, null, 63, null);
        return "isEnd=" + z16 + " data=" + joinToString$default;
    }
}
