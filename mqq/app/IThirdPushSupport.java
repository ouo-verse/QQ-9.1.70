package mqq.app;

import android.content.Context;
import android.os.Bundle;

/* loaded from: classes28.dex */
public interface IThirdPushSupport {
    public static final int TYPE_DEFAULT = 1;
    public static final int TYPE_HUAWEI = 3;

    int getThirdPushType(Context context, Bundle bundle);
}
