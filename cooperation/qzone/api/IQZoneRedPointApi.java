package cooperation.qzone.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes28.dex */
public interface IQZoneRedPointApi extends QRouteApi {
    boolean canTogetherRefreshWithQQVideo(boolean z16);

    void refreshRedPoint();
}
