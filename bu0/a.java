package bu0;

import com.tencent.icgame.game.utils.g;
import com.tencent.mobileqq.app.QBaseActivity;
import mqq.app.AccountNotMatchException;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes7.dex */
public class a {
    public static AppRuntime a() {
        AppRuntime appRuntime;
        QBaseActivity b16 = b();
        if (b16 != null) {
            appRuntime = b16.getAppRuntime();
        } else {
            appRuntime = null;
        }
        if (appRuntime == null) {
            try {
                appRuntime = MobileQQ.sMobileQQ.getAppRuntime(((mx0.a) qx0.a.b(mx0.a.class)).B());
                g.h("ICGameGameActivityManager_", "appRuntime from sMobileQQ");
                return appRuntime;
            } catch (AccountNotMatchException e16) {
                g.e("ICGameGameActivityManager_", "getAppRuntime failed", e16);
                return appRuntime;
            }
        }
        g.h("ICGameGameActivityManager_", "appRuntime from topActivity");
        return appRuntime;
    }

    public static QBaseActivity b() {
        return QBaseActivity.sTopActivity;
    }
}
