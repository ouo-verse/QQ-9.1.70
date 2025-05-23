package j71;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.utils.api.IZPlanAccessibleHelper;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a {
    public static void a(AppInterface appInterface) {
        ((IZPlanAccessibleHelper) QRoute.api(IZPlanAccessibleHelper.class)).refreshAccessibleRegularly(appInterface);
    }

    public static void b(AppInterface appInterface) {
        ((IZPlanAccessibleHelper) QRoute.api(IZPlanAccessibleHelper.class)).updateAllSceneAccessible(appInterface);
    }

    public static void c(AppInterface appInterface, boolean z16) {
        ((IZPlanAccessibleHelper) QRoute.api(IZPlanAccessibleHelper.class)).uploadPhoneType(appInterface, z16);
    }
}
