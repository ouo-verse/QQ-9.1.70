package com.tencent.qqguild.directmessage.aio.graytips.local.robotmsglimit;

import androidx.fragment.app.FragmentActivity;
import com.tencent.guild.aio.msglist.holder.component.t;
import com.tencent.mobileqq.guild.robot.api.IGuildRobotPageApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqguild.directmessage.aio.graytips.local.robotmsglimit.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qqguild/directmessage/aio/graytips/local/robotmsglimit/c;", "Lcom/tencent/guild/aio/msglist/holder/component/t;", "", "robotId", "robotUin", "robotName", "", "l", "Lol3/b;", "intent", "handleIntent", "<init>", "()V", "d", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class c extends t {
    /* JADX WARN: Multi-variable type inference failed */
    private final void l(String robotId, String robotUin, String robotName) {
        FragmentActivity activity = ((com.tencent.aio.api.runtime.a) getMContext()).c().getActivity();
        if (activity != null) {
            ((IGuildRobotPageApi) QRoute.api(IGuildRobotPageApi.class)).openRobotActiveMsgControlDialogFragment(activity, ((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().f(), robotId, robotUin, robotName);
        }
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.t, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void handleIntent(@NotNull ol3.b intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof b.a) {
            b.a aVar = (b.a) intent;
            l(aVar.getRobotId(), aVar.getRobotUin(), aVar.getRobotName());
        }
    }
}
