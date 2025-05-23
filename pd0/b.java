package pd0;

import android.text.TextUtils;
import com.tencent.biz.qqstory.utils.i;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b {
    public static Long a() {
        String cityCode = ((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).getCityCode();
        if (TextUtils.isEmpty(cityCode)) {
            hd0.c.a("LocationUtils", "getCityCode() lbsInfo.location.cityCode is empty");
            return null;
        }
        try {
            long parseLong = Long.parseLong(cityCode);
            hd0.c.b("LocationUtils", "getCityCode() lbsInfo.location.cityCode is %d", Long.valueOf(parseLong));
            return Long.valueOf(parseLong);
        } catch (NumberFormatException e16) {
            hd0.c.g("LocationUtils", "getCityCode() cityCode is not number!");
            com.tencent.qqperf.monitor.crash.catchedexception.a.c(i.a("LocationUtils getCityCode() error", e16), "LocationUtils getCityCode() error");
            return null;
        }
    }
}
