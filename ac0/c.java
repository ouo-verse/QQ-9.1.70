package ac0;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;

/* compiled from: P */
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static Boolean f25791a;

    public static synchronized boolean a() {
        synchronized (c.class) {
            Boolean bool = f25791a;
            if (bool != null) {
                return bool.booleanValue();
            }
            Boolean valueOf = Boolean.valueOf(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_pic_layer_muti", true));
            f25791a = valueOf;
            return valueOf.booleanValue();
        }
    }

    public static void b() {
        f25791a = null;
    }
}
