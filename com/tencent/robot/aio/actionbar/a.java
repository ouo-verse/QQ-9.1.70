package com.tencent.robot.aio.actionbar;

import com.tencent.aio.data.AIOParam;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.robot.api.IRobotServiceApi;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/robot/aio/actionbar/a;", "Lcom/tencent/mobileqq/aio/msg/action/b;", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "", "b", "Lcom/tencent/mobileqq/aio/msg/action/a;", "updater", "Lcom/tencent/mobileqq/aio/msg/action/c;", "a", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class a implements com.tencent.mobileqq.aio.msg.action.b {
    @Override // com.tencent.mobileqq.aio.msg.action.b
    @NotNull
    public com.tencent.mobileqq.aio.msg.action.c a(@NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull com.tencent.mobileqq.aio.msg.action.a updater) {
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(updater, "updater");
        return new RobotAIOMsgActionBarView(aioContext, updater);
    }

    @Override // com.tencent.mobileqq.aio.msg.action.b
    public boolean b(@NotNull com.tencent.aio.api.runtime.a aioContext) {
        Long longOrNull;
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        AIOParam g16 = aioContext.g();
        Intrinsics.checkNotNullExpressionValue(g16, "aioContext.aioParam");
        long a16 = su3.c.a(g16);
        int e16 = aioContext.g().r().c().e();
        if (a16 == 0) {
            String friendUinFromUid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getFriendUinFromUid(aioContext.g().r().c().j());
            Intrinsics.checkNotNullExpressionValue(friendUinFromUid, "api(IRelationNTUinAndUid\u2026.getFriendUinFromUid(uid)");
            longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(friendUinFromUid);
            if (longOrNull != null) {
                a16 = longOrNull.longValue();
            } else {
                a16 = 0;
            }
        }
        return ((IRobotServiceApi) QRoute.api(IRobotServiceApi.class)).isRobotAIO(String.valueOf(a16), Integer.valueOf(e16));
    }
}
