package mqq.app;

import android.content.Context;
import android.os.Bundle;

/* loaded from: classes28.dex */
public class ThirdPushSupportHelper {
    public static IThirdPushSupport sThirdPushSupport;

    public static int getThirdPushType(Context context, Bundle bundle) {
        IThirdPushSupport iThirdPushSupport = sThirdPushSupport;
        if (iThirdPushSupport != null) {
            return iThirdPushSupport.getThirdPushType(context, bundle);
        }
        return 1;
    }
}
