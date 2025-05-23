package com.tencent.mobileqq.qqecommerce.biz.report.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\bg\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/report/api/IQQECDataReport;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "dataReport", "", "action", "", "params", "", "", "qqecommerce-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IQQECDataReport extends QRouteApi {
    void dataReport(@NotNull String action, @NotNull Map<Object, ? extends Object> params);
}
