package ob2;

import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a {
    public static void a(Promise promise, SosoLbsInfo sosoLbsInfo) {
        if (promise == null) {
            return;
        }
        HippyMap hippyMap = new HippyMap();
        hippyMap.pushInt("retCode", 0);
        HippyMap hippyMap2 = new HippyMap();
        hippyMap2.pushString("longitude", String.valueOf(sosoLbsInfo.mLocation.mLon02));
        hippyMap2.pushString("latitude", String.valueOf(sosoLbsInfo.mLocation.mLat02));
        hippyMap2.pushString("nation", String.valueOf(sosoLbsInfo.mLocation.nation));
        hippyMap2.pushString("province", String.valueOf(sosoLbsInfo.mLocation.province));
        hippyMap2.pushString("city", String.valueOf(sosoLbsInfo.mLocation.city));
        hippyMap2.pushString("district", String.valueOf(sosoLbsInfo.mLocation.district));
        hippyMap.pushObject("data", hippyMap2);
        promise.resolve(hippyMap);
        QLog.d("NearbyHippyCallback", 2, "rspToWebLBS: " + hippyMap.toJSONObject().toString());
    }
}
