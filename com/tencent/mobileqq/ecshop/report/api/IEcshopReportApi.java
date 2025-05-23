package com.tencent.mobileqq.ecshop.report.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bg\u0018\u00002\u00020\u0001J8\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052&\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0007j\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005`\bH&J \u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH&\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/ecshop/report/api/IEcshopReportApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "doReportBeacon", "", "opName", "", "inputParams", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "reportSetTopOrCancleSetTop", "uinType", "", "uin", "isSetTop", "", "qqshop-feature-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes5.dex */
public interface IEcshopReportApi extends QRouteApi {
    void doReportBeacon(@NotNull String opName, @NotNull HashMap<String, String> inputParams);

    void reportSetTopOrCancleSetTop(int uinType, @NotNull String uin, boolean isSetTop);
}
