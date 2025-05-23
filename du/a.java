package du;

import android.content.Context;
import com.tencent.av.config.api.IConfigManager;
import com.tencent.av.config.api.IConfigParser;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static IConfigManager f394851a;

    public static IConfigManager a(Context context) {
        if (f394851a == null) {
            synchronized (IConfigManager.class) {
                if (f394851a == null) {
                    IConfigManager iConfigManager = (IConfigManager) QRoute.api(IConfigManager.class);
                    f394851a = iConfigManager;
                    iConfigManager.onCreate(context);
                }
            }
        }
        return f394851a;
    }

    public static IConfigParser b(Context context) {
        return a(context).getConfigParser(context);
    }

    public static void c(Context context) {
        if (f394851a != null) {
            synchronized (IConfigManager.class) {
                IConfigManager iConfigManager = f394851a;
                if (iConfigManager != null) {
                    iConfigManager.onDestroy(context);
                    f394851a = null;
                }
            }
        }
    }
}
