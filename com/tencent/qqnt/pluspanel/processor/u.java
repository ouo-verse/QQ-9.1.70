package com.tencent.qqnt.pluspanel.processor;

import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.robot.api.IRobotDiscoveryApi;
import com.tencent.robot.troop.discovery.LaunchSourceType;
import com.tencent.robot.troop.discovery.TroopRobotDiscoveryLaunchArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/pluspanel/processor/u;", "Lcom/tencent/qqnt/pluspanel/logic/b;", "Lcom/tencent/qqnt/pluspanel/data/a;", "data", "Lcom/tencent/aio/api/runtime/a;", "context", "", "a", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class u implements com.tencent.qqnt.pluspanel.logic.b {
    @Override // com.tencent.qqnt.pluspanel.logic.b
    public void a(com.tencent.qqnt.pluspanel.data.a data, com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(context, "context");
        String i3 = data.i();
        if (i3 == null || i3.length() == 0) {
            QLog.e("RobotDiscoveryPageClickProcessor", 1, "onClick| troopUin is null or empty");
            return;
        }
        FragmentActivity activity = context.c().getActivity();
        if (activity == null) {
            return;
        }
        ((IRobotDiscoveryApi) QRoute.api(IRobotDiscoveryApi.class)).launchTroopRobotDiscoveryPage(new TroopRobotDiscoveryLaunchArgs(activity, i3, LaunchSourceType.UNKNOWN));
    }
}
