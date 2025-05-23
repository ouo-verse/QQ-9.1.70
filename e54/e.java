package e54;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.utils.ax;
import com.tencent.qphone.base.util.QLog;
import com.tencent.robot.profile.addtotroop.RobotAddToTroopFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Le54/e;", "Le54/a;", "Lcom/tencent/mobileqq/utils/ax;", "jumpAction", "", "a", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class e implements a {
    @Override // e54.a
    public boolean a(@NotNull ax jumpAction) {
        boolean z16;
        String str;
        Intrinsics.checkNotNullParameter(jumpAction, "jumpAction");
        String str2 = jumpAction.f307441f.get("uin");
        if (str2 != null && str2.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.e("RobotInviteToGroupProcessor", 1, "uin or uid is null not jump");
            return false;
        }
        Bundle bundle = new Bundle();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getCurrentAccountUin();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(str, "getAppRuntime()?.currentAccountUin ?: \"\"");
        }
        bundle.putString("uin", str);
        bundle.putInt("qq_robot_type", 1);
        RobotAddToTroopFragment.Companion companion = RobotAddToTroopFragment.INSTANCE;
        Context context = jumpAction.f307437b;
        Intrinsics.checkNotNullExpressionValue(context, "jumpAction.context");
        companion.a(context, str2, "", bundle);
        return true;
    }
}
