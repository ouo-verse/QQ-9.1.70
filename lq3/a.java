package lq3;

import com.tencent.mobileqq.msg.api.IFeatureSwitch;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a {
    public static boolean a() {
        return b("OpenSdk_featureAccountSelectDialog_864284595");
    }

    public static boolean b(String str) {
        return ((IFeatureSwitch) QRoute.api(IFeatureSwitch.class)).isFeatureSwitchEnable(str);
    }
}
