package h24;

import com.tencent.robot.aio.bottombar.model.RobotBottomBarItemModel;
import com.tencent.robot.aio.input.RobotMenuMsgIntent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lh24/d;", "Lh24/a;", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lcom/tencent/robot/aio/bottombar/model/a;", "model", "", "a", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class d implements a {
    @Override // h24.a
    public void a(@NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull RobotBottomBarItemModel model) {
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(model, "model");
        aioContext.e().h(RobotMenuMsgIntent.ShowRobotMenuDialog.f367150d);
        com.tencent.mobileqq.aio.utils.b.f194119a.k("em_bas_agent_interact_more");
    }
}
