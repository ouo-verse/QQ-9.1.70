package cooperation.qzone.api;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.IQZoneApiProxy;
import mqq.app.AppRuntime;

/* loaded from: classes28.dex */
public class QZoneApiProxy {
    public static final String FEEDX_FRAME_FRAGMENT_CLASS_NAME = "com.qzone.reborn.feedx.fragment.QZoneFeedXOldFrameFragment";
    public static final String FEEDX_FRAME_ZPALN_FRAGMENT_CLASS_NAME = "com.qzone.reborn.feedx.fragment.QZoneFeedXFrameWithZPlanFragment";
    private static final String TAG = "QZoneApiProxy";

    /* loaded from: classes28.dex */
    public interface QZoneLoadCallback {
        void onLoadOver(boolean z16);
    }

    @Nullable
    public static Fragment createLebaFragment(@NonNull Activity activity, @NonNull AppRuntime appRuntime, @NonNull String str) {
        return ((IQZoneApiProxy) QRoute.api(IQZoneApiProxy.class)).createLebaFragment(activity, appRuntime, str);
    }

    public static AppRuntime getLastRuntime() {
        return ((IQZoneApiProxy) QRoute.api(IQZoneApiProxy.class)).getLastRuntime();
    }

    public static boolean initEnv(@NonNull Context context, @NonNull AppRuntime appRuntime) {
        return ((IQZoneApiProxy) QRoute.api(IQZoneApiProxy.class)).initEnv(context, appRuntime);
    }

    public static boolean initServlet(@NonNull Context context, @NonNull AppRuntime appRuntime) {
        return ((IQZoneApiProxy) QRoute.api(IQZoneApiProxy.class)).initServlet(context, appRuntime);
    }

    public static boolean isInQZoneEnvironment() {
        return ((IQZoneApiProxy) QRoute.api(IQZoneApiProxy.class)).isInQZoneEnvironment();
    }

    public static boolean isQZonePluginInit() {
        return ((IQZoneApiProxy) QRoute.api(IQZoneApiProxy.class)).isQZonePluginInit();
    }

    public static boolean isRightAndroidVersionForStickyNote() {
        return true;
    }

    public static boolean needShowAioFeedList(@Nullable Activity activity, @Nullable AppRuntime appRuntime) {
        return ((IQZoneApiProxy) QRoute.api(IQZoneApiProxy.class)).needShowAioFeedList(activity, appRuntime);
    }

    public static boolean needShowQzoneFrame(@Nullable Context context, @Nullable AppRuntime appRuntime) {
        return ((IQZoneApiProxy) QRoute.api(IQZoneApiProxy.class)).needShowQzoneFrame(context, appRuntime);
    }

    public static void onAccountChange(@NonNull Context context, @NonNull AppRuntime appRuntime) {
        ((IQZoneApiProxy) QRoute.api(IQZoneApiProxy.class)).onAccountChange(context, appRuntime);
    }
}
