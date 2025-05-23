package n34;

import android.widget.ImageView;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0006\u00a8\u0006\u000e"}, d2 = {"Ln34/d;", "", "Lcom/tencent/mobileqq/troop/robot/api/ITroopRobotService;", "b", "Landroid/widget/ImageView;", "view", "", "troopUin", "robotUin", "", "a", "c", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f418126a = new d();

    d() {
    }

    private final ITroopRobotService b() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            return (ITroopRobotService) peekAppRuntime.getRuntimeService(ITroopRobotService.class, "all");
        }
        return null;
    }

    public final void a(@NotNull ImageView view, @NotNull String troopUin, @NotNull String robotUin) {
        boolean z16;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(robotUin, "robotUin");
        ITroopRobotService b16 = b();
        if (b16 != null) {
            z16 = b16.isRobotUinNeedShowRed(MobileQQ.sMobileQQ.peekAppRuntime(), robotUin, troopUin);
        } else {
            z16 = false;
        }
        if (z16) {
            view.setVisibility(0);
            view.setTag(robotUin);
        } else {
            view.setVisibility(8);
        }
    }

    public final void c(@NotNull String robotUin) {
        Intrinsics.checkNotNullParameter(robotUin, "robotUin");
        ITroopRobotService b16 = b();
        if (b16 != null) {
            b16.removeRobotUinInRed(MobileQQ.sMobileQQ.peekAppRuntime(), robotUin);
        }
    }
}
