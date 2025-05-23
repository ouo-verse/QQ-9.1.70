package cooperation.qzone.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes28.dex */
public interface IQZoneVideoApi extends QRouteApi {
    String getExperimentGrayId();

    String getExperimentId();

    boolean isHitQQVideoExperiment();
}
