package com.tencent.mobileqq.kandian.biz.common.api;

import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u001a\u0010\u0005\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u0003H&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/kandian/biz/common/api/IWeiShiReportUtil;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "reportEnter", "", "reportExit", "reportMsgExposure", "data", "Lcom/tencent/mobileqq/activity/recent/RecentBaseData;", "reportFrom", "", "reportWeiShiDelete", "kandian-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IWeiShiReportUtil extends QRouteApi {
    void reportEnter();

    void reportExit();

    void reportMsgExposure(@Nullable RecentBaseData data, int reportFrom);

    void reportWeiShiDelete();
}
