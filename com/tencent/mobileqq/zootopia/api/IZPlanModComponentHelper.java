package com.tencent.mobileqq.zootopia.api;

import com.tencent.ad.tangram.statistics.metric.AdMetricID;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import kotlin.Metadata;

@QRouteFactory(singleton = true)
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bg\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bH&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/zootopia/api/IZPlanModComponentHelper;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "silentDownloadModInZPlan", "", "isAfterPortalLoading", "", "forceDownload", "mapId", "", "zplan_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface IZPlanModComponentHelper extends QRouteApi {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public static final class a {
        public static /* synthetic */ void a(IZPlanModComponentHelper iZPlanModComponentHelper, boolean z16, boolean z17, int i3, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 4) != 0) {
                    i3 = AdMetricID.Click.SUCCESS;
                }
                iZPlanModComponentHelper.silentDownloadModInZPlan(z16, z17, i3);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: silentDownloadModInZPlan");
        }
    }

    void silentDownloadModInZPlan(boolean isAfterPortalLoading, boolean forceDownload, int mapId);
}
