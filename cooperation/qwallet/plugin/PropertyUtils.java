package cooperation.qwallet.plugin;

import android.app.Activity;
import android.content.Context;
import com.tencent.mobileqq.qroute.QRoute;

/* loaded from: classes28.dex */
public class PropertyUtils {
    public static String getNetworkType(Context context) {
        return ((IPropertyUtils) QRoute.api(IPropertyUtils.class)).getNetworkType(context);
    }

    public static int getScreenWidth(Activity activity) {
        return ((IPropertyUtils) QRoute.api(IPropertyUtils.class)).getScreenWidth(activity);
    }

    public static int getTitleBarHeight(Activity activity) {
        return ((IPropertyUtils) QRoute.api(IPropertyUtils.class)).getTitleBarHeight(activity);
    }

    public static int getToastOffset(Context context) {
        return ((IPropertyUtils) QRoute.api(IPropertyUtils.class)).getToastOffset(context);
    }
}
