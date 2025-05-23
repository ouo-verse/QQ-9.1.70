package k44;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.utils.ax;
import com.tencent.qphone.base.util.QLog;
import com.tencent.robot.discover.fragment.RobotSearchFragment;
import com.tencent.robot.profile.RobotProfileFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \n2\u00020\u0001:\u0001\u000bB\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"Lk44/a;", "Lcom/tencent/mobileqq/utils/ax;", "", "b", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "app", "Landroid/content/Context;", "context", "<init>", "(Lcom/tencent/common/app/business/BaseQQAppInterface;Landroid/content/Context;)V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class a extends ax {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull BaseQQAppInterface app, @NotNull Context context) {
        super(app, context);
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.tencent.mobileqq.utils.ax
    public boolean b() {
        boolean z16 = true;
        QLog.d("robot.profile.TroopRobotJumpAction", 1, "doAction " + this.f307440e);
        String str = this.f307440e;
        if (Intrinsics.areEqual(str, "show_card")) {
            String str2 = this.f307441f.get("uin");
            if (str2 == null) {
                str2 = "";
            }
            String str3 = str2;
            QLog.d("robot.profile.TroopRobotJumpAction", 1, "jump profile robotUin " + str3);
            if (str3.length() <= 0) {
                z16 = false;
            }
            if (z16) {
                RobotProfileFragment.Companion companion = RobotProfileFragment.INSTANCE;
                Context context = this.f307437b;
                Intrinsics.checkNotNullExpressionValue(context, "context");
                RobotProfileFragment.Companion.c(companion, context, "", str3, 12, true, 0, null, 96, null);
            }
        } else if (Intrinsics.areEqual(str, "open_robot_search")) {
            RobotSearchFragment.Companion companion2 = RobotSearchFragment.INSTANCE;
            Context context2 = this.f307437b;
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            companion2.a(context2);
        }
        return super.b();
    }
}
