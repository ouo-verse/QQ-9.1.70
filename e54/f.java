package e54;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ax;
import com.tencent.qphone.base.util.QLog;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.robot.timbre.api.IRobotTimbreSettingApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Le54/f;", "Le54/a;", "Lcom/tencent/mobileqq/utils/ax;", "jumpAction", "", "a", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class f implements a {
    @Override // e54.a
    public boolean a(@NotNull ax jumpAction) {
        boolean z16;
        Intrinsics.checkNotNullParameter(jumpAction, "jumpAction");
        String str = jumpAction.f307441f.get("uin");
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.e("QRobotJumpAction", 1, "uin or uid is null not jump");
        } else {
            String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str);
            IRobotTimbreSettingApi iRobotTimbreSettingApi = (IRobotTimbreSettingApi) QRoute.api(IRobotTimbreSettingApi.class);
            Context context = jumpAction.f307437b;
            Intrinsics.checkNotNullExpressionValue(context, "jumpAction.context");
            iRobotTimbreSettingApi.startRobotTimbreSetting(context, str, uidFromUin, 0L);
        }
        return true;
    }
}
