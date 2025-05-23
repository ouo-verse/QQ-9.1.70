package h24;

import android.content.Context;
import android.net.Uri;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.robot.aio.bottombar.model.RobotBottomBarItemModel;
import com.tencent.robot.api.IRobotStoryBoardApi;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u000e"}, d2 = {"Lh24/j;", "Lh24/a;", "Landroid/content/Context;", "context", "Lcom/tencent/robot/aio/bottombar/model/a;", "model", "", "b", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "", "a", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class j implements a {
    private final boolean b(Context context, RobotBottomBarItemModel model) {
        boolean z16;
        BaseQQAppInterface baseQQAppInterface;
        if (model.getAction().length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Boolean bool = null;
        if (peekAppRuntime instanceof BaseQQAppInterface) {
            baseQQAppInterface = (BaseQQAppInterface) peekAppRuntime;
        } else {
            baseQQAppInterface = null;
        }
        Uri.Builder buildUpon = Uri.parse(model.getAction()).buildUpon();
        buildUpon.appendQueryParameter("from", "1");
        if (baseQQAppInterface == null) {
            return false;
        }
        ax c16 = bi.c(baseQQAppInterface, context, buildUpon.toString());
        if (c16 != null) {
            bool = Boolean.valueOf(c16.b());
        }
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    @Override // h24.a
    public void a(@NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull RobotBottomBarItemModel model) {
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(model, "model");
        Context context = aioContext.c().getContext();
        if (context != null) {
            boolean b16 = b(context, model);
            if (!b16) {
                ((IRobotStoryBoardApi) QRoute.api(IRobotStoryBoardApi.class)).showRobotStoryBoard(aioContext, "1");
                new com.tencent.videocut.utils.dsl.b();
            } else {
                new com.tencent.videocut.utils.dsl.a(b16);
            }
            HashMap hashMap = new HashMap();
            hashMap.put("plot_id", String.valueOf(aioContext.g().l().getLong("key_robot_story_id")));
            com.tencent.mobileqq.aio.utils.b.l("em_bas_switch_plot", hashMap);
        }
    }
}
