package dt3;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.common.api.IAegisLogApi;

/* compiled from: P */
/* loaded from: classes22.dex */
public class g {
    public static String a(String str, Class cls) {
        IAegisLogApi iAegisLogApi = (IAegisLogApi) QRoute.api(IAegisLogApi.class);
        String name = cls.getPackage().getName();
        iAegisLogApi.i("PostProguardPkgNameUtil", str + ": getName name=" + name);
        return name;
    }
}
