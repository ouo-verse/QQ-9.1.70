package com.tencent.mobileqq.leba.redtouch;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/leba/redtouch/ILebaRedTouchReportApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "reportLevelOneRedInfo", "", "appInfo", "Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;", AdMetricTag.Report.TYPE, "", "isInMoreFragment", "", "appid", "qqleba-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface ILebaRedTouchReportApi extends QRouteApi {
    void reportLevelOneRedInfo(int appid, int reportType, boolean isInMoreFragment);

    void reportLevelOneRedInfo(@NotNull BusinessInfoCheckUpdate.AppInfo appInfo, int reportType, boolean isInMoreFragment);
}
