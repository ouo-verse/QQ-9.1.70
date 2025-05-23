package d54;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.robot.adelie.homepage.api.IAdelieHomePageApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Foreground;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Ld54/b;", "Ld54/h;", "Lcom/tencent/mobileqq/utils/ax;", "jumpAction", "", "a", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class b implements h {
    @Override // d54.h
    public boolean a(@NotNull ax jumpAction) {
        Intrinsics.checkNotNullParameter(jumpAction, "jumpAction");
        Activity topActivity = Foreground.getTopActivity();
        if (topActivity == null) {
            QLog.w("AdelieEditJumpProcessor", 1, "openHome, getTopActivity is null");
            Context context = jumpAction.f307437b;
            if (context instanceof Activity) {
                Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
                topActivity = (Activity) context;
            } else {
                topActivity = null;
            }
            if (topActivity == null) {
                QLog.w("AdelieEditJumpProcessor", 1, "openHome, activity is null");
                return true;
            }
        }
        Bundle bundle = new Bundle();
        String f16 = jumpAction.f(ISchemeApi.KEY_REFERER);
        String f17 = jumpAction.f(ISchemeApi.KEY_PAGE_DATA);
        bundle.putString(ISchemeApi.KEY_REFERER, f16);
        bundle.putString(ISchemeApi.KEY_PAGE_DATA, f17);
        bundle.putString("jumpPage", "creative_center");
        ((IAdelieHomePageApi) QRoute.api(IAdelieHomePageApi.class)).startAdelieHomePage(topActivity, bundle);
        return true;
    }
}
