package pk3;

import android.content.Context;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingPermission;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a {
    public static boolean a(Context context) {
        return ((IQQFloatingPermission) QRoute.api(IQQFloatingPermission.class)).checkPermission(context);
    }

    public static boolean b(Context context) {
        return ((IQQFloatingPermission) QRoute.api(IQQFloatingPermission.class)).requestPermission(context);
    }
}
