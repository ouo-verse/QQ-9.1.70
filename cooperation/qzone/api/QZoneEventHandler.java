package cooperation.qzone.api;

import android.content.Intent;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.IQZoneEventHandlerProxy;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QZoneEventHandler {
    private static final String TAG = "QZoneEventHandler";

    public static boolean handleActivityEvent(Object obj, int i3, int i16, Intent intent) {
        return ((IQZoneEventHandlerProxy) QRoute.api(IQZoneEventHandlerProxy.class)).handleActivityEvent(obj, i3, i16, intent);
    }
}
