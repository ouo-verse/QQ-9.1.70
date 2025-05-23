package cooperation.vip.ad;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mtt.hippy.HippyAPIProvider;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes28.dex */
public interface IQQVASGuideHippyApi extends QRouteApi {
    HippyAPIProvider getQQIvLiveHallHippyAPIProvider();

    boolean isVASGuideModule(String str);
}
